package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrewBatch20 {

    val sets: List<WordSetEntity> = listOf(
                WordSetEntity(
            id = 1083, languagePair = "he-ru", orderIndex = 1083,
            name = "Технологии",
            description = "Интернет-коммуникации и медиа",
            topic = "Технологии",
            level = 2
        ),
        WordSetEntity(
            id = 1084, languagePair = "he-ru", orderIndex = 1084,
            name = "Еда и кулинария",
            description = "Продвинутые техники и термины",
            topic = "Еда и кулинария",
            level = 4
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Set 1082: Алия и Израиль — продвинутый ───────────────────────

        // UNCOMMON (A2–B1),
        
        
        
        
        
        
        
        
        
        
        
        

        // RARE (B2),
                                                                                                        
        // ── Set 1083: Социальные сети ──────────────────────────────────────

        // COMMON (A1),
        WordEntity(id = 108301, setId = 1083, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "social_media", transliteration = "post",
            original = "פּוֹסְט", translation = "пост, публикация"),
        WordEntity(id = 108302, setId = 1083, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "social_media", transliteration = "okev",
            original = "עוֹקֵב", translation = "подписчик, фолловер"),
        WordEntity(id = 108303, setId = 1083, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "social_media", transliteration = "lika",
            original = "לִקָּה", translation = "лайк, отметка «нравится»"),
        WordEntity(id = 108304, setId = 1083, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "social_media", transliteration = "tagit",
            original = "תַּגִּית", translation = "хэштег, тег"),
        WordEntity(id = 108305, setId = 1083, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "social_media", transliteration = "shituf",
            original = "שִׁיתּוּף", translation = "репост, шеринг"),
        WordEntity(id = 108306, setId = 1083, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "social_media", transliteration = "fid",
            original = "פִּיד", translation = "лента (feed)"),

        // UNCOMMON (A2-B1),
        WordEntity(id = 108307, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "social_media", transliteration = "tokhen",
            original = "תּוֹכֶן", translation = "контент"),
        WordEntity(id = 108308, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "social_media", transliteration = "mashpian",
            original = "מַשְׁפִּיעַן", translation = "инфлюенсер, лидер мнений"),
        WordEntity(id = 108309, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "social_media", transliteration = "stori",
            original = "סְטוֹרִי", translation = "сторис (ephemeral story в соцсетях)"),
        WordEntity(id = 108310, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "social_media", transliteration = "video katsar",
            original = "וִידֵאוֹ קָצָר", translation = "короткое видео (reels/shorts)"),
        WordEntity(id = 108311, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "social_media", transliteration = "netvurking",
            original = "נְטְוּרְקִינְג", translation = "нетворкинг"),
        WordEntity(id = 108312, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "social_media", transliteration = "virali",
            original = "וִירַלִי", translation = "вирусный (о контенте)"),
        WordEntity(id = 108313, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "social_media", transliteration = "kehila mekuvenet",
            original = "קְהִיּלָה מְקוּוֶּנֶת", translation = "онлайн-сообщество"),
        WordEntity(id = 108314, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "social_media", transliteration = "hankhayot kehila",
            original = "הַנְחָיוֹת קְהִיּלָה", translation = "правила сообщества (community guidelines)"),
        WordEntity(id = 108315, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "social_media", transliteration = "bot",
            original = "בּוֹט", translation = "бот (автоматический аккаунт)"),
        WordEntity(id = 108316, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "social_media", transliteration = "shiyuf",
            original = "שִׁיּוּף", translation = "троллинг, киберхарассмент"),

        // RARE (B2),
        WordEntity(id = 108317, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "social_media", transliteration = "taguba",
            original = "תַּגּוּבָה", translation = "комментарий, ответ"),
        WordEntity(id = 108318, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "social_media", transliteration = "arats",
            original = "עֲרוֹץ", translation = "канал (в соцсетях или мессенджере)"),
        WordEntity(id = 108319, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "social_media", transliteration = "muda'a",
            original = "מוּדָעָה", translation = "рекламное объявление"),
        WordEntity(id = 108320, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "social_media", transliteration = "hamlatsa",
            original = "הֲמָלָצָה", translation = "рекомендация (алгоритма)"),
        WordEntity(id = 108321, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "social_media", transliteration = "ekhsun ba-anan",
            original = "אֶחְסוּן בָּעֲנָן", translation = "облачное хранилище"),
        WordEntity(id = 108322, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "social_media", transliteration = "emoji",
            original = "אֵמוֹגִ'י", translation = "эмодзи"),
        WordEntity(id = 108323, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "social_media", transliteration = "reshet khevratit",
            original = "רְשָׁת חֶבְרָתִית", translation = "социальная сеть"),
        WordEntity(id = 108324, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "social_media", transliteration = "shidup khai",
            original = "שִׁדּוּר חִי", translation = "прямой эфир, лайвстрим"),
        WordEntity(id = 108325, setId = 1083, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "media_trust", transliteration = "aminut",
            original = "אֲמִינוּת", translation = "надёжность, достоверность"),

        // ── Set 1084: Еда и кулинария ──────────────────────────────────────

        // RARE (B2),
        WordEntity(id = 108401, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "miz an plas",
            original = "מִיז אָן פְּלָס", translation = "мизанплас (подготовка ингредиентов перед готовкой)"),
        WordEntity(id = 108402, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "demi glas",
            original = "דֵּמִי גְלַס", translation = "деми-гляс (концентрированный соус)"),
        WordEntity(id = 108403, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "beshamel",
            original = "בֶּשָׁמֶל", translation = "соус бешамель"),
        WordEntity(id = 108404, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "vinigret",
            original = "וִינַיְגְרֵט", translation = "винегрет (масляно-уксусная заправка)"),
        WordEntity(id = 108405, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "shliqa",
            original = "שְׁלִיקָה", translation = "варка-пашот (в едва кипящей жидкости)"),
        WordEntity(id = 108406, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "zgiga",
            original = "זְגִיגָה", translation = "глазирование (покрытие блестящим соусом)"),
        WordEntity(id = 108407, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "breizing",
            original = "בְּרֵיזִינְג", translation = "брезирование (тушение в малом количестве жидкости)"),
        WordEntity(id = 108408, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "marak etsem",
            original = "מַרַק עֶצֶם", translation = "костный бульон"),
        WordEntity(id = 108409, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "rotev em",
            original = "רוֹטֵב אֵם", translation = "материнский соус (base sauce)"),
        WordEntity(id = 108410, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "panira",
            original = "פַּנִּירָה", translation = "панировка"),
        WordEntity(id = 108411, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "batsek alim",
            original = "בָּצֵק עָלִים", translation = "слоёное тесто"),
        WordEntity(id = 108412, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "makhmasa",
            original = "מַחְמָצָה", translation = "закваска для хлеба"),
        WordEntity(id = 108413, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "pastrami",
            original = "פַּסְטְרִימִי", translation = "пастрами (вяленая копчёная говядина)"),
        WordEntity(id = 108414, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "so-vi",
            original = "סוֹ-וִי", translation = "су-вид (готовка в вакуумном пакете)"),
        WordEntity(id = 108415, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "zaafran",
            original = "זָעְפְּרָן", translation = "шафран"),
        WordEntity(id = 108416, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "shalot",
            original = "שָׁלוֹט", translation = "шалот (лук-шалот)"),

        // RARE (B2),
        WordEntity(id = 108417, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "emulsiya",
            original = "אֶמוּלְסִיָּה", translation = "эмульсия"),
        WordEntity(id = 108418, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "reduktsiya",
            original = "רֶדוּקְצְיָה", translation = "редукция (упаривание соуса)"),
        WordEntity(id = 108419, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "blanching",
            original = "בְּלַנְשִׁינְג", translation = "бланширование"),
        WordEntity(id = 108420, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "konfi",
            original = "קוֹנְפִי", translation = "конфи (медленное томление в жире)"),
        WordEntity(id = 108421, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "plating",
            original = "פְּלֵיטִינְג", translation = "сервировка блюда (plating)"),

        // EPIC (C1),
        WordEntity(id = 108422, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "gastronomiya",
            original = "גַּסְטְרוֹנוֹמִיָּה", translation = "гастрономия"),
        WordEntity(id = 108423, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "mayar",
            original = "מֵיאָרְ", translation = "реакция Майяра (потемнение при жарке)"),
        WordEntity(id = 108424, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "brunuaz",
            original = "בְּרוּנוֹאָז", translation = "брюнуаз (мелкая кубическая нарезка)"),
        WordEntity(id = 108425, setId = 1084, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cooking", transliteration = "teruar",
            original = "טֶרוּאָר", translation = "терруар (влияние места на продукт)"),
    )
}
