package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrewBatch52 {

    val sets: List<WordSetEntity> get() = listOf(

        WordSetEntity(
            id = 1295, languagePair = "he-ru", orderIndex = 1295,
            name = "Хай-тек: основы",
            description = "Базовая лексика IT-офиса, стартапов и разработки ПО",
            topic = "Хай-тек",
            level = 1),

        WordSetEntity(
            id = 1296, languagePair = "he-ru", orderIndex = 1296,
            name = "Хай-тек: углублённый",
            description = "Рабочий процесс разработчика, инструменты и методологии",
            topic = "Хай-тек",
            level = 3),

        WordSetEntity(
            id = 1297, languagePair = "he-ru", orderIndex = 1297,
            name = "Хай-тек: профессиональный",
            description = "Профессиональная разработка, облако и безопасность систем",
            topic = "Хай-тек",
            level = 4),

        WordSetEntity(
            id = 1298, languagePair = "he-ru", orderIndex = 1298,
            name = "Хай-тек: носитель языка",
            description = "Высокоуровневые концепции архитектуры и распределённых систем",
            topic = "Хай-тек",
            level = 5),

        WordSetEntity(
            id = 1299, languagePair = "he-ru", orderIndex = 1299,
            name = "Хай-тек: носитель языка 2",
            description = "Академический и экспертный дискурс инженерии ПО",
            topic = "Хай-тек",
            level = 5),
    )

    val words: List<WordEntity> get() = listOf(

        // ── Set 1295: Хай-тек: основы (level=1, COMMON+UNCOMMON) ────────────

        WordEntity(id = 129501, setId = 1295, languagePair = "he-ru", rarity = "COMMON",
            original = "מַחְשֵׁב נָיָּד", transliteration = "makhshev nayad", translation = "ноутбук"),

        WordEntity(id = 129502, setId = 1295, languagePair = "he-ru", rarity = "COMMON",
            original = "תּוֹכְנָה", transliteration = "tokhna", translation = "программа, ПО"),

        WordEntity(id = 129503, setId = 1295, languagePair = "he-ru", rarity = "COMMON",
            original = "מוֹבַּיְל", transliteration = "mobail", translation = "мобильный / смартфон"),

        WordEntity(id = 129504, setId = 1295, languagePair = "he-ru", rarity = "COMMON",
            original = "בַּג", transliteration = "bag", translation = "баг, ошибка в коде"),

        WordEntity(id = 129505, setId = 1295, languagePair = "he-ru", rarity = "COMMON",
            original = "שֶׁרֶת עָנָן", transliteration = "sheret anan", translation = "облачный сервер"),

        WordEntity(id = 129506, setId = 1295, languagePair = "he-ru", rarity = "COMMON",
            original = "רֶשֶׁת אִינְטֶרְנֶט", transliteration = "reshet internet", translation = "сеть интернет"),

        WordEntity(id = 129507, setId = 1295, languagePair = "he-ru", rarity = "COMMON",
            original = "מֵיְדָן", transliteration = "meidan", translation = "панель управления / дашборд"),

        WordEntity(id = 129508, setId = 1295, languagePair = "he-ru", rarity = "COMMON",
            original = "צֶוֶת", transliteration = "tsevet", translation = "команда"),

        WordEntity(id = 129509, setId = 1295, languagePair = "he-ru", rarity = "COMMON",
            original = "חַשְׁבּוֹן מִשְׁתַּמֵּשׁ", transliteration = "kheshbon mishtamesh", translation = "учётная запись пользователя"),

        WordEntity(id = 129510, setId = 1295, languagePair = "he-ru", rarity = "COMMON",
            original = "מַשְׁתַּמֵּשׁ", transliteration = "mishtamesh", translation = "пользователь"),

        WordEntity(id = 129511, setId = 1295, languagePair = "he-ru", rarity = "COMMON",
            original = "גִּישָׁה", transliteration = "gisha", translation = "доступ / вход в систему"),

        WordEntity(id = 129512, setId = 1295, languagePair = "he-ru", rarity = "COMMON",
            original = "צ'ַאט", transliteration = "chat", translation = "чат"),

        WordEntity(id = 129513, setId = 1295, languagePair = "he-ru", rarity = "COMMON",
            original = "מַסָּך", transliteration = "masakh", translation = "монитор / экран"),

        WordEntity(id = 129514, setId = 1295, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַמְשָׁק מִשְׁתַּמֵּשׁ", transliteration = "mamshak mishtamesh", translation = "пользовательский интерфейс"),

        WordEntity(id = 129515, setId = 1295, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַסָּד נְתוּנִים", transliteration = "masad netunin", translation = "база данных"),

        WordEntity(id = 129516, setId = 1295, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עֵדְכּוּן תּוֹכְנָה", transliteration = "idkun tokhna", translation = "обновление программы"),

        WordEntity(id = 129517, setId = 1295, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טֶמְפְּלֵט", transliteration = "templet", translation = "шаблон / template"),

        WordEntity(id = 129518, setId = 1295, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תַּמִּיכָה טֶכְנִית", transliteration = "tmiha tekhnit", translation = "техническая поддержка"),

        WordEntity(id = 129519, setId = 1295, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מֻפְעָל", transliteration = "muflal", translation = "запущен, активен (о сервисе)"),

        WordEntity(id = 129520, setId = 1295, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חֲבִילַת תּוֹכְנָה", transliteration = "khavila tokhna", translation = "пакет программ"),

        WordEntity(id = 129521, setId = 1295, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טִיקֶט", transliteration = "tiket", translation = "тикет, заявка"),

        WordEntity(id = 129522, setId = 1295, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַהֲדוּרָה", transliteration = "mahadura", translation = "релиз / выпуск (версия ПО)"),

        WordEntity(id = 129523, setId = 1295, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סְטַרְטַאפּ", transliteration = "startup", translation = "стартап"),

        WordEntity(id = 129524, setId = 1295, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִמּוּן זֶרַע", transliteration = "mimun zera", translation = "посевное финансирование (seed)"),

        WordEntity(id = 129525, setId = 1295, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טוֹקֶן", transliteration = "token", translation = "токен (аутентификации)"),

        // ── Set 1296: Хай-тек: продвинутый (level=2, UNCOMMON+RARE) ─────────

        WordEntity(id = 129601, setId = 1296, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אַלְגּוֹרִיתְם", transliteration = "algoritm", translation = "алгоритм"),

        WordEntity(id = 129602, setId = 1296, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פוּנְקְצִיָּה", transliteration = "funktsiya", translation = "функция"),

        WordEntity(id = 129603, setId = 1296, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִשְׁתַּנֶּה", transliteration = "mishtane", translation = "переменная"),

        WordEntity(id = 129604, setId = 1296, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַאֲגַר גִּיט", transliteration = "ma'agar git", translation = "git-репозиторий"),

        WordEntity(id = 129605, setId = 1296, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עֲנָף", transliteration = "anaf", translation = "ветка (git branch)"),

        WordEntity(id = 129606, setId = 1296, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שֵׁרוּת API", transliteration = "sherut API", translation = "API-сервис"),

        WordEntity(id = 129607, setId = 1296, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִחְזוֹר פִּיתּוּחַ", transliteration = "mikhzor pituyakh", translation = "цикл разработки"),

        WordEntity(id = 129608, setId = 1296, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "ספְּרִינְט", transliteration = "sprint", translation = "спринт (agile)"),

        WordEntity(id = 129609, setId = 1296, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "בְּדִיקוֹת יְחִידָה", transliteration = "bdikot yekhida", translation = "юнит-тесты"),

        WordEntity(id = 129610, setId = 1296, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַדְרִיךְ טֶכְנִי", transliteration = "madrikH tekhni", translation = "технический гайд / руководство"),

        WordEntity(id = 129611, setId = 1296, languagePair = "he-ru", rarity = "RARE",
            original = "בְּחִינַת קוֹד", transliteration = "bkhimat kod", translation = "код-ревью"),

        WordEntity(id = 129612, setId = 1296, languagePair = "he-ru", rarity = "RARE",
            original = "פְּרִיסַת קוֹד", transliteration = "prisat kod", translation = "деплой, развёртывание кода"),

        WordEntity(id = 129613, setId = 1296, languagePair = "he-ru", rarity = "RARE",
            original = "מַסְגֶּרֶת פִּיתּוּחַ", transliteration = "masgeret pituyakh", translation = "фреймворк разработки"),

        WordEntity(id = 129614, setId = 1296, languagePair = "he-ru", rarity = "RARE",
            original = "מְהַדֵּר", transliteration = "mehadder", translation = "компилятор"),

        WordEntity(id = 129615, setId = 1296, languagePair = "he-ru", rarity = "RARE",
            original = "מְנַפֵּה שְׁגִיאוֹת", transliteration = "menape shgi'ot", translation = "отладчик, дебаггер"),

        WordEntity(id = 129616, setId = 1296, languagePair = "he-ru", rarity = "RARE",
            original = "רִיפַקְטוֹרִינְג", transliteration = "refactoring", translation = "рефакторинг"),

        WordEntity(id = 129617, setId = 1296, languagePair = "he-ru", rarity = "RARE",
            original = "אִינְטֶגְרַצְיָה רְצִיפָה", transliteration = "integratsiya retsufa", translation = "непрерывная интеграция (CI)"),

        WordEntity(id = 129618, setId = 1296, languagePair = "he-ru", rarity = "RARE",
            original = "אוֹטוֹמַצְיַת בְּדִיקוֹת", transliteration = "otomatsiyat bdikot", translation = "автоматизация тестирования"),

        WordEntity(id = 129619, setId = 1296, languagePair = "he-ru", rarity = "RARE",
            original = "מִיגְרַצְיָה", transliteration = "migratsiya", translation = "миграция (данных / кода)"),

        WordEntity(id = 129620, setId = 1296, languagePair = "he-ru", rarity = "RARE",
            original = "פְּרָמֶטֶר פוּנְקְצִיָּה", transliteration = "parametr funktsiya", translation = "параметр функции"),

        WordEntity(id = 129621, setId = 1296, languagePair = "he-ru", rarity = "RARE",
            original = "רֶגְרֵסִיָּה", transliteration = "regressiya", translation = "регрессия (тестирование)"),

        WordEntity(id = 129622, setId = 1296, languagePair = "he-ru", rarity = "RARE",
            original = "מְשִׁימַת פִּיתּוּחַ", transliteration = "meshimat pituyakh", translation = "задача разработки (issue)"),

        WordEntity(id = 129623, setId = 1296, languagePair = "he-ru", rarity = "RARE",
            original = "מִזוּג קוֹד", transliteration = "mizug kod", translation = "слияние кода (merge)"),

        WordEntity(id = 129624, setId = 1296, languagePair = "he-ru", rarity = "RARE",
            original = "סְבִיבַת הַפְעָלָה", transliteration = "svivat haf'ala", translation = "производственная среда (прод)"),

        WordEntity(id = 129625, setId = 1296, languagePair = "he-ru", rarity = "RARE",
            original = "תַּשְׁתִּית הַקוֹד", transliteration = "tashtit hakod", translation = "кодовая база"),

        // ── Set 1297: Хай-тек: углублённый (level=3, RARE+EPIC) ─────────────

        WordEntity(id = 129701, setId = 1297, languagePair = "he-ru", rarity = "RARE",
            original = "מִיקְרוֹ-שֵׁרוּתִים", transliteration = "mikro-sherutim", translation = "микросервисы"),

        WordEntity(id = 129702, setId = 1297, languagePair = "he-ru", rarity = "RARE",
            original = "מַחְשׁוֹב קְצָה", transliteration = "makhshuv ktsа", translation = "граничные вычисления / edge computing"),

        WordEntity(id = 129703, setId = 1297, languagePair = "he-ru", rarity = "RARE",
            original = "מַכָּלוּת", transliteration = "makhalut", translation = "контейнеризация"),

        WordEntity(id = 129704, setId = 1297, languagePair = "he-ru", rarity = "RARE",
            original = "אוֹרְכֶסְטְרַצְיַת שֵׁרוּתִים", transliteration = "orkestratsiayat sherutim", translation = "оркестрация сервисов"),

        WordEntity(id = 129705, setId = 1297, languagePair = "he-ru", rarity = "RARE",
            original = "אִיזוּן עוֹמְסִים", transliteration = "izun ‌omasim", translation = "балансировка нагрузки"),

        WordEntity(id = 129706, setId = 1297, languagePair = "he-ru", rarity = "RARE",
            original = "יְכוֹלֶת הַרְחָבָה", transliteration = "yekolet harkhava", translation = "масштабируемость"),

        WordEntity(id = 129707, setId = 1297, languagePair = "he-ru", rarity = "RARE",
            original = "מַטְמוּן שֵׁרוּת", transliteration = "matmon sherut", translation = "кэширование сервиса"),

        WordEntity(id = 129708, setId = 1297, languagePair = "he-ru", rarity = "RARE",
            original = "תּוֹר הוֹדָעוֹת", transliteration = "tor hoda'ot", translation = "очередь сообщений"),

        WordEntity(id = 129709, setId = 1297, languagePair = "he-ru", rarity = "RARE",
            original = "אַרְכִיטֶקְטוּרַת אַחְזָקָה", transliteration = "arkhitektura akhzaka", translation = "событийно-ориентированная архитектура"),

        WordEntity(id = 129710, setId = 1297, languagePair = "he-ru", rarity = "RARE",
            original = "מוֹנִיטוֹרִינְג", transliteration = "monitoring", translation = "мониторинг"),

        WordEntity(id = 129711, setId = 1297, languagePair = "he-ru", rarity = "RARE",
            original = "רִישּׁוּם יּוֹמָן", transliteration = "rishum yoman", translation = "логирование"),

        WordEntity(id = 129712, setId = 1297, languagePair = "he-ru", rarity = "RARE",
            original = "בִּצּוּעִים", transliteration = "bitsui'im", translation = "производительность (системы)"),

        WordEntity(id = 129713, setId = 1297, languagePair = "he-ru", rarity = "EPIC",
            original = "אַרְכִיטֶקְטוּרָה", transliteration = "arkhitektura", translation = "архитектура (программная)"),

        WordEntity(id = 129714, setId = 1297, languagePair = "he-ru", rarity = "EPIC",
            original = "הַצְפָּנַת קוֹד", transliteration = "hatspanat kod", translation = "шифрование кода / данных"),

        WordEntity(id = 129715, setId = 1297, languagePair = "he-ru", rarity = "EPIC",
            original = "אִימוּת מִשְׁתַּמֵּשׁ", transliteration = "imut mishtamesh", translation = "аутентификация пользователя"),

        WordEntity(id = 129716, setId = 1297, languagePair = "he-ru", rarity = "EPIC",
            original = "הַרְשָׁאַת גִּישָׁה", transliteration = "harsha'at gisha", translation = "авторизация доступа"),

        WordEntity(id = 129717, setId = 1297, languagePair = "he-ru", rarity = "EPIC",
            original = "אֲסִימוֹן גִּישָׁה", transliteration = "asimon gisha", translation = "токен доступа"),

        WordEntity(id = 129718, setId = 1297, languagePair = "he-ru", rarity = "EPIC",
            original = "שְׁכַּבַת בֵּינַיִם", transliteration = "shkhavat benayim", translation = "middleware (промежуточный слой)"),

        WordEntity(id = 129719, setId = 1297, languagePair = "he-ru", rarity = "EPIC",
            original = "פוּנְקְצִיַּת גִּיבּוּב", transliteration = "funktsiyat gibub", translation = "хэш-функция"),

        WordEntity(id = 129720, setId = 1297, languagePair = "he-ru", rarity = "EPIC",
            original = "שֵׁרוּת REST", transliteration = "sherut REST", translation = "REST-сервис"),

        WordEntity(id = 129721, setId = 1297, languagePair = "he-ru", rarity = "EPIC",
            original = "שְׁאֵלָתָת GraphQL", transliteration = "she'eltat GraphQL", translation = "GraphQL-запрос"),

        WordEntity(id = 129722, setId = 1297, languagePair = "he-ru", rarity = "EPIC",
            original = "DevOps", transliteration = "DevOps", translation = "DevOps (методология разработки и эксплуатации)"),

        WordEntity(id = 129723, setId = 1297, languagePair = "he-ru", rarity = "EPIC",
            original = "פְּרִיסָה רְצִיפָה", transliteration = "prisa retsufa", translation = "непрерывное развёртывание (CD)"),

        WordEntity(id = 129724, setId = 1297, languagePair = "he-ru", rarity = "EPIC",
            original = "שִׁבּוּשׁ אַחְזָקָה", transliteration = "shibush akhzaka", translation = "сбой в работе сервиса"),

        WordEntity(id = 129725, setId = 1297, languagePair = "he-ru", rarity = "EPIC",
            original = "סוֹקֵר אֲבְטָחָה", transliteration = "soker avtakha", translation = "аудит безопасности"),

        // ── Set 1298: Хай-тек: профессиональный (level=4, EPIC+LEGENDARY) ───

        WordEntity(id = 129801, setId = 1298, languagePair = "he-ru", rarity = "EPIC",
            original = "תַּבְנִיּוֹת אַרְכִיטֶקְטוּרָה", transliteration = "tavniyot arkhitektura", translation = "архитектурные паттерны"),

        WordEntity(id = 129802, setId = 1298, languagePair = "he-ru", rarity = "EPIC",
            original = "עִצּוּב מוּנְחֶה-תְּחוּמִים", transliteration = "itsub munkhe-tkhumim", translation = "доменно-ориентированное проектирование (DDD)"),

        WordEntity(id = 129803, setId = 1298, languagePair = "he-ru", rarity = "EPIC",
            original = "הַפְרָדַת פְּקוּדָה-שְׁאֵלָה", transliteration = "hafradat pkuda-she'ela", translation = "CQRS (разделение команд и запросов)"),

        WordEntity(id = 129804, setId = 1298, languagePair = "he-ru", rarity = "EPIC",
            original = "מָקוֹר אַחְזָקָה", transliteration = "makor akhzaka", translation = "event sourcing (источник событий)"),

        WordEntity(id = 129805, setId = 1298, languagePair = "he-ru", rarity = "EPIC",
            original = "מַעֲרֶכֶת מְבוּזֶּרֶת", transliteration = "ma'arekhet mevuzeret", translation = "распределённая система"),

        WordEntity(id = 129806, setId = 1298, languagePair = "he-ru", rarity = "EPIC",
            original = "קוֹנְסֶנְסוּס מְבוּזָּר", transliteration = "konsensus mevuzar", translation = "распределённый консенсус"),

        WordEntity(id = 129807, setId = 1298, languagePair = "he-ru", rarity = "EPIC",
            original = "מֵשֶׁק עִמּוּד", transliteration = "meshek imud", translation = "пропускная способность (throughput)"),

        WordEntity(id = 129808, setId = 1298, languagePair = "he-ru", rarity = "EPIC",
            original = "הֶחְלֵפַת הֶקְשֵׁר", transliteration = "hekhliefat heksher", translation = "переключение контекста (context switching)"),

        WordEntity(id = 129809, setId = 1298, languagePair = "he-ru", rarity = "EPIC",
            original = "חוֹב תַּשְׁתִּיתִי", transliteration = "khov tashtiti", translation = "технический инфраструктурный долг"),

        WordEntity(id = 129810, setId = 1298, languagePair = "he-ru", rarity = "EPIC",
            original = "הֶסְכֵּם רָמַת שֵׁרוּת", transliteration = "heskem ramat sherut", translation = "SLA (соглашение об уровне сервиса)"),

        WordEntity(id = 129811, setId = 1298, languagePair = "he-ru", rarity = "EPIC",
            original = "יַעַד רָמַת שֵׁרוּת", transliteration = "ya'ad ramat sherut", translation = "SLO (цель уровня сервиса)"),

        WordEntity(id = 129812, setId = 1298, languagePair = "he-ru", rarity = "EPIC",
            original = "רָדַאר טֶכְנוֹלוֹגִי", transliteration = "radar tekhnologi", translation = "технологический радар"),

        WordEntity(id = 129813, setId = 1298, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תֶּאוֹרֶם CAP", transliteration = "te'orem CAP", translation = "теорема CAP (согласованность, доступность, разделение)"),

        WordEntity(id = 129814, setId = 1298, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "הַתְכַּנְסוּת אַרְכִיטֶקְטוּרָה", transliteration = "hitkansut arkhitektura", translation = "конвергенция архитектуры"),

        WordEntity(id = 129815, setId = 1298, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "סְטִיַּת אַרְכִיטֶקְטוּרָה", transliteration = "stiytayat arkhitektura", translation = "дивергенция / дрейф архитектуры"),

        WordEntity(id = 129816, setId = 1298, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "עֵרֶךְ עֵסְקִי", transliteration = "erekh iski", translation = "бизнес-ценность (продукта)"),

        WordEntity(id = 129817, setId = 1298, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "הַנְדָּסַת אֲמִינוּת אֲתָרִים", transliteration = "handsat aminut atarim", translation = "SRE (Site Reliability Engineering)"),

        WordEntity(id = 129818, setId = 1298, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "אַבְטָחַת מֵידָע", transliteration = "avtakhat meida", translation = "информационная безопасность"),

        WordEntity(id = 129819, setId = 1298, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "כֶּשֶׁל יְחִיד", transliteration = "keshal yekhid", translation = "единая точка отказа (SPOF)"),

        WordEntity(id = 129820, setId = 1298, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "חוֹלְשׁוֹת אַרְכִיטֶקְטוּרָה", transliteration = "kholshot arkhitektura", translation = "архитектурные уязвимости"),

        WordEntity(id = 129821, setId = 1298, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מֵטְרִיקוֹת עֵסְקִיּוֹת", transliteration = "metrикot iskiyot", translation = "бизнес-метрики"),

        WordEntity(id = 129822, setId = 1298, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "שַׁיִּישׁ נְתוּנִים", transliteration = "shayish netunin", translation = "шардирование данных"),

        WordEntity(id = 129823, setId = 1298, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "כִּיוּל מַעֲרֶכֶת", transliteration = "kiyul ma'arekhet", translation = "калибровка системы"),

        WordEntity(id = 129824, setId = 1298, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "הַסְכָּמַת פְּלַטְפוֹרְמָה", transliteration = "haskamat platforma", translation = "аттестация платформы"),

        WordEntity(id = 129825, setId = 1298, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "פֶּדֶרַצְיַת שֵׁרוּתִים", transliteration = "federatsiyat sherutim", translation = "федерация сервисов"),

        // ── Set 1299: Хай-тек: носитель языка (level=5, LEGENDARY) ─────────

        WordEntity(id = 129901, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מֶרְחָב בְּעָיוֹת תּוֹכְנָה", transliteration = "merkhav be'ayot tokhna", translation = "проблемное пространство (software)"),

        WordEntity(id = 129902, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "הִתְפַּתְּחוּת מְאֻחֶדֶת פְּלַטְפוֹרְמוֹת", transliteration = "hitpatkhut me'ukhedet platformot", translation = "конвергентная эволюция платформ"),

        WordEntity(id = 129903, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "פָּרָדִיגְמָה הַנְדָּסִית", transliteration = "paradigma handasit", translation = "инженерная парадигма"),

        WordEntity(id = 129904, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תּוֹדָעָה מְחַקֶּרֶת", transliteration = "toda'a mekhakeret", translation = "рефлексивность системы"),

        WordEntity(id = 129905, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מֶטָ-תִּכְנוּת", transliteration = "meta-tikhnun", translation = "метапрограммирование"),

        WordEntity(id = 129906, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "אוֹנְטוֹלוֹגְיַת נְתוּנִים", transliteration = "ontologiyat netunin", translation = "онтология данных"),

        WordEntity(id = 129907, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "אֶפִּיסְטֵמוֹלוֹגְיַת הַנְדָּסָה", transliteration = "epistemologiyat handasa", translation = "эпистемология инженерии"),

        WordEntity(id = 129908, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תַּאֵּם תַּהֲלִיכִים", transliteration = "ta'em tahallikhim", translation = "ортогональность процессов"),

        WordEntity(id = 129909, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מַעֲרֶכֶת אֶמֶרְגֶּנְטִית", transliteration = "ma'arekhet emergentit", translation = "эмерджентная система"),

        WordEntity(id = 129910, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תְּאוֹרְיַת הַמַּעֲרָכוֹת הַמְּסוּבָּכוֹת", transliteration = "teoriyat hama'arakhot hamesubakoт", translation = "теория сложных систем"),

        WordEntity(id = 129911, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "שִׁינּוּי פָּרָדִיגְמָטִי", transliteration = "shinui paradigmati", translation = "парадигматический сдвиг"),

        WordEntity(id = 129912, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "הִסְתָּגְלוּת מַעֲרֶכֶת", transliteration = "histaglut ma'arekhet", translation = "адаптивность системы"),

        WordEntity(id = 129913, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "קַטָסְטְרוֹפִיּוּת מִדַּעִית", transliteration = "katastrofiyut mida'it", translation = "катастрофичность при масштабировании"),

        WordEntity(id = 129914, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "הַנְדָּסַת הִסָּיוּן", transliteration = "handsat hisayun", translation = "инженерия умозаключений (inference engineering)"),

        WordEntity(id = 129915, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "בִּינָה מֵחַקֶּרֶת", transliteration = "bina mekhakeret", translation = "рефлексивный интеллект"),

        WordEntity(id = 129916, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תְּאוֹרְיַת הַסִּבּוּכִיּוּת", transliteration = "teoriyat hasivukhiyut", translation = "теория вычислительной сложности"),

        WordEntity(id = 129917, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "עֲקְרוֹנוֹת הַהַנְדָּסָה הַרַּכָּה", transliteration = "ikronot hahhandasa haraka", translation = "принципы разработки ПО"),

        WordEntity(id = 129918, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "כָּלְכָּלַת פְּלַטְפוֹרְמוֹת", transliteration = "kalkala platformot", translation = "экономика платформ"),

        WordEntity(id = 129919, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "פִּילוֹסוֹפִיַּת מֶחְקַר הַמַּחְשׁוֹב", transliteration = "filosofiyat mekhkar hamakhshuv", translation = "философия компьютерных наук"),

        WordEntity(id = 129920, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "סוֹצְיוֹ-טֶכְנִי", transliteration = "sotsyo-tekhni", translation = "социотехнический (подход)"),

        WordEntity(id = 129921, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "שִׁיח הַדִּיגִיטַל", transliteration = "siakh hadigital", translation = "дискурс цифровизации"),

        WordEntity(id = 129922, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "גּוּשׁ קוֹד עַצְמִי", transliteration = "gush kod atsmi", translation = "самомодифицирующийся код"),

        WordEntity(id = 129923, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תְּכוּנוֹת אֶמֶרְגֶּנְטִיּוֹת", transliteration = "tekhnunot emergentiyot", translation = "эмерджентные свойства системы"),

        WordEntity(id = 129924, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תְּלוּת הַמַּעֲרֶכֶת", transliteration = "telut hama'arekhet", translation = "зависимость / связность системы"),

        WordEntity(id = 129925, setId = 1299, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "קוּבְּיָה שְׁחוֹרָה", transliteration = "kuvya shekhora", translation = "чёрный ящик (принцип в инженерии)"),
    )
}
