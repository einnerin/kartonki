package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Set 1708: «Наука», уровень 1 (базовая лексика для уроков естествознания).
 *
 * 15 COMMON + 10 UNCOMMON. Базовые слова: лаборатория, прибор, проверка,
 * измерение, факт, формула, число, вещество — то, что школьник встречает
 * на первом уроке физики или химии. Слова намеренно подобраны так, чтобы
 * не пересекаться с другими сетами темы «Наука» (1077, 1095, 1097, 1098,
 * 1100, 1101, 1102, 1105, 1107, 1111, 1117, 1118, 1120, 1208, 1210, 1211,
 * 1250, 1251, 1530, 1544) — пересечения по `original` проверены grep'ом.
 */
object WordDataHebrewScienceL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1708, languagePair = "he-ru", orderIndex = 208,
            name = "Наука",
            description = "Базовая научная лексика: опыт, лаборатория, исследование",
            topic = "Наука", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── 1708: Наука (level 1, COMMON+UNCOMMON) ────────────────────────

        // — science_workers_lab (5): люди и лаборатория —
        WordEntity(
            id = 170801, setId = 1708, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "science_workers_lab", transliteration = "khoker",
            original = "חוֹקֵר", translation = "исследователь / научный сотрудник",
            definition = "אִישׁ שֶׁמְּחַפֵּשׂ תְּשׁוּבוֹת לִשְׁאֵלוֹת בְּעֶזְרַת בְּדִיקוֹת וְקִרִיאָה.",
            definitionNative = "Человек, что ищет ответы на вопросы через проверки и чтение.",
            example = "הַחוֹקֵר עָבַד שְׁנָתַיִם עַל שְׁאֵלָה אַחַת בִּלְבַד.",
            exampleNative = "חוֹקֵר работал два года всего над одним вопросом.",
         fillInBlankExclusions = listOf(170802L, 170803L, 170804L, 170805L)),
        WordEntity(
            id = 170802, setId = 1708, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "science_workers_lab", transliteration = "ozer mekhkar",
            original = "עוֹזֵר מֶחְקָר", translation = "лаборант / научный ассистент",
            definition = "אִישׁ שֶׁעוֹזֵר לְחוֹקֵר בָּכִיר עִם בְּדִיקוֹת וְרִשּׁוּם נְתוּנִים.",
            definitionNative = "Тот, кто помогает старшему специалисту с проверками и записью данных.",
            example = "עוֹזֵר מֶחְקָר רוֹשֵׁם אֶת הַתּוֹצָאוֹת בְּמַחְבֶּרֶת קְטַנָּה.",
            exampleNative = "עוֹזֵר מֶחְקָר записывает результаты в маленькую тетрадь.",
         fillInBlankExclusions = listOf(170801L, 170803L, 170804L, 170805L)),
        WordEntity(
            id = 170803, setId = 1708, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "science_workers_lab", transliteration = "ma'avada",
            original = "מַעְבָּדָה", translation = "лаборатория (помещение)",
            definition = "חֶדֶר עִם שֻׁלְחָנוֹת וּמִכְשִׁירִים שֶׁבּוֹ עוֹשִׂים בְּדִיקוֹת מַדָּעִיּוֹת.",
            definitionNative = "Помещение со столами и приборами, где проводят научные проверки.",
            example = "הַתַּלְמִידִים נִכְנְסוּ לַמַּעְבָּדָה לְשִׁעוּר חֵקֶר רִאשׁוֹן.",
            exampleNative = "Ученики зашли в מַעְבָּדָה на первый урок исследования.",
        ),
        WordEntity(
            id = 170804, setId = 1708, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "science_workers_lab", transliteration = "makhshir",
            original = "מַכְשִׁיר", translation = "прибор / устройство",
            definition = "דָּבָר טֶכְנִי שֶׁבּוֹ מִשְׁתַּמְּשִׁים כְּדֵי לִבְדֹּק אוֹ לִמְדֹּד מַשֶּׁהוּ.",
            definitionNative = "Техническая вещь, которой пользуются, чтобы проверить или измерить нечто.",
            example = "הַמַּכְשִׁיר הֶחָדָשׁ מַרְאֶה אֶת הַטֶּמְפֵּרָטוּרָה בְּדִיּוּק רַב.",
            exampleNative = "Новый מַכְשִׁיר показывает температуру очень точно.",
        ),
        WordEntity(
            id = 170805, setId = 1708, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "science_workers_lab", transliteration = "mavkhena",
            original = "מִבְחֵנָה", translation = "пробирка",
            definition = "צִינּוֹר זְכוּכִית קָטָן וְצַר שֶׁמַּחְזִיק מְעַט נוֹזֵל לִבְדִיקָה.",
            definitionNative = "Маленькая узкая стеклянная трубка, что держит немного жидкости для теста.",
            example = "הַתַּלְמִידָה שָׁפְכָה טִפָּה כְּחֻלָּה לְתוֹךְ הַמִּבְחֵנָה.",
            exampleNative = "Ученица налила синюю каплю в מִבְחֵנָה.",
        ),

        // — science_actions (5): действия в науке —
        WordEntity(
            id = 170806, setId = 1708, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "science_actions", transliteration = "bdika",
            original = "בְּדִיקָה", translation = "проверка / тест",
            definition = "פְּעֻלָּה שֶׁבָּהּ מְבָרְרִים אִם דָּבָר עוֹבֵד אוֹ נָכוֹן.",
            definitionNative = "Действие, в котором выясняют, работает ли нечто или верно ли.",
            example = "אַחֲרֵי הַבְּדִיקָה הָרָאשׁוֹנָה הֵם הִבְחִינוּ בְּטָעוּת קְטַנָּה.",
            exampleNative = "После первой בְּדִיקָה они заметили маленькую ошибку.",
         fillInBlankExclusions = listOf(170807L, 170808L, 170809L, 170810L)),
        WordEntity(
            id = 170807, setId = 1708, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "science_actions", transliteration = "medida",
            original = "מְדִידָה", translation = "измерение",
            definition = "פְּעֻלָּה שֶׁל קְבִיעַת גֹּדֶל אוֹ כַּמּוּת בְּעֶזְרַת מַכְשִׁיר.",
            definitionNative = "Действие определения размера или количества с помощью прибора.",
            example = "הַמְּדִידָה הָרִאשׁוֹנָה לֹא דַּיְקָה וְהֵם חָזְרוּ עָלֶיהָ.",
            exampleNative = "Первая מְדִידָה вышла неточной, и они её повторили.",
        ),
        WordEntity(
            id = 170808, setId = 1708, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "science_actions", transliteration = "tatzpit",
            original = "תַּצְפִּית", translation = "наблюдение (за явлением)",
            definition = "מַעֲקָב מְמֻשָּׁךְ אַחַר תּוֹפָעָה כְּדֵי לִלְמֹד עָלֶיהָ עוֹד.",
            definitionNative = "Длительное слежение за явлением, чтобы узнать о нём больше.",
            example = "הַתַּצְפִּית עַל הַצִּפּוֹר נִמְשְׁכָה כִּשְׁעָתַיִם בַּשַּׁחַר.",
            exampleNative = "תַּצְפִּית за птицей длилось около двух часов на рассвете.",
         fillInBlankExclusions = listOf(170806L, 170807L, 170809L, 170810L)),
        WordEntity(
            id = 170809, setId = 1708, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "science_actions", transliteration = "gilui",
            original = "גִּילּוּי", translation = "обнаружение / находка",
            definition = "מָצָא דָּבָר חָדָשׁ שֶׁעַד עַתָּה לֹא הָיָה יָדוּעַ לְאַף אֶחָד.",
            definitionNative = "Нашёл нечто новое, что до сих пор никому не было известно.",
            example = "הַגִּילּוּי עַל קֶבֶר עַתִּיק הִפְתִּיעַ אֶת כָּל הָאָרֶץ.",
            exampleNative = "גִּילּוּי старой могилы удивило всю страну.",
         fillInBlankExclusions = listOf(170806L, 170807L, 170808L, 170810L)),
        WordEntity(
            id = 170810, setId = 1708, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "science_actions", transliteration = "hashva'a",
            original = "הַשְׁוָאָה", translation = "сравнение",
            definition = "בְּחִינַת שְׁנֵי דְּבָרִים יַחַד לִרְאוֹת בְּמָה הֵם דּוֹמִים אוֹ שׁוֹנִים.",
            definitionNative = "Рассмотрение двух предметов вместе, чтобы увидеть, чем похожи или отличаются.",
            example = "אַחֲרֵי הַשְׁוָאָה בֵּין הַשְּׁנַיִם רָאִינוּ הֶבְדֵּל בָּרוּר.",
            exampleNative = "После הַשְׁוָאָה между двумя мы увидели ясное отличие.",
         fillInBlankExclusions = listOf(170806L, 170807L, 170808L, 170809L)),

        // — science_concepts (5): абстрактные понятия —
        WordEntity(
            id = 170811, setId = 1708, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "science_concepts", transliteration = "uvda",
            original = "עוּבְדָּה", translation = "факт",
            definition = "דָּבָר שֶׁקָּרָה בֶּאֱמֶת וְאֶפְשָׁר לְהוֹכִיחַ בְּעֵדוּת אוֹ מִסְמָךְ.",
            definitionNative = "То, что произошло на самом деле и можно подтвердить свидетельством или документом.",
            example = "זוֹ עוּבְדָּה יְדוּעָה וְאֵין צֹרֶךְ לְוַכֵּחַ עָלֶיהָ.",
            exampleNative = "Это известная עוּבְדָּה, и спорить о ней нет нужды.",
         fillInBlankExclusions = listOf(170812L, 170813L, 170814L, 170815L)),
        WordEntity(
            id = 170812, setId = 1708, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "science_concepts", transliteration = "totza'a",
            original = "תּוֹצָאָה", translation = "результат",
            definition = "מַה שֶּׁיּוֹצֵא בְּסוֹף בְּדִיקָה אוֹ פְּעֻלָּה אֲרֻכָּה.",
            definitionNative = "То, что выходит в конце проверки или долгого действия.",
            example = "הַתּוֹצָאָה שֶׁל הַבְּדִיקָה הָיְתָה שׁוֹנָה מִמַּה שֶּׁחָשַׁבְנוּ.",
            exampleNative = "תּוֹצָאָה теста вышла иной, чем мы думали.",
         fillInBlankExclusions = listOf(170811L, 170813L, 170814L, 170815L)),
        WordEntity(
            id = 170813, setId = 1708, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "science_concepts", transliteration = "hokhakha",
            original = "הוֹכָחָה", translation = "доказательство",
            definition = "דָּבָר שֶׁמַּרְאֶה לָנוּ בְּלִי סָפֵק שֶׁמַּשֶּׁהוּ נָכוֹן.",
            definitionNative = "Нечто, что показывает нам без сомнения, что некое утверждение верно.",
            example = "אֵין לָנוּ עֲדַיִן הוֹכָחָה אֲמִתִּית לָרַעְיוֹן הַזֶּה.",
            exampleNative = "У нас пока нет настоящего הוֹכָחָה для этой идеи.",
         fillInBlankExclusions = listOf(170811L, 170812L, 170814L, 170815L)),
        WordEntity(
            id = 170814, setId = 1708, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "science_concepts", transliteration = "hesber",
            original = "הֶסְבֵּר", translation = "объяснение",
            definition = "מִלִּים פְּשׁוּטוֹת שֶׁמְּסַפְּרוֹת לָמָּה דָּבָר קוֹרֶה אוֹ אֵיךְ הוּא עוֹבֵד.",
            definitionNative = "Простые слова, что рассказывают, почему нечто происходит или как оно работает.",
            example = "הַמּוֹרָה נָתְנָה הֶסְבֵּר קָצָר עַל מָה שֶׁקָּרָה.",
            exampleNative = "Учительница дала короткое הֶסְבֵּר о том, что произошло.",
         fillInBlankExclusions = listOf(170811L, 170812L, 170813L, 170815L)),
        WordEntity(
            id = 170815, setId = 1708, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "science_concepts", transliteration = "maskana",
            original = "מַסְקָנָה", translation = "вывод (после исследования)",
            definition = "מַה שֶּׁאוֹמְרִים בַּסּוֹף אַחֲרֵי שֶׁסִּיְּמוּ אֶת כָּל הַבְּדִיקוֹת.",
            definitionNative = "То, что говорят в конце, после того как закончили все проверки.",
            example = "הַמַּסְקָנָה הָיְתָה שֶׁהַחֹמֶר אֵינוֹ בָּטוּחַ לִילָדִים.",
            exampleNative = "מַסְקָנָה вышла такой: вещество не безопасно для детей.",
        ),

        // — science_numbers (5): числа, формулы, единицы —
        WordEntity(
            id = 170816, setId = 1708, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "science_numbers", transliteration = "mispar",
            original = "מִסְפָּר", translation = "число",
            definition = "סִימָן שֶׁמַּרְאֶה כַּמּוּת אוֹ מָקוֹם בְּסֵדֶר.",
            definitionNative = "Знак, что показывает количество или место в порядке.",
            example = "הוּא רָשַׁם אֶת הַמִּסְפָּר עַל הַלּוּחַ בְּצֶבַע אָדֹם.",
            exampleNative = "Он записал מִסְפָּר на доске красным цветом.",
        ),
        WordEntity(
            id = 170817, setId = 1708, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "science_numbers", transliteration = "akhuz",
            original = "אַחוּז", translation = "процент",
            definition = "חֵלֶק קָטָן מִתּוֹךְ מֵאָה שֶׁמַּרְאֶה כַּמָּה מִשֶּׁהוּ יֵשׁ.",
            definitionNative = "Маленькая часть из ста, что показывает, сколько чего-то имеется.",
            example = "רַק אַחוּז קָטָן שֶׁל הַתַּלְמִידִים עָנָה נְכוֹנָה.",
            exampleNative = "Только маленький אַחוּז учеников ответил верно.",
         fillInBlankExclusions = listOf(170816L, 170818L, 170819L, 170820L)),
        WordEntity(
            id = 170818, setId = 1708, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "science_numbers", transliteration = "nuskha",
            original = "נוּסְחָה", translation = "формула",
            definition = "שׁוּרָה קְצָרָה שֶׁל אוֹתִיּוֹת וְסִימָנִים שֶׁמְּתָאֶרֶת חֹק קָבוּעַ.",
            definitionNative = "Короткая строка букв и знаков, что описывает постоянное правило.",
            example = "הַתַּלְמִיד שִׁנֵּן אֶת הַנּוּסְחָה לִפְנֵי הַמִּבְחָן בְּסוֹף הַשָּׁבוּעַ.",
            exampleNative = "Ученик заучил נוּסְחָה перед экзаменом в конце недели.",
        ),
        WordEntity(
            id = 170819, setId = 1708, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "science_numbers", transliteration = "yekhida",
            original = "יְחִידָה", translation = "единица (измерения)",
            definition = "חֵלֶק קָבוּעַ שֶׁבְּעֶזְרָתוֹ סוֹפְרִים אוֹ מוֹדְדִים — מֶטֶר, גְּרָם, שָׁעָה.",
            definitionNative = "Постоянная часть, которой считают или мерят — метр, грамм, час.",
            example = "הַיְּחִידָה לְמִשְׁקָל בַּמַּעֲרֶכֶת הַזֹּאת הִיא קִילוֹ.",
            exampleNative = "יְחִידָה веса в этой системе — кило.",
        ),
        WordEntity(
            id = 170820, setId = 1708, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "science_numbers", transliteration = "tavla",
            original = "טַבְלָה", translation = "таблица (с данными)",
            definition = "סִידּוּר נְתוּנִים בְּשׁוּרוֹת וְעַמּוּדוֹת לְהַשְׁוָאָה נוֹחָה.",
            definitionNative = "Размещение данных по строкам и столбцам — для удобного сличения.",
            example = "הוּא שָׂם אֶת כָּל הַמִּסְפָּרִים בְּטַבְלָה אַחַת בַּדַּף.",
            exampleNative = "Он поместил все числа в одну טַבְלָה на странице.",
         fillInBlankExclusions = listOf(170816L, 170817L, 170818L, 170819L)),

        // — science_matter (5): вещество и базовые явления —
        WordEntity(
            id = 170821, setId = 1708, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "science_matter", transliteration = "khomer",
            original = "חֹמֶר", translation = "вещество / материал",
            definition = "מַשֶּׁהוּ פִיזִי שֶׁמִּמֶּנּוּ עָשׂוּי דָּבָר — עֵץ, מַתֶּכֶת, פְּלַסְטִיק.",
            definitionNative = "Физическая основа, из которой сделана вещь — дерево, металл, пластик.",
            example = "הַחֹמֶר הַזֶּה קָשֶׁה וְקָשֶׁה לְשׁוֹבְרוֹ בַּיָּד.",
            exampleNative = "Это חֹמֶר твёрдое — рукой не разломать.",
         fillInBlankExclusions = listOf(170822L, 170823L, 170824L, 170825L)),
        WordEntity(
            id = 170822, setId = 1708, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "science_matter", transliteration = "gaz",
            original = "גָּז", translation = "газ",
            definition = "צוּרָה שֶׁל חֹמֶר שֶׁלֹּא רוֹאִים וּמְמַלֵּא אֶת כָּל הַחֶדֶר.",
            definitionNative = "Состояние материи, что не видать глазом и заполняет всю комнату.",
            example = "רֵיחַ הַגָּז הָרָגִישׁ אוֹתָנוּ לִבְרֹחַ מֵהַבַּיִת מִיָּד.",
            exampleNative = "Запах גָּז заставил нас тут же выбежать из дома.",
         fillInBlankExclusions = listOf(170821L, 170823L, 170824L, 170825L)),
        WordEntity(
            id = 170823, setId = 1708, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "science_matter", transliteration = "kli",
            original = "כְּלִי", translation = "инструмент / орудие",
            definition = "דָּבָר שֶׁאוֹחֲזִים בַּיָּד כְּדֵי לַעֲשׂוֹת עֲבוֹדָה — כַּף, פַּטִּישׁ, מַזְלֵג.",
            definitionNative = "Предмет, что держат в руке для работы — ложка, молоток, вилка.",
            example = "הוּא בָּחַר אֶת הַכְּלִי הַנָּכוֹן לִפְנֵי שֶׁהִתְחִיל לַעֲבֹד.",
            exampleNative = "Он подобрал нужный כְּלִי, прежде чем начать работу.",
         fillInBlankExclusions = listOf(170804L, 170821L, 170822L, 170824L, 170825L)),
        WordEntity(
            id = 170824, setId = 1708, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "science_matter", transliteration = "or",
            original = "אוֹר", translation = "свет (физическое явление)",
            definition = "מַה שֶּׁמַּגִּיעַ מֵהַשֶּׁמֶשׁ אוֹ מִנּוּרָה וּמַרְאֶה לָנוּ דְּבָרִים.",
            definitionNative = "То, что идёт от солнца или от лампы и даёт нам видеть предметы.",
            example = "הָאוֹר עָבַר דֶּרֶךְ הַחַלּוֹן וְנָגַע בַּשֻּׁלְחָן.",
            exampleNative = "אוֹר прошёл сквозь окно и коснулся стола.",
         fillInBlankExclusions = listOf(170821L, 170822L, 170823L, 170825L)),
        WordEntity(
            id = 170825, setId = 1708, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "science_matter", transliteration = "nozel",
            original = "נוֹזֵל", translation = "жидкость",
            definition = "צוּרָה שֶׁל חֹמֶר שֶׁזּוֹרֶמֶת וְלוֹקַחַת אֶת צוּרַת הַכְּלִי שֶׁבּוֹ הִיא.",
            definitionNative = "Состояние материи, что течёт и берёт форму сосуда, в котором находится.",
            example = "הוּא שָׁפַךְ אֶת הַנּוֹזֵל הַשָּׁקוּף לְתוֹךְ הַכּוֹס.",
            exampleNative = "Он налил прозрачный נוֹזֵל в стакан.",
        ),
    )
}
