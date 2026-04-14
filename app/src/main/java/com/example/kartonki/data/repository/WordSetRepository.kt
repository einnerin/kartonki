package com.example.kartonki.data.repository

import com.example.kartonki.data.db.dao.SetRarityCount
import com.example.kartonki.data.db.dao.SetWordCount
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
