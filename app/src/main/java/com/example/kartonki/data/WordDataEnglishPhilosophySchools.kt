package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — set 469.
 * Философия: школы и направления (L4 / RARE + EPIC).
 *
 * Расширение темы «Философия». Дополняет существующие сеты:
 *   - 42, 62, 63, 78, 82  — общая лексика мышления, логики и понятий.
 *   - 68, 87              — рассуждение, аргументация, fallacies.
 *   - 83                  — стиль "Влияние, рост и изменения".
 *   - 258                 — L4 RARE/EPIC, профессиональная философия
 *                            (ontology, deontology, hermeneutics,
 *                             phenomenology, existentialism, nihilism,
 *                             utilitarianism, determinism, …).
 *   - 341 (L1)            — основы (truth, life, mind, death).
 *   - 342 (L2)            — продвинутая лексика (morality, duty, identity).
 *
 * Подтема — конкретные философские школы и -измы:
 *   античные течения (stoicism, epicureanism, skepticism, cynicism, platonism),
 *   континентальные направления XIX-XX вв. (absurdism, perspectivism,
 *     romanticism, transcendentalism, fatalism),
 *   метафизика (materialism, idealism, dualism, monism, panpsychism),
 *   методология и наука о познании (humanism, scientism, functionalism,
 *     foundationalism, holism),
 *   этические школы (hedonism, asceticism, consequentialism,
 *     virtue ethics, eudaimonia).
 *
 * НЕ дубли с set 258: existentialism, phenomenology, hermeneutics, nihilism,
 *   utilitarianism, deontology, determinism, free will, moral relativism,
 *   pragmatism, rationalism, empiricism, solipsism, deconstruction,
 *   structuralism, postmodernism, positivism, reductionism — все уже там
 *   или в смежных сетах (Batch5, Batch15, ScienceL5, CinemaL5).
 *
 * Распределение редкости (2 смежных уровня по `validate_rarity_spread`):
 *   RARE  — 9 слов  (stoicism, skepticism, romanticism, materialism,
 *                    idealism, dualism, humanism, hedonism, asceticism).
 *   EPIC  — 16 слов (epicureanism, cynicism, platonism, absurdism,
 *                    perspectivism, fatalism, transcendentalism,
 *                    monism, panpsychism, scientism, functionalism,
 *                    foundationalism, holism, consequentialism,
 *                    eudaimonia, virtue ethics).
 *
 * Пять семантических групп по 5 слов:
 *   philo_school_ancient      — античные школы
 *   philo_school_continental  — направления XIX-XX вв.
 *   philo_school_metaphysics  — онтологические позиции о природе реальности
 *   philo_school_metascience  — школы о методе и роли науки/человека
 *   philo_school_ethics       — этические доктрины
 *
 * Word IDs: 46901..46925 (setId × 100 + position).
 */
object WordDataEnglishPhilosophySchools {

    val sets = listOf(
        WordSetEntity(
            id = 469,
            name = "Философия",
            description = "Школы и направления философии: античные течения, метафизика, этические доктрины (stoicism, idealism, hedonism, virtue ethics)",
            languagePair = "en-ru",
            orderIndex = 469,
            topic = "Философия",
            level = 4,
        ),
    )

    val words = listOf(

        // ── philo_school_ancient (античные школы) ─────────────────────────────
        WordEntity(
            id = 46901, original = "stoicism", transliteration = "[ˈstoʊɪsɪzəm]", translation = "стоицизм",
            definition = "Ancient school founded by Zeno teaching calm acceptance of fate and control of desires.",
            definitionNative = "Античная школа Зенона, учившая спокойному принятию судьбы и контролю над желаниями.",
            example = "Modern stoicism, popularised by Ryan Holiday, says we suffer more in imagination than reality.",
            exampleNative = "Современный stoicism у Райана Холидея учит: страдаем мы больше в воображении, чем в реальности.",
            rarity = "RARE", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_ancient", fillInBlankExclusions = listOf(46902L, 46903L, 46904L, 46905L)),
        WordEntity(
            id = 46902, original = "epicureanism", transliteration = "[ˌɛpɪkjʊˈriːənɪzəm]", translation = "эпикуреизм",
            definition = "Ancient teaching of Epicurus seeking quiet happiness through modest pleasure and freedom from fear.",
            definitionNative = "Учение Эпикура о тихом счастье через скромное удовольствие и свободу от страхов.",
            example = "Despite the cliché, epicureanism preached simple meals with friends, not wild feasts.",
            exampleNative = "Вопреки клише, epicureanism на деле проповедовал простые обеды с друзьями, а не пиры.",
            rarity = "EPIC", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_ancient", fillInBlankExclusions = listOf(46901L, 46903L, 46904L, 46905L)),
        WordEntity(
            id = 46903, original = "skepticism", transliteration = "[ˈskɛptɪsɪzəm]", translation = "скептицизм",
            definition = "School holding that certain knowledge is impossible and every claim deserves to be doubted.",
            definitionNative = "Школа, считающая, что достоверное знание недостижимо и каждое утверждение стоит подвергать сомнению.",
            example = "Ancient skepticism asked whether we can really trust the senses to show us the world as it is.",
            exampleNative = "Античный skepticism ставил вопрос: можно ли доверять чувствам, чтобы они показали мир таким, какой он есть.",
            rarity = "RARE", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_ancient", fillInBlankExclusions = listOf(46901L, 46902L, 46904L, 46905L)),
        WordEntity(
            id = 46904, original = "cynicism", transliteration = "[ˈsɪnɪsɪzəm]", translation = "кинизм",
            definition = "School of Diogenes that rejected wealth and social conventions in favour of a natural, simple life.",
            definitionNative = "Школа Диогена, отвергавшая богатство и условности ради простой жизни по природе.",
            example = "Diogenes embodied cynicism by living in a barrel and mocking Alexander the Great to his face.",
            exampleNative = "Диоген воплощал cynicism, живя в бочке и насмехаясь над Александром Македонским прямо в глаза.",
            rarity = "EPIC", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_ancient", fillInBlankExclusions = listOf(46901L, 46902L, 46903L, 46905L)),
        WordEntity(
            id = 46905, original = "platonism", transliteration = "[ˈpleɪtənɪzəm]", translation = "платонизм",
            definition = "Tradition of Plato holding that abstract forms are more real than the changing physical world.",
            definitionNative = "Традиция Платона, утверждающая, что абстрактные идеи реальнее изменчивого физического мира.",
            example = "Mathematicians often slip into platonism when they say numbers exist independently of human minds.",
            exampleNative = "Математики часто скатываются в platonism, когда говорят, что числа существуют независимо от человеческого ума.",
            rarity = "EPIC", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_ancient", fillInBlankExclusions = listOf(46901L, 46902L, 46903L, 46904L)),

        // ── philo_school_continental (направления XIX–XX вв.) ────────────────
        WordEntity(
            id = 46906, original = "absurdism", transliteration = "[əbˈsɜːrdɪzəm]", translation = "абсурдизм",
            definition = "View developed by Camus that life has no inherent meaning yet must be lived with revolt and joy.",
            definitionNative = "Взгляд Камю: у жизни нет встроенного смысла, но её надо проживать с бунтом и радостью.",
            example = "Camus illustrated absurdism through the myth of Sisyphus pushing his boulder forever up the hill.",
            exampleNative = "Камю показал absurdism через миф о Сизифе, который вечно толкает камень в гору.",
            rarity = "EPIC", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_continental", fillInBlankExclusions = listOf(46907L, 46908L, 46909L, 46910L)),
        WordEntity(
            id = 46907, original = "perspectivism", transliteration = "[pərˈspɛktɪvɪzəm]", translation = "перспективизм",
            definition = "Nietzsche's view that every truth is shaped by the angle and interests of whoever sees it.",
            definitionNative = "Идея Ницше: всякая истина определена углом зрения и интересами того, кто смотрит.",
            example = "Through perspectivism Nietzsche argued there are no pure facts, only readings from some angle.",
            exampleNative = "Через perspectivism Ницше утверждал: чистых фактов нет, есть лишь прочтения под углом.",
            rarity = "EPIC", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_continental", fillInBlankExclusions = listOf(46906L, 46908L, 46909L, 46910L)),
        WordEntity(
            id = 46908, original = "fatalism", transliteration = "[ˈfeɪtəlɪzəm]", translation = "фатализм",
            definition = "Belief that whatever happens has been fixed in advance and human effort cannot change it.",
            definitionNative = "Убеждение, что любое событие предрешено и человеческие усилия ничего не меняют.",
            example = "Russian literature is full of fatalism, from Pushkin's duels to Tolstoy's battle scenes.",
            exampleNative = "Русская литература пропитана fatalism — от дуэлей Пушкина до батальных сцен Толстого.",
            rarity = "EPIC", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_continental", fillInBlankExclusions = listOf(46906L, 46907L, 46909L, 46910L)),
        WordEntity(
            id = 46909, original = "romanticism", transliteration = "[roʊˈmæntɪsɪzəm]", translation = "романтизм",
            definition = "Movement after the Enlightenment that prized feeling, nature and the lone creative individual.",
            definitionNative = "Движение после Просвещения, ценившее чувство, природу и одинокую творческую личность.",
            example = "German romanticism gave us Goethe's Werther and Friedrich's lonely wanderers on misty peaks.",
            exampleNative = "Немецкий romanticism подарил нам гётевского Вертера и одиноких странников Фридриха на туманных вершинах.",
            rarity = "RARE", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_continental", fillInBlankExclusions = listOf(46906L, 46907L, 46908L, 46910L)),
        WordEntity(
            id = 46910, original = "transcendentalism", transliteration = "[ˌtrænsɛnˈdɛntəlɪzəm]", translation = "трансцендентализм",
            definition = "American 19th-century movement of Emerson and Thoreau that sought truth in nature and personal intuition.",
            definitionNative = "Американское движение XIX века Эмерсона и Торо: искало истину в природе и личной интуиции.",
            example = "Thoreau retreated to Walden Pond to practise transcendentalism by living deliberately in the woods.",
            exampleNative = "Торо удалился к Уолденскому пруду — практиковать transcendentalism, осознанно живя в лесу.",
            rarity = "EPIC", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_continental", fillInBlankExclusions = listOf(46906L, 46907L, 46908L, 46909L)),

        // ── philo_school_metaphysics (онтологические позиции) ─────────────────
        WordEntity(
            id = 46911, original = "materialism", transliteration = "[məˈtɪəriəlɪzəm]", translation = "материализм",
            definition = "View that only matter exists and everything mental can be reduced to physical processes.",
            definitionNative = "Взгляд, что существует только материя, а всё психическое сводится к физическим процессам.",
            example = "Marx built his version of materialism on the idea that economic conditions shape what people think.",
            exampleNative = "Маркс построил свой materialism на идее, что экономические условия формируют мышление людей.",
            rarity = "RARE", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_metaphysics", fillInBlankExclusions = listOf(46912L, 46913L, 46914L, 46915L)),
        WordEntity(
            id = 46912, original = "idealism", transliteration = "[aɪˈdiːəlɪzəm]", translation = "идеализм (филос.)",
            definition = "Position of Berkeley and Hegel that reality is fundamentally mental — ideas come before matter.",
            definitionNative = "Позиция Беркли и Гегеля: реальность по сути ментальна — идеи первичнее материи.",
            example = "Hegel's idealism saw the whole of history as the gradual unfolding of one great Mind.",
            exampleNative = "Гегелевский idealism видел всю историю как постепенное развёртывание одного великого Разума.",
            rarity = "RARE", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_metaphysics", fillInBlankExclusions = listOf(46911L, 46913L, 46914L, 46915L)),
        WordEntity(
            id = 46913, original = "dualism", transliteration = "[ˈduːəlɪzəm]", translation = "дуализм",
            definition = "Descartes' view that mind and body are two separate substances that somehow interact.",
            definitionNative = "Взгляд Декарта: ум и тело — две отдельные субстанции, которые как-то взаимодействуют.",
            example = "Modern neuroscience makes Cartesian dualism harder to defend than it was in the seventeenth century.",
            exampleNative = "Современная нейронаука делает картезианский dualism труднее защитимым, чем в XVII веке.",
            rarity = "RARE", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_metaphysics", fillInBlankExclusions = listOf(46911L, 46912L, 46914L, 46915L)),
        WordEntity(
            id = 46914, original = "monism", transliteration = "[ˈmɒnɪzəm]", translation = "монизм",
            definition = "Position that the world is made of only one ultimate substance, whether mind, matter or something else.",
            definitionNative = "Позиция: мир состоит из одной предельной субстанции — будь то ум, материя или нечто иное.",
            example = "Spinoza defended a strict monism in which God and nature are simply two names for the same thing.",
            exampleNative = "Спиноза защищал строгий monism, в котором Бог и природа — два имени одного и того же.",
            rarity = "EPIC", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_metaphysics", fillInBlankExclusions = listOf(46911L, 46912L, 46913L, 46915L)),
        WordEntity(
            id = 46915, original = "panpsychism", transliteration = "[pænˈsaɪkɪzəm]", translation = "панпсихизм",
            definition = "Claim that consciousness is a basic feature of all matter, not just brains.",
            definitionNative = "Утверждение, что сознание — фундаментальное свойство всей материи, а не только мозгов.",
            example = "Galen Strawson revived panpsychism by arguing that even electrons have a faint inner life.",
            exampleNative = "Гален Стросон оживил panpsychism, утверждая: даже у электронов есть слабая внутренняя жизнь.",
            rarity = "EPIC", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_metaphysics", fillInBlankExclusions = listOf(46911L, 46912L, 46913L, 46914L)),

        // ── philo_school_metascience (метод и наука) ──────────────────────────
        WordEntity(
            id = 46916, original = "humanism", transliteration = "[ˈhjuːmənɪzəm]", translation = "гуманизм",
            definition = "Tradition that puts human worth, reason and freedom at the centre instead of divine authority.",
            definitionNative = "Традиция, ставящая в центр достоинство человека, разум и свободу вместо божественной власти.",
            example = "Renaissance humanism returned to ancient texts and put individual dignity back on the agenda.",
            exampleNative = "Ренессансный humanism вернулся к античным текстам и снова вынес достоинство личности в центр.",
            rarity = "RARE", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_metascience", fillInBlankExclusions = listOf(46917L, 46918L, 46919L, 46920L)),
        WordEntity(
            id = 46917, original = "scientism", transliteration = "[ˈsaɪəntɪzəm]", translation = "сциентизм",
            definition = "View that natural-science methods are the only path to real knowledge about anything important.",
            definitionNative = "Взгляд: методы естественных наук — единственный путь к настоящему знанию о чём-либо важном.",
            example = "Critics accuse Sam Harris of scientism when he claims that science alone can settle moral questions.",
            exampleNative = "Критики обвиняют Сэма Харриса в scientism, когда он заявляет, что одна лишь наука может решать моральные вопросы.",
            rarity = "EPIC", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_metascience", fillInBlankExclusions = listOf(46916L, 46918L, 46919L, 46920L)),
        WordEntity(
            id = 46918, original = "functionalism", transliteration = "[ˈfʌŋkʃənəlɪzəm]", translation = "функционализм",
            definition = "Theory of mind saying mental states are defined by what they do, not what they are made of.",
            definitionNative = "Теория сознания: психические состояния определяются тем, что они делают, а не материалом.",
            example = "Functionalism opens the door to the idea that a silicon brain could in principle think like ours.",
            exampleNative = "Functionalism открывает дверь идее, что кремниевый мозг в принципе мог бы мыслить как наш.",
            rarity = "EPIC", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_metascience", fillInBlankExclusions = listOf(46916L, 46917L, 46919L, 46920L)),
        WordEntity(
            id = 46919, original = "foundationalism", transliteration = "[faʊnˈdeɪʃənəlɪzəm]", translation = "фундаментализм (эпистем.)",
            definition = "Idea in epistemology that all knowledge rests on a base of self-evident beliefs.",
            definitionNative = "Идея в теории познания: всякое знание опирается на фундамент самоочевидных убеждений.",
            example = "Descartes pursued foundationalism — one indubitable starting point under every other thought.",
            exampleNative = "Декарт продвигал foundationalism — несомненная отправная точка под всеми прочими мыслями.",
            rarity = "EPIC", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_metascience", fillInBlankExclusions = listOf(46916L, 46917L, 46918L, 46920L)),
        WordEntity(
            id = 46920, original = "holism", transliteration = "[ˈhoʊlɪzəm]", translation = "холизм",
            definition = "Position that wholes cannot be understood just by breaking them into separate parts.",
            definitionNative = "Позиция: целое нельзя понять, разложив его на отдельные части.",
            example = "Quine pushed semantic holism, insisting a single sentence has no meaning outside its web.",
            exampleNative = "Куайн продвигал семантический holism: одно предложение лишено смысла вне всей сети убеждений.",
            rarity = "EPIC", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_metascience", fillInBlankExclusions = listOf(46916L, 46917L, 46918L, 46919L)),

        // ── philo_school_ethics (этические доктрины) ──────────────────────────
        WordEntity(
            id = 46921, original = "hedonism", transliteration = "[ˈhiːdənɪzəm]", translation = "гедонизм",
            definition = "Ethical view that pleasure is the highest good and pain the only real evil.",
            definitionNative = "Этический взгляд: удовольствие — высшее благо, а боль — единственное настоящее зло.",
            example = "Aristippus preached crude hedonism centuries before Epicurus quietly refined the same idea.",
            exampleNative = "Аристипп проповедовал грубый hedonism за века до того, как Эпикур тихо облагородил эту же идею.",
            rarity = "RARE", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_ethics", fillInBlankExclusions = listOf(46922L, 46923L, 46925L)),
        WordEntity(
            id = 46922, original = "asceticism", transliteration = "[əˈsɛtɪsɪzəm]", translation = "аскетизм",
            definition = "Way of life that gives up bodily comfort and pleasure to reach spiritual or moral goals.",
            definitionNative = "Образ жизни, отказывающийся от телесного комфорта и удовольствия ради духовных целей.",
            example = "Medieval monks practised severe asceticism, sleeping on stone floors and eating one meal a day.",
            exampleNative = "Средневековые монахи практиковали суровый asceticism, спали на каменных полах и ели один раз в день.",
            rarity = "RARE", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_ethics", fillInBlankExclusions = listOf(46921L, 46923L, 46925L)),
        WordEntity(
            id = 46923, original = "consequentialism", transliteration = "[ˌkɒnsɪˈkwɛnʃəlɪzəm]", translation = "консеквенциализм",
            definition = "Ethical view that judges actions only by their results, not by intentions or rules.",
            definitionNative = "Этический взгляд: поступок судят только по последствиям, а не по намерениям или правилам.",
            example = "A strict consequentialism might justify a small lie if it ends up saving someone's life.",
            exampleNative = "Строгий consequentialism может оправдать маленькую ложь, если она в итоге спасает чью-то жизнь.",
            rarity = "EPIC", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_ethics", fillInBlankExclusions = listOf(46921L, 46922L, 46925L)),
        WordEntity(
            id = 46924, original = "virtue ethics", transliteration = "[ˈvɜːrtʃuː ˈɛθɪks]", translation = "этика добродетели",
            definition = "Approach of Aristotle that asks what kind of person to be, not which rule to follow.",
            definitionNative = "Подход Аристотеля: спрашивает не «какому правилу следовать», а «каким человеком быть».",
            example = "Virtue ethics is enjoying a revival, partly thanks to Alasdair MacIntyre's book After Virtue.",
            exampleNative = "Virtue ethics переживает возрождение — отчасти благодаря книге Аласдера Макинтайра «After Virtue».",
            rarity = "EPIC", setId = 469, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "philo_school_ethics"),
        WordEntity(
            id = 46925, original = "eudaimonia", transliteration = "[ˌjuːdaɪˈmoʊniə]", translation = "эвдемония",
            definition = "Aristotle's idea of flourishing — the deep, lasting kind of happiness you earn by living well.",
            definitionNative = "Идея Аристотеля о процветании — глубокое и стойкое счастье, заработанное достойной жизнью.",
            example = "Aristotle insisted that eudaimonia is not a feeling but a whole life lived in line with reason.",
            exampleNative = "Аристотель настаивал: eudaimonia — не чувство, а вся жизнь, прожитая согласно разуму.",
            rarity = "EPIC", setId = 469, languagePair = "en-ru", pos = "noun",
            semanticGroup = "philo_school_ethics", fillInBlankExclusions = listOf(46921L, 46922L, 46923L)),
    )
}
