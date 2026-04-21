package com.example.kartonki

import android.app.Application
import com.example.kartonki.analytics.AnalyticsCrashHandler
import com.example.kartonki.analytics.AnalyticsManager
import com.example.kartonki.data.preferences.UserPreferencesRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class KartonkiApplication : Application() {

    @Inject lateinit var analytics: AnalyticsManager
    @Inject lateinit var prefs: UserPreferencesRepository

    override fun onCreate() {
        super.onCreate()
        initAnalytics()
        installCrashHandler()
    }

    /**
     * Аналитика включается всегда. user_id проставляется так:
     * - Debug-сборка (моё dev-устройство)     → "dev_einnerin"
     * - Пользователь включил tester mode      → "tester"
     * - Обычный пользователь в Play Store      → null (анонимный Firebase ID)
     *
     * В Firebase Console фильтруем `user_id NOT IN ("dev_einnerin", "tester")` —
     * видим только реальную аудиторию.
     */
    private fun initAnalytics() {
        analytics.setAnalyticsEnabled(true)
        val userId = when {
            BuildConfig.DEBUG -> "dev_einnerin"
            prefs.isTesterModeEnabled() -> "tester"
            else -> null
        }
        analytics.setUserId(userId)
    }

    private fun installCrashHandler() {
        val previous = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler(AnalyticsCrashHandler(analytics, previous))
    }
}
