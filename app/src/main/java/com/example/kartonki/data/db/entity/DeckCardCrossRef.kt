package com.example.kartonki.data.db.entity

import androidx.room.Entity

@Entity(
    tableName = "deck_cards",
    primaryKeys = ["deckId", "wordId"],
)
data class DeckCardCrossRef(
    val deckId: Long,
    val wordId: Long,
)
