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

    suspend fun upsert(progress: ProgressEntity) = progressDao.upsert(progress)
}
