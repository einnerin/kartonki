package com.example.kartonki.data.remote.model

data class MatchmakingEntry(
    val uid: String = "",
    val playerName: String = "",
    val deckId: Long = 0L,
    val deckName: String = "",
    val deckLevel: Int = 1,
    val languagePair: String = "en-ru",
    val cardIds: List<Long> = emptyList(),
    val timestamp: Long = 0L,
)
