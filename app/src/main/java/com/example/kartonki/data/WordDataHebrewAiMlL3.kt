package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "AI и ML", L3 «Углублённый» (RARE+EPIC).
 *
 * Set 1755: «AI и ML» — углублённый L3:
 *           Основы машинного обучения: модели, датасеты, обучение, инференс,
 *           нейросети + работа с данными + процесс обучения + типы моделей +
 *           вычислительная инфраструктура (GPU/TPU/CUDA).
 *
 * Тема ориентирована на разработчика/data-scientist'а, который изучает иврит для
 * работы в израильском хайтеке (AI21, Run:ai, Lightricks, NICE и т.д.). Лексика
 * отражает реальную речь в офисах: сплошные английские заимствования
 * (אִינְפֶרֶנְס, פִיצֶ׳ר, אִיפּוֹק, אוֹפְּטִימָייזֶר, אֶמְבֶּדִינְג, טְרַנְסְפוֹרְמֶר) — так
 * реально говорят инженеры в ML-командах.
 *
 * Распределение редкостей: 13 RARE + 12 EPIC (L3 = специальная ML-лексика).
 *
 * SemanticGroups (5 × 5):
 *   aiml_basics    — базовые понятия: модель, датасет, обучение, инференс, нейросеть
 *   aiml_data      — работа с данными: фича, нормализация, разметка, очистка, аугментация
 *   aiml_training  — процесс обучения: эпоха, гиперпараметр, loss, оптимизатор, валидация
 *   aiml_models    — типы моделей: классификация, регрессия, кластеризация, transformer, embedding
 *   aiml_compute   — вычисления: GPU, TPU, CUDA, vRAM, размер батча
 *
 * Word IDs: setId × 100 + position (175501..175525).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewAiMlL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1755, languagePair = "he-ru", orderIndex = 1755,
            name = "AI и ML",
            description = "Основы машинного обучения: модели, датасеты, обучение, инференс",
            topic = "AI и ML", level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1755 — AI и ML: углублённый (L3, RARE+EPIC)
        // 5 групп × 5 слов: basics, data, training, models, compute
        // ══════════════════════════════════════════════════════════════════════

        // ── aiml_basics (5) — базовые понятия ──
        WordEntity(
            id = 175501, setId = 1755, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_basics", transliteration = "model",
            original = "מוֹדֵל", translation = "модель",
            definition = "תּוֹכְנָה שֶׁלָּמְדָה דְּפוּסִים מִתּוֹךְ נְתוּנִים וְעַכְשָׁו יוֹדַעַת לְנַחֵשׁ תְּשׁוּבוֹת.",
            definitionNative = "Программа, выучившая закономерности из данных и теперь умеющая давать прогнозы.",
            example = "הַמוֹדֵל הֶחָדָשׁ מְזַהֶה חֲתוּלִים בִּתְמוּנוֹת בְּדִיּוּק שֶׁל 97%.",
            exampleNative = "Новый מוֹדֵל распознаёт котов на фото с точностью 97%.",
         fillInBlankExclusions = listOf(175502L, 175503L, 175504L, 175505L)),
        WordEntity(
            id = 175502, setId = 1755, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_basics", transliteration = "datas-et",
            original = "דַּאטָסֶט", translation = "датасет",
            definition = "אֹסֶף מְסֻדָּר שֶׁל דֻּגְמָאוֹת — תְּמוּנוֹת, טֶקְסְטִים אוֹ מְסַפְרִים — שֶׁעַל בְּסִיסוֹ לוֹמְדִים.",
            definitionNative = "Упорядоченный набор примеров — картинок, текстов или чисел — на котором учатся.",
            example = "הַחֻקֵר אָסַף דַּאטָסֶט שֶׁל מִילְיוֹן צִילוּמֵי רֶנְטְגֶן מִשְׁלוֹשָׁה בָּתֵי חוֹלִים.",
            exampleNative = "Исследователь собрал דַּאטָסֶט из миллиона рентген-снимков из трёх больниц.",
         fillInBlankExclusions = listOf(175501L, 175503L, 175504L, 175505L)),
        WordEntity(
            id = 175503, setId = 1755, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_basics", transliteration = "imun",
            original = "אִימוּן", translation = "обучение модели",
            definition = "הַתַּהֲלִיךְ שֶׁבּוֹ הַתּוֹכְנָה לוֹמֶדֶת מִתּוֹךְ דֻּגְמָאוֹת וּמְשַׁפֶּרֶת אֶת עַצְמָהּ בְּהַדְרָגָה.",
            definitionNative = "Процесс, в котором программа учится на примерах и постепенно улучшает себя.",
            example = "הָאִימוּן רָץ שְׁלוֹשָׁה יָמִים עַל שְׁמוֹנֶה כַּרְטִיסֵי מָסַךְ חֲזָקִים.",
            exampleNative = "אִימוּן шёл три дня на восьми мощных видеокартах.",
         fillInBlankExclusions = listOf(175501L, 175502L, 175504L, 175505L)),
        WordEntity(
            id = 175504, setId = 1755, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_basics", transliteration = "inferens",
            original = "אִינְפֶרֶנְס", translation = "инференс",
            definition = "הַשִּׁמּוּשׁ הַחַי בַּתּוֹכְנָה אַחֲרֵי שֶׁכְּבָר לָמְדָה — מַזִּינִים שְׁאֵלָה וּמְקַבְּלִים תְּשׁוּבָה.",
            definitionNative = "Живое использование уже выученной программы — подаём вопрос, получаем ответ.",
            example = "אִינְפֶרֶנְס מָהִיר חָשׁוּב בִּשְׁבִיל הַצָּ׳אט-בּוֹט שֶׁעוֹנֶה בִּזְמַן אֲמִת.",
            exampleNative = "Быстрый אִינְפֶרֶנְס важен для чат-бота, отвечающего в реальном времени.",
         fillInBlankExclusions = listOf(175501L, 175502L, 175503L, 175505L)),
        WordEntity(
            id = 175505, setId = 1755, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_basics", transliteration = "reshet neyronim",
            original = "רֶשֶׁת נֵירוֹנִים", translation = "нейросеть",
            definition = "מִבְנֶה שֶׁל יְחִידוֹת חִישּׁוּב מְקֻשָּׁרוֹת בְּשִׁכְבוֹת — חִקּוּי גַּס שֶׁל הַמּוֹחַ.",
            definitionNative = "Структура из связанных вычислительных ячеек в слоях — грубая имитация мозга.",
            example = "רֶשֶׁת נֵירוֹנִים עֲמֻקָּה מְזַהָה רַעַשׁ חָשׁוּד בְּהַקְלָטוֹת שֶׁל מָנוֹעִים.",
            exampleNative = "Глубокая רֶשֶׁת נֵירוֹנִים распознаёт подозрительный шум в записях двигателей.",
         fillInBlankExclusions = listOf(175501L, 175502L, 175503L, 175504L)),

        // ── aiml_data (5) — работа с данными ──
        WordEntity(
            id = 175506, setId = 1755, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_data", transliteration = "ficher",
            original = "פִיצֶ׳ר", translation = "фича",
            definition = "מְאַפְיֵן בּוֹדֵד שֶׁל דֻּגְמָה — לְדֻגְמָה גִּיל, גֹּבַהּ אוֹ צֶבַע פִּיקְסֵל.",
            definitionNative = "Отдельная характеристика примера — например, возраст, рост или цвет пикселя.",
            example = "הוֹסַפְנוּ פִיצֶ׳ר חָדָשׁ עַל מְשֵׁךְ הַסֶּשֶׁן וְהַדִּיּוּק עָלָה בְּאַרְבָּעָה אֲחוּזִים.",
            exampleNative = "Мы добавили новую פִיצֶ׳ר длительности сессии — точность выросла на 4%.",
         fillInBlankExclusions = listOf(175507L, 175508L, 175509L, 175510L)),
        WordEntity(
            id = 175507, setId = 1755, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_data", transliteration = "normalizatsya",
            original = "נוֹרְמָלִיזַצְיָה", translation = "нормализация",
            definition = "הַעֲבָרַת מְסַפְרִים לְטוָוח אֶחָד — לְמָשָׁל בֵּין אֶפֶס לְאֶחָד — כְּדֵי שֶׁהַלְּמִידָה תְּהֵא יַצִּיבָה.",
            definitionNative = "Перевод чисел в один диапазон — например, от нуля до единицы — для устойчивого обучения.",
            example = "בְּלִי נוֹרְמָלִיזַצְיָה הַמּוֹדֵל הִתְמַקֵּד רַק בְּשָׂדוֹת עִם עֶרְכֵי גָּדוֹלִים.",
            exampleNative = "Без נוֹרְמָלִיזַצְיָה модель смотрела только на поля с большими значениями.",
         fillInBlankExclusions = listOf(175506L, 175508L, 175509L, 175510L)),
        WordEntity(
            id = 175508, setId = 1755, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_data", transliteration = "tiyug",
            original = "תִּיוּג", translation = "разметка данных",
            definition = "הַדְבָּקַת תְּשׁוּבָה נְכוֹנָה לְכָל דֻּגְמָה — עַל מָה רוֹאִים בִּתְמוּנָה אוֹ בַּטֶּקְסְט.",
            definitionNative = "Назначение правильного ответа каждому примеру — что на картинке или в тексте.",
            example = "הַתִּיוּג שֶׁל מִילְיוֹן תְּמוּנוֹת רְפוּאִיּוֹת לָקַח לַצֶּוֶות חֲצִי שָׁנָה.",
            exampleNative = "תִּיוּג миллиона медицинских снимков занял у команды полгода.",
         fillInBlankExclusions = listOf(175506L, 175507L, 175509L, 175510L)),
        WordEntity(
            id = 175509, setId = 1755, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_data", transliteration = "nikuy data",
            original = "נִיקוּי דָּאטָה", translation = "очистка данных",
            definition = "סִלּוּק שׁוּרוֹת רֵיקוֹת, כְּפוּלוֹת אוֹ מֻטְעוֹת לִפְנֵי שֶׁמַּתְחִילִים לִלְמֹד מֵהַטַּבְלָה.",
            definitionNative = "Удаление пустых, дубликатных или ошибочных строк перед началом учёбы по таблице.",
            example = "אַחֲרֵי נִיקוּי דָּאטָה הַמּוֹדֵל הִפְסִיק לְהַחְזִיר תַּאֲרִיכִים מֵהַשָּׁנָה 1900.",
            exampleNative = "После נִיקוּי דָּאטָה модель перестала возвращать даты из 1900 года.",
         fillInBlankExclusions = listOf(175506L, 175507L, 175508L, 175510L)),
        WordEntity(
            id = 175510, setId = 1755, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_data", transliteration = "ogmentatsya",
            original = "אוֹגְמֶנְטַצְיָה", translation = "аугментация",
            definition = "יְצִירַת גַּרְסָאוֹת שׁוֹנוֹת שֶׁל אוֹתָהּ דֻּגְמָה — סִיבוּב, חִתּוּךְ אוֹ הוֹסָפַת רַעַשׁ — לִגְדִילַת הַסֵּט.",
            definitionNative = "Создание разных вариантов одного примера — поворот, обрезка или шум — для расширения сета.",
            example = "אוֹגְמֶנְטַצְיָה שֶׁל תְּמוּנוֹת עָזְרָה לָנוּ לְהַכְפִּיל אֶת גֹּדֶל הַדַּאטָסֶט.",
            exampleNative = "אוֹגְמֶנְטַצְיָה картинок помогла нам удвоить размер датасета.",
         fillInBlankExclusions = listOf(175506L, 175507L, 175508L, 175509L)),

        // ── aiml_training (5) — процесс обучения ──
        WordEntity(
            id = 175511, setId = 1755, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_training", transliteration = "ipok",
            original = "אִיפּוֹק", translation = "эпоха",
            definition = "מַעֲבָר מָלֵא אֶחָד עַל כָּל הַדֻּגְמָאוֹת בִּזְמַן הַלְּמִידָה — בְּדֶרֶךְ כְּלָל עוֹשִׂים עַשְׂרוֹת.",
            definitionNative = "Один полный проход по всем примерам во время учёбы — обычно делают десятки.",
            example = "אַחֲרֵי שְׁלוֹשִׁים אִיפּוֹק הַטָּעוּת הִפְסִיקָה לָרֶדֶת וְעָצַרְנוּ אֶת הָרִיצָה.",
            exampleNative = "После тридцати אִיפּוֹק ошибка перестала падать — и мы остановили прогон.",
         fillInBlankExclusions = listOf(175512L, 175513L, 175514L, 175515L)),
        WordEntity(
            id = 175512, setId = 1755, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_training", transliteration = "hiper-parametr",
            original = "הִיפֶּר־פָּרָמֶטֶר", translation = "гиперпараметр",
            definition = "הַגְדָּרָה שֶׁבּוֹחֲרִים יָדַנִּית לִפְנֵי הָרִיצָה — קֶצֶב לְמִידָה, מִסְפַּר שִׁכְבוֹת וְכוֹ׳.",
            definitionNative = "Настройка, выбираемая руками до прогона, — скорость учёбы, число слоёв и т.д.",
            example = "מָצָאנוּ הִיפֶּר־פָּרָמֶטֶר טוֹב יוֹתֵר אַחֲרֵי שִׁשִּׁים נִסּוּיִים בַּגְּרִיד.",
            exampleNative = "Мы нашли лучший הִיפֶּר־פָּרָמֶטֶר после шестидесяти проб в гриде.",
         fillInBlankExclusions = listOf(175511L, 175513L, 175514L, 175515L)),
        WordEntity(
            id = 175513, setId = 1755, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_training", transliteration = "funktsyat los",
            original = "פוּנְקְצְיַית לוֹס", translation = "функция потерь",
            definition = "מְסַפֵּר שֶׁמַּרְאֶה כַּמָּה הַתְּשׁוּבָה הָיְתָה רְחוֹקָה מֵהַנְּכוֹנָה — צָרִיךְ לְהוֹרִיד אוֹתוֹ.",
            definitionNative = "Число, показывающее, насколько ответ был далёк от правильного — нужно его понижать.",
            example = "פוּנְקְצְיַית לוֹס מַתְאִימָה לִמְשִׁימָה קוֹבַעַת הַרְבֵּה אֶת הַתּוֹצָאָה.",
            exampleNative = "Подходящая פוּנְקְצְיַית לוֹס сильно определяет итоговый результат.",
         fillInBlankExclusions = listOf(175511L, 175512L, 175514L, 175515L)),
        WordEntity(
            id = 175514, setId = 1755, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_training", transliteration = "optimayzer",
            original = "אוֹפְּטִימָייזֶר", translation = "оптимизатор",
            definition = "אַלְגוֹרִיתְם שֶׁמְּעַדְכֵּן אֶת מִשְׁקְלֵי הַמּוֹדֵל בְּכָל צַעַד כְּדֵי לְהוֹרִיד אֶת הַטָּעוּת.",
            definitionNative = "Алгоритм, обновляющий веса модели на каждом шаге — чтобы понизить ошибку.",
            example = "אוֹפְּטִימָייזֶר מוֹדֶרְנִי כְּמוֹ Adam מַתְכַּוֵּן אֶת קֶצֶב הַלְּמִידָה לְבַד.",
            exampleNative = "Современный אוֹפְּטִימָייזֶר типа Adam сам подстраивает скорость учёбы.",
         fillInBlankExclusions = listOf(175511L, 175512L, 175513L, 175515L)),
        WordEntity(
            id = 175515, setId = 1755, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_training", transliteration = "validatsya",
            original = "וַלִידַצְיָה", translation = "валидация",
            definition = "בְּדִיקָה עַל סֵט נִפְרָד שֶׁלֹּא הוֹפִיעַ בָּאִימוּן — כְּדֵי לִרְאוֹת אִם הַמּוֹדֵל בֶּאֱמֶת לָמַד.",
            definitionNative = "Проверка на отдельном сете, не виданном в учёбе, — чтобы понять, выучил ли модель по-настоящему.",
            example = "צִיוּן הַוַלִידַצְיָה הָיָה גָּבוֹהַּ אֲבָל בִּפְרוֹדַקְשֶׁן הַתּוֹצָאוֹת אַכְזְבוּ.",
            exampleNative = "Балл וַלִידַצְיָה был высокий, но в проде результаты разочаровали.",
         fillInBlankExclusions = listOf(175511L, 175512L, 175513L, 175514L)),

        // ── aiml_models (5) — типы моделей ──
        WordEntity(
            id = 175516, setId = 1755, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_models", transliteration = "klasifikatsya",
            original = "קְלַסִיפִיקַצְיָה", translation = "классификация",
            definition = "מְשִׂימָה שֶׁבָּהּ צָרִיךְ לְשַׁיֵּךְ דֻּגְמָה לְאַחַת מִכַּמָּה קַטֵגוֹרְיוֹת קְבוּעוֹת מֵרֹאשׁ.",
            definitionNative = "Задача — отнести пример к одной из нескольких заранее заданных категорий.",
            example = "קְלַסִיפִיקַצְיָה שֶׁל אִי-מֵיילִים לְסְפַּאם וְלֹא-סְפַּאם הִיא דֻּגְמָה קְלָאסִית.",
            exampleNative = "קְלַסִיפִיקַצְיָה писем на спам и не-спам — классический пример.",
         fillInBlankExclusions = listOf(175517L, 175518L, 175519L, 175520L)),
        WordEntity(
            id = 175517, setId = 1755, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_models", transliteration = "regresya",
            original = "רֶגְרֶסְיָה", translation = "регрессия",
            definition = "מְשִׂימָה שֶׁבָּהּ הַמּוֹדֵל מְנַחֵשׁ מְסַפֵּר רָצִיף — מְחִיר, גִּיל אוֹ טֶמְפֵּרָטוּרָה.",
            definitionNative = "Задача — модель прогнозирует непрерывное число: цену, возраст или температуру.",
            example = "מוֹדֵל שֶׁל רֶגְרֶסְיָה צוֹפֶה אֶת מְחִיר הַדִּירָה לְפִי גֹּדֶל וְאֵזוֹר.",
            exampleNative = "Модель רֶגְרֶסְיָה прогнозирует цену квартиры по площади и району.",
         fillInBlankExclusions = listOf(175516L, 175518L, 175519L, 175520L)),
        WordEntity(
            id = 175518, setId = 1755, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_models", transliteration = "klastering",
            original = "קְלַסְטֶרִינְג", translation = "кластеризация",
            definition = "חֲלוּקָה שֶׁל דֻּגְמָאוֹת לְקַבּוּצוֹת דּוֹמוֹת בְּלִי שֶׁאָמְרוּ לַמּוֹדֵל מָה הַתְּשׁוּבָה הַנְּכוֹנָה.",
            definitionNative = "Деление примеров на похожие группы — без подсказки модели, какой ответ правильный.",
            example = "קְלַסְטֶרִינְג שֶׁל לָקוֹחוֹת חָשַׂף שָׁלוֹשׁ קַבּוּצוֹת קְנִיָּה שׁוֹנוֹת לְגַמְרֵי.",
            exampleNative = "קְלַסְטֶרִינְג клиентов выявил три совершенно разные покупательские группы.",
         fillInBlankExclusions = listOf(175516L, 175517L, 175519L, 175520L)),
        WordEntity(
            id = 175519, setId = 1755, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_models", transliteration = "transformer",
            original = "טְרַנְסְפוֹרְמֶר", translation = "трансформер",
            definition = "אַרְכִיטֶקְטוּרָה שֶׁל רֶשֶׁת שֶׁעוֹמֶדֶת מֵאֲחוֹרֵי רֹב הַמּוֹדֵלִים הַלְּשׁוֹנִיִּים הַגְּדוֹלִים הַיּוֹם.",
            definitionNative = "Архитектура сети, стоящая за большинством больших языковых моделей сегодня.",
            example = "טְרַנְסְפוֹרְמֶר חוֹלֵל מַהְפֵּכָה בְּתִרְגּוּם אוֹטוֹמָטִי וּבַצָּ׳אט-בּוֹטִים.",
            exampleNative = "טְרַנְסְפוֹרְמֶר совершил революцию в автоматическом переводе и чат-ботах.",
         fillInBlankExclusions = listOf(175516L, 175517L, 175518L, 175520L)),
        WordEntity(
            id = 175520, setId = 1755, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_models", transliteration = "embeding",
            original = "אֶמְבֶּדִינְג", translation = "эмбеддинг",
            definition = "הַצָּגָה שֶׁל מִלָּה אוֹ דֻּגְמָה בְּתוֹר רְשִׁימַת מְסַפְרִים — קְרוֹבִים בִּמְשָׁעוּת = קְרוֹבִים בִּמֶּרְחָב.",
            definitionNative = "Представление слова или примера списком чисел — близкие по смыслу = близкие в пространстве.",
            example = "אֶמְבֶּדִינְג שֶׁל הַמִּלִּים מְאַפְשֵׁר חִפּוּשׂ סֶמַנְטִי בְּמָסַד הַיְּדָע.",
            exampleNative = "אֶמְבֶּדִינְג слов позволяет делать семантический поиск в базе знаний.",
         fillInBlankExclusions = listOf(175516L, 175517L, 175518L, 175519L)),

        // ── aiml_compute (5) — вычислительная инфраструктура ──
        WordEntity(
            id = 175521, setId = 1755, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_compute", transliteration = "dzhi-pi-yu",
            original = "GPU", translation = "GPU",
            definition = "כַּרְטִיס מַאֲרֵץ שֶׁמְּחַשֵּׁב מִילְיוֹנֵי פְּעֻלּוֹת מַטְרִיצָה בְּמַקְבִּיל — לֵב הַלְּמִידָה הָעֲמֻקָּה.",
            definitionNative = "Ускорительная карта, считающая миллионы матричных операций параллельно — сердце глубокого обучения.",
            example = "GPU חָדָשׁ מִ-NVIDIA הוֹרִיד אֶת זְמַן הָאִימוּן מִשְּׁבוּעַ לְיוֹמַיִם.",
            exampleNative = "Новый GPU от NVIDIA снизил время обучения с недели до двух дней.",
         fillInBlankExclusions = listOf(175522L, 175523L, 175524L, 175525L)),
        WordEntity(
            id = 175522, setId = 1755, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_compute", transliteration = "ti-pi-yu",
            original = "TPU", translation = "TPU",
            definition = "שְׁבָב מְיֻחָד שֶׁל גוּגֶל לִתְּהָלִיכֵי לְמִידָה — מְהִיר מְאוֹד אֲבָל זָמִין רַק בָּעָנָן שֶׁלָּהֶם.",
            definitionNative = "Спец-чип Google для обучения — очень быстрый, но доступен только в их облаке.",
            example = "אִימַּנּוּ אֶת הַמּוֹדֵל עַל TPU כְּדֵי לְהַסְפִּיק לְפְנֵי הַדֶּדְּלַיְין.",
            exampleNative = "Мы обучали модель на TPU, чтобы успеть до дедлайна.",
         fillInBlankExclusions = listOf(175521L, 175523L, 175524L, 175525L)),
        WordEntity(
            id = 175523, setId = 1755, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_compute", transliteration = "kuda",
            original = "CUDA", translation = "CUDA",
            definition = "סְבִיבַת תִּכְנוּת שֶׁל NVIDIA שֶׁמְּאַפְשֶׁרֶת לְהָרִיץ קוֹד מַקְבִּילִי עַל כַּרְטִיסֵי הַמָּסַךְ שֶׁלָּהּ.",
            definitionNative = "Среда программирования NVIDIA — позволяет запускать параллельный код на их видеокартах.",
            example = "סְפָרִיּוֹת CUDA מוּתְקָנוֹת בְּכָל מְכוֹנַת אִימוּן בַּמַּעְבָּדָה.",
            exampleNative = "Библиотеки CUDA установлены на каждой обучающей машине в лаборатории.",
         fillInBlankExclusions = listOf(175521L, 175522L, 175524L, 175525L)),
        WordEntity(
            id = 175524, setId = 1755, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "aiml_compute", transliteration = "vi-ram",
            original = "vRAM", translation = "vRAM",
            definition = "זִכָּרוֹן עַל כַּרְטִיס הַמָּסַךְ שֶׁמַּחְזִיק מִשְׁקְלֵי מוֹדֵל וּבָאצ׳ים בִּזְמַן רִיצָה.",
            definitionNative = "Память на видеокарте — держит веса модели и батчи во время прогона.",
            example = "הַמּוֹדֵל הַגָּדוֹל לֹא נִכְנַס בְּ-24GB שֶׁל vRAM וְצָרַכְנוּ לְהוֹרִיד דִּיּוּק.",
            exampleNative = "Большая модель не влезла в 24GB vRAM, и пришлось снизить точность.",
         fillInBlankExclusions = listOf(175521L, 175522L, 175523L, 175525L)),
        WordEntity(
            id = 175525, setId = 1755, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "aiml_compute", transliteration = "godel batch",
            original = "גֹּדֶל בָּאצ׳", translation = "размер батча",
            definition = "כַּמָּה דֻּגְמָאוֹת מַעֲבִירִים בַּמּוֹדֵל בְּצַעַד אֶחָד שֶׁל לְמִידָה — מֻגְבָּל עַל יְדֵי הַזִּכָּרוֹן.",
            definitionNative = "Сколько примеров пропускают через модель за один шаг учёбы — упирается в память.",
            example = "הִגְדַּלְנוּ אֶת גֹּדֶל בָּאצ׳ לְ-128 וְהַלְּמִידָה הָפְכָה יַצִּיבָה יוֹתֵר.",
            exampleNative = "Мы увеличили גֹּדֶל בָּאצ׳ до 128, и обучение стало стабильнее.",
            isFillInBlankSafe = false,
        ),
    )
}
