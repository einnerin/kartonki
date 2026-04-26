package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Data Engineering", уровень 4 (профессиональный).
 *
 * Set 1764: «Data Engineering» — профессиональный L4 (EPIC + LEGENDARY).
 * Продакшен-лексика дата-инжиниринга: real-time стриминг, serving-слой,
 * data governance, продвинутые проверки качества и состав команды.
 *
 * Целевая аудитория — русскоязычные репатрианты в Израиле, работающие
 * с дата-платформами (data engineer, analytics engineer, data architect).
 * Лексика двуязычная: иврит + английские заимствования (קָאפְקָה, סִי-דִּי-סִי,
 * אוֹלָאפּ, דָּאטָה קָטָלוֹג, אֲנָלִיטִיקְס אֶנְגִ׳נְיֶר) — так реально говорят
 * на инфраструктурных стендапах в израильских компаниях.
 *
 * Распределение редкостей:
 *   13 EPIC + 12 LEGENDARY (без выхода за 2 смежных уровня).
 *
 * SemanticGroups (5 × 5):
 *   de_realtime          — Kafka, очередь сообщений, exactly-once, CDC, stream processing
 *   de_serving           — serving layer, materialized view, OLAP, OLTP, оптимизация запросов
 *   de_governance        — каталог, lineage, discovery, контракт данных, data steward
 *   de_quality_advanced  — anomaly detection, freshness, completeness, consistency, profiling
 *   de_team              — data engineer, analytics engineer, data architect, platform team, on-call
 *
 * Word IDs: setId × 100 + position (176401..176425).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewDataEngL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1764, languagePair = "he-ru", orderIndex = 1764,
            name = "Data Engineering",
            description = "Продакшен: real-time, serving, governance, мониторинг качества",
            topic = "Data Engineering", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1764 — Data Engineering: профессиональный (L4, EPIC + LEGENDARY)
        // 5 групп × 5 слов: realtime, serving, governance, quality_advanced, team
        // ══════════════════════════════════════════════════════════════════════

        // ── de_realtime (5) — потоковая обработка и доставка событий ──
        WordEntity(
            id = 176401, setId = 1764, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_realtime", transliteration = "kafka",
            original = "קָאפְקָה", translation = "Kafka",
            definition = "פְּלַטְפוֹרְמָה לְהַעֲבָרַת אֵירוּעִים בִּזְמַן אֱמֶת בֵּין מַעֲרָכוֹת בְּלִי לְאַבֵּד הוֹדָעוֹת.",
            definitionNative = "Платформа для передачи событий в реальном времени между сервисами без потери сообщений.",
            example = "קָאפְקָה מַעֲבִירָה אֶצְלֵנוּ עֶשְׂרִים אֶלֶף אֵירוּעִים בְּשְׁנִיָּה בִּשְׁעוֹת הַשִּׂיא.",
            exampleNative = "קָאפְקָה прокачивает у нас двадцать тысяч событий в секунду в часы пик.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176402, setId = 1764, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_realtime", transliteration = "broker hodaot",
            original = "בְּרוֹקֶר הוֹדָעוֹת", translation = "брокер сообщений",
            definition = "שֵׁרוּת מֶרְכָּזִי שֶׁמַּעֲבִיר אֵירוּעִים בֵּין מְפַרְסְמִים לְצָרְכָנִים בְּלִי לְצַוֵּד אוֹתָם זֶה לְזֶה.",
            definitionNative = "Центральный сервис — передаёт события от отправителей к получателям, не связывая их напрямую.",
            example = "בְּרוֹקֶר הוֹדָעוֹת מְזַיֵּן עַשְׂרוֹת מִיקְרוֹסֶרְוִיסִים בְּלִי לֵדַעַת אֵיךְ הֵם בְּנוּיִים.",
            exampleNative = "בְּרוֹקֶר הוֹדָעוֹת кормит десятки микросервисов, не зная, как они устроены.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176403, setId = 1764, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_realtime", transliteration = "mesira khad-paamit",
            original = "מְסִירָה חַד-פַּעֲמִית", translation = "exactly-once",
            definition = "הַבְטָחָה שֶׁכָּל אֵירוּעַ יְעֻבַּד בְּדִיּוּק פַּעַם אַחַת — לֹא יִכָּפֵל וְלֹא יֹאבַד.",
            definitionNative = "Гарантия: каждое событие обработается ровно один раз — не задвоится и не потеряется.",
            example = "מְסִירָה חַד-פַּעֲמִית קְרִיטִית לְמַעֲרֶכֶת תַּשְׁלוּמִים שֶׁלֹּא תַּחְיֵב פַּעֲמַיִם.",
            exampleNative = "מְסִירָה חַד-פַּעֲמִית критична для платежей — чтобы не списать дважды.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176404, setId = 1764, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_realtime", transliteration = "si-di-si",
            original = "סִי-דִּי-סִי", translation = "change data capture (CDC)",
            definition = "טֶכְנִיקָה שֶׁמְּזַהָה כָּל שִׁנּוּי בְּמַסַּד הַמָּקוֹר וּמַעֲבִירָה אוֹתוֹ הָלְאָה כְּזֶרֶם.",
            definitionNative = "Техника — ловит каждое изменение в исходной БД и шлёт его дальше как поток.",
            example = "סִי-דִּי-סִי מֵהַ-פּוֹסְטְגְּרֵס מַזִּין אֶת הַ-מַחְסָן בִּזְמַן אֱמֶת.",
            exampleNative = "סִי-דִּי-סִי с Postgres питает хранилище в реальном времени.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176405, setId = 1764, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_realtime", transliteration = "ibud strim",
            original = "עִבּוּד סְטְרִים", translation = "потоковая обработка",
            definition = "חִשּׁוּב רָצִיף עַל אֵירוּעִים זוֹרְמִים מִבְּלִי לְחַכּוֹת לְקֹבֶץ סָגוּר עִם כָּל הַנְּתוּנִים.",
            definitionNative = "Непрерывный расчёт по летящим событиям — без ожидания закрытого файла со всеми данными.",
            example = "עִבּוּד סְטְרִים בְּ-פְלִינְק נוֹתֵן לָנוּ סְטָטִיסְטִיקָה כָּל שָׁנִיָּה.",
            exampleNative = "עִבּוּד סְטְרִים в Flink даёт нам статистику каждую секунду.",
            isFillInBlankSafe = false,
        ),

        // ── de_serving (5) — слой подачи данных аналитикам и приложениям ──
        WordEntity(
            id = 176406, setId = 1764, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_serving", transliteration = "shikhvat hagasha",
            original = "שִׁכְבַת הַגָּשָׁה", translation = "serving layer",
            definition = "הַחֵלֶק שֶׁמַּחֲזִיר תְּשׁוּבוֹת מוּכָנוֹת לַמּוּצָר אַחֲרֵי שֶׁכָּל הַחִשּׁוּבִים נִגְמְרוּ מֵאָחוֹר.",
            definitionNative = "Часть, которая отдаёт готовые ответы продукту — после того как все расчёты прошли в фоне.",
            example = "שִׁכְבַת הַגָּשָׁה רָצָה עַל רֶדִיס לִמְהִירוּת מַקְסִימָלִית.",
            exampleNative = "שִׁכְבַת הַגָּשָׁה работает на Redis — для максимальной скорости.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176407, setId = 1764, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_serving", transliteration = "tatsuga materializd",
            original = "תָּצוּגָה מַטֶ׳רִיאָלַייזְד", translation = "materialized view",
            definition = "תּוֹצָאָה שְׁמוּרָה מֵרֹאשׁ שֶׁל שְׁאֵלָה כְּבֵדָה כְּדֵי שֶׁלֹּא נְחַשֵּׁב אוֹתָהּ שׁוּב מֵאֶפֶס.",
            definitionNative = "Заранее сохранённый результат тяжёлого запроса — чтобы не пересчитывать заново с нуля.",
            example = "תָּצוּגָה מַטֶ׳רִיאָלַייזְד מִתְעַדְכֶּנֶת אַחַת לְחָמֵשׁ דַּקּוֹת בַּלַּיְלָה.",
            exampleNative = "תָּצוּגָה מַטֶ׳רִיאָלַייזְד обновляется раз в пять минут ночью.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176408, setId = 1764, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_serving", transliteration = "olap",
            original = "אוֹלָאפּ", translation = "OLAP",
            definition = "סוּג מַחְסָן שֶׁבָּנוּי לִשְׁאֵלוֹת כְּבֵדוֹת עַל הַרְבֵּה שׁוּרוֹת — לְדוּחוֹת וּלְאָנָלִיזָה.",
            definitionNative = "Тип хранилища — заточен под тяжёлые запросы по миллионам строк, для отчётов и аналитики.",
            example = "מַעֲבָר לְ-אוֹלָאפּ הוֹרִיד אֶת זְמַן הַדּוּחוֹת מֵחֲצִי שָׁעָה לְדַקָּה.",
            exampleNative = "Переход на אוֹלָאפּ опустил время отчётов с получаса до минуты.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176409, setId = 1764, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_serving", transliteration = "oltp",
            original = "אוֹלְטִיפִּי", translation = "OLTP",
            definition = "סוּג מַסָּד שֶׁבָּנוּי לְהַרְבֵּה פְּעֻלּוֹת קְצָרוֹת בְּמַקְבִּיל — בְּדֶרֶךְ כְּלָל מֵהָאַפְּלִיקַצְיָה הַחַיָּה.",
            definitionNative = "Тип СУБД — заточена под множество коротких операций параллельно, обычно от живого приложения.",
            example = "אוֹלְטִיפִּי לֹא מַתְאִים לְשְׁאֵלוֹת שֶׁעוֹבְרוֹת עַל מִילְיוֹנֵי שׁוּרוֹת.",
            exampleNative = "אוֹלְטִיפִּי не подходит для запросов по миллионам строк.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176410, setId = 1764, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_serving", transliteration = "optimizatsyat she'ilta",
            original = "אוֹפְּטִימִיזַצְיַת שְׁאִילְתָּה", translation = "оптимизация запроса",
            definition = "שִׁפּוּר אֹפֶן הָרָצָה שֶׁל פְּנִיָּה לַמַּסָּד כְּדֵי שֶׁתַּחְזִיר תְּשׁוּבָה מַהֵר וְעִם פָּחוֹת מַשְׁאַבִּים.",
            definitionNative = "Улучшение того, как обращение к БД исполняется — чтобы ответ пришёл быстрее и с меньшими ресурсами.",
            example = "אוֹפְּטִימִיזַצְיַת שְׁאִילְתָּה הוֹרִידָה אֶת הַזְּמַן מִשָּׁלוֹשׁ דַּקּוֹת לְחָמֵשׁ שְׁנִיּוֹת.",
            exampleNative = "אוֹפְּטִימִיזַצְיַת שְׁאִילְתָּה опустила время с трёх минут до пяти секунд.",
            isFillInBlankSafe = false,
        ),

        // ── de_governance (5) — управление и каталогизация данных ──
        WordEntity(
            id = 176411, setId = 1764, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_governance", transliteration = "data katalog",
            original = "דָּאטָה קָטָלוֹג", translation = "каталог данных",
            definition = "מַאֲגָר מֶטָה-מֵידָע שֶׁמְּתָאֵר אֵילוּ טַבְלָאוֹת קַיָּמוֹת בְּחֶבְרָה וּמָה כָּל עַמּוּדָה אוֹמֶרֶת.",
            definitionNative = "Реестр метаданных — описывает, какие таблицы есть в фирме и что значит каждая колонка.",
            example = "דָּאטָה קָטָלוֹג בְּ-קוֹלִיבְּרָה חוֹסֵךְ שָׁעוֹת חִפּוּשׂ לְכָל עוֹבֵד חָדָשׁ.",
            exampleNative = "דָּאטָה קָטָלוֹג в Collibra экономит часы поиска каждому новичку.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176412, setId = 1764, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_governance", transliteration = "linaaz' data",
            original = "לִינְאָז׳ דָּאטָה", translation = "data lineage",
            definition = "מַפָּה שֶׁמַּרְאָה מֵאֵיפֹה הִגִּיעַ כָּל שָׂדֶה בְּטַבְלָה — דֶּרֶךְ כָּל הַשְּׁלַבִּים מֵהַמָּקוֹר עַד הַסּוֹף.",
            definitionNative = "Карта — показывает, откуда пришло каждое поле в таблице через все шаги от истока до конца.",
            example = "לִינְאָז׳ דָּאטָה עָזַר לָנוּ לִמְצֹא בָּאג שֶׁהִשְׁפִּיעַ עַל שִׁשָּׁה דּוּחוֹת.",
            exampleNative = "לִינְאָז׳ דָּאטָה помог найти баг, повлиявший на шесть отчётов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176413, setId = 1764, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_governance", transliteration = "giluy data",
            original = "גִּלּוּי דָּאטָה", translation = "data discovery",
            definition = "תַּהֲלִיךְ שֶׁבּוֹ עוֹבֵד מוֹצֵא טַבְלָאוֹת רֶלֶוַנְטִיּוֹת לַמְּשִׂימָה שֶׁלּוֹ מִתּוֹךְ אַלְפֵי קְבָצִים.",
            definitionNative = "Процесс — сотрудник находит таблицы, нужные для своей задачи, среди тысяч массивов.",
            example = "גִּלּוּי דָּאטָה הָפַךְ לְקַל אַחֲרֵי שֶׁהִתְקַנּוּ אֲמוּנְדְסֶן.",
            exampleNative = "גִּלּוּי דָּאטָה стал лёгким — после того как мы поставили Amundsen.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176414, setId = 1764, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_governance", transliteration = "khoze data",
            original = "חוֹזֶה דָּאטָה", translation = "data contract",
            definition = "הֶסְכֵּם פוֹרְמָלִי בֵּין צוֹרֵךְ הַמֵּידָע לְבֵין הַסַּפָּק עַל מִבְנֶה וְאֵיכוּת מַה שֶּׁמּוּעֲבָר.",
            definitionNative = "Формальное соглашение между потребителем данных и поставщиком — о структуре и качестве того, что передают.",
            example = "חוֹזֶה דָּאטָה מָנַע מֵאִתָּנוּ שִׁבּוּר דּוּחוֹת בְּכָל פַּעַם שֶׁ-בֶּקְאֶנְד מְשַׁנֶּה שָׂדֶה.",
            exampleNative = "חוֹזֶה דָּאטָה не дал нам ломать отчёты каждый раз, когда бэкенд менял поле.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176415, setId = 1764, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_governance", transliteration = "data stuward",
            original = "דָּאטָה סְטְוַארְד", translation = "data steward",
            definition = "אִישׁ אַחֲרַאי בָּעֵסֶק שֶׁשּׁוֹמֵר עַל אֵיכוּת הַמֵּידָע וְעַל זֶה שֶׁכָּל אֶחָד מֵבִין מַה הוּא רוֹאֶה.",
            definitionNative = "Ответственный человек в бизнесе — следит за качеством данных и тем, чтобы каждый понимал, что видит.",
            example = "דָּאטָה סְטְוַארְד מִתְחוּם הַשִּׁוּוּק עוֹשֶׂה רִוִיוּ לְכָל שָׂדֶה חָדָשׁ.",
            exampleNative = "דָּאטָה סְטְוַארְד из маркетинга делает ревью каждому новому полю.",
            isFillInBlankSafe = false,
        ),

        // ── de_quality_advanced (5) — продвинутые проверки качества ──
        WordEntity(
            id = 176416, setId = 1764, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_quality_advanced", transliteration = "itur kharigot",
            original = "אִיתוּר חֲרִיגוֹת", translation = "anomaly detection",
            definition = "מַעֲרֶכֶת שֶׁמְּזַהָה אוֹטוֹמָטִית עֶרְכֵּי קִיצוֹן אוֹ דְּפוּסִים מוּזָרִים בְּתוֹךְ זֶרֶם הַנְּתוּנִים.",
            definitionNative = "Система — автоматически ловит выбросы и странные паттерны внутри потока данных.",
            example = "אִיתוּר חֲרִיגוֹת תָּפַס יְרִידָה שֶׁל שִׁבְעִים אָחוּז בְּהַרְשָׁמוֹת תּוֹךְ דַּקּוֹת.",
            exampleNative = "אִיתוּר חֲרִיגוֹת поймал падение регистраций на семьдесят процентов за минуты.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176417, setId = 1764, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_quality_advanced", transliteration = "raananut data",
            original = "רַעֲנַנּוּת דָּאטָה", translation = "freshness данных (SLA)",
            definition = "מַדָּד שֶׁבּוֹדֵק כַּמָּה זְמַן עָבַר מֵאָז שֶׁהַטַּבְלָה הִתְעַדְכְּנָה לְעֻמַּת הַסַּף הַמֻּסְכָּם.",
            definitionNative = "Метрика — сколько времени прошло с обновления таблицы по сравнению с согласованным порогом.",
            example = "רַעֲנַנּוּת דָּאטָה שֶׁל הַטַּבְלָה הַזּוֹ צְרִיכָה לִהְיוֹת מִתַּחַת לְשָׁעָה.",
            exampleNative = "רַעֲנַנּוּת דָּאטָה этой таблицы должна быть меньше часа.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176418, setId = 1764, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_quality_advanced", transliteration = "bdikat shlemut",
            original = "בְּדִיקַת שְׁלֵמוּת", translation = "проверка полноты",
            definition = "אִמּוּת שֶׁכָּל הָרְשׁוּמוֹת הַצְּפוּיוֹת אָכֵן הִגִּיעוּ — בְּלִי שׁוּרוֹת רֵיקוֹת אוֹ חֲסֵרוֹת.",
            definitionNative = "Сверка — все ожидаемые записи действительно пришли, без пустых или пропущенных строк.",
            example = "בְּדִיקַת שְׁלֵמוּת מָצְאָה שֶׁחָסְרוּ אַלְפַּיִם הַזְמָנוֹת מִיּוֹם רִאשׁוֹן.",
            exampleNative = "בְּדִיקַת שְׁלֵמוּת нашла пропавшие две тысячи заказов с воскресенья.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176419, setId = 1764, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_quality_advanced", transliteration = "bdikat ikviyut",
            original = "בְּדִיקַת עִקְבִיּוּת", translation = "проверка согласованности",
            definition = "אִמּוּת שֶׁאוֹתָם מַסְפָּרִים בְּטַבְלָאוֹת שׁוֹנוֹת תּוֹאֲמִים זֶה לָזֶה אַחֲרֵי כָּל הַטְּרַנְסְפוֹרְמַצְיוֹת.",
            definitionNative = "Сверка — одни и те же числа в разных таблицах совпадают друг с другом после всех трансформаций.",
            example = "בְּדִיקַת עִקְבִיּוּת חָשְׂפָה פַּעַר שֶׁל שְׁמוֹנָה אָחוּז בֵּין הַ-מַחְסָן לַ-דּוּחוֹת.",
            exampleNative = "בְּדִיקַת עִקְבִיּוּת вскрыла разрыв в восемь процентов между хранилищем и отчётами.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176420, setId = 1764, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_quality_advanced", transliteration = "profayling data",
            original = "פְּרוֹפַיְילִינְג דָּאטָה", translation = "профайлинг данных",
            definition = "סְקִירָה אוֹטוֹמָטִית שֶׁל שָׂדוֹת — טְוָוחֵי עֶרֶךְ, אָחוּז רֵיקִים, פִּזּוּר — לִפְנֵי שֶׁבּוֹנִים פַּייפְּלַיין.",
            definitionNative = "Автоматический обзор полей — диапазоны значений, доля пустых, распределение — до постройки пайплайна.",
            example = "פְּרוֹפַיְילִינְג דָּאטָה גִּלָּה שֶׁשְּׁלִישׁ מֵהָעַמּוּדוֹת רֵיקוֹת לַחֲלוּטִין.",
            exampleNative = "פְּרוֹפַיְילִינְג דָּאטָה показал, что треть колонок полностью пуста.",
            isFillInBlankSafe = false,
        ),

        // ── de_team (5) — роли и состав команды дата-инжиниринга ──
        WordEntity(
            id = 176421, setId = 1764, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_team", transliteration = "mehandes data",
            original = "מְהַנְדֵס דָּאטָה", translation = "data engineer",
            definition = "אִישׁ מִקְצוֹעַ שֶׁבּוֹנֶה אֶת הַצִּנּוֹרוֹת שֶׁמַּעֲבִירִים מֵידָע מֵהָאַפְּלִיקַצְיוֹת לַ-מַחְסָן.",
            definitionNative = "Специалист — строит трубы, которые гонят информацию из приложений в хранилище.",
            example = "מְהַנְדֵס דָּאטָה חָדָשׁ הִצְטָרֵף לַצֶּוֶות בִּתְחִלַּת הַשָּׁנָה הַכַּסְפִּית.",
            exampleNative = "מְהַנְדֵס דָּאטָה присоединился к команде в начале финансового года.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176422, setId = 1764, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_team", transliteration = "analitiks endzhenir",
            original = "אֲנָלִיטִיקְס אֶנְגִ׳נְיֶר", translation = "analytics engineer",
            definition = "תַּפְקִיד גֶּשֶׁר בֵּין הָאַנָלִיסְטִים לַמְהַנְדְסִים — בּוֹנֶה מוֹדֵלִים שֶׁל מֵידָע בְּ-דִי-בִּי-טִי.",
            definitionNative = "Гибридная роль — мост между аналитиками и инженерами, строит модели в dbt.",
            example = "אֲנָלִיטִיקְס אֶנְגִ׳נְיֶר אַחְרַאי עַל כָּל הַמּוֹדֵלִים הָעֲסָקִיִּים בַּ-מַחְסָן.",
            exampleNative = "אֲנָלִיטִיקְס אֶנְגִ׳נְיֶר отвечает за все бизнес-модели в хранилище.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176423, setId = 1764, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_team", transliteration = "arkhitekt data",
            original = "אַרְכִיטֶקְט דָּאטָה", translation = "data architect",
            definition = "אִישׁ בָּכִיר שֶׁמְּעַצֵּב אֶת הַתְּמוּנָה הַכּוֹלֶלֶת שֶׁל זְרִימוֹת הַמֵּידָע בָּאִרְגוּן לְטַוָּח שָׁנִים.",
            definitionNative = "Сеньорный человек — рисует общую картину потоков информации в организации на годы вперёд.",
            example = "אַרְכִיטֶקְט דָּאטָה הִצִּיג מַפַּת דְּרָכִים לְמַעֲבָר לַעֲנָן.",
            exampleNative = "אַרְכִיטֶקְט דָּאטָה представил roadmap миграции в облако.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176424, setId = 1764, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "de_team", transliteration = "tsevet platforma",
            original = "צֶוֶות פְּלָטְפוֹרְמָה", translation = "data platform team",
            definition = "קְבוּצָה אַחְרָאִית עַל הַתַּשְׁתִּית הַמְּשֻׁתֶּפֶת — כְּלִים, שֶׁרָתִים וְהֶרְשָׁאוֹת לַכָּל הַחֶבְרָה.",
            definitionNative = "Группа отвечает за общую инфраструктуру — инструменты, серверы и доступы для всей фирмы.",
            example = "צֶוֶות פְּלָטְפוֹרְמָה דּוֹחֵף שִׁדְרוּג שֶׁל סְנוֹאוּפְלֵיק בְּכָל הַחֲטִיבָה.",
            exampleNative = "צֶוֶות פְּלָטְפוֹרְמָה катит апгрейд Snowflake по всему дивизиону.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176425, setId = 1764, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "de_team", transliteration = "rotatsyat toranut",
            original = "רוֹטָצְיַת תּוֹרָנוּת", translation = "on-call rotation",
            definition = "סִדּוּר שֶׁבּוֹ אַנְשֵׁי הַצֶּוֶות מִתְחַלְּפִים בְּזִמּוּן לִקְרֹא לְתַקָּלוֹת בִּפְרוֹדַקְשֶׁן בִּשְׁעוֹת לַיְלָה.",
            definitionNative = "Расписание — люди в команде по очереди отвечают на сбои в проде в ночные часы.",
            example = "רוֹטָצְיַת תּוֹרָנוּת אֶצְלֵנוּ מִתְחַלֶּפֶת כָּל יוֹם רִאשׁוֹן בַּבֹּקֶר.",
            exampleNative = "רוֹטָצְיַת תּוֹרָנוּת у нас меняется каждое воскресенье утром.",
            isFillInBlankSafe = false,
        ),
    )
}
