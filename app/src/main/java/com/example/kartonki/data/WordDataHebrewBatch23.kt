package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrewBatch23 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1091, languagePair = "he-ru", orderIndex = 1091,
            name = "Финансы: профессиональный",
            description = "Макро- и микроэкономика, рынки и теории",
            topic = "Финансы",
            level = 4
        ),
        WordSetEntity(
            id = 1092, languagePair = "he-ru", orderIndex = 1092,
            name = "Философия: продвинутый 2",
            description = "Направления, понятия и великие вопросы",
            topic = "Философия",
            level = 2
        ),
        WordSetEntity(
            id = 1093, languagePair = "he-ru", orderIndex = 1093,
            name = "Природа и экология: профессиональный",
            description = "Изменение климата, экополитика и решения",
            topic = "Природа и экология",
            level = 4
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Set 1091: Экономика ────────────────────────────────────────────

        // RARE (B2)
        WordEntity(id = 109101, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "דִּיבִידֶנְד", translation = "дивиденд", transliteration = "dividend"),
        WordEntity(id = 109102, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "תְּשׁוּאָה", translation = "доходность; доход на инвестиции", transliteration = "tshu'a"),
        WordEntity(id = 109103, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "מִינוּף", translation = "кредитное плечо; леверидж", transliteration = "minuf"),
        WordEntity(id = 109104, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "תִּזְרִים מָזוּמָן", translation = "денежный поток", transliteration = "tizrim mazuman"),
        WordEntity(id = 109105, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "נְיָר עֵרֶךְ", translation = "ценная бумага", transliteration = "nyar erekh"),
        WordEntity(id = 109106, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "קֶרֶן גֵּידוּר", translation = "хедж-фонд", transliteration = "keren gidur"),
        WordEntity(id = 109107, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "פּוֹרְטְפוֹלִיוֹ", translation = "инвестиционный портфель", transliteration = "portfolio"),
        WordEntity(id = 109108, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "אֶגְרוֹת חוֹב", translation = "облигации", transliteration = "igrot khov"),
        WordEntity(id = 109109, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "מַטְבֵּעַ דִּיגִיטָלִי", translation = "цифровая валюта", transliteration = "matbe'a digitali"),
        WordEntity(id = 109110, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "מִמְשָׁל תַּאֲגִידִי", translation = "корпоративное управление", transliteration = "mimshal ta'agidi"),

        // EPIC (C1)
        WordEntity(id = 109111, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "מַסְחַר אַלְגוֹרִיתְמִי", translation = "алгоритмическая торговля", transliteration = "maskhar algoritmí"),
        WordEntity(id = 109112, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "פִּינְתֶּק", translation = "финтех; финансовые технологии", transliteration = "fintek"),
        WordEntity(id = 109113, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "אֶקוֹנוֹמֶטְרְיָה", translation = "эконометрика", transliteration = "ekonometrya"),
        WordEntity(id = 109114, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "כַּלְכָּלָה דִּיגִיטָלִית", translation = "цифровая экономика", transliteration = "kalkala digitalit"),
        WordEntity(id = 109115, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "חַדְשָׁנוּת פִּינַנְסִית", translation = "финансовые инновации", transliteration = "khadshmanut finansit"),
        WordEntity(id = 109116, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "בּוּעָה כַּלְכָּלִית", translation = "экономический пузырь", transliteration = "bu'a kalkalit"),

        // RARE (B2)
        WordEntity(id = 109117, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "פּרוֹטֶקְצְיוֹנִיזְם", translation = "протекционизм"),
        WordEntity(id = 109118, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "כַּלְכָּלַת שׁוּק", translation = "рыночная экономика"),
        WordEntity(id = 109119, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "כַּלְכָּלָה תַּכְנוּנִית", translation = "плановая экономика"),
        WordEntity(id = 109120, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "מַקְרוֹ-כַּלְכָּלָה", translation = "макроэкономика"),
        WordEntity(id = 109121, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "מִיקְרוֹ-כַּלְכָּלָה", translation = "микроэкономика"),

        // EPIC (C1)
        WordEntity(id = 109122, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "פּוֹפּוּלִיזְם כַּלְכָּלִי", translation = "экономический популизм"),
        WordEntity(id = 109123, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "כַּלְכָּלָה הֶתְנְהַגּוּתִית", translation = "поведенческая экономика"),
        WordEntity(id = 109124, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "תֵּיאוֹרְיַת הַמִּשְׂחָקִים", translation = "теория игр"),

        WordEntity(id = 109125, setId = 1091, languagePair = "he-ru", rarity = "EPIC",
            original = "נִיהוּל סִיכּוּנִים פִּינַנְסִיִּים", translation = "управление финансовыми рисками", transliteration = "nihul sikunim finansiyim"),

        // ── Set 1092: Философия ────────────────────────────────────────────

        // UNCOMMON (A2-B1)
        WordEntity(id = 109201, setId = 1092, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תֵּאוֹלוֹגְיָה", translation = "теология", transliteration = "teologia"),
        WordEntity(id = 109202, setId = 1092, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הוּמָנִיזְם", translation = "гуманизм", transliteration = "humanism"),
        WordEntity(id = 109203, setId = 1092, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אִידֵאָלִיזְם", translation = "идеализм", transliteration = "idealizm"),
        WordEntity(id = 109204, setId = 1092, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סְקֶפְּטִיצִיזְם", translation = "скептицизм", transliteration = "skeptitsizm"),
        WordEntity(id = 109205, setId = 1092, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מָטֵרְיַאלִיזְם", translation = "материализм", transliteration = "materializm"),
        WordEntity(id = 109206, setId = 1092, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אַגְנוֹסְטִיצִיזְם", translation = "агностицизм", transliteration = "agnostitsizm"),

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
            original = "סְטוֹאִיּוּת", translation = "стоицизм"),
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
            original = "הֶרְמֶנֵיוּטִיקָה", translation = "герменевтика"),
        WordEntity(id = 109219, setId = 1092, languagePair = "he-ru", rarity = "RARE",
            original = "שָׁאֵלָה פִּילוֹסוֹפִית", translation = "философский вопрос"),
        WordEntity(id = 109220, setId = 1092, languagePair = "he-ru", rarity = "RARE",
            original = "פּוֹלֵמִיקָה", translation = "полемика"),
        WordEntity(id = 109221, setId = 1092, languagePair = "he-ru", rarity = "RARE",
            original = "אוּטִיָּה", translation = "утопия"),

        WordEntity(id = 109222, setId = 1092, languagePair = "he-ru", rarity = "RARE",
            original = "הֶדוֹנִיזְם", translation = "гедонизм", transliteration = "hedonizm"),
        WordEntity(id = 109223, setId = 1092, languagePair = "he-ru", rarity = "RARE",
            original = "אוּטִילִיטָרִיזְם", translation = "утилитаризм", transliteration = "utilitarizm"),
        WordEntity(id = 109224, setId = 1092, languagePair = "he-ru", rarity = "RARE",
            original = "אַלְטְרוּאִיזְם", translation = "альтруизм", transliteration = "altruizm"),
        WordEntity(id = 109225, setId = 1092, languagePair = "he-ru", rarity = "RARE",
            original = "אַבְּסוּרְדִיזְם", translation = "абсурдизм", transliteration = "absurdizm"),

        // ── Set 1093: Климат и устойчивость ───────────────────────────────

        // RARE (B2)
        WordEntity(id = 109301, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "אֶקוֹסִיסְטֶם", translation = "экосистема", transliteration = "ekosistem"),
        WordEntity(id = 109302, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "שַׁכְבַת אוֹזוֹן", translation = "озоновый слой", transliteration = "shakhvat ozon"),
        WordEntity(id = 109303, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "בִּיוֹסְפֵרָה", translation = "биосфера", transliteration = "biosfera"),
        WordEntity(id = 109304, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "פַּחְמֵן", translation = "углерод", transliteration = "pakhmen"),
        WordEntity(id = 109305, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "יְעָרוּת מִחָדָשׁ", translation = "лесовосстановление", transliteration = "ye'arut mikhadash"),
        WordEntity(id = 109306, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "אֵנֶרְגְּיַת גֵּיאוֹתֶרְמִית", translation = "геотермальная энергия", transliteration = "energyat geotermit"),
        WordEntity(id = 109307, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "מִיחְזוּר מַיִם", translation = "переработка воды", transliteration = "mikhzur mayim"),
        WordEntity(id = 109308, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "טֶכְנוֹלוֹגְיָה יְרוּקָּה", translation = "зелёные технологии", transliteration = "tekhnologia yeruká"),
        WordEntity(id = 109309, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "הַגְנַת הַסְּבִיבָה", translation = "охрана окружающей среды", transliteration = "hagnat haseviva"),
        WordEntity(id = 109310, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "רֵגוּלָצְיַת פְּלִיטוֹת", translation = "регулирование выбросов", transliteration = "regulatziat plitot"),

        // EPIC (C1)
        WordEntity(id = 109311, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "מֵימַן יָרוֹק", translation = "зелёный водород", transliteration = "meiman yarok"),
        WordEntity(id = 109312, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "לֶכֶד פֶּחָמָן", translation = "улавливание углерода", transliteration = "lekhed pekhaman"),
        WordEntity(id = 109313, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "הַנְדָּסַת סְבִיבָה", translation = "экологическая инженерия", transliteration = "handasat seviva"),
        WordEntity(id = 109314, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "שׁוּק פְּלִיטוֹת", translation = "рынок выбросов; торговля выбросами", transliteration = "shuk plitot"),
        WordEntity(id = 109315, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "תֶּשְׁתִּית אֶנֶרְגְּיָה מִתְחַדֶּשֶׁת", translation = "инфраструктура возобновляемой энергии", transliteration = "tshtit energia mitkhadeshet"),
        WordEntity(id = 109316, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "מְדִינִיּוּת קִיּוּמִיּוּת", translation = "политика устойчивого развития", transliteration = "mediniyut kiyumiyut"),

        // RARE (B2)
        WordEntity(id = 109317, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "מַפֶּלֶת הַבִּיוֹדִיבֶרְסִיטִי", translation = "утрата биоразнообразия"),
        WordEntity(id = 109318, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "טְבִיעַת רֶגֶל", translation = "углеродный след"),
        WordEntity(id = 109319, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "תַּשְׁתִּית יְרוּקָּה", translation = "зелёная инфраструктура"),
        WordEntity(id = 109320, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "מִשְׁבַּר אֶקְלִים", translation = "климатический кризис"),
        WordEntity(id = 109321, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "עַרְפִּיחַ", translation = "смог"),

        // EPIC (C1)
        WordEntity(id = 109322, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "כַּלְכָּלָה דֶּקַרְבּוֹנִיזַצְיָה", translation = "декарбонизация экономики"),
        WordEntity(id = 109323, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "צְמִיחָה כְּחוּלָה", translation = "зелёный/голубой рост (устойчивое развитие)"),
        WordEntity(id = 109324, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "פְּגִיעוּת אֶקוֹ-סִיסְטֶמִית", translation = "уязвимость экосистем"),

        WordEntity(id = 109325, setId = 1093, languagePair = "he-ru", rarity = "EPIC",
            original = "תַּקְצוּב פֶּחָמָן", translation = "углеродный бюджет; бюджетирование углерода", transliteration = "taktzuv pekhaman"),
    )
}
