package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Музыка (L3, RARE+UNCOMMON).
 *
 * Set 402: «Музыка» — углублённый.
 *          Терминология теории музыки, серьёзного исполнительства, студийной
 *          продакшен-кухни, продвинутых жанров и языка музыкальной критики
 *          уровня B1-B2. Лексика рецензий, интервью с продюсерами и
 *          фестивальных обзоров.
 *
 * Тема — продолжение L1 (set 400) и L2 (set 401, создаётся параллельно).
 * L1 покрывает базовую лексику A1-A2 (sound, tune, beat, note, hit, bass,
 * harp, trumpet, saxophone, tambourine, hip-hop, rap, blues, folk, disco,
 * hum, whistle, bop, strum, encore, musician, band, drummer, pianist, dj).
 * L2 (создаётся параллельно) — повседневные понятия B1 (chord, scale,
 * harmony типа слов, не покрыто здесь). L3 строго придерживается B1/B2 —
 * терминология теории, продакшена и критики.
 *
 * Все 25 слов этого сета не пересекаются с уже существующими английскими
 * словами в базе (проверено grep'ом по `original = "..."`). Обойдены, в
 * частности: dissonance, counterpoint, syncopation (set 205), recital, tempo,
 * crescendo, polyphony, refrain, vibrato, timbre, soprano, symphony, ballad,
 * harmony, rehearsal (set 205/239), prodigy (EducationL5), indie
 * (CinemaL3), tonal (set 239 art), а также базовые music-термины из L1
 * (set 400) и из set 23/33/CultureL1.
 *
 * Распределение редкости: 18 RARE + 7 UNCOMMON — два смежных уровня (B1 + B2).
 *
 * SemanticGroups (5 × 5):
 *   music_l3_theory          — modulation, fugue, cadenza, atonal, tonality
 *   music_l3_performance     — virtuoso, maestro, setlist, busking, frontman
 *   music_l3_production      — mastering, mixing, overdub, sampling, multitrack
 *   music_l3_genres_advanced — bossa nova, bluegrass, gospel, prog rock, shoegaze
 *   music_l3_critique        — pitch-perfect, off-key, in tune, earworm, technically flawless
 *
 * Word IDs: setId × 100 + position (40201..40225).
 *
 * fillInBlankExclusions / isFillInBlankSafe — не выставлены здесь (defaults в
 * WordEntity). FILL_IN_BLANK pipeline инжектит их централизованно после wave;
 * если поставить их заранее, pipeline пропустит запись (известный баг).
 */
object WordDataEnglishMusicL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 402,
            languagePair = "en-ru",
            orderIndex = 402,
            name = "Музыка",
            description = "Теория, исполнительство, продакшен и язык музыкальной критики",
            topic = "Музыка",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 402 — Музыка: углублённый (L3, RARE+UNCOMMON)                ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── music_l3_theory (5) ───────────────────────────────────────────

        WordEntity(id = 40201, setId = 402, languagePair = "en-ru", rarity = "RARE",
            original = "modulation", transliteration = "[ˌmɑʤəˈleɪʃən]", translation = "модуляция (смена тональности)",
            definition = "A smooth move of a piece of music from one key into another key.",
            definitionNative = "Плавный переход музыкального произведения из одной тональности в другую.",
            example = "A sudden modulation up a tone lifts the final chorus of the song.",
            exampleNative = "Внезапная modulation на тон вверх поднимает финальный припев песни.",
            pos = "noun", semanticGroup = "music_l3_theory", fillInBlankExclusions = listOf(40202L, 40203L, 40205L)),

        WordEntity(id = 40202, setId = 402, languagePair = "en-ru", rarity = "RARE",
            original = "fugue", transliteration = "[fjuɡ]", translation = "фуга",
            definition = "A piece in which one short tune is repeated and woven together by several voices.",
            definitionNative = "Произведение, в котором одна короткая тема повторяется и переплетается несколькими голосами.",
            example = "Bach's organ fugue still feels mathematically perfect three centuries later.",
            exampleNative = "Органная fugue Баха и три века спустя кажется математически совершенной.",
            pos = "noun", semanticGroup = "music_l3_theory", fillInBlankExclusions = listOf(40201L, 40203L, 40205L)),

        WordEntity(id = 40203, setId = 402, languagePair = "en-ru", rarity = "RARE",
            original = "cadenza", transliteration = "[kəˈdɛnzə]", translation = "каденция (виртуозный сольный пассаж)",
            definition = "A showy solo passage near the end of a concerto where the player improvises.",
            definitionNative = "Эффектный сольный фрагмент ближе к концу концерта, где исполнитель импровизирует.",
            example = "The pianist's cadenza brought the whole hall to silent attention.",
            exampleNative = "cadenza пианиста заставила весь зал замереть в внимании.",
            pos = "noun", semanticGroup = "music_l3_theory", fillInBlankExclusions = listOf(40201L, 40202L, 40205L)),

        WordEntity(id = 40204, setId = 402, languagePair = "en-ru", rarity = "RARE",
            original = "atonal", transliteration = "[eɪˈtoʊnəl]", translation = "атональный (без главной тональности)",
            definition = "Made without a main key — no single note feels like the home base.",
            definitionNative = "Написанный без главной тональности — ни одна нота не звучит как «домашняя».",
            example = "Schoenberg's atonal pieces shocked audiences used to clear major and minor.",
            exampleNative = "atonal сочинения Шёнберга шокировали слушателей, привыкших к ясному мажору и минору.",
            pos = "adjective", semanticGroup = "music_l3_theory"),

        WordEntity(id = 40205, setId = 402, languagePair = "en-ru", rarity = "RARE",
            original = "tonality", transliteration = "[toʊˈnæləti]", translation = "тональность (ладовая система)",
            definition = "The overall key system that gives a piece its sense of musical home.",
            definitionNative = "Общая ладовая система, дающая произведению ощущение музыкального «дома».",
            example = "Late Romantic composers stretched tonality almost to the breaking point.",
            exampleNative = "Поздние романтики растянули tonality почти до предела.",
            pos = "noun", semanticGroup = "music_l3_theory", fillInBlankExclusions = listOf(40201L, 40202L, 40203L)),

        // ── music_l3_performance (5) ──────────────────────────────────────

        WordEntity(id = 40206, setId = 402, languagePair = "en-ru", rarity = "RARE",
            original = "virtuoso", transliteration = "[ˌvərʧuˈoʊsoʊ]", translation = "виртуоз",
            definition = "A musician with extraordinary technical skill that few others can match.",
            definitionNative = "Музыкант с выдающейся техникой, какой почти никто не может повторить.",
            example = "The young violin virtuoso played a fiendishly difficult Paganini caprice.",
            exampleNative = "Юный virtuoso скрипки сыграл дьявольски сложный каприс Паганини.",
            pos = "noun", semanticGroup = "music_l3_performance", fillInBlankExclusions = listOf(40207L, 40208L, 40209L, 40210L)),

        WordEntity(id = 40207, setId = 402, languagePair = "en-ru", rarity = "RARE",
            original = "maestro", transliteration = "[ˈmaɪstroʊ]", translation = "маэстро (уважительно о дирижёре или мастере)",
            definition = "A respectful name for a great conductor or a senior musical master.",
            definitionNative = "Уважительное обращение к великому дирижёру или старшему музыкальному мастеру.",
            example = "The orchestra rose to greet the maestro as he walked onto the stage.",
            exampleNative = "Оркестр встал, чтобы приветствовать maestro, когда тот вышел на сцену.",
            pos = "noun", semanticGroup = "music_l3_performance", fillInBlankExclusions = listOf(40206L, 40208L, 40209L, 40210L)),

        WordEntity(id = 40208, setId = 402, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "setlist", transliteration = "[ˈsɛtˌlɪst]", translation = "сет-лист (порядок песен на концерте)",
            definition = "The written order of songs that a band plans to play during a show.",
            definitionNative = "Записанный порядок песен, которые группа планирует сыграть на концерте.",
            example = "The drummer taped the night's setlist to the floor by his kit.",
            exampleNative = "Барабанщик приклеил вечерний setlist к полу рядом со своей установкой.",
            pos = "noun", semanticGroup = "music_l3_performance", fillInBlankExclusions = listOf(40206L, 40207L, 40209L, 40210L)),

        WordEntity(id = 40209, setId = 402, languagePair = "en-ru", rarity = "RARE",
            original = "busking", transliteration = "[ˈbʌskɪŋ]", translation = "уличное музицирование за чаевые",
            definition = "Playing music in public places to entertain passers-by and collect tips.",
            definitionNative = "Игра на публике в людных местах, чтобы развлекать прохожих и собирать чаевые.",
            example = "He paid his way through college by busking outside the metro station.",
            exampleNative = "Он оплачивал учёбу через busking у выхода из метро.",
            pos = "noun", semanticGroup = "music_l3_performance", fillInBlankExclusions = listOf(40206L, 40207L, 40208L, 40210L)),

        WordEntity(id = 40210, setId = 402, languagePair = "en-ru", rarity = "RARE",
            original = "frontman", transliteration = "[ˈfrʌntˌmæn]", translation = "фронтмен (главный солист группы)",
            definition = "The lead singer who is the public face of a rock or pop band.",
            definitionNative = "Главный вокалист, который является публичным лицом рок- или поп-группы.",
            example = "The charismatic frontman whipped the crowd into a frenzy.",
            exampleNative = "Харизматичный frontman довёл толпу до неистовства.",
            pos = "noun", semanticGroup = "music_l3_performance", fillInBlankExclusions = listOf(40206L, 40207L, 40208L, 40209L)),

        // ── music_l3_production (5) ───────────────────────────────────────

        WordEntity(id = 40211, setId = 402, languagePair = "en-ru", rarity = "RARE",
            original = "mastering", transliteration = "[ˈmæstərɪŋ]", translation = "мастеринг (финальная обработка записи)",
            definition = "The last polishing stage that prepares mixed tracks for streaming or release.",
            definitionNative = "Заключительный этап шлифовки, готовящий сведённые треки к стримингу или релизу.",
            example = "After mastering, every song on the album felt warmer and louder.",
            exampleNative = "После mastering каждая песня альбома стала теплее и громче.",
            pos = "noun", semanticGroup = "music_l3_production", fillInBlankExclusions = listOf(40212L, 40213L, 40214L, 40215L)),

        WordEntity(id = 40212, setId = 402, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "mixing", transliteration = "[ˈmɪksɪŋ]", translation = "сведение (балансировка дорожек)",
            definition = "The studio stage where separate tracks are blended into one balanced song.",
            definitionNative = "Студийный этап, на котором отдельные дорожки сводят в одну сбалансированную песню.",
            example = "She spent three days mixing the drums before she was happy.",
            exampleNative = "Она потратила три дня на mixing барабанов, прежде чем осталась довольна.",
            pos = "noun", semanticGroup = "music_l3_production", fillInBlankExclusions = listOf(40211L, 40213L, 40214L, 40215L)),

        WordEntity(id = 40213, setId = 402, languagePair = "en-ru", rarity = "RARE",
            original = "overdub", transliteration = "[ˈoʊvərˌdʌb]", translation = "оверда́б (наложение дорожки поверх готовой)",
            definition = "An extra recorded layer added on top of tracks that are already laid down.",
            definitionNative = "Дополнительный записанный слой, наложенный поверх уже готовых дорожек.",
            example = "He added a quiet guitar overdub to thicken the chorus.",
            exampleNative = "Он добавил тихий гитарный overdub, чтобы уплотнить припев.",
            pos = "noun", semanticGroup = "music_l3_production", fillInBlankExclusions = listOf(40211L, 40212L, 40214L, 40215L)),

        WordEntity(id = 40214, setId = 402, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "sampling", transliteration = "[ˈsæmplɪŋ]", translation = "сэмплинг (взятие фрагмента чужой записи)",
            definition = "Taking a short piece of an existing recording to reuse inside a new song.",
            definitionNative = "Взятие короткого фрагмента уже существующей записи и его повторное использование в новой песне.",
            example = "Hip-hop producers built whole genres around clever sampling of old soul records.",
            exampleNative = "Хип-хоп продюсеры построили целые жанры на умелом sampling старых соул-пластинок.",
            pos = "noun", semanticGroup = "music_l3_production", fillInBlankExclusions = listOf(40211L, 40212L, 40213L, 40215L)),

        WordEntity(id = 40215, setId = 402, languagePair = "en-ru", rarity = "RARE",
            original = "multitrack", transliteration = "[ˈmʌltiˌtræk]", translation = "многодорожечная запись",
            definition = "A studio recording made on many separate tracks so each part can be edited alone.",
            definitionNative = "Студийная запись на многих отдельных дорожках, где каждую партию можно править отдельно.",
            example = "The original Beatles multitrack tapes are still studied by producers today.",
            exampleNative = "Оригинальные multitrack ленты The Beatles до сих пор изучают продюсеры.",
            pos = "noun", semanticGroup = "music_l3_production", fillInBlankExclusions = listOf(40211L, 40212L, 40213L, 40214L)),

        // ── music_l3_genres_advanced (5) ──────────────────────────────────

        WordEntity(id = 40216, setId = 402, languagePair = "en-ru", rarity = "RARE",
            original = "bossa nova", transliteration = "[ˈbɑsə ˈnoʊvə]", translation = "босса-нова (бразильский гитарный стиль)",
            definition = "A soft Brazilian style mixing samba rhythm with cool, jazz-flavoured guitar.",
            definitionNative = "Мягкий бразильский стиль, соединяющий ритм самбы с прохладной, джазовой гитарой.",
            example = "The cafe played gentle bossa nova all through the rainy afternoon.",
            exampleNative = "В кафе весь дождливый день играла нежная bossa nova.",
            pos = "noun", semanticGroup = "music_l3_genres_advanced", fillInBlankExclusions = listOf(40217L, 40218L, 40219L, 40220L)),

        WordEntity(id = 40217, setId = 402, languagePair = "en-ru", rarity = "RARE",
            original = "bluegrass", transliteration = "[ˈbluˌɡræs]", translation = "блюграсс (американский кантри-стиль)",
            definition = "A fast American country style played on banjo, fiddle and acoustic guitar.",
            definitionNative = "Быстрый американский кантри-стиль, исполняемый на банджо, скрипке и акустической гитаре.",
            example = "The bluegrass band drove the dancers wild with their breakneck tempo.",
            exampleNative = "Группа bluegrass довела танцующих до восторга своим бешеным темпом.",
            pos = "noun", semanticGroup = "music_l3_genres_advanced", fillInBlankExclusions = listOf(40216L, 40218L, 40219L, 40220L)),

        WordEntity(id = 40218, setId = 402, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "gospel", transliteration = "[ˈɡɑspəl]", translation = "госпел (духовная негритянская музыка)",
            definition = "Powerful Christian song style born in Black American churches in the South.",
            definitionNative = "Мощный стиль христианского пения, родившийся в чернокожих церквях американского Юга.",
            example = "The choir sang gospel with such joy that the whole church stood up.",
            exampleNative = "Хор пел gospel с такой радостью, что встала вся церковь.",
            pos = "noun", semanticGroup = "music_l3_genres_advanced", fillInBlankExclusions = listOf(40216L, 40217L, 40219L, 40220L)),

        WordEntity(id = 40219, setId = 402, languagePair = "en-ru", rarity = "RARE",
            original = "prog rock", transliteration = "[prɑɡ rɑk]", translation = "прог-рок (сложный экспериментальный рок)",
            definition = "A complex rock style with long songs, odd time signatures and ambitious themes.",
            definitionNative = "Сложный рок-стиль с длинными композициями, необычными размерами и амбициозными темами.",
            example = "Their twenty-minute prog rock epic told a strange tale about robots.",
            exampleNative = "Их двадцатиминутный prog rock эпос рассказывал странную историю про роботов.",
            pos = "noun", semanticGroup = "music_l3_genres_advanced", fillInBlankExclusions = listOf(40216L, 40217L, 40218L, 40220L)),

        WordEntity(id = 40220, setId = 402, languagePair = "en-ru", rarity = "RARE",
            original = "shoegaze", transliteration = "[ˈʃuˌɡeɪz]", translation = "шугейз (туманный гитарный стиль с эффектами)",
            definition = "A foggy guitar style where vocals drown inside thick walls of noisy effects.",
            definitionNative = "Туманный гитарный стиль, в котором вокал тонет в плотных стенах шумовых эффектов.",
            example = "The dreamy shoegaze track buried the singer's voice under layers of reverb.",
            exampleNative = "Мечтательный shoegaze трек хоронил голос певицы под слоями реверберации.",
            pos = "noun", semanticGroup = "music_l3_genres_advanced", fillInBlankExclusions = listOf(40216L, 40217L, 40218L, 40219L)),

        // ── music_l3_critique (5) ─────────────────────────────────────────

        WordEntity(id = 40221, setId = 402, languagePair = "en-ru", rarity = "RARE",
            original = "pitch-perfect", transliteration = "[pɪʧ ˈpərfɪkt]", translation = "с идеально чистым звуковысотным слухом",
            definition = "Always able to sing or play exactly the right note without any wobble.",
            definitionNative = "Всегда способный петь или играть точно правильную ноту, без колебаний.",
            example = "Her pitch-perfect a cappella opening silenced the chatty audience.",
            exampleNative = "Её pitch-perfect открытие а капелла заставило болтливый зал затихнуть.",
            pos = "adjective", semanticGroup = "music_l3_critique", fillInBlankExclusions = listOf(40222L, 40223L, 40225L)),

        WordEntity(id = 40222, setId = 402, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "off-key", transliteration = "[ɔf ki]", translation = "фальшиво / не в ноту",
            definition = "Sung or played at the wrong note so that it sounds painfully wrong.",
            definitionNative = "Спетый или сыгранный неверной нотой, так что звучит мучительно неправильно.",
            example = "The drunk uncle's off-key karaoke made everyone wince.",
            exampleNative = "Пьяное off-key караоке дядюшки заставляло всех морщиться.",
            pos = "adjective", semanticGroup = "music_l3_critique", fillInBlankExclusions = listOf(40221L, 40223L, 40225L)),

        WordEntity(id = 40223, setId = 402, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "in tune", transliteration = "[ɪn tun]", translation = "в строю / точно по нотам",
            definition = "Singing or playing the exact right notes that match the rest of the music.",
            definitionNative = "Поющий или играющий именно те ноты, которые точно совпадают с остальной музыкой.",
            example = "Make sure the guitar is in tune before the band starts playing.",
            exampleNative = "Убедись, что гитара in tune, до того как группа начнёт играть.",
            pos = "adjective", semanticGroup = "music_l3_critique", fillInBlankExclusions = listOf(40221L, 40222L, 40225L)),

        WordEntity(id = 40224, setId = 402, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "earworm", transliteration = "[ˈɪrˌwərm]", translation = "навязчивая мелодия / прилипчивый мотив",
            definition = "A catchy tune that gets stuck in your head and keeps replaying for hours.",
            definitionNative = "Привязчивая мелодия, которая застревает в голове и крутится часами.",
            example = "That silly jingle became a real earworm that nobody could shake.",
            exampleNative = "Этот глупый джингл стал настоящим earworm, от которого никто не мог избавиться.",
            pos = "noun", semanticGroup = "music_l3_critique"),

        WordEntity(id = 40225, setId = 402, languagePair = "en-ru", rarity = "RARE",
            original = "technically flawless", transliteration = "[ˈtɛknɪkli ˈflɔləs]", translation = "технически безупречный",
            definition = "Performed with such precision that no mistake of skill can be heard.",
            definitionNative = "Исполненный с такой точностью, что не слышно ни одной технической ошибки.",
            example = "The young pianist's technically flawless reading still felt cold to many critics.",
            exampleNative = "technically flawless исполнение юного пианиста многим критикам всё равно показалось холодным.",
            pos = "adjective", semanticGroup = "music_l3_critique", fillInBlankExclusions = listOf(40221L, 40222L, 40223L)),
    )
}
