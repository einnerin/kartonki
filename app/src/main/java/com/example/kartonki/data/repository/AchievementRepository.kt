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
import com.example.kartonki.data.preferences.UserPreferencesRepository
import com.example.kartonki.domain.model.AchievementId
import com.example.kartonki.domain.model.AchievementState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import java.util.Calendar
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Per-language achievement repository. The user's currently-studied language
 * (`prefs.getLanguagePair()`) is read at the start of each public entry point
 * and used to scope progress, unlocks, and reward cards.
 *
 * The same achievement (e.g. FIRST_LESSON) can be unlocked separately for each
 * language — once for en-ru, once for he-ru — granting a language-specific
 * reward card each time.
 */
@Singleton
class AchievementRepository @Inject constructor(
    private val achievementDao: AchievementDao,
    private val progressDao: ProgressDao,
    private val studyStreakDao: StudyStreakDao,
    private val pvpMatchDao: PvpMatchDao,
    private val wordDao: WordDao,
    private val deckDao: DeckDao,
    private val collectionDao: CollectionDao,
    private val prefs: UserPreferencesRepository,
    private val analytics: com.example.kartonki.analytics.AnalyticsManager,
) {
    private val _newlyUnlocked = MutableSharedFlow<AchievementId>(extraBufferCapacity = 8)
    val newlyUnlocked: SharedFlow<AchievementId> = _newlyUnlocked.asSharedFlow()

    /** unlockedCache key = "$id|$languagePair" — language-aware. */
    private val unlockedCache: MutableSet<String> = mutableSetOf()

    private fun cacheKey(id: AchievementId, lang: String) = "${id.name}|$lang"

    /** Returns achievement states for the currently-studied language. */
    suspend fun getAll(): List<AchievementState> {
        val lang = prefs.getLanguagePair()
        val entities = achievementDao.getAllForLang(lang).associateBy { it.id }
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
        val lang = prefs.getLanguagePair()
        val previousStreak = calculateCurrentStreak(lang)
        studyStreakDao.insert(StudyStreakEntity(date = todayMs(), languagePair = lang))
        val newStreak = calculateCurrentStreak(lang)
        if (newStreak > previousStreak) {
            analytics.log(
                com.example.kartonki.analytics.AnalyticsEvent.StreakExtended(
                    newLength = newStreak,
                    previousLength = previousStreak,
                )
            )
        } else if (newStreak < previousStreak) {
            analytics.log(
                com.example.kartonki.analytics.AnalyticsEvent.StreakBroken(
                    lostLength = previousStreak,
                )
            )
        }
        checkFirstLesson(lang)
        checkDiligent(lang)
        checkExpert(lang)
        checkPolyglot(lang)
        checkStreak5(lang)
        checkStreak7(lang)
        checkLegend(lang)
        // Hidden
        checkNightOwl(lang)
        checkPerfectionist(lang, incorrectCount)
        checkDeepLearner(lang)
        checkCenturion(lang)
        checkMondayScholar(lang)
        checkWeeklyGrind(lang)
        checkRusty(lang)
        checkExplorer(lang)
        checkLongWord(lang)
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
        val lang = prefs.getLanguagePair()
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
                languagePair = lang,
            )
        )
        checkFirstFight(lang)
        if (winnerName != null) checkFirstWin(lang)
        checkLegend(lang)
        // Hidden
        checkDominator(lang, player1Score, player2Score, winnerName)
        checkDrawMaster(lang, winnerName)
        checkGoldenShot(lang, player1Score, player2Score)
        checkVeteran(lang)
        checkMarathon(lang)
        if (wasSurrender) checkWhiteFlag(lang)
    }

    suspend fun checkAfterDeckChange() {
        val lang = prefs.getLanguagePair()
        checkCollector(lang)
        checkLegend(lang)
    }

    // ── Visible achievement checks ────────────────────────────────────────────

    private suspend fun checkFirstLesson(lang: String) {
        if (isUnlocked(AchievementId.FIRST_LESSON, lang)) return
        if (studyStreakDao.getCountForLang(lang) >= 1) unlock(AchievementId.FIRST_LESSON, lang)
    }

    private suspend fun checkDiligent(lang: String) {
        if (isUnlocked(AchievementId.DILIGENT, lang)) return
        if (studyStreakDao.getCountForLang(lang) >= 10) unlock(AchievementId.DILIGENT, lang)
    }

    private suspend fun checkFirstFight(lang: String) {
        if (isUnlocked(AchievementId.FIRST_FIGHT, lang)) return
        if (pvpMatchDao.getMatchCountForLang(lang) >= 1) unlock(AchievementId.FIRST_FIGHT, lang)
    }

    private suspend fun checkFirstWin(lang: String) {
        if (isUnlocked(AchievementId.FIRST_WIN, lang)) return
        if (pvpMatchDao.getMatchesWithWinnerCountForLang(lang) >= 1) unlock(AchievementId.FIRST_WIN, lang)
    }

    private suspend fun checkStreak5(lang: String) {
        if (isUnlocked(AchievementId.STREAK_5, lang)) return
        if (calculateCurrentStreak(lang) >= 5) unlock(AchievementId.STREAK_5, lang)
    }

    private suspend fun checkExpert(lang: String) {
        if (isUnlocked(AchievementId.EXPERT, lang)) return
        if (progressDao.getLearnedCountForLang(lang) >= EXPERT_THRESHOLD) unlock(AchievementId.EXPERT, lang)
    }

    private suspend fun checkPolyglot(lang: String) {
        if (isUnlocked(AchievementId.POLYGLOT, lang)) return
        if (progressDao.getLearnedCountForLang(lang) >= POLYGLOT_THRESHOLD) unlock(AchievementId.POLYGLOT, lang)
    }

    private suspend fun checkStreak7(lang: String) {
        if (isUnlocked(AchievementId.STREAK_7, lang)) return
        if (calculateCurrentStreak(lang) >= 7) unlock(AchievementId.STREAK_7, lang)
    }

    private suspend fun checkCollector(lang: String) {
        if (isUnlocked(AchievementId.COLLECTOR, lang)) return
        val decks = deckDao.getDecksOnce()
        for (deck in decks) {
            if (deckDao.getOwnedCardCountForDeck(deck.id) >= COLLECTOR_MIN_CARDS) {
                unlock(AchievementId.COLLECTOR, lang)
                return
            }
        }
    }

    private suspend fun checkLegend(lang: String) {
        if (isUnlocked(AchievementId.LEGEND, lang)) return
        val entities = achievementDao.getAllForLang(lang).associateBy { it.id }
        val allVisibleDone = AchievementId.entries
            .filter { !it.isHidden && it != AchievementId.LEGEND }
            .all { entities[it.name]?.unlockedAt != null }
        if (allVisibleDone) unlock(AchievementId.LEGEND, lang)
    }

    // ── Hidden achievement checks ─────────────────────────────────────────────

    private suspend fun checkDominator(lang: String, p1Score: Int, p2Score: Int, winnerName: String?) {
        if (isUnlocked(AchievementId.DOMINATOR, lang)) return
        if (winnerName == null) return
        val hi = maxOf(p1Score, p2Score)
        val lo = minOf(p1Score, p2Score)
        if (lo > 0 && hi.toFloat() / lo >= 2f) unlock(AchievementId.DOMINATOR, lang)
    }

    private suspend fun checkNightOwl(lang: String) {
        if (isUnlocked(AchievementId.NIGHT_OWL, lang)) return
        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        if (hour >= NIGHT_OWL_HOUR) unlock(AchievementId.NIGHT_OWL, lang)
    }

    private suspend fun checkPerfectionist(lang: String, incorrectCount: Int) {
        if (isUnlocked(AchievementId.PERFECTIONIST, lang)) return
        if (incorrectCount == 0) unlock(AchievementId.PERFECTIONIST, lang)
    }

    private suspend fun checkDeepLearner(lang: String) {
        if (isUnlocked(AchievementId.DEEP_LEARNER, lang)) return
        if (progressDao.getWordCountAtMinLevelForLang(5, lang) >= DEEP_LEARNER_MIN_WORDS) unlock(AchievementId.DEEP_LEARNER, lang)
    }

    private suspend fun checkVeteran(lang: String) {
        if (isUnlocked(AchievementId.VETERAN, lang)) return
        if (pvpMatchDao.getMatchCountForLang(lang) >= 10) unlock(AchievementId.VETERAN, lang)
    }

    private suspend fun checkCenturion(lang: String) {
        if (isUnlocked(AchievementId.CENTURION, lang)) return
        if (progressDao.getTotalCorrectCountForLang(lang) >= 100) unlock(AchievementId.CENTURION, lang)
    }

    private suspend fun checkDrawMaster(lang: String, winnerName: String?) {
        if (isUnlocked(AchievementId.DRAW_MASTER, lang)) return
        if (winnerName == null) unlock(AchievementId.DRAW_MASTER, lang)
    }

    private suspend fun checkMondayScholar(lang: String) {
        if (isUnlocked(AchievementId.MONDAY_SCHOLAR, lang)) return
        val dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
        if (dayOfWeek == Calendar.MONDAY) unlock(AchievementId.MONDAY_SCHOLAR, lang)
    }

    private suspend fun checkGoldenShot(lang: String, p1Score: Int, p2Score: Int) {
        if (isUnlocked(AchievementId.GOLDEN_SHOT, lang)) return
        if (maxOf(p1Score, p2Score) >= GOLDEN_SHOT_MIN_SCORE) unlock(AchievementId.GOLDEN_SHOT, lang)
    }

    private suspend fun checkWeeklyGrind(lang: String) {
        if (isUnlocked(AchievementId.WEEKLY_GRIND, lang)) return
        val weekAgoMs = todayMs() - 6 * DAY_MS
        if (studyStreakDao.getCountSinceForLang(weekAgoMs, lang) >= 5) unlock(AchievementId.WEEKLY_GRIND, lang)
    }

    private suspend fun checkWhiteFlag(lang: String) {
        if (isUnlocked(AchievementId.WHITE_FLAG, lang)) return
        unlock(AchievementId.WHITE_FLAG, lang)
    }

    private suspend fun checkExplorer(lang: String) {
        if (isUnlocked(AchievementId.EXPLORER, lang)) return
        if (progressDao.getDistinctSemanticGroupCountForLang(lang) >= 5) unlock(AchievementId.EXPLORER, lang)
    }

    private suspend fun checkMarathon(lang: String) {
        if (isUnlocked(AchievementId.MARATHON, lang)) return
        if (pvpMatchDao.getMatchCountSinceForLang(todayMs(), lang) >= 3) unlock(AchievementId.MARATHON, lang)
    }

    private suspend fun checkRusty(lang: String) {
        if (isUnlocked(AchievementId.RUSTY, lang)) return
        val days = studyStreakDao.getAllForLang(lang).map { it.date }
        if (days.size < 2) return
        // days are sorted DESC; [0] = today, [1] = last previous day
        val gap = (days[0] - days[1]) / DAY_MS
        if (gap >= RUSTY_GAP_DAYS) unlock(AchievementId.RUSTY, lang)
    }

    private suspend fun checkLongWord(lang: String) {
        if (isUnlocked(AchievementId.LONG_WORD, lang)) return
        if (progressDao.getProgressWithLongWordCountForLang(13, lang) >= 1) unlock(AchievementId.LONG_WORD, lang)
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

    private suspend fun unlock(id: AchievementId, lang: String) {
        val key = cacheKey(id, lang)
        val alreadyUnlocked = key in unlockedCache
        val original = id.rewardOriginalFor(lang)
        val word = wordDao.getWordByOriginal(original)
        achievementDao.upsert(
            AchievementEntity(
                id = id.name,
                languagePair = lang,
                unlockedAt = System.currentTimeMillis(),
                rewardWordId = word?.id,
            )
        )
        if (!alreadyUnlocked) {
            analytics.log(
                com.example.kartonki.analytics.AnalyticsEvent.AchievementUnlocked(
                    achievementId = id.name,
                    daysSinceFirstOpen = 0,
                )
            )
        }
        if (word != null) {
            collectionDao.insertAll(listOf(CollectionEntity(wordId = word.id)))
        }
        unlockedCache.add(key)
        _newlyUnlocked.emit(id)
    }

    private suspend fun isUnlocked(id: AchievementId, lang: String): Boolean {
        val key = cacheKey(id, lang)
        if (key in unlockedCache) return true
        val result = achievementDao.getById(id.name, lang)?.unlockedAt != null
        if (result) unlockedCache.add(key)
        return result
    }

    private suspend fun calculateCurrentStreak(lang: String): Int {
        val days = studyStreakDao.getAllForLang(lang).map { it.date }
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
