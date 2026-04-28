package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — Время и календарь (L5, LEGENDARY+EPIC).
 *
 * Set 1836: «Время и календарь» — носитель/архаика.
 *           Танахические образы времени, поэтика и философия времени,
 *           архаичные единицы и литературные эпитеты.
 *
 * Тема «Время и календарь» — продолжение L1 (1832), L2 (1833), L3 (1834).
 * L4 (1835) — соседний уровень (B2-C1), создаётся в той же волне.
 *
 * Все 25 слов проверены grep'ом по `original = "..."` против всех
 * he-ru сетов. В частности обойдены уже занятые слова:
 *   - L2 (1833): עִתִּים, פַּעַם, פְּעָמִים;
 *   - L3 (1834): מִקֶּדֶם, מוֹעֵד, פֶּרֶק זְמַן, עִתּוּי;
 *   - AliyaV2 (1733): אַחֲרִית הַיָּמִים;
 *   - Batch83: אֵין סוֹף;
 *   - AchievementRewards: נִצְחִי;
 *   - AppearanceL3: שָׁעוֹן חוֹל (заменено на שָׁעוֹן הַחֹל с артиклем);
 *   - Batch87: זְמַן עָבָר.
 *
 * Распределение редкости: 18 LEGENDARY + 7 EPIC — два смежных уровня
 * C2+ (LEGENDARY доминирует) + C1 (EPIC).
 *
 * SemanticGroups (5 × 5):
 *   time_l5_biblical        — Танахические образы времени:
 *     קֵץ הַיָּמִים, נֵצַח, דּוֹר וָדוֹר (EPIC), יְמוֹת עוֹלָם, אַחֲרִית הָעוֹלָם (EPIC)
 *   time_l5_poetic          — поэтические образы времени:
 *     שָׁעוֹן הַחֹל, רִקְמַת הַזְּמַן, חוּג הַחַמָּה, תּוֹחֶלֶת חַיִּים, נֵר תָּמִיד (EPIC)
 *   time_l5_philosophy      — философские категории времени:
 *     אַל-זְמַן, הַוֶּה מָתְמִיד, סוֹף עוֹלָם, מְצִיאוּת חוֹלֶפֶת, הִשְׁתַּלְשְׁלוּת (EPIC)
 *   time_l5_archaic_units   — архаичные единицы и обороты:
 *     זְמַן רַב, רֶגַע אַחַר (EPIC), תְּרֵי-עָשָׂר חֳדָשִׁים, עֶבֶר רָחוֹק, עָתִיד נֶצַח (EPIC)
 *   time_l5_descriptive     — литературные эпитеты времени:
 *     קַדְמוֹן, אַל-מָוֶת, חוֹלֵף, נִצְחִיּוּת, רוּחַ הַזְּמַן (EPIC)
 *
 * Word IDs: setId × 100 + position (183601..183625).
 *
 * fillInBlankExclusions / isFillInBlankSafe — НЕ задаются здесь.
 * Заполнятся через FILL_IN_BLANK pipeline централизованно после
 * полировки набора.
 */
object WordDataHebrewTimeL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1836,
            languagePair = "he-ru",
            orderIndex = 1836,
            name = "Время и календарь",
            description = "Танахические образы, поэтика и философия времени",
            topic = "Время и календарь",
            level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 1836 — Время и календарь: носитель/архаика (L5, LEG+EPIC)   ║
        // ║ 18 LEGENDARY + 7 EPIC, 5 групп × 5 слов                         ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── time_l5_biblical (5) — Танахические образы времени ────────────

        WordEntity(
            id = 183601, setId = 1836, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "time_l5_biblical",
            original = "קֵץ הַיָּמִים", translation = "конец дней (мессианское время, Танах)",
            transliteration = "кэц hа-ямим",
            definition = "בִּטּוּי תַּנָּ\"כִי לִתְקוּפָה הָאַחֲרוֹנָה שֶׁל הַהִיסְטוֹרְיָה — זְמַן הַגְּאֻלָּה הַשְּׁלֵמָה.",
            definitionNative = "Танахическое выражение для последней эпохи истории — времени окончательного избавления.",
            example = "הַנְּבִיאִים חָזוּ עוֹלָם שָׁלֵם בְּקֵץ הַיָּמִים.",
            exampleNative = "Пророки прозревали мир без войн в קֵץ הַיָּמִים.",
         fillInBlankExclusions = listOf(183602L, 183603L, 183604L, 183605L)),

        WordEntity(
            id = 183602, setId = 1836, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "time_l5_biblical",
            original = "נֵצַח", translation = "вечность (поэт./Танах.)",
            transliteration = "нэцах",
            definition = "מוּשָׂג שֶׁל זְמַן בִּלְתִּי-מֻגְבָּל בַּשִּׁירָה וּבַתַּנָּ\"ךְ — לֹא רַק תְּקוּפָה אֲרֻכָּה אֶלָּא הֶעְדֵּר סוֹף.",
            definitionNative = "Понятие безграничного времени в поэзии и Танахе — не просто долгий срок, а отсутствие предела.",
            example = "הַמִּזְמוֹר הִשְׁווָה אֶת חֶסֶד הָאֵל לַנֵּצַח.",
            exampleNative = "Псалмопевец уподоблял милость Бога נֵצַח.",
        ),

        WordEntity(
            id = 183603, setId = 1836, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "time_l5_biblical",
            original = "דּוֹר וָדוֹר", translation = "из рода в род, во веки веков (Танах)",
            transliteration = "дор ва-дор",
            definition = "בִּטּוּי מִקְרָאִי הַמּוֹסֵר רַעֲיוֹן שֶׁל הֶמְשֵׁכִיּוּת בֵּין דּוֹרוֹת — זִכְרוֹן עָם וַחֲסָדָיו.",
            definitionNative = "Библейское выражение, передающее идею преемственности между поколениями — народной памяти и милостей.",
            example = "סִפּוּרֵי הַיְּצִיאָה מִמִּצְרַיִם נִמְסָרִים מִדּוֹר וָדוֹר.",
            exampleNative = "Рассказы об исходе из Египта передаются מִדּוֹר וָדוֹר.",
         fillInBlankExclusions = listOf(183601L, 183602L, 183604L, 183605L)),

        WordEntity(
            id = 183604, setId = 1836, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "time_l5_biblical",
            original = "יְמוֹת עוֹלָם", translation = "дни вечности, древние дни (Танах)",
            transliteration = "ймот олам",
            definition = "כִּנּוּי תַּנָּ\"כִי לְתוֹלְדוֹת עוֹלָם הַקְּדוּמוֹת — מִבְּרֵאשִׁית עַד לִתְקוּפַת הַנְּבִיאִים.",
            definitionNative = "Танахическое именование древнейшей истории мира — от сотворения до эпохи пророков.",
            example = "הִיא לִמְּדָה אֶת תַּלְמִידֶיהָ זְכֹר יְמוֹת עוֹלָם.",
            exampleNative = "Она наставляла учеников: помни יְמוֹת עוֹלָם.",
         fillInBlankExclusions = listOf(183601L, 183602L, 183603L, 183605L, 183607L, 183610L, 183611L, 183612L, 183613L, 183614L, 183615L, 183619L, 183620L, 183624L, 183625L)),

        WordEntity(
            id = 183605, setId = 1836, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "time_l5_biblical",
            original = "אַחֲרִית הָעוֹלָם", translation = "конец мира, эсхатологическое время",
            transliteration = "ахарит hа-олам",
            definition = "תְּקוּפַת סוֹף הַזְּמַנִּים בַּמַּחְשָׁבָה הַדָּתִית — לְפָנֶיהָ קוֹרוֹת מַהְפֵּכוֹת קוֹסְמִיּוֹת.",
            definitionNative = "Период конца времён в религиозной мысли — ему предшествуют космические потрясения.",
            example = "הַחֲזוֹן עוֹסֵק בְּמַה שֶּׁיִּקְרֶה בְּאַחֲרִית הָעוֹלָם.",
            exampleNative = "Видение посвящено тому, что случится в אַחֲרִית הָעוֹלָם.",
         fillInBlankExclusions = listOf(183601L, 183602L, 183603L, 183604L)),

        // ── time_l5_poetic (5) — поэтические образы времени ──────────────

        WordEntity(
            id = 183606, setId = 1836, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "time_l5_poetic",
            original = "שָׁעוֹן הַחֹל", translation = "песочные часы (поэт. символ ускользающего времени)",
            transliteration = "шаон hа-холь",
            definition = "מַכְשִׁיר עַתִּיק שֶׁבּוֹ חוֹל זוֹרֵם מִצַּד אֶחָד לַשֵּׁנִי — סֵמֶל סִפְרוּתִי לִזְמַן שֶׁאוֹזֵל.",
            definitionNative = "Древний прибор, в котором песок пересыпается из одной части в другую — литературный символ убывающего времени.",
            example = "הַסּוֹפֵר תֵּאֵר אֶת הַחַיִּים כְּשָׁעוֹן הַחֹל הַמִּתְרוֹקֵן.",
            exampleNative = "Писатель уподоблял жизнь שָׁעוֹן הַחֹל, что пустеет в тишине.",
         fillInBlankExclusions = listOf(183607L, 183608L, 183609L, 183610L)),

        WordEntity(
            id = 183607, setId = 1836, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "time_l5_poetic",
            original = "רִקְמַת הַזְּמַן", translation = "ткань времени (поэт.)",
            transliteration = "рикмат hа-зман",
            definition = "מֵטָפוֹרָה שִׁירִית לְמִרְקָם הָאֵרוּעִים שֶׁמִּשְׁתַּזְּרִים זֶה בָּזֶה לְאֹרֶךְ הַשָּׁנִים.",
            definitionNative = "Поэтическая метафора для узора событий, что переплетаются друг с другом сквозь годы.",
            example = "הָרוֹמָן חוֹשֵׂף אֶת רִקְמַת הַזְּמַן שֶׁל מִשְׁפָּחָה שְׁלֵמָה.",
            exampleNative = "Роман обнажает רִקְמַת הַזְּמַן целой семьи.",
         fillInBlankExclusions = listOf(183601L, 183602L, 183604L, 183606L, 183608L, 183609L, 183610L, 183611L, 183612L, 183614L, 183615L, 183619L, 183620L, 183624L, 183625L)),

        WordEntity(
            id = 183608, setId = 1836, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "time_l5_poetic",
            original = "חוּג הַחַמָּה", translation = "солнечный круг, годовой круговорот (поэт.)",
            transliteration = "хуг hа-хама",
            definition = "בִּטּוּי שִׁירִי לְמַסְלוּל הַשֶּׁמֶשׁ עַל פְּנֵי הָרָקִיעַ בְּמֶשֶׁךְ הַשָּׁנָה — סֵמֶל מַחֲזוֹרִיּוּת.",
            definitionNative = "Поэтическое выражение для пути солнца по небу в течение года — символ цикличности.",
            example = "הָעוֹבֵד הָאֲדָמָה חַי לְפִי חוּג הַחַמָּה.",
            exampleNative = "Земледелец живёт по חוּג הַחַמָּה.",
         fillInBlankExclusions = listOf(183606L, 183607L, 183609L, 183610L, 183625L)),

        WordEntity(
            id = 183609, setId = 1836, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "time_l5_poetic",
            original = "תּוֹחֶלֶת חַיִּים", translation = "продолжительность жизни (выс. лексика)",
            transliteration = "тохэлет хаим",
            definition = "מִשְׁךְ הַזְּמַן הַמְצֻפֶּה שֶׁבּוֹ אָדָם חַי — מוּשָׂג סְטָטִיסְטִי וּפִילוֹסוֹפִי כְּאַחַד.",
            definitionNative = "Срок, который человеку, как ожидается, отведено прожить — категория и статистическая, и философская.",
            example = "תּוֹחֶלֶת הַחַיִּים בְּעוֹלָם הַמַּעֲרָב גְּדֵלָה לְאַט.",
            exampleNative = "תּוֹחֶלֶת חַיִּים в западном мире медленно растёт.",
        ),

        WordEntity(
            id = 183610, setId = 1836, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "time_l5_poetic",
            original = "נֵר תָּמִיד", translation = "вечный огонь, неугасимая лампада",
            transliteration = "нэр тамид",
            definition = "אוֹר שֶׁדּוֹלֵק לְלֹא הֶפְסֵק בְּבֵית הַכְּנֶסֶת אוֹ עַל קֶבֶר — סֵמֶל לְזִכָּרוֹן נִצְחִי.",
            definitionNative = "Свет, что горит без перерыва в синагоге или над могилой — символ вечной памяти.",
            example = "הַנֵּר תָּמִיד שֶׁבְּאֻלַּם הַיִּזְכֹּר דָּלַק לִכְבוֹד הַחַלָלִים.",
            exampleNative = "נֵר תָּמִיד в зале памяти горел в честь павших.",
        ),

        // ── time_l5_philosophy (5) — философские категории времени ──────

        WordEntity(
            id = 183611, setId = 1836, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "time_l5_philosophy",
            original = "אַל-זְמַן", translation = "вневременность (филос.)",
            transliteration = "аль-зман",
            definition = "מַצָּב מַחְשַׁבְתִּי אוֹ מֵטָאפִיזִי שֶׁבּוֹ זְמַן אֵינוֹ פּוֹעֵל כְּלָל — מֵעֵבֶר לְהַתְחָלָה וְסוֹף.",
            definitionNative = "Состояние мысли или метафизики, в котором время вовсе не действует — за пределами начала и конца.",
            example = "מִיסְטִיקָנִים תֵּאֲרוּ חֲוָיַת אַל-זְמַן בִּזְמַן הַתְּפִלָּה.",
            exampleNative = "Мистики описывали переживание אַל-זְמַן в час молитвы.",
         fillInBlankExclusions = listOf(183601L, 183602L, 183604L, 183605L, 183608L, 183610L, 183612L, 183613L, 183614L, 183615L, 183619L, 183620L, 183624L)),

        WordEntity(
            id = 183612, setId = 1836, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "time_l5_philosophy",
            original = "הַוֶּה מָתְמִיד", translation = "вечное настоящее (филос.)",
            transliteration = "hовэ матмид",
            definition = "מוּשָׂג פִילוֹסוֹפִי שֶׁל רֶגַע נִצְחִי שֶׁאֵינוֹ חוֹלֵף — בָּסִיס לְמַחְשַׁבְתָּם שֶׁל מִיסְטִיקָנִים וְהוֹגִים.",
            definitionNative = "Философское понятие вечного, не уходящего мгновения — основа размышлений мистиков и философов.",
            example = "הַסְּפַרְדִּי הִסְבִּיר אֶת הָאֱלוֹהוּת בְּמֻשַּׂג הַהַוֶּה הַמָּתְמִיד.",
            exampleNative = "Сефардский мудрец толковал божество через הַוֶּה מָתְמִיד.",
        ),

        WordEntity(
            id = 183613, setId = 1836, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "time_l5_philosophy",
            original = "סוֹף עוֹלָם", translation = "конец света (филос./литер.)",
            transliteration = "соф олам",
            definition = "תַּפִיסָה שֶׁל גְּמַר הַמְּצִיאוּת הַמֻּכֶּרֶת — נוֹשֵׂא מֶרְכָּזִי בְּפִילוֹסוֹפְיָה, בְּדָת וּבַסִּפְרוּת.",
            definitionNative = "Представление о завершении известной реальности — центральная тема в философии, религии и литературе.",
            example = "הַסֵּפֶר עוֹסֵק בְּדִמְיוּן שֶׁל סוֹף עוֹלָם וְלֵדָתוֹ מֵחָדָשׁ.",
            exampleNative = "Книга трактует образ סוֹף עוֹלָם и нового рождения мира.",
         fillInBlankExclusions = listOf(183601L, 183604L, 183605L, 183607L, 183611L, 183612L, 183614L, 183615L, 183619L, 183625L)),

        WordEntity(
            id = 183614, setId = 1836, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "time_l5_philosophy",
            original = "מְצִיאוּת חוֹלֶפֶת", translation = "преходящая реальность (филос.)",
            transliteration = "мециут холэфэт",
            definition = "תַּפִיסָה פִילוֹסוֹפִית שֶׁכָּל מַה שֶּׁקַּיָּם בָּעוֹלָם הַזֶּה הוּא זְמַנִּי וְלֹא קָבוּעַ.",
            definitionNative = "Философское воззрение, что всё существующее в этом мире преходяще и не постоянно.",
            example = "הָרַב דִּבֵּר עַל הַמְּצִיאוּת הַחוֹלֶפֶת מוּל הָעוֹלָם הַבָּא.",
            exampleNative = "Раввин говорил о מְצִיאוּת חוֹלֶפֶת в противовес миру грядущему.",
        ),

        WordEntity(
            id = 183615, setId = 1836, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "time_l5_philosophy",
            original = "הִשְׁתַּלְשְׁלוּת", translation = "цепь причин, каузальная преемственность",
            transliteration = "hиштальшэлут",
            definition = "תַּהֲלִיךְ הַתְפַּתְּחוּת שֶׁבּוֹ אֵרוּעַ אֶחָד גּוֹרֵר אַחֲרָיו אֶת הַבָּא — מוּשָׂג קַבָּלִי וְהִיסְטוֹרִי.",
            definitionNative = "Процесс развёртывания, в котором одно событие влечёт следующее — понятие каббалистическое и историческое.",
            example = "הַחוֹקֵר הִתְחַקָּה אַחַר הִשְׁתַּלְשְׁלוּת הָאֵרוּעִים מֵהַמֵּאָה הַשְּׁמוֹנֶה-עֶשְׂרֵה.",
            exampleNative = "Исследователь прослеживал הִשְׁתַּלְשְׁלוּת событий с восемнадцатого века.",
         fillInBlankExclusions = listOf(183607L, 183611L, 183612L, 183613L, 183614L)),

        // ── time_l5_archaic_units (5) — архаичные единицы и обороты ─────

        WordEntity(
            id = 183616, setId = 1836, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "time_l5_archaic_units",
            original = "זְמַן רַב", translation = "долгое время, давно (книжн.)",
            transliteration = "зман рав",
            definition = "בִּטּוּי סִפְרוּתִי לִתְקוּפָה אֲרֻכָּה שֶׁעָבְרָה — נֶחְשָׁב גָּבוֹהַּ יוֹתֵר מֵ«הַרְבֵּה זְמַן».",
            definitionNative = "Литературное выражение для долгого минувшего срока — стилистически выше, чем «много времени».",
            example = "זְמַן רַב לֹא שָׁמַע מִמֶּנּוּ דָּבָר וַחֲצִי דָּבָר.",
            exampleNative = "זְמַן רַב он не имел от него ни весточки, ни полслова.",
         fillInBlankExclusions = listOf(183602L, 183617L, 183618L, 183619L, 183620L)),

        WordEntity(
            id = 183617, setId = 1836, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "time_l5_archaic_units",
            original = "רֶגַע אַחַר", translation = "следующее мгновение (литер.)",
            transliteration = "рэга ахэр",
            definition = "בִּטּוּי סִפְרוּתִי לִנְקוּדַת זְמַן הַמַּגִּיעָה מִיָּד אַחֲרֵי הָרֶגַע הַנּוֹכְחִי, בְּהֶקְשֵׁר דְּרָמָתִי.",
            definitionNative = "Литературное обозначение точки времени, что наступает сразу после нынешней, в драматическом контексте.",
            example = "רֶגַע אַחַר וְהָעוֹלָם כֻּלּוֹ שׁוּב לֹא הָיָה כְּמוֹ קֹדֶם.",
            exampleNative = "רֶגַע אַחַר — и весь мир уже не был прежним.",
         fillInBlankExclusions = listOf(183601L, 183602L, 183616L, 183618L, 183619L, 183620L)),

        WordEntity(
            id = 183618, setId = 1836, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "time_l5_archaic_units",
            original = "תְּרֵי-עָשָׂר חֳדָשִׁים", translation = "двенадцать месяцев (арам./юрид.)",
            transliteration = "трэй-асар ходашим",
            definition = "צֵרוּף אֲרַמִּי-תַּלְמוּדִי הַמְּצַיֵּן שָׁנָה שְׁלֵמָה — מוֹפִיעַ בְּהֶקְשֵׁר הִלְכָתִי וּמִשְׁפָּטִי.",
            definitionNative = "Арамейско-талмудическое словосочетание, обозначающее полный год — встречается в галахических и юридических контекстах.",
            example = "אַחֲרֵי תְּרֵי-עָשָׂר חֳדָשִׁים נֶהֱפַךְ הַחוֹב לְהֶפְקֵר.",
            exampleNative = "По прошествии תְּרֵי-עָשָׂר חֳדָשִׁים долг становится беспризорным.",
         fillInBlankExclusions = listOf(183608L, 183616L, 183617L, 183619L, 183620L)),

        WordEntity(
            id = 183619, setId = 1836, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "time_l5_archaic_units",
            original = "עֶבֶר רָחוֹק", translation = "далёкое прошлое (литер.)",
            transliteration = "эвэр рахок",
            definition = "תְּקוּפָה שֶׁהִתְרַחֲשָׁה הַרְבֵּה זְמַן לִפְנֵי הַהוֹוֶה — מַתָּאֵם לְזִכְרוֹנוֹת קְמוּטֵי שָׁנִים.",
            definitionNative = "Эпоха, что миновала задолго до нынешнего часа — соответствует выцветшим от лет воспоминаниям.",
            example = "כָּל מַה שֶּׁקָּרָה אָז שַׁיָּךְ כְּבָר לְעֶבֶר רָחוֹק.",
            exampleNative = "Всё, что тогда случилось, отошло уже в עֶבֶר רָחוֹק.",
         fillInBlankExclusions = listOf(183616L, 183617L, 183618L, 183620L)),

        WordEntity(
            id = 183620, setId = 1836, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "time_l5_archaic_units",
            original = "עָתִיד נֶצַח", translation = "вечное будущее (литер.)",
            transliteration = "атид нэцах",
            definition = "צֵרוּף שִׁירִי לְמֶרְחָב הַזְּמַן שֶׁאַחֲרֵי כָּל הַזְּמַנִּים הַמְצֻפִּים — סֵמֶל לְתִקְוָה אֵין-סוֹפִית.",
            definitionNative = "Поэтическое словосочетание для пространства времени за пределами всех ожидаемых сроков — символ бесконечной надежды.",
            example = "הַמְּשׁוֹרֵר הִבְטִיחַ לִידִידָיו עָתִיד נֶצַח שֶׁל אַחֲוָה.",
            exampleNative = "Поэт обещал друзьям עָתִיד נֶצַח братской дружбы.",
         fillInBlankExclusions = listOf(183602L, 183604L, 183607L, 183610L, 183611L, 183612L, 183614L, 183616L, 183617L, 183618L, 183619L, 183624L, 183625L)),

        // ── time_l5_descriptive (5) — литературные эпитеты времени ──────

        WordEntity(
            id = 183621, setId = 1836, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "adjective", semanticGroup = "time_l5_descriptive",
            original = "קַדְמוֹן", translation = "древний, изначальный (книжн./Танах.)",
            transliteration = "кадмон",
            definition = "שֶׁנּוֹעַד אוֹ נִבְרָא בָּרֵאשִׁית — תֹּאַר סִפְרוּתִי לְמַה שֶּׁקַּיָּם מֵרֵאשִׁית הַדּוֹרוֹת.",
            definitionNative = "Тот, что предназначен или сотворён в самом начале — литературный эпитет для существующего от первоистоков.",
            example = "הַחָכְמָה הַקַּדְמוֹנָה שֶׁל הָאָבוֹת נִשְׁמְרָה בִּכְתָבִים גְּנוּזִים.",
            exampleNative = "קַדְמוֹנָה мудрость отцов сохранилась в сокрытых писаниях.",
        ),

        WordEntity(
            id = 183622, setId = 1836, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "adjective", semanticGroup = "time_l5_descriptive",
            original = "אַל-מָוֶת", translation = "бессмертный (поэт./филос.)",
            transliteration = "аль-мавэт",
            definition = "שֶׁאֵין הַמָּוֶת שׁוֹלֵט בּוֹ — בִּטּוּי שִׁירִי לִקְיוּם שֶׁאֵינוֹ פּוֹסֵק בְּגָוֵעַ הַגּוּף.",
            definitionNative = "Тот, над которым смерть невластна — поэтическое выражение для бытия, что не пресекается с гибелью тела.",
            example = "הָאָמָּן שָׁאַף לִיצֹר יְצִירָה אַל-מָוֶת שֶׁתִּשָּׁאֵר אַחֲרָיו.",
            exampleNative = "Художник стремился создать אַל-מָוֶת произведение, что переживёт его.",
         fillInBlankExclusions = listOf(183611L, 183621L, 183623L)),

        WordEntity(
            id = 183623, setId = 1836, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "adjective", semanticGroup = "time_l5_descriptive",
            original = "חוֹלֵף", translation = "преходящий, мимолётный (книжн.)",
            transliteration = "холэф",
            definition = "שֶׁאֵינוֹ מִתְקַיֵּם זְמַן רַב וְעוֹבֵר חִישׁ — תֹּאַר סִפְרוּתִי לְכָל מַה שֶּׁאֵינוֹ נִצְחִי.",
            definitionNative = "Тот, что недолго длится и быстро минует — литературный эпитет для всего, что невечно.",
            example = "תְּהִלָּה חוֹלֶפֶת אֵינָהּ מַחְלִיפָה אַהֲבַת אֲמֶת.",
            exampleNative = "חוֹלֶפֶת слава не заменит истинной любви.",
        ),

        WordEntity(
            id = 183624, setId = 1836, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "time_l5_descriptive",
            original = "נִצְחִיּוּת", translation = "вечность как качество, нескончаемость (выс. лексика)",
            transliteration = "ницхиют",
            definition = "תְּכוּנָה שֶׁל מַה שֶּׁמִּתְקַיֵּם בְּלִי גְּבוּל זְמַן — שֵׁם עֶצֶם מֻפְשָׁט בִּלְשׁוֹן גְּבוֹהָה.",
            definitionNative = "Свойство того, что существует без временного предела — отвлечённое существительное в высоком стиле.",
            example = "הָרוֹמָן עוֹסֵק בִּכְמִיהָה אֱנוֹשִׁית לִנְצִחִיּוּת.",
            exampleNative = "Роман посвящён человеческой жажде נִצְחִיּוּת.",
        ),

        WordEntity(
            id = 183625, setId = 1836, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "time_l5_descriptive",
            original = "רוּחַ הַזְּמַן", translation = "дух эпохи (литер./филос.)",
            transliteration = "руах hа-зман",
            definition = "מַעֲרֶכֶת הַתְּחוּשׁוֹת, הָרַעֲיוֹנוֹת וְהַסִּגְנוֹן הָאָפְיָנִיִּים לִתְקוּפָה הִיסְטוֹרִית מְסֻיֶּמֶת.",
            definitionNative = "Совокупность настроений, идей и стиля, характерных для определённой исторической эпохи.",
            example = "הַסּוֹפֵר תָּפַס בְּדִיּוּק אֶת רוּחַ הַזְּמַן שֶׁל שְׁנוֹת הַשִּׁשִּׁים.",
            exampleNative = "Писатель уловил רוּחַ הַזְּמַן шестидесятых годов.",
         fillInBlankExclusions = listOf(183607L, 183614L, 183615L, 183624L)),
    )
}
