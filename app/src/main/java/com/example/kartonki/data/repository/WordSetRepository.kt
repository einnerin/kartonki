package com.example.kartonki.data.repository

import com.example.kartonki.data.SeedData
import com.example.kartonki.data.SeedDataEnglishNative
import com.example.kartonki.data.SeedDataHebrew
import com.example.kartonki.data.SeedDataHebrewEveryday
import com.example.kartonki.data.SeedDataHebrewMore
import com.example.kartonki.data.db.dao.WordDao
import com.example.kartonki.data.db.dao.WordSetDao
import com.example.kartonki.data.db.entity.WordSetEntity
import com.example.kartonki.domain.model.Rarity
import com.example.kartonki.domain.model.Word
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.abs

@Singleton
class WordSetRepository @Inject constructor(
    private val wordSetDao: WordSetDao,
    private val wordDao: WordDao,
) {
    /** Inserts seed sets + words on first run (or after destructive migration). */
    suspend fun ensureSeeded() {
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
