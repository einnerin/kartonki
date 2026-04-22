package com.example.kartonki.data.repository

import com.example.kartonki.data.PresetDecksVersion
import com.example.kartonki.data.WordDataVersion
import com.example.kartonki.data.WordLoader
import com.example.kartonki.data.WordRegistry
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
     * match the stored version, deletes all preset decks, recreates them from [WordRegistry],
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

        val isFirstRun = collectionDao.count() == 0
        if (isFirstRun) {
            // Words referenced by preset decks are always guaranteed so deck editors
            // show the correct cards immediately on first launch.
            // Each lookup uses languagePair so originals that collide across languages
            // (impossible today, prevented in future) always resolve to the right word.
            val presetWordEntities = WordRegistry.allPrebuiltDecks.flatMap { deck ->
                deck.wordOriginals.mapNotNull { original ->
                    wordDao.getWordByOriginalAndLanguage(original, deck.languagePair)
                }
            }.distinctBy { it.id }
            val presetIds = presetWordEntities.map { it.id }.toSet()

            // The default PvP card set is deterministic — same words for every user.
            // Flags are set by WordLoader based on insertion order, no shuffling.
            val starterWords = wordDao.getDefaultPvpCards().filter { it.id !in presetIds }

            val combined = (presetWordEntities + starterWords).distinctBy { it.id }
            collectionDao.insertAll(combined.map { CollectionEntity(it.id) })
        }

        // (Re)create preset decks if deck definitions changed OR word data changed.
        // Word data changes can silently alter word IDs via OnConflictStrategy.REPLACE
        // (a duplicate original in a new batch deletes the old row and inserts a new one
        // with a different ID), which orphans deck_cards references. Tracking both
        // versions ensures deck_cards are always rebuilt after any word data update.
        val storedDecksVersion = prefs.getPresetDecksVersion()
        val storedWordVersionForDecks = prefs.getPresetDecksWordVersion()
        if (storedDecksVersion != PresetDecksVersion.CURRENT ||
            storedWordVersionForDecks != WordDataVersion.CURRENT) {
            // Clean up orphaned deck_cards in user decks first (caused by duplicate word
            // replacements via OnConflictStrategy.REPLACE in previous word data versions).
            deckDao.deleteOrphanedDeckCards()
            migratePresetDecks()
            prefs.setPresetDecksVersion(PresetDecksVersion.CURRENT)
            prefs.setPresetDecksWordVersion(WordDataVersion.CURRENT)
        }
    }

    /**
     * Deletes all existing preset decks, recreates them from [WordRegistry.allPrebuiltDecks],
     * and ensures the collection contains all words those decks reference.
     */
    private suspend fun migratePresetDecks() {
        // Remove stale preset decks
        deckDao.clearAllPresetDeckCards()
        deckDao.deleteAllPresetDecks()

        // Recreate from all language sources via WordRegistry
        for (deckSeed in WordRegistry.allPrebuiltDecks) {
            val deckId = deckDao.insertDeck(
                DeckEntity(name = deckSeed.name, level = deckSeed.level, isPreset = true, languagePair = deckSeed.languagePair)
            )
            for (original in deckSeed.wordOriginals) {
                val word = wordDao.getWordByOriginalAndLanguage(original, deckSeed.languagePair) ?: continue
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
                definitionNative = e.definitionNative,
                example = e.example,
                exampleNative = e.exampleNative,
                rarity = Rarity.valueOf(e.rarity),
                languagePair = e.languagePair,
                pos = e.pos,
                semanticGroup = e.semanticGroup,
                transliteration = e.transliteration,
                isFillInBlankSafe = e.isFillInBlankSafe,
            )
        }
    }

    suspend fun getTotalCount(): Int = collectionDao.count()
}
