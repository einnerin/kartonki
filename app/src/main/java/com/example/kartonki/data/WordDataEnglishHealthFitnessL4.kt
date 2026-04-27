package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — «Здоровье и фитнес» (level 4, профессиональный).
 *
 * Set 354: «Здоровье и фитнес» — углублённая лексика спортивной медицины,
 * нутрициологии, ментального здоровья, биомеханики и продвинутых
 * тренировочных методик (L4 / EPIC+LEGENDARY).
 *
 * Распределение редкости: 13 EPIC + 12 LEGENDARY — два смежных уровня шкалы.
 *
 * Дополняет уже существующие сеты темы «Здоровье и фитнес»:
 *   - Set 345 (L1, COMMON+UNCOMMON) — основы: run, walk, gym, sleep, vitamin, diet…
 *   - Set 346 (L2, UNCOMMON+RARE)   — упражнения и снаряды: squat, treadmill, protein…
 *   - Set 347 (L3, RARE+EPIC)       — методики и наука: hypertrophy, periodization,
 *                                     proprioception, kinesiology, biomechanics…
 *
 * Слова setId=354 не пересекаются ни с одним из перечисленных сетов
 * (проверено grep по всей директории data/) и ни с Medicine L4/L5 (322/323).
 *
 * SemanticGroups (5 × 5):
 *   health_pro_sportsmed   — tendinitis, meniscus, concussion, whiplash, rotator-cuff
 *   health_pro_nutrition   — micronutrient, ketogenic, glycemic, polyphenol, antioxidant
 *   health_pro_mental      — burnout, wellbeing, ruminate, dissociation, neuroplasticity
 *   health_pro_biomech     — kinematics, pronation, supination, fascia, cartilage
 *   health_pro_training    — taper, supercompensation, eccentric, isokinetic, mesocycle
 *
 * Word IDs: 35401..35425 (setId × 100 + position).
 *
 * isFillInBlankSafe=false на всех 25 словах: в L4 преобладают узкоспециальные
 * термины с пересекающимися полями (tendinitis/meniscus/cartilage внутри
 * sportsmed; eccentric/isokinetic/taper внутри training), и контекст example
 * часто допускает соседнюю терминологию. Pipeline FILL_IN_BLANK exclusions
 * заполнит точечно после фиксации набора (Phase A → Phase B).
 *
 * fillInBlankExclusions проставит pipeline (см. fill-in-blank-pipeline.md).
 * Регистрация в WordRegistry / bump WordDataVersion — централизованно.
 */
object WordDataEnglishHealthFitnessL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 354, languagePair = "en-ru", orderIndex = 354,
            name = "Здоровье и фитнес",
            description = "Углублённый: спортивная медицина, нутрициология, ментальное здоровье, биомеханика",
            topic = "Здоровье и фитнес", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── health_pro_sportsmed (5) ──────────────────────────────────────────

        WordEntity(id = 35401, setId = 354, languagePair = "en-ru", rarity = "EPIC",
            original = "tendinitis", transliteration = "[ˌtɛndəˈnaɪtɪs]", translation = "тендинит (воспаление сухожилия)",
            definition = "Sore swelling of a cord that joins muscle to bone, from overuse.",
            definitionNative = "Болезненное воспаление шнура, соединяющего мышцу с костью, от перегрузки.",
            example = "Chronic tendinitis in the elbow forced him to skip the season.",
            exampleNative = "Хронический tendinitis в локте заставил его пропустить сезон.",
            pos = "noun", semanticGroup = "health_pro_sportsmed", fillInBlankExclusions = listOf(35402L, 35403L, 35404L, 35405L)),

        WordEntity(id = 35402, setId = 354, languagePair = "en-ru", rarity = "EPIC",
            original = "meniscus", transliteration = "[məˈnɪskəs]", translation = "мениск (хрящ в колене)",
            definition = "A C-shaped pad of soft tissue that cushions the bones inside the knee.",
            definitionNative = "С-образная мягкая прокладка, смягчающая удар между костями в колене.",
            example = "A torn meniscus often needs a small surgery to trim the flap.",
            exampleNative = "Порванный meniscus часто требует небольшой операции для удаления лоскута.",
            pos = "noun", semanticGroup = "health_pro_sportsmed", fillInBlankExclusions = listOf(35401L, 35403L, 35404L, 35405L, 35420L)),

        WordEntity(id = 35403, setId = 354, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "concussion", transliteration = "[kənˈkʌʃən]", translation = "сотрясение мозга",
            definition = "A brain injury from a hard knock to the head that scrambles thinking.",
            definitionNative = "Травма мозга от сильного удара по голове, сбивающая ясность мышления.",
            example = "The boxer left the ring with a clear concussion after the final round.",
            exampleNative = "Боксёр покинул ринг с явным concussion после последнего раунда.",
            pos = "noun", semanticGroup = "health_pro_sportsmed", fillInBlankExclusions = listOf(35401L, 35402L, 35404L, 35405L)),

        WordEntity(id = 35404, setId = 354, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "whiplash", transliteration = "[ˈwɪpˌlæʃ]", translation = "хлыстовая травма (шеи)",
            definition = "A neck injury caused by the head snapping forward and back, often in a crash.",
            definitionNative = "Травма шеи от резкого рывка головы вперёд и назад — часто при ДТП.",
            example = "Mild whiplash kept the driver in a soft collar for two weeks.",
            exampleNative = "Лёгкий whiplash удержал водителя в мягком воротнике две недели.",
            pos = "noun", semanticGroup = "health_pro_sportsmed", fillInBlankExclusions = listOf(35401L, 35402L, 35403L, 35405L)),

        WordEntity(id = 35405, setId = 354, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "rotator-cuff", transliteration = "[ˈroʊteɪtər kʌf]", translation = "вращательная манжета (плеча)",
            definition = "A group of small shoulder structures that hold the upper arm in its socket.",
            definitionNative = "Группа мелких структур плеча, удерживающих головку плечевой кости в суставной впадине.",
            example = "Pitchers often tear the rotator-cuff after years of hard throws.",
            exampleNative = "Питчеры часто рвут rotator-cuff после многих лет силовых бросков.",
            pos = "noun", semanticGroup = "health_pro_sportsmed", fillInBlankExclusions = listOf(35401L, 35402L, 35403L, 35404L, 35419L, 35420L)),

        // ── health_pro_nutrition (5) ──────────────────────────────────────────

        WordEntity(id = 35406, setId = 354, languagePair = "en-ru", rarity = "EPIC",
            original = "micronutrient", transliteration = "[ˌmaɪkroʊˈnuːtriənt]", translation = "микронутриент (витамины и минералы)",
            definition = "A tiny food substance like a vitamin or mineral, needed in small amounts.",
            definitionNative = "Крошечное вещество в пище — витамин или минерал, нужный в малых дозах.",
            example = "Iron is the micronutrient most often missing from a vegan plate.",
            exampleNative = "Железо — micronutrient, которого чаще всего не хватает в веганском рационе.",
            pos = "noun", semanticGroup = "health_pro_nutrition", fillInBlankExclusions = listOf(35409L, 35410L)),

        WordEntity(id = 35407, setId = 354, languagePair = "en-ru", rarity = "EPIC",
            original = "ketogenic", transliteration = "[ˌkiːtoʊˈʤɛnɪk]", translation = "кетогенный (диета)",
            definition = "A way of eating that is very low in sugar and starch, high in fat.",
            definitionNative = "Способ питания с очень низким содержанием сахара и крахмала и большой долей жира.",
            example = "She tried a strict ketogenic plan to manage her seizures.",
            exampleNative = "Она попробовала строгий ketogenic план, чтобы справиться с приступами.",
            pos = "adjective", semanticGroup = "health_pro_nutrition", fillInBlankExclusions = listOf(35408L)),

        WordEntity(id = 35408, setId = 354, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "glycemic", transliteration = "[ɡlaɪˈsiːmɪk]", translation = "гликемический (индекс)",
            definition = "Tied to how quickly a food raises the level of sugar in your blood.",
            definitionNative = "Связанный с тем, как быстро еда поднимает уровень сахара в крови.",
            example = "White bread has a high glycemic value compared to oats.",
            exampleNative = "У белого хлеба высокий glycemic показатель по сравнению с овсянкой.",
            pos = "adjective", semanticGroup = "health_pro_nutrition", fillInBlankExclusions = listOf(35407L)),

        WordEntity(id = 35409, setId = 354, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "polyphenol", transliteration = "[ˌpɒliˈfiːnɒl]", translation = "полифенол (растительное соединение)",
            definition = "A plant chemical found in tea, berries and olive oil that protects cells.",
            definitionNative = "Растительное вещество в чае, ягодах и оливковом масле, защищающее клетки.",
            example = "Dark chocolate is famous for its high polyphenol content.",
            exampleNative = "Тёмный шоколад славится высоким содержанием polyphenol.",
            pos = "noun", semanticGroup = "health_pro_nutrition", fillInBlankExclusions = listOf(35406L, 35410L)),

        WordEntity(id = 35410, setId = 354, languagePair = "en-ru", rarity = "EPIC",
            original = "antioxidant", transliteration = "[ˌæntiˈɒksɪdənt]", translation = "антиоксидант",
            definition = "A food substance that fights tiny harmful particles inside the body.",
            definitionNative = "Вещество в еде, борющееся с крошечными вредными частицами в организме.",
            example = "Blueberries are packed with antioxidant compounds for the brain.",
            exampleNative = "Голубика богата antioxidant соединениями, полезными для мозга.",
            pos = "noun", semanticGroup = "health_pro_nutrition", fillInBlankExclusions = listOf(35406L, 35409L)),

        // ── health_pro_mental (5) ─────────────────────────────────────────────

        WordEntity(id = 35411, setId = 354, languagePair = "en-ru", rarity = "EPIC",
            original = "burnout", transliteration = "[ˈbɜːrnaʊt]", translation = "выгорание (синдром)",
            definition = "A worn-out state from long stress at work, with no joy and low energy.",
            definitionNative = "Истощённое состояние от долгого стресса на работе — без радости и сил.",
            example = "Three years of night shifts pushed the nurse into total burnout.",
            exampleNative = "Три года ночных смен довели медсестру до полного burnout.",
            pos = "noun", semanticGroup = "health_pro_mental", fillInBlankExclusions = listOf(35412L, 35414L, 35415L)),

        WordEntity(id = 35412, setId = 354, languagePair = "en-ru", rarity = "EPIC",
            original = "wellbeing", transliteration = "[ˌwɛlˈbiːɪŋ]", translation = "благополучие (общее самочувствие)",
            definition = "A steady state of feeling well in body, mind and daily life.",
            definitionNative = "Устойчивое состояние, когда хорошо в теле, голове и в обычной жизни.",
            example = "Daily walks made a real difference to her wellbeing.",
            exampleNative = "Ежедневные прогулки заметно улучшили её wellbeing.",
            pos = "noun", semanticGroup = "health_pro_mental", fillInBlankExclusions = listOf(35411L, 35414L, 35415L)),

        WordEntity(id = 35413, setId = 354, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "ruminate", transliteration = "[ˈruːmɪneɪt]", translation = "зацикливаться (на мыслях)",
            definition = "To turn the same dark thought over and over without reaching peace.",
            definitionNative = "Прокручивать одну и ту же тёмную мысль снова и снова, не находя покоя.",
            example = "He tends to ruminate on past mistakes during long sleepless nights.",
            exampleNative = "Он склонен ruminate о прошлых ошибках в долгие бессонные ночи.",
            pos = "verb", semanticGroup = "health_pro_mental"),

        WordEntity(id = 35414, setId = 354, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "dissociation", transliteration = "[dɪsˌsoʊsiˈeɪʃən]", translation = "диссоциация (психол.)",
            definition = "A feeling of being detached from your body, thoughts or surroundings.",
            definitionNative = "Ощущение оторванности от собственного тела, мыслей или окружающей обстановки.",
            example = "Mild dissociation often follows a sudden traumatic event.",
            exampleNative = "Лёгкая dissociation часто следует за внезапным травмирующим событием.",
            pos = "noun", semanticGroup = "health_pro_mental", fillInBlankExclusions = listOf(35403L, 35404L, 35411L, 35412L, 35415L)),

        WordEntity(id = 35415, setId = 354, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "executive function", transliteration = "[ɪɡˈzekjətɪv ˈfʌŋkʃən]", translation = "исполнительная функция мозга",
            definition = "The mental skill of planning, switching tasks and holding focus on a goal.",
            definitionNative = "Умственный навык планировать, переключаться между задачами и удерживать фокус на цели.",
            example = "Sleep loss strongly weakens his executive function the next morning.",
            exampleNative = "Недостаток сна резко ослабляет его executive function на следующее утро.",
            pos = "noun", semanticGroup = "health_pro_mental", fillInBlankExclusions = listOf(35411L, 35412L, 35414L)),

        // ── health_pro_biomech (5) ────────────────────────────────────────────

        WordEntity(id = 35416, setId = 354, languagePair = "en-ru", rarity = "EPIC",
            original = "kinematics", transliteration = "[ˌkɪnəˈmætɪks]", translation = "кинематика (движения)",
            definition = "The study of how a body moves in space without looking at the forces.",
            definitionNative = "Изучение того, как тело движется в пространстве, без учёта сил.",
            example = "High-speed cameras revealed the kinematics of his perfect serve.",
            exampleNative = "Скоростные камеры раскрыли kinematics его идеальной подачи.",
            pos = "noun", semanticGroup = "health_pro_biomech", fillInBlankExclusions = listOf(35417L, 35418L, 35419L, 35420L)),

        WordEntity(id = 35417, setId = 354, languagePair = "en-ru", rarity = "EPIC",
            original = "pronation", transliteration = "[proʊˈneɪʃən]", translation = "пронация (поворот стопы внутрь)",
            definition = "The natural inward roll of the foot when it touches the ground while running.",
            definitionNative = "Естественный заворот стопы внутрь при касании земли во время бега.",
            example = "Mild pronation is normal — heavy roll-in is what causes pain.",
            exampleNative = "Лёгкая pronation нормальна — боль вызывает только сильный завал внутрь.",
            pos = "noun", semanticGroup = "health_pro_biomech", fillInBlankExclusions = listOf(35416L, 35418L, 35419L, 35420L)),

        WordEntity(id = 35418, setId = 354, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "supination", transliteration = "[ˌsuːpɪˈneɪʃən]", translation = "супинация (поворот стопы наружу)",
            definition = "The outward roll of the foot, with weight resting on the outside edge.",
            definitionNative = "Заворот стопы наружу — вес тела ложится на внешний край ступни.",
            example = "Excess supination wears out the outer edge of running shoes.",
            exampleNative = "Избыточная supination изнашивает внешний край беговых кроссовок.",
            pos = "noun", semanticGroup = "health_pro_biomech", fillInBlankExclusions = listOf(35416L, 35417L, 35419L, 35420L)),

        WordEntity(id = 35419, setId = 354, languagePair = "en-ru", rarity = "EPIC",
            original = "fascia", transliteration = "[ˈfæʃə]", translation = "фасция (соединительная оболочка)",
            definition = "A thin sheet of body tissue that wraps around every muscle and organ.",
            definitionNative = "Тонкая оболочка из соединительной ткани, обхватывающая каждую мышцу и орган.",
            example = "Tight fascia in the back can mimic a slipped disc on the scan.",
            exampleNative = "Зажатая fascia в спине может имитировать грыжу диска на снимке.",
            pos = "noun", semanticGroup = "health_pro_biomech", fillInBlankExclusions = listOf(35416L, 35417L, 35418L, 35420L)),

        WordEntity(id = 35420, setId = 354, languagePair = "en-ru", rarity = "EPIC",
            original = "cartilage", transliteration = "[ˈkɑːrtɪlɪʤ]", translation = "хрящ (ткань сустава)",
            definition = "A firm but flexible body tissue at the ends of bones inside the joints.",
            definitionNative = "Плотная, но гибкая ткань на концах костей внутри суставов.",
            example = "Years of running slowly wore down the cartilage in his knees.",
            exampleNative = "Годы бега постепенно стёрли cartilage в его коленях.",
            pos = "noun", semanticGroup = "health_pro_biomech", fillInBlankExclusions = listOf(35402L, 35416L, 35417L, 35418L, 35419L)),

        // ── health_pro_training (5) ───────────────────────────────────────────

        WordEntity(id = 35421, setId = 354, languagePair = "en-ru", rarity = "EPIC",
            original = "taper", transliteration = "[ˈteɪpər]", translation = "снижение нагрузки (перед стартом)",
            definition = "A planned drop in training load shortly before a big race or contest.",
            definitionNative = "Запланированное снижение нагрузки незадолго до крупного старта или соревнования.",
            example = "A two-week taper sharpens the legs before a marathon.",
            exampleNative = "Двухнедельный taper свежит ноги перед марафоном.",
            pos = "noun", semanticGroup = "health_pro_training", fillInBlankExclusions = listOf(35422L, 35425L)),

        WordEntity(id = 35422, setId = 354, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "supercompensation", transliteration = "[ˌsuːpərˌkɒmpɛnˈseɪʃən]", translation = "суперкомпенсация",
            definition = "A short window after rest when the body is stronger than before training.",
            definitionNative = "Короткое окно после отдыха, когда тело становится крепче, чем до нагрузки.",
            example = "Smart coaches plan the next session right inside the supercompensation window.",
            exampleNative = "Умные тренеры ставят следующее занятие прямо в окно supercompensation.",
            pos = "noun", semanticGroup = "health_pro_training", fillInBlankExclusions = listOf(35421L, 35425L)),

        WordEntity(id = 35423, setId = 354, languagePair = "en-ru", rarity = "EPIC",
            original = "eccentric", transliteration = "[ɪkˈsɛntrɪk]", translation = "эксцентрический (фаза упражнения)",
            definition = "Tied to the slow lowering phase of a lift, when a muscle stretches under load.",
            definitionNative = "Связанный с медленной фазой опускания, когда мышца растягивается под нагрузкой.",
            example = "A slow eccentric tempo on squats triggers more muscle damage.",
            exampleNative = "Медленный eccentric темп в приседе даёт больше микротравм мышцам.",
            pos = "adjective", semanticGroup = "health_pro_training", fillInBlankExclusions = listOf(35424L)),

        WordEntity(id = 35424, setId = 354, languagePair = "en-ru", rarity = "EPIC",
            original = "isokinetic", transliteration = "[ˌaɪsoʊkɪˈnɛtɪk]", translation = "изокинетический (с постоянной скоростью)",
            definition = "Done on a machine that holds the speed steady no matter how hard you push.",
            definitionNative = "Выполняемый на тренажёре, который держит постоянную скорость при любом усилии.",
            example = "Rehab clinics use isokinetic devices to test knee strength after surgery.",
            exampleNative = "В реабилитации используют isokinetic тренажёры для проверки силы колена.",
            pos = "adjective", semanticGroup = "health_pro_training", fillInBlankExclusions = listOf(35423L)),

        WordEntity(id = 35425, setId = 354, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "mesocycle", transliteration = "[ˈmɛzoʊˌsaɪkəl]", translation = "мезоцикл (блок 3-6 недель)",
            definition = "A training block of three to six weeks aimed at one specific goal.",
            definitionNative = "Тренировочный блок в три-шесть недель, направленный на одну конкретную цель.",
            example = "The strength mesocycle ends with a hard testing session next Friday.",
            exampleNative = "Силовой mesocycle завершается тяжёлым тестовым занятием в пятницу.",
            pos = "noun", semanticGroup = "health_pro_training", fillInBlankExclusions = listOf(35421L, 35422L)),
    )
}
