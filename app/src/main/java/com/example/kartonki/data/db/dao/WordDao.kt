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

    @Query("""
        UPDATE words
        SET    definitionNative = :defNative,
               exampleNative    = :exNative
        WHERE  original = :original
          AND  languagePair = :langPair
    """)
    suspend fun updateNativeContent(
        original: String,
        langPair: String,
        defNative: String,
        exNative: String,
    )

    @Query("SELECT COUNT(*) FROM words WHERE languagePair = :langPair AND definitionNative IS NOT NULL")
    suspend fun countWordsWithNativeContent(langPair: String): Int

    @Query("SELECT COUNT(*) FROM words WHERE languagePair = :langPair")
    suspend fun countWordsByLanguage(langPair: String): Int

    /**
     * Fetches random words from the same semantic group, excluding already-known IDs.
     * Used to expand the distractor pool for quiz questions.
     */
    @Query("SELECT * FROM words WHERE semanticGroup = :group AND languagePair = :langPair AND id NOT IN (:excludeIds) ORDER BY RANDOM() LIMIT :limit")
    suspend fun getWordsBySemanticGroup(group: String, langPair: String, excludeIds: List<Long>, limit: Int): List<WordEntity>

    /** Applies all native-content updates inside a single SQLite transaction. */
    @androidx.room.Transaction
    suspend fun patchNativeContent(langPair: String, data: Map<String, Pair<String, String>>) {
        data.forEach { (original, content) ->
            updateNativeContent(original, langPair, content.first, content.second)
        }
    }
}
