package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Наука (level 1).
 *
 * Set 324: «Наука» — основы для повседневных разговоров о школьных
 * предметах, простых опытах и устройстве мира (L1 / COMMON+UNCOMMON).
 *
 * Дополняет уже существующие сеты темы «Наука»:
 *   - Set 37  (WordDataEnglish.kt)         — L2 (базовая научная лексика).
 *   - Set 55  (WordDataEnglish.kt)         — L3 (продвинутая лексика).
 *   - Set 70, 72, 73, 74 (WordDataEnglish.kt) — L4 (управление, процессы, термины).
 *   - Set 216 (WordDataEnglishExpanded.kt) — L3 (космос и небесные тела).
 *   - Set 218 (WordDataEnglishExpanded.kt) — L3 (числа и фигуры).
 *   - Set 219 (WordDataEnglishExpanded.kt) — L2 (химия — базовые понятия).
 *   - Set 248 (WordDataEnglishExpanded.kt) — L4 (химия — углублённая).
 *
 * Слова setId=324 не пересекаются ни с одним из этих наборов (проверено grep
 * по setId=37/55/70/72/73/74/216/218/219/248).
 *
 * Распределение редкости: 20 COMMON + 5 UNCOMMON — два смежных уровня шкалы (A1+A2).
 *
 * SemanticGroups (5 × 5):
 *   science_lab        — lab, microscope, magnet, beaker, tube
 *   science_world      — world, space, earth, nature, universe
 *   science_action     — measure, discover, mix, check, compare
 *   science_concept    — fact, idea, problem, model, force
 *   science_thing      — shape, machine, robot, scientist, chart
 *
 * Word IDs: 32401..32425 (setId × 100 + position).
 */
object WordDataEnglishScienceL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 324, name = "Наука",
            description = "Базовая лексика про науку, школьные предметы и простые опыты для повседневных разговоров",
            languagePair = "en-ru",
            orderIndex = 145,
            topic = "Наука", level = 1),
    )

    val words: List<WordEntity> = listOf(

        // ── science_lab (5) ───────────────────────────────────────────────

        WordEntity(id = 32401, setId = 324, languagePair = "en-ru", rarity = "COMMON",
            original = "lab", transliteration = "[læb]", translation = "лаборатория",
            definition = "A room with tools where people do science experiments.",
            definitionNative = "Комната с приборами — там делают научные опыты.",
            example = "We did a fun water experiment in the school lab today.",
            exampleNative = "Сегодня мы делали весёлый опыт с водой в школьной lab.",
            pos = "noun", semanticGroup = "science_lab",
            fillInBlankExclusions = listOf(32402L, 32403L, 32404L, 32405L)),

        WordEntity(id = 32402, setId = 324, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "microscope", transliteration = "[ˈmaɪkrəˌskoʊp]", translation = "микроскоп",
            definition = "A tool that makes very small things look big enough to see.",
            definitionNative = "Прибор — делает очень мелкие предметы видимыми и большими.",
            example = "Through the microscope the leaf looked like a green forest.",
            exampleNative = "В microscope лист выглядел как зелёный лес.",
            pos = "noun", semanticGroup = "science_lab",
            fillInBlankExclusions = listOf(32401L, 32403L, 32404L, 32405L)),

        WordEntity(id = 32403, setId = 324, languagePair = "en-ru", rarity = "COMMON",
            original = "magnet", transliteration = "[ˈmæɡnət]", translation = "магнит",
            definition = "A piece of metal that pulls iron things to itself.",
            definitionNative = "Кусочек металла — притягивает к себе железные предметы.",
            example = "The little magnet stuck a paper note to the fridge door.",
            exampleNative = "Маленький magnet прижал записку к двери холодильника.",
            pos = "noun", semanticGroup = "science_lab",
            fillInBlankExclusions = listOf(32401L, 32402L, 32404L, 32405L)),

        WordEntity(id = 32404, setId = 324, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "beaker", transliteration = "[ˈbikər]", translation = "химический стакан",
            definition = "A tall glass cup used in a lab to hold and mix liquids.",
            definitionNative = "Высокий стеклянный стакан в лаборатории — для жидкостей и смесей.",
            example = "The teacher poured blue water into the beaker and we watched.",
            exampleNative = "Учитель налил синюю воду в beaker, а мы смотрели.",
            pos = "noun", semanticGroup = "science_lab",
            fillInBlankExclusions = listOf(32401L, 32402L, 32403L, 32405L)),

        WordEntity(id = 32405, setId = 324, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "tube", transliteration = "[tub]", translation = "пробирка",
            definition = "A long thin glass jar used in a lab to hold a tiny amount of liquid.",
            definitionNative = "Длинная тонкая стеклянная баночка — в неё кладут немного жидкости для опыта.",
            example = "She held the warm tube up to the light and frowned.",
            exampleNative = "Она подняла тёплую tube к свету и нахмурилась.",
            pos = "noun", semanticGroup = "science_lab",
            fillInBlankExclusions = listOf(32401L, 32402L, 32403L, 32404L)),

        // ── science_world (5) ─────────────────────────────────────────────

        WordEntity(id = 32406, setId = 324, languagePair = "en-ru", rarity = "COMMON",
            original = "world", transliteration = "[wərld]", translation = "мир",
            definition = "Our whole planet — all the lands, seas and people on it.",
            definitionNative = "Вся наша планета — со всеми землями, морями и людьми.",
            example = "Science helps us learn how the world really works.",
            exampleNative = "Наука помогает понять, как устроен наш world.",
            pos = "noun", semanticGroup = "science_world",
            fillInBlankExclusions = listOf(32407L, 32408L, 32409L, 32410L)),

        WordEntity(id = 32407, setId = 324, languagePair = "en-ru", rarity = "COMMON",
            original = "space", transliteration = "[speɪs]", translation = "космос",
            definition = "The huge dark place above the sky where planets float.",
            definitionNative = "Огромное тёмное пространство над небом — там парят планеты.",
            example = "My little brother dreams of flying to space one day.",
            exampleNative = "Мой младший брат мечтает однажды улететь в space.",
            pos = "noun", semanticGroup = "science_world",
            fillInBlankExclusions = listOf(32406L, 32408L, 32409L, 32410L)),

        WordEntity(id = 32408, setId = 324, languagePair = "en-ru", rarity = "COMMON",
            original = "earth", transliteration = "[ərθ]", translation = "Земля (планета)",
            definition = "The round planet where we all live — it has water and trees.",
            definitionNative = "Круглая планета, на которой мы живём — с водой и деревьями.",
            example = "From space the earth looks like a beautiful blue ball.",
            exampleNative = "Из космоса earth выглядит как красивый синий шар.",
            pos = "noun", semanticGroup = "science_world",
            fillInBlankExclusions = listOf(32406L, 32407L, 32409L, 32410L)),

        WordEntity(id = 32409, setId = 324, languagePair = "en-ru", rarity = "COMMON",
            original = "nature", transliteration = "[ˈneɪʧər]", translation = "природа",
            definition = "All the trees, animals, rivers and weather around us.",
            definitionNative = "Всё вокруг нас — деревья, звери, реки и погода.",
            example = "We walked through the forest and watched the quiet nature.",
            exampleNative = "Мы шли через лес и наблюдали за тихой nature.",
            pos = "noun", semanticGroup = "science_world",
            fillInBlankExclusions = listOf(32406L, 32407L, 32408L, 32410L)),

        WordEntity(id = 32410, setId = 324, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "universe", transliteration = "[ˈjunəˌvərs]", translation = "вселенная",
            definition = "Everything that exists — all stars, planets and empty space.",
            definitionNative = "Всё, что существует — все звёзды, планеты и пустое пространство.",
            example = "Scientists say the universe is much bigger than we can imagine.",
            exampleNative = "Учёные говорят, что universe куда больше, чем мы думаем.",
            pos = "noun", semanticGroup = "science_world",
            fillInBlankExclusions = listOf(32406L, 32407L, 32408L, 32409L)),

        // ── science_action (5) ────────────────────────────────────────────

        WordEntity(id = 32411, setId = 324, languagePair = "en-ru", rarity = "COMMON",
            original = "measure", transliteration = "[ˈmɛʒər]", translation = "измерять",
            definition = "To find out how big, long or heavy something is.",
            definitionNative = "Узнавать, какой предмет по размеру, длине или весу.",
            example = "We measure the plant every Monday to see how it grows.",
            exampleNative = "Каждый понедельник мы measure растение, чтобы видеть рост.",
            pos = "verb", semanticGroup = "science_action",
            fillInBlankExclusions = listOf(32412L, 32413L, 32414L, 32415L)),

        WordEntity(id = 32412, setId = 324, languagePair = "en-ru", rarity = "COMMON",
            original = "discover", transliteration = "[dɪˈskəvər]", translation = "обнаружить, открыть",
            definition = "To find something new that nobody knew about before.",
            definitionNative = "Найти что-то новое, о чём раньше никто не знал.",
            example = "Kids often discover small bugs hiding under the leaves.",
            exampleNative = "Дети часто discover маленьких жучков под листьями.",
            pos = "verb", semanticGroup = "science_action",
            fillInBlankExclusions = listOf(32411L, 32413L, 32414L, 32415L)),

        WordEntity(id = 32413, setId = 324, languagePair = "en-ru", rarity = "COMMON",
            original = "mix", transliteration = "[mɪks]", translation = "смешивать",
            definition = "To put two or more things together so they become one.",
            definitionNative = "Соединять два или больше предметов так, чтобы получился один.",
            example = "Mix the red water with the blue water and watch the colour.",
            exampleNative = "Mix красную воду с синей и смотри, какой цвет получится.",
            pos = "verb", semanticGroup = "science_action",
            fillInBlankExclusions = listOf(32411L, 32412L, 32414L, 32415L)),

        WordEntity(id = 32414, setId = 324, languagePair = "en-ru", rarity = "COMMON",
            original = "check", transliteration = "[ʧɛk]", translation = "проверять",
            definition = "To look at something carefully to make sure it is right.",
            definitionNative = "Внимательно смотреть на что-то, чтобы убедиться, что всё верно.",
            example = "Always check the result before you write it in the notebook.",
            exampleNative = "Всегда check результат, прежде чем записать его в тетрадь.",
            pos = "verb", semanticGroup = "science_action",
            fillInBlankExclusions = listOf(32411L, 32412L, 32413L, 32415L)),

        WordEntity(id = 32415, setId = 324, languagePair = "en-ru", rarity = "COMMON",
            original = "compare", transliteration = "[kəmˈpɛr]", translation = "сравнивать",
            definition = "To look at two things and see how they are alike or different.",
            definitionNative = "Смотреть на два предмета и видеть, чем они похожи или различны.",
            example = "Let's compare the two leaves and see which one is bigger.",
            exampleNative = "Давай compare два листа и посмотрим, какой больше.",
            pos = "verb", semanticGroup = "science_action",
            fillInBlankExclusions = listOf(32411L, 32412L, 32413L, 32414L)),

        // ── science_concept (5) ───────────────────────────────────────────

        WordEntity(id = 32416, setId = 324, languagePair = "en-ru", rarity = "COMMON",
            original = "fact", transliteration = "[fækt]", translation = "факт",
            definition = "Something that is really true — not a guess or a story.",
            definitionNative = "То, что правда на самом деле — не догадка и не выдумка.",
            example = "It is a fact that the sun rises in the east every morning.",
            exampleNative = "Это fact: солнце каждое утро встаёт на востоке.",
            pos = "noun", semanticGroup = "science_concept",
            fillInBlankExclusions = listOf(32417L, 32418L, 32419L, 32420L)),

        WordEntity(id = 32417, setId = 324, languagePair = "en-ru", rarity = "COMMON",
            original = "idea", transliteration = "[aɪˈdiə]", translation = "идея",
            definition = "A thought in your head — like a plan for an experiment.",
            definitionNative = "Мысль в голове — например, план будущего опыта.",
            example = "I have a great idea for a new science project at school.",
            exampleNative = "У меня отличная idea для нового проекта в школе.",
            pos = "noun", semanticGroup = "science_concept",
            fillInBlankExclusions = listOf(32416L, 32418L, 32419L, 32420L)),

        WordEntity(id = 32418, setId = 324, languagePair = "en-ru", rarity = "COMMON",
            original = "problem", transliteration = "[ˈprɑbləm]", translation = "задача",
            definition = "A question in a book that you must work out an answer for.",
            definitionNative = "Вопрос в учебнике, на который нужно найти ответ.",
            example = "This problem looks hard, but we can solve it together.",
            exampleNative = "Эта problem кажется сложной, но мы решим её вместе.",
            pos = "noun", semanticGroup = "science_concept",
            fillInBlankExclusions = listOf(32416L, 32417L, 32419L, 32420L)),

        WordEntity(id = 32419, setId = 324, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "model", transliteration = "[ˈmɑdəl]", translation = "модель",
            definition = "A small copy of a real thing — used to study or show how it works.",
            definitionNative = "Маленькая копия настоящего предмета — для изучения или показа.",
            example = "He built a small model of the planet Saturn from clay.",
            exampleNative = "Он слепил из глины маленькую model планеты Сатурн.",
            pos = "noun", semanticGroup = "science_concept",
            fillInBlankExclusions = listOf(32416L, 32417L, 32418L, 32420L)),

        WordEntity(id = 32420, setId = 324, languagePair = "en-ru", rarity = "COMMON",
            original = "force", transliteration = "[fɔrs]", translation = "сила",
            definition = "A push or a pull that moves something — like wind on a leaf.",
            definitionNative = "Толчок или тяга, которые двигают предмет — как ветер двигает листок.",
            example = "You need a strong force to push the heavy door open.",
            exampleNative = "Нужна сильная force, чтобы толкнуть тяжёлую дверь.",
            pos = "noun", semanticGroup = "science_concept",
            fillInBlankExclusions = listOf(32416L, 32417L, 32418L, 32419L)),

        // ── science_thing (5) ─────────────────────────────────────────────

        WordEntity(id = 32421, setId = 324, languagePair = "en-ru", rarity = "COMMON",
            original = "shape", transliteration = "[ʃeɪp]", translation = "форма",
            definition = "The outline of a thing — like a circle, square or star.",
            definitionNative = "Внешний вид предмета — круг, квадрат или звёздочка.",
            example = "The little girl drew a shape that looked like a heart.",
            exampleNative = "Девочка нарисовала shape, похожую на сердечко.",
            pos = "noun", semanticGroup = "science_thing",
            fillInBlankExclusions = listOf(32422L, 32423L, 32424L, 32425L)),

        WordEntity(id = 32422, setId = 324, languagePair = "en-ru", rarity = "COMMON",
            original = "machine", transliteration = "[məˈʃin]", translation = "машина (устройство)",
            definition = "A thing with moving parts that does work for people.",
            definitionNative = "Устройство с движущимися частями — выполняет работу для людей.",
            example = "The washing machine in our kitchen is making a strange noise.",
            exampleNative = "Стиральная machine на кухне странно шумит.",
            pos = "noun", semanticGroup = "science_thing",
            fillInBlankExclusions = listOf(32421L, 32423L, 32424L, 32425L)),

        WordEntity(id = 32423, setId = 324, languagePair = "en-ru", rarity = "COMMON",
            original = "robot", transliteration = "[ˈroʊbət]", translation = "робот",
            definition = "A machine made to look or act like a person — does jobs by itself.",
            definitionNative = "Машина — внешне или поведением похожа на человека, делает работу сама.",
            example = "My cousin has a small robot that walks across the table.",
            exampleNative = "У моего брата маленький robot — он ходит по столу.",
            pos = "noun", semanticGroup = "science_thing",
            fillInBlankExclusions = listOf(32421L, 32422L, 32424L, 32425L)),

        WordEntity(id = 32424, setId = 324, languagePair = "en-ru", rarity = "COMMON",
            original = "scientist", transliteration = "[ˈsaɪəntəst]", translation = "учёный",
            definition = "A person whose job is to study how things work and find answers.",
            definitionNative = "Человек, чья работа — изучать, как всё устроено, и искать ответы.",
            example = "The young scientist showed us a new kind of plant in the garden.",
            exampleNative = "Молодой scientist показал нам новое растение в саду.",
            pos = "noun", semanticGroup = "science_thing",
            fillInBlankExclusions = listOf(32421L, 32422L, 32423L, 32425L)),

        WordEntity(id = 32425, setId = 324, languagePair = "en-ru", rarity = "COMMON",
            original = "chart", transliteration = "[ʧɑrt]", translation = "график, схема",
            definition = "A drawing with lines or numbers that shows facts in a clear way.",
            definitionNative = "Рисунок с линиями или числами — наглядно показывает факты.",
            example = "The chart on the wall shows how tall each child has grown.",
            exampleNative = "Chart на стене показывает, как вырос каждый ребёнок.",
            pos = "noun", semanticGroup = "science_thing",
            fillInBlankExclusions = listOf(32421L, 32422L, 32423L, 32424L)),
    )
}
