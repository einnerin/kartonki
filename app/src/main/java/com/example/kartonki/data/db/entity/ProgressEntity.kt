package com.example.kartonki.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "progress")
data class ProgressEntity(
    @PrimaryKey val wordId: Long,
    val correctCount: Int = 0,
    val incorrectCount: Int = 0,
    val level: Int = 0,           // 0–5; уровень освоения слова
    val nextReviewAt: Long = 0L,  // epoch millis
)
