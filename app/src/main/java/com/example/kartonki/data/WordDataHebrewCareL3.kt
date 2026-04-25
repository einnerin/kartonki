package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary: Care, level 3 (1 set, 25 words).
 * Углублённая лексика опытной сиделки/ухаживающей: специфика возрастных
 * пациентов, базовые медицинские манипуляции, перемещение лежачих,
 * общение с семьёй и документация ухода.
 *
 * Set 1725 (level 3, RARE + EPIC) — заполняет уровень между level 2 (1311)
 * и level 4 (1312, 1313) в теме «Уход».
 *
 * Не пересекается с уже существующими сетами темы «Уход»
 * (1310 L1, 1338 L1, 1311 L2, 1312 L4, 1313 L4, 1314 L5). Допустимы пересечения
 * с темами «Медсестра», «Медицина», «Социальный работник».
 *
 * Распределение редкостей: 15 RARE + 10 EPIC (2 смежных уровня).
 *
 * Пять подгрупп по 5 слов каждая:
 *   care_age_specifics       — особенности возрастного подопечного
 *   care_medical_basics      — базовые медицинские манипуляции
 *   care_mobility            — перемещение лежачего и поддержка движения
 *   care_family_communication — общение с семьёй подопечного
 *   care_documentation       — документация и отчётность
 */
object WordDataHebrewCareL3 {

    val sets = listOf(
        WordSetEntity(
            id = 1725, languagePair = "he-ru", orderIndex = 1725,
            name = "Уход",
            description = "Возрастные особенности, манипуляции, семья, документация",
            topic = "Уход", level = 3,
        ),
    )

    val words = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1725 — Уход: углублённый (RARE + EPIC, B2–C1)
        // 5 групп × 5 слов
        // ══════════════════════════════════════════════════════════════════════

        // ── care_age_specifics (5) — особенности возрастного подопечного ──
        WordEntity(
            id = 172501, setId = 1725, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "care_age_specifics", transliteration = "itiyut gil",
            original = "אִטִּיוּת גִּיל", translation = "возрастная заторможенность",
            definition = "תְּגוּבָה אִטִּית יוֹתֵר שֶׁל זָקֵן לְמַה שֶּׁקּוֹרֶה סְבִיבוֹ.",
            definitionNative = "Замедленная реакция пожилого на то, что происходит вокруг.",
            example = "אִטִּיוּת גִּיל דּוֹרֶשֶׁת סַבְלָנוּת בְּכָל פְּעֻלָּה יוֹמִית.",
            exampleNative = "אִטִּיוּת גִּיל требует терпения в каждом обыденном действии.", fillInBlankExclusions = listOf(172502L, 172503L, 172504L, 172505L)),
        WordEntity(
            id = 172502, setId = 1725, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "care_age_specifics", transliteration = "tasmonet shki'at hashemesh",
            original = "תַּסְמוֹנֶת שְׁקִיעַת הַשֶּׁמֶשׁ", translation = "синдром заходящего солнца",
            definition = "מַצָּב שֶׁבּוֹ קַשִּׁישׁ נַעֲשֶׂה בִּלְבּוּל וְעַצְבָּנִי לְקַרַאת הָעֶרֶב.",
            definitionNative = "Состояние, когда старик к вечеру становится спутанным и тревожным.",
            example = "תַּסְמוֹנֶת שְׁקִיעַת הַשֶּׁמֶשׁ מוֹפִיעָה אֶצְלָהּ בְּסָבִיב שֵׁשׁ.",
            exampleNative = "תַּסְמוֹנֶת שְׁקִיעַת הַשֶּׁמֶשׁ появляется у неё около шести вечера."),
        WordEntity(
            id = 172503, setId = 1725, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "care_age_specifics", transliteration = "yerida bir'iya",
            original = "יְרִידָה בִּרְאִיָּה", translation = "ослабление зрения",
            definition = "פְּחָת הֲדַרְגָּתִי בִּיכֹלֶת הָעַיִן לִרְאוֹת בְּבַהִירוּת.",
            definitionNative = "Постепенный спад способности глаза видеть чётко.",
            example = "יְרִידָה בִּרְאִיָּה מַקְשָׁה עָלֶיהָ לִקְרֹא תַּוֵּי הַתְּרוּפוֹת.",
            exampleNative = "יְרִידָה בִּרְאִיָּה мешает ей читать наклейки на лекарствах.", fillInBlankExclusions = listOf(172501L, 172502L, 172504L, 172505L)),
        WordEntity(
            id = 172504, setId = 1725, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "care_age_specifics", transliteration = "reyakh zikna",
            original = "רֵיחַ זִקְנָה", translation = "стариковский запах",
            definition = "רֵיחַ אָפְיָנִי שֶׁל גּוּף קַשִּׁישׁ הַנּוֹבֵעַ מִשִּׁנּוּי בָּעוֹר.",
            definitionNative = "Особый запах тела старика — от изменений в коже и поте.",
            example = "רֵיחַ זִקְנָה נֶחְלָשׁ אַחֲרֵי מִקְלַחַת חַמָּה וּבְגָדִים נְקִיִּים.",
            exampleNative = "רֵיחַ זִקְנָה ослабевает после тёплого душа и чистой одежды.", fillInBlankExclusions = listOf(172501L, 172502L, 172503L, 172505L)),
        WordEntity(
            id = 172505, setId = 1725, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "care_age_specifics", transliteration = "shikh'kha mitmasheket",
            original = "שִׁכְחָה מִתְמַשֶּׁכֶת", translation = "затяжная забывчивость",
            definition = "אָבְדַּן זִכָּרוֹן יוֹם-יוֹמִי שֶׁמִּתְמַשֵּׁךְ עַל פְּנֵי שָׁבוּעוֹת רְצוּפִים.",
            definitionNative = "Каждодневная потеря памяти, тянущаяся неделями подряд.",
            example = "שִׁכְחָה מִתְמַשֶּׁכֶת מַחֲמִירָה בִּקְפִיצוֹת בְּמַצְבֵי לַחַץ.",
            exampleNative = "שִׁכְחָה מִתְמַשֶּׁכֶת скачкообразно усиливается в стрессовых ситуациях.", fillInBlankExclusions = listOf(172501L, 172502L, 172503L, 172504L)),

        // ── care_medical_basics (5) — базовые медицинские манипуляции ──
        WordEntity(
            id = 172506, setId = 1725, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "care_medical_basics", transliteration = "mad lakhats dam",
            original = "מַד לַחַץ דָּם", translation = "тонометр",
            definition = "מַכְשִׁיר שֶׁמּוֹדֵד אֶת הַכֹּחַ שֶׁל הַזְּרִימָה בָּעוֹרְקִים.",
            definitionNative = "Прибор, измеряющий силу потока крови в артериях.",
            example = "מַד לַחַץ דָּם רוֹשֵׁם אֶת הַתְּוָצוֹת בְּכָל בֹּקֶר.",
            exampleNative = "מַד לַחַץ דָּם записывает результаты каждое утро.", fillInBlankExclusions = listOf(172507L, 172508L, 172509L, 172510L)),
        WordEntity(
            id = 172507, setId = 1725, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "care_medical_basics", transliteration = "mad khom digitali",
            original = "מַד חֹם דִּיגִיטָלִי", translation = "электронный термометр",
            definition = "מַכְשִׁיר אֶלֶקְטְרוֹנִי שֶׁמַּרְאֶה אֶת הַחֹם שֶׁל הַגּוּף בְּמִסְפָּר.",
            definitionNative = "Электронный прибор, показывающий тепло тела цифрой на экране.",
            example = "מַד חֹם דִּיגִיטָלִי מַשְׁמִיעַ צְפִיפָה אַחֲרֵי שְׁתֵּי שְׁנִיּוֹת.",
            exampleNative = "מַד חֹם דִּיגִיטָלִי пищит через две секунды после замера.", fillInBlankExclusions = listOf(172506L, 172508L, 172509L, 172510L)),
        WordEntity(
            id = 172508, setId = 1725, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "care_medical_basics", transliteration = "pulsometer",
            original = "פּוּלְסוֹמֶטֶר", translation = "пульсоксиметр",
            definition = "מַכְשִׁיר קָטָן עַל הָאֶצְבַּע שֶׁמַּרְאֶה דֹּפֶק וְחַמְצָן בַּדָּם.",
            definitionNative = "Маленький прибор на палец, показывающий ритм сердца и кислород.",
            example = "פּוּלְסוֹמֶטֶר נִצְמַד לָאֶצְבַּע וְנוֹתֵן תּוֹצָאָה תּוֹךְ דַּקָּה.",
            exampleNative = "פּוּלְסוֹמֶטֶר надевается на палец и даёт результат за минуту."),
        WordEntity(
            id = 172509, setId = 1725, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "care_medical_basics", transliteration = "tipul be-petsa lakhats",
            original = "טִיפּוּל בְּפֶצַע לַחַץ", translation = "обработка пролежня",
            definition = "נִקּוּי וְחִבּוּשׁ פֶּצַע שֶׁנּוֹצַר מִשְּׁכִיבָה רְצוּפָה בְּאוֹתוֹ מָקוֹם.",
            definitionNative = "Чистка и перевязка раны от долгого лежания на одном месте.",
            example = "טִיפּוּל בְּפֶצַע לַחַץ נַעֲשֶׂה כָּל אַרְבַּע שָׁעוֹת בְּלִי דִּלּוּג.",
            exampleNative = "טִיפּוּל בְּפֶצַע לַחַץ делается каждые четыре часа без пропусков.", fillInBlankExclusions = listOf(172506L, 172507L, 172510L, 172513L)),
        WordEntity(
            id = 172510, setId = 1725, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "care_medical_basics", transliteration = "medidat khom",
            original = "מְדִידַת חֹם", translation = "термометрия",
            definition = "בְּדִיקָה שֶׁל חֹם הַגּוּף בְּשָׁעוֹת קְבוּעוֹת לְאֹרֶךְ הַיּוֹם.",
            definitionNative = "Проверка температуры тела в установленные часы за сутки.",
            example = "מְדִידַת חֹם נִרְשֶׁמֶת בַּטֹּפֶס שָׁלוֹשׁ פְּעָמִים בַּיּוֹם.",
            exampleNative = "מְדִידַת חֹם записывается в бланк трижды за день.", fillInBlankExclusions = listOf(172506L, 172507L, 172509L, 172511L, 172512L)),

        // ── care_mobility (5) — перемещение лежачего и поддержка движения ──
        WordEntity(
            id = 172511, setId = 1725, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "care_mobility", transliteration = "tezuza mimita",
            original = "תְּזוּזָה מִמִּטָּה", translation = "перевод с кровати",
            definition = "הָעֲבָרָה זְהִירָה שֶׁל מְטוּפָּל מִשְּׁכִיבָה לִישִׁיבָה אוֹ עֲמִידָה.",
            definitionNative = "Бережный перевод подопечного из лежачего в сидячее или стоячее.",
            example = "תְּזוּזָה מִמִּטָּה נַעֲשֵׂית עִם תְּמִיכָה שֶׁל שְׁתֵּי יָדַיִם.",
            exampleNative = "תְּזוּזָה מִמִּטָּה выполняется с поддержкой обеими руками.", fillInBlankExclusions = listOf(172512L, 172513L, 172514L, 172515L)),
        WordEntity(
            id = 172512, setId = 1725, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "care_mobility", transliteration = "ha'avara lekise galgalim",
            original = "הַעֲבָרָה לְכִסֵּא גַּלְגַּלִּים", translation = "пересадка на кресло-каталку",
            definition = "מַעֲבָר שֶׁל אָדָם מֵהַמִּטָּה אוֹ הַסַּפָּה אֶל מוֹשָׁב עִם גַּלְגַּלִּים.",
            definitionNative = "Перемещение человека с кровати или дивана в сиденье на колёсах.",
            example = "הַעֲבָרָה לְכִסֵּא גַּלְגַּלִּים דּוֹרֶשֶׁת בְּלָמִים נְעוּלִים מֵרֹאשׁ.",
            exampleNative = "הַעֲבָרָה לְכִסֵּא גַּלְגַּלִּים требует заранее зажатых тормозов.", fillInBlankExclusions = listOf(172511L, 172513L, 172514L, 172515L)),
        WordEntity(
            id = 172513, setId = 1725, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "care_mobility", transliteration = "hipukh metupal",
            original = "הִיפּוּךְ מְטוּפָּל", translation = "переворачивание лежачего",
            definition = "סִבּוּב הַגּוּף מִצַּד אֶחָד לַשֵּׁנִי לִמְנִיעַת פְּצָעִים בַּעוֹר.",
            definitionNative = "Поворот тела с одного бока на другой, чтобы кожа не страдала.",
            example = "הִיפּוּךְ מְטוּפָּל מִתְבַּצֵּעַ כָּל שְׁתֵּי שָׁעוֹת בַּלַּיְלָה.",
            exampleNative = "הִיפּוּךְ מְטוּפָּל выполняется каждые два часа в течение ночи.", fillInBlankExclusions = listOf(172509L, 172511L, 172512L, 172514L, 172515L)),
        WordEntity(
            id = 172514, setId = 1725, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "care_mobility", transliteration = "tmikhat halikha",
            original = "תְּמִיכַת הֲלִיכָה", translation = "поддержка при ходьбе",
            definition = "אֲחִיזָה בַּזְּרוֹעַ שֶׁל מְטוּפָּל כְּדֵי שֶׁלֹּא יִפֹּל בַּדֶּרֶךְ.",
            definitionNative = "Удержание подопечного за руку, чтобы он не упал во время шагов.",
            example = "תְּמִיכַת הֲלִיכָה בְּכָל מַסְדְּרוֹן עוֹזֶרֶת לוֹ לְהַרְגִּישׁ בָּטוּחַ.",
            exampleNative = "תְּמִיכַת הֲלִיכָה по коридору помогает ему чувствовать себя уверенно.", fillInBlankExclusions = listOf(172511L, 172512L, 172513L, 172515L)),
        WordEntity(
            id = 172515, setId = 1725, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "care_mobility", transliteration = "avtakha bema'avar",
            original = "אַבְטָחָה בְּמַעֲבָר", translation = "страховка при пересадке",
            definition = "אֲחִיזָה בַּגֵּב כְּדֵי לִמְנֹעַ נְפִילָה בִּשְׁנִיָּה שֶׁל הַעֲבָרָה.",
            definitionNative = "Удержание за спину, чтобы пресечь падение в момент пересадки.",
            example = "אַבְטָחָה בְּמַעֲבָר חוֹסֶכֶת חֲבָלוֹת קְשׁוּחוֹת בַּמָּתְנַיִם.",
            exampleNative = "אַבְטָחָה בְּמַעֲבָר спасает от тяжёлых ушибов в области поясницы.", fillInBlankExclusions = listOf(172511L, 172512L, 172513L, 172514L)),

        // ── care_family_communication (5) — общение с семьёй подопечного ──
        WordEntity(
            id = 172516, setId = 1725, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "care_family_communication", transliteration = "pgisha im hamishpakha",
            original = "פְּגִישָׁה עִם הַמִּשְׁפָּחָה", translation = "семейная встреча",
            definition = "מִפְגָּשׁ שֶׁל הַסִּיעֶדֶת עִם בְּנֵי הַבַּיִת לְעַדְכּוּן וְהַחְלָטוֹת.",
            definitionNative = "Сбор сиделки с домашними для обсуждения новостей и решений.",
            example = "פְּגִישָׁה עִם הַמִּשְׁפָּחָה נִקְבֶּעֶת אַחַת לִשְׁבוּעַיִם בָּעֶרֶב.",
            exampleNative = "פְּגִישָׁה עִם הַמִּשְׁפָּחָה назначается раз в две недели по вечерам.", fillInBlankExclusions = listOf(172517L, 172518L, 172519L, 172520L)),
        WordEntity(
            id = 172517, setId = 1725, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "care_family_communication", transliteration = "divukh al hakhmara",
            original = "דִּוּוּחַ עַל הַחְמָרָה", translation = "сообщение об ухудшении",
            definition = "הוֹדָעָה דְּחוּפָה לַמִּשְׁפָּחָה כְּשֶׁמַּצָּב הַזָּקֵן יוֹרֵד פִּתְאוֹם.",
            definitionNative = "Срочное сообщение родне, когда состояние старика резко ухудшается.",
            example = "דִּוּוּחַ עַל הַחְמָרָה נִשְׁלָח לַבַּת תּוֹךְ עֶשֶׂר דַּקּוֹת.",
            exampleNative = "דִּוּוּחַ עַל הַחְמָרָה отправлено дочери в течение десяти минут.", fillInBlankExclusions = listOf(172516L, 172518L, 172519L, 172520L, 172525L)),
        WordEntity(
            id = 172518, setId = 1725, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "care_family_communication", transliteration = "te'um im hayeladim",
            original = "תֵּאוּם עִם הַיְלָדִים", translation = "координация с детьми подопечного",
            definition = "סִדּוּר בִּקּוּרִים וּמַטָּלוֹת בֵּין הַסִּיעֶדֶת לִבְנֵי הַזָּקֵן הַבּוֹגְרִים.",
            definitionNative = "Согласование визитов и задач между сиделкой и взрослыми сыновьями старика.",
            example = "תֵּאוּם עִם הַיְלָדִים נַעֲשֶׂה דֶּרֶךְ קְבוּצַת וַטְסְאַפּ מְשֻׁתֶּפֶת.",
            exampleNative = "תֵּאוּם עִם הַיְלָדִים происходит через общую группу в WhatsApp.", fillInBlankExclusions = listOf(172516L, 172517L, 172519L, 172520L)),
        WordEntity(
            id = 172519, setId = 1725, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "care_family_communication", transliteration = "ishur karov",
            original = "אִישׁוּר קָרוֹב", translation = "согласие близкого родственника",
            definition = "הַסְכָּמָה רִשְׁמִית שֶׁל בֶּן מִשְׁפָּחָה לִפְעֻלָּה רְפוּאִית מְסֻיֶּמֶת.",
            definitionNative = "Формальное согласие родного человека на конкретное медицинское действие.",
            example = "אִישׁוּר קָרוֹב נִדְרָשׁ לִפְנֵי הַחְלָפַת תְּרוּפָה כְּרוֹנִית.",
            exampleNative = "אִישׁוּר קָרוֹב требуется до замены постоянного лекарства.", fillInBlankExclusions = listOf(172516L, 172517L, 172518L, 172520L)),
        WordEntity(
            id = 172520, setId = 1725, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "care_family_communication", transliteration = "sikhat erev lamishpakha",
            original = "שִׂיחַת עֶרֶב לַמִּשְׁפָּחָה", translation = "вечерний звонок семье",
            definition = "טֵלֵפוֹן קָבוּעַ בַּשָּׁעָה הָאַחַת אַחַרֵי הַצָּהֳרַיִם עַל מַהֲלָךְ הַיּוֹם.",
            definitionNative = "Регулярный звонок ближе к ночи о том, как прошёл день.",
            example = "שִׂיחַת עֶרֶב לַמִּשְׁפָּחָה נִמְשֶׁכֶת בְּדֶרֶךְ כְּלָל חָמֵשׁ דַּקּוֹת.",
            exampleNative = "שִׂיחַת עֶרֶב לַמִּשְׁפָּחָה длится обычно около пяти минут.", fillInBlankExclusions = listOf(172516L, 172517L, 172518L, 172519L)),

        // ── care_documentation (5) — документация и отчётность ──
        WordEntity(
            id = 172521, setId = 1725, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "care_documentation", transliteration = "yoman tipul",
            original = "יוֹמָן טִיפּוּל", translation = "журнал ухода",
            definition = "מַחְבֶּרֶת שֶׁבָּהּ נִרְשָׁמוֹת כָּל הַפְּעֻלּוֹת לְלָקוּחַ בְּמַהֲלָךְ הַיּוֹם.",
            definitionNative = "Тетрадь, в которой фиксируются все действия с подопечным за сутки.",
            example = "יוֹמָן טִיפּוּל נִשְׁאָר עַל שֻׁלְחָן הַסַּלוֹן לְבוֹדְקֵי הָאֲגַף.",
            exampleNative = "יוֹמָן טִיפּוּל лежит на столе в гостиной для проверяющих из отдела.", fillInBlankExclusions = listOf(172522L, 172523L, 172524L, 172525L)),
        WordEntity(
            id = 172522, setId = 1725, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "care_documentation", transliteration = "tofes ma'avar mishmeret",
            original = "טֹפֶס מַעֲבַר מִשְׁמֶרֶת", translation = "бланк передачи смены",
            definition = "דַּף שֶׁבּוֹ הַסִּיעֶדֶת מְסַכֶּמֶת מַה קָּרָה לִפְנֵי שֶׁעוֹזֶבֶת.",
            definitionNative = "Лист, где сиделка описывает события дежурства перед уходом.",
            example = "טֹפֶס מַעֲבַר מִשְׁמֶרֶת מָלֵא תָּמִיד לִפְנֵי שֶׁבַע בַּבֹּקֶר.",
            exampleNative = "טֹפֶס מַעֲבַר מִשְׁמֶרֶת заполнен всегда до семи утра.", fillInBlankExclusions = listOf(172521L, 172523L, 172524L, 172525L)),
        WordEntity(
            id = 172523, setId = 1725, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "care_documentation", transliteration = "yoman simanim",
            original = "יוֹמַן סִימָנִים", translation = "дневник наблюдений",
            definition = "רְשִׁימָה שֶׁל הִתְבַּטְּאוּיוֹת לֹא רְגִילוֹת בַּגּוּף וּבַמַּצַּב הָרוּחַ.",
            definitionNative = "Список необычных проявлений в теле и в настроении подопечного.",
            example = "יוֹמַן סִימָנִים עוֹזֵר לָרוֹפֵא לִרְאוֹת מְגַמַּת שִׁנּוּי.",
            exampleNative = "יוֹמַן סִימָנִים помогает врачу увидеть направление изменений.", fillInBlankExclusions = listOf(172521L, 172522L, 172524L, 172525L)),
        WordEntity(
            id = 172524, setId = 1725, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "care_documentation", transliteration = "reshimat trufot",
            original = "רְשִׁימַת תְּרוּפוֹת", translation = "лист медикаментов",
            definition = "טַבְלָה שֶׁמּוֹנָה כָּל כַּדּוּר וְזַרְקָה שֶׁמְּקַבֵּל הַמְּטוּפָּל בַּיּוֹם.",
            definitionNative = "Таблица с каждой таблеткой и уколом, что получает подопечный за сутки.",
            example = "רְשִׁימַת תְּרוּפוֹת תְּלוּיָה עַל הַמְקָרֵר עִם שָׁעוֹת בְּרוּרוֹת.",
            exampleNative = "רְשִׁימַת תְּרוּפוֹת висит на холодильнике с чёткими часами приёма.", fillInBlankExclusions = listOf(172521L, 172522L, 172523L, 172525L)),
        WordEntity(
            id = 172525, setId = 1725, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "care_documentation", transliteration = "du'akh eru'a",
            original = "דּוּ\"חַ אֵרוּעַ", translation = "акт о происшествии",
            definition = "מִסְמָךְ קָצָר עַל נְפִילָה אוֹ אִי-תַּקִּינוּת חֲרִיגָה אֵצֶל הַמְּטוּפָּל.",
            definitionNative = "Короткий документ о падении или внеочередном сбое у подопечного.",
            example = "דּוּ\"חַ אֵרוּעַ הוּגַשׁ לַסּוֹכְנוּת בּוֹ בַּיּוֹם בָּעֶרֶב.",
            exampleNative = "דּוּ\"חַ אֵרוּעַ передан в агентство в тот же вечер."),
    )
}
