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
 *   1. Edit the relevant SeedData*.kt file.
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

        // ── Sets: INSERT OR IGNORE — preserves the user's isFavorite flag ──────
        val allSets = SeedData.sets +
                SeedDataHebrew.sets +
                SeedDataHebrewEveryday.sets +
                SeedDataHebrewMore.sets +
                SeedDataHebrewAdvanced.sets +
                SeedDataEnglishMore.sets
        wordSetDao.insertSets(allSets)

        // ── Words: INSERT OR REPLACE — always stores the latest content ─────────
        // Chunked to avoid SQLite variable limits on large inserts.
        val allWords = SeedData.words +
                SeedDataHebrew.words +
                SeedDataHebrewEveryday.words +
                SeedDataHebrewMore.words +
                SeedDataHebrewAdvanced.words +
                SeedDataEnglishMore.words
        allWords.chunked(500).forEach { chunk ->
            wordDao.insertAllOrReplace(chunk)
        }

        // ── Native-language content patch for English words ────────────────────
        wordDao.patchNativeContent("en-ru", SeedDataEnglishNative.data)

        prefs.setWordDataVersion(WordDataVersion.CURRENT)
    }
}
