package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Дом и быт", level 1 (A1-A2).
 * Один сет × 25 слов. setId = 1700.
 *
 *  - 15 COMMON + 10 UNCOMMON (2 смежных уровня).
 *  - 6 семантических групп: dishes_tableware (8), small_decor (5),
 *    cleaning (4), furniture (4), bedding (2), building_parts (2).
 *  - Слова не пересекаются с существующими сетами темы «Дом и быт»
 *    (1004, 1026, 1027, 1032, 1050, 1051, 1132, 1152, 1162, 1175,
 *    1206, 1243, 1244, 1245, 1247, 1248).
 */
object WordDataHebrewHomeL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1700, languagePair = "he-ru", orderIndex = 200,
            name = "Дом и быт",
            description = "Базовая лексика дома: комнаты, мебель, посуда",
            topic = "Дом и быт", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── dishes_tableware (8) ─────────────────────────────────────────────
        WordEntity(
            id = 170001, setId = 1700, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "dishes_tableware",
            original = "צַלַּחַת", translation = "тарелка",
            transliteration = "tsalakhat",
            definition = "כְּלִי שָׁטוּחַ עָגֹל שֶׁמַּגִּישִׁים בּוֹ אֹכֶל לְכָל סוֹעֵד.",
            definitionNative = "Плоский круглый предмет, на котором подают еду каждому едоку.",
            example = "שַׂמְתִּי עַל הַשֻּׁלְחָן צַלַּחַת חַמָּה עִם אֹרֶז.",
            exampleNative = "Я поставил на стол горячую צַלַּחַת с рисом.",
         fillInBlankExclusions = listOf(170002L, 170003L, 170004L, 170005L, 170006L, 170007L, 170008L)),
        WordEntity(
            id = 170002, setId = 1700, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "dishes_tableware",
            original = "כּוֹס", translation = "стакан",
            transliteration = "kos",
            definition = "כְּלִי קָטָן וְעָגֹל לִשְׁתִיַּת מַיִם, מִיץ אוֹ מַשְׁקֶה אַחֵר.",
            definitionNative = "Небольшой круглый сосуд для питья воды, сока или другого напитка.",
            example = "מָזַגְתִּי לוֹ כּוֹס מַיִם קָרִים.",
            exampleNative = "Я налил ему כּוֹס холодной воды.",
         fillInBlankExclusions = listOf(170001L, 170003L, 170004L, 170005L, 170006L, 170007L, 170008L)),
        WordEntity(
            id = 170003, setId = 1700, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "dishes_tableware",
            original = "סַכִּין", translation = "нож",
            transliteration = "sakin",
            definition = "מַכְשִׁיר עִם לַהַב חַד שֶׁמְּשַׁמֵּשׁ לַחֲתֹךְ אֹכֶל אוֹ חֳמָרִים.",
            definitionNative = "Инструмент с острым лезвием, которым режут пищу или материалы.",
            example = "הוּא לָקַח סַכִּין וְחָתַךְ אֶת הַלֶּחֶם לִשְׁנַיִם.",
            exampleNative = "Он взял סַכִּין и разрезал хлеб пополам.",
         fillInBlankExclusions = listOf(170001L, 170002L, 170004L, 170005L, 170006L, 170007L, 170008L)),
        WordEntity(
            id = 170004, setId = 1700, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "dishes_tableware",
            original = "מַזְלֵג", translation = "вилка",
            transliteration = "mazleg",
            definition = "כְּלִי אֲכִילָה עִם שִׁנַּיִם דַּקּוֹת לִתְפֹּס מָנוֹת מַעַל הַצַּלַּחַת.",
            definitionNative = "Столовый прибор с зубцами, которым подцепляют еду из тарелки.",
            example = "אֲנִי אוֹכֵל סָלָט עִם מַזְלֵג קָטָן.",
            exampleNative = "Я ем салат маленькой מַזְלֵג.",
         fillInBlankExclusions = listOf(170001L, 170002L, 170003L, 170005L, 170006L, 170007L, 170008L)),
        WordEntity(
            id = 170005, setId = 1700, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "dishes_tableware",
            original = "סִיר", translation = "кастрюля",
            transliteration = "sir",
            definition = "כְּלִי בִּשּׁוּל עָמֹק עִם יָדִית שֶׁשָּׂמִים עַל הַכִּירַיִם.",
            definitionNative = "Глубокая посуда с ручкой для готовки, которую ставят на плиту.",
            example = "הָאִמָּא הִכִּינָה מָרָק בְּסִיר גָּדוֹל.",
            exampleNative = "Мама приготовила суп в большой סִיר.",
         fillInBlankExclusions = listOf(170001L, 170002L, 170003L, 170004L, 170006L, 170007L, 170008L)),
        WordEntity(
            id = 170006, setId = 1700, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "dishes_tableware",
            original = "בַּקְבּוּק", translation = "бутылка",
            transliteration = "bakbuk",
            definition = "כְּלִי גָּבוֹהַּ וְצַר עָשׂוּי זְכוּכִית אוֹ פְּלַסְטִיק לִשְׁמֹר נֹזֶל.",
            definitionNative = "Высокий узкий сосуд из стекла или пластика, в котором держат жидкость.",
            example = "הוּא קָנָה בַּקְבּוּק שֶׁל מַיִם בַּחֲנוּת.",
            exampleNative = "Он купил בַּקְבּוּק воды в магазине.",
         fillInBlankExclusions = listOf(170001L, 170002L, 170003L, 170004L, 170005L, 170007L, 170008L)),
        WordEntity(
            id = 170007, setId = 1700, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "dishes_tableware",
            original = "כַּד", translation = "кувшин",
            transliteration = "kad",
            definition = "כְּלִי גָּדוֹל עִם יָדִית וּפִיָּה לִמְזוֹג מִמֶּנּוּ נֹזֶל לְכוֹסוֹת.",
            definitionNative = "Большой сосуд с ручкой и носиком, из которого наливают жидкость по стаканам.",
            example = "עַל הַשֻּׁלְחָן עוֹמֵד כַּד עִם מִיץ תַּפּוּזִים.",
            exampleNative = "На столе стоит כַּד с апельсиновым соком.",
         fillInBlankExclusions = listOf(170001L, 170002L, 170003L, 170004L, 170005L, 170006L, 170008L)),
        WordEntity(
            id = 170008, setId = 1700, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "dishes_tableware",
            original = "קַעֲרִית", translation = "пиала",
            transliteration = "ka'arit",
            definition = "כְּלִי קָטָן וְעָמֹק לְהַגָּשַׁת רֹטֶב, סָלָט אוֹ מָנָה אִישִׁית.",
            definitionNative = "Маленькая глубокая посуда для соуса, салата или порционной еды.",
            example = "הוּא יָצַק טְחִינָה לְתוֹךְ קַעֲרִית.",
            exampleNative = "Он налил тхину в קַעֲרִית.",
         fillInBlankExclusions = listOf(170001L, 170002L, 170003L, 170004L, 170005L, 170006L, 170007L)),

        // ─── small_decor (5) ──────────────────────────────────────────────────
        WordEntity(
            id = 170009, setId = 1700, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "small_decor",
            original = "נֵר", translation = "свеча",
            transliteration = "ner",
            definition = "מַקֵּל שַׁעֲוָה עִם פְּתִילָה דַּקָּה שֶׁמַּדְלִיקִים כְּדֵי לְקַבֵּל אוֹר.",
            definitionNative = "Восковой стержень с тонким фитилём, который зажигают для света.",
            example = "הִדְלַקְנוּ נֵר קָטָן עַל הַשֻּׁלְחָן.",
            exampleNative = "Мы зажгли маленький נֵר на столе.",
         fillInBlankExclusions = listOf(170010L, 170011L, 170012L, 170013L)),
        WordEntity(
            id = 170010, setId = 1700, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "small_decor",
            original = "גַּפְרוּר", translation = "спичка",
            transliteration = "gafrur",
            definition = "מַקֵּל עֵץ קָצָר עִם רֹאשׁ דָּלִיק שֶׁמַּצִּיתִים לְהַדְלָקַת אֵשׁ.",
            definitionNative = "Короткая деревянная палочка с зажигательной головкой, чтобы развести огонь.",
            example = "הוּא הִשְׁתַּמֵּשׁ בְּגַפְרוּר אֶחָד וְהִדְלִיק אֶת הַתַּנּוּר.",
            exampleNative = "Он использовал одну גַּפְרוּר и зажёг печь.",
        ),
        WordEntity(
            id = 170011, setId = 1700, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "small_decor",
            original = "מַסְגֶּרֶת", translation = "рамка",
            transliteration = "misgeret",
            definition = "מִבְנֶה דַּק מִסָּבִיב לִתְמוּנָה אוֹ לְמַרְאָה הַתָּלוּי עַל הַקִּיר.",
            definitionNative = "Тонкая обводка вокруг картины или зеркала, которая висит на стене.",
            example = "תָּלִינוּ מַסְגֶּרֶת זָהָב מֵעַל הַסַּפָּה.",
            exampleNative = "Мы повесили золотую מַסְגֶּרֶת над диваном.",
         fillInBlankExclusions = listOf(170009L, 170010L, 170012L, 170013L, 170019L)),
        WordEntity(
            id = 170012, setId = 1700, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "small_decor",
            original = "מִתְלֶה", translation = "вешалка",
            transliteration = "mitle",
            definition = "מַכְשִׁיר קָטָן עִם וָוִים לִתְלוֹת מְעִילִים, כּוֹבָעִים אוֹ מַגָּבוֹת.",
            definitionNative = "Небольшое приспособление с крючками для пальто, шляп или полотенец.",
            example = "תָּלִיתִי אֶת הַמְּעִיל עַל מִתְלֶה לְיַד הַדֶּלֶת.",
            exampleNative = "Я повесил пальто на מִתְלֶה у двери.",
         fillInBlankExclusions = listOf(170009L, 170010L, 170011L, 170013L)),
        WordEntity(
            id = 170013, setId = 1700, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "small_decor",
            original = "פְּמוֹט", translation = "подсвечник",
            transliteration = "pmot",
            definition = "כְּלִי קָטָן עִם בָּסִיס שֶׁמַּחֲזִיק נֵר זָקוּף עַל הַשֻּׁלְחָן.",
            definitionNative = "Маленькая подставка, которая держит свечу вертикально на столе.",
            example = "אִמָּא שָׂמָה אֶת הַנֵּר בְּתוֹךְ פְּמוֹט שֶׁל כֶּסֶף.",
            exampleNative = "Мама поставила свечу в серебряный פְּמוֹט.",
         fillInBlankExclusions = listOf(170002L, 170008L, 170009L, 170010L, 170011L, 170012L)),

        // ─── cleaning (4) ─────────────────────────────────────────────────────
        WordEntity(
            id = 170014, setId = 1700, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cleaning",
            original = "שׁוֹאֵב אָבָק", translation = "пылесос",
            transliteration = "shoev avak",
            definition = "מַכְשִׁיר חַשְׁמַלִּי שֶׁשּׁוֹאֵב לְכֶלוּךְ וְאָבָק מֵהָרִצְפָּה.",
            definitionNative = "Электрический прибор, который втягивает грязь и пыль с пола.",
            example = "אֲנִי מְנַקֶּה אֶת הַסָּלוֹן עִם שׁוֹאֵב אָבָק.",
            exampleNative = "Я убираю гостиную с помощью שׁוֹאֵב אָבָק.",
         fillInBlankExclusions = listOf(170015L, 170016L, 170017L)),
        WordEntity(
            id = 170015, setId = 1700, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cleaning",
            original = "מַטְלִית", translation = "тряпка",
            transliteration = "matlit",
            definition = "פִּסַּת בַּד רַכָּה לְנִקּוּי שֻׁלְחָנוֹת, חַלּוֹנוֹת אוֹ הָרִצְפָּה.",
            definitionNative = "Кусок мягкой ткани для протирки столов, окон или пола.",
            example = "לָקַחְתִּי מַטְלִית רְטוּבָּה וְנִגַּבְתִּי אֶת הַמְּקָרֵר.",
            exampleNative = "Я взял мокрую מַטְלִית и протёр холодильник.",
         fillInBlankExclusions = listOf(170014L, 170016L, 170017L)),
        WordEntity(
            id = 170016, setId = 1700, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cleaning",
            original = "מַטְאֲטֵא", translation = "метла",
            transliteration = "mat'ate",
            definition = "כְּלִי עִם יָדִית אֲרֻכָּה וְזִיפִים שֶׁמְּטַאטְאִים בּוֹ אֶת הָרִצְפָּה.",
            definitionNative = "Инструмент с длинной ручкой и щетиной, которым подметают пол.",
            example = "הִיא לָקְחָה מַטְאֲטֵא וְהוֹצִיאָה אֶת הָאָבָק לַחָצֵר.",
            exampleNative = "Она взяла מַטְאֲטֵא и вымела пыль во двор.",
         fillInBlankExclusions = listOf(170014L, 170015L, 170017L)),
        WordEntity(
            id = 170017, setId = 1700, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cleaning",
            original = "כְּפָפוֹת", translation = "перчатки",
            transliteration = "kfafot",
            definition = "כִּסּוּי גּוּמִי לַיָּדַיִם שֶׁמַּגִּן מֵחֳמָרֵי נִקּוּי בִּזְמַן עֲבוֹדָה.",
            definitionNative = "Резиновое покрытие для рук, защищающее от моющих средств во время уборки.",
            example = "הִיא לוֹבֶשֶׁת כְּפָפוֹת לִפְנֵי שֶׁשּׁוֹטֶפֶת אֶת הַכֵּלִים.",
            exampleNative = "Она надевает כְּפָפוֹת перед мытьём посуды.",
         fillInBlankExclusions = listOf(170014L, 170015L, 170016L)),

        // ─── furniture (4) ────────────────────────────────────────────────────
        WordEntity(
            id = 170018, setId = 1700, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "furniture",
            original = "שִׁדָּה", translation = "комод",
            transliteration = "shida",
            definition = "רָהִיט עִם מְגֵרוֹת אֲחָדוֹת שֶׁשּׂוֹמְרִים בּוֹ בְּגָדִים אוֹ מַגָּבוֹת.",
            definitionNative = "Предмет мебели с несколькими ящиками для хранения одежды или белья.",
            example = "הוּא הִכְנִיס אֶת הַחֻלְצוֹת לְתוֹךְ שִׁדָּה חֲדָשָׁה.",
            exampleNative = "Он сложил рубашки в новую שִׁדָּה.",
         fillInBlankExclusions = listOf(170019L, 170020L, 170021L, 170023L)),
        WordEntity(
            id = 170019, setId = 1700, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "furniture",
            original = "שָׁעוֹן קִיר", translation = "настенные часы",
            transliteration = "sha'on kir",
            definition = "מַכְשִׁיר זְמַן עָגֹל שֶׁתָּלוּי עַל הַקִּיר וּמַרְאֶה אֶת הַשָּׁעָה.",
            definitionNative = "Круглый прибор времени, висящий на стене и показывающий часы.",
            example = "שָׁעוֹן קִיר גָּדוֹל תָּלוּי מֵעַל הַסַּפָּה.",
            exampleNative = "Большие שָׁעוֹן קִיר висят над диваном.",
         fillInBlankExclusions = listOf(170012L, 170013L, 170018L, 170020L, 170021L)),
        WordEntity(
            id = 170020, setId = 1700, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "furniture",
            original = "שַׁרְפְּרַף", translation = "табурет",
            transliteration = "sharpraf",
            definition = "מוֹשָׁב נָמוּךְ בְּלִי מִשְׁעָן לְשִׁמּוּשׁ זְמַנִּי בַּמִּטְבָּח אוֹ בַּחֶדֶר.",
            definitionNative = "Низкое сиденье без спинки для временного использования на кухне или в комнате.",
            example = "אֲנִי יוֹשֵׁב עַל שַׁרְפְּרַף לְיַד הַשֻּׁלְחָן.",
            exampleNative = "Я сижу на שַׁרְפְּרַף возле стола.",
         fillInBlankExclusions = listOf(170018L, 170019L, 170021L)),
        WordEntity(
            id = 170021, setId = 1700, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "furniture",
            original = "דַּלְפֵּק", translation = "стойка",
            transliteration = "dalpek",
            definition = "מִשְׁטָח עֲבוֹדָה גָּבוֹהַּ בַּמִּטְבָּח שֶׁעָלָיו מְכִינִים אֹכֶל.",
            definitionNative = "Высокая рабочая поверхность на кухне, на которой готовят еду.",
            example = "הִנַּחְתִּי אֶת הַלֶּחֶם עַל הַדַּלְפֵּק.",
            exampleNative = "Я положил хлеб на דַּלְפֵּק.",
         fillInBlankExclusions = listOf(170018L, 170019L, 170020L)),

        // ─── bedding (2) ──────────────────────────────────────────────────────
        WordEntity(
            id = 170022, setId = 1700, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "bedding",
            original = "סָדִין", translation = "простыня",
            transliteration = "sadin",
            definition = "פִּיסַת בַּד גְּדוֹלָה דַּקָּה שֶׁפּוֹרְשִׂים עַל הַמִּזְרָן לִפְנֵי שֵׁנָה.",
            definitionNative = "Большой тонкий кусок ткани, расстилаемый на матрасе перед сном.",
            example = "הִיא הֶחֱלִיפָה אֶת הַסָּדִין בַּבֹּקֶר.",
            exampleNative = "Она поменяла סָדִין утром.",
        ),
        WordEntity(
            id = 170023, setId = 1700, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "bedding",
            original = "צִיפָּה", translation = "наволочка",
            transliteration = "tzipa",
            definition = "כִּסּוּי בַּד שֶׁעוֹטְפִים בּוֹ אֶת הַכָּרִית לִפְנֵי הַשֵּׁנָה.",
            definitionNative = "Тканевый чехол, в который оборачивают подушку перед сном.",
            example = "אֲנִי מְכַבֵּס אֶת הַצִּיפָּה פַּעַם בְּשָׁבוּעַ.",
            exampleNative = "Я стираю צִיפָּה раз в неделю.",
        ),

        // ─── building_parts (2) ───────────────────────────────────────────────
        WordEntity(
            id = 170024, setId = 1700, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "building_parts",
            original = "גַּג", translation = "крыша",
            transliteration = "gag",
            definition = "הַחֵלֶק הָעֶלְיוֹן שֶׁל הַבַּיִת שֶׁמַּגִּן עַל הַדִּיָּרִים מִגֶּשֶׁם וְשֶׁמֶשׁ.",
            definitionNative = "Верхняя часть дома, защищающая жильцов от дождя и солнца.",
            example = "יְלָדִים עָלוּ עַל הַגַּג לִרְאוֹת אֶת הַזִּיקּוּקִים.",
            exampleNative = "Дети поднялись на גַּג, чтобы посмотреть фейерверк.",
         fillInBlankExclusions = listOf(170025L)),
        WordEntity(
            id = 170025, setId = 1700, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "building_parts",
            original = "סְבָכָה", translation = "решётка",
            transliteration = "svakha",
            definition = "מִבְנֶה מִמֶּתֶכֶת עִם חוֹרִים שֶׁמְּכַסֶּה חַלּוֹן אוֹ פֶּתַח לַהֲגָנָה.",
            definitionNative = "Металлическая конструкция с отверстиями, закрывающая окно или проём для защиты.",
            example = "הִתְקִינוּ סְבָכָה עַל הַחַלּוֹן בַּקּוֹמָה הָרִאשׁוֹנָה.",
            exampleNative = "Установили סְבָכָה на окно первого этажа.",
         fillInBlankExclusions = listOf(170011L, 170024L)),
    )
}
