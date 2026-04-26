package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Собеседования" (job interviews), уровень L1.
 *
 * Set 1752: «Собеседования» — основы (L1, COMMON+UNCOMMON):
 *           простейшая лексика для первого собеседования. Базовые понятия,
 *           встреча, элементарные слова о компании, базовое о себе,
 *           первый контакт по телефону/имейл.
 *
 * Тема ориентирована на русскоязычных репатриантов в Израиле, которые впервые
 * сталкиваются с собеседованием на иврите. Лексика — только самые
 * частотные слова A1-A2 без английских заимствований и узких терминов.
 *
 * Кросс-тематические пересечения с темами «Хайтек» (1745), «Работа и карьера»
 * (WordDataHebrewWorkV2.kt) допустимы по правилу: дубли `original` между
 * РАЗНЫМИ темами разрешены. Внутри темы «Собеседования» (1750-1752) дублей
 * нет — этот сет даёт чистый базовый слой, а 1750/1751 — углублённый
 * и профессиональный уровни.
 *
 * Распределение редкостей:
 *   Set 1752: 13 COMMON + 12 UNCOMMON.
 *
 * SemanticGroups (5 × 5):
 *   interview_basics        — самые базовые: собеседование, работа,
 *                             работодатель, кандидат, зарплата
 *   interview_meeting       — про встречу: встреча, час, дата, адрес, комната
 *   interview_company_basic — простое о компании: компания, офис,
 *                             руководитель, команда, коллега
 *   interview_self_basic    — базовое о себе: имя, возраст, образование,
 *                             опыт, языки
 *   interview_first_contact — первый контакт: телефон, имейл, сообщение,
 *                             приглашение, ответ
 *
 * Word IDs: setId × 100 + position (175201..175225).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewInterviewL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1752, languagePair = "he-ru", orderIndex = 1752,
            name = "Собеседования",
            description = "Базовая лексика: работа, кандидат, работодатель, вакансия, должность",
            topic = "Собеседования", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1752 — Собеседования: основы (L1, COMMON+UNCOMMON, A1-A2)
        // 5 групп × 5 слов: basics, meeting, company_basic, self_basic, first_contact
        // ══════════════════════════════════════════════════════════════════════

        // ── interview_basics (5) — самые базовые понятия собеседования ──
        WordEntity(
            id = 175201, setId = 1752, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "interview_basics", transliteration = "ra'ayon",
            original = "רֵאָיוֹן", translation = "собеседование",
            definition = "פְּגִישָׁה רִשְׁמִית בֵּין מֻעֳמָד לְמַעֲסִיק לִפְנֵי קַבָּלָה לַעֲבוֹדָה.",
            definitionNative = "Официальная встреча кандидата и работодателя перед приёмом на работу.",
            example = "יֵשׁ לִי רֵאָיוֹן בְּחֶבְרַת הַיְּי-טֶק מָחָר בָּעֶשֶׂר.",
            exampleNative = "У меня רֵאָיוֹן в хайтек-компании завтра в десять.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175202, setId = 1752, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "interview_basics", transliteration = "avoda",
            original = "עֲבוֹדָה", translation = "работа",
            definition = "מָה שֶׁאָדָם עוֹשֶׂה בְּחֶבְרָה כְּדֵי לְקַבֵּל כֶּסֶף בְּסוֹף הַחֹדֶשׁ.",
            definitionNative = "То, что человек делает в фирме, чтобы получать деньги в конце месяца.",
            example = "אֲנִי מְחַפֵּשׂ עֲבוֹדָה חֲדָשָׁה כְּבָר שְׁלוֹשָׁה חֳדָשִׁים.",
            exampleNative = "Я ищу новую עֲבוֹדָה уже три месяца.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175203, setId = 1752, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "interview_basics", transliteration = "ma'asik",
            original = "מַעֲסִיק", translation = "работодатель",
            definition = "אִישׁ אוֹ חֶבְרָה שֶׁמְּשַׁלְּמִים שָׂכָר תְּמוּרַת עֲבוֹדָה.",
            definitionNative = "Человек или фирма, что платят зарплату взамен на работу.",
            example = "הַמַּעֲסִיק שֶׁלִּי הַקּוֹדֵם הָיָה הוֹגֵן וְשִׁלֵּם בַּזְּמַן.",
            exampleNative = "Мой прежний מַעֲסִיק был справедливым и платил вовремя.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175204, setId = 1752, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "interview_basics", transliteration = "mu'amad",
            original = "מוֹעֲמָד", translation = "кандидат",
            definition = "אָדָם שֶׁמְּחַפֵּשׂ לְהִתְקַבֵּל לְמָקוֹם חָדָשׁ וְצָרִיךְ לַעֲבוֹר רֵאָיוֹן.",
            definitionNative = "Человек, что хочет попасть на новое место и проходит собеседование.",
            example = "כָּל מוֹעֲמָד עוֹבֵר שָׁלוֹשׁ שִׂיחוֹת לִפְנֵי הַחְלָטָה.",
            exampleNative = "Каждый מוֹעֲמָד проходит три беседы перед решением.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175205, setId = 1752, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "interview_basics", transliteration = "maskoret",
            original = "מַשְׂכֹּרֶת", translation = "зарплата",
            definition = "סְכוּם הַכֶּסֶף שֶׁאָדָם מְקַבֵּל פַּעַם בְּחֹדֶשׁ עֲבוּר עֲבוֹדָתוֹ.",
            definitionNative = "Сумма денег, что человек получает раз в месяц за свою работу.",
            example = "הַמַּשְׂכֹּרֶת מִתְקַבֶּלֶת בַּחֶשְׁבּוֹן בָּעֲשִׂירִי לַחֹדֶשׁ.",
            exampleNative = "מַשְׂכֹּרֶת приходит на счёт десятого числа месяца.",
            isFillInBlankSafe = false,
        ),

        // ── interview_meeting (5) — про встречу: время, место, помещение ──
        WordEntity(
            id = 175206, setId = 1752, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "interview_meeting", transliteration = "pgisha",
            original = "פְּגִישָׁה", translation = "встреча",
            definition = "מַעֲמָד שֶׁבּוֹ שְׁנֵי אֲנָשִׁים אוֹ יוֹתֵר נִפְגָּשִׁים בְּמָקוֹם מְתֻכְנָן מֵרֹאשׁ.",
            definitionNative = "Когда два человека или больше сходятся в заранее условленном месте.",
            example = "קָבַעְנוּ פְּגִישָׁה בְּבֵית הַקָּפֶה לְיַד הַתַּחֲנָה.",
            exampleNative = "Мы назначили פְּגִישָׁה в кофейне рядом со станцией.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175207, setId = 1752, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "interview_meeting", transliteration = "sha'a",
            original = "שָׁעָה", translation = "час",
            definition = "יְחִידַת זְמַן שֶׁל שִׁישִּׁים דַּקּוֹת — בָּהּ מוֹדְדִים אֶת הַיּוֹם.",
            definitionNative = "Промежуток времени в шестьдесят минут — им меряют день.",
            example = "הַמְּגַיֵּיס בִּקֵּשׁ לְהִפָּגֵשׁ בַּשָּׁעָה תֵּשַׁע בַּבֹּקֶר.",
            exampleNative = "Рекрутер попросил встретиться в שָׁעָה девять утра.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175208, setId = 1752, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "interview_meeting", transliteration = "ta'arikh",
            original = "תַּאֲרִיךְ", translation = "дата",
            definition = "הַיּוֹם הַמְּסֻיָּם בַּחֹדֶשׁ שֶׁבּוֹ קוֹרֶה אֵרוּעַ — לְמָשָׁל חֲמִישָּׁה בְּמַאי.",
            definitionNative = "Конкретный день в месяце, когда происходит событие — например, пятого мая.",
            example = "הַתַּאֲרִיךְ שֶׁל הָרֵאָיוֹן הַשֵּׁנִי נִקְבַּע לִשְׁלִישִׁי הַבָּא.",
            exampleNative = "תַּאֲרִיךְ второго собеседования назначен на следующий вторник.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175209, setId = 1752, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "interview_meeting", transliteration = "ktovet",
            original = "כְּתֹבֶת", translation = "адрес",
            definition = "הַשֵּׁם שֶׁל הָרְחוֹב וְהַמִּסְפָּר שֶׁעוֹזֵר לִמְצֹא בַּיִת אוֹ בִּנְיָן.",
            definitionNative = "Название улицы и номер — помогают найти дом или здание.",
            example = "שָׁלְחוּ לִי כְּתֹבֶת מְדֻיֶּקֶת בְּוואטסאפ לִפְנֵי הַשִּׂיחָה.",
            exampleNative = "Мне прислали точный כְּתֹבֶת в WhatsApp перед беседой.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175210, setId = 1752, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "interview_meeting", transliteration = "kheder",
            original = "חֶדֶר", translation = "комната",
            definition = "מָקוֹם סָגוּר בְּתוֹךְ בִּנְיָן עִם דֶּלֶת וְקִירוֹת — שָׁם יוֹשְׁבִים בָּרֵאָיוֹן.",
            definitionNative = "Закрытое место внутри здания с дверью и стенами — там сидят на собеседовании.",
            example = "הַחֶדֶר הָיָה קָטָן וְעִם שׁוּלְחָן עָגֹל לִשְׁלוֹשָׁה אֲנָשִׁים.",
            exampleNative = "חֶדֶר был маленьким, со столом круглым на трёх человек.",
            isFillInBlankSafe = false,
        ),

        // ── interview_company_basic (5) — простое о компании ──
        WordEntity(
            id = 175211, setId = 1752, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "interview_company_basic", transliteration = "khevra",
            original = "חֶבְרָה", translation = "компания",
            definition = "אִרְגּוּן עִסְקִי שֶׁל אֲנָשִׁים שֶׁעוֹבְדִים יַחַד וּמַרְוִיחִים כֶּסֶף יַחַד.",
            definitionNative = "Деловое объединение людей, что работают вместе и зарабатывают вместе.",
            example = "הַחֶבְרָה הוּקְמָה לִפְנֵי שֶׁבַע שָׁנִים בְּתֵל אָבִיב.",
            exampleNative = "חֶבְרָה была основана семь лет назад в Тель-Авиве.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175212, setId = 1752, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "interview_company_basic", transliteration = "misrad",
            original = "מִשְׂרָד", translation = "офис",
            definition = "מָקוֹם שֶׁבּוֹ הָעוֹבְדִים יוֹשְׁבִים מוּל הַמַּחְשֵׁב מִדֵּי יוֹם.",
            definitionNative = "Помещение, где сотрудники сидят за компьютером каждый день.",
            example = "הַמִּשְׂרָד הֶחָדָשׁ נִמְצָא בַּקּוֹמָה הַחֲמִישִּׁית.",
            exampleNative = "Новый מִשְׂרָד находится на пятом этаже.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175213, setId = 1752, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "interview_company_basic", transliteration = "menahel",
            original = "מַנְהֵל", translation = "руководитель",
            definition = "אִישׁ שֶׁאַחְרַאי עַל קְבוּצָה שֶׁל אֲנָשִׁים וּמַחְלִיט מָה לַעֲשׂוֹת.",
            definitionNative = "Тот, кто отвечает за группу людей и решает, что делать.",
            example = "הַמַּנְהֵל הַיָּשִׁיר שֶׁלִּי הָיָה נוֹכֵחַ בָּרֵאָיוֹן.",
            exampleNative = "Мой прямой מַנְהֵל присутствовал на собеседовании.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175214, setId = 1752, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "interview_company_basic", transliteration = "tsevet",
            original = "צֶוֶת", translation = "команда",
            definition = "קְבוּצָה קְטַנָּה שֶׁל אֲנָשִׁים שֶׁעוֹבְדִים יַחַד עַל אוֹתָהּ מַטָּרָה.",
            definitionNative = "Маленькая группа людей, что работают вместе над одной целью.",
            example = "הַצֶּוֶות שֶׁלָּנוּ סִיֵּם אֶת הַפְּרוֹיֶקְט לִפְנֵי הַזְּמַן.",
            exampleNative = "Наш צֶוֶות закончил проект раньше срока.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175215, setId = 1752, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "interview_company_basic", transliteration = "kolega",
            original = "קוֹלֶגָה", translation = "коллега",
            definition = "מִישֶׁהוּ שֶׁעוֹבֵד אִתְּךָ בְּאוֹתוֹ מָקוֹם, אֲבָל לֹא בְּהֶכְרֵחַ בְּאוֹתוֹ צֶוֶות.",
            definitionNative = "Тот, кто работает с тобой в одном месте, но не обязательно в одной команде.",
            example = "פָּגַשְׁתִּי קוֹלֶגָה וָתִיק בַּמִּסְדָּרוֹן בְּדַרְכִּי לָרֵאָיוֹן.",
            exampleNative = "Я встретил старого קוֹלֶגָה в коридоре по пути на собеседование.",
            isFillInBlankSafe = false,
        ),

        // ── interview_self_basic (5) — базовое о себе ──
        WordEntity(
            id = 175216, setId = 1752, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "interview_self_basic", transliteration = "shem",
            original = "שֵׁם", translation = "имя",
            definition = "הַמִּלָּה שֶׁבָּהּ קוֹרְאִים לְאָדָם — הַדָּבָר הָרִאשׁוֹן שֶׁאוֹמְרִים בָּרֵאָיוֹן.",
            definitionNative = "Слово, которым зовут человека — то, что говорят первым на собеседовании.",
            example = "הַמְּרַאֲיֵין רָשַׁם אֶת הַשֵּׁם שֶׁלִּי בַּמַּחְבֶּרֶת לִפְנֵי שֶׁדִּבַּרְנוּ.",
            exampleNative = "Интервьюер записал мой שֵׁם в блокнот, прежде чем мы заговорили.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175217, setId = 1752, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "interview_self_basic", transliteration = "gil",
            original = "גִּיל", translation = "возраст",
            definition = "מִסְפַּר הַשָּׁנִים שֶׁעָבְרוּ מֵהַיּוֹם שֶׁאָדָם נוֹלַד.",
            definitionNative = "Число лет, что прошли со дня рождения человека.",
            example = "לֹא חוֹקִי לִשְׁאֹל עַל גִּיל בָּרֵאָיוֹן בְּיִשְׂרָאֵל.",
            exampleNative = "Спрашивать про גִּיל на собеседовании в Израиле незаконно.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175218, setId = 1752, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "interview_self_basic", transliteration = "haskala",
            original = "הַשְׂכָּלָה", translation = "образование",
            definition = "כָּל הַלִּימּוּדִים בְּבֵית סֵפֶר וּבָאוּנִיבֶרְסִיטָה שֶׁאָדָם סִיֵּם בְּחַיָּיו.",
            definitionNative = "Всё учение в школе и университете, что человек прошёл за жизнь.",
            example = "סִפַּרְתִּי בַּקְּצָרָה עַל הַהַשְׂכָּלָה שֶׁלִּי בְּמוֹסְקְבָה.",
            exampleNative = "Я кратко рассказал про свою הַשְׂכָּלָה в Москве.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175219, setId = 1752, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "interview_self_basic", transliteration = "nisayon",
            original = "נִסָּיוֹן", translation = "опыт",
            definition = "הַיֶּדַע שֶׁאָדָם צָבַר תּוֹךְ כְּדֵי שָׁנִים שֶׁל עֲבוֹדָה אוֹ חַיִּים.",
            definitionNative = "Знания, что человек накопил за годы работы или жизни.",
            example = "יֵשׁ לִי נִסָּיוֹן שֶׁל חָמֵשׁ שָׁנִים בְּתַחוּם הָעִצּוּב.",
            exampleNative = "У меня נִסָּיוֹן в пять лет в сфере дизайна.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175220, setId = 1752, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "interview_self_basic", transliteration = "safot",
            original = "שָׂפוֹת", translation = "языки",
            definition = "הַדְּרָכִים שֶׁבָּהֶן בְּנֵי אָדָם מְדַבְּרִים — לְמָשָׁל עִבְרִית, רוּסִית אוֹ אַנְגְּלִית.",
            definitionNative = "То, на чём общаются люди — например иврит, русский или английский.",
            example = "כָּתַבְתִּי בַּקּוֹרוֹת חַיִּים שָׁלוֹשׁ שָׂפוֹת בְּרָמָה גְּבוֹהָה.",
            exampleNative = "Я указал в резюме три שָׂפוֹת на высоком уровне.",
            isFillInBlankSafe = false,
        ),

        // ── interview_first_contact (5) — первый контакт ──
        WordEntity(
            id = 175221, setId = 1752, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "interview_first_contact", transliteration = "telefon",
            original = "טֶלֶפוֹן", translation = "телефон",
            definition = "מַכְשִׁיר קָטָן בַּכִּיס שֶׁבּוֹ מְדַבְּרִים אוֹ שׁוֹלְחִים הוֹדָעָה לְמִישֶׁהוּ רָחוֹק.",
            definitionNative = "Маленькое устройство в кармане — говорят или шлют сообщение далёкому собеседнику.",
            example = "הַטֶּלֶפוֹן צִלְצֵל בָּאֶמְצַע הַמִּקְלַחַת — הַמְּגַיֵּיס מִתְקַשֵּׁר.",
            exampleNative = "טֶלֶפוֹן зазвонил посреди душа — это рекрутер.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175222, setId = 1752, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "interview_first_contact", transliteration = "imeil",
            original = "אִימֵייל", translation = "имейл",
            definition = "מִכְתָּב שֶׁעוֹבֵר בָּרֶשֶׁת מִכְּתֹבֶת אֶלֶקְטְרוֹנִית אַחַת לִשְׁנִיָּה.",
            definitionNative = "Письмо по сети — с одного электронного адреса на другой.",
            example = "כָּתַבְתִּי אִימֵייל קָצָר וּמְנֻמָּס לַמְּגַיֵּיס בָּעֶרֶב.",
            exampleNative = "Я написал короткий и вежливый אִימֵייל рекрутеру вечером.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175223, setId = 1752, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "interview_first_contact", transliteration = "hoda'a",
            original = "הוֹדָעָה", translation = "сообщение",
            definition = "טֶקְסְט קָצָר בָּטֶלֶפוֹן שֶׁמּוֹסֵר מֵידָע מְהִיר בְּלִי לְצַלְצֵל.",
            definitionNative = "Короткий текст в телефоне — передаёт быструю информацию без звонка.",
            example = "קִבַּלְתִּי הוֹדָעָה שֶׁמְּזַמֶּנֶת אוֹתִי לָרֵאָיוֹן בְּיוֹם שְׁלִישִׁי.",
            exampleNative = "Мне пришло הוֹדָעָה, что меня зовут на собеседование во вторник.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175224, setId = 1752, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "interview_first_contact", transliteration = "tazkoret",
            original = "תַּזְכֹּרֶת", translation = "напоминание (о встрече)",
            definition = "פְּתָק קָצָר אוֹ הוֹדָעָה שֶׁמַּזְכִּירִים שֶׁעוֹד מְעַט פְּגִישָׁה.",
            definitionNative = "Короткая записка или сообщение — напоминают, что скоро встреча.",
            example = "קִבַּלְתִּי תַּזְכֹּרֶת בָּטֶלֶפוֹן יוֹם לִפְנֵי הַפְּגִישָׁה הָרִאשׁוֹנָה.",
            exampleNative = "Я получил תַּזְכֹּרֶת на телефон за день до первой встречи.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175225, setId = 1752, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "interview_first_contact", transliteration = "ma'ane",
            original = "מַעֲנֶה", translation = "ответ",
            definition = "מַה שֶּׁאָדָם אוֹמֵר אוֹ כּוֹתֵב כְּשֶׁמַּפְנִים אֵלָיו שְׁאֵלָה אוֹ פְּנִיָּה.",
            definitionNative = "То, что человек говорит или пишет, когда к нему обращаются с вопросом.",
            example = "חִיכִּיתִי שָׁבוּעַ שָׁלֵם לְמַעֲנֶה מֵהַחֶבְרָה הַגְּדוֹלָה.",
            exampleNative = "Я ждал целую неделю מַעֲנֶה от большой компании.",
            isFillInBlankSafe = false,
        ),
    )
}
