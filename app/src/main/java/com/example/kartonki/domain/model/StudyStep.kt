package com.example.kartonki.domain.model

enum class StudyQuizType {
    MULTIPLE_CHOICE_TRANSLATION,         // show word → pick correct translation from 4
    TYPE_TRANSLATION,                    // show word → type the translation
    MULTIPLE_CHOICE_DEFINITION,          // show word → pick correct definition (foreign language)
    MULTIPLE_CHOICE_DEFINITION_NATIVE,   // show word → pick correct definition (native language)
    FILL_IN_BLANK,                       // show foreign sentence with blank → pick correct word
    FILL_IN_BLANK_NATIVE,                // show native sentence with blank → pick correct word
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
