package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — «Здоровье и фитнес» (новая тема, levels 1-3).
 *
 * Set 345 — L1 (COMMON+UNCOMMON): A1-лексика про спорт, тренировки и ЗОЖ для
 *           повседневных разговоров.
 * Set 346 — L2 (UNCOMMON+RARE): продвинутая лексика фитнеса — упражнения, питание,
 *           спортивные термины.
 * Set 347 — L3 (RARE+EPIC): углублённая лексика здоровья — тренировочные
 *           методики, биомеханика, нутрициология.
 *
 * Топик «Здоровье и фитнес» в en-ru ранее не существовал. Cross-topic дубли с
 * наборами «Спорт» (17/210/253/308/315/316), «Медицина» (12/30/212/254/282/322/323),
 * «Лингвистика» (2/6/...) и др. допустимы по правилу «cross-topic дубли разрешены»
 * (docs/claude/feedback_duplicate_words_policy.md). Внутри-темы коллизий нет —
 * это первый и единственный сет «Здоровье и фитнес».
 *
 * SemanticGroups:
 *   Set 345 (5×5): health_movement, health_body, health_nutrition,
 *                  health_routines, health_concepts
 *   Set 346 (5×5): fitness_exercises, fitness_equipment, fitness_concepts,
 *                  fitness_nutrition, fitness_routines
 *   Set 347 (5×5): health_adv_training, health_adv_systems,
 *                  health_adv_nutrition, health_adv_movement, health_adv_science
 *
 * Word IDs: setId × 100 + position (1..25).
 *
 * fillInBlankExclusions заполнит pipeline (см. fill-in-blank-pipeline.md).
 * Регистрация в WordRegistry / bump WordDataVersion — централизованно.
 */
object WordDataEnglishHealthFitnessL1L2L3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 345, languagePair = "en-ru", orderIndex = 145,
            name = "Здоровье и фитнес",
            description = "Базовая лексика про спорт, тренировки и здоровый образ жизни для повседневных разговоров",
            topic = "Здоровье и фитнес", level = 1,
        ),
        WordSetEntity(
            id = 346, languagePair = "en-ru", orderIndex = 146,
            name = "Здоровье и фитнес",
            description = "Продвинутая лексика фитнеса: упражнения, питание, спортивные термины",
            topic = "Здоровье и фитнес", level = 2,
        ),
        WordSetEntity(
            id = 347, languagePair = "en-ru", orderIndex = 147,
            name = "Здоровье и фитнес",
            description = "Углублённая лексика здоровья: тренировочные методики, биомеханика, нутрициология",
            topic = "Здоровье и фитнес", level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ════════════════════════════════════════════════════════════════════
        //  SET 345 — L1 — Здоровье и фитнес (COMMON + UNCOMMON)
        // ════════════════════════════════════════════════════════════════════

        // ── health_movement (5) ───────────────────────────────────────────────

        WordEntity(id = 34501, setId = 345, languagePair = "en-ru", rarity = "COMMON",
            original = "run", transliteration = "[rʌn]", translation = "бегать",
            definition = "To move on your feet faster than walking, with both feet leaving the ground.",
            definitionNative = "Двигаться на ногах быстрее, чем при ходьбе, отрываясь от земли.",
            example = "I run in the park every morning before breakfast.",
            exampleNative = "Я люблю run в парке ранним утром до завтрака.",
            pos = "verb", semanticGroup = "health_movement", fillInBlankExclusions = listOf(34502L, 34503L, 34504L, 34505L)),

        WordEntity(id = 34502, setId = 345, languagePair = "en-ru", rarity = "COMMON",
            original = "walk", transliteration = "[wɔːk]", translation = "ходить пешком",
            definition = "To move on your feet at a steady pace without rushing.",
            definitionNative = "Перемещаться на ногах ровным шагом, не спеша.",
            example = "Doctors say a daily walk is good for your heart.",
            exampleNative = "Врачи говорят, что ежедневный walk полезен для сердца.",
            pos = "verb", semanticGroup = "health_movement", fillInBlankExclusions = listOf(34501L, 34503L, 34504L, 34505L, 34517L, 34525L)),

        WordEntity(id = 34503, setId = 345, languagePair = "en-ru", rarity = "COMMON",
            original = "swim", transliteration = "[swɪm]", translation = "плавать",
            definition = "To move through water using your arms and legs.",
            definitionNative = "Двигаться в воде, работая руками и ногами.",
            example = "She likes to swim two kilometres every Saturday.",
            exampleNative = "По субботам она любит swim два километра в бассейне.",
            pos = "verb", semanticGroup = "health_movement", fillInBlankExclusions = listOf(34501L, 34502L, 34504L, 34505L)),

        WordEntity(id = 34504, setId = 345, languagePair = "en-ru", rarity = "COMMON",
            original = "jump", transliteration = "[ʤʌmp]", translation = "прыгать",
            definition = "To push off the ground hard so your whole body goes into the air.",
            definitionNative = "Резко оттолкнуться от земли так, чтобы тело оказалось в воздухе.",
            example = "Children love to jump on the trampoline in the yard.",
            exampleNative = "Дети обожают jump на батуте во дворе.",
            pos = "verb", semanticGroup = "health_movement", fillInBlankExclusions = listOf(34501L, 34502L, 34503L, 34505L)),

        WordEntity(id = 34505, setId = 345, languagePair = "en-ru", rarity = "COMMON",
            original = "lift", transliteration = "[lɪft]", translation = "тянуть вверх",
            definition = "To raise a heavy thing into the air with your hands or arms.",
            definitionNative = "Брать тяжёлый предмет и направлять его вверх руками или плечом.",
            example = "He can lift fifty kilos above his head with both arms.",
            exampleNative = "Он может lift пятьдесят килограммов над головой обеими руками.",
            pos = "verb", semanticGroup = "health_movement", fillInBlankExclusions = listOf(34501L, 34502L, 34503L, 34504L)),

        // ── health_body (5) ───────────────────────────────────────────────────

        WordEntity(id = 34506, setId = 345, languagePair = "en-ru", rarity = "COMMON",
            original = "heart", transliteration = "[hɑːrt]", translation = "сердце",
            definition = "The organ inside the chest that pumps blood around your body.",
            definitionNative = "Орган в груди, который качает кровь по всему телу.",
            example = "After the sprint my heart was beating very fast.",
            exampleNative = "После спринта моё heart билось очень быстро.",
            pos = "noun", semanticGroup = "health_body", fillInBlankExclusions = listOf(34507L, 34508L, 34509L, 34510L)),

        WordEntity(id = 34507, setId = 345, languagePair = "en-ru", rarity = "COMMON",
            original = "muscle", transliteration = "[ˈmʌsəl]", translation = "мышца",
            definition = "Soft body tissue under the skin that lets your arms and legs move.",
            definitionNative = "Мягкая ткань под кожей, благодаря которой движутся руки и ноги.",
            example = "Lifting weights makes the muscle in your arms grow.",
            exampleNative = "Подъём гантелей наращивает muscle в руках.",
            pos = "noun", semanticGroup = "health_body", fillInBlankExclusions = listOf(34506L, 34508L, 34509L, 34510L)),

        WordEntity(id = 34508, setId = 345, languagePair = "en-ru", rarity = "COMMON",
            original = "body", transliteration = "[ˈbɒdi]", translation = "тело",
            definition = "All the parts of a person — head, chest, arms and legs together.",
            definitionNative = "Все части человека — голова, грудь, руки и ноги вместе.",
            example = "Yoga is good for the whole body and the mind.",
            exampleNative = "Йога полезна для всего body и для ума.",
            pos = "noun", semanticGroup = "health_body", fillInBlankExclusions = listOf(34506L, 34507L, 34509L, 34510L)),

        WordEntity(id = 34509, setId = 345, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "breath", transliteration = "[breθ]", translation = "вдох; дыхание",
            definition = "The air that goes in and out of your nose and mouth.",
            definitionNative = "Воздух, который входит в нос и рот и выходит обратно.",
            example = "Take a deep breath before you start the heavy lift.",
            exampleNative = "Сделай глубокий breath перед тем, как поднять штангу.",
            pos = "noun", semanticGroup = "health_body", fillInBlankExclusions = listOf(34506L, 34507L, 34508L, 34510L)),

        WordEntity(id = 34510, setId = 345, languagePair = "en-ru", rarity = "COMMON",
            original = "weight", transliteration = "[weɪt]", translation = "вес тела",
            definition = "How heavy a person or thing is, measured on a scale.",
            definitionNative = "Насколько тяжёлый человек или предмет — то, что показывают весы.",
            example = "She lost five kilos of weight in three months.",
            exampleNative = "За три месяца она сбросила пять килограммов weight.",
            pos = "noun", semanticGroup = "health_body", fillInBlankExclusions = listOf(34506L, 34507L, 34508L, 34509L, 34511L)),

        // ── health_nutrition (5) ──────────────────────────────────────────────

        WordEntity(id = 34511, setId = 345, languagePair = "en-ru", rarity = "COMMON",
            original = "water", transliteration = "[ˈwɔːtər]", translation = "вода",
            definition = "The clear liquid you drink every day to stay alive.",
            definitionNative = "Прозрачная жидкость, которую пьют каждый день для жизни.",
            example = "Drink plenty of water during a long workout.",
            exampleNative = "Пей побольше water во время долгой тренировки.",
            pos = "noun", semanticGroup = "health_nutrition", fillInBlankExclusions = listOf(34512L, 34513L, 34514L, 34515L)),

        WordEntity(id = 34512, setId = 345, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "vitamin", transliteration = "[ˈvaɪtəmɪn]", translation = "витамин",
            definition = "A tiny thing in food that your body needs to stay well.",
            definitionNative = "Микроскопическое вещество в пище, нужное организму, чтобы быть здоровым.",
            example = "Oranges have a lot of vitamin C, so kids love them.",
            exampleNative = "В апельсинах много vitamin C, поэтому дети их любят.",
            pos = "noun", semanticGroup = "health_nutrition", fillInBlankExclusions = listOf(34511L, 34513L, 34514L, 34515L)),

        WordEntity(id = 34513, setId = 345, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "diet", transliteration = "[ˈdaɪət]", translation = "диета; рацион",
            definition = "The kinds of food a person usually eats every day.",
            definitionNative = "То, какую еду человек обычно ест каждый день.",
            example = "A healthy diet has lots of vegetables and fruit.",
            exampleNative = "В здоровом diet много овощей и фруктов.",
            pos = "noun", semanticGroup = "health_nutrition", fillInBlankExclusions = listOf(34511L, 34512L, 34514L)),

        WordEntity(id = 34514, setId = 345, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "calorie", transliteration = "[ˈkæləri]", translation = "калория",
            definition = "A unit that shows how much energy a piece of food gives you.",
            definitionNative = "Единица, показывающая, сколько энергии даёт еда телу.",
            example = "Each calorie on the label adds up at the end of the day.",
            exampleNative = "Каждая calorie на этикетке складывается за день.",
            pos = "noun", semanticGroup = "health_nutrition", fillInBlankExclusions = listOf(34511L, 34512L, 34513L, 34515L)),

        WordEntity(id = 34515, setId = 345, languagePair = "en-ru", rarity = "COMMON",
            original = "fruit", transliteration = "[fruːt]", translation = "фрукт",
            definition = "A sweet thing that grows on a tree, like an apple or a pear.",
            definitionNative = "Сладкий плод, который растёт на дереве — яблоко, груша и так далее.",
            example = "Eat a piece of fruit instead of a sweet bar.",
            exampleNative = "Съешь fruit вместо шоколадного батончика.",
            pos = "noun", semanticGroup = "health_nutrition", fillInBlankExclusions = listOf(34511L, 34512L, 34513L, 34514L)),

        // ── health_routines (5) ───────────────────────────────────────────────

        WordEntity(id = 34516, setId = 345, languagePair = "en-ru", rarity = "COMMON",
            original = "gym", transliteration = "[ʤɪm]", translation = "спортзал",
            definition = "A big room with machines and weights for working out indoors.",
            definitionNative = "Большое помещение с тренажёрами и весами для занятий в помещении.",
            example = "I go to the gym three times a week after work.",
            exampleNative = "Я хожу в gym три раза в неделю после работы.",
            pos = "noun", semanticGroup = "health_routines", fillInBlankExclusions = listOf(34517L, 34518L, 34519L, 34520L)),

        WordEntity(id = 34517, setId = 345, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "workout", transliteration = "[ˈwɜːrkaʊt]", translation = "тренировка",
            definition = "A session of moves and lifting done to keep the body strong.",
            definitionNative = "Занятие из упражнений и подъёмов, чтобы поддерживать тело сильным.",
            example = "A short workout in the morning gives me energy all day.",
            exampleNative = "Короткий workout с утра даёт мне силы на весь день.",
            pos = "noun", semanticGroup = "health_routines", fillInBlankExclusions = listOf(34501L, 34502L, 34503L, 34516L, 34518L, 34519L, 34520L)),

        WordEntity(id = 34518, setId = 345, languagePair = "en-ru", rarity = "COMMON",
            original = "sleep", transliteration = "[sliːp]", translation = "сон",
            definition = "The quiet time at night when your eyes close and you rest fully.",
            definitionNative = "Тихое время ночью, когда глаза закрыты и тело полностью отдыхает.",
            example = "Eight hours of sleep each night helps you stay healthy.",
            exampleNative = "Восемь часов sleep каждую ночь помогают сохранять здоровье.",
            pos = "noun", semanticGroup = "health_routines", fillInBlankExclusions = listOf(34516L, 34517L, 34519L, 34520L, 34525L)),

        WordEntity(id = 34519, setId = 345, languagePair = "en-ru", rarity = "COMMON",
            original = "rest", transliteration = "[rest]", translation = "отдых",
            definition = "A short break when you stop moving and let your body recover.",
            definitionNative = "Короткий перерыв, когда перестаёшь двигаться и тело восстанавливается.",
            example = "Take a short rest between hard sets at the gym.",
            exampleNative = "Делай короткий rest между тяжёлыми подходами в зале.",
            pos = "noun", semanticGroup = "health_routines", fillInBlankExclusions = listOf(34502L, 34509L, 34517L, 34518L, 34520L)),

        WordEntity(id = 34520, setId = 345, languagePair = "en-ru", rarity = "COMMON",
            original = "sport", transliteration = "[spɔːrt]", translation = "спорт",
            definition = "An activity with rules where people play or compete using the body.",
            definitionNative = "Занятие с правилами, где люди играют или соревнуются с помощью тела.",
            example = "Football is the most popular sport in our school.",
            exampleNative = "Футбол — самый популярный sport в нашей школе.",
            pos = "noun", semanticGroup = "health_routines", fillInBlankExclusions = listOf(34516L, 34517L, 34518L, 34519L)),

        // ── health_concepts (5) ───────────────────────────────────────────────

        WordEntity(id = 34521, setId = 345, languagePair = "en-ru", rarity = "COMMON",
            original = "healthy", transliteration = "[ˈhelθi]", translation = "здоровый",
            definition = "Free from sickness and feeling well in body and mind.",
            definitionNative = "Без болезней, в хорошем состоянии тела и духа.",
            example = "She feels healthy after a year of regular exercise.",
            exampleNative = "Она чувствует себя healthy после года регулярных тренировок.",
            pos = "adjective", semanticGroup = "health_concepts", fillInBlankExclusions = listOf(34522L)),

        WordEntity(id = 34522, setId = 345, languagePair = "en-ru", rarity = "COMMON",
            original = "strong", transliteration = "[strɒŋ]", translation = "крепкий, мощный",
            definition = "Able to lift heavy things or push hard with the body.",
            definitionNative = "Имеющий много мускульной мощи: легко поднимает тяжёлое и хорошо толкает.",
            example = "He has very strong arms from years of swimming.",
            exampleNative = "У него очень strong руки после многих лет плавания.",
            pos = "adjective", semanticGroup = "health_concepts", fillInBlankExclusions = listOf(34521L)),

        WordEntity(id = 34523, setId = 345, languagePair = "en-ru", rarity = "COMMON",
            original = "fitness", transliteration = "[ˈfɪtnəs]", translation = "физическая форма",
            definition = "How well your body can move, lift and last during effort.",
            definitionNative = "Насколько хорошо тело двигается, поднимает грузы и держит нагрузку.",
            example = "Daily walks helped her fitness a lot in two months.",
            exampleNative = "Ежедневные прогулки заметно подняли её fitness за два месяца.",
            pos = "noun", semanticGroup = "health_concepts", fillInBlankExclusions = listOf(34506L, 34508L, 34509L, 34510L, 34518L, 34524L, 34525L)),

        WordEntity(id = 34524, setId = 345, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "energy", transliteration = "[ˈenərʤi]", translation = "энергия (телесная)",
            definition = "The power inside your body that lets you move and work.",
            definitionNative = "Внутренние силы тела, позволяющие двигаться и работать.",
            example = "A good breakfast gives me lots of energy for class.",
            exampleNative = "Хороший завтрак даёт мне много energy на занятия.",
            pos = "noun", semanticGroup = "health_concepts", fillInBlankExclusions = listOf(34511L, 34515L, 34518L, 34519L, 34523L, 34525L)),

        WordEntity(id = 34525, setId = 345, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "exercise", transliteration = "[ˈeksərsaɪz]", translation = "упражнение",
            definition = "A simple move you do to make the body stronger or healthier.",
            definitionNative = "Простое движение, которое делают, чтобы тело стало крепче или здоровее.",
            example = "Push-ups are a classic exercise for the chest and arms.",
            exampleNative = "Отжимания — классическое exercise для груди и рук.",
            pos = "noun", semanticGroup = "health_concepts", fillInBlankExclusions = listOf(34517L, 34523L, 34524L)),

        // ════════════════════════════════════════════════════════════════════
        //  SET 346 — L2 — Здоровье и фитнес (UNCOMMON + RARE)
        // ════════════════════════════════════════════════════════════════════

        // ── fitness_exercises (5) ─────────────────────────────────────────────

        WordEntity(id = 34601, setId = 346, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "squat", transliteration = "[skwɒt]", translation = "приседание",
            definition = "A move where you bend the knees to drop low and then stand back up.",
            definitionNative = "Упражнение: согнуть колени, опуститься вниз и снова встать.",
            example = "A deep squat works the thighs and the glutes hard.",
            exampleNative = "Глубокий squat сильно нагружает бёдра и ягодицы.",
            pos = "noun", semanticGroup = "fitness_exercises", fillInBlankExclusions = listOf(34602L, 34603L, 34604L, 34605L)),

        WordEntity(id = 34602, setId = 346, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "lunge", transliteration = "[lʌnʤ]", translation = "выпад",
            definition = "A long step forward where the back knee almost touches the floor.",
            definitionNative = "Большой шаг вперёд так, что заднее колено почти касается пола.",
            example = "A clean walking lunge keeps the front knee over the toes.",
            exampleNative = "Чистый шагающий lunge удерживает переднее колено над носком.",
            pos = "noun", semanticGroup = "fitness_exercises", fillInBlankExclusions = listOf(34601L, 34603L, 34604L, 34605L)),

        WordEntity(id = 34603, setId = 346, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "sprint", transliteration = "[sprɪnt]", translation = "спринт; быстрый забег",
            definition = "A very fast short run, given everything you have for a brief time.",
            definitionNative = "Очень быстрый короткий бег на пределе сил в течение нескольких секунд.",
            example = "A short hard sprint at the end ruins my legs.",
            exampleNative = "Короткий тяжёлый sprint в конце убивает мне ноги.",
            pos = "noun", semanticGroup = "fitness_exercises", fillInBlankExclusions = listOf(34601L, 34602L, 34604L, 34605L)),

        WordEntity(id = 34604, setId = 346, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "jog", transliteration = "[ʤɒɡ]", translation = "бег трусцой",
            definition = "A slow steady run done for a long time without rushing.",
            definitionNative = "Медленный ровный бег, который держат долго и без спешки.",
            example = "A gentle morning jog clears her head before work.",
            exampleNative = "Лёгкий утренний jog проясняет ей голову перед работой.",
            pos = "noun", semanticGroup = "fitness_exercises", fillInBlankExclusions = listOf(34601L, 34602L, 34603L, 34605L)),

        WordEntity(id = 34605, setId = 346, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "plank", transliteration = "[plæŋk]", translation = "планка (упражнение)",
            definition = "A still hold on the toes and forearms with the body straight as a board.",
            definitionNative = "Статичная поза: упор на носки и предплечья, тело прямое как доска.",
            example = "Hold a plank for one minute to train the core.",
            exampleNative = "Держи plank минуту, чтобы прокачать корпус.",
            pos = "noun", semanticGroup = "fitness_exercises", fillInBlankExclusions = listOf(34601L, 34602L, 34603L, 34604L)),

        // ── fitness_equipment (5) ─────────────────────────────────────────────

        WordEntity(id = 34606, setId = 346, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "treadmill", transliteration = "[ˈtredmɪl]", translation = "беговая дорожка",
            definition = "A gym machine with a moving belt for indoor running and walking.",
            definitionNative = "Тренажёр с движущейся лентой для бега и ходьбы в помещении.",
            example = "I ran for half an hour on the treadmill today.",
            exampleNative = "Сегодня я бежал полчаса на treadmill в зале.",
            pos = "noun", semanticGroup = "fitness_equipment", fillInBlankExclusions = listOf(34607L, 34608L, 34609L, 34610L)),

        WordEntity(id = 34607, setId = 346, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "dumbbell", transliteration = "[ˈdʌmbel]", translation = "гантель",
            definition = "A short bar with heavy ends, lifted with one hand at a time.",
            definitionNative = "Короткий стержень с тяжёлыми концами, поднимаемый одной рукой.",
            example = "She picked up a five-kilo dumbbell for arm curls.",
            exampleNative = "Она взяла пятикилограммовую dumbbell для сгибаний на бицепс.",
            pos = "noun", semanticGroup = "fitness_equipment", fillInBlankExclusions = listOf(34606L, 34608L, 34609L, 34610L)),

        WordEntity(id = 34608, setId = 346, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "barbell", transliteration = "[ˈbɑːrbel]", translation = "штанга",
            definition = "A long metal bar with heavy plates on each end, lifted with two hands.",
            definitionNative = "Длинный стержень с тяжёлыми блинами на концах, поднимаемый двумя руками.",
            example = "He loaded the barbell with twenty kilos for the squat.",
            exampleNative = "Он зарядил barbell двадцатью килограммами для приседания.",
            pos = "noun", semanticGroup = "fitness_equipment", fillInBlankExclusions = listOf(34606L, 34607L, 34609L, 34610L)),

        WordEntity(id = 34609, setId = 346, languagePair = "en-ru", rarity = "RARE",
            original = "kettlebell", transliteration = "[ˈketəlbel]", translation = "гиря",
            definition = "A round iron weight with a thick handle on top for swinging moves.",
            definitionNative = "Круглый чугунный груз с толстой ручкой сверху для маховых движений.",
            example = "Kettlebell swings train the back and the legs at once.",
            exampleNative = "Махи kettlebell тренируют спину и ноги одновременно.",
            pos = "noun", semanticGroup = "fitness_equipment", fillInBlankExclusions = listOf(34606L, 34607L, 34608L, 34610L)),

        WordEntity(id = 34610, setId = 346, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "mat", transliteration = "[mæt]", translation = "коврик (для занятий)",
            definition = "A soft thin pad on the floor that protects the back during ground moves.",
            definitionNative = "Мягкая тонкая подстилка на пол, защищающая спину при упражнениях лёжа.",
            example = "Roll out your mat before the yoga class starts.",
            exampleNative = "Раскатай свой mat перед началом занятия по йоге.",
            pos = "noun", semanticGroup = "fitness_equipment", fillInBlankExclusions = listOf(34606L, 34607L, 34608L, 34609L)),

        // ── fitness_concepts (5) ──────────────────────────────────────────────

        WordEntity(id = 34611, setId = 346, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "cardio", transliteration = "[ˈkɑːrdioʊ]", translation = "кардио (нагрузка)",
            definition = "Long activity that makes the heart beat fast — running or cycling.",
            definitionNative = "Долгая нагрузка, заставляющая сердце биться быстро — бег или велосипед.",
            example = "Twenty minutes of cardio is a good warm-up for the gym.",
            exampleNative = "Двадцать минут cardio — хорошая разминка перед залом.",
            pos = "noun", semanticGroup = "fitness_concepts", fillInBlankExclusions = listOf(34612L, 34613L, 34614L, 34615L)),

        WordEntity(id = 34612, setId = 346, languagePair = "en-ru", rarity = "RARE",
            original = "endurance", transliteration = "[ɪnˈdjʊərəns]", translation = "выносливость",
            definition = "The power to keep up effort for a long time without giving up.",
            definitionNative = "Способность долго удерживать усилие, не сдаваясь.",
            example = "Long swims build the endurance of the whole body.",
            exampleNative = "Долгие заплывы развивают endurance всего тела.",
            pos = "noun", semanticGroup = "fitness_concepts", fillInBlankExclusions = listOf(34611L, 34613L, 34614L, 34615L)),

        WordEntity(id = 34613, setId = 346, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "flexibility", transliteration = "[ˌfleksəˈbɪləti]", translation = "гибкость",
            definition = "How far the joints can bend before they feel tight or sore.",
            definitionNative = "Насколько суставы могут сгибаться, прежде чем появится напряжение.",
            example = "Yoga slowly improved her flexibility over a year.",
            exampleNative = "За год йога постепенно улучшила её flexibility.",
            pos = "noun", semanticGroup = "fitness_concepts", fillInBlankExclusions = listOf(34611L, 34612L, 34614L, 34615L, 34625L)),

        WordEntity(id = 34614, setId = 346, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "strength", transliteration = "[streŋθ]", translation = "сила (мышечная)",
            definition = "The amount of weight a person can push, pull or lift at once.",
            definitionNative = "Сколько веса человек может разово толкнуть, потянуть или поднять.",
            example = "Squats add strength to the legs and lower back.",
            exampleNative = "Приседания добавляют strength ногам и пояснице.",
            pos = "noun", semanticGroup = "fitness_concepts", fillInBlankExclusions = listOf(34611L, 34612L, 34613L, 34615L)),

        WordEntity(id = 34615, setId = 346, languagePair = "en-ru", rarity = "RARE",
            original = "stamina", transliteration = "[ˈstæmɪnə]", translation = "выносливость, стойкость",
            definition = "Inner staying power that lets a person keep going when others quit.",
            definitionNative = "Внутренний запас, позволяющий не сдаться, когда другие уже устали.",
            example = "Daily runs slowly built up his stamina over months.",
            exampleNative = "Ежедневные пробежки медленно нарастили его stamina за месяцы.",
            pos = "noun", semanticGroup = "fitness_concepts", fillInBlankExclusions = listOf(34611L, 34612L, 34613L, 34614L)),

        // ── fitness_nutrition (5) ─────────────────────────────────────────────

        WordEntity(id = 34616, setId = 346, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "protein", transliteration = "[ˈproʊtiːn]", translation = "белок (нутриент)",
            definition = "A nutrient in eggs, meat and beans that builds and fixes muscles.",
            definitionNative = "Нутриент из яиц, мяса и бобовых, строящий и чинящий мышцы.",
            example = "Athletes eat extra protein to help their muscles grow.",
            exampleNative = "Спортсмены едят больше protein, чтобы мышцы росли.",
            pos = "noun", semanticGroup = "fitness_nutrition", fillInBlankExclusions = listOf(34617L, 34618L, 34619L)),

        WordEntity(id = 34617, setId = 346, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "carb", transliteration = "[kɑːrb]", translation = "углевод (разг.)",
            definition = "A nutrient in bread, rice and pasta that gives quick energy.",
            definitionNative = "Нутриент из хлеба, риса и макарон, быстро дающий энергию.",
            example = "Pasta is a fast carb the night before a long race.",
            exampleNative = "Паста — быстрый carb накануне долгой гонки.",
            pos = "noun", semanticGroup = "fitness_nutrition", fillInBlankExclusions = listOf(34616L, 34618L, 34619L)),

        WordEntity(id = 34618, setId = 346, languagePair = "en-ru", rarity = "RARE",
            original = "supplement", transliteration = "[ˈsʌplɪmənt]", translation = "пищевая добавка",
            definition = "A pill or powder taken to add a missing nutrient to the diet.",
            definitionNative = "Таблетка или порошок, добавляемые в рацион ради недостающего нутриента.",
            example = "Some athletes take a daily supplement of vitamin D.",
            exampleNative = "Некоторые спортсмены пьют ежедневный supplement витамина D.",
            pos = "noun", semanticGroup = "fitness_nutrition", fillInBlankExclusions = listOf(34616L, 34617L, 34619L)),

        WordEntity(id = 34619, setId = 346, languagePair = "en-ru", rarity = "RARE",
            original = "hydration", transliteration = "[haɪˈdreɪʃən]", translation = "гидратация (питьевой режим)",
            definition = "Keeping enough fluid in the body so cells and muscles work well.",
            definitionNative = "Поддержание достаточного количества жидкости в теле для работы клеток.",
            example = "Good hydration during a marathon prevents painful cramps.",
            exampleNative = "Хорошая hydration на марафоне защищает от болезненных судорог.",
            pos = "noun", semanticGroup = "fitness_nutrition", fillInBlankExclusions = listOf(34612L, 34615L, 34616L, 34617L, 34618L)),

        WordEntity(id = 34620, setId = 346, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "balanced", transliteration = "[ˈbælənst]", translation = "сбалансированный (рацион)",
            definition = "Made up of different foods in the right amounts for good health.",
            definitionNative = "Состоящий из разных продуктов в нужных пропорциях для здоровья.",
            example = "A balanced meal has protein, carbs and vegetables.",
            exampleNative = "Balanced приём пищи содержит белки, углеводы и овощи.",
            pos = "adjective", semanticGroup = "fitness_nutrition"),

        // ── fitness_routines (5) ──────────────────────────────────────────────

        WordEntity(id = 34621, setId = 346, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "warmup", transliteration = "[ˈwɔːrmʌp]", translation = "разминка",
            definition = "Light moves at the start of training that get the body ready for effort.",
            definitionNative = "Лёгкие движения в начале тренировки, готовящие тело к нагрузке.",
            example = "Skipping the warmup often leads to a pulled muscle.",
            exampleNative = "Пропуск warmup часто заканчивается потянутой мышцей.",
            pos = "noun", semanticGroup = "fitness_routines", fillInBlankExclusions = listOf(34622L, 34623L, 34625L)),

        WordEntity(id = 34622, setId = 346, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "cooldown", transliteration = "[ˈkuːldaʊn]", translation = "заминка",
            definition = "Easy moves at the end of training that bring the heart rate slowly down.",
            definitionNative = "Лёгкие движения в конце тренировки, плавно снижающие пульс.",
            example = "Five minutes of cooldown reduces sore muscles tomorrow.",
            exampleNative = "Пять минут cooldown уменьшат боль в мышцах завтра.",
            pos = "noun", semanticGroup = "fitness_routines", fillInBlankExclusions = listOf(34621L, 34623L, 34625L)),

        WordEntity(id = 34623, setId = 346, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "recovery", transliteration = "[rɪˈkʌvəri]", translation = "восстановление (после нагрузки)",
            definition = "The quiet time after training when the body heals and gets stronger.",
            definitionNative = "Тихое время после тренировки, когда тело залечивается и крепнет.",
            example = "Sleep is the most important part of recovery.",
            exampleNative = "Сон — главная часть recovery после нагрузки.",
            pos = "noun", semanticGroup = "fitness_routines", fillInBlankExclusions = listOf(34621L, 34622L, 34625L)),

        WordEntity(id = 34624, setId = 346, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "intense", transliteration = "[ɪnˈtens]", translation = "интенсивный (о нагрузке)",
            definition = "Very strong or hard, taking a lot of effort over a short time.",
            definitionNative = "Очень сильный или тяжёлый, требующий многих усилий за короткое время.",
            example = "A short intense run burns more fat than a long slow walk.",
            exampleNative = "Короткий intense бег жжёт больше жира, чем долгая прогулка.",
            pos = "adjective", semanticGroup = "fitness_routines"),

        WordEntity(id = 34625, setId = 346, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "posture", transliteration = "[ˈpɒsʧər]", translation = "осанка",
            definition = "The way you hold your back and shoulders when sitting or standing.",
            definitionNative = "Как человек держит спину и плечи, когда сидит или стоит.",
            example = "Good posture during a deadlift saves the lower back.",
            exampleNative = "Правильная posture при становой тяге бережёт поясницу.",
            pos = "noun", semanticGroup = "fitness_routines", fillInBlankExclusions = listOf(34613L, 34621L, 34622L, 34623L)),

        // ════════════════════════════════════════════════════════════════════
        //  SET 347 — L3 — Здоровье и фитнес (RARE + EPIC)
        // ════════════════════════════════════════════════════════════════════

        // ── health_adv_training (5) ───────────────────────────────────────────

        WordEntity(id = 34701, setId = 347, languagePair = "en-ru", rarity = "RARE",
            original = "hypertrophy", transliteration = "[haɪˈpɜːrtrəfi]", translation = "гипертрофия (рост мышц)",
            definition = "The growth of muscle fibres in size after heavy training and food.",
            definitionNative = "Рост мышечных волокон в объёме после тяжёлых тренировок и питания.",
            example = "Eight reps per set is the classic range for hypertrophy.",
            exampleNative = "Восемь повторов в подходе — классика для hypertrophy.",
            pos = "noun", semanticGroup = "health_adv_training", fillInBlankExclusions = listOf(34704L, 34705L, 34716L, 34717L)),

        WordEntity(id = 34702, setId = 347, languagePair = "en-ru", rarity = "EPIC",
            original = "plyometric", transliteration = "[ˌplaɪəˈmetrɪk]", translation = "плиометрический (взрывной)",
            definition = "Tied to fast jumping moves that make the muscles snap with explosive power.",
            definitionNative = "Связанный с быстрыми прыжковыми движениями, развивающими взрывную силу.",
            example = "A plyometric box jump trains the legs to react fast.",
            exampleNative = "Plyometric запрыгивание на тумбу учит ноги взрываться быстро.",
            pos = "adjective", semanticGroup = "health_adv_training"),

        WordEntity(id = 34703, setId = 347, languagePair = "en-ru", rarity = "EPIC",
            original = "isometric", transliteration = "[ˌaɪsəˈmetrɪk]", translation = "изометрический (статический)",
            definition = "Done by holding a still pose under load instead of moving the body.",
            definitionNative = "Выполняемый с удержанием статичной позы под нагрузкой, без движения.",
            example = "An isometric wall sit tests the patience of the thighs.",
            exampleNative = "Isometric присед у стены проверяет терпение бёдер.",
            pos = "adjective", semanticGroup = "health_adv_training", fillInBlankExclusions = listOf(34706L)),

        WordEntity(id = 34704, setId = 347, languagePair = "en-ru", rarity = "RARE",
            original = "periodization", transliteration = "[ˌpɪərɪədaɪˈzeɪʃən]", translation = "периодизация (планирование тренировок)",
            definition = "Splitting a long plan into phases of different load to keep gains coming.",
            definitionNative = "Деление долгого плана на фазы разной нагрузки, чтобы прогресс не стопорился.",
            example = "Smart periodization avoids burnout before a big race.",
            exampleNative = "Умная periodization защищает от выгорания перед крупными стартами.",
            pos = "noun", semanticGroup = "health_adv_training", fillInBlankExclusions = listOf(34701L, 34705L, 34708L, 34724L)),

        WordEntity(id = 34705, setId = 347, languagePair = "en-ru", rarity = "RARE",
            original = "deadlift", transliteration = "[ˈdedlɪft]", translation = "становая тяга",
            definition = "A core barbell move: lift a loaded bar from the floor up to the hips.",
            definitionNative = "Базовое упражнение со штангой: поднять снаряд с пола до бёдер.",
            example = "A heavy deadlift builds the back and the whole body.",
            exampleNative = "Тяжёлый deadlift строит спину и всё тело сразу.",
            pos = "noun", semanticGroup = "health_adv_training", fillInBlankExclusions = listOf(34701L, 34704L, 34717L)),

        // ── health_adv_systems (5) ────────────────────────────────────────────

        WordEntity(id = 34706, setId = 347, languagePair = "en-ru", rarity = "RARE",
            original = "anaerobic", transliteration = "[ˌænəˈroʊbɪk]", translation = "анаэробный (без кислорода)",
            definition = "Tied to short, hard effort the muscles fuel without using oxygen.",
            definitionNative = "Связанный с короткой тяжёлой нагрузкой, идущей в мышцах без кислорода.",
            example = "A heavy lift is anaerobic — it lasts only a few seconds.",
            exampleNative = "Тяжёлый подъём — anaerobic, длится лишь пару секунд.",
            pos = "adjective", semanticGroup = "health_adv_systems", fillInBlankExclusions = listOf(34712L, 34713L)),

        WordEntity(id = 34707, setId = 347, languagePair = "en-ru", rarity = "EPIC",
            original = "calisthenics", transliteration = "[ˌkæləsˈθenɪks]", translation = "калистеника (тренировка с весом тела)",
            definition = "A method that trains the body using only its own weight on bars and floor.",
            definitionNative = "Метод тренировки телом без снарядов — только турник, брусья и пол.",
            example = "Pull-ups and dips are core calisthenics moves.",
            exampleNative = "Подтягивания и брусья — основные движения calisthenics.",
            pos = "noun", semanticGroup = "health_adv_systems", fillInBlankExclusions = listOf(34701L, 34702L, 34703L, 34706L, 34708L, 34709L, 34710L, 34716L, 34717L)),

        WordEntity(id = 34708, setId = 347, languagePair = "en-ru", rarity = "RARE",
            original = "HIIT", transliteration = "[hɪt]", translation = "ВИИТ (высокоинтенсивный интервальный тренинг)",
            definition = "Short hard bursts of effort with brief breaks, repeated several times.",
            definitionNative = "Короткие тяжёлые усилия с краткими паузами, повторяемые несколько раз.",
            example = "A twenty-minute HIIT session burns a lot of fat.",
            exampleNative = "Двадцатиминутный HIIT сжигает много жира.",
            pos = "noun", semanticGroup = "health_adv_systems", fillInBlankExclusions = listOf(34701L, 34702L, 34705L, 34706L, 34707L, 34709L, 34710L, 34717L, 34724L)),

        WordEntity(id = 34709, setId = 347, languagePair = "en-ru", rarity = "RARE",
            original = "BMR", transliteration = "[ˌbiːemˈɑːr]", translation = "БМР (базальный метаболизм)",
            definition = "How many calories the body burns at full rest just to keep you alive.",
            definitionNative = "Сколько калорий тело тратит в полном покое только на поддержание жизни.",
            example = "A higher BMR makes weight loss easier for some.",
            exampleNative = "Высокий BMR облегчает похудение для некоторых.",
            pos = "noun", semanticGroup = "health_adv_systems", fillInBlankExclusions = listOf(34707L, 34708L, 34710L)),

        WordEntity(id = 34710, setId = 347, languagePair = "en-ru", rarity = "RARE",
            original = "mobility", transliteration = "[moʊˈbɪləti]", translation = "мобильность (свобода движения)",
            definition = "How freely a joint can move through its full range under control.",
            definitionNative = "Насколько свободно сустав движется во всём диапазоне с контролем.",
            example = "Hip mobility helps a lifter sit deep into a squat.",
            exampleNative = "Mobility таза помогает атлету садиться глубоко в присед.",
            pos = "noun", semanticGroup = "health_adv_systems", fillInBlankExclusions = listOf(34707L, 34708L, 34709L, 34716L, 34721L, 34723L)),

        // ── health_adv_nutrition (5) ──────────────────────────────────────────

        WordEntity(id = 34711, setId = 347, languagePair = "en-ru", rarity = "RARE",
            original = "macros", transliteration = "[ˈmækroʊz]", translation = "макронутриенты (БЖУ)",
            definition = "The big three nutrients counted by athletes: protein, carbs and fat.",
            definitionNative = "Три главных нутриента, которые считают атлеты: белки, углеводы и жиры.",
            example = "She tracks her macros to plan every meal of the day.",
            exampleNative = "Она считает свои macros, чтобы спланировать каждый приём пищи.",
            pos = "noun", semanticGroup = "health_adv_nutrition", fillInBlankExclusions = listOf(34709L, 34714L, 34715L)),

        WordEntity(id = 34712, setId = 347, languagePair = "en-ru", rarity = "EPIC",
            original = "anabolic", transliteration = "[ˌænəˈbɒlɪk]", translation = "анаболический (наращивающий)",
            definition = "Tied to body chemistry that builds new tissue from food and rest.",
            definitionNative = "Связанный с биохимией тела, строящей новые ткани из еды и отдыха.",
            example = "Sleep places the body in a deeply anabolic state.",
            exampleNative = "Сон переводит тело в глубоко anabolic состояние.",
            pos = "adjective", semanticGroup = "health_adv_nutrition", fillInBlankExclusions = listOf(34706L, 34713L)),

        WordEntity(id = 34713, setId = 347, languagePair = "en-ru", rarity = "EPIC",
            original = "catabolic", transliteration = "[ˌkætəˈbɒlɪk]", translation = "катаболический (разрушающий)",
            definition = "Tied to body chemistry that breaks tissue down to release energy.",
            definitionNative = "Связанный с биохимией тела, разрушающей ткани ради высвобождения энергии.",
            example = "Long fasting puts the body into a catabolic phase.",
            exampleNative = "Долгое голодание вводит тело в catabolic фазу.",
            pos = "adjective", semanticGroup = "health_adv_nutrition"),

        WordEntity(id = 34714, setId = 347, languagePair = "en-ru", rarity = "RARE",
            original = "glycogen", transliteration = "[ˈɡlaɪkəʤən]", translation = "гликоген (запас углеводов)",
            definition = "A form of sugar stored in the muscles and liver for fast use.",
            definitionNative = "Форма сахара, запасённая в мышцах и печени для быстрого использования.",
            example = "Heavy training quickly uses up the muscle glycogen.",
            exampleNative = "Тяжёлая тренировка быстро тратит мышечный glycogen.",
            pos = "noun", semanticGroup = "health_adv_nutrition", fillInBlankExclusions = listOf(34711L, 34715L)),

        WordEntity(id = 34715, setId = 347, languagePair = "en-ru", rarity = "RARE",
            original = "electrolyte", transliteration = "[ɪˈlektrəlaɪt]", translation = "электролит",
            definition = "A salt in the blood that helps muscles fire and the heart beat steady.",
            definitionNative = "Соль в крови, помогающая мышцам сокращаться, а сердцу биться ровно.",
            example = "An electrolyte drink stops cramps on a hot run.",
            exampleNative = "Electrolyte напиток снимает судороги в жаркой пробежке.",
            pos = "noun", semanticGroup = "health_adv_nutrition", fillInBlankExclusions = listOf(34712L)),

        // ── health_adv_movement (5) ───────────────────────────────────────────

        WordEntity(id = 34716, setId = 347, languagePair = "en-ru", rarity = "RARE",
            original = "isolation", transliteration = "[ˌaɪsəˈleɪʃən]", translation = "изолирующее упражнение",
            definition = "A move that loads only one muscle while the rest of the body stays still.",
            definitionNative = "Упражнение, нагружающее только одну мышцу, пока остальное тело неподвижно.",
            example = "A bicep curl is a classic isolation exercise.",
            exampleNative = "Сгибание на бицепс — классическое isolation упражнение.",
            pos = "noun", semanticGroup = "health_adv_movement", fillInBlankExclusions = listOf(34701L, 34702L, 34703L, 34706L, 34707L, 34708L, 34710L, 34717L, 34718L, 34719L, 34720L, 34724L)),

        WordEntity(id = 34717, setId = 347, languagePair = "en-ru", rarity = "RARE",
            original = "compound", transliteration = "[ˈkɒmpaʊnd]", translation = "многосуставное упражнение",
            definition = "A move that loads many joints and muscle groups at the same time.",
            definitionNative = "Упражнение, нагружающее сразу несколько суставов и групп мышц.",
            example = "The squat is the king of compound movements.",
            exampleNative = "Присед — король compound движений.",
            pos = "noun", semanticGroup = "health_adv_movement", fillInBlankExclusions = listOf(34701L, 34702L, 34703L, 34706L, 34707L, 34708L, 34710L, 34716L, 34718L, 34719L, 34720L, 34721L)),

        WordEntity(id = 34718, setId = 347, languagePair = "en-ru", rarity = "RARE",
            original = "plateau", transliteration = "[plæˈtoʊ]", translation = "плато (застой в прогрессе)",
            definition = "A long stretch when the body stops getting stronger no matter what.",
            definitionNative = "Долгий отрезок, когда тело перестаёт прогрессировать, что бы ни делал.",
            example = "He hit a plateau after six months of the same plan.",
            exampleNative = "Он упёрся в plateau после полугода одного плана.",
            pos = "noun", semanticGroup = "health_adv_movement", fillInBlankExclusions = listOf(34717L, 34720L)),

        WordEntity(id = 34719, setId = 347, languagePair = "en-ru", rarity = "RARE",
            original = "overtraining", transliteration = "[ˌoʊvərˈtreɪnɪŋ]", translation = "перетренированность",
            definition = "A worn-down state from too much load and too little rest over weeks.",
            definitionNative = "Истощённое состояние от чрезмерной нагрузки и нехватки отдыха неделями.",
            example = "Constant fatigue and bad sleep are signs of overtraining.",
            exampleNative = "Постоянная усталость и плохой сон — признаки overtraining.",
            pos = "noun", semanticGroup = "health_adv_movement", fillInBlankExclusions = listOf(34716L, 34717L, 34718L, 34720L)),

        WordEntity(id = 34720, setId = 347, languagePair = "en-ru", rarity = "RARE",
            original = "foam-roller", transliteration = "[foʊm ˈroʊlər]", translation = "массажный ролик (фоам-роллер)",
            definition = "A firm tube of foam used to roll out tight spots in the muscles.",
            definitionNative = "Плотный пенный цилиндр для прокатывания зажатых участков мышц.",
            example = "Five minutes on the foam-roller eased the back pain.",
            exampleNative = "Пять минут на foam-roller сняли боль в спине.",
            pos = "noun", semanticGroup = "health_adv_movement", fillInBlankExclusions = listOf(34716L, 34717L, 34718L, 34719L)),

        // ── health_adv_science (5) ────────────────────────────────────────────

        WordEntity(id = 34721, setId = 347, languagePair = "en-ru", rarity = "EPIC",
            original = "proprioception", transliteration = "[ˌproʊprioʊˈsepʃən]", translation = "проприоцепция (чувство тела)",
            definition = "The inner sense that tells the brain where every limb is right now.",
            definitionNative = "Внутреннее чувство, сообщающее мозгу, где сейчас каждая часть тела.",
            example = "Balance drills sharpen proprioception in the ankles.",
            exampleNative = "Упражнения на баланс обостряют proprioception в лодыжках.",
            pos = "noun", semanticGroup = "health_adv_science", fillInBlankExclusions = listOf(34710L, 34722L, 34723L, 34724L, 34725L)),

        WordEntity(id = 34722, setId = 347, languagePair = "en-ru", rarity = "EPIC",
            original = "kinesiology", transliteration = "[kɪˌniːsiˈɒləʤi]", translation = "кинезиология (наука о движении)",
            definition = "The study of how the human body moves and how the joints work.",
            definitionNative = "Наука о том, как движется человеческое тело и работают суставы.",
            example = "She studied kinesiology to become a sports therapist.",
            exampleNative = "Она училась kinesiology, чтобы стать спортивным терапевтом.",
            pos = "noun", semanticGroup = "health_adv_science", fillInBlankExclusions = listOf(34721L, 34723L, 34724L, 34725L)),

        WordEntity(id = 34723, setId = 347, languagePair = "en-ru", rarity = "EPIC",
            original = "biomechanics", transliteration = "[ˌbaɪoʊmɪˈkænɪks]", translation = "биомеханика",
            definition = "The study of forces inside the body during sport and daily moves.",
            definitionNative = "Наука о силах внутри тела во время спорта и обычных движений.",
            example = "Modern biomechanics explains why some lifters get hurt.",
            exampleNative = "Современная biomechanics объясняет, почему некоторые атлеты травмируются.",
            pos = "noun", semanticGroup = "health_adv_science", fillInBlankExclusions = listOf(34704L, 34721L, 34722L, 34724L, 34725L)),

        WordEntity(id = 34724, setId = 347, languagePair = "en-ru", rarity = "EPIC",
            original = "circuit-training", transliteration = "[ˈsɜːrkɪt ˈtreɪnɪŋ]", translation = "круговая тренировка",
            definition = "A session that moves fast from one station to the next with little rest.",
            definitionNative = "Тренировка с быстрым переходом от одной станции к другой почти без отдыха.",
            example = "Her circuit-training class hits ten exercises in a row.",
            exampleNative = "Её занятие circuit-training включает десять упражнений подряд.",
            pos = "noun", semanticGroup = "health_adv_science", fillInBlankExclusions = listOf(34701L, 34702L, 34706L, 34707L, 34708L, 34710L, 34721L, 34722L, 34723L, 34725L)),

        WordEntity(id = 34725, setId = 347, languagePair = "en-ru", rarity = "EPIC",
            original = "lactate", transliteration = "[ˈlækteɪt]", translation = "лактат (молочная кислота)",
            definition = "A substance that builds up in muscles during very hard short effort.",
            definitionNative = "Вещество, накапливающееся в мышцах при очень тяжёлой короткой нагрузке.",
            example = "High lactate during a sprint causes the burning leg pain.",
            exampleNative = "Высокий lactate в спринте вызывает жгучую боль в ногах.",
            pos = "noun", semanticGroup = "health_adv_science", fillInBlankExclusions = listOf(34721L, 34722L, 34723L, 34724L)),
    )
}
