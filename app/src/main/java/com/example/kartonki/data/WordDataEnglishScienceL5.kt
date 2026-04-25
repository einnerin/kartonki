package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Наука (level 5, носитель языка).
 *
 * Set 325: «Наука: носитель языка» — высокая академическая лексика на стыке
 * методологии, философии науки и формальных дисциплин (C2+).
 *
 * Распределение редкости: 17 LEGENDARY + 8 EPIC — два смежных уровня шкалы,
 * LEGENDARY преобладает (узкоспециальная мета-научная терминология).
 *
 * Дополняет уже существующие сеты темы «Наука» (en-ru):
 *   - Set 37  (WordDataEnglish.kt)         — L2 UNCOMMON, базовая научная лексика.
 *   - Set 55  (WordDataEnglish.kt)         — L3 RARE, продвинутая научная лексика.
 *   - Set 70  (WordDataEnglish.kt)         — L4 EPIC, закономерности и тенденции.
 *   - Set 72  (WordDataEnglish.kt)         — L4 EPIC, процессы и управление.
 *   - Set 73  (WordDataEnglish.kt)         — L4 EPIC, организационные процессы.
 *   - Set 74  (WordDataEnglish.kt)         — L4 EPIC, продвинутые научные термины.
 *   - Set 216 (WordDataEnglishExpanded.kt) — L3 RARE, космос и небесные тела.
 *   - Set 218 (WordDataEnglishExpanded.kt) — L3 RARE, математика.
 *   - Set 219 (WordDataEnglishExpanded.kt) — L2 UNCOMMON, химия — базовые.
 *   - Set 248 (WordDataEnglishExpanded.kt) — L4 EPIC, химия — углублённая.
 *   - Set 324 (WordDataEnglishScienceL1.kt) — L1 COMMON, школьная наука (создаётся параллельно).
 *
 * Слова setId=325 не пересекаются ни с одним из перечисленных сетов
 * (проверено grep по теме «Наука»).
 *
 * SemanticGroups (5 × 5):
 *   science_epistemology  — heuristic, axiomatic, parsimony, falsifiability, positivism
 *   science_methodology   — stochastic, deterministic, asymptotic, orthogonal, monotonic
 *   science_concepts      — emergent, holistic, ontological, isomorphism, eigenvalue
 *   science_rhetoric      — extrapolate, postulate, infer, refute, corroborate
 *   science_philosophy    — reductionism, rationalism, paradigmatic, epistemic, nomothetic
 *
 * Word IDs: 32501..32525 (setId × 100 + position).
 */
object WordDataEnglishScienceL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 325, name = "Наука",
            description = "Высокая научная лексика: эпистемология, методология, философия науки, редкие концепции",
            languagePair = "en-ru",
            topic = "Наука", level = 5),
    )

    val words: List<WordEntity> = listOf(

        // ── science_epistemology (5) ──────────────────────────────────────

        WordEntity(id = 32501, setId = 325, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "heuristic", transliteration = "[hjʊˈrɪstɪk]", translation = "эвристический (упрощающий поиск решения)",
            definition = "Of a rough rule that helps find a workable answer when the perfect one is too costly.",
            definitionNative = "Связанный с приближённым правилом для быстрого ответа, когда точное решение слишком дорого.",
            example = "Engineers use a heuristic shortcut to estimate signal loss before exact calculations.",
            exampleNative = "Инженеры пользуются heuristic прикидкой потерь сигнала до точного расчёта.",
            pos = "adjective", semanticGroup = "science_epistemology", fillInBlankExclusions = listOf(32507L, 32512L)),

        WordEntity(id = 32502, setId = 325, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "axiomatic", transliteration = "[ˌæksiəˈmætɪk]", translation = "аксиоматический (принимаемый без доказательства)",
            definition = "Treated as a basic truth from which other claims are then derived.",
            definitionNative = "Принимаемый как исходная истина, из которой выводятся другие утверждения.",
            example = "In Euclid's geometry, the parallel postulate is taken as axiomatic.",
            exampleNative = "В геометрии Евклида постулат о параллельных принят как axiomatic.",
            pos = "adjective", semanticGroup = "science_epistemology", fillInBlankExclusions = listOf(32501L, 32507L, 32523L)),

        WordEntity(id = 32503, setId = 325, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "parsimony", transliteration = "[ˈpɑrsəˌmoʊni]", translation = "парсимония (принцип бритвы Оккама)",
            definition = "The scholarly preference for the simplest explanation that still fits the facts.",
            definitionNative = "Учёное предпочтение самому простому объяснению, согласующемуся с фактами.",
            example = "By parsimony, scientists picked the model with three terms over the one with seven.",
            exampleNative = "По parsimony учёные предпочли модель с тремя членами, а не с семью.",
            pos = "noun", semanticGroup = "science_epistemology", fillInBlankExclusions = listOf(32504L, 32505L, 32521L, 32522L)),

        WordEntity(id = 32504, setId = 325, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "falsifiability", transliteration = "[ˌfɔlsəˌfaɪəˈbɪlɪti]", translation = "фальсифицируемость (опровержимость теории)",
            definition = "The mark of a real theory — it must allow for a possible disproving observation.",
            definitionNative = "Признак настоящей теории — она должна допускать наблюдение, которое её опровергнет.",
            example = "Popper argued that falsifiability separates real science from pseudo-science.",
            exampleNative = "Поппер утверждал, что falsifiability отделяет науку от псевдонауки.",
            pos = "noun", semanticGroup = "science_epistemology", fillInBlankExclusions = listOf(32503L, 32505L)),

        WordEntity(id = 32505, setId = 325, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "positivism", transliteration = "[ˈpɑzəˌtɪvɪzəm]", translation = "позитивизм (опора только на наблюдаемое)",
            definition = "The doctrine that real knowledge comes only from observable facts and logic.",
            definitionNative = "Учение о том, что подлинное знание идёт лишь из наблюдаемых фактов и логики.",
            example = "Comte's positivism shaped how nineteenth-century sociology framed evidence.",
            exampleNative = "Positivism Конта задал, как социология XIX века подавала доказательства.",
            pos = "noun", semanticGroup = "science_epistemology", fillInBlankExclusions = listOf(32503L, 32504L, 32521L, 32522L)),

        // ── science_methodology (5) ───────────────────────────────────────

        WordEntity(id = 32506, setId = 325, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "stochastic", transliteration = "[stəˈkæstɪk]", translation = "стохастический (со случайной составляющей)",
            definition = "Driven partly by chance, so each outcome can only be given a probability.",
            definitionNative = "Зависящий отчасти от случая, поэтому каждый исход даётся лишь с вероятностью.",
            example = "Quantum decay follows a stochastic pattern that no signal can predict.",
            exampleNative = "Квантовый распад следует stochastic закону, который никакой сигнал не предскажет.",
            pos = "adjective", semanticGroup = "science_methodology", fillInBlankExclusions = listOf(32501L, 32507L, 32510L, 32512L, 32523L, 32525L)),

        WordEntity(id = 32507, setId = 325, languagePair = "en-ru", rarity = "EPIC",
            original = "deterministic", transliteration = "[dɪˌtərmɪˈnɪstɪk]", translation = "детерминированный (полностью предопределённый)",
            definition = "Producing the same outcome every run when the starting state is identical.",
            definitionNative = "Выдающий одинаковый итог при одинаковом стартовом состоянии — без места случаю.",
            example = "Classical mechanics treats a planet's orbit as a deterministic curve in time.",
            exampleNative = "Классическая механика считает орбиту планеты deterministic кривой во времени.",
            pos = "adjective", semanticGroup = "science_methodology", fillInBlankExclusions = listOf(32501L, 32506L, 32510L)),

        WordEntity(id = 32508, setId = 325, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "asymptotic", transliteration = "[ˌæsɪmpˈtɑtɪk]", translation = "асимптотический (приближающийся к пределу)",
            definition = "Drawing ever closer to a limiting value but never quite reaching it.",
            definitionNative = "Подходящий к предельному значению всё ближе, но никогда его не достигающий.",
            example = "The reaction rate showed an asymptotic curve flattening near saturation.",
            exampleNative = "Скорость реакции дала asymptotic кривую, выходящую на насыщение.",
            pos = "adjective", semanticGroup = "science_methodology", fillInBlankExclusions = listOf(32509L, 32511L)),

        WordEntity(id = 32509, setId = 325, languagePair = "en-ru", rarity = "EPIC",
            original = "orthogonal", transliteration = "[ɔrˈθɑɡənəl]", translation = "ортогональный (независимый, под прямым углом)",
            definition = "Independent of another factor — varying one leaves the other untouched.",
            definitionNative = "Независимый от другого фактора — изменение одного не задевает второй.",
            example = "Cost and accuracy turned out to be orthogonal in the new measurement design.",
            exampleNative = "Цена и точность оказались orthogonal в новой схеме измерений.",
            pos = "adjective", semanticGroup = "science_methodology", fillInBlankExclusions = listOf(32506L, 32507L, 32508L, 32510L)),

        WordEntity(id = 32510, setId = 325, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "monotonic", transliteration = "[ˌmɑnəˈtɑnɪk]", translation = "монотонный (только возрастающий или только убывающий)",
            definition = "Moving in one direction only — either always rising or always falling.",
            definitionNative = "Изменяющийся только в одну сторону — либо всегда растёт, либо всегда убывает.",
            example = "The function proved monotonic across the whole tested temperature range.",
            exampleNative = "Функция оказалась monotonic во всём изученном диапазоне температур.",
            pos = "adjective", semanticGroup = "science_methodology", fillInBlankExclusions = listOf(32506L, 32507L, 32508L, 32509L)),

        // ── science_concepts (5) ──────────────────────────────────────────

        WordEntity(id = 32511, setId = 325, languagePair = "en-ru", rarity = "EPIC",
            original = "emergent", transliteration = "[ɪˈmərʤənt]", translation = "эмерджентный (возникающий на уровне системы)",
            definition = "Arising from the system as a whole, not present in any one component alone.",
            definitionNative = "Возникающий у системы в целом, отсутствующий у любого её компонента в отдельности.",
            example = "Consciousness is often called an emergent property of the brain's neural activity.",
            exampleNative = "Сознание часто называют emergent свойством нейронной работы мозга.",
            pos = "adjective", semanticGroup = "science_concepts", fillInBlankExclusions = listOf(32502L, 32508L, 32509L, 32513L, 32524L)),

        WordEntity(id = 32512, setId = 325, languagePair = "en-ru", rarity = "EPIC",
            original = "holistic", transliteration = "[hoʊˈlɪstɪk]", translation = "холистический (рассматривающий целое)",
            definition = "Treating a thing as one whole whose parts cannot be fully understood alone.",
            definitionNative = "Рассматривающий объект как единое целое, чьи части не понять по отдельности.",
            example = "Ecologists take a holistic view, tying soil, weather and species together.",
            exampleNative = "Экологи держат holistic взгляд, связывая почву, погоду и виды воедино.",
            pos = "adjective", semanticGroup = "science_concepts", fillInBlankExclusions = listOf(32501L, 32507L, 32523L, 32525L)),

        WordEntity(id = 32513, setId = 325, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "ontological", transliteration = "[ˌɑntəˈlɑʤɪkəl]", translation = "онтологический (относящийся к самой природе бытия)",
            definition = "Concerning what kinds of things actually exist in the world being studied.",
            definitionNative = "Касающийся того, какие именно сущности существуют в изучаемом мире.",
            example = "Physicists faced an ontological puzzle about whether fields are real entities.",
            exampleNative = "Физики столкнулись с ontological загадкой: реальны ли поля как сущности.",
            pos = "adjective", semanticGroup = "science_concepts", fillInBlankExclusions = listOf(32502L, 32511L, 32524L)),

        WordEntity(id = 32514, setId = 325, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "isomorphism", transliteration = "[ˌaɪsəˈmɔrfɪzəm]", translation = "изоморфизм (структурное соответствие)",
            definition = "A structure-preserving match between two systems with the same internal pattern.",
            definitionNative = "Соответствие, сохраняющее структуру, между двумя системами с одинаковым устройством.",
            example = "Group theory revealed an isomorphism between symmetries of the cube and a permutation set.",
            exampleNative = "Теория групп вскрыла isomorphism между симметриями куба и набором перестановок.",
            pos = "noun", semanticGroup = "science_concepts", fillInBlankExclusions = listOf(32515L)),

        WordEntity(id = 32515, setId = 325, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "eigenvalue", transliteration = "[ˈaɪɡənˌvælju]", translation = "собственное значение (матрицы или оператора)",
            definition = "A scaling number that a special vector keeps when a linear operator acts on it.",
            definitionNative = "Число, на которое умножается особый вектор при действии на него линейного оператора.",
            example = "Each eigenvalue of the Hamiltonian gives an allowed energy of the quantum system.",
            exampleNative = "Каждое eigenvalue гамильтониана даёт допустимую энергию квантовой системы.",
            pos = "noun", semanticGroup = "science_concepts", fillInBlankExclusions = listOf(32514L)),

        // ── science_rhetoric (5) ──────────────────────────────────────────

        WordEntity(id = 32516, setId = 325, languagePair = "en-ru", rarity = "EPIC",
            original = "extrapolate", transliteration = "[ɪkˈstræpəˌleɪt]", translation = "экстраполировать (распространять данные за пределы выборки)",
            definition = "To stretch a known trend out beyond the measured range to guess unseen values.",
            definitionNative = "Растянуть известную тенденцию за пределы измеренного, чтобы оценить невидимые значения.",
            example = "Climate models extrapolate past warming rates to forecast the next century.",
            exampleNative = "Климатические модели extrapolate прошлые темпы потепления на следующий век.",
            pos = "verb", semanticGroup = "science_rhetoric", fillInBlankExclusions = listOf(32517L, 32518L, 32519L, 32520L)),

        WordEntity(id = 32517, setId = 325, languagePair = "en-ru", rarity = "EPIC",
            original = "postulate", transliteration = "[ˈpɑsʧəˌleɪt]", translation = "постулировать (вводить как исходное допущение)",
            definition = "To put forward a starting claim, taken as true so that further reasoning can begin.",
            definitionNative = "Выдвинуть исходное утверждение, принимаемое истинным, чтобы продолжить рассуждение.",
            example = "Theorists postulate that the speed of light stays constant in every frame.",
            exampleNative = "Теоретики postulate, что скорость света постоянна в любой системе отсчёта.",
            pos = "verb", semanticGroup = "science_rhetoric", fillInBlankExclusions = listOf(32516L, 32518L, 32519L, 32520L)),

        WordEntity(id = 32518, setId = 325, languagePair = "en-ru", rarity = "EPIC",
            original = "infer", transliteration = "[ɪnˈfər]", translation = "выводить (логическое следствие из данных)",
            definition = "To draw a conclusion from the given evidence by following the lines of logic.",
            definitionNative = "Сделать вывод из имеющихся данных, следуя логической связи.",
            example = "From the fossil layers, geologists infer a sudden ancient climate shift.",
            exampleNative = "По слоям ископаемых геологи infer резкий древний климатический сдвиг.",
            pos = "verb", semanticGroup = "science_rhetoric", fillInBlankExclusions = listOf(32516L, 32517L, 32519L, 32520L)),

        WordEntity(id = 32519, setId = 325, languagePair = "en-ru", rarity = "EPIC",
            original = "refute", transliteration = "[rɪˈfjut]", translation = "опровергать (доказательно)",
            definition = "To prove an idea wrong with evidence or sound argument.",
            definitionNative = "Доказательно показать, что мысль неверна — фактами или строгим рассуждением.",
            example = "A single repeatable counter-experiment can refute an entire physical law.",
            exampleNative = "Один повторяемый контр-опыт способен refute целый физический закон.",
            pos = "verb", semanticGroup = "science_rhetoric", fillInBlankExclusions = listOf(32516L, 32517L, 32518L, 32520L)),

        WordEntity(id = 32520, setId = 325, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "corroborate", transliteration = "[kəˈrɑbəˌreɪt]", translation = "подкреплять (доказательствами)",
            definition = "To back up a claim with extra evidence that points the same way.",
            definitionNative = "Поддержать утверждение дополнительными свидетельствами, ведущими к тому же выводу.",
            example = "Independent labs corroborate the team's strange superconductivity result.",
            exampleNative = "Независимые лаборатории corroborate странный результат команды по сверхпроводимости.",
            pos = "verb", semanticGroup = "science_rhetoric", fillInBlankExclusions = listOf(32516L, 32517L, 32518L, 32519L)),

        // ── science_philosophy (5) ────────────────────────────────────────

        WordEntity(id = 32521, setId = 325, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "reductionism", transliteration = "[rɪˈdəkʃəˌnɪzəm]", translation = "редукционизм (сведение целого к частям)",
            definition = "The view that any whole is fully explained by the behaviour of its smaller parts.",
            definitionNative = "Взгляд, по которому целое исчерпывающе объясняется поведением его меньших частей.",
            example = "Strict reductionism claims that biology is just complicated physics underneath.",
            exampleNative = "Жёсткий reductionism утверждает: биология — просто сложная физика в основе.",
            pos = "noun", semanticGroup = "science_philosophy", fillInBlankExclusions = listOf(32503L, 32504L, 32505L, 32522L)),

        WordEntity(id = 32522, setId = 325, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "rationalism", transliteration = "[ˈræʃənəˌlɪzəm]", translation = "рационализм (ставка на разум как источник знания)",
            definition = "The view that reason, more than the senses, gives the surest path to truth.",
            definitionNative = "Воззрение, что разум, а не чувства, даёт самый надёжный путь к истине.",
            example = "Descartes built his rationalism on a foundation of pure deductive thought.",
            exampleNative = "Декарт построил свой rationalism на фундаменте чисто дедуктивной мысли.",
            pos = "noun", semanticGroup = "science_philosophy", fillInBlankExclusions = listOf(32503L, 32504L, 32505L, 32521L)),

        WordEntity(id = 32523, setId = 325, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "paradigmatic", transliteration = "[ˌpærədɪɡˈmætɪk]", translation = "парадигматический (задающий образец мышления)",
            definition = "Setting the very framework of thought that a field uses for a whole era.",
            definitionNative = "Задающий саму рамку мышления, в которой целая область работает в свою эпоху.",
            example = "Newton's mechanics gave physics a paradigmatic model that lasted two centuries.",
            exampleNative = "Механика Ньютона дала физике paradigmatic модель, продержавшуюся два века.",
            pos = "adjective", semanticGroup = "science_philosophy", fillInBlankExclusions = listOf(32501L, 32506L, 32507L, 32510L, 32512L, 32525L)),

        WordEntity(id = 32524, setId = 325, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "epistemic", transliteration = "[ˌɛpɪˈstimɪk]", translation = "эпистемический (относящийся к знанию и его обоснованию)",
            definition = "Concerning knowledge itself — how it is grounded and how sure we may be of it.",
            definitionNative = "Касающийся самого знания — как оно обосновано и насколько в нём можно быть уверенным.",
            example = "Peer review serves as an epistemic filter for new physics findings.",
            exampleNative = "Рецензирование служит epistemic фильтром для новых физических находок.",
            pos = "adjective", semanticGroup = "science_philosophy", fillInBlankExclusions = listOf(32502L, 32508L, 32509L, 32511L, 32513L)),

        WordEntity(id = 32525, setId = 325, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "nomothetic", transliteration = "[ˌnɑməˈθɛtɪk]", translation = "номотетический (стремящийся к общим законам)",
            definition = "Aimed at finding general laws that hold across many separate cases.",
            definitionNative = "Направленный на поиск общих законов, действующих для многих отдельных случаев.",
            example = "Sociology hopes for a nomothetic theory that predicts behaviour across cultures.",
            exampleNative = "Социология надеется на nomothetic теорию, предсказывающую поведение в разных культурах.",
            pos = "adjective", semanticGroup = "science_philosophy", fillInBlankExclusions = listOf(32501L, 32506L, 32507L, 32510L, 32512L, 32523L)),
    )
}
