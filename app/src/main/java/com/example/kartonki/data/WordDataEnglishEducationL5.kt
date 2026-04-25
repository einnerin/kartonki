package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Образование (level 5, носитель языка).
 *
 * Set 326: «Образование: носитель языка» — высокая академическая лексика
 * (педагогика, образовательная теория, академические звания и архаика).
 *
 * Распределение редкости: 22 LEGENDARY + 3 EPIC — два смежных уровня шкалы.
 *
 * Дополняет существующие сеты темы «Образование»:
 *   - Set 279 (WordDataEnglishBatch12.kt) — L1 COMMON/UNCOMMON (школьные предметы и канцелярия).
 *   - Set 27  (WordDataEnglish.kt)         — L2 UNCOMMON (университетская жизнь).
 *   - Set 44  (WordDataEnglish.kt)         — L3 RARE (учебные действия и навыки).
 *   - Set 59  (WordDataEnglish.kt)         — L4 EPIC (академический дискурс).
 *
 * Слова setId=326 не пересекаются ни с одним из этих наборов (проверено grep).
 *
 * SemanticGroups (5 × 5):
 *   education_pedagogy   — pedagogy, andragogy, propaedeutic, mnemonic, catechism
 *   education_titles     — emeritus, valedictorian, salutatorian, baccalaureate, matriculation
 *   education_practices  — disquisition, encyclical, cathedra, tutelage, exegesis
 *   education_theory     — Socratic, scholastic, hermeneutic, sophist, sapience
 *   education_archaic    — preceptor, autodidact, polymath, savant, prodigy
 *
 * Word IDs: 32601..32625 (setId × 100 + position).
 */
object WordDataEnglishEducationL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 326, name = "Образование",
            description = "Высокая академическая лексика: педагогика, теория обучения, звания и архаика",
            languagePair = "en-ru",
            orderIndex = 300,
            topic = "Образование", level = 5),
    )

    val words: List<WordEntity> = listOf(

        // ── education_pedagogy (5) ────────────────────────────────────────

        WordEntity(id = 32601, setId = 326, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "pedagogy", transliteration = "[ˈpɛdəˌɡoʊʤi]", translation = "педагогика (как наука)",
            definition = "The art and science of teaching — methods, theory and practice of instruction.",
            definitionNative = "Искусство и наука преподавания — методы, теория и практика обучения.",
            example = "Modern pedagogy treats every learner as an active partner.",
            exampleNative = "Современная pedagogy относится к ученику как к активному партнёру.",
            pos = "noun", semanticGroup = "education_pedagogy",
            fillInBlankExclusions = listOf(32602L, 32603L, 32604L, 32605L)),

        WordEntity(id = 32602, setId = 326, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "andragogy", transliteration = "[ˈændrəˌɡoʊʤi]", translation = "андрагогика (обучение взрослых)",
            definition = "The branch of teaching theory that studies how grown-ups learn best.",
            definitionNative = "Раздел теории обучения, изучающий, как лучше всего учатся взрослые люди.",
            example = "Good andragogy respects the rich experience adult students bring.",
            exampleNative = "Грамотная andragogy уважает богатый опыт, который несут взрослые студенты.",
            pos = "noun", semanticGroup = "education_pedagogy",
            fillInBlankExclusions = listOf(32601L, 32603L, 32604L, 32605L)),

        WordEntity(id = 32603, setId = 326, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "propaedeutic", transliteration = "[ˌproʊpɪˈdjutɪk]", translation = "пропедевтический (вводный курс)",
            definition = "Serving as a basic introduction that prepares one for deeper study.",
            definitionNative = "Служащий начальным введением, готовящим к более глубокому изучению предмета.",
            example = "First-year Latin is a propaedeutic course before classical philology.",
            exampleNative = "Латынь первого курса — propaedeutic курс перед классической филологией.",
            pos = "adjective", semanticGroup = "education_pedagogy",
            fillInBlankExclusions = listOf(32601L, 32602L, 32604L, 32605L)),

        WordEntity(id = 32604, setId = 326, languagePair = "en-ru", rarity = "EPIC",
            original = "mnemonic", transliteration = "[nɪˈmɑnɪk]", translation = "мнемонический приём",
            definition = "A short trick — a rhyme or phrase — that helps your memory hold facts.",
            definitionNative = "Короткий приём — рифма или фраза — помогающий памяти удержать факты.",
            example = "She invented a clever mnemonic for the planets in our system.",
            exampleNative = "Она придумала остроумный mnemonic для планет нашей системы.",
            pos = "noun", semanticGroup = "education_pedagogy",
            fillInBlankExclusions = listOf(32601L, 32602L, 32603L, 32605L)),

        WordEntity(id = 32605, setId = 326, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "catechism", transliteration = "[ˈkætəˌkɪzəm]", translation = "катехизис (учение в форме вопросов)",
            definition = "A set teaching method built as fixed questions and short answers learned by heart.",
            definitionNative = "Метод обучения через закреплённые вопросы и короткие ответы, заучиваемые наизусть.",
            example = "The novice studied the catechism of the order each morning before chapel.",
            exampleNative = "Послушник учил catechism ордена каждое утро перед службой в часовне.",
            pos = "noun", semanticGroup = "education_pedagogy",
            fillInBlankExclusions = listOf(32601L, 32602L, 32603L, 32604L)),

        // ── education_titles (5) ──────────────────────────────────────────

        WordEntity(id = 32606, setId = 326, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "emeritus", transliteration = "[ɪˈmɛrətəs]", translation = "почётный (в отставке, о профессоре)",
            definition = "Holding an honoured retired status — kept on the staff list out of respect.",
            definitionNative = "Носящий уважительный статус в отставке — оставленный в штате из признания заслуг.",
            example = "The emeritus chair still gives one lecture each spring term.",
            exampleNative = "Emeritus заведующий читает по одной лекции каждый весенний семестр.",
            pos = "adjective", semanticGroup = "education_titles",
            fillInBlankExclusions = listOf(32607L, 32608L, 32609L, 32610L)),

        WordEntity(id = 32607, setId = 326, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "valedictorian", transliteration = "[ˌvælədɪkˈtɔriən]", translation = "лучший выпускник (с прощальной речью)",
            definition = "The top-ranked graduating student who delivers the farewell speech to classmates.",
            definitionNative = "Лучший по рейтингу выпускник, произносящий прощальную речь однокурсникам.",
            example = "She was named valedictorian of her senior class with high honours.",
            exampleNative = "Её назвали valedictorian выпускного класса с высшими отличиями.",
            pos = "noun", semanticGroup = "education_titles",
            fillInBlankExclusions = listOf(32606L, 32608L, 32609L, 32610L)),

        WordEntity(id = 32608, setId = 326, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "salutatorian", transliteration = "[səˌlutəˈtɔriən]", translation = "второй выпускник (с приветственной речью)",
            definition = "The second-ranked graduating student, who opens the ceremony with a welcome.",
            definitionNative = "Второй по рейтингу выпускник, открывающий церемонию приветственной речью.",
            example = "The salutatorian welcomed the parents before the main speeches began.",
            exampleNative = "Salutatorian приветствовал родителей до начала основных речей.",
            pos = "noun", semanticGroup = "education_titles",
            fillInBlankExclusions = listOf(32606L, 32607L, 32609L, 32610L)),

        WordEntity(id = 32609, setId = 326, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "baccalaureate", transliteration = "[ˌbækəˈlɔriət]", translation = "бакалавриат (степень / диплом)",
            definition = "The first university degree, awarded after three or four years of study.",
            definitionNative = "Первая университетская степень, присуждаемая после трёх или четырёх лет учёбы.",
            example = "He earned his baccalaureate in classics at a small liberal college.",
            exampleNative = "Он получил baccalaureate по классической филологии в маленьком колледже.",
            pos = "noun", semanticGroup = "education_titles",
            fillInBlankExclusions = listOf(32606L, 32607L, 32608L, 32610L)),

        WordEntity(id = 32610, setId = 326, languagePair = "en-ru", rarity = "EPIC",
            original = "matriculation", transliteration = "[məˌtrɪkjəˈleɪʃən]", translation = "зачисление в вуз (с занесением в реестр)",
            definition = "The formal act of enrolling at a university and being entered on its rolls.",
            definitionNative = "Официальный акт зачисления в университет с внесением в его списки.",
            example = "The matriculation ceremony took place in the great hall of the college.",
            exampleNative = "Matriculation проходила в большом зале старинного колледжа.",
            pos = "noun", semanticGroup = "education_titles",
            fillInBlankExclusions = listOf(32606L, 32607L, 32608L, 32609L)),

        // ── education_practices (5) ───────────────────────────────────────

        WordEntity(id = 32611, setId = 326, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "disquisition", transliteration = "[ˌdɪskwəˈzɪʃən]", translation = "учёный трактат / обстоятельное рассуждение",
            definition = "A long, careful written or spoken inquiry into one chosen topic.",
            definitionNative = "Долгое и обстоятельное письменное или устное рассуждение по одной теме.",
            example = "He launched into a disquisition on the origins of the alphabet.",
            exampleNative = "Он пустился в disquisition о происхождении алфавита.",
            pos = "noun", semanticGroup = "education_practices",
            fillInBlankExclusions = listOf(32612L, 32613L, 32614L, 32615L)),

        WordEntity(id = 32612, setId = 326, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "encyclical", transliteration = "[ɛnˈsɪklɪkəl]", translation = "энциклика (папское учительное послание)",
            definition = "A formal pastoral letter sent by the pope to teach all bishops at once.",
            definitionNative = "Торжественное пастырское послание папы ко всем епископам сразу для поучения.",
            example = "The new encyclical addressed climate change and human dignity.",
            exampleNative = "Новая encyclical говорила о климате и человеческом достоинстве.",
            pos = "noun", semanticGroup = "education_practices",
            fillInBlankExclusions = listOf(32611L, 32613L, 32614L, 32615L)),

        WordEntity(id = 32613, setId = 326, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "cathedra", transliteration = "[kəˈθidrə]", translation = "кафедра (учительский престол)",
            definition = "The official seat of a bishop or master from which he teaches with full authority.",
            definitionNative = "Официальное седалище епископа или магистра, с которого он учит полновластно.",
            example = "He spoke from the cathedra of his university with a quiet certainty.",
            exampleNative = "Он говорил с cathedra своего университета со спокойной уверенностью.",
            pos = "noun", semanticGroup = "education_practices",
            fillInBlankExclusions = listOf(32611L, 32612L, 32614L, 32615L)),

        WordEntity(id = 32614, setId = 326, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "tutelage", transliteration = "[ˈtutələʤ]", translation = "опека / наставничество",
            definition = "The careful guidance of a younger learner by a more experienced teacher.",
            definitionNative = "Внимательное руководство младшим учеником со стороны более опытного наставника.",
            example = "Under her tutelage the young pianist won three national prizes.",
            exampleNative = "Под её tutelage юный пианист завоевал три национальных приза.",
            pos = "noun", semanticGroup = "education_practices",
            fillInBlankExclusions = listOf(32611L, 32612L, 32613L, 32615L)),

        WordEntity(id = 32615, setId = 326, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "exegesis", transliteration = "[ˌɛksəˈʤisɪs]", translation = "экзегеза (толкование текста)",
            definition = "A close, scholarly explanation of a difficult written passage, often sacred.",
            definitionNative = "Подробное учёное разъяснение трудного письменного отрывка, часто священного.",
            example = "His exegesis of the prophet's verses changed the seminar's debate.",
            exampleNative = "Его exegesis стихов пророка перевернула дискуссию на семинаре.",
            pos = "noun", semanticGroup = "education_practices",
            fillInBlankExclusions = listOf(32611L, 32612L, 32613L, 32614L)),

        // ── education_theory (5) ──────────────────────────────────────────

        WordEntity(id = 32616, setId = 326, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "Socratic", transliteration = "[səˈkrætɪk]", translation = "сократический (метод вопросов)",
            definition = "Teaching by patient questioning that leads the student to find truth alone.",
            definitionNative = "Обучение через терпеливые вопросы, ведущие ученика к самостоятельному открытию истины.",
            example = "The professor preferred a Socratic style over long, dry lectures.",
            exampleNative = "Профессор предпочитал Socratic стиль длинным сухим лекциям.",
            pos = "adjective", semanticGroup = "education_theory",
            fillInBlankExclusions = listOf(32617L, 32618L, 32619L, 32620L)),

        WordEntity(id = 32617, setId = 326, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "scholastic", transliteration = "[skəˈlæstɪk]", translation = "схоластический (медиевальная школа)",
            definition = "Belonging to the medieval school tradition that joined faith with strict logic.",
            definitionNative = "Принадлежащий средневековой школьной традиции, соединившей веру со строгой логикой.",
            example = "The scholastic method shaped European thought for nearly four centuries.",
            exampleNative = "Scholastic метод формировал европейскую мысль почти четыре века.",
            pos = "adjective", semanticGroup = "education_theory",
            fillInBlankExclusions = listOf(32616L, 32618L, 32619L, 32620L)),

        WordEntity(id = 32618, setId = 326, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "hermeneutic", transliteration = "[ˌhɜrməˈnjutɪk]", translation = "герменевтический (толковательный)",
            definition = "Concerned with the careful art of explaining what an old text really means.",
            definitionNative = "Связанный с тонким искусством истолкования того, что старый текст значит на самом деле.",
            example = "Her hermeneutic approach treated each passage as a riddle to unlock.",
            exampleNative = "Её hermeneutic подход воспринимал каждый отрывок как загадку для разгадки.",
            pos = "adjective", semanticGroup = "education_theory",
            fillInBlankExclusions = listOf(32616L, 32617L, 32619L, 32620L)),

        WordEntity(id = 32619, setId = 326, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "sophist", transliteration = "[ˈsɑfɪst]", translation = "софист (учитель красноречия Древней Греции)",
            definition = "An ancient Greek teacher of rhetoric, paid to argue any side of a question.",
            definitionNative = "Древнегреческий учитель риторики, бравший плату за защиту любой стороны вопроса.",
            example = "Plato treated the visiting sophist with cool, unmistakable irony.",
            exampleNative = "Платон встретил приезжего sophist холодной, явной иронией.",
            pos = "noun", semanticGroup = "education_theory",
            fillInBlankExclusions = listOf(32616L, 32617L, 32618L, 32620L)),

        WordEntity(id = 32620, setId = 326, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "sapience", transliteration = "[ˈseɪpiəns]", translation = "глубокая мудрость (книжно)",
            definition = "Deep, weighed understanding of life — the calm wisdom of long study and years.",
            definitionNative = "Глубокое и взвешенное понимание жизни — спокойная мудрость долгих лет и учёбы.",
            example = "The old monk's sapience drew young scholars from across Europe.",
            exampleNative = "Sapience старого монаха привлекала молодых учёных со всей Европы.",
            pos = "noun", semanticGroup = "education_theory",
            fillInBlankExclusions = listOf(32616L, 32617L, 32618L, 32619L)),

        // ── education_archaic (5) ─────────────────────────────────────────

        WordEntity(id = 32621, setId = 326, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "preceptor", transliteration = "[prɪˈsɛptər]", translation = "наставник / учитель (книжно)",
            definition = "A senior teacher who guides one student or a small group with personal care.",
            definitionNative = "Опытный преподаватель, индивидуально работающий с одним подопечным или малой группой.",
            example = "His preceptor in clinical medicine taught him to listen first.",
            exampleNative = "Его preceptor в клинической медицине научил его сначала слушать.",
            pos = "noun", semanticGroup = "education_archaic",
            fillInBlankExclusions = listOf(32622L, 32623L, 32624L, 32625L)),

        WordEntity(id = 32622, setId = 326, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "autodidact", transliteration = "[ˌɔtoʊˈdaɪdækt]", translation = "самоучка (книжно)",
            definition = "Someone who has taught themselves a subject without going to a school for it.",
            definitionNative = "Тот, кто самостоятельно овладел предметом без посещения школы или вуза.",
            example = "A brilliant autodidact, he mastered Sanskrit alone in his attic study.",
            exampleNative = "Блестящий autodidact, он освоил санскрит один в чердачном кабинете.",
            pos = "noun", semanticGroup = "education_archaic",
            fillInBlankExclusions = listOf(32621L, 32623L, 32624L, 32625L)),

        WordEntity(id = 32623, setId = 326, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "polymath", transliteration = "[ˈpɑliˌmæθ]", translation = "эрудит во многих науках",
            definition = "A person of deep learning across many widely different fields of study.",
            definitionNative = "Человек глубоких знаний в самых разных областях науки и искусства.",
            example = "Leonardo was a polymath at home in art, anatomy and engineering.",
            exampleNative = "Леонардо был polymath, свободным в искусстве, анатомии и инженерии.",
            pos = "noun", semanticGroup = "education_archaic",
            fillInBlankExclusions = listOf(32621L, 32622L, 32624L, 32625L)),

        WordEntity(id = 32624, setId = 326, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "savant", transliteration = "[səˈvɑnt]", translation = "учёный муж / гений в одной сфере",
            definition = "A scholar of unusual depth — or a person with one stunning, narrow gift.",
            definitionNative = "Учёный необычайной глубины — или человек с одним поразительным узким даром.",
            example = "The visiting savant could recite long passages of medieval verse.",
            exampleNative = "Приезжий savant мог цитировать длинные пассажи средневековой поэзии.",
            pos = "noun", semanticGroup = "education_archaic",
            fillInBlankExclusions = listOf(32621L, 32622L, 32623L, 32625L)),

        WordEntity(id = 32625, setId = 326, languagePair = "en-ru", rarity = "EPIC",
            original = "prodigy", transliteration = "[ˈprɑdəʤi]", translation = "вундеркинд / одарённый ребёнок",
            definition = "A young person whose gift in a craft or science amazes far older masters.",
            definitionNative = "Юный человек, чей дар в ремесле или науке поражает гораздо более старших мастеров.",
            example = "The piano prodigy played a Chopin concerto at the age of nine.",
            exampleNative = "Фортепианный prodigy сыграл концерт Шопена в девять лет.",
            pos = "noun", semanticGroup = "education_archaic", fillInBlankExclusions = listOf(32621L, 32622L, 32623L, 32624L)),
    )
}
