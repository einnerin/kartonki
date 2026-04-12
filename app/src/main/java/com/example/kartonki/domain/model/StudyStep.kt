package com.example.kartonki.domain.model

enum class StudyQuizType {
    MULTIPLE_CHOICE_TRANSLATION,  // show word → pick correct translation from 4
    TYPE_TRANSLATION,             // show word → type the translation
    MULTIPLE_CHOICE_DEFINITION,   // show word → pick correct definition from 4
    FILL_IN_BLANK,                // show sentence with blank → pick correct word from 4
}

sealed class StudyStep {
    data class Introduction(val word: Word) : StudyStep()

    data class Quiz(
        val word: Word,
        val type: StudyQuizType,
        val question: String,
        val options: List<String> = emptyList(),
        val correctAnswer: String,
    ) : StudyStep()
}
