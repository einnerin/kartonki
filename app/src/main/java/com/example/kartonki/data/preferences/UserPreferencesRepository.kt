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
        const val IS_DARK_THEME   = "is_dark_theme"
        const val USERNAME        = "username"
        const val AVATAR_CHOICE   = "avatar_choice"
        const val LANGUAGE_PAIR   = "language_pair"
        const val ACTIVITY_COUNT  = "activity_count"
        const val FREE_PACK_COUNT = "free_pack_count"
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

    val isDarkTheme: Flow<Boolean>  = prefsFlow().map { it.getBoolean(Keys.IS_DARK_THEME, true) }
    val username: Flow<String>      = prefsFlow().map { it.getString(Keys.USERNAME, "Игрок") ?: "Игрок" }
    val avatarChoice: Flow<String>  = prefsFlow().map { it.getString(Keys.AVATAR_CHOICE, "🎮") ?: "🎮" }
    val languagePair: Flow<String>  = prefsFlow().map { it.getString(Keys.LANGUAGE_PAIR, "en-ru") ?: "en-ru" }
    val activityCount: Flow<Int>    = prefsFlow().map { it.getInt(Keys.ACTIVITY_COUNT, 0) }
    val freePackCount: Flow<Int>    = prefsFlow().map { it.getInt(Keys.FREE_PACK_COUNT, 0) }

    fun setDarkTheme(isDark: Boolean)   = prefs.edit().putBoolean(Keys.IS_DARK_THEME, isDark).apply()
    fun setUsername(name: String)        = prefs.edit().putString(Keys.USERNAME, name).apply()
    fun setAvatarChoice(choice: String)  = prefs.edit().putString(Keys.AVATAR_CHOICE, choice).apply()
    fun setLanguagePair(pair: String)    = prefs.edit().putString(Keys.LANGUAGE_PAIR, pair).apply()

    fun getActivityCount(): Int  = prefs.getInt(Keys.ACTIVITY_COUNT, 0)
    fun getFreePackCount(): Int  = prefs.getInt(Keys.FREE_PACK_COUNT, 0)

    fun setActivityCount(n: Int)  = prefs.edit().putInt(Keys.ACTIVITY_COUNT, n).apply()
    fun setFreePackCount(n: Int)  = prefs.edit().putInt(Keys.FREE_PACK_COUNT, n).apply()
}
