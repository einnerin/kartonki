package com.example.kartonki.data.repository

import java.util.Calendar

internal const val DAY_MS = 86_400_000L

/** Midnight timestamp for the current local day (ms since epoch). */
internal fun todayMs(): Long = midnightDaysAgo(0)

/**
 * Local-midnight timestamp [days] calendar days before today (DST-safe).
 * Uses Calendar arithmetic, so crossing a DST transition still lands on the
 * correct local midnight — unlike subtracting `days * DAY_MS` from a millis value,
 * which is off by ±1h on the twice-yearly transition days.
 */
internal fun midnightDaysAgo(days: Int): Long {
    val cal = Calendar.getInstance()
    cal.set(Calendar.HOUR_OF_DAY, 0)
    cal.set(Calendar.MINUTE, 0)
    cal.set(Calendar.SECOND, 0)
    cal.set(Calendar.MILLISECOND, 0)
    cal.add(Calendar.DAY_OF_MONTH, -days)
    return cal.timeInMillis
}

/**
 * Local calendar-day index for [ms] — days since the Unix epoch in the device's
 * current local time. DST-safe: the zone + DST offset in effect at that instant is
 * folded in, so two consecutive local midnights always differ by exactly 1.
 *
 * Streak/gap logic must compare day indices, NOT raw `(a - b) / DAY_MS`: across a
 * DST transition the millis delta between two adjacent local midnights is 23h or
 * 25h, so the naive division yields 0 or off-by-one and spuriously breaks a streak.
 */
internal fun localEpochDay(ms: Long): Long {
    val cal = Calendar.getInstance().apply { timeInMillis = ms }
    val offset = cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET)
    return Math.floorDiv(ms + offset, DAY_MS)
}
