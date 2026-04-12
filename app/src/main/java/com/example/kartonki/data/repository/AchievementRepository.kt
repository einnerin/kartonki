package com.example.kartonki.data.repository

import com.example.kartonki.data.db.dao.AchievementDao
import com.example.kartonki.data.db.dao.CollectionDao
import com.example.kartonki.data.db.dao.DeckDao
import com.example.kartonki.data.db.dao.ProgressDao
import com.example.kartonki.data.db.dao.PvpMatchDao
import com.example.kartonki.data.db.dao.StudyStreakDao
import com.example.kartonki.data.db.dao.WordDao
import com.example.kartonki.data.db.entity.AchievementEntity
import com.example.kartonki.data.db.entity.CollectionEntity
import com.example.kartonki.data.db.entity.PvpMatchEntity
import com.example.kartonki.data.db.entity.StudyStreakEntity
import com.example.kartonki.domain.model.AchievementId
import com.example.kartonki.domain.model.AchievementState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import java.util.Calendar
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AchievementRepository @Inject constructor(
    private val achievementDao: AchievementDao,
    private val progressDao: ProgressDao,
    private val studyStreakDao: StudyStreakDao,
    private val pvpMatchDao: PvpMatchDao,
    private val wordDao: WordDao,
    private val deckDao: DeckDao,
    private val collectionDao: CollectionDao,
) {
    private val _newlyUnlocked = MutableSharedFlow<AchievementId>(extraBufferCapacity = 8)
    val newlyUnlocked: SharedFlow<AchievementId> = _newlyUnlocked.asSharedFlow()

    suspend fun getAll(): List<AchievementState> {
        val entities = achievementDao.getAll().associateBy { it.id }
        return AchievementId.entries.map { id ->
            val entity = entities[id.name]
            AchievementState(
                id = id,
                unlockedAt = entity?.unlockedAt,
                rewardWordId = entity?.rewardWordId,
            )
        }
    }

    /** Record that a study session happened today and check streak/study achievements. */
    suspend fun recordStudyDay() {
        studyStreakDao.insert(StudyStreakEntity(date = todayMs()))
        checkAll()
    }

    /** Record a completed PvP match and check WINNER achievement. */
    suspend fun recordPvpMatch(
        player1Name: String,
        player2Name: String,
        player1Score: Int,
        player2Score: Int,
    ) {
        val winnerName = when {
            player1Score > player2Score -> player1Name
            player2Score > player1Score -> player2Name
            else -> null
        }
        pvpMatchDao.insert(
            PvpMatchEntity(
                timestamp = System.currentTimeMillis(),
                player1Name = player1Name,
                player2Name = player2Name,
                player1Score = player1Score,
                player2Score = player2Score,
                winnerName = winnerName,
            )
        )
        if (winnerName != null) checkWinner()
        checkLegend()
    }

    suspend fun checkAll() {
        checkFirstSteps()
        checkExpert()
        checkPolyglot()
        checkWinner()
        checkStreak()
        checkCollector()
        checkLegend()
    }

    suspend fun checkAfterDeckChange() {
        checkCollector()
        checkLegend()
    }

    private suspend fun checkFirstSteps() {
        if (isUnlocked(AchievementId.FIRST_STEPS)) return
        val all = progressDao.getAll()
        val totalCorrect = all.sumOf { it.correctCount }
        if (totalCorrect >= 10) unlock(AchievementId.FIRST_STEPS)
    }

    private suspend fun checkExpert() {
        if (isUnlocked(AchievementId.EXPERT)) return
        if (progressDao.getLearnedCount() >= 50) unlock(AchievementId.EXPERT)
    }

    private suspend fun checkPolyglot() {
        if (isUnlocked(AchievementId.POLYGLOT)) return
        if (progressDao.getLearnedCount() >= 200) unlock(AchievementId.POLYGLOT)
    }

    private suspend fun checkWinner() {
        if (isUnlocked(AchievementId.WINNER)) return
        if (pvpMatchDao.getMatchesWithWinnerCount() >= 1) unlock(AchievementId.WINNER)
    }

    private suspend fun checkStreak() {
        if (isUnlocked(AchievementId.STREAK)) return
        val streak = calculateCurrentStreak()
        if (streak >= 7) unlock(AchievementId.STREAK)
    }

    private suspend fun checkCollector() {
        if (isUnlocked(AchievementId.COLLECTOR)) return
        val decks = deckDao.getDecksOnce()
        for (deck in decks) {
            if (deckDao.getCardCountForDeck(deck.id) >= 20) {
                unlock(AchievementId.COLLECTOR)
                return
            }
        }
    }

    private suspend fun checkLegend() {
        if (isUnlocked(AchievementId.LEGEND)) return
        val entities = achievementDao.getAll().associateBy { it.id }
        val othersAllUnlocked = AchievementId.entries
            .filter { it != AchievementId.LEGEND }
            .all { entities[it.name]?.unlockedAt != null }
        if (othersAllUnlocked) unlock(AchievementId.LEGEND)
    }

    private suspend fun unlock(id: AchievementId) {
        val word = wordDao.getWordByOriginal(id.rewardWordOriginal)
        achievementDao.upsert(
            AchievementEntity(
                id = id.name,
                unlockedAt = System.currentTimeMillis(),
                rewardWordId = word?.id,
            )
        )
        if (word != null) {
            collectionDao.insertAll(listOf(CollectionEntity(wordId = word.id)))
        }
        _newlyUnlocked.emit(id)
    }

    private suspend fun isUnlocked(id: AchievementId): Boolean =
        achievementDao.getById(id.name)?.unlockedAt != null

    private suspend fun calculateCurrentStreak(): Int {
        val days = studyStreakDao.getAll().map { it.date }
        if (days.isEmpty()) return 0
        var streak = 0
        var expected = todayMs()
        for (day in days) {
            if (day == expected) { streak++; expected -= DAY_MS }
            else if (day < expected) break
        }
        return streak
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
