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
)
