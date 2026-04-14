package com.example.kartonki.ui.screen.pvp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.remote.FirebaseAuthManager
import com.example.kartonki.data.remote.FirestoreUserRepository
import com.example.kartonki.data.remote.OnlineGameRepository
import com.example.kartonki.data.remote.model.OnlineMatchData
import com.example.kartonki.data.remote.model.OnlineRoundData
import com.example.kartonki.data.repository.AchievementRepository
import com.example.kartonki.data.repository.CollectionRepository
import com.example.kartonki.data.repository.WordSetRepository
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
    data class MyHandSelection(val hand: List<Word>, val remainingDeck: List<Word>) : OnlinePvpPhase()
    /** Opponent is picking a card — I wait */
    object WaitingForOpponent : OnlinePvpPhase()
    /** Opponent picked, I need to answer */
    data class MyQuiz(
        val question: String,
        val questionLabel: String,
        val options: List<String>,
        val correctAnswer: String,
        val playedCardWord: String,
        val playedCardTranslation: String,
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
    val opponentStreak: Int = 0,
    val timeRemaining: Int = PvpGameLogic.TIMER_DURATION,
    val phase: OnlinePvpPhase = OnlinePvpPhase.WaitingForOpponent,
    val connectionError: String? = null,
    val showSurrenderDialog: Boolean = false,
)

private const val DISCONNECT_TIMEOUT_MS = 15_000L

@HiltViewModel
class OnlinePvpGameViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val wordSetRepository: WordSetRepository,
    private val collectionRepository: CollectionRepository,
    private val onlineGameRepository: OnlineGameRepository,
    private val authManager: FirebaseAuthManager,
    private val firestoreUserRepository: FirestoreUserRepository,
    private val achievementRepository: AchievementRepository,
) : ViewModel() {

    private val matchId: String = checkNotNull(savedStateHandle[Route.OnlinePvpGame.ARG_MATCH_ID])
    private val myIndex: Int = checkNotNull(savedStateHandle[Route.OnlinePvpGame.ARG_MY_INDEX])

    private val _uiState = MutableStateFlow(OnlinePvpGameUiState(myIndex = myIndex))
    val uiState: StateFlow<OnlinePvpGameUiState> = _uiState.asStateFlow()

    private var allWords: List<Word> = emptyList()
    private var myCardIds: List<Long> = emptyList()
    private var opponentCardIds: List<Long> = emptyList()
    private var opponentStreak: Int = 0
    private var timerJob: Job? = null
    private var disconnectTimerJob: Job? = null
    private var lastPhase: String? = null
    private var gameOverRecorded = false
    private var didSurrender = false

    init {
        loadWordsAndListen()
    }

    private fun loadWordsAndListen() {
        viewModelScope.launch {
            // allWords is used as distractor pool for quiz generation.
            // Deck words are resolved per-round from myCardIds directly,
            // so all deck cards are available regardless of collection status.
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

    private suspend fun processMatchState(match: OnlineMatchData) {
        val opponentIndex = 1 - myIndex
        val myName = if (myIndex == 0) match.player1Name else match.player2Name
        val opponentName = if (opponentIndex == 0) match.player1Name else match.player2Name
        val myScore = if (myIndex == 0) match.player1Score else match.player2Score
        val opponentScore = if (opponentIndex == 0) match.player1Score else match.player2Score
        val myStreak = if (myIndex == 0) match.player1Streak else match.player2Streak

        // Store card IDs for both players
        myCardIds = if (myIndex == 0) match.player1RemainingIds else match.player2RemainingIds
        opponentCardIds = if (myIndex == 0) match.player2RemainingIds else match.player1RemainingIds
        opponentStreak = if (myIndex == 0) match.player2Streak else match.player1Streak

        // Auto-forfeit: if the opponent has been gone for 15 s we award the win here
        if (!gameOverRecorded) checkOpponentDisconnect(match)

        when (match.phase) {
            OnlineMatchData.PHASE_GAME_OVER, OnlineMatchData.STATUS_FINISHED -> {
                stopTimer()
                if (!gameOverRecorded) {
                    gameOverRecorded = true
                    val p1Name = match.player1Name
                    val p2Name = match.player2Name
                    val p1Score = match.player1Score
                    val p2Score = match.player2Score
                    viewModelScope.launch {
                        achievementRepository.recordPvpMatch(
                            player1Name  = p1Name,
                            player2Name  = p2Name,
                            player1Score = p1Score,
                            player2Score = p2Score,
                            wasSurrender = didSurrender,
                        )
                    }
                }
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
                    val myWords = wordSetRepository.getWordsByIds(myCardIds)
                    val hand = buildHand(myWords)
                    val handIds = hand.map { it.id }.toSet()
                    val remainingDeck = myWords.filter { it.id !in handIds }
                        .sortedByDescending { it.rarity.points }
                    OnlinePvpPhase.MyHandSelection(hand, remainingDeck)
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
                        opponentStreak = opponentStreak,
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
                        playedCardWord = round.playedCardOriginal,
                        playedCardTranslation = round.playedCardTranslation,
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
                        opponentStreak = opponentStreak,
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
            playedCardOriginal = card.original,
            playedCardTranslation = card.translation,
        )
        viewModelScope.launch {
            try {
                onlineGameRepository.submitCardPick(
                    matchId = matchId,
                    attackerIndex = myIndex,
                    round = round,
                    newRemainingIds = newRemainingIds,
                    playerIndex = myIndex,
                )
            } catch (e: Exception) {
                _uiState.update { it.copy(connectionError = "Ошибка отправки хода: ${e.message}") }
            }
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
            val isCorrect = selected.equals(phase.correctAnswer, ignoreCase = true)

            // I am the defender. Turns ALTERNATE: defender becomes next attacker.
            val newMyStreak = if (isCorrect) state.myStreak + 1 else 0
            val multiplier = streakToMultiplier(newMyStreak)

            val card = allWords.find { it.original == phase.playedCardWord }
            val points = if (isCorrect) (card?.rarity?.points ?: 1) * multiplier else 0

            val newMyScore = state.myScore + points

            // Map my/opponent scores to player1/player2 slots
            val p1Score: Int
            val p2Score: Int
            val p1Streak: Int
            val p2Streak: Int
            if (myIndex == 0) {
                // I am Player 1 (defender), opponent is Player 2 (attacker)
                p1Score = newMyScore
                p2Score = state.opponentScore
                p1Streak = newMyStreak
                p2Streak = opponentStreak  // attacker's streak unchanged
            } else {
                // I am Player 2 (defender), opponent is Player 1 (attacker)
                p1Score = state.opponentScore
                p2Score = newMyScore
                p1Streak = opponentStreak  // attacker's streak unchanged
                p2Streak = newMyStreak
            }

            // Defender becomes next attacker if they have cards;
            // if not but opponent still has cards, opponent continues; otherwise game over.
            val opponentIdx = 1 - myIndex
            val nextAttacker: Int
            val nextPhase: String
            when {
                myCardIds.isNotEmpty() -> {
                    nextAttacker = myIndex
                    nextPhase = OnlineMatchData.PHASE_HAND_SELECTION
                }
                opponentCardIds.isNotEmpty() -> {
                    nextAttacker = opponentIdx
                    nextPhase = OnlineMatchData.PHASE_HAND_SELECTION
                }
                else -> {
                    nextAttacker = myIndex
                    nextPhase = OnlineMatchData.PHASE_GAME_OVER
                }
            }

            val isGameOver = nextPhase == OnlineMatchData.PHASE_GAME_OVER
            val winnerIndex = when {
                !isGameOver -> -1
                p1Score > p2Score -> 0
                p2Score > p1Score -> 1
                else -> -1
            }

            // Game-critical write to Realtime Database
            try {
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
            } catch (e: Exception) {
                _uiState.update { it.copy(connectionError = "Ошибка подтверждения ответа: ${e.message}") }
                return@launch
            }

            // Stats update is best-effort — Firestore errors must not break the game
            if (isGameOver) {
                try {
                    val uid = authManager.currentUser.value?.uid ?: return@launch
                    when {
                        winnerIndex == myIndex -> firestoreUserRepository.incrementWin(uid)
                        winnerIndex == -1 -> firestoreUserRepository.incrementDraw(uid)
                        else -> firestoreUserRepository.incrementLoss(uid)
                    }
                } catch (_: Exception) { /* ignore */ }
            }
        }
    }

    fun onSurrenderClick() = _uiState.update { it.copy(showSurrenderDialog = true) }
    fun onSurrenderDismiss() = _uiState.update { it.copy(showSurrenderDialog = false) }

    fun surrender() {
        didSurrender = true
        val state = _uiState.value
        val opponentIndex = 1 - myIndex
        val p1Score = if (myIndex == 0) state.myScore else state.opponentScore
        val p2Score = if (myIndex == 0) state.opponentScore else state.myScore
        viewModelScope.launch {
            try {
                onlineGameRepository.confirmAnswer(
                    matchId = matchId,
                    p1Score = p1Score,
                    p2Score = p2Score,
                    p1Streak = 0,
                    p2Streak = 0,
                    nextTurn = 0,
                    nextPhase = OnlineMatchData.PHASE_GAME_OVER,
                    isGameOver = true,
                    winnerIndex = opponentIndex,
                )
            } catch (e: Exception) {
                _uiState.update { it.copy(connectionError = "Ошибка сдачи: ${e.message}") }
                return@launch
            }
            // Stats update is best-effort — Firestore errors must not break the game
            try {
                val uid = authManager.currentUser.value?.uid ?: return@launch
                firestoreUserRepository.incrementLoss(uid)
            } catch (_: Exception) { /* ignore */ }
        }
    }

    // ── App background / foreground ──────────────────────────────────────────────

    /** Called by the screen when the app goes to background (onStop). */
    fun onAppBackground() {
        if (gameOverRecorded) return
        viewModelScope.launch {
            try { onlineGameRepository.reportDisconnect(matchId, myIndex, System.currentTimeMillis()) }
            catch (_: Exception) { }
        }
    }

    /** Called by the screen when the app comes back to foreground (onStart). */
    fun onAppForeground() {
        if (gameOverRecorded) return
        viewModelScope.launch {
            try { onlineGameRepository.clearDisconnect(matchId, myIndex) }
            catch (_: Exception) { }
        }
    }

    // ── Opponent disconnect timer ─────────────────────────────────────────────

    private fun checkOpponentDisconnect(match: OnlineMatchData) {
        val disconnectedAt = if (myIndex == 0) match.player2DisconnectedAt else match.player1DisconnectedAt
        if (disconnectedAt <= 0L) {
            // Opponent is back — cancel any pending disconnect timer
            disconnectTimerJob?.cancel()
            disconnectTimerJob = null
            return
        }
        val elapsed = System.currentTimeMillis() - disconnectedAt
        if (elapsed >= DISCONNECT_TIMEOUT_MS) {
            awardWinByDisconnect()
        } else if (disconnectTimerJob?.isActive != true) {
            // Start countdown for the remaining time
            disconnectTimerJob = viewModelScope.launch {
                delay(DISCONNECT_TIMEOUT_MS - elapsed)
                awardWinByDisconnect()
            }
        }
    }

    private fun awardWinByDisconnect() {
        if (gameOverRecorded) return
        gameOverRecorded = true
        disconnectTimerJob?.cancel()
        val state = _uiState.value
        val p1Score = if (myIndex == 0) state.myScore else state.opponentScore
        val p2Score = if (myIndex == 0) state.opponentScore else state.myScore
        viewModelScope.launch {
            try {
                onlineGameRepository.confirmAnswer(
                    matchId = matchId,
                    p1Score = p1Score,
                    p2Score = p2Score,
                    p1Streak = 0,
                    p2Streak = 0,
                    nextTurn = 0,
                    nextPhase = OnlineMatchData.PHASE_GAME_OVER,
                    isGameOver = true,
                    winnerIndex = myIndex,
                )
                try {
                    val uid = authManager.currentUser.value?.uid ?: return@launch
                    firestoreUserRepository.incrementWin(uid)
                } catch (_: Exception) { }
            } catch (e: Exception) {
                _uiState.update { it.copy(connectionError = "Ошибка: ${e.message}") }
            }
        }
    }

    private fun startTimerFrom(startTime: Long) {
        timerJob?.cancel()
        val elapsed = ((System.currentTimeMillis() - startTime) / 1000).toInt().coerceIn(0, PvpGameLogic.TIMER_DURATION)
        val remaining = PvpGameLogic.TIMER_DURATION - elapsed
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

    private fun buildHand(cards: List<Word>) = PvpGameLogic.buildHand(cards)
    private fun buildQuiz(word: Word): PvpQuiz? = PvpGameLogic.buildQuiz(word, allWords)
    private fun streakToMultiplier(streak: Int) = PvpGameLogic.streakToMultiplier(streak)

    override fun onCleared() {
        super.onCleared()
        stopTimer()
        disconnectTimerJob?.cancel()
        // Fire-and-forget: clear our disconnect flag so we don't leave stale data in Firebase
        onlineGameRepository.clearDisconnectSync(matchId, myIndex)
    }
}
