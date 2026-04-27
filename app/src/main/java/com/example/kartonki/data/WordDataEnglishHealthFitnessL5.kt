package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — «Здоровье и фитнес» (level 5, носитель языка).
 *
 * Set 355: «Здоровье и фитнес: уровень носителя» — академическая медицинская
 * лексика на стыке эндокринологии, физиологии, патологии, фармакологии и
 * клинической доказательной медицины (C2+).
 *
 * Распределение редкости: 13 EPIC + 12 LEGENDARY — два смежных уровня шкалы.
 *
 * Дополняет уже существующие сеты темы «Здоровье и фитнес»:
 *   - Set 345 (WordDataEnglishHealthFitnessL1L2L3.kt) — L1 COMMON/UNCOMMON
 *   - Set 346 (WordDataEnglishHealthFitnessL1L2L3.kt) — L2 UNCOMMON/RARE
 *   - Set 347 (WordDataEnglishHealthFitnessL1L2L3.kt) — L3 RARE/EPIC
 *   - Set 354 (TBD) — L4 EPIC, клиническая лексика спортмеда
 *
 * Слова setId=355 не пересекаются ни с одним из перечисленных сетов
 * (проверено grep по всей директории data/). Cross-topic дубль
 * `contraindication` с set 322 (Медицина L4) допустим по правилу
 * «cross-topic дубли разрешены» (docs/claude/feedback_duplicate_words_policy.md).
 *
 * SemanticGroups (5 × 5):
 *   health_endocrine     — cortisol, insulin sensitivity, thyroid hormone, adrenal fatigue, leptin
 *   health_physiology    — homeostasis, mitochondrial function, neuroplasticity, autophagy, telomere
 *   health_pathology     — chronic inflammation, autoimmune disease, oxidative stress, metabolic syndrome, sarcopenia
 *   health_pharmacology  — pharmacokinetics, bioavailability, drug interaction, contraindication, off-label use
 *   health_clinical      — randomized controlled trial, placebo effect, evidence-based practice, longitudinal study, biomarker
 *
 * Word IDs: 35501..35525 (setId × 100 + position).
 *
 * isFillInBlankSafe = false для всех слов: множество многословных терминов
 * («randomized controlled trial», «evidence-based practice», «off-label use»)
 * и плотная семантическая близость соседей по подтеме (cortisol ↔ leptin,
 * pharmacokinetics ↔ bioavailability) делают пропуски плохо разрешимыми
 * без полного контекста — exclusion-списки были бы огромными.
 */
object WordDataEnglishHealthFitnessL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 355, languagePair = "en-ru", orderIndex = 355,
            name = "Здоровье и фитнес",
            description = "Уровень носителя: эндокринология, физиология, патология, фармакология, клиника",
            topic = "Здоровье и фитнес", level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── health_endocrine (5) ──────────────────────────────────────────────

        WordEntity(id = 35501, setId = 355, languagePair = "en-ru", rarity = "EPIC",
            original = "cortisol", transliteration = "[ˈkɔːrtɪsɒl]", translation = "кортизол (гормон стресса)",
            definition = "A stress hormone the adrenal glands release to mobilise energy under pressure.",
            definitionNative = "Гормон стресса, выделяемый надпочечниками для мобилизации энергии под давлением.",
            example = "Chronic stress keeps cortisol elevated for hours after the event.",
            exampleNative = "Хронический стресс держит cortisol повышенным часами после события.",
            pos = "noun", semanticGroup = "health_endocrine", isFillInBlankSafe = false),

        WordEntity(id = 35502, setId = 355, languagePair = "en-ru", rarity = "EPIC",
            original = "insulin sensitivity", transliteration = "[ˈɪnsjəlɪn ˌsensəˈtɪvəti]", translation = "чувствительность к инсулину",
            definition = "How well the body responds to the blood-sugar hormone after a meal.",
            definitionNative = "Насколько хорошо тело отвечает на гормон сахара крови после приёма пищи.",
            example = "Regular sprints can improve insulin sensitivity within a few weeks.",
            exampleNative = "Регулярные спринты улучшают insulin sensitivity за несколько недель.",
            pos = "noun", semanticGroup = "health_endocrine", isFillInBlankSafe = false),

        WordEntity(id = 35503, setId = 355, languagePair = "en-ru", rarity = "EPIC",
            original = "thyroid hormone", transliteration = "[ˈθaɪrɔɪd ˈhɔːrmoʊn]", translation = "тиреоидный гормон",
            definition = "A neck-gland chemical that sets how fast every cell burns its fuel.",
            definitionNative = "Вещество шейной железы, задающее, насколько быстро каждая клетка тратит топливо.",
            example = "Low thyroid hormone leaves the patient cold, slow and tired all day.",
            exampleNative = "Низкий thyroid hormone оставляет пациента зябким, медлительным и уставшим целый день.",
            pos = "noun", semanticGroup = "health_endocrine", isFillInBlankSafe = false),

        WordEntity(id = 35504, setId = 355, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "adrenal fatigue", transliteration = "[əˈdriːnəl fəˈtiːɡ]", translation = "адреналовая усталость",
            definition = "A controversial label for deep tiredness blamed on overworked stress glands.",
            definitionNative = "Спорное название для глубокой усталости, приписываемой перегруженным надпочечникам.",
            example = "Some clinicians dismiss adrenal fatigue as a fashionable misdiagnosis.",
            exampleNative = "Некоторые клиницисты отвергают adrenal fatigue как модный неверный диагноз.",
            pos = "noun", semanticGroup = "health_endocrine", isFillInBlankSafe = false),

        WordEntity(id = 35505, setId = 355, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "leptin", transliteration = "[ˈleptɪn]", translation = "лептин (гормон сытости)",
            definition = "A fat-cell hormone that tells the brain the body has eaten enough.",
            definitionNative = "Гормон жировой клетки, сообщающий мозгу, что организм поел достаточно.",
            example = "Poor sleep blunts leptin and drives midnight snacking.",
            exampleNative = "Плохой сон притупляет leptin и провоцирует ночные перекусы.",
            pos = "noun", semanticGroup = "health_endocrine", isFillInBlankSafe = false),

        // ── health_physiology (5) ─────────────────────────────────────────────

        WordEntity(id = 35506, setId = 355, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "homeostasis", transliteration = "[ˌhoʊmiəˈsteɪsɪs]", translation = "гомеостаз (внутреннее равновесие)",
            definition = "The body's quiet trick of holding temperature, salt and sugar nearly constant.",
            definitionNative = "Тихий приём тела удерживать температуру, соль и сахар почти постоянными.",
            example = "Sweating is a basic tool of homeostasis on a hot afternoon.",
            exampleNative = "Потоотделение — базовый инструмент homeostasis жарким днём.",
            pos = "noun", semanticGroup = "health_physiology", isFillInBlankSafe = false),

        WordEntity(id = 35507, setId = 355, languagePair = "en-ru", rarity = "EPIC",
            original = "mitochondrial function", transliteration = "[ˌmaɪtəˈkɒndriəl ˈfʌŋkʃən]", translation = "митохондриальная функция",
            definition = "How well the tiny power plants inside each cell turn food into usable energy.",
            definitionNative = "Насколько хорошо крошечные энергостанции внутри клетки превращают еду в энергию.",
            example = "Endurance training boosts mitochondrial function in slow-twitch muscle fibres.",
            exampleNative = "Тренировка выносливости поднимает mitochondrial function в медленных волокнах.",
            pos = "noun", semanticGroup = "health_physiology", isFillInBlankSafe = false),

        WordEntity(id = 35508, setId = 355, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "neuroplasticity", transliteration = "[ˌnʊəroʊplæˈstɪsəti]", translation = "нейропластичность",
            definition = "The brain's lifelong knack of rewiring itself when learning a new skill.",
            definitionNative = "Пожизненная способность мозга перестраиваться при освоении нового навыка.",
            example = "Daily piano practice slowly reshapes the brain through neuroplasticity.",
            exampleNative = "Ежедневные занятия фортепиано медленно меняют мозг через neuroplasticity.",
            pos = "noun", semanticGroup = "health_physiology", isFillInBlankSafe = false),

        WordEntity(id = 35509, setId = 355, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "autophagy", transliteration = "[ɔːˈtɒfəʤi]", translation = "аутофагия (самоочищение клеток)",
            definition = "The cell's housekeeping process of digesting its own worn-out parts to recycle them.",
            definitionNative = "Уборка в клетке: переваривание собственных изношенных деталей для вторичной переработки.",
            example = "Long fasting is said to ramp up autophagy in healthy adults.",
            exampleNative = "Долгое голодание, как считается, усиливает autophagy у здоровых взрослых.",
            pos = "noun", semanticGroup = "health_physiology", isFillInBlankSafe = false),

        WordEntity(id = 35510, setId = 355, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "telomere", transliteration = "[ˈtiːlɵmɪər]", translation = "теломера (концевой участок ДНК)",
            definition = "A protective cap at the end of a chromosome that shortens with each cell split.",
            definitionNative = "Защитный колпачок на конце хромосомы, укорачивающийся при каждом делении клетки.",
            example = "Researchers link short telomere length to faster biological aging.",
            exampleNative = "Учёные связывают короткую длину telomere с ускоренным биологическим старением.",
            pos = "noun", semanticGroup = "health_physiology", isFillInBlankSafe = false),

        // ── health_pathology (5) ──────────────────────────────────────────────

        WordEntity(id = 35511, setId = 355, languagePair = "en-ru", rarity = "EPIC",
            original = "chronic inflammation", transliteration = "[ˈkrɒnɪk ˌɪnfləˈmeɪʃən]", translation = "хроническое воспаление",
            definition = "A slow, low-grade fire in the tissues that quietly damages organs over years.",
            definitionNative = "Медленный тлеющий процесс в тканях, тихо разрушающий органы годами.",
            example = "Belly fat fuels chronic inflammation across the whole body.",
            exampleNative = "Жир на животе подпитывает chronic inflammation по всему телу.",
            pos = "noun", semanticGroup = "health_pathology", isFillInBlankSafe = false),

        WordEntity(id = 35512, setId = 355, languagePair = "en-ru", rarity = "EPIC",
            original = "autoimmune disease", transliteration = "[ˌɔːtoʊɪˈmjuːn dɪˈziːz]", translation = "аутоиммунное заболевание",
            definition = "A disorder where the defence cells mistake the body's own tissues for invaders.",
            definitionNative = "Расстройство, при котором защитные клетки принимают свои ткани за чужаков.",
            example = "Lupus is the textbook example of an autoimmune disease.",
            exampleNative = "Волчанка — хрестоматийный пример autoimmune disease.",
            pos = "noun", semanticGroup = "health_pathology", isFillInBlankSafe = false),

        WordEntity(id = 35513, setId = 355, languagePair = "en-ru", rarity = "EPIC",
            original = "oxidative stress", transliteration = "[ˈɒksɪdeɪtɪv stres]", translation = "окислительный стресс",
            definition = "A chemical wear-and-tear when unstable molecules damage cell membranes and DNA.",
            definitionNative = "Химический износ, когда нестабильные молекулы повреждают мембраны клеток и ДНК.",
            example = "Heavy smoking drives oxidative stress in the lungs day after day.",
            exampleNative = "Тяжёлое курение нагнетает oxidative stress в лёгких изо дня в день.",
            pos = "noun", semanticGroup = "health_pathology", isFillInBlankSafe = false),

        WordEntity(id = 35514, setId = 355, languagePair = "en-ru", rarity = "EPIC",
            original = "metabolic syndrome", transliteration = "[ˌmetəˈbɒlɪk ˈsɪndroʊm]", translation = "метаболический синдром",
            definition = "A cluster of belly fat, high sugar and high pressure that warns of heart trouble.",
            definitionNative = "Сочетание жира на животе, высокого сахара и давления, предвещающее болезни сердца.",
            example = "His doctor flagged metabolic syndrome at the yearly check-up.",
            exampleNative = "Врач отметил metabolic syndrome на ежегодном осмотре.",
            pos = "noun", semanticGroup = "health_pathology", isFillInBlankSafe = false),

        WordEntity(id = 35515, setId = 355, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "sarcopenia", transliteration = "[ˌsɑːrkoʊˈpiːniə]", translation = "саркопения (возрастная потеря мышц)",
            definition = "An age-related loss of muscle mass that creeps in after the sixth decade.",
            definitionNative = "Возрастное уменьшение мышечной массы, подбирающееся после шестого десятка.",
            example = "Resistance training is the main shield against sarcopenia in old age.",
            exampleNative = "Силовой тренинг — главный щит от sarcopenia в старости.",
            pos = "noun", semanticGroup = "health_pathology", isFillInBlankSafe = false),

        // ── health_pharmacology (5) ───────────────────────────────────────────

        WordEntity(id = 35516, setId = 355, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "pharmacokinetics", transliteration = "[ˌfɑːrməkoʊkɪˈnetɪks]", translation = "фармакокинетика",
            definition = "The study of how a drug moves through the body — entry, spread, breakdown and exit.",
            definitionNative = "Наука о пути лекарства в теле: всасывание, распределение, расщепление и выведение.",
            example = "Liver failure dramatically alters the pharmacokinetics of many medicines.",
            exampleNative = "Печёночная недостаточность резко меняет pharmacokinetics многих лекарств.",
            pos = "noun", semanticGroup = "health_pharmacology", isFillInBlankSafe = false),

        WordEntity(id = 35517, setId = 355, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "bioavailability", transliteration = "[ˌbaɪoʊəˌveɪləˈbɪləti]", translation = "биодоступность",
            definition = "The share of a swallowed substance that actually reaches the bloodstream.",
            definitionNative = "Доля проглоченного вещества, реально достигающая кровотока.",
            example = "Taking iron with vitamin C raises its bioavailability noticeably.",
            exampleNative = "Приём железа с витамином C заметно повышает его bioavailability.",
            pos = "noun", semanticGroup = "health_pharmacology", isFillInBlankSafe = false),

        WordEntity(id = 35518, setId = 355, languagePair = "en-ru", rarity = "EPIC",
            original = "drug interaction", transliteration = "[drʌɡ ˌɪntərˈækʃən]", translation = "лекарственное взаимодействие",
            definition = "An effect when two medicines change each other's strength inside the body.",
            definitionNative = "Эффект, когда два лекарства меняют силу друг друга внутри организма.",
            example = "The pharmacist warned about a serious drug interaction with grapefruit juice.",
            exampleNative = "Фармацевт предупредил о серьёзном drug interaction с грейпфрутовым соком.",
            pos = "noun", semanticGroup = "health_pharmacology", isFillInBlankSafe = false),

        WordEntity(id = 35519, setId = 355, languagePair = "en-ru", rarity = "EPIC",
            original = "contraindication", transliteration = "[ˌkɒntrəˌɪndɪˈkeɪʃən]", translation = "противопоказание",
            definition = "A specific reason a treatment must not be given to a particular patient.",
            definitionNative = "Конкретная причина, по которой лечение нельзя назначать данному пациенту.",
            example = "Pregnancy is a clear contraindication for many strong antibiotics.",
            exampleNative = "Беременность — явное contraindication для многих сильных антибиотиков.",
            pos = "noun", semanticGroup = "health_pharmacology", isFillInBlankSafe = false),

        WordEntity(id = 35520, setId = 355, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "off-label use", transliteration = "[ˌɔːf ˈleɪbəl juːs]", translation = "применение вне инструкции",
            definition = "Prescribing a medicine for a problem not listed on its official paperwork.",
            definitionNative = "Назначение лекарства от проблемы, не указанной в его официальной инструкции.",
            example = "Doctors sometimes try off-label use of beta-blockers for stage fright.",
            exampleNative = "Врачи иногда пробуют off-label use бета-блокаторов от страха сцены.",
            pos = "noun", semanticGroup = "health_pharmacology", isFillInBlankSafe = false),

        // ── health_clinical (5) ───────────────────────────────────────────────

        WordEntity(id = 35521, setId = 355, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "randomized controlled trial", transliteration = "[ˈrændəmaɪzd kənˈtroʊld ˈtraɪəl]", translation = "рандомизированное контролируемое исследование",
            definition = "A gold-standard study where chance decides who gets the new drug or a dummy.",
            definitionNative = "Золотой стандарт исследования: случай решает, кто получит новое лекарство или пустышку.",
            example = "A well-run randomized controlled trial settled the old debate.",
            exampleNative = "Качественное randomized controlled trial разрешило давний спор.",
            pos = "noun", semanticGroup = "health_clinical", isFillInBlankSafe = false),

        WordEntity(id = 35522, setId = 355, languagePair = "en-ru", rarity = "EPIC",
            original = "placebo effect", transliteration = "[pləˈsiːboʊ ɪˈfekt]", translation = "эффект плацебо",
            definition = "A real bodily improvement caused by belief in a fake or empty treatment.",
            definitionNative = "Настоящее телесное улучшение, вызванное верой в фальшивое или пустое лечение.",
            example = "Pain studies must always account for the placebo effect.",
            exampleNative = "Исследования боли обязаны учитывать placebo effect.",
            pos = "noun", semanticGroup = "health_clinical", isFillInBlankSafe = false),

        WordEntity(id = 35523, setId = 355, languagePair = "en-ru", rarity = "EPIC",
            original = "evidence-based practice", transliteration = "[ˈevɪdəns beɪst ˈpræktɪs]", translation = "доказательная практика",
            definition = "Treating patients using only methods proven by careful published research.",
            definitionNative = "Лечение пациентов только методами, подтверждёнными аккуратными опубликованными работами.",
            example = "Modern hospitals are slowly switching to evidence-based practice.",
            exampleNative = "Современные больницы постепенно переходят на evidence-based practice.",
            pos = "noun", semanticGroup = "health_clinical", isFillInBlankSafe = false),

        WordEntity(id = 35524, setId = 355, languagePair = "en-ru", rarity = "EPIC",
            original = "longitudinal study", transliteration = "[ˌlɒnʤəˈtjuːdənəl ˈstʌdi]", translation = "лонгитюдное исследование",
            definition = "A research project that follows the same people for many years to watch changes.",
            definitionNative = "Исследовательский проект, наблюдающий за одними и теми же людьми много лет.",
            example = "A famous longitudinal study tracked nurses for over forty years.",
            exampleNative = "Знаменитое longitudinal study следило за медсёстрами более сорока лет.",
            pos = "noun", semanticGroup = "health_clinical", isFillInBlankSafe = false),

        WordEntity(id = 35525, setId = 355, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "biomarker", transliteration = "[ˈbaɪoʊˌmɑːrkər]", translation = "биомаркер",
            definition = "A measurable signal in blood or tissue that reflects a disease or its course.",
            definitionNative = "Измеримый сигнал в крови или ткани, отражающий болезнь или её течение.",
            example = "PSA is a useful biomarker for tracking prostate trouble in older men.",
            exampleNative = "ПСА — полезный biomarker для отслеживания проблем простаты у пожилых мужчин.",
            pos = "noun", semanticGroup = "health_clinical", isFillInBlankSafe = false),
    )
}
