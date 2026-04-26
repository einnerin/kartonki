package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Развлечения и досуг (levels 1-3).
 *
 * Set 351: «Развлечения и досуг» — основы (L1, COMMON+UNCOMMON):
 *          игры, шоу, вечеринки, детские забавы.
 * Set 352: «Развлечения и досуг» — продвинутые (L2, UNCOMMON+RARE):
 *          жанры экрана, события, гейминг, стриминг, фан-культура.
 * Set 353: «Развлечения и досуг» — углублённые (L3, RARE+EPIC):
 *          индустрия, продакшн, киноязык, гейм-дизайн, фандом.
 *
 * Слова не пересекаются с темами «Культура и искусство» (en-ru: 23, 60, 80,
 * 202, 205, 206, 224, 225, 238, 239, 242, 245, 259, 321) и «Спорт» (17, 210,
 * 253). Все cross-topic совпадения лежат вне Культуры/Спорта (Транспорт,
 * Технологии, Лингвистика, Семья, Город) — допустимо.
 *
 * Распределение редкости:
 *   Set 351: 20 COMMON + 5 UNCOMMON.
 *   Set 352: 16 UNCOMMON + 9 RARE.
 *   Set 353: 22 RARE + 3 EPIC.
 *
 * SemanticGroups (5 × 5 в каждом сете):
 *   Set 351:
 *     entertainment_party_social   — party, picnic, sleepover, club, friend
 *     entertainment_humor_fun      — fun, joke, laugh, magic, trick
 *     entertainment_kids_outdoor   — swing, slide, kite, hopscotch, bowling
 *     entertainment_games_indoor   — game, toy, puzzle, riddle, quiz
 *     entertainment_show_event     — video, show, prize, ticket, ride
 *   Set 352:
 *     entertainment_screen_genres  — drama, thriller, anime, sitcom, prequel
 *     entertainment_offline_events — festival, escape-room, karaoke, paintball, cosplay
 *     entertainment_gaming_gear    — gamer, console, controller, mod, multiplayer
 *     entertainment_streaming      — stream, podcast, playlist, unboxing, binge-watch
 *     entertainment_fan_meta       — spoiler, leaderboard, achievement, glitch, fanfic
 *   Set 353:
 *     entertainment_storytelling   — antihero, plot-twist, denouement, mockumentary, trope
 *     entertainment_film_craft     — easter-egg, soundtrack, tracking-shot, jump-scare, blooper
 *     entertainment_game_design    — sandbox, indie-game, roguelike, RPG, MMO
 *     entertainment_production     — worldbuilding, lore, canon, showrunner, finale
 *     entertainment_fan_culture    — speedrun, fandom, esports, grind, leveling
 *
 * Word IDs: setId × 100 + position (35101..35125, 35201..35225, 35301..35325).
 */
object WordDataEnglishEntertainmentL1L2L3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 351, name = "Развлечения и досуг",
            description = "Базовая лексика про игры, кино и хобби для повседневных разговоров",
            languagePair = "en-ru",
            orderIndex = 302,
            topic = "Развлечения и досуг", level = 1),
        WordSetEntity(
            id = 352, name = "Развлечения и досуг",
            description = "Продвинутая лексика развлечений: жанры, события, гейминг, стриминг",
            languagePair = "en-ru",
            orderIndex = 303,
            topic = "Развлечения и досуг", level = 2),
        WordSetEntity(
            id = 353, name = "Развлечения и досуг",
            description = "Углублённая лексика индустрии: продакшн, киноязык, гейм-дизайн, ивенты",
            languagePair = "en-ru",
            orderIndex = 304,
            topic = "Развлечения и досуг", level = 3),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 351 — Развлечения и досуг: основы (L1, COMMON+UNCOMMON)      ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── entertainment_party_social (5) ────────────────────────────────

        WordEntity(id = 35101, setId = 351, languagePair = "en-ru", rarity = "COMMON",
            original = "party", transliteration = "[ˈpɑrti]", translation = "вечеринка",
            definition = "A happy meeting where people eat, talk, dance and have fun.",
            definitionNative = "Весёлая встреча, где люди едят, болтают, танцуют и развлекаются.",
            example = "We had a big party at home for my tenth birthday.",
            exampleNative = "У нас дома была большая party на мой десятый день рождения.",
            pos = "noun", semanticGroup = "entertainment_party_social", fillInBlankExclusions = listOf(35102L, 35103L, 35104L, 35105L, 35116L)),

        WordEntity(id = 35102, setId = 351, languagePair = "en-ru", rarity = "COMMON",
            original = "picnic", transliteration = "[ˈpɪknɪk]", translation = "пикник",
            definition = "A meal eaten outside on the grass, often with sandwiches and fruit.",
            definitionNative = "Еда, которую едят на улице на траве, часто с бутербродами и фруктами.",
            example = "We took bread and cheese for a picnic by the river.",
            exampleNative = "Мы взяли хлеб и сыр на picnic у реки.",
            pos = "noun", semanticGroup = "entertainment_party_social", fillInBlankExclusions = listOf(35101L, 35103L, 35104L, 35105L)),

        WordEntity(id = 35103, setId = 351, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "sleepover", transliteration = "[ˈslipˌoʊvər]", translation = "ночёвка у друзей",
            definition = "A night when kids stay at a friend's house to play, eat and sleep.",
            definitionNative = "Ночь, когда дети остаются у друга играть, есть и спать.",
            example = "My daughter is going to a sleepover at her best friend's place.",
            exampleNative = "Моя дочь идёт на sleepover к своей лучшей подруге.",
            pos = "noun", semanticGroup = "entertainment_party_social", fillInBlankExclusions = listOf(35101L, 35102L, 35104L, 35116L, 35120L, 35122L)),

        WordEntity(id = 35104, setId = 351, languagePair = "en-ru", rarity = "COMMON",
            original = "club", transliteration = "[kləb]", translation = "клуб (по интересам)",
            definition = "A group of people who meet often to share a hobby or activity.",
            definitionNative = "Группа людей, регулярно встречающихся ради общего хобби или занятия.",
            example = "She joined a chess club after school every Tuesday.",
            exampleNative = "Она ходит в шахматный club после школы по вторникам.",
            pos = "noun", semanticGroup = "entertainment_party_social", fillInBlankExclusions = listOf(35101L, 35102L, 35103L, 35105L, 35116L)),

        WordEntity(id = 35105, setId = 351, languagePair = "en-ru", rarity = "COMMON",
            original = "friend", transliteration = "[frɛnd]", translation = "друг (с кем играешь и проводишь время)",
            definition = "A person you like a lot and spend free time with for fun.",
            definitionNative = "Человек, который тебе очень нравится и с кем проводишь свободное время.",
            example = "My best friend invited me to her birthday party on Saturday.",
            exampleNative = "Мой лучший friend пригласила меня на день рождения в субботу.",
            pos = "noun", semanticGroup = "entertainment_party_social", fillInBlankExclusions = listOf(35102L, 35103L, 35104L)),

        // ── entertainment_humor_fun (5) ───────────────────────────────────

        WordEntity(id = 35106, setId = 351, languagePair = "en-ru", rarity = "COMMON",
            original = "fun", transliteration = "[fən]", translation = "веселье; весёлый",
            definition = "A pleasant feeling you get from doing something that you enjoy.",
            definitionNative = "Приятное чувство, которое возникает, когда занимаешься тем, что нравится.",
            example = "We had so much fun at the water park last summer.",
            exampleNative = "Мы получили столько fun в аквапарке прошлым летом.",
            pos = "noun", semanticGroup = "entertainment_humor_fun", fillInBlankExclusions = listOf(35107L, 35109L, 35110L)),

        WordEntity(id = 35107, setId = 351, languagePair = "en-ru", rarity = "COMMON",
            original = "joke", transliteration = "[ʤoʊk]", translation = "шутка",
            definition = "A short funny story or remark that makes people smile or giggle.",
            definitionNative = "Короткая смешная история или фраза, от которой улыбаются или хихикают.",
            example = "Grandpa told a silly joke and everyone at the table giggled.",
            exampleNative = "Дедушка рассказал глупую joke, и все за столом захихикали.",
            pos = "noun", semanticGroup = "entertainment_humor_fun", fillInBlankExclusions = listOf(35106L, 35109L, 35110L, 35119L)),

        WordEntity(id = 35108, setId = 351, languagePair = "en-ru", rarity = "COMMON",
            original = "laugh", transliteration = "[læf]", translation = "смеяться",
            definition = "To make happy sounds when something is funny or makes you smile.",
            definitionNative = "Издавать радостные звуки, когда что-то смешное или вызывает улыбку.",
            example = "The kids began to laugh when the puppy fell into the pool.",
            exampleNative = "Дети начали laugh, когда щенок плюхнулся в бассейн.",
            pos = "verb", semanticGroup = "entertainment_humor_fun"),

        WordEntity(id = 35109, setId = 351, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "magic", transliteration = "[ˈmæʤɪk]", translation = "магия / волшебство",
            definition = "Tricks or wonderful events that look like they break the usual rules.",
            definitionNative = "Фокусы или чудеса, которые выглядят так, будто нарушают обычные правила.",
            example = "The boy loved books about magic, dragons and tall castles.",
            exampleNative = "Мальчик обожал книги про magic, драконов и высокие замки.",
            pos = "noun", semanticGroup = "entertainment_humor_fun", fillInBlankExclusions = listOf(35106L, 35107L, 35110L)),

        WordEntity(id = 35110, setId = 351, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "trick", transliteration = "[trɪk]", translation = "трюк / фокус",
            definition = "A clever action that surprises people or makes them think they saw magic.",
            definitionNative = "Ловкое действие, которое удивляет людей или создаёт впечатление чуда.",
            example = "He showed me a card trick and I could not see how it worked.",
            exampleNative = "Он показал мне карточный trick, и я не понял, как это устроено.",
            pos = "noun", semanticGroup = "entertainment_humor_fun", fillInBlankExclusions = listOf(35106L, 35107L, 35109L, 35116L)),

        // ── entertainment_kids_outdoor (5) ────────────────────────────────

        WordEntity(id = 35111, setId = 351, languagePair = "en-ru", rarity = "COMMON",
            original = "swing", transliteration = "[swɪŋ]", translation = "качели",
            definition = "A seat hung by ropes that kids ride to move back and forth in the air.",
            definitionNative = "Сиденье на верёвках, на котором дети катаются вперёд и назад.",
            example = "My little brother loves the wooden swing in our backyard.",
            exampleNative = "Мой младший брат обожает деревянный swing на нашем заднем дворе.",
            pos = "noun", semanticGroup = "entertainment_kids_outdoor", fillInBlankExclusions = listOf(35112L, 35113L, 35114L, 35115L, 35117L, 35118L)),

        WordEntity(id = 35112, setId = 351, languagePair = "en-ru", rarity = "COMMON",
            original = "slide", transliteration = "[slaɪd]", translation = "горка (детская)",
            definition = "A long smooth ramp at a park that kids climb up and zip down.",
            definitionNative = "Длинный гладкий скат в парке, на который залезают и скатываются.",
            example = "The kids took turns going down the bright red slide.",
            exampleNative = "Дети по очереди скатывались с яркой красной slide.",
            pos = "noun", semanticGroup = "entertainment_kids_outdoor", fillInBlankExclusions = listOf(35111L, 35113L, 35114L, 35115L)),

        WordEntity(id = 35113, setId = 351, languagePair = "en-ru", rarity = "COMMON",
            original = "kite", transliteration = "[kaɪt]", translation = "воздушный змей",
            definition = "A toy made of cloth and sticks that flies high on a long string.",
            definitionNative = "Игрушка из ткани и палочек, летящая высоко на длинной верёвке.",
            example = "We flew a colorful kite at the beach when the wind was strong.",
            exampleNative = "Мы запускали разноцветный kite на пляже при сильном ветре.",
            pos = "noun", semanticGroup = "entertainment_kids_outdoor", fillInBlankExclusions = listOf(35111L, 35112L, 35114L, 35115L)),

        WordEntity(id = 35114, setId = 351, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "hopscotch", transliteration = "[ˈhɑpˌskɑʧ]", translation = "классики (детская игра)",
            definition = "A kids' game with squares drawn on the ground that you jump through.",
            definitionNative = "Детская игра с квадратами на земле, через которые нужно прыгать.",
            example = "The girls drew big squares and started a game of hopscotch.",
            exampleNative = "Девочки нарисовали большие квадраты и начали игру в hopscotch.",
            pos = "noun", semanticGroup = "entertainment_kids_outdoor", fillInBlankExclusions = listOf(35111L, 35112L, 35113L, 35115L)),

        WordEntity(id = 35115, setId = 351, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "bowling", transliteration = "[ˈboʊlɪŋ]", translation = "боулинг",
            definition = "A game in which you roll a heavy ball to knock down ten tall pins.",
            definitionNative = "Игра, в которой катят тяжёлый шар, чтобы сбить десять высоких кеглей.",
            example = "We went to a noisy bowling alley for my cousin's birthday.",
            exampleNative = "Мы пошли в шумный bowling-зал на день рождения моего кузена.",
            pos = "noun", semanticGroup = "entertainment_kids_outdoor", fillInBlankExclusions = listOf(35111L, 35112L, 35113L, 35114L)),

        // ── entertainment_games_indoor (5) ────────────────────────────────

        WordEntity(id = 35116, setId = 351, languagePair = "en-ru", rarity = "COMMON",
            original = "game", transliteration = "[ɡeɪm]", translation = "игра (любая)",
            definition = "An activity with rules that people do for fun, alone or together.",
            definitionNative = "Занятие с правилами, которым занимаются ради удовольствия в одиночку или вместе.",
            example = "Let's pick a game to play before dinner is ready.",
            exampleNative = "Давай выберем какую-нибудь game, пока ужин не готов.",
            pos = "noun", semanticGroup = "entertainment_games_indoor", fillInBlankExclusions = listOf(35110L, 35117L, 35118L, 35119L, 35120L, 35121L)),

        WordEntity(id = 35117, setId = 351, languagePair = "en-ru", rarity = "COMMON",
            original = "toy", transliteration = "[tɔɪ]", translation = "игрушка",
            definition = "A small object made for children to play with at home.",
            definitionNative = "Маленький предмет, сделанный для того, чтобы дети играли с ним дома.",
            example = "My nephew got a new toy car for his fifth birthday.",
            exampleNative = "Мой племянник получил новую toy-машинку на свой пятый день рождения.",
            pos = "noun", semanticGroup = "entertainment_games_indoor", fillInBlankExclusions = listOf(35116L, 35118L, 35119L, 35120L)),

        WordEntity(id = 35118, setId = 351, languagePair = "en-ru", rarity = "COMMON",
            original = "puzzle", transliteration = "[ˈpəzəl]", translation = "пазл / головоломка",
            definition = "A set of small pieces you fit together to make a picture or shape.",
            definitionNative = "Набор маленьких кусочков, которые соединяют, чтобы получить картинку или фигуру.",
            example = "Grandma loves to do a thousand-piece puzzle on rainy weekends.",
            exampleNative = "Бабушка любит собирать puzzle из тысячи деталей в дождливые выходные.",
            pos = "noun", semanticGroup = "entertainment_games_indoor", fillInBlankExclusions = listOf(35116L, 35117L, 35119L, 35120L)),

        WordEntity(id = 35119, setId = 351, languagePair = "en-ru", rarity = "COMMON",
            original = "riddle", transliteration = "[ˈrɪdəl]", translation = "загадка (с подвохом)",
            definition = "A short tricky question that makes you think and is fun to solve.",
            definitionNative = "Короткий каверзный вопрос, над которым нужно думать и который весело отгадывать.",
            example = "He asked us a clever riddle about a creature with no legs.",
            exampleNative = "Он загадал нам хитрую riddle про существо без ног.",
            pos = "noun", semanticGroup = "entertainment_games_indoor", fillInBlankExclusions = listOf(35116L, 35117L, 35118L, 35120L)),

        WordEntity(id = 35120, setId = 351, languagePair = "en-ru", rarity = "COMMON",
            original = "quiz", transliteration = "[kwɪz]", translation = "викторина",
            definition = "A short test of questions, often played for fun in teams.",
            definitionNative = "Короткий набор вопросов, в который часто играют командами для развлечения.",
            example = "The pub holds a friendly history quiz every Thursday evening.",
            exampleNative = "В пабе каждый четверг вечером проводят дружескую quiz по истории.",
            pos = "noun", semanticGroup = "entertainment_games_indoor", fillInBlankExclusions = listOf(35116L, 35117L, 35118L, 35119L, 35122L)),

        // ── entertainment_show_event (5) ──────────────────────────────────

        WordEntity(id = 35121, setId = 351, languagePair = "en-ru", rarity = "COMMON",
            original = "video", transliteration = "[ˈvɪdioʊ]", translation = "видео",
            definition = "A short clip with moving pictures and sound that you watch on a screen.",
            definitionNative = "Короткий ролик с движущимися картинками и звуком, который смотрят на экране.",
            example = "She posted a funny video of her dog dancing on its hind legs.",
            exampleNative = "Она выложила смешное video, где её собака танцует на задних лапах.",
            pos = "noun", semanticGroup = "entertainment_show_event", fillInBlankExclusions = listOf(35122L, 35123L, 35124L, 35125L)),

        WordEntity(id = 35122, setId = 351, languagePair = "en-ru", rarity = "COMMON",
            original = "show", transliteration = "[ʃoʊ]", translation = "представление / шоу",
            definition = "A live or recorded performance that an audience watches for fun.",
            definitionNative = "Живая или записанная постановка, которую зрители смотрят ради удовольствия.",
            example = "We bought tickets for a magic show in the city centre.",
            exampleNative = "Мы купили билеты на show фокусника в центре города.",
            pos = "noun", semanticGroup = "entertainment_show_event", fillInBlankExclusions = listOf(35121L, 35123L, 35124L, 35125L)),

        WordEntity(id = 35123, setId = 351, languagePair = "en-ru", rarity = "COMMON",
            original = "prize", transliteration = "[praɪz]", translation = "приз",
            definition = "Something nice you get for winning a game or contest.",
            definitionNative = "Что-то приятное, что получают за победу в игре или конкурсе.",
            example = "The first prize was a brand new mountain bike.",
            exampleNative = "Главный prize был совершенно новый горный велосипед.",
            pos = "noun", semanticGroup = "entertainment_show_event", fillInBlankExclusions = listOf(35121L, 35122L, 35124L, 35125L)),

        WordEntity(id = 35124, setId = 351, languagePair = "en-ru", rarity = "COMMON",
            original = "ticket", transliteration = "[ˈtɪkɪt]", translation = "билет (на мероприятие)",
            definition = "A small paper that lets you enter a show, ride or event.",
            definitionNative = "Маленькая бумажка, которая даёт право войти на шоу, аттракцион или мероприятие.",
            example = "I bought a ticket online for the comedy show on Friday.",
            exampleNative = "Я купил ticket онлайн на стендап в пятницу.",
            pos = "noun", semanticGroup = "entertainment_show_event", fillInBlankExclusions = listOf(35121L, 35123L, 35125L)),

        WordEntity(id = 35125, setId = 351, languagePair = "en-ru", rarity = "COMMON",
            original = "ride", transliteration = "[raɪd]", translation = "аттракцион (катание)",
            definition = "A fun machine at a fair or park that you sit on and it moves you.",
            definitionNative = "Весёлая машина в парке, на которую садишься, и она тебя катает.",
            example = "The roller coaster ride was the best part of the whole day.",
            exampleNative = "Ride на американских горках была лучшей частью всего дня.",
            pos = "noun", semanticGroup = "entertainment_show_event", fillInBlankExclusions = listOf(35121L, 35122L, 35123L, 35124L)),

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 352 — Развлечения и досуг: продвинутые (L2, UNCOMMON+RARE)   ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── entertainment_screen_genres (5) ───────────────────────────────

        WordEntity(id = 35201, setId = 352, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "drama", transliteration = "[ˈdrɑmə]", translation = "драма (жанр)",
            definition = "A serious film or show about strong feelings and difficult situations.",
            definitionNative = "Серьёзный фильм или сериал о сильных чувствах и трудных ситуациях.",
            example = "She prefers a slow drama to a noisy action movie.",
            exampleNative = "Она предпочитает медленную drama шумному боевику.",
            pos = "noun", semanticGroup = "entertainment_screen_genres", fillInBlankExclusions = listOf(35202L, 35203L, 35204L, 35205L)),

        WordEntity(id = 35202, setId = 352, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "thriller", transliteration = "[ˈθrɪlər]", translation = "триллер",
            definition = "An exciting film or book full of danger, suspense and sudden twists.",
            definitionNative = "Захватывающий фильм или книга с опасностью, напряжением и резкими поворотами.",
            example = "We watched a tense thriller about a missing child late at night.",
            exampleNative = "Мы смотрели напряжённый thriller про пропавшего ребёнка поздно ночью.",
            pos = "noun", semanticGroup = "entertainment_screen_genres", fillInBlankExclusions = listOf(35201L, 35203L, 35204L, 35205L, 35217L)),

        WordEntity(id = 35203, setId = 352, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "anime", transliteration = "[ˈænəˌmeɪ]", translation = "аниме",
            definition = "A Japanese style of cartoon popular with teenagers and adults worldwide.",
            definitionNative = "Японский стиль мультфильмов, популярный у подростков и взрослых по миру.",
            example = "He stayed up late watching a new anime series about pirates.",
            exampleNative = "Он засиделся допоздна за новым anime-сериалом про пиратов.",
            pos = "noun", semanticGroup = "entertainment_screen_genres", fillInBlankExclusions = listOf(35201L, 35202L, 35204L, 35205L, 35217L, 35225L)),

        WordEntity(id = 35204, setId = 352, languagePair = "en-ru", rarity = "RARE",
            original = "sitcom", transliteration = "[ˈsɪtˌkɑm]", translation = "ситком (комедийный сериал)",
            definition = "A funny TV series about the same group of people in everyday situations.",
            definitionNative = "Смешной сериал об одной и той же компании в обычных бытовых ситуациях.",
            example = "Their favourite sitcom is set in a tiny New York apartment.",
            exampleNative = "Их любимый sitcom разворачивается в крохотной нью-йоркской квартире.",
            pos = "noun", semanticGroup = "entertainment_screen_genres", fillInBlankExclusions = listOf(35201L, 35202L, 35203L, 35205L, 35207L, 35217L, 35225L)),

        WordEntity(id = 35205, setId = 352, languagePair = "en-ru", rarity = "RARE",
            original = "prequel", transliteration = "[ˈprikwəl]", translation = "приквел (фильм-предыстория)",
            definition = "A film or book that tells the story of events before the original one.",
            definitionNative = "Фильм или книга, рассказывающая о событиях до оригинальной истории.",
            example = "The prequel explains how the villain became evil in the first place.",
            exampleNative = "Prequel объясняет, как злодей вообще стал злодеем.",
            pos = "noun", semanticGroup = "entertainment_screen_genres", fillInBlankExclusions = listOf(35201L, 35202L, 35203L, 35204L, 35216L, 35217L, 35221L, 35225L)),

        // ── entertainment_offline_events (5) ──────────────────────────────

        WordEntity(id = 35206, setId = 352, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "festival", transliteration = "[ˈfɛstɪvəl]", translation = "фестиваль (музыкальный/тематический)",
            definition = "A big public event with music, food and shows over several days.",
            definitionNative = "Крупное публичное мероприятие с музыкой, едой и шоу, идущее несколько дней.",
            example = "Half my friends went to the rock festival in the countryside.",
            exampleNative = "Половина моих друзей поехала на рок-festival за город.",
            pos = "noun", semanticGroup = "entertainment_offline_events", fillInBlankExclusions = listOf(35207L, 35208L, 35209L, 35210L)),

        WordEntity(id = 35207, setId = 352, languagePair = "en-ru", rarity = "RARE",
            original = "escape-room", transliteration = "[ɪˈskeɪp rum]", translation = "квест-комната (escape-room)",
            definition = "A locked room where a team solves clues to get out within a time limit.",
            definitionNative = "Запертая комната, из которой команда выбирается, разгадывая подсказки за время.",
            example = "Our team escaped the haunted escape-room with two minutes left.",
            exampleNative = "Наша команда выбралась из хоррор escape-room за две минуты до конца.",
            pos = "noun", semanticGroup = "entertainment_offline_events", fillInBlankExclusions = listOf(35206L, 35208L, 35209L, 35210L)),

        WordEntity(id = 35208, setId = 352, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "karaoke", transliteration = "[ˌkɛriˈoʊki]", translation = "караоке",
            definition = "Singing along to music tracks with the lyrics shown on a screen.",
            definitionNative = "Пение под фонограмму, когда слова песни показываются на экране.",
            example = "We laughed for an hour during karaoke at the office party.",
            exampleNative = "Мы смеялись целый час под karaoke на корпоративе.",
            pos = "noun", semanticGroup = "entertainment_offline_events", fillInBlankExclusions = listOf(35206L, 35207L, 35209L, 35210L)),

        WordEntity(id = 35209, setId = 352, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "paintball", transliteration = "[ˈpeɪntˌbɔl]", translation = "пейнтбол",
            definition = "A team sport where players shoot capsules of paint at each other.",
            definitionNative = "Командная игра, в которой стреляют друг в друга капсулами с краской.",
            example = "We rented gear and played paintball for my brother's stag party.",
            exampleNative = "Мы взяли снаряжение напрокат и играли в paintball на мальчишнике брата.",
            pos = "noun", semanticGroup = "entertainment_offline_events", fillInBlankExclusions = listOf(35206L, 35207L, 35208L, 35210L)),

        WordEntity(id = 35210, setId = 352, languagePair = "en-ru", rarity = "RARE",
            original = "cosplay", transliteration = "[ˈkɑzˌpleɪ]", translation = "косплей",
            definition = "Dressing up as a character from a film, game or anime at fan events.",
            definitionNative = "Переодевание в персонажа фильма, игры или аниме на фанатских встречах.",
            example = "Her cosplay of the witch queen took six months of careful sewing.",
            exampleNative = "Её cosplay королевы-ведьмы потребовал шести месяцев аккуратного шитья.",
            pos = "noun", semanticGroup = "entertainment_offline_events", fillInBlankExclusions = listOf(35206L, 35207L, 35208L, 35209L)),

        // ── entertainment_gaming_gear (5) ─────────────────────────────────

        WordEntity(id = 35211, setId = 352, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "gamer", transliteration = "[ˈɡeɪmər]", translation = "геймер (заядлый игрок)",
            definition = "A person who spends a lot of time playing video titles seriously.",
            definitionNative = "Человек, проводящий много времени за серьёзной игрой в видеопроекты.",
            example = "My cousin is a serious gamer with three powerful machines at home.",
            exampleNative = "Мой кузен — серьёзный gamer с тремя мощными машинами дома.",
            pos = "noun", semanticGroup = "entertainment_gaming_gear", fillInBlankExclusions = listOf(35212L, 35213L, 35214L, 35215L)),

        WordEntity(id = 35212, setId = 352, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "console", transliteration = "[ˈkɑnˌsoʊl]", translation = "игровая приставка",
            definition = "A small machine made just for playing video titles on a TV screen.",
            definitionNative = "Небольшое устройство, созданное специально для видеоигр на экране телевизора.",
            example = "He saved up all summer to buy the latest gaming console.",
            exampleNative = "Он копил всё лето, чтобы купить новейшую console.",
            pos = "noun", semanticGroup = "entertainment_gaming_gear", fillInBlankExclusions = listOf(35211L, 35213L, 35214L, 35215L)),

        WordEntity(id = 35213, setId = 352, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "controller", transliteration = "[kənˈtroʊlər]", translation = "геймпад / контроллер",
            definition = "A small handheld device with buttons used to control video titles.",
            definitionNative = "Небольшое ручное устройство с кнопками, которым управляют видеоиграми.",
            example = "The new controller fits much better in small hands than the old one.",
            exampleNative = "Новый controller гораздо удобнее лежит в маленькой руке, чем старый.",
            pos = "noun", semanticGroup = "entertainment_gaming_gear", fillInBlankExclusions = listOf(35211L, 35212L, 35214L, 35215L)),

        WordEntity(id = 35214, setId = 352, languagePair = "en-ru", rarity = "RARE",
            original = "mod", transliteration = "[mɑd]", translation = "мод (фанатская модификация)",
            definition = "An unofficial change to a game made by fans to add new content.",
            definitionNative = "Неофициальное изменение игры, сделанное фанатами для добавления контента.",
            example = "He installed a popular mod that adds dragons to the village map.",
            exampleNative = "Он поставил популярный mod, добавляющий драконов на деревенскую карту.",
            pos = "noun", semanticGroup = "entertainment_gaming_gear", fillInBlankExclusions = listOf(35211L, 35212L, 35213L, 35215L)),

        WordEntity(id = 35215, setId = 352, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "multiplayer", transliteration = "[ˈməltiˌpleɪər]", translation = "мультиплеер (совместная игра)",
            definition = "A mode where many people play together at the same time online.",
            definitionNative = "Режим, в котором много людей одновременно играют вместе по сети.",
            example = "The multiplayer mode lets sixteen friends fight in the same arena.",
            exampleNative = "Multiplayer-режим позволяет шестнадцати друзьям сражаться на одной арене.",
            pos = "noun", semanticGroup = "entertainment_gaming_gear", fillInBlankExclusions = listOf(35211L, 35212L, 35213L, 35214L)),

        // ── entertainment_streaming (5) ───────────────────────────────────

        WordEntity(id = 35216, setId = 352, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "stream", transliteration = "[strim]", translation = "стрим (онлайн-трансляция игры/контента)",
            definition = "A live broadcast on the internet where viewers watch a host in real time.",
            definitionNative = "Живая трансляция в интернете, где зрители смотрят ведущего в реальном времени.",
            example = "Thousands joined his stream to watch the match commentary.",
            exampleNative = "Тысячи людей подключились к его stream, чтобы послушать комментарии матча.",
            pos = "noun", semanticGroup = "entertainment_streaming", fillInBlankExclusions = listOf(35217L, 35218L, 35219L)),

        WordEntity(id = 35217, setId = 352, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "podcast", transliteration = "[ˈpɔdˌkæst]", translation = "подкаст",
            definition = "An audio show you download or stream to listen on your phone or laptop.",
            definitionNative = "Аудиошоу, которое скачивают или слушают через интернет на телефоне или ноутбуке.",
            example = "She listens to a true-crime podcast on her morning commute.",
            exampleNative = "Она слушает true-crime podcast по дороге на работу утром.",
            pos = "noun", semanticGroup = "entertainment_streaming", fillInBlankExclusions = listOf(35201L, 35202L, 35216L, 35218L, 35219L)),

        WordEntity(id = 35218, setId = 352, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "playlist", transliteration = "[ˈpleɪˌlɪst]", translation = "плейлист (подборка треков)",
            definition = "A list of songs or videos chosen to be played one after another.",
            definitionNative = "Список песен или роликов, выбранных, чтобы воспроизводиться один за другим.",
            example = "He made a long road-trip playlist with his favourite eighties hits.",
            exampleNative = "Он собрал большой playlist для дороги из любимых хитов восьмидесятых.",
            pos = "noun", semanticGroup = "entertainment_streaming", fillInBlankExclusions = listOf(35216L, 35217L, 35219L)),

        WordEntity(id = 35219, setId = 352, languagePair = "en-ru", rarity = "RARE",
            original = "unboxing", transliteration = "[ʌnˈbɑksɪŋ]", translation = "анбоксинг (распаковка на видео)",
            definition = "A video where someone opens a new product and shows what's inside.",
            definitionNative = "Видеоролик, в котором кто-то открывает новый товар и показывает содержимое.",
            example = "Her unboxing video for the new phone got a million views fast.",
            exampleNative = "Её unboxing нового телефона быстро набрал миллион просмотров.",
            pos = "noun", semanticGroup = "entertainment_streaming", fillInBlankExclusions = listOf(35216L, 35217L, 35218L, 35224L)),

        WordEntity(id = 35220, setId = 352, languagePair = "en-ru", rarity = "RARE",
            original = "binge-watch", transliteration = "[ˈbɪnʤ wɑʧ]", translation = "смотреть запоем (несколько серий подряд)",
            definition = "To watch many episodes of a show one after another in a single session.",
            definitionNative = "Смотреть много серий сериала подряд за один присест.",
            example = "We plan to binge-watch the whole new season this rainy weekend.",
            exampleNative = "Мы собираемся binge-watch весь новый сезон в эти дождливые выходные.",
            pos = "verb", semanticGroup = "entertainment_streaming"),

        // ── entertainment_fan_meta (5) ────────────────────────────────────

        WordEntity(id = 35221, setId = 352, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "spoiler", transliteration = "[ˈspɔɪlər]", translation = "спойлер (раскрытие сюжета)",
            definition = "A piece of news that reveals an important plot detail before someone sees it.",
            definitionNative = "Сообщение, раскрывающее важную деталь сюжета до того, как её увидят сами.",
            example = "Please don't post a spoiler before everyone has seen the finale.",
            exampleNative = "Пожалуйста, не выкладывай spoiler, пока все не посмотрели финал.",
            pos = "noun", semanticGroup = "entertainment_fan_meta", fillInBlankExclusions = listOf(35222L, 35224L, 35225L)),

        WordEntity(id = 35222, setId = 352, languagePair = "en-ru", rarity = "RARE",
            original = "leaderboard", transliteration = "[ˈliːdərˌbɔrd]", translation = "таблица лидеров",
            definition = "A public list ranking the top players or scores in a contest.",
            definitionNative = "Открытый список с местами лучших игроков или результатов в соревновании.",
            example = "He climbed to second place on the global leaderboard last night.",
            exampleNative = "Он поднялся на второе место в мировом leaderboard этой ночью.",
            pos = "noun", semanticGroup = "entertainment_fan_meta", fillInBlankExclusions = listOf(35221L, 35223L, 35224L, 35225L)),

        WordEntity(id = 35223, setId = 352, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "achievement", transliteration = "[əˈʧivmənt]", translation = "ачивка (внутриигровая награда)",
            definition = "A reward you earn in a game for doing something hard or unusual.",
            definitionNative = "Награда в игре за выполнение чего-то сложного или необычного.",
            example = "He proudly unlocked the secret achievement after fifty hours.",
            exampleNative = "Он гордо открыл секретный achievement после пятидесяти часов игры.",
            pos = "noun", semanticGroup = "entertainment_fan_meta", fillInBlankExclusions = listOf(35214L, 35221L, 35222L, 35224L, 35225L)),

        WordEntity(id = 35224, setId = 352, languagePair = "en-ru", rarity = "RARE",
            original = "glitch", transliteration = "[ɡlɪʧ]", translation = "глитч (баг в игре или видео)",
            definition = "A small bug in a game or video that makes things look or behave wrong.",
            definitionNative = "Мелкая ошибка в игре или ролике, из-за которой что-то выглядит или работает неправильно.",
            example = "A funny glitch made the boss float through the floor of the dungeon.",
            exampleNative = "Смешной glitch заставил босса проваливаться сквозь пол подземелья.",
            pos = "noun", semanticGroup = "entertainment_fan_meta", fillInBlankExclusions = listOf(35214L, 35221L, 35222L, 35223L, 35225L)),

        WordEntity(id = 35225, setId = 352, languagePair = "en-ru", rarity = "RARE",
            original = "fanfic", transliteration = "[ˈfænˌfɪk]", translation = "фанфик (фанатский текст по вселенной)",
            definition = "A story written by fans using characters from a film, book or game.",
            definitionNative = "История, написанная фанатами с персонажами фильма, книги или игры.",
            example = "Her fanfic about the wizard school got thousands of online readers.",
            exampleNative = "Её fanfic про школу волшебников набрал тысячи онлайн-читателей.",
            pos = "noun", semanticGroup = "entertainment_fan_meta", fillInBlankExclusions = listOf(35202L, 35205L, 35221L, 35222L, 35223L, 35224L)),

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 353 — Развлечения и досуг: углублённые (L3, RARE+EPIC)       ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── entertainment_storytelling (5) ────────────────────────────────

        WordEntity(id = 35301, setId = 353, languagePair = "en-ru", rarity = "RARE",
            original = "antihero", transliteration = "[ˈæntiˌhɪroʊ]", translation = "антигерой (главный персонаж без морального ореола)",
            definition = "A main character who lacks the noble traits people expect from a hero.",
            definitionNative = "Главный персонаж, лишённый благородных черт, ожидаемых от героя.",
            example = "The brooding antihero stole every scene of the dark crime drama.",
            exampleNative = "Угрюмый antihero крал все сцены в мрачной криминальной драме.",
            pos = "noun", semanticGroup = "entertainment_storytelling", fillInBlankExclusions = listOf(35302L, 35303L, 35304L, 35305L)),

        WordEntity(id = 35302, setId = 353, languagePair = "en-ru", rarity = "RARE",
            original = "plot-twist", transliteration = "[plɑt twɪst]", translation = "сюжетный поворот (внезапный)",
            definition = "A sudden change in the story that surprises and reframes earlier scenes.",
            definitionNative = "Резкое изменение в сюжете, которое удивляет и переосмысливает предыдущие сцены.",
            example = "The plot-twist near the end revealed the kind doctor as the killer.",
            exampleNative = "Plot-twist под конец показал, что добрый доктор и есть убийца.",
            pos = "noun", semanticGroup = "entertainment_storytelling", fillInBlankExclusions = listOf(35301L, 35303L, 35304L, 35305L)),

        WordEntity(id = 35303, setId = 353, languagePair = "en-ru", rarity = "EPIC",
            original = "denouement", transliteration = "[ˌdeɪnuˈmɑ̃]", translation = "развязка (финальное разрешение сюжета)",
            definition = "The final stage of a story where loose ends are tied up and conflicts end.",
            definitionNative = "Финальная стадия истории, где сводятся концы и завершаются конфликты.",
            example = "The denouement quietly reunites the family after years of silence.",
            exampleNative = "Denouement тихо воссоединяет семью после долгих лет молчания.",
            pos = "noun", semanticGroup = "entertainment_storytelling", fillInBlankExclusions = listOf(35301L, 35302L, 35304L, 35305L, 35320L)),

        WordEntity(id = 35304, setId = 353, languagePair = "en-ru", rarity = "EPIC",
            original = "mockumentary", transliteration = "[ˌmɑkjəˈmɛntəri]", translation = "псевдодокументалка (вымысел в стиле документа)",
            definition = "A fictional film made to look like a serious documentary for comic effect.",
            definitionNative = "Художественный фильм, снятый под серьёзный документальный — ради комического эффекта.",
            example = "The office mockumentary mimics the look of a real workplace film crew.",
            exampleNative = "Офисный mockumentary имитирует стиль настоящей съёмочной группы.",
            pos = "noun", semanticGroup = "entertainment_storytelling", fillInBlankExclusions = listOf(35301L, 35302L, 35303L, 35305L)),

        WordEntity(id = 35305, setId = 353, languagePair = "en-ru", rarity = "RARE",
            original = "trope", transliteration = "[troʊp]", translation = "троп (знакомый сюжетный приём)",
            definition = "A familiar pattern in stories that audiences recognise from many works.",
            definitionNative = "Знакомый шаблон в историях, который зрители узнают по множеству произведений.",
            example = "The lone-cop trope shows up in nearly every classic action film.",
            exampleNative = "Trope про копа-одиночку встречается чуть ли не в каждом классическом боевике.",
            pos = "noun", semanticGroup = "entertainment_storytelling", fillInBlankExclusions = listOf(35301L, 35302L, 35303L, 35304L)),

        // ── entertainment_film_craft (5) ──────────────────────────────────

        WordEntity(id = 35306, setId = 353, languagePair = "en-ru", rarity = "RARE",
            original = "easter-egg", transliteration = "[ˈistər ɛɡ]", translation = "пасхалка (скрытая отсылка)",
            definition = "A hidden joke or reference placed in a game or film for fans to find.",
            definitionNative = "Скрытая шутка или отсылка в игре или фильме, которую находят внимательные фанаты.",
            example = "Sharp viewers spotted an easter-egg about the director's earlier film.",
            exampleNative = "Внимательные зрители нашли easter-egg, отсылающий к раннему фильму режиссёра.",
            pos = "noun", semanticGroup = "entertainment_film_craft"),

        WordEntity(id = 35307, setId = 353, languagePair = "en-ru", rarity = "RARE",
            original = "soundtrack", transliteration = "[ˈsaʊndˌtræk]", translation = "саундтрек (музыкальное сопровождение)",
            definition = "All the music played during a film, show or game from start to end.",
            definitionNative = "Вся музыка, звучащая в фильме, шоу или игре от начала до конца.",
            example = "The orchestral soundtrack made the battle scene feel truly epic.",
            exampleNative = "Оркестровый soundtrack сделал сцену битвы по-настоящему эпической.",
            pos = "noun", semanticGroup = "entertainment_film_craft", fillInBlankExclusions = listOf(35306L, 35308L, 35309L, 35310L)),

        WordEntity(id = 35308, setId = 353, languagePair = "en-ru", rarity = "EPIC",
            original = "tracking-shot", transliteration = "[ˈtrækɪŋ ʃɑt]", translation = "проводка камерой (длинный план в движении)",
            definition = "A long camera move that follows characters smoothly through a scene.",
            definitionNative = "Длинный кадр, в котором камера плавно движется вслед за персонажами.",
            example = "The hallway tracking-shot follows the hero for two unbroken minutes.",
            exampleNative = "Tracking-shot по коридору сопровождает героя две минуты без склеек.",
            pos = "noun", semanticGroup = "entertainment_film_craft", fillInBlankExclusions = listOf(35306L, 35307L, 35309L, 35310L)),

        WordEntity(id = 35309, setId = 353, languagePair = "en-ru", rarity = "RARE",
            original = "jump-scare", transliteration = "[ʤəmp skɛr]", translation = "скример / резкий испуг (в фильме)",
            definition = "A sudden loud or shocking moment used to frighten the audience.",
            definitionNative = "Резкий громкий или шокирующий момент, использованный, чтобы напугать зрителя.",
            example = "Cheap horror films lean too heavily on the easy jump-scare.",
            exampleNative = "Дешёвые ужастики слишком полагаются на лёгкий jump-scare.",
            pos = "noun", semanticGroup = "entertainment_film_craft", fillInBlankExclusions = listOf(35302L, 35305L, 35306L, 35307L, 35308L, 35310L)),

        WordEntity(id = 35310, setId = 353, languagePair = "en-ru", rarity = "RARE",
            original = "blooper", transliteration = "[ˈblupər]", translation = "ляп (смешной дубль за кадром)",
            definition = "A funny mistake recorded during filming and shown later to fans.",
            definitionNative = "Смешная ошибка, снятая во время съёмок и потом показанная фанатам.",
            example = "The blooper reel made the cast laugh harder than the actual film.",
            exampleNative = "Blooper-нарезка рассмешила актёров сильнее, чем сам фильм.",
            pos = "noun", semanticGroup = "entertainment_film_craft", fillInBlankExclusions = listOf(35306L, 35307L, 35308L, 35309L)),

        // ── entertainment_game_design (5) ─────────────────────────────────

        WordEntity(id = 35311, setId = 353, languagePair = "en-ru", rarity = "RARE",
            original = "sandbox", transliteration = "[ˈsændˌbɑks]", translation = "песочница (тип открытой игры)",
            definition = "A game type that lets the player roam and create with no fixed path.",
            definitionNative = "Тип игры, где игрок свободно перемещается и творит без жёсткого сюжета.",
            example = "He spent two hundred hours in the sandbox building a tiny medieval town.",
            exampleNative = "Он провёл двести часов в sandbox, строя крохотный средневековый городок.",
            pos = "noun", semanticGroup = "entertainment_game_design", fillInBlankExclusions = listOf(35312L, 35313L, 35314L, 35315L)),

        WordEntity(id = 35312, setId = 353, languagePair = "en-ru", rarity = "RARE",
            original = "indie-game", transliteration = "[ˈɪndi ɡeɪm]", translation = "инди-игра (от небольшой студии)",
            definition = "A title made by a small independent team without a big publisher.",
            definitionNative = "Тайтл от небольшой независимой команды без крупного издателя.",
            example = "This quiet indie-game became a hit despite a tiny budget.",
            exampleNative = "Этот тихий indie-game стал хитом несмотря на крошечный бюджет.",
            pos = "noun", semanticGroup = "entertainment_game_design", fillInBlankExclusions = listOf(35304L, 35311L, 35313L, 35314L, 35315L)),

        WordEntity(id = 35313, setId = 353, languagePair = "en-ru", rarity = "RARE",
            original = "roguelike", transliteration = "[ˈroʊɡˌlaɪk]", translation = "рогалик (жанр с перезапуском)",
            definition = "A game style where you start over from scratch each time you die.",
            definitionNative = "Жанр, в котором после смерти приходится начинать игру с нуля.",
            example = "She loves a punishing roguelike that resets the dungeon every run.",
            exampleNative = "Она обожает суровый roguelike, где подземелье генерируется заново.",
            pos = "noun", semanticGroup = "entertainment_game_design", fillInBlankExclusions = listOf(35311L, 35312L, 35314L, 35315L)),

        WordEntity(id = 35314, setId = 353, languagePair = "en-ru", rarity = "RARE",
            original = "RPG", transliteration = "[ˌɑr piː ˈʤi]", translation = "РПГ (ролевая игра)",
            definition = "A game where you play a character who grows stronger through choices.",
            definitionNative = "Игра, в которой вы играете персонажем, становящимся сильнее через выбор.",
            example = "His favourite RPG lets you build a wizard, a thief or a knight.",
            exampleNative = "Его любимый RPG позволяет создать волшебника, вора или рыцаря.",
            pos = "noun", semanticGroup = "entertainment_game_design", fillInBlankExclusions = listOf(35311L, 35312L, 35313L, 35315L)),

        WordEntity(id = 35315, setId = 353, languagePair = "en-ru", rarity = "RARE",
            original = "MMO", transliteration = "[ˌɛm ɛm ˈoʊ]", translation = "ММО (многопользовательский онлайн-мир)",
            definition = "An online world where thousands of players share the same map at once.",
            definitionNative = "Сетевой мир, в котором тысячи людей одновременно делят одну карту.",
            example = "He met his future wife inside a massive fantasy MMO ten years ago.",
            exampleNative = "Он встретил свою будущую жену в большом фэнтезийном MMO десять лет назад.",
            pos = "noun", semanticGroup = "entertainment_game_design", fillInBlankExclusions = listOf(35311L, 35312L, 35313L, 35314L)),

        // ── entertainment_production (5) ──────────────────────────────────

        WordEntity(id = 35316, setId = 353, languagePair = "en-ru", rarity = "RARE",
            original = "worldbuilding", transliteration = "[ˈwɜːrldˌbɪldɪŋ]", translation = "построение мира (мифология вселенной)",
            definition = "The work of inventing the geography, history and culture of a fictional setting.",
            definitionNative = "Работа по созданию географии, истории и культуры вымышленного мира.",
            example = "Tolkien's worldbuilding still inspires fantasy writers everywhere.",
            exampleNative = "Worldbuilding Толкина до сих пор вдохновляет фэнтези-авторов по всему миру.",
            pos = "noun", semanticGroup = "entertainment_production", fillInBlankExclusions = listOf(35317L, 35318L, 35319L, 35320L)),

        WordEntity(id = 35317, setId = 353, languagePair = "en-ru", rarity = "RARE",
            original = "lore", transliteration = "[lɔr]", translation = "лор (внутренняя мифология вселенной)",
            definition = "The deep background facts and legends of a fictional setting.",
            definitionNative = "Глубокие фоновые факты и легенды вымышленной вселенной.",
            example = "Long-time fans love discussing the dark lore of the elven kingdoms.",
            exampleNative = "Давние фанаты любят обсуждать мрачный lore эльфийских королевств.",
            pos = "noun", semanticGroup = "entertainment_production", fillInBlankExclusions = listOf(35303L, 35316L, 35318L, 35319L, 35320L)),

        WordEntity(id = 35318, setId = 353, languagePair = "en-ru", rarity = "RARE",
            original = "canon", transliteration = "[ˈkænən]", translation = "канон (официальная часть вселенной)",
            definition = "The set of works officially accepted as part of a fictional universe.",
            definitionNative = "Набор произведений, официально признанных частью вымышленной вселенной.",
            example = "Many fans argue whether the new spinoff belongs to the main canon.",
            exampleNative = "Многие фанаты спорят, относится ли новый спин-офф к основному canon.",
            pos = "noun", semanticGroup = "entertainment_production", fillInBlankExclusions = listOf(35316L, 35317L, 35319L, 35320L)),

        WordEntity(id = 35319, setId = 353, languagePair = "en-ru", rarity = "RARE",
            original = "showrunner", transliteration = "[ˈʃoʊˌrənər]", translation = "шоураннер (главный продюсер сериала)",
            definition = "The lead producer who guides every creative choice of a TV series.",
            definitionNative = "Главный продюсер, направляющий все творческие решения сериала.",
            example = "The new showrunner turned the slow drama into a tight thriller.",
            exampleNative = "Новый showrunner превратил медленную драму в плотный триллер.",
            pos = "noun", semanticGroup = "entertainment_production", fillInBlankExclusions = listOf(35302L, 35303L, 35307L, 35316L, 35317L, 35318L, 35320L)),

        WordEntity(id = 35320, setId = 353, languagePair = "en-ru", rarity = "RARE",
            original = "finale", transliteration = "[fəˈnæli]", translation = "финал (последний эпизод)",
            definition = "The very last episode of a series that closes the main story.",
            definitionNative = "Самый последний эпизод сериала, закрывающий основную сюжетную линию.",
            example = "The two-hour finale answered every question fans had asked for years.",
            exampleNative = "Двухчасовой finale ответил на все вопросы, которые годами задавали фанаты.",
            pos = "noun", semanticGroup = "entertainment_production", fillInBlankExclusions = listOf(35303L, 35316L, 35317L, 35318L, 35319L)),

        // ── entertainment_fan_culture (5) ─────────────────────────────────

        WordEntity(id = 35321, setId = 353, languagePair = "en-ru", rarity = "RARE",
            original = "speedrun", transliteration = "[ˈspidˌrən]", translation = "спидран (прохождение игры на скорость)",
            definition = "A run through a game completed as fast as humanly possible.",
            definitionNative = "Прохождение игры за как можно меньшее время, на пределе человеческих возможностей.",
            example = "Her record speedrun beat the whole adventure in under three hours.",
            exampleNative = "Её рекордный speedrun прошёл всё приключение меньше чем за три часа.",
            pos = "noun", semanticGroup = "entertainment_fan_culture", fillInBlankExclusions = listOf(35322L, 35323L, 35324L, 35325L)),

        WordEntity(id = 35322, setId = 353, languagePair = "en-ru", rarity = "RARE",
            original = "fandom", transliteration = "[ˈfænˌdəm]", translation = "фэндом (сообщество поклонников)",
            definition = "The whole community of fans of a show, book series or game.",
            definitionNative = "Всё сообщество поклонников сериала, серии книг или игры.",
            example = "The witcher fandom built whole wikis and weekly podcasts together.",
            exampleNative = "Fandom «Ведьмака» вместе строит целые вики и еженедельные подкасты.",
            pos = "noun", semanticGroup = "entertainment_fan_culture", fillInBlankExclusions = listOf(35321L, 35323L, 35324L, 35325L)),

        WordEntity(id = 35323, setId = 353, languagePair = "en-ru", rarity = "RARE",
            original = "esports", transliteration = "[ˈiːˌspɔrts]", translation = "киберспорт (соревновательные видеоигры)",
            definition = "Pro-level video competitions watched live by big online audiences.",
            definitionNative = "Профессиональные соревнования в видеоиграх, которые смотрят онлайн вживую.",
            example = "Top esports finals now fill arenas just like football matches.",
            exampleNative = "Главные esports-финалы сейчас собирают арены не хуже футбольных матчей.",
            pos = "noun", semanticGroup = "entertainment_fan_culture", fillInBlankExclusions = listOf(35321L, 35322L, 35324L, 35325L)),

        WordEntity(id = 35324, setId = 353, languagePair = "en-ru", rarity = "RARE",
            original = "grind", transliteration = "[ɡraɪnd]", translation = "гринд (рутинное прокачивание)",
            definition = "Long repeating play needed to gather points or items in a game.",
            definitionNative = "Долгая повторяющаяся игра ради очков или предметов внутри игры.",
            example = "The endgame grind for rare gear takes most players a full month.",
            exampleNative = "Эндгейм-grind ради редкой экипировки занимает у большинства месяц.",
            pos = "noun", semanticGroup = "entertainment_fan_culture", fillInBlankExclusions = listOf(35321L, 35322L, 35323L, 35325L)),

        WordEntity(id = 35325, setId = 353, languagePair = "en-ru", rarity = "RARE",
            original = "leveling", transliteration = "[ˈlɛvəlɪŋ]", translation = "прокачка (повышение уровня персонажа)",
            definition = "The slow rise of a character's stats and skills as they gain experience.",
            definitionNative = "Постепенный рост характеристик и умений персонажа по мере получения опыта.",
            example = "Early leveling feels slow but pays off in late-game battles.",
            exampleNative = "Ранний leveling кажется медленным, но окупается в поздних битвах.",
            pos = "noun", semanticGroup = "entertainment_fan_culture", fillInBlankExclusions = listOf(35321L, 35322L, 35323L, 35324L)),
    )
}
