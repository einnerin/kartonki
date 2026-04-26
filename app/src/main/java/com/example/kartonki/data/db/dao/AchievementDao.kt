package com.example.kartonki.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kartonki.data.db.entity.AchievementEntity

@Dao
interface AchievementDao {
    @Query("SELECT * FROM achievements ORDER BY id")
    suspend fun getAll(): List<AchievementEntity>

    @Query("SELECT * FROM achievements WHERE languagePair = :languagePair ORDER BY id")
    suspend fun getAllForLang(languagePair: String): List<AchievementEntity>

    @Query("SELECT * FROM achievements WHERE id = :id AND languagePair = :languagePair")
    suspend fun getById(id: String, languagePair: String): AchievementEntity?

    @Query("SELECT COUNT(*) FROM achievements WHERE unlockedAt IS NOT NULL AND languagePair = :languagePair")
    suspend fun getUnlockedCountForLang(languagePair: String): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(achievement: AchievementEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(achievements: List<AchievementEntity>)
}
