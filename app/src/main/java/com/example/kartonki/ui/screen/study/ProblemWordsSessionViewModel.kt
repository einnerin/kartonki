package com.example.kartonki.ui.screen.study

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.db.entity.ProgressEntity
import com.example.kartonki.data.preferences.UserPreferencesRepository
import com.example.kartonki.data.repository.AchievementRepository
import com.example.kartonki.data.repository.PackRepository
import com.example.kartonki.data.repository.ProgressRepository
import com.example.kartonki.data.repository.StatsRepository
import com.example.kartonki.domain.model.StudyQuizType
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
    /** Words that advanced at least one distinct quiz type but didn't reach mastery. */
    val progressedCount: Int = 0,
    /** Words that participated in the session but didn't add any new correctly-answered quiz type. */
    val noProgressCount: Int = 0,
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
    private val analytics: com.example.kartonki.analytics.AnalyticsManager,
) : ViewModel() {

    private val sessionStartedAtMs: Long = System.currentTimeMillis()
    private var sessionStartedLogged = false
    private var sessionFinishedLogged = false

    private val _uiState = MutableStateFlow(ProblemSessionUiState())
    val uiState: StateFlow<ProblemSessionUiState> = _uiState.asStateFlow()

    // Snapshot of error rates before the session, for improvement comparison
    private var beforeErrorRates: Map<Long, Float> = emptyMap()
    // Per-word results during this session: total correct/incorrect counts
    private val sessionCorrect: MutableMap<Long, Int> = mutableMapOf()
    private val sessionIncorrect: MutableMap<Long, Int> = mutableMapOf()
    // Per-word set of NEW distinct quiz types answered correctly in this session
    // (types not already in the stored "mastered-types" set). Used at session
    // end to decide mastery and to report per-word progress.
    private val sessionNewTypes: MutableMap<Long, MutableSet<StudyQuizType>> = mutableMapOf()
    // Snapshot of stored mastered types at session start, so we can detect
    // "this session added a NEW type" vs "type was already counted".
    private var beforeMasteredTypes: Map<Long, Set<StudyQuizType>> = emptyMap()
    // Per-word set of available quiz types (what's physically possible for the
    // word given current word pool and user settings). Mastery threshold is
    // capped at this size — a word with only 2 available types is mastered
    // when both types are correctly answered.
    private var availableTypesByWord: Map<Long, Set<StudyQuizType>> = emptyMap()

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
                    progressedCount = 0,
                    noProgressCount = 0,
                    showSettingsHint = false,
                )
            }
            sessionCorrect.clear()
            sessionIncorrect.clear()
            sessionNewTypes.clear()

            val enabled = prefs.problemWordsEnabled.first()
            if (!enabled) {
                _uiState.update { it.copy(isLoading = false, isDisabled = true, isEmpty = false) }
                return@launch
            }

            val source = prefs.problemWordsSource.first()
            val minEncounters = prefs.problemWordsMinEncounters.first()

            val excludedIds = prefs.getSessionExcludedWordIds()
            prefs.clearSessionExcludedWordIds()
            val dismissedIds = prefs.getDismissedProblemWordIds()
            val allWords = statsRepository.getProblemWords(
                source, minEncounters, limit = 200, dismissedIds = dismissedIds,
            )
            val words = if (excludedIds.isEmpty()) allWords
                        else allWords.filter { it.id !in excludedIds }
            if (words.isEmpty()) {
                _uiState.update { it.copy(isLoading = false, isEmpty = true, isDisabled = false) }
                return@launch
            }

            // Snapshot before-state error rates
            beforeErrorRates = buildBeforeSnapshot(words)

            // Load stored mastered-types map, filtered to session words. Use to
            // (a) exclude already-passed types from quiz generation (variety),
            // (b) decide at session end whether a word reached mastery.
            beforeMasteredTypes = prefs.getProblemSessionMasteredTypes()
                .mapValues { (_, names) ->
                    names.mapNotNull { runCatching { StudyQuizType.valueOf(it) }.getOrNull() }.toSet()
                }
                .filterKeys { it in words.map(Word::id).toSet() }

            // Compute what quiz types are physically possible for each word,
            // given the current pool and user settings. Mastery threshold is
            // capped at this size (so a 1-type word is mastered with 1 answer).
            val definitionMode = prefs.definitionQuizMode.first()
            val fillBlankMode  = prefs.fillBlankQuizMode.first()
            val enabledTypes   = prefs.quizTypesEnabled.first()
            availableTypesByWord = words.associate { w ->
                w.id to QuizBuilder.availableQuizTypesFor(w, words, definitionMode, fillBlankMode, enabledTypes)
            }

            val steps = buildQuizStepsFromPrefs(
                prefs = prefs,
                words = words,
                excludedTypesByWord = beforeMasteredTypes,
            )
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
            if (!sessionStartedLogged) {
                sessionStartedLogged = true
                analytics.log(
                    com.example.kartonki.analytics.AnalyticsEvent.SessionStarted(
                        mode = com.example.kartonki.analytics.SessionMode.PVE_PROBLEM_WORDS,
                        deckLevel = null,
                        deckSize = words.size,
                        deckAvgRarity = null,
                    )
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
        val failsBefore = sessionIncorrect[wordId] ?: 0
        if (isCorrect) {
            sessionCorrect[wordId] = (sessionCorrect[wordId] ?: 0) + 1
            // Track NEW mastered types only — types already in the stored set
            // before the session started don't add fresh progress.
            val alreadyMastered = beforeMasteredTypes[wordId].orEmpty()
            if (step.type !in alreadyMastered) {
                sessionNewTypes.getOrPut(wordId) { mutableSetOf() }.add(step.type)
            }
        } else {
            sessionIncorrect[wordId] = (sessionIncorrect[wordId] ?: 0) + 1
        }

        _uiState.update {
            it.copy(
                answerState = AnswerState.Answered(isCorrect, step.correctAnswer, selected),
                correctCount   = if (isCorrect) it.correctCount + 1 else it.correctCount,
                incorrectCount = if (!isCorrect) it.incorrectCount + 1 else it.incorrectCount,
            )
        }
        analytics.log(
            com.example.kartonki.analytics.AnalyticsEvent.QuizAnswered(
                wordId = wordId,
                quizType = step.type.name,
                correct = isCorrect,
                responseMs = 0L,  // в этом VM нет точного timing — лишний шум; оставляем 0
                distractorCount = step.options.size.coerceAtLeast(1) - 1,
                attemptNumber = 1,
            )
        )
        analytics.log(
            com.example.kartonki.analytics.AnalyticsEvent.ProblemWordReviewed(
                wordId = wordId,
                failCountBefore = failsBefore,
                correctNow = isCorrect,
            )
        )
        saveProgress(step.word, isCorrect)
    }

    private fun advanceStep() {
        val next = _uiState.value.currentStepIndex + 1
        if (next >= _uiState.value.steps.size) {
            val incorrectCount = _uiState.value.incorrectCount
            val correctCount = _uiState.value.correctCount
            val totalSteps = _uiState.value.steps.size
            viewModelScope.launch {
                val improved = computeImprovedCount()
                val progress = applyMasteryAndCount()
                val showHint = !prefs.isProblemWordsHintShown()
                if (showHint) prefs.setProblemWordsHintShown()
                _uiState.update {
                    it.copy(
                        isSessionComplete = true,
                        improvedCount    = improved,
                        learnedCount     = progress.mastered,
                        progressedCount  = progress.progressed,
                        noProgressCount  = progress.noProgress,
                        showSettingsHint = showHint,
                    )
                }
                achievementRepository.recordStudyDay(incorrectCount)
                packRepository.onActivityCompleted()
                if (!sessionFinishedLogged) {
                    sessionFinishedLogged = true
                    analytics.log(
                        com.example.kartonki.analytics.AnalyticsEvent.SessionFinished(
                            mode = com.example.kartonki.analytics.SessionMode.PVE_PROBLEM_WORDS,
                            durationSec = (System.currentTimeMillis() - sessionStartedAtMs) / 1000,
                            wordsReviewed = totalSteps,
                            correctCount = correctCount,
                            completed = true,
                        )
                    )
                    val failStreakWords = sessionIncorrect.values.count { it >= 2 }
                    analytics.log(
                        com.example.kartonki.analytics.AnalyticsEvent.ProblemWordsSessionCompleted(
                            wordsReviewed = sessionCorrect.size + sessionIncorrect.size,
                            learnedCount = progress.mastered,
                            failStreakWords = failStreakWords,
                        )
                    )
                }
            }
        } else {
            _uiState.update { it.copy(currentStepIndex = next) }
        }
    }

    override fun onCleared() {
        super.onCleared()
        if (sessionStartedLogged && !sessionFinishedLogged) {
            val state = _uiState.value
            val total = state.steps.size.coerceAtLeast(1)
            val percent = ((state.currentStepIndex * 100) / total).coerceIn(0, 100)
            analytics.log(
                com.example.kartonki.analytics.AnalyticsEvent.SessionAbandoned(
                    mode = com.example.kartonki.analytics.SessionMode.PVE_PROBLEM_WORDS,
                    completedPercent = percent,
                    reason = com.example.kartonki.analytics.AbandonReason.BACK_PRESS,
                )
            )
        }
    }

    /**
     * Three-bucket summary of what happened this session:
     *  - [mastered]: words that reached the distinct-types threshold this session
     *    (removed from problem list; level bumped to max).
     *  - [progressed]: words that added ≥1 new distinct quiz type but didn't reach
     *    mastery yet.
     *  - [noProgress]: words that participated but didn't add any new type
     *    (all their session answers were either wrong or on types already counted).
     */
    private data class MasteryOutcome(
        val mastered: Int,
        val progressed: Int,
        val noProgress: Int,
    )

    /**
     * Applies the session's new correctly-answered quiz types to the stored
     * per-word type-set, masters words that reached the threshold, and returns
     * a summary of how every session word fared.
     *
     * Mastery threshold for a word: min([StudyConstants.MASTERY_DISTINCT_TYPES],
     * size of [availableTypesByWord] for that word). This cap handles words
     * that physically can't hit 3 types (e.g. missing definition/example).
     */
    private suspend fun applyMasteryAndCount(): MasteryOutcome {
        val storedBefore = beforeMasteredTypes
        val storedNext = storedBefore
            .mapValues { (_, set) -> set.toMutableSet() }
            .toMutableMap()

        var mastered = 0
        var progressed = 0
        var noProgress = 0

        val sessionWordIds = sessionCorrect.keys + sessionIncorrect.keys
        for (wordId in sessionWordIds) {
            val newTypes = sessionNewTypes[wordId].orEmpty()
            if (newTypes.isEmpty()) {
                noProgress++
                continue
            }
            val merged = (storedNext[wordId] ?: mutableSetOf()).apply { addAll(newTypes) }
            storedNext[wordId] = merged

            val availableSize = availableTypesByWord[wordId]?.size ?: StudyConstants.MASTERY_DISTINCT_TYPES
            val threshold = minOf(StudyConstants.MASTERY_DISTINCT_TYPES, availableSize).coerceAtLeast(1)
            if (merged.size >= threshold) {
                masterWord(wordId)
                storedNext.remove(wordId)
                mastered++
            } else {
                progressed++
            }
        }

        prefs.setProblemSessionMasteredTypes(
            storedNext.mapValues { (_, set) -> set.map { it.name }.toSet() }
        )
        return MasteryOutcome(mastered = mastered, progressed = progressed, noProgress = noProgress)
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
                nextReviewAt   = System.currentTimeMillis() + StudyConstants.LEVEL_INTERVALS_DAYS[StudyConstants.MAX_LEVEL] * StudyConstants.MILLIS_PER_DAY,
            )
        )
    }

    private fun saveProgress(word: Word, isCorrect: Boolean) {
        viewModelScope.launch {
            val existing = progressRepository.getProgress(word.id)
                ?: ProgressEntity(wordId = word.id)
            val newLevel = if (isCorrect) minOf(existing.level + 1, StudyConstants.MAX_LEVEL)
                           else maxOf(existing.level - 1, 0)
            val intervalMs = StudyConstants.LEVEL_INTERVALS_DAYS[newLevel] * StudyConstants.MILLIS_PER_DAY
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
