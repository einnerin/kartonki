package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary: AI и ML, level 1 (1 set, 25 words).
 * Базовая лексика искусственного интеллекта и машинного обучения для уровня
 * A1-A2/B1: основные понятия (data, model, algorithm), действия (learn,
 * training, generate), интерфейс (chatbot, prompt) и системы (computer, robot).
 *
 * Set 415 — основы темы AI и ML на английском.
 * Распределение редкостей: 12 COMMON + 13 UNCOMMON.
 *
 * Шесть подгрупп по 3-5 слов:
 *   ai_ml_data         — что подаётся на вход (data, number, word, picture)
 *   ai_ml_models       — структурные элементы (model, algorithm, neural, network)
 *   ai_ml_actions      — что делает система (learn, training, classify, ...)
 *   ai_ml_metrics      — измерение и разметка (accuracy, feature, label)
 *   ai_ml_interaction  — общение с моделью (AI, chatbot, prompt, answer)
 *   ai_ml_systems      — устройства и проверка (smart, computer, robot, ...)
 */
object WordDataEnglishAiMlL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 415,
            languagePair = "en-ru",
            orderIndex = 415,
            name = "AI и ML",
            description = "Базовая лексика ИИ: данные, модели, обучение, чат-боты",
            topic = "AI и ML",
            level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 415 — AI и ML: основы (L1, COMMON+UNCOMMON)                  ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── ai_ml_data (4) ────────────────────────────────────────────────

        WordEntity(id = 41501, setId = 415, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "data", transliteration = "[ˈdeɪtə]", translation = "данные",
            definition = "Information that a computer collects, stores or processes.",
            definitionNative = "Информация, которую компьютер собирает, хранит или обрабатывает.",
            example = "Companies collect data from users to improve their services.",
            exampleNative = "Компании собирают data от пользователей для улучшения сервиса.",
            pos = "noun", semanticGroup = "ai_ml_data"),

        WordEntity(id = 41502, setId = 415, languagePair = "en-ru", rarity = "COMMON",
            original = "number", transliteration = "[ˈnʌmbər]", translation = "число",
            definition = "A symbol or word that shows how many things there are.",
            definitionNative = "Знак или слово, что показывает, сколько чего-то есть.",
            example = "Each photo has a number that helps sort it correctly.",
            exampleNative = "У каждой фотографии есть number, который помогает сортировать их.",
            pos = "noun", semanticGroup = "ai_ml_data"),

        WordEntity(id = 41503, setId = 415, languagePair = "en-ru", rarity = "COMMON",
            original = "word", transliteration = "[wɜːrd]", translation = "слово",
            definition = "A unit of language with meaning, made of letters or sounds.",
            definitionNative = "Единица языка со значением — из букв или звуков.",
            example = "We can read each word out loud while studying together.",
            exampleNative = "Каждое word можно читать вслух, когда занимаемся вместе.",
            pos = "noun", semanticGroup = "ai_ml_data"),

        WordEntity(id = 41504, setId = 415, languagePair = "en-ru", rarity = "COMMON",
            original = "picture", transliteration = "[ˈpɪktʃər]", translation = "картинка, изображение",
            definition = "A drawing, painting or photo that shows something visual.",
            definitionNative = "Зримый образ на бумаге или экране — рисунок или фотография.",
            example = "She uploaded a picture of her dog to social media.",
            exampleNative = "Она загрузила picture своей собаки в соцсети.",
            pos = "noun", semanticGroup = "ai_ml_data"),

        // ── ai_ml_models (4) ──────────────────────────────────────────────

        WordEntity(id = 41505, setId = 415, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "model", transliteration = "[ˈmɒdl]", translation = "модель (нейросеть)",
            definition = "A program trained on examples that gives replies or makes decisions.",
            definitionNative = "Программа, обученная на примерах — даёт ответы или принимает решения.",
            example = "A new model can write a short song from your idea.",
            exampleNative = "Новая model может написать короткую песню по твоей идее.",
            pos = "noun", semanticGroup = "ai_ml_models"),

        WordEntity(id = 41506, setId = 415, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "algorithm", transliteration = "[ˈælɡərɪðəm]", translation = "алгоритм",
            definition = "A step-by-step recipe a computer follows to solve a problem.",
            definitionNative = "Пошаговый рецепт, по которому компьютер решает задачу.",
            example = "This algorithm sorts photos by date in less than a second.",
            exampleNative = "Этот algorithm сортирует фотографии по дате меньше чем за секунду.",
            pos = "noun", semanticGroup = "ai_ml_models"),

        WordEntity(id = 41507, setId = 415, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "neural", transliteration = "[ˈnʊərəl]", translation = "нейронный",
            definition = "Connected to brain cells or to software that imitates them.",
            definitionNative = "Связанный с клетками мозга или с программой, что их имитирует.",
            example = "Most modern translation tools rely on a neural design inside.",
            exampleNative = "Большинство современных переводчиков работают на neural устройстве.",
            pos = "adjective", semanticGroup = "ai_ml_models"),

        WordEntity(id = 41508, setId = 415, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "network", transliteration = "[ˈnetwɜːrk]", translation = "сеть (нейросеть)",
            definition = "A group of items connected together — like brain cells or computers.",
            definitionNative = "Группа связанных элементов — клеток мозга или машин.",
            example = "A deep network with many layers can recognize faces well.",
            exampleNative = "Глубокая network со множеством слоёв хорошо распознаёт лица.",
            pos = "noun", semanticGroup = "ai_ml_models"),

        // ── ai_ml_actions (5) ─────────────────────────────────────────────

        WordEntity(id = 41509, setId = 415, languagePair = "en-ru", rarity = "COMMON",
            original = "learn", transliteration = "[lɜːrn]", translation = "учить, учиться",
            definition = "To get new knowledge or skills by reading, watching or trying.",
            definitionNative = "Получать новые знания или навыки — через чтение, наблюдение или практику.",
            example = "Children learn faster when lessons are short and fun.",
            exampleNative = "Дети learn быстрее, когда уроки короткие и весёлые.",
            pos = "verb", semanticGroup = "ai_ml_actions"),

        WordEntity(id = 41510, setId = 415, languagePair = "en-ru", rarity = "COMMON",
            original = "training", transliteration = "[ˈtreɪnɪŋ]", translation = "обучение модели",
            definition = "The long process of showing examples to a system so it improves.",
            definitionNative = "Долгий процесс показа примеров системе, чтобы она стала лучше.",
            example = "The training process took two weeks on the new servers.",
            exampleNative = "training заняло две недели на новых серверах.",
            pos = "noun", semanticGroup = "ai_ml_actions"),

        WordEntity(id = 41511, setId = 415, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "classify", transliteration = "[ˈklæsɪfaɪ]", translation = "классифицировать",
            definition = "To put items into groups by their type or category.",
            definitionNative = "Раскладывать предметы по группам — по типу или категории.",
            example = "Email apps classify messages as spam or important automatically.",
            exampleNative = "Почтовые приложения classify письма как спам или важные.",
            pos = "verb", semanticGroup = "ai_ml_actions"),

        WordEntity(id = 41512, setId = 415, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "generate", transliteration = "[ˈdʒenəreɪt]", translation = "генерировать (создавать)",
            definition = "To create something new, like text, music or pictures.",
            definitionNative = "Создавать что-то новое — текст, музыку или картинки.",
            example = "The app can generate twenty short summaries in one minute.",
            exampleNative = "Приложение может generate двадцать коротких пересказов за минуту.",
            pos = "verb", semanticGroup = "ai_ml_actions"),

        WordEntity(id = 41513, setId = 415, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "prediction", transliteration = "[prɪˈdɪkʃən]", translation = "предсказание (модели)",
            definition = "A guess about what will happen, based on examples we already have.",
            definitionNative = "Догадка о будущем — на основе примеров, что у нас уже есть.",
            example = "The weather prediction for tomorrow says rain in the morning.",
            exampleNative = "prediction погоды на завтра — дождь утром.",
            pos = "noun", semanticGroup = "ai_ml_actions"),

        // ── ai_ml_metrics (3) ─────────────────────────────────────────────

        WordEntity(id = 41514, setId = 415, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "accuracy", transliteration = "[ˈækjərəsi]", translation = "точность (метрика)",
            definition = "How close to the correct result something turns out to be.",
            definitionNative = "Насколько результат близок к правильному значению.",
            example = "The doctor's app reaches very high accuracy on chest X-rays.",
            exampleNative = "Приложение врача достигает очень высокой accuracy на снимках лёгких.",
            pos = "noun", semanticGroup = "ai_ml_metrics"),

        WordEntity(id = 41515, setId = 415, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "feature", transliteration = "[ˈfiːtʃər]", translation = "признак (в данных)",
            definition = "A small detail that the system uses to make a decision.",
            definitionNative = "Небольшая деталь, которую система использует для принятия решения.",
            example = "Color is an important feature when sorting fruits by quality.",
            exampleNative = "Цвет — важный feature при сортировке фруктов по качеству.",
            pos = "noun", semanticGroup = "ai_ml_metrics"),

        WordEntity(id = 41516, setId = 415, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "label", transliteration = "[ˈleɪbl]", translation = "метка (для обучения)",
            definition = "A short tag people put on examples so the system knows what they are.",
            definitionNative = "Короткий ярлык, который ставят на примеры, чтобы система их поняла.",
            example = "A vet writes a clear label on each medicine bottle.",
            exampleNative = "Ветеринар пишет чёткий label на каждом флаконе лекарства.",
            pos = "noun", semanticGroup = "ai_ml_metrics"),

        // ── ai_ml_interaction (4) ─────────────────────────────────────────

        WordEntity(id = 41517, setId = 415, languagePair = "en-ru", rarity = "COMMON",
            original = "AI", transliteration = "[eɪ aɪ]", translation = "ИИ (искусственный интеллект)",
            definition = "A computer system that learns from examples and replies like a person.",
            definitionNative = "Компьютерная система, которая учится на примерах и отвечает как человек.",
            example = "Many companies use AI to write code and emails faster.",
            exampleNative = "Многие компании используют AI, чтобы писать код и письма быстрее.",
            pos = "noun", semanticGroup = "ai_ml_interaction"),

        WordEntity(id = 41518, setId = 415, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "chatbot", transliteration = "[ˈtʃætbɒt]", translation = "чат-бот",
            definition = "A program that talks with people through short text messages.",
            definitionNative = "Программа, которая общается с людьми короткими текстовыми сообщениями.",
            example = "Our shop has a chatbot that helps people late at night.",
            exampleNative = "В нашем магазине есть chatbot, что помогает людям поздно ночью.",
            pos = "noun", semanticGroup = "ai_ml_interaction"),

        WordEntity(id = 41519, setId = 415, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "prompt", transliteration = "[prɒmpt]", translation = "промпт (запрос к модели)",
            definition = "The text or question you write to a chatbot to get a reply.",
            definitionNative = "Текст или вопрос, которые пишут чат-боту, чтобы получить ответ.",
            example = "A clear prompt usually gives a much better reply.",
            exampleNative = "Чёткий prompt обычно даёт ответ получше.",
            pos = "noun", semanticGroup = "ai_ml_interaction"),

        WordEntity(id = 41520, setId = 415, languagePair = "en-ru", rarity = "COMMON",
            original = "answer", transliteration = "[ˈɑːnsər]", translation = "ответ",
            definition = "The reply someone gives to a question or problem.",
            definitionNative = "Реплика, которую кто-то даёт на вопрос или задачу.",
            example = "I read the answer slowly to make sure it's correct.",
            exampleNative = "Я медленно прочитал answer, чтобы убедиться в правильности.",
            pos = "noun", semanticGroup = "ai_ml_interaction"),

        // ── ai_ml_systems (5) ─────────────────────────────────────────────

        WordEntity(id = 41521, setId = 415, languagePair = "en-ru", rarity = "COMMON",
            original = "smart", transliteration = "[smɑːrt]", translation = "умный",
            definition = "Able to think and solve problems quickly, like a clever person.",
            definitionNative = "Способный быстро думать и решать задачи — как сообразительный человек.",
            example = "My new phone is smart enough to translate signs in real time.",
            exampleNative = "Мой новый телефон smart настолько, что переводит вывески мгновенно.",
            pos = "adjective", semanticGroup = "ai_ml_systems"),

        WordEntity(id = 41522, setId = 415, languagePair = "en-ru", rarity = "COMMON",
            original = "computer", transliteration = "[kəmˈpjuːtər]", translation = "компьютер",
            definition = "An electronic device that runs programs and stores files.",
            definitionNative = "Электронное устройство, что запускает программы и хранит файлы.",
            example = "My old computer cannot run heavy graphics anymore.",
            exampleNative = "Мой старый computer уже не справляется с тяжёлой графикой.",
            pos = "noun", semanticGroup = "ai_ml_systems"),

        WordEntity(id = 41523, setId = 415, languagePair = "en-ru", rarity = "COMMON",
            original = "robot", transliteration = "[ˈroʊbɒt]", translation = "робот",
            definition = "A device built to do work like a person, often automatic.",
            definitionNative = "Устройство, что делает работу за человека — обычно автоматически.",
            example = "The factory uses a robot to paint each car door.",
            exampleNative = "Завод использует robot, чтобы красить каждую дверь автомобиля.",
            pos = "noun", semanticGroup = "ai_ml_systems"),

        WordEntity(id = 41524, setId = 415, languagePair = "en-ru", rarity = "COMMON",
            original = "machine", transliteration = "[məˈʃiːn]", translation = "машина (механизм)",
            definition = "A device with moving parts that helps people do work.",
            definitionNative = "Устройство с движущимися частями, помогающее людям выполнять работу.",
            example = "This old machine has been working in the kitchen for years.",
            exampleNative = "Эта старая machine работает на кухне уже много лет.",
            pos = "noun", semanticGroup = "ai_ml_systems"),

        WordEntity(id = 41525, setId = 415, languagePair = "en-ru", rarity = "COMMON",
            original = "test", transliteration = "[test]", translation = "тест, проверка",
            definition = "A short check that shows if something works the right way.",
            definitionNative = "Короткое испытание — посмотреть, работает ли что-то правильно.",
            example = "I ran a quick test on the homework before submitting it.",
            exampleNative = "Я быстро прошёл test домашки перед её отправкой.",
            pos = "noun", semanticGroup = "ai_ml_systems"),
    )
}
