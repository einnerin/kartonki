package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Кибербезопасность", L1 «Основы» (COMMON+UNCOMMON).
 *
 * Set 1780: «Кибербезопасность» — основы L1:
 *           Базовая лексика осознанного пользователя сети — пароли, защита
 *           аккаунта, антивирус, осторожность в интернете, базовая приватность.
 *           ВСЕ ТЕРМИНЫ — ОБОРОНИТЕЛЬНОЙ ЗАЩИТЫ ДЛЯ ОБЫЧНОГО ПОЛЬЗОВАТЕЛЯ
 *           (не атакующая безопасность — это L3/L4).
 *
 * Лексика отражает реальный иврит-израильского интерфейса: кириллические/латинские
 * заимствования (אַנְטִיוִירוּס, פִּין, קוּקִיז, פְּרוֹפִיל) перемешаны с
 * собственно ивритскими композитами (סִיסְמָה, חֶשְׁבּוֹן, מִשְׁתַּמֵּשׁ).
 *
 * Распределение редкостей: 13 COMMON + 12 UNCOMMON.
 *
 * SemanticGroups (5 × 5):
 *   cyber_passwords           — пароли и блокировки: пароль, пин-код,
 *                               контрольный вопрос, секретный ключ,
 *                               блокировка экрана
 *   cyber_account_protection  — защита аккаунта: аккаунт, пользователь,
 *                               выход из аккаунта, история входов,
 *                               доверенное устройство
 *   cyber_antivirus           — антивирус и проверки: антивирус, авто-
 *                               обновление, сканирование, угроза, карантин
 *   cyber_internet_safety     — осторожность в сети: подозрительная ссылка,
 *                               безопасный сайт, неизвестный отправитель,
 *                               личная информация, спам
 *   cyber_privacy             — приватность: цифровая защита, согласие на
 *                               cookies, настройки приватности, анонимный
 *                               режим, скрытие профиля
 *
 * Word IDs: setId × 100 + position (178001..178025).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 *
 * Заметки про возможные пересечения с соседями (тема «Кибербезопасность»):
 * - L2 (1781) — продвинутый пользователь: 2FA, бэкапы, обновления системы,
 *   безопасный сёрфинг, email-гигиена. Здесь — только базовая лексика.
 * - L3 (1767) — атаки и защита (пентест-ориентированный): malware, phishing,
 *   firewall, VPN, шифрование. Здесь нет.
 * - L4 (1768) — security engineering: pentest, forensics, GDPR, zero trust.
 *   Здесь нет.
 * - מַפְתֵּחַ (root פ-ת-ח): в 1767 «מַפְתֵּחַ צִיבּוּרִי», в 1768 «מַפְתֵּחַ
 *   צִבּוּרִי», в 1781 «מַפְתֵּחַ פִיזִי», здесь — «מַפְתֵּחַ סוֹדִי». Все
 *   разные `original`-строки, дублей нет.
 */
object WordDataHebrewCyberL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1780, languagePair = "he-ru", orderIndex = 1780,
            name = "Кибербезопасность",
            description = "Базовая лексика: пароли, защита аккаунта, антивирус, осторожность в сети",
            topic = "Кибербезопасность", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1780 — Кибербезопасность: основы (L1, COMMON+UNCOMMON)
        // 5 групп × 5 слов: passwords, account_protection, antivirus,
        // internet_safety, privacy
        // ══════════════════════════════════════════════════════════════════════

        // ── cyber_passwords (5) — пароли и блокировки экрана ──
        WordEntity(
            id = 178001, setId = 1780, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "cyber_passwords", transliteration = "sismah",
            original = "סִיסְמָה", translation = "пароль",
            definition = "מַחְרֹזֶת אוֹתִיּוֹת וּמִסְפָּרִים שֶׁמְּאַשֶּׁרֶת לָךְ לְהִכָּנֵס לַחֶשְׁבּוֹן.",
            definitionNative = "Цепочка букв и цифр — даёт тебе войти в учётную запись.",
            example = "שָׁכַחְתִּי אֶת הַסִּיסְמָה וְהָיִיתִי צָרִיךְ לְאַפֵּס אוֹתָהּ.",
            exampleNative = "Я забыл סִיסְמָה и пришлось её сбрасывать.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178002, setId = 1780, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "cyber_passwords", transliteration = "kod pin",
            original = "קוֹד פִּין", translation = "пин-код",
            definition = "אַרְבָּעָה אוֹ שִׁשָּׁה סְפָרוֹת קְצָרוֹת לִכְנִיסָה מְהִירָה לְכַרְטִיס אוֹ לְטֶלֶפוֹן.",
            definitionNative = "Четыре или шесть коротких цифр — для быстрого входа в карту или телефон.",
            example = "הִקְלַדְתִּי קוֹד פִּין שָׁגוּי שָׁלוֹשׁ פְּעָמִים בְּטָעוּת.",
            exampleNative = "Я по ошибке набрал неверный קוֹד פִּין три раза.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178003, setId = 1780, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "cyber_passwords", transliteration = "she'elat zihui",
            original = "שְׁאֵלַת זִהוּי", translation = "контрольный вопрос",
            definition = "שְׁאֵלָה אִישִׁית שֶׁבּוֹחֲרִים מֵרֹאשׁ — לְוַדֵּא שֶׁאַתָּה זֶה אַתָּה.",
            definitionNative = "Личный вопрос, что выбираешь заранее — убедиться, что это действительно ты.",
            example = "שְׁאֵלַת זִהוּי שֶׁלִּי הָיְתָה שֵׁם הַכֶּלֶב הָרִאשׁוֹן.",
            exampleNative = "Моя שְׁאֵלַת זִהוּי была про имя первой собаки.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178004, setId = 1780, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "cyber_passwords", transliteration = "maftea'kh sodi",
            original = "מַפְתֵּחַ סוֹדִי", translation = "секретный ключ",
            definition = "צֵרוּף יָחִיד שֶׁרַק לְךָ יֵשׁ — וְהוּא פּוֹתֵחַ אֶת הָאוֹצָר הַדִּיגִיטָלִי שֶׁלְּךָ.",
            definitionNative = "Уникальная комбинация — есть только у тебя, ею открываешь свой цифровой сейф.",
            example = "כָּתַבְתִּי אֶת הַמַּפְתֵּחַ סוֹדִי עַל פֶּתֶק וְהֶחְבֵּאתִי בַּכַּסֶּפֶת.",
            exampleNative = "Я записал מַפְתֵּחַ סוֹדִי на бумажку и спрятал в сейфе.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178005, setId = 1780, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "cyber_passwords", transliteration = "ne'ilat masakh",
            original = "נְעִילַת מָסָךְ", translation = "блокировка экрана",
            definition = "מַצָּב שֶׁבּוֹ הַטֶּלֶפוֹן יָשֵׁן וְלֹא נִפְתָּח בְּלִי קוֹד אוֹ טְבִיעַת אֶצְבַּע.",
            definitionNative = "Состояние, когда телефон спит и не открывается без кода или отпечатка.",
            example = "נְעִילַת מָסָךְ נִפְתַּחַת אֶצְלִי בִּטְבִיעַת אֶצְבַּע.",
            exampleNative = "נְעִילַת מָסָךְ у меня снимается отпечатком пальца.",
            isFillInBlankSafe = false,
        ),

        // ── cyber_account_protection (5) — защита учётной записи ──
        WordEntity(
            id = 178006, setId = 1780, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "cyber_account_protection", transliteration = "kheshbon",
            original = "חֶשְׁבּוֹן", translation = "аккаунт",
            definition = "מָקוֹם אִישִׁי בָּאֲתָר אוֹ בָּאַפְּלִיקַצְיָה שֶׁשַּׁיָּךְ רַק לְךָ.",
            definitionNative = "Личное место на сайте или в приложении — принадлежит только тебе.",
            example = "פָּתַחְתִּי חֶשְׁבּוֹן חָדָשׁ בָּרֶשֶׁת הַחֶבְרָתִית הַחֲדָשָׁה.",
            exampleNative = "Я открыл новый חֶשְׁבּוֹן в свежей соцсети.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178007, setId = 1780, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cyber_account_protection", transliteration = "mishtamesh",
            original = "מִשְׁתַּמֵּשׁ", translation = "пользователь",
            definition = "אָדָם שֶׁפּוֹתֵחַ אֲתָר אוֹ אַפְּלִיקַצְיָה כְּדֵי לִקְרֹא, לִקְנוֹת אוֹ לִכְתֹּב הוֹדָעוֹת.",
            definitionNative = "Человек, что открывает сайт или приложение — читать, покупать или писать сообщения.",
            example = "כָּל מִשְׁתַּמֵּשׁ חָדָשׁ מְקַבֵּל מַדְרִיךְ קָצָר בַּכְּנִיסָה הָרִאשׁוֹנָה.",
            exampleNative = "Каждый новый מִשְׁתַּמֵּשׁ получает короткий гид при первом входе.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178008, setId = 1780, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "cyber_account_protection", transliteration = "yetsia mehakheshbon",
            original = "יְצִיאָה מֵהַחֶשְׁבּוֹן", translation = "выход из аккаунта",
            definition = "פְּעֻלָּה שֶׁסּוֹגֶרֶת אֶת הַחֶשְׁבּוֹן בַּדַּפְדְּפָן וּמַחֲזִירָה לְמָסַךְ הַכְּנִיסָה.",
            definitionNative = "Действие — закрывает учётную запись в браузере и возвращает к экрану входа.",
            example = "יְצִיאָה מֵהַחֶשְׁבּוֹן הִיא הֶרְגֵּל טוֹב בְּמַחְשֵׁב צִיבּוּרִי.",
            exampleNative = "יְצִיאָה מֵהַחֶשְׁבּוֹן — хорошая привычка на публичном компьютере.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178009, setId = 1780, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "cyber_account_protection", transliteration = "historiyat knisot",
            original = "הִיסְטוֹרְיַת כְּנִיסוֹת", translation = "история входов",
            definition = "רְשִׁימָה שֶׁל פְּעָמִים שֶׁמִּישֶׁהוּ נִכְנַס לַחֶשְׁבּוֹן, עִם זְמַן וְעִם מָקוֹם.",
            definitionNative = "Список случаев, когда кто-то входил в учётку — со временем и местом.",
            example = "הִיסְטוֹרְיַת כְּנִיסוֹת חָשְׂפָה לִי כְּנִיסָה זָרָה מִחוּ\"ל.",
            exampleNative = "הִיסְטוֹרְיַת כְּנִיסוֹת показала мне чужой вход из-за границы.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178010, setId = 1780, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "cyber_account_protection", transliteration = "makhshir amin",
            original = "מַכְשִׁיר אָמִין", translation = "доверенное устройство",
            definition = "טֶלֶפוֹן אוֹ מַחְשֵׁב שֶׁכְּבָר אִשַּׁרְתָּ פַּעַם — וְלֹא בּוֹדְקִים אוֹתְךָ שׁוּב כָּל פַּעַם.",
            definitionNative = "Телефон или компьютер, что ты уже подтвердил — больше не спрашивают каждый раз.",
            example = "סִמַּנְתִּי אֶת הַטֶּלֶפוֹן שֶׁלִּי כְּמַכְשִׁיר אָמִין בַּשֵּׁרוּת הַבַּנְקָאִי.",
            exampleNative = "Я отметил свой телефон как מַכְשִׁיר אָמִין в банковском сервисе.",
            isFillInBlankSafe = false,
        ),

        // ── cyber_antivirus (5) — антивирус и сканирование ──
        WordEntity(
            id = 178011, setId = 1780, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "cyber_antivirus", transliteration = "antivirus",
            original = "אַנְטִיוִירוּס", translation = "антивирус",
            definition = "תּוֹכְנָה שֶׁעוֹצֶרֶת קְבָצִים זְדוֹנִיִּים לִפְנֵי שֶׁהֵם פּוֹגְעִים בַּמַּחְשֵׁב.",
            definitionNative = "Программа, что останавливает зловредные файлы — до того как они навредят машине.",
            example = "הָאַנְטִיוִירוּס שֶׁלִּי תָּפַס קֹבֶץ חָשׁוּד מִיָּד.",
            exampleNative = "Мой אַנְטִיוִירוּס сразу поймал подозрительный файл.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178012, setId = 1780, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "cyber_antivirus", transliteration = "idkun otomati",
            original = "עִדְכּוּן אוֹטוֹמָטִי", translation = "автоматическое обновление",
            definition = "הוֹרָדָה שֶׁמַּגִּיעָה לְבַד בָּרֶקַע — בְּלִי שֶׁתִּצְטָרֵךְ לִלְחֹץ עַל כְּלוּם.",
            definitionNative = "Загрузка приходит сама в фоне — нажимать ничего не надо.",
            example = "עִדְכּוּן אוֹטוֹמָטִי הוֹרִיד גִּרְסָה חֲדָשָׁה בַּלַּיְלָה.",
            exampleNative = "עִדְכּוּן אוֹטוֹמָטִי за ночь скачал свежую версию.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178013, setId = 1780, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "cyber_antivirus", transliteration = "srikat kvatsim",
            original = "סְרִיקַת קְבָצִים", translation = "сканирование файлов",
            definition = "מַעֲבָר מְהִיר עַל כָּל הַקְּבָצִים בְּדִיסְק כְּדֵי לִמְצֹא מַשֶּׁהוּ זְדוֹנִי.",
            definitionNative = "Быстрый проход по всем файлам на диске — найти что-то зловредное.",
            example = "סְרִיקַת קְבָצִים שְׁבוּעִית מִתְבַּצַּעַת בְּלֵילוֹת שִׁשִּׁי.",
            exampleNative = "Еженедельный סְרִיקַת קְבָצִים запускается по пятницам ночью.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178014, setId = 1780, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "cyber_antivirus", transliteration = "iyum",
            original = "אִיּוּם", translation = "угроза",
            definition = "כָּל דָּבָר מְסֻכָּן שֶׁאוּלַי יִפְגַּע בַּמַּחְשֵׁב אוֹ בַּמֵּידָע שֶׁלְּךָ.",
            definitionNative = "Любая опасная штука — может задеть машину или твою информацию.",
            example = "הָאַנְטִיוִירוּס סִמֵּן אִיּוּם בְּקֹבֶץ שֶׁהוֹרַדְתִּי מֵאֲתָר זָר.",
            exampleNative = "Антивирус пометил אִיּוּם в файле, что я скачал с чужого сайта.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178015, setId = 1780, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cyber_antivirus", transliteration = "azor mevuda",
            original = "אֵזוֹר מְבֻדָּד", translation = "карантинная зона (для подозрительных файлов)",
            definition = "מָקוֹם סָגוּר בָּאַנְטִיוִירוּס שֶׁבּוֹ מַחֲזִיקִים קֹבֶץ חָשׁוּד עַד שֶׁבּוֹדְקִים.",
            definitionNative = "Закрытое место в антивирусе — там держат подозрительный файл до проверки.",
            example = "הָעֲבַרְתִּי אֶת הַקֹּבֶץ הַחָשׁוּד לְאֵזוֹר מְבֻדָּד בִּלְחִיצָה.",
            exampleNative = "Я перевёл подозрительный файл в אֵזוֹר מְבֻדָּד одним нажатием.",
            isFillInBlankSafe = false,
        ),

        // ── cyber_internet_safety (5) — осторожность в сети ──
        WordEntity(
            id = 178016, setId = 1780, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "cyber_internet_safety", transliteration = "kishur khashud",
            original = "קִישׁוּר חָשׁוּד", translation = "подозрительная ссылка",
            definition = "כְּתֹבֶת בָּרֶשֶׁת שֶׁנִּרְאֵית מוּזָרָה — אוּלַי תּוֹבִיל לְאֲתָר מְזֻיָּף אוֹ לְוִירוּס.",
            definitionNative = "Сетевой адрес выглядит странно — может вести на поддельный сайт или вирус.",
            example = "מָחַקְתִּי אֶת הָהוֹדָעָה כִּי הָיָה בָּהּ קִישׁוּר חָשׁוּד.",
            exampleNative = "Я удалил сообщение — там был קִישׁוּר חָשׁוּד.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178017, setId = 1780, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "cyber_internet_safety", transliteration = "atar batuakh",
            original = "אֲתָר בָּטוּחַ", translation = "безопасный сайт",
            definition = "אֲתָר עִם מַנְעוּל יָרֹק וּכְתֹבֶת תְּקֵפָה — אֶפְשָׁר לְהַזִּין שָׁם פְּרָטִים בְּלִי דְּאָגָה.",
            definitionNative = "Сайт с зелёным замочком и валидным адресом — там можно вводить данные без боязни.",
            example = "אֲנִי קוֹנֶה רַק בְּאֲתָר בָּטוּחַ עִם מַנְעוּל בַּשּׁוּרָה הָעֶלְיוֹנָה.",
            exampleNative = "Я покупаю только в אֲתָר בָּטוּחַ с замочком в верхней строке.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178018, setId = 1780, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "cyber_internet_safety", transliteration = "sholeakh zar",
            original = "שׁוֹלֵחַ זָר", translation = "неизвестный отправитель",
            definition = "אִישׁ שֶׁלֹּא מַכִּירִים שֶׁשּׁוֹלֵחַ הוֹדָעָה — לֹא חָבֵר וְלֹא מִשְׂרָד מֻכָּר.",
            definitionNative = "Человек незнакомый, что присылает сообщение — не друг и не известная контора.",
            example = "לֹא לוֹחֲצִים עַל קְבָצִים מִשּׁוֹלֵחַ זָר בַּדֹּאַר.",
            exampleNative = "Не нажимать на файлы от שׁוֹלֵחַ זָר в почте.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178019, setId = 1780, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "cyber_internet_safety", transliteration = "meida ishi",
            original = "מֵידָע אִישִׁי", translation = "личная информация",
            definition = "פְּרָטִים שֶׁשַׁיָּכִים רַק לָךְ — שֵׁם, מִסְפַּר זֶהוּת, כְּתֹבֶת בַּיִת אוֹ טֶלֶפוֹן.",
            definitionNative = "Сведения, что относятся только к тебе — имя, удостоверение, домашний адрес или телефон.",
            example = "אַל תִּשְׁלַח מֵידָע אִישִׁי בְּצֵ'אט פָּתוּחַ עִם זָרִים.",
            exampleNative = "Не присылай מֵידָע אִישִׁי в открытом чате с незнакомцами.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178020, setId = 1780, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "cyber_internet_safety", transliteration = "do'ar zevel",
            original = "דֹּאַר זְבֵל", translation = "спам / мусорная почта",
            definition = "הוֹדָעוֹת פִּרְסֹמֶת אוֹ נִגּוּד שֶׁמַּגִּיעוֹת בְּלִי שֶׁבִּקַּשְׁתָּ אוֹתָן.",
            definitionNative = "Рекламные или мутные сообщения — приходят, хотя ты их не просил.",
            example = "הַתֵּבָה שֶׁל דֹּאַר זְבֵל הִתְמַלְּאָה בְּמֵאוֹת הוֹדָעוֹת בְּחֹדֶשׁ.",
            exampleNative = "Папка דֹּאַר זְבֵל забилась сотнями сообщений за месяц.",
            isFillInBlankSafe = false,
        ),

        // ── cyber_privacy (5) — приватность и контроль над данными ──
        WordEntity(
            id = 178021, setId = 1780, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "cyber_privacy", transliteration = "hagana digitalit",
            original = "הֲגָנָה דִּיגִיטָלִית", translation = "цифровая защита",
            definition = "כְּלִים וְהֶרְגֵּלִים שֶׁמּוֹנְעִים מִזָּרִים לְהַגִּיעַ לַמַּחְשֵׁב אוֹ לַטֶּלֶפוֹן שֶׁלְּךָ.",
            definitionNative = "Инструменты и привычки — не дают чужим добраться до твоей машины или телефона.",
            example = "הֲגָנָה דִּיגִיטָלִית טוֹבָה מַתְחִילָה בְּסִיסְמָה אֲרֻכָּה.",
            exampleNative = "Хорошая הֲגָנָה דִּיגִיטָלִית начинается с длинного пароля.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178022, setId = 1780, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "cyber_privacy", transliteration = "haskama le-kukiz",
            original = "הַסְכָּמָה לְקוּקִיז", translation = "согласие на cookies",
            definition = "אִישּׁוּר בַּכַּפְתּוֹר הַקּוֹפֵץ שֶׁמַּתִּיר לָאֲתָר לִזְכֹּר אוֹתְךָ בִּכְנִיסוֹת הַבָּאוֹת.",
            definitionNative = "Согласие во всплывающей кнопке — даёт сайту запомнить тебя на следующих заходах.",
            example = "לָחַצְתִּי עַל הַסְכָּמָה לְקוּקִיז בְּלִי לִקְרֹא אֶת הַטֶּקְסְט הַקָּטָן.",
            exampleNative = "Я нажал на הַסְכָּמָה לְקוּקִיז, не читая мелкого текста.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178023, setId = 1780, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "cyber_privacy", transliteration = "hagdarot pratiyut",
            original = "הַגְדָּרוֹת פְּרָטִיּוּת", translation = "настройки приватности",
            definition = "מָסָךְ שֶׁבּוֹ אַתָּה בּוֹחֵר מִי רוֹאֶה אֶת הַתְּמוּנוֹת וְהַפּוֹסְטִים שֶׁלְּךָ.",
            definitionNative = "Экран — там ты выбираешь, кому видны твои фотки и посты.",
            example = "פָּתַחְתִּי אֶת הַהַגְדָּרוֹת פְּרָטִיּוּת וְהֵגַבְתִּי אֶת הַפּוֹסְטִים לִידִידִים.",
            exampleNative = "Я открыл הַגְדָּרוֹת פְּרָטִיּוּת и ограничил посты только для друзей.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178024, setId = 1780, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "cyber_privacy", transliteration = "glisha anonimit",
            original = "גְּלִישָׁה אֲנוֹנִימִית", translation = "анонимный режим",
            definition = "מַצָּב שֶׁבּוֹ הַדַּפְדְּפָן לֹא זוֹכֵר אֶת הָאֲתָרִים שֶׁבִּקַּרְתָּ בָּהֶם.",
            definitionNative = "Состояние браузера — он не запоминает сайты, что ты посетил.",
            example = "פָּתַחְתִּי גְּלִישָׁה אֲנוֹנִימִית כְּדֵי לִקְרֹא חֲדָשׁוֹת לְלֹא הַמְלָצוֹת.",
            exampleNative = "Я открыл גְּלִישָׁה אֲנוֹנִימִית, чтобы читать новости без рекомендаций.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178025, setId = 1780, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "cyber_privacy", transliteration = "hastarat profil",
            original = "הַסְתָּרַת פְּרוֹפִיל", translation = "скрытие профиля",
            definition = "אֶפְשָׁרוּת שֶׁמּוֹרִידָה אֶת הַדַּף שֶׁלְּךָ מֵחִפּוּשׂ בָּרֶשֶׁת הַחֶבְרָתִית.",
            definitionNative = "Опция — убирает твою страницу из поиска по соцсети.",
            example = "הִפְעַלְתִּי הַסְתָּרַת פְּרוֹפִיל אַחֲרֵי הוֹדָעוֹת מַטְרִידוֹת.",
            exampleNative = "Я включил הַסְתָּרַת פְּרוֹפִיל после навязчивых сообщений.",
            isFillInBlankSafe = false,
        ),
    )
}
