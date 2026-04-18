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
    val topic: String = "",   // тема для группировки, напр. "Медицина"
    val level: Int = 0,       // 0=не задан, 1=Основы, 2=Продвинутый, 3=Профессиональный
)
