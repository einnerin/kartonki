package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — set 1910 (he-ru).
 * Хайтек: базовые структуры данных и алгоритмы (L3 / RARE + EPIC).
 *
 * Зеркало en-ru set 464 (WordDataEnglishTechAlgorithms). Точечное расширение
 * темы «Хайтек» в he-ru — CS fundamentals, словарь технического собеседования.
 *
 * Не пересекается с существующими он-ну сетами темы «Хайтек» в he-ru:
 *   - HightechL3 (1872) — архитектура стека: фреймворки, БД, облака,
 *     микросервисы. Здесь другое — структуры данных в памяти.
 *   - HightechL4 (1873) — DevOps, CI/CD, безопасность, KPI.
 *   - HightechL5 (1874) — менеджмент, C-suite, инвестиции.
 * Также проверено пересечение с DataEng/Cyber/QA/Mobile/PM/Programmer (1350).
 *
 * Из набора кандидатов исключены 7 слов — дубли в IT-контексте:
 *   - מַחְסָנִית (stack) — set 1350 (Программист, IT-смысл)
 *   - תּוֹר (queue) — set 1350 (IT-смысл)
 *   - מִיּוּן (sorting) — DataEngL2 (SQL ORDER BY, IT-смысл)
 *   - סִיבּוּכִיוּת (complexity / Big O) — set 1350
 *   - מִילּוֹן (dictionary / hash) — set 1350
 *   - אִיטֶרַצְיָה (iteration) — WorkRemote (общий смысл, но риск пересечения)
 *   - עֵץ (tree, простое) — в 1350 уже «дерево поиска» как составной термин,
 *     здесь беру עֵץ בִּינָרִי как более специфичное и непересекающееся.
 *
 * Заменители подобраны из той же подгруппы:
 *   - В подгруппе linear отсутствует stack/queue → шлишия + מַעֲרָךְ +
 *     рашима мэкушэрэт остаются как ядро линейных структур.
 *   - В подгруппе sorting_search מִיּוּן заменено на מִיּוּן בּוּעוֹת и
 *     מִיּוּן מָהִיר (конкретные алгоритмы). מַעֲבָר → מַעֲבָר עַל עֵץ.
 *   - В концептах סִיבּוּכִיוּת заменено на O גָּדוֹל (Big O) — более узкий
 *     термин, отдельная карточка вне 1350.
 *
 * Распределение редкости (validate_rarity_spread: 2 смежных уровня):
 *   RARE — 13 слов (B2, лексика собеседований): структуры данных
 *     и базовые алгоритмы сортировки/поиска.
 *   EPIC — 12 слов (C1, теория и низкий уровень): концепции ООП,
 *     анализ сложности, низкоуровневые понятия.
 *
 * Пять семантических подгрупп (validate_group_sizes):
 *   tech_algo_structures_linear — 4 слова: массив, связный список,
 *     указатель, кортеж
 *   tech_algo_structures_nonlinear — 5 слов: бинарное дерево, куча,
 *     хеш-таблица, направленный граф, узел
 *   tech_algo_sorting_search — 5 слов: двоичный поиск, обход дерева,
 *     хеширование, сортировка пузырьком, быстрая сортировка
 *   tech_algo_concepts — 6 слов: Big O, runtime, динамическое
 *     программирование, жадный алгоритм, инкапсуляция, наследование,
 *     интерфейс, абстракция, абстрактный класс — урезано до 6:
 *     O гадоль, зман рица, тихнут динами, алгоритм хамдан + ООП-четвёрка
 *   tech_algo_oop — пересмотр: ООП-термины выделены в свою группу
 *   tech_algo_lowlevel — 2 слова: тhалих, мацав мэруц
 *
 * Финальное разбиение (после пересчёта):
 *   tech_algo_structures_linear — 4 слова
 *   tech_algo_structures_nonlinear — 5 слов
 *   tech_algo_sorting_search — 5 слов
 *   tech_algo_concepts — 4 слова (O гадоль, runtime, dp, greedy)
 *   tech_algo_oop — 5 слов (incaps, inherit, interface, abstract, abstract class)
 *   tech_algo_lowlevel — 2 слова (thread/process, race condition)
 *
 * Word IDs: 191001..191025 (setId × 100 + position).
 */
object WordDataHebrewHightechAlgorithms {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1910, languagePair = "he-ru", orderIndex = 1910,
            name = "Хайтек",
            description = "Структуры и алгоритмы: מַעֲרָךְ, עֵץ בִּינָרִי, טַבְלַת גִּיבּוּב, O גָּדוֹל, מַצַּב מֵרוּץ.",
            topic = "Хайтек",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: tech_algo_structures_linear (4 words) ─────────────────────

        WordEntity(id = 191001, setId = 1910, languagePair = "he-ru", rarity = "RARE",
            original = "מַעֲרָךְ",
            translation = "массив",
            definition = "אֹסֶף סָדוּר שֶׁל אֵיבָרִים בְּגֹדֶל קָבוּעַ עִם גִּישָׁה יְשִׁירָה דֶּרֶךְ מַפְתֵּחַ מִסְפָּרִי.",
            definitionNative = "Упорядоченный набор элементов фиксированного размера с прямым доступом по числовому ключу.",
            example = "הַמּוּעֲמָד הֵסְבִּיר אֵיךְ לְמַיֵּן מַעֲרָךְ בִּסְבִיכוּת לוֹגָרִיתְמִית.",
            exampleNative = "Кандидат объяснил, как отсортировать מַעֲרָךְ за логарифмическую сложность.",
            transliteration = "мараах",
            pos = "noun", semanticGroup = "tech_algo_structures_linear"),

        WordEntity(id = 191002, setId = 1910, languagePair = "he-ru", rarity = "RARE",
            original = "רְשִׁימָה מְקֻשֶּׁרֶת",
            translation = "связный список",
            definition = "מִבְנֶה דִּינָמִי שֶׁבּוֹ כָּל אֵיבָר מַחְזִיק הַפְנָיָה לָאֵיבָר הַבָּא בִּתְוָך הַזִּכָּרוֹן.",
            definitionNative = "Динамическая структура, в которой каждый элемент хранит ссылку на следующий в памяти.",
            example = "הַמְפַתֵּחַ הִחְלִיף מַעֲרָךְ בִּרְשִׁימָה מְקֻשֶּׁרֶת כְּדֵי לְהוֹסִיף בְּקַלּוּת.",
            exampleNative = "Разработчик заменил массив на רְשִׁימָה מְקֻשֶּׁרֶת для лёгких вставок.",
            transliteration = "ршима мэкушэрэт",
            pos = "phrase", semanticGroup = "tech_algo_structures_linear"),

        WordEntity(id = 191003, setId = 1910, languagePair = "he-ru", rarity = "RARE",
            original = "מַצְבֵּעַ",
            translation = "указатель (pointer)",
            definition = "מִשְׁתַּנֶּה שֶׁמַּחְזִיק כְּתֹבֶת בְּזִכָּרוֹן וְלֹא אֶת הָעֵרֶךְ עַצְמוֹ.",
            definitionNative = "Переменная, которая хранит адрес в памяти, а не само значение.",
            example = "הוּא נִכְשַׁל בַּשְּׁאֵלָה כִּי שָׁכַח לְבַטֵּל מַצְבֵּעַ אַחֲרֵי שִׁחְרוּר.",
            exampleNative = "Он провалил вопрос, забыв обнулить מַצְבֵּעַ после освобождения памяти.",
            transliteration = "мацбэа",
            pos = "noun", semanticGroup = "tech_algo_structures_linear"),

        WordEntity(id = 191004, setId = 1910, languagePair = "he-ru", rarity = "RARE",
            original = "שָׁלִישִׁיָּה",
            translation = "кортеж (tuple)",
            definition = "אֹסֶף אֵיבָרִים בְּגֹדֶל קָבוּעַ שֶׁאִי אֶפְשָׁר לְשַׁנּוֹתוֹ אַחֲרֵי הַיְצִירָה.",
            definitionNative = "Набор элементов фиксированного размера, который нельзя изменить после создания.",
            example = "הַפוּנְקְצִיָּה הֶחְזִירָה שָׁלִישִׁיָּה שֶׁל קוֹאוֹרְדִּינָטָה, סְטָטוּס וּשְׁגִיאָה.",
            exampleNative = "Функция вернула שָׁלִישִׁיָּה из координаты, статуса и ошибки.",
            transliteration = "шлишия",
            pos = "noun", semanticGroup = "tech_algo_structures_linear", fillInBlankExclusions = listOf(191001L, 191003L)),

        // ── Group: tech_algo_structures_nonlinear (5 words) ───────────────────

        WordEntity(id = 191005, setId = 1910, languagePair = "he-ru", rarity = "RARE",
            original = "עֵץ בִּינָרִי",
            translation = "бинарное дерево",
            definition = "מִבְנֶה הִיֶּרַרְכִּי שֶׁבּוֹ לְכָל צֹמֶת יֵשׁ לְכָל הַיּוֹתֵר שְׁנֵי בָּנִים.",
            definitionNative = "Иерархическая структура, в которой у каждого узла не более двух потомков.",
            example = "הַשְּׁאֵלָה דָּרְשָׁה לְאַזֵּן עֵץ בִּינָרִי תּוֹךְ כְּדֵי הוֹסָפָה.",
            exampleNative = "Задача требовала балансировать עֵץ בִּינָרִי прямо во время вставки.",
            transliteration = "эц бинари",
            pos = "phrase", semanticGroup = "tech_algo_structures_nonlinear", fillInBlankExclusions = listOf(191007L, 191008L)),

        WordEntity(id = 191006, setId = 1910, languagePair = "he-ru", rarity = "RARE",
            original = "עָרְמָה",
            translation = "куча (heap, структура данных)",
            definition = "מִבְנֶה שֶׁשּׁוֹמֵר עַל סֵדֶר חֶלְקִי וּמְאַפְשֵׁר לְהוֹצִיא אֶת הַמַּקְסִימוּם בִּמְהִירוּת.",
            definitionNative = "Структура с частичным порядком, позволяющая быстро извлечь максимум.",
            example = "תּוֹר הָעֲדִיפוּיוֹת מוּמַשׁ עַל גַּבֵּי עָרְמָה בִּינָרִית.",
            exampleNative = "Очередь приоритетов реализована поверх двоичной עָרְמָה.",
            transliteration = "арма",
            pos = "noun", semanticGroup = "tech_algo_structures_nonlinear", fillInBlankExclusions = listOf(191009L)),

        WordEntity(id = 191007, setId = 1910, languagePair = "he-ru", rarity = "RARE",
            original = "טַבְלַת גִּיבּוּב",
            translation = "хеш-таблица",
            definition = "מִבְנֶה שֶׁמְּמַפֶּה מַפְתֵּחַ לְעֵרֶךְ דֶּרֶךְ פוּנְקְצִיַּת פִּיזּוּר עִם גִּישָׁה מְמֻצַּעַת קְבוּעָה.",
            definitionNative = "Структура, отображающая ключ в значение через функцию разброса со средней константной выборкой.",
            example = "הוּא בָּחַר טַבְלַת גִּיבּוּב כְּדֵי לְצַמְצֵם זְמַן הַחִיפּוּשׂ.",
            exampleNative = "Он выбрал טַבְלַת גִּיבּוּב, чтобы сократить время поиска.",
            transliteration = "тавлат гибув",
            pos = "phrase", semanticGroup = "tech_algo_structures_nonlinear", fillInBlankExclusions = listOf(191005L, 191008L)),

        WordEntity(id = 191008, setId = 1910, languagePair = "he-ru", rarity = "RARE",
            original = "גְּרָף מְכֻוָּן",
            translation = "ориентированный граф (directed graph)",
            definition = "אֹסֶף קָדְקוֹדִים וְקַשְׁתוֹת עִם כִּוּוּן יָחִיד בֵּין כָּל זוּג מְחֻבָּר.",
            definitionNative = "Множество вершин и рёбер с одним направлением для каждой связанной пары.",
            example = "תְּלוּת בֵּין מוֹדּוּלִים מְיֻצֶּגֶת בְּדֶרֶךְ כְּלָל גְּרָף מְכֻוָּן.",
            exampleNative = "Зависимости между модулями обычно представлены как גְּרָף מְכֻוָּן.",
            transliteration = "граф мэхуван",
            pos = "phrase", semanticGroup = "tech_algo_structures_nonlinear", fillInBlankExclusions = listOf(191005L, 191007L)),

        WordEntity(id = 191009, setId = 1910, languagePair = "he-ru", rarity = "RARE",
            original = "צֹמֶת בְּעֵץ",
            translation = "узел дерева (node)",
            definition = "יְחִידָה בּוֹדֶדֶת בַּמִּבְנֶה הַהִיֶּרַרְכִּי שֶׁמַּחְזִיקָה עֵרֶךְ וְהַפְנָיוֹת לְבָנִים.",
            definitionNative = "Одиночная единица иерархической структуры, что хранит значение и ссылки на потомков.",
            example = "הָאַלְגוֹרִיתְם עוֹבֵר עַל כָּל צֹמֶת בְּעֵץ וּמַדְפִּיס אֶת הָעֵרֶךְ.",
            exampleNative = "Алгоритм проходит по каждому צֹמֶת בְּעֵץ и печатает значение.",
            transliteration = "цомэт ба-эц",
            pos = "phrase", semanticGroup = "tech_algo_structures_nonlinear", fillInBlankExclusions = listOf(191006L)),

        // ── Group: tech_algo_sorting_search (5 words) ─────────────────────────

        WordEntity(id = 191010, setId = 1910, languagePair = "he-ru", rarity = "RARE",
            original = "חִיפּוּשׂ בִּינָרִי",
            translation = "двоичный (бинарный) поиск",
            definition = "שִׁיטָה שֶׁמּוֹצֵאת עֵרֶךְ בְּרְשִׁימָה מְמֻיֶּנֶת עַל יְדֵי חֲצָאָה חוֹזֶרֶת שֶׁל הַטְּוָוח.",
            definitionNative = "Способ найти значение в отсортированном списке многократным делением диапазона пополам.",
            example = "הַמְרַאֲיֵן בִּקֵּשׁ לְמַמֵּשׁ חִיפּוּשׂ בִּינָרִי בְּלִי רֵקוּרְסְיָה.",
            exampleNative = "Интервьюер попросил реализовать חִיפּוּשׂ בִּינָרִי без рекурсии.",
            transliteration = "хипус бинари",
            pos = "phrase", semanticGroup = "tech_algo_sorting_search", fillInBlankExclusions = listOf(191011L, 191013L, 191014L)),

        WordEntity(id = 191011, setId = 1910, languagePair = "he-ru", rarity = "RARE",
            original = "מַעֲבָר עַל עֵץ",
            translation = "обход дерева (tree traversal)",
            definition = "סְרִיקָה שִׁיטָתִית שֶׁל כָּל הַצְּמָתִים בַּמִּבְנֶה לְפִי סֵדֶר מֻסְכָּם.",
            definitionNative = "Систематический обход всех узлов структуры в согласованном порядке.",
            example = "הַפִּתְרוֹן הִשְׁתַּמֵּשׁ בְּמַעֲבָר עַל עֵץ לְפִי הָעֹמֶק.",
            exampleNative = "Решение использовало מַעֲבָר עַל עֵץ в глубину.",
            transliteration = "маавар аль эц",
            pos = "phrase", semanticGroup = "tech_algo_sorting_search", fillInBlankExclusions = listOf(191010L, 191013L, 191014L)),

        WordEntity(id = 191012, setId = 1910, languagePair = "he-ru", rarity = "RARE",
            original = "הַטְלָה",
            translation = "хеширование",
            definition = "תַּהֲלִיךְ שֶׁמַּמִּיר קְלָט בְּגֹדֶל כְּלָשֶׁהוּ לְפֶלֶט קָצָר בְּגֹדֶל קָבוּעַ.",
            definitionNative = "Процесс, что превращает вход любого размера в короткий выход постоянной длины.",
            example = "אַחֲסוּן סִיסְמָאוֹת תָּמִיד עוֹבֵר הַטְלָה לִפְנֵי כְּתִיבָה לְבָסִיס הַנְּתוּנִים.",
            exampleNative = "Хранение паролей всегда проходит הַטְלָה перед записью в базу.",
            transliteration = "hатала",
            pos = "noun", semanticGroup = "tech_algo_sorting_search"),

        WordEntity(id = 191013, setId = 1910, languagePair = "he-ru", rarity = "RARE",
            original = "מִיּוּן בּוּעוֹת",
            translation = "сортировка пузырьком (bubble sort)",
            definition = "אַלְגוֹרִיתְם פָּשׁוּט שֶׁמַּחֲלִיף זוּגוֹת שְׁכֵנִים עַד שֶׁכָּל הָרְצוּגָה מְסֻדֶּרֶת.",
            definitionNative = "Простой алгоритм, обменивающий соседей, пока вся последовательность не упорядочится.",
            example = "בְּקוֹרְס מָבוֹא מַתְחִילִים תָּמִיד עִם מִיּוּן בּוּעוֹת.",
            exampleNative = "На вводном курсе всегда начинают с מִיּוּן בּוּעוֹת.",
            transliteration = "миун буот",
            pos = "phrase", semanticGroup = "tech_algo_sorting_search", fillInBlankExclusions = listOf(191010L, 191011L, 191014L)),

        WordEntity(id = 191014, setId = 1910, languagePair = "he-ru", rarity = "RARE",
            original = "מִיּוּן מָהִיר",
            translation = "быстрая сортировка (quicksort)",
            definition = "אַלְגוֹרִיתְם שֶׁבּוֹחֵר צִיר וּמְפַצֵּל סְבִיבוֹ אֶת הָאֵיבָרִים בָּאֹפֶן רֵקוּרְסִיבִי.",
            definitionNative = "Алгоритм, что выбирает опорный элемент и рекурсивно разделяет вокруг него остальное.",
            example = "מִיּוּן מָהִיר רָץ בִּסְבִיכוּת מְמֻצַּעַת לוֹגָרִיתְמִית-לִינֵיאָרִית.",
            exampleNative = "מִיּוּן מָהִיר работает в среднем за линейно-логарифмическое время.",
            transliteration = "миун маhир",
            pos = "phrase", semanticGroup = "tech_algo_sorting_search", fillInBlankExclusions = listOf(191010L, 191011L, 191013L)),

        // ── Group: tech_algo_concepts (4 words) ───────────────────────────────

        WordEntity(id = 191015, setId = 1910, languagePair = "he-ru", rarity = "EPIC",
            original = "O גָּדוֹל",
            translation = "Big O (асимптотическая оценка)",
            definition = "סִמּוּן שֶׁמְּתָאֵר אֵיךְ זְמַן הָרִיצָה גָּדֵל עִם גֹּדֶל הַקְּלָט, לְלֹא קְבוּעִים.",
            definitionNative = "Запись, что описывает, как время роста алгоритма зависит от размера входа без констант.",
            example = "הוּא נָתַן תְּשׁוּבָה נְכוֹנָה אֲבָל הִתְקַשָּׁה לְהוֹכִיחַ O גָּדוֹל בְּכָתָב.",
            exampleNative = "Он дал верный ответ, но затруднился доказать O גָּדוֹל на бумаге.",
            transliteration = "О гадоль",
            pos = "phrase", semanticGroup = "tech_algo_concepts", fillInBlankExclusions = listOf(191016L, 191017L, 191018L)),

        WordEntity(id = 191016, setId = 1910, languagePair = "he-ru", rarity = "EPIC",
            original = "זְמַן רִיצָה",
            translation = "время выполнения (runtime)",
            definition = "מֶשֶׁךְ הַחִישּׁוּב שֶׁל אַלְגוֹרִיתְם עַל קְלָט קוֹנְקְרֶטִי, נִמְדָּד בִּפְעֻלּוֹת אוֹ בְּשְׁנִיּוֹת.",
            definitionNative = "Длительность вычисления алгоритма на конкретном входе, в операциях или секундах.",
            example = "הַפְּרוֹפַיילֶר חָשַׂף שֶׁמֶּחֱצִית מִזְּמַן הָרִיצָה הוֹלֵךְ עַל שְׁאִילְתָּה אַחַת.",
            exampleNative = "Профайлер показал, что половину זְמַן רִיצָה съедает один запрос.",
            transliteration = "зман рица",
            pos = "phrase", semanticGroup = "tech_algo_concepts"),

        WordEntity(id = 191017, setId = 1910, languagePair = "he-ru", rarity = "EPIC",
            original = "תִּכְנוּת דִּינָמִי",
            translation = "динамическое программирование",
            definition = "גִּישָׁה שֶׁמְּפַרֶקֶת בְּעָיָה לְתַת-בְּעָיוֹת חוֹזְרוֹת וְשׁוֹמֶרֶת אֶת הַתּוֹצָאוֹת.",
            definitionNative = "Подход, что разбивает задачу на повторяющиеся подзадачи и кеширует их результаты.",
            example = "פִתְרוֹן בְּתִכְנוּת דִּינָמִי הוֹרִיד אֶת הַסְּבִיכוּת מֵאֶקְסְפּוֹנֶנְצְיָאלִית לְפּוֹלִינוֹמִית.",
            exampleNative = "Решение через תִּכְנוּת דִּינָמִי опустило сложность с экспоненты до полинома.",
            transliteration = "тихнут динами",
            pos = "phrase", semanticGroup = "tech_algo_concepts"),

        WordEntity(id = 191018, setId = 1910, languagePair = "he-ru", rarity = "EPIC",
            original = "אַלְגוֹרִיתְם חַמְדָן",
            translation = "жадный алгоритм (greedy)",
            definition = "שִׁיטָה שֶׁבּוֹחֶרֶת בְּכָל שָׁלָב אֶת הַהַחְלָטָה הַטּוֹבָה בְּיוֹתֵר מְקוֹמִית.",
            definitionNative = "Стратегия, что на каждом шаге берёт самое выгодное локальное решение.",
            example = "אַלְגוֹרִיתְם חַמְדָן לֹא תָּמִיד מוֹצֵא אֶת הַפִּתְרוֹן הָאוֹפְּטִימָלִי.",
            exampleNative = "אַלְגוֹרִיתְם חַמְדָן не всегда находит оптимальное решение.",
            transliteration = "алгоритм хамдан",
            pos = "phrase", semanticGroup = "tech_algo_concepts", fillInBlankExclusions = listOf(191015L, 191016L, 191017L)),

        // ── Group: tech_algo_oop (5 words) ────────────────────────────────────

        WordEntity(id = 191019, setId = 1910, languagePair = "he-ru", rarity = "EPIC",
            original = "הֲכָלָה",
            translation = "инкапсуляция",
            definition = "עִקָּרוֹן שֶׁמַּסְתִּיר אֶת הַמַּצָּב הַפְּנִימִי שֶׁל אוֹבְּיֶיקְט וְחוֹשֵׂף רַק מִמְשָׁק מֻגְדָּר.",
            definitionNative = "Принцип, что прячет внутреннее состояние объекта и открывает только заданный API.",
            example = "הֲכָלָה נְכוֹנָה מְצַמְצֶמֶת תְּלוּיוֹת בֵּין מוֹדּוּלִים שׁוֹנִים.",
            exampleNative = "Грамотная הֲכָלָה снижает связанность между разными модулями.",
            transliteration = "hахала",
            pos = "noun", semanticGroup = "tech_algo_oop", fillInBlankExclusions = listOf(191020L, 191021L, 191022L)),

        WordEntity(id = 191020, setId = 1910, languagePair = "he-ru", rarity = "EPIC",
            original = "הוֹרָשָׁה",
            translation = "наследование (OOP)",
            definition = "מַנְגְּנוֹן שֶׁבּוֹ מַחְלָקָה חֲדָשָׁה מְקַבֶּלֶת תְּכוּנוֹת וּפוּנְקְצִיּוֹת מִמַּחְלָקַת אָב.",
            definitionNative = "Механизм, при котором новый класс получает свойства и методы от родительского.",
            example = "הָאַרְכִיטֶקְט הִמְלִיץ לְהַחְלִיף הוֹרָשָׁה בְּהֶרְכֵּב לְצֹרֶךְ גְמִישׁוּת.",
            exampleNative = "Архитектор посоветовал заменить הוֹרָשָׁה на композицию ради гибкости.",
            transliteration = "hораша",
            pos = "noun", semanticGroup = "tech_algo_oop", fillInBlankExclusions = listOf(191019L, 191021L, 191022L)),

        WordEntity(id = 191021, setId = 1910, languagePair = "he-ru", rarity = "EPIC",
            original = "מִמְשָׁק",
            translation = "интерфейс (контракт классов)",
            definition = "חוֹזֶה שֶׁמַּגְדִּיר אֵילוּ פְּעֻלּוֹת מַחְלָקָה חַיֶּבֶת לְמַמֵּשׁ בְּלִי לִקְבֹּעַ אֵיךְ.",
            definitionNative = "Контракт, что задаёт, какие методы класс обязан реализовать, не указывая как.",
            example = "כָּל הָאַדַפְּטֶרִים בַּפְּרוֹיֶקְט מַמְּשִׁים אוֹתוֹ מִמְשָׁק.",
            exampleNative = "Все адаптеры в проекте реализуют один מִמְשָׁק.",
            transliteration = "мимшак",
            pos = "noun", semanticGroup = "tech_algo_oop", fillInBlankExclusions = listOf(191019L, 191020L, 191022L)),

        WordEntity(id = 191022, setId = 1910, languagePair = "he-ru", rarity = "EPIC",
            original = "הַפְשָׁטָה",
            translation = "абстракция",
            definition = "תַּהֲלִיךְ שֶׁמַּשְׁאִיר רַק אֶת הַהֶבֵּטִים הַחֲשׁוּבִים לַשִּׁמּוּשׁ וּמַסְתִּיר פְּרָטִים פְּנִימִיִּים.",
            definitionNative = "Процесс, что оставляет только важные для использования аспекты и прячет внутренние детали.",
            example = "הוּא הִצִּיעַ הַפְשָׁטָה דַּקָּה יוֹתֵר מֵעַל הַ-API.",
            exampleNative = "Он предложил более тонкую הַפְשָׁטָה поверх API.",
            transliteration = "hафшата",
            pos = "noun", semanticGroup = "tech_algo_oop", fillInBlankExclusions = listOf(191019L, 191020L, 191021L)),

        WordEntity(id = 191023, setId = 1910, languagePair = "he-ru", rarity = "EPIC",
            original = "מַחְלָקָה מוּפְשֶׁטֶת",
            translation = "абстрактный класс",
            definition = "תַּבְנִית שֶׁאִי אֶפְשָׁר לִיצֹר מִמֶּנָּה אוֹבְּיֶיקְט יָשִׁיר וְהִיא חוֹשֶׂפֶת חֶלְקֵי מִימּוּשׁ.",
            definitionNative = "Шаблон, от которого нельзя породить объект напрямую и который раскрывает часть реализации.",
            example = "כָּל הַ-handlers יוֹרְשִׁים מִמַּחְלָקָה מוּפְשֶׁטֶת אַחַת מְרֻכֶּזֶת.",
            exampleNative = "Все хендлеры наследуют от одной центральной מַחְלָקָה מוּפְשֶׁטֶת.",
            transliteration = "махлака муфшэтэт",
            pos = "phrase", semanticGroup = "tech_algo_oop"),

        // ── Group: tech_algo_lowlevel (2 words) ───────────────────────────────

        WordEntity(id = 191024, setId = 1910, languagePair = "he-ru", rarity = "EPIC",
            original = "תַּהֲלִיךְ",
            translation = "процесс / поток (thread)",
            definition = "יְחִידַת רִיצָה עַצְמָאִית עִם זִכָּרוֹן וּמַשְׁאַבֵּי מַעֲרֶכֶת מְשֻׁתָּפִים אוֹ נִפְרָדִים.",
            definitionNative = "Самостоятельная единица выполнения со своей памятью и общими или раздельными ресурсами системы.",
            example = "אַחֲרֵי שְׁלֹשָׁה סִבְבֵי בִּקֹּרֶת קוֹד הוּא כָּתַב מֵחָדָשׁ אֶת הַתַּהֲלִיךְ הָרֵקוּרְסִיבִי.",
            exampleNative = "После трёх раундов код-ревью он переписал תַּהֲלִיךְ из рекурсии в цикл.",
            transliteration = "таhалих",
            pos = "noun", semanticGroup = "tech_algo_lowlevel"),

        WordEntity(id = 191025, setId = 1910, languagePair = "he-ru", rarity = "EPIC",
            original = "מַצַּב מֵרוּץ",
            translation = "состояние гонки (race condition)",
            definition = "בָּאג שֶׁמּוֹפִיעַ כְּשֶׁשְּׁנֵי תַּהֲלִיכִים נִכְנָסִים בְּמַקְבִּיל לְאוֹתוֹ מַשְׁאָב לְלֹא סִינְכְּרוּן.",
            definitionNative = "Баг, что возникает, когда два потока параллельно лезут к одному ресурсу без синхронизации.",
            example = "מַצַּב מֵרוּץ נָדִיר הִפִּיל אֶת הַשֵּׁרוּת רַק תַּחַת עֹמֶס כָּבֵד.",
            exampleNative = "Редкий מַצַּב מֵרוּץ ронял сервис только под тяжёлой нагрузкой.",
            transliteration = "мацав мэруц",
            pos = "phrase", semanticGroup = "tech_algo_lowlevel"),
    )
}
