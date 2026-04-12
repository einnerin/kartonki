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
        const val CONTEXT_QUIZ_MODE        = "context_quiz_mode"   // "foreign" | "native" | "both"
        const val QUIZ_TYPES_ENABLED       = "quiz_types_enabled"  // comma-separated keys
    }

    companion object {
        val DEFAULT_QUIZ_TYPES: Set<String> = setOf("translation", "type_input", "definition", "fill_blank")
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

    fun getActivityCount(): Int  = prefs.getInt(Keys.ACTIVITY_COUNT, 0)
    fun getFreePackCount(): Int  = prefs.getInt(Keys.FREE_PACK_COUNT, 0)

    fun setActivityCount(n: Int)  = prefs.edit().putInt(Keys.ACTIVITY_COUNT, n).apply()
    fun setFreePackCount(n: Int)  = prefs.edit().putInt(Keys.FREE_PACK_COUNT, n).apply()

    fun getPvpMultiplierHintSeen(): Boolean = prefs.getBoolean(Keys.PVP_MULTIPLIER_HINT_SEEN, false)
    fun setPvpMultiplierHintSeen()          = prefs.edit().putBoolean(Keys.PVP_MULTIPLIER_HINT_SEEN, true).apply()

    val contextQuizMode: Flow<String> = prefsFlow().map { it.getString(Keys.CONTEXT_QUIZ_MODE, "both") ?: "both" }
    fun setContextQuizMode(mode: String) = prefs.edit().putString(Keys.CONTEXT_QUIZ_MODE, mode).apply()

    val quizTypesEnabled: Flow<Set<String>> = prefsFlow().map { p ->
        val raw = p.getString(Keys.QUIZ_TYPES_ENABLED, null)
        if (raw.isNullOrBlank()) DEFAULT_QUIZ_TYPES else raw.split(",").toSet()
    }
    fun setQuizTypesEnabled(types: Set<String>) =
        prefs.edit().putString(Keys.QUIZ_TYPES_ENABLED, types.joinToString(",")).apply()
}
