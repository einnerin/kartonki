package com.example.kartonki.ui.screen.study

import com.example.kartonki.data.preferences.UserPreferencesRepository
import com.example.kartonki.domain.model.StudyQuizType
import com.example.kartonki.domain.model.StudyStep
import com.example.kartonki.domain.model.Word
import com.example.kartonki.domain.quiz.QuizBuilder
import kotlinx.coroutines.flow.first

internal suspend fun buildQuizStepsFromPrefs(
    prefs: UserPreferencesRepository,
    words: List<Word>,
    distractorExtras: List<Word> = emptyList(),
    excludedTypesByWord: Map<Long, Set<StudyQuizType>> = emptyMap(),
): List<StudyStep.Quiz> {
    val definitionMode = prefs.definitionQuizMode.first()
    val enabledTypes   = prefs.quizTypesEnabled.first()
    return QuizBuilder.buildSteps(
        words, distractorExtras, definitionMode, enabledTypes, excludedTypesByWord,
    )
}
