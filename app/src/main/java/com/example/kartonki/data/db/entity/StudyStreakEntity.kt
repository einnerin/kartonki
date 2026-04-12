package com.example.kartonki.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/** One row per calendar day that had at least one study session. */
@Entity(tableName = "study_streaks")
data class StudyStreakEntity(
    @PrimaryKey val date: Long,  // start-of-day timestamp (ms)
)
