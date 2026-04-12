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
    val pos: String? = null,           // part of speech: noun, verb, adjective, adverb, etc.
    val semanticGroup: String? = null, // thematic category: emotions, food, travel, etc.
)
