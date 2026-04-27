package com.example.kartonki.data.preferences

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.map
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPreferencesRepository @Inject constructor(
    @ApplicationContext private val context: Context,
) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    init {
        // One-time migration: FREE_PACK_COUNT * 100 → TOKENS_BALANCE.
        val legacyPacks = prefs.getInt("free_pack_count", 0)
        if (legacyPacks > 0) {
            val currentTokens = prefs.getInt("tokens_balance", 0)
            prefs.edit()
                .putInt("tokens_balance", currentTokens + legacyPacks * TOKENS_PER_PACK)
                .putInt("free_pack_count", 0)
                .apply()
        }
    }

    private object Keys {
        const val IS_DARK_THEME            = "is_dark_theme"
        const val USERNAME                 = "username"
        const val AVATAR_CHOICE            = "avatar_choice"
        const val LANGUAGE_PAIR            = "language_pair"
        const val NATIVE_LANGUAGE          = "native_language"
        const val ACTIVITY_COUNT           = "activity_count"
        const val FREE_PACK_COUNT          = "free_pack_count"  // deprecated — migrated to TOKENS_BALANCE
        const val TOKENS_BALANCE           = "tokens_balance"
        const val DAILY_ACTIVITY_COUNT     = "daily_activity_count"
        const val LAST_ACTIVITY_DATE       = "last_activity_date"  // "yyyy-MM-dd" local
        const val PVP_MULTIPLIER_HINT_SEEN = "pvp_multiplier_hint_seen"
        const val DEFINITION_QUIZ_MODE     = "definition_quiz_mode"   // "foreign" | "native" | "both"
        const val QUIZ_TYPES_ENABLED       = "quiz_types_enabled"    // comma-separated keys
        const val PROBLEM_WORDS_SOURCE          = "problem_words_source"   // "both" | "pve_only" | "pvp_only"
        const val PROBLEM_WORDS_ENABLED         = "problem_words_enabled"  // Boolean
        const val PROBLEM_WORDS_MIN_ENCOUNTERS  = "problem_words_min_enc"  // Int: 1/2/3/5/10
        const val PROBLEM_WORDS_CORRECT_TO_LEARN = "problem_words_ctl"     // Int: 1/2/3/5
        const val PROBLEM_WORDS_HINT_SHOWN      = "problem_words_hint"     // Boolean
        const val PROBLEM_SESSION_COUNTS        = "problem_session_counts" // DEPRECATED: "id:count,id:count,..." — replaced by PROBLEM_SESSION_MASTERED_TYPES
        const val PROBLEM_SESSION_MASTERED_TYPES = "problem_session_mastered_types" // "id:type1|type2;id:type1,..." — distinct quiz types answered correctly per word
        const val PROBLEM_WORDS_DISMISSED_IDS   = "problem_words_dismissed" // "id,id,..." — words the user removed from problem list permanently
        const val SESSION_EXCLUDED_WORD_IDS     = "session_excluded_ids"  // "id,id,..." temp
        const val PROBLEM_CHIP_HINT_SHOWN       = "problem_chip_hint"     // Boolean
        const val WORD_DATA_VERSION             = "word_data_version"          // Int
        const val PRESET_DECKS_VERSION          = "preset_decks_version"       // Int
        const val PRESET_DECKS_WORD_VERSION     = "preset_decks_word_version"  // Int: WordDataVersion stored at last deck rebuild
        const val SEARCH_BACK_BEHAVIOR          = "search_back_behavior"        // "clear" | "restore"
        const val TESTER_MODE_ENABLED           = "tester_mode_enabled"         // Boolean — анонимный маркер для фильтрации аналитики
        const val INSTALL_COHORT_WEEK           = "install_cohort_week"         // String "YYYY-WW" — для cohort-аналитики
    }

    companion object {
        val KNOWN_QUIZ_TYPES:   Set<String> = setOf("translation", "definition", "fill_blank")
        val DEFAULT_QUIZ_TYPES: Set<String> = KNOWN_QUIZ_TYPES

        const val TOKENS_PER_PACK             = 100
        const val ACTIVITIES_PER_TOKEN_GRANT  = 3
        const val DAILY_ACTIVITY_LIMIT        = 9   // 3 grants × 3 activities = 300 tokens / day
    }

    private fun todayStr(): String =
        SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Date())

    /** Emits on every SharedPreferences change. */
    private fun prefsFlow(): Flow<SharedPreferences> = callbackFlow {
        trySend(prefs)
        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, _ ->
            trySend(prefs)
        }
        prefs.registerOnSharedPreferenceChangeListener(listener)
        awaitClose { prefs.unregisterOnSharedPreferenceChangeListener(listener) }
    }

    val isDarkTheme: Flow<Boolean>      = prefsFlow().map { it.getBoolean(Keys.IS_DARK_THEME, true) }
    val username: Flow<String>          = prefsFlow().map { it.getString(Keys.USERNAME, "Игрок") ?: "Игрок" }
    val avatarChoice: Flow<String>      = prefsFlow().map { it.getString(Keys.AVATAR_CHOICE, "🎮") ?: "🎮" }
    val languagePair: Flow<String>      = prefsFlow().map { it.getString(Keys.LANGUAGE_PAIR, "en-ru") ?: "en-ru" }
    val nativeLanguage: Flow<String>    = prefsFlow().map { it.getString(Keys.NATIVE_LANGUAGE, "ru") ?: "ru" }
    /**
     * Progress toward the next 100-token grant (0..2). Resets at midnight along
     * with [dailyActivityCount] — same temporal scope so the two counters never
     * disagree visually (e.g. "1/3" on Home + "0/9 today" in shop is impossible).
     */
    val activityCount: Flow<Int>        = prefsFlow().map { p ->
        val lastDate = p.getString(Keys.LAST_ACTIVITY_DATE, null)
        if (lastDate == todayStr()) p.getInt(Keys.ACTIVITY_COUNT, 0) else 0
    }
    val freePackCount: Flow<Int>        = prefsFlow().map { it.getInt(Keys.FREE_PACK_COUNT, 0) }
    val tokensBalance: Flow<Int>        = prefsFlow().map { it.getInt(Keys.TOKENS_BALANCE, 0) }

    /** Daily activity count for *today*. Returns 0 if last activity was on a different date. */
    val dailyActivityCount: Flow<Int>   = prefsFlow().map { p ->
        val lastDate = p.getString(Keys.LAST_ACTIVITY_DATE, null)
        if (lastDate == todayStr()) p.getInt(Keys.DAILY_ACTIVITY_COUNT, 0) else 0
    }

    fun setDarkTheme(isDark: Boolean)    = prefs.edit().putBoolean(Keys.IS_DARK_THEME, isDark).apply()
    fun setUsername(name: String)        = prefs.edit().putString(Keys.USERNAME, name).apply()
    fun setAvatarChoice(choice: String)  = prefs.edit().putString(Keys.AVATAR_CHOICE, choice).apply()
    fun setLanguagePair(pair: String)    = prefs.edit().putString(Keys.LANGUAGE_PAIR, pair).apply()
    fun setNativeLanguage(lang: String)  = prefs.edit().putString(Keys.NATIVE_LANGUAGE, lang).apply()

    /** Same midnight-reset semantics as [activityCount] flow. */
    fun getActivityCount(): Int {
        val lastDate = prefs.getString(Keys.LAST_ACTIVITY_DATE, null)
        return if (lastDate == todayStr()) prefs.getInt(Keys.ACTIVITY_COUNT, 0) else 0
    }
    fun getFreePackCount(): Int    = prefs.getInt(Keys.FREE_PACK_COUNT, 0)
    fun getTokensBalance(): Int    = prefs.getInt(Keys.TOKENS_BALANCE, 0)
    fun getLanguagePair(): String  = prefs.getString(Keys.LANGUAGE_PAIR, "en-ru") ?: "en-ru"

    fun setActivityCount(n: Int)  = prefs.edit().putInt(Keys.ACTIVITY_COUNT, n).apply()
    fun setFreePackCount(n: Int)  = prefs.edit().putInt(Keys.FREE_PACK_COUNT, n).apply()
    fun setTokensBalance(n: Int)  = prefs.edit().putInt(Keys.TOKENS_BALANCE, n.coerceAtLeast(0)).apply()
    fun addTokens(n: Int)         = setTokensBalance(getTokensBalance() + n)

    /** Daily activity count for today (auto-resets across midnight). */
    fun getDailyActivityCount(): Int {
        val lastDate = prefs.getString(Keys.LAST_ACTIVITY_DATE, null)
        return if (lastDate == todayStr()) prefs.getInt(Keys.DAILY_ACTIVITY_COUNT, 0) else 0
    }

    /**
     * Tries to register one more activity toward today's quota.
     * Returns true if it counted (under DAILY_ACTIVITY_LIMIT), false if the daily cap was reached.
     *
     * If the previous activity was on a different date, the progress-to-next-grant
     * counter ([Keys.ACTIVITY_COUNT]) is also reset, so it cannot lag behind a
     * fresh day.
     */
    fun registerDailyActivity(): Boolean {
        val today = todayStr()
        val lastDate = prefs.getString(Keys.LAST_ACTIVITY_DATE, null)
        val isNewDay = lastDate != today
        val current = if (isNewDay) 0 else prefs.getInt(Keys.DAILY_ACTIVITY_COUNT, 0)
        if (current >= DAILY_ACTIVITY_LIMIT) return false
        val edit = prefs.edit()
            .putInt(Keys.DAILY_ACTIVITY_COUNT, current + 1)
            .putString(Keys.LAST_ACTIVITY_DATE, today)
        if (isNewDay) {
            // Wipe stale grant-progress so Home and Shop never disagree across midnight.
            edit.putInt(Keys.ACTIVITY_COUNT, 0)
        }
        edit.apply()
        return true
    }

    fun getPvpMultiplierHintSeen(): Boolean = prefs.getBoolean(Keys.PVP_MULTIPLIER_HINT_SEEN, false)
    fun setPvpMultiplierHintSeen()          = prefs.edit().putBoolean(Keys.PVP_MULTIPLIER_HINT_SEEN, true).apply()

    val definitionQuizMode: Flow<String> = prefsFlow().map { it.getString(Keys.DEFINITION_QUIZ_MODE, "both") ?: "both" }
    fun setDefinitionQuizMode(mode: String) = prefs.edit().putString(Keys.DEFINITION_QUIZ_MODE, mode).apply()

    val problemWordsSource: Flow<String> = prefsFlow().map { it.getString(Keys.PROBLEM_WORDS_SOURCE, "both") ?: "both" }
    fun setProblemWordsSource(source: String) = prefs.edit().putString(Keys.PROBLEM_WORDS_SOURCE, source).apply()

    val problemWordsEnabled: Flow<Boolean> = prefsFlow().map { it.getBoolean(Keys.PROBLEM_WORDS_ENABLED, true) }
    fun setProblemWordsEnabled(enabled: Boolean) = prefs.edit().putBoolean(Keys.PROBLEM_WORDS_ENABLED, enabled).apply()

    val problemWordsMinEncounters: Flow<Int> = prefsFlow().map { it.getInt(Keys.PROBLEM_WORDS_MIN_ENCOUNTERS, 2) }
    fun setProblemWordsMinEncounters(n: Int) = prefs.edit().putInt(Keys.PROBLEM_WORDS_MIN_ENCOUNTERS, n).apply()

    val problemWordsCorrectToLearn: Flow<Int> = prefsFlow().map { it.getInt(Keys.PROBLEM_WORDS_CORRECT_TO_LEARN, 1) }
    fun setProblemWordsCorrectToLearn(n: Int) = prefs.edit().putInt(Keys.PROBLEM_WORDS_CORRECT_TO_LEARN, n).apply()

    /** How many correct answers a word needs before it counts toward set progress bar. Default 1. */
    val studyCorrectToCount: Flow<Int> = prefsFlow().map { it.getInt("study_correct_to_count", 1) }
    fun setStudyCorrectToCount(n: Int) = prefs.edit().putInt("study_correct_to_count", n).apply()

    fun isProblemWordsHintShown(): Boolean = prefs.getBoolean(Keys.PROBLEM_WORDS_HINT_SHOWN, false)
    fun setProblemWordsHintShown() = prefs.edit().putBoolean(Keys.PROBLEM_WORDS_HINT_SHOWN, true).apply()

    /**
     * DEPRECATED: superseded by [getProblemSessionMasteredTypes]. Kept only for
     * removal/migration of old data. Will be cleaned from prefs on next
     * [setProblemSessionMasteredTypes] write.
     */
    fun getProblemSessionCounts(): Map<Long, Int> {
        val raw = prefs.getString(Keys.PROBLEM_SESSION_COUNTS, null) ?: return emptyMap()
        return raw.split(",").mapNotNull { entry ->
            val parts = entry.split(":")
            if (parts.size == 2) parts[0].toLongOrNull()?.let { id -> parts[1].toIntOrNull()?.let { id to it } }
            else null
        }.toMap()
    }

    fun setProblemSessionCounts(counts: Map<Long, Int>) {
        val raw = counts.entries.joinToString(",") { "${it.key}:${it.value}" }
        prefs.edit().putString(Keys.PROBLEM_SESSION_COUNTS, raw).apply()
    }

    /**
     * Returns the set of quiz-type names (StudyQuizType.name) that the user has
     * correctly answered for each word across problem-word sessions.
     * When a word accumulates [StudyConstants.MASTERY_DISTINCT_TYPES] distinct
     * types (or all available types, whichever is smaller), it is mastered and
     * removed from this map.
     *
     * Serialization format: "wordId:type1|type2|type3;wordId2:type1" where `;`
     * separates word entries and `|` separates type names within one word.
     */
    fun getProblemSessionMasteredTypes(): Map<Long, Set<String>> {
        val raw = prefs.getString(Keys.PROBLEM_SESSION_MASTERED_TYPES, null) ?: return emptyMap()
        return raw.split(";").mapNotNull { entry ->
            if (entry.isBlank()) return@mapNotNull null
            val parts = entry.split(":", limit = 2)
            if (parts.size == 2) {
                val id = parts[0].toLongOrNull() ?: return@mapNotNull null
                val types = parts[1].split("|").filter { it.isNotBlank() }.toSet()
                id to types
            } else null
        }.toMap()
    }

    fun setProblemSessionMasteredTypes(byWord: Map<Long, Set<String>>) {
        val raw = byWord.entries
            .filter { it.value.isNotEmpty() }
            .joinToString(";") { (id, types) -> "$id:${types.joinToString("|")}" }
        prefs.edit()
            .putString(Keys.PROBLEM_SESSION_MASTERED_TYPES, raw)
            // Old counter-based format is obsolete once we migrate to types.
            .remove(Keys.PROBLEM_SESSION_COUNTS)
            .apply()
    }

    /** Words the user has permanently removed from the problem-words list (via trash button). */
    fun getDismissedProblemWordIds(): Set<Long> {
        val raw = prefs.getString(Keys.PROBLEM_WORDS_DISMISSED_IDS, null) ?: return emptySet()
        return raw.split(",").mapNotNull { it.toLongOrNull() }.toSet()
    }

    fun addDismissedProblemWordId(id: Long) {
        val updated = getDismissedProblemWordIds() + id
        prefs.edit().putString(Keys.PROBLEM_WORDS_DISMISSED_IDS, updated.joinToString(",")).apply()
    }

    /** Removes a single id from the dismissed list — used by the "restore one" action. */
    fun removeDismissedProblemWordId(id: Long) {
        val updated = getDismissedProblemWordIds() - id
        if (updated.isEmpty()) {
            prefs.edit().remove(Keys.PROBLEM_WORDS_DISMISSED_IDS).apply()
        } else {
            prefs.edit().putString(Keys.PROBLEM_WORDS_DISMISSED_IDS, updated.joinToString(",")).apply()
        }
    }

    fun clearDismissedProblemWordIds() {
        prefs.edit().remove(Keys.PROBLEM_WORDS_DISMISSED_IDS).apply()
    }

    /** Temporarily stores word IDs the user excluded from the next problem session. */
    fun getSessionExcludedWordIds(): Set<Long> {
        val raw = prefs.getString(Keys.SESSION_EXCLUDED_WORD_IDS, null) ?: return emptySet()
        return raw.split(",").mapNotNull { it.toLongOrNull() }.toSet()
    }
    fun setSessionExcludedWordIds(ids: Set<Long>) {
        prefs.edit().putString(Keys.SESSION_EXCLUDED_WORD_IDS, ids.joinToString(",")).apply()
    }
    fun clearSessionExcludedWordIds() {
        prefs.edit().remove(Keys.SESSION_EXCLUDED_WORD_IDS).apply()
    }

    fun isProblemChipHintShown(): Boolean = prefs.getBoolean(Keys.PROBLEM_CHIP_HINT_SHOWN, false)
    fun setProblemChipHintShown() = prefs.edit().putBoolean(Keys.PROBLEM_CHIP_HINT_SHOWN, true).apply()

    val searchBackBehavior: Flow<String> = prefsFlow().map { it.getString(Keys.SEARCH_BACK_BEHAVIOR, "clear") ?: "clear" }
    fun getSearchBackBehavior(): String = prefs.getString(Keys.SEARCH_BACK_BEHAVIOR, "clear") ?: "clear"
    fun setSearchBackBehavior(mode: String) = prefs.edit().putString(Keys.SEARCH_BACK_BEHAVIOR, mode).apply()

    fun getWordDataVersion(): Int = prefs.getInt(Keys.WORD_DATA_VERSION, 0)
    fun setWordDataVersion(version: Int) = prefs.edit().putInt(Keys.WORD_DATA_VERSION, version).apply()

    fun getPresetDecksVersion(): Int = prefs.getInt(Keys.PRESET_DECKS_VERSION, 0)
    fun setPresetDecksVersion(version: Int) = prefs.edit().putInt(Keys.PRESET_DECKS_VERSION, version).apply()

    /** WordDataVersion stored at the time preset decks were last rebuilt. */
    fun getPresetDecksWordVersion(): Int = prefs.getInt(Keys.PRESET_DECKS_WORD_VERSION, 0)
    fun setPresetDecksWordVersion(version: Int) = prefs.edit().putInt(Keys.PRESET_DECKS_WORD_VERSION, version).apply()

    /** Tester mode: помечает сессии как «тестерские» для фильтрации в Firebase Analytics. */
    val testerModeEnabled: Flow<Boolean> = prefsFlow().map { it.getBoolean(Keys.TESTER_MODE_ENABLED, false) }
    fun isTesterModeEnabled(): Boolean = prefs.getBoolean(Keys.TESTER_MODE_ENABLED, false)
    fun setTesterModeEnabled(enabled: Boolean) = prefs.edit().putBoolean(Keys.TESTER_MODE_ENABLED, enabled).apply()

    /** Cohort week — фиксируется один раз при первом запуске для аналитики «когорта установки X неделя». */
    fun getInstallCohortWeek(): String = prefs.getString(Keys.INSTALL_COHORT_WEEK, "") ?: ""
    fun setInstallCohortWeek(weekTag: String) = prefs.edit().putString(Keys.INSTALL_COHORT_WEEK, weekTag).apply()

    val quizTypesEnabled: Flow<Set<String>> = prefsFlow().map { p ->
        val raw = p.getString(Keys.QUIZ_TYPES_ENABLED, null)
        val stored = if (raw.isNullOrBlank()) DEFAULT_QUIZ_TYPES else raw.split(",").toSet()
        stored.intersect(KNOWN_QUIZ_TYPES).ifEmpty { DEFAULT_QUIZ_TYPES }
    }
    fun setQuizTypesEnabled(types: Set<String>) =
        prefs.edit().putString(Keys.QUIZ_TYPES_ENABLED, types.joinToString(",")).apply()
}
