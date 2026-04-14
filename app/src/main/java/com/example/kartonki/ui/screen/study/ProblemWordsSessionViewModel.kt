package com.example.kartonki.ui.screen.study

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.db.entity.ProgressEntity
import com.example.kartonki.data.preferences.UserPreferencesRepository
import com.example.kartonki.data.repository.AchievementRepository
import com.example.kartonki.data.repository.PackRepository
import com.example.kartonki.data.repository.ProgressRepository
import com.example.kartonki.data.repository.StatsRepository
import com.example.kartonki.domain.model.StudyStep
import com.example.kartonki.domain.model.Word
import com.example.kartonki.domain.quiz.QuizBuilder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ProblemSessionUiState(
    val isLoading: Boolean = true,
    val isEmpty: Boolean = false,
    val isDisabled: Boolean = false,
    val steps: List<StudyStep> = emptyList(),
    val currentStepIndex: Int = 0,
    val correctCount: Int = 0,
    val incorrectCount: Int = 0,
    val isSessionComplete: Boolean = false,
    val answerState: AnswerState = AnswerState.Unanswered,
    val improvedCount: Int = 0,
    val learnedCount: Int = 0,
    val wordsStudied: Int = 0,
    val showSettingsHint: Boolean = false,
) {
    val currentStep: StudyStep? get() = steps.getOrNull(currentStepIndex)
    val progress: Float get() = if (steps.isEmpty()) 0f else currentStepIndex.toFloat() / steps.size
    val totalSteps: Int get() = steps.size
}

@HiltViewModel
class ProblemWordsSessionViewModel @Inject constructor(
    private val statsRepository: StatsRepository,
    private val progressRepository: ProgressRepository,
    private val achievementRepository: AchievementRepository,
    private val packRepository: PackRepository,
    private val prefs: UserPreferencesRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProblemSessionUiState())
    val uiState: StateFlow<ProblemSessionUiState> = _uiState.asStateFlow()

    // Snapshot of error rates before the session, for improvement comparison
    private var beforeErrorRates: Map<Long, Float> = emptyMap()
    // Track per-word session results (wordId → correct/incorrect during this session)
    private val sessionCorrect: MutableMap<Long, Int> = mutableMapOf()
    private val sessionIncorrect: MutableMap<Long, Int> = mutableMapOf()

    // Setting: how many correct answers in problem sessions total = mastered
    private var correctToLearn: Int = 1

    init {
        loadSession()
    }

    fun loadSession() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true,
                    isSessionComplete = false,
                    correctCount = 0,
                    incorrectCount = 0,
                    answerState = AnswerState.Unanswered,
                    learnedCount = 0,
                    showSettingsHint = false,
                )
            }
            sessionCorrect.clear()
            sessionIncorrect.clear()

            val enabled = prefs.problemWordsEnabled.first()
            if (!enabled) {
                _uiState.update { it.copy(isLoading = false, isDisabled = true, isEmpty = false) }
                return@launch
            }

            val source = prefs.problemWordsSource.first()
            val minEncounters = prefs.problemWordsMinEncounters.first()
            correctToLearn = prefs.problemWordsCorrectToLearn.first()

            val excludedIds = prefs.getSessionExcludedWordIds()
            prefs.clearSessionExcludedWordIds()
            val allWords = statsRepository.getProblemWords(source, minEncounters, limit = 200)
            val words = if (excludedIds.isEmpty()) allWords
                        else allWords.filter { it.id !in excludedIds }
            if (words.isEmpty()) {
                _uiState.update { it.copy(isLoading = false, isEmpty = true, isDisabled = false) }
                return@launch
            }

            // Snapshot before-state error rates
            beforeErrorRates = buildBeforeSnapshot(words)

            val definitionMode = prefs.definitionQuizMode.first()
            val fillBlankMode  = prefs.fillBlankQuizMode.first()
            val enabledTypes   = prefs.quizTypesEnabled.first()
            val steps = QuizBuilder.buildSteps(words, emptyList(), definitionMode, fillBlankMode, enabledTypes)
            _uiState.update {
                it.copy(
                    isLoading = false,
                    isEmpty = false,
                    isDisabled = false,
                    steps = steps,
                    currentStepIndex = 0,
                    wordsStudied = words.size,
                )
            }
        }
    }

    fun onIntroductionContinue() = advanceStep()

    fun onMultipleChoiceAnswer(selected: String) {
        val step = _uiState.value.currentStep as? StudyStep.Quiz ?: return
        if (_uiState.value.answerState != AnswerState.Unanswered) return
        val isCorrect = selected.equals(step.correctAnswer, ignoreCase = true)
        recordAnswer(step, isCorrect, selected)
    }

    fun onAnsweredContinue() {
        _uiState.update { it.copy(answerState = AnswerState.Unanswered) }
        advanceStep()
    }

    private fun recordAnswer(step: StudyStep.Quiz, isCorrect: Boolean, selected: String) {
        val wordId = step.word.id
        if (isCorrect) sessionCorrect[wordId] = (sessionCorrect[wordId] ?: 0) + 1
        else sessionIncorrect[wordId] = (sessionIncorrect[wordId] ?: 0) + 1

        _uiState.update {
            it.copy(
                answerState = AnswerState.Answered(isCorrect, step.correctAnswer, selected),
                correctCount   = if (isCorrect) it.correctCount + 1 else it.correctCount,
                incorrectCount = if (!isCorrect) it.incorrectCount + 1 else it.incorrectCount,
            )
        }
        saveProgress(step.word, isCorrect)
    }

    private fun advanceStep() {
        val next = _uiState.value.currentStepIndex + 1
        if (next >= _uiState.value.steps.size) {
            val incorrectCount = _uiState.value.incorrectCount
            viewModelScope.launch {
                val improved = computeImprovedCount()
                val learned  = applyMasteryAndCount()
                val showHint = !prefs.isProblemWordsHintShown()
                if (showHint) prefs.setProblemWordsHintShown()
                _uiState.update {
                    it.copy(
                        isSessionComplete = true,
                        improvedCount = improved,
                        learnedCount  = learned,
                        showSettingsHint = showHint,
                    )
                }
                achievementRepository.recordStudyDay(incorrectCount)
                packRepository.onActivityCompleted()
            }
        } else {
            _uiState.update { it.copy(currentStepIndex = next) }
        }
    }

    /**
     * Accumulates correct problem-session counts across sessions.
     * Returns the number of words that newly reached the mastery threshold.
     */
    private suspend fun applyMasteryAndCount(): Int {
        val storedCounts = prefs.getProblemSessionCounts().toMutableMap()
        var masteredThisSession = 0

        for ((wordId, correctInSession) in sessionCorrect) {
            val newTotal = (storedCounts[wordId] ?: 0) + correctInSession
            if (newTotal >= correctToLearn) {
                // Word is mastered — clear its error rate and reset its counter
                masterWord(wordId)
                storedCounts.remove(wordId)
                masteredThisSession++
            } else {
                storedCounts[wordId] = newTotal
            }
        }

        prefs.setProblemSessionCounts(storedCounts)
        return masteredThisSession
    }

    /**
     * Marks a word as mastered by resetting its incorrectCount to 0,
     * which clears its error rate and removes it from the problem words list.
     */
    private suspend fun masterWord(wordId: Long) {
        val existing = progressRepository.getProgress(wordId) ?: return
        progressRepository.upsert(
            existing.copy(
                incorrectCount = 0,
                level          = StudyConstants.MAX_LEVEL,
                nextReviewAt   = System.currentTimeMillis() + StudyConstants.LEVEL_INTERVALS_DAYS[StudyConstants.MAX_LEVEL] * 24L * 60 * 60 * 1000,
            )
        )
    }

    private fun saveProgress(word: Word, isCorrect: Boolean) {
        viewModelScope.launch {
            val existing = progressRepository.getProgress(word.id)
                ?: ProgressEntity(wordId = word.id)
            val newLevel = if (isCorrect) minOf(existing.level + 1, StudyConstants.MAX_LEVEL)
                           else maxOf(existing.level - 1, 0)
            val intervalMs = StudyConstants.LEVEL_INTERVALS_DAYS[newLevel] * 24L * 60 * 60 * 1000
            progressRepository.upsert(
                existing.copy(
                    correctCount   = if (isCorrect) existing.correctCount + 1 else existing.correctCount,
                    incorrectCount = if (!isCorrect) existing.incorrectCount + 1 else existing.incorrectCount,
                    level          = newLevel,
                    nextReviewAt   = System.currentTimeMillis() + intervalMs,
                )
            )
        }
    }

    private suspend fun buildBeforeSnapshot(words: List<Word>): Map<Long, Float> {
        val progressMap = progressRepository.getProgressForWords(words.map { it.id })
        return words.associate { word ->
            val p = progressMap[word.id]
            val total = (p?.correctCount ?: 0) + (p?.incorrectCount ?: 0)
            val rate = if (total > 0) (p?.incorrectCount ?: 0).toFloat() / total else 0f
            word.id to rate
        }
    }

    private suspend fun computeImprovedCount(): Int {
        val progressMap = progressRepository.getProgressForWords(beforeErrorRates.keys.toList())
        var improved = 0
        for ((wordId, beforeRate) in beforeErrorRates) {
            val p = progressMap[wordId] ?: continue
            val total = p.correctCount + p.incorrectCount
            if (total == 0) continue
            val afterRate = p.incorrectCount.toFloat() / total
            if (afterRate < beforeRate) improved++
        }
        return improved
    }

}
