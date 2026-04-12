package com.example.kartonki.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class WordEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val original: String,
    val translation: String,
    val definition: String? = null,
    val example: String? = null,
    val rarity: String,        // Rarity.name
    val languagePair: String = "en-ru",
    val setId: Long = 0,
    val pos: String? = null,
    val semanticGroup: String? = null,
    val transliteration: String? = null,  // pronunciation guide, used for non-Latin scripts
)
