package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Музыка (L1, COMMON+UNCOMMON).
 *
 * Set 400: «Музыка» — основы.
 *          Базовая лексика A1-A2 о музыке: звуки, инструменты, жанры,
 *          действия и люди. Слова, которые встречаются в наушниках,
 *          на афишах концертов и в обычных разговорах «что слушаешь».
 *
 * Тема пересекается с несколькими существующими наборами: set 23 «Искусство»
 * (где живут concert, opera, rhythm, stage, composer, orchestra, rehearse),
 * set 33 «Развлечения и досуг» (festival, stream, playlist), set 205 «Music»
 * в WordDataEnglishExpanded (melody, chord, lyrics, conductor, solo, cello,
 * duet), set 238 (music, song), CultureL1 (guitar, piano, violin, drum,
 * flute, album, vinyl, chorus). А также базовые глаголы listen/play/sing
 * заняты в WordDataEnglish/Holidays/Batch8. Поэтому все 25 слов этого сета
 * не пересекаются с существующими английскими словами в базе (проверено
 * grep'ом по `original = "..."`). Пришлось обойти базовые лексемы (music,
 * song, sing, play, listen, guitar, piano, drum, violin, flute, rock, jazz,
 * classical, pop, country, singer, artist, fan, perform, album, melody,
 * chord, lyrics, concert, rhythm, stage, composer, orchestra) и взять
 * смежные понятия того же уровня — tune, beat, note, hit, bass, harp,
 * trumpet, saxophone, tambourine, hip-hop, rap, blues, folk, disco, hum,
 * whistle, bop, strum, encore, musician, band, drummer, pianist, dj.
 *
 * Распределение редкости: 18 COMMON + 7 UNCOMMON — два смежных уровня (A1 + A2).
 *
 * SemanticGroups (5 × 5):
 *   music_l1_basic       — sound, tune, beat, note, hit
 *   music_l1_instruments — bass, harp, trumpet, saxophone, tambourine
 *   music_l1_genres      — hip-hop, rap, blues, folk, disco
 *   music_l1_actions     — hum, whistle, bop, strum, encore
 *   music_l1_people      — musician, band, drummer, pianist, dj
 *
 * Word IDs: setId × 100 + position (40001..40025).
 *
 * isFillInBlankSafe = false на всех словах. fillInBlankExclusions пустые —
 * заполнятся через FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataEnglishMusicL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 400,
            languagePair = "en-ru",
            orderIndex = 400,
            name = "Музыка",
            description = "Звуки, инструменты, жанры и базовые слова о музыке",
            topic = "Музыка",
            level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 400 — Музыка: основы (L1, COMMON+UNCOMMON)                   ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── music_l1_basic (5) ────────────────────────────────────────────

        WordEntity(id = 40001, setId = 400, languagePair = "en-ru", rarity = "COMMON",
            original = "sound", transliteration = "[saʊnd]", translation = "звук",
            definition = "Anything you hear with your ears — voices, music or noises around you.",
            definitionNative = "Всё, что слышишь ушами — голоса, музыку или шумы вокруг.",
            example = "I love the sound of rain on the roof at night.",
            exampleNative = "Я люблю sound дождя по крыше ночью.",
            pos = "noun", semanticGroup = "music_l1_basic", fillInBlankExclusions = listOf(40002L, 40003L, 40004L, 40005L)),

        WordEntity(id = 40002, setId = 400, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "tune", transliteration = "[tun]", translation = "мотив / мелодия",
            definition = "A short series of musical notes that is easy to remember and hum.",
            definitionNative = "Короткая последовательность нот, которую легко запомнить и напеть.",
            example = "She can't get that catchy tune out of her head.",
            exampleNative = "Она не может выкинуть эту привязчивую tune из головы.",
            pos = "noun", semanticGroup = "music_l1_basic", fillInBlankExclusions = listOf(40001L, 40003L, 40004L, 40005L)),

        WordEntity(id = 40003, setId = 400, languagePair = "en-ru", rarity = "COMMON",
            original = "beat", transliteration = "[bit]", translation = "бит / ритм",
            definition = "The steady pulse you tap your foot to when listening to a song.",
            definitionNative = "Ровный пульс, под который притопываешь ногой, слушая песню.",
            example = "This song has a strong beat — perfect for the gym.",
            exampleNative = "У этой песни мощный beat — идеально для зала.",
            pos = "noun", semanticGroup = "music_l1_basic", fillInBlankExclusions = listOf(40001L, 40002L, 40004L, 40005L, 40006L)),

        WordEntity(id = 40004, setId = 400, languagePair = "en-ru", rarity = "COMMON",
            original = "note", transliteration = "[noʊt]", translation = "нота",
            definition = "One single sound in a piece of music — high, low or somewhere between.",
            definitionNative = "Один отдельный звук в музыке — высокий, низкий или средний.",
            example = "He hit a high note that surprised everyone in the room.",
            exampleNative = "Он взял высокий note, чем удивил всех в зале.",
            pos = "noun", semanticGroup = "music_l1_basic", fillInBlankExclusions = listOf(40001L, 40002L, 40003L)),

        WordEntity(id = 40005, setId = 400, languagePair = "en-ru", rarity = "COMMON",
            original = "hit", transliteration = "[hɪt]", translation = "хит",
            definition = "A song that becomes very popular and is loved by many people.",
            definitionNative = "Песня, которая становится очень популярной и нравится многим.",
            example = "Her new song was a huge hit on the radio last summer.",
            exampleNative = "Её новая песня стала огромным hit на радио прошлым летом.",
            pos = "noun", semanticGroup = "music_l1_basic", fillInBlankExclusions = listOf(40001L, 40002L, 40003L, 40004L)),

        // ── music_l1_instruments (5) ──────────────────────────────────────

        WordEntity(id = 40006, setId = 400, languagePair = "en-ru", rarity = "COMMON",
            original = "bass", transliteration = "[beɪs]", translation = "бас-гитара",
            definition = "A big stringed instrument with a deep, low sound — common in rock bands.",
            definitionNative = "Большой струнный инструмент с глубоким низким звуком — частый в рок-группах.",
            example = "He plays bass in a small jazz band on weekends.",
            exampleNative = "Он играет на bass в маленькой джазовой группе по выходным.",
            pos = "noun", semanticGroup = "music_l1_instruments", fillInBlankExclusions = listOf(40007L, 40008L, 40009L, 40010L)),

        WordEntity(id = 40007, setId = 400, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "harp", transliteration = "[hɑrp]", translation = "арфа",
            definition = "A tall instrument with many strings — the player plucks them with fingers.",
            definitionNative = "Высокий инструмент со множеством струн — на нём перебирают пальцами.",
            example = "She played the harp at her sister's wedding.",
            exampleNative = "Она играла на harp на свадьбе своей сестры.",
            pos = "noun", semanticGroup = "music_l1_instruments", fillInBlankExclusions = listOf(40006L, 40008L, 40009L, 40010L)),

        WordEntity(id = 40008, setId = 400, languagePair = "en-ru", rarity = "COMMON",
            original = "trumpet", transliteration = "[ˈtrʌmpət]", translation = "труба",
            definition = "A shiny brass instrument you blow into — it makes a bright, loud sound.",
            definitionNative = "Блестящий медный инструмент, в который дуют — даёт яркий громкий звук.",
            example = "My son wants to learn the trumpet at school next year.",
            exampleNative = "Мой сын хочет учиться играть на trumpet в школе со следующего года.",
            pos = "noun", semanticGroup = "music_l1_instruments", fillInBlankExclusions = listOf(40006L, 40007L, 40009L, 40010L)),

        WordEntity(id = 40009, setId = 400, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "saxophone", transliteration = "[ˈsæksəˌfoʊn]", translation = "саксофон",
            definition = "A curved metal instrument with keys — famous in jazz for its smooth voice.",
            definitionNative = "Изогнутый металлический инструмент с клапанами — звучит мягко в джазе.",
            example = "The saxophone solo in this song is just amazing.",
            exampleNative = "Соло на saxophone в этой песне просто потрясающее.",
            pos = "noun", semanticGroup = "music_l1_instruments", fillInBlankExclusions = listOf(40006L, 40007L, 40008L, 40010L)),

        WordEntity(id = 40010, setId = 400, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "tambourine", transliteration = "[ˌtæmbəˈrin]", translation = "бубен",
            definition = "A small round frame with little metal disks that jingle when you shake it.",
            definitionNative = "Маленький круглый обод с металлическими дисками — звенит, когда трясёшь.",
            example = "The little girl shook a tambourine along with the song.",
            exampleNative = "Маленькая девочка трясла tambourine в такт песне.",
            pos = "noun", semanticGroup = "music_l1_instruments", fillInBlankExclusions = listOf(40006L, 40007L, 40008L, 40009L)),

        // ── music_l1_genres (5) ───────────────────────────────────────────

        WordEntity(id = 40011, setId = 400, languagePair = "en-ru", rarity = "COMMON",
            original = "hip-hop", transliteration = "[ˈhɪpˌhɑp]", translation = "хип-хоп",
            definition = "A style with strong beats and rhymed words — born on US city streets.",
            definitionNative = "Стиль с мощными битами и рифмованными словами — родился на улицах США.",
            example = "My teenage son listens to hip-hop all day long.",
            exampleNative = "Мой сын-подросток слушает hip-hop целыми днями.",
            pos = "noun", semanticGroup = "music_l1_genres", fillInBlankExclusions = listOf(40012L, 40013L, 40014L, 40015L)),

        WordEntity(id = 40012, setId = 400, languagePair = "en-ru", rarity = "COMMON",
            original = "rap", transliteration = "[ræp]", translation = "рэп",
            definition = "A style where words are spoken fast in rhyme over a strong beat.",
            definitionNative = "Стиль, где слова быстро проговариваются в рифму под мощный бит.",
            example = "He started writing rap lyrics when he was just twelve.",
            exampleNative = "Он начал писать тексты для rap, когда ему было всего двенадцать.",
            pos = "noun", semanticGroup = "music_l1_genres", fillInBlankExclusions = listOf(40011L, 40013L, 40014L, 40015L)),

        WordEntity(id = 40013, setId = 400, languagePair = "en-ru", rarity = "COMMON",
            original = "blues", transliteration = "[bluz]", translation = "блюз",
            definition = "A slow, sad style with deep feelings — born among Black workers in the South.",
            definitionNative = "Медленный, грустный стиль с глубокими чувствами — родился у чернокожих рабочих Юга.",
            example = "My dad puts on old blues records every Sunday morning.",
            exampleNative = "Мой папа ставит старые пластинки blues каждое воскресное утро.",
            pos = "noun", semanticGroup = "music_l1_genres", fillInBlankExclusions = listOf(40011L, 40012L, 40014L, 40015L)),

        WordEntity(id = 40014, setId = 400, languagePair = "en-ru", rarity = "COMMON",
            original = "folk", transliteration = "[foʊk]", translation = "фолк / народная музыка",
            definition = "Traditional songs of ordinary people — usually with a guitar and simple words.",
            definitionNative = "Традиционные песни простых людей — обычно с гитарой и простыми словами.",
            example = "We sat by the fire and sang old folk songs together.",
            exampleNative = "Мы сидели у костра и пели вместе старые песни folk.",
            pos = "noun", semanticGroup = "music_l1_genres", fillInBlankExclusions = listOf(40011L, 40012L, 40013L, 40015L)),

        WordEntity(id = 40015, setId = 400, languagePair = "en-ru", rarity = "COMMON",
            original = "disco", transliteration = "[ˈdɪskoʊ]", translation = "диско",
            definition = "Lively dance music from the seventies — flashing lights and a strong beat.",
            definitionNative = "Бойкая танцевальная музыка из семидесятых — мигающий свет и сильный бит.",
            example = "My parents met at a disco party back in 1978.",
            exampleNative = "Мои родители познакомились на disco-вечеринке ещё в 1978-м.",
            pos = "noun", semanticGroup = "music_l1_genres", fillInBlankExclusions = listOf(40011L, 40012L, 40013L, 40014L)),

        // ── music_l1_actions (5) ──────────────────────────────────────────

        WordEntity(id = 40016, setId = 400, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "hum", transliteration = "[hʌm]", translation = "напевать",
            definition = "To make a soft musical sound with closed lips — without using words.",
            definitionNative = "Издавать тихий музыкальный звук с закрытыми губами — без слов.",
            example = "Grandma likes to hum old songs while she cooks dinner.",
            exampleNative = "Бабушка любит hum старые песни, пока готовит ужин.",
            pos = "verb", semanticGroup = "music_l1_actions", fillInBlankExclusions = listOf(40017L, 40018L, 40019L)),

        WordEntity(id = 40017, setId = 400, languagePair = "en-ru", rarity = "COMMON",
            original = "whistle", transliteration = "[ˈwɪsəl]", translation = "свистеть",
            definition = "To make a high musical sound by blowing air through your shaped lips.",
            definitionNative = "Издавать высокий музыкальный звук, дуя сквозь сложенные губы.",
            example = "He likes to whistle a happy song on his way to work.",
            exampleNative = "Он любит whistle весёлую песенку по дороге на работу.",
            pos = "verb", semanticGroup = "music_l1_actions", fillInBlankExclusions = listOf(40016L, 40018L, 40019L)),

        WordEntity(id = 40018, setId = 400, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "bop", transliteration = "[bɑp]", translation = "пританцовывать",
            definition = "To move your head or body lightly along with music you enjoy.",
            definitionNative = "Слегка двигать головой или телом в такт музыке, которая нравится.",
            example = "The kids started to bop as soon as the song came on.",
            exampleNative = "Дети начали bop, как только заиграла песня.",
            pos = "verb", semanticGroup = "music_l1_actions", fillInBlankExclusions = listOf(40016L, 40017L, 40019L)),

        WordEntity(id = 40019, setId = 400, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "strum", transliteration = "[strʌm]", translation = "бренчать",
            definition = "To brush your fingers across guitar strings to make a soft chord.",
            definitionNative = "Провести пальцами по струнам гитары, чтобы получить мягкий аккорд.",
            example = "He likes to strum his guitar quietly on the back porch.",
            exampleNative = "Он любит strum на гитаре тихо на заднем крыльце.",
            pos = "verb", semanticGroup = "music_l1_actions", fillInBlankExclusions = listOf(40016L, 40017L, 40018L)),

        WordEntity(id = 40020, setId = 400, languagePair = "en-ru", rarity = "COMMON",
            original = "encore", transliteration = "[ˈɑnˌkɔr]", translation = "выход на бис",
            definition = "An extra song the band plays at the end when fans cheer for more.",
            definitionNative = "Дополнительная песня в конце концерта, которую играют по просьбе зрителей.",
            example = "The crowd kept clapping until the band played one more encore.",
            exampleNative = "Толпа хлопала, пока группа не сыграла ещё один encore.",
            pos = "noun", semanticGroup = "music_l1_actions", fillInBlankExclusions = listOf(40002L, 40004L, 40005L)),

        // ── music_l1_people (5) ───────────────────────────────────────────

        WordEntity(id = 40021, setId = 400, languagePair = "en-ru", rarity = "COMMON",
            original = "musician", transliteration = "[mjuˈzɪʃən]", translation = "музыкант",
            definition = "A person whose job or hobby is to play instruments or sing.",
            definitionNative = "Человек, чья работа или хобби — играть на инструментах или петь.",
            example = "My uncle is a talented musician who plays five instruments.",
            exampleNative = "Мой дядя — талантливый musician, играет на пяти инструментах.",
            pos = "noun", semanticGroup = "music_l1_people", fillInBlankExclusions = listOf(40022L, 40023L, 40024L, 40025L)),

        WordEntity(id = 40022, setId = 400, languagePair = "en-ru", rarity = "COMMON",
            original = "band", transliteration = "[bænd]", translation = "группа",
            definition = "A small group of people who play music together — usually three to six.",
            definitionNative = "Небольшая группа людей, которые играют музыку вместе — обычно три-шесть человек.",
            example = "Their band practices in the garage every Friday evening.",
            exampleNative = "Их band репетирует в гараже каждый вечер пятницы.",
            pos = "noun", semanticGroup = "music_l1_people", fillInBlankExclusions = listOf(40021L, 40023L, 40024L, 40025L)),

        WordEntity(id = 40023, setId = 400, languagePair = "en-ru", rarity = "COMMON",
            original = "drummer", transliteration = "[ˈdrʌmər]", translation = "барабанщик",
            definition = "The person in a band who keeps the beat by hitting drums and cymbals.",
            definitionNative = "Человек в группе, который держит ритм, ударяя по барабанам и тарелкам.",
            example = "Their new drummer is the best they've ever had.",
            exampleNative = "Их новый drummer — лучший, который у них когда-либо был.",
            pos = "noun", semanticGroup = "music_l1_people", fillInBlankExclusions = listOf(40021L, 40022L, 40024L, 40025L)),

        WordEntity(id = 40024, setId = 400, languagePair = "en-ru", rarity = "COMMON",
            original = "pianist", transliteration = "[piˈænɪst]", translation = "пианист",
            definition = "A person who plays the piano — at home, on stage or in a small bar.",
            definitionNative = "Человек, который играет на пианино — дома, на сцене или в маленьком баре.",
            example = "The pianist at the hotel bar plays old jazz every night.",
            exampleNative = "Pianist в баре отеля играет старый джаз каждый вечер.",
            pos = "noun", semanticGroup = "music_l1_people", fillInBlankExclusions = listOf(40021L, 40022L, 40023L, 40025L)),

        WordEntity(id = 40025, setId = 400, languagePair = "en-ru", rarity = "COMMON",
            original = "dj", transliteration = "[ˈdiˈʤeɪ]", translation = "диджей",
            definition = "A person who chooses and mixes songs at parties, on radio or in clubs.",
            definitionNative = "Человек, который выбирает и сводит песни на вечеринках, радио или в клубах.",
            example = "The dj at the wedding played all our favorite songs.",
            exampleNative = "Dj на свадьбе ставил все наши любимые песни.",
            pos = "noun", semanticGroup = "music_l1_people", fillInBlankExclusions = listOf(40021L, 40022L, 40023L, 40024L)),
    )
}
