package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Мобильная разработка", уровень 4 (профессиональный).
 *
 * Set 1770: «Мобильная разработка» — профессиональный L4 (EPIC + LEGENDARY).
 * Узкоспециальная лексика мобильной разработки: производительность,
 * дистрибуция через сторы, фичи устройства, offline-стратегии и продвинутые
 * нативные интеграции.
 *
 * Целевая аудитория — русскоязычные репатрианты в Израиле, работающие
 * мобильными разработчиками (iOS, Android, кроссплатформа) в израильских
 * стартапах. Лексика двуязычная: иврит + множество английских заимствований
 * (אֵיי-אֶס-אוֹ, טֶסְטפְלַייט, פְּלֵיי קוֹנְסוֹל, פּוּשׁ נוֹטִיפִיקַצְיָה,
 * דִּיפּ לִינְק, אוֹפְלַיין-פֶירְסְט, בְּרִידְג') — так реально говорят на
 * митингах в мобильных командах.
 *
 * Распределение редкостей:
 *   13 EPIC + 12 LEGENDARY (без выхода за 2 смежных уровня).
 *
 * SemanticGroups (5 × 5):
 *   mobile_perf          — app launch time, frame rate, memory profiling, battery consumption, network optimization
 *   mobile_distribution  — ASO, beta testing, TestFlight, Play Console, staged rollout mobile
 *   mobile_features      — push notification, deep link, in-app purchase, biometric auth, geolocation
 *   mobile_data          — offline-first, local cache, sync, conflict resolution, encrypted storage
 *   mobile_advanced      — native module, FFI, bridge, plugin architecture, security hardening
 *
 * Word IDs: setId × 100 + position (177001..177025).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewMobileL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1770, languagePair = "he-ru", orderIndex = 1770,
            name = "Мобильная разработка",
            description = "Продвинутый: производительность, дистрибуция, фичи устройства, offline",
            topic = "Мобильная разработка", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1770 — Мобильная разработка: профессиональный (L4, EPIC + LEGENDARY)
        // 5 групп × 5 слов: perf, distribution, features, data, advanced
        // ══════════════════════════════════════════════════════════════════════

        // ── mobile_perf (5) — производительность мобильного приложения ──
        WordEntity(
            id = 177001, setId = 1770, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_perf", transliteration = "zman itkhul",
            original = "זְמַן אִתְחוּל", translation = "app launch time",
            definition = "מִסְפַּר הַשְּׁנִיּוֹת בֵּין נְקִישָׁה עַל הָאַיְקוֹן עַד שֶׁהַמָּסָךְ הָרִאשׁוֹן זָמִין לִשְׁמוּשׁ.",
            definitionNative = "Сколько секунд от тапа по иконке до момента, когда первый экран готов к работе.",
            example = "זְמַן אִתְחוּל יָרַד מִשָּׁלוֹשׁ שְׁנִיּוֹת לִשְׁנִיָּה אַחַת אַחֲרֵי אוֹפְּטִימִיזַצְיָה.",
            exampleNative = "זְמַן אִתְחוּל упал с трёх секунд до одной после оптимизации.",
         fillInBlankExclusions = listOf(177002L, 177003L, 177004L, 177005L)),
        WordEntity(
            id = 177002, setId = 1770, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_perf", transliteration = "freym reyt",
            original = "פְרֵיים רֵייט", translation = "частота кадров (frame rate)",
            definition = "כַּמָּה תְּמוּנוֹת לִשְׁנִיָּה הַמָּסָךְ מְצַיֵּר — כְּדֵי שֶׁגְּלִילָה תֵּרָאֶה חֲלָקָה.",
            definitionNative = "Сколько изображений в секунду рисует экран — чтобы прокрутка выглядела гладкой.",
            example = "פְרֵיים רֵייט נָפַל לִשְׁלוֹשִׁים בִּגְלִילַת רְשִׁימָה אֲרֻכָּה.",
            exampleNative = "פְרֵיים רֵייט упал до тридцати при прокрутке длинного списка.",
         fillInBlankExclusions = listOf(177001L, 177003L, 177004L, 177005L)),
        WordEntity(
            id = 177003, setId = 1770, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_perf", transliteration = "profayling zikaron",
            original = "פְּרוֹפַיילִינְג זִכָּרוֹן", translation = "memory profiling",
            definition = "מְעַקָּב אַחַר תַּהֲלִיכִים בָּרַם כְּדֵי לִמְצֹא דְּלִיפוֹת וּמַבְנִים שֶׁתּוֹפְסִים יוֹתֵר מִדַּי.",
            definitionNative = "Слежение за процессами в RAM — чтобы найти утечки и объекты, что занимают слишком много.",
            example = "פְּרוֹפַיילִינְג זִכָּרוֹן בָּאַנְדְּרוֹאִיד סְטוּדִיוֹ חָשַׂף דְּלִיפָה בְּמָסַךְ הַתְּמוּנוֹת.",
            exampleNative = "פְּרוֹפַיילִינְג זִכָּרוֹן в Android Studio выявил утечку на экране галереи.",
         fillInBlankExclusions = listOf(177001L, 177002L, 177004L, 177005L)),
        WordEntity(
            id = 177004, setId = 1770, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_perf", transliteration = "tsrikhat solela",
            original = "צְרִיכַת סוֹלְלָה", translation = "расход батареи",
            definition = "כַּמָּה אֶנֶרְגִּיָה הָאַפְּלִיקַצְיָה לוֹקַחַת בְּרֶקַע וּבָחֲזִית בְּמַהֲלָךְ שָׁעוֹת שִׁמּוּשׁ.",
            definitionNative = "Сколько энергии приложение берёт в фоне и переднем плане за часы использования.",
            example = "צְרִיכַת סוֹלְלָה גְּבוֹהָה בָּרֶקַע סִמְּנָה לְאִיתּוּר מִיקּוּם תָּכוּף מִדַּי.",
            exampleNative = "צְרִיכַת סוֹלְלָה высокая в фоне — указала на слишком частое определение позиции.",
         fillInBlankExclusions = listOf(177001L, 177002L, 177003L, 177005L)),
        WordEntity(
            id = 177005, setId = 1770, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_perf", transliteration = "optimizatsyat reshet",
            original = "אוֹפְּטִימִיזַצְיַת רֶשֶׁת", translation = "оптимизация сети",
            definition = "צִמְצוּם בַּקָּשׁוֹת וּכְמוּת בַּיְטִים שֶׁעוֹבְרִים בֵּין הַמַּכְשִׁיר לַשֶּׁרֶת.",
            definitionNative = "Сокращение запросов и количества байт между устройством и сервером.",
            example = "אוֹפְּטִימִיזַצְיַת רֶשֶׁת חָסְכָה לָנוּ שְׁלוֹשִׁים אָחוּז מֵהַתַּעֲבוּרָה.",
            exampleNative = "אוֹפְּטִימִיזַצְיַת רֶשֶׁת сэкономила нам тридцать процентов трафика.",
         fillInBlankExclusions = listOf(177001L, 177002L, 177003L, 177004L)),

        // ── mobile_distribution (5) — выпуск приложения в сторах ──
        WordEntity(
            id = 177006, setId = 1770, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_distribution", transliteration = "ei-es-o",
            original = "אֵיי-אֶס-אוֹ", translation = "ASO (app store optimization)",
            definition = "שִׁפּוּר כּוֹתֶרֶת, תִּיאוּר וּמִילּוֹת מַפְתֵּחַ בַּחֲנוּת כְּדֵי לְהוֹפִיעַ גָּבוֹהַּ בַּחִפּוּשׂ.",
            definitionNative = "Улучшение заголовка, описания и ключевых слов в сторе — чтобы выходить выше в поиске.",
            example = "אֵיי-אֶס-אוֹ הִקְפִּיץ אֶת הַהוֹרָדוֹת בְּעֶשְׂרִים אָחוּז בְּחֹדֶשׁ.",
            exampleNative = "אֵיי-אֶס-אוֹ поднял загрузки на двадцать процентов за месяц.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177007, setId = 1770, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_distribution", transliteration = "beta testing",
            original = "בֵּיתָא טֶסְטִינְג", translation = "бета-тестирование",
            definition = "שְׁלָב בּוֹ קְבוּצַת מִשְׁתַּמְּשִׁים מְצֻמְצֶמֶת מְקַבֶּלֶת גִּרְסָה מֻקְדֶּמֶת לְאִתּוּר בָּגִים.",
            definitionNative = "Этап, на котором узкая группа получает раннюю версию — чтобы ловить баги.",
            example = "בֵּיתָא טֶסְטִינְג חָשַׂף קְרִיסָה רְצִינִית בְּמָסַךְ הַתַּשְׁלוּם.",
            exampleNative = "בֵּיתָא טֶסְטִינְג выявил серьёзный краш на экране оплаты.",
         fillInBlankExclusions = listOf(177006L, 177008L, 177009L, 177010L)),
        WordEntity(
            id = 177008, setId = 1770, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_distribution", transliteration = "testflait",
            original = "טֶסְטפְלַייט", translation = "TestFlight",
            definition = "פְּלַטְפוֹרְמָה שֶׁל אֵפֶּל לְהֲפָצַת גִּרְסָאוֹת נִסָּיוֹן לְבוֹדְקִים פְּנִימִיִּים וְחִיצוֹנִיִּים.",
            definitionNative = "Платформа Apple — раздаёт пробные версии внутренним и внешним тестировщикам.",
            example = "טֶסְטפְלַייט שָׁלַח הַזְמָנוֹת לְמֵאָה בּוֹדְקִים בִּמְדִינוֹת שׁוֹנוֹת.",
            exampleNative = "טֶסְטפְלַייט разослал приглашения сотне тестировщиков в разных странах.",
         fillInBlankExclusions = listOf(177006L, 177007L, 177009L, 177010L)),
        WordEntity(
            id = 177009, setId = 1770, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_distribution", transliteration = "pley konsol",
            original = "פְּלֵיי קוֹנְסוֹל", translation = "Play Console",
            definition = "מָסָךְ שֶׁל גוּגְל לְנִהוּל הָעֲלָאוֹת, סְטָטִיסְטִיקוֹת וּמְשׁוּבֵי מִשְׁתַּמְּשִׁים שֶׁל אַנְדְּרוֹאִיד.",
            definitionNative = "Панель Google — управляет публикациями, статистикой и отзывами для Android.",
            example = "פְּלֵיי קוֹנְסוֹל הִצִּיג יְרִידָה בְּדֵירוּג אַחֲרֵי הָעִדְכּוּן הָאַחֲרוֹן.",
            exampleNative = "פְּלֵיי קוֹנְסוֹל показал падение рейтинга после последнего обновления.",
         fillInBlankExclusions = listOf(177006L, 177007L, 177008L, 177010L)),
        WordEntity(
            id = 177010, setId = 1770, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_distribution", transliteration = "steyjed rolaut movayl",
            original = "סְטֵייגֵּ'ד רוֹלאַאוּט מוֹבַייל", translation = "поэтапный выпуск (mobile)",
            definition = "הַחְשָׂפַת גִּרְסָה חֲדָשָׁה רַק לְאָחוּז קָטָן מֵהַמַּתְקִינִים, וּמְגַדִּילִים אוֹתוֹ בְּהַדְרָגָה.",
            definitionNative = "Раздача новой версии лишь маленькой доле скачавших — постепенно увеличивая охват.",
            example = "סְטֵייגֵּ'ד רוֹלאַאוּט מוֹבַייל הִתְחִיל מֵחָמֵשׁ אָחוּז וְעָלָה בְּכָל יוֹם.",
            exampleNative = "סְטֵייגֵּ'ד רוֹלאַאוּט מוֹבַייל начался с пяти процентов и рос каждый день.",
         fillInBlankExclusions = listOf(177006L, 177007L, 177008L, 177009L)),

        // ── mobile_features (5) — фичи устройства и пользовательского опыта ──
        WordEntity(
            id = 177011, setId = 1770, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_features", transliteration = "push notifikatsya",
            original = "פּוּשׁ נוֹטִיפִיקַצְיָה", translation = "push-уведомление",
            definition = "הוֹדָעָה קְצָרָה שֶׁמִּגִּיעָה לְמַסַּךְ הַנְּעִילָה גַּם כְּשֶׁהָאַפְּלִיקַצְיָה סְגוּרָה.",
            definitionNative = "Короткое сообщение, что приходит на экран блокировки даже когда приложение закрыто.",
            example = "פּוּשׁ נוֹטִיפִיקַצְיָה הֵעִיר אוֹתִי בְּשָׁלוֹשׁ בַּלַּיְלָה עַל הוֹרָדַת מְחִיר.",
            exampleNative = "פּוּשׁ נוֹטִיפִיקַצְיָה разбудил меня в три ночи — про снижение цены.",
         fillInBlankExclusions = listOf(177012L, 177013L, 177014L, 177015L)),
        WordEntity(
            id = 177012, setId = 1770, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_features", transliteration = "dip link",
            original = "דִּיפּ לִינְק", translation = "deep link",
            definition = "כְּתֹבֶת שֶׁלְּחִיצָה עָלֶיהָ פּוֹתַחַת מָסָךְ סְפֵצִיפִי בְּתוֹךְ הָאַפְּלִיקַצְיָה, לֹא אֶת הַדַּף הָרָאשִׁי.",
            definitionNative = "Адрес — нажатие открывает конкретный экран внутри приложения, а не главную страницу.",
            example = "דִּיפּ לִינְק מֵהַדּוֹאַר הֵבִיא אוֹתִי יָשִׁיר לַעֲגָלַת הַקְּנִיּוֹת.",
            exampleNative = "דִּיפּ לִינְק из письма привёл меня прямо в корзину.",
         fillInBlankExclusions = listOf(177011L, 177013L, 177014L, 177015L)),
        WordEntity(
            id = 177013, setId = 1770, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_features", transliteration = "rkhisha betokh ha-aplikatsya",
            original = "רְכִישָׁה בְּתוֹךְ הָאַפְּלִיקַצְיָה", translation = "in-app purchase",
            definition = "תַּשְׁלוּם עֲבוּר תֹּכֶן אוֹ יְכֹלֶת נוֹסֶפֶת מִבְּלִי לָצֵאת מֵהַמַּסָּךְ שֶׁל הַשֵּׁרוּת.",
            definitionNative = "Оплата за контент или дополнительную возможность — не выходя с экрана сервиса.",
            example = "רְכִישָׁה בְּתוֹךְ הָאַפְּלִיקַצְיָה פָּתְחָה לִי גִּשָּׁה לְשִׁעוּרִים מִתְקַדְּמִים.",
            exampleNative = "רְכִישָׁה בְּתוֹךְ הָאַפְּלִיקַצְיָה открыла мне доступ к продвинутым урокам.",
         fillInBlankExclusions = listOf(177011L, 177012L, 177014L, 177015L)),
        WordEntity(
            id = 177014, setId = 1770, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_features", transliteration = "imut biyometri",
            original = "אִימּוּת בִּיוֹמֵטְרִי", translation = "биометрическая аутентификация",
            definition = "כְּנִיסָה לְחֶשְׁבּוֹן בְּעֶזְרַת טְבִיעַת אֶצְבַּע אוֹ זִהוּי פָּנִים בִּמְקוֹם סִיסְמָה.",
            definitionNative = "Вход в аккаунт по отпечатку пальца или скану лица — вместо ввода пароля.",
            example = "אִימּוּת בִּיוֹמֵטְרִי הֶחְלִיף סִיסְמָאוֹת בְּכָל אַפְּלִיקַצְיוֹת הַבַּנְק.",
            exampleNative = "אִימּוּת בִּיוֹמֵטְרִי заменил пароли во всех банковских приложениях.",
         fillInBlankExclusions = listOf(177011L, 177012L, 177013L, 177015L)),
        WordEntity(
            id = 177015, setId = 1770, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_features", transliteration = "geo-lokatsya",
            original = "גֵּ'יוֹ-לוֹקַצְיָה", translation = "геолокация",
            definition = "אִיתּוּר הַמְּקוֹם שֶׁל הַמַּכְשִׁיר לְפִי לַוְיָנִים, וַויי-פַיי אוֹ אַנְטֶנוֹת סֵלוּלָרִיּוֹת.",
            definitionNative = "Определение положения устройства — по спутникам, Wi-Fi или сотовым вышкам.",
            example = "גֵּ'יוֹ-לוֹקַצְיָה לֹא עָבְדָה טוֹב בִּפְנִים הַקַּנְיוֹן בִּגְלַל קִירוֹת בֵּטוֹן.",
            exampleNative = "גֵּ'יוֹ-לוֹקַצְיָה плохо работала внутри ТЦ из-за бетонных стен.",
         fillInBlankExclusions = listOf(177011L, 177012L, 177013L, 177014L)),

        // ── mobile_data (5) — данные, синхронизация и оффлайн ──
        WordEntity(
            id = 177016, setId = 1770, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_data", transliteration = "oflain-feirst",
            original = "אוֹפְלַיין-פֶירְסְט", translation = "offline-first",
            definition = "גִּישָׁה שֶׁבָּהּ הָאַפְּלִיקַצְיָה עוֹבֶדֶת בְּלִי אִינְטֶרְנֶט וּמַעֲלָה שִׁנּוּיִים כְּשֶׁחָזַר חִבּוּר.",
            definitionNative = "Подход: приложение работает без интернета, а изменения уходят на сервер при возврате связи.",
            example = "אוֹפְלַיין-פֶירְסְט מַתְאִים לְאַפְּלִיקַצְיוֹת שֶׁל אֲנָשִׁים בְּטִיסוֹת אוֹ בְּהָרִים.",
            exampleNative = "אוֹפְלַיין-פֶירְסְט подходит для приложений, где люди в полётах или в горах.",
         fillInBlankExclusions = listOf(177017L, 177018L, 177019L, 177020L)),
        WordEntity(
            id = 177017, setId = 1770, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_data", transliteration = "matmon mekomi",
            original = "מַטְמוֹן מְקוֹמִי", translation = "локальный кэш",
            definition = "אַחְסוּן זְמַנִּי שֶׁל נְתוּנִים עַל הַמַּכְשִׁיר כְּדֵי לֹא לְהוֹרִיד אֶת אוֹתוֹ דָּבָר שׁוּב.",
            definitionNative = "Временное хранение данных на устройстве — чтобы не качать одно и то же повторно.",
            example = "מַטְמוֹן מְקוֹמִי שֶׁל תְּמוּנוֹת חָסַךְ לִי הֲמוֹן תַּעֲבוּרָה בְּטִיסוֹת.",
            exampleNative = "מַטְמוֹן מְקוֹמִי для картинок сэкономил мне кучу трафика в полётах.",
         fillInBlankExclusions = listOf(177016L, 177018L, 177019L, 177020L)),
        WordEntity(
            id = 177018, setId = 1770, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_data", transliteration = "sinkhrun netunim",
            original = "סִינְכְּרוּן נְתוּנִים", translation = "синхронизация данных",
            definition = "הַשְׁוָאָה אוֹטוֹמָטִית בֵּין הַמַּכְשִׁיר לַעֲנָן כְּדֵי שֶׁשְּׁנֵיהֶם יַחֲזִיקוּ אוֹתוֹ מֵידָע.",
            definitionNative = "Автоматическая сверка между устройством и облаком — чтобы у обоих был один и тот же массив.",
            example = "סִינְכְּרוּן נְתוּנִים בָּרֶקַע לֹא הוּשְׁלַם בִּגְלַל וַויי-פַיי חַלָּשׁ.",
            exampleNative = "סִינְכְּרוּן נְתוּנִים в фоне не завершился — слабый Wi-Fi.",
         fillInBlankExclusions = listOf(177016L, 177017L, 177019L, 177020L)),
        WordEntity(
            id = 177019, setId = 1770, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_data", transliteration = "ptirat konfliktim",
            original = "פְּתִירַת קוֹנְפְלִיקְטִים", translation = "разрешение конфликтов",
            definition = "כְּלָל שֶׁמַּחְלִיט אֵיזוֹ גִּרְסָה מְנַצַּחַת כְּשֶׁשְּׁנֵי מַכְשִׁירִים שִׁנּוּ אוֹתוֹ רְשׁוּמָה.",
            definitionNative = "Правило, какая версия побеждает — когда два устройства поменяли одну и ту же запись.",
            example = "פְּתִירַת קוֹנְפְלִיקְטִים בְּחָרְה תָּמִיד אֶת הָעִדְכּוּן הָאַחֲרוֹן בִּזְמַן.",
            exampleNative = "פְּתִירַת קוֹנְפְלִיקְטִים всегда выбирала самое позднее по времени обновление.",
         fillInBlankExclusions = listOf(177016L, 177017L, 177018L, 177020L)),
        WordEntity(
            id = 177020, setId = 1770, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_data", transliteration = "akhsun mutspan",
            original = "אַחְסוּן מוּצְפָּן", translation = "зашифрованное хранилище",
            definition = "מָקוֹם עַל הַמַּכְשִׁיר שֶׁבּוֹ הַקְּבָצִים נִשְׁמָרִים בְּצֹפֶן וְלֹא נִקְרָאִים בְּלִי מַפְתֵּחַ.",
            definitionNative = "Место на устройстве — файлы лежат в шифре и не читаются без ключа.",
            example = "אַחְסוּן מוּצְפָּן הָגֵן עַל הַמֵּידָע גַּם אַחֲרֵי גְּנֵבַת הַטֵּלֵפוֹן.",
            exampleNative = "אַחְסוּן מוּצְפָּן защитил данные даже после кражи телефона.",
         fillInBlankExclusions = listOf(177016L, 177017L, 177018L, 177019L)),

        // ── mobile_advanced (5) — продвинутые нативные интеграции ──
        WordEntity(
            id = 177021, setId = 1770, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_advanced", transliteration = "modul neytiv",
            original = "מוֹדּוּל נֵייטִיב", translation = "нативный модуль",
            definition = "חֲתִיכַת קוֹד שֶׁנִּכְתֶּבֶת בִּשְׂפַת הַמַּעֲרֶכֶת וְנִקְרֵאת מִתּוֹךְ פְּרֵיימְוֶורְק קְרוֹס-פְּלַטְפוֹרְמִי.",
            definitionNative = "Кусок кода на языке системы — вызывается из кроссплатформенного фреймворка.",
            example = "מוֹדּוּל נֵייטִיב לִקְרִיאַת מַד-צַעַד נִכְתַּב בְּקוֹטְלִין בִּשְׁבִיל אַנְדְּרוֹאִיד.",
            exampleNative = "מוֹדּוּל נֵייטִיב для чтения шагомера написали на Kotlin под Android.",
         fillInBlankExclusions = listOf(177022L, 177023L, 177024L, 177025L)),
        WordEntity(
            id = 177022, setId = 1770, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_advanced", transliteration = "ef-ef-ai",
            original = "אֶף-אֶף-אַיי", translation = "FFI (foreign function interface)",
            definition = "מַנְגָנוֹן שֶׁמְּאַפְשֵׁר לְקוֹד בִּשְׂפָה אַחַת לִקְרֹא פוּנְקְצְיוֹת מִסִּפְרִיָּה כְּתוּבָה בִּשְׂפָה אַחֶרֶת.",
            definitionNative = "Механизм — код на одном языке зовёт функции из библиотеки на другом языке.",
            example = "אֶף-אֶף-אַיי בְּפְלַטֶר חִבֵּר לָנוּ סִפְרִיַּת רוּסְט לְקוֹד דַּארְט.",
            exampleNative = "אֶף-אֶף-אַיי во Flutter подключил нам Rust-библиотеку к Dart-коду.",
         fillInBlankExclusions = listOf(177021L, 177023L, 177024L, 177025L)),
        WordEntity(
            id = 177023, setId = 1770, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_advanced", transliteration = "bridj",
            original = "בְּרִידְג'", translation = "bridge (мост между средами)",
            definition = "שִׁכְבַת תִּקְשׁוֹרֶת בֵּין מָנוֹעַ הַ-JS לַחֵלֶק הַנֵּייטִיב, שֶׁמַּעֲבִירָה הוֹדָעוֹת בִּשְׁתֵּי הַכִּוּוּנִים.",
            definitionNative = "Слой связи между JS-движком и нативной частью — передаёт сообщения в обе стороны.",
            example = "בְּרִידְג' בְּרֵייאַקְט נֵייטִיב הָיָה צַוַּאר בַּקְבּוּק בִּגְלִילוֹת אֲרֻכּוֹת.",
            exampleNative = "בְּרִידְג' в React Native стал бутылочным горлышком при длинных списках.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 177024, setId = 1770, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_advanced", transliteration = "arkhitekturat tosafim",
            original = "אַרְכִיטֶקְטוּרַת תּוֹסָפִים", translation = "архитектура плагинов",
            definition = "מִבְנֵה קוֹד שֶׁמְּאַפְשֵׁר לְהוֹסִיף יְכוֹלוֹת בְּלִי לִגַּעַת בַּלֵּב שֶׁל הָאַפְּלִיקַצְיָה.",
            definitionNative = "Структура кода — добавлять новые возможности, не трогая ядро приложения.",
            example = "אַרְכִיטֶקְטוּרַת תּוֹסָפִים אִפְשְׁרָה לִשְׁלוֹשָׁה צְוָתִים לְפַתֵּחַ בְּמַקְבִּיל.",
            exampleNative = "אַרְכִיטֶקְטוּרַת תּוֹסָפִים позволила трём командам разрабатывать параллельно.",
         fillInBlankExclusions = listOf(177021L, 177022L, 177023L, 177025L)),
        WordEntity(
            id = 177025, setId = 1770, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_advanced", transliteration = "hakshakhat avtakha",
            original = "הַקְשָׁחַת אַבְטָחָה", translation = "усиление защиты (security hardening)",
            definition = "סְדְרַת שִׁפּוּרִים שֶׁמְּקַשִּׁים עַל תּוֹקֵף לִשְׁלֹף קוֹד אוֹ מֵידָע מֵהַחֲבִילָה הַסּוֹפִית.",
            definitionNative = "Серия улучшений — затрудняют взломщику вытащить код или данные из готового бандла.",
            example = "הַקְשָׁחַת אַבְטָחָה כָּלְלָה אוֹבְפוּסְקַצְיָה וְזִהוּי שׁוֹרֵשׁ בַּמַּכְשִׁיר.",
            exampleNative = "הַקְשָׁחַת אַבְטָחָה включала обфускацию и проверку рута на устройстве.",
         fillInBlankExclusions = listOf(177021L, 177022L, 177023L, 177024L)),
    )
}
