package com.example.kartonki.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pvp_matches")
data class PvpMatchEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val timestamp: Long,
    val player1Name: String,
    val player2Name: String,
    val player1Score: Int,
    val player2Score: Int,
    val winnerName: String?,       // null = draw
    val wasSurrender: Boolean = false,
    val languagePair: String = "en-ru",  // language of the deck used in this match
    /**
     * Index of the device owner in this match: 0 for player1 (local PvP convention,
     * online PvP when this client was matched as P1), 1 when this client was matched
     * as P2 in online PvP, null only for legacy rows written before the column
     * existed (treated as "unknown" by stats — neither win nor loss).
     *
     * Replaces the previous name-comparison logic (winnerName == player1Name), which
     * mis-counted wins/losses when both players were called "Игрок" — common in
     * pass-and-play mode where neither player customised their name.
     */
    val deviceOwnerIndex: Int? = null,
)
