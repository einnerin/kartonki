package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Интернет и соцсети, расширение #6 (L2, UNCOMMON+RARE).
 *
 * Set 454: «Интернет и соцсети» — современные платформы и форматы контента.
 *          Брендовые названия соцсетей (TikTok, Discord, Reddit, Twitch, Patreon),
 *          форматы коротких видео (shorts, reels, stories, FYP, stitch), стриминг
 *          (raid, emote, super chat, donation, subscriber), creator economy
 *          (creator, creator economy, merch, ad-free, demonetization) и
 *          сообщества (subreddit, karma, AMA, shoutout, collab).
 *
 * Тема — продолжение L1-L5 (set 390-394). Все 25 слов проверены grep'ом против
 * базы — нет пересечений ни с InternetL1-L5, ни с другими en-ru сетами:
 *   - Платформы (TikTok/Discord/Reddit/Twitch/Patreon) — отсутствуют в базе
 *   - Форматы (shorts/reels/stories/FYP/stitch) — свободны (story в L1, reel в Batch5
 *     — но множественное "reels" = Instagram-формат и "stories" = Instagram-формат
 *     — отдельные лексемы)
 *   - Стриминг (raid/emote/super chat/donation/subscriber) — свободны (livestream
 *     в L2, streamer в Batch18, но эти 5 — отдельные термины)
 *   - Creator economy (creator/creator economy/merch/ad-free/demonetization) —
 *     свободны (monetization в L3, monetize в WorkL5 — это разные формы)
 *   - Сообщества (subreddit/karma/AMA/shoutout/collab) — отсутствуют
 *
 * Распределение редкости: 17 UNCOMMON + 8 RARE — два смежных уровня (A2-B1 + B2).
 * Брендовые имена платформ — UNCOMMON (узнаваемы любым подростком в мире).
 * Бизнес-термины (creator economy, demonetization, influencer-related) — RARE.
 *
 * SemanticGroups (5 × 5):
 *   internet_l6_platforms     — TikTok, Discord, Reddit, Twitch, Patreon
 *   internet_l6_short_video   — shorts, reels, stories, FYP, stitch
 *   internet_l6_streaming     — raid, emote, super chat, donation, subscriber
 *   internet_l6_creator_econ  — creator, creator economy, merch, ad-free, demonetization
 *   internet_l6_community     — subreddit, karma, AMA, shoutout, collab
 *
 * Word IDs: setId × 100 + position (45401..45425).
 *
 * fillInBlankExclusions / isFillInBlankSafe — НЕ задаются здесь. Заполнятся через
 * FILL_IN_BLANK pipeline централизованно (известный баг: если выставить заранее,
 * pipeline пропустит запись).
 */
object WordDataEnglishInternetPlatforms {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 454,
            languagePair = "en-ru",
            orderIndex = 454,
            name = "Интернет и соцсети",
            description = "Платформы и форматы контента: TikTok, Discord, стримы",
            topic = "Интернет и соцсети",
            level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 454 — Интернет и соцсети: платформы и форматы (L2, UNCOMMON+RARE) ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── internet_l6_platforms (5) ─────────────────────────────────────

        WordEntity(id = 45401, setId = 454, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "TikTok", transliteration = "[ˈtɪkˌtɑk]", translation = "ТикТок (соцсеть коротких видео)",
            definition = "A huge mobile app where people share very short vertical videos with music.",
            definitionNative = "Огромное мобильное приложение, где люди публикуют очень короткие вертикальные видео с музыкой.",
            example = "Teenagers spend hours on TikTok every single evening after school.",
            exampleNative = "Подростки часами сидят в TikTok каждый вечер после школы.",
            pos = "noun", semanticGroup = "internet_l6_platforms", fillInBlankExclusions = listOf(45402L, 45403L, 45404L, 45405L)),

        WordEntity(id = 45402, setId = 454, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "Discord", transliteration = "[ˈdɪsˌkɔrd]", translation = "Дискорд (мессенджер для сообществ)",
            definition = "A chat app for gamers and communities with text rooms and voice rooms inside servers.",
            definitionNative = "Чат-приложение для геймеров и сообществ — с текстовыми и голосовыми комнатами внутри серверов.",
            example = "Our study group meets on Discord every Tuesday to share notes.",
            exampleNative = "Наша учебная группа собирается в Discord каждый вторник делиться конспектами.",
            pos = "noun", semanticGroup = "internet_l6_platforms", fillInBlankExclusions = listOf(45401L, 45403L, 45404L, 45405L)),

        WordEntity(id = 45403, setId = 454, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "Reddit", transliteration = "[ˈrɛdɪt]", translation = "Реддит (форум-агрегатор)",
            definition = "A site of thousands of small forums where users vote posts up or down.",
            definitionNative = "Сайт из тысяч маленьких форумов, где пользователи голосуют за посты — за или против.",
            example = "I always check Reddit for honest reviews before buying a phone.",
            exampleNative = "Я всегда проверяю Reddit на честные отзывы, прежде чем купить телефон.",
            pos = "noun", semanticGroup = "internet_l6_platforms", fillInBlankExclusions = listOf(45401L, 45402L, 45404L, 45405L)),

        WordEntity(id = 45404, setId = 454, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "Twitch", transliteration = "[twɪʧ]", translation = "Твич (платформа стримов)",
            definition = "The main website where people show their gaming live and viewers chat with them.",
            definitionNative = "Главный сайт, где люди в прямом эфире показывают свои игры, а зрители болтают с ними.",
            example = "She watches her favourite player on Twitch almost every weekend.",
            exampleNative = "Она смотрит любимого игрока на Twitch почти каждые выходные.",
            pos = "noun", semanticGroup = "internet_l6_platforms", fillInBlankExclusions = listOf(45401L, 45402L, 45403L, 45405L)),

        WordEntity(id = 45405, setId = 454, languagePair = "en-ru", rarity = "RARE",
            original = "Patreon", transliteration = "[ˈpeɪtriɑn]", translation = "Патреон (площадка платных подписок на авторов)",
            definition = "A platform where fans pay a small monthly fee to support a creator they love.",
            definitionNative = "Площадка, где фанаты платят небольшую ежемесячную сумму, чтобы поддержать любимого автора.",
            example = "The podcast survives only thanks to its loyal Patreon supporters.",
            exampleNative = "Подкаст выживает только благодаря верным сторонникам на Patreon.",
            pos = "noun", semanticGroup = "internet_l6_platforms", fillInBlankExclusions = listOf(45401L, 45402L, 45403L, 45404L)),

        // ── internet_l6_short_video (5) ───────────────────────────────────

        WordEntity(id = 45406, setId = 454, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "shorts", transliteration = "[ʃɔrts]", translation = "шортсы (короткие вертикальные видео на YouTube)",
            definition = "Very brief vertical clips on YouTube, usually under sixty seconds long.",
            definitionNative = "Очень краткие вертикальные ролики на YouTube, обычно длиной до шестидесяти секунд.",
            example = "He gets most of his new viewers from YouTube shorts these days.",
            exampleNative = "Большинство новых зрителей он получает с YouTube shorts в наши дни.",
            pos = "noun", semanticGroup = "internet_l6_short_video", fillInBlankExclusions = listOf(45407L, 45408L, 45409L, 45410L)),

        WordEntity(id = 45407, setId = 454, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "reels", transliteration = "[rilz]", translation = "рилсы (короткие видео в Instagram)",
            definition = "Short vertical videos on Instagram set to music, often dance or comedy.",
            definitionNative = "Короткие вертикальные видео в Instagram под музыку, часто с танцами или юмором.",
            example = "Her funny reels about office life got over a million views.",
            exampleNative = "Её смешные reels про офисную жизнь набрали больше миллиона просмотров.",
            pos = "noun", semanticGroup = "internet_l6_short_video", fillInBlankExclusions = listOf(45406L, 45408L, 45409L, 45410L)),

        WordEntity(id = 45408, setId = 454, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "stories", transliteration = "[ˈstɔriz]", translation = "сторис (короткие посты на 24 часа)",
            definition = "Short photo or video posts at the top of an app that vanish after a day.",
            definitionNative = "Короткие фото или видео-посты сверху приложения, которые исчезают через сутки.",
            example = "She watches everyone's stories first thing in the morning over coffee.",
            exampleNative = "Она смотрит чужие stories первым делом утром за чашкой кофе.",
            pos = "noun", semanticGroup = "internet_l6_short_video", fillInBlankExclusions = listOf(45406L, 45407L, 45409L, 45410L)),

        WordEntity(id = 45409, setId = 454, languagePair = "en-ru", rarity = "RARE",
            original = "FYP", transliteration = "[ˌɛf waɪ ˈpi]", translation = "рекомендованная лента TikTok",
            definition = "The personal landing screen on TikTok where the algorithm picks every single clip for you.",
            definitionNative = "Персональный начальный экран TikTok, где алгоритм подбирает каждый ролик лично под тебя.",
            example = "His silly cat video somehow ended up on everyone's FYP overnight.",
            exampleNative = "Его глупое видео с котом за ночь попало всем на FYP.",
            pos = "noun", semanticGroup = "internet_l6_short_video", fillInBlankExclusions = listOf(45406L, 45407L, 45408L, 45410L)),

        WordEntity(id = 45410, setId = 454, languagePair = "en-ru", rarity = "RARE",
            original = "stitch", transliteration = "[stɪʧ]", translation = "стич (вставка чужого видео в своё)",
            definition = "A TikTok feature that lets you splice a piece of someone else's video into yours.",
            definitionNative = "Функция TikTok, позволяющая вставить кусочек чужого видео в начало своего.",
            example = "She made a clever stitch reacting to a famous chef's bad recipe.",
            exampleNative = "Она сделала умный stitch с реакцией на плохой рецепт известного шеф-повара.",
            pos = "noun", semanticGroup = "internet_l6_short_video", fillInBlankExclusions = listOf(45406L, 45407L, 45408L, 45409L)),

        // ── internet_l6_streaming (5) ─────────────────────────────────────

        WordEntity(id = 45411, setId = 454, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "raid", transliteration = "[reɪd]", translation = "рейд (массовый переход зрителей на чужой стрим)",
            definition = "When a streamer ends and sends their entire audience over to another channel as a gift.",
            definitionNative = "Когда автор стрима заканчивает эфир и в подарок отправляет всю свою аудиторию на чужой канал.",
            example = "A friendly raid from a big streamer brought her two hundred new viewers.",
            exampleNative = "Дружеский raid от крупного стримера привёл ей двести новых зрителей.",
            pos = "noun", semanticGroup = "internet_l6_streaming", fillInBlankExclusions = listOf(45412L, 45413L, 45414L, 45415L)),

        WordEntity(id = 45412, setId = 454, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "emote", transliteration = "[ɪˈmoʊt]", translation = "эмоут (картинка-эмоция в стрим-чате)",
            definition = "A small custom picture in a stream chat that fans spam to react during a moment.",
            definitionNative = "Маленькая особая картинка в чате стрима — фанаты спамят ею в ответ на момент эфира.",
            example = "The chat exploded with the laughing emote after his terrible joke.",
            exampleNative = "Чат взорвался смеющимся emote после его ужасной шутки.",
            pos = "noun", semanticGroup = "internet_l6_streaming", fillInBlankExclusions = listOf(45411L, 45413L, 45414L, 45415L)),

        WordEntity(id = 45413, setId = 454, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "super chat", transliteration = "[ˈsupər ʧæt]", translation = "супер-чат (платное выделенное сообщение)",
            definition = "A paid bright message a viewer sends so the streamer surely sees and reads it aloud.",
            definitionNative = "Платное яркое сообщение от зрителя — чтобы автор точно заметил и прочитал его вслух.",
            example = "Her birthday super chat from a longtime fan brought her to tears.",
            exampleNative = "Её праздничный super chat от давнего фаната довёл её до слёз.",
            pos = "noun", semanticGroup = "internet_l6_streaming", fillInBlankExclusions = listOf(45411L, 45412L, 45414L, 45415L)),

        WordEntity(id = 45414, setId = 454, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "donation", transliteration = "[doʊˈneɪʃən]", translation = "донат (добровольный денежный подарок автору)",
            definition = "A free-will money gift a viewer sends to a creator during a stream or to a channel.",
            definitionNative = "Добровольный денежный подарок от зрителя автору — во время стрима или просто на канал.",
            example = "A surprise donation of fifty dollars helped pay for new microphones.",
            exampleNative = "Неожиданный donation в пятьдесят долларов помог оплатить новые микрофоны.",
            pos = "noun", semanticGroup = "internet_l6_streaming", fillInBlankExclusions = listOf(45411L, 45412L, 45413L, 45415L)),

        WordEntity(id = 45415, setId = 454, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "subscriber", transliteration = "[səbˈskraɪbər]", translation = "подписчик канала (часто платный)",
            definition = "Someone who has clicked the button to follow a channel and get every new video.",
            definitionNative = "Тот, кто нажал кнопку следить за каналом и получать каждое новое видео.",
            example = "She just hit one hundred thousand subscriber milestone last night.",
            exampleNative = "Вчера вечером она как раз преодолела отметку в сто тысяч subscriber.",
            pos = "noun", semanticGroup = "internet_l6_streaming", fillInBlankExclusions = listOf(45411L, 45412L, 45413L, 45414L, 45416L)),

        // ── internet_l6_creator_econ (5) ──────────────────────────────────

        WordEntity(id = 45416, setId = 454, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "creator", transliteration = "[kriˈeɪtər]", translation = "автор контента, создатель",
            definition = "Anyone who makes videos, photos or posts for an online audience as a job or hobby.",
            definitionNative = "Тот, кто делает видео, фото или посты для онлайн-аудитории — по работе или для души.",
            example = "Every full-time creator I know struggles with burnout at some point.",
            exampleNative = "Каждый известный мне профессиональный creator однажды сталкивается с выгоранием.",
            pos = "noun", semanticGroup = "internet_l6_creator_econ", fillInBlankExclusions = listOf(45415L, 45417L, 45418L, 45420L)),

        WordEntity(id = 45417, setId = 454, languagePair = "en-ru", rarity = "RARE",
            original = "creator economy", transliteration = "[kriˈeɪtər ɪˈkɑnəmi]", translation = "экономика авторов контента",
            definition = "The whole money system where individuals earn a living from posts, videos and online fans.",
            definitionNative = "Целая денежная система, где обычные люди зарабатывают на жизнь постами, видео и онлайн-фанатами.",
            example = "The creator economy now feeds millions of people in dozens of countries.",
            exampleNative = "Creator economy теперь кормит миллионы людей в десятках стран.",
            pos = "noun", semanticGroup = "internet_l6_creator_econ", fillInBlankExclusions = listOf(45416L, 45418L, 45420L)),

        WordEntity(id = 45418, setId = 454, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "merch", transliteration = "[mərʧ]", translation = "мерч (брендовая продукция автора)",
            definition = "Branded T-shirts, mugs and hoodies that fans buy to show love for a creator.",
            definitionNative = "Брендовые футболки, кружки и худи, которые фанаты покупают в знак любви к автору.",
            example = "Her new merch line of cosy hoodies sold out in four hours.",
            exampleNative = "Её новая линия уютных худи merch распродалась за четыре часа.",
            pos = "noun", semanticGroup = "internet_l6_creator_econ", fillInBlankExclusions = listOf(45416L, 45417L, 45420L)),

        WordEntity(id = 45419, setId = 454, languagePair = "en-ru", rarity = "RARE",
            original = "ad-free", transliteration = "[ˌæd ˈfri]", translation = "без рекламы (о платном тарифе)",
            definition = "Of a paid plan that lets you watch or read with no ads breaking the flow.",
            definitionNative = "О платном тарифе, где можно смотреть или читать без баннеров и роликов.",
            example = "I finally paid for the ad-free version of my favourite podcast app.",
            exampleNative = "Я наконец заплатил за ad-free версию любимого подкаст-приложения.",
            pos = "adjective", semanticGroup = "internet_l6_creator_econ"),

        WordEntity(id = 45420, setId = 454, languagePair = "en-ru", rarity = "RARE",
            original = "demonetization", transliteration = "[diˌmɑnətəˈzeɪʃən]", translation = "демонетизация (отключение рекламы на видео)",
            definition = "When a platform turns off ads on a video so the author earns nothing from it.",
            definitionNative = "Когда платформа отключает рекламу на видео, и автор перестаёт получать с него деньги.",
            example = "Strict demonetization of his news clips forced him to find sponsors instead.",
            exampleNative = "Жёсткая demonetization его новостных роликов заставила его искать спонсоров.",
            pos = "noun", semanticGroup = "internet_l6_creator_econ", fillInBlankExclusions = listOf(45416L, 45417L, 45418L)),

        // ── internet_l6_community (5) ─────────────────────────────────────

        WordEntity(id = 45421, setId = 454, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "subreddit", transliteration = "[ˈsʌbˌrɛdɪt]", translation = "сабреддит (тематический раздел Реддита)",
            definition = "One small forum on Reddit dedicated to a single topic, hobby or city.",
            definitionNative = "Один маленький форум на Reddit, посвящённый одной теме, хобби или городу.",
            example = "There's a friendly subreddit for almost any weird hobby you can think of.",
            exampleNative = "Есть дружелюбный subreddit почти под любое странное хобби, какое только придумаешь.",
            pos = "noun", semanticGroup = "internet_l6_community", fillInBlankExclusions = listOf(45422L, 45423L, 45424L, 45425L)),

        WordEntity(id = 45422, setId = 454, languagePair = "en-ru", rarity = "RARE",
            original = "karma", transliteration = "[ˈkɑrmə]", translation = "карма (репутация на Реддите)",
            definition = "A score on Reddit that goes up or down depending on how readers vote on your posts.",
            definitionNative = "Очки на Reddit — растут или падают от того, как читатели голосуют за твои посты.",
            example = "He gained loads of karma after a single funny comment hit the front page.",
            exampleNative = "Он набрал кучу karma после одного смешного комментария, попавшего на главную.",
            pos = "noun", semanticGroup = "internet_l6_community", fillInBlankExclusions = listOf(45415L, 45421L, 45423L, 45424L, 45425L)),

        WordEntity(id = 45423, setId = 454, languagePair = "en-ru", rarity = "RARE",
            original = "AMA", transliteration = "[ˌeɪ ɛm ˈeɪ]", translation = "AMA, сессия «спроси меня о чём угодно»",
            definition = "An online session where a known person answers any question readers throw at them.",
            definitionNative = "Онлайн-сессия, на которой известный человек отвечает на любой вопрос, что ему кидают читатели.",
            example = "The astronaut's AMA on the forum lasted nearly five whole hours.",
            exampleNative = "AMA космонавта на форуме длилась почти пять часов подряд.",
            pos = "noun", semanticGroup = "internet_l6_community", fillInBlankExclusions = listOf(45421L, 45422L, 45424L, 45425L)),

        WordEntity(id = 45424, setId = 454, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "shoutout", transliteration = "[ˈʃaʊtˌaʊt]", translation = "шаутаут (публичное упоминание-благодарность)",
            definition = "A friendly public mention of another person to send your fans their way.",
            definitionNative = "Доброжелательное публичное упоминание другого человека — чтобы направить к нему своих фанатов.",
            example = "She gave a warm shoutout to the small bakery that fed her crew.",
            exampleNative = "Она сделала тёплый shoutout маленькой пекарне, накормившей её команду.",
            pos = "noun", semanticGroup = "internet_l6_community", fillInBlankExclusions = listOf(45414L, 45421L, 45422L, 45423L, 45425L)),

        WordEntity(id = 45425, setId = 454, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "collab", transliteration = "[kəˈlæb]", translation = "колаб, совместный проект двух авторов",
            definition = "A joint video or post made by two creators together to share each other's audiences.",
            definitionNative = "Совместное видео или пост от двух авторов разом — чтобы поделиться аудиториями друг друга.",
            example = "Their cooking collab brought both channels a wave of fresh subscribers.",
            exampleNative = "Их кулинарный collab принёс обоим каналам волну свежих подписчиков.",
            pos = "noun", semanticGroup = "internet_l6_community", fillInBlankExclusions = listOf(45421L, 45422L, 45423L, 45424L)),
    )
}
