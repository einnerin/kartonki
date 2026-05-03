package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Музыка (L4, RARE+EPIC).
 *
 * Set 403: «Музыка» — профессиональный.
 *          Продвинутая теория (chromatic, polyrhythm, hemiola, augmentation,
 *          diminution), мировые музыкальные традиции (flamenco, klezmer,
 *          gamelan, raga, qawwali), авангард XX века (atonality, serialism,
 *          aleatoric, microtonal, drone), язык музыкальной критики высокого
 *          уровня (virtuosic, formulaic, contrived, mesmerizing, bombastic) и
 *          углублённая индустрия (payola, A&R, publishing rights,
 *          distribution deal, advance) — лексика B2-C1 для разговоров о
 *          музыке на уровне статьи в The Wire или Pitchfork.
 *
 * Тема «Музыка» — продолжение L1 (set 400), L2 (set 401), L3 (set 402).
 * Все 25 слов проверены grep'ом по `original = "..."` против WordDataEnglish*.kt:
 *   - Кандидаты, оказавшиеся занятыми и заменённые: residuals (CinemaL4 set 398),
 *     distribution (set 303 boardgame — взято в составе фразы "distribution deal"),
 *     spectral (set 216 astronomy), derivative (FinanceL5), transcendent
 *     (CinemaL5), sublime (EmotionsL5/EntertainmentL5), polyphony (set 239),
 *     counterpoint/syncopation/dissonance/cadence/timbre/vibrato/soprano/symphony/
 *     overture/crescendo (set 205), prodigy (EducationL5), motif (set 60),
 *     leitmotif (set 80/EntertainmentL5), prelude (TimeL3), recital (set 239),
 *     panning (CinemaL3 — иное значение, во избежание путаницы),
 *     orchestration (TechL5 — омоним), cathartic/haunting/evocative/pastiche
 *     (set 60/80), nuanced (set 74), visceral (set 81), relentless (set 82),
 *     cliché (CinemaL2), homage (set 242), introspective (set 71).
 *   - Принятые: chromatic, polyrhythm, hemiola, augmentation, diminution,
 *     flamenco, klezmer, gamelan, raga, qawwali, atonality, serialism,
 *     aleatoric, microtonal, drone, virtuosic, formulaic, contrived,
 *     mesmerizing, bombastic, payola, A&R, publishing rights,
 *     distribution deal, advance.
 *
 * Распределение редкости: 17 EPIC + 8 RARE — два смежных уровня (B2 + C1).
 *
 * SemanticGroups (5 × 5):
 *   music_l4_theory_advanced  — chromatic, polyrhythm, hemiola, augmentation,
 *                               diminution
 *   music_l4_world_traditions — flamenco, klezmer, gamelan, raga, qawwali
 *   music_l4_avant_garde      — atonality, serialism, aleatoric, microtonal,
 *                               drone
 *   music_l4_critic_terms     — virtuosic, formulaic, contrived, mesmerizing,
 *                               bombastic
 *   music_l4_industry_advanced — payola, A&R, publishing rights,
 *                                distribution deal, advance
 *
 * Word IDs: setId × 100 + position (40301..40325).
 *
 * fillInBlankExclusions / isFillInBlankSafe — не выставлены здесь (defaults в
 * WordEntity). FILL_IN_BLANK pipeline инжектит их централизованно после wave;
 * если поставить их заранее, pipeline пропустит запись (известный баг).
 */
object WordDataEnglishMusicL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 403,
            languagePair = "en-ru",
            orderIndex = 403,
            name = "Музыка",
            description = "Продвинутая теория, мировые традиции, авангард, критика и индустрия",
            topic = "Музыка",
            level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 403 — Музыка: профессиональный (L4, RARE+EPIC)               ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── music_l4_theory_advanced (5) ──────────────────────────────────

        WordEntity(id = 40301, setId = 403, languagePair = "en-ru", rarity = "RARE",
            original = "chromatic", transliteration = "[kroʊˈmætɪk]", translation = "хроматический (по полутонам)",
            definition = "Moving by the smallest steps that the Western scale can take.",
            definitionNative = "Идущий по самым мелким шагам, какие знает западная гамма.",
            example = "The pianist played a swift chromatic run from the lowest key to the highest.",
            exampleNative = "Пианист быстро пробежался chromatic ходом от самой низкой клавиши к самой высокой.",
            pos = "adjective", semanticGroup = "music_l4_theory_advanced", fillInBlankExclusions = listOf(40314L, 40316L)),

        WordEntity(id = 40302, setId = 403, languagePair = "en-ru", rarity = "EPIC",
            original = "polyrhythm", transliteration = "[ˈpɑliˌrɪðəm]", translation = "полиритмия (несколько ритмов одновременно)",
            definition = "Two opposing rhythms played at the same time so they pull against each other.",
            definitionNative = "Два противоположных ритма, что звучат одновременно и тянут друг против друга.",
            example = "West African drumming is built on layers of polyrhythm woven together.",
            exampleNative = "Барабанная музыка Западной Африки построена на слоях polyrhythm, сплетённых вместе.",
            pos = "noun", semanticGroup = "music_l4_theory_advanced", fillInBlankExclusions = listOf(40303L, 40304L, 40305L)),

        WordEntity(id = 40303, setId = 403, languagePair = "en-ru", rarity = "EPIC",
            original = "hemiola", transliteration = "[ˌhɛmiˈoʊlə]", translation = "гемиола (сдвиг акцентов в ритме)",
            definition = "A trick where three beats fit into the space normally given to two.",
            definitionNative = "Приём, при котором три доли укладываются в место, обычно отведённое двум.",
            example = "Brahms loved a sudden hemiola that knocks the listener off the strong beat.",
            exampleNative = "Брамс любил внезапную hemiola, что сбивает слушателя с сильной доли.",
            pos = "noun", semanticGroup = "music_l4_theory_advanced", fillInBlankExclusions = listOf(40302L, 40304L, 40305L)),

        WordEntity(id = 40304, setId = 403, languagePair = "en-ru", rarity = "EPIC",
            original = "augmentation", transliteration = "[ˌɔɡmənˈteɪʃən]", translation = "аугментация (растягивание длительностей)",
            definition = "A way of restating a tune in which every note is held twice as long.",
            definitionNative = "Способ повторного проведения темы, при котором каждую ноту держат вдвое дольше.",
            example = "The fugue's final entry uses augmentation to make the theme feel grander.",
            exampleNative = "В финальном проведении фуги augmentation делает тему более величественной.",
            pos = "noun", semanticGroup = "music_l4_theory_advanced", fillInBlankExclusions = listOf(40302L, 40303L, 40305L)),

        WordEntity(id = 40305, setId = 403, languagePair = "en-ru", rarity = "EPIC",
            original = "diminution", transliteration = "[ˌdɪməˈnuʃən]", translation = "диминуция (сжатие длительностей)",
            definition = "The opposite of stretching: a tune restated with every note made shorter.",
            definitionNative = "Противоположность растягиванию: повторение темы, где каждую ноту делают короче.",
            example = "Bach answers the long opening theme with a tight diminution in the bass.",
            exampleNative = "Бах отвечает на долгую начальную тему плотной diminution в басу.",
            pos = "noun", semanticGroup = "music_l4_theory_advanced", fillInBlankExclusions = listOf(40302L, 40303L, 40304L)),

        // ── music_l4_world_traditions (5) ─────────────────────────────────

        WordEntity(id = 40306, setId = 403, languagePair = "en-ru", rarity = "RARE",
            original = "flamenco", transliteration = "[fləˈmɛŋkoʊ]", translation = "фламенко (испанский цыганский стиль)",
            definition = "A passionate Spanish gypsy style of guitar, voice and stamping dance.",
            definitionNative = "Страстный испанский цыганский стиль гитары, голоса и отбивающего танца.",
            example = "The Seville bar offered live flamenco every Friday night until dawn.",
            exampleNative = "Севильский бар каждую пятницу предлагал живое flamenco до рассвета.",
            pos = "noun", semanticGroup = "music_l4_world_traditions", fillInBlankExclusions = listOf(40307L, 40308L, 40309L, 40310L)),

        WordEntity(id = 40307, setId = 403, languagePair = "en-ru", rarity = "EPIC",
            original = "klezmer", transliteration = "[ˈklɛzmər]", translation = "клезмер (восточноевропейская еврейская музыка)",
            definition = "An old Eastern European Jewish folk style played on clarinet, fiddle and accordion.",
            definitionNative = "Старинный восточноевропейский еврейский фольклорный стиль на кларнете, скрипке и аккордеоне.",
            example = "The wedding band launched into a fast klezmer tune as the dancers formed a circle.",
            exampleNative = "Свадебная группа грянула быстрый klezmer мотив, пока танцоры собирались в круг.",
            pos = "noun", semanticGroup = "music_l4_world_traditions", fillInBlankExclusions = listOf(40306L, 40308L, 40309L, 40310L)),

        WordEntity(id = 40308, setId = 403, languagePair = "en-ru", rarity = "EPIC",
            original = "gamelan", transliteration = "[ˈɡæməˌlæn]", translation = "гамелан (индонезийский ансамбль ударных)",
            definition = "An Indonesian ensemble built around tuned bronze gongs and metal bars.",
            definitionNative = "Индонезийский ансамбль, построенный вокруг настроенных бронзовых гонгов и металлических пластин.",
            example = "The Javanese gamelan filled the courtyard with shimmering layers of bronze.",
            exampleNative = "Яванский gamelan заполнил двор мерцающими слоями бронзы.",
            pos = "noun", semanticGroup = "music_l4_world_traditions", fillInBlankExclusions = listOf(40306L, 40307L, 40309L, 40310L)),

        WordEntity(id = 40309, setId = 403, languagePair = "en-ru", rarity = "EPIC",
            original = "raga", transliteration = "[ˈrɑɡə]", translation = "рага (индийская мелодическая модель)",
            definition = "An Indian musical pattern that sets the notes and mood for an improvised piece.",
            definitionNative = "Индийская музыкальная схема, что задаёт ноты и настроение для импровизированной пьесы.",
            example = "The sitar player chose an evening raga to match the calming sunset hour.",
            exampleNative = "Ситарист выбрал вечернюю raga в тон успокаивающему закатному часу.",
            pos = "noun", semanticGroup = "music_l4_world_traditions", fillInBlankExclusions = listOf(40306L, 40307L, 40308L, 40310L)),

        WordEntity(id = 40310, setId = 403, languagePair = "en-ru", rarity = "EPIC",
            original = "qawwali", transliteration = "[kəˈwɑli]", translation = "каввали (суфийское духовное пение)",
            definition = "A loud Sufi devotional style sung by a group with hand drums and clapping.",
            definitionNative = "Громкий суфийский духовный стиль, который поёт группа с ручными барабанами и хлопками.",
            example = "Nusrat's qawwali could lift a whole audience into a state close to a trance.",
            exampleNative = "qawwali Нусрата мог поднять целый зал в состояние, близкое к трансу.",
            pos = "noun", semanticGroup = "music_l4_world_traditions", fillInBlankExclusions = listOf(40306L, 40307L, 40308L, 40309L)),

        // ── music_l4_avant_garde (5) ──────────────────────────────────────

        WordEntity(id = 40311, setId = 403, languagePair = "en-ru", rarity = "RARE",
            original = "atonality", transliteration = "[ˌeɪtoʊˈnæləti]", translation = "атональность (отсутствие тональной опоры)",
            definition = "A way of writing music in which no single note feels like the home base.",
            definitionNative = "Способ письма, при котором ни одна нота не звучит как «домашняя».",
            example = "Schoenberg's move toward atonality split early-twentieth-century critics in two.",
            exampleNative = "Поворот Шёнберга к atonality расколол критиков начала двадцатого века надвое.",
            pos = "noun", semanticGroup = "music_l4_avant_garde", fillInBlankExclusions = listOf(40312L, 40313L, 40314L, 40315L)),

        WordEntity(id = 40312, setId = 403, languagePair = "en-ru", rarity = "EPIC",
            original = "serialism", transliteration = "[ˈsɪriəˌlɪzəm]", translation = "серийная техника",
            definition = "A system that orders all twelve notes into a fixed row used as the basis of a piece.",
            definitionNative = "Система, что выстраивает все двенадцать нот в строгий ряд, лежащий в основе пьесы.",
            example = "Boulez pushed serialism beyond pitch into rhythm, dynamics and timbre as well.",
            exampleNative = "Булез распространил serialism за пределы высоты — на ритм, динамику и тембр.",
            pos = "noun", semanticGroup = "music_l4_avant_garde", fillInBlankExclusions = listOf(40311L, 40313L, 40314L, 40315L)),

        WordEntity(id = 40313, setId = 403, languagePair = "en-ru", rarity = "EPIC",
            original = "aleatoric", transliteration = "[ˌeɪliəˈtɔrɪk]", translation = "алеаторический (с элементом случайности)",
            definition = "Made with parts deliberately left to chance for the player to choose live.",
            definitionNative = "Написанный так, что часть нарочно отдана случаю, и исполнитель решает прямо на сцене.",
            example = "Cage's aleatoric scores let the performer toss coins to pick the next phrase.",
            exampleNative = "Aleatoric партитуры Кейджа позволяют исполнителю бросать монеты, чтобы выбрать следующую фразу.",
            pos = "adjective", semanticGroup = "music_l4_avant_garde", fillInBlankExclusions = listOf(40311L, 40312L, 40314L, 40315L)),

        WordEntity(id = 40314, setId = 403, languagePair = "en-ru", rarity = "EPIC",
            original = "microtonal", transliteration = "[ˌmaɪkroʊˈtoʊnəl]", translation = "микротоновый (с шагом меньше полутона)",
            definition = "Using pitches that fall between the standard keys of the Western piano.",
            definitionNative = "Использующий высоты, что попадают между стандартными клавишами западного фортепиано.",
            example = "Her microtonal violin part bends each note slightly off the usual grid.",
            exampleNative = "Её microtonal скрипичная партия чуть отклоняет каждую ноту от привычной сетки.",
            pos = "adjective", semanticGroup = "music_l4_avant_garde", fillInBlankExclusions = listOf(40311L, 40312L, 40313L, 40315L)),

        WordEntity(id = 40315, setId = 403, languagePair = "en-ru", rarity = "RARE",
            original = "drone", transliteration = "[droʊn]", translation = "дрон (тянущийся бас как опора)",
            definition = "A long held bass tone that hums under the music for minutes on end.",
            definitionNative = "Долго тянущийся басовый звук, что гудит под музыкой минутами подряд.",
            example = "Indian classical music often unfolds over a low tambura drone.",
            exampleNative = "Индийская классическая музыка часто разворачивается над низким drone тамбуры.",
            pos = "noun", semanticGroup = "music_l4_avant_garde", fillInBlankExclusions = listOf(40311L, 40312L, 40313L, 40314L)),

        // ── music_l4_critic_terms (5) ─────────────────────────────────────

        WordEntity(id = 40316, setId = 403, languagePair = "en-ru", rarity = "RARE",
            original = "virtuosic", transliteration = "[ˌvərʧuˈoʊsɪk]", translation = "виртуозный",
            definition = "Played with skill so high that very few musicians on Earth could match it.",
            definitionNative = "Исполненный с мастерством, какое могут повторить лишь немногие на Земле.",
            example = "Her virtuosic guitar solo drew a long stunned silence before the applause.",
            exampleNative = "Её virtuosic гитарное соло вызвало долгое потрясённое молчание перед аплодисментами.",
            pos = "adjective", semanticGroup = "music_l4_critic_terms", fillInBlankExclusions = listOf(40317L, 40318L, 40319L, 40320L)),

        WordEntity(id = 40317, setId = 403, languagePair = "en-ru", rarity = "RARE",
            original = "formulaic", transliteration = "[ˌfɔrmjəˈleɪɪk]", translation = "шаблонный (по готовой формуле)",
            definition = "Built on a tired ready pattern that adds nothing fresh of its own.",
            definitionNative = "Построенный на затёртой готовой схеме, что не добавляет ничего своего нового.",
            example = "The reviewer called the album's choruses formulaic and forgettable.",
            exampleNative = "Рецензент назвал припевы альбома formulaic и забываемыми.",
            pos = "adjective", semanticGroup = "music_l4_critic_terms", fillInBlankExclusions = listOf(40316L, 40318L, 40319L, 40320L)),

        WordEntity(id = 40318, setId = 403, languagePair = "en-ru", rarity = "EPIC",
            original = "contrived", transliteration = "[kənˈtraɪvd]", translation = "натянутый, искусственный",
            definition = "Forced and unnatural — clearly arranged on purpose rather than felt.",
            definitionNative = "Натужный и неестественный — явно подстроенный нарочно, а не пережитый.",
            example = "The big key change near the end felt contrived rather than earned.",
            exampleNative = "Громкая смена тональности под конец показалась contrived, а не заслуженной.",
            pos = "adjective", semanticGroup = "music_l4_critic_terms", fillInBlankExclusions = listOf(40316L, 40317L, 40319L, 40320L)),

        WordEntity(id = 40319, setId = 403, languagePair = "en-ru", rarity = "RARE",
            original = "mesmerizing", transliteration = "[ˈmɛzməˌraɪzɪŋ]", translation = "завораживающий",
            definition = "So strangely beautiful that it grips the ear and refuses to let go.",
            definitionNative = "Так странно прекрасный, что захватывает слух и не отпускает.",
            example = "Her mesmerizing voice drew the whole crowd toward the small wooden stage.",
            exampleNative = "Её mesmerizing голос притянул всю толпу к маленькой деревянной сцене.",
            pos = "adjective", semanticGroup = "music_l4_critic_terms", fillInBlankExclusions = listOf(40316L, 40317L, 40318L, 40320L)),

        WordEntity(id = 40320, setId = 403, languagePair = "en-ru", rarity = "EPIC",
            original = "bombastic", transliteration = "[bɑmˈbæstɪk]", translation = "напыщенный",
            definition = "Loud and grand in a showy empty way that mistakes volume for depth.",
            definitionNative = "Громкий и грандиозный показной пустотой, путающей объём звука с глубиной.",
            example = "Critics dismissed the symphony's bombastic finale as pure noise without ideas.",
            exampleNative = "Критики отмахнулись от bombastic финала симфонии как от чистого шума без идей.",
            pos = "adjective", semanticGroup = "music_l4_critic_terms", fillInBlankExclusions = listOf(40316L, 40317L, 40318L, 40319L)),

        // ── music_l4_industry_advanced (5) ────────────────────────────────

        WordEntity(id = 40321, setId = 403, languagePair = "en-ru", rarity = "EPIC",
            original = "payola", transliteration = "[peɪˈoʊlə]", translation = "плата за прокрутку (нелегальная)",
            definition = "Secret cash slipped to radio staff to make them play one song over others.",
            definitionNative = "Скрытые деньги, что суют сотрудникам радио за то, чтобы они крутили одну песню вперёд других.",
            example = "The big payola scandal of the late fifties shook the American radio business.",
            exampleNative = "Громкий скандал с payola конца пятидесятых потряс американский радиобизнес.",
            pos = "noun", semanticGroup = "music_l4_industry_advanced", fillInBlankExclusions = listOf(40322L, 40323L, 40324L, 40325L)),

        WordEntity(id = 40322, setId = 403, languagePair = "en-ru", rarity = "EPIC",
            original = "A&R", transliteration = "[ˌeɪ ən ˈɑr]", translation = "A&R-менеджер (поиск и развитие артистов)",
            definition = "The label staff whose job is to find new artists and shape what they record.",
            definitionNative = "Сотрудники лейбла, чья работа — находить новых артистов и формировать то, что они записывают.",
            example = "The A&R guy from the London office flew out to hear the band live.",
            exampleNative = "A&R-сотрудник из лондонского офиса прилетел послушать группу вживую.",
            pos = "noun", semanticGroup = "music_l4_industry_advanced", fillInBlankExclusions = listOf(40321L, 40323L, 40324L, 40325L)),

        WordEntity(id = 40323, setId = 403, languagePair = "en-ru", rarity = "RARE",
            original = "publishing rights", transliteration = "[ˈpʌblɪʃɪŋ raɪts]", translation = "издательские права на песню",
            definition = "The legal hold over a song's words and tune that earns money each time it is used.",
            definitionNative = "Юридическое право на слова и мелодию песни, что приносит деньги при каждом использовании.",
            example = "The artist refused to sign away her publishing rights even for a big advance.",
            exampleNative = "Артистка отказалась отдать publishing rights даже за крупный аванс.",
            pos = "noun", semanticGroup = "music_l4_industry_advanced", fillInBlankExclusions = listOf(40321L, 40322L, 40324L, 40325L)),

        WordEntity(id = 40324, setId = 403, languagePair = "en-ru", rarity = "EPIC",
            original = "distribution deal", transliteration = "[ˌdɪstrəˈbjuʃən dil]", translation = "контракт на дистрибуцию",
            definition = "A contract that lets a partner ship and sell an artist's music to shops and streams.",
            definitionNative = "Контракт, по которому партнёр поставляет и продаёт музыку артиста в магазины и на стримы.",
            example = "The indie band signed a worldwide distribution deal but kept their masters.",
            exampleNative = "Инди-группа подписала мировой distribution deal, но сохранила за собой мастер-записи.",
            pos = "noun", semanticGroup = "music_l4_industry_advanced", fillInBlankExclusions = listOf(40321L, 40322L, 40323L, 40325L)),

        WordEntity(id = 40325, setId = 403, languagePair = "en-ru", rarity = "EPIC",
            original = "advance", transliteration = "[ədˈvæns]", translation = "аванс (от лейбла)",
            definition = "Money paid up front by a label that the artist later earns back from sales.",
            definitionNative = "Деньги, выплаченные лейблом вперёд, которые артист потом отрабатывает с продаж.",
            example = "She used the modest advance to buy proper studio gear for her debut record.",
            exampleNative = "Она пустила скромный advance на нормальное студийное оборудование для дебютной пластинки.",
            pos = "noun", semanticGroup = "music_l4_industry_advanced", fillInBlankExclusions = listOf(40321L, 40322L, 40323L, 40324L)),
    )
}
