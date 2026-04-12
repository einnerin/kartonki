package com.example.kartonki.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/** Tracks which words (cards) the user owns in their collection. */
@Entity(tableName = "collection")
data class CollectionEntity(
    @PrimaryKey val wordId: Long,
)
