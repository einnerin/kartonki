package com.example.kartonki.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kartonki.data.db.entity.StudyStreakEntity

@Dao
interface StudyStreakDao {
    @Query("SELECT * FROM study_streaks ORDER BY date DESC")
    suspend fun getAll(): List<StudyStreakEntity>

    @Query("SELECT COUNT(*) FROM study_streaks")
    suspend fun getCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(streak: StudyStreakEntity)
}
