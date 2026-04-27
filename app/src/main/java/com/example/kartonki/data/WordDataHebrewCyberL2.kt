package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Кибербезопасность", L2 «Продвинутый» (UNCOMMON+RARE).
 *
 * Set 1781: «Кибербезопасность» — продвинутый L2:
 *           Защита и осознанное поведение обычного пользователя — двухфакторная
 *           проверка, резервные копии, обновления системы, безопасный браузинг,
 *           email-гигиена. Без узкоспециальной лексики (атаки, протоколы,
 *           криптография — это L3/L4).
 *
 * Распределение редкостей: 13 UNCOMMON + 12 RARE.
 *
 * SemanticGroups (5 × 5):
 *   cyber_2fa            — двухэтапная проверка: код по SMS, код из приложения,
 *                          физический ключ, резервный код, дополнительный шаг
 *   cyber_backup         — резервные копии: облачная, локальная, восстановление,
 *                          шифрованная копия, расписание
 *   cyber_updates        — обновления: системы, патч безопасности, исправление
 *                          уязвимости, перезагрузка, версия
 *   cyber_safe_browsing  — безопасный сёрфинг: публичный Wi-Fi, защищённое
 *                          соединение, замочек в адресе, проверка адреса сайта,
 *                          режим инкогнито
 *   cyber_email_safety   — email-гигиена: вложение, отправитель, архив сообщений,
 *                          фильтр спама, маркер фишинга
 *
 * Word IDs: setId × 100 + position (178101..178125).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 *
 * Заметки про возможные пересечения с соседями:
 * - L3 (1767) использует אֵם-אֵף-אֵיי (MFA, общий термин) и פִישִׁינְג (атака) —
 *   здесь конкретные защитные практики юзера: אִימוּת דּוּ-שְׁלַבִּי, סִימָן פִישִׁינְג.
 * - L4 (1768) — pentest/forensics/governance/cryptography, не пересекается.
 * - Соседний L1 (1780) пишется параллельно: базовая лексика (סִיסְמָה, חָזָק,
 *   נָעוּל, חַשְׁבּוֹן, מָסַךְ נְעִילָה и т.п.) — здесь её нет.
 */
object WordDataHebrewCyberL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1781, languagePair = "he-ru", orderIndex = 1781,
            name = "Кибербезопасность",
            description = "Безопасность пользователя: 2FA, бэкапы, обновления, безопасные сети",
            topic = "Кибербезопасность", level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1781 — Кибербезопасность: продвинутый (L2, UNCOMMON+RARE)
        // 5 групп × 5 слов: 2fa, backup, updates, safe_browsing, email_safety
        // ══════════════════════════════════════════════════════════════════════

        // ── cyber_2fa (5) — двухэтапная проверка входа ──
        WordEntity(
            id = 178101, setId = 1781, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cyber_2fa", transliteration = "imut du-shlabi",
            original = "אִימוּת דּוּ-שְׁלַבִּי", translation = "двухэтапная проверка",
            definition = "כְּנִיסָה לַחֶשְׁבּוֹן בִּשְׁנֵי שְׁלַבִּים — סִיסְמָה וְעוֹד אִישּׁוּר נוֹסָף.",
            definitionNative = "Вход в аккаунт в два шага — пароль и ещё одно подтверждение.",
            example = "הִפְעַלְתִּי אִימוּת דּוּ-שְׁלַבִּי עַל הַחֶשְׁבּוֹן הַבַּנְקָאִי שֶׁלִּי.",
            exampleNative = "Я включил אִימוּת דּוּ-שְׁלַבִּי на банковском аккаунте.",
         fillInBlankExclusions = listOf(178102L, 178103L, 178104L, 178105L)),
        WordEntity(
            id = 178102, setId = 1781, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cyber_2fa", transliteration = "kod be-es-em-es",
            original = "קוֹד בְּאֶס-אֶם-אֶס", translation = "код по SMS",
            definition = "מִסְפָּר חַד-פַּעֲמִי שֶׁמַּגִּיעַ לַטֶּלֶפוֹן בַּהוֹדָעָה לְפִי בַּקָּשַׁת הָאֲתָר.",
            definitionNative = "Одноразовое число — приходит на телефон сообщением по запросу сайта.",
            example = "חִכִּיתִי לְקוֹד בְּאֶס-אֶם-אֶס כְּדֵי לְהִכָּנֵס לַחֶשְׁבּוֹן הֶחָדָשׁ.",
            exampleNative = "Я ждал קוֹד בְּאֶס-אֶם-אֶס, чтобы зайти в новый аккаунт.",
         fillInBlankExclusions = listOf(178101L, 178103L, 178104L, 178105L)),
        WordEntity(
            id = 178103, setId = 1781, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_2fa", transliteration = "kod me-aplikatsya",
            original = "קוֹד מֵאַפְּלִיקַצְיָה", translation = "код из приложения",
            definition = "מִסְפָּר שֶׁמִּתְחַלֵּף כָּל שְׁלוֹשִׁים שְׁנִיּוֹת בְּתוֹךְ אַפְּלִיקַצְיָה מְיֻחֶדֶת בַּטֶּלֶפוֹן.",
            definitionNative = "Число, меняется каждые тридцать секунд — внутри особого приложения на телефоне.",
            example = "פָּתַחְתִּי אֶת גוּגֶל אוֹתֶנְטִיקֵייטֶר וְהֶעֱתַקְתִּי קוֹד מֵאַפְּלִיקַצְיָה.",
            exampleNative = "Я открыл Google Authenticator и скопировал קוֹד מֵאַפְּלִיקַצְיָה.",
         fillInBlankExclusions = listOf(178101L, 178102L, 178104L, 178105L)),
        WordEntity(
            id = 178104, setId = 1781, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_2fa", transliteration = "maftea'kh fizi",
            original = "מַפְתֵּחַ פִיזִי", translation = "физический ключ (USB-токен)",
            definition = "הִתְקַן קָטָן שֶׁמִּתְחַבֵּר לַמַּחְשֵׁב וּמְאַשֵּׁר אֶת הַזֶּהוּת בִּלְחִיצָה אַחַת.",
            definitionNative = "Маленькое устройство — подключается к компьютеру и подтверждает личность одним нажатием.",
            example = "קָנִיתִי מַפְתֵּחַ פִיזִי כִּי אֲנִי מְנַהֵל חֶשְׁבּוֹנוֹת רְגִישִׁים בָּעֲבוֹדָה.",
            exampleNative = "Я купил מַפְתֵּחַ פִיזִי — на работе у меня чувствительные аккаунты.",
         fillInBlankExclusions = listOf(178101L, 178102L, 178103L, 178105L)),
        WordEntity(
            id = 178105, setId = 1781, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_2fa", transliteration = "kod giboi",
            original = "קוֹד גִּבּוּי", translation = "резервный код (для восстановления)",
            definition = "רְשִׁימָה שֶׁל מִסְפָּרִים שֶׁמַּדְפִּיסִים מֵרֹאשׁ — לְמִקְרֶה שֶׁאַתָּה מְאַבֵּד גִּישָׁה לַטֶּלֶפוֹן.",
            definitionNative = "Список чисел — печатают заранее на случай, если потеряешь доступ к телефону.",
            example = "שָׁמַרְתִּי קוֹד גִּבּוּי בְּכַסֶּפֶת בַּבַּיִת לְמִקְרֵי חֵרוּם.",
            exampleNative = "Я сохранил קוֹד גִּבּוּי в сейфе дома — на крайний случай.",
         fillInBlankExclusions = listOf(178101L, 178102L, 178103L, 178104L)),

        // ── cyber_backup (5) — резервные копии данных ──
        WordEntity(
            id = 178106, setId = 1781, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cyber_backup", transliteration = "otek shamur",
            original = "עֹתֶק שָׁמוּר", translation = "резервная копия",
            definition = "מַעֲתִיק שֶׁל הַקְּבָצִים שֶׁמַּחֲזִיקִים בְּמָקוֹם נִפְרָד לְמִקְרֶה שֶׁהַמְּקוֹרִיִּים יֹאבְדוּ.",
            definitionNative = "Двойник файлов — держат отдельно, если оригиналы вдруг пропадут.",
            example = "עֹתֶק שָׁמוּר שֶׁל הַתְּמוּנוֹת חָסַךְ לִי כְּשֶׁהַטֶּלֶפוֹן נָפַל לַיָּם.",
            exampleNative = "עֹתֶק שָׁמוּר фоток выручил, когда телефон упал в море.",
         fillInBlankExclusions = listOf(178107L, 178108L, 178109L)),
        WordEntity(
            id = 178107, setId = 1781, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cyber_backup", transliteration = "giboi be-anan",
            original = "גִּבּוּי בֶּעָנָן", translation = "облачный бэкап",
            definition = "שְׁמִירָה אוֹטוֹמָטִית שֶׁל הַקְּבָצִים בַּשְּׁרָתִים שֶׁל גוּגֶל אוֹ אַפֶּל בָּאִינְטֶרְנֶט.",
            definitionNative = "Автоматическое сохранение файлов на серверах Google или Apple в интернете.",
            example = "גִּבּוּי בֶּעָנָן רָץ כָּל לַיְלָה כְּשֶׁהַטֶּלֶפוֹן עַל הַמַּטְעֵן.",
            exampleNative = "גִּבּוּי בֶּעָנָן запускается ночью, пока телефон на зарядке.",
         fillInBlankExclusions = listOf(178106L, 178108L, 178109L)),
        WordEntity(
            id = 178108, setId = 1781, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_backup", transliteration = "giboi mekomi",
            original = "גִּבּוּי מְקוֹמִי", translation = "локальный бэкап (на диск)",
            definition = "הַעְתָּקָה שֶׁל הַקְּבָצִים לְכוֹנָן חִיצוֹנִי שֶׁמְּחַבְּרִים לַמַּחְשֵׁב פִּיזִית.",
            definitionNative = "Копирование файлов на внешний диск, который физически подключают к компьютеру.",
            example = "גִּבּוּי מְקוֹמִי עַל דִּיסְק חִיצוֹנִי שׁוֹכֵב אֶצְלִי בַּמְּגֵרָה.",
            exampleNative = "גִּבּוּי מְקוֹמִי на внешнем диске лежит у меня в ящике стола.",
         fillInBlankExclusions = listOf(178106L, 178107L, 178109L)),
        WordEntity(
            id = 178109, setId = 1781, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cyber_backup", transliteration = "shikhzur kvatsim",
            original = "שִׁחְזוּר קְבָצִים", translation = "восстановление файлов",
            definition = "הַחְזָרָה שֶׁל מִסְמָכִים שֶׁאָבְדוּ אוֹ נִמְחֲקוּ — מִתּוֹךְ הַעְתָּק שֶׁשָׁמוּר מֵרֹאשׁ.",
            definitionNative = "Возврат документов, которые пропали или удалились — из заранее сохранённого двойника.",
            example = "שִׁחְזוּר קְבָצִים אַחֲרֵי הַמְּחִיקָה הַחֲטוּפָה לָקַח לִי שְׁתֵּי שָׁעוֹת.",
            exampleNative = "שִׁחְזוּר קְבָצִים после случайного удаления занял у меня два часа.",
         fillInBlankExclusions = listOf(178106L, 178107L, 178108L)),
        WordEntity(
            id = 178110, setId = 1781, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "cyber_backup", transliteration = "metspan",
            original = "מֻצְפָּן", translation = "зашифрованный (о копии)",
            definition = "סָגוּר עַל יְדֵי קוֹד סוֹדִי — בְּלִי הַסִּיסְמָה הַנְּכוֹנָה אִי-אֶפְשָׁר לִקְרֹא אוֹתוֹ.",
            definitionNative = "Запертый секретным кодом — без правильного пароля прочитать его нельзя.",
            example = "הַגִּבּוּי שֶׁלִּי מֻצְפָּן כָּךְ שֶׁאַף אֶחָד אַחֵר לֹא יוּכַל לִפְתֹּחַ אוֹתוֹ.",
            exampleNative = "Мой бэкап מֻצְפָּן — никто другой его не откроет.",
        ),

        // ── cyber_updates (5) — обновления и патчи ──
        WordEntity(
            id = 178111, setId = 1781, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cyber_updates", transliteration = "idkun ma'arekhet",
            original = "עִדְכּוּן מַעֲרֶכֶת", translation = "обновление системы",
            definition = "גִּרְסָה חֲדָשָׁה שֶׁל הַתּוֹכְנָה שֶׁמַּתְקִינִים עַל הַמַּכְשִׁיר וּמַחְלִיפָה אֶת הַיְּשָׁנָה.",
            definitionNative = "Свежая версия программы — ставят на устройство, она заменяет старую.",
            example = "עִדְכּוּן מַעֲרֶכֶת חָדָשׁ הוֹרִיד אוֹתִי מִשִּׁמּוּשׁ לַחֲצִי שָׁעָה.",
            exampleNative = "עִדְכּוּן מַעֲרֶכֶת отключило меня от работы на полчаса.",
         fillInBlankExclusions = listOf(178112L, 178113L, 178114L, 178115L)),
        WordEntity(
            id = 178112, setId = 1781, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_updates", transliteration = "tlay avtakha",
            original = "טְלַאי אַבְטָחָה", translation = "патч безопасности",
            definition = "תִּקּוּן קָטָן שֶׁסּוֹגֵר חוֹר מְסֻכָּן בַּתּוֹכְנָה לִפְנֵי שֶׁתּוֹקְפִים יְנַצְּלוּ אוֹתוֹ.",
            definitionNative = "Маленькая починка — закрывает опасную дыру в программе до того, как ею воспользуются.",
            example = "טְלַאי אַבְטָחָה דָּחוּף יָצָא יוֹם לִפְנֵי הִתְקָפָה גְּלוֹבָּלִית.",
            exampleNative = "Срочный טְלַאי אַבְטָחָה вышел за день до глобальной атаки.",
         fillInBlankExclusions = listOf(178111L, 178113L, 178114L, 178115L)),
        WordEntity(
            id = 178113, setId = 1781, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_updates", transliteration = "tikkun nekudat torpa",
            original = "תִּקּוּן נְקֻדַּת תֻּרְפָּה", translation = "исправление уязвимости",
            definition = "סְגִירָה שֶׁל מָקוֹם חַלָּשׁ בַּקּוֹד שֶׁאִפְשֵׁר לְהָאקֵרִים לְהִכָּנֵס לַמַּחְשֵׁב.",
            definitionNative = "Заделка слабого места в коде — через него хакеры могли войти в компьютер.",
            example = "תִּקּוּן נְקֻדַּת תֻּרְפָּה בַּדַּפְדְּפָן יָצָא רַק שָׁבוּעַ אַחֲרֵי הַגִּלּוּי.",
            exampleNative = "תִּקּוּן נְקֻדַּת תֻּרְפָּה в браузере вышло всего через неделю после обнаружения.",
         fillInBlankExclusions = listOf(178111L, 178112L, 178114L, 178115L)),
        WordEntity(
            id = 178114, setId = 1781, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_updates", transliteration = "ipul mekhudash",
            original = "אִתְחוּל מְחֻדָּשׁ", translation = "плановая перезагрузка",
            definition = "כִּבּוּי וְהַדְלָקָה שֶׁל הַמַּכְשִׁיר שֶׁמַּשְׁלִימִים אֶת הַהַתְקָנָה שֶׁל הַשִּׁנּוּיִים הַחֲדָשִׁים.",
            definitionNative = "Выключение и включение устройства — завершает установку свежих изменений.",
            example = "הַמַּעֲרֶכֶת בִּקְּשָׁה אִתְחוּל מְחֻדָּשׁ אַחֲרֵי הַהַתְקָנָה.",
            exampleNative = "Система попросила אִתְחוּל מְחֻדָּשׁ после установки.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178115, setId = 1781, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cyber_updates", transliteration = "girsa adkanit",
            original = "גִּרְסָה עַדְכָּנִית", translation = "актуальная версия",
            definition = "הַמַּהֲדוּרָה הָאַחֲרוֹנָה שֶׁל הַתּוֹכְנָה שֶׁכּוֹלֶלֶת אֶת כָּל הַתִּקּוּנִים הַחֲדָשִׁים.",
            definitionNative = "Последний выпуск программы — со всеми свежими починками внутри.",
            example = "אֲנִי מַחֲזִיק אֶת הַטֶּלֶפוֹן בַּגִּרְסָה עַדְכָּנִית בְּכָל פַּעַם.",
            exampleNative = "Я держу телефон в גִּרְסָה עַדְכָּנִית каждый раз.",
         fillInBlankExclusions = listOf(178111L, 178112L, 178113L, 178114L)),

        // ── cyber_safe_browsing (5) — безопасный сёрфинг ──
        WordEntity(
            id = 178116, setId = 1781, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cyber_safe_browsing", transliteration = "vaifai tsiburi",
            original = "וַאיְ-פַיי צִיבּוּרִי", translation = "публичный Wi-Fi",
            definition = "רֶשֶׁת אַלְחוּטִית פְּתוּחָה בְּבֵית קָפֶה אוֹ בִּשְׂדֵה תְּעוּפָה — לְלֹא סִיסְמָה אוֹ עִם סִיסְמָה מְשֻׁתֶּפֶת.",
            definitionNative = "Открытая беспроводная сеть в кафе или аэропорту — без пароля или с общим паролем.",
            example = "וַאיְ-פַיי צִיבּוּרִי בַּקָּפֶה לֹא נוֹחַ לְעַסְקָאוֹת בַּנְקָאִיּוֹת.",
            exampleNative = "וַאיְ-פַיי צִיבּוּרִי в кафе не годится для банковских операций.",
         fillInBlankExclusions = listOf(178117L, 178118L, 178119L, 178120L)),
        WordEntity(
            id = 178117, setId = 1781, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_safe_browsing", transliteration = "khibur mugan",
            original = "חִבּוּר מֻגָּן", translation = "защищённое соединение",
            definition = "קֶשֶׁר מֻצְפָּן בֵּין הַדַּפְדְּפָן לָאֲתָר — אַף אֶחָד בָּאֶמְצַע לֹא יָכוֹל לִקְרֹא אוֹתוֹ.",
            definitionNative = "Шифрованная связь между браузером и сайтом — никто посередине не прочтёт.",
            example = "הָאֲתָר עָבַר לְחִבּוּר מֻגָּן רַק אַחֲרֵי שֶׁהִתְלוֹנַנּוּ.",
            exampleNative = "Сайт перешёл на חִבּוּר מֻגָּן только после жалоб.",
         fillInBlankExclusions = listOf(178116L, 178118L, 178119L, 178120L)),
        WordEntity(
            id = 178118, setId = 1781, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cyber_safe_browsing", transliteration = "siman manul",
            original = "סִימַן מַנְעוּל", translation = "значок замочка (в адресной строке)",
            definition = "אִיקוֹן קָטָן בְּצַד הַכְּתֹבֶת שֶׁמַּרְאֶה שֶׁהַתִּקְשֹׁרֶת עִם הָאֲתָר מֻצְפֶּנֶת.",
            definitionNative = "Маленькая иконка рядом с адресом — показывает, что связь с сайтом зашифрована.",
            example = "תָּמִיד אֲנִי בּוֹדֵק סִימַן מַנְעוּל לִפְנֵי שֶׁאֲנִי מַכְנִיס פְּרָטֵי אַשְׁרַאי.",
            exampleNative = "Я всегда проверяю סִימַן מַנְעוּל, прежде чем ввожу данные карты.",
         fillInBlankExclusions = listOf(178116L, 178117L, 178119L, 178120L)),
        WordEntity(
            id = 178119, setId = 1781, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_safe_browsing", transliteration = "bdikat ktovet",
            original = "בְּדִיקַת כְּתֹבֶת", translation = "проверка адреса сайта",
            definition = "קְרִיאָה שֶׁל הַשּׁוּרָה הָעֶלְיוֹנָה כְּדֵי לְוַדֵּא שֶׁאַתָּה לֹא בְּאֲתָר מְזֻיָּף שֶׁמְּחַקֶּה אֶת הָאֲמִתִּי.",
            definitionNative = "Чтение верхней строки — убедиться, что ты не на поддельном сайте, что копирует настоящий.",
            example = "בְּדִיקַת כְּתֹבֶת זְהִירָה הִצִּילָה אוֹתִי מֵאֲתָר מְזֻיָּף שֶׁל הַבַּנְק.",
            exampleNative = "Внимательная בְּדִיקַת כְּתֹבֶת спасла меня от поддельного сайта банка.",
         fillInBlankExclusions = listOf(178116L, 178117L, 178118L, 178120L)),
        WordEntity(
            id = 178120, setId = 1781, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cyber_safe_browsing", transliteration = "gli'a peratit",
            original = "גְּלִישָׁה פְּרָטִית", translation = "режим инкогнито",
            definition = "מַצָּב שֶׁל הַדַּפְדְּפָן שֶׁבּוֹ הַהִיסְטוֹרְיָה וְהָעוּגִיּוֹת לֹא נִשְׁמָרוֹת בַּמַּחְשֵׁב.",
            definitionNative = "Состояние браузера — история и cookies не сохраняются на компьютере.",
            example = "פָּתַחְתִּי גְּלִישָׁה פְּרָטִית כְּדֵי לִקְרֹא חֲדָשׁוֹת בְּלִי לְהַשְׁפִּיעַ עַל הַהַמְלָצוֹת.",
            exampleNative = "Я открыл גְּלִישָׁה פְּרָטִית, чтобы читать новости и не влиять на рекомендации.",
         fillInBlankExclusions = listOf(178116L, 178117L, 178118L, 178119L)),

        // ── cyber_email_safety (5) — гигиена электронной почты ──
        WordEntity(
            id = 178121, setId = 1781, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cyber_email_safety", transliteration = "tofes mtsoraf",
            original = "טֹפֶס מְצֹרָף", translation = "вложение в письме",
            definition = "קֹבֶץ שֶׁמְּצַרְפִים לְהוֹדָעַת דֹּאַר — קוֹרֵא מַחְשֵׁב פּוֹתֵחַ אוֹתוֹ בִּלְחִיצָה.",
            definitionNative = "Файл, прицепленный к почтовому сообщению — открывается одним кликом.",
            example = "לֹא פָּתַחְתִּי אֶת הַטֹּפֶס מְצֹרָף כִּי הַשּׁוֹלֵחַ הָיָה לֹא מֻכָּר.",
            exampleNative = "Я не открыл טֹפֶס מְצֹרָף — отправитель был незнакомый.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178122, setId = 1781, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_email_safety", transliteration = "imut sholeakh",
            original = "אִימוּת שׁוֹלֵחַ", translation = "проверка отправителя",
            definition = "וִדּוּא שֶׁכְּתֹבֶת הַמַּיְלָר אֲמִתִּית וְלֹא הַעְתָּקָה דּוֹמָה שֶׁמַּטְעָה אֶת הָעַיִן.",
            definitionNative = "Убедиться, что email-адрес настоящий, а не похожая копия — обманывает глаз.",
            example = "אִימוּת שׁוֹלֵחַ זָהִיר חָשַׂף אוֹת אַחַת שׁוֹנָה בִּכְתֹבֶת.",
            exampleNative = "Внимательный אִימוּת שׁוֹלֵחַ показал одну изменённую букву в адресе.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178123, setId = 1781, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cyber_email_safety", transliteration = "arkhion hoda'ot",
            original = "אַרְכִיּוֹן הוֹדָעוֹת", translation = "архив сообщений",
            definition = "תִּקְיָה שֶׁבָּהּ שׁוֹמְרִים מַיְלִים יְשָׁנִים לְלֹא לִמְחֹק אוֹתָם — לְשִׁמּוּשׁ עָתִידִי.",
            definitionNative = "Папка для старых писем — храним, не удаляя, на будущее.",
            example = "מָצָאתִי קַבָּלָה חֲשׁוּבָה בָּאַרְכִיּוֹן הוֹדָעוֹת מִשָּׁנָה שֶׁעָבְרָה.",
            exampleNative = "Я нашёл важный чек в אַרְכִיּוֹן הוֹדָעוֹת за прошлый год.",
         fillInBlankExclusions = listOf(178121L, 178122L, 178124L, 178125L)),
        WordEntity(
            id = 178124, setId = 1781, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cyber_email_safety", transliteration = "masnen zevel",
            original = "מַסְנֵן זֶבֶל", translation = "спам-фильтр",
            definition = "כְּלִי אוֹטוֹמָטִי שֶׁמַּפְרִיד הוֹדָעוֹת פִּרְסֹמֶת מְעַצְבָּנוֹת מִדֹּאַר רָגִיל.",
            definitionNative = "Автоматический инструмент — отделяет рекламные сообщения-надоеды от обычной почты.",
            example = "מַסְנֵן זֶבֶל תָּפַס תִּשְׁעִים אֲחוּזִים מֵהַהוֹדָעוֹת הַמְּטַפְשׁוֹת.",
            exampleNative = "מַסְנֵן זֶבֶל поймал девяносто процентов глупых сообщений.",
         fillInBlankExclusions = listOf(178121L, 178122L, 178123L, 178125L)),
        WordEntity(
            id = 178125, setId = 1781, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_email_safety", transliteration = "siman fishing",
            original = "סִימַן פִישִׁינְג", translation = "маркер фишинга",
            definition = "סִיגְנָל בּוֹלֵט בַּהוֹדָעָה — שְׁגִיאוֹת כְּתִיב, לַחַץ דָּחוּף אוֹ קִשּׁוּר חָשׁוּד.",
            definitionNative = "Заметный сигнал в письме — ошибки, срочное давление или подозрительная ссылка.",
            example = "שָׁלוֹשׁ שְׁגִיאוֹת כְּתִיב הָיוּ סִימַן פִישִׁינְג בָּרוּר בַּהוֹדָעָה.",
            exampleNative = "Три опечатки были явный סִימַן פִישִׁינְג в сообщении.",
         fillInBlankExclusions = listOf(178121L, 178122L, 178123L, 178124L)),
    )
}
