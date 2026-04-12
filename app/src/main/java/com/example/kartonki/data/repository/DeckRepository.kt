package com.example.kartonki.data.repository

import com.example.kartonki.data.db.dao.DeckDao
import com.example.kartonki.data.db.entity.DeckCardCrossRef
import com.example.kartonki.data.db.entity.DeckEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeckRepository @Inject constructor(private val deckDao: DeckDao) {

    fun getAllDecks(): Flow<List<DeckEntity>> = deckDao.getAllDecks()

    suspend fun insertDeck(deck: DeckEntity): Long = deckDao.insertDeck(deck)

    suspend fun deleteDeck(deck: DeckEntity) = deckDao.deleteDeck(deck)

    suspend fun addCardToDeck(deckId: Long, wordId: Long) =
        deckDao.addCardToDeck(DeckCardCrossRef(deckId, wordId))

    suspend fun removeCardFromDeck(deckId: Long, wordId: Long) =
        deckDao.removeCardFromDeck(DeckCardCrossRef(deckId, wordId))

    suspend fun getWordIdsForDeck(deckId: Long): List<Long> =
        deckDao.getWordIdsForDeck(deckId)

    suspend fun clearDeck(deckId: Long) = deckDao.clearDeck(deckId)
}
