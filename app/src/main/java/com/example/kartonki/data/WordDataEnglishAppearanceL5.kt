package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Внешность и тело (L5, носитель / литературный).
 *
 * Set 384: «Внешность и тело» — литературные эпитеты и поэтика.
 *          Архаичные и возвышенные слова, какие встречаются в худ.прозе,
 *          поэзии и старых описаниях персонажей: мина и облик, оттенки
 *          кожи поэтической манерой, силуэты, осанки и «состояния».
 *
 * Чем L5 отличается от L1-L4:
 *   - L1 (380): базовые части лица/тела, причёска, телосложение (A1-A2).
 *   - L2 (381): мимика, типы причёсок, отметины (A2-B1).
 *   - L3 (382): тонкая анатомия, типы фигуры, стиль, кожа (B2-C1).
 *   - L4 (383): зарезервирован — продвинутая лексика B2-C1 без архаики.
 *   - L5 (384): литературные эпитеты — mien, countenance, alabaster,
 *               saturnine, willowy, debonair, hoary, comely и т.п. C2+.
 *
 * Cross-set анти-дубли (проверено grep'ом):
 *   - L1: cheek, chin, forehead, eyebrow, eyelash, blonde, curly, bald,
 *         beard, ponytail, freckle, wrinkle, mole, dimple, sunburn, slim,
 *         plump, skinny, muscular, slender, lips, teeth, palm, ankle, toe.
 *   - L2: bun, braid, fringe, sideburns, stubble, grin, smirk, scowl,
 *         glare, wink, burly, stocky, chubby, scrawny, brawny, whisker,
 *         nape, blush, cleft, gap, tattoo, piercing, crease, birthmark, wart.
 *   - L3: hairline, lobe, eyelid, nostril, brow, collarbone, knuckle,
 *         temple, jaw, biceps, hourglass, athletic, petite, wiry,
 *         curvaceous, freckled, acne, tanned, olive, ruddy, groomed,
 *         dishevelled, polished, scruffy, dapper.
 *   - В L5 повтора нет (grep по `original` чистый по всем 25).
 *   - ALL_EXCLUSIVE (achievement words) — пересечений нет.
 *
 * Распределение редкости: 18 LEGENDARY + 7 EPIC — два смежных уровня C1/C2+.
 *
 * SemanticGroups (5 × 5):
 *   appearance_literary_face       — mien, countenance, visage, aquiline, hawk-nosed
 *   appearance_literary_skin       — alabaster, sallow, hoary, wan, swarthy
 *   appearance_literary_figure     — statuesque, willowy, lissome, voluptuous, gangly
 *   appearance_literary_demeanour  — saturnine, jaunty, demure, debonair, raffish
 *   appearance_literary_state      — comely, ravishing, gaunt, haggard, callow
 *
 * Word IDs: setId × 100 + position (38401..38425).
 *
 * isFillInBlankSafe / fillInBlankExclusions — не задаём, defaults
 * сработают, FILL_IN_BLANK pipeline зальёт сам.
 */
object WordDataEnglishAppearanceL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 384,
            languagePair = "en-ru",
            orderIndex = 384,
            name = "Внешность и тело",
            description = "Литературные эпитеты и поэтика внешности",
            topic = "Внешность и тело",
            level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 384 — Внешность и тело: литературное (L5, EPIC+LEGENDARY)   ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── appearance_literary_face (5) ──────────────────────────────────

        WordEntity(id = 38401, setId = 384, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "mien",
            transliteration = "[miːn]",
            translation = "облик, манера держаться",
            definition = "The look on someone's face that quietly shows their mood.",
            definitionNative = "Выражение лица, тихо передающее настроение или нрав.",
            example = "The old judge entered the hall with a grave and solemn mien.",
            exampleNative = "Старый судья вошёл в зал с серьёзным, торжественным mien.",
            pos = "noun", semanticGroup = "appearance_literary_face", fillInBlankExclusions = listOf(38402L, 38403L)),

        WordEntity(id = 38402, setId = 384, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "countenance",
            transliteration = "[ˈkaʊntənəns]",
            translation = "лик, выражение лица",
            definition = "A person's face — especially as it shows feeling or character.",
            definitionNative = "Лицо человека — особенно как зеркало чувства или нрава.",
            example = "Her gentle countenance brightened the moment she saw the old letters.",
            exampleNative = "Её мягкий countenance просветлел, едва она увидела старые письма.",
            pos = "noun", semanticGroup = "appearance_literary_face", fillInBlankExclusions = listOf(38401L, 38403L)),

        WordEntity(id = 38403, setId = 384, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "visage",
            transliteration = "[ˈvɪzɪdʒ]",
            translation = "лик (поэт.)",
            definition = "A face seen in a poetic or noble way — often in old books.",
            definitionNative = "Лицо в возвышенном поэтическом смысле — часто в старой прозе.",
            example = "The portrait showed a stern visage carved by years of hard war.",
            exampleNative = "На портрете был суровый visage, вытесанный годами тяжёлой войны.",
            pos = "noun", semanticGroup = "appearance_literary_face", fillInBlankExclusions = listOf(38401L, 38402L)),

        WordEntity(id = 38404, setId = 384, languagePair = "en-ru", rarity = "EPIC",
            original = "aquiline",
            transliteration = "[ˈækwəˌlaɪn]",
            translation = "орлиный (о носе)",
            definition = "Curved like an eagle's beak — said about a sharp noble nose.",
            definitionNative = "Изогнутый как клюв орла — обычно о крупном благородном носе.",
            example = "The actor's aquiline profile suited every Roman role he played.",
            exampleNative = "Aquiline профиль актёра подходил для всех его римских ролей.",
            pos = "adjective", semanticGroup = "appearance_literary_face", fillInBlankExclusions = listOf(38405L, 38409L, 38411L, 38412L, 38413L, 38414L, 38415L, 38416L, 38417L, 38418L, 38419L, 38420L, 38421L, 38422L, 38423L, 38424L, 38425L)),

        WordEntity(id = 38405, setId = 384, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hawk-nosed",
            transliteration = "[ˈhɔːkˌnoʊzd]",
            translation = "с ястребиным носом",
            definition = "Having a sharply curved nose — like the beak of a hawk.",
            definitionNative = "С резко изогнутым носом — словно клюв у ястреба.",
            example = "A tall hawk-nosed stranger watched the road from under his hood.",
            exampleNative = "Высокий hawk-nosed незнакомец следил за дорогой из-под капюшона.",
            pos = "adjective", semanticGroup = "appearance_literary_face", fillInBlankExclusions = listOf(38404L, 38407L, 38408L, 38409L, 38410L, 38411L, 38412L, 38413L, 38415L, 38416L, 38417L, 38419L, 38420L, 38421L, 38423L, 38424L, 38425L)),

        // ── appearance_literary_skin (5) ──────────────────────────────────

        WordEntity(id = 38406, setId = 384, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "alabaster",
            transliteration = "[ˈæləˌbæstər]",
            translation = "алебастровый (о коже)",
            definition = "Smooth and very pale — like fine white stone polished to shine.",
            definitionNative = "Гладкий и очень бледный — как отполированный белый камень.",
            example = "Her alabaster shoulders glowed softly in the candlelight that night.",
            exampleNative = "Её alabaster плечи мягко светились в пламени свечей.",
            pos = "adjective", semanticGroup = "appearance_literary_skin", fillInBlankExclusions = listOf(38407L, 38408L, 38409L, 38410L, 38411L, 38412L, 38414L, 38421L, 38422L, 38423L)),

        WordEntity(id = 38407, setId = 384, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "sallow",
            transliteration = "[ˈsæloʊ]",
            translation = "землистый, желтоватый",
            definition = "Of skin — having an unhealthy dull tone with a tinge of yellow.",
            definitionNative = "О коже — с нездоровым тусклым оттенком, отдающим в охру.",
            example = "The clerk's sallow cheeks betrayed his many sleepless nights at work.",
            exampleNative = "Sallow щёки клерка выдавали его бессонные ночи за работой.",
            pos = "adjective", semanticGroup = "appearance_literary_skin", fillInBlankExclusions = listOf(38406L, 38408L, 38409L, 38410L, 38423L, 38424L)),

        WordEntity(id = 38408, setId = 384, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hoary",
            transliteration = "[ˈhɔːri]",
            translation = "седой, убелённый сединами",
            definition = "Grey or white from age — said of hair, beard or an old person.",
            definitionNative = "Серебристо-белый от прожитых лет — о волосах, бороде или старце.",
            example = "A hoary fisherman mended his nets on the windy stone pier.",
            exampleNative = "Hoary рыбак чинил сети на ветреном каменном причале.",
            pos = "adjective", semanticGroup = "appearance_literary_skin", fillInBlankExclusions = listOf(38405L, 38407L, 38409L, 38410L, 38411L, 38412L, 38413L, 38415L, 38416L, 38417L, 38419L, 38420L, 38421L, 38423L, 38424L, 38425L)),

        WordEntity(id = 38409, setId = 384, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "wan",
            transliteration = "[wɒn]",
            translation = "бледный, изнурённый",
            definition = "Pale and tired-looking — as if from illness or long sorrow.",
            definitionNative = "Без кровинки в лице и усталый — будто после болезни или горя.",
            example = "She gave a wan smile from the hospital bed and waved weakly.",
            exampleNative = "Она подарила wan улыбку с больничной койки и слабо махнула.",
            pos = "adjective", semanticGroup = "appearance_literary_skin", fillInBlankExclusions = listOf(38407L, 38408L, 38410L, 38416L, 38417L, 38418L, 38419L, 38420L, 38421L, 38422L, 38423L, 38424L, 38425L)),

        WordEntity(id = 38410, setId = 384, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "swarthy",
            transliteration = "[ˈswɔːrði]",
            translation = "смуглый",
            definition = "Of skin — having a dark brown shade, often from sun and toil.",
            definitionNative = "О коже — тёмно-коричневого тона, часто от солнца и труда.",
            example = "A swarthy sailor strode along the docks with a heavy oak chest.",
            exampleNative = "Swarthy моряк шагал вдоль причала с тяжёлым дубовым сундуком.",
            pos = "adjective", semanticGroup = "appearance_literary_skin", fillInBlankExclusions = listOf(38405L, 38407L, 38408L, 38409L, 38411L, 38412L, 38413L, 38415L, 38416L, 38417L, 38419L, 38420L, 38421L, 38423L, 38424L, 38425L)),

        // ── appearance_literary_figure (5) ────────────────────────────────

        WordEntity(id = 38411, setId = 384, languagePair = "en-ru", rarity = "EPIC",
            original = "statuesque",
            transliteration = "[ˌstætʃuˈɛsk]",
            translation = "статный, величественный",
            definition = "Tall and strikingly graceful — like a fine sculpture come alive.",
            definitionNative = "Высокий и поразительно изящный — будто ожившая скульптура.",
            example = "A statuesque dancer crossed the stage with slow, queenly steps.",
            exampleNative = "Statuesque танцовщица пересекла сцену медленным царственным шагом.",
            pos = "adjective", semanticGroup = "appearance_literary_figure", fillInBlankExclusions = listOf(38407L, 38408L, 38409L, 38410L, 38412L, 38413L, 38414L, 38415L, 38416L, 38417L, 38418L, 38419L, 38420L, 38421L, 38422L, 38423L, 38424L, 38425L)),

        WordEntity(id = 38412, setId = 384, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "willowy",
            transliteration = "[ˈwɪloʊi]",
            translation = "тонкий и гибкий, как ива",
            definition = "Tall, slim and gracefully bending — like a young tree in the wind.",
            definitionNative = "Высокий, стройный и гнущийся — словно молодое деревце на ветру.",
            example = "The willowy model glided down the runway in a flowing silk gown.",
            exampleNative = "Willowy модель плыла по подиуму в струящемся шёлковом платье.",
            pos = "adjective", semanticGroup = "appearance_literary_figure", fillInBlankExclusions = listOf(38407L, 38408L, 38409L, 38410L, 38411L, 38413L, 38414L, 38415L, 38416L, 38417L, 38418L, 38419L, 38420L, 38421L, 38422L, 38423L, 38424L, 38425L)),

        WordEntity(id = 38413, setId = 384, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "lissome",
            transliteration = "[ˈlɪsəm]",
            translation = "гибкий, грациозный",
            definition = "Moving in a soft easy way — light on the feet, supple and smooth.",
            definitionNative = "Двигающийся мягко и плавно — легко на ногах, без угловатости.",
            example = "The lissome gymnast bent backwards into an effortless arching bridge.",
            exampleNative = "Lissome гимнастка прогнулась назад в лёгкий изящный мостик.",
            pos = "adjective", semanticGroup = "appearance_literary_figure", fillInBlankExclusions = listOf(38407L, 38408L, 38409L, 38410L, 38411L, 38412L, 38414L, 38415L, 38416L, 38417L, 38418L, 38419L, 38420L, 38421L, 38422L, 38423L, 38424L, 38425L)),

        WordEntity(id = 38414, setId = 384, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "voluptuous",
            transliteration = "[vəˈlʌptʃuəs]",
            translation = "пышный, чувственный",
            definition = "Having a full round figure that pleases the eye in a sensual way.",
            definitionNative = "С округлой полнотелой фигурой, манящей взгляд телесной красотой.",
            example = "The painter loved drawing the voluptuous goddesses of the old myths.",
            exampleNative = "Художник любил рисовать voluptuous богинь древних мифов.",
            pos = "adjective", semanticGroup = "appearance_literary_figure", fillInBlankExclusions = listOf(38406L, 38407L, 38408L, 38409L, 38410L, 38411L, 38412L, 38413L, 38415L, 38416L, 38417L, 38418L, 38420L, 38421L, 38422L, 38423L, 38424L)),

        WordEntity(id = 38415, setId = 384, languagePair = "en-ru", rarity = "EPIC",
            original = "gangly",
            transliteration = "[ˈɡæŋɡli]",
            translation = "долговязый, нескладный",
            definition = "Tall and thin in an awkward way — as if the limbs are too long.",
            definitionNative = "Высокий и худой неуклюже — будто конечности слишком длинные.",
            example = "The gangly teenager kept tripping over his own oversized sneakers.",
            exampleNative = "Gangly подросток то и дело спотыкался о свои огромные кроссовки.",
            pos = "adjective", semanticGroup = "appearance_literary_figure", fillInBlankExclusions = listOf(38405L, 38407L, 38408L, 38409L, 38410L, 38411L, 38412L, 38413L, 38414L, 38416L, 38417L, 38419L, 38420L, 38421L, 38423L, 38424L, 38425L)),

        // ── appearance_literary_demeanour (5) ─────────────────────────────

        WordEntity(id = 38416, setId = 384, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "saturnine",
            transliteration = "[ˈsætərˌnaɪn]",
            translation = "мрачный, угрюмый",
            definition = "Looking gloomy and dark in mood — as if shadowed from within.",
            definitionNative = "С тяжёлым сумеречным видом — будто тень лежит на душе.",
            example = "The saturnine professor rarely smiled at his quiet evening lectures.",
            exampleNative = "Saturnine профессор редко улыбался на тихих вечерних лекциях.",
            pos = "adjective", semanticGroup = "appearance_literary_demeanour", fillInBlankExclusions = listOf(38405L, 38407L, 38408L, 38409L, 38410L, 38411L, 38412L, 38413L, 38415L, 38417L, 38418L, 38419L, 38420L, 38421L, 38423L, 38424L, 38425L)),

        WordEntity(id = 38417, setId = 384, languagePair = "en-ru", rarity = "EPIC",
            original = "jaunty",
            transliteration = "[ˈdʒɔːnti]",
            translation = "бойкий, лихой",
            definition = "Looking cheerful and self-assured — moving with a light playful step.",
            definitionNative = "С весёлым и уверенным видом — лёгкая игривая походка.",
            example = "He wore his hat at a jaunty angle as he strolled along.",
            exampleNative = "Он носил шляпу под jaunty углом, прогуливаясь по улице.",
            pos = "adjective", semanticGroup = "appearance_literary_demeanour", fillInBlankExclusions = listOf(38416L, 38418L, 38419L, 38420L)),

        WordEntity(id = 38418, setId = 384, languagePair = "en-ru", rarity = "EPIC",
            original = "demure",
            transliteration = "[dɪˈmjʊər]",
            translation = "скромный, сдержанный",
            definition = "Quiet and modest in manner — said about a young woman in old books.",
            definitionNative = "Тихая и застенчивая в манере — обычно о девушке в старых книгах.",
            example = "She gave a demure nod and lowered her eyes to the polished floor.",
            exampleNative = "Она кивнула demure и опустила глаза на блестящий пол.",
            pos = "adjective", semanticGroup = "appearance_literary_demeanour", fillInBlankExclusions = listOf(38416L, 38417L, 38419L, 38420L, 38425L)),

        WordEntity(id = 38419, setId = 384, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "debonair",
            transliteration = "[ˌdɛbəˈnɛər]",
            translation = "галантный, обходительный",
            definition = "Polished and charming in a confident, well-bred way — said of men.",
            definitionNative = "Лощёный и обаятельный — в уверенной породистой манере.",
            example = "The debonair host greeted each guest with a warm easy bow.",
            exampleNative = "Debonair хозяин приветствовал каждого гостя тёплым лёгким поклоном.",
            pos = "adjective", semanticGroup = "appearance_literary_demeanour", fillInBlankExclusions = listOf(38405L, 38407L, 38408L, 38409L, 38410L, 38411L, 38412L, 38413L, 38415L, 38416L, 38417L, 38418L, 38420L, 38421L, 38423L, 38424L, 38425L)),

        WordEntity(id = 38420, setId = 384, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "raffish",
            transliteration = "[ˈræfɪʃ]",
            translation = "разухабистый, бесшабашный",
            definition = "Looking a bit rough yet charming — slightly wild but stylish.",
            definitionNative = "Слегка потрёпанный, но обаятельный — немного дикий, но стильный.",
            example = "His raffish grin and rumpled jacket gave him a roguish pirate charm.",
            exampleNative = "Raffish ухмылка и мятый пиджак придавали ему пиратское обаяние.",
            pos = "adjective", semanticGroup = "appearance_literary_demeanour", fillInBlankExclusions = listOf(38409L, 38416L, 38417L, 38418L, 38419L, 38423L, 38424L, 38425L)),

        // ── appearance_literary_state (5) ─────────────────────────────────

        WordEntity(id = 38421, setId = 384, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "comely",
            transliteration = "[ˈkʌmli]",
            translation = "пригожий, миловидный",
            definition = "Pleasant to look at in a calm, wholesome way — used in old prose.",
            definitionNative = "Приятный наружно — в спокойном, добром смысле, как в старой прозе.",
            example = "A comely maid brought fresh bread and warm milk to the table.",
            exampleNative = "Comely девушка принесла свежий хлеб и тёплое молоко на стол.",
            pos = "adjective", semanticGroup = "appearance_literary_state", fillInBlankExclusions = listOf(38405L, 38407L, 38408L, 38409L, 38410L, 38411L, 38412L, 38413L, 38414L, 38415L, 38416L, 38417L, 38418L, 38419L, 38420L, 38422L, 38423L, 38424L, 38425L)),

        WordEntity(id = 38422, setId = 384, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "ravishing",
            transliteration = "[ˈrævɪʃɪŋ]",
            translation = "сногсшибательный",
            definition = "So lovely in looks that it almost takes the breath away.",
            definitionNative = "Настолько прекрасный внешне, что от вида захватывает дух.",
            example = "She looked simply ravishing in the long emerald evening dress.",
            exampleNative = "Она выглядела просто ravishing в длинном изумрудном платье.",
            pos = "adjective", semanticGroup = "appearance_literary_state", fillInBlankExclusions = listOf(38407L, 38408L, 38409L, 38410L, 38411L, 38412L, 38413L, 38414L, 38415L, 38416L, 38417L, 38418L, 38420L, 38421L, 38423L, 38424L, 38425L)),

        WordEntity(id = 38423, setId = 384, languagePair = "en-ru", rarity = "EPIC",
            original = "gaunt",
            transliteration = "[ɡɔːnt]",
            translation = "измождённый, исхудалый",
            definition = "Very thin and bony — usually from hunger, hardship or long illness.",
            definitionNative = "Очень худой и костлявый — от голода, тягот или долгой болезни.",
            example = "The gaunt traveller stumbled into the inn after weeks on the road.",
            exampleNative = "Gaunt путник ввалился в трактир после долгих недель в пути.",
            pos = "adjective", semanticGroup = "appearance_literary_state", fillInBlankExclusions = listOf(38405L, 38407L, 38408L, 38409L, 38410L, 38411L, 38412L, 38413L, 38414L, 38415L, 38416L, 38417L, 38418L, 38419L, 38420L, 38421L, 38422L, 38424L, 38425L)),

        WordEntity(id = 38424, setId = 384, languagePair = "en-ru", rarity = "EPIC",
            original = "haggard",
            transliteration = "[ˈhæɡərd]",
            translation = "измученный, осунувшийся",
            definition = "Looking tired and worn out — with hollow cheeks and dark eyes.",
            definitionNative = "Усталый и измотанный на вид — со впалыми щеками и тёмными глазами.",
            example = "He came home haggard after sitting up all night with the baby.",
            exampleNative = "Он пришёл домой haggard после ночи без сна с малышом.",
            pos = "adjective", semanticGroup = "appearance_literary_state", fillInBlankExclusions = listOf(38407L, 38409L, 38416L, 38421L, 38422L, 38423L, 38425L)),

        WordEntity(id = 38425, setId = 384, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "callow",
            transliteration = "[ˈkæloʊ]",
            translation = "юный и неопытный, зелёный",
            definition = "Young and lacking experience — still soft and not yet seasoned.",
            definitionNative = "Юный и без опыта — ещё мягкий, не закалённый жизнью.",
            example = "A callow recruit fumbled with the rifle on his very first day.",
            exampleNative = "Callow новобранец неловко возился с винтовкой в первый же день.",
            pos = "adjective", semanticGroup = "appearance_literary_state", fillInBlankExclusions = listOf(38405L, 38407L, 38408L, 38409L, 38410L, 38411L, 38412L, 38413L, 38415L, 38416L, 38417L, 38419L, 38420L, 38421L, 38422L, 38423L, 38424L)),
    )
}
