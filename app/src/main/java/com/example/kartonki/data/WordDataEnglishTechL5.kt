package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Технологии (level 5, носитель языка).
 *
 * Set 340: «Технологии: носитель языка» — высокая техническая лексика
 * (компиляторы, протоколы, криптография, специальные термины разработки) C2+.
 *
 * Распределение редкости: 5 EPIC + 20 LEGENDARY — два смежных уровня.
 *
 * Дополняет уже существующие сеты темы «Технологии» (en-ru):
 *   - Set 18  (WordDataEnglish.kt)         — L1 COMMON.
 *   - Set 234 (WordDataEnglishExpanded.kt) — L2 COMMON/UNCOMMON.
 *   - Set 235 (WordDataEnglishExpanded.kt) — L3 RARE/EPIC.
 *   - Set 247 (WordDataEnglishExpanded.kt) — L4 RARE/EPIC.
 *   - Set 249 (WordDataEnglishExpanded.kt) — L2 UNCOMMON/RARE (геймерская лексика).
 *
 * Слова setId=340 не пересекаются ни с одним из этих наборов (проверено grep).
 *
 * SemanticGroups (5 × 5):
 *   tech_paradigms      — monad, functor, currying, memoization, closure
 *   tech_theory         — halting, lambda, idempotent, NP-complete, big-O
 *   tech_protocols      — handshake, payload, deprecation, reentrant, thread-safe
 *   tech_observability  — instrumentation, observability, telemetry, lock-free, mutex
 *   tech_infrastructure — orchestration, kubernetes, hypervisor, semaphore, deadlock
 *
 * Word IDs: 34001..34025 (setId × 100 + position).
 */
object WordDataEnglishTechL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 340, name = "Технологии",
            description = "Высокая техническая лексика: компиляторы, протоколы, криптография, специальные термины разработки",
            languagePair = "en-ru",
            topic = "Технологии", level = 5),
    )

    val words: List<WordEntity> = listOf(

        // ── tech_paradigms (5) ────────────────────────────────────────────

        WordEntity(id = 34001, setId = 340, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "monad", transliteration = "[ˈmɑnæd]", translation = "монада (контейнер вычисления)",
            definition = "An abstract structure that wraps a value and rules for chaining computations on it.",
            definitionNative = "Абстрактная структура, оборачивающая значение и правила цепочечных вычислений над ним.",
            example = "Haskell uses a monad to handle side effects in pure functional code.",
            exampleNative = "Haskell использует monad для обработки эффектов в чистом функциональном коде.",
            pos = "noun", semanticGroup = "tech_paradigms", fillInBlankExclusions = listOf(34002L, 34003L, 34004L, 34005L, 34007L)),

        WordEntity(id = 34002, setId = 340, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "functor", transliteration = "[ˈfʌŋktər]", translation = "функтор (отображение, сохраняющее структуру)",
            definition = "A type with a mapping function that preserves identity and composition rules.",
            definitionNative = "Тип с функцией отображения, сохраняющей правила тождества и композиции.",
            example = "A list is the simplest functor — mapping a function over each element.",
            exampleNative = "Список — простейший functor: отображение функции на каждый элемент.",
            pos = "noun", semanticGroup = "tech_paradigms", fillInBlankExclusions = listOf(34001L, 34003L, 34004L, 34005L)),

        WordEntity(id = 34003, setId = 340, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "currying", transliteration = "[ˈkɜːriɪŋ]", translation = "каррирование (преобразование функции в цепочку одноместных)",
            definition = "Turning a function of many arguments into a chain of single-argument functions.",
            definitionNative = "Превращение функции от нескольких аргументов в цепочку одноаргументных функций.",
            example = "Through currying, add(two, three) becomes add(two)(three) in stages.",
            exampleNative = "Через currying функция от двух аргументов разбивается на две по одному.",
            pos = "noun", semanticGroup = "tech_paradigms", fillInBlankExclusions = listOf(34001L, 34002L, 34004L, 34005L)),

        WordEntity(id = 34004, setId = 340, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "memoization", transliteration = "[ˌmɛməwaɪˈzeɪʃən]", translation = "мемоизация (кэширование результатов функции)",
            definition = "An optimisation that stores results of pure function calls to skip recomputing them.",
            definitionNative = "Оптимизация, сохраняющая результаты чистых вызовов функции, чтобы не считать заново.",
            example = "Adding memoization cut the recursive Fibonacci runtime from minutes to milliseconds.",
            exampleNative = "Memoization сократила рекурсивный Фибоначчи с минут до миллисекунд.",
            pos = "noun", semanticGroup = "tech_paradigms", fillInBlankExclusions = listOf(34001L, 34002L, 34003L, 34005L)),

        WordEntity(id = 34005, setId = 340, languagePair = "en-ru", rarity = "EPIC",
            original = "closure", transliteration = "[ˈkloʊʒər]", translation = "замыкание (функция со связанным окружением)",
            definition = "A function bundled with the variables from the scope where it was defined.",
            definitionNative = "Функция вместе с переменными из области, где она была определена.",
            example = "The closure remembered the counter value even after the outer function had returned.",
            exampleNative = "Closure сохраняла счётчик даже после возврата из внешней функции.",
            pos = "noun", semanticGroup = "tech_paradigms", fillInBlankExclusions = listOf(34001L, 34002L, 34003L, 34004L, 34007L)),

        // ── tech_theory (5) ───────────────────────────────────────────────

        WordEntity(id = 34006, setId = 340, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "halting", transliteration = "[ˈhɔltɪŋ]", translation = "остановка (программы — формальная задача теории)",
            definition = "The classical question of whether an arbitrary program will eventually stop running.",
            definitionNative = "Классическая задача: остановится ли произвольная программа за конечное время.",
            example = "The famous halting problem cannot be solved by any general algorithm.",
            exampleNative = "Знаменитая halting задача не решается никаким общим алгоритмом.",
            pos = "noun", semanticGroup = "tech_theory", fillInBlankExclusions = listOf(34007L, 34010L)),

        WordEntity(id = 34007, setId = 340, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "lambda", transliteration = "[ˈlæmdə]", translation = "лямбда (анонимная функция)",
            definition = "A small unnamed function defined inline and often passed to other functions.",
            definitionNative = "Короткая безымянная функция, определённая на месте и часто передаваемая дальше.",
            example = "She passed a lambda to filter the list of even numbers in one line.",
            exampleNative = "Она передала lambda для отбора чётных чисел из списка одной строкой.",
            pos = "noun", semanticGroup = "tech_theory", fillInBlankExclusions = listOf(34005L, 34006L, 34010L)),

        WordEntity(id = 34008, setId = 340, languagePair = "en-ru", rarity = "EPIC",
            original = "idempotent", transliteration = "[ˌaɪdɛmˈpoʊtənt]", translation = "идемпотентный (повторный вызов даёт тот же результат)",
            definition = "Producing the same result no matter how many times the operation is repeated.",
            definitionNative = "Дающий один и тот же результат, сколько бы раз операцию ни повторили.",
            example = "A delete request should be idempotent so retries do not corrupt the database.",
            exampleNative = "Запрос на удаление должен быть idempotent, чтобы повторы не портили базу.",
            pos = "adjective", semanticGroup = "tech_theory", fillInBlankExclusions = listOf(34009L)),

        WordEntity(id = 34009, setId = 340, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "NP-complete", transliteration = "[ˌɛn piː kəmˈpliːt]", translation = "NP-полный (класс сложности задач)",
            definition = "Belonging to the hardest set of problems whose solutions can be quickly checked.",
            definitionNative = "Из класса самых сложных задач, чьи решения можно быстро проверить.",
            example = "The travelling salesman puzzle is NP-complete and resists fast exact solvers.",
            exampleNative = "Задача коммивояжёра NP-complete и не сдаётся быстрым точным алгоритмам.",
            pos = "adjective", semanticGroup = "tech_theory", fillInBlankExclusions = listOf(34008L)),

        WordEntity(id = 34010, setId = 340, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "big-O", transliteration = "[ˌbɪɡ ˈoʊ]", translation = "О-большое (асимптотическая оценка сложности)",
            definition = "The standard way to describe how an algorithm scales as input size grows.",
            definitionNative = "Стандартная запись роста времени или памяти алгоритма с увеличением входа.",
            example = "Quicksort runs in big-O of n log n on average inputs.",
            exampleNative = "Быстрая сортировка работает в big-O от n log n на средних данных.",
            pos = "noun", semanticGroup = "tech_theory", fillInBlankExclusions = listOf(34006L, 34007L)),

        // ── tech_protocols (5) ────────────────────────────────────────────

        WordEntity(id = 34011, setId = 340, languagePair = "en-ru", rarity = "EPIC",
            original = "handshake", transliteration = "[ˈhændˌʃeɪk]", translation = "рукопожатие (протокола)",
            definition = "An opening exchange of messages where two systems agree on rules of a session.",
            definitionNative = "Начальный обмен сообщениями, где две системы договариваются о правилах сеанса.",
            example = "The TLS handshake negotiates ciphers and exchanges keys before any data flows.",
            exampleNative = "TLS handshake согласует шифры и ключи до начала передачи данных.",
            pos = "noun", semanticGroup = "tech_protocols", fillInBlankExclusions = listOf(34012L, 34013L)),

        WordEntity(id = 34012, setId = 340, languagePair = "en-ru", rarity = "EPIC",
            original = "payload", transliteration = "[ˈpeɪˌloʊd]", translation = "полезная нагрузка (данные сообщения)",
            definition = "The actual data carried inside a network packet or message, minus the headers.",
            definitionNative = "Собственно данные внутри пакета или сообщения, без служебных заголовков.",
            example = "The API rejects any payload larger than five megabytes per request.",
            exampleNative = "API отвергает любую payload больше пяти мегабайт за один запрос.",
            pos = "noun", semanticGroup = "tech_protocols", fillInBlankExclusions = listOf(34011L, 34013L)),

        WordEntity(id = 34013, setId = 340, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "deprecation", transliteration = "[ˌdɛprɪˈkeɪʃən]", translation = "вывод из употребления (объявление устаревшим)",
            definition = "An official notice that a feature still works but should no longer be used.",
            definitionNative = "Официальное уведомление, что возможность работает, но использовать её не стоит.",
            example = "The library announced deprecation of the old function in next year's release.",
            exampleNative = "Библиотека объявила deprecation старой функции в выпуске следующего года.",
            pos = "noun", semanticGroup = "tech_protocols", fillInBlankExclusions = listOf(34011L, 34012L)),

        WordEntity(id = 34014, setId = 340, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "reentrant", transliteration = "[riˈɛntrənt]", translation = "реентерабельный (безопасный для повторного входа)",
            definition = "Safe to interrupt mid-execution and call again without corrupting its own state.",
            definitionNative = "Безопасный для прерывания и повторного вызова без порчи собственного состояния.",
            example = "Interrupt handlers must be reentrant or the kernel will eventually crash.",
            exampleNative = "Обработчики прерываний обязаны быть reentrant, иначе ядро рухнет.",
            pos = "adjective", semanticGroup = "tech_protocols", fillInBlankExclusions = listOf(34008L, 34015L, 34019L)),

        WordEntity(id = 34015, setId = 340, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "thread-safe", transliteration = "[ˈθrɛd ˌseɪf]", translation = "потокобезопасный (корректный при параллельном доступе)",
            definition = "Behaving correctly when several threads access the same code or data at once.",
            definitionNative = "Работающий верно, когда несколько потоков обращаются к коду или данным одновременно.",
            example = "Make the counter thread-safe before exposing it to the worker pool.",
            exampleNative = "Сделай счётчик thread-safe, прежде чем открывать его пулу воркеров.",
            pos = "adjective", semanticGroup = "tech_protocols", fillInBlankExclusions = listOf(34008L, 34014L, 34019L)),

        // ── tech_observability (5) ────────────────────────────────────────

        WordEntity(id = 34016, setId = 340, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "instrumentation", transliteration = "[ˌɪnstrəmɛnˈteɪʃən]", translation = "инструментирование (внедрение метрик в код)",
            definition = "The added code that emits metrics, traces and logs from a running system.",
            definitionNative = "Код, добавленный для отправки метрик, трасс и логов из работающей системы.",
            example = "Careful instrumentation revealed the slow database query under heavy load.",
            exampleNative = "Аккуратное instrumentation выявило медленный запрос под нагрузкой.",
            pos = "noun", semanticGroup = "tech_observability", fillInBlankExclusions = listOf(34017L, 34018L, 34020L)),

        WordEntity(id = 34017, setId = 340, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "observability", transliteration = "[əbˌzɜrvəˈbɪləti]", translation = "наблюдаемость (видимость состояния системы извне)",
            definition = "How well the inner state of a system can be inferred from its outside signals.",
            definitionNative = "Насколько по внешним сигналам можно судить о внутреннем состоянии системы.",
            example = "Good observability lets engineers diagnose outages without redeploying anything.",
            exampleNative = "Хорошая observability помогает инженерам ловить сбои без перевыкатки.",
            pos = "noun", semanticGroup = "tech_observability", fillInBlankExclusions = listOf(34016L, 34018L, 34020L)),

        WordEntity(id = 34018, setId = 340, languagePair = "en-ru", rarity = "EPIC",
            original = "telemetry", transliteration = "[təˈlɛmətri]", translation = "телеметрия (данные о работе системы)",
            definition = "Automatic collection and remote transmission of measurements about a system.",
            definitionNative = "Автоматический сбор и удалённая передача измерений о работе системы.",
            example = "App telemetry showed battery drain spiked after the latest firmware update.",
            exampleNative = "Telemetry приложения показала рост расхода батареи после обновления.",
            pos = "noun", semanticGroup = "tech_observability", fillInBlankExclusions = listOf(34016L, 34017L, 34020L)),

        WordEntity(id = 34019, setId = 340, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "lock-free", transliteration = "[ˈlɑk ˌfri]", translation = "без блокировок (алгоритм без mutex)",
            definition = "Designed so threads make progress without waiting on one another's locks.",
            definitionNative = "Сделанный так, что потоки продвигаются, не ожидая чужих блокировок.",
            example = "The lock-free queue let producers and consumers work without stalls.",
            exampleNative = "Lock-free очередь позволила производителям и потребителям работать без пауз.",
            pos = "adjective", semanticGroup = "tech_observability", fillInBlankExclusions = listOf(34014L, 34015L)),

        WordEntity(id = 34020, setId = 340, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "mutex", transliteration = "[ˈmjuːtɛks]", translation = "мьютекс (объект взаимного исключения)",
            definition = "A lock that lets only one thread enter a protected section at a time.",
            definitionNative = "Замок, пускающий в защищённый участок только один поток за раз.",
            example = "Wrap shared state with a mutex to keep concurrent writes from clashing.",
            exampleNative = "Оберните общие данные mutex, чтобы параллельные записи не сталкивались.",
            pos = "noun", semanticGroup = "tech_observability", fillInBlankExclusions = listOf(34018L, 34024L)),

        // ── tech_infrastructure (5) ───────────────────────────────────────

        WordEntity(id = 34021, setId = 340, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "orchestration", transliteration = "[ˌɔrkəˈstreɪʃən]", translation = "оркестрация (координация работы сервисов)",
            definition = "Coordinated automation that schedules, scales and connects many running services.",
            definitionNative = "Согласованная автоматика, запускающая, масштабирующая и соединяющая множество сервисов.",
            example = "Container orchestration moved workloads to fresh nodes when machines failed.",
            exampleNative = "Orchestration контейнеров переносила нагрузку на свежие узлы при отказах.",
            pos = "noun", semanticGroup = "tech_infrastructure", fillInBlankExclusions = listOf(34022L, 34023L, 34024L, 34025L)),

        WordEntity(id = 34022, setId = 340, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "kubernetes", transliteration = "[ˌkuːbərˈnɛtəs]", translation = "Kubernetes (платформа оркестрации контейнеров)",
            definition = "An open-source platform that runs and manages containerised workloads at scale.",
            definitionNative = "Платформа с открытым кодом, запускающая и управляющая контейнерами в масштабе.",
            example = "The team migrated its services to kubernetes for automatic scaling and recovery.",
            exampleNative = "Команда перевела сервисы на kubernetes ради авто-масштабирования и восстановления.",
            pos = "noun", semanticGroup = "tech_infrastructure", fillInBlankExclusions = listOf(34021L, 34023L, 34024L, 34025L)),

        WordEntity(id = 34023, setId = 340, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hypervisor", transliteration = "[ˈhaɪpərˌvaɪzər]", translation = "гипервизор (управляющий виртуальными машинами)",
            definition = "A control layer that runs many isolated virtual machines on one physical host.",
            definitionNative = "Управляющий слой, запускающий много изолированных виртуальных машин на одном железе.",
            example = "The hypervisor allocated CPU time fairly across a dozen tenant servers.",
            exampleNative = "Hypervisor распределял время процессора между дюжиной арендуемых серверов.",
            pos = "noun", semanticGroup = "tech_infrastructure", fillInBlankExclusions = listOf(34021L, 34022L, 34024L, 34025L)),

        WordEntity(id = 34024, setId = 340, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "semaphore", transliteration = "[ˈsɛməˌfɔr]", translation = "семафор (счётный примитив синхронизации)",
            definition = "A counter primitive that limits how many threads may enter a shared resource.",
            definitionNative = "Счётный примитив, ограничивающий число потоков, входящих в общий ресурс.",
            example = "A semaphore capped database connections at twenty during the traffic spike.",
            exampleNative = "Semaphore удержал число соединений к базе на двадцати во время пика.",
            pos = "noun", semanticGroup = "tech_infrastructure", fillInBlankExclusions = listOf(34022L, 34023L, 34025L)),

        WordEntity(id = 34025, setId = 340, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "deadlock", transliteration = "[ˈdɛdˌlɑk]", translation = "взаимная блокировка (потоков, ждущих друг друга)",
            definition = "A frozen state where threads each wait for a resource held by another forever.",
            definitionNative = "Зависание, когда потоки бесконечно ждут ресурсы, удерживаемые друг другом.",
            example = "A classic deadlock froze both worker threads holding each other's locks.",
            exampleNative = "Классический deadlock заморозил оба воркера, удерживающие чужие замки.",
            pos = "noun", semanticGroup = "tech_infrastructure", fillInBlankExclusions = listOf(34021L, 34022L, 34023L, 34024L)),
    )
}
