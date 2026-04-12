package com.example.kartonki.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kartonki.data.db.entity.ProgressEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProgressDao {
    @Query("SELECT * FROM progress WHERE wordId = :wordId")
    suspend fun getProgress(wordId: Long): ProgressEntity?

    @Query("SELECT * FROM progress WHERE nextReviewAt <= :now ORDER BY nextReviewAt ASC")
    fun getDueWords(now: Long): Flow<List<ProgressEntity>>

    @Query("SELECT COUNT(*) FROM progress WHERE level >= 3")
    fun getUnlockedCount(): Flow<Int>

    @Query("""
        SELECT progress.* FROM progress
        INNER JOIN words ON progress.wordId = words.id
        WHERE words.setId = :setId
    """)
    suspend fun getProgressForSet(setId: Long): List<ProgressEntity>

    @Query("SELECT * FROM progress")
    suspend fun getAll(): List<ProgressEntity>

    @Query("SELECT COUNT(*) FROM progress WHERE level >= 3")
    suspend fun getLearnedCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(progress: ProgressEntity)

    @Query("SELECT wordId FROM progress WHERE correctCount >= 10")
    suspend fun getEarnedWordIds(): List<Long>
}
