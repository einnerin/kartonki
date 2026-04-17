package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrewBatch20 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1082, languagePair = "he-ru", orderIndex = 1082,
            name = "История Израиля",
            description = "Исторические события и понятия B2/C1",
        ),
        WordSetEntity(
            id = 1083, languagePair = "he-ru", orderIndex = 1083,
            name = "Социальные сети",
            description = "Интернет-коммуникации и медиа A2/B2",
        ),
        WordSetEntity(
            id = 1084, languagePair = "he-ru", orderIndex = 1084,
            name = "Кулинария: углублённо",
            description = "Продвинутые техники и термины B2/C1",
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Set 1082: История Израиля ──────────────────────────────────────

        // COMMON (A1)
        WordEntity(id = 108201, setId = 1082, languagePair = "he-ru", rarity = "COMMON",
            original = "מְדִינָה", translation = "государство"),
        WordEntity(id = 108202, setId = 1082, languagePair = "he-ru", rarity = "COMMON",
            original = "עַצְמָאוּת", translation = "независимость"),
        WordEntity(id = 108203, setId = 1082, languagePair = "he-ru", rarity = "COMMON",
            original = "הַקָּמָה", translation = "основание / учреждение (государства)"),
        WordEntity(id = 108204, setId = 1082, languagePair = "he-ru", rarity = "COMMON",
            original = "גְּבוּל", translation = "граница"),
        WordEntity(id = 108205, setId = 1082, languagePair = "he-ru", rarity = "COMMON",
            original = "מִלְחָמָה", translation = "война"),
        WordEntity(id = 108206, setId = 1082, languagePair = "he-ru", rarity = "COMMON",
            original = "תְּקוּמָה", translation = "возрождение, восстановление"),

        // UNCOMMON (A2-B1)
        WordEntity(id = 108207, setId = 1082, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַכְרָזָה", translation = "декларация, провозглашение"),
        WordEntity(id = 108208, setId = 1082, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "צִיּוֹנוּת", translation = "сионизм"),
        WordEntity(id = 108209, setId = 1082, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פְּלִיטִים", translation = "беженцы"),
        WordEntity(id = 108210, setId = 1082, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "כִּבּוּשׁ", translation = "оккупация, завоевание"),
        WordEntity(id = 108211, setId = 1082, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "יִישּׁוּב", translation = "ишув (еврейская община в Эрец-Исраэль до 1948)"),
        WordEntity(id = 108212, setId = 1082, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שׁוֹאָה", translation = "Холокост"),
        WordEntity(id = 108213, setId = 1082, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "נַכְבָּה", translation = "Накба (палестинская катастрофа 1948 г.)"),
        WordEntity(id = 108214, setId = 1082, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חֲלוּצִים", translation = "халуцим, пионеры-первопроходцы"),
        WordEntity(id = 108215, setId = 1082, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הֶסְכֵּם אוֹסְלוֹ", translation = "Соглашения Осло"),
        WordEntity(id = 108216, setId = 1082, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גְּלוּת", translation = "изгнание, диаспора"),

        // RARE (B2)
        WordEntity(id = 108217, setId = 1082, languagePair = "he-ru", rarity = "RARE",
            original = "קִיבּוּץ", translation = "кибуц"),
        WordEntity(id = 108218, setId = 1082, languagePair = "he-ru", rarity = "RARE",
            original = "מוֹשָׁב", translation = "мошав (кооперативное поселение)"),
        WordEntity(id = 108219, setId = 1082, languagePair = "he-ru", rarity = "RARE",
            original = "מַחְתֶּרֶת", translation = "подполье, подпольное движение"),
        WordEntity(id = 108220, setId = 1082, languagePair = "he-ru", rarity = "RARE",
            original = "דִּפְלוֹמַטְיָה", translation = "дипломатия"),
        WordEntity(id = 108221, setId = 1082, languagePair = "he-ru", rarity = "RARE",
            original = "פְּרוֹטֶקְטוֹרָט", translation = "протекторат"),

        // EPIC (C1)
        WordEntity(id = 108222, setId = 1082, languagePair = "he-ru", rarity = "EPIC",
            original = "רֶוִיזְיוֹנִיזְם", translation = "ревизионизм (движение Жаботинского)"),
        WordEntity(id = 108223, setId = 1082, languagePair = "he-ru", rarity = "EPIC",
            original = "נְאוֹ-צִיּוֹנוּת", translation = "неосионизм"),
        WordEntity(id = 108224, setId = 1082, languagePair = "he-ru", rarity = "EPIC",
            original = "פּוֹסְט-צִיּוֹנוּת", translation = "постсионизм"),

        // LEGENDARY (C2)
        WordEntity(id = 108225, setId = 1082, languagePair = "he-ru", rarity = "EPIC",
            original = "הַצְהָרַת בַּלְפוּר", translation = "Декларация Бальфура (1917)"),

        // ── Set 1083: Социальные сети ──────────────────────────────────────

        // COMMON (A1)
        WordEntity(id = 108301, setId = 1083, languagePair = "he-ru", rarity = "COMMON",
            original = "פּוֹסְט", translation = "пост, публикация"),
        WordEntity(id = 108302, setId = 1083, languagePair = "he-ru", rarity = "COMMON",
            original = "עוֹקֵב", translation = "подписчик, фолловер"),
        WordEntity(id = 108303, setId = 1083, languagePair = "he-ru", rarity = "COMMON",
            original = "לִקָּה", translation = "лайк, отметка «нравится»"),
        WordEntity(id = 108304, setId = 1083, languagePair = "he-ru", rarity = "COMMON",
            original = "תַּגִּית", translation = "хэштег, тег"),
        WordEntity(id = 108305, setId = 1083, languagePair = "he-ru", rarity = "COMMON",
            original = "שִׁיתּוּף", translation = "репост, шеринг"),
        WordEntity(id = 108306, setId = 1083, languagePair = "he-ru", rarity = "COMMON",
            original = "פִּיד", translation = "лента (feed)"),

        // UNCOMMON (A2-B1)
        WordEntity(id = 108307, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תּוֹכֶן", translation = "контент"),
        WordEntity(id = 108308, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַשְׁפִּיעַן", translation = "инфлюенсер, лидер мнений"),
        WordEntity(id = 108309, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סְטוֹרִי", translation = "сторис (ephemeral story в соцсетях)"),
        WordEntity(id = 108310, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "וִידֵאוֹ קָצָר", translation = "короткое видео (reels/shorts)"),
        WordEntity(id = 108311, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "נְטְוּרְקִינְג", translation = "нетворкинг"),
        WordEntity(id = 108312, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "וִירַלִי", translation = "вирусный (о контенте)"),
        WordEntity(id = 108313, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קְהִיּלָה מְקוּוֶּנֶת", translation = "онлайн-сообщество"),
        WordEntity(id = 108314, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַנְחָיוֹת קְהִיּלָה", translation = "правила сообщества (community guidelines)"),
        WordEntity(id = 108315, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "בּוֹט", translation = "бот (автоматический аккаунт)"),
        WordEntity(id = 108316, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שִׁיּוּף", translation = "троллинг, киберхарассмент"),

        // RARE (B2)
        WordEntity(id = 108317, setId = 1083, languagePair = "he-ru", rarity = "RARE",
            original = "מוֹנֵטִיזַצְיָה", translation = "монетизация"),
        WordEntity(id = 108318, setId = 1083, languagePair = "he-ru", rarity = "RARE",
            original = "הַאֱלִימוּת מְקוּוֶּנֶת", translation = "кибербуллинг (онлайн-травля)"),
        WordEntity(id = 108319, setId = 1083, languagePair = "he-ru", rarity = "RARE",
            original = "פְּרָטִיּוּת מְקוּוֶּנֶת", translation = "онлайн-приватность"),
        WordEntity(id = 108320, setId = 1083, languagePair = "he-ru", rarity = "RARE",
            original = "מִידָע שֶׁקֶר", translation = "дезинформация, фейк"),
        WordEntity(id = 108321, setId = 1083, languagePair = "he-ru", rarity = "RARE",
            original = "תְּקְשׁוֹרֶת חֶבְרָתִית", translation = "социальная коммуникация"),

        // EPIC (C1)
        WordEntity(id = 108322, setId = 1083, languagePair = "he-ru", rarity = "RARE",
            original = "פִּילְטֶר בּוּעָה", translation = "пузырь фильтров (filter bubble)"),
        WordEntity(id = 108323, setId = 1083, languagePair = "he-ru", rarity = "RARE",
            original = "בּוּעַת מֵידָע", translation = "информационный пузырь"),
        WordEntity(id = 108324, setId = 1083, languagePair = "he-ru", rarity = "RARE",
            original = "הַגְבָּרַת תּוֹכֶן", translation = "усиление контента (content amplification)"),

        // LEGENDARY (C2)
        WordEntity(id = 108325, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "media_trust", transliteration = "aminut",
            original = "אֲמִינוּת", translation = "надёжность, достоверность"),

        WordEntity(id = 108401, setId = 1084, languagePair = "he-ru", rarity = "COMMON",
            original = "מָרִינָדָה", translation = "маринад"),
        WordEntity(id = 108402, setId = 1084, languagePair = "he-ru", rarity = "COMMON",
            original = "צְלִיָּה", translation = "жарка на гриле, запекание"),
        WordEntity(id = 108403, setId = 1084, languagePair = "he-ru", rarity = "COMMON",
            original = "אֵדוּי", translation = "варка на пару"),
        WordEntity(id = 108404, setId = 1084, languagePair = "he-ru", rarity = "COMMON",
            original = "בָּצֵק", translation = "тесто"),
        WordEntity(id = 108405, setId = 1084, languagePair = "he-ru", rarity = "COMMON",
            original = "מְגֵרֶד", translation = "тёрка"),
        WordEntity(id = 108406, setId = 1084, languagePair = "he-ru", rarity = "COMMON",
            original = "שׁוֹקוֹלָד", translation = "шоколад"),

        // UNCOMMON (A2-B1)
        WordEntity(id = 108407, setId = 1084, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טִגּוּן עָמֹק", translation = "жарка во фритюре"),
        WordEntity(id = 108408, setId = 1084, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קַרְמֶלִיזַצְיָה", translation = "карамелизация"),
        WordEntity(id = 108409, setId = 1084, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עֲשָׂבֵי תִּבּוּל", translation = "ароматные травы, зелень"),
        WordEntity(id = 108410, setId = 1084, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "לִישָׁה", translation = "замешивание теста"),
        WordEntity(id = 108411, setId = 1084, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַקְפָּצָה", translation = "обжаривание при постоянном помешивании (стир-фрай)"),
        WordEntity(id = 108412, setId = 1084, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שְׂאוֹר", translation = "закваска"),
        WordEntity(id = 108413, setId = 1084, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גְּרָטֵן", translation = "гратен (запеканка с корочкой)"),
        WordEntity(id = 108414, setId = 1084, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סוּפְלֵה", translation = "суфле"),
        WordEntity(id = 108415, setId = 1084, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פּוּרֵה", translation = "пюре"),
        WordEntity(id = 108416, setId = 1084, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קֶרֶם פַּטִיסְיֵר", translation = "крем-патисьер (заварной крем)"),

        // RARE (B2)
        WordEntity(id = 108417, setId = 1084, languagePair = "he-ru", rarity = "RARE",
            original = "אֶמוּלְסִיָּה", translation = "эмульсия"),
        WordEntity(id = 108418, setId = 1084, languagePair = "he-ru", rarity = "RARE",
            original = "רֶדוּקְצְיָה", translation = "редукция (упаривание соуса)"),
        WordEntity(id = 108419, setId = 1084, languagePair = "he-ru", rarity = "RARE",
            original = "בְּלַנְשִׁינְג", translation = "бланширование"),
        WordEntity(id = 108420, setId = 1084, languagePair = "he-ru", rarity = "RARE",
            original = "קוֹנְפִי", translation = "конфи (медленное томление в жире)"),
        WordEntity(id = 108421, setId = 1084, languagePair = "he-ru", rarity = "RARE",
            original = "פְּלֵיטִינְג", translation = "сервировка блюда (plating)"),

        // EPIC (C1)
        WordEntity(id = 108422, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            original = "גַּסְטְרוֹנוֹמִיָּה", translation = "гастрономия"),
        WordEntity(id = 108423, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            original = "מֵיאָרְ", translation = "реакция Майяра (потемнение при жарке)"),
        WordEntity(id = 108424, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            original = "בְּרוּנוֹאָז", translation = "брюнуаз (мелкая кубическая нарезка)"),

        // LEGENDARY (C2)
        WordEntity(id = 108425, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            original = "טֶרוּאָר", translation = "терруар (влияние места на продукт)"),
    )
}
