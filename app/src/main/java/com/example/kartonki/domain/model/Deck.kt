package com.example.kartonki.domain.model

data class Deck(
    val id: Long = 0,
    val name: String,
    val cards: List<Card> = emptyList(),
) {
    companion object {
        const val MAX_SIZE = 20
        val RARITY_LIMITS = mapOf(
            Rarity.LEGENDARY to 2,
            Rarity.EPIC to 4,
            Rarity.RARE to 6,
        )
    }

    fun canAdd(card: Card): Boolean {
        if (cards.size >= MAX_SIZE) return false
        val limit = RARITY_LIMITS[card.word.rarity] ?: return true
        return cards.count { it.word.rarity == card.word.rarity } < limit
    }
}
