package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Шоппинг и покупки", уровень L5 (носитель языка).
 *
 * Set 1793: «Шоппинг и покупки» — носитель языка (EPIC + LEGENDARY).
 *           Бренд-стратегия высокого уровня, потребительское право
 *           Израиля, маркетинг-психология (когнитивные искажения и
 *           триггеры покупки), стратегия рынка и глобальная торговля.
 *
 * Аудитория — русскоязычные маркетологи, бренд-менеджеры, юристы
 * по защите прав потребителей, импортёры в Израиле. Лексика реальная,
 * та, что встречается в академических курсах по маркетингу
 * (Котлер / Келлер) и в израильском юридическом обиходе
 * (חוֹק הֲגַנַּת הַצַּרְכָן, תְּבִיעָה יִיצּוּגִית).
 *
 * Распределение редкостей: 13 EPIC + 12 LEGENDARY.
 *
 * SemanticGroups (5 × 5):
 *   shopping_brand_advanced — продвинутая бренд-стратегия:
 *     brand equity, архетип, share of voice, резонанс, halo effect
 *   shopping_consumer_law_he — потребительское право Израиля:
 *     закон о защите потребителя, disclaimer, законное право,
 *     отзыв партии, коллективный иск
 *   shopping_marketing_psych — поведенческая психология покупки:
 *     когнитивное искажение, принцип дефицита, social proof,
 *     reciprocity, choice paralysis
 *   shopping_strategy_advanced — продвинутая стратегия рынка:
 *     market positioning, blue ocean, вертикальная интеграция,
 *     дифференциация, динамическое ценообразование
 *   shopping_global_trade — международная торговля:
 *     таможенный тариф, импортный налог, HS-код,
 *     соглашение о свободной торговле, торговое эмбарго
 *
 * Word IDs: setId × 100 + position (179301..179325).
 *
 * Пересечения с другими наборами темы:
 *   - L1L2L3 (1730–1732) уже содержит мелкорозничный обиход (חֲנוּת,
 *     מְחִיר, הֲנָחָה), online-операции (מָנוּי, חִיּוּב חוֹזֵר,
 *     הִתְנַתְּקוּת), базовый маркетинг (מִיתוּג, יוּקְרָה, מָסָר שִׁוּוּקִי,
 *     אוֹמְנִיצַ'אנֶל, מַסַּע פִּרְסוּם). Здесь — академический и
 *     стратегический слой над ними.
 *   - L4 (1792, профессиональный) — параллельный сет, разный фокус.
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них
 * отключён, пока LLM-pipeline не пройдёт по набору и не проставит
 * fillInBlankExclusions.
 */
object WordDataHebrewShoppingL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1793, languagePair = "he-ru", orderIndex = 1793,
            name = "Шоппинг и покупки",
            description = "Уровень носителя: бренд-стратегия, потребительское право, маркетинг-психология",
            topic = "Шоппинг и покупки", level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1793 — Шоппинг и покупки: носитель языка (L5, EPIC+LEGENDARY)
        // 5 групп × 5 слов: brand_advanced, consumer_law_he,
        //                   marketing_psych, strategy_advanced, global_trade
        // ══════════════════════════════════════════════════════════════════════

        // ── shopping_brand_advanced (5) — продвинутая бренд-стратегия ──
        WordEntity(
            id = 179301, setId = 1793, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "shopping_brand_advanced", transliteration = "hon hamutág",
            original = "הוֹן הַמּוּתָג", translation = "капитал бренда",
            definition = "הָעֵרֶךְ הַכַּסְפִּי שֶׁלָּקוֹחוֹת מַעֲנִיקִים לְשֵׁם מֻכָּר מֵעַל הַמּוּצָר עַצְמוֹ.",
            definitionNative = "Денежная ценность, которую покупатели придают самому имени — сверх качеств товара.",
            example = "הוֹן הַמּוּתָג שֶׁל אַפְּל מַסְבִּיר אֶת הַפְּרִימְיוּם בַּמְּחִיר.",
            exampleNative = "הוֹן הַמּוּתָג Apple объясняет премию, которую платят за её товары.",
         fillInBlankExclusions = listOf(179302L, 179303L, 179304L, 179305L)),
        WordEntity(
            id = 179302, setId = 1793, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "shopping_brand_advanced", transliteration = "arkhetíp hamutág",
            original = "אַרְכֵיטִיפּ הַמּוּתָג", translation = "архетип бренда",
            definition = "דְּמוּת קְבוּעָה (גִּבּוֹר, חָכָם, מוֹרֵד) שֶׁמּוּתָג מְשַׂחֵק מוּל הַקְּהַל.",
            definitionNative = "Устойчивый образ — герой, мудрец, бунтарь — который компания играет перед публикой.",
            example = "אַרְכֵיטִיפּ הַמּוּתָג שֶׁל נַייקִי הוּא הַגִּבּוֹר הַמְּנַצֵּחַ.",
            exampleNative = "אַרְכֵיטִיפּ הַמּוּתָג Nike — это герой-победитель.",
         fillInBlankExclusions = listOf(179301L, 179303L, 179304L, 179305L)),
        WordEntity(
            id = 179303, setId = 1793, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "shopping_brand_advanced", transliteration = "nétakh kolót",
            original = "נֶתַח קוֹלוֹת", translation = "доля голоса",
            definition = "אֲחוּז הַזְּמַן וְהַשֶּׁטַח שֶׁמּוּתָג תּוֹפֵס בִּתְקְשׁוֹרֶת בְּהַשְׁוָאָה לַמִּתְחָרִים.",
            definitionNative = "Какую часть рекламного эфира и площадей компания занимает на фоне конкурентов.",
            example = "מָדַדְנוּ נֶתַח קוֹלוֹת שֶׁל שְׁלֹשִׁים אֲחוּז בְּקַטֵגוֹרְיָה.",
            exampleNative = "Мы намеряли נֶתַח קוֹלוֹת в тридцать процентов в нашей категории.",
         fillInBlankExclusions = listOf(179301L, 179302L, 179304L, 179305L)),
        WordEntity(
            id = 179304, setId = 1793, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "shopping_brand_advanced", transliteration = "hed hamutág",
            original = "הֵד הַמּוּתָג", translation = "резонанс бренда",
            definition = "הַשָּׁלָב שֶׁבּוֹ הַלָּקוֹחַ מַרְגִּישׁ קֶשֶׁר אֲמִתִּי וּמַחֲזִיר רֶגֶשׁ לְחֶבְרָה.",
            definitionNative = "Стадия, когда покупатель чувствует настоящую связь с компанией и отвечает ей теплом.",
            example = "סְטָארְבַּקְס יוֹצֵר הֵד הַמּוּתָג דֶּרֶךְ פִּסְגַּת הַחֲוָיָה בְּחֲנוּת.",
            exampleNative = "Starbucks создаёт הֵד הַמּוּתָג через атмосферу в самом кафе.",
         fillInBlankExclusions = listOf(179301L, 179302L, 179303L, 179305L)),
        WordEntity(
            id = 179305, setId = 1793, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "shopping_brand_advanced", transliteration = "éfekt hahilá",
            original = "אֶפֶקְט הַהִילָה", translation = "эффект ореола",
            definition = "כְּשֶׁרֹשֶׁם חִיּוּבִי בְּתָחוּם אֶחָד מַטֶּה אֶת הַשִּׁפּוּט בִּשְׁאָר הַתְּחוּמִים.",
            definitionNative = "Когда хорошее впечатление в одной мелочи окрашивает оценку всего остального.",
            example = "אֶפֶקְט הַהִילָה גוֹרֵם לְלָקוֹחוֹת לְהַעֲרִיךְ אֲרִיזָה יָפָה כְּטִיב גָּבוֹהַּ.",
            exampleNative = "אֶפֶקְט הַהִילָה заставляет покупателя считать красивую упаковку признаком качества.",
         fillInBlankExclusions = listOf(179301L, 179302L, 179303L, 179304L)),

        // ── shopping_consumer_law_he (5) — потребительское право Израиля ──
        WordEntity(
            id = 179306, setId = 1793, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "shopping_consumer_law_he", transliteration = "khok haganát hatsarkhán",
            original = "חֹק הֲגַנַּת הַצַּרְכָן", translation = "закон о защите прав потребителей",
            definition = "חֲקִיקָה יִשְׂרְאֵלִית הַמְּגִנָּה עַל קוֹנִים מִפְּנֵי הַטְעָיָה וְתְנָאִים מַקְפְּחִים.",
            definitionNative = "Израильский закон, защищающий покупателей от обмана и кабальных условий продавца.",
            example = "חֹק הֲגַנַּת הַצַּרְכָן מַחְיֵיב גִּלּוּי מָלֵא שֶׁל הַתְּנָאִים בַּחוֹזֶה.",
            exampleNative = "חֹק הֲגַנַּת הַצַּרְכָן требует полного раскрытия условий в договоре.",
         fillInBlankExclusions = listOf(179307L, 179308L, 179309L, 179310L)),
        WordEntity(
            id = 179307, setId = 1793, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "shopping_consumer_law_he", transliteration = "ktav mastir",
            original = "כְּתָב מַסְתִּיר", translation = "отказ от гарантии",
            definition = "טֶקְסְט קָטָן שֶׁבּוֹ הַמּוֹכֵר מְבַטֵּל אַחֲרָיוּת עַל פְּגָמִים נִסְתָּרִים.",
            definitionNative = "Мелкий текст, которым продавец снимает с себя ответственность за скрытые недостатки.",
            example = "הוּא לֹא קָרָא אֶת כְּתָב מַסְתִּיר וְלָכֵן הִפְסִיד בְּבֵית מִשְׁפָּט.",
            exampleNative = "Он не прочитал כְּתָב מַסְתִּיר и поэтому проиграл в суде.",
         fillInBlankExclusions = listOf(179306L, 179308L, 179309L, 179310L)),
        WordEntity(
            id = 179308, setId = 1793, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "shopping_consumer_law_he", transliteration = "zkhút khukít",
            original = "זְכוּת חֻקִּית", translation = "право по закону",
            definition = "אֶפְשָׁרוּת שֶׁמְּדִינָה מַעֲנִיקָה לְקוֹנֶה וְאִי-אֶפְשָׁר לְוַתֵּר עָלֶיהָ בְּחוֹזֶה.",
            definitionNative = "Возможность, которую государство даёт покупателю и от которой нельзя отказаться договором.",
            example = "יֵשׁ לְךָ זְכוּת חֻקִּית לְבַטֵּל עִסְקָה תּוֹךְ אַרְבָּעָה עָשָׂר יוֹם.",
            exampleNative = "У тебя есть זְכוּת חֻקִּית отменить сделку в течение четырнадцати дней.",
         fillInBlankExclusions = listOf(179306L, 179307L, 179309L, 179310L)),
        WordEntity(
            id = 179309, setId = 1793, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "shopping_consumer_law_he", transliteration = "hashavát mutsár",
            original = "הֲשָׁבַת מוּצָר", translation = "отзыв партии товара",
            definition = "כְּשֶׁיַּצְרָן דּוֹרֵשׁ מִקּוֹנִים לְהַחְזִיר פְּרִיט בִּגְלַל סַכָּנָה אוֹ פְּגָם רָצִינִי.",
            definitionNative = "Когда производитель просит покупателей вернуть товар из-за опасности или серьёзного дефекта.",
            example = "טוֹיוֹטָה הוֹדִיעָה עַל הֲשָׁבַת מוּצָר עֲבוּר חֲצִי מִילְיוֹן רֶכֶב.",
            exampleNative = "Toyota объявила הֲשָׁבַת מוּצָר для полумиллиона машин.",
         fillInBlankExclusions = listOf(179306L, 179307L, 179308L, 179310L)),
        WordEntity(
            id = 179310, setId = 1793, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "shopping_consumer_law_he", transliteration = "tviá yitsugít",
            original = "תְּבִיעָה יִיצּוּגִית", translation = "коллективный иск",
            definition = "הַלִּיךְ מִשְׁפָּטִי שֶׁבּוֹ אִישׁ אֶחָד תּוֹבֵעַ בִּשְׁבִיל קְבוּצָה גְּדוֹלָה שֶׁל נִפְגָּעִים.",
            definitionNative = "Судебный процесс, где один истец действует от имени большой группы пострадавших.",
            example = "מֵאוֹת לָקוֹחוֹת הִצְטָרְפוּ לִתְבִיעָה יִיצּוּגִית נֶגֶד הַסֶּלוֹלָר.",
            exampleNative = "Сотни клиентов присоединились к תְּבִיעָה יִיצּוּגִית против сотового оператора.",
            isFillInBlankSafe = false,
        ),

        // ── shopping_marketing_psych (5) — поведенческая психология покупки ──
        WordEntity(
            id = 179311, setId = 1793, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "shopping_marketing_psych", transliteration = "hatayá kognitívit",
            original = "הִטָּיָה קוֹגְנִיטִיבִית", translation = "когнитивное искажение",
            definition = "סְטִיָּה שִׁיטָתִית שֶׁל הַמַּחֲשָׁבָה מֵהֲגָיוֹן יָבֵשׁ בִּגְלַל קִצּוּרֵי דֶרֶךְ נַפְשִׁיִּים.",
            definitionNative = "Систематический сдвиг мышления от чистой логики из-за умственных коротких путей.",
            example = "הִטָּיָה קוֹגְנִיטִיבִית גוֹרֶמֶת לָנוּ לְהַעֲדִיף הַפְסֵד מֵהֲרָוָחָה.",
            exampleNative = "הִטָּיָה קוֹגְנִיטִיבִית заставляет нас сильнее бояться потери, чем радоваться выгоде.",
         fillInBlankExclusions = listOf(179312L, 179313L, 179314L, 179315L)),
        WordEntity(
            id = 179312, setId = 1793, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "shopping_marketing_psych", transliteration = "ikarón hamakhsór",
            original = "עִקָּרוֹן הַמַּחְסוֹר", translation = "принцип дефицита",
            definition = "כְּלָל פְּסִיכוֹלוֹגִי: כְּשֶׁמַּשֶּׁהוּ נִדְמֶה נָדִיר, הָרָצוֹן לִקְנוֹתוֹ גָּדֵל.",
            definitionNative = "Психологическое правило: чем что-то кажется реже, тем сильнее тянет это купить.",
            example = "פְּרְסוּמוֹת \"רַק חָמֵשׁ נוֹתְרוּ בַּמְּלַאי\" עוֹבְדוֹת עַל עִקָּרוֹן הַמַּחְסוֹר.",
            exampleNative = "Реклама «осталось пять штук» работает через עִקָּרוֹן הַמַּחְסוֹר.",
         fillInBlankExclusions = listOf(179311L, 179313L, 179314L, 179315L)),
        WordEntity(
            id = 179313, setId = 1793, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "shopping_marketing_psych", transliteration = "hokhakhá khevratít",
            original = "הוֹכָחָה חֶבְרָתִית", translation = "социальное доказательство",
            definition = "כְּשֶׁאֲנָשִׁים מַחְלִיטִים מַה לִּקְנוֹת לְפִי מַה שֶּׁאֲחֵרִים כְּבָר עָשׂוּ.",
            definitionNative = "Когда человек решает, что купить, ориентируясь на действия других людей.",
            example = "חַוּוֹת דַּעַת חִיּוּבִיּוֹת בְּאַמָּזוֹן הֵן הוֹכָחָה חֶבְרָתִית חֲזָקָה.",
            exampleNative = "Положительные отзывы на Amazon — это сильная הוֹכָחָה חֶבְרָתִית.",
         fillInBlankExclusions = listOf(179311L, 179312L, 179314L, 179315L)),
        WordEntity(
            id = 179314, setId = 1793, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "shopping_marketing_psych", transliteration = "khok hahadadiyút",
            original = "חֹק הַהֲדָדִיּוּת", translation = "правило взаимности",
            definition = "נְטִיָּה לְהַחְזִיר טוֹבָה כַּאֲשֶׁר מְקַבְּלִים מַתָּנָה אוֹ דְּגִימָה חִנָּם.",
            definitionNative = "Желание ответить добром, когда тебе подарили что-то или дали бесплатный образец.",
            example = "דְּגִימָה חִנָּם בְּסוּפֶּרְמַרְקֶט מַפְעִילָה אֶת חֹק הַהֲדָדִיּוּת.",
            exampleNative = "Бесплатный образец в супермаркете запускает חֹק הַהֲדָדִיּוּת.",
         fillInBlankExclusions = listOf(179311L, 179312L, 179313L, 179315L)),
        WordEntity(
            id = 179315, setId = 1793, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "shopping_marketing_psych", transliteration = "shituk habkhirá",
            original = "שִׁתּוּק הַבְּחִירָה", translation = "паралич выбора",
            definition = "כְּשֶׁיֵּשׁ יוֹתֵר מִדַּי אֶפְשָׁרוּיוֹת וְהַקּוֹנֶה לֹא מַחְלִיט כְּלוּם.",
            definitionNative = "Когда вариантов слишком много и покупатель в итоге не выбирает ничего.",
            example = "שִׁתּוּק הַבְּחִירָה גָּרַם לוֹ לָצֵאת מֵהַחֲנוּת בְּלִי כְּלוּם.",
            exampleNative = "שִׁתּוּק הַבְּחִירָה заставил его выйти из магазина с пустыми руками.",
         fillInBlankExclusions = listOf(179311L, 179312L, 179313L, 179314L)),

        // ── shopping_strategy_advanced (5) — продвинутая стратегия рынка ──
        WordEntity(
            id = 179316, setId = 1793, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "shopping_strategy_advanced", transliteration = "mikúm bashúk",
            original = "מִקּוּם בַּשּׁוּק", translation = "позиционирование на рынке",
            definition = "הַמָּקוֹם הָרְצוּי שֶׁמּוּתָג רוֹצֶה לִתְפֹּס בַּמַּחֲשָׁבָה שֶׁל הַקּוֹנֶה.",
            definitionNative = "Желаемое место, которое марка хочет занять в голове у покупателя.",
            example = "מִקּוּם בַּשּׁוּק שֶׁל וֹלְוֹו מְבֻסָּס עַל בְּטִיחוּת מֵעַל הַכֹּל.",
            exampleNative = "מִקּוּם בַּשּׁוּק Volvo строится на безопасности превыше всего.",
         fillInBlankExclusions = listOf(179317L, 179318L, 179319L, 179320L)),
        WordEntity(
            id = 179317, setId = 1793, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "shopping_strategy_advanced", transliteration = "istrategiyát okiyanós kakhól",
            original = "אִסְטְרָטֶגְיַת אוֹקְיָנוֹס כָּחֹל", translation = "стратегия голубого океана",
            definition = "גִּישָׁה שֶׁבָּהּ חֶבְרָה יוֹצֶרֶת שׁוּק חָדָשׁ לְגַמְרֵי בְּמָקוֹם לְהִתְחָרוֹת בַּקַּיָּם.",
            definitionNative = "Подход, при котором фирма создаёт совсем новый рынок вместо борьбы в старом.",
            example = "סִירְקְ דּוּ סוֹלֵיי הִשְׁתַּמֵּשׁ בְּאִסְטְרָטֶגְיַת אוֹקְיָנוֹס כָּחֹל לְהָקִים קִרְקָס חָדָשׁ.",
            exampleNative = "Cirque du Soleil использовал אִסְטְרָטֶגְיַת אוֹקְיָנוֹס כָּחֹל, чтобы создать новый цирк.",
         fillInBlankExclusions = listOf(179316L, 179318L, 179319L, 179320L)),
        WordEntity(
            id = 179318, setId = 1793, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "shopping_strategy_advanced", transliteration = "integratsyá anakhít",
            original = "אִינְטֶגְרַצְיָה אֲנָכִית", translation = "вертикальная интеграция",
            definition = "כְּשֶׁחֶבְרָה רוֹכֶשֶׁת אֶת הַסַּפָּקִים שֶׁלָּהּ אוֹ אֶת רֶשֶׁת הַהֲפָצָה שֶׁלָּהּ.",
            definitionNative = "Когда компания скупает своих поставщиков или сеть распространения товара.",
            example = "טֶסְלָה בָּחֲרָה בְּאִינְטֶגְרַצְיָה אֲנָכִית וּבָנְתָה מִפְעַל סוֹלְלוֹת מְשֻׁלָּב.",
            exampleNative = "Tesla выбрала אִינְטֶגְרַצְיָה אֲנָכִית и построила свой батарейный завод.",
         fillInBlankExclusions = listOf(179316L, 179317L, 179319L, 179320L)),
        WordEntity(
            id = 179319, setId = 1793, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "shopping_strategy_advanced", transliteration = "diferentsyatsyá",
            original = "דִּיפֶרֶנְצְיַאצְיָה", translation = "дифференциация продукта",
            definition = "כְּשֶׁחֶבְרָה מַבְלִיטָה תְּכוּנָה יִחוּדִית כְּדֵי לְהֵרָאוֹת שׁוֹנָה מֵהַמִּתְחָרִים.",
            definitionNative = "Когда фирма выпячивает уникальную черту, чтобы выглядеть иначе на фоне конкурентов.",
            example = "דִּיפֶרֶנְצְיַאצְיָה עַל יְדֵי עִצּוּב מַעֲנִיקָה לְדַייסוֹן יִתְרוֹן.",
            exampleNative = "דִּיפֶרֶנְצְיַאצְיָה через дизайн даёт Dyson преимущество над всеми.",
         fillInBlankExclusions = listOf(179316L, 179317L, 179318L, 179320L)),
        WordEntity(
            id = 179320, setId = 1793, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "shopping_strategy_advanced", transliteration = "tamkhúr dinámi",
            original = "תַּמְחוּר דִּינָמִי", translation = "динамическое ценообразование",
            definition = "שִׁיטָה שֶׁבָּהּ הַמְּחִיר מִשְׁתַּנֶּה בִּזְמַן אֲמִתִּי לְפִי בִּיקּוּשׁ וּזְמַן יוֹם.",
            definitionNative = "Подход, при котором цена меняется в реальном времени по спросу и часу суток.",
            example = "אוּבֶּר מִשְׁתַּמֶּשֶׁת בְּתַמְחוּר דִּינָמִי בְּשָׁעוֹת עֲמוּסוֹת.",
            exampleNative = "Uber применяет תַּמְחוּר דִּינָמִי в часы пик.",
            isFillInBlankSafe = false,
        ),

        // ── shopping_global_trade (5) — международная торговля ──
        WordEntity(
            id = 179321, setId = 1793, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "shopping_global_trade", transliteration = "ta'aríf mékhes",
            original = "תַּעֲרִיף מֶכֶס", translation = "таможенный тариф",
            definition = "טַבְלָה רִשְׁמִית שֶׁל אֲחוּזֵי הַתַּשְׁלוּם עַל סְחוֹרוֹת בִּכְנִיסָה לַמְּדִינָה.",
            definitionNative = "Официальная таблица процентов, которые берут с товара при ввозе в страну.",
            example = "תַּעֲרִיף מֶכֶס עַל יַיִן מְיֻבָּא עוֹמֵד עַל שִׁשִּׁים אֲחוּז.",
            exampleNative = "תַּעֲרִיף מֶכֶס на ввозное вино составляет шестьдесят процентов.",
         fillInBlankExclusions = listOf(179322L, 179323L, 179324L, 179325L)),
        WordEntity(
            id = 179322, setId = 1793, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "shopping_global_trade", transliteration = "mas yevú",
            original = "מַס יְבוּא", translation = "импортный налог",
            definition = "תַּשְׁלוּם שֶׁמֵּטִיל הָאוֹצָר עַל מוּצָר שֶׁמַּגִּיעַ מֵחוּץ לָאָרֶץ.",
            definitionNative = "Сбор, который казна берёт с товара, прибывшего из-за границы.",
            example = "אַחֲרֵי מַס יְבוּא הַטֶּלֶפוֹן הִתְיַקֵּר בְּמֵאתַיִם שֶׁקֶל.",
            exampleNative = "После מַס יְבוּא телефон подорожал на двести шекелей.",
         fillInBlankExclusions = listOf(179321L, 179323L, 179324L, 179325L)),
        WordEntity(
            id = 179323, setId = 1793, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "shopping_global_trade", transliteration = "kod harmonizatsyá",
            original = "קוֹד הַרְמוֹנִיזַצְיָה", translation = "гармонизированный код",
            definition = "מִסְפָּר בֵּינְלְאֻמִּי שֶׁמְּזַהֶה כָּל מוּצָר בְּטָפְסֵי מֶכֶס בְּכָל הָעוֹלָם.",
            definitionNative = "Международный номер, по которому таможни всех стран узнают любой товар в декларации.",
            example = "סוֹכֵן הַשִּׁילּוּחַ הִכְנִיס קוֹד הַרְמוֹנִיזַצְיָה לֹא נָכוֹן בַּמִּשְׁלוֹחַ.",
            exampleNative = "Логист вписал в накладную неверный קוֹד הַרְמוֹנִיזַצְיָה.",
         fillInBlankExclusions = listOf(179321L, 179322L, 179324L, 179325L)),
        WordEntity(
            id = 179324, setId = 1793, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "shopping_global_trade", transliteration = "heském sákhar khofshí",
            original = "הֶסְכֵּם סַחַר חוֹפְשִׁי", translation = "соглашение о свободной торговле",
            definition = "חוֹזֶה בֵּין מְדִינוֹת שֶׁמְּבַטֵּל אוֹ מַפְחִית אֶת הָמֶכֶס בֵּינֵיהֶן.",
            definitionNative = "Договор между странами, который убирает или снижает пошлины между ними.",
            example = "יִשְׂרָאֵל חָתְמָה הֶסְכֵּם סַחַר חוֹפְשִׁי עִם דְּרוֹם קוֹרֵיאָה.",
            exampleNative = "Израиль подписал הֶסְכֵּם סַחַר חוֹפְשִׁי с Южной Кореей.",
         fillInBlankExclusions = listOf(179321L, 179322L, 179323L, 179325L)),
        WordEntity(
            id = 179325, setId = 1793, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "shopping_global_trade", transliteration = "khérem sákhar",
            original = "חֵרֶם סַחַר", translation = "торговое эмбарго",
            definition = "אִסּוּר רִשְׁמִי שֶׁמְּדִינָה מַטִּילָה עַל קֶנֶה אוֹ מְכִירָה מוּל מְדִינָה אַחֶרֶת.",
            definitionNative = "Официальный запрет, который страна вводит на покупку или продажу с другим государством.",
            example = "חֵרֶם סַחַר עַל אִירָאן מַחְרִיף אֶת הַמַּשְׁבֵּר הַכַּלְכָּלִי.",
            exampleNative = "חֵרֶם סַחַר против Ирана углубляет экономический кризис.",
         fillInBlankExclusions = listOf(179321L, 179322L, 179323L, 179324L)),
    )
}
