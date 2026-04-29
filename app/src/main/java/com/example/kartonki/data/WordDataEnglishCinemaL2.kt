package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Кино и сериалы (L2, UNCOMMON+RARE).
 *
 * Set 396: «Кино и сериалы» — продвинутый уровень.
 *          Производство (script, crew, producer), продвинутые жанры
 *          (period drama, slasher, noir), техники (close-up, voiceover,
 *          opening credits) и индустрия (spin-off, art house, super-fan)
 *          уровня A2-B2 (UNCOMMON+RARE). Не пересекается с L1 (set 395)
 *          и со старыми «cinema/entertainment» сетами (23 «Кино», 33
 *          «Развлечения», 51 «Медиа-бизнес», 206/245 Expanded, 351-353
 *          EntertainmentL1L2L3, Batch5).
 *
 * Распределение редкости: 18 UNCOMMON + 7 RARE — два смежных уровня
 * (A2-B1 + B2).
 *
 * SemanticGroups (5 × 5):
 *   cinema_l2_production   — script, crew, producer, location, extras
 *   cinema_l2_genres_pro   — period drama, slasher, rom-com, noir, tear-jerker
 *   cinema_l2_techniques   — close-up, voiceover, opening credits, end credits, teaser
 *   cinema_l2_industry     — spin-off, low-budget, big screen, standalone, art house
 *   cinema_l2_audience     — fanbase, cliché, cult, nominee, super-fan
 *
 * Word IDs: setId × 100 + position (39601..39625).
 *
 * fillInBlankExclusions / isFillInBlankSafe не задаются — заполнятся через
 * FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataEnglishCinemaL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 396,
            languagePair = "en-ru",
            orderIndex = 396,
            name = "Кино и сериалы",
            description = "Производство, продвинутые жанры, техники и индустрия",
            topic = "Кино и сериалы",
            level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 396 — Кино и сериалы: продвинутый (L2, UNCOMMON+RARE)        ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── cinema_l2_production (5) ──────────────────────────────────────

        WordEntity(id = 39601, setId = 396, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "script", transliteration = "[skrɪpt]", translation = "сценарий (текст реплик)",
            definition = "The written text of a film with all the words actors must say.",
            definitionNative = "Письменный текст фильма со всеми словами, которые должны сказать актёры.",
            example = "She read the whole script in one evening on her couch.",
            exampleNative = "Она прочитала весь script за один вечер на диване.",
            pos = "noun", semanticGroup = "cinema_l2_production", fillInBlankExclusions = listOf(39602L, 39603L, 39604L, 39605L)),

        WordEntity(id = 39602, setId = 396, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "crew", transliteration = "[kru]", translation = "съёмочная группа",
            definition = "The full team of people who make a film together behind the camera.",
            definitionNative = "Вся команда людей, которые вместе снимают фильм за кадром.",
            example = "The film crew worked sixteen hours a day during the desert shoot.",
            exampleNative = "Этот crew работал по шестнадцать часов в день на съёмках в пустыне.",
            pos = "noun", semanticGroup = "cinema_l2_production", fillInBlankExclusions = listOf(39601L, 39603L, 39604L, 39605L)),

        WordEntity(id = 39603, setId = 396, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "producer", transliteration = "[prəˈdusər]", translation = "продюсер",
            definition = "The person who finds money for a film and runs the whole project.",
            definitionNative = "Человек, который находит деньги на фильм и управляет всем проектом.",
            example = "A young producer from Texas backed her risky first feature.",
            exampleNative = "Молодой producer из Техаса поддержал её рискованный дебют.",
            pos = "noun", semanticGroup = "cinema_l2_production", fillInBlankExclusions = listOf(39601L, 39602L, 39604L, 39605L)),

        WordEntity(id = 39604, setId = 396, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "location", transliteration = "[loʊˈkeɪʃən]", translation = "локация (место съёмки)",
            definition = "A real place outside the studio where part of a film is shot.",
            definitionNative = "Реальное место вне студии, где снимают часть фильма.",
            example = "They picked a quiet Italian village as the main location.",
            exampleNative = "Они выбрали тихую итальянскую деревню главной location.",
            pos = "noun", semanticGroup = "cinema_l2_production", fillInBlankExclusions = listOf(39601L, 39602L, 39603L, 39605L)),

        WordEntity(id = 39605, setId = 396, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "extras", transliteration = "[ˈɛkstrəz]", translation = "массовка",
            definition = "People hired for crowd scenes who walk past or stand without speaking.",
            definitionNative = "Люди, нанятые для массовых сцен — они проходят мимо или стоят без слов.",
            example = "Hundreds of extras filled the busy market in the opening shot.",
            exampleNative = "Сотни extras наполняли шумный рынок в первой сцене.",
            pos = "noun", semanticGroup = "cinema_l2_production", fillInBlankExclusions = listOf(39601L, 39602L, 39603L, 39604L)),

        // ── cinema_l2_genres_pro (5) ──────────────────────────────────────

        WordEntity(id = 39606, setId = 396, languagePair = "en-ru", rarity = "RARE",
            original = "period drama", transliteration = "[ˈpɪriəd ˈdrɑmə]", translation = "историческая драма",
            definition = "A serious film set in the past with old clothes, carriages and manners.",
            definitionNative = "Серьёзный фильм про прошлое — со старинной одеждой, каретами и манерами.",
            example = "She loves any period drama with big dresses and quiet country houses.",
            exampleNative = "Она обожает любую period drama с пышными платьями и тихими усадьбами.",
            pos = "noun", semanticGroup = "cinema_l2_genres_pro", fillInBlankExclusions = listOf(39607L, 39608L, 39609L, 39610L)),

        WordEntity(id = 39607, setId = 396, languagePair = "en-ru", rarity = "RARE",
            original = "slasher", transliteration = "[ˈslæʃər]", translation = "слэшер (хоррор с маньяком)",
            definition = "A horror film about a killer with a knife who chases young people.",
            definitionNative = "Фильм ужасов про убийцу с ножом, который гоняется за молодыми людьми.",
            example = "The new slasher takes place at a summer camp by the lake.",
            exampleNative = "Новый slasher разворачивается в летнем лагере у озера.",
            pos = "noun", semanticGroup = "cinema_l2_genres_pro", fillInBlankExclusions = listOf(39601L, 39606L, 39608L, 39609L, 39610L, 39615L, 39616L)),

        WordEntity(id = 39608, setId = 396, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "rom-com", transliteration = "[ˈrɑmˌkɑm]", translation = "ромком (романтическая комедия)",
            definition = "A light film that mixes a love story with funny everyday moments.",
            definitionNative = "Лёгкий фильм, в котором история любви соединяется со смешными бытовыми моментами.",
            example = "We picked a cosy rom-com for our rainy Sunday afternoon.",
            exampleNative = "Мы выбрали уютный rom-com на дождливый воскресный день.",
            pos = "noun", semanticGroup = "cinema_l2_genres_pro", fillInBlankExclusions = listOf(39604L, 39606L, 39607L, 39609L, 39610L, 39616L)),

        WordEntity(id = 39609, setId = 396, languagePair = "en-ru", rarity = "RARE",
            original = "noir", transliteration = "[nwɑr]", translation = "нуар (мрачный детективный жанр)",
            definition = "A dark crime style with shadows, smoking detectives and risky women.",
            definitionNative = "Мрачный детективный стиль с тенями, курящими сыщиками и опасными женщинами.",
            example = "Classic noir often shows a tired hero alone in a rainy city.",
            exampleNative = "Классический noir часто показывает уставшего героя в дождливом городе.",
            pos = "noun", semanticGroup = "cinema_l2_genres_pro", fillInBlankExclusions = listOf(39606L, 39607L, 39608L, 39610L, 39611L, 39615L, 39616L, 39620L, 39622L)),

        WordEntity(id = 39610, setId = 396, languagePair = "en-ru", rarity = "RARE",
            original = "tear-jerker", transliteration = "[ˈtɪrˌʤɜrkər]", translation = "слёзовыжималка (трогательный фильм)",
            definition = "A film made on purpose to make every viewer cry by the end.",
            definitionNative = "Фильм, специально снятый, чтобы к концу заставить зрителя плакать.",
            example = "Bring tissues for this tear-jerker about a lost dog.",
            exampleNative = "Бери салфетки на этот tear-jerker про потерянную собаку.",
            pos = "noun", semanticGroup = "cinema_l2_genres_pro", fillInBlankExclusions = listOf(39601L, 39606L, 39607L, 39608L, 39609L, 39616L)),

        // ── cinema_l2_techniques (5) ──────────────────────────────────────

        WordEntity(id = 39611, setId = 396, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "close-up", transliteration = "[ˈkloʊsˌʌp]", translation = "крупный план",
            definition = "A camera shot taken very near the subject so the face fills the screen.",
            definitionNative = "Кадр, снятый очень близко, так что лицо занимает весь экран.",
            example = "A long close-up of her eyes told the whole story in silence.",
            exampleNative = "Долгий close-up её глаз рассказал всю историю в тишине.",
            pos = "noun", semanticGroup = "cinema_l2_techniques", fillInBlankExclusions = listOf(39612L, 39613L, 39614L, 39615L)),

        WordEntity(id = 39612, setId = 396, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "voiceover", transliteration = "[ˈvɔɪsˌoʊvər]", translation = "закадровый голос",
            definition = "A speaker we hear over the film who is not seen on the screen.",
            definitionNative = "Голос, который звучит поверх фильма, хотя самого говорящего на экране не видно.",
            example = "A calm voiceover explains the hero's thoughts during the chase.",
            exampleNative = "Спокойный voiceover объясняет мысли героя во время погони.",
            pos = "noun", semanticGroup = "cinema_l2_techniques", fillInBlankExclusions = listOf(39611L, 39613L, 39614L, 39615L)),

        WordEntity(id = 39613, setId = 396, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "opening credits", transliteration = "[ˈoʊpənɪŋ ˈkrɛdɪts]", translation = "вступительные титры",
            definition = "The list of names shown at the very start of a film.",
            definitionNative = "Список имён, который показывают в самом начале фильма.",
            example = "Cool jazz played during the opening credits of the spy film.",
            exampleNative = "Под opening credits шпионского фильма играл прохладный джаз.",
            pos = "noun", semanticGroup = "cinema_l2_techniques", fillInBlankExclusions = listOf(39611L, 39612L, 39614L, 39615L)),

        WordEntity(id = 39614, setId = 396, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "end credits", transliteration = "[ɛnd ˈkrɛdɪts]", translation = "финальные титры",
            definition = "The list of names that scrolls up the screen after the story ends.",
            definitionNative = "Список имён, который ползёт по экрану после конца истории.",
            example = "Loyal fans always wait through the end credits for a secret scene.",
            exampleNative = "Преданные фанаты всегда сидят до конца end credits ради секретной сцены.",
            pos = "noun", semanticGroup = "cinema_l2_techniques", fillInBlankExclusions = listOf(39611L, 39612L, 39613L, 39615L)),

        WordEntity(id = 39615, setId = 396, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "teaser", transliteration = "[ˈtizər]", translation = "тизер (короткий анонс)",
            definition = "A very short clip released early to get people excited about a film.",
            definitionNative = "Очень короткий ролик, который выпускают заранее, чтобы заинтриговать зрителя.",
            example = "The thirty-second teaser hinted at a hidden villain in the sequel.",
            exampleNative = "Тридцатисекундный teaser намекнул на скрытого злодея в продолжении.",
            pos = "noun", semanticGroup = "cinema_l2_techniques", fillInBlankExclusions = listOf(39611L, 39612L, 39613L, 39614L)),

        // ── cinema_l2_industry (5) ────────────────────────────────────────

        WordEntity(id = 39616, setId = 396, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "spin-off", transliteration = "[ˈspɪnˌɔf]", translation = "спин-офф (отдельная серия по миру)",
            definition = "A new show built around a side character from a popular older show.",
            definitionNative = "Новый сериал, построенный вокруг второстепенного персонажа из популярного старого сериала.",
            example = "The detective got his own spin-off after fans loved his side story.",
            exampleNative = "Детектив получил свой spin-off после того, как фанаты полюбили его линию.",
            pos = "noun", semanticGroup = "cinema_l2_industry", fillInBlankExclusions = listOf(39601L, 39606L, 39607L, 39608L, 39609L, 39610L, 39618L, 39619L, 39620L)),

        WordEntity(id = 39617, setId = 396, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "low-budget", transliteration = "[ˌloʊ ˈbʌʤɪt]", translation = "малобюджетный",
            definition = "Made with very little money compared to a normal big studio film.",
            definitionNative = "Снятый за очень маленькие деньги по сравнению с обычным большим фильмом студии.",
            example = "His low-budget thriller still beat the big summer blockbuster.",
            exampleNative = "Его low-budget триллер всё равно обошёл крупный летний блокбастер.",
            pos = "adjective", semanticGroup = "cinema_l2_industry", fillInBlankExclusions = listOf(39607L, 39609L, 39616L, 39619L, 39620L, 39623L)),

        WordEntity(id = 39618, setId = 396, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "big screen", transliteration = "[bɪɡ skrin]", translation = "большой экран (кинотеатр)",
            definition = "The cinema as a place to watch a film, not a home TV or phone.",
            definitionNative = "Кинотеатр как место просмотра фильма — не домашний телевизор или телефон.",
            example = "The space scenes really come alive on the big screen.",
            exampleNative = "Космические сцены по-настоящему оживают на big screen.",
            pos = "noun", semanticGroup = "cinema_l2_industry", fillInBlankExclusions = listOf(39616L, 39620L)),

        WordEntity(id = 39619, setId = 396, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "standalone", transliteration = "[ˈstændəˌloʊn]", translation = "самостоятельный (фильм без серии)",
            definition = "Made to be watched on its own without any other parts before or after.",
            definitionNative = "Снятый так, чтобы его смотрели сам по себе, без других частей до или после.",
            example = "This standalone film tells one full story in two hours.",
            exampleNative = "Этот standalone фильм рассказывает целую историю за два часа.",
            pos = "adjective", semanticGroup = "cinema_l2_industry", fillInBlankExclusions = listOf(39607L, 39609L, 39610L, 39616L, 39617L, 39620L, 39623L)),

        WordEntity(id = 39620, setId = 396, languagePair = "en-ru", rarity = "RARE",
            original = "art house", transliteration = "[ɑrt haʊs]", translation = "артхаус (авторское кино)",
            definition = "Slow serious cinema made for taste and ideas rather than wide profit.",
            definitionNative = "Медленное серьёзное кино, сделанное ради вкуса и идей, а не широкой прибыли.",
            example = "Quiet art house films often fill small festival cinemas.",
            exampleNative = "Тихие art house фильмы часто заполняют маленькие фестивальные кинотеатры.",
            pos = "noun", semanticGroup = "cinema_l2_industry", fillInBlankExclusions = listOf(39606L, 39609L, 39610L, 39616L, 39617L, 39618L, 39619L, 39623L)),

        // ── cinema_l2_audience (5) ────────────────────────────────────────

        WordEntity(id = 39621, setId = 396, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "fanbase", transliteration = "[ˈfænˌbeɪs]", translation = "база поклонников",
            definition = "The whole group of regular viewers who love a film or actor.",
            definitionNative = "Вся группа постоянных зрителей, которые любят фильм или актёра.",
            example = "The young actor already has a loyal fanbase across three countries.",
            exampleNative = "У молодого актёра уже есть преданная fanbase в трёх странах.",
            pos = "noun", semanticGroup = "cinema_l2_audience", fillInBlankExclusions = listOf(39622L, 39624L, 39625L)),

        WordEntity(id = 39622, setId = 396, languagePair = "en-ru", rarity = "RARE",
            original = "cliché", transliteration = "[kliˈʃeɪ]", translation = "клише (избитый приём)",
            definition = "A scene or line used so often in films that it feels boring now.",
            definitionNative = "Сцена или фраза, использованная в фильмах так часто, что уже надоела.",
            example = "The dying-by-Christmas-tree scene is a sad holiday cliché.",
            exampleNative = "Сцена смерти у новогодней ёлки — печальный праздничный cliché.",
            pos = "noun", semanticGroup = "cinema_l2_audience", fillInBlankExclusions = listOf(39610L, 39621L, 39624L, 39625L)),

        WordEntity(id = 39623, setId = 396, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "cult", transliteration = "[kʌlt]", translation = "культовый (фильм со фанатами-знатоками)",
            definition = "Loved fiercely by a small group of viewers years after release.",
            definitionNative = "Любимый страстно небольшой группой зрителей через много лет после выхода.",
            example = "That weird cult film still plays at midnight on Saturdays downtown.",
            exampleNative = "Тот странный cult фильм до сих пор крутят в полночь по субботам в центре.",
            pos = "adjective", semanticGroup = "cinema_l2_audience", fillInBlankExclusions = listOf(39606L, 39607L, 39609L, 39610L, 39616L, 39617L, 39619L, 39620L)),

        WordEntity(id = 39624, setId = 396, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "nominee", transliteration = "[ˌnɑməˈni]", translation = "номинант (на премию)",
            definition = "A person or film picked for a possible award but maybe not the winner.",
            definitionNative = "Человек или фильм, выбранный на возможную премию, но не обязательно победитель.",
            example = "Every nominee walked the red carpet before the ceremony started.",
            exampleNative = "Каждый nominee прошёл по красной дорожке до начала церемонии.",
            pos = "noun", semanticGroup = "cinema_l2_audience", fillInBlankExclusions = listOf(39603L, 39621L, 39622L, 39625L)),

        WordEntity(id = 39625, setId = 396, languagePair = "en-ru", rarity = "RARE",
            original = "super-fan", transliteration = "[ˈsupərˌfæn]", translation = "ярый фанат",
            definition = "A wildly devoted fan who knows every detail and follows every news bit.",
            definitionNative = "Безумно преданный фанат, знающий каждую деталь и следящий за каждой новостью.",
            example = "Only a true super-fan would queue all night for the premiere.",
            exampleNative = "Только настоящий super-fan простоит в очереди всю ночь ради премьеры.",
            pos = "noun", semanticGroup = "cinema_l2_audience", fillInBlankExclusions = listOf(39621L, 39622L, 39624L)),
    )
}
