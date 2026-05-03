package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Идиомы и устойчивые выражения (L2, UNCOMMON+RARE).
 *
 * Set 406: «Идиомы и устойчивые выражения» — продвинутый уровень.
 *          Идиомы про работу/карьеру, отношения, решения, борьбу
 *          и успех/провал. Это второй сет темы (продолжение L1 set 405).
 *          Все 25 фраз — самостоятельные многословные единицы, смысл
 *          которых не складывается из значений отдельных слов.
 *
 * ⚠️ Идиомы по определению редко бывают COMMON по объективному CEFR.
 * На L2 темы COMMON-слов нет: 17 UNCOMMON (B1) + 8 RARE (B2). Это два
 * смежных уровня, правило разброса соблюдено.
 *
 * Дублей с set 405 (L1) и другими английскими сетами нет — проверено
 * grep'ом по `original = "..."` для всех 25 фраз. Базовая лексика
 * (climb, ladder, ropes, towel, viral и т.д.) живёт в других сетах
 * как отдельные слова — наши же фразы — это самостоятельные идиомы.
 *
 * Распределение редкости: 17 UNCOMMON (B1) + 8 RARE (B2).
 *
 * SemanticGroups (5 × 5):
 *   idioms_l2_work_career      — climb the ladder, learn the ropes,
 *                                burn the midnight oil, throw in the
 *                                towel, hit a glass ceiling
 *   idioms_l2_relationships    — see eye to eye, get along, hit it off,
 *                                drift apart, on thin ice
 *   idioms_l2_decisions        — a tough call, a fork in the road,
 *                                sleep on it, weigh the pros and cons,
 *                                in two minds
 *   idioms_l2_struggle         — face the music, take the bull by the
 *                                horns, swim against the tide, in the
 *                                same boat, hit rock bottom
 *   idioms_l2_success_failure  — fall flat, go viral, make ends meet,
 *                                turn the corner, raise the bar
 *
 * Word IDs: setId × 100 + position (40601..40625).
 *
 * Все слова — pos = "phrase". fillInBlankExclusions пустые — заполнятся
 * через FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataEnglishIdiomsL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 406,
            languagePair = "en-ru",
            orderIndex = 406,
            name = "Идиомы и устойчивые выражения",
            description = "Идиомы о работе, отношениях, решениях, борьбе и успехе",
            topic = "Идиомы и устойчивые выражения",
            level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 406 — Идиомы: продвинутый уровень (L2, UNCOMMON+RARE)        ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── idioms_l2_work_career (5) ─────────────────────────────────────

        WordEntity(id = 40601, setId = 406, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "climb the ladder", transliteration = "[klaɪm ðə ˈlædər]", translation = "продвигаться по карьерной лестнице",
            definition = "To move up step by step in your job or career.",
            definitionNative = "Постепенно расти по службе или в карьере. Дословно — «карабкаться по лестнице».",
            example = "She wants to climb the ladder and become a senior manager.",
            exampleNative = "Она хочет climb the ladder и стать старшим менеджером.",
            pos = "phrase", semanticGroup = "idioms_l2_work_career", fillInBlankExclusions = listOf(40602L, 40603L, 40604L, 40605L, 40614L, 40617L, 40624L, 40625L)),

        WordEntity(id = 40602, setId = 406, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "learn the ropes", transliteration = "[lɜrn ðə roʊps]", translation = "освоиться (на новой работе)",
            definition = "To learn the basic skills and rules of a new job or activity.",
            definitionNative = "Освоить азы и правила новой работы или занятия. Дословно — «выучить канаты» (из морского жаргона).",
            example = "Give him a few weeks to learn the ropes at the new office.",
            exampleNative = "Дай ему пару недель learn the ropes в новом офисе.",
            pos = "phrase", semanticGroup = "idioms_l2_work_career", fillInBlankExclusions = listOf(40601L, 40603L, 40604L, 40605L, 40606L, 40607L, 40614L, 40617L, 40624L, 40625L)),

        WordEntity(id = 40603, setId = 406, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "burn the midnight oil", transliteration = "[bɜrn ðə ˈmɪdnaɪt ɔɪl]", translation = "работать допоздна / засиживаться за работой",
            definition = "To work or study late into the night.",
            definitionNative = "Работать или учиться до поздней ночи. Дословно — «жечь полуночное масло» (когда лампы заправляли маслом).",
            example = "I had to burn the midnight oil to finish the report on time.",
            exampleNative = "Мне пришлось burn the midnight oil, чтобы вовремя сдать отчёт.",
            pos = "phrase", semanticGroup = "idioms_l2_work_career", fillInBlankExclusions = listOf(40601L, 40602L, 40604L, 40605L, 40614L, 40617L, 40625L)),

        WordEntity(id = 40604, setId = 406, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "throw in the towel", transliteration = "[θroʊ ɪn ðə ˈtaʊəl]", translation = "сдаться, признать поражение",
            definition = "To give up trying because the task is too difficult.",
            definitionNative = "Сдаться и перестать пытаться. Дословно — «бросить полотенце» (из бокса).",
            example = "After three failed startups, he was ready to throw in the towel.",
            exampleNative = "После трёх провальных стартапов он был готов throw in the towel.",
            pos = "phrase", semanticGroup = "idioms_l2_work_career", fillInBlankExclusions = listOf(40601L, 40602L, 40603L, 40605L, 40613L, 40614L, 40616L, 40617L, 40618L, 40623L, 40624L, 40625L)),

        WordEntity(id = 40605, setId = 406, languagePair = "en-ru", rarity = "RARE",
            original = "hit a glass ceiling", transliteration = "[hɪt ə ɡlæs ˈsilɪŋ]", translation = "упереться в «стеклянный потолок» (невидимый карьерный барьер)",
            definition = "To reach an invisible barrier that blocks further career growth, often due to bias.",
            definitionNative = "Упереться в невидимый барьер карьерного роста. Дословно — «удариться о стеклянный потолок».",
            example = "Many talented women hit a glass ceiling in this industry.",
            exampleNative = "Многие талантливые женщины hit a glass ceiling в этой отрасли.",
            pos = "phrase", semanticGroup = "idioms_l2_work_career", fillInBlankExclusions = listOf(40601L, 40602L, 40603L, 40604L, 40606L, 40607L, 40608L, 40609L, 40614L, 40616L, 40617L, 40618L, 40620L, 40621L, 40623L, 40624L, 40625L)),

        // ── idioms_l2_relationships (5) ───────────────────────────────────

        WordEntity(id = 40606, setId = 406, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "see eye to eye", transliteration = "[si aɪ tu aɪ]", translation = "сходиться во мнениях, понимать друг друга",
            definition = "To agree with someone and share the same view.",
            definitionNative = "Соглашаться с кем-то и иметь общую точку зрения. Дословно — «смотреть глаза в глаза».",
            example = "My brother and I rarely see eye to eye on politics.",
            exampleNative = "Мы с братом редко see eye to eye по поводу политики.",
            pos = "phrase", semanticGroup = "idioms_l2_relationships", fillInBlankExclusions = listOf(40604L, 40607L, 40608L, 40609L, 40610L, 40614L, 40617L, 40618L)),

        WordEntity(id = 40607, setId = 406, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "get along", transliteration = "[ɡɛt əˈlɔŋ]", translation = "ладить (с кем-то)",
            definition = "To have a friendly relationship and not argue.",
            definitionNative = "Иметь дружеские отношения и не ссориться. Дословно — «продвигаться вместе».",
            example = "It's important to get along with your new colleagues.",
            exampleNative = "Важно get along с новыми коллегами.",
            pos = "phrase", semanticGroup = "idioms_l2_relationships", fillInBlankExclusions = listOf(40606L, 40608L, 40609L, 40610L, 40616L)),

        WordEntity(id = 40608, setId = 406, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "hit it off", transliteration = "[hɪt ɪt ɔf]", translation = "сразу поладить, найти общий язык",
            definition = "To become friends quickly when you first meet someone.",
            definitionNative = "Быстро подружиться при первой же встрече. Дословно — «ударить по этому».",
            example = "We hit it off at the party and have been friends ever since.",
            exampleNative = "Мы hit it off на вечеринке и с тех пор дружим.",
            pos = "phrase", semanticGroup = "idioms_l2_relationships", fillInBlankExclusions = listOf(40606L, 40607L, 40609L, 40610L)),

        WordEntity(id = 40609, setId = 406, languagePair = "en-ru", rarity = "RARE",
            original = "drift apart", transliteration = "[drɪft əˈpɑrt]", translation = "отдалиться (друг от друга)",
            definition = "To slowly become less close to someone over time.",
            definitionNative = "Постепенно становиться менее близкими с кем-то со временем. Дословно — «дрейфовать в стороны».",
            example = "After college, the old friends slowly began to drift apart.",
            exampleNative = "После колледжа старые друзья начали постепенно drift apart.",
            pos = "phrase", semanticGroup = "idioms_l2_relationships", fillInBlankExclusions = listOf(40601L, 40602L, 40603L, 40604L, 40606L, 40607L, 40608L, 40610L, 40614L, 40616L, 40617L, 40618L, 40622L, 40623L, 40624L, 40625L)),

        WordEntity(id = 40610, setId = 406, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "on thin ice", transliteration = "[ɑn θɪn aɪs]", translation = "в шатком положении (≈ ходить по тонкому льду)",
            definition = "In a risky situation where you can easily get into trouble.",
            definitionNative = "В рискованной ситуации, где легко попасть в неприятности. Дословно — «на тонком льду».",
            example = "After two warnings, he's on thin ice with the boss.",
            exampleNative = "После двух предупреждений он on thin ice у начальника.",
            pos = "phrase", semanticGroup = "idioms_l2_relationships", fillInBlankExclusions = listOf(40606L, 40607L, 40608L, 40609L, 40615L, 40619L)),

        // ── idioms_l2_decisions (5) ───────────────────────────────────────

        WordEntity(id = 40611, setId = 406, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "a tough call", transliteration = "[ə tʌf kɔl]", translation = "трудное решение",
            definition = "A difficult decision that is hard to make.",
            definitionNative = "Сложное решение, которое трудно принять. Дословно — «жёсткий вызов».",
            example = "Choosing between the two job offers was a tough call.",
            exampleNative = "Выбрать между двумя предложениями работы — это была a tough call.",
            pos = "phrase", semanticGroup = "idioms_l2_decisions", fillInBlankExclusions = listOf(40612L, 40613L, 40614L, 40615L)),

        WordEntity(id = 40612, setId = 406, languagePair = "en-ru", rarity = "RARE",
            original = "a fork in the road", transliteration = "[ə fɔrk ɪn ðə roʊd]", translation = "развилка (≈ важный выбор пути)",
            definition = "A point where you must choose between two different directions in life.",
            definitionNative = "Момент, когда нужно выбрать одно из двух направлений в жизни. Дословно — «вилка/развилка на дороге».",
            example = "Graduation feels like a fork in the road for most students.",
            exampleNative = "Выпускной для большинства студентов ощущается как a fork in the road.",
            pos = "phrase", semanticGroup = "idioms_l2_decisions", fillInBlankExclusions = listOf(40611L, 40613L, 40614L, 40615L)),

        WordEntity(id = 40613, setId = 406, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "sleep on it", transliteration = "[slip ɑn ɪt]", translation = "переспать с этой мыслью / подумать до утра",
            definition = "To wait until the next day before making a decision.",
            definitionNative = "Подождать до следующего дня, прежде чем принять решение. Дословно — «поспать на этом».",
            example = "Don't decide right now — sleep on it and tell me tomorrow.",
            exampleNative = "Не решай прямо сейчас — sleep on it и скажи мне завтра.",
            pos = "phrase", semanticGroup = "idioms_l2_decisions", fillInBlankExclusions = listOf(40603L, 40611L, 40612L, 40614L, 40615L, 40617L)),

        WordEntity(id = 40614, setId = 406, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "weigh the pros and cons", transliteration = "[weɪ ðə proʊz ənd kɑnz]", translation = "взвесить все «за» и «против»",
            definition = "To carefully think about the good and bad sides of something.",
            definitionNative = "Внимательно обдумать плюсы и минусы чего-то. Дословно — «взвесить плюсы и минусы».",
            example = "Before you take the loan, weigh the pros and cons carefully.",
            exampleNative = "Прежде чем брать кредит, аккуратно weigh the pros and cons.",
            pos = "phrase", semanticGroup = "idioms_l2_decisions", fillInBlankExclusions = listOf(40611L, 40612L, 40613L, 40615L, 40624L)),

        WordEntity(id = 40615, setId = 406, languagePair = "en-ru", rarity = "RARE",
            original = "in two minds", transliteration = "[ɪn tu maɪndz]", translation = "в раздумьях, сомневаться",
            definition = "Unable to decide because you have two different opinions about something.",
            definitionNative = "Не можешь решить, потому что у тебя два разных мнения по поводу чего-то. Дословно — «в двух умах».",
            example = "I'm in two minds about accepting the offer abroad.",
            exampleNative = "Я in two minds насчёт того, принимать ли предложение за рубежом.",
            pos = "phrase", semanticGroup = "idioms_l2_decisions", fillInBlankExclusions = listOf(40611L, 40612L, 40613L, 40614L)),

        // ── idioms_l2_struggle (5) ────────────────────────────────────────

        WordEntity(id = 40616, setId = 406, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "face the music", transliteration = "[feɪs ðə ˈmjuzɪk]", translation = "ответить за свои поступки",
            definition = "To accept criticism or punishment for something you did.",
            definitionNative = "Принять критику или наказание за то, что сделал. Дословно — «встретить музыку лицом».",
            example = "Sooner or later, he'll have to face the music for those mistakes.",
            exampleNative = "Рано или поздно ему придётся face the music за эти ошибки.",
            pos = "phrase", semanticGroup = "idioms_l2_struggle", fillInBlankExclusions = listOf(40603L, 40604L, 40617L, 40618L, 40619L, 40620L)),

        WordEntity(id = 40617, setId = 406, languagePair = "en-ru", rarity = "RARE",
            original = "take the bull by the horns", transliteration = "[teɪk ðə bʊl baɪ ðə hɔrnz]", translation = "взять быка за рога",
            definition = "To deal with a difficult situation directly and bravely.",
            definitionNative = "Решительно и смело взяться за трудную ситуацию. Дословно — «взять быка за рога».",
            example = "It's time to take the bull by the horns and ask for a raise.",
            exampleNative = "Пора take the bull by the horns и попросить прибавку.",
            pos = "phrase", semanticGroup = "idioms_l2_struggle", fillInBlankExclusions = listOf(40601L, 40602L, 40603L, 40613L, 40614L, 40616L, 40618L, 40619L, 40620L, 40624L)),

        WordEntity(id = 40618, setId = 406, languagePair = "en-ru", rarity = "RARE",
            original = "swim against the tide", transliteration = "[swɪm əˈɡɛnst ðə taɪd]", translation = "идти против течения",
            definition = "To do something different from what most people are doing.",
            definitionNative = "Делать что-то иначе, чем большинство людей. Дословно — «плыть против прилива».",
            example = "Choosing art as a career means you'll swim against the tide.",
            exampleNative = "Выбрать искусство как профессию — значит swim against the tide.",
            pos = "phrase", semanticGroup = "idioms_l2_struggle", fillInBlankExclusions = listOf(40602L, 40603L, 40604L, 40605L, 40616L, 40617L, 40619L, 40620L, 40621L, 40623L)),

        WordEntity(id = 40619, setId = 406, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "in the same boat", transliteration = "[ɪn ðə seɪm boʊt]", translation = "в одной лодке (≈ в одинаковом положении)",
            definition = "In the same difficult situation as someone else.",
            definitionNative = "В таком же трудном положении, как и кто-то другой. Дословно — «в той же лодке».",
            example = "Don't worry, we're all in the same boat with these layoffs.",
            exampleNative = "Не переживай, мы все in the same boat из-за этих сокращений.",
            pos = "phrase", semanticGroup = "idioms_l2_struggle", fillInBlankExclusions = listOf(40610L, 40615L, 40616L, 40617L, 40618L, 40620L)),

        WordEntity(id = 40620, setId = 406, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "hit rock bottom", transliteration = "[hɪt rɑk ˈbɑtəm]", translation = "опуститься на самое дно",
            definition = "To reach the lowest, worst point in your life.",
            definitionNative = "Достичь самой низкой, худшей точки в своей жизни. Дословно — «удариться о каменное дно».",
            example = "After losing his job and home, he had hit rock bottom.",
            exampleNative = "Потеряв работу и дом, он had hit rock bottom.",
            pos = "phrase", semanticGroup = "idioms_l2_struggle", fillInBlankExclusions = listOf(40605L, 40608L, 40616L, 40617L, 40618L, 40619L)),

        // ── idioms_l2_success_failure (5) ─────────────────────────────────

        WordEntity(id = 40621, setId = 406, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "fall flat", transliteration = "[fɔl flæt]", translation = "провалиться, не иметь успеха",
            definition = "To fail completely, especially when trying to entertain or impress.",
            definitionNative = "Полностью провалиться, особенно когда пытался развлечь или впечатлить. Дословно — «упасть плашмя».",
            example = "We were afraid the new show would fall flat with the audience.",
            exampleNative = "Мы боялись, что новое шоу fall flat у зрителей.",
            pos = "phrase", semanticGroup = "idioms_l2_success_failure", fillInBlankExclusions = listOf(40620L, 40622L, 40623L, 40624L, 40625L)),

        WordEntity(id = 40622, setId = 406, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "go viral", transliteration = "[ɡoʊ ˈvaɪrəl]", translation = "стать вирусным (в интернете)",
            definition = "To spread very quickly online and be seen by many people.",
            definitionNative = "Очень быстро распространиться в интернете и быть увиденным множеством людей. Дословно — «стать вирусным».",
            example = "Every brand dreams of making a video go viral overnight.",
            exampleNative = "Каждый бренд мечтает, чтобы его видео go viral за ночь.",
            pos = "phrase", semanticGroup = "idioms_l2_success_failure", fillInBlankExclusions = listOf(40621L, 40623L, 40624L, 40625L)),

        WordEntity(id = 40623, setId = 406, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "make ends meet", transliteration = "[meɪk ɛndz mit]", translation = "сводить концы с концами",
            definition = "To earn just enough money to pay for the things you need.",
            definitionNative = "Зарабатывать ровно столько, чтобы хватало на необходимое. Дословно — «свести концы вместе».",
            example = "With two kids, it's hard to make ends meet on one salary.",
            exampleNative = "С двумя детьми трудно make ends meet на одну зарплату.",
            pos = "phrase", semanticGroup = "idioms_l2_success_failure", fillInBlankExclusions = listOf(40607L, 40621L, 40622L, 40624L, 40625L)),

        WordEntity(id = 40624, setId = 406, languagePair = "en-ru", rarity = "RARE",
            original = "turn the corner", transliteration = "[tɜrn ðə ˈkɔrnər]", translation = "переломить ситуацию (≈ пойти на поправку)",
            definition = "To pass the worst stage of a problem and start to improve.",
            definitionNative = "Пройти худшую стадию проблемы и начать выправляться. Дословно — «повернуть за угол».",
            example = "After months of losses, the company is starting to turn the corner.",
            exampleNative = "После месяцев убытков компания начинает turn the corner.",
            pos = "phrase", semanticGroup = "idioms_l2_success_failure", fillInBlankExclusions = listOf(40614L, 40616L, 40617L, 40621L, 40622L, 40623L, 40625L)),

        WordEntity(id = 40625, setId = 406, languagePair = "en-ru", rarity = "RARE",
            original = "raise the bar", transliteration = "[reɪz ðə bɑr]", translation = "поднять планку",
            definition = "To set a higher standard that others now have to match.",
            definitionNative = "Задать более высокий стандарт для остальных. Дословно — «поднять планку».",
            example = "We need to raise the bar for quality on every new project.",
            exampleNative = "Нам нужно raise the bar по качеству на каждом новом проекте.",
            pos = "phrase", semanticGroup = "idioms_l2_success_failure", fillInBlankExclusions = listOf(40603L, 40614L, 40621L, 40622L, 40623L, 40624L)),
    )
}
