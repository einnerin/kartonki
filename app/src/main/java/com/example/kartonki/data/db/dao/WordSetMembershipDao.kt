package com.example.kartonki.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetMembershipEntity

@Dao
interface WordSetMembershipDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(memberships: List<WordSetMembershipEntity>)

    @Query("""
        SELECT w.* FROM words w
        INNER JOIN word_set_membership m ON w.id = m.wordId
        WHERE m.setId = :setId
        ORDER BY w.id ASC
    """)
    suspend fun getWordsForSet(setId: Long): List<WordEntity>

    @Query("SELECT COUNT(*) FROM word_set_membership WHERE setId = :setId")
    suspend fun getCountForSet(setId: Long): Int

    @Query("DELETE FROM word_set_membership")
    suspend fun deleteAll()
}
