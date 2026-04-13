package com.example.kartonki.domain.model

data class UserProfile(
    val uid: String = "",
    val displayName: String = "Игрок",
    val email: String = "",
    val photoUrl: String? = null,
    val isAnonymous: Boolean = false,
    val pvpOnlineWins: Int = 0,
    val pvpOnlineLosses: Int = 0,
    val pvpOnlineDraws: Int = 0,
)
