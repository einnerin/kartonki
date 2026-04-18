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

    // Achievements only transition locked → unlocked, never backwards.
    // Caching the unlocked set avoids a DB round-trip per check.
    private val unlockedCache: MutableSet<String> = mutableSetOf()

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

    /**
     * Called when a study session completes.
     * @param incorrectCount number of wrong answers in the session (0 = perfect)
     */
    suspend fun recordStudyDay(incorrectCount: Int = 0) {
        studyStreakDao.insert(StudyStreakEntity(date = todayMs()))
        checkFirstLesson()
        checkDiligent()
        checkExpert()
        checkPolyglot()
        checkStreak5()
        checkStreak7()
        checkLegend()
        // Hidden
        checkNightOwl()
        checkPerfectionist(incorrectCount)
        checkDeepLearner()
        checkCenturion()
        checkMondayScholar()
        checkWeeklyGrind()
        checkRusty()
        checkExplorer()
        checkLongWord()
    }

    /**
     * Called when a PvP match ends.
     */
    suspend fun recordPvpMatch(
        player1Name: String,
        player2Name: String,
        player1Score: Int,
        player2Score: Int,
        wasSurrender: Boolean = false,
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
                wasSurrender = wasSurrender,
            )
        )
        checkFirstFight()
        if (winnerName != null) checkFirstWin()
        checkLegend()
        // Hidden
        checkDominator(player1Score, player2Score, winnerName)
        checkDrawMaster(winnerName)
        checkGoldenShot(player1Score, player2Score)
        checkVeteran()
        checkMarathon()
        if (wasSurrender) checkWhiteFlag()
    }

    suspend fun checkAfterDeckChange() {
        checkCollector()
        checkLegend()
    }

    /** Called once on app launch from MainViewModel. */
    suspend fun checkFirstLaunch() {
        if (isUnlocked(AchievementId.FIRST_LAUNCH)) return
        unlock(AchievementId.FIRST_LAUNCH)
    }

    // ── Visible achievement checks ────────────────────────────────────────────

    private suspend fun checkFirstLesson() {
        if (isUnlocked(AchievementId.FIRST_LESSON)) return
        if (studyStreakDao.getCount() >= 1) unlock(AchievementId.FIRST_LESSON)
    }

    private suspend fun checkDiligent() {
        if (isUnlocked(AchievementId.DILIGENT)) return
        if (studyStreakDao.getCount() >= 10) unlock(AchievementId.DILIGENT)
    }

    private suspend fun checkFirstFight() {
        if (isUnlocked(AchievementId.FIRST_FIGHT)) return
        if (pvpMatchDao.getMatchCount() >= 1) unlock(AchievementId.FIRST_FIGHT)
    }

    private suspend fun checkFirstWin() {
        if (isUnlocked(AchievementId.FIRST_WIN)) return
        if (pvpMatchDao.getMatchesWithWinnerCount() >= 1) unlock(AchievementId.FIRST_WIN)
    }

    private suspend fun checkStreak5() {
        if (isUnlocked(AchievementId.STREAK_5)) return
        if (calculateCurrentStreak() >= 5) unlock(AchievementId.STREAK_5)
    }

    private suspend fun checkExpert() {
        if (isUnlocked(AchievementId.EXPERT)) return
        if (progressDao.getLearnedCount() >= EXPERT_THRESHOLD) unlock(AchievementId.EXPERT)
    }

    private suspend fun checkPolyglot() {
        if (isUnlocked(AchievementId.POLYGLOT)) return
        if (progressDao.getLearnedCount() >= POLYGLOT_THRESHOLD) unlock(AchievementId.POLYGLOT)
    }

    private suspend fun checkStreak7() {
        if (isUnlocked(AchievementId.STREAK_7)) return
        if (calculateCurrentStreak() >= 7) unlock(AchievementId.STREAK_7)
    }

    private suspend fun checkCollector() {
        if (isUnlocked(AchievementId.COLLECTOR)) return
        val decks = deckDao.getDecksOnce()
        for (deck in decks) {
            if (deckDao.getOwnedCardCountForDeck(deck.id) >= COLLECTOR_MIN_CARDS) {
                unlock(AchievementId.COLLECTOR)
                return
            }
        }
    }

    private suspend fun checkLegend() {
        if (isUnlocked(AchievementId.LEGEND)) return
        val entities = achievementDao.getAll().associateBy { it.id }
        val allVisibleDone = AchievementId.entries
            .filter { !it.isHidden && it != AchievementId.LEGEND }
            .all { entities[it.name]?.unlockedAt != null }
        if (allVisibleDone) unlock(AchievementId.LEGEND)
    }

    // ── Hidden achievement checks ─────────────────────────────────────────────

    private suspend fun checkDominator(p1Score: Int, p2Score: Int, winnerName: String?) {
        if (isUnlocked(AchievementId.DOMINATOR)) return
        if (winnerName == null) return
        val hi = maxOf(p1Score, p2Score)
        val lo = minOf(p1Score, p2Score)
        if (lo > 0 && hi.toFloat() / lo >= 2f) unlock(AchievementId.DOMINATOR)
    }

    private suspend fun checkNightOwl() {
        if (isUnlocked(AchievementId.NIGHT_OWL)) return
        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        if (hour >= NIGHT_OWL_HOUR) unlock(AchievementId.NIGHT_OWL)
    }

    private suspend fun checkPerfectionist(incorrectCount: Int) {
        if (isUnlocked(AchievementId.PERFECTIONIST)) return
        if (incorrectCount == 0) unlock(AchievementId.PERFECTIONIST)
    }

    private suspend fun checkDeepLearner() {
        if (isUnlocked(AchievementId.DEEP_LEARNER)) return
        if (progressDao.getWordCountAtMinLevel(5) >= DEEP_LEARNER_MIN_WORDS) unlock(AchievementId.DEEP_LEARNER)
    }

    private suspend fun checkVeteran() {
        if (isUnlocked(AchievementId.VETERAN)) return
        if (pvpMatchDao.getMatchCount() >= 10) unlock(AchievementId.VETERAN)
    }

    private suspend fun checkCenturion() {
        if (isUnlocked(AchievementId.CENTURION)) return
        if (progressDao.getTotalCorrectCount() >= 100) unlock(AchievementId.CENTURION)
    }

    private suspend fun checkDrawMaster(winnerName: String?) {
        if (isUnlocked(AchievementId.DRAW_MASTER)) return
        if (winnerName == null) unlock(AchievementId.DRAW_MASTER)
    }

    private suspend fun checkMondayScholar() {
        if (isUnlocked(AchievementId.MONDAY_SCHOLAR)) return
        val dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
        if (dayOfWeek == Calendar.MONDAY) unlock(AchievementId.MONDAY_SCHOLAR)
    }

    private suspend fun checkGoldenShot(p1Score: Int, p2Score: Int) {
        if (isUnlocked(AchievementId.GOLDEN_SHOT)) return
        if (maxOf(p1Score, p2Score) >= GOLDEN_SHOT_MIN_SCORE) unlock(AchievementId.GOLDEN_SHOT)
    }

    private suspend fun checkWeeklyGrind() {
        if (isUnlocked(AchievementId.WEEKLY_GRIND)) return
        val weekAgoMs = todayMs() - 6 * DAY_MS
        if (studyStreakDao.getCountSince(weekAgoMs) >= 5) unlock(AchievementId.WEEKLY_GRIND)
    }

    private suspend fun checkWhiteFlag() {
        if (isUnlocked(AchievementId.WHITE_FLAG)) return
        unlock(AchievementId.WHITE_FLAG)
    }

    private suspend fun checkExplorer() {
        if (isUnlocked(AchievementId.EXPLORER)) return
        if (progressDao.getDistinctSemanticGroupCount() >= 5) unlock(AchievementId.EXPLORER)
    }

    private suspend fun checkMarathon() {
        if (isUnlocked(AchievementId.MARATHON)) return
        if (pvpMatchDao.getMatchCountSince(todayMs()) >= 3) unlock(AchievementId.MARATHON)
    }

    private suspend fun checkRusty() {
        if (isUnlocked(AchievementId.RUSTY)) return
        val days = studyStreakDao.getAll().map { it.date }
        if (days.size < 2) return
        // days are sorted DESC; [0] = today, [1] = last previous day
        val gap = (days[0] - days[1]) / DAY_MS
        if (gap >= RUSTY_GAP_DAYS) unlock(AchievementId.RUSTY)
    }

    private suspend fun checkLongWord() {
        if (isUnlocked(AchievementId.LONG_WORD)) return
        if (progressDao.getProgressWithLongWordCount(13) >= 1) unlock(AchievementId.LONG_WORD)
    }

    // ── Internals ─────────────────────────────────────────────────────────────

    private companion object {
        const val EXPERT_THRESHOLD       = 50
        const val POLYGLOT_THRESHOLD     = 200
        const val COLLECTOR_MIN_CARDS    = 20
        const val DEEP_LEARNER_MIN_WORDS = 20
        const val GOLDEN_SHOT_MIN_SCORE  = 50
        const val NIGHT_OWL_HOUR         = 23
        const val RUSTY_GAP_DAYS         = 7L
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
        unlockedCache.add(id.name)
        _newlyUnlocked.emit(id)
    }

    private suspend fun isUnlocked(id: AchievementId): Boolean {
        if (id.name in unlockedCache) return true
        val result = achievementDao.getById(id.name)?.unlockedAt != null
        if (result) unlockedCache.add(id.name)
        return result
    }

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

}
