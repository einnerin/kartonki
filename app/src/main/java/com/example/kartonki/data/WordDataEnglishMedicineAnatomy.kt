package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — set 462.
 * Медицина: внутренние органы и анатомические системы (L3 / RARE + EPIC).
 *
 * Расширение темы «Медицина». Дополняет:
 *   - 3   (L1) — внешние части тела (head, eye, arm, leg).
 *   - 12  (L1) — здоровье и общая медицина.
 *   - 30, 254, 282 (L2) — питание, первая помощь, ощущения.
 *   - 212 (L3) — общая медицина: диагноз, перелом, симптом, опухоль.
 *   - 322 (L4) — клиническая терминология (диагностика, патология).
 *   - 323 (L5) — латинизмы, синдромы, эпонимы.
 *
 * Подтема — анатомия человека: внутренние органы и системы тела.
 * Пять семантических групп по системам организма:
 *   medicine_anatomy_digestive    — liver, pancreas, gallbladder, esophagus, duodenum, intestine
 *   medicine_anatomy_respiratory  — trachea, larynx, pharynx, bronchus, alveolus
 *   medicine_anatomy_circulatory  — artery, vein, aorta, ventricle, capillary
 *   medicine_anatomy_urogenital   — kidney, bladder, urethra, ovary, uterus
 *   medicine_anatomy_endocrine    — thyroid, adrenal, pituitary, gland
 *
 * Дубли atrium/ligament/cartilage/neuron/appendix уже заняты другими сетами
 * (setId=211 architecture, 212 medicine, 354 fitness, 55 science) — исключены.
 *
 * Word IDs: 46201..46225 (setId × 100 + position).
 */
object WordDataEnglishMedicineAnatomy {

    val sets = listOf(
        WordSetEntity(
            id = 462,
            name = "Медицина",
            description = "Внутренние органы и системы тела: liver, kidney, trachea, aorta",
            languagePair = "en-ru",
            orderIndex = 462,
            topic = "Медицина",
            level = 3,
        ),
    )

    val words = listOf(

        // ── medicine_anatomy_digestive (пищеварительная система) ──────────────
        WordEntity(
            id = 46201, original = "liver", transliteration = "[ˈlɪvər]", translation = "печень",
            definition = "The large brown organ on the right side that filters blood and processes nutrients.",
            definitionNative = "Большой бурый орган справа: фильтрует кровь и перерабатывает питательные вещества.",
            example = "My grandfather had to quit drinking after his liver started failing.",
            exampleNative = "Дедушке пришлось бросить пить, когда его liver начала отказывать.",
            rarity = "RARE", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_digestive", fillInBlankExclusions = listOf(46202L, 46203L, 46204L, 46205L, 46206L)),
        WordEntity(
            id = 46202, original = "pancreas", transliteration = "[ˈpæŋkriəs]", translation = "поджелудочная железа",
            definition = "A flat gland behind the stomach that releases insulin and digestive juices.",
            definitionNative = "Плоская железа за желудком: выделяет инсулин и пищеварительные соки.",
            example = "Diabetes develops when the pancreas stops producing enough insulin.",
            exampleNative = "Диабет развивается, когда pancreas перестаёт производить достаточно инсулина.",
            rarity = "RARE", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_digestive", fillInBlankExclusions = listOf(46201L, 46203L, 46204L, 46205L, 46206L)),
        WordEntity(
            id = 46203, original = "gallbladder", transliteration = "[ˈɡɔːlblædər]", translation = "жёлчный пузырь",
            definition = "A small pear-shaped sac under the liver that stores bile for digesting fat.",
            definitionNative = "Маленький грушевидный мешочек под печенью: хранит жёлчь для переваривания жира.",
            example = "After the attack, doctors removed her gallbladder the next morning.",
            exampleNative = "После приступа врачи удалили её gallbladder уже на следующее утро.",
            rarity = "RARE", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_digestive", fillInBlankExclusions = listOf(46201L, 46202L, 46204L, 46205L, 46206L)),
        WordEntity(
            id = 46204, original = "esophagus", transliteration = "[ɪˈsɒfəɡəs]", translation = "пищевод",
            definition = "A muscular tube that pushes swallowed food from the throat down to the stomach.",
            definitionNative = "Мышечная трубка: проталкивает проглоченную еду от горла к желудку.",
            example = "Acid reflux burns the lining of the esophagus over time.",
            exampleNative = "Изжога со временем обжигает слизистую esophagus.",
            rarity = "RARE", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_digestive", fillInBlankExclusions = listOf(46201L, 46202L, 46203L, 46205L, 46206L)),
        WordEntity(
            id = 46205, original = "duodenum", transliteration = "[ˌdjuːəˈdiːnəm]", translation = "двенадцатиперстная кишка",
            definition = "The short first section of the small bowel where food meets bile and pancreatic juice.",
            definitionNative = "Короткий первый отдел тонкой кишки: там еда смешивается с жёлчью и панкреатическим соком.",
            example = "An ulcer in the duodenum often causes pain a few hours after eating.",
            exampleNative = "Язва в duodenum часто болит через пару часов после еды.",
            rarity = "EPIC", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_digestive", fillInBlankExclusions = listOf(46201L, 46202L, 46203L, 46204L, 46206L)),
        WordEntity(
            id = 46206, original = "intestine", transliteration = "[ɪnˈtestɪn]", translation = "кишечник",
            definition = "The long coiled tube below the stomach that absorbs nutrients from food.",
            definitionNative = "Длинная свёрнутая трубка под желудком: всасывает питательные вещества из еды.",
            example = "Most of the iron from food gets absorbed in the small intestine.",
            exampleNative = "Большая часть железа из еды всасывается в тонком intestine.",
            rarity = "RARE", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_digestive", fillInBlankExclusions = listOf(46201L, 46202L, 46203L, 46204L, 46205L)),

        // ── medicine_anatomy_respiratory (дыхательная система) ────────────────
        WordEntity(
            id = 46207, original = "trachea", transliteration = "[trəˈkiːə]", translation = "трахея",
            definition = "The stiff tube of cartilage rings that carries air from the throat into the lungs.",
            definitionNative = "Жёсткая трубка из хрящевых колец: проводит воздух из горла в лёгкие.",
            example = "The surgeon cut a small hole in the trachea to help him breathe.",
            exampleNative = "Хирург проделал маленькое отверстие в trachea, чтобы помочь ему дышать.",
            rarity = "RARE", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_respiratory", fillInBlankExclusions = listOf(46208L, 46209L, 46210L, 46211L)),
        WordEntity(
            id = 46208, original = "larynx", transliteration = "[ˈlærɪŋks]", translation = "гортань",
            definition = "The voice box at the top of the windpipe that vibrates to produce sound.",
            definitionNative = "Голосовой аппарат в верхней части дыхательной трубки: вибрирует, чтобы создавать звук.",
            example = "Heavy smoking can lead to cancer of the larynx.",
            exampleNative = "Сильное курение может привести к раку larynx.",
            rarity = "RARE", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_respiratory", fillInBlankExclusions = listOf(46207L, 46209L, 46210L, 46211L)),
        WordEntity(
            id = 46209, original = "pharynx", transliteration = "[ˈfærɪŋks]", translation = "глотка",
            definition = "The cavity behind the mouth where food and air paths cross before splitting.",
            definitionNative = "Полость за ртом: там пересекаются пути еды и воздуха, прежде чем разойтись.",
            example = "The infection started in the pharynx and spread to the ears.",
            exampleNative = "Инфекция началась в pharynx и распространилась на уши.",
            rarity = "EPIC", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_respiratory", fillInBlankExclusions = listOf(46207L, 46208L, 46210L, 46211L)),
        WordEntity(
            id = 46210, original = "bronchus", transliteration = "[ˈbrɒŋkəs]", translation = "бронх",
            definition = "One of the two main airways that branch off the windpipe into each lung.",
            definitionNative = "Один из двух главных воздухоносных путей: отходят от дыхательной трубки в каждое лёгкое.",
            example = "The CT scan showed a tumor blocking the right bronchus.",
            exampleNative = "Компьютерная томография показала опухоль, перекрывшую правый bronchus.",
            rarity = "EPIC", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_respiratory", fillInBlankExclusions = listOf(46207L, 46208L, 46209L, 46211L)),
        WordEntity(
            id = 46211, original = "alveolus", transliteration = "[ælˈviːələs]", translation = "альвеола",
            definition = "A tiny air sac deep in the lungs where oxygen passes into the blood.",
            definitionNative = "Крошечный воздушный мешочек в глубине лёгких: там кислород переходит в кровь.",
            example = "Each alveolus is wrapped in a fine net of capillaries.",
            exampleNative = "Каждая alveolus оплетена тонкой сеточкой капилляров.",
            rarity = "EPIC", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_respiratory", fillInBlankExclusions = listOf(46207L, 46208L, 46209L, 46210L)),

        // ── medicine_anatomy_circulatory (кровеносная система) ────────────────
        WordEntity(
            id = 46212, original = "artery", transliteration = "[ˈɑːrtəri]", translation = "артерия",
            definition = "A thick-walled vessel that carries oxygen-rich blood away from the heart.",
            definitionNative = "Толстостенный сосуд: несёт кровь, насыщенную кислородом, от сердца.",
            example = "A blocked artery in the brain caused his stroke.",
            exampleNative = "Закупоренная artery в мозге вызвала у него инсульт.",
            rarity = "RARE", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_circulatory", fillInBlankExclusions = listOf(46213L, 46214L, 46215L, 46216L)),
        WordEntity(
            id = 46213, original = "vein", transliteration = "[veɪn]", translation = "вена",
            definition = "A thin-walled vessel that returns used blood from the body back to the heart.",
            definitionNative = "Тонкостенный сосуд: возвращает использованную кровь от тела к сердцу.",
            example = "The nurse struggled to find a good vein for the IV.",
            exampleNative = "Медсестре было трудно найти подходящую vein для капельницы.",
            rarity = "RARE", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_circulatory", fillInBlankExclusions = listOf(46212L, 46214L, 46215L, 46216L)),
        WordEntity(
            id = 46214, original = "aorta", transliteration = "[eɪˈɔːrtə]", translation = "аорта",
            definition = "The largest vessel in the body, leaving the heart and feeding all major branches.",
            definitionNative = "Самый крупный сосуд в теле: выходит из сердца и питает все главные ветви.",
            example = "A tear in the aorta is a medical emergency.",
            exampleNative = "Разрыв aorta — это экстренное состояние, требующее срочной помощи.",
            rarity = "EPIC", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_circulatory", fillInBlankExclusions = listOf(46212L, 46213L, 46215L, 46216L)),
        WordEntity(
            id = 46215, original = "ventricle", transliteration = "[ˈventrɪkəl]", translation = "желудочек (сердца)",
            definition = "One of the two lower chambers of the heart that pumps blood out under pressure.",
            definitionNative = "Одна из двух нижних камер сердца: выталкивает кровь под давлением.",
            example = "The left ventricle does most of the pumping work.",
            exampleNative = "Левый ventricle выполняет основную работу по перекачке крови.",
            rarity = "EPIC", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_circulatory", fillInBlankExclusions = listOf(46212L, 46213L, 46214L, 46216L)),
        WordEntity(
            id = 46216, original = "capillary", transliteration = "[ˈkæpɪleri]", translation = "капилляр",
            definition = "A microscopic vessel where oxygen and nutrients pass from blood into tissue.",
            definitionNative = "Микроскопический сосуд: через него кислород и питательные вещества переходят в ткань.",
            example = "A burst capillary under the skin leaves a small red dot.",
            exampleNative = "Лопнувший capillary под кожей оставляет маленькую красную точку.",
            rarity = "EPIC", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_circulatory", fillInBlankExclusions = listOf(46212L, 46213L, 46214L, 46215L)),

        // ── medicine_anatomy_urogenital (мочеполовая система) ─────────────────
        WordEntity(
            id = 46217, original = "kidney", transliteration = "[ˈkɪdni]", translation = "почка",
            definition = "A bean-shaped organ that cleans waste out of the blood and makes urine.",
            definitionNative = "Бобовидный орган: очищает кровь от отходов и образует мочу.",
            example = "He receives dialysis three times a week because his kidney failed.",
            exampleNative = "Он ходит на диализ три раза в неделю, потому что у него отказала kidney.",
            rarity = "RARE", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_urogenital", fillInBlankExclusions = listOf(46218L, 46219L, 46220L, 46221L)),
        WordEntity(
            id = 46218, original = "bladder", transliteration = "[ˈblædər]", translation = "мочевой пузырь",
            definition = "A stretchy pouch in the lower belly that holds urine until you go to the toilet.",
            definitionNative = "Растяжимый мешочек в нижней части живота: хранит мочу, пока не сходишь в туалет.",
            example = "After three cups of tea, my bladder was about to burst.",
            exampleNative = "После трёх чашек чая мой bladder вот-вот должен был лопнуть.",
            rarity = "RARE", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_urogenital", fillInBlankExclusions = listOf(46217L, 46219L, 46220L, 46221L)),
        WordEntity(
            id = 46219, original = "urethra", transliteration = "[jʊˈriːθrə]", translation = "уретра (мочеиспускательный канал)",
            definition = "The narrow tube that carries urine out of the body from its storage sac.",
            definitionNative = "Узкая трубка: выводит мочу из тела от места её хранения наружу.",
            example = "A catheter is gently slid up the urethra into the bladder.",
            exampleNative = "Катетер аккуратно вводят по urethra в мочевой пузырь.",
            rarity = "EPIC", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_urogenital", fillInBlankExclusions = listOf(46217L, 46218L, 46220L, 46221L)),
        WordEntity(
            id = 46220, original = "ovary", transliteration = "[ˈoʊvəri]", translation = "яичник",
            definition = "One of two small female glands that release eggs and make sex hormones.",
            definitionNative = "Одна из двух маленьких женских желёз: выпускает яйцеклетки и производит половые гормоны.",
            example = "The ultrasound found a small cyst on her right ovary.",
            exampleNative = "Узи нашло маленькую кисту на её правом ovary.",
            rarity = "RARE", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_urogenital", fillInBlankExclusions = listOf(46217L, 46218L, 46219L, 46221L)),
        WordEntity(
            id = 46221, original = "uterus", transliteration = "[ˈjuːtərəs]", translation = "матка",
            definition = "The hollow muscular organ in a woman's belly where a baby grows during pregnancy.",
            definitionNative = "Полый мышечный орган в женском животе: там растёт ребёнок во время беременности.",
            example = "An ultrasound checks the lining of the uterus during pregnancy.",
            exampleNative = "Узи проверяет слизистую uterus во время беременности.",
            rarity = "RARE", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_urogenital", fillInBlankExclusions = listOf(46217L, 46218L, 46219L, 46220L)),

        // ── medicine_anatomy_endocrine (эндокринная система и железы) ─────────
        WordEntity(
            id = 46222, original = "thyroid", transliteration = "[ˈθaɪrɔɪd]", translation = "щитовидная железа",
            definition = "A butterfly-shaped gland in the neck that controls how fast your body burns energy.",
            definitionNative = "Железа в форме бабочки на шее: управляет тем, как быстро тело сжигает энергию.",
            example = "She takes a pill every morning for an underactive thyroid.",
            exampleNative = "Она каждое утро пьёт таблетку из-за пониженной функции thyroid.",
            rarity = "RARE", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_endocrine", fillInBlankExclusions = listOf(46223L, 46224L, 46225L)),
        WordEntity(
            id = 46223, original = "adrenal", transliteration = "[əˈdriːnəl]", translation = "надпочечник",
            definition = "A small gland sitting on top of each kidney that releases stress hormones.",
            definitionNative = "Маленькая железа на верхушке каждой почки: выбрасывает гормоны стресса.",
            example = "Chronic stress wears out the adrenal glands over years.",
            exampleNative = "Хронический стресс изнашивает adrenal железы за годы.",
            rarity = "EPIC", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_endocrine", fillInBlankExclusions = listOf(46222L, 46224L, 46225L)),
        WordEntity(
            id = 46224, original = "pituitary", transliteration = "[pɪˈtjuːɪteri]", translation = "гипофиз",
            definition = "A pea-sized gland at the base of the brain that runs most of the body's hormones.",
            definitionNative = "Железа размером с горошину у основания мозга: управляет большинством гормонов тела.",
            example = "A tumor on the pituitary can cause sudden growth in adults.",
            exampleNative = "Опухоль на pituitary может вызвать внезапный рост у взрослых.",
            rarity = "EPIC", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_endocrine", fillInBlankExclusions = listOf(46222L, 46223L, 46225L)),
        WordEntity(
            id = 46225, original = "gland", transliteration = "[ɡlænd]", translation = "железа (орган)",
            definition = "An organ that produces a fluid or chemical released into the body or onto its surface.",
            definitionNative = "Орган, производящий жидкость или химическое вещество, выделяемое в тело или наружу.",
            example = "The doctor felt a swollen gland on the side of her neck.",
            exampleNative = "Врач нащупал увеличенную gland сбоку на её шее.",
            rarity = "RARE", setId = 462, languagePair = "en-ru", pos = "noun",
            semanticGroup = "medicine_anatomy_endocrine", fillInBlankExclusions = listOf(46222L, 46223L, 46224L)),
    )
}
