package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Музыка (L5, EPIC+LEGENDARY).
 *
 * Set 404: «Музыка» — носитель/архаика/музыковедение.
 *          Архаичные приёмы средневекового и ренессансного письма
 *          (ostinato, cantus firmus, hocket, organum, isorhythm),
 *          архаичные инструменты (sackbut, theorbo, hurdy-gurdy, shawm,
 *          virginal), академическое музыковедение (ethnomusicology,
 *          paleography, organology, musicology, neume), литературные
 *          описания звучания (plangent, sepulchral, dulcet, sonorous,
 *          elegiac) и редчайшие мировые жанры (gagaku, mbira, qanun,
 *          didgeridoo, throat singing).
 *
 * Тема «Музыка» — продолжение L1 (set 400), L2 (set 401), L3 (set 402).
 * L4 (set 403) — соседний уровень (B2-C1), создаётся в той же волне
 * параллельным агентом. Чтобы избежать дублей с L4, этот сет строго
 * придерживается LEGENDARY-уровня — устаревшие приёмы и инструменты,
 * академические дисциплины о музыке, литературные описания звучания,
 * редчайшие мировые традиции, — а не базовые/индустриальные термины.
 *
 * Все 25 слов этого сета не пересекаются ни с одним существующим
 * английским словом в базе (проверено grep по `original = "..."`).
 * В частности обойдены уже занятые слова: leitmotif (set 80, L5
 * EntertainmentL5), prosody (set 66), hermeneutics (Batch5),
 * hermeneutic (EducationL5), lugubrious/stentorian/mellifluous
 * (set 76), quotidian-производные (через esoteric/ineffable там же),
 * mellow (MusicL2), saudade (EmotionsL5), polyphony (set 239),
 * minimalism (Batch15), aleatory (set 78), atonal/fugue/cadenza/
 * virtuoso/maestro (MusicL3), dissonance/cadence/counterpoint/
 * vibrato/symphony/crescendo/timbre (set 205), composer/orchestra/
 * rhythm/opera/concert/conductor (set 23/205), gossamer (WeatherL5),
 * sibilance (Expanded), exegesis/hermeneutic (EducationL5).
 *
 * Распределение редкости: 17 LEGENDARY + 8 EPIC — два смежных уровня (C1 + C2+).
 *
 * SemanticGroups (5 × 5):
 *   music_l5_theory_advanced     — ostinato, cantus firmus, hocket, organum, isorhythm
 *   music_l5_archaic_instruments — sackbut, theorbo, hurdy-gurdy, shawm, virginal
 *   music_l5_musicology          — ethnomusicology, paleography, organology, musicology, neume
 *   music_l5_critic_advanced     — plangent, sepulchral, dulcet, sonorous, elegiac
 *   music_l5_obscure_genres      — gagaku, mbira, qanun, didgeridoo, throat singing
 *
 * Word IDs: setId × 100 + position (40401..40425).
 *
 * fillInBlankExclusions / isFillInBlankSafe — НЕ задаются здесь. Заполнятся
 * через FILL_IN_BLANK pipeline централизованно после wave (известный баг:
 * если выставить заранее, pipeline пропустит запись).
 */
object WordDataEnglishMusicL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 404,
            languagePair = "en-ru",
            orderIndex = 404,
            name = "Музыка",
            description = "Архаика, музыковедение и редчайшие мировые традиции",
            topic = "Музыка",
            level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 404 — Музыка: носитель/архаика (L5, EPIC+LEGENDARY)          ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── music_l5_theory_advanced (5) ──────────────────────────────────

        WordEntity(id = 40401, setId = 404, languagePair = "en-ru", rarity = "EPIC",
            original = "ostinato",
            transliteration = "[ˌɑstɪˈnɑtoʊ]",
            translation = "остинато (упорно повторяемая фигура)",
            definition = "A short musical phrase that one voice repeats stubbornly while others change above it.",
            definitionNative = "Короткая музыкальная фраза, что один голос упрямо повторяет, пока остальные меняются над ней.",
            example = "The cellos hold a dark ostinato beneath the soaring melody of the strings.",
            exampleNative = "Виолончели держат мрачный ostinato под взлетающей мелодией струнных.",
            pos = "noun", semanticGroup = "music_l5_theory_advanced", fillInBlankExclusions = listOf(40402L, 40403L, 40404L, 40405L)),

        WordEntity(id = 40402, setId = 404, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "cantus firmus",
            transliteration = "[ˈkæntəs ˈfɜrməs]",
            translation = "кантус фирмус (заданная мелодия как основа)",
            definition = "A fixed melody borrowed from old chant on which a composer builds new lines around it.",
            definitionNative = "Заранее заданная мелодия из старинного распева, поверх которой композитор сплетает новые голоса.",
            example = "Each motet of the school is built upon a cantus firmus drawn from plainchant.",
            exampleNative = "Каждый мотет школы построен на cantus firmus, взятом из григорианского распева.",
            pos = "noun", semanticGroup = "music_l5_theory_advanced", fillInBlankExclusions = listOf(40403L)),

        WordEntity(id = 40403, setId = 404, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hocket",
            transliteration = "[ˈhɑkɪt]",
            translation = "гокет (приём «икающего» дробления мелодии)",
            definition = "An old way of splitting a single tune between voices so each sings only every other note.",
            definitionNative = "Старинный приём, при котором единая мелодия дробится между голосами, и каждый поёт лишь через ноту.",
            example = "The medieval ensemble closed the concert with a sharp, jittery hocket.",
            exampleNative = "Средневековый ансамбль закрыл концерт резким, дёрганым hocket.",
            pos = "noun", semanticGroup = "music_l5_theory_advanced", fillInBlankExclusions = listOf(40401L, 40402L, 40404L, 40405L)),

        WordEntity(id = 40404, setId = 404, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "organum",
            transliteration = "[ˈɔrɡənəm]",
            translation = "органум (раннее средневековое многоголосие)",
            definition = "An early form of part-singing in which a second voice runs in parallel above the chant.",
            definitionNative = "Ранняя форма многоголосия, при которой второй голос идёт параллельно поверх распева.",
            example = "Notre-Dame composers stretched a single chant note for whole minutes of organum.",
            exampleNative = "Композиторы Нотр-Дама растягивали одну ноту распева на целые минуты organum.",
            pos = "noun", semanticGroup = "music_l5_theory_advanced", fillInBlankExclusions = listOf(40401L, 40402L, 40403L, 40405L)),

        WordEntity(id = 40405, setId = 404, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "isorhythm",
            transliteration = "[ˈaɪsoʊˌrɪðəm]",
            translation = "изоритм (повторяемая ритмическая формула)",
            definition = "A late-medieval device in which the same long rhythmic pattern returns under shifting pitches.",
            definitionNative = "Позднесредневековый приём, при котором один длинный ритмический рисунок возвращается под меняющимися высотами.",
            example = "Her thesis traced the strict isorhythm running through Machaut's late motets.",
            exampleNative = "Её диссертация прослеживала строгий isorhythm в поздних мотетах Машо.",
            pos = "noun", semanticGroup = "music_l5_theory_advanced", fillInBlankExclusions = listOf(40401L, 40402L, 40403L, 40404L)),

        // ── music_l5_archaic_instruments (5) ──────────────────────────────

        WordEntity(id = 40406, setId = 404, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "sackbut",
            transliteration = "[ˈsækbʌt]",
            translation = "сакбут (ренессансная предтеча тромбона)",
            definition = "An old brass instrument with a sliding tube — the soft-voiced ancestor of today's trombone.",
            definitionNative = "Старый медный инструмент с раздвижной трубкой — мягкоголосый предок современного тромбона.",
            example = "The early-music band brought out a sackbut for the Renaissance dance suite.",
            exampleNative = "Ансамбль старинной музыки достал sackbut для ренессансной танцевальной сюиты.",
            pos = "noun", semanticGroup = "music_l5_archaic_instruments", fillInBlankExclusions = listOf(40407L, 40408L, 40409L, 40410L)),

        WordEntity(id = 40407, setId = 404, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "theorbo",
            transliteration = "[θiˈɔrboʊ]",
            translation = "теорба (большая лютня с длинным грифом)",
            definition = "A long-necked Baroque lute with extra bass strings used to underpin sung lines.",
            definitionNative = "Барочная лютня с длинным грифом и дополнительными басовыми струнами, что подпирает вокал.",
            example = "A single theorbo accompanied the soprano through the whole cantata.",
            exampleNative = "Один theorbo сопровождал сопрано на протяжении всей кантаты.",
            pos = "noun", semanticGroup = "music_l5_archaic_instruments", fillInBlankExclusions = listOf(40406L, 40408L, 40409L, 40410L)),

        WordEntity(id = 40408, setId = 404, languagePair = "en-ru", rarity = "EPIC",
            original = "hurdy-gurdy",
            transliteration = "[ˈhɜrdiˌɡɜrdi]",
            translation = "колёсная лира (народный инструмент с рукоятью)",
            definition = "A folk instrument whose drone is made by a wooden wheel scraping strings as the player cranks.",
            definitionNative = "Народный инструмент, чей бурдон рождает деревянное колесо, трущее о струны при вращении рукояти.",
            example = "The street musician cranked his hurdy-gurdy through a slow Breton tune.",
            exampleNative = "Уличный музыкант крутил свой hurdy-gurdy под медленный бретонский напев.",
            pos = "noun", semanticGroup = "music_l5_archaic_instruments", fillInBlankExclusions = listOf(40406L, 40407L, 40409L, 40410L)),

        WordEntity(id = 40409, setId = 404, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "shawm",
            transliteration = "[ʃɔm]",
            translation = "шалмей (резкий деревянный духовой Средневековья)",
            definition = "A loud double-reed wind from the Middle Ages — the rough ancestor of the modern oboe.",
            definitionNative = "Громкий двухтростевой духовой Средних веков — грубоватый предок современного гобоя.",
            example = "Town watchmen once played the shawm from castle towers at dawn.",
            exampleNative = "Городские стражи когда-то играли на shawm с башен замка на рассвете.",
            pos = "noun", semanticGroup = "music_l5_archaic_instruments", fillInBlankExclusions = listOf(40406L, 40407L, 40408L, 40410L)),

        WordEntity(id = 40410, setId = 404, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "virginal",
            transliteration = "[ˈvɜrʤənəl]",
            translation = "вирджинал (малый клавишный родственник клавесина)",
            definition = "A small Renaissance keyboard whose strings are plucked, much loved in Tudor parlours.",
            definitionNative = "Малый ренессансный клавишный со щиплющим механизмом, любимый в гостиных тюдоровской Англии.",
            example = "She played a Byrd pavane on a restored virginal at the museum recital.",
            exampleNative = "Она играла павану Бёрда на отреставрированном virginal на концерте в музее.",
            pos = "noun", semanticGroup = "music_l5_archaic_instruments", fillInBlankExclusions = listOf(40406L, 40407L, 40408L, 40409L)),

        // ── music_l5_musicology (5) ───────────────────────────────────────

        WordEntity(id = 40411, setId = 404, languagePair = "en-ru", rarity = "EPIC",
            original = "ethnomusicology",
            transliteration = "[ˌɛθnoʊˌmjuzɪˈkɑləʤi]",
            translation = "этномузыкология (наука о музыке народов мира)",
            definition = "The study of music as part of the living cultures and rituals of peoples around the world.",
            definitionNative = "Изучение музыки как части живых культур и обрядов разных народов мира.",
            example = "Her field trip for ethnomusicology took her deep into the Tuvan steppe.",
            exampleNative = "Полевая поездка по ethnomusicology завела её в глубину тувинской степи.",
            pos = "noun", semanticGroup = "music_l5_musicology", fillInBlankExclusions = listOf(40412L, 40413L, 40414L, 40415L)),

        WordEntity(id = 40412, setId = 404, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "paleography",
            transliteration = "[ˌpeɪliˈɑɡrəfi]",
            translation = "палеография (наука о старинных рукописях и записи)",
            definition = "The careful study of old handwritten scripts, including the early ways of writing music down.",
            definitionNative = "Тщательное изучение старинных рукописных почерков, в том числе ранних способов записи музыки.",
            example = "Musical paleography lets us read the earliest neumes scratched above plainchant.",
            exampleNative = "Музыкальная paleography позволяет читать ранние знаки над строкой григорианского распева.",
            pos = "noun", semanticGroup = "music_l5_musicology", fillInBlankExclusions = listOf(40411L, 40413L, 40414L, 40415L)),

        WordEntity(id = 40413, setId = 404, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "organology",
            transliteration = "[ˌɔrɡəˈnɑləʤi]",
            translation = "органология (наука о музыкальных инструментах)",
            definition = "The branch of scholarship that classifies musical instruments and traces their history.",
            definitionNative = "Раздел науки, что классифицирует музыкальные инструменты и прослеживает их историю.",
            example = "His chapter on organology grouped every drum of West Africa by skin and shape.",
            exampleNative = "Его глава по organology сгруппировала каждый барабан Западной Африки по коже и форме.",
            pos = "noun", semanticGroup = "music_l5_musicology", fillInBlankExclusions = listOf(40411L, 40412L, 40414L, 40415L)),

        WordEntity(id = 40414, setId = 404, languagePair = "en-ru", rarity = "EPIC",
            original = "musicology",
            transliteration = "[ˌmjuzɪˈkɑləʤi]",
            translation = "музыковедение (научное изучение музыки)",
            definition = "The academic study of music — its history, theory, and place within wider culture.",
            definitionNative = "Академическое изучение музыки — её истории, теории и места в широкой культуре.",
            example = "She earned her doctorate in musicology with a thesis on Renaissance song.",
            exampleNative = "Она получила докторскую по musicology за диссертацию о ренессансной песне.",
            pos = "noun", semanticGroup = "music_l5_musicology", fillInBlankExclusions = listOf(40411L, 40412L, 40413L, 40415L)),

        WordEntity(id = 40415, setId = 404, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "neume",
            transliteration = "[njum]",
            translation = "невма (старинный знак записи распева)",
            definition = "An old hooked sign written above a chant text to show the shape of the melody.",
            definitionNative = "Старинный крючковатый знак над текстом распева, что показывает движение мелодии.",
            example = "Each neume above the Latin line hinted at a curve of voice rather than exact pitch.",
            exampleNative = "Каждая neume над латинской строкой намекала на изгиб голоса, а не на точную высоту.",
            pos = "noun", semanticGroup = "music_l5_musicology", fillInBlankExclusions = listOf(40411L, 40412L, 40413L, 40414L)),

        // ── music_l5_critic_advanced (5) ──────────────────────────────────

        WordEntity(id = 40416, setId = 404, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "plangent",
            transliteration = "[ˈplænʤənt]",
            translation = "звонко-печальный, протяжный (книжн. о звучании)",
            definition = "Of a sound that rings out loud and mournful, like a deep bell over still water.",
            definitionNative = "О звуке, что звенит громко и печально, словно низкий колокол над тихой водой.",
            example = "A plangent cello line cut across the silent hall and held the listeners.",
            exampleNative = "Plangent линия виолончели прорезала тихий зал и удержала слушателей.",
            pos = "adjective", semanticGroup = "music_l5_critic_advanced", fillInBlankExclusions = listOf(40417L, 40418L, 40419L)),

        WordEntity(id = 40417, setId = 404, languagePair = "en-ru", rarity = "EPIC",
            original = "sepulchral",
            transliteration = "[səˈpʌlkrəl]",
            translation = "гробовой, замогильный (книжн. о звучании)",
            definition = "Of a tone so deep and hollow it seems to rise from a stone tomb in cold earth.",
            definitionNative = "О тоне, столь глубоком и пустом, словно поднимается из каменной гробницы в холодной земле.",
            example = "The bass sang the lament in a sepulchral voice that froze the audience.",
            exampleNative = "Бас пел плач sepulchral голосом, что заморозил зал.",
            pos = "adjective", semanticGroup = "music_l5_critic_advanced", fillInBlankExclusions = listOf(40416L, 40418L, 40419L)),

        WordEntity(id = 40418, setId = 404, languagePair = "en-ru", rarity = "EPIC",
            original = "dulcet",
            transliteration = "[ˈdʌlsɪt]",
            translation = "сладкозвучный, нежный (книжн. о голосе)",
            definition = "Of a voice or sound that is soft and sweet to the ear, gently easing rather than striking.",
            definitionNative = "О голосе или звуке мягком и сладком для уха, что ласкает, а не разит.",
            example = "Her dulcet alto wrapped around the slow lullaby like warm wool.",
            exampleNative = "Её dulcet альт окутывал медленную колыбельную, словно тёплая шерсть.",
            pos = "adjective", semanticGroup = "music_l5_critic_advanced", fillInBlankExclusions = listOf(40416L, 40417L, 40419L, 40420L)),

        WordEntity(id = 40419, setId = 404, languagePair = "en-ru", rarity = "EPIC",
            original = "sonorous",
            transliteration = "[ˈsɑnərəs]",
            translation = "звучный, полнозвучный (книжн.)",
            definition = "Of a sound full and rich in body, ringing freely and filling the room with weight.",
            definitionNative = "О звуке полном и насыщенном телом, что звенит вольно и наполняет комнату весом.",
            example = "The old cathedral organ released a sonorous chord that shook the wooden pews.",
            exampleNative = "Старинный соборный орган отпустил sonorous аккорд, что сотряс деревянные скамьи.",
            pos = "adjective", semanticGroup = "music_l5_critic_advanced", fillInBlankExclusions = listOf(40416L, 40417L, 40418L)),

        WordEntity(id = 40420, setId = 404, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "elegiac",
            transliteration = "[ˌɛləˈʤaɪək]",
            translation = "элегический, скорбно-задумчивый (книжн.)",
            definition = "Of a piece whose slow grieving mood seems to mourn for something lost long ago.",
            definitionNative = "О произведении, чей медленный скорбный настрой словно оплакивает давно ушедшее.",
            example = "The slow movement has an elegiac calm that hushes every cough in the hall.",
            exampleNative = "Медленная часть несёт elegiac покой, что унимает любой кашель в зале.",
            pos = "adjective", semanticGroup = "music_l5_critic_advanced"),

        // ── music_l5_obscure_genres (5) ───────────────────────────────────

        WordEntity(id = 40421, setId = 404, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "gagaku",
            transliteration = "[ɡɑˈɡɑku]",
            translation = "гагаку (древняя японская придворная музыка)",
            definition = "An ancient Japanese court music of slow drone and wind, performed for over a thousand years.",
            definitionNative = "Древняя японская придворная музыка медленного бурдона и духовых, что звучит более тысячи лет.",
            example = "A gagaku ensemble opened the imperial ceremony with a long, breathing chord.",
            exampleNative = "Ансамбль gagaku открыл императорскую церемонию длинным, дышащим аккордом.",
            pos = "noun", semanticGroup = "music_l5_obscure_genres", fillInBlankExclusions = listOf(40422L, 40423L, 40424L, 40425L)),

        WordEntity(id = 40422, setId = 404, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "mbira",
            transliteration = "[əmˈbɪrə]",
            translation = "мбира (африканский ламеллофон с металлическими язычками)",
            definition = "A small wooden board with metal tongues plucked by thumbs — sacred in much of southern Africa.",
            definitionNative = "Малая деревянная дощечка с металлическими язычками, что щиплют большими пальцами, — святыня юга Африки.",
            example = "An old man played the mbira at the village ceremony for ancestral spirits.",
            exampleNative = "Старик играл на mbira на деревенской церемонии для духов предков.",
            pos = "noun", semanticGroup = "music_l5_obscure_genres", fillInBlankExclusions = listOf(40421L, 40423L, 40424L, 40425L)),

        WordEntity(id = 40423, setId = 404, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "qanun",
            transliteration = "[kɑˈnun]",
            translation = "канун (арабская щипковая цитра)",
            definition = "A flat plucked zither of the Arab world with many strings tuned by tiny levers under each course.",
            definitionNative = "Плоская щипковая цитра арабского мира со множеством струн, настраиваемых рычажками под каждым хором.",
            example = "The qanun took a long taqsim before the singer entered with the first verse.",
            exampleNative = "Qanun взял долгий таксим до того, как певец вступил с первым стихом.",
            pos = "noun", semanticGroup = "music_l5_obscure_genres", fillInBlankExclusions = listOf(40421L, 40422L, 40424L, 40425L)),

        WordEntity(id = 40424, setId = 404, languagePair = "en-ru", rarity = "EPIC",
            original = "didgeridoo",
            transliteration = "[ˌdɪʤəriˈdu]",
            translation = "диджериду (австралийская деревянная труба)",
            definition = "A long hollow wooden pipe of Aboriginal Australia, played with a deep continuous breath.",
            definitionNative = "Длинная полая деревянная труба коренной Австралии, на которой играют глубоким непрерывным дыханием.",
            example = "The didgeridoo droned beneath the firelight at the desert ceremony.",
            exampleNative = "Didgeridoo гудел под светом костра на церемонии в пустыне.",
            pos = "noun", semanticGroup = "music_l5_obscure_genres", fillInBlankExclusions = listOf(40421L, 40422L, 40423L, 40425L)),

        WordEntity(id = 40425, setId = 404, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "throat singing",
            transliteration = "[θroʊt ˈsɪŋɪŋ]",
            translation = "горловое пение (одновременное звучание нескольких тонов)",
            definition = "A rare technique in which one singer brings out two or more tones at once from a single throat.",
            definitionNative = "Редкая техника, при которой один певец извлекает разом два и более тона из одного горла.",
            example = "Tuvan throat singing sounded as if a whole choir hid inside one quiet man.",
            exampleNative = "Тувинское throat singing звучало так, словно целый хор прятался внутри одного тихого человека.",
            pos = "noun", semanticGroup = "music_l5_obscure_genres", fillInBlankExclusions = listOf(40421L, 40422L, 40423L, 40424L)),
    )
}
