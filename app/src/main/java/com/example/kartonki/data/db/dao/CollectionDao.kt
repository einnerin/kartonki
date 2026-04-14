package com.example.kartonki.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kartonki.data.db.entity.CollectionEntity
import com.example.kartonki.data.db.entity.WordEntity

@Dao
interface CollectionDao {

    @Query("SELECT COUNT(*) FROM collection")
    suspend fun count(): Int

    @Query("""
        SELECT words.* FROM words
        INNER JOIN collection ON words.id = collection.wordId
        ORDER BY
            CASE words.rarity
                WHEN 'LEGENDARY' THEN 0
                WHEN 'EPIC'      THEN 1
                WHEN 'RARE'      THEN 2
                WHEN 'UNCOMMON'  THEN 3
                ELSE 4
            END ASC,
            words.original ASC
    """)
    suspend fun getOwnedWords(): List<WordEntity>

    @Query("""
        SELECT words.* FROM words
        INNER JOIN collection ON words.id = collection.wordId
        WHERE words.languagePair = :languagePair
        ORDER BY
            CASE words.rarity
                WHEN 'LEGENDARY' THEN 0
                WHEN 'EPIC'      THEN 1
                WHEN 'RARE'      THEN 2
                WHEN 'UNCOMMON'  THEN 3
                ELSE 4
            END ASC,
            words.original ASC
    """)
    suspend fun getOwnedWords(languagePair: String): List<WordEntity>

    @Query("""
        SELECT words.* FROM words
        INNER JOIN collection ON words.id = collection.wordId
        WHERE words.rarity = :rarity
        ORDER BY words.original ASC
    """)
    suspend fun getOwnedWordsByRarity(rarity: String): List<WordEntity>

    @Query("""
        SELECT words.* FROM words
        INNER JOIN collection ON words.id = collection.wordId
        WHERE words.languagePair = :languagePair AND words.rarity = :rarity
        ORDER BY words.original ASC
    """)
    suspend fun getOwnedWordsByRarity(languagePair: String, rarity: String): List<WordEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(entries: List<CollectionEntity>)

    @Query("SELECT wordId FROM collection")
    suspend fun getCollectedWordIds(): List<Long>
}
