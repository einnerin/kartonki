package com.example.kartonki.data.repository

import com.example.kartonki.data.SeedData
import com.example.kartonki.data.SeedDataEnglishMore
import com.example.kartonki.data.SeedDataEnglishNative
import com.example.kartonki.data.SeedDataHebrew
import com.example.kartonki.data.SeedDataHebrewEveryday
import com.example.kartonki.data.SeedDataHebrewMore
import com.example.kartonki.data.db.dao.SetRarityCount
import com.example.kartonki.data.db.dao.SetWordCount
import com.example.kartonki.data.db.dao.WordDao
import com.example.kartonki.data.db.dao.WordSetDao
import com.example.kartonki.data.db.entity.WordSetEntity
import com.example.kartonki.domain.model.Rarity
import com.example.kartonki.domain.model.Word
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.math.abs

@Singleton
class WordSetRepository @Inject constructor(
    private val wordSetDao: WordSetDao,
    private val wordDao: WordDao,
) {
    // Once seeding completes for this process, skip all subsequent calls.
    private val seedMutex = Mutex()
    private var seedingComplete = false

    /** Inserts seed sets + words on first run (or after destructive migration). */
    suspend fun ensureSeeded() {
        if (seedingComplete) return
        seedMutex.withLock {
            if (seedingComplete) return
            doSeed()
            seedingComplete = true
        }
    }

    private suspend fun doSeed() {
        if (wordSetDao.getSetCountByLanguage("en-ru") == 0) {
            wordSetDao.insertSets(SeedData.sets)
            wordDao.insertAll(SeedData.words)
        }
        if (wordSetDao.getSetCountByLanguage("he-ru") == 0) {
            wordSetDao.insertSets(SeedDataHebrew.sets)
            wordDao.insertAll(SeedDataHebrew.words)
        }
        // Everyday Hebrew sets added in a later update — seed if set 104 is missing.
        if (wordSetDao.getSetById(104L) == null) {
            wordSetDao.insertSets(SeedDataHebrewEveryday.sets)
            wordDao.insertAll(SeedDataHebrewEveryday.words)
        }
        // Additional Hebrew sets added in a later update — seed if set 108 is missing.
        if (wordSetDao.getSetById(108L) == null) {
            wordSetDao.insertSets(SeedDataHebrewMore.sets)
            wordDao.insertAll(SeedDataHebrewMore.words)
        }
        // Additional English sets (200+) — seed if set 200 is missing.
        if (wordSetDao.getSetById(200L) == null) {
            wordSetDao.insertSets(SeedDataEnglishMore.sets)
            wordDao.insertAll(SeedDataEnglishMore.words)
        }
        // Patch sets 211–219: compare total word count against the expected 225.
        // Uses REPLACE so that words previously stored with wrong setId are corrected.
        val expected211_219 = SeedDataEnglishMore.words.count { it.setId in 211L..219L }
        val actual211_219  = wordSetDao.getWordCountInRange(211L, 219L)
        if (actual211_219 < expected211_219) {
            wordSetDao.insertSets(SeedDataEnglishMore.sets.filter { it.id in 211L..219L })
            wordDao.insertAllOrReplace(SeedDataEnglishMore.words.filter { it.setId in 211L..219L })
        }
        // Additional English sets (220–229) — seed if set 220 is missing.
        if (wordSetDao.getSetById(220L) == null) {
            wordSetDao.insertSets(SeedDataEnglishMore.sets.filter { it.id >= 220 })
            wordDao.insertAll(SeedDataEnglishMore.words.filter { it.setId >= 220 })
        }
        // Sets 225–229 added in a later update — seed if set 225 is missing.
        if (wordSetDao.getSetById(225L) == null) {
            wordSetDao.insertSets(SeedDataEnglishMore.sets.filter { it.id in 225..229 })
            wordDao.insertAll(SeedDataEnglishMore.words.filter { it.setId in 225..229 })
        }
        // Sets 230–239 added in a later update — seed if set 230 is missing.
        if (wordSetDao.getSetById(230L) == null) {
            wordSetDao.insertSets(SeedDataEnglishMore.sets.filter { it.id in 230..239 })
            wordDao.insertAll(SeedDataEnglishMore.words.filter { it.setId in 230..239 })
        }
        // Sentinel for sets 200–219 (basics) after the set-split: ensures all wordsJ are
        // present and restores any missing second-batch words (2491-2568 range) for users
        // whose DB was seeded before those words were added. Uses INSERT OR IGNORE so no
        // existing word is overwritten.
        val expected200_219 = SeedDataEnglishMore.words.count { it.setId in 200L..219L }
        val actual200_219   = wordSetDao.getWordCountInRange(200L, 219L)
        if (actual200_219 < expected200_219) {
            wordSetDao.insertSets(SeedDataEnglishMore.sets.filter { it.id in 200..219 })
            wordDao.insertAll(SeedDataEnglishMore.words.filter { it.setId in 200L..219L })
        }
        // Sentinel for advanced sets 240–248 after the set-split. The set-220 sentinel
        // (id >= 220) may have already inserted wordsK for existing users; if so,
        // actual == expected and this block correctly skips. Otherwise it seeds them.
        val expected240_248 = SeedDataEnglishMore.words.count { it.setId in 240L..248L }
        val actual240_248   = wordSetDao.getWordCountInRange(240L, 248L)
        if (actual240_248 < expected240_248) {
            wordSetDao.insertSets(SeedDataEnglishMore.sets.filter { it.id in 240..248 })
            wordDao.insertAll(SeedDataEnglishMore.words.filter { it.setId in 240L..248L })
        }
        // Patch English words with Russian-language native content (definitionNative + exampleNative).
        // Runs once: skipped when the count of already-patched English words matches the dataset.
        patchEnglishNativeContent()
    }

    private suspend fun patchEnglishNativeContent() {
        // Done when every English word in the DB has native content filled in.
        val total = wordDao.countWordsByLanguage("en-ru")
        if (total == 0) return                                          // not seeded yet
        val done  = wordDao.countWordsWithNativeContent("en-ru")
        if (done == total) return                                       // all words already patched
        // Run all 2000+ UPDATEs inside one SQLite transaction — ~100× faster than separate transactions.
        wordDao.patchNativeContent("en-ru", SeedDataEnglishNative.data)
    }

    suspend fun toggleFavorite(setId: Long) {
        val set = wordSetDao.getSetById(setId) ?: return
        wordSetDao.setFavorite(setId, !set.isFavorite)
    }

    suspend fun getSetsByLanguage(languagePair: String): List<WordSetEntity> =
        wordSetDao.getSetsByLanguage(languagePair)

    suspend fun getSetById(id: Long): WordSetEntity? = wordSetDao.getSetById(id)

    suspend fun getWordsInSet(setId: Long): List<Word> =
        wordSetDao.getWordsInSet(setId).map { entity ->
            Word(
                id = entity.id,
                original = entity.original,
                translation = entity.translation,
                definition = entity.definition,
                example = entity.example,
                rarity = Rarity.valueOf(entity.rarity),
                languagePair = entity.languagePair,
                pos = entity.pos,
                semanticGroup = entity.semanticGroup,
                transliteration = entity.transliteration,
                definitionNative = entity.definitionNative,
                exampleNative = entity.exampleNative,
            )
        }

    suspend fun getWordCountInSet(setId: Long): Int = wordSetDao.getWordCountInSet(setId)

    /** Fetches word counts for many sets in one query, keyed by setId. */
    suspend fun getWordCountsForSets(setIds: List<Long>): Map<Long, Int> =
        wordSetDao.getWordCountsForSets(setIds).associate { it.setId to it.count }

    /** Fetches rarity composition for many sets in one query, grouped by setId. */
    suspend fun getRarityCountsForSets(setIds: List<Long>): Map<Long, List<SetRarityCount>> =
        wordSetDao.getRarityCountsForSets(setIds).groupBy { it.setId }

    /**
     * For each semantic group present in [sessionWords], fetches up to [limitPerGroup] additional
     * words from the DB (different words, same language). These extras are passed to QuizBuilder
     * as a distractor pool so that semantically-relevant wrong answers can be found even when the
     * session set is small or topic-diverse.
     */
    suspend fun getDistractorExtras(sessionWords: List<Word>, limitPerGroup: Int = 10): List<Word> {
        if (sessionWords.isEmpty()) return emptyList()
        val langPair = sessionWords.first().languagePair
        val excludeIds = sessionWords.map { it.id }
        val groups = sessionWords.mapNotNull { it.semanticGroup }.distinct()
        return groups.flatMap { group ->
            wordDao.getWordsBySemanticGroup(group, langPair, excludeIds, limitPerGroup)
                .map { entity ->
                    Word(
                        id = entity.id,
                        original = entity.original,
                        translation = entity.translation,
                        definition = entity.definition,
                        example = entity.example,
                        rarity = Rarity.valueOf(entity.rarity),
                        languagePair = entity.languagePair,
                        pos = entity.pos,
                        semanticGroup = entity.semanticGroup,
                        transliteration = entity.transliteration,
                        definitionNative = entity.definitionNative,
                        exampleNative = entity.exampleNative,
                    )
                }
        }.distinctBy { it.id }
    }

    /**
     * Returns the rarity whose [Rarity.points] value is closest to the weighted average
     * of all words in the set (weight = word count per rarity × rarity points).
     * This gives a colour that reflects the overall composition of the set rather than
     * the first or the rarest word.
     */
    suspend fun getRarityForSet(setId: Long): Rarity {
        val counts = wordSetDao.getRarityCountsForSet(setId)
        return rarityFromCounts(counts.map { SetRarityCount(setId, it.rarity, it.count) })
    }

    /** Computes a representative [Rarity] from a list of (rarity, count) pairs for one set. */
    fun rarityFromCounts(counts: List<SetRarityCount>): Rarity {
        if (counts.isEmpty()) return Rarity.COMMON
        val totalWords = counts.sumOf { it.count }
        val weightedSum = counts.sumOf { rc ->
            val pts = runCatching { Rarity.valueOf(rc.rarity).points }.getOrDefault(1)
            pts * rc.count
        }
        val avgPoints = weightedSum.toDouble() / totalWords
        return Rarity.entries.minByOrNull { abs(it.points - avgPoints) } ?: Rarity.COMMON
    }
}
