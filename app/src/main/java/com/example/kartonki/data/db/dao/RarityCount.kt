package com.example.kartonki.data.db.dao

/** Result of grouping words by rarity within a set. Used for weighted-average rarity calculation. */
data class RarityCount(
    val rarity: String,
    val count: Int,
)
