package com.example.kartonki.data

import com.example.kartonki.data.db.dao.WordDao
import com.example.kartonki.data.db.dao.WordSetDao
import com.example.kartonki.data.preferences.UserPreferencesRepository
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Single entry point for keeping word/set data fresh.
 *
 * Call [ensureFresh] once per process (e.g. from a ViewModel's init block).
 * It is safe to call from multiple coroutines — the first call does the work,
 * all subsequent calls in the same process return immediately.
 *
 * When word data changes:
 *   1. Edit the relevant WordData*.kt file.
 *   2. Bump [WordDataVersion.CURRENT].
 *   3. Ship the update — WordLoader detects the change on next launch automatically.
 */
@Singleton
class WordLoader @Inject constructor(
    private val wordSetDao: WordSetDao,
    private val wordDao: WordDao,
    private val prefs: UserPreferencesRepository,
) {
    private val mutex = Mutex()

    /** True after a successful load in this process. Skips DB calls on re-entry. */
    @Volatile private var loadedInProcess = false

    suspend fun ensureFresh() {
        if (loadedInProcess) return
        mutex.withLock {
            if (loadedInProcess) return
            doLoad()
            loadedInProcess = true
        }
    }

    private suspend fun doLoad() {
        val storedVersion = prefs.getWordDataVersion()
        if (storedVersion >= WordDataVersion.CURRENT) return

        val allSets = WordRegistry.allSets
        // Insert sets not yet in the DB; existing rows skipped (IGNORE).
        wordSetDao.insertSets(allSets)
        // Sync seed-controlled metadata (name, description, orderIndex) for all sets,
        // without touching user-owned fields like isFavorite.
        allSets.forEach { set ->
            wordSetDao.updateSetMetadata(set.id, set.name, set.description, set.orderIndex)
        }

        val allWords = WordRegistry.allWords

        val pvpOriginals = buildDefaultPvpOriginals(allWords)
        val wordsWithFlag = allWords.map { w ->
            if (w.original in pvpOriginals) w.copy(isDefaultPvpCard = true) else w
        }
        wordsWithFlag.chunked(500).forEach { chunk -> wordDao.insertAllOrReplace(chunk) }

        prefs.setWordDataVersion(WordDataVersion.CURRENT)
    }

    /**
     * Deterministically selects the starter PvP card set from [allWords].
     *
     * Words are taken in insertion order (i.e. the order they appear in seed files),
     * up to per-rarity limits. The result is identical for every user — no shuffling.
     *
     * Limits per language pair:
     *   COMMON 300 · UNCOMMON 130 · RARE 50 · EPIC 15 · LEGENDARY 5
     */
    private fun buildDefaultPvpOriginals(allWords: List<com.example.kartonki.data.db.entity.WordEntity>): Set<String> {
        val limits = mapOf("COMMON" to 300, "UNCOMMON" to 130, "RARE" to 50, "EPIC" to 15, "LEGENDARY" to 5)
        val result = mutableSetOf<String>()
        allWords
            .filter { it.original !in AchievementCards.ALL_EXCLUSIVE }
            .groupBy { it.languagePair }
            .forEach { (_, words) ->
                words.groupBy { it.rarity }.forEach { (rarity, rarityWords) ->
                    rarityWords.take(limits[rarity] ?: 0).forEach { result += it.original }
                }
            }
        return result
    }
}
