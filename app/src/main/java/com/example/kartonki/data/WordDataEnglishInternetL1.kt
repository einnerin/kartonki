package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Интернет и соцсети (L1, COMMON+UNCOMMON).
 *
 * Set 390: «Интернет и соцсети» — основы.
 *          Базовая лексика A1-A2 о соцсетях, мессенджерах и веб-сайтах.
 *          Кнопки и действия в любом приложении: подписаться, листать,
 *          заблокировать, отключить звук — всё, что делает каждый пользователь
 *          в первый день регистрации.
 *
 * Тема пересекается с двумя уже существующими наборами: set 18 «Технологии»
 * (где живут internet, website, app, email, password, share, link, message,
 * download, upload, search, click, screen, wifi, browser, keyboard, camera)
 * и set 209 «Internet/Социальные сети» (username, hashtag, profile, post,
 * comment, chat, account, feed, emoji, avatar, follower, notification, meme,
 * spam, screenshot — почти весь основной слой). Поэтому все 25 слов этого
 * сета не пересекаются с существующими английскими словами в базе
 * (проверено grep'ом по `original = "..."`). Пришлось обойти базовые лексемы
 * (online, offline, photo, video, friend, like, share, link, post, follow*er,
 * profile, feed, account, emoji, message, chat, comment, hashtag, story) и
 * взять смежные понятия того же уровня — webpage, homepage, scroll, swipe,
 * selfie, GIF, news feed, group chat, video chat и т.д.
 *
 * Распределение редкости: 18 COMMON + 7 UNCOMMON — два смежных уровня (A1 + A2).
 *
 * SemanticGroups (5 × 5):
 *   internet_l1_basic     — webpage, homepage, site, user, bookmark
 *   internet_l1_actions   — follow, scroll, swipe, block, mute
 *   internet_l1_social    — selfie, status, forum, smiley, login
 *   internet_l1_messaging — group chat, voice message, video chat, bot, signup
 *   internet_l1_content   — GIF, search bar, wallpaper, privacy, news feed
 *
 * Word IDs: setId × 100 + position (39001..39025).
 *
 * isFillInBlankSafe = false на всех словах. fillInBlankExclusions пустые —
 * заполнятся через FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataEnglishInternetL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 390,
            languagePair = "en-ru",
            orderIndex = 390,
            name = "Интернет и соцсети",
            description = "Соцсети, мессенджеры и базовое использование веба",
            topic = "Интернет и соцсети",
            level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 390 — Интернет и соцсети: основы (L1, COMMON+UNCOMMON)       ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── internet_l1_basic (5) ─────────────────────────────────────────

        WordEntity(id = 39001, setId = 390, languagePair = "en-ru", rarity = "COMMON",
            original = "webpage", transliteration = "[ˈwɛbˌpeɪʤ]", translation = "веб-страница",
            definition = "One single document on the internet that you open in a browser.",
            definitionNative = "Один отдельный документ в интернете — открываешь его в браузере.",
            example = "This webpage takes forever to load on my phone.",
            exampleNative = "Эта webpage очень долго грузится на моём телефоне.",
            pos = "noun", semanticGroup = "internet_l1_basic", fillInBlankExclusions = listOf(39002L, 39003L, 39004L, 39005L, 39013L, 39022L, 39025L)),

        WordEntity(id = 39002, setId = 390, languagePair = "en-ru", rarity = "COMMON",
            original = "homepage", transliteration = "[ˈhoʊmˌpeɪʤ]", translation = "главная страница",
            definition = "The first page of a website — the one you land on by default.",
            definitionNative = "Первая страница сайта — на неё попадаешь, когда заходишь на сайт.",
            example = "I added a big photo of the team to our homepage.",
            exampleNative = "Я добавил большое фото команды на нашу homepage.",
            pos = "noun", semanticGroup = "internet_l1_basic", fillInBlankExclusions = listOf(39001L, 39003L, 39004L, 39005L, 39013L, 39016L, 39025L)),

        WordEntity(id = 39003, setId = 390, languagePair = "en-ru", rarity = "COMMON",
            original = "site", transliteration = "[saɪt]", translation = "сайт",
            definition = "A whole place on the internet with many pages under one address.",
            definitionNative = "Целое место в интернете с множеством страниц под одним адресом.",
            example = "I buy all my books from the same site.",
            exampleNative = "Я покупаю все свои книги на одном и том же site.",
            pos = "noun", semanticGroup = "internet_l1_basic", fillInBlankExclusions = listOf(39001L, 39002L, 39004L, 39005L, 39013L)),

        WordEntity(id = 39004, setId = 390, languagePair = "en-ru", rarity = "COMMON",
            original = "user", transliteration = "[ˈjuzər]", translation = "пользователь",
            definition = "A person who has signed up and uses an app or website.",
            definitionNative = "Человек, который зарегистрировался и пользуется приложением или сайтом.",
            example = "Every user must agree to the rules before posting.",
            exampleNative = "Каждый user должен согласиться с правилами перед публикацией.",
            pos = "noun", semanticGroup = "internet_l1_basic", fillInBlankExclusions = listOf(39001L, 39002L, 39003L, 39005L)),

        WordEntity(id = 39005, setId = 390, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "bookmark", transliteration = "[ˈbʊkˌmɑrk]", translation = "закладка",
            definition = "A saved link in your browser so you can find a page again fast.",
            definitionNative = "Сохранённая ссылка в браузере — чтобы быстро найти страницу снова.",
            example = "Save this recipe as a bookmark so you don't lose it.",
            exampleNative = "Сохрани этот рецепт как bookmark, чтобы не потерять.",
            pos = "noun", semanticGroup = "internet_l1_basic", fillInBlankExclusions = listOf(39001L, 39002L, 39003L)),

        // ── internet_l1_actions (5) ───────────────────────────────────────

        WordEntity(id = 39006, setId = 390, languagePair = "en-ru", rarity = "COMMON",
            original = "follow", transliteration = "[ˈfɑloʊ]", translation = "подписываться",
            definition = "To start seeing someone's posts in your feed all the time.",
            definitionNative = "Начать видеть в своей ленте все посты другого человека.",
            example = "I follow three cooking blogs and a travel photographer.",
            exampleNative = "Я follow за тремя кулинарными блогами и одним фотографом-путешественником.",
            pos = "verb", semanticGroup = "internet_l1_actions", fillInBlankExclusions = listOf(39007L, 39008L, 39009L, 39010L)),

        WordEntity(id = 39007, setId = 390, languagePair = "en-ru", rarity = "COMMON",
            original = "scroll", transliteration = "[skroʊl]", translation = "листать",
            definition = "To move the screen up or down with your finger or a wheel.",
            definitionNative = "Двигать экран вверх или вниз пальцем или колёсиком мышки.",
            example = "I could scroll through my feed for hours without noticing.",
            exampleNative = "Я могу scroll ленту часами, не замечая времени.",
            pos = "verb", semanticGroup = "internet_l1_actions", fillInBlankExclusions = listOf(39006L, 39008L, 39009L, 39010L)),

        WordEntity(id = 39008, setId = 390, languagePair = "en-ru", rarity = "COMMON",
            original = "swipe", transliteration = "[swaɪp]", translation = "свайпать",
            definition = "To slide your finger across a screen to move things sideways.",
            definitionNative = "Провести пальцем по экрану, чтобы сдвинуть что-то вбок.",
            example = "Swipe left to see the next photo in the album.",
            exampleNative = "Swipe влево, чтобы увидеть следующее фото в альбоме.",
            pos = "verb", semanticGroup = "internet_l1_actions", fillInBlankExclusions = listOf(39006L, 39007L, 39009L, 39010L)),

        WordEntity(id = 39009, setId = 390, languagePair = "en-ru", rarity = "COMMON",
            original = "block", transliteration = "[blɑk]", translation = "блокировать",
            definition = "To stop someone from contacting you or seeing your profile online.",
            definitionNative = "Запретить кому-то писать тебе или видеть твой профиль в сети.",
            example = "She decided to block the rude commenter once and for all.",
            exampleNative = "Она решила block грубого комментатора раз и навсегда.",
            pos = "verb", semanticGroup = "internet_l1_actions", fillInBlankExclusions = listOf(39006L, 39007L, 39008L, 39010L)),

        WordEntity(id = 39010, setId = 390, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "mute", transliteration = "[mjut]", translation = "отключить уведомления",
            definition = "To silence someone's posts or a chat without blocking the person.",
            definitionNative = "Заглушить чьи-то посты или чат, но не блокировать самого человека.",
            example = "I had to mute the group chat — it never stopped buzzing.",
            exampleNative = "Пришлось mute групповой чат — он не переставал жужжать.",
            pos = "verb", semanticGroup = "internet_l1_actions", fillInBlankExclusions = listOf(39006L, 39007L, 39008L, 39009L)),

        // ── internet_l1_social (5) ────────────────────────────────────────

        WordEntity(id = 39011, setId = 390, languagePair = "en-ru", rarity = "COMMON",
            original = "selfie", transliteration = "[ˈsɛlfi]", translation = "селфи",
            definition = "A photo you take of yourself, usually at arm's length.",
            definitionNative = "Фото самого себя, обычно сделанное на вытянутой руке.",
            example = "She took a selfie with the sunset behind her.",
            exampleNative = "Она сделала selfie на фоне заката.",
            pos = "noun", semanticGroup = "internet_l1_social", fillInBlankExclusions = listOf(39012L, 39013L, 39014L, 39015L)),

        WordEntity(id = 39012, setId = 390, languagePair = "en-ru", rarity = "COMMON",
            original = "status", transliteration = "[ˈstætəs]", translation = "статус",
            definition = "A short note on your profile that says how you feel or what you're doing.",
            definitionNative = "Короткая надпись в профиле — рассказывает, как ты или чем занят.",
            example = "He changed his status to \"on vacation\" before leaving.",
            exampleNative = "Он сменил status на «в отпуске» перед поездкой.",
            pos = "noun", semanticGroup = "internet_l1_social", fillInBlankExclusions = listOf(39001L, 39002L, 39011L, 39013L, 39014L, 39015L)),

        WordEntity(id = 39013, setId = 390, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "forum", transliteration = "[ˈfɔrəm]", translation = "форум",
            definition = "An online place where people post questions and answers about a topic.",
            definitionNative = "Место в сети, где люди задают вопросы и отвечают по одной теме.",
            example = "I found the answer on a gardening forum after hours of searching.",
            exampleNative = "Я нашёл ответ на садоводческом forum после долгих поисков.",
            pos = "noun", semanticGroup = "internet_l1_social", fillInBlankExclusions = listOf(39001L, 39002L, 39003L, 39011L, 39012L, 39014L, 39015L, 39016L, 39019L, 39025L)),

        WordEntity(id = 39014, setId = 390, languagePair = "en-ru", rarity = "COMMON",
            original = "smiley", transliteration = "[ˈsmaɪli]", translation = "смайлик",
            definition = "A small round yellow face used to show feelings in messages.",
            definitionNative = "Маленькое жёлтое круглое лицо — показывает чувства в сообщениях.",
            example = "Add a smiley so the joke doesn't sound mean.",
            exampleNative = "Добавь smiley, чтобы шутка не прозвучала злой.",
            pos = "noun", semanticGroup = "internet_l1_social", fillInBlankExclusions = listOf(39011L, 39012L, 39013L, 39015L, 39021L)),

        WordEntity(id = 39015, setId = 390, languagePair = "en-ru", rarity = "COMMON",
            original = "login", transliteration = "[ˈlɔˌɡɪn]", translation = "вход в аккаунт",
            definition = "The act of entering your name and password to enter an account.",
            definitionNative = "Ввод имени и пароля, чтобы войти в свой аккаунт.",
            example = "Use the same login on every device to keep your data in sync.",
            exampleNative = "Используй один login на всех устройствах, чтобы данные совпадали.",
            pos = "noun", semanticGroup = "internet_l1_social", fillInBlankExclusions = listOf(39003L, 39011L, 39012L, 39013L, 39014L, 39023L, 39024L)),

        // ── internet_l1_messaging (5) ─────────────────────────────────────

        WordEntity(id = 39016, setId = 390, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "group chat", transliteration = "[ɡrup ʧæt]", translation = "групповой чат",
            definition = "A single chat where three or more people send messages together.",
            definitionNative = "Один чат, где трое или больше людей пишут вместе.",
            example = "We made a group chat for the trip to share photos and plans.",
            exampleNative = "Мы создали group chat для поездки, чтобы делиться фото и планами.",
            pos = "noun", semanticGroup = "internet_l1_messaging", fillInBlankExclusions = listOf(39001L, 39002L, 39003L, 39013L, 39017L, 39018L, 39019L, 39020L, 39025L)),

        WordEntity(id = 39017, setId = 390, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "voice message", transliteration = "[vɔɪs ˈmɛsɪʤ]", translation = "голосовое сообщение",
            definition = "A short recording of your voice sent instead of typing text.",
            definitionNative = "Короткая запись твоего голоса вместо набранного текста.",
            example = "She sent a long voice message to explain the whole story.",
            exampleNative = "Она отправила длинное voice message, чтобы рассказать всю историю.",
            pos = "noun", semanticGroup = "internet_l1_messaging", fillInBlankExclusions = listOf(39016L, 39018L, 39019L, 39020L)),

        WordEntity(id = 39018, setId = 390, languagePair = "en-ru", rarity = "COMMON",
            original = "video chat", transliteration = "[ˈvɪdioʊ ʧæt]", translation = "видеочат",
            definition = "A live conversation where you see and hear each other on screen.",
            definitionNative = "Живой разговор, где вы видите и слышите друг друга на экране.",
            example = "We had a video chat with grandma every Sunday morning.",
            exampleNative = "Мы делали video chat с бабушкой каждое воскресное утро.",
            pos = "noun", semanticGroup = "internet_l1_messaging", fillInBlankExclusions = listOf(39016L, 39017L, 39019L, 39020L)),

        WordEntity(id = 39019, setId = 390, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "bot", transliteration = "[bɑt]", translation = "бот",
            definition = "A small program that talks to users automatically without a real person.",
            definitionNative = "Маленькая программа, которая общается с людьми сама — без живого человека.",
            example = "A bot answered my first question before a real agent took over.",
            exampleNative = "Сначала bot ответил на мой вопрос, потом подключился живой оператор.",
            pos = "noun", semanticGroup = "internet_l1_messaging", fillInBlankExclusions = listOf(39016L, 39017L, 39018L, 39020L)),

        WordEntity(id = 39020, setId = 390, languagePair = "en-ru", rarity = "COMMON",
            original = "signup", transliteration = "[ˈsaɪnˌəp]", translation = "регистрация",
            definition = "The first step where you create a new account on a service.",
            definitionNative = "Первый шаг — когда ты создаёшь новый аккаунт на сервисе.",
            example = "The signup takes only one minute if you use your phone number.",
            exampleNative = "Signup занимает всего минуту, если использовать номер телефона.",
            pos = "noun", semanticGroup = "internet_l1_messaging", fillInBlankExclusions = listOf(39001L, 39002L, 39015L, 39016L, 39017L, 39018L, 39019L)),

        // ── internet_l1_content (5) ───────────────────────────────────────

        WordEntity(id = 39021, setId = 390, languagePair = "en-ru", rarity = "COMMON",
            original = "gif", transliteration = "[ʤɪf]", translation = "гифка",
            definition = "A tiny silent video that loops over and over, often funny.",
            definitionNative = "Маленькое беззвучное видео, повторяющееся по кругу, — часто смешное.",
            example = "He answered with a dancing cat gif instead of words.",
            exampleNative = "Он ответил gif с танцующим котом вместо слов.",
            pos = "noun", semanticGroup = "internet_l1_content", fillInBlankExclusions = listOf(39014L, 39022L, 39023L, 39024L, 39025L)),

        WordEntity(id = 39022, setId = 390, languagePair = "en-ru", rarity = "COMMON",
            original = "search bar", transliteration = "[sərʧ bɑr]", translation = "строка поиска",
            definition = "The long thin box at the top of an app where you type what you're looking for.",
            definitionNative = "Длинная узкая полоска вверху приложения — туда печатаешь, что ищешь.",
            example = "Type the name of the song into the search bar at the top.",
            exampleNative = "Напечатай название песни в search bar наверху.",
            pos = "noun", semanticGroup = "internet_l1_content", fillInBlankExclusions = listOf(39021L, 39023L, 39024L, 39025L)),

        WordEntity(id = 39023, setId = 390, languagePair = "en-ru", rarity = "COMMON",
            original = "wallpaper", transliteration = "[ˈwɔlˌpeɪpər]", translation = "обои (на экране)",
            definition = "The picture you see on your phone or computer behind all the icons.",
            definitionNative = "Картинка на экране телефона или компьютера за всеми значками.",
            example = "I changed my wallpaper to a photo of the sea.",
            exampleNative = "Я поменял wallpaper на фото моря.",
            pos = "noun", semanticGroup = "internet_l1_content", fillInBlankExclusions = listOf(39002L, 39012L, 39021L, 39022L, 39024L, 39025L)),

        WordEntity(id = 39024, setId = 390, languagePair = "en-ru", rarity = "COMMON",
            original = "privacy", transliteration = "[ˈpraɪvəsi]", translation = "приватность",
            definition = "The right to keep your personal info hidden from strangers online.",
            definitionNative = "Право прятать свою личную информацию от чужих людей в сети.",
            example = "Check your privacy settings before posting family photos.",
            exampleNative = "Проверь настройки privacy, прежде чем выкладывать семейные фото.",
            pos = "noun", semanticGroup = "internet_l1_content", fillInBlankExclusions = listOf(39003L, 39012L, 39015L, 39019L, 39020L, 39021L, 39022L, 39023L, 39025L)),

        WordEntity(id = 39025, setId = 390, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "news feed", transliteration = "[nuz fid]", translation = "лента новостей",
            definition = "The endless list of fresh posts you see when you open a social app.",
            definitionNative = "Бесконечный список свежих постов, который открывается в соцсети.",
            example = "My news feed was full of vacation photos from my friends.",
            exampleNative = "Мой news feed был полон отпускных фото от друзей.",
            pos = "noun", semanticGroup = "internet_l1_content", fillInBlankExclusions = listOf(39001L, 39002L, 39003L, 39013L, 39016L, 39021L, 39022L, 39023L, 39024L)),
    )
}
