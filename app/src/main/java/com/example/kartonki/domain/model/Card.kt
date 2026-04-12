package com.example.kartonki.domain.model

data class Card(
    val word: Word,
    val isUnlocked: Boolean = false,
)
