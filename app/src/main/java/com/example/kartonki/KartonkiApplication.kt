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
        // User properties — стартовый набор. Полные значения подгружаются позже из repos.
        analytics.setUserProperty(
            com.example.kartonki.analytics.UserProperty.PreferredLanguagePair(prefs.getLanguagePair())
        )
        // Cohort week — устанавливается один раз при первом запуске
        if (prefs.getInstallCohortWeek().isEmpty()) {
            val cal = java.util.Calendar.getInstance()
            val tag = "%d-%02d".format(
                cal.get(java.util.Calendar.YEAR),
                cal.get(java.util.Calendar.WEEK_OF_YEAR),
            )
            prefs.setInstallCohortWeek(tag)
        }
        analytics.setUserProperty(
            com.example.kartonki.analytics.UserProperty.InstallCohortWeek(prefs.getInstallCohortWeek())
        )
    }

    private fun installCrashHandler() {
        val previous = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler(AnalyticsCrashHandler(analytics, previous))
    }
}
