package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Время и календарь (L3, RARE+EPIC).
 *
 * Set 387: «Время и календарь» — углублённый.
 *          Хронология, специальные единицы, научные временные термины,
 *          формальные/книжные ориентиры B2-C1.
 *
 * Тема «Время и календарь» — продолжение L1 (set 385) и L2 (set 386).
 * Все 25 слов этого сета не пересекаются с уже существующими английскими
 * словами в базе (проверено grep'ом по `original = "..."`). Обойдены, в
 * частности: lifetime, duration, millennium, epoch, chronology (это L2),
 * также perennial, equinox, solstice, lull, intermission, epilogue,
 * continuity, succession, transient, transitory, recurrent, ephemeral,
 * imminent, forthcoming, interim, interregnum, prolonged, intervene,
 * inception, sequel — все они уже есть в других наборах.
 *
 * Распределение редкости: 18 RARE + 7 EPIC — два смежных уровня (B2 + C1).
 *
 * SemanticGroups (5 × 5):
 *   time_l3_temporal_concepts — simultaneity, chronological, timeline, sequential, consecutive
 *   time_l3_calendar_archaic  — biennial, leap year, centennial, antiquated, antediluvian
 *   time_l3_phases_advanced   — interlude, prelude, hiatus, respite, cessation
 *   time_l3_relative_complex  — concurrently, retroactively, prematurely, sporadically, intermittently
 *   time_l3_units_specialized — millisecond, nanosecond, eon, aeon, picosecond
 *
 * Word IDs: setId × 100 + position (38701..38725).
 *
 * fillInBlankExclusions / isFillInBlankSafe — не выставлены здесь (defaults в
 * WordEntity). FILL_IN_BLANK pipeline инжектит их централизованно после wave;
 * если поставить их заранее, pipeline пропустит запись (известный баг).
 */
object WordDataEnglishTimeL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 387,
            languagePair = "en-ru",
            orderIndex = 387,
            name = "Время и календарь",
            description = "Хронология, специальные единицы и научные временные термины",
            topic = "Время и календарь",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 387 — Время и календарь: углублённый (L3, RARE+EPIC)         ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── time_l3_temporal_concepts (5) ─────────────────────────────────

        WordEntity(id = 38701, setId = 387, languagePair = "en-ru", rarity = "EPIC",
            original = "simultaneity", transliteration = "[ˌsaɪməltəˈneɪəti]", translation = "одновременность",
            definition = "The fact that two or more events happen in the very same instant.",
            definitionNative = "Свойство двух или более событий происходить ровно в один и тот же миг.",
            example = "Physicists study the simultaneity of distant events very carefully.",
            exampleNative = "Физики очень тщательно изучают simultaneity далёких событий.",
            pos = "noun", semanticGroup = "time_l3_temporal_concepts", fillInBlankExclusions = listOf(38703L)),

        WordEntity(id = 38702, setId = 387, languagePair = "en-ru", rarity = "RARE",
            original = "chronological", transliteration = "[ˌkrɑnəˈlɑʤɪkəl]", translation = "хронологический",
            definition = "Arranged in the order in which events happened in time, from first to last.",
            definitionNative = "Расставленный в том порядке, в котором события шли во времени, от первого к последнему.",
            example = "Please list the steps in chronological order for the report.",
            exampleNative = "Пожалуйста, перечисли шаги в chronological порядке для отчёта.",
            pos = "adjective", semanticGroup = "time_l3_temporal_concepts", fillInBlankExclusions = listOf(38704L, 38705L)),

        WordEntity(id = 38703, setId = 387, languagePair = "en-ru", rarity = "RARE",
            original = "timeline", transliteration = "[ˈtaɪmˌlaɪn]", translation = "временная шкала",
            definition = "A line that shows when events happened, with the earliest on one end.",
            definitionNative = "Линия, на которой показано, когда происходили события, с самым ранним на одном краю.",
            example = "The museum's timeline traces the city from Roman times to today.",
            exampleNative = "Музейная timeline прослеживает город от римских времён до сегодня.",
            pos = "noun", semanticGroup = "time_l3_temporal_concepts", fillInBlankExclusions = listOf(38701L)),

        WordEntity(id = 38704, setId = 387, languagePair = "en-ru", rarity = "RARE",
            original = "sequential", transliteration = "[sɪˈkwɛnʃəl]", translation = "последовательный",
            definition = "Following one after another in a clear order, like steps in a recipe.",
            definitionNative = "Идущий один за другим в ясном порядке, как шаги рецепта.",
            example = "The lessons follow a sequential plan from easy to hard.",
            exampleNative = "Уроки идут по sequential плану — от лёгких к сложным.",
            pos = "adjective", semanticGroup = "time_l3_temporal_concepts", fillInBlankExclusions = listOf(38702L, 38705L, 38706L)),

        WordEntity(id = 38705, setId = 387, languagePair = "en-ru", rarity = "RARE",
            original = "consecutive", transliteration = "[kənˈsɛkjətɪv]", translation = "идущий подряд",
            definition = "Following each other without any gap — like three days in a row.",
            definitionNative = "Идущий друг за другом без пауз — как три дня кряду.",
            example = "It rained for five consecutive days last week.",
            exampleNative = "На прошлой неделе дождь шёл пять consecutive дней.",
            pos = "adjective", semanticGroup = "time_l3_temporal_concepts", fillInBlankExclusions = listOf(38702L, 38704L)),

        // ── time_l3_calendar_archaic (5) ──────────────────────────────────

        WordEntity(id = 38706, setId = 387, languagePair = "en-ru", rarity = "RARE",
            original = "biennial", transliteration = "[baɪˈɛniəl]", translation = "проводимый раз в два года",
            definition = "Happening once every two years — like an art show held only on even years.",
            definitionNative = "Происходящий один раз в два года — как выставка, что бывает только по чётным годам.",
            example = "The biennial film festival opens again next September.",
            exampleNative = "Biennial кинофестиваль снова откроется в сентябре будущего года.",
            pos = "adjective", semanticGroup = "time_l3_calendar_archaic", fillInBlankExclusions = listOf(38709L, 38710L)),

        WordEntity(id = 38707, setId = 387, languagePair = "en-ru", rarity = "RARE",
            original = "leap year", transliteration = "[lip jɪr]", translation = "високосный год",
            definition = "A year with one extra day, the 29th of February, that comes every four years.",
            definitionNative = "Год с одним лишним днём, 29 февраля, который наступает раз в четыре года.",
            example = "She was born on February 29 and only celebrates in a leap year.",
            exampleNative = "Она родилась 29 февраля и празднует день рождения только в leap year.",
            pos = "noun", semanticGroup = "time_l3_calendar_archaic", fillInBlankExclusions = listOf(38708L)),

        WordEntity(id = 38708, setId = 387, languagePair = "en-ru", rarity = "RARE",
            original = "centennial", transliteration = "[sɛnˈtɛniəl]", translation = "столетний (юбилей)",
            definition = "A celebration that marks one hundred years since something started.",
            definitionNative = "Торжество, которое отмечает сто лет с момента какого-то начала.",
            example = "The town held a centennial parade for its founding.",
            exampleNative = "Город устроил centennial парад в честь своего основания.",
            pos = "noun", semanticGroup = "time_l3_calendar_archaic", fillInBlankExclusions = listOf(38706L, 38707L)),

        WordEntity(id = 38709, setId = 387, languagePair = "en-ru", rarity = "RARE",
            original = "antiquated", transliteration = "[ˈæntəˌkweɪtəd]", translation = "устаревший",
            definition = "So old-fashioned that almost nobody uses it any more — like a typewriter.",
            definitionNative = "Настолько старомодный, что им уже почти никто не пользуется — как пишущая машинка.",
            example = "Their antiquated booking system loses bookings every week.",
            exampleNative = "Их antiquated система бронирования теряет заказы каждую неделю.",
            pos = "adjective", semanticGroup = "time_l3_calendar_archaic", fillInBlankExclusions = listOf(38706L, 38710L)),

        WordEntity(id = 38710, setId = 387, languagePair = "en-ru", rarity = "EPIC",
            original = "antediluvian", transliteration = "[ˌæntɪdɪˈluviən]", translation = "допотопный",
            definition = "Extremely old-fashioned, as if from a time before the great flood in old stories.",
            definitionNative = "Крайне старомодный, словно из времени до всемирного потопа из древних преданий.",
            example = "His antediluvian views on schooling shocked the young teachers.",
            exampleNative = "Его antediluvian взгляды на школу шокировали молодых учителей.",
            pos = "adjective", semanticGroup = "time_l3_calendar_archaic", fillInBlankExclusions = listOf(38706L, 38709L)),

        // ── time_l3_phases_advanced (5) ───────────────────────────────────

        WordEntity(id = 38711, setId = 387, languagePair = "en-ru", rarity = "RARE",
            original = "interlude", transliteration = "[ˈɪntərˌlud]", translation = "интерлюдия, краткое затишье",
            definition = "A short calm break in the middle of a long, busy stretch of time.",
            definitionNative = "Короткое спокойное окно в середине долгого и насыщенного отрезка времени.",
            example = "The picnic was a sunny interlude between two storms.",
            exampleNative = "Пикник стал солнечной interlude между двумя бурями.",
            pos = "noun", semanticGroup = "time_l3_phases_advanced", fillInBlankExclusions = listOf(38712L, 38713L, 38714L, 38715L)),

        WordEntity(id = 38712, setId = 387, languagePair = "en-ru", rarity = "RARE",
            original = "prelude", transliteration = "[ˈprɛˌlud]", translation = "прелюдия, преддверие",
            definition = "Something that happens just before a main event and prepares the way.",
            definitionNative = "То, что происходит прямо перед главным событием и готовит ему почву.",
            example = "The small protests were a prelude to the great strike.",
            exampleNative = "Мелкие протесты стали prelude к большой забастовке.",
            pos = "noun", semanticGroup = "time_l3_phases_advanced", fillInBlankExclusions = listOf(38713L, 38714L, 38715L)),

        WordEntity(id = 38713, setId = 387, languagePair = "en-ru", rarity = "EPIC",
            original = "hiatus", transliteration = "[haɪˈeɪtəs]", translation = "перерыв в деятельности",
            definition = "A pause in the middle of an activity that usually keeps going for a long time.",
            definitionNative = "Пауза в середине занятия, которое обычно тянется долго и без перерывов.",
            example = "After a five-year hiatus, the band finally released a new album.",
            exampleNative = "После пятилетнего hiatus группа наконец выпустила новый альбом.",
            pos = "noun", semanticGroup = "time_l3_phases_advanced", fillInBlankExclusions = listOf(38711L, 38712L, 38714L, 38715L)),

        WordEntity(id = 38714, setId = 387, languagePair = "en-ru", rarity = "RARE",
            original = "respite", transliteration = "[ˈrɛspət]", translation = "передышка",
            definition = "A short rest from something difficult or painful before it starts again.",
            definitionNative = "Короткий отдых от чего-то трудного или тяжёлого перед тем, как оно вернётся.",
            example = "The cool evening gave us a brief respite from the heat.",
            exampleNative = "Прохладный вечер дал нам короткую respite от жары.",
            pos = "noun", semanticGroup = "time_l3_phases_advanced", fillInBlankExclusions = listOf(38711L, 38712L, 38713L, 38715L)),

        WordEntity(id = 38715, setId = 387, languagePair = "en-ru", rarity = "EPIC",
            original = "cessation", transliteration = "[sɛˈseɪʃən]", translation = "прекращение",
            definition = "The full stop of something that was going on — used in formal speech.",
            definitionNative = "Полная остановка того, что шло — употребляется в формальной речи.",
            example = "Both sides agreed to a cessation of fighting at midnight.",
            exampleNative = "Обе стороны согласились на cessation боёв в полночь.",
            pos = "noun", semanticGroup = "time_l3_phases_advanced", fillInBlankExclusions = listOf(38712L, 38713L, 38714L)),

        // ── time_l3_relative_complex (5) ──────────────────────────────────

        WordEntity(id = 38716, setId = 387, languagePair = "en-ru", rarity = "RARE",
            original = "concurrently", transliteration = "[kənˈkərəntli]", translation = "одновременно (с чем-то)",
            definition = "At the same time as something else — both running side by side.",
            definitionNative = "В то же время, что и что-то ещё — оба идут бок о бок.",
            example = "He worked on two projects concurrently last spring.",
            exampleNative = "Прошлой весной он concurrently вёл два проекта.",
            pos = "adverb", semanticGroup = "time_l3_relative_complex", fillInBlankExclusions = listOf(38717L, 38718L, 38719L, 38720L)),

        WordEntity(id = 38717, setId = 387, languagePair = "en-ru", rarity = "EPIC",
            original = "retroactively", transliteration = "[ˌrɛtroʊˈæktɪvli]", translation = "задним числом",
            definition = "Reaching back to a past date so that an old time is also covered.",
            definitionNative = "С охватом прошлой даты, так что старое время тоже становится учтённым.",
            example = "The new tax rule applies retroactively to last year's income.",
            exampleNative = "Новое налоговое правило действует retroactively на прошлогодний доход.",
            pos = "adverb", semanticGroup = "time_l3_relative_complex", fillInBlankExclusions = listOf(38716L, 38718L, 38719L, 38720L)),

        WordEntity(id = 38718, setId = 387, languagePair = "en-ru", rarity = "RARE",
            original = "prematurely", transliteration = "[ˌpriməˈʧʊrli]", translation = "преждевременно",
            definition = "Earlier than the right or expected time — before things were really ready.",
            definitionNative = "Раньше, чем нужно или ожидалось — ещё до того, как всё было готово.",
            example = "The baby was born prematurely and stayed in the hospital for weeks.",
            exampleNative = "Малыш родился prematurely и пробыл в больнице несколько недель.",
            pos = "adverb", semanticGroup = "time_l3_relative_complex", fillInBlankExclusions = listOf(38716L, 38717L, 38719L, 38720L)),

        WordEntity(id = 38719, setId = 387, languagePair = "en-ru", rarity = "RARE",
            original = "sporadically", transliteration = "[spəˈrædɪkli]", translation = "эпизодически",
            definition = "Now and then with no clear pattern — happening only every so often.",
            definitionNative = "Время от времени, без чёткого узора — лишь иногда, без расписания.",
            example = "The old radio works only sporadically these days.",
            exampleNative = "Старый радиоприёмник в эти дни работает лишь sporadically.",
            pos = "adverb", semanticGroup = "time_l3_relative_complex", fillInBlankExclusions = listOf(38716L, 38717L, 38718L, 38720L)),

        WordEntity(id = 38720, setId = 387, languagePair = "en-ru", rarity = "EPIC",
            original = "intermittently", transliteration = "[ˌɪntərˈmɪtəntli]", translation = "с перерывами",
            definition = "Stopping and starting again and again — not steady but in short bursts.",
            definitionNative = "Останавливаясь и начинаясь снова и снова — не ровно, а короткими всплесками.",
            example = "The old engine ran intermittently throughout the trip.",
            exampleNative = "Старый мотор всю поездку работал intermittently.",
            pos = "adverb", semanticGroup = "time_l3_relative_complex", fillInBlankExclusions = listOf(38716L, 38717L, 38718L, 38719L)),

        // ── time_l3_units_specialized (5) ─────────────────────────────────

        WordEntity(id = 38721, setId = 387, languagePair = "en-ru", rarity = "RARE",
            original = "millisecond", transliteration = "[ˈmɪləˌsɛkənd]", translation = "миллисекунда",
            definition = "One thousandth of a second — too short for a human eye to notice.",
            definitionNative = "Одна тысячная секунды — слишком коротко, чтобы человеческий глаз заметил.",
            example = "The camera captured the bullet in a single millisecond.",
            exampleNative = "Камера поймала пулю за одну millisecond.",
            pos = "noun", semanticGroup = "time_l3_units_specialized", fillInBlankExclusions = listOf(38722L, 38723L, 38724L, 38725L)),

        WordEntity(id = 38722, setId = 387, languagePair = "en-ru", rarity = "RARE",
            original = "nanosecond", transliteration = "[ˈnænoʊˌsɛkənd]", translation = "наносекунда",
            definition = "One billionth of a second — used to measure how fast computers think.",
            definitionNative = "Одна миллиардная доля секунды — используется, чтобы измерять скорость работы компьютеров.",
            example = "A modern chip can flip a single transistor in less than one nanosecond.",
            exampleNative = "Современный чип переключает один транзистор меньше чем за одну nanosecond.",
            pos = "noun", semanticGroup = "time_l3_units_specialized", fillInBlankExclusions = listOf(38721L, 38723L, 38724L, 38725L)),

        WordEntity(id = 38723, setId = 387, languagePair = "en-ru", rarity = "RARE",
            original = "eon", transliteration = "[ˈiˌɑn]", translation = "эон, очень длинный период",
            definition = "An extremely long stretch of time, often used for ages of the Earth.",
            definitionNative = "Крайне длинный отрезок времени, часто используется для эпох Земли.",
            example = "These rocks were formed an eon ago, deep in the planet's past.",
            exampleNative = "Эти камни сформировались eon назад, глубоко в прошлом планеты.",
            pos = "noun", semanticGroup = "time_l3_units_specialized", fillInBlankExclusions = listOf(38724L)),

        WordEntity(id = 38724, setId = 387, languagePair = "en-ru", rarity = "EPIC",
            original = "aeon", transliteration = "[ˈiˌɑn]", translation = "эон (книжное)",
            definition = "An immense span of time — the literary, more solemn spelling of the word.",
            definitionNative = "Огромный промежуток времени — книжное, более торжественное написание слова.",
            example = "The poet wrote of forests that had stood for an aeon.",
            exampleNative = "Поэт писал о лесах, что простояли целый aeon.",
            pos = "noun", semanticGroup = "time_l3_units_specialized", fillInBlankExclusions = listOf(38723L)),

        WordEntity(id = 38725, setId = 387, languagePair = "en-ru", rarity = "RARE",
            original = "picosecond", transliteration = "[ˈpikoʊˌsɛkənd]", translation = "пикосекунда",
            definition = "One trillionth of a second — used in laser physics and very fast electronics.",
            definitionNative = "Одна триллионная доля секунды — применяется в лазерной физике и очень быстрой электронике.",
            example = "The laser pulse lasted barely one picosecond before it faded out.",
            exampleNative = "Лазерный импульс длился едва ли одну picosecond, прежде чем угаснуть.",
            pos = "noun", semanticGroup = "time_l3_units_specialized", fillInBlankExclusions = listOf(38721L, 38722L, 38723L, 38724L)),
    )
}
