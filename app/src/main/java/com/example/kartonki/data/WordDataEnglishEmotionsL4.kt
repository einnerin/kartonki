package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Эмоции и чувства (level 4, профессиональный).
 *
 * Set 363: «Эмоции и чувства» — профессиональный (L4, EPIC + LEGENDARY):
 *          эмпатия, регуляция эмоций, эмоциональный интеллект,
 *          сложные/когнитивные эмоции, теория привязанности.
 *
 * Слова не повторяются с Emotions L1L2L3 (360, 361, 362) и с Psychology
 * (28, 35, 36, 45, 64, 71, 81). Уже занятые в Psychology:
 *   empathy → cognitive empathy
 *   compassion → compassion fatigue
 *   humility → mindfulness
 *   equanimity → перенесено в L5
 *
 * Распределение редкости: 13 EPIC + 12 LEGENDARY (спред 1, на границе L4-L5).
 *
 * SemanticGroups (5 × 5):
 *   emotions_empathy           — cognitive empathy, compassion fatigue, mirror neuron,
 *                                perspective taking, attunement
 *   emotions_regulation        — emotion regulation, suppression, reappraisal,
 *                                mindfulness, self-soothing
 *   emotions_intelligence      — emotional intelligence, self-awareness, social cue,
 *                                interpersonal radar, emotional bandwidth
 *   emotions_complex_concepts  — ambivalence, cognitive dissonance, existential dread,
 *                                euphoria, melancholy
 *   emotions_attachment        — attachment style, secure attachment, anxious attachment,
 *                                avoidant attachment, codependence
 *
 * Word IDs: setId × 100 + position (36301..36325).
 *
 * isFillInBlankSafe = false — большинство слов многословные термины
 * (cognitive empathy, compassion fatigue, attachment style и т.д.). В FILL_IN_BLANK
 * пропуск создаётся механической заменой и для таких терминов протекает
 * либо неоднозначен. Для одиночных слов (suppression, reappraisal, mindfulness,
 * ambivalence, euphoria, melancholy, codependence) флаг тоже сохранён false для
 * единообразия — pipeline позже подберёт exclusions и при необходимости
 * флипнет флаг в Phase 3.
 */
object WordDataEnglishEmotionsL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 363, languagePair = "en-ru", orderIndex = 363,
            name = "Эмоции и чувства",
            description = "Профессиональный: эмпатия, когнитивные эмоции, эмоц. интеллект, регуляция",
            topic = "Эмоции и чувства", level = 4),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 363 — Эмоции и чувства: профессиональный (L4, EPIC+LEG)     ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── emotions_empathy (5) ──────────────────────────────────────────

        WordEntity(id = 36301, setId = 363, languagePair = "en-ru", rarity = "EPIC",
            original = "cognitive empathy", transliteration = "[ˈkɑɡnətɪv ˈɛmpəθi]",
            translation = "когнитивная эмпатия (понимание чужих чувств)",
            definition = "The ability to mentally grasp what another person feels without sharing it.",
            definitionNative = "Способность умом понять, что чувствует другой, не переживая то же самое.",
            example = "Therapists rely on cognitive empathy to make sense of a client's inner world.",
            exampleNative = "Терапевты опираются на cognitive empathy, чтобы разобраться во внутреннем мире клиента.",
            pos = "noun", semanticGroup = "emotions_empathy", fillInBlankExclusions = listOf(36302L, 36303L, 36304L, 36305L)),

        WordEntity(id = 36302, setId = 363, languagePair = "en-ru", rarity = "EPIC",
            original = "compassion fatigue", transliteration = "[kəmˈpæʃən fəˈtiɡ]",
            translation = "усталость от сострадания",
            definition = "Emotional exhaustion that builds up in people who care for the suffering daily.",
            definitionNative = "Эмоциональное истощение у тех, кто каждый день заботится о страдающих.",
            example = "After ten years in oncology, the nurse felt deep compassion fatigue.",
            exampleNative = "После десяти лет в онкологии медсестра ощутила глубокую compassion fatigue.",
            pos = "noun", semanticGroup = "emotions_empathy", fillInBlankExclusions = listOf(36301L, 36303L, 36304L, 36305L)),

        WordEntity(id = 36303, setId = 363, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "mirror neuron", transliteration = "[ˈmɪrər ˈnʊrɑn]",
            translation = "зеркальный нейрон",
            definition = "A brain cell that fires both when you act and when you watch someone else act.",
            definitionNative = "Клетка мозга, реагирующая и на твоё действие, и на действие другого человека.",
            example = "Scientists believe mirror neuron activity helps babies learn to imitate adults.",
            exampleNative = "Учёные считают, что mirror neuron активность помогает младенцам подражать взрослым.",
            pos = "noun", semanticGroup = "emotions_empathy", fillInBlankExclusions = listOf(36301L, 36302L, 36304L, 36305L)),

        WordEntity(id = 36304, setId = 363, languagePair = "en-ru", rarity = "EPIC",
            original = "perspective taking", transliteration = "[pərˈspɛktɪv ˈteɪkɪŋ]",
            translation = "принятие чужой точки зрения",
            definition = "The act of imagining a situation through someone else's eyes and feelings.",
            definitionNative = "Попытка представить ситуацию глазами и чувствами другого человека.",
            example = "Good mediators master perspective taking before saying a single word.",
            exampleNative = "Хорошие медиаторы осваивают perspective taking прежде чем сказать хоть слово.",
            pos = "noun", semanticGroup = "emotions_empathy", fillInBlankExclusions = listOf(36301L, 36302L, 36303L, 36305L)),

        WordEntity(id = 36305, setId = 363, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "attunement", transliteration = "[əˈtunmənt]",
            translation = "эмоциональное созвучие, настроенность",
            definition = "The quiet skill of sensing another person's feelings and matching them gently.",
            definitionNative = "Тихое умение чувствовать состояние другого и мягко подстраиваться под него.",
            example = "Her attunement to the child's mood made every session feel safe.",
            exampleNative = "Её attunement к настроению ребёнка делало каждую сессию безопасной.",
            pos = "noun", semanticGroup = "emotions_empathy", fillInBlankExclusions = listOf(36301L, 36302L, 36303L, 36304L)),

        // ── emotions_regulation (5) ───────────────────────────────────────

        WordEntity(id = 36306, setId = 363, languagePair = "en-ru", rarity = "EPIC",
            original = "emotion regulation", transliteration = "[ɪˈmoʊʃən ˌrɛɡjəˈleɪʃən]",
            translation = "регуляция эмоций",
            definition = "The skill of guiding what you feel so it fits the moment and your goals.",
            definitionNative = "Умение направлять то, что чувствуешь, под момент и собственные цели.",
            example = "Therapy taught him emotion regulation strategies for stressful meetings.",
            exampleNative = "Терапия научила его стратегиям emotion regulation для стрессовых встреч.",
            pos = "noun", semanticGroup = "emotions_regulation", fillInBlankExclusions = listOf(36307L, 36308L, 36309L, 36310L)),

        WordEntity(id = 36307, setId = 363, languagePair = "en-ru", rarity = "EPIC",
            original = "suppression", transliteration = "[səˈprɛʃən]",
            translation = "подавление (чувств)",
            definition = "Holding back a feeling so it stays hidden from others and yourself.",
            definitionNative = "Удержание чувства, чтобы оно оставалось скрытым от других и от себя.",
            example = "Long-term suppression of grief often leads to physical health issues.",
            exampleNative = "Длительная suppression горя часто ведёт к проблемам с физическим здоровьем.",
            pos = "noun", semanticGroup = "emotions_regulation", fillInBlankExclusions = listOf(36306L, 36308L, 36309L, 36310L)),

        WordEntity(id = 36308, setId = 363, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "reappraisal", transliteration = "[ˌriəˈpreɪzəl]",
            translation = "переоценка (когнитивная)",
            definition = "Looking at a tough situation again and finding a calmer way to read it.",
            definitionNative = "Новый взгляд на трудную ситуацию, чтобы прочесть её спокойнее.",
            example = "Cognitive reappraisal helped her stop seeing the criticism as a personal attack.",
            exampleNative = "Когнитивная reappraisal помогла ей перестать видеть критику как личную атаку.",
            pos = "noun", semanticGroup = "emotions_regulation", fillInBlankExclusions = listOf(36306L, 36307L, 36309L, 36310L)),

        WordEntity(id = 36309, setId = 363, languagePair = "en-ru", rarity = "EPIC",
            original = "mindfulness", transliteration = "[ˈmaɪndfəlnəs]",
            translation = "осознанность, mindfulness-практика",
            definition = "Paying gentle attention to the present moment without judging what shows up.",
            definitionNative = "Мягкое внимание к настоящему моменту без оценки того, что в нём появляется.",
            example = "A daily mindfulness practice slowly changed how he reacted to anger.",
            exampleNative = "Ежедневная mindfulness практика постепенно меняла его реакцию на гнев.",
            pos = "noun", semanticGroup = "emotions_regulation", fillInBlankExclusions = listOf(36306L, 36307L, 36308L, 36310L)),

        WordEntity(id = 36310, setId = 363, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "self-soothing", transliteration = "[sɛlf ˈsuðɪŋ]",
            translation = "самоуспокоение",
            definition = "The ability to calm yourself down through small kind acts when upset.",
            definitionNative = "Умение унять себя через небольшие добрые жесты, когда тяжело.",
            example = "Healthy self-soothing might be a warm bath, a walk, or a soft blanket.",
            exampleNative = "Здоровое self-soothing — это тёплая ванна, прогулка или мягкий плед.",
            pos = "noun", semanticGroup = "emotions_regulation", fillInBlankExclusions = listOf(36306L, 36307L, 36308L, 36309L)),

        // ── emotions_intelligence (5) ─────────────────────────────────────

        WordEntity(id = 36311, setId = 363, languagePair = "en-ru", rarity = "EPIC",
            original = "emotional intelligence", transliteration = "[ɪˈmoʊʃənəl ɪnˈtɛlədʒəns]",
            translation = "эмоциональный интеллект",
            definition = "The skill of reading feelings — your own and others' — and acting wisely.",
            definitionNative = "Умение читать чувства — свои и чужие — и поступать с ними мудро.",
            example = "Modern leaders need strong emotional intelligence as much as technical skill.",
            exampleNative = "Современным лидерам нужен сильный emotional intelligence не меньше технических навыков.",
            pos = "noun", semanticGroup = "emotions_intelligence", fillInBlankExclusions = listOf(36312L, 36313L, 36314L, 36315L)),

        WordEntity(id = 36312, setId = 363, languagePair = "en-ru", rarity = "EPIC",
            original = "self-awareness", transliteration = "[sɛlf əˈwɛrnəs]",
            translation = "самоосознанность",
            definition = "Knowing what you feel, why you feel it, and how it shapes your choices.",
            definitionNative = "Знание о том, что чувствуешь, почему и как это влияет на выбор.",
            example = "Years of journaling deepened her self-awareness around old family patterns.",
            exampleNative = "Годы дневников углубили её self-awareness в отношении старых семейных паттернов.",
            pos = "noun", semanticGroup = "emotions_intelligence", fillInBlankExclusions = listOf(36311L, 36313L, 36314L, 36315L)),

        WordEntity(id = 36313, setId = 363, languagePair = "en-ru", rarity = "EPIC",
            original = "social cue", transliteration = "[ˈsoʊʃəl kju]",
            translation = "социальный сигнал",
            definition = "A small hint in a face, voice or gesture that tells you how to respond.",
            definitionNative = "Маленькая подсказка на лице, в голосе или жесте, как реагировать.",
            example = "He missed the social cue and kept talking long after everyone wanted to leave.",
            exampleNative = "Он не заметил social cue и продолжал говорить, когда все хотели уйти.",
            pos = "noun", semanticGroup = "emotions_intelligence", fillInBlankExclusions = listOf(36311L, 36312L, 36314L, 36315L)),

        WordEntity(id = 36314, setId = 363, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "interpersonal radar", transliteration = "[ˌɪntərˈpɜrsənəl ˈreɪdɑr]",
            translation = "межличностный «радар» (чуткость к людям)",
            definition = "An almost intuitive sense for shifts in mood across a room of people.",
            definitionNative = "Почти интуитивное чутьё на смену настроения в комнате людей.",
            example = "Her interpersonal radar caught the tension before anyone said a word.",
            exampleNative = "Её interpersonal radar уловил напряжение раньше, чем кто-то заговорил.",
            pos = "noun", semanticGroup = "emotions_intelligence", fillInBlankExclusions = listOf(36311L, 36312L, 36313L, 36315L)),

        WordEntity(id = 36315, setId = 363, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "emotional bandwidth", transliteration = "[ɪˈmoʊʃənəl ˈbændwɪdθ]",
            translation = "эмоциональная пропускная способность",
            definition = "How much feeling and care a person can hold before getting overwhelmed.",
            definitionNative = "Сколько чувств и заботы человек выдерживает, прежде чем перегрузиться.",
            example = "After the funeral she had no emotional bandwidth left for office drama.",
            exampleNative = "После похорон у неё не осталось emotional bandwidth на офисные драмы.",
            pos = "noun", semanticGroup = "emotions_intelligence", fillInBlankExclusions = listOf(36311L, 36312L, 36313L, 36314L)),

        // ── emotions_complex_concepts (5) ─────────────────────────────────

        WordEntity(id = 36316, setId = 363, languagePair = "en-ru", rarity = "EPIC",
            original = "equivocation", transliteration = "[ɪˌkwɪvəˈkeɪʃən]",
            translation = "внутренняя двусмысленность",
            definition = "An inner pull between two truths that makes a person speak or feel both ways.",
            definitionNative = "Внутреннее раздвоение между двумя правдами — человек говорит и чувствует обе.",
            example = "She felt deep equivocation about leaving a job she both loved and hated.",
            exampleNative = "Она чувствовала глубокую equivocation от ухода с работы, которую любила и ненавидела.",
            pos = "noun", semanticGroup = "emotions_complex_concepts", fillInBlankExclusions = listOf(36317L, 36318L, 36319L, 36320L)),

        WordEntity(id = 36317, setId = 363, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "cognitive dissonance", transliteration = "[ˈkɑɡnətɪv ˈdɪsənəns]",
            translation = "когнитивный диссонанс",
            definition = "The uneasy feeling when your actions clash with what you say you believe.",
            definitionNative = "Неприятное ощущение, когда поступки расходятся с тем, во что вроде бы веришь.",
            example = "Buying a fur coat caused her real cognitive dissonance as an animal lover.",
            exampleNative = "Покупка шубы вызвала у неё настоящий cognitive dissonance как у любительницы животных.",
            pos = "noun", semanticGroup = "emotions_complex_concepts", fillInBlankExclusions = listOf(36316L, 36318L, 36319L, 36320L)),

        WordEntity(id = 36318, setId = 363, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "existential dread", transliteration = "[ˌɛɡzɪˈstɛnʃəl drɛd]",
            translation = "экзистенциальная тревога",
            definition = "A heavy fear about meaning, mortality and the size of the world around you.",
            definitionNative = "Тяжёлый страх о смысле, смертности и огромности мира вокруг.",
            example = "Late at night, existential dread made him stare at the dark ceiling for hours.",
            exampleNative = "Поздно ночью existential dread заставлял его часами смотреть в тёмный потолок.",
            pos = "noun", semanticGroup = "emotions_complex_concepts", fillInBlankExclusions = listOf(36316L, 36317L, 36319L, 36320L)),

        WordEntity(id = 36319, setId = 363, languagePair = "en-ru", rarity = "EPIC",
            original = "euphoria", transliteration = "[juˈfɔriə]",
            translation = "эйфория",
            definition = "A wave of intense happiness that lifts you almost off the ground.",
            definitionNative = "Волна сильнейшего счастья, что почти отрывает от земли.",
            example = "Crossing the finish line filled her with a strange, weightless euphoria.",
            exampleNative = "Финиш наполнил её странной, невесомой euphoria.",
            pos = "noun", semanticGroup = "emotions_complex_concepts", fillInBlankExclusions = listOf(36316L, 36317L, 36318L, 36320L)),

        WordEntity(id = 36320, setId = 363, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "melancholy", transliteration = "[ˈmɛlənkɑli]",
            translation = "меланхолия (тихая печаль)",
            definition = "A soft, lingering sadness that has no clear cause but stays for a while.",
            definitionNative = "Мягкая, тянущаяся грусть без ясной причины, остающаяся на время.",
            example = "Autumn evenings filled the old poet with a familiar melancholy.",
            exampleNative = "Осенние вечера наполняли старого поэта привычной melancholy.",
            pos = "noun", semanticGroup = "emotions_complex_concepts", fillInBlankExclusions = listOf(36316L, 36317L, 36318L, 36319L)),

        // ── emotions_attachment (5) ───────────────────────────────────────

        WordEntity(id = 36321, setId = 363, languagePair = "en-ru", rarity = "EPIC",
            original = "attachment style", transliteration = "[əˈtætʃmənt staɪl]",
            translation = "стиль привязанности",
            definition = "The pattern of how a person seeks closeness and reacts to distance in love.",
            definitionNative = "Паттерн того, как человек ищет близости и реагирует на дистанцию в любви.",
            example = "Couples therapy started with mapping each partner's attachment style.",
            exampleNative = "Парная терапия началась с описания attachment style каждого партнёра.",
            pos = "noun", semanticGroup = "emotions_attachment", fillInBlankExclusions = listOf(36322L, 36323L, 36324L, 36325L)),

        WordEntity(id = 36322, setId = 363, languagePair = "en-ru", rarity = "EPIC",
            original = "secure attachment", transliteration = "[sɪˈkjʊr əˈtætʃmənt]",
            translation = "надёжная привязанность",
            definition = "A calm bond where closeness feels safe and short separations don't scare you.",
            definitionNative = "Спокойная связь, где близость безопасна, а короткие разлуки не пугают.",
            example = "Secure attachment in childhood often makes adult relationships smoother.",
            exampleNative = "Secure attachment в детстве часто делает взрослые отношения более ровными.",
            pos = "noun", semanticGroup = "emotions_attachment", fillInBlankExclusions = listOf(36321L, 36323L, 36324L, 36325L)),

        WordEntity(id = 36323, setId = 363, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "anxious attachment", transliteration = "[ˈæŋkʃəs əˈtætʃmənt]",
            translation = "тревожная привязанность",
            definition = "A bond marked by constant worry that the loved one will pull away.",
            definitionNative = "Связь с постоянным беспокойством, что близкий человек отдалится.",
            example = "His anxious attachment showed up every time she didn't answer texts quickly.",
            exampleNative = "Его anxious attachment проявлялся каждый раз, когда она не отвечала на сообщения быстро.",
            pos = "noun", semanticGroup = "emotions_attachment", fillInBlankExclusions = listOf(36321L, 36322L, 36324L, 36325L)),

        WordEntity(id = 36324, setId = 363, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "avoidant attachment", transliteration = "[əˈvɔɪdənt əˈtætʃmənt]",
            translation = "избегающая привязанность",
            definition = "A pattern where closeness feels suffocating and distance feels safer.",
            definitionNative = "Паттерн, где близость душит, а дистанция кажется безопаснее.",
            example = "People with avoidant attachment often shut down during emotional talks.",
            exampleNative = "Люди с avoidant attachment часто закрываются во время эмоциональных разговоров.",
            pos = "noun", semanticGroup = "emotions_attachment", fillInBlankExclusions = listOf(36321L, 36322L, 36323L, 36325L)),

        WordEntity(id = 36325, setId = 363, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "codependence", transliteration = "[ˌkoʊdɪˈpɛndəns]",
            translation = "созависимость",
            definition = "A bond where one person's worth depends on rescuing or pleasing the other.",
            definitionNative = "Связь, где ценность одного зависит от спасения или угождения другому.",
            example = "Years of codependence left her unable to name a single hobby of her own.",
            exampleNative = "Годы codependence оставили её без единого собственного увлечения.",
            pos = "noun", semanticGroup = "emotions_attachment", fillInBlankExclusions = listOf(36321L, 36322L, 36323L, 36324L)),
    )
}
