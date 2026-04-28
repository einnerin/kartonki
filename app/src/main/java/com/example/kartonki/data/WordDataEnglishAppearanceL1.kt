package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Внешность и тело (L1, COMMON+UNCOMMON).
 *
 * Set 380: «Внешность и тело» — основы.
 *          Базовые черты лица, волосы и причёска, телосложение,
 *          отметины на коже и редко-используемые части тела.
 *
 * Тематический фокус — описание ВНЕШНОСТИ человека, а не части тела
 * как таковые. Базовые части (head/face/eye/nose/hand/leg…) уже
 * закрыты в set 3 «Медицина / Части тела» — здесь повтора нет.
 * Базовые прилагательные (tall/young/old/beautiful) живут в
 * set 6 «Лингвистика / Базовые прилагательные» — повтора нет.
 *
 * Cross-topic совпадения (тема «Внешность» vs другие — допустимо):
 *   - lips, teeth, palm, ankle, toe → части тела, не пересекающиеся с set 3
 *     (set 3 даёт lip ед.ч., tooth ед.ч., finger, foot, heel — но не их «соседей»).
 *   - mole — нет дублей в базе.
 *   - freckle/wrinkle/dimple/sunburn — кожа/метки, не пересекаются.
 *   - blonde/curly/bald/beard/ponytail — волосы и причёска, FREE.
 *   - slim/plump/skinny/muscular/slender — телосложение, FREE.
 *
 * Распределение редкости: 18 COMMON + 7 UNCOMMON — два смежных уровня A1/A2.
 *
 * SemanticGroups (5 × 5):
 *   appearance_face_features  — cheek, chin, forehead, eyebrow, eyelash
 *   appearance_hair           — blonde, curly, bald, beard, ponytail
 *   appearance_skin_marks     — freckle, wrinkle, mole, dimple, sunburn
 *   appearance_build          — slim, plump, skinny, muscular, slender
 *   appearance_body_parts     — lips, teeth, palm, ankle, toe
 *
 * Word IDs: setId × 100 + position (38001..38025).
 *
 * isFillInBlankSafe = true; fillInBlankExclusions пустые
 * (заполнятся через FILL_IN_BLANK pipeline).
 */
object WordDataEnglishAppearanceL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 380,
            languagePair = "en-ru",
            orderIndex = 380,
            name = "Внешность и тело",
            description = "Части тела и базовое описание человека",
            topic = "Внешность и тело",
            level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 380 — Внешность и тело: основы (L1, COMMON+UNCOMMON)         ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── appearance_face_features (5) ──────────────────────────────────

        WordEntity(id = 38001, setId = 380, languagePair = "en-ru", rarity = "COMMON",
            original = "cheek", transliteration = "[ʧik]", translation = "щека",
            definition = "The soft round part of the face below each eye.",
            definitionNative = "Мягкое округлое место на лице — под каждым глазом.",
            example = "Grandma kissed me gently on my left cheek before bed.",
            exampleNative = "Бабушка нежно поцеловала меня в левую cheek перед сном.",
            pos = "noun", semanticGroup = "appearance_face_features",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38002L, 38003L, 38004L, 38005L, 38014L)),

        WordEntity(id = 38002, setId = 380, languagePair = "en-ru", rarity = "COMMON",
            original = "chin", transliteration = "[ʧɪn]", translation = "подбородок",
            definition = "The small part of the face just under the mouth.",
            definitionNative = "Небольшая часть лица — прямо под ртом.",
            example = "He scratched his chin while thinking about the answer.",
            exampleNative = "Он почесал свой chin, обдумывая ответ.",
            pos = "noun", semanticGroup = "appearance_face_features",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38001L, 38003L, 38004L, 38005L, 38009L, 38013L, 38015L, 38021L, 38023L, 38024L, 38025L)),

        WordEntity(id = 38003, setId = 380, languagePair = "en-ru", rarity = "COMMON",
            original = "forehead", transliteration = "[ˈfɔrˌhɛd]", translation = "лоб",
            definition = "The flat part of the face above the eyes and below the hair.",
            definitionNative = "Ровная часть лица — над глазами и ниже линии волос.",
            example = "Mum put her hand on my forehead to check for a fever.",
            exampleNative = "Мама приложила руку к моему forehead, чтобы проверить температуру.",
            pos = "noun", semanticGroup = "appearance_face_features",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38001L, 38002L, 38004L, 38005L)),

        WordEntity(id = 38004, setId = 380, languagePair = "en-ru", rarity = "COMMON",
            original = "eyebrow", transliteration = "[ˈaɪˌbraʊ]", translation = "бровь",
            definition = "A line of small hairs above each eye, on the lower forehead.",
            definitionNative = "Полоска коротких волосков над каждым глазом.",
            example = "She raised one eyebrow when I told her the strange story.",
            exampleNative = "Она подняла одну eyebrow, когда я рассказал ей странную историю.",
            pos = "noun", semanticGroup = "appearance_face_features",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38001L, 38002L, 38003L, 38005L)),

        WordEntity(id = 38005, setId = 380, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "eyelash", transliteration = "[ˈaɪˌlæʃ]", translation = "ресница",
            definition = "One of the short hairs that grow along the edge of the eye.",
            definitionNative = "Один из коротких волосков по краю века у глаза.",
            example = "A tiny eyelash fell into her cup of warm tea.",
            exampleNative = "Крошечная eyelash упала в её чашку с тёплым чаем.",
            pos = "noun", semanticGroup = "appearance_face_features",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38001L, 38002L, 38003L, 38004L)),

        // ── appearance_hair (5) ───────────────────────────────────────────

        WordEntity(id = 38006, setId = 380, languagePair = "en-ru", rarity = "COMMON",
            original = "blonde", transliteration = "[blɑnd]", translation = "светловолосый",
            definition = "Having pale yellow or golden hair on the head.",
            definitionNative = "Имеющий светло-жёлтые или золотистые волосы на голове.",
            example = "Her little daughter is blonde, just like her father was.",
            exampleNative = "Её маленькая дочь blonde — совсем как её отец в детстве.",
            pos = "adjective", semanticGroup = "appearance_hair",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38007L, 38008L, 38016L, 38017L, 38018L, 38019L, 38020L)),

        WordEntity(id = 38007, setId = 380, languagePair = "en-ru", rarity = "COMMON",
            original = "curly", transliteration = "[ˈkərli]", translation = "кудрявый",
            definition = "Forming round shapes — said about hair that twists into rings.",
            definitionNative = "Завивающийся в круглые витки — говорят о волосах в колечках.",
            example = "My nephew has curly red hair and bright green eyes.",
            exampleNative = "У моего племянника curly рыжие волосы и ярко-зелёные глаза.",
            pos = "adjective", semanticGroup = "appearance_hair",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38006L, 38008L)),

        WordEntity(id = 38008, setId = 380, languagePair = "en-ru", rarity = "COMMON",
            original = "bald", transliteration = "[bɔld]", translation = "лысый",
            definition = "Having no hair, or almost no hair, on top of the head.",
            definitionNative = "Без волос на голове — или с очень небольшим их остатком.",
            example = "My uncle went bald in his thirties but he never minded.",
            exampleNative = "Мой дядя стал bald в тридцать с небольшим, но не переживал.",
            pos = "adjective", semanticGroup = "appearance_hair",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38006L, 38007L)),

        WordEntity(id = 38009, setId = 380, languagePair = "en-ru", rarity = "COMMON",
            original = "beard", transliteration = "[bɪrd]", translation = "борода",
            definition = "The hair that grows on a man's chin and lower face.",
            definitionNative = "Волосы у мужчины на нижней части лица — под ртом и на щеках.",
            example = "Santa Claus is famous for his big white fluffy beard.",
            exampleNative = "Санта-Клаус известен своей большой белой пушистой beard.",
            pos = "noun", semanticGroup = "appearance_hair",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38010L)),

        WordEntity(id = 38010, setId = 380, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "ponytail", transliteration = "[ˈpoʊniˌteɪl]", translation = "хвост (причёска)",
            definition = "A bunch of hair tied at the back of the head with a band.",
            definitionNative = "Пучок волос, завязанный сзади резинкой или лентой.",
            example = "She tied her long hair into a quick ponytail before running.",
            exampleNative = "Она быстро собрала длинные волосы в ponytail перед пробежкой.",
            pos = "noun", semanticGroup = "appearance_hair",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38009L)),

        // ── appearance_skin_marks (5) ─────────────────────────────────────

        WordEntity(id = 38011, setId = 380, languagePair = "en-ru", rarity = "COMMON",
            original = "freckle", transliteration = "[ˈfrɛkəl]", translation = "веснушка",
            definition = "A small light brown spot on the skin, often after sunlight.",
            definitionNative = "Маленькая светло-коричневая точка на коже — часто от солнца.",
            example = "A tiny freckle appeared on her nose during the summer holiday.",
            exampleNative = "Крошечная freckle появилась на её носу во время летних каникул.",
            pos = "noun", semanticGroup = "appearance_skin_marks",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38012L, 38013L, 38014L, 38015L)),

        WordEntity(id = 38012, setId = 380, languagePair = "en-ru", rarity = "COMMON",
            original = "wrinkle", transliteration = "[ˈrɪŋkəl]", translation = "морщина",
            definition = "A small line on the skin that appears as a person grows older.",
            definitionNative = "Маленькая линия на коже — появляется с возрастом.",
            example = "Grandpa has a deep wrinkle right between his thick eyebrows.",
            exampleNative = "У дедушки глубокая wrinkle прямо между густыми бровями.",
            pos = "noun", semanticGroup = "appearance_skin_marks",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38011L, 38013L, 38014L, 38015L)),

        WordEntity(id = 38013, setId = 380, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "mole", transliteration = "[moʊl]", translation = "родинка",
            definition = "A small dark round spot on the skin from birth or later in life.",
            definitionNative = "Маленькое тёмное округлое пятнышко на коже — с рождения или позже.",
            example = "She has a tiny mole just below her left ear.",
            exampleNative = "У неё крохотная mole прямо под левым ухом.",
            pos = "noun", semanticGroup = "appearance_skin_marks",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38011L, 38012L, 38014L, 38015L)),

        WordEntity(id = 38014, setId = 380, languagePair = "en-ru", rarity = "COMMON",
            original = "dimple", transliteration = "[ˈdɪmpəl]", translation = "ямочка",
            definition = "A small soft hollow on a cheek that appears when someone smiles.",
            definitionNative = "Маленькая мягкая впадинка на щеке — появляется при улыбке.",
            example = "He has a cute dimple on the right side of his face.",
            exampleNative = "У него милая dimple с правой стороны лица.",
            pos = "noun", semanticGroup = "appearance_skin_marks",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38011L, 38012L, 38013L, 38015L)),

        WordEntity(id = 38015, setId = 380, languagePair = "en-ru", rarity = "COMMON",
            original = "sunburn", transliteration = "[ˈsənˌbərn]", translation = "солнечный ожог",
            definition = "Red sore skin you get after staying too long in strong sunlight.",
            definitionNative = "Красная болезненная кожа после долгого пребывания на ярком солнце.",
            example = "I got a painful sunburn on my back at the beach yesterday.",
            exampleNative = "Я получил болезненный sunburn на спине на пляже вчера.",
            pos = "noun", semanticGroup = "appearance_skin_marks",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38011L, 38012L, 38013L, 38014L)),

        // ── appearance_build (5) ──────────────────────────────────────────

        WordEntity(id = 38016, setId = 380, languagePair = "en-ru", rarity = "COMMON",
            original = "slim", transliteration = "[slɪm]", translation = "стройный",
            definition = "Having a thin and pleasant body shape — not heavy at all.",
            definitionNative = "С тонкой и приятной фигурой — совсем не тяжёлой.",
            example = "My older sister stays slim because she walks every day.",
            exampleNative = "Моя старшая сестра остаётся slim, потому что каждый день ходит пешком.",
            pos = "adjective", semanticGroup = "appearance_build",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38017L, 38018L, 38019L, 38020L)),

        WordEntity(id = 38017, setId = 380, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "plump", transliteration = "[pləmp]", translation = "пухлый",
            definition = "Pleasantly full and round in the body — soft and a bit heavy.",
            definitionNative = "Приятно округлый телом — мягкий и немного полный.",
            example = "The baby has plump pink hands and very soft cheeks.",
            exampleNative = "У малыша plump розовые ручки и очень мягкие щёчки.",
            pos = "adjective", semanticGroup = "appearance_build",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38016L, 38018L, 38019L, 38020L)),

        WordEntity(id = 38018, setId = 380, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "skinny", transliteration = "[ˈskɪni]", translation = "очень худой",
            definition = "Very thin in the body — almost too thin, with little flesh.",
            definitionNative = "Очень тощий — почти слишком, с очень малым количеством плоти.",
            example = "The skinny boy ate two big plates of pasta in minutes.",
            exampleNative = "Skinny мальчик за минуты съел две больших тарелки пасты.",
            pos = "adjective", semanticGroup = "appearance_build",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38006L, 38008L, 38016L, 38017L, 38019L, 38020L)),

        WordEntity(id = 38019, setId = 380, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "muscular", transliteration = "[ˈməskjələr]", translation = "мускулистый",
            definition = "Having a strong body with clear, well-built arms and legs.",
            definitionNative = "Сильный телом — с заметными, хорошо развитыми руками и ногами.",
            example = "The muscular man at the gym lifted the heavy bar with ease.",
            exampleNative = "Muscular мужчина в зале легко поднял тяжёлую штангу.",
            pos = "adjective", semanticGroup = "appearance_build",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38006L, 38008L, 38016L, 38017L, 38018L, 38020L)),

        WordEntity(id = 38020, setId = 380, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "slender", transliteration = "[ˈslɛndər]", translation = "изящный (худощавый)",
            definition = "Pleasingly thin and graceful — usually said in a kind way.",
            definitionNative = "Приятно тонкий и грациозный — обычно говорят с одобрением.",
            example = "The dancer had long slender arms and very strong legs.",
            exampleNative = "У танцовщицы были длинные slender руки и очень сильные ноги.",
            pos = "adjective", semanticGroup = "appearance_build",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38016L, 38017L, 38018L, 38019L)),

        // ── appearance_body_parts (5) ─────────────────────────────────────

        WordEntity(id = 38021, setId = 380, languagePair = "en-ru", rarity = "COMMON",
            original = "lips", transliteration = "[lɪps]", translation = "губы",
            definition = "The two soft pink edges around the opening of the mouth.",
            definitionNative = "Два мягких розовых края вокруг отверстия рта.",
            example = "Her lips turned blue after swimming in the cold lake.",
            exampleNative = "Её lips посинели после купания в холодном озере.",
            pos = "noun", semanticGroup = "appearance_body_parts",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38001L, 38022L, 38023L, 38024L, 38025L)),

        WordEntity(id = 38022, setId = 380, languagePair = "en-ru", rarity = "COMMON",
            original = "teeth", transliteration = "[tiθ]", translation = "зубы",
            definition = "The hard white parts inside the mouth used to bite and chew food.",
            definitionNative = "Твёрдые белые части во рту — ими откусывают и пережёвывают еду.",
            example = "The little boy brushes his teeth every morning before school.",
            exampleNative = "Маленький мальчик чистит teeth каждое утро перед школой.",
            pos = "noun", semanticGroup = "appearance_body_parts",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38010L, 38021L, 38023L, 38024L, 38025L)),

        WordEntity(id = 38023, setId = 380, languagePair = "en-ru", rarity = "COMMON",
            original = "palm", transliteration = "[pɑm]", translation = "ладонь",
            definition = "The flat inside part of the hand between the wrist and fingers.",
            definitionNative = "Ровная внутренняя часть руки — между запястьем и пальцами.",
            example = "She held a tiny seashell in the palm of her hand.",
            exampleNative = "Она держала крошечную ракушку в palm своей руки.",
            pos = "noun", semanticGroup = "appearance_body_parts",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38021L, 38022L, 38024L, 38025L)),

        WordEntity(id = 38024, setId = 380, languagePair = "en-ru", rarity = "COMMON",
            original = "ankle", transliteration = "[ˈæŋkəl]", translation = "лодыжка",
            definition = "The thin part of the leg that joins the foot below.",
            definitionNative = "Тонкая часть ноги — соединяет ступню с голенью.",
            example = "He twisted his ankle while running down the wet stone steps.",
            exampleNative = "Он подвернул ankle, сбегая по мокрым каменным ступенькам.",
            pos = "noun", semanticGroup = "appearance_body_parts",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38021L, 38022L, 38023L, 38025L)),

        WordEntity(id = 38025, setId = 380, languagePair = "en-ru", rarity = "COMMON",
            original = "toe", transliteration = "[toʊ]", translation = "палец ноги",
            definition = "One of the five small parts at the front end of each foot.",
            definitionNative = "Один из пяти маленьких отростков на передней части ступни.",
            example = "I dropped a heavy book and hurt my big toe badly.",
            exampleNative = "Я уронил тяжёлую книгу и сильно ушиб большой toe.",
            pos = "noun", semanticGroup = "appearance_body_parts",
            isFillInBlankSafe = true, fillInBlankExclusions = listOf(38021L, 38022L, 38023L, 38024L)),
    )
}
