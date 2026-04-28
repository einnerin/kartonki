package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Время и календарь (L4, RARE+EPIC).
 *
 * Set 388: «Время и календарь» — профессиональный.
 *          Продвинутая хронология, специальные календарные системы (Gregorian,
 *          Julian, lunisolar, paschal), темпоральные явления (perihelion,
 *          aphelion, precession), формальные ориентиры (heretofore, hitherto,
 *          hereinafter), продвинутые фазы (perpetuity, transience, ephemerality)
 *          — лексика уровня B2-C1, какой пользуются юристы, астрономы,
 *          историки, философы.
 *
 * Тема «Время и календарь» — продолжение L1 (set 385), L2 (set 386), L3 (set 387).
 * Все 25 слов проверены на отсутствие в наборах 31, 63, 70, 72, 76, 77, 80, 82,
 * 216, 233, 242, 385-387 и других файлах WordData*.kt (grep по `original = "..."`).
 * В частности обойдены anachronism (Expanded), retrospective (EntertainmentL4),
 * solstice (Expanded), posterity (Batch13), chronicle (WordDataEnglish),
 * imminent / transient / perennial / interim / ephemeral / nascent / incipient
 * (WordDataEnglish), antiquated (TimeL3), hourly (TimeL2), antiquarian (HistoryL4),
 * jubilee (Expanded) и crepuscular / gloaming (WeatherL5) — все они уже есть.
 *
 * Распределение редкости: 17 EPIC + 8 RARE — два смежных уровня (B2 + C1).
 *
 * SemanticGroups (5 × 5):
 *   time_l4_chronology_pro    — anachronistic, chronicler, posthumous, antedate, postdate
 *   time_l4_calendar_advanced — gregorian, julian, lunisolar, intercalary, paschal
 *   time_l4_temporal_phenomena — precession, analemma, perihelion, aphelion, sidereal
 *   time_l4_relative_formal   — heretofore, hitherto, hereinafter, forthwith, henceforward
 *   time_l4_phases_pro        — recurrence, perpetuity, transience, fleetingness, ephemerality
 *
 * Word IDs: setId × 100 + position (38801..38825).
 *
 * fillInBlankExclusions / isFillInBlankSafe — не выставлены здесь (defaults в
 * WordEntity). FILL_IN_BLANK pipeline инжектит их централизованно после wave;
 * если поставить их заранее, pipeline пропустит запись (известный баг).
 */
object WordDataEnglishTimeL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 388,
            languagePair = "en-ru",
            orderIndex = 388,
            name = "Время и календарь",
            description = "Хронологические термины, астрономические явления и формальные ориентиры",
            topic = "Время и календарь",
            level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 388 — Время и календарь: профессиональный (L4, RARE+EPIC)    ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── time_l4_chronology_pro (5) ────────────────────────────────────

        WordEntity(id = 38801, setId = 388, languagePair = "en-ru", rarity = "EPIC",
            original = "anachronistic", transliteration = "[əˌnækrəˈnɪstɪk]", translation = "несоответствующий эпохе",
            definition = "Out of place in time — like a wristwatch worn by a Roman soldier in a film.",
            definitionNative = "Не на своём месте во времени — как наручные часы у римского легионера в фильме.",
            example = "The smartphone in the period drama looked utterly anachronistic.",
            exampleNative = "Смартфон в исторической драме смотрелся совершенно anachronistic.",
            pos = "adjective", semanticGroup = "time_l4_chronology_pro", fillInBlankExclusions = listOf(38803L)),

        WordEntity(id = 38802, setId = 388, languagePair = "en-ru", rarity = "RARE",
            original = "chronicler", transliteration = "[ˈkrɑnɪklər]", translation = "летописец, хронист",
            definition = "A person who writes down events in the order they happen, year after year.",
            definitionNative = "Человек, что записывает события по порядку, как они идут, год за годом.",
            example = "The medieval chronicler recorded every battle the king fought.",
            exampleNative = "Средневековый chronicler записал все битвы, в которых сражался король.",
            pos = "noun", semanticGroup = "time_l4_chronology_pro"),

        WordEntity(id = 38803, setId = 388, languagePair = "en-ru", rarity = "EPIC",
            original = "posthumous", transliteration = "[ˈpɑsʧəməs]", translation = "посмертный",
            definition = "Happening or given after a person has died — like a medal awarded to a fallen soldier.",
            definitionNative = "Случившееся или полученное после смерти человека — как медаль павшему солдату.",
            example = "She received a posthumous award for her wartime bravery.",
            exampleNative = "Она получила posthumous награду за храбрость в военные годы.",
            pos = "adjective", semanticGroup = "time_l4_chronology_pro"),

        WordEntity(id = 38804, setId = 388, languagePair = "en-ru", rarity = "RARE",
            original = "antedate", transliteration = "[ˈæntɪˌdeɪt]", translation = "помечать задним числом, предшествовать",
            definition = "To mark a paper with an earlier date than today, or to come before something in time.",
            definitionNative = "Поставить на бумаге более раннюю дату, чем сегодня, или быть раньше чего-то по времени.",
            example = "Stone tools antedate written language by tens of thousands of years.",
            exampleNative = "Каменные орудия antedate письменность на десятки тысяч лет.",
            pos = "verb", semanticGroup = "time_l4_chronology_pro", fillInBlankExclusions = listOf(38805L)),

        WordEntity(id = 38805, setId = 388, languagePair = "en-ru", rarity = "RARE",
            original = "postdate", transliteration = "[ˌpoʊstˈdeɪt]", translation = "датировать будущим числом",
            definition = "To put a future date on a paper or cheque so it cannot be used until then.",
            definitionNative = "Поставить будущую дату на бумаге или чеке, чтобы им нельзя было воспользоваться раньше.",
            example = "Please postdate the cheque to the first of next month.",
            exampleNative = "Прошу postdate чек первым числом следующего месяца.",
            pos = "verb", semanticGroup = "time_l4_chronology_pro", fillInBlankExclusions = listOf(38804L)),

        // ── time_l4_calendar_advanced (5) ─────────────────────────────────

        WordEntity(id = 38806, setId = 388, languagePair = "en-ru", rarity = "EPIC",
            original = "gregorian", transliteration = "[ɡrɪˈɡɔriən]", translation = "григорианский (о календаре)",
            definition = "Of the calendar most countries use today, fixed by a Pope in 1582.",
            definitionNative = "Относящийся к календарю, который сейчас в ходу почти во всех странах — его утвердил Папа в 1582.",
            example = "Most of Europe switched to the gregorian calendar by the eighteenth century.",
            exampleNative = "Большая часть Европы перешла на gregorian календарь к восемнадцатому веку.",
            pos = "adjective", semanticGroup = "time_l4_calendar_advanced", fillInBlankExclusions = listOf(38807L, 38808L, 38809L, 38810L)),

        WordEntity(id = 38807, setId = 388, languagePair = "en-ru", rarity = "EPIC",
            original = "julian", transliteration = "[ˈʤuljən]", translation = "юлианский (о календаре)",
            definition = "Of the older Roman calendar set up by Julius Caesar — still used by some churches.",
            definitionNative = "Относящийся к старому римскому календарю, что ввёл Юлий Цезарь — его до сих пор держатся некоторые церкви.",
            example = "Orthodox Christmas falls on a different date because of the julian calendar.",
            exampleNative = "Православное Рождество приходится на другой день из-за julian календаря.",
            pos = "adjective", semanticGroup = "time_l4_calendar_advanced", fillInBlankExclusions = listOf(38806L, 38808L, 38809L, 38810L)),

        WordEntity(id = 38808, setId = 388, languagePair = "en-ru", rarity = "EPIC",
            original = "lunisolar", transliteration = "[ˌluːnɪˈsoʊlər]", translation = "лунно-солнечный",
            definition = "Of a calendar that follows both the moon's phases and the sun's seasons at once.",
            definitionNative = "Относящийся к календарю, что следит сразу за фазами луны и за временами года солнца.",
            example = "The Chinese New Year is set by a lunisolar calendar.",
            exampleNative = "Китайский Новый год определяется по lunisolar календарю.",
            pos = "adjective", semanticGroup = "time_l4_calendar_advanced", fillInBlankExclusions = listOf(38806L, 38807L, 38810L)),

        WordEntity(id = 38809, setId = 388, languagePair = "en-ru", rarity = "EPIC",
            original = "intercalary", transliteration = "[ɪnˈtɜːrkəˌlɛri]", translation = "вставной (о дне в календаре)",
            definition = "Of an extra day or month added to a calendar to keep it in step with the seasons.",
            definitionNative = "Об отдельном дне или месяце, что вставили в календарь, чтобы он не отставал от времён года.",
            example = "February twenty-ninth is the intercalary day of a leap year.",
            exampleNative = "Двадцать девятое февраля — intercalary день високосного года.",
            pos = "adjective", semanticGroup = "time_l4_calendar_advanced", fillInBlankExclusions = listOf(38806L, 38807L, 38808L, 38810L)),

        WordEntity(id = 38810, setId = 388, languagePair = "en-ru", rarity = "RARE",
            original = "paschal", transliteration = "[ˈpæskəl]", translation = "пасхальный",
            definition = "Of the church holiday of Easter — used for special candles, services and dates.",
            definitionNative = "Относящийся к церковному празднику Пасхи — о свечах, службах и датах.",
            example = "The priest lit the tall paschal candle at the midnight service.",
            exampleNative = "Священник зажёг высокую paschal свечу на полуночной службе.",
            pos = "adjective", semanticGroup = "time_l4_calendar_advanced", fillInBlankExclusions = listOf(38806L, 38807L, 38808L, 38809L)),

        // ── time_l4_temporal_phenomena (5) ────────────────────────────────

        WordEntity(id = 38811, setId = 388, languagePair = "en-ru", rarity = "EPIC",
            original = "precession", transliteration = "[priˈsɛʃən]", translation = "прецессия (оси)",
            definition = "The very slow wobble of the Earth's axis, like a dying spinning top, over many centuries.",
            definitionNative = "Очень медленное покачивание земной оси, как у затухающего волчка, через многие века.",
            example = "Astronomers correct star charts for the precession of the equinoxes.",
            exampleNative = "Астрономы поправляют карты звёзд на precession равноденствий.",
            pos = "noun", semanticGroup = "time_l4_temporal_phenomena", fillInBlankExclusions = listOf(38812L, 38813L, 38814L)),

        WordEntity(id = 38812, setId = 388, languagePair = "en-ru", rarity = "EPIC",
            original = "analemma", transliteration = "[ˌænəˈlɛmə]", translation = "аналемма",
            definition = "The figure-of-eight loop the sun traces in the sky if you photograph it at noon all year.",
            definitionNative = "Восьмёркой, что чертит солнце на небе, если снимать его в полдень круглый год.",
            example = "Photographers patiently shoot the analemma over an entire year.",
            exampleNative = "Фотографы терпеливо снимают analemma на протяжении целого года.",
            pos = "noun", semanticGroup = "time_l4_temporal_phenomena", fillInBlankExclusions = listOf(38811L, 38813L, 38814L)),

        WordEntity(id = 38813, setId = 388, languagePair = "en-ru", rarity = "EPIC",
            original = "perihelion", transliteration = "[ˌpɛrɪˈhiːliən]", translation = "перигелий",
            definition = "The point in a planet's orbit where it comes the closest to the sun.",
            definitionNative = "Точка на орбите планеты, где она ближе всего подходит к солнцу.",
            example = "The Earth reaches perihelion in early January each year.",
            exampleNative = "Земля проходит perihelion в начале января каждый год.",
            pos = "noun", semanticGroup = "time_l4_temporal_phenomena", fillInBlankExclusions = listOf(38811L, 38812L, 38814L)),

        WordEntity(id = 38814, setId = 388, languagePair = "en-ru", rarity = "EPIC",
            original = "aphelion", transliteration = "[æˈfiːliən]", translation = "афелий",
            definition = "The point in a planet's orbit where it is the farthest from the sun.",
            definitionNative = "Точка на орбите планеты, где она дальше всего от солнца.",
            example = "Mars cools sharply when it is near aphelion in its long year.",
            exampleNative = "Марс резко остывает, когда он у aphelion в своём долгом году.",
            pos = "noun", semanticGroup = "time_l4_temporal_phenomena", fillInBlankExclusions = listOf(38811L, 38812L, 38813L)),

        WordEntity(id = 38815, setId = 388, languagePair = "en-ru", rarity = "RARE",
            original = "sidereal", transliteration = "[saɪˈdɪriəl]", translation = "сидерический, звёздный (о времени)",
            definition = "Measured by the stars, not the sun — used by astronomers for precise time.",
            definitionNative = "Отмеряемый по звёздам, а не по солнцу — астрономы пользуются им для точного времени.",
            example = "The telescope's clock ticks in sidereal time, not regular time.",
            exampleNative = "Часы телескопа идут по sidereal времени, а не по обычному.",
            pos = "adjective", semanticGroup = "time_l4_temporal_phenomena", fillInBlankExclusions = listOf(38807L)),

        // ── time_l4_relative_formal (5) ───────────────────────────────────

        WordEntity(id = 38816, setId = 388, languagePair = "en-ru", rarity = "EPIC",
            original = "heretofore", transliteration = "[ˌhɪrtuˈfɔːr]", translation = "до сих пор, ранее",
            definition = "Up to this point in time — a stiff, old-fashioned word found in legal papers.",
            definitionNative = "До этого момента — чопорное старомодное слово, что встречается в юридических бумагах.",
            example = "The contract overrules all heretofore signed agreements.",
            exampleNative = "Договор отменяет все heretofore подписанные соглашения.",
            pos = "adverb", semanticGroup = "time_l4_relative_formal", fillInBlankExclusions = listOf(38817L, 38818L, 38819L, 38820L)),

        WordEntity(id = 38817, setId = 388, languagePair = "en-ru", rarity = "EPIC",
            original = "hitherto", transliteration = "[ˌhɪðərˈtuː]", translation = "до сего времени",
            definition = "Until now — a formal way to say something has been true up to the present.",
            definitionNative = "До сего момента — высокий способ сказать, что нечто было верно вплоть до настоящего.",
            example = "The diary revealed details hitherto unknown to historians.",
            exampleNative = "Дневник раскрыл подробности, hitherto неизвестные историкам.",
            pos = "adverb", semanticGroup = "time_l4_relative_formal", fillInBlankExclusions = listOf(38816L, 38818L, 38819L, 38820L)),

        WordEntity(id = 38818, setId = 388, languagePair = "en-ru", rarity = "EPIC",
            original = "hereinafter", transliteration = "[ˌhɪrɪnˈæftər]", translation = "далее (по тексту)",
            definition = "From this point on in a written paper — a formal pointer used by lawyers.",
            definitionNative = "С этого места и далее в бумаге — формальный указатель, которым пользуются юристы.",
            example = "The buyer, hereinafter called the Client, agrees to the terms.",
            exampleNative = "Покупатель, hereinafter именуемый Клиентом, соглашается с условиями.",
            pos = "adverb", semanticGroup = "time_l4_relative_formal", fillInBlankExclusions = listOf(38816L, 38817L, 38819L, 38820L)),

        WordEntity(id = 38819, setId = 388, languagePair = "en-ru", rarity = "EPIC",
            original = "forthwith", transliteration = "[ˌfɔːrθˈwɪθ]", translation = "немедленно, тотчас же",
            definition = "Right now without any delay — a stern, formal way of saying at once.",
            definitionNative = "Прямо сейчас, без всяких задержек — суровый формальный способ сказать «тут же».",
            example = "The court ordered the prisoner to be released forthwith.",
            exampleNative = "Суд приказал освободить узника forthwith.",
            pos = "adverb", semanticGroup = "time_l4_relative_formal", fillInBlankExclusions = listOf(38816L, 38817L, 38818L, 38820L)),

        WordEntity(id = 38820, setId = 388, languagePair = "en-ru", rarity = "RARE",
            original = "henceforward", transliteration = "[ˌhɛnsˈfɔːrwərd]", translation = "впредь, отныне и далее",
            definition = "From this moment on into the future — formal and slightly old-fashioned.",
            definitionNative = "С этого мига и в будущее — формальное и слегка старомодное слово.",
            example = "The new rules will apply henceforward to every member.",
            exampleNative = "Новые правила будут действовать henceforward для каждого члена.",
            pos = "adverb", semanticGroup = "time_l4_relative_formal", fillInBlankExclusions = listOf(38816L, 38817L, 38818L, 38819L)),

        // ── time_l4_phases_pro (5) ────────────────────────────────────────

        WordEntity(id = 38821, setId = 388, languagePair = "en-ru", rarity = "EPIC",
            original = "recurrence", transliteration = "[rɪˈkɜːrəns]", translation = "повторение, рецидив",
            definition = "Something happening again, often in a pattern — like a fever returning each spring.",
            definitionNative = "Когда нечто случается снова, часто по образцу — как жар, что возвращается каждой весной.",
            example = "The doctor watched for any recurrence of the old illness.",
            exampleNative = "Врач следил за любой recurrence старой болезни.",
            pos = "noun", semanticGroup = "time_l4_phases_pro", fillInBlankExclusions = listOf(38822L, 38823L, 38824L, 38825L)),

        WordEntity(id = 38822, setId = 388, languagePair = "en-ru", rarity = "EPIC",
            original = "perpetuity", transliteration = "[ˌpɜːrpəˈtuːəti]", translation = "вечность, бессрочность",
            definition = "A state that lasts for all time without end — used in legal and formal speech.",
            definitionNative = "Состояние, что длится во все времена без конца — встречается в юридической и высокой речи.",
            example = "The land was granted to the family in perpetuity.",
            exampleNative = "Земля была пожалована семье в perpetuity.",
            pos = "noun", semanticGroup = "time_l4_phases_pro", fillInBlankExclusions = listOf(38821L, 38823L, 38824L, 38825L)),

        WordEntity(id = 38823, setId = 388, languagePair = "en-ru", rarity = "EPIC",
            original = "transience", transliteration = "[ˈtrænziəns]", translation = "быстротечность, недолговечность",
            definition = "The quality of being short-lived — like flowers that bloom for only a day.",
            definitionNative = "Свойство быть недолгим — как цветы, что распускаются всего на день.",
            example = "The poem dwells on the transience of human happiness.",
            exampleNative = "Стихотворение размышляет о transience человеческого счастья.",
            pos = "noun", semanticGroup = "time_l4_phases_pro", fillInBlankExclusions = listOf(38821L, 38822L, 38824L, 38825L)),

        WordEntity(id = 38824, setId = 388, languagePair = "en-ru", rarity = "RARE",
            original = "fleetingness", transliteration = "[ˈfliːtɪŋnəs]", translation = "мимолётность",
            definition = "The way a thing or moment slips by very fast and is gone before you grasp it.",
            definitionNative = "Свойство вещи или мига проскальзывать очень быстро и исчезать раньше, чем ты успел ухватить.",
            example = "She felt the fleetingness of summer as the leaves turned.",
            exampleNative = "Она почувствовала fleetingness лета, когда листья начали желтеть.",
            pos = "noun", semanticGroup = "time_l4_phases_pro", fillInBlankExclusions = listOf(38821L, 38822L, 38823L, 38825L)),

        WordEntity(id = 38825, setId = 388, languagePair = "en-ru", rarity = "RARE",
            original = "ephemerality", transliteration = "[ɪˌfɛməˈrælɪti]", translation = "эфемерность",
            definition = "The quality of being beautiful and very short — like a soap bubble or a sunset.",
            definitionNative = "Свойство быть красивым и очень коротким — как мыльный пузырь или закат.",
            example = "Cherry blossoms are loved for their pure ephemerality.",
            exampleNative = "Сакуру любят за её чистую ephemerality.",
            pos = "noun", semanticGroup = "time_l4_phases_pro", fillInBlankExclusions = listOf(38821L, 38822L, 38823L, 38824L)),
    )
}
