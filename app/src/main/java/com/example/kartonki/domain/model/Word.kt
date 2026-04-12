package com.example.kartonki.domain.model

data class Word(
    val id: Long = 0,
    val original: String,
    val translation: String,
    val definition: String? = null,
    val example: String? = null,
    val rarity: Rarity,
    val languagePair: String = "en-ru",
    val pos: String? = null,
    val semanticGroup: String? = null,
)
