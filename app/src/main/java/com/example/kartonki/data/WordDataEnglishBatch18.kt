package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — batch 18.
 * Тема: Настольные игры (en-ru).
 * Первый сет (level 1) из запланированной серии 300-304 — основы/продвинутый/
 * углублённый/профессиональный/носитель языка. Остальные 4 сета — в
 * следующих batch-файлах.
 *
 * Set 300: Настольные игры: основы (L1 / COMMON+UNCOMMON).
 * 4 semanticGroup: objects (физические атрибуты), verbs (действия),
 * concepts (абстрактные), classic (chess/checkers как классическая пара).
 */
object WordDataEnglishBatch18 {

    val sets = listOf(
        WordSetEntity(id = 300, name = "Настольные игры: основы",
            description = "Базовая лексика: доска, кубики, карты, ходы и очки",
            languagePair = "en-ru",
            topic = "Настольные игры", level = 1),
    )

    val words = listOf(

        // ── Set 300 — Настольные игры: основы (COMMON + UNCOMMON) ───────────────

        // COMMON — boardgame_concepts (абстрактные: игра, игрок, ход, счёт, правило, команда, очко)
        WordEntity(id = 30001, original = "game", transliteration = "[ɡeɪm]", translation = "игра", rarity = "COMMON", setId = 300, languagePair = "en-ru", pos = "noun", semanticGroup = "boardgame_concepts",
            definition = "An activity with rules where people play for fun or to win.",
            example = "We played a fun game with the whole family.",
            definitionNative = "Занятие с правилами — ради удовольствия или победы.",
            exampleNative = "Мы играли в увлекательный game всей семьёй.", fillInBlankExclusions = listOf(30002L, 30003L, 30004L, 30005L, 30006L, 30007L)),
        WordEntity(id = 30002, original = "player", transliteration = "[ˈpleɪər]", translation = "игрок", rarity = "COMMON", setId = 300, languagePair = "en-ru", pos = "noun", semanticGroup = "boardgame_concepts",
            definition = "A person taking part in a game — you, a friend, or an opponent.",
            example = "Each player picks a colour at the start.",
            definitionNative = "Участник, который ходит, двигает фишки и соревнуется с другими.",
            exampleNative = "Каждый player выбирает цвет в начале партии.", fillInBlankExclusions = listOf(30001L, 30003L, 30004L, 30005L, 30006L, 30007L)),
        WordEntity(id = 30003, original = "turn", transliteration = "[tɜrn]", translation = "ход, очередь", rarity = "COMMON", setId = 300, languagePair = "en-ru", pos = "noun", semanticGroup = "boardgame_concepts",
            definition = "Your moment to play — when everyone else waits for you.",
            example = "It's your turn — pick up a card now.",
            definitionNative = "Момент, когда приходит твоя очередь действовать за столом.",
            exampleNative = "Твой turn — бери карту и делай движение.", fillInBlankExclusions = listOf(30001L, 30002L, 30004L, 30005L, 30006L, 30007L)),
        WordEntity(id = 30004, original = "score", transliteration = "[skɔr]", translation = "счёт, очки", rarity = "COMMON", setId = 300, languagePair = "en-ru", pos = "noun", semanticGroup = "boardgame_concepts",
            definition = "The number of points you have earned so far in a game.",
            example = "She had the highest score after three rounds.",
            definitionNative = "Количество набранных очков — показывает, кто впереди.",
            exampleNative = "После трёх раундов у неё был лучший score.", fillInBlankExclusions = listOf(30001L, 30002L, 30003L, 30005L, 30006L, 30007L)),
        WordEntity(id = 30005, original = "rule", transliteration = "[rul]", translation = "правило", rarity = "COMMON", setId = 300, languagePair = "en-ru", pos = "noun", semanticGroup = "boardgame_concepts",
            definition = "An instruction that tells you what you can or cannot do.",
            example = "The first rule says you cannot skip your turn.",
            definitionNative = "Указание, что в игре можно, а чего делать нельзя.",
            exampleNative = "Первое rule говорит: пропускать ход нельзя.", fillInBlankExclusions = listOf(30001L, 30002L, 30004L, 30006L, 30007L)),
        WordEntity(id = 30006, original = "team", transliteration = "[tim]", translation = "команда", rarity = "COMMON", setId = 300, languagePair = "en-ru", pos = "noun", semanticGroup = "boardgame_concepts",
            definition = "A group of players who work together against other groups.",
            example = "Our team won the tournament by two points.",
            definitionNative = "Группа игроков, которые вместе играют против других.",
            exampleNative = "Наш team выиграл турнир на два очка.", fillInBlankExclusions = listOf(30001L, 30002L, 30003L, 30004L, 30005L, 30007L)),
        WordEntity(id = 30007, original = "point", transliteration = "[pɔɪnt]", translation = "очко", rarity = "COMMON", setId = 300, languagePair = "en-ru", pos = "noun", semanticGroup = "boardgame_concepts",
            definition = "A single unit you earn — collect enough of them to win.",
            example = "He earned one point for each correct answer.",
            definitionNative = "Единица счёта — чем больше накопишь, тем ближе к победе.",
            exampleNative = "Он получил один point за каждый верный ответ.", fillInBlankExclusions = listOf(30001L, 30002L, 30003L, 30004L, 30005L, 30006L)),

        // COMMON — boardgame_objects (физические: доска, кубики, карты, фишки)
        WordEntity(id = 30008, original = "board", transliteration = "[bɔrd]", translation = "доска (игровая)", rarity = "COMMON", setId = 300, languagePair = "en-ru", pos = "noun", semanticGroup = "boardgame_objects",
            definition = "A flat surface with squares or spaces where you place pieces.",
            example = "Set the board on the table before you start.",
            definitionNative = "Плоская поверхность с клетками — основа для фигур и фишек.",
            exampleNative = "Расправь board на столе и расставь фигуры.", fillInBlankExclusions = listOf(30009L, 30010L, 30011L, 30012L, 30023L, 30024L, 30025L)),
        WordEntity(id = 30009, original = "dice", transliteration = "[daɪs]", translation = "кубик (игральный)", rarity = "COMMON", setId = 300, languagePair = "en-ru", pos = "noun", semanticGroup = "boardgame_objects",
            definition = "A small six-sided object with dots — you shake and throw it.",
            example = "Pick up the dice and shake them hard.",
            definitionNative = "Шестигранный предмет с точками — его трясут и бросают на стол.",
            exampleNative = "Возьми dice, потряси и брось на стол.", fillInBlankExclusions = listOf(30008L, 30010L, 30011L, 30012L, 30023L, 30024L, 30025L)),
        WordEntity(id = 30010, original = "card", transliteration = "[kɑrd]", translation = "карта (игральная)", rarity = "COMMON", setId = 300, languagePair = "en-ru", pos = "noun", semanticGroup = "boardgame_objects",
            definition = "A flat piece of thick paper, often with a picture or number.",
            example = "She took a card from the top of the deck.",
            definitionNative = "Плоский прямоугольник из плотной бумаги с рисунком или числом.",
            exampleNative = "Она взяла верхнюю card из колоды.", fillInBlankExclusions = listOf(30008L, 30009L, 30011L, 30012L, 30023L, 30024L, 30025L)),
        WordEntity(id = 30011, original = "piece", transliteration = "[pis]", translation = "фигура, фишка", rarity = "COMMON", setId = 300, languagePair = "en-ru", pos = "noun", semanticGroup = "boardgame_objects",
            definition = "A small object you move around the board as you play.",
            example = "He moved his piece three squares forward.",
            definitionNative = "Небольшой предмет, который двигают по доске во время партии.",
            exampleNative = "Он передвинул свою piece на три клетки вперёд.", fillInBlankExclusions = listOf(30008L, 30009L, 30010L, 30012L, 30023L, 30024L, 30025L)),
        WordEntity(id = 30012, original = "pawn", transliteration = "[pɔn]", translation = "пешка", rarity = "COMMON", setId = 300, languagePair = "en-ru", pos = "noun", semanticGroup = "boardgame_objects",
            definition = "The smallest chess figure that stands in the front row.",
            example = "He lost his last pawn in the middle of the board.",
            definitionNative = "Самая маленькая шахматная фигура, стоит в переднем ряду.",
            exampleNative = "Он потерял последнюю pawn в середине партии.", fillInBlankExclusions = listOf(30009L, 30010L, 30011L, 30023L, 30024L, 30025L)),

        // COMMON — boardgame_verbs (действия: win, lose, roll, move, pass, quit)
        WordEntity(id = 30013, original = "win", transliteration = "[wɪn]", translation = "выигрывать", rarity = "COMMON", setId = 300, languagePair = "en-ru", pos = "verb", semanticGroup = "boardgame_verbs",
            definition = "To finish first — to get more points or reach the goal first.",
            example = "He hopes to win the match against his older brother.",
            definitionNative = "Прийти к победе — оказаться первым или набрать больше всех.",
            exampleNative = "Он надеется win матч у старшего брата.", fillInBlankExclusions = listOf(30014L, 30015L, 30016L, 30017L, 30018L, 30021L, 30022L)),
        WordEntity(id = 30014, original = "lose", transliteration = "[luz]", translation = "проигрывать", rarity = "COMMON", setId = 300, languagePair = "en-ru", pos = "verb", semanticGroup = "boardgame_verbs",
            definition = "To finish behind someone else — to not come first.",
            example = "I don't mind if I lose as long as it's fun.",
            definitionNative = "Оказаться позади — не дойти первым до финиша, не взять верх.",
            exampleNative = "Я не против lose, если было весело играть.", fillInBlankExclusions = listOf(30013L, 30015L, 30016L, 30017L, 30018L, 30021L, 30022L)),
        WordEntity(id = 30015, original = "roll", transliteration = "[roʊl]", translation = "бросать (кубик)", rarity = "COMMON", setId = 300, languagePair = "en-ru", pos = "verb", semanticGroup = "boardgame_verbs",
            definition = "To throw something that turns over and shows a number on top.",
            example = "You roll the cube and move that many spaces.",
            definitionNative = "Кинуть предмет так, чтобы он покатился и выпал на сторону.",
            exampleNative = "Ты roll кубик и двигаешься на выпавшее число.", fillInBlankExclusions = listOf(30013L, 30014L, 30017L, 30018L, 30021L, 30022L)),
        WordEntity(id = 30016, original = "move", transliteration = "[muv]", translation = "двигать, ходить", rarity = "COMMON", setId = 300, languagePair = "en-ru", pos = "verb", semanticGroup = "boardgame_verbs",
            definition = "To change the place of a figure — shift it one spot forward.",
            example = "You can move your knight in an L-shape.",
            definitionNative = "Переставить фигуру — на новую клетку или вдоль дорожки.",
            exampleNative = "Коня можно move буквой «Г».", fillInBlankExclusions = listOf(30013L, 30014L, 30015L, 30017L, 30018L, 30021L, 30022L)),
        WordEntity(id = 30017, original = "pass", transliteration = "[pæs]", translation = "пропускать ход", rarity = "COMMON", setId = 300, languagePair = "en-ru", pos = "verb", semanticGroup = "boardgame_verbs",
            definition = "To skip your move — say nothing and let the next person go.",
            example = "If you have no good move, you can pass.",
            definitionNative = "Ничего не делать в свою очередь и отдать ход следующему.",
            exampleNative = "Если нет хорошего хода, можно pass.", fillInBlankExclusions = listOf(30013L, 30014L, 30015L, 30018L, 30021L, 30022L)),
        WordEntity(id = 30018, original = "quit", transliteration = "[kwɪt]", translation = "выйти из игры", rarity = "COMMON", setId = 300, languagePair = "en-ru", pos = "verb", semanticGroup = "boardgame_verbs",
            definition = "To stop playing before the game is finished, on purpose.",
            example = "He decided to quit after two bad rounds.",
            definitionNative = "Закончить участвовать до конца партии — встать и уйти.",
            exampleNative = "После двух плохих раундов он решил quit.", fillInBlankExclusions = listOf(30013L, 30014L, 30015L, 30016L, 30017L, 30021L, 30022L)),

        // COMMON — boardgame_classic (классические игры — пара)
        WordEntity(id = 30019, original = "chess", transliteration = "[ʧɛs]", translation = "шахматы", rarity = "COMMON", setId = 300, languagePair = "en-ru", pos = "noun", semanticGroup = "boardgame_classic",
            definition = "An old game for two — black and white figures on a checked board.",
            example = "He learned chess from his grandfather.",
            definitionNative = "Старинная игра для двоих — армия из белых и чёрных фигур.",
            exampleNative = "Он научился играть в chess у дедушки.", fillInBlankExclusions = listOf(30020L)),
        WordEntity(id = 30020, original = "checkers", transliteration = "[ˈʧɛkərz]", translation = "шашки", rarity = "COMMON", setId = 300, languagePair = "en-ru", pos = "noun", semanticGroup = "boardgame_classic",
            definition = "A simpler board game — round pieces jump over each other.",
            example = "My sister beats me at checkers every time.",
            definitionNative = "Игра попроще шахмат — круглые фишки перепрыгивают друг через друга.",
            exampleNative = "Сестра обыгрывает меня в checkers раз за разом.", fillInBlankExclusions = listOf(30019L)),

        // UNCOMMON — boardgame_verbs (продвинутые действия: draw, trade)
        WordEntity(id = 30021, original = "draw", transliteration = "[drɔ]", translation = "тянуть (карту)", rarity = "UNCOMMON", setId = 300, languagePair = "en-ru", pos = "verb", semanticGroup = "boardgame_verbs",
            definition = "To take a card from the top of a pile without looking.",
            example = "Draw a card and read what it says out loud.",
            definitionNative = "Взять верхнюю карту из колоды вслепую.",
            exampleNative = "Draw карту и вслух прочитай, что написано.", fillInBlankExclusions = listOf(30013L, 30014L, 30015L, 30016L, 30017L, 30018L, 30022L)),
        WordEntity(id = 30022, original = "trade", transliteration = "[treɪd]", translation = "обменивать", rarity = "UNCOMMON", setId = 300, languagePair = "en-ru", pos = "verb", semanticGroup = "boardgame_verbs",
            definition = "To give something to another person and get something back.",
            example = "I will trade two sheep for one brick with you.",
            definitionNative = "Отдать одну вещь и получить другую — поменяться с соседом.",
            exampleNative = "Я готов trade две овцы за один кирпич.", fillInBlankExclusions = listOf(30013L, 30014L, 30015L, 30016L, 30017L, 30018L, 30021L)),

        // UNCOMMON — boardgame_objects (специфические объекты: tile, domino, spinner)
        WordEntity(id = 30023, original = "tile", transliteration = "[taɪl]", translation = "плитка (игровая)", rarity = "UNCOMMON", setId = 300, languagePair = "en-ru", pos = "noun", semanticGroup = "boardgame_objects",
            definition = "A small flat square or rectangle you place on the board.",
            example = "She drew a tile with a large number on it.",
            definitionNative = "Маленький плоский квадратик — его выкладывают на поле.",
            exampleNative = "Она вытянула tile с большим числом.", fillInBlankExclusions = listOf(30008L, 30009L, 30010L, 30011L, 30012L, 30024L, 30025L)),
        WordEntity(id = 30024, original = "domino", transliteration = "[ˈdɑmɪˌnoʊ]", translation = "домино (костяшка)", rarity = "UNCOMMON", setId = 300, languagePair = "en-ru", pos = "noun", semanticGroup = "boardgame_objects",
            definition = "A long flat block with dots on both halves — you match the ends.",
            example = "He placed a domino with six dots at the end.",
            definitionNative = "Длинная плоская фишка с точками с двух сторон — её ставят рядом.",
            exampleNative = "Он положил domino с шестью точками в конец цепочки.", fillInBlankExclusions = listOf(30008L, 30009L, 30010L, 30011L, 30012L, 30023L, 30025L)),
        WordEntity(id = 30025, original = "spinner", transliteration = "[ˈspɪnər]", translation = "стрелка (вертушка)", rarity = "UNCOMMON", setId = 300, languagePair = "en-ru", pos = "noun", semanticGroup = "boardgame_objects",
            definition = "An arrow on a round card — flick it to pick a colour.",
            example = "Give the spinner a quick flick and see where it stops.",
            definitionNative = "Подвижная стрелка на круге — её крутят, она показывает сектор.",
            exampleNative = "Крутни spinner и посмотри, где остановится стрелка.", fillInBlankExclusions = listOf(30008L, 30009L, 30010L, 30011L, 30012L, 30023L, 30024L)),
    )
}
