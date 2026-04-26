package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Кофейня и работа баристой" (levels 1-3).
 *
 * Set 1739: «Кофейня и работа баристой» — основы (L1, COMMON+UNCOMMON):
 *           напитки, еда, обслуживание клиентов.
 * Set 1740: «Кофейня и работа баристой» — продвинутые (L2, UNCOMMON+RARE):
 *           оборудование, рецептура, латте-арт, рабочая смена.
 * Set 1741: «Кофейня и работа баристой» — углублённые (L3, RARE+EPIC):
 *           купажи, обжарка, экстракция, спешелти-кофе.
 *
 * Тема не пересекается с уже существующими сетами тем «Еда и кулинария»
 * (1006, 1084, 1239, 1240) и «Ресторан и работа официантом» (1369-1373):
 * там покрыта общая еда и зал ресторана, а здесь — узкая лексика бариста
 * и кофейного дела. Cross-topic совпадения с другими темами допустимы.
 *
 * Распределение редкостей:
 *   Set 1739: 16 COMMON + 9 UNCOMMON.
 *   Set 1740: 11 UNCOMMON + 14 RARE.
 *   Set 1741: 12 RARE + 13 EPIC.
 *
 * SemanticGroups (5 × 5 в каждом сете):
 *   Set 1739:
 *     barista_drinks_basic   — кофе, эспрессо, капучино, латте, американо
 *     barista_other_drinks   — чай, какао, шоколад, сок, лимонад
 *     barista_food           — круассан, торт, печенье, бутерброд, салат
 *     barista_extras         — сахар, молоко, сливки, мёд, корица
 *     barista_service        — заказ, столик, меню, цена, кассир
 *   Set 1740:
 *     barista_equipment      — кофемашина, портафильтр, гриндер, темпер, насадка-пар
 *     barista_recipe         — помол, дозировка, давление, температура, экстрактивная вода
 *     barista_milk_art       — пар, молочная пена, латте-арт, розетта, тюльпан
 *     barista_pos_screen     — доска меню, дисплей, чаевые, доставка, постоянный клиент
 *     barista_shift          — рабочая смена, открытие, закрытие, утренний пик, абонемент
 *   Set 1741:
 *     barista_specialty      — спешелти, арабика, робуста, сингл-ориджин, бленд
 *     barista_roast          — обжарка, светлая, средняя, тёмная, профиль обжарки
 *     barista_taste          — букет, кислотность, послевкусие, вкусовая палитра, нотки
 *     barista_extraction     — экстракция, под-экстракция, перe-экстракция, чанелинг, каппинг
 *     barista_industry       — каппинг, фермер, прямая торговля, fair-trade, сезонность
 *
 * Word IDs: setId × 100 + position (173901..173925, 174001..174025, 174101..174125).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewBaristaL1L2L3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1739, languagePair = "he-ru", orderIndex = 1739,
            name = "Кофейня и работа баристой",
            description = "Базовая лексика кофейни: напитки, еда, обслуживание клиентов",
            topic = "Кофейня и работа баристой", level = 1,
        ),
        WordSetEntity(
            id = 1740, languagePair = "he-ru", orderIndex = 1740,
            name = "Кофейня и работа баристой",
            description = "Продвинутая лексика баристы: оборудование, рецептура, латте-арт",
            topic = "Кофейня и работа баристой", level = 2,
        ),
        WordSetEntity(
            id = 1741, languagePair = "he-ru", orderIndex = 1741,
            name = "Кофейня и работа баристой",
            description = "Углублённая лексика кофейного дела: купажи, обжарка, экстракция, спешелти-кофе",
            topic = "Кофейня и работа баристой", level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1739 — Кофейня и работа баристой: основы (L1, COMMON+UNCOMMON, A1-A2)
        // 5 групп × 5 слов: drinks_basic, other_drinks, food, extras, service
        // ══════════════════════════════════════════════════════════════════════

        // ── barista_drinks_basic (5) — кофейные напитки ──
        WordEntity(
            id = 173901, setId = 1739, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "barista_drinks_basic", transliteration = "kafe",
            original = "קָפֶה", translation = "кофе",
            definition = "מַשְׁקֶה חַם וְכֵהֶה הַמּוּכָן מִגַּרְעִינִים קְלוּיִים בְּמַיִם.",
            definitionNative = "Горячий тёмный напиток из обжаренных зёрен на воде.",
            example = "אֲנִי שׁוֹתֶה כּוֹס בַּבֹּקֶר לִפְנֵי הָעֲבוֹדָה.",
            exampleNative = "Я выпиваю чашку קָפֶה утром перед работой.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 173902, setId = 1739, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "barista_drinks_basic", transliteration = "espreso",
            original = "אֶסְפְּרֶסוֹ", translation = "эспрессо",
            definition = "מָנָה קְטַנָּה וְחָזָקָה שֶׁל מַשְׁקֶה כֵּהֶה מִתַּחַת לְלַחַץ גָּבוֹהַּ.",
            definitionNative = "Маленькая крепкая порция тёмного напитка под высоким давлением.",
            example = "הוּא הִזְמִין כּוֹס קְטַנָּה אַחֲרֵי הָאֲרוּחָה.",
            exampleNative = "Он заказал маленькую чашку אֶסְפְּרֶסוֹ после еды.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 173903, setId = 1739, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "barista_drinks_basic", transliteration = "kapuchino",
            original = "קָפּוּצִ׳ינוֹ", translation = "капучино",
            definition = "מַשְׁקֶה חַם בְּחֵלֶק שָׁוֶה שֶׁל מַשְׁקֶה כֵּהֶה, חָלָב חַם וְקֶצֶף.",
            definitionNative = "Горячий напиток из равных частей кофе, молока и пены.",
            example = "הַזְמַנְתִּי קָפּוּצִ׳ינוֹ עִם קֶצֶף שָׁמֵן וְקִנָּמוֹן.",
            exampleNative = "Я заказал קָפּוּצִ׳ינוֹ с густой пеной и корицей.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 173904, setId = 1739, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "barista_drinks_basic", transliteration = "late",
            original = "לָאטֶה", translation = "латте",
            definition = "מַשְׁקֶה חַם רַךְ עִם הַרְבֵּה חָלָב וּמְעַט מַשְׁקֶה כֵּהֶה לְמַעְלָה.",
            definitionNative = "Мягкий горячий напиток с обилием молока и каплей крепкого сверху.",
            example = "אִשְׁתִּי בּוֹחֶרֶת לָאטֶה גָּדוֹל בְּלִי סֻכָּר.",
            exampleNative = "Жена выбирает большое לָאטֶה без сахара.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(173901L, 173902L, 173903L, 173905L)),
        WordEntity(
            id = 173905, setId = 1739, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "barista_drinks_basic", transliteration = "amerikano",
            original = "אָמֶרִיקָנוֹ", translation = "американо",
            definition = "מָנָה חֲזָקָה מְהוּלָּה בְּמַיִם חַמִּים לְמַשְׁקֶה אָרֹךְ וְקַל.",
            definitionNative = "Крепкая порция, разбавленная горячей водой до длинного и лёгкого напитка.",
            example = "אָמֶרִיקָנוֹ מַתְאִים לִי יוֹתֵר מִכָּל מַשְׁקֶה אַחֵר.",
            exampleNative = "אָמֶרִיקָנוֹ подходит мне больше любого другого напитка.",
            isFillInBlankSafe = false,
        ),

        // ── barista_other_drinks (5) — некофейные напитки ──
        WordEntity(
            id = 173906, setId = 1739, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "barista_other_drinks", transliteration = "te",
            original = "תֵּה", translation = "чай",
            definition = "מַשְׁקֶה חַם הַמּוּכָן מִשְּׁרִיַּת עָלִים יְבֵשִׁים בְּמַיִם רוֹתְחִים.",
            definitionNative = "Горячий напиток из настоя сухих листьев в кипятке.",
            example = "אִמָּא רוֹצָה תֵּה יָרֹק עִם נַעֲנָע.",
            exampleNative = "Мама хочет тёмный תֵּה с мятой.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(173907L, 173908L, 173909L, 173910L)),
        WordEntity(
            id = 173907, setId = 1739, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "barista_other_drinks", transliteration = "kakao",
            original = "קָקָאוֹ", translation = "какао",
            definition = "מַשְׁקֶה חַם וּמָתוֹק מֵאֲבַק פּוֹלֵי קָקָאוֹ עִם חָלָב.",
            definitionNative = "Сладкий горячий напиток из порошка плодов с молоком.",
            example = "הַיֶּלֶד אוֹהֵב קָקָאוֹ חַם בְּעֶרֶב חַרְפִּי.",
            exampleNative = "Ребёнок любит горячее קָקָאוֹ зимним вечером.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 173908, setId = 1739, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "barista_other_drinks", transliteration = "shokolad cham",
            original = "שׁוֹקוֹלָד חַם", translation = "горячий шоколад",
            definition = "מַשְׁקֶה סָמִיךְ וְחָגִיגִי מִשׁוֹקוֹלָד מַמָּשׁ הַמּוּמָס בְּחָלָב.",
            definitionNative = "Густой праздничный напиток из настоящего шоколада, растворённого в молоке.",
            example = "בַּחֲנֻכָּה הִכַנּוּ שׁוֹקוֹלָד חַם לְכָל הַמִּשְׁפָּחָה.",
            exampleNative = "В Хануку мы готовили שׁוֹקוֹלָד חַם всей семье.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(173906L, 173907L, 173909L, 173910L)),
        WordEntity(
            id = 173909, setId = 1739, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "barista_other_drinks", transliteration = "mits",
            original = "מִיץ", translation = "сок",
            definition = "נוֹזֵל מָתוֹק שֶׁמְּסַחֲטִים מִפֵּרוֹת אוֹ יְרָקוֹת טְרִיִּים.",
            definitionNative = "Сладкая жидкость, выжимаемая из свежих фруктов или овощей.",
            example = "סִחַטְנוּ מִיץ תַּפּוּזִים לְלַקּוֹחוֹת בַּבֹּקֶר.",
            exampleNative = "Мы выдавили апельсиновый מִיץ для гостей утром.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(173906L, 173907L, 173908L, 173910L)),
        WordEntity(
            id = 173910, setId = 1739, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "barista_other_drinks", transliteration = "limonada",
            original = "לִימוֹנָדָה", translation = "лимонад",
            definition = "מַשְׁקֶה קַר חָמוּץ-מָתוֹק שֶׁל לִימוֹן, סֻכָּר וּמַיִם קָרִים.",
            definitionNative = "Холодный кисло-сладкий напиток из лимона, сахара и студёной воды.",
            example = "בְּחֹם הַקַּיִץ אֲנִי מַזְמִין לִימוֹנָדָה כָּל יוֹם.",
            exampleNative = "В летнюю жару я заказываю לִימוֹנָדָה каждый день.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(173906L, 173907L, 173908L, 173909L)),

        // ── barista_food (5) — еда в кофейне ──
        WordEntity(
            id = 173911, setId = 1739, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "barista_food", transliteration = "kruason",
            original = "קְרוּאָסוֹן", translation = "круассан",
            definition = "מַאֲפֶה צָרְפָתִי בְּצוּרַת סַהַר מִבָּצֵק עָלִים שָׁמֵן וְרַךְ.",
            definitionNative = "Французская выпечка-полумесяц из жирного слоёного теста.",
            example = "הוּא טָבַל קְרוּאָסוֹן בְּכוֹס לִפְנֵי הָעֲבוֹדָה.",
            exampleNative = "Он окунул קְרוּאָסוֹן в чашку перед работой.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(173912L, 173913L, 173914L, 173915L)),
        WordEntity(
            id = 173912, setId = 1739, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "barista_food", transliteration = "uga",
            original = "עוּגָה", translation = "торт",
            definition = "מַאֲפֶה מָתוֹק וְשִׁכְבָתִי בְּצוּרָה עֲגֻלָּה לְאֵרוּעַ אוֹ קִנּוּחַ.",
            definitionNative = "Сладкое многослойное блюдо круглой формы для праздника или десерта.",
            example = "אֶצְלָנוּ הַיּוֹם עוּגָה עִם פֵּרוֹת וְקֶצֶף.",
            exampleNative = "У нас сегодня עוּגָה с фруктами и взбитыми сливками.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(173911L, 173913L, 173914L, 173915L)),
        WordEntity(
            id = 173913, setId = 1739, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "barista_food", transliteration = "ugiya",
            original = "עוּגִיָּה", translation = "печенье",
            definition = "מַאֲפֶה קָטָן וְיָבֵשׁ עִם שׁוֹקוֹלָד אוֹ אֱגוֹזִים בַּפְּנִים.",
            definitionNative = "Маленькое сухое лакомство с шоколадом или орехами внутри.",
            example = "הַלָּקוֹחַ קִבֵּל עוּגִיָּה חִנָּם עִם הַמַּשְׁקֶה.",
            exampleNative = "Клиент получил עוּגִיָּה бесплатно к напитку.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(173911L, 173912L, 173914L, 173915L)),
        WordEntity(
            id = 173914, setId = 1739, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "barista_food", transliteration = "karich",
            original = "כָּרִיךְ", translation = "бутерброд",
            definition = "מָנָה קַלָּה שֶׁל לֶחֶם פָּרוּס עִם גְּבִינָה אוֹ יָרָק בִּפְנִים.",
            definitionNative = "Лёгкая еда: ломоть хлеба с сыром или овощем внутри.",
            example = "לְקַחְתִּי כָּרִיךְ לַעֲבוֹדָה בִּגְלַל זְמַן קָצָר.",
            exampleNative = "Я взял כָּרִיךְ на работу из-за нехватки времени.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 173915, setId = 1739, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "barista_food", transliteration = "salat",
            original = "סָלָט", translation = "салат",
            definition = "מָנָה קְרִירָה שֶׁל יְרָקוֹת חֲתוּכִים עִם שֶׁמֶן זַיִת וּמֶלַח.",
            definitionNative = "Прохладная еда из нарезанных овощей с маслом и солью.",
            example = "סָלָט יְרַקְרַק מַתְאִים לִי לַאֲרוּחַת צָהֳרַיִם.",
            exampleNative = "Зелёный סָלָט подходит мне на обед.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(173911L, 173912L, 173913L, 173914L)),

        // ── barista_extras (5) — добавки ──
        WordEntity(
            id = 173916, setId = 1739, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "barista_extras", transliteration = "sukar",
            original = "סֻכָּר", translation = "сахар",
            definition = "אֲבַק לָבָן וּמָתוֹק שֶׁמּוֹסִיפִים לְמַשְׁקֶה אוֹ לְעוּגָה.",
            definitionNative = "Белый сладкий песок, что добавляют к напитку или десерту.",
            example = "הוּא בִּקֵּשׁ שְׁתֵּי כַּפּוֹת סֻכָּר חוּם בַּלָּאטֶה.",
            exampleNative = "Он попросил две ложки коричневого סֻכָּר в латте.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(173917L, 173918L, 173919L, 173920L)),
        WordEntity(
            id = 173917, setId = 1739, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "barista_extras", transliteration = "chalav",
            original = "חָלָב", translation = "молоко",
            definition = "נוֹזֵל לָבָן שֶׁל פָּרָה אוֹ צֶמַח לְהוֹסִיף לְמַשְׁקֶה חַם.",
            definitionNative = "Белая жидкость от коровы или растения для добавки в напиток.",
            example = "אֵין חָלָב טִבְעוֹנִי, רַק שֶׁל פָּרָה.",
            exampleNative = "Нет растительного חָלָב, только коровье.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(173916L, 173918L, 173919L, 173920L)),
        WordEntity(
            id = 173918, setId = 1739, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "barista_extras", transliteration = "shamenet",
            original = "שַׁמֶּנֶת", translation = "сливки",
            definition = "חֵלֶק שָׁמֵן וְעָבֶה שֶׁל הַחָלָב הַטּוֹב לְמַשְׁקֶה אוֹ לְקִנּוּחַ.",
            definitionNative = "Жирная густая часть, что годится в напиток или десерт.",
            example = "הִיא בִּקְשָׁה שַׁמֶּנֶת מוּקְצֶפֶת עַל הַשּׁוֹקוֹלָד הַחַם.",
            exampleNative = "Она попросила שַׁמֶּנֶת взбитые на горячий шоколад.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(173916L, 173917L, 173919L, 173920L)),
        WordEntity(
            id = 173919, setId = 1739, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "barista_extras", transliteration = "dvash",
            original = "דְּבַשׁ", translation = "мёд",
            definition = "נוֹזֵל זָהֹב וּמָתוֹק שֶׁל דְּבוֹרִים לְמַשְׁקֶה בִּמְקוֹם סֻכָּר.",
            definitionNative = "Золотистая сладкая жидкость пчёл вместо обычного песка.",
            example = "אֲנִי שָׂם דְּבַשׁ בַּתֵּה כָּל בֹּקֶר.",
            exampleNative = "Я кладу דְּבַשׁ в чай каждое утро.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 173920, setId = 1739, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "barista_extras", transliteration = "kinamon",
            original = "קִנָּמוֹן", translation = "корица",
            definition = "אֲבַק חוּם וְרֵיחָנִי שֶׁל קְלִפַּת עֵץ לְפִיזוּר עַל הַקֶּצֶף.",
            definitionNative = "Коричневый ароматный порошок коры дерева для посыпки на пенку.",
            example = "פִּיזַרְתִּי קִנָּמוֹן בְּעַד הַשַּׁבְלוֹנָה עַל הַלָּאטֶה.",
            exampleNative = "Я посыпал קִנָּמוֹן через трафарет на латте.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(173916L, 173917L, 173918L, 173919L)),

        // ── barista_service (5) — обслуживание клиентов ──
        WordEntity(
            id = 173921, setId = 1739, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "barista_service", transliteration = "hazmana",
            original = "הַזְמָנָה", translation = "заказ",
            definition = "בַּקָּשָׁה שֶׁל לָקוֹחַ לְמַה שֶּׁהוּא רוֹצֶה לֶאֱכֹל אוֹ לִשְׁתּוֹת.",
            definitionNative = "Просьба клиента о том, что он хочет съесть или выпить.",
            example = "הוֹסַפְתִּי קְרוּאָסוֹן לַהַזְמָנָה שֶׁל הַזּוּג.",
            exampleNative = "Я добавил круассан к הַזְמָנָה этой пары.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(173922L, 173923L, 173924L, 173925L)),
        WordEntity(
            id = 173922, setId = 1739, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "barista_service", transliteration = "shulkhan",
            original = "שֻׁלְחָן", translation = "столик",
            definition = "רָהִיט קָטָן עִם רַגְלַיִם שֶׁעָלָיו מַנִּיחִים אֶת הַמַּשְׁקֶה.",
            definitionNative = "Маленький предмет на ножках, куда ставят чашку и тарелку.",
            example = "הִיא יָשְׁבָה עַל שֻׁלְחָן לְיַד הַחַלּוֹן.",
            exampleNative = "Она села за שֻׁלְחָן у окна.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(173921L, 173923L, 173924L, 173925L)),
        WordEntity(
            id = 173923, setId = 1739, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "barista_service", transliteration = "tafrit",
            original = "תַּפְרִיט", translation = "меню",
            definition = "רְשִׁימַת הַמַּשְׁקָאוֹת וְהַמַּאֲכָלִים שֶׁבֵּית הַקָּפֶה מַצִּיעַ לַלָּקוֹחַ.",
            definitionNative = "Список напитков и еды, что предлагает кофейня клиенту.",
            example = "הַתַּפְרִיט הַחָדָשׁ כָּלַל מַשְׁקָאוֹת קַיִץ.",
            exampleNative = "Новое תַּפְרִיט включило летние напитки.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(173921L, 173922L, 173924L, 173925L)),
        WordEntity(
            id = 173924, setId = 1739, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "barista_service", transliteration = "mechir",
            original = "מְחִיר", translation = "цена",
            definition = "כַּמּוּת הַכֶּסֶף שֶׁהַלָּקוֹחַ מְשַׁלֵּם עַל מָנָה אוֹ עַל מַשְׁקֶה.",
            definitionNative = "Сумма, которую клиент платит за порцию или напиток.",
            example = "הַמְּחִיר עָלָה אַחֲרֵי הַקַּיִץ עַל כָּל הַמַּשְׁקָאוֹת.",
            exampleNative = "מְחִיר вырос после лета на все напитки.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 173925, setId = 1739, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "barista_service", transliteration = "kupai",
            original = "קֻפַּאי", translation = "кассир",
            definition = "עוֹבֵד שֶׁמְּקַבֵּל אֶת הַתַּשְׁלוּם וּמוֹסֵר קַבָּלָה לַלָּקוֹחַ.",
            definitionNative = "Сотрудник, что принимает оплату и выдаёт чек посетителю.",
            example = "הַקֻּפַּאי הֶחֱלִיף לִי שְׁטָר שֶׁל מֵאָה.",
            exampleNative = "קֻפַּאי разменял мне сторублёвку.",
            isFillInBlankSafe = false,
        ),

        // ══════════════════════════════════════════════════════════════════════
        // Set 1740 — Кофейня и работа баристой: продвинутые (L2, UNCOMMON+RARE, A2-B1)
        // 5 групп × 5 слов: equipment, recipe, milk_art, pos_screen, shift
        // ══════════════════════════════════════════════════════════════════════

        // ── barista_equipment (5) — оборудование ──
        WordEntity(
            id = 174001, setId = 1740, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "barista_equipment", transliteration = "barista",
            original = "בָּרִיסְטָה", translation = "бариста",
            definition = "אִישׁ הַמִּקְצוֹעַ שֶׁמַּכִין מַשְׁקָאוֹת חַמִּים מֵאֲחוֹרֵי הַדֶּלְפֵּק.",
            definitionNative = "Профессионал, что готовит горячие напитки за стойкой.",
            example = "בָּרִיסְטָה חָדָשׁ הִתְחִיל לַעֲבֹד אֶצְלֵנוּ הַשָּׁבוּעַ.",
            exampleNative = "Новый בָּרִיסְטָה начал работать у нас на этой неделе.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174003L, 174004L, 174005L)),
        WordEntity(
            id = 174002, setId = 1740, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "barista_equipment", transliteration = "mekhonat espreso",
            original = "מְכוֹנַת אֶסְפְּרֶסוֹ", translation = "кофемашина",
            definition = "מַכְשִׁיר מַתֶּכֶת גָּדוֹל שֶׁמּוֹצִיא מָנוֹת חֲזָקוֹת בְּלַחַץ גָּבוֹהַּ.",
            definitionNative = "Большой металлический агрегат, выдающий крепкие порции под напором.",
            example = "מְכוֹנַת אֶסְפְּרֶסוֹ חָדָשָׁה הִגִּיעָה אֶתְמוֹל מֵאִיטַלְיָה.",
            exampleNative = "Новая מְכוֹנַת אֶסְפְּרֶסוֹ приехала вчера из Италии.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174003, setId = 1740, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "barista_equipment", transliteration = "portafiltr",
            original = "פּוֹרְטָפִילְטֶר", translation = "портафильтр",
            definition = "יָדִית מַתֶּכֶת עִם סַל מְחוּרָר שֶׁבּוֹ מֻנָּחִים גַּרְעִינִים טְחוּנִים.",
            definitionNative = "Металлическая ручка с дырчатой корзиной под молотый продукт.",
            example = "הַפּוֹרְטָפִילְטֶר נִשְׁאַר תָּמִיד חַם בִּצְמוּד לַמְּכוֹנָה.",
            exampleNative = "פּוֹרְטָפִילְטֶר всегда греется впритык к машине.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174001L, 174004L, 174005L)),
        WordEntity(
            id = 174004, setId = 1740, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "barista_equipment", transliteration = "matchena",
            original = "מַטְחֵנָה", translation = "гриндер (мельница)",
            definition = "מַכְשִׁיר עִם לֶהָבִים שֶׁטּוֹחֵן גַּרְעִינִים לַאֲבַק עָדִין אוֹ גַּס.",
            definitionNative = "Прибор с лезвиями, перемалывающий зёрна в тонкий или крупный порошок.",
            example = "הַמַּטְחֵנָה הַחֲדָשָׁה רוֹעֶשֶׁת פָּחוֹת מֵהַיְּשָׁנָה.",
            exampleNative = "Новая מַטְחֵנָה шумит меньше старой.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174005, setId = 1740, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "barista_equipment", transliteration = "tamper",
            original = "טַמְפֶּר", translation = "темпер",
            definition = "כְּלִי קָטָן וְכָבֵד שֶׁלּוֹחֲצִים בּוֹ אֶת הָאָבָק לְשִׁכְבָה אֲחִידָה.",
            definitionNative = "Тяжёлый ручной инструмент для прижатия порошка в ровный слой.",
            example = "הַטַּמְפֶּר הַזָּהָב כָּבֵד פִּי שְׁתַּיִם מֵהָרָגִיל.",
            exampleNative = "Золотой טַמְפֶּר весит вдвое больше обычного.",
            isFillInBlankSafe = false,
        ),

        // ── barista_recipe (5) — рецептура ──
        WordEntity(
            id = 174006, setId = 1740, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "barista_recipe", transliteration = "tchina",
            original = "טְחִינָה", translation = "помол",
            definition = "מִדַּת הַעֲדִינוּת שֶׁל הַגַּרְעִינִים אַחֲרֵי הָעֲבוֹדָה בַּמַּטְחֵנָה.",
            definitionNative = "Степень тонкости частиц после прохождения через ножи мельницы.",
            example = "הַטְּחִינָה הָיְתָה גַּסָּה מִדַּי וְהַמָּנָה יָצְאָה חַלָּשָׁה.",
            exampleNative = "טְחִינָה вышла грубой, и порция получилась слабой.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174007, setId = 1740, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "barista_recipe", transliteration = "minon",
            original = "מִנּוּן", translation = "дозировка",
            definition = "הַכַּמּוּת הַמְדֻיֶּקֶת שֶׁל אָבָק לְכָל מָנָה לְפִי הַמַּתְכּוֹן.",
            definitionNative = "Точная масса засыпки на одну порцию по утверждённому рецепту.",
            example = "הַמִּנּוּן הַסָּטָנְדַּרְטִי אֶצְלֵנוּ הוּא שְׁמוֹנֶה עָשָׂר גְּרַם.",
            exampleNative = "Стандартный מִנּוּן у нас — восемнадцать грамм.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174008, setId = 1740, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "barista_recipe", transliteration = "lachatz mayim",
            original = "לַחַץ מַיִם", translation = "давление воды",
            definition = "הַכֹּחַ שֶׁבּוֹ הַמַּיִם עוֹבְרִים דֶּרֶךְ הַשִּׁכְבָה — תֵּשַׁע אַטְמוֹסְפֵרוֹת מְקֻבָּל.",
            definitionNative = "Сила, с которой вода идёт сквозь слой; девять атмосфер — норма.",
            example = "לַחַץ מַיִם נָמוּךְ מִדַּי גּוֹרֵם לְטַעַם מַיִּימִי.",
            exampleNative = "Низкий לַחַץ מַיִם даёт водянистый вкус.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174010L)),
        WordEntity(
            id = 174009, setId = 1740, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "barista_recipe", transliteration = "khom",
            original = "חֹם", translation = "температура",
            definition = "מִדַּת הָאֵשׁ שֶׁל הַמַּיִם בִּזְמַן שִׁפּוּכָם דֶּרֶךְ הָאָבָק.",
            definitionNative = "Степень нагретости воды в момент пролива через засыпку.",
            example = "הַחֹם שֶׁל הַמַּיִם צָרִיךְ לִהְיוֹת תִּשְׁעִים וְשָׁלֹשׁ מַעֲלוֹת.",
            exampleNative = "חֹם воды должен быть девяносто три градуса.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174006L, 174007L)),
        WordEntity(
            id = 174010, setId = 1740, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "barista_recipe", transliteration = "yakhas chiluts",
            original = "יַחַס חִלּוּץ", translation = "соотношение экстракции",
            definition = "הַיַּחַס הַמִּסְפָּרִי בֵּין הָאָבָק הַיָּבֵשׁ לְמִשְׁקַל הַנּוֹזֵל בַּכּוֹס.",
            definitionNative = "Числовое отношение сухой засыпки к массе жидкости в чашке.",
            example = "אֲנִי עוֹבֵד בְּיַחַס חִלּוּץ שֶׁל אֶחָד לִשְׁנַיִם.",
            exampleNative = "Я работаю в יַחַס חִלּוּץ один к двум.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174008L)),

        // ── barista_milk_art (5) — пар и латте-арт ──
        WordEntity(
            id = 174011, setId = 1740, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "barista_milk_art", transliteration = "ed",
            original = "אֵד", translation = "пар (для молока)",
            definition = "גַּז לָבָן וְחַם שֶׁיּוֹצֵא מֵצִנּוֹר וּמְחַמֵּם וּמַקְצִיף נוֹזֵל לָבָן.",
            definitionNative = "Белый горячий газ из трубки, что греет и взбивает белую жидкость.",
            example = "הָאֵד מֵהַצִּנּוֹר הִשְׁמִיעַ קוֹל חָלוּק וְעָדִין.",
            exampleNative = "אֵד из трубки шипел гладко и нежно.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174013L, 174014L, 174015L)),
        WordEntity(
            id = 174012, setId = 1740, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "barista_milk_art", transliteration = "ketsef chalav",
            original = "קֶצֶף חָלָב", translation = "молочная пена",
            definition = "שִׁכְבָה אֲוִירִית וְלוֹהֲטֶת בְּרֹאשׁ הַכּוֹס מֵאֲוִיר וְנוֹזֵל לָבָן.",
            definitionNative = "Воздушная и горячая прослойка наверху бокала из воздуха и сливочной массы.",
            example = "קֶצֶף חָלָב טוֹב נִרְאֶה בָּרָק וְמַתְמִיד דַּקּוֹת.",
            exampleNative = "Хороший קֶצֶף חָלָב блестит и стоит минутами.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174013, setId = 1740, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "barista_milk_art", transliteration = "late-art",
            original = "לָאטֶה־אַרְט", translation = "латте-арт",
            definition = "אָמָּנוּת שֶׁל צִיּוּרִים בָּרֹאשׁ הַמַּשְׁקֶה בְּעֶזְרַת קֶצֶף וּתְנוּעַת יָד.",
            definitionNative = "Искусство рисунка наверху чашки потоком пенки и движением руки.",
            example = "הוּא לוֹמֵד לָאטֶה־אַרְט שָׁלֹשׁ שָׁעוֹת בְּכָל יוֹם.",
            exampleNative = "Он учит לָאטֶה־אַרְט по три часа каждый день.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174011L, 174014L, 174015L)),
        WordEntity(
            id = 174014, setId = 1740, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "barista_milk_art", transliteration = "rozeta",
            original = "רוֹזֶטָה", translation = "розетта (узор)",
            definition = "צִיּוּר בְּצוּרַת עָלֶה שֶׁל שֻׁשַּׁן אוֹ שֶׁל שֶׁרֶךְ עִם פַּסִּים סִימֶטְרִיִּים.",
            definitionNative = "Рисунок в виде листа лилии или папоротника с симметричными штрихами.",
            example = "הוּא צִיֵּר רוֹזֶטָה מֻשְׁלֶמֶת מֵהַנִּסָּיוֹן הָרִאשׁוֹן.",
            exampleNative = "Он нарисовал безупречную רוֹזֶטָה с первой попытки.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174011L, 174013L, 174015L)),
        WordEntity(
            id = 174015, setId = 1740, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "barista_milk_art", transliteration = "tulipan",
            original = "טוּלִיפָּן", translation = "тюльпан (узор)",
            definition = "צִיּוּר חוֹזֵר שֶׁל שִׁכְבוֹת לְמַעְלָה הַנִּרְאוֹת כְּפֶרַח אָבִיב.",
            definitionNative = "Повторяющийся узор слоями вверх, похожий на весенний цветок.",
            example = "טוּלִיפָּן בֶּן חָמֵשׁ שִׁכְבוֹת קָשֶׁה בְּמְיוּחָד.",
            exampleNative = "טוּלִיפָּן на пять слоёв особенно сложен.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174011L, 174013L, 174014L)),

        // ── barista_pos_screen (5) — касса и экраны ──
        WordEntity(
            id = 174016, setId = 1740, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "barista_pos_screen", transliteration = "luach tafrit",
            original = "לוּחַ תַּפְרִיט", translation = "доска меню",
            definition = "שֶׁלֶט גָּדוֹל מֵעַל הַדֶּלְפֵּק עִם רְשִׁימַת מַשְׁקָאוֹת וּמְחִירִים.",
            definitionNative = "Большой щит над прилавком со списком напитков и сумм.",
            example = "צִיַּרְתִּי אֶת לוּחַ הַתַּפְרִיט הֶחָדָשׁ בְּגִיר.",
            exampleNative = "Я расписал новый לוּחַ תַּפְרִיט мелом.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174017, setId = 1740, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "barista_pos_screen", transliteration = "tsag",
            original = "צָג", translation = "дисплей",
            definition = "מָסָךְ קָטָן בַּקֻּפָּה שֶׁמַּרְאֶה לַלָּקוֹחַ אֶת הַסְכוּם וְהַפְּרִיטִים.",
            definitionNative = "Маленький экран на кассе, что показывает посетителю позиции и сумму.",
            example = "הַצָּג כִּבָּה אֶמְצַע מִשְׁמֶרֶת הַבֹּקֶר.",
            exampleNative = "צָג отключился прямо посреди утренней смены.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174018, setId = 1740, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "barista_pos_screen", transliteration = "tip",
            original = "טִיפּ", translation = "чаевые",
            definition = "כֶּסֶף נוֹסָף שֶׁהַלָּקוֹחַ מַשְׁאִיר לָעוֹבֵד מֵרְצוֹנוֹ הַחוֹפְשִׁי.",
            definitionNative = "Дополнительная сумма, что посетитель оставляет работнику добровольно.",
            example = "הַלָּקוֹחַ הַקָּבוּעַ הִשְׁאִיר טִיפּ נָדִיב הַבֹּקֶר.",
            exampleNative = "Постоянный посетитель оставил щедрый טִיפּ утром.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174019, setId = 1740, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "barista_pos_screen", transliteration = "mishloach yashir",
            original = "מִשְׁלוֹחַ יָשִׁיר", translation = "доставка через приложение",
            definition = "שֵׁרוּת שֶׁבּוֹ שָׁלִיחַ אוֹסֵף מַשְׁקֶה וּמַעֲבִיר אוֹתוֹ לְבַיִת אוֹ מִשְׂרָד.",
            definitionNative = "Услуга, где курьер забирает напиток и везёт домой или в офис.",
            example = "הַזְמָנוֹת מִשְׁלוֹחַ יָשִׁיר תָּפְסוּ חֵצִי מֵהָעֲבוֹדָה.",
            exampleNative = "Заказы מִשְׁלוֹחַ יָשִׁיר занимают половину работы.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174016L, 174020L)),
        WordEntity(
            id = 174020, setId = 1740, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "barista_pos_screen", transliteration = "lakoach kavua",
            original = "לָקוֹחַ קָבוּעַ", translation = "постоянный клиент",
            definition = "אִישׁ שֶׁבָּא לְבֵית הַקָּפֶה הַזֶּה כִּמְעַט בְּכָל יוֹם בִּקְבִיעוּת.",
            definitionNative = "Человек, что приходит сюда почти каждый день регулярно.",
            example = "לָקוֹחַ קָבוּעַ אוֹהֵב לָאטֶה גָּדוֹל בְּלִי סֻכָּר.",
            exampleNative = "לָקוֹחַ קָבוּעַ любит большое латте без сахара.",
            isFillInBlankSafe = false,
        ),

        // ── barista_shift (5) — рабочая смена ──
        WordEntity(
            id = 174021, setId = 1740, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "barista_shift", transliteration = "mishmeret",
            original = "מִשְׁמֶרֶת", translation = "рабочая смена",
            definition = "פֶּרֶק זְמַן רָצוּף שֶׁבּוֹ אוֹתוֹ עוֹבֵד מַחְזִיק אֶת הַדֶּלְפֵּק.",
            definitionNative = "Непрерывный отрезок дня, в котором один сотрудник держит стойку.",
            example = "הַמִּשְׁמֶרֶת שֶׁלִּי מַתְחִילָה בְּשֵׁשׁ בַּבֹּקֶר.",
            exampleNative = "Моя מִשְׁמֶרֶת начинается в шесть утра.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174022, setId = 1740, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "barista_shift", transliteration = "ptiha",
            original = "פְּתִיחָה", translation = "открытие смены",
            definition = "הַפְּעֻלּוֹת הָרִאשׁוֹנוֹת בַּבֹּקֶר — חִמּוּם הַמְּכוֹנָה וְכִוּוּן הַמַּטְחֵנָה.",
            definitionNative = "Первые действия утром: прогрев аппарата и настройка мельницы.",
            example = "פְּתִיחָה אִיטִית גּוֹרֶמֶת לְמַשְׁקֶה רִאשׁוֹן רַע.",
            exampleNative = "Медленная פְּתִיחָה портит первый утренний бокал.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174021L, 174023L, 174025L)),
        WordEntity(
            id = 174023, setId = 1740, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "barista_shift", transliteration = "sgira",
            original = "סְגִירָה", translation = "закрытие смены",
            definition = "הַפְּעֻלּוֹת בְּסוֹף הַיּוֹם — נִקּוּי, סְפִירַת קֻפָּה וְכִבּוּי הַחַשְׁמַל.",
            definitionNative = "Действия в конце дня: чистка, пересчёт денег и выключение тока.",
            example = "סְגִירָה לוֹקַחַת אֶצְלִי כִּשְׁלֹשִׁים דַּקּוֹת.",
            exampleNative = "סְגִירָה занимает у меня минут тридцать.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174021L, 174022L, 174025L)),
        WordEntity(
            id = 174024, setId = 1740, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "barista_shift", transliteration = "shiat seah",
            original = "שְׁעַת שִׂיא", translation = "утренний пик",
            definition = "פֶּרֶק שֶׁל לַחַץ גָּדוֹל בִּזְמַן שֶׁכָּל הָעוֹבְדִים בָּאִים בְּדַרְכָּם לָעֲבוֹדָה.",
            definitionNative = "Период наибольшей нагрузки, когда все работники идут к станку.",
            example = "בִּשְׁעַת שִׂיא יֵשׁ תּוֹר שֶׁל עֲשָׂרָה אֲנָשִׁים.",
            exampleNative = "В שְׁעַת שִׂיא очередь из десяти посетителей.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174025, setId = 1740, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "barista_shift", transliteration = "manuy",
            original = "מָנוּי", translation = "абонемент на кофе",
            definition = "הֶסְכֵּם חוֹדְשִׁי שֶׁל לָקוֹחַ עַל מַשְׁקֶה אֶחָד בְּכָל יוֹם בְּמָחִיר קָבוּעַ.",
            definitionNative = "Месячный договор клиента на один напиток в день за фиксированную сумму.",
            example = "קָנִיתִי מָנוּי הַחֹדֶשׁ וְכָל יוֹם בָּא בָּאוֹתָהּ שָׁעָה.",
            exampleNative = "Я взял מָנוּי на месяц и хожу каждый день в одно время.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174021L, 174022L, 174023L)),

        // ══════════════════════════════════════════════════════════════════════
        // Set 1741 — Кофейня и работа баристой: углублённые (L3, RARE+EPIC, B2-C1)
        // 5 групп × 5 слов: specialty, roast, taste, extraction, industry
        // ══════════════════════════════════════════════════════════════════════

        // ── barista_specialty (5) — спешелти и сорта ──
        WordEntity(
            id = 174101, setId = 1741, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_specialty", transliteration = "speshalti",
            original = "סְפֵּשַׁלְטִי", translation = "спешелти-кофе",
            definition = "מַדְרֵגָה הַגְּבוֹהָה שֶׁל אֵיכוּת הַגַּרְעִינִים מֵעַל שְׁמוֹנִים נְקֻדּוֹת בְּדֵרוּג.",
            definitionNative = "Высшая ступень качества зерна — выше восьмидесяти баллов в дегустации.",
            example = "אֲנַחְנוּ מַגִּישִׁים רַק סְפֵּשַׁלְטִי טָרִי מִחֲוָוֹת קְטַנּוֹת.",
            exampleNative = "Мы подаём только свежий סְפֵּשַׁלְטִי с малых ферм.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174102L, 174103L, 174105L)),
        WordEntity(
            id = 174102, setId = 1741, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "barista_specialty", transliteration = "arabika",
            original = "אֲרָבִּיקָה", translation = "арабика",
            definition = "זַן עָדִין בַּעַל חַמְצִיּוּת רַעֲנָנָה הַגָּדֵל בְּהָרִים גְּבוֹהִים.",
            definitionNative = "Деликатный вид с яркой кислинкой, что растёт в высокогорных областях.",
            example = "אֲרָבִּיקָה מֵאַתְיוֹפְּיָה נִשְׁאֶרֶת אַהֲבָתִי הַגְּדוֹלָה.",
            exampleNative = "אֲרָבִּיקָה из Эфиопии — моя главная любовь.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174101L, 174103L, 174105L)),
        WordEntity(
            id = 174103, setId = 1741, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "barista_specialty", transliteration = "robusta",
            original = "רוֹבּוּסְטָה", translation = "робуста",
            definition = "זַן חָזָק וּמַר שֶׁמַּכִיל פִּי שְׁנַיִם קָפַאִין מֵאֲרָבִּיקָה רְגִילָה.",
            definitionNative = "Крепкий горьковатый вид с двойной дозой кофеина против обычной арабики.",
            example = "רוֹבּוּסְטָה מַכְנִיסָה גּוּף סָמִיךְ לַתַּעֲרֹבֶת הָאִיטַלְקִית.",
            exampleNative = "רוֹבּוּסְטָה даёт плотное тело итальянской смеси.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174101L, 174102L)),
        WordEntity(
            id = 174104, setId = 1741, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barista_specialty", transliteration = "single oridzhin",
            original = "מָקוֹר יָחִיד", translation = "сингл-ориджин",
            definition = "תּוֹצֶרֶת מֵחַוָּה אַחַת בִּלְבַד בְּלִי עִרְבּוּב עִם זַנִּים אֲחֵרִים.",
            definitionNative = "Продукт с одной фермы без смешения с зёрнами других хозяйств.",
            example = "מָקוֹר יָחִיד מִקֶּנְיָה זָכָה אֵצֶל הַחוֹבְבִים בְּהַעֲרָכָה רַבָּה.",
            exampleNative = "מָקוֹר יָחִיד из Кении завоевал высокую оценку у любителей.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174105, setId = 1741, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_specialty", transliteration = "tarovet",
            original = "תַּעֲרֹבֶת", translation = "купаж (бленд)",
            definition = "צֵרוּף שֶׁל זַנִּים שׁוֹנִים לְאִזּוּן בֵּין חַמְצִיּוּת לְגוּף וּמְתִיקוּת.",
            definitionNative = "Сочетание разных сортов ради баланса между кислинкой, телом и сластью.",
            example = "הַתַּעֲרֹבֶת הָאִיטַלְקִית כּוֹלֶלֶת אַרְבָּעָה מְקוֹרוֹת.",
            exampleNative = "Итальянская תַּעֲרֹבֶת включает четыре источника.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174101L, 174102L, 174103L)),

        // ── barista_roast (5) — обжарка ──
        WordEntity(
            id = 174106, setId = 1741, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "barista_roast", transliteration = "kliya",
            original = "קְלִיָּה", translation = "обжарка",
            definition = "הָעֲבוֹדָה הַתֶּרְמִית שֶׁמַּפְכָה גַּרְעִינִים יְרֻקִּים לִכְהֻלִּים וְרֵיחָנִיִּים.",
            definitionNative = "Тепловая работа, превращающая зелёные семена в коричневые и душистые.",
            example = "הַקְּלִיָּה הָעֲדִינָה שָׁמְרָה עַל הַדְּקֻיּוֹת שֶׁל הַזַּן.",
            exampleNative = "Деликатная קְלִיָּה сохранила тонкости сорта.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174107, setId = 1741, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "barista_roast", transliteration = "kliya bahira",
            original = "קְלִיָּה בְּהִירָה", translation = "светлая обжарка",
            definition = "דַּרְגָּה קְצָרָה הַשּׁוֹמֶרֶת עַל פֵּרוֹתִיּוּת וְחַמְצִיּוּת בּוֹלֶטֶת בַּכּוֹס.",
            definitionNative = "Короткая степень, сохраняющая фруктовость и кислинку в напитке.",
            example = "קְלִיָּה בְּהִירָה דּוֹרֶשֶׁת מַיִם חַמִּים יוֹתֵר לַחִלּוּץ.",
            exampleNative = "קְלִיָּה בְּהִירָה требует более горячей воды для пролива.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174108L, 174109L, 174110L)),
        WordEntity(
            id = 174108, setId = 1741, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "barista_roast", transliteration = "kliya beinit",
            original = "קְלִיָּה בֵּינוֹנִית", translation = "средняя обжарка",
            definition = "דַּרְגַּת בֵּינַיִם שֶׁל אִזּוּן בֵּין מְתִיקוּת, גּוּף וְחַמְצִיּוּת מְעֻדֶּנֶת.",
            definitionNative = "Промежуточная ступень с балансом сладости, тела и мягкой кислинки.",
            example = "קְלִיָּה בֵּינוֹנִית מַתְאִימָה גַּם לְמַשְׁקֶה כֵּהֶה וְגַם לְחָלָב.",
            exampleNative = "קְלִיָּה בֵּינוֹנִית подходит и под чёрный, и под молоко.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174107L, 174109L, 174110L)),
        WordEntity(
            id = 174109, setId = 1741, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "barista_roast", transliteration = "kliya keha",
            original = "קְלִיָּה כֵּהָה", translation = "тёмная обжарка",
            definition = "דַּרְגָּה אֲרֻכָּה שֶׁל מְרִירוּת, גּוּף עָבֶה וְשֶׁמֶן עַל פְּנֵי הַגַּרְעִין.",
            definitionNative = "Долгая ступень с горчинкой, плотным телом и маслом на поверхности.",
            example = "אִיטַלְיָה אוֹהֶבֶת קְלִיָּה כֵּהָה וְעָשִׁירָה.",
            exampleNative = "Италия любит קְלִיָּה כֵּהָה и насыщенную.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174107L, 174108L, 174110L)),
        WordEntity(
            id = 174110, setId = 1741, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barista_roast", transliteration = "profil kliya",
            original = "פְּרוֹפִיל קְלִיָּה", translation = "профиль обжарки",
            definition = "עֲקֻמַּת זְמַן וְחֹם מְדֻיֶּקֶת שֶׁבָּהּ עוֹבֵד הַקַּלָּאי לְכָל זַן בִּפְרָט.",
            definitionNative = "Точная кривая времени и температуры, по которой обжарщик ведёт каждый сорт.",
            example = "פְּרוֹפִיל קְלִיָּה לְקֶנְיָה אוֹרֵךְ אַחַד עָשָׂר וַחֲצִי דַּקּוֹת.",
            exampleNative = "פְּרוֹפִיל קְלִיָּה для Кении длится одиннадцать с половиной минут.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174107L, 174108L, 174109L)),

        // ── barista_taste (5) — вкус и оценка ──
        WordEntity(
            id = 174111, setId = 1741, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "barista_taste", transliteration = "zer",
            original = "זֵר", translation = "букет (вкус)",
            definition = "מְכֻלָּת הַטְּעָמִים וְהָרֵיחוֹת שֶׁל הַמַּשְׁקֶה הַנֶּחְבָּר לִידִיעָה אַחַת.",
            definitionNative = "Совокупность вкусов и ароматов чашки, что складывается в одно впечатление.",
            example = "הַזֵּר שֶׁל הַזַּן הַזֶּה מַזְכִּיר פֵּרוֹת יָבֵשׁ.",
            exampleNative = "זֵר этого сорта напоминает сухофрукты.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174112, setId = 1741, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "barista_taste", transliteration = "chamtzitsut",
            original = "חַמְצִיצוּת", translation = "кислотность",
            definition = "תְּחוּשָׁה חֲרִיפָה וְעַלִּיזָה שֶׁמַּזְכִּירָה לִימוֹן אוֹ פְּרִי הָדָר טָרִי.",
            definitionNative = "Острое и весёлое ощущение, что напоминает лимон или свежий цитрус.",
            example = "חַמְצִיצוּת בְּהִירָה הִיא סִימָן שֶׁל זַן רָם.",
            exampleNative = "Яркая חַמְצִיצוּת — признак высокогорного сорта.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174111L, 174115L)),
        WordEntity(
            id = 174113, setId = 1741, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "barista_taste", transliteration = "taam shenishar",
            original = "טַעַם שֶׁנִּשְׁאָר", translation = "послевкусие",
            definition = "הָרֹשֶׁם הָאַחֲרוֹן בַּפֶּה אַחֲרֵי הַלְּגִימָה הַסּוֹפִית שֶׁל הַמַּשְׁקֶה.",
            definitionNative = "Завершающий отпечаток во рту после последнего глотка чашки.",
            example = "טַעַם שֶׁנִּשְׁאָר אָרֹךְ מְעִיד עַל גַּרְעִין מְעוּלֶה.",
            exampleNative = "Долгий טַעַם שֶׁנִּשְׁאָר свидетельствует о высоком зерне.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174114L)),
        WordEntity(
            id = 174114, setId = 1741, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barista_taste", transliteration = "lekhet teamim",
            original = "לוּחַ טְעָמִים", translation = "вкусовая палитра",
            definition = "תַּרְשִׁים מְקֻבָּל בִּמְקַצּוֹעַ הַמְצַיֵּג מִשְׁפָּחוֹת שֶׁל אֲרוֹמוֹת אֶפְשָׁרִיּוֹת.",
            definitionNative = "Принятая в профессии схема, что показывает группы возможных ароматов.",
            example = "לוּחַ טְעָמִים עוֹזֵר לִי לִכְתֹּב הֶעָרוֹת מְדֻיָּקוֹת.",
            exampleNative = "לוּחַ טְעָמִים помогает мне писать точные пометки.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174113L)),
        WordEntity(
            id = 174115, setId = 1741, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_taste", transliteration = "notot",
            original = "נוֹטוֹת", translation = "нотки (аромата)",
            definition = "רִמְזֵי טַעַם דַּקִּים שֶׁמּוּכָּרִים בַּגְּמִיעָה — שׁוֹקוֹלָד, אֱגוֹז אוֹ פְּרִי הָדָר.",
            definitionNative = "Тонкие следы вкуса при глотке: шоколад, орех или цитрус.",
            example = "אֲנִי טוֹעֵם נוֹטוֹת שֶׁל פֵּרוֹת יַעַר בָּזֶה.",
            exampleNative = "Я чувствую נוֹטוֹת лесных ягод в этом.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174111L, 174112L)),

        // ── barista_extraction (5) — экстракция ──
        WordEntity(
            id = 174116, setId = 1741, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_extraction", transliteration = "chilutz",
            original = "חִלּוּץ", translation = "экстракция",
            definition = "תַּהֲלִיךְ שֶׁבּוֹ מַיִם חַמִּים מַסִּיעִים אֶת הַטַּעַם מֵהָאָבָק לַכּוֹס.",
            definitionNative = "Процесс, в котором горячая вода переносит вкус из засыпки в чашку.",
            example = "חִלּוּץ אִיטִי גּוֹרֵם לְטַעַם מַר וְכָבֵד.",
            exampleNative = "Медленный חִלּוּץ даёт горький и тяжёлый вкус.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174119L, 174120L)),
        WordEntity(
            id = 174117, setId = 1741, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barista_extraction", transliteration = "tat-chilutz",
            original = "תַּת־חִלּוּץ", translation = "под-экстракция",
            definition = "בְּעָיָה שֶׁבָּהּ הַמַּיִם לֹא הִסְפִּיקוּ לְהוֹצִיא אֶת הַסְּכָרִים מֵהָאָבָק.",
            definitionNative = "Сбой, когда вода не успела вынуть сахара из засыпки.",
            example = "תַּת־חִלּוּץ נִכָּר בְּטַעַם חָמוּץ וְקָצָר.",
            exampleNative = "תַּת־חִלּוּץ узнаётся по кислому и короткому вкусу.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174118L)),
        WordEntity(
            id = 174118, setId = 1741, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barista_extraction", transliteration = "chilutz yater",
            original = "חִלּוּץ יֶתֶר", translation = "пере-экстракция",
            definition = "בְּעָיָה שֶׁבָּהּ הַמַּיִם הוֹצִיאוּ גַּם חֳמָרִים מַרִים בִּגְלַל זְמַן יוֹתֵר מִדַּי אָרֹךְ.",
            definitionNative = "Сбой, когда вода вынула и горькие соединения из-за слишком долгого пролива.",
            example = "חִלּוּץ יֶתֶר נוֹתֵן טַעַם מָאוּס שֶׁל קְלִפָּה.",
            exampleNative = "חִלּוּץ יֶתֶר даёт противный привкус кожуры.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174117L)),
        WordEntity(
            id = 174119, setId = 1741, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_extraction", transliteration = "tealat mayim",
            original = "תְּעָלַת מַיִם", translation = "чанелинг",
            definition = "מַעֲבָר מָהִיר שֶׁל מַיִם דֶּרֶךְ סֶדֶק יָחִיד וְלֹא דֶּרֶךְ הַשִּׁכְבָה אֲחִידָה.",
            definitionNative = "Быстрый ход воды по одной щели, а не по всему слою равномерно.",
            example = "תְּעָלַת מַיִם פּוֹגַעַת קָשׁוֹת בָּרֹשֶׁם הַסּוֹפִי.",
            exampleNative = "תְּעָלַת מַיִם сильно бьёт по итоговому впечатлению.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174116L, 174120L)),
        WordEntity(
            id = 174120, setId = 1741, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "barista_extraction", transliteration = "kaping",
            original = "קַאפִּינְג", translation = "каппинг",
            definition = "טֶקֶס מִקְצוֹעִי שֶׁל טְעִימָה לְצֹרֶךְ הַעֲרָכָה וְהַשְׁוָאָה בֵּין זַנִּים שׁוֹנִים.",
            definitionNative = "Профессиональная церемония дегустации для оценки и сравнения сортов.",
            example = "קַאפִּינְג שְׁבוּעִי מְשַׁפֵּר אֶת הַחֵךְ שֶׁל הַצֶּוֶת.",
            exampleNative = "Еженедельный קַאפִּינְג улучшает нёбо команды.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174116L, 174119L)),

        // ── barista_industry (5) — индустрия и торговля ──
        WordEntity(
            id = 174121, setId = 1741, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "barista_industry", transliteration = "khavai",
            original = "חַוַּאי", translation = "фермер",
            definition = "אִישׁ שֶׁמְּגַדֵּל אֶת הַשִּׂיחִים בְּחַוָּתוֹ וְאוֹסֵף מֵהֶם פֵּרוֹת בְּשֵׁלִים.",
            definitionNative = "Человек, что выращивает кусты на ферме и собирает с них спелые ягоды.",
            example = "הַחַוַּאי בְּקוֹלוֹמְבְּיָה מַכְנִיס לָנוּ פֵּרוֹת מְעוּלִים.",
            exampleNative = "חַוַּאי в Колумбии поставляет нам отменные ягоды.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174124L, 174125L)),
        WordEntity(
            id = 174122, setId = 1741, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barista_industry", transliteration = "sakhar yashir",
            original = "סַחַר יָשִׁיר", translation = "прямая торговля",
            definition = "מִסְחָר בֵּין הַחַוָּה לַקַּלָּאי בְּלִי מְתַוְּכִים — תַּשְׁלוּם הוֹגֵן יוֹתֵר.",
            definitionNative = "Торговля фермы напрямую с обжарщиком без посредников — справедливее по оплате.",
            example = "סַחַר יָשִׁיר מַעֲלֶה אֶת רָמַת הַחַיִּים בִּכְפָרִים מְרֻחָקִים.",
            exampleNative = "סַחַר יָשִׁיר поднимает уровень жизни в дальних деревнях.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174123L)),
        WordEntity(
            id = 174123, setId = 1741, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "barista_industry", transliteration = "tasrir hogen",
            original = "תַּסְרִיר הוֹגֵן", translation = "сертификат справедливой торговли",
            definition = "תָּו רִשְׁמִי שֶׁמְּאַשֵּׁר תְּנָאֵי עֲבוֹדָה הוֹגְנִים וְשָׂכָר מִינִימָלִי לַחַוַּאי.",
            definitionNative = "Официальный знак, что подтверждает достойные условия и минимальный заработок.",
            example = "אֲנַחְנוּ קוֹנִים רַק זַנִּים עִם תַּסְרִיר הוֹגֵן.",
            exampleNative = "Мы покупаем только сорта с תַּסְרִיר הוֹגֵן.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174122L)),
        WordEntity(
            id = 174124, setId = 1741, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "barista_industry", transliteration = "onatiyut",
            original = "עוֹנָתִיּוּת", translation = "сезонность урожая",
            definition = "תַּלוּי שֶׁל אֵיכוּת הַזַּן בִּזְמַן הָאָסִיף בַּחַוָּה בְּמְהַלָּךְ הַשָּׁנָה.",
            definitionNative = "Зависимость качества сорта от времени сбора урожая в течение года.",
            example = "הָעוֹנָתִיּוּת מְשַׁנָּה אֶת הַתַּפְרִיט שֶׁלָּנוּ פַּעֲמַיִם בַּשָּׁנָה.",
            exampleNative = "עוֹנָתִיּוּת меняет наше меню дважды в год.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174121L, 174125L)),
        WordEntity(
            id = 174125, setId = 1741, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "barista_industry", transliteration = "taharut",
            original = "תַּחֲרוּת", translation = "бариста-чемпионат",
            definition = "אֵרוּעַ מִקְצוֹעִי שֶׁבּוֹ אַנְשֵׁי הַמִּקְצוֹעַ מַצִּיגִים מְיֻמָנוּת לִפְנֵי שׁוֹפְטִים.",
            definitionNative = "Профессиональное событие, где спецы показывают мастерство перед судьями.",
            example = "אֲנִי מִתְכּוֹנֵן לַתַּחֲרוּת הָאַרְצִית כָּל אַחַר צָהֳרַיִם.",
            exampleNative = "Я готовлюсь к национальному תַּחֲרוּת каждый день после обеда.",
            isFillInBlankSafe = false,
         fillInBlankExclusions = listOf(174121L, 174124L)),
    )
}
