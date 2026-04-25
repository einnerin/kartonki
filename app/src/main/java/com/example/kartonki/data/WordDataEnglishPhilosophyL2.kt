package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Философия (level 2, продвинутый).
 *
 * Set 342: «Философия» — продвинутая лексика философских разговоров:
 * этика и мораль, концепты сознания, базовые течения мысли, моральные дилеммы.
 *
 * Распределение редкости: 20 UNCOMMON + 5 RARE — два смежных уровня шкалы;
 * UNCOMMON преобладает (level 2 = продвинутый, A2-B1).
 *
 * Дополняет уже существующие сеты темы «Философия»:
 *   - Set 87  (WordDataEnglish.kt + WordDataEnglishExpanded.kt) — L3 UNCOMMON/RARE,
 *     логика и аргументация (fallacy, syllogism, ad hominem, ...).
 *   - Set 258 (WordDataEnglishBatch5.kt)                       — L4 RARE/EPIC,
 *     профессиональная философия (ontology, deontology, hermeneutics, ...).
 *   - Set 83  (WordDataEnglish.kt)                             — L5 EPIC/LEGENDARY,
 *     "Влияние, рост и изменения" (burgeon, proliferate, ramify, ...).
 *
 * Параллельный сет уровня 1 — set 341 — берёт на себя A1: truth, lie, life,
 * death, mind, heart, soul, dream — поэтому в L2 эти слова не использованы.
 *
 * SemanticGroups (5 × 5):
 *   philosophy_ethics          — morality, justice, duty, dignity, conscience
 *   philosophy_consciousness   — logic, wisdom, awareness, identity, purpose
 *   philosophy_directions      — religion, faith, freedom, equality, belief
 *   philosophy_reasoning       — reflect, interpret, ponder, debate, analyze
 *   philosophy_concepts        — meaning, value, ignorance, integrity, honesty
 *
 * Word IDs: 34201..34225 (setId × 100 + position).
 */
object WordDataEnglishPhilosophyL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 342, name = "Философия",
            description = "Продвинутая лексика философских разговоров: этические вопросы, базовые направления мысли, моральные дилеммы",
            languagePair = "en-ru",
            topic = "Философия", level = 2),
    )

    val words: List<WordEntity> = listOf(

        // ── philosophy_ethics (5) ─────────────────────────────────────────

        WordEntity(id = 34201, setId = 342, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "morality", transliteration = "[məˈræləti]", translation = "мораль / нравственность",
            definition = "A set of ideas about what is right or wrong in how people behave.",
            definitionNative = "Совокупность представлений о правильном и неправильном в поведении людей.",
            example = "Different cultures often hold different ideas about morality.",
            exampleNative = "В разных культурах часто различаются представления о morality.",
            pos = "noun", semanticGroup = "philosophy_ethics", fillInBlankExclusions = listOf(34202L, 34203L, 34204L, 34205L, 34206L, 34207L, 34208L, 34209L, 34210L, 34211L, 34212L, 34213L, 34214L, 34215L, 34219L, 34221L, 34222L, 34223L, 34224L, 34225L)),

        WordEntity(id = 34202, setId = 342, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "justice", transliteration = "[ˈʤʌstɪs]", translation = "правосудие / справедливость",
            definition = "Fair treatment based on laws and the idea of giving each person their due.",
            definitionNative = "Справедливое обращение по закону — каждому воздаётся то, что он заслужил.",
            example = "She fought all her life for justice for ordinary working people.",
            exampleNative = "Всю жизнь она боролась за justice для простых рабочих людей.",
            pos = "noun", semanticGroup = "philosophy_ethics", fillInBlankExclusions = listOf(34201L, 34203L, 34204L, 34205L, 34208L, 34209L, 34211L, 34213L, 34214L)),

        WordEntity(id = 34203, setId = 342, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "duty", transliteration = "[ˈdjuːti]", translation = "долг / обязанность",
            definition = "Something you feel you must do because of your role or moral rules.",
            definitionNative = "То, что человек чувствует обязанным сделать в силу роли или моральных норм.",
            example = "He saw it as his duty to care for his elderly parents.",
            exampleNative = "Он считал своим duty заботиться о пожилых родителях.",
            pos = "noun", semanticGroup = "philosophy_ethics", fillInBlankExclusions = listOf(34201L, 34202L, 34204L, 34205L, 34210L)),

        WordEntity(id = 34204, setId = 342, languagePair = "en-ru", rarity = "RARE",
            original = "dignity", transliteration = "[ˈdɪɡnəti]", translation = "достоинство",
            definition = "The quality of being worthy of respect — by yourself and by others.",
            definitionNative = "Свойство быть достойным уважения — и в собственных глазах, и в чужих.",
            example = "Even in poverty he carried himself with quiet dignity.",
            exampleNative = "Даже в бедности он держался с тихим dignity.",
            pos = "noun", semanticGroup = "philosophy_ethics", fillInBlankExclusions = listOf(34201L, 34202L, 34203L, 34205L, 34206L, 34207L, 34208L, 34210L, 34212L, 34215L, 34224L, 34225L)),

        WordEntity(id = 34205, setId = 342, languagePair = "en-ru", rarity = "RARE",
            original = "conscience", transliteration = "[ˈkɒnʃəns]", translation = "совесть",
            definition = "The inner voice that tells you whether your actions are right or wrong.",
            definitionNative = "Внутренний голос, подсказывающий, хорошо ли или плохо то, что ты делаешь.",
            example = "His conscience would not let him keep the lost wallet.",
            exampleNative = "Его conscience не позволила оставить найденный кошелёк себе.",
            pos = "noun", semanticGroup = "philosophy_ethics", fillInBlankExclusions = listOf(34201L, 34202L, 34203L, 34204L, 34212L, 34215L, 34224L, 34225L)),

        // ── philosophy_consciousness (5) ──────────────────────────────────

        WordEntity(id = 34206, setId = 342, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "logic", transliteration = "[ˈlɒʤɪk]", translation = "логика",
            definition = "An orderly way of thinking where each step follows from the last.",
            definitionNative = "Стройный способ мыслить, где каждый шаг вытекает из предыдущего.",
            example = "Her argument followed strict logic from start to finish.",
            exampleNative = "Её рассуждение от начала и до конца следовало строгой logic.",
            pos = "noun", semanticGroup = "philosophy_consciousness", fillInBlankExclusions = listOf(34207L, 34208L, 34209L, 34210L)),

        WordEntity(id = 34207, setId = 342, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "wisdom", transliteration = "[ˈwɪzdəm]", translation = "мудрость",
            definition = "Deep understanding of life that comes from experience and clear thinking.",
            definitionNative = "Глубокое понимание жизни, добытое опытом и ясным размышлением.",
            example = "The old teacher shared his wisdom with younger colleagues.",
            exampleNative = "Старый учитель делился своей wisdom с молодыми коллегами.",
            pos = "noun", semanticGroup = "philosophy_consciousness", fillInBlankExclusions = listOf(34206L, 34208L, 34209L, 34210L, 34212L, 34215L)),

        WordEntity(id = 34208, setId = 342, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "awareness", transliteration = "[əˈweənəs]", translation = "осознание / понимание",
            definition = "The state of noticing something and understanding what it means for you.",
            definitionNative = "Состояние, в котором ты замечаешь нечто и понимаешь его значение для себя.",
            example = "Meditation slowly grew his awareness of his own emotions.",
            exampleNative = "Медитация постепенно усиливала его awareness собственных эмоций.",
            pos = "noun", semanticGroup = "philosophy_consciousness", fillInBlankExclusions = listOf(34206L, 34207L, 34209L, 34210L, 34223L)),

        WordEntity(id = 34209, setId = 342, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "identity", transliteration = "[aɪˈdɛntəti]", translation = "личность / самобытность",
            definition = "Who a person feels they truly are — values, roots, beliefs and habits.",
            definitionNative = "То, кем человек ощущает себя по сути — корни, ценности, убеждения, привычки.",
            example = "Living abroad made him think hard about his cultural identity.",
            exampleNative = "Жизнь за границей заставила его глубоко задуматься о своей identity.",
            pos = "noun", semanticGroup = "philosophy_consciousness", fillInBlankExclusions = listOf(34201L, 34206L, 34207L, 34208L, 34210L, 34215L, 34222L)),

        WordEntity(id = 34210, setId = 342, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "purpose", transliteration = "[ˈpɜːpəs]", translation = "цель / смысл (жизни, дела)",
            definition = "The reason why you do something or why something exists at all.",
            definitionNative = "Причина, ради которой ты что-то делаешь, или ради чего нечто существует.",
            example = "After retiring he searched for a new purpose in life.",
            exampleNative = "После выхода на пенсию он искал новую purpose в жизни.",
            pos = "noun", semanticGroup = "philosophy_consciousness", fillInBlankExclusions = listOf(34201L, 34203L, 34206L, 34207L, 34208L, 34209L, 34211L, 34212L, 34213L, 34215L, 34221L, 34222L)),

        // ── philosophy_directions (5) ─────────────────────────────────────

        WordEntity(id = 34211, setId = 342, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "religion", transliteration = "[rɪˈlɪʤən]", translation = "религия",
            definition = "A system of beliefs and rituals built around a god or sacred power.",
            definitionNative = "Система верований и обрядов, выстроенная вокруг бога или священной силы.",
            example = "Many philosophers have studied the role of religion in society.",
            exampleNative = "Многие философы изучали роль religion в обществе.",
            pos = "noun", semanticGroup = "philosophy_directions", fillInBlankExclusions = listOf(34201L, 34202L, 34203L, 34204L, 34205L, 34206L, 34207L, 34208L, 34209L, 34210L, 34212L, 34213L, 34214L, 34215L, 34219L, 34221L, 34222L, 34223L, 34224L, 34225L)),

        WordEntity(id = 34212, setId = 342, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "faith", transliteration = "[feɪθ]", translation = "вера (религиозная или в принципы)",
            definition = "A strong trust in something you cannot prove with hard evidence.",
            definitionNative = "Сильное доверие к тому, что нельзя строго доказать опытом или фактами.",
            example = "Her faith in human kindness never wavered after the war.",
            exampleNative = "Её faith в человеческую доброту не пошатнулась даже после войны.",
            pos = "noun", semanticGroup = "philosophy_directions", fillInBlankExclusions = listOf(34211L, 34213L, 34214L, 34215L)),

        WordEntity(id = 34213, setId = 342, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "freedom", transliteration = "[ˈfriːdəm]", translation = "свобода",
            definition = "The state of being able to choose and act without being held back.",
            definitionNative = "Состояние, когда человек может выбирать и действовать, не будучи скован.",
            example = "Many thinkers consider freedom the highest political value.",
            exampleNative = "Многие мыслители считают freedom высшей политической ценностью.",
            pos = "noun", semanticGroup = "philosophy_directions", fillInBlankExclusions = listOf(34201L, 34202L, 34203L, 34204L, 34205L, 34209L, 34211L, 34212L, 34214L, 34215L)),

        WordEntity(id = 34214, setId = 342, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "equality", transliteration = "[ɪˈkwɒləti]", translation = "равенство",
            definition = "The state where every person has the same rights and chances in life.",
            definitionNative = "Положение, при котором у всех людей одинаковые права и возможности.",
            example = "The march demanded equality for women in the workplace.",
            exampleNative = "Марш требовал equality для женщин на рабочих местах.",
            pos = "noun", semanticGroup = "philosophy_directions", fillInBlankExclusions = listOf(34202L, 34204L, 34208L, 34211L, 34212L, 34213L, 34215L)),

        WordEntity(id = 34215, setId = 342, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "belief", transliteration = "[bɪˈliːf]", translation = "убеждение / мнение",
            definition = "A firm view that something is true, even without final proof.",
            definitionNative = "Твёрдый взгляд на то, что нечто верно — даже без окончательных доказательств.",
            example = "His core belief is that honest work brings inner peace.",
            exampleNative = "Главное его belief — что честный труд приносит внутренний покой.",
            pos = "noun", semanticGroup = "philosophy_directions", fillInBlankExclusions = listOf(34211L, 34212L, 34213L, 34214L, 34222L)),

        // ── philosophy_reasoning (5) ──────────────────────────────────────

        WordEntity(id = 34216, setId = 342, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "reflect", transliteration = "[rɪˈflɛkt]", translation = "размышлять (над вопросом)",
            definition = "To think calmly and deeply about something for a long time.",
            definitionNative = "Спокойно и глубоко думать о чём-то на протяжении долгого времени.",
            example = "She liked to reflect on the day's events before going to sleep.",
            exampleNative = "Она любила reflect над событиями дня перед сном.",
            pos = "verb", semanticGroup = "philosophy_reasoning", fillInBlankExclusions = listOf(34217L, 34218L, 34219L, 34220L)),

        WordEntity(id = 34217, setId = 342, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "interpret", transliteration = "[ɪnˈtɜːprət]", translation = "толковать / истолковывать",
            definition = "To explain the deeper meaning of a text, sign or another person's actions.",
            definitionNative = "Объяснять скрытый смысл текста, знака или чужих поступков.",
            example = "Scholars still interpret that passage in very different ways.",
            exampleNative = "Учёные до сих пор по-разному interpret этот отрывок.",
            pos = "verb", semanticGroup = "philosophy_reasoning", fillInBlankExclusions = listOf(34216L, 34218L, 34219L, 34220L)),

        WordEntity(id = 34218, setId = 342, languagePair = "en-ru", rarity = "RARE",
            original = "ponder", transliteration = "[ˈpɒndə]", translation = "обдумывать / взвешивать (мысль)",
            definition = "To weigh an idea slowly in your mind, turning it from side to side.",
            definitionNative = "Долго и медленно крутить мысль в уме, рассматривая её со всех сторон.",
            example = "He sat by the window to ponder the strange letter from his cousin.",
            exampleNative = "Он сел у окна, чтобы ponder странное письмо от двоюродного брата.",
            pos = "verb", semanticGroup = "philosophy_reasoning", fillInBlankExclusions = listOf(34216L, 34217L, 34219L, 34220L)),

        WordEntity(id = 34219, setId = 342, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "debate", transliteration = "[dɪˈbeɪt]", translation = "дискутировать / спорить публично",
            definition = "To discuss a topic in public where two or more people give opposing views.",
            definitionNative = "Открыто разбирать тему, когда несколько людей высказывают противоположные взгляды.",
            example = "Students will debate the ethics of gene editing on Friday.",
            exampleNative = "В пятницу студенты будут debate этику редактирования генома.",
            pos = "verb", semanticGroup = "philosophy_reasoning", fillInBlankExclusions = listOf(34216L, 34217L, 34218L, 34220L)),

        WordEntity(id = 34220, setId = 342, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "analyze", transliteration = "[ˈænəlaɪz]", translation = "анализировать (мысль, текст)",
            definition = "To break an idea into parts so you can study how each one works.",
            definitionNative = "Раскладывать мысль на части, чтобы изучить, как работает каждая из них.",
            example = "Philosophers analyze old arguments to see what still holds today.",
            exampleNative = "Философы analyze старые аргументы, чтобы увидеть, что в них до сих пор работает.",
            pos = "verb", semanticGroup = "philosophy_reasoning", fillInBlankExclusions = listOf(34216L, 34217L, 34218L, 34219L)),

        // ── philosophy_concepts (5) ───────────────────────────────────────

        WordEntity(id = 34221, setId = 342, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "meaning", transliteration = "[ˈmiːnɪŋ]", translation = "смысл / значение",
            definition = "The deep idea or message that something carries within itself.",
            definitionNative = "Глубокая мысль или весть, которую нечто несёт в себе для понимающего.",
            example = "Many people search all their lives for the meaning of suffering.",
            exampleNative = "Многие всю жизнь ищут meaning страдания и боли.",
            pos = "noun", semanticGroup = "philosophy_concepts", fillInBlankExclusions = listOf(34201L, 34202L, 34204L, 34206L, 34207L, 34208L, 34210L, 34222L, 34223L, 34224L, 34225L)),

        WordEntity(id = 34222, setId = 342, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "value", transliteration = "[ˈvæljuː]", translation = "ценность (моральная)",
            definition = "An important principle a person or group considers worthy and lasting.",
            definitionNative = "Важный принцип, который человек или группа считает достойным и устойчивым.",
            example = "Honesty is a core value taught in his family for generations.",
            exampleNative = "Честность — главная value, которую в его семье воспитывали поколениями.",
            pos = "noun", semanticGroup = "philosophy_concepts", fillInBlankExclusions = listOf(34203L, 34215L, 34221L, 34223L, 34224L)),

        WordEntity(id = 34223, setId = 342, languagePair = "en-ru", rarity = "RARE",
            original = "ignorance", transliteration = "[ˈɪɡnərəns]", translation = "невежество / незнание",
            definition = "The state of not knowing facts that you really should know about life.",
            definitionNative = "Положение, когда человек не знает того, что он реально должен бы знать.",
            example = "Socrates said that real ignorance is thinking you already know.",
            exampleNative = "Сократ говорил, что подлинное ignorance — думать, будто ты уже знаешь.",
            pos = "noun", semanticGroup = "philosophy_concepts", fillInBlankExclusions = listOf(34207L, 34221L, 34222L, 34224L, 34225L)),

        WordEntity(id = 34224, setId = 342, languagePair = "en-ru", rarity = "RARE",
            original = "integrity", transliteration = "[ɪnˈtɛɡrəti]", translation = "цельность характера / неподкупность",
            definition = "A firm habit of acting by your principles even when it costs you a lot.",
            definitionNative = "Твёрдая привычка поступать по своим принципам, даже если это дорого тебе обходится.",
            example = "The judge was famous for his integrity in difficult cases.",
            exampleNative = "Судья славился своей integrity в сложных делах.",
            pos = "noun", semanticGroup = "philosophy_concepts", fillInBlankExclusions = listOf(34201L, 34204L, 34206L, 34207L, 34221L, 34222L, 34223L, 34225L)),

        WordEntity(id = 34225, setId = 342, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "honesty", transliteration = "[ˈɒnəsti]", translation = "честность",
            definition = "The habit of telling the truth and never trying to trick the other person.",
            definitionNative = "Привычка говорить правду и никогда не пытаться обмануть собеседника.",
            example = "Friendship between them rested on plain honesty from day one.",
            exampleNative = "Их дружба с самого начала держалась на простой honesty.",
            pos = "noun", semanticGroup = "philosophy_concepts", fillInBlankExclusions = listOf(34201L, 34206L, 34212L, 34215L, 34221L, 34222L, 34223L, 34224L)),
    )
}
