package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Продвинутый уровень — наборы C1–C2 (EPIC / LEGENDARY).
 * Темы: риторика, философия, дипломатия, иудаика, психоанализ, академический язык.
 */
object WordDataHebrewImmigrant16 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(id = 1202, languagePair = "he-ru", name = "Лингвистика", description = "Метафора, нарратив, стилистика", orderIndex = 202,
    topic = "Лингвистика", level = 4),
    )

    val words: List<WordEntity> = listOf(

        // ── 1202: Риторика и литература ──────────────────────────────────
        WordEntity(id = 120201, setId = 1202, languagePair = "he-ru", original = "מְשׁוֹרֵר", translation = "поэт", transliteration = "meshorer", rarity = "EPIC"),
        WordEntity(id = 120202, setId = 1202, languagePair = "he-ru", original = "אֶפִּיפוֹרָה", translation = "эпифора", transliteration = "epifora", rarity = "LEGENDARY"),
        WordEntity(id = 120203, setId = 1202, languagePair = "he-ru", original = "אַנָּפוֹרָה", translation = "анафора", transliteration = "anafora", rarity = "EPIC"),
        WordEntity(id = 120204, setId = 1202, languagePair = "he-ru", original = "אַלֶּגוֹרִיָּה", translation = "аллегория", transliteration = "alegoria", rarity = "EPIC"),
        WordEntity(id = 120205, setId = 1202, languagePair = "he-ru", original = "פַּרָּדוֹקְס", translation = "парадокс", transliteration = "paradoks", rarity = "EPIC"),
        WordEntity(id = 120206, setId = 1202, languagePair = "he-ru", original = "אִירוֹנְיָה", translation = "ирония", transliteration = "ironia", rarity = "EPIC"),
        WordEntity(id = 120207, setId = 1202, languagePair = "he-ru", original = "סַרְקַזְם", translation = "сарказм", transliteration = "sarkasm", rarity = "EPIC"),
        WordEntity(id = 120208, setId = 1202, languagePair = "he-ru", original = "פּוֹלִיסִינְדֶטוֹן", translation = "полисиндетон", transliteration = "polisindeton", rarity = "LEGENDARY"),
        WordEntity(id = 120209, setId = 1202, languagePair = "he-ru", original = "דְּמוּת", translation = "образ / персонаж", transliteration = "dmut", rarity = "EPIC"),
        WordEntity(id = 120210, setId = 1202, languagePair = "he-ru", original = "נָרָטִיב", translation = "нарратив / повествование", transliteration = "narativ", rarity = "EPIC"),
        WordEntity(id = 120211, setId = 1202, languagePair = "he-ru", original = "לִיטוֹטֶס", translation = "литотес (преуменьшение)", transliteration = "litotes", rarity = "EPIC"),
        WordEntity(id = 120212, setId = 1202, languagePair = "he-ru", original = "אוֹקְסִימוֹרוֹן", translation = "оксюморон", transliteration = "oksymoron", rarity = "EPIC"),
        WordEntity(id = 120213, setId = 1202, languagePair = "he-ru", original = "טְרָגֶדְיָה", translation = "трагедия", transliteration = "tragedya", rarity = "EPIC"),
        WordEntity(id = 120214, setId = 1202, languagePair = "he-ru", original = "נוֹשֵׂא", translation = "тема / предмет", transliteration = "nose", rarity = "EPIC"),
        WordEntity(id = 120215, setId = 1202, languagePair = "he-ru", original = "חֲרוּז", translation = "рифма", transliteration = "kharuz", rarity = "EPIC"),
        WordEntity(id = 120216, setId = 1202, languagePair = "he-ru", original = "רֵיתוֹרִיקָה", translation = "риторика", transliteration = "reitorika", rarity = "LEGENDARY"),
        WordEntity(id = 120217, setId = 1202, languagePair = "he-ru", original = "נוֹבֵלָה", translation = "новелла", transliteration = "novela", rarity = "EPIC"),
        WordEntity(id = 120218, setId = 1202, languagePair = "he-ru", original = "אֶלֵגְיָה", translation = "элегия", transliteration = "elegya", rarity = "EPIC"),
        WordEntity(id = 120219, setId = 1202, languagePair = "he-ru", original = "אֶפִּיגְרַמָּה", translation = "эпиграмма", transliteration = "epigramma", rarity = "LEGENDARY"),
        WordEntity(id = 120220, setId = 1202, languagePair = "he-ru", original = "פֶּרִיפְרָזָה", translation = "перифраза", transliteration = "perifraza", rarity = "EPIC"),
        WordEntity(id = 120221, setId = 1202, languagePair = "he-ru", original = "אוֹטוֹבִּיוֹגְרַפְיָה", translation = "автобиография", transliteration = "otobiografia", rarity = "LEGENDARY"),
        WordEntity(id = 120222, setId = 1202, languagePair = "he-ru", original = "סֵמֶל", translation = "символ", transliteration = "semel", rarity = "EPIC"),
        WordEntity(id = 120223, setId = 1202, languagePair = "he-ru", original = "אַמְפִּיבּוֹלְיָה", translation = "амфиболия (двусмысленность)", transliteration = "amfibolya", rarity = "LEGENDARY"),
        WordEntity(id = 120224, setId = 1202, languagePair = "he-ru", original = "הִיפֶּרְבּוֹלָה", translation = "гипербола", transliteration = "hiperbola", rarity = "EPIC"),
        WordEntity(id = 120225, setId = 1202, languagePair = "he-ru", original = "מֵטוֹנִימְיָה", translation = "метонимия", transliteration = "metonimya", rarity = "LEGENDARY"),

        // ── 1203: Философия ──────────────────────────────────────────────

        // ── 1204: Дипломатия ─────────────────────────────────────────────

        // ── 1205: Иудаика и тексты ───────────────────────────────────────

        // ── 1206: Психоанализ ────────────────────────────────────────────

        // ── 1207: Академический язык ─────────────────────────────────────
    )
}
