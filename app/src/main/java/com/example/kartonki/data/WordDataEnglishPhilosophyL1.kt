package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Философия (level 1, основы / A1).
 *
 * Set 341: «Философия» — базовая лексика про мысли, истину и жизнь
 * для простых разговоров о философских понятиях (COMMON / UNCOMMON,
 * преобладает COMMON).
 *
 * Дополняет уже существующие сеты темы «Философия» в en-ru:
 *   - Set 87  (WordDataEnglish.kt + WordDataEnglishExpanded.kt) — L3 базовые понятия логики.
 *   - Set 258 (WordDataEnglishBatch5.kt)                        — L4 философские понятия и этика.
 *   - Set 83  (WordDataEnglish.kt)                              — L5 рост, влияние, перемены.
 *   - Set 342 (WordDataEnglishPhilosophyL2.kt)                  — L2 (создаётся параллельно).
 *
 * Слова setId=341 не пересекаются ни с одним из этих наборов (проверено grep
 * по `original = "..."`). Также не дублируются со свежим L1-набором темы
 * «Психология» (set 334): из задачи запрещены happy, sad, fear, hope, mind,
 * heart, soul, mood, smile — не использованы.
 *
 * Cross-topic дубли (одно слово в разных темах допустимо): `know` (set 2),
 * `ask` (set 7), `learn` (set 15), `choose` (set 16), `good`/`bad` (set 6),
 * `right` (set 236), `wrong` (set 219), `luck` (set 301).
 *
 * Распределение редкости: 21 COMMON + 4 UNCOMMON — два смежных уровня шкалы (A1+A2).
 *
 * SemanticGroups (5 × 5):
 *   philosophy_truth_lies     — truth, lie, real, fake, false
 *   philosophy_life_death     — life, death, live, fate, end
 *   philosophy_thought_actions — know, understand, guess, ask, wonder
 *   philosophy_concepts       — chance, luck, choose, decide, learn
 *   philosophy_judgments      — good, bad, right, wrong, fair
 *
 * Word IDs: 34101..34125 (setId × 100 + position).
 */
object WordDataEnglishPhilosophyL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 341, name = "Философия",
            description = "Базовая лексика про мысли, истину и жизнь — простые философские понятия для разговоров",
            languagePair = "en-ru",
            topic = "Философия", level = 1),
    )

    val words: List<WordEntity> = listOf(

        // ── philosophy_truth_lies (5) ─────────────────────────────────────

        WordEntity(id = 34101, setId = 341, languagePair = "en-ru", rarity = "COMMON",
            original = "truth", transliteration = "[truθ]", translation = "правда",
            definition = "What really happened — not a story made up to hide the facts.",
            definitionNative = "То, что было на самом деле — не выдумка, чтобы скрыть факты.",
            example = "She finally told her mother the truth about the broken vase.",
            exampleNative = "Она наконец рассказала маме truth про разбитую вазу.",
            pos = "noun", semanticGroup = "philosophy_truth_lies", fillInBlankExclusions = listOf(34102L)),

        WordEntity(id = 34102, setId = 341, languagePair = "en-ru", rarity = "COMMON",
            original = "lie", transliteration = "[laɪ]", translation = "ложь",
            definition = "Something that is not true — said to fool another person.",
            definitionNative = "То, что неправда — сказано, чтобы обмануть другого человека.",
            example = "His silly lie about the homework did not fool the teacher.",
            exampleNative = "Его глупая lie про домашку не обманула учителя.",
            pos = "noun", semanticGroup = "philosophy_truth_lies", fillInBlankExclusions = listOf(34101L, 34113L)),

        WordEntity(id = 34103, setId = 341, languagePair = "en-ru", rarity = "COMMON",
            original = "real", transliteration = "[ril]", translation = "настоящий",
            definition = "True and not made up — like a real dog, not a toy one.",
            definitionNative = "Настоящий, не выдуманный — как живая собака, а не игрушка.",
            example = "The little boy thought the painted apple was a real one.",
            exampleNative = "Малыш подумал, что нарисованное яблоко real.",
            pos = "adjective", semanticGroup = "philosophy_truth_lies", fillInBlankExclusions = listOf(34104L, 34105L, 34121L, 34122L, 34124L)),

        WordEntity(id = 34104, setId = 341, languagePair = "en-ru", rarity = "COMMON",
            original = "fake", transliteration = "[feɪk]", translation = "поддельный",
            definition = "Made to look real but it is not — like plastic flowers in a vase.",
            definitionNative = "Сделан под настоящее, но не настоящее — как пластиковые цветы.",
            example = "Grandma's necklace turned out to be fake, not real gold.",
            exampleNative = "Бабушкино ожерелье оказалось fake, а не из настоящего золота.",
            pos = "adjective", semanticGroup = "philosophy_truth_lies", fillInBlankExclusions = listOf(34105L)),

        WordEntity(id = 34105, setId = 341, languagePair = "en-ru", rarity = "COMMON",
            original = "false", transliteration = "[fɔls]", translation = "ложный",
            definition = "Not correct — like a wrong answer or a story that did not happen.",
            definitionNative = "Неверный — как неправильный ответ или выдуманная история.",
            example = "The note about the lost dog was false — the dog was at home.",
            exampleNative = "Записка о пропавшей собаке была false — пёс был дома.",
            pos = "adjective", semanticGroup = "philosophy_truth_lies", fillInBlankExclusions = listOf(34103L, 34104L, 34124L)),

        // ── philosophy_life_death (5) ─────────────────────────────────────

        WordEntity(id = 34106, setId = 341, languagePair = "en-ru", rarity = "COMMON",
            original = "life", transliteration = "[laɪf]", translation = "жизнь",
            definition = "All the days from when a person is born until the end.",
            definitionNative = "Все дни от рождения человека до самого конца.",
            example = "Grandfather told warm stories about his long happy life.",
            exampleNative = "Дед рассказывал тёплые истории о своей долгой life.",
            pos = "noun", semanticGroup = "philosophy_life_death", fillInBlankExclusions = listOf(34107L, 34109L, 34110L)),

        WordEntity(id = 34107, setId = 341, languagePair = "en-ru", rarity = "COMMON",
            original = "death", transliteration = "[dɛθ]", translation = "смерть",
            definition = "The end of a life — when a person or animal stops being alive.",
            definitionNative = "Конец жизни — когда человек или животное перестаёт жить.",
            example = "The whole village was sad after the old farmer's death.",
            exampleNative = "Вся деревня грустила после death старого фермера.",
            pos = "noun", semanticGroup = "philosophy_life_death", fillInBlankExclusions = listOf(34106L, 34109L, 34110L)),

        WordEntity(id = 34108, setId = 341, languagePair = "en-ru", rarity = "COMMON",
            original = "live", transliteration = "[lɪv]", translation = "жить",
            definition = "To be alive — to breathe, eat, work and have days each year.",
            definitionNative = "Быть живым — дышать, есть, работать, проживать дни и годы.",
            example = "My uncle and aunt live in a small village by the river.",
            exampleNative = "Мои дядя и тётя live в маленькой деревне у реки.",
            pos = "verb", semanticGroup = "philosophy_life_death"),

        WordEntity(id = 34109, setId = 341, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "fate", transliteration = "[feɪt]", translation = "судьба",
            definition = "What will happen to a person — as if it is already chosen for them.",
            definitionNative = "То, что случится с человеком — как будто уже выбрано за него.",
            example = "Old tales say that no one can run away from their own fate.",
            exampleNative = "Старые сказки говорят, что от своей fate не убежать.",
            pos = "noun", semanticGroup = "philosophy_life_death", fillInBlankExclusions = listOf(34101L, 34102L, 34106L, 34107L, 34110L)),

        WordEntity(id = 34110, setId = 341, languagePair = "en-ru", rarity = "COMMON",
            original = "end", transliteration = "[ɛnd]", translation = "конец",
            definition = "The last part — when something stops, like a long road or a life.",
            definitionNative = "Последняя часть — когда что-то прекращается, как дорога или жизнь.",
            example = "At the end of the long story the brave dog comes home safely.",
            exampleNative = "В end долгой истории храбрый пёс возвращается домой.",
            pos = "noun", semanticGroup = "philosophy_life_death", fillInBlankExclusions = listOf(34106L, 34107L, 34109L)),

        // ── philosophy_thought_actions (5) ────────────────────────────────

        WordEntity(id = 34111, setId = 341, languagePair = "en-ru", rarity = "COMMON",
            original = "know", transliteration = "[noʊ]", translation = "знать",
            definition = "To have the right answer in your head — like the name of a friend.",
            definitionNative = "Иметь верный ответ в голове — например, имя друга.",
            example = "I know the way to the post office — just follow the long street.",
            exampleNative = "Я know дорогу на почту — просто иди по длинной улице.",
            pos = "verb", semanticGroup = "philosophy_thought_actions", fillInBlankExclusions = listOf(34112L, 34113L, 34114L, 34115L)),

        WordEntity(id = 34112, setId = 341, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "understand", transliteration = "[ˌʌndərˈstænd]", translation = "понимать",
            definition = "To get the sense of something — to see why or how it is so.",
            definitionNative = "Уловить смысл — увидеть, почему или как это устроено.",
            example = "I do not understand why the small cat hides under the bed every night.",
            exampleNative = "Я не understand, почему кот каждый вечер прячется под кровать.",
            pos = "verb", semanticGroup = "philosophy_thought_actions", fillInBlankExclusions = listOf(34111L, 34113L, 34114L, 34115L)),

        WordEntity(id = 34113, setId = 341, languagePair = "en-ru", rarity = "COMMON",
            original = "guess", transliteration = "[ɡɛs]", translation = "догадываться",
            definition = "To say what you think is true without being sure — like for a riddle.",
            definitionNative = "Сказать то, что считаешь верным, не будучи уверен — как при загадке.",
            example = "Try to guess how many small candies are in this glass jar.",
            exampleNative = "Попробуй guess, сколько мелких конфет в этой стеклянной банке.",
            pos = "verb", semanticGroup = "philosophy_thought_actions", fillInBlankExclusions = listOf(34111L, 34112L, 34114L, 34115L, 34119L, 34120L)),

        WordEntity(id = 34114, setId = 341, languagePair = "en-ru", rarity = "COMMON",
            original = "ask", transliteration = "[æsk]", translation = "спрашивать",
            definition = "To say a question to another person to learn something.",
            definitionNative = "Задать вопрос другому человеку, чтобы узнать что-то новое.",
            example = "If you don't know the road, just ask a friendly old woman.",
            exampleNative = "Если не знаешь дорогу, просто ask добрую старушку.",
            pos = "verb", semanticGroup = "philosophy_thought_actions", fillInBlankExclusions = listOf(34112L, 34113L, 34115L)),

        WordEntity(id = 34115, setId = 341, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "wonder", transliteration = "[ˈwʌndər]", translation = "размышлять",
            definition = "To turn a question over in your head and try to find the answer.",
            definitionNative = "Крутить вопрос в голове и пытаться найти на него ответ.",
            example = "I often wonder why the sky looks so blue on a clear day.",
            exampleNative = "Я часто wonder, почему небо такое синее в ясный день.",
            pos = "verb", semanticGroup = "philosophy_thought_actions", fillInBlankExclusions = listOf(34111L, 34112L, 34113L, 34114L)),

        // ── philosophy_concepts (5) ───────────────────────────────────────

        WordEntity(id = 34116, setId = 341, languagePair = "en-ru", rarity = "COMMON",
            original = "chance", transliteration = "[ʧæns]", translation = "случай",
            definition = "Something that happens with no plan — just by accident.",
            definitionNative = "То, что случается без плана — просто так, нечаянно.",
            example = "By chance, my old friend sat next to me on the long bus.",
            exampleNative = "По chance мой старый друг сел рядом в длинном автобусе.",
            pos = "noun", semanticGroup = "philosophy_concepts", fillInBlankExclusions = listOf(34109L, 34117L)),

        WordEntity(id = 34117, setId = 341, languagePair = "en-ru", rarity = "COMMON",
            original = "luck", transliteration = "[lʌk]", translation = "удача",
            definition = "Good or bad things that come to you with no clear cause.",
            definitionNative = "Хорошее или плохое, что приходит к тебе без понятной причины.",
            example = "Finding a five-dollar bill on the street was real luck.",
            exampleNative = "Найти на улице пятидолларовую купюру — настоящая luck.",
            pos = "noun", semanticGroup = "philosophy_concepts", fillInBlankExclusions = listOf(34106L, 34116L)),

        WordEntity(id = 34118, setId = 341, languagePair = "en-ru", rarity = "COMMON",
            original = "choose", transliteration = "[ʧuz]", translation = "выбирать",
            definition = "To pick one thing from many — like one cake from a long shelf.",
            definitionNative = "Взять одно из многого — как одно пирожное с длинной полки.",
            example = "She had to choose between the red shoes and the blue ones.",
            exampleNative = "Ей пришлось choose между красными туфлями и синими.",
            pos = "verb", semanticGroup = "philosophy_concepts", fillInBlankExclusions = listOf(34113L, 34119L, 34120L)),

        WordEntity(id = 34119, setId = 341, languagePair = "en-ru", rarity = "COMMON",
            original = "decide", transliteration = "[dɪˈsaɪd]", translation = "решать",
            definition = "To make up your mind — to say what you will do or not do.",
            definitionNative = "Принять решение — сказать, что будешь делать, а что нет.",
            example = "I cannot decide where we should go for our short holiday.",
            exampleNative = "Я не могу decide, куда нам поехать на короткий отпуск.",
            pos = "verb", semanticGroup = "philosophy_concepts", fillInBlankExclusions = listOf(34111L, 34112L, 34113L, 34114L, 34118L, 34120L)),

        WordEntity(id = 34120, setId = 341, languagePair = "en-ru", rarity = "COMMON",
            original = "learn", transliteration = "[lərn]", translation = "узнавать",
            definition = "To get new ideas in your head — from a book, a person or life.",
            definitionNative = "Получать новые знания в голову — из книги, от людей, из жизни.",
            example = "Children learn new words every single day at the small school.",
            exampleNative = "Дети learn новые слова каждый день в маленькой школе.",
            pos = "verb", semanticGroup = "philosophy_concepts", fillInBlankExclusions = listOf(34111L, 34112L, 34118L, 34119L)),

        // ── philosophy_judgments (5) ──────────────────────────────────────

        WordEntity(id = 34121, setId = 341, languagePair = "en-ru", rarity = "COMMON",
            original = "good", transliteration = "[gʊd]", translation = "хороший",
            definition = "Pleasant or right — like a kind person or warm bread.",
            definitionNative = "Приятный или правильный — как добрый человек или тёплый хлеб.",
            example = "Helping an old neighbour with bags is always a good thing to do.",
            exampleNative = "Помочь соседу-старику с сумками — всегда good поступок.",
            pos = "adjective", semanticGroup = "philosophy_judgments", fillInBlankExclusions = listOf(34122L, 34123L, 34124L, 34125L)),

        WordEntity(id = 34122, setId = 341, languagePair = "en-ru", rarity = "COMMON",
            original = "bad", transliteration = "[bæd]", translation = "плохой",
            definition = "Not pleasant or not right — like a mean act or rotten fruit.",
            definitionNative = "Неприятный или неправильный — как злой поступок или гнилой плод.",
            example = "Telling a small kid to be quiet by shouting is a bad idea.",
            exampleNative = "Кричать на малыша, чтобы он замолчал, — bad идея.",
            pos = "adjective", semanticGroup = "philosophy_judgments", fillInBlankExclusions = listOf(34103L, 34105L, 34121L, 34123L, 34124L, 34125L)),

        WordEntity(id = 34123, setId = 341, languagePair = "en-ru", rarity = "COMMON",
            original = "right", transliteration = "[raɪt]", translation = "правильный",
            definition = "Correct — the answer or action that fits the rule.",
            definitionNative = "Правильный — ответ или поступок, который подходит к правилу.",
            example = "She gave the right answer and the teacher gave her a star.",
            exampleNative = "Она дала right ответ, и учитель поставил ей звёздочку.",
            pos = "adjective", semanticGroup = "philosophy_judgments", fillInBlankExclusions = listOf(34103L, 34104L, 34105L, 34121L, 34122L, 34124L, 34125L)),

        WordEntity(id = 34124, setId = 341, languagePair = "en-ru", rarity = "COMMON",
            original = "wrong", transliteration = "[rɔŋ]", translation = "неправильный",
            definition = "Not correct — like a bad answer or an action that hurts a friend.",
            definitionNative = "Неверный — как ошибочный ответ или поступок, ранящий друга.",
            example = "Taking a toy from a small child without asking is just wrong.",
            exampleNative = "Брать игрушку у малыша, не спросив, — просто wrong.",
            pos = "adjective", semanticGroup = "philosophy_judgments", fillInBlankExclusions = listOf(34105L, 34121L, 34122L, 34123L, 34125L)),

        WordEntity(id = 34125, setId = 341, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "fair", transliteration = "[fɛr]", translation = "справедливый",
            definition = "Treating everyone the same — giving each person what they should get.",
            definitionNative = "Относится ко всем одинаково — даёт каждому то, что ему положено.",
            example = "It is not fair to share the cake unevenly between the two kids.",
            exampleNative = "Это не fair — делить торт неровно между двумя ребятами.",
            pos = "adjective", semanticGroup = "philosophy_judgments", fillInBlankExclusions = listOf(34121L, 34122L, 34123L, 34124L)),
    )
}
