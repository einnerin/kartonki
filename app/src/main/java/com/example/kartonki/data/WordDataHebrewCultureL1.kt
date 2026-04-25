package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Культура и искусство" (L1).
 * 1 set × 25 words = 25 слов. setId = 1704.
 *
 *  - 1704 (L1, COMMON+UNCOMMON): базовая лексика искусства — музыка, фильм, картина.
 *
 * Распределение редкостей: 15 COMMON + 10 UNCOMMON.
 * Иврит: огласовки niqqud сохраняются; внутри ивритских строк не используем
 * кавычки (' или ") во избежание визуальных и парсерных конфликтов.
 *
 * Дубли по теме «Культура и искусство» проверены — все 25 ивритских слов
 * не пересекаются со словами из существующих культурных сетов
 * (1012, 1013, 1072, 1075, 1079, 1184, 1185, 1186, 1264, 1265, 1266 и др.).
 * Дубли в других темах (Работа, Журналист, Город) допустимы по правилу проекта.
 */
object WordDataHebrewCultureL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1704, languagePair = "he-ru", orderIndex = 1704,
            name = "Культура и искусство",
            description = "Базовая лексика искусства: музыка, фильм, картина",
            topic = "Культура и искусство", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── Set 1704 — основы культуры (level 1, COMMON + UNCOMMON) ──────────
        // Semantic subgroups:
        //   arts_general · arts_painters · arts_writers
        //   arts_singers · arts_dancers · arts_music · arts_show

        // ── arts_general (5) ─────────────────────────────────────────────────
        WordEntity(
            id = 170401, setId = 1704, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "arts_general",
            original = "תְּמוּנָה", translation = "картина",
            transliteration = "tmuna",
            definition = "צִיּוּר אוֹ צִילּוּם בְּתוֹךְ מִסְגֶּרֶת עַל הַקִּיר.",
            definitionNative = "Изображение в рамке, висящее на стене.",
            example = "תְּמוּנָה יָפָה תְּלוּיָה בַּסָּלוֹן שֶׁל סָבָתָא.",
            exampleNative = "Красивая תְּמוּנָה висит у бабушки в гостиной.",
         fillInBlankExclusions = listOf(170402L, 170404L, 170405L)),
        WordEntity(
            id = 170402, setId = 1704, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "arts_general",
            original = "יְצִירָה", translation = "произведение",
            transliteration = "yetsira",
            definition = "כָּל דָּבָר שֶׁאָדָם יוֹצֵר — תְּמוּנָה, סֵפֶר אוֹ מַנְגִּינָה.",
            definitionNative = "Всё, что создаёт человек: образ, книга или мелодия.",
            example = "הַיְצִירָה הַזּוֹ נִכְתְּבָה לִפְנֵי שָׁנִים רַבּוֹת.",
            exampleNative = "Эта יְצִירָה написана много лет назад.",
         fillInBlankExclusions = listOf(170401L, 170404L, 170405L)),
        WordEntity(
            id = 170403, setId = 1704, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "arts_general",
            original = "אַמָּנוּתִי", translation = "художественный",
            transliteration = "amanuti",
            definition = "כָּזֶה הַשַּׁיָּךְ לְעוֹלָם הַיֵּצֶר וְלֹא לִדְבָרִים מַעֲשִׂיִּים.",
            definitionNative = "Относящийся к миру творчества, а не к практическим вещам.",
            example = "הַסֶּרֶט הַזֶּה הוּא סֶרֶט אַמָּנוּתִי וְלֹא מִסְחָרִי.",
            exampleNative = "Этот фильм — אַמָּנוּתִי, а не коммерческий.",
        ),
        WordEntity(
            id = 170404, setId = 1704, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "arts_general",
            original = "צֶבַע", translation = "цвет",
            transliteration = "tseva",
            definition = "הָרֹשֶׁם הַחֲזוּתִי שֶׁמַּבְדִּיל בֵּין אָדוֹם, כָּחוֹל וְיָרוֹק.",
            definitionNative = "Зрительное свойство, отличающее красное от синего и зелёного.",
            example = "הִיא בָּחֲרָה צֶבַע חַם לַקִּיר שֶׁל הַחֶדֶר.",
            exampleNative = "Она выбрала тёплый צֶבַע для стены комнаты.",
         fillInBlankExclusions = listOf(170401L, 170402L, 170405L)),
        WordEntity(
            id = 170405, setId = 1704, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "arts_general",
            original = "סְטוּדְיוֹ", translation = "студия",
            transliteration = "studyo",
            definition = "חֶדֶר עֲבוֹדָה לְצַיָּר, צַלָּם אוֹ נַגָּן הַמַּקְלִיט שָׁם.",
            definitionNative = "Рабочая комната живописца, фотографа или музыканта для записи.",
            example = "הַצַּיֶּרֶת מַשְׁקִיעָה כָּל יוֹם שָׁעוֹת בַּסְּטוּדְיוֹ.",
            exampleNative = "Художница каждый день проводит часы в סְטוּדְיוֹ.",
        ),

        // ── arts_painters (2 — гендерная пара) ───────────────────────────────
        WordEntity(
            id = 170406, setId = 1704, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "arts_painters",
            original = "צַיָּר", translation = "художник",
            transliteration = "tsayar",
            definition = "אָדָם שֶׁמְּעַצֵּב תְּמוּנוֹת בְּצֶבַע עַל בַּד אוֹ עַל נְיָר.",
            definitionNative = "Тот, кто создаёт изображения красками на холсте или бумаге.",
            example = "הַצַּיָּר עָבַד עַל הַתְּמוּנָה הַחֲדָשָׁה כָּל הַיּוֹם.",
            exampleNative = "צַיָּר весь день работал над новой картиной.",
        ),
        WordEntity(
            id = 170407, setId = 1704, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "arts_painters",
            original = "צַיֶּרֶת", translation = "художница",
            transliteration = "tsayeret",
            definition = "אִשָּׁה שֶׁמְּעַצֶּבֶת תְּמוּנוֹת בְּצֶבַע עַל בַּד אוֹ עַל נְיָר.",
            definitionNative = "Женщина, создающая изображения красками на холсте или бумаге.",
            example = "הַצַּיֶּרֶת מָכְרָה אֶת הָעֲבוֹדוֹת שֶׁלָּהּ בַּתַּעֲרוּכָה.",
            exampleNative = "צַיֶּרֶת продала свои работы на выставке.",
        ),

        // ── arts_writers (4) ─────────────────────────────────────────────────
        WordEntity(
            id = 170408, setId = 1704, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "arts_writers",
            original = "סוֹפֵר", translation = "писатель",
            transliteration = "sofer",
            definition = "אָדָם שֶׁכּוֹתֵב סִפְרֵי מַחֲשָׁבָה אוֹ עֲלִילוֹת לָקוֹרְאִים.",
            definitionNative = "Тот, кто сочиняет книги — повести или романы — для читателей.",
            example = "הַסּוֹפֵר חָתַם עַל סִפְרוֹ הֶחָדָשׁ בַּחֲנוּת.",
            exampleNative = "סוֹפֵר раздавал автографы в книжном магазине.",
        ),
        WordEntity(
            id = 170409, setId = 1704, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "arts_writers",
            original = "סוֹפֶרֶת", translation = "писательница",
            transliteration = "soferet",
            definition = "אִשָּׁה שֶׁכּוֹתֶבֶת סִפְרֵי מַחֲשָׁבָה אוֹ עֲלִילוֹת לָקוֹרְאִים.",
            definitionNative = "Женщина, сочиняющая книги — повести или романы — для читателей.",
            example = "הַסּוֹפֶרֶת זָכְתָה בַּפְּרָס עַל הָרוֹמָן הָרִאשׁוֹן שֶׁלָּהּ.",
            exampleNative = "סוֹפֶרֶת получила премию за свой первый роман.",
        ),
        WordEntity(
            id = 170410, setId = 1704, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "arts_writers",
            original = "סִפּוּר", translation = "рассказ",
            transliteration = "sipur",
            definition = "טֶקְסְט קָצָר עִם עֲלִילָה, גִּבּוֹרִים וְסוֹף.",
            definitionNative = "Короткий текст с сюжетом, героями и развязкой.",
            example = "אִמָּא קוֹרֵאת לִי סִפּוּר לִפְנֵי הַשֵּׁנָה.",
            exampleNative = "Мама читает мне סִפּוּר перед сном.",
         fillInBlankExclusions = listOf(170408L, 170409L, 170411L)),
        WordEntity(
            id = 170411, setId = 1704, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "arts_writers",
            original = "סִפְרוּת", translation = "литература",
            transliteration = "sifrut",
            definition = "אֹסֶף יְצִירוֹת כְּתוּבוֹת שֶׁל עַם אוֹ תְּקוּפָה.",
            definitionNative = "Совокупность письменных произведений народа или эпохи.",
            example = "אֲנַחְנוּ לוֹמְדִים סִפְרוּת רוּסִית בְּכִתָּה י.",
            exampleNative = "Мы изучаем русскую סִפְרוּת в десятом классе.",
         fillInBlankExclusions = listOf(170408L, 170409L, 170410L, 170418L)),

        // ── arts_singers (3) ─────────────────────────────────────────────────
        WordEntity(
            id = 170412, setId = 1704, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "arts_singers",
            original = "זַמָּר", translation = "певец",
            transliteration = "zamar",
            definition = "אָמָּן שֶׁמּוֹפִיעַ בְּקוֹלוֹ עַל הַבָּמָה לִפְנֵי קָהָל.",
            definitionNative = "Артист, выступающий голосом на сцене перед публикой.",
            example = "הַזַּמָּר הוֹפִיעַ עִם לַהֲקָה גְּדוֹלָה בָּעִיר.",
            exampleNative = "זַמָּר выступал в городе с большой группой.",
        ),
        WordEntity(
            id = 170413, setId = 1704, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "arts_singers",
            original = "זַמֶּרֶת", translation = "певица",
            transliteration = "zameret",
            definition = "אָמָּנִית שֶׁמּוֹפִיעָה בְּקוֹלָהּ עַל הַבָּמָה לִפְנֵי קָהָל.",
            definitionNative = "Женщина-артистка, выступающая голосом на сцене перед публикой.",
            example = "הַזַּמֶּרֶת הוֹצִיאָה אַלְבּוֹם חָדָשׁ בַּשָּׁבוּעַ שֶׁעָבַר.",
            exampleNative = "זַמֶּרֶת на прошлой неделе выпустила новый альбом.",
        ),
        WordEntity(
            id = 170414, setId = 1704, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "arts_singers",
            original = "מָקְהֵלָה", translation = "хор",
            transliteration = "makhela",
            definition = "קְבוּצַת אֲנָשִׁים שֶׁשָּׁרִים יַחַד בְּקוֹלוֹת שׁוֹנִים.",
            definitionNative = "Группа людей, поющих вместе разными голосами.",
            example = "הַמָּקְהֵלָה הוֹפִיעָה בִּכְנֵסִיָּה בָּעֶרֶב חַג הַמּוֹלָד.",
            exampleNative = "מָקְהֵלָה пела в церкви в рождественский вечер.",
        ),

        // ── arts_dancers (3) ─────────────────────────────────────────────────
        WordEntity(
            id = 170415, setId = 1704, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "arts_dancers",
            original = "רִיקּוּד", translation = "танец",
            transliteration = "rikud",
            definition = "תְּנוּעָה שֶׁל הַגּוּף לְפִי קֶצֶב מוּסִיקָלִי לְשֵׁם הֲנָאָה.",
            definitionNative = "Движения тела под музыкальный ритм для удовольствия.",
            example = "הַיְּלָדִים לָמְדוּ רִיקּוּד חָדָשׁ בַּמְּסִבָּה.",
            exampleNative = "Дети разучивали новый רִיקּוּד на празднике.",
         fillInBlankExclusions = listOf(170416L, 170417L)),
        WordEntity(
            id = 170416, setId = 1704, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "arts_dancers",
            original = "רַקְדָן", translation = "танцор",
            transliteration = "rakdan",
            definition = "אָמָּן שֶׁמּוֹפִיעַ עַל הַבָּמָה בִּתְנוּעוֹת לְפִי מוּסִיקָה.",
            definitionNative = "Артист, выступающий на сцене движениями под музыку.",
            example = "הָרַקְדָן הוֹפִיעַ עִם לַהֲקַת בָּלֶט מַפֻּרְסֶמֶת.",
            exampleNative = "רַקְדָן выступал с известной балетной труппой.",
         fillInBlankExclusions = listOf(170415L, 170417L)),
        WordEntity(
            id = 170417, setId = 1704, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "arts_dancers",
            original = "רַקְדָנִית", translation = "танцовщица",
            transliteration = "rakdanit",
            definition = "אָמָּנִית שֶׁמּוֹפִיעָה עַל הַבָּמָה בִּתְנוּעוֹת לְפִי מוּסִיקָה.",
            definitionNative = "Артистка, выступающая на сцене движениями под музыку.",
            example = "הָרַקְדָנִית הִתְאַמְּנָה כָּל בֹּקֶר שָׁעָה אֲרֻכָּה.",
            exampleNative = "רַקְדָנִית каждое утро тренировалась подолгу.",
         fillInBlankExclusions = listOf(170415L, 170416L)),

        // ── arts_music (5) ───────────────────────────────────────────────────
        WordEntity(
            id = 170418, setId = 1704, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "arts_music",
            original = "מוּסִיקָה", translation = "музыка",
            transliteration = "musika",
            definition = "אָמָּנוּת שֶׁל צְלִילִים עָרוּכִים לְפִי קֶצֶב וְהַרְמוֹנְיָה.",
            definitionNative = "Искусство звуков, выстроенных по ритму и созвучию.",
            example = "הוּא שׁוֹמֵעַ מוּסִיקָה שְׁקֵטָה בַּדֶּרֶךְ לָעֲבוֹדָה.",
            exampleNative = "Он слушает тихую מוּסִיקָה по дороге на работу.",
         fillInBlankExclusions = listOf(170402L, 170411L, 170414L, 170419L, 170420L, 170421L, 170422L)),
        WordEntity(
            id = 170419, setId = 1704, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "arts_music",
            original = "שִׁיר עֶרֶשׂ", translation = "колыбельная",
            transliteration = "shir eres",
            definition = "מַנְגִּינָה רַכָּה שֶׁאֵם שָׁרָה לַתִּינוֹק לִפְנֵי הַשֵּׁנָה.",
            definitionNative = "Тихая мелодия, что мама поёт малышу перед сном.",
            example = "אִמָּא שָׁרָה לַתִּינוֹק שִׁיר עֶרֶשׂ עַד שֶׁנִּרְדַּם.",
            exampleNative = "Мама пела малышу שִׁיר עֶרֶשׂ, пока он не заснул.",
        ),
        WordEntity(
            id = 170420, setId = 1704, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "arts_music",
            original = "דִּיסְקוֹ", translation = "диско",
            transliteration = "disko",
            definition = "סִגְנוֹן רִקּוּדִים קַל וְקִצְבִּי שֶׁל שְׁנוֹת הַשִּׁבְעִים.",
            definitionNative = "Лёгкий ритмичный танцевальный стиль семидесятых годов.",
            example = "בַּמְּסִבָּה הִשְׁמִיעוּ דִּיסְקוֹ יָשָׁן וְכֻלָּם רָקְדוּ.",
            exampleNative = "На вечеринке поставили старое דִּיסְקוֹ и все танцевали.",
        ),
        WordEntity(
            id = 170421, setId = 1704, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "arts_music",
            original = "רָדְיוֹ", translation = "радио",
            transliteration = "radyo",
            definition = "מַכְשִׁיר שֶׁמְּשַׁדֵּר קוֹל וּמַנְגִּינוֹת לְהַאֲזָנָה בַּבַּיִת אוֹ בָּרְכֶב.",
            definitionNative = "Прибор, передающий голос и мелодии для прослушивания дома или в машине.",
            example = "אַבָּא הִדְלִיק אֶת הָרָדְיוֹ כְּדֵי לִשְׁמוֹעַ חֲדָשׁוֹת בַּבֹּקֶר.",
            exampleNative = "Папа включил רָדְיוֹ, чтобы послушать утренние новости.",
        ),
        WordEntity(
            id = 170422, setId = 1704, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "arts_music",
            original = "הַקְלָטָה", translation = "запись",
            transliteration = "haklata",
            definition = "שִׁמּוּר קוֹל אוֹ מַנְגִּינָה עַל מַכְשִׁיר לִשְׁמִיעָה לְאַחַר מִכֵּן.",
            definitionNative = "Сохранение голоса или мелодии на устройстве для прослушивания позже.",
            example = "הַזַּמָּר עָבַד עַל הַהַקְלָטָה הָאַחֲרוֹנָה כָּל הַלַּיְלָה.",
            exampleNative = "Певец работал над последней הַקְלָטָה всю ночь.",
         fillInBlankExclusions = listOf(170418L, 170419L, 170420L, 170421L)),

        // ── arts_show (3) ────────────────────────────────────────────────────
        WordEntity(
            id = 170423, setId = 1704, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "arts_show",
            original = "קוֹלְנוֹעַ", translation = "кино",
            transliteration = "kolnoa",
            definition = "אָמָּנוּת הַסְּרָטִים שֶׁמַּצִּיגָה תְּמוּנוֹת נָעוֹת עַל הַמָּסָךְ.",
            definitionNative = "Искусство фильмов, показывающее движущиеся картины на экране.",
            example = "הַקּוֹלְנוֹעַ הָאִיטַלְקִי מַפֻּרְסָם בְּעוֹלָם כֻּלּוֹ.",
            exampleNative = "Итальянский קוֹלְנוֹעַ известен во всём мире.",
        ),
        WordEntity(
            id = 170424, setId = 1704, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "arts_show",
            original = "מוֹפָע", translation = "шоу",
            transliteration = "mofa",
            definition = "אֵרוּעַ בִּדּוּרִי עַל בָּמָה עִם שִׁירָה, רִקּוּד אוֹ הַצָּגָה.",
            definitionNative = "Развлекательное событие на сцене с пением, танцами или игрой.",
            example = "הַמּוֹפָע נִמְשַׁךְ שְׁתֵּי שָׁעוֹת וְהַקָּהָל מָחָא כַּפַּיִם.",
            exampleNative = "מוֹפָע длилось два часа, и зрители аплодировали.",
        ),
        WordEntity(
            id = 170425, setId = 1704, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "arts_show",
            original = "נֵיאוֹן", translation = "неон",
            transliteration = "neon",
            definition = "אוֹר צִבְעוֹנִי בְּמוֹדָעוֹת רְחוֹב שֶׁל קוֹלְנוֹעַ אוֹ מוֹעָדוֹן.",
            definitionNative = "Цветной свет на уличных вывесках кинотеатра или клуба.",
            example = "הַנֵּיאוֹן עַל הַמּוֹעָדוֹן זוֹהֵר בְּצֶבַע אָדוֹם וְכָחוֹל.",
            exampleNative = "נֵיאוֹן над клубом светится красным и синим.",
        ),
    )
}
