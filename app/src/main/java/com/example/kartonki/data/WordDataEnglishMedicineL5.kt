package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Медицина (level 5, носитель языка).
 *
 * Set 323: «Медицина: носитель языка» — архаичная и узкоспециальная
 * медицинская лексика: эпонимы синдромов, латинизмы, архаичные диагнозы,
 * редкие клинические концепты и почти забытые процедуры (C2+).
 *
 * Распределение редкости: 21 LEGENDARY + 4 EPIC — два смежных уровня шкалы,
 * LEGENDARY преобладает (узкоспециальная и архаическая лексика).
 *
 * Дополняет уже существующие сеты темы «Медицина»:
 *   - Set 282 (WordDataEnglishBatch12.kt)        — L1 COMMON/UNCOMMON, ощущения и тело.
 *   - Set 254 (WordDataEnglishBatch4.kt)         — L2 COMMON/UNCOMMON, первая помощь.
 *   - Set 212 (WordDataEnglishExpanded.kt)       — L3 UNCOMMON/RARE, общая медицина.
 *   - Set 322 (WordDataEnglishMedicineL4.kt)     — L4 RARE/EPIC, клиническая терминология.
 *
 * Слова setId=323 не пересекаются ни с одним из перечисленных сетов
 * (проверено grep по всей директории data/).
 *
 * SemanticGroups (5 × 5):
 *   medicine_eponyms             — hashimoto, addisonian, cushingoid, parkinsonian, marfanoid
 *   medicine_latinisms           — pruritus, tenesmus, borborygmi, fasciculation, paresthesia
 *   medicine_archaic_diagnoses   — apoplexy, dropsy, phthisis, ague, scrofula
 *   medicine_rare_concepts       — iatrogenic, idiopathic, prodrome, sequela, pathognomonic
 *   medicine_rare_procedures     — venesection, trephination, phlebotomy, cautery, cupping
 *
 * Word IDs: 32301..32325 (setId × 100 + position).
 */
object WordDataEnglishMedicineL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 323, name = "Медицина",
            description = "Архаичная и узкоспециальная медицинская лексика: латинизмы, синдромы, эпонимы, редкая клиническая терминология",
            languagePair = "en-ru",
            topic = "Медицина", level = 5),
    )

    val words: List<WordEntity> = listOf(

        // ── medicine_eponyms (5) ──────────────────────────────────────────

        WordEntity(id = 32301, setId = 323, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hashimoto", transliteration = "[ˌhɑʃiˈmoʊtoʊ]", translation = "хашимото (аутоиммунный тиреоидит)",
            definition = "An autoimmune thyroid disease named after the Japanese doctor who described it.",
            definitionNative = "Аутоиммунная болезнь щитовидной железы, названная по имени описавшего её японского врача.",
            example = "Her hashimoto was finally diagnosed after years of unexplained fatigue.",
            exampleNative = "Её hashimoto был наконец поставлен после лет необъяснимой усталости.",
            pos = "noun", semanticGroup = "medicine_eponyms", fillInBlankExclusions = listOf(32306L, 32307L, 32309L, 32310L, 32312L, 32313L, 32314L, 32315L)),

        WordEntity(id = 32302, setId = 323, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "addisonian", transliteration = "[ˌædɪˈsoʊniən]", translation = "аддисоновский (связанный с надпочечниковой недостаточностью)",
            definition = "Tied to the adrenal failure first described by an English physician in the 1850s.",
            definitionNative = "Связанный с поражением надпочечников, впервые описанным английским врачом в 1850-х.",
            example = "The patient slipped into an addisonian crisis after stopping his steroids.",
            exampleNative = "Пациент впал в addisonian криз, прекратив приём стероидов.",
            pos = "adjective", semanticGroup = "medicine_eponyms", fillInBlankExclusions = listOf(32316L, 32317L)),

        WordEntity(id = 32303, setId = 323, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "cushingoid", transliteration = "[ˈkʊʃɪŋˌɔɪd]", translation = "кушингоидный (вид при избытке кортизола)",
            definition = "Looking like a patient with too much cortisol — round face, thin limbs, fatty belly.",
            definitionNative = "Похожий на больного с избытком кортизола: круглое лицо, тонкие конечности, жир на животе.",
            example = "Long steroid therapy left her with a clearly cushingoid appearance.",
            exampleNative = "Долгая терапия стероидами оставила её с явно cushingoid внешностью.",
            pos = "adjective", semanticGroup = "medicine_eponyms", fillInBlankExclusions = listOf(32302L, 32304L, 32305L, 32320L)),

        WordEntity(id = 32304, setId = 323, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "parkinsonian", transliteration = "[ˌpɑrkɪnˈsoʊniən]", translation = "паркинсонический (связанный с болезнью Паркинсона)",
            definition = "Marked by tremor, stiffness and slow movement of a known degenerative disease.",
            definitionNative = "Отмеченный дрожью, скованностью и медлительностью известного дегенеративного заболевания.",
            example = "The neurologist noted a clear parkinsonian gait during the brief examination.",
            exampleNative = "Невролог отметил явно parkinsonian походку во время краткого осмотра.",
            pos = "adjective", semanticGroup = "medicine_eponyms", fillInBlankExclusions = listOf(32302L, 32303L, 32305L, 32317L, 32320L)),

        WordEntity(id = 32305, setId = 323, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "marfanoid", transliteration = "[ˈmɑrfəˌnɔɪd]", translation = "марфаноидный (фенотип Марфана)",
            definition = "Looking like a Marfan patient — tall, slender, with very long fingers and limbs.",
            definitionNative = "Похожий на больного Марфана: высокий, худой, с очень длинными пальцами и конечностями.",
            example = "His marfanoid build prompted the cardiologist to order an echocardiogram.",
            exampleNative = "Его marfanoid телосложение заставило кардиолога назначить эхокардиографию.",
            pos = "adjective", semanticGroup = "medicine_eponyms", fillInBlankExclusions = listOf(32302L, 32303L, 32304L)),

        // ── medicine_latinisms (5) ────────────────────────────────────────

        WordEntity(id = 32306, setId = 323, languagePair = "en-ru", rarity = "EPIC",
            original = "pruritus", transliteration = "[prʊˈraɪtəs]", translation = "пруритус (медицинский зуд)",
            definition = "The medical name for an unpleasant skin sensation that makes you want to scratch.",
            definitionNative = "Медицинское название неприятного ощущения на коже, заставляющего расчёсывать её.",
            example = "Severe pruritus of the legs woke the elderly patient every night.",
            exampleNative = "Сильный pruritus ног будил пожилого пациента каждую ночь.",
            pos = "noun", semanticGroup = "medicine_latinisms", fillInBlankExclusions = listOf(32307L, 32308L, 32309L, 32310L, 32312L)),

        WordEntity(id = 32307, setId = 323, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "tenesmus", transliteration = "[təˈnɛzməs]", translation = "тенезмы (мучительные позывы)",
            definition = "A painful, useless urge to empty the bowel or bladder when nothing comes out.",
            definitionNative = "Болезненный и бесплодный позыв к опорожнению, когда ничего не выходит.",
            example = "Constant tenesmus was the most distressing symptom for the patient with colitis.",
            exampleNative = "Постоянный tenesmus был самым мучительным симптомом у пациента с колитом.",
            pos = "noun", semanticGroup = "medicine_latinisms", fillInBlankExclusions = listOf(32306L, 32308L, 32309L, 32310L)),

        WordEntity(id = 32308, setId = 323, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "borborygmi", transliteration = "[ˌbɔrbəˈrɪɡmaɪ]", translation = "борборигмы (урчание в животе)",
            definition = "The rumbling sounds made by gas and fluid moving through the gut.",
            definitionNative = "Урчащие звуки, возникающие при движении газа и жидкости в кишечнике.",
            example = "Loud borborygmi were audible across the small examination room.",
            exampleNative = "Громкие borborygmi были слышны через всю небольшую смотровую.",
            pos = "noun", semanticGroup = "medicine_latinisms", fillInBlankExclusions = listOf(32306L, 32307L, 32309L, 32310L)),

        WordEntity(id = 32309, setId = 323, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "fasciculation", transliteration = "[fəˌsɪkjəˈleɪʃən]", translation = "фасцикуляция (мышечное подёргивание)",
            definition = "A small, involuntary twitch of a few muscle fibres visible under the skin.",
            definitionNative = "Мелкое непроизвольное подёргивание группы мышечных волокон, заметное под кожей.",
            example = "The neurologist saw a fasciculation flicker across the patient's tongue.",
            exampleNative = "Невролог увидел, как fasciculation пробежала по языку пациента.",
            pos = "noun", semanticGroup = "medicine_latinisms", fillInBlankExclusions = listOf(32306L, 32307L, 32308L, 32310L)),

        WordEntity(id = 32310, setId = 323, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "paresthesia", transliteration = "[ˌpærəsˈθiʒə]", translation = "парестезия (покалывание/онемение)",
            definition = "An odd burning, tingling or pins-and-needles feeling in the skin.",
            definitionNative = "Странное жжение, покалывание или мурашки в коже без внешней причины.",
            example = "She reported paresthesia in both feet whenever she sat too long.",
            exampleNative = "Она жаловалась на paresthesia в обеих стопах при долгом сидении.",
            pos = "noun", semanticGroup = "medicine_latinisms", fillInBlankExclusions = listOf(32306L, 32307L, 32308L, 32309L, 32312L)),

        // ── medicine_archaic_diagnoses (5) ────────────────────────────────

        WordEntity(id = 32311, setId = 323, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "apoplexy", transliteration = "[ˈæpəˌplɛksi]", translation = "апоплексия (старое название инсульта)",
            definition = "An old word for a sudden stroke that left the patient stunned and paralysed.",
            definitionNative = "Старое слово для внезапного инсульта, валившего больного в оцепенение и паралич.",
            example = "The colonel was struck down by apoplexy at the dinner table that evening.",
            exampleNative = "Полковника свалила apoplexy за обеденным столом тем вечером.",
            pos = "noun", semanticGroup = "medicine_archaic_diagnoses", fillInBlankExclusions = listOf(32312L, 32313L, 32314L, 32315L)),

        WordEntity(id = 32312, setId = 323, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "dropsy", transliteration = "[ˈdrɑpsi]", translation = "водянка (устаревшее)",
            definition = "An old name for the body filling up with fluid — bloated belly and swollen legs.",
            definitionNative = "Старое название скопления жидкости в теле — раздутый живот и отёчные ноги.",
            example = "Old physicians blamed dropsy on a weakness of the heart and the kidneys.",
            exampleNative = "Старые врачи винили в dropsy слабость сердца и почек.",
            pos = "noun", semanticGroup = "medicine_archaic_diagnoses", fillInBlankExclusions = listOf(32311L, 32313L, 32314L, 32315L)),

        WordEntity(id = 32313, setId = 323, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "phthisis", transliteration = "[ˈθaɪsɪs]", translation = "фтиза (устаревшее: туберкулёз)",
            definition = "An archaic medical name for tuberculosis — wasting lungs and a dry cough.",
            definitionNative = "Архаическое медицинское название туберкулёза — истощение лёгких и сухой кашель.",
            example = "Romantic poets often died young of phthisis in damp northern cities.",
            exampleNative = "Поэты-романтики часто умирали молодыми от phthisis в сырых северных городах.",
            pos = "noun", semanticGroup = "medicine_archaic_diagnoses", fillInBlankExclusions = listOf(32311L, 32312L, 32314L, 32315L)),

        WordEntity(id = 32314, setId = 323, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "ague", transliteration = "[ˈeɪɡju]", translation = "лихоманка (устаревшее: малярийная лихорадка)",
            definition = "An old word for fever and shaking chills, usually meaning malaria.",
            definitionNative = "Старое слово для жара и трясущего озноба — обычно имели в виду малярию.",
            example = "Settlers in the marshland suffered ague every late summer.",
            exampleNative = "Поселенцы на болотах страдали ague каждое позднее лето.",
            pos = "noun", semanticGroup = "medicine_archaic_diagnoses", fillInBlankExclusions = listOf(32306L, 32311L, 32312L, 32313L, 32315L)),

        WordEntity(id = 32315, setId = 323, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "scrofula", transliteration = "[ˈskrɑfjələ]", translation = "скрофулёз (туберкулёз шейных лимфоузлов)",
            definition = "An old name for tuberculosis of the neck glands — kings were said to cure it by touch.",
            definitionNative = "Старое название туберкулёза шейных желёз — короли якобы исцеляли его прикосновением.",
            example = "Medieval kings touched the sick to drive out scrofula from their bodies.",
            exampleNative = "Средневековые короли касались больных, изгоняя scrofula из их тел.",
            pos = "noun", semanticGroup = "medicine_archaic_diagnoses", fillInBlankExclusions = listOf(32311L, 32312L, 32313L, 32314L)),

        // ── medicine_rare_concepts (5) ────────────────────────────────────

        WordEntity(id = 32316, setId = 323, languagePair = "en-ru", rarity = "EPIC",
            original = "iatrogenic", transliteration = "[aɪˌætrəˈʤɛnɪk]", translation = "ятрогенный (вызванный лечением)",
            definition = "Caused by the doctor or the treatment itself — harm born from medical care.",
            definitionNative = "Вызванный самим врачом или лечением — вред, рождённый медицинской помощью.",
            example = "The bleeding turned out to be an iatrogenic effect of a blood thinner.",
            exampleNative = "Кровотечение оказалось iatrogenic эффектом препарата для разжижения крови.",
            pos = "adjective", semanticGroup = "medicine_rare_concepts", fillInBlankExclusions = listOf(32317L)),

        WordEntity(id = 32317, setId = 323, languagePair = "en-ru", rarity = "EPIC",
            original = "idiopathic", transliteration = "[ˌɪdiəˈpæθɪk]", translation = "идиопатический (неясной причины)",
            definition = "Of unknown origin — the doctors cannot point to any specific cause.",
            definitionNative = "Невыясненного происхождения — врачи не могут указать никакой конкретной причины.",
            example = "After all the tests, the seizures were labelled idiopathic in the chart.",
            exampleNative = "После всех анализов приступы записали в карту как idiopathic.",
            pos = "adjective", semanticGroup = "medicine_rare_concepts", fillInBlankExclusions = listOf(32316L, 32320L)),

        WordEntity(id = 32318, setId = 323, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "prodrome", transliteration = "[ˈproʊˌdroʊm]", translation = "продром (предвестник болезни)",
            definition = "An early warning sign that comes before the full disease takes hold.",
            definitionNative = "Ранний тревожный знак, появляющийся до того, как болезнь развернётся.",
            example = "A faint visual aura served as the prodrome to her migraine attacks.",
            exampleNative = "Слабая зрительная аура служила prodrome перед её приступами мигрени.",
            pos = "noun", semanticGroup = "medicine_rare_concepts", fillInBlankExclusions = listOf(32319L)),

        WordEntity(id = 32319, setId = 323, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "sequela", transliteration = "[sɪˈkwilə]", translation = "секвела (последствие болезни)",
            definition = "A chronic problem that lingers after the acute illness is gone.",
            definitionNative = "Хроническая проблема, остающаяся после того, как острая болезнь миновала.",
            example = "Mild memory loss became a permanent sequela of the brain injury.",
            exampleNative = "Лёгкое снижение памяти стало стойкой sequela черепной травмы.",
            pos = "noun", semanticGroup = "medicine_rare_concepts", fillInBlankExclusions = listOf(32318L)),

        WordEntity(id = 32320, setId = 323, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "pathognomonic", transliteration = "[ˌpæθəɡnəˈmɑnɪk]", translation = "патогномоничный (специфический для болезни)",
            definition = "So specific to one disease that finding it alone confirms the diagnosis.",
            definitionNative = "Настолько специфичный для одной болезни, что его наличие сразу подтверждает диагноз.",
            example = "Koplik spots are pathognomonic for measles in a feverish child.",
            exampleNative = "Пятна Коплика — pathognomonic для кори у лихорадящего ребёнка.",
            pos = "adjective", semanticGroup = "medicine_rare_concepts", fillInBlankExclusions = listOf(32316L, 32317L)),

        // ── medicine_rare_procedures (5) ──────────────────────────────────

        WordEntity(id = 32321, setId = 323, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "venesection", transliteration = "[ˌvɛnəˈsɛkʃən]", translation = "венесекция (старинное кровопускание)",
            definition = "An old medical practice of cutting open a vein to release a measure of blood.",
            definitionNative = "Старинная медицинская практика — вскрытие вены и выпуск отмеренного объёма крови.",
            example = "Eighteenth-century doctors prescribed venesection for nearly every fever.",
            exampleNative = "Врачи восемнадцатого века назначали venesection почти при любой лихорадке.",
            pos = "noun", semanticGroup = "medicine_rare_procedures", fillInBlankExclusions = listOf(32322L, 32323L, 32324L, 32325L)),

        WordEntity(id = 32322, setId = 323, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "trephination", transliteration = "[ˌtrɛfɪˈneɪʃən]", translation = "трепанация (вскрытие черепа)",
            definition = "An ancient surgery of drilling a round hole through the bone of the skull.",
            definitionNative = "Древняя хирургическая операция — высверливание круглого отверстия в кости черепа.",
            example = "Neolithic skulls show survivors of crude trephination performed with flint blades.",
            exampleNative = "Неолитические черепа показывают выживших после грубой trephination кремнёвыми лезвиями.",
            pos = "noun", semanticGroup = "medicine_rare_procedures", fillInBlankExclusions = listOf(32321L, 32323L, 32324L, 32325L)),

        WordEntity(id = 32323, setId = 323, languagePair = "en-ru", rarity = "EPIC",
            original = "phlebotomy", transliteration = "[fləˈbɑtəmi]", translation = "флеботомия (взятие крови из вены)",
            definition = "The medical procedure of drawing blood from a vein with a needle.",
            definitionNative = "Медицинская процедура забора крови из вены при помощи иглы.",
            example = "The morning rounds began with phlebotomy on every patient in the ward.",
            exampleNative = "Утренний обход начинался с phlebotomy у каждого пациента в палате.",
            pos = "noun", semanticGroup = "medicine_rare_procedures", fillInBlankExclusions = listOf(32321L, 32322L, 32324L, 32325L)),

        WordEntity(id = 32324, setId = 323, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "cautery", transliteration = "[ˈkɔtəri]", translation = "каутер (прижигание раны)",
            definition = "Old surgical practice of burning tissue with a hot iron to seal a wound.",
            definitionNative = "Старая хирургическая практика — прижигание ткани раскалённым железом для закрытия раны.",
            example = "Battlefield surgeons stopped heavy bleeding with red-hot cautery on the spot.",
            exampleNative = "Полевые хирурги останавливали сильное кровотечение раскалённым cautery на месте.",
            pos = "noun", semanticGroup = "medicine_rare_procedures", fillInBlankExclusions = listOf(32321L, 32322L, 32323L, 32325L)),

        WordEntity(id = 32325, setId = 323, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "cupping", transliteration = "[ˈkʌpɪŋ]", translation = "баночная терапия (старинное лечение)",
            definition = "An old healing practice of pressing heated glass cups onto the skin to draw out illness.",
            definitionNative = "Старинная лечебная практика — наложение нагретых стеклянных банок на кожу, чтобы «вытянуть» болезнь.",
            example = "Folk healers in remote villages still rely on cupping for stubborn back pain.",
            exampleNative = "Народные целители в глухих деревнях всё ещё применяют cupping при упорной боли в спине.",
            pos = "noun", semanticGroup = "medicine_rare_procedures", fillInBlankExclusions = listOf(32321L, 32322L, 32323L, 32324L)),
    )
}
