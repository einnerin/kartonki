package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary: Construction, level 2 (1 set, 25 words).
 * Продвинутая лексика рядового рабочего на стройке: материалы под рукой,
 * инструменты, простые операции и типичные команды бригадира.
 *
 * Set 1724 (level 2, UNCOMMON + RARE) — параллелен старому 1306 (тот же level 2,
 * но с уклоном в документацию и инженерию). Здесь — практический язык
 * рабочего: «подай молоток», «лей бетон», «выровняй угол».
 *
 * Не пересекается с уже существующими сетами темы «Строительство»
 * (1305 L1 — основы, 1306 L2 — документация и материалы, 1307 L3, 1308 L4,
 * 1309 L5, 1337 L1 — карьера/бригада).
 *
 * Распределение редкостей: 15 UNCOMMON + 10 RARE (2 смежных уровня).
 *
 * Пять подгрупп по 5 слов каждая:
 *   construction_materials     — материалы под рукой
 *   construction_tools         — инструменты рабочего
 *   construction_operations    — простые операции
 *   construction_measurements  — мерить и проверять
 *   construction_orders        — указания бригадира
 */
object WordDataHebrewConstructionL2 {

    val sets = listOf(
        WordSetEntity(
            id = 1724, languagePair = "he-ru", orderIndex = 1724,
            name = "Стройка и работа строителем",
            description = "Материалы, инструменты и команды бригадира на стройке",
            topic = "Стройка и работа строителем", level = 2,
        ),
    )

    val words = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1724 — Строительство: продвинутый рабочий (UNCOMMON + RARE, A2–B2)
        // 5 групп × 5 слов
        // ══════════════════════════════════════════════════════════════════════

        // ── construction_materials (5) — материалы под рукой ──
        WordEntity(
            id = 172401, setId = 1724, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "construction_materials", transliteration = "khol binyan",
            original = "חוֹל בִּנְיָן", translation = "строительный песок",
            definition = "חֹמֶר דַּק וְצָהֹב שֶׁמְּעָרְבִים בּוֹ מֶלֶט וּמַיִם לִיצִיקָה.",
            definitionNative = "Сыпучий жёлтый материал, который мешают с цементом и водой.",
            example = "הָעוֹבֵד הֵבִיא שַׂק חוֹל בִּנְיָן מֵהַמַּחְסָן.",
            exampleNative = "Рабочий принёс мешок חוֹל בִּנְיָן со склада.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172402L, 172403L, 172404L, 172405L)),
        WordEntity(
            id = 172402, setId = 1724, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "construction_materials", transliteration = "tit binyan",
            original = "טִיט בִּנְיָן", translation = "строительный раствор",
            definition = "תַּעֲרוֹבֶת רַכָּה שֶׁמְּחַבְּרִים בָּהּ לְבֵנִים אוֹ אֲבָנִים בַּקִּיר.",
            definitionNative = "Мягкая смесь, которой скрепляют кирпичи или камни в стене.",
            example = "הוּא מָרַח טִיט בִּנְיָן בֵּין שְׁתֵּי הַשּׁוּרוֹת.",
            exampleNative = "Он намазал טִיט בִּנְיָן между двумя рядами кирпичей.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172401L, 172403L, 172404L, 172405L)),
        WordEntity(
            id = 172403, setId = 1724, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "construction_materials", transliteration = "khatzatz",
            original = "חָצָץ", translation = "гравий, щебень",
            definition = "אֲבָנִים קְטַנּוֹת וּקְשׁוֹת שֶׁמְּפַזְּרִים מִתַּחַת לִיסוֹדוֹת.",
            definitionNative = "Мелкие твёрдые камешки, которые сыплют под фундамент.",
            example = "הַמַּשָּׂאִית פְּרְקָה עֲרֵמַת חָצָץ לְיַד הַבְּנִיָּה.",
            exampleNative = "Грузовик выгрузил кучу חָצָץ возле стройки.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172401L, 172402L, 172404L, 172405L)),
        WordEntity(
            id = 172404, setId = 1724, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "construction_materials", transliteration = "livnei silikat",
            original = "לִבְנֵי סִילִיקָט", translation = "силикатные блоки",
            definition = "בְּלוֹקִים לְבָנִים וְכְבֵדִים שֶׁבּוֹנִים מֵהֶם קִירוֹת פְּנִים.",
            definitionNative = "Белые тяжёлые блоки, из которых кладут внутренние стены.",
            example = "הוּא הֵרִים לִבְנֵי סִילִיקָט בִּזְהִירוּת לַקּוֹמָה הַשְּׁנִיָּה.",
            exampleNative = "Он осторожно поднял לִבְנֵי סִילִיקָט на второй этаж.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172401L, 172402L, 172403L, 172405L)),
        WordEntity(
            id = 172405, setId = 1724, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "construction_materials", transliteration = "ariakh",
            original = "אֲרִיחַ", translation = "плитка (керамическая)",
            definition = "לוּחַ קְטָן וְקָשֶׁה שֶׁמַּדְבִּיקִים עַל רִצְפָּה אוֹ קִיר אַמְבַּטְיָה.",
            definitionNative = "Маленькая твёрдая пластина, которую клеят на пол или на стену.",
            example = "הַבַּנַּאי הִדְבִּיק אֲרִיחַ נוֹסָף לְיַד הָאַמְבַּטְיָה.",
            exampleNative = "Каменщик приклеил ещё один אֲרִיחַ возле ванны.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172401L, 172402L, 172403L, 172404L)),

        // ── construction_tools (5) — инструменты рабочего ──
        WordEntity(
            id = 172406, setId = 1724, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "construction_tools", transliteration = "patish",
            original = "פַּטִּישׁ", translation = "молоток",
            definition = "כְּלִי יָד עִם רֹאשׁ מַתֶּכֶת לְהַכָּאַת מַסְמְרִים אוֹ שְׁבִירָה.",
            definitionNative = "Ручной инструмент с железной головкой для забивания гвоздей.",
            example = "תֵּן לִי אֶת הַפַּטִּישׁ שֶׁעַל הַשֻּׁלְחָן בְּבַקָּשָׁה.",
            exampleNative = "Дай мне פַּטִּישׁ со стола, пожалуйста.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172407L, 172408L, 172409L, 172410L)),
        WordEntity(
            id = 172407, setId = 1724, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "construction_tools", transliteration = "ma'der",
            original = "מַעְדֵּר", translation = "мотыга, кирка",
            definition = "כְּלִי עִם לָהָב רָחָב לְעִבּוּד אֲדָמָה אוֹ פִּסּוּל סַלָּעִים.",
            definitionNative = "Инструмент с широким лезвием для рыхления земли или камней.",
            example = "הַפּוֹעֵל הִכָּה בַּמַּעְדֵּר עַל אֲדָמָה יְבֵשָׁה.",
            exampleNative = "Рабочий ударил מַעְדֵּר по сухой земле.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172406L, 172408L, 172409L, 172410L)),
        WordEntity(
            id = 172408, setId = 1724, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "construction_tools", transliteration = "mritza",
            original = "מְרִיצָה", translation = "тачка",
            definition = "עֲגָלַת יָד עִם גַּלְגַּל אֶחָד לְהוֹבָלַת חֹמֶר כָּבֵד בָּאֲתָר.",
            definitionNative = "Ручная одноколёсная повозка для перевозки тяжёлых грузов.",
            example = "הוּא הֶעֱמִיס בֶּטוֹן עַל מְרִיצָה וְדָחַף קָדִימָה.",
            exampleNative = "Он погрузил бетон в מְרִיצָה и покатил вперёд.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172406L, 172407L, 172409L, 172410L)),
        WordEntity(
            id = 172409, setId = 1724, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "construction_tools", transliteration = "mavreg",
            original = "מַבְרֵג", translation = "отвёртка",
            definition = "כְּלִי דַּק שֶׁסּוֹבְבִים אִתּוֹ בָּרְגִים פְּנִימָה אוֹ הַחוּצָה.",
            definitionNative = "Тонкий инструмент, которым вкручивают и выкручивают шурупы.",
            example = "הַחַשְׁמַלַּאי שָׁלַף מַבְרֵג קָטָן מֵהַחֲגוֹרָה.",
            exampleNative = "Электрик достал маленькую מַבְרֵג из пояса.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172406L, 172407L, 172408L, 172410L)),
        WordEntity(
            id = 172410, setId = 1724, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "construction_tools", transliteration = "mekade'akh khashmali",
            original = "מְקַדֵּחַ חַשְׁמָלִי", translation = "электродрель",
            definition = "מַכְשִׁיר נַייָּד שֶׁעוֹשֶׂה חוֹרִים בְּקִיר אוֹ בְּעֵץ בְּזְרִיזוּת.",
            definitionNative = "Переносной прибор, который быстро делает дыры в стене или дереве.",
            example = "הוּא חִבֵּר אֶת הַמְּקַדֵּחַ חַשְׁמָלִי לַשֶּׁקַע בַּקִּיר.",
            exampleNative = "Он подключил מְקַדֵּחַ חַשְׁמָלִי к розетке в стене.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172406L, 172407L, 172408L, 172409L)),

        // ── construction_operations (5) — простые операции ──
        WordEntity(
            id = 172411, setId = 1724, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "construction_operations", transliteration = "lakhpor",
            original = "לַחְפֹּר", translation = "копать, рыть",
            definition = "לְהוֹצִיא אֲדָמָה מֵהַקַּרְקַע בְּעֶזְרַת מַכְשִׁיר אוֹ יָדַיִם.",
            definitionNative = "Вынимать землю из почвы — лопатой, киркой или машиной.",
            example = "הַבּוֹס בִּקֵּשׁ לַחְפֹּר בּוֹר עָמֹק לִיסוֹדוֹת.",
            exampleNative = "Бригадир попросил לַחְפֹּר глубокую яму под фундамент.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172412L, 172413L, 172414L, 172415L)),
        WordEntity(
            id = 172412, setId = 1724, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "construction_operations", transliteration = "litzok",
            original = "לִיצֹק", translation = "заливать (бетон)",
            definition = "לְשַׁפֹּךְ חֹמֶר נוֹזְלִי לַתַּבְנִית כְּדֵי שֶׁיִּתְקַשֶּׁה לְצוּרָה.",
            definitionNative = "Подавать жидкую массу в форму, чтобы она застыла в нужном виде.",
            example = "הִתְחַלְנוּ לִיצֹק בֶּטוֹן בִּשְׁבַע בַּבֹּקֶר.",
            exampleNative = "Мы начали לִיצֹק бетон в семь утра.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172411L, 172413L, 172414L, 172415L)),
        WordEntity(
            id = 172413, setId = 1724, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "construction_operations", transliteration = "litzboa",
            original = "לִצְבֹּעַ", translation = "красить",
            definition = "לְכַסּוֹת קִיר אוֹ עֵץ בְּשִׁכְבָה צִבְעוֹנִית בְּעֶזְרַת מִבְרֶשֶׁת.",
            definitionNative = "Покрывать стену или дерево цветным слоем при помощи кисти.",
            example = "הוּא הִתְחִיל לִצְבֹּעַ אֶת הַקִּיר הַחִיצוֹנִי בְּלָבָן.",
            exampleNative = "Он начал לִצְבֹּעַ внешнюю стену в белый цвет.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172411L, 172412L, 172414L, 172415L)),
        WordEntity(
            id = 172414, setId = 1724, languagePair = "he-ru", rarity = "RARE",
            pos = "verb", semanticGroup = "construction_operations", transliteration = "letayeakh",
            original = "לְטַיֵּחַ", translation = "штукатурить",
            definition = "לִמְרֹחַ שִׁכְבַת גֶּבֶס דַּקָּה עַל קִיר כְּדֵי שֶׁיִּהְיֶה חָלָק.",
            definitionNative = "Намазывать тонкий слой смеси на стену, чтобы она стала гладкой.",
            example = "הַטַּיָּח הִתְחִיל לְטַיֵּחַ אֶת הַקִּיר אַחֲרֵי הַצָּהֳרַיִם.",
            exampleNative = "Штукатур начал לְטַיֵּחַ стену после обеда.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172411L, 172412L, 172413L, 172415L)),
        WordEntity(
            id = 172415, setId = 1724, languagePair = "he-ru", rarity = "RARE",
            pos = "verb", semanticGroup = "construction_operations", transliteration = "lehakhlik",
            original = "לְהַחְלִיק", translation = "выравнивать, заглаживать",
            definition = "לַעֲבֹר עַל מַשֶּׁהוּ עַד שֶׁיִּהְיֶה חָלָק וּבְלִי בְּלִיטוֹת.",
            definitionNative = "Проводить по поверхности, пока она не станет ровной и без бугров.",
            example = "הוּא הִתְחִיל לְהַחְלִיק אֶת הַבֶּטוֹן בְּמַחְלֵק רָחָב.",
            exampleNative = "Он начал לְהַחְלִיק бетон широким мастерком.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172411L, 172412L, 172413L, 172414L)),

        // ── construction_measurements (5) — мерить и проверять ──
        WordEntity(
            id = 172416, setId = 1724, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "construction_measurements", transliteration = "limdod",
            original = "לִמְדֹּד", translation = "измерять",
            definition = "לִבְדֹּק כַּמָּה מַשֶּׁהוּ אָרֹךְ אוֹ רָחָב בְּעֶזְרַת סֶרֶט אוֹ סַרְגֵּל.",
            definitionNative = "Узнавать длину или ширину чего-то лентой или линейкой.",
            example = "הוּא בִּקֵּשׁ לִמְדֹּד אֶת הַחָלָל לִפְנֵי הַחִתּוּךְ.",
            exampleNative = "Он попросил לִמְדֹּד проём перед резкой.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172417L, 172418L, 172419L, 172420L)),
        WordEntity(
            id = 172417, setId = 1724, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "construction_measurements", transliteration = "plas mayim",
            original = "פְּלַס מַיִם", translation = "уровень (водяной)",
            definition = "כְּלִי אָרֹךְ עִם בּוּעָה בְּתוֹךְ נוֹזֵל לִבְדִיקַת אֹפֶק יָשָׁר.",
            definitionNative = "Длинный инструмент с пузырьком в жидкости — проверять горизонталь.",
            example = "שָׂם פְּלַס מַיִם עַל הָאֲדָנִית כְּדֵי לִבְדֹּק.",
            exampleNative = "Положил פְּלַס מַיִם на подоконник для проверки.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172416L, 172418L, 172419L, 172420L)),
        WordEntity(
            id = 172418, setId = 1724, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "construction_measurements", transliteration = "meter glila",
            original = "מֶטֶר גְּלִילָה", translation = "рулетка",
            definition = "סֶרֶט גָּמִישׁ עִם מִסְפָּרִים שֶׁמּוֹשְׁכִים מִקֻּפְסָה קְטַנָּה.",
            definitionNative = "Гибкая лента с цифрами, которую вытягивают из коробочки.",
            example = "הַבַּנַּאי שָׁלַף מֶטֶר גְּלִילָה מֵהַכִּיס שֶׁלּוֹ.",
            exampleNative = "Каменщик достал מֶטֶר גְּלִילָה из кармана.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172416L, 172417L, 172419L, 172420L)),
        WordEntity(
            id = 172419, setId = 1724, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "construction_measurements", transliteration = "anakh",
            original = "אָנָךְ", translation = "отвес",
            definition = "מִשְׁקֹלֶת קְטַנָּה תְּלוּיָה עַל חוּט לִבְדִיקַת קַו אֲנָכִי.",
            definitionNative = "Маленький груз на верёвке — проверяет вертикаль стены.",
            example = "הוּא הוֹרִיד אָנָךְ לְצַד הַקִּיר הֶחָדָשׁ.",
            exampleNative = "Он опустил אָנָךְ вдоль новой стены.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172416L, 172417L, 172418L, 172420L)),
        WordEntity(
            id = 172420, setId = 1724, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "construction_measurements", transliteration = "khad-zavit",
            original = "חַד-זָוִית", translation = "угольник, наугольник",
            definition = "כְּלִי בְּצוּרַת אוֹת L לִבְדִיקַת זָוִית שֶׁל תִּשְׁעִים מַעֲלוֹת.",
            definitionNative = "Инструмент в форме буквы Г — проверять прямой угол в девяносто градусов.",
            example = "שָׂם חַד-זָוִית בַּפִּינָּה וּבָדַק שֶׁהִיא יָשָׁר.",
            exampleNative = "Приложил חַד-זָוִית к углу и проверил, что он прямой.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172416L, 172417L, 172418L, 172419L)),

        // ── construction_orders (5) — указания бригадира ──
        WordEntity(
            id = 172421, setId = 1724, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "construction_orders", transliteration = "lehatkhil",
            original = "לְהַתְחִיל", translation = "начинать",
            definition = "לַעֲשׂוֹת אֶת הַצַּעַד הָרִאשׁוֹן שֶׁל מְשִׂימָה אוֹ עֲבוֹדָה חֲדָשָׁה.",
            definitionNative = "Делать первый шаг новой работы или задачи.",
            example = "הַבּוֹס אָמַר לְהַתְחִיל בְּשֵׁשׁ בַּבֹּקֶר מָחָר.",
            exampleNative = "Бригадир сказал לְהַתְחִיל завтра в шесть утра.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172422L, 172423L, 172424L, 172425L)),
        WordEntity(
            id = 172422, setId = 1724, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "construction_orders", transliteration = "lesayem",
            original = "לְסַיֵּם", translation = "заканчивать, завершать",
            definition = "לְהַגִּיעַ לַסּוֹף שֶׁל מְשִׂימָה וְלֹא לְהַשְׁאִיר חֲלָקִים פְּתוּחִים.",
            definitionNative = "Доходить до конца задачи и не оставлять открытых частей.",
            example = "צָרִיךְ לְסַיֵּם אֶת הַקִּיר עַד יוֹם רְבִיעִי.",
            exampleNative = "Нужно לְסַיֵּם стену до среды.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172421L, 172423L, 172424L, 172425L)),
        WordEntity(
            id = 172423, setId = 1724, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "construction_orders", transliteration = "maher yoter",
            original = "מְהֵר יוֹתֵר", translation = "быстрее (давай!)",
            definition = "בַּקָּשָׁה מֵהַבּוֹס לַעֲבֹד בְּקֶצֶב גָּדוֹל יוֹתֵר מִכְּפִי שֶׁעוֹשִׂים עַכְשָׁו.",
            definitionNative = "Просьба от бригадира работать в большем темпе, чем сейчас.",
            example = "הַמְּפַקֵּחַ צָעַק מְהֵר יוֹתֵר לְכֻלָּם בָּאֲתָר.",
            exampleNative = "Прораб крикнул всем на участке: מְהֵר יוֹתֵר!",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172421L, 172422L, 172424L, 172425L)),
        WordEntity(
            id = 172424, setId = 1724, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "construction_orders", transliteration = "ha'aver li",
            original = "הַעֲבֵר לִי", translation = "передай мне (м. р.)",
            definition = "פְּקֻדָּה קְצָרָה לַחֲבֵר לְהוֹשִׁיט פְּרִיט שֶׁמּוֹנֵחַ קָרוֹב אֵלָיו.",
            definitionNative = "Короткая команда товарищу подать предмет, лежащий рядом с ним.",
            example = "הַעֲבֵר לִי אֶת הַחֶבֶל שֶׁעַל הַסֻּלָּם בְּבַקָּשָׁה.",
            exampleNative = "הַעֲבֵר לִי верёвку с лестницы, пожалуйста.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172421L, 172422L, 172423L, 172425L)),
        WordEntity(
            id = 172425, setId = 1724, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "construction_orders", transliteration = "ten li kli",
            original = "תֵּן לִי כְּלִי", translation = "дай мне инструмент",
            definition = "בַּקָּשָׁה לְהָבִיא לַדּוֹבֵר מַכְשִׁיר עֲבוֹדָה שֶׁהוּא צָרִיךְ כָּעֵת.",
            definitionNative = "Просьба принести говорящему рабочий инструмент прямо сейчас.",
            example = "תֵּן לִי כְּלִי לְפַתֹּחַ אֶת הַתֵּבָה הַזּוֹ.",
            exampleNative = "תֵּן לִי כְּלִי, чтобы открыть этот ящик.",
            isFillInBlankSafe = true,
            fillInBlankExclusions = listOf(172421L, 172422L, 172423L, 172424L)),
    )
}
