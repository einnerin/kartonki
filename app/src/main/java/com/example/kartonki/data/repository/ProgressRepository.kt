package com.example.kartonki.data.repository

import com.example.kartonki.data.db.dao.ProgressDao
import com.example.kartonki.data.db.entity.ProgressEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProgressRepository @Inject constructor(private val progressDao: ProgressDao) {

    suspend fun getProgress(wordId: Long): ProgressEntity? = progressDao.getProgress(wordId)

    fun getDueWords(now: Long = System.currentTimeMillis()): Flow<List<ProgressEntity>> =
        progressDao.getDueWords(now)

    fun getUnlockedCount(): Flow<Int> = progressDao.getUnlockedCount()

    suspend fun getProgressForSet(setId: Long): List<ProgressEntity> =
        progressDao.getProgressForSet(setId)

    /** Fetches progress rows for multiple words in a single query, keyed by wordId. */
    suspend fun getProgressForWords(wordIds: List<Long>): Map<Long, ProgressEntity> =
        progressDao.getProgressForWords(wordIds).associateBy { it.wordId }

    /**
     * Fetches progress for all words in the given sets in a single query.
     * Returns a map from setId → count of words where correctCount >= [threshold].
     * Default threshold of 1 preserves original behaviour (any correct answer counts).
     */
    suspend fun getIntroducedCountsForSets(setIds: List<Long>, threshold: Int = 1): Map<Long, Int> {
        val rows = progressDao.getProgressLevelsForSets(setIds)
        val result = mutableMapOf<Long, Int>()
        for (row in rows) {
            if (row.correctCount >= threshold) result[row.setId] = (result[row.setId] ?: 0) + 1
        }
        return result
    }

    suspend fun upsert(progress: ProgressEntity) = progressDao.upsert(progress)
}
