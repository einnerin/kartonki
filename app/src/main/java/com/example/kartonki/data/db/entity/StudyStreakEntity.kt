package com.example.kartonki.data.db.entity

import androidx.room.Entity

/**
 * One row per (calendar day, languagePair) that had at least one study session.
 * Streak counters are calculated separately for each language.
 */
@Entity(
    tableName = "study_streaks",
    primaryKeys = ["date", "languagePair"],
)
data class StudyStreakEntity(
    val date: Long,           // start-of-day timestamp (ms)
    val languagePair: String,
)
