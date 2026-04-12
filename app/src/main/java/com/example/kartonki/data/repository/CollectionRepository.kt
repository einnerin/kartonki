package com.example.kartonki.data.repository

import com.example.kartonki.data.SeedData
import com.example.kartonki.data.db.dao.CollectionDao
import com.example.kartonki.data.db.dao.DeckDao
import com.example.kartonki.data.db.dao.WordDao
import com.example.kartonki.data.db.entity.CollectionEntity
import com.example.kartonki.data.db.entity.DeckCardCrossRef
import com.example.kartonki.data.db.entity.DeckEntity
import com.example.kartonki.domain.model.Rarity
import com.example.kartonki.domain.model.Word
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CollectionRepository @Inject constructor(
    private val collectionDao: CollectionDao,
    private val wordDao: WordDao,
    private val deckDao: DeckDao,
    private val wordSetRepository: WordSetRepository,
) {
    /**
     * On first run: seeds words, gives 10 Common + 4 Uncommon + 2 Rare starter pack,
     * and creates the default deck.
     */
    suspend fun ensureStarterPack() {
        wordSetRepository.ensureSeeded()
        if (collectionDao.count() > 0) return
        val allWords = wordDao.getAllWordsOnce()
        collectionDao.insertAll(allWords.map { CollectionEntity(it.id) })
        if (deckDao.getDeckCount() == 0) {
            for (deckSeed in SeedData.prebuiltDecks) {
                val deckId = deckDao.insertDeck(DeckEntity(name = deckSeed.name, level = deckSeed.level))
                for (original in deckSeed.wordOriginals) {
                    val word = wordDao.getWordByOriginal(original) ?: continue
                    deckDao.addCardToDeck(DeckCardCrossRef(deckId = deckId, wordId = word.id))
                }
            }
        }
    }

    suspend fun getOwnedWords(filter: Rarity? = null): List<Word> {
        val entities = if (filter == null) collectionDao.getOwnedWords()
                       else collectionDao.getOwnedWordsByRarity(filter.name)
        return entities.map { e ->
            Word(
                id = e.id,
                original = e.original,
                translation = e.translation,
                definition = e.definition,
                example = e.example,
                rarity = Rarity.valueOf(e.rarity),
                languagePair = e.languagePair,
                pos = e.pos,
                semanticGroup = e.semanticGroup,
            )
        }
    }

    suspend fun getTotalCount(): Int = collectionDao.count()
}
