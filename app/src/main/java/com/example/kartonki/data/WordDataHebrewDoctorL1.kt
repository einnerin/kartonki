package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "У врача в Израиле" (приём, симптомы, лекарства).
 *
 * Set 1802: «У врача в Израиле» — основы (L1, COMMON+UNCOMMON):
 *           базовая лексика приёма у израильского врача — кто принимает,
 *           что болит, какие лекарства, что говорят и куда идут потом.
 *
 * Тема ориентирована на русскоязычных репатриантов, которые впервые приходят
 * в кабинет врача в Израиле: открывают תּוֹר в קוּפָּה, объясняют где כְּאֵב,
 * получают מִרְשָׁם и идут в אַפְטֵקָה. Сценарий — реальный поход к семейному
 * врачу или педиатру.
 *
 * Кросс-тематические пересечения с темой «Медицина» (1600-1606) допустимы по
 * правилу: дубли `original` между РАЗНЫМИ темами разрешены. Тема «Медицина»
 * фокусируется на анатомии, обследованиях и специалистах; тема «У врача в
 * Израиле» — на разговорной лексике самого приёма.
 *
 * Распределение редкостей:
 *   Set 1802: 13 COMMON + 12 UNCOMMON.
 *
 * SemanticGroups (5 × 5):
 *   doctor_basic_people    — кто в кабинете: врач, медсестра, санитар,
 *                            больной, регистратор
 *   doctor_basic_symptoms  — что чувствует пациент: боль, температура,
 *                            кашель, простуда, головокружение
 *   doctor_basic_meds      — что прописывают: лекарство, рецепт, таблетка,
 *                            сироп, мазь
 *   doctor_basic_actions   — что делают на приёме: записаться, измерить
 *                            температуру, выздороветь, пить лекарство, отдыхать
 *   doctor_basic_visit     — слова визита: очередь, кабинет, рекомендации,
 *                            больничный, выдача справки
 *
 * Word IDs: setId × 100 + position (180201..180225).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewDoctorL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1802, languagePair = "he-ru", orderIndex = 1802,
            name = "У врача в Израиле",
            description = "Базовая лексика приёма: врач, боль, рецепт, лекарство, симптомы",
            topic = "У врача в Израиле", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1802 — У врача в Израиле: основы (L1, COMMON+UNCOMMON, A1-A2)
        // 5 групп × 5 слов: people, symptoms, meds, actions, visit
        // ══════════════════════════════════════════════════════════════════════

        // ── doctor_basic_people (5) — кто в кабинете ──
        WordEntity(
            id = 180201, setId = 1802, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "doctor_basic_people", transliteration = "rofe",
            original = "רוֹפֵא", translation = "врач",
            definition = "אִישׁ מִקְצוֹעַ שֶׁמְּטַפֵּל בַּחוֹלִים וְכוֹתֵב מִרְשָׁם לִתְרוּפוֹת.",
            definitionNative = "Специалист, что лечит больных и выписывает рецепты на лекарства.",
            example = "רוֹפֵא מִשְׁפָּחָה בְּדַק אוֹתִי וְשָׁלַח לִבְדִיקוֹת דָּם.",
            exampleNative = "Семейный רוֹפֵא осмотрел меня и отправил на анализы крови.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180202, setId = 1802, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "doctor_basic_people", transliteration = "akhot",
            original = "אָחוֹת", translation = "медсестра",
            definition = "אִשָּׁה שֶׁעוֹזֶרֶת לָרוֹפֵא, נוֹתֶנֶת זְרִיקוֹת וּמוֹדֶדֶת לַחַץ דָּם.",
            definitionNative = "Женщина, что помогает врачу — делает уколы и измеряет давление.",
            example = "הָאָחוֹת לָקְחָה לִי דָּם בְּלִי כְּאֵב לִפְנֵי הַבְּדִיקָה.",
            exampleNative = "אָחוֹת взяла у меня кровь без боли перед обследованием.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180203, setId = 1802, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "doctor_basic_people", transliteration = "metapel",
            original = "מְטַפֵּל", translation = "санитар (ухаживающий)",
            definition = "עוֹבֵד שֶׁשּׁוֹמֵר עַל הַחוֹלֶה — מַאֲכִיל, מְלַוֶּוה וְעוֹזֵר לָקוּם.",
            definitionNative = "Сотрудник, что ходит за больным — кормит, сопровождает и помогает встать.",
            example = "הַמְּטַפֵּל בַּמַּחְלָקָה עָזַר לְסַבָּא לָלֶכֶת לַשֵּׁרוּתִים.",
            exampleNative = "מְטַפֵּל в отделении помог дедушке дойти до туалета.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180204, setId = 1802, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "doctor_basic_people", transliteration = "khole",
            original = "חוֹלֶה", translation = "больной (пациент)",
            definition = "אָדָם שֶׁמַּרְגִּישׁ רַע אוֹ יֵשׁ לוֹ מַחֲלָה וְצָרִיךְ טִפּוּל.",
            definitionNative = "Человек, что плохо себя чувствует или болеет и нуждается в лечении.",
            example = "כָּל חוֹלֶה מְחַכֶּה בַּמִּסְדְּרוֹן עִם תְּעוּדַת זֶהוּת בַּיָּד.",
            exampleNative = "Каждый חוֹלֶה ждёт в коридоре с удостоверением в руке.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180205, setId = 1802, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "doctor_basic_people", transliteration = "mazkira",
            original = "מַזְכִּירָה", translation = "регистратор (в клинике)",
            definition = "אִשָּׁה בִּכְנִיסָה לַמִּרְפָּאָה שֶׁרוֹשֶׁמֶת חוֹלִים וְעוֹנָה לַטֶּלֶפוֹן.",
            definitionNative = "Женщина у входа в клинику — записывает больных и отвечает на звонки.",
            example = "הַמַּזְכִּירָה בַּקֻּפָּה הִדְפִּיסָה לִי טֹפֶס לַבְּדִיקָה.",
            exampleNative = "מַזְכִּירָה в кассе распечатала мне форму для обследования.",
            isFillInBlankSafe = false,
        ),

        // ── doctor_basic_symptoms (5) — что чувствует пациент ──
        WordEntity(
            id = 180206, setId = 1802, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "doctor_basic_symptoms", transliteration = "ke'ev",
            original = "כְּאֵב", translation = "боль",
            definition = "תְּחוּשָׁה לֹא נְעִימָה בַּגּוּף — חַד אוֹ עַמּוּם, קָצָר אוֹ אָרֹךְ.",
            definitionNative = "Неприятное ощущение в теле — острое или тупое, краткое или долгое.",
            example = "מֵאָז הַבֹּקֶר יֵשׁ לִי כְּאֵב חָזָק בַּגַּב הַתַּחְתּוֹן.",
            exampleNative = "С самого утра у меня сильный כְּאֵב в пояснице.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180207, setId = 1802, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "doctor_basic_symptoms", transliteration = "khom",
            original = "חֹם", translation = "температура (жар)",
            definition = "מַצָּב שֶׁבּוֹ הַגּוּף חַם מִדַּי — לְרוֹב סִימָן שֶׁל הִצְטַנְּנוּת אוֹ זִיהוּם.",
            definitionNative = "Состояние, когда тело слишком горячее — обычно знак простуды или инфекции.",
            example = "לַיֶּלֶד יֵשׁ חֹם שֶׁל אַרְבָּעִים מַעֲלוֹת מֵאֶמֶשׁ.",
            exampleNative = "У ребёнка חֹם сорок градусов со вчерашнего вечера.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180208, setId = 1802, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "doctor_basic_symptoms", transliteration = "shi'ul",
            original = "שִׁעוּל", translation = "кашель",
            definition = "פְּלִיטַת אֲוִיר חֲזָקָה מֵהַגָּרוֹן — לְרֹב כְּשֶׁמַּשֶּׁהוּ מַפְרִיעַ שָׁם.",
            definitionNative = "Резкий выброс воздуха из горла — обычно когда там что-то мешает.",
            example = "שִׁעוּל יָבֵשׁ לֹא נוֹתֵן לִי לִישׁוֹן כְּבָר שָׁבוּעַ.",
            exampleNative = "Сухой שִׁעוּל не даёт мне спать уже неделю.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180209, setId = 1802, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "doctor_basic_symptoms", transliteration = "tsina",
            original = "צִנָּה", translation = "простуда",
            definition = "מַחֲלָה קַלָּה שֶׁל הָאַף וְהַגָּרוֹן עִם נַזֶּלֶת וְקְצָת חֹם.",
            definitionNative = "Лёгкая болезнь носа и горла с насморком и небольшой температурой.",
            example = "תָּפַסְתִּי צִנָּה אַחֲרֵי שֶׁיָּצָאתִי לַגֶּשֶׁם בְּלִי מְעִיל.",
            exampleNative = "Я подхватил צִנָּה после того, как вышел под дождь без куртки.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180210, setId = 1802, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "doctor_basic_symptoms", transliteration = "skharkhoret",
            original = "סְחַרְחֹרֶת", translation = "головокружение",
            definition = "תְּחוּשָׁה שֶׁהַחֶדֶר סוֹבֵב סְבִיבְךָ וְקָשֶׁה לַעֲמֹד יָשָׁר.",
            definitionNative = "Ощущение, будто комната вращается вокруг — и трудно стоять прямо.",
            example = "קַמְתִּי מַהֵר מֵהַמִּטָּה וְהִרְגַּשְׁתִּי סְחַרְחֹרֶת חֲזָקָה.",
            exampleNative = "Я быстро встал с кровати и почувствовал сильное סְחַרְחֹרֶת.",
            isFillInBlankSafe = false,
        ),

        // ── doctor_basic_meds (5) — что прописывают ──
        WordEntity(
            id = 180211, setId = 1802, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "doctor_basic_meds", transliteration = "trufa",
            original = "תְּרוּפָה", translation = "лекарство",
            definition = "חֹמֶר שֶׁלּוֹקְחִים כְּדֵי לְהַרְגִּישׁ טוֹב יוֹתֵר אוֹ לְהָקֵל עַל מַחֲלָה.",
            definitionNative = "Вещество, что принимают, чтобы стало лучше или болезнь полегчала.",
            example = "הָרוֹפֵא רָשַׁם לִי תְּרוּפָה חֲדָשָׁה לְלַחַץ דָּם.",
            exampleNative = "Врач выписал мне новое תְּרוּפָה от давления.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180212, setId = 1802, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "doctor_basic_meds", transliteration = "mirsham",
            original = "מִרְשָׁם", translation = "рецепт",
            definition = "פֶּתֶק מֵהָרוֹפֵא שֶׁמַּרְשֶׁה לָקַחַת תְּרוּפָה מְסֻיֶּמֶת בְּבֵית הַמִּרְקַחַת.",
            definitionNative = "Бумажка от врача — разрешает забрать определённое лекарство в аптеке.",
            example = "שָׁכַחְתִּי אֶת הַמִּרְשָׁם בַּבַּיִת וְהָלַכְתִּי שׁוּב לַמִּרְפָּאָה.",
            exampleNative = "Я забыл מִרְשָׁם дома и снова пошёл в клинику.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180213, setId = 1802, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "doctor_basic_meds", transliteration = "glula",
            original = "גְּלוּלָה", translation = "пилюля (таблетка)",
            definition = "כַּדּוּר קָטָן עָגֹל שֶׁבּוֹלְעִים עִם מַיִם בְּסוֹף הָאֲרוּחָה.",
            definitionNative = "Маленький круглый шарик — глотают с водой в конце еды.",
            example = "אֲנִי לוֹקַחַת גְּלוּלָה אַחַת בַּבֹּקֶר וְעוֹד אַחַת בָּעֶרֶב.",
            exampleNative = "Я принимаю одну גְּלוּלָה утром и ещё одну вечером.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180214, setId = 1802, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "doctor_basic_meds", transliteration = "sirop",
            original = "סִירוֹפּ", translation = "сироп",
            definition = "תְּרוּפָה נוֹזְלִית מְתוּקָה שֶׁשּׁוֹתִים עִם כַּפִּית מְיֻחֶדֶת.",
            definitionNative = "Сладкое жидкое средство — пьют со специальной ложечкой.",
            example = "נָתַתִּי לַיֶּלֶד סִירוֹפּ לְשִׁעוּל לִפְנֵי הַשֵּׁנָה.",
            exampleNative = "Я дал ребёнку סִירוֹפּ от кашля перед сном.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180215, setId = 1802, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "doctor_basic_meds", transliteration = "mishkha",
            original = "מִשְׁחָה", translation = "мазь",
            definition = "חֹמֶר סָמִיךְ שֶׁמּוֹרְחִים עַל הָעוֹר בִּמְקוֹם שֶׁכּוֹאֵב אוֹ מְגָרֵד.",
            definitionNative = "Густое средство — мажут на кожу там, где болит или чешется.",
            example = "מָרַחְתִּי מִשְׁחָה עַל הַכְּתֵפַיִים אַחֲרֵי הַשֶּׁמֶשׁ הַחֲזָקָה.",
            exampleNative = "Я намазал מִשְׁחָה на плечи после сильного солнца.",
            isFillInBlankSafe = false,
        ),

        // ── doctor_basic_actions (5) — что делают на приёме ──
        WordEntity(
            id = 180216, setId = 1802, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "doctor_basic_actions", transliteration = "likbo'a tor",
            original = "לִקְבֹּעַ תּוֹר", translation = "записаться на приём",
            definition = "לִתְפֹּס מָקוֹם וְשָׁעָה אֵצֶל הָרוֹפֵא דֶּרֶךְ הַטֶּלֶפוֹן אוֹ הָאֲתָר.",
            definitionNative = "Занять место и время у врача — по телефону или через сайт.",
            example = "הִצְלַחְתִּי לִקְבֹּעַ תּוֹר רַק לְעוֹד שְׁבוּעַיִם.",
            exampleNative = "Мне удалось לִקְבֹּעַ תּוֹר только через две недели.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180217, setId = 1802, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "doctor_basic_actions", transliteration = "limdod khom",
            original = "לִמְדֹּד חֹם", translation = "измерить температуру",
            definition = "לִבְדֹּק כַּמָּה חַם הַגּוּף בְּעֶזְרַת מַד חֹם תַּחַת הַלָּשׁוֹן אוֹ הַשֶּׁחִי.",
            definitionNative = "Проверить, насколько горячее тело — градусником под язык или подмышку.",
            example = "אִמָּא בִּקְּשָׁה לִמְדֹּד חֹם לִפְנֵי שֶׁתֵּלֵךְ לַגַּן.",
            exampleNative = "Мама попросила לִמְדֹּד חֹם, прежде чем идти в садик.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180218, setId = 1802, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "doctor_basic_actions", transliteration = "lehitrape",
            original = "לְהִתְרַפֵּא", translation = "выздоравливать",
            definition = "לַחֲזֹר לְהַרְגִּישׁ טוֹב אַחֲרֵי מַחֲלָה אוֹ פְּצִיעָה.",
            definitionNative = "Снова чувствовать себя хорошо — после болезни или ушиба.",
            example = "כְּדֵי לְהִתְרַפֵּא מַהֵר חָשׁוּב לִשְׁתּוֹת הַרְבֵּה מַיִם וְלָנוּחַ.",
            exampleNative = "Чтобы быстро לְהִתְרַפֵּא, важно много пить воды и отдыхать.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180219, setId = 1802, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "doctor_basic_actions", transliteration = "lishtot trufa",
            original = "לִשְׁתּוֹת תְּרוּפָה", translation = "пить лекарство",
            definition = "לָקַחַת אֶת מַה שֶּׁהָרוֹפֵא רָשַׁם בִּזְמַן הַנָּכוֹן וּבַמִּינוּן הַנָּכוֹן.",
            definitionNative = "Принимать то, что врач выписал — в нужное время и в нужной дозе.",
            example = "אָסוּר לִשְׁכֹּחַ לִשְׁתּוֹת תְּרוּפָה אֲפִילּוּ פַּעַם אַחַת בַּשָּׁבוּעַ.",
            exampleNative = "Нельзя забывать לִשְׁתּוֹת תְּרוּפָה даже один раз за неделю.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180220, setId = 1802, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "doctor_basic_actions", transliteration = "lanuakh",
            original = "לָנוּחַ", translation = "отдыхать",
            definition = "לְהַפְסִיק לַעֲשׂוֹת מַשֶּׁהוּ וְלָתֵת לַגּוּף לֶאֱסֹף כֹּחַ — בִּשְׁכִיבָה אוֹ בְּשֵׁנָה.",
            definitionNative = "Перестать что-то делать и дать телу набрать силы — лёжа или во сне.",
            example = "הָרוֹפֵא אָמַר לִי לָנוּחַ בַּבַּיִת לְפָחוֹת שְׁלוֹשָׁה יָמִים.",
            exampleNative = "Врач сказал мне לָנוּחַ дома хотя бы три дня.",
            isFillInBlankSafe = false,
        ),

        // ── doctor_basic_visit (5) — слова визита ──
        WordEntity(
            id = 180221, setId = 1802, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "doctor_basic_visit", transliteration = "tor",
            original = "תּוֹר", translation = "очередь / запись",
            definition = "מָקוֹם וְשָׁעָה שֶׁמְּחַכִּים בָּהֶם לְפֶגִישָׁה עִם הָרוֹפֵא.",
            definitionNative = "Место и время, где ждут встречи с врачом.",
            example = "יֵשׁ לִי תּוֹר אֵצֶל רוֹפֵא מִשְׁפָּחָה בְּאַרְבַּע אַחַר הַצָּהֳרַיִם.",
            exampleNative = "У меня תּוֹר к семейному врачу в четыре часа дня.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180222, setId = 1802, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "doctor_basic_visit", transliteration = "kheder rofe",
            original = "חֶדֶר רוֹפֵא", translation = "кабинет врача",
            definition = "חֶדֶר קָטָן בַּמִּרְפָּאָה שֶׁבּוֹ הָרוֹפֵא בּוֹדֵק וּמְקַבֵּל חוֹלִים.",
            definitionNative = "Маленькая комната в клинике — там врач смотрит и принимает больных.",
            example = "נִכְנַסְתִּי לְחֶדֶר רוֹפֵא וְהָרְגַּשְׁתִּי מִיָּד יוֹתֵר רָגוּעַ.",
            exampleNative = "Я зашёл в חֶדֶר רוֹפֵא и сразу почувствовал себя спокойнее.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180223, setId = 1802, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "doctor_basic_visit", transliteration = "hamlatsot",
            original = "הֶמְלָצוֹת", translation = "рекомендации (врача)",
            definition = "מַה שֶׁהָרוֹפֵא מְבַקֵּשׁ לַעֲשׂוֹת אַחֲרֵי הַבִּיקוּר — לִשְׁתּוֹת, לָנוּחַ, לַחֲזֹר.",
            definitionNative = "Что врач просит сделать после визита — пить, отдыхать, прийти снова.",
            example = "קִבַּלְתִּי דַּף עִם הֶמְלָצוֹת לַשָּׁבוּעַ הַקָּרוֹב.",
            exampleNative = "Я получил листок с הֶמְלָצוֹת на ближайшую неделю.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180224, setId = 1802, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "doctor_basic_visit", transliteration = "ishur makhala",
            original = "אִישּׁוּר מַחֲלָה", translation = "больничный лист",
            definition = "מִסְמָךְ מֵהָרוֹפֵא שֶׁמַּרְשֶׁה לֹא לָבוֹא לָעֲבוֹדָה בִּזְמַן מַחֲלָה.",
            definitionNative = "Документ от врача — разрешает не приходить на работу во время болезни.",
            example = "שָׁלַחְתִּי לַמְּנַהֵל אִישּׁוּר מַחֲלָה לְשָׁלוֹשׁ יָמִים.",
            exampleNative = "Я отправил руководителю אִישּׁוּר מַחֲלָה на три дня.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180225, setId = 1802, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "doctor_basic_visit", transliteration = "hanpakat ishur",
            original = "הַנְפָּקַת אִישּׁוּר", translation = "выдача справки",
            definition = "פְּעוּלָה שֶׁל הַמַּזְכִּירָה אוֹ הָרוֹפֵא — מוֹסְרִים לְךָ נְיָר רִשְׁמִי בַּיָּד.",
            definitionNative = "Действие регистратора или врача — выдают тебе официальную бумагу в руки.",
            example = "הִתְעַכַּבְתִּי בַּקֻּפָּה בִּגְלַל הַנְפָּקַת אִישּׁוּר לַמַּעֲסִיק.",
            exampleNative = "Я задержался в кассе из-за הַנְפָּקַת אִישּׁוּר для работодателя.",
            isFillInBlankSafe = false,
        ),
    )
}
