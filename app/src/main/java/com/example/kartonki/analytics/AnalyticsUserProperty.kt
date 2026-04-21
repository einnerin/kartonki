package com.example.kartonki.analytics

/**
 * Свойства пользователя, привязанные к `user_id` в Firebase Analytics.
 *
 * Пример использования:
 *   analytics.setUserProperty(UserProperty.PreferredLanguagePair("en-ru"))
 *
 * Заполняются в Фазах 2-4 — тут только декларация.
 */
sealed class UserProperty(val key: String, val value: String?) {

    /** en-ru / he-ru — какой языковой пары чаще выбирают. */
    data class PreferredLanguagePair(val pair: String) :
        UserProperty("preferred_language_pair", pair)

    /** Сколько колод построил пользователь. */
    data class TotalDecks(val count: Int) :
        UserProperty("total_decks", count.toString())

    /** Слов в UNCOMMON+ — прокси для «сколько выучил». */
    data class TotalWordsLearned(val count: Int) :
        UserProperty("total_words_learned", count.toString())

    /** Слов в LEGENDARY — самые «освоенные». */
    data class TotalWordsMastered(val count: Int) :
        UserProperty("total_words_mastered", count.toString())

    /** PVE / PVP_LOCAL / PVP_ONLINE — где большинство сессий. */
    data class FavoriteMode(val mode: String) :
        UserProperty("favorite_mode", mode)

    /** Среднее время в приложении в минутах за последнюю неделю. */
    data class AvgDailySessionMinutes(val minutes: Int) :
        UserProperty("avg_daily_session_minutes", minutes.toString())

    /** YYYY-WW — когда установил приложение. Для cohort-анализа. */
    data class InstallCohortWeek(val weekTag: String) :
        UserProperty("install_cohort_week", weekTag)

    /** Играл ли в онлайн-режим хоть раз. */
    data class HasPlayedPvpOnline(val played: Boolean) :
        UserProperty("has_played_pvp_online", played.toString())

    /** Максимальный streak, который был у пользователя. */
    data class HighestStreak(val days: Int) :
        UserProperty("highest_streak", days.toString())
}
