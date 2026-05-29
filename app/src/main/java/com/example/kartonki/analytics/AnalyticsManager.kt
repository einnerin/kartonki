package com.example.kartonki.analytics

import android.os.Bundle
import android.util.Log
import com.example.kartonki.BuildConfig
import com.google.firebase.analytics.FirebaseAnalytics
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Интерфейс аналитики. Одна точка входа для всех событий.
 *
 * Инициализация — в [KartonkiApplication.onCreate] через [FirebaseAnalyticsManager].
 * Для тестов / режима без аналитики используется [NoOpAnalyticsManager].
 */
interface AnalyticsManager {
    fun log(event: AnalyticsEvent)
    fun setUserProperty(property: UserProperty)
    fun setUserId(id: String?)
    fun setAnalyticsEnabled(enabled: Boolean)
}

/**
 * Основная реализация — пишет в Firebase Analytics.
 *
 * Все параметры событий кладутся в [Bundle] (Firebase SDK принимает только это).
 * null-значения пропускаются (Firebase это не любит).
 */
@Singleton
class FirebaseAnalyticsManager @Inject constructor(
    private val firebaseAnalytics: FirebaseAnalytics,
) : AnalyticsManager {

    override fun log(event: AnalyticsEvent) {
        val bundle = Bundle().apply {
            event.params.forEach { (k, v) ->
                when (v) {
                    null -> { /* skip */ }
                    is Boolean -> putBoolean(k, v)
                    is Int -> putLong(k, v.toLong())
                    is Long -> putLong(k, v)
                    is Float -> putDouble(k, v.toDouble())
                    is Double -> putDouble(k, v)
                    is String -> putString(k, v)
                    else -> putString(k, v.toString())
                }
            }
        }
        firebaseAnalytics.logEvent(event.name, bundle)
        if (DEBUG_LOG) Log.d(TAG, "event=${event.name} params=${event.params}")
    }

    override fun setUserProperty(property: UserProperty) {
        firebaseAnalytics.setUserProperty(property.key, property.value)
        if (DEBUG_LOG) Log.d(TAG, "userProperty ${property.key}=${property.value}")
    }

    override fun setUserId(id: String?) {
        firebaseAnalytics.setUserId(id)
        if (DEBUG_LOG) Log.d(TAG, "userId=$id")
    }

    override fun setAnalyticsEnabled(enabled: Boolean) {
        firebaseAnalytics.setAnalyticsCollectionEnabled(enabled)
        if (DEBUG_LOG) Log.d(TAG, "analyticsEnabled=$enabled")
    }

    companion object {
        private const val TAG = "Analytics"
        // Только в debug-сборке. В release нельзя сыпать имена событий, user
        // properties и userId в Logcat (видно любому с READ_LOGS/adb).
        private val DEBUG_LOG = BuildConfig.DEBUG
    }
}

/** Заглушка — для тестов и на случай если что-то пойдёт не так с Firebase init. */
class NoOpAnalyticsManager : AnalyticsManager {
    override fun log(event: AnalyticsEvent) = Unit
    override fun setUserProperty(property: UserProperty) = Unit
    override fun setUserId(id: String?) = Unit
    override fun setAnalyticsEnabled(enabled: Boolean) = Unit
}
