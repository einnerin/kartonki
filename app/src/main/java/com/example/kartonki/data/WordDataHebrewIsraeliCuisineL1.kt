package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Кулинария Израиля", level 1 (A1-A2).
 * Один сет × 25 слов. setId = 1842.
 *
 *  - 18 COMMON + 7 UNCOMMON (2 смежных уровня).
 *  - 5 семантических групп по 5 слов:
 *      cuisine_l1_dishes      — фалафель, хумус, шакшука, бурекас, сабих (5)
 *      cuisine_l1_ingredients — тхина, нут, заатар, авокадо, мята (5)
 *      cuisine_l1_meals       — завтрак, ужин, шабатний ужин, чолент, перекус (5)
 *      cuisine_l1_actions     — есть, готовить, заказывать, пробовать, нарезать (5)
 *      cuisine_l1_places      — хумусия, фалафельная, деликатесная, рынок, ресторан (5)
 *  - Фокус на израильской/левантийской/еврейской кухне: фалафель, хумус,
 *    шакшука, бурекас, сабих, заатар, чолент. Базовые «хлеб/яблоко» — в
 *    Immigrant сетах, здесь специфика Израиля.
 *  - Никудим везде (стандарт he-ru). Огласовки в `example` ставятся только
 *    на целевом слове.
 *  - Несколько оригиналов (פָלָאפֶל, חוּמּוּס, שַׁקְשׁוּקָה, שׁוּק, מִסְעָדָה,
 *    לֶאֱכֹל, לְבַשֵּׁל) пересекаются с серией Aliya/Immigrant/Batch/City/Everyday —
 *    это другие темы («Алия и Израиль», «Еда и кулинария», «Город»),
 *    дубли в разных темах допустимы по политике
 *    (`docs/claude/feedback_duplicate_words_policy.md`). Без них L1
 *    «Кулинария Израиля» неполноценна — это корневой словарь израильской
 *    кухни, без которого тема пустая.
 */
object WordDataHebrewIsraeliCuisineL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1842, languagePair = "he-ru", orderIndex = 1842,
            name = "Кулинария Израиля",
            description = "Израильские блюда, ингредиенты и трапезы",
            topic = "Кулинария Израиля", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── cuisine_l1_dishes (5) ───────────────────────────────────────
        WordEntity(
            id = 184201, setId = 1842, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cuisine_l1_dishes",
            original = "פָלָאפֶל", translation = "фалафель",
            transliteration = "фалафель",
            definition = "כַּדּוּרִים מְטֻגָּנִים מֵחִמְצָה כְּתוּשָׁה — אֹכֶל רְחוֹב פּוֹפּוּלָרִי בָּאָרֶץ.",
            definitionNative = "Жареные шарики из молотого нута — популярная уличная еда в Израиле.",
            example = "אֲנִי קוֹנֶה פָלָאפֶל בַּפִּיתָה לְיַד הַתַּחֲנָה.",
            exampleNative = "Я покупаю פָלָאפֶל в пите рядом с автобусной станцией."
        , fillInBlankExclusions = listOf(184202L, 184203L, 184204L, 184205L, 184215L)),
        WordEntity(
            id = 184202, setId = 1842, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "cuisine_l1_dishes",
            original = "חוּמּוּס", translation = "хумус",
            transliteration = "хумус",
            definition = "מִמְרָח סָמִיךְ מֵחִמְצָה כְּתוּשָׁה עִם שֶׁמֶן וְלִמּוֹן — אֹכֶל לְאוּמִי.",
            definitionNative = "Густая паста из молотого нута с маслом и лимоном — национальная еда.",
            example = "מָרַחְתִּי חוּמּוּס עַל הַפִּיתָה לִפְנֵי הַסָּלָט.",
            exampleNative = "Я намазал חוּמּוּס на питу перед салатом на завтрак."
        , fillInBlankExclusions = listOf(184201L, 184203L, 184204L, 184205L, 184206L, 184208L, 184209L)),
        WordEntity(
            id = 184203, setId = 1842, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cuisine_l1_dishes",
            original = "שַׁקְשׁוּקָה", translation = "шакшука",
            transliteration = "шакшука",
            definition = "בֵּיצִים מְבֻשָּׁלוֹת בְּרֹטֶב עַגְבָנִיּוֹת חָרִיף — אֹכֶל בֹּקֶר אָהוּב.",
            definitionNative = "Яйца, тушёные в остром томатном соусе — любимый завтрак в Израиле.",
            example = "אִמָּא הֵכִינָה שַׁקְשׁוּקָה חַמָּה בַּמַּחֲבַת לַבֹּקֶר.",
            exampleNative = "Мама приготовила горячую שַׁקְשׁוּקָה на сковородке утром."
        , fillInBlankExclusions = listOf(184201L, 184202L, 184204L, 184205L, 184207L)),
        WordEntity(
            id = 184204, setId = 1842, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "cuisine_l1_dishes",
            original = "בּוּרֶקַס", translation = "бурекас",
            transliteration = "бурекас",
            definition = "מְאֻפֶּה מִבָּצֵק עָלִים עִם מִלּוּי גְּבִינָה אוֹ תַּפּוּחֵי אֲדָמָה.",
            definitionNative = "Слоёный пирожок с начинкой из сыра или картошки — типичная выпечка.",
            example = "קָנִיתִי בּוּרֶקַס חַם בַּמַּאֲפִיָּה לְיַד הַבַּיִת.",
            exampleNative = "Я купил горячий בּוּרֶקַס в пекарне рядом с домом утром."
        , fillInBlankExclusions = listOf(184201L, 184202L, 184203L, 184205L, 184215L)),
        WordEntity(
            id = 184205, setId = 1842, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cuisine_l1_dishes",
            original = "סָבִיח", translation = "сабих",
            transliteration = "сабих",
            definition = "פִּיתָה עִם חָצִיל מְטֻגָּן, בֵּיצָה קָשָׁה וִירָקוֹת — מָנָה עִירָאקִית.",
            definitionNative = "Пита с жареным баклажаном, варёным яйцом и овощами — иракское блюдо.",
            example = "בְּרָמַת גַּן יֵשׁ דּוּכָן סָבִיח מְפֻרְסָם בָּעוֹלָם.",
            exampleNative = "В Рамат-Гане есть знаменитый на весь мир ларёк с סָבִיח."
        , fillInBlankExclusions = listOf(184201L, 184202L, 184203L, 184204L)),

        // ─── cuisine_l1_ingredients (5) ──────────────────────────────────
        WordEntity(
            id = 184206, setId = 1842, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "cuisine_l1_ingredients",
            original = "טַחִינָה", translation = "тхина (соус)",
            transliteration = "тхина",
            definition = "מִמְרָח חָלָק מִזַּרְעֵי שֻׁמְשׁוּם טְחוּנִים עִם מַיִם וְלִמּוֹן.",
            definitionNative = "Гладкая паста из молотого кунжута, разведённая с водой и лимоном.",
            example = "יָצַקְתִּי טַחִינָה עַל הַפָלָאפֶל בַּצַּלַּחַת.",
            exampleNative = "Я полил טַחִינָה поверх фалафеля прямо в тарелке."
        , fillInBlankExclusions = listOf(184202L, 184207L, 184208L, 184209L, 184210L)),
        WordEntity(
            id = 184207, setId = 1842, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cuisine_l1_ingredients",
            original = "חִמְצָה", translation = "нут",
            transliteration = "химца",
            definition = "קִטְנִית עֲגֻלָּה צְהֻבָּה — הַבָּסִיס לְפָלָאפֶל וּלְחוּמּוּס.",
            definitionNative = "Жёлтый круглый боб — основа для фалафеля и для пасты хумус.",
            example = "הִשְׁרֵיתִי חִמְצָה בַּמַּיִם כָּל הַלַּיְלָה לִפְנֵי הַבִּשּׁוּל.",
            exampleNative = "Я замочил חִמְצָה в воде на всю ночь перед варкой."
        , fillInBlankExclusions = listOf(184206L, 184208L, 184209L, 184210L)),
        WordEntity(
            id = 184208, setId = 1842, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cuisine_l1_ingredients",
            original = "זַעְתַּר", translation = "заатар",
            transliteration = "заатар",
            definition = "תַּעֲרֹבֶת תְּבָלִין יְרֻקָּה מֵאֵזוֹב, שֻׁמְשׁוּם וּמֶלַח לְפִיתָה וְשֶׁמֶן.",
            definitionNative = "Зелёная смесь приправ из иссопа, кунжута и соли для питы с маслом.",
            example = "בְּצַד שֶׁל הַשֻּׁלְחָן הָיָה צַלַּחַת זַעְתַּר עִם שֶׁמֶן זַיִת.",
            exampleNative = "Сбоку на столе стояла тарелка זַעְתַּר с оливковым маслом."
        , fillInBlankExclusions = listOf(184202L, 184206L, 184207L, 184209L, 184210L)),
        WordEntity(
            id = 184209, setId = 1842, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "cuisine_l1_ingredients",
            original = "אֲבוֹקָדוֹ", translation = "авокадо",
            transliteration = "авокадо",
            definition = "פְּרִי יָרֹק שָׁמֵן עִם גַּלְעִין גָּדוֹל — מָרוּחַ עַל לֶחֶם בַּבֹּקֶר.",
            definitionNative = "Зелёный жирный плод с большой косточкой — мажут на хлеб с утра.",
            example = "מָרַחְתִּי אֲבוֹקָדוֹ עַל פְּרוּסַת לֶחֶם עִם מֶלַח.",
            exampleNative = "Я намазал אֲבוֹקָדוֹ на ломоть хлеба со щепоткой соли."
        ),
        WordEntity(
            id = 184210, setId = 1842, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "cuisine_l1_ingredients",
            original = "נַעֲנַע", translation = "мята",
            transliteration = "наанá",
            definition = "עָלֶה יָרֹק רֵיחָנִי שֶׁשָּׂמִים בַּתֵּה הַחַם וּבַסָּלָט.",
            definitionNative = "Зелёный пахучий лист, который кладут в горячий чай и в салат.",
            example = "הוֹסַפְתִּי נַעֲנַע טְרִיָּה לַסָּלָט הַיְּרָקוֹת.",
            exampleNative = "Я добавил свежую נַעֲנַע в овощной салат для аромата."
        , fillInBlankExclusions = listOf(184206L, 184207L, 184208L, 184209L)),

        // ─── cuisine_l1_meals (5) ────────────────────────────────────────
        WordEntity(
            id = 184211, setId = 1842, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "cuisine_l1_meals",
            original = "אֲרוּחַת בֹּקֶר", translation = "завтрак",
            transliteration = "арухат бокер",
            definition = "הָאֹכֶל הָרִאשׁוֹן בַּיּוֹם — בַּדֶּרֶךְ כְּלָל בֵּיצִים, גְּבִינָה וְקָפֶה.",
            definitionNative = "Первая еда дня — обычно яйца, сыр и кофе перед работой.",
            example = "אֲרוּחַת הַבֹּקֶר בַּמָּלוֹן הָיְתָה עֲשִׁירָה וּגְדוֹלָה.",
            exampleNative = "אֲרוּחַת בֹּקֶר в гостинице была богатой и большой."
        ),
        WordEntity(
            id = 184212, setId = 1842, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "cuisine_l1_meals",
            original = "אֲרוּחַת עֶרֶב", translation = "ужин",
            transliteration = "арухат эрев",
            definition = "הָאֹכֶל הָאַחֲרוֹן בַּיּוֹם — אַחֲרֵי הָעֲבוֹדָה אוֹ לִפְנֵי הַשֵּׁנָה.",
            definitionNative = "Последняя еда дня — после работы или перед сном для всей семьи.",
            example = "אָכַלְנוּ אֲרוּחַת עֶרֶב קַלָּה עִם סָלָט וְלֶחֶם.",
            exampleNative = "Мы ели лёгкий אֲרוּחַת עֶרֶב с салатом и хлебом."
        , fillInBlankExclusions = listOf(184211L, 184213L, 184214L, 184215L)),
        WordEntity(
            id = 184213, setId = 1842, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "cuisine_l1_meals",
            original = "אֲרוּחַת שַׁבָּת", translation = "шабатний ужин",
            transliteration = "арухат шабат",
            definition = "אֲרוּחָה חֲגִיגִית בְּעֶרֶב שִׁשִּׁי עִם חַלָּה, יַיִן וְכָל הַמִּשְׁפָּחָה.",
            definitionNative = "Праздничная трапеза в пятницу вечером с халой, вином и всей семьёй.",
            example = "סָבְתָא תָּמִיד מַזְמִינָה אוֹתָנוּ לַאֲרוּחַת שַׁבָּת.",
            exampleNative = "Бабушка всегда зовёт нас на אֲרוּחַת שַׁבָּת к себе домой."
        , fillInBlankExclusions = listOf(184211L, 184212L, 184214L, 184215L)),
        WordEntity(
            id = 184214, setId = 1842, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "cuisine_l1_meals",
            original = "חָמִין", translation = "чолент / хамин",
            transliteration = "хамин",
            definition = "תַּבְשִׁיל אִטִּי שֶׁל בָּשָׂר, קִטְנִיּוֹת וְתַפּוּחֵי אֲדָמָה לִשְׁבָת.",
            definitionNative = "Медленное блюдо из мяса, бобов и картошки на субботний обед.",
            example = "סַבָּא מֵכִין חָמִין כָּל יוֹם שִׁשִּׁי בַּסִּיר הָאִטִּי.",
            exampleNative = "Дед готовит חָמִין каждую пятницу в медленной кастрюле."
        , fillInBlankExclusions = listOf(184211L, 184212L, 184213L, 184215L)),
        WordEntity(
            id = 184215, setId = 1842, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "cuisine_l1_meals",
            original = "חֲטִיף", translation = "перекус",
            transliteration = "хатиф",
            definition = "אֹכֶל קָטָן בֵּין הָאֲרוּחוֹת — לְהַשְׁבִּיעַ אֶת הַבֶּטֶן עַד הָעֶרֶב.",
            definitionNative = "Маленькая еда между трапезами — успокоить живот до самого вечера.",
            example = "לָקַחְתִּי חֲטִיף שׁוֹקוֹלָד לָעֲבוֹדָה לַאַחַר הַצָּהֳרַיִם.",
            exampleNative = "Я взял шоколадный חֲטִיף на работу после полудня."
        , fillInBlankExclusions = listOf(184211L, 184212L, 184213L, 184214L)),

        // ─── cuisine_l1_actions (5) ──────────────────────────────────────
        WordEntity(
            id = 184216, setId = 1842, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "cuisine_l1_actions",
            original = "לֶאֱכֹל", translation = "есть, кушать",
            transliteration = "леэхоль",
            definition = "לְהַכְנִיס אֹכֶל לַפֶּה, לִלְעֹס וְלִבְלֹעַ כְּדֵי לָתֵת כֹּחַ לַגּוּף.",
            definitionNative = "Класть еду в рот, жевать и глотать, чтобы дать силы телу.",
            example = "אֲנִי אוֹהֵב לֶאֱכֹל פָלָאפֶל אַחֲרֵי הָעֲבוֹדָה.",
            exampleNative = "Я люблю לֶאֱכֹל фалафель прямо после работы у киоска."
        , fillInBlankExclusions = listOf(184217L, 184218L, 184219L, 184220L)),
        WordEntity(
            id = 184217, setId = 1842, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "cuisine_l1_actions",
            original = "לְבַשֵּׁל", translation = "готовить (варить)",
            transliteration = "левашель",
            definition = "לְהָכִין אֹכֶל בְּחֹם — לְחַמֵּם בְּסִיר אוֹ עַל מַחֲבַת.",
            definitionNative = "Делать еду на жару — нагревать в кастрюле или на сковороде.",
            example = "אִמָּא יוֹדַעַת לְבַשֵּׁל חוּמּוּס מֵאֶפֶס בְּכַחֲצִי שָׁעָה.",
            exampleNative = "Мама умеет לְבַשֵּׁל хумус с нуля за полчаса с небольшим."
        , fillInBlankExclusions = listOf(184216L, 184218L, 184219L, 184220L)),
        WordEntity(
            id = 184218, setId = 1842, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "cuisine_l1_actions",
            original = "לְהַזְמִין", translation = "заказывать",
            transliteration = "леазмин",
            definition = "לְבַקֵּשׁ מִמֶּלְצָר אֹכֶל אוֹ שְׁתִיָּה תְּמוּרַת תַּשְׁלוּם.",
            definitionNative = "Просить у официанта еду или питьё за оплату по счёту.",
            example = "הֶחְלַטְתִּי לְהַזְמִין שַׁקְשׁוּקָה וְקָפֶה הָפוּךְ לַבֹּקֶר.",
            exampleNative = "Я решил לְהַזְמִין шакшуку и кофе с молоком на завтрак."
        , fillInBlankExclusions = listOf(184216L, 184217L, 184219L, 184220L)),
        WordEntity(
            id = 184219, setId = 1842, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "cuisine_l1_actions",
            original = "לִטְעֹם", translation = "пробовать (на вкус)",
            transliteration = "литъом",
            definition = "לָשִׂים מְעַט אֹכֶל בַּפֶּה כְּדֵי לְהַרְגִּישׁ אֵיךְ הַטַּעַם שֶׁלּוֹ.",
            definitionNative = "Положить чуть-чуть еды в рот, чтобы понять, какой у неё вкус.",
            example = "תּוּכַל לִטְעֹם מֵהַסָּלָט לִפְנֵי שֶׁתַּחְלִיט?",
            exampleNative = "Можешь לִטְעֹם салат, прежде чем решить, нравится ли он?"
        , fillInBlankExclusions = listOf(184216L, 184217L, 184218L, 184220L)),
        WordEntity(
            id = 184220, setId = 1842, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "cuisine_l1_actions",
            original = "לִקְצֹץ", translation = "нарезать (мелко)",
            transliteration = "ликцоц",
            definition = "לַחְתֹּךְ אֹכֶל לַחֲתִיכוֹת קְטַנּוֹת מְאוֹד בְּסַכִּין עַל קֶרֶשׁ.",
            definitionNative = "Резать еду на очень мелкие кусочки ножом на разделочной доске.",
            example = "צָרִיךְ לִקְצֹץ עַגְבָנִיּוֹת וּמְלָפְפוֹנִים לַסָּלָט יִשְׂרְאֵלִי.",
            exampleNative = "Нужно לִקְצֹץ помидоры и огурцы для израильского салата."
        , fillInBlankExclusions = listOf(184216L, 184217L, 184218L, 184219L)),

        // ─── cuisine_l1_places (5) ───────────────────────────────────────
        WordEntity(
            id = 184221, setId = 1842, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cuisine_l1_places",
            original = "חוּמּוּסִיָּה", translation = "хумусия",
            transliteration = "хумусия",
            definition = "מִסְעֶדֶת רְחוֹב קְטַנָּה שֶׁמַּגִּישָׁה רַק מָנוֹת חוּמּוּס וּפִיתָה.",
            definitionNative = "Маленькая уличная закусочная, что подаёт только блюда хумуса с питой.",
            example = "בְּכָל בֹּקֶר אַבָּא אוֹכֵל בְּחוּמּוּסִיָּה בָּרְחוֹב.",
            exampleNative = "Каждое утро папа ест в חוּמּוּסִיָּה на нашей улице."
        , fillInBlankExclusions = listOf(184222L, 184223L, 184224L, 184225L)),
        WordEntity(
            id = 184222, setId = 1842, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cuisine_l1_places",
            original = "פָלָאפֶלִיָּה", translation = "фалафельная",
            transliteration = "фалафелия",
            definition = "דּוּכָן קָטָן שֶׁמַּגִּישׁ פָלָאפֶל בַּפִּיתָה עִם סָלָט וּטְחִינָה.",
            definitionNative = "Маленький ларёк, что подаёт фалафель в пите с салатом и тхиной.",
            example = "הַפָלָאפֶלִיָּה הֲכִי טוֹבָה בָּעִיר נִמְצֵאת בַּשּׁוּק.",
            exampleNative = "Лучшая в городе פָלָאפֶלִיָּה находится прямо на рынке."
        , fillInBlankExclusions = listOf(184221L, 184223L, 184224L, 184225L)),
        WordEntity(
            id = 184223, setId = 1842, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "cuisine_l1_places",
            original = "מַעֲדַנִיָּה", translation = "деликатесная",
            transliteration = "маадания",
            definition = "חֲנוּת קְטַנָּה שֶׁמּוֹכֶרֶת גְּבִינוֹת, סָלָטִים וּמַטְעַמִּים מְיֻחָדִים.",
            definitionNative = "Маленький магазин, что продаёт сыры, салаты и особые лакомства.",
            example = "קָנִיתִי גְּבִינַת עִזִּים בַּמַּעֲדַנִיָּה לִכְבוֹד הָאוֹרְחִים.",
            exampleNative = "Я купил козий сыр в מַעֲדַנִיָּה к приходу гостей."
        ),
        WordEntity(
            id = 184224, setId = 1842, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "cuisine_l1_places",
            original = "שׁוּק", translation = "рынок",
            transliteration = "шук",
            definition = "מָקוֹם פָּתוּחַ עִם דּוּכָנִים שֶׁל יְרָקוֹת, פֵּרוֹת וּתְבָלִין.",
            definitionNative = "Открытое место с прилавками овощей, фруктов и приправ под небом.",
            example = "בְּשַׁבָּת בַּבֹּקֶר אֲנַחְנוּ הוֹלְכִים לַשּׁוּק לִקְנוֹת יְרָקוֹת.",
            exampleNative = "В субботу утром мы идём на שׁוּק покупать свежие овощи."
        ),
        WordEntity(
            id = 184225, setId = 1842, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "cuisine_l1_places",
            original = "מִסְעָדָה", translation = "ресторан",
            transliteration = "мисъада",
            definition = "מָקוֹם שֶׁבּוֹ יוֹשְׁבִים לְיַד שֻׁלְחָן וּמַזְמִינִים אֹכֶל מִתַּפְרִיט.",
            definitionNative = "Место, где садятся за стол и заказывают еду из меню у официанта.",
            example = "פָּתְחוּ מִסְעָדָה חֲדָשָׁה שֶׁל אֹכֶל מָרוֹקָאִי בָּרְחוֹב שֶׁלָּנוּ.",
            exampleNative = "Открыли новый מִסְעָדָה марокканской еды на нашей улице."
        , fillInBlankExclusions = listOf(184221L, 184222L, 184223L, 184224L)),
    )
}
