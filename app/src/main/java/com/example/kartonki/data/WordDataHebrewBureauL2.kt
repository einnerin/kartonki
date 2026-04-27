package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary V2: Bureaucracy & Documents level 2 (single set, 25 words).
 *
 * Set 1808 — продвинутая бюрократическая лексика для оле: разделы ID-документов
 * (номер удостоверения, биометрический паспорт, фото, магнитная карта, вкладыш),
 * виз и сроков действия (תֹּקֶף, продление, обновление, истечение, проштамповка),
 * разрешений и регистрации (Управление народонаселения, статус, льгота, апостиль),
 * пошлин и сборов (אַגְרָה, плата за обработку, налоговая оценка, гербовый сбор,
 * платёжная квитанция), и официальной переписки (обращение, ответ, реф-номер,
 * нотариальный перевод, заверенная копия).
 *
 * 13 UNCOMMON + 12 RARE — спред 2 смежных, валиден для level 2.
 *
 * Сознательно не пересекается со словами в:
 *  - WordDataHebrewLawL1.kt (1703) — там базовый юридический пласт (תְּעוּדַת זֶהוּת,
 *    דַּרְכּוֹן, אַשְׁרָה, חוֹתֶמֶת, אִישּׁוּר, רִשָּׁיוֹן, בַּקָּשָׁה, תַּעֲרִיף, נוֹטָרְיוֹן и т.д.)
 *  - WordDataHebrewAliyaV2.kt (1610-1616) — там абсорбция (פִּקָּדוֹן, מַעֲטָפָה, שׁוֹבֵר,
 *    קְבָּלָה, סֶפַח, פָּטוּר, דּוֹאַר רָשׁוּם, מַעֲמָד, רִשָּׁיוֹן, אַשְׁרָה и т.д.)
 *  - WordDataHebrewImmigrant*.kt — קְבָּלָה, תַּעֲרִיף, בּוּל, תַּשְׁלוּם, חוֹב и т.д.
 *
 * Все слова помечены isFillInBlankSafe=false: ивритская морфология (огласовки,
 * смихут, артикли) ломает наивную замену original→___ в example, пока не
 * реализована Hebrew-aware FILL_IN_BLANK логика. См. правило 16c в rules-index.
 */
object WordDataHebrewBureauL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1808, languagePair = "he-ru", orderIndex = 1808,
            name = "Бюрократия и документы",
            description = "Продвинутый базовый: ID, виза, разрешение, оплата сборов",
            topic = "Бюрократия и документы", level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Set 1808 — Бюрократия и документы: продвинутый (level 2) ──────
        // 13 UNCOMMON + 12 RARE, спред 2 смежных

        // ── bureau_id_papers (5) ──────────────────────────────────────────
        WordEntity(
            id = 180801, setId = 1808, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "bureau_id_papers", transliteration = "миспар зеhут",
            original = "מִסְפַּר זֶהוּת", translation = "номер удостоверения личности",
            definition = "תֵּשַׁע סִפְרוֹת אִישִׁיּוֹת שֶׁבָּהֶן הַמְּדִינָה מְזַהָה כָּל אָדָם בְּמִסְמָכִים.",
            definitionNative = "Девять личных цифр, по которым государство опознаёт человека во всех бумагах.",
            example = "כִּתְבוּ אֶת הַמִּסְפַּר זֶהוּת בָּרֻבְּרִיקָה הָעֶלְיוֹנָה שֶׁל הַטֹּפֶס.",
            exampleNative = "Впишите מִסְפַּר זֶהוּת в верхнюю графу бланка.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180802, setId = 1808, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "bureau_id_papers", transliteration = "даркон биометри",
            original = "דַּרְכּוֹן בִּיוֹמֶטְרִי", translation = "биометрический паспорт",
            definition = "סֵפֶר נְסִיעוֹת חָדָשׁ עִם שְׁבָב אֶלֶקְטְרוֹנִי הַשּׁוֹמֵר עַל פְּרָטֵי הַבַּעַל.",
            definitionNative = "Новый дорожный документ с электронным чипом, хранящим данные владельца.",
            example = "מֵאָז שָׁנָה שֶׁעָבְרָה כּוּלָּם מְקַבְּלִים דַּרְכּוֹן בִּיוֹמֶטְרִי בִּלְבַד.",
            exampleNative = "С прошлого года всем выдают только דַּרְכּוֹן בִּיוֹמֶטְרִי.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180803, setId = 1808, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "bureau_id_papers", transliteration = "тацлум паспорт",
            original = "תַּצְלוּם פַּסְפּוֹרְט", translation = "фото на паспорт",
            definition = "תְּמוּנָה רִשְׁמִית קְטַנָּה לְפָנִים בְּלִי כּוֹבַע אוֹ מִשְׁקָפַיִם כֵּהִים.",
            definitionNative = "Маленький официальный снимок лица — без головного убора и тёмных очков.",
            example = "צִילַּמְתִּי תַּצְלוּם פַּסְפּוֹרְט מָחֳרָתַיִם לִפְנֵי הַתּוֹר.",
            exampleNative = "Я сделал תַּצְלוּם פַּסְפּוֹרְט за день до записи.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180804, setId = 1808, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "bureau_id_papers", transliteration = "картис магнэти",
            original = "כַּרְטִיס מָגְנֶטִי", translation = "магнитная карта (доступа)",
            definition = "פְּלַסְטִיק קָטָן עִם פַּס אוֹ שְׁבָב הַמַּתִּיר כְּנִיסָה לִמְקוֹם רִשְׁמִי.",
            definitionNative = "Маленький пластик с полосой или чипом, дающий доступ в учреждение.",
            example = "הַשּׁוֹמֵר מַעֲבִיר אֶת הַכַּרְטִיס מָגְנֶטִי לִיד הַקּוֹרֵא בַּכְּנִיסָה.",
            exampleNative = "Охранник проводит כַּרְטִיס מָגְנֶטִי возле считывателя на входе.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180805, setId = 1808, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bureau_id_papers", transliteration = "ниспах",
            original = "נִסְפַּח", translation = "вкладыш / приложение к документу",
            definition = "דַּף נוֹסָף הַנִּצְמָד לִתְעוּדָה רִשְׁמִית עִם פְּרָטִים שֶׁל בְּנֵי מִשְׁפָּחָה.",
            definitionNative = "Дополнительный листок, прикреплённый к удостоверению — со сведениями о членах семьи.",
            example = "אִבַּדְתִּי אֶת הַנִּסְפַּח וְצָרִיךְ לְהַזְמִין אוֹתוֹ מֵחָדָשׁ.",
            exampleNative = "Я потерял נִסְפַּח и должен заказать новый.",
            isFillInBlankSafe = false,
        ),

        // ── bureau_visas (5) ──────────────────────────────────────────────
        WordEntity(
            id = 180806, setId = 1808, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bureau_visas", transliteration = "токеф",
            original = "תֹּקֶף", translation = "срок действия",
            definition = "פֶּרֶק זְמַן שֶׁבּוֹ מִסְמָךְ אוֹ אִישּׁוּר נֶחְשָׁבִים חוּקִיִּים וְקַיָּמִים.",
            definitionNative = "Промежуток времени, в течение которого документ или одобрение считаются действительными.",
            example = "הַתֹּקֶף שֶׁל הָאַשְׁרָה שֶׁלִּי מִסְתַּיֵּם בְּסוֹף הַחֹדֶשׁ.",
            exampleNative = "תֹּקֶף моей визы заканчивается в конце месяца.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180807, setId = 1808, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bureau_visas", transliteration = "hаараха",
            original = "הַאֲרָכָה", translation = "продление (срока)",
            definition = "הוֹסָפַת זְמַן רִשְׁמִית לְמִסְמָךְ קָרוֹב לִפּוּג, כְּדֵי לְהַמְשִׁיךְ לְהִשְׁתַּמֵּשׁ בּוֹ.",
            definitionNative = "Официальная добавка времени к документу, который скоро истечёт, чтобы и дальше им пользоваться.",
            example = "הִגַּשְׁתִּי בַּקָּשָׁה לְהַאֲרָכָה שֶׁל שֵׁשָׁה חֳדָשִׁים נוֹסָפִים.",
            exampleNative = "Я подал просьбу о הַאֲרָכָה ещё на полгода.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180808, setId = 1808, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "bureau_visas", transliteration = "хидуш",
            original = "חִידּוּשׁ", translation = "обновление документа",
            definition = "הוֹצָאָה שֶׁל מִסְמָךְ זֵהֶה בִּמְקוֹם זֶה שֶׁפַּג, בְּלִי לְשַׁנּוֹת אֶת תָּכְנוֹ.",
            definitionNative = "Выдача такого же документа взамен истёкшего — без изменения содержимого.",
            example = "הַחִידּוּשׁ שֶׁל הַדַּרְכּוֹן עוֹלֶה כַּמָּה מֵאוֹת שְׁקָלִים.",
            exampleNative = "חִידּוּשׁ загранпаспорта стоит несколько сотен шекелей.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180809, setId = 1808, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "bureau_visas", transliteration = "моэд тфуга",
            original = "מוֹעֵד תְּפוּגָה", translation = "дата истечения",
            definition = "הַיּוֹם הָאַחֲרוֹן שֶׁבּוֹ מִסְמָךְ עוֹדֶנּוּ חוּקִי — אַחֲרָיו צָרִיךְ חָדָשׁ.",
            definitionNative = "Последний день, когда документ ещё действителен — потом нужен новый.",
            example = "בִּדְקוּ אֶת הַמּוֹעֵד תְּפוּגָה לִפְנֵי הַטִּיסָה לְחוּ\"ל.",
            exampleNative = "Проверьте מוֹעֵד תְּפוּגָה перед вылетом за границу.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180810, setId = 1808, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bureau_visas", transliteration = "hахтама",
            original = "הַחְתָּמָה", translation = "проштамповка / простановка штампа",
            definition = "הַטְבָּעַת סִימָן רִשְׁמִי עַל מִסְמָךְ אוֹ עַל דַּרְכּוֹן בִּזְמַן מַעֲבַר גְּבוּל.",
            definitionNative = "Нанесение официального оттиска на документ или паспорт — например, при пересечении границы.",
            example = "אַחֲרֵי הַהַחְתָּמָה אֶפְשָׁר לָצֵאת בִּטֶרְמִינָל הַיְצִיאָה.",
            exampleNative = "После הַחְתָּמָה можно идти в зал вылета.",
            isFillInBlankSafe = false,
        ),

        // ── bureau_permits (5) ────────────────────────────────────────────
        WordEntity(
            id = 180811, setId = 1808, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "bureau_permits", transliteration = "рашут hаухлусин",
            original = "רַשׁוּת הָאֻכְלוּסִין", translation = "Управление народонаселения и иммиграции",
            definition = "הַגּוּף הַמֶּמְשַׁלְתִּי הָרָאשִׁי שֶׁמְּטַפֵּל בִּתְעוּדוֹת זֶהוּת, דַּרְכּוֹנִים וְהֶיתֵּרֵי שְׁהִיָּה.",
            definitionNative = "Главный госорган, занимающийся ID-удостоверениями, паспортами и разрешениями на пребывание.",
            example = "הִתְקַשַּׁרְתִּי לְרַשׁוּת הָאֻכְלוּסִין לְזַמֵּן תּוֹר חָדָשׁ.",
            exampleNative = "Я позвонил в רַשׁוּת הָאֻכְלוּסִין записаться на новую очередь.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180812, setId = 1808, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "bureau_permits", transliteration = "маамад хуки",
            original = "מַעֲמָד חוּקִי", translation = "правовой статус",
            definition = "הַהַגְדָּרָה הָרִשְׁמִית שֶׁל אָדָם בָּאָרֶץ — אֶזְרָח, תּוֹשָׁב אוֹ זָר.",
            definitionNative = "Официальное определение положения человека в стране — гражданин, житель или иностранец.",
            example = "בְּלִי מַעֲמָד חוּקִי קָבוּעַ אִי אֶפְשָׁר לִפְתֹּחַ חֶשְׁבּוֹן בַּנְק.",
            exampleNative = "Без постоянного מַעֲמָד חוּקִי нельзя открыть банковский счёт.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180813, setId = 1808, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bureau_permits", transliteration = "зхаут",
            original = "זְכָאוּת", translation = "право на льготу",
            definition = "הַתְּנַאי שֶׁבּוֹ אָדָם רַשַּׁאי לְקַבֵּל הֲטָבָה, הֲנָחָה אוֹ שֵׁרוּת מֵהַמְּדִינָה.",
            definitionNative = "Условие, при котором человек вправе получить льготу, скидку или услугу от государства.",
            example = "הַזְּכָאוּת לַסַּל קְלִיטָה תַּקֵּפָה בְּשָׁנָה הָרִאשׁוֹנָה.",
            exampleNative = "זְכָאוּת на корзину абсорбции действует в первый год.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180814, setId = 1808, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "bureau_permits", transliteration = "hитъагдут",
            original = "הִתְאַגְּדוּת", translation = "регистрация юр. лица / создание объединения",
            definition = "פְּעוּלָה רִשְׁמִית שֶׁבָּהּ מִקְבֶּצֶת אֲנָשִׁים הוֹפֶכֶת לְגוּף חוּקִי אֶחָד.",
            definitionNative = "Официальное действие, при котором группа людей становится единым юридическим лицом.",
            example = "הַהִתְאַגְּדוּת שֶׁל הַעֲמוּתָה דּוֹרֶשֶׁת חֲתִימָה עַל תַּקָּנוֹן.",
            exampleNative = "הִתְאַגְּדוּת некоммерческой организации требует подписать устав.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180815, setId = 1808, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "bureau_permits", transliteration = "апостиль",
            original = "אַפּוֹסְטִיל", translation = "апостиль (международная заверка)",
            definition = "אִישּׁוּר בֵּין־לְאֻמִּי קָצָר שֶׁמּוֹכִיחַ שֶׁמִּסְמָךְ זָר נֶחְתַּם כָּחוּק בִּמְדִינָתוֹ.",
            definitionNative = "Краткое международное удостоверение того, что иностранный документ подписан по закону у себя в стране.",
            example = "תְּעוּדַת לֵדָה זָרָה מְחַיֶּבֶת אַפּוֹסְטִיל לִפְנֵי הַגָּשָׁה.",
            exampleNative = "Иностранному свидетельству о рождении нужен אַפּוֹסְטִיל до подачи.",
            isFillInBlankSafe = false,
        ),

        // ── bureau_fees (5) ───────────────────────────────────────────────
        WordEntity(
            id = 180816, setId = 1808, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bureau_fees", transliteration = "агра",
            original = "אַגְרָה", translation = "пошлина (государственная)",
            definition = "סְכוּם קָבוּעַ שֶׁמְּשַׁלְּמִים לַמְּדִינָה תְּמוּרַת שֵׁרוּת רִשְׁמִי כְּמוֹ הוֹצָאַת מִסְמָךְ.",
            definitionNative = "Фиксированная сумма, которую платят государству за официальную услугу — например, выдачу документа.",
            example = "שִׁלַּמְתִּי אֶת הָאַגְרָה בָּדֹּאַר וְקִבַּלְתִּי שׁוֹבֵר.",
            exampleNative = "Я заплатил אַגְרָה на почте и получил квитанцию.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180817, setId = 1808, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "bureau_fees", transliteration = "дмей типуль",
            original = "דְּמֵי טִפּוּל", translation = "плата за обработку (заявления)",
            definition = "תַּשְׁלוּם קָטָן שֶׁגּוֹבֶה הַמִּשְׂרָד עַל בְּדִיקַת הַטֹּפֶס וְהַטִּפּוּל בּוֹ.",
            definitionNative = "Небольшой платёж, который контора берёт за рассмотрение бланка и работу с ним.",
            example = "צָרִיךְ לְהַעֲבִיר דְּמֵי טִפּוּל לִפְנֵי שֶׁבּוֹדְקִים אֶת הַבַּקָּשָׁה.",
            exampleNative = "Нужно перевести דְּמֵי טִפּוּל до того, как рассмотрят заявление.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180818, setId = 1808, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "bureau_fees", transliteration = "шума",
            original = "שׁוּמָה", translation = "налоговая оценка / расчёт платежа",
            definition = "חִשּׁוּב רִשְׁמִי שֶׁעוֹשָׂה הַמְּדִינָה כְּדֵי לִקְבֹּעַ כַּמָּה אָדָם חַיָּב לְשַׁלֵּם.",
            definitionNative = "Официальный подсчёт, который делает государство, чтобы установить, сколько человек должен заплатить.",
            example = "הַשּׁוּמָה הִגִּיעָה בַּדֹּאַר עִם פֵּרוּט שֶׁל כָּל הַמַּרְכִּיבִים.",
            exampleNative = "שׁוּמָה пришла по почте — с разбивкой по всем составляющим.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180819, setId = 1808, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "bureau_fees", transliteration = "мас булим",
            original = "מַס בּוּלִים", translation = "гербовый сбор",
            definition = "תַּשְׁלוּם נוֹסָף עַל חוֹזִים וּמִסְמָכִים יְקָרִים — הָיָה נֶחְתָּם פַּעַם בִּדְבָקִיּוֹת קְטַנּוֹת.",
            definitionNative = "Дополнительный платёж за договоры и дорогие документы — раньше его клеили маленькими наклейками.",
            example = "בִּטְלוּ אֶת הַמַּס בּוּלִים עַל מְכִירַת דִּירוֹת בִּשְׁנַת אַלְפָּיִם וְשֵׁשׁ.",
            exampleNative = "מַס בּוּלִים на продажу квартир отменили в две тысячи шестом году.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180820, setId = 1808, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "bureau_fees", transliteration = "тлуш ташлум",
            original = "תְּלוּשׁ תַּשְׁלוּם", translation = "платёжная квитанция",
            definition = "פְּרוּסָה קְטַנָּה מֵהַטֹּפֶס שֶׁמַּחֲזִיר הַבַּנְק אַחֲרֵי הַעֲבָרַת הַסְּכוּם.",
            definitionNative = "Маленький отрезной талон, который банк возвращает после перевода нужной суммы.",
            example = "צָרְפוּ אֶת הַתְּלוּשׁ תַּשְׁלוּם לַטֹּפֶס וְהַגִּישׁוּ לַמִּשְׂרָד.",
            exampleNative = "Подколите תְּלוּשׁ תַּשְׁלוּם к бланку и сдайте в контору.",
            isFillInBlankSafe = false,
        ),

        // ── bureau_correspond (5) ─────────────────────────────────────────
        WordEntity(
            id = 180821, setId = 1808, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bureau_correspond", transliteration = "пния",
            original = "פְּנִיָּה", translation = "обращение (в инстанцию)",
            definition = "מִכְתָּב קָצָר שֶׁאָדָם שׁוֹלֵחַ לְמִשְׂרָד כְּדֵי לְבַקֵּשׁ עֶזְרָה אוֹ הַסְבָּרָה.",
            definitionNative = "Короткое письмо, которое человек посылает в учреждение, чтобы попросить помощи или объяснений.",
            example = "הַפְּנִיָּה שֶׁלִּי לַמִּשְׂרָד נִשְׁלְחָה בַּדֹּאַר הָאֶלֶקְטְרוֹנִי.",
            exampleNative = "פְּנִיָּה в министерство я отправил по электронной почте.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180822, setId = 1808, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "bureau_correspond", transliteration = "маанэ ришми",
            original = "מַעֲנֵה רִשְׁמִי", translation = "официальный ответ",
            definition = "מִכְתָּב חָתוּם מִגּוּף מֶמְשַׁלְתִּי שֶׁמּוֹסֵר הַחְלָטָה כְּתוּבָה עַל פְּנִיָּה.",
            definitionNative = "Подписанное письмо от госоргана, передающее письменное решение по обращению.",
            example = "קִבַּלְתִּי מַעֲנֵה רִשְׁמִי כַּעֲבֹר שְׁלוֹשָׁה שָׁבוּעוֹת בִּלְבַד.",
            exampleNative = "מַעֲנֵה רִשְׁמִי я получил всего через три недели.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180823, setId = 1808, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "bureau_correspond", transliteration = "асмахта",
            original = "אַסְמַכְתָּא", translation = "номер-подтверждение / референс",
            definition = "צֵרוּף אוֹתִיּוֹת וּמִסְפָּרִים יִיחוּדִי הַמְּזַהֶה פְּעֻלָּה רִשְׁמִית בְּמַעֲרֶכֶת.",
            definitionNative = "Уникальное сочетание букв и цифр, которое опознаёт официальное действие в системе.",
            example = "מָסְרוּ לִי אַסְמַכְתָּא לְעִקּוּב אַחֲרֵי הַטִּפּוּל בַּפְּנִיָּה.",
            exampleNative = "Мне выдали אַסְמַכְתָּא для отслеживания работы по обращению.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180824, setId = 1808, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "bureau_correspond", transliteration = "таргум нотарьони",
            original = "תַּרְגּוּם נוֹטָרְיוֹנִי", translation = "нотариальный перевод",
            definition = "הַעֲבָרַת מִסְמָךְ זָר לִשְׂפָה אַחֶרֶת — חֲתוּמָה בִּידֵי אִישׁ מִקְצוֹעַ מֻסְמָךְ.",
            definitionNative = "Перевод иностранного документа на другой язык — заверенный квалифицированным специалистом.",
            example = "צָרִיךְ תַּרְגּוּם נוֹטָרְיוֹנִי שֶׁל הַתְּעוּדָה לְהַגָּשָׁה לַמּוֹסָד.",
            exampleNative = "Для подачи в учреждение нужен תַּרְגּוּם נוֹטָרְיוֹנִי справки.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180825, setId = 1808, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "bureau_correspond", transliteration = "hэетек нээман ламакор",
            original = "הַעְתֵּק נֶאֱמָן לַמָּקוֹר", translation = "заверенная копия",
            definition = "צִילּוּם שֶׁל מִסְמָךְ עִם חוֹתֶמֶת וַחֲתִימָה הַמְּאַשְּׁרוֹת זֵהוּת מְלֵאָה לַמְּקוֹר.",
            definitionNative = "Копия документа со штампом и подписью, удостоверяющими полное соответствие оригиналу.",
            example = "בַּתִּיק הִכְנַסְתִּי הַעְתֵּק נֶאֱמָן לַמָּקוֹר שֶׁל הַחוֹזֶה.",
            exampleNative = "В дело я вложил הַעְתֵּק נֶאֱמָן לַמָּקוֹר договора.",
            isFillInBlankSafe = false,
        ),
    )
}
