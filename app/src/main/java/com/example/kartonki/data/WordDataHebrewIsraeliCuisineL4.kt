package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Кулинария Израиля", level 4 (B2-C1).
 * Один сет × 25 слов. setId = 1845 (продолжение L1 1842, L2 1843, L3 1844).
 *
 *  - 17 EPIC + 8 RARE (два смежных уровня C1 + B2, EPIC доминирует на L4).
 *  - 5 семантических групп по 5 слов:
 *      cuisine_l4_high_techniques  — продвинутые техники готовки (5)
 *      cuisine_l4_specialty_meat   — специализация по мясу (5)
 *      cuisine_l4_advanced_kosher  — продвинутый кашрут (5)
 *      cuisine_l4_food_industry    — пищевая промышленность (5)
 *      cuisine_l4_baking           — выпечка / хлебопечение (5)
 *  - Профессиональная и формальная лексика по теме «Кулинария Израиля»
 *    на иврите. Никудим везде (стандарт he-ru).
 *  - Все 25 слов проверены grep'ом по `original = "..."` против всех
 *    WordDataHebrew*.kt и не пересекаются с set 1842 (L1), 1843 (L2),
 *    1844 (L3), Immigrant*, Aliya*, ReligionL1, Batch* и Cook/Barista.
 *    Замены из-за коллизий:
 *      • вместо סוּ-וִיד / סוֹ-וִי (Batch20, Batch64) — בִּשּׁוּל בְּוָקוּם
 *        (vacuum cooking) для группы high_techniques.
 *      • вместо פְלַמְבֶּה (CookL4 имеет פְלָמְבֶּה) — גָּסְטְרוֹנוֹמְיָה
 *        מוֹלֵקוּלָרִית (молекулярная гастрономия).
 *      • вместо קוֹנְפִי (Batch20) — טִיגּוּן עָמֹק (фритюр) как
 *        продвинутая техника.
 *      • вместо אֶמוּלְסְיָה (Batch20, Batch45) — קֶצֶף קוּלִינָרִי
 *        (culinary foam, авангардная техника).
 *      • вместо שְׁחִיטָה / שׁוֹחֵט (Immigrant6) — כַּשְׁרוּת מַהְדְרִין
 *        (высший уровень кашрута) для kosher-группы.
 *      • вместо מַשְׁגִּיחַ (одиночное — Immigrant3, IsraeliCuisineL3)
 *        и בַּקָּרַת אֵיכוּת (Batch70) — מַשְׁגִּיחַ אֵיכוּת как
 *        специализированный фразовый термин.
 *      • вместо אֲרִיזָה (Batch63, Immigrant3, ShoppingL1L2L3) —
 *        אֲרִיזַת וָקוּם (вакуумная упаковка, индустриальный термин).
 *      • вместо מַצָּה (Batch10) и הַקְצָפָה (Batch45) выбраны другие
 *        baking-термины — לִישַׁת בָּצֵק и הַשְׁבָּחַת קֶמַח.
 *      • вместо דַּגְמָנוּת (двусмысленно — обычно «модельный бизнес»)
 *        — כָּשֵׁר לְפֶסַח как однозначный кашрутный термин.
 *  - Распределение rarity по группам: high_techniques 4E+1R,
 *    specialty_meat 3E+2R, advanced_kosher 4E+1R, food_industry 3E+2R,
 *    baking 3E+2R = 17 EPIC + 8 RARE.
 *  - fillInBlankExclusions / isFillInBlankSafe — не выставлены здесь;
 *    FILL_IN_BLANK pipeline инжектит их централизованно после wave.
 */
object WordDataHebrewIsraeliCuisineL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1845, languagePair = "he-ru", orderIndex = 1845,
            name = "Кулинария Израиля",
            description = "Продвинутые техники, мясо, кашрут, пищевая промышленность и выпечка",
            topic = "Кулинария Израиля", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── cuisine_l4_high_techniques (5) ───────────────────────────────
        WordEntity(
            id = 184501, setId = 1845, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cuisine_l4_high_techniques",
            original = "בִּשּׁוּל בְּוָקוּם", translation = "приготовление в вакууме (sous-vide)",
            transliteration = "бишуль бэ-вакум",
            definition = "שִׁיטַת בִּשּׁוּל אִטִּי שֶׁבָּהּ הַמַּצְרָךְ נֶאֱטָם בְּשַׂקִּית פְּלַסְטִיק וּמְבֻשָּׁל בְּמַיִם בְּטֶמְפֶּרָטוּרָה מְדֻיֶּקֶת.",
            definitionNative = "Метод медленной готовки, при которой продукт запаян в пакет и варится в воде при точной температуре.",
            example = "הַשֶּׁף הִכִין נֵתַח אַנְטְרִיקוֹט בְּבִשּׁוּל בְּוָקוּם בְּמֶשֶׁךְ שָׁעוֹת אֲרֻכּוֹת.",
            exampleNative = "Шеф приготовил кусок антрекота בְּבִשּׁוּל בְּוָקוּם в течение долгих часов.",
        ),
        WordEntity(
            id = 184502, setId = 1845, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cuisine_l4_high_techniques",
            original = "גָּסְטְרוֹנוֹמְיָה מוֹלֵקוּלָרִית", translation = "молекулярная гастрономия",
            transliteration = "гастрономйа мольекулярит",
            definition = "תְּחוּם קוּלִינָרִי מוֹדֶרְנִי הַמְשַׁלֵּב כִּימְיָה וּפִיזִיקָה לְשִׁנּוּי מִרְקָם וְצוּרָה שֶׁל מָזוֹן.",
            definitionNative = "Современное кулинарное направление, что соединяет химию и физику для изменения текстуры и формы блюда.",
            example = "הַמִּסְעָדָה הָאֲוַנְגַּרְדִּית מַגִּישָׁה מָנוֹת בְּגָסְטְרוֹנוֹמְיָה מוֹלֵקוּלָרִית.",
            exampleNative = "Авангардный ресторан подаёт блюда в стиле גָּסְטְרוֹנוֹמְיָה מוֹלֵקוּלָרִית.",
        ),
        WordEntity(
            id = 184503, setId = 1845, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cuisine_l4_high_techniques",
            original = "קֶצֶף קוּלִינָרִי", translation = "кулинарная пена (foam)",
            transliteration = "кэцэф кулинари",
            definition = "מִרְקָם אֲוִירִי שֶׁל רֹטֶב אוֹ צִיר עִם לֵצִיטִין הַמּוּגָשׁ עַל הַצַּלַּחַת בְּמִסְעָדוֹת שֶׁף.",
            definitionNative = "Воздушная текстура соуса или бульона с лецитином, что подаётся на тарелке в шеф-ресторанах.",
            example = "הַמָּנָה קֻשְּׁטָה בְּקֶצֶף קוּלִינָרִי שֶׁל פִּטְרִיּוֹת יַעַר.",
            exampleNative = "Блюдо было украшено קֶצֶף קוּלִינָרִי из лесных грибов.",
         fillInBlankExclusions = listOf(184501L, 184502L, 184504L, 184505L)),
        WordEntity(
            id = 184504, setId = 1845, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cuisine_l4_high_techniques",
            original = "פִּירֶה", translation = "пюре (протёртая масса)",
            transliteration = "пирэ",
            definition = "מַצְרָךְ מְעֻכָּךְ עַד לְמִרְקָם חָלָק וְאָחִיד בְּעֶזְרַת מוֹעֵךְ אוֹ מְעַבֵּד מָזוֹן.",
            definitionNative = "Продукт, протёртый до гладкой однородной массы при помощи толкушки или измельчителя.",
            example = "לְצַד הַדָּג הַשֶּׁף הִגִּישׁ פִּירֶה כְּרוּבִית בְּחֶמְאַת תְּרוּפוֹת.",
            exampleNative = "К рыбе шеф подал פִּירֶה из цветной капусты с травяным маслом.",
         fillInBlankExclusions = listOf(184503L)),
        WordEntity(
            id = 184505, setId = 1845, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cuisine_l4_high_techniques",
            original = "טִיגּוּן עָמֹק", translation = "глубокая обжарка во фритюре",
            transliteration = "тигун амок",
            definition = "שִׁיטַת בִּשּׁוּל בָּהּ הַמַּצְרָךְ טָבוּל לְגַמְרֵי בְּשֶׁמֶן רוֹתֵחַ עַד לִקְבִיעַת קְרוּם זָהֹב.",
            definitionNative = "Способ готовки, при котором продукт полностью погружён в кипящее масло до образования золотой корочки.",
            example = "פָלָאפֶל טוֹב מְקַבֵּל אֶת טַעֲמוֹ הַסּוֹפִי דַּוְקָא בְּטִיגּוּן עָמֹק.",
            exampleNative = "Хороший фалафель получает свой окончательный вкус именно в טִיגּוּן עָמֹק.",
         fillInBlankExclusions = listOf(184501L, 184502L, 184503L)),

        // ─── cuisine_l4_specialty_meat (5) ─────────────────────────────────
        WordEntity(
            id = 184506, setId = 1845, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cuisine_l4_specialty_meat",
            original = "קְצִיצָה", translation = "котлета (мясная)",
            transliteration = "кцица",
            definition = "כַּדּוּר אוֹ דִּסְקִית שֶׁל בָּשָׂר טָחוּן עִם תַּבְלִינִים הַמְּטֻגָּן אוֹ הַמְבֻשָּׁל בְּרֹטֶב.",
            definitionNative = "Шарик или круглая лепёшка из фарша с приправами, что обжаривается или варится в соусе.",
            example = "אִמָּא הִכִינָה קְצִיצָה בְּרֹטֶב עַגְבָנִיּוֹת לְאֲרוּחַת שִׁשִּׁי.",
            exampleNative = "Мама приготовила קְצִיצָה в томатном соусе на пятничный обед.",
         fillInBlankExclusions = listOf(184507L, 184508L, 184509L, 184510L)),
        WordEntity(
            id = 184507, setId = 1845, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cuisine_l4_specialty_meat",
            original = "שִׁפּוּד", translation = "шампур; шашлык на шампуре",
            transliteration = "шипуд",
            definition = "מוֹט מַתֶּכֶת אוֹ עֵץ שֶׁעָלָיו מַשְׁחִילִים נְתָחֵי בָּשָׂר אוֹ יְרָקוֹת לִצְלִיָּה.",
            definitionNative = "Металлический или деревянный стержень, на который нанизывают куски мяса или овощей для жарки.",
            example = "בַּמַּנְגָּל שָׂמְנוּ שִׁפּוּד שֶׁל לֵב עוֹף עִם בָּצָל וְשׁוּם.",
            exampleNative = "На мангал мы положили שִׁפּוּד из куриных сердец с луком и чесноком.",
         fillInBlankExclusions = listOf(184506L, 184508L, 184509L, 184510L)),
        WordEntity(
            id = 184508, setId = 1845, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cuisine_l4_specialty_meat",
            original = "שְׁווָארְמָה", translation = "шаурма (мясо с вертикального вертела)",
            transliteration = "шаварма",
            definition = "בָּשָׂר מְתֻבָּל הַנִּצְלֶה עַל שִׁפּוּד אֲנָכִי וְנֶחְתָּךְ בִּפְרוּסוֹת דַּקּוֹת לְהַגָּשָׁה בְּפִיתָה.",
            definitionNative = "Маринованное мясо, что жарится на вертикальном вертеле и срезается тонкими ломтями для подачи в пите.",
            example = "הוּא עוֹמֵד מֵאָחוֹרֵי דּוּכַן שְׁווָארְמָה בִּשְׁכוּנַת הַתִּקְוָה כְּבָר עֶשְׂרִים שָׁנָה.",
            exampleNative = "Он стоит за стойкой שְׁווָארְמָה в районе Тиква уже двадцать лет.",
         fillInBlankExclusions = listOf(184506L, 184507L, 184509L, 184510L)),
        WordEntity(
            id = 184509, setId = 1845, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cuisine_l4_specialty_meat",
            original = "פְּלַנְצְ'ָה", translation = "плитa-плансья (горячая плита для жарки)",
            transliteration = "планча",
            definition = "מִשְׁטָח מַתֶּכֶת חַם וְשָׁטוּחַ לִצְלִיָּה מְהִירָה שֶׁל בָּשָׂר וִירָקוֹת בְּמִטְבַּח מִקְצוֹעִי.",
            definitionNative = "Горячая плоская металлическая поверхность для быстрой жарки мяса и овощей на профессиональной кухне.",
            example = "הַשֶּׁף צָלָה אֶת הָאַנְטְרִיקוֹט עַל פְּלַנְצְ'ָה לוֹהֶטֶת בְּשָׁלוֹשׁ דַּקּוֹת.",
            exampleNative = "Шеф зажарил антрекот на раскалённой פְּלַנְצְ'ָה за три минуты.",
         fillInBlankExclusions = listOf(184506L, 184507L, 184508L, 184510L)),
        WordEntity(
            id = 184510, setId = 1845, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cuisine_l4_specialty_meat",
            original = "קֶבָּב", translation = "кебаб (рубленое мясо на углях)",
            transliteration = "кебаб",
            definition = "בָּשָׂר טָחוּן עִם פֶּטְרוֹזִילְיָה, בָּצָל וְתַבְלִינִים הַמְעֻצָּב עַל שִׁפּוּד וְנִצְלֶה עַל גֶּחָלִים.",
            definitionNative = "Фарш с петрушкой, луком и приправами, который формируют на шампуре и жарят на углях.",
            example = "הַסְּעוּדָה כָּלְלָה קֶבָּב טָרִי עִם סָלָט יְרֻקִּים וְטַחִינָה.",
            exampleNative = "Трапеза включала свежий קֶבָּב с зелёным салатом и тхиной.",
         fillInBlankExclusions = listOf(184506L, 184507L, 184508L, 184509L)),

        // ─── cuisine_l4_advanced_kosher (5) ────────────────────────────────
        WordEntity(
            id = 184511, setId = 1845, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cuisine_l4_advanced_kosher",
            original = "מַעְבֻּדָה", translation = "лаборатория (кашрутный контроль)",
            transliteration = "маабада",
            definition = "מָקוֹם בְּמִפְעַל שֶׁבּוֹ בּוֹדְקִים מַרְכִּיבִים וּמְזוֹנוֹת לִקְבִיעַת הַתְאָמַת הַכַּשְׁרוּת.",
            definitionNative = "Помещение на заводе, где проверяют ингредиенты и продукты для определения соответствия кашруту.",
            example = "כָּל אַצְוָוה שֶׁל אַבְקַת חָלָב עוֹבֶרֶת בְּדִיקָה בְּמַעְבֻּדָה לִפְנֵי מַתַּן הַתְּעוּדָה.",
            exampleNative = "Каждая партия сухого молока проходит проверку в מַעְבֻּדָה до выдачи сертификата.",
        ),
        WordEntity(
            id = 184512, setId = 1845, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cuisine_l4_advanced_kosher",
            original = "הַכְשָׁרַת כֵּלִים", translation = "кашерование посуды",
            transliteration = "hахшарат келим",
            definition = "תַּהֲלִיךְ הֲלָכָתִי שֶׁל הַטְבָּלָה וּמַיִם רוֹתְחִים לְהַפְּכַת כְּלִי לְכָשֵׁר לְשִׁמּוּשׁ.",
            definitionNative = "Галахический процесс погружения и кипячения, что делает посуду пригодной для кошерного использования.",
            example = "לִפְנֵי פֶּסַח עוֹשִׂים הַכְשָׁרַת כֵּלִים שֶׁל סִירִים וּמַחְבָּתוֹת בְּמַיִם רוֹתְחִים.",
            exampleNative = "Перед Песахом делают הַכְשָׁרַת כֵּלִים кастрюль и сковород в кипящей воде.",
         fillInBlankExclusions = listOf(184514L, 184515L)),
        WordEntity(
            id = 184513, setId = 1845, languagePair = "he-ru", rarity = "EPIC",
            pos = "adjective", semanticGroup = "cuisine_l4_advanced_kosher",
            original = "פְּסוּלָה", translation = "негодная, некошерная (о пище)",
            transliteration = "псула",
            definition = "אֹכֶל אוֹ מַצְרָךְ שֶׁאֵינוֹ מַתְאִים עַל פִּי הַהֲלָכָה וְאָסוּר לַאֲכִילָה.",
            definitionNative = "Еда или продукт, что не соответствует галахе и запрещён к употреблению.",
            example = "הָרַב פָּסַק שֶׁהָעוּגָה פְּסוּלָה בִּגְלַל מַרְכִּיב נִסְתָּר שֶׁל גֶּלָטִין.",
            exampleNative = "Раввин постановил, что торт פְּסוּלָה из-за скрытого ингредиента — желатина.",
        ),
        WordEntity(
            id = 184514, setId = 1845, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cuisine_l4_advanced_kosher",
            original = "כַּשְׁרוּת מַהְדְרִין", translation = "кашрут мехадрин (высший уровень)",
            transliteration = "кашрут меhадрин",
            definition = "רָמָה מַחְמִירָה שֶׁל כַּשְׁרוּת הַדּוֹרֶשֶׁת פִּקּוּחַ קָפֶה וְשִׁיטוֹת יִצּוּר מְדֻיָּקוֹת.",
            definitionNative = "Строжайший уровень кашрута, что требует тщательного надзора и точных методов производства.",
            example = "הַמִּסְעָדָה מַחְזִיקָה תְּעוּדַת כַּשְׁרוּת מַהְדְרִין מֵהָרַבָּנוּת הָרָאשִׁית.",
            exampleNative = "Ресторан имеет сертификат כַּשְׁרוּת מַהְדְרִין от Главного раввината.",
         fillInBlankExclusions = listOf(184512L, 184515L)),
        WordEntity(
            id = 184515, setId = 1845, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "cuisine_l4_advanced_kosher",
            original = "כָּשֵׁר לְפֶסַח", translation = "кошерное на Песах",
            transliteration = "кашер ле-Пэсах",
            definition = "מַצְרָךְ שֶׁאֵין בּוֹ חָמֵץ וְאֵין הוּא נִיצוֹר בְּמִתְקָנִים שֶׁעוֹבְדוּ בָּהֶם דְּגָנִים.",
            definitionNative = "Продукт, в котором нет хамеца и который не произведён на оборудовании, обрабатывавшем зерновые.",
            example = "בְּפֶסַח קוֹנִים רַק מוּצָרִים עִם תָּו כָּשֵׁר לְפֶסַח עַל הָאֲרִיזָה.",
            exampleNative = "На Песах покупают только продукты с пометкой כָּשֵׁר לְפֶסַח на упаковке.",
         fillInBlankExclusions = listOf(184512L, 184514L)),

        // ─── cuisine_l4_food_industry (5) ──────────────────────────────────
        WordEntity(
            id = 184516, setId = 1845, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cuisine_l4_food_industry",
            original = "תַּעֲשִׂיַּת מָזוֹן", translation = "пищевая промышленность",
            transliteration = "таасият мазон",
            definition = "עָנָף תַּעֲשִׂיָּה הַמְעַבֵּד חָמְרֵי גֶלֶם חַקְלָאִיִּים לְמוּצְרֵי מָזוֹן מוּכָנִים לִצְרִיכָה.",
            definitionNative = "Отрасль промышленности, что перерабатывает сельскохозяйственное сырьё в готовые продукты питания.",
            example = "תַּעֲשִׂיַּת הַמָּזוֹן בְּיִשְׂרָאֵל מַעֲסִיקָה רְבָבוֹת עוֹבְדִים וְיוֹצֵאת לַיְּצוּא.",
            exampleNative = "תַּעֲשִׂיַּת מָזוֹן в Израиле даёт работу десяткам тысяч и идёт на экспорт.",
        ),
        WordEntity(
            id = 184517, setId = 1845, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cuisine_l4_food_industry",
            original = "מַשְׁגִּיחַ אֵיכוּת", translation = "инспектор качества",
            transliteration = "машгиах эйхут",
            definition = "אִישׁ מִקְצוֹעַ הָאַחְרַאי לְבַקֵּר תַּהֲלִיכֵי יִצּוּר וּמוּצָרִים לְעֲמִידָה בְּתֶקֶן.",
            definitionNative = "Профессионал, отвечающий за проверку производственных процессов и продукции на соответствие стандарту.",
            example = "מַשְׁגִּיחַ אֵיכוּת עָצַר אֶת קַו הַיִּצּוּר אַחֲרֵי שֶׁמָּצָא חֲרִיגָה בִּטְעִימָה.",
            exampleNative = "מַשְׁגִּיחַ אֵיכוּת остановил линию после того, как нашёл отклонение при дегустации.",
         fillInBlankExclusions = listOf(184516L, 184518L, 184519L, 184520L)),
        WordEntity(
            id = 184518, setId = 1845, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cuisine_l4_food_industry",
            original = "תּוֹסְפֵי מָזוֹן", translation = "пищевые добавки",
            transliteration = "тосфэй мазон",
            definition = "חוֹמָרִים הַמּוּסָפִים לְמוּצְרֵי מָזוֹן לְשִׁפּוּר טַעַם, צֶבַע, מִרְקָם אוֹ אֹרֶךְ חַיֵּי מַדָּף.",
            definitionNative = "Вещества, что добавляют в продукты для улучшения вкуса, цвета, текстуры или срока годности.",
            example = "הַתָּו הָרֵכִיב מְפָרֵט אֶת כָּל תּוֹסְפֵי הַמָּזוֹן עִם מִסְפַּר אֵירוֹפִּי.",
            exampleNative = "Этикетка состава перечисляет все תּוֹסְפֵי מָזוֹן с европейским номером.",
        ),
        WordEntity(
            id = 184519, setId = 1845, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "cuisine_l4_food_industry",
            original = "חוֹמְרֵי שִׁמּוּר", translation = "консерванты",
            transliteration = "хомрэй шимур",
            definition = "תוֹסָפִים הַמְעַכְּבִים קִלְקוּל בִּגְלַל חַיְדַּקִּים אוֹ פִּטְרִיּוֹת וּמַאֲרִיכִים אֶת חַיֵּי הַמָּזוֹן.",
            definitionNative = "Добавки, что задерживают порчу из-за бактерий или плесени и продлевают срок жизни продукта.",
            example = "הַלֶּחֶם הַתַּעֲשִׂיָּתִי מַחְזִיק שָׁבוּעַ דַּוְקָא בִּזְכוּת חוֹמְרֵי שִׁמּוּר.",
            exampleNative = "Промышленный хлеб держится неделю именно благодаря חוֹמְרֵי שִׁמּוּר.",
         fillInBlankExclusions = listOf(184516L, 184517L, 184518L, 184520L)),
        WordEntity(
            id = 184520, setId = 1845, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "cuisine_l4_food_industry",
            original = "אֲרִיזַת וָקוּם", translation = "вакуумная упаковка",
            transliteration = "аризат вакум",
            definition = "שִׁיטַת אֲרִיזָה שֶׁבָּהּ הָאֲוִיר נִשְׁאָב מֵהַשַּׂקִּית לִפְנֵי הָאֲטִימָה לְהַאֲרָכַת חַיֵּי הַמַּדָּף.",
            definitionNative = "Способ упаковки, при котором воздух откачивается из пакета перед запайкой ради продления срока годности.",
            example = "הַבָּשָׂר נִשְׁמַר טָרִי שְׁבוּעַיִם בְּזְכוּת אֲרִיזַת וָקוּם בַּמְקָרֵר.",
            exampleNative = "Мясо сохраняется свежим две недели благодаря אֲרִיזַת וָקוּם в холодильнике.",
         fillInBlankExclusions = listOf(184516L, 184517L, 184518L, 184519L)),

        // ─── cuisine_l4_baking (5) ─────────────────────────────────────────
        WordEntity(
            id = 184521, setId = 1845, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cuisine_l4_baking",
            original = "שְׁמָרִים", translation = "дрожжи",
            transliteration = "шмарим",
            definition = "פִּטְרִיּוֹת חַד-תָּאִיּוֹת הַמַּתְפִּיחוֹת בָּצֵק עַל יְדֵי הַפְרָשַׁת פַּחְמָן דּוּ-חַמְצָנִי.",
            definitionNative = "Одноклеточные грибы, что поднимают тесто, выделяя углекислый газ при брожении.",
            example = "הַסַּפָּקָנוּ קָנִינוּ שְׁמָרִים טְרִיִּים בְּכִיכָּר לְכָל לֶחֶם הַשַּׁבָּת.",
            exampleNative = "Поставщик закупил свежие שְׁמָרִים на всю субботнюю выпечку.",
         fillInBlankExclusions = listOf(184522L, 184523L)),
        WordEntity(
            id = 184522, setId = 1845, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cuisine_l4_baking",
            original = "הַתְפָּחָה", translation = "расстойка (теста)",
            transliteration = "hатпаха",
            definition = "תַּהֲלִיךְ שֶׁבּוֹ הַבָּצֵק נָח בְּמָקוֹם חַם וְלָח כְּדֵי שֶׁיִּתְמַלֵּא אֲוִיר וְיִגְדַּל בִּנְפָחוֹ.",
            definitionNative = "Процесс, при котором тесто отдыхает в тёплом и влажном месте, чтобы наполниться воздухом и увеличиться в объёме.",
            example = "הַתְפָּחָה רִאשׁוֹנָה שֶׁל בָּצֵק חַלָּה אוֹרֶכֶת כְּשָׁעָה וָחֵצִי.",
            exampleNative = "Первая הַתְפָּחָה теста для халы длится примерно полтора часа.",
         fillInBlankExclusions = listOf(184521L, 184523L, 184524L)),
        WordEntity(
            id = 184523, setId = 1845, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cuisine_l4_baking",
            original = "עִיסָה", translation = "тесто; вязкая масса",
            transliteration = "иса",
            definition = "תַּעֲרֹבֶת סְמִיכָה שֶׁל קֶמַח וְנוֹזֵל לִפְנֵי הַתְפָּחָה אוֹ אֲפִיָּה הַנִּשְׁמֶרֶת רַכָּה וּגְמִישָׁה.",
            definitionNative = "Густая смесь муки с жидкостью до расстойки или выпечки, что остаётся мягкой и эластичной.",
            example = "הָעִיסָה שֶׁל הַפִּיתָה נֶחָה כָּל הַלַּיְלָה בַּמַּקְפִּיא לִפְנֵי הָאֲפִיָּה.",
            exampleNative = "עִיסָה для питы отдыхала всю ночь в холодильнике перед выпечкой.",
         fillInBlankExclusions = listOf(184521L, 184522L)),
        WordEntity(
            id = 184524, setId = 1845, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "cuisine_l4_baking",
            original = "לִישַׁת בָּצֵק", translation = "замес теста",
            transliteration = "лишат бацэк",
            definition = "פְּעֻלָּה יְדָנִית אוֹ מְכוֹנִית שֶׁל עִרְבּוּב חָזָק שֶׁל הַעִיסָה לְפִתּוּחַ הַגְּלוּטֵן וְמִרְקָם אֶחָד.",
            definitionNative = "Ручное или машинное действие интенсивного смешивания массы для развития глейтена и однородной текстуры.",
            example = "לִישַׁת בָּצֵק יָדָנִית אוֹרֶכֶת כְּעֶשֶׂר דַּקּוֹת עַד שֶׁהָעִיסָה הוֹפֶכֶת חֲלָקָה.",
            exampleNative = "Ручная לִישַׁת בָּצֵק длится около десяти минут, пока тесто не станет гладким.",
         fillInBlankExclusions = listOf(184522L, 184525L)),
        WordEntity(
            id = 184525, setId = 1845, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "cuisine_l4_baking",
            original = "הַשְׁבָּחַת קֶמַח", translation = "обогащение муки (улучшение)",
            transliteration = "hашбахат кемах",
            definition = "תּוֹסֶפֶת שֶׁל וִיטָמִינִים, מִינֵרָלִים אוֹ אֶנְזִימִים לַקֶּמַח לְשִׁפּוּר עֶרֶךְ תְּזוּנָתִי וּתְכוּנוֹת אֲפִיָּה.",
            definitionNative = "Добавление витаминов, минералов или ферментов в муку для улучшения пищевой ценности и хлебопекарных свойств.",
            example = "הַתֶּקֶן הַיִּשְׂרְאֵלִי מְחַיֵּב הַשְׁבָּחַת קֶמַח בְּחוּמְצָה פוֹלִית וּבַרְזֶל.",
            exampleNative = "Израильский стандарт обязывает הַשְׁבָּחַת קֶמַח фолиевой кислотой и железом.",
         fillInBlankExclusions = listOf(184524L)),
    )
}
