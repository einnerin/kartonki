package com.example.kartonki.data.repository

import com.example.kartonki.data.db.dao.ProgressDao
import com.example.kartonki.data.db.dao.PvpMatchDao
import com.example.kartonki.data.db.dao.StudyStreakDao
import com.example.kartonki.data.db.dao.WordDao
import com.example.kartonki.domain.model.PlayerStats
import com.example.kartonki.domain.model.Rarity
import com.example.kartonki.domain.model.WordStat
import com.example.kartonki.domain.model.WordStatSort
import java.util.Calendar
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
        val wins      = matches.count { it.winnerName != null }
        val losses    = matches.count { it.winnerName == null }
        val bestScore = matches.maxOfOrNull { maxOf(it.player1Score, it.player2Score) } ?: 0

        return PlayerStats(
            wordsLearned  = wordsLearned,
            accuracy      = accuracy,
            currentStreak = currentStreak,
            longestStreak = longestStreak,
            pvpWins       = wins,
            pvpLosses     = losses,
            pvpDraws      = matches.count { it.winnerName == null },
            bestPvpScore  = bestScore,
        )
    }

    suspend fun getWordStats(
        sortBy: WordStatSort,
        rarityFilter: Rarity?,
    ): List<WordStat> {
        val allProgress = progressDao.getAll()
        val wordMap     = wordDao.getAllWordsOnce().associateBy { it.id }

        val stats = allProgress.mapNotNull { progress ->
            val word   = wordMap[progress.wordId] ?: return@mapNotNull null
            val rarity = runCatching { Rarity.valueOf(word.rarity) }.getOrElse { Rarity.COMMON }
            if (rarityFilter != null && rarity != rarityFilter) return@mapNotNull null
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

        return when (sortBy) {
            WordStatSort.MOST_ERRORS       -> stats.sortedByDescending { it.errorRate }
            WordStatSort.EASIEST           -> stats.filter { it.encounters > 0 }.sortedBy { it.errorRate }
            WordStatSort.MOST_ENCOUNTERS   -> stats.sortedByDescending { it.encounters }
            WordStatSort.RECENTLY_STUDIED  -> stats.sortedByDescending { it.nextReviewAt }
        }
    }

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

    private fun todayMs(): Long {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)
        return cal.timeInMillis
    }

    companion object {
        private const val DAY_MS = 86_400_000L
    }
}
