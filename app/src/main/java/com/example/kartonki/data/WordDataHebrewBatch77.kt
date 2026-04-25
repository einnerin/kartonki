package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrewBatch77 {

    val sets: List<WordSetEntity> = listOf(
        // ── Транспорт: основы 4, 5 ───────────────────────────────────────────

        // ── Спорт: основы 3, 4, 5 ────────────────────────────────────────────
        WordSetEntity(id = 1490, languagePair = "he-ru", orderIndex = 1490,
            name = "Спорт", description = "Командные виды спорта и соревнования",
            topic = "Спорт", level = 1),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // ТРАНСПОРТ: ОСНОВЫ 4 — set 1488 (общественный транспорт, COMMON),
        // ══════════════════════════════════════════════════════════════════════

        // ══════════════════════════════════════════════════════════════════════
        // ТРАНСПОРТ: ОСНОВЫ 5 — set 1489 (вождение в Израиле, COMMON)
        // ══════════════════════════════════════════════════════════════════════

        // ══════════════════════════════════════════════════════════════════════
        // СПОРТ: ОСНОВЫ 3 — set 1490 (командный спорт и соревнования, COMMON)
        // ══════════════════════════════════════════════════════════════════════
        WordEntity(
            id = 149001, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_kinds", transliteration = "гольф",
            original = "גוֹלֶף", translation = "гольф",
            definition = "מִשְׂחָק שֶׁבּוֹ מַכִּים בְּכַדּוּר קָטָן עִם מַקֵּל לְתוֹךְ חוֹר.",
            definitionNative = "Игра, где маленький мяч клюшкой загоняют в лунку на травяном поле.",
            example = "סָבָא שֶׁלִּי מְשַׂחֵק גוֹלֶף בְּכָל יוֹם רִאשׁוֹן.",
            exampleNative = "Мой дедушка играет в גוֹלֶף каждое воскресенье."
        , fillInBlankExclusions = listOf(149002L, 149003L, 149004L, 149005L, 149006L)),
        WordEntity(
            id = 149002, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_kinds", transliteration = "аманут лахама",
            original = "אָמָנוּת לַחֲמָה", translation = "боевые искусства",
            definition = "שִׁיטוֹת קְרָב כְּמוֹ קָרָאטֶה אוֹ גְּ'וּדוֹ, מְלַמְּדִים מִשְׁמַעַת וּמַגֵּן עַצְמִי.",
            definitionNative = "Каратэ, дзюдо и подобные системы рукопашной защиты и нападения.",
            example = "אַחִי לוֹמֵד אָמָנוּת לַחֲמָה כְּבָר חָמֵשׁ שָׁנִים.",
            exampleNative = "Брат уже пять лет занимается אָמָנוּת לַחֲמָה."
        , fillInBlankExclusions = listOf(149001L, 149003L, 149004L, 149005L, 149006L)),
        WordEntity(
            id = 149003, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_kinds", transliteration = "хокэй аль hа-кэрах",
            original = "הוֹקֵי עַל הַקֶּרַח", translation = "хоккей на льду",
            definition = "מִשְׂחַק קְבוּצָה עִם מַקְלוֹת וְדִיסְקִית, מְשַׂחֲקִים עִם מַחֲלִיקַיִם עַל זִירָה קָרָה.",
            definitionNative = "Командная игра шайбой и клюшкой на ледовом поле, играют на коньках.",
            example = "צָפִיתִי בַּמִּשְׂחָק הוֹקֵי עַל הַקֶּרַח בַּטֶּלֶוִיזְיָה.",
            exampleNative = "Я смотрел матч הוֹקֵי עַל הַקֶּרַח по телевизору."
        , fillInBlankExclusions = listOf(149001L, 149002L, 149004L, 149005L, 149006L)),
        WordEntity(
            id = 149004, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_kinds", transliteration = "эгроф",
            original = "אֲגְרוֹף", translation = "бокс",
            definition = "סְפּוֹרְט קְרָב שֶׁבּוֹ שְׁנֵי יְרִיבִים מַכִּים זֶה אֶת זֶה בְּכַפּוֹת יָדַיִם בְּתוֹךְ זִירָה.",
            definitionNative = "Единоборство, где двое противников бьют друг друга кулаками в перчатках на ринге.",
            example = "הוּא מִתְאַמֵּן אֲגְרוֹף שָׁלוֹשׁ פְּעָמִים בַּשָּׁבוּעַ.",
            exampleNative = "Он тренирует אֲגְרוֹף три раза в неделю."
        , fillInBlankExclusions = listOf(149001L, 149002L, 149003L, 149005L, 149006L)),
        WordEntity(
            id = 149005, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_kinds", transliteration = "шахья",
            original = "שַׁחְיָה", translation = "плавание",
            definition = "תְּנוּעָה בַּמַּיִם בְּעֶזְרַת יָדַיִם וְרַגְלַיִם, סְפּוֹרְט אוֹ פְּעֻלָּה לְהַנָאָה.",
            definitionNative = "Передвижение в воде с помощью рук и ног, как спорт или для удовольствия.",
            example = "אֲנִי הוֹלֵךְ לְשַׁחְיָה בַּבְּרֵכָה אַחֲרֵי הָעֲבוֹדָה.",
            exampleNative = "Я хожу на שַׁחְיָה в бассейн после работы."
        , fillInBlankExclusions = listOf(149001L, 149002L, 149003L, 149004L, 149006L)),
        WordEntity(
            id = 149006, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_kinds", transliteration = "атлетика",
            original = "אַתְלֵטִיקָה", translation = "лёгкая атлетика",
            definition = "תְּחוּם סְפּוֹרְט הַכּוֹלֵל רִיצָה, קְפִיצָה וְזְרִיקָה שֶׁל כֵּלִים.",
            definitionNative = "Раздел спорта: бег, прыжки и метание снарядов; на стадионе или арене.",
            example = "אַתְלֵטִיקָה הִיא חֵלֶק חָשׁוּב מִן הַמִּשְׂחָקִים הָאוֹלִימְפִּיִּים.",
            exampleNative = "אַתְלֵטִיקָה — важная часть Олимпийских игр."
        , fillInBlankExclusions = listOf(149001L, 149002L, 149003L, 149004L, 149005L)),
        WordEntity(
            id = 149007, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_roles", transliteration = "квуца",
            original = "קְבוּצָה", translation = "команда",
            definition = "אֲסוּפָה שֶׁל סְפּוֹרְטָאִים הַמְּשַׂחֲקִים יַחַד נֶגֶד יְרִיבִים.",
            definitionNative = "Группа спортсменов, играющих сообща против соперников по правилам.",
            example = "הַקְּבוּצָה שֶׁלָּנוּ נִצְּחָה בַּמִּשְׂחָק אֶמֶשׁ.",
            exampleNative = "Наша קְבוּצָה выиграла матч вчера."
        ),
        WordEntity(
            id = 149008, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_roles", transliteration = "шахкан хилуф",
            original = "שַׁחְקַן חִלּוּף", translation = "запасной игрок",
            definition = "סְפּוֹרְטָאי שֶׁמְּחַכֶּה בְּצַד הַמִּגְרָשׁ וְעוֹלֶה לְשַׂחֵק בִּמְקוֹם חָבֵר אַחֵר.",
            definitionNative = "Спортсмен на скамейке, выходит на поле вместо уставшего или травмированного.",
            example = "הַמְּאַמֵּן שָׁלַח שַׁחְקַן חִלּוּף בַּדַּקָּה הַשְּׁמוֹנִים.",
            exampleNative = "Тренер выпустил שַׁחְקַן חִלּוּף на восьмидесятой минуте."
        , fillInBlankExclusions = listOf(149007L, 149009L, 149010L)),
        WordEntity(
            id = 149009, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_roles", transliteration = "капитан",
            original = "קַפִּיטָן", translation = "капитан команды",
            definition = "הַסְּפּוֹרְטָאי הָרָאשִׁי שֶׁמּוֹבִיל אֶת הַחֲבֵרִים בַּמִּגְרָשׁ וּמְקַבֵּל הַחְלָטוֹת.",
            definitionNative = "Главный игрок, ведёт партнёров на поле и принимает решения во время игры.",
            example = "הַקַּפִּיטָן לוֹחֵץ יַד לַשּׁוֹפֵט לִפְנֵי הַמִּשְׂחָק.",
            exampleNative = "קַפִּיטָן пожимает руку арбитру перед началом матча."
        ),
        WordEntity(
            id = 149010, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_roles", transliteration = "шофэт",
            original = "שׁוֹפֵט", translation = "судья (спортивный)",
            definition = "אִישׁ הַמַּקְפִּיד עַל הַחֻקִּים בַּמִּשְׂחָק וּמְצַפְצֵף בִּשְׁעַת עֲבֵרָה.",
            definitionNative = "Человек, следит за правилами на поле и свистит при нарушениях.",
            example = "הַשּׁוֹפֵט נָתַן עֳנֶשׁ עַל הַעֲבֵרָה.",
            exampleNative = "שׁוֹפֵט назначил штрафной за нарушение."
        ),
        WordEntity(
            id = 149011, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_outcome", transliteration = "картис адом",
            original = "כַּרְטִיס אָדֹם", translation = "красная карточка",
            definition = "סִימָן שֶׁל הַשּׁוֹפֵט עַל עֲבֵרָה חֲמוּרָה, הַשַּׂחְקָן יוֹרֵד מִיָּד מֵהַמִּגְרָשׁ.",
            definitionNative = "Знак арбитра за грубое нарушение: игрок сразу покидает поле без замены.",
            example = "הַשַּׂחְקָן קִבֵּל כַּרְטִיס אָדֹם וְעָזַב אֶת הַמִּגְרָשׁ.",
            exampleNative = "Игрок получил כַּרְטִיס אָדֹם и ушёл с поля."
        , fillInBlankExclusions = listOf(149015L, 149016L, 149017L, 149018L, 149019L, 149020L, 149021L)),
        WordEntity(
            id = 149012, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_event", transliteration = "ицтадьон",
            original = "אִצְטַדְיוֹן", translation = "стадион",
            definition = "מִבְנֶה גָּדוֹל עִם מִגְרָשׁ וְכַרְטִיסֵי יְשִׁיבָה לַקָּהָל בִּשְׁעַת מִשְׂחָק.",
            definitionNative = "Большое сооружение с полем и трибунами для зрителей во время матчей.",
            example = "הָלַכְתִּי לָאִצְטַדְיוֹן לִרְאוֹת אֶת הַמִּשְׂחָק.",
            exampleNative = "Я пошёл на אִצְטַדְיוֹן посмотреть матч."
        , fillInBlankExclusions = listOf(149013L, 149014L, 149022L, 149023L, 149024L, 149025L)),
        WordEntity(
            id = 149013, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_event", transliteration = "лига",
            original = "לִיגָה", translation = "лига",
            definition = "אַרְגוּן שֶׁל קְבוּצוֹת הַמְּשַׂחֲקוֹת זוֹ נֶגֶד זוֹ בְּאוֹתָהּ רָמָה.",
            definitionNative = "Объединение клубов, играющих между собой по сетке турнира одного уровня.",
            example = "הַקְּבוּצָה עָלְתָה לַלִּיגָה הָעֶלְיוֹנָה הַשָּׁנָה.",
            exampleNative = "Команда вышла в высшую לִיגָה в этом году."
        ),
        WordEntity(
            id = 149014, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_event", transliteration = "алипут",
            original = "אַלִּיפוּת", translation = "чемпионат",
            definition = "תַּחֲרוּת גְּדוֹלָה שֶׁבָּהּ קְבוּצוֹת אוֹ סְפּוֹרְטָאִים נִלְחָמִים עַל הַתֹּאַר הָרִאשׁוֹן.",
            definitionNative = "Крупный турнир, где команды или атлеты борются за главный титул.",
            example = "הִיא זָכְתָה בְּאַלִּיפוּת בְּיַלְדוּתָהּ.",
            exampleNative = "Она победила в אַלִּיפוּת ещё в детстве."
        , fillInBlankExclusions = listOf(149012L, 149013L, 149015L, 149020L, 149022L, 149023L, 149024L, 149025L)),
        WordEntity(
            id = 149015, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_outcome", transliteration = "прас",
            original = "פְּרָס", translation = "приз, награда",
            definition = "מַתָּנָה רִשְׁמִית כְּסֵפֶל אוֹ כֶּסֶף לַזּוֹכִים בְּתַחֲרוּת.",
            definitionNative = "Кубок, медаль или денежная сумма, которую вручают победителю турнира.",
            example = "הוּא קִבֵּל פְּרָס יָקָר עַל מָקוֹם רִאשׁוֹן.",
            exampleNative = "Он получил большой פְּרָס за первое место."
        , fillInBlankExclusions = listOf(149011L, 149016L, 149017L, 149018L, 149019L, 149020L, 149021L)),
        WordEntity(
            id = 149016, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_outcome", transliteration = "шийа",
            original = "שִׁיָּא", translation = "рекорд",
            definition = "תּוֹצָאָה הֲכִי טוֹבָה שֶׁהוּשְׂגָה אֵי פַּעַם בְּסוּג סְפּוֹרְט מְסֻיָּם.",
            definitionNative = "Лучший показатель за всю историю в данном виде спорта или дисциплине.",
            example = "הָאַתְלֵט שָׁבַר אֶת הַשִּׁיָּא הַיִּשְׂרְאֵלִי.",
            exampleNative = "Атлет побил израильский שִׁיָּא."
        ),
        WordEntity(
            id = 149017, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_outcome", transliteration = "тоцаа",
            original = "תּוֹצָאָה", translation = "результат (счёт)",
            definition = "הַסְּפֹרֶת הַסּוֹפִית שֶׁל הַמִּשְׂחָק, בְּמִסְפָּרִים שְׁתֵּי הַקְּבוּצוֹת.",
            definitionNative = "Итоговый счёт матча в цифрах между двумя соперниками после финального свистка.",
            example = "הַתּוֹצָאָה הָיְתָה שָׁלוֹשׁ-שְׁנַיִם לְטוֹבָתֵנוּ.",
            exampleNative = "תּוֹצָאָה матча — три-два в нашу пользу."
        , fillInBlankExclusions = listOf(149011L, 149015L, 149016L, 149018L, 149019L, 149020L, 149021L)),
        WordEntity(
            id = 149018, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_outcome", transliteration = "шаар",
            original = "שַׁעַר", translation = "гол, ворота",
            definition = "מִסְגֶּרֶת בַּמִּגְרָשׁ שֶׁאֵלֶיהָ מַכְנִיסִים אֶת הַכַּדּוּר וְהַנְּקֻדָּה שֶׁמַּתְקַבֶּלֶת.",
            definitionNative = "Рамка на поле, куда забивают мяч в футболе; также само очко за такое попадание.",
            example = "הוּא הִכְנִיס שַׁעַר יָפֶה בַּדַּקָּה הָאַחֲרוֹנָה.",
            exampleNative = "Он забил красивый שַׁעַר на последней минуте."
        , fillInBlankExclusions = listOf(149011L, 149015L, 149016L, 149017L, 149019L, 149020L, 149021L)),
        WordEntity(
            id = 149019, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_outcome", transliteration = "кэшалон",
            original = "כְּשָׁלוֹן", translation = "поражение",
            definition = "סִיּוּם מִשְׂחָק עִם פָּחוֹת נְקֻדּוֹת מִן הַיָּרִיב, הֶפֶךְ מִנִּצָּחוֹן.",
            definitionNative = "Окончание игры с меньшим счётом, чем у соперника; противоположность победе.",
            example = "הַכְּשָׁלוֹן בַּגָּמַר הָיָה כּוֹאֵב לְכֻלָּנוּ.",
            exampleNative = "כְּשָׁלוֹן в финале был болезненным для всех."
        , fillInBlankExclusions = listOf(149011L, 149015L, 149016L, 149017L, 149018L, 149020L, 149021L)),
        WordEntity(
            id = 149020, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_outcome", transliteration = "ницахон",
            original = "נִצָּחוֹן", translation = "победа",
            definition = "סִיּוּם תַּחֲרוּת עִם תּוֹצָאָה טוֹבָה יוֹתֵר מִן הַיָּרִיב.",
            definitionNative = "Успешное окончание матча с лучшим счётом, чем у соперника.",
            example = "הַנִּצָּחוֹן הָיָה חָשׁוּב לַקְּבוּצָה הַצְּעִירָה.",
            exampleNative = "נִצָּחוֹן был очень важен для молодой команды."
        ),
        WordEntity(
            id = 149021, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_outcome", transliteration = "тэку",
            original = "תֵּקוּ", translation = "ничья",
            definition = "סִיּוּם מִשְׂחָק שֶׁבּוֹ שְׁתֵּי הַקְּבוּצוֹת מַשִּׂיגוֹת אוֹתָהּ סְפֹרֶת.",
            definitionNative = "Итог матча с равным счётом обоих соперников; никто не выиграл.",
            example = "הַמִּשְׂחָק הִסְתַּיֵּם בְּתֵּקוּ אֶחָד-אֶחָד.",
            exampleNative = "Матч закончился תֵּקוּ один-один."
        ),
        WordEntity(
            id = 149022, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_event", transliteration = "рив'эй гамар",
            original = "רִבְעֵי גָּמַר", translation = "четвертьфинал",
            definition = "שָׁלָב בַּתַּחֲרוּת עִם שְׁמוֹנֶה קְבוּצוֹת לִפְנֵי חֲצִי הַסּוֹף.",
            definitionNative = "Стадия плей-офф с восемью участниками перед полуфиналом.",
            example = "הַקְּבוּצָה עָבְרָה לְרִבְעֵי גָּמַר אַחֲרֵי שְׁלֹשָׁה נִצְחוֹנוֹת.",
            exampleNative = "Команда вышла в רִבְעֵי גָּמַר после трёх побед."
        , fillInBlankExclusions = listOf(149012L, 149013L, 149014L, 149023L, 149024L, 149025L)),
        WordEntity(
            id = 149023, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_event", transliteration = "гамар",
            original = "גָּמַר", translation = "финал",
            definition = "הַמִּשְׂחָק הָאַחֲרוֹן בַּתַּחֲרוּת בֵּין שְׁתֵּי הַקְּבוּצוֹת הַטּוֹבוֹת בְּיוֹתֵר.",
            definitionNative = "Решающий матч турнира между двумя сильнейшими участниками за главный титул.",
            example = "הַגָּמַר יִתְקַיֵּם בַּשַּׁבָּת בְּשָׁעָה תֵּשַׁע.",
            exampleNative = "גָּמַר состоится в субботу в девять вечера."
        , fillInBlankExclusions = listOf(149012L, 149013L, 149014L, 149022L, 149024L, 149025L)),
        WordEntity(
            id = 149024, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_event", transliteration = "мундиаль",
            original = "מוּנְדִיאָל", translation = "чемпионат мира по футболу",
            definition = "תַּחֲרוּת בֵּין-לְאֻמִּית גְּדוֹלָה שֶׁל קְבוּצוֹת לְאֻמִּיוֹת אַחַת לְאַרְבַּע שָׁנִים.",
            definitionNative = "Главный международный футбольный турнир между сборными разных стран раз в четыре года.",
            example = "כֻּלָּם צָפוּ בַּמּוּנְדִיאָל בַּקֵּיץ.",
            exampleNative = "Все смотрели מוּנְדִיאָל летом."
        ),
        WordEntity(
            id = 149025, setId = 1490, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "sport_event", transliteration = "эт hафсака",
            original = "עֵת הַפְסָקָה", translation = "перерыв (тайм)",
            definition = "זְמַן מְנוּחָה קָצָר בְּאֶמְצַע הַמִּשְׂחָק לִשְׁתִיָּה וּלְהוֹרָאוֹת הַמְּאַמֵּן.",
            definitionNative = "Короткая пауза в середине игры для воды, отдыха и указаний от тренера.",
            example = "בְּעֵת הַפְסָקָה הַמְּאַמֵּן דִּבֵּר עִם הַשַּׂחְקָנִים.",
            exampleNative = "Во время עֵת הַפְסָקָה тренер говорил с игроками."
        , fillInBlankExclusions = listOf(149012L, 149013L, 149014L, 149022L, 149023L, 149024L)),

        // ══════════════════════════════════════════════════════════════════════
        // СПОРТ: ОСНОВЫ 4 — set 1491 (фитнес и тренажёрный зал, COMMON),
        // ══════════════════════════════════════════════════════════════════════

        // ══════════════════════════════════════════════════════════════════════
        // СПОРТ: ОСНОВЫ 5 — set 1492 (активный отдых и природа, COMMON),
        // ══════════════════════════════════════════════════════════════════════
    )
}
