package com.example.kartonki.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kartonki.data.db.entity.WordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Query("SELECT * FROM words ORDER BY rarity DESC, original ASC")
    fun getAllWords(): Flow<List<WordEntity>>

    @Query("SELECT * FROM words WHERE id = :id")
    suspend fun getWordById(id: Long): WordEntity?

    @Query("SELECT COUNT(*) FROM words")
    suspend fun getWordCount(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(words: List<WordEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(word: WordEntity): Long

    @Query("SELECT * FROM words ORDER BY RANDOM() LIMIT :limit")
    suspend fun getRandomWords(limit: Int): List<WordEntity>

    @Query("SELECT * FROM words WHERE rarity = :rarity ORDER BY id ASC")
    suspend fun getWordsByRarity(rarity: String): List<WordEntity>

    @Query("SELECT * FROM words WHERE original = :original LIMIT 1")
    suspend fun getWordByOriginal(original: String): WordEntity?

    @Query("SELECT * FROM words ORDER BY rarity DESC, original ASC")
    suspend fun getAllWordsOnce(): List<WordEntity>

    @Query("SELECT * FROM words WHERE languagePair = :languagePair ORDER BY rarity DESC, original ASC")
    suspend fun getAllWordsByLanguage(languagePair: String): List<WordEntity>

    @Delete
    suspend fun delete(word: WordEntity)
}
