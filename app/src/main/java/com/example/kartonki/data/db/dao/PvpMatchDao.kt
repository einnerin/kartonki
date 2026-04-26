package com.example.kartonki.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kartonki.data.db.entity.PvpMatchEntity

@Dao
interface PvpMatchDao {
    @Query("SELECT * FROM pvp_matches ORDER BY timestamp DESC")
    suspend fun getAll(): List<PvpMatchEntity>

    @Query("SELECT COUNT(*) FROM pvp_matches WHERE languagePair = :languagePair")
    suspend fun getMatchCountForLang(languagePair: String): Int

    @Query("SELECT COUNT(*) FROM pvp_matches WHERE winnerName IS NOT NULL AND languagePair = :languagePair")
    suspend fun getMatchesWithWinnerCountForLang(languagePair: String): Int

    @Query("SELECT COUNT(*) FROM pvp_matches WHERE timestamp >= :sinceMs AND languagePair = :languagePair")
    suspend fun getMatchCountSinceForLang(sinceMs: Long, languagePair: String): Int

    @Insert
    suspend fun insert(match: PvpMatchEntity)
}
