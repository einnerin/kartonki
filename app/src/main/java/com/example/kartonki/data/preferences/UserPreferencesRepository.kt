package com.example.kartonki.data.preferences

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPreferencesRepository @Inject constructor(
    @ApplicationContext private val context: Context,
) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    private object Keys {
        const val IS_DARK_THEME            = "is_dark_theme"
        const val USERNAME                 = "username"
        const val AVATAR_CHOICE            = "avatar_choice"
        const val LANGUAGE_PAIR            = "language_pair"
        const val NATIVE_LANGUAGE          = "native_language"
        const val ACTIVITY_COUNT           = "activity_count"
        const val FREE_PACK_COUNT          = "free_pack_count"
        const val PVP_MULTIPLIER_HINT_SEEN = "pvp_multiplier_hint_seen"
        const val DEFINITION_QUIZ_MODE     = "definition_quiz_mode"   // "foreign" | "native" | "both"
        const val FILL_BLANK_QUIZ_MODE     = "fill_blank_quiz_mode"  // "foreign" | "native" | "both"
        const val QUIZ_TYPES_ENABLED       = "quiz_types_enabled"    // comma-separated keys
        const val PROBLEM_WORDS_SOURCE          = "problem_words_source"   // "both" | "pve_only" | "pvp_only"
        const val PROBLEM_WORDS_ENABLED         = "problem_words_enabled"  // Boolean
        const val PROBLEM_WORDS_MIN_ENCOUNTERS  = "problem_words_min_enc"  // Int: 1/2/3/5/10
        const val PROBLEM_WORDS_CORRECT_TO_LEARN = "problem_words_ctl"     // Int: 1/2/3/5
        const val PROBLEM_WORDS_HINT_SHOWN      = "problem_words_hint"     // Boolean
        const val PROBLEM_SESSION_COUNTS        = "problem_session_counts" // "id:count,id:count,..."
        const val SESSION_EXCLUDED_WORD_IDS     = "session_excluded_ids"  // "id,id,..." temp
        const val PROBLEM_CHIP_HINT_SHOWN       = "problem_chip_hint"     // Boolean
        const val WORD_DATA_VERSION             = "word_data_version"          // Int
        const val PRESET_DECKS_VERSION          = "preset_decks_version"       // Int
        const val PRESET_DECKS_WORD_VERSION     = "preset_decks_word_version"  // Int: WordDataVersion stored at last deck rebuild
    }

    companion object {
        val KNOWN_QUIZ_TYPES:   Set<String> = setOf("translation", "definition", "fill_blank")
        val DEFAULT_QUIZ_TYPES: Set<String> = KNOWN_QUIZ_TYPES
    }

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
    val activityCount: Flow<Int>        = prefsFlow().map { it.getInt(Keys.ACTIVITY_COUNT, 0) }
    val freePackCount: Flow<Int>        = prefsFlow().map { it.getInt(Keys.FREE_PACK_COUNT, 0) }

    fun setDarkTheme(isDark: Boolean)    = prefs.edit().putBoolean(Keys.IS_DARK_THEME, isDark).apply()
    fun setUsername(name: String)        = prefs.edit().putString(Keys.USERNAME, name).apply()
    fun setAvatarChoice(choice: String)  = prefs.edit().putString(Keys.AVATAR_CHOICE, choice).apply()
    fun setLanguagePair(pair: String)    = prefs.edit().putString(Keys.LANGUAGE_PAIR, pair).apply()
    fun setNativeLanguage(lang: String)  = prefs.edit().putString(Keys.NATIVE_LANGUAGE, lang).apply()

    fun getActivityCount(): Int    = prefs.getInt(Keys.ACTIVITY_COUNT, 0)
    fun getFreePackCount(): Int    = prefs.getInt(Keys.FREE_PACK_COUNT, 0)
    fun getLanguagePair(): String  = prefs.getString(Keys.LANGUAGE_PAIR, "en-ru") ?: "en-ru"

    fun setActivityCount(n: Int)  = prefs.edit().putInt(Keys.ACTIVITY_COUNT, n).apply()
    fun setFreePackCount(n: Int)  = prefs.edit().putInt(Keys.FREE_PACK_COUNT, n).apply()

    fun getPvpMultiplierHintSeen(): Boolean = prefs.getBoolean(Keys.PVP_MULTIPLIER_HINT_SEEN, false)
    fun setPvpMultiplierHintSeen()          = prefs.edit().putBoolean(Keys.PVP_MULTIPLIER_HINT_SEEN, true).apply()

    val definitionQuizMode: Flow<String> = prefsFlow().map { it.getString(Keys.DEFINITION_QUIZ_MODE, "both") ?: "both" }
    fun setDefinitionQuizMode(mode: String) = prefs.edit().putString(Keys.DEFINITION_QUIZ_MODE, mode).apply()

    val fillBlankQuizMode: Flow<String> = prefsFlow().map { it.getString(Keys.FILL_BLANK_QUIZ_MODE, "both") ?: "both" }
    fun setFillBlankQuizMode(mode: String) = prefs.edit().putString(Keys.FILL_BLANK_QUIZ_MODE, mode).apply()

    val problemWordsSource: Flow<String> = prefsFlow().map { it.getString(Keys.PROBLEM_WORDS_SOURCE, "both") ?: "both" }
    fun setProblemWordsSource(source: String) = prefs.edit().putString(Keys.PROBLEM_WORDS_SOURCE, source).apply()

    val problemWordsEnabled: Flow<Boolean> = prefsFlow().map { it.getBoolean(Keys.PROBLEM_WORDS_ENABLED, true) }
    fun setProblemWordsEnabled(enabled: Boolean) = prefs.edit().putBoolean(Keys.PROBLEM_WORDS_ENABLED, enabled).apply()

    val problemWordsMinEncounters: Flow<Int> = prefsFlow().map { it.getInt(Keys.PROBLEM_WORDS_MIN_ENCOUNTERS, 2) }
    fun setProblemWordsMinEncounters(n: Int) = prefs.edit().putInt(Keys.PROBLEM_WORDS_MIN_ENCOUNTERS, n).apply()

    val problemWordsCorrectToLearn: Flow<Int> = prefsFlow().map { it.getInt(Keys.PROBLEM_WORDS_CORRECT_TO_LEARN, 1) }
    fun setProblemWordsCorrectToLearn(n: Int) = prefs.edit().putInt(Keys.PROBLEM_WORDS_CORRECT_TO_LEARN, n).apply()

    fun isProblemWordsHintShown(): Boolean = prefs.getBoolean(Keys.PROBLEM_WORDS_HINT_SHOWN, false)
    fun setProblemWordsHintShown() = prefs.edit().putBoolean(Keys.PROBLEM_WORDS_HINT_SHOWN, true).apply()

    /** Returns the number of correct problem-session answers accumulated per word: wordId → count. */
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

    fun getWordDataVersion(): Int = prefs.getInt(Keys.WORD_DATA_VERSION, 0)
    fun setWordDataVersion(version: Int) = prefs.edit().putInt(Keys.WORD_DATA_VERSION, version).apply()

    fun getPresetDecksVersion(): Int = prefs.getInt(Keys.PRESET_DECKS_VERSION, 0)
    fun setPresetDecksVersion(version: Int) = prefs.edit().putInt(Keys.PRESET_DECKS_VERSION, version).apply()

    /** WordDataVersion stored at the time preset decks were last rebuilt. */
    fun getPresetDecksWordVersion(): Int = prefs.getInt(Keys.PRESET_DECKS_WORD_VERSION, 0)
    fun setPresetDecksWordVersion(version: Int) = prefs.edit().putInt(Keys.PRESET_DECKS_WORD_VERSION, version).apply()

    val quizTypesEnabled: Flow<Set<String>> = prefsFlow().map { p ->
        val raw = p.getString(Keys.QUIZ_TYPES_ENABLED, null)
        val stored = if (raw.isNullOrBlank()) DEFAULT_QUIZ_TYPES else raw.split(",").toSet()
        stored.intersect(KNOWN_QUIZ_TYPES).ifEmpty { DEFAULT_QUIZ_TYPES }
    }
    fun setQuizTypesEnabled(types: Set<String>) =
        prefs.edit().putString(Keys.QUIZ_TYPES_ENABLED, types.joinToString(",")).apply()
}
