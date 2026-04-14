package com.example.kartonki.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "decks")
data class DeckEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val level: Int = 1,
    /** True for decks created by the app (preset). Allows safe migration on updates. */
    val isPreset: Boolean = false,
)
