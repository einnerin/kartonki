package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — set 464.
 * Технологии: базовые структуры данных и алгоритмы — то, что изучают на первом
 * курсе CS (L3 / RARE + EPIC).
 *
 * Расширение темы «Технологии». Дополняет:
 *   - 18         (L1) — базовые гаджеты.
 *   - 234        (L2) — повседневная IT-лексика.
 *   - 235        (L3) — программирование и кибербезопасность RARE+EPIC.
 *   - 247        (L4) — продвинутая разработка.
 *   - 249        (L2) — геймерская лексика.
 *   - 340        (L5) — теоретические термины (monad, lambda, NP-complete, big-O).
 *
 * Подтема — CS fundamentals: структуры данных, алгоритмы сортировки и поиска,
 * базовые концепции сложности и низкоуровневые понятия времени выполнения.
 * Пять семантических групп:
 *   tech_algo_structures_linear     — array, linked list, stack, heap, deque
 *   tech_algo_structures_nonlinear  — node, graph, hash table, pointer, tuple
 *   tech_algo_sorting_search        — sorting, binary search, traversal, lookup, quicksort
 *   tech_algo_concepts              — complexity, runtime, dynamic programming,
 *                                     greedy algorithm, brute force, encapsulation
 *   tech_algo_lowlevel              — race condition, syscall, stack frame, abstract class
 *
 * Исключены дубли:
 *   - cache, debug, compiler, recursion, polymorphism, kernel, latency,
 *     binary, throughput, jitter — setId 235.
 *   - memoization, mutex, deadlock, big-O, monad, functor, currying, closure,
 *     lambda, NP-complete, halting, idempotent, handshake, payload,
 *     deprecation, reentrant, thread-safe, instrumentation, observability,
 *     telemetry, lock-free, orchestration, kubernetes, hypervisor,
 *     semaphore — setId 340.
 *   - algorithm, interface — setId 39.
 *   - tree, leaf — setId 208 (gardening).
 *   - dictionary — setId 15 (school).
 *   - queue — setId 25 (verb «стоять в очереди») и shopping L1 (noun «очередь»).
 *   - fork — setId Batch10 («вилка»).
 *   - thread — setId Batch5 («тред цепочки сообщений»).
 *   - abstraction — setId Batch5.
 *   - reference — setId Batch4 («рекомендация»).
 *   - inheritance — setId Batch13 («наследство имущества»).
 *   - iteration — setId 303 (boardgame design).
 *   - indexing — setId InternetL3.
 *   - hashing — setId InternetL4.
 *   - garbage collection — setId CityLifeL3 («вывоз мусора»).
 *
 * Word IDs: 46401..46425 (setId × 100 + position).
 */
object WordDataEnglishTechAlgorithms {

    val sets = listOf(
        WordSetEntity(
            id = 464,
            name = "Технологии",
            description = "Структуры данных и алгоритмы: array, stack, hash table, binary search, complexity",
            languagePair = "en-ru",
            orderIndex = 464,
            topic = "Технологии",
            level = 3,
        ),
    )

    val words = listOf(

        // ── tech_algo_structures_linear (линейные структуры данных) ───────────
        WordEntity(
            id = 46401, original = "array", transliteration = "[əˈreɪ]", translation = "массив",
            definition = "An ordered container that stores items of the same type in fixed numbered slots, accessed by index.",
            definitionNative = "Упорядоченный контейнер: хранит элементы одного типа в фиксированных пронумерованных ячейках, доступ по индексу.",
            example = "She loaded the player scores into an array and sorted them in place before printing the leaderboard.",
            exampleNative = "Она загрузила очки игроков в array и отсортировала их на месте перед выводом таблицы лидеров.",
            rarity = "RARE", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_structures_linear", fillInBlankExclusions = listOf(46402L, 46403L, 46404L, 46405L)),
        WordEntity(
            id = 46402, original = "linked list", transliteration = "[lɪŋkt lɪst]", translation = "связный список",
            definition = "A chain of nodes, each holding a value and a pointer to the next one in the sequence.",
            definitionNative = "Цепочка узлов: каждый хранит значение и указатель на следующий узел в последовательности.",
            example = "We swapped the array for a linked list because front insertions had to be cheap.",
            exampleNative = "Мы заменили массив на linked list, потому что вставки в начало должны быть дешёвыми.",
            rarity = "EPIC", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_structures_linear", fillInBlankExclusions = listOf(46401L, 46403L, 46404L, 46405L)),
        WordEntity(
            id = 46403, original = "stack", transliteration = "[stæk]", translation = "стек",
            definition = "A last-in, first-out container where you push items on top and pop the most recent one off first.",
            definitionNative = "Контейнер LIFO: элементы кладутся сверху, и первым достаётся самый последний положенный.",
            example = "The undo feature stores each action on a stack so the most recent change rolls back first.",
            exampleNative = "Функция отмены кладёт каждое действие в stack, чтобы первым откатывалось самое свежее изменение.",
            rarity = "RARE", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_structures_linear", fillInBlankExclusions = listOf(46401L, 46402L, 46404L, 46405L)),
        WordEntity(
            id = 46404, original = "heap", transliteration = "[hiːp]", translation = "куча (структура / память)",
            definition = "A tree-shaped container that always keeps the smallest or largest item at the top, used to pull priorities fast.",
            definitionNative = "Древовидный контейнер: всегда держит наверху минимум или максимум — нужен для быстрой выборки по приоритету.",
            example = "The task scheduler keeps pending jobs in a min-heap so the most urgent one is always at hand.",
            exampleNative = "Планировщик задач хранит ожидающие задания в min-heap, чтобы самое срочное всегда было под рукой.",
            rarity = "EPIC", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_structures_linear", fillInBlankExclusions = listOf(46401L, 46402L, 46403L, 46405L)),
        WordEntity(
            id = 46405, original = "deque", transliteration = "[dek]", translation = "двусторонняя очередь",
            definition = "A container that lets you add or remove items from either end in constant time, mixing stack and queue behaviour.",
            definitionNative = "Контейнер, в котором можно добавлять и удалять элементы с любого конца за константное время: смесь стека и очереди.",
            example = "A deque is handy for a sliding-window algorithm that drops the oldest value each step.",
            exampleNative = "Deque удобен для алгоритма скользящего окна: на каждом шаге сбрасывается самый старый элемент.",
            rarity = "EPIC", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_structures_linear", fillInBlankExclusions = listOf(46401L, 46402L, 46403L, 46404L)),

        // ── tech_algo_structures_nonlinear (нелинейные структуры) ─────────────
        WordEntity(
            id = 46406, original = "node", transliteration = "[noʊd]", translation = "узел",
            definition = "A single unit inside a tree, graph or linked list that stores one value plus links to its neighbours.",
            definitionNative = "Одна ячейка дерева, графа или связного списка: хранит значение плюс ссылки на соседей.",
            example = "Each node in the tree keeps a key, a payload and references to its left and right children.",
            exampleNative = "Каждый node в дереве хранит ключ, полезные данные и ссылки на левого и правого ребёнка.",
            rarity = "RARE", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_structures_nonlinear", fillInBlankExclusions = listOf(46407L, 46408L, 46409L, 46410L)),
        WordEntity(
            id = 46407, original = "graph", transliteration = "[ɡræf]", translation = "граф",
            definition = "A network of nodes connected by edges, used to model anything from road maps to social-media friendships.",
            definitionNative = "Сеть узлов, соединённых рёбрами: моделирует что угодно от дорожной карты до дружбы в соцсетях.",
            example = "Finding the shortest delivery route is a classic shortest-path problem on a weighted graph.",
            exampleNative = "Поиск кратчайшего маршрута доставки — классическая задача о кратчайшем пути на взвешенном graph.",
            rarity = "RARE", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_structures_nonlinear", fillInBlankExclusions = listOf(46406L, 46408L, 46409L, 46410L)),
        WordEntity(
            id = 46408, original = "hash table", transliteration = "[hæʃ ˈteɪbəl]", translation = "хеш-таблица",
            definition = "A container that turns a key into an array index using a hash function, giving near-constant lookups.",
            definitionNative = "Контейнер, превращающий ключ в индекс массива через хеш-функцию: даёт поиск почти за константу.",
            example = "We stored user sessions in a hash table so any user's record could be fetched in one step.",
            exampleNative = "Мы хранили сессии пользователей в hash table, чтобы запись любого юзера доставалась за один шаг.",
            rarity = "RARE", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_structures_nonlinear", fillInBlankExclusions = listOf(46406L, 46407L, 46409L, 46410L)),
        WordEntity(
            id = 46409, original = "pointer", transliteration = "[ˈpɔɪntər]", translation = "указатель",
            definition = "A variable that stores the memory address of another value rather than the value itself.",
            definitionNative = "Переменная, хранящая адрес другого значения в памяти, а не само значение.",
            example = "The bug came from a stale pointer that still referenced memory the program had already freed.",
            exampleNative = "Баг пришёл от устаревшего pointer, который всё ещё ссылался на уже освобождённую память.",
            rarity = "RARE", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_structures_nonlinear", fillInBlankExclusions = listOf(46406L, 46407L, 46408L, 46410L)),
        WordEntity(
            id = 46410, original = "tuple", transliteration = "[ˈtuːpəl]", translation = "кортеж",
            definition = "A small fixed-size group of values, often of different types, treated as a single immutable record.",
            definitionNative = "Маленькая группа значений фиксированной длины, часто разных типов: воспринимается как одна неизменяемая запись.",
            example = "The function returned a tuple holding the parsed date, the user's name and an error code.",
            exampleNative = "Функция вернула tuple, содержащий разобранную дату, имя пользователя и код ошибки.",
            rarity = "EPIC", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_structures_nonlinear", fillInBlankExclusions = listOf(46406L, 46407L, 46408L, 46409L)),

        // ── tech_algo_sorting_search (сортировка и поиск) ─────────────────────
        WordEntity(
            id = 46411, original = "sorting", transliteration = "[ˈsɔːrtɪŋ]", translation = "сортировка",
            definition = "The act of arranging items in a chosen order — ascending, alphabetical or by any custom rule.",
            definitionNative = "Расстановка элементов в выбранном порядке: по возрастанию, алфавиту или любому собственному правилу.",
            example = "Switching from bubble sorting to a built-in routine cut the report generation time in half.",
            exampleNative = "Замена пузырькового sorting на встроенную процедуру вдвое сократила время генерации отчёта.",
            rarity = "RARE", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_sorting_search", fillInBlankExclusions = listOf(46412L, 46413L, 46414L, 46415L)),
        WordEntity(
            id = 46412, original = "binary search", transliteration = "[ˈbaɪnəri sɜːrtʃ]", translation = "двоичный поиск",
            definition = "A way to find an item in a sorted list by repeatedly cutting the search range in half.",
            definitionNative = "Способ найти элемент в отсортированном списке: на каждом шаге диапазон поиска делится пополам.",
            example = "We replaced the linear scan with a binary search and the lookup dropped to microseconds.",
            exampleNative = "Мы заменили линейный обход на binary search, и поиск ускорился до микросекунд.",
            rarity = "RARE", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_sorting_search", fillInBlankExclusions = listOf(46411L, 46413L, 46414L, 46415L)),
        WordEntity(
            id = 46413, original = "traversal", transliteration = "[trəˈvɜːrsəl]", translation = "обход (структуры данных)",
            definition = "The act of visiting every element of a tree, graph or list in some defined order.",
            definitionNative = "Посещение каждого элемента дерева, графа или списка в каком-то заданном порядке.",
            example = "An in-order traversal of a binary search tree prints the values from smallest to largest for free.",
            exampleNative = "In-order traversal двоичного дерева поиска бесплатно выводит значения от наименьшего к наибольшему.",
            rarity = "RARE", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_sorting_search", fillInBlankExclusions = listOf(46411L, 46412L, 46414L, 46415L)),
        WordEntity(
            id = 46414, original = "lookup", transliteration = "[ˈlʊkˌʌp]", translation = "поиск по ключу / выборка",
            definition = "The single operation of finding a value by its key inside a table or map.",
            definitionNative = "Одна операция: достать значение по его ключу из таблицы или словаря.",
            example = "A lookup in a well-tuned hash map takes constant time no matter how many entries are stored.",
            exampleNative = "Lookup в хорошо настроенной хеш-таблице занимает константное время вне зависимости от числа записей.",
            rarity = "RARE", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_sorting_search", fillInBlankExclusions = listOf(46411L, 46412L, 46413L, 46415L)),
        WordEntity(
            id = 46415, original = "quicksort", transliteration = "[ˈkwɪkˌsɔːrt]", translation = "быстрая сортировка",
            definition = "A divide-and-conquer sorting method that picks a pivot, splits the data around it and recurses on each half.",
            definitionNative = "Сортировка «разделяй и властвуй»: выбираем опорный элемент, разделяем данные вокруг него и рекурсивно сортируем половины.",
            example = "Most language standard libraries use quicksort or a tuned variant of it under the hood.",
            exampleNative = "Большинство стандартных библиотек языков используют под капотом quicksort или его подкрученный вариант.",
            rarity = "EPIC", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_sorting_search", fillInBlankExclusions = listOf(46411L, 46412L, 46413L, 46414L)),

        // ── tech_algo_concepts (концепции и парадигмы) ────────────────────────
        WordEntity(
            id = 46416, original = "complexity", transliteration = "[kəmˈpleksəti]", translation = "сложность (алгоритма)",
            definition = "A measure of how the time or memory needed by an algorithm grows with the input size.",
            definitionNative = "Оценка того, как растут время или память, нужные алгоритму, с увеличением размера входа.",
            example = "Before merging the patch, the reviewer asked what the time complexity of the new function was.",
            exampleNative = "Перед мерджем патча ревьюер спросил, какая у новой функции временная complexity.",
            rarity = "RARE", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_concepts", fillInBlankExclusions = listOf(46417L, 46418L, 46419L, 46420L, 46421L)),
        WordEntity(
            id = 46417, original = "runtime", transliteration = "[ˈrʌnˌtaɪm]", translation = "время выполнения / среда выполнения",
            definition = "Either how long a program takes to run or the system that supports it while it is executing.",
            definitionNative = "Либо время работы программы, либо система, поддерживающая её во время исполнения.",
            example = "Adding caching brought the runtime of the nightly batch job from forty minutes down to six.",
            exampleNative = "Добавление кеша сократило runtime ночного пакетного задания с сорока минут до шести.",
            rarity = "RARE", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_concepts", fillInBlankExclusions = listOf(46416L, 46418L, 46419L, 46420L, 46421L)),
        WordEntity(
            id = 46418, original = "dynamic programming", transliteration = "[daɪˈnæmɪk ˈproʊɡræmɪŋ]", translation = "динамическое программирование",
            definition = "An approach that solves complex problems by storing answers to smaller overlapping sub-problems and reusing them.",
            definitionNative = "Подход к решению сложных задач: ответы на меньшие пересекающиеся подзадачи запоминаются и переиспользуются.",
            example = "The interviewer asked us to rewrite the recursive solution with dynamic programming on the board.",
            exampleNative = "Интервьюер попросил переписать рекурсивное решение через dynamic programming прямо на доске.",
            rarity = "EPIC", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_concepts", fillInBlankExclusions = listOf(46416L, 46417L, 46419L, 46420L, 46421L)),
        WordEntity(
            id = 46419, original = "greedy algorithm", transliteration = "[ˈɡriːdi ˈælɡəˌrɪðəm]", translation = "жадный алгоритм",
            definition = "A method that makes the locally best choice at each step in the hope of reaching a good global answer.",
            definitionNative = "Метод, который на каждом шаге берёт локально лучший вариант в надежде получить хороший общий ответ.",
            example = "A simple greedy algorithm picks the largest coin that still fits and works for standard money.",
            exampleNative = "Простой greedy algorithm берёт самую крупную из подходящих монет и работает для обычной валюты.",
            rarity = "EPIC", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_concepts", fillInBlankExclusions = listOf(46416L, 46417L, 46418L, 46420L, 46421L)),
        WordEntity(
            id = 46420, original = "brute force", transliteration = "[bruːt fɔːrs]", translation = "перебор / грубая сила",
            definition = "A straightforward approach that tries every possible option until the correct one shows up.",
            definitionNative = "Прямолинейный подход: пробуем все возможные варианты по очереди, пока не найдётся правильный.",
            example = "We solved the first version of the puzzle by brute force, then looked for a smarter approach.",
            exampleNative = "Первую версию задачи мы решили brute force, а потом стали искать более умный подход.",
            rarity = "EPIC", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_concepts", fillInBlankExclusions = listOf(46416L, 46417L, 46418L, 46419L, 46421L)),
        WordEntity(
            id = 46421, original = "encapsulation", transliteration = "[ɪnˌkæpsjəˈleɪʃən]", translation = "инкапсуляция",
            definition = "The OOP practice of hiding an object's internal data behind a clean public interface.",
            definitionNative = "Практика ООП: внутренние данные объекта скрыты за чистым внешним интерфейсом.",
            example = "Strict encapsulation kept other modules from reaching into the cache and corrupting its state.",
            exampleNative = "Строгая encapsulation не давала другим модулям лезть в кеш и портить его состояние.",
            rarity = "EPIC", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_concepts", fillInBlankExclusions = listOf(46416L, 46417L, 46418L, 46419L, 46420L)),

        // ── tech_algo_lowlevel (низкоуровневые понятия времени выполнения) ────
        WordEntity(
            id = 46422, original = "race condition", transliteration = "[reɪs kənˈdɪʃən]", translation = "состояние гонки",
            definition = "A bug where the result depends on the unpredictable order in which threads happen to run.",
            definitionNative = "Баг, при котором результат зависит от непредсказуемого порядка выполнения потоков.",
            example = "An intermittent race condition was corrupting the counter only when the server was under heavy load.",
            exampleNative = "Прерывистый race condition портил счётчик только тогда, когда сервер был под сильной нагрузкой.",
            rarity = "EPIC", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_lowlevel", fillInBlankExclusions = listOf(46423L, 46424L, 46425L)),
        WordEntity(
            id = 46423, original = "syscall", transliteration = "[ˈsɪsˌkɔːl]", translation = "системный вызов",
            definition = "A request from a program to the operating-system kernel to perform something like reading a file or opening a socket.",
            definitionNative = "Запрос программы к ядру операционной системы: например, прочитать файл или открыть сокет.",
            example = "Tracing every syscall the binary made quickly showed where the program was spending its time.",
            exampleNative = "Трассировка каждого syscall программы быстро показала, где она тратит время.",
            rarity = "EPIC", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_lowlevel", fillInBlankExclusions = listOf(46422L, 46424L, 46425L)),
        WordEntity(
            id = 46424, original = "stack frame", transliteration = "[stæk freɪm]", translation = "кадр стека вызовов",
            definition = "The chunk of memory on the call stack that holds one function's local variables and return address.",
            definitionNative = "Кусок памяти на стеке вызовов: хранит локальные переменные одной функции и адрес возврата.",
            example = "The crash dump showed a deeply nested stack frame from the recursive parser at failure time.",
            exampleNative = "Дамп падения показал глубоко вложенный stack frame из рекурсивного парсера в момент сбоя.",
            rarity = "EPIC", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_lowlevel", fillInBlankExclusions = listOf(46422L, 46423L, 46425L)),
        WordEntity(
            id = 46425, original = "abstract class", transliteration = "[ˈæbstrækt klæs]", translation = "абстрактный класс",
            definition = "A class that cannot be instantiated on its own and exists only to be extended by concrete subclasses.",
            definitionNative = "Класс, который нельзя создать напрямую: существует только для того, чтобы от него наследовались конкретные подклассы.",
            example = "The base shape is an abstract class, so each concrete figure must implement its own area method.",
            exampleNative = "Базовая фигура — это abstract class, поэтому каждая конкретная фигура должна реализовать метод площади.",
            rarity = "EPIC", setId = 464, languagePair = "en-ru", pos = "noun",
            semanticGroup = "tech_algo_lowlevel", fillInBlankExclusions = listOf(46422L, 46423L, 46424L)),
    )
}
