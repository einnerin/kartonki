package com.example.kartonki.ui.screen.study

/** Shared spaced-repetition constants used by both study-session ViewModels. */
object StudyConstants {
    const val MAX_LEVEL = 5
    val LEVEL_INTERVALS_DAYS = intArrayOf(0, 1, 3, 7, 14, 30)
    const val MILLIS_PER_DAY = 24L * 60 * 60 * 1000

    /**
     * Default number of DISTINCT quiz types a word must be answered correctly in
     * across problem-word sessions before it is considered "mastered".
     *
     * Rationale: one correct answer on MULTIPLE_CHOICE_TRANSLATION (4 options)
     * is 25% guess-rate — not a reliable mastery signal. Requiring distinct
     * quiz types forces the user to recognize the word from multiple angles
     * (translation, definition, context) before we declare it learned.
     *
     * Capped per-word by the number of quiz types actually available: a word
     * with no [definition] or no [example] may only have 1-2 types possible;
     * for such words mastery = all available types answered.
     */
    const val MASTERY_DISTINCT_TYPES = 3
}
