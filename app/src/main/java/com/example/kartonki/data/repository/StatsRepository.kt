package com.example.kartonki.data.repository

import com.example.kartonki.data.db.dao.ProgressDao
import com.example.kartonki.data.db.dao.PvpMatchDao
import com.example.kartonki.data.db.dao.StudyStreakDao
import com.example.kartonki.data.db.dao.WordDao
import com.example.kartonki.domain.model.PlayerStats
import com.example.kartonki.domain.model.Rarity
import com.example.kartonki.domain.model.Word
import com.example.kartonki.domain.model.WordStat
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StatsRepository @Inject constructor(
    private val progressDao: ProgressDao,
    private val studyStreakDao: StudyStreakDao,
    private val pvpMatchDao: PvpMatchDao,
    private val wordDao: WordDao,
) {
    suspend fun getPlayerStats(): PlayerStats {
        val allProgress = progressDao.getAll()
        val totalCorrect   = allProgress.sumOf { it.correctCount }
        val totalIncorrect = allProgress.sumOf { it.incorrectCount }
        val totalAnswers   = totalCorrect + totalIncorrect
        val accuracy       = if (totalAnswers > 0) totalCorrect.toFloat() / totalAnswers else 0f
        val wordsLearned   = allProgress.count { it.level >= 3 }

        val sortedDays = studyStreakDao.getAll().map { it.date }.sorted()
        val currentStreak = calculateCurrentStreak(sortedDays.sortedDescending())
        val longestStreak = calculateLongestStreak(sortedDays)

        val matches   = pvpMatchDao.getAll()
        // Player 1 = device owner by convention in local PvP.
        val wins      = matches.count { it.winnerName != null && it.winnerName == it.player1Name }
        val losses    = matches.count { it.winnerName != null && it.winnerName == it.player2Name }
        val draws     = matches.count { it.winnerName == null }
        val bestScore = matches.maxOfOrNull { it.player1Score } ?: 0

        return PlayerStats(
            wordsLearned  = wordsLearned,
            accuracy      = accuracy,
            currentStreak = currentStreak,
            longestStreak = longestStreak,
            pvpWins       = wins,
            pvpLosses     = losses,
            pvpDraws      = draws,
            bestPvpScore  = bestScore,
        )
    }

    suspend fun getWordStats(): List<WordStat> {
        val allProgress = progressDao.getAll()
        val wordMap     = wordDao.getAllWordsOnce().associateBy { it.id }

        return allProgress.mapNotNull { progress ->
            val word   = wordMap[progress.wordId] ?: return@mapNotNull null
            val rarity = runCatching { Rarity.valueOf(word.rarity) }.getOrElse { Rarity.COMMON }
            val total     = progress.correctCount + progress.incorrectCount
            val errorRate = if (total > 0) progress.incorrectCount.toFloat() / total else 0f
            WordStat(
                wordId       = word.id,
                original     = word.original,
                translation  = word.translation,
                rarity       = rarity,
                encounters   = total,
                errorRate    = errorRate,
                level        = progress.level,
                nextReviewAt = progress.nextReviewAt,
            )
        }
    }

    /**
     * Returns up to [limit] words with a high error rate (> [minErrorRate]) and
     * at least [minEncounters] attempts, sorted worst-first.
     *
     * @param source "both" | "pve_only" | "pvp_only"
     */
    suspend fun getProblemWords(
        source: String = "both",
        minEncounters: Int = 2,
        minErrorRate: Float = 0.30f,
        limit: Int = 25,
    ): List<Word> {
        val allProgress = progressDao.getAll()
        val wordMap = wordDao.getAllWordsOnce().associateBy { it.id }

        return allProgress.mapNotNull { p ->
            val word = wordMap[p.wordId] ?: return@mapNotNull null
            val (encounters, errors) = when (source) {
                "pve_only" -> {
                    val pveCorrect   = p.correctCount - p.pvpCorrectCount
                    val pveIncorrect = p.incorrectCount - p.pvpIncorrectCount
                    (pveCorrect + pveIncorrect) to pveIncorrect
                }
                "pvp_only" -> {
                    (p.pvpCorrectCount + p.pvpIncorrectCount) to p.pvpIncorrectCount
                }
                else -> (p.correctCount + p.incorrectCount) to p.incorrectCount
            }
            if (encounters < minEncounters) return@mapNotNull null
            val errorRate = errors.toFloat() / encounters
            if (errorRate <= minErrorRate) return@mapNotNull null
            Pair(errorRate, word)
        }
            .sortedByDescending { it.first }
            .take(limit)
            .map { (_, entity) ->
                val rarity = runCatching { Rarity.valueOf(entity.rarity) }.getOrElse { Rarity.COMMON }
                Word(
                    id              = entity.id,
                    original        = entity.original,
                    translation     = entity.translation,
                    definition      = entity.definition,
                    example         = entity.example,
                    rarity          = rarity,
                    languagePair    = entity.languagePair,
                    pos             = entity.pos,
                    semanticGroup   = entity.semanticGroup,
                    transliteration = entity.transliteration,
                    definitionNative = entity.definitionNative,
                    exampleNative   = entity.exampleNative,
                    isFillInBlankSafe = entity.isFillInBlankSafe,
                )
            }
    }

    /** Returns the number of problem words matching the given source filter. */
    suspend fun getProblemWordCount(source: String = "both", minEncounters: Int = 2): Int =
        getProblemWords(source, minEncounters).size

    private fun calculateCurrentStreak(sortedDesc: List<Long>): Int {
        if (sortedDesc.isEmpty()) return 0
        var streak   = 0
        var expected = todayMs()
        for (day in sortedDesc) {
            if (day == expected) { streak++; expected -= DAY_MS }
            else if (day < expected) break
        }
        return streak
    }

    private fun calculateLongestStreak(sortedAsc: List<Long>): Int {
        if (sortedAsc.isEmpty()) return 0
        var longest = 1
        var current = 1
        for (i in 1 until sortedAsc.size) {
            if (sortedAsc[i] - sortedAsc[i - 1] == DAY_MS) {
                current++
                if (current > longest) longest = current
            } else {
                current = 1
            }
        }
        return longest
    }

}
