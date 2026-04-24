package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Journalism (set 311, level 5).
 *
 * Set 311: Журналистика: язык носителя (L5) — архаичная и редкая терминология
 * медиа-индустрии. Старые типографские профессии и техники (linotype,
 * compositor, rotogravure, halftone, galley proof, pressman, stereotype plate),
 * анатомия материала на профессиональном жаргоне (standfirst, nutgraf, kicker,
 * strapline, deck, slug), забытые амплуа (muckraker, leader writer, hack),
 * исторические форматы и издания (broadsheet, broadside, gazette, penny
 * dreadful, samizdat) и исторические понятия пресс-индустрии (nameplate,
 * colophon, fourth estate, yellow journalism).
 *
 * Распределение редкости: 5 EPIC + 20 LEGENDARY — два смежных уровня по
 * шкале валидатора (требование validate_rarity_spread).
 *
 * Соседи по теме «Журналистика» (en-ru):
 *  - Set 305 — COMMON / UNCOMMON (L1, основы): news, story, interview, ...
 *  - Set 33  — UNCOMMON (L2): commentary, headline, editor, ...
 *  - Set 51  — RARE (L3): broadcast, media, bias, censorship, ...
 *  - Set 310 — EPIC / LEGENDARY (L4, профессиональный): subedit, lede,
 *              defamation, op-ed, stringer, byline, dateline, masthead, ...
 * Слова из этих наборов не дублируются здесь (проверено grep'ом по setId).
 */
object WordDataEnglishJournalismL5 {

    val sets = listOf(
        WordSetEntity(
            id = 311,
            name = "Журналистика",
            description = "Язык носителя: архаичная и редкая терминология медиа-индустрии",
            orderIndex = 131,
            languagePair = "en-ru",
            topic = "Журналистика",
            level = 5,
        ),
    )

    val words = listOf(

        // ── Set 311 — Журналистика: язык носителя (L5) ─────────────────────────

        // LEGENDARY — press_archaic_production (типографские техники и профессии)
        WordEntity(
            id = 31101, original = "linotype", transliteration = "[ˈlaɪnəˌtaɪp]",
            translation = "линотип (наборная машина)",
            rarity = "LEGENDARY", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_production",
            definition = "An old hot-metal typesetting machine that cast a whole row of letters at once.",
            example = "The print shop kept one linotype as a museum piece for visitors.",
            definitionNative = "Старая машина горячего набора — отливала целый ряд букв за раз.",
            exampleNative = "Типография держала один linotype как музейный экспонат для посетителей.",
            fillInBlankExclusions = listOf(31103L, 31104L, 31105L, 31107L)),
        WordEntity(
            id = 31102, original = "stereotype plate", transliteration = "[ˈstɛriəˌtaɪp pleɪt]",
            translation = "печатная форма (отлитая со набора)",
            rarity = "LEGENDARY", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_production",
            definition = "A curved metal sheet cast from type for fast rotary runs of one page.",
            example = "Each press needed a fresh stereotype plate before the morning run.",
            definitionNative = "Изогнутый металлический лист, отлитый со набора — для быстрой ротационной печати.",
            exampleNative = "На каждый ротатор нужна была свежая stereotype plate до утреннего тиража.",
            fillInBlankExclusions = listOf(31106L)),
        WordEntity(
            id = 31103, original = "compositor", transliteration = "[kəmˈpɑzətər]",
            translation = "наборщик (вручную)",
            rarity = "LEGENDARY", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_production",
            definition = "An old craftsman who arranged metal letters by hand into pages of text.",
            example = "The compositor bent over the case and picked each letter by feel.",
            definitionNative = "Старинный мастер — вручную складывал металлические литеры в готовые полосы.",
            exampleNative = "Compositor склонился над кассой и брал каждую литеру на ощупь.",
            fillInBlankExclusions = listOf(31101L, 31104L, 31105L, 31106L, 31107L)),
        WordEntity(
            id = 31104, original = "rotogravure", transliteration = "[ˌroʊtəɡrəˈvjʊr]",
            translation = "глубокая ротационная печать",
            rarity = "LEGENDARY", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_production",
            definition = "An old deep-etched cylinder method for rich photo pages on long runs.",
            example = "Sunday colour pages came off a rotogravure press in the basement.",
            definitionNative = "Старый способ печати с глубоко травлёным цилиндром — давал богатые фотополосы большим тиражом.",
            exampleNative = "Цветные воскресные полосы шли с rotogravure пресса в подвале.",
            fillInBlankExclusions = listOf(31101L, 31103L, 31105L, 31106L, 31107L)),
        WordEntity(
            id = 31105, original = "halftone", transliteration = "[ˈhɑfˌtoʊn]",
            translation = "растровое изображение",
            rarity = "LEGENDARY", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_production",
            definition = "A photo turned into a pattern of tiny dots so a press can put it on paper.",
            example = "The portrait showed every wrinkle once it became a halftone in tomorrow's paper.",
            definitionNative = "Снимок, преобразованный в узор крошечных точек — чтобы пресс смог его оттиснуть.",
            exampleNative = "Портрет показал каждую морщину, став halftone в завтрашней газете.",
            fillInBlankExclusions = listOf(31101L, 31103L, 31104L, 31107L)),
        WordEntity(
            id = 31106, original = "galley proof", transliteration = "[ˈɡæli pruf]",
            translation = "гранка (пробный оттиск)",
            rarity = "LEGENDARY", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_production",
            definition = "An early test print of a story before it goes into a real page layout.",
            example = "The editor scribbled corrections all over the galley proof in red ink.",
            definitionNative = "Ранний пробный оттиск материала — до того как его поставят в реальную полосу.",
            exampleNative = "Редактор испещрил красными правками всю galley proof.",
            fillInBlankExclusions = listOf(31102L, 31103L, 31104L)),
        WordEntity(
            id = 31107, original = "pressman", transliteration = "[ˈprɛsmən]",
            translation = "печатник (рабочий пресса)",
            rarity = "LEGENDARY", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_production",
            definition = "A skilled worker who ran the heavy old machines that turned ink into pages.",
            example = "The old pressman could smell when the ink ran low on his machine.",
            definitionNative = "Опытный рабочий, обслуживавший тяжёлые старые машины, превращавшие краску в полосы.",
            exampleNative = "Старый pressman мог по запаху понять, когда у машины кончается краска.",
            fillInBlankExclusions = listOf(31101L, 31103L, 31104L, 31105L)),

        // LEGENDARY — press_archaic_content_parts (профессиональный жаргон редакции)
        WordEntity(
            id = 31108, original = "standfirst", transliteration = "[ˈstændˌfɜrst]",
            translation = "вводный абзац (UK)",
            rarity = "LEGENDARY", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_content_parts",
            definition = "A short bold paragraph below the title that sums up the whole piece in two lines.",
            example = "The standfirst told you everything important even if you read no further.",
            definitionNative = "Короткий жирный абзац под заголовком — пересказывает весь материал в двух строках.",
            exampleNative = "Standfirst сообщал всё важное, даже если дальше ты не читал.",
            fillInBlankExclusions = listOf(31109L, 31111L)),
        WordEntity(
            id = 31109, original = "nutgraf", transliteration = "[ˈnʌtɡræf]",
            translation = "суть-абзац (объясняющий смысл)",
            rarity = "LEGENDARY", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_content_parts",
            definition = "A short paragraph that quickly tells the reader why the whole story matters today.",
            example = "The editor moved the nutgraf higher so readers got the point in ten seconds.",
            definitionNative = "Короткий абзац — быстро объясняет читателю, почему весь материал сегодня важен.",
            exampleNative = "Редактор поднял nutgraf повыше — чтобы читатели поняли смысл за десять секунд.",
            fillInBlankExclusions = listOf(31108L, 31110L, 31111L, 31112L, 31113L)),
        WordEntity(
            id = 31110, original = "kicker", transliteration = "[ˈkɪkər]",
            translation = "мини-заголовок (над основным)",
            rarity = "LEGENDARY", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_content_parts",
            definition = "A small line of bold text placed above a headline as a teaser.",
            example = "A witty kicker often did more for circulation than a long subhead.",
            definitionNative = "Маленькая жирная строка над заголовком — как затравка для читателя.",
            exampleNative = "Остроумный kicker часто делал для тиража больше, чем длинный подзаголовок.",
            fillInBlankExclusions = listOf(31108L, 31109L, 31111L, 31112L, 31113L)),
        WordEntity(
            id = 31111, original = "strapline", transliteration = "[ˈstræpˌlaɪn]",
            translation = "подзаголовок-полоска (UK)",
            rarity = "LEGENDARY", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_content_parts",
            definition = "A small extra line of text under a main title that adds another idea or hook.",
            example = "The strapline under the bold title cracked a small joke about the weather.",
            definitionNative = "Маленькая дополнительная строка под основным заголовком — добавляет ещё мысль или зацепку.",
            exampleNative = "Strapline под основным заголовком отпускал маленькую шутку о погоде.",
            fillInBlankExclusions = listOf(31108L, 31109L, 31110L)),
        WordEntity(
            id = 31112, original = "deck", transliteration = "[dɛk]",
            translation = "вторичный заголовок (под основным)",
            rarity = "EPIC", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_content_parts",
            definition = "A second bold line below a main title that gives the reader more of the story.",
            example = "The deck below the front-page title added a wry comment about the loss.",
            definitionNative = "Вторая жирная строка под основным заголовком — даёт читателю больше деталей материала.",
            exampleNative = "Deck под заголовком первой полосы добавил язвительное замечание о провале.",
            fillInBlankExclusions = listOf(31109L, 31110L, 31113L)),
        WordEntity(
            id = 31113, original = "slug", transliteration = "[slʌɡ]",
            translation = "рабочая метка материала",
            rarity = "LEGENDARY", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_content_parts",
            definition = "A short tag used inside the office to find a story before it has a real title.",
            example = "Every desk knew the story by its slug long before the headline was set.",
            definitionNative = "Короткая метка внутри редакции — чтобы найти материал, пока у него нет настоящего названия.",
            exampleNative = "В редакции материал знали по slug задолго до того, как был согласован заголовок.",
            fillInBlankExclusions = listOf(31109L, 31110L, 31112L)),

        // LEGENDARY — press_archaic_people (забытые амплуа репортёров)
        WordEntity(
            id = 31114, original = "muckraker", transliteration = "[ˈmʌkˌreɪkər]",
            translation = "разоблачитель (старого образца)",
            rarity = "LEGENDARY", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_people",
            definition = "An early reporter who dug into rich men's dirty secrets to shake the public.",
            example = "The famous muckraker spent two years inside a meatpacking plant for one piece.",
            definitionNative = "Ранний репортёр, копавшийся в грязных тайнах богачей, чтобы встряхнуть общество.",
            exampleNative = "Знаменитый muckraker провёл два года на мясокомбинате ради одного материала."),
        WordEntity(
            id = 31115, original = "leader writer", transliteration = "[ˈlidər ˈraɪtər]",
            translation = "автор передовиц (UK)",
            rarity = "EPIC", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_people",
            definition = "A senior staff hand who pens unsigned pieces stating the paper's own view.",
            example = "Their veteran leader writer drafted the angry editorial about the new tax.",
            definitionNative = "Старший штатный сотрудник — пишет неподписанные материалы, излагающие позицию издания.",
            exampleNative = "Их ветеран leader writer написал гневную передовицу о новом налоге."),
        WordEntity(
            id = 31116, original = "hack", transliteration = "[hæk]",
            translation = "писака (пренебр.)",
            rarity = "LEGENDARY", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_people",
            definition = "A scornful old name for a tired reporter who churns out cheap copy for hire.",
            example = "The barfly turned out to be an old Fleet Street hack with a thousand stories.",
            definitionNative = "Презрительное старое прозвище уставшего репортёра, штампующего дешёвые тексты на заказ.",
            exampleNative = "Завсегдатай бара оказался старым флитстритовским hack с тысячей историй."),

        // EPIC/LEGENDARY — press_archaic_outlets (исторические форматы и издания)
        WordEntity(
            id = 31117, original = "broadsheet", transliteration = "[ˈbrɔdˌʃit]",
            translation = "качественная газета (большого формата)",
            rarity = "EPIC", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_outlets",
            definition = "A large-format quality paper, traditionally aimed at serious adult readers.",
            example = "The morning broadsheet still landed on his doorstep folded in three.",
            definitionNative = "Крупноформатное качественное издание — традиционно для серьёзного взрослого читателя.",
            exampleNative = "Утренний broadsheet до сих пор падал к нему на порог, сложенный втрое.",
            fillInBlankExclusions = listOf(31118L, 31119L, 31121L)),
        WordEntity(
            id = 31118, original = "broadside", transliteration = "[ˈbrɔdˌsaɪd]",
            translation = "одностраничная прокламация (историч.)",
            rarity = "LEGENDARY", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_outlets",
            definition = "A historical one-sheet pamphlet pasted on walls to spread news or angry verse.",
            example = "A printed broadside about the king's taxes circulated through every tavern.",
            definitionNative = "Исторический однополосный листок — клеили на стены, разнося новости или гневные стихи.",
            exampleNative = "По всем тавернам ходил печатный broadside о королевских налогах.",
            fillInBlankExclusions = listOf(31117L, 31119L, 31121L)),
        WordEntity(
            id = 31119, original = "gazette", transliteration = "[ɡəˈzɛt]",
            translation = "официальный вестник (историч.)",
            rarity = "LEGENDARY", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_outlets",
            definition = "A historical paper of official notices — court orders, ranks and government acts.",
            example = "His promotion appeared in the royal gazette on a cold November morning.",
            definitionNative = "Историческое издание официальных извещений — приказы, чины, государственные акты.",
            exampleNative = "Его повышение вышло в королевской gazette холодным ноябрьским утром.",
            fillInBlankExclusions = listOf(31117L, 31118L, 31121L)),
        WordEntity(
            id = 31120, original = "penny dreadful", transliteration = "[ˈpɛni ˈdrɛdfəl]",
            translation = "грошовый сенсационный листок (Викторианский)",
            rarity = "LEGENDARY", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_outlets",
            definition = "A cheap Victorian booklet of bloody, shocking tales sold for a single coin.",
            example = "Boys hid every penny dreadful from teachers who called the booklets vulgar trash.",
            definitionNative = "Дешёвая викторианская книжица кровавых жутких историй — продавалась за одну монетку.",
            exampleNative = "Мальчишки прятали каждый penny dreadful от учителей — те звали их пошлой дрянью."),
        WordEntity(
            id = 31121, original = "samizdat", transliteration = "[ˈsɑmɪzˌdɑt]",
            translation = "самиздат (запрещённые тексты)",
            rarity = "LEGENDARY", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_outlets",
            definition = "Forbidden writings copied by hand or typewriter and passed in secret under a regime.",
            example = "The smuggled samizdat changed hands in stairwells and locked university toilets.",
            definitionNative = "Запрещённые тексты — переписанные вручную или на машинке и тайно передаваемые при режиме.",
            exampleNative = "Контрабандный samizdat переходил из рук в руки на лестницах и в закрытых университетских туалетах.",
            fillInBlankExclusions = listOf(31117L, 31118L, 31119L)),

        // EPIC/LEGENDARY — press_archaic_concepts (исторические понятия пресс-индустрии)
        WordEntity(
            id = 31122, original = "nameplate", transliteration = "[ˈneɪmˌpleɪt]",
            translation = "титульная плашка издания",
            rarity = "EPIC", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_concepts",
            definition = "The big banner across page one showing a paper's name in its old typeface.",
            example = "The famous nameplate had used the same gothic letters for over a century.",
            definitionNative = "Большой баннер вверху первой полосы — показывает название газеты историческим шрифтом.",
            exampleNative = "Знаменитая nameplate использовала те же готические буквы более века.",
            fillInBlankExclusions = listOf(31123L)),
        WordEntity(
            id = 31123, original = "colophon", transliteration = "[ˈkɑləˌfɑn]",
            translation = "выходные сведения (в конце книги)",
            rarity = "LEGENDARY", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_concepts",
            definition = "A short note at the end of a book listing the printer, the year and the type used.",
            example = "The colophon proudly named a tiny press in a Belgian mountain town.",
            definitionNative = "Короткая запись в конце книги — печатник, год выпуска и использованный шрифт.",
            exampleNative = "Colophon с гордостью указывал крошечную типографию в бельгийском горном городке.",
            fillInBlankExclusions = listOf(31122L)),
        WordEntity(
            id = 31124, original = "fourth estate", transliteration = "[fɔrθ ɪˈsteɪt]",
            translation = "четвёртая власть (пресса)",
            rarity = "LEGENDARY", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_concepts",
            definition = "An old name for the press as a power that watches the other three branches.",
            example = "The young senator quickly learned to fear the fourth estate at every committee.",
            definitionNative = "Старое название прессы — силы, которая следит за тремя другими ветвями власти.",
            exampleNative = "Молодой сенатор быстро научился побаиваться fourth estate на каждом комитете.",
            fillInBlankExclusions = listOf(31125L)),
        WordEntity(
            id = 31125, original = "yellow journalism", transliteration = "[ˈjɛloʊ ˈʤərnəlɪzəm]",
            translation = "жёлтая журналистика (сенсационная)",
            rarity = "EPIC", setId = 311, languagePair = "en-ru", pos = "noun",
            semanticGroup = "press_archaic_concepts",
            definition = "An old style of cheap, screaming reporting that sold copies by shock and scandal.",
            example = "Critics called the new tabloid the worst yellow journalism since the war years.",
            definitionNative = "Старый стиль дешёвой крикливой подачи — тиражи продавали скандалом и шоком.",
            exampleNative = "Критики назвали новый таблоид худшим yellow journalism со времён войны.",
            fillInBlankExclusions = listOf(31124L)),
    )
}
