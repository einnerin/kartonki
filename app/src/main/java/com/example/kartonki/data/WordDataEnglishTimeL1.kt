package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Время и календарь (L1, COMMON+UNCOMMON).
 *
 * Set 385: «Время и календарь» — основы.
 *          Базовые понятия о времени и календаре: периоды, ориентиры в сутках,
 *          относительные слова и частотность. Без дней недели и месяцев —
 *          они уже покрыты старой темой «Повседневная жизнь» (set 264).
 *
 * Тема «Время и календарь» — отдельная от старой темы «Повседневная жизнь»
 * (set 264 «Дни недели, время суток и слова о времени»). Все 25 слов этого
 * сета не пересекаются с уже существующими английскими словами в базе
 * (проверено grep'ом по `original = "..."`). Поэтому пришлось обойти
 * базовые лексемы (hour, minute, day, week, month, year, today, tomorrow,
 * morning, evening, night, midnight, noon, dawn, dusk, weekend, always,
 * often, never, sometimes, now) и взять смежные понятия того же уровня.
 *
 * Распределение редкости: 18 COMMON + 7 UNCOMMON — два смежных уровня (A1 + A2).
 *
 * SemanticGroups (5 × 5):
 *   time_l1_units    — time, moment, period, age, timer
 *   time_l1_calendar — calendar, vacation, event, weekday, midweek
 *   time_l1_dayparts — midday, tonight, daytime, daylight, twilight
 *   time_l1_relative — soon, later, ago, still, recent
 *   time_l1_freq     — usually, rarely, regular, monthly, yearly
 *
 * Word IDs: setId × 100 + position (38501..38525).
 *
 * isFillInBlankSafe = false на всех словах. fillInBlankExclusions пустые —
 * заполнятся через FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataEnglishTimeL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 385,
            languagePair = "en-ru",
            orderIndex = 385,
            name = "Время и календарь",
            description = "Часы, дни, месяцы и базовые ориентиры во времени",
            topic = "Время и календарь",
            level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 385 — Время и календарь: основы (L1, COMMON+UNCOMMON)        ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── time_l1_units (5) ─────────────────────────────────────────────

        WordEntity(id = 38501, setId = 385, languagePair = "en-ru", rarity = "COMMON",
            original = "time", transliteration = "[taɪm]", translation = "время",
            definition = "What clocks measure — the steady flow of seconds, minutes and hours.",
            definitionNative = "То, что показывают часы — ровный поток секунд, минут и часов.",
            example = "I don't have much time before the meeting starts.",
            exampleNative = "У меня осталось мало time до начала встречи.",
            pos = "noun", semanticGroup = "time_l1_units", fillInBlankExclusions = listOf(38502L, 38503L, 38504L, 38505L)),

        WordEntity(id = 38502, setId = 385, languagePair = "en-ru", rarity = "COMMON",
            original = "moment", transliteration = "[ˈmoʊmənt]", translation = "момент",
            definition = "A very short bit of time — just a heartbeat or two.",
            definitionNative = "Очень короткий отрезок времени — буквально на пару ударов сердца.",
            example = "Wait a moment — I need to grab my keys.",
            exampleNative = "Подожди один moment — мне нужно взять ключи.",
            pos = "noun", semanticGroup = "time_l1_units", fillInBlankExclusions = listOf(38501L, 38503L, 38505L)),

        WordEntity(id = 38503, setId = 385, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "period", transliteration = "[ˈpɪriəd]", translation = "период",
            definition = "A stretch of time with a clear start and end — like a school lesson.",
            definitionNative = "Отрезок времени с понятным началом и концом — как один школьный урок.",
            example = "We lived in Madrid for a short period after the wedding.",
            exampleNative = "Мы прожили в Мадриде короткий period после свадьбы.",
            pos = "noun", semanticGroup = "time_l1_units", fillInBlankExclusions = listOf(38501L, 38502L, 38504L, 38505L)),

        WordEntity(id = 38504, setId = 385, languagePair = "en-ru", rarity = "COMMON",
            original = "age", transliteration = "[eɪʤ]", translation = "возраст",
            definition = "How many years a person, animal or thing has already lived.",
            definitionNative = "Сколько лет уже прожил человек, животное или вещь.",
            example = "What is the age of your youngest brother?",
            exampleNative = "Какой age у твоего младшего брата?",
            pos = "noun", semanticGroup = "time_l1_units", fillInBlankExclusions = listOf(38501L, 38502L, 38503L, 38505L)),

        WordEntity(id = 38505, setId = 385, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "timer", transliteration = "[ˈtaɪmər]", translation = "таймер",
            definition = "A small device that counts seconds and beeps when the time is up.",
            definitionNative = "Маленькое устройство, которое отсчитывает секунды и пищит, когда время вышло.",
            example = "Set a timer for ten minutes so the pasta doesn't overcook.",
            exampleNative = "Поставь timer на десять минут, чтобы паста не переварилась.",
            pos = "noun", semanticGroup = "time_l1_units", fillInBlankExclusions = listOf(38501L, 38502L, 38503L)),

        // ── time_l1_calendar (5) ──────────────────────────────────────────

        WordEntity(id = 38506, setId = 385, languagePair = "en-ru", rarity = "COMMON",
            original = "calendar", transliteration = "[ˈkæləndər]", translation = "календарь",
            definition = "A grid of days and months that helps you plan the whole year.",
            definitionNative = "Сетка из дней и месяцев — помогает планировать весь год.",
            example = "I marked our anniversary on the kitchen calendar.",
            exampleNative = "Я отметил нашу годовщину на кухонном calendar.",
            pos = "noun", semanticGroup = "time_l1_calendar", fillInBlankExclusions = listOf(38507L, 38508L, 38509L)),

        WordEntity(id = 38507, setId = 385, languagePair = "en-ru", rarity = "COMMON",
            original = "vacation", transliteration = "[veɪˈkeɪʃən]", translation = "отпуск",
            definition = "Days off from work or school — used to travel, relax or visit family.",
            definitionNative = "Дни без работы или учёбы — обычно для путешествий, отдыха или семьи.",
            example = "We are going on a long vacation to the mountains.",
            exampleNative = "Мы едем в долгий vacation в горы.",
            pos = "noun", semanticGroup = "time_l1_calendar", fillInBlankExclusions = listOf(38506L, 38508L, 38509L)),

        WordEntity(id = 38508, setId = 385, languagePair = "en-ru", rarity = "COMMON",
            original = "event", transliteration = "[ɪˈvɛnt]", translation = "событие",
            definition = "Something planned or important that happens on a specific date.",
            definitionNative = "Что-то запланированное или важное, что происходит в конкретную дату.",
            example = "The wedding will be the biggest event of the summer.",
            exampleNative = "Свадьба станет главным event этого лета.",
            pos = "noun", semanticGroup = "time_l1_calendar", fillInBlankExclusions = listOf(38502L, 38506L, 38507L, 38509L)),

        WordEntity(id = 38509, setId = 385, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "weekday", transliteration = "[ˈwikˌdeɪ]", translation = "будний день",
            definition = "Any day from Monday to Friday — when most people go to work.",
            definitionNative = "Любой день с понедельника по пятницу — когда большинство ходит на работу.",
            example = "The cafe is quieter on a weekday than on Sunday.",
            exampleNative = "В кафе тише в weekday, чем в воскресенье.",
            pos = "noun", semanticGroup = "time_l1_calendar", fillInBlankExclusions = listOf(38506L, 38507L)),

        WordEntity(id = 38510, setId = 385, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "midweek", transliteration = "[ˌmɪdˈwik]", translation = "середина недели",
            definition = "The middle of the working week — usually Tuesday or Wednesday.",
            definitionNative = "Середина рабочей недели — обычно вторник или среда.",
            example = "Let's grab dinner midweek when the restaurants are empty.",
            exampleNative = "Давай поужинаем в midweek, когда в ресторанах пусто.",
            pos = "adverb", semanticGroup = "time_l1_calendar", fillInBlankExclusions = listOf(38511L, 38512L, 38516L, 38517L)),

        // ── time_l1_dayparts (5) ──────────────────────────────────────────

        WordEntity(id = 38511, setId = 385, languagePair = "en-ru", rarity = "COMMON",
            original = "midday", transliteration = "[ˌmɪdˈdeɪ]", translation = "полдень",
            definition = "The middle of the daytime — when the sun stands the highest.",
            definitionNative = "Середина светлого времени суток — когда солнце стоит выше всего.",
            example = "We met for lunch at midday near the fountain.",
            exampleNative = "Мы встретились на обед в midday у фонтана.",
            pos = "noun", semanticGroup = "time_l1_dayparts", fillInBlankExclusions = listOf(38513L, 38514L, 38515L)),

        WordEntity(id = 38512, setId = 385, languagePair = "en-ru", rarity = "COMMON",
            original = "tonight", transliteration = "[təˈnaɪt]", translation = "сегодня вечером",
            definition = "The evening and night of the current day — the hours just ahead.",
            definitionNative = "Вечер и ночь именно сегодняшнего дня — ближайшие часы впереди.",
            example = "Are you free tonight for a movie?",
            exampleNative = "Ты свободен tonight, чтобы сходить в кино?",
            pos = "adverb", semanticGroup = "time_l1_dayparts", fillInBlankExclusions = listOf(38510L, 38511L, 38517L)),

        WordEntity(id = 38513, setId = 385, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "daytime", transliteration = "[ˈdeɪˌtaɪm]", translation = "дневное время",
            definition = "The bright hours between sunrise and sunset.",
            definitionNative = "Светлые часы между восходом и закатом — пока солнце над горизонтом.",
            example = "Owls sleep during the daytime and hunt at night.",
            exampleNative = "Совы спят в daytime, а охотятся ночью.",
            pos = "noun", semanticGroup = "time_l1_dayparts", fillInBlankExclusions = listOf(38511L, 38514L, 38515L)),

        WordEntity(id = 38514, setId = 385, languagePair = "en-ru", rarity = "COMMON",
            original = "daylight", transliteration = "[ˈdeɪˌlaɪt]", translation = "дневной свет",
            definition = "The natural light from the sky during the day.",
            definitionNative = "Натуральный свет с неба в светлое время суток.",
            example = "I prefer to read by daylight near the window.",
            exampleNative = "Я предпочитаю читать при daylight у окна.",
            pos = "noun", semanticGroup = "time_l1_dayparts", fillInBlankExclusions = listOf(38511L, 38513L, 38515L)),

        WordEntity(id = 38515, setId = 385, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "twilight", transliteration = "[ˈtwaɪˌlaɪt]", translation = "сумерки",
            definition = "The soft light right before night, when colours fade to grey.",
            definitionNative = "Мягкий свет перед самой ночью, когда цвета становятся серыми.",
            example = "We finished the hike just as twilight was falling.",
            exampleNative = "Мы закончили поход прямо в twilight.",
            pos = "noun", semanticGroup = "time_l1_dayparts", fillInBlankExclusions = listOf(38511L, 38513L, 38514L)),

        // ── time_l1_relative (5) ──────────────────────────────────────────

        WordEntity(id = 38516, setId = 385, languagePair = "en-ru", rarity = "COMMON",
            original = "soon", transliteration = "[sun]", translation = "скоро",
            definition = "After a short bit of time — not right now, but very close.",
            definitionNative = "Через короткое время — не сейчас, но уже вот-вот.",
            example = "The train will arrive soon, get your bag ready.",
            exampleNative = "Поезд приедет soon, готовь сумку.",
            pos = "adverb", semanticGroup = "time_l1_relative", fillInBlankExclusions = listOf(38510L, 38512L, 38517L, 38518L, 38519L)),

        WordEntity(id = 38517, setId = 385, languagePair = "en-ru", rarity = "COMMON",
            original = "later", transliteration = "[ˈleɪtər]", translation = "позже",
            definition = "At some time after now — not immediately but at a future moment.",
            definitionNative = "В какое-то время после сейчас — не сразу, а позднее.",
            example = "We can finish the puzzle later — dinner is ready.",
            exampleNative = "Мы доделаем пазл later — ужин уже готов.",
            pos = "adverb", semanticGroup = "time_l1_relative", fillInBlankExclusions = listOf(38510L, 38512L, 38516L, 38518L, 38519L)),

        WordEntity(id = 38518, setId = 385, languagePair = "en-ru", rarity = "COMMON",
            original = "ago", transliteration = "[əˈɡoʊ]", translation = "тому назад",
            definition = "Used to count how long ago something happened — three days, two years.",
            definitionNative = "Используется, чтобы посчитать, сколько прошло — три дня, два года.",
            example = "I saw your sister at the cafe two days ago.",
            exampleNative = "Я видел твою сестру в кафе два дня ago.",
            pos = "adverb", semanticGroup = "time_l1_relative", fillInBlankExclusions = listOf(38516L, 38517L, 38519L)),

        WordEntity(id = 38519, setId = 385, languagePair = "en-ru", rarity = "COMMON",
            original = "still", transliteration = "[stɪl]", translation = "всё ещё",
            definition = "Used when something keeps going on right up to now.",
            definitionNative = "Используется, когда что-то продолжается прямо до настоящего момента.",
            example = "Are you still working on the same report?",
            exampleNative = "Ты still делаешь тот же отчёт?",
            pos = "adverb", semanticGroup = "time_l1_relative", fillInBlankExclusions = listOf(38516L, 38517L, 38518L, 38521L, 38522L)),

        WordEntity(id = 38520, setId = 385, languagePair = "en-ru", rarity = "COMMON",
            original = "recent", transliteration = "[ˈrisənt]", translation = "недавний",
            definition = "Happening a short time before now — fresh in memory.",
            definitionNative = "Произошедший незадолго до сейчас — ещё свежий в памяти.",
            example = "Have you read the recent news from the south?",
            exampleNative = "Ты читал recent новости с юга?",
            pos = "adjective", semanticGroup = "time_l1_relative", fillInBlankExclusions = listOf(38523L, 38524L, 38525L)),

        // ── time_l1_freq (5) ──────────────────────────────────────────────

        WordEntity(id = 38521, setId = 385, languagePair = "en-ru", rarity = "COMMON",
            original = "usually", transliteration = "[ˈjuʒəwəli]", translation = "обычно",
            definition = "In most cases — about how things normally go.",
            definitionNative = "В большинстве случаев — про то, как чаще всего бывает.",
            example = "I usually drink coffee right after I wake up.",
            exampleNative = "Я usually пью кофе сразу после пробуждения.",
            pos = "adverb", semanticGroup = "time_l1_freq", fillInBlankExclusions = listOf(38519L, 38522L)),

        WordEntity(id = 38522, setId = 385, languagePair = "en-ru", rarity = "COMMON",
            original = "rarely", transliteration = "[ˈrɛrli]", translation = "редко",
            definition = "Almost never — only on a few days out of many.",
            definitionNative = "Почти никогда — только в редкие дни из многих.",
            example = "She rarely eats dessert after dinner.",
            exampleNative = "Она rarely ест десерт после ужина.",
            pos = "adverb", semanticGroup = "time_l1_freq", fillInBlankExclusions = listOf(38519L, 38521L)),

        WordEntity(id = 38523, setId = 385, languagePair = "en-ru", rarity = "COMMON",
            original = "regular", transliteration = "[ˈrɛɡjələr]", translation = "регулярный",
            definition = "Happening at the same times again and again — like clockwork.",
            definitionNative = "Происходящий снова и снова в одни и те же моменты — как по часам.",
            example = "He has a regular check-up at the dentist every spring.",
            exampleNative = "У него regular осмотр у стоматолога каждую весну.",
            pos = "adjective", semanticGroup = "time_l1_freq", fillInBlankExclusions = listOf(38520L, 38524L, 38525L)),

        WordEntity(id = 38524, setId = 385, languagePair = "en-ru", rarity = "COMMON",
            original = "monthly", transliteration = "[ˈmənθli]", translation = "ежемесячный",
            definition = "Happening once every month — like a salary or a magazine.",
            definitionNative = "Происходящий раз в месяц — как зарплата или журнал.",
            example = "We pay the rent on a monthly basis.",
            exampleNative = "Мы платим аренду на monthly основе.",
            pos = "adjective", semanticGroup = "time_l1_freq", fillInBlankExclusions = listOf(38523L, 38525L)),

        WordEntity(id = 38525, setId = 385, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "yearly", transliteration = "[ˈjɪrli]", translation = "ежегодный",
            definition = "Happening one time each year — like a birthday or a check-up.",
            definitionNative = "Происходящий один раз в каждом году — как день рождения или ежегодный осмотр.",
            example = "We have a yearly family trip to the lake.",
            exampleNative = "У нас yearly семейная поездка на озеро.",
            pos = "adjective", semanticGroup = "time_l1_freq", fillInBlankExclusions = listOf(38520L, 38523L, 38524L)),
    )
}
