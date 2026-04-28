package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Внешность и тело (L4, профессиональный / C1).
 *
 * Set 383: «Внешность и тело» — медицинский / анатомический регистр.
 *          Лексика, которую используют врачи, антропологи, художники-
 *          портретисты и судебные эксперты: соматотипы, тонкая анатомия
 *          лица и черепа, кожные состояния и опорно-двигательная ось.
 *
 * Параллельные сеты того же топика:
 *   - set 380 (L1): cheek, chin, forehead, eyebrow, eyelash, blonde,
 *     curly, bald, beard, ponytail, freckle, wrinkle, mole, dimple,
 *     sunburn, slim, plump, skinny, muscular, slender, lips, teeth,
 *     palm, ankle, toe.
 *   - set 381 (L2): bun, braid, fringe, sideburns, stubble, grin,
 *     smirk, scowl, glare, wink, burly, stocky, chubby, scrawny, brawny,
 *     whisker, nape, blush, cleft, gap, tattoo, piercing, crease,
 *     birthmark, wart.
 *   - set 382 (L3): hairline, lobe, eyelid, nostril, brow, collarbone,
 *     knuckle, temple, jaw, biceps, hourglass, athletic, petite, wiry,
 *     curvaceous, freckled, acne, tanned, olive, ruddy, groomed,
 *     dishevelled, polished, scruffy, dapper.
 *
 * L4-фокус (профессиональный, медико-анатомический):
 *   соматотипы (mesomorph/ectomorph/endomorph/hirsute/cherubic),
 *   тонкая анатомия лица (philtrum/columella/vermilion/nasolabial/
 *   periorbital), скелет черепа и зубочелюстная система (prognathism/
 *   malocclusion/supraorbital/cleft palate/ptosis), кожно-волосяные
 *   состояния и слёзный аппарат (melanocyte/alopecia/vitiligo/
 *   dermatoglyphic/lacrimal), опорно-двигательная ось (contralateral/
 *   scapular/deltoid/clavicular/gluteal).
 *
 * Cross-topic совпадений нет — grep по WordData*.kt чистый
 * (включая `cleft palate` — отдельная фраза, set 381 содержит
 * только `cleft` как ямочка на подбородке).
 *
 * Распределение редкости: 8 RARE + 17 EPIC — два смежных уровня B2/C1.
 *   RARE — широко известные медицинские прилагательные, попадающиеся
 *   в популярной анатомии (nasolabial, periorbital, supraorbital,
 *   lacrimal, scapular, deltoid, clavicular, gluteal).
 *   EPIC — узкоспециальная терминология врачебного / научного регистра.
 *
 * SemanticGroups (5 × 5):
 *   appearance_anthropometry        — mesomorph, ectomorph, endomorph,
 *                                     hirsute, cherubic
 *   appearance_face_anatomy_med     — philtrum, columella, vermilion,
 *                                     nasolabial, periorbital
 *   appearance_skull_jaw            — prognathism, malocclusion,
 *                                     supraorbital, cleft palate, ptosis
 *   appearance_skin_conditions      — melanocyte, alopecia, vitiligo,
 *                                     dermatoglyphic, lacrimal
 *   appearance_musculoskeletal      — contralateral, scapular, deltoid,
 *                                     clavicular, gluteal
 *
 * Word IDs: setId × 100 + position (38301..38325).
 *
 * isFillInBlankSafe / fillInBlankExclusions — не задаём; FILL_IN_BLANK
 * pipeline (см. `docs/claude/fill-in-blank-pipeline.md`) заполнит
 * exclusion-списки автоматически после прохода LLM.
 */
object WordDataEnglishAppearanceL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 383,
            languagePair = "en-ru",
            orderIndex = 383,
            name = "Внешность и тело",
            description = "Медицинская анатомия и типология телосложения",
            topic = "Внешность и тело",
            level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 383 — Внешность и тело: профессиональный (L4, RARE+EPIC)    ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── appearance_anthropometry (5) ──────────────────────────────────

        WordEntity(id = 38301, setId = 383, languagePair = "en-ru", rarity = "EPIC",
            original = "mesomorph",
            transliteration = "[ˈmɛzəˌmɔrf]",
            translation = "мезоморф",
            definition = "A body type that is naturally muscular and athletic — like a boxer.",
            definitionNative = "Тип сложения, естественно мускулистый и спортивный — как у боксёра.",
            example = "The trainer noted that his client was a classic mesomorph.",
            exampleNative = "Тренер отметил, что его клиент — классический mesomorph.",
            pos = "noun", semanticGroup = "appearance_anthropometry", fillInBlankExclusions = listOf(38302L, 38303L)),

        WordEntity(id = 38302, setId = 383, languagePair = "en-ru", rarity = "EPIC",
            original = "ectomorph",
            transliteration = "[ˈɛktəˌmɔrf]",
            translation = "эктоморф",
            definition = "A body type that is naturally lean and long-limbed — like a marathoner.",
            definitionNative = "Тип сложения — худой от природы, с длинными конечностями, как у марафонца.",
            example = "As an ectomorph, he struggled to put on weight in the gym.",
            exampleNative = "Будучи ectomorph, он с трудом набирал вес в спортзале.",
            pos = "noun", semanticGroup = "appearance_anthropometry", fillInBlankExclusions = listOf(38303L)),

        WordEntity(id = 38303, setId = 383, languagePair = "en-ru", rarity = "EPIC",
            original = "endomorph",
            transliteration = "[ˈɛndəˌmɔrf]",
            translation = "эндоморф",
            definition = "A body type that is naturally soft and round — gains weight easily.",
            definitionNative = "Тип сложения — мягкий и округлый от природы, легко набирает вес.",
            example = "An endomorph often loses fat best on a low-carb plan.",
            exampleNative = "Endomorph часто худеет лучше всего на низкоуглеводном плане.",
            pos = "noun", semanticGroup = "appearance_anthropometry", fillInBlankExclusions = listOf(38302L)),

        WordEntity(id = 38304, setId = 383, languagePair = "en-ru", rarity = "EPIC",
            original = "hirsute",
            transliteration = "[ˈhɜrsut]",
            translation = "волосатый (мед.)",
            definition = "Having a lot of body hair — used in books and medicine.",
            definitionNative = "С обильным волосяным покровом на теле — слово книжное и медицинское.",
            example = "His hirsute chest was clearly visible through the open shirt.",
            exampleNative = "Его hirsute грудь была хорошо видна сквозь расстёгнутую рубашку.",
            pos = "adjective", semanticGroup = "appearance_anthropometry", fillInBlankExclusions = listOf(38305L)),

        WordEntity(id = 38305, setId = 383, languagePair = "en-ru", rarity = "EPIC",
            original = "cherubic",
            transliteration = "[ʧəˈrubɪk]",
            translation = "ангелоподобный (о лице)",
            definition = "Having a sweet round face — like a small angel in old paintings.",
            definitionNative = "С милым округлым лицом — как у маленького ангела на старых картинах.",
            example = "The toddler smiled with a cherubic face full of pure joy.",
            exampleNative = "Малыш улыбался cherubic личиком, полным чистой радости.",
            pos = "adjective", semanticGroup = "appearance_anthropometry", fillInBlankExclusions = listOf(38304L)),

        // ── appearance_face_anatomy_med (5) ───────────────────────────────

        WordEntity(id = 38306, setId = 383, languagePair = "en-ru", rarity = "EPIC",
            original = "philtrum",
            transliteration = "[ˈfɪltrəm]",
            translation = "губной желобок",
            definition = "The small vertical groove on the upper lip below the nose.",
            definitionNative = "Маленькая вертикальная бороздка на верхней губе — прямо под носом.",
            example = "The makeup artist carefully highlighted her philtrum with a pale pencil.",
            exampleNative = "Визажист аккуратно подсветила её philtrum светлым карандашом.",
            pos = "noun", semanticGroup = "appearance_face_anatomy_med", fillInBlankExclusions = listOf(38307L, 38308L)),

        WordEntity(id = 38307, setId = 383, languagePair = "en-ru", rarity = "EPIC",
            original = "columella",
            transliteration = "[ˌkɑljəˈmɛlə]",
            translation = "колумелла, кожная перегородка носа",
            definition = "The fleshy strip of skin between the two openings of the nose.",
            definitionNative = "Мясистая полоска кожи между двумя отверстиями у основания носа.",
            example = "The surgeon studied the patient's columella before planning the procedure.",
            exampleNative = "Хирург изучил columella пациента, прежде чем планировать операцию.",
            pos = "noun", semanticGroup = "appearance_face_anatomy_med", fillInBlankExclusions = listOf(38306L, 38308L)),

        WordEntity(id = 38308, setId = 383, languagePair = "en-ru", rarity = "EPIC",
            original = "vermilion",
            transliteration = "[vərˈmɪljən]",
            translation = "красная кайма губ",
            definition = "The red border of the lips, where soft skin meets normal skin.",
            definitionNative = "Красная кромка губ — место, где мягкая ткань переходит в обычную кожу.",
            example = "A small cut on the vermilion of his lower lip refused to heal.",
            exampleNative = "Маленький порез на vermilion нижней губы никак не заживал.",
            pos = "noun", semanticGroup = "appearance_face_anatomy_med", fillInBlankExclusions = listOf(38306L, 38307L)),

        WordEntity(id = 38309, setId = 383, languagePair = "en-ru", rarity = "RARE",
            original = "nasolabial",
            transliteration = "[ˌneɪzoʊˈleɪbiəl]",
            translation = "носогубный",
            definition = "Of the area between the side of the nose and the corner of the mouth.",
            definitionNative = "Относящийся к зоне между крылом носа и углом рта.",
            example = "Deep nasolabial folds appeared on her face after years of smoking.",
            exampleNative = "Глубокие nasolabial складки появились на её лице после лет курения.",
            pos = "adjective", semanticGroup = "appearance_face_anatomy_med", fillInBlankExclusions = listOf(38310L)),

        WordEntity(id = 38310, setId = 383, languagePair = "en-ru", rarity = "RARE",
            original = "periorbital",
            transliteration = "[ˌpɛriˈɔrbɪtəl]",
            translation = "периорбитальный, окологлазничный",
            definition = "Of or near the area around the eye socket.",
            definitionNative = "Относящийся к зоне вокруг глазницы или прилежащий к ней.",
            example = "He noticed dark periorbital shadows after a week of poor sleep.",
            exampleNative = "Он заметил тёмные periorbital тени после недели плохого сна.",
            pos = "adjective", semanticGroup = "appearance_face_anatomy_med", fillInBlankExclusions = listOf(38309L)),

        // ── appearance_skull_jaw (5) ──────────────────────────────────────

        WordEntity(id = 38311, setId = 383, languagePair = "en-ru", rarity = "EPIC",
            original = "prognathism",
            transliteration = "[ˈprɑɡnəθɪzəm]",
            translation = "прогнатизм",
            definition = "A condition where the lower jaw sticks forward more than usual.",
            definitionNative = "Состояние, при котором нижняя челюсть выступает вперёд сильнее обычного.",
            example = "The orthodontist diagnosed mild prognathism and recommended early treatment.",
            exampleNative = "Ортодонт диагностировал лёгкий prognathism и предложил раннее лечение.",
            pos = "noun", semanticGroup = "appearance_skull_jaw", fillInBlankExclusions = listOf(38312L, 38314L, 38315L, 38317L)),

        WordEntity(id = 38312, setId = 383, languagePair = "en-ru", rarity = "EPIC",
            original = "malocclusion",
            transliteration = "[ˌmæləˈkluʒən]",
            translation = "неправильный прикус",
            definition = "A condition where the upper and lower teeth do not meet correctly.",
            definitionNative = "Состояние, при котором верхние и нижние зубы смыкаются неправильно.",
            example = "The braces gradually corrected the boy's severe malocclusion over two years.",
            exampleNative = "Брекеты постепенно исправили сильный malocclusion мальчика за два года.",
            pos = "noun", semanticGroup = "appearance_skull_jaw", fillInBlankExclusions = listOf(38311L, 38314L, 38315L)),

        WordEntity(id = 38313, setId = 383, languagePair = "en-ru", rarity = "RARE",
            original = "supraorbital",
            transliteration = "[ˌsupraˈɔrbɪtəl]",
            translation = "надглазничный",
            definition = "Of the bony ridge just above the eye socket.",
            definitionNative = "Относящийся к костному валику прямо над глазницей.",
            example = "The boxer's heavy supraorbital ridge gave his face a rugged look.",
            exampleNative = "Тяжёлый supraorbital валик придавал лицу боксёра суровый вид.",
            pos = "adjective", semanticGroup = "appearance_skull_jaw"),

        WordEntity(id = 38314, setId = 383, languagePair = "en-ru", rarity = "EPIC",
            original = "cleft palate",
            transliteration = "[ˈklɛft ˈpælət]",
            translation = "расщелина нёба",
            definition = "A birth condition where the roof of the mouth has an open split.",
            definitionNative = "Врождённое состояние — открытая щель в верхней части ротовой полости.",
            example = "Charity surgeons fly abroad to repair cleft palate in poor regions.",
            exampleNative = "Благотворительные хирурги летают за рубеж исправлять cleft palate.",
            pos = "noun", semanticGroup = "appearance_skull_jaw", fillInBlankExclusions = listOf(38311L, 38312L, 38315L)),

        WordEntity(id = 38315, setId = 383, languagePair = "en-ru", rarity = "EPIC",
            original = "ptosis",
            transliteration = "[ˈtoʊsɪs]",
            translation = "птоз, опущение века",
            definition = "A medical condition where the upper eyelid droops down lower than normal.",
            definitionNative = "Медицинское состояние — верхнее веко опущено ниже обычного.",
            example = "Mild ptosis in his left eye became more visible after age fifty.",
            exampleNative = "Лёгкий ptosis левого глаза стал заметнее после пятидесяти.",
            pos = "noun", semanticGroup = "appearance_skull_jaw", fillInBlankExclusions = listOf(38311L, 38312L, 38314L)),

        // ── appearance_skin_conditions (5) ────────────────────────────────

        WordEntity(id = 38316, setId = 383, languagePair = "en-ru", rarity = "EPIC",
            original = "melanocyte",
            transliteration = "[məˈlænəˌsaɪt]",
            translation = "меланоцит",
            definition = "A skin cell that makes the dark colour of skin, hair and eyes.",
            definitionNative = "Клетка кожи, вырабатывающая тёмный пигмент кожи, волос и глаз.",
            example = "Sunlight makes each melanocyte produce more pigment to protect the skin.",
            exampleNative = "На солнце каждый melanocyte вырабатывает больше пигмента для защиты.",
            pos = "noun", semanticGroup = "appearance_skin_conditions", fillInBlankExclusions = listOf(38317L, 38318L)),

        WordEntity(id = 38317, setId = 383, languagePair = "en-ru", rarity = "EPIC",
            original = "alopecia",
            transliteration = "[ˌæləˈpiʃə]",
            translation = "алопеция, облысение",
            definition = "A medical condition where hair falls out in patches or all over.",
            definitionNative = "Медицинское состояние — выпадение волос участками или сплошь.",
            example = "After chemotherapy she developed alopecia and chose to shave her head.",
            exampleNative = "После химиотерапии у неё развилась alopecia, и она побрила голову.",
            pos = "noun", semanticGroup = "appearance_skin_conditions", fillInBlankExclusions = listOf(38316L, 38318L)),

        WordEntity(id = 38318, setId = 383, languagePair = "en-ru", rarity = "EPIC",
            original = "vitiligo",
            transliteration = "[ˌvɪtəˈlaɪɡoʊ]",
            translation = "витилиго",
            definition = "A skin condition where some areas lose colour and turn pale white.",
            definitionNative = "Кожное состояние — отдельные участки теряют пигмент и белеют.",
            example = "The model proudly showed her vitiligo on the cover of the magazine.",
            exampleNative = "Модель с гордостью показала своё vitiligo на обложке журнала.",
            pos = "noun", semanticGroup = "appearance_skin_conditions", fillInBlankExclusions = listOf(38316L, 38317L)),

        WordEntity(id = 38319, setId = 383, languagePair = "en-ru", rarity = "EPIC",
            original = "dermatoglyphic",
            transliteration = "[ˌdɜrmətoʊˈɡlɪfɪk]",
            translation = "дерматоглифический",
            definition = "Of the small ridge patterns on the skin of fingers, palms and soles.",
            definitionNative = "Относящийся к узорам тонких гребешков на пальцах, ладонях и ступнях.",
            example = "Forensic experts analysed the dermatoglyphic patterns left on the door handle.",
            exampleNative = "Эксперты изучили dermatoglyphic узоры, оставшиеся на дверной ручке.",
            pos = "adjective", semanticGroup = "appearance_skin_conditions", fillInBlankExclusions = listOf(38320L)),

        WordEntity(id = 38320, setId = 383, languagePair = "en-ru", rarity = "RARE",
            original = "lacrimal",
            transliteration = "[ˈlækrəməl]",
            translation = "слёзный",
            definition = "Of the tiny glands and ducts that produce and carry tears.",
            definitionNative = "Относящийся к мелким железам и протокам, вырабатывающим и несущим слёзы.",
            example = "A tiny lacrimal duct in her left eye was blocked from birth.",
            exampleNative = "Крошечный lacrimal проток её левого глаза был закупорен с рождения.",
            pos = "adjective", semanticGroup = "appearance_skin_conditions", fillInBlankExclusions = listOf(38319L)),

        // ── appearance_musculoskeletal (5) ────────────────────────────────

        WordEntity(id = 38321, setId = 383, languagePair = "en-ru", rarity = "EPIC",
            original = "contralateral",
            transliteration = "[ˌkɑntrəˈlætərəl]",
            translation = "контралатеральный, противоположный",
            definition = "On the opposite side of the body — right hand to left foot.",
            definitionNative = "С другой стороны тела — правая рука по отношению к левой ноге.",
            example = "The stroke caused weakness in her contralateral arm and leg.",
            exampleNative = "Инсульт вызвал слабость в её contralateral руке и ноге.",
            pos = "adjective", semanticGroup = "appearance_musculoskeletal", fillInBlankExclusions = listOf(38322L, 38323L, 38324L, 38325L)),

        WordEntity(id = 38322, setId = 383, languagePair = "en-ru", rarity = "RARE",
            original = "scapular",
            transliteration = "[ˈskæpjələr]",
            translation = "лопаточный",
            definition = "Of the flat triangular bone on the upper back, behind the shoulder.",
            definitionNative = "Относящийся к плоской треугольной кости на верхней части спины.",
            example = "The therapist worked on the tight scapular muscles after his injury.",
            exampleNative = "Терапевт работал с зажатыми scapular мышцами после его травмы.",
            pos = "adjective", semanticGroup = "appearance_musculoskeletal", fillInBlankExclusions = listOf(38321L, 38323L, 38324L, 38325L)),

        WordEntity(id = 38323, setId = 383, languagePair = "en-ru", rarity = "RARE",
            original = "deltoid",
            transliteration = "[ˈdɛltɔɪd]",
            translation = "дельтовидный (мышца)",
            definition = "The thick triangular muscle that covers the top of each shoulder.",
            definitionNative = "Толстая треугольная мышца, покрывающая верх каждого плеча.",
            example = "He felt a sharp pain in his deltoid after lifting the heavy box.",
            exampleNative = "Он почувствовал резкую боль в deltoid, подняв тяжёлую коробку.",
            pos = "adjective", semanticGroup = "appearance_musculoskeletal", fillInBlankExclusions = listOf(38321L, 38322L, 38324L, 38325L)),

        WordEntity(id = 38324, setId = 383, languagePair = "en-ru", rarity = "RARE",
            original = "clavicular",
            transliteration = "[kləˈvɪkjələr]",
            translation = "ключичный",
            definition = "Of the long thin bone that runs from the shoulder to the throat.",
            definitionNative = "Относящийся к длинной тонкой кости от плеча к горлу.",
            example = "The X-ray revealed a small clavicular fracture from the bike fall.",
            exampleNative = "Рентген показал небольшой clavicular перелом после падения с велосипеда.",
            pos = "adjective", semanticGroup = "appearance_musculoskeletal", fillInBlankExclusions = listOf(38321L, 38322L, 38323L, 38325L)),

        WordEntity(id = 38325, setId = 383, languagePair = "en-ru", rarity = "RARE",
            original = "gluteal",
            transliteration = "[ˈɡlutiəl]",
            translation = "ягодичный",
            definition = "Of the large muscles that form the rounded shape of the buttocks.",
            definitionNative = "Относящийся к крупным мышцам, формирующим округлость ягодиц.",
            example = "Squats are the best exercise to strengthen the gluteal muscles fast.",
            exampleNative = "Приседания — лучшее упражнение для быстрого укрепления gluteal мышц.",
            pos = "adjective", semanticGroup = "appearance_musculoskeletal", fillInBlankExclusions = listOf(38321L, 38322L, 38323L, 38324L)),
    )
}
