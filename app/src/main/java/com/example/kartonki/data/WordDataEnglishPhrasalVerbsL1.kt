package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Фразовые глаголы (L1, UNCOMMON+RARE).
 *
 * Set 410: «Phrasal Verbs» — основы.
 *          Базовые англоязычные phrasal verbs уровня A2-B1: фразовые
 *          лексемы вида «verb + particle», у которых смысл часто не
 *          складывается из значений отдельных слов. Это первый сет
 *          совершенно новой темы в репо — phrasal verbs как класс лексики
 *          никогда раньше не выделялись отдельным набором (в отличие от
 *          идиом в наборе 405-409 и обычных глаголов в Batch).
 *
 * Phrasal verbs — отдельный класс от:
 *   • обычных verbs (run, eat, sleep — одно слово)
 *   • idioms (kill two birds with one stone — образное выражение)
 * У phrasal verbs смысл «verb + particle» может быть как буквальным
 * (sit down, walk in), так и идиоматичным (give up = сдаваться).
 *
 * Распределение редкости: 17 UNCOMMON (A2-B1) + 8 RARE (B1).
 * Самые базовые буквальные движения/действия (sit down, get up,
 * turn on, pick up) — UNCOMMON; чуть менее частотные или с менее
 * очевидным смыслом (run into = случайно встретить, put off =
 * отложить, drop by = заглянуть) — RARE.
 *
 * ⚠️ Коллизии при подготовке (проверено grep'ом по `original = "..."`):
 *   • "wake up" — занят в WordDataEnglishBatch5 (id 25602).
 *     Заменён на "dress up" (нарядиться) — тоже daily routine.
 *   • "get dressed" — занят в WordDataEnglishBatch5 (id 25603) и это
 *     не phrasal verb, а passive participle. Заменён на "tidy up"
 *     (прибраться) — действие из бытовой рутины.
 *   • "get along" — занят в WordDataEnglishIdiomsL2 (id 40805).
 *     Заменён на "get together" (собраться вместе) — про отношения.
 *   • "break up" и "make up" — заняты в WordDataEnglish (id 3623, 3624).
 *     Не использовались, но проверены, чтобы не пытаться их брать.
 *
 * SemanticGroups (5 × 5):
 *   phrasal_l1_movement       — get up, sit down, come back, go away, walk in
 *   phrasal_l1_daily_routines — tidy up, dress up, turn on, turn off, switch off
 *   phrasal_l1_relationships  — get together, hang out, run into, drop by, catch up
 *   phrasal_l1_actions_simple — pick up, put on, put off, give up, look for
 *   phrasal_l1_communication  — call back, write down, find out, point out, fill in
 *
 * Word IDs: setId × 100 + position (41001..41025).
 *
 * Все слова — pos = "phrase". fillInBlankExclusions пустые — заполнятся
 * через FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataEnglishPhrasalVerbsL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 410,
            languagePair = "en-ru",
            orderIndex = 410,
            name = "Phrasal Verbs",
            description = "Базовые фразовые глаголы про движение, рутину, отношения, действия и общение",
            topic = "Phrasal Verbs",
            level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 410 — Phrasal Verbs: основы (L1, UNCOMMON+RARE)              ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── phrasal_l1_movement (5) ───────────────────────────────────────

        WordEntity(id = 41001, setId = 410, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "get up", transliteration = "[ɡɛt ʌp]", translation = "вставать (с постели или со стула)",
            definition = "To rise from a bed, chair or the floor and start standing.",
            definitionNative = "Встать с кровати, со стула или с пола в положение стоя.",
            example = "I usually get up at seven o'clock on weekdays.",
            exampleNative = "Я обычно get up в семь часов в будние дни.",
            pos = "phrase", semanticGroup = "phrasal_l1_movement", fillInBlankExclusions = listOf(41002L, 41003L, 41004L, 41005L, 41011L, 41012L, 41014L, 41021L)),

        WordEntity(id = 41002, setId = 410, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "sit down", transliteration = "[sɪt daʊn]", translation = "садиться",
            definition = "To move your body down onto a chair, bench or other seat.",
            definitionNative = "Опуститься телом на стул, скамейку или другое сиденье.",
            example = "Please sit down — the meeting is about to start.",
            exampleNative = "Пожалуйста, sit down — встреча сейчас начнётся.",
            pos = "phrase", semanticGroup = "phrasal_l1_movement", fillInBlankExclusions = listOf(41001L, 41003L, 41004L, 41005L, 41014L, 41021L)),

        WordEntity(id = 41003, setId = 410, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "come back", transliteration = "[kʌm bæk]", translation = "возвращаться",
            definition = "To return to a place where you were before.",
            definitionNative = "Вернуться в место, где был раньше.",
            example = "She'll come back from her trip on Sunday evening.",
            exampleNative = "Она come back из поездки в воскресенье вечером.",
            pos = "phrase", semanticGroup = "phrasal_l1_movement", fillInBlankExclusions = listOf(41001L, 41002L, 41004L, 41005L, 41021L)),

        WordEntity(id = 41004, setId = 410, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "go away", transliteration = "[ɡoʊ əˈweɪ]", translation = "уходить, убираться",
            definition = "To leave a place or to leave someone alone.",
            definitionNative = "Уйти откуда-то или оставить кого-то одного.",
            example = "Just go away and leave me alone for a while.",
            exampleNative = "Просто go away и оставь меня одного на время.",
            pos = "phrase", semanticGroup = "phrasal_l1_movement", fillInBlankExclusions = listOf(41001L, 41002L, 41003L, 41005L, 41019L)),

        WordEntity(id = 41005, setId = 410, languagePair = "en-ru", rarity = "RARE",
            original = "walk in", transliteration = "[wɔk ɪn]", translation = "войти (пешком, без приглашения)",
            definition = "To enter a room or building by walking, often without warning.",
            definitionNative = "Войти в комнату или здание пешком, часто без предупреждения.",
            example = "He just walk in without knocking on the door first.",
            exampleNative = "Он просто walk in, даже не постучав в дверь.",
            pos = "phrase", semanticGroup = "phrasal_l1_movement", fillInBlankExclusions = listOf(41001L, 41002L, 41003L, 41004L, 41014L)),

        // ── phrasal_l1_daily_routines (5) ─────────────────────────────────

        WordEntity(id = 41006, setId = 410, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "tidy up", transliteration = "[ˈtaɪdi ʌp]", translation = "прибираться",
            definition = "To make a room or place neat by putting things in order.",
            definitionNative = "Привести комнату или место в порядок, разложив вещи по местам.",
            example = "Please tidy up your room before our guests arrive.",
            exampleNative = "Пожалуйста, tidy up в своей комнате до прихода гостей.",
            pos = "phrase", semanticGroup = "phrasal_l1_daily_routines", fillInBlankExclusions = listOf(41007L, 41008L, 41009L, 41010L, 41016L)),

        WordEntity(id = 41007, setId = 410, languagePair = "en-ru", rarity = "RARE",
            original = "dress up", transliteration = "[drɛs ʌp]", translation = "наряжаться",
            definition = "To put on smart or special clothes for an event.",
            definitionNative = "Надеть нарядную или особую одежду по случаю.",
            example = "We always dress up for our anniversary dinner at the restaurant.",
            exampleNative = "Мы всегда dress up на наш юбилейный ужин в ресторане.",
            pos = "phrase", semanticGroup = "phrasal_l1_daily_routines", fillInBlankExclusions = listOf(41002L, 41003L, 41006L, 41008L, 41009L, 41010L, 41011L, 41014L)),

        WordEntity(id = 41008, setId = 410, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "turn on", transliteration = "[tɜrn ɑn]", translation = "включать",
            definition = "To make a machine or light start working by pressing a switch.",
            definitionNative = "Запустить прибор или свет, нажав кнопку или выключатель.",
            example = "Please turn on the kitchen light — it's getting dark.",
            exampleNative = "Пожалуйста, turn on свет на кухне — становится темно.",
            pos = "phrase", semanticGroup = "phrasal_l1_daily_routines", fillInBlankExclusions = listOf(41006L, 41007L, 41009L, 41010L, 41017L)),

        WordEntity(id = 41009, setId = 410, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "turn off", transliteration = "[tɜrn ɔf]", translation = "выключать",
            definition = "To make a machine or light stop working by pressing a switch.",
            definitionNative = "Остановить прибор или свет, нажав кнопку или выключатель.",
            example = "Don't forget to turn off the stove before you leave.",
            exampleNative = "Не забудь turn off плиту перед уходом.",
            pos = "phrase", semanticGroup = "phrasal_l1_daily_routines", fillInBlankExclusions = listOf(41006L, 41007L, 41008L, 41010L)),

        WordEntity(id = 41010, setId = 410, languagePair = "en-ru", rarity = "RARE",
            original = "switch off", transliteration = "[swɪʧ ɔf]", translation = "выключать (тумблером)",
            definition = "To stop a device or light by flipping its switch.",
            definitionNative = "Остановить прибор или свет, переключив тумблер.",
            example = "Please switch off the computer before going to bed.",
            exampleNative = "Пожалуйста, switch off компьютер перед сном.",
            pos = "phrase", semanticGroup = "phrasal_l1_daily_routines", fillInBlankExclusions = listOf(41006L, 41007L, 41008L, 41009L)),

        // ── phrasal_l1_relationships (5) ──────────────────────────────────

        WordEntity(id = 41011, setId = 410, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "get together", transliteration = "[ɡɛt təˈɡɛðər]", translation = "собраться вместе",
            definition = "To meet with friends or family for a friendly time.",
            definitionNative = "Встретиться с друзьями или семьёй, чтобы дружески провести время.",
            example = "Let's get together for coffee this weekend.",
            exampleNative = "Давай get together за кофе в эти выходные.",
            pos = "phrase", semanticGroup = "phrasal_l1_relationships", fillInBlankExclusions = listOf(41002L, 41007L, 41012L, 41013L, 41014L, 41015L)),

        WordEntity(id = 41012, setId = 410, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "hang out", transliteration = "[hæŋ aʊt]", translation = "тусоваться",
            definition = "To spend free time together in a relaxed way.",
            definitionNative = "Проводить свободное время вместе в расслабленной обстановке.",
            example = "We used to hang out at the park after school.",
            exampleNative = "Раньше мы любили hang out в парке после школы.",
            pos = "phrase", semanticGroup = "phrasal_l1_relationships", fillInBlankExclusions = listOf(41011L, 41013L, 41014L, 41015L)),

        WordEntity(id = 41013, setId = 410, languagePair = "en-ru", rarity = "RARE",
            original = "run into", transliteration = "[rʌn ˈɪntu]", translation = "случайно встретить",
            definition = "To meet someone by chance, without planning it.",
            definitionNative = "Встретить кого-то случайно, без договорённости.",
            example = "I run into my old teacher at the supermarket yesterday.",
            exampleNative = "Я run into старую учительницу в супермаркете вчера.",
            pos = "phrase", semanticGroup = "phrasal_l1_relationships", fillInBlankExclusions = listOf(41011L, 41012L, 41014L, 41015L, 41016L, 41020L, 41024L)),

        WordEntity(id = 41014, setId = 410, languagePair = "en-ru", rarity = "RARE",
            original = "drop by", transliteration = "[drɑp baɪ]", translation = "заглянуть (без предупреждения)",
            definition = "To visit someone for a short time, usually without calling first.",
            definitionNative = "Зайти к кому-то ненадолго, обычно без предварительного звонка.",
            example = "Feel free to drop by anytime — we're home all day.",
            exampleNative = "Можешь спокойно drop by в любое время — мы весь день дома.",
            pos = "phrase", semanticGroup = "phrasal_l1_relationships", fillInBlankExclusions = listOf(41003L, 41005L, 41011L, 41012L, 41013L, 41015L, 41021L)),

        WordEntity(id = 41015, setId = 410, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "catch up", transliteration = "[kæʧ ʌp]", translation = "наверстать новости / общаться после долгого перерыва",
            definition = "To talk with someone you haven't seen for a while about recent news.",
            definitionNative = "Поговорить с давно не видевшимся человеком о свежих новостях.",
            example = "Let's meet for lunch and catch up on everything.",
            exampleNative = "Давай встретимся за обедом и catch up обо всём.",
            pos = "phrase", semanticGroup = "phrasal_l1_relationships", fillInBlankExclusions = listOf(41011L, 41012L, 41013L, 41014L, 41016L, 41019L)),

        // ── phrasal_l1_actions_simple (5) ─────────────────────────────────

        WordEntity(id = 41016, setId = 410, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "pick up", transliteration = "[pɪk ʌp]", translation = "поднять / забрать",
            definition = "To lift something with your hand or to collect a person from a place.",
            definitionNative = "Поднять что-то рукой или забрать человека с места.",
            example = "Can you pick up the kids from school today?",
            exampleNative = "Сможешь pick up детей из школы сегодня?",
            pos = "phrase", semanticGroup = "phrasal_l1_actions_simple", fillInBlankExclusions = listOf(41007L, 41017L, 41018L, 41019L, 41020L)),

        WordEntity(id = 41017, setId = 410, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "put on", transliteration = "[pʊt ɑn]", translation = "надевать",
            definition = "To place clothing, shoes or makeup on your body.",
            definitionNative = "Поместить одежду, обувь или косметику на тело.",
            example = "Put on a warm jacket — it's freezing outside.",
            exampleNative = "Put on тёплую куртку — на улице холод.",
            pos = "phrase", semanticGroup = "phrasal_l1_actions_simple", fillInBlankExclusions = listOf(41016L, 41018L, 41019L, 41020L)),

        WordEntity(id = 41018, setId = 410, languagePair = "en-ru", rarity = "RARE",
            original = "put off", transliteration = "[pʊt ɔf]", translation = "откладывать (на потом)",
            definition = "To move a planned action to a later time.",
            definitionNative = "Перенести запланированное действие на более поздний срок.",
            example = "We had to put off the picnic because of the rain.",
            exampleNative = "Нам пришлось put off пикник из-за дождя.",
            pos = "phrase", semanticGroup = "phrasal_l1_actions_simple", fillInBlankExclusions = listOf(41016L, 41017L, 41019L, 41020L)),

        WordEntity(id = 41019, setId = 410, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "give up", translation = "сдаваться, бросать",
            transliteration = "[ɡɪv ʌp]",
            definition = "To stop trying to do something because it feels too hard.",
            definitionNative = "Прекратить попытки что-то делать, потому что это кажется слишком трудным.",
            example = "Don't give up — you're almost at the finish line.",
            exampleNative = "Не вздумай give up — ты почти у финиша.",
            pos = "phrase", semanticGroup = "phrasal_l1_actions_simple", fillInBlankExclusions = listOf(41002L, 41016L, 41017L, 41018L, 41020L)),

        WordEntity(id = 41020, setId = 410, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "look for", transliteration = "[lʊk fɔr]", translation = "искать",
            definition = "To try to find someone or something you need.",
            definitionNative = "Стараться найти нужного человека или нужный предмет.",
            example = "I'm look for my keys — have you seen them?",
            exampleNative = "Я look for свои ключи — ты их видел?",
            pos = "phrase", semanticGroup = "phrasal_l1_actions_simple", fillInBlankExclusions = listOf(41016L, 41017L, 41018L, 41019L)),

        // ── phrasal_l1_communication (5) ──────────────────────────────────

        WordEntity(id = 41021, setId = 410, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "call back", transliteration = "[kɔl bæk]", translation = "перезвонить",
            definition = "To phone someone again after they called you or you missed them.",
            definitionNative = "Позвонить кому-то снова после его звонка или пропущенного вызова.",
            example = "I'll call back as soon as my meeting is over.",
            exampleNative = "Я call back, как только закончится встреча.",
            pos = "phrase", semanticGroup = "phrasal_l1_communication", fillInBlankExclusions = listOf(41001L, 41002L, 41003L, 41005L, 41006L, 41007L, 41012L, 41014L, 41015L, 41019L, 41022L, 41023L, 41024L, 41025L)),

        WordEntity(id = 41022, setId = 410, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "write down", transliteration = "[raɪt daʊn]", translation = "записывать",
            definition = "To put words or numbers on paper so you can remember them.",
            definitionNative = "Зафиксировать слова или числа на бумаге, чтобы запомнить.",
            example = "Let me write down your address before I forget.",
            exampleNative = "Дай я write down твой адрес, пока не забыл.",
            pos = "phrase", semanticGroup = "phrasal_l1_communication", fillInBlankExclusions = listOf(41014L, 41016L, 41020L, 41021L, 41023L, 41024L, 41025L)),

        WordEntity(id = 41023, setId = 410, languagePair = "en-ru", rarity = "UNCOMMON",
            original = "find out", transliteration = "[faɪnd aʊt]", translation = "узнавать, выяснять",
            definition = "To learn information that you didn't know before.",
            definitionNative = "Получить информацию, которая раньше была неизвестна.",
            example = "I want to find out who sent me this gift.",
            exampleNative = "Хочу find out, кто прислал мне этот подарок.",
            pos = "phrase", semanticGroup = "phrasal_l1_communication", fillInBlankExclusions = listOf(41020L, 41021L, 41022L, 41024L, 41025L)),

        WordEntity(id = 41024, setId = 410, languagePair = "en-ru", rarity = "RARE",
            original = "point out", transliteration = "[pɔɪnt aʊt]", translation = "указывать (на факт), отмечать",
            definition = "To tell someone about something they hadn't noticed.",
            definitionNative = "Сообщить кому-то о том, чего он не заметил.",
            example = "She was kind enough to point out my mistake before the meeting.",
            exampleNative = "Она любезно решила point out мою ошибку до встречи.",
            pos = "phrase", semanticGroup = "phrasal_l1_communication", fillInBlankExclusions = listOf(41016L, 41021L, 41022L, 41023L, 41025L)),

        WordEntity(id = 41025, setId = 410, languagePair = "en-ru", rarity = "RARE",
            original = "fill in", transliteration = "[fɪl ɪn]", translation = "заполнять (форму, бланк)",
            definition = "To write the needed information in the empty spaces of a form.",
            definitionNative = "Вписать нужные данные в пустые места анкеты или бланка.",
            example = "Please fill in this form before you see the doctor.",
            exampleNative = "Пожалуйста, fill in этот бланк перед визитом к врачу.",
            pos = "phrase", semanticGroup = "phrasal_l1_communication", fillInBlankExclusions = listOf(41016L, 41021L, 41022L, 41023L, 41024L)),
    )
}
