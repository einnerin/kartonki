package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew spice & herb vocabulary — extension of the «Еда и кулинария» topic, level 3.
 * Set 1894 (he-ru). Covers spices and aromatic herbs important in Israeli and
 * Mediterranean cuisine: sumac, baharat, hawaij, paprika, allspice, cardamom,
 * anise, nigella, fenugreek; herbs (basil, oregano, rosemary, dill, parsley,
 * savory, thyme); warm spices (clove, nutmeg, vanilla, fennel) and core spices
 * (turmeric, coriander, mustard, paprika).
 *
 * Rarity: UNCOMMON + RARE (two adjacent tiers, A2..B2).
 * Word IDs follow formula setId*100+pos → 189401..189425.
 *
 * Не пересекается с уже существующими «специями» в других сетах: corica
 * (קִנָּמוֹן в set Barista L3 и Batch45), kummin/тмин (כַּמּוּן в Batch6,
 * כְּמֹון в Batch45), куркум — пока нет, шафран (זָעְפְּרָן в Batch20),
 * имбирь (זַנְגְּבִיל в Batch45), кунжут (שֻׁמְשּׁוּם в Batch7), чеснок
 * (שׁוּם в Batch6), мята (נַעֲנַע в IsraeliCuisineL1), заатар (זַעְתַּר в
 * IsraeliCuisineL1) — все эти слова исключены из этого сета.
 */
object WordDataHebrewFoodSpices {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1894, languagePair = "he-ru", orderIndex = 1894,
            name = "Еда и кулинария",
            description = "Специи и пряные травы: סוּמָק, בַּהָרָאת, חַוָאיֵג׳, פַּפְּרִיקָה, רֵיחָן",
            topic = "Еда и кулинария",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: food_spices_mediterranean (5 words) ───────────────────────

        WordEntity(id = 189401, setId = 1894, languagePair = "he-ru", rarity = "RARE",
            original = "סוּמָק",
            translation = "сумак",
            definition = "אֲבָקָה אֲדֻמָּה וַחֲמוּצָה מִגַּרְגִּירֵי שִׂיחַ יָם־תִּיכוֹנִי, מְחַלֶּפֶת לִימוֹן בְּפִזּוּר עַל מַאֲכָלִים.",
            definitionNative = "Молотая красная пряность с кислинкой; делается из плодов левантийского кустарника, заменяет лимон в посыпке.",
            example = "פִּיזַּרְתִּי סוּמָק עַל הַחוּמּוּס וְעַל פְּרוּסוֹת הַבָּצָל.",
            exampleNative = "Я посыпал хумус и ломтики лука סוּמָק.",
            pos = "noun", semanticGroup = "food_spices_mediterranean",
            fillInBlankExclusions = listOf(189402L, 189403L, 189404L, 189405L)),

        WordEntity(id = 189402, setId = 1894, languagePair = "he-ru", rarity = "RARE",
            original = "בַּהָרָאת",
            translation = "бахарат",
            definition = "תַּעֲרוֹבֶת תַּבְלִינִים חֲמִימָה מֵהַמִּזְרָח הַתִּיכוֹן עִם פִּלְפֵּל שָׁחוֹר, פִּלְפֵּל אַנְגְּלִי וְכַמּוֹן.",
            definitionNative = "Согревающая ближневосточная смесь пряностей с чёрным перцем, душистым перцем и тмином.",
            example = "הוּא תִּבֵּל אֶת הַתַּבְשִׁיל בְּכַף בַּהָרָאת לִפְנֵי הָאֲפִיָּה.",
            exampleNative = "Он приправил тушёное блюдо ложкой בַּהָרָאת перед запеканием.",
            pos = "noun", semanticGroup = "food_spices_mediterranean",
            fillInBlankExclusions = listOf(189401L, 189403L, 189404L, 189405L)),

        WordEntity(id = 189403, setId = 1894, languagePair = "he-ru", rarity = "RARE",
            original = "חַוָאיֵג׳",
            translation = "хаваидж",
            definition = "תַּעֲרוֹבֶת תֵּימָנִית עַל בְּסִיס כּוּרְכּוּם, כַּמּוֹן וְפִלְפֵּל שָׁחוֹר, מְשַׁמֶּשֶׁת לְמָרָקִים וְקָפֶה.",
            definitionNative = "Йеменская смесь на основе куркумы, тмина и чёрного перца; добавляется в супы или кофе.",
            example = "אֶת הַמָּרָק לֹא טוֹעֲמִים בְּתֵימָן בְּלִי חַוָאיֵג׳ שֶׁל סָבְתָא.",
            exampleNative = "В Йемене суп не едят без бабушкиного חַוָאיֵג׳.",
            pos = "noun", semanticGroup = "food_spices_mediterranean",
            fillInBlankExclusions = listOf(189401L, 189402L, 189404L, 189405L)),

        WordEntity(id = 189404, setId = 1894, languagePair = "he-ru", rarity = "RARE",
            original = "פִּלְפֵּל אַנְגְּלִי",
            translation = "душистый перец",
            definition = "גַּרְגִּירִים חוּמִּים שֶׁל עֵץ פִּימֶנְטָה, בַּעֲלֵי טַעַם הַמַּזְכִּיר קִינָּמוֹן, צִיפּוֹרֶן וֶאֱגוֹז מוּסְקָט.",
            definitionNative = "Коричневые горошины с дерева пименты; вкус напоминает корицу, гвоздику и мускатный орех одновременно.",
            example = "הוֹסַפְתִּי שְׁנֵי גַּרְגִּירֵי פִּלְפֵּל אַנְגְּלִי אֶל הַמָּרִינַד שֶׁל הַבָּשָׂר.",
            exampleNative = "Я добавил пару горошин פִּלְפֵּל אַנְגְּלִי в маринад для мяса.",
            pos = "phrase", semanticGroup = "food_spices_mediterranean",
            fillInBlankExclusions = listOf(189401L, 189402L, 189403L, 189405L)),

        WordEntity(id = 189405, setId = 1894, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פַּפְּרִיקָה",
            translation = "паприка",
            definition = "אֲבָקָה אֲדוּמָה הַמְּתֻבָּלָה מִפִּלְפֵּל מָתוֹק וְלִפְעָמִים חָרִיף, נוֹתֶנֶת צֶבַע לְמַאֲכָלִים.",
            definitionNative = "Молотый порошок из сладкого, иногда острого перца; даёт блюдам красный цвет и сладковатый вкус.",
            example = "הִיא הוֹסִיפָה כַּף פַּפְּרִיקָה אֲדֻמָּה לְגוּלָאשׁ הַבָּשָׂר.",
            exampleNative = "Она добавила в гуляш ложку красной פַּפְּרִיקָה.",
            pos = "noun", semanticGroup = "food_spices_mediterranean",
            fillInBlankExclusions = listOf(189401L, 189402L, 189403L, 189404L)),

        // ── Group: food_spices_seeds (5 words) ───────────────────────────────

        WordEntity(id = 189406, setId = 1894, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פִּלְפֵּל שָׁחוֹר",
            translation = "чёрный перец",
            definition = "גַּרְגִּירִים חֲרִיפִים שֶׁל צֶמַח הַפִּלְפֵּל, נִטְחָנִים וּמְשַׁמְּשִׁים בְּכִמְעַט כָּל תַּבְשִׁיל מָלוּחַ.",
            definitionNative = "Острые горошины с лианы перца; мелют и кладут практически в любое солёное блюдо.",
            example = "טַחֲנִי קְצָת פִּלְפֵּל שָׁחוֹר טָרִי עַל הַסָּלָט לִפְנֵי הַהַגָּשָׁה.",
            exampleNative = "Намели сверху на салат немного свежего פִּלְפֵּל שָׁחוֹר перед подачей.",
            pos = "phrase", semanticGroup = "food_spices_seeds",
            fillInBlankExclusions = listOf(189407L, 189408L, 189409L, 189410L)),

        WordEntity(id = 189407, setId = 1894, languagePair = "he-ru", rarity = "RARE",
            original = "הֵל",
            translation = "кардамон",
            definition = "תַּרְמִילִים יְרֻקִּים אֲרוֹמָטִיִּים עִם זְרָעִים שְׁחוֹרִים, מְשַׁמְּשִׁים לְקָפֶה תֵּימָנִי וּלְעוּגוֹת.",
            definitionNative = "Ароматные зелёные стручки с чёрными зёрнышками; кладут в йеменский кофе и в выпечку.",
            example = "סָבָא תָּמִיד מוֹסִיף הֵל לְקָפֶה הַטּוּרְקִי שֶׁלּוֹ.",
            exampleNative = "Дедушка всегда добавляет в свой турецкий кофе הֵל.",
            pos = "noun", semanticGroup = "food_spices_seeds",
            fillInBlankExclusions = listOf(189406L, 189408L, 189409L, 189410L)),

        WordEntity(id = 189408, setId = 1894, languagePair = "he-ru", rarity = "RARE",
            original = "אַנִיס",
            translation = "анис",
            definition = "זַרְעֵי תַּבְלִין בַּעֲלֵי טַעַם מָתוֹק שֶׁמַּזְכִּיר לִיקוֹרִיץ', מְשַׁמְּשִׁים לְעוּגִיּוֹת וְלִיקֵרִים.",
            definitionNative = "Сладкие семена со вкусом, напоминающим лакрицу; кладут в выпечку и в ликёры.",
            example = "הִיא הִכְנִיסָה זַרְעֵי אַנִיס אֶל בָּצֵק הַקְּרִיסְפִּין.",
            exampleNative = "Она добавила в тесто для печенья семена אַנִיס.",
            pos = "noun", semanticGroup = "food_spices_seeds",
            fillInBlankExclusions = listOf(189406L, 189407L, 189409L, 189410L)),

        WordEntity(id = 189409, setId = 1894, languagePair = "he-ru", rarity = "RARE",
            original = "חִילְבָּה",
            translation = "пажитник, хильба",
            definition = "זַרְעֵי תַּבְלִין צְהֻבִּים בַּעֲלֵי רֵיחַ חָזָק, נִשְׁרִים בַּמַּיִם וּמְשַׁמְּשִׁים לִרְבִיכָה תֵּימָנִית.",
            definitionNative = "Жёлтые семена с резким запахом; их вымачивают и взбивают в йеменскую желеобразную заправку.",
            example = "אִמָּא הִגִּישָׁה חִילְבָּה לְצַד הַחַלָּה לְשַׁבָּת.",
            exampleNative = "Мама подала חִילְבָּה рядом с субботней халой.",
            pos = "noun", semanticGroup = "food_spices_seeds",
            fillInBlankExclusions = listOf(189406L, 189407L, 189408L, 189410L)),

        WordEntity(id = 189410, setId = 1894, languagePair = "he-ru", rarity = "RARE",
            original = "קֶצַח",
            translation = "чёрный тмин, нигелла",
            definition = "זַרְעֵי תַּבְלִין שְׁחוֹרִים קְטַנִּים בַּעֲלֵי טַעַם מַר־עָשָׁן, מְפַזְּרִים עַל לֶחֶם וְעַל גְּבִינוֹת.",
            definitionNative = "Мелкие чёрные семена с горьковато-дымным вкусом; посыпают хлеб и творожные сыры.",
            example = "הָאוֹפֶה פִּזֵּר קֶצַח עַל הַלַּחְמָנִיּוֹת לִפְנֵי שֶׁהִכְנִיס אוֹתָן לַתַּנּוּר.",
            exampleNative = "Пекарь посыпал булочки קֶצַח перед тем, как поставить их в печь.",
            pos = "noun", semanticGroup = "food_spices_seeds",
            fillInBlankExclusions = listOf(189406L, 189407L, 189408L, 189409L)),

        // ── Group: food_spices_herbs (5 words) ───────────────────────────────

        WordEntity(id = 189411, setId = 1894, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רֵיחָן",
            translation = "базилик",
            definition = "צֶמַח תַּבְלִין יָרוֹק בַּעַל אֲרוֹמָה מְתוּקָה וַעֲדִינָה, מוֹסִיפִים אוֹתוֹ לְפַסְטָה וּפֶּסְטוֹ.",
            definitionNative = "Зелёная пряная трава со сладким мягким ароматом; идёт в пасту и в соус песто.",
            example = "כָּתַשְׁתִּי עָלֵי רֵיחָן טְרִיִּים עִם שׁוּם וְשֶׁמֶן זַיִת.",
            exampleNative = "Я растёр свежие листья רֵיחָן с чесноком и оливковым маслом.",
            pos = "noun", semanticGroup = "food_spices_herbs",
            fillInBlankExclusions = listOf(189412L, 189413L, 189414L, 189415L)),

        WordEntity(id = 189412, setId = 1894, languagePair = "he-ru", rarity = "RARE",
            original = "אוֹרֶגָנוֹ",
            translation = "орегано, душица",
            definition = "עָלִים מְיוּבָּשִׁים שֶׁל עֵשֶׂב יָם־תִּיכוֹנִי בַּעֲלֵי טַעַם חָזָק, אוֹפְיָנִיִּים לַמִּטְבָּח הַיְּוָנִי וְהָאִיטַלְקִי.",
            definitionNative = "Сушёные листья средиземноморской пряной травы с насыщенным вкусом; узнаваемая нота греческой и итальянской кухни.",
            example = "פִּזַּרְתִּי אוֹרֶגָנוֹ עַל הַפִּיצָה לִפְנֵי שֶׁהִכְנַסְתִּי אוֹתָהּ לַתַּנּוּר.",
            exampleNative = "Я посыпал пиццу אוֹרֶגָנוֹ перед тем, как поставить её в духовку.",
            pos = "noun", semanticGroup = "food_spices_herbs",
            fillInBlankExclusions = listOf(189411L, 189413L, 189414L, 189415L)),

        WordEntity(id = 189413, setId = 1894, languagePair = "he-ru", rarity = "RARE",
            original = "רוֹזְמָרִין",
            translation = "розмарин",
            definition = "צֶמַח תַּבְלִין עִם מַחֲטִים יְרֻקּוֹת וְרֵיחַ אֲרוֹמָטִי חָזָק, מַתְאִים לְעוֹף וְלִתְפּוּחֵי אֲדָמָה.",
            definitionNative = "Куст со жёсткой хвоей и сильным ароматом; отлично подходит к курице и к запечённой картошке.",
            example = "הִנַּחְתִּי עָנְפֵי רוֹזְמָרִין מִתַּחַת לָעוֹף לִפְנֵי הַצְּלִיָּה.",
            exampleNative = "Я положил под курицу веточки רוֹזְמָרִין перед запеканием.",
            pos = "noun", semanticGroup = "food_spices_herbs",
            fillInBlankExclusions = listOf(189411L, 189412L, 189414L, 189415L)),

        WordEntity(id = 189414, setId = 1894, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שָׁמִיר",
            translation = "укроп",
            definition = "צֶמַח תַּבְלִין דַּק עִם עָלִים נוֹצָתִיִּים וְרֵיחַ קַל, מוֹסִיפִים אוֹתוֹ לְסָלָטִים וּלְמְלָפְפוֹנֵי כְּבוּשִׁים.",
            definitionNative = "Тонкая трава с перистыми листьями и лёгким ароматом; кладут в салаты и в малосольные огурцы.",
            example = "הוֹסַפְתִּי שָׁמִיר קָצוּץ אֶל סְלַט תַּפּוּחֵי הָאֲדָמָה.",
            exampleNative = "Я добавил в картофельный салат рубленый שָׁמִיר.",
            pos = "noun", semanticGroup = "food_spices_herbs",
            fillInBlankExclusions = listOf(189411L, 189412L, 189413L, 189415L)),

        WordEntity(id = 189415, setId = 1894, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פֶּטְרוֹזִילְיָה",
            translation = "петрушка",
            definition = "עֵשֶׂב תַּבְלִין יָרוֹק עִם עָלִים מְסוּלָּסִים אוֹ שְׁטוּחִים, נֶחְשָׁב יְסוֹדִי בְּסָלָט תַּבּוּלֶה.",
            definitionNative = "Зелёная трава с кудрявыми или плоскими листьями; основной ингредиент салата табуле.",
            example = "קִצַּצְתִּי הַרְבֵּה פֶּטְרוֹזִילְיָה לְתַבּוּלֶה לְבָנוֹנִי.",
            exampleNative = "Я мелко нарубил много פֶּטְרוֹזִילְיָה для ливанского табуле.",
            pos = "noun", semanticGroup = "food_spices_herbs",
            fillInBlankExclusions = listOf(189411L, 189412L, 189413L, 189414L)),

        // ── Group: food_spices_warm (5 words) ────────────────────────────────

        WordEntity(id = 189416, setId = 1894, languagePair = "he-ru", rarity = "RARE",
            original = "צִיפּוֹרֶן",
            translation = "гвоздика (пряность)",
            definition = "נִצָּנֵי פֶּרַח מְיוּבָּשִׁים בְּצוּרַת מַסְמֵר עִם רֵיחַ חַם וְעַז, מְשַׁמְּשִׁים לְעוֹגוֹת וּלְמַשְׁקֵה חַם.",
            definitionNative = "Высушенные бутоны южного цветка в форме маленького тёмного штифта; сильный тёплый аромат, идёт в выпечку и в горячие напитки.",
            example = "תָּקַעְתִּי כַּמָּה צִיפּוֹרֶן בְּתוֹךְ הַתַּפּוּז לְמַשְׁקֵה חַג הַמּוֹלָד.",
            exampleNative = "Я воткнул в апельсин несколько צִיפּוֹרֶן для рождественского напитка.",
            pos = "noun", semanticGroup = "food_spices_warm",
            fillInBlankExclusions = listOf(189417L, 189418L, 189419L, 189420L)),

        WordEntity(id = 189417, setId = 1894, languagePair = "he-ru", rarity = "RARE",
            original = "אֱגוֹז מוּסְקָט",
            translation = "мускатный орех",
            definition = "זֶרַע פְּרִי טְרוֹפִּי שֶׁמְּגָרְדִים אוֹתוֹ עַל פּוֹמְפִּיָּה, נוֹתֵן רֵיחַ חַם וּמָתוֹק לְרוֹטֶב לָבָן.",
            definitionNative = "Семя тропического фрукта; натирают на тёрке и добавляют в белый соус для тёплого сладковатого аромата.",
            example = "גַּרַדְתִּי מְעַט אֱגוֹז מוּסְקָט עַל רוֹטֶב הַבֶּשָׁמֶל.",
            exampleNative = "Я потёр немного אֱגוֹז מוּסְקָט в соус бешамель.",
            pos = "phrase", semanticGroup = "food_spices_warm",
            fillInBlankExclusions = listOf(189416L, 189418L, 189419L, 189420L)),

        WordEntity(id = 189418, setId = 1894, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "וָנִיל",
            translation = "ваниль",
            definition = "תַּרְמִילִים שְׁחוֹרִים שֶׁל סַחְלָב טְרוֹפִּי עִם זְרָעִים אֲרוֹמָטִיִּים, מְשַׁמְּשִׁים לְעוּגוֹת וְלִקְצֶפֶת.",
            definitionNative = "Чёрные стручки тропической орхидеи с ароматными семенами; кладут в выпечку и во взбитые сливки.",
            example = "פָּתַחְתִּי מַקֵּל וָנִיל וְגֵרַדְתִּי אֶת הַזְּרָעִים אֶל הַשַּׁמֶּנֶת.",
            exampleNative = "Я разрезал стручок וָנִיל и выскреб семена в сливки.",
            pos = "noun", semanticGroup = "food_spices_warm",
            fillInBlankExclusions = listOf(189416L, 189417L, 189419L, 189420L)),

        WordEntity(id = 189419, setId = 1894, languagePair = "he-ru", rarity = "RARE",
            original = "שׁוּמָר",
            translation = "фенхель",
            definition = "צֶמַח עִם בַּצַל לָבָן וְעָלִים נוֹצָתִיִּים, בַּעַל טַעַם מָתוֹק שֶׁל אַנִיס.",
            definitionNative = "Растение с белой луковицей и перистой зеленью; вкус сладковатый, с нотами аниса.",
            example = "צָלִיתִי פְּרוּסוֹת שׁוּמָר בְּתַנּוּר עִם שֶׁמֶן זַיִת וְלִימוֹן.",
            exampleNative = "Я запёк в духовке ломтики שׁוּמָר с оливковым маслом и лимоном.",
            pos = "noun", semanticGroup = "food_spices_warm",
            fillInBlankExclusions = listOf(189416L, 189417L, 189418L, 189420L)),

        WordEntity(id = 189420, setId = 1894, languagePair = "he-ru", rarity = "RARE",
            original = "טִימִין",
            translation = "тимьян, чабрец",
            definition = "צֶמַח תַּבְלִין נָמוּךְ עִם עָלִים זְעִירִים וְרֵיחַ חָזָק, פּוֹפּוּלָרִי בַּמִּטְבָּח הַצָּרְפָתִי.",
            definitionNative = "Низкий кустарник с мелкими листочками и сильным ароматом; популярная пряность французской кухни.",
            example = "פִּזַּרְתִּי טִימִין טָרִי עַל הַדָּג לִפְנֵי הַצְּלִיָּה.",
            exampleNative = "Я посыпал рыбу свежим טִימִין перед запеканием.",
            pos = "noun", semanticGroup = "food_spices_warm",
            fillInBlankExclusions = listOf(189416L, 189417L, 189418L, 189419L)),

        // ── Group: food_spices_pungent (5 words) ─────────────────────────────

        WordEntity(id = 189421, setId = 1894, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "כּוּרְכּוּם",
            translation = "куркума",
            definition = "אֲבָקָה צְהֻבָּה־כְּתוּמָה מִשּׁוֹרֶשׁ צֶמַח טְרוֹפִּי, נוֹתֶנֶת צֶבַע וְטַעַם עָפָר עָדִין.",
            definitionNative = "Жёлто-оранжевый порошок из корня тропического растения; даёт цвет и землистый мягкий вкус.",
            example = "הוֹסַפְתִּי כַּפִּית כּוּרְכּוּם אֶל הָאֹרֶז לִצְבִיעָה זְהֻבָּה.",
            exampleNative = "Я добавил в рис ложечку כּוּרְכּוּם, чтобы он стал золотистым.",
            pos = "noun", semanticGroup = "food_spices_pungent",
            fillInBlankExclusions = listOf(189422L, 189423L, 189424L, 189425L)),

        WordEntity(id = 189422, setId = 1894, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "כּוּסְבָּרָה",
            translation = "кориандр, кинза",
            definition = "צֶמַח תַּבְלִין עִם עָלִים יְרֻקִּים וְרֵיחַ חַד; הַזְּרָעִים מְשַׁמְּשִׁים כְּתַבְלִין מָתוֹק יוֹתֵר.",
            definitionNative = "Трава со специфическим резким ароматом; свежие листья идут в салаты и хумус, а сухие семена — в смеси приправ.",
            example = "פִּזַּרְתִּי כּוּסְבָּרָה קְצוּצָה עַל הַחוּמּוּס לִפְנֵי הַהַגָּשָׁה.",
            exampleNative = "Перед подачей я посыпал хумус рубленой כּוּסְבָּרָה.",
            pos = "noun", semanticGroup = "food_spices_pungent",
            fillInBlankExclusions = listOf(189421L, 189423L, 189424L, 189425L)),

        WordEntity(id = 189423, setId = 1894, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חַרְדָּל",
            translation = "горчица",
            definition = "תַּבְלִין חָרִיף מִזַּרְעֵי צֶמַח קָטָן, מוּכָר גַּם כִּמְמָרֵחַ צָהֹב לְכָרִיךְ וְלִנְקְנִיקִיּוֹת.",
            definitionNative = "Острая пряность из жёлтых семян; знакома также как ярко-жёлтая паста к бутербродам и сосискам.",
            example = "מָרַחְתִּי חַרְדָּל דִּיז'וֹן עַל הַכָּרִיךְ לִפְנֵי שֶׁהוֹסַפְתִּי גְּבִינָה.",
            exampleNative = "Я намазал на бутерброд חַרְדָּל дижонской и положил сыр.",
            pos = "noun", semanticGroup = "food_spices_pungent",
            fillInBlankExclusions = listOf(189421L, 189422L, 189424L, 189425L)),

        WordEntity(id = 189424, setId = 1894, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תַּבְלִינִים",
            translation = "специи, пряности",
            definition = "אֲבָקוֹת וּזְרָעִים יְבֵשִׁים וַאֲרוֹמָטִיִּים שֶׁמּוֹסִיפִים לְמַאֲכָלִים כְּדֵי לָתֵת לָהֶם טַעַם.",
            definitionNative = "Общее название сухих приправ — тмин, перец, паприка и т.п., которые добавляют в блюда для вкуса и аромата.",
            example = "בַּשּׁוּק קָנִיתִי תַּבְלִינִים טְרִיִּים בְּכַמּוּיוֹת קְטַנּוֹת.",
            exampleNative = "На рынке я купил свежие תַּבְלִינִים маленькими порциями.",
            pos = "noun", semanticGroup = "food_spices_pungent",
            fillInBlankExclusions = listOf(189421L, 189422L, 189423L, 189425L)),

        WordEntity(id = 189425, setId = 1894, languagePair = "he-ru", rarity = "RARE",
            original = "תַּעֲרוֹבֶת תַּבְלִינִים",
            translation = "смесь специй",
            definition = "צֵרוּף שֶׁל כַּמָּה אֲבָקוֹת אֲרוֹמָטִיּוֹת בְּיַחַס קָבוּעַ, כְּמוֹ בַּהָרָאת אוֹ חַוָאיֵג׳.",
            definitionNative = "Сочетание нескольких пряностей в определённых пропорциях — например, бахарат или хаваидж.",
            example = "הַחֵפֶץ הָאָהוּב עַל הַשֶּׁף הוּא תַּעֲרוֹבֶת תַּבְלִינִים מָרוֹקָאִית בְּעֶשֶׂר רְכִיבִים.",
            exampleNative = "Любимая вещь шефа — марокканская תַּעֲרוֹבֶת תַּבְלִינִים из десяти компонентов.",
            pos = "phrase", semanticGroup = "food_spices_pungent",
            fillInBlankExclusions = listOf(189421L, 189422L, 189423L, 189424L)),
    )
}
