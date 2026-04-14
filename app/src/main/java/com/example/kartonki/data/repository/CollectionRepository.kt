package com.example.kartonki.data.repository

import com.example.kartonki.data.PresetDecksVersion
import com.example.kartonki.data.SeedData
import com.example.kartonki.data.WordLoader
import com.example.kartonki.data.db.dao.CollectionDao
import com.example.kartonki.data.db.dao.DeckDao
import com.example.kartonki.data.db.dao.WordDao
import com.example.kartonki.data.db.entity.CollectionEntity
import com.example.kartonki.data.db.entity.DeckCardCrossRef
import com.example.kartonki.data.db.entity.DeckEntity
import com.example.kartonki.data.preferences.UserPreferencesRepository
import com.example.kartonki.domain.model.Rarity
import com.example.kartonki.domain.model.Word
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CollectionRepository @Inject constructor(
    private val collectionDao: CollectionDao,
    private val wordDao: WordDao,
    private val deckDao: DeckDao,
    private val wordSetRepository: WordSetRepository,
    private val wordLoader: WordLoader,
    private val prefs: UserPreferencesRepository,
) {
    private val mutex = Mutex()
    @Volatile private var initializedInProcess = false
    /**
     * On first run: seeds words, gives a starter collection of ~500 cards
     * (weighted toward lower rarities), and creates preset decks.
     *
     * On subsequent launches after an app update: if [PresetDecksVersion.CURRENT] doesn't
     * match the stored version, deletes all preset decks, recreates them from [SeedData],
     * and ensures any new preset words are added to the collection.
     *
     * PvE uses wordDao directly and does not require collection ownership.
     */
    suspend fun ensureStarterPack() {
        if (initializedInProcess) return
        mutex.withLock {
            if (initializedInProcess) return
            doEnsureStarterPack()
            initializedInProcess = true
        }
    }

    private suspend fun doEnsureStarterPack() {
        wordLoader.ensureFresh()

        // All words of every language are available from the start.
        // INSERT OR IGNORE is idempotent: existing rows are skipped, and any
        // new words added in future WordDataVersion bumps appear automatically.
        val allWords = wordDao.getAllWordsOnce()
        collectionDao.insertAll(allWords.map { CollectionEntity(it.id) })

        // (Re)create preset decks if version has changed or this is a first run.
        val storedVersion = prefs.getPresetDecksVersion()
        if (storedVersion != PresetDecksVersion.CURRENT) {
            migratePresetDecks()
            prefs.setPresetDecksVersion(PresetDecksVersion.CURRENT)
        }
    }

    /**
     * Deletes all existing preset decks, recreates them from [SeedData],
     * and ensures the collection contains all words those decks reference.
     */
    private suspend fun migratePresetDecks() {
        // Remove stale preset decks
        deckDao.clearAllPresetDeckCards()
        deckDao.deleteAllPresetDecks()

        // Recreate from current SeedData
        for (deckSeed in SeedData.prebuiltDecks) {
            val deckId = deckDao.insertDeck(
                DeckEntity(name = deckSeed.name, level = deckSeed.level, isPreset = true, languagePair = deckSeed.languagePair)
            )
            for (original in deckSeed.wordOriginals) {
                val word = wordDao.getWordByOriginal(original) ?: continue
                deckDao.addCardToDeck(DeckCardCrossRef(deckId = deckId, wordId = word.id))
                // Ensure this word is in the collection (new preset words added in updates)
                collectionDao.insertAll(listOf(CollectionEntity(word.id)))
            }
        }
    }

    suspend fun getOwnedWords(filter: Rarity? = null, languagePair: String? = null): List<Word> {
        val entities = when {
            languagePair != null && filter != null -> collectionDao.getOwnedWordsByRarity(languagePair, filter.name)
            languagePair != null -> collectionDao.getOwnedWords(languagePair)
            filter != null -> collectionDao.getOwnedWordsByRarity(filter.name)
            else -> collectionDao.getOwnedWords()
        }
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
