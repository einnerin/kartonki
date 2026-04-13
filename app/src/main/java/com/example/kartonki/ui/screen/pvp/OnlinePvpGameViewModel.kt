package com.example.kartonki.ui.screen.pvp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.remote.FirebaseAuthManager
import com.example.kartonki.data.remote.FirestoreUserRepository
import com.example.kartonki.data.remote.OnlineGameRepository
import com.example.kartonki.data.remote.model.OnlineMatchData
import com.example.kartonki.data.remote.model.OnlineRoundData
import com.example.kartonki.data.repository.CollectionRepository
import com.example.kartonki.domain.model.Word
import com.example.kartonki.ui.navigation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class OnlinePvpPhase {
    /** It's my turn to pick a card */
    data class MyHandSelection(val hand: List<Word>) : OnlinePvpPhase()
    /** Opponent is picking a card — I wait */
    object WaitingForOpponent : OnlinePvpPhase()
    /** Opponent picked, I need to answer */
    data class MyQuiz(
        val question: String,
        val questionLabel: String,
        val options: List<String>,
        val correctAnswer: String,
        val playedCardWord: String,
        val selectedAnswer: String? = null,
    ) : OnlinePvpPhase()
    /** I picked, opponent is answering — I wait */
    data class WaitingForAnswer(val question: String) : OnlinePvpPhase()
    /** Game over */
    data class GameOver(
        val myScore: Int,
        val opponentScore: Int,
        val myName: String,
        val opponentName: String,
        val winnerIndex: Int,
        val myIndex: Int,
    ) : OnlinePvpPhase()
}

data class OnlinePvpGameUiState(
    val isLoading: Boolean = true,
    val myIndex: Int = 0,
    val myName: String = "",
    val opponentName: String = "",
    val myScore: Int = 0,
    val opponentScore: Int = 0,
    val myStreak: Int = 0,
    val timeRemaining: Int = TIMER_DURATION,
    val phase: OnlinePvpPhase = OnlinePvpPhase.WaitingForOpponent,
    val connectionError: String? = null,
) {
    companion object { const val TIMER_DURATION = 30 }
}

@HiltViewModel
class OnlinePvpGameViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val collectionRepository: CollectionRepository,
    private val onlineGameRepository: OnlineGameRepository,
    private val authManager: FirebaseAuthManager,
    private val firestoreUserRepository: FirestoreUserRepository,
) : ViewModel() {

    private val matchId: String = checkNotNull(savedStateHandle[Route.OnlinePvpGame.ARG_MATCH_ID])
    private val myIndex: Int = checkNotNull(savedStateHandle[Route.OnlinePvpGame.ARG_MY_INDEX])

    private val _uiState = MutableStateFlow(OnlinePvpGameUiState(myIndex = myIndex))
    val uiState: StateFlow<OnlinePvpGameUiState> = _uiState.asStateFlow()

    private var allWords: List<Word> = emptyList()
    private var myCardIds: List<Long> = emptyList()
    private var timerJob: Job? = null
    private var lastPhase: String? = null

    init {
        loadWordsAndListen()
    }

    private fun loadWordsAndListen() {
        viewModelScope.launch {
            allWords = collectionRepository.getOwnedWords()
            listenToMatch()
        }
    }

    private fun listenToMatch() {
        viewModelScope.launch {
            onlineGameRepository.listenToMatch(matchId).collect { match ->
                if (match == null) {
                    _uiState.update { it.copy(connectionError = "Соединение потеряно") }
                    return@collect
                }
                processMatchState(match)
            }
        }
    }

    private fun processMatchState(match: OnlineMatchData) {
        val opponentIndex = 1 - myIndex
        val myName = if (myIndex == 0) match.player1Name else match.player2Name
        val opponentName = if (opponentIndex == 0) match.player1Name else match.player2Name
        val myScore = if (myIndex == 0) match.player1Score else match.player2Score
        val opponentScore = if (opponentIndex == 0) match.player1Score else match.player2Score
        val myStreak = if (myIndex == 0) match.player1Streak else match.player2Streak

        // Store my card IDs
        myCardIds = if (myIndex == 0) match.player1RemainingIds else match.player2RemainingIds

        when (match.phase) {
            OnlineMatchData.PHASE_GAME_OVER, OnlineMatchData.STATUS_FINISHED -> {
                stopTimer()
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        myName = myName,
                        opponentName = opponentName,
                        myScore = myScore,
                        opponentScore = opponentScore,
                        phase = OnlinePvpPhase.GameOver(
                            myScore = myScore,
                            opponentScore = opponentScore,
                            myName = myName,
                            opponentName = opponentName,
                            winnerIndex = match.winnerIndex,
                            myIndex = myIndex,
                        ),
                    )
                }
            }

            OnlineMatchData.PHASE_HAND_SELECTION -> {
                val isMyTurn = match.currentTurn == myIndex
                val newPhase = if (isMyTurn) {
                    val myWords = allWords.filter { it.id in myCardIds }
                    val hand = buildHand(myWords)
                    OnlinePvpPhase.MyHandSelection(hand)
                } else {
                    OnlinePvpPhase.WaitingForOpponent
                }
                val phaseKey = "hand_${match.currentTurn}"
                if (phaseKey != lastPhase) {
                    lastPhase = phaseKey
                    stopTimer()
                    startTimerFrom(match.roundStartTime)
                }
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        myName = myName,
                        opponentName = opponentName,
                        myScore = myScore,
                        opponentScore = opponentScore,
                        myStreak = myStreak,
                        phase = newPhase,
                    )
                }
            }

            OnlineMatchData.PHASE_QUIZ -> {
                val round = match.currentRound ?: return
                val defenderIndex = 1 - round.attackerIndex
                val isMyQuiz = defenderIndex == myIndex

                // Restart timer only on new round
                val phaseKey = "quiz_${round.playedCardId}_${round.attackerIndex}"
                if (phaseKey != lastPhase) {
                    lastPhase = phaseKey
                    stopTimer()
                    startTimerFrom(match.roundStartTime)
                }

                val newPhase = if (isMyQuiz) {
                    OnlinePvpPhase.MyQuiz(
                        question = round.question,
                        questionLabel = round.questionLabel,
                        options = round.options,
                        correctAnswer = round.correctAnswer,
                        playedCardWord = allWords.find { it.id == round.playedCardId }?.original ?: "",
                        selectedAnswer = round.selectedAnswer.takeIf { it.isNotEmpty() },
                    )
                } else {
                    OnlinePvpPhase.WaitingForAnswer(round.question)
                }
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        myName = myName,
                        opponentName = opponentName,
                        myScore = myScore,
                        opponentScore = opponentScore,
                        myStreak = myStreak,
                        phase = newPhase,
                    )
                }
            }
        }
    }

    fun onCardSelected(card: Word) {
        stopTimer()
        val quiz = buildQuiz(card) ?: return
        val newRemainingIds = myCardIds.filter { it != card.id }

        val round = OnlineRoundData(
            playedCardId = card.id,
            attackerIndex = myIndex,
            question = quiz.question,
            questionLabel = quiz.questionLabel,
            options = quiz.options,
            correctAnswer = quiz.correctAnswer,
            selectedAnswer = "",
        )
        viewModelScope.launch {
            onlineGameRepository.submitCardPick(
                matchId = matchId,
                attackerIndex = myIndex,
                round = round,
                newRemainingIds = newRemainingIds,
                playerIndex = myIndex,
            )
        }
    }

    fun onAnswerSelected(answer: String) {
        val phase = _uiState.value.phase as? OnlinePvpPhase.MyQuiz ?: return
        if (phase.selectedAnswer != null) return
        stopTimer()
        _uiState.update { it.copy(phase = phase.copy(selectedAnswer = answer)) }
        viewModelScope.launch {
            onlineGameRepository.submitAnswer(matchId, answer)
        }
    }

    fun onConfirmAnswer() {
        val state = _uiState.value
        val phase = state.phase as? OnlinePvpPhase.MyQuiz ?: return
        val selected = phase.selectedAnswer ?: return

        viewModelScope.launch {
            val match = onlineGameRepository.listenToMatch(matchId).let {
                // We need current match state — use last known from processMatchState
                null // handled via listenToMatch — we just update Firebase
            }

            val isCorrect = selected.equals(phase.correctAnswer, ignoreCase = true)
            val defenderIndex = myIndex  // I am the defender in MyQuiz phase
            val attackerIndex = 1 - myIndex

            val myStreak = if (isCorrect) state.myStreak + 1 else 0
            val multiplier = streakToMultiplier(myStreak)

            // Get card rarity points (default 1 if not found)
            val card = allWords.find { word ->
                (state.phase as? OnlinePvpPhase.MyQuiz)?.let { q ->
                    word.original == q.playedCardWord
                } ?: false
            }
            val points = if (isCorrect) (card?.rarity?.points ?: 1) * multiplier else 0

            // Determine scores based on who is who
            val currentMyScore = state.myScore + points
            val currentOpponentScore = state.opponentScore

            val p1Score: Int
            val p2Score: Int
            val p1Streak: Int
            val p2Streak: Int

            if (myIndex == 0) {
                p1Score = currentMyScore
                p2Score = currentOpponentScore
                p1Streak = myStreak
                p2Streak = state.myStreak // opponent's streak unchanged
            } else {
                p1Score = currentOpponentScore
                p2Score = currentMyScore
                p1Streak = state.myStreak // opponent's streak unchanged
                p2Streak = myStreak
            }

            // Check game over: look at remaining cards
            val myRemaining = myCardIds
            val opponentRemainingKey = if (myIndex == 0) "player2RemainingIds" else "player1RemainingIds"
            // We use current myCardIds (already updated when card was played by attacker)
            val nextAttacker = attackerIndex
            val nextPhase = if (myRemaining.isNotEmpty()) {
                OnlineMatchData.PHASE_HAND_SELECTION
            } else {
                OnlineMatchData.PHASE_GAME_OVER
            }

            val isGameOver = nextPhase == OnlineMatchData.PHASE_GAME_OVER
            val winnerIndex = when {
                !isGameOver -> -1
                p1Score > p2Score -> 0
                p2Score > p1Score -> 1
                else -> -1 // draw
            }

            onlineGameRepository.confirmAnswer(
                matchId = matchId,
                p1Score = p1Score,
                p2Score = p2Score,
                p1Streak = p1Streak,
                p2Streak = p2Streak,
                nextTurn = nextAttacker,
                nextPhase = nextPhase,
                isGameOver = isGameOver,
                winnerIndex = winnerIndex,
            )

            // Update Firestore stats on game over
            if (isGameOver) {
                val uid = authManager.currentUser.value?.uid ?: return@launch
                when {
                    winnerIndex == myIndex -> firestoreUserRepository.incrementWin(uid)
                    winnerIndex == -1 -> firestoreUserRepository.incrementDraw(uid)
                    else -> firestoreUserRepository.incrementLoss(uid)
                }
            }
        }
    }

    private fun startTimerFrom(startTime: Long) {
        timerJob?.cancel()
        val elapsed = ((System.currentTimeMillis() - startTime) / 1000).toInt().coerceIn(0, TIMER_DURATION)
        val remaining = TIMER_DURATION - elapsed
        if (remaining <= 0) return

        _uiState.update { it.copy(timeRemaining = remaining) }
        timerJob = viewModelScope.launch {
            for (i in remaining downTo 1) {
                delay(1000)
                _uiState.update { it.copy(timeRemaining = i - 1) }
            }
            handleTimerExpired()
        }
    }

    private fun stopTimer() {
        timerJob?.cancel()
        timerJob = null
    }

    private fun handleTimerExpired() {
        val phase = _uiState.value.phase
        when (phase) {
            is OnlinePvpPhase.MyHandSelection -> {
                // Auto-pick random card
                val card = phase.hand.randomOrNull() ?: return
                onCardSelected(card)
            }
            is OnlinePvpPhase.MyQuiz -> {
                // Auto-submit wrong answer
                val wrong = phase.options.firstOrNull { it != phase.correctAnswer } ?: return
                onAnswerSelected(wrong)
                viewModelScope.launch {
                    delay(800)
                    onConfirmAnswer()
                }
            }
            else -> {}
        }
    }

    private fun buildHand(cards: List<Word>): List<Word> =
        if (cards.size <= HAND_SIZE) cards.shuffled() else cards.shuffled().take(HAND_SIZE)

    private fun buildQuiz(word: Word): PvpQuiz? {
        val others = allWords.filter { it.id != word.id }
        if (others.size < 3) return null
        val wrongs = others.shuffled().take(3).map { it.translation }
        return PvpQuiz(
            playedCard = word,
            question = word.original,
            questionLabel = "Выберите перевод:",
            options = (wrongs + word.translation).shuffled(),
            correctAnswer = word.translation,
        )
    }

    private fun streakToMultiplier(streak: Int): Int = when {
        streak >= 15 -> 4
        streak >= 10 -> 3
        streak >= 5  -> 2
        else         -> 1
    }

    override fun onCleared() {
        super.onCleared()
        stopTimer()
    }

    companion object {
        const val HAND_SIZE = 10
        const val TIMER_DURATION = 30
    }
}
