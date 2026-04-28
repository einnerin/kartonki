package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Внешность и тело (L3, RARE+EPIC).
 *
 * Set 382: «Внешность и тело» — углублённый уровень.
 *          Анатомия лица, видимые детали скелета, типы фигуры,
 *          качество кожи и стиль/ухоженность.
 *
 * L1 (set 380) занял: cheek, chin, forehead, eyebrow, eyelash, blonde,
 *   curly, bald, beard, ponytail, freckle, wrinkle, mole, dimple,
 *   sunburn, slim, plump, skinny, muscular, slender, lips, teeth,
 *   palm, ankle, toe.
 *
 * L3-фокус (углублённый): тонкая анатомия лица (hairline/lobe/eyelid/
 * nostril/brow), кости и суставы (collarbone/knuckle/temple/jaw/
 * biceps), типы фигуры (hourglass/athletic/petite/wiry/curvaceous),
 * детали кожи (freckled/acne/tanned/olive/ruddy), стиль (groomed/
 * dishevelled/polished/scruffy/dapper).
 *
 * L2 (set 381) занял: bun, braid, fringe, sideburns, stubble, grin,
 * smirk, scowl, glare, wink, burly, stocky, chubby, scrawny, brawny,
 * gum, iris, blush, cleft, gap, tattoo, piercing, crease, birthmark,
 * pimple — повтора нет (свериться выше).
 *
 * Cross-topic совпадений нет — grep по WordData*.kt чистый.
 *
 * Распределение редкости: 18 RARE + 7 EPIC — два смежных уровня B2/C1.
 *
 * SemanticGroups (5 × 5):
 *   appearance_face_anatomy     — hairline, lobe, eyelid, nostril, brow
 *   appearance_skeletal         — collarbone, knuckle, temple, jaw, biceps
 *   appearance_body_shape       — hourglass, athletic, petite, wiry, curvaceous
 *   appearance_skin_quality     — freckled, acne, tanned, olive, ruddy
 *   appearance_grooming_style   — groomed, dishevelled, polished, scruffy, dapper
 *
 * Word IDs: setId × 100 + position (38201..38225).
 *
 * isFillInBlankSafe / fillInBlankExclusions — не задаём, defaults
 * сработают, FILL_IN_BLANK pipeline зальёт сам.
 */
object WordDataEnglishAppearanceL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 382,
            languagePair = "en-ru",
            orderIndex = 382,
            name = "Внешность и тело",
            description = "Анатомия лица, типы фигуры и стиль",
            topic = "Внешность и тело",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 382 — Внешность и тело: углублённый (L3, RARE+EPIC)         ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── appearance_face_anatomy (5) ───────────────────────────────────

        WordEntity(id = 38201, setId = 382, languagePair = "en-ru", rarity = "RARE",
            original = "hairline",
            transliteration = "[ˈhɛrˌlaɪn]",
            translation = "линия роста волос",
            definition = "The shape where the hair on the head meets the forehead.",
            definitionNative = "Граница, где волосы на голове встречаются со лбом.",
            example = "His hairline slowly moved back as he turned forty this spring.",
            exampleNative = "К сорока годам его hairline постепенно отступила назад.",
            pos = "noun", semanticGroup = "appearance_face_anatomy", fillInBlankExclusions = listOf(38202L, 38203L, 38204L, 38205L)),

        WordEntity(id = 38202, setId = 382, languagePair = "en-ru", rarity = "RARE",
            original = "lobe",
            transliteration = "[loʊb]",
            translation = "мочка (уха)",
            definition = "The soft round part at the bottom of the outer ear.",
            definitionNative = "Мягкая округлая часть внизу наружной части уха.",
            example = "The tiny gold stud sat neatly in the lobe of her ear.",
            exampleNative = "Крошечная золотая серёжка аккуратно сидела в lobe её уха.",
            pos = "noun", semanticGroup = "appearance_face_anatomy", fillInBlankExclusions = listOf(38201L, 38203L, 38204L, 38205L)),

        WordEntity(id = 38203, setId = 382, languagePair = "en-ru", rarity = "RARE",
            original = "eyelid",
            transliteration = "[ˈaɪˌlɪd]",
            translation = "веко",
            definition = "The thin skin that closes over the eye when you blink.",
            definitionNative = "Тонкая кожа, закрывающая глаз при моргании.",
            example = "A small mosquito bite swelled up on her upper eyelid overnight.",
            exampleNative = "Маленький укус комара вспух за ночь на её верхнем eyelid.",
            pos = "noun", semanticGroup = "appearance_face_anatomy", fillInBlankExclusions = listOf(38201L, 38202L, 38204L, 38205L)),

        WordEntity(id = 38204, setId = 382, languagePair = "en-ru", rarity = "RARE",
            original = "nostril",
            transliteration = "[ˈnɑstrəl]",
            translation = "ноздря",
            definition = "One of the two openings at the bottom of the nose.",
            definitionNative = "Одно из двух отверстий внизу носа.",
            example = "He flared one nostril in disgust at the strong cheese smell.",
            exampleNative = "Он раздул одну nostril, ощутив резкий запах сыра.",
            pos = "noun", semanticGroup = "appearance_face_anatomy", fillInBlankExclusions = listOf(38201L, 38202L, 38203L, 38205L)),

        WordEntity(id = 38205, setId = 382, languagePair = "en-ru", rarity = "EPIC",
            original = "brow",
            transliteration = "[braʊ]",
            translation = "надбровье, лоб",
            definition = "The bone area above the eyes — also a poetic word for the forehead.",
            definitionNative = "Костистая зона над глазами — также поэтичное слово для лба.",
            example = "Sweat dripped from his brow as he ran the final hill.",
            exampleNative = "Пот капал с его brow, когда он бежал последний холм.",
            pos = "noun", semanticGroup = "appearance_face_anatomy", fillInBlankExclusions = listOf(38201L, 38202L, 38203L, 38204L, 38208L, 38209L)),

        // ── appearance_skeletal (5) ───────────────────────────────────────

        WordEntity(id = 38206, setId = 382, languagePair = "en-ru", rarity = "RARE",
            original = "collarbone",
            transliteration = "[ˈkɑlərˌboʊn]",
            translation = "ключица",
            definition = "The long thin bone you can see going from shoulder to throat.",
            definitionNative = "Длинная тонкая кость от плеча к горлу — её видно у худых.",
            example = "The dancer's elegant dress showed off her delicate collarbone beautifully.",
            exampleNative = "Изящное платье танцовщицы красиво подчёркивало её collarbone.",
            pos = "noun", semanticGroup = "appearance_skeletal", fillInBlankExclusions = listOf(38207L, 38208L, 38209L, 38210L)),

        WordEntity(id = 38207, setId = 382, languagePair = "en-ru", rarity = "RARE",
            original = "knuckle",
            transliteration = "[ˈnəkəl]",
            translation = "костяшка пальца",
            definition = "A small joint where a finger bends — you feel it when fist is closed.",
            definitionNative = "Сустав, где сгибается палец — выступает при сжатом кулаке.",
            example = "He hit his knuckle on the door frame and yelped in pain.",
            exampleNative = "Он ударился knuckle о дверной косяк и громко вскрикнул.",
            pos = "noun", semanticGroup = "appearance_skeletal", fillInBlankExclusions = listOf(38205L, 38206L, 38208L, 38209L, 38210L)),

        WordEntity(id = 38208, setId = 382, languagePair = "en-ru", rarity = "RARE",
            original = "temple",
            transliteration = "[ˈtɛmpəl]",
            translation = "висок",
            definition = "The flat soft area on the side of the head, near each eye.",
            definitionNative = "Ровное мягкое место сбоку головы — рядом с каждым глазом.",
            example = "She rubbed her temple gently to ease the slow morning headache.",
            exampleNative = "Она мягко потёрла свой temple, чтобы унять головную боль.",
            pos = "noun", semanticGroup = "appearance_skeletal", fillInBlankExclusions = listOf(38205L, 38206L, 38207L, 38209L, 38210L)),

        WordEntity(id = 38209, setId = 382, languagePair = "en-ru", rarity = "RARE",
            original = "jaw",
            transliteration = "[ʤɔ]",
            translation = "челюсть",
            definition = "The bone that holds the teeth — moves when you chew or talk.",
            definitionNative = "Кость, держащая зубы — двигается при жевании и разговоре.",
            example = "His lower jaw dropped open in shock at the surprise news.",
            exampleNative = "Его нижняя jaw отвисла от удивления при неожиданной новости.",
            pos = "noun", semanticGroup = "appearance_skeletal", fillInBlankExclusions = listOf(38206L, 38207L, 38208L, 38210L)),

        WordEntity(id = 38210, setId = 382, languagePair = "en-ru", rarity = "EPIC",
            original = "biceps",
            transliteration = "[ˈbaɪsɛps]",
            translation = "бицепс",
            definition = "The big round muscle on the front of the upper arm.",
            definitionNative = "Большая округлая мышца на передней части плеча.",
            example = "He flexed his biceps proudly in front of the bathroom mirror.",
            exampleNative = "Он гордо напряг biceps перед зеркалом в ванной.",
            pos = "noun", semanticGroup = "appearance_skeletal", fillInBlankExclusions = listOf(38206L, 38207L, 38208L, 38209L)),

        // ── appearance_body_shape (5) ─────────────────────────────────────

        WordEntity(id = 38211, setId = 382, languagePair = "en-ru", rarity = "RARE",
            original = "hourglass",
            transliteration = "[ˈaʊərˌglæs]",
            translation = "фигура «песочные часы»",
            definition = "A body shape with a narrow waist and wider hips and shoulders.",
            definitionNative = "Фигура с узкой талией и более широкими бёдрами и плечами.",
            example = "The vintage dress fit her hourglass figure absolutely like a glove.",
            exampleNative = "Винтажное платье село на её hourglass фигуру как влитое.",
            pos = "noun", semanticGroup = "appearance_body_shape", fillInBlankExclusions = listOf(38212L, 38213L, 38214L, 38215L)),

        WordEntity(id = 38212, setId = 382, languagePair = "en-ru", rarity = "RARE",
            original = "athletic",
            transliteration = "[æθˈlɛtɪk]",
            translation = "атлетический",
            definition = "Strong and fit — like a person who plays sport regularly.",
            definitionNative = "Сильный и подтянутый — как у человека, регулярно занимающегося спортом.",
            example = "Her athletic build came from years of swimming and morning runs.",
            exampleNative = "Её athletic телосложение — результат долгих лет плавания и пробежек.",
            pos = "adjective", semanticGroup = "appearance_body_shape", fillInBlankExclusions = listOf(38211L, 38213L, 38214L, 38215L)),

        WordEntity(id = 38213, setId = 382, languagePair = "en-ru", rarity = "RARE",
            original = "petite",
            transliteration = "[pəˈtit]",
            translation = "миниатюрная",
            definition = "Small and delicate in size — usually said about a woman.",
            definitionNative = "Маленькая и изящная — обычно так говорят о женщине.",
            example = "The petite woman needed a stool to reach the top shelf.",
            exampleNative = "Petite женщине пришлось встать на табурет, чтоб достать до полки.",
            pos = "adjective", semanticGroup = "appearance_body_shape", fillInBlankExclusions = listOf(38212L, 38214L, 38215L, 38216L, 38218L, 38220L, 38222L, 38224L)),

        WordEntity(id = 38214, setId = 382, languagePair = "en-ru", rarity = "EPIC",
            original = "wiry",
            transliteration = "[ˈwaɪri]",
            translation = "жилистый",
            definition = "Thin but very strong — like a body made of tight ropes.",
            definitionNative = "Худой, но очень сильный — будто тело собрано из тугих верёвок.",
            example = "The wiry climber pulled himself up the cliff with sheer ease.",
            exampleNative = "Wiry скалолаз подтягивался по отвесной скале с лёгкостью.",
            pos = "adjective", semanticGroup = "appearance_body_shape", fillInBlankExclusions = listOf(38212L, 38213L, 38215L, 38218L)),

        WordEntity(id = 38215, setId = 382, languagePair = "en-ru", rarity = "EPIC",
            original = "curvaceous",
            transliteration = "[kərˈveɪʃəs]",
            translation = "фигуристая",
            definition = "Having a soft round body shape that draws the eye — said about women.",
            definitionNative = "С мягкой округлой женственной фигурой, привлекающей взгляд.",
            example = "The curvaceous singer wore a tight red gown to the awards.",
            exampleNative = "Curvaceous певица надела облегающее красное платье на церемонию.",
            pos = "adjective", semanticGroup = "appearance_body_shape", fillInBlankExclusions = listOf(38212L, 38213L, 38214L, 38218L)),

        // ── appearance_skin_quality (5) ───────────────────────────────────

        WordEntity(id = 38216, setId = 382, languagePair = "en-ru", rarity = "RARE",
            original = "freckled",
            transliteration = "[ˈfrɛkəld]",
            translation = "веснушчатый",
            definition = "Of skin — covered with many small light brown dots from the sun.",
            definitionNative = "О коже — покрытый множеством мелких светло-коричневых точек.",
            example = "Her freckled nose got even more spots during the seaside week.",
            exampleNative = "Её freckled нос покрылся ещё бóльшим числом точек за неделю у моря.",
            pos = "adjective", semanticGroup = "appearance_skin_quality", fillInBlankExclusions = listOf(38218L, 38219L, 38220L)),

        WordEntity(id = 38217, setId = 382, languagePair = "en-ru", rarity = "RARE",
            original = "acne",
            transliteration = "[ˈækni]",
            translation = "угревая сыпь",
            definition = "A skin problem with many small red bumps — common in teenage years.",
            definitionNative = "Кожная проблема со множеством красных бугорков — частая у подростков.",
            example = "Her stubborn acne finally cleared up after the long summer break.",
            exampleNative = "Её упрямая acne наконец прошла после долгих летних каникул.",
            pos = "noun", semanticGroup = "appearance_skin_quality"),

        WordEntity(id = 38218, setId = 382, languagePair = "en-ru", rarity = "RARE",
            original = "tanned",
            transliteration = "[tænd]",
            translation = "загорелый",
            definition = "Having brown skin from spending time in strong sunlight.",
            definitionNative = "С коричневой кожей — после долгого пребывания на ярком солнце.",
            example = "He came back tanned and rested after two weeks in Greece.",
            exampleNative = "Он вернулся tanned и отдохнувшим после двух недель в Греции.",
            pos = "adjective", semanticGroup = "appearance_skin_quality", fillInBlankExclusions = listOf(38216L, 38219L, 38220L, 38221L, 38223L, 38225L)),

        WordEntity(id = 38219, setId = 382, languagePair = "en-ru", rarity = "RARE",
            original = "olive",
            transliteration = "[ˈɑlɪv]",
            translation = "оливковый (тон кожи)",
            definition = "Of skin — having a light yellow-brown shade common in the Mediterranean.",
            definitionNative = "О коже — со светлым жёлто-коричневым оттенком, как у южан.",
            example = "Her olive skin tone never burned during long summer days outdoors.",
            exampleNative = "Её olive кожа никогда не обгорала за долгие летние дни на улице.",
            pos = "adjective", semanticGroup = "appearance_skin_quality", fillInBlankExclusions = listOf(38216L, 38218L, 38220L)),

        WordEntity(id = 38220, setId = 382, languagePair = "en-ru", rarity = "EPIC",
            original = "ruddy",
            transliteration = "[ˈrədi]",
            translation = "румяный",
            definition = "Having a healthy red-pink colour in the face — usually from cold or wind.",
            definitionNative = "С розово-красным здоровым цветом лица — от холода или ветра.",
            example = "The farmer had a ruddy face from working in the cold air.",
            exampleNative = "У фермера было ruddy лицо после работы на холодном воздухе.",
            pos = "adjective", semanticGroup = "appearance_skin_quality", fillInBlankExclusions = listOf(38216L, 38218L)),

        // ── appearance_grooming_style (5) ─────────────────────────────────

        WordEntity(id = 38221, setId = 382, languagePair = "en-ru", rarity = "RARE",
            original = "groomed",
            transliteration = "[grumd]",
            translation = "ухоженный",
            definition = "Looking neat and clean — hair, nails and clothes all in good order.",
            definitionNative = "С опрятным видом — волосы, ногти и одежда в полном порядке.",
            example = "The well-groomed lawyer arrived early for the important morning meeting.",
            exampleNative = "Хорошо groomed юрист пришёл заранее на важную утреннюю встречу.",
            pos = "adjective", semanticGroup = "appearance_grooming_style", fillInBlankExclusions = listOf(38222L, 38223L, 38224L, 38225L)),

        WordEntity(id = 38222, setId = 382, languagePair = "en-ru", rarity = "RARE",
            original = "dishevelled",
            transliteration = "[dɪˈʃɛvəld]",
            translation = "взлохмаченный",
            definition = "Looking messy — like after sleep, wind or a hurry to leave.",
            definitionNative = "С растрёпанным видом — как после сна, ветра или быстрых сборов.",
            example = "He looked dishevelled after rushing through the rain to the office.",
            exampleNative = "Он выглядел dishevelled после бега под дождём до офиса.",
            pos = "adjective", semanticGroup = "appearance_grooming_style", fillInBlankExclusions = listOf(38220L, 38221L, 38223L, 38224L, 38225L)),

        WordEntity(id = 38223, setId = 382, languagePair = "en-ru", rarity = "RARE",
            original = "polished",
            transliteration = "[ˈpɑlɪʃt]",
            translation = "безупречный (о виде)",
            definition = "Smart and finished in look — every detail thought through.",
            definitionNative = "С продуманным аккуратным видом — где всё доведено до блеска.",
            example = "Her polished style impressed every client at the fancy law firm.",
            exampleNative = "Её polished стиль впечатлял каждого клиента в престижной фирме.",
            pos = "adjective", semanticGroup = "appearance_grooming_style", fillInBlankExclusions = listOf(38221L, 38222L, 38224L, 38225L)),

        WordEntity(id = 38224, setId = 382, languagePair = "en-ru", rarity = "EPIC",
            original = "scruffy",
            transliteration = "[ˈskrəfi]",
            translation = "потрёпанный",
            definition = "Looking shabby and untidy — old clothes, messy hair, no care.",
            definitionNative = "С небрежным неряшливым видом — старая одежда, нечёсаные волосы.",
            example = "The scruffy student rolled into class wearing the same hoodie again.",
            exampleNative = "Scruffy студент ввалился на пару опять в той же толстовке.",
            pos = "adjective", semanticGroup = "appearance_grooming_style", fillInBlankExclusions = listOf(38212L, 38213L, 38214L, 38216L, 38218L, 38220L, 38221L, 38222L, 38223L, 38225L)),

        WordEntity(id = 38225, setId = 382, languagePair = "en-ru", rarity = "EPIC",
            original = "dapper",
            transliteration = "[ˈdæpər]",
            translation = "щеголеватый",
            definition = "Smartly dressed in a stylish way — said mostly about a man.",
            definitionNative = "Стильно и франтовато одетый — обычно говорят о мужчине.",
            example = "The dapper gentleman tipped his hat as he passed the ladies.",
            exampleNative = "Dapper джентльмен приподнял шляпу, проходя мимо дам.",
            pos = "adjective", semanticGroup = "appearance_grooming_style", fillInBlankExclusions = listOf(38212L, 38214L, 38216L, 38218L, 38220L, 38221L, 38222L, 38223L, 38224L)),
    )
}
