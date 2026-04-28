package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Интернет и соцсети (L3, RARE+EPIC).
 *
 * Set 392: «Интернет и соцсети» — углублённый.
 *          Алгоритмы платформ, инфраструктура хостинга, сетевые феномены и
 *          бизнес-метрики B2-C1. Лексика обзоров, пресс-релизов и
 *          специализированных статей о работе соцсетей и веба.
 *
 * Тема — продолжение L1 (set 390) и L2 (set 391, создаётся параллельно).
 * L1 покрывает базовые действия (webpage, scroll, swipe, follow, login),
 * L2 — повседневные понятия B1 уровня. L3 строго придерживается B2/C1.
 *
 * Все 25 слов этого сета не пересекаются с уже существующими английскими
 * словами в базе (проверено grep'ом по `original = "..."`). Обойдены, в
 * частности: bandwidth, latency, throughput, encryption, packet, server,
 * cache, protocol, firewall, malware, phishing, metadata, algorithm,
 * cookie (это set 209/235/247/39/72), а также viral, influencer, clickbait,
 * disinformation, paywall, subscription, broadcast, audience (set 51),
 * conversion, retention (Shopping), shadowban, upvote, impressions, reach,
 * curate, engagement (Batch5), trending, notification (set 209) — все они
 * уже есть в других наборах.
 *
 * Распределение редкости: 18 RARE + 7 EPIC — два смежных уровня (B2 + C1).
 *
 * SemanticGroups (5 × 5):
 *   internet_l3_infrastructure — hosting, throttling, indexing, uptime, outage
 *   internet_l3_algorithms     — recommendation, filter bubble, echo chamber, curation, deplatforming
 *   internet_l3_culture        — doxxing, gatekeeping, lurker, memetic, brigading
 *   internet_l3_business       — monetization, click-through, churn, engagement rate, funnel
 *   internet_l3_phenomena      — cyberbullying, catfishing, trolling, ghosting, gaslighting
 *
 * Word IDs: setId × 100 + position (39201..39225).
 *
 * fillInBlankExclusions / isFillInBlankSafe — не выставлены здесь (defaults в
 * WordEntity). FILL_IN_BLANK pipeline инжектит их централизованно после wave;
 * если поставить их заранее, pipeline пропустит запись (известный баг).
 */
object WordDataEnglishInternetL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 392,
            languagePair = "en-ru",
            orderIndex = 392,
            name = "Интернет и соцсети",
            description = "Алгоритмы, инфраструктура и интернет-феномены",
            topic = "Интернет и соцсети",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 392 — Интернет и соцсети: углублённый (L3, RARE+EPIC)        ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── internet_l3_infrastructure (5) ────────────────────────────────

        WordEntity(id = 39201, setId = 392, languagePair = "en-ru", rarity = "RARE",
            original = "hosting", transliteration = "[ˈhoʊstɪŋ]", translation = "хостинг",
            definition = "The paid service of keeping a website's files on a computer that's always online.",
            definitionNative = "Платная услуга — хранить файлы сайта на постоянно включённом компьютере.",
            example = "Their cheap hosting kept crashing whenever traffic spiked.",
            exampleNative = "Их дешёвый hosting падал каждый раз при наплыве трафика.",
            pos = "noun", semanticGroup = "internet_l3_infrastructure", fillInBlankExclusions = listOf(39202L, 39203L, 39204L, 39205L)),

        WordEntity(id = 39202, setId = 392, languagePair = "en-ru", rarity = "RARE",
            original = "throttling", transliteration = "[ˈθrɑtəlɪŋ]", translation = "ограничение скорости",
            definition = "When a provider slows your connection on purpose after you reach a limit.",
            definitionNative = "Когда провайдер нарочно режет скорость, как только ты упёрся в лимит.",
            example = "Heavy users complained about throttling after the first ten gigabytes.",
            exampleNative = "Активные пользователи жаловались на throttling после первых десяти гигабайт.",
            pos = "noun", semanticGroup = "internet_l3_infrastructure", fillInBlankExclusions = listOf(39201L, 39203L, 39204L, 39205L)),

        WordEntity(id = 39203, setId = 392, languagePair = "en-ru", rarity = "RARE",
            original = "indexing", transliteration = "[ˈɪnˌdɛksɪŋ]", translation = "индексация",
            definition = "The process by which a search engine reads a page and adds it to its catalogue.",
            definitionNative = "Процесс, при котором поисковик читает страницу и заносит её в свой каталог.",
            example = "Google's indexing of the new blog took about three days.",
            exampleNative = "indexing нового блога в Google заняло около трёх дней.",
            pos = "noun", semanticGroup = "internet_l3_infrastructure", fillInBlankExclusions = listOf(39201L, 39202L, 39204L, 39205L, 39206L, 39209L, 39216L)),

        WordEntity(id = 39204, setId = 392, languagePair = "en-ru", rarity = "RARE",
            original = "uptime", transliteration = "[ˈəpˌtaɪm]", translation = "время бесперебойной работы",
            definition = "The share of time a service stays online and responds to users without breaking.",
            definitionNative = "Доля времени, когда сервис остаётся в сети и отвечает пользователям без сбоев.",
            example = "The company guarantees ninety-nine percent uptime to its clients.",
            exampleNative = "Компания гарантирует клиентам uptime не ниже девяноста девяти процентов.",
            pos = "noun", semanticGroup = "internet_l3_infrastructure", fillInBlankExclusions = listOf(39201L, 39202L, 39203L, 39205L)),

        WordEntity(id = 39205, setId = 392, languagePair = "en-ru", rarity = "EPIC",
            original = "outage", transliteration = "[ˈaʊtəʤ]", translation = "сбой / отключение сервиса",
            definition = "A period when a service stops working for everyone — like the whole site going dark.",
            definitionNative = "Период, когда сервис не работает для всех — будто весь сайт целиком погас.",
            example = "A four-hour outage cost the platform millions in lost ad revenue.",
            exampleNative = "Четырёхчасовой outage стоил платформе миллионов в потерянной рекламной выручке.",
            pos = "noun", semanticGroup = "internet_l3_infrastructure", fillInBlankExclusions = listOf(39201L, 39202L, 39203L, 39204L)),

        // ── internet_l3_algorithms (5) ────────────────────────────────────

        WordEntity(id = 39206, setId = 392, languagePair = "en-ru", rarity = "RARE",
            original = "recommendation", transliteration = "[ˌrɛkəmənˈdeɪʃən]", translation = "рекомендация (алгоритма)",
            definition = "A post or video the platform's program picks for you based on what you've watched before.",
            definitionNative = "Пост или ролик, который программа сайта подбирает по тому, что ты уже смотрел.",
            example = "Most of her viewing now comes from the platform's recommendation engine.",
            exampleNative = "Большая часть её просмотров теперь идёт из recommendation платформы.",
            pos = "noun", semanticGroup = "internet_l3_algorithms", fillInBlankExclusions = listOf(39203L, 39207L, 39208L, 39209L, 39210L)),

        WordEntity(id = 39207, setId = 392, languagePair = "en-ru", rarity = "RARE",
            original = "filter bubble", transliteration = "[ˈfɪltər ˈbəbəl]", translation = "пузырь фильтров",
            definition = "A narrow stream of content the algorithm shows you because it matches your past clicks.",
            definitionNative = "Узкий поток контента, который алгоритм показывает тебе, потому что он совпадает с твоими прошлыми кликами.",
            example = "He realised he was trapped in a filter bubble of one-sided news.",
            exampleNative = "Он понял, что застрял в filter bubble однобоких новостей.",
            pos = "noun", semanticGroup = "internet_l3_algorithms", fillInBlankExclusions = listOf(39206L, 39209L, 39210L)),

        WordEntity(id = 39208, setId = 392, languagePair = "en-ru", rarity = "RARE",
            original = "echo chamber", transliteration = "[ˈɛkoʊ ˈʧeɪmbər]", translation = "эхо-камера",
            definition = "An online space where the same opinion bounces back and forth without any real challenge.",
            definitionNative = "Сетевое пространство, где одно и то же мнение отскакивает туда-сюда, и никто его не оспаривает.",
            example = "Their group chat had become an echo chamber of agreement.",
            exampleNative = "Их групповой чат превратился в echo chamber всеобщего согласия.",
            pos = "noun", semanticGroup = "internet_l3_algorithms"),

        WordEntity(id = 39209, setId = 392, languagePair = "en-ru", rarity = "RARE",
            original = "curation", transliteration = "[kjʊˈreɪʃən]", translation = "кураторский отбор",
            definition = "Careful picking and ordering of posts or items so the best ones rise to the top.",
            definitionNative = "Тщательный отбор и сортировка постов или вещей, чтобы лучшие оказались наверху.",
            example = "Editorial curation still beats raw algorithms for niche topics.",
            exampleNative = "Редакторская curation всё ещё бьёт чистые алгоритмы в узких темах.",
            pos = "noun", semanticGroup = "internet_l3_algorithms", fillInBlankExclusions = listOf(39206L, 39207L, 39208L, 39210L, 39212L)),

        WordEntity(id = 39210, setId = 392, languagePair = "en-ru", rarity = "EPIC",
            original = "deplatforming", transliteration = "[diˈplætˌfɔrmɪŋ]", translation = "лишение платформы",
            definition = "Banning a person from a major service so they can no longer reach their audience there.",
            definitionNative = "Запрет человеку пользоваться крупным сервисом, чтобы он больше не мог обращаться там к своей аудитории.",
            example = "The deplatforming of the radio host sparked a fierce free-speech debate.",
            exampleNative = "deplatforming радиоведущего разожгло яростный спор о свободе слова.",
            pos = "noun", semanticGroup = "internet_l3_algorithms", fillInBlankExclusions = listOf(39206L, 39207L, 39208L, 39209L, 39211L, 39215L, 39221L, 39223L, 39225L)),

        // ── internet_l3_culture (5) ───────────────────────────────────────

        WordEntity(id = 39211, setId = 392, languagePair = "en-ru", rarity = "RARE",
            original = "doxxing", transliteration = "[ˈdɑksɪŋ]", translation = "доксинг (слив личных данных)",
            definition = "Publishing someone's private information online so a crowd can find and harass them.",
            definitionNative = "Публикация чьих-то личных данных в сети, чтобы толпа могла найти и травить человека.",
            example = "After the doxxing she had to change her phone and move apartments.",
            exampleNative = "После doxxing ей пришлось сменить телефон и переехать.",
            pos = "noun", semanticGroup = "internet_l3_culture", fillInBlankExclusions = listOf(39212L, 39213L, 39215L, 39221L, 39223L, 39225L)),

        WordEntity(id = 39212, setId = 392, languagePair = "en-ru", rarity = "RARE",
            original = "gatekeeping", transliteration = "[ˈɡeɪtˌkipɪŋ]", translation = "гейткипинг (контроль доступа в сообщество)",
            definition = "Acting as if only \"real\" fans deserve to enter a hobby and judging newcomers harshly.",
            definitionNative = "Поведение, при котором решают, что в хобби достойны входить только «настоящие» фанаты, и строго оценивают новичков.",
            example = "The forum's gatekeeping drove away every beginner who asked a basic question.",
            exampleNative = "gatekeeping на форуме отпугивал каждого новичка, задавшего простой вопрос.",
            pos = "noun", semanticGroup = "internet_l3_culture", fillInBlankExclusions = listOf(39208L, 39209L, 39210L, 39211L, 39213L, 39215L, 39216L, 39221L, 39222L, 39223L, 39225L)),

        WordEntity(id = 39213, setId = 392, languagePair = "en-ru", rarity = "RARE",
            original = "lurker", transliteration = "[ˈlərkər]", translation = "наблюдатель (читает, но не пишет)",
            definition = "Someone who reads a forum or chat for a long time but never writes anything themselves.",
            definitionNative = "Человек, который долго читает форум или чат, но сам так ничего и не пишет.",
            example = "Most communities have ten readers for every poster — the rest are a silent lurker crowd.",
            exampleNative = "В большинстве сообществ на одного писателя приходится десять читателей — остальные молчаливая lurker толпа.",
            pos = "noun", semanticGroup = "internet_l3_culture", fillInBlankExclusions = listOf(39211L, 39212L, 39215L)),

        WordEntity(id = 39214, setId = 392, languagePair = "en-ru", rarity = "EPIC",
            original = "memetic", transliteration = "[mɪˈmɛtɪk]", translation = "мемный, относящийся к мемам",
            definition = "Spreading from person to person on the internet the way a catchy idea or joke does.",
            definitionNative = "Расходящийся от человека к человеку в интернете так, как разлетается яркая идея или шутка.",
            example = "The dancing pickle achieved truly memetic fame within a week.",
            exampleNative = "Танцующий огурец за неделю достиг подлинно memetic славы.",
            pos = "adjective", semanticGroup = "internet_l3_culture"),

        WordEntity(id = 39215, setId = 392, languagePair = "en-ru", rarity = "EPIC",
            original = "brigading", transliteration = "[brɪˈɡeɪdɪŋ]", translation = "бригадирование (скоординированная атака)",
            definition = "An organised pile-on where many users from one community swarm a target post or person.",
            definitionNative = "Организованная атака, при которой много участников одного сообщества разом наваливаются на пост или человека-мишень.",
            example = "The mods locked the thread to stop further brigading from outside subreddits.",
            exampleNative = "Модераторы закрыли тему, чтобы остановить brigading из других сабреддитов.",
            pos = "noun", semanticGroup = "internet_l3_culture", fillInBlankExclusions = listOf(39211L, 39212L, 39213L, 39221L, 39223L, 39225L)),

        // ── internet_l3_business (5) ──────────────────────────────────────

        WordEntity(id = 39216, setId = 392, languagePair = "en-ru", rarity = "RARE",
            original = "monetization", transliteration = "[ˌmɑnətəˈzeɪʃən]", translation = "монетизация",
            definition = "The process of turning a free audience or product into a steady source of money.",
            definitionNative = "Процесс превращения бесплатной аудитории или продукта в стабильный источник денег.",
            example = "Channel monetization usually starts after one thousand subscribers.",
            exampleNative = "monetization канала обычно стартует после тысячи подписчиков.",
            pos = "noun", semanticGroup = "internet_l3_business", fillInBlankExclusions = listOf(39217L, 39218L, 39219L, 39220L)),

        WordEntity(id = 39217, setId = 392, languagePair = "en-ru", rarity = "RARE",
            original = "bounce rate", transliteration = "[baʊns reɪt]", translation = "показатель отказов",
            definition = "The share of visitors who leave a website after viewing only a single page.",
            definitionNative = "Доля посетителей, которые уходят с сайта, посмотрев лишь одну страницу.",
            example = "A slow loading screen pushed the bounce rate above seventy percent.",
            exampleNative = "Медленная загрузка подняла bounce rate выше семидесяти процентов.",
            pos = "noun", semanticGroup = "internet_l3_business", fillInBlankExclusions = listOf(39216L, 39218L, 39219L, 39220L)),

        WordEntity(id = 39218, setId = 392, languagePair = "en-ru", rarity = "RARE",
            original = "churn", transliteration = "[ʧərn]", translation = "отток клиентов",
            definition = "The rate at which paying users cancel a service over a given month or year.",
            definitionNative = "Скорость, с которой платящие пользователи отказываются от сервиса за месяц или год.",
            example = "High monthly churn is a warning sign for any subscription app.",
            exampleNative = "Высокий месячный churn — тревожный знак для любого подписочного приложения.",
            pos = "noun", semanticGroup = "internet_l3_business", fillInBlankExclusions = listOf(39216L, 39217L, 39219L, 39220L)),

        WordEntity(id = 39219, setId = 392, languagePair = "en-ru", rarity = "RARE",
            original = "engagement rate", transliteration = "[ɛnˈɡeɪʤmənt reɪt]", translation = "уровень вовлечённости",
            definition = "The share of viewers who actively like, share or comment on a post — not just see it.",
            definitionNative = "Доля зрителей, которые активно лайкают, репостят или комментируют пост, а не просто его видят.",
            example = "Her short videos have an engagement rate three times the platform average.",
            exampleNative = "У её коротких видео engagement rate втрое выше среднего по платформе.",
            pos = "noun", semanticGroup = "internet_l3_business"),

        WordEntity(id = 39220, setId = 392, languagePair = "en-ru", rarity = "EPIC",
            original = "funnel", transliteration = "[ˈfənəl]", translation = "воронка продаж",
            definition = "The step-by-step path that turns a curious visitor into a paying customer over time.",
            definitionNative = "Пошаговый путь, который со временем превращает любопытного посетителя в платящего клиента.",
            example = "Their checkout funnel still loses half the buyers at the payment screen.",
            exampleNative = "Их funnel оформления всё ещё теряет половину покупателей на экране оплаты.",
            pos = "noun", semanticGroup = "internet_l3_business", fillInBlankExclusions = listOf(39216L, 39217L, 39218L, 39219L)),

        // ── internet_l3_phenomena (5) ─────────────────────────────────────

        WordEntity(id = 39221, setId = 392, languagePair = "en-ru", rarity = "RARE",
            original = "cyberbullying", transliteration = "[ˈsaɪbərˌbʊliɪŋ]", translation = "кибербуллинг",
            definition = "Cruel teasing or threats sent through messages, posts and comments instead of in person.",
            definitionNative = "Жестокие насмешки или угрозы, посылаемые в сообщениях, постах и комментариях, а не в лицо.",
            example = "The school added a hotline for victims of cyberbullying last term.",
            exampleNative = "Школа в прошлом семестре открыла горячую линию для жертв cyberbullying.",
            pos = "noun", semanticGroup = "internet_l3_phenomena", fillInBlankExclusions = listOf(39211L, 39215L, 39222L, 39223L, 39224L, 39225L)),

        WordEntity(id = 39222, setId = 392, languagePair = "en-ru", rarity = "RARE",
            original = "flame war", transliteration = "[fleɪm wɔr]", translation = "флейм, словесная перепалка",
            definition = "A long, angry online argument where users keep insulting each other instead of discussing.",
            definitionNative = "Долгая злая перепалка в сети, где участники бесконечно оскорбляют друг друга вместо обсуждения.",
            example = "An innocent question about pineapple pizza sparked a week-long flame war.",
            exampleNative = "Невинный вопрос про пиццу с ананасом разжёг недельный flame war.",
            pos = "noun", semanticGroup = "internet_l3_phenomena", fillInBlankExclusions = listOf(39210L, 39215L, 39221L, 39223L, 39224L, 39225L)),

        WordEntity(id = 39223, setId = 392, languagePair = "en-ru", rarity = "RARE",
            original = "trolling", transliteration = "[ˈtroʊlɪŋ]", translation = "троллинг",
            definition = "Posting nasty or silly comments on purpose to make other people angry online.",
            definitionNative = "Намеренное написание гадких или нелепых комментариев в сети, чтобы разозлить других.",
            example = "His constant trolling got him banned from three forums in one month.",
            exampleNative = "Его постоянный trolling привёл к бану на трёх форумах за один месяц.",
            pos = "noun", semanticGroup = "internet_l3_phenomena", fillInBlankExclusions = listOf(39211L, 39212L, 39215L, 39221L, 39222L, 39224L, 39225L)),

        WordEntity(id = 39224, setId = 392, languagePair = "en-ru", rarity = "EPIC",
            original = "ghosting", transliteration = "[ˈɡoʊstɪŋ]", translation = "гостинг (резкое исчезновение из переписки)",
            definition = "Suddenly stopping all replies in a chat without ever explaining why.",
            definitionNative = "Внезапное прекращение всех ответов в чате, без всяких объяснений — почему.",
            example = "After two great dates, his ghosting really hurt her feelings.",
            exampleNative = "После двух чудесных свиданий его ghosting её сильно обидел.",
            pos = "noun", semanticGroup = "internet_l3_phenomena", fillInBlankExclusions = listOf(39212L, 39221L, 39222L, 39223L, 39225L)),

        WordEntity(id = 39225, setId = 392, languagePair = "en-ru", rarity = "EPIC",
            original = "pile-on", transliteration = "[ˈpaɪl ɑn]", translation = "массовая травля одной мишени",
            definition = "A wave of hostile replies aimed at one person all at once after a single bad post.",
            definitionNative = "Волна враждебных ответов, обрушивающаяся разом на одного человека после одного неудачного поста.",
            example = "Her clumsy joke triggered an immediate pile-on from thousands of strangers.",
            exampleNative = "Её неуклюжая шутка вызвала немедленный pile-on от тысяч незнакомцев.",
            pos = "noun", semanticGroup = "internet_l3_phenomena", fillInBlankExclusions = listOf(39221L, 39222L, 39223L, 39224L)),
    )
}
