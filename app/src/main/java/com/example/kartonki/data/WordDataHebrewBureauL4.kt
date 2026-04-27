package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary: Bureaucracy and documents, level 4 (1 set, 25 words).
 * Профессиональная бюрократическая лексика: министерства, мильуим, нотариальные
 * документы, исполнительное производство, гражданско-правовой статус.
 *
 * Set 1810:
 *   1810 (level 4, EPIC + LEGENDARY) — профессиональный: министерства, мильуим,
 *   нотариус, коллекторы, статус.
 *
 * Не пересекается со словами в темах «Право» (1703 — LawL1: базовые документы)
 * и «Алия и Израиль» (Aliya — общие реалии репатрианта). Слова, конфликтующие
 * с этими темами, заменены на синонимичные/смежные:
 *   - אֶזְרָחוּת (LawL1) → הִתְאַזְרְחוּת (натурализация)
 *   - בִּטּוּחַ לְאוּמִי (Aliya) → מוֹסַד לְבִיטּוּחַ לְאוּמִי (название ведомства)
 *   - מַס הַכְנָסָה (Aliya) → רָשׁוּת הַמִּסִּים (налоговое управление)
 *   - נוֹטָרְיוֹן (LawL1) → אִמּוּת חֲתִימָה (заверение подписи нотариусом)
 *
 * Распределение редкостей: 13 EPIC + 12 LEGENDARY (2 смежных уровня).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewBureauL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1810, languagePair = "he-ru", orderIndex = 1810,
            name = "Бюрократия и документы",
            description = "Профессиональный: министерства, мильуим, нотариус, коллекторы",
            topic = "Бюрократия и документы", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1810 — Бюрократия и документы: профессиональный (EPIC + LEGENDARY)
        // 5 групп × 5 слов: ministries, milueim, legal_docs, collections, status
        // ══════════════════════════════════════════════════════════════════════

        // ── bureau_ministries (5 EPIC) — ведомства ──
        WordEntity(
            id = 181001, setId = 1810, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_ministries", transliteration = "мисрад hа-пним",
            original = "מִשְׂרָד הַפְּנִים", translation = "МВД (министерство внутренних дел)",
            definition = "הַגּוּף הַמֶּמְשַׁלְתִּי הָאַחְרַאי לִתְעוּדוֹת זֶהוּת, אֶזְרָחוּת וּלְמִרְשַׁם הָאֻכְלוּסִין.",
            definitionNative = "Ведомство, отвечающее за удостоверения личности, гражданство и регистрацию жителей.",
            example = "מִשְׂרָד הַפְּנִים אִשֵּׁר לִי לְהַחְלִיף שֵׁם מִשְׁפָּחָה.",
            exampleNative = "מִשְׂרָד הַפְּנִים одобрил мне смену фамилии.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181002, setId = 1810, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_ministries", transliteration = "рашут hа-ухлусин",
            original = "רָשׁוּת הָאֻכְלוּסִין", translation = "Управление по делам населения и иммиграции",
            definition = "הַזְּרוֹעַ הַמִּבְצָעִית הַמְּטַפֶּלֶת בְּאַשְׁרוֹת, דַּרְכּוֹנִים וּבִכְנִיסַת זָרִים לָאָרֶץ.",
            definitionNative = "Исполнительный орган, занимающийся визами, паспортами и въездом иностранцев.",
            example = "רָשׁוּת הָאֻכְלוּסִין קוֹבַעַת תּוֹר רַק לְעוֹד חֳדָשַׁיִם.",
            exampleNative = "רָשׁוּת הָאֻכְלוּסִין даёт запись только через два месяца.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181003, setId = 1810, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_ministries", transliteration = "мосад ле-битуах леуми",
            original = "מוֹסַד לְבִיטּוּחַ לְאוּמִי", translation = "Институт национального страхования (Битуах Леуми)",
            definition = "הַגּוּף הַמַּעֲבִיר קִצְבָּאוֹת זִקְנָה, נָכוּת, אַבְטָלָה וּדְמֵי לֵידָה לְכָל הַתּוֹשָׁבִים.",
            definitionNative = "Орган, передающий пенсии, пособия по инвалидности, безработице и материнству.",
            example = "מוֹסַד לְבִיטּוּחַ לְאוּמִי הִכִּיר בִּפְגִיעָה שֶׁלִּי בָּעֲבוֹדָה.",
            exampleNative = "מוֹסַד לְבִיטּוּחַ לְאוּמִי признал мою травму на работе.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181004, setId = 1810, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_ministries", transliteration = "рашут hа-мисим",
            original = "רָשׁוּת הַמִּסִּים", translation = "Налоговое управление",
            definition = "הַגּוּף הַמֶּמְשַׁלְתִּי הָאוֹסֵף הַכְנָסוֹת מֵאֶזְרָחִים וּמֵעֲסָקִים לְפִי הַחֻקִּים שֶׁל הַמְּדִינָה.",
            definitionNative = "Государственное ведомство, собирающее доходы с граждан и предприятий по законам страны.",
            example = "רָשׁוּת הַמִּסִּים שָׁלְחָה דְּרִישַׁת חוֹב עַל שָׁנָה שֶׁעָבְרָה.",
            exampleNative = "רָשׁוּת הַמִּסִּים прислало требование о долге за прошлый год.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181005, setId = 1810, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_ministries", transliteration = "мисрад hа-хуц",
            original = "מִשְׂרָד הַחוּץ", translation = "МИД (министерство иностранных дел)",
            definition = "הַגּוּף הַמְּטַפֵּל בְּקֶשֶׁר עִם מְדִינוֹת זָרוֹת, שַׁגְרִירוּיוֹת וּקְשָׁרִים דִּיפְּלוֹמָטִיִּים.",
            definitionNative = "Ведомство, занимающееся связями с другими странами, посольствами и дипломатией.",
            example = "מִשְׂרָד הַחוּץ פִּרְסֵם אַזְהָרַת מַסָּע לְכַמָּה מְדִינוֹת בָּאֵיזוֹר.",
            exampleNative = "מִשְׂרָד הַחוּץ выпустил предупреждение о поездках в несколько стран региона.",
            isFillInBlankSafe = false,
        ),

        // ── bureau_milueim (3 EPIC + 2 LEGENDARY) — резервная служба ──
        WordEntity(
            id = 181006, setId = 1810, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_milueim", transliteration = "шерут милуим",
            original = "שֵׁרוּת מִלּוּאִים", translation = "резервистская служба",
            definition = "תְּקוּפָה קְצָרָה שֶׁל חַיָּלֵי קֶבַע מְשֻׁחְרָרִים הַחוֹזְרִים לַצָּבָא בִּזְמַן מִלְחָמָה אוֹ אִמּוּן.",
            definitionNative = "Короткие сборы демобилизованных военных, возвращающихся в армию во время войны или учений.",
            example = "שֵׁרוּת מִלּוּאִים הַשָּׁנָה אָרַךְ שִׁשִּׁים יוֹם רְצוּפִים.",
            exampleNative = "שֵׁרוּת מִלּוּאִים в этом году длилась шестьдесят дней подряд.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181007, setId = 1810, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_milueim", transliteration = "цав милуим",
            original = "צַו מִלּוּאִים", translation = "повестка на сборы",
            definition = "מִכְתָּב רִשְׁמִי שֶׁל הַצָּבָא הַמְּחַיֵּב הִתְיַצְּבוּת בְּבָסִיס בְּתַאֲרִיךְ נָקוּב לְפִי הַחֹק.",
            definitionNative = "Официальное письмо армии, обязывающее явиться на базу к указанной дате по закону.",
            example = "קִבַּלְתִּי צַו מִלּוּאִים שָׁבוּעַ לִפְנֵי הַחַג.",
            exampleNative = "Я получил צַו מִלּוּאִים за неделю до праздника.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181008, setId = 1810, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_milueim", transliteration = "бакаша лидхия",
            original = "בָּקָשָׁה לִדְחִיָּה", translation = "просьба об отсрочке",
            definition = "פְּנִיָּה רִשְׁמִית לְהַעֲבִיר מוֹעֵד הִתְיַצְּבוּת אוֹ דִּיּוּן בִּגְלַל סִבָּה אִישִׁית מֻצְדֶּקֶת.",
            definitionNative = "Официальное обращение перенести срок явки или заседания по обоснованной личной причине.",
            example = "הִגַּשְׁנוּ בָּקָשָׁה לִדְחִיָּה כִּי אִשְׁתִּי בָּחֹדֶשׁ הַתְּשִׁיעִי.",
            exampleNative = "Мы подали בָּקָשָׁה לִדְחִיָּה — жена на девятом месяце.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181009, setId = 1810, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "bureau_milueim", transliteration = "ваада рефуит",
            original = "וַעֲדָה רְפוּאִית", translation = "медицинская комиссия",
            definition = "מוֹשָׁב שֶׁל מֻמְחִים בָּרִיאוּת שֶׁמַּחְלִיט עַל כְּשִׁירוּת לַצָּבָא אוֹ עַל אֲחוּזֵי נָכוּת.",
            definitionNative = "Заседание врачей-специалистов, решающих о пригодности к армии или о проценте инвалидности.",
            example = "וַעֲדָה רְפוּאִית קָבְעָה לוֹ פְּטוֹר זְמַנִּי בִּגְלַל גַּב.",
            exampleNative = "וַעֲדָה רְפוּאִית назначила ему временное освобождение из-за спины.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181010, setId = 1810, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "bureau_milueim", transliteration = "птор милуим",
            original = "פְּטוֹר מִלּוּאִים", translation = "освобождение от резервистской службы",
            definition = "אִישּׁוּר רִשְׁמִי הַמְשַׁחְרֵר אָדָם מֵהַצֹּרֶךְ לְהִתְיַצֵּב בַּצָּבָא בִּזְמַן קְרִיאָה.",
            definitionNative = "Официальное подтверждение, снимающее с человека необходимость явиться в армию по призыву.",
            example = "אַחֲרֵי הַנִּתּוּחַ הוּא קִבֵּל פְּטוֹר מִלּוּאִים קָבוּעַ.",
            exampleNative = "После операции он получил постоянное פְּטוֹר מִלּוּאִים.",
            isFillInBlankSafe = false,
        ),

        // ── bureau_legal_docs (2 EPIC + 3 LEGENDARY) — нотариальные документы ──
        WordEntity(
            id = 181011, setId = 1810, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_legal_docs", transliteration = "имут хатима",
            original = "אִמּוּת חֲתִימָה", translation = "заверение подписи (нотариальное)",
            definition = "פְּעוּלָה רִשְׁמִית בָּהּ עוֹרֵךְ דִּין מְאַשֵּׁר שֶׁאָדָם רָשַׁם אֶת שְׁמוֹ בְּפָנָיו אִישִׁית.",
            definitionNative = "Официальная процедура, при которой юрист подтверждает, что человек поставил автограф лично перед ним.",
            example = "צָרִיךְ אִמּוּת חֲתִימָה כְּדֵי לִשְׁלֹחַ אֶת הַחוֹזֶה לַקּוֹנְסוּלִיָּה.",
            exampleNative = "Нужно אִמּוּת חֲתִימָה, чтобы отправить договор в консульство.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181012, setId = 1810, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_legal_docs", transliteration = "ийпуй коах",
            original = "יִיפּוּי כֹּחַ", translation = "доверенность",
            definition = "מִסְמָךְ הַנּוֹתֵן לְאָדָם אַחֵר זְכוּת לִפְעֹל בִּשְׁמֵךְ מוּל בַּנְק, מִשְׂרָד אוֹ בֵּית מִשְׁפָּט.",
            definitionNative = "Бумага, дающая другому человеку право действовать от вашего имени в банке или суде.",
            example = "נָתַתִּי לְאָחִי יִיפּוּי כֹּחַ לְמַכּוֹר אֶת הַדִּירָה בְּמָקוֹמִי.",
            exampleNative = "Я выдал брату יִיפּוּי כֹּחַ продать квартиру вместо меня.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181013, setId = 1810, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "bureau_legal_docs", transliteration = "апостиль",
            original = "אֲפּוֹסְטִיל", translation = "апостиль",
            definition = "חוֹתֶמֶת בֵּין־לְאֻמִּית שֶׁמַּכְשִׁירָה מִסְמָךְ רִשְׁמִי לְשִׁמּוּשׁ בִּמְדִינָה זָרָה.",
            definitionNative = "Международный штамп, делающий официальную бумагу годной для использования в чужой стране.",
            example = "בְּלִי אֲפּוֹסְטִיל הַתְּעוּדָה לֹא תִּתְקַבֵּל בְּגֶרְמַנְיָה.",
            exampleNative = "Без אֲפּוֹסְטִיל справка не будет принята в Германии.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181014, setId = 1810, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "bureau_legal_docs", transliteration = "тацhир мушба",
            original = "תַּצְהִיר מֻשְׁבַּע", translation = "аффидевит (показания под присягой)",
            definition = "מִסְמָךְ כָּתוּב מוּל עוֹרֵךְ דִּין שֶׁמְּקַבֵּל תֹּקֶף שֶׁל עֵדוּת לְכָל דָּבָר בְּבֵית מִשְׁפָּט.",
            definitionNative = "Письменный документ перед юристом, имеющий полную силу свидетельства в суде.",
            example = "הִיא נָתְנָה תַּצְהִיר מֻשְׁבַּע עַל הַתְּאוּנָה שֶׁרָאֲתָה.",
            exampleNative = "Она дала תַּצְהִיר מֻשְׁבַּע об аварии, которую видела.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181015, setId = 1810, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "bureau_legal_docs", transliteration = "хатима электронит",
            original = "חֲתִימָה אִלֶקְטְרוֹנִית", translation = "электронная подпись",
            definition = "סִימָן דִּיגִיטָלִי מֻצְפָּן הַמְּזַהֶה אָדָם בְּמִסְמָכִים מְקֻוָּנִים בְּלִי לִכְתֹּב בַּיָּד.",
            definitionNative = "Зашифрованный цифровой знак, опознающий человека в онлайн-документах без рукописи.",
            example = "חֲתִימָה אִלֶקְטְרוֹנִית מֵהַטֵּלֵפוֹן מַסְפִּיקָה לְכָל טֹפֶס בַּמַּעֲרֶכֶת.",
            exampleNative = "חֲתִימָה אִלֶקְטְרוֹנִית с телефона годится для любой формы в системе.",
            isFillInBlankSafe = false,
        ),

        // ── bureau_collections (2 EPIC + 3 LEGENDARY) — взыскание и долги ──
        WordEntity(
            id = 181016, setId = 1810, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_collections", transliteration = "хов каспи",
            original = "חוֹב כַּסְפִּי", translation = "денежный долг (финансовое обязательство)",
            definition = "סְכוּם שֶׁאָדָם נִדְרָשׁ לְהַחְזִיר לְגוּף אַחֵר וְשֶׁעֲדַיִן לֹא שֻׁלַּם בְּמְלוֹאוֹ.",
            definitionNative = "Сумма, которую следует вернуть другому лицу и которая ещё не выплачена полностью.",
            example = "הוּא צָבַר חוֹב כַּסְפִּי גָּדוֹל אַחֲרֵי שֶׁסָּגַר אֶת הָעֵסֶק.",
            exampleNative = "Он накопил большой חוֹב כַּסְפִּי после закрытия бизнеса.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181017, setId = 1810, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_collections", transliteration = "цав ташлум",
            original = "צַו תַּשְׁלוּם", translation = "приказ об оплате (исполнительный приказ)",
            definition = "הוֹרָאָה שִׁיפּוּטִית הַמְּחַיֶּבֶת אָדָם לְהַעֲבִיר סְכוּם כֶּסֶף תּוֹךְ זְמַן קָצוּב וּמֻגְדָּר.",
            definitionNative = "Судебное распоряжение, обязывающее человека перевести сумму денег в короткий определённый срок.",
            example = "צַו תַּשְׁלוּם הִגִּיעַ בַּדֹּאַר רָשׁוּם בַּשָּׁבוּעַ שֶׁעָבַר.",
            exampleNative = "צַו תַּשְׁלוּם пришёл заказным письмом на прошлой неделе.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181018, setId = 1810, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "bureau_collections", transliteration = "hоцаа ла-поаль",
            original = "הוֹצָאָה לַפֹּעַל", translation = "исполнительное производство",
            definition = "מַעֲרֶכֶת מֶמְשַׁלְתִּית שֶׁמַּכְרִיחָה אֲנָשִׁים לְקַיֵּם הַחְלָטוֹת בֵּית הַמִּשְׁפָּט בְּעִנְיְנֵי כֶּסֶף.",
            definitionNative = "Государственная служба, принудительно взыскивающая судебные решения по денежным делам.",
            example = "הוֹצָאָה לַפֹּעַל פָּתְחָה לִי תִּיק חָדָשׁ בְּתֵל אָבִיב.",
            exampleNative = "הוֹצָאָה לַפֹּעַל открыла мне новое дело в Тель-Авиве.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181019, setId = 1810, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "bureau_collections", transliteration = "икуль",
            original = "עִקּוּל", translation = "арест имущества (наложение взыскания)",
            definition = "פְּעוּלָה מִשְׁפָּטִית הַמַּקְפִּיאָה רְכוּשׁ אוֹ חֶשְׁבּוֹן בַּנְק עַד שֶׁיֻּסְדַּר הַסְּכוּם הַנִּדְרָשׁ.",
            definitionNative = "Юридическое действие, замораживающее собственность или банковский счёт до улаживания требуемой суммы.",
            example = "הַבַּנְק עָשָׂה עִקּוּל עַל הַמַּשְׂכֹּרֶת שֶׁלָּהּ בְּצַו בֵּית מִשְׁפָּט.",
            exampleNative = "Банк наложил עִקּוּל на её зарплату по решению суда.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181020, setId = 1810, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "bureau_collections", transliteration = "hесдер ношим",
            original = "הֶסְדֵּר נוֹשִׁים", translation = "соглашение с кредиторами",
            definition = "הֶסְכֵּם רִשְׁמִי בֵּין חַיָּב לְבַעֲלֵי הַחוֹב עַל לוּחַ הַחְזָרוֹת חָדָשׁ.",
            definitionNative = "Официальный договор между должником и держателями долга о новом графике выплат.",
            example = "אַחֲרֵי מַשָּׂא וּמַתָּן אָרֹךְ נֶחְתַּם הֶסְדֵּר נוֹשִׁים בִּפְנֵי בֵּית הַמִּשְׁפָּט.",
            exampleNative = "После долгих переговоров перед судом подписали соглашение с кредиторами.",
            isFillInBlankSafe = false,
        ),

        // ── bureau_status (1 EPIC + 4 LEGENDARY) — гражданский статус ──
        WordEntity(
            id = 181021, setId = 1810, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "bureau_status", transliteration = "решум нисуин",
            original = "רֵישׁוּם נִשּׂוּאִין", translation = "регистрация брака",
            definition = "פְּעוּלָה רִשְׁמִית בָּהּ הַמְּדִינָה מַכְנִיסָה זוּג חָדָשׁ לְמַאֲגַר הַתּוֹשָׁבִים אַחֲרֵי הַחֲתֻנָּה.",
            definitionNative = "Официальное действие, при котором государство вносит новую пару в базу жителей после свадьбы.",
            example = "רֵישׁוּם נִשּׂוּאִין נַעֲשָׂה בַּמִּשְׂרָד שָׁבוּעַ אַחֲרֵי הַטֶּקֶס.",
            exampleNative = "רֵישׁוּם נִשּׂוּאִין был сделан в ведомстве через неделю после церемонии.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181022, setId = 1810, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "bureau_status", transliteration = "hитъазрехут",
            original = "הִתְאַזְרְחוּת", translation = "натурализация (получение гражданства)",
            definition = "תַּהֲלִיךְ בּוֹ אָדָם זָר מְקַבֵּל מַעֲמָד מָלֵא שֶׁל בֶּן הַמְּדִינָה לְפִי בַּקָּשָׁתוֹ.",
            definitionNative = "Процесс, при котором иностранец становится полноправным жителем страны по своему заявлению.",
            example = "הִתְאַזְרְחוּת אוֹרֶכֶת בָּרֶגַע חָמֵשׁ שָׁנִים שֶׁל בְּדִיקוֹת.",
            exampleNative = "הִתְאַזְרְחוּת сейчас занимает пять лет проверок.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181023, setId = 1810, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "bureau_status", transliteration = "тошавут кева",
            original = "תּוֹשָׁבוּת קֶבַע", translation = "статус постоянного жителя (ВНЖ)",
            definition = "מַעֲמָד חֻקִּי הַמַּתִּיר חַיִּים מֵתְמִידִים בָּאָרֶץ עִם זְכֻיּוֹת רַבּוֹת אֲבָל לְלֹא דַּרְכּוֹן.",
            definitionNative = "Юридическое положение, дающее право находиться в стране бессрочно с правами, но без паспорта.",
            example = "תּוֹשָׁבוּת קֶבַע מַתִּירָה לוֹ לִחְיוֹת בָּאָרֶץ עֶשְׂרִים שָׁנָה.",
            exampleNative = "תּוֹשָׁבוּת קֶבַע позволяет ему жить в стране уже двадцать лет.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181024, setId = 1810, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "bureau_status", transliteration = "псак дин",
            original = "פִּסַק דִּין", translation = "судебное решение (приговор / вердикт)",
            definition = "הַחְלָטָה כְּתוּבָה וְסוֹפִית שֶׁל שׁוֹפֵט הַסּוֹגֶרֶת הַתִּיק וּקוֹבַעַת אֶת תּוֹצְאָתוֹ.",
            definitionNative = "Письменное окончательное заключение судьи, закрывающее дело и определяющее его исход.",
            example = "פִּסַק דִּין נִתַּן רַק חֳדָשַׁיִם אַחֲרֵי הַדִּיּוּן הָאַחֲרוֹן.",
            exampleNative = "פִּסַק דִּין был вынесен только через два месяца после последнего слушания.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 181025, setId = 1810, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "bureau_status", transliteration = "цав hасмаха",
            original = "צַו הַסְמָכָה", translation = "приказ о наделении полномочиями",
            definition = "הַחְלָטָה רִשְׁמִית הַנּוֹתֶנֶת לְאָדָם אוֹ גּוּף זְכוּת לִפְעֹל בְּשֵׁם הַמְּדִינָה בִּתְחוּם מְסֻיָּם.",
            definitionNative = "Официальное распоряжение, дающее лицу или органу право действовать от имени государства в определённой сфере.",
            example = "צַו הַסְמָכָה חָדָשׁ אִפְשֵׁר לוֹ לַחֲתֹם בִּשְׁמוֹ שֶׁל הַשַּׂר.",
            exampleNative = "Новый צַו הַסְמָכָה позволил ему подписывать от имени министра.",
            isFillInBlankSafe = false,
        ),
    )
}
