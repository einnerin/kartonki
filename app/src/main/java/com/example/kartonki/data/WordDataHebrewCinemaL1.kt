package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary: Кино и сериалы, level 1 (1 set, 25 words).
 * Базовая лексика про кино и телесериалы для уровня A1-A2/B1: форматы (фильм,
 * сериал, эпизод), люди (актёр, режиссёр, зритель), персонажи (герой, роль),
 * производство (съёмка, монтаж), составные части (сюжет, диалог, саундтрек) и
 * мероприятия (премьера, фестиваль, кинотеатр).
 *
 * Set 1857 — основы темы «Кино и сериалы» на иврите.
 * Распределение редкостей: 12 COMMON + 13 UNCOMMON.
 *
 * Шесть подгрупп по 3-5 слов:
 *   cinema_formats     — типы контента (סֶרֶט, סִדְרָה, פֶּרֶק, הַצָּגָה)
 *   cinema_people      — кино-индустрия (שַׂחְקָן, בַּמַּאי, כּוֹכָב, צוֹפֶה)
 *   cinema_characters  — персонажи (גִּבּוֹר, אוֹיֵב, תַּפְקִיד)
 *   cinema_production  — процесс (צִילּוּם, עֲרִיכָה, הַפָּקָה, סְצֵנָה)
 *   cinema_content     — составные части (עֲלִילָה, דִּיאַלוֹג, מוּזִיקַת רֶקַע, ...)
 *   cinema_event       — показ и рецензии (בֵּית קוֹלְנוֹעַ, פֶסְטִיבָל, ...)
 *
 * NOTE: текстовые поля (definition/example/pos/semanticGroup) заполняются
 * через text-author + metadata-filler subagents, поэтому здесь — skeleton.
 * После заполнения сет станет полностью release-ready.
 */
object WordDataHebrewCinemaL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1857,
            languagePair = "he-ru",
            orderIndex = 1857,
            name = "Кино и сериалы",
            description = "Основы: фильм, сериал, актёр, режиссёр, премьера, кинотеатр",
            topic = "Кино и сериалы",
            level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 1857 — Кино и сериалы: основы (L1, COMMON+UNCOMMON)          ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── cinema_formats (4) ────────────────────────────────────────────
        WordEntity(id = 185701, setId = 1857, languagePair = "he-ru", rarity = "COMMON",
            original = "סֶרֶט", transliteration = "seret", translation = "фильм",
            definition = "יְצִירָה אַרֻכָּה שֶׁמַּקְרִינִים בְּקוֹלְנוֹעַ אוֹ צוֹפִים בָּהּ בַּטֵּלֵוִיזְיָה.",
            definitionNative = "Длинная история на экране — её смотрят в зале или дома.",
            example = "אֶתְמוֹל רָאִינוּ סֶרֶט מַצְחִיק שֶׁל אֲדַם סַנְדְּלֶר.",
            exampleNative = "Вчера мы посмотрели смешной סֶרֶט с Адамом Сэндлером.",
            pos = "noun", semanticGroup = "cinema_formats"),
        WordEntity(id = 185702, setId = 1857, languagePair = "he-ru", rarity = "COMMON",
            original = "סִדְרָה", transliteration = "sidra", translation = "сериал",
            definition = "סִפּוּר שֶׁמְּחֻלָּק לְהַרְבֵּה פְּרָקִים, וְכָל פֶּרֶק יוֹצֵא בְּשָׁבוּעַ אַחֵר.",
            definitionNative = "История из множества эпизодов, выходящих один за другим неделя за неделей.",
            example = "אֲנִי מַכְמָנָה אֶת הַסִּדְרָה הַחֲדָשָׁה שֶׁל נֶטְפְלִיקְס.",
            exampleNative = "Я залипаю на новой סִדְרָה от Netflix.",
            pos = "noun", semanticGroup = "cinema_formats"),
        WordEntity(id = 185703, setId = 1857, languagePair = "he-ru", rarity = "COMMON",
            original = "פֶּרֶק", transliteration = "perek", translation = "серия (эпизод)",
            definition = "חֵלֶק בּוֹדֵד מִתּוֹךְ סִדְרָה — בְּדֶרֶךְ כְּלָל בֵּין עֶשְׂרִים לְשִׁשִּׁים דַּקּוֹת.",
            definitionNative = "Одна отдельная часть из длинного телешоу — обычно от двадцати минут до часа.",
            example = "הַפֶּרֶק הָאַחֲרוֹן שֶׁל הָעוֹנָה הָיָה מְרַגֵּשׁ בְּטֵרוּף.",
            exampleNative = "Финальный פֶּרֶק этого сезона был жутко трогательным.",
            pos = "noun", semanticGroup = "cinema_formats"),
        WordEntity(id = 185704, setId = 1857, languagePair = "he-ru", rarity = "COMMON",
            original = "הַצָּגָה", transliteration = "hatsaga", translation = "показ / спектакль",
            definition = "אֵרוּעַ שֶׁבּוֹ מַרְאִים סֶרֶט בְּקוֹלְנוֹעַ אוֹ מְשַׂחֲקִים מַחֲזֶה עַל בָּמָה.",
            definitionNative = "Когда фильм идёт на экране или актёры играют что-то на сцене.",
            example = "קָנִינוּ כַּרְטִיסִים לַהַצָּגָה שֶׁל שְׁמוֹנֶה בָּעֶרֶב.",
            exampleNative = "Мы взяли билеты на הַצָּגָה в восемь вечера.",
            pos = "noun", semanticGroup = "cinema_formats"),

        // ── cinema_people (4) ─────────────────────────────────────────────
        WordEntity(id = 185705, setId = 1857, languagePair = "he-ru", rarity = "COMMON",
            original = "שַׂחְקָן", transliteration = "sakhkan", translation = "актёр",
            definition = "אִישׁ שֶׁמְּגַלֵּם דְּמֻיּוֹת בְּסֶרֶט אוֹ עַל בָּמָה — לִפְעָמִים בּוֹכֶה אוֹ צוֹחֵק לְפִי תַּסְרִיט.",
            definitionNative = "Человек, который играет персонажей в кино или на сцене по сценарию.",
            example = "הַשַּׂחְקָן הֲכִי טוֹב בָּעוֹלָם הוּא לְדַעְתִּי דַּנִיאֵל דֵּיי-לוּאִיס.",
            exampleNative = "Лучший שַׂחְקָן в мире, по-моему, — Дэниел Дэй-Льюис.",
            pos = "noun", semanticGroup = "cinema_people"),
        WordEntity(id = 185706, setId = 1857, languagePair = "he-ru", rarity = "COMMON",
            original = "בַּמַּאי", transliteration = "bamai", translation = "режиссёр",
            definition = "הָאִישׁ הָרָאשִׁי בִּיצִירַת סֶרֶט — מַחְלִיט אֵיךְ כָּל סְצֵנָה תֵּרָאֶה.",
            definitionNative = "Главный человек на съёмках — решает, как должна выглядеть каждая сцена.",
            example = "הַבַּמַּאי דִּבֵּר עִם הַשַּׂחְקָנִים לִפְנֵי הַצִּלּוּם הָרִאשׁוֹן.",
            exampleNative = "Перед первой съёмкой בַּמַּאי поговорил с актёрами.",
            pos = "noun", semanticGroup = "cinema_people"),
        WordEntity(id = 185707, setId = 1857, languagePair = "he-ru", rarity = "COMMON",
            original = "כּוֹכָב", transliteration = "kokhav", translation = "звезда (известный актёр)",
            definition = "שַׂחְקָן אוֹ זַמָּר מְפֻרְסָם מְאוֹד שֶׁכֻּלָּם מַכִּירִים.",
            definitionNative = "Очень известный артист — его узнают на улице везде.",
            example = "גַּל גָּדוֹת הִיא הַכּוֹכָב הֲכִי גָּדוֹל שֶׁל הוֹלִיווּד הַיּוֹם.",
            exampleNative = "Галь Гадот — самый большой כּוֹכָב Голливуда сегодня.",
            pos = "noun", semanticGroup = "cinema_people"),
        WordEntity(id = 185708, setId = 1857, languagePair = "he-ru", rarity = "COMMON",
            original = "צוֹפֶה", transliteration = "tsofe", translation = "зритель",
            definition = "מִישֶׁהוּ שֶׁיּוֹשֵׁב מוּל הַמָּסָךְ אוֹ הַבָּמָה וּמִסְתַּכֵּל עַל מַה שֶׁקּוֹרֶה.",
            definitionNative = "Тот, кто сидит в зале или дома и смотрит на экран.",
            example = "כָּל צוֹפֶה קִבֵּל פּוֹפְּקוֹרְן חִנָּם בִּכְנִיסָה לָאוּלָם.",
            exampleNative = "Каждый צוֹפֶה получил бесплатный попкорн на входе в зал.",
            pos = "noun", semanticGroup = "cinema_people"),

        // ── cinema_characters (3) ─────────────────────────────────────────
        WordEntity(id = 185709, setId = 1857, languagePair = "he-ru", rarity = "COMMON",
            original = "גִּבּוֹר", transliteration = "gibor", translation = "герой (главный персонаж)",
            definition = "הָאִישׁ הָרָאשִׁי בַּסִּפּוּר — בְּדֶרֶךְ כְּלָל אַמִּיץ וְעוֹשֶׂה דְּבָרִים גְּדוֹלִים.",
            definitionNative = "Главное лицо в истории — обычно смелый и совершает важные поступки.",
            example = "הַגִּבּוֹר שֶׁל הַסֶּרֶט הִצִּיל אֶת הָעִיר בָּרֶגַע הָאַחֲרוֹן.",
            exampleNative = "גִּבּוֹר фильма спас город в самую последнюю секунду.",
            pos = "noun", semanticGroup = "cinema_characters"),
        WordEntity(id = 185710, setId = 1857, languagePair = "he-ru", rarity = "COMMON",
            original = "אוֹיֵב", transliteration = "oyev", translation = "враг (антагонист в сюжете)",
            definition = "הַצַּד הָרַע בַּסִּפּוּר — מִי שֶׁמַּפְרִיעַ לַגִּבּוֹר וּמְנַסֶּה לַעֲצוֹר אוֹתוֹ.",
            definitionNative = "Тёмная сторона в истории — мешает герою и пытается его остановить.",
            example = "הָאוֹיֵב שֶׁל הַסֶּרֶט הִסְתַּתֵּר עַד הָרֶגַע הָאַחֲרוֹן.",
            exampleNative = "אוֹיֵב фильма прятался до самой последней секунды.",
            pos = "noun", semanticGroup = "cinema_characters"),
        WordEntity(id = 185711, setId = 1857, languagePair = "he-ru", rarity = "COMMON",
            original = "תַּפְקִיד", transliteration = "tafkid", translation = "роль (актёрская)",
            definition = "הַדְּמוּת שֶׁשַּׂחְקָן מְגַלֵּם בַּסֶּרֶט — הַטֶּקְסְט וְהַמַּעֲשִׂים שֶׁלָּהּ.",
            definitionNative = "То, что играет актёр на экране — кого изображает и что делает.",
            example = "הִיא קִבְּלָה אֶת הַתַּפְקִיד הָרָאשִׁי אַחֲרֵי שְׁלוֹשָׁה אוֹדִישְׁנִים.",
            exampleNative = "Она получила главный תַּפְקִיד после трёх кастингов.",
            pos = "noun", semanticGroup = "cinema_characters"),

        // ── cinema_production (4) ─────────────────────────────────────────
        WordEntity(id = 185712, setId = 1857, languagePair = "he-ru", rarity = "COMMON",
            original = "צִילּוּם", transliteration = "tsilum", translation = "съёмка",
            definition = "תַּהֲלִיךְ שֶׁבּוֹ מַצְלֵמָה קוֹלֶטֶת אֶת מַה שֶׁקּוֹרֶה לְפָנֶיהָ — לְסֶרֶט אוֹ לִתְמוּנָה.",
            definitionNative = "Когда камера записывает то, что происходит перед ней — для фильма или фото.",
            example = "הַצִּילּוּם שֶׁל הַסֶּרֶט נִמְשַׁךְ שִׁשָּׁה חֳדָשִׁים בְּתֵל אָבִיב.",
            exampleNative = "צִילּוּם фильма продолжался полгода в Тель-Авиве.",
            pos = "noun", semanticGroup = "cinema_production"),
        WordEntity(id = 185713, setId = 1857, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עֲרִיכָה", transliteration = "arikha", translation = "монтаж (фильма)",
            definition = "הַשָּׁלָב שֶׁבּוֹ חוֹתְכִים וּמְחַבְּרִים אֶת הַסְּצֵנוֹת אַחֲרֵי הַצִּילּוּמִים.",
            definitionNative = "Этап после съёмок: куски склеивают вместе и вырезают всё лишнее.",
            example = "הָעֲרִיכָה שֶׁל הַסֶּרֶט אָרְכָה כִּמְעַט שָׁנָה שְׁלֵמָה.",
            exampleNative = "עֲרִיכָה этого фильма заняла почти целый год.",
            pos = "noun", semanticGroup = "cinema_production"),
        WordEntity(id = 185714, setId = 1857, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַפָּקָה", transliteration = "hafaka", translation = "продюсирование",
            definition = "הָאַחְרָיוּת עַל יְצִירַת סֶרֶט — מִי מְמַמֵּן, מִי מְאַרְגֵּן וּמִי דּוֹאֵג שֶׁהַכֹּל יִקְרֶה.",
            definitionNative = "Когда кто-то ищет деньги, людей и площадки, чтобы фильм вообще появился.",
            example = "הַהַפָּקָה שֶׁל הַסֶּרֶט הַזֶּה עָלְתָה מֵאָה מִילְיוֹן דוֹלָר.",
            exampleNative = "הַפָּקָה этой картины обошлась в сто миллионов долларов.",
            pos = "noun", semanticGroup = "cinema_production"),
        WordEntity(id = 185715, setId = 1857, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סְצֵנָה", transliteration = "stsena", translation = "сцена (кинокадр)",
            definition = "קֶטַע קָצָר בַּסֶּרֶט שֶׁמִּתְרַחֵשׁ בְּמָקוֹם אֶחָד וּבְזְמַן אֶחָד.",
            definitionNative = "Короткий кусок фильма, который происходит в одном месте и времени.",
            example = "הַסְּצֵנָה שֶׁל הַנְּשִׁיקָה בַּגֶּשֶׁם הִיא הַמְּפֻרְסֶמֶת בְּיוֹתֵר.",
            exampleNative = "סְצֵנָה поцелуя под дождём — самая известная в фильме.",
            pos = "noun", semanticGroup = "cinema_production"),

        // ── cinema_content (5) ────────────────────────────────────────────
        WordEntity(id = 185716, setId = 1857, languagePair = "he-ru", rarity = "COMMON",
            original = "עֲלִילָה", transliteration = "alila", translation = "сюжет",
            definition = "הַסִּפּוּר שֶׁל הַסֶּרֶט — מַה קוֹרֶה לַגִּבּוֹרִים וְאֵיךְ זֶה נִגְמָר בַּסּוֹף.",
            definitionNative = "Главная история фильма — что и в каком порядке происходит с героями.",
            example = "הָעֲלִילָה שֶׁל הַסֶּרֶט מְבֻלְבֶּלֶת וְקָשָׁה לְהָבִין מִי נֶגֶד מִי.",
            exampleNative = "עֲלִילָה этого фильма запутанная — непонятно, кто против кого.",
            pos = "noun", semanticGroup = "cinema_content"),
        WordEntity(id = 185717, setId = 1857, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "דִּיאַלוֹג", transliteration = "dialog", translation = "диалог",
            definition = "שִׂיחָה בֵּין שְׁתֵּי דְּמֻיּוֹת בַּסֶּרֶט — אֶחָד מְדַבֵּר וְאַחַר עוֹנֶה.",
            definitionNative = "Когда два героя в фильме разговаривают по очереди — один сказал, другой ответил.",
            example = "הַדִּיאַלוֹג בֵּין הָאַבָּא וְהַבֵּן בַּסּוֹף הִבְכָּה אוֹתִי.",
            exampleNative = "דִּיאַלוֹג отца и сына в финале меня до слёз пробил.",
            pos = "noun", semanticGroup = "cinema_content"),
        WordEntity(id = 185718, setId = 1857, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מוּזִיקַת רֶקַע", transliteration = "muzikat reka", translation = "фоновая музыка (в кино)",
            definition = "הַמּוּזִיקָה הַשְּׁקֵטָה שֶׁמְּנַגְּנֶת מֵאָחוֹר בִּזְמַן שֶׁהַשַּׂחְקָנִים מְדַבְּרִים.",
            definitionNative = "Тихая музыка, что играет на фоне, пока актёры разговаривают.",
            example = "הַמּוּזִיקַת רֶקַע בַּסְּצֵנָה הַזֹּאת מַעֲצִימָה אֶת הָרֶגֶשׁ.",
            exampleNative = "מוּזִיקַת רֶקַע в этой сцене усиливает эмоцию.",
            pos = "phrase", semanticGroup = "cinema_content"),
        WordEntity(id = 185719, setId = 1857, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "כְּתוּבִיּוֹת", transliteration = "ktuviyot", translation = "субтитры",
            definition = "מִלִּים שֶׁמּוֹפִיעוֹת לְמַטָּה בַּמָּסָךְ וּמְתַרְגְּמוֹת אֶת מַה שֶׁאוֹמְרִים.",
            definitionNative = "Текст внизу экрана, который переводит то, что говорят на чужом языке.",
            example = "אֲנִי תָּמִיד צוֹפָה בִּסְרָטִים אֲנְגְלִיִּים עִם כְּתוּבִיּוֹת בְּעִבְרִית.",
            exampleNative = "Я всегда смотрю английские фильмы с כְּתוּבִיּוֹת на иврите.",
            pos = "noun", semanticGroup = "cinema_content"),
        WordEntity(id = 185720, setId = 1857, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "דּוּבּוּב", transliteration = "dubuv", translation = "дубляж",
            definition = "כְּשֶׁמַּחֲלִיפִים אֶת קוֹלוֹת הַשַּׂחְקָנִים בִּשְׂפָה אַחֶרֶת בִּמְקוֹם הַמְּקוֹרִית.",
            definitionNative = "Когда оригинальные голоса актёров заменяют озвучкой на другом языке.",
            example = "סִרְטֵי דִּיסְנֵי מְקַבְּלִים תָּמִיד דּוּבּוּב מְצֻיָּן בְּעִבְרִית.",
            exampleNative = "У диснеевских мультфильмов всегда отличный דּוּבּוּב на иврите.",
            pos = "noun", semanticGroup = "cinema_content"),

        // ── cinema_event (5) ──────────────────────────────────────────────
        WordEntity(id = 185721, setId = 1857, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "בֵּית קוֹלְנוֹעַ", transliteration = "beit kolnoa", translation = "кинотеатр",
            definition = "מָקוֹם גָּדוֹל עִם מָסָךְ עֲנָק וְהַרְבֵּה כִּסְּאוֹת — בָּאִים לִרְאוֹת סְרָטִים.",
            definitionNative = "Большое здание с огромным экраном и рядами кресел — там идут фильмы.",
            example = "הַבֵּית קוֹלְנוֹעַ בְּדִיזֶנְגוֹף סֶנְטֶר נִסְגַּר לִפְנֵי שְׁנָתַיִם.",
            exampleNative = "בֵּית קוֹלְנוֹעַ в Дизенгоф-центре закрылся два года назад.",
            pos = "noun", semanticGroup = "cinema_event"),
        WordEntity(id = 185722, setId = 1857, languagePair = "he-ru", rarity = "COMMON",
            original = "כַּרְטִיס", transliteration = "kartis", translation = "билет (в кино)",
            definition = "פִּסַּת נְיָר אוֹ קוֹד דִּיגִיטָלִי שֶׁמַּכְנִיסִים אוֹתְךָ לָאוּלָם אַחֲרֵי שֶׁשִּׁלַּמְתָּ.",
            definitionNative = "Бумажка или код в телефоне, который пускает тебя в зал после оплаты.",
            example = "הַכַּרְטִיס לַסֶּרֶט הֶחָדָשׁ עָלָה חֲמִשִּׁים שֶׁקֶל בְּסוּפְשָׁבוּעַ.",
            exampleNative = "כַּרְטִיס на новый фильм стоил пятьдесят шекелей в выходные.",
            pos = "noun", semanticGroup = "cinema_event"),
        WordEntity(id = 185723, setId = 1857, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פֶסְטִיבָל", transliteration = "festival", translation = "кинофестиваль",
            definition = "אֵרוּעַ שֶׁל כַּמָּה יָמִים שֶׁבּוֹ מַקְרִינִים הַרְבֵּה סְרָטִים וּמְחַלְּקִים פְּרָסִים.",
            definitionNative = "Несколько дней подряд показывают много фильмов и вручают награды лучшим.",
            example = "הַפֶסְטִיבָל בְּחֵיפָה מַכְנִיס כָּל שָׁנָה אֶלֶף צוֹפִים מִכָּל הָעוֹלָם.",
            exampleNative = "פֶסְטִיבָל в Хайфе каждый год собирает тысячи зрителей со всего мира.",
            pos = "noun", semanticGroup = "cinema_event"),
        WordEntity(id = 185724, setId = 1857, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קְדִימוֹן", transliteration = "kdimon", translation = "трейлер (анонс фильма)",
            definition = "סֶרְטוֹן קָצָר שֶׁמַּרְאֶה רְגָעִים מִסֶּרֶט עָתִידִי כְּדֵי לִמְשׁוֹךְ צוֹפִים.",
            definitionNative = "Короткий ролик с фрагментами будущего фильма — чтобы заинтересовать зрителей.",
            example = "הַקְּדִימוֹן שֶׁל הַסֶּרֶט הֶחָדָשׁ הָיָה מַצְחִיק בְּטֵרוּף.",
            exampleNative = "קְדִימוֹן нового фильма получился жутко смешным.",
            pos = "noun", semanticGroup = "cinema_event"),
        WordEntity(id = 185725, setId = 1857, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "בִּקֹּרֶת", transliteration = "bikoret", translation = "рецензия / критика",
            definition = "טֶקְסְט שֶׁבּוֹ מִישֶׁהוּ כּוֹתֵב מָה הוּא חוֹשֵׁב עַל הַסֶּרֶט — מָה טוֹב וּמָה לֹא.",
            definitionNative = "Текст, в котором кто-то пишет, что у фильма получилось, а что нет.",
            example = "הַבִּקֹּרֶת בְּעִתּוֹן הָאָרֶץ שִׁבְּחָה אֶת הַמִּשְׂחָק שֶׁל הַשַּׂחְקָנִית.",
            exampleNative = "בִּקֹּרֶת в газете «Гаарец» расхвалила игру актрисы.",
            pos = "noun", semanticGroup = "cinema_event"),
    )
}
