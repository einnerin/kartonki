package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Journalism (set 305, level 1).
 *
 * Set 305: Журналистика: основы (L1) — базовая лексика A1-B1 про газеты,
 * репортёров, телевидение, интервью, блоги и пресс-релизы.
 * Распределение редкости для L1 (основы): 10 COMMON + 15 UNCOMMON —
 * строго два смежных уровня по шкале валидатора.
 *
 * Существующие соседи по теме «Журналистика»:
 *  - Set 33 — UNCOMMON лексика (commentary, headline, editor, source, ...).
 *  - Set 51 — RARE лексика (broadcast, media, bias, censorship, ...).
 * Слова из этих наборов не дублируются здесь.
 */
object WordDataEnglishJournalism2 {

    val sets = listOf(
        WordSetEntity(
            id = 305,
            name = "Журналистика",
            description = "Основы: газета, журналист, новости, интервью",
            orderIndex = 125,
            languagePair = "en-ru",
            topic = "Журналистика",
            level = 1,
        ),
    )

    val words = listOf(

        // ── Set 305 — Журналистика: основы ─────────────────────────────────────

        // COMMON — press_content_text (что публикуют: новости, истории, интервью)
        WordEntity(
            id = 30501, original = "news", transliteration = "[nuz]", translation = "новости",
            rarity = "COMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_content_text",
            definition = "Reports about recent events — what happened today at home or abroad.",
            example = "Turn on the news at seven to hear today's stories.",
            definitionNative = "Сведения о свежих событиях — что случилось сегодня в стране и мире.",
            exampleNative = "Включи news в семь, чтобы услышать сегодняшние сюжеты.",
         fillInBlankExclusions = listOf(30502L, 30503L, 30506L, 30507L, 30518L, 30519L, 30520L)),
        WordEntity(
            id = 30502, original = "story", transliteration = "[ˈstɔri]", translation = "сюжет, материал",
            rarity = "COMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_content_text",
            definition = "A single piece of news — one event written or filmed in detail.",
            example = "The main story today is about the new city park.",
            definitionNative = "Отдельная новость — одно событие, описанное подробно в СМИ.",
            exampleNative = "Главный story дня — о новом городском парке.",
         fillInBlankExclusions = listOf(30501L, 30503L, 30508L, 30518L, 30519L, 30520L)),
        WordEntity(
            id = 30503, original = "interview", transliteration = "[ˈɪntərvˌju]", translation = "интервью",
            rarity = "COMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_content_text",
            definition = "A meeting where someone asks a guest questions to publish the answers.",
            example = "She gave a long interview to the local paper yesterday.",
            definitionNative = "Беседа с гостем для печати или эфира — вопросы и его ответы.",
            exampleNative = "Вчера она дала длинное interview местной газете.",
         fillInBlankExclusions = listOf(30501L, 30502L, 30518L, 30519L, 30520L)),

        // COMMON — press_people (кто пишет/читает)
        WordEntity(
            id = 30504, original = "writer", transliteration = "[ˈraɪtər]", translation = "автор",
            rarity = "COMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_people",
            definition = "A person who puts words on paper or a screen for other people to see.",
            example = "The writer of this piece works for a big magazine.",
            definitionNative = "Человек, который сочиняет тексты — статьи, книги, заметки для публики.",
            exampleNative = "Writer этого материала работает в крупном журнале.",
         fillInBlankExclusions = listOf(30505L, 30514L, 30521L, 30522L)),
        WordEntity(
            id = 30505, original = "reader", transliteration = "[ˈridər]", translation = "читатель",
            rarity = "COMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_people",
            definition = "A person who looks through a book, paper or screen to learn something.",
            example = "Every loyal reader of our paper got a free gift today.",
            definitionNative = "Человек, который знакомится с текстом — газетой, книгой или сайтом.",
            exampleNative = "Каждый верный reader нашей газеты получил сегодня подарок.",
         fillInBlankExclusions = listOf(30504L, 30514L, 30521L, 30522L)),

        // COMMON — press_broadcast (эфир: ТВ, радио)
        WordEntity(
            id = 30506, original = "TV", transliteration = "[ˌtiˈvi]", translation = "телевидение",
            rarity = "COMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_broadcast",
            definition = "A device with a screen that shows films, shows and live news.",
            example = "My grandpa watches the evening news on TV every day.",
            definitionNative = "Устройство с экраном — показывает передачи, фильмы и прямые эфиры.",
            exampleNative = "Дед каждый день смотрит вечерние новости по TV.",
         fillInBlankExclusions = listOf(30507L, 30517L)),
        WordEntity(
            id = 30507, original = "radio", transliteration = "[ˈreɪdiˌoʊ]", translation = "радио",
            rarity = "COMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_broadcast",
            definition = "A small box that plays sound — music, talk shows and live news.",
            example = "I listen to the radio while I drive to work.",
            definitionNative = "Коробочка с динамиком — передаёт звук, музыку, разговоры, эфир.",
            exampleNative = "Я слушаю radio по дороге на работу.",
         fillInBlankExclusions = listOf(30501L, 30502L, 30503L, 30506L, 30517L)),

        // COMMON — press_visual (визуальная часть: фото, страница)
        WordEntity(
            id = 30508, original = "photo", transliteration = "[ˈfoʊˌtoʊ]", translation = "фотография",
            rarity = "COMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_visual",
            definition = "A picture taken with a camera — it shows a moment exactly as it was.",
            example = "A big photo of the mayor filled the front page today.",
            definitionNative = "Снимок, сделанный камерой — точно показывает один миг жизни.",
            exampleNative = "Большое photo мэра заняло сегодня первую полосу.",
         fillInBlankExclusions = listOf(30502L, 30515L, 30516L)),
        WordEntity(
            id = 30509, original = "page", transliteration = "[peɪʤ]", translation = "страница",
            rarity = "COMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_visual",
            definition = "One side of a sheet in a book or paper — you turn it to see the next.",
            example = "The weather forecast is on the last page of the paper.",
            definitionNative = "Одна сторона листа в книге или газете — её перелистывают дальше.",
            exampleNative = "Прогноз погоды — на последней page газеты.",
         fillInBlankExclusions = listOf(30502L, 30508L, 30515L, 30516L, 30523L, 30524L)),

        // COMMON — press_outlet (где публикуется: газета)
        WordEntity(
            id = 30510, original = "newspaper", transliteration = "[ˈnuzˌpeɪpər]", translation = "газета",
            rarity = "COMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_outlet",
            definition = "A large folded sheet of paper with daily stories, sold at the corner shop.",
            example = "Dad buys a newspaper on his way home from work.",
            definitionNative = "Большой сложенный лист с ежедневными материалами — продают в киоске.",
            exampleNative = "Папа покупает newspaper по дороге с работы.",
         fillInBlankExclusions = listOf(30511L, 30512L, 30513L, 30525L)),

        // UNCOMMON — press_outlet (магазины, периодика)
        WordEntity(
            id = 30511, original = "magazine", transliteration = "[ˌmæɡəˈzin]", translation = "журнал",
            rarity = "UNCOMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_outlet",
            definition = "A thin book with glossy covers — it comes out each month or week.",
            example = "She reads a fashion magazine on the train every Friday.",
            definitionNative = "Тонкая книжка с глянцевой обложкой — выходит раз в месяц или неделю.",
            exampleNative = "Каждую пятницу она читает модный magazine в электричке.",
         fillInBlankExclusions = listOf(30502L, 30510L, 30512L, 30513L, 30519L, 30524L, 30525L)),
        WordEntity(
            id = 30512, original = "daily", transliteration = "[ˈdeɪli]", translation = "ежедневка, ежедневная газета",
            rarity = "UNCOMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_outlet",
            definition = "A paper that comes out every morning with the freshest stories.",
            example = "Our city daily costs one pound at the corner shop.",
            definitionNative = "Издание, выходящее каждое утро — со самой свежей повесткой.",
            exampleNative = "Наша городская daily стоит один фунт в киоске.",
         fillInBlankExclusions = listOf(30510L, 30511L, 30513L, 30524L, 30525L)),
        WordEntity(
            id = 30513, original = "weekly", transliteration = "[ˈwikli]", translation = "еженедельник",
            rarity = "UNCOMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_outlet",
            definition = "A paper or magazine that comes out once every seven days.",
            example = "He writes for a big business weekly in London.",
            definitionNative = "Издание, выходящее раз в семь дней — обычно крупный выпуск.",
            exampleNative = "Он пишет для крупного делового weekly в Лондоне.",
         fillInBlankExclusions = listOf(30510L, 30511L, 30512L, 30519L, 30524L, 30525L)),

        // UNCOMMON — press_people (репортёр)
        WordEntity(
            id = 30514, original = "reporter", transliteration = "[rɪˈpɔrtər]", translation = "корреспондент",
            rarity = "UNCOMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_people",
            definition = "A person who goes out, asks questions and writes about what happened.",
            example = "A reporter from the capital came to cover the fire.",
            definitionNative = "Сотрудник СМИ — выезжает на место, собирает факты и пишет материал.",
            exampleNative = "На пожар приехал reporter из столицы.",
         fillInBlankExclusions = listOf(30504L, 30505L, 30522L)),

        // UNCOMMON — press_visual (камера, обложка)
        WordEntity(
            id = 30515, original = "camera", transliteration = "[ˈkæmərə]", translation = "фотокамера",
            rarity = "UNCOMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_visual",
            definition = "A small box with a lens — you press a button and it saves a picture.",
            example = "He held the camera high to film the crowd below.",
            definitionNative = "Прибор с объективом — нажимаешь кнопку и сохраняешь изображение.",
            exampleNative = "Он поднял camera повыше, чтобы снять толпу внизу.",
         fillInBlankExclusions = listOf(30508L, 30509L, 30516L, 30517L, 30523L)),
        WordEntity(
            id = 30516, original = "cover", transliteration = "[ˈkəvər]", translation = "обложка",
            rarity = "UNCOMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_visual",
            definition = "The front outside part of a magazine — it shows a big picture and the title.",
            example = "The singer's face is on the cover of this month's issue.",
            definitionNative = "Внешняя лицевая сторона журнала — крупное изображение и название номера.",
            exampleNative = "Лицо певицы — на cover номера этого месяца.",
         fillInBlankExclusions = listOf(30508L, 30509L, 30515L, 30523L)),

        // UNCOMMON — press_broadcast (микрофон)
        WordEntity(
            id = 30517, original = "microphone", transliteration = "[ˈmaɪkrəˌfoʊn]", translation = "микрофон",
            rarity = "UNCOMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_broadcast",
            definition = "A small object you speak into so many people can hear your voice.",
            example = "She held the microphone close to the singer's face.",
            definitionNative = "Небольшой предмет — говоришь в него, и голос слышат многие.",
            exampleNative = "Она поднесла microphone к лицу певца.",
         fillInBlankExclusions = listOf(30506L, 30507L, 30508L, 30515L)),

        // UNCOMMON — press_content_text (название материала)
        WordEntity(
            id = 30518, original = "title", transliteration = "[ˈtaɪtəl]", translation = "название (материала)",
            rarity = "UNCOMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_content_text",
            definition = "The short name at the top that tells you what a piece is about.",
            example = "The title of her piece was just one powerful word.",
            definitionNative = "Короткое имя сверху — сразу говорит, о чём пойдёт речь в тексте.",
            exampleNative = "Title её материала состоял всего из одного мощного слова.",
         fillInBlankExclusions = listOf(30501L, 30502L, 30503L, 30519L, 30520L)),

        // UNCOMMON — press_content_text (блог и пресс-релиз — новые форматы материала)
        WordEntity(
            id = 30519, original = "blog", transliteration = "[blɑg]", translation = "блог",
            rarity = "UNCOMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_content_text",
            definition = "A personal site with short notes that the author adds every few days.",
            example = "She runs a travel blog with photos from twenty countries.",
            definitionNative = "Личный сайт с короткими заметками — автор добавляет их раз в несколько дней.",
            exampleNative = "Она ведёт blog о путешествиях с фото из двадцати стран.",
         fillInBlankExclusions = listOf(30501L, 30502L, 30503L, 30511L, 30513L, 30518L, 30520L)),
        WordEntity(
            id = 30520, original = "press release", transliteration = "[prɛs rɪˈlis]", translation = "пресс-релиз",
            rarity = "UNCOMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_content_text",
            definition = "A short paper a company sends to all reporters to share official news.",
            example = "The studio sent out a press release about the new film.",
            definitionNative = "Короткий документ — фирма рассылает его репортёрам, чтобы сообщить новость.",
            exampleNative = "Студия разослала press release о съёмках нового фильма.",
         fillInBlankExclusions = listOf(30501L, 30502L, 30518L, 30519L)),

        // UNCOMMON — press_people (ведущий новостей и автор блога)
        WordEntity(
            id = 30521, original = "anchor", transliteration = "[ˈæŋkər]", translation = "ведущий новостей",
            rarity = "UNCOMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_people",
            definition = "The main person who reads stories from a desk in a TV studio.",
            example = "The evening anchor smiled and said good night to viewers.",
            definitionNative = "Главный ведущий студии — читает сюжеты за столом в прямом эфире.",
            exampleNative = "Вечерний anchor улыбнулся и пожелал зрителям спокойной ночи.",
         fillInBlankExclusions = listOf(30504L, 30505L, 30514L, 30522L)),
        WordEntity(
            id = 30522, original = "blogger", transliteration = "[ˈblɑɡər]", translation = "автор блога",
            rarity = "UNCOMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_people",
            definition = "A person who writes short online notes for people who follow their site.",
            example = "A popular food blogger tried our new bakery yesterday.",
            definitionNative = "Человек, который пишет короткие заметки в сети для своих читателей.",
            exampleNative = "Известный blogger о еде попробовал нашу новую пекарню.",
         fillInBlankExclusions = listOf(30504L, 30505L, 30514L, 30521L)),

        // UNCOMMON — press_visual (первая полоса — главное визуальное место)
        WordEntity(
            id = 30523, original = "front page", transliteration = "[frʌnt peɪʤ]", translation = "первая полоса",
            rarity = "UNCOMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_visual",
            definition = "The first sheet of a paper where the biggest story of the day goes.",
            example = "The fire was on the front page of every morning paper.",
            definitionNative = "Первый лист газеты — там ставят самую важную новость дня.",
            exampleNative = "Пожар попал на front page всех утренних газет.",
         fillInBlankExclusions = listOf(30508L, 30509L, 30515L, 30516L)),

        // UNCOMMON — press_outlet (выпуск и срок сдачи — цикл публикации)
        WordEntity(
            id = 30524, original = "edition", transliteration = "[ɪˈdɪʃən]", translation = "выпуск (номер)",
            rarity = "UNCOMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_outlet",
            definition = "One run of a paper or magazine — all copies printed on the same day.",
            example = "The morning edition carried the big interview with the mayor.",
            definitionNative = "Один тираж газеты или журнала — экземпляры одной даты печати.",
            exampleNative = "Утренний edition вышел с большим интервью мэра.",
         fillInBlankExclusions = listOf(30510L, 30511L, 30512L, 30513L, 30525L)),
        WordEntity(
            id = 30525, original = "deadline", transliteration = "[ˈdɛˌdlaɪn]", translation = "срок сдачи материала",
            rarity = "UNCOMMON", setId = 305, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_outlet",
            definition = "The last hour to hand in a story — after that, the paper goes to print.",
            example = "The writer finished her story ten minutes before the deadline.",
            definitionNative = "Последний час сдать материал — после этого газету уже печатают.",
            exampleNative = "Автор дописала материал за десять минут до deadline.",
         fillInBlankExclusions = listOf(30510L, 30511L, 30512L, 30513L, 30524L)),
    )
}
