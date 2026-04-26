package com.example.kartonki.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kartonki.data.db.dao.SetProgressRow
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

    @Query("SELECT * FROM progress WHERE wordId IN (:wordIds)")
    suspend fun getProgressForWords(wordIds: List<Long>): List<ProgressEntity>

    /**
     * Returns (setId, level) for every word in the given sets that has a progress row.
     * Used to compute "introducedWords" counts for all sets in one query.
     */
    @Query("""
        SELECT w.setId AS setId, p.level AS level, p.correctCount AS correctCount
        FROM progress p
        INNER JOIN words w ON p.wordId = w.id
        WHERE w.setId IN (:setIds)
    """)
    suspend fun getProgressLevelsForSets(setIds: List<Long>): List<SetProgressRow>

    @Query("SELECT COUNT(*) FROM progress WHERE level >= 3")
    suspend fun getLearnedCount(): Int

    @Query("""
        SELECT COUNT(*) FROM progress p
        INNER JOIN words w ON p.wordId = w.id
        WHERE p.level >= 3 AND w.languagePair = :languagePair
    """)
    suspend fun getLearnedCountForLang(languagePair: String): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(progress: ProgressEntity)

    @Query("SELECT wordId FROM progress WHERE correctCount >= 10")
    suspend fun getEarnedWordIds(): List<Long>

    @Query("SELECT COALESCE(SUM(correctCount), 0) FROM progress")
    suspend fun getTotalCorrectCount(): Long

    @Query("""
        SELECT COALESCE(SUM(p.correctCount), 0) FROM progress p
        INNER JOIN words w ON p.wordId = w.id
        WHERE w.languagePair = :languagePair
    """)
    suspend fun getTotalCorrectCountForLang(languagePair: String): Long

    @Query("SELECT COUNT(*) FROM progress WHERE level >= :minLevel")
    suspend fun getWordCountAtMinLevel(minLevel: Int): Int

    @Query("""
        SELECT COUNT(*) FROM progress p
        INNER JOIN words w ON p.wordId = w.id
        WHERE p.level >= :minLevel AND w.languagePair = :languagePair
    """)
    suspend fun getWordCountAtMinLevelForLang(minLevel: Int, languagePair: String): Int

    @Query("""
        SELECT COUNT(DISTINCT w.semanticGroup) FROM progress p
        INNER JOIN words w ON p.wordId = w.id
        WHERE w.semanticGroup IS NOT NULL
    """)
    suspend fun getDistinctSemanticGroupCount(): Int

    @Query("""
        SELECT COUNT(DISTINCT w.semanticGroup) FROM progress p
        INNER JOIN words w ON p.wordId = w.id
        WHERE w.semanticGroup IS NOT NULL AND w.languagePair = :languagePair
    """)
    suspend fun getDistinctSemanticGroupCountForLang(languagePair: String): Int

    @Query("""
        SELECT COUNT(*) FROM progress p
        INNER JOIN words w ON p.wordId = w.id
        WHERE length(w.original) >= :minLength
    """)
    suspend fun getProgressWithLongWordCount(minLength: Int): Int

    @Query("""
        SELECT COUNT(*) FROM progress p
        INNER JOIN words w ON p.wordId = w.id
        WHERE length(w.original) >= :minLength AND w.languagePair = :languagePair
    """)
    suspend fun getProgressWithLongWordCountForLang(minLength: Int, languagePair: String): Int
}
