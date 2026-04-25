package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Повседневная жизнь (level 4, профессиональный).
 *
 * Set 328: «Повседневная жизнь: профессиональный» — C1-лексика быта:
 * нестандартные глаголы движения, тонкие эмоциональные оттенки,
 * литературные описания состояний и идиоматические концепции переполоха.
 *
 * Распределение редкости: 6 RARE + 19 EPIC — два смежных уровня шкалы (B2→C1).
 *
 * Дополняет уже существующие сеты темы «Повседневная жизнь»:
 *   - Set 25  (WordDataEnglish.kt)            — L2 UNCOMMON (привычки, расписание).
 *   - Set 256 (WordDataEnglishBatch5.kt)      — L2 COMMON/UNCOMMON (распорядок дня).
 *   - Set 265 (WordDataEnglishBatch8.kt)      — L1 COMMON/UNCOMMON (месяцы, сезоны, погода).
 *   - Set 327 (WordDataEnglishEverydayL3.kt)  — L3 UNCOMMON/RARE (тонкие действия и эмоции).
 *
 * Слова setId=328 не пересекаются ни с одним из этих наборов (проверено grep).
 *
 * SemanticGroups (5 × 5):
 *   everyday_motion        — loiter, saunter, traipse, prowl, dither
 *   everyday_irked         — peeved, exasperated, vexed, indignant, disgruntled
 *   everyday_appeased      — mollified, placated, wistful, forlorn, morose
 *   everyday_drudgery      — drudgery, tedium, malaise, doldrums, lassitude
 *   everyday_commotion     — upheaval, kerfuffle, hubbub, brouhaha, palaver
 *
 * Word IDs: 32801..32825 (setId × 100 + position).
 */
object WordDataEnglishEverydayL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 328, name = "Повседневная жизнь",
            description = "Идиоматические обороты и нестандартные выражения повседневной речи носителя",
            languagePair = "en-ru",
            topic = "Повседневная жизнь", level = 4),
    )

    val words: List<WordEntity> = listOf(

        // ── everyday_motion (5) ──────────────────────────────────────────

        WordEntity(id = 32801, setId = 328, languagePair = "en-ru", rarity = "RARE",
            original = "loiter", transliteration = "[ˈlɔɪtər]", translation = "слоняться без дела",
            definition = "To stand or move slowly in a public place without any clear purpose.",
            definitionNative = "Стоять или медленно передвигаться в общественном месте без ясной цели.",
            example = "Teenagers tend to loiter near the entrance of the shopping mall.",
            exampleNative = "Подростки любят loiter у входа в торговый центр.",
            pos = "verb", semanticGroup = "everyday_motion", fillInBlankExclusions = listOf(32802L, 32803L, 32804L, 32805L)),

        WordEntity(id = 32802, setId = 328, languagePair = "en-ru", rarity = "EPIC",
            original = "saunter", transliteration = "[ˈsɔːntər]", translation = "вальяжно прохаживаться",
            definition = "To walk in a relaxed and confident manner — without any rush at all.",
            definitionNative = "Идти расслабленно и с лёгким достоинством — совершенно не торопясь.",
            example = "He likes to saunter into the office ten minutes after everyone else.",
            exampleNative = "Он любит saunter в офис на десять минут позже всех остальных.",
            pos = "verb", semanticGroup = "everyday_motion", fillInBlankExclusions = listOf(32801L, 32803L, 32804L, 32805L)),

        WordEntity(id = 32803, setId = 328, languagePair = "en-ru", rarity = "EPIC",
            original = "traipse", transliteration = "[treɪps]", translation = "тащиться (устало и долго)",
            definition = "To walk a long way in a tired or unwilling manner — usually pointlessly.",
            definitionNative = "Идти долгий путь устало или нехотя — обычно без особого смысла.",
            example = "We had to traipse across town just to find an open pharmacy.",
            exampleNative = "Нам пришлось traipse через весь город ради открытой аптеки.",
            pos = "verb", semanticGroup = "everyday_motion", fillInBlankExclusions = listOf(32801L, 32802L, 32804L, 32805L)),

        WordEntity(id = 32804, setId = 328, languagePair = "en-ru", rarity = "EPIC",
            original = "prowl", transliteration = "[praʊl]", translation = "красться, рыскать",
            definition = "To move quietly through a place looking for something — like a hunting cat.",
            definitionNative = "Тихо перемещаться по месту в поисках чего-либо — словно крадущаяся кошка.",
            example = "A stray cat used to prowl around our garden after midnight.",
            exampleNative = "Бродячий кот привык prowl вокруг нашего сада после полуночи.",
            pos = "verb", semanticGroup = "everyday_motion", fillInBlankExclusions = listOf(32801L, 32802L, 32803L, 32805L)),

        WordEntity(id = 32805, setId = 328, languagePair = "en-ru", rarity = "EPIC",
            original = "dither", transliteration = "[ˈdɪðər]", translation = "мяться, не решаться",
            definition = "To hesitate nervously between choices — unable to decide what to do.",
            definitionNative = "Нервно колебаться между вариантами — не в силах принять решение.",
            example = "Stop dither over the menu — the waiter is waiting patiently.",
            exampleNative = "Хватит dither над меню — официант терпеливо ждёт.",
            pos = "verb", semanticGroup = "everyday_motion", fillInBlankExclusions = listOf(32801L, 32802L, 32803L, 32804L)),

        // ── everyday_irked (5) ───────────────────────────────────────────

        WordEntity(id = 32806, setId = 328, languagePair = "en-ru", rarity = "EPIC",
            original = "peeved", transliteration = "[piːvd]", translation = "раздосадованный (мелочью)",
            definition = "Mildly annoyed by something small — irritated more than truly angry.",
            definitionNative = "Слегка раздражённый из-за пустяка — скорее задетый, чем по-настоящему злой.",
            example = "She was peeved that no one had remembered to bring her keys.",
            exampleNative = "Она была peeved, что никто не вспомнил принести ей ключи.",
            pos = "adjective", semanticGroup = "everyday_irked", fillInBlankExclusions = listOf(32807L, 32808L, 32809L, 32810L)),

        WordEntity(id = 32807, setId = 328, languagePair = "en-ru", rarity = "EPIC",
            original = "exasperated", transliteration = "[ɪɡˈzæspəreɪtɪd]", translation = "доведённый до бешенства",
            definition = "Deeply frustrated after long-running annoyance — patience finally worn thin.",
            definitionNative = "Глубоко изведённый долго копившимся раздражением — терпение совсем истощилось.",
            example = "The mother was exasperated by her son's third tantrum that morning.",
            exampleNative = "Мать была exasperated третьей за утро истерикой сына.",
            pos = "adjective", semanticGroup = "everyday_irked", fillInBlankExclusions = listOf(32806L, 32808L, 32809L, 32810L)),

        WordEntity(id = 32808, setId = 328, languagePair = "en-ru", rarity = "EPIC",
            original = "vexed", transliteration = "[vɛkst]", translation = "раздражённый, задетый",
            definition = "Worried and annoyed at the same time — bothered by an unpleasant problem.",
            definitionNative = "Одновременно встревоженный и раздражённый — задетый неприятной проблемой.",
            example = "He grew vexed by the constant questions about his weekend plans.",
            exampleNative = "Он сделался vexed постоянными расспросами о его планах на выходные.",
            pos = "adjective", semanticGroup = "everyday_irked", fillInBlankExclusions = listOf(32806L, 32807L, 32809L, 32810L, 32815L)),

        WordEntity(id = 32809, setId = 328, languagePair = "en-ru", rarity = "EPIC",
            original = "indignant", transliteration = "[ɪnˈdɪɡnənt]", translation = "возмущённый (несправедливостью)",
            definition = "Angry because of something seen as unfair or insulting to one's honour.",
            definitionNative = "Сердитый из-за того, что воспринимается как несправедливое или оскорбительное.",
            example = "She felt indignant when her colleague took credit for her report.",
            exampleNative = "Она была indignant, когда коллега присвоил себе её отчёт.",
            pos = "adjective", semanticGroup = "everyday_irked", fillInBlankExclusions = listOf(32806L, 32807L, 32808L, 32810L)),

        WordEntity(id = 32810, setId = 328, languagePair = "en-ru", rarity = "EPIC",
            original = "disgruntled", transliteration = "[dɪsˈɡrʌntəld]", translation = "недовольный, обиженный",
            definition = "Sour and grumpy because expectations or hopes were not met.",
            definitionNative = "Кислый и хмурый из-за того, что ожидания или надежды не оправдались.",
            example = "Disgruntled passengers complained loudly about the long delay.",
            exampleNative = "Disgruntled пассажиры громко жаловались на долгую задержку.",
            pos = "adjective", semanticGroup = "everyday_irked", fillInBlankExclusions = listOf(32806L, 32807L, 32808L, 32809L)),

        // ── everyday_appeased (5) ────────────────────────────────────────

        WordEntity(id = 32811, setId = 328, languagePair = "en-ru", rarity = "EPIC",
            original = "mollified", transliteration = "[ˈmɒləfaɪd]", translation = "умиротворённый, утихомиренный",
            definition = "Calmed down after being upset — anger softened by kind words or apology.",
            definitionNative = "Успокоенный после расстройства — гнев смягчён добрым словом или извинением.",
            example = "She was mollified by his sincere apology for the rude joke.",
            exampleNative = "Она была mollified его искренним извинением за грубую шутку.",
            pos = "adjective", semanticGroup = "everyday_appeased", fillInBlankExclusions = listOf(32806L, 32807L, 32808L, 32812L, 32813L, 32814L, 32815L)),

        WordEntity(id = 32812, setId = 328, languagePair = "en-ru", rarity = "EPIC",
            original = "placated", transliteration = "[ˈpleɪkeɪtɪd]", translation = "задобренный, успокоенный",
            definition = "Made less angry through small concessions or gentle, soothing actions.",
            definitionNative = "Сделанный менее сердитым малыми уступками или мягкими, успокаивающими действиями.",
            example = "The crying toddler was placated with a small piece of chocolate.",
            exampleNative = "Плачущий малыш был placated маленьким кусочком шоколада.",
            pos = "adjective", semanticGroup = "everyday_appeased", fillInBlankExclusions = listOf(32811L, 32813L, 32814L, 32815L)),

        WordEntity(id = 32813, setId = 328, languagePair = "en-ru", rarity = "RARE",
            original = "wistful", transliteration = "[ˈwɪstfəl]", translation = "тоскливо-задумчивый",
            definition = "Quietly sad and thoughtful — gently longing for something out of reach.",
            definitionNative = "Тихо грустный и задумчивый — мягко тоскующий по чему-то недостижимому.",
            example = "Her wistful smile suggested she missed her childhood summers by the lake.",
            exampleNative = "Её wistful улыбка намекала на тоску по детским летам у озера.",
            pos = "adjective", semanticGroup = "everyday_appeased", fillInBlankExclusions = listOf(32811L, 32812L, 32814L, 32815L)),

        WordEntity(id = 32814, setId = 328, languagePair = "en-ru", rarity = "EPIC",
            original = "forlorn", transliteration = "[fərˈlɔːrn]", translation = "покинутый, одинокий",
            definition = "Lonely and unhappy — looking abandoned by friends or by hope itself.",
            definitionNative = "Одинокий и несчастный — покинутый друзьями или самой надеждой.",
            example = "The forlorn little dog sat by the empty house for three whole days.",
            exampleNative = "Forlorn маленький пёсик сидел у пустого дома целых три дня.",
            pos = "adjective", semanticGroup = "everyday_appeased", fillInBlankExclusions = listOf(32811L, 32812L, 32813L, 32815L)),

        WordEntity(id = 32815, setId = 328, languagePair = "en-ru", rarity = "EPIC",
            original = "morose", transliteration = "[məˈroʊs]", translation = "хмурый, мрачный",
            definition = "Gloomy and silent for a long time — sunk in dark, brooding thoughts.",
            definitionNative = "Мрачный и молчаливый долгое время — погружённый в тёмные, тяжёлые думы.",
            example = "He grew morose after losing his old job at the family bookshop.",
            exampleNative = "Он сделался morose, потеряв давнюю работу в семейной книжной лавке.",
            pos = "adjective", semanticGroup = "everyday_appeased", fillInBlankExclusions = listOf(32811L, 32812L, 32813L, 32814L)),

        // ── everyday_drudgery (5) ────────────────────────────────────────

        WordEntity(id = 32816, setId = 328, languagePair = "en-ru", rarity = "EPIC",
            original = "drudgery", transliteration = "[ˈdrʌdʒəri]", translation = "нудная тяжёлая работа",
            definition = "Hard, dull, repetitive work that brings no joy or sense of meaning.",
            definitionNative = "Тяжёлая, однообразная и скучная работа, не приносящая радости или смысла.",
            example = "Modern washing machines spared housewives the drudgery of hand laundry.",
            exampleNative = "Современные стиральные машины избавили хозяек от drudgery ручной стирки.",
            pos = "noun", semanticGroup = "everyday_drudgery", fillInBlankExclusions = listOf(32817L, 32818L, 32819L, 32820L)),

        WordEntity(id = 32817, setId = 328, languagePair = "en-ru", rarity = "EPIC",
            original = "tedium", transliteration = "[ˈtiːdiəm]", translation = "скука, однообразие",
            definition = "The dull state of being bored by something slow and repetitive.",
            definitionNative = "Унылое состояние скуки от чего-то медленного и однообразного.",
            example = "The tedium of the long flight was broken only by a weak movie.",
            exampleNative = "Tedium долгого перелёта прерывался лишь слабеньким фильмом.",
            pos = "noun", semanticGroup = "everyday_drudgery", fillInBlankExclusions = listOf(32816L, 32818L, 32819L, 32820L)),

        WordEntity(id = 32818, setId = 328, languagePair = "en-ru", rarity = "EPIC",
            original = "malaise", transliteration = "[məˈleɪz]", translation = "томное недомогание, хандра",
            definition = "A vague feeling of being unwell or uneasy — without any clear cause.",
            definitionNative = "Смутное ощущение нездоровья или неуюта — без какой-либо ясной причины.",
            example = "A general malaise hung over the office on the rainy Monday morning.",
            exampleNative = "Общая malaise висела над офисом дождливым утром понедельника.",
            pos = "noun", semanticGroup = "everyday_drudgery", fillInBlankExclusions = listOf(32816L, 32817L, 32819L, 32820L)),

        WordEntity(id = 32819, setId = 328, languagePair = "en-ru", rarity = "EPIC",
            original = "doldrums", transliteration = "[ˈdoʊldrəmz]", translation = "уныние, застой",
            definition = "A long stretch of low mood or boredom — nothing exciting seems to happen.",
            definitionNative = "Долгая полоса упадка настроения или скуки — ничего волнующего не происходит.",
            example = "January always pulls our family into the post-holiday doldrums.",
            exampleNative = "Январь всегда тянет нашу семью в послепраздничные doldrums.",
            pos = "noun", semanticGroup = "everyday_drudgery", fillInBlankExclusions = listOf(32816L, 32817L, 32818L, 32820L)),

        WordEntity(id = 32820, setId = 328, languagePair = "en-ru", rarity = "EPIC",
            original = "lassitude", transliteration = "[ˈlæsɪtjuːd]", translation = "вялость, изнеможение",
            definition = "A heavy feeling of tiredness and lack of energy — body and mind both slow.",
            definitionNative = "Тяжёлое ощущение усталости и нехватки сил — и тело, и ум двигаются вяло.",
            example = "Summer heat brought a slow lassitude over the whole sleepy village.",
            exampleNative = "Летняя жара навела медленную lassitude на всю сонную деревушку.",
            pos = "noun", semanticGroup = "everyday_drudgery", fillInBlankExclusions = listOf(32816L, 32817L, 32818L, 32819L)),

        // ── everyday_commotion (5) ───────────────────────────────────────

        WordEntity(id = 32821, setId = 328, languagePair = "en-ru", rarity = "RARE",
            original = "upheaval", transliteration = "[ʌpˈhiːvəl]", translation = "потрясение, переворот",
            definition = "A big sudden change that throws everyday life or society into disorder.",
            definitionNative = "Крупная внезапная перемена, бросающая повседневную жизнь или общество в беспорядок.",
            example = "Moving to a new country was the biggest upheaval of her quiet life.",
            exampleNative = "Переезд в другую страну стал главной upheaval её тихой жизни.",
            pos = "noun", semanticGroup = "everyday_commotion", fillInBlankExclusions = listOf(32822L, 32823L, 32824L, 32825L)),

        WordEntity(id = 32822, setId = 328, languagePair = "en-ru", rarity = "EPIC",
            original = "kerfuffle", transliteration = "[kərˈfʌfəl]", translation = "переполох, суматоха",
            definition = "A noisy fuss about something fairly small — lots of voices, little real harm.",
            definitionNative = "Шумная возня вокруг чего-то мелкого — много криков, мало настоящего вреда.",
            example = "There was quite a kerfuffle when the cat jumped onto the dinner table.",
            exampleNative = "Случилась настоящая kerfuffle, когда кот запрыгнул на обеденный стол.",
            pos = "noun", semanticGroup = "everyday_commotion", fillInBlankExclusions = listOf(32823L, 32824L, 32825L)),

        WordEntity(id = 32823, setId = 328, languagePair = "en-ru", rarity = "RARE",
            original = "hubbub", transliteration = "[ˈhʌbʌb]", translation = "гул, шумная толкотня",
            definition = "The mixed noise of many voices and movements in a crowded place.",
            definitionNative = "Смешанный шум многих голосов и движений в людном пространстве.",
            example = "The hubbub of the train station made it hard to hear her phone.",
            exampleNative = "Hubbub вокзала заглушал её телефонный разговор.",
            pos = "noun", semanticGroup = "everyday_commotion", fillInBlankExclusions = listOf(32821L, 32822L, 32824L, 32825L)),

        WordEntity(id = 32824, setId = 328, languagePair = "en-ru", rarity = "EPIC",
            original = "brouhaha", transliteration = "[ˈbruːhɑːhɑː]", translation = "шумиха, скандальный гвалт",
            definition = "A loud public outcry over something — often blown out of proportion.",
            definitionNative = "Громкое общественное возмущение по поводу чего-то — нередко раздутое до небес.",
            example = "The mayor's silly tweet caused a brouhaha across the local newspapers.",
            exampleNative = "Глупый твит мэра вызвал brouhaha по всем местным газетам.",
            pos = "noun", semanticGroup = "everyday_commotion", fillInBlankExclusions = listOf(32822L, 32823L, 32825L)),

        WordEntity(id = 32825, setId = 328, languagePair = "en-ru", rarity = "EPIC",
            original = "palaver", transliteration = "[pəˈlɑːvər]", translation = "пустая болтовня, морока",
            definition = "Long, fussy talk or trouble about a matter that should be simple.",
            definitionNative = "Долгие, суетливые разговоры или возня о деле, которое могло быть простым.",
            example = "Renewing the passport turned into an endless palaver of forms and queues.",
            exampleNative = "Обновление паспорта обернулось бесконечным palaver из бумаг и очередей.",
            pos = "noun", semanticGroup = "everyday_commotion", fillInBlankExclusions = listOf(32816L, 32817L, 32821L, 32822L, 32823L, 32824L)),
    )
}
