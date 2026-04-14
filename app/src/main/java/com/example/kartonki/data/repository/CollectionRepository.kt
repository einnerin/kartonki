package com.example.kartonki.data.repository

import com.example.kartonki.data.AchievementCards
import com.example.kartonki.data.SeedData
import com.example.kartonki.data.WordLoader
import com.example.kartonki.data.db.dao.CollectionDao
import com.example.kartonki.data.db.dao.DeckDao
import com.example.kartonki.data.db.dao.WordDao
import com.example.kartonki.data.db.entity.CollectionEntity
import com.example.kartonki.data.db.entity.DeckCardCrossRef
import com.example.kartonki.data.db.entity.DeckEntity
import com.example.kartonki.data.db.entity.WordEntity
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
    private val wordLoader: WordLoader,
) {
    /**
     * On first run: seeds words, gives a starter collection of ~500 cards
     * (weighted toward lower rarities), and creates the default deck.
     * PvE uses wordDao directly and does not require collection ownership.
     */
    suspend fun ensureStarterPack() {
        wordLoader.ensureFresh()
        if (collectionDao.count() > 0) return
        val allWords = wordDao.getAllWordsOnce()
        val starterWords = selectStarterCards(allWords)
        collectionDao.insertAll(starterWords.map { CollectionEntity(it.id) })
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

    /**
     * Picks ~500 starter cards from all available words.
     * Weighted toward lower rarities so higher-rarity cards stay rare and
     * desirable from packs.
     */
    private fun selectStarterCards(allWords: List<WordEntity>): List<WordEntity> {
        val byRarity = allWords
            .filter { it.id !in AchievementCards.ALL_EXCLUSIVE_IDS }
            .groupBy { it.rarity }
        val result = mutableListOf<WordEntity>()
        listOf(
            "COMMON"    to 300,
            "UNCOMMON"  to 130,
            "RARE"      to 50,
            "EPIC"      to 15,
            "LEGENDARY" to 5,
        ).forEach { (rarity, limit) ->
            result.addAll(byRarity[rarity]?.shuffled()?.take(limit) ?: emptyList())
        }
        return result.take(STARTER_COLLECTION_SIZE)
    }

    companion object {
        private const val STARTER_COLLECTION_SIZE = 500
    }
}
