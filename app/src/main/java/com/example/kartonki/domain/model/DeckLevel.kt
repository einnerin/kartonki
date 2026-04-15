package com.example.kartonki.domain.model

object DeckLevel {

    const val COUNT = 7

    private val NAMES = listOf("Новичок", "Ученик", "Знаток", "Опытный", "Умелый", "Мастер", "Эксперт")

    data class Limits(
        val common: Int,
        val uncommon: Int,
        val rare: Int,
        val epic: Int,
        val legendary: Int,
    ) {
        fun limitFor(rarity: Rarity): Int = when (rarity) {
            Rarity.COMMON    -> common
            Rarity.UNCOMMON  -> uncommon
            Rarity.RARE      -> rare
            Rarity.EPIC      -> epic
            Rarity.LEGENDARY -> legendary
        }

        val total: Int get() = common + uncommon + rare + epic + legendary
    }

    private val ALL = listOf(
        Limits(common = 12, uncommon = 9,  rare = 0,  epic = 0,  legendary = 0), // L1 Новичок
        Limits(common = 10, uncommon = 6,  rare = 5,  epic = 0,  legendary = 0), // L2 Ученик
        Limits(common = 8,  uncommon = 6,  rare = 4,  epic = 2,  legendary = 1), // L3 Знаток
        Limits(common = 4,  uncommon = 7,  rare = 6,  epic = 3,  legendary = 1), // L4 Опытный
        Limits(common = 0,  uncommon = 6,  rare = 8,  epic = 5,  legendary = 2), // L5 Умелый
        Limits(common = 0,  uncommon = 3,  rare = 8,  epic = 7,  legendary = 3), // L6 Мастер
        Limits(common = 0,  uncommon = 0,  rare = 6,  epic = 10, legendary = 5), // L7 Эксперт
    )

    fun limitsFor(level: Int): Limits = ALL.getOrElse(level - 1) { ALL[0] }
    fun nameFor(level: Int): String = NAMES.getOrElse(level - 1) { NAMES[0] }
    fun starsFor(level: Int): String = "★".repeat(level.coerceIn(1, COUNT))

    /**
     * Returns true if the deck has exactly [DECK_MAX_SIZE] cards and every rarity
     * count is within the limit for the given level.
     */
    fun isDeckValid(level: Int, totalCards: Int, rarityCounts: Map<Rarity, Int>): Boolean {
        if (totalCards != DECK_MAX_SIZE) return false
        val limits = limitsFor(level)
        return Rarity.entries.all { rarity -> (rarityCounts[rarity] ?: 0) <= limits.limitFor(rarity) }
    }

    const val DECK_MAX_SIZE = 21
}
