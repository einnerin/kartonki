package com.example.kartonki.ui.screen.study

/** Shared spaced-repetition constants used by both study-session ViewModels. */
object StudyConstants {
    const val MAX_LEVEL = 5
    val LEVEL_INTERVALS_DAYS = intArrayOf(0, 1, 3, 7, 14, 30)
    const val MILLIS_PER_DAY = 24L * 60 * 60 * 1000
}
