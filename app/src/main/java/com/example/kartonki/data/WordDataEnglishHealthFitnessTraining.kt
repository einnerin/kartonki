package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — «Здоровье и фитнес» (level 2, дополнительный сет).
 *
 * Set 453: «Здоровье и фитнес» — виды тренировок и фитнес-форматы (L2 / UNCOMMON+RARE).
 *
 * Расширяет тему «Здоровье и фитнес» (уже 5 сетов: 345 L1, 346 L2, 347 L3, 354 L4, 355 L5).
 * Этот шестой сет фокусируется на ИМЕНОВАННЫХ форматах тренировок и стилях:
 *   - HIIT-протоколы (Tabata, EMOM, AMRAP, fartlek, metcon)
 *   - Боевые единоборства как фитнес (kickboxing, MMA, wrestling, capoeira, sparring)
 *   - Системные дисциплины (CrossFit, powerlifting, bodybuilding, tai chi, qigong)
 *   - Групповые занятия (bootcamp, aerobics, spinning, Zumba, barre)
 *   - Базовые движения с собственным весом (pull-up, push-up, chin-up, muscle-up, box jump)
 *
 * Распределение редкости: 11 UNCOMMON + 14 RARE — два смежных уровня шкалы.
 *
 * Все 25 слов проверены на дубли с уже существующими сетами темы (345/346/347/354/355).
 * Cross-topic дубли: НЕТ — слова не пересекаются ни с одним сетом базы (проверено
 * grep -rFlw по всей директории data/).
 *
 * SemanticGroups (5 × 5):
 *   fitness_training_intervals    — Tabata, EMOM, AMRAP, fartlek, metcon
 *   fitness_training_combat       — kickboxing, MMA, wrestling, capoeira, sparring
 *   fitness_training_disciplines  — CrossFit, powerlifting, bodybuilding, tai chi, qigong
 *   fitness_training_classes      — bootcamp, aerobics, spinning, Zumba, barre
 *   fitness_training_bodyweight   — pull-up, push-up, chin-up, muscle-up, box jump
 *
 * Word IDs: 45301..45325 (setId × 100 + position).
 *
 * fillInBlankExclusions заполнит pipeline (см. fill-in-blank-pipeline.md).
 * Регистрация в WordRegistry / bump WordDataVersion — централизованно.
 */
object WordDataEnglishHealthFitnessTraining {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 453, languagePair = "en-ru", orderIndex = 453,
            name = "Здоровье и фитнес",
            description = "Виды тренировок и фитнес-форматы: HIIT-протоколы, единоборства, групповые занятия",
            topic = "Здоровье и фитнес", level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── fitness_training_intervals (5) ────────────────────────────────────

        WordEntity(id = 45301, setId = 453, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "Tabata", transliteration = "[təˈbɑːtə]", translation = "табата (протокол интервалов)",
            definition = "A short workout pattern of twenty seconds hard, ten seconds rest, eight rounds.",
            definitionNative = "Короткий формат: двадцать секунд на пределе, десять секунд паузы, восемь циклов.",
            example = "Four minutes of Tabata leaves my legs completely on fire.",
            exampleNative = "Четыре минуты Tabata оставляют мои ноги полностью в огне.",
            pos = "noun", semanticGroup = "fitness_training_intervals", fillInBlankExclusions = listOf(45302L, 45303L, 45304L, 45305L)),

        WordEntity(id = 45302, setId = 453, languagePair = "en-ru", rarity = "RARE",
            original = "EMOM", transliteration = "[ˈiːmɒm]", translation = "EMOM (каждую минуту по подходу)",
            definition = "A format where you start a fixed task at the top of every minute and rest till the next.",
            definitionNative = "Формат: в начале каждой минуты выполняешь заданную задачу и отдыхаешь до следующей.",
            example = "Our coach gave us a brutal EMOM of ten thrusters per minute.",
            exampleNative = "Тренер задал жестокий EMOM по десять трастеров в минуту.",
            pos = "noun", semanticGroup = "fitness_training_intervals", fillInBlankExclusions = listOf(45301L, 45303L, 45304L, 45305L)),

        WordEntity(id = 45303, setId = 453, languagePair = "en-ru", rarity = "RARE",
            original = "AMRAP", transliteration = "[ˈæmræp]", translation = "AMRAP (как можно больше раундов)",
            definition = "A timed format where you finish as many rounds of a set list as you can.",
            definitionNative = "Формат на время: успеть как можно больше кругов заданного списка движений.",
            example = "She scored fifteen rounds in the twenty-minute AMRAP today.",
            exampleNative = "Сегодня в двадцатиминутном AMRAP она набрала пятнадцать кругов.",
            pos = "noun", semanticGroup = "fitness_training_intervals", fillInBlankExclusions = listOf(45301L, 45302L, 45304L, 45305L)),

        WordEntity(id = 45304, setId = 453, languagePair = "en-ru", rarity = "RARE",
            original = "fartlek", transliteration = "[ˈfɑːrtlek]", translation = "фартлек (рваный темп)",
            definition = "A run that mixes fast bursts and slow easy parts on the fly, without strict timing.",
            definitionNative = "Бег с произвольным чередованием быстрых рывков и медленных лёгких отрезков.",
            example = "A long fartlek along the river cleared his head before the meeting.",
            exampleNative = "Долгий fartlek вдоль реки прояснил ему голову перед совещанием.",
            pos = "noun", semanticGroup = "fitness_training_intervals", fillInBlankExclusions = listOf(45301L, 45302L, 45303L, 45305L)),

        WordEntity(id = 45305, setId = 453, languagePair = "en-ru", rarity = "RARE",
            original = "metcon", transliteration = "[ˈmetkɒn]", translation = "меткон (метаболический комплекс)",
            definition = "A short conditioning piece that hammers the heart and lungs to the limit.",
            definitionNative = "Короткий комплекс на выносливость, нагружающий сердце и лёгкие до предела.",
            example = "Friday's metcon mixed kettlebells, rowing and burpees in three rounds.",
            exampleNative = "Пятничный metcon смешал гири, греблю и бёрпи в три круга.",
            pos = "noun", semanticGroup = "fitness_training_intervals", fillInBlankExclusions = listOf(45301L, 45302L, 45303L, 45304L)),

        // ── fitness_training_combat (5) ───────────────────────────────────────

        WordEntity(id = 45306, setId = 453, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "kickboxing", transliteration = "[ˈkɪkbɒksɪŋ]", translation = "кикбоксинг",
            definition = "A combat sport mixing punches with kicks, often used as cardio in gyms.",
            definitionNative = "Единоборство, сочетающее удары руками и ногами, часто как кардио в зале.",
            example = "An hour of kickboxing burns more calories than a long run.",
            exampleNative = "Час kickboxing сжигает больше калорий, чем долгая пробежка.",
            pos = "noun", semanticGroup = "fitness_training_combat", fillInBlankExclusions = listOf(45307L, 45308L, 45309L, 45310L)),

        WordEntity(id = 45307, setId = 453, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "MMA", transliteration = "[ˌemeˈmeɪ]", translation = "ММА (смешанные единоборства)",
            definition = "A full-contact sport that lets fighters use striking, wrestling and ground holds.",
            definitionNative = "Полноконтактный спорт, где разрешены удары, борьба и приёмы на полу.",
            example = "He trains MMA five days a week to stay sharp for amateur bouts.",
            exampleNative = "Он тренирует MMA пять дней в неделю ради любительских боёв.",
            pos = "noun", semanticGroup = "fitness_training_combat", fillInBlankExclusions = listOf(45306L, 45308L, 45309L, 45310L)),

        WordEntity(id = 45308, setId = 453, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "wrestling", transliteration = "[ˈreslɪŋ]", translation = "борьба (вид спорта)",
            definition = "A grappling sport where you try to pin the other person to the mat.",
            definitionNative = "Контактный спорт, в котором задача — прижать соперника спиной к ковру.",
            example = "Years of wrestling gave him a powerful grip and steady balance.",
            exampleNative = "Годы wrestling дали ему мощный хват и устойчивое равновесие.",
            pos = "noun", semanticGroup = "fitness_training_combat", fillInBlankExclusions = listOf(45306L, 45307L, 45309L, 45310L)),

        WordEntity(id = 45309, setId = 453, languagePair = "en-ru", rarity = "RARE",
            original = "capoeira", transliteration = "[ˌkæpuˈeərə]", translation = "капоэйра",
            definition = "A Brazilian art that blends fight moves, dance and acrobatics with live music.",
            definitionNative = "Бразильское искусство, смешивающее боевые движения, танец и акробатику под живую музыку.",
            example = "A capoeira circle in the park drew a crowd of curious tourists.",
            exampleNative = "Круг capoeira в парке собрал толпу любопытных туристов.",
            pos = "noun", semanticGroup = "fitness_training_combat", fillInBlankExclusions = listOf(45306L, 45307L, 45308L, 45310L)),

        WordEntity(id = 45310, setId = 453, languagePair = "en-ru", rarity = "RARE",
            original = "sparring", transliteration = "[ˈspɑːrɪŋ]", translation = "спарринг (учебный бой)",
            definition = "A practice fight at controlled speed, used to test moves between two trained partners.",
            definitionNative = "Учебный бой в контролируемом темпе для отработки движений между двумя партнёрами.",
            example = "Light sparring on Saturdays sharpens his timing without real risk.",
            exampleNative = "Лёгкий sparring по субботам оттачивает чувство времени без серьёзного риска.",
            pos = "noun", semanticGroup = "fitness_training_combat", fillInBlankExclusions = listOf(45306L, 45307L, 45308L, 45309L)),

        // ── fitness_training_disciplines (5) ──────────────────────────────────

        WordEntity(id = 45311, setId = 453, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "CrossFit", transliteration = "[ˈkrɒsfɪt]", translation = "кроссфит",
            definition = "A branded gym system that mixes lifting, gymnastics and short hard cardio bouts.",
            definitionNative = "Брендовая система занятий, смешивающая подъёмы, гимнастику и короткое жёсткое кардио.",
            example = "He joined a CrossFit box near his office for a morning class.",
            exampleNative = "Он записался на утренний CrossFit рядом с офисом.",
            pos = "noun", semanticGroup = "fitness_training_disciplines", fillInBlankExclusions = listOf(45312L, 45313L, 45314L, 45315L)),

        WordEntity(id = 45312, setId = 453, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "powerlifting", transliteration = "[ˈpaʊərˌlɪftɪŋ]", translation = "пауэрлифтинг",
            definition = "A sport judged on three heavy lifts: the squat, the bench press and the deadlift.",
            definitionNative = "Спорт, где судят по трём тяжёлым движениям: приседу, жиму лёжа и становой тяге.",
            example = "Top powerlifting meets sometimes have ties decided by body weight alone.",
            exampleNative = "На крупных стартах powerlifting ничью иногда решает один лишь вес тела.",
            pos = "noun", semanticGroup = "fitness_training_disciplines", fillInBlankExclusions = listOf(45311L, 45313L, 45314L, 45315L)),

        WordEntity(id = 45313, setId = 453, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "bodybuilding", transliteration = "[ˈbɒdiˌbɪldɪŋ]", translation = "бодибилдинг",
            definition = "A sport that judges shape and size of muscles posed on a stage.",
            definitionNative = "Спорт, где судьи оценивают форму и объём мышц атлета на сцене.",
            example = "He took up bodybuilding after years of casual gym visits.",
            exampleNative = "Он занялся bodybuilding после многих лет редких походов в зал.",
            pos = "noun", semanticGroup = "fitness_training_disciplines", fillInBlankExclusions = listOf(45311L, 45312L, 45314L, 45315L)),

        WordEntity(id = 45314, setId = 453, languagePair = "en-ru", rarity = "RARE",
            original = "tai chi", transliteration = "[ˌtaɪ ˈʧiː]", translation = "тайцзи (тайчи)",
            definition = "A Chinese practice of slow flowing poses, used for balance and inner calm.",
            definitionNative = "Китайская практика медленных текучих поз для равновесия и внутреннего покоя.",
            example = "Old men in the park start each day with a quiet tai chi session.",
            exampleNative = "Пожилые мужчины в парке начинают день с тихого занятия tai chi.",
            pos = "noun", semanticGroup = "fitness_training_disciplines", fillInBlankExclusions = listOf(45311L, 45312L, 45313L, 45315L)),

        WordEntity(id = 45315, setId = 453, languagePair = "en-ru", rarity = "RARE",
            original = "qigong", transliteration = "[ˌʧiːˈɡɒŋ]", translation = "цигун",
            definition = "A Chinese system of soft moves and breath aimed at health and inner energy.",
            definitionNative = "Китайская система мягких движений и дыхания ради здоровья и внутренней энергии.",
            example = "She does qigong every morning before her tea and the news.",
            exampleNative = "Каждое утро она занимается qigong до чая и новостей.",
            pos = "noun", semanticGroup = "fitness_training_disciplines", fillInBlankExclusions = listOf(45311L, 45312L, 45313L, 45314L)),

        // ── fitness_training_classes (5) ──────────────────────────────────────

        WordEntity(id = 45316, setId = 453, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "bootcamp", transliteration = "[ˈbuːtkæmp]", translation = "буткемп (армейская тренировка)",
            definition = "A tough group class run like army drill with running, jumps and short rests.",
            definitionNative = "Жёсткое групповое занятие в армейском стиле: бег, прыжки и короткий отдых.",
            example = "An outdoor bootcamp at six in the morning is not for the faint of heart.",
            exampleNative = "Уличный bootcamp в шесть утра — не для слабых духом.",
            pos = "noun", semanticGroup = "fitness_training_classes", fillInBlankExclusions = listOf(45317L, 45318L, 45319L, 45320L)),

        WordEntity(id = 45317, setId = 453, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "aerobics", transliteration = "[eəˈroʊbɪks]", translation = "аэробика",
            definition = "A group class of music-led moves that lift the heart rate for a long stretch.",
            definitionNative = "Групповое занятие под музыку, поднимающее пульс на долгий отрезок времени.",
            example = "Step aerobics was the queen of gyms in the late eighties.",
            exampleNative = "Степ aerobics была королевой залов в конце восьмидесятых.",
            pos = "noun", semanticGroup = "fitness_training_classes", fillInBlankExclusions = listOf(45316L, 45318L, 45319L, 45320L)),

        WordEntity(id = 45318, setId = 453, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "spinning", transliteration = "[ˈspɪnɪŋ]", translation = "сайклинг (спиннинг)",
            definition = "A high-energy group class on stationary bikes led by music and a coach.",
            definitionNative = "Энергичное групповое занятие на велотренажёрах под музыку и команды тренера.",
            example = "Forty-five minutes of spinning soaks the whole group in sweat.",
            exampleNative = "Сорок пять минут spinning оставляют всю группу мокрыми от пота.",
            pos = "noun", semanticGroup = "fitness_training_classes", fillInBlankExclusions = listOf(45316L, 45317L, 45319L, 45320L)),

        WordEntity(id = 45319, setId = 453, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "Zumba", transliteration = "[ˈzʌmbə]", translation = "зумба (танцевальный фитнес)",
            definition = "A group class that mixes Latin dance steps with cardio moves under loud music.",
            definitionNative = "Групповое занятие, мешающее латинские танцевальные шаги с кардио под громкую музыку.",
            example = "An hour of Zumba feels more like a party than a workout.",
            exampleNative = "Час Zumba ощущается скорее как вечеринка, чем как тренировка.",
            pos = "noun", semanticGroup = "fitness_training_classes", fillInBlankExclusions = listOf(45316L, 45317L, 45318L, 45320L)),

        WordEntity(id = 45320, setId = 453, languagePair = "en-ru", rarity = "RARE",
            original = "barre", transliteration = "[bɑːr]", translation = "барр (фитнес у балетного станка)",
            definition = "A class at a ballet bar that uses tiny moves to sculpt the legs and core.",
            definitionNative = "Занятие у балетного станка с мелкими движениями для проработки ног и корпуса.",
            example = "She traded heavy lifting for a gentler barre class twice a week.",
            exampleNative = "Она сменила тяжёлые подъёмы на более мягкое barre дважды в неделю.",
            pos = "noun", semanticGroup = "fitness_training_classes", fillInBlankExclusions = listOf(45316L, 45317L, 45318L, 45319L)),

        // ── fitness_training_bodyweight (5) ───────────────────────────────────

        WordEntity(id = 45321, setId = 453, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "pull-up", transliteration = "[ˈpʊlʌp]", translation = "подтягивание (хват сверху)",
            definition = "A move where you hang from a bar and pull your chin above it using overhand grip.",
            definitionNative = "Движение: вис на перекладине и подъём подбородка над ней хватом сверху.",
            example = "His first clean pull-up came after three months of regular practice.",
            exampleNative = "Его первое чистое pull-up получилось после трёх месяцев регулярных занятий.",
            pos = "noun", semanticGroup = "fitness_training_bodyweight", fillInBlankExclusions = listOf(45322L, 45323L, 45324L, 45325L)),

        WordEntity(id = 45322, setId = 453, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "push-up", transliteration = "[ˈpʊʃʌp]", translation = "отжимание",
            definition = "A floor move: lower the chest with the arms and push the body back up.",
            definitionNative = "Движение на полу: опустить грудь руками и вернуть тело наверх.",
            example = "A perfect push-up keeps the body straight from head to heels.",
            exampleNative = "Идеальное push-up держит тело прямым от головы до пяток.",
            pos = "noun", semanticGroup = "fitness_training_bodyweight", fillInBlankExclusions = listOf(45321L, 45323L, 45324L, 45325L)),

        WordEntity(id = 45323, setId = 453, languagePair = "en-ru", rarity = "RARE",
            original = "chin-up", transliteration = "[ˈʧɪnʌp]", translation = "подтягивание обратным хватом",
            definition = "A bar move done with palms facing you, which loads the biceps a bit harder.",
            definitionNative = "Движение на перекладине ладонями к себе — даёт чуть больше нагрузки на бицепс.",
            example = "He likes the chin-up because it hits the arms more directly.",
            exampleNative = "Он любит chin-up за более прямую нагрузку на руки.",
            pos = "noun", semanticGroup = "fitness_training_bodyweight", fillInBlankExclusions = listOf(45321L, 45322L, 45324L, 45325L)),

        WordEntity(id = 45324, setId = 453, languagePair = "en-ru", rarity = "RARE",
            original = "muscle-up", transliteration = "[ˈmʌsəlʌp]", translation = "выход силой (на турник)",
            definition = "An advanced move that pulls the body from a hang up over the bar in one flow.",
            definitionNative = "Сложное движение: одним потоком вывести тело из виса над перекладиной.",
            example = "A clean muscle-up takes years of patient bodyweight practice.",
            exampleNative = "Чистый muscle-up требует лет терпеливых занятий с собственным весом.",
            pos = "noun", semanticGroup = "fitness_training_bodyweight", fillInBlankExclusions = listOf(45321L, 45322L, 45323L, 45325L)),

        WordEntity(id = 45325, setId = 453, languagePair = "en-ru", rarity = "RARE",
            original = "box jump", transliteration = "[bɒks ʤʌmp]", translation = "запрыгивание на тумбу",
            definition = "An explosive move where you jump from the floor onto a sturdy raised platform.",
            definitionNative = "Взрывное движение: прыжок с пола на устойчивую возвышенную платформу.",
            example = "Her first box jump onto the high platform felt like a small victory.",
            exampleNative = "Её первый box jump на высокую тумбу ощущался маленькой победой.",
            pos = "noun", semanticGroup = "fitness_training_bodyweight", fillInBlankExclusions = listOf(45321L, 45322L, 45323L, 45324L)),
    )
}
