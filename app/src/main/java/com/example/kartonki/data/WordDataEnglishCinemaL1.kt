package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Кино и сериалы (L1, COMMON+UNCOMMON).
 *
 * Set 395: «Кино и сериалы» — основы.
 *          Базовая лексика A1-A2 о фильмах, сериалах, жанрах и просмотре.
 *          Слова, которые встречаются на афишах кинотеатра, в меню стриминга
 *          и в обычных разговорах «что вчера посмотрел».
 *
 * Тема пересекается с тремя уже существующими наборами: set 23 «Искусство»
 * (где живут scene, character, director, plot, composer, critic, stage), set 33
 * «Развлечения и досуг» (где живут review, editor, documentary, episode,
 * streaming) и set 206 «Cinema» в WordDataEnglishExpanded (film, actor, cinema,
 * blockbuster, comedy, sequel, premiere, screenplay, trailer, preview, subtitles,
 * cliffhanger, seat, cast, credits, box office). А также set 351-353
 * «Развлечения» (drama, thriller, sitcom, prequel, soundtrack, finale, fandom,
 * binge-watch, spoiler, antihero) и культурные/праздничные сеты (movie, cartoon).
 * Поэтому все 25 слов этого сета не пересекаются с существующими английскими
 * словами в базе (проверено grep'ом по `original = "..."`). Пришлось обойти
 * базовые лексемы (movie, film, actor, theater, ticket, screen, watch, scene,
 * episode, drama, comedy, thriller, action, hero, director, plot, character)
 * и взять смежные понятия того же уровня — flick, movie theater, watchlist,
 * horror, fantasy, western, actress, villain, series, rating, opener, dubbed,
 * remake и т.д.
 *
 * Распределение редкости: 18 COMMON + 7 UNCOMMON — два смежных уровня (A1 + A2).
 *
 * SemanticGroups (5 × 5):
 *   cinema_l1_basic     — flick, TV, movie night, movie theater, watchlist
 *   cinema_l1_genres    — horror, romance, fantasy, sci-fi, western
 *   cinema_l1_people    — actress, villain, good guy, fan, filmmaker
 *   cinema_l1_watching  — series, rating, recommend, opener, ending
 *   cinema_l1_streaming — remote, audio, dubbed, reboot, remake
 *
 * Word IDs: setId × 100 + position (39501..39525).
 *
 * isFillInBlankSafe = false на всех словах. fillInBlankExclusions пустые —
 * заполнятся через FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataEnglishCinemaL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 395,
            languagePair = "en-ru",
            orderIndex = 395,
            name = "Кино и сериалы",
            description = "Фильмы, сериалы, жанры и базовый просмотр",
            topic = "Кино и сериалы",
            level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 395 — Кино и сериалы: основы (L1, COMMON+UNCOMMON)           ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── cinema_l1_basic (5) ───────────────────────────────────────────

        WordEntity(id = 39501, setId = 395, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "flick", transliteration = "[flɪk]", translation = "фильм/киношка",
            definition = "An informal word for a film, often used for something fun and light.",
            definitionNative = "Неформальное слово для фильма — часто для лёгкого и развлекательного.",
            example = "Let's rent a funny flick and stay in tonight.",
            exampleNative = "Давай возьмём напрокат смешной flick и проведём вечер дома.",
            pos = "noun", semanticGroup = "cinema_l1_basic", fillInBlankExclusions = listOf(39502L, 39503L, 39504L, 39505L, 39506L, 39507L, 39508L, 39509L, 39510L, 39516L, 39524L, 39525L)),

        WordEntity(id = 39502, setId = 395, languagePair = "en-ru", rarity = "COMMON",
            original = "TV", transliteration = "[ˌtiˈvi]", translation = "телевизор",
            definition = "The box in your living room that shows shows and movies.",
            definitionNative = "Ящик в комнате, на котором показывают передачи и фильмы.",
            example = "We watched the football match on the new TV.",
            exampleNative = "Мы смотрели футбольный матч на новом TV.",
            pos = "noun", semanticGroup = "cinema_l1_basic", fillInBlankExclusions = listOf(39501L, 39503L, 39504L, 39505L)),

        WordEntity(id = 39503, setId = 395, languagePair = "en-ru", rarity = "COMMON",
            original = "movie night", transliteration = "[ˈmuvi naɪt]", translation = "киновечер",
            definition = "An evening at home or with friends spent watching movies together.",
            definitionNative = "Вечер дома или с друзьями, который проводят за просмотром фильмов.",
            example = "Friday is always movie night with the kids and lots of popcorn.",
            exampleNative = "Пятница — это всегда movie night с детьми и кучей попкорна.",
            pos = "noun", semanticGroup = "cinema_l1_basic", fillInBlankExclusions = listOf(39501L, 39502L, 39504L, 39505L, 39506L)),

        WordEntity(id = 39504, setId = 395, languagePair = "en-ru", rarity = "COMMON",
            original = "movie theater", transliteration = "[ˈmuvi ˈθiətər]", translation = "кинотеатр",
            definition = "A big public place with many seats and a huge screen for new films.",
            definitionNative = "Большое общественное место с креслами и огромным экраном для новых фильмов.",
            example = "The new movie theater downtown has comfy reclining seats.",
            exampleNative = "В новом movie theater в центре стоят удобные раскладные кресла.",
            pos = "noun", semanticGroup = "cinema_l1_basic", fillInBlankExclusions = listOf(39501L, 39502L, 39503L, 39505L)),

        WordEntity(id = 39505, setId = 395, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "watchlist", transliteration = "[ˈwɑʧˌlɪst]", translation = "список к просмотру",
            definition = "A saved list of shows and movies you plan to see later.",
            definitionNative = "Сохранённый список фильмов и сериалов, которые ты собираешься посмотреть позже.",
            example = "I added three new shows to my watchlist over the weekend.",
            exampleNative = "Я добавил три новых сериала в свой watchlist за выходные.",
            pos = "noun", semanticGroup = "cinema_l1_basic", fillInBlankExclusions = listOf(39501L, 39502L, 39503L, 39504L)),

        // ── cinema_l1_genres (5) ──────────────────────────────────────────

        WordEntity(id = 39506, setId = 395, languagePair = "en-ru", rarity = "COMMON",
            original = "horror", transliteration = "[ˈhɔrər]", translation = "ужасы",
            definition = "A type of film that tries to scare you with monsters or ghosts.",
            definitionNative = "Жанр фильма, который старается напугать монстрами или привидениями.",
            example = "I can't watch horror late at night — I won't sleep.",
            exampleNative = "Я не могу смотреть horror поздно ночью — потом не усну.",
            pos = "noun", semanticGroup = "cinema_l1_genres", fillInBlankExclusions = listOf(39502L, 39507L, 39508L, 39509L, 39510L)),

        WordEntity(id = 39507, setId = 395, languagePair = "en-ru", rarity = "COMMON",
            original = "romance", transliteration = "[ˈroʊˌmæns]", translation = "мелодрама",
            definition = "A type of film about people falling in love and their feelings.",
            definitionNative = "Жанр фильма про любовь и чувства между людьми.",
            example = "She likes a good romance with a happy ending.",
            exampleNative = "Она любит хорошую romance со счастливым концом.",
            pos = "noun", semanticGroup = "cinema_l1_genres", fillInBlankExclusions = listOf(39501L, 39503L, 39506L, 39508L, 39509L, 39510L, 39516L, 39524L, 39525L)),

        WordEntity(id = 39508, setId = 395, languagePair = "en-ru", rarity = "COMMON",
            original = "fantasy", transliteration = "[ˈfæntəsi]", translation = "фэнтези",
            definition = "A genre with magic, dragons and worlds that don't exist in real life.",
            definitionNative = "Жанр с магией, драконами и мирами, которых нет в реальной жизни.",
            example = "He grew up reading fantasy and now writes his own books.",
            exampleNative = "Он вырос на fantasy и теперь сам пишет книги.",
            pos = "noun", semanticGroup = "cinema_l1_genres", fillInBlankExclusions = listOf(39506L, 39507L, 39509L, 39510L)),

        WordEntity(id = 39509, setId = 395, languagePair = "en-ru", rarity = "COMMON",
            original = "sci-fi", transliteration = "[ˈsaɪˌfaɪ]", translation = "научная фантастика",
            definition = "A genre about space, robots, the future and new technology.",
            definitionNative = "Жанр про космос, роботов, будущее и новые технологии.",
            example = "My brother only watches sci-fi with spaceships and aliens.",
            exampleNative = "Мой брат смотрит только sci-fi с космическими кораблями и пришельцами.",
            pos = "noun", semanticGroup = "cinema_l1_genres", fillInBlankExclusions = listOf(39506L, 39507L, 39508L, 39510L)),

        WordEntity(id = 39510, setId = 395, languagePair = "en-ru", rarity = "COMMON",
            original = "western", transliteration = "[ˈwɛstərn]", translation = "вестерн",
            definition = "A film about cowboys, horses and the old American Wild West.",
            definitionNative = "Фильм про ковбоев, лошадей и старый американский Дикий Запад.",
            example = "Grandpa loves an old western with cowboys and dusty towns.",
            exampleNative = "Дедушка любит старый western с ковбоями и пыльными городками.",
            pos = "noun", semanticGroup = "cinema_l1_genres", fillInBlankExclusions = listOf(39506L, 39507L, 39508L, 39509L)),

        // ── cinema_l1_people (5) ──────────────────────────────────────────

        WordEntity(id = 39511, setId = 395, languagePair = "en-ru", rarity = "COMMON",
            original = "actress", transliteration = "[ˈæktrəs]", translation = "актриса",
            definition = "A woman whose job is to play characters in films or on stage.",
            definitionNative = "Женщина, чья работа — играть персонажей в фильмах или на сцене.",
            example = "She is my favorite actress in romantic films.",
            exampleNative = "Она моя любимая actress в романтических фильмах.",
            pos = "noun", semanticGroup = "cinema_l1_people", fillInBlankExclusions = listOf(39512L, 39513L, 39514L, 39515L)),

        WordEntity(id = 39512, setId = 395, languagePair = "en-ru", rarity = "COMMON",
            original = "villain", transliteration = "[ˈvɪlən]", translation = "злодей",
            definition = "The bad person in a story whose plans the good characters fight against.",
            definitionNative = "Плохой человек в истории, против чьих планов борются положительные герои.",
            example = "The villain in this movie wears a long black coat.",
            exampleNative = "Villain в этом фильме носит длинное чёрное пальто.",
            pos = "noun", semanticGroup = "cinema_l1_people", fillInBlankExclusions = listOf(39511L, 39513L, 39514L, 39515L)),

        WordEntity(id = 39513, setId = 395, languagePair = "en-ru", rarity = "COMMON",
            original = "good guy", transliteration = "[ɡʊd ɡaɪ]", translation = "положительный герой",
            definition = "The kind, honest character that the audience wants to win.",
            definitionNative = "Добрый, честный персонаж, за чью победу болеет зритель.",
            example = "You always know who the good guy is by the end of the first scene.",
            exampleNative = "К концу первой сцены всегда понятно, кто здесь good guy.",
            pos = "noun", semanticGroup = "cinema_l1_people", fillInBlankExclusions = listOf(39511L, 39512L, 39514L, 39515L)),

        WordEntity(id = 39514, setId = 395, languagePair = "en-ru", rarity = "COMMON",
            original = "fan", transliteration = "[fæn]", translation = "фанат",
            definition = "A person who loves a film, show or actor and follows everything about them.",
            definitionNative = "Человек, который обожает фильм, сериал или актёра и следит за ним.",
            example = "He's a huge fan of every Marvel movie ever made.",
            exampleNative = "Он огромный fan каждого фильма Marvel, который когда-либо снимали.",
            pos = "noun", semanticGroup = "cinema_l1_people", fillInBlankExclusions = listOf(39511L, 39512L, 39513L, 39515L)),

        WordEntity(id = 39515, setId = 395, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "filmmaker", transliteration = "[ˈfɪlmˌmeɪkər]", translation = "кинематографист",
            definition = "A person who makes movies — usually directs and helps create the whole film.",
            definitionNative = "Человек, который делает фильмы — обычно режиссирует и создаёт фильм целиком.",
            example = "The young filmmaker won a prize at her first festival.",
            exampleNative = "Молодая filmmaker получила приз на своём первом фестивале.",
            pos = "noun", semanticGroup = "cinema_l1_people", fillInBlankExclusions = listOf(39511L, 39512L, 39513L, 39514L)),

        // ── cinema_l1_watching (5) ────────────────────────────────────────

        WordEntity(id = 39516, setId = 395, languagePair = "en-ru", rarity = "COMMON",
            original = "series", transliteration = "[ˈsɪriz]", translation = "сериал",
            definition = "A show with many parts that tell one long story over time.",
            definitionNative = "Передача из множества серий, которые рассказывают одну долгую историю.",
            example = "We finished the whole series in two weeks.",
            exampleNative = "Мы досмотрели весь series за две недели.",
            pos = "noun", semanticGroup = "cinema_l1_watching", fillInBlankExclusions = listOf(39501L, 39503L, 39505L, 39507L, 39508L, 39509L, 39510L, 39517L, 39519L, 39520L, 39522L, 39524L, 39525L)),

        WordEntity(id = 39517, setId = 395, languagePair = "en-ru", rarity = "COMMON",
            original = "rating", transliteration = "[ˈreɪtɪŋ]", translation = "рейтинг",
            definition = "A score that shows how good a film is, based on viewers or critics.",
            definitionNative = "Оценка, которая показывает, насколько фильм хороший — по мнению зрителей или критиков.",
            example = "This movie has a high rating, so let's give it a try.",
            exampleNative = "У этого фильма высокий rating, давай попробуем.",
            pos = "noun", semanticGroup = "cinema_l1_watching", fillInBlankExclusions = listOf(39516L, 39519L, 39520L)),

        WordEntity(id = 39518, setId = 395, languagePair = "en-ru", rarity = "COMMON",
            original = "recommend", transliteration = "[ˌrɛkəˈmɛnd]", translation = "рекомендовать",
            definition = "To tell someone that a film or show is good and they should see it.",
            definitionNative = "Сказать кому-то, что фильм или сериал хороший и стоит посмотреть.",
            example = "I recommend this thriller — it surprised me until the very end.",
            exampleNative = "Я recommend этот триллер — он удивлял меня до самого конца.",
            pos = "verb", semanticGroup = "cinema_l1_watching"),

        WordEntity(id = 39519, setId = 395, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "opener", transliteration = "[ˈoʊpənər]", translation = "первая сцена",
            definition = "The first scene of a film or show that pulls you in right away.",
            definitionNative = "Самая первая сцена фильма или сериала, которая сразу тебя цепляет.",
            example = "The opener with the car chase made me sit up and pay attention.",
            exampleNative = "Opener с погоней на машинах заставил меня выпрямиться и смотреть внимательно.",
            pos = "noun", semanticGroup = "cinema_l1_watching", fillInBlankExclusions = listOf(39501L, 39516L, 39517L, 39520L, 39524L, 39525L)),

        WordEntity(id = 39520, setId = 395, languagePair = "en-ru", rarity = "COMMON",
            original = "ending", transliteration = "[ˈɛndɪŋ]", translation = "концовка",
            definition = "The last part of a film or show — how the story finishes.",
            definitionNative = "Последняя часть фильма или сериала — то, чем заканчивается история.",
            example = "The ending was sad but it felt right for the story.",
            exampleNative = "Ending был грустным, но подходил истории.",
            pos = "noun", semanticGroup = "cinema_l1_watching", fillInBlankExclusions = listOf(39501L, 39506L, 39507L, 39508L, 39509L, 39510L, 39511L, 39512L, 39513L, 39515L, 39516L, 39517L, 39519L, 39524L, 39525L)),

        // ── cinema_l1_streaming (5) ───────────────────────────────────────

        WordEntity(id = 39521, setId = 395, languagePair = "en-ru", rarity = "COMMON",
            original = "remote", transliteration = "[rɪˈmoʊt]", translation = "пульт",
            definition = "The small device with buttons you use to control the TV from the couch.",
            definitionNative = "Маленькое устройство с кнопками — управляешь телевизором с дивана.",
            example = "I lost the remote between the cushions again.",
            exampleNative = "Я опять потерял remote между подушками дивана.",
            pos = "noun", semanticGroup = "cinema_l1_streaming", fillInBlankExclusions = listOf(39522L, 39524L, 39525L)),

        WordEntity(id = 39522, setId = 395, languagePair = "en-ru", rarity = "COMMON",
            original = "audio", transliteration = "[ˈɔdiˌoʊ]", translation = "звуковая дорожка",
            definition = "The sound part of a film — voices, music and noises you hear.",
            definitionNative = "Звуковая часть фильма — голоса, музыка и шумы, которые слышишь.",
            example = "Switch the audio to English if you want the original voices.",
            exampleNative = "Переключи audio на английский, если хочешь слышать оригинальные голоса.",
            pos = "noun", semanticGroup = "cinema_l1_streaming", fillInBlankExclusions = listOf(39502L, 39521L, 39524L, 39525L)),

        WordEntity(id = 39523, setId = 395, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "dubbed", transliteration = "[dʌbd]", translation = "дублированный",
            definition = "Made in another language, with new voices replacing the original ones.",
            definitionNative = "Переделанный на другой язык — оригинальные голоса заменили новыми.",
            example = "The film was dubbed in Russian, so we didn't need subtitles.",
            exampleNative = "Фильм был dubbed на русский, и субтитры нам не понадобились.",
            pos = "adjective", semanticGroup = "cinema_l1_streaming"),

        WordEntity(id = 39524, setId = 395, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "reboot", transliteration = "[ˈriˌbut]", translation = "перезапуск",
            definition = "A fresh start of an old film series, often with new actors and a new style.",
            definitionNative = "Свежий старт старой серии фильмов — часто с новыми актёрами и новым стилем.",
            example = "The reboot of the old superhero saga came out last summer.",
            exampleNative = "Reboot старой саги о супергерое вышел прошлым летом.",
            pos = "noun", semanticGroup = "cinema_l1_streaming", fillInBlankExclusions = listOf(39511L, 39512L, 39513L, 39515L, 39516L, 39520L, 39521L, 39522L, 39525L)),

        WordEntity(id = 39525, setId = 395, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "remake", transliteration = "[ˈriˌmeɪk]", translation = "ремейк",
            definition = "A new version of an older film that tells the same story again.",
            definitionNative = "Новая версия старого фильма, которая рассказывает ту же историю заново.",
            example = "The remake of the classic comedy didn't really work for me.",
            exampleNative = "Remake классической комедии меня не зацепил.",
            pos = "noun", semanticGroup = "cinema_l1_streaming", fillInBlankExclusions = listOf(39511L, 39512L, 39513L, 39515L, 39519L, 39520L, 39521L, 39522L, 39524L)),
    )
}
