package com.example.kartonki.data.repository

import java.util.Calendar

/** Midnight timestamp for the current local day (ms since epoch). */
internal fun todayMs(): Long {
    val cal = Calendar.getInstance()
    cal.set(Calendar.HOUR_OF_DAY, 0)
    cal.set(Calendar.MINUTE, 0)
    cal.set(Calendar.SECOND, 0)
    cal.set(Calendar.MILLISECOND, 0)
    return cal.timeInMillis
}

internal const val DAY_MS = 86_400_000L
