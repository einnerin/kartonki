package com.example.kartonki.ui.screen.pvp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.db.dao.DeckDao
import com.example.kartonki.data.db.entity.ProgressEntity
import com.example.kartonki.data.preferences.UserPreferencesRepository
import com.example.kartonki.data.repository.AchievementRepository
import com.example.kartonki.data.repository.CollectionRepository
import com.example.kartonki.data.repository.PackRepository
import com.example.kartonki.data.repository.ProgressRepository
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

data class PvpPlayerState(
    val name: String,
    val remainingCards: List<Word>,
    val score: Int = 0,
    val streak: Int = 0,
    val multiplier: Int = 1,
    val afkStreak: Int = 0,
)

data class PvpQuiz(
    val playedCard: Word,
    val question: String,
    val questionLabel: String,
    val options: List<String>,
    val correctAnswer: String,
)

sealed class PvpPhase {
    data class HandSelection(val hand: List<Word>) : PvpPhase()
    data class Quiz(
        val quiz: PvpQuiz,
        val defenderName: String,
        val defenderIndex: Int,
        val selectedAnswer: String? = null,
    ) : PvpPhase()
    data class GameOver(
        val loserIndex: Int? = null,
        val reason: GameOverReason = GameOverReason.NORMAL,
    ) : PvpPhase()
}

enum class GameOverReason { NORMAL, FORFEIT, AFK }

data class PvpGameUiState(
    val isLoading: Boolean = true,
    val players: List<PvpPlayerState> = emptyList(),
    val currentPlayerIndex: Int = 0,
    val phase: PvpPhase = PvpPhase.GameOver(),
    val timeRemaining: Int = TIMER_DURATION,
    val showMultiplierHint: Boolean = false,
) {
    val activePlayer: PvpPlayerState? get() = players.getOrNull(currentPlayerIndex)

    companion object {
        const val TIMER_DURATION = 30
    }
}

@HiltViewModel
class PvpGameViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val deckDao: DeckDao,
    private val collectionRepository: CollectionRepository,
    private val achievementRepository: AchievementRepository,
    private val progressRepository: ProgressRepository,
    private val packRepository: PackRepository,
    private val prefs: UserPreferencesRepository,
) : ViewModel() {

    private val deck1Id: Long = checkNotNull(savedStateHandle[Route.PvpGame.ARG_DECK1_ID])
    private val deck2Id: Long = checkNotNull(savedStateHandle[Route.PvpGame.ARG_DECK2_ID])
    private val p1Name: String = savedStateHandle[Route.PvpGame.ARG_P1_NAME] ?: "Игрок 1"
    private val p2Name: String = savedStateHandle[Route.PvpGame.ARG_P2_NAME] ?: "Игрок 2"

    private val _uiState = MutableStateFlow(PvpGameUiState())
    val uiState: StateFlow<PvpGameUiState> = _uiState.asStateFlow()

    private var allWords: List<Word> = emptyList()
    private var attackerIndex: Int = 0
    private var timerJob: Job? = null

    init {
        loadGame()
        if (!prefs.getPvpMultiplierHintSeen()) {
            _uiState.update { it.copy(showMultiplierHint = true) }
        }
    }

    fun dismissMultiplierHint() {
        prefs.setPvpMultiplierHintSeen()
        _uiState.update { it.copy(showMultiplierHint = false) }
    }

    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel()
    }

    private fun loadGame() {
        viewModelScope.launch {
            allWords = collectionRepository.getOwnedWords()
            val deck1Words = wordsForDeck(deck1Id)
            val deck2Words = wordsForDeck(deck2Id)

            val players = listOf(
                PvpPlayerState(p1Name, deck1Words.shuffled()),
                PvpPlayerState(p2Name, deck2Words.shuffled()),
            )

            if (players.all { it.remainingCards.isEmpty() }) {
                _uiState.update { it.copy(isLoading = false, players = players, phase = PvpPhase.GameOver()) }
                return@launch
            }

            val startIndex = if (players[0].remainingCards.isNotEmpty()) 0 else 1
            _uiState.update {
                it.copy(
                    isLoading = false,
                    players = players,
                    currentPlayerIndex = startIndex,
                    phase = PvpPhase.HandSelection(buildHand(players[startIndex].remainingCards)),
                )
            }
            startTimer()
        }
    }

    /** Attacker picks a card — resets their AFK streak, starts the quiz. */
    fun onCardSelected(card: Word) {
        stopTimer()
        val state = _uiState.value
        attackerIndex = state.currentPlayerIndex
        val defenderIdx = 1 - attackerIndex

        val updatedPlayers = state.players.mapIndexed { i, p ->
            if (i == attackerIndex) p.copy(
                remainingCards = p.remainingCards.filter { it.id != card.id },
                afkStreak = 0,
            ) else p
        }
        val quiz = buildQuiz(card) ?: return
        _uiState.update {
            it.copy(
                players = updatedPlayers,
                phase = PvpPhase.Quiz(quiz, state.players[defenderIdx].name, defenderIdx),
            )
        }
        startTimer()
    }

    /** Defender taps an option — resets their AFK streak, highlights answer. */
    fun onAnswerSelected(answer: String) {
        val quizPhase = _uiState.value.phase as? PvpPhase.Quiz ?: return
        if (quizPhase.selectedAnswer != null) return
        stopTimer()
        val defenderIdx = quizPhase.defenderIndex
        _uiState.update { state ->
            state.copy(
                players = state.players.mapIndexed { i, p ->
                    if (i == defenderIdx) p.copy(afkStreak = 0) else p
                },
                phase = quizPhase.copy(selectedAnswer = answer),
            )
        }
    }

    /** Defender confirms — awards points, advances to next turn. */
    fun onConfirmAnswer() {
        val state = _uiState.value
        val quizPhase = state.phase as? PvpPhase.Quiz ?: return
        val selected = quizPhase.selectedAnswer ?: return

        val card = quizPhase.quiz.playedCard
        val isCorrect = selected.equals(quizPhase.quiz.correctAnswer, ignoreCase = true)
        val defenderIdx = quizPhase.defenderIndex
        val defender = state.players[defenderIdx]
        val newStreak = if (isCorrect) defender.streak + 1 else 0
        val newMultiplier = streakToMultiplier(newStreak)
        val points = if (isCorrect) card.rarity.points * newMultiplier else 0

        viewModelScope.launch {
            val existing = progressRepository.getProgress(card.id) ?: ProgressEntity(wordId = card.id)
            progressRepository.upsert(
                existing.copy(
                    correctCount      = if (isCorrect) existing.correctCount + 1 else existing.correctCount,
                    incorrectCount    = if (!isCorrect) existing.incorrectCount + 1 else existing.incorrectCount,
                    pvpCorrectCount   = if (isCorrect) existing.pvpCorrectCount + 1 else existing.pvpCorrectCount,
                    pvpIncorrectCount = if (!isCorrect) existing.pvpIncorrectCount + 1 else existing.pvpIncorrectCount,
                )
            )
        }

        val updatedPlayers = state.players.mapIndexed { i, p ->
            if (i == defenderIdx) p.copy(score = p.score + points, streak = newStreak, multiplier = newMultiplier)
            else p
        }

        val nextAttackerIdx = 1 - attackerIndex
        val nextAttacker = updatedPlayers[nextAttackerIdx]
        val currentAttacker = updatedPlayers[attackerIndex]

        val (nextPhase, nextIndex) = when {
            nextAttacker.remainingCards.isNotEmpty() ->
                PvpPhase.HandSelection(buildHand(nextAttacker.remainingCards)) to nextAttackerIdx
            currentAttacker.remainingCards.isNotEmpty() ->
                PvpPhase.HandSelection(buildHand(currentAttacker.remainingCards)) to attackerIndex
            else ->
                PvpPhase.GameOver() to attackerIndex
        }

        if (nextPhase is PvpPhase.GameOver) {
            triggerGameOver(updatedPlayers, loserIndex = null, reason = GameOverReason.NORMAL)
        } else {
            _uiState.update {
                it.copy(players = updatedPlayers, currentPlayerIndex = nextIndex, phase = nextPhase)
            }
            startTimer()
        }
    }

    /** Current player voluntarily surrenders. */
    fun onSurrender(playerIndex: Int) {
        stopTimer()
        triggerGameOver(_uiState.value.players, loserIndex = playerIndex, reason = GameOverReason.FORFEIT)
    }

    // ─── Timer ────────────────────────────────────────────────────────────────

    private fun startTimer() {
        timerJob?.cancel()
        _uiState.update { it.copy(timeRemaining = TIMER_DURATION) }
        timerJob = viewModelScope.launch {
            for (i in TIMER_DURATION downTo 1) {
                delay(1000)
                _uiState.update { it.copy(timeRemaining = i - 1) }
                if (i == 1) handleTimerExpired()
            }
        }
    }

    private fun stopTimer() {
        timerJob?.cancel()
        timerJob = null
    }

    private fun handleTimerExpired() {
        val state = _uiState.value
        when (val phase = state.phase) {
            is PvpPhase.HandSelection -> {
                val attackerIdx = state.currentPlayerIndex
                val newAfkStreak = state.players[attackerIdx].afkStreak + 1
                val updatedPlayers = state.players.mapIndexed { i, p ->
                    if (i == attackerIdx) p.copy(afkStreak = newAfkStreak) else p
                }
                if (newAfkStreak >= AFK_LIMIT) {
                    triggerGameOver(updatedPlayers, loserIndex = attackerIdx, reason = GameOverReason.AFK)
                } else {
                    // Auto-pick random card without resetting afkStreak
                    val card = phase.hand.random()
                    val defenderIdx = 1 - attackerIdx
                    attackerIndex = attackerIdx
                    val playersAfterPick = updatedPlayers.mapIndexed { i, p ->
                        if (i == attackerIdx) p.copy(remainingCards = p.remainingCards.filter { it.id != card.id })
                        else p
                    }
                    val quiz = buildQuiz(card) ?: return
                    _uiState.update {
                        it.copy(
                            players = playersAfterPick,
                            phase = PvpPhase.Quiz(quiz, state.players[defenderIdx].name, defenderIdx),
                        )
                    }
                    startTimer()
                }
            }
            is PvpPhase.Quiz -> {
                if (phase.selectedAnswer == null) {
                    val defenderIdx = phase.defenderIndex
                    val newAfkStreak = state.players[defenderIdx].afkStreak + 1
                    val updatedPlayers = state.players.mapIndexed { i, p ->
                        if (i == defenderIdx) p.copy(afkStreak = newAfkStreak) else p
                    }
                    if (newAfkStreak >= AFK_LIMIT) {
                        triggerGameOver(updatedPlayers, loserIndex = defenderIdx, reason = GameOverReason.AFK)
                    } else {
                        // Show wrong answer briefly, then auto-confirm
                        val wrong = phase.quiz.options.first { it != phase.quiz.correctAnswer }
                        _uiState.update {
                            it.copy(
                                players = updatedPlayers,
                                phase = phase.copy(selectedAnswer = wrong),
                            )
                        }
                        viewModelScope.launch {
                            delay(800)
                            onConfirmAnswer()
                        }
                    }
                }
            }
            else -> {}
        }
    }

    // ─── Game over ────────────────────────────────────────────────────────────

    private fun triggerGameOver(players: List<PvpPlayerState>, loserIndex: Int?, reason: GameOverReason) {
        viewModelScope.launch {
            achievementRepository.recordPvpMatch(
                player1Name  = players[0].name,
                player2Name  = players[1].name,
                player1Score = players[0].score,
                player2Score = players[1].score,
            )
            packRepository.checkAndGrantEarnedCards()
            packRepository.onActivityCompleted()
        }
        _uiState.update {
            it.copy(players = players, phase = PvpPhase.GameOver(loserIndex = loserIndex, reason = reason))
        }
    }

    // ─── Helpers ──────────────────────────────────────────────────────────────

    private suspend fun wordsForDeck(deckId: Long): List<Word> {
        val ids = deckDao.getWordIdsForDeck(deckId).toSet()
        return allWords.filter { it.id in ids }
    }

    private fun buildHand(cards: List<Word>): List<Word> =
        if (cards.size <= HAND_SIZE) cards.shuffled() else cards.shuffled().take(HAND_SIZE)

    private fun pickDistractors(word: Word): List<Word> {
        val candidates = allWords.filter { it.id != word.id }
        if (word.pos == null && word.semanticGroup == null) return candidates.shuffled()
        val tier1 = candidates.filter { it.pos == word.pos && it.semanticGroup == word.semanticGroup }.shuffled()
        val tier2 = candidates.filter { it.pos == word.pos && it.semanticGroup != word.semanticGroup }.shuffled()
        val tier3 = candidates.filter { it.pos != word.pos }.shuffled()
        return tier1 + tier2 + tier3
    }

    private fun buildQuiz(word: Word): PvpQuiz? {
        val others = pickDistractors(word)
        if (others.size < 3) return null

        val candidates = buildList {
            add("translation")
            if (word.definition != null && others.count { it.definition != null } >= 3) add("definition")
            if (word.example != null) add("fill_blank")
        }

        return when (candidates.random()) {
            "definition" -> {
                val wrongs = others.filter { it.definition != null }.take(3).map { it.definition!! }
                if (wrongs.size < 3) return translationQuiz(word, others)
                PvpQuiz(
                    playedCard = word,
                    question = word.original,
                    questionLabel = "Выберите определение:",
                    options = (wrongs + word.definition!!).shuffled(),
                    correctAnswer = word.definition!!,
                )
            }
            "fill_blank" -> {
                val sentence = word.example!!.replace(word.original, "_____", ignoreCase = true)
                val wrongs = others.take(3).map { it.original }
                PvpQuiz(
                    playedCard = word,
                    question = sentence,
                    questionLabel = "Выберите слово для пропуска:",
                    options = (wrongs + word.original).shuffled(),
                    correctAnswer = word.original,
                )
            }
            else -> translationQuiz(word, others)
        }
    }

    private fun translationQuiz(word: Word, others: List<Word>): PvpQuiz {
        val wrongs = others.take(3).map { it.translation }
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

    companion object {
        const val HAND_SIZE = 10
        const val TIMER_DURATION = 30
        const val AFK_LIMIT = 3
    }
}
