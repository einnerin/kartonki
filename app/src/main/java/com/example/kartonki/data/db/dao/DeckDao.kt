package com.example.kartonki.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kartonki.data.db.entity.DeckCardCrossRef
import com.example.kartonki.data.db.entity.DeckEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DeckDao {
    @Query("SELECT * FROM decks ORDER BY name ASC")
    fun getAllDecks(): Flow<List<DeckEntity>>

    @Query("SELECT * FROM decks ORDER BY name ASC")
    suspend fun getDecksOnce(): List<DeckEntity>

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

    @Query("DELETE FROM deck_cards WHERE deckId = :deckId")
    suspend fun clearDeck(deckId: Long)
}
