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

        val allSets = WordDataEnglish.sets + WordDataEnglishExpanded.sets +
                WordDataHebrew.sets + WordDataHebrewEveryday.sets +
                WordDataHebrewMore.sets + WordDataHebrewAdvanced.sets
        wordSetDao.insertSets(allSets)

        val allWords = WordDataEnglish.words + WordDataEnglishExpanded.words +
                WordDataHebrew.words + WordDataHebrewEveryday.words +
                WordDataHebrewMore.words + WordDataHebrewAdvanced.words
        allWords.chunked(500).forEach { chunk -> wordDao.insertAllOrReplace(chunk) }

        prefs.setWordDataVersion(WordDataVersion.CURRENT)
    }
}
