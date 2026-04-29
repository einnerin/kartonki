package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Кино и сериалы (L5, EPIC+LEGENDARY).
 *
 * Set 399: «Кино и сериалы» — носитель/архаика индустрии/авторские движения/
 *          теория кино/эстетика/литературные описания. Архаика индустрии
 *          (silent reel, magic lantern, Cinéma vérité, Vitaphone, Technicolor),
 *          авторские движения (Dogme 95, Mumblecore, German Expressionism,
 *          Soviet montage, Cinema Novo), теория кино (apparatus theory,
 *          suture, Kuleshov effect, structuralism, post-structuralism),
 *          эстетика (tableau, vignette, low-key, painterly, dreamlike),
 *          литературные описания (cinematic, transcendent, kafkaesque,
 *          tarkovskian, Lynchian).
 *
 * Тема «Кино и сериалы» — продолжение L1 (set 395), L2 (set 396), L3 (set 397).
 * L4 (set 398) — соседний уровень (B2-C1), создаётся в той же волне
 * параллельным агентом. Чтобы избежать дублей с L4, этот сет строго
 * придерживается LEGENDARY-уровня — устаревшие термины индустрии, авторские
 * киношколы, философско-теоретические категории, литературные описания, —
 * а не базовые жанровые/технические термины.
 *
 * Все 25 слов этого сета не пересекаются ни с одним существующим английским
 * словом в базе (проверено grep по `original = "..."`). В частности обойдены
 * уже занятые слова: chiaroscuro, sfumato (set 239 art), hermeneutics
 * (Batch5), allegorical (set 60), mise-en-scène, montage, auteur, diegetic,
 * gaffer, grip, continuity, tracking shot, nouvelle vague (set 245 cinema),
 * jump cut (set 397 CinemaL3), surrealism, magical realism, sublime
 * (EntertainmentL5), epiphany (set 64), liminal/aleatory/verisimilitude/
 * metafiction/intertextuality (sets 78, 80), expressionism, baroque (set 239),
 * art-house (set 397), psychogeography (Batch14), phenomenology (Batch5).
 *
 * Распределение редкости: 18 LEGENDARY + 7 EPIC — два смежных уровня (C1 + C2+).
 *
 * SemanticGroups (5 × 5):
 *   cinema_l5_archaic_tech    — silent reel, magic lantern, Cinéma vérité, Vitaphone, Technicolor
 *   cinema_l5_movements       — Dogme 95, Mumblecore, German Expressionism, Soviet montage, Cinema Novo
 *   cinema_l5_theory          — apparatus theory, suture, Kuleshov effect, structuralism, post-structuralism
 *   cinema_l5_aesthetics      — tableau, vignette, low-key, painterly, dreamlike
 *   cinema_l5_descriptive     — cinematic, transcendent, kafkaesque, tarkovskian, Lynchian
 *
 * Word IDs: setId × 100 + position (39901..39925).
 *
 * fillInBlankExclusions / isFillInBlankSafe — НЕ задаются здесь. Заполнятся
 * через FILL_IN_BLANK pipeline централизованно после wave (известный баг:
 * если выставить заранее, pipeline пропустит запись).
 */
object WordDataEnglishCinemaL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 399,
            languagePair = "en-ru",
            orderIndex = 399,
            name = "Кино и сериалы",
            description = "Архаика индустрии, авторские движения и теория кино",
            topic = "Кино и сериалы",
            level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ╔══════════════════════════════════════════════════════════════════╗
        // ║ Set 399 — Кино и сериалы: носитель/архаика (L5, EPIC+LEGENDARY)  ║
        // ╚══════════════════════════════════════════════════════════════════╝

        // ── cinema_l5_archaic_tech (5) ────────────────────────────────────

        WordEntity(id = 39901, setId = 399, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "silent reel",
            transliteration = "[ˈsaɪlənt ril]",
            translation = "катушка немого кино (арх.)",
            definition = "A roll of film from the era before sound, viewed only with live music or titles.",
            definitionNative = "Бобина плёнки из эпохи до звукового кино, смотревшаяся только с тапёром или титрами.",
            example = "The archive preserved a silent reel of a forgotten Berlin street comedy.",
            exampleNative = "Архив хранил silent reel забытой берлинской уличной комедии.",
            pos = "noun", semanticGroup = "cinema_l5_archaic_tech", fillInBlankExclusions = listOf(39902L, 39903L, 39904L, 39905L, 39916L, 39917L)),

        WordEntity(id = 39902, setId = 399, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "magic lantern",
            transliteration = "[ˈmæʤɪk ˈlæntərn]",
            translation = "волшебный фонарь (арх. предтеча кинопроектора)",
            definition = "An old projector that threw painted glass slides onto a wall as a forerunner of cinema.",
            definitionNative = "Старый проектор, бросавший на стену расписные стеклянные слайды как предшественник кино.",
            example = "Travelling showmen amazed villages with a magic lantern long before the movies arrived.",
            exampleNative = "Бродячие зрелищники поражали деревни magic lantern задолго до прихода кино.",
            pos = "noun", semanticGroup = "cinema_l5_archaic_tech", fillInBlankExclusions = listOf(39901L, 39903L, 39904L, 39905L)),

        WordEntity(id = 39903, setId = 399, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "Cinéma vérité",
            transliteration = "[ˌsɪnəˈmɑ veɪriˈteɪ]",
            translation = "синема-верите (документальный стиль 60-х)",
            definition = "A documentary style that follows real life with handheld cameras and almost no staging.",
            definitionNative = "Документальный стиль, что следует за живой жизнью ручной камерой почти без постановки.",
            example = "Her thesis film borrowed the rough breath of Cinéma vérité from the sixties.",
            exampleNative = "Её дипломный фильм заимствовал шершавое дыхание Cinéma vérité шестидесятых.",
            pos = "noun", semanticGroup = "cinema_l5_archaic_tech", fillInBlankExclusions = listOf(39901L, 39902L, 39904L, 39905L, 39910L)),

        WordEntity(id = 39904, setId = 399, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "Vitaphone",
            transliteration = "[ˈvaɪtəˌfoʊn]",
            translation = "Vitaphone (арх. ранняя система звукового кино)",
            definition = "An early sound-on-disc system that married projected film to a synchronised gramophone record.",
            definitionNative = "Ранняя система звука на пластинке, что соединяла проекцию плёнки с синхронным граммофоном.",
            example = "Vitaphone briefly amazed audiences before optical sound on film overtook it.",
            exampleNative = "Vitaphone недолго восхищал зрителей, пока его не обогнал оптический звук на плёнке.",
            pos = "noun", semanticGroup = "cinema_l5_archaic_tech", fillInBlankExclusions = listOf(39901L, 39902L, 39903L, 39905L)),

        WordEntity(id = 39905, setId = 399, languagePair = "en-ru", rarity = "EPIC",
            original = "Technicolor",
            transliteration = "[ˈtɛknɪˌkʌlər]",
            translation = "Technicolor (классический трёхцветный процесс)",
            definition = "A classic colour process whose dye-soaked prints gave Hollywood its lush saturated palette.",
            definitionNative = "Классический цветной процесс, чьи краскопропитанные копии дали Голливуду пышную насыщенную палитру.",
            example = "The musical glowed in deep red and emerald Technicolor on the big screen.",
            exampleNative = "Мюзикл сиял глубоким красным и изумрудным Technicolor на большом экране.",
            pos = "noun", semanticGroup = "cinema_l5_archaic_tech", fillInBlankExclusions = listOf(39901L, 39902L, 39903L, 39904L)),

        // ── cinema_l5_movements (5) ───────────────────────────────────────

        WordEntity(id = 39906, setId = 399, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "Dogme 95",
            transliteration = "[ˈdɔɡmə ˌnaɪnti ˈfaɪv]",
            translation = "«Догма 95» (датский манифест минимализма)",
            definition = "A Danish manifesto banning artificial light, props, music, and tricks in the name of raw truth.",
            definitionNative = "Датский манифест, запретивший искусственный свет, реквизит, музыку и трюки во имя сырой правды.",
            example = "Their film followed Dogme 95 to the letter — handheld, daylight, no score.",
            exampleNative = "Их фильм следовал Dogme 95 буквально — ручная камера, дневной свет, без музыки.",
            pos = "noun", semanticGroup = "cinema_l5_movements", fillInBlankExclusions = listOf(39907L, 39908L, 39909L, 39910L)),

        WordEntity(id = 39907, setId = 399, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "Mumblecore",
            transliteration = "[ˈmʌmbəlˌkɔr]",
            translation = "мамблкор (американский минибюджетный жанр о бытовых разговорах)",
            definition = "A small American movement of cheap films built on rambling, naturalistic, half-mumbled talk.",
            definitionNative = "Малое американское движение дешёвых фильмов, построенных на сбивчивой бытовой полупроборморотанной речи.",
            example = "Critics called the early piece a textbook example of Mumblecore.",
            exampleNative = "Критики называли раннюю работу хрестоматийным примером Mumblecore.",
            pos = "noun", semanticGroup = "cinema_l5_movements", fillInBlankExclusions = listOf(39903L, 39905L, 39906L, 39908L, 39909L, 39910L, 39911L, 39914L, 39915L)),

        WordEntity(id = 39908, setId = 399, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "German Expressionism",
            transliteration = "[ˈʤɜrmən ɪkˈsprɛʃəˌnɪzəm]",
            translation = "немецкий экспрессионизм (1920-е)",
            definition = "A nineteen-twenties German style of warped sets and harsh shadow used to body forth fear.",
            definitionNative = "Стиль немецких двадцатых — кривые декорации и жёсткая тень, выявляющие страх.",
            example = "The art director chose German Expressionism to picture the killer's broken mind.",
            exampleNative = "Художник-постановщик выбрал German Expressionism, чтобы изобразить надломленный ум убийцы.",
            pos = "noun", semanticGroup = "cinema_l5_movements", fillInBlankExclusions = listOf(39906L, 39907L, 39909L, 39910L)),

        WordEntity(id = 39909, setId = 399, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "Soviet montage",
            transliteration = "[ˈsoʊviət mɑnˈtɑʒ]",
            translation = "советский монтаж (теория Эйзенштейна)",
            definition = "An early Soviet school in which the clash of cut-together shots itself produced new meaning.",
            definitionNative = "Ранняя советская школа, где сам столкновённый стык кадров рождал новое значение.",
            example = "Her course on Soviet montage opened with Eisenstein's Odessa Steps sequence.",
            exampleNative = "Её курс по Soviet montage открывался Одесской лестницей Эйзенштейна.",
            pos = "noun", semanticGroup = "cinema_l5_movements", fillInBlankExclusions = listOf(39906L, 39907L, 39908L, 39910L, 39913L)),

        WordEntity(id = 39910, setId = 399, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "Cinema Novo",
            transliteration = "[ˈsɪnəmə ˈnoʊvoʊ]",
            translation = "Синема ново (бразильское радикальное кино 60-х)",
            definition = "A radical Brazilian movement of the sixties that filmed poverty and politics with bare cameras.",
            definitionNative = "Радикальное бразильское движение шестидесятых, снимавшее бедность и политику голой камерой.",
            example = "He traced Cinema Novo from Rio's slums to the festivals of Cannes.",
            exampleNative = "Он прослеживал Cinema Novo от трущоб Рио до фестивалей Канна.",
            pos = "noun", semanticGroup = "cinema_l5_movements", fillInBlankExclusions = listOf(39906L, 39907L, 39908L, 39909L)),

        // ── cinema_l5_theory (5) ──────────────────────────────────────────

        WordEntity(id = 39911, setId = 399, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "apparatus theory",
            transliteration = "[ˌæpəˈreɪtəs ˈθɪri]",
            translation = "теория аппарата (филос.: кино как идеологическая машина)",
            definition = "A theory holding that cinema itself, as a machine of viewing, shapes the spectator's mind.",
            definitionNative = "Теория, гласящая, что само кино как машина зрения формирует ум зрителя.",
            example = "Apparatus theory taught her to mistrust the seeming neutrality of the camera.",
            exampleNative = "Apparatus theory научила её не доверять кажущейся нейтральности камеры.",
            pos = "noun", semanticGroup = "cinema_l5_theory", fillInBlankExclusions = listOf(39912L, 39913L, 39914L, 39915L)),

        WordEntity(id = 39912, setId = 399, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "suture",
            transliteration = "[ˈsuʧər]",
            translation = "сутура (теор.: «вшивание» зрителя в кадр)",
            definition = "A theory of how editing stitches the spectator into a film's world without the seam being seen.",
            definitionNative = "Теория того, как монтаж незаметно вшивает зрителя в мир фильма, скрывая шов.",
            example = "She read a long chapter on suture before her seminar on shot-reverse-shot.",
            exampleNative = "Она прочла длинную главу про suture перед семинаром о восьмёрке.",
            pos = "noun", semanticGroup = "cinema_l5_theory", fillInBlankExclusions = listOf(39909L, 39911L, 39913L, 39914L, 39915L)),

        WordEntity(id = 39913, setId = 399, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "Kuleshov effect",
            transliteration = "[ˈkulɪʃɔf ɪˈfɛkt]",
            translation = "эффект Кулешова (классическая теория монтажа)",
            definition = "The classic finding that one and the same face takes new meaning from each shot beside it.",
            definitionNative = "Классическое открытие, что одно и то же лицо принимает новый смысл от каждого соседнего кадра.",
            example = "He demonstrated the Kuleshov effect with a single neutral face and three different cutaways.",
            exampleNative = "Он показывал Kuleshov effect одним нейтральным лицом и тремя разными перебивками.",
            pos = "noun", semanticGroup = "cinema_l5_theory", fillInBlankExclusions = listOf(39909L, 39911L, 39912L, 39914L, 39915L)),

        WordEntity(id = 39914, setId = 399, languagePair = "en-ru", rarity = "EPIC",
            original = "structuralism",
            transliteration = "[ˈstrʌkʧərəˌlɪzəm]",
            translation = "структурализм (метод анализа знаков)",
            definition = "A method that reads any work as a system of paired signs whose meaning lies in their relations.",
            definitionNative = "Метод, читающий любое произведение как систему парных знаков, чей смысл — в их отношениях.",
            example = "Their reading of the western leant heavily on classic structuralism.",
            exampleNative = "Их разбор вестерна сильно опирался на классический structuralism.",
            pos = "noun", semanticGroup = "cinema_l5_theory", fillInBlankExclusions = listOf(39911L, 39912L, 39913L, 39915L)),

        WordEntity(id = 39915, setId = 399, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "post-structuralism",
            transliteration = "[ˌpoʊst ˈstrʌkʧərəˌlɪzəm]",
            translation = "постструктурализм (филос. течение)",
            definition = "A later movement that broke open structuralism and held meaning to be unstable and shifting.",
            definitionNative = "Позднейшее течение, что взломало структурализм и стало считать смысл зыбким и текучим.",
            example = "Her thesis read the cult film through the lens of post-structuralism.",
            exampleNative = "Её диссертация прочла культовый фильм через призму post-structuralism.",
            pos = "noun", semanticGroup = "cinema_l5_theory", fillInBlankExclusions = listOf(39908L, 39909L, 39911L, 39912L, 39913L, 39914L)),

        // ── cinema_l5_aesthetics (5) ──────────────────────────────────────

        WordEntity(id = 39916, setId = 399, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "tableau",
            transliteration = "[tæˈbloʊ]",
            translation = "табло (статичная живописная сцена)",
            definition = "A still painterly scene held a beat too long, as if the actors had frozen into a portrait.",
            definitionNative = "Замершая живописная сцена, выдержанная чуть дольше нужного, словно актёры застыли в портрет.",
            example = "The film closes on a tableau of the family at the long table.",
            exampleNative = "Фильм закрывается tableau семьи за длинным столом.",
            pos = "noun", semanticGroup = "cinema_l5_aesthetics", fillInBlankExclusions = listOf(39917L)),

        WordEntity(id = 39917, setId = 399, languagePair = "en-ru", rarity = "EPIC",
            original = "vignette",
            transliteration = "[vɪnˈjɛt]",
            translation = "виньетка (короткая живописная сцена; затемнение по краям кадра)",
            definition = "A small soft-edged scene or frame that fades into darkness toward its corners.",
            definitionNative = "Маленькая сцена или кадр с мягкими краями, что растворяется во тьму по углам.",
            example = "The opening vignette gave a hint of every character's secret in turn.",
            exampleNative = "Начальная vignette по очереди намекала на тайну каждого героя.",
            pos = "noun", semanticGroup = "cinema_l5_aesthetics", fillInBlankExclusions = listOf(39916L)),

        WordEntity(id = 39918, setId = 399, languagePair = "en-ru", rarity = "EPIC",
            original = "low-key",
            transliteration = "[ˌloʊ ˈki]",
            translation = "низкий ключ (лит. контрастная тёмная световая схема)",
            definition = "Of a lighting scheme built on deep shadow with only a few sharp pools of bright light.",
            definitionNative = "О световой схеме на глубокой тени с немногими резкими пятнами яркого света.",
            example = "The detective scenes were lit low-key, with most of the room sunk in black.",
            exampleNative = "Сцены с детективом были сняты low-key, и большая часть комнаты тонула в черноте.",
            pos = "adjective", semanticGroup = "cinema_l5_aesthetics", fillInBlankExclusions = listOf(39919L, 39920L)),

        WordEntity(id = 39919, setId = 399, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "painterly",
            transliteration = "[ˈpeɪntərli]",
            translation = "живописный (как старинная картина)",
            definition = "Of an image so composed in light and colour that it looks like an old oil painting.",
            definitionNative = "Об изображении, столь сложенном по свету и цвету, что напоминает старую масляную картину.",
            example = "Each frame had a painterly stillness, lit like a Vermeer interior.",
            exampleNative = "Каждый кадр был painterly, тих и освещён как интерьер Вермеера.",
            pos = "adjective", semanticGroup = "cinema_l5_aesthetics", fillInBlankExclusions = listOf(39918L, 39920L, 39921L, 39922L, 39924L)),

        WordEntity(id = 39920, setId = 399, languagePair = "en-ru", rarity = "EPIC",
            original = "dreamlike",
            transliteration = "[ˈdrimˌlaɪk]",
            translation = "сновидческий, словно во сне (книжн.)",
            definition = "Of a scene whose softened logic and floating rhythm feel as if dreamt rather than shot.",
            definitionNative = "О сцене, чья смягчённая логика и плывущий ритм кажутся скорее присниным, чем снятым.",
            example = "A dreamlike fog slid through the empty corridors of the hotel.",
            exampleNative = "Dreamlike туман скользил по пустым коридорам отеля.",
            pos = "adjective", semanticGroup = "cinema_l5_aesthetics", fillInBlankExclusions = listOf(39918L, 39919L, 39921L, 39923L, 39924L, 39925L)),

        // ── cinema_l5_descriptive (5) ─────────────────────────────────────

        WordEntity(id = 39921, setId = 399, languagePair = "en-ru", rarity = "EPIC",
            original = "cinematic",
            transliteration = "[ˌsɪnəˈmætɪk]",
            translation = "кинематографичный (с размахом и языком кино)",
            definition = "Carrying the sweep, framing, and rhythm of fine cinema rather than of plain television.",
            definitionNative = "Несущий размах, кадровку и ритм большого кино, а не простого телевидения.",
            example = "The novel's chase has a cinematic sweep that begs for the screen.",
            exampleNative = "Погоня в романе выдержана cinematic размахом, что сама просится на экран.",
            pos = "adjective", semanticGroup = "cinema_l5_descriptive", fillInBlankExclusions = listOf(39920L, 39922L, 39923L, 39924L, 39925L)),

        WordEntity(id = 39922, setId = 399, languagePair = "en-ru", rarity = "EPIC",
            original = "transcendent",
            transliteration = "[trænˈsɛndənt]",
            translation = "трансцендентный, выходящий за пределы обычного (книжн.)",
            definition = "Reaching beyond the ordinary in beauty or meaning so as to point at something higher.",
            definitionNative = "Превосходящий обычное по красоте или смыслу так, что указывает на нечто высшее.",
            example = "She called the final scene a transcendent stretch of pure cinema.",
            exampleNative = "Она называла финальную сцену transcendent отрезком чистого кино.",
            pos = "adjective", semanticGroup = "cinema_l5_descriptive", fillInBlankExclusions = listOf(39918L, 39919L, 39920L, 39921L, 39923L, 39924L, 39925L)),

        WordEntity(id = 39923, setId = 399, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "kafkaesque",
            transliteration = "[ˌkɑfkəˈɛsk]",
            translation = "кафкианский (об абсурдно-зловещей бюрократии)",
            definition = "Of a world of senseless rules and faceless powers in the manner of Franz Kafka's novels.",
            definitionNative = "О мире бессмысленных правил и безликих властей в духе романов Франца Кафки.",
            example = "The hero's slow trial had a kafkaesque chill no courtroom drama could match.",
            exampleNative = "Медленный суд над героем нёс kafkaesque холодок, какого нет ни в одной судебной драме.",
            pos = "adjective", semanticGroup = "cinema_l5_descriptive", fillInBlankExclusions = listOf(39920L, 39921L, 39922L, 39924L, 39925L)),

        WordEntity(id = 39924, setId = 399, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "tarkovskian",
            transliteration = "[tɑrˈkɔfskiən]",
            translation = "тарковский (о медленном поэтическом кино в духе Тарковского)",
            definition = "Of a slow poetic style of cinema marked by long takes, water, ruin, and quiet faith.",
            definitionNative = "О медленном поэтическом стиле кино с долгими планами, водой, руинами и тихой верой.",
            example = "The hushed pine-forest scene had an almost tarkovskian patience.",
            exampleNative = "Тихая сцена в сосновом лесу несла почти tarkovskian терпение.",
            pos = "adjective", semanticGroup = "cinema_l5_descriptive", fillInBlankExclusions = listOf(39921L, 39922L, 39923L, 39925L)),

        WordEntity(id = 39925, setId = 399, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "Lynchian",
            transliteration = "[ˈlɪnʧiən]",
            translation = "линчевский (о тревожно-странной поэтике в духе Линча)",
            definition = "Of an unsettling style in which warm small-town life suddenly opens onto dread and dream.",
            definitionNative = "О тревожащем стиле, при котором тёплая жизнь городка вдруг распахивается в ужас и сон.",
            example = "A Lynchian hum rose from the empty diner just before the lights cut out.",
            exampleNative = "Lynchian гул поднялся из пустой закусочной за миг до того, как погас свет.",
            pos = "adjective", semanticGroup = "cinema_l5_descriptive", fillInBlankExclusions = listOf(39918L, 39920L, 39921L, 39922L, 39923L, 39924L)),
    )
}
