package com.example.kartonki.domain.model

enum class StudyQuizType {
    MULTIPLE_CHOICE_TRANSLATION,              // show word → pick correct translation from 4
    MULTIPLE_CHOICE_DEFINITION,               // show word → pick correct definition (foreign lang)
    MULTIPLE_CHOICE_DEFINITION_NATIVE,        // show word → pick correct definition (native lang)
    MULTIPLE_CHOICE_WORD_FROM_DEF,            // show foreign definition → pick correct word
    MULTIPLE_CHOICE_WORD_FROM_DEF_NATIVE,     // show native definition  → pick correct word
    FILL_IN_BLANK,                            // foreign sentence with blank → pick correct word
    FILL_IN_BLANK_NATIVE,                     // native sentence with blank  → pick correct word
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
