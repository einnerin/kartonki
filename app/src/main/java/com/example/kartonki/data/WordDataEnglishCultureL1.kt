package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Культура и искусство (level 1).
 *
 * Set 321: «Культура и искусство» — основы для повседневных разговоров о музыке,
 * кино, театре, музеях и хобби (L1 / COMMON+UNCOMMON).
 *
 * Дополняет уже существующие сеты темы «Культура и искусство»:
 *   - Set 23  (WordDataEnglish.kt)         — L2 (museum, gallery, concert, novel...).
 *   - Set 60  (WordDataEnglish.kt)         — L4 (нарратив).
 *   - Set 80  (WordDataEnglish.kt)         — L5 (литературные термины).
 *   - Set 202 (WordDataEnglishExpanded.kt) — L2 (праздники).
 *   - Set 205 (WordDataEnglishExpanded.kt) — L3 (музыка и инструменты).
 *   - Set 206 (WordDataEnglishExpanded.kt) — L2 (кино и театр).
 *   - Set 224 (WordDataEnglishExpanded.kt) — L2 (литературные термины).
 *   - Set 225 (WordDataEnglishExpanded.kt) — L3 (приёмы и жанры).
 *   - Set 238 (WordDataEnglishExpanded.kt) — L2 (искусство: основы).
 *   - Set 239 (WordDataEnglishExpanded.kt) — L3 (искусство: углублённо).
 *   - Set 242 (WordDataEnglishExpanded.kt) — L4 (торжества).
 *   - Set 245 (WordDataEnglishExpanded.kt) — L4 (киноязык).
 *   - Set 259 (WordDataEnglishBatch6.kt)   — L2 (фотосъёмка).
 *
 * Слова setId=321 не пересекаются ни с одним из этих наборов (проверено grep).
 *
 * Распределение редкости: 20 COMMON + 5 UNCOMMON — два смежных уровня шкалы (A1+A2).
 *
 * SemanticGroups (5 × 5):
 *   culture_visual_art          — painting, drawing, sketch, pottery, clay
 *   culture_music_instruments   — guitar, piano, violin, drum, flute
 *   culture_show_entertainment  — movie, cartoon, circus, clown, puppet
 *   culture_dance_stage         — ballet, dancer, chorus, spotlight, applause
 *   culture_hobby_media         — hobby, poster, album, fairytale, vinyl
 *
 * Word IDs: 32101..32125 (setId × 100 + position).
 */
object WordDataEnglishCultureL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 321, name = "Культура и искусство",
            description = "Базовая лексика про музыку, кино, театр, музеи и хобби для повседневных разговоров",
            languagePair = "en-ru",
            orderIndex = 141,
            topic = "Культура и искусство", level = 1),
    )

    val words: List<WordEntity> = listOf(

        // ── culture_visual_art (5) ────────────────────────────────────────

        WordEntity(id = 32101, setId = 321, languagePair = "en-ru", rarity = "COMMON",
            original = "painting", transliteration = "[ˈpeɪntɪŋ]", translation = "картина",
            definition = "A picture made with coloured paints on paper, canvas or a wall.",
            definitionNative = "Изображение, сделанное красками на бумаге, холсте или стене.",
            example = "A huge painting of a forest hung above the sofa.",
            exampleNative = "Огромная painting с лесом висела над диваном.",
            pos = "noun", semanticGroup = "culture_visual_art", fillInBlankExclusions = listOf(32102L, 32103L, 32104L, 32105L, 32122L)),

        WordEntity(id = 32102, setId = 321, languagePair = "en-ru", rarity = "COMMON",
            original = "drawing", transliteration = "[ˈdrɔɪŋ]", translation = "рисунок",
            definition = "A picture made with a pencil, pen or crayon — usually without colour.",
            definitionNative = "Изображение, сделанное карандашом, ручкой или мелком — обычно без красок.",
            example = "My little sister gave me a drawing of our cat.",
            exampleNative = "Младшая сестра подарила мне drawing нашего кота.",
            pos = "noun", semanticGroup = "culture_visual_art", fillInBlankExclusions = listOf(32101L, 32103L, 32104L, 32105L, 32112L, 32122L)),

        WordEntity(id = 32103, setId = 321, languagePair = "en-ru", rarity = "COMMON",
            original = "sketch", transliteration = "[skɛʧ]", translation = "набросок",
            definition = "A quick rough drawing — done before the real picture.",
            definitionNative = "Быстрый черновой рисунок — делается до настоящей картины.",
            example = "He made a quick sketch of the bridge in his notebook.",
            exampleNative = "Он сделал быстрый sketch моста в своём блокноте.",
            pos = "noun", semanticGroup = "culture_visual_art", fillInBlankExclusions = listOf(32101L, 32102L, 32104L, 32105L)),

        WordEntity(id = 32104, setId = 321, languagePair = "en-ru", rarity = "COMMON",
            original = "pottery", transliteration = "[ˈpɑtəri]", translation = "керамика",
            definition = "Cups, bowls and pots made from soft earth that is baked hard.",
            definitionNative = "Чашки, миски и горшки из мягкой земли, которую обжигают до твёрдости.",
            example = "We bought a small bowl at the pottery shop near the museum.",
            exampleNative = "Мы купили маленькую миску в магазине pottery рядом с музеем.",
            pos = "noun", semanticGroup = "culture_visual_art", fillInBlankExclusions = listOf(32101L, 32102L, 32103L, 32105L, 32106L, 32115L, 32122L, 32125L)),

        WordEntity(id = 32105, setId = 321, languagePair = "en-ru", rarity = "COMMON",
            original = "clay", transliteration = "[kleɪ]", translation = "глина",
            definition = "Soft sticky earth that artists shape into pots and figures.",
            definitionNative = "Мягкая липкая земля, из которой лепят горшки и фигурки.",
            example = "The kids made little animals out of clay at school.",
            exampleNative = "Дети лепили маленьких зверей из clay в школе.",
            pos = "noun", semanticGroup = "culture_visual_art", fillInBlankExclusions = listOf(32101L, 32102L, 32103L, 32104L)),

        // ── culture_music_instruments (5) ─────────────────────────────────

        WordEntity(id = 32106, setId = 321, languagePair = "en-ru", rarity = "COMMON",
            original = "guitar", transliteration = "[ɡɪˈtɑr]", translation = "гитара",
            definition = "A wooden instrument with six strings that you play with your fingers.",
            definitionNative = "Деревянный инструмент с шестью струнами — играют пальцами.",
            example = "My brother plays the guitar in a small school band.",
            exampleNative = "Мой брат играет на guitar в маленькой школьной группе.",
            pos = "noun", semanticGroup = "culture_music_instruments", fillInBlankExclusions = listOf(32107L, 32108L, 32109L, 32110L)),

        WordEntity(id = 32107, setId = 321, languagePair = "en-ru", rarity = "COMMON",
            original = "piano", transliteration = "[piˈænoʊ]", translation = "пианино",
            definition = "A large instrument with black and white keys that you press to play.",
            definitionNative = "Крупный инструмент с чёрными и белыми клавишами — играют, нажимая их.",
            example = "She has been learning the piano since she was six.",
            exampleNative = "Она учится играть на piano с шести лет.",
            pos = "noun", semanticGroup = "culture_music_instruments", fillInBlankExclusions = listOf(32106L, 32108L, 32109L, 32110L)),

        WordEntity(id = 32108, setId = 321, languagePair = "en-ru", rarity = "COMMON",
            original = "violin", transliteration = "[ˌvaɪəˈlɪn]", translation = "скрипка",
            definition = "A small wooden instrument with strings — played with a long stick.",
            definitionNative = "Маленький деревянный инструмент со струнами — играют длинной палочкой.",
            example = "The girl carried her violin in a black case to the lesson.",
            exampleNative = "Девочка несла violin в чёрном футляре на урок.",
            pos = "noun", semanticGroup = "culture_music_instruments", fillInBlankExclusions = listOf(32106L, 32107L, 32109L, 32110L)),

        WordEntity(id = 32109, setId = 321, languagePair = "en-ru", rarity = "COMMON",
            original = "drum", transliteration = "[drʌm]", translation = "барабан",
            definition = "A round instrument that you hit with sticks or hands to make sound.",
            definitionNative = "Круглый инструмент — бьют палочками или руками, чтобы получить звук.",
            example = "The little boy banged on the drum and woke the baby.",
            exampleNative = "Малыш стукнул в drum и разбудил младенца.",
            pos = "noun", semanticGroup = "culture_music_instruments", fillInBlankExclusions = listOf(32106L, 32107L, 32108L, 32110L)),

        WordEntity(id = 32110, setId = 321, languagePair = "en-ru", rarity = "COMMON",
            original = "flute", transliteration = "[flut]", translation = "флейта",
            definition = "A long thin instrument — you blow into it to make soft sounds.",
            definitionNative = "Длинный тонкий инструмент — в него дуют, чтобы получить мягкий звук.",
            example = "Grandma played the flute beautifully when she was young.",
            exampleNative = "Бабушка прекрасно играла на flute, когда была молодой.",
            pos = "noun", semanticGroup = "culture_music_instruments", fillInBlankExclusions = listOf(32106L, 32107L, 32108L, 32109L)),

        // ── culture_show_entertainment (5) ────────────────────────────────

        WordEntity(id = 32111, setId = 321, languagePair = "en-ru", rarity = "COMMON",
            original = "movie", transliteration = "[ˈmuvi]", translation = "кино",
            definition = "A story told with pictures and sound — you watch it on a big screen.",
            definitionNative = "История, рассказанная картинками и звуком — её смотрят на большом экране.",
            example = "We watched a funny movie at home on Saturday night.",
            exampleNative = "Мы смотрели смешное movie дома в субботу вечером.",
            pos = "noun", semanticGroup = "culture_show_entertainment", fillInBlankExclusions = listOf(32112L, 32113L, 32114L, 32115L, 32124L)),

        WordEntity(id = 32112, setId = 321, languagePair = "en-ru", rarity = "COMMON",
            original = "cartoon", transliteration = "[kɑrˈtun]", translation = "мультфильм",
            definition = "A short film with drawn characters — usually for children.",
            definitionNative = "Короткий фильм с нарисованными героями — обычно для детей.",
            example = "Every Sunday morning the kids watch a cartoon together.",
            exampleNative = "Каждое воскресное утро дети вместе смотрят cartoon.",
            pos = "noun", semanticGroup = "culture_show_entertainment", fillInBlankExclusions = listOf(32111L, 32113L, 32114L, 32115L, 32116L, 32118L)),

        WordEntity(id = 32113, setId = 321, languagePair = "en-ru", rarity = "COMMON",
            original = "circus", transliteration = "[ˈsɜrkəs]", translation = "цирк",
            definition = "A big tent show with funny people, jumping animals and tricks.",
            definitionNative = "Шоу в большом шатре — с весёлыми людьми, прыгающими животными и трюками.",
            example = "Dad took us to the circus and we saw an elephant.",
            exampleNative = "Папа повёл нас в circus, и мы увидели слона.",
            pos = "noun", semanticGroup = "culture_show_entertainment", fillInBlankExclusions = listOf(32111L, 32112L, 32114L, 32115L, 32116L)),

        WordEntity(id = 32114, setId = 321, languagePair = "en-ru", rarity = "COMMON",
            original = "clown", transliteration = "[klaʊn]", translation = "клоун",
            definition = "A funny man with a red nose and big shoes — makes people laugh.",
            definitionNative = "Весёлый человек с красным носом и большими ботинками — смешит людей.",
            example = "The clown made my little sister laugh until she cried.",
            exampleNative = "Clown рассмешил мою сестрёнку до слёз.",
            pos = "noun", semanticGroup = "culture_show_entertainment", fillInBlankExclusions = listOf(32111L, 32112L, 32113L, 32115L, 32117L, 32124L)),

        WordEntity(id = 32115, setId = 321, languagePair = "en-ru", rarity = "COMMON",
            original = "puppet", transliteration = "[ˈpʌpɪt]", translation = "кукла (марионетка)",
            definition = "A small toy figure that a person moves with hands or strings.",
            definitionNative = "Маленькая игрушечная фигурка — человек двигает её руками или нитками.",
            example = "The old man made a wooden puppet for his grandson.",
            exampleNative = "Старик сделал деревянного puppet для внука.",
            pos = "noun", semanticGroup = "culture_show_entertainment", fillInBlankExclusions = listOf(32109L, 32110L, 32111L, 32112L, 32113L, 32114L)),

        // ── culture_dance_stage (5) ───────────────────────────────────────

        WordEntity(id = 32116, setId = 321, languagePair = "en-ru", rarity = "COMMON",
            original = "ballet", transliteration = "[bæˈleɪ]", translation = "балет",
            definition = "A graceful dance show — performers stand on the tips of their toes.",
            definitionNative = "Изящное танцевальное представление — исполнители стоят на кончиках пальцев ног.",
            example = "My aunt took me to the ballet for my birthday.",
            exampleNative = "Тётя сводила меня на ballet на день рождения.",
            pos = "noun", semanticGroup = "culture_dance_stage", fillInBlankExclusions = listOf(32111L, 32113L, 32117L, 32118L, 32119L, 32120L)),

        WordEntity(id = 32117, setId = 321, languagePair = "en-ru", rarity = "COMMON",
            original = "dancer", transliteration = "[ˈdænsər]", translation = "танцор",
            definition = "A person who moves to music — at a show or for a job.",
            definitionNative = "Человек, который двигается под музыку — на представлении или по работе.",
            example = "The dancer wore a long red dress and silver shoes.",
            exampleNative = "Dancer был в длинном красном платье и серебряных туфлях.",
            pos = "noun", semanticGroup = "culture_dance_stage", fillInBlankExclusions = listOf(32114L, 32115L, 32116L, 32118L, 32119L, 32120L)),

        WordEntity(id = 32118, setId = 321, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "chorus", transliteration = "[ˈkɔrəs]", translation = "хор",
            definition = "A big group of people who sing or dance together on stage.",
            definitionNative = "Большая группа людей — поют или танцуют вместе на сцене.",
            example = "The school chorus sang a happy song at the festival.",
            exampleNative = "Школьный chorus спел весёлую песню на празднике.",
            pos = "noun", semanticGroup = "culture_dance_stage", fillInBlankExclusions = listOf(32116L, 32117L, 32119L, 32120L)),

        WordEntity(id = 32119, setId = 321, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "spotlight", transliteration = "[ˈspɑtˌlaɪt]", translation = "прожектор",
            definition = "A strong round light that shines on one person on stage.",
            definitionNative = "Сильный круглый свет — направлен на одного человека на сцене.",
            example = "The singer stepped into the spotlight and the crowd cheered.",
            exampleNative = "Певец вышел в spotlight, и толпа закричала.",
            pos = "noun", semanticGroup = "culture_dance_stage", fillInBlankExclusions = listOf(32116L, 32117L, 32118L, 32120L)),

        WordEntity(id = 32120, setId = 321, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "applause", transliteration = "[əˈplɔz]", translation = "аплодисменты",
            definition = "The loud sound of many people clapping their hands together.",
            definitionNative = "Громкий звук — много людей вместе хлопают в ладоши.",
            example = "After the song there was loud applause from the whole hall.",
            exampleNative = "После песни весь зал разразился громкими applause.",
            pos = "noun", semanticGroup = "culture_dance_stage", fillInBlankExclusions = listOf(32116L, 32117L, 32118L, 32119L)),

        // ── culture_hobby_media (5) ───────────────────────────────────────

        WordEntity(id = 32121, setId = 321, languagePair = "en-ru", rarity = "COMMON",
            original = "hobby", transliteration = "[ˈhɑbi]", translation = "хобби",
            definition = "Something you love to do in free time — just for fun.",
            definitionNative = "То, чем нравится заниматься в свободное время — просто для удовольствия.",
            example = "My favourite hobby is taking photos of birds in the park.",
            exampleNative = "Моё любимое hobby — снимать птиц в парке.",
            pos = "noun", semanticGroup = "culture_hobby_media", fillInBlankExclusions = listOf(32122L, 32123L, 32124L, 32125L)),

        WordEntity(id = 32122, setId = 321, languagePair = "en-ru", rarity = "COMMON",
            original = "poster", transliteration = "[ˈpoʊstər]", translation = "плакат",
            definition = "A big colourful paper sheet you stick on a wall — often shows a star.",
            definitionNative = "Большой яркий бумажный лист на стене — часто с изображением звезды.",
            example = "She has a huge poster of her favourite singer above her bed.",
            exampleNative = "У неё над кроватью висит огромный poster любимой певицы.",
            pos = "noun", semanticGroup = "culture_hobby_media", fillInBlankExclusions = listOf(32101L, 32102L, 32103L, 32121L, 32123L, 32124L, 32125L)),

        WordEntity(id = 32123, setId = 321, languagePair = "en-ru", rarity = "COMMON",
            original = "album", transliteration = "[ˈælbəm]", translation = "альбом",
            definition = "A book of songs by a singer, or a book where you keep photos.",
            definitionNative = "Сборник песен одного певца — или книжка, где хранят фотографии.",
            example = "She listened to the new album three times in one evening.",
            exampleNative = "Она прослушала новый album три раза за один вечер.",
            pos = "noun", semanticGroup = "culture_hobby_media", fillInBlankExclusions = listOf(32118L, 32121L, 32122L, 32124L, 32125L)),

        WordEntity(id = 32124, setId = 321, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "fairytale", transliteration = "[ˈfɛriˌteɪl]", translation = "сказка",
            definition = "A short story for kids — with kings, witches and magic.",
            definitionNative = "Короткая история для детей — с королями, ведьмами и волшебством.",
            example = "Grandma read me a fairytale every night before bed.",
            exampleNative = "Бабушка читала мне fairytale каждый вечер перед сном.",
            pos = "noun", semanticGroup = "culture_hobby_media", fillInBlankExclusions = listOf(32121L, 32122L, 32125L)),

        WordEntity(id = 32125, setId = 321, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "vinyl", transliteration = "[ˈvaɪnəl]", translation = "пластинка (виниловая)",
            definition = "A round black disc with music — played on an old record player.",
            definitionNative = "Круглый чёрный диск с музыкой — крутят на старом проигрывателе.",
            example = "Dad still keeps his old vinyl in a wooden box in the attic.",
            exampleNative = "Папа до сих пор хранит старый vinyl в деревянной коробке на чердаке.",
            pos = "noun", semanticGroup = "culture_hobby_media", fillInBlankExclusions = listOf(32101L, 32102L, 32103L, 32106L, 32108L, 32110L, 32115L, 32121L, 32122L, 32123L, 32124L)),
    )
}
