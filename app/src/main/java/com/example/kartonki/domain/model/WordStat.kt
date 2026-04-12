package com.example.kartonki.domain.model

enum class WordStatSort { MOST_ERRORS, EASIEST, MOST_ENCOUNTERS, RECENTLY_STUDIED }

data class WordStat(
    val wordId: Long,
    val original: String,
    val translation: String,
    val rarity: Rarity,
    val encounters: Int,
    val errorRate: Float,
    val level: Int,
    val nextReviewAt: Long,
)
