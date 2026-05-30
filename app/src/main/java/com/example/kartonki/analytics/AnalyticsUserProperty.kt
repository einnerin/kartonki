package com.example.kartonki.analytics

/**
 * Свойства пользователя, привязанные к `user_id` в Firebase Analytics.
 *
 * Пример использования:
 *   analytics.setUserProperty(UserProperty.PreferredLanguagePair("en-ru"))
 *
 * Сейчас задействованы только две — выставляются в
 * [com.example.kartonki.KartonkiApplication.initAnalytics] при старте.
 * Дополнительные user-property добавлять по мере того, как для них
 * появляется реальное продуктовое потребление в дашбордах.
 */
sealed class UserProperty(val key: String, val value: String?) {

    /** en-ru / he-ru — какой языковой пары чаще выбирают. */
    data class PreferredLanguagePair(val pair: String) :
        UserProperty("preferred_language_pair", pair)

    /** YYYY-WW — когда установил приложение. Для cohort-анализа. */
    data class InstallCohortWeek(val weekTag: String) :
        UserProperty("install_cohort_week", weekTag)
}
