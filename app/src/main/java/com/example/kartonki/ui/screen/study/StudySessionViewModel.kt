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
import com.example.kartonki.ui.navigation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
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
    private val analytics: com.example.kartonki.analytics.AnalyticsManager,
) : ViewModel() {

    private val setId: Long = checkNotNull(savedStateHandle[Route.StudySession.ARG_SET_ID])

    private val _uiState = MutableStateFlow(SessionUiState())
    val uiState: StateFlow<SessionUiState> = _uiState.asStateFlow()

    private val sessionStartedAtMs: Long = System.currentTimeMillis()
    private var sessionStartedLogged = false
    private var sessionFinishedLogged = false

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
            // Fetch semantically-related words from other sets for use as distractors.
            // This ensures that e.g. "knee" gets body-part distractors even if the session
            // only has one body-part word alongside 24 animal words.
            val distractorExtras = wordSetRepository.getDistractorExtras(words)
            val steps = buildQuizStepsFromPrefs(prefs, words, distractorExtras)
            _uiState.update {
                it.copy(isLoading = false, isEmpty = false, steps = steps, currentStepIndex = 0)
            }
            if (!sessionStartedLogged) {
                sessionStartedLogged = true
                analytics.log(
                    com.example.kartonki.analytics.AnalyticsEvent.SessionStarted(
                        mode = com.example.kartonki.analytics.SessionMode.SET_STUDY,
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
            val incorrectCount = _uiState.value.incorrectCount
            val correctCount = _uiState.value.correctCount
            val totalSteps = _uiState.value.steps.size
            _uiState.update { it.copy(isSessionComplete = true) }
            viewModelScope.launch {
                achievementRepository.recordStudyDay(incorrectCount)
                packRepository.onActivityCompleted()
            }
            if (!sessionFinishedLogged) {
                sessionFinishedLogged = true
                analytics.log(
                    com.example.kartonki.analytics.AnalyticsEvent.SessionFinished(
                        mode = com.example.kartonki.analytics.SessionMode.SET_STUDY,
                        durationSec = (System.currentTimeMillis() - sessionStartedAtMs) / 1000,
                        wordsReviewed = totalSteps,
                        correctCount = correctCount,
                        completed = true,
                    )
                )
            }
        } else {
            _uiState.update { it.copy(currentStepIndex = next) }
        }
    }

    override fun onCleared() {
        super.onCleared()
        // Если выходим без завершения — фиксируем abandon
        if (sessionStartedLogged && !sessionFinishedLogged) {
            val state = _uiState.value
            val total = state.steps.size.coerceAtLeast(1)
            val percent = ((state.currentStepIndex * 100) / total).coerceIn(0, 100)
            analytics.log(
                com.example.kartonki.analytics.AnalyticsEvent.SessionAbandoned(
                    mode = com.example.kartonki.analytics.SessionMode.SET_STUDY,
                    completedPercent = percent,
                    reason = com.example.kartonki.analytics.AbandonReason.BACK_PRESS,
                )
            )
        }
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
                    correctCount = if (isCorrect) existing.correctCount + 1 else existing.correctCount,
                    incorrectCount = if (!isCorrect) existing.incorrectCount + 1 else existing.incorrectCount,
                    level = newLevel,
                    nextReviewAt = System.currentTimeMillis() + intervalMs,
                )
            )
        }
    }
}
