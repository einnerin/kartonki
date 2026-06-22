package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — set 1915 (he-ru).
 * Спорт: баскетбол и израильский баскетбол (L2 / UNCOMMON + RARE).
 *
 * Уникальный для he-ru ракурс: израильский баскетбол — клубы (hа-Поэль
 * Иерусалим, Маккаби в 1892), внутренние лиги (Лигат hа-Аль баскет),
 * европейские турниры (Юролига, Фэйнал Фор), позиции (масмих, шомэр зорэк,
 * канаф, мэрказ), стартовая пятёрка, бросковая лексика (зрика, зрикат шалош,
 * зрикат оншин, hатбаа), защитные приёмы (хасима, хатафа), фолы (авэра ишит,
 * мага, тэхнит), структура матча (рэва, шаон hа-зрика, hаараха, псикат зман).
 * Парный к set 1892 (футбол) — вместе покрывают два главных командных спорта
 * Израиля.
 *
 * Распределение редкости (validate_rarity_spread: 2 смежных уровня):
 *   UNCOMMON — 9 слов (A2-B1): общеспортивная и базовая баскетбольная
 *     лексика (NBA, зрика, зрикат шалош, зрикат оншин, מֶרְכָּז, рэва,
 *     hаараха, псикат зман, нэкуда).
 *   RARE — 16 слов (B2): специализированная баскетбольная терминология
 *     (hа-Поэль Й., Лигат hа-Аль баскет, Юролига, Фэйнал Фор, חַמְשִׁיָּה
 *     פּוֹתַחַת, масмих, шомэр зорэк, канаф, hатбаа, кадрур, хасима,
 *     хатафа, авэра ишит, авэрат мага, авэра тэхнит, шаон hа-зрика).
 *
 * Не пересекается со словами в существующих he-ru сетах темы «Спорт»
 * (1041, 1285, 1286, 1287, 1490, 1892). Исключены кандидаты-дубли:
 *   - מַכַּבִּי תֵּל אָבִיב — в set 1892 (футбол)
 *   - כַּדּוּרְסָל — в set 1041 (Спорт)
 *   - אַלִּיפוּת — в set 1490 (Спорт)
 *   - גָּבִיעַ הַמְּדִינָה — в set 1892 (футбол)
 *   - מְסִירָה — семантический дубль с מַסִירָה в set 1892
 *   - קַפְטֶן הַקְּבוּצָה — семантический дубль с קַפִּיטָן в set 1490
 *
 * Слова, имеющиеся в других темах (НЕ «Спорт») — допустимы:
 *   - מֶרְכָּז (IsraeliTransportL2, «Транспорт» — там «центр страны»)
 *   - זְרִיקָה (Batch55/67/68, «Медицина» — там «инъекция»)
 *   - הַאֲרָכָה (BureauL2, «Бюрократия» — там «продление срока»)
 *   - נְקוּדָה (Batch61, «Математика» — там «точка»)
 *   - קְלִיעָה (ArmyL1 — стрельба, не используется здесь)
 * Это разные значения в разных контекстах; cross-topic дубли разрешены
 * валидатором.
 *
 * Пять семантических подгрупп (validate_group_sizes: 3-8 на группу):
 *   sport_basketball_clubs — 5 слов: клубы, лиги, турниры
 *   sport_basketball_positions — 5 слов: позиции и состав
 *   sport_basketball_play — 5 слов: броски и атакующие приёмы
 *   sport_basketball_defense — 5 слов: защита и фолы
 *   sport_basketball_game — 5 слов: структура матча и счёт
 *
 * Все слова помечены isFillInBlankSafe=false: ивритская морфология (биньян,
 * огласовки, артикли ה/ב/ל/מ, смихут — многие записи — фразы из 2-3 слов)
 * ломает подстрочную замену в FILL_IN_BLANK, пока не реализована
 * Hebrew-aware логика. Финальный pipeline проставит exclusions и snimet
 * флаг для безопасных слов.
 *
 * Word IDs: 191501..191525 (setId × 100 + position).
 */
object WordDataHebrewSportsBasketball {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1915, languagePair = "he-ru", orderIndex = 1915,
            name = "Спорт",
            description = "Баскетбол в Израиле: лиги, позиции, броски, защита, Маккаби и Евролига.",
            topic = "Спорт",
            level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: sport_basketball_clubs (5 words) ───────────────────────────

        WordEntity(id = 191501, setId = 1915, languagePair = "he-ru", rarity = "RARE",
            original = "הַפּוֹעֵל יְרוּשָׁלַיִם",
            translation = "Хапоэль Иерусалим (баскетбольный клуб)",
            definition = "מוֹעֲדוֹן בַּסְל מִיְּרוּשָׁלַיִם — אַלּוּף יִשְׂרָאֵל בְּמַסְפַּר עוֹנוֹת וְזוֹכֶה גָּבִיעַ אֵירוֹפָּה.",
            definitionNative = "Иерусалимский баскетбольный клуб — многократный чемпион Израиля и обладатель европейских трофеев.",
            example = "הַפּוֹעֵל יְרוּשָׁלַיִם נִצְּחָה אֶת מַכַּבִּי בַּדֶּרְבִּי הַחָשׁוּב.",
            exampleNative = "הַפּוֹעֵל יְרוּשָׁלַיִם обыграл Маккаби в важном дерби.",
            pos = "phrase", semanticGroup = "sport_basketball_clubs", fillInBlankExclusions = listOf(191502L, 191505L)),

        WordEntity(id = 191502, setId = 1915, languagePair = "he-ru", rarity = "RARE",
            original = "לִיגַת הָעַל בְּכַדּוּרְסַל",
            translation = "Премьер-лига по баскетболу",
            definition = "הַדַּרְגָּה הָעֶלְיוֹנָה שֶׁל בַּסְקֶטְבּוֹל מִקְצוֹעָנִי בְּיִשְׂרָאֵל — שְׁתֵּים־עֶשְׂרֵה קְבוּצוֹת.",
            definitionNative = "Высший дивизион профессионального баскетбола в Израиле — двенадцать клубов.",
            example = "הַקְּבוּצָה עָלְתָה לְלִיגַת הָעַל בְּכַדּוּרְסַל לְאַחַר עוֹנָה מַרְשִׁימָה.",
            exampleNative = "Клуб поднялся в לִיגַת הָעַל בְּכַדּוּרְסַל после впечатляющего сезона.",
            pos = "phrase", semanticGroup = "sport_basketball_clubs", fillInBlankExclusions = listOf(191501L, 191505L)),

        WordEntity(id = 191503, setId = 1915, languagePair = "he-ru", rarity = "RARE",
            original = "יוּרוֹלִיגָה",
            translation = "Евролига (главный клубный турнир Европы)",
            definition = "טוּרְנִיר הַבַּסְקֶטְבּוֹל הַחָשׁוּב בְּיוֹתֵר בְּאֵירוֹפָּה — מַכַּבִּי תֵּל אָבִיב זָכְתָה בּוֹ שֵׁשׁ פְּעָמִים.",
            definitionNative = "Главный клубный турнир Европы по баскетболу — Маккаби Тель-Авив выигрывал его шесть раз.",
            example = "הַפְּרוֹיֶקְט בַּיוּרוֹלִיגָה נִכְשַׁל אַחֲרֵי הֶפְסֵד בַּשְּׁמִינִית.",
            exampleNative = "Поход в יוּרוֹלִיגָה закончился поражением в одной восьмой.",
            pos = "noun", semanticGroup = "sport_basketball_clubs", fillInBlankExclusions = listOf(191504L)),

        WordEntity(id = 191504, setId = 1915, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "NBA",
            translation = "НБА (главная лига США)",
            definition = "הַלִּיגָה הַמִּקְצוֹעָנִית הַחֲשׁוּבָה בְּיוֹתֵר בָּאַרְצוֹת הַבְּרִית — חֲלוֹם שֶׁל כָּל שַׂחְקַן בַּסְקֶטְבּוֹל בָּעוֹלָם.",
            definitionNative = "Главная профессиональная лига США — мечта любого баскетболиста в мире.",
            example = "הַשַּׂחְקָן הַיִּשְׂרְאֵלִי חֲתַם חוֹזֶה בַּNBA בְּגִיל עֶשְׂרִים וּשְׁתַּיִם.",
            exampleNative = "Израильский игрок подписал контракт в NBA в двадцать два года.",
            pos = "noun", semanticGroup = "sport_basketball_clubs", fillInBlankExclusions = listOf(191503L)),

        WordEntity(id = 191505, setId = 1915, languagePair = "he-ru", rarity = "RARE",
            original = "פַיְנָל פוֹר",
            translation = "Финал Четырёх (Final Four)",
            definition = "שָׁלָב חֲצִי־הַגְּמָר וְהַגְּמָר שֶׁל הַיּוּרוֹלִיגָה — אַרְבַּע קְבוּצוֹת מִתְמוֹדְדוֹת עַל הַגָּבִיעַ בְּסוֹף שָׁבוּעַ אֶחָד.",
            definitionNative = "Полуфинал и финал Евролиги — четыре команды борются за кубок в один уикенд.",
            example = "מַכַּבִּי הִגִּיעָה לַפַיְנָל פוֹר אַחֲרֵי שֶׁנִּצְּחָה בַּחֲצִי גְּמָר.",
            exampleNative = "Маккаби вышел в פַיְנָל פוֹר после победы в плей-офф.",
            pos = "phrase", semanticGroup = "sport_basketball_clubs", fillInBlankExclusions = listOf(191501L, 191502L)),

        // ── Group: sport_basketball_positions (5 words) ───────────────────────

        WordEntity(id = 191506, setId = 1915, languagePair = "he-ru", rarity = "RARE",
            original = "רַכָּז",
            translation = "разыгрывающий защитник (point guard)",
            definition = "הַשַּׂחְקָן שֶׁמְּנַהֵל אֶת הַהַתְקָפָה — מַעֲבִיר אֶת הַכַּדּוּר וְקוֹבֵעַ אֶת הַקֶּצֶב שֶׁל הַמִּשְׂחָק.",
            definitionNative = "Игрок, который ведёт атаку — разводит мяч и задаёт темп игры команды.",
            example = "הָרַכָּז הַצָּעִיר חִלֵּק שְׁתֵּים־עֶשְׂרֵה אַסִיסְטִים בָּעֶרֶב.",
            exampleNative = "Молодой רַכָּז отдал двенадцать передач за вечер.",
            pos = "noun", semanticGroup = "sport_basketball_positions", fillInBlankExclusions = listOf(191508L, 191509L)),

        WordEntity(id = 191507, setId = 1915, languagePair = "he-ru", rarity = "RARE",
            original = "שׁוֹמֵר זוֹרֵק",
            translation = "атакующий защитник (shooting guard)",
            definition = "שַׂחְקָן הַסִּעוּף הָאֲחוֹרִי הַמִּתְמַחֶה בִּקְלִיעוֹת מֵרָחוֹק וּבְקֻדּוֹת לַסַּל.",
            definitionNative = "Защитник задней линии, специализируется на дальних бросках и наборе очков.",
            example = "שׁוֹמֵר זוֹרֵק הָאוֹרֵחַ קָלַע שֶׁבַע זְרִיקוֹת שָׁלוֹשׁ בַּמִּשְׂחָק.",
            exampleNative = "Гостевой שׁוֹמֵר זוֹרֵק забил семь трёхочковых за матч.",
            pos = "phrase", semanticGroup = "sport_basketball_positions", fillInBlankExclusions = listOf(191510L)),

        WordEntity(id = 191508, setId = 1915, languagePair = "he-ru", rarity = "RARE",
            original = "כָּנָף",
            translation = "крайний нападающий (forward)",
            definition = "שַׂחְקָן בַּקֶּצֶה שֶׁל הַחֲמִישִׁיָּה — מְשַׁלֵּב כּוֹחַ מִתַּחַת לַסַּל עִם יְכוֹלֶת קְלִיעָה מִחוּץ לַקֶּשֶׁת.",
            definitionNative = "Игрок на краю пятёрки — сочетает силовую игру под кольцом с броском из-за дуги.",
            example = "הַכָּנָף הַגָּבוֹהַּ אָסַף שְׁמוֹנֶה רִיבָּאוּנְדִים בַּמַּחֲצִית הָרִאשׁוֹנָה.",
            exampleNative = "Высокий כָּנָף собрал восемь подборов в первой половине.",
            pos = "noun", semanticGroup = "sport_basketball_positions", fillInBlankExclusions = listOf(191506L, 191509L)),

        WordEntity(id = 191509, setId = 1915, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מֶרְכָּז",
            translation = "центровой (center)",
            definition = "הַשַּׂחְקָן הַגָּבוֹהַּ בְּיוֹתֵר בַּקְּבוּצָה — מְשַׂחֵק קָרוֹב לַסַּל וְאַחְרַאי עַל רִיבָּאוּנְדִים וַחֲסִימוֹת.",
            definitionNative = "Самый высокий игрок команды — играет под кольцом и отвечает за подборы и блоки.",
            example = "הַמֶּרְכָּז שֶׁל הַקְּבוּצָה גָּבוֹהַּ שְׁנֵי מֶטֶר וְעֶשֶׂר.",
            exampleNative = "מֶרְכָּז команды ростом два метра десять.",
            pos = "noun", semanticGroup = "sport_basketball_positions"),

        WordEntity(id = 191510, setId = 1915, languagePair = "he-ru", rarity = "RARE",
            original = "חֲמִישִׁיָּה פּוֹתַחַת",
            translation = "стартовая пятёрка",
            definition = "חֲמֵשֶׁת הַשַּׂחְקָנִים שֶׁפּוֹתְחִים אֶת הַמִּשְׂחָק עַל הַמִּגְרָשׁ — הַהֶרְכֵּב הַחָזָק בְּיוֹתֵר שֶׁל הַקְּבוּצָה.",
            definitionNative = "Пятёрка игроков, выходящих на площадку в начале матча — сильнейший состав команды.",
            example = "הַחֲמִישִׁיָּה הַפּוֹתַחַת הִתְחִילָה אֶת הָעוֹנָה בְּהַרְכֵּב מוּכָּר.",
            exampleNative = "חֲמִישִׁיָּה פּוֹתַחַת начала сезон в привычном составе.",
            pos = "phrase", semanticGroup = "sport_basketball_positions",
            isFillInBlankSafe = false),

        // ── Group: sport_basketball_play (5 words) ────────────────────────────

        WordEntity(id = 191511, setId = 1915, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "זְרִיקָה",
            translation = "бросок (по кольцу)",
            definition = "פְּעוּלָה שֶׁל הַשְׁלָכַת הַכַּדּוּר לְעֵבֶר הַסַּל בְּמַטָּרָה לִצְבּוֹר נְקֻדּוֹת.",
            definitionNative = "Действие, когда игрок отправляет мяч в направлении кольца, чтобы набрать очки.",
            example = "הַזְּרִיקָה הָאַחֲרוֹנָה שֶׁלּוֹ פָּגְעָה בַּחִישּׁוּק וְלֹא נִכְנְסָה.",
            exampleNative = "Его последняя זְרִיקָה ударилась о дужку и не попала.",
            pos = "noun", semanticGroup = "sport_basketball_play"),

        WordEntity(id = 191512, setId = 1915, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "זְרִיקַת שָׁלוֹשׁ",
            translation = "трёхочковый бросок",
            definition = "קְלִיעָה מֵעֵבֶר לַקֶּשֶׁת שֶׁל שֵׁשׁ מֶטֶר וָרֶבַע — מַעֲנִיקָה שָׁלוֹשׁ נְקֻדּוֹת לְקוֹלֵעַ.",
            definitionNative = "Бросок из-за линии в шесть метров двадцать пять — приносит команде три очка.",
            example = "בְּדַקָּה הָאַחֲרוֹנָה הוּא כָּבַשׁ זְרִיקַת שָׁלוֹשׁ מַכְרִיעָה.",
            exampleNative = "На последней минуте он забил решающую זְרִיקַת שָׁלוֹשׁ.",
            pos = "phrase", semanticGroup = "sport_basketball_play"),

        WordEntity(id = 191513, setId = 1915, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "זְרִיקַת עוֹנְשִׁין",
            translation = "штрафной бросок",
            definition = "קְלִיעָה חוֹפְשִׁית מִקַּו שִׁבְעָה מֶטֶר וְחֵצִי — נִתֶּנֶת אַחֲרֵי עֲבֵרָה אִישִׁית שֶׁל הַיָּרִיב.",
            definitionNative = "Свободный бросок с линии в семь с половиной метров — назначается после фола соперника.",
            example = "הוּא הֶחְמִיץ אֶת שְׁתֵּי זְרִיקוֹת הָעוֹנְשִׁין בְּסוֹף הָרֵבָע.",
            exampleNative = "Он смазал обе זְרִיקַת עוֹנְשִׁין в концовке четверти.",
            pos = "phrase", semanticGroup = "sport_basketball_play",
            isFillInBlankSafe = false),

        WordEntity(id = 191514, setId = 1915, languagePair = "he-ru", rarity = "RARE",
            original = "הַטְבָּעָה",
            translation = "слэм-данк (бросок сверху)",
            definition = "קְלִיעָה מֵעַל הַחִישּׁוּק כְּשֶׁהַשַּׂחְקָן קוֹפֵץ וְשׂוֹם אֶת הַכַּדּוּר יָשַׁר לְתוֹךְ הַסַּל.",
            definitionNative = "Бросок сверху, когда игрок выпрыгивает и закладывает мяч прямо в кольцо.",
            example = "הוּא סָגַר אֶת הָרֵבָע בְּהַטְבָּעָה מְרַשֶּׁמֶת מֵעַל הַיָּרִיב.",
            exampleNative = "Он закрыл четверть эффектной הַטְבָּעָה над защитником.",
            pos = "noun", semanticGroup = "sport_basketball_play", fillInBlankExclusions = listOf(191511L, 191515L)),

        WordEntity(id = 191515, setId = 1915, languagePair = "he-ru", rarity = "RARE",
            original = "כִּדְרוּר",
            translation = "ведение мяча (дриблинг)",
            definition = "הַקְפָּצַת הַכַּדּוּר עַל הָרִצְפָּה תּוֹךְ כְּדֵי תְּנוּעָה — הַדֶּרֶךְ הַחוּקִית לְהִתְקַדֵּם עִם הַכַּדּוּר.",
            definitionNative = "Удары мячом о пол во время движения — единственный законный способ идти с мячом.",
            example = "הַכִּדְרוּר הַמָּהִיר שֶׁלּוֹ עָקַף שְׁנֵי שׁוֹמְרִים בַּדֶּרֶךְ לַסַּל.",
            exampleNative = "Его быстрый כִּדְרוּר прошёл двух защитников по пути к кольцу.",
            pos = "noun", semanticGroup = "sport_basketball_play", fillInBlankExclusions = listOf(191511L, 191514L)),

        // ── Group: sport_basketball_defense (5 words) ─────────────────────────

        WordEntity(id = 191516, setId = 1915, languagePair = "he-ru", rarity = "RARE",
            original = "חֲסִימָה",
            translation = "блок-шот (защитный блок)",
            definition = "פְּעוּלָה שֶׁל עֲצִירַת זְרִיקַת הַיָּרִיב בָּאֲוִיר — הַמֵּגֵן נוֹגֵעַ בַּכַּדּוּר וּמוֹנַע סְלִיקָה.",
            definitionNative = "Действие, когда защитник в прыжке отбивает летящий мяч соперника и срывает атаку.",
            example = "הַחֲסִימָה שֶׁל הַמֶּרְכָּז גָּרְמָה לְקָהָל לָקוּם עַל הָרַגְלַיִם.",
            exampleNative = "חֲסִימָה центрового подняла трибуны на ноги.",
            pos = "noun", semanticGroup = "sport_basketball_defense", fillInBlankExclusions = listOf(191517L)),

        WordEntity(id = 191517, setId = 1915, languagePair = "he-ru", rarity = "RARE",
            original = "חֲטָפָה",
            translation = "перехват мяча (steal)",
            definition = "לְקִיחַת הַכַּדּוּר מִידֵי הַיָּרִיב תּוֹךְ כְּדֵי מַסִירָה אוֹ כַּדְרוּר — בְּלִי לַעֲשׂוֹת עֲבֵרָה.",
            definitionNative = "Отбор мяча у соперника во время передачи или ведения — без нарушения правил.",
            example = "הַחֲטָפָה שֶׁל הַשַּׂחְקָן הַמַּסְמִיךְ הָפְכָה לְהַטְבָּעָה מַהִירָה.",
            exampleNative = "חֲטָפָה разыгрывающего обернулась быстрой הַטְבָּעָה.",
            pos = "noun", semanticGroup = "sport_basketball_defense", fillInBlankExclusions = listOf(191516L)),

        WordEntity(id = 191518, setId = 1915, languagePair = "he-ru", rarity = "RARE",
            original = "עֲבֵרָה אִישִׁית",
            translation = "персональный фол",
            definition = "מַגָּע אָסוּר שֶׁל מֵגֵן בְּשַׂחְקַן הַיָּרִיב — חֲמֵשׁ עֲבֵרוֹת אִישִׁיוֹת מוֹצִיאוֹת מֵהַמִּשְׂחָק.",
            definitionNative = "Запрещённый контакт защитника с игроком соперника — после пяти таких фолов удаление.",
            example = "הוּא יָצָא מֵהַמִּשְׂחָק עִם חָמֵשׁ עֲבֵרוֹת אִישִׁיוֹת בָּרֵבָע הָאַחֲרוֹן.",
            exampleNative = "Он покинул паркет с пятью עֲבֵרָה אִישִׁית в последней четверти.",
            pos = "phrase", semanticGroup = "sport_basketball_defense",
            isFillInBlankSafe = false),

        WordEntity(id = 191519, setId = 1915, languagePair = "he-ru", rarity = "RARE",
            original = "עֲבֵרַת מַגָּע",
            translation = "контактный фол",
            definition = "עֲבֵרָה הַנּוֹצֶרֶת מִדְּחִיפָה אוֹ הַחְזָקָה שֶׁל הַיָּרִיב תּוֹךְ כְּדֵי מַאֲבָק עַל מָקוֹם.",
            definitionNative = "Фол от толчка или удерживания соперника во время борьбы за позицию под кольцом.",
            example = "הַשּׁוֹפֵט שָׁרַק עֲבֵרַת מַגָּע בְּמַאֲבָק עַל הָרִיבָּאוּנְד.",
            exampleNative = "Судья свистнул עֲבֵרַת מַגָּע при борьбе за подбор.",
            pos = "phrase", semanticGroup = "sport_basketball_defense", fillInBlankExclusions = listOf(191518L, 191520L)),

        WordEntity(id = 191520, setId = 1915, languagePair = "he-ru", rarity = "RARE",
            original = "עֲבֵרָה טֶכְנִית",
            translation = "технический фол",
            definition = "עוֹנֶשׁ עַל הִתְנַהֲגוּת לֹא־סְפּוֹרְטִיבִית — וִכּוּחַ עִם הַשּׁוֹפֵט, גִּדּוּפִים אוֹ אִיחוּר זְמַן.",
            definitionNative = "Наказание за неспортивное поведение — спор с арбитром, ругань или затяжка времени.",
            example = "הַמְּאַמֵּן קִבֵּל עֲבֵרָה טֶכְנִית עַל הַצְּעָקוֹת מֵהַסַּפְסָל.",
            exampleNative = "Тренер получил עֲבֵרָה טֶכְנִית за крики со скамейки.",
            pos = "phrase", semanticGroup = "sport_basketball_defense", fillInBlankExclusions = listOf(191518L, 191519L)),

        // ── Group: sport_basketball_game (5 words) ────────────────────────────

        WordEntity(id = 191521, setId = 1915, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רֵבַע",
            translation = "четверть (период матча)",
            definition = "אֶחָד מֵאַרְבָּעָה חֲלָקִים שׁוֹוִים שֶׁל מִשְׂחַק בַּסְקֶטְבּוֹל — עֶשֶׂר דַּקּוֹת בְּפִיב\"א וּשְׁתֵּים־עֶשְׂרֵה בַּNBA.",
            definitionNative = "Один из четырёх равных периодов матча — десять минут в ФИБА и двенадцать в NBA.",
            example = "בַּרֵבַע הַשְּׁלִישִׁי הַקְּבוּצָה צִמְצְמָה אֶת הַפֶּעֵר לִשְׁתֵּי נְקֻדּוֹת.",
            exampleNative = "В третьем רֵבַע команда сократила отставание до двух очков.",
            pos = "noun", semanticGroup = "sport_basketball_game", fillInBlankExclusions = listOf(191523L, 191525L)),

        WordEntity(id = 191522, setId = 1915, languagePair = "he-ru", rarity = "RARE",
            original = "שְׁעוֹן הַזְּרִיקָה",
            translation = "счётчик атаки (shot clock)",
            definition = "מַד זְמַן שֶׁל עֶשְׂרִים וְאַרְבַּע שְׁנִיּוֹת בְּתוֹכוֹ הַקְּבוּצָה חַיֶּבֶת לִזְרוֹק לַסַּל.",
            definitionNative = "Таймер на двадцать четыре секунды, за которые команда обязана бросить по кольцу.",
            example = "שְׁעוֹן הַזְּרִיקָה הִתְקָרֵב לְאֶפֶס וְהוּא נֶאֱלַץ לִזְרוֹק מֵרָחוֹק.",
            exampleNative = "שְׁעוֹן הַזְּרִיקָה подходил к нулю, и пришлось бросать издалека.",
            pos = "phrase", semanticGroup = "sport_basketball_game", fillInBlankExclusions = listOf(191524L)),

        WordEntity(id = 191523, setId = 1915, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַאֲרָכָה",
            translation = "овертайм (дополнительное время)",
            definition = "חֲמֵשׁ דַּקּוֹת נוֹסָפוֹת לְמִשְׂחָק שֶׁהִסְתַּיֵּם בְּתֵיקוּ — מְשַׂחֲקִים עַד שֶׁמִּישֶׁהוּ מְנַצֵּחַ.",
            definitionNative = "Пять дополнительных минут к матчу, который закончился вничью — играют до победы.",
            example = "הַמִּשְׂחָק הוּכְרַע רַק בַּהַאֲרָכָה הַשְּׁנִיָּה אַחֲרֵי תֵּיקוּ.",
            exampleNative = "Исход решился только во второй הַאֲרָכָה после ничейного основного времени.",
            pos = "noun", semanticGroup = "sport_basketball_game", fillInBlankExclusions = listOf(191521L, 191525L)),

        WordEntity(id = 191524, setId = 1915, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פְּסִיקַת זְמַן",
            translation = "тайм-аут (минутный перерыв)",
            definition = "הַפְסָקָה קְצָרָה שֶׁמְּבַקֵּשׁ הַמְּאַמֵּן כְּדֵי לְהוֹרוֹת עַל טַקְטִיקָה אוֹ לְעַצֵּב מַהֲלָךְ.",
            definitionNative = "Короткая пауза по запросу тренера, чтобы дать указания по тактике или сбить ритм соперника.",
            example = "הַמְּאַמֵּן בִּקֵּשׁ פְּסִיקַת זְמַן בְּדַקָּה הָאַחֲרוֹנָה לְפִי תּוֹכְנִית מַהֲלָךְ.",
            exampleNative = "Тренер взял פְּסִיקַת זְמַן на последней минуте, чтобы разобрать комбинацию.",
            pos = "phrase", semanticGroup = "sport_basketball_game", fillInBlankExclusions = listOf(191522L)),

        WordEntity(id = 191525, setId = 1915, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "נְקֻדָּה",
            translation = "очко (единица счёта)",
            definition = "יְחִידַת הַחִשּׁוּב הַבְּסִיסִית בַּמִּשְׂחָק — שְׁתַּיִם עַל קְלִיעָה רְגִילָה וְשָׁלוֹשׁ מֵעֵבֶר לַקֶּשֶׁת.",
            definitionNative = "Базовая единица счёта в матче — два за обычный бросок и три из-за дуги.",
            example = "הַקְּבוּצָה צָבְרָה תִּשְׁעִים נְקֻדּוֹת וְנִצְּחָה בְּהֶפְרֵשׁ דּוּ־סִפְרָתִי.",
            exampleNative = "Команда набрала девяносто נְקֻדָּה и победила с двузначной разницей.",
            pos = "noun", semanticGroup = "sport_basketball_game",
            isFillInBlankSafe = false),
    )
}
