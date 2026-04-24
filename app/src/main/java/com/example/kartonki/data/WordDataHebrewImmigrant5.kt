package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary for immigrants and new residents in Israel — batch 5.
 * Sets 1142–1144: Bituchi Leumi, Shuk, Security/Shelter.
 */
object WordDataHebrewImmigrant5 {

    val sets = listOf(
                WordSetEntity(id = 1143, name = "Еда и кулинария: продвинутый — покупки на шуке, торговля и продукты",     description = "Покупки на шуке, торговля и продукты",       languagePair = "he-ru", orderIndex = 143,
    topic = "Еда и кулинария", level = 2),
            )

    val words = listOf(

        // ──────────────────────────────────────────────────────────────────────
        // Set 1142 — Битуах Леуми (Национальное страхование),
        // ──────────────────────────────────────────────────────────────────────

                                                                                                                                                                                                        
        // ──────────────────────────────────────────────────────────────────────
        // Set 1143 — Рынок и базар (שׁוּק),
        // ──────────────────────────────────────────────────────────────────────

        WordEntity(
            id = 114301, setId = 1143, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "shuk", transliteration = "dukan",
            original = "דּוּכָן", translation = "прилавок / ларёк",
            definition = "מִבְנֶה קָטָן בַּשּׁוּק שֶׁבּוֹ מוֹכְרִים מֻצָרִים.",
            definitionNative = "Небольшое сооружение на рынке, где продают товары.",
            example = "קָנִיתִי תַּפּוּחִים בַּדּוּכָן הַיְּרֹק.",
            exampleNative = "Я купил яблоки на зелёном דּוּכָן.",
        ),
        WordEntity(
            id = 114302, setId = 1143, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "shuk", transliteration = "kone",
            original = "קוֹנֶה", translation = "покупатель",
            definition = "מִי שֶׁמְּשַׁלֵּם כֶּסֶף עַל מֻצָר אוֹ שֵׁרוּת.",
            definitionNative = "Тот, кто платит деньги за товар или услугу.",
            example = "הַקּוֹנֶה בִּקֵּשׁ הֲנָחָה עַל הַיְּרָקוֹת.",
            exampleNative = "קוֹנֶה попросил скидку на овощи.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 114303, setId = 1143, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "shuk", transliteration = "hanача",
            original = "הֲנָחָה", translation = "скидка",
            definition = "הוֹרָדַת מְחִיר לְצוֹרֶךְ מְכִירָה אוֹ כְּמֵחֻוָּה לַלָּקוֹחַ.",
            definitionNative = "Снижение цены для продажи или в знак уважения к покупателю.",
            example = "קִיבַּלְתִּי הֲנָחָה כִּי קָנִיתִי הַרְבֵּה.",
            exampleNative = "Я получил הֲנָחָה, потому что купил много.",
         fillInBlankExclusions = listOf(114312L)),
        WordEntity(
            id = 114304, setId = 1143, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "shuk", transliteration = "mishkal",
            original = "מִשְׁקָל", translation = "весы / вес",
            definition = "מַכְשִׁיר לְמַדִּידַת כּוֹבֶד שֶׁל מֻצָר.",
            definitionNative = "Прибор для измерения веса товара.",
            example = "הַמּוֹכֵר שָׁם אֶת הַפֵּרוֹת עַל הַמִּשְׁקָל.",
            exampleNative = "Продавец положил фрукты на מִשְׁקָל.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 114305, setId = 1143, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "shuk", transliteration = "l'hitmakaḥ",
            original = "לְהִתְמַקֵּחַ", translation = "торговаться / торг",
            definition = "לְנַסּוֹת לְהוֹרִיד אֶת הַמְּחִיר בַּדִּבּוּר עִם הַמּוֹכֵר.",
            definitionNative = "Пытаться снизить цену в разговоре с продавцом.",
            example = "בַּשּׁוּק רָגִיל לְהִתְמַקֵּחַ עַל הַמְּחִיר.",
            exampleNative = "На рынке принято לְהִתְמַקֵּחַ о цене.",
        ),
        WordEntity(
            id = 114306, setId = 1143, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "shuk", transliteration = "m'chira",
            original = "מְכִירָה", translation = "продажа / распродажа",
            definition = "פְּעוּלַת מְסִירַת מֻצָר תְּמוּרַת כֶּסֶף.",
            definitionNative = "Действие передачи товара в обмен на деньги.",
            example = "הַיּוֹם יֵשׁ מְכִירָה בְּחֲנוּת הַבְּגָדִים.",
            exampleNative = "Сегодня מְכִירָה в магазине одежды.",
         fillInBlankExclusions = listOf(114303L)),
        WordEntity(
            id = 114307, setId = 1143, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "shuk", transliteration = "perot",
            original = "פֵּרוֹת", translation = "фрукты",
            definition = "חֵלֶק הַצֶּמַח הַמְּכִיל זְרָעִים וְנֶאֱכָל טָרִי.",
            definitionNative = "Часть растения, содержащая семена и употребляемая в пищу свежей.",
            example = "קָנִינוּ הַרְבֵּה פֵּרוֹת בַּשּׁוּק הַיּוֹם.",
            exampleNative = "Мы купили много פֵּרוֹת на рынке сегодня.",
         fillInBlankExclusions = listOf(114308L, 114309L, 114310L, 114311L, 114318L, 114319L, 114321L, 114322L, 114324L)),
        WordEntity(
            id = 114308, setId = 1143, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "shuk", transliteration = "y'rakot",
            original = "יְרָקוֹת", translation = "овощи",
            definition = "צְמָחִים נֶאֱכָלִים כְּגוֹן עַגְבָנִיָּה, מְלָפְפוֹן וְגֶזֶר.",
            definitionNative = "Съедобные растения, такие как помидор, огурец и морковь.",
            example = "יְרָקוֹת טְרִיִּים בַּשּׁוּק זוֹלִים מֵהַסּוּפֶּר.",
            exampleNative = "Свежие יְרָקוֹת на рынке дешевле, чем в супермаркете.",
         fillInBlankExclusions = listOf(114307L, 114309L, 114318L)),
        WordEntity(
            id = 114309, setId = 1143, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "shuk", transliteration = "esbei tibul",
            original = "עֶשְׂבֵּי תִּיבּוּל", translation = "пряные травы / зелень",
            definition = "צְמָחִים אֲרוֹמַטִיִּים כְּגוֹן נַעֲנַע, פֶּטְרוֹזִילְיָה וְכוּסְבָּרָה.",
            definitionNative = "Ароматические растения, такие как мята, петрушка и кинза.",
            example = "קָנִיתִי עֶשְׂבֵּי תִּיבּוּל לַסָּלָט.",
            exampleNative = "Я купил עֶשְׂבֵּי תִּיבּוּל для салата.",
         fillInBlankExclusions = listOf(114307L, 114308L, 114310L, 114318L, 114319L, 114320L, 114321L, 114322L, 114323L)),
        WordEntity(
            id = 114310, setId = 1143, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "shuk", transliteration = "humus",
            original = "חֻמּוּס", translation = "хумус",
            definition = "מַחִית מַטְעֶמֶת מֵחֻמְּצִיוֹת עִם טְחִינָה וְלִימוֹן.",
            definitionNative = "Питательная паста из нута с тахини и лимоном.",
            example = "הַחֻמּוּס הַטָּרִי בַּשּׁוּק הֲכִי טָעִים.",
            exampleNative = "Свежий חֻמּוּס на рынке — самый вкусный.",
         fillInBlankExclusions = listOf(114319L, 114320L, 114321L, 114322L)),
        WordEntity(
            id = 114311, setId = 1143, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "shuk", transliteration = "shvarma",
            original = "שַׁוַּרְמָה", translation = "шаурма",
            definition = "מַנַּת בָּשָׂר צָלוּי הַמּוֹגֶשֶׁת בְּפִיתָה עִם תּוֹסָפוֹת.",
            definitionNative = "Блюдо из жареного мяса, подаваемого в пите с добавками.",
            example = "אָכַלְנוּ שַׁוַּרְמָה בַּשּׁוּק הָעִיר.",
            exampleNative = "Мы ели שַׁוַּרְמָה на городском рынке.",
         fillInBlankExclusions = listOf(114307L, 114308L, 114310L, 114318L, 114320L, 114323L, 114324L)),
        WordEntity(
            id = 114312, setId = 1143, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "shuk", transliteration = "s'kit",
            original = "שְׂקִית", translation = "пакет / мешочек",
            definition = "כְּלִי אֲרִיזָה מִנְיָלוֹן אוֹ נְיָר לְהַכָּנַסַת מֻצָרִים.",
            definitionNative = "Упаковочный пакет из пластика или бумаги для товаров.",
            example = "שַׂמְתִּי אֶת הַיְּרָקוֹת בַּשְּׂקִית.",
            exampleNative = "Я положил овощи в שְׂקִית.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 114313, setId = 1143, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "shuk", transliteration = "agora",
            original = "אֲגוֹרָה", translation = "агора (мелкая монета)",
            definition = "מַטְבֵּעַ הַיִּשְׂרְאֵלִי הַקָּטָן בְּיוֹתֵר, מֵאִית הַשֶּׁקֶל.",
            definitionNative = "Наименьшая израильская монета, одна сотая шекеля.",
            example = "הַמְּחִיר הוּא שְׁלוֹשָׁה שְׁקָלִים וַחֲמִשִּׁים אֲגוֹרוֹת.",
            exampleNative = "Цена — три шекеля и пятьдесят אֲגוֹרוֹת.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 114314, setId = 1143, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "shuk", transliteration = "khanut",
            original = "חֲנוּת", translation = "магазин",
            definition = "מָקוֹם שֶׁבּוֹ מוֹכְרִים מֻצָרִים לַלָּקוֹחוֹת.",
            definitionNative = "Место, где продают товары покупателям.",
            example = "פָּתַחְנוּ חֲנוּת קְטַנָּה בַּשּׁוּק.",
            exampleNative = "Мы открыли маленькую חֲנוּת на рынке.",
         fillInBlankExclusions = listOf(114315L)),
        WordEntity(
            id = 114315, setId = 1143, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "shuk", transliteration = "machólet",
            original = "מְכֹלֶת", translation = "продуктовый магазин / бакалея",
            definition = "חֲנוּת קְטַנָּה הַמּוֹכֶרֶת מַזּוֹן וּמוּצָרֵי יוֹמְיוֹם.",
            definitionNative = "Небольшой магазин, торгующий едой и товарами повседневного спроса.",
            example = "יֵשׁ מְכֹלֶת פְּתוּחָה בְּכָל שָׁעָה בַּשְּׁכוּנָה.",
            exampleNative = "В районе есть круглосуточная מְכֹלֶת.",
         fillInBlankExclusions = listOf(114314L, 114316L)),
        WordEntity(
            id = 114316, setId = 1143, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "shuk", transliteration = "kupa",
            original = "קוּפָּה", translation = "касса",
            definition = "מָקוֹם בַּחֲנוּת שֶׁבּוֹ מְשַׁלְּמִים עַל הַקְּנִיּוֹת.",
            definitionNative = "Место в магазине, где платят за покупки.",
            example = "הַתּוֹר לַקּוּפָּה אָרֹךְ הַיּוֹם.",
            exampleNative = "Очередь к קוּפָּה сегодня длинная.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 114317, setId = 1143, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "shuk", transliteration = "kilogram",
            original = "כִּילוֹגְרָם", translation = "килограмм",
            definition = "יְחִידַת מִשְׁקָל הַשָּׁוָה לְאֶלֶף גְּרָמִים.",
            definitionNative = "Единица веса, равная тысяче граммов.",
            example = "כַּמָּה עוֹלֶה כִּילוֹגְרָם עַגְבָנִיּוֹת?",
            exampleNative = "Сколько стоит כִּילוֹגְרָם помидоров?",
         fillInBlankExclusions = listOf(114312L)),
        WordEntity(
            id = 114318, setId = 1143, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "shuk", transliteration = "zeitim",
            original = "זֵיתִים", translation = "оливки / маслины",
            definition = "פְּרִי הַזַּיִת, נֶאֱכָל כָּבוּשׁ אוֹ מְשַׁמֵּשׁ לְהַפָּקַת שֶׁמֶן.",
            definitionNative = "Плод оливкового дерева, употребляемый маринованным или для производства масла.",
            example = "קָנִיתִי קִילוֹגְרָם זֵיתִים שְׁחוֹרִים.",
            exampleNative = "Я купил килограмм чёрных זֵיתִים.",
         fillInBlankExclusions = listOf(114307L, 114308L)),
        WordEntity(
            id = 114319, setId = 1143, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "shuk", transliteration = "limon",
            original = "לִימוֹן", translation = "лимон",
            definition = "פְּרִי חָמוּץ צָהֹב הַמְּשַׁמֵּשׁ לְבִישּׁוּל וּלְשֵׁרוּתֵי בְּרִיאוּת.",
            definitionNative = "Жёлтый кислый фрукт, используемый в кулинарии и для здоровья.",
            example = "סָחַטְתִּי לִימוֹן עַל הַסָּלָט.",
            exampleNative = "Я выжал לִימוֹן на салат.",
         fillInBlankExclusions = listOf(114321L, 114323L)),
        WordEntity(
            id = 114320, setId = 1143, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "shuk", transliteration = "agas",
            original = "אֲגַס", translation = "груша",
            definition = "פְּרִי מָתוֹק בְּצוּרַת דְּמָעָה, בְּדֶרֶךְ כְּלָל צָהֹב אוֹ יָרֹק.",
            definitionNative = "Сладкий грушевидный фрукт, обычно жёлтый или зелёный.",
            example = "קָנִיתִי חֲמִישָּׁה אֲגָסִים בַּשּׁוּק.",
            exampleNative = "Я купил пять אֲגָסִים на рынке.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 114321, setId = 1143, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "shuk", transliteration = "maionez",
            original = "מַיּוֹנֵז", translation = "майонез",
            definition = "רֹטֶב קְרֵמִי עָשׂוּי מִבֵּיצִים וְשֶׁמֶן לְתִבּוּל.",
            definitionNative = "Кремообразный соус из яиц и масла для заправки блюд.",
            example = "שָׂמַנוּ מַיּוֹנֵז בַּשָּׁלִישׁ.",
            exampleNative = "Мы добавили מַיּוֹנֵז в салат.",
        ),
        WordEntity(
            id = 114322, setId = 1143, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "shuk", transliteration = "shemen zayit",
            original = "שֶׁמֶן זַיִת", translation = "оливковое масло",
            definition = "שֶׁמֶן הַמֻּפָּק מִפֵּרוֹת הַזַּיִת, נָפוֹץ בְּבִישּׁוּל יִשְׂרְאֵלִי.",
            definitionNative = "Масло, получаемое из плодов оливы, широко используемое в израильской кухне.",
            example = "שֶׁמֶן זַיִת טוֹב הוּא מַתָּנָה נְפוֹצָה.",
            exampleNative = "Хорошее שֶׁמֶן זַיִת — популярный подарок.",
         fillInBlankExclusions = listOf(114310L)),
        WordEntity(
            id = 114323, setId = 1143, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "shuk", transliteration = "eshkolit",
            original = "אֶשְׁכּוֹלִית", translation = "грейпфрут",
            definition = "פְּרִי הֶדֶר גָּדוֹל וְחָמְצוּצִי, נָפוֹץ בְּיִשְׂרָאֵל.",
            definitionNative = "Крупный кисловатый цитрусовый фрукт, широко распространённый в Израиле.",
            example = "שָׁתִיתִי מִיץ אֶשְׁכּוֹלִית בַּבֹּקֶר.",
            exampleNative = "Утром я выпил сок אֶשְׁכּוֹלִית.",
         fillInBlankExclusions = listOf(114307L, 114308L, 114319L, 114320L)),
        WordEntity(
            id = 114324, setId = 1143, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "shuk", transliteration = "pita",
            original = "פִּיתָה", translation = "пита (лепёшка)",
            definition = "לֶחֶם שָׁטוּחַ יִשְׂרְאֵלִי שֶׁנֶּאֱכָל עִם חֻמּוּס, שַׁוַּרְמָה וְעוֹד.",
            definitionNative = "Израильская плоская лепёшка, которую едят с хумусом, шаурмой и другим.",
            example = "בִּלַּעְנוּ פִּיתָה עִם חֻמּוּס בַּשּׁוּק.",
            exampleNative = "Мы ели פִּיתָה с хумусом на рынке.",
         fillInBlankExclusions = listOf(114308L, 114309L, 114311L, 114318L)),
        WordEntity(
            id = 114325, setId = 1143, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "shuk", transliteration = "m'zuman",
            original = "מְזוּמָן", translation = "наличные деньги",
            definition = "כֶּסֶף פִּיזִי בְּשֵׁם מַטְבְּעוֹת וּשְׁטָרוֹת, בְּנִגּוּד לְכַרְטִיס אַשְׁרַאי.",
            definitionNative = "Физические деньги в виде монет и купюр, в отличие от кредитной карты.",
            example = "בַּשּׁוּק הַיָּשָׁן מְקַבְּלִים רַק מְזוּמָן.",
            exampleNative = "На старом рынке принимают только מְזוּמָן.",
        ),

        // ──────────────────────────────────────────────────────────────────────
        // Set 1144 — Безопасность и убежище
        // ──────────────────────────────────────────────────────────────────────

                                                                                                                                                                                                            )
}
