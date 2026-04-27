package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary: Bureaucracy and documents, level 3 (1 set, 25 words).
 * Углублённая бюрократическая лексика для жизни в Израиле:
 * налоги, банковские документы, недвижимость, страхование, справки.
 *
 * Set 1809 (level 3, RARE + EPIC) — заполняет L3 в теме «Бюрократия и документы»
 * между level 1 (1807) и level 2 (1808, параллельно).
 *
 * Не пересекается с FinanceV2 (1717), Law L1 (1703) и старыми сетами:
 * заменены מַס הַכְנָסָה → מַס שׁוּלִי, הוֹרָאַת קֶבַע → הַרְשָׁאָה לְחִיּוּב,
 * אַרְנוֹנָה → שֶׁטָר חֲכִירָה. Слова с корнем מ-ס встречаются как
 * компоненты multi-word терминов (mas shuli, mas rekhesh, ptor mimas,
 * hahzer mas) — допустимо, поскольку «mas» = базовое слово темы налогов.
 *
 * Распределение редкостей: 13 RARE + 12 EPIC (2 смежных уровня).
 *
 * Пять подгрупп по 5 слов:
 *   bureau_taxes         — налоги (mas shuli, tlush maskoret и т.д.)
 *   bureau_bank_docs     — банковские документы (cheshbon bank, check)
 *   bureau_realty_docs   — документы по недвижимости (chozeh sкхirut)
 *   bureau_insurance     — страхование (bituach dira, polisat khaim)
 *   bureau_certificates  — официальные справки (ishur ta'asuka)
 *
 * Все слова: isFillInBlankSafe = false (заполнить exclusions через pipeline).
 */
object WordDataHebrewBureauL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1809, languagePair = "he-ru", orderIndex = 1809,
            name = "Бюрократия и документы: углублённый",
            description = "Углублённый: налоги, банковские документы, недвижимость, страхование",
            topic = "Бюрократия и документы", level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1809 — Бюрократия и документы: углублённый (RARE + EPIC, B2–C1)
        // 5 групп × 5 слов
        // ══════════════════════════════════════════════════════════════════════

        // ── bureau_taxes (5) — налоги ──
        WordEntity(
            id = 180901, setId = 1809, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_taxes", transliteration = "mas shuli",
            original = "מַס שׁוּלִי", translation = "предельная ставка налога",
            definition = "אֲחוּז הַמַּס הַגָּבוֹהַּ בְּיוֹתֵר שֶׁאָדָם מְשַׁלֵּם עַל הַשֶּׁקֶל הָאַחֲרוֹן.",
            definitionNative = "Доля, которую государство берёт с самой верхней части дохода человека.",
            example = "מַס שׁוּלִי עוֹלֶה כְּשֶׁהַמַּשְׂכֹּרֶת חוֹצָה מַדְרֵגָה חֲדָשָׁה.",
            exampleNative = "מַס שׁוּלִי растёт, когда зарплата переходит в новую ступень.",
            isFillInBlankSafe = false),
        WordEntity(
            id = 180902, setId = 1809, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "bureau_taxes", transliteration = "tlush maskoret",
            original = "תְּלוּשׁ מַשְׂכֹּרֶת", translation = "расчётный листок (зарплатный)",
            definition = "דַּף שֶׁמַּפְרִיט אֶת כָּל הַסְּכוּמִים וְהַנִּיכּוּיִים בַּמַּשְׂכֹּרֶת הַחוֹדֶשֶׁת.",
            definitionNative = "Бумага с разбивкой всех сумм и удержаний за месяц работы.",
            example = "בְּרֹאשׁ הַחֹדֶשׁ הַמַּעֲסִיק שׁוֹלֵחַ תְּלוּשׁ מַשְׂכֹּרֶת בְּמֵייל.",
            exampleNative = "В начале месяца работодатель шлёт תְּלוּשׁ מַשְׂכֹּרֶת на почту.",
            isFillInBlankSafe = false),
        WordEntity(
            id = 180903, setId = 1809, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "bureau_taxes", transliteration = "hahzer mas",
            original = "הַחְזֵר מַס", translation = "возврат налога",
            definition = "כֶּסֶף שֶׁהַמְּדִינָה מַחֲזִירָה כְּשֶׁשִּׁלַּמְתָּ יוֹתֵר מִדַּי בְּמֶשֶׁךְ הַשָּׁנָה.",
            definitionNative = "Деньги, которые казна возвращает, если за год удержали больше нужного.",
            example = "הִגַּשְׁתִּי בַּקָּשָׁה וְקִבַּלְתִּי הַחְזֵר מַס מְכֻבָּד.",
            exampleNative = "Я подал заявку и получил неплохой הַחְזֵר מַס.",
            isFillInBlankSafe = false),
        WordEntity(
            id = 180904, setId = 1809, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_taxes", transliteration = "nikudot zikuy",
            original = "נִקּוּדוֹת זִכּוּי", translation = "налоговые баллы льготы",
            definition = "יְחִידוֹת חִישּׁוּב שֶׁמַּפְחִיתוֹת אֶת הַסְּכוּם הַחוֹדְשִׁי הַמְּנֻכֶּה לְמַס.",
            definitionNative = "Расчётные единицы, на которые уменьшают ежемесячную сумму удержания.",
            example = "אִם נוֹלָד יֶלֶד מוֹסִיפִים לָאֵם נִקּוּדוֹת זִכּוּי בַּטֹּפֶס.",
            exampleNative = "Если родился ребёнок, маме добавляют נִקּוּדוֹת זִכּוּי в анкете.",
            isFillInBlankSafe = false),
        WordEntity(
            id = 180905, setId = 1809, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_taxes", transliteration = "ptor mimas",
            original = "פָּטוֹר מִמַּס", translation = "освобождение от налога",
            definition = "הֶחְלָטָה רִשְׁמִית שֶׁאוֹמֶרֶת שֶׁעַל הַכְנָסָה מְסֻיֶּמֶת לֹא מְשַׁלְּמִים כְּלוּם.",
            definitionNative = "Решение властей, что с конкретного дохода платить казне не нужно.",
            example = "עוֹלֶה חָדָשׁ מְקַבֵּל פָּטוֹר מִמַּס עַל פֶּנְסְיָה זָרָה.",
            exampleNative = "Новый репатриант получает פָּטוֹר מִמַּס на иностранную пенсию.",
            isFillInBlankSafe = false),

        // ── bureau_bank_docs (5) — банковские документы ──
        WordEntity(
            id = 180906, setId = 1809, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "bureau_bank_docs", transliteration = "cheshbon bank",
            original = "חֶשְׁבּוֹן בַּנְק", translation = "банковский счёт",
            definition = "מָקוֹם שָׁמוּר בַּמּוֹסָד הַפִּינַנְסִי שֶׁבּוֹ מַחְזִיקִים אֶת הַכֶּסֶף.",
            definitionNative = "Личное место в финансовом учреждении — там лежат деньги клиента.",
            example = "פָּתַחְתִּי חֶשְׁבּוֹן בַּנְק מִיָּד אַחֲרֵי שֶׁהִגַּעְתִּי לָאָרֶץ.",
            exampleNative = "Я открыл חֶשְׁבּוֹן בַּנְק сразу после приезда в страну.",
            isFillInBlankSafe = false),
        WordEntity(
            id = 180907, setId = 1809, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "bureau_bank_docs", transliteration = "check",
            original = "צֵ'ק", translation = "чек (платёжный)",
            definition = "פֶּתֶק נְיָר שֶׁמְּשַׁלְּמִים בּוֹ סְכוּם מוּגְדָּר מֵחֶשְׁבּוֹן הַבַּנְק.",
            definitionNative = "Бумажка для оплаты конкретной суммы прямо со счёта в банке.",
            example = "מָסַרְתִּי לַבַּעַל הַבַּיִת צֵ'ק לְשִׁשָּׁה חֳדָשִׁים.",
            exampleNative = "Я отдал хозяину квартиры צֵ'ק на полгода вперёд.",
            isFillInBlankSafe = false),
        WordEntity(
            id = 180908, setId = 1809, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_bank_docs", transliteration = "harshaa lekhiyuv",
            original = "הַרְשָׁאָה לְחִיּוּב", translation = "разрешение на списание (с счёта)",
            definition = "מִסְמָךְ שֶׁמַּתִּיר לְעֵסֶק לִקְחַת תַּשְׁלוּם יָשָׁר מֵהַחֶשְׁבּוֹן בַּמּוֹעֵד.",
            definitionNative = "Документ, дающий компании право снимать оплату прямо со счёта.",
            example = "חָתַמְתִּי עַל הַרְשָׁאָה לְחִיּוּב בַּחֶבְרַת הַחַשְׁמַל.",
            exampleNative = "Я подписал הַרְשָׁאָה לְחִיּוּב в электрической компании.",
            isFillInBlankSafe = false),
        WordEntity(
            id = 180909, setId = 1809, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "bureau_bank_docs", transliteration = "ishur yitra",
            original = "אִישּׁוּר יִתְרָה", translation = "справка об остатке на счёте",
            definition = "מִסְמָךְ רִשְׁמִי מֵהַבַּנְק שֶׁמְּצַיֵּן כַּמָּה כֶּסֶף יֵשׁ בַּחֶשְׁבּוֹן עַכְשָׁו.",
            definitionNative = "Официальная бумага из банка о текущей сумме на счёте клиента.",
            example = "הַשַּׁגְרִירוּת בִּקְּשָׁה אִישּׁוּר יִתְרָה לְאַחַר שְׁנָתַיִם.",
            exampleNative = "Посольство затребовало אִישּׁוּר יִתְרָה за два года.",
            isFillInBlankSafe = false),
        WordEntity(
            id = 180910, setId = 1809, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "bureau_bank_docs", transliteration = "haavara bankait",
            original = "הֶעֲבָרָה בַּנְקָאִית", translation = "банковский перевод",
            definition = "פְּעוּלָה שֶׁמַּעֲבִירָה כֶּסֶף בֵּין שְׁנֵי חֶשְׁבּוֹנוֹת בְּהוֹרָאַת הַלָּקוֹחַ.",
            definitionNative = "Действие — деньги перемещаются между двумя счетами по поручению клиента.",
            example = "הַשָּׂכָר הִגִּיעַ הַיּוֹם בְּהֶעֲבָרָה בַּנְקָאִית רְגִילָה.",
            exampleNative = "Зарплата пришла сегодня обычной הֶעֲבָרָה בַּנְקָאִית.",
            isFillInBlankSafe = false),

        // ── bureau_realty_docs (5) — документы по недвижимости ──
        WordEntity(
            id = 180911, setId = 1809, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "bureau_realty_docs", transliteration = "khoze skhirut",
            original = "חוֹזֵה שְׂכִירוּת", translation = "договор аренды квартиры",
            definition = "הֶסְכֵּם כָּתוּב בֵּין בַּעַל הַבַּיִת לַדַּיָּר עַל תְּנָאֵי הַמְּגוּרִים.",
            definitionNative = "Письменный договор хозяина с жильцом — об условиях проживания.",
            example = "חָתַמְנוּ עַל חוֹזֵה שְׂכִירוּת לִשְׁנָתַיִם עִם אוֹפְּצְיָה.",
            exampleNative = "Мы подписали חוֹזֵה שְׂכִירוּת на два года с опцией продления.",
            isFillInBlankSafe = false),
        WordEntity(
            id = 180912, setId = 1809, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "bureau_realty_docs", transliteration = "khoze rekhesh",
            original = "חוֹזֵה רֶכֶשׁ", translation = "договор купли-продажи (недвижимости)",
            definition = "מִסְמָךְ שֶׁמַּעֲבִיר בַּעֲלוּת עַל דִּירָה אוֹ קַרְקַע מִצַּד אֶחָד לַשֵּׁנִי.",
            definitionNative = "Документ, передающий собственность на жильё или землю от одного человека другому.",
            example = "עוֹרֵךְ הַדִּין הִכְתִּיב אֶת חוֹזֵה רֶכֶשׁ בִּפְגִישַׁת הַחֲתִימָה.",
            exampleNative = "Адвокат продиктовал חוֹזֵה רֶכֶשׁ на встрече для подписей.",
            isFillInBlankSafe = false),
        WordEntity(
            id = 180913, setId = 1809, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_realty_docs", transliteration = "nesakh tabu",
            original = "נְסַח טַאבּוּ", translation = "выписка из реестра прав на имущество",
            definition = "הַעְתֵּק רִשְׁמִי שֶׁל הַפֵּרוּט עַל הַזְּכוּיוֹת בַּדִּירָה אוֹ בַּקַּרְקַע.",
            definitionNative = "Официальная копия записей о правах на квартиру или участок земли.",
            example = "הַקּוֹנֶה דָּרַשׁ נְסַח טַאבּוּ עָדְכָּנִי לִפְנֵי הַחֲתִימָה.",
            exampleNative = "Покупатель потребовал свежий נְסַח טַאבּוּ перед подписанием.",
            isFillInBlankSafe = false),
        WordEntity(
            id = 180914, setId = 1809, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_realty_docs", transliteration = "mas rekhesh",
            original = "מַס רֶכֶשׁ", translation = "налог на покупку недвижимости",
            definition = "תַּשְׁלוּם חַד-פַּעֲמִי לַמְּדִינָה שֶׁמְּשַׁלֵּם הַקּוֹנֶה בִּקְנִיַּת דִּירָה.",
            definitionNative = "Разовая выплата казне — её делает покупатель при сделке с жильём.",
            example = "מַס רֶכֶשׁ עַל דִּירָה רִאשׁוֹנָה נָמוּךְ יוֹתֵר.",
            exampleNative = "מַס רֶכֶשׁ при покупке первого жилья ниже обычного.",
            isFillInBlankSafe = false),
        WordEntity(
            id = 180915, setId = 1809, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_realty_docs", transliteration = "shtar khakhira",
            original = "שֶׁטָר חֲכִירָה", translation = "договор долгосрочной аренды земли",
            definition = "מִסְמָךְ שֶׁנּוֹתֵן זְכוּת שִׁמּוּשׁ בַּקַּרְקַע לְשָׁנִים רַבּוֹת לְלֹא בַּעֲלוּת.",
            definitionNative = "Документ — даёт право пользоваться землёй много лет без передачи собственности.",
            example = "הַמִּנְהָל הוֹצִיא שֶׁטָר חֲכִירָה לְתִשְׁעִים וְתֵשַׁע שָׁנִים.",
            exampleNative = "Управление выдало שֶׁטָר חֲכִירָה на 99 лет.",
            isFillInBlankSafe = false),

        // ── bureau_insurance (5) — страхование ──
        WordEntity(
            id = 180916, setId = 1809, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "bureau_insurance", transliteration = "bituakh dira",
            original = "בִּטּוּחַ דִּירָה", translation = "страхование квартиры",
            definition = "הֶסְכֵּם שֶׁמַּגֵּן עַל הַדִּירָה וְעַל הָרְכוּשׁ בִּפְנֵי שְׂרֵפָה אוֹ פְּרִיצָה.",
            definitionNative = "Соглашение, защищающее жильё и имущество от пожара или взлома.",
            example = "בִּטּוּחַ דִּירָה כִּסָּה אֶת נֶזֶק הַמַּיִם בַּמִּטְבָּח.",
            exampleNative = "בִּטּוּחַ דִּירָה покрыло ущерб от затопления на кухне.",
            isFillInBlankSafe = false),
        WordEntity(
            id = 180917, setId = 1809, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_insurance", transliteration = "polisat khaim",
            original = "פּוֹלִיסַת חַיִּים", translation = "полис страхования жизни",
            definition = "מִסְמָךְ הֶסְכֵּם שֶׁמְּבַטִּיחַ סְכוּם לַמִּשְׁפָּחָה בְּמִקְרֵה פְּטִירַת הַמְּבֻטָּח.",
            definitionNative = "Договор-документ, гарантирующий деньги семье в случае смерти застрахованного.",
            example = "אַבָּא חָתַם עַל פּוֹלִיסַת חַיִּים לִשְׁמִירַת הַיְלָדִים.",
            exampleNative = "Папа подписал פּוֹלִיסַת חַיִּים для защиты детей.",
            isFillInBlankSafe = false),
        WordEntity(
            id = 180918, setId = 1809, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "bureau_insurance", transliteration = "tagmulim",
            original = "תַּגְמוּלִים", translation = "страховое возмещение",
            definition = "סְכוּם הַכֶּסֶף שֶׁחֶבְרַת הַבִּטּוּחַ מְשַׁלֶּמֶת לַלָּקוֹחַ אַחֲרֵי אֵרוּעַ מְכֻסֶּה.",
            definitionNative = "Сумма от страховой клиенту после случая, который входит в покрытие.",
            example = "אַחֲרֵי הַתְּאוּנָה קִבַּלְתִּי תַּגְמוּלִים תּוֹךְ שְׁבוּעַיִם.",
            exampleNative = "После аварии я получил תַּגְמוּלִים в течение двух недель.",
            isFillInBlankSafe = false),
        WordEntity(
            id = 180919, setId = 1809, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_insurance", transliteration = "hishtatfut atsmit",
            original = "הִשְׁתַּתְּפוּת עַצְמִית", translation = "франшиза (взнос самого клиента)",
            definition = "סְכוּם שֶׁהַלָּקוֹחַ מְשַׁלֵּם מִכִּיסוֹ לִפְנֵי שֶׁהַחֶבְרָה מְכַסָּה אֶת הַיֶּתֶר.",
            definitionNative = "Сумма из своего кармана клиента — до того как компания платит остаток.",
            example = "אַחֲרֵי הַתְּאוּנָה שִׁלַּמְתִּי הִשְׁתַּתְּפוּת עַצְמִית שֶׁל אֶלֶף שֶׁקֶל.",
            exampleNative = "После аварии я заплатил הִשְׁתַּתְּפוּת עַצְמִית в тысячу шекелей.",
            isFillInBlankSafe = false),
        WordEntity(
            id = 180920, setId = 1809, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "bureau_insurance", transliteration = "saadim",
            original = "סַעֲדִים", translation = "средства правовой защиты (по страховке)",
            definition = "אֶמְצָעִים מִשְׁפָּטִיִּים שֶׁמַּגִּיעִים לַלָּקוֹחַ כְּשֶׁהַחוֹזֶה הוּפַר נֶגְדּוֹ.",
            definitionNative = "Юридические инструменты, положенные клиенту, если соглашение нарушили.",
            example = "עוֹרֵךְ הַדִּין הִסְבִּיר אֵילוּ סַעֲדִים יַשׁ לַמְּבֻטָּח.",
            exampleNative = "Адвокат объяснил, какие сַעֲדִים есть у застрахованного.",
            isFillInBlankSafe = false),

        // ── bureau_certificates (5) — официальные справки ──
        WordEntity(
            id = 180921, setId = 1809, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "bureau_certificates", transliteration = "ishur taasuka",
            original = "אִישּׁוּר תַּעֲסוּקָה", translation = "справка с места работы",
            definition = "מִסְמָךְ מֵהַמַּעֲסִיק שֶׁמְּצַיֵּן שֶׁאָדָם עוֹבֵד שָׁם בְּתַפְקִיד מְסֻיָּם.",
            definitionNative = "Бумага от работодателя — что человек служит у них в конкретной должности.",
            example = "הַבַּנְק בִּקֵּשׁ אִישּׁוּר תַּעֲסוּקָה לְפִתְחוֹן הַמַּשְׁכַּנְתָּא.",
            exampleNative = "Банк затребовал אִישּׁוּר תַּעֲסוּקָה для оформления ипотеки.",
            isFillInBlankSafe = false),
        WordEntity(
            id = 180922, setId = 1809, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_certificates", transliteration = "hatsharat hon",
            original = "הַצְהָרַת הוֹן", translation = "декларация об имуществе",
            definition = "טֹפֶס רִשְׁמִי שֶׁמְּפָרֵט אֶת כָּל הָרְכוּשׁ וְהַחִסָּכוֹן שֶׁל הָאָדָם לַשִּׁלְטוֹנוֹת.",
            definitionNative = "Официальная анкета — всё имущество и сбережения человека для государства.",
            example = "פָּקִיד הַשּׁוּמָה דָּרַשׁ הַצְהָרַת הוֹן אַחַת לְעֶשֶׂר שָׁנִים.",
            exampleNative = "Налоговый инспектор требует הַצְהָרַת הוֹן раз в десять лет.",
            isFillInBlankSafe = false),
        WordEntity(
            id = 180923, setId = 1809, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_certificates", transliteration = "teudat bagrut",
            original = "תְּעוּדַת בָּגְרוּת", translation = "аттестат зрелости",
            definition = "מִסְמָךְ רִשְׁמִי שֶׁמְּצַיֵּן הַשְׁלָמָה שֶׁל בֵּית סֵפֶר תִּיכוֹן בְּהַצְלָחָה.",
            definitionNative = "Официальный документ — выпускник средней школы успешно завершил курс.",
            example = "בְּלִי תְּעוּדַת בָּגְרוּת קָשֶׁה לְהִתְקַבֵּל לָאוּנִיבֶרְסִיטָה.",
            exampleNative = "Без תְּעוּדַת בָּגְרוּת сложно поступить в университет.",
            isFillInBlankSafe = false),
        WordEntity(
            id = 180924, setId = 1809, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "bureau_certificates", transliteration = "teudat shikhrur",
            original = "תְּעוּדַת שִׁחְרוּר", translation = "справка об увольнении из армии",
            definition = "מִסְמָךְ צְבָאִי שֶׁמְּעִיד עַל סִיּוּם הַשֵּׁירוּת הַסָּדִיר וְהַסְטָטוּס שֶׁל הַחַיָּל.",
            definitionNative = "Военный документ — об окончании срочной службы и статусе бывшего солдата.",
            example = "מַעֲסִיקִים בִּקְּשׁוּ לִרְאוֹת תְּעוּדַת שִׁחְרוּר בָּרֵאַיוֹן.",
            exampleNative = "Работодатели попросили показать תְּעוּדַת שִׁחְרוּר на собеседовании.",
            isFillInBlankSafe = false),
        WordEntity(
            id = 180925, setId = 1809, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "bureau_certificates", transliteration = "mirsham plili",
            original = "מִרְשָׁם פְּלִילִי", translation = "справка о судимости (выписка из реестра)",
            definition = "מִסְמָךְ מֵהַמְּדִינָה שֶׁמַּרְאֶה הַאִם רָשׁוּם נֶגֶד הָאָדָם רֶקַע מִשְׁפָּטִי.",
            definitionNative = "Бумага из госреестра — числится ли за человеком уголовное дело.",
            example = "הַמַּעֲסִיק דָּרַשׁ מִרְשָׁם פְּלִילִי נָקִי לְעֲבוֹדָה עִם יְלָדִים.",
            exampleNative = "Работодатель потребовал чистый מִרְשָׁם פְּלִילִי для работы с детьми.",
            isFillInBlankSafe = false),
    )
}
