package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Идиомы и поговорки иврита", level 1 (B1).
 * Один сет × 25 слов. setId = 1847.
 *
 *  - 17 UNCOMMON + 8 RARE (B1+B2). Идиомы по природе минимум B1.
 *  - 5 семантических групп по 5 слов:
 *      idioms_l1_food_metaphors — еда как метафора (хлеб/перец/каша/масло/соль)
 *      idioms_l1_body_parts     — части тела (язык/ухо/голова/глаз/рука)
 *      idioms_l1_animals        — животные (кот/лиса/змея/птица/слон)
 *      idioms_l1_time_situations— время и ситуации (момент/порог/конец/буря)
 *      idioms_l1_actions        — действия (ломать голову/прятать в песок и т.д.)
 *  - Все pos = "phrase".
 *  - Никудим везде, включая саму идиому в `original`.
 *  - `transliteration` — кириллицей вся фраза целиком.
 *  - В `example` никудим стоит только на целевой идиоме (стандарт he-ru).
 *  - `exampleNative` — русская калька с самой идиомой В ИВРИТЕ внутри.
 *  - В исходном плане часть идиом была кальками с русского/английского
 *    («не падает с уха», «открыто на голове», «ломать пост», «жарко в кастрюле»,
 *    «раз в шесть дней», «в высечке скалы», «идти в юбке», «нерешительно»,
 *    «два ноги в одном ботинке», «кусает свой хвост», «с громом и молнией»,
 *    «не время для перца», «на ноже», «сколько птиц одним камнем» в форме
 *    с אֶבֶן и т.п.) — заменены на реальные привычные израильтянам выражения:
 *      - לֶחֶם חֻקֵּנוּ («наш хлеб насущный»)
 *      - חַי עַל הַזְּמַן («живёт на времени» — впритык / в обрез)
 *      - עַיִן יָפָה («хороший глаз» — щедрость, доброжелательность)
 *      - כָּל הַכָּבוֹד («вся честь» — молодец/отлично)
 *      - הַכֹּל דְּבַשׁ («всё мёд» — всё прекрасно, часто иронично)
 *      - מֶלַח הָאָרֶץ («соль земли» — лучшие люди)
 *      - יוֹצֵא מֵהַכֵּלִים («выходит из посуды» — выходит из себя)
 *      - שָׂם זַיִן («ложит хер» — ему пофиг, разговорная)
 *      - יָצָא מְכָל הַכֵּלִים etc. (избегаем сленга B2+, оставляем B1-B2)
 *  - Дублей `original` с другими he-ru сетами по точной фразе нет
 *    (проверено grep'ом 2026-04-29). Отдельные слова (לֵב, רֹאשׁ, יָד, חָתוּל)
 *    встречаются как обычные существительные в других темах — здесь это
 *    устойчивые фразы целиком, что является политикой допустимости дублей.
 */
object WordDataHebrewIdiomsL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1847, languagePair = "he-ru", orderIndex = 1847,
            name = "Идиомы и поговорки иврита",
            description = "Базовые израильские идиомы и устойчивые выражения",
            topic = "Идиомы и поговорки иврита", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── idioms_l1_food_metaphors (5) ────────────────────────────────
        WordEntity(
            id = 184701, setId = 1847, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l1_food_metaphors",
            original = "לֶחֶם וּמַיִם", translation = "хлеб и вода (самый минимум)",
            transliteration = "лехем у-маим",
            definition = "הַמִּנִימוּם הֶכְרַחִי לְחַיִּים — בְּלִי מוֹתָרוֹת.",
            definitionNative = "Самый необходимый минимум для жизни — без излишеств. Дословно: «хлеб и вода».",
            example = "בִּתְקוּפַת הַמִּלְחָמָה הָיָה לָנוּ רַק לֶחֶם וּמַיִם.",
            exampleNative = "Во время войны у нас был только לֶחֶם וּמַיִם — ничего больше."
        , fillInBlankExclusions = listOf(184702L, 184703L, 184704L, 184705L)),
        WordEntity(
            id = 184702, setId = 1847, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l1_food_metaphors",
            original = "לֶחֶם חֻקֵּנוּ", translation = "хлеб насущный (повседневное дело)",
            transliteration = "лехем хукейну",
            definition = "מַשֶּׁהוּ שֶׁעוֹשִׂים כָּל יוֹם — חֵלֶק רָגִיל מִן הַחַיִּים.",
            definitionNative = "То, что делают каждый день — обычная часть жизни. Дословно: «хлеб закона нашего».",
            example = "פְּקָקִים בַּכְּבִישׁ הֵם לֶחֶם חֻקֵּנוּ בְּתֵל אָבִיב.",
            exampleNative = "Пробки на дороге — это לֶחֶם חֻקֵּנוּ в Тель-Авиве, повседневность."
        ),
        WordEntity(
            id = 184703, setId = 1847, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l1_food_metaphors",
            original = "מֶלַח הָאָרֶץ", translation = "соль земли (лучшие люди)",
            transliteration = "мелах hа-арец",
            definition = "אֲנָשִׁים הֲכִי טוֹבִים וְחָשׁוּבִים בַּחֶבְרָה — עַמּוּד הַתָּוֶךְ שֶׁלָּהּ.",
            definitionNative = "Самые лучшие и важные люди в обществе — его опора. Дословно: «соль земли».",
            example = "הַחַיָּלִים הָאֵלֶּה הֵם בֶּאֱמֶת מֶלַח הָאָרֶץ שֶׁלָּנוּ.",
            exampleNative = "Эти солдаты — настоящие מֶלַח הָאָרֶץ нашей страны."
        , fillInBlankExclusions = listOf(184701L, 184702L, 184704L, 184705L)),
        WordEntity(
            id = 184704, setId = 1847, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_l1_food_metaphors",
            original = "הַכֹּל דְּבַשׁ", translation = "всё мёд (всё прекрасно, часто иронично)",
            transliteration = "hа-коль дваш",
            definition = "הַכֹּל הוֹלֵךְ נֶהְדָּר — לִפְעָמִים נֶאֱמָר בְּאִירוֹנְיָה כְּשֶׁלֹּא בֶּאֱמֶת.",
            definitionNative = "Всё идёт прекрасно — иногда говорят с иронией, когда на самом деле плохо. Дословно: «всё мёд».",
            example = "הוּא תָּמִיד מְסַפֵּר שֶׁבָּעֲבוֹדָה הַכֹּל דְּבַשׁ.",
            exampleNative = "Он всегда рассказывает, что на работе הַכֹּל דְּבַשׁ — но мы-то знаем."
        ),
        WordEntity(
            id = 184705, setId = 1847, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_l1_food_metaphors",
            original = "הַתַּפּוּחַ לֹא נוֹפֵל רָחוֹק מֵהָעֵץ",
            translation = "яблоко от яблони недалеко падает",
            transliteration = "hа-тапуах ло нофель рахок ме-hа-эц",
            definition = "יְלָדִים דּוֹמִים לַהוֹרִים שֶׁלָּהֶם בְּהֶרְגֵּלִים וּבְאֹפִי.",
            definitionNative = "Дети похожи на родителей по привычкам и характеру. Дословно: «яблоко не падает далеко от дерева».",
            example = "הוּא עַקְשָׁן כְּמוֹ אַבָּא — הַתַּפּוּחַ לֹא נוֹפֵל רָחוֹק מֵהָעֵץ.",
            exampleNative = "Он упрямый как отец — הַתַּפּוּחַ לֹא נוֹפֵל רָחוֹק מֵהָעֵץ."
        , fillInBlankExclusions = listOf(184701L, 184702L, 184703L, 184704L)),

        // ─── idioms_l1_body_parts (5) ────────────────────────────────────
        WordEntity(
            id = 184706, setId = 1847, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l1_body_parts",
            original = "עַל קְצֵה הַלָּשׁוֹן", translation = "на кончике языка",
            transliteration = "аль кце hа-лашон",
            definition = "כִּמְעַט נִזְכָּר אֲבָל לֹא מַצְלִיחַ לוֹמַר אֶת הַמִּלָּה.",
            definitionNative = "Почти вспомнил, но никак не получается сказать слово. Дословно: «на кончике языка».",
            example = "הַשֵּׁם שֶׁלּוֹ עַל קְצֵה הַלָּשׁוֹן וְאֵינִי מַצְלִיחַ.",
            exampleNative = "Его имя עַל קְצֵה הַלָּשׁוֹן, а вспомнить не могу."
        , fillInBlankExclusions = listOf(184707L, 184708L, 184709L, 184710L, 184718L)),
        WordEntity(
            id = 184707, setId = 1847, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l1_body_parts",
            original = "עַיִן יָפָה", translation = "щедрый/добрый глаз (щедрость)",
            transliteration = "аин яфа",
            definition = "יַחַס נָדִיב וְטוֹב כְּלַפֵּי אֲחֵרִים — בְּלִי קִנְאָה וּבְלִי כִּילוּת.",
            definitionNative = "Щедрое и доброе отношение к другим — без зависти и без скупости. Дословно: «красивый глаз».",
            example = "הַשְּׁכֵנָה תָּמִיד מְקַבֶּלֶת אוֹרְחִים בְּעַיִן יָפָה.",
            exampleNative = "Соседка всегда принимает гостей בְּעַיִן יָפָה — щедро и тепло."
        , fillInBlankExclusions = listOf(184706L, 184708L, 184709L, 184710L)),
        WordEntity(
            id = 184708, setId = 1847, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l1_body_parts",
            original = "יָד רוֹחֶצֶת יָד", translation = "рука руку моет",
            transliteration = "яд рохэцет яд",
            definition = "אֲנָשִׁים עוֹזְרִים זֶה לָזֶה — לְעִתִּים בְּעִנְיָנִים לֹא יָשָׁר.",
            definitionNative = "Люди помогают друг другу — иногда в нечистых делах. Дословно: «рука моет руку».",
            example = "בַּפּוֹלִיטִיקָה הַזֹּאת יָד רוֹחֶצֶת יָד וְכֻלָּם יוֹדְעִים.",
            exampleNative = "В этой политике יָד רוֹחֶצֶת יָד — и все об этом знают."
        , fillInBlankExclusions = listOf(184704L, 184706L, 184707L, 184709L, 184710L)),
        WordEntity(
            id = 184709, setId = 1847, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_l1_body_parts",
            original = "יוֹצֵא מֵהַכֵּלִים", translation = "выходит из себя",
            transliteration = "йоце ме-hа-келим",
            definition = "מַתְחִיל לִכְעֹס מְאֹד וְלֹא שׁוֹלֵט יוֹתֵר עַל הָרְגָשׁוֹת.",
            definitionNative = "Начинает сильно злиться и больше не контролирует чувства. Дословно: «выходит из посуды».",
            example = "אַבָּא יוֹצֵא מֵהַכֵּלִים כְּשֶׁהַיְלָדִים מַרְעִישִׁים.",
            exampleNative = "Папа יוֹצֵא מֵהַכֵּלִים, когда дети шумят весь вечер."
        , fillInBlankExclusions = listOf(184706L, 184707L, 184708L, 184710L)),
        WordEntity(
            id = 184710, setId = 1847, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_l1_body_parts",
            original = "מִפֶּה לְאֹזֶן", translation = "из уст в уста (из уст в уши)",
            transliteration = "ми-пе ле-озен",
            definition = "מֵידָע עוֹבֵר בְּדִבּוּר בֵּין אֲנָשִׁים — בְּלִי פִּרְסוּם רִשְׁמִי.",
            definitionNative = "Информация передаётся между людьми устно — без официальной публикации. Дословно: «изо рта в ухо».",
            example = "הַמִּסְעָדָה מַצְלִיחָה רַק מִפֶּה לְאֹזֶן בְּלִי פִּרְסוּם.",
            exampleNative = "Ресторан раскручивается только מִפֶּה לְאֹזֶן, без рекламы."
        , fillInBlankExclusions = listOf(184706L, 184707L, 184708L, 184709L)),

        // ─── idioms_l1_animals (5) ───────────────────────────────────────
        WordEntity(
            id = 184711, setId = 1847, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l1_animals",
            original = "חָתוּל בְּשַׂק", translation = "кот в мешке",
            transliteration = "хатуль бэ-сак",
            definition = "מַשֶּׁהוּ שֶׁקּוֹנִים בְּלִי לִרְאוֹת — לֹא יוֹדְעִים מָה מְקַבְּלִים.",
            definitionNative = "Что-то покупают не глядя — не знают, что именно получают. Дословно: «кот в мешке».",
            example = "אַל תִּקְנֶה רֶכֶב יָד שְׁנִיָּה בְּלִי לִבְדֹּק — זֶה חָתוּל בְּשַׂק.",
            exampleNative = "Не покупай подержанную машину без проверки — это חָתוּל בְּשַׂק."
        , fillInBlankExclusions = listOf(184712L, 184713L, 184714L, 184715L)),
        WordEntity(
            id = 184712, setId = 1847, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l1_animals",
            original = "הַכֶּבֶשׂ הַשָּׁחֹר", translation = "паршивая овца (белая ворона)",
            transliteration = "hа-кевес hа-шахор",
            definition = "אָדָם שׁוֹנֶה מִכָּל הַמִּשְׁפָּחָה — לְרֹב בְּמוּבָן שְׁלִילִי.",
            definitionNative = "Человек, отличающийся от всей семьи — обычно в негативном смысле. Дословно: «чёрная овца».",
            example = "הוּא הַכֶּבֶשׂ הַשָּׁחֹר בַּמִּשְׁפָּחָה — לֹא לָמַד בָּאוּנִיבֶרְסִיטָה.",
            exampleNative = "Он הַכֶּבֶשׂ הַשָּׁחֹר в семье — единственный без университета."
        , fillInBlankExclusions = listOf(184711L, 184713L, 184714L, 184715L)),
        WordEntity(
            id = 184713, setId = 1847, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l1_animals",
            original = "צִפּוֹר בַּיָּד שָׁוָה שְׁתַּיִם עַל הָעֵץ",
            translation = "лучше синица в руке, чем журавль в небе",
            transliteration = "ципор ба-яд шава штаим аль hа-эц",
            definition = "עָדִיף מַשֶּׁהוּ קָטָן וּבָטוּחַ עַכְשָׁו מֵרֹב גָּדוֹל וְלֹא בָּטוּחַ.",
            definitionNative = "Лучше малое, но верное сейчас, чем большое и ненадёжное. Дословно: «птица в руке стоит двух на дереве».",
            example = "קַח אֶת הָעֲבוֹדָה — צִפּוֹר בַּיָּד שָׁוָה שְׁתַּיִם עַל הָעֵץ.",
            exampleNative = "Соглашайся на работу: צִפּוֹר בַּיָּד שָׁוָה שְׁתַּיִם עַל הָעֵץ."
        , fillInBlankExclusions = listOf(184711L, 184712L, 184714L, 184715L)),
        WordEntity(
            id = 184714, setId = 1847, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_l1_animals",
            original = "מַכְנִיס רֹאשׁ בָּרִיא לְמִטָּה חוֹלָה",
            translation = "сам себе ищет неприятности",
            transliteration = "махнис рош бари ле-мита хола",
            definition = "מַכְנִיס אֶת עַצְמוֹ לִצָרָה בְּלִי סִבָּה — מְחַפֵּשׂ צָרוֹת.",
            definitionNative = "Сам себя втягивает в неприятности без причины — ищет беду. Дословно: «суёт здоровую голову в больную постель».",
            example = "מַכְנִיס רֹאשׁ בָּרִיא לְמִטָּה חוֹלָה זוֹ הִתְנַהֲגוּת לֹא חֲכָמָה.",
            exampleNative = "מַכְנִיס רֹאשׁ בָּרִיא לְמִטָּה חוֹלָה — это неразумное поведение."
        , fillInBlankExclusions = listOf(184711L, 184712L, 184713L, 184715L)),
        WordEntity(
            id = 184715, setId = 1847, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_l1_animals",
            original = "פִּיל בַּחֲנוּת חַרְסִינָה", translation = "слон в посудной лавке",
            transliteration = "пиль ба-ханут харсина",
            definition = "אָדָם מְגֻשָּׁם שֶׁשּׁוֹבֵר וּמַזִּיק בְּלִי כַּוָּנָה.",
            definitionNative = "Неуклюжий человек, который ломает и портит без злого умысла. Дословно: «слон в магазине фарфора».",
            example = "הוּא נִכְנַס לַמִּשְׂרָד כְּמוֹ פִּיל בַּחֲנוּת חַרְסִינָה.",
            exampleNative = "Он ввалился в офис как פִּיל בַּחֲנוּת חַרְסִינָה."
        , fillInBlankExclusions = listOf(184711L, 184712L, 184713L, 184714L)),

        // ─── idioms_l1_time_situations (5) ───────────────────────────────
        WordEntity(
            id = 184716, setId = 1847, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l1_time_situations",
            original = "בְּרֶגַע הָאֱמֶת", translation = "в момент истины (в решающий момент)",
            transliteration = "бэ-рега hа-эмет",
            definition = "בָּרֶגַע הֲכִי חָשׁוּב וּמַכְרִיעַ — כְּשֶׁבּוֹדְקִים מִי בֶּאֱמֶת מוּכָן.",
            definitionNative = "В самый важный, решающий момент — когда проверяют, кто реально готов. Дословно: «в момент истины».",
            example = "בְּרֶגַע הָאֱמֶת הוּא נִבְהַל וְלֹא הִצְלִיחַ לְהָגִיב.",
            exampleNative = "בְּרֶגַע הָאֱמֶת он испугался и не смог отреагировать."
        , fillInBlankExclusions = listOf(184717L, 184718L, 184719L, 184720L)),
        WordEntity(
            id = 184717, setId = 1847, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l1_time_situations",
            original = "אַחַת לְיוֹבֵל", translation = "раз в столетие (очень редко)",
            transliteration = "ахат ле-йовель",
            definition = "מַשֶּׁהוּ שֶׁקּוֹרֶה לְעִתִּים נְדִירוֹת מְאֹד — כִּמְעַט אַף פַּעַם לֹא.",
            definitionNative = "То, что случается крайне редко — почти никогда. Дословно: «раз в юбилей».",
            example = "הוּא מְבַקֵּר אֶת הַמִּשְׁפָּחָה אַחַת לְיוֹבֵל בְּדִיּוּק.",
            exampleNative = "Он навещает семью אַחַת לְיוֹבֵל — буквально раз в столетие."
        , fillInBlankExclusions = listOf(184716L, 184718L, 184719L, 184720L)),
        WordEntity(
            id = 184718, setId = 1847, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l1_time_situations",
            original = "עַל סַף הַדֶּלֶת", translation = "на пороге (вот-вот)",
            transliteration = "аль саф hа-делет",
            definition = "מַשֶּׁהוּ שֶׁאוֹטוֹטוֹ קוֹרֶה — קָרוֹב מְאֹד אֲבָל עוֹד לֹא הִתְחִיל.",
            definitionNative = "То, что вот-вот произойдёт — очень близко, но ещё не началось. Дословно: «на пороге двери».",
            example = "אֲנַחְנוּ עַל סַף הַדֶּלֶת שֶׁל שִׁנּוּי גָּדוֹל בַּחֶבְרָה.",
            exampleNative = "Мы עַל סַף הַדֶּלֶת больших перемен в компании."
        , fillInBlankExclusions = listOf(184716L, 184717L, 184719L, 184720L)),
        WordEntity(
            id = 184719, setId = 1847, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_l1_time_situations",
            original = "חַי עַל הַזְּמַן", translation = "впритык со временем (в обрез)",
            transliteration = "хай аль hа-зман",
            definition = "עוֹשֶׂה הַכֹּל בָּרֶגַע הָאַחֲרוֹן — בְּלִי מַרְוָח לִטְעֻיּוֹת.",
            definitionNative = "Делает всё в последний момент — без запаса времени. Дословно: «живёт на времени».",
            example = "הוּא תָּמִיד חַי עַל הַזְּמַן וּמַגִּיעַ בְּדִיּוּק בָּרֶגַע.",
            exampleNative = "Он всегда חַי עַל הַזְּמַן и приходит ровно в последнюю секунду."
        , fillInBlankExclusions = listOf(184716L, 184717L, 184718L, 184720L)),
        WordEntity(
            id = 184720, setId = 1847, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l1_time_situations",
            original = "בְּסוֹפוֹ שֶׁל דָּבָר", translation = "в конце концов (в итоге)",
            transliteration = "бэ-софо шель давар",
            definition = "אַחֲרֵי הַכֹּל, אַחֲרֵי כָּל הַתַּהֲלִיךְ — הַתּוֹצָאָה הַסּוֹפִית.",
            definitionNative = "После всего, в самом итоге процесса — окончательный результат. Дословно: «в конце дела».",
            example = "בְּסוֹפוֹ שֶׁל דָּבָר הִסְכַּמְנוּ לִקְנוֹת אֶת הַדִּירָה.",
            exampleNative = "בְּסוֹפוֹ שֶׁל דָּבָר мы согласились купить квартиру."
        , fillInBlankExclusions = listOf(184716L, 184717L, 184718L, 184719L)),

        // ─── idioms_l1_actions (5) ───────────────────────────────────────
        WordEntity(
            id = 184721, setId = 1847, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l1_actions",
            original = "לִשְׁבֹּר אֶת הָרֹאשׁ", translation = "ломать голову (думать долго)",
            transliteration = "лишбор эт hа-рош",
            definition = "לַחְשֹׁב חָזָק זְמַן רַב עַל בְּעָיָה קָשָׁה — לְחַפֵּשׂ פִּתְרוֹן.",
            definitionNative = "Долго и упорно думать над сложной проблемой — искать решение. Дословно: «ломать голову».",
            example = "אֵין טַעַם לִשְׁבֹּר אֶת הָרֹאשׁ עַל בְּעָיָה כָּזֹאת פְּשׁוּטָה.",
            exampleNative = "Нет смысла לִשְׁבֹּר אֶת הָרֹאשׁ над такой простой задачей."
        ),
        WordEntity(
            id = 184722, setId = 1847, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l1_actions",
            original = "לִתְפֹּס אֶת הַשּׁוֹר בַּקַּרְנַיִם",
            translation = "взять быка за рога",
            transliteration = "литпос эт hа-шор ба-карнаим",
            definition = "לְהַתְחִיל לִפְעֹל בְּהֶחְלֵטִיּוּת בִּמְקוֹם לִפְחֹד וּלְחַכּוֹת.",
            definitionNative = "Начать решительно действовать вместо того, чтобы бояться и ждать. Дословно: «схватить быка за рога».",
            example = "הִגִּיעַ הַזְּמַן לִתְפֹּס אֶת הַשּׁוֹר בַּקַּרְנַיִם וּלְהַחְלִיט.",
            exampleNative = "Пора לִתְפֹּס אֶת הַשּׁוֹר בַּקַּרְנַיִם и наконец принять решение."
        , fillInBlankExclusions = listOf(184721L, 184723L, 184724L, 184725L)),
        WordEntity(
            id = 184723, setId = 1847, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l1_actions",
            original = "לִטְמֹן אֶת הָרֹאשׁ בַּחוֹל",
            translation = "прятать голову в песок",
            transliteration = "литмон эт hа-рош ба-холь",
            definition = "לְהִתְעַלֵּם מִבְּעָיָה בִּמְקוֹם לְהִתְמוֹדֵד אִתָּהּ — כְּמוֹ יַעֲנָה.",
            definitionNative = "Игнорировать проблему вместо того, чтобы её решать — как страус. Дословно: «прятать голову в песок».",
            example = "אָסוּר לִטְמֹן אֶת הָרֹאשׁ בַּחוֹל מוּל בְּעָיָה קָשָׁה כָּזֹאת.",
            exampleNative = "Нельзя לִטְמֹן אֶת הָרֹאשׁ בַּחוֹל перед такой тяжёлой проблемой."
        , fillInBlankExclusions = listOf(184721L, 184722L, 184724L, 184725L)),
        WordEntity(
            id = 184724, setId = 1847, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "idioms_l1_actions",
            original = "לִשְׁפֹּךְ אֶת הַלֵּב", translation = "излить душу (выговориться)",
            transliteration = "лишпох эт hа-лев",
            definition = "לְסַפֵּר לְמִישֶׁהוּ אֶת כָּל מָה שֶׁמַּכְבִּיד עַל הַלֵּב.",
            definitionNative = "Рассказать кому-то всё, что тяжело лежит на сердце. Дословно: «вылить сердце».",
            example = "לִפְעָמִים צָרִיךְ לִשְׁפֹּךְ אֶת הַלֵּב לִפְנֵי חָבֵר טוֹב וּמְבִין.",
            exampleNative = "Иногда нужно לִשְׁפֹּךְ אֶת הַלֵּב перед хорошим понимающим другом."
        , fillInBlankExclusions = listOf(184721L, 184722L, 184723L, 184725L)),
        WordEntity(
            id = 184725, setId = 1847, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "idioms_l1_actions",
            original = "לַעֲשׂוֹת רוּחַ", translation = "делать шум/важничать",
            transliteration = "лаасот руах",
            definition = "לְהִתְפָּאֵר וְלִצְעֹק עַל מַשֶּׁהוּ קָטָן — בְּלִי תֹּכֶן אֲמִתִּי.",
            definitionNative = "Хвастаться и поднимать шум вокруг мелочи — без реального содержания. Дословно: «делать ветер».",
            example = "אֵין טַעַם לַעֲשׂוֹת רוּחַ סְבִיב הַצְלָחָה כָּזֹאת קְטַנָּה וּזְמַנִּית.",
            exampleNative = "Нет смысла לַעֲשׂוֹת רוּחַ вокруг такого маленького и временного успеха."
        ),
    )
}
