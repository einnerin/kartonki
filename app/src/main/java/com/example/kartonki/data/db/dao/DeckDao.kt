package com.example.kartonki.data.db.dao

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kartonki.data.db.entity.DeckCardCrossRef
import com.example.kartonki.data.db.entity.DeckEntity
import kotlinx.coroutines.flow.Flow

/** Result row for per-rarity card counts in a deck. */
data class RarityCountRow(
    @ColumnInfo(name = "rarity") val rarity: String,
    @ColumnInfo(name = "cnt") val cnt: Int,
)

@Dao
interface DeckDao {
    @Query("SELECT * FROM decks ORDER BY isPreset ASC, level DESC, name ASC")
    fun getAllDecks(): Flow<List<DeckEntity>>

    @Query("SELECT * FROM decks WHERE languagePair = :languagePair ORDER BY isPreset ASC, level DESC, name ASC")
    fun getAllDecks(languagePair: String): Flow<List<DeckEntity>>

    @Query("SELECT * FROM decks ORDER BY isPreset ASC, level DESC, name ASC")
    suspend fun getDecksOnce(): List<DeckEntity>

    @Query("SELECT * FROM decks WHERE languagePair = :languagePair ORDER BY isPreset ASC, level DESC, name ASC")
    suspend fun getDecksOnce(languagePair: String): List<DeckEntity>

    @Query("SELECT COUNT(*) FROM decks")
    suspend fun getDeckCount(): Int

    @Query("SELECT * FROM decks ORDER BY id ASC LIMIT 1")
    suspend fun getFirstDeck(): DeckEntity?

    @Query("SELECT * FROM decks WHERE id = :id")
    suspend fun getDeckById(id: Long): DeckEntity?

    /** Total entries in the deck regardless of ownership (used for deck structure checks). */
    @Query("SELECT COUNT(*) FROM deck_cards WHERE deckId = :deckId")
    suspend fun getCardCountForDeck(deckId: Long): Int

    /** Cards that are both in the deck AND owned by the player — used for display and PvP. */
    @Query("""
        SELECT COUNT(*) FROM deck_cards
        INNER JOIN collection ON deck_cards.wordId = collection.wordId
        WHERE deck_cards.deckId = :deckId
    """)
    suspend fun getOwnedCardCountForDeck(deckId: Long): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDeck(deck: DeckEntity): Long

    @Delete
    suspend fun deleteDeck(deck: DeckEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCardToDeck(ref: DeckCardCrossRef)

    @Delete
    suspend fun removeCardFromDeck(ref: DeckCardCrossRef)

    @Query("SELECT wordId FROM deck_cards WHERE deckId = :deckId")
    suspend fun getWordIdsForDeck(deckId: Long): List<Long>

    /** Returns per-rarity card counts for a deck (all cards, regardless of ownership). */
    @Query("""
        SELECT w.rarity AS rarity, COUNT(*) AS cnt
        FROM deck_cards dc
        JOIN words w ON dc.wordId = w.id
        WHERE dc.deckId = :deckId
        GROUP BY w.rarity
    """)
    suspend fun getRarityCountsForDeck(deckId: Long): List<RarityCountRow>

    @Query("DELETE FROM deck_cards WHERE deckId = :deckId")
    suspend fun clearDeck(deckId: Long)

    /** Removes all cards from every preset deck (used during preset migration). */
    @Query("DELETE FROM deck_cards WHERE deckId IN (SELECT id FROM decks WHERE isPreset = 1)")
    suspend fun clearAllPresetDeckCards()

    /** Deletes all preset deck rows (call after clearAllPresetDeckCards). */
    @Query("DELETE FROM decks WHERE isPreset = 1")
    suspend fun deleteAllPresetDecks()

    /**
     * Removes deck_cards entries whose wordId no longer exists in the words table.
     * Call this after a word data upsert to fix any orphans left by OnConflictStrategy.REPLACE
     * (which deletes the old row when a duplicate original is loaded with a new ID).
     */
    @Query("DELETE FROM deck_cards WHERE wordId NOT IN (SELECT id FROM words)")
    suspend fun deleteOrphanedDeckCards()
}
