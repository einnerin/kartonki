package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Set 1702: «Армия», уровень 1 (основы для срочной службы и репатриантов).
 *
 * 15 COMMON + 10 UNCOMMON. Базовая лексика ЦАХАЛ, которую слышит каждый
 * новобранец-репатриант: рода войск, подразделения, оружие, экипировка,
 * жизнь на базе. Выбраны слова, которых ещё нет в темах «Армия» сетов
 * 1057, 1067, 1068, 1116, 1146, 1170, 1256, 1257, 1258 — пересечения проверены
 * перед созданием.
 */
object WordDataHebrewArmyL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1702, languagePair = "he-ru", orderIndex = 1702,
            name = "Армия",
            description = "Базовая военная лексика: ЦАХАЛ, призыв, форма",
            topic = "Армия", level = 1
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── 1702: Армия (level 1, COMMON+UNCOMMON) ────────────────────────

        // — army_basics (3, COMMON): צה״ל, דֶּגֶל, קְרָב —
        WordEntity(id = 170201, setId = 1702, languagePair = "he-ru", rarity = "COMMON",
            original = "צה״ל", transliteration = "tsahal",
            translation = "ЦАХАЛ (армия Израиля)",
            pos = "noun", semanticGroup = "army_basics",
            definition = "רָאשֵׁי תֵּבוֹת לְשֵׁם הַצָּבָא הָרִשְׁמִי שֶׁל מְדִינַת יִשְׂרָאֵל.",
            definitionNative = "Сокращение от названия официальных вооружённых сил Израиля.",
            example = "כָּל בָּחוּר וְכָל בַּחוּרָה מִתְגַּיְּסִים לְצה״ל בְּגִיל שְׁמוֹנֶה־עֶשְׂרֵה.",
            exampleNative = "Каждый парень и каждая девушка идут в צה״ל в восемнадцать лет.", fillInBlankExclusions = listOf(170202L, 170203L)),

        WordEntity(id = 170202, setId = 1702, languagePair = "he-ru", rarity = "COMMON",
            original = "דֶּגֶל", transliteration = "degel",
            translation = "флаг",
            pos = "noun", semanticGroup = "army_basics",
            definition = "פִּסַּת בַּד עִם סֵמֶל אוֹ צֶבַע שֶׁמְּסַמֶּלֶת מְדִינָה אוֹ יְחִידָה.",
            definitionNative = "Кусок ткани с символом или цветом, что обозначает страну или часть.",
            example = "בְּטֶקֶס סִיּוּם הַטִּירוֹנִים נוֹשְׂאִים אֶת הַדֶּגֶל בְּגַאֲוָה.",
            exampleNative = "На церемонии новобранцы с гордостью несут דֶּגֶל.", fillInBlankExclusions = listOf(170201L, 170203L)),

        WordEntity(id = 170203, setId = 1702, languagePair = "he-ru", rarity = "COMMON",
            original = "קְרָב", transliteration = "krav",
            translation = "бой / сражение",
            pos = "noun", semanticGroup = "army_basics",
            definition = "הִתְנַגְּשׁוּת חֲמוּשָׁה בֵּין שְׁנֵי כּוֹחוֹת בְּשֶׁטַח אוֹ בָּאֲוִיר.",
            definitionNative = "Вооружённое столкновение двух сил на земле или в воздухе.",
            example = "הַחַיָּלִים יָצְאוּ לְקְרָב לִפְנֵי שֶׁעָלָה הַבֹּקֶר עַל הַגְּבָעָה.",
            exampleNative = "Солдаты вышли в קְרָב ещё до того, как утро встало над холмом.", fillInBlankExclusions = listOf(170201L, 170202L)),

        // — army_units (6): COMMON כִּתָּה, פְּלוּגָה, מַחְלָקָה; UNCOMMON כּוֹחוֹת הַיַּבָּשָׁה, חֵיל הָאֲוִיר, חֵיל הַיָּם —
        WordEntity(id = 170204, setId = 1702, languagePair = "he-ru", rarity = "COMMON",
            original = "כִּתָּה", transliteration = "kita",
            translation = "отделение (армейское)",
            pos = "noun", semanticGroup = "army_units",
            definition = "קְבוּצָה קְטַנָּה שֶׁל לוֹחֲמִים, בְּדֶרֶךְ כְּלָל שִׁשָּׁה עַד עֲשָׂרָה אֲנָשִׁים.",
            definitionNative = "Маленькая группа бойцов, обычно от шести до десяти человек.",
            example = "הַכִּתָּה יָצְאָה לְאִמּוּן לַיְלָה עִם הַמֵּפַקֵּד הַחָדָשׁ.",
            exampleNative = "כִּתָּה вышла на ночное учение с новым מַפְקֵד.", fillInBlankExclusions = listOf(170205L, 170206L)),

        WordEntity(id = 170205, setId = 1702, languagePair = "he-ru", rarity = "COMMON",
            original = "פְּלוּגָה", transliteration = "pluga",
            translation = "рота",
            pos = "noun", semanticGroup = "army_units",
            definition = "יְחִידָה צְבָאִית שֶׁל בְּעֵרֶךְ מֵאָה לוֹחֲמִים תַּחַת מַפְקֵד אֶחָד.",
            definitionNative = "Часть примерно из ста бойцов под одним командиром.",
            example = "הַפְּלוּגָה הִתְכַּנְּסָה בַּמִּסְדַּר לִפְנֵי הַיְצִיאָה לַשֶּׁטַח.",
            exampleNative = "פְּלוּגָה собралась на построение перед выходом на местность.", fillInBlankExclusions = listOf(170204L, 170206L)),

        WordEntity(id = 170206, setId = 1702, languagePair = "he-ru", rarity = "COMMON",
            original = "מַחְלָקָה", transliteration = "makhlaka",
            translation = "взвод",
            pos = "noun", semanticGroup = "army_units",
            definition = "תַּת־יְחִידָה שֶׁל כִּשְׁלוֹשִׁים לוֹחֲמִים בִּפְנִים פְּלוּגָה.",
            definitionNative = "Меньшая часть из примерно тридцати бойцов внутри роты.",
            example = "הַמַּחְלָקָה הָרִאשׁוֹנָה יוֹצֵאת לִשְׁמִירָה לְפִי לוּחַ הַזְּמַנִּים.",
            exampleNative = "Первая מַחְלָקָה выходит на охрану по графику."),

        WordEntity(id = 170207, setId = 1702, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "כּוֹחוֹת הַיַּבָּשָׁה", transliteration = "ko'khot ha'yabasha",
            translation = "сухопутные войска",
            pos = "phrase", semanticGroup = "army_units",
            definition = "חֵלֶק שֶׁל הַצָּבָא הַפּוֹעֵל עַל הַקַּרְקַע בְּטַנְקִים, רַגְלִים וְתוֹתָחִים.",
            definitionNative = "Часть армии, действующая на земле — танками, ногами и пушками.",
            example = "כּוֹחוֹת הַיַּבָּשָׁה נִכְנְסוּ לַשֶּׁטַח לְאַחַר הַהַפְצָצָה הָרִאשׁוֹנָה.",
            exampleNative = "כּוֹחוֹת הַיַּבָּשָׁה вошли в район после первой бомбёжки.", fillInBlankExclusions = listOf(170208L, 170209L)),

        WordEntity(id = 170208, setId = 1702, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חֵיל הָאֲוִיר", transliteration = "kheyl ha'avir",
            translation = "ВВС / военно-воздушные силы",
            pos = "phrase", semanticGroup = "army_units",
            definition = "זְרוֹעַ הַצָּבָא הַמַּפְעִילָה מְטוֹסִים וּמַסּוֹקִים לַהֲגָנָה וְלַהַתְקָפָה.",
            definitionNative = "Часть армии, что управляет самолётами и вертолётами для защиты и удара.",
            example = "חֵיל הָאֲוִיר עָרַךְ תַּרְגִּיל גָּדוֹל מֵעַל הַנֶּגֶב הַשָּׁבוּעַ.",
            exampleNative = "חֵיל הָאֲוִיר провёл крупное учение над Негевом на этой неделе.", fillInBlankExclusions = listOf(170207L, 170209L)),

        WordEntity(id = 170209, setId = 1702, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חֵיל הַיָּם", transliteration = "kheyl ha'yam",
            translation = "ВМФ / военно-морские силы",
            pos = "phrase", semanticGroup = "army_units",
            definition = "זְרוֹעַ הַצָּבָא הַמַּפְעִילָה אֳנִיּוֹת וְצוֹלְלוֹת לְהָגֵן עַל הַחוֹף.",
            definitionNative = "Часть армии, что управляет кораблями и подлодками для охраны побережья.",
            example = "חֵיל הַיָּם עוֹצֵר סִירוֹת חֲשׁוּדוֹת לְיַד חוֹף עַזָּה.",
            exampleNative = "חֵיל הַיָּם останавливает подозрительные лодки у берега Газы.", fillInBlankExclusions = listOf(170207L, 170208L)),

        // — army_weapons (3, COMMON): מַקְלֵעַ, אֶקְדָּח, טִיל —
        WordEntity(id = 170210, setId = 1702, languagePair = "he-ru", rarity = "COMMON",
            original = "מַקְלֵעַ", transliteration = "maklea",
            translation = "пулемёт",
            pos = "noun", semanticGroup = "army_weapons",
            definition = "כְּלִי יְרִיָּה אוֹטוֹמָטִי שֶׁיּוֹרֶה כַּדּוּרִים רַבִּים בִּזְמַן קָצָר.",
            definitionNative = "Автоматическое стрельбищное приспособление, что выпускает много пуль за короткое время.",
            example = "הַלּוֹחֵם נָשָׂא אֶת הַמַּקְלֵעַ עַל הַכָּתֵף בְּמַסַּע לַיְלָה.",
            exampleNative = "Боец нёс מַקְלֵעַ на плече в ночном марше."),

        WordEntity(id = 170211, setId = 1702, languagePair = "he-ru", rarity = "COMMON",
            original = "אֶקְדָּח", transliteration = "ekdakh",
            translation = "пистолет",
            pos = "noun", semanticGroup = "army_weapons",
            definition = "כְּלִי יְרִיָּה קָטָן שֶׁמַּחְזִיקִים בְּיָד אַחַת לְמֶרְחָק קָצָר.",
            definitionNative = "Маленькое стрельбищное приспособление, что держат одной рукой на близкой дистанции.",
            example = "הַקָּצִינָה שָׂמָה אֶקְדָּח בִּנְרְתִּיק הַחֲגוֹרָה לִפְנֵי הַיְצִיאָה.",
            exampleNative = "Офицерша положила אֶקְדָּח в кобуру на ремне перед выходом.", fillInBlankExclusions = listOf(170210L, 170212L)),

        WordEntity(id = 170212, setId = 1702, languagePair = "he-ru", rarity = "COMMON",
            original = "טִיל", transliteration = "til",
            translation = "ракета",
            pos = "noun", semanticGroup = "army_weapons",
            definition = "כְּלִי נֶשֶׁק מְעוֹפֵף וּמַתְפּוֹצֵץ שֶׁיוֹצֵא מִמַּשְׁגֵּר לְפִי מַסְלוּל.",
            definitionNative = "Летящее и взрывающееся оружие, что идёт по заданному пути из пусковой.",
            example = "טִיל נָפַל בְּשָׂדֶה רֵיק וְלֹא גָּרַם נֶזֶק לְאַף אֶחָד.",
            exampleNative = "טִיל упал в пустое поле и никому не нанёс ущерба.", fillInBlankExclusions = listOf(170210L, 170211L)),

        // — army_gear (3, COMMON): אֲפוֹד, מַגָּף, אֲלוּנְקָה —
        WordEntity(id = 170213, setId = 1702, languagePair = "he-ru", rarity = "COMMON",
            original = "אֲפוֹד", transliteration = "afod",
            translation = "бронежилет",
            pos = "noun", semanticGroup = "army_gear",
            definition = "וְסֶט עָבֶה הַמְּכַסֶּה אֶת הֶחָזֶה וּמֵגֵן מִפְּגִיעוֹת קְלִיעִים.",
            definitionNative = "Толстая жилетка, что закрывает грудь и спасает от пуль.",
            example = "כָּל לוֹחֵם לוֹבֵשׁ אֲפוֹד לִפְנֵי שֶׁהוּא יוֹצֵא מֵהַמַּחְסֹם.",
            exampleNative = "Каждый боец надевает אֲפוֹד перед выходом из блокпоста.", fillInBlankExclusions = listOf(170214L, 170215L)),

        WordEntity(id = 170214, setId = 1702, languagePair = "he-ru", rarity = "COMMON",
            original = "מַגָּף", transliteration = "magaf",
            translation = "берц / армейский ботинок",
            pos = "noun", semanticGroup = "army_gear",
            definition = "נַעַל גְּבוֹהָה וּקָשָׁה הַמּוּדְבֶּקֶת לָרֶגֶל לְהֲלִיכָה בַּשֶּׁטַח הַקָּשֶׁה.",
            definitionNative = "Высокий жёсткий ботинок, плотно сидящий на ноге для марша по тяжёлой местности.",
            example = "הַטִּירוֹן צִחְצֵחַ אֶת הַמַּגָּף שֶׁלּוֹ לְפִי הַפְּקוּדָּה לִפְנֵי הַמִּסְדָּר.",
            exampleNative = "Новобранец начистил свой מַגָּף по приказу до построения."),

        WordEntity(id = 170215, setId = 1702, languagePair = "he-ru", rarity = "COMMON",
            original = "אֲלוּנְקָה", transliteration = "alunka",
            translation = "носилки",
            pos = "noun", semanticGroup = "army_gear",
            definition = "מִתְקָן בַּד עִם שְׁתֵּי מוֹטוֹת לְסוּחֲבַת פָּצוּעַ אוֹ חוֹלֶה.",
            definitionNative = "Тканевое приспособление с двумя жердями для переноски раненого или больного.",
            example = "צֶמֶד לוֹחֲמִים סָחַב אֲלוּנְקָה כְּבֵדָה אֶל הַמַּסּוֹק.",
            exampleNative = "Двое бойцов тащили тяжёлую אֲלוּנְקָה к вертолёту.", fillInBlankExclusions = listOf(170213L, 170214L)),

        // — army_base_life (4): COMMON מִשְׁמָר, שׁוֹמֵר, קַנְטִינָה; UNCOMMON הַשְׁבָּעָה —
        WordEntity(id = 170216, setId = 1702, languagePair = "he-ru", rarity = "COMMON",
            original = "מִשְׁמָר", transliteration = "mishmar",
            translation = "стража / караул",
            pos = "noun", semanticGroup = "army_base_life",
            definition = "תַּפְקִיד שֶׁבּוֹ עוֹמְדִים שָׁעוֹת קְבוּעוֹת לִשְׁמֹר עַל בָּסִיס אוֹ עֶמְדָּה.",
            definitionNative = "Дежурство, при котором стоят установленные часы и охраняют базу или позицию.",
            example = "הַחַיָּל יָצָא לְמִשְׁמָר בִּשְׁתַּיִם בַּלַּיְלָה לְשָׁעָתַיִם.",
            exampleNative = "Боец вышел на מִשְׁמָר в два часа ночи на пару часов.", fillInBlankExclusions = listOf(170217L, 170218L, 170219L)),

        WordEntity(id = 170217, setId = 1702, languagePair = "he-ru", rarity = "COMMON",
            original = "שׁוֹמֵר", transliteration = "shomer",
            translation = "часовой / дозорный",
            pos = "noun", semanticGroup = "army_base_life",
            definition = "אָדָם שֶׁעוֹמֵד בַּשַּׁעַר אוֹ בִּמְקוֹם רָגִישׁ לִבְדֹּק מִי נִכְנָס וּמִי יוֹצֵא.",
            definitionNative = "Тот, кто стоит у ворот или на чувствительной точке и проверяет, кто входит и выходит.",
            example = "הַשּׁוֹמֵר עָצַר אוֹתִי בַּשַּׁעַר וּבִקֵּשׁ לִרְאוֹת אֶת הַתְּעוּדָה.",
            exampleNative = "שׁוֹמֵר остановил меня у ворот и попросил показать удостоверение."),

        WordEntity(id = 170218, setId = 1702, languagePair = "he-ru", rarity = "COMMON",
            original = "קַנְטִינָה", transliteration = "kantina",
            translation = "кантина (магазин на базе)",
            pos = "noun", semanticGroup = "army_base_life",
            definition = "חֲנוּת קְטַנָּה בַּבָּסִיס שֶׁמּוֹכֶרֶת חַטִּיפִים, שְׁתִיָּה וּצְרָכִים יוֹמְיוֹמִיִּים.",
            definitionNative = "Маленькая лавка на базе, где продают перекусы, питьё и бытовые мелочи.",
            example = "אַחֲרֵי הָאִמּוּן רַצְנוּ לַקַּנְטִינָה לִקְנוֹת קָפֶה וְשׁוֹקוֹלָד.",
            exampleNative = "После учения мы рванули в קַנְטִינָה за кофе и шоколадкой."),

        WordEntity(id = 170219, setId = 1702, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַשְׁבָּעָה", transliteration = "hashba'a",
            translation = "присяга",
            pos = "noun", semanticGroup = "army_base_life",
            definition = "טֶקֶס שֶׁבּוֹ הַטִּירוֹן מַבְטִיחַ נֶאֱמָנוּת לַמְּדִינָה וְלַצָּבָא.",
            definitionNative = "Церемония, на которой новобранец обещает верность стране и армии.",
            example = "טֶקֶס הַהַשְׁבָּעָה נֶעֱרַךְ בַּכֹּתֶל בְּנוֹכְחוּת הַמִּשְׁפָּחוֹת.",
            exampleNative = "Церемония הַשְׁבָּעָה прошла у Стены в присутствии семей.", fillInBlankExclusions = listOf(170216L, 170217L, 170218L)),

        // — army_service (3, UNCOMMON): קֶבַע, סָדִיר, דַּרְגָּה —
        WordEntity(id = 170220, setId = 1702, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קֶבַע", transliteration = "keva",
            translation = "кадровая (постоянная) служба",
            pos = "noun", semanticGroup = "army_service",
            definition = "שֵׁרוּת בְּתַשְׁלוּם לִתְקוּפָה אֲרֻכָּה לְאַחַר סִיּוּם הַשֵּׁרוּת הַחוֹבָה.",
            definitionNative = "Оплачиваемая служба на долгий срок после окончания обязательной.",
            example = "אַחֲרֵי שָׁלוֹשׁ שָׁנִים הוּא חָתַם עַל קֶבַע לְעוֹד חָמֵשׁ שָׁנִים.",
            exampleNative = "Через три года он подписался на קֶבַע ещё на пять лет.", fillInBlankExclusions = listOf(170221L, 170222L)),

        WordEntity(id = 170221, setId = 1702, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סָדִיר", transliteration = "sadir",
            translation = "срочная (регулярная) служба",
            pos = "noun", semanticGroup = "army_service",
            definition = "תְּקוּפַת שֵׁרוּת חוֹבָה שֶׁל חַיָּל צָעִיר אַחֲרֵי הַטִּירוֹנוּת.",
            definitionNative = "Срок обязательной службы молодого бойца после учебки.",
            example = "הוּא סִיֵּם אֶת הַסָּדִיר וְהִתְחִיל לְלַמֹּד בָּאוּנִיבֶרְסִיטָה.",
            exampleNative = "Он закончил סָדִיר и начал учёбу в университете."),

        WordEntity(id = 170222, setId = 1702, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "דַּרְגָּה", transliteration = "darga",
            translation = "звание / воинское звание",
            pos = "noun", semanticGroup = "army_service",
            definition = "סִימָן עַל הַכָּתֵף הַמְּסַמֵּן אֶת הַמַּעֲמָד שֶׁל הַחַיָּל בַּצָּבָא.",
            definitionNative = "Знак на плече, что показывает положение бойца в армии.",
            example = "אַחֲרֵי הַקּוּרְס הוּא קִבֵּל דַּרְגָּה חֲדָשָׁה בַּטֶּקֶס.",
            exampleNative = "После курса он получил новую דַּרְגָּה на церемонии.", fillInBlankExclusions = listOf(170220L, 170221L)),

        // — army_training (3, UNCOMMON): מַטָּוַח, קְלִיעָה, טַיָּס —
        WordEntity(id = 170223, setId = 1702, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַטָּוַח", transliteration = "matvakh",
            translation = "стрельбище / тир",
            pos = "noun", semanticGroup = "army_training",
            definition = "שֶׁטַח פָּתוּחַ וּמְסֻדָּר שֶׁבּוֹ חַיָּלִים מִתְאַמְּנִים בִּפְגִיעָה בְּמַטָּרוֹת.",
            definitionNative = "Открытое размеченное место, где бойцы учатся попадать в мишени.",
            example = "הַמַּחְלָקָה יָצְאָה לַמַּטָּוַח לִשְׁעָתַיִם שֶׁל אִמּוּן בֹּקֶר.",
            exampleNative = "Взвод вышел на מַטָּוַח на два часа утренней тренировки."),

        WordEntity(id = 170224, setId = 1702, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קְלִיעָה", transliteration = "kli'a",
            translation = "стрельба / меткость",
            pos = "noun", semanticGroup = "army_training",
            definition = "פְּעֻלָּה שֶׁל יְרִיָּה בְּמַטָּרָה תּוֹךְ דִּיּוּק וּשְׁלִיטָה בַּכְּלִי.",
            definitionNative = "Действие выстрела по мишени с точностью и контролем над оружием.",
            example = "הוּא קִבֵּל צִיּוּן מַעֲלֶה עַל קְלִיעָה בְּתֹם שָׁבוּעַ הָאִמּוּן.",
            exampleNative = "Он получил высокую оценку за קְלִיעָה в конце недели тренировок.", fillInBlankExclusions = listOf(170223L, 170225L)),

        WordEntity(id = 170225, setId = 1702, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טַיָּס", transliteration = "tayas",
            translation = "лётчик / пилот",
            pos = "noun", semanticGroup = "army_training",
            definition = "אִישׁ שֶׁמְּפַעֵל מָטוֹס קְרָבִי לְאַחַר קוּרְס אָרֹךְ וְקָשֶׁה.",
            definitionNative = "Тот, кто управляет боевым самолётом после долгого и тяжёлого курса.",
            example = "הַטַּיָּס נָחַת בְּשָׁלוֹם בַּבָּסִיס לְאַחַר טִיסַת לַיְלָה אֲרֻכָּה.",
            exampleNative = "טַיָּס благополучно сел на базу после долгого ночного полёта."),
    )
}
