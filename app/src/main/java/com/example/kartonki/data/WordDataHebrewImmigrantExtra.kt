package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity

/**
 * Extra words (positions 21–25) for immigrant sets 1022–1037.
 * All sets were missing 5 words to reach the standard 25-word count.
 * This file adds them without touching the original batch files.
 *
 * No WordSetEntity entries here — the sets already exist in Immigrant/2/3/4.
 */
object WordDataHebrewImmigrantExtra {

    val words = listOf(

        // ──────────────────────────────────────────────────────
        // Set 1022 — Документы и оформление (слова 21–25)
        // ──────────────────────────────────────────────────────

        WordEntity(
            id = 102221, setId = 1022, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "documents", transliteration = "srika",
            original = "סְרִיקָה", translation = "сканирование / ксерокопия",
            definition = "הַעְתָּקָה דִּיגִיטָלִית שֶׁל מִסְמָךְ בְּאֶמְצָעוּת סוֹרֵק.",
            definitionNative = "Цифровая копия документа, созданная с помощью сканера.",
            example = "הַמִּשְׂרָד מְבַקֵּשׁ סְרִיקָה שֶׁל הַדַּרְכּוֹן.",
            exampleNative = "Офис просит предоставить סְרִיקָה паспорта.",
        ),
        WordEntity(
            id = 102222, setId = 1022, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "documents", transliteration = "teudat ole",
            original = "תְּעוּדַת עוֹלֶה", translation = "удостоверение репатрианта",
            definition = "מִסְמָךְ רִשְׁמִי הַמְּעִיד עַל מַעֲמַד הָעוֹלֶה הֶחָדָשׁ בְּיִשְׂרָאֵל.",
            definitionNative = "Официальный документ, подтверждающий статус нового репатрианта в Израиле.",
            example = "תְּעוּדַת עוֹלֶה מְאַפְשֶׁרֶת קַבָּלַת הֲטָבוֹת לַעוֹלֶה.",
            exampleNative = "תְּעוּדַת עוֹלֶה позволяет получать льготы для репатрианта.",
        ),
        WordEntity(
            id = 102223, setId = 1022, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "documents", transliteration = "hagasha",
            original = "הַגָּשָׁה", translation = "подача (документов)",
            definition = "מְסִירַת מִסְמָכִים אוֹ בַּקָּשָׁה לְגוּף מֻסָּמָךְ.",
            definitionNative = "Передача документов или запроса уполномоченному органу.",
            example = "הַגָּשַׁת הַבַּקָּשָׁה צְרִיכָה לְהֵעָשׂוֹת לִפְנֵי הַתַּאֲרִיךְ הַקּוֹבֵעַ.",
            exampleNative = "הַגָּשָׁה заявки должна быть сделана до установленного срока.",
        ),
        WordEntity(
            id = 102224, setId = 1022, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "documents", transliteration = "original",
            original = "אוֹרִיגִינָל", translation = "оригинал (документа)",
            definition = "הַמִּסְמָךְ הָרִאשׁוֹנִי וְהָאֲמִיתִי, לֹא עוֹתֶק.",
            definitionNative = "Первый и подлинный документ, не копия.",
            example = "צְרִיךְ לְהָבִיא אֶת הָאוֹרִיגִינָל, לֹא צִלּוּם.",
            exampleNative = "Нужно принести אוֹרִיגִינָל, а не копию.",
        ),
        WordEntity(
            id = 102225, setId = 1022, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "documents", transliteration = "khothemet",
            original = "חוֹתֶמֶת", translation = "печать / штамп",
            definition = "סִימָן רִשְׁמִי שֶׁל רָשׁוּת אוֹ גּוּף הַמּוּטְבָּע עַל מִסְמָךְ לְאִישּׁוּר.",
            definitionNative = "Официальный знак органа или организации, проставляемый на документ для подтверждения.",
            example = "הַמִּסְמָךְ לֹא תָּקֵף בְּלִי חוֹתֶמֶת הַמִּשְׂרָד.",
            exampleNative = "Документ недействителен без חוֹתֶמֶת учреждения.",
        ),

        // ──────────────────────────────────────────────────────
        // Set 1023 — Алия и абсорбция (слова 21–25)
        // ──────────────────────────────────────────────────────

        WordEntity(
            id = 102321, setId = 1023, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "aliya", transliteration = "merkaz klita",
            original = "מֵרְכָּז קְלִיטָה", translation = "центр абсорбции",
            definition = "מְקוֹם מֶגוּרִים זְמַנִּי לְעוֹלִים חֲדָשִׁים עִם שֵׁרוּתִים לְקְלִיטָה.",
            definitionNative = "Временное место проживания для новых репатриантов со службами абсорбции.",
            example = "גַּרְנוּ בְּמֵרְכָּז קְלִיטָה בְּמֶשֶׁךְ שֵׁשׁ חֳדָשִׁים אַחֲרֵי הָעֲלִיָּה.",
            exampleNative = "После алии мы жили в מֵרְכָּז קְלִיטָה шесть месяцев.",
        ),
        WordEntity(
            id = 102322, setId = 1023, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "aliya", transliteration = "ezrakh",
            original = "אֶזְרַח", translation = "гражданин",
            definition = "אָדָם הַמַּחְזִיק אֶזְרָחוּת מְדִינָה וְנֶהֱנֶה מִזְּכוּיוֹתֶיהָ.",
            definitionNative = "Человек, имеющий гражданство государства и пользующийся его правами.",
            example = "לְאַחַר שָׁלוֹשׁ שָׁנִים בָּאָרֶץ קִבַּלְתִּי אֶזְרָחוּת יִשְׂרְאֵלִית.",
            exampleNative = "После трёх лет в стране я стал אֶזְרַח Израиля.",
        ),
        WordEntity(
            id = 102323, setId = 1023, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "aliya", transliteration = "magur zmani",
            original = "מָגוּר זְמַנִּי", translation = "временное жильё",
            definition = "מְקוֹם מֶגוּרִים לִתְקוּפָה קְצָרָה עַד מְצִיאַת דִּיּוּר קָבוּעַ.",
            definitionNative = "Место проживания на короткое время до нахождения постоянного жилья.",
            example = "בְּמָגוּר זְמַנִּי גָּרְנוּ אֶצֶל קְרוֹבֵי מִשְׁפָּחָה בְּמֶשֶׁךְ הַחוֹדֶשׁ הָרִאשׁוֹן.",
            exampleNative = "В мָגוּר זְמַנִּי мы жили у родственников в первый месяц.",
        ),
        WordEntity(
            id = 102324, setId = 1023, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "aliya", transliteration = "kursus",
            original = "כּוּרְסוּס", translation = "краткий курс / интенсив",
            definition = "לִמּוּד קָצָר וּמְרֻכָּז בְּנוֹשֵׂא מְסוּיָּם.",
            definitionNative = "Короткое интенсивное обучение по определённой теме.",
            example = "עָשִׂיתִי כּוּרְסוּס בְּחֶשְׁבּוֹנָאוּת בְּמֶשֶׁךְ שְׁלוֹשָׁה שָׁבוּעוֹת.",
            exampleNative = "Я прошёл כּוּרְסוּס по бухгалтерии за три недели.",
        ),
        WordEntity(
            id = 102325, setId = 1023, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "aliya", transliteration = "sherut",
            original = "שֵׁרוּת", translation = "служба / сервис / обслуживание",
            definition = "פְּעִילוּת עֲזָרָה וְהַשְׁלָמַת צְרָכִים לַלָּקוֹחַ אוֹ לַאֶזְרָח.",
            definitionNative = "Деятельность по помощи и удовлетворению нужд клиента или гражданина.",
            example = "הַשֵּׁרוּת בַּמִּשְׂרָד הָיָה מְהִיר וְנֶעֱלָם.",
            exampleNative = "שֵׁרוּת в офисе был быстрым и приятным.",
        ),

        // ──────────────────────────────────────────────────────
        // Set 1024 — Банк: открытие счёта (слова 21–25)
        // ──────────────────────────────────────────────────────

        WordEntity(
            id = 102421, setId = 1024, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bank", transliteration = "menahel kheshbon",
            original = "מְנַהֵל חֶשְׁבּוֹן", translation = "менеджер по счёту",
            definition = "פָּקִיד בַּנְק הָאַחְרָאִי עַל חֶשְׁבּוֹנוֹ שֶׁל לָקוֹחַ וּמְסַיֵּעַ לוֹ.",
            definitionNative = "Сотрудник банка, отвечающий за счёт клиента и помогающий ему.",
            example = "פָּגַשְׁתִּי אֶת מְנַהֵל הַחֶשְׁבּוֹן שֶׁלִּי לְבִירוּר הַמַּשְׁכַּנְתָּא.",
            exampleNative = "Я встретился с мְנַהֵל חֶשְׁבּוֹן по вопросу ипотеки.",
        ),
        WordEntity(
            id = 102422, setId = 1024, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bank", transliteration = "tashlum",
            original = "תַּשְׁלוּם", translation = "платёж / оплата",
            definition = "מְסִירַת כֶּסֶף תְּמוּרַת מוּצָר, שֵׁרוּת אוֹ חוֹב.",
            definitionNative = "Передача денег за товар, услугу или долг.",
            example = "בִּצַּעְתִּי תַּשְׁלוּם דֶּרֶךְ הָאֲפְּלִיקַצְיָה שֶׁל הַבַּנְק.",
            exampleNative = "Я совершил תַּשְׁלוּם через приложение банка.",
        ),
        WordEntity(
            id = 102423, setId = 1024, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bank", transliteration = "shek",
            original = "שֵׁיק", translation = "чек",
            definition = "מִסְמָךְ בַּנְקָאִי לְתַשְׁלוּם סְכוּם קָבוּעַ לְנָמֵן מְסוּיָּם.",
            definitionNative = "Банковский документ для выплаты определённой суммы указанному получателю.",
            example = "שִׁלַּמְתִּי לַמַּשְׂכִּיר בְּשֵׁיק לְשָׁלוֹשָׁה חֳדָשִׁים מֻקְדָּמִים.",
            exampleNative = "Я заплатил арендодателю שֵׁיק за три месяца вперёд.",
        ),
        WordEntity(
            id = 102424, setId = 1024, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bank", transliteration = "kheshbon meshutaf",
            original = "חֶשְׁבּוֹן מְשׁוּתָּף", translation = "совместный счёт",
            definition = "חֶשְׁבּוֹן בַּנְק הַשַּׁיָּךְ לִשְׁנַיִם אוֹ יוֹתֵר בַּעֲלִים.",
            definitionNative = "Банковский счёт, принадлежащий двум или более владельцам.",
            example = "פָּתַחְנוּ חֶשְׁבּוֹן מְשׁוּתָּף עִם בֶּן הַזּוּג לִהוֹצָאוֹת הַבַּיִת.",
            exampleNative = "Мы открыли חֶשְׁבּוֹן מְשׁוּתָּף с партнёром для домашних расходов.",
        ),
        WordEntity(
            id = 102425, setId = 1024, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bank", transliteration = "matbe'a",
            original = "מַטְבֵּעַ", translation = "монета / валюта",
            definition = "מְטַבֵּעַ מִתָּכֶת לְשִׁימּוּשׁ כְּאֶמְצָעֵי תַּשְׁלוּם; כָּלְלִי: מַטְבֵּעַ שֶׁל מְדִינָה.",
            definitionNative = "Металлическая монета для платежей; в общем смысле: валюта страны.",
            example = "הַשֵּׁקֶל הוּא מַטְבֵּעַ יִשְׂרָאֵל.",
            exampleNative = "Шекель — это מַטְבֵּעַ Израиля.",
        ),

        // ──────────────────────────────────────────────────────
        // Set 1025 — Аэропорт Бен-Гурион (слова 21–25)
        // ──────────────────────────────────────────────────────

        WordEntity(
            id = 102521, setId = 1025, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "airport", transliteration = "kartis tisa",
            original = "כַּרְטִיס טִיסָה", translation = "авиабилет",
            definition = "כַּרְטִיס הַמַּזְכֶּה בִּנְסִיעָה בִּטִּיסָה מְסוּיֶּמֶת.",
            definitionNative = "Билет, дающий право на перелёт определённым рейсом.",
            example = "קָנִיתִי כַּרְטִיס טִיסָה לְמוֹסְקְבָה מִרַכֶּשֶׁת מִקָּוָּן.",
            exampleNative = "Я купил כַּרְטִיס טִיסָה в Москву через интернет-магазин.",
        ),
        WordEntity(
            id = 102522, setId = 1025, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "airport", transliteration = "tik yad",
            original = "תִּיק יָד", translation = "ручная кладь / сумка на борт",
            definition = "מִזְוָדָה קְטַנָּה שֶׁמֻּתָּר לְהַעֲלוֹת לְתָא הַנּוֹסְעִים בַּמָּטוֹס.",
            definitionNative = "Небольшой чемодан, который разрешено взять в салон самолёта.",
            example = "גֹּדֶל תִּיק הַיָּד בַּאֲגַד זֶה הוּא עַד 55 עַל 40 עַל 20 סֶנְטִימֶטֶר.",
            exampleNative = "Размер תִּיק יָד у этой авиакомпании до 55×40×20 см.",
        ),
        WordEntity(
            id = 102523, setId = 1025, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "airport", transliteration = "khanut ptura mimelekh",
            original = "חֲנוּת פְּטוּרָה מִמֶּכֶס", translation = "магазин беспошлинной торговли (duty-free)",
            definition = "חֲנוּת בְּשֶׁטַח הַנָּמֵל שֶׁבָּהּ נִמְכָּרוֹת סְחוֹרוֹת בְּלִי מַס.",
            definitionNative = "Магазин на территории аэропорта, в котором товары продаются без налога.",
            example = "קָנִיתִי בּוֹשֶׂם בַּחֲנוּת הַפְּטוּרָה מִמֶּכֶס לִפְנֵי הָרְחִיפָה.",
            exampleNative = "Я купил духи в חֲנוּת פְּטוּרָה מִמֶּכֶס перед вылетом.",
        ),
        WordEntity(
            id = 102524, setId = 1025, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "airport", transliteration = "ya'ed",
            original = "יְעֶד", translation = "пункт назначения",
            definition = "הַמָּקוֹם אֵלָיו מַגִּיעָה הַטִּיסָה אוֹ הַנּוֹסֵעַ.",
            definitionNative = "Место, куда прибывает рейс или пассажир.",
            example = "יְעֶד הַטִּיסָה שֶׁלָּנוּ הוּא פָּרִיז.",
            exampleNative = "יְעֶד нашего рейса — Париж.",
        ),
        WordEntity(
            id = 102525, setId = 1025, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "airport", transliteration = "sha'at hamra'a",
            original = "שַׁעַת הַמְרָאָה", translation = "время вылета",
            definition = "הַשָּׁעָה שֶׁבָּהּ הַמָּטוֹס עוֹלֶה לַאֲוִיר.",
            definitionNative = "Час, в который самолёт поднимается в воздух.",
            example = "שַׁעַת הַהַמְרָאָה שֶׁלָּנוּ הִיא 14:30 — יֵשׁ לְהַגִּיעַ שָׁלוֹשׁ שָׁעוֹת מוּקְדָּם.",
            exampleNative = "Наша שַׁעַת הַמְרָאָה — 14:30, нужно приехать за три часа.",
        ),

        // ──────────────────────────────────────────────────────
        // Set 1026 — Аренда квартиры (слова 21–25)
        // ──────────────────────────────────────────────────────

        WordEntity(
            id = 102621, setId = 1026, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "apartment", transliteration = "khadar sheyna",
            original = "חֲדַר שֵׁינָה", translation = "спальня",
            definition = "הַחֶדֶר הַמְּיוּעָד לִשְׁנָת לָיְלָה.",
            definitionNative = "Комната, предназначенная для ночного сна.",
            example = "הַדִּירָה כּוֹלֶלֶת שְׁנַיִם חַדְרֵי שֵׁינָה וְסָלוֹן.",
            exampleNative = "Квартира включает две חֲדַר שֵׁינָה и гостиную.",
        ),
        WordEntity(
            id = 102622, setId = 1026, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "apartment", transliteration = "kheder okhel",
            original = "חֶדֶר אֹכֶל", translation = "столовая / обеденная зона",
            definition = "הַחֶדֶר אוֹ הַפִּנָּה בַּדִּירָה שֶׁבָּהּ אוֹכְלִים.",
            definitionNative = "Комната или уголок в квартире, где едят.",
            example = "הַמִּטְבָּח וְחֶדֶר הָאֹכֶל הַחִיפְּנוּ בְּדִירָה הַחֲדָשָׁה.",
            exampleNative = "Кухня и חֶדֶר אֹכֶל объединены в новой квартире.",
        ),
        WordEntity(
            id = 102623, setId = 1026, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "apartment", transliteration = "shkhenim",
            original = "שְׁכֵנִים", translation = "соседи",
            definition = "אֲנָשִׁים הַגָּרִים בַּבִּנְיָן אוֹ לְיַד הַדִּירָה.",
            definitionNative = "Люди, живущие в одном доме или рядом с квартирой.",
            example = "הַשְּׁכֵנִים שֶׁלָּנוּ מְאֹד נֶחְמָדִים וְתָּמִיד עוֹזְרִים.",
            exampleNative = "Наши שְׁכֵנִים очень хорошие и всегда помогают.",
        ),
        WordEntity(
            id = 102624, setId = 1026, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "apartment", transliteration = "merkhav",
            original = "מֶרְחָב", translation = "площадь / пространство (жилая площадь)",
            definition = "גֹּדֶל הַשֶּׁטַח שֶׁל דִּירָה אוֹ חֶדֶר בְּמֶטְרִים רְבוּעִים.",
            definitionNative = "Размер площади квартиры или комнаты в квадратных метрах.",
            example = "מֶרְחָב הַדִּירָה הוּא 75 מֶטְרִים רְבוּעִים.",
            exampleNative = "מֶרְחָב квартиры — 75 квадратных метров.",
        ),
        WordEntity(
            id = 102625, setId = 1026, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "apartment", transliteration = "amalat tiyukh",
            original = "עֲמָלַת תִּיּוּךְ", translation = "комиссия агента по недвижимости",
            definition = "תַּשְׁלוּם הַנִּגְבָּה מֵהַשּׁוֹכֵר אוֹ הַמַּשְׂכִּיר בְּתַמּוּרָה לְשֵׁרוּת הַתִּיּוּךְ.",
            definitionNative = "Плата, взимаемая с арендатора или арендодателя за услуги посредничества.",
            example = "עֲמָלַת הַתִּיּוּךְ הִיא בְּדֶרֶךְ כְּלָל מֶחֱצִית חוֹדֶשׁ שְׂכִירוּת.",
            exampleNative = "עֲמָלַת תִּיּוּךְ обычно составляет половину месячной арендной платы.",
        ),

        // ──────────────────────────────────────────────────────
        // Set 1027 — Коммунальные услуги (слова 21–25)
        // ──────────────────────────────────────────────────────

        WordEntity(
            id = 102721, setId = 1027, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "utilities", transliteration = "kheshbon khashmal",
            original = "חֶשְׁבּוֹן חַשְׁמַל", translation = "счёт за электричество",
            definition = "דְּרִישַׁת תַּשְׁלוּם שֶׁל חֶבְרַת הַחַשְׁמַל בְּגִין הַחַשְׁמַל שֶׁנִּצְרַךְ.",
            definitionNative = "Требование оплаты от электрической компании за потреблённую электроэнергию.",
            example = "חֶשְׁבּוֹן הַחַשְׁמַל שֶׁלָּנוּ גָּבֹהַּ בַּקַּיִץ בְּשֶׁל הַמַּזְגָּן.",
            exampleNative = "Наш חֶשְׁבּוֹן חַשְׁמַל высокий летом из-за кондиционера.",
        ),
        WordEntity(
            id = 102722, setId = 1027, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "utilities", transliteration = "provayeder",
            original = "פְּרוֹבַיְדֶר", translation = "провайдер (интернет-поставщик)",
            definition = "חֶבְרָה הַמְּסַפֶּקֶת גִּישָׁה לָאִינְטֶרְנֶט.",
            definitionNative = "Компания, предоставляющая доступ к интернету.",
            example = "עָבַרְתִּי לְפְּרוֹבַיְדֶר אַחֵר כִּי הַמְּהִירוּת הָיְתָה נְמוּכָּה.",
            exampleNative = "Я сменил פְּרוֹבַיְדֶר, потому что скорость была низкой.",
        ),
        WordEntity(
            id = 102723, setId = 1027, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "utilities", transliteration = "khimum",
            original = "חִמּוּם", translation = "отопление",
            definition = "מַעֲרֶכֶת לְחִמּוּם הַבַּיִת בְּמֶזֶג אֲוִיר קַר.",
            definitionNative = "Система для обогрева дома в холодную погоду.",
            example = "בְּחֶרְמוֹן יֵשׁ צֹרֶךְ בְּחִמּוּם בְּחֹרֶף.",
            exampleNative = "В Хермоне зимой необходимо חִמּוּם.",
        ),
        WordEntity(
            id = 102724, setId = 1027, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "utilities", transliteration = "energya",
            original = "אֶנֶרְגְיָה", translation = "энергия",
            definition = "כּוֹחַ אוֹ חַשְׁמַל הַנָּחוּץ לְהַפְעָלַת מִכְשִׁירִים וּבִנְיָנִים.",
            definitionNative = "Сила или электричество, необходимые для работы приборов и зданий.",
            example = "שִׁמּוּשׁ בְּאֶנֶרְגְיָה סוֹלָרִית מוֹרִיד אֶת הַחֶשְׁבּוֹן.",
            exampleNative = "Использование солнечной אֶנֶרְגְיָה снижает счёт за электричество.",
        ),
        WordEntity(
            id = 102725, setId = 1027, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "utilities", transliteration = "ventilatsya",
            original = "וִנְטִילַצְיָה", translation = "вентиляция",
            definition = "מַעֲרֶכֶת לְהַחְלָפַת אֲוִיר בְּמֶרְחָבִים סְגוּרִים.",
            definitionNative = "Система для обмена воздуха в закрытых помещениях.",
            example = "וִנְטִילַצְיָה טוֹבָה חִיּוּנִית בַּחֶדֶר שֶׁל יֶלֶד קָטָן.",
            exampleNative = "Хорошая וִנְטִילַצְיָה необходима в детской комнате.",
        ),

        // ──────────────────────────────────────────────────────
        // Set 1028 — Купат Холим (слова 21–25)
        // ──────────────────────────────────────────────────────

        WordEntity(
            id = 102821, setId = 1028, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "health", transliteration = "rofe shinayim",
            original = "רוֹפֵא שִׁינַּיִם", translation = "стоматолог",
            definition = "רוֹפֵא מְתַמְחֶה בְּבְּרִיאוּת הַשִּׁינַּיִם וְהַחֲנִיכַּיִים.",
            definitionNative = "Врач, специализирующийся на здоровье зубов и дёсен.",
            example = "בִּקַּרְתִּי רוֹפֵא שִׁינַּיִם לְבִדְיקָה שְׁנָתִית.",
            exampleNative = "Я посетил רוֹפֵא שִׁינַּיִם для ежегодного осмотра.",
        ),
        WordEntity(
            id = 102822, setId = 1028, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "health", transliteration = "ti'ud",
            original = "תִּיעוּד", translation = "документация / запись (медицинская)",
            definition = "רִישׁוּם שִׁיטָתִי שֶׁל פְּרָטִים רְפוּאִיִּים שֶׁל הַמְּטוּפָּל.",
            definitionNative = "Систематическая запись медицинских данных пациента.",
            example = "הָרוֹפֵא עָרַךְ תִּיעוּד מְלֵא שֶׁל הַבְּדִיקָה.",
            exampleNative = "Врач вёл полное תִּיעוּד осмотра.",
        ),
        WordEntity(
            id = 102823, setId = 1028, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "health", transliteration = "tik refui",
            original = "תָּיק רְפוּאִי", translation = "медицинская карта / история болезни",
            definition = "מִסְמָךְ הַמְּכִיל אֶת כָּל הַמֵּידַע הָרְפוּאִי שֶׁל הַמְּטוּפָּל.",
            definitionNative = "Документ, содержащий все медицинские данные пациента.",
            example = "הָרוֹפֵא עָיַן בַּתָּיק הָרְפוּאִי שֶׁלִּי לִפְנֵי הַבְּדִיקָה.",
            exampleNative = "Врач просмотрел мой תָּיק רְפוּאִי перед осмотром.",
        ),
        WordEntity(
            id = 102824, setId = 1028, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "health", transliteration = "toran",
            original = "תּוֹרַן", translation = "дежурный (врач / сотрудник)",
            definition = "עוֹבֵד הַמְּבַצֵּעַ תּוֹר שֵׁמֶר בְּשָׁעוֹת שֶׁבָּהֶן אֲחֵרִים אֵינָם בָּמִּשְׁרָד.",
            definitionNative = "Сотрудник, несущий вахту в часы, когда другие не работают.",
            example = "הַתּוֹרַן בַּקּוּפָּה זָמִין גַּם בְּלֵילוֹת.",
            exampleNative = "תּוֹרַן в клинике доступен и по ночам.",
        ),
        WordEntity(
            id = 102825, setId = 1028, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "health", transliteration = "khadar hamtana",
            original = "חֲדַר הַמְּתָנָה", translation = "зал / комната ожидания",
            definition = "הַחֶדֶר שֶׁבּוֹ מְחַכִּים לָנְבֵר לִפְנֵי הַכְּנִיסָה אֵל הָרוֹפֵא.",
            definitionNative = "Комната, где ожидают своей очереди перед входом к врачу.",
            example = "חֲדַר הַמְּתָנָה הָיָה מָלֵא בַּבֹּקֶר.",
            exampleNative = "חֲדַר הַמְּתָנָה был полон утром.",
        ),

        // ──────────────────────────────────────────────────────
        // Set 1029 — Аптека (слова 21–25)
        // ──────────────────────────────────────────────────────

        WordEntity(
            id = 102921, setId = 1029, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pharmacy", transliteration = "antibiotika",
            original = "אַנְטִיבְיוֹטִיקָה", translation = "антибиотик",
            definition = "תְּרוּפָה הַהוֹרֶגֶת חַיְּדַקִּים אוֹ מְעַכֶּבֶת אֶת צְמִיחָתָם.",
            definitionNative = "Лекарство, убивающее бактерии или останавливающее их рост.",
            example = "הָרוֹפֵא רָשַׁם לִי אַנְטִיבְיוֹטִיקָה לַמֶּשֶׁךְ שִׁבְעָה יָמִים.",
            exampleNative = "Врач прописал мне אַנְטִיבְיוֹטִיקָה на семь дней.",
        ),
        WordEntity(
            id = 102922, setId = 1029, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pharmacy", transliteration = "shi'ul",
            original = "שִׁיעוּל", translation = "кашель",
            definition = "רֶפְלֶקְס גּוּפָנִי שֶׁל פְּלִיטַת אֲוִיר מֵהָאֲגַרוֹן בְּלֶחַץ.",
            definitionNative = "Телесный рефлекс выброса воздуха из горла под давлением.",
            example = "יֵשׁ לִי שִׁיעוּל יָבֵשׁ כְּבָר שָׁלוֹשָׁה יָמִים.",
            exampleNative = "У меня שִׁיעוּל без мокроты уже три дня.",
        ),
        WordEntity(
            id = 102923, setId = 1029, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pharmacy", transliteration = "nazelet",
            original = "נָזֶלֶת", translation = "насморк",
            definition = "דְּלֶפֶת נוֹזֵל מֵהָאַף עֲקֶב דַּלֶּקֶת אוֹ אַלֶּרְגְּיָה.",
            definitionNative = "Течение жидкости из носа вследствие воспаления или аллергии.",
            example = "קָנִיתִי סְפְּרֵי אַף בַּגְּלַל נָזֶלֶת שֶׁלּא עוֹזֵב.",
            exampleNative = "Я купил спрей для носа из-за не проходящей נָזֶלֶת.",
        ),
        WordEntity(
            id = 102924, setId = 1029, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pharmacy", transliteration = "ke'ev garon",
            original = "כְּאֵב גָּרוֹן", translation = "боль в горле",
            definition = "כְּאֵב אוֹ גֵּרוּי בְּאֵזוֹר הַגָּרוֹן, לְעִתִּים סִימְפְּטוֹם שֶׁל זִיהוּם.",
            definitionNative = "Боль или раздражение в области горла, иногда симптом инфекции.",
            example = "יֵשׁ לִי כְּאֵב גָּרוֹן חָזָק — אֶפְשָׁר מָה לָקַחַת?",
            exampleNative = "У меня сильный כְּאֵב גָּרוֹן — что можно принять?",
        ),
        WordEntity(
            id = 102925, setId = 1029, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "pharmacy", transliteration = "sukeret",
            original = "סֻכֶּרֶת", translation = "диабет / сахарный диабет",
            definition = "מַחֲלָה כְּרוֹנִית שֶׁבָּהּ רָמַת הַסֻּכָּר בַּדָּם גְּבוֹהָה מִדַּי.",
            definitionNative = "Хроническое заболевание, при котором уровень сахара в крови слишком высок.",
            example = "לִמְטוּפָּל עִם סֻכֶּרֶת יֵשׁ צֹרֶךְ בְּבַקָּרַת סֻכָּר יוֹמִית.",
            exampleNative = "Пациенту с סֻכֶּרֶת необходим ежедневный контроль сахара.",
        ),

        // ──────────────────────────────────────────────────────
        // Set 1030 — Поиск работы (слова 21–25)
        // ──────────────────────────────────────────────────────

        WordEntity(
            id = 103021, setId = 1030, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "work", transliteration = "ishur avoda",
            original = "אִישּׁוּר עֲבוֹדָה", translation = "разрешение на работу",
            definition = "מִסְמָךְ רִשְׁמִי הַמַּרְשֶׁה לְאֶזְרָח זָר לַעֲבוֹד בְּמְדִינָה.",
            definitionNative = "Официальный документ, разрешающий иностранному гражданину работать в стране.",
            example = "עוֹלִים חֲדָשִׁים מְקַבְּלִים אִישּׁוּר עֲבוֹדָה בְּאוֹטוֹמָטִי.",
            exampleNative = "Новые репатрианты получают אִישּׁוּר עֲבוֹדָה автоматически.",
        ),
        WordEntity(
            id = 103022, setId = 1030, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "work", transliteration = "re'ayon avoda",
            original = "רֵאָיוֹן עֲבוֹדָה", translation = "собеседование",
            definition = "פְּגִישָׁה בֵּין מוֹעָמֵד לַעֲבוֹדָה לְבֵין מְנַהֵל לִשְׁם הַעֲרָכָה.",
            definitionNative = "Встреча между кандидатом на работу и руководителем для оценки.",
            example = "הוּזְמַנְתִּי לְרֵאָיוֹן עֲבוֹדָה בַּחֶבְרָה לְמָחָר בְּ-10.",
            exampleNative = "Меня пригласили на רֵאָיוֹן עֲבוֹדָה в компании завтра в 10.",
        ),
        WordEntity(
            id = 103023, setId = 1030, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "work", transliteration = "miktsoa",
            original = "מִקְצוֹעַ", translation = "профессия / специальность",
            definition = "תְּחוּם הָעֲבוֹדָה שֶׁאָדָם מֻמְחֶה בּוֹ וְעוֹסֵק בּוֹ.",
            definitionNative = "Область работы, в которой человек является специалистом.",
            example = "מִקְצוֹעִי הוּא מְהַנְדֵּס תוֹכְנָה.",
            exampleNative = "Мой מִקְצוֹעַ — инженер-программист.",
        ),
        WordEntity(
            id = 103024, setId = 1030, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "work", transliteration = "nesiyon",
            original = "נֵסְיוֹן", translation = "опыт (работы)",
            definition = "הַמַּה שֶׁרָכַשׁ אָדָם בְּשֶׁטַח הָעֲבוֹדָה לְאֹרֶךְ שָׁנִים.",
            definitionNative = "То, что человек приобрёл в профессиональной сфере за годы работы.",
            example = "יֵשׁ לִי חָמֵשׁ שָׁנִים נֵסְיוֹן בְּפִּתּוּחַ תוֹכְנָה.",
            exampleNative = "У меня пять лет נֵסְיוֹן в разработке программного обеспечения.",
        ),
        WordEntity(
            id = 103025, setId = 1030, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "work", transliteration = "akhrai",
            original = "אַחְרָאִי", translation = "ответственный (за что-то) / дежурный",
            definition = "מִי שֶׁמְּחוּיָּב לְטִיפּוּל בְּתַפְקִיד אוֹ בְּמִשִּׂימָה מְסוּיֶּמֶת.",
            definitionNative = "Тот, кто обязан заботиться об определённой должности или задаче.",
            example = "מִי אַחְרָאִי עַל קֶשֶׁר עִם לָקוֹחוֹת בַּחֶבְרָה שֶׁלְּכֶם?",
            exampleNative = "Кто у вас אַחְרָאִי за контакт с клиентами?",
        ),

        // ──────────────────────────────────────────────────────
        // Set 1031 — Детский сад и школа (слова 21–25)
        // ──────────────────────────────────────────────────────

        WordEntity(
            id = 103121, setId = 1031, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "school", transliteration = "mora",
            original = "מוֹרָה", translation = "учительница",
            definition = "אִשָּׁה הַמְּלַמֶּדֶת תַּלְמִידִים בְּבֵית סֵפֶר.",
            definitionNative = "Женщина, обучающая учеников в школе.",
            example = "הַמּוֹרָה שֶׁל הַכִּתָּה שֶׁלִּי מְלַמֶּדֶת מַתְמָטִיקָה.",
            exampleNative = "מוֹרָה нашего класса преподаёт математику.",
        ),
        WordEntity(
            id = 103122, setId = 1031, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "school", transliteration = "khadar kita",
            original = "חֲדַר כִּיתָּה", translation = "классная комната",
            definition = "הַחֶדֶר שֶׁבּוֹ מִתְקַיְּמִים שִׁיעוּרִים בְּבֵית סֵפֶר.",
            definitionNative = "Комната, в которой проходят уроки в школе.",
            example = "כָּל חֲדַר כִּיתָּה מְצוּיָּד בְּלוּחַ חָכָם.",
            exampleNative = "Каждый חֲדַר כִּיתָּה оснащён умной доской.",
        ),
        WordEntity(
            id = 103123, setId = 1031, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "school", transliteration = "semester",
            original = "סֶמֶסְטֶר", translation = "семестр",
            definition = "מֶחֱצִית שֶׁל שָׁנַת הַלִּימּוּדִים בְּמוֹסָד אָקָדֵמִי.",
            definitionNative = "Половина учебного года в академическом заведении.",
            example = "הַסֶּמֶסְטֶר הָרִאשׁוֹן מַתְחִיל בְּאוֹקְטוֹבֶּר.",
            exampleNative = "Первый סֶמֶסְטֶר начинается в октябре.",
        ),
        WordEntity(
            id = 103124, setId = 1031, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "school", transliteration = "te'uda",
            original = "תְּעוּדָה", translation = "табель / свидетельство",
            definition = "מִסְמָךְ רִשְׁמִי הַמְּעִיד עַל לִימּוּדִים, הִישֵׂגִים אוֹ כִּשּׁוּרִים.",
            definitionNative = "Официальный документ, подтверждающий учёбу, достижения или квалификацию.",
            example = "קִיבַּלְנוּ אֶת תְּעוּדוֹת הַסּוֹף שָׁנָה בְּטֶקֶס.",
            exampleNative = "Мы получили годовые תְּעוּדָה на торжественной церемонии.",
        ),
        WordEntity(
            id = 103125, setId = 1031, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "school", transliteration = "iparon",
            original = "עִפָּרוֹן", translation = "карандаш",
            definition = "כְּלִי כְּתִיבָה עַם לַיְב גְּרָפִיט לִשְׁרִיטַת מִשְׁטָחִים.",
            definitionNative = "Инструмент для письма с графитовым стержнем для нанесения на поверхность.",
            example = "הַמּוֹרָה בִּקְּשָׁה לִכְתּוֹב בְּעִפָּרוֹן, לֹא בְּעֵט.",
            exampleNative = "Учительница попросила писать עִפָּרוֹן, а не ручкой.",
        ),

        // ──────────────────────────────────────────────────────
        // Set 1032 — Почта и посылки (слова 21–25)
        // ──────────────────────────────────────────────────────

        WordEntity(
            id = 103221, setId = 1032, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "post", transliteration = "bituakh mishlokh",
            original = "בִּיטּוּחַ מִשְׁלוֹחַ", translation = "страхование посылки",
            definition = "כִּיסּוּי בִּיטּוּחִי לְנֵזֶק אוֹ אֲבֵדָה שֶׁל חֲבִילָה בְּמֶשֶׁךְ הַמִּשְׁלוֹחַ.",
            definitionNative = "Страховое покрытие на случай повреждения или потери посылки при доставке.",
            example = "שִׁלַּחְתִּי אֶת הַחֲבִילָה עִם בִּיטּוּחַ מִשְׁלוֹחַ כִּי הִיא יְקָרָה.",
            exampleNative = "Я отправил посылку с בִּיטּוּחַ מִשְׁלוֹחַ, потому что она дорогая.",
        ),
        WordEntity(
            id = 103222, setId = 1032, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "post", transliteration = "mishlokh mahir",
            original = "מִשְׁלוֹחַ מְהִיר", translation = "экспресс-доставка",
            definition = "שֵׁרוּת מִשְׁלוֹחַ בִּזְמַן קָצָר מֵהַרָּגִיל, לְרוֹב בְּמְחִיר גָּבֹהַּ יוֹתֵר.",
            definitionNative = "Служба доставки за более короткое время, обычно по более высокой цене.",
            example = "בָּחַרְתִּי בְּמִשְׁלוֹחַ מְהִיר כְּדֵי שֶׁהַחֲבִילָה תַּגִּיעַ מָחָר.",
            exampleNative = "Я выбрал מִשְׁלוֹחַ מְהִיר, чтобы посылка пришла завтра.",
        ),
        WordEntity(
            id = 103223, setId = 1032, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "post", transliteration = "madbeka",
            original = "מַדְבֵּקָה", translation = "этикетка / наклейка",
            definition = "פֶּתֶק דָּבִיק שֶׁמָּדְבִּיקִים עַל חֲבִילוֹת עִם פְּרָטִים אוֹ לְעִיטּוּר.",
            definitionNative = "Клейкий ярлычок, наклеиваемый на посылки с данными или для украшения.",
            example = "הַמַּדְבֵּקָה עַל הַחֲבִילָה מְכִילָה אֶת שֵׁם הַמְּקַבֵּל וְאֶת הַכְּתוֹבֶת.",
            exampleNative = "מַדְבֵּקָה на посылке содержит имя получателя и адрес.",
        ),
        WordEntity(
            id = 103224, setId = 1032, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "post", transliteration = "shover",
            original = "שׁוֹבֵר", translation = "квитанция для получения / ваучер",
            definition = "תְּלוּשׁ הַמַּזְכֶּה בְּקַבָּלַת חֲבִילָה אוֹ שֵׁרוּת.",
            definitionNative = "Отрывной талон, дающий право на получение посылки или услуги.",
            example = "קִיבַּלְתִּי שׁוֹבֵר בְּדֹאַר לְמַשִּׁיכַת הַחֲבִילָה מֵהַסְּנִיף.",
            exampleNative = "Я получил שׁוֹבֵר по почте для получения посылки в отделении.",
        ),
        WordEntity(
            id = 103225, setId = 1032, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "post", transliteration = "ktovet sholelkh",
            original = "כְּתוֹבֶת שׁוֹלֵחַ", translation = "адрес отправителя",
            definition = "כְּתוֹבַת הָאָדָם שֶׁשָּׁלַח אֶת הַחֲבִילָה, הַנִּרְשֶׁמֶת עַל גַּב הַחֲבִילָה.",
            definitionNative = "Адрес человека, отправившего посылку, указываемый на обратной стороне.",
            example = "כָּתַבְתִּי אֶת כְּתוֹבֶת הַשּׁוֹלֵחַ בְּפִּנָּה הָעֶלְיוֹנָה שְׂמֹאלִית.",
            exampleNative = "Я написал כְּתוֹבֶת שׁוֹלֵחַ в верхнем левом углу.",
        ),

        // ──────────────────────────────────────────────────────
        // Set 1033 — Вождение и транспорт (слова 21–25)
        // ──────────────────────────────────────────────────────

        WordEntity(
            id = 103321, setId = 1033, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "driving", transliteration = "oto",
            original = "אוֹטוֹ", translation = "авто / машина (разг.)",
            definition = "מֶכוֹנִית — כְּלִי רֶכֶב מָנוֹעִי לִנְסִיעָה בַּכְּבִישׁ.",
            definitionNative = "Автомобиль — моторное транспортное средство для езды по дороге.",
            example = "הָאוֹטוֹ שֶׁלִּי חֲדָשׁ — קְנִיתִי אוֹתוֹ לִפְנֵי חֹדֶשׁ.",
            exampleNative = "Мой אוֹטוֹ новый — я купил его месяц назад.",
        ),
        WordEntity(
            id = 103322, setId = 1033, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "driving", transliteration = "tamrur",
            original = "תָּמרוּר", translation = "дорожный знак",
            definition = "שִׁלְטָא בְּצַד הַדֶּרֶךְ הַמּוֹרֶה לְנַהֲגִים עַל כְּלָלֵי הַנְּהִיגָה.",
            definitionNative = "Знак у дороги, указывающий водителям правила движения.",
            example = "חוֹבָה לְהִשְׁמַע לְתָמרוּרֵי הַדֶּרֶךְ.",
            exampleNative = "Обязательно подчиняться תָּמרוּר.",
        ),
        WordEntity(
            id = 103323, setId = 1033, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "driving", transliteration = "me'aber",
            original = "מְעָבֵּר", translation = "переезд / переход через путь",
            definition = "נְקוּדַת חֲצִיָּה שֶׁל כְּבִישׁ אוֹ מִסִּילַת רַכֶּבֶת.",
            definitionNative = "Точка пересечения дороги или железнодорожного пути.",
            example = "יֵשׁ מְעָבֵּר חַד-סִטְרִי בְּכְּנִיסָה לַגֶּשֶׁר.",
            exampleNative = "На въезде на мост есть односторонний מְעָבֵּר.",
        ),
        WordEntity(
            id = 103324, setId = 1033, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "driving", transliteration = "okef",
            original = "עוֹקֵף", translation = "объезд / объезжающий",
            definition = "דֶּרֶךְ חֲלוּפִית לְעֶקֶף עִיר אוֹ אֵזוֹר עִם פְּקָק.",
            definitionNative = "Альтернативная дорога в обход города или пробки.",
            example = "לָקַחְנוּ כְּבִישׁ עוֹקֵף כְּדֵי לְהִמָּנַע מֵהַפְּקָק.",
            exampleNative = "Мы взяли עוֹקֵף, чтобы избежать пробки.",
        ),
        WordEntity(
            id = 103325, setId = 1033, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "driving", transliteration = "minheret",
            original = "מִנְהֶרֶת", translation = "тоннель",
            definition = "מַעֲבָר תַּת-קַרְקָעִי לְרְכָבִים עוֹבֵר מִתַּחַת לְהַר אוֹ לַמַּיִם.",
            definitionNative = "Подземный проход для транспортных средств под горой или водой.",
            example = "הַמִּנְהֶרֶת בֵּין חֵיפָה לְנַהֲרִיָּה חוֹסֶכֶת זְמַן רַב.",
            exampleNative = "מִנְהֶרֶת между Хайфой и Нагарией экономит много времени.",
        ),

        // ──────────────────────────────────────────────────────
        // Set 1034 — Полиция и экстренные службы (слова 21–25)
        // ──────────────────────────────────────────────────────

        WordEntity(
            id = 103421, setId = 1034, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "emergency", transliteration = "konen",
            original = "כּוֹנֵן", translation = "дежурный (экстренный) / готовый к вызову",
            definition = "מִי שֶׁנִּמְצָא בְּכּוֹנְנוּת וְזָמִין לְטִיפּוּל בְּאֵרוּעֵי חֵרוּם.",
            definitionNative = "Тот, кто находится в дежурстве и готов реагировать на чрезвычайные события.",
            example = "הַמֵּצָב מְחַיֵּב כּוֹנְנוּת מְלֵאָה שֶׁל כָּל הַכּוֹחוֹת.",
            exampleNative = "Ситуация требует полной כּוֹנֵן всех сил.",
        ),
        WordEntity(
            id = 103422, setId = 1034, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "emergency", transliteration = "pig'ua",
            original = "פִּגּוּעַ", translation = "теракт / нападение / инцидент",
            definition = "תְּקִיפָה מְכֻוֶּנֶת שֶׁגּוֹרֶמֶת נֵזֶק גּוּפָנִי אוֹ נַפְשִׁי לְאֲנָשִׁים.",
            definitionNative = "Преднамеренное нападение, причиняющее физический или психологический вред людям.",
            example = "הַמִּשְׁטָרָה מִיהֲרָה לַזִּירָה לְאַחַר הַפִּגּוּעַ.",
            exampleNative = "Полиция срочно прибыла на место פִּגּוּעַ.",
        ),
        WordEntity(
            id = 103423, setId = 1034, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "emergency", transliteration = "atsur",
            original = "עֲצוּר", translation = "задержанный / арестованный",
            definition = "אָדָם הַמּוּחְזָק בְּמַעֲצָר עַל יְדֵי הַמִּשְׁטָרָה.",
            definitionNative = "Человек, находящийся под стражей полиции.",
            example = "הָעֲצוּר הוּבָא לְחֶדֶר הַחֲקִירָה לְשִׂיחָה.",
            exampleNative = "עֲצוּר был доставлен в комнату допроса для беседы.",
        ),
        WordEntity(
            id = 103424, setId = 1034, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "emergency", transliteration = "ed re'iya",
            original = "עֵד רְאִיָּה", translation = "очевидец / свидетель-очевидец",
            definition = "מִי שֶׁרָאָה בְּעֵינָיו אֶת הָאֵירוּעַ בְּעֵת הִתְרַחֲשׁוּתוֹ.",
            definitionNative = "Тот, кто лично видел своими глазами событие в момент его происшествия.",
            example = "עֵד רְאִיָּה מָסַר לַמִּשְׁטָרָה פִּרְטִים עַל הַתּוֹקֵף.",
            exampleNative = "עֵד רְאִיָּה передал полиции подробности о нападавшем.",
        ),
        WordEntity(
            id = 103425, setId = 1034, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "emergency", transliteration = "rekhev herum",
            original = "רֶכֶב חֵרוּם", translation = "машина экстренных служб",
            definition = "כְּלִי רֶכֶב שֶׁל הַמִּשְׁטָרָה, אַמְבּוּלַנְס אוֹ כַּבָּאִים הָנָּוֵעַ בְּמָהִירוּת לִזִּירָה.",
            definitionNative = "Автомобиль полиции, скорой помощи или пожарных, мчащийся на место.",
            example = "שְׁמַעְתִּי אֶת צוֹפַר רֶכֶב הַחֵרוּם וְפָּנִיתִי לַיָּמִין.",
            exampleNative = "Я услышал сирену רֶכֶב חֵרוּם и принял вправо.",
        ),

        // ──────────────────────────────────────────────────────
        // Set 1035 — Шаббат и праздники (слова 21–25)
        // ──────────────────────────────────────────────────────

        WordEntity(
            id = 103521, setId = 1035, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holidays", transliteration = "motsa'e shabbat",
            original = "מוֹצָאֵי שַׁבָּת", translation = "исход субботы / субботний вечер",
            definition = "הַזְּמַן לְאַחַר שְׁקִיעַת הַחַמָּה בְּמוֹצָאֵי שַׁבָּת כְּשֶׁמְּסַיְּמִים אֶת הַשַּׁבָּת.",
            definitionNative = "Время после захода солнца в субботу вечером, когда Шаббат заканчивается.",
            example = "בְּמוֹצָאֵי שַׁבָּת פּוֹתְחִים אֶת הַחֲנֻיּוֹת וְהַמִּסְעָדוֹת.",
            exampleNative = "В מוֹצָאֵי שַׁבָּת открываются магазины и рестораны.",
        ),
        WordEntity(
            id = 103522, setId = 1035, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holidays", transliteration = "tfilа",
            original = "תְּפִלָּה", translation = "молитва",
            definition = "פְּנִיָּה לֵאלֹהִים בְּבַקָּשָׁה, הוֹדָיָה אוֹ שֶׁבַח.",
            definitionNative = "Обращение к Богу с просьбой, благодарностью или хвалой.",
            example = "בְּשַׁבָּת מִשְׁתַּתְּפִים בִּתְפִלַּת הַבֹּקֶר בְּבֵית הַכְּנֶסֶת.",
            exampleNative = "В субботу участвуют в утренней תְּפִלָּה в синагоге.",
        ),
        WordEntity(
            id = 103523, setId = 1035, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holidays", transliteration = "erev khag",
            original = "עֵרֶב חַג", translation = "канун праздника",
            definition = "הַלַּיְלָה לִפְנֵי הַחַג שֶׁבּוֹ מְכִינִים אֶת הַחַג.",
            definitionNative = "Ночь перед праздником, когда готовятся к нему.",
            example = "בְּעֵרֶב חַג כָּל הַמִּשְׁפָּחָה עוֹזֶרֶת לְהָכִין אֶת הַסְּעוּדָה.",
            exampleNative = "В עֵרֶב חַג вся семья помогает готовить праздничный ужин.",
        ),
        WordEntity(
            id = 103524, setId = 1035, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holidays", transliteration = "minhag",
            original = "מִנְהַג", translation = "традиция / обычай",
            definition = "נוֹהַג מְקֻבָּל הַמֻּעְבָּר מִדּוֹר לְדוֹר בְּקֶרֶב עֵדָה אוֹ מִשְׁפָּחָה.",
            definitionNative = "Принятый обычай, передаваемый из поколения в поколение в общине или семье.",
            example = "מִנְהַג הַמִּשְׁפָּחָה הוּא לֶאֱכֹל דְּבַשׁ בְּרֹאשׁ הַשָּׁנָה.",
            exampleNative = "מִנְהַג нашей семьи — есть мёд на Рош Ашана.",
        ),
        WordEntity(
            id = 103525, setId = 1035, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holidays", transliteration = "mezuza",
            original = "מְזוּזָה", translation = "мезуза",
            definition = "קְלַף קָדוֹשׁ בְּנַרְתִּיק הַמּוּצָמָד לְמְזוּזַת הַדֶּלֶת כְּסִימָן יְהוּדִי.",
            definitionNative = "Священный свиток в футляре, прикреплённый к косяку двери как еврейский символ.",
            example = "בְּכָל כְּנִיסָה לְבַיִת יְהוּדִי יֵשׁ מְזוּזָה בַּמְּזוּזָה הַיְּמִינִית.",
            exampleNative = "У каждого входа в еврейский дом есть מְזוּזָה на правом косяке.",
        ),

        // ──────────────────────────────────────────────────────
        // Set 1036 — Налоги и финансы (слова 21–25)
        // ──────────────────────────────────────────────────────

        WordEntity(
            id = 103621, setId = 1036, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "finance", transliteration = "hon atsmi",
            original = "הוֹן עַצְמִי", translation = "собственный капитал",
            definition = "שֶׁהֶפְרֵשׁ בֵּין נְכָסֵי הָעֵסֶק לְהִתְחַיְּבוּיּוֹתָיו.",
            definitionNative = "Разница между активами предприятия и его обязательствами.",
            example = "הוֹן עַצְמִי חָיוּב הוּא סִימָן לְחֶבְרָה יְצֻיֶּבֶת.",
            exampleNative = "Положительный הוֹן עַצְמִי — признак стабильной компании.",
        ),
        WordEntity(
            id = 103622, setId = 1036, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "finance", transliteration = "mas rekhush",
            original = "מַס רְכוּשׁ", translation = "налог на имущество",
            definition = "מַס הַמּוּטָל עַל בְּעָלֵי נְכָסִים בְּהִתְאַם לְשׁוֹוְיָם.",
            definitionNative = "Налог, взимаемый с владельцев имущества пропорционально его стоимости.",
            example = "מַס רְכוּשׁ מְשׁוּלָּם לָרָשׁוּת הַמְּקוֹמִית פַּעֲמַיִם בַּשָּׁנָה.",
            exampleNative = "מַס רְכוּשׁ платится в местный орган власти два раза в год.",
        ),
        WordEntity(
            id = 103623, setId = 1036, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "finance", transliteration = "hotsa'a mukeret",
            original = "הוֹצָאָה מוּכֶּרֶת", translation = "признанный расход (налоговый вычет)",
            definition = "הוֹצָאָה עֵסְקִית הַמּוּכָּרֶת עַל יְדֵי רָשׁוּת הַמִּסִּים לְהַפְחָתַת הַמַּס.",
            definitionNative = "Деловой расход, признанный налоговым органом для уменьшения налога.",
            example = "רְכִישַׁת מַחְשֵׁב לַעֲבוֹדָה הִיא הוֹצָאָה מוּכֶּרֶת.",
            exampleNative = "Покупка компьютера для работы — это הוֹצָאָה מוּכֶּרֶת.",
        ),
        WordEntity(
            id = 103624, setId = 1036, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "finance", transliteration = "poked mas",
            original = "פּוֹקֵד מַס", translation = "налоговый инспектор",
            definition = "פָּקִיד רָשׁוּת הַמִּסִּים הַבּוֹדֵק וּמְחַשֵּׁב מַסִּים שֶׁל יְחִידִים וְעֵסְקִים.",
            definitionNative = "Сотрудник налоговой службы, проверяющий и исчисляющий налоги физических лиц и предприятий.",
            example = "פָּגַשְׁתִּי אֶת פּוֹקֵד הַמַּס שֶׁלִּי לְהַגָּשַׁת הַדּוּחַ הַשָּׁנָתִי.",
            exampleNative = "Я встретился со своим פּוֹקֵד מַס для подачи годового отчёта.",
        ),
        WordEntity(
            id = 103625, setId = 1036, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "finance", transliteration = "shnat mas",
            original = "שְׁנַת מַס", translation = "налоговый год",
            definition = "תְּקוּפַת 12 חֳדָשִׁים שֶׁלְּגַבֵּיהָ מְחַשְּׁבִים אֶת הַמַּס.",
            definitionNative = "Период в 12 месяцев, за который исчисляется налог.",
            example = "שְׁנַת הַמַּס בְּיִשְׂרָאֵל מַתְחִילָה בְּ-1 בְּיָנְוָר.",
            exampleNative = "שְׁנַת מַס в Израиле начинается 1 января.",
        ),

        // ──────────────────────────────────────────────────────
        // Set 1037 — Природа и климат Израиля (слова 21–25)
        // ──────────────────────────────────────────────────────

        WordEntity(
            id = 103721, setId = 1037, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "nature", transliteration = "karmel",
            original = "כַּרְמֶל", translation = "Кармель (горный массив)",
            definition = "רֶכֶס הָרִים בְּחֵיפָה וּסְבִיבוֹתֶיהָ, מְפֹרְסָם בְּיַעֲרוֹת וּנְחָלִים.",
            definitionNative = "Горный хребет в Хайфе и её окрестностях, известный лесами и ручьями.",
            example = "טִיַּלְנוּ בִּשְׁבִיל נָחָשׁ בְּרֶכֶס הַכַּרְמֶל.",
            exampleNative = "Мы прошли по тропе Нахаш на хребте כַּרְמֶל.",
        ),
        WordEntity(
            id = 103722, setId = 1037, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "nature", transliteration = "khermon",
            original = "חֶרְמוֹן", translation = "Хермон (гора / горнолыжный курорт)",
            definition = "הָהָר הַגָּבֹהַּ בְּיוֹתֵר בְּיִשְׂרָאֵל בְּצָפוֹן הַגּוֹלָן, עִם אֲזוֹר סְקִי בַּחֹרֶף.",
            definitionNative = "Самая высокая гора в Израиле на севере Голан, с горнолыжным районом зимой.",
            example = "בַּחֹרֶף עוֹלִים לַחֶרְמוֹן לְגְלִישָׁה עַל הַשֶּׁלֶג.",
            exampleNative = "Зимой едут на חֶרְמוֹן кататься на лыжах.",
        ),
        WordEntity(
            id = 103723, setId = 1037, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "nature", transliteration = "perekh",
            original = "פֶּרֶח", translation = "цветок",
            definition = "חֵלֶק הַצֶּמַח הַמְּיוּעָד לְרִבִּיָּה, לְרוֹב יָפֶה וְרֵיחָנִי.",
            definitionNative = "Часть растения, предназначенная для размножения, обычно красивая и ароматная.",
            example = "בָּאָבִיב פּוֹרְחִים פִּרְחֵי הַכַּלָּנִית הָאֲדֻמִּים בְּכָל הָאָרֶץ.",
            exampleNative = "Весной по всей стране цветут красные פֶּרֶח — каланиты.",
        ),
        WordEntity(
            id = 103724, setId = 1037, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "nature", transliteration = "ets",
            original = "עֵץ", translation = "дерево",
            definition = "צֶמַח רַב-שְׁנָתִי עִם גֶּזַע קָשֶׁה, עֲנָפִים וְעָלִים.",
            definitionNative = "Многолетнее растение с твёрдым стволом, ветвями и листьями.",
            example = "עֵץ הַזַּיִת הוּא סֵמֶל שֶׁל יִשְׂרָאֵל וְהַשָּׁלוֹם.",
            exampleNative = "עֵץ маслины — символ Израиля и мира.",
        ),
        WordEntity(
            id = 103725, setId = 1037, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "nature", transliteration = "tsipor",
            original = "צִפּוֹר", translation = "птица",
            definition = "חַיָּה בַּעֲלַת כְּנָפַיִם וְנוֹצוֹת הַמְּסוּגֶּלֶת לְעוֹף.",
            definitionNative = "Животное с крыльями и перьями, способное летать.",
            example = "יִשְׂרָאֵל נְמֻצֶּאֶת עַל נָתִיב הַגֵּירָה שֶׁל מֵאוֹת מִינֵי צִפּוֹרִים.",
            exampleNative = "Израиль расположен на пути миграции сотен видов צִפּוֹר.",
        ),
    )
}
