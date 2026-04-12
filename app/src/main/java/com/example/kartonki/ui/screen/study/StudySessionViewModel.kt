package com.example.kartonki.ui.screen.study

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kartonki.data.db.entity.ProgressEntity
import com.example.kartonki.data.preferences.UserPreferencesRepository
import com.example.kartonki.data.repository.AchievementRepository
import com.example.kartonki.data.repository.PackRepository
import com.example.kartonki.data.repository.ProgressRepository
import com.example.kartonki.data.repository.WordSetRepository
import com.example.kartonki.domain.model.StudyQuizType
import com.example.kartonki.domain.model.StudyStep
import com.example.kartonki.domain.model.Word
import com.example.kartonki.ui.navigation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class AnswerState {
    object Unanswered : AnswerState()
    data class Answered(
        val isCorrect: Boolean,
        val correctAnswer: String,
        val selectedAnswer: String,
    ) : AnswerState()
}

data class SessionUiState(
    val isLoading: Boolean = true,
    val isEmpty: Boolean = false,
    val steps: List<StudyStep> = emptyList(),
    val currentStepIndex: Int = 0,
    val correctCount: Int = 0,
    val incorrectCount: Int = 0,
    val isSessionComplete: Boolean = false,
    val answerState: AnswerState = AnswerState.Unanswered,
) {
    val currentStep: StudyStep? get() = steps.getOrNull(currentStepIndex)
    val progress: Float get() = if (steps.isEmpty()) 0f else currentStepIndex.toFloat() / steps.size
    val totalSteps: Int get() = steps.size
}

@HiltViewModel
class StudySessionViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val wordSetRepository: WordSetRepository,
    private val progressRepository: ProgressRepository,
    private val achievementRepository: AchievementRepository,
    private val packRepository: PackRepository,
    private val prefs: UserPreferencesRepository,
) : ViewModel() {

    private val setId: Long = checkNotNull(savedStateHandle[Route.StudySession.ARG_SET_ID])

    private val _uiState = MutableStateFlow(SessionUiState())
    val uiState: StateFlow<SessionUiState> = _uiState.asStateFlow()

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
                )
            }
            val words = wordSetRepository.getWordsInSet(setId)
            if (words.isEmpty()) {
                _uiState.update { it.copy(isLoading = false, isEmpty = true) }
                return@launch
            }
            val contextMode  = prefs.contextQuizMode.first()
            val enabledTypes = prefs.quizTypesEnabled.first()
            val steps = buildSteps(words, contextMode, enabledTypes)
            _uiState.update {
                it.copy(isLoading = false, isEmpty = false, steps = steps, currentStepIndex = 0)
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
        _uiState.update {
            it.copy(
                answerState = AnswerState.Answered(isCorrect, step.correctAnswer, selected),
                correctCount = if (isCorrect) it.correctCount + 1 else it.correctCount,
                incorrectCount = if (!isCorrect) it.incorrectCount + 1 else it.incorrectCount,
            )
        }
        saveProgress(step.word, isCorrect)
    }

    private fun advanceStep() {
        val next = _uiState.value.currentStepIndex + 1
        if (next >= _uiState.value.steps.size) {
            _uiState.update { it.copy(isSessionComplete = true) }
            viewModelScope.launch {
                achievementRepository.recordStudyDay()
                packRepository.checkAndGrantEarnedCards()
                packRepository.onActivityCompleted()
            }
        } else {
            _uiState.update { it.copy(currentStepIndex = next) }
        }
    }

    private fun saveProgress(word: Word, isCorrect: Boolean) {
        viewModelScope.launch {
            val existing = progressRepository.getProgress(word.id)
                ?: ProgressEntity(wordId = word.id)
            val newLevel = if (isCorrect) minOf(existing.level + 1, MAX_LEVEL)
                           else maxOf(existing.level - 1, 0)
            val intervalMs = LEVEL_INTERVALS_DAYS[newLevel] * 24L * 60 * 60 * 1000
            progressRepository.upsert(
                existing.copy(
                    correctCount = if (isCorrect) existing.correctCount + 1 else existing.correctCount,
                    incorrectCount = if (!isCorrect) existing.incorrectCount + 1 else existing.incorrectCount,
                    level = newLevel,
                    nextReviewAt = System.currentTimeMillis() + intervalMs,
                )
            )
        }
    }

    private fun buildSteps(words: List<Word>, contextMode: String, enabledTypes: Set<String>): List<StudyStep> =
        words.shuffled().map { word ->
            buildQuizStep(word, pickQuizType(word, words, contextMode, enabledTypes), words)
        }

    private fun pickQuizType(
        word: Word,
        allWords: List<Word>,
        contextMode: String,
        enabledTypes: Set<String>,
    ): StudyQuizType {
        val available = mutableListOf<StudyQuizType>()

        if ("translation" in enabledTypes) available.add(StudyQuizType.MULTIPLE_CHOICE_TRANSLATION)

        val useForeign = contextMode == "foreign" || contextMode == "both"
        val useNative  = contextMode == "native"  || contextMode == "both"

        if ("definition" in enabledTypes) {
            val foreignDefCount = allWords.count { it.definition != null }
            val nativeDefCount  = allWords.count { it.definitionNative != null }
            if (useForeign && word.definition != null && foreignDefCount >= 4) {
                available.add(StudyQuizType.MULTIPLE_CHOICE_DEFINITION)
                available.add(StudyQuizType.MULTIPLE_CHOICE_WORD_FROM_DEF)
            }
            if (useNative && word.definitionNative != null && nativeDefCount >= 4) {
                available.add(StudyQuizType.MULTIPLE_CHOICE_DEFINITION_NATIVE)
                available.add(StudyQuizType.MULTIPLE_CHOICE_WORD_FROM_DEF_NATIVE)
            }
        }
        if ("fill_blank" in enabledTypes) {
            if (useForeign && word.example != null && allWords.size >= 4)
                available.add(StudyQuizType.FILL_IN_BLANK)
            if (useNative && word.exampleNative != null && allWords.size >= 4)
                available.add(StudyQuizType.FILL_IN_BLANK_NATIVE)
        }

        return if (available.isEmpty()) StudyQuizType.MULTIPLE_CHOICE_TRANSLATION else available.random()
    }

    private fun buildQuizStep(word: Word, type: StudyQuizType, allWords: List<Word>): StudyStep.Quiz {
        val others = pickDistractors(word, allWords)
        return when (type) {
            StudyQuizType.MULTIPLE_CHOICE_TRANSLATION -> {
                val wrongs = others.take(3).map { it.translation }
                if (wrongs.size < 3) return fallbackTranslation(word, allWords)
                StudyStep.Quiz(
                    word = word, type = type, question = word.original,
                    options = (wrongs + word.translation).shuffled(),
                    correctAnswer = word.translation,
                )
            }
            StudyQuizType.MULTIPLE_CHOICE_DEFINITION -> {
                val wrongs = others.filter { it.definition != null }.take(3).map { it.definition!! }
                if (wrongs.size < 3) return fallbackTranslation(word, allWords)
                StudyStep.Quiz(
                    word = word, type = type, question = word.original,
                    options = (wrongs + word.definition!!).shuffled(),
                    correctAnswer = word.definition!!,
                )
            }
            StudyQuizType.MULTIPLE_CHOICE_DEFINITION_NATIVE -> {
                val wrongs = others.filter { it.definitionNative != null }.take(3).map { it.definitionNative!! }
                if (wrongs.size < 3) return fallbackTranslation(word, allWords)
                StudyStep.Quiz(
                    word = word, type = type, question = word.original,
                    options = (wrongs + word.definitionNative!!).shuffled(),
                    correctAnswer = word.definitionNative!!,
                )
            }
            StudyQuizType.MULTIPLE_CHOICE_WORD_FROM_DEF -> {
                val wrongs = others.filter { it.definition != null }.take(3).map { it.original }
                if (wrongs.size < 3) return fallbackTranslation(word, allWords)
                StudyStep.Quiz(
                    word = word, type = type, question = word.definition!!,
                    options = (wrongs + word.original).shuffled(),
                    correctAnswer = word.original,
                )
            }
            StudyQuizType.MULTIPLE_CHOICE_WORD_FROM_DEF_NATIVE -> {
                val wrongs = others.filter { it.definitionNative != null }.take(3).map { it.original }
                if (wrongs.size < 3) return fallbackTranslation(word, allWords)
                StudyStep.Quiz(
                    word = word, type = type, question = word.definitionNative!!,
                    options = (wrongs + word.original).shuffled(),
                    correctAnswer = word.original,
                )
            }
            StudyQuizType.FILL_IN_BLANK -> {
                val sentence = word.example!!.replace(word.original, "_____", ignoreCase = true)
                val wrongs = others.take(3).map { it.original }
                if (wrongs.size < 3) return fallbackTranslation(word, allWords)
                StudyStep.Quiz(
                    word = word, type = type, question = sentence,
                    options = (wrongs + word.original).shuffled(),
                    correctAnswer = word.original,
                )
            }
            StudyQuizType.FILL_IN_BLANK_NATIVE -> {
                val sentence = word.exampleNative!!.replace(word.original, "_____", ignoreCase = true)
                val wrongs = others.take(3).map { it.original }
                if (wrongs.size < 3) return fallbackTranslation(word, allWords)
                StudyStep.Quiz(
                    word = word, type = type, question = sentence,
                    options = (wrongs + word.original).shuffled(),
                    correctAnswer = word.original,
                )
            }
        }
    }

    private fun fallbackTranslation(word: Word, allWords: List<Word>): StudyStep.Quiz {
        val wrongs = allWords.filter { it.id != word.id }.shuffled().take(3).map { it.translation }
        return StudyStep.Quiz(
            word = word, type = StudyQuizType.MULTIPLE_CHOICE_TRANSLATION,
            question = word.original,
            options = (wrongs + word.translation).shuffled(),
            correctAnswer = word.translation,
        )
    }

    /**
     * Returns a shuffled list of distractor candidates ranked by semantic similarity:
     * 1st priority — same pos AND semanticGroup, 2nd — same pos only, 3rd — everything else.
     * Falls back gracefully when tags are absent.
     */
    private fun pickDistractors(word: Word, allWords: List<Word>): List<Word> {
        val candidates = allWords.filter { it.id != word.id }
        if (word.pos == null && word.semanticGroup == null) return candidates.shuffled()
        val tier1 = candidates.filter { it.pos == word.pos && it.semanticGroup == word.semanticGroup }.shuffled()
        val tier2 = candidates.filter { it.pos == word.pos && it.semanticGroup != word.semanticGroup }.shuffled()
        val tier3 = candidates.filter { it.pos != word.pos }.shuffled()
        return tier1 + tier2 + tier3
    }

    companion object {
        const val MAX_LEVEL = 5
        val LEVEL_INTERVALS_DAYS = intArrayOf(0, 1, 3, 7, 14, 30)
    }
}
