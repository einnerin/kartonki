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

    @Query("SELECT * FROM words WHERE id IN (:ids)")
    suspend fun getWordsByIds(ids: List<Long>): List<WordEntity>

    @Query("SELECT COUNT(*) FROM words")
    suspend fun getWordCount(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(words: List<WordEntity>)

    /** Like insertAll but overwrites existing rows — used for patch seeding when setId may be wrong. */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllOrReplace(words: List<WordEntity>)

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

    /** Returns the fixed starter PvP collection — same words for every user. */
    @Query("SELECT * FROM words WHERE isDefaultPvpCard = 1")
    suspend fun getDefaultPvpCards(): List<WordEntity>

    @Delete
    suspend fun delete(word: WordEntity)

    @Query("SELECT COUNT(*) FROM words WHERE languagePair = :langPair")
    suspend fun countWordsByLanguage(langPair: String): Int

    /**
     * Fetches random words from the same semantic group, excluding already-known IDs.
     * Used to expand the distractor pool for quiz questions.
     */
    @Query("SELECT * FROM words WHERE semanticGroup = :group AND languagePair = :langPair AND id NOT IN (:excludeIds) ORDER BY RANDOM() LIMIT :limit")
    suspend fun getWordsBySemanticGroup(group: String, langPair: String, excludeIds: List<Long>, limit: Int): List<WordEntity>
}
