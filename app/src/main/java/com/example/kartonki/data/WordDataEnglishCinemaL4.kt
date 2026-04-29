package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Кино и сериалы (L4, RARE+EPIC).
 *
 * Set 398: «Кино и сериалы» — профессиональный.
 *          Продвинутые операторские/монтажные техники (depth of field, rack focus,
 *          match cut, long take, shallow focus), теория жанров (genre conventions,
 *          monomyth, narratology, stock character, world-building), углублённая
 *          индустрия (greenlight, in development, principal photography, theatrical
 *          run, residuals), история кино (silent era, New Hollywood, French New Wave,
 *          Italian neorealism, Soviet Montage), критическая теория (reception theory,
 *          gaze theory, formalism, structuralism, spectatorship) — лексика B2-C1
 *          для разговоров о фильмах на уровне статьи в Sight & Sound или Cahiers
 *          du Cinéma.
 *
 * Тема «Кино и сериалы» — продолжение L1 (set 395), L2 (set 396), L3 (set 397).
 * Все 25 слов проверены grep'ом по `original = "..."` против WordDataEnglish*.kt:
 *   - Кандидаты, оказавшиеся занятыми и заменённые: tracking shot (Expanded),
 *     post-production (EntertainmentL4), mise-en-scène (EntertainmentL5),
 *     ideology (Abstract set 42 — иной топик, но во избежание путаницы),
 *     paradigm (set 59 academic), nouvelle vague (Expanded), premiere (Expanded),
 *     archetypal (есть archetype в set 225), tropes (есть trope в EntL1L2L3),
 *     narrative tradition (есть narrative arc в set 245), cinephilia
 *     (есть cinephile в CinemaL3 — однокоренное в смежном сете темы), semiotics
 *     (есть semiotic reading в EntertainmentL5).
 *   - Принятые: depth of field, rack focus, match cut, long take, shallow focus,
 *     genre conventions, monomyth, narratology, stock character, world-building,
 *     greenlight, in development, principal photography, theatrical run, residuals,
 *     silent era, New Hollywood, French New Wave, Italian neorealism, Soviet Montage,
 *     reception theory, gaze theory, formalism, structuralism, spectatorship.
 *
 * Распределение редкости: 17 EPIC + 8 RARE — два смежных уровня (B2 + C1).
 *
 * SemanticGroups (5 × 5):
 *   cinema_l4_techniques_advanced — depth of field, rack focus, match cut,
 *                                   long take, shallow focus
 *   cinema_l4_genre_studies       — genre conventions, monomyth, narratology,
 *                                   stock character, world-building
 *   cinema_l4_industry_advanced   — greenlight, in development,
 *                                   principal photography, theatrical run,
 *                                   residuals
 *   cinema_l4_history             — silent era, New Hollywood, French New Wave,
 *                                   Italian neorealism, Soviet Montage
 *   cinema_l4_critique_advanced   — reception theory, gaze theory, formalism,
 *                                   structuralism, spectatorship
 *
 * Word IDs: setId × 100 + position (39801..39825).
 *
 * fillInBlankExclusions / isFillInBlankSafe — не выставлены здесь (defaults в
 * WordEntity). FILL_IN_BLANK pipeline инжектит их централизованно после wave;
 * если поставить их заранее, pipeline пропустит запись (известный баг).
 */
object WordDataEnglishCinemaL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 398,
            languagePair = "en-ru",
            orderIndex = 398,
            name = "Кино и сериалы",
            description = "Продвинутые техники, история, теория жанров и критика",
            topic = "Кино и сериалы",
            level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 398 — Кино и сериалы: профессиональный (L4, RARE+EPIC)       ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── cinema_l4_techniques_advanced (5) ─────────────────────────────

        WordEntity(id = 39801, setId = 398, languagePair = "en-ru", rarity = "RARE",
            original = "depth of field", transliteration = "[dɛpθ əv fild]", translation = "глубина резкости",
            definition = "The slice of the scene in front of the lens that stays sharp at once.",
            definitionNative = "Полоса сцены перед объективом, что в один момент остаётся резкой.",
            example = "A wide aperture gives a shallow depth of field that blurs the background.",
            exampleNative = "Широкая диафрагма даёт малую depth of field, что размывает задний план.",
            pos = "noun", semanticGroup = "cinema_l4_techniques_advanced", fillInBlankExclusions = listOf(39802L, 39803L, 39804L, 39805L)),

        WordEntity(id = 39802, setId = 398, languagePair = "en-ru", rarity = "EPIC",
            original = "rack focus", transliteration = "[ræk ˈfoʊkəs]", translation = "перевод фокуса в кадре",
            definition = "A trick where the lens shifts sharpness from one object to another mid-shot.",
            definitionNative = "Приём, когда объектив прямо в кадре переводит резкость с одного предмета на другой.",
            example = "The director used a rack focus to pull the eye from the gun to the face.",
            exampleNative = "Режиссёр применил rack focus, чтобы увести взгляд с пистолета на лицо.",
            pos = "noun", semanticGroup = "cinema_l4_techniques_advanced", fillInBlankExclusions = listOf(39801L, 39803L, 39804L, 39805L)),

        WordEntity(id = 39803, setId = 398, languagePair = "en-ru", rarity = "EPIC",
            original = "match cut", transliteration = "[mæʧ kʌt]", translation = "монтажная склейка по форме",
            definition = "A clever edit where two shots line up by shape or motion to feel like one.",
            definitionNative = "Хитрый монтажный стык, в котором два кадра совпадают формой или движением.",
            example = "Kubrick's famous match cut turns a thrown bone into an orbiting station.",
            exampleNative = "Знаменитый match cut Кубрика превращает брошенную кость в орбитальную станцию.",
            pos = "noun", semanticGroup = "cinema_l4_techniques_advanced", fillInBlankExclusions = listOf(39801L, 39802L, 39804L, 39805L)),

        WordEntity(id = 39804, setId = 398, languagePair = "en-ru", rarity = "RARE",
            original = "long take", translation = "длинный непрерывный план",
            transliteration = "[lɔŋ teɪk]",
            definition = "A single shot that runs without a cut for many minutes at a time.",
            definitionNative = "Один кадр, что идёт без монтажной склейки помногу минут подряд.",
            example = "The opening long take in that thriller follows the hero through three rooms.",
            exampleNative = "Вступительный long take в том триллере провожает героя через три комнаты.",
            pos = "noun", semanticGroup = "cinema_l4_techniques_advanced", fillInBlankExclusions = listOf(39801L, 39802L, 39803L, 39805L)),

        WordEntity(id = 39805, setId = 398, languagePair = "en-ru", rarity = "EPIC",
            original = "shallow focus", transliteration = "[ˈʃæloʊ ˈfoʊkəs]", translation = "малая глубина фокуса",
            definition = "A look where only one plane is sharp while everything else dissolves softly.",
            definitionNative = "Картинка, где резок лишь один план, а остальное мягко расплывается.",
            example = "Portrait scenes lean on shallow focus to keep the actor's eyes alone in clarity.",
            exampleNative = "Портретные сцены опираются на shallow focus, чтобы только глаза актёра были в чёткости.",
            pos = "noun", semanticGroup = "cinema_l4_techniques_advanced", fillInBlankExclusions = listOf(39801L, 39802L, 39803L, 39804L)),

        // ── cinema_l4_genre_studies (5) ───────────────────────────────────

        WordEntity(id = 39806, setId = 398, languagePair = "en-ru", rarity = "RARE",
            original = "genre conventions", transliteration = "[ˈʒɑnrə kənˈvɛnʃənz]", translation = "жанровые условности",
            definition = "The unwritten rules an audience expects a certain kind of film to follow.",
            definitionNative = "Негласные правила, которым, как ждёт зритель, послушно следует определённый сорт фильма.",
            example = "Westerns lean on genre conventions like the lone rider and the duel at noon.",
            exampleNative = "Вестерны опираются на genre conventions — одинокий всадник и дуэль в полдень.",
            pos = "noun", semanticGroup = "cinema_l4_genre_studies", fillInBlankExclusions = listOf(39807L, 39808L, 39809L, 39810L)),

        WordEntity(id = 39807, setId = 398, languagePair = "en-ru", rarity = "EPIC",
            original = "monomyth", transliteration = "[ˈmɑnəˌmɪθ]", translation = "мономиф (универсальная схема геройского пути)",
            definition = "Campbell's idea of one shared story shape behind every hero tale on Earth.",
            definitionNative = "Идея Кэмпбелла об одной общей форме сюжета, что стоит за любой геройской историей.",
            example = "Star Wars famously follows the monomyth from call to adventure to return.",
            exampleNative = "«Звёздные войны» откровенно следуют monomyth: от зова в путь до возвращения.",
            pos = "noun", semanticGroup = "cinema_l4_genre_studies", fillInBlankExclusions = listOf(39806L, 39808L, 39809L, 39810L)),

        WordEntity(id = 39808, setId = 398, languagePair = "en-ru", rarity = "EPIC",
            original = "narratology", transliteration = "[ˌnɛrəˈtɑləʤi]", translation = "наука о повествовании",
            definition = "The branch of theory that studies how stories are built and how they work.",
            definitionNative = "Раздел теории, что изучает, как истории устроены и как они работают.",
            example = "Modern narratology compares story structures across novels, films and games.",
            exampleNative = "Современная narratology сравнивает структуры историй в романах, фильмах и играх.",
            pos = "noun", semanticGroup = "cinema_l4_genre_studies", fillInBlankExclusions = listOf(39806L, 39807L, 39809L, 39810L, 39821L, 39823L, 39824L)),

        WordEntity(id = 39809, setId = 398, languagePair = "en-ru", rarity = "RARE",
            original = "stock character", transliteration = "[stɑk ˈkɛrɪktər]", translation = "типовой персонаж",
            definition = "A familiar role figure — like the wise mentor — that audiences spot at once.",
            definitionNative = "Знакомый ролевой типаж — вроде мудрого наставника, — что зритель узнаёт сразу.",
            example = "The grumpy boss is a stock character every workplace comedy reaches for.",
            exampleNative = "Ворчливый босс — stock character, к которому тянется любая офисная комедия.",
            pos = "noun", semanticGroup = "cinema_l4_genre_studies", fillInBlankExclusions = listOf(39806L, 39807L, 39808L, 39810L)),

        WordEntity(id = 39810, setId = 398, languagePair = "en-ru", rarity = "EPIC",
            original = "world-building", transliteration = "[ˈwɜrldˌbɪldɪŋ]", translation = "построение мира",
            definition = "The careful crafting of a fictional setting with its own rules and history.",
            definitionNative = "Старательное создание вымышленного мира с собственными правилами и историей.",
            example = "Tolkien set the bar for cinematic world-building with maps, languages and lore.",
            exampleNative = "Толкин задал планку для кинематографического world-building картами, языками и преданиями.",
            pos = "noun", semanticGroup = "cinema_l4_genre_studies", fillInBlankExclusions = listOf(39806L, 39807L, 39808L, 39809L)),

        // ── cinema_l4_industry_advanced (5) ───────────────────────────────

        WordEntity(id = 39811, setId = 398, languagePair = "en-ru", rarity = "RARE",
            original = "greenlight", transliteration = "[ˈɡrinˌlaɪt]", translation = "одобрение проекта к запуску",
            definition = "The studio's formal go-ahead that allows a film to enter real production.",
            definitionNative = "Официальное «вперёд» от студии, что пускает фильм в настоящее производство.",
            example = "After two years in limbo, the script finally got the greenlight from the board.",
            exampleNative = "После двух лет в подвешенном виде сценарий наконец получил greenlight от совета.",
            pos = "noun", semanticGroup = "cinema_l4_industry_advanced", fillInBlankExclusions = listOf(39813L, 39814L, 39815L)),

        WordEntity(id = 39812, setId = 398, languagePair = "en-ru", rarity = "EPIC",
            original = "in development", transliteration = "[ɪn dɪˈvɛləpmənt]", translation = "на стадии разработки",
            definition = "The early phase when a project is being shaped but not yet shooting.",
            definitionNative = "Ранняя фаза, когда проект ещё лепится, но съёмки ещё не идут.",
            example = "The biopic has been in development for five years without a final director.",
            exampleNative = "Байопик in development уже пять лет без окончательного режиссёра.",
            pos = "adjective", semanticGroup = "cinema_l4_industry_advanced"),

        WordEntity(id = 39813, setId = 398, languagePair = "en-ru", rarity = "EPIC",
            original = "principal photography", transliteration = "[ˈprɪnsəpəl fəˈtɑɡrəfi]", translation = "основной этап съёмок",
            definition = "The main shooting phase when most of the film is actually filmed on set.",
            definitionNative = "Главный съёмочный этап, на котором, по сути, и снимается большая часть фильма.",
            example = "Principal photography wrapped after ninety days across three countries.",
            exampleNative = "Principal photography завершилась после девяноста дней в трёх странах.",
            pos = "noun", semanticGroup = "cinema_l4_industry_advanced", fillInBlankExclusions = listOf(39811L, 39814L, 39815L)),

        WordEntity(id = 39814, setId = 398, languagePair = "en-ru", rarity = "EPIC",
            original = "theatrical run", transliteration = "[θiˈætrɪkəl rʌn]", translation = "прокат в кинотеатрах",
            definition = "The stretch of weeks a movie spends playing on real cinema screens.",
            definitionNative = "Череда недель, которые фильм проводит в показе на настоящих киноэкранах.",
            example = "The horror film enjoyed a long theatrical run thanks to strong word of mouth.",
            exampleNative = "Хоррор отыграл долгий theatrical run благодаря крепкому сарафанному радио.",
            pos = "noun", semanticGroup = "cinema_l4_industry_advanced", fillInBlankExclusions = listOf(39811L, 39813L, 39815L)),

        WordEntity(id = 39815, setId = 398, languagePair = "en-ru", rarity = "EPIC",
            original = "residuals", transliteration = "[rɪˈzɪʤuəlz]", translation = "отчисления за повторные показы",
            definition = "The ongoing pay actors and writers get whenever their old work runs again.",
            definitionNative = "Регулярные выплаты актёрам и сценаристам всякий раз, когда их старая работа идёт снова.",
            example = "Strikes often centre on fairer residuals from streaming platforms.",
            exampleNative = "Забастовки часто крутятся вокруг справедливых residuals со стриминговых платформ.",
            pos = "noun", semanticGroup = "cinema_l4_industry_advanced", fillInBlankExclusions = listOf(39811L, 39813L, 39814L)),

        // ── cinema_l4_history (5) ─────────────────────────────────────────

        WordEntity(id = 39816, setId = 398, languagePair = "en-ru", rarity = "RARE",
            original = "silent era", transliteration = "[ˈsaɪlənt ˈɪrə]", translation = "эпоха немого кино",
            definition = "The early decades of cinema before sound, when titles carried the dialogue.",
            definitionNative = "Ранние десятилетия кино до звука, когда диалоги несли надписи на экране.",
            example = "Chaplin and Keaton became giants of the silent era with pure visual comedy.",
            exampleNative = "Чаплин и Китон стали гигантами silent era на чистой визуальной комедии.",
            pos = "noun", semanticGroup = "cinema_l4_history", fillInBlankExclusions = listOf(39817L, 39818L, 39819L, 39820L)),

        WordEntity(id = 39817, setId = 398, languagePair = "en-ru", rarity = "EPIC",
            original = "New Hollywood", transliteration = "[nu ˈhɑliˌwʊd]", translation = "Новый Голливуд (1967–1980)",
            definition = "The bold late-sixties wave of young American directors who broke studio rules.",
            definitionNative = "Дерзкая волна конца шестидесятых — молодых американских режиссёров, что ломали студийные правила.",
            example = "Scorsese and Coppola defined the look of New Hollywood across the seventies.",
            exampleNative = "Скорсезе и Коппола задали облик New Hollywood на все семидесятые.",
            pos = "noun", semanticGroup = "cinema_l4_history", fillInBlankExclusions = listOf(39816L, 39818L, 39819L, 39820L)),

        WordEntity(id = 39818, setId = 398, languagePair = "en-ru", rarity = "EPIC",
            original = "French New Wave", transliteration = "[frɛnʧ nu weɪv]", translation = "французская новая волна",
            definition = "A late-fifties movement of French directors who shot fast, cheap and personal.",
            definitionNative = "Движение конца пятидесятых — французские режиссёры снимали быстро, дёшево и от себя.",
            example = "Godard and Truffaut led the French New Wave with handheld cameras on Paris streets.",
            exampleNative = "Годар и Трюффо вели French New Wave с ручными камерами по парижским улицам.",
            pos = "noun", semanticGroup = "cinema_l4_history", fillInBlankExclusions = listOf(39816L, 39817L, 39819L, 39820L)),

        WordEntity(id = 39819, setId = 398, languagePair = "en-ru", rarity = "EPIC",
            original = "Italian neorealism", transliteration = "[ɪˈtæljən ˌnioʊˈriəˌlɪzəm]", translation = "итальянский неореализм",
            definition = "Post-war Italian films shot on real streets with non-actors and harsh truth.",
            definitionNative = "Послевоенные итальянские фильмы — съёмка на настоящих улицах, непрофессионалы и суровая правда.",
            example = "De Sica's Bicycle Thieves stands as a peak of Italian neorealism.",
            exampleNative = "«Похитители велосипедов» Де Сики — вершина Italian neorealism.",
            pos = "noun", semanticGroup = "cinema_l4_history", fillInBlankExclusions = listOf(39816L, 39817L, 39818L, 39820L)),

        WordEntity(id = 39820, setId = 398, languagePair = "en-ru", rarity = "EPIC",
            original = "Soviet Montage", transliteration = "[ˈsoʊviət mɒnˈtɑʒ]", translation = "советский монтаж (школа 1920-х)",
            definition = "A 1920s Russian school that built meaning by clashing two shots against each other.",
            definitionNative = "Русская школа 1920-х, что строила смысл, сталкивая два кадра друг с другом.",
            example = "Eisenstein's Battleship Potemkin is the textbook example of Soviet Montage.",
            exampleNative = "«Броненосец Потёмкин» Эйзенштейна — хрестоматийный пример Soviet Montage.",
            pos = "noun", semanticGroup = "cinema_l4_history", fillInBlankExclusions = listOf(39816L, 39817L, 39818L, 39819L)),

        // ── cinema_l4_critique_advanced (5) ───────────────────────────────

        WordEntity(id = 39821, setId = 398, languagePair = "en-ru", rarity = "RARE",
            original = "reception theory", transliteration = "[rɪˈsɛpʃən ˈθɪri]", translation = "теория восприятия",
            definition = "The study of how different audiences make sense of the same film.",
            definitionNative = "Изучение того, как разные зрители понимают один и тот же фильм по-своему.",
            example = "Reception theory shows the same horror film scares each generation differently.",
            exampleNative = "Reception theory показывает, что один хоррор пугает каждое поколение по-разному.",
            pos = "noun", semanticGroup = "cinema_l4_critique_advanced", fillInBlankExclusions = listOf(39822L, 39823L, 39824L, 39825L)),

        WordEntity(id = 39822, setId = 398, languagePair = "en-ru", rarity = "EPIC",
            original = "gaze theory", transliteration = "[ɡeɪz ˈθɪri]", translation = "теория взгляда (в кинокритике)",
            definition = "A school that asks whose eyes the camera takes on and whose body it studies.",
            definitionNative = "Школа, что спрашивает, чьими глазами смотрит камера и чьё тело она изучает.",
            example = "Mulvey's gaze theory reshaped how critics read women on the big screen.",
            exampleNative = "Gaze theory Малви перевернула то, как критики читают женщин на большом экране.",
            pos = "noun", semanticGroup = "cinema_l4_critique_advanced", fillInBlankExclusions = listOf(39821L, 39823L, 39824L, 39825L)),

        WordEntity(id = 39823, setId = 398, languagePair = "en-ru", rarity = "RARE",
            original = "formalism", transliteration = "[ˈfɔrməˌlɪzəm]", translation = "формализм (анализ через форму)",
            definition = "An approach that reads a film through its shape, rhythm and craft, not its message.",
            definitionNative = "Подход, что читает фильм через его форму, ритм и ремесло, а не через идею.",
            example = "Russian formalism urged critics to study how a film is made, not just what it says.",
            exampleNative = "Русский formalism звал критиков изучать, как фильм сделан, а не только что он говорит.",
            pos = "noun", semanticGroup = "cinema_l4_critique_advanced", fillInBlankExclusions = listOf(39821L, 39822L, 39824L, 39825L)),

        WordEntity(id = 39824, setId = 398, languagePair = "en-ru", rarity = "EPIC",
            original = "psychoanalytic theory", transliteration = "[ˌsaɪkoʊˌænəˈlɪtɪk ˈθɪəri]", translation = "психоаналитическая теория (в кино)",
            definition = "A school that reads a film through hidden desires, dreams and the work of the unconscious.",
            definitionNative = "Школа, что читает фильм через скрытые желания, сны и работу бессознательного.",
            example = "Metz built his psychoanalytic theory on the link between dream logic and cinema.",
            exampleNative = "Мец строил свою psychoanalytic theory на связи между логикой сна и кино.",
            pos = "noun", semanticGroup = "cinema_l4_critique_advanced", fillInBlankExclusions = listOf(39821L, 39822L, 39823L, 39825L)),

        WordEntity(id = 39825, setId = 398, languagePair = "en-ru", rarity = "EPIC",
            original = "spectatorship", transliteration = "[spɛkˈteɪtərˌʃɪp]", translation = "зрительская позиция",
            definition = "The active role of the viewer in shaping what a film comes to mean.",
            definitionNative = "Активная роль зрителя в том, какой смысл в итоге обретает фильм.",
            example = "Modern essays on spectatorship treat the viewer as a partner, not a target.",
            exampleNative = "Современные эссе о spectatorship видят зрителя партнёром, а не мишенью.",
            pos = "noun", semanticGroup = "cinema_l4_critique_advanced", fillInBlankExclusions = listOf(39821L, 39822L, 39823L, 39824L)),
    )
}
