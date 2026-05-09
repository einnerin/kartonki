package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Кино и сериалы: жанры и сабжанры.
 * Set 456 (L2-L3, UNCOMMON+RARE) — расширение темы «Кино и сериалы»
 * (наряду с L1-L5: 395, 396, 397, 398, 399). Фокус — конкретные жанровые
 * подвиды и форматы, не пересекающиеся со старыми сетами темы.
 *
 * Уже занятые в L1-L5 и потому обойдённые: rom-com, slasher, period drama,
 * noir, tear-jerker, neo-noir, found-footage, body horror, kitchen-sink drama,
 * art-house, biopic, ensemble cast, mockumentary (Entertainment), sitcom
 * (Entertainment), anthology (Expanded), magical realism (EntertainmentL5),
 * anthology series (EntertainmentL5), satire (Base), parody (Expanded),
 * whodunit (Literature), anime (Entertainment).
 *
 * Все 25 слов проверены grep'ом по `original = "..."` против всех
 * WordDataEnglish*.kt — дублей нет.
 *
 * Распределение редкости: 17 UNCOMMON + 8 RARE — два смежных уровня (B1 + B2).
 *
 * SemanticGroups (5 × 5):
 *   cinema_genres_comedy_subtypes  — dark comedy, screwball comedy, cringe comedy, buddy comedy, dramedy
 *   cinema_genres_drama_subtypes   — melodrama, courtroom drama, legal drama, medical drama, costume drama
 *   cinema_genres_thriller_horror  — spy thriller, psychological thriller, heist film, supernatural horror, monster movie
 *   cinema_genres_tv_formats       — soap opera, procedural, miniseries, docuseries, limited series
 *   cinema_genres_hybrid_intl      — K-drama, telenovela, road movie, spaghetti western, disaster film
 *
 * Word IDs: setId × 100 + position (45601..45625).
 *
 * fillInBlankExclusions / isFillInBlankSafe заполнятся через FILL_IN_BLANK
 * pipeline после валидации (известный баг: если задать заранее, pipeline
 * пропустит запись).
 */
object WordDataEnglishCinemaGenres {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 456,
            languagePair = "en-ru",
            orderIndex = 456,
            name = "Кино и сериалы",
            description = "Жанры и сабжанры: rom-com, neo-noir, mockumentary",
            topic = "Кино и сериалы",
            level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 456 — Кино и сериалы: жанры и сабжанры (L2-L3, UNCOMMON+RARE)║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── cinema_genres_comedy_subtypes (5) ─────────────────────────────

        WordEntity(id = 45601, setId = 456, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "dark comedy", transliteration = "[dɑrk ˈkɑmədi]", translation = "чёрная комедия",
            definition = "A funny film about gloomy or painful topics like death, illness or crime.",
            definitionNative = "Смешной фильм про мрачные или больные темы — смерть, болезнь, преступление.",
            example = "The dark comedy makes you laugh and then feel a little guilty about it.",
            exampleNative = "Этот dark comedy сначала смешит, а потом заставляет чувствовать себя виноватым.",
            pos = "noun", semanticGroup = "cinema_genres_comedy_subtypes", fillInBlankExclusions = listOf(45602L, 45603L, 45604L, 45605L)),

        WordEntity(id = 45602, setId = 456, languagePair = "en-ru", rarity = "RARE",
            original = "screwball comedy", transliteration = "[ˈskruˌbɔl ˈkɑmədi]", translation = "эксцентричная комедия",
            definition = "A wild fast-talking film style from old Hollywood about clashing romantic partners.",
            definitionNative = "Безумный болтливый стиль старого Голливуда о паре, которая вечно ссорится и спорит.",
            example = "Hepburn and Grant defined the screwball comedy in the late thirties.",
            exampleNative = "Хепбёрн и Грант задали стиль screwball comedy в конце тридцатых.",
            pos = "noun", semanticGroup = "cinema_genres_comedy_subtypes", fillInBlankExclusions = listOf(45601L, 45603L, 45604L, 45605L)),

        WordEntity(id = 45603, setId = 456, languagePair = "en-ru", rarity = "RARE",
            original = "cringe comedy", transliteration = "[krɪnʤ ˈkɑmədi]", translation = "комедия неловкости",
            definition = "A style built on awkward social moments that make you wince and laugh together.",
            definitionNative = "Стиль на неловких социальных моментах, от которых одновременно морщишься и смеёшься.",
            example = "The British office sitcom is a textbook cringe comedy.",
            exampleNative = "Британский офисный ситком — хрестоматийный cringe comedy.",
            pos = "noun", semanticGroup = "cinema_genres_comedy_subtypes", fillInBlankExclusions = listOf(45601L, 45602L, 45604L, 45605L)),

        WordEntity(id = 45604, setId = 456, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "buddy comedy", transliteration = "[ˈbʌdi ˈkɑmədi]", translation = "приятельская комедия",
            definition = "A funny film about two mismatched friends who travel or work together.",
            definitionNative = "Смешной фильм про двух непохожих друзей, которые куда-то едут или работают вместе.",
            example = "The buddy comedy follows a quiet librarian and a loud truck driver across Texas.",
            exampleNative = "Этот buddy comedy ведёт тихого библиотекаря и шумного дальнобойщика через Техас.",
            pos = "noun", semanticGroup = "cinema_genres_comedy_subtypes", fillInBlankExclusions = listOf(45601L, 45602L, 45603L, 45605L)),

        WordEntity(id = 45605, setId = 456, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "dramedy", transliteration = "[ˈdrɑmədi]", translation = "драмеди (драма с элементами комедии)",
            definition = "A film that mixes serious drama with light moments of humor in equal measure.",
            definitionNative = "Фильм, в котором серьёзная драма поровну смешана с лёгкими смешными моментами.",
            example = "Her new dramedy about a failing bakery balances tears and laughs nicely.",
            exampleNative = "Её новый dramedy про разоряющуюся пекарню удачно балансирует слёзы и смех.",
            pos = "noun", semanticGroup = "cinema_genres_comedy_subtypes", fillInBlankExclusions = listOf(45601L, 45602L, 45603L, 45604L)),

        // ── cinema_genres_drama_subtypes (5) ──────────────────────────────

        WordEntity(id = 45606, setId = 456, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "melodrama", transliteration = "[ˈmɛləˌdrɑmə]", translation = "мелодрама",
            definition = "An emotional film with strong feelings, sudden tears and a clear villain to hate.",
            definitionNative = "Эмоциональный фильм с сильными чувствами, резкими слезами и явным злодеем, чтобы его ненавидеть.",
            example = "Grandma never misses a Sunday afternoon melodrama on the old channel.",
            exampleNative = "Бабушка никогда не пропустит воскресную melodrama на старом канале.",
            pos = "noun", semanticGroup = "cinema_genres_drama_subtypes", fillInBlankExclusions = listOf(45607L, 45608L, 45609L, 45610L)),

        WordEntity(id = 45607, setId = 456, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "courtroom drama", transliteration = "[ˈkɔrtˌrum ˈdrɑmə]", translation = "судебная драма",
            definition = "A serious film set mostly inside a courtroom around a difficult trial.",
            definitionNative = "Серьёзный фильм, действие которого почти целиком проходит в зале суда вокруг сложного процесса.",
            example = "The courtroom drama keeps the whole jury on screen for two solid hours.",
            exampleNative = "Этот courtroom drama держит присяжных в кадре два часа подряд.",
            pos = "noun", semanticGroup = "cinema_genres_drama_subtypes", fillInBlankExclusions = listOf(45606L, 45608L, 45609L, 45610L)),

        WordEntity(id = 45608, setId = 456, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "legal drama", transliteration = "[ˈliɡəl ˈdrɑmə]", translation = "юридическая драма",
            definition = "A serious film or show about lawyers, court cases and the rules they fight over.",
            definitionNative = "Серьёзный фильм или сериал про юристов, дела в суде и правила, за которые они борются.",
            example = "She got hooked on a long legal drama about a tiny firm taking on huge banks.",
            exampleNative = "Она подсела на длинный legal drama про маленькую фирму против крупных банков.",
            pos = "noun", semanticGroup = "cinema_genres_drama_subtypes", fillInBlankExclusions = listOf(45606L, 45607L, 45609L, 45610L)),

        WordEntity(id = 45609, setId = 456, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "medical drama", transliteration = "[ˈmɛdɪkəl ˈdrɑmə]", translation = "медицинская драма",
            definition = "A serious show set in a hospital around doctors, nurses and very sick patients.",
            definitionNative = "Серьёзный сериал, действие которого идёт в больнице вокруг врачей, медсестёр и тяжёлых пациентов.",
            example = "The medical drama follows a young surgeon through her first year on the ward.",
            exampleNative = "Этот medical drama ведёт молодого хирурга через её первый год в отделении.",
            pos = "noun", semanticGroup = "cinema_genres_drama_subtypes", fillInBlankExclusions = listOf(45606L, 45607L, 45608L, 45610L)),

        WordEntity(id = 45610, setId = 456, languagePair = "en-ru", rarity = "RARE",
            original = "costume drama", transliteration = "[ˈkɑstum ˈdrɑmə]", translation = "костюмированная драма",
            definition = "A film set in the past where lavish historical clothing carries half the story.",
            definitionNative = "Фильм про прошлое, где половину истории несёт пышный исторический наряд.",
            example = "Every costume drama on the BBC pulls in millions of weekend viewers.",
            exampleNative = "Каждая costume drama на BBC собирает миллионы зрителей в выходные.",
            pos = "noun", semanticGroup = "cinema_genres_drama_subtypes", fillInBlankExclusions = listOf(45606L, 45607L, 45608L, 45609L)),

        // ── cinema_genres_thriller_horror (5) ─────────────────────────────

        WordEntity(id = 45611, setId = 456, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "spy thriller", transliteration = "[spaɪ ˈθrɪlər]", translation = "шпионский триллер",
            definition = "A tense film about secret agents, hidden codes and dangerous foreign missions.",
            definitionNative = "Напряжённый фильм про тайных агентов, шифры и опасные миссии за рубежом.",
            example = "The cold-war spy thriller jumps between Berlin, Vienna and Helsinki.",
            exampleNative = "Этот spy thriller времён холодной войны прыгает между Берлином, Веной и Хельсинки.",
            pos = "noun", semanticGroup = "cinema_genres_thriller_horror", fillInBlankExclusions = listOf(45612L, 45613L, 45614L, 45615L)),

        WordEntity(id = 45612, setId = 456, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "psychological thriller", transliteration = "[ˌsaɪkəˈlɑʤɪkəl ˈθrɪlər]", translation = "психологический триллер",
            definition = "A tense film that scares the viewer through twisted minds rather than open violence.",
            definitionNative = "Напряжённый фильм, который пугает зрителя извращёнными умами, а не открытой жестокостью.",
            example = "The psychological thriller slowly makes you doubt the hero's whole memory.",
            exampleNative = "Этот psychological thriller медленно заставляет сомневаться во всей памяти героя.",
            pos = "noun", semanticGroup = "cinema_genres_thriller_horror", fillInBlankExclusions = listOf(45611L, 45613L, 45614L, 45615L)),

        WordEntity(id = 45613, setId = 456, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "heist film", transliteration = "[haɪst fɪlm]", translation = "фильм-ограбление",
            definition = "A film about a clever team that plans and pulls off a big robbery together.",
            definitionNative = "Фильм про ловкую команду, которая планирует и проворачивает крупное ограбление вместе.",
            example = "The heist film ends with the gang walking out of the casino with two suitcases.",
            exampleNative = "Этот heist film кончается тем, как банда выходит из казино с двумя чемоданами.",
            pos = "noun", semanticGroup = "cinema_genres_thriller_horror", fillInBlankExclusions = listOf(45611L, 45612L, 45614L, 45615L)),

        WordEntity(id = 45614, setId = 456, languagePair = "en-ru", rarity = "RARE",
            original = "supernatural horror", transliteration = "[ˌsupərˈnæʧərəl ˈhɔrər]", translation = "сверхъестественный хоррор",
            definition = "A scary film driven by ghosts, demons or other forces from beyond our world.",
            definitionNative = "Страшный фильм, движимый призраками, демонами или иными силами из-за пределов нашего мира.",
            example = "The supernatural horror centres on a haunted Victorian dollhouse.",
            exampleNative = "Этот supernatural horror строится вокруг проклятого викторианского кукольного домика.",
            pos = "noun", semanticGroup = "cinema_genres_thriller_horror", fillInBlankExclusions = listOf(45611L, 45612L, 45613L, 45615L)),

        WordEntity(id = 45615, setId = 456, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "monster movie", transliteration = "[ˈmɑnstər ˈmuvi]", translation = "фильм про монстра",
            definition = "A loud scary film built around a giant creature that destroys cities and people.",
            definitionNative = "Громкий страшный фильм вокруг огромного существа, что разносит города и людей.",
            example = "The classic monster movie still scares teenagers at midnight screenings.",
            exampleNative = "Классический monster movie до сих пор пугает подростков на полуночных сеансах.",
            pos = "noun", semanticGroup = "cinema_genres_thriller_horror", fillInBlankExclusions = listOf(45611L, 45612L, 45613L, 45614L)),

        // ── cinema_genres_tv_formats (5) ──────────────────────────────────

        WordEntity(id = 45616, setId = 456, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "soap opera", transliteration = "[soʊp ˈɑpərə]", translation = "мыльная опера",
            definition = "A long emotional show with many families, secret affairs and never-ending storylines.",
            definitionNative = "Длинный эмоциональный сериал со множеством семей, тайных романов и бесконечных сюжетов.",
            example = "Mum has watched the same soap opera every weekday for thirty years.",
            exampleNative = "Мама смотрит одну и ту же soap opera каждый будний день уже тридцать лет.",
            pos = "noun", semanticGroup = "cinema_genres_tv_formats", fillInBlankExclusions = listOf(45617L, 45618L, 45619L, 45620L)),

        WordEntity(id = 45617, setId = 456, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "procedural", transliteration = "[prəˈsiʤərəl]", translation = "процедурал (сериал «дело недели»)",
            definition = "A show where a fresh case opens and closes inside almost every single episode.",
            definitionNative = "Сериал, в котором каждое новое дело открывается и закрывается в пределах одной серии.",
            example = "The police procedural wraps up a separate murder case each Sunday night.",
            exampleNative = "Этот police procedural раскручивает отдельное убийство каждое воскресенье.",
            pos = "noun", semanticGroup = "cinema_genres_tv_formats", fillInBlankExclusions = listOf(45616L, 45618L, 45619L, 45620L)),

        WordEntity(id = 45618, setId = 456, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "miniseries", transliteration = "[ˈmɪniˌsɪriz]", translation = "мини-сериал",
            definition = "A short show with a clear ending, usually only four to eight episodes long.",
            definitionNative = "Короткий сериал с чётким финалом — обычно от четырёх до восьми серий.",
            example = "The miniseries about the lighthouse keeper finished after only six episodes.",
            exampleNative = "Этот miniseries про смотрителя маяка кончился всего за шесть серий.",
            pos = "noun", semanticGroup = "cinema_genres_tv_formats", fillInBlankExclusions = listOf(45616L, 45617L, 45619L, 45620L)),

        WordEntity(id = 45619, setId = 456, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "docuseries", transliteration = "[ˈdɑkjəˌsɪriz]", translation = "документальный сериал",
            definition = "A non-fiction show built from real footage that runs across several episodes.",
            definitionNative = "Документальный сериал из настоящих съёмок, идущий через несколько серий.",
            example = "Their docuseries about wildfire crews captured every long sleepless night.",
            exampleNative = "Их docuseries о пожарных бригадах снял каждую долгую бессонную ночь.",
            pos = "noun", semanticGroup = "cinema_genres_tv_formats", fillInBlankExclusions = listOf(45616L, 45617L, 45618L, 45620L)),

        WordEntity(id = 45620, setId = 456, languagePair = "en-ru", rarity = "RARE",
            original = "limited series", transliteration = "[ˈlɪmətəd ˈsɪriz]", translation = "ограниченный сериал",
            definition = "A premium show planned from the start to wrap up in a single complete season.",
            definitionNative = "Премиальный сериал, изначально задуманный закрыть всю историю за один полный сезон.",
            example = "The limited series tells the trial story tightly across eight strong hours.",
            exampleNative = "Этот limited series плотно рассказывает суд за восемь сильных часов.",
            pos = "noun", semanticGroup = "cinema_genres_tv_formats", fillInBlankExclusions = listOf(45616L, 45617L, 45618L, 45619L)),

        // ── cinema_genres_hybrid_intl (5) ─────────────────────────────────

        WordEntity(id = 45621, setId = 456, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "K-drama", transliteration = "[ˈkeɪ ˈdrɑmə]", translation = "корейская дорама",
            definition = "A South Korean show, usually romantic, with a closed plot inside one neat season.",
            definitionNative = "Южнокорейский сериал, обычно романтический, с закрытым сюжетом в одном аккуратном сезоне.",
            example = "Her favourite K-drama runs sixteen episodes from chance meeting to wedding.",
            exampleNative = "Её любимая K-drama идёт шестнадцать серий от случайной встречи до свадьбы.",
            pos = "noun", semanticGroup = "cinema_genres_hybrid_intl", fillInBlankExclusions = listOf(45622L, 45623L, 45624L, 45625L)),

        WordEntity(id = 45622, setId = 456, languagePair = "en-ru", rarity = "RARE",
            original = "telenovela", transliteration = "[ˌtɛlənoʊˈvɛlə]", translation = "латиноамериканская теленовелла",
            definition = "A Latin American emotional show that runs every weekday and ends after one big arc.",
            definitionNative = "Латиноамериканский эмоциональный сериал, что идёт каждый будний день и кончается после одной большой арки.",
            example = "The Mexican telenovela kept the whole neighbourhood glued to the screen at eight.",
            exampleNative = "Эта мексиканская telenovela приклеила к экрану весь квартал в восемь вечера.",
            pos = "noun", semanticGroup = "cinema_genres_hybrid_intl", fillInBlankExclusions = listOf(45621L, 45623L, 45624L, 45625L)),

        WordEntity(id = 45623, setId = 456, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "road movie", transliteration = "[roʊd ˈmuvi]", translation = "роуд-муви (фильм-путешествие)",
            definition = "A film whose heroes drive across long distances, changing inside as the miles pass.",
            definitionNative = "Фильм, чьи герои едут на большие расстояния и меняются внутри по мере дороги.",
            example = "The classic road movie follows two sisters from Texas to the Pacific coast.",
            exampleNative = "Классический road movie ведёт двух сестёр из Техаса к побережью Тихого океана.",
            pos = "noun", semanticGroup = "cinema_genres_hybrid_intl", fillInBlankExclusions = listOf(45621L, 45622L, 45624L, 45625L)),

        WordEntity(id = 45624, setId = 456, languagePair = "en-ru", rarity = "RARE",
            original = "spaghetti western", transliteration = "[spəˈɡɛti ˈwɛstərn]", translation = "спагетти-вестерн",
            definition = "A gritty western made cheaply in Italy in the sixties, often with a lone gunslinger.",
            definitionNative = "Жёсткий вестерн, дёшево снятый в Италии в шестидесятые, часто с одиноким стрелком.",
            example = "Leone's spaghetti western made Eastwood a global star almost overnight.",
            exampleNative = "spaghetti western Леоне сделал Иствуда мировой звездой почти за одну ночь.",
            pos = "noun", semanticGroup = "cinema_genres_hybrid_intl", fillInBlankExclusions = listOf(45621L, 45622L, 45623L, 45625L)),

        WordEntity(id = 45625, setId = 456, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "disaster film", transliteration = "[dɪˈzæstər fɪlm]", translation = "фильм-катастрофа",
            definition = "A loud big film about a huge crisis that hits a city — earthquake, flood or fire.",
            definitionNative = "Громкий большой фильм про огромную беду, что бьёт по городу — землетрясение, потоп или пожар.",
            example = "The disaster film opens with a giant wave swallowing the harbour at sunset.",
            exampleNative = "Этот disaster film открывается тем, как огромная волна глотает гавань на закате.",
            pos = "noun", semanticGroup = "cinema_genres_hybrid_intl", fillInBlankExclusions = listOf(45621L, 45622L, 45623L, 45624L)),
    )
}
