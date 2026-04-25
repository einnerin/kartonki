package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Работа и карьера (level 3, углублённый).
 *
 * Set 338: «Работа и карьера: углублённая лексика».
 * Процессы, карьерные движения, оценка результата, корпоративные отношения и
 * современные форматы занятости (B2).
 *
 * Распределение редкости: 22 RARE + 3 UNCOMMON — два смежных уровня шкалы.
 *
 * Дополняет уже существующие сеты темы «Работа и карьера»:
 *   - Set 280 (WordDataEnglishBatch12.kt)   — L1 COMMON (базовые профессии).
 *   - Set 203 (WordDataEnglishExpanded.kt)  — L2 COMMON/UNCOMMON (распространённые профессии).
 *   - Set 243 (WordDataEnglishExpanded.kt)  — L4 RARE (узкоспециализированные профессии).
 *   - Set 339 (WordDataEnglishWorkL5.kt)    — L5 LEGENDARY (создаётся параллельно).
 *
 * Слова setId=338 не пересекаются с другими сетами темы (проверено grep).
 *
 * SemanticGroups (5 × 5):
 *   work_processes        — onboard, mentor, prioritize, debrief, expedite
 *   work_career_moves     — secondment, sabbatical, retainer, attrition, relocate
 *   work_evaluation       — backlog, bottleneck, milestone, punctuality, absenteeism
 *   work_relations        — counterpart, underling, protege, micromanager, whistleblower
 *   work_modes            — moonlight, telecommute, upskill, reskill, kickoff
 *
 * Word IDs: 33801..33825 (setId × 100 + position).
 */
object WordDataEnglishWorkL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 338, name = "Работа и карьера",
            description = "Углублённая лексика работы: дедлайны, корпоративная динамика, профразвитие",
            languagePair = "en-ru",
            orderIndex = 301,
            topic = "Работа и карьера", level = 3),
    )

    val words: List<WordEntity> = listOf(

        // ── work_processes (5) ────────────────────────────────────────────

        WordEntity(id = 33801, setId = 338, languagePair = "en-ru", rarity = "RARE",
            original = "onboard", transliteration = "[ˌɑnˈbɔrd]", translation = "вводить в курс дела (нового сотрудника)",
            definition = "To guide a new hire through training so they settle into their role.",
            definitionNative = "Провести нового сотрудника через обучение, чтобы он освоился в роли.",
            example = "Our team will onboard the junior developer over the next two weeks.",
            exampleNative = "Наша команда будет onboard младшего разработчика следующие две недели.",
            pos = "verb", semanticGroup = "work_processes", fillInBlankExclusions = listOf(33802L, 33803L, 33804L, 33805L, 33810L, 33823L, 33824L)),

        WordEntity(id = 33802, setId = 338, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "mentor", transliteration = "[ˈmɛnˌtɔr]", translation = "наставник; быть наставником",
            definition = "An experienced person who guides and teaches a less experienced colleague.",
            definitionNative = "Опытный человек, направляющий и обучающий менее опытного коллегу.",
            example = "A senior engineer will mentor the new graduate for the first six months.",
            exampleNative = "Старший инженер будет mentor новому выпускнику первые полгода.",
            pos = "verb", semanticGroup = "work_processes", fillInBlankExclusions = listOf(33801L, 33803L, 33804L, 33805L, 33810L, 33823L, 33824L)),

        WordEntity(id = 33803, setId = 338, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "prioritize", transliteration = "[praɪˈɔrəˌtaɪz]", translation = "расставлять приоритеты",
            definition = "To decide which tasks are most urgent and should be done first.",
            definitionNative = "Решать, какие задачи важнее всего и должны быть сделаны первыми.",
            example = "Please prioritize the client request before the routine reports today.",
            exampleNative = "Пожалуйста, prioritize запрос клиента перед обычными отчётами сегодня.",
            pos = "verb", semanticGroup = "work_processes", fillInBlankExclusions = listOf(33801L, 33802L, 33804L, 33805L)),

        WordEntity(id = 33804, setId = 338, languagePair = "en-ru", rarity = "RARE",
            original = "debrief", transliteration = "[diˈbrif]", translation = "подвести итоги (после задачи)",
            definition = "To meet after a project and discuss what went well or wrong.",
            definitionNative = "Встретиться после проекта и разобрать, что прошло хорошо или плохо.",
            example = "The manager will debrief the team after Friday's product launch.",
            exampleNative = "Менеджер будет debrief команду после пятничного запуска продукта.",
            pos = "verb", semanticGroup = "work_processes", fillInBlankExclusions = listOf(33801L, 33802L, 33803L, 33805L, 33810L, 33823L, 33824L)),

        WordEntity(id = 33805, setId = 338, languagePair = "en-ru", rarity = "RARE",
            original = "expedite", transliteration = "[ˈɛkspəˌdaɪt]", translation = "ускорять (выполнение задачи)",
            definition = "To make a process happen sooner or move forward more quickly.",
            definitionNative = "Сделать так, чтобы процесс произошёл раньше или продвигался быстрее.",
            example = "We must expedite the contract review to meet the buyer's tight schedule.",
            exampleNative = "Мы должны expedite проверку контракта, чтобы успеть к графику покупателя.",
            pos = "verb", semanticGroup = "work_processes", fillInBlankExclusions = listOf(33801L, 33802L, 33803L, 33804L)),

        // ── work_career_moves (5) ─────────────────────────────────────────

        WordEntity(id = 33806, setId = 338, languagePair = "en-ru", rarity = "RARE",
            original = "secondment", transliteration = "[sɪˈkɑndmənt]", translation = "временный перевод (в другой отдел/филиал)",
            definition = "A temporary move of a worker to another team or branch for a fixed period.",
            definitionNative = "Временное перемещение сотрудника в другую команду или филиал на срок.",
            example = "She accepted a six-month secondment to the firm's office in Berlin.",
            exampleNative = "Она приняла шестимесячный secondment в офис компании в Берлине.",
            pos = "noun", semanticGroup = "work_career_moves", fillInBlankExclusions = listOf(33807L, 33808L, 33809L)),

        WordEntity(id = 33807, setId = 338, languagePair = "en-ru", rarity = "RARE",
            original = "sabbatical", transliteration = "[səˈbætɪkəl]", translation = "длительный оплачиваемый отпуск (на учёбу или отдых)",
            definition = "A long break from work, often paid, used for study, travel or rest.",
            definitionNative = "Длительный перерыв в работе, часто оплачиваемый, для учёбы, поездок или отдыха.",
            example = "The professor took a year's sabbatical to write her new book.",
            exampleNative = "Профессор взяла годовой sabbatical, чтобы написать новую книгу.",
            pos = "noun", semanticGroup = "work_career_moves", fillInBlankExclusions = listOf(33806L, 33808L, 33809L)),

        WordEntity(id = 33808, setId = 338, languagePair = "en-ru", rarity = "RARE",
            original = "retainer", transliteration = "[rɪˈteɪnər]", translation = "регулярный гонорар (за постоянное обслуживание)",
            definition = "A fixed fee paid in advance to keep an expert's services available.",
            definitionNative = "Заранее оплачиваемая фиксированная сумма за постоянную доступность специалиста.",
            example = "Our firm pays the lawyer a monthly retainer for ongoing legal advice.",
            exampleNative = "Наша компания платит юристу ежемесячный retainer за регулярные консультации.",
            pos = "noun", semanticGroup = "work_career_moves", fillInBlankExclusions = listOf(33806L, 33807L, 33809L)),

        WordEntity(id = 33809, setId = 338, languagePair = "en-ru", rarity = "RARE",
            original = "attrition", transliteration = "[əˈtrɪʃən]", translation = "естественная убыль (сотрудников)",
            definition = "The slow loss of staff as people retire or leave and are not replaced.",
            definitionNative = "Медленная потеря сотрудников, когда они уходят или выходят на пенсию и не заменяются.",
            example = "Strong attrition forced the firm to rethink its retention strategy.",
            exampleNative = "Сильная attrition заставила компанию пересмотреть стратегию удержания.",
            pos = "noun", semanticGroup = "work_career_moves", fillInBlankExclusions = listOf(33806L, 33807L, 33808L, 33815L)),

        WordEntity(id = 33810, setId = 338, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "relocate", transliteration = "[ˌriˈloʊˌkeɪt]", translation = "переезжать (по работе)",
            definition = "To move to a new city or country in order to take a job there.",
            definitionNative = "Переехать в другой город или страну, чтобы работать там.",
            example = "The bank offered to relocate the analyst from London to Singapore.",
            exampleNative = "Банк предложил relocate аналитика из Лондона в Сингапур.",
            pos = "verb", semanticGroup = "work_career_moves"),

        // ── work_evaluation (5) ───────────────────────────────────────────

        WordEntity(id = 33811, setId = 338, languagePair = "en-ru", rarity = "RARE",
            original = "backlog", transliteration = "[ˈbækˌlɔɡ]", translation = "невыполненные задачи (накопленный список)",
            definition = "A pile of unfinished tasks waiting in line for the team to handle.",
            definitionNative = "Куча незавершённых задач, ожидающих в очереди обработки командой.",
            example = "The support team cleared its backlog after a long weekend of work.",
            exampleNative = "Команда поддержки разгребла свой backlog за долгие выходные работы.",
            pos = "noun", semanticGroup = "work_evaluation", fillInBlankExclusions = listOf(33812L, 33813L, 33814L, 33815L)),

        WordEntity(id = 33812, setId = 338, languagePair = "en-ru", rarity = "RARE",
            original = "bottleneck", transliteration = "[ˈbɑtəlˌnɛk]", translation = "узкое место (тормозящий этап)",
            definition = "A stage in a process that slows everything down because it cannot keep up.",
            definitionNative = "Этап процесса, замедляющий всё остальное, потому что не справляется.",
            example = "Approval from legal became the main bottleneck in our launch plan.",
            exampleNative = "Одобрение юристов стало главным bottleneck в нашем плане запуска.",
            pos = "noun", semanticGroup = "work_evaluation", fillInBlankExclusions = listOf(33811L, 33813L, 33814L, 33815L)),

        WordEntity(id = 33813, setId = 338, languagePair = "en-ru", rarity = "RARE",
            original = "milestone", transliteration = "[ˈmaɪlˌstoʊn]", translation = "контрольная веха (важный этап проекта)",
            definition = "A key point in a project that marks meaningful progress toward the goal.",
            definitionNative = "Ключевая точка проекта, отмечающая значимое продвижение к цели.",
            example = "Reaching ten thousand users was a major milestone for the small startup.",
            exampleNative = "Десять тысяч пользователей стали важным milestone для маленького стартапа.",
            pos = "noun", semanticGroup = "work_evaluation", fillInBlankExclusions = listOf(33811L, 33812L, 33814L, 33815L)),

        WordEntity(id = 33814, setId = 338, languagePair = "en-ru", rarity = "RARE",
            original = "punctuality", transliteration = "[ˌpʌŋkʧuˈæləti]", translation = "пунктуальность",
            definition = "The habit of arriving and finishing things at the agreed time.",
            definitionNative = "Привычка приходить и заканчивать дела в условленное время.",
            example = "Strict punctuality is valued highly in this German engineering firm.",
            exampleNative = "Строгая punctuality высоко ценится в этой немецкой инженерной фирме.",
            pos = "noun", semanticGroup = "work_evaluation", fillInBlankExclusions = listOf(33811L, 33812L, 33813L, 33815L)),

        WordEntity(id = 33815, setId = 338, languagePair = "en-ru", rarity = "RARE",
            original = "absenteeism", transliteration = "[ˌæbsənˈtiɪzəm]", translation = "прогулы (систематическое отсутствие на работе)",
            definition = "Repeated and often unjustified absence from one's place of work.",
            definitionNative = "Повторяющееся, часто неоправданное отсутствие на рабочем месте.",
            example = "Rising absenteeism alarmed the factory's human resources department.",
            exampleNative = "Растущий absenteeism встревожил отдел кадров на заводе.",
            pos = "noun", semanticGroup = "work_evaluation", fillInBlankExclusions = listOf(33809L, 33811L, 33812L, 33813L, 33814L)),

        // ── work_relations (5) ────────────────────────────────────────────

        WordEntity(id = 33816, setId = 338, languagePair = "en-ru", rarity = "RARE",
            original = "counterpart", transliteration = "[ˈkaʊntərˌpɑrt]", translation = "коллега того же ранга (в другой организации)",
            definition = "Someone who holds an equivalent role in a different team or firm.",
            definitionNative = "Человек, занимающий равноценную должность в другой команде или компании.",
            example = "Our director called her counterpart at the partner firm to settle the dispute.",
            exampleNative = "Наш директор позвонила своей counterpart в фирме-партнёре, чтобы уладить спор.",
            pos = "noun", semanticGroup = "work_relations", fillInBlankExclusions = listOf(33817L, 33818L, 33819L, 33820L)),

        WordEntity(id = 33817, setId = 338, languagePair = "en-ru", rarity = "RARE",
            original = "underling", transliteration = "[ˈʌndərlɪŋ]", translation = "подчинённый (с оттенком пренебрежения)",
            definition = "A worker of lower rank, often spoken of with a slight tone of contempt.",
            definitionNative = "Работник более низкого ранга, о котором часто говорят с лёгким пренебрежением.",
            example = "The harsh boss treated every underling as a tool rather than a person.",
            exampleNative = "Грубый начальник обращался с каждым underling как с инструментом, не человеком.",
            pos = "noun", semanticGroup = "work_relations", fillInBlankExclusions = listOf(33816L, 33818L, 33819L, 33820L)),

        WordEntity(id = 33818, setId = 338, languagePair = "en-ru", rarity = "RARE",
            original = "protege", transliteration = "[ˈproʊtəˌʒeɪ]", translation = "протеже (молодой подопечный наставника)",
            definition = "A young person guided in their career by an experienced senior figure.",
            definitionNative = "Молодой человек, чью карьеру направляет опытный старший наставник.",
            example = "The famous chef hired his protege to run the new restaurant in Paris.",
            exampleNative = "Знаменитый шеф нанял своего protege руководить новым рестораном в Париже.",
            pos = "noun", semanticGroup = "work_relations", fillInBlankExclusions = listOf(33816L, 33817L, 33819L, 33820L)),

        WordEntity(id = 33819, setId = 338, languagePair = "en-ru", rarity = "RARE",
            original = "micromanager", transliteration = "[ˈmaɪkroʊˌmænɪʤər]", translation = "руководитель, лезущий в каждую мелочь",
            definition = "A boss who controls every tiny detail and rarely lets staff act alone.",
            definitionNative = "Начальник, контролирующий каждую мелочь и редко дающий сотрудникам действовать самостоятельно.",
            example = "Our team lost two engineers because the new micromanager checked every line of code.",
            exampleNative = "Наша команда потеряла двух инженеров, потому что новый micromanager проверял каждую строку кода.",
            pos = "noun", semanticGroup = "work_relations", fillInBlankExclusions = listOf(33816L, 33817L, 33818L, 33820L)),

        WordEntity(id = 33820, setId = 338, languagePair = "en-ru", rarity = "RARE",
            original = "whistleblower", transliteration = "[ˈwɪsəlˌbloʊər]", translation = "разоблачитель (сообщающий о нарушениях)",
            definition = "A worker who publicly reveals wrongdoing inside the company they serve.",
            definitionNative = "Сотрудник, публично раскрывающий нарушения внутри компании, в которой работает.",
            example = "A brave whistleblower exposed the bank's hidden fraud to the press.",
            exampleNative = "Храбрый whistleblower раскрыл прессе скрытое мошенничество банка.",
            pos = "noun", semanticGroup = "work_relations", fillInBlankExclusions = listOf(33816L, 33817L, 33818L, 33819L)),

        // ── work_modes (5) ────────────────────────────────────────────────

        WordEntity(id = 33821, setId = 338, languagePair = "en-ru", rarity = "RARE",
            original = "moonlight", transliteration = "[ˈmunˌlaɪt]", translation = "подрабатывать (после основной работы)",
            definition = "To hold a second job after the main one, often quietly in the evening.",
            definitionNative = "Иметь вторую работу после основной, часто тихо по вечерам.",
            example = "Many teachers moonlight as private tutors to boost a thin salary.",
            exampleNative = "Многие учителя moonlight частными репетиторами, чтобы повысить скромный оклад.",
            pos = "verb", semanticGroup = "work_modes", fillInBlankExclusions = listOf(33822L, 33823L, 33824L)),

        WordEntity(id = 33822, setId = 338, languagePair = "en-ru", rarity = "RARE",
            original = "telecommute", transliteration = "[ˈtɛləkəˌmjut]", translation = "работать удалённо (через интернет)",
            definition = "To do the job from home using a computer instead of going to the office.",
            definitionNative = "Работать из дома с компьютера вместо поездки в офис.",
            example = "Software engineers can telecommute three days a week under the new policy.",
            exampleNative = "Инженеры-программисты могут telecommute три дня в неделю по новым правилам.",
            pos = "verb", semanticGroup = "work_modes", fillInBlankExclusions = listOf(33802L, 33821L, 33823L, 33824L)),

        WordEntity(id = 33823, setId = 338, languagePair = "en-ru", rarity = "RARE",
            original = "upskill", transliteration = "[ˌʌpˈskɪl]", translation = "повышать квалификацию",
            definition = "To learn fresh skills so a worker can take on harder or newer tasks.",
            definitionNative = "Получать новые навыки, чтобы сотрудник мог браться за сложные или новые задачи.",
            example = "The company paid for staff to upskill in data analysis last year.",
            exampleNative = "В прошлом году компания оплатила сотрудникам upskill в анализе данных.",
            pos = "verb", semanticGroup = "work_modes", fillInBlankExclusions = listOf(33821L, 33822L, 33824L)),

        WordEntity(id = 33824, setId = 338, languagePair = "en-ru", rarity = "RARE",
            original = "reskill", transliteration = "[ˌriˈskɪl]", translation = "переобучаться (на новую профессию)",
            definition = "To train workers in a new trade when their old role is no longer needed.",
            definitionNative = "Обучать сотрудников новой специальности, когда прежняя роль больше не нужна.",
            example = "Factory workers had to reskill as machines replaced the assembly line.",
            exampleNative = "Заводским рабочим пришлось reskill, когда машины заменили конвейер.",
            pos = "verb", semanticGroup = "work_modes", fillInBlankExclusions = listOf(33810L, 33821L, 33822L, 33823L)),

        WordEntity(id = 33825, setId = 338, languagePair = "en-ru", rarity = "RARE",
            original = "kickoff", transliteration = "[ˈkɪˌkɔf]", translation = "стартовая встреча (по проекту)",
            definition = "The first meeting that opens a project and sets goals for everyone.",
            definitionNative = "Первая встреча, открывающая проект и задающая цели для всех участников.",
            example = "The kickoff for the launch project starts tomorrow at nine sharp.",
            exampleNative = "Kickoff проекта запуска начинается завтра ровно в девять.",
            pos = "noun", semanticGroup = "work_modes", fillInBlankExclusions = listOf(33813L)),
    )
}
