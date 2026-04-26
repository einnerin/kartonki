package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Хайтек", уровень 4 (профессиональный).
 *
 * Set 1748: «Хайтек» — профессиональный L4 (EPIC + LEGENDARY).
 * Узкоспециальная лексика инфраструктуры, продуктовой работы и стратегии:
 * DevOps, мониторинг, продуктовые метрики, продакт-менеджмент, безопасность.
 *
 * Целевая аудитория — русскоязычные репатрианты в Израиле, работающие
 * в хайтеке (инженеры, продакты, тимлиды). Лексика двуязычная: иврит +
 * множество английских заимствований (סִי-אַי-סִי-דִּי, פַּייפְּלַיין, דַּשְׁבּוֹרְד,
 * רוֹדְמָאפּ, פִיצֶ׳ר פְלַג, פֶּנְ-טֶסְט) — так реально говорят на стендапах
 * и митингах в израильских стартапах.
 *
 * Распределение редкостей:
 *   13 EPIC + 12 LEGENDARY (без выхода за 2 смежных уровня).
 *
 * SemanticGroups (5 × 5):
 *   hightech_devops      — CI/CD, пайплайн деплоя, IaC, скрипт автоматизации, артефакт сборки
 *   hightech_monitoring  — алерт, дашборд, healthcheck, лог-агрегация, инцидент в проде
 *   hightech_metrics     — KPI, OKR, retention, churn, NPS
 *   hightech_product     — roadmap, stakeholder, gating, A/B-тест, фиче-флаг
 *   hightech_security    — пентест, уязвимость, шифрование, аудит безопасности, GDPR
 *
 * Word IDs: setId × 100 + position (174801..174825).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewHightechL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1748, languagePair = "he-ru", orderIndex = 1748,
            name = "Хайтек",
            description = "Инфраструктура и продукт: DevOps, мониторинг, KPI, метрики",
            topic = "Хайтек", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1748 — Хайтек: профессиональный (L4, EPIC + LEGENDARY)
        // 5 групп × 5 слов: devops, monitoring, metrics, product, security
        // ══════════════════════════════════════════════════════════════════════

        // ── hightech_devops (5) — конвейер разработки и доставки кода ──
        WordEntity(
            id = 174801, setId = 1748, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_devops", transliteration = "si-ai-si-di",
            original = "סִי-אַי-סִי-דִּי", translation = "CI/CD",
            definition = "תַּהֲלִיךְ אוֹטוֹמָטִי שֶׁבּוֹדֵק קוֹד חָדָשׁ וּמַעֲלֶה אוֹתוֹ לַשֶּׁרֶת בְּלִי הִתְעָרְבוּת אִישִׁית.",
            definitionNative = "Автоматический процесс — проверяет новый код и катит на сервер без рук человека.",
            example = "סִי-אַי-סִי-דִּי בְּחֶבְרָה שֶׁלָּנוּ רָץ עַל גִ׳יטְהָאבּ אַקְשֶׁנְס.",
            exampleNative = "סִי-אַי-סִי-דִּי в нашей фирме работает на GitHub Actions.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174802, setId = 1748, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_devops", transliteration = "paiplain deploy",
            original = "פַּייפְּלַיין דֵּפְּלוֹי", translation = "пайплайн деплоя",
            definition = "שַׁרְשֶׁרֶת שֶׁל שְׁלַבִּים אַחֲרֵי מִיזּוּג קוֹד עַד שֶׁהַגִּרְסָה הַחֲדָשָׁה רָצָה אֵצֶל לָקוֹחוֹת.",
            definitionNative = "Цепочка шагов после слияния кода — пока новая версия не работает у клиентов.",
            example = "פַּייפְּלַיין דֵּפְּלוֹי נִתְקַע בִּשְׁלַב הַבְּדִיקוֹת בִּגְלַל סְפְּרִיג חָדָשׁ.",
            exampleNative = "פַּייפְּלַיין דֵּפְּלוֹי застрял на тестах из-за нового спринта.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174803, setId = 1748, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "hightech_devops", transliteration = "infrastruktura ke-kod",
            original = "אִינְפְרַסְטְרוּקְטוּרָה כְּקוֹד", translation = "infrastructure as code (IaC)",
            definition = "גִּישָׁה שֶׁבָּהּ שְׁרָתִים, רְשָׁתוֹת וּמַאֲגָרִים מֻגְדָּרִים בְּקֹבֶץ טֶקְסְט שֶׁמְּנוּהָל בִּגְ׳יט.",
            definitionNative = "Подход: серверы, сети и БД описаны в текстовом файле под Git-управлением.",
            example = "מַעֲבָר לְאִינְפְרַסְטְרוּקְטוּרָה כְּקוֹד חָסַךְ לָנוּ שָׁעוֹת קוֹנְפִיגוּרַצְיָה יָדָנִית.",
            exampleNative = "Переход на אִינְפְרַסְטְרוּקְטוּרָה כְּקוֹד сэкономил часы ручной настройки.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174804, setId = 1748, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_devops", transliteration = "skript otomatsya",
            original = "סְקְרִיפְט אוֹטוֹמַצְיָה", translation = "скрипт автоматизации",
            definition = "קֹבֶץ קָצָר שֶׁמְּבַצֵּעַ פְּעֻלּוֹת חוֹזְרוֹת בְּלִי שֶׁמְהַנְדֵס יִכְתֹּב כָּל פַּעַם פְּקֻדָּה.",
            definitionNative = "Короткий файл — повторяет рутинные действия, чтобы инженер не вводил команду каждый раз.",
            example = "כָּתַבְתִּי סְקְרִיפְט אוֹטוֹמַצְיָה שֶׁמְּגַבֶּה אֶת הַמַּאֲגָר כָּל לַיְלָה.",
            exampleNative = "Я написал סְקְרִיפְט אוֹטוֹמַצְיָה — бэкапит базу каждой ночью.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174805, setId = 1748, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "hightech_devops", transliteration = "artefakt bniya",
            original = "אַרְטֵפַקְט בְּנִיָּה", translation = "артефакт сборки",
            definition = "קֹבֶץ סוֹפִי שֶׁיּוֹצֵא מִשְּׁלַב הַקּוֹמְפִּילַצְיָה וּמוּכָן לַהַעֲלָאָה לַסְּבִיבָה הַחַיָּה.",
            definitionNative = "Финальный файл из стадии компиляции — готов уехать на боевое окружение.",
            example = "אַרְטֵפַקְט בְּנִיָּה נִשְׁמָר בָּרֶגִיסְטְרִי הַפְּרָטִי שֶׁל הַחֶבְרָה.",
            exampleNative = "אַרְטֵפַקְט בְּנִיָּה хранится в приватном реестре фирмы.",
            isFillInBlankSafe = false,
        ),

        // ── hightech_monitoring (5) — наблюдение за продакшеном ──
        WordEntity(
            id = 174806, setId = 1748, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_monitoring", transliteration = "alert",
            original = "אַלֶרְט", translation = "алерт",
            definition = "הוֹדָעָה אוֹטוֹמָטִית שֶׁנִּשְׁלַחַת לְצֶוֶות כְּשֶׁמַּשֶּׁהוּ בָּרֶכֶת חוֹרֵג מֵהַסַּף הַתַּקִּין.",
            definitionNative = "Автоматическое сообщение команде — когда что-то в системе вышло за нормальный порог.",
            example = "אַלֶרְט הִתְקַבֵּל בַּסְּלֶק בִּשְׁתַּיִם בַּלַּיְלָה עַל זִכָּרוֹן מָלֵא.",
            exampleNative = "אַלֶרְט пришёл в Slack в два ночи — про забитую память.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174807, setId = 1748, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_monitoring", transliteration = "dashbord",
            original = "דַּשְׁבּוֹרְד", translation = "дашборд",
            definition = "מָסָךְ אֶחָד שֶׁמְּרַכֵּז גְּרָפִים וּמַסְפָּרִים חַיִּים עַל מַצַּב הַמַּעֲרֶכֶת בְּזְמַן אֱמֶת.",
            definitionNative = "Один экран — собирает живые графики и числа о состоянии системы прямо сейчас.",
            example = "דַּשְׁבּוֹרְד שֶׁל גְּרָפָנָה הֶרְאָה זִנּוּק חַד בְּלָאטֶנְסִי.",
            exampleNative = "דַּשְׁבּוֹרְד в Grafana показал резкий скачок latency.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174808, setId = 1748, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "hightech_monitoring", transliteration = "heltschek",
            original = "הֶלְת׳צֶ׳ק", translation = "healthcheck",
            definition = "פְּנִיָּה תְּקוּפָתִית קְצָרָה לַשֶּׁרֶת שֶׁבּוֹדֶקֶת אִם הוּא חַי וְעוֹנֶה כָּרָאוּי.",
            definitionNative = "Короткий регулярный запрос на сервер — жив ли он и отвечает ли как надо.",
            example = "הֶלְת׳צֶ׳ק נִכְשַׁל שָׁלוֹשׁ פְּעָמִים בָּרְצִיפוּת וְהַשֶּׁרֶת אֻתְחַל אוֹטוֹמָטִית.",
            exampleNative = "הֶלְת׳צֶ׳ק упал три раза подряд — сервер автоматически перезапустился.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174809, setId = 1748, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "hightech_monitoring", transliteration = "agregatsyat logim",
            original = "אַגְרֵגַצְיַת לוֹגִים", translation = "лог-агрегация",
            definition = "אִחוּד שׁוּרוֹת מֵהַרְבֵּה שְׁרָתִים לִמְקוֹם אֶחָד שֶׁבּוֹ קַל לְחַפֵּשׂ וּלְסַנֵּן.",
            definitionNative = "Объединение строк со многих серверов в одно место — где удобно искать и фильтровать.",
            example = "אַגְרֵגַצְיַת לוֹגִים בְּאֵלַסְטִיק הִקְפִּיצָה אֶת מְהִירוּת הַחֲקִירָה שֶׁל בָּגִים.",
            exampleNative = "אַגְרֵגַצְיַת לוֹגִים в Elastic ускорила расследование багов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174810, setId = 1748, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_monitoring", transliteration = "takala biprodakshen",
            original = "תַּקָּלָה בִּפְרוֹדַקְשֶׁן", translation = "инцидент в проде",
            definition = "אֵרוּעַ חָמוּר בַּסְּבִיבָה הַחַיָּה שֶׁדּוֹרֵשׁ צֶוֶות תּוֹרָנוּת לִתְקֹן מִיָּד.",
            definitionNative = "Серьёзное событие на боевом окружении — дежурная команда чинит немедленно.",
            example = "תַּקָּלָה בִּפְרוֹדַקְשֶׁן הִשְׁבִּיתָה אֶת הַתַּשְׁלוּמִים לְשָׁעָה שְׁלֵמָה.",
            exampleNative = "תַּקָּלָה בִּפְרוֹדַקְשֶׁן положила платежи на целый час.",
            isFillInBlankSafe = false,
        ),

        // ── hightech_metrics (5) — продуктовые метрики и цели ──
        WordEntity(
            id = 174811, setId = 1748, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_metrics", transliteration = "kei-pi-ai",
            original = "קֵיי-פִּי-אַיי", translation = "KPI",
            definition = "מַדָּד מַסְפָּרִי קָבוּעַ שֶׁבּוֹדֵק עַד כַּמָּה מַחְלָקָה מַשִּׂיגָה אֶת הַיַּעַד הָעִקָּרִי שֶׁלָּהּ.",
            definitionNative = "Постоянный числовой индикатор — насколько отдел двигает свою главную цель.",
            example = "קֵיי-פִּי-אַיי שֶׁל הַצֶּוֶות הָיָה לְהוֹרִיד אֶת זְמַן הַתְּגוּבָה.",
            exampleNative = "Командный KPI был — снизить время ответа.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174812, setId = 1748, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "hightech_metrics", transliteration = "o-kei-ar",
            original = "אוֹ-קֵיי-אַר", translation = "OKR",
            definition = "מִסְגֶּרֶת רְבְעוֹנִית שֶׁל יַעַד שְׁאַפְתָּנִי וּכְמַסְפָּר תּוֹצָאוֹת מְדִידוֹת לְבִיצּוּעוֹ.",
            definitionNative = "Квартальная рамка: амбициозная цель плюс несколько измеримых результатов под неё.",
            example = "אוֹ-קֵיי-אַר שֶׁל הָרֹבַע נִקְבְּעוּ מוּל סְמַנְכַּ״ל הַמּוּצָר.",
            exampleNative = "אוֹ-קֵיי-אַר на квартал согласовали с VP Product.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174813, setId = 1748, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_metrics", transliteration = "shimur mishtamshim",
            original = "שִׁמּוּר מִשְׁתַּמְּשִׁים", translation = "retention",
            definition = "אָחוּז הָאַנָשִׁים שֶׁמַּמְשִׁיכִים לְהִכָּנֵס לַמּוּצָר אַחֲרֵי שָׁבוּעַ אוֹ חֹדֶשׁ.",
            definitionNative = "Доля людей, которые продолжают заходить в продукт через неделю или месяц.",
            example = "שִׁמּוּר מִשְׁתַּמְּשִׁים יָרַד מִשְּׁלוֹשִׁים אָחוּז לְעֶשְׂרִים אַחֲרֵי הָעִדְכּוּן.",
            exampleNative = "שִׁמּוּר מִשְׁתַּמְּשִׁים упал с тридцати процентов до двадцати после апдейта.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174814, setId = 1748, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_metrics", transliteration = "netishat mishtamshim",
            original = "נְטִישַׁת מִשְׁתַּמְּשִׁים", translation = "churn",
            definition = "אָחוּז הַלָּקוֹחוֹת שֶׁמַּפְסִיקִים לְשַׁלֵּם אוֹ לְהִכָּנֵס בְּתוֹךְ פֶּרֶק זְמַן מֻגְדָּר.",
            definitionNative = "Доля клиентов, переставших платить или заходить за определённый период.",
            example = "נְטִישַׁת מִשְׁתַּמְּשִׁים גָּבוֹהַּ סִמֵּן לְבַעֲיָה בִּשְׁלַב הָאוֹנְבּוֹרְדִּינְג.",
            exampleNative = "Высокий נְטִישַׁת מִשְׁתַּמְּשִׁים указал на проблему в онбординге.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174815, setId = 1748, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "hightech_metrics", transliteration = "en-pi-es",
            original = "אֶן-פִּי-אֵס", translation = "NPS",
            definition = "צִיּוּן בֵּין מָאתַיִם פְּלוּס לְמָאתַיִם מִינוּס שֶׁבּוֹדֵק כַּמָּה הַלָּקוֹחוֹת מַמְלִיצִים עַל הַמּוּצָר.",
            definitionNative = "Балл от минус ста до плюс ста — насколько клиенты рекомендуют продукт другим.",
            example = "אֶן-פִּי-אֵס עָלָה לְאַרְבָּעִים אַחֲרֵי שֶׁשִּׁפַּרְנוּ אֶת הַתְּמִיכָה.",
            exampleNative = "אֶן-פִּי-אֵס вырос до сорока после того как мы улучшили поддержку.",
            isFillInBlankSafe = false,
        ),

        // ── hightech_product (5) — продуктовая работа и эксперименты ──
        WordEntity(
            id = 174816, setId = 1748, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_product", transliteration = "rodmap",
            original = "רוֹדְמָאפּ", translation = "roadmap",
            definition = "מַסְמָךְ שֶׁמַּרְאֶה אֵיזוֹ פִיצֶ׳רִים יַגִּיעוּ בְּכָל רֹבַע בַּחֲצִי שָׁנָה הַקְּרוֹבָה.",
            definitionNative = "Документ, какие фичи приедут в каждом квартале на ближайшие полгода.",
            example = "רוֹדְמָאפּ לִשְׁנַת אַלְפַּיִם עֶשְׂרִים וְשֶׁבַע פֻּרְסַם בְּתוֹם נוֹטְיוֹן.",
            exampleNative = "רוֹדְמָאפּ на двадцать седьмой год опубликовали в общем Notion.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174817, setId = 1748, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "hightech_product", transliteration = "steykholder",
            original = "סְטֵייקְהוֹלְדֶר", translation = "stakeholder",
            definition = "אִישׁ פְּנִימִי בָּעֵסֶק שֶׁיֵּשׁ לוֹ אִינְטֶרֶס יָשִׁיר בְּהַצְלָחַת מַשֶּׁהוּ שֶׁמְּפַתְחִים.",
            definitionNative = "Внутренний человек в бизнесе, у которого прямой интерес в успехе разработки.",
            example = "כָּל סְטֵייקְהוֹלְדֶר אִשֵּׁר אֶת הַמִּפְרָט לִפְנֵי תְּחִילַת הַסְּפְּרִינְט.",
            exampleNative = "Каждый סְטֵייקְהוֹלְדֶר утвердил спецификацию до старта спринта.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174818, setId = 1748, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "hightech_product", transliteration = "geyting",
            original = "גֵּייטִינְג", translation = "gating (ограничение фичи)",
            definition = "חֲסִימָה זְמַנִּית שֶׁל יְכֹלֶת חֲדָשָׁה רַק לִקְבוּצַת מִשְׁתַּמְּשִׁים מְצֻמְצֶמֶת לְבַדִּיקָה.",
            definitionNative = "Временное закрытие новой возможности — только для маленькой группы пользователей на пробу.",
            example = "גֵּייטִינְג שֶׁל הַיְּכֹלֶת הַחֲדָשָׁה נִפְתַּח רַק לְמִיכוּן וְצָפוֹן.",
            exampleNative = "גֵּייטִינְג новой функции открыли только для центра и севера.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174819, setId = 1748, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_product", transliteration = "ei-bi test",
            original = "אֵיי-בִּי טֶסְט", translation = "A/B-тест",
            definition = "הַשְׁוָאָה בֵּין שְׁתֵּי גִּרְסָאוֹת שֶׁל מָסָךְ כְּדֵי לִרְאוֹת אֵיזוֹ מַבִּיאָה תּוֹצָאָה טוֹבָה יוֹתֵר.",
            definitionNative = "Сравнение двух версий экрана — какая даёт лучший результат.",
            example = "אֵיי-בִּי טֶסְט עַל כַּפְתּוֹר הָרִשּׁוּם הִרְאָה הֶבְדֵּל שֶׁל שְׁמוֹנָה אָחוּז.",
            exampleNative = "אֵיי-בִּי טֶסְט на кнопке регистрации показал разницу в восемь процентов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174820, setId = 1748, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "hightech_product", transliteration = "ficher flag",
            original = "פִיצֶ׳ר פְלַג", translation = "фиче-флаг",
            definition = "מַתְגֵּן בַּקּוֹד שֶׁמַּפְעִיל אוֹ מְכַבֶּה יְכוֹלוֹת בְּלִי לְשַׁחְרֵר גִּרְסָה חֲדָשָׁה.",
            definitionNative = "Переключатель в коде — включает или выключает функции без выпуска новой версии.",
            example = "פִיצֶ׳ר פְלַג אִפְשֵׁר לָנוּ לְהַחֲזִיר אֶת הַשִּׁנּוּי תּוֹךְ דַּקָּה.",
            exampleNative = "פִיצֶ׳ר פְלַג позволил откатить изменение за минуту.",
            isFillInBlankSafe = false,
        ),

        // ── hightech_security (5) — безопасность и аудит ──
        WordEntity(
            id = 174821, setId = 1748, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_security", transliteration = "pen-test",
            original = "פֶּנְ-טֶסְט", translation = "пентест",
            definition = "בְּדִיקָה מְכֻוֶּנֶת שֶׁבָּהּ אִישׁ חִיצוֹנִי מְנַסֶּה לְפְרֹץ לַמַּעֲרֶכֶת כְּדֵי לִמְצֹא חוּלְשׁוֹת.",
            definitionNative = "Целевая проверка: внешний человек ломает систему, чтобы найти слабые места.",
            example = "פֶּנְ-טֶסְט שְׁנָתִי גִּלָּה שָׁלוֹשׁ חוּלְשׁוֹת קְרִיטִיּוֹת בַּסֶּרְוֵוס.",
            exampleNative = "Ежегодный פֶּנְ-טֶסְט выявил три критические дыры в сервисе.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174822, setId = 1748, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "hightech_security", transliteration = "pirtsat avtakha",
            original = "פִּרְצַת אַבְטָחָה", translation = "уязвимость",
            definition = "חוֹר בַּקּוֹד אוֹ בַּהַגְדָּרוֹת שֶׁמְּאַפְשֵׁר לְזָר לַעֲשׂוֹת מַשֶּׁהוּ שֶׁאָסוּר.",
            definitionNative = "Дыра в коде или настройках — даёт постороннему сделать запрещённое действие.",
            example = "פִּרְצַת אַבְטָחָה בַּסִּפְרִיָּה הַחִיצוֹנִית גָּרְמָה לְפַאצְ׳ דָּחוּף.",
            exampleNative = "פִּרְצַת אַבְטָחָה во внешней библиотеке вызвала срочный патч.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174823, setId = 1748, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_security", transliteration = "iyumey sayber",
            original = "אִיּוּמֵי סַייבֶּר", translation = "киберугрозы",
            definition = "סִכּוּנִים שֶׁתּוֹקְפִים מַעֲרֶכֶת מֵרֶשֶׁת — נִסְיוֹנוֹת פְּרִיצָה, גְּנֵבַת מֵידָע אוֹ שִׁבּוּשׁ.",
            definitionNative = "Сетевые риски — попытки взлома, кражи данных или нарушения работы системы.",
            example = "צֶוֶות הָאַבְטָחָה מְנַטֵּר אִיּוּמֵי סַייבֶּר בִּזְמַן אֱמֶת מִכָּל הָאֲזוֹרִים.",
            exampleNative = "Команда безопасности отслеживает אִיּוּמֵי סַייבֶּר в реальном времени со всех регионов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174824, setId = 1748, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "hightech_security", transliteration = "mivdak avtakha",
            original = "מִבְדַּק אַבְטָחָה", translation = "аудит безопасности",
            definition = "סְקִירָה רִשְׁמִית שֶׁל מְבַקֵּר חִיצוֹנִי עַל הַקּוֹד וְהַתַּהֲלִיכִים לְפִי תֶּקֶן מֻגְדָּר.",
            definitionNative = "Официальный обзор внешним проверяющим — кода и процессов по заданному стандарту.",
            example = "מִבְדַּק אַבְטָחָה לִקְרַאת הָעֲלָאָה לַעֲנָן נִמְשַׁךְ שִׁשָּׁה שָׁבוּעוֹת.",
            exampleNative = "מִבְדַּק אַבְטָחָה перед переездом в облако длился шесть недель.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174825, setId = 1748, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "hightech_security", transliteration = "ji-di-pi-ar",
            original = "גִ׳י-דִּי-פִּי-אַר", translation = "GDPR",
            definition = "תַּקָּנָה אֵירוֹפֵּית שֶׁמְּחַיֶּבֶת חֶבְרוֹת לְהָגֵן עַל מֵידָע אִישִׁי שֶׁל אֶזְרָחֵי הַיַּבֶּשֶׁת.",
            definitionNative = "Европейский регламент — обязывает фирмы защищать персональные данные граждан континента.",
            example = "גִ׳י-דִּי-פִּי-אַר חִיֵּב אוֹתָנוּ לְהוֹסִיף בַּקָּשַׁת הַסְכָּמָה לְלִקּוּט מֵידָע.",
            exampleNative = "גִ׳י-דִּי-פִּי-אַר обязал нас добавить запрос согласия на сбор данных.",
            isFillInBlankSafe = false,
        ),
    )
}
