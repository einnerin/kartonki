package com.example.kartonki.data.db.entity

import androidx.room.Entity

/**
 * Achievement progress per (achievementId, languagePair).
 *
 * Same achievement can be unlocked separately for each language the user studies —
 * e.g. FIRST_LESSON unlocks once for "en-ru" and again for "he-ru", granting a
 * language-specific reward card each time.
 */
@Entity(
    tableName = "achievements",
    primaryKeys = ["id", "languagePair"],
)
data class AchievementEntity(
    val id: String,
    val languagePair: String,
    val unlockedAt: Long? = null,
    val rewardWordId: Long? = null,
)
