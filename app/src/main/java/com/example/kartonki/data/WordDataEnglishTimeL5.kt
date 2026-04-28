package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Время и календарь (L5, EPIC+LEGENDARY).
 *
 * Set 389: «Время и календарь» — носитель/архаика/литература/философия.
 *          Архаизмы (yore, eld, whilom, ere, anon), литературные образы
 *          времени (twilight years, sands of time, autumn of life, dotage,
 *          yesteryear), философские категории (kairos, chronos, presentism,
 *          eternalism, immutability), продвинутая хронология (primordial,
 *          atavistic, immemorial, halcyon, aforetime), литературные
 *          описания (eternal, evanescent, abeyance, vicissitudes, coeval).
 *
 * Тема «Время и календарь» — продолжение L1 (set 385), L2 (set 386), L3
 * (set 387). L4 (set 388) — соседний уровень (B2-C1), создаётся в той
 * же волне параллельным агентом. Чтобы избежать дублей с L4, этот сет
 * строго придерживается LEGENDARY-уровня — устаревшие архаизмы, латинизмы,
 * литературные клише, — а не технические/научные термины.
 *
 * Все 25 слов этого сета не пересекаются ни с одним существующим английским
 * словом в базе (проверено grep по `original = "..."`). В частности обойдены
 * уже занятые слова: palimpsest (sets 14, 77), transitory/perennial/recurrent/
 * cyclical (set 70), antediluvian (set 387 TimeL3), sempiternal/ephemeral
 * (set 76), inveterate/nascent (set 82), retrospective (EntertainmentL4),
 * anachronism (Expanded), hoary (AppearanceL5), pilgrimage (set 48 / Holidays
 * L4), ancient/ancestor (set 31), wane (set 83), forebear/posterity (Batch13),
 * fortnight (Batch7), interregnum (HistoryL4), moratorium (FinanceL5),
 * nightfall (set 386 TimeL2), eon/aeon (set 387 TimeL3).
 *
 * Распределение редкости: 18 LEGENDARY + 7 EPIC — два смежных уровня (C1 + C2+).
 *
 * SemanticGroups (5 × 5):
 *   time_l5_archaic              — yore, eld, whilom, ere, anon
 *   time_l5_literary             — twilight years, autumn of life, dotage, sands of time, yesteryear
 *   time_l5_philosophy           — immutability, eternalism, presentism, kairos, chronos
 *   time_l5_chronology_advanced  — primordial, atavistic, immemorial, halcyon, aforetime
 *   time_l5_descriptive_high     — eternal, evanescent, abeyance, vicissitudes, coeval
 *
 * Word IDs: setId × 100 + position (38901..38925).
 *
 * fillInBlankExclusions / isFillInBlankSafe — НЕ задаются здесь. Заполнятся
 * через FILL_IN_BLANK pipeline централизованно после wave (известный баг:
 * если выставить заранее, pipeline пропустит запись).
 */
object WordDataEnglishTimeL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 389,
            languagePair = "en-ru",
            orderIndex = 389,
            name = "Время и календарь",
            description = "Архаизмы, литературные образы времени и философские категории",
            topic = "Время и календарь",
            level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 389 — Время и календарь: носитель/архаика (L5, EPIC+LEGENDARY) ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── time_l5_archaic (5) ───────────────────────────────────────────

        WordEntity(id = 38901, setId = 389, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "yore",
            transliteration = "[jɔr]",
            translation = "былые времена (арх., в выражениях «of yore»)",
            definition = "A long-gone past — used in the set phrase to speak of distant former times.",
            definitionNative = "Давно ушедшее прошлое — в устойчивом обороте о далёких прежних временах.",
            example = "The minstrel sang of heroes of yore by the great hearth.",
            exampleNative = "Менестрель пел о героях yore у большого очага.",
            pos = "noun", semanticGroup = "time_l5_archaic", fillInBlankExclusions = listOf(38902L, 38910L)),

        WordEntity(id = 38902, setId = 389, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "eld",
            transliteration = "[ɛld]",
            translation = "старина, древность (арх./поэт.)",
            definition = "Old age or far-back times — a chiefly poetic word now found only in literature.",
            definitionNative = "Старость или далёкое прошлое — нынче чисто поэтическое слово, живёт лишь в книгах.",
            example = "A scholar in his eld pored over the cracked vellum.",
            exampleNative = "Учёный во своём eld корпел над растрескавшимся пергаментом.",
            pos = "noun", semanticGroup = "time_l5_archaic", fillInBlankExclusions = listOf(38901L, 38906L, 38908L)),

        WordEntity(id = 38903, setId = 389, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "whilom",
            transliteration = "[ˈwaɪləm]",
            translation = "некогда, в прошлом (арх.)",
            definition = "Once upon a time — an archaic adverb meaning at some former point in life.",
            definitionNative = "Когда-то давно — архаичное наречие о неком прежнем мгновении в жизни.",
            example = "The whilom monarch lived out his years in a quiet abbey.",
            exampleNative = "Whilom монарх дожил свои годы в тихом аббатстве.",
            pos = "adjective", semanticGroup = "time_l5_archaic", fillInBlankExclusions = listOf(38921L)),

        WordEntity(id = 38904, setId = 389, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "ere",
            transliteration = "[ɛr]",
            translation = "прежде, до того как (арх./поэт.)",
            definition = "Before — a poetic conjunction or preposition used by older writers and bards.",
            definitionNative = "До того как — поэтический союз или предлог в речи старых писателей и бардов.",
            example = "He vowed to return ere the harvest moon should rise.",
            exampleNative = "Он клялся вернуться ere взойдёт луна жатвы.",
            pos = "preposition", semanticGroup = "time_l5_archaic"),

        WordEntity(id = 38905, setId = 389, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "anon",
            transliteration = "[əˈnɑn]",
            translation = "вскоре, тотчас (арх.)",
            definition = "Soon, in a short while — an archaic adverb that survives in poetry and stage drama.",
            definitionNative = "Скоро, через малое время — архаичное наречие, живёт в поэзии и сценической драме.",
            example = "I shall return anon, my lady, with tidings of the field.",
            exampleNative = "Я вернусь anon, миледи, с вестями с поля битвы.",
            pos = "adverb", semanticGroup = "time_l5_archaic"),

        // ── time_l5_literary (5) ──────────────────────────────────────────

        WordEntity(id = 38906, setId = 389, languagePair = "en-ru", rarity = "EPIC",
            original = "twilight years",
            transliteration = "[ˈtwaɪˌlaɪt jɪrz]",
            translation = "закат жизни, поздние годы",
            definition = "The last quiet stage of someone's life — a literary image of fading light at evening.",
            definitionNative = "Последняя тихая пора чьей-то жизни — литературный образ гаснущего вечернего света.",
            example = "He spent his twilight years tending an old vineyard above the bay.",
            exampleNative = "Он провёл свои twilight years, ухаживая за старым виноградником над бухтой.",
            pos = "noun", semanticGroup = "time_l5_literary", fillInBlankExclusions = listOf(38902L, 38907L, 38908L, 38909L, 38910L)),

        WordEntity(id = 38907, setId = 389, languagePair = "en-ru", rarity = "EPIC",
            original = "autumn of life",
            transliteration = "[ˈɔtəm ʌv laɪf]",
            translation = "осень жизни (поэт.)",
            definition = "The mature later season of a person's lifetime — a poetic image taken from the year.",
            definitionNative = "Зрелая поздняя пора чьей-то жизни — поэтический образ, взятый из круговорота года.",
            example = "In the autumn of life he turned at last to writing letters home.",
            exampleNative = "В autumn of life он наконец взялся писать письма домой.",
            pos = "noun", semanticGroup = "time_l5_literary", fillInBlankExclusions = listOf(38906L, 38908L, 38909L, 38910L)),

        WordEntity(id = 38908, setId = 389, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "dotage",
            transliteration = "[ˈdoʊtəʤ]",
            translation = "дряхлость, маразм (книжн.)",
            definition = "The feeble final years of life when memory and judgement weaken — a literary word.",
            definitionNative = "Слабые последние годы жизни, когда тускнеют память и здравомыслие — книжное слово.",
            example = "In his dotage the old admiral confused his grandsons with his shipmates.",
            exampleNative = "В своём dotage старый адмирал путал внуков с однокашниками по флоту.",
            pos = "noun", semanticGroup = "time_l5_literary", fillInBlankExclusions = listOf(38902L, 38906L, 38907L, 38909L, 38910L)),

        WordEntity(id = 38909, setId = 389, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "sands of time",
            transliteration = "[sændz ʌv taɪm]",
            translation = "пески времени (поэт.)",
            definition = "Time itself imagined as grains slipping through an hourglass — a literary phrase.",
            definitionNative = "Само время, представляемое как песчинки в часах — литературное выражение.",
            example = "The sands of time were running short for the tired old empire.",
            exampleNative = "Sands of time убывали для уставшей старой империи.",
            pos = "noun", semanticGroup = "time_l5_literary", fillInBlankExclusions = listOf(38906L, 38907L, 38908L, 38910L)),

        WordEntity(id = 38910, setId = 389, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "yesteryear",
            transliteration = "[ˈjɛstərˌjɪr]",
            translation = "минувшие годы (поэт./книжн.)",
            definition = "The years that have already gone by — a poetic word for a recent vanished past.",
            definitionNative = "Уже минувшие годы — поэтическое слово о недавнем растаявшем прошлом.",
            example = "Songs of yesteryear filled the smoky tavern that night.",
            exampleNative = "Песни yesteryear заполнили дымную таверну той ночью.",
            pos = "noun", semanticGroup = "time_l5_literary", fillInBlankExclusions = listOf(38901L, 38902L, 38906L, 38907L, 38908L, 38909L)),

        // ── time_l5_philosophy (5) ────────────────────────────────────────

        WordEntity(id = 38911, setId = 389, languagePair = "en-ru", rarity = "EPIC",
            original = "immutability",
            transliteration = "[ɪˌmjuːtəˈbɪlɪti]",
            translation = "неизменность (филос.)",
            definition = "The quality of never changing — a philosophical and theological term for what stands fixed.",
            definitionNative = "Свойство никогда не меняться — философско-богословский термин о том, что стоит твёрдо.",
            example = "He argued for the immutability of the laws of nature.",
            exampleNative = "Он отстаивал immutability законов природы.",
            pos = "noun", semanticGroup = "time_l5_philosophy", fillInBlankExclusions = listOf(38912L, 38913L, 38914L, 38915L)),

        WordEntity(id = 38912, setId = 389, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "eternalism",
            transliteration = "[ɪˈtɜrnəˌlɪzəm]",
            translation = "этернализм (учение о реальности всех времён)",
            definition = "The philosophical view that past and future are equally real, like a fixed block.",
            definitionNative = "Философский взгляд, что прошлое и будущее столь же реальны, как застывший блок.",
            example = "Modern eternalism draws on relativity and the block universe model.",
            exampleNative = "Современный eternalism опирается на теорию относительности и блоковую вселенную.",
            pos = "noun", semanticGroup = "time_l5_philosophy", fillInBlankExclusions = listOf(38911L, 38913L, 38914L, 38915L)),

        WordEntity(id = 38913, setId = 389, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "presentism",
            transliteration = "[ˈprɛzəntˌɪzəm]",
            translation = "презентизм (учение о реальности только настоящего)",
            definition = "The philosophical view that only the present is real — past and future do not exist.",
            definitionNative = "Философский взгляд, что лишь настоящее реально — прошлого и будущего нет.",
            example = "His thesis defended presentism against the eternalist tradition.",
            exampleNative = "Его диссертация защищала presentism от этерналистской традиции.",
            pos = "noun", semanticGroup = "time_l5_philosophy", fillInBlankExclusions = listOf(38911L, 38912L, 38914L, 38915L)),

        WordEntity(id = 38914, setId = 389, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "kairos",
            transliteration = "[ˈkaɪrɑs]",
            translation = "кайрос (миг истинно подходящего срока)",
            definition = "A decisive instant when action ripens — the right moment as the Greeks named it.",
            definitionNative = "Решающий миг, когда действие созревает — верный момент, как называли его греки.",
            example = "The orator seized the kairos and turned the wavering crowd.",
            exampleNative = "Оратор поймал kairos и переломил колеблющуюся толпу.",
            pos = "noun", semanticGroup = "time_l5_philosophy", fillInBlankExclusions = listOf(38911L, 38912L, 38913L, 38915L)),

        WordEntity(id = 38915, setId = 389, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "chronos",
            transliteration = "[ˈkroʊnɑs]",
            translation = "хронос (линейное измеримое время)",
            definition = "Sequential measurable time — the steady flow of hours, contrasted with kairos.",
            definitionNative = "Последовательное измеримое время — ровный ход часов, противопоставленный кайросу.",
            example = "The dialogue weighed kairos against the cold ledger of chronos.",
            exampleNative = "Диалог взвешивал кайрос против холодной описи chronos.",
            pos = "noun", semanticGroup = "time_l5_philosophy", fillInBlankExclusions = listOf(38911L, 38912L, 38913L)),

        // ── time_l5_chronology_advanced (5) ───────────────────────────────

        WordEntity(id = 38916, setId = 389, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "primordial",
            transliteration = "[praɪˈmɔrdiəl]",
            translation = "первозданный, изначальный (книжн.)",
            definition = "Belonging to the very first ages — older than memory, history, or recorded life.",
            definitionNative = "Принадлежащий самым первым векам — древнее памяти, истории и записанной жизни.",
            example = "Geologists examined a primordial layer beneath the cave floor.",
            exampleNative = "Геологи изучали primordial слой под полом пещеры.",
            pos = "adjective", semanticGroup = "time_l5_chronology_advanced", fillInBlankExclusions = listOf(38919L)),

        WordEntity(id = 38917, setId = 389, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "atavistic",
            transliteration = "[ˌætəˈvɪstɪk]",
            translation = "атавистический (всплывающий из глубокой древности)",
            definition = "Reverting to a far-back ancestral state — a learned word for an old urge or feature.",
            definitionNative = "Возвращающий в очень древнее родовое состояние — учёное слово о старом порыве или признаке.",
            example = "Some atavistic dread of the dark forest still gripped the villagers.",
            exampleNative = "Некий atavistic страх перед тёмным лесом ещё держал сельчан.",
            pos = "adjective", semanticGroup = "time_l5_chronology_advanced", fillInBlankExclusions = listOf(38916L, 38918L, 38919L, 38921L)),

        WordEntity(id = 38918, setId = 389, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "immemorial",
            transliteration = "[ˌɪməˈmɔriəl]",
            translation = "незапамятный, бытующий с глубокой древности",
            definition = "Older than anything anyone can remember — used of customs, names, and sacred rights.",
            definitionNative = "Древнее всего, что кто-либо помнит — об обычаях, именах и священных правах.",
            example = "The right of way had run through the meadow from immemorial usage.",
            exampleNative = "Право прохода тянулось через луг по immemorial обычаю.",
            pos = "adjective", semanticGroup = "time_l5_chronology_advanced", fillInBlankExclusions = listOf(38916L, 38917L, 38919L)),

        WordEntity(id = 38919, setId = 389, languagePair = "en-ru", rarity = "EPIC",
            original = "halcyon",
            transliteration = "[ˈhælsiən]",
            translation = "безмятежный, светлый (об ушедшей поре, поэт.)",
            definition = "Of a calm bright vanished period — said of years remembered with peaceful longing.",
            definitionNative = "О тихой светлой ушедшей поре — о годах, которые вспоминают с мирной тоской.",
            example = "The album captured the halcyon days before the war.",
            exampleNative = "Альбом запечатлел halcyon дни до войны.",
            pos = "adjective", semanticGroup = "time_l5_chronology_advanced", fillInBlankExclusions = listOf(38916L, 38917L, 38918L)),

        WordEntity(id = 38920, setId = 389, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "aforetime",
            transliteration = "[əˈfɔrˌtaɪm]",
            translation = "в прежние времена (арх.)",
            definition = "In a former age or earlier era — an archaic adverb chiefly found in scripture and old prose.",
            definitionNative = "В былом веке или прежнюю эпоху — архаичное наречие, живёт в Писании и старой прозе.",
            example = "Aforetime this hill bore a pagan shrine.",
            exampleNative = "Aforetime на этом холме стояло языческое святилище.",
            pos = "adverb", semanticGroup = "time_l5_chronology_advanced"),

        // ── time_l5_descriptive_high (5) ──────────────────────────────────

        WordEntity(id = 38921, setId = 389, languagePair = "en-ru", rarity = "EPIC",
            original = "eternal",
            transliteration = "[ɪˈtɜrnəl]",
            translation = "вечный, без конца",
            definition = "Lasting without end — used of the soul, the divine, and the deepest hopes of humankind.",
            definitionNative = "Длящийся без конца — о душе, божественном и глубочайших чаяниях рода людского.",
            example = "He swore an eternal pledge of friendship beneath the standing stones.",
            exampleNative = "Он принёс eternal обет дружбы у стоячих камней.",
            pos = "adjective", semanticGroup = "time_l5_descriptive_high", fillInBlankExclusions = listOf(38922L)),

        WordEntity(id = 38922, setId = 389, languagePair = "en-ru", rarity = "EPIC",
            original = "evanescent",
            transliteration = "[ˌɛvəˈnɛsənt]",
            translation = "ускользающий, тающий на глазах (книжн.)",
            definition = "Vanishing almost as soon as it appears — used of mist, beauty, and brief joys.",
            definitionNative = "Исчезающий едва ли не сразу же по появлении — о тумане, красоте и кратких радостях.",
            example = "An evanescent smile flickered across her tired face.",
            exampleNative = "Evanescent улыбка скользнула по её усталому лицу.",
            pos = "adjective", semanticGroup = "time_l5_descriptive_high", fillInBlankExclusions = listOf(38917L, 38921L)),

        WordEntity(id = 38923, setId = 389, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "abeyance",
            transliteration = "[əˈbeɪəns]",
            translation = "временное приостановление (книжн./юр.)",
            definition = "A condition of being held back for a while — the formal pause of a right or process.",
            definitionNative = "Состояние, когда нечто приостановлено на время — формальная пауза в праве или ходе дела.",
            example = "The grant lay in abeyance until the heir could be found.",
            exampleNative = "Дарственная пребывала в abeyance, пока не отыщется наследник.",
            pos = "noun", semanticGroup = "time_l5_descriptive_high", fillInBlankExclusions = listOf(38924L)),

        WordEntity(id = 38924, setId = 389, languagePair = "en-ru", rarity = "EPIC",
            original = "vicissitudes",
            transliteration = "[vɪˈsɪsəˌtuːdz]",
            translation = "превратности (судьбы, времени)",
            definition = "The unpredictable shifts of fortune over time — a literary word for ups and downs of life.",
            definitionNative = "Непредсказуемые повороты удачи со временем — книжное слово о взлётах и падениях жизни.",
            example = "The chronicle traced the vicissitudes of the noble house.",
            exampleNative = "Хроника прослеживала vicissitudes благородного дома.",
            pos = "noun", semanticGroup = "time_l5_descriptive_high", fillInBlankExclusions = listOf(38906L, 38923L)),

        WordEntity(id = 38925, setId = 389, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "coeval",
            transliteration = "[koʊˈiːvəl]",
            translation = "одногодок, одной эпохи с (книжн.)",
            definition = "Of the same age or era as something else — a learned word for a contemporary in time.",
            definitionNative = "Того же возраста или эпохи, что и нечто иное — учёное слово о современнике во времени.",
            example = "The chapel is coeval with the oldest part of the keep.",
            exampleNative = "Часовня coeval с древнейшей частью донжона.",
            pos = "adjective", semanticGroup = "time_l5_descriptive_high", fillInBlankExclusions = listOf(38921L, 38922L)),
    )
}
