package com.example.kartonki.analytics

/**
 * Простой глобальный обработчик крашей.
 *
 * Когда приложение падает с необработанным исключением:
 * 1. Логируем [AnalyticsEvent.AppCrash] (имя класса исключения + фатальность).
 * 2. Пробрасываем дальше в предыдущий handler — чтобы системный crash-dialog
 *    сработал как обычно и ANR/краш зафиксировался в Android Vitals.
 *
 * Без stack trace (для этого нужен Crashlytics). Но уже видим:
 * - как часто крашится (relative к кол-ву сессий)
 * - какой класс исключения (NullPointerException / IllegalStateException / ...)
 * - на каких версиях Android / моделях (из Firebase auto params)
 *
 * Крашится до вызова Firebase.flush() — SDK буферизует локально и отправит
 * при следующем старте приложения.
 */
class AnalyticsCrashHandler(
    private val analytics: AnalyticsManager,
    private val previous: Thread.UncaughtExceptionHandler?,
) : Thread.UncaughtExceptionHandler {

    override fun uncaughtException(thread: Thread, throwable: Throwable) {
        runCatching {
            analytics.log(
                AnalyticsEvent.AppCrash(
                    errorType = throwable.javaClass.simpleName,
                    screen = null,   // Route-tracking добавим в Фазе 2
                    isFatal = true,
                )
            )
        }
        previous?.uncaughtException(thread, throwable)
    }
}
