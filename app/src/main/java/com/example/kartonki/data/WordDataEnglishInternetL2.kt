package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Интернет и соцсети (L2, UNCOMMON+RARE).
 *
 * Set 391: «Интернет и соцсети» — продвинутый уровень.
 *          Engagement-метрики, продвинутый контент-формат, кибербезопасность,
 *          инфлюенсер-маркетинг и модерация сообществ уровня A2-B2
 *          (UNCOMMON+RARE). Не пересекается с L1 (set 390) и со старыми
 *          наборами по теме «Интернет/соцсети» (Batch5 «social_media_*»,
 *          set 209 «Internet/Социальные сети», set 247 «Cybersecurity»,
 *          set 51 «Media business»).
 *
 * Распределение редкости: 18 UNCOMMON + 7 RARE — два смежных уровня (A2-B1 + B2).
 *
 * SemanticGroups (5 × 5):
 *   internet_l2_engagement   — retweet, mention, pinned, click-through, virality
 *   internet_l2_content_pro  — livestream, admin, geotag, deepfake, growth hack
 *   internet_l2_security     — antivirus, two-factor, biometric, scam, catfish
 *   internet_l2_marketing    — sponsor, ad-block, sponsorship, opt-out, tip jar
 *   internet_l2_community    — moderator, harassment, hoax, takedown, gaslighting
 *
 * Word IDs: setId × 100 + position (39101..39125).
 *
 * fillInBlankExclusions / isFillInBlankSafe не задаются — заполнятся через
 * FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataEnglishInternetL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 391,
            languagePair = "en-ru",
            orderIndex = 391,
            name = "Интернет и соцсети",
            description = "Engagement, безопасность, маркетинг и сообщества",
            topic = "Интернет и соцсети",
            level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 391 — Интернет и соцсети: продвинутый (L2, UNCOMMON+RARE)    ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── internet_l2_engagement (5) ────────────────────────────────────

        WordEntity(id = 39101, setId = 391, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "retweet", transliteration = "[riˈtwit]", translation = "ретвит, репост в Твиттере",
            definition = "A copy of someone else's tweet that you share again on your own page.",
            definitionNative = "Копия чужого твита, которой ты делишься повторно у себя на странице.",
            example = "Her funny retweet of the cat video reached thousands of users.",
            exampleNative = "Её смешной retweet с видео кота дошёл до тысяч пользователей.",
            pos = "noun", semanticGroup = "internet_l2_engagement", fillInBlankExclusions = listOf(39102L, 39104L, 39105L, 39106L, 39109L, 39124L)),

        WordEntity(id = 39102, setId = 391, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "mention", transliteration = "[ˈmɛnʃən]", translation = "упоминание (с @)",
            definition = "A short note about a user with the @ sign so they get a ping.",
            definitionNative = "Короткое упоминание пользователя со знаком @, чтобы ему пришло оповещение.",
            example = "He got a friendly mention from a famous chef on the platform.",
            exampleNative = "Он получил дружеский mention от известного шеф-повара на платформе.",
            pos = "noun", semanticGroup = "internet_l2_engagement", fillInBlankExclusions = listOf(39101L, 39104L, 39105L, 39106L, 39110L, 39118L, 39123L, 39124L)),

        WordEntity(id = 39103, setId = 391, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "pinned", transliteration = "[pɪnd]", translation = "закреплённый (пост)",
            definition = "Stuck to the very top of a profile or chat so it always shows first.",
            definitionNative = "Прикреплённый к самому верху профиля или чата, чтобы был виден первым.",
            example = "Her pinned post explains all the rules of the community.",
            exampleNative = "Её pinned пост объясняет все правила сообщества.",
            pos = "adjective", semanticGroup = "internet_l2_engagement"),

        WordEntity(id = 39104, setId = 391, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "click-through", transliteration = "[ˈklɪkˌθru]", translation = "переход по клику",
            definition = "A single tap on a link that sends a person from one page to another.",
            definitionNative = "Одно нажатие на ссылку — оно ведёт человека с одной страницы на другую.",
            example = "Each click-through on the banner earns the blogger a small fee.",
            exampleNative = "Каждый click-through по баннеру приносит блогеру маленькую плату.",
            pos = "noun", semanticGroup = "internet_l2_engagement", fillInBlankExclusions = listOf(39101L, 39102L, 39105L, 39114L, 39116L, 39119L)),

        WordEntity(id = 39105, setId = 391, languagePair = "en-ru", rarity = "RARE",
            original = "virality", transliteration = "[vaɪˈræləti]", translation = "вирусность (контента)",
            definition = "The power of a post to spread very fast from person to person online.",
            definitionNative = "Способность поста очень быстро расходиться от человека к человеку в сети.",
            example = "The clip's virality surprised even the team that filmed it.",
            exampleNative = "Virality этого клипа удивила даже снявшую его команду.",
            pos = "noun", semanticGroup = "internet_l2_engagement", fillInBlankExclusions = listOf(39101L, 39102L, 39104L, 39108L, 39116L, 39118L, 39124L)),

        // ── internet_l2_content_pro (5) ───────────────────────────────────

        WordEntity(id = 39106, setId = 391, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "livestream", transliteration = "[ˈlaɪvˌstrim]", translation = "прямая трансляция",
            definition = "A video shown on the internet exactly as it is happening, with no delay.",
            definitionNative = "Видео в интернете, которое показывают ровно тогда, когда оно идёт, без задержки.",
            example = "Fans tuned in to her cooking livestream from all over the world.",
            exampleNative = "Фанаты включали её кулинарный livestream со всего мира.",
            pos = "noun", semanticGroup = "internet_l2_content_pro", fillInBlankExclusions = listOf(39107L, 39108L, 39109L, 39110L)),

        WordEntity(id = 39107, setId = 391, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "admin", transliteration = "[ˈædmɪn]", translation = "админ (группы, чата)",
            definition = "The person who runs an online group and decides who joins or leaves.",
            definitionNative = "Человек, управляющий онлайн-группой и решающий, кого впускать или выгонять.",
            example = "Only the admin of the chat can change the group photo.",
            exampleNative = "Только admin чата может поменять фото группы.",
            pos = "noun", semanticGroup = "internet_l2_content_pro", fillInBlankExclusions = listOf(39106L, 39108L, 39109L, 39110L, 39116L, 39121L)),

        WordEntity(id = 39108, setId = 391, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "geotag", transliteration = "[ˈʤioʊˌtæɡ]", translation = "геометка",
            definition = "A small location label added to a post that shows where the photo was taken.",
            definitionNative = "Маленькая отметка на посте, показывающая, в каком месте сделано фото.",
            example = "She added a geotag of the beach to her sunset photo.",
            exampleNative = "Она добавила geotag пляжа к своему фото заката.",
            pos = "noun", semanticGroup = "internet_l2_content_pro", fillInBlankExclusions = listOf(39102L, 39106L, 39109L, 39110L)),

        WordEntity(id = 39109, setId = 391, languagePair = "en-ru", rarity = "RARE",
            original = "deepfake", transliteration = "[ˈdipˌfeɪk]", translation = "дипфейк (поддельное видео)",
            definition = "A fake video where a computer puts one person's face onto another body.",
            definitionNative = "Поддельное видео, где компьютер ставит лицо одного человека на тело другого.",
            example = "The deepfake of the president fooled many viewers for a few hours.",
            exampleNative = "Deepfake с президентом обманул многих зрителей на несколько часов.",
            pos = "noun", semanticGroup = "internet_l2_content_pro", fillInBlankExclusions = listOf(39101L, 39106L, 39107L, 39108L, 39110L, 39114L, 39123L)),

        WordEntity(id = 39110, setId = 391, languagePair = "en-ru", rarity = "RARE",
            original = "growth hack", transliteration = "[ɡroʊθ hæk]", translation = "хитрый приём для роста аудитории",
            definition = "A clever trick that helps a small page get many new followers fast.",
            definitionNative = "Хитрый приём, который помогает маленькой странице быстро получить много подписчиков.",
            example = "Posting at six in the morning was her best growth hack last year.",
            exampleNative = "Посты в шесть утра стали её лучшим growth hack в прошлом году.",
            pos = "noun", semanticGroup = "internet_l2_content_pro", fillInBlankExclusions = listOf(39106L, 39107L, 39108L, 39109L)),

        // ── internet_l2_security (5) ──────────────────────────────────────

        WordEntity(id = 39111, setId = 391, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "antivirus", transliteration = "[ˌæntiˈvaɪrəs]", translation = "антивирус",
            definition = "A program that watches your computer and removes harmful files it finds.",
            definitionNative = "Программа, которая следит за компьютером и удаляет вредные файлы.",
            example = "A good antivirus stopped the strange email from opening on my laptop.",
            exampleNative = "Хороший antivirus не дал странному письму открыться на моём ноутбуке.",
            pos = "noun", semanticGroup = "internet_l2_security", fillInBlankExclusions = listOf(39114L, 39115L, 39117L, 39119L)),

        WordEntity(id = 39112, setId = 391, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "two-factor", transliteration = "[ˈtuˌfæktər]", translation = "двухфакторный (вход)",
            definition = "Using two separate steps — a password and a code — to enter an account.",
            definitionNative = "Вход в аккаунт по двум отдельным шагам — паролю и коду из СМС или приложения.",
            example = "I switched on two-factor login on every important account this week.",
            exampleNative = "На этой неделе я включил two-factor вход во все важные аккаунты.",
            pos = "adjective", semanticGroup = "internet_l2_security", fillInBlankExclusions = listOf(39113L)),

        WordEntity(id = 39113, setId = 391, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "biometric", transliteration = "[ˌbaɪoʊˈmɛtrɪk]", translation = "биометрический (вход)",
            definition = "Working by reading a part of your body, like a finger or face, to log in.",
            definitionNative = "Работающий по части тела — например, по пальцу или лицу — для входа.",
            example = "The bank app uses a biometric scan instead of an old password.",
            exampleNative = "Банковское приложение использует biometric скан вместо старого пароля.",
            pos = "adjective", semanticGroup = "internet_l2_security", fillInBlankExclusions = listOf(39112L)),

        WordEntity(id = 39114, setId = 391, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "scam", transliteration = "[skæm]", translation = "мошенническая схема",
            definition = "A clever lie online that tricks a person into giving money or data.",
            definitionNative = "Хитрая ложь в сети — заставляет человека отдать деньги или личные данные.",
            example = "That free-prize message was a clear scam from the very first line.",
            exampleNative = "То сообщение про бесплатный приз было явный scam с первой строки.",
            pos = "noun", semanticGroup = "internet_l2_security", fillInBlankExclusions = listOf(39102L, 39109L, 39111L, 39115L, 39123L, 39125L)),

        WordEntity(id = 39115, setId = 391, languagePair = "en-ru", rarity = "RARE",
            original = "catfish", transliteration = "[ˈkætˌfɪʃ]", translation = "катфишинг (фейковый профиль)",
            definition = "A person online who pretends to be someone completely different in photos and name.",
            definitionNative = "Человек в сети, который выдаёт себя за совсем другую персону на фото и по имени.",
            example = "She found out her online date was a catfish from another country.",
            exampleNative = "Она узнала, что её онлайн-знакомый — catfish из другой страны.",
            pos = "noun", semanticGroup = "internet_l2_security", fillInBlankExclusions = listOf(39109L, 39114L, 39123L)),

        // ── internet_l2_marketing (5) ─────────────────────────────────────

        WordEntity(id = 39116, setId = 391, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "sponsor", transliteration = "[ˈspɑnsər]", translation = "спонсор (поста, канала)",
            definition = "A company that pays a creator to mention its product in a post or video.",
            definitionNative = "Компания, которая платит автору за упоминание её товара в посте или видео.",
            example = "The video has a new sponsor — a small coffee brand from Italy.",
            exampleNative = "У этого видео новый sponsor — маленькая кофейная марка из Италии.",
            pos = "noun", semanticGroup = "internet_l2_marketing", fillInBlankExclusions = listOf(39102L, 39117L, 39118L, 39119L, 39120L)),

        WordEntity(id = 39117, setId = 391, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "ad-block", transliteration = "[ˈædˌblɑk]", translation = "блокировщик рекламы",
            definition = "A small program that hides ads from web pages while you read.",
            definitionNative = "Маленькая программа, которая прячет рекламу со страниц, пока ты читаешь.",
            example = "I installed an ad-block to make news sites load faster.",
            exampleNative = "Я установил ad-block, чтобы новостные сайты грузились быстрее.",
            pos = "noun", semanticGroup = "internet_l2_marketing", fillInBlankExclusions = listOf(39111L, 39119L)),

        WordEntity(id = 39118, setId = 391, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "sponsorship", transliteration = "[ˈspɑnsərˌʃɪp]", translation = "спонсорский контракт",
            definition = "A deal in which a brand pays a creator to promote it for some time.",
            definitionNative = "Договор, по которому бренд платит автору за рекламу в течение какого-то срока.",
            example = "Her first big sponsorship was with a sportswear company.",
            exampleNative = "Её первый крупный sponsorship был со спортивной фирмой.",
            pos = "noun", semanticGroup = "internet_l2_marketing", fillInBlankExclusions = listOf(39102L, 39106L, 39114L, 39116L, 39117L, 39119L, 39120L)),

        WordEntity(id = 39119, setId = 391, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "opt-out", transliteration = "[ɑpt aʊt]", translation = "отказ от подписки/рассылки",
            definition = "A button or link that lets you stop getting emails or ads from a service.",
            definitionNative = "Кнопка или ссылка, которая отключает письма или рекламу от сервиса.",
            example = "There's a clear opt-out at the bottom of every newsletter.",
            exampleNative = "Внизу каждой рассылки есть понятный opt-out.",
            pos = "noun", semanticGroup = "internet_l2_marketing", fillInBlankExclusions = listOf(39102L, 39104L, 39116L, 39117L, 39118L, 39120L)),

        WordEntity(id = 39120, setId = 391, languagePair = "en-ru", rarity = "RARE",
            original = "tip jar", transliteration = "[tɪp ʤɑr]", translation = "виртуальный «кувшин для чаевых»",
            definition = "A button on a creator's page where fans can send a small money gift.",
            definitionNative = "Кнопка на странице автора, через которую фанаты отправляют маленький денежный подарок.",
            example = "Her streaming page has a tip jar for fans who enjoyed the show.",
            exampleNative = "На её странице со стримами есть tip jar для довольных зрителей.",
            pos = "noun", semanticGroup = "internet_l2_marketing", fillInBlankExclusions = listOf(39102L, 39104L, 39106L, 39116L, 39118L)),

        // ── internet_l2_community (5) ─────────────────────────────────────

        WordEntity(id = 39121, setId = 391, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "moderator", transliteration = "[ˈmɑdəˌreɪtər]", translation = "модератор",
            definition = "A person who watches a chat or forum and removes posts that break the rules.",
            definitionNative = "Человек, который следит за чатом или форумом и удаляет посты против правил.",
            example = "A friendly moderator warned the user about rude language.",
            exampleNative = "Доброжелательный moderator предупредил пользователя о грубых словах.",
            pos = "noun", semanticGroup = "internet_l2_community", fillInBlankExclusions = listOf(39107L, 39116L, 39122L, 39123L, 39124L, 39125L)),

        WordEntity(id = 39122, setId = 391, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "harassment", transliteration = "[həˈræsmənt]", translation = "травля, домогательства",
            definition = "Repeated mean messages or actions that make a person feel unsafe online.",
            definitionNative = "Повторяющиеся злые сообщения или действия, от которых человеку страшно в сети.",
            example = "The platform has a strict rule against harassment in private chats.",
            exampleNative = "У платформы строгое правило против harassment в личных чатах.",
            pos = "noun", semanticGroup = "internet_l2_community", fillInBlankExclusions = listOf(39121L, 39123L, 39124L, 39125L)),

        WordEntity(id = 39123, setId = 391, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "hoax", transliteration = "[hoʊks]", translation = "фейк, розыгрыш-обманка",
            definition = "A made-up story shared online to fool many people for fun or harm.",
            definitionNative = "Выдуманная история, которой делятся в сети, чтобы обмануть много людей.",
            example = "The shark-in-the-pool photo turned out to be an old hoax.",
            exampleNative = "Фото акулы в бассейне оказалось старым hoax.",
            pos = "noun", semanticGroup = "internet_l2_community", fillInBlankExclusions = listOf(39101L, 39102L, 39106L, 39109L, 39114L, 39121L, 39122L, 39124L, 39125L)),

        WordEntity(id = 39124, setId = 391, languagePair = "en-ru", rarity = "RARE",
            original = "takedown", transliteration = "[ˈteɪkˌdaʊn]", translation = "удаление контента (по жалобе)",
            definition = "An order from a site to remove a video or post because it broke a rule.",
            definitionNative = "Распоряжение сайта удалить видео или пост из-за нарушения правил.",
            example = "The studio sent a takedown to every site that hosted the leaked clip.",
            exampleNative = "Студия отправила takedown на каждый сайт со слитым клипом.",
            pos = "noun", semanticGroup = "internet_l2_community", fillInBlankExclusions = listOf(39121L, 39122L, 39123L, 39125L)),

        WordEntity(id = 39125, setId = 391, languagePair = "en-ru", rarity = "RARE",
            original = "gaslighting", transliteration = "[ˈɡæsˌlaɪtɪŋ]", translation = "газлайтинг (отрицание реальности)",
            definition = "Slowly making a person doubt their own memory by twisting the truth online.",
            definitionNative = "Медленно заставлять человека сомневаться в своей памяти, искажая правду в сети.",
            example = "Her friends warned her that the constant gaslighting in the chat was harmful.",
            exampleNative = "Друзья предупредили её, что постоянный gaslighting в чате — это вредно.",
            pos = "noun", semanticGroup = "internet_l2_community", fillInBlankExclusions = listOf(39121L, 39122L, 39123L, 39124L)),
    )
}
