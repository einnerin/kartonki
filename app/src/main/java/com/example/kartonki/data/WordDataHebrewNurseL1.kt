package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic «Медсестра», level 1 (A1-A2).
 * Один сет × 25 слов. setId = 1719.
 *
 *  - 15 COMMON + 10 UNCOMMON (2 смежных уровня).
 *  - 5 семантических групп:
 *      nurse_ward_room        (5) — палата и обстановка
 *      nurse_patient_clothing (4) — одежда пациента в больнице
 *      nurse_measurement      (5) — приборы измерения
 *      nurse_medications      (7) — формы лекарств и расходники
 *      nurse_routine          (4) — рабочая рутина медсестры
 *
 *  - Слова не пересекаются с уже существующими сетами темы «Медсестра»
 *    (1393, 1394, 1395, 1396, 1397). Тема граничит с «Медицина» и «Врач»;
 *    встречающиеся в них слова допустимы (политика дублей между разными темами).
 */
object WordDataHebrewNurseL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1719, languagePair = "he-ru", orderIndex = 1719,
            name = "Медсестра",
            description = "Палата, пациент, измерение, базовые лекарства",
            topic = "Медсестра", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1719 — Медсестра: основы (COMMON + UNCOMMON, A1–A2)
        // 5 групп, 25 слов
        // ══════════════════════════════════════════════════════════════════════

        // ─── nurse_ward_room (5) — палата и обстановка ───────────────────────
        WordEntity(
            id = 171901, setId = 1719, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "nurse_ward_room",
            original = "חַדַר חוֹלִים", translation = "палата",
            transliteration = "khadar kholim",
            definition = "חֶדֶר בְּבֵית חוֹלִים שֶׁבּוֹ שׁוֹכְבִים מְטוּפָּלִים בִּזְמַן הָאִשְׁפּוּז.",
            definitionNative = "Комната в больнице, где лежат больные во время лечения.",
            example = "חַדַר חוֹלִים מַכִּיל אַרְבַּע מִטּוֹת וְאַרְבָּעָה אֲרוֹנוֹת.",
            exampleNative = "В חַדַר חוֹלִים помещаются четыре койки и четыре шкафа.",
            fillInBlankExclusions = listOf(171902L, 171903L, 171904L, 171905L)),
        WordEntity(
            id = 171902, setId = 1719, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "nurse_ward_room",
            original = "מִיטַת בֵּית חוֹלִים", translation = "больничная койка",
            transliteration = "mitat beit kholim",
            definition = "מִשְׁכָּב מְיֻחָד עַל גַּלְגַּלִּים שֶׁאֶפְשָׁר לְהָרִים אוֹ לְהוֹרִיד בְּחֵלֶק.",
            definitionNative = "Особое спальное место на колёсах, где можно поднять или опустить часть.",
            example = "הִיא שָׁכְבָה עַל מִיטַת בֵּית חוֹלִים לְיַד הַחַלּוֹן.",
            exampleNative = "Она лежала на מִיטַת בֵּית חוֹלִים возле окна.",
            fillInBlankExclusions = listOf(171901L, 171903L, 171904L, 171905L)),
        WordEntity(
            id = 171903, setId = 1719, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "nurse_ward_room",
            original = "כּוֹנָנִית", translation = "тумбочка",
            transliteration = "konanit",
            definition = "רָהִיט קָטָן לְיַד הַמִּטָּה לִשְׁמִירַת חֲפָצִים אִישִׁיִּים.",
            definitionNative = "Маленький предмет мебели у кровати — для личных вещей.",
            example = "הוּא הִנִּיחַ אֶת הַמִּשְׁקָפַיִם עַל הַכּוֹנָנִית.",
            exampleNative = "Он положил очки на כּוֹנָנִית.",
            fillInBlankExclusions = listOf(171901L, 171902L, 171904L, 171905L)),
        WordEntity(
            id = 171904, setId = 1719, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "nurse_ward_room",
            original = "וִילוֹן הַפְרָדָה", translation = "разделительная занавеска",
            transliteration = "vilon hafrada",
            definition = "בַּד שֶׁמּוֹשְׁכִים בֵּין מִטּוֹת כְּדֵי לִשְׁמֹר עַל פְּרָטִיּוּת בִּזְמַן בְּדִיקָה.",
            definitionNative = "Ткань, которой загораживают койки ради приватности при осмотре.",
            example = "הָאָחוֹת מָשְׁכָה אֶת וִילוֹן הַהַפְרָדָה לִפְנֵי הַזְּרִיקָה.",
            exampleNative = "Сестра задёрнула וִילוֹן הַפְרָדָה перед уколом.",
            fillInBlankExclusions = listOf(171901L, 171902L, 171903L, 171905L)),
        WordEntity(
            id = 171905, setId = 1719, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "nurse_ward_room",
            original = "כַּפְתּוֹר אַזְעָקָה", translation = "кнопка вызова медсестры",
            transliteration = "kaftor az'aka",
            definition = "כַּפְתּוֹר לְיַד הַמִּטָּה שֶׁבּוֹ קוֹרְאִים לְצֶוֶות הָרְפוּאִי בְּעֵת צֹרֶךְ.",
            definitionNative = "Кнопка возле кровати, которой зовут медицинский персонал при нужде.",
            example = "הִיא לָחֲצָה עַל כַּפְתּוֹר אַזְעָקָה כְּשֶׁכָּאַב לָהּ.",
            exampleNative = "Она нажала на כַּפְתּוֹר אַזְעָקָה, когда стало больно.",
            fillInBlankExclusions = listOf(171901L, 171902L, 171903L, 171904L)),

        // ─── nurse_patient_clothing (4) — одежда пациента ────────────────────
        WordEntity(
            id = 171906, setId = 1719, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "nurse_patient_clothing",
            original = "פִּיגָ'מָה", translation = "пижама",
            transliteration = "pijama",
            definition = "בִּגְדֵי שֵׁנָה נוֹחִים שֶׁלּוֹבְשִׁים בַּלַּיְלָה אוֹ בִּזְמַן מְנוּחָה.",
            definitionNative = "Удобная одежда для сна — на ночь или для отдыха в постели.",
            example = "הִיא לָבְשָׁה פִּיגָ'מָה רַכָּה לִפְנֵי שֶׁנִּרְדְּמָה.",
            exampleNative = "Она надела мягкую פִּיגָ'מָה, прежде чем уснуть.",
            fillInBlankExclusions = listOf(171907L, 171908L, 171909L)),
        WordEntity(
            id = 171907, setId = 1719, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "nurse_patient_clothing",
            original = "נַעֲלֵי בַּיִת", translation = "тапочки",
            transliteration = "na'alei bayit",
            definition = "נְעָלַיִם רַכּוֹת וְקַלּוֹת שֶׁלּוֹבְשִׁים בְּתוֹךְ הַחֶדֶר.",
            definitionNative = "Мягкая лёгкая обувь, в которой ходят дома или в палате.",
            example = "הוּא נָעַל נַעֲלֵי בַּיִת חַמּוֹת וְהָלַךְ לַשֵּׁרוּתִים.",
            exampleNative = "Он надел тёплые נַעֲלֵי בַּיִת и пошёл в туалет.",
            fillInBlankExclusions = listOf(171906L, 171908L, 171909L)),
        WordEntity(
            id = 171908, setId = 1719, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "nurse_patient_clothing",
            original = "חֻלְצָה רְפוּאִית", translation = "больничная рубашка",
            transliteration = "khultsa refu'it",
            definition = "בֶּגֶד פָּשׁוּט לִמְטוּפָּלִים שֶׁנִּפְתָּח מֵאָחוֹר וְקַל לְהַחְלִיף.",
            definitionNative = "Простой наряд для больных: открывается сзади, легко снять.",
            example = "אַחֲרֵי הַנִּתּוּחַ נָתְנוּ לוֹ חֻלְצָה רְפוּאִית לְבָנָה.",
            exampleNative = "После операции ему дали белую חֻלְצָה רְפוּאִית.",
            fillInBlankExclusions = listOf(171906L, 171907L, 171909L)),
        WordEntity(
            id = 171909, setId = 1719, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "nurse_patient_clothing",
            original = "כְּתֹנֶת לַיְלָה", translation = "ночная сорочка",
            transliteration = "ktonet layla",
            definition = "בֶּגֶד אָרֹךְ וְרָפוּי לְשֵׁנָה, בְּעִקָּר לְנָשִׁים אוֹ קְשִׁישִׁים.",
            definitionNative = "Длинная свободная одежда для сна — чаще для женщин и пожилых.",
            example = "סָבְתָא הֶחְלִיפָה לְכְּתֹנֶת לַיְלָה כְּחֻלָּה.",
            exampleNative = "Бабушка переоделась в синюю כְּתֹנֶת לַיְלָה.",
            fillInBlankExclusions = listOf(171906L, 171907L, 171908L)),

        // ─── nurse_measurement (5) — приборы измерения ───────────────────────
        WordEntity(
            id = 171910, setId = 1719, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "nurse_measurement",
            original = "מַד-לַחַץ-דָּם", translation = "тонометр",
            transliteration = "mad-lakhats-dam",
            definition = "מַכְשִׁיר עִם שַׁרְווּלִית שֶׁבּוֹדֵק כַּמָּה חָזָק זוֹרֵם הַדָּם בָּעוֹרְקִים.",
            definitionNative = "Прибор с манжетой, проверяющий, как сильно течёт кровь по сосудам.",
            example = "הָאָחוֹת חִבְּרָה אֶת הַמַּד-לַחַץ-דָּם לִזְרוֹעַ הַחוֹלֶה.",
            exampleNative = "Сестра приладила מַד-לַחַץ-דָּם к руке больного.",
            fillInBlankExclusions = listOf(171911L, 171912L, 171913L, 171914L)),
        WordEntity(
            id = 171911, setId = 1719, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "nurse_measurement",
            original = "מַשְׁקָל רְפוּאִי", translation = "медицинские весы",
            transliteration = "mishkal refu'i",
            definition = "מַכְשִׁיר שֶׁעוֹמְדִים עָלָיו כְּדֵי לָדַעַת כַּמָּה קִילוֹגְרָמִים אַתָּה.",
            definitionNative = "Прибор, на который встают, чтобы узнать, сколько килограммов ты весишь.",
            example = "הוּא עָלָה עַל הַמַּשְׁקָל רְפוּאִי לִפְנֵי הַבְּדִיקָה.",
            exampleNative = "Он встал на מַשְׁקָל רְפוּאִי перед осмотром.",
            fillInBlankExclusions = listOf(171910L, 171912L, 171913L, 171914L)),
        WordEntity(
            id = 171912, setId = 1719, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "nurse_measurement",
            original = "מַד-סֻכָּר", translation = "глюкометр",
            transliteration = "mad-sukar",
            definition = "מַכְשִׁיר קָטָן עִם מַחַט שֶׁבּוֹדֵק כַּמָּה סֻכָּר יֵשׁ בְּטִפַּת דָּם.",
            definitionNative = "Маленький прибор с иглой: проверяет уровень сахара в капле крови.",
            example = "סָבָּא מוֹדֵד אֶת הַסֻּכָּר עִם מַד-סֻכָּר כָּל בֹּקֶר.",
            exampleNative = "Дедушка проверяет сахар через מַד-סֻכָּר каждое утро.",
            fillInBlankExclusions = listOf(171910L, 171911L, 171913L, 171914L)),
        WordEntity(
            id = 171913, setId = 1719, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "nurse_measurement",
            original = "מַד-חַמְצָן", translation = "пульсоксиметр (на палец)",
            transliteration = "mad-khamtsan",
            definition = "מַכְשִׁיר קָטָן שֶׁשָּׂמִים עַל הָאֶצְבַּע לִבְדֹּק רַעֲנַנּוּת בַּדָּם.",
            definitionNative = "Маленький прибор на палец, проверяющий, хватает ли воздуха в крови.",
            example = "הָאָחוֹת חִבְּרָה מַד-חַמְצָן לְאֶצְבַּע הַתִּינוֹק.",
            exampleNative = "Сестра надела מַד-חַמְצָן на палец малышу.",
            fillInBlankExclusions = listOf(171910L, 171911L, 171912L, 171914L)),
        WordEntity(
            id = 171914, setId = 1719, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "nurse_measurement",
            original = "סִימָנֵי חַיִּים", translation = "жизненные показатели",
            transliteration = "simanei khayim",
            definition = "אַרְבָּעָה נְתוּנִים בְּסִיסִיִּים שֶׁבּוֹדְקִים בְּכָל מְטוּפָּל בַּמַּחְלָקָה.",
            definitionNative = "Четыре главных показателя, что проверяют у каждого пациента.",
            example = "הַצֶּוֶת רוֹשֵׁם סִימָנֵי חַיִּים פַּעֲמַיִם בִּמְשֶׁךְ הַמִּשְׁמֶרֶת.",
            exampleNative = "Команда записывает סִימָנֵי חַיִּים дважды за смену.",
            fillInBlankExclusions = listOf(171910L, 171911L, 171912L, 171913L)),

        // ─── nurse_medications (7) — формы лекарств и расходники ─────────────
        WordEntity(
            id = 171915, setId = 1719, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "nurse_medications",
            original = "כְּמוּסָה", translation = "капсула",
            transliteration = "kmusa",
            definition = "צוּרַת תְּרוּפָה עֲגַלְגַּלָּה עִם קְלִפָּה רַכָּה וְאָבָק בִּפְנִים.",
            definitionNative = "Овальная форма лекарства: мягкая оболочка, а внутри порошок.",
            example = "הוּא בָּלַע כְּמוּסָה אַחַת עִם הַרְבֵּה מַיִם.",
            exampleNative = "Он проглотил одну כְּמוּסָה, запил большим стаканом воды.",
            fillInBlankExclusions = listOf(171916L, 171917L, 171918L, 171919L, 171920L, 171921L)),
        WordEntity(
            id = 171916, setId = 1719, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "nurse_medications",
            original = "סִירוֹפּ", translation = "сироп",
            transliteration = "sirop",
            definition = "תְּרוּפָה נוֹזְלִית מְתוּקָה שֶׁמַּגִּישִׁים בְּעִקָּר לִילָדִים בְּכַף.",
            definitionNative = "Сладкое жидкое лекарство, которое чаще всего дают детям с ложки.",
            example = "אִמָּא נָתְנָה לוֹ סִירוֹפּ נֶגֶד שִׁעוּל לִפְנֵי הַשֵּׁנָה.",
            exampleNative = "Мама дала ему סִירוֹפּ от кашля перед сном.",
            fillInBlankExclusions = listOf(171915L, 171917L, 171918L, 171919L, 171920L, 171921L)),
        WordEntity(
            id = 171917, setId = 1719, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "nurse_medications",
            original = "וִיטָמִין", translation = "витамин",
            transliteration = "vitamin",
            definition = "חֹמֶר חָשׁוּב לַגּוּף שֶׁאֶפְשָׁר לְקַבֵּל בְּטַבְלֵטָה אוֹ בְּפֵרוֹת.",
            definitionNative = "Полезное для тела вещество — есть в таблетке или во фруктах.",
            example = "הִיא לוֹקַחַת וִיטָמִין כָּתֹם פַּעַם בְּיוֹם בַּבֹּקֶר.",
            exampleNative = "Она пьёт оранжевый וִיטָמִין раз в день утром.",
            fillInBlankExclusions = listOf(171915L, 171916L, 171918L, 171919L, 171920L, 171921L)),
        WordEntity(
            id = 171918, setId = 1719, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "nurse_medications",
            original = "טִפּוֹת עֵינַיִם", translation = "глазные капли",
            transliteration = "tipot einayim",
            definition = "תְּרוּפָה נוֹזְלִית שֶׁמַּזְלִיפִים יָשָׁר עַל הָעַיִן הָאֲדֻמָּה אוֹ הַיְּבֵשָׁה.",
            definitionNative = "Жидкое лекарство, которое капают прямо на красный или сухой глаз.",
            example = "הָאָחוֹת הִזְלִיפָה לוֹ טִפּוֹת עֵינַיִם שָׁלֹשׁ פְּעָמִים בְּיוֹם.",
            exampleNative = "Сестра закапала ему טִפּוֹת עֵינַיִם трижды за день.",
            fillInBlankExclusions = listOf(171915L, 171916L, 171917L, 171919L, 171920L, 171921L)),
        WordEntity(
            id = 171919, setId = 1719, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "nurse_medications",
            original = "פְּלַסְטֵר", translation = "пластырь",
            transliteration = "plaster",
            definition = "פַּס דָּבִיק קָטָן שֶׁמַּדְבִּיקִים עַל פֶּצַע קָטָן כְּדֵי לְכַסּוֹתוֹ.",
            definitionNative = "Маленькая липкая полоска, которую клеят на ранку, чтобы прикрыть.",
            example = "הוּא הִדְבִּיק פְּלַסְטֵר עַל הַבֹּהֶן אַחֲרֵי הַחֲתָךְ.",
            exampleNative = "Он наклеил פְּלַסְטֵר на палец после пореза.",
            fillInBlankExclusions = listOf(171915L, 171916L, 171917L, 171918L, 171920L, 171921L)),
        WordEntity(
            id = 171920, setId = 1719, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "nurse_medications",
            original = "צֶמֶר רְפוּאִי", translation = "медицинская вата",
            transliteration = "tsemer refu'i",
            definition = "חוּטִים לְבָנִים רַכִּים שֶׁבָּהֶם מְנַגְּבִים אֶת הָעוֹר לִפְנֵי הַזְּרִיקָה.",
            definitionNative = "Мягкая белая тонкая нить, которой протирают кожу перед уколом.",
            example = "הָאָחוֹת לָקְחָה צֶמֶר רְפוּאִי וְנִגְּבָה אֶת הַזְּרוֹעַ.",
            exampleNative = "Сестра взяла צֶמֶר רְפוּאִי и протёрла руку.",
            fillInBlankExclusions = listOf(171915L, 171916L, 171917L, 171918L, 171919L, 171921L)),
        WordEntity(
            id = 171921, setId = 1719, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "nurse_medications",
            original = "מַזְרֵק חַד-פַּעֲמִי", translation = "одноразовый шприц",
            transliteration = "mazrek khad-pa'ami",
            definition = "כְּלִי דַּק עִם מַחַט שֶׁמִּשְׁתַּמְּשִׁים בּוֹ פַּעַם אַחַת וְזוֹרְקִים.",
            definitionNative = "Тонкое устройство с иглой: пользуются один раз и выкидывают.",
            example = "הָרוֹפֵא הוֹצִיא מַזְרֵק חַד-פַּעֲמִי מִתּוֹךְ עֲטִיפָה סְגוּרָה.",
            exampleNative = "Врач достал מַזְרֵק חַד-פַּעֲמִי из закрытой упаковки.",
            fillInBlankExclusions = listOf(171915L, 171916L, 171917L, 171918L, 171919L, 171920L)),

        // ─── nurse_routine (4) — рабочая рутина ──────────────────────────────
        WordEntity(
            id = 171922, setId = 1719, languagePair = "he-ru", rarity = "COMMON",
            pos = "phrase", semanticGroup = "nurse_routine",
            original = "טִפּוּל יוֹמִי", translation = "ежедневный уход",
            transliteration = "tipul yomi",
            definition = "פְּעֻלּוֹת קְבוּעוֹת שֶׁעוֹשִׂים לַחוֹלֶה בְּכָל בֹּקֶר וְעֶרֶב.",
            definitionNative = "Привычные действия, что делают больному каждое утро и вечер.",
            example = "טִפּוּל יוֹמִי מַתְחִיל בִּשְׁמוֹנֶה וְכוֹלֵל מְקַלַּחַת קָלָה.",
            exampleNative = "טִפּוּל יוֹמִי начинается в восемь и включает лёгкий душ.",
            fillInBlankExclusions = listOf(171923L, 171924L, 171925L)),
        WordEntity(
            id = 171923, setId = 1719, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "nurse_routine",
            original = "הַאֲכָלָה", translation = "кормление",
            transliteration = "ha'akhala",
            definition = "פְּעֻלָּה שֶׁבָּהּ נוֹתְנִים אֹכֶל לְמִי שֶׁאֵינוֹ יָכוֹל לֶאֱכֹל לְבַד.",
            definitionNative = "Действие, когда подают еду тому, кто сам поесть не может.",
            example = "הַאֲכָלָה שֶׁל קְשִׁישָׁה דּוֹרֶשֶׁת סַבְלָנוּת רַבָּה.",
            exampleNative = "הַאֲכָלָה пожилой женщины требует много терпения.",
            fillInBlankExclusions = listOf(171922L, 171924L, 171925L)),
        WordEntity(
            id = 171924, setId = 1719, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "nurse_routine",
            original = "סֵבֶב בֹּקֶר", translation = "утренний обход",
            transliteration = "sevev boker",
            definition = "סִיּוּר שֶׁל הַצֶּוֶת בֵּין הַמִּטּוֹת לְבָדֹּק כָּל מְטוּפָּל בַּמַּחְלָקָה.",
            definitionNative = "Прохождение команды по койкам, чтобы взглянуть на каждого больного.",
            example = "סֵבֶב בֹּקֶר מַתְחִיל מִיָּד אַחֲרֵי קַבָּלַת הַמִּשְׁמֶרֶת.",
            exampleNative = "סֵבֶב בֹּקֶר начинается сразу после приёма дежурства.",
            fillInBlankExclusions = listOf(171922L, 171923L, 171925L)),
        WordEntity(
            id = 171925, setId = 1719, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "nurse_routine",
            original = "סִיעוּד אִישִׁי", translation = "личная гигиена пациента",
            transliteration = "si'ud ishi",
            definition = "עֶזְרָה לְמִי שֶׁאֵינוֹ יָכוֹל לְהִתְקַלֵּחַ אוֹ לְהִתְלַבֵּשׁ בְּעַצְמוֹ.",
            definitionNative = "Помощь тому, кто сам не может принять душ или одеться.",
            example = "סִיעוּד אִישִׁי כּוֹלֵל גַּם הַחְלָפַת בִּגְדֵי שֵׁנָה.",
            exampleNative = "סִיעוּד אִישִׁי включает и смену одежды для сна.",
            fillInBlankExclusions = listOf(171922L, 171923L, 171924L)),
    )
}
