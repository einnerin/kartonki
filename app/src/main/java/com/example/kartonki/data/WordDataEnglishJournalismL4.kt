package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Journalism, Level 4 (Professional).
 * Set 310 — профессиональный мир медиа: редакционная работа, правовые аспекты,
 * жаргон отрасли, профессиональные форматы материалов и этика.
 *
 * Rarity strategy: EPIC + LEGENDARY (adjacent CEFR C1-C2+), per rule 3
 * «разброс редкости в наборе ≤ 2 смежных уровня». Level 4 (профессиональный)
 * соответствует знанию отраслевого жаргона и специализированной терминологии.
 *
 * Соседи по теме «Журналистика» (дубли исключены):
 *  - Set 33  — UNCOMMON лексика (commentary, headline, editor, source, column ...).
 *  - Set 51  — RARE лексика (broadcast, media, bias, censorship, propaganda ...).
 *  - Set 305 — COMMON/UNCOMMON основы (news, interview, reporter, newspaper ...).
 *
 * SemanticGroups (5 × 3-6 слов, в оптимуме 3-8):
 *   journalism_editorial_process     — subedit, copyedit, fact-check, lede, nut graf, spike
 *   journalism_legal                 — defamation, libel, slander, privilege, redact
 *   journalism_formats               — op-ed, longform, backgrounder, explainer, exposé
 *   journalism_pro_lingo             — stringer, copydesk, scoop, embargo, attribution
 *   journalism_publication_elements  — byline, dateline, masthead, stylebook
 *
 * Распределение редкости: 16 EPIC + 9 LEGENDARY (2 смежных уровня).
 * Word IDs: 31001..31025 (setId × 100 + position).
 */
object WordDataEnglishJournalismL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 310,
            name = "Журналистика",
            description = "Профессиональный мир медиа: выпуск, редакционная политика, правовые аспекты",
            orderIndex = 130,
            languagePair = "en-ru",
            topic = "Журналистика",
            level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── journalism_editorial_process (редакционный процесс) ────────────
        WordEntity(
            id = 31001, setId = 310, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "subedit", transliteration = "[ˈsʌbˌedɪt]", translation = "готовить текст к печати (вычитка)",
            pos = "verb", semanticGroup = "journalism_editorial_process",
            definition = "To polish a reporter's draft — cut length, fix errors, add a title.",
            definitionNative = "Подготовить текст репортёра к печати — сократить, исправить, придумать заголовок.",
            example = "Jane will subedit the feature before it goes to the printers.",
            exampleNative = "Джейн будет subedit очерк перед отправкой в типографию.",
            fillInBlankExclusions = listOf(31002L, 31004L, 31005L, 31006L),
        ),
        WordEntity(
            id = 31002, setId = 310, languagePair = "en-ru", rarity = "EPIC",
            original = "copyedit", transliteration = "[ˈkɒpiˌedɪt]", translation = "литературно править текст",
            pos = "verb", semanticGroup = "journalism_editorial_process",
            definition = "To correct grammar, spelling and house style in somebody else's text.",
            definitionNative = "Исправить грамматику, орфографию и стиль в чужом тексте перед выходом.",
            example = "She was hired to copyedit a thick book of essays overnight.",
            exampleNative = "Её наняли, чтобы copyedit толстый сборник эссе за ночь.",
            fillInBlankExclusions = listOf(31001L, 31004L, 31005L, 31006L),
        ),
        WordEntity(
            id = 31003, setId = 310, languagePair = "en-ru", rarity = "EPIC",
            original = "fact-check", transliteration = "[ˈfæktˌʧek]", translation = "проверять факты в материале",
            pos = "verb", semanticGroup = "journalism_editorial_process",
            definition = "To verify every claim in a draft against original sources before print.",
            definitionNative = "Сверить каждое утверждение черновика с первоисточниками до выхода номера.",
            example = "An intern was told to fact-check every quote in the feature.",
            exampleNative = "Стажёру поручили fact-check каждую цитату в очерке.",
            fillInBlankExclusions = listOf(31001L, 31002L, 31006L),
        ),
        WordEntity(
            id = 31004, setId = 310, languagePair = "en-ru", rarity = "EPIC",
            original = "lede", transliteration = "[liːd]", translation = "первый абзац (\"зачин\")",
            pos = "noun", semanticGroup = "journalism_editorial_process",
            definition = "The opening paragraph that hooks the reader and states the main point.",
            definitionNative = "Первый абзац материала — зацепляет читателя и излагает суть новости.",
            example = "A strong lede can save even a dull story from the bin.",
            exampleNative = "Сильный lede может спасти даже скучный материал от корзины.",
            fillInBlankExclusions = listOf(31005L, 31025L),
        ),
        WordEntity(
            id = 31005, setId = 310, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "nut graf", transliteration = "[nʌt ɡræf]", translation = "абзац сути статьи",
            pos = "noun", semanticGroup = "journalism_editorial_process",
            definition = "The paragraph a few lines in that explains why this story matters.",
            definitionNative = "Абзац сразу после зачина — объясняет, почему эта история важна читателю.",
            example = "Her draft lacked a nut graf, so readers never learned the point.",
            exampleNative = "В её черновике не было nut graf — читатели так и не поняли сути.",
            fillInBlankExclusions = listOf(31004L, 31025L),
        ),
        WordEntity(
            id = 31006, setId = 310, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "spike", transliteration = "[spaɪk]", translation = "снимать материал с публикации",
            pos = "verb", semanticGroup = "journalism_editorial_process",
            definition = "To kill a finished story — pull it from print after editors decide against it.",
            definitionNative = "Снять готовый материал — убрать из номера по решению редакции.",
            example = "The editor chose to spike the piece just hours before deadline.",
            exampleNative = "Редактор решил spike материал за считанные часы до сдачи.",
            fillInBlankExclusions = listOf(31001L, 31002L, 31003L),
        ),

        // ── journalism_legal (правовые аспекты) ────────────────────────────
        WordEntity(
            id = 31007, setId = 310, languagePair = "en-ru", rarity = "EPIC",
            original = "defamation", transliteration = "[ˌdefəˈmeɪʃən]", translation = "клевета (общий термин)",
            pos = "noun", semanticGroup = "journalism_legal",
            definition = "A false public statement that harms the good name of a real person.",
            definitionNative = "Ложное публичное высказывание, причиняющее вред репутации реального человека.",
            example = "The actor sued the magazine for defamation over a bogus story.",
            exampleNative = "Актёр подал в суд на журнал за defamation из-за выдуманной истории.",
            fillInBlankExclusions = listOf(31008L, 31009L, 31010L, 31011L),
        ),
        WordEntity(
            id = 31008, setId = 310, languagePair = "en-ru", rarity = "EPIC",
            original = "libel", transliteration = "[ˈlaɪbəl]", translation = "клевета в печати",
            pos = "noun", semanticGroup = "journalism_legal",
            definition = "A harmful untrue claim about a person published in writing or on air.",
            definitionNative = "Ложное утверждение о человеке в печати или эфире, наносящее ущерб.",
            example = "The paper lost a huge libel case and had to print an apology.",
            exampleNative = "Газета проиграла крупный иск по libel и напечатала извинения.",
            fillInBlankExclusions = listOf(31007L, 31009L, 31011L),
        ),
        WordEntity(
            id = 31009, setId = 310, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "slander", transliteration = "[ˈslɑːndə]", translation = "устная клевета",
            pos = "noun", semanticGroup = "journalism_legal",
            definition = "An untrue harmful claim made aloud, not in print — at a meeting or on radio.",
            definitionNative = "Ложное вредное утверждение вслух — на собрании или в радиоэфире, не в печати.",
            example = "He won a court battle over slander after the live radio show.",
            exampleNative = "Он выиграл дело по slander после того живого эфира на радио.",
            fillInBlankExclusions = listOf(31007L, 31008L, 31011L),
        ),
        WordEntity(
            id = 31010, setId = 310, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "privilege", transliteration = "[ˈprɪvɪlɪʤ]", translation = "правовой иммунитет репортажа",
            pos = "noun", semanticGroup = "journalism_legal",
            definition = "A legal shield for fair reports of court and parliament — no libel suits.",
            definitionNative = "Правовой щит для честных отчётов о судах и парламенте — иски за клевету невозможны.",
            example = "Parliamentary privilege let the paper print the whole testimony safely.",
            exampleNative = "Парламентский privilege позволил газете напечатать показания без риска.",
            fillInBlankExclusions = listOf(31007L, 31008L, 31009L, 31011L),
        ),
        WordEntity(
            id = 31011, setId = 310, languagePair = "en-ru", rarity = "EPIC",
            original = "redact", transliteration = "[rɪˈdækt]", translation = "затирать (в документе)",
            pos = "verb", semanticGroup = "journalism_legal",
            definition = "To black out sensitive names or numbers in a document before you release it.",
            definitionNative = "Замазать фамилии или цифры в документе перед публикацией, чтобы их не видели.",
            example = "Lawyers asked the paper to redact every witness name in the file.",
            exampleNative = "Юристы попросили газету redact все фамилии свидетелей в деле.",
            fillInBlankExclusions = listOf(31007L, 31008L, 31009L, 31010L),
        ),

        // ── journalism_formats (профессиональные форматы) ──────────────────
        WordEntity(
            id = 31012, setId = 310, languagePair = "en-ru", rarity = "EPIC",
            original = "op-ed", transliteration = "[ˌɒpˈed]", translation = "авторская колонка мнения",
            pos = "noun", semanticGroup = "journalism_formats",
            definition = "A signed opinion piece by an outside writer on the page facing the editorials.",
            definitionNative = "Авторское мнение внешнего эксперта на странице рядом с редакционными статьями.",
            example = "She wrote a sharp op-ed about the new city budget.",
            exampleNative = "Она написала острый op-ed о новом городском бюджете.",
            fillInBlankExclusions = listOf(31013L, 31014L, 31015L, 31016L),
        ),
        WordEntity(
            id = 31013, setId = 310, languagePair = "en-ru", rarity = "EPIC",
            original = "longform", transliteration = "[ˈlɒŋfɔːm]", translation = "длинный журналистский материал",
            pos = "noun", semanticGroup = "journalism_formats",
            definition = "A deep piece of several thousand words with scenes, dialogue and analysis.",
            definitionNative = "Глубокий материал на несколько тысяч слов — со сценами, диалогом и анализом.",
            example = "His longform on prison life took two years of quiet research.",
            exampleNative = "Его longform о жизни в тюрьме стоил двух лет тихой работы.",
            fillInBlankExclusions = listOf(31012L, 31014L, 31015L, 31016L),
        ),
        WordEntity(
            id = 31014, setId = 310, languagePair = "en-ru", rarity = "EPIC",
            original = "backgrounder", transliteration = "[ˈbækˌɡraʊndə]", translation = "справочный материал (контекст)",
            pos = "noun", semanticGroup = "journalism_formats",
            definition = "A piece that explains the history and context behind today's big news.",
            definitionNative = "Материал, который излагает историю и контекст позади сегодняшней крупной новости.",
            example = "The weekend paper ran a long backgrounder on the border crisis.",
            exampleNative = "В выходных газетах вышел длинный backgrounder о кризисе на границе.",
            fillInBlankExclusions = listOf(31012L, 31013L, 31015L, 31016L),
        ),
        WordEntity(
            id = 31015, setId = 310, languagePair = "en-ru", rarity = "EPIC",
            original = "explainer", transliteration = "[ɪkˈspleɪnə]", translation = "разъяснительный материал",
            pos = "noun", semanticGroup = "journalism_formats",
            definition = "A short piece that answers basic questions about a hard topic in plain words.",
            definitionNative = "Короткий материал — отвечает на основные вопросы по сложной теме простым языком.",
            example = "The site ran an explainer on how the new pension law works.",
            exampleNative = "На сайте вышел explainer о том, как работает новый пенсионный закон.",
            fillInBlankExclusions = listOf(31012L, 31013L, 31014L, 31016L),
        ),
        WordEntity(
            id = 31016, setId = 310, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "exposé", transliteration = "[ɪkˈspəʊzeɪ]", translation = "разоблачительный материал",
            pos = "noun", semanticGroup = "journalism_formats",
            definition = "A long published report that reveals wrongdoing somebody has tried to hide.",
            definitionNative = "Большой опубликованный отчёт — вскрывает злоупотребления, которые пытались скрыть.",
            example = "Her exposé on the charity's missing funds forced a full police probe.",
            exampleNative = "Её exposé о пропавших средствах фонда вынудил полицию начать проверку.",
            fillInBlankExclusions = listOf(31012L, 31013L, 31014L, 31015L),
        ),

        // ── journalism_pro_lingo (профессиональный жаргон) ─────────────────
        WordEntity(
            id = 31017, setId = 310, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "stringer", transliteration = "[ˈstrɪŋə]", translation = "внештатный корреспондент",
            pos = "noun", semanticGroup = "journalism_pro_lingo",
            definition = "A freelance writer hired piece by piece in a city far from head office.",
            definitionNative = "Внештатник — пишет материалы из города вдалеке от центральной редакции за плату.",
            example = "Our stringer in Beirut sent a vivid dispatch about the rally.",
            exampleNative = "Наш stringer в Бейруте прислал яркий репортаж с митинга.",
            fillInBlankExclusions = listOf(31018L),
        ),
        WordEntity(
            id = 31018, setId = 310, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "copydesk", transliteration = "[ˈkɒpiˌdesk]", translation = "редакторский отдел (\"стол\")",
            pos = "noun", semanticGroup = "journalism_pro_lingo",
            definition = "The team at a paper that polishes and lays out every story before print.",
            definitionNative = "Команда в газете — вычитывает и вёрстывает каждый материал перед печатью.",
            example = "The copydesk found two errors minutes before the front page closed.",
            exampleNative = "Copydesk нашла две ошибки за минуты до закрытия первой полосы.",
            fillInBlankExclusions = listOf(31017L),
        ),
        WordEntity(
            id = 31019, setId = 310, languagePair = "en-ru", rarity = "EPIC",
            original = "scoop", transliteration = "[skuːp]", translation = "эксклюзивная сенсация",
            pos = "noun", semanticGroup = "journalism_pro_lingo",
            definition = "A big news story you print before any of your rivals get the information.",
            definitionNative = "Крупная новость — выдаёшь её первым, пока конкуренты ещё не знают о событии.",
            example = "The cub reporter landed a scoop on the mayor's secret deal.",
            exampleNative = "Молодой репортёр добыл scoop о тайной сделке мэра.",
            fillInBlankExclusions = listOf(31020L, 31021L),
        ),
        WordEntity(
            id = 31020, setId = 310, languagePair = "en-ru", rarity = "EPIC",
            original = "embargo", transliteration = "[emˈbɑːɡəʊ]", translation = "эмбарго на публикацию",
            pos = "noun", semanticGroup = "journalism_pro_lingo",
            definition = "A rule from a source that holds a story back until an agreed date.",
            definitionNative = "Условие источника — попридержать материал до согласованной даты выхода.",
            example = "The study is under an embargo until Monday at nine in the morning.",
            exampleNative = "Исследование под embargo до понедельника до девяти утра.",
            fillInBlankExclusions = listOf(31019L, 31021L),
        ),
        WordEntity(
            id = 31021, setId = 310, languagePair = "en-ru", rarity = "EPIC",
            original = "attribution", transliteration = "[ˌætrɪˈbjuːʃən]", translation = "ссылка на источник",
            pos = "noun", semanticGroup = "journalism_pro_lingo",
            definition = "The line in a piece that tells the reader who gave each claim or quote.",
            definitionNative = "Фраза в тексте — указывает читателю, от кого получено каждое утверждение.",
            example = "A good reporter gives attribution for every hard claim in the story.",
            exampleNative = "Хороший репортёр даёт attribution для каждого серьёзного утверждения.",
            fillInBlankExclusions = listOf(31019L, 31020L),
        ),

        // ── journalism_publication_elements (элементы выпуска) ─────────────
        WordEntity(
            id = 31022, setId = 310, languagePair = "en-ru", rarity = "EPIC",
            original = "byline", transliteration = "[ˈbaɪlaɪn]", translation = "строка с именем автора",
            pos = "noun", semanticGroup = "journalism_publication_elements",
            definition = "The small line at the top of a piece that tells who wrote it.",
            definitionNative = "Маленькая строка вверху материала — сообщает, кто написал статью.",
            example = "She saw her name in a real byline for the first time that day.",
            exampleNative = "В тот день она впервые увидела своё имя в настоящем byline.",
            fillInBlankExclusions = listOf(31023L, 31024L, 31025L),
        ),
        WordEntity(
            id = 31023, setId = 310, languagePair = "en-ru", rarity = "EPIC",
            original = "dateline", transliteration = "[ˈdeɪtlaɪn]", translation = "место и дата написания",
            pos = "noun", semanticGroup = "journalism_publication_elements",
            definition = "The line at the start of a piece that gives the city and day of filing.",
            definitionNative = "Строка в начале материала — указывает город и день, когда был сдан текст.",
            example = "The dateline read Kyiv, and every reader understood the weight.",
            exampleNative = "В dateline стояло «Киев», и каждый читатель понимал значимость.",
            fillInBlankExclusions = listOf(31022L, 31024L, 31025L),
        ),
        WordEntity(
            id = 31024, setId = 310, languagePair = "en-ru", rarity = "EPIC",
            original = "masthead", transliteration = "[ˈmɑːsthed]", translation = "выходные данные издания",
            pos = "noun", semanticGroup = "journalism_publication_elements",
            definition = "The box in a paper listing the staff, address and owner of the title.",
            definitionNative = "Бокс в газете — перечисляет штат, адрес и владельца издания для читателей.",
            example = "Her promotion showed up in the masthead of the Sunday paper.",
            exampleNative = "Её повышение появилось в masthead воскресного выпуска газеты.",
            fillInBlankExclusions = listOf(31022L, 31023L, 31025L),
        ),
        WordEntity(
            id = 31025, setId = 310, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "stylebook", transliteration = "[ˈstaɪlbʊk]", translation = "редакционный справочник стиля",
            pos = "noun", semanticGroup = "journalism_publication_elements",
            definition = "The in-house book that tells reporters how to spell, cite and format each thing.",
            definitionNative = "Внутренний справочник — учит репортёров, как писать, цитировать и оформлять.",
            example = "Every new hire gets a thick stylebook on the very first day.",
            exampleNative = "Каждый новичок получает толстый stylebook в первый же день работы.",
            fillInBlankExclusions = listOf(31022L, 31023L, 31024L),
        ),
    )
}
