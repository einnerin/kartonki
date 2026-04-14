package com.example.kartonki.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_sets")
data class WordSetEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val description: String = "",
    val orderIndex: Int = 0,
    val languagePair: String = "en-ru",
    val isFavorite: Boolean = false,
)
