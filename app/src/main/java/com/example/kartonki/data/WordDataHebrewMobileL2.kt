package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Мобильная разработка", L2 «Продвинутый» (UNCOMMON+RARE).
 *
 * Set 1784: «Мобильная разработка» — продвинутый L2:
 *           ежедневный быт мобильного разработчика — настройки, сети,
 *           разрешения, ресурсы, отладка.
 *
 * Целевая аудитория — русскоязычные репатрианты в Израиле, работающие
 * мобильными разработчиками. Лексика смешанная: иврит + множество английских
 * заимствований (לוֹג, סִימוּלָטוֹר, רֶזוֹלוּצְיָה, לוֹקַלִיזַצְיָה,
 * דְּרוֹאֶבֶּל, בְּרֵייקְפּוֹינְט) — так реально говорят в израильских
 * мобильных командах.
 *
 * Распределение редкостей: 13 UNCOMMON + 12 RARE.
 *
 * SemanticGroups (5 × 5):
 *   mobile_settings_basic     — настройки приложения, тёмная/светлая тема, шрифт, язык
 *   mobile_network_basic      — мобильный интернет, Wi-Fi, лимит трафика, авиарежим, точка доступа
 *   mobile_permissions_basic  — камера, микрофон, фото, геолокация, уведомления
 *   mobile_resources          — assets, drawable, string-ресурс, локализация, разрешение картинки
 *   mobile_debug_basic        — лог, консоль разработчика, breakpoint, debug-сборка, симулятор
 *
 * Word IDs: setId × 100 + position (178401..178425).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewMobileL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1784, languagePair = "he-ru", orderIndex = 1784,
            name = "Мобильная разработка",
            description = "Продвинутый базовый: настройки, сети, разрешения, ресурсы, отладка",
            topic = "Мобильная разработка", level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1784 — Мобильная разработка: продвинутый (L2, UNCOMMON+RARE)
        // 5 групп × 5 слов: settings, network, permissions, resources, debug
        // ══════════════════════════════════════════════════════════════════════

        // ── mobile_settings_basic (5) — настройки приложения ──
        WordEntity(
            id = 178401, setId = 1784, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_settings_basic", transliteration = "hagdarot aplikatsya",
            original = "הַגְדָּרוֹת אַפְּלִיקַצְיָה", translation = "настройки приложения",
            definition = "מָסָךְ פְּנִימִי שֶׁבּוֹ הַמִּשְׁתַּמֵּשׁ מַתְאִים לְעַצְמוֹ אֶת הִתְנַהֲגוּת הַתּוֹכְנָה.",
            definitionNative = "Внутренний экран — пользователь подгоняет под себя поведение программы.",
            example = "פָּתַחְתִּי הַגְדָּרוֹת אַפְּלִיקַצְיָה כְּדֵי לְהַשְׁתִּיק רַעַשׁ בְּעֵת קְרִיאוֹת.",
            exampleNative = "Я открыл הַגְדָּרוֹת אַפְּלִיקַצְיָה, чтобы заглушить шум во время звонков.",
         fillInBlankExclusions = listOf(178402L, 178403L, 178404L, 178405L)),
        WordEntity(
            id = 178402, setId = 1784, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_settings_basic", transliteration = "arket keha",
            original = "עַרְכַּת כֵּהָה", translation = "тёмная тема",
            definition = "מַעֲרֶכֶת צְבָעִים שְׁחוֹרָה אוֹ אֲפֹרָה — נוֹחָה לָעַיִן בִּקְרִיאָה בַּלַּיְלָה.",
            definitionNative = "Чёрный или серый цветовой набор — удобен глазам при чтении ночью.",
            example = "עַרְכַּת כֵּהָה חוֹסֶכֶת סוֹלְלָה בְּמַסַּכִּים מִסּוּג אוֹלֶד.",
            exampleNative = "עַרְכַּת כֵּהָה экономит батарею на OLED-экранах.",
         fillInBlankExclusions = listOf(178401L, 178403L, 178404L, 178405L)),
        WordEntity(
            id = 178403, setId = 1784, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_settings_basic", transliteration = "arket behira",
            original = "עַרְכַּת בְּהִירָה", translation = "светлая тема",
            definition = "מַעֲרֶכֶת צְבָעִים לְבָנָה אוֹ פַּסְטֶל — קְרִיאָה נוֹחָה בְּשֶׁמֶשׁ יוֹם.",
            definitionNative = "Белый или пастельный цветовой набор — удобен для чтения днём на солнце.",
            example = "עַרְכַּת בְּהִירָה מַתְאִימָה לְשִׁמּוּשׁ בַּחוּץ בְּאוֹר חָזָק.",
            exampleNative = "עַרְכַּת בְּהִירָה подходит для использования на улице при ярком свете.",
         fillInBlankExclusions = listOf(178401L, 178402L, 178404L, 178405L)),
        WordEntity(
            id = 178404, setId = 1784, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_settings_basic", transliteration = "godel gufan",
            original = "גֹּדֶל גּוּפָן", translation = "размер шрифта",
            definition = "אֹרֶךְ הָאוֹתִיּוֹת עַל הַמָּסָךְ — מִקָּטָן וְצָפוּף וְעַד גָּדוֹל וּבָרוּר לְעַיִן חַלָּשָׁה.",
            definitionNative = "Высота букв на экране — от мелкого и плотного до крупного и чёткого для слабого зрения.",
            example = "סָבָתָא בִּקְּשָׁה לְהַגְדִּיל אֶת גֹּדֶל גּוּפָן בִּקְרִיאַת הוֹדָעוֹת.",
            exampleNative = "Бабушка попросила увеличить גֹּדֶל גּוּפָן при чтении сообщений.",
         fillInBlankExclusions = listOf(178401L, 178402L, 178403L, 178405L)),
        WordEntity(
            id = 178405, setId = 1784, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_settings_basic", transliteration = "sfat memshak",
            original = "שְׂפַת מִמְשָׁק", translation = "язык интерфейса",
            definition = "הַשָּׂפָה שֶׁבָּהּ מוּצָגוֹת כָּל הַכַּפְתּוֹרִים, הַתָּפְרִיטִים וְהוֹדָעוֹת הַמַּעֲרֶכֶת.",
            definitionNative = "Язык, на котором показываются все кнопки, меню и сообщения системы.",
            example = "שִׁנִּיתִי שְׂפַת מִמְשָׁק לְעִבְרִית אַחֲרֵי הָעֲלִיָּה לִיְשְׂרָאֵל.",
            exampleNative = "Я сменил שְׂפַת מִמְשָׁק на иврит после репатриации в Израиль.",
         fillInBlankExclusions = listOf(178401L, 178402L, 178403L, 178404L)),

        // ── mobile_network_basic (5) — сетевые настройки и подключения ──
        WordEntity(
            id = 178406, setId = 1784, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_network_basic", transliteration = "internet selulari",
            original = "אִינְטֶרְנֶט סֶלוּלָרִי", translation = "мобильный интернет",
            definition = "חִבּוּר לָרֶשֶׁת דֶּרֶךְ אַנְטֶנּוֹת חֶבְרַת הַטֵּלֵפוֹן — בְּלִי תְּלוּת בְּכַבְלִים אוֹ נְקֻדּוֹת קְרוֹבוֹת.",
            definitionNative = "Выход в сеть через антенны сотовой компании — без кабелей и роутеров рядом.",
            example = "אִינְטֶרְנֶט סֶלוּלָרִי הִצִּיל אוֹתִי כְּשֶׁהַמְּשַׂחֵק נִשְׁבַּר בָּרַכֶּבֶת.",
            exampleNative = "אִינְטֶרְנֶט סֶלוּלָרִי выручил меня, когда роутер сломался в поезде.",
         fillInBlankExclusions = listOf(178407L, 178408L, 178409L, 178410L)),
        WordEntity(
            id = 178407, setId = 1784, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_network_basic", transliteration = "khibur vay-fay",
            original = "חִבּוּר וַויי-פַיי", translation = "Wi-Fi подключение",
            definition = "קֶשֶׁר אַלְחוּטִי קָצָר טְוַח לַנַּתְבַּב בַּבַּיִת אוֹ בְּבֵית הַקָּפֶה.",
            definitionNative = "Беспроводная связь короткого радиуса с роутером дома или в кафе.",
            example = "חִבּוּר וַויי-פַיי בַּנָּמַל הָיָה אִטִּי וְלֹא הִסְפִּיק לְוִידֵאוֹ.",
            exampleNative = "חִבּוּר וַויי-פַיי в порту был медленный и не тянул видео.",
         fillInBlankExclusions = listOf(178406L, 178408L, 178409L, 178410L)),
        WordEntity(
            id = 178408, setId = 1784, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_network_basic", transliteration = "hagbalat tuna",
            original = "הַגְבָּלַת תּוּנָּה", translation = "ограничение трафика",
            definition = "תִּקְרָה חָדְשִׁית שֶׁל בַּיְטִים שֶׁמֵּעַל לָהּ הַסֶּפֶּק יוֹרֵד אוֹ הַגְּלִישָׁה נֶחְסֶמֶת.",
            definitionNative = "Месячный потолок байт — выше него скорость падает или выход в сеть блокируется.",
            example = "הַגְבָּלַת תּוּנָּה שֶׁל הַחֲבִילָה שֶׁלִּי נִגְמְרָה בְּאֶמְצַע הַחֹדֶשׁ.",
            exampleNative = "הַגְבָּלַת תּוּנָּה моего тарифа закончилась в середине месяца.",
         fillInBlankExclusions = listOf(178406L, 178407L, 178409L, 178410L)),
        WordEntity(
            id = 178409, setId = 1784, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_network_basic", transliteration = "matsav tisa",
            original = "מַצַּב טִיסָה", translation = "режим самолёта",
            definition = "מְצָב שֶׁמְּכַבֶּה אֶת כָּל הָאוֹת הָאַלְחוּטִי שֶׁל הַמַּכְשִׁיר בְּלַחִיצָה אַחַת.",
            definitionNative = "Состояние, отключающее весь беспроводной сигнал устройства одним нажатием.",
            example = "הִדְלַקְתִּי מַצַּב טִיסָה לִפְנֵי הַהַמְרָאָה כְּמוֹ שֶׁבִּקְּשָׁה הַדַּיֶּלֶת.",
            exampleNative = "Я включил מַצַּב טִיסָה перед взлётом, как попросила бортпроводница.",
         fillInBlankExclusions = listOf(178406L, 178407L, 178408L, 178410L)),
        WordEntity(
            id = 178410, setId = 1784, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_network_basic", transliteration = "hotspot",
            original = "הוֹטְסְפּוֹט", translation = "точка доступа (hotspot)",
            definition = "שֵׁרוּת שֶׁמַּפְעִיל הַטֵּלֵפוֹן וּמְשַׁתֵּף אֶת הַחֲבִילָה הַסֶּלוּלָרִית עִם מַחְשְׁבִים אֲחֵרִים.",
            definitionNative = "Сервис на телефоне — отдаёт сотовый трафик другим компьютерам поблизости.",
            example = "פָּתַחְתִּי הוֹטְסְפּוֹט בָּרֶכֶב כְּדֵי שֶׁהַיְּלָדִים יִצְפּוּ בְּסֶרֶט.",
            exampleNative = "Я открыл הוֹטְסְפּוֹט в машине, чтобы дети посмотрели фильм.",
         fillInBlankExclusions = listOf(178406L, 178407L, 178408L, 178409L)),

        // ── mobile_permissions_basic (5) — системные разрешения ──
        WordEntity(
            id = 178411, setId = 1784, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_permissions_basic", transliteration = "harshaat matslema",
            original = "הַרְשָׁאַת מַצְלֵמָה", translation = "разрешение камеры",
            definition = "אִשּׁוּר שֶׁל הַמִּשְׁתַּמֵּשׁ לַתּוֹכְנָה לִפְתֹּחַ אֶת הָעֵדֶשׁ וּלְצַלֵּם תְּמוּנוֹת אוֹ סְרָטוֹנִים.",
            definitionNative = "Согласие пользователя — программа открывает объектив и снимает кадры или ролики.",
            example = "בִּקְּשָׁה לְהַרְשָׁאַת מַצְלֵמָה קוֹפֶצֶת בַּפְּעָם הָרִאשׁוֹנָה.",
            exampleNative = "Запрос הַרְשָׁאַת מַצְלֵמָה всплывает при первом запуске.",
         fillInBlankExclusions = listOf(178412L, 178413L, 178414L, 178415L)),
        WordEntity(
            id = 178412, setId = 1784, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_permissions_basic", transliteration = "gisha la-mikrofon",
            original = "גִּישָׁה לַמִּיקְרוֹפוֹן", translation = "доступ к микрофону",
            definition = "אִשּׁוּר שֶׁמְּאַפְשֵׁר לְקוֹד לְהַקְלִיט קוֹל מֵהַסְּבִיבָה דֶּרֶךְ הָרְכִיב הַפְּנִימִי.",
            definitionNative = "Согласие — код записывает голос из окружения через внутренний компонент.",
            example = "בְּלִי גִּישָׁה לַמִּיקְרוֹפוֹן הוּדְעוֹת קוֹלִיּוֹת לֹא יַעַבְדוּ בִּכְלָל.",
            exampleNative = "Без גִּישָׁה לַמִּיקְרוֹפוֹן голосовые сообщения вообще не заработают.",
         fillInBlankExclusions = listOf(178411L, 178413L, 178414L, 178415L)),
        WordEntity(
            id = 178413, setId = 1784, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_permissions_basic", transliteration = "albom tmunot",
            original = "אַלְבּוֹם תְּמוּנוֹת", translation = "доступ к фото",
            definition = "אֹסֶף הַתְּצוּגוֹת שֶׁל הַמַּכְשִׁיר שֶׁתּוֹכְנָה רוֹצָה לִקְרֹא, לִבְחֹר אוֹ לְהַעֲלוֹת מִמֶּנּוּ.",
            definitionNative = "Коллекция кадров устройства — программа хочет читать, выбирать или загружать оттуда.",
            example = "הַתּוֹכְנָה בִּקְּשָׁה לְהִכָּנֵס לְאַלְבּוֹם תְּמוּנוֹת לִפְנֵי שֶׁהֶעֶלְתָה אֶת הָאַוּטָר.",
            exampleNative = "Программа попросилась в אַלְבּוֹם תְּמוּנוֹת, прежде чем загрузить аватар.",
         fillInBlankExclusions = listOf(178411L, 178412L, 178414L, 178415L)),
        WordEntity(
            id = 178414, setId = 1784, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_permissions_basic", transliteration = "itur mikum",
            original = "אִיתּוּר מִיקּוּם", translation = "разрешение геолокации",
            definition = "אִשּׁוּר לְקוֹד לִקְבֹּעַ אֵיפֹה הַמַּכְשִׁיר נִמְצָא — לְפִי לַוְיָנִים אוֹ אַנְטֶנּוֹת.",
            definitionNative = "Согласие коду определять, где находится устройство — по спутникам или вышкам.",
            example = "אִיתּוּר מִיקּוּם נִדְרָשׁ כְּדֵי שֶׁהַמָּפָּה תַּצִּיג אוֹתִי בִּנְקֻדָּה הַנְּכוֹנָה.",
            exampleNative = "אִיתּוּר מִיקּוּם нужен, чтобы карта показала меня в правильной точке.",
         fillInBlankExclusions = listOf(178411L, 178412L, 178413L, 178415L)),
        WordEntity(
            id = 178415, setId = 1784, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_permissions_basic", transliteration = "haskamat hodaot",
            original = "הַסְכָּמַת הוֹדָעוֹת", translation = "разрешения уведомлений",
            definition = "אִשּׁוּר שֶׁל הַמִּשְׁתַּמֵּשׁ לַמַּעֲרֶכֶת לְהַצִּיג עִדְכּוּנִים גַּם כְּשֶׁהַתּוֹכְנָה סְגוּרָה.",
            definitionNative = "Согласие пользователя системе — показывать оповещения, даже когда программа закрыта.",
            example = "בְּלִי הַסְכָּמַת הוֹדָעוֹת לֹא תֵּדְעוּ עַל הוֹרָדַת מְחִיר אוֹ הוֹדָעָה חֲדָשָׁה.",
            exampleNative = "Без הַסְכָּמַת הוֹדָעוֹת вы не узнаете о снижении цены или новом сообщении.",
         fillInBlankExclusions = listOf(178411L, 178412L, 178413L, 178414L)),

        // ── mobile_resources (5) — ресурсы и локализация ──
        WordEntity(
            id = 178416, setId = 1784, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_resources", transliteration = "tikiyat asets",
            original = "תִּיקִיַּת אַסֵטְס", translation = "папка assets",
            definition = "מָקוֹם בָּפְּרוֹיֶקְט שֶׁבּוֹ מַחְזִיקִים קְבָצִים סְטָטִיִּים — פוֹנְטִים, סְרָטִים אוֹ נְתוּנֵי דֶּמוֹ.",
            definitionNative = "Место в проекте — там лежат статичные файлы: шрифты, ролики или demo-данные.",
            example = "שָׂמְתִּי אֶת קֹבֶץ הַנְּתוּנִים בְּתוֹךְ תִּיקִיַּת אַסֵטְס וְקָרָאתִי אוֹתוֹ בִּזְמַן רִיצָה.",
            exampleNative = "Я положил файл с данными в תִּיקִיַּת אַסֵטְס и читал его во время выполнения.",
         fillInBlankExclusions = listOf(178417L, 178418L, 178419L, 178420L)),
        WordEntity(
            id = 178417, setId = 1784, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_resources", transliteration = "drovebel",
            original = "דְּרוֹאֶבֶּל", translation = "drawable (графический ресурс)",
            definition = "תְּצוּגָה גְּרָפִית — אַייקוֹן, רֶקַע אוֹ צוּרָה — שֶׁהַקּוֹד מוֹשֵׁךְ וּמַצְלִיב עַל הַמָּסָךְ.",
            definitionNative = "Графическое представление — иконка, фон или фигура — код подтягивает и кладёт на экран.",
            example = "הִצַּבְתִּי דְּרוֹאֶבֶּל חָדָשׁ לַכַּפְתּוֹר הָרָאשִׁי בִּשְׁתֵּי דְּחִיפוּיוֹת לַמַּאֲגָר.",
            exampleNative = "Я добавил новый דְּרוֹאֶבֶּל для главной кнопки в двух коммитах в репозиторий.",
         fillInBlankExclusions = listOf(178416L, 178418L, 178419L, 178420L)),
        WordEntity(
            id = 178418, setId = 1784, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_resources", transliteration = "mashaav makhrozet",
            original = "מַשָּׁאַב מַחְרֹזֶת", translation = "string-ресурс",
            definition = "טֶקְסְט שָׁמוּר בְּקֹבֶץ נִפְרָד עִם מַזָהֶה — כָּךְ קַל לְהַחֲלִיפוֹ אוֹ לְתַרְגְּמוֹ.",
            definitionNative = "Текст лежит в отдельном файле с идентификатором — так его легко заменить или перевести.",
            example = "כָּל הַכּוֹתָרוֹת בָּאַפְּלִיקַצְיָה כְּתוּבוֹת כְּמַשָּׁאַב מַחְרֹזֶת לְפִי הַשָּׂפָה.",
            exampleNative = "Все заголовки в приложении записаны как מַשָּׁאַב מַחְרֹזֶת по языку.",
         fillInBlankExclusions = listOf(178416L, 178417L, 178419L, 178420L)),
        WordEntity(
            id = 178419, setId = 1784, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_resources", transliteration = "lokalizatsya",
            original = "לוֹקַלִיזַצְיָה", translation = "локализация",
            definition = "הַתְאָמַת הַתּוֹכְנָה לִשְׂפָה וְלִתְרְבּוּת שֶׁל מְדִינָה — תַּרְגוּם, מַטְבֵּעַ, פוֹרְמָט תַּאֲרִיךְ.",
            definitionNative = "Подгонка программы под язык и культуру страны — перевод, валюта, формат даты.",
            example = "לוֹקַלִיזַצְיָה לְעִבְרִית דָּרְשָׁה לְהָפֹךְ אֶת כָּל הַמָּסָכִים לְכִוּוּן יָמִין.",
            exampleNative = "לוֹקַלִיזַצְיָה на иврит потребовала развернуть все экраны направо.",
         fillInBlankExclusions = listOf(178416L, 178417L, 178418L, 178420L)),
        WordEntity(
            id = 178420, setId = 1784, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_resources", transliteration = "rezolutsya",
            original = "רֶזוֹלוּצְיָה", translation = "разрешение картинки",
            definition = "כַּמּוּת הַנְּקֻדּוֹת בְּכָל אֹרֶךְ וְרֹחַב — קוֹבַעַת אֶת חֲדּוּת הַתְּצוּגָה.",
            definitionNative = "Количество точек по длине и ширине — определяет чёткость изображения.",
            example = "רֶזוֹלוּצְיָה גְּבוֹהָה שֶׁל הָאַייקוֹן נִרְאֲתָה מְטֻשְׁטֶשֶׁת בְּמַסַּכִּים יְשָׁנִים.",
            exampleNative = "Высокая רֶזוֹלוּצְיָה иконки выглядела размыто на старых экранах.",
         fillInBlankExclusions = listOf(178416L, 178417L, 178418L, 178419L)),

        // ── mobile_debug_basic (5) — отладка приложения ──
        WordEntity(
            id = 178421, setId = 1784, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_debug_basic", transliteration = "log",
            original = "לוֹג", translation = "лог приложения",
            definition = "רְשִׁימָה שׁוּרוֹת שֶׁהַתּוֹכְנָה כּוֹתֶבֶת בִּזְמַן רִיצָה — מָה קָרָה וּמָתַי.",
            definitionNative = "Список строк — программа пишет на ходу: что произошло и когда.",
            example = "כָּתַבְתִּי שׁוּרַת לוֹג בְּכָל פְּעֻלָּה כְּדֵי לִמְצֹא תַּקָּלוֹת מְהֵרָה.",
            exampleNative = "Я писал строку לוֹג на каждое действие, чтобы быстро находить поломки.",
         fillInBlankExclusions = listOf(178422L, 178423L, 178424L, 178425L)),
        WordEntity(
            id = 178422, setId = 1784, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "mobile_debug_basic", transliteration = "konsolat mefateakh",
            original = "קוֹנְסוֹלַת מְפַתֵּחַ", translation = "консоль разработчика",
            definition = "כְּלִי שֶׁבּוֹ הַמְּפַתֵּחַ רוֹאֶה הוֹדָעוֹת מַעֲרֶכֶת בִּזְמַן אֱמֶת וְשׁוֹלֵחַ פְּקֻדּוֹת.",
            definitionNative = "Инструмент — разработчик видит сообщения системы в реальном времени и шлёт команды.",
            example = "קוֹנְסוֹלַת מְפַתֵּחַ הִצִּיעָה לִי הַשְׁלָמָה אוֹטוֹמָטִית בִּשְׁתֵּי שׁוּרוֹת.",
            exampleNative = "קוֹנְסוֹלַת מְפַתֵּחַ предложила мне автодополнение в две строки.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178423, setId = 1784, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_debug_basic", transliteration = "breykpoint",
            original = "בְּרֵייקְפּוֹינְט", translation = "breakpoint (точка останова)",
            definition = "סִימָן שֶׁעוֹצֵר אֶת הָרִיצָה בְּשׁוּרָה מְסֻיֶּמֶת — כְּדֵי לִבְדֹּק עֶרְכִּים בָּרֶגַע הַזֶּה.",
            definitionNative = "Метка останавливает выполнение на конкретной строке — посмотреть значения в этот момент.",
            example = "שָׂמְתִּי בְּרֵייקְפּוֹינְט בַּלּוּלָאָה כְּדֵי לִתְפֹּס בְּדִיּוּק מָתַי הָאִינְדֶּקְס מִתְקַלְקֵל.",
            exampleNative = "Я поставил בְּרֵייקְפּוֹינְט в цикле, чтобы поймать момент, когда индекс портится.",
         fillInBlankExclusions = listOf(178421L, 178422L, 178424L, 178425L)),
        WordEntity(
            id = 178424, setId = 1784, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_debug_basic", transliteration = "bild dibug",
            original = "בִּילְד דִּיבּוּג", translation = "отладочная сборка",
            definition = "גִּרְסַת קוֹד עִם כְּלֵי בְּדִיקָה פְּנִימִיִּים — אִטִּית יוֹתֵר אֲבָל נוֹחָה לַחֲקִירָה.",
            definitionNative = "Версия кода со встроенными средствами проверки — медленнее, но удобна для разбора.",
            example = "בִּילְד דִּיבּוּג שֶׁל יוֹם שִׁישִּׁי שָׁקַל פִּי שְׁנַיִם מִגִּרְסַת הַפְּרוֹדָקְשֶׁן.",
            exampleNative = "בִּילְד דִּיבּוּג в пятницу весил вдвое больше продакшен-версии.",
         fillInBlankExclusions = listOf(178421L, 178422L, 178423L, 178425L)),
        WordEntity(
            id = 178425, setId = 1784, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_debug_basic", transliteration = "simulator",
            original = "סִימוּלָטוֹר", translation = "симулятор",
            definition = "תּוֹכְנָה עַל הַמַּחְשֵׁב שֶׁמַּעֲמִידָה פָּנִים שֶׁל מַכְשִׁיר נַיָּד — לִבְדִיקַת קוֹד בְּלִי טֵלֵפוֹן.",
            definitionNative = "Программа на компьютере прикидывается мобильным устройством — проверять код без телефона.",
            example = "סִימוּלָטוֹר שֶׁל אַיי-פוֹן יוֹתֵר מָהִיר מֵאֱמוּלָטוֹר אַנְדְּרוֹאִיד בְּמַק.",
            exampleNative = "סִימוּלָטוֹר для iPhone быстрее эмулятора Android на Mac.",
         fillInBlankExclusions = listOf(178421L, 178422L, 178423L, 178424L)),
    )
}
