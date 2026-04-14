package com.example.kartonki.data.db.dao

/** Word count per set — returned by the batch word-count query. */
data class SetWordCount(
    val setId: Long,
    val count: Int,
)

/** Rarity count per set — returned by the batch rarity query. */
data class SetRarityCount(
    val setId: Long,
    val rarity: String,
    val count: Int,
)

/** Minimum progress level per (setId, wordId) row — returned by the batch progress query. */
data class SetProgressRow(
    val setId: Long,
    val level: Int,
)
