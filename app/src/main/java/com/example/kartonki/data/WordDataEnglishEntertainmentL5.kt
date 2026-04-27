package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Развлечения и досуг (level 5, носитель языка).
 *
 * Set 359: «Развлечения и досуг» — носитель языка (L5, EPIC+LEGENDARY):
 *          теория экранных искусств, кинокритика, философия искусства,
 *          экономика индустрии, продвинутые жанры.
 *
 * Слова не пересекаются с L1/L2/L3 (351-353): другая лексика, нет однокоренных.
 * Дубли с темой «Культура и искусство» (auteur 24521, diegetic 24524, leitmotif 8016,
 * aesthetic 6008, blockbuster 20622, anthology 22401, critic 2317), темой «Наука»
 * (peer review 7417), темой «Лингвистика» (catharsis 7708) — допустимы как
 * межтематические совпадения; в данном сете используются как многословные термины
 * («auteur theory», «blockbuster economics», «peer review», «anthology series»),
 * либо как самостоятельные термины индустрии.
 *
 * Распределение редкости: 13 EPIC + 12 LEGENDARY (2 смежных уровня).
 *
 * SemanticGroups (5 × 5):
 *   entertainment_theory          — auteur theory, mise-en-scène, diegetic sound,
 *                                   fourth wall, leitmotif
 *   entertainment_criticism       — film critic, peer review, longform essay,
 *                                   retrospective analysis, semiotic reading
 *   entertainment_philosophy      — aesthetic experience, suspension of disbelief,
 *                                   catharsis, sublime, gesamtkunstwerk
 *   entertainment_industry_econ   — box office return, residual payment,
 *                                   ancillary revenue, syndication deal,
 *                                   blockbuster economics
 *   entertainment_advanced_genre  — magical realism, surrealism, slipstream,
 *                                   anthology series, dieselpunk
 *
 * Все 25 слов помечены isFillInBlankSafe=false: это специализированные многословные
 * термины из теории/индустрии, для которых FILL_IN_BLANK выдаёт generic-контекст
 * (любой из соседей по semanticGroup правдоподобен). Квиз использует TRANSLATION/
 * DEFINITION-форматы, где близкие дистракторы по делу.
 *
 * Word IDs: setId × 100 + position (35901..35925).
 */
object WordDataEnglishEntertainmentL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 359, languagePair = "en-ru", orderIndex = 359,
            name = "Развлечения и досуг",
            description = "Уровень носителя: theory, criticism, philosophy of art, industry economics",
            topic = "Развлечения и досуг", level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 359 — Развлечения и досуг: носитель языка (L5, EPIC+LEG)     ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── entertainment_theory (5) ──────────────────────────────────────

        WordEntity(
            id = 35901, setId = 359, languagePair = "en-ru", rarity = "EPIC",
            original = "auteur theory", transliteration = "[oʊˈtɜːr ˈθɪri]",
            translation = "теория авторского кино",
            definition = "The view that a director shapes a film like a writer shapes a book.",
            definitionNative = "Взгляд, по которому режиссёр формирует фильм, как писатель — книгу.",
            example = "Cahiers critics built auteur theory around Hitchcock and Hawks.",
            exampleNative = "Критики Cahiers выстроили auteur theory вокруг Хичкока и Хоукса.",
            pos = "noun", semanticGroup = "entertainment_theory",
            isFillInBlankSafe = false,
        ),

        WordEntity(
            id = 35902, setId = 359, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "mise-en-scène", transliteration = "[ˌmiːzɒ̃ˈsɛn]",
            translation = "мизансцена (всё в кадре)",
            definition = "Everything visible in a single shot — set, light, costume and blocking.",
            definitionNative = "Всё, что видно в одном кадре, — декорации, свет, костюмы и расстановка.",
            example = "Welles packed every mise-en-scène with deep focus and dramatic shadows.",
            exampleNative = "Уэллс наполнял каждую mise-en-scène глубокой резкостью и тенями.",
            pos = "noun", semanticGroup = "entertainment_theory",
            isFillInBlankSafe = false,
        ),

        WordEntity(
            id = 35903, setId = 359, languagePair = "en-ru", rarity = "EPIC",
            original = "diegetic sound", transliteration = "[ˌdaɪəˈʤɛtɪk saʊnd]",
            translation = "внутрикадровый звук",
            definition = "Audio whose source belongs to the world the characters live inside.",
            definitionNative = "Звук, источник которого принадлежит миру, где живут герои.",
            example = "A radio playing in the kitchen counts as diegetic sound on screen.",
            exampleNative = "Радио на кухне считается diegetic sound внутри сцены.",
            pos = "noun", semanticGroup = "entertainment_theory",
            isFillInBlankSafe = false,
        ),

        WordEntity(
            id = 35904, setId = 359, languagePair = "en-ru", rarity = "EPIC",
            original = "fourth wall", transliteration = "[fɔːrθ wɔːl]",
            translation = "четвёртая стена (барьер с залом)",
            definition = "An imagined screen that keeps actors from talking to the audience.",
            definitionNative = "Воображаемая преграда, мешающая актёрам обращаться к залу напрямую.",
            example = "Deadpool breaks the fourth wall and winks straight at the camera.",
            exampleNative = "Дэдпул ломает fourth wall и подмигивает прямо в камеру.",
            pos = "noun", semanticGroup = "entertainment_theory",
            isFillInBlankSafe = false,
        ),

        WordEntity(
            id = 35905, setId = 359, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "leitmotif", transliteration = "[ˈlaɪtmoʊˌtiːf]",
            translation = "лейтмотив (повторяющаяся тема)",
            definition = "A short musical phrase tied to a character or idea that returns often.",
            definitionNative = "Короткая музыкальная фраза, связанная с героем или идеей и часто звучащая.",
            example = "Vader's heavy leitmotif warns the audience before he even appears.",
            exampleNative = "Тяжёлый leitmotif Вейдера предупреждает зрителя до его появления.",
            pos = "noun", semanticGroup = "entertainment_theory",
            isFillInBlankSafe = false,
        ),

        // ── entertainment_criticism (5) ───────────────────────────────────

        WordEntity(
            id = 35906, setId = 359, languagePair = "en-ru", rarity = "EPIC",
            original = "film critic", transliteration = "[fɪlm ˈkrɪtɪk]",
            translation = "кинокритик (профессиональный обозреватель)",
            definition = "A writer who studies movies for a living and weighs in on their merit.",
            definitionNative = "Автор, чья работа — разбирать фильмы и оценивать их достоинства.",
            example = "Each film critic on the panel ranked the year's top ten differently.",
            exampleNative = "Каждый film critic в жюри расставил топ года по-своему.",
            pos = "noun", semanticGroup = "entertainment_criticism",
            isFillInBlankSafe = false,
        ),

        WordEntity(
            id = 35907, setId = 359, languagePair = "en-ru", rarity = "EPIC",
            original = "peer review", transliteration = "[pɪr rɪˈvjuː]",
            translation = "коллегиальная рецензия (между критиками)",
            definition = "When experts of equal rank judge each other's work before it goes out.",
            definitionNative = "Когда специалисты равного ранга оценивают работы друг друга до выхода.",
            example = "The festival jury runs a quiet peer review on every selected entry.",
            exampleNative = "Жюри фестиваля проводит тихий peer review каждой отобранной работы.",
            pos = "noun", semanticGroup = "entertainment_criticism",
            isFillInBlankSafe = false,
        ),

        WordEntity(
            id = 35908, setId = 359, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "longform essay", transliteration = "[ˈlɒŋfɔːrm ˈɛseɪ]",
            translation = "большая аналитическая статья (10k+ слов)",
            definition = "An in-depth piece of writing that explores a topic far beyond a quick take.",
            definitionNative = "Глубокий текст, исследующий тему гораздо подробнее короткой заметки.",
            example = "Her longform essay on Lynch ran twelve thousand words across two issues.",
            exampleNative = "Её longform essay о Линче занял двенадцать тысяч слов в двух номерах.",
            pos = "noun", semanticGroup = "entertainment_criticism",
            isFillInBlankSafe = false,
        ),

        WordEntity(
            id = 35909, setId = 359, languagePair = "en-ru", rarity = "EPIC",
            original = "retrospective analysis", transliteration = "[ˌrɛtrəˈspɛktɪv əˈnæləsɪs]",
            translation = "ретроспективный разбор (взгляд назад)",
            definition = "A look back at an artist's full body of work to find patterns and growth.",
            definitionNative = "Взгляд назад на всё творчество автора ради поиска закономерностей и роста.",
            example = "The journal ran a retrospective analysis of Kubrick on his anniversary.",
            exampleNative = "Журнал опубликовал retrospective analysis Кубрика к его юбилею.",
            pos = "noun", semanticGroup = "entertainment_criticism",
            isFillInBlankSafe = false,
        ),

        WordEntity(
            id = 35910, setId = 359, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "semiotic reading", transliteration = "[ˌsɛmiˈɒtɪk ˈriːdɪŋ]",
            translation = "семиотический разбор (анализ знаков и кодов)",
            definition = "An interpretation that decodes the visual and verbal signs in a work.",
            definitionNative = "Толкование, в котором расшифровываются визуальные и словесные знаки произведения.",
            example = "Her semiotic reading of the poster unpacked every colour and gesture.",
            exampleNative = "Её semiotic reading постера разобрало каждый цвет и жест.",
            pos = "noun", semanticGroup = "entertainment_criticism",
            isFillInBlankSafe = false,
        ),

        // ── entertainment_philosophy (5) ──────────────────────────────────

        WordEntity(
            id = 35911, setId = 359, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "aesthetic experience", transliteration = "[ɛsˈθɛtɪk ɪkˈspɪriəns]",
            translation = "эстетическое переживание",
            definition = "A deep state in which beauty or form holds you fully in the moment.",
            definitionNative = "Глубокое состояние, в котором красота или форма захватывает целиком.",
            example = "A great opera offers an aesthetic experience hard to find elsewhere.",
            exampleNative = "Большая опера дарит aesthetic experience, редкую где-либо ещё.",
            pos = "noun", semanticGroup = "entertainment_philosophy",
            isFillInBlankSafe = false,
        ),

        WordEntity(
            id = 35912, setId = 359, languagePair = "en-ru", rarity = "EPIC",
            original = "suspension of disbelief", transliteration = "[səˈspɛnʃən əv dɪsbɪˈliːf]",
            translation = "отказ от недоверия (готовность поверить вымыслу)",
            definition = "A reader's quiet deal to accept impossible events for the sake of a story.",
            definitionNative = "Тихая сделка читателя — принять невозможное ради хода истории.",
            example = "Good fantasy earns your suspension of disbelief in the first chapter.",
            exampleNative = "Хорошее фэнтези заслуживает suspension of disbelief в первой главе.",
            pos = "noun", semanticGroup = "entertainment_philosophy",
            isFillInBlankSafe = false,
        ),

        WordEntity(
            id = 35913, setId = 359, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "catharsis", transliteration = "[kəˈθɑːrsɪs]",
            translation = "катарсис (очищение через сильное переживание)",
            definition = "A cleansing release of strong feeling brought on by tragedy on stage.",
            definitionNative = "Очищающее высвобождение сильных чувств, вызванное трагедией на сцене.",
            example = "Greek tragedy aimed at catharsis through pity and fear in the audience.",
            exampleNative = "Греческая трагедия стремилась к catharsis через жалость и страх.",
            pos = "noun", semanticGroup = "entertainment_philosophy",
            isFillInBlankSafe = false,
        ),

        WordEntity(
            id = 35914, setId = 359, languagePair = "en-ru", rarity = "EPIC",
            original = "sublime", transliteration = "[səˈblaɪm]",
            translation = "возвышенное (категория эстетики)",
            definition = "A feeling of awe so vast it borders on fear — Romantic philosophers' ideal.",
            definitionNative = "Чувство трепета такой силы, что граничит со страхом, — идеал романтиков.",
            example = "Caspar Friedrich's misty cliffs aim at the sublime, not at pretty views.",
            exampleNative = "Туманные скалы Фридриха целят в sublime, а не в красивый пейзаж.",
            pos = "noun", semanticGroup = "entertainment_philosophy",
            isFillInBlankSafe = false,
        ),

        WordEntity(
            id = 35915, setId = 359, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "gesamtkunstwerk", transliteration = "[ɡəˈzɑmtˌkʊnstvɛrk]",
            translation = "гезамткунстверк (тотальное произведение искусства)",
            definition = "A grand work that fuses music, drama and visuals into a single whole.",
            definitionNative = "Грандиозное произведение, сплавляющее музыку, драму и визуал в единое целое.",
            example = "Wagner dreamed of a gesamtkunstwerk where every art served the same vision.",
            exampleNative = "Вагнер мечтал о gesamtkunstwerk, где все искусства служат одному замыслу.",
            pos = "noun", semanticGroup = "entertainment_philosophy",
            isFillInBlankSafe = false,
        ),

        // ── entertainment_industry_econ (5) ───────────────────────────────

        WordEntity(
            id = 35916, setId = 359, languagePair = "en-ru", rarity = "EPIC",
            original = "box office return", transliteration = "[bɒks ˈɒfɪs rɪˈtɜːrn]",
            translation = "кассовые сборы (доход в прокате)",
            definition = "The total cash a movie pulls in from ticket sales around the globe.",
            definitionNative = "Общая сумма, которую фильм собирает с продажи билетов по миру.",
            example = "The studio's quiet drama posted a surprising box office return abroad.",
            exampleNative = "Тихая драма студии показала неожиданный box office return за рубежом.",
            pos = "noun", semanticGroup = "entertainment_industry_econ",
            isFillInBlankSafe = false,
        ),

        WordEntity(
            id = 35917, setId = 359, languagePair = "en-ru", rarity = "EPIC",
            original = "residual payment", transliteration = "[rɪˈzɪdjuəl ˈpeɪmənt]",
            translation = "роялти за повторный показ",
            definition = "Money paid to actors each time their old work airs or streams again.",
            definitionNative = "Деньги, выплачиваемые актёрам каждый раз, когда их работа идёт повторно.",
            example = "Veteran actors live for years on residual payment from a hit sitcom.",
            exampleNative = "Ветераны годами живут на residual payment от хитового ситкома.",
            pos = "noun", semanticGroup = "entertainment_industry_econ",
            isFillInBlankSafe = false,
        ),

        WordEntity(
            id = 35918, setId = 359, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "ancillary revenue", transliteration = "[ænˈsɪləri ˈrɛvənjuː]",
            translation = "побочный доход (мерч, лицензии, тематические парки)",
            definition = "Extra cash from products and rights tied to a hit beyond ticket sales.",
            definitionNative = "Дополнительный доход от товаров и прав, связанных с хитом, помимо проката.",
            example = "Toys and theme parks deliver more ancillary revenue than the films themselves.",
            exampleNative = "Игрушки и парки приносят больше ancillary revenue, чем сами фильмы.",
            pos = "noun", semanticGroup = "entertainment_industry_econ",
            isFillInBlankSafe = false,
        ),

        WordEntity(
            id = 35919, setId = 359, languagePair = "en-ru", rarity = "EPIC",
            original = "syndication deal", transliteration = "[ˌsɪndɪˈkeɪʃən diːl]",
            translation = "сделка на синдикацию (продажа в эфирные сети)",
            definition = "A contract that lets local stations rerun a finished show for years.",
            definitionNative = "Контракт, позволяющий местным каналам годами повторять готовый сериал.",
            example = "Friends earned a fortune from its long syndication deal in the nineties.",
            exampleNative = "«Друзья» заработали состояние на долгом syndication deal в девяностые.",
            pos = "noun", semanticGroup = "entertainment_industry_econ",
            isFillInBlankSafe = false,
        ),

        WordEntity(
            id = 35920, setId = 359, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "blockbuster economics", transliteration = "[ˈblɒkbʌstər ˌiːkəˈnɒmɪks]",
            translation = "экономика блокбастеров (бизнес-модель крупных хитов)",
            definition = "A business model where one giant hit pays for a slate of weaker titles.",
            definitionNative = "Бизнес-модель, в которой один большой хит окупает целую линейку слабых.",
            example = "Marvel's blockbuster economics rests on huge worldwide opening weekends.",
            exampleNative = "Blockbuster economics Marvel держится на огромных мировых стартах.",
            pos = "noun", semanticGroup = "entertainment_industry_econ",
            isFillInBlankSafe = false,
        ),

        // ── entertainment_advanced_genre (5) ──────────────────────────────

        WordEntity(
            id = 35921, setId = 359, languagePair = "en-ru", rarity = "EPIC",
            original = "magical realism", transliteration = "[ˈmæʤɪkəl ˈriəlɪzəm]",
            translation = "магический реализм",
            definition = "A style where strange or wondrous events appear inside an ordinary world.",
            definitionNative = "Стиль, в котором странные чудеса возникают в обыденном мире как норма.",
            example = "García Márquez built whole novels on calm, lyrical magical realism.",
            exampleNative = "Гарсиа Маркес выстраивал целые романы на спокойном magical realism.",
            pos = "noun", semanticGroup = "entertainment_advanced_genre",
            isFillInBlankSafe = false,
        ),

        WordEntity(
            id = 35922, setId = 359, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "surrealism", transliteration = "[səˈrɪəlɪzəm]",
            translation = "сюрреализм (эстетика снов и подсознания)",
            definition = "A movement that draws on dreams and the unconscious to break logic.",
            definitionNative = "Движение, черпающее из снов и бессознательного, чтобы ломать логику.",
            example = "Buñuel's films pushed surrealism deeper into mainstream cinema.",
            exampleNative = "Фильмы Бунюэля продвинули surrealism глубже в массовый кинематограф.",
            pos = "noun", semanticGroup = "entertainment_advanced_genre",
            isFillInBlankSafe = false,
        ),

        WordEntity(
            id = 35923, setId = 359, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "slipstream", transliteration = "[ˈslɪpstriːm]",
            translation = "слипстрим (жанр на стыке фантастики и мейнстрима)",
            definition = "A genre that blurs the line between literary fiction and the strange.",
            definitionNative = "Жанр, размывающий границу между литературой мейнстрима и странным.",
            example = "Murakami's quiet novels read like slipstream more than pure fantasy.",
            exampleNative = "Тихие романы Мураками читаются скорее как slipstream, чем фэнтези.",
            pos = "noun", semanticGroup = "entertainment_advanced_genre",
            isFillInBlankSafe = false,
        ),

        WordEntity(
            id = 35924, setId = 359, languagePair = "en-ru", rarity = "EPIC",
            original = "anthology series", transliteration = "[ænˈθɒləʤi ˈsɪriːz]",
            translation = "сериал-антология (новый сюжет каждый сезон)",
            definition = "A show whose seasons tell separate stories with new casts each time.",
            definitionNative = "Сериал, в котором сезоны рассказывают отдельные истории с новым составом.",
            example = "True Detective made the anthology series fashionable on cable again.",
            exampleNative = "«Настоящий детектив» вернул моду на anthology series на кабельном.",
            pos = "noun", semanticGroup = "entertainment_advanced_genre",
            isFillInBlankSafe = false,
        ),

        WordEntity(
            id = 35925, setId = 359, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "dieselpunk", transliteration = "[ˈdiːzəlpʌŋk]",
            translation = "дизельпанк (эстетика 1920–50-х с альтернативной техникой)",
            definition = "A retro style mixing inter-war machines with alternate-history grit.",
            definitionNative = "Ретро-стиль, соединяющий межвоенные машины с альт-историей и брутальностью.",
            example = "Sky Captain leans hard on dieselpunk to picture a thirties that never was.",
            exampleNative = "«Небесный капитан» жмёт на dieselpunk, рисуя тридцатые, каких не было.",
            pos = "noun", semanticGroup = "entertainment_advanced_genre",
            isFillInBlankSafe = false,
        ),
    )
}
