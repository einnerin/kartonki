package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Праздники и традиции (level 4).
 *
 * Set 373: «Праздники и традиции» — профессиональный уровень: фольклор,
 * этнография, культурные обычаи разных стран (L4 / EPIC+LEGENDARY).
 *
 * Подтемы (5×5):
 *   - holidays_world          — мировые праздники (Diwali, Lunar New Year…)
 *   - holidays_ethnography    — этнография и фольклор (folklore, taboo, totem…)
 *   - holidays_religious      — религиозные практики (pilgrimage, fasting…)
 *   - holidays_pagan_roots    — языческие корни (solstice, equinox, bonfire…)
 *   - holidays_modern         — современный формат (public holiday, observance…)
 *
 * Слова не пересекаются с параллельными L1-L3 (370-372) и темами Religion,
 * History. Несколько слов (folklore, taboo, pilgrimage, solstice, equinox)
 * фигурируют в других темах (Политика, Наука) — это допустимо по правилу
 * «между темами одно слово разрешено».
 *
 * Все слова помечены isFillInBlankSafe=false до прохождения FILL_IN_BLANK
 * pipeline (см. docs/claude/fill-in-blank-pipeline.md).
 */
object WordDataEnglishHolidaysL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 373,
            languagePair = "en-ru",
            orderIndex = 373,
            name = "Праздники и традиции",
            description = "Профессиональный: фольклор, этнография, культурные обычаи разных стран",
            topic = "Праздники и традиции",
            level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── holidays_world (5) ────────────────────────────────────────────

        WordEntity(id = 37301, setId = 373, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "Diwali", transliteration = "[dɪˈwɑːli]", translation = "Дивали (праздник огней)",
            definition = "An Indian autumn festival of bright lamps, sweets and family gatherings.",
            definitionNative = "Индийский осенний праздник с яркими лампами, сладостями и встречами родных.",
            example = "Every house glowed with oil lamps on the night of Diwali.",
            exampleNative = "Каждый дом светился масляными лампами в ночь Diwali.",
            pos = "noun", semanticGroup = "holidays_world",
            isFillInBlankSafe = false, fillInBlankExclusions = listOf(37302L, 37303L, 37304L, 37305L, 37316L, 37317L, 37318L, 37320L)),

        WordEntity(id = 37302, setId = 373, languagePair = "en-ru", rarity = "EPIC",
            original = "Lunar New Year", transliteration = "[ˈluːnər njuː jɪər]", translation = "лунный Новый год",
            definition = "An East Asian festival starting the year by the cycle of the moon.",
            definitionNative = "Восточноазиатский праздник, открывающий год по лунному циклу.",
            example = "Families gather for dumplings and red envelopes during Lunar New Year.",
            exampleNative = "Семьи собираются за пельменями и красными конвертами на Lunar New Year.",
            pos = "noun", semanticGroup = "holidays_world",
            isFillInBlankSafe = false, fillInBlankExclusions = listOf(37301L, 37303L, 37304L, 37305L, 37316L, 37317L, 37318L, 37320L)),

        WordEntity(id = 37303, setId = 373, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "Hanukkah", transliteration = "[ˈhɑːnəkə]", translation = "Ханука",
            definition = "A Jewish winter feast lasting eight nights, marked by candles on a menorah.",
            definitionNative = "Еврейский зимний праздник в восемь вечеров — со свечами на меноре.",
            example = "She lit the first candle on the eve of Hanukkah.",
            exampleNative = "Она зажгла первую свечу накануне Hanukkah.",
            pos = "noun", semanticGroup = "holidays_world",
            isFillInBlankSafe = false, fillInBlankExclusions = listOf(37301L, 37302L, 37304L, 37305L, 37316L, 37317L, 37318L, 37320L)),

        WordEntity(id = 37304, setId = 373, languagePair = "en-ru", rarity = "EPIC",
            original = "Mardi Gras", transliteration = "[ˈmɑːrdi ɡrɑː]", translation = "Марди Гра / жирный вторник",
            definition = "A loud street carnival on the last day before Christian fasting begins.",
            definitionNative = "Шумный уличный карнавал в последний день перед началом христианского поста.",
            example = "The streets of New Orleans overflow with masks during Mardi Gras.",
            exampleNative = "Улицы Нового Орлеана переполнены масками во время Mardi Gras.",
            pos = "noun", semanticGroup = "holidays_world",
            isFillInBlankSafe = false, fillInBlankExclusions = listOf(37301L, 37302L, 37303L, 37305L, 37316L, 37317L, 37318L, 37320L)),

        WordEntity(id = 37305, setId = 373, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "Day of the Dead", transliteration = "[deɪ əv ðə dɛd]", translation = "День мёртвых",
            definition = "A Mexican autumn celebration when families honour relatives who have passed.",
            definitionNative = "Мексиканский осенний праздник — семьи чтят память ушедших родных.",
            example = "Marigolds and sugar skulls line every altar on Day of the Dead.",
            exampleNative = "Бархатцы и сахарные черепа украшают каждый алтарь в Day of the Dead.",
            pos = "noun", semanticGroup = "holidays_world",
            isFillInBlankSafe = false, fillInBlankExclusions = listOf(37301L, 37302L, 37303L, 37304L, 37316L, 37317L, 37318L, 37320L)),

        // ── holidays_ethnography (5) ──────────────────────────────────────

        WordEntity(id = 37306, setId = 373, languagePair = "en-ru", rarity = "EPIC",
            original = "folklore", transliteration = "[ˈfoʊklɔːr]", translation = "фольклор",
            definition = "Stories, songs and customs of common people, passed from grandparent to child.",
            definitionNative = "Истории, песни и обычаи простых людей — передаются от бабушек внукам.",
            example = "Russian folklore is full of brave tsareviches and clever foxes.",
            exampleNative = "Русский folklore полон храбрых царевичей и хитрых лис.",
            pos = "noun", semanticGroup = "holidays_ethnography", fillInBlankExclusions = listOf(37307L, 37308L, 37309L, 37310L)),

        WordEntity(id = 37307, setId = 373, languagePair = "en-ru", rarity = "EPIC",
            original = "oral tradition", transliteration = "[ˈɔːrəl trəˈdɪʃən]", translation = "устная традиция",
            definition = "The practice of preserving stories or rules by speaking them across generations.",
            definitionNative = "Способ сохранять рассказы или правила, передавая их голосом из поколения в поколение.",
            example = "The bards kept the entire epic alive through oral tradition.",
            exampleNative = "Барды сохранили весь эпос через oral tradition.",
            pos = "noun", semanticGroup = "holidays_ethnography", fillInBlankExclusions = listOf(37306L, 37308L, 37309L, 37310L)),

        WordEntity(id = 37308, setId = 373, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "superstition", transliteration = "[ˌsuːpərˈstɪʃən]", translation = "суеверие",
            definition = "A folk belief that some action brings luck or trouble, against ordinary reason.",
            definitionNative = "Народная вера, что некое действие несёт удачу или беду, вопреки здравому смыслу.",
            example = "An old superstition warns travellers never to whistle indoors.",
            exampleNative = "Старое superstition советует путникам никогда не свистеть в доме.",
            pos = "noun", semanticGroup = "holidays_ethnography", fillInBlankExclusions = listOf(37306L, 37307L, 37309L, 37310L)),

        WordEntity(id = 37309, setId = 373, languagePair = "en-ru", rarity = "EPIC",
            original = "taboo", transliteration = "[təˈbuː]", translation = "табу / запрет",
            definition = "A strict cultural ban — something one must never say, touch or eat.",
            definitionNative = "Строгое культурное «нельзя» — то, чего не говорят, не трогают и не едят.",
            example = "Mentioning the chief's name was a strong taboo in the village.",
            exampleNative = "Упоминание имени вождя было крепким taboo в деревне.",
            pos = "noun", semanticGroup = "holidays_ethnography", fillInBlankExclusions = listOf(37306L, 37307L, 37308L, 37310L)),

        WordEntity(id = 37310, setId = 373, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "totem", transliteration = "[ˈtoʊtəm]", translation = "тотем",
            definition = "An animal or plant a clan treats as its sacred ancestor and protector.",
            definitionNative = "Животное или растение, которое род считает священным предком и защитником.",
            example = "The eagle was the totem of their northern clan.",
            exampleNative = "Орёл был totem их северного клана.",
            pos = "noun", semanticGroup = "holidays_ethnography", fillInBlankExclusions = listOf(37306L, 37307L, 37308L, 37309L)),

        // ── holidays_religious (5) ────────────────────────────────────────

        WordEntity(id = 37311, setId = 373, languagePair = "en-ru", rarity = "EPIC",
            original = "pilgrimage", transliteration = "[ˈpɪlɡrəmɪdʒ]", translation = "паломничество",
            definition = "A long sacred journey to a holy site, often on foot and as a spiritual duty.",
            definitionNative = "Долгое священное путешествие к святому месту — часто пешком, как духовный долг.",
            example = "Once a year my grandfather made a quiet pilgrimage to the old monastery.",
            exampleNative = "Раз в год дед совершал тихое pilgrimage в старый монастырь.",
            pos = "noun", semanticGroup = "holidays_religious", fillInBlankExclusions = listOf(37312L, 37313L, 37314L, 37315L)),

        WordEntity(id = 37312, setId = 373, languagePair = "en-ru", rarity = "EPIC",
            original = "fasting", transliteration = "[ˈfæstɪŋ]", translation = "пост (воздержание от пищи)",
            definition = "Refusing food for a set time as a religious or health discipline.",
            definitionNative = "Отказ от пищи на установленный срок ради духовной или телесной дисциплины.",
            example = "During Ramadan many practise fasting from dawn until sunset.",
            exampleNative = "Во время Рамадана многие соблюдают fasting от рассвета до заката.",
            pos = "noun", semanticGroup = "holidays_religious", fillInBlankExclusions = listOf(37311L, 37313L, 37314L, 37315L)),

        WordEntity(id = 37313, setId = 373, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "communion", transliteration = "[kəˈmjuːnjən]", translation = "причастие",
            definition = "A Christian rite of sharing bread and wine in memory of the Last Supper.",
            definitionNative = "Христианский обряд хлеба и вина в память о Тайной вечере.",
            example = "The children received their first communion in white robes.",
            exampleNative = "Дети приняли первое communion в белых одеждах.",
            pos = "noun", semanticGroup = "holidays_religious", fillInBlankExclusions = listOf(37311L, 37312L, 37314L, 37315L)),

        WordEntity(id = 37314, setId = 373, languagePair = "en-ru", rarity = "EPIC",
            original = "baptism", transliteration = "[ˈbæptɪzəm]", translation = "крещение",
            definition = "A Christian water rite that marks a person joining the church.",
            definitionNative = "Христианский водный обряд, отмечающий вступление человека в церковь.",
            example = "Her baptism took place in the small chapel by the river.",
            exampleNative = "Её baptism прошло в маленькой часовне у реки.",
            pos = "noun", semanticGroup = "holidays_religious", fillInBlankExclusions = listOf(37311L, 37312L, 37313L, 37315L)),

        WordEntity(id = 37315, setId = 373, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "ordination", transliteration = "[ˌɔːrdəˈneɪʃən]", translation = "рукоположение / посвящение в сан",
            definition = "The solemn act of making someone a priest, monk or rabbi.",
            definitionNative = "Торжественный акт, в котором человек становится священником, монахом или раввином.",
            example = "His ordination was attended by the bishop and the whole village.",
            exampleNative = "На его ordination присутствовали епископ и вся деревня.",
            pos = "noun", semanticGroup = "holidays_religious", fillInBlankExclusions = listOf(37311L, 37312L, 37313L, 37314L)),

        // ── holidays_pagan_roots (5) ──────────────────────────────────────

        WordEntity(id = 37316, setId = 373, languagePair = "en-ru", rarity = "EPIC",
            original = "midwinter", transliteration = "[ˌmɪdˈwɪntər]", translation = "середина зимы (зимний праздник)",
            definition = "The depth of winter, around late December — old peoples lit fires on these nights.",
            definitionNative = "Глубина зимы, около конца декабря — древние жгли костры в эти ночи.",
            example = "The standing stones align with the sun at the festival of midwinter.",
            exampleNative = "Стоячие камни выстраиваются к солнцу на праздник midwinter.",
            pos = "noun", semanticGroup = "holidays_pagan_roots",
            isFillInBlankSafe = false, fillInBlankExclusions = listOf(37301L, 37302L, 37303L, 37304L, 37305L, 37317L, 37318L, 37319L, 37320L)),

        WordEntity(id = 37317, setId = 373, languagePair = "en-ru", rarity = "EPIC",
            original = "Lughnasadh", transliteration = "[ˈluːnəsə]", translation = "Лугнасад (кельтский праздник урожая)",
            definition = "An old Celtic feast at the start of August, marking the first grain harvest.",
            definitionNative = "Старый кельтский праздник в начале августа, отмечающий первый сбор зерна.",
            example = "Old farmers reaped the first wheat right at the festival of Lughnasadh.",
            exampleNative = "Старые крестьяне жали первую пшеницу прямо на праздник Lughnasadh.",
            pos = "noun", semanticGroup = "holidays_pagan_roots",
            isFillInBlankSafe = false, fillInBlankExclusions = listOf(37301L, 37302L, 37303L, 37304L, 37305L, 37316L, 37318L, 37319L, 37320L)),

        WordEntity(id = 37318, setId = 373, languagePair = "en-ru", rarity = "EPIC",
            original = "harvest festival", transliteration = "[ˈhɑːrvɪst ˈfɛstɪvəl]", translation = "праздник урожая",
            definition = "A village feast at the end of summer when grain has been gathered.",
            definitionNative = "Деревенское торжество в конце лета, когда зерно уже собрано.",
            example = "The whole valley dances together at the autumn harvest festival.",
            exampleNative = "Вся долина пляшет вместе на осеннем harvest festival.",
            pos = "noun", semanticGroup = "holidays_pagan_roots", fillInBlankExclusions = listOf(37316L, 37317L, 37319L, 37320L)),

        WordEntity(id = 37319, setId = 373, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "bonfire", transliteration = "[ˈbɑːnfaɪər]", translation = "костёр (праздничный)",
            definition = "A tall outdoor fire built for a celebration — old beliefs say it scares evil spirits.",
            definitionNative = "Высокий уличный огонь для торжества — по старым поверьям, отгоняет злых духов.",
            example = "Children leapt over the bonfire to welcome the new season.",
            exampleNative = "Дети прыгали через bonfire, встречая новый сезон.",
            pos = "noun", semanticGroup = "holidays_pagan_roots", fillInBlankExclusions = listOf(37316L, 37317L, 37318L, 37320L)),

        WordEntity(id = 37320, setId = 373, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "May Day", transliteration = "[meɪ deɪ]", translation = "майский день (весенний праздник)",
            definition = "A spring festival of flowers, ribbons and dancing around a tall pole.",
            definitionNative = "Весенний праздник цветов, лент и плясок вокруг высокого шеста.",
            example = "The girls wove crowns of daisies for May Day.",
            exampleNative = "Девушки плели венки из ромашек к May Day.",
            pos = "noun", semanticGroup = "holidays_pagan_roots",
            isFillInBlankSafe = false, fillInBlankExclusions = listOf(37301L, 37302L, 37303L, 37304L, 37305L, 37316L, 37317L, 37318L, 37319L)),

        // ── holidays_modern (5) ───────────────────────────────────────────

        WordEntity(id = 37321, setId = 373, languagePair = "en-ru", rarity = "EPIC",
            original = "civic holiday", transliteration = "[ˈsɪvɪk ˈhɑːlədeɪ]", translation = "гражданский праздник",
            definition = "A non-religious day off marking a national or city event.",
            definitionNative = "Нерелигиозный выходной, отмечающий событие страны или города.",
            example = "The town declared a civic holiday for its 200th anniversary.",
            exampleNative = "Город объявил civic holiday в честь своего 200-летия.",
            pos = "noun", semanticGroup = "holidays_modern", fillInBlankExclusions = listOf(37322L, 37323L, 37324L, 37325L)),

        WordEntity(id = 37322, setId = 373, languagePair = "en-ru", rarity = "EPIC",
            original = "public holiday", transliteration = "[ˈpʌblɪk ˈhɑːlədeɪ]", translation = "государственный выходной",
            definition = "An official day off when shops, banks and schools are normally closed.",
            definitionNative = "Официальный выходной, когда магазины, банки и школы обычно закрыты.",
            example = "Trains run on a reduced timetable on every public holiday.",
            exampleNative = "Поезда ходят по сокращённому расписанию в каждый public holiday.",
            pos = "noun", semanticGroup = "holidays_modern", fillInBlankExclusions = listOf(37321L, 37323L, 37324L, 37325L)),

        WordEntity(id = 37323, setId = 373, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "national holiday", transliteration = "[ˈnæʃənəl ˈhɑːlədeɪ]", translation = "национальный праздник",
            definition = "A day off written into a country's law to honour a major shared event.",
            definitionNative = "Выходной, закреплённый законом страны, чтобы чествовать важное общее событие.",
            example = "Independence Day became a national holiday in eighteen seventy-six.",
            exampleNative = "День независимости стал national holiday в тысяча восемьсот семьдесят шестом.",
            pos = "noun", semanticGroup = "holidays_modern", fillInBlankExclusions = listOf(37321L, 37322L, 37324L, 37325L)),

        WordEntity(id = 37324, setId = 373, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "paid leave", transliteration = "[peɪd liːv]", translation = "оплачиваемый отпуск",
            definition = "Time away from work that the employer still pays — for rest, illness or holidays.",
            definitionNative = "Время вне работы, которое работодатель всё равно оплачивает — на отдых или болезнь.",
            example = "Most companies grant extra paid leave for major family events.",
            exampleNative = "Большинство компаний дают дополнительный paid leave на крупные семейные события.",
            pos = "noun", semanticGroup = "holidays_modern", fillInBlankExclusions = listOf(37321L, 37322L, 37323L, 37325L)),

        WordEntity(id = 37325, setId = 373, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "bank holiday", transliteration = "[bæŋk ˈhɑːlədeɪ]", translation = "банковский выходной (брит.)",
            definition = "A British weekday on which banks shut and most workers stay home.",
            definitionNative = "Британский будний день, в который банки закрыты, а большинство людей дома.",
            example = "The motorway was packed before the long bank holiday weekend.",
            exampleNative = "Автомагистраль была забита перед долгими выходными bank holiday.",
            pos = "noun", semanticGroup = "holidays_modern", fillInBlankExclusions = listOf(37321L, 37322L, 37323L, 37324L)),
    )
}
