package com.example.kartonki.domain.model

data class PlayerStats(
    val wordsLearned: Int = 0,
    val accuracy: Float = 0f,
    val currentStreak: Int = 0,
    val longestStreak: Int = 0,
    val pvpWins: Int = 0,
    val pvpLosses: Int = 0,
    val pvpDraws: Int = 0,
    val bestPvpScore: Int = 0,
)
