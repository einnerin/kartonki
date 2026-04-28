package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Внешность и тело", level 3 (B2-C1).
 * Один сет × 25 слов. setId = 1824.
 *
 *  - 18 RARE + 7 EPIC (2 смежных уровня — B2/C1).
 *  - 5 семантических групп по 5 слов:
 *      appearance_face_anatomy   — тонкая анатомия лица (линия волос,
 *                                  мочка, веко, ноздря, бровь)
 *      appearance_skeletal       — кости и суставы (ключица, костяшка,
 *                                  позвонок, челюсть, мышца/бицепс)
 *      appearance_body_shape     — типы фигуры (песочные часы,
 *                                  атлетический, миниатюрная, стройный/статный,
 *                                  точёная)
 *      appearance_skin_quality   — качество кожи (веснушчатый, прыщи,
 *                                  загорелый, оливковый, румяный)
 *      appearance_grooming_style — стиль и ухоженность (ухоженный,
 *                                  растрёпанный, опрятный, неряшливый,
 *                                  элегантный)
 *  - Никудим везде.
 *  - L1 (set 1822) занял базовые רֹאשׁ/יָד/רֶגֶל/אַף/פֶּה/אֹזֶן/שֵׁן/מֶצַח/
 *    אֶצְבַּע/כָּתֵף/גַּב/בֶּרֶךְ/מַרְפֵּק/צַוָּאר/סַנְטֵר/חִיּוּךְ — здесь не
 *    повторяются.
 *  - L2 (set 1823) занимает причёски/мимику/телосложение коренастое и
 *    т.п. — здесь не пересекаемся (анатомия костей, ноздря, веко,
 *    типы фигуры, кожа, стиль).
 *  - שֹׁרֶשׁ есть в Лингвистике как «корень слова», здесь как часть
 *    словосочетания שֹׁרֶשׁ הַשֵּׂעָר — допустимо политикой дублей
 *    (разные topic'и, разные значения).
 *  - isFillInBlankSafe / fillInBlankExclusions не задаём — defaults
 *    отработают, FILL_IN_BLANK pipeline зальёт сам.
 */
object WordDataHebrewAppearanceL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1824, languagePair = "he-ru", orderIndex = 1824,
            name = "Внешность и тело",
            description = "Анатомия лица, скелет, типы фигуры и стиль",
            topic = "Внешность и тело", level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── appearance_face_anatomy (5) ──────────────────────────────────
        WordEntity(
            id = 182401, setId = 1824, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "appearance_face_anatomy",
            original = "שֹׁרֶשׁ הַשֵּׂעָר", translation = "линия роста волос",
            transliteration = "шорэш hа-сэар",
            definition = "הַקַּו שֶׁבּוֹ הַשֵּׂעָר מַתְחִיל לִצְמֹחַ עַל הַמֶּצַח וְהָרֹאשׁ.",
            definitionNative = "Линия, по которой волосы начинают расти на лбу и голове.",
            example = "עִם הַשָּׁנִים שֹׁרֶשׁ הַשֵּׂעָר שֶׁלּוֹ נָסוֹג קְצָת אֲחוֹרָה.",
            exampleNative = "С годами שֹׁרֶשׁ הַשֵּׂעָר у него немного отступил назад.",
         fillInBlankExclusions = listOf(182402L, 182403L, 182404L, 182405L)),
        WordEntity(
            id = 182402, setId = 1824, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "appearance_face_anatomy",
            original = "תְּנוּךְ", translation = "мочка (уха)",
            transliteration = "тнух",
            definition = "הַחֵלֶק הַתַּחְתּוֹן הָרַךְ שֶׁל הָאֹזֶן — בּוֹ עוֹנְדִים עֲגִיל.",
            definitionNative = "Нижняя мягкая часть уха — в ней носят серёжку.",
            example = "הִיא עָנְדָה עָגִיל קָטָן זָהָב עַל הַתְּנוּךְ.",
            exampleNative = "Она надела маленькую золотую серёжку на תְּנוּךְ.",
        ),
        WordEntity(
            id = 182403, setId = 1824, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "appearance_face_anatomy",
            original = "עַפְעַף", translation = "веко",
            transliteration = "афаф",
            definition = "הָעוֹר הַדַּק שֶׁמְּכַסֶּה אֶת הָעַיִן כַּאֲשֶׁר עוֹצְמִים אוֹתָהּ.",
            definitionNative = "Тонкая кожа, которая закрывает глаз, когда его смыкают.",
            example = "יַתּוּשׁ עָקַץ אוֹתָהּ עַל הָעַפְעַף בְּמַהֲלַךְ הַלַּיְלָה.",
            exampleNative = "Комар укусил её в עַפְעַף в течение ночи.",
         fillInBlankExclusions = listOf(182401L, 182402L, 182404L, 182405L, 182406L)),
        WordEntity(
            id = 182404, setId = 1824, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "appearance_face_anatomy",
            original = "נְחִיר", translation = "ноздря",
            transliteration = "нхир",
            definition = "אֶחָד מִשְּׁנֵי הַפְּתָחִים בְּחֶלְקוֹ הַתַּחְתּוֹן שֶׁל הָאַף.",
            definitionNative = "Одно из двух отверстий в нижней части носа.",
            example = "הוּא נִפְנֵף נְחִיר אֶחָד כְּשֶׁהֵרִיחַ אֶת הַגְּבִינָה הַחֲרִיפָה.",
            exampleNative = "Он раздул один נְחִיר, почувствовав резкий запах сыра.",
         fillInBlankExclusions = listOf(182401L, 182402L, 182403L, 182405L)),
        WordEntity(
            id = 182405, setId = 1824, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "appearance_face_anatomy",
            original = "גַּבָּה", translation = "бровь",
            transliteration = "габа",
            definition = "פַּס שֵׂעָר מֵעַל הָעַיִן — מֵגֵן עָלֶיהָ מִזֵּעָה וּמֵאוֹר חָזָק.",
            definitionNative = "Полоска волос над глазом — защищает его от пота и яркого света.",
            example = "הוּא הֵרִים גַּבָּה אַחַת בְּתֵמָהוֹן כְּשֶׁשָּׁמַע אֶת הַחֲדָשׁוֹת.",
            exampleNative = "Он удивлённо приподнял одну גַּבָּה, услышав новость.",
         fillInBlankExclusions = listOf(182401L, 182402L, 182403L, 182404L)),

        // ─── appearance_skeletal (5) ──────────────────────────────────────
        WordEntity(
            id = 182406, setId = 1824, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "appearance_skeletal",
            original = "עֶצֶם הַבְּרִיחַ", translation = "ключица",
            transliteration = "эцэм hа-бриах",
            definition = "עֶצֶם אֲרֻכָּה וְדַקָּה בֵּין הַכָּתֵף לַגָּרוֹן — בּוֹלֶטֶת אֵצֶל רָזִים.",
            definitionNative = "Длинная тонкая кость от плеча к горлу — заметна у худых.",
            example = "הַשִּׂמְלָה הָאֵלֶגַנְטִית הִדְגִּישָׁה אֶת עֶצֶם הַבְּרִיחַ הָעֲדִינָה שֶׁלָּהּ.",
            exampleNative = "Элегантное платье подчёркивало её изящную עֶצֶם הַבְּרִיחַ.",
        ),
        WordEntity(
            id = 182407, setId = 1824, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "appearance_skeletal",
            original = "פֶּרֶק הָאֶצְבַּע", translation = "костяшка пальца",
            transliteration = "пэрэк hа-эцба",
            definition = "מָקוֹם בָּאֶצְבַּע שֶׁמִּתְכּוֹפֵף — בּוֹלֵט כְּשֶׁסּוֹגְרִים אֶגְרוֹף.",
            definitionNative = "Сустав на пальце, который сгибается — выступает при сжатом кулаке.",
            example = "הוּא חָבַט אֶת פֶּרֶק הָאֶצְבַּע בְּמַשְׁקוֹף הַדֶּלֶת וְצָעַק מִכְּאֵב.",
            exampleNative = "Он ударился פֶּרֶק הָאֶצְבַּע о косяк двери и вскрикнул от боли.",
         fillInBlankExclusions = listOf(182406L, 182408L, 182409L, 182410L)),
        WordEntity(
            id = 182408, setId = 1824, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "appearance_skeletal",
            original = "חֻלְיָה", translation = "позвонок",
            transliteration = "хулья",
            definition = "אַחַת הַעֲצָמוֹת הַקְּטַנּוֹת שֶׁמַּרְכִּיבוֹת אֶת עַמּוּד הַשִּׁדְרָה לְאֹרֶךְ הַגַּב.",
            definitionNative = "Одна из мелких костей, что складываются в позвоночник вдоль спины.",
            example = "הָרוֹפֵא בָּדַק כֹּל חֻלְיָה בְּזָהִירוּת אַחֲרֵי שֶׁנָּפַל מֵהַסּוּלָּם.",
            exampleNative = "Врач осторожно прощупал каждую חֻלְיָה после того, как он упал со стремянки.",
         fillInBlankExclusions = listOf(182406L, 182407L, 182409L, 182410L)),
        WordEntity(
            id = 182409, setId = 1824, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "appearance_skeletal",
            original = "לֶסֶת", translation = "челюсть",
            transliteration = "лэсэт",
            definition = "הָעֶצֶם הַמַּחֲזִיקָה אֶת הַשִּׁנַּיִם — זָזָה כְּשֶׁלּוֹעֲסִים אוֹ מְדַבְּרִים.",
            definitionNative = "Кость, которая держит зубы — двигается, когда жуют или говорят.",
            example = "הַלֶּסֶת הַתַּחְתּוֹנָה שֶׁלּוֹ צָנְחָה מֵרֹב הַפְתָּעָה.",
            exampleNative = "Его нижняя לֶסֶת отвисла от полной неожиданности.",
        ),
        WordEntity(
            id = 182410, setId = 1824, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "appearance_skeletal",
            original = "שְׁרִיר דּוּ-רָאשִׁי", translation = "бицепс",
            transliteration = "шрир ду-раши",
            definition = "הַשְּׁרִיר הָעָגֹל בְּחֵלֶק הַקִּדְמִי שֶׁל הַזְּרוֹעַ הָעֶלְיוֹנָה.",
            definitionNative = "Округлая мышца на передней части плеча выше локтя.",
            example = "הוּא הִדֵּק אֶת הַשְּׁרִיר דּוּ-רָאשִׁי בְּגַאֲוָה מוּל הַמַּרְאָה.",
            exampleNative = "Он гордо напряг שְׁרִיר דּוּ-רָאשִׁי перед зеркалом.",
        ),

        // ─── appearance_body_shape (5) ────────────────────────────────────
        WordEntity(
            id = 182411, setId = 1824, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "appearance_body_shape",
            original = "שָׁעוֹן חוֹל", translation = "фигура «песочные часы»",
            transliteration = "шаон холь",
            definition = "מִבְנֵה גּוּף עִם מָתְנַיִם צָרוֹת וִירֵכַיִם וּכְתֵפַיִם רְחָבוֹת יוֹתֵר.",
            definitionNative = "Тип фигуры с узкой талией и более широкими бёдрами и плечами.",
            example = "הַשִּׂמְלָה הַוִּינְטֵג' יָשְׁבָה עַל גּוּף הַשָּׁעוֹן חוֹל שֶׁלָּהּ בִּשְׁלֵמוּת.",
            exampleNative = "Винтажное платье село на её שָׁעוֹן חוֹל фигуру идеально.",
        ),
        WordEntity(
            id = 182412, setId = 1824, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "appearance_body_shape",
            original = "אַתְלֵטִי", translation = "атлетический",
            transliteration = "атлети",
            definition = "בַּעַל גּוּף חָזָק וּמְשֻׁכְלָל — כְּמוֹ שֶׁל מִי שֶׁמִּתְאַמֵּן בְּקֶבַע.",
            definitionNative = "С сильным и натренированным телом — как у регулярно занимающихся спортом.",
            example = "מִבְנֶה הַגּוּף הָאַתְלֵטִי שֶׁלָּהּ הוּא תּוֹצָאָה שֶׁל שָׁנִים שֶׁל שְׂחִיָּה.",
            exampleNative = "Её אַתְלֵטִי телосложение — результат многих лет плавания.",
         fillInBlankExclusions = listOf(182413L, 182414L, 182415L)),
        WordEntity(
            id = 182413, setId = 1824, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "appearance_body_shape",
            original = "זְעִירָה", translation = "миниатюрная",
            transliteration = "зэира",
            definition = "אִשָּׁה קְטַנָּה וַעֲדִינָה בְּמַבְנֵה גּוּפָהּ — נְמוּכָה וְדַקָּה.",
            definitionNative = "Маленькая и хрупкая женщина по сложению — невысокая и тонкая.",
            example = "הָאִשָּׁה הַזְּעִירָה נֶעֶזְרָה בְּשַׁרְפְּרַף כְּדֵי לְהַגִּיעַ לַמַּדָּף הָעֶלְיוֹן.",
            exampleNative = "זְעִירָה женщине пришлось встать на табурет, чтобы достать до полки.",
        ),
        WordEntity(
            id = 182414, setId = 1824, languagePair = "he-ru", rarity = "EPIC",
            pos = "adjective", semanticGroup = "appearance_body_shape",
            original = "תָּמִיר", translation = "стройный, статный",
            transliteration = "тамир",
            definition = "גָּבוֹהַּ וְזָקוּף בְּצוּרָה יָפָה — קַוִּים אֲרֻכִּים וִיצִיבָה מַרְשִׁימָה.",
            definitionNative = "Высокий и красиво выпрямленный — длинные линии и впечатляющая осанка.",
            example = "הָרַקְדָּן הַתָּמִיר חָצָה אֶת הַבִּימָה בִּצְעָדִים אֲרֻכִּים וְקַלִּים.",
            exampleNative = "תָּמִיר танцор пересёк сцену длинными лёгкими шагами.",
         fillInBlankExclusions = listOf(182412L, 182413L, 182415L, 182416L, 182418L, 182419L, 182420L, 182421L, 182423L)),
        WordEntity(
            id = 182415, setId = 1824, languagePair = "he-ru", rarity = "EPIC",
            pos = "adjective", semanticGroup = "appearance_body_shape",
            original = "חֲטוּבָה", translation = "точёная (фигура)",
            transliteration = "хатува",
            definition = "בַּעֲלַת גּוּף מְעֻצָּב וּשְׁרִירִי — קַוִּים בְּרוּרִים וְצוּרָה מַרְשִׁימָה.",
            definitionNative = "С хорошо очерченной мускулистой фигурой — чёткие линии и эффектная форма.",
            example = "אַחֲרֵי שָׁנָה בַּחֲדַר הַכֹּשֶׁר הִיא נִרְאֲתָה חֲטוּבָה וְחֲזָקָה.",
            exampleNative = "После года в спортзале она выглядела חֲטוּבָה и сильной.",
         fillInBlankExclusions = listOf(182412L, 182413L, 182414L)),

        // ─── appearance_skin_quality (5) ──────────────────────────────────
        WordEntity(
            id = 182416, setId = 1824, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "appearance_skin_quality",
            original = "מְנֻמָּשׁ", translation = "веснушчатый",
            transliteration = "мэнумаш",
            definition = "בַּעַל עוֹר מְכֻסֶּה בִּנְקֻדּוֹת חוּמוֹת קְטַנּוֹת — בְּדֶרֶךְ כְּלָל מֵהַשֶּׁמֶשׁ.",
            definitionNative = "С кожей, покрытой множеством мелких коричневых точек — обычно от солнца.",
            example = "הָאַף הַמְּנֻמָּשׁ שֶׁלָּהּ הִתְכַּסָּה בְּעוֹד נְקֻדּוֹת לְאַחַר שָׁבוּעַ עַל הַחוֹף.",
            exampleNative = "Её מְנֻמָּשׁ нос покрылся ещё бóльшим числом точек после недели на пляже.",
        ),
        WordEntity(
            id = 182417, setId = 1824, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "appearance_skin_quality",
            original = "פִּצְעוֹנִים", translation = "прыщи / угревая сыпь",
            transliteration = "пицъоним",
            definition = "פְּגָמִים אֲדַמְדַּמִּים קְטַנִּים עַל הָעוֹר — נְפוֹצִים אֵצֶל בְּנֵי נֹעַר.",
            definitionNative = "Маленькие красноватые высыпания на коже — частая проблема у подростков.",
            example = "הַפִּצְעוֹנִים הָעַקְשָׁנִיִּים שֶׁלָּהּ נֶעֶלְמוּ אַחֲרֵי חֻפְשַׁת הַקַּיִץ.",
            exampleNative = "Её упрямые פִּצְעוֹנִים прошли после летних каникул.",
        ),
        WordEntity(
            id = 182418, setId = 1824, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "appearance_skin_quality",
            original = "שָׁזוּף", translation = "загорелый",
            transliteration = "шазуф",
            definition = "בַּעַל עוֹר חוּם — אַחֲרֵי שֶׁבִּלָּה זְמַן רַב בַּשֶּׁמֶשׁ.",
            definitionNative = "С коричневой кожей — после долгого пребывания на солнце.",
            example = "הוּא חָזַר שָׁזוּף וְרָגוּעַ לְאַחַר שְׁבוּעַיִם בִּיוֹן.",
            exampleNative = "Он вернулся שָׁזוּף и отдохнувшим после двух недель в Греции.",
         fillInBlankExclusions = listOf(182414L, 182416L, 182419L, 182420L, 182421L)),
        WordEntity(
            id = 182419, setId = 1824, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "appearance_skin_quality",
            original = "זֵיתִי", translation = "оливковый (тон кожи)",
            transliteration = "зэйти",
            definition = "בַּעַל עוֹר בְּגָוֶן צָהֹב-חוּם בָּהִיר — אָפְיָנִי לְעַמֵּי הַיָּם הַתִּיכוֹן.",
            definitionNative = "С кожей светло-жёлто-коричневого оттенка — характерно для южан.",
            example = "גָּוֶן הָעוֹר הַזֵּיתִי שֶׁלָּהּ אַף פַּעַם לֹא נִשְׂרַף בַּשֶּׁמֶשׁ הַחֲזָקָה.",
            exampleNative = "Её זֵיתִי оттенок кожи никогда не обгорал на сильном солнце.",
        ),
        WordEntity(
            id = 182420, setId = 1824, languagePair = "he-ru", rarity = "EPIC",
            pos = "adjective", semanticGroup = "appearance_skin_quality",
            original = "סְמוּק", translation = "румяный",
            transliteration = "смук",
            definition = "בַּעַל לְחָיַיִם וְרֻדּוֹת-אֲדַמְדַּמּוֹת — בְּדֶרֶךְ כְּלָל מִקֹּר אוֹ מֵרוּחַ.",
            definitionNative = "С розово-красноватыми щеками — обычно от холода или ветра.",
            example = "הַחַקְלַאי חָזַר עִם פָּנִים סְמוּקוֹת לְאַחַר עֲבוֹדָה בְּקֹר עַז.",
            exampleNative = "Фермер вернулся с סְמוּק лицом после работы в сильный мороз.",
        ),

        // ─── appearance_grooming_style (5) ────────────────────────────────
        WordEntity(
            id = 182421, setId = 1824, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "appearance_grooming_style",
            original = "מְטֻפָּח", translation = "ухоженный",
            transliteration = "мэтупах",
            definition = "נִרְאֶה נָקִי וּמְסֻדָּר — שֵׂעָר, צִפָּרְנַיִם וּבְגָדִים בְּמַצָּב טוֹב.",
            definitionNative = "Выглядит чистым и опрятным — волосы, ногти и одежда в порядке.",
            example = "עוֹרֵךְ הַדִּין הַמְטֻפָּח הִגִּיעַ מֻקְדָּם לִפְגִישַׁת הַבֹּקֶר הַחֲשׁוּבָה.",
            exampleNative = "מְטֻפָּח юрист пришёл заранее на важную утреннюю встречу.",
         fillInBlankExclusions = listOf(182414L, 182416L, 182418L, 182419L, 182420L, 182422L, 182423L, 182424L, 182425L)),
        WordEntity(
            id = 182422, setId = 1824, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "appearance_grooming_style",
            original = "פָּרוּעַ", translation = "растрёпанный / лохматый",
            transliteration = "паруа",
            definition = "נִרְאֶה לֹא מְסֻדָּר — כְּמוֹ אַחֲרֵי שֵׁנָה, רוּחַ אוֹ מִהוּר.",
            definitionNative = "Выглядит неопрятно — будто после сна, ветра или спешки.",
            example = "הוּא הִגִּיעַ פָּרוּעַ לְגַמְרֵי לְאַחַר שֶׁרָץ בַּגֶּשֶׁם לַמִּשְׂרָד.",
            exampleNative = "Он явился совсем פָּרוּעַ после бега под дождём в офис.",
        ),
        WordEntity(
            id = 182423, setId = 1824, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "appearance_grooming_style",
            original = "מְסֻדָּר", translation = "опрятный",
            transliteration = "мэсудар",
            definition = "נִרְאֶה מְאֻרְגָּן וְנָקִי — כֹּל פְּרָט בְּמָקוֹם וּבְלִי בִּלְבּוּל.",
            definitionNative = "Выглядит организованным и аккуратным — каждая деталь на месте.",
            example = "הַתַּלְמִיד הַמְסֻדָּר הִגִּיעַ לַשִּׁעוּר עִם תִּיק נָקִי וְשֵׂעָר מְסֹרָק.",
            exampleNative = "מְסֻדָּר ученик пришёл на урок с чистым ранцем и причёсанными волосами.",
         fillInBlankExclusions = listOf(182414L, 182416L, 182418L, 182419L, 182420L, 182421L, 182422L, 182424L, 182425L)),
        WordEntity(
            id = 182424, setId = 1824, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "appearance_grooming_style",
            original = "מֻזְנָח", translation = "неряшливый / запущенный",
            transliteration = "музнах",
            definition = "נִרְאֶה לֹא מְטֻפָּל — בְּגָדִים יְשָׁנִים, שֵׂעָר לֹא מְסֹרָק, בְּלִי תְּשׂוּמַת לֵב.",
            definitionNative = "С запущенным видом — старая одежда, нечёсаные волосы, без ухода.",
            example = "הַסְּטוּדֶנְט הַמֻּזְנָח נִכְנַס לַשִּׁעוּר שׁוּב עִם אוֹתוֹ קַפּוּצ'וֹן.",
            exampleNative = "מֻזְנָח студент ввалился на пару опять в той же толстовке.",
        ),
        WordEntity(
            id = 182425, setId = 1824, languagePair = "he-ru", rarity = "EPIC",
            pos = "adjective", semanticGroup = "appearance_grooming_style",
            original = "הָדוּר", translation = "элегантный / щегольский",
            transliteration = "hадур",
            definition = "לָבוּשׁ בְּסִגְנוֹן מַרְשִׁים וּמְעֻדָּן — בְּדֶרֶךְ כְּלָל עַל גֶּבֶר.",
            definitionNative = "Одетый в эффектном изысканном стиле — обычно говорят о мужчине.",
            example = "הַגֶּבֶר הֶהָדוּר הֵרִים אֶת הַכּוֹבַע כְּשֶׁעָבַר לְיַד הַגְּבָרוֹת.",
            exampleNative = "הָדוּר джентльмен приподнял шляпу, проходя мимо дам.",
         fillInBlankExclusions = listOf(182421L, 182422L, 182423L, 182424L)),
    )
}
