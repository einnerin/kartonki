package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Кулинария Израиля", level 3 (B2).
 * Один сет × 25 слов. setId = 1844.
 *
 *  - 18 RARE + 7 UNCOMMON (два смежных уровня B1 + B2).
 *  - 5 семантических групп по 5 слов:
 *      cuisine_l3_advanced_techniques — продвинутые кулинарные техники (5)
 *      cuisine_l3_regional            — региональные кухни Израиля (5)
 *      cuisine_l3_kosher_advanced     — продвинутая лексика кашрута (5)
 *      cuisine_l3_terms_culinary      — общие кулинарные термины B1-B2 (5)
 *      cuisine_l3_specialty_dishes    — специальные блюда диаспоры (5)
 *  - Углублённая лексика B2 по теме «Кулинария Израиля» — продолжение L1
 *    (1842) и L2 (1843). Не пересекается с L1 по списку слов: фалафель,
 *    хумус, шакшука, бурекас, сабих, тхина, нут, заатар, авокадо, мята,
 *    завтрак/ужин/шабат, чолент, перекус, есть/готовить/заказывать/
 *    пробовать/нарезать, хумусия, фалафельная, маадания, рынок, ресторан —
 *    здесь их нет.
 *  - Не пересекается с L2 (1843) по списку слов: לְהַשְׁרוֹת, לְהַקְפִּיא,
 *    לְבַשֵּׁל בְּאֵדִים, לְקַלּוֹת, לְעַשֵּׁן, מָלָוַח, קוּבֶּה, מַחְשִׁי, פָתָה,
 *    סָחְלָב, חָלָבִי, בְּשָׂרִי, פַּרְוֶה, נֶטִילַת יָדַיִם, חוֹתֶמֶת רַבָּנוּת,
 *    тапузина/арак/кофе, миц-римоним, ознэ-hаман, харосет, קוּגֶל,
 *    кнейдлах, халва — все эти слова остались в L2.
 *  - Базовая еда (לֶחֶם, יַיִן, תַּפּוּחַ, תַּפּוּחַ אֲדָמָה, גְּבִינָה, בָּשָׂר, דָּג,
 *    אֹרֶז, עוֹף) занята в Immigrant — здесь не используется.
 *  - Никудим везде (стандарт he-ru). Огласовки в `example` ставятся только
 *    на целевом слове.
 *  - Выравнивания rarity под существующую базу (та же оригинальная форма
 *    уже есть в репо — рарность в этом сете обязана совпадать):
 *      • סְפָרַדִּי — UNCOMMON (1071/1613, ethnic groups). Здесь: «сефардская
 *        кухня».
 *      • אַשְׁכְּנַזִּי — UNCOMMON (1071/1613). Здесь: «ашкеназская кухня».
 *      • תַּבְלִין — UNCOMMON (1043/1374). То же значение, общая приправа.
 *      • מַתְכּוֹן — UNCOMMON (1375). То же значение, рецепт.
 *      • מַשְׁגִּיחַ — UNCOMMON (1031, школа). Здесь: «машгиах кашрута»
 *        (другое значение, та же оригинальная форма).
 *      • הַפְרָדָה — UNCOMMON (1147, кошер). То же значение, разделение
 *        мясного и молочного.
 *  - Все 25 слов проверены grep'ом по `original = "..."` против всех
 *    WordDataHebrew*.kt и WordDataImmigrant*.kt — других конфликтов нет.
 *  - fillInBlankExclusions / isFillInBlankSafe — не выставлены здесь;
 *    FILL_IN_BLANK pipeline инжектит их централизованно после wave.
 */
object WordDataHebrewIsraeliCuisineL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1844, languagePair = "he-ru", orderIndex = 1844,
            name = "Кулинария Израиля",
            description = "Продвинутые техники, региональные кухни и кашрут",
            topic = "Кулинария Израиля", level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── cuisine_l3_advanced_techniques (5) ──────────────────────────
        WordEntity(
            id = 184401, setId = 1844, languagePair = "he-ru", rarity = "RARE",
            pos = "verb", semanticGroup = "cuisine_l3_advanced_techniques",
            original = "לְהַתְפִּיחַ", translation = "поднимать (тесто)",
            transliteration = "леатпиях",
            definition = "לְהַשְׁאִיר בָּצֵק עִם שְׁמָרִים בְּמָקוֹם חַם כְּדֵי שֶׁיִּגְדַּל וְיִתְמַלֵּא אֲוִיר.",
            definitionNative = "Оставить тесто с дрожжами в тёплом месте, чтобы оно выросло и наполнилось воздухом.",
            example = "צָרִיךְ לְהַתְפִּיחַ אֶת הַבָּצֵק כְּשָׁעָה לִפְנֵי שֶׁמַּכְנִיסִים אוֹתוֹ לַתַּנּוּר.",
            exampleNative = "Нужно לְהַתְפִּיחַ тесто около часа перед тем, как поставить в духовку.",
        ),
        WordEntity(
            id = 184402, setId = 1844, languagePair = "he-ru", rarity = "RARE",
            pos = "verb", semanticGroup = "cuisine_l3_advanced_techniques",
            original = "לְקָרֵם", translation = "карамелизовать",
            transliteration = "лекарем",
            definition = "לְחַמֵּם סֻכָּר אוֹ יְרָקוֹת עַד שֶׁהֵם הוֹפְכִים לְשׁוֹלֶטֶת חוּמָה וּמְתוּקָה.",
            definitionNative = "Греть сахар или овощи до того момента, когда они становятся коричневыми и сладкими.",
            example = "הַשֵּׁף הִקְפִּיד לְקָרֵם אֶת הַבְּצָלִים לְאַט עַל אֵשׁ נְמוּכָה.",
            exampleNative = "Шеф старался לְקָרֵם лук медленно на маленьком огне до карамели.",
         fillInBlankExclusions = listOf(184401L, 184403L, 184404L, 184405L)),
        WordEntity(
            id = 184403, setId = 1844, languagePair = "he-ru", rarity = "RARE",
            pos = "verb", semanticGroup = "cuisine_l3_advanced_techniques",
            original = "לְהַחְמִיץ", translation = "квасить, мариновать",
            transliteration = "леахмиц",
            definition = "לְהַשְׁרוֹת יְרָקוֹת בְּחֹמֶץ אוֹ בְּמֶלַח כְּדֵי שֶׁיִּתְקַלְקְלוּ קְצָת וְיִקַבְּלוּ טַעַם חָרִיף.",
            definitionNative = "Замачивать овощи в уксусе или в соли, чтобы они слегка забродили и получили острый вкус.",
            example = "סָבְתָא נָהֲגָה לְהַחְמִיץ מְלָפְפוֹנִים בְּצִנְצֶנֶת זְכוּכִית עַל הַמִּרְפֶּסֶת.",
            exampleNative = "Бабушка любила לְהַחְמִיץ огурцы в стеклянной банке прямо на балконе.",
         fillInBlankExclusions = listOf(184401L, 184402L, 184404L, 184405L)),
        WordEntity(
            id = 184404, setId = 1844, languagePair = "he-ru", rarity = "RARE",
            pos = "verb", semanticGroup = "cuisine_l3_advanced_techniques",
            original = "לְהַקְצִיף", translation = "взбивать (в пену)",
            transliteration = "леакциф",
            definition = "לְעַרְבֵב חֹמֶר נוֹזֵל בְּמַטְרֵפָה בִּמְהִירוּת עַד שֶׁהוּא הוֹפֵךְ קַל וְמָלֵא בּוּעוֹת.",
            definitionNative = "Перемешивать жидкость венчиком быстро, пока она не становится лёгкой и полной пузырьков.",
            example = "צָרִיךְ לְהַקְצִיף אֶת הַחֶלְבּוֹנִים עַד שֶׁהֵם עוֹמְדִים יַצִּיב בְּקַעֲרָה.",
            exampleNative = "Нужно לְהַקְצִיף белки, пока они не стоят устойчиво в миске пиками.",
         fillInBlankExclusions = listOf(184401L, 184402L, 184403L, 184405L)),
        WordEntity(
            id = 184405, setId = 1844, languagePair = "he-ru", rarity = "RARE",
            pos = "verb", semanticGroup = "cuisine_l3_advanced_techniques",
            original = "לְהַתְסִיס", translation = "ферментировать",
            transliteration = "леатсис",
            definition = "לִגְרֹם לְמָזוֹן לְהִשְׁתַּנּוֹת בְּעֶזְרַת חַיְדַּקִּים אוֹ שְׁמָרִים — לְמָשָׁל בִּקְרַאוּט אוֹ בִּכְרוּב כָּבוּשׁ.",
            definitionNative = "Менять продукт с помощью бактерий или дрожжей — например, в крауте или квашеной капусте.",
            example = "סָבְתָא יוֹדַעַת לְהַתְסִיס יְרָקוֹת בִּצִנְצֶנֶת זְכוּכִית בְּמֶלַח לִשְׁבוּעַיִם.",
            exampleNative = "Бабушка умеет לְהַתְסִיס овощи в стеклянной банке с солью две недели.",
         fillInBlankExclusions = listOf(184401L, 184402L, 184403L, 184404L)),

        // ─── cuisine_l3_regional (5) ─────────────────────────────────────
        WordEntity(
            id = 184406, setId = 1844, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "cuisine_l3_regional",
            original = "סְפָרַדִּי", translation = "сефардский (о кухне)",
            transliteration = "сфаради",
            definition = "שֶׁל יְהוּדִים יוֹצְאֵי סְפָרַד וְצָפוֹן אַפְרִיקָה — בְּהֶקְשֵׁר אֹכֶל וּמַתְכּוֹנִים.",
            definitionNative = "Относящийся к евреям из Испании и Северной Африки — в контексте еды и рецептов.",
            example = "הַסָּלָט הַזֶּה הוּא חֵלֶק מֵהַמִּטְבָּח הַסְּפָרַדִּי הַמָּסוֹרְתִּי.",
            exampleNative = "Этот салат — часть традиционной сефардской кухни наших общин.",
        ),
        WordEntity(
            id = 184407, setId = 1844, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "cuisine_l3_regional",
            original = "אַשְׁכְּנַזִּי", translation = "ашкеназский (о кухне)",
            transliteration = "ашкеназú",
            definition = "שֶׁל יְהוּדִים יוֹצְאֵי מִזְרַח וּמֶרְכַּז אֵירוֹפָּה — בְּהֶקְשֵׁר אֹכֶל וּמַתְכּוֹנִים.",
            definitionNative = "Относящийся к евреям из Восточной и Центральной Европы — в контексте еды и рецептов.",
            example = "הַחָמִין הָאַשְׁכְּנַזִּי שׁוֹנֶה מֵהַחָמִין הַמָּרוֹקָאִי בִּתְבָלִין וּבְמִרְכָּב.",
            exampleNative = "Ашкеназский чолент отличается от марокканского по приправам и составу.",
         fillInBlankExclusions = listOf(184406L)),
        WordEntity(
            id = 184408, setId = 1844, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cuisine_l3_regional",
            original = "מִטְבָּח לְבָנוֹנִי", translation = "ливанская кухня",
            transliteration = "митбах леванони",
            definition = "מָסוֹרֶת בִּשּׁוּל מִלְבָנוֹן עִם הַרְבֵּה סָלָטִים, מַטְבּוּלִים וְשֶׁמֶן זַיִת.",
            definitionNative = "Кулинарная традиция Ливана с обилием салатов, мезе и оливкового масла.",
            example = "הַמִּטְבָּח הַלְּבָנוֹנִי תּוֹרֵם לָאֹכֶל שֶׁלָּנוּ אֶת הַטַּבּוּלֶה וְהַמַּטְבּוּלִים.",
            exampleNative = "מִטְבָּח לְבָנוֹנִי дарит израильской еде табуле и мезе с тхиной.",
        ),
        WordEntity(
            id = 184409, setId = 1844, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cuisine_l3_regional",
            original = "מִטְבָּח פֶּרְסִי", translation = "персидская кухня",
            transliteration = "митбах перси",
            definition = "מָסוֹרֶת בִּשּׁוּל מֵאִירָאן עִם אֹרֶז זַעְפְּרָן, גִּ'בֶּה וּפֵרוֹת מְיֻבָּשִׁים בִּתַבְשִׁילִים.",
            definitionNative = "Кулинарная традиция Ирана с шафрановым рисом, фрикадельками и сухофруктами в тушёных блюдах.",
            example = "הַמִּטְבָּח הַפֶּרְסִי מְפֻרְסָם בְּתַבְשִׁילִים אִטִּיִּים שֶׁל בָּשָׂר וְשָׁזִיף.",
            exampleNative = "מִטְבָּח פֶּרְסִי известен медленными блюдами из мяса и слив.",
        ),
        WordEntity(
            id = 184410, setId = 1844, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cuisine_l3_regional",
            original = "מִטְבָּח תֵּימָנִי", translation = "йеменская кухня",
            transliteration = "митбах теймани",
            definition = "מָסוֹרֶת בִּשּׁוּל מִתֵּימָן עִם תְּבָלִינִים חֲרִיפִים, מָרָק עוֹף, חִילְבֶּה וְלָחֹוחַ.",
            definitionNative = "Кулинарная традиция Йемена с острыми приправами, куриным супом, хильбе и лахохом.",
            example = "אֲרוּחַת שִׁשִּׁי בַּמִּטְבָּח הַתֵּימָנִי כּוֹלֶלֶת מָרָק חַם וְלָחֹוחַ טָרִי.",
            exampleNative = "Пятничная трапеза в מִטְבָּח תֵּימָנִי включает горячий суп и свежий лахох.",
        ),

        // ─── cuisine_l3_kosher_advanced (5) ──────────────────────────────
        WordEntity(
            id = 184411, setId = 1844, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cuisine_l3_kosher_advanced",
            original = "מַשְׁגִּיחַ", translation = "машгиах (надзор за кашрутом)",
            transliteration = "машгиах",
            definition = "אָדָם מֻסְמָךְ שֶׁמְּפַקֵּחַ עַל מִטְבָּח אוֹ עַל מִפְעָל לְוַדֵּא שֶׁהָאֹכֶל כָּשֵׁר.",
            definitionNative = "Уполномоченный человек, что наблюдает за кухней или предприятием, проверяя кошерность еды.",
            example = "הַמַּשְׁגִּיחַ הִגִּיעַ לַמִּסְעָדָה בַּבֹּקֶר לִבְדֹּק אֶת הַמַּקְפִּיא וְאֶת הַתְּעוּדוֹת.",
            exampleNative = "מַשְׁגִּיחַ пришёл в ресторан утром проверить морозильник и сертификаты.",
        ),
        WordEntity(
            id = 184412, setId = 1844, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cuisine_l3_kosher_advanced",
            original = "הַפְרָדָה", translation = "разделение (мясного и молочного)",
            transliteration = "афрада",
            definition = "כְּלָל בְּכַשְׁרוּת שֶׁמְּחַיֵּב לְהַחֲזִיק כֵּלִים וּמְקוֹמוֹת נִפְרָדִים לְבָשָׂר וּלְחָלָב.",
            definitionNative = "Правило кашрута, что обязывает держать раздельную посуду и места для мяса и молока.",
            example = "בַּמִּטְבָּח שֶׁלָּנוּ יֵשׁ הַפְרָדָה מְלֵאָה בֵּין הַכֵּלִים שֶׁל בָּשָׂר וְחָלָב.",
            exampleNative = "У нас на кухне полное הַפְרָדָה между посудой для мяса и молока.",
         fillInBlankExclusions = listOf(184411L, 184413L, 184414L, 184415L)),
        WordEntity(
            id = 184413, setId = 1844, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cuisine_l3_kosher_advanced",
            original = "בְּדִיקַת חָמֵץ", translation = "проверка на хамец",
            transliteration = "бдикат хамец",
            definition = "טֶקֶס לִפְנֵי פֶּסַח שֶׁבּוֹ עוֹבְרִים בַּבַּיִת עִם נֵר וּמְחַפְּשִׂים שְׁאֵרִיּוֹת לֶחֶם.",
            definitionNative = "Обряд накануне Песаха — проходят по дому со свечой и ищут остатки хлеба.",
            example = "אַבָּא עוֹשֶׂה בְּדִיקַת חָמֵץ עִם הַיְּלָדִים בַּלַּיְלָה לִפְנֵי הַסֵּדֶר.",
            exampleNative = "Папа делает בְּדִיקַת חָמֵץ с детьми в ночь перед седером.",
         fillInBlankExclusions = listOf(184411L, 184412L, 184414L, 184415L)),
        WordEntity(
            id = 184414, setId = 1844, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cuisine_l3_kosher_advanced",
            original = "בְּשַׂר גְּלַאט", translation = "глат-кошер (мясо строжайшего кашрута)",
            transliteration = "бесар глат",
            definition = "בָּשָׂר שֶׁעָבַר בְּדִיקָה מַחְמִירָה בְּיוֹתֵר וְהָרֵאוֹת שֶׁלּוֹ נְקִיּוֹת לְגַמְרֵי.",
            definitionNative = "Мясо, прошедшее самую строгую проверку, у которого лёгкие совершенно чистые.",
            example = "בַּשְּׁכוּנָה הַחֲרֵדִית קוֹנִים רַק בְּשַׂר גְּלַאט מֵהָאַטְלִיז הַמֻּסְמָךְ.",
            exampleNative = "В харедимном квартале покупают только בְּשַׂר גְּלַאט в сертифицированной мясной лавке.",
         fillInBlankExclusions = listOf(184411L, 184412L, 184413L, 184415L)),
        WordEntity(
            id = 184415, setId = 1844, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cuisine_l3_kosher_advanced",
            original = "מְלִיחָה", translation = "просолка (вытягивание крови из мяса)",
            transliteration = "млиха",
            definition = "תַּהֲלִיךְ כָּשֵׁר שֶׁל הוֹסָפַת מֶלַח לְבָשָׂר חַי כְּדֵי לְהוֹצִיא מִמֶּנּוּ אֶת כָּל הַדָּם.",
            definitionNative = "Кошерный процесс посыпать сырое мясо солью, чтобы вытянуть из него всю кровь.",
            example = "אַחֲרֵי הַשְּׁחִיטָה עוֹשִׂים מְלִיחָה לַבָּשָׂר בִּשְׁעָתַיִם תְּמִימוֹת.",
            exampleNative = "После забоя делают מְלִיחָה мяса в течение полных двух часов вымачивания.",
         fillInBlankExclusions = listOf(184411L, 184412L, 184413L, 184414L)),

        // ─── cuisine_l3_terms_culinary (5) ───────────────────────────────
        WordEntity(
            id = 184416, setId = 1844, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cuisine_l3_terms_culinary",
            original = "תַּבְלִין", translation = "приправа, специя",
            transliteration = "тавлин",
            definition = "חֹמֶר יָבֵשׁ אוֹ טָרִי שֶׁמּוֹסִיפִים לְמָזוֹן כְּדֵי לָתֵת לוֹ טַעַם וְרֵיחַ.",
            definitionNative = "Сухой или свежий компонент, что добавляют к еде, чтобы дать ей вкус и аромат.",
            example = "הַסּוּמָק הוּא תַּבְלִין חָמוּץ אָדֹם שֶׁמַּשְׁתַּמְּשִׁים בּוֹ בַּסַּלָּטִים.",
            exampleNative = "Сумах — это кислый красный תַּבְלִין, который добавляют в салаты.",
         fillInBlankExclusions = listOf(184417L, 184418L, 184419L, 184420L)),
        WordEntity(
            id = 184417, setId = 1844, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cuisine_l3_terms_culinary",
            original = "מַתְכּוֹן", translation = "рецепт",
            transliteration = "матком",
            definition = "סֵדֶר כָּתוּב שֶׁל מַרְכִּיבִים וּשְׁלַבֵּי הֲכָנָה לְהָכִין מָנָה מְסֻיֶּמֶת.",
            definitionNative = "Письменный порядок ингредиентов и шагов приготовления для конкретного блюда.",
            example = "מָצָאתִי מַתְכּוֹן יָשָׁן שֶׁל סָבְתָא לְעוּגַת דְּבַשׁ עַם תַּפּוּזִים.",
            exampleNative = "Я нашёл старый מַתְכּוֹן бабушки для медового пирога с апельсинами.",
         fillInBlankExclusions = listOf(184416L, 184418L, 184419L, 184420L)),
        WordEntity(
            id = 184418, setId = 1844, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cuisine_l3_terms_culinary",
            original = "מַרְכִּיב", translation = "ингредиент",
            transliteration = "маркив",
            definition = "כָּל אֶחָד מֵהַחֲלָקִים שֶׁמְּחַבְּרִים יַחַד כְּדֵי לְהָכִין מָנָה אוֹ מַתְכּוֹן.",
            definitionNative = "Каждая из частей, что соединяются вместе для приготовления блюда или рецепта.",
            example = "הַמַּרְכִּיב הָעִקָּרִי בְּחוּמּוּס אֲמִתִּי הוּא חִמְצָה טְחוּנָה הֵיטֵב.",
            exampleNative = "Главный מַרְכִּיב в настоящем хумусе — хорошо протёртый нут.",
        ),
        WordEntity(
            id = 184419, setId = 1844, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cuisine_l3_terms_culinary",
            original = "כַּמּוּת", translation = "количество (в рецепте)",
            transliteration = "камут",
            definition = "מִסְפָּר אוֹ מִדָּה שֶׁמְּתָאֲרִים כַּמָּה יֵשׁ מִכָּל מַרְכִּיב בַּמָּנָה.",
            definitionNative = "Число или мера, что описывает, сколько каждого ингредиента в блюде.",
            example = "הַכַּמּוּת שֶׁל הַמֶּלַח בַּמַּתְכּוֹן הָיְתָה גְּדוֹלָה מִדַּי לְטַעְמֵנוּ.",
            exampleNative = "כַּמּוּת соли в рецепте оказалась слишком большой на наш вкус.",
         fillInBlankExclusions = listOf(184416L, 184417L, 184418L, 184420L)),
        WordEntity(
            id = 184420, setId = 1844, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cuisine_l3_terms_culinary",
            original = "מִרְקָם", translation = "текстура (блюда)",
            transliteration = "миркам",
            definition = "הַתְּחוּשָׁה הַפִיזִית שֶׁל אֹכֶל בַּפֶּה — קָשֶׁה, רַךְ, חָלָק אוֹ פָּרִיךְ.",
            definitionNative = "Физическое ощущение пищи во рту — твёрдая, мягкая, гладкая или хрустящая.",
            example = "הַמִּרְקָם שֶׁל הַחוּמּוּס הַזֶּה חָלָק וְקָטִיפָתִי בְּלִי גַּרְעִינִים.",
            exampleNative = "מִרְקָם у этого хумуса гладкий и бархатный, без зёрен совсем.",
        ),

        // ─── cuisine_l3_specialty_dishes (5) ─────────────────────────────
        WordEntity(
            id = 184421, setId = 1844, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cuisine_l3_specialty_dishes",
            original = "מַעֲמוּל", translation = "маамуль (печенье с финиками)",
            transliteration = "маамуль",
            definition = "עוּגִיּוֹת מָסוֹרְתִיוֹת מְמֻלָּאוֹת בִּתְמָרִים אוֹ בֶּאֱגוֹזִים — אֹפְיָנִי לַמִּזְרָח הַתִּיכוֹן.",
            definitionNative = "Традиционное печенье с начинкой из фиников или орехов — характерно для Ближнего Востока.",
            example = "סָבְתָא הֵכִינָה מַעֲמוּל לְכָל הָאוֹרְחִים שֶׁל חַג הָרַמַדָאן.",
            exampleNative = "Бабушка приготовила מַעֲמוּל для всех гостей на праздник Рамадана.",
         fillInBlankExclusions = listOf(184422L, 184423L, 184424L, 184425L)),
        WordEntity(
            id = 184422, setId = 1844, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cuisine_l3_specialty_dishes",
            original = "רוּגֶלָךְ", translation = "ругелах (рулетики)",
            transliteration = "ругелах",
            definition = "מַאֲפֶה אַשְׁכְּנַזִּי שֶׁל בָּצֵק מְגֻלְגָּל עִם מִלּוּי שׁוֹקוֹלָד אוֹ סֻכָּר וְקִנָּמוֹן.",
            definitionNative = "Ашкеназская выпечка из закрученного теста с начинкой из шоколада или сахара с корицей.",
            example = "הַמַּאֲפִיָּה בָּרְחוֹב הַזֶּה מְפֻרְסֶמֶת עַל הָרוּגֶלָךְ הַטָּרִי שֶׁלָּהּ.",
            exampleNative = "Пекарня на этой улице знаменита своим свежим רוּגֶלָךְ с шоколадом.",
        ),
        WordEntity(
            id = 184423, setId = 1844, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cuisine_l3_specialty_dishes",
            original = "בָּקְלָאוָוה", translation = "пахлава (восточный десерт)",
            transliteration = "баклава",
            definition = "מַאֲפֶה מִזְרָחִי מִשִּׁכְבוֹת בָּצֵק עָלִים עִם אֱגוֹזִים וְסִירוֹפ דְּבַשׁ אוֹ סֻכָּר.",
            definitionNative = "Восточная выпечка из слоёв тонкого теста с орехами и сиропом из мёда или сахара.",
            example = "בַּחֲנוּת הַתֻּרְכִּית מוֹכְרִים בָּקְלָאוָוה בְּקֻפְסַת זָהָב לְמַתָּנָה.",
            exampleNative = "В турецком магазине продают בָּקְלָאוָוה в золотой коробке как подарок.",
         fillInBlankExclusions = listOf(184421L, 184422L, 184424L, 184425L)),
        WordEntity(
            id = 184424, setId = 1844, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cuisine_l3_specialty_dishes",
            original = "גְּפִילְטֶע פִישׁ", translation = "гефилте фиш (фаршированная рыба)",
            transliteration = "гефилте фиш",
            definition = "מָנָה אַשְׁכְּנַזִּית שֶׁל דָּגִים טְחוּנִים מְבֻשָּׁלִים בִּקְצִיצוֹת אוֹ בְּמִלּוּי לְעוֹר הַדָּג.",
            definitionNative = "Ашкеназское блюдо из молотой рыбы, варёной в виде котлет или начинённой в кожу рыбы.",
            example = "אִמָּא הִכִּירָה לִי גְּפִילְטֶע פִישׁ בַּפַּעַם הָרִאשׁוֹנָה בְּלֵיל פֶּסַח.",
            exampleNative = "Мама познакомила меня с גְּפִילְטֶע פִישׁ впервые в пасхальную ночь.",
        ),
        WordEntity(
            id = 184425, setId = 1844, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cuisine_l3_specialty_dishes",
            original = "מַלָאבִּי", translation = "малаби (молочный десерт)",
            transliteration = "малаби",
            definition = "קִנּוּחַ קַר עַל בָּסִיס חָלָב וְקֹרַח עִם רֹטֶב וֶרֶד וֶאֱגוֹזִים — אֹפְיָנִי לַמִּזְרָח הַתִּיכוֹן.",
            definitionNative = "Холодный десерт на молоке и крахмале с розовым сиропом и орехами — характерен для Ближнего Востока.",
            example = "אַחֲרֵי הַמָּנָה הָעִקָּרִית הִזְמַנּוּ מַלָאבִּי קַר לַשֻּׁלְחָן.",
            exampleNative = "После основного блюда мы заказали холодный מַלָאבִּי к столу.",
         fillInBlankExclusions = listOf(184421L, 184422L, 184423L, 184424L)),
    )
}
