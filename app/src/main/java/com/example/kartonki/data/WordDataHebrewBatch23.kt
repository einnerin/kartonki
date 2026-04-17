package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrewBatch23 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1091, languagePair = "he-ru", orderIndex = 1091,
            name = "Экономика",
            description = "Макро- и микроэкономика, рынки и теории A2/C1",
        ),
        WordSetEntity(
            id = 1092, languagePair = "he-ru", orderIndex = 1092,
            name = "Философия",
            description = "Направления, понятия и великие вопросы A2/C2",
        ),
        WordSetEntity(
            id = 1093, languagePair = "he-ru", orderIndex = 1093,
            name = "Климат и устойчивость",
            description = "Изменение климата, экополитика и решения A2/C2",
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Set 1091: Экономика ────────────────────────────────────────────

        // COMMON (A1)
        WordEntity(id = 109101, setId = 1091, languagePair = "he-ru", rarity = "COMMON",
            original = "כַּלְכָּלָה", translation = "экономика"),
        WordEntity(id = 109102, setId = 1091, languagePair = "he-ru", rarity = "COMMON",
            original = "מַשְׁבֵּר", translation = "кризис"),
        WordEntity(id = 109103, setId = 1091, languagePair = "he-ru", rarity = "COMMON",
            original = "אִינְפְלַצְיָה", translation = "инфляция"),
        WordEntity(id = 109104, setId = 1091, languagePair = "he-ru", rarity = "COMMON",
            original = "מִס", translation = "налог"),
        WordEntity(id = 109105, setId = 1091, languagePair = "he-ru", rarity = "COMMON",
            original = "תַּקְצִיב", translation = "бюджет"),
        WordEntity(id = 109106, setId = 1091, languagePair = "he-ru", rarity = "COMMON",
            original = "גֵּרָעוֹן", translation = "дефицит"),

        // UNCOMMON (A2-B1)
        WordEntity(id = 109107, setId = 1091, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִיתוּן", translation = "рецессия"),
        WordEntity(id = 109108, setId = 1091, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תּוֹצֶרֶת מְקוֹמִית", translation = "ВВП, внутренний валовый продукт"),
        WordEntity(id = 109109, setId = 1091, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סַחַר חוּץ", translation = "внешняя торговля"),
        WordEntity(id = 109110, setId = 1091, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "יְצוּא", translation = "экспорт"),
        WordEntity(id = 109111, setId = 1091, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עוֹדֶף", translation = "профицит, избыток"),
        WordEntity(id = 109112, setId = 1091, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שׁוּק חוֹפְשִׁי", translation = "свободный рынок"),
        WordEntity(id = 109113, setId = 1091, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "בֹּרְסָה", translation = "биржа (фондовая)"),
        WordEntity(id = 109114, setId = 1091, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אִיגּוּד מִקְצוֹעִי", translation = "профессиональный союз, профсоюз"),
        WordEntity(id = 109115, setId = 1091, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גְּלוֹבָּלִיזַצְיָה", translation = "глобализация"),
        WordEntity(id = 109116, setId = 1091, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַשְׁקָעוֹת זָרוֹת", translation = "иностранные инвестиции"),

        // RARE (B2)
        WordEntity(id = 109117, setId = 1091, languagePair = "he-ru", rarity = "RARE",
            original = "פּרוֹטֶקְצְיוֹנִיזְם", translation = "протекционизм"),
        WordEntity(id = 109118, setId = 1091, languagePair = "he-ru", rarity = "RARE",
            original = "כַּלְכָּלַת שׁוּק", translation = "рыночная экономика"),
        WordEntity(id = 109119, setId = 1091, languagePair = "he-ru", rarity = "RARE",
            original = "כַּלְכָּלָה תַּכְנוּנִית", translation = "плановая экономика"),
        WordEntity(id = 109120, setId = 1091, languagePair = "he-ru", rarity = "RARE",
            original = "מַקְרוֹ-כַּלְכָּלָה", translation = "макроэкономика"),
        WordEntity(id = 109121, setId = 1091, languagePair = "he-ru", rarity = "RARE",
            original = "מִיקְרוֹ-כַּלְכָּלָה", translation = "микроэкономика"),

        // EPIC (C1)
        WordEntity(id = 109122, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "פּוֹפּוּלִיזְם כַּלְכָּלִי", translation = "экономический популизм"),
        WordEntity(id = 109123, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "כַּלְכָּלָה הֶתְנְהַגּוּתִית", translation = "поведенческая экономика"),
        WordEntity(id = 109124, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "תֵּיאוֹרְיַת הַמִּשְׂחָקִים", translation = "теория игр"),

        // LEGENDARY (C2)
        WordEntity(id = 109125, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "קֵינֶסְיָאנִיזְם", translation = "кейнсианство (теория Дж. М. Кейнса)"),

        // ── Set 1092: Философия ────────────────────────────────────────────

        // COMMON (A1)
        WordEntity(id = 109201, setId = 1092, languagePair = "he-ru", rarity = "COMMON",
            original = "פִּילוֹסוֹפְיָה", translation = "философия"),
        WordEntity(id = 109202, setId = 1092, languagePair = "he-ru", rarity = "COMMON",
            original = "הִגָּיוֹן", translation = "логика"),
        WordEntity(id = 109203, setId = 1092, languagePair = "he-ru", rarity = "COMMON",
            original = "אֶתִיקָה", translation = "этика"),
        WordEntity(id = 109204, setId = 1092, languagePair = "he-ru", rarity = "COMMON",
            original = "עֶקְרוֹן", translation = "принцип"),
        WordEntity(id = 109205, setId = 1092, languagePair = "he-ru", rarity = "COMMON",
            original = "תּוֹדָעָה", translation = "сознание"),
        WordEntity(id = 109206, setId = 1092, languagePair = "he-ru", rarity = "COMMON",
            original = "פָּרָדוֹקְס", translation = "парадокс"),

        // UNCOMMON (A2-B1)
        WordEntity(id = 109207, setId = 1092, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מֶטָפִיסִיקָה", translation = "метафизика"),
        WordEntity(id = 109208, setId = 1092, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חוֹפֶשׁ הָרָצוֹן", translation = "свобода воли"),
        WordEntity(id = 109209, setId = 1092, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "נִיהִילִיזְם", translation = "нигилизм"),
        WordEntity(id = 109210, setId = 1092, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אֶקְסִיסְטֶנְצְיַלִיזְם", translation = "экзистенциализм"),
        WordEntity(id = 109211, setId = 1092, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פְּרַגְמַטִיזְם", translation = "прагматизм"),
        WordEntity(id = 109212, setId = 1092, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רְלַטִיבִיזְם", translation = "релятивизм"),
        WordEntity(id = 109213, setId = 1092, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אוֹטוֹנוֹמְיָה", translation = "автономия"),
        WordEntity(id = 109214, setId = 1092, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חֲשִׁיבָה בִּיקוֹרְתִּית", translation = "критическое мышление"),
        WordEntity(id = 109215, setId = 1092, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אֶמְפִּירִיצִיזְם", translation = "эмпиризм"),
        WordEntity(id = 109216, setId = 1092, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רַצְיוֹנַלִיזְם", translation = "рационализм"),

        // RARE (B2)
        WordEntity(id = 109217, setId = 1092, languagePair = "he-ru", rarity = "RARE",
            original = "אֶפִּיסְטֶמוֹלוֹגְיָה", translation = "эпистемология (теория познания)"),
        WordEntity(id = 109218, setId = 1092, languagePair = "he-ru", rarity = "RARE",
            original = "דִּיאַלֶקְטִיקָה", translation = "диалектика"),
        WordEntity(id = 109219, setId = 1092, languagePair = "he-ru", rarity = "RARE",
            original = "שָׁאֵלָה פִּילוֹסוֹפִית", translation = "философский вопрос"),
        WordEntity(id = 109220, setId = 1092, languagePair = "he-ru", rarity = "RARE",
            original = "פּוֹלֵמִיקָה", translation = "полемика"),
        WordEntity(id = 109221, setId = 1092, languagePair = "he-ru", rarity = "RARE",
            original = "אוּטִיָּה", translation = "утопия"),

        // EPIC (C1)
        WordEntity(id = 109222, setId = 1092, languagePair = "he-ru", rarity = "EPIC",
            original = "פֵּנוֹמֶנוֹלוֹגְיָה", translation = "феноменология (Гуссерль)"),
        WordEntity(id = 109223, setId = 1092, languagePair = "he-ru", rarity = "EPIC",
            original = "קַנְטִיַּאנִיזְם", translation = "кантианство (этика Канта)"),
        WordEntity(id = 109224, setId = 1092, languagePair = "he-ru", rarity = "EPIC",
            original = "מֶטָ-אֶתִיקָה", translation = "метаэтика"),

        // LEGENDARY (C2)
        WordEntity(id = 109225, setId = 1092, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "אָקְסִיוֹלוֹגְיָה", translation = "аксиология (философия ценностей)"),

        // ── Set 1093: Климат и устойчивость ───────────────────────────────

        // COMMON (A1)
        WordEntity(id = 109301, setId = 1093, languagePair = "he-ru", rarity = "COMMON",
            original = "כַּדּוּר הָאָרֶץ", translation = "Земля, планета"),
        WordEntity(id = 109302, setId = 1093, languagePair = "he-ru", rarity = "COMMON",
            original = "קַיְּימוּת", translation = "устойчивость / устойчивое развитие"),
        WordEntity(id = 109303, setId = 1093, languagePair = "he-ru", rarity = "COMMON",
            original = "אוֹקְיָינוֹס", translation = "океан"),
        WordEntity(id = 109304, setId = 1093, languagePair = "he-ru", rarity = "COMMON",
            original = "פֶּחָמַן דּוּ-חַמְצָנִי", translation = "углекислый газ (CO₂)"),
        WordEntity(id = 109305, setId = 1093, languagePair = "he-ru", rarity = "COMMON",
            original = "שִׁטְפוֹן", translation = "наводнение"),
        WordEntity(id = 109306, setId = 1093, languagePair = "he-ru", rarity = "COMMON",
            original = "זִיהוּם אֲוִיר", translation = "загрязнение воздуха"),

        // UNCOMMON (A2-B1)
        WordEntity(id = 109307, setId = 1093, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מְדִינִיּוּת אַקְלִים", translation = "климатическая политика"),
        WordEntity(id = 109308, setId = 1093, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַסְכֵּם פָּרִיס", translation = "Парижское соглашение"),
        WordEntity(id = 109309, setId = 1093, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פְּלִיטַת פֶּחָמָן", translation = "выбросы углерода"),
        WordEntity(id = 109310, setId = 1093, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַפְשָׁרַת קַרְחוֹנִים", translation = "таяние ледников"),
        WordEntity(id = 109311, setId = 1093, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "יַעַר גֶּשֶׁם", translation = "тропический лес"),
        WordEntity(id = 109312, setId = 1093, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "כַּלְכָּלָה מְחַזֶּרֶת", translation = "циркулярная экономика"),
        WordEntity(id = 109313, setId = 1093, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אֶנֶרְגְּיָה סוֹלָרִית", translation = "солнечная энергия"),
        WordEntity(id = 109314, setId = 1093, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עֲלִיַּת הַפָּנִים", translation = "подъём уровня моря"),
        WordEntity(id = 109315, setId = 1093, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִדְבּוּר", translation = "опустынивание"),
        WordEntity(id = 109316, setId = 1093, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הֶסְכֵּם קְיוֹטוֹ", translation = "Киотский протокол"),

        // RARE (B2)
        WordEntity(id = 109317, setId = 1093, languagePair = "he-ru", rarity = "RARE",
            original = "מַפֶּלֶת הַבִּיוֹדִיבֶרְסִיטִי", translation = "утрата биоразнообразия"),
        WordEntity(id = 109318, setId = 1093, languagePair = "he-ru", rarity = "RARE",
            original = "טְבִיעַת רֶגֶל", translation = "углеродный след"),
        WordEntity(id = 109319, setId = 1093, languagePair = "he-ru", rarity = "RARE",
            original = "תַּשְׁתִּית יְרוּקָּה", translation = "зелёная инфраструктура"),
        WordEntity(id = 109320, setId = 1093, languagePair = "he-ru", rarity = "RARE",
            original = "מִשְׁבַּר אֶקְלִים", translation = "климатический кризис"),
        WordEntity(id = 109321, setId = 1093, languagePair = "he-ru", rarity = "RARE",
            original = "עַרְפִּיחַ", translation = "смог"),

        // EPIC (C1)
        WordEntity(id = 109322, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "כַּלְכָּלָה דֶּקַרְבּוֹנִיזַצְיָה", translation = "декарбонизация экономики"),
        WordEntity(id = 109323, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "צְמִיחָה כְּחוּלָה", translation = "зелёный/голубой рост (устойчивое развитие)"),
        WordEntity(id = 109324, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "פְּגִיעוּת אֶקוֹ-סִיסְטֶמִית", translation = "уязвимость экосистем"),

        // LEGENDARY (C2)
        WordEntity(id = 109325, setId = 1093, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "נְקֻדַּת אֵין-חֲזָרָה", translation = "точка невозврата (климатический типпинг-пойнт)"),
    )
}
