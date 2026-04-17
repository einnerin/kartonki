package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrewBatch24 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1094, languagePair = "he-ru", orderIndex = 1094,
            name = "Лингвистика",
            description = "Язык, звуки и структура речи A2/C2",
        ),
        WordSetEntity(
            id = 1095, languagePair = "he-ru", orderIndex = 1095,
            name = "Антропология",
            description = "Культура, общество и эволюция человека A2/C2",
        ),
        WordSetEntity(
            id = 1096, languagePair = "he-ru", orderIndex = 1096,
            name = "Питание и здоровье",
            description = "Нутриенты, диета и пищевая наука A2/C2",
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Set 1094: Лингвистика ──────────────────────────────────────────

        // COMMON (A1)
        WordEntity(id = 109401, setId = 1094, languagePair = "he-ru", rarity = "COMMON",
            original = "לְשׁוֹנָאוּת", translation = "лингвистика (наука о языке)"),
        WordEntity(id = 109402, setId = 1094, languagePair = "he-ru", rarity = "COMMON",
            original = "לֶקְסִיקוֹגְרַפְיָה", translation = "лексикография"),
        WordEntity(id = 109403, setId = 1094, languagePair = "he-ru", rarity = "COMMON",
            original = "שָׂפָה אֵם", translation = "родной язык, язык матери"),
        WordEntity(id = 109404, setId = 1094, languagePair = "he-ru", rarity = "COMMON",
            original = "דִּיאַלֶקְט", translation = "диалект"),
        WordEntity(id = 109405, setId = 1094, languagePair = "he-ru", rarity = "COMMON",
            original = "מְשָׁמָעוּת", translation = "значение, смысл"),
        WordEntity(id = 109406, setId = 1094, languagePair = "he-ru", rarity = "COMMON",
            original = "שֹׁרֶשׁ מִלָּה", translation = "корень слова"),

        // UNCOMMON (A2-B1)
        WordEntity(id = 109407, setId = 1094, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פּוֹנוֹלוֹגְיָה", translation = "фонология (наука о звуках)"),
        WordEntity(id = 109408, setId = 1094, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מוֹרְפוֹלוֹגְיָה", translation = "морфология (строение слов)"),
        WordEntity(id = 109409, setId = 1094, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סֵמַנְטִיקָה", translation = "семантика (значение слов)"),
        WordEntity(id = 109410, setId = 1094, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רְכִישַׁת שָׂפָה", translation = "усвоение языка"),
        WordEntity(id = 109411, setId = 1094, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "לְשׁוֹן עַמָּמִית", translation = "просторечие, народный язык"),
        WordEntity(id = 109412, setId = 1094, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "יְסוֹד לְשׁוֹנִי", translation = "языковая единица"),
        WordEntity(id = 109413, setId = 1094, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קוֹד-שְׁוִיצִ'ינְג", translation = "переключение кодов (смена языка)"),
        WordEntity(id = 109414, setId = 1094, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "בִּלְשׁוֹנִיּוּת", translation = "двуязычие (билингвизм)"),
        WordEntity(id = 109415, setId = 1094, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "כִּישּׁוּר שָׂפָה", translation = "языковой навык"),
        WordEntity(id = 109416, setId = 1094, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הֶקְשֵׁר לְשׁוֹנִי", translation = "языковой контекст"),

        // RARE (B2)
        WordEntity(id = 109417, setId = 1094, languagePair = "he-ru", rarity = "RARE",
            original = "רְב-לְשׁוֹנִיּוּת", translation = "многоязычие (мультилингвизм)"),
        WordEntity(id = 109418, setId = 1094, languagePair = "he-ru", rarity = "RARE",
            original = "מֶטָ-שָׂפָה", translation = "метаязык"),
        WordEntity(id = 109419, setId = 1094, languagePair = "he-ru", rarity = "RARE",
            original = "לְשׁוֹן אַמָּה", translation = "язык матери (книжн.)"),
        WordEntity(id = 109420, setId = 1094, languagePair = "he-ru", rarity = "RARE",
            original = "פִּיגּוּן", translation = "подпорка (scaffolding — поддержка в обучении языку)"),
        WordEntity(id = 109421, setId = 1094, languagePair = "he-ru", rarity = "RARE",
            original = "דְּגָם", translation = "образец, паттерн"),

        // EPIC (C1)
        WordEntity(id = 109422, setId = 1094, languagePair = "he-ru", rarity = "EPIC",
            original = "תַּחְבִּיר גֶּנֶרָטִיבִי", translation = "генеративный синтаксис (Хомский)"),
        WordEntity(id = 109423, setId = 1094, languagePair = "he-ru", rarity = "EPIC",
            original = "בַּלְשָׁנוּת סוֹצְיוֹ-לְשׁוֹנִית", translation = "социолингвистика"),
        WordEntity(id = 109424, setId = 1094, languagePair = "he-ru", rarity = "EPIC",
            original = "טִיפּוֹלוֹגְיָה לְשׁוֹנִית", translation = "лингвистическая типология"),

        // LEGENDARY (C2)
        WordEntity(id = 109425, setId = 1094, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תֵּיאוֹרְיַת סַפִּיר-וְוֹרְף", translation = "гипотеза Сепира–Уорфа (языковая относительность)"),

        // ── Set 1095: Антропология ─────────────────────────────────────────

        // COMMON (A1)
        WordEntity(id = 109501, setId = 1095, languagePair = "he-ru", rarity = "COMMON",
            original = "אָנְתְּרוֹפּוֹלוֹגְיָה", translation = "антропология"),
        WordEntity(id = 109502, setId = 1095, languagePair = "he-ru", rarity = "COMMON",
            original = "תַּרְבּוּת", translation = "культура"),
        WordEntity(id = 109503, setId = 1095, languagePair = "he-ru", rarity = "COMMON",
            original = "שֶׁבֶט", translation = "племя"),
        WordEntity(id = 109504, setId = 1095, languagePair = "he-ru", rarity = "COMMON",
            original = "טֶקֶס", translation = "обряд, ритуал"),
        WordEntity(id = 109505, setId = 1095, languagePair = "he-ru", rarity = "COMMON",
            original = "מִיתוֹס", translation = "миф"),
        WordEntity(id = 109506, setId = 1095, languagePair = "he-ru", rarity = "COMMON",
            original = "אַרְכֵיאוֹלוֹגְיָה", translation = "археология"),

        // UNCOMMON (A2-B1)
        WordEntity(id = 109507, setId = 1095, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טֶקֶס מַעֲבָר", translation = "обряд перехода"),
        WordEntity(id = 109508, setId = 1095, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "זֶהוּת תַּרְבּוּתִית", translation = "культурная идентичность"),
        WordEntity(id = 109509, setId = 1095, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אֶתְנוֹגְרָפְיָה", translation = "этнография"),
        WordEntity(id = 109510, setId = 1095, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טוֹטֶם", translation = "тотем"),
        WordEntity(id = 109511, setId = 1095, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טָאבּוּ", translation = "табу"),
        WordEntity(id = 109512, setId = 1095, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גֶּנְדֶּר", translation = "гендер"),
        WordEntity(id = 109513, setId = 1095, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תַּפְקִיד חֶבְרָתִי", translation = "социальная роль"),
        WordEntity(id = 109514, setId = 1095, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אַסִימִילַצְיָה", translation = "ассимиляция"),
        WordEntity(id = 109515, setId = 1095, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מוֹנוֹגָמְיָה", translation = "моногамия"),
        WordEntity(id = 109516, setId = 1095, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שַׁמָּן", translation = "шаман"),

        // RARE (B2)
        WordEntity(id = 109517, setId = 1095, languagePair = "he-ru", rarity = "RARE",
            original = "אֶנְדוֹגָמְיָה", translation = "эндогамия (браки внутри группы)"),
        WordEntity(id = 109518, setId = 1095, languagePair = "he-ru", rarity = "RARE",
            original = "אֶקְסוֹגָמְיָה", translation = "экзогамия (браки вне группы)"),
        WordEntity(id = 109519, setId = 1095, languagePair = "he-ru", rarity = "RARE",
            original = "קִינְשִׁיפּ", translation = "система родства (kinship)"),
        WordEntity(id = 109520, setId = 1095, languagePair = "he-ru", rarity = "RARE",
            original = "אֶתְנוֹלוֹגְיָה", translation = "этнология"),
        WordEntity(id = 109521, setId = 1095, languagePair = "he-ru", rarity = "RARE",
            original = "פּוֹלִיגָמְיָה", translation = "полигамия"),

        // EPIC (C1)
        WordEntity(id = 109522, setId = 1095, languagePair = "he-ru", rarity = "EPIC",
            original = "אֶתְנוֹ-צֶנְטְרִיזְם", translation = "этноцентризм"),
        WordEntity(id = 109523, setId = 1095, languagePair = "he-ru", rarity = "EPIC",
            original = "רֵלַטִיבִיזְם תַּרְבּוּתִי", translation = "культурный релятивизм"),
        WordEntity(id = 109524, setId = 1095, languagePair = "he-ru", rarity = "EPIC",
            original = "אַנִּימִיזְם", translation = "анимизм"),

        // LEGENDARY (C2)
        WordEntity(id = 109525, setId = 1095, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "סְטְרוּקְטוּרַלִיזְם", translation = "структурализм (Леви-Стросс)"),

        // ── Set 1096: Питание и здоровье ──────────────────────────────────

        // COMMON (A1)
        WordEntity(id = 109601, setId = 1096, languagePair = "he-ru", rarity = "COMMON",
            original = "תַּזוּנָה", translation = "питание, нутриция"),
        WordEntity(id = 109602, setId = 1096, languagePair = "he-ru", rarity = "COMMON",
            original = "חֶלְבּוֹן", translation = "белок"),
        WordEntity(id = 109603, setId = 1096, languagePair = "he-ru", rarity = "COMMON",
            original = "פַּחְמֵי מָזוֹן", translation = "углеводы"),
        WordEntity(id = 109604, setId = 1096, languagePair = "he-ru", rarity = "COMMON",
            original = "שֻׁמָּנִים", translation = "жиры (в питании)"),
        WordEntity(id = 109605, setId = 1096, languagePair = "he-ru", rarity = "COMMON",
            original = "מִינֶרָל", translation = "минерал, минеральное вещество"),
        WordEntity(id = 109606, setId = 1096, languagePair = "he-ru", rarity = "COMMON",
            original = "קָלוֹרִיָּה", translation = "калория"),

        // UNCOMMON (A2-B1)
        WordEntity(id = 109607, setId = 1096, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "דִּיאֶטָה", translation = "диета"),
        WordEntity(id = 109608, setId = 1096, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סִיבִּים תְּזוּנָתִיִּים", translation = "пищевые волокна, клетчатка"),
        WordEntity(id = 109609, setId = 1096, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תְּזוּנָה מְאוּזֶּנֶת", translation = "сбалансированное питание"),
        WordEntity(id = 109610, setId = 1096, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אוֹמֶגָה-3", translation = "омега-3 (жирные кислоты)"),
        WordEntity(id = 109611, setId = 1096, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פְּרוֹבִּיוֹטִיקָה", translation = "пробиотики"),
        WordEntity(id = 109612, setId = 1096, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תּוֹסֶפֶת מָזוֹן", translation = "пищевая добавка"),
        WordEntity(id = 109613, setId = 1096, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַרְגָּלֵי אֲכִילָה", translation = "пищевые привычки"),
        WordEntity(id = 109614, setId = 1096, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אַנְטִיאוֹקְסִידָנְטִים", translation = "антиоксиданты"),
        WordEntity(id = 109615, setId = 1096, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סוּפֶּר-פּוּד", translation = "суперфуд (суперпродукт)"),
        WordEntity(id = 109616, setId = 1096, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַחְסוֹר תְּזוּנָתִי", translation = "нутритивный дефицит"),

        // RARE (B2)
        WordEntity(id = 109617, setId = 1096, languagePair = "he-ru", rarity = "RARE",
            original = "תַּזוּנָן", translation = "диетолог, нутрициолог"),
        WordEntity(id = 109618, setId = 1096, languagePair = "he-ru", rarity = "RARE",
            original = "תְּזוּנָה טִבְעוֹנִית", translation = "веганское питание"),
        WordEntity(id = 109619, setId = 1096, languagePair = "he-ru", rarity = "RARE",
            original = "גְּלִיקֶמִי", translation = "гликемический (индекс)"),
        WordEntity(id = 109620, setId = 1096, languagePair = "he-ru", rarity = "RARE",
            original = "אֶנְזִים עִיכּוּל", translation = "пищеварительный фермент"),
        WordEntity(id = 109621, setId = 1096, languagePair = "he-ru", rarity = "RARE",
            original = "מֶטָבּוֹלִיזְם בָּסִיסִי", translation = "базальный метаболизм"),

        // EPIC (C1)
        WordEntity(id = 109622, setId = 1096, languagePair = "he-ru", rarity = "EPIC",
            original = "מִיקְרוֹבִּיוֹם", translation = "микробиом (кишечная микрофлора)"),
        WordEntity(id = 109623, setId = 1096, languagePair = "he-ru", rarity = "EPIC",
            original = "תַּסְמֹנֶת מֶטָבּוֹלִית", translation = "метаболический синдром"),
        WordEntity(id = 109624, setId = 1096, languagePair = "he-ru", rarity = "EPIC",
            original = "תְּזוּנָה פוּנְקְצְיוֹנַלִית", translation = "функциональное питание"),

        // LEGENDARY (C2)
        WordEntity(id = 109625, setId = 1096, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "נוּטְרִי-גֶּנוֹמִיקָה", translation = "нутригеномика (влияние питания на гены)"),
    )
}
