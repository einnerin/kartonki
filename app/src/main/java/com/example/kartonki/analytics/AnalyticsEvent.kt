package com.example.kartonki.analytics

/**
 * Типизированные события аналитики. Каждый case = одно событие в Firebase.
 *
 * Правило имён: snake_case, префикс указывает подсистему (pvp_, deck_, session_, ...).
 * Параметры — примитивы или строки (Firebase-ограничение: String, Long, Double, Boolean).
 *
 * Полный план событий и когда они триггерятся — в docs/claude/analytics-plan.md.
 */
sealed class AnalyticsEvent(val name: String, val params: Map<String, Any?>) {

    // ── Engagement (6) ────────────────────────────────────────────────────────

    /** Вход в любую сессию (study / pvp / problem words). */
    data class SessionStarted(
        val mode: SessionMode,
        val deckLevel: Int?,
        val deckSize: Int?,
        val deckAvgRarity: String?,
    ) : AnalyticsEvent("session_started", mapOf(
        "mode" to mode.tag,
        "deck_level" to deckLevel,
        "deck_size" to deckSize,
        "deck_avg_rarity" to deckAvgRarity,
    ))

    /** Нормальное завершение сессии (пользователь дошёл до конца). */
    data class SessionFinished(
        val mode: SessionMode,
        val durationSec: Long,
        val wordsReviewed: Int,
        val correctCount: Int,
        val completed: Boolean,
    ) : AnalyticsEvent("session_finished", mapOf(
        "mode" to mode.tag,
        "duration_sec" to durationSec,
        "words_reviewed" to wordsReviewed,
        "correct_count" to correctCount,
        "completed" to completed,
    ))

    /** Сессия прервалась (приложение свёрнуто/убито). */
    data class SessionAbandoned(
        val mode: SessionMode,
        val completedPercent: Int,
        val reason: AbandonReason,
    ) : AnalyticsEvent("session_abandoned", mapOf(
        "mode" to mode.tag,
        "completed_percent" to completedPercent,
        "reason" to reason.tag,
    ))

    /** Переход между табами главной навигации. Дебаунс — один event на таб за сессию. */
    data class TabSelected(val tabName: String) : AnalyticsEvent(
        "tab_selected",
        mapOf("tab_name" to tabName),
    )

    /** Streak продлён — пользователь позанимался сегодня. */
    data class StreakExtended(
        val newLength: Int,
        val previousLength: Int,
    ) : AnalyticsEvent("streak_extended", mapOf(
        "new_length" to newLength,
        "previous_length" to previousLength,
    ))

    /** Streak сломался — пропуск дня. */
    data class StreakBroken(val lostLength: Int) : AnalyticsEvent(
        "streak_broken",
        mapOf("lost_length" to lostLength),
    )

    // ── Learning (7) — скелет, реализуются в Фазе 2 ───────────────────────────

    data class WordSeen(
        val wordId: Long,
        val setId: Int,
        val rarity: String,
        val languagePair: String,
        val sessionMode: SessionMode,
    ) : AnalyticsEvent("word_seen", mapOf(
        "word_id" to wordId,
        "set_id" to setId,
        "rarity" to rarity,
        "language_pair" to languagePair,
        "session_mode" to sessionMode.tag,
    ))

    data class QuizAnswered(
        val wordId: Long,
        val quizType: String,
        val correct: Boolean,
        val responseMs: Long,
        val distractorCount: Int,
        val attemptNumber: Int,
    ) : AnalyticsEvent("quiz_answered", mapOf(
        "word_id" to wordId,
        "quiz_type" to quizType,
        "correct" to correct,
        "response_ms" to responseMs,
        "distractor_count" to distractorCount,
        "attempt_number" to attemptNumber,
    ))

    data class CardRarityPromoted(
        val wordId: Long,
        val fromRarity: String,
        val toRarity: String,
        val cumulativeAttempts: Int,
    ) : AnalyticsEvent("card_rarity_promoted", mapOf(
        "word_id" to wordId,
        "from_rarity" to fromRarity,
        "to_rarity" to toRarity,
        "cumulative_attempts" to cumulativeAttempts,
    ))

    data class ProblemWordReviewed(
        val wordId: Long,
        val failCountBefore: Int,
        val correctNow: Boolean,
    ) : AnalyticsEvent("problem_word_reviewed", mapOf(
        "word_id" to wordId,
        "fail_count_before" to failCountBefore,
        "correct_now" to correctNow,
    ))

    data class SetOpened(
        val setId: Int,
        val firstTime: Boolean,
        val fromScreen: String,
    ) : AnalyticsEvent("set_opened", mapOf(
        "set_id" to setId,
        "first_time" to firstTime,
        "from_screen" to fromScreen,
    ))

    data class SetCompleted(
        val setId: Int,
        val daysSinceFirstOpen: Int,
        val totalAttempts: Int,
    ) : AnalyticsEvent("set_completed", mapOf(
        "set_id" to setId,
        "days_since_first_open" to daysSinceFirstOpen,
        "total_attempts" to totalAttempts,
    ))

    data class ProblemWordsSessionCompleted(
        val wordsReviewed: Int,
        val learnedCount: Int,
        val failStreakWords: Int,
    ) : AnalyticsEvent("problem_words_session_completed", mapOf(
        "words_reviewed" to wordsReviewed,
        "learned_count" to learnedCount,
        "fail_streak_words" to failStreakWords,
    ))

    // ── Decks (4) — скелет, реализуются в Фазе 3 ──────────────────────────────

    data class DeckBuilt(
        val size: Int,
        val avgRarity: String,
        val commonCount: Int,
        val uncommonCount: Int,
        val rareCount: Int,
        val epicCount: Int,
        val legendaryCount: Int,
        val languagePair: String,
        val buildDurationSec: Long,
        val cardsConsidered: Int,
    ) : AnalyticsEvent("deck_built", mapOf(
        "size" to size,
        "avg_rarity" to avgRarity,
        "common_count" to commonCount,
        "uncommon_count" to uncommonCount,
        "rare_count" to rareCount,
        "epic_count" to epicCount,
        "legendary_count" to legendaryCount,
        "language_pair" to languagePair,
        "build_duration_sec" to buildDurationSec,
        "cards_considered" to cardsConsidered,
    ))

    data class DeckEdited(
        val sizeDelta: Int,
        val avgRarityAfter: String,
        val languagePair: String,
    ) : AnalyticsEvent("deck_edited", mapOf(
        "size_delta" to sizeDelta,
        "avg_rarity_after" to avgRarityAfter,
        "language_pair" to languagePair,
    ))

    data class DeckDeleted(
        val ageDays: Int,
        val wasEverUsed: Boolean,
    ) : AnalyticsEvent("deck_deleted", mapOf(
        "age_days" to ageDays,
        "was_ever_used" to wasEverUsed,
    ))

    data class DeckSelectedForSession(
        val deckId: Long,
        val deckLevel: Int,
        val deckSize: Int,
        val forMode: SessionMode,
    ) : AnalyticsEvent("deck_selected_for_session", mapOf(
        "deck_id" to deckId,
        "deck_level" to deckLevel,
        "deck_size" to deckSize,
        "for_mode" to forMode.tag,
    ))

    // ── PvP Local (2) ─────────────────────────────────────────────────────────

    data class PvpLocalMatchStarted(
        val p1DeckLevel: Int,
        val p1DeckSize: Int,
        val p2DeckLevel: Int,
        val p2DeckSize: Int,
    ) : AnalyticsEvent("pvp_local_match_started", mapOf(
        "p1_deck_level" to p1DeckLevel,
        "p1_deck_size" to p1DeckSize,
        "p2_deck_level" to p2DeckLevel,
        "p2_deck_size" to p2DeckSize,
    ))

    data class PvpLocalMatchFinished(
        val rounds: Int,
        val winnerSlot: Int,  // 1 | 2 | 0 (draw)
        val durationSec: Long,
        val surrendered: Boolean,
        val surrenderedBySlot: Int?,
        val roundsWonP1: Int,
        val roundsWonP2: Int,
    ) : AnalyticsEvent("pvp_local_match_finished", mapOf(
        "rounds" to rounds,
        "winner_slot" to winnerSlot,
        "duration_sec" to durationSec,
        "surrendered" to surrendered,
        "surrendered_by_slot" to surrenderedBySlot,
        "rounds_won_p1" to roundsWonP1,
        "rounds_won_p2" to roundsWonP2,
    ))

    // ── PvP Online (5) ────────────────────────────────────────────────────────

    data class PvpOnlineMatchmakingStarted(
        val deckLevel: Int,
        val deckSize: Int,
        val deckAvgRarity: String,
    ) : AnalyticsEvent("pvp_online_matchmaking_started", mapOf(
        "deck_level" to deckLevel,
        "deck_size" to deckSize,
        "deck_avg_rarity" to deckAvgRarity,
    ))

    data class PvpOnlineMatchmakingResult(
        val outcome: MatchmakingOutcome,
        val durationSec: Long,
    ) : AnalyticsEvent("pvp_online_matchmaking_result", mapOf(
        "outcome" to outcome.tag,
        "duration_sec" to durationSec,
    ))

    data class PvpOnlineMatchStarted(
        val ownDeckLevel: Int,
        val ownDeckSize: Int,
        val opponentEstimatedLevel: Int?,
    ) : AnalyticsEvent("pvp_online_match_started", mapOf(
        "own_deck_level" to ownDeckLevel,
        "own_deck_size" to ownDeckSize,
        "opponent_estimated_level" to opponentEstimatedLevel,
    ))

    data class PvpOnlineMatchFinished(
        val rounds: Int,
        val won: Boolean,
        val durationSec: Long,
        val surrendered: Boolean,
        val surrenderedByOpponent: Boolean,
    ) : AnalyticsEvent("pvp_online_match_finished", mapOf(
        "rounds" to rounds,
        "won" to won,
        "duration_sec" to durationSec,
        "surrendered" to surrendered,
        "surrendered_by_opponent" to surrenderedByOpponent,
    ))

    data class PvpOnlineDisconnect(
        val reason: DisconnectReason,
        val roundNumber: Int,
    ) : AnalyticsEvent("pvp_online_disconnect", mapOf(
        "reason" to reason.tag,
        "round_number" to roundNumber,
    ))

    // ── Collection & Rewards (3) ──────────────────────────────────────────────

    data class PackOpened(
        val packType: String,
        val newCardsCount: Int,
        val duplicatesCount: Int,
        val highestRarityObtained: String,
        val packSource: String,   // "purchase" | "achievement"
    ) : AnalyticsEvent("pack_opened", mapOf(
        "pack_type" to packType,
        "new_cards_count" to newCardsCount,
        "duplicates_count" to duplicatesCount,
        "highest_rarity_obtained" to highestRarityObtained,
        "pack_source" to packSource,
    ))

    data class AchievementUnlocked(
        val achievementId: String,
        val daysSinceFirstOpen: Int,
    ) : AnalyticsEvent("achievement_unlocked", mapOf(
        "achievement_id" to achievementId,
        "days_since_first_open" to daysSinceFirstOpen,
    ))

    data class CardRetainedAsFavorite(
        val wordId: Long,
        val rarity: String,
    ) : AnalyticsEvent("card_retained_as_favorite", mapOf(
        "word_id" to wordId,
        "rarity" to rarity,
    ))

    // ── Auth & Technical (3) ──────────────────────────────────────────────────

    data class LoginMethod(
        val method: String,        // "google" | "anonymous"
        val firstTime: Boolean,
    ) : AnalyticsEvent("login_method", mapOf(
        "method" to method,
        "first_time" to firstTime,
    ))

    data class AppCrash(
        val errorType: String,
        val screen: String?,
        val isFatal: Boolean,
    ) : AnalyticsEvent("app_crash", mapOf(
        "error_type" to errorType,
        "screen" to screen,
        "is_fatal" to isFatal,
    ))

    /** Маркер включения tester-mode. Также вызывает setUserId("tester"). */
    object TesterModeEnabled : AnalyticsEvent("tester_mode_enabled", emptyMap())
}

enum class SessionMode(val tag: String) {
    PVE("pve"),
    PVE_PROBLEM_WORDS("pve_problem_words"),
    PVP_LOCAL("pvp_local"),
    PVP_ONLINE("pvp_online"),
    SET_STUDY("set_study"),
}

enum class AbandonReason(val tag: String) {
    BACKGROUND("background"),
    BACK_PRESS("back"),
    TIMEOUT("timeout"),
    UNKNOWN("unknown"),
}

enum class MatchmakingOutcome(val tag: String) {
    FOUND("found"),
    CANCELLED("cancelled"),
    TIMEOUT("timeout"),
    ERROR("error"),
}

enum class DisconnectReason(val tag: String) {
    TIMEOUT("timeout"),
    SERVER_ERROR("server"),
    NETWORK("network"),
    OPPONENT_LEFT("opponent_left"),
}
