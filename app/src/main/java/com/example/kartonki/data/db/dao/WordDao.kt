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

    /** Bulk-delete words belonging to given setIds — used by orphan cleanup in WordLoader. */
    @Query("DELETE FROM words WHERE setId IN (:setIds)")
    suspend fun deleteWordsBySetIds(setIds: List<Long>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(words: List<WordEntity>)

    /** Like insertAll but overwrites existing rows — used for patch seeding when setId may be wrong. */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllOrReplace(words: List<WordEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(word: WordEntity): Long

    @Query("SELECT * FROM words ORDER BY RANDOM() LIMIT :limit")
    suspend fun getRandomWords(limit: Int): List<WordEntity>

    /**
     * Random pick by language + rarity, excluding a denylist of `original`s.
     * Used by [com.example.kartonki.data.repository.PackRepository] so a 5-card
     * pack can be assembled with five SQL calls instead of loading every word
     * for the language into memory.
     */
    @Query("""
        SELECT * FROM words
        WHERE languagePair = :langPair
          AND rarity = :rarity
          AND original NOT IN (:excludeOriginals)
        ORDER BY RANDOM() LIMIT :limit
    """)
    suspend fun getRandomByLangAndRarity(
        langPair: String,
        rarity: String,
        excludeOriginals: List<String>,
        limit: Int,
    ): List<WordEntity>

    @Query("SELECT * FROM words WHERE rarity = :rarity ORDER BY id ASC")
    suspend fun getWordsByRarity(rarity: String): List<WordEntity>

    @Query("SELECT * FROM words WHERE original = :original LIMIT 1")
    suspend fun getWordByOriginal(original: String): WordEntity?

    @Query("SELECT * FROM words WHERE original = :original AND languagePair = :languagePair LIMIT 1")
    suspend fun getWordByOriginalAndLanguage(original: String, languagePair: String): WordEntity?

    /**
     * Batch lookup for the seed-deck migration path: maps a list of `original`
     * strings to their canonical [WordEntity] in one query.
     *
     * Replaces the N+1 pattern where every preset deck word triggered a
     * separate `getWordByOriginalAndLanguage` call (15+ decks × 21 words ≈
     * 300+ statements per migratePresetDecks pass).
     */
    @Query("SELECT * FROM words WHERE languagePair = :languagePair AND original IN (:originals)")
    suspend fun getWordsByOriginalsAndLanguage(originals: List<String>, languagePair: String): List<WordEntity>

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
