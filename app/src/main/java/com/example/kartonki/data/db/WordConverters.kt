package com.example.kartonki.data.db

import androidx.room.TypeConverter

/**
 * Converters for WordEntity list-typed fields. Stored as comma-separated string.
 * Empty list ↔ empty string (not null) to match NOT NULL DEFAULT '' in SQL.
 */
class WordConverters {
    @TypeConverter
    fun longListToString(list: List<Long>): String =
        if (list.isEmpty()) "" else list.joinToString(",")

    @TypeConverter
    fun stringToLongList(value: String): List<Long> =
        if (value.isEmpty()) emptyList()
        // toLongOrNull — tolerate a malformed/corrupt stored value rather than
        // crashing word loading on a bad DB read.
        else value.split(",").mapNotNull { it.trim().toLongOrNull() }
}
