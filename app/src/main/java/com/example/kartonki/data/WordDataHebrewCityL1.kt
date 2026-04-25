package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew City — Level 1 (basic A1 vocabulary).
 *
 * 25 base words a beginner immediately needs to navigate a city: streets,
 * transport, shops, simple landmarks. Pure COMMON + UNCOMMON spread.
 */
object WordDataHebrewCityL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1705, languagePair = "he-ru", orderIndex = 1705,
            name = "Город",
            description = "Базовая городская лексика: улица, магазин, парк",
            topic = "Город",
            level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Set 1705: Город (L1) ───────────────────────────────────────────

        // ── Группа: улицы и пешеходные пути (5) ─────────────────────────
        WordEntity(
            id = 170501, setId = 1705, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "city_streets_walks", transliteration = "rekhov",
            original = "רְחוֹב", translation = "улица",
            definition = "דֶּרֶךְ בָּעִיר עִם בָּתִּים מִשְּׁנֵי הַצְּדָדִים שֶׁבָּהּ הוֹלְכִים וְנוֹסְעִים.",
            definitionNative = "Городская дорога с домами по обе стороны, по которой ходят и ездят.",
            example = "אֲנִי גָּר בָּרְחוֹב הַשֶּׁקֶט הַזֶּה כְּבָר עֶשֶׂר שָׁנִים.",
            exampleNative = "Я живу на этой тихой רְחוֹב уже десять лет.",
         fillInBlankExclusions = listOf(170502L, 170503L, 170518L, 170525L)),
        WordEntity(
            id = 170502, setId = 1705, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "city_streets_walks", transliteration = "tsomet",
            original = "צֹמֶת", translation = "перекрёсток",
            definition = "מָקוֹם שֶׁבּוֹ נִפְגָּשׁוֹת שְׁתֵּי דְּרָכִים אוֹ יוֹתֵר בָּעִיר.",
            definitionNative = "Место, где встречаются две или больше городских дорог.",
            example = "פָּגַשְׁתִּי אֶת חַבְרִי בַּצֹּמֶת הָרָאשִׁי שֶׁל הָעִיר.",
            exampleNative = "Я встретил друга на главном צֹמֶת города.",
        ),
        WordEntity(
            id = 170503, setId = 1705, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "city_streets_walks", transliteration = "midrakha",
            original = "מִדְרָכָה", translation = "тротуар",
            definition = "מָקוֹם צַר לְצַד הַכְּבִישׁ שֶׁבּוֹ הוֹלְכִים אֲנָשִׁים בְּרֶגֶל.",
            definitionNative = "Узкая полоса вдоль дороги, по которой идут пешеходом.",
            example = "הַיְּלָדִים רָצוּ עַל הַמִּדְרָכָה לִקְרַאת הַגַּן.",
            exampleNative = "Дети бежали по מִדְרָכָה в сторону парка.",
        ),
        WordEntity(
            id = 170518, setId = 1705, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "city_streets_walks", transliteration = "ma'avar khatsiya",
            original = "מַעֲבַר חֲצִיָּה", translation = "пешеходный переход",
            definition = "פַּסִּים לְבָנִים עַל הַכְּבִישׁ שֶׁבָּהֶם הוֹלְכִים בְּרֶגֶל מִצַּד אֶל צַד.",
            definitionNative = "Белые полосы на дороге, по которым переходят пешком на другую сторону.",
            example = "חִכִּינוּ בְּסַבְלָנוּת לְפָנָיו וְעָבַרְנוּ בַּמַּעֲבַר חֲצִיָּה.",
            exampleNative = "Мы терпеливо подождали и прошли по מַעֲבַר חֲצִיָּה.",
        ),
        WordEntity(
            id = 170525, setId = 1705, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "city_streets_walks", transliteration = "bulvar",
            original = "בּוּלְוַאר", translation = "бульвар",
            definition = "רְחוֹב רָחָב עִם עֵצִים וְסַפְסָלִים שֶׁבּוֹ נֶחְמָד לְטַיֵּל.",
            definitionNative = "Широкая улица с деревьями и скамейками — приятно гулять.",
            example = "אַחַר הַצָּהֳרַיִם טִיַּלְנוּ בַּבּוּלְוַאר הַיָּפֶה הַזֶּה.",
            exampleNative = "После обеда мы гуляли по этому красивому בּוּלְוַאר.",
         fillInBlankExclusions = listOf(170501L, 170502L, 170503L, 170518L)),

        // ── Группа: городской транспорт (5) ──────────────────────────────
        WordEntity(
            id = 170504, setId = 1705, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "city_transport", transliteration = "otobus",
            original = "אוֹטוֹבּוּס", translation = "автобус",
            definition = "כְּלִי תַּחְבּוּרָה גָּדוֹל שֶׁמַּסִּיעַ הַרְבֵּה אֲנָשִׁים בָּעִיר.",
            definitionNative = "Большой транспорт, который везёт много людей по городу.",
            example = "אֲנִי נוֹסֵעַ בָּאוֹטוֹבּוּס לָעֲבוֹדָה כָּל בֹּקֶר.",
            exampleNative = "Я еду на работу на אוֹטוֹבּוּס каждое утро.",
         fillInBlankExclusions = listOf(170505L, 170506L, 170519L, 170520L)),
        WordEntity(
            id = 170505, setId = 1705, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "city_transport", transliteration = "monit",
            original = "מוֹנִית", translation = "такси",
            definition = "מְכוֹנִית עִם נֶהָג שֶׁאוֹתָהּ מַזְמִינִים תְּמוּרַת תַּשְׁלוּם.",
            definitionNative = "Машина с водителем, которую заказывают за плату.",
            example = "הִזְמַנּוּ מוֹנִית לִתְחָנַת הָרַכֶּבֶת בַּלַּיְלָה.",
            exampleNative = "Мы заказали מוֹנִית до вокзала ночью.",
         fillInBlankExclusions = listOf(170504L, 170506L, 170519L)),
        WordEntity(
            id = 170506, setId = 1705, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "city_transport", transliteration = "ofanayim",
            original = "אוֹפַנַּיִם", translation = "велосипед",
            definition = "כְּלִי רֶכֶב קָטָן עִם שְׁנֵי גַּלְגַּלִּים שֶׁמֵּנִיעִים בְּרַגְלַיִם.",
            definitionNative = "Маленькое средство с двумя колёсами, на котором едут крутя педали ногами.",
            example = "הִיא רוֹכֶבֶת עַל אוֹפַנַּיִם לַעֲבוֹדָה בִּימוֹת הַקַּיִץ.",
            exampleNative = "Летом она ездит на работу на אוֹפַנַּיִם.",
         fillInBlankExclusions = listOf(170504L, 170505L, 170519L, 170520L)),
        WordEntity(
            id = 170519, setId = 1705, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "city_transport", transliteration = "ofanoa",
            original = "אוֹפַנּוֹעַ", translation = "мотоцикл",
            definition = "רֶכֶב קָטָן עִם שְׁנֵי גַּלְגַּלִּים וּמָנוֹעַ חָזָק לַנְּסִיעוֹת מְהִירוֹת.",
            definitionNative = "Маленький транспорт на двух колёсах с мощным мотором — для быстрой езды.",
            example = "הוּא קָנָה אוֹפַנּוֹעַ אָדֹם וְנוֹסֵעַ בּוֹ לָעִיר.",
            exampleNative = "Он купил красный אוֹפַנּוֹעַ и ездит на нём в город.",
        ),
        WordEntity(
            id = 170520, setId = 1705, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "city_transport", transliteration = "rakevet",
            original = "רַכֶּבֶת", translation = "поезд",
            definition = "תַּחְבּוּרָה גְּדוֹלָה עַל פַּסִּים שֶׁעוֹבֶרֶת בֵּין עָרִים בִּמְהִירוּת.",
            definitionNative = "Большой транспорт на рельсах, что быстро ходит между городами.",
            example = "עָלִינוּ עַל הָרַכֶּבֶת שֶׁל הַשָּׁעָה שֶׁבַע בַּבֹּקֶר.",
            exampleNative = "Мы сели на רַכֶּבֶת на семь часов утра.",
         fillInBlankExclusions = listOf(170504L, 170505L, 170506L, 170519L)),

        // ── Группа: дороги и точки сообщения (3) ─────────────────────────
        WordEntity(
            id = 170507, setId = 1705, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "city_roads", transliteration = "kvish",
            original = "כְּבִישׁ", translation = "дорога",
            definition = "נְתִיב מְזוּפָּת שֶׁעָלָיו נוֹסְעוֹת מְכוֹנִיּוֹת וְאוֹטוֹבּוּסִים.",
            definitionNative = "Асфальтированный путь, по которому ездят машины и автобусы.",
            example = "הָיָה גֶּשֶׁם חָזָק וְהַכְּבִישׁ הָיָה רָטוֹב מְאוֹד.",
            exampleNative = "Был сильный дождь, и כְּבִישׁ был совсем мокрый.",
        ),
        WordEntity(
            id = 170508, setId = 1705, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "city_roads", transliteration = "gesher",
            original = "גֶּשֶׁר", translation = "мост",
            definition = "מִבְנֶה שֶׁמְּחַבֵּר שְׁנֵי צְדָדִים מֵעַל נָהָר אוֹ כְּבִישׁ.",
            definitionNative = "Сооружение, что соединяет два берега над рекой или дорогой.",
            example = "הַגֶּשֶׁר הַחָדָשׁ נִפְתַּח לִנְסִיעָה רַק בְּשָׁבוּעַ שֶׁעָבַר.",
            exampleNative = "Новый גֶּשֶׁר открылся для движения только на прошлой неделе.",
         fillInBlankExclusions = listOf(170507L, 170509L)),
        WordEntity(
            id = 170509, setId = 1705, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "city_roads", transliteration = "takhana",
            original = "תַּחֲנָה", translation = "остановка",
            definition = "מָקוֹם בָּרְחוֹב שֶׁבּוֹ עוֹצֵר אוֹטוֹבּוּס וְאֲנָשִׁים עוֹלִים אוֹ יוֹרְדִים.",
            definitionNative = "Место на улице, где останавливается автобус и люди заходят или выходят.",
            example = "חִכִּיתִי בַּתַּחֲנָה רְבַע שָׁעָה עַד שֶׁבָּא הַקַּו.",
            exampleNative = "Я ждал на תַּחֲנָה пятнадцать минут, пока пришёл маршрут.",
         fillInBlankExclusions = listOf(170507L, 170508L)),

        // ── Группа: магазины и общепит (4) ───────────────────────────────
        WordEntity(
            id = 170510, setId = 1705, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "city_shops", transliteration = "khanut",
            original = "חֲנוּת", translation = "магазин",
            definition = "מָקוֹם קָטָן שֶׁבּוֹ קוֹנִים מוּצָרִים תְּמוּרַת כֶּסֶף.",
            definitionNative = "Небольшое заведение, где покупают товары за деньги.",
            example = "נִכְנַסְתִּי לַחֲנוּת לִקְנוֹת לֶחֶם וְחָלָב טָרִי.",
            exampleNative = "Я зашёл в חֲנוּת купить хлеб и свежее молоко.",
         fillInBlankExclusions = listOf(170511L, 170512L, 170513L)),
        WordEntity(
            id = 170511, setId = 1705, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "city_shops", transliteration = "beit mirkakhat",
            original = "בֵּית מִרְקָחַת", translation = "аптека",
            definition = "מָקוֹם בָּעִיר שֶׁבּוֹ קוֹנִים תְּרוּפוֹת לְפִי מִרְשָׁם הָרוֹפֵא.",
            definitionNative = "Заведение в городе, где покупают лекарства по рецепту врача.",
            example = "הָלַכְתִּי לַבֵּית מִרְקָחַת לְקַבֵּל אֶת הַתְּרוּפָה שֶׁל סָבָתִי.",
            exampleNative = "Я пошёл в בֵּית מִרְקָחַת получить лекарство для бабушки.",
         fillInBlankExclusions = listOf(170510L, 170512L, 170513L)),
        WordEntity(
            id = 170512, setId = 1705, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "city_shops", transliteration = "shuk",
            original = "שׁוּק", translation = "рынок",
            definition = "מָקוֹם פָּתוּחַ עִם הַרְבֵּה דּוּכָנִים לְמִכְרֵי יְרָקוֹת וּפֵרוֹת.",
            definitionNative = "Открытое место с прилавками, где продают овощи и фрукты.",
            example = "אִמָּא קוֹנָה יְרָקוֹת בַּשּׁוּק כָּל יוֹם שִׁשִּׁי בַּבֹּקֶר.",
            exampleNative = "Мама покупает овощи на שׁוּק каждую пятницу утром.",
        ),
        WordEntity(
            id = 170513, setId = 1705, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "city_shops", transliteration = "mis'ada",
            original = "מִסְעָדָה", translation = "ресторан",
            definition = "מָקוֹם בָּעִיר שֶׁבּוֹ אוֹכְלִים אֲרוּחָה מוּכָנָה וּמְשַׁלְּמִים.",
            definitionNative = "Заведение в городе, где едят готовое блюдо и платят за него.",
            example = "חָגַגְנוּ אֶת יוֹם הַהוּלֶּדֶת בַּמִּסְעָדָה הָאִיטַלְקִית.",
            exampleNative = "Мы отметили день рождения в итальянской מִסְעָדָה.",
        ),

        // ── Группа: общественные здания (4) ──────────────────────────────
        WordEntity(
            id = 170514, setId = 1705, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "city_buildings", transliteration = "binyan",
            original = "בִּנְיָן", translation = "здание",
            definition = "מִבְנֶה גָּבוֹהַּ עִם קוֹמוֹת וַחֲדָרִים שֶׁבּוֹ גָּרִים אוֹ עוֹבְדִים.",
            definitionNative = "Высокое сооружение с этажами и комнатами — там живут или работают.",
            example = "הַבִּנְיָן הַזֶּה הוּקַם לִפְנֵי חֲמִישִׁים שָׁנָה בִּדְיוּק.",
            exampleNative = "Этот בִּנְיָן построили ровно пятьдесят лет назад.",
         fillInBlankExclusions = listOf(170521L, 170522L, 170523L)),
        WordEntity(
            id = 170521, setId = 1705, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "city_buildings", transliteration = "moadon",
            original = "מוֹעֲדוֹן", translation = "клуб",
            definition = "מָקוֹם שֶׁבּוֹ אֲנָשִׁים נִפְגָּשִׁים לְשֵׁם בִּלּוּי, רִקּוּד אוֹ הַרְצָאָה.",
            definitionNative = "Место, где люди встречаются для отдыха, танцев или лекции.",
            example = "צְעִירִים מְבַלִּים בְּמוֹעֲדוֹן הַלַּיְלָה עַד הַבֹּקֶר.",
            exampleNative = "Молодёжь развлекается в ночном מוֹעֲדוֹן до утра.",
         fillInBlankExclusions = listOf(170514L, 170522L, 170523L)),
        WordEntity(
            id = 170522, setId = 1705, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "city_buildings", transliteration = "knesiya",
            original = "כְּנֵסִיָּה", translation = "церковь",
            definition = "בִּנְיָן דָּתִי שֶׁבּוֹ נוֹצְרִים מִתְפַּלְלִים וּמַקְשִׁיבִים לִדְרָשָׁה.",
            definitionNative = "Религиозное здание, где христиане молятся и слушают проповедь.",
            example = "הַכְּנֵסִיָּה הָעַתִּיקָה נִמְצֵאת בְּלֵב הָעִיר הָעַתִּיקָה.",
            exampleNative = "Старая כְּנֵסִיָּה находится в самом центре старого города.",
         fillInBlankExclusions = listOf(170514L, 170521L, 170523L)),
        WordEntity(
            id = 170523, setId = 1705, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "city_buildings", transliteration = "snif",
            original = "סְנִיף", translation = "отделение",
            definition = "סָנִיף קָטָן שֶׁל בַּנְק אוֹ דֹּאַר בְּשְׁכוּנָה אוֹ בָּרְחוֹב.",
            definitionNative = "Маленькая контора банка или почты в районе или на улице.",
            example = "פָּתַחְתִּי חֶשְׁבּוֹן בַּסְּנִיף הַחָדָשׁ קָרוֹב לַבַּיִת שֶׁלִּי.",
            exampleNative = "Я открыл счёт в новом סְנִיף рядом со своим домом.",
        ),

        // ── Группа: уличные объекты (4) ──────────────────────────────────
        WordEntity(
            id = 170515, setId = 1705, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "city_outdoor_objects", transliteration = "safsal",
            original = "סַפְסָל", translation = "скамейка",
            definition = "מוֹשָׁב אָרוֹךְ עָשׂוּי עֵץ אוֹ מַתֶּכֶת לִישִׁיבָה בָּרְחוֹב.",
            definitionNative = "Длинное сиденье из дерева или металла — посидеть на улице.",
            example = "הַזּוּג הַזָּקֵן יָשַׁב עַל הַסַּפְסָל לְיַד הַמִּזְרָקָה.",
            exampleNative = "Пожилая пара сидела на סַפְסָל рядом с фонтаном.",
        ),
        WordEntity(
            id = 170516, setId = 1705, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "city_outdoor_objects", transliteration = "shelet",
            original = "שֶׁלֶט", translation = "знак",
            definition = "לוּחַ קָטָן עִם מִלִּים אוֹ צוּרוֹת שֶׁמַּסְבִּיר אוֹ מַזְהִיר בָּרְחוֹב.",
            definitionNative = "Небольшая табличка со словами или рисунком — что-то поясняет на улице.",
            example = "הַשֶּׁלֶט הָאָדֹם הוֹדִיעַ שֶׁאָסוּר לַעֲצֹר שָׁם.",
            exampleNative = "Красный שֶׁלֶט сообщал, что там нельзя останавливаться.",
        ),
        WordEntity(
            id = 170517, setId = 1705, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "city_outdoor_objects", transliteration = "pakh",
            original = "פַּח", translation = "мусорный бак",
            definition = "כְּלִי גָּדוֹל בָּרְחוֹב שֶׁאֵלָיו זוֹרְקִים לִכְלוּךְ וְאַשְׁפָּה.",
            definitionNative = "Большой контейнер на улице, куда выкидывают грязь и мусор.",
            example = "זָרַקְתִּי אֶת הַבַּקְבּוּק הָרֵיק לַפַּח שֶׁל מִחְזּוּר.",
            exampleNative = "Я выкинул пустую бутылку в פַּח для переработки.",
         fillInBlankExclusions = listOf(170515L, 170516L, 170524L)),
        WordEntity(
            id = 170524, setId = 1705, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "city_outdoor_objects", transliteration = "mazraka",
            original = "מַזְרָקָה", translation = "фонтан",
            definition = "מִתְקָן שֶׁבּוֹ מַיִם קוֹפְצִים לַאֲוִיר לְקִשּׁוּט הַכִּכָּר.",
            definitionNative = "Сооружение, где вода взлетает струями вверх — украшает площадь.",
            example = "יְלָדִים שִׂחֲקוּ לְיַד הַמַּזְרָקָה בַּכִּכָּר הַמֶּרְכָּזִית.",
            exampleNative = "Дети играли возле מַזְרָקָה на центральной площади.",
        ),
    )
}
