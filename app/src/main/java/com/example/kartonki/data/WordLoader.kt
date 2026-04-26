package com.example.kartonki.data

import androidx.room.withTransaction
import com.example.kartonki.data.db.AppDatabase
import com.example.kartonki.data.db.dao.WordDao
import com.example.kartonki.data.db.dao.WordSetDao
import com.example.kartonki.data.db.dao.WordSetMembershipDao
import com.example.kartonki.data.db.entity.WordSetMembershipEntity
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
    private val db: AppDatabase,
    private val wordSetDao: WordSetDao,
    private val wordDao: WordDao,
    private val wordSetMembershipDao: WordSetMembershipDao,
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
        // Re-load if either the seed version bumped OR the DB is empty.
        // Why the count check: Room's fallbackToDestructiveMigration drops every
        // table on schema change, but SharedPreferences are untouched — so
        // `storedVersion` can still equal CURRENT while the words table is empty.
        // Without the count guard we'd silently leave the user with no sets.
        val dbWordCount = wordDao.getWordCount()
        if (storedVersion >= WordDataVersion.CURRENT && dbWordCount > 0) return

        val allSets = WordRegistry.allSets
        val allWords = WordRegistry.allWords
        val pvpIds = buildDefaultPvpIds(allWords)
        val wordsWithFlag = allWords.map { w ->
            if (w.id in pvpIds) w.copy(isDefaultPvpCard = true) else w.copy(isDefaultPvpCard = false)
        }
        val memberships = allWords.map { WordSetMembershipEntity(it.id, it.setId) }

        db.withTransaction {
            // ── Orphan cleanup: remove sets/words that no longer exist in seed code ───
            // Without this, sets accumulate forever — e.g. when skeleton sets get filtered
            // out via WordRegistry.EXCLUDE_SKELETON_SETS_FROM_RELEASE or when a set is
            // deleted/renumbered, the old rows linger in the DB from previous app versions.
            val canonicalSetIds = allSets.map { it.id }.toSet()
            val existingSetIds = wordSetDao.getAllSetIds().toSet()
            val orphanSetIds = existingSetIds - canonicalSetIds
            if (orphanSetIds.isNotEmpty()) {
                val orphanList = orphanSetIds.toList()
                wordSetDao.deleteSetsById(orphanList)
                wordDao.deleteWordsBySetIds(orphanList)
            }

            // Insert sets not yet in the DB; existing rows skipped (IGNORE).
            wordSetDao.insertSets(allSets)
            // Sync seed-controlled metadata (name, description, orderIndex) for all sets,
            // without touching user-owned fields like isFavorite.
            allSets.forEach { set ->
                wordSetDao.updateSetMetadata(set.id, set.name, set.description, set.orderIndex, set.topic, set.level)
            }

            // Restore any isFavorite flags that were saved before a migration wiped word_sets.
            // No-op if retained_favorites is empty (the normal case).
            wordSetDao.restoreFavoritesFromRetained()
            wordSetDao.clearRetainedFavorites()

            wordsWithFlag.chunked(500).forEach { chunk -> wordDao.insertAllOrReplace(chunk) }

            // Populate membership table from canonical setId
            wordSetMembershipDao.deleteAll()
            memberships.chunked(500).forEach { chunk -> wordSetMembershipDao.insertAll(chunk) }
        }

        prefs.setWordDataVersion(WordDataVersion.CURRENT)
    }

    /**
     * Deterministically selects the starter PvP card set from [allWords].
     *
     * Returns a set of word IDs (one per language pair × rarity) that should be
     * marked [WordEntity.isDefaultPvpCard]=true. The result is identical for
     * every user — no shuffling, no randomness.
     *
     * Two subtleties make this non-trivial:
     *   1. The same `original` may appear in several seed files with different
     *      `rarity` values (collisions across themes). The DB resolves this via
     *      `OnConflictStrategy.REPLACE` on UNIQUE(original, languagePair) — the
     *      last write wins. We therefore dedup by (lang, original) and keep the
     *      LAST occurrence so the starter agrees with the effective DB rarity.
     *   2. Selection must be per-language (`Set<Long>` keyed by ID, not by
     *      `original`). A `Set<String>` of originals would mark BOTH the en-ru
     *      and he-ru row as starter when an identical string appears in both
     *      languages (e.g. "WhatsApp"). Tying the flag to ID prevents that leak.
     *
     * Limits per language pair total ~1000 cards (≈2000 across en-ru + he-ru):
     *   COMMON 600 · UNCOMMON 270 · RARE 100 · EPIC 25 · LEGENDARY 5
     *
     * Distribution skewed toward lower rarities so newcomers always have enough
     * basic vocabulary to build PvP decks; rare/epic/legendary appear sparingly.
     * Preset deck words are added on top of this set in CollectionRepository.
     */
    private fun buildDefaultPvpIds(allWords: List<com.example.kartonki.data.db.entity.WordEntity>): Set<Long> {
        val limits = mapOf("COMMON" to 600, "UNCOMMON" to 270, "RARE" to 100, "EPIC" to 25, "LEGENDARY" to 5)

        // Effective table: last (lang, original) → WordEntity. LinkedHashMap preserves
        // insertion order of first appearance, but `put` reassigns the value —
        // so iteration order is stable while the value reflects the final write.
        val effective = LinkedHashMap<Pair<String, String>, com.example.kartonki.data.db.entity.WordEntity>()
        for (w in allWords) {
            if (w.setId == 0L) continue                          // achievement reward words — never starter
            if (w.original in AchievementCards.ALL_EXCLUSIVE) continue
            effective[w.languagePair to w.original] = w
        }

        val result = mutableSetOf<Long>()
        effective.values
            .groupBy { it.languagePair }
            .forEach { (_, words) ->
                words.groupBy { it.rarity }.forEach { (rarity, bucket) ->
                    bucket.take(limits[rarity] ?: 0).forEach { result += it.id }
                }
            }
        return result
    }
}
