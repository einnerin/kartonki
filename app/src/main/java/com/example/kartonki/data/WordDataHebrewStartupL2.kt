package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Стартап", L2 «Продвинутый базовый» (UNCOMMON+RARE).
 *
 * Set 1789: «Стартап» — продвинутый L2:
 *           Базовая лексика повседневной работы стартапа на ранней стадии —
 *           то, о чём говорят первые два-три месяца после регистрации компании:
 *           кто наш рынок, кто наш клиент, как назовём продукт, как продать,
 *           что значит «запустились» и «остановились».
 *
 * Уровень намеренно проще, чем L3 (там — `MVP`, `validation`, `traction`,
 * `customer development`). Здесь — повседневные слова, которые услышишь
 * в первой беседе с основателем за кофе: «целевой рынок», «холодное письмо»,
 * «первая встреча», «обратная связь», «запустились».
 *
 * Распределение редкостей: 13 UNCOMMON + 12 RARE.
 *
 * SemanticGroups (5 × 5):
 *   startup_market           — рынок: целевой рынок, потребность рынка,
 *                              конкурент, анализ рынка, сегмент рынка
 *   startup_customers_basic  — клиенты: целевой клиент, первая встреча,
 *                              презентация продукта, демо-версия, обратная связь
 *   startup_product_basic    — продукт: название продукта, логотип, миссия,
 *                              обещание продукта, цена продукта
 *   startup_sales_basic      — продажи: холодное письмо, телефонный звонок,
 *                              черновик договора, скидка, первая продажа
 *   startup_lifecycle_basic  — жизненный цикл: запуск, рост, приостановка,
 *                              новое направление, закрытие компании
 *
 * Word IDs: setId × 100 + position (178901..178925).
 *
 * Пересечения с другими наборами темы «Стартап»:
 *   - L3 (1758) уже содержит `קְהַל יַעַד` (целевая аудитория), `נִישָׁה`
 *     (рыночная ниша), `נִיתוּחַ תַּחֲרוּת` (конкурентный анализ), `מִיסְיוֹן`
 *     (миссия как транслит), `שִׁינּוּי כִּוּוּן` (пивот). В L2 использованы
 *     **другие термины** для близких понятий:
 *       целевой клиент   → `לָקוֹחַ יַעַד` (≠ קְהַל יַעַד — целевая аудитория)
 *       сегмент рынка    → `פֶּלַח שׁוּק` (≠ נִישָׁה — узкая ниша)
 *       анализ рынка     → `נִיתוּחַ שׁוּק` (≠ נִיתוּחַ תַּחֲרוּת — анализ конкурентов)
 *       миссия           → `יִעוּד` (≠ מִיסְיוֹן — английский транслит)
 *       новое направление → `כִּוּוּן חָדָשׁ` (≠ שִׁינּוּי כִּוּוּן — резкий пивот)
 *   - L4 (1759) и L5 (1760) фокусируются на финансировании / scale / exit —
 *     никаких пересечений с базовой лексикой L2.
 *   - Параллельный L1 (1788) делается отдельным агентом — там самые простые
 *     COMMON слова (идея, команда, офис и т.п.), не пересекаются с L2.
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них
 * отключён, пока LLM-pipeline не пройдёт по набору и не проставит
 * fillInBlankExclusions.
 */
object WordDataHebrewStartupL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1789, languagePair = "he-ru", orderIndex = 1789,
            name = "Стартап",
            description = "Продвинутый базовый: рынок, клиенты, продукт, продажи, жизненный цикл",
            topic = "Стартап", level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1789 — Стартап: продвинутый базовый (L2, UNCOMMON+RARE)
        // 5 групп × 5 слов: market, customers_basic, product_basic,
        //                   sales_basic, lifecycle_basic
        // ══════════════════════════════════════════════════════════════════════

        // ── startup_market (5) — на каком рынке играет стартап ──
        WordEntity(
            id = 178901, setId = 1789, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_market", transliteration = "shuk yaad",
            original = "שׁוּק יַעַד", translation = "целевой рынок",
            definition = "הַתְּחוּם הַכַּלְכָּלִי שֶׁבּוֹ הַחֶבְרָה רוֹצָה לִמְכֹּר וְלִצְמֹחַ בַּשָּׁנִים הַקְּרוֹבוֹת.",
            definitionNative = "Та сфера экономики, где фирма хочет продавать и расти в ближайшие годы.",
            example = "שׁוּק יַעַד שֶׁלָּנוּ הוּא בָּתֵּי קָפֶה קְטַנִּים בְּתֵל אָבִיב.",
            exampleNative = "Наш שׁוּק יַעַד — маленькие кофейни в Тель-Авиве.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178902, setId = 1789, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_market", transliteration = "tsorekh shuk",
            original = "צֹרֶךְ שׁוּק", translation = "потребность рынка",
            definition = "מַשֶּׁהוּ שֶׁאֲנָשִׁים בָּעֵסֶק רוֹצִים אֲבָל לֹא מוֹצְאִים פִּתְרוֹן טוֹב כָּעֵת.",
            definitionNative = "Что-то, чего хотят люди в бизнесе, но хорошего решения сейчас не находят.",
            example = "מָצָאנוּ צֹרֶךְ שׁוּק חָזָק אֵצֶל מוֹרִים פְּרָטִיִּים לְמָתֵמָטִיקָה.",
            exampleNative = "Мы нашли сильную צֹרֶךְ שׁוּק у частных репетиторов по математике.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178903, setId = 1789, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_market", transliteration = "matkhare",
            original = "מַתְחָרֶה", translation = "конкурент",
            definition = "חֶבְרָה אַחֶרֶת שֶׁמּוֹכֶרֶת מַשֶּׁהוּ דּוֹמֶה לְאוֹתָם לָקוֹחוֹת.",
            definitionNative = "Другая фирма, продающая что-то похожее тем же клиентам.",
            example = "הַמַּתְחָרֶה הָרָאשִׁי שֶׁלָּנוּ פָּתַח מִשְׂרָד בְּחֵיפָה לִפְנֵי שָׁבוּעַ.",
            exampleNative = "Главный наш מַתְחָרֶה открыл офис в Хайфе неделю назад.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178904, setId = 1789, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_market", transliteration = "nituakh shuk",
            original = "נִיתוּחַ שׁוּק", translation = "анализ рынка",
            definition = "אִסּוּף נְתוּנִים עַל גֹּדֶל הַמִּגְזָר, הַלָּקוֹחוֹת וְהַסְּכוּמִים שֶׁמְּסַתּוֹבְבִים בּוֹ.",
            definitionNative = "Сбор данных о размере сектора, его клиентах и о деньгах, которые в нём ходят.",
            example = "נִיתוּחַ שׁוּק חָשַׂף שֶׁחֲצִי מִילְיוֹן יִשְׂרְאֵלִים סוֹבְלִים.",
            exampleNative = "נִיתוּחַ שׁוּק показал — полмиллиона израильтян страдают.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178905, setId = 1789, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_market", transliteration = "pelakh shuk",
            original = "פֶּלַח שׁוּק", translation = "сегмент рынка",
            definition = "חֵלֶק מֻגְדָּר שֶׁל הַשּׁוּק עִם קָהָל מְסֻיָּם וְצוֹרֶךְ דּוֹמֶה.",
            definitionNative = "Очерченная часть рынка с конкретной публикой и схожей нуждой.",
            example = "בָּחַרְנוּ פֶּלַח שׁוּק שֶׁל הוֹרִים צְעִירִים עִם תִּינוֹק רִאשׁוֹן.",
            exampleNative = "Мы выбрали פֶּלַח שׁוּק из молодых родителей с первым ребёнком.",
            isFillInBlankSafe = false,
        ),

        // ── startup_customers_basic (5) — первое касание с клиентами ──
        WordEntity(
            id = 178906, setId = 1789, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_customers_basic", transliteration = "lakoakh yaad",
            original = "לָקוֹחַ יַעַד", translation = "целевой клиент",
            definition = "הָאָדָם הָאִידֵאָלִי שֶׁבִּשְׁבִילוֹ הַחֶבְרָה בּוֹנָה אֶת מָה שֶׁהִיא בּוֹנָה.",
            definitionNative = "Идеальный человек, ради которого фирма строит то, что она строит.",
            example = "לָקוֹחַ יַעַד שֶׁלָּנוּ הוּא חֶשְׁבּוֹנַאי עַצְמָאִי בְּגִיל אַרְבָּעִים.",
            exampleNative = "Наш לָקוֹחַ יַעַד — самозанятый бухгалтер сорока лет.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178907, setId = 1789, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_customers_basic", transliteration = "pgisha rishona",
            original = "פְּגִישָׁה רִאשׁוֹנָה", translation = "первая встреча",
            definition = "מִפְגָּשׁ פָּתוּחַ עִם לָקוֹחַ פּוֹטֶנְצְיָאלִי שֶׁבּוֹ מַכִּירִים זֶה אֶת זֶה.",
            definitionNative = "Открытая встреча с потенциальным клиентом — где знакомятся друг с другом.",
            example = "הַפְּגִישָׁה רִאשׁוֹנָה עִם הַמְּנַהֵל אָרְכָה רַק רֶבַע שָׁעָה.",
            exampleNative = "פְּגִישָׁה רִאשׁוֹנָה с управляющим длилась всего четверть часа.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178908, setId = 1789, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_customers_basic", transliteration = "hatsagat mutsar",
            original = "הַצָּגַת מוּצָר", translation = "презентация продукта",
            definition = "מַעֲמָד שֶׁבּוֹ מַרְאִים לְלָקוֹחַ אֵיךְ הַדָּבָר עוֹבֵד וּמַה הוּא נוֹתֵן לוֹ.",
            definitionNative = "Момент, когда клиенту показывают, как штука работает и что она ему даёт.",
            example = "הַצָּגַת מוּצָר אָרְכָה עֶשְׂרִים דַּקּוֹת וְהִשְׁאִירָה רֹשֶׁם חָזָק.",
            exampleNative = "הַצָּגַת מוּצָר длилась двадцать минут и оставила сильное впечатление.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178909, setId = 1789, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_customers_basic", transliteration = "girsat demo",
            original = "גִּרְסַת דֵּמוֹ", translation = "демо-версия",
            definition = "סִיבּוּב חַי שֶׁל הַדָּבָר עִם נְתוּנִים אֲמִתִּיִּים — לֹא רַק תְּמוּנוֹת בְּמַצֶּגֶת.",
            definitionNative = "Живой прогон штуки на настоящих данных — не одни картинки в презентации.",
            example = "גִּרְסַת דֵּמוֹ אִפְשְׁרָה לַלָּקוֹחַ לִלְחֹץ עַל כַּפְתּוֹרִים בְּעַצְמוֹ.",
            exampleNative = "גִּרְסַת דֵּמוֹ позволила клиенту самому понажимать на кнопки.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178910, setId = 1789, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_customers_basic", transliteration = "mashov",
            original = "מַשּׁוֹב", translation = "обратная связь",
            definition = "מָה שֶׁהָאָדָם אוֹמֵר אַחֲרֵי שֶׁנִּסָּה — מָה הָיָה טוֹב וּמָה הִפְרִיעַ.",
            definitionNative = "То, что человек говорит после того, как попробовал — что было хорошо и что мешало.",
            example = "מַשּׁוֹב מֵחָמֵשׁ הַלָּקוֹחוֹת שִׁנָּה לָנוּ אֶת הַכִּוּוּן.",
            exampleNative = "מַשּׁוֹב от пяти клиентов сменил нам направление работы.",
            isFillInBlankSafe = false,
        ),

        // ── startup_product_basic (5) — что и как называется в продукте ──
        WordEntity(
            id = 178911, setId = 1789, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_product_basic", transliteration = "shem mutsar",
            original = "שֵׁם מוּצָר", translation = "название продукта",
            definition = "הַמִּלָּה הָרִאשׁוֹנָה שֶׁאֲנָשִׁים שׁוֹמְעִים — וְהִיא נִשְׁאֶרֶת אֶצְלָם בָּרֹאשׁ.",
            definitionNative = "Первое слово, которое люди слышат — оно у них и остаётся в голове.",
            example = "שֵׁם מוּצָר טוֹב צָרִיךְ לְהִזָּכֵר בְּקַלּוּת גַּם בְּטֶלֶפוֹן רוֹעֵשׁ.",
            exampleNative = "Хорошее שֵׁם מוּצָר должно легко вспоминаться даже по шумному телефону.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178912, setId = 1789, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_product_basic", transliteration = "logo",
            original = "לוֹגוֹ", translation = "логотип",
            definition = "סִימָן צְיוּרִי קָטָן שֶׁמְּזַהֶה אֶת הַחֶבְרָה עַל אֲרִיזוֹת, אֲתָר וּכְרָטִיסֵי בִּקּוּר.",
            definitionNative = "Маленький рисованный знак, по которому фирму узнают на упаковке, сайте и визитках.",
            example = "מְעַצֶּבֶת חֲבֵרָה הִכִינָה לָנוּ לוֹגוֹ פָּשׁוּט בִּשְׁנֵי צְבָעִים.",
            exampleNative = "Подруга-дизайнер сделала нам простой לוֹגוֹ в двух цветах.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178913, setId = 1789, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_product_basic", transliteration = "yi'ud",
            original = "יִעוּד", translation = "миссия (главная цель компании)",
            definition = "מִשְׁפָּט קָצָר שֶׁאוֹמֵר בִּשְׁבִיל מָה הַחֶבְרָה קַיֶּמֶת בָּעוֹלָם.",
            definitionNative = "Короткая фраза, говорящая, ради чего фирма существует на свете.",
            example = "כָּתַבְנוּ יִעוּד עַל הַקִּיר שֶׁל הַמִּשְׂרָד כְּדֵי לֹא לִשְׁכֹּחַ.",
            exampleNative = "Мы написали יִעוּד на стене офиса, чтобы не забывать.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178914, setId = 1789, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_product_basic", transliteration = "havtakhat mutsar",
            original = "הַבְטָחַת מוּצָר", translation = "обещание продукта",
            definition = "הַתּוֹעֶלֶת הָאַחַת שֶׁהַלָּקוֹחַ מְקַבֵּל בְּוַדָּאוּת אִם יִקְנֶה.",
            definitionNative = "Та одна польза, которую клиент точно получит, если купит.",
            example = "הַבְטָחַת מוּצָר שֶׁלָּנוּ — חֶשְׁבּוֹן מְסֻדָּר בְּחָמֵשׁ דַּקּוֹת.",
            exampleNative = "Наша הַבְטָחַת מוּצָר — упорядоченный счёт за пять минут.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178915, setId = 1789, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_product_basic", transliteration = "mekhir mutsar",
            original = "מְחִיר מוּצָר", translation = "цена продукта",
            definition = "הַסְּכוּם שֶׁהַלָּקוֹחַ מְשַׁלֵּם וְשֶׁמַּשְׁפִּיעַ עַל הַתְּחוּשָׁה אִם זֶה זוֹל אוֹ יָקָר.",
            definitionNative = "Сумма, которую клиент платит — она задаёт ощущение, дёшево это или дорого.",
            example = "הוֹרַדְנוּ מְחִיר מוּצָר בְּחָמֵשׁ עָשָׂר אָחוּז וְהַמְּכִירוֹת קָפְצוּ.",
            exampleNative = "Мы снизили מְחִיר מוּצָר на пятнадцать процентов — продажи выросли.",
            isFillInBlankSafe = false,
        ),

        // ── startup_sales_basic (5) — каналы первой продажи ──
        WordEntity(
            id = 178916, setId = 1789, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_sales_basic", transliteration = "mikhtav kar",
            original = "מִכְתָּב קָר", translation = "холодное письмо",
            definition = "פְּנִיָּה כְּתוּבָה לְאָדָם זָר שֶׁאֵין אִתּוֹ הֶכֵּרוּת קוֹדֶמֶת בִּכְלָל.",
            definitionNative = "Письменное обращение к незнакомому человеку, без всякого предыдущего знакомства.",
            example = "שָׁלַחְתִּי מִכְתָּב קָר לְשִׁבְעִים מְנַהֲלִים וְקִבַּלְתִּי שָׁלוֹשׁ.",
            exampleNative = "Я отправил מִכְתָּב קָר семидесяти управляющим — пришло три.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178917, setId = 1789, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_sales_basic", transliteration = "sikhat telefon",
            original = "שִׂיחַת טֶלֶפוֹן", translation = "телефонный звонок",
            definition = "דִּבּוּר חַי בָּרְשֶׁת — שׁוֹמְעִים זֶה אֶת זֶה אֲבָל לֹא רוֹאִים פָּנִים.",
            definitionNative = "Живой разговор по сети — слышат друг друга, но лиц не видят.",
            example = "סִיכַּמְנוּ אֶת הַעִסְקָה בְּשִׂיחַת טֶלֶפוֹן קְצָרָה שֶׁל שֶׁבַע דַּקּוֹת.",
            exampleNative = "Мы закрыли сделку коротким שִׂיחַת טֶלֶפוֹן на семь минут.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178918, setId = 1789, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_sales_basic", transliteration = "tiyutat khoze",
            original = "טִיוּטַת חוֹזֶה", translation = "черновик договора",
            definition = "גִּרְסָה רָאשׁוֹנָה שֶׁל הַמִּסְמָךְ הַמִּשְׁפָּטִי שֶׁעֲדַיִן עוֹבֶרֶת תִּקּוּנִים.",
            definitionNative = "Первая редакция юридической бумаги — она ещё проходит правки.",
            example = "טִיוּטַת חוֹזֶה הִגִּיעָה בָּעֶרֶב וְעוֹרְכֵי הַדִּין עָבְרוּ עָלֶיהָ בַּבֹּקֶר.",
            exampleNative = "טִיוּטַת חוֹזֶה пришла вечером — юристы прошлись по ней утром.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178919, setId = 1789, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_sales_basic", transliteration = "hanakha",
            original = "הֲנָחָה", translation = "скидка",
            definition = "הוֹרָדָה זְמַנִּית בַּמְּחִיר שֶׁמְּעוֹדֶדֶת אֶת הַלָּקוֹחַ לְהַחְלִיט מַהֵר יוֹתֵר.",
            definitionNative = "Временное снижение цены — побуждает клиента решиться побыстрее.",
            example = "נָתַנּוּ הֲנָחָה שֶׁל שְׁלוֹשִׁים אָחוּז לְעֶשְׂרֶת הַלָּקוֹחוֹת הָרִאשׁוֹנִים.",
            exampleNative = "Мы дали הֲנָחָה в тридцать процентов первой десятке клиентов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178920, setId = 1789, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_sales_basic", transliteration = "mkhira rishona",
            original = "מְכִירָה רִאשׁוֹנָה", translation = "первая продажа",
            definition = "הַעִסְקָה שֶׁבָּהּ מִישֶׁהוּ לֹא מֻכָּר מַעֲבִיר כֶּסֶף תְּמוּרַת מָה שֶׁבָּנִינוּ.",
            definitionNative = "Сделка, в которой незнакомый человек переводит деньги за то, что мы построили.",
            example = "הַמְּכִירָה רִאשׁוֹנָה הָיְתָה לְלָקוֹחַ מֵרָמַת גָּן בְּמָאתַיִם שֶׁקֶל.",
            exampleNative = "מְכִירָה רִאשׁוֹנָה досталась клиенту из Рамат-Гана за двести шекелей.",
            isFillInBlankSafe = false,
        ),

        // ── startup_lifecycle_basic (5) — этапы жизни ранней компании ──
        WordEntity(
            id = 178921, setId = 1789, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_lifecycle_basic", transliteration = "hashaka",
            original = "הַשְׁקָה", translation = "запуск (выход в свет)",
            definition = "הָרֶגַע שֶׁבּוֹ הַחֶבְרָה פּוֹתַחַת אֶת הַדֶּלֶת לַקָּהָל הָרָחָב לַשִּׁמּוּשׁ הָרִאשׁוֹן.",
            definitionNative = "Момент, когда фирма открывает дверь широкой публике для первого использования.",
            example = "אַחֲרֵי שָׁנָה שֶׁל פִּתּוּחַ הִגַּעְנוּ סוֹף סוֹף לְיוֹם הַהַשְׁקָה.",
            exampleNative = "После года разработки мы наконец дошли до дня הַשְׁקָה.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178922, setId = 1789, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "startup_lifecycle_basic", transliteration = "tsmikha",
            original = "צְמִיחָה", translation = "рост (компании)",
            definition = "תְּקוּפָה שֶׁבָּהּ מִסְפַּר הַלָּקוֹחוֹת וְהַהַכְנָסוֹת עוֹלִים מֵחֹדֶשׁ לְחֹדֶשׁ.",
            definitionNative = "Период, когда количество клиентов и доходы поднимаются от месяца к месяцу.",
            example = "אַחֲרֵי הַהַשְׁקָה הִתְחִילָה שָׁנָה שֶׁל צְמִיחָה מְהִירָה וְלֹא צְפוּיָה.",
            exampleNative = "После запуска начался год быстрого и неожиданного צְמִיחָה.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178923, setId = 1789, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_lifecycle_basic", transliteration = "atsirat pe'ila",
            original = "עֲצִירַת פְּעִילוּת", translation = "приостановка деятельности",
            definition = "הַחְלָטָה לְהַפְסִיק לִמְכֹּר וּלְפַתֵּחַ זְמַנִּית כְּדֵי לִבְחֹן מָה הָלְאָה.",
            definitionNative = "Решение временно прекратить продажи и разработку — чтобы обдумать, что дальше.",
            example = "עֲצִירַת פְּעִילוּת שֶׁל חָדְשַׁיִם עָזְרָה לָנוּ לְהָבִין מָה לֹא עוֹבֵד.",
            exampleNative = "עֲצִירַת פְּעִילוּת на два месяца помогла нам понять, что не работает.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178924, setId = 1789, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_lifecycle_basic", transliteration = "kivun khadash",
            original = "כִּוּוּן חָדָשׁ", translation = "новое направление",
            definition = "מַסְלוּל אַחֵר שֶׁהַחֶבְרָה בּוֹחֶרֶת אַחֲרֵי שֶׁהָרָאשׁוֹן הִתְבָּרֵר כְּלֹא מַתְאִים.",
            definitionNative = "Другая дорога, которую фирма выбирает после того, как первая оказалась негодной.",
            example = "אַחֲרֵי חֲצִי שָׁנָה שֶׁל כִּשְׁלוֹנוֹת בָּחַרְנוּ כִּוּוּן חָדָשׁ לְגַמְרֵי.",
            exampleNative = "После полугода неудач мы выбрали совершенно כִּוּוּן חָדָשׁ.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178925, setId = 1789, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_lifecycle_basic", transliteration = "sgirat khevra",
            original = "סְגִירַת חֶבְרָה", translation = "закрытие компании",
            definition = "סוֹף הַדֶּרֶךְ שֶׁל הָעֵסֶק — מְפַטְּרִים עוֹבְדִים, מַחְזִירִים חוֹבוֹת וְסוֹגְרִים תִּיק.",
            definitionNative = "Конец пути бизнеса — увольняют людей, отдают долги, закрывают дело.",
            example = "סְגִירַת חֶבְרָה הָיְתָה הַחְלָטָה כּוֹאֶבֶת אֲבָל נְכוֹנָה לְכֻלָּנוּ.",
            exampleNative = "סְגִירַת חֶבְרָה было больным, но правильным решением для всех нас.",
            isFillInBlankSafe = false,
        ),
    )
}
