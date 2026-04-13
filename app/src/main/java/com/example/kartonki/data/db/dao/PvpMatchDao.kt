package com.example.kartonki.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kartonki.data.db.entity.PvpMatchEntity

@Dao
interface PvpMatchDao {
    @Query("SELECT * FROM pvp_matches ORDER BY timestamp DESC")
    suspend fun getAll(): List<PvpMatchEntity>

    @Query("SELECT COUNT(*) FROM pvp_matches")
    suspend fun getMatchCount(): Int

    @Query("SELECT COUNT(*) FROM pvp_matches WHERE winnerName IS NOT NULL")
    suspend fun getMatchesWithWinnerCount(): Int

    @Query("SELECT COUNT(*) FROM pvp_matches WHERE timestamp >= :sinceMs")
    suspend fun getMatchCountSince(sinceMs: Long): Int

    @Insert
    suspend fun insert(match: PvpMatchEntity)
}
