package com.example.kartonki.domain.model

enum class Rarity(
    val displayName: String,
    val points: Int,
    val colorArgb: Long,
    val deckLimit: Int,
) {
    COMMON("Common", 1, 0xFFAAAAAA, 8),
    UNCOMMON("Uncommon", 2, 0xFF4CAF50, 6),
    RARE("Rare", 4, 0xFF4A90E2, 4),
    EPIC("Epic", 7, 0xFF9B51E0, 2),
    LEGENDARY("Legendary", 12, 0xFFF5A623, 1),
    ;

    companion object {
        /** Maps set level (1–5) to the canonical rarity for display and filtering. */
        fun fromLevel(level: Int): Rarity = when (level) {
            1 -> COMMON
            2 -> UNCOMMON
            3 -> RARE
            4 -> EPIC
            5 -> LEGENDARY
            else -> COMMON
        }
    }
}
