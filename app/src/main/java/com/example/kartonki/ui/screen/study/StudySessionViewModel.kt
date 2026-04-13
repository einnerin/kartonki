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
import com.example.kartonki.domain.model.StudyStep
import com.example.kartonki.domain.model.Word
import com.example.kartonki.domain.quiz.QuizBuilder
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
            val definitionMode = prefs.definitionQuizMode.first()
            val fillBlankMode  = prefs.fillBlankQuizMode.first()
            val enabledTypes   = prefs.quizTypesEnabled.first()
            // Fetch semantically-related words from other sets for use as distractors.
            // This ensures that e.g. "knee" gets body-part distractors even if the session
            // only has one body-part word alongside 24 animal words.
            val distractorExtras = wordSetRepository.getDistractorExtras(words)
            val steps = QuizBuilder.buildSteps(words, distractorExtras, definitionMode, fillBlankMode, enabledTypes)
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

    companion object {
        const val MAX_LEVEL = 5
        val LEVEL_INTERVALS_DAYS = intArrayOf(0, 1, 3, 7, 14, 30)
    }
}
