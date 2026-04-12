package com.example.kartonki.data.repository

import com.example.kartonki.data.db.dao.WordDao
import com.example.kartonki.data.db.entity.WordEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WordRepository @Inject constructor(private val wordDao: WordDao) {

    fun getAllWords(): Flow<List<WordEntity>> = wordDao.getAllWords()

    suspend fun getWordById(id: Long): WordEntity? = wordDao.getWordById(id)

    suspend fun insert(word: WordEntity): Long = wordDao.insert(word)

    suspend fun insertAll(words: List<WordEntity>) = wordDao.insertAll(words)

    suspend fun delete(word: WordEntity) = wordDao.delete(word)

    suspend fun getWordCount(): Int = wordDao.getWordCount()
}
