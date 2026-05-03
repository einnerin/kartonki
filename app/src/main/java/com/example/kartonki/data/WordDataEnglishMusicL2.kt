package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Музыка (L2, UNCOMMON+RARE).
 *
 * Set 401: «Музыка» — продвинутый уровень.
 *          Теория (scale, key, octave, notation, interval), техники
 *          (improvise, accompany, compose, arrange, conduct), настроение
 *          трека (uplifting, energetic, soothing, dreamy, mellow), индустрия
 *          (record label, studio, agent, royalties, gigging) и стили
 *          (electronic, instrumental, vocal, ambient, ensemble) уровня
 *          A2-B2 (UNCOMMON+RARE). Не пересекается с L1 (set 400) и со
 *          старыми «music/arts» сетами (23 «Искусство» — concert/opera/
 *          rhythm/stage/composer/orchestra/rehearse/score, 205 «Music»
 *          Expanded — melody/chord/harmony/lyrics/conductor/solo/cello/
 *          duet/tempo/acoustic/symphony/percussion/crescendo/timbre/
 *          dissonance/cadence/counterpoint/vibrato/syncopation/overture/
 *          soprano/trombone/rehearsal, CultureL1 — guitar/piano/violin/
 *          drum/flute/album/vinyl/chorus, 60 — haunting, EmotionsL4 —
 *          melancholy, set 22 — manager).
 *
 * Распределение редкости: 17 UNCOMMON + 8 RARE — два смежных уровня
 * (A2-B1 + B2).
 *
 * SemanticGroups (5 × 5):
 *   music_l2_theory     — scale, key, octave, notation, interval
 *   music_l2_techniques — improvise, accompany, compose, arrange, conduct
 *   music_l2_mood       — uplifting, energetic, soothing, dreamy, mellow
 *   music_l2_industry   — record label, studio, agent, royalties, gigging
 *   music_l2_styles     — electronic, instrumental, vocal, ambient, ensemble
 *
 * Word IDs: setId × 100 + position (40101..40125).
 *
 * fillInBlankExclusions / isFillInBlankSafe не задаются — заполнятся через
 * FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataEnglishMusicL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 401,
            languagePair = "en-ru",
            orderIndex = 401,
            name = "Музыка",
            description = "Теория, техники, настроение, индустрия и стили",
            topic = "Музыка",
            level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 401 — Музыка: продвинутый (L2, UNCOMMON+RARE)                ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── music_l2_theory (5) ───────────────────────────────────────────

        WordEntity(id = 40101, setId = 401, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "scale", transliteration = "[skeɪl]", translation = "гамма (звукоряд)",
            definition = "A row of notes that go up or down step by step inside one key.",
            definitionNative = "Ряд нот, идущих вверх или вниз по шагам внутри одной тональности.",
            example = "Every morning she practises a slow scale on the piano before breakfast.",
            exampleNative = "Каждое утро она играет медленный scale на пианино перед завтраком.",
            pos = "noun", semanticGroup = "music_l2_theory", fillInBlankExclusions = listOf(40102L, 40103L, 40104L, 40105L)),

        WordEntity(id = 40102, setId = 401, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "key", transliteration = "[ki]", translation = "тональность",
            definition = "The main note that a piece of music is built around from start to end.",
            definitionNative = "Главная нота, вокруг которой построено музыкальное произведение от начала до конца.",
            example = "The whole song is in the key of D minor, which makes it sound sad.",
            exampleNative = "Вся песня в key ре минор, поэтому звучит грустно.",
            pos = "noun", semanticGroup = "music_l2_theory", fillInBlankExclusions = listOf(40101L, 40103L, 40104L, 40105L)),

        WordEntity(id = 40103, setId = 401, languagePair = "en-ru", rarity = "RARE",
            original = "octave", transliteration = "[ˈɑktɪv]", translation = "октава",
            definition = "The space between one note and the next note with the same name higher up.",
            definitionNative = "Расстояние между нотой и следующей нотой с тем же названием выше.",
            example = "His voice can jump a full octave without any effort at all.",
            exampleNative = "Его голос легко прыгает на целую octave без всяких усилий.",
            pos = "noun", semanticGroup = "music_l2_theory", fillInBlankExclusions = listOf(40101L, 40102L, 40104L, 40105L)),

        WordEntity(id = 40104, setId = 401, languagePair = "en-ru", rarity = "RARE",
            original = "notation", transliteration = "[noʊˈteɪʃən]", translation = "нотная запись",
            definition = "The system of written symbols used to put music on paper.",
            definitionNative = "Система письменных знаков, которыми музыку записывают на бумаге.",
            example = "She learned standard notation at music school when she was eight.",
            exampleNative = "Она освоила стандартную notation в музыкальной школе в восемь лет.",
            pos = "noun", semanticGroup = "music_l2_theory", fillInBlankExclusions = listOf(40101L, 40102L, 40103L, 40105L)),

        WordEntity(id = 40105, setId = 401, languagePair = "en-ru", rarity = "RARE",
            original = "interval", transliteration = "[ˈɪntərvəl]", translation = "интервал (между нотами)",
            definition = "The difference in pitch between two musical notes you compare.",
            definitionNative = "Разница в высоте между двумя сравниваемыми музыкальными нотами.",
            example = "The teacher asked the students to name the interval between the two notes.",
            exampleNative = "Учитель попросил студентов назвать interval между двумя нотами.",
            pos = "noun", semanticGroup = "music_l2_theory", fillInBlankExclusions = listOf(40101L, 40102L, 40103L, 40104L)),

        // ── music_l2_techniques (5) ───────────────────────────────────────

        WordEntity(id = 40106, setId = 401, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "improvise", transliteration = "[ˈɪmprəˌvaɪz]", translation = "импровизировать",
            definition = "To make up music on the spot without practising it first.",
            definitionNative = "Сочинять музыку прямо по ходу, не репетируя её заранее.",
            example = "Good jazz players can improvise for half an hour on a single tune.",
            exampleNative = "Хорошие джазмены могут improvise полчаса на одну мелодию.",
            pos = "verb", semanticGroup = "music_l2_techniques", fillInBlankExclusions = listOf(40107L, 40108L, 40109L, 40110L)),

        WordEntity(id = 40107, setId = 401, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "accompany", transliteration = "[əˈkʌmpəni]", translation = "аккомпанировать",
            definition = "To play an instrument quietly while another person sings or plays the main part.",
            definitionNative = "Играть на инструменте тихо, пока другой человек поёт или ведёт главную партию.",
            example = "Her brother will accompany her on the piano during the school concert.",
            exampleNative = "Её брат будет accompany ей на пианино во время школьного концерта.",
            pos = "verb", semanticGroup = "music_l2_techniques", fillInBlankExclusions = listOf(40106L, 40108L, 40109L, 40110L)),

        WordEntity(id = 40108, setId = 401, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "compose", transliteration = "[kəmˈpoʊz]", translation = "сочинять (музыку)",
            definition = "To write a new piece of music by choosing notes and putting them together.",
            definitionNative = "Создавать новое музыкальное произведение, подбирая ноты и складывая их вместе.",
            example = "He started to compose his own songs at the age of fourteen.",
            exampleNative = "Он начал compose свои песни в четырнадцать лет.",
            pos = "verb", semanticGroup = "music_l2_techniques", fillInBlankExclusions = listOf(40106L, 40107L, 40109L, 40110L)),

        WordEntity(id = 40109, setId = 401, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "arrange", transliteration = "[əˈreɪnʤ]", translation = "аранжировать",
            definition = "To rework an existing song so different instruments and voices can play it.",
            definitionNative = "Переделать готовую песню, чтобы её могли исполнить другие инструменты и голоса.",
            example = "She had to arrange the old folk tune for a small string quartet.",
            exampleNative = "Ей пришлось arrange старую народную мелодию для маленького струнного квартета.",
            pos = "verb", semanticGroup = "music_l2_techniques", fillInBlankExclusions = listOf(40106L, 40107L, 40108L, 40110L)),

        WordEntity(id = 40110, setId = 401, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "conduct", transliteration = "[kənˈdʌkt]", translation = "дирижировать",
            definition = "To stand in front of musicians and guide them with hand movements.",
            definitionNative = "Стоять перед музыкантами и руководить ими движениями рук.",
            example = "She will conduct the youth orchestra at the spring festival.",
            exampleNative = "Она будет conduct молодёжный оркестр на весеннем фестивале.",
            pos = "verb", semanticGroup = "music_l2_techniques", fillInBlankExclusions = listOf(40106L, 40107L, 40108L, 40109L)),

        // ── music_l2_mood (5) ─────────────────────────────────────────────

        WordEntity(id = 40111, setId = 401, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "uplifting", transliteration = "[ˌʌpˈlɪftɪŋ]", translation = "воодушевляющий",
            definition = "Making you feel happier and full of hope while you listen.",
            definitionNative = "Заставляющий чувствовать себя радостнее и полным надежды во время прослушивания.",
            example = "She made an uplifting playlist for her early morning runs.",
            exampleNative = "Она составила uplifting плейлист для утренних пробежек.",
            pos = "adjective", semanticGroup = "music_l2_mood", fillInBlankExclusions = listOf(40112L)),

        WordEntity(id = 40112, setId = 401, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "energetic", transliteration = "[ˌɛnərˈʤɛtɪk]", translation = "энергичный",
            definition = "Full of fast strong sound that gives you power to move and dance.",
            definitionNative = "Полный быстрого мощного звука, который даёт силы двигаться и танцевать.",
            example = "The DJ played an energetic set that kept everyone on the floor.",
            exampleNative = "Диджей поставил energetic сет, и все остались на танцполе.",
            pos = "adjective", semanticGroup = "music_l2_mood", fillInBlankExclusions = listOf(40111L)),

        WordEntity(id = 40113, setId = 401, languagePair = "en-ru", rarity = "RARE",
            original = "soothing", transliteration = "[ˈsuðɪŋ]", translation = "успокаивающий",
            definition = "Soft and slow in a way that helps you relax or fall asleep.",
            definitionNative = "Мягкий и медленный — так, что помогает расслабиться или уснуть.",
            example = "The soothing piano music helped the baby drift off to sleep.",
            exampleNative = "Soothing музыка пианино помогла малышу постепенно уснуть.",
            pos = "adjective", semanticGroup = "music_l2_mood", fillInBlankExclusions = listOf(40111L, 40112L, 40114L, 40115L)),

        WordEntity(id = 40114, setId = 401, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "dreamy", transliteration = "[ˈdrimi]", translation = "мечтательный",
            definition = "Soft, slow and a bit unreal — like the music heard in a daydream.",
            definitionNative = "Мягкий, медленный и немного нереальный — как музыка из дневной мечты.",
            example = "The film's dreamy soundtrack made the long flight feel shorter.",
            exampleNative = "Dreamy саундтрек фильма скрасил длинный перелёт.",
            pos = "adjective", semanticGroup = "music_l2_mood", fillInBlankExclusions = listOf(40111L, 40112L, 40113L, 40115L)),

        WordEntity(id = 40115, setId = 401, languagePair = "en-ru", rarity = "RARE",
            original = "mellow", transliteration = "[ˈmɛloʊ]", translation = "мягкий, неспешный",
            definition = "Smooth, calm and warm — never loud or sharp on the ears.",
            definitionNative = "Гладкий, спокойный и тёплый — никогда не громкий и не резкий для слуха.",
            example = "On Sundays they put on mellow tunes and read by the window.",
            exampleNative = "По воскресеньям они ставят mellow мелодии и читают у окна.",
            pos = "adjective", semanticGroup = "music_l2_mood", fillInBlankExclusions = listOf(40111L, 40112L, 40113L, 40114L)),

        // ── music_l2_industry (5) ─────────────────────────────────────────

        WordEntity(id = 40116, setId = 401, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "record label", transliteration = "[ˈrɛkərd ˈleɪbəl]", translation = "звукозаписывающая компания",
            definition = "A company that pays artists to make songs and then sells those songs.",
            definitionNative = "Компания, которая платит артистам за запись песен и потом эти песни продаёт.",
            example = "A small record label from Berlin signed the young singer last month.",
            exampleNative = "Маленький record label из Берлина подписал молодую певицу в прошлом месяце.",
            pos = "noun", semanticGroup = "music_l2_industry", fillInBlankExclusions = listOf(40117L, 40118L, 40119L, 40120L)),

        WordEntity(id = 40117, setId = 401, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "studio", transliteration = "[ˈstudiˌoʊ]", translation = "студия (звукозаписи)",
            definition = "A quiet room with special microphones where artists record their songs.",
            definitionNative = "Тихая комната со специальными микрофонами, где артисты записывают свои песни.",
            example = "The band spent six weeks in the studio finishing their second album.",
            exampleNative = "Группа провела шесть недель в studio, заканчивая второй альбом.",
            pos = "noun", semanticGroup = "music_l2_industry", fillInBlankExclusions = listOf(40116L, 40118L, 40119L, 40120L)),

        WordEntity(id = 40118, setId = 401, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "agent", transliteration = "[ˈeɪʤənt]", translation = "агент (артиста)",
            definition = "A person who finds work for an artist and signs deals on their behalf.",
            definitionNative = "Человек, который ищет работу артисту и заключает сделки от его имени.",
            example = "Her agent booked a small tour across three European cities.",
            exampleNative = "Её agent забронировал небольшой тур по трём европейским городам.",
            pos = "noun", semanticGroup = "music_l2_industry", fillInBlankExclusions = listOf(40116L, 40117L, 40119L, 40120L)),

        WordEntity(id = 40119, setId = 401, languagePair = "en-ru", rarity = "RARE",
            original = "royalties", transliteration = "[ˈrɔɪəltiz]", translation = "роялти (выплаты автору)",
            definition = "Money an artist gets every time their song is played, streamed or sold.",
            definitionNative = "Деньги, которые артист получает каждый раз, когда его песню играют, стримят или продают.",
            example = "He still earns royalties from a hit he wrote thirty years ago.",
            exampleNative = "Он до сих пор получает royalties за хит, который написал тридцать лет назад.",
            pos = "noun", semanticGroup = "music_l2_industry", fillInBlankExclusions = listOf(40116L, 40117L, 40118L, 40120L)),

        WordEntity(id = 40120, setId = 401, languagePair = "en-ru", rarity = "RARE",
            original = "gigging", transliteration = "[ˈɡɪɡɪŋ]", translation = "выступления по клубам",
            definition = "Playing one short paid show after another at small clubs and bars.",
            definitionNative = "Игра одного короткого платного выступления за другим в маленьких клубах и барах.",
            example = "She spent two hard years gigging in tiny pubs across the country.",
            exampleNative = "Она провела два тяжёлых года gigging в крошечных пабах по всей стране.",
            pos = "noun", semanticGroup = "music_l2_industry", fillInBlankExclusions = listOf(40116L, 40117L, 40118L, 40119L)),

        // ── music_l2_styles (5) ───────────────────────────────────────────

        WordEntity(id = 40121, setId = 401, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "electronic", transliteration = "[ɪˌlɛkˈtrɑnɪk]", translation = "электронный (стиль)",
            definition = "Made mostly with computers and synths instead of normal instruments.",
            definitionNative = "Сделанный в основном на компьютерах и синтезаторах, а не на обычных инструментах.",
            example = "He produces electronic music in his bedroom on a single laptop.",
            exampleNative = "Он делает electronic музыку в спальне на одном ноутбуке.",
            pos = "adjective", semanticGroup = "music_l2_styles", fillInBlankExclusions = listOf(40122L, 40123L, 40124L)),

        WordEntity(id = 40122, setId = 401, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "instrumental", transliteration = "[ˌɪnstrəˈmɛntəl]", translation = "инструментальный (без вокала)",
            definition = "A song with only instruments and no singing voice at all.",
            definitionNative = "Песня, в которой только инструменты и нет ни одного поющего голоса.",
            example = "The film opens with a long instrumental piece for solo guitar.",
            exampleNative = "Фильм открывается длинной instrumental пьесой для соло-гитары.",
            pos = "adjective", semanticGroup = "music_l2_styles", fillInBlankExclusions = listOf(40121L, 40123L, 40124L)),

        WordEntity(id = 40123, setId = 401, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "vocal", transliteration = "[ˈvoʊkəl]", translation = "вокальный (с голосом)",
            definition = "Made with singing voices instead of mostly instruments.",
            definitionNative = "Сделанный с поющими голосами, а не в основном с инструментами.",
            example = "The choir performed a stunning vocal piece without any backing music.",
            exampleNative = "Хор исполнил потрясающее vocal произведение без всякого аккомпанемента.",
            pos = "adjective", semanticGroup = "music_l2_styles", fillInBlankExclusions = listOf(40121L, 40122L, 40124L)),

        WordEntity(id = 40124, setId = 401, languagePair = "en-ru", rarity = "RARE",
            original = "ambient", transliteration = "[ˈæmbiənt]", translation = "эмбиент (фоновый)",
            definition = "A slow style with soft layers of sound made to sit in the background.",
            definitionNative = "Медленный стиль с мягкими слоями звука, созданный, чтобы оставаться на фоне.",
            example = "He plays quiet ambient tracks while painting in his small studio.",
            exampleNative = "Он включает тихий ambient во время рисования в своей маленькой мастерской.",
            pos = "adjective", semanticGroup = "music_l2_styles", fillInBlankExclusions = listOf(40121L, 40122L, 40123L)),

        WordEntity(id = 40125, setId = 401, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "ensemble", transliteration = "[ɑnˈsɑmbəl]", translation = "ансамбль (малая группа)",
            definition = "A small group of musicians who play together as one team.",
            definitionNative = "Небольшая группа музыкантов, которые играют вместе как одна команда.",
            example = "The string ensemble played softly during dinner at the wedding.",
            exampleNative = "Струнный ensemble играл тихо во время ужина на свадьбе.",
            pos = "noun", semanticGroup = "music_l2_styles"),
    )
}
