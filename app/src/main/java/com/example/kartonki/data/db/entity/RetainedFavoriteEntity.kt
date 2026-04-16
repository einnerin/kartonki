package com.example.kartonki.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Helper table that survives word_set wipes during migrations.
 *
 * Before any migration that deletes word_sets, copy favorite IDs here:
 *   INSERT OR REPLACE INTO retained_favorites SELECT id FROM word_sets WHERE isFavorite = 1
 *
 * WordLoader.doLoad() will restore isFavorite=1 and clear this table automatically.
 */
@Entity(tableName = "retained_favorites")
data class RetainedFavoriteEntity(
    @PrimaryKey val setId: Long,
)
