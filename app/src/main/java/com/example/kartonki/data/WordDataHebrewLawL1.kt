package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary V2: Law level 1 (single set, 25 words).
 *
 * Set 1703 — базовая юридическая лексика для репатриантов: документы,
 * заявление, права. 15 COMMON + 10 UNCOMMON. Сет нацелен на первую
 * волну бытовой бюрократии оле — теудат-зеут, виза, заявление, печать,
 * посольство, явка в полицию.
 *
 * Не пересекается со словами в существующих he-ru сетах темы «Право»
 * (1063, 1064, 1089, 1195, 1278, 1279, 1495, 1496, 1537) — те покрывают
 * level 2-5 (адвокат, суд, иск, апелляция и т.д.).
 *
 * Все слова помечены isFillInBlankSafe=false: ивритская морфология
 * (биньян, огласовки, артикли, смихут) часто ломает подстрочную замену
 * в FILL_IN_BLANK, пока не реализована Hebrew-aware логика (см. правило 16c).
 */
object WordDataHebrewLawL1 {

    val sets = listOf(
        WordSetEntity(
            id = 1703, languagePair = "he-ru", orderIndex = 1703,
            name = "Право",
            description = "Базовая юридическая лексика: документы, заявление, права",
            topic = "Право", level = 1,
        ),
    )

    val words = listOf(

        // ── Set 1703 — Право: основы (level 1, COMMON+UNCOMMON) ───────────

        // ── COMMON (15) ───────────────────────────────────────────────────

        // ── law_id_documents (5) ──────────────────────────────────────────
        WordEntity(
            id = 170301, setId = 1703, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "law_id_documents", transliteration = "теудат зеут",
            original = "תְּעוּדַת זֶהוּת", translation = "удостоверение личности (теудат-зеут)",
            definition = "הַמִּסְמָךְ הָרִשְׁמִי שֶׁמְּזַהֶה תּוֹשָׁב יִשְׂרָאֵל לְכָל גּוּף מֶמְשַׁלְתִּי.",
            definitionNative = "Главный документ, который опознаёт жителя Израиля во всех государственных инстанциях.",
            example = "הַפָּקִיד בִּקֵּשׁ לִרְאוֹת אֶת תְּעוּדַת זֶהוּת בָּאוֹלָם.",
            exampleNative = "Чиновник попросил показать תְּעוּדַת זֶהוּת в зале.",
        ),
        WordEntity(
            id = 170302, setId = 1703, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "law_id_documents", transliteration = "даркон",
            original = "דַּרְכּוֹן", translation = "паспорт (заграничный)",
            definition = "סֵפֶר קָטָן מֵהַמְּדִינָה הַמַּתִּיר יְצִיאָה וּכְנִיסָה לִמְדִינוֹת זָרוֹת.",
            definitionNative = "Маленькая книжка от государства, разрешающая выезд и въезд в чужие страны.",
            example = "שַׂמְתִּי אֶת הַדַּרְכּוֹן בַּכַּסֶּפֶת לִפְנֵי הַטִּיסָה.",
            exampleNative = "Я положил דַּרְכּוֹן в сейф перед рейсом.",
         fillInBlankExclusions = listOf(170303L, 170304L, 170305L)),
        WordEntity(
            id = 170303, setId = 1703, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "law_id_documents", transliteration = "ашра",
            original = "אַשְׁרָה", translation = "виза",
            definition = "הֶחְתֵּם רִשְׁמִי בַּדַּרְכּוֹן הַמַּתִּיר שְׁהוּת בִּמְדִינָה זָרָה.",
            definitionNative = "Официальная отметка в паспорте, разрешающая находиться в чужой стране.",
            example = "קִבַּלְנוּ אַשְׁרָה לְשָׁנָה אַחַת מֵהַשַּׁגְרִירוּת.",
            exampleNative = "Мы получили אַשְׁרָה на год от посольства.",
         fillInBlankExclusions = listOf(170302L, 170304L, 170305L)),
        WordEntity(
            id = 170304, setId = 1703, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "law_id_documents", transliteration = "теуда",
            original = "תְּעוּדָה", translation = "справка / свидетельство",
            definition = "כְּתָב רִשְׁמִי קָצָר הַמְאַשֵּׁר עֻבְדָּה אוֹ מַעֲמָד מְסֻיָּם שֶׁל אָדָם.",
            definitionNative = "Короткая официальная бумага, удостоверяющая определённый факт или статус человека.",
            example = "הֵבֵאתִי תְּעוּדָה מֵהָרוֹפֵא לִמְקוֹם הָעֲבוֹדָה.",
            exampleNative = "Я принёс תְּעוּדָה от врача на работу.",
         fillInBlankExclusions = listOf(170302L, 170303L, 170305L)),
        WordEntity(
            id = 170305, setId = 1703, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "law_id_documents", transliteration = "мисмах",
            original = "מִסְמָךְ", translation = "документ (бумага)",
            definition = "כָּל דַּף רִשְׁמִי הַחָתוּם אוֹ הֶחָתוּם בְּחוֹתֶמֶת, כְּמוֹ חוֹזֶה אוֹ אִישּׁוּר.",
            definitionNative = "Любая официальная бумага с подписью или печатью — например, договор или справка.",
            example = "שָׁכַחְתִּי אֶת הַמִּסְמָךְ הֶחָשׁוּב בַּמִּשְׂרָד.",
            exampleNative = "Я забыл важный מִסְמָךְ в офисе.",
            isFillInBlankSafe = false,
        ),

        // ── law_office_paperwork (5) ──────────────────────────────────────
        WordEntity(
            id = 170306, setId = 1703, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "law_office_paperwork", transliteration = "хатима",
            original = "חֲתִימָה", translation = "подпись",
            definition = "הַשֵּׁם שֶׁאָדָם כּוֹתֵב בְּיָדוֹ בְּסוֹף נְיָר כְּדֵי לְאַשֵּׁר אוֹתוֹ.",
            definitionNative = "Имя, которое человек пишет рукой в конце бумаги, чтобы её утвердить.",
            example = "צָרִיךְ חֲתִימָה שֶׁל שְׁנֵי הַצְּדָדִים בָּחוֹזֶה.",
            exampleNative = "Нужна חֲתִימָה обеих сторон на договоре.",
         fillInBlankExclusions = listOf(170307L, 170308L, 170309L, 170310L)),
        WordEntity(
            id = 170307, setId = 1703, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "law_office_paperwork", transliteration = "хотэмэт",
            original = "חוֹתֶמֶת", translation = "печать / штамп",
            definition = "כְּלִי שֶׁמַּשְׁאִיר סִימָן רִשְׁמִי שֶׁל מִשְׂרָד אוֹ אִרְגוּן עַל הַמִּסְמָךְ.",
            definitionNative = "Инструмент, оставляющий официальный знак учреждения или организации на бумаге.",
            example = "הַטֹּפֶס לֹא תָּקֵף בְּלִי חוֹתֶמֶת שֶׁל הַמִּשְׂרָד.",
            exampleNative = "Бланк недействителен без חוֹתֶמֶת ведомства.",
         fillInBlankExclusions = listOf(170306L, 170308L, 170309L, 170310L)),
        WordEntity(
            id = 170308, setId = 1703, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "law_office_paperwork", transliteration = "тофэс",
            original = "טֹפֶס", translation = "бланк / форма",
            definition = "דַּף מוּכָן עִם רוֹבְּרִיקוֹת שֶׁמְּמַלְּאִים בִּפְרָטִים אִישִׁיִּים אוֹ בַּקָּשָׁה.",
            definitionNative = "Готовый листок с графами, куда вписывают личные данные или просьбу.",
            example = "מִלֵּאתִי אֶת הַטֹּפֶס לְקַבָּלַת הַסַּל קְלִיטָה.",
            exampleNative = "Я заполнил טֹפֶס для получения корзины абсорбции.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 170309, setId = 1703, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "law_office_paperwork", transliteration = "ишур",
            original = "אִישּׁוּר", translation = "подтверждение / справка",
            definition = "מִכְתָּב קָצָר מִגּוּף רִשְׁמִי הַמְּאַשֵּׁר שֶׁמַּשֶּׁהוּ נָכוֹן אוֹ הֻסְכַּם.",
            definitionNative = "Короткая бумага от учреждения, удостоверяющая, что нечто верно или одобрено.",
            example = "הוּא קִבֵּל אִישּׁוּר עַל תַּשְׁלוּם הָאַגְרָה.",
            exampleNative = "Он получил אִישּׁוּר об оплате пошлины.",
         fillInBlankExclusions = listOf(170304L, 170306L, 170307L, 170308L, 170310L)),
        WordEntity(
            id = 170310, setId = 1703, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "law_office_paperwork", transliteration = "ришайон",
            original = "רִשָּׁיוֹן", translation = "разрешение / лицензия",
            definition = "הֶיתֵּר רִשְׁמִי לַעֲשׂוֹת מַשֶּׁהוּ — לִנְהֹג, לִפְתֹּחַ עֵסֶק, לְהַחְזִיק נֶשֶׁק.",
            definitionNative = "Официальное право что-то делать — водить, открыть бизнес, держать оружие.",
            example = "צָרִיךְ רִשָּׁיוֹן מִיוּחָד לְהַפְעִיל מַסְעָדָה.",
            exampleNative = "Нужен особый רִשָּׁיוֹן для открытия ресторана.",
         fillInBlankExclusions = listOf(170306L, 170307L, 170308L, 170309L)),

        // ── law_authorities_basic (5) ─────────────────────────────────────
        WordEntity(
            id = 170311, setId = 1703, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "law_authorities_basic", transliteration = "миштара",
            original = "מִשְׁטָרָה", translation = "полиция",
            definition = "הַגּוּף הַשּׁוֹמֵר עַל הַסֵּדֶר הַצִּבּוּרִי וְעַל קִיּוּם הַחוֹק.",
            definitionNative = "Орган, который следит за общественным порядком и соблюдением закона.",
            example = "הִתְקַשַּׁרְנוּ לַמִּשְׁטָרָה אַחֲרֵי הַתְּאוּנָה בָּרְחוֹב.",
            exampleNative = "Мы позвонили в מִשְׁטָרָה после аварии на улице.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 170312, setId = 1703, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "law_authorities_basic", transliteration = "пакид",
            original = "פָּקִיד", translation = "чиновник / служащий",
            definition = "עוֹבֵד מִשְׂרָד מֶמְשַׁלְתִּי הַמְּטַפֵּל בִּפְנִיּוֹת שֶׁל הַתּוֹשָׁבִים.",
            definitionNative = "Работник государственной конторы, который ведёт приём граждан и оформляет бумаги.",
            example = "הַפָּקִיד הִסְבִּיר אֵיךְ לְמַלֵּא אֶת הַטֹּפֶס.",
            exampleNative = "פָּקִיד объяснил, как заполнить бланк.",
         fillInBlankExclusions = listOf(170311L, 170313L, 170314L, 170315L)),
        WordEntity(
            id = 170313, setId = 1703, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "law_authorities_basic", transliteration = "нотарьон",
            original = "נוֹטָרְיוֹן", translation = "нотариус",
            definition = "אִישׁ מִקְצוֹעַ שֶׁמַּסְמִיךְ חֲתִימוֹת וּמְאַמֵּת תַּרְגּוּמִים שֶׁל מִסְמָכִים רִשְׁמִיִּים.",
            definitionNative = "Специалист, заверяющий подписи и удостоверяющий переводы официальных документов.",
            example = "הָלַכְנוּ לַנוֹטָרְיוֹן לְאִמּוּת חֲתִימָה עַל הַחוֹזֶה.",
            exampleNative = "Мы пошли к נוֹטָרְיוֹן заверить подпись на договоре.",
         fillInBlankExclusions = listOf(170307L, 170311L, 170312L, 170314L, 170315L)),
        WordEntity(
            id = 170314, setId = 1703, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "law_authorities_basic", transliteration = "шагрирут",
            original = "שַׁגְרִירוּת", translation = "посольство",
            definition = "הַנְּצִיגוּת הָרָאשִׁית שֶׁל מְדִינָה זָרָה בָּעִיר הַבִּירָה.",
            definitionNative = "Главное представительство чужой страны в столице.",
            example = "הִגַּשְׁתִּי בַּקָּשַׁת אַשְׁרָה בְּשַׁגְרִירוּת אַרְצוֹת הַבְּרִית.",
            exampleNative = "Я подал заявление на визу в שַׁגְרִירוּת США.",
         fillInBlankExclusions = listOf(170311L, 170312L, 170313L, 170315L)),
        WordEntity(
            id = 170315, setId = 1703, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "law_authorities_basic", transliteration = "консулия",
            original = "קוֹנְסוּלִיָּה", translation = "консульство",
            definition = "מִשְׂרָד שֶׁל מְדִינָה זָרָה הַמְּטַפֵּל בְּדַרְכּוֹנִים וּבְעִנְיְנֵי אֶזְרָחֶיהָ בְּחוּל.",
            definitionNative = "Учреждение чужой страны, занимающееся паспортами и делами своих граждан за рубежом.",
            example = "הַקּוֹנְסוּלִיָּה הָרוּסִית פְּתוּחָה רַק שָׁלוֹשׁ פְּעָמִים בַּשָּׁבוּעַ.",
            exampleNative = "Российская קוֹנְסוּלִיָּה открыта только три раза в неделю.",
            isFillInBlankSafe = false,
        ),

        // ── UNCOMMON (10) ─────────────────────────────────────────────────

        // ── law_civil_certificates (3) ────────────────────────────────────
        WordEntity(
            id = 170316, setId = 1703, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "law_civil_certificates", transliteration = "теудат лейда",
            original = "תְּעוּדַת לֵידָה", translation = "свидетельство о рождении",
            definition = "מִסְמָךְ רִשְׁמִי הַמְּאַשֵּׁר אֶת תַּאֲרִיךְ וְהוֹרֵי הָאָדָם בִּשְׁעַת לֵידָתוֹ.",
            definitionNative = "Официальная бумага, удостоверяющая дату рождения человека и имена его родителей.",
            example = "צָרִיךְ לְהָבִיא תְּעוּדַת לֵידָה לְהוֹצָאַת דַּרְכּוֹן.",
            exampleNative = "Для оформления паспорта нужно принести תְּעוּדַת לֵידָה.",
         fillInBlankExclusions = listOf(170317L, 170318L)),
        WordEntity(
            id = 170317, setId = 1703, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "law_civil_certificates", transliteration = "теудат нисуин",
            original = "תְּעוּדַת נִישׂוּאִין", translation = "свидетельство о браке",
            definition = "מִסְמָךְ רִשְׁמִי הַמּוֹכִיחַ שֶׁשְּׁנֵי אֲנָשִׁים נִשְּׂאוּ זֶה לְזוֹ עַל פִּי חוֹק.",
            definitionNative = "Официальная бумага, доказывающая, что два человека вступили в брак по закону.",
            example = "תְּעוּדַת נִישׂוּאִין הִיא תְּנַאי לְקַבָּלַת זְכֻיּוֹת מִשְׁפַּחְתִּיּוֹת.",
            exampleNative = "תְּעוּדַת נִישׂוּאִין нужно для получения семейных льгот.",
         fillInBlankExclusions = listOf(170316L, 170318L)),
        WordEntity(
            id = 170318, setId = 1703, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "law_civil_certificates", transliteration = "цилум мисмах",
            original = "צִילּוּם מִסְמָךְ", translation = "копия документа (фотокопия)",
            definition = "הֶעְתֵּק נְאֱמָן לַמְּקוֹר שֶׁמּוּכָן בְּמַכְשִׁיר צִילּוּם וּמְצוֹרָף לַטֹּפֶס.",
            definitionNative = "Точная копия оригинала, сделанная на копировальном аппарате и приложенная к бланку.",
            example = "צָרְפוּ צִילּוּם מִסְמָךְ שֶׁל הַדַּרְכּוֹן לְבַקָּשָׁה.",
            exampleNative = "К заявлению приложите צִילּוּם מִסְמָךְ паспорта.",
            isFillInBlankSafe = false,
        ),

        // ── law_status_basic (4) ──────────────────────────────────────────
        WordEntity(
            id = 170319, setId = 1703, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "law_status_basic", transliteration = "эзрахут",
            original = "אֶזְרָחוּת", translation = "гражданство",
            definition = "הַמַּעֲמָד הַחֻקִּי שֶׁל אָדָם כְּשַׁיָּךְ לִמְדִינָה מְסֻיֶּמֶת עִם זְכֻיּוֹת מְלֵאוֹת.",
            definitionNative = "Юридический статус человека как принадлежащего к определённой стране с полным набором прав.",
            example = "הִיא קִבְּלָה אֶזְרָחוּת מִיָּד אַחֲרֵי הָעֲלִיָּה.",
            exampleNative = "Она получила אֶזְרָחוּת сразу после репатриации.",
         fillInBlankExclusions = listOf(170321L, 170322L)),
        WordEntity(
            id = 170320, setId = 1703, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "law_status_basic", transliteration = "тошав кавуа",
            original = "תּוֹשָׁב קָבוּעַ", translation = "постоянный житель / резидент",
            definition = "מִי שֶׁגָּר בָּאָרֶץ דֶּרֶךְ קֶבַע אַךְ עֲדַיִן אֵינוֹ אֶזְרָח.",
            definitionNative = "Тот, кто живёт в стране на постоянной основе, но ещё не является гражданином.",
            example = "תּוֹשָׁב קָבוּעַ זַכַּאי לְבִיטּוּחַ לְאוּמִּי.",
            exampleNative = "תּוֹשָׁב קָבוּעַ имеет право на национальное страхование.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 170321, setId = 1703, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "law_status_basic", transliteration = "зхуйот",
            original = "זְכֻיּוֹת", translation = "права (личные)",
            definition = "הַדְּבָרִים שֶׁמַּגִּיעִים לְכָל אָדָם עַל פִּי חוֹק — חֻפְשַׁת דִּבּוּר, שִׁוְיוֹן, רְכוּשׁ.",
            definitionNative = "То, что положено каждому по закону — свобода слова, равенство, имущество.",
            example = "כָּל עוֹלֶה חַיָּב לְהַכִּיר אֶת הַזְּכֻיּוֹת שֶׁלּוֹ בָּאָרֶץ.",
            exampleNative = "Каждый репатриант обязан знать свои זְכֻיּוֹת в стране.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 170322, setId = 1703, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "law_status_basic", transliteration = "таариф",
            original = "תַּעֲרִיף", translation = "пошлина / тариф",
            definition = "סְכוּם קָבוּעַ שֶׁמְּשַׁלְּמִים לַמְּדִינָה תְּמוּרַת שֵׁרוּת רִשְׁמִי כְּמוֹ דַּרְכּוֹן.",
            definitionNative = "Фиксированная сумма, которую платят государству за официальную услугу — например, паспорт.",
            example = "הַתַּעֲרִיף לְהוֹצָאַת דַּרְכּוֹן עָלָה הַשָּׁנָה.",
            exampleNative = "תַּעֲרִיף за оформление паспорта вырос в этом году.",
         fillInBlankExclusions = listOf(170319L, 170321L)),

        // ── law_legal_actions_basic (3) ───────────────────────────────────
        WordEntity(
            id = 170323, setId = 1703, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "law_legal_actions_basic", transliteration = "hагаша",
            original = "הַגָּשָׁה", translation = "подача (заявления, документов)",
            definition = "הַעֲבָרַת טֹפֶס אוֹ מִסְמָכִים לַמִּשְׂרָד הָרָאוּי לְטִפּוּל בָּהֶם.",
            definitionNative = "Передача бланка или бумаг в учреждение, которое должно ими заняться.",
            example = "הַהַגָּשָׁה שֶׁל הַבַּקָּשָׁה תְּסַיֵּם בְּסוֹף הַחֹדֶשׁ.",
            exampleNative = "הַגָּשָׁה заявления завершится в конце месяца.",
         fillInBlankExclusions = listOf(170325L)),
        WordEntity(
            id = 170324, setId = 1703, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "law_legal_actions_basic", transliteration = "бакаша",
            original = "בַּקָּשָׁה", translation = "заявление / прошение",
            definition = "פְּנִיָּה כְּתוּבָה לִרְשׁוּת הַמְּבַקֶּשֶׁת שֵׁרוּת אוֹ אִישּׁוּר רִשְׁמִי.",
            definitionNative = "Письменное обращение в орган с просьбой об услуге или официальном одобрении.",
            example = "מִלֵּאתִי בַּקָּשָׁה לַחֲדֵשׁ אֶת הָרִשָּׁיוֹן.",
            exampleNative = "Я заполнил בַּקָּשָׁה о продлении лицензии.",
         fillInBlankExclusions = listOf(170323L, 170325L)),
        WordEntity(
            id = 170325, setId = 1703, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "law_legal_actions_basic", transliteration = "hитьяцвут",
            original = "הִתְיַצְּבוּת", translation = "явка (по вызову)",
            definition = "הַגָּעָה אִישִׁית לְמִשְׂרָד אוֹ לִרְשׁוּת לְפִי הַזְמָנָה רִשְׁמִית.",
            definitionNative = "Личный приход в учреждение или ведомство по официальному вызову.",
            example = "הַזְמָנָה לְהִתְיַצְּבוּת בַּמִּשְׁטָרָה הִגִּיעָה בַּדֹּאַר.",
            exampleNative = "Повестка о הִתְיַצְּבוּת в полицию пришла по почте.",
         fillInBlankExclusions = listOf(170323L, 170324L)),
    )
}
