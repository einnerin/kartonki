package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — Шоппинг и покупки, level 4 (1 set, 25 words).
 * Профессиональная лексика e-commerce, цепочек поставок, ритейл-аналитики,
 * поведенческой экономики покупок и премиум-сегмента.
 *
 * Set 1792 (level 4, EPIC + LEGENDARY) — 13 EPIC + 12 LEGENDARY.
 *
 * Не пересекается с уже существующими сетами темы «Шоппинг и покупки»
 * (1730, 1731, 1732 — базовая, продвинутая, углублённая лексика).
 * Все 25 слов и их шорешим проверены против L1–L3.
 *
 * SemanticGroups (5 × 5):
 *   shopping_ecommerce  — воронка оформления, брошенная корзина,
 *                         completion-метрика, центр шинуа, drop-shipping
 *   shopping_supply     — оптовик, дистрибьютор, оборачиваемость,
 *                         непрерывная поставка, обратная логистика
 *   shopping_analytics  — веб-аналитика, LTV, поток посетителей,
 *                         планограмма, dwell time
 *   shopping_behavior   — импульсная покупка, эмоциональная привязка,
 *                         информационная асимметрия, ценовой якорь, decoy
 *   shopping_premium    — товар класса люкс, дизайнерский лейбл,
 *                         лимитированный выпуск, индивидуальный пошив,
 *                         персональный консьерж
 *
 * Word IDs: setId * 100 + position (179201..179225).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewShoppingL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1792, languagePair = "he-ru", orderIndex = 1792,
            name = "Шоппинг и покупки",
            description = "Углублённый: e-commerce, цепочки поставок, ритейл-аналитика, потребительское поведение",
            topic = "Шоппинг и покупки", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1792 — Шоппинг: профессиональный (EPIC + LEGENDARY, C1–C2)
        // 5 групп × 5 слов: ecommerce, supply, analytics, behavior, premium
        // 13 EPIC + 12 LEGENDARY
        // ══════════════════════════════════════════════════════════════════════

        // ── shopping_ecommerce (5) — все EPIC ─────────────────────────────────
        WordEntity(
            id = 179201, setId = 1792, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "shopping_ecommerce", transliteration = "машпех сгира",
            original = "מַשְׁפֵּךְ סְגִירָה", translation = "воронка оформления заказа",
            definition = "סִדְרַת שְׁלַבִּים שֶׁעוֹבֵר הַגּוֹלֵשׁ מֵהַדַּף הָרִאשׁוֹן עַד תַּשְׁלוּם.",
            definitionNative = "Цепочка шагов от первой страницы до момента оплаты на сайте.",
            example = "מַשְׁפֵּךְ סְגִירָה אָרֹךְ מִדַּי מַבְרִיחַ קוֹנִים בְּאֶמְצַע הַתַּהֲלִיךְ.",
            exampleNative = "Слишком длинная מַשְׁפֵּךְ סְגִירָה отпугивает покупателей по пути.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179202, setId = 1792, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "shopping_ecommerce", transliteration = "саль натуш",
            original = "סַל נָטוּשׁ", translation = "брошенная корзина",
            definition = "מַצָּב שֶׁבּוֹ הַגּוֹלֵשׁ הוֹסִיף מוּצָרִים אַךְ עָזַב לִפְנֵי הַתַּשְׁלוּם.",
            definitionNative = "Состояние, когда товары добавлены, но оплата так и не прошла.",
            example = "כָּל סַל נָטוּשׁ מַפְעִיל אִי-מֶיְל אוֹטוֹמָטִי לְהַחְזָרַת הַגּוֹלֵשׁ.",
            exampleNative = "Каждый סַל נָטוּשׁ запускает автописьмо для возврата покупателя.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179203, setId = 1792, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "shopping_ecommerce", transliteration = "яхас хашлама",
            original = "יַחַס הַשְׁלָמָה", translation = "коэффициент завершения",
            definition = "אָחוּז הַגּוֹלְשִׁים שֶׁמְּסַיְּמִים אֶת הַתַּהֲלִיךְ עַד הַסּוֹף בְּלִי לִנְטֹשׁ.",
            definitionNative = "Доля посетителей, доводящих процесс до конца без выхода.",
            example = "יַחַס הַשְׁלָמָה עָלָה אַחֲרֵי שֶׁפִּשְׁטָנוּ אֶת טֹפֶס הַתַּשְׁלוּם.",
            exampleNative = "יַחַס הַשְׁלָמָה вырос после упрощения формы оплаты.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179204, setId = 1792, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "shopping_ecommerce", transliteration = "мерказ шинуа",
            original = "מֶרְכַּז שִׁנּוּעַ", translation = "центр выполнения заказов",
            definition = "מִתְקָן גָּדוֹל שֶׁבּוֹ אוֹסְפִים, אוֹרְזִים וּמְפַזְּרִים חֲבִילוֹת לְכָל קָצֶה.",
            definitionNative = "Большой комплекс, где собирают, упаковывают и развозят посылки.",
            example = "הַחֶבְרָה פָּתְחָה מֶרְכַּז שִׁנּוּעַ נוֹסָף בִּדְרוֹם הָאָרֶץ.",
            exampleNative = "Фирма открыла ещё один מֶרְכַּז שִׁנּוּעַ на юге страны.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179205, setId = 1792, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "shopping_ecommerce", transliteration = "дропшипинг",
            original = "דְּרוֹפְּשִׁיפִּינְג", translation = "дроп-шиппинг",
            definition = "מוֹדֶל שֶׁבּוֹ הַחֲנוּת הַוִּירְטוּאָלִית מוֹכֶרֶת בְּלִי לְהַחֲזִיק מְלַאי בְּעַצְמָהּ.",
            definitionNative = "Модель, в которой онлайн-точка продаёт без собственных запасов.",
            example = "סְטוּדֶנְט הִקִּים עֵסֶק שֶׁל דְּרוֹפְּשִׁיפִּינְג מִדִּירָה שְׂכוּרָה.",
            exampleNative = "Студент построил бизнес на דְּרוֹפְּשִׁיפִּינְג прямо из съёмной квартиры.",
            isFillInBlankSafe = false,
        ),

        // ── shopping_supply (5) — все EPIC ────────────────────────────────────
        WordEntity(
            id = 179206, setId = 1792, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "shopping_supply", transliteration = "хеврат халука",
            original = "חֶבְרַת חֲלוּקָה", translation = "оптовая компания",
            definition = "תַּאֲגִיד הַמּוֹכֵר כַּמֻּיּוֹת גְּדוֹלוֹת לַחֲנוּיוֹת קְטַנּוֹת בְּמוֹדֶל B2B.",
            definitionNative = "Корпорация, продающая большие партии магазинам по модели B2B.",
            example = "חֶבְרַת חֲלוּקָה קִבְּלָה זִכָּיוֹן בִּלְעָדִי לִיבּוּא הַמּוּצָר.",
            exampleNative = "חֶבְרַת חֲלוּקָה получила эксклюзивные права на ввоз товара.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179207, setId = 1792, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "shopping_supply", transliteration = "мафиц",
            original = "מָפִיץ", translation = "дистрибьютор",
            definition = "גּוֹרֵם רִשְׁמִי שֶׁמַּעֲבִיר אֶת מוּצְרֵי הַיַּצְרָן לַחֲנוּיוֹת בְּאֵזוֹר מֻגְדָּר.",
            definitionNative = "Официальный посредник, доносящий товары производителя до магазинов.",
            example = "הַיַּצְרָן הֶחְלִיף אֶת הַמָּפִיץ הַיִּשְׂרְאֵלִי אַחֲרֵי שָׁנִים שֶׁל שִׁתּוּף.",
            exampleNative = "Производитель сменил израильского מָפִיץ после долгих лет работы.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179208, setId = 1792, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "shopping_supply", transliteration = "ротацйат ихсун",
            original = "רוֹטַצְיַת אִחְסוּן", translation = "оборачиваемость склада",
            definition = "קֶצֶב הַחְלָפַת הַסְּחוֹרוֹת בַּמַּחְסָן בִּפְרָק זְמַן קָבוּעַ.",
            definitionNative = "Скорость, с которой запасы на складе сменяются за единицу времени.",
            example = "רוֹטַצְיַת אִחְסוּן מְהִירָה מוֹרִידָה אֶת עֲלוּת הַהַחְזָקָה.",
            exampleNative = "Быстрая רוֹטַצְיַת אִחְסוּן снижает издержки хранения.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179209, setId = 1792, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "shopping_supply", transliteration = "аспака рцуфа",
            original = "אַסְפָּקָה רְצוּפָה", translation = "поставка точно в срок",
            definition = "שִׁיטָה שֶׁבָּהּ הַסְּחוֹרָה מַגִּיעָה בְּדִיּוּק בָּרֶגַע שֶׁבּוֹ צְרִיכִים אוֹתָהּ.",
            definitionNative = "Метод, при котором товар приходит ровно тогда, когда требуется.",
            example = "אַסְפָּקָה רְצוּפָה חוֹסֶכֶת לַמִּפְעָל אֶת הַצֹּרֶךְ בְּמַחְסָן עָנָק.",
            exampleNative = "אַסְפָּקָה רְצוּפָה избавляет завод от нужды в огромном складе.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179210, setId = 1792, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "shopping_supply", transliteration = "maarekhet hakhzarot",
            original = "מַעֲרֶכֶת הַחְזָרוֹת", translation = "система возвратов товара",
            definition = "תַּהֲלִיךְ מְסֻדָּר שֶׁל קַבָּלָה, בְּדִיקָה וּמִיוּן שֶׁל סְחוֹרָה שֶׁלָּקוֹחוֹת מַחְזִירִים.",
            definitionNative = "Упорядоченный процесс приёма, проверки и сортировки товара, возвращённого клиентами.",
            example = "מַעֲרֶכֶת הַחְזָרוֹת חֲזָקָה הָפְכָה לִכְלִי מַרְכָּזִי שֶׁל מִסְחָר אִינְטֶרְנֶט.",
            exampleNative = "Сильная מַעֲרֶכֶת הַחְזָרוֹת стала ключевым инструментом интернет-торговли.",
            isFillInBlankSafe = false,
        ),

        // ── shopping_analytics (5) — 3 EPIC + 2 LEGENDARY ─────────────────────
        WordEntity(
            id = 179211, setId = 1792, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "shopping_analytics", transliteration = "аналитикат атар",
            original = "אֲנָלִיטִיקַת אֲתָר", translation = "веб-аналитика",
            definition = "אִסּוּף וּמְעַקָּב שֶׁל נְתוּנֵי הָאַתָר כְּדֵי לְהָבִין הִתְנַהֲגוּת גּוֹלְשִׁים.",
            definitionNative = "Сбор данных сайта для понимания того, как ведут себя посетители.",
            example = "אֲנָלִיטִיקַת אֲתָר חָשְׂפָה דַּף אֶחָד שֶׁמַּבְרִיחַ אֶת רֹב הַגּוֹלְשִׁים.",
            exampleNative = "אֲנָלִיטִיקַת אֲתָר показала страницу, отпугивающую большинство людей.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179212, setId = 1792, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "shopping_analytics", transliteration = "эрех лехоль хахаим",
            original = "עֵרֶךְ לְכֹל הַחַיִּים", translation = "пожизненная ценность клиента",
            definition = "סַךְ הָרֶוַח הַצָּפוּי מֵאָדָם אֶחָד לְאֹרֶךְ כָּל הַשָּׁנִים שֶׁהוּא קוֹנֶה.",
            definitionNative = "Ожидаемая прибыль от одного человека за все годы покупок.",
            example = "מִתְבַּסְּסִים עַל עֵרֶךְ לְכֹל הַחַיִּים כְּדֵי לִקְבֹּעַ תַּקְצִיב פִּרְסוּם.",
            exampleNative = "На עֵרֶךְ לְכֹל הַחַיִּים опираются, выставляя бюджет рекламы.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179213, setId = 1792, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "shopping_analytics", transliteration = "тнуат мевакрим",
            original = "תְּנוּעַת מְבַקְּרִים", translation = "поток посетителей",
            definition = "מִסְפַּר הָאֲנָשִׁים הָעוֹבְרִים אוֹ נִכְנָסִים לְמָקוֹם בְּמֶשֶׁךְ זְמַן מְסֻיָּם.",
            definitionNative = "Число людей, проходящих или входящих в место за единицу времени.",
            example = "תְּנוּעַת מְבַקְּרִים יוֹרֶדֶת בִּשְׁעוֹת אַחַר הַצָּהֳרַיִם בִּימֵי אֶמְצַע הַשָּׁבוּעַ.",
            exampleNative = "תְּנוּעַת מְבַקְּרִים падает после обеда в будние дни недели.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179214, setId = 1792, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "shopping_analytics", transliteration = "планограма",
            original = "פְּלָנוֹגְרָמָה", translation = "планограмма",
            definition = "תָּכְנִית גְּרָפִית הַמַּגְדִּירָה בִּמְדֻיָּק הֵיכָן יוּצַב כָּל מוּצָר עַל הַמַּדָּף.",
            definitionNative = "Графический план, точно указывающий место каждого товара на полке.",
            example = "פְּלָנוֹגְרָמָה חֲדָשָׁה מַגְדִּילָה בִּמְעַט יוֹתֵר אֶת הַסּוּג הָרָוֵוחִי.",
            exampleNative = "Новая פְּלָנוֹגְרָמָה чуть увеличивает выкладку прибыльной марки.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179215, setId = 1792, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "shopping_analytics", transliteration = "мешех шехут",
            original = "מֶשֶׁךְ שְׁהוּת", translation = "время задержки на странице",
            definition = "פֶּרֶק הַזְּמַן שֶׁבּוֹ הַגּוֹלֵשׁ נִשְׁאָר בְּדַף אֶחָד לִפְנֵי שֶׁהוּא עוֹבֵר הָלְאָה.",
            definitionNative = "Сколько посетитель остаётся на одной странице, прежде чем уйти.",
            example = "מֶשֶׁךְ שְׁהוּת אָרֹךְ מְעִיד עַל עִנְיָן בַּתֹּכֶן הַמֻּצָּג.",
            exampleNative = "Долгий מֶשֶׁךְ שְׁהוּת указывает на интерес к показанному содержимому.",
            isFillInBlankSafe = false,
        ),

        // ── shopping_behavior (5) — все LEGENDARY ─────────────────────────────
        WordEntity(
            id = 179216, setId = 1792, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "shopping_behavior", transliteration = "рхиша дахафит",
            original = "רְכִישָׁה דַּחֲפִית", translation = "импульсивная покупка",
            definition = "תַּגְמוּל מִיָּדִי שֶׁמַּשִּׂיגִים בִּלְקִיחָה לֹא מְתֻכְנֶנֶת שֶׁל פָּרִיט.",
            definitionNative = "Мгновенное удовольствие от незапланированного захвата вещи.",
            example = "רְכִישָׁה דַּחֲפִית שֶׁל סְפָרִים שֶׁאַף פַּעַם לֹא קָרָאתִי בָּהֶם.",
            exampleNative = "רְכִישָׁה דַּחֲפִית книжек, которые я так ни разу и не открыл.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179217, setId = 1792, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "shopping_behavior", transliteration = "иткашрут ригшит",
            original = "הִתְקַשְּׁרוּת רִגְשִׁית", translation = "лояльность бренду",
            definition = "קֶשֶׁר עָמֹק בֵּין הַצַּרְכָן לִשְׁמוֹ שֶׁל יַצְרָן מְסֻיָּם הַחוֹרֵג מֵרַצְיוֹנָל.",
            definitionNative = "Глубокая привязка покупателя к одному имени производителя сверх логики.",
            example = "הִתְקַשְּׁרוּת רִגְשִׁית מַסְבִּירָה לָמָה אֲנָשִׁים מְשַׁלְּמִים פִּי שְׁנַיִם.",
            exampleNative = "הִתְקַשְּׁרוּת רִגְשִׁית объясняет, почему люди платят вдвое дороже.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179218, setId = 1792, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "shopping_behavior", transliteration = "асиметрйат меда",
            original = "אֲסִימֶטְרִיַּת מֵידָע", translation = "информационная асимметрия",
            definition = "פַּעַר בֵּין הַיֶּדַע שֶׁיֵּשׁ לַמּוֹכֵר עַל הַסְּחוֹרָה לְזֶה שֶׁל הַקּוֹנֶה.",
            definitionNative = "Разрыв между знанием продавца о товаре и знанием покупателя о нём.",
            example = "אֲסִימֶטְרִיַּת מֵידָע מַגְדִּילָה אֶת כֹּחַ הַמּוֹכֵר בִּשְׁוָקִים מְקֻצָּעִים.",
            exampleNative = "אֲסִימֶטְרִיַּת מֵידָע усиливает продавца на узких профессиональных рынках.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179219, setId = 1792, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "shopping_behavior", transliteration = "оген хатхала",
            original = "עֹגֶן הַתְחָלָה", translation = "якорная цена",
            definition = "סְכוּם רִאשׁוֹן שֶׁמּוּצָג לַקּוֹנֶה וּמְעַצֵּב אֶת תְּחוּשַׁת הַשּׁוֹוִי שֶׁלּוֹ.",
            definitionNative = "Первая увиденная сумма, которая задаёт ощущение справедливой цены.",
            example = "עֹגֶן הַתְחָלָה גָּבוֹהַּ גּוֹרֵם לַסּוֹף לְהֵרָאוֹת זוֹל בְּהַרְבֵּה.",
            exampleNative = "Высокий עֹגֶן הַתְחָלָה делает итоговую сумму куда более привлекательной.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179220, setId = 1792, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "shopping_behavior", transliteration = "эфект питайон",
            original = "אֶפֶקְט פִּתָּיוֹן", translation = "эффект приманки",
            definition = "טַעֲנָה שִׁוּוּקִית שֶׁמּוֹסִיפָה אֶפְשָׁרוּת גְּרוּעָה כְּדֵי לְהַבְלִיט שְׁתַּיִם אֲחֵרוֹת.",
            definitionNative = "Маркетинговый ход: третий невыгодный вариант делает соседние ярче.",
            example = "אֶפֶקְט פִּתָּיוֹן הוּא הַסּוֹד שֶׁל הַמַּחֲירוֹן בְּחֶבְרוֹת מָנוּי.",
            exampleNative = "אֶפֶקְט פִּתָּיוֹן — секрет прайс-листа подписочных компаний.",
            isFillInBlankSafe = false,
        ),

        // ── shopping_premium (5) — все LEGENDARY ──────────────────────────────
        WordEntity(
            id = 179221, setId = 1792, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "shopping_premium", transliteration = "муцар илит",
            original = "מוּצָר עִלִּית", translation = "товар класса люкс",
            definition = "פָּרִיט יָקָר בְּמְיֻחָד שֶׁפּוֹנֶה לְשִׁכְבָה הַעַשִּׁירָה בְּיוֹתֵר שֶׁל הַשּׁוּק.",
            definitionNative = "Особенно дорогой предмет, нацеленный на самую состоятельную аудиторию.",
            example = "מוּצָר עִלִּית מִכַּמָּה גְרָמִים שֶׁל זָהָב טָהוֹר נָמְכַּר בְּתוֹר זָקוּף.",
            exampleNative = "מוּצָר עִלִּית из нескольких граммов чистого золота продают по записи.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179222, setId = 1792, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "shopping_premium", transliteration = "лейбель меацев",
            original = "לֵייבֶּל מְעַצֵּב", translation = "дизайнерская марка",
            definition = "סִימָן רִשְׁמִי שֶׁל יוֹצֵר אָפְנָה בּוֹדֵד הַחוֹרֵט אֶת שְׁמוֹ עַל כָּל פָּרִיט.",
            definitionNative = "Метка одиночного модельера, выгравированная на каждой его вещи.",
            example = "לֵייבֶּל מְעַצֵּב יְשַׂא תָּמִיד מִסְפָּר סִדּוּרִי וְחָתִימָה.",
            exampleNative = "לֵייבֶּל מְעַצֵּב всегда несёт серийный номер и подпись.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179223, setId = 1792, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "shopping_premium", transliteration = "махадура мугбелет",
            original = "מַהֲדוּרָה מֻגְבֶּלֶת", translation = "лимитированный выпуск",
            definition = "סִדְרַת יִחִידוֹת קְטַנָּה שֶׁל פָּרִיט אַחֲרֵי שֶׁמַּפְסִיקִים אֶת הַיִּצּוּר.",
            definitionNative = "Малая серия предмета, после которой производство останавливают.",
            example = "מַהֲדוּרָה מֻגְבֶּלֶת שֶׁל מָאתַיִם שְׁעוֹנִים נֶחֶטְפָה בְּתוֹךְ דַּקּוֹת.",
            exampleNative = "מַהֲדוּרָה מֻגְבֶּלֶת из двухсот часов разлетелась за минуты.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179224, setId = 1792, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "shopping_premium", transliteration = "тефер аль мида",
            original = "תֶּפֶר עַל מִדָּה", translation = "индивидуальный пошив",
            definition = "עֲבוֹדַת חֲיָּט שֶׁמַּתְאִימָה אֶת הַבֶּגֶד בְּדִיּוּק לְצוּרַת הַגּוּף.",
            definitionNative = "Работа портного с подгонкой одежды строго под фигуру заказчика.",
            example = "תֶּפֶר עַל מִדָּה דּוֹרֵשׁ לְפָחוֹת שָׁלוֹשׁ פְּגִישׁוֹת מְדִידָה.",
            exampleNative = "תֶּפֶר עַל מִדָּה требует не меньше трёх примерок у мастера.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179225, setId = 1792, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "shopping_premium", transliteration = "консьерж иши",
            original = "קוֹנְסְיֶרְז' אִישִׁי", translation = "консьерж-сервис",
            definition = "לִוּוּי בְּלָעֳדִי שֶׁל גּוֹרֵם פְּרָטִי הַמְּסַדֵּר כָּל בַּקָּשָׁה שֶׁל הַלָּקוֹחַ הַעַשִּׁיר.",
            definitionNative = "Эксклюзивный спутник, исполняющий любую просьбу богатого клиента.",
            example = "קוֹנְסְיֶרְז' אִישִׁי הִשִּׂיג כַּרְטִיסִים לְהַצָּגָה שֶׁכְּבָר נִמְכְּרָה.",
            exampleNative = "קוֹנְסְיֶרְז' אִישִׁי достал билеты на спектакль уже после распродажи.",
            isFillInBlankSafe = false,
        ),
    )
}
