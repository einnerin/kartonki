package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Эмоции и чувства (level 5, носитель языка).
 *
 * Set 364: «Эмоции и чувства» — литературные, философские и экзистенциальные
 * термины для тонких оттенков чувств: непереводимые заимствования (Sehnsucht-
 * подобные слова), экзистенциальная лексика, литературные категории, философские
 * концепты возвышенного и трансцендентного, продвинутая клиническая психология
 * аффекта (C1-C2).
 *
 * Распределение редкости: 13 EPIC + 12 LEGENDARY — два смежных уровня шкалы.
 *
 * Дополняет уже существующие/параллельные сеты темы «Эмоции и чувства»:
 *   - Set 360 (параллельно) — L1 COMMON/UNCOMMON.
 *   - Set 361 (параллельно) — L2 UNCOMMON/RARE.
 *   - Set 362 (параллельно) — L3 RARE/EPIC (или UNCOMMON/RARE).
 *   - Set 363 (параллельно) — L4 RARE/EPIC.
 *
 * Слова setId=364 не пересекаются с темами «Психология» (set 28, 35, 36, 45, 52,
 * 53, 54, 64, 71, 81, 215, 334) и «Философия» (set 87, 258, 83, 78, 82, 341, 342)
 * — проверено grep по `original = "..."`. `liminal` (Философия L5 set 78) сознательно
 * исключён и заменён на `ineffable` (Лингвистика L5 — другая тема, дубль допустим).
 *
 * Cross-topic дубли (одно слово в разных темах допустимо по политике проекта):
 *   - schadenfreude, weltschmerz, ennui, malaise — set 329 «Повседневная жизнь» L5.
 *   - sublime, catharsis — set 359 «Развлечения» L5.
 *   - pathos, bathos, hubris, ennui — set 77/80 «Лингвистика»/«Культура» L5.
 *   - alienation — set 57 «Политика» L3.
 *   - dissociation — set 354 «Здоровье и фитнес» L4.
 *   - ineffable — set 76 «Лингвистика» L5.
 *
 * SemanticGroups (5 × 5):
 *   emotions_loanwords        — schadenfreude, weltschmerz, saudade, hygge, sonder
 *   emotions_existential      — angst, ennui, anomie, alienation, malaise
 *   emotions_literary         — sublime, pathos, bathos, catharsis, hubris
 *   emotions_philosophical    — uncanny, numinous, transcendence, ineffable, apophenia
 *   emotions_dark_advanced    — psychic numbing, derealization, dissociation, anhedonia, languishing
 *
 * Word IDs: 36401..36425 (setId × 100 + position).
 *
 * isFillInBlankSafe = false для всех слов: тема предельно абстрактна, многие
 * концепты — близкие синонимы экзистенциальной/эстетической тоски, любые соседи
 * по семантике легко встают в пропуск (saudade ↔ sehnsucht ↔ weltschmerz и т.д.).
 * Pipeline-exclusions не справится — слишком много пересечений.
 */
object WordDataEnglishEmotionsL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 364, languagePair = "en-ru", orderIndex = 364,
            name = "Эмоции и чувства",
            description = "Уровень носителя: литературные, философские, экзистенциальные термины",
            topic = "Эмоции и чувства", level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── emotions_loanwords (5) ────────────────────────────────────────

        WordEntity(id = 36401, setId = 364, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "schadenfreude", transliteration = "[ˈʃɑdənˌfrɔɪdə]",
            translation = "злорадство (тихая радость от чужой неудачи)",
            definition = "A quiet pleasure felt when someone you dislike runs into trouble.",
            definitionNative = "Тихое удовольствие от того, что у недруга всё пошло не так.",
            example = "He felt a flash of schadenfreude when his rival lost the race.",
            exampleNative = "Он ощутил вспышку schadenfreude, когда соперник проиграл забег.",
            pos = "noun", semanticGroup = "emotions_loanwords",
            isFillInBlankSafe = false),

        WordEntity(id = 36402, setId = 364, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "weltschmerz", transliteration = "[ˈvɛltʃmɛrts]",
            translation = "мировая скорбь (тоска по идеальному миру)",
            definition = "A deep sadness about how the real world falls short of one's ideals.",
            definitionNative = "Глубокая печаль от того, что мир далёк от того, каким мог бы быть.",
            example = "Romantic poets often wrote of a quiet weltschmerz behind their verses.",
            exampleNative = "Романтики часто прятали за стихами тихий weltschmerz о мире.",
            pos = "noun", semanticGroup = "emotions_loanwords",
            isFillInBlankSafe = false),

        WordEntity(id = 36403, setId = 364, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "saudade", transliteration = "[saʊˈdɑːdə]",
            translation = "сладкая грусть по утраченному (порт.)",
            definition = "A bittersweet longing for something or someone gone, perhaps forever.",
            definitionNative = "Горько-сладкая тоска по чему-то ушедшему — может быть, навсегда.",
            example = "Fado music carries a deep saudade for old Lisbon and lost love.",
            exampleNative = "В музыке фаду слышится глубокое saudade по старому Лиссабону.",
            pos = "noun", semanticGroup = "emotions_loanwords",
            isFillInBlankSafe = false),

        WordEntity(id = 36404, setId = 364, languagePair = "en-ru", rarity = "EPIC",
            original = "hygge", transliteration = "[ˈhuːɡə]",
            translation = "уют (датский — тёплое домашнее благополучие)",
            definition = "A cozy contentment from candles, warm drinks and quiet evenings indoors.",
            definitionNative = "Уютное довольство от свечей, тёплых напитков и тихих вечеров дома.",
            example = "On winter nights they wrap in blankets and chase a feeling of hygge.",
            exampleNative = "Зимними вечерами они кутаются в пледы и ловят hygge.",
            pos = "noun", semanticGroup = "emotions_loanwords",
            isFillInBlankSafe = false),

        WordEntity(id = 36405, setId = 364, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "sonder", transliteration = "[ˈsɒndər]",
            translation = "сондер (осознание чужой внутренней жизни)",
            definition = "The dizzy realization that every passer-by lives an inner life as full as yours.",
            definitionNative = "Головокружительное озарение: у каждого прохожего своя такая же жизнь.",
            example = "Crossing the busy square, she felt a wave of sonder for every stranger.",
            exampleNative = "Пересекая площадь, она ощутила волну sonder к каждому прохожему.",
            pos = "noun", semanticGroup = "emotions_loanwords",
            isFillInBlankSafe = false),

        // ── emotions_existential (5) ──────────────────────────────────────

        WordEntity(id = 36406, setId = 364, languagePair = "en-ru", rarity = "EPIC",
            original = "angst", transliteration = "[ɑːŋst]",
            translation = "экзистенциальная тревога",
            definition = "A deep dread about freedom, meaning and one's own choices in life.",
            definitionNative = "Глубокий страх перед свободой, смыслом и собственным выбором.",
            example = "Teenage angst poured out of every page of his early diary.",
            exampleNative = "Подростковая angst сочилась с каждой страницы его раннего дневника.",
            pos = "noun", semanticGroup = "emotions_existential",
            isFillInBlankSafe = false),

        WordEntity(id = 36407, setId = 364, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "ennui", transliteration = "[ɒnˈwiː]",
            translation = "томительная экзистенциальная скука",
            definition = "A heavy dullness of spirit when nothing in the world seems to interest you.",
            definitionNative = "Тяжёлое отупение духа, когда ничто в мире не цепляет интерес.",
            example = "By midsummer the long holidays had settled into a quiet ennui.",
            exampleNative = "К середине лета долгие каникулы осели тихим ennui.",
            pos = "noun", semanticGroup = "emotions_existential",
            isFillInBlankSafe = false),

        WordEntity(id = 36408, setId = 364, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "anomie", transliteration = "[ˈænəmi]",
            translation = "аномия (распад внутренних норм и ценностей)",
            definition = "A drift inside, when old rules and shared meanings stop guiding you.",
            definitionNative = "Внутренний дрейф, когда старые правила и общие смыслы больше не ведут.",
            example = "After the factory closed, a creeping anomie spread through the small town.",
            exampleNative = "После закрытия завода городок охватило ползучее anomie.",
            pos = "noun", semanticGroup = "emotions_existential",
            isFillInBlankSafe = false),

        WordEntity(id = 36409, setId = 364, languagePair = "en-ru", rarity = "EPIC",
            original = "alienation", transliteration = "[ˌeɪliəˈneɪʃən]",
            translation = "отчуждение (от себя, других, мира)",
            definition = "A cold sense of being a stranger to your own life and to people around you.",
            definitionNative = "Холодное чувство чужака — и в собственной жизни, и среди близких.",
            example = "Years of remote work brought a slow alienation he could not name.",
            exampleNative = "Годы удалёнки принесли медленное alienation, которое он не умел назвать.",
            pos = "noun", semanticGroup = "emotions_existential",
            isFillInBlankSafe = false),

        WordEntity(id = 36410, setId = 364, languagePair = "en-ru", rarity = "EPIC",
            original = "malaise", transliteration = "[məˈleɪz]",
            translation = "томное недомогание духа, хандра",
            definition = "A vague unease — body and mind out of tune, no clear cause.",
            definitionNative = "Смутное недомогание — тело и душа не в ладу, причины не назовёшь.",
            example = "A grey malaise hung over the office in the weeks before the layoffs.",
            exampleNative = "Серое malaise висело над офисом недели до сокращений.",
            pos = "noun", semanticGroup = "emotions_existential",
            isFillInBlankSafe = false),

        // ── emotions_literary (5) ─────────────────────────────────────────

        WordEntity(id = 36411, setId = 364, languagePair = "en-ru", rarity = "EPIC",
            original = "sublime", transliteration = "[səˈblaɪm]",
            translation = "возвышенное (эстетическая категория)",
            definition = "A breathtaking awe so vast it brushes against fear — storms, peaks, abysses.",
            definitionNative = "Захватывающий трепет такой силы, что граничит со страхом — буря, бездна.",
            example = "Standing at the cliff's edge, she tasted the sublime in every gust.",
            exampleNative = "У края обрыва она пробовала sublime в каждом порыве ветра.",
            pos = "noun", semanticGroup = "emotions_literary",
            isFillInBlankSafe = false),

        WordEntity(id = 36412, setId = 364, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "pathos", transliteration = "[ˈpeɪθɒs]",
            translation = "пафос (как трогательность, способность вызывать жалость)",
            definition = "That quality in art which tugs the heart and brings a tear of pity.",
            definitionNative = "Качество в искусстве, что трогает сердце и вызывает слёзы жалости.",
            example = "The film's final scene carried a pathos no review could quite capture.",
            exampleNative = "В финале фильма звучал такой pathos, что рецензии не могли его передать.",
            pos = "noun", semanticGroup = "emotions_literary",
            isFillInBlankSafe = false),

        WordEntity(id = 36413, setId = 364, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "bathos", transliteration = "[ˈbeɪθɒs]",
            translation = "батос (срыв пафоса в комичное или банальное)",
            definition = "An abrupt fall from lofty feeling to something silly — pity becomes laughter.",
            definitionNative = "Резкое падение от высокого чувства к нелепому — жалость сменяет смешок.",
            example = "A solemn eulogy slid into bathos when his phone began ringing loudly.",
            exampleNative = "Скорбная речь съехала в bathos, когда зазвонил его телефон.",
            pos = "noun", semanticGroup = "emotions_literary",
            isFillInBlankSafe = false),

        WordEntity(id = 36414, setId = 364, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "catharsis", transliteration = "[kəˈθɑːrsɪs]",
            translation = "катарсис (очищение через сильное переживание)",
            definition = "A cleansing release when bottled-up feeling pours out through art or tears.",
            definitionNative = "Очищающее высвобождение запертого чувства — через искусство или слёзы.",
            example = "Writing the long letter brought her a quiet catharsis at last.",
            exampleNative = "Длинное письмо наконец принесло ей тихий catharsis.",
            pos = "noun", semanticGroup = "emotions_literary",
            isFillInBlankSafe = false),

        WordEntity(id = 36415, setId = 364, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hubris", transliteration = "[ˈhjuːbrɪs]",
            translation = "гордыня (роковое самомнение героя трагедии)",
            definition = "A blinding pride that pushes a hero past wise limits — and toward downfall.",
            definitionNative = "Слепящая гордость, что толкает героя за разумные границы — к падению.",
            example = "His hubris drove him to ignore every warning from his closest advisors.",
            exampleNative = "Его hubris заставила его пропустить мимо ушей все предостережения.",
            pos = "noun", semanticGroup = "emotions_literary",
            isFillInBlankSafe = false),

        // ── emotions_philosophical (5) ────────────────────────────────────

        WordEntity(id = 36416, setId = 364, languagePair = "en-ru", rarity = "EPIC",
            original = "uncanny", transliteration = "[ʌnˈkæni]",
            translation = "жуткое (странное в знакомом — Фрейд)",
            definition = "A creepy strangeness inside the familiar — a doll's eyes, an empty street.",
            definitionNative = "Тревожная странность в знакомом — глаза куклы, пустая улица под фонарём.",
            example = "The deserted village had an uncanny stillness that froze every guest.",
            exampleNative = "В покинутой деревне стояла uncanny тишина, морозящая гостей.",
            pos = "adjective", semanticGroup = "emotions_philosophical",
            isFillInBlankSafe = false),

        WordEntity(id = 36417, setId = 364, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "numinous", transliteration = "[ˈnuːmɪnəs]",
            translation = "нуминозное (трепет перед сакральным)",
            definition = "A trembling awe before what feels divine — vast, holy, beyond words.",
            definitionNative = "Дрожащий трепет перед тем, что кажется божественным, — безбрежным, святым.",
            example = "Ancient cathedrals can stir a numinous hush even in the secular visitor.",
            exampleNative = "Древние соборы будят numinous тишину даже у светского гостя.",
            pos = "adjective", semanticGroup = "emotions_philosophical",
            isFillInBlankSafe = false),

        WordEntity(id = 36418, setId = 364, languagePair = "en-ru", rarity = "EPIC",
            original = "transcendence", transliteration = "[trænˈsɛndəns]",
            translation = "трансценденция (выход за пределы обыденного)",
            definition = "A reaching beyond everyday limits — into the spiritual, the boundless, the eternal.",
            definitionNative = "Выход за пределы обыденного — в духовное, безграничное, вечное.",
            example = "Long meditation can bring a quiet transcendence the words cannot hold.",
            exampleNative = "Долгая медитация способна дать тихое transcendence, что не вмещают слова.",
            pos = "noun", semanticGroup = "emotions_philosophical",
            isFillInBlankSafe = false),

        WordEntity(id = 36419, setId = 364, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "ineffable", transliteration = "[ɪnˈɛfəbəl]",
            translation = "неизрекаемое, несказанное",
            definition = "Too vast or holy or strange to fit in any words a tongue can shape.",
            definitionNative = "Слишком огромное, святое или странное, чтобы вместиться в любые слова.",
            example = "She stared at the dawn and felt an ineffable peace settle inside her.",
            exampleNative = "Она глядела на рассвет, и ineffable покой оседал внутри.",
            pos = "adjective", semanticGroup = "emotions_philosophical",
            isFillInBlankSafe = false),

        WordEntity(id = 36420, setId = 364, languagePair = "en-ru", rarity = "EPIC",
            original = "apophenia", transliteration = "[ˌæpəˈfiːniə]",
            translation = "апофения (ложное чувство значимых связей)",
            definition = "A spooky pull to find meaning in random patterns — faces in clouds, signs in chance.",
            definitionNative = "Жутковатая тяга видеть смысл в случайностях — лица в облаках, знаки судьбы.",
            example = "Late-night reading of conspiracies fed his apophenia until every coincidence glowed.",
            exampleNative = "Чтение конспирологии ночами питало его apophenia до свечения каждого совпадения.",
            pos = "noun", semanticGroup = "emotions_philosophical",
            isFillInBlankSafe = false),

        // ── emotions_dark_advanced (5) ────────────────────────────────────

        WordEntity(id = 36421, setId = 364, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "psychic numbing", transliteration = "[ˈsaɪkɪk ˈnʌmɪŋ]",
            translation = "психическое онемение (защитное замораживание чувств)",
            definition = "A deadening of feeling when too much horror comes too fast to face.",
            definitionNative = "Замирание чувств, когда слишком много ужаса валится за раз — не вынести.",
            example = "Aid workers describe a psychic numbing after their fifth war zone in a row.",
            exampleNative = "Гуманитарщики описывают psychic numbing после пятой подряд горячей точки.",
            pos = "noun", semanticGroup = "emotions_dark_advanced",
            isFillInBlankSafe = false),

        WordEntity(id = 36422, setId = 364, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "derealization", transliteration = "[diːˌriːəlaɪˈzeɪʃən]",
            translation = "дереализация (мир кажется ненастоящим)",
            definition = "A strange sense the world has gone fake — like a film set or a dream.",
            definitionNative = "Странное чувство, что мир стал ненастоящим — будто декорация или сон.",
            example = "After the accident she had bouts of derealization for nearly three months.",
            exampleNative = "После аварии у неё были приступы derealization почти три месяца.",
            pos = "noun", semanticGroup = "emotions_dark_advanced",
            isFillInBlankSafe = false),

        WordEntity(id = 36423, setId = 364, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "dissociation", transliteration = "[dɪˌsoʊsiˈeɪʃən]",
            translation = "диссоциация (отрыв от себя и тела)",
            definition = "A floaty distance from your own body and feelings, as if watching from outside.",
            definitionNative = "Парящее отстранение от собственного тела и чувств — будто наблюдаешь со стороны.",
            example = "The therapist explained that dissociation often follows severe early trauma.",
            exampleNative = "Терапевт объяснил, что dissociation часто следует за ранней тяжёлой травмой.",
            pos = "noun", semanticGroup = "emotions_dark_advanced",
            isFillInBlankSafe = false),

        WordEntity(id = 36424, setId = 364, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "anhedonia", transliteration = "[ˌænhiːˈdoʊniə]",
            translation = "ангедония (утрата способности радоваться)",
            definition = "A grey inability to enjoy anything — food, music, friends all flatten out.",
            definitionNative = "Серая неспособность ничему радоваться — еда, музыка, друзья тускнеют.",
            example = "Deep depression often brings an anhedonia that loved hobbies cannot break.",
            exampleNative = "Тяжёлая депрессия часто приносит anhedonia, что не лечится прежним хобби.",
            pos = "noun", semanticGroup = "emotions_dark_advanced",
            isFillInBlankSafe = false),

        WordEntity(id = 36425, setId = 364, languagePair = "en-ru", rarity = "EPIC",
            original = "languishing", transliteration = "[ˈlæŋɡwɪʃɪŋ]",
            translation = "томление (между унынием и расцветом — Адам Грант)",
            definition = "A flat in-between state — not depressed, not thriving, just running on empty.",
            definitionNative = "Плоское серединное состояние — не в депрессии, не цветёшь, просто пусто.",
            example = "Through the long pandemic many described a chronic languishing rather than grief.",
            exampleNative = "За долгую пандемию многие описывали хроническое languishing, не горе.",
            pos = "noun", semanticGroup = "emotions_dark_advanced",
            isFillInBlankSafe = false),
    )
}
