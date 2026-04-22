package com.example.kartonki.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_sets")
data class WordSetEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val description: String = "",
    // orderIndex исторический: колонка существует в DB, но запросы сортируют
    // по `id`, а не по нему. В новых наборах можно опустить — дефолт 0. Все
    // существующие 739 наборов имеют orderIndex == id (избыточно).
    val orderIndex: Int = 0,
    val languagePair: String = "en-ru",
    val isFavorite: Boolean = false,
    val topic: String = "",   // тема для группировки, напр. "Медицина"
    // level: 0=не задан, 1=основы (COMMON), 2=продвинутый (UNCOMMON),
    // 3=углублённый (RARE), 4=профессиональный (EPIC), 5=носитель языка (LEGENDARY).
    // См. docs/claude/word-sets.md.
    val level: Int = 0,
)
