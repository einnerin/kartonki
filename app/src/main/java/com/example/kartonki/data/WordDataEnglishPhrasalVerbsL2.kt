package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Фразовые глаголы (L2, UNCOMMON+RARE).
 *
 * Set 411: «Фразовые глаголы» — продолжение L1 (set 410). Уровень B1:
 *          phrasal verbs про учёбу/работу, проблемы и неудачи, изменения
 *          и новые занятия, отношения с людьми, а также действия с
 *          деньгами и вещами. По сравнению с L1 здесь смыслы реже
 *          буквальные («break down» — не только «сломаться о вещи», но
 *          и «расклеиться эмоционально»; «end up» — «оказаться в итоге»;
 *          «take after» — «пойти в кого-то из родителей»), поэтому
 *          уровень CEFR — B1.
 *
 * Распределение редкости: 17 UNCOMMON (B1) + 8 RARE (B1, чуть менее
 * частотные или с менее очевидным значением).
 *
 * ⚠️ Коллизии при подготовке (проверено grep'ом по `original = "..."`):
 *   • "make up" — занят в WordDataEnglish (id 3624, «мириться»).
 *     Заменён на "patch up" (помириться, уладить ссору) в группе
 *     phrasal_l2_social — близкое значение, но без коллизии.
 *   • "give up" — уже использован в L1 (id 41019). В TODO к этому сету
 *     стояло «give up» в phrasal_l2_problems — это дубль с L1. Сначала
 *     рассматривался "let down" (⛔ занят в WordDataEnglishEmotionsL2,
 *     id 40913) и "back out" (⛔ занят в WordDataEnglishPhrasalVerbsL3,
 *     id 41216). Итог — взято "give in" (уступить, сдаться) — близкое
 *     по смыслу к «give up», но это отдельный phrasal verb.
 *   • "look up" в этом сете — про поиск в словаре/справочнике
 *     (work_study), а "look up to" — про восхищение (social). Это
 *     разные phrasal verbs, оба свободны.
 *
 * SemanticGroups (5 × 5):
 *   phrasal_l2_work_study     — go over, look up, hand in, drop out, sign up
 *   phrasal_l2_problems       — break down, give in, run out, mess up, slip away
 *   phrasal_l2_changes        — turn into, end up, come up with, take up, calm down
 *   phrasal_l2_social         — patch up, fall out, look up to, take after, get on
 *   phrasal_l2_money_things   — pay back, save up, throw away, sort out, set up
 *
 * Word IDs: setId × 100 + position (41101..41125).
 *
 * Все слова — pos = "phrase". fillInBlankExclusions пустые — заполнятся
 * через FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataEnglishPhrasalVerbsL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 411,
            languagePair = "en-ru",
            orderIndex = 411,
            name = "Фразовые глаголы",
            description = "Фразовые глаголы про учёбу, проблемы, изменения, отношения и деньги",
            topic = "Фразовые глаголы",
            level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 411 — Фразовые глаголы: продолжение (L2, UNCOMMON+RARE)         ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── phrasal_l2_work_study (5) ─────────────────────────────────────

        WordEntity(id = 41101, setId = 411, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "go over", transliteration = "[ɡoʊ ˈoʊvər]", translation = "разбирать, проходить (повторно)",
            definition = "To examine or review something carefully, often step by step.",
            definitionNative = "Внимательно разобрать или просмотреть что-то, часто по шагам.",
            example = "Let's go over the report once more before we send it.",
            exampleNative = "Давай ещё раз go over отчёт, прежде чем его отправлять.",
            pos = "phrase", semanticGroup = "phrasal_l2_work_study", fillInBlankExclusions = listOf(41102L, 41103L, 41104L, 41105L, 41124L)),

        WordEntity(id = 41102, setId = 411, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "look up", transliteration = "[lʊk ʌp]", translation = "посмотреть, найти (в словаре или справочнике)",
            definition = "To search for information in a dictionary, book or online.",
            definitionNative = "Найти нужную информацию в словаре, книге или онлайн.",
            example = "If you don't know this word, just look up its meaning.",
            exampleNative = "Если не знаешь это слово, просто look up его значение.",
            pos = "phrase", semanticGroup = "phrasal_l2_work_study", fillInBlankExclusions = listOf(41101L, 41103L, 41104L, 41105L, 41124L)),

        WordEntity(id = 41103, setId = 411, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "hand in", transliteration = "[hænd ɪn]", translation = "сдавать (работу, домашку)",
            definition = "To give finished work to a teacher, boss or official person.",
            definitionNative = "Передать готовую работу учителю, начальнику или должностному лицу.",
            example = "Students must hand in their essays by Friday morning.",
            exampleNative = "Студенты должны hand in свои эссе до утра пятницы.",
            pos = "phrase", semanticGroup = "phrasal_l2_work_study", fillInBlankExclusions = listOf(41101L, 41102L, 41104L, 41105L, 41124L)),

        WordEntity(id = 41104, setId = 411, languagePair = "en-ru", rarity = "RARE",
            original = "drop out", transliteration = "[drɑp aʊt]", translation = "бросить (учёбу, курс)",
            definition = "To leave a school, course or programme before finishing it.",
            definitionNative = "Уйти из школы, курса или программы до её окончания.",
            example = "He decided to drop out of college and start a business.",
            exampleNative = "Он решил drop out из колледжа и открыть бизнес.",
            pos = "phrase", semanticGroup = "phrasal_l2_work_study", fillInBlankExclusions = listOf(41101L, 41102L, 41103L, 41105L)),

        WordEntity(id = 41105, setId = 411, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "sign up", transliteration = "[saɪn ʌp]", translation = "записаться, зарегистрироваться",
            definition = "To put your name on a list to join a course, club or service.",
            definitionNative = "Внести своё имя в список, чтобы попасть на курс, в клуб или сервис.",
            example = "I want to sign up for the morning yoga class.",
            exampleNative = "Я хочу sign up на утренний класс йоги.",
            pos = "phrase", semanticGroup = "phrasal_l2_work_study", fillInBlankExclusions = listOf(41101L, 41102L, 41103L, 41104L, 41122L)),

        // ── phrasal_l2_problems (5) ───────────────────────────────────────

        WordEntity(id = 41106, setId = 411, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "break down", transliteration = "[breɪk daʊn]", translation = "сломаться (о технике); расклеиться",
            definition = "To stop working, about a machine, or to lose emotional control.",
            definitionNative = "Перестать работать, про прибор, или потерять эмоциональный контроль.",
            example = "Our car always break down at the worst possible moment.",
            exampleNative = "Наша машина всегда break down в самый неподходящий момент.",
            pos = "phrase", semanticGroup = "phrasal_l2_problems", fillInBlankExclusions = listOf(41107L, 41108L, 41109L, 41110L)),

        WordEntity(id = 41107, setId = 411, languagePair = "en-ru", rarity = "RARE",
            original = "give in", transliteration = "[ɡɪv ɪn]", translation = "уступить, сдаться (под давлением)",
            definition = "To finally agree to do something after refusing or resisting.",
            definitionNative = "В итоге согласиться сделать что-то после отказа или сопротивления.",
            example = "After hours of arguing, he finally give in to her demands.",
            exampleNative = "После часов споров он наконец give in её требованиям.",
            pos = "phrase", semanticGroup = "phrasal_l2_problems", fillInBlankExclusions = listOf(41106L, 41108L, 41109L, 41110L)),

        WordEntity(id = 41108, setId = 411, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "run out", transliteration = "[rʌn aʊt]", translation = "закончиться (о запасах)",
            definition = "To use all of something so that none is left.",
            definitionNative = "Израсходовать что-то полностью, так что ничего не осталось.",
            example = "We always run out of milk by the end of the week.",
            exampleNative = "У нас всегда run out молоко к концу недели.",
            pos = "phrase", semanticGroup = "phrasal_l2_problems", fillInBlankExclusions = listOf(41106L, 41107L, 41109L, 41110L)),

        WordEntity(id = 41109, setId = 411, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "mess up", transliteration = "[mɛs ʌp]", translation = "напортачить, испортить",
            definition = "To do something badly or to spoil a plan, task or situation.",
            definitionNative = "Сделать что-то плохо или испортить план, задачу или ситуацию.",
            example = "I really mess up the presentation in front of the whole team.",
            exampleNative = "Я реально mess up презентацию перед всей командой.",
            pos = "phrase", semanticGroup = "phrasal_l2_problems", fillInBlankExclusions = listOf(41101L, 41106L, 41107L, 41108L, 41110L, 41113L, 41116L, 41124L, 41125L)),

        WordEntity(id = 41110, setId = 411, languagePair = "en-ru", rarity = "RARE",
            original = "slip away", transliteration = "[slɪp əˈweɪ]", translation = "ускользнуть, незаметно уйти",
            definition = "To leave a place quietly, hoping that no one will notice.",
            definitionNative = "Тихо уйти откуда-то, рассчитывая, что никто не заметит.",
            example = "She tried to slip away from the boring party unnoticed.",
            exampleNative = "Она пыталась slip away с скучной вечеринки незаметно.",
            pos = "phrase", semanticGroup = "phrasal_l2_problems", fillInBlankExclusions = listOf(41106L, 41107L, 41108L, 41109L)),

        // ── phrasal_l2_changes (5) ────────────────────────────────────────

        WordEntity(id = 41111, setId = 411, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "turn into", transliteration = "[tɜrn ˈɪntu]", translation = "превратиться в",
            definition = "To change and become something different in form or character.",
            definitionNative = "Измениться и стать чем-то другим по форме или сути.",
            example = "Their friendly chat slowly turn into a serious argument.",
            exampleNative = "Их дружеская беседа медленно turn into серьёзный спор.",
            pos = "phrase", semanticGroup = "phrasal_l2_changes", fillInBlankExclusions = listOf(41112L, 41113L, 41114L, 41115L)),

        WordEntity(id = 41112, setId = 411, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "end up", transliteration = "[ɛnd ʌp]", translation = "оказаться в итоге, кончить тем, что",
            definition = "To finally be in a place or situation, often unexpectedly.",
            definitionNative = "Оказаться в итоге в каком-то месте или ситуации, часто неожиданно.",
            example = "We end up taking a taxi because of the heavy rain.",
            exampleNative = "Мы end up на такси из-за сильного дождя.",
            pos = "phrase", semanticGroup = "phrasal_l2_changes", fillInBlankExclusions = listOf(41111L, 41113L, 41114L, 41115L)),

        WordEntity(id = 41113, setId = 411, languagePair = "en-ru", rarity = "RARE",
            original = "come up with", transliteration = "[kʌm ʌp wɪð]", translation = "придумать, предложить (идею)",
            definition = "To think of an idea, plan or solution and suggest it.",
            definitionNative = "Придумать идею, план или решение и предложить его.",
            example = "She always come up with the most creative ideas at work.",
            exampleNative = "Она всегда come up with самые креативные идеи на работе.",
            pos = "phrase", semanticGroup = "phrasal_l2_changes", fillInBlankExclusions = listOf(41101L, 41111L, 41112L, 41114L, 41115L, 41124L)),

        WordEntity(id = 41114, setId = 411, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "take up", transliteration = "[teɪk ʌp]", translation = "начать заниматься (хобби, спортом)",
            definition = "To start a new hobby, sport or activity on a regular basis.",
            definitionNative = "Начать регулярно заниматься новым хобби, спортом или делом.",
            example = "After retirement he decided to take up painting as a hobby.",
            exampleNative = "После пенсии он решил take up живопись как хобби.",
            pos = "phrase", semanticGroup = "phrasal_l2_changes", fillInBlankExclusions = listOf(41111L, 41112L, 41113L, 41115L)),

        WordEntity(id = 41115, setId = 411, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "calm down", transliteration = "[kɑm daʊn]", translation = "успокоиться",
            definition = "To stop feeling angry, upset or excited and become quiet.",
            definitionNative = "Перестать злиться, расстраиваться или волноваться и стать спокойным.",
            example = "Please calm down — we'll fix this problem together.",
            exampleNative = "Пожалуйста, calm down — мы решим эту проблему вместе.",
            pos = "phrase", semanticGroup = "phrasal_l2_changes", fillInBlankExclusions = listOf(41111L, 41112L, 41113L, 41114L)),

        // ── phrasal_l2_social (5) ─────────────────────────────────────────

        WordEntity(id = 41116, setId = 411, languagePair = "en-ru", rarity = "RARE",
            original = "patch up", transliteration = "[pæʧ ʌp]", translation = "помириться, уладить (ссору)",
            definition = "To repair a friendship or relationship after a quarrel.",
            definitionNative = "Восстановить дружбу или отношения после ссоры.",
            example = "They finally patch up their friendship after a long silence.",
            exampleNative = "Они наконец-то patch up свою дружбу после долгого молчания.",
            pos = "phrase", semanticGroup = "phrasal_l2_social", fillInBlankExclusions = listOf(41101L, 41109L, 41117L, 41118L, 41119L, 41120L, 41123L, 41124L)),

        WordEntity(id = 41117, setId = 411, languagePair = "en-ru", rarity = "RARE",
            original = "fall out", transliteration = "[fɔl aʊt]", translation = "поссориться, рассориться",
            definition = "To have a serious argument with a friend or family member.",
            definitionNative = "Серьёзно поссориться с другом или членом семьи.",
            example = "The brothers fall out over a small misunderstanding last summer.",
            exampleNative = "Братья fall out из-за мелкого недоразумения прошлым летом.",
            pos = "phrase", semanticGroup = "phrasal_l2_social", fillInBlankExclusions = listOf(41106L, 41107L, 41115L, 41116L, 41118L, 41119L, 41120L)),

        WordEntity(id = 41118, setId = 411, languagePair = "en-ru", rarity = "RARE",
            original = "look up to", transliteration = "[lʊk ʌp tu]", translation = "уважать, восхищаться (кем-то)",
            definition = "To admire and respect someone, often an older person.",
            definitionNative = "Восхищаться кем-то и уважать его, часто старшего по возрасту.",
            example = "Many young athletes look up to their first coach.",
            exampleNative = "Многие молодые спортсмены look up to своего первого тренера.",
            pos = "phrase", semanticGroup = "phrasal_l2_social", fillInBlankExclusions = listOf(41102L, 41116L, 41117L, 41119L, 41120L, 41121L)),

        WordEntity(id = 41119, setId = 411, languagePair = "en-ru", rarity = "RARE",
            original = "take after", transliteration = "[teɪk ˈæftər]", translation = "пойти в (кого-то из родителей)",
            definition = "To look or behave like an older relative, usually a parent.",
            definitionNative = "Внешне или по характеру походить на старшего родственника, обычно родителя.",
            example = "Everyone says she take after her grandmother in character.",
            exampleNative = "Все говорят, что она take after свою бабушку по характеру.",
            pos = "phrase", semanticGroup = "phrasal_l2_social", fillInBlankExclusions = listOf(41116L, 41117L, 41118L, 41120L)),

        WordEntity(id = 41120, setId = 411, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "get on", transliteration = "[ɡɛt ɑn]", translation = "ладить (с кем-то); справляться",
            definition = "To have a friendly relationship with someone or to manage in a situation.",
            definitionNative = "Иметь дружеские отношения с кем-то или справляться в какой-то ситуации.",
            example = "I get on really well with my new flatmates.",
            exampleNative = "Я очень хорошо get on со своими новыми соседями по квартире.",
            pos = "phrase", semanticGroup = "phrasal_l2_social", fillInBlankExclusions = listOf(41116L, 41117L, 41118L, 41119L)),

        // ── phrasal_l2_money_things (5) ───────────────────────────────────

        WordEntity(id = 41121, setId = 411, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "pay back", transliteration = "[peɪ bæk]", translation = "вернуть (долг), отдать деньги",
            definition = "To return money that you borrowed from someone earlier.",
            definitionNative = "Вернуть деньги, которые раньше занял у кого-то.",
            example = "I'll pay back the money as soon as I get my salary.",
            exampleNative = "Я pay back деньги, как только получу зарплату.",
            pos = "phrase", semanticGroup = "phrasal_l2_money_things", fillInBlankExclusions = listOf(41103L, 41122L, 41123L, 41124L, 41125L)),

        WordEntity(id = 41122, setId = 411, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "save up", transliteration = "[seɪv ʌp]", translation = "копить (деньги на что-то)",
            definition = "To keep money over time so that you can buy something later.",
            definitionNative = "Откладывать деньги на протяжении времени, чтобы потом что-то купить.",
            example = "We're trying to save up for a trip to Japan next year.",
            exampleNative = "Мы пытаемся save up на поездку в Японию в следующем году.",
            pos = "phrase", semanticGroup = "phrasal_l2_money_things", fillInBlankExclusions = listOf(41105L, 41121L, 41123L, 41124L, 41125L)),

        WordEntity(id = 41123, setId = 411, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "throw away", transliteration = "[θroʊ əˈweɪ]", translation = "выбрасывать (в мусор)",
            definition = "To put something in the rubbish because you don't need it.",
            definitionNative = "Положить что-то в мусор, потому что это больше не нужно.",
            example = "Don't throw away those boxes — we can use them again.",
            exampleNative = "Не вздумай throw away эти коробки — мы их ещё используем.",
            pos = "phrase", semanticGroup = "phrasal_l2_money_things", fillInBlankExclusions = listOf(41109L, 41121L, 41122L, 41124L, 41125L)),

        WordEntity(id = 41124, setId = 411, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "sort out", transliteration = "[sɔrt aʊt]", translation = "разобраться, уладить (вопрос)",
            definition = "To deal with a problem or organise things successfully.",
            definitionNative = "Разобраться с проблемой или успешно организовать дела.",
            example = "I need to sort out my documents before the trip.",
            exampleNative = "Мне нужно sort out свои документы до поездки.",
            pos = "phrase", semanticGroup = "phrasal_l2_money_things", fillInBlankExclusions = listOf(41101L, 41102L, 41103L, 41116L, 41121L, 41122L, 41123L, 41125L)),

        WordEntity(id = 41125, setId = 411, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "set up", transliteration = "[sɛt ʌp]", translation = "настроить, организовать (систему)",
            definition = "To prepare equipment or start a business, account or system.",
            definitionNative = "Подготовить оборудование или открыть бизнес, аккаунт или систему.",
            example = "It only takes a few minutes to set up a new email account.",
            exampleNative = "Нужно всего несколько минут, чтобы set up новую почту.",
            pos = "phrase", semanticGroup = "phrasal_l2_money_things", fillInBlankExclusions = listOf(41121L, 41122L, 41123L, 41124L)),
    )
}
