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
    val pvpCorrectCount: Int = 0,
    val pvpIncorrectCount: Int = 0,
    /**
     * Set when the user masters a word in a problem-words session. Excludes the word
     * from the problem list WITHOUT zeroing incorrectCount (so accuracy stats stay
     * truthful). Cleared automatically on the next wrong answer, so a word that
     * becomes hard again can return to the problem list.
     */
    val isMastered: Boolean = false,
)
