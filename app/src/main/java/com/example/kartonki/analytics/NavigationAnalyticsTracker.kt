package com.example.kartonki.analytics

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Логирует [AnalyticsEvent.TabSelected] при смене destination в NavController.
 *
 * Дебаунс по сессии (=жизнь этого ViewModel): один таб не логируется повторно подряд,
 * чтобы не спамить аналитику при back-и-вперёд между двумя экранами.
 *
 * Жизненный цикл — пока приложение запущено (HiltViewModel при ApplicationContext через
 * NavGraph composable). При перезапуске счётчик сбрасывается, что соответствует
 * понятию «новой сессии» в Firebase auto-events.
 */
@HiltViewModel
class NavigationAnalyticsTracker @Inject constructor(
    private val analytics: AnalyticsManager,
) : ViewModel() {

    private val seenInSession = mutableSetOf<String>()

    fun onDestinationChanged(route: String?) {
        val tab = route?.normalizeTabName() ?: return
        if (seenInSession.add(tab)) {
            analytics.log(AnalyticsEvent.TabSelected(tab))
        }
    }

    /**
     * Сводит "study/{setId}" → "study", "deckBuilder/{deckId}" → "deck_builder", etc.
     * Лимит cardinality для tab_name (Firebase ограничивает до 500 уникальных значений
     * за 24h на параметр).
     */
    private fun String.normalizeTabName(): String {
        return substringBefore('/').substringBefore('?')
            .replace(Regex("([a-z])([A-Z])"), "$1_$2").lowercase()
    }
}
