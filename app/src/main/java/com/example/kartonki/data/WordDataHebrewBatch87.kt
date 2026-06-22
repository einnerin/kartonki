package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — batch 87.
 * Sets 1529–1533: углубление — Технологии L3, Наука L3, Психология L2, Медицина L4, Лингвистика L2.
 */
object WordDataHebrewBatch87 {

    val sets = listOf(
        WordSetEntity(id = 1533, languagePair = "he-ru", orderIndex = 1533,
            name = "Лингвистика",
            description = "Фонетика, морфология, прагматика",
            topic = "Лингвистика", level = 2),
    )

    val words = listOf(

        // ── Set 1529 — Технологии: углублённый 2 (level 3, B2) ───────────
        // 1 COMMON + 5 UNCOMMON + 12 RARE + 5 EPIC + 2 LEGENDARY

        // ── Set 1530 — Наука: углублённый 2 (level 3, B2) ────────────────
        // 1 COMMON + 5 UNCOMMON + 12 RARE + 5 EPIC + 2 LEGENDARY

        // ── Set 1531 — Психология: продвинутый 2 (level 2, A2/B1) ────────
        // 2 COMMON + 16 UNCOMMON + 4 RARE + 2 EPIC + 1 LEGENDARY

        // ── Set 1532 — Медицина: профессиональный 2 (level 4, C1) ────────
        // 0 COMMON + 1 UNCOMMON + 6 RARE + 13 EPIC + 5 LEGENDARY

        // ── Set 1533 — Лингвистика: продвинутый 2 (level 2, A2/B1) ───────
        // 2 COMMON + 16 UNCOMMON + 4 RARE + 2 EPIC + 1 LEGENDARY
        WordEntity(id = 153301, setId = 1533, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "דִּקְדּוּק", translation = "грамматика"),
        WordEntity(id = 153302, setId = 1533, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אוֹצָר מִלִּים", translation = "словарный запас"),
        WordEntity(id = 153303, setId = 1533, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הֲגִיָּה", translation = "произношение"),
        WordEntity(id = 153304, setId = 1533, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַטְעָמָה", translation = "ударение (в слове)"),
        WordEntity(id = 153305, setId = 1533, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שֹׁרֶשׁ", translation = "корень (слова)"),
        WordEntity(id = 153306, setId = 1533, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִשְׁקָל", translation = "модель / биньян (глагольная)"),
        WordEntity(id = 153307, setId = 1533, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַטָּיָה", translation = "спряжение / склонение"),
        WordEntity(id = 153308, setId = 1533, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "זְמַן עָבָר", translation = "прошедшее время"),
        WordEntity(id = 153309, setId = 1533, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "זְמַן עָתִיד", translation = "будущее время"),
        WordEntity(id = 153310, setId = 1533, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "צוּרָה סְמִיכוּת", translation = "смихут (сопряжённое состояние)"),
        WordEntity(id = 153311, setId = 1533, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִלַּת יַחַס", translation = "предлог"),
        WordEntity(id = 153312, setId = 1533, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִלַּת קִישׁוּר", translation = "союз (грамматический)"),
        WordEntity(id = 153313, setId = 1533, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שֵׁם פְּעוּלָה", translation = "отглагольное существительное"),
        WordEntity(id = 153314, setId = 1533, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "נָשׂוּא", translation = "сказуемое"),
        WordEntity(id = 153315, setId = 1533, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מֻשָּׂא", translation = "дополнение (в предложении)"),
        WordEntity(id = 153316, setId = 1533, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תֵּאוּר", translation = "обстоятельство (в предложении)"),
        WordEntity(id = 153317, setId = 1533, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סִמּוּן פִּסּוּק", translation = "знаки препинания / пунктуация"),
        WordEntity(id = 153318, setId = 1533, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שָׁפָה מְדוּבֶּרֶת", translation = "разговорный язык"),
        WordEntity(id = 153319, setId = 1533, languagePair = "he-ru", rarity = "RARE",
            original = "פוֹנֵטִיקָה", translation = "фонетика"),
        WordEntity(id = 153320, setId = 1533, languagePair = "he-ru", rarity = "RARE",
            original = "הֶרְמֵנוֹיְטִיקָה לְשׁוֹנִית", translation = "лингвистическая герменевтика"),
        WordEntity(id = 153321, setId = 1533, languagePair = "he-ru", rarity = "RARE",
            original = "תַּחְבִּיר", translation = "синтаксис"),
        WordEntity(id = 153322, setId = 1533, languagePair = "he-ru", rarity = "RARE",
            original = "מוֹנוֹלִינְגּוּאָלִיּוּת", translation = "моноязычность"),
        WordEntity(id = 153323, setId = 1533, languagePair = "he-ru", rarity = "RARE",
            original = "בִּי-לִינְגּוּאָלִיּוּת", translation = "билингвизм"),
        WordEntity(id = 153324, setId = 1533, languagePair = "he-ru", rarity = "RARE",
            original = "דִּיגְלוֹסִיָּה", translation = "диглоссия"),
        WordEntity(id = 153325, setId = 1533, languagePair = "he-ru", rarity = "RARE",
            original = "בַּלְשָׁנוּת הִיסְטוֹרִית", translation = "историческая лингвистика"),
    )
}
