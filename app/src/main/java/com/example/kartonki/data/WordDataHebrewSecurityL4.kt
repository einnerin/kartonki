package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary: Security (Охранник), level 4 (1 set, 25 words).
 * Профессиональная лексика начальника охраны: спецоперации, лицензии,
 * угрозы, протоколы реагирования, командование.
 *
 * Set 1721 (level 4, EPIC + LEGENDARY) — дополняет линейку темы «Охранник»:
 * 1359 (L1), 1360 (L2), 1361 (L3), 1362/1363 (L5).
 *
 * Не пересекается со словами уже существующих сетов 1359–1363 и темы «Армия»
 * (1716+ и др.) — каждое слово проверено grep'ом.
 *
 * Распределение редкостей: 15 EPIC + 10 LEGENDARY (2 смежных уровня).
 *
 * Пять подгрупп по 5 слов каждая:
 *   security_special_ops   — спецоперации
 *   security_permits       — лицензии и допуски
 *   security_threats       — типы угроз
 *   security_response      — протоколы реагирования
 *   security_command       — командование охраной
 */
object WordDataHebrewSecurityL4 {

    val sets = listOf(
        WordSetEntity(
            id = 1721, languagePair = "he-ru", orderIndex = 1721,
            name = "Охранник",
            description = "Спецоперации, разрешения, угрозы, протоколы реагирования",
            topic = "Охранник", level = 4,
        ),
    )

    val words = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1721 — Охранник: профессиональный (EPIC + LEGENDARY, C1–C2)
        // 5 групп × 5 слов
        // ══════════════════════════════════════════════════════════════════════

        // ── security_special_ops (5) — спецоперации ──
        WordEntity(
            id = 172101, setId = 1721, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "security_special_ops", transliteration = "mivtsa khai",
            original = "מִבְצָע חַי", translation = "боевая операция (на земле)",
            definition = "פְּעוּלָה אֲמִיתִּית בַּשֶּׁטַח עִם סִכּוּן מַמָּשִׁי, לֹא תַּרְגִּיל.",
            definitionNative = "Реальное действие на местности с настоящим риском, не учения.",
            example = "מִבְצָע חַי דּוֹרֵשׁ צֶוֶת מְנֻסֶּה וּמוּכָן.",
            exampleNative = "מִבְצָע חַי требует опытной и подготовленной группы.",
         fillInBlankExclusions = listOf(172102L, 172103L, 172104L, 172105L, 172111L)),
        WordEntity(
            id = 172102, setId = 1721, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "security_special_ops", transliteration = "shikhzur eiru'a",
            original = "שִׁחְזוּר אֵירוּעַ", translation = "реконструкция события",
            definition = "שִׁיחְזוּר מְדֻיָּק שֶׁל מַה שֶּׁקָּרָה כְּדֵי לְהָבִין אֵיךְ זֶה הִתְפַּתֵּחַ.",
            definitionNative = "Точное воспроизведение случившегося, чтобы понять ход событий.",
            example = "שִׁחְזוּר אֵירוּעַ הִצְבִּיעַ עַל פְּגָם בַּמַּצְלֵמָה.",
            exampleNative = "שִׁחְזוּר אֵירוּעַ указал на неисправность камеры.",
        ),
        WordEntity(
            id = 172103, setId = 1721, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "security_special_ops", transliteration = "tatspit smuya",
            original = "תַּצְפִּית סְמוּיָה", translation = "скрытое наблюдение",
            definition = "מַעֲקָב מֵרָחוֹק מִבְּלִי שֶׁהַנֶּעֱקָב יָדַע עַל כָּךְ.",
            definitionNative = "Слежение издали так, чтобы объект не догадался об этом.",
            example = "תַּצְפִּית סְמוּיָה נִמְשְׁכָה שָׁלֹשׁ שָׁעוֹת מֵעַל הַגַּג.",
            exampleNative = "תַּצְפִּית סְמוּיָה длилась три часа с крыши.",
         fillInBlankExclusions = listOf(172101L, 172102L, 172104L, 172105L)),
        WordEntity(
            id = 172104, setId = 1721, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "security_special_ops", transliteration = "avtakha ishit",
            original = "אַבְטָחָה אִישִׁית", translation = "личная охрана VIP",
            definition = "שְׁמִירָה צְמוּדָה עַל אָדָם חָשׁוּב כָּל זְמַן שֶׁהוּא בְּתָנוּעָה.",
            definitionNative = "Постоянное сопровождение важного человека во всех его перемещениях.",
            example = "אַבְטָחָה אִישִׁית דּוֹרֶשֶׁת לְפָחוֹת שְׁנֵי לוֹחֲמִים.",
            exampleNative = "אַבְטָחָה אִישִׁית требует не меньше двух бойцов.",
         fillInBlankExclusions = listOf(172101L, 172102L, 172103L, 172105L, 172111L)),
        WordEntity(
            id = 172105, setId = 1721, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "security_special_ops", transliteration = "livui khamush",
            original = "לִוּוּי חָמוּשׁ", translation = "вооружённое сопровождение",
            definition = "צֶוֶת עִם נֶשֶׁק שֶׁמְּלַוֶּה רֶכֶב אוֹ מִטְעָן רָגִישׁ בַּדֶּרֶךְ.",
            definitionNative = "Группа с оружием, идущая рядом с машиной или ценным грузом.",
            example = "לִוּוּי חָמוּשׁ הוּצָב לְכָל הוֹבָלַת יַהֲלוֹמִים.",
            exampleNative = "לִוּוּי חָמוּשׁ ставят на каждую перевозку алмазов.",
        ),

        // ── security_permits (5) — лицензии и допуски ──
        WordEntity(
            id = 172106, setId = 1721, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "security_permits", transliteration = "rishyon iskei shmira",
            original = "רִשְׁיוֹן עִסְקֵי שְׁמִירָה", translation = "лицензия охранного бизнеса",
            definition = "אִישׁוּר רִשְׁמִי לַחֶבְרָה לְהַפְעִיל שֵׁרוּתֵי שְׁמִירָה תְּמוּרַת תַּשְׁלוּם.",
            definitionNative = "Официальное разрешение фирме оказывать охранные услуги за плату.",
            example = "בְּלִי רִשְׁיוֹן עִסְקֵי שְׁמִירָה הַחֶבְרָה לֹא תּוּכַל לִפְעֹל.",
            exampleNative = "Без רִשְׁיוֹן עִסְקֵי שְׁמִירָה фирма работать не сможет.",
         fillInBlankExclusions = listOf(172107L, 172108L, 172109L, 172110L)),
        WordEntity(
            id = 172107, setId = 1721, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "security_permits", transliteration = "te'udat me'avteakh",
            original = "תְּעוּדַת מְאַבְטֵחַ", translation = "сертификат охранника",
            definition = "תְּעוּדָה הַמַּעֲנִיקָה לְאָדָם זְכוּת לַעֲבֹד כִּשְׁמָר מוּסְמָךְ.",
            definitionNative = "Свидетельство, дающее человеку право работать аттестованным сторожем.",
            example = "תְּעוּדַת מְאַבְטֵחַ נִמְסֶרֶת אַחֲרֵי קוּרְס שֶׁל חוֹדֶשׁ.",
            exampleNative = "תְּעוּדַת מְאַבְטֵחַ выдаётся после месячного курса.",
        ),
        WordEntity(
            id = 172108, setId = 1721, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "security_permits", transliteration = "ishur bitakhoni",
            original = "אִישׁוּר בִּטָּחוֹנִי", translation = "допуск к секретной информации",
            definition = "הֶיתֵּר רִשְׁמִי לִגֶּשֶׁת לַחֳמָרִים סוֹדִיִּים אַחֲרֵי בְּדִיקָה אִישִׁית.",
            definitionNative = "Официальное право доступа к закрытым материалам после личной проверки.",
            example = "אִישׁוּר בִּטָּחוֹנִי גָּבוֹהַּ לוֹקֵחַ חֳדָשִׁים רַבִּים.",
            exampleNative = "אִישׁוּר בִּטָּחוֹנִי высокого уровня выдают много месяцев.",
         fillInBlankExclusions = listOf(172106L, 172107L, 172109L, 172110L)),
        WordEntity(
            id = 172109, setId = 1721, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "security_permits", transliteration = "ktav minui",
            original = "כְּתַב מִנּוּי", translation = "приказ о назначении",
            definition = "מִסְמָךְ הַקּוֹבֵעַ שֶׁאָדָם מוּסְמָךְ לְמַלֵּא תַּפְקִיד מְסֻיָּם בָּאַרְגּוּן.",
            definitionNative = "Бумага, утверждающая человека на конкретную должность в организации.",
            example = "כְּתַב מִנּוּי נִמְסַר לוֹ בְּטֶקֶס קָצָר וְצָנוּעַ.",
            exampleNative = "כְּתַב מִנּוּי вручили ему на короткой скромной церемонии.",
         fillInBlankExclusions = listOf(172106L, 172107L, 172108L, 172110L)),
        WordEntity(
            id = 172110, setId = 1721, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "security_permits", transliteration = "heter nesi'a",
            original = "הֶיתֵּר נְשִׁיאָה", translation = "разрешение на ношение",
            definition = "תְּעוּדָה רִשְׁמִית הַמְּתִירָה לִסְחֹב נֶשֶׁק קַל בְּגוּף הָאָדָם בַּחוּץ.",
            definitionNative = "Официальный документ на постоянное ношение лёгкого оружия при себе.",
            example = "הֶיתֵּר נְשִׁיאָה מְחַיֵּב חִדּוּשׁ פַּעַם בִּשְׁנָתַיִם.",
            exampleNative = "הֶיתֵּר נְשִׁיאָה продлевают раз в два года.",
         fillInBlankExclusions = listOf(172106L, 172107L, 172108L, 172109L)),

        // ── security_threats (5) — типы угроз ──
        WordEntity(
            id = 172111, setId = 1721, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "security_threats", transliteration = "iyum balisti",
            original = "אִיּוּם בָּלִיסְטִי", translation = "ракетная угроза",
            definition = "סַכָּנָה מִכֵּלִי יָרִי אוֹ טִילִים שֶׁעוֹפְפִים מֵעַל הָאֲוִיר.",
            definitionNative = "Опасность от снарядов или ракет, идущих по небу с большой скоростью.",
            example = "אִיּוּם בָּלִיסְטִי דּוֹרֵשׁ פְּתִיחַת מִקְלָטִים מִיָּד.",
            exampleNative = "אִיּוּם בָּלִיסְטִי требует немедленного открытия убежищ.",
         fillInBlankExclusions = listOf(172112L, 172113L, 172114L, 172115L)),
        WordEntity(
            id = 172112, setId = 1721, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "security_threats", transliteration = "tarkhish pigu'a",
            original = "תַּרְחִישׁ פִּגּוּעַ", translation = "сценарий теракта",
            definition = "תְּכוּנָה מַחְשְׁבָתִית אֵיךְ עָלוּל אוֹיֵב לִתְקֹף אֶת הָאֲתָר.",
            definitionNative = "Мысленная заготовка, как враг может напасть на охраняемый объект.",
            example = "תַּרְחִישׁ פִּגּוּעַ נִדּוֹן בִּישִׁיבַת הַמַּטֶּה הָאַחֲרוֹנָה.",
            exampleNative = "תַּרְחִישׁ פִּגּוּעַ обсуждали на последнем совещании штаба.",
        ),
        WordEntity(
            id = 172113, setId = 1721, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "security_threats", transliteration = "gorem oyen",
            original = "גּוֹרֵם עוֹיֵן", translation = "враждебный элемент",
            definition = "אָדָם אוֹ קְבוּצָה הַמַּכַּוְּנִים לְהַזִּיק לָאֲתָר אוֹ לְעוֹבְדָיו.",
            definitionNative = "Человек или группа, имеющие намерение причинить вред объекту или людям.",
            example = "גּוֹרֵם עוֹיֵן זוֹהָה מוּל הַשַּׁעַר הָרָאשִׁי.",
            exampleNative = "גּוֹרֵם עוֹיֵן опознали возле главного входа.",
         fillInBlankExclusions = listOf(172111L, 172112L, 172114L, 172115L)),
        WordEntity(
            id = 172114, setId = 1721, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "security_threats", transliteration = "khoder pnimi",
            original = "חוֹדֵר פְּנִימִי", translation = "внутренний нарушитель",
            definition = "עוֹבֵד מִבִּפְנִים שֶׁמְּנַצֵּל גִּישָׁה חֻקִּית לְמַטָּרוֹת אֲסוּרוֹת.",
            definitionNative = "Свой сотрудник, использующий законный доступ во вред компании.",
            example = "חוֹדֵר פְּנִימִי מְסֻכָּן יוֹתֵר מִתּוֹקֵף חִיצוֹנִי.",
            exampleNative = "חוֹדֵר פְּנִימִי опаснее любого внешнего нападающего.",
         fillInBlankExclusions = listOf(172111L, 172112L, 172113L, 172115L)),
        WordEntity(
            id = 172115, setId = 1721, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "security_threats", transliteration = "iyum saiber",
            original = "אֲיוּם סַיִיבֶּר", translation = "кибер-угроза",
            definition = "סַכָּנָה מִתְקֵפָה דֶּרֶךְ הָרֶשֶׁת עַל מַחְשְׁבֵי הָאֲתָר וְהַמַּעֲרָכוֹת.",
            definitionNative = "Опасность нападения через сеть на компьютеры объекта и его системы.",
            example = "אֲיוּם סַיִיבֶּר עַל מַעֲרֶכֶת הַשְּׁעָרִים נֶחְסַם בִּזְמַן.",
            exampleNative = "אֲיוּם סַיִיבֶּר на систему ворот удалось пресечь вовремя.",
         fillInBlankExclusions = listOf(172111L, 172112L, 172113L, 172114L)),

        // ── security_response (5) — протоколы реагирования ──
        WordEntity(
            id = 172116, setId = 1721, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "security_response", transliteration = "nohal histagrut",
            original = "נֹהַל הַסְתָּגְרוּת", translation = "протокол укрытия (lockdown)",
            definition = "פְּקֻדָּה לִסְגֹּר דְּלָתוֹת וְלִשְׁאֵר בִּפְנִים עַד שֶׁתֻּכְרַז הַרְגָּעָה.",
            definitionNative = "Команда запереть двери и оставаться внутри до сигнала отбоя.",
            example = "נֹהַל הַסְתָּגְרוּת הוּפְעַל מִיָּד לְאַחַר הָאַזְעָקָה.",
            exampleNative = "נֹהַל הַסְתָּגְרוּת включили сразу после сирены.",
         fillInBlankExclusions = listOf(172117L, 172118L, 172119L, 172120L)),
        WordEntity(
            id = 172117, setId = 1721, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "security_response", transliteration = "tseva kod",
            original = "צֶבַע קוֹד", translation = "цветовой код тревоги",
            definition = "סִימּוּן בִּצְבָעִים שֶׁמְּסַמֵּל אֶת חֻמְרַת הַמַּצָּב לַצֶּוֶת.",
            definitionNative = "Метка цветом, показывающая команде уровень опасности на данный момент.",
            example = "צֶבַע קוֹד אָדֹם סִימֵּן יְרִי בָּאֲתָר.",
            exampleNative = "צֶבַע קוֹד красного уровня означал стрельбу на объекте.",
         fillInBlankExclusions = listOf(172116L, 172118L, 172119L, 172120L)),
        WordEntity(
            id = 172118, setId = 1721, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "security_response", transliteration = "sharsheret pikud",
            original = "שַׁרְשֶׁרֶת פִּקּוּד", translation = "цепочка командования",
            definition = "סֵדֶר קָבוּעַ מִי מְצַוֶּה עַל מִי, מֵהָרֹאשׁ עַד הַזּוּטָר.",
            definitionNative = "Чёткий порядок старшинства от руководства до младшего сотрудника.",
            example = "שַׁרְשֶׁרֶת פִּקּוּד בְּרוּרָה מוֹנַעַת בִּלְבּוּל בְּחֵרוּם.",
            exampleNative = "שַׁרְשֶׁרֶת פִּקּוּד ясная избавляет от путаницы при ЧС.",
         fillInBlankExclusions = listOf(172116L, 172117L, 172119L, 172120L, 172124L, 172125L)),
        WordEntity(
            id = 172119, setId = 1721, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "security_response", transliteration = "hashbatat iyum",
            original = "הַשְׁבָּתַת אִיּוּם", translation = "нейтрализация угрозы",
            definition = "הַפְסָקַת פְּעוּלַת הַתּוֹקֵף לִפְנֵי שֶׁיַּזִּיק לְאָדָם אוֹ לִרְכוּשׁ.",
            definitionNative = "Прекращение действий нападающего раньше, чем он навредит людям или имуществу.",
            example = "הַשְׁבָּתַת אִיּוּם בּוּצְעָה תּוֹךְ עֶשֶׂר שְׁנִיּוֹת מֵהַאַזְעָקָה.",
            exampleNative = "הַשְׁבָּתַת אִיּוּם прошла за десять секунд от сигнала.",
         fillInBlankExclusions = listOf(172116L, 172117L, 172118L, 172120L)),
        WordEntity(
            id = 172120, setId = 1721, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "security_response", transliteration = "de-eskalatsiya",
            original = "דֶּה־אֶסְקָלָצְיָה", translation = "деэскалация",
            definition = "הוֹרָדַת מֶתַח בְּעֵת עִמּוּת בְּלִי לְהַחְרִיף וּבְלִי כֹּחַ.",
            definitionNative = "Снятие напряжения при конфликте без применения силы и обострения.",
            example = "דֶּה־אֶסְקָלָצְיָה בְּדִבּוּר רָגוּעַ הִצִּילָה אֶת הַמַּצָּב.",
            exampleNative = "דֶּה־אֶסְקָלָצְיָה спокойным голосом спасла ситуацию.",
         fillInBlankExclusions = listOf(172116L, 172117L, 172118L, 172119L)),

        // ── security_command (5) — командование охраной ──
        WordEntity(
            id = 172121, setId = 1721, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "security_command", transliteration = "katsin mivtsa'im",
            original = "קָצִין מִבְצָעִים", translation = "оперативный офицер",
            definition = "אִישׁ פִּקּוּד הָאַחְרַאי עַל בִּצּוּעַ הַמְּשִׂימוֹת בַּשֶּׁטַח בְּכָל מִשְׁמֶרֶת.",
            definitionNative = "Командир, отвечающий за исполнение задач на местах в каждую смену.",
            example = "קָצִין מִבְצָעִים בָּחַר אֵיךְ לְפַזֵּר אֶת הַכּוֹחוֹת.",
            exampleNative = "קָצִין מִבְצָעִים решал, как расставить силы по постам.",
         fillInBlankExclusions = listOf(172122L, 172123L, 172124L, 172125L)),
        WordEntity(
            id = 172122, setId = 1721, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "security_command", transliteration = "mate avtakha",
            original = "מַטֶּה אַבְטָחָה", translation = "штаб охраны",
            definition = "צֶוֶת בְּכִיר שֶׁמְּתַכְנֵן וּמְפַקֵּחַ עַל כָּל פְּעוּלוֹת הָאֲתָר.",
            definitionNative = "Группа старших сотрудников, планирующая и контролирующая работу объекта.",
            example = "מַטֶּה אַבְטָחָה הִתְכַּנֵּס לְהַעֲרָכַת מַצָּב דְּחוּפָה.",
            exampleNative = "מַטֶּה אַבְטָחָה собрался на срочную оценку обстановки.",
         fillInBlankExclusions = listOf(172121L, 172123L, 172124L, 172125L)),
        WordEntity(
            id = 172123, setId = 1721, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "security_command", transliteration = "takhkir mivtsa'i",
            original = "תַּחְקִיר מִבְצָעִי", translation = "разбор операции",
            definition = "פְּגִישָׁה אַחֲרֵי הָאֵירוּעַ לִלְמֹד מַה עָבַד וּמַה לְשַׁפֵּר בַּפַּעַם הַבָּאָה.",
            definitionNative = "Встреча после события, чтобы понять, что удалось, а что улучшить.",
            example = "תַּחְקִיר מִבְצָעִי חָשַׂף שָׁלוֹשׁ נְקֻדּוֹת תּוּרְפָּה.",
            exampleNative = "תַּחְקִיר מִבְצָעִי обнаружил три слабых места.",
         fillInBlankExclusions = listOf(172102L, 172103L, 172121L, 172122L, 172124L, 172125L)),
        WordEntity(
            id = 172124, setId = 1721, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "security_command", transliteration = "takanon haf'ala",
            original = "תָּקָנוֹן הַפְעָלָה", translation = "правила применения силы",
            definition = "כְּלָלִים בְּרוּרִים מָתַי וְעַד כַּמָּה מֻתָּר לְהַפְעִיל כֹּחַ עַל אָדָם.",
            definitionNative = "Чёткий список случаев и пределов применения силы к человеку.",
            example = "תָּקָנוֹן הַפְעָלָה אוֹסֵר יְרִי בְּלִי אַזְהָרָה קוֹדֶמֶת.",
            exampleNative = "תָּקָנוֹן הַפְעָלָה запрещает стрельбу без предварительного окрика.",
         fillInBlankExclusions = listOf(172118L, 172121L, 172122L, 172123L, 172125L)),
        WordEntity(
            id = 172125, setId = 1721, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "security_command", transliteration = "te'um bein rashuyot",
            original = "תֵּאוּם בֵּין רָשׁוּיוֹת", translation = "межведомственная координация",
            definition = "עֲבוֹדָה מְשֻׁתֶּפֶת בֵּין מִשְׁטָרָה, צָבָא וְגוּפֵי חֵרוּם בְּעֵת מַשְׁבֵּר.",
            definitionNative = "Совместная работа полиции, армии и служб экстренной помощи в кризис.",
            example = "תֵּאוּם בֵּין רָשׁוּיוֹת קִצֵּר אֶת זְמַן הַתְּגוּבָה לַחֲצִי.",
            exampleNative = "תֵּאוּם בֵּין רָשׁוּיוֹת сократил время отклика вдвое.",
         fillInBlankExclusions = listOf(172116L, 172118L, 172121L, 172122L, 172123L, 172124L)),
    )
}
