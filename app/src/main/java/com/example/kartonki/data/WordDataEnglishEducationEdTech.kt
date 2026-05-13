package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — set 472.
 * Образование: онлайн-обучение и EdTech (L4 / RARE + EPIC).
 *
 * Расширение темы «Образование». Дополняет существующие en-ru сеты:
 *   - 7, 15, 27    — школьная лексика (L1-L2): teacher, lesson, exam, homework,
 *                    classroom, blackboard, chalk.
 *   - 43, 44       — учебные навыки (L2-L3): essay, research, study, summarise,
 *                    outline, citation.
 *   - 59           — академический дискурс (L3): paradigm, hypothesise, premise,
 *                    refute, posit, methodology.
 *   - 326 (L5)     — архаика и теория педагогики: pedagogy, didactic, Socratic,
 *                    andragogy, scholastic, hermeneutic.
 *
 * Подтема — современная цифровая педагогика 2020-х:
 *   онлайн-форматы (MOOC, webinar, blended learning, self-paced, cohort-based),
 *   инструменты EdTech (LMS, virtual classroom, breakout room, whiteboard,
 *     captioning),
 *   современные методики (flipped classroom, gamification, adaptive learning,
 *     scaffolding, mastery learning),
 *   проектная и оценочная педагогика (project-based learning, inquiry-based
 *     learning, formative assessment, summative assessment, differentiation),
 *   контент и сертификация (OER, modular curriculum, learning path, digital
 *     badge, microcredential).
 *
 * НЕ дубли (проверено grep по всем WordDataEnglish*.kt):
 *   polling (Expanded — другая тема), peer review (Entertainment L5), andragogy
 *   и Socratic (EducationL5), milestone (Holidays/Work). Все эти слова
 *   исключены и заменены. Остальные 25 — впервые в базе.
 *
 * Распределение редкости (2 смежных уровня по `validate_rarity_spread`):
 *   RARE — 13 слов (отраслевой стандарт онлайн-обучения, узнаваем большинством
 *          практиков EdTech).
 *   EPIC — 12 слов (профлексика методиста: формативное/суммативное оценивание,
 *          scaffolding, mastery learning, OER, microcredential).
 *
 * Пять семантических подгрупп (по 5 слов):
 *   edu_edtech_formats   — онлайн-форматы курсов
 *   edu_edtech_tools     — инструменты виртуального класса
 *   edu_edtech_methods   — современные методики преподавания
 *   edu_edtech_pedagogy  — проектная и оценочная педагогика
 *   edu_edtech_content   — контент и сертификация
 *
 * Word IDs: 47201..47225 (setId × 100 + position).
 */
object WordDataEnglishEducationEdTech {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 472,
            name = "Образование",
            description = "Онлайн-обучение и EdTech: форматы (MOOC, blended learning), инструменты (LMS, virtual classroom), методики (flipped classroom, gamification, scaffolding), контент (OER, microcredential, digital badge)",
            languagePair = "en-ru",
            orderIndex = 472,
            topic = "Образование",
            level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── edu_edtech_formats (онлайн-форматы курсов) ────────────────────────
        WordEntity(
            id = 47201, original = "MOOC", transliteration = "[muːk]", translation = "массовый открытый онлайн-курс",
            definition = "Online course open to anyone on the internet, often free, with thousands of learners in one cohort.",
            definitionNative = "Онлайн-курс, открытый для всех желающих, часто бесплатный, с тысячами слушателей одного потока.",
            example = "Coursera launched its first MOOC on machine learning in 2012, attracting over 160,000 students.",
            exampleNative = "Coursera запустил свой первый MOOC по машинному обучению в 2012 году, собрав больше 160 000 студентов.",
            rarity = "RARE", setId = 472, languagePair = "en-ru", pos = "noun",
            semanticGroup = "edu_edtech_formats", fillInBlankExclusions = listOf(47202L)),
        WordEntity(
            id = 47202, original = "webinar", transliteration = "[ˈwɛbɪnɑːr]", translation = "вебинар",
            definition = "Live online presentation where the speaker shares slides and the audience asks questions in chat.",
            definitionNative = "Прямая онлайн-презентация: ведущий показывает слайды, аудитория задаёт вопросы в чате.",
            example = "Three thousand teachers signed up for the free webinar on chatbots in the classroom.",
            exampleNative = "Три тысячи учителей записались на бесплатный webinar о чат-ботах в классе.",
            rarity = "RARE", setId = 472, languagePair = "en-ru", pos = "noun",
            semanticGroup = "edu_edtech_formats", fillInBlankExclusions = listOf(47201L)),
        WordEntity(
            id = 47203, original = "blended learning", transliteration = "[ˈblɛndɪd ˈlɜːrnɪŋ]", translation = "смешанное обучение",
            definition = "Course mixing in-person classes with online tasks so students do both at the same time.",
            definitionNative = "Курс, где очные занятия совмещены с онлайн-заданиями, и студенты делают то и другое.",
            example = "The university kept a blended learning model for half of its undergraduate seminars.",
            exampleNative = "Университет оставил blended learning для половины бакалаврских семинаров.",
            rarity = "RARE", setId = 472, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "edu_edtech_formats", fillInBlankExclusions = listOf(47204L, 47205L)),
        WordEntity(
            id = 47204, original = "self-paced", transliteration = "[sɛlf peɪst]", translation = "в своём темпе (формат курса)",
            definition = "Course format where each learner decides when to start, how fast to go and when to finish.",
            definitionNative = "Формат курса, где каждый ученик сам решает, когда начать, как быстро идти и когда закончить.",
            example = "The self-paced Python track let her finish modules during lunch breaks over six months.",
            exampleNative = "Self-paced трек по Python позволил ей закрывать модули в обеденные перерывы за полгода.",
            rarity = "RARE", setId = 472, languagePair = "en-ru", pos = "adjective",
            semanticGroup = "edu_edtech_formats", fillInBlankExclusions = listOf(47203L, 47205L)),
        WordEntity(
            id = 47205, original = "cohort-based", transliteration = "[ˈkoʊhɔːrt beɪst]", translation = "когортный (формат курса)",
            definition = "Online course where students start and finish together, with weekly deadlines and group chats.",
            definitionNative = "Онлайн-курс, где студенты стартуют и заканчивают вместе, с еженедельными дедлайнами и групповыми чатами.",
            example = "Maven's cohort-based courses cost ten times more than MOOCs but keep most learners.",
            exampleNative = "Cohort-based курсы Maven в десять раз дороже MOOC, но удерживают большинство слушателей.",
            rarity = "EPIC", setId = 472, languagePair = "en-ru", pos = "adjective",
            semanticGroup = "edu_edtech_formats", fillInBlankExclusions = listOf(47203L, 47204L)),

        // ── edu_edtech_tools (инструменты виртуального класса) ────────────────
        WordEntity(
            id = 47206, original = "LMS", transliteration = "[ˌɛl ɛm ˈɛs]", translation = "система управления обучением",
            definition = "Software platform where teachers post assignments, grades and materials for an entire course.",
            definitionNative = "Программная платформа, где преподаватели выкладывают задания, оценки и материалы всего курса.",
            example = "The school switched from Moodle to Canvas after teachers complained the old LMS was too clunky.",
            exampleNative = "Школа перешла с Moodle на Canvas — учителя жаловались, что старая LMS слишком неудобна.",
            rarity = "RARE", setId = 472, languagePair = "en-ru", pos = "noun",
            semanticGroup = "edu_edtech_tools", fillInBlankExclusions = listOf(47209L, 47210L)),
        WordEntity(
            id = 47207, original = "virtual classroom", transliteration = "[ˈvɜːrtʃuəl ˈklæsruːm]", translation = "виртуальный класс",
            definition = "Live video room where a teacher and students meet online instead of a real classroom.",
            definitionNative = "Видеокомната в прямом эфире, где учитель и ученики встречаются онлайн вместо настоящего класса.",
            example = "Twenty fifth-graders waved at the camera as the teacher opened the virtual classroom at nine sharp.",
            exampleNative = "Двадцать пятиклассников помахали в камеру, когда учительница открыла virtual classroom ровно в девять.",
            rarity = "RARE", setId = 472, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "edu_edtech_tools", fillInBlankExclusions = listOf(47208L)),
        WordEntity(
            id = 47208, original = "breakout room", transliteration = "[ˈbreɪkaʊt ruːm]", translation = "сессионный зал (Zoom)",
            definition = "Small private video sub-room where part of the class works together for a few minutes.",
            definitionNative = "Маленькая отдельная видеокомната, где часть класса работает вместе несколько минут.",
            example = "She moved each project team into its own breakout room for ten minutes.",
            exampleNative = "Она отправила каждую проектную команду в свой breakout room на десять минут.",
            rarity = "RARE", setId = 472, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "edu_edtech_tools", fillInBlankExclusions = listOf(47207L)),
        WordEntity(
            id = 47209, original = "whiteboard", transliteration = "[ˈwaɪtbɔːrd]", translation = "интерактивная доска",
            definition = "Shared digital canvas where teacher and students draw, write and stick notes at the same time.",
            definitionNative = "Общий цифровой холст, где учитель и ученики одновременно рисуют, пишут и клеят заметки.",
            example = "She sketched a cell on the Miro whiteboard while students added labels live.",
            exampleNative = "Она набросала клетку на Miro whiteboard, а ученики живьём добавляли подписи.",
            rarity = "RARE", setId = 472, languagePair = "en-ru", pos = "noun",
            semanticGroup = "edu_edtech_tools", fillInBlankExclusions = listOf(47206L, 47210L)),
        WordEntity(
            id = 47210, original = "captioning", transliteration = "[ˈkæpʃənɪŋ]", translation = "автоматические субтитры",
            definition = "Live text under a video showing what the speaker just said, often generated by speech-to-text.",
            definitionNative = "Бегущий текст под видео, показывающий только что сказанное, часто генерируется распознаванием речи.",
            example = "Live captioning helped the deaf student follow the chemistry lecture without an interpreter.",
            exampleNative = "Captioning помогало глухому студенту следить за лекцией по химии без переводчика.",
            rarity = "RARE", setId = 472, languagePair = "en-ru", pos = "noun",
            semanticGroup = "edu_edtech_tools", fillInBlankExclusions = listOf(47206L, 47209L)),

        // ── edu_edtech_methods (современные методики преподавания) ────────────
        WordEntity(
            id = 47211, original = "flipped classroom", transliteration = "[flɪpt ˈklæsruːm]", translation = "перевёрнутый класс",
            definition = "Approach where students watch a lecture at home and use class time for exercises with the teacher.",
            definitionNative = "Подход: дома смотрят лекцию, а очное время тратят на упражнения с учителем.",
            example = "In her flipped classroom the kids watched a video on fractions before Monday's workshop.",
            exampleNative = "В её flipped classroom дети смотрели ролик про дроби перед понедельничным практикумом.",
            rarity = "RARE", setId = 472, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "edu_edtech_methods", fillInBlankExclusions = listOf(47212L, 47213L, 47215L, 47216L, 47217L)),
        WordEntity(
            id = 47212, original = "gamification", transliteration = "[ˌɡeɪmɪfɪˈkeɪʃən]", translation = "геймификация",
            definition = "Adding game elements — points, levels, badges — to lessons to keep learners engaged.",
            definitionNative = "Добавление в уроки игровых элементов — очков, уровней, бейджей — чтобы удерживать внимание учеников.",
            example = "Duolingo's gamification with streaks and leagues keeps users opening the app for ten minutes a day.",
            exampleNative = "Gamification от Duolingo — серии дней и лиги — заставляет пользователей открывать приложение по десять минут в день.",
            rarity = "RARE", setId = 472, languagePair = "en-ru", pos = "noun",
            semanticGroup = "edu_edtech_methods", fillInBlankExclusions = listOf(47214L)),
        WordEntity(
            id = 47213, original = "adaptive learning", transliteration = "[əˈdæptɪv ˈlɜːrnɪŋ]", translation = "адаптивное обучение",
            definition = "Software that changes the next exercise based on how the student answered the previous ones.",
            definitionNative = "Программа, которая подбирает следующее упражнение, исходя из ответов на предыдущие.",
            example = "Khan Academy's adaptive learning sent him back to fractions when algebra accuracy dropped.",
            exampleNative = "Adaptive learning от Khan Academy отправил его обратно к дробям при падении точности в алгебре.",
            rarity = "EPIC", setId = 472, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "edu_edtech_methods", fillInBlankExclusions = listOf(47211L, 47214L, 47215L)),
        WordEntity(
            id = 47214, original = "scaffolding", transliteration = "[ˈskæfəldɪŋ]", translation = "скаффолдинг (поддержка)",
            definition = "Temporary hints, examples or templates a teacher gives a learner and removes step by step.",
            definitionNative = "Временные подсказки, образцы или шаблоны: учитель даёт их и убирает по шагам.",
            example = "She gave the essay scaffolding with sentence starters and removed it after two weeks.",
            exampleNative = "Она дала эссейный scaffolding с заготовками фраз и убрала его через две недели.",
            rarity = "EPIC", setId = 472, languagePair = "en-ru", pos = "noun",
            semanticGroup = "edu_edtech_methods", fillInBlankExclusions = listOf(47212L)),
        WordEntity(
            id = 47215, original = "mastery learning", transliteration = "[ˈmæstəri ˈlɜːrnɪŋ]", translation = "обучение до полного освоения",
            definition = "Approach where a student moves to the next topic only after reaching near-perfect score on the current one.",
            definitionNative = "Подход: ученик переходит к следующей теме только после почти безошибочного результата по текущей.",
            example = "Mastery learning let weaker students reach algebra fluency by spring despite starting behind.",
            exampleNative = "Mastery learning позволил слабым ученикам уверенно знать алгебру к весне, несмотря на отставание.",
            rarity = "EPIC", setId = 472, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "edu_edtech_methods", fillInBlankExclusions = listOf(47211L, 47213L)),

        // ── edu_edtech_pedagogy (проектная и оценочная педагогика) ────────────
        WordEntity(
            id = 47216, original = "project-based learning", transliteration = "[ˈprɒʤɛkt beɪst ˈlɜːrnɪŋ]", translation = "проектное обучение",
            definition = "Method where students learn by working for weeks on a real product or research question.",
            definitionNative = "Метод, при котором школьники неделями работают над реальным продуктом или исследовательским вопросом.",
            example = "Their project-based learning unit on water quality ended with a city council presentation.",
            exampleNative = "Их project-based learning блок по качеству воды закончился выступлением в городском совете.",
            rarity = "EPIC", setId = 472, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "edu_edtech_pedagogy", fillInBlankExclusions = listOf(47217L, 47218L, 47219L)),
        WordEntity(
            id = 47217, original = "inquiry-based learning", transliteration = "[ɪnˈkwaɪri beɪst ˈlɜːrnɪŋ]", translation = "исследовательское обучение",
            definition = "Method where the teacher asks an open question and the class searches for evidence and forms answers.",
            definitionNative = "Метод: учитель задаёт открытый вопрос, а класс ищет доказательства и формулирует ответ.",
            example = "Inquiry-based learning turned her physics class into a debate about bridge safety.",
            exampleNative = "Inquiry-based learning превратило урок физики в дискуссию о безопасности моста.",
            rarity = "EPIC", setId = 472, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "edu_edtech_pedagogy", fillInBlankExclusions = listOf(47216L, 47218L, 47219L)),
        WordEntity(
            id = 47218, original = "formative assessment", transliteration = "[ˈfɔːrmətɪv əˈsɛsmənt]", translation = "формирующее оценивание",
            definition = "Low-stakes check during a unit that shows the teacher what students still misunderstand.",
            definitionNative = "Проверка по ходу темы без серьёзной оценки: показывает учителю, что ученики ещё не поняли.",
            example = "A two-question exit ticket as formative assessment showed half the class missed the rule.",
            exampleNative = "Два вопроса в конце урока как formative assessment показали: половина не поняла правило.",
            rarity = "EPIC", setId = 472, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "edu_edtech_pedagogy", fillInBlankExclusions = listOf(47216L, 47217L, 47219L)),
        WordEntity(
            id = 47219, original = "summative assessment", transliteration = "[ˈsʌmətɪv əˈsɛsmənt]", translation = "итоговое оценивание",
            definition = "High-stakes test at the end of a unit or year that measures what the student has learnt.",
            definitionNative = "Серьёзная проверка в конце темы или года: измеряет, чему ученик научился.",
            example = "The state exam in May was the only summative assessment that counted toward college applications.",
            exampleNative = "Майский государственный экзамен был единственным summative assessment, шедшим в зачёт при поступлении в колледж.",
            rarity = "EPIC", setId = 472, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "edu_edtech_pedagogy", fillInBlankExclusions = listOf(47216L, 47217L, 47218L)),
        WordEntity(
            id = 47220, original = "differentiation", transliteration = "[ˌdɪfərɛnʃiˈeɪʃən]", translation = "дифференциация (под уровень ученика)",
            definition = "Adjusting tasks, pace or materials in one classroom so weaker and stronger students both make progress.",
            definitionNative = "Подстройка заданий, темпа или материалов в одном классе, чтобы слабые и сильные равно продвигались.",
            example = "Her differentiation gave the early finishers a logic puzzle while three others got extra examples.",
            exampleNative = "Её differentiation давала закончившим раньше логическую головоломку, а троим — дополнительные примеры.",
            rarity = "EPIC", setId = 472, languagePair = "en-ru", pos = "noun",
            semanticGroup = "edu_edtech_pedagogy"),

        // ── edu_edtech_content (контент и сертификация) ───────────────────────
        WordEntity(
            id = 47221, original = "OER", transliteration = "[ˌoʊ iː ˈɑːr]", translation = "открытые образовательные ресурсы",
            definition = "Teaching materials posted under a licence that lets anyone copy, change and reuse them for free.",
            definitionNative = "Учебные материалы под лицензией, позволяющей любому копировать, менять и использовать их бесплатно.",
            example = "The college replaced its expensive textbook with OER and saved each freshman a week's wages.",
            exampleNative = "Колледж заменил дорогой учебник на OER, сэкономив каждому новичку недельную зарплату.",
            rarity = "EPIC", setId = 472, languagePair = "en-ru", pos = "noun",
            semanticGroup = "edu_edtech_content", fillInBlankExclusions = listOf(47225L)),
        WordEntity(
            id = 47222, original = "modular curriculum", transliteration = "[ˈmɒʤʊlər kəˈrɪkjʊləm]", translation = "модульная учебная программа",
            definition = "Course broken into short stand-alone blocks so students can study them in different orders.",
            definitionNative = "Курс, разбитый на короткие самостоятельные блоки, которые можно изучать в разном порядке.",
            example = "The bootcamp's modular curriculum let parents take the front-end block before the back-end one.",
            exampleNative = "Modular curriculum буткемпа позволил родителям пройти фронтенд раньше бэкенда.",
            rarity = "EPIC", setId = 472, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "edu_edtech_content", fillInBlankExclusions = listOf(47223L)),
        WordEntity(
            id = 47223, original = "learning path", transliteration = "[ˈlɜːrnɪŋ pæθ]", translation = "учебная траектория",
            definition = "Planned sequence of courses or topics that takes a learner from a starting level to a clear goal.",
            definitionNative = "Запланированная последовательность курсов или тем, ведущая ученика от старта к чёткой цели.",
            example = "LinkedIn suggested a learning path of six courses from junior PM to product lead.",
            exampleNative = "LinkedIn предложил learning path из шести курсов от младшего PM до руководителя продукта.",
            rarity = "RARE", setId = 472, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "edu_edtech_content", fillInBlankExclusions = listOf(47222L, 47224L)),
        WordEntity(
            id = 47224, original = "digital badge", transliteration = "[ˈdɪʤɪtəl bæʤ]", translation = "цифровой бейдж (достижения)",
            definition = "Online icon stored in a profile that proves a learner finished a course or mastered a skill.",
            definitionNative = "Онлайн-иконка в профиле, подтверждающая, что ученик завершил курс или освоил навык.",
            example = "She pinned the Google Analytics digital badge to her LinkedIn profile the day after the final quiz.",
            exampleNative = "Она прикрепила digital badge от Google Analytics к профилю LinkedIn на следующий день после финального теста.",
            rarity = "RARE", setId = 472, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "edu_edtech_content", fillInBlankExclusions = listOf(47223L, 47225L)),
        WordEntity(
            id = 47225, original = "microcredential", transliteration = "[ˌmaɪkroʊkrɪˈdɛnʃəl]", translation = "микросертификат",
            definition = "Short formal qualification proving one narrow skill — far smaller than a full college diploma.",
            definitionNative = "Короткая формальная квалификация, подтверждающая один узкий навык — куда меньше полного диплома.",
            example = "Her Coursera microcredential in SQL got her three recruiter calls within the first week.",
            exampleNative = "Её microcredential по SQL от Coursera принёс три звонка от рекрутёров за первую неделю.",
            rarity = "EPIC", setId = 472, languagePair = "en-ru", pos = "noun",
            semanticGroup = "edu_edtech_content", fillInBlankExclusions = listOf(47224L)),
    )
}
