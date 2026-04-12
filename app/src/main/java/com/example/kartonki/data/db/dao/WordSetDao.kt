package com.example.kartonki.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

@Dao
interface WordSetDao {
    @Query("""
        SELECT ws.* FROM word_sets ws
        LEFT JOIN (
            SELECT setId,
                   CASE rarity
                       WHEN 'COMMON'    THEN 0
                       WHEN 'UNCOMMON'  THEN 1
                       WHEN 'RARE'      THEN 2
                       WHEN 'EPIC'      THEN 3
                       WHEN 'LEGENDARY' THEN 4
                       ELSE 99
                   END AS rarityOrder
            FROM words
            GROUP BY setId
        ) w ON w.setId = ws.id
        WHERE ws.languagePair = :languagePair
        ORDER BY COALESCE(w.rarityOrder, 99) ASC, ws.id ASC
    """)
    suspend fun getSetsByLanguage(languagePair: String): List<WordSetEntity>

    @Query("SELECT COUNT(*) FROM word_sets")
    suspend fun getSetCount(): Int

    @Query("SELECT COUNT(*) FROM word_sets WHERE languagePair = :languagePair")
    suspend fun getSetCountByLanguage(languagePair: String): Int

    @Query("SELECT * FROM word_sets WHERE id = :id")
    suspend fun getSetById(id: Long): WordSetEntity?

    @Query("SELECT * FROM words WHERE setId = :setId ORDER BY id ASC")
    suspend fun getWordsInSet(setId: Long): List<WordEntity>

    @Query("SELECT COUNT(*) FROM words WHERE setId = :setId")
    suspend fun getWordCountInSet(setId: Long): Int

    @Query("SELECT rarity FROM words WHERE setId = :setId LIMIT 1")
    suspend fun getRarityForSet(setId: Long): String?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSets(sets: List<WordSetEntity>)
}
