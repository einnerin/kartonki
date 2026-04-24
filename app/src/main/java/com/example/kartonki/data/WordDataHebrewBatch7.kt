package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — batch 7.
 * Sets 1044–1046: Supermarket, Hospital/Medicine, Public Transport.
 */
object WordDataHebrewBatch7 {

    val sets = listOf(
        WordSetEntity(id = 1044, name = "Еда и кулинария",            description = "Покупки, цены и товары",          languagePair = "he-ru", orderIndex = 44,
            topic = "Еда и кулинария",
            level = 2),
                    )

    val words = listOf(

        // ──────────────────────────────────────────────────────
        // Set 1044 — קניות בסופרמרקט  (Supermarket shopping, A2/B1),
        // 25 words: 6 COMMON + 10 UNCOMMON + 6 RARE + 2 EPIC + 1 LEGENDARY
        // ──────────────────────────────────────────────────────

        WordEntity(
            id = 104401, setId = 1044, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "supermarket_basics", transliteration = "agala",
            original = "עֲגָלָה", translation = "тележка (покупательская)",
            definition = "כְּלִי גַּלְגַּלִּים לְהַנָּחַת קְנִיּוֹת בַּסּוּפֶּרְמַרְקֶט.",
            definitionNative = "Колёсная корзина для покупок в супермаркете.",
            example = "לָקַחְתִּי עֲגָלָה בְּכְנִיסָה לַסּוּפֶּרְמַרְקֶט.",
            exampleNative = "Я взял עֲגָלָה при входе в супермаркет.",
         fillInBlankExclusions = listOf(104402L, 104403L, 104404L, 104405L, 104406L, 104408L, 104414L, 104415L, 104416L, 104417L, 104421L, 104422L, 104423L, 104424L, 104425L)),
        WordEntity(
            id = 104402, setId = 1044, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "supermarket_basics", transliteration = "sal kniyot",
            original = "סַל קְנִיּוֹת", translation = "корзина для покупок",
            definition = "סַל נָשׂוּא לְהַנָּחַת מוּצָרִים מְעַטִּים בַּסּוּפֶּרְמַרְקֶט.",
            definitionNative = "Ручная корзина для небольшого количества покупок в супермаркете.",
            example = "לְקַחְתִּי רַק סַל קְנִיּוֹת כִּי הִזְמַנְתִּי מְעַט.",
            exampleNative = "Я взял только סַל קְנִיּוֹת, потому что покупал немного.",
         fillInBlankExclusions = listOf(104401L, 104403L, 104404L, 104405L, 104406L, 104408L, 104414L, 104415L, 104416L, 104417L, 104421L, 104422L, 104423L, 104424L, 104425L)),
        WordEntity(
            id = 104403, setId = 1044, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "supermarket_basics", transliteration = "mutzar",
            original = "מוּצָר", translation = "товар, продукт",
            definition = "דָּבָר הַמְּיֻצָּר לִמְכִירָה בַּסּוּפֶּרְמַרְקֶט.",
            definitionNative = "Изделие, произведённое для продажи в супермаркете.",
            example = "בָּדַקְתִּי אֶת תַּאֲרִיךְ הַתֹּקֶף שֶׁל הַמּוּצָר.",
            exampleNative = "Я проверил срок годности מוּצָר.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 104404, setId = 1044, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "supermarket_basics", transliteration = "kupon",
            original = "קֻפּוֹן", translation = "купон; скидочный талон",
            definition = "שׁוֹבֵר הַמְּאַפְשֵׁר הֲנָחָה אוֹ הֲטָבָה בְּרְכִישַׁת מוּצָרִים בַּסּוּפֶּרְמַרְקֵט.",
            definitionNative = "Ваучер, дающий скидку или льготу при покупке товаров в супермаркете.",
            example = "הִשְׁתַּמַּשְׁתִּי בְּקֻפּוֹן וְחָסַכְתִּי עֶשְׂרִים אָחוּז עַל הַקְּנִיָּה.",
            exampleNative = "Я использовал קֻפּוֹן и сэкономил двадцать процентов на покупке.",
         fillInBlankExclusions = listOf(104401L, 104402L, 104403L, 104405L, 104406L, 104408L, 104412L, 104413L, 104414L, 104415L, 104416L, 104417L, 104421L, 104422L, 104423L, 104424L, 104425L)),
        WordEntity(
            id = 104405, setId = 1044, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "supermarket_basics", transliteration = "mekhir",
            original = "מְחִיר", translation = "цена",
            definition = "הַסְּכוּם הַכַּסְפִּי שֶׁמְּשַׁלְּמִים עַל מוּצָר אוֹ שֵׁרוּת.",
            definitionNative = "Денежная сумма, которую платят за товар или услугу.",
            example = "הַמְּחִיר שֶׁל הַשֶּׁמֶן עָלָה הַחֹדֶשׁ.",
            exampleNative = "מְחִיר масла вырос в этом месяце.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 104406, setId = 1044, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "supermarket_basics", transliteration = "kasai",
            original = "קַסָּאי", translation = "кассир",
            definition = "עוֹבֵד הָעוֹמֵד בַּקֻּפָּה וּמְטַפֵּל בְּתַשְׁלוּמֵי הַקּוֹנִים.",
            definitionNative = "Работник, который стоит за кассой и принимает оплату.",
            example = "שָׁאַלְתִּי אֶת הַקַּסָּאי אֵיפֹה הַמּוּצָר שֶׁחִפַּשְׂתִּי.",
            exampleNative = "Я спросил קַסָּאי, где находится нужный мне товар.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 104407, setId = 1044, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "supermarket_people", transliteration = "kasait",
            original = "קַסַּאִית", translation = "кассирша",
            definition = "עוֹבֶדֶת הָעוֹמֶדֶת בַּקֻּפָּה וּמְטַפֶּלֶת בְּתַשְׁלוּמֵי הַקּוֹנִים.",
            definitionNative = "Работница, которая стоит за кассой и принимает оплату.",
            example = "הַקַּסַּאִית סָרְקָה אֶת כָּל הַמּוּצָרִים בְּמְהִירוּת.",
            exampleNative = "קַסַּאִית быстро просканировала все товары.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 104408, setId = 1044, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "supermarket_basics", transliteration = "madaf",
            original = "מָדָף", translation = "полка",
            definition = "מִשְׁטָח אֲנָכִי בְּחֶנוּת שֶׁמַּצִּיגִים עָלָיו מוּצָרִים לִמְכִירָה.",
            definitionNative = "Горизонтальная поверхность в магазине, на которой выставлены товары.",
            example = "חִיפַּשְׁתִּי אֶת הַשּׁוֹקוֹלָד בְּמָדָף הַמִּתּוּקִים.",
            exampleNative = "Я искал шоколад на מָדָף со сладостями.",
         fillInBlankExclusions = listOf(104401L, 104402L, 104403L, 104404L, 104405L, 104406L, 104414L, 104415L, 104416L, 104417L, 104421L, 104422L, 104423L, 104424L, 104425L)),
        WordEntity(
            id = 104409, setId = 1044, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "supermarket_quality", transliteration = "tari",
            original = "טָרִי", translation = "свежий",
            definition = "מָזוֹן שֶׁלֹּא עָבַר עִבּוּד וְנִמְכָּר בְּמַצְּבוֹ הַטִּבְעִי.",
            definitionNative = "Продукт, не прошедший обработку и продаваемый в натуральном виде.",
            example = "הַלֶּחֶם הַטָּרִי נִמְכָּר בַּבֹּקֶר בִּלְבַד.",
            exampleNative = "Свежий טָרִי хлеб продаётся только утром.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 104410, setId = 1044, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "supermarket_quality", transliteration = "kafua",
            original = "קָפוּא", translation = "замороженный",
            definition = "מָזוֹן שֶׁשֻּׁמַּר בְּטֶמְפֶּרָטוּרָה שֶׁל מִינוּס לְשִׁמּוּר לְאֹרֶךְ זְמַן.",
            definitionNative = "Продукт, хранившийся при минусовой температуре для длительного хранения.",
            example = "קָנִיתִי פִּיצָּה קְפוּאָה לַאֲרוּחַת עֶרֶב.",
            exampleNative = "Я купил замороженную קָפוּא пиццу на ужин.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 104411, setId = 1044, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "supermarket_labels", transliteration = "ta'arikh tokef",
            original = "תַּאֲרִיךְ תֹּקֶף", translation = "срок годности",
            definition = "הַתַּאֲרִיךְ הָאַחֲרוֹן שֶׁבּוֹ מוּתָּר לְהִשְׁתַּמֵּשׁ בַּמּוּצָר.",
            definitionNative = "Последняя дата, до которой разрешено использовать продукт.",
            example = "תָּמִיד בּוֹדְקִים אֶת תַּאֲרִיךְ הַתֹּקֶף לִפְנֵי קְנִיָּה.",
            exampleNative = "Всегда проверяй תַּאֲרִיךְ תֹּקֶף перед покупкой.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 104412, setId = 1044, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "supermarket_deals", transliteration = "hanakha",
            original = "הַנָּחָה", translation = "скидка",
            definition = "הוֹרָדַת מְחִיר שֶׁנּוֹתֵן הַמּוֹכֵר לְקוֹנֶה.",
            definitionNative = "Снижение цены, предоставляемое продавцом покупателю.",
            example = "קִבַּלְתִּי הַנָּחָה שֶׁל עֶשְׂרִים אָחוּז בְּכַרְטִיס הַמּוֹעֶדוֹן.",
            exampleNative = "Я получил הַנָּחָה двадцать процентов по карте клуба.",
         fillInBlankExclusions = listOf(104404L, 104413L)),
        WordEntity(
            id = 104413, setId = 1044, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "supermarket_deals", transliteration = "mivtza",
            original = "מָבְצָע", translation = "акция, распродажа",
            definition = "הַצָּעָה מְיֻחֶדֶת לִמְכִירַת מוּצָר בְּמְחִיר מוּפְחָת לְזְמַן מוּגְבָּל.",
            definitionNative = "Специальное предложение по продаже товара по сниженной цене на ограниченный срок.",
            example = "יֵשׁ מָבְצָע שֶׁל קְנֵה שְׁנַיִם קַבֵּל שְׁלוֹשָׁה עַל שׁוֹקוֹלָד.",
            exampleNative = "Есть מָבְצָע «купи два — получи три» на шоколад.",
         fillInBlankExclusions = listOf(104404L, 104412L)),
        WordEntity(
            id = 104414, setId = 1044, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "supermarket_basics", transliteration = "mitzrah",
            original = "מִצְרָח", translation = "стеллаж / полка с товарами",
            definition = "מַדָּף אוֹ שׁוּרַת מַדָּפִים בְּחֲנוּת שָׁם מְסֻדָּרִים מוּצָרִים לְמֶכֶר.",
            definitionNative = "Полка или ряд полок в магазине, на которых выставлены товары для продажи.",
            example = "אֲרִיזוֹת הַדְּגָנִים מְסֻדָּרוֹת בְּמִצְרַח הַבֹּקֶר.",
            exampleNative = "Упаковки с хлопьями расставлены на מִצְרַח завтраков.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 104415, setId = 1044, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "supermarket_basics", transliteration = "sakit",
            original = "שַׂקִּית", translation = "пакет",
            definition = "שַׂקִּית נְיָר אוֹ פְּלַסְטִיק לְהַכְנָסַת קְנִיּוֹת בַּחֲנוּת.",
            definitionNative = "Бумажный или пластиковый пакет для покупок в магазине.",
            example = "בְּיִשְׂרָאֵל מְשַׁלְּמִים עַל שַׂקִּית פְּלַסְטִיק.",
            exampleNative = "В Израиле платят за пластиковый שַׂקִּית.",
         fillInBlankExclusions = listOf(104401L, 104402L, 104403L, 104404L, 104405L, 104406L, 104408L, 104414L, 104416L, 104417L, 104421L, 104422L, 104423L, 104424L, 104425L)),
        WordEntity(
            id = 104416, setId = 1044, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "supermarket_basics", transliteration = "kartis ashrai",
            original = "כַּרְטִיס אַשְׁרַאי", translation = "кредитная карта",
            definition = "כַּרְטִיס בַּנְקָאִי לְתַשְׁלוּם בְּחֶנוּיּוֹת וּבְאִינְטֶרְנֶט.",
            definitionNative = "Банковская карта для оплаты в магазинах и в интернете.",
            example = "שִׁלַּמְתִּי בְּכַרְטִיס אַשְׁרַאי כִּי לֹא הָיָה לִי כֶּסֶף מְזֻמָּן.",
            exampleNative = "Я заплатил כַּרְטִיס אַשְׁרַאי, потому что не было наличных.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 104417, setId = 1044, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "supermarket_basics", transliteration = "mits tapuzim",
            original = "מִיץ תַּפּוּזִים", translation = "апельсиновый сок",
            definition = "מֶשְׁקֶה פְּרוּת הַנִּסְחָט מִתַּפּוּזִים טְרִיִּים אוֹ מְרוּכָּז.",
            definitionNative = "Фруктовый напиток, выжатый из свежих или концентрированных апельсинов.",
            example = "קָנִיתִי בַּסּוּפֶּר קַרְטוֹן מִיץ תַּפּוּזִים טָרִי.",
            exampleNative = "Я купил в супере картонку свежего מִיץ תַּפּוּזִים.",
         fillInBlankExclusions = listOf(104401L, 104402L, 104403L, 104404L, 104405L, 104406L, 104408L, 104414L, 104415L, 104416L, 104418L, 104421L, 104422L, 104423L, 104424L, 104425L)),
        WordEntity(
            id = 104418, setId = 1044, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "supermarket_dairy", transliteration = "yogurt",
            original = "יוֹגוּרְט", translation = "йогурт",
            definition = "מוּצַר חָלָב מְּחֻמָּץ עֲשִׁיר בְּחֶלְבּוֹנוֹת וּבְּחִידְקֵי חָלָב.",
            definitionNative = "Кисломолочный продукт, богатый белками и молочными бактериями.",
            example = "הוּא אוֹכֵל יוֹגוּרְט עִם פֵּרוֹת לַאֲרוּחַת בֹּקֶר.",
            exampleNative = "Он ест יוֹגוּרְט с фруктами на завтрак.",
         fillInBlankExclusions = listOf(104419L, 104421L, 104424L, 104425L)),
        WordEntity(
            id = 104419, setId = 1044, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "supermarket_dairy", transliteration = "shamenet",
            original = "שַׁמְנֶת", translation = "сметана",
            definition = "מוּצַר חָלָב שֶׁנּוֹצָר מֵחֶמְאַת חָלָב בַּעַל מְרַקָּם עָבֶה.",
            definitionNative = "Молочный продукт, получаемый из сливок молока, с густой консистенцией.",
            example = "הוֹסַפְתִּי שַׁמְנֶת לְמָרָק הַגֶּזֶר.",
            exampleNative = "Я добавил שַׁמְנֶת в морковный суп.",
         fillInBlankExclusions = listOf(104418L, 104421L, 104422L, 104423L)),
        WordEntity(
            id = 104420, setId = 1044, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "supermarket_meat", transliteration = "nkaniyk",
            original = "נְקָנִיק", translation = "сосиска, колбаса",
            definition = "מוּצַר בָּשָׂר מְעֻבָּד הַנָּמְכָּר בְּצִינּוּר דַּק מְמֻלָּא.",
            definitionNative = "Переработанный мясной продукт, продаваемый в тонкой оболочке.",
            example = "קָנִיתִי נְקָנִיקִיּוֹת לַמַּנְגָּל בְּשִׁישִׁי.",
            exampleNative = "Я купил נְקָנִיק для мангала в пятницу.",
        ),
        WordEntity(
            id = 104421, setId = 1044, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "supermarket_basics", transliteration = "ktaniyot",
            original = "קְטָנִיּוֹת", translation = "бобовые (горох, фасоль, чечевица)",
            definition = "קַבּוּצַת מָזוֹן הַכּוֹלֶלֶת עֲדָשִׁים, שְׁעוּעִית, חוּמּוּס וְאֵפוּנָה.",
            definitionNative = "Группа продуктов: чечевица, фасоль, нут, горох.",
            example = "קְטָנִיּוֹת הֵן מָקוֹר מֻצָּלָן לְחֶלְבּוֹן צְמַחוֹנִי.",
            exampleNative = "Бобовые — отличный источник растительного белка.",
         fillInBlankExclusions = listOf(104401L, 104402L, 104403L, 104404L, 104405L, 104406L, 104408L, 104414L, 104415L, 104416L, 104417L, 104422L, 104423L, 104424L, 104425L)),
        WordEntity(
            id = 104422, setId = 1044, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "supermarket_basics", transliteration = "tavlin",
            original = "תְּבָלִין", translation = "специи, пряности",
            definition = "חֹמְרֵי טַעַם וְרֵיחַ הַמּוּסָפִים לְמָזוֹן לְהַעֲשָׁרַת הַטַּעַם.",
            definitionNative = "Ароматические добавки к пище для усиления вкуса.",
            example = "הִיא הוֹסִיפָה תְּבָלִין רַבִּים לְמָרָק.",
            exampleNative = "Она добавила много תְּבָלִין в суп.",
         fillInBlankExclusions = listOf(104401L, 104402L, 104403L, 104404L, 104405L, 104406L, 104408L, 104414L, 104415L, 104416L, 104417L, 104421L, 104423L, 104424L, 104425L)),
        WordEntity(
            id = 104423, setId = 1044, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "supermarket_basics", transliteration = "shumshum",
            original = "שֻׁמְשּׁוּם", translation = "кунжут (семена сезама)",
            definition = "זְרָעִים קְטַנִּים הַמְּשַׁמְּשִׁים לְבִישּׁוּל, בִּמְיֻחָד בְּלֶחֶם וּסְלָטִים.",
            definitionNative = "Маленькие семена, используемые в кулинарии, особенно для хлеба и салатов.",
            example = "לַחֲמָנִיּוֹת עִם שֻׁמְשּׁוּם פּוֹפּוּלָרִיּוֹת בְּיִשְׂרָאֵל.",
            exampleNative = "Булочки с שֻׁמְשּׁוּם популярны в Израиле.",
         fillInBlankExclusions = listOf(104401L, 104402L, 104403L, 104404L, 104405L, 104406L, 104408L, 104414L, 104415L, 104416L, 104417L, 104421L, 104422L, 104424L, 104425L)),
        WordEntity(
            id = 104424, setId = 1044, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "supermarket_basics", transliteration = "egozim",
            original = "אֱגּוֹזִים", translation = "орехи",
            definition = "פֵּרוֹת יַבְּשִׁים עָשִׁירִים בְּשׁוּמָנִים בְּרִיאִים כּגוֹן אֱגּוֹז מֶלֶךְ וּשְׁקֵדִים.",
            definitionNative = "Сухофрукты, богатые полезными жирами: грецкий орех, миндаль и др.",
            example = "קָנִיתִי שַׂקִּית אֱגּוֹזִים מְעֹרָבִים לַחֲטִיף.",
            exampleNative = "Я купил пакет смешанных אֱגּוֹזִים для перекуса.",
         fillInBlankExclusions = listOf(104401L, 104402L, 104403L, 104404L, 104405L, 104406L, 104408L, 104414L, 104416L, 104417L, 104421L, 104422L, 104423L, 104425L)),
        WordEntity(
            id = 104425, setId = 1044, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "supermarket_basics", transliteration = "riva",
            original = "רִיבָּה", translation = "джем, варенье",
            definition = "מַמְרַח פֵּרוֹת מְבֻשָּׁל עִם סֻכָּר הַמְּשַׁמֵּשׁ לְמְרִיחָה עַל לֶחֶם.",
            definitionNative = "Фруктовый намазной продукт, сваренный с сахаром, для намазывания на хлеб.",
            example = "הֵכַנְתִּי רִיבַּת תּוּת בַּיִת מֵהַתּוּתִים שֶׁבַּגִּינָּה.",
            exampleNative = "Я приготовил домашнее клубничное רִיבָּה из ягод в саду.",
         isFillInBlankSafe = false),

        // ──────────────────────────────────────────────────────
        // Set 1045 — בית חולים ורפואה  (Hospital and medicine, B1/B2),
        // 25 words: 6 COMMON + 10 UNCOMMON + 6 RARE + 2 EPIC + 1 LEGENDARY
        // ──────────────────────────────────────────────────────

                                                                                                                                                                                                        
        // ──────────────────────────────────────────────────────
        // Set 1046 — תחבורה ציבורית  (Public transport, A2/B1),
        // 25 words: 6 COMMON + 10 UNCOMMON + 6 RARE + 2 EPIC + 1 LEGENDARY
        // ──────────────────────────────────────────────────────

                                                                                                                                                                                                            )
}
