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
import com.example.kartonki.data.db.entity.WordEntity
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
     * On first run: seeds words, gives a starter collection of ~1000 cards
     * per language pair (≈2000 total across en-ru + he-ru), weighted toward
     * lower rarities so newcomers can immediately build PvP decks. Preset
     * deck words are guaranteed on top of this base.
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

        // (Re)create preset decks if deck definitions changed OR word data changed.
        // Word data changes can silently alter word IDs via OnConflictStrategy.REPLACE
        // (a duplicate original in a new batch deletes the old row and inserts a new one
        // with a different ID), which orphans deck_cards references. Tracking both
        // versions ensures deck_cards are always rebuilt after any word data update.
        val storedDecksVersion = prefs.getPresetDecksVersion()
        val storedWordVersionForDecks = prefs.getPresetDecksWordVersion()
        val versionChanged = storedDecksVersion != PresetDecksVersion.CURRENT ||
            storedWordVersionForDecks != WordDataVersion.CURRENT
        val isFirstRun = collectionDao.count() == 0

        // On first run AND on every word/deck data version bump: ensure the user
        // owns all default starter PvP cards plus all preset deck words. This is
        // additive (insertAll uses OnConflict=IGNORE) — never removes user cards.
        // Without the version-bump branch, a tester installed on an older build
        // stays frozen with the old starter set even after we ship more cards.
        if (isFirstRun || versionChanged) {
            // Resolve every preset deck's wordOriginals in ONE query per language
            // (was N+1: one query per (deck × word), 300+ statements total).
            // languagePair scoping keeps cross-language originals from colliding.
            val presetWordEntities = WordRegistry.allPrebuiltDecks
                .groupBy { it.languagePair }
                .flatMap { (lang, decks) ->
                    val originals = decks.flatMap { it.wordOriginals }.distinct()
                    if (originals.isEmpty()) emptyList()
                    else wordDao.getWordsByOriginalsAndLanguage(originals, lang)
                }
                .distinctBy { it.id }

            // The default PvP card set is deterministic — same words for every user.
            // Flags are set by WordLoader using effective rarity (last write wins on
            // (original, languagePair) collisions), so the starter agrees with what
            // the user actually sees in the deck builder.
            val starterWords = wordDao.getDefaultPvpCards()

            val combined = (presetWordEntities + starterWords).distinctBy { it.id }
            collectionDao.insertAll(combined.map { CollectionEntity(it.id) })
        }

        if (versionChanged) {
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

        // Pre-resolve all (lang, original) pairs in one query per language —
        // avoids the per-word DB lookup loop (was 21 × ~30 decks = 600 queries).
        val originalsByLang: Map<String, Map<String, WordEntity>> =
            WordRegistry.allPrebuiltDecks
                .groupBy { it.languagePair }
                .mapValues { (lang, decks) ->
                    val originals = decks.flatMap { it.wordOriginals }.distinct()
                    if (originals.isEmpty()) emptyMap()
                    else wordDao.getWordsByOriginalsAndLanguage(originals, lang)
                        .associateBy { it.original }
                }

        val collectedIds = mutableListOf<CollectionEntity>()
        for (deckSeed in WordRegistry.allPrebuiltDecks) {
            val deckId = deckDao.insertDeck(
                DeckEntity(name = deckSeed.name, level = deckSeed.level, isPreset = true, languagePair = deckSeed.languagePair)
            )
            val langMap = originalsByLang[deckSeed.languagePair] ?: emptyMap()
            for (original in deckSeed.wordOriginals) {
                val word = langMap[original] ?: continue
                deckDao.addCardToDeck(DeckCardCrossRef(deckId = deckId, wordId = word.id))
                collectedIds += CollectionEntity(word.id)
            }
        }
        // Single bulk insert instead of one-per-word.
        if (collectedIds.isNotEmpty()) collectionDao.insertAll(collectedIds)
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

    /** Card count owned in a single language — what the collection screen displays. */
    suspend fun getTotalCount(languagePair: String): Int = collectionDao.count(languagePair)
}
