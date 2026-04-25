package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary: Electrician, level 1 (1 set, 25 words).
 * Базовая лексика начинающего электрика: ручные инструменты, освещение,
 * простые операции, безопасность и типичные мелкие проблемы.
 *
 * Set 1726 (level 1, COMMON + UNCOMMON) — заполняет уровень 1 в теме «Электрик»
 * рядом с уже существующими наборами уровней 2-5 (1398, 1399, 1400, 1401,
 * 1402, 1558). Слова не пересекаются с этими наборами.
 *
 * Тема «Электрик» граничит с темами «Дом и быт», «Технологии» и «Инженер»
 * (ручной инструмент, лампы, бытовые провода) — пересечения там разрешены
 * политикой дублей (см. CLAUDE.md / feedback_duplicate_words_policy.md).
 *
 * Распределение редкостей: 15 COMMON + 10 UNCOMMON (2 смежных уровня).
 *
 * Пять подгрупп по 5 слов каждая:
 *   electrician_tools    — ручные инструменты
 *   electrician_lighting — лампы, удлинители, выключатели
 *   electrician_actions  — простые операции
 *   electrician_safety   — средства защиты
 *   electrician_problems — типичные мелкие проблемы
 */
object WordDataHebrewElectricianL1 {

    val sets = listOf(
        WordSetEntity(
            id = 1726, languagePair = "he-ru", orderIndex = 1726,
            name = "Электрик",
            description = "Базовые инструменты, лампы, провода, простые операции",
            topic = "Электрик", level = 1,
        ),
    )

    val words = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1726 — Электрик: основы (COMMON + UNCOMMON, A1–A2)
        // 5 групп × 5 слов
        // ══════════════════════════════════════════════════════════════════════

        // ── electrician_tools (5) — ручные инструменты ──
        WordEntity(
            id = 172601, setId = 1726, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "electrician_tools", transliteration = "mavreg",
            original = "מַבְרֵג", translation = "отвёртка",
            definition = "כְּלִי יָד עִם יָדִית וּקְצֶה דַּק לִסְגוֹר וּפְתוֹחַ בּוֹרְגִים.",
            definitionNative = "Ручной инструмент с ручкой и тонким концом, чтобы крутить шурупы.",
            example = "הַמַּבְרֵג הַקָּטָן נָפַל לוֹ מִתּוֹךְ הַכִּיס.",
            exampleNative = "מַבְרֵג маленький выпал у него из кармана.",
            isFillInBlankSafe = true),
        WordEntity(
            id = 172602, setId = 1726, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "electrician_tools", transliteration = "patish",
            original = "פַּטִּישׁ", translation = "молоток",
            definition = "כְּלִי כָּבֵד עִם רֹאשׁ מַתֶּכֶת לְהַכּוֹת בְּמַסְמְרִים אוֹ קִירוֹת.",
            definitionNative = "Тяжёлый инструмент с металлической головкой — забивать гвозди или дюбели.",
            example = "הַפַּטִּישׁ הַזֶּה כָּבֵד מִדַּי בִּשְׁבִיל הַיֶּלֶד.",
            exampleNative = "פַּטִּישׁ этот слишком тяжёлый для ребёнка.",
            isFillInBlankSafe = true),
        WordEntity(
            id = 172603, setId = 1726, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "electrician_tools", transliteration = "makdekha",
            original = "מַקְדֵּחָה", translation = "дрель",
            definition = "מַכְשִׁיר מִסְתּוֹבֵב שֶׁעוֹשֶׂה חוֹר בְּקִיר אוֹ בְּעֵץ.",
            definitionNative = "Вращающийся инструмент, что делает отверстие в стене или дереве.",
            example = "הַמַּקְדֵּחָה רָעֲשָׁה בְּכָל הַבִּנְיָן בַּבֹּקֶר.",
            exampleNative = "מַקְדֵּחָה шумела на весь дом с самого утра.",
            isFillInBlankSafe = true),
        WordEntity(
            id = 172604, setId = 1726, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "electrician_tools", transliteration = "malkhem",
            original = "מַלְחֵם", translation = "паяльник",
            definition = "כְּלִי חַם שֶׁמַּמֵּס בְּדִיל וּמְחַבֵּר רַגְלֵי חֲלָקִים אֶלֶקְטְרוֹנִיִּים.",
            definitionNative = "Горячий инструмент: плавит олово и склеивает выводы радиодеталей.",
            example = "הַמַּלְחֵם הִתְחַמֵּם אַחֲרֵי דַּקָּה וְהָיָה מוּכָן לְשִׁמּוּשׁ.",
            exampleNative = "מַלְחֵם нагрелся за минуту и был готов к работе.",
            isFillInBlankSafe = true),
        WordEntity(
            id = 172605, setId = 1726, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "electrician_tools", transliteration = "argaz kelim",
            original = "אַרְגַּז כֵּלִים", translation = "ящик с инструментами",
            definition = "תֵּיבָה נִישֵּׂאת שֶׁבְּתוֹכָהּ הַבַּעַל מְלָאכָה שׁוֹמֵר אֶת כָּל הַכֵּלִים.",
            definitionNative = "Переносная коробка, где мастер хранит весь свой набор приспособлений.",
            example = "אַרְגַּז כֵּלִים שֶׁלִּי תָּמִיד יוֹשֵׁב לְיַד דֶּלֶת הַכְּנִיסָה.",
            exampleNative = "אַרְגַּז כֵּלִים мой всегда стоит у входной двери.",
            isFillInBlankSafe = true),

        // ── electrician_lighting (5) — лампы, удлинители, выключатели ──
        WordEntity(
            id = 172606, setId = 1726, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "electrician_lighting", transliteration = "panas",
            original = "פָּנָס", translation = "фонарик",
            definition = "מַכְשִׁיר קָטָן עִם בָּטְרִיָּה שֶׁמֵּאִיר בַּחֹשֶׁךְ כְּשֶׁאֵין אוֹר בָּחֶדֶר.",
            definitionNative = "Маленькая штука с батарейкой — светит в темноте, когда нет света в комнате.",
            example = "אָבִי לָקַח פָּנָס וְיָרַד לִבְדוֹק אֶת הַמַּרְתֵּף.",
            exampleNative = "Папа взял פָּנָס и спустился проверить подвал.",
            isFillInBlankSafe = true),
        WordEntity(
            id = 172607, setId = 1726, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "electrician_lighting", transliteration = "nura led",
            original = "נוּרָה לֵד", translation = "светодиодная лампа",
            definition = "מָקוֹר אוֹר חָדָשׁ שֶׁצּוֹרֵךְ מְעַט אֱנֶרְגִּיָּה וְכִמְעַט לֹא מִתְחַמֵּם.",
            definitionNative = "Современный источник света — мало ест энергии и почти не греется.",
            example = "הִתְקַנּוּ נוּרָה לֵד בַּמִּטְבָּח כְּדֵי לַחֲסוֹךְ חַשְׁמַל.",
            exampleNative = "Поставили נוּרָה לֵד на кухне, чтобы экономить электричество.",
            isFillInBlankSafe = true),
        WordEntity(
            id = 172608, setId = 1726, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "electrician_lighting", transliteration = "ta batriya",
            original = "תָּא בָּטְרִיָּה", translation = "батарейный отсек",
            definition = "מָקוֹם בְּתוֹךְ מַכְשִׁיר שֶׁבּוֹ מַכְנִיסִים סוֹלְלוֹת כְּדֵי שֶׁהוּא יִפְעַל.",
            definitionNative = "Место внутри прибора, куда вставляют батарейки, чтобы он работал.",
            example = "תָּא בָּטְרִיָּה הָיָה רָטוֹב וְהַשָּׁעוֹן הִפְסִיק לַעֲבוֹד.",
            exampleNative = "תָּא בָּטְרִיָּה был мокрым, и часы перестали работать.",
            isFillInBlankSafe = true),
        WordEntity(
            id = 172609, setId = 1726, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "electrician_lighting", transliteration = "teka maarikh",
            original = "תֶּקַע מַאֲרִיךְ", translation = "удлинитель / тройник",
            definition = "פַּס עִם כַּמָּה חוֹרִים שֶׁמְּחַבֵּר מַכְשִׁירִים רְחוֹקִים לַשֶּׁקַע בַּקִּיר.",
            definitionNative = "Длинный шнур с гнёздами — подключает приборы к дальней розетке.",
            example = "תֶּקַע מַאֲרִיךְ כָּחוֹל שָׂמְנוּ מֵאֲחוֹרֵי הַסַּפָּה.",
            exampleNative = "תֶּקַע מַאֲרִיךְ синий мы спрятали за диваном.",
            isFillInBlankSafe = true),
        WordEntity(
            id = 172610, setId = 1726, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "electrician_lighting", transliteration = "matag kir",
            original = "מַתָּג קִיר", translation = "настенный выключатель",
            definition = "כַּפְתּוֹר בַּקִּיר שֶׁלּוֹחֲצִים עָלָיו כְּדֵי לִפְתֹּחַ אוֹ לִסְגֹּר אֶת הָאוֹר.",
            definitionNative = "Кнопка на стене — нажимают, чтобы зажечь или потушить освещение.",
            example = "מַתָּג קִיר נִשְׁבַּר וְעַכְשָׁו הָאוֹר דּוֹלֵק כָּל הַזְּמַן.",
            exampleNative = "מַתָּג קִיר сломался, и теперь свет горит постоянно.",
            isFillInBlankSafe = true),

        // ── electrician_actions (5) — простые операции ──
        WordEntity(
            id = 172611, setId = 1726, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "electrician_actions", transliteration = "lekhaber khutim",
            original = "לְחַבֵּר חוּטִים", translation = "соединить провода",
            definition = "לִקְשׁוֹר שְׁנֵי קְצוֹת מַתֶּכֶת יַחַד כְּדֵי שֶׁהַזֶּרֶם יַעֲבוֹר בֵּינֵיהֶם.",
            definitionNative = "Свести вместе два металлических конца, чтобы ток шёл насквозь.",
            example = "צָרִיךְ לְחַבֵּר חוּטִים בִּזְהִירוּת לִפְנֵי שֶׁמַּדְלִיקִים.",
            exampleNative = "Надо לְחַבֵּר חוּטִים аккуратно, прежде чем включать.",
            isFillInBlankSafe = true),
        WordEntity(
            id = 172612, setId = 1726, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "electrician_actions", transliteration = "lehadlik or",
            original = "לְהַדְלִיק אוֹר", translation = "включить свет",
            definition = "לִלְחֹץ עַל הַכַּפְתּוֹר כְּדֵי שֶׁהַחֶדֶר יִהְיֶה מוּאָר.",
            definitionNative = "Нажать на кнопку, чтобы в комнате стало ярко.",
            example = "אִמָּא בִּקְּשָׁה לְהַדְלִיק אוֹר בַּמִּסְדְּרוֹן בָּעֶרֶב.",
            exampleNative = "Мама попросила לְהַדְלִיק אוֹר в коридоре вечером.",
            isFillInBlankSafe = true),
        WordEntity(
            id = 172613, setId = 1726, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "electrician_actions", transliteration = "lekhabot zerem",
            original = "לְכַבּוֹת זֶרֶם", translation = "отключить ток",
            definition = "לִסְגֹּר אֶת הַזְּרִימָה הַחַשְׁמַלִּית לִפְנֵי שֶׁנּוֹגְעִים בַּחוּטִים.",
            definitionNative = "Перекрыть электрический поток, прежде чем трогать жилы руками.",
            example = "תָּמִיד צָרִיךְ לְכַבּוֹת זֶרֶם לִפְנֵי הַחְלָפַת שֶׁקַע.",
            exampleNative = "Всегда нужно לְכַבּוֹת זֶרֶם перед заменой розетки.",
            isFillInBlankSafe = true),
        WordEntity(
            id = 172614, setId = 1726, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "electrician_actions", transliteration = "limdod metakh",
            original = "לִמְדֹּד מֶתַח", translation = "измерить напряжение",
            definition = "לִבְדֹּק בְּעֶזְרַת מַכְשִׁיר אִם יֵשׁ חַשְׁמַל וּבְכַמָּה הוּא חָזָק.",
            definitionNative = "Проверить прибором, есть ли электричество и насколько оно сильное.",
            example = "צָרִיךְ לִמְדֹּד מֶתַח לִפְנֵי שֶׁמַּחְלִיפִים אֶת הָאוּטוֹמָט.",
            exampleNative = "Надо לִמְדֹּד מֶתַח, прежде чем менять автомат.",
            isFillInBlankSafe = true),
        WordEntity(
            id = 172615, setId = 1726, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "electrician_actions", transliteration = "lehakhlif nura",
            original = "לְהַחְלִיף נוּרָה", translation = "заменить лампочку",
            definition = "לְהוֹצִיא אֶת הַיְּשָׁנָה שֶׁשָּׂרְפָה וְלְהַכְנִיס חֲדָשָׁה בִּמְקוֹמָהּ.",
            definitionNative = "Достать перегоревшую старую и поставить на её место новую.",
            example = "צָרִיךְ לְהַחְלִיף נוּרָה בַּמִּסְדְּרוֹן הַיּוֹם בָּעֶרֶב.",
            exampleNative = "Надо לְהַחְלִיף נוּרָה в коридоре сегодня вечером.",
            isFillInBlankSafe = true),

        // ── electrician_safety (5) — средства защиты ──
        WordEntity(
            id = 172616, setId = 1726, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "electrician_safety", transliteration = "kfafot gumi",
            original = "כְּפָפוֹת גוּמִי", translation = "резиновые перчатки",
            definition = "כִּסּוּי לַיָּדַיִם מֵחֹמֶר רַךְ שֶׁאֵינוֹ מַעֲבִיר זֶרֶם חַשְׁמַלִּי.",
            definitionNative = "Покрытие на руки из мягкого материала, что не пропускает ток.",
            example = "אַל תִּגַּע בַּכֶּבֶל בְּלִי כְּפָפוֹת גוּמִי בַּיָּדַיִם.",
            exampleNative = "Не трогай кабель без כְּפָפוֹת גוּמִי на руках.",
            isFillInBlankSafe = true),
        WordEntity(
            id = 172617, setId = 1726, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "electrician_safety", transliteration = "sulam",
            original = "סוֹלָם", translation = "стремянка / лестница",
            definition = "כְּלִי עִם שְׁלַבֵּי עַלְיָה לְהַגִּיעַ לִמְקוֹמוֹת גְּבוֹהִים בַּתִּקְרָה אוֹ בַּקִּיר.",
            definitionNative = "Приспособление со ступенями для подъёма к высоким местам в потолке или стене.",
            example = "הַסּוֹלָם הָיָה רָעוּעַ קְצָת וְלָכֵן רַעַד תַּחְתֵּיהֶם.",
            exampleNative = "סוֹלָם был немного шаткий и потому покачнулся под ним.",
            isFillInBlankSafe = true),
        WordEntity(
            id = 172618, setId = 1726, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "electrician_safety", transliteration = "kasdat avoda",
            original = "קַסְדַּת עֲבוֹדָה", translation = "рабочая каска",
            definition = "כּוֹבַע קָשֶׁה שֶׁמֵּגֵן עַל הָרֹאשׁ מִנְּפִילַת חֲפָצִים מִלְּמַעְלָה.",
            definitionNative = "Жёсткий головной убор — спасает голову от падающих сверху предметов.",
            example = "קַסְדַּת עֲבוֹדָה צְהֻבָּה מוּנַחַת תָּמִיד עַל הַמַּדָּף.",
            exampleNative = "קַסְדַּת עֲבוֹדָה жёлтая всегда лежит на полке.",
            isFillInBlankSafe = true),
        WordEntity(
            id = 172619, setId = 1726, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "electrician_safety", transliteration = "mishkafey betikhut",
            original = "מִשְׁקְפֵי בְּטִיחוּת", translation = "защитные очки",
            definition = "מִשְׁקָפַיִם שְׁקוּפִים שֶׁשּׁוֹמְרִים עַל הָעֵינַיִם מֵרְסִיסִים אוֹ אָבָק.",
            definitionNative = "Прозрачные очки, что берегут глаза от осколков или пыли.",
            example = "תָּמִיד אֲנִי מַרְכִּיב מִשְׁקְפֵי בְּטִיחוּת בִּזְמַן הַקִּדּוּחַ.",
            exampleNative = "Я всегда надеваю מִשְׁקְפֵי בְּטִיחוּת во время сверления.",
            isFillInBlankSafe = true),
        WordEntity(
            id = 172620, setId = 1726, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "electrician_safety", transliteration = "sikun hitkhashmelut",
            original = "סִכּוּן הִתְחַשְׁמְלוּת", translation = "риск удара током",
            definition = "אֶפְשָׁרוּת שֶׁאָדָם יִפָּגַע מֵרֶזְרֶם חַזָק כְּשֶׁהוּא נוֹגֵעַ בַּחוּטִים.",
            definitionNative = "Возможность пострадать от сильного тока, если коснуться оголённых жил.",
            example = "סִכּוּן הִתְחַשְׁמְלוּת גָּדוֹל בְּמַחֲסָן רָטוֹב וּמְלֵא צִנּוֹרוֹת.",
            exampleNative = "סִכּוּן הִתְחַשְׁמְלוּת велик в сыром складе с трубами.",
            isFillInBlankSafe = true),

        // ── electrician_problems (5) — типичные мелкие проблемы ──
        WordEntity(
            id = 172621, setId = 1726, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "electrician_problems", transliteration = "tkala",
            original = "תְּקָלָה", translation = "неисправность",
            definition = "מַצָּב שֶׁבּוֹ מַכְשִׁיר אוֹ מַעֲרֶכֶת מַפְסִיקִים לַעֲבוֹד כְּמוֹ שֶׁצָּרִיךְ.",
            definitionNative = "Положение, когда прибор или система перестают работать как следует.",
            example = "הַתְּקָלָה הִתְגַּלְּתָה רַק אַחֲרֵי שָׁעוֹת שֶׁל חִפּוּשׂ.",
            exampleNative = "תְּקָלָה вылезла только после нескольких часов поиска.",
            isFillInBlankSafe = true),
        WordEntity(
            id = 172622, setId = 1726, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "electrician_problems", transliteration = "ashan",
            original = "עָשָׁן", translation = "дым",
            definition = "עֲנַן אָפֹר אוֹ שָׁחֹר שֶׁעוֹלֶה כְּשֶׁמַּשֶּׁהוּ נִשְׂרָף אוֹ מִתְחַמֵּם מִדַּי.",
            definitionNative = "Серое или чёрное облако, что поднимается, когда что-то горит или сильно греется.",
            example = "עָשָׁן יָצָא מֵהַשֶּׁקַע וְכֻלָּם נִבְהֲלוּ מִיָּד.",
            exampleNative = "עָשָׁן пошёл из розетки, и все сразу испугались.",
            isFillInBlankSafe = true),
        WordEntity(
            id = 172623, setId = 1726, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "electrician_problems", transliteration = "mekhaseh sheka",
            original = "מְכַסֶּה שֶׁקַע", translation = "заглушка розетки",
            definition = "פִּסַּת פְּלַסְטִיק שֶׁמַּכְנִיסִים לַחוֹר כְּדֵי שֶׁתִּינוֹק לֹא יַכְנִיס יָד.",
            definitionNative = "Кусочек пластика в отверстие — чтобы малыш не сунул туда пальцы.",
            example = "מְכַסֶּה שֶׁקַע יָרֹק מָנַע מֵהַתִּינוֹק לְהַגִּיעַ לַחַשְׁמַל.",
            exampleNative = "מְכַסֶּה שֶׁקַע зелёный не дал малышу добраться до тока.",
            isFillInBlankSafe = true),
        WordEntity(
            id = 172624, setId = 1726, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "electrician_problems", transliteration = "reyakh srifa",
            original = "רֵיחַ שְׂרִיפָה", translation = "запах гари",
            definition = "רֵיחַ חָרִיף שֶׁל פְּלַסְטִיק אוֹ חוּט שֶׁמִּתְחַמֵּם וּמִתְחִיל לְהִתְפַּחֵם.",
            definitionNative = "Резкий запах пластика или провода, что слишком разогрелся и тлеет.",
            example = "רֵיחַ שְׂרִיפָה הִגִּיעַ מֵהַלּוּחַ וּכִבִּינוּ הַכֹּל מִיָּד.",
            exampleNative = "רֵיחַ שְׂרִיפָה пошёл от щита, и мы сразу всё обесточили.",
            isFillInBlankSafe = true),
        WordEntity(
            id = 172625, setId = 1726, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "electrician_problems", transliteration = "omes yater",
            original = "עוֹמֶס יַתֵר", translation = "перегрузка сети",
            definition = "מַצָּב שֶׁבּוֹ יוֹתֵר מִדַּי מַכְשִׁירִים מְחֻבָּרִים וְהַחַשְׁמַל מִתְחַמֵּם.",
            definitionNative = "Случай, когда подключено слишком много приборов и проводка начинает греться.",
            example = "עוֹמֶס יַתֵר גָּרַם לַמַּפְסֵק לִקְפֹּץ כְּבָר פַּעֲמַיִם הַיּוֹם.",
            exampleNative = "עוֹמֶס יַתֵר заставил автомат сработать уже дважды за день.",
            isFillInBlankSafe = true),
    )
}
