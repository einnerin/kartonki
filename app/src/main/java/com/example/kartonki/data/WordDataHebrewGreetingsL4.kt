package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary: Приветствия, level 4 (1 set, 25 words).
 * Профессиональный регистр приветствий: дипломатический протокол, академический
 * церемониал, формы письменного обращения, цитаты Торы и пословиц для
 * приветствий, формальные соболезнования и поздравления.
 *
 * Set 1709:
 *   1709 (level 4, EPIC + LEGENDARY) — профессиональные приветствия:
 *   дипломатия, академический протокол
 *
 * Не пересекается с уже существующими сетами темы «Приветствия»
 * (1004 L1 базовые формулы, 1280 L2 ситуативные пожелания, 1221 L3 формальный
 * этикет, 1222 L4 прагматика и риторика, 1281 L5 теория вежливости):
 * там покрыты бытовые/общеэтикетные/теоретические пласты. Здесь — узкий
 * профессиональный регистр: дипломатия, академия, эпистолярный канон, тексты
 * благословений из Торы, формальные соболезнования и поздравления.
 *
 * Распределение редкостей: 15 EPIC + 10 LEGENDARY (2 смежных уровня).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewGreetingsL4 {

    val sets = listOf(
        WordSetEntity(
            id = 1709, languagePair = "he-ru", orderIndex = 209,
            name = "Приветствия",
            description = "Профессиональные приветствия: дипломатия, академический протокол",
            topic = "Приветствия", level = 4,
        ),
    )

    val words = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1709 — Приветствия: профессиональный регистр (EPIC + LEGENDARY, C1–C2)
        // 5 групп × 5 слов: diplomacy, academic_protocol, letter_address,
        //                   torah_quotes, condolences_celebrations
        // ══════════════════════════════════════════════════════════════════════

        // ── greeting_diplomacy (5 EPIC) — дипломатические обороты ──
        WordEntity(
            id = 170901, setId = 1709, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "greeting_diplomacy", transliteration = "kvod hashagrir",
            original = "כְּבוֹד הַשַּׁגְרִיר", translation = "Ваше Превосходительство (посол)",
            definition = "פְּנִיָּה רִשְׁמִית לַשַּׁגְרִיר בִּטְקָסִים וּבְתִכְתֹּבֶת מְדִינִית.",
            definitionNative = "Формальное обращение к послу на церемониях и в государственной переписке.",
            example = "כְּבוֹד הַשַּׁגְרִיר הִגִּיעַ לְטֶקֶס פְּתִיחָה.",
            exampleNative = "Господин כְּבוֹד הַשַּׁגְרִיר прибыл на церемонию открытия.",
         fillInBlankExclusions = listOf(170902L, 170903L, 170904L, 170905L)),
        WordEntity(
            id = 170902, setId = 1709, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "greeting_diplomacy", transliteration = "hagashat ktav haamana",
            original = "הַגָּשַׁת כְּתַב הַאֲמָנָה", translation = "вручение верительных грамот",
            definition = "טֶקֶס בּוֹ שַׁגְרִיר חָדָשׁ מַעֲבִיר אֶת מִכְתַּב מִנּוּיוֹ לְרֹאשׁ הַמְּדִינָה.",
            definitionNative = "Церемония, на которой новый посол передаёт грамоту главе государства.",
            example = "הַגָּשַׁת כְּתַב הַאֲמָנָה נֶעֶרְכָה בָּאַרְמוֹן.",
            exampleNative = "הַגָּשַׁת כְּתַב הַאֲמָנָה состоялась во дворце.",
         fillInBlankExclusions = listOf(170901L, 170903L, 170904L, 170905L)),
        WordEntity(
            id = 170903, setId = 1709, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "greeting_diplomacy", transliteration = "brakhot mediniyot",
            original = "בִּרְכוֹת מְדִינִיּוֹת", translation = "официальные приветствия (главы государства)",
            definition = "דִּבְרֵי שָׁלוֹם רִשְׁמִיִּים מִשְׁלִיט לִשְׁלִיט בִּטְקָסִים בֵּין־מְדִינִיִּים.",
            definitionNative = "Формальные слова приветствия, которыми обмениваются лидеры государств.",
            example = "הַנָּשִׂיא פָּתַח אֶת הָעֶרֶב בְּבִרְכוֹת מְדִינִיּוֹת.",
            exampleNative = "Президент открыл вечер словами בִּרְכוֹת מְדִינִיּוֹת.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 170904, setId = 1709, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "greeting_diplomacy", transliteration = "pgisha bilti reshmit",
            original = "פְּגִישָׁה בִּלְתִּי רִשְׁמִית", translation = "неформальная (кулуарная) встреча",
            definition = "מִפְגָּשׁ דִּיפְּלוֹמָטִי מִחוּץ לַפְּרוֹטוֹקוֹל לַחֲלִיפַת רְשָׁמִים שֶׁקֵטָה.",
            definitionNative = "Дипломатический контакт вне протокола для тихого обмена впечатлениями.",
            example = "הַשָּׂרִים קִיְּמוּ פְּגִישָׁה בִּלְתִּי רִשְׁמִית בַּגִּנָּה.",
            exampleNative = "Министры провели פְּגִישָׁה בִּלְתִּי רִשְׁמִית в саду.",
         fillInBlankExclusions = listOf(170901L, 170902L, 170903L, 170905L)),
        WordEntity(
            id = 170905, setId = 1709, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "greeting_diplomacy", transliteration = "hatsharat khavrut",
            original = "הַצְהָרַת חֲבֵרוּת", translation = "заявление о дружбе (между странами)",
            definition = "הוֹדָעָה רִשְׁמִית הַמַּכְרִיזָה עַל יְחָסִים יְדִידוּתִיִּים בֵּין שְׁתֵּי מְדִינוֹת.",
            definitionNative = "Официальное заявление о дружественных отношениях между двумя странами.",
            example = "הַצְהָרַת חֲבֵרוּת נֶחְתְּמָה בִּפְנֵי הַתִּקְשֹׁרֶת.",
            exampleNative = "הַצְהָרַת חֲבֵרוּת подписана перед камерами прессы.",
         fillInBlankExclusions = listOf(170901L, 170902L, 170903L, 170904L)),

        // ── greeting_academic_protocol (5 EPIC) — академический церемониал ──
        WordEntity(
            id = 170906, setId = 1709, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "greeting_academic_protocol", transliteration = "neum ptikha",
            original = "נְאוּם פְּתִיחָה", translation = "вступительная речь (на конференции)",
            definition = "דִּבְרֵי בְּרָכָה רִשְׁמִיִּים שֶׁפּוֹתְחִים כֶּנֶס אוֹ טֶקֶס אַקָדֶמִי.",
            definitionNative = "Официальные приветственные слова, открывающие конференцию или церемонию.",
            example = "הַדֵּיקָן נָשָׂא נְאוּם פְּתִיחָה קָצָר וּמְכֻבָּד.",
            exampleNative = "Декан произнёс краткую и почтительную נְאוּם פְּתִיחָה.",
         fillInBlankExclusions = listOf(170907L, 170908L, 170909L, 170910L)),
        WordEntity(
            id = 170907, setId = 1709, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "greeting_academic_protocol", transliteration = "brikhat habaim",
            original = "בִּרְכַּת הַבָּאִים", translation = "приветствие гостей (формальное)",
            definition = "דִּבְרֵי שָׁלוֹם רִשְׁמִיִּים לְאוֹרְחִים בְּפֶתַח אֵרוּעַ אַקָדֶמִי אוֹ צִבּוּרִי.",
            definitionNative = "Формальные слова приветствия гостям в начале академического или общественного события.",
            example = "הַנָּשִׂיא פָּתַח בְּבִרְכַּת הַבָּאִים חֲמִימָה.",
            exampleNative = "Президент открыл тёплыми בִּרְכַּת הַבָּאִים.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 170908, setId = 1709, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "greeting_academic_protocol", transliteration = "hatsdaat orakh kavod",
            original = "הַצְדָּעַת אוֹרֵחַ כָּבוֹד", translation = "представление почётного гостя",
            definition = "טֶקֶס קָצָר שֶׁבּוֹ הַמַּנְחֶה מַצִּיג אוֹרֵחַ דָּגוּל לִפְנֵי הַקָּהָל.",
            definitionNative = "Краткий ритуал, в котором ведущий представляет аудитории заслуженного гостя.",
            example = "הַמַּנְחֶה עָרַךְ הַצְדָּעַת אוֹרֵחַ כָּבוֹד מְפֹרָט.",
            exampleNative = "Ведущий провёл подробную הַצְדָּעַת אוֹרֵחַ כָּבוֹד.",
         fillInBlankExclusions = listOf(170906L, 170907L, 170909L, 170910L)),
        WordEntity(
            id = 170909, setId = 1709, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "greeting_academic_protocol", transliteration = "divrei toda akademiyim",
            original = "דִּבְרֵי תּוֹדָה אַקָדֶמִיִּים", translation = "академические слова благодарности",
            definition = "פְּסוּקֵי הַכָּרַת תּוֹדָה רִשְׁמִיִּים לִמְלַוִּים מַדָּעִיִּים אוֹ לִמְמַמְּנִים.",
            definitionNative = "Формальные выражения благодарности научным руководителям и грантодателям.",
            example = "הַחוֹקֵר נָעַל אֶת הַהַרְצָאָה בְּדִבְרֵי תּוֹדָה אַקָדֶמִיִּים.",
            exampleNative = "Учёный закрыл лекцию словами דִּבְרֵי תּוֹדָה אַקָדֶמִיִּים.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 170910, setId = 1709, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "greeting_academic_protocol", transliteration = "tekes hakharat panim",
            original = "טֶקֶס הַכָּרַת פָּנִים", translation = "церемония знакомства (на симпозиуме)",
            definition = "מִפְגָּשׁ הַתָּחָלָתִי בּוֹ מַשְׁתַּתְּפֵי כֶּנֶס מַצִּיגִים אֶת עַצְמָם זֶה לָזֶה.",
            definitionNative = "Начальный сбор, на котором участники симпозиума представляются друг другу.",
            example = "טֶקֶס הַכָּרַת פָּנִים נִפְתַּח בִּצְלִילֵי כִּנּוֹר.",
            exampleNative = "טֶקֶס הַכָּרַת פָּנִים открылся скрипичной музыкой.",
         fillInBlankExclusions = listOf(170906L, 170907L, 170908L, 170909L)),

        // ── greeting_letter_address (5 EPIC) — формы письменного обращения ──
        WordEntity(
            id = 170911, setId = 1709, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "greeting_letter_address", transliteration = "lichvod hanichbad",
            original = "לִכְבוֹד הַנִּכְבָּד", translation = "Глубокоуважаемому (в начале письма)",
            definition = "פְּתִיחָה רִשְׁמִית לְמִכְתָּב לְאָדָם בַּעַל מַעֲמָד גָּבוֹהַּ.",
            definitionNative = "Формальный зачин письма к лицу высокого общественного положения.",
            example = "הוּא פָּתַח אֶת הַמִּכְתָּב בְּ\"לִכְבוֹד הַנִּכְבָּד\".",
            exampleNative = "Он начал письмо строкой לִכְבוֹד הַנִּכְבָּד.",
         fillInBlankExclusions = listOf(170912L, 170913L, 170914L, 170915L)),
        WordEntity(
            id = 170912, setId = 1709, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "greeting_letter_address", transliteration = "bevirkat hokara",
            original = "בְּבִרְכַּת הוֹקָרָה", translation = "С уважением (в концовке письма)",
            definition = "נֻסַּח חֲתִימָה רִשְׁמִית בְּמִכְתָּב לִפְנֵי שֵׁם הַשּׁוֹלֵחַ.",
            definitionNative = "Формальная подпись в конце официального письма перед именем отправителя.",
            example = "הוּא חָתַם אֶת הַמִּכְתָּב בְּ\"בְּבִרְכַּת הוֹקָרָה\".",
            exampleNative = "Он закрыл письмо словами בְּבִרְכַּת הוֹקָרָה.",
         fillInBlankExclusions = listOf(170911L, 170913L, 170914L, 170915L)),
        WordEntity(
            id = 170913, setId = 1709, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "greeting_letter_address", transliteration = "lichvod adoni hanikhbad",
            original = "לִכְבוֹד אֲדוֹנִי הַנִּכְבָּד", translation = "Глубокоуважаемый господин",
            definition = "פְּתִיחָה רִשְׁמִית מַדְגִּישָׁה לְמִכְתָּב אֶל גֶּבֶר בְּמַעֲמָד מְכֻבָּד.",
            definitionNative = "Усиленный формальный зачин письма к мужчине высокого статуса.",
            example = "לִכְבוֹד אֲדוֹנִי הַנִּכְבָּד, הִנְּנִי לְהוֹדִיעַ.",
            exampleNative = "לִכְבוֹד אֲדוֹנִי הַנִּכְבָּד, имею честь сообщить.",
         fillInBlankExclusions = listOf(170911L, 170912L, 170914L, 170915L)),
        WordEntity(
            id = 170914, setId = 1709, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "greeting_letter_address", transliteration = "hineni lehodia",
            original = "הִנְּנִי לְהוֹדִיעַ", translation = "Имею честь сообщить (формула)",
            definition = "פְּתִיחָה רִשְׁמִית מְקֻבֶּלֶת בְּמִכְתַּב הוֹדָעָה רֶשֶׁמִית מִמּוֹסֶד.",
            definitionNative = "Принятая формальная фраза в начале служебного уведомления от учреждения.",
            example = "הִנְּנִי לְהוֹדִיעַ עַל קַבָּלָתְךָ לַתַּפְקִיד.",
            exampleNative = "הִנְּנִי לְהוֹדִיעַ о вашем назначении на должность.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 170915, setId = 1709, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "greeting_letter_address", transliteration = "be-yedidut rabba",
            original = "בִּידִידוּת רַבָּה", translation = "С глубоким дружеским расположением",
            definition = "חֲתִימַת מִכְתָּב בִּלְתִּי רִשְׁמִית מְלֻוָּה בְּהַבָּעַת קִרְבָה.",
            definitionNative = "Полу-формальная концовка письма с выражением сердечной близости.",
            example = "הוּא סִיֵּם אֶת הָאִיגֶּרֶת בְּ\"בִּידִידוּת רַבָּה\".",
            exampleNative = "Он завершил послание словами בִּידִידוּת רַבָּה.",
         fillInBlankExclusions = listOf(170911L, 170912L, 170913L, 170914L)),

        // ── greeting_torah_quotes (5 LEGENDARY) — цитаты Торы и пословиц ──
        WordEntity(
            id = 170916, setId = 1709, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "greeting_torah_quotes", transliteration = "shalom rav",
            original = "שָׁלוֹם רָב", translation = "Великий мир (благословение из Псалмов)",
            definition = "בְּרָכָה תַּנָּכִית מִתְּהִלִּים, מְשַׁמֶּשֶׁת כִּפְתִיחָה גְּבוֹהָה.",
            definitionNative = "Библейское благословение из Псалмов, употребляется как высокий зачин.",
            example = "הָרַב בֵּרֵךְ אֶת הַקָּהָל בְּ\"שָׁלוֹם רָב\".",
            exampleNative = "Раввин благословил собрание словами שָׁלוֹם רָב.",
         fillInBlankExclusions = listOf(170917L, 170918L, 170919L, 170920L)),
        WordEntity(
            id = 170917, setId = 1709, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "greeting_torah_quotes", transliteration = "barukh haba beshem adonai",
            original = "בָּרוּךְ הַבָּא בְּשֵׁם יְיָ", translation = "Благословен идущий во имя Господне",
            definition = "פָּסוּק מִתְּהִלִּים הַמְיֻעָד לִקְבָלַת אוֹרֵחַ נִכְבָּד אוֹ עוֹלֶה לָרֶגֶל.",
            definitionNative = "Стих из Псалмов для встречи почётного гостя или паломника.",
            example = "אָמְרוּ לוֹ \"בָּרוּךְ הַבָּא בְּשֵׁם יְיָ\".",
            exampleNative = "Ему сказали בָּרוּךְ הַבָּא בְּשֵׁם יְיָ при входе.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 170918, setId = 1709, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "greeting_torah_quotes", transliteration = "kekhol hayotse mipiv",
            original = "כְּכָל הַיּוֹצֵא מִפִּיו", translation = "Всё, что вышло из уст его (формула обета)",
            definition = "צִיטוּט מִסֵּפֶר בַּמִּדְבָּר, מְשַׁמֵּשׁ פְּתִיחַת בְּרָכָה רִשְׁמִית בְּקֶהִילָּה.",
            definitionNative = "Цитата из Книги Чисел, открывает формальное благословение в общине.",
            example = "הָרַב צִטֵּט \"כְּכָל הַיּוֹצֵא מִפִּיו\" בִּדְרָשָׁה.",
            exampleNative = "Раввин процитировал כְּכָל הַיּוֹצֵא מִפִּיו в проповеди.",
         fillInBlankExclusions = listOf(170916L, 170917L, 170919L, 170920L)),
        WordEntity(
            id = 170919, setId = 1709, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "greeting_torah_quotes", transliteration = "yevarekhekha adonai",
            original = "יְבָרֶכְךָ יְיָ", translation = "Да благословит тебя Господь (благословение коэнов)",
            definition = "פְּתִיחַת בִּרְכַּת כֹּהֲנִים, מְשַׁמֶּשֶׁת בְּטֶקֶסִים גְּבוֹהִים.",
            definitionNative = "Зачин жреческого благословения, звучит на торжественных церемониях.",
            example = "הַכֹּהֵן פָּתַח בְּ\"יְבָרֶכְךָ יְיָ\".",
            exampleNative = "Священник начал словами יְבָרֶכְךָ יְיָ.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 170920, setId = 1709, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "greeting_torah_quotes", transliteration = "lekhayim u-livracha",
            original = "לְחַיִּים וְלִבְרָכָה", translation = "Во здравие и во благословение (тост)",
            definition = "נֻסָּח גָּבוֹהַּ לְהֲרָמַת כּוֹסִית בְּאֵרוּעַ קְהִלָּתִי רִשְׁמִי.",
            definitionNative = "Возвышенная тостовая формула на формальном общинном торжестве.",
            example = "הוּא הֵרִים כּוֹס בְּ\"לְחַיִּים וְלִבְרָכָה\".",
            exampleNative = "Он поднял бокал со словами לְחַיִּים וְלִבְרָכָה.",
         fillInBlankExclusions = listOf(170916L, 170917L, 170918L, 170919L)),

        // ── greeting_condolences_celebrations (5 LEGENDARY) — соболезнования и поздравления ──
        WordEntity(
            id = 170921, setId = 1709, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "greeting_condolences_celebrations", transliteration = "yehi zikhro barukh",
            original = "יְהִי זִכְרוֹ בָּרוּךְ", translation = "Да будет благословенна память его",
            definition = "נֻסַּח רִשְׁמִי לְהַזְכָּרַת נִפְטָר בְּטֶקֶס אוֹ בְּהוֹדָעָה רֶשֶׁמִית.",
            definitionNative = "Формальная фраза при упоминании усопшего на церемонии или в извещении.",
            example = "הַמַּנְחֶה אָמַר \"יְהִי זִכְרוֹ בָּרוּךְ\" בָּאַזְכָּרָה.",
            exampleNative = "Ведущий произнёс יְהִי זִכְרוֹ בָּרוּךְ на поминальном собрании.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 170922, setId = 1709, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "greeting_condolences_celebrations", transliteration = "hishtatfut be-tsa'arkhem",
            original = "הִשְׁתַּתְּפוּת בְּצַעַרְכֶם", translation = "соболезнование (формальная формула)",
            definition = "הַבָּעַת כְּאֵב מְשֻׁתָּף לְמִשְׁפְּחַת אָבֵל בִּכְתָב אוֹ בִּדְבָרִים רֶשְׁמִיִּים.",
            definitionNative = "Выражение разделённой скорби семье усопших в письме или формальной речи.",
            example = "הוּא שָׁלַח דִּבְרֵי הִשְׁתַּתְּפוּת בְּצַעַרְכֶם.",
            exampleNative = "Он направил слова הִשְׁתַּתְּפוּת בְּצַעַרְכֶם семье покойного.",
         fillInBlankExclusions = listOf(170921L, 170923L, 170924L, 170925L)),
        WordEntity(
            id = 170923, setId = 1709, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "greeting_condolences_celebrations", transliteration = "tanchumim mekuvanim",
            original = "תַּנְחוּמִים מְכֻוָּנִים", translation = "адресные соболезнования",
            definition = "דִּבְרֵי נִחוּם רֶשְׁמִיִּים הַמְכֻוָּנִים אִישִׁית לִקְרוֹב מִשְׁפַּחְתּוֹ שֶׁל הַנִּפְטָר.",
            definitionNative = "Формальные слова утешения, лично обращённые к близкому родственнику покойного.",
            example = "הוּא הִקְרִיא תַּנְחוּמִים מְכֻוָּנִים בִּפְנֵי הָאַלְמָנָה.",
            exampleNative = "Он зачитал תַּנְחוּמִים מְכֻוָּנִים вдове.",
         fillInBlankExclusions = listOf(170921L, 170922L, 170924L, 170925L)),
        WordEntity(
            id = 170924, setId = 1709, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "greeting_condolences_celebrations", transliteration = "bekhol mo'adim u-zmanim",
            original = "בְּכָל מוֹעֲדִים וּזְמַנִּים", translation = "Во все праздники и времена (формула поздравлений)",
            definition = "נֻסָּח גָּבוֹהַּ לְבִרְכַּת חַג אוֹ אֵרוּעַ מַחְזוֹרִי קְהִלָּתִי.",
            definitionNative = "Возвышенная формула праздничного приветствия общинного циклического события.",
            example = "הָרַב בֵּרֵךְ \"בְּכָל מוֹעֲדִים וּזְמַנִּים\".",
            exampleNative = "Раввин благословил словами בְּכָל מוֹעֲדִים וּזְמַנִּים.",
         fillInBlankExclusions = listOf(170916L, 170919L, 170920L, 170921L, 170922L, 170923L, 170925L)),
        WordEntity(
            id = 170925, setId = 1709, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "greeting_condolences_celebrations", transliteration = "tvarkhu bematziv",
            original = "תְּבֹרְכוּ בְּמַצָּב", translation = "Будьте благословенны в положении вашем",
            definition = "נֻסַּח בְּרָכָה מְכֻבָּד הַמְלַוֶּה הוֹדָעָה רֶשֶׁמִית עַל הִישֵּׂג אוֹ אֵרוּעַ שִׂמְחָה.",
            definitionNative = "Почтительная формула благословения, сопровождающая официальное извещение о торжестве.",
            example = "הַמִּכְתָּב נֶחְתַּם בְּ\"תְּבֹרְכוּ בְּמַצָּב\".",
            exampleNative = "Письмо подписали словами תְּבֹרְכוּ בְּמַצָּב.",
         fillInBlankExclusions = listOf(170912L, 170915L, 170921L, 170922L, 170923L, 170924L)),
    )
}
