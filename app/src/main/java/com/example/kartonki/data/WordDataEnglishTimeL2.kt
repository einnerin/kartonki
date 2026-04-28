package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Время и календарь (L2, UNCOMMON+RARE).
 *
 * Set 386: «Время и календарь» — продвинутый уровень.
 *          Эпохи, расписания, дополнительные части суток и продвинутые
 *          ориентиры/частотные наречия уровня A2-B2 (UNCOMMON+RARE).
 *          Не пересекается с L1 (set 385) и старыми наборами по времени
 *          (Batch7 «Повседневная жизнь», Batch12/13, Holidays и др.).
 *
 * Распределение редкости: 18 UNCOMMON + 7 RARE — два смежных уровня (A2-B1 + B2).
 *
 * SemanticGroups (5 × 5):
 *   time_l2_periods         — lifetime, millennium, epoch, chronology, duration
 *   time_l2_calendar_pro    — countdown, reschedule, postpone, punctual, fortnightly
 *   time_l2_dayparts_extra  — nightfall, daybreak, midsummer, weeknight, workweek
 *   time_l2_relative_pro    — eventually, meanwhile, beforehand, afterward, henceforth
 *   time_l2_freq_pro        — frequently, seldom, occasionally, constantly, hourly
 *
 * Word IDs: setId × 100 + position (38601..38625).
 *
 * fillInBlankExclusions / isFillInBlankSafe не задаются — заполнятся через
 * FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataEnglishTimeL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 386,
            languagePair = "en-ru",
            orderIndex = 386,
            name = "Время и календарь",
            description = "Эпохи, расписания и продвинутые ориентиры во времени",
            topic = "Время и календарь",
            level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 386 — Время и календарь: продвинутый (L2, UNCOMMON+RARE)     ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── time_l2_periods (5) ───────────────────────────────────────────

        WordEntity(id = 38601, setId = 386, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "lifetime", transliteration = "[ˈlaɪfˌtaɪm]", translation = "продолжительность жизни, целая жизнь",
            definition = "All the years a person or thing exists — from birth to the very end.",
            definitionNative = "Все годы, что человек или вещь существуют — от рождения и до самого конца.",
            example = "She saved enough money over a lifetime to buy a small house.",
            exampleNative = "Она за lifetime накопила достаточно, чтобы купить маленький дом.",
            pos = "noun", semanticGroup = "time_l2_periods", fillInBlankExclusions = listOf(38602L, 38603L, 38605L, 38614L)),

        WordEntity(id = 38602, setId = 386, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "duration", transliteration = "[dʊˈreɪʃən]", translation = "продолжительность",
            definition = "The length of time something lasts — from the moment it starts until it ends.",
            definitionNative = "Длина отрезка, в течение которого что-то идёт — от начала до конца события.",
            example = "Please stay seated for the duration of the flight.",
            exampleNative = "Пожалуйста, оставайтесь на месте на всю duration полёта.",
            pos = "noun", semanticGroup = "time_l2_periods", fillInBlankExclusions = listOf(38601L, 38603L, 38604L, 38605L)),

        WordEntity(id = 38603, setId = 386, languagePair = "en-ru", rarity = "RARE",
            original = "millennium", transliteration = "[məˈlɛniəm]", translation = "тысячелетие",
            definition = "A period of one thousand years — like a huge step in human history.",
            definitionNative = "Промежуток в тысячу лет — как огромный шаг человеческой истории.",
            example = "The cathedral has stood here for almost a millennium.",
            exampleNative = "Этот собор стоит здесь почти millennium.",
            pos = "noun", semanticGroup = "time_l2_periods", fillInBlankExclusions = listOf(38601L, 38602L, 38605L, 38614L)),

        WordEntity(id = 38604, setId = 386, languagePair = "en-ru", rarity = "RARE",
            original = "epoch", transliteration = "[ˈɛpək]", translation = "эпоха (значимый период)",
            definition = "A long stretch of history marked by something important — wars, kings or new ideas.",
            definitionNative = "Длинный кусок истории, отмеченный чем-то важным — войнами, королями или новыми идеями.",
            example = "The invention of the wheel began a new epoch for humankind.",
            exampleNative = "Изобретение колеса открыло новую epoch человечества.",
            pos = "noun", semanticGroup = "time_l2_periods", fillInBlankExclusions = listOf(38601L, 38602L, 38603L, 38605L, 38606L)),

        WordEntity(id = 38605, setId = 386, languagePair = "en-ru", rarity = "RARE",
            original = "chronology", transliteration = "[krəˈnɑləʤi]", translation = "хронология",
            definition = "A list of events in the exact order they happened in time.",
            definitionNative = "Список событий в точном порядке, в каком они шли во времени.",
            example = "The museum shows a clear chronology of the city's growth.",
            exampleNative = "В музее показана ясная chronology развития города.",
            pos = "noun", semanticGroup = "time_l2_periods", fillInBlankExclusions = listOf(38601L, 38602L, 38603L, 38604L)),

        // ── time_l2_calendar_pro (5) ──────────────────────────────────────

        WordEntity(id = 38606, setId = 386, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "countdown", transliteration = "[ˈkaʊntˌdaʊn]", translation = "обратный отсчёт",
            definition = "Counting numbers down toward zero before something big starts.",
            definitionNative = "Счёт чисел в обратную сторону, к нулю, перед каким-то важным стартом.",
            example = "The countdown to the New Year began with loud cheers.",
            exampleNative = "Countdown до Нового года начался с громких криков.",
            pos = "noun", semanticGroup = "time_l2_calendar_pro"),

        WordEntity(id = 38607, setId = 386, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "reschedule", transliteration = "[riˈskɛʤʊl]", translation = "перенести (встречу)",
            definition = "To move a planned meeting or event to a different day or time.",
            definitionNative = "Перенести запланированную встречу или событие на другой день или час.",
            example = "We had to reschedule the dentist visit for next Monday.",
            exampleNative = "Нам пришлось reschedule визит к стоматологу на следующий понедельник.",
            pos = "verb", semanticGroup = "time_l2_calendar_pro", fillInBlankExclusions = listOf(38608L)),

        WordEntity(id = 38608, setId = 386, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "postpone", transliteration = "[poʊstˈpoʊn]", translation = "отложить (на потом)",
            definition = "To push an event to a later date — not today, maybe next week.",
            definitionNative = "Передвинуть событие на более поздний срок — не сегодня, может быть, на следующую неделю.",
            example = "They had to postpone the wedding because of the storm.",
            exampleNative = "Им пришлось postpone свадьбу из-за бури.",
            pos = "verb", semanticGroup = "time_l2_calendar_pro", fillInBlankExclusions = listOf(38607L)),

        WordEntity(id = 38609, setId = 386, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "punctual", transliteration = "[ˈpʌŋkʧuəl]", translation = "пунктуальный",
            definition = "Always arriving exactly at the agreed time — never a minute late.",
            definitionNative = "Всегда приходящий ровно в назначенный час — ни на минуту не опаздывая.",
            example = "Our teacher is famously punctual — class starts at nine sharp.",
            exampleNative = "Наш учитель славится тем, что punctual — урок ровно в девять.",
            pos = "adjective", semanticGroup = "time_l2_calendar_pro"),

        WordEntity(id = 38610, setId = 386, languagePair = "en-ru", rarity = "RARE",
            original = "fortnightly", transliteration = "[ˈfɔrtˌnaɪtli]", translation = "раз в две недели",
            definition = "Happening once every two weeks — like a meeting on alternating Fridays.",
            definitionNative = "Происходящий раз в две недели — как встреча по пятницам через одну.",
            example = "Our book club meets fortnightly at the corner cafe.",
            exampleNative = "Наш книжный клуб собирается fortnightly в кафе на углу.",
            pos = "adverb", semanticGroup = "time_l2_calendar_pro", fillInBlankExclusions = listOf(38621L, 38622L, 38623L, 38624L, 38625L)),

        // ── time_l2_dayparts_extra (5) ────────────────────────────────────

        WordEntity(id = 38611, setId = 386, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "nightfall", transliteration = "[ˈnaɪtˌfɔl]", translation = "наступление ночи",
            definition = "The moment when the sky turns dark and the day quietly ends.",
            definitionNative = "Миг, когда небо темнеет и день тихо подходит к концу.",
            example = "We reached the village just before nightfall.",
            exampleNative = "Мы добрались до деревни как раз перед nightfall.",
            pos = "noun", semanticGroup = "time_l2_dayparts_extra", fillInBlankExclusions = listOf(38612L, 38613L, 38614L, 38615L)),

        WordEntity(id = 38612, setId = 386, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "daybreak", transliteration = "[ˈdeɪˌbreɪk]", translation = "рассвет",
            definition = "The very first light in the sky — when birds begin to sing.",
            definitionNative = "Самый первый свет на небе — когда птицы только начинают петь.",
            example = "The fishermen set out at daybreak with their nets.",
            exampleNative = "Рыбаки вышли в море на daybreak со своими сетями.",
            pos = "noun", semanticGroup = "time_l2_dayparts_extra", fillInBlankExclusions = listOf(38611L, 38613L, 38614L, 38615L)),

        WordEntity(id = 38613, setId = 386, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "weeknight", transliteration = "[ˈwiːkˌnaɪt]", translation = "будний вечер/ночь",
            definition = "Any evening from Monday to Thursday — not part of the weekend.",
            definitionNative = "Любой вечер с понедельника по четверг — не относящийся к выходным.",
            example = "We rarely eat out on a weeknight because of work.",
            exampleNative = "Мы редко ходим в ресторан в weeknight из-за работы.",
            pos = "noun", semanticGroup = "time_l2_dayparts_extra", fillInBlankExclusions = listOf(38611L, 38612L, 38614L, 38615L)),

        WordEntity(id = 38614, setId = 386, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "workweek", transliteration = "[ˈwɜːrkˌwiːk]", translation = "рабочая неделя",
            definition = "The days from Monday to Friday when most people go to work.",
            definitionNative = "Дни с понедельника по пятницу, когда большинство людей ходят на работу.",
            example = "A standard workweek in our office is forty hours.",
            exampleNative = "Стандартный workweek в нашем офисе — сорок часов.",
            pos = "noun", semanticGroup = "time_l2_dayparts_extra", fillInBlankExclusions = listOf(38611L, 38612L, 38613L, 38615L)),

        WordEntity(id = 38615, setId = 386, languagePair = "en-ru", rarity = "RARE",
            original = "midsummer", transliteration = "[ˌmɪdˈsʌmər]", translation = "середина лета",
            definition = "The middle of the summer — the hottest, longest days of the year.",
            definitionNative = "Середина лета — самые жаркие и самые длинные дни в году.",
            example = "We always go camping by the lake at midsummer.",
            exampleNative = "Мы всегда едем с палатками к озеру в midsummer.",
            pos = "noun", semanticGroup = "time_l2_dayparts_extra", fillInBlankExclusions = listOf(38611L, 38612L, 38613L, 38614L)),

        // ── time_l2_relative_pro (5) ──────────────────────────────────────

        WordEntity(id = 38616, setId = 386, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "eventually", transliteration = "[ɪˈvɛnʧuəli]", translation = "в конце концов",
            definition = "After a long while — when something finally happens after delays.",
            definitionNative = "После долгого ожидания — когда что-то наконец случается после задержек.",
            example = "After many tries, she eventually passed the driving test.",
            exampleNative = "После многих попыток она eventually сдала на права.",
            pos = "adverb", semanticGroup = "time_l2_relative_pro", fillInBlankExclusions = listOf(38617L, 38618L, 38619L, 38620L, 38623L)),

        WordEntity(id = 38617, setId = 386, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "meanwhile", transliteration = "[ˈminˌwaɪl]", translation = "тем временем",
            definition = "At the same time as another action — while something else is also going on.",
            definitionNative = "Одновременно с другим действием — пока ещё что-то идёт параллельно.",
            example = "I was cooking; meanwhile, the kids set the table.",
            exampleNative = "Я готовил; meanwhile, дети накрывали на стол.",
            pos = "adverb", semanticGroup = "time_l2_relative_pro", fillInBlankExclusions = listOf(38616L, 38618L, 38619L, 38620L, 38621L, 38622L, 38623L, 38624L)),

        WordEntity(id = 38618, setId = 386, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "afterward", transliteration = "[ˈæftərwərd]", translation = "потом, впоследствии",
            definition = "At a point in time after the thing you were just talking about.",
            definitionNative = "В какой-то момент уже после того, о чём только что шла речь.",
            example = "We watched a film and went for ice cream afterward.",
            exampleNative = "Мы посмотрели фильм и afterward пошли есть мороженое.",
            pos = "adverb", semanticGroup = "time_l2_relative_pro", fillInBlankExclusions = listOf(38610L, 38616L, 38617L, 38619L, 38620L, 38621L, 38623L, 38624L)),

        WordEntity(id = 38619, setId = 386, languagePair = "en-ru", rarity = "RARE",
            original = "beforehand", transliteration = "[bɪˈfɔrˌhænd]", translation = "заранее",
            definition = "Earlier than the main event — done in advance to be ready.",
            definitionNative = "Раньше основного события — сделанное заранее, чтобы быть готовым.",
            example = "Please warn us beforehand if you plan to bring guests.",
            exampleNative = "Пожалуйста, предупреди нас beforehand, если приведёшь гостей.",
            pos = "adverb", semanticGroup = "time_l2_relative_pro", fillInBlankExclusions = listOf(38610L, 38616L, 38617L, 38618L, 38620L, 38621L, 38623L, 38624L, 38625L)),

        WordEntity(id = 38620, setId = 386, languagePair = "en-ru", rarity = "RARE",
            original = "henceforth", transliteration = "[ˌhɛnsˈfɔrθ]", translation = "отныне, впредь",
            definition = "From this moment on — used in formal speech for new rules.",
            definitionNative = "С этого момента и далее — употребляется в формальной речи для новых правил.",
            example = "Henceforth, all visitors must sign in at the front desk.",
            exampleNative = "Henceforth все посетители должны отмечаться на ресепшене.",
            pos = "adverb", semanticGroup = "time_l2_relative_pro", fillInBlankExclusions = listOf(38616L, 38617L, 38618L, 38619L, 38623L)),

        // ── time_l2_freq_pro (5) ──────────────────────────────────────────

        WordEntity(id = 38621, setId = 386, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "frequently", transliteration = "[ˈfrikwəntli]", translation = "часто",
            definition = "Many times in a given period — much more often than only sometimes.",
            definitionNative = "Много раз за какой-то промежуток — гораздо чаще, чем просто иногда.",
            example = "He frequently travels to Berlin for business.",
            exampleNative = "Он frequently ездит в Берлин по делам.",
            pos = "adverb", semanticGroup = "time_l2_freq_pro", fillInBlankExclusions = listOf(38610L, 38616L, 38622L, 38623L, 38624L, 38625L)),

        WordEntity(id = 38622, setId = 386, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "seldom", transliteration = "[ˈsɛldəm]", translation = "редко",
            definition = "Almost never — only on very rare occasions throughout the year.",
            definitionNative = "Почти никогда — лишь в очень редких случаях за весь год.",
            example = "She seldom watches television in the evenings.",
            exampleNative = "Она seldom смотрит телевизор вечерами.",
            pos = "adverb", semanticGroup = "time_l2_freq_pro", fillInBlankExclusions = listOf(38616L, 38621L, 38623L, 38624L, 38625L)),

        WordEntity(id = 38623, setId = 386, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "occasionally", transliteration = "[əˈkeɪʒənəli]", translation = "иногда, время от времени",
            definition = "Now and then — from time to time, but not on any regular plan.",
            definitionNative = "Время от времени — нечасто и без какого-то твёрдого графика.",
            example = "We occasionally visit my grandparents in the countryside.",
            exampleNative = "Мы occasionally навещаем бабушку с дедушкой в деревне.",
            pos = "adverb", semanticGroup = "time_l2_freq_pro", fillInBlankExclusions = listOf(38610L, 38616L, 38621L, 38622L, 38624L, 38625L)),

        WordEntity(id = 38624, setId = 386, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "constantly", transliteration = "[ˈkɑnstəntli]", translation = "постоянно, непрерывно",
            definition = "All the time without a break — happening again and again.",
            definitionNative = "Всё время без перерыва — снова и снова, без остановки.",
            example = "My phone constantly buzzes with new messages.",
            exampleNative = "Мой телефон constantly жужжит от новых сообщений.",
            pos = "adverb", semanticGroup = "time_l2_freq_pro", fillInBlankExclusions = listOf(38616L, 38621L, 38622L, 38623L, 38625L)),

        WordEntity(id = 38625, setId = 386, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "hourly", transliteration = "[ˈaʊərli]", translation = "ежечасно, каждый час",
            definition = "Once every hour — like a bus that comes at the top of each hour.",
            definitionNative = "Раз в час — как автобус, который приходит каждый раз в начале часа.",
            example = "The tower clock chimes hourly across the old town.",
            exampleNative = "Башенные часы hourly бьют над старым городом.",
            pos = "adverb", semanticGroup = "time_l2_freq_pro", fillInBlankExclusions = listOf(38610L, 38621L, 38622L, 38623L, 38624L)),
    )
}
