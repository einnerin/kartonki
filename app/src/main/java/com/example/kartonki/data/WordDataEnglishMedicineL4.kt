package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Медицина (level 4, профессиональный).
 *
 * Set 322: «Медицина» — клиническая терминология, как звучит на врачебной
 * пятиминутке: диагностические методы, патология, клинические признаки,
 * неотложные состояния и фармакологические понятия (L4 / RARE+EPIC).
 *
 * Распределение редкости: 15 EPIC + 10 RARE — два смежных уровня шкалы,
 * EPIC преобладает (узкоспециальная клиническая лексика).
 *
 * Дополняет уже существующие сеты темы «Медицина»:
 *   - Set 282 (WordDataEnglishBatch12.kt)   — L1 COMMON/UNCOMMON, ощущения и тело
 *                                             (sneeze, dizzy, sore, faint, twitch).
 *   - Set 254 (WordDataEnglishBatch4.kt)    — L2 COMMON/UNCOMMON, первая помощь
 *                                             (first aid, stretcher, plaster, CPR).
 *   - Set 212 (WordDataEnglishExpanded.kt)  — L3 UNCOMMON/RARE, общая медицина
 *                                             (diagnosis, abscess, fracture, tumour).
 *
 * Слова setId=322 не пересекаются ни с одним из перечисленных сетов
 * (проверено grep по всей директории data/).
 *
 * SemanticGroups (5 × 5):
 *   medicine_diagnosis        — anamnesis, auscultation, palpation, biopsy, prognosis
 *   medicine_pathology        — pathology, etiology, lesion, neoplasm, atrophy
 *   medicine_symptoms         — syncope, dyspnea, edema, effusion, hypoxia
 *   medicine_pathophysiology  — sepsis, ischemia, embolism, hematoma, malignant
 *   medicine_clinical         — anaesthesia, palliative, prophylactic, contraindication, comorbidity
 *
 * Word IDs: 32201..32225 (setId × 100 + position).
 */
object WordDataEnglishMedicineL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 322, name = "Медицина",
            description = "Клиническая терминология: диагностика, патология, лечение, медицинский жаргон",
            languagePair = "en-ru",
            topic = "Медицина", level = 4),
    )

    val words: List<WordEntity> = listOf(

        // ── medicine_diagnosis (5) ────────────────────────────────────────

        WordEntity(id = 32201, setId = 322, languagePair = "en-ru", rarity = "EPIC",
            original = "anamnesis", transliteration = "[ˌænəmˈnisɪs]", translation = "анамнез",
            definition = "The patient's history of illness gathered before any examination.",
            definitionNative = "История болезни пациента, собираемая до начала осмотра.",
            example = "A careful anamnesis revealed two episodes of chest pain last winter.",
            exampleNative = "Тщательный anamnesis выявил два эпизода боли в груди прошлой зимой.",
            pos = "noun", semanticGroup = "medicine_diagnosis", fillInBlankExclusions = listOf(32202L, 32203L, 32204L, 32205L)),

        WordEntity(id = 32202, setId = 322, languagePair = "en-ru", rarity = "EPIC",
            original = "auscultation", transliteration = "[ˌɔskəlˈteɪʃən]", translation = "аускультация",
            definition = "Listening to internal body sounds, usually through a stethoscope.",
            definitionNative = "Выслушивание внутренних звуков тела — обычно через стетоскоп.",
            example = "Auscultation of the lower lobe revealed coarse crackles on inspiration.",
            exampleNative = "Auscultation нижней доли выявила грубые хрипы на вдохе.",
            pos = "noun", semanticGroup = "medicine_diagnosis", fillInBlankExclusions = listOf(32201L, 32203L, 32204L, 32205L)),

        WordEntity(id = 32203, setId = 322, languagePair = "en-ru", rarity = "RARE",
            original = "palpation", transliteration = "[pælˈpeɪʃən]", translation = "пальпация",
            definition = "Examining a patient by feeling the body with the hands.",
            definitionNative = "Обследование пациента ощупыванием рукой через кожу.",
            example = "Deep palpation of the abdomen elicited tenderness in the right lower quadrant.",
            exampleNative = "Глубокая palpation живота вызвала болезненность в правой подвздошной области.",
            pos = "noun", semanticGroup = "medicine_diagnosis", fillInBlankExclusions = listOf(32201L, 32202L, 32204L, 32205L)),

        WordEntity(id = 32204, setId = 322, languagePair = "en-ru", rarity = "RARE",
            original = "biopsy", transliteration = "[ˈbaɪˌɑpsi]", translation = "биопсия",
            definition = "Taking a small tissue sample from a patient for laboratory study.",
            definitionNative = "Забор маленького образца ткани у пациента для лабораторного изучения.",
            example = "The dermatologist sent a punch biopsy of the suspicious mole to histology.",
            exampleNative = "Дерматолог отправил biopsy подозрительной родинки на гистологию.",
            pos = "noun", semanticGroup = "medicine_diagnosis", fillInBlankExclusions = listOf(32201L, 32202L, 32203L, 32205L)),

        WordEntity(id = 32205, setId = 322, languagePair = "en-ru", rarity = "RARE",
            original = "prognosis", transliteration = "[prɑɡˈnoʊsɪs]", translation = "прогноз (исхода болезни)",
            definition = "A medical forecast of how a disease is likely to develop and end.",
            definitionNative = "Медицинский прогноз: как болезнь, вероятно, будет развиваться и чем закончится.",
            example = "Without surgery the prognosis remains poor over the next two years.",
            exampleNative = "Без операции prognosis остаётся неблагоприятным в ближайшие два года.",
            pos = "noun", semanticGroup = "medicine_diagnosis", fillInBlankExclusions = listOf(32201L, 32202L, 32203L, 32204L)),

        // ── medicine_pathology (5) ────────────────────────────────────────

        WordEntity(id = 32206, setId = 322, languagePair = "en-ru", rarity = "RARE",
            original = "pathology", transliteration = "[pəˈθɑləʤi]", translation = "патология (раздел медицины; пат. процесс)",
            definition = "The branch of medicine that studies disease processes in tissues.",
            definitionNative = "Раздел медицины, изучающий болезненные процессы в тканях.",
            example = "The pathology report confirmed a low-grade adenocarcinoma.",
            exampleNative = "Заключение pathology подтвердило аденокарциному низкой степени.",
            pos = "noun", semanticGroup = "medicine_pathology", fillInBlankExclusions = listOf(32204L, 32207L, 32208L, 32209L, 32210L)),

        WordEntity(id = 32207, setId = 322, languagePair = "en-ru", rarity = "EPIC",
            original = "etiology", transliteration = "[ˌitiˈɑləʤi]", translation = "этиология (причина болезни)",
            definition = "The set of causes that gave rise to a disease in a particular patient.",
            definitionNative = "Совокупность причин, вызвавших болезнь у конкретного пациента.",
            example = "The etiology of the fever remained unclear after a week of tests.",
            exampleNative = "Etiology лихорадки оставалась неясной после недели обследований.",
            pos = "noun", semanticGroup = "medicine_pathology", fillInBlankExclusions = listOf(32201L, 32205L, 32206L, 32208L, 32209L, 32210L)),

        WordEntity(id = 32208, setId = 322, languagePair = "en-ru", rarity = "RARE",
            original = "lesion", transliteration = "[ˈliʒən]", translation = "очаг поражения",
            definition = "An area of damaged tissue caused by injury or disease.",
            definitionNative = "Участок повреждённой ткани, возникший из-за травмы или болезни.",
            example = "A small hyperintense lesion was visible on the right hemisphere.",
            exampleNative = "На правом полушарии виднелся небольшой гиперинтенсивный lesion.",
            pos = "noun", semanticGroup = "medicine_pathology", fillInBlankExclusions = listOf(32206L, 32207L, 32209L, 32210L, 32219L)),

        WordEntity(id = 32209, setId = 322, languagePair = "en-ru", rarity = "EPIC",
            original = "neoplasm", transliteration = "[ˈniəˌplæzəm]", translation = "новообразование",
            definition = "A new and abnormal growth of tissue, either benign or cancerous.",
            definitionNative = "Новый и атипичный рост ткани — доброкачественный или злокачественный.",
            example = "The colonoscopy detected a small neoplasm in the descending colon.",
            exampleNative = "Колоноскопия выявила небольшое neoplasm в нисходящей ободочной кишке.",
            pos = "noun", semanticGroup = "medicine_pathology", fillInBlankExclusions = listOf(32206L, 32207L, 32208L, 32210L, 32219L)),

        WordEntity(id = 32210, setId = 322, languagePair = "en-ru", rarity = "RARE",
            original = "atrophy", transliteration = "[ˈætrəfi]", translation = "атрофия",
            definition = "Wasting away of an organ or tissue from disuse or disease.",
            definitionNative = "Уменьшение и истощение органа или ткани из-за бездействия или болезни.",
            example = "Disuse atrophy of the calf muscle developed after eight weeks in plaster.",
            exampleNative = "Atrophy икроножной мышцы от бездействия развилась за восемь недель в гипсе.",
            pos = "noun", semanticGroup = "medicine_pathology", fillInBlankExclusions = listOf(32206L, 32207L, 32208L, 32209L)),

        // ── medicine_symptoms (5) ─────────────────────────────────────────

        WordEntity(id = 32211, setId = 322, languagePair = "en-ru", rarity = "EPIC",
            original = "syncope", transliteration = "[ˈsɪŋkəpi]", translation = "синкопе (обморок)",
            definition = "A brief loss of consciousness caused by a drop in blood flow to the brain.",
            definitionNative = "Кратковременная потеря сознания из-за падения кровотока в мозге.",
            example = "The patient described two episodes of syncope while standing in line.",
            exampleNative = "Пациент описал два эпизода syncope при стоянии в очереди.",
            pos = "noun", semanticGroup = "medicine_symptoms", fillInBlankExclusions = listOf(32212L, 32213L, 32214L, 32215L, 32216L, 32217L)),

        WordEntity(id = 32212, setId = 322, languagePair = "en-ru", rarity = "EPIC",
            original = "dyspnea", transliteration = "[dɪspˈniə]", translation = "диспноэ (одышка)",
            definition = "Difficult or laboured breathing, felt as shortness of air.",
            definitionNative = "Затруднённое или напряжённое дыхание, ощущаемое как нехватка воздуха.",
            example = "The patient complained of dyspnea on exertion climbing one flight of stairs.",
            exampleNative = "Пациент жаловался на dyspnea при подъёме на один лестничный пролёт.",
            pos = "noun", semanticGroup = "medicine_symptoms", fillInBlankExclusions = listOf(32211L, 32213L, 32214L, 32215L, 32219L)),

        WordEntity(id = 32213, setId = 322, languagePair = "en-ru", rarity = "EPIC",
            original = "edema", transliteration = "[ɪˈdimə]", translation = "отёк (медицинский)",
            definition = "Excess fluid trapped in body tissues, making them swell.",
            definitionNative = "Избыток жидкости в тканях организма, приводящий к их набуханию.",
            example = "Pitting edema of both ankles suggested decompensated heart failure.",
            exampleNative = "Едема обеих лодыжек с ямкой при надавливании указывала на декомпенсацию сердечной недостаточности.",
            pos = "noun", semanticGroup = "medicine_symptoms", fillInBlankExclusions = listOf(32211L, 32212L, 32214L, 32215L)),

        WordEntity(id = 32214, setId = 322, languagePair = "en-ru", rarity = "EPIC",
            original = "effusion", transliteration = "[ɪˈfjuʒən]", translation = "выпот",
            definition = "An abnormal collection of fluid inside a body cavity, like the pleura.",
            definitionNative = "Аномальное скопление жидкости в полости тела — например, в плевральной.",
            example = "Chest X-ray revealed a moderate left pleural effusion.",
            exampleNative = "Рентген грудной клетки выявил умеренный плевральный effusion слева.",
            pos = "noun", semanticGroup = "medicine_symptoms", fillInBlankExclusions = listOf(32208L, 32209L, 32211L, 32212L, 32213L, 32215L, 32219L)),

        WordEntity(id = 32215, setId = 322, languagePair = "en-ru", rarity = "EPIC",
            original = "hypoxia", transliteration = "[haɪˈpɑksiə]", translation = "гипоксия",
            definition = "A state where tissues do not receive enough oxygen for normal function.",
            definitionNative = "Состояние, когда ткани не получают достаточно кислорода для нормальной работы.",
            example = "Profound hypoxia developed after the airway became partially obstructed.",
            exampleNative = "Глубокая hypoxia развилась после частичного нарушения проходимости дыхательных путей.",
            pos = "noun", semanticGroup = "medicine_symptoms", fillInBlankExclusions = listOf(32211L, 32212L, 32213L, 32214L)),

        // ── medicine_pathophysiology (5) ──────────────────────────────────

        WordEntity(id = 32216, setId = 322, languagePair = "en-ru", rarity = "RARE",
            original = "sepsis", transliteration = "[ˈsɛpsɪs]", translation = "сепсис",
            definition = "Body-wide inflammation triggered by an infection that overwhelms the patient.",
            definitionNative = "Системное воспаление, вызванное инфекцией и подавляющее состояние пациента.",
            example = "The patient was transferred to intensive care with suspected sepsis.",
            exampleNative = "Пациента перевели в реанимацию с подозрением на sepsis.",
            pos = "noun", semanticGroup = "medicine_pathophysiology", fillInBlankExclusions = listOf(32206L, 32208L, 32209L, 32211L, 32214L, 32215L, 32217L, 32218L, 32219L, 32224L, 32225L)),

        WordEntity(id = 32217, setId = 322, languagePair = "en-ru", rarity = "EPIC",
            original = "ischemia", transliteration = "[ɪˈskimiə]", translation = "ишемия",
            definition = "An insufficient blood supply to a tissue, threatening it with damage.",
            definitionNative = "Недостаточное кровоснабжение ткани, угрожающее её повреждением.",
            example = "ECG changes pointed to acute myocardial ischemia of the inferior wall.",
            exampleNative = "Изменения на ЭКГ указывали на острую миокардиальную ischemia нижней стенки.",
            pos = "noun", semanticGroup = "medicine_pathophysiology", fillInBlankExclusions = listOf(32208L, 32209L, 32213L, 32215L, 32216L, 32218L, 32219L)),

        WordEntity(id = 32218, setId = 322, languagePair = "en-ru", rarity = "EPIC",
            original = "embolism", transliteration = "[ˈɛmbəˌlɪzəm]", translation = "эмболия",
            definition = "Sudden blocking of a vessel by a clot or air bubble carried in the blood.",
            definitionNative = "Внезапная закупорка сосуда сгустком или пузырьком воздуха, принесённым кровью.",
            example = "Pulmonary embolism was confirmed on CT angiography of the chest.",
            exampleNative = "Лёгочная embolism была подтверждена на КТ-ангиографии грудной клетки.",
            pos = "noun", semanticGroup = "medicine_pathophysiology", fillInBlankExclusions = listOf(32208L, 32209L, 32213L, 32214L, 32216L, 32217L, 32219L)),

        WordEntity(id = 32219, setId = 322, languagePair = "en-ru", rarity = "RARE",
            original = "hematoma", transliteration = "[ˌhiməˈtoʊmə]", translation = "гематома",
            definition = "A collection of clotted blood that has leaked outside the vessels into tissue.",
            definitionNative = "Скопление свернувшейся крови, вышедшей из сосудов в окружающие ткани.",
            example = "A subdural hematoma was drained through a small burr-hole craniotomy.",
            exampleNative = "Субдуральная hematoma была дренирована через небольшое фрезевое отверстие.",
            pos = "noun", semanticGroup = "medicine_pathophysiology", fillInBlankExclusions = listOf(32208L, 32214L, 32216L, 32217L, 32218L)),

        WordEntity(id = 32220, setId = 322, languagePair = "en-ru", rarity = "RARE",
            original = "malignant", transliteration = "[məˈlɪɡnənt]", translation = "злокачественный",
            definition = "Cancerous and likely to invade surrounding tissue or spread elsewhere.",
            definitionNative = "Раковый, склонный прорастать в окружающие ткани и давать отдалённые очаги.",
            example = "Histology confirmed the malignant nature of the resected nodule.",
            exampleNative = "Гистология подтвердила malignant природу удалённого узла.",
            pos = "adjective", semanticGroup = "medicine_pathophysiology"),

        // ── medicine_clinical (5) ─────────────────────────────────────────

        WordEntity(id = 32221, setId = 322, languagePair = "en-ru", rarity = "RARE",
            original = "anaesthesia", transliteration = "[ˌænəsˈθiʒə]", translation = "анестезия",
            definition = "Loss of sensation produced by drugs so that surgery can be performed painlessly.",
            definitionNative = "Утрата чувствительности, вызванная препаратами, чтобы провести операцию без боли.",
            example = "General anaesthesia was induced with propofol and maintained with sevoflurane.",
            exampleNative = "Общая anaesthesia была индуцирована пропофолом и поддерживалась севофлураном.",
            pos = "noun", semanticGroup = "medicine_clinical", fillInBlankExclusions = listOf(32224L, 32225L)),

        WordEntity(id = 32222, setId = 322, languagePair = "en-ru", rarity = "EPIC",
            original = "palliative", transliteration = "[ˈpæliətɪv]", translation = "паллиативный",
            definition = "Aimed at relieving suffering rather than curing the underlying disease.",
            definitionNative = "Направленный на облегчение страданий, а не на излечение основной болезни.",
            example = "The team shifted to palliative care once further treatment proved futile.",
            exampleNative = "Команда перешла на palliative помощь, когда дальнейшее лечение оказалось бесполезным.",
            pos = "adjective", semanticGroup = "medicine_clinical", fillInBlankExclusions = listOf(32223L)),

        WordEntity(id = 32223, setId = 322, languagePair = "en-ru", rarity = "EPIC",
            original = "prophylactic", transliteration = "[ˌproʊfəˈlæktɪk]", translation = "профилактический",
            definition = "Given to prevent a disease before it has had a chance to develop.",
            definitionNative = "Назначаемый для предупреждения болезни до того, как она успеет развиться.",
            example = "The surgeon ordered prophylactic antibiotics one hour before the incision.",
            exampleNative = "Хирург назначил prophylactic антибиотики за час до разреза.",
            pos = "adjective", semanticGroup = "medicine_clinical", fillInBlankExclusions = listOf(32222L)),

        WordEntity(id = 32224, setId = 322, languagePair = "en-ru", rarity = "EPIC",
            original = "contraindication", transliteration = "[ˌkɑntrəˌɪndəˈkeɪʃən]", translation = "противопоказание",
            definition = "A condition that makes a particular treatment unsafe for the patient.",
            definitionNative = "Состояние, при котором конкретное лечение небезопасно для пациента.",
            example = "Active gastrointestinal bleeding is a contraindication to anticoagulation.",
            exampleNative = "Активное желудочно-кишечное кровотечение — contraindication к антикоагуляции.",
            pos = "noun", semanticGroup = "medicine_clinical", fillInBlankExclusions = listOf(32225L)),

        WordEntity(id = 32225, setId = 322, languagePair = "en-ru", rarity = "EPIC",
            original = "comorbidity", transliteration = "[ˌkoʊmɔrˈbɪdəti]", translation = "коморбидность (сопутствующая патология)",
            definition = "Another disease present in the same patient alongside the main diagnosis.",
            definitionNative = "Другое заболевание, имеющееся у пациента наряду с основным диагнозом.",
            example = "Diabetes is a frequent comorbidity in patients admitted for heart failure.",
            exampleNative = "Диабет — частая comorbidity у пациентов, госпитализированных по поводу сердечной недостаточности.",
            pos = "noun", semanticGroup = "medicine_clinical", fillInBlankExclusions = listOf(32206L, 32207L, 32221L, 32224L)),
    )
}
