package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Праздники и традиции (level 5, носитель языка).
 *
 * Set 374: «Праздники и традиции» — уровень носителя:
 * антропология обряда, академическая терминология, архаичные/возрождённые праздники,
 * редкие мировые торжества, концепты обрядовой жизни (C2+).
 *
 * Распределение редкости: 13 EPIC + 12 LEGENDARY — два смежных уровня шкалы.
 * isFillInBlankSafe = false для всех 25 слов: формы (Twelfth Night, Yom Kippur и т.п.)
 * многословные либо несклоняемые антропологические термины — generic-пропуски.
 *
 * Параллельные сеты темы «Праздники и традиции»:
 *   - Set 370 (L1, основы)         — параллельная разработка.
 *   - Set 371 (L2, продвинутый)    — параллельная разработка.
 *   - Set 372 (L3, углублённый)    — параллельная разработка.
 *   - Set 373 (L4, профессиональный) — параллельная разработка.
 *
 * Слова setId=374 не пересекаются с темами Religion (нет L*-сетов),
 * History (set 31, 217, 306, 312, 313) и Philosophy (set 87, 258, 83, 341, 342)
 * — проверено grep по ключевым лексемам.
 *
 * SemanticGroups (5 × 5):
 *   holidays_anthropology      — liminality, communitas, sacred time, syncretism, ritual purity
 *   holidays_advanced_terms    — observance, secularization, cultural appropriation, commodification, vernacular tradition
 *   holidays_obsolete_revived  — wassail, Twelfth Night, Beltane, Candlemas, Michaelmas
 *   holidays_obscure_world     — Obon, Kwanzaa, Holi, Yom Kippur, Vesak
 *   holidays_concepts          — rite of passage, gift economy, ceremonial exchange, ancestor veneration, taboo lifting
 *
 * Word IDs: 37401..37425 (setId × 100 + position).
 */
object WordDataEnglishHolidaysL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 374, name = "Праздники и традиции",
            description = "Уровень носителя: антропология, обрядовая лексика, академическая терминология",
            languagePair = "en-ru",
            orderIndex = 374,
            topic = "Праздники и традиции", level = 5),
    )

    val words: List<WordEntity> = listOf(

        // ── holidays_anthropology (5) ─────────────────────────────────────

        WordEntity(id = 37401, setId = 374, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "liminality", transliteration = "[ˌlɪmɪˈnæləti]", translation = "лиминальность (пороговое состояние обряда)",
            definition = "A threshold stage in a ritual — no longer the old self, not yet the new one.",
            definitionNative = "Пороговая фаза обряда: человек уже не прежний, но ещё не ставший новым.",
            example = "Anthropologists describe wedding nights as a moment of cultural liminality.",
            exampleNative = "Антропологи описывают свадебную ночь как миг культурной liminality.",
            pos = "noun", semanticGroup = "holidays_anthropology", fillInBlankExclusions = listOf(37402L, 37404L, 37407L)),

        WordEntity(id = 37402, setId = 374, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "communitas", transliteration = "[kəˈmjuːnɪtəs]", translation = "коммунитас (общность участников обряда)",
            definition = "A feeling of equal bond among people sharing a sacred moment outside daily roles.",
            definitionNative = "Чувство равенства между людьми, переживающими священный миг вне обычных ролей.",
            example = "Pilgrims walking together often report a deep sense of communitas on the road.",
            exampleNative = "Паломники в пути часто отмечают глубокое чувство communitas между собой.",
            pos = "noun", semanticGroup = "holidays_anthropology", fillInBlankExclusions = listOf(37401L, 37404L)),

        WordEntity(id = 37403, setId = 374, languagePair = "en-ru", rarity = "EPIC",
            original = "sacred time", transliteration = "[ˈseɪkrɪd taɪm]", translation = "сакральное время",
            definition = "A special period set apart from daily life when people feel close to the divine.",
            definitionNative = "Особый период, отделённый от будней, когда люди ощущают близость к божественному.",
            example = "For believers, the holiday eve enters a kind of sacred time of waiting.",
            exampleNative = "Для верующих канун праздника входит в особое sacred time ожидания.",
            pos = "phrase", semanticGroup = "holidays_anthropology", fillInBlankExclusions = listOf(37401L, 37405L)),

        WordEntity(id = 37404, setId = 374, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "syncretism", transliteration = "[ˈsɪŋkrətɪzəm]", translation = "синкретизм (слияние верований)",
            definition = "The blending of beliefs and customs from different faiths into one new whole.",
            definitionNative = "Слияние верований и обычаев из разных религий в одно новое целое.",
            example = "Latin American festivals show clear syncretism between Catholic and native practices.",
            exampleNative = "Латиноамериканские праздники ярко являют syncretism католических и местных обрядов.",
            pos = "noun", semanticGroup = "holidays_anthropology", fillInBlankExclusions = listOf(37401L, 37402L, 37408L)),

        WordEntity(id = 37405, setId = 374, languagePair = "en-ru", rarity = "EPIC",
            original = "ritual purity", transliteration = "[ˈrɪtʃuəl ˈpjʊrəti]", translation = "ритуальная чистота",
            definition = "A state of being clean in a sacred sense, required before approaching holy things.",
            definitionNative = "Состояние чистоты в священном смысле — нужно перед прикосновением к святыне.",
            example = "Many faiths demand ritual purity before entering a temple or shrine.",
            exampleNative = "Многие религии требуют ritual purity перед входом в храм или святилище.",
            pos = "phrase", semanticGroup = "holidays_anthropology", fillInBlankExclusions = listOf(37403L, 37406L)),

        // ── holidays_advanced_terms (5) ───────────────────────────────────

        WordEntity(id = 37406, setId = 374, languagePair = "en-ru", rarity = "EPIC",
            original = "observance", transliteration = "[əbˈzɜːrvəns]", translation = "соблюдение обряда / праздничный обычай",
            definition = "The careful keeping of a custom, holiday or sacred rule by a community.",
            definitionNative = "Тщательное соблюдение обычая, праздника или священного правила общиной.",
            example = "Lent observance in their family was strict and lasted full forty days.",
            exampleNative = "Великопостный observance в их семье был строг и длился полные сорок дней.",
            pos = "noun", semanticGroup = "holidays_advanced_terms", fillInBlankExclusions = listOf(37405L, 37407L, 37409L)),

        WordEntity(id = 37407, setId = 374, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "secularization", transliteration = "[ˌsɛkjələrɪˈzeɪʃən]", translation = "секуляризация (обмирщение)",
            definition = "The slow drift of customs and feasts away from religious meaning into civic life.",
            definitionNative = "Медленный сдвиг обычаев и торжеств от религиозного смысла к мирскому.",
            example = "Christmas trees in city squares mark the secularization of an old church feast.",
            exampleNative = "Городские ёлки на площадях знаменуют secularization старого церковного праздника.",
            pos = "noun", semanticGroup = "holidays_advanced_terms", fillInBlankExclusions = listOf(37404L, 37406L, 37408L, 37409L)),

        WordEntity(id = 37408, setId = 374, languagePair = "en-ru", rarity = "EPIC",
            original = "cultural appropriation", transliteration = "[ˈkʌltʃərəl əˌproʊpriˈeɪʃən]", translation = "культурная апроприация",
            definition = "Taking symbols or rites from another people without respect for their meaning.",
            definitionNative = "Заимствование символов или обрядов чужого народа без уважения к их смыслу.",
            example = "Wearing sacred headdresses as costume is widely seen as cultural appropriation.",
            exampleNative = "Ношение священных уборов как маскарад считают cultural appropriation.",
            pos = "phrase", semanticGroup = "holidays_advanced_terms", fillInBlankExclusions = listOf(37404L, 37407L, 37409L, 37410L)),

        WordEntity(id = 37409, setId = 374, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "commodification", transliteration = "[kəˌmɑdəfɪˈkeɪʃən]", translation = "коммодификация (превращение в товар)",
            definition = "Turning a meaningful tradition into a product to be bought and sold for profit.",
            definitionNative = "Превращение значимой традиции в продукт ради купли-продажи и прибыли.",
            example = "Critics decry the commodification of Halloween into endless plastic costumes.",
            exampleNative = "Критики осуждают commodification Хэллоуина в бесконечные пластиковые костюмы.",
            pos = "noun", semanticGroup = "holidays_advanced_terms", fillInBlankExclusions = listOf(37404L, 37406L, 37407L, 37408L)),

        WordEntity(id = 37410, setId = 374, languagePair = "en-ru", rarity = "EPIC",
            original = "vernacular tradition", transliteration = "[vərˈnækjələr trəˈdɪʃən]", translation = "народная (местная) традиция",
            definition = "A custom kept by ordinary folk in their own region, not by any official church.",
            definitionNative = "Обычай, хранимый простым народом в своём краю — без церковного устава.",
            example = "Pagan bonfires survived as a vernacular tradition in remote mountain villages.",
            exampleNative = "Языческие костры дожили как vernacular tradition в глухих горных сёлах.",
            pos = "phrase", semanticGroup = "holidays_advanced_terms", fillInBlankExclusions = listOf(37408L)),

        // ── holidays_obsolete_revived (5) ─────────────────────────────────

        WordEntity(id = 37411, setId = 374, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "wassail", transliteration = "[ˈwɑːseɪl]", translation = "уоссейл (ст.-англ. рождественское поздравление)",
            definition = "An old English winter cheer with spiced ale, sung from door to door for good luck.",
            definitionNative = "Старинный зимний обряд с пряным элем — пели у дверей соседям на удачу.",
            example = "Villagers carried bowls of wassail through the snowy lanes on Twelfth Night.",
            exampleNative = "Селяне несли чаши wassail по снежным улочкам в крещенский вечер.",
            pos = "noun", semanticGroup = "holidays_obsolete_revived", fillInBlankExclusions = listOf(37413L, 37414L, 37415L)),

        WordEntity(id = 37412, setId = 374, languagePair = "en-ru", rarity = "EPIC",
            original = "Twelfth Night", transliteration = "[twɛlfθ naɪt]", translation = "Двенадцатая ночь (канун Богоявления)",
            definition = "The eve of January sixth, the close of Christmas time in old English custom.",
            definitionNative = "Канун шестого января — конец Святок по старому английскому обычаю.",
            example = "On Twelfth Night the family finally took down the dried evergreen wreath.",
            exampleNative = "На Twelfth Night семья наконец сняла засохший вечнозелёный венок.",
            pos = "phrase", semanticGroup = "holidays_obsolete_revived",
            isFillInBlankSafe = false, fillInBlankExclusions = listOf(37413L, 37414L, 37415L, 37416L, 37417L, 37418L, 37419L, 37420L)),

        WordEntity(id = 37413, setId = 374, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "Beltane", transliteration = "[ˈbɛltən]", translation = "Бельтайн (кельтский майский праздник)",
            definition = "An ancient Celtic feast on May first, marked by bonfires and cattle blessings.",
            definitionNative = "Древний кельтский праздник первого мая — с кострами и благословением скота.",
            example = "Modern pagans light Beltane fires on hilltops to greet the warm season.",
            exampleNative = "Современные язычники зажигают огни Beltane на холмах, встречая тёплое полугодие.",
            pos = "noun", semanticGroup = "holidays_obsolete_revived",
            isFillInBlankSafe = false, fillInBlankExclusions = listOf(37411L, 37412L, 37414L, 37415L, 37416L, 37417L, 37418L, 37419L, 37420L)),

        WordEntity(id = 37414, setId = 374, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "Candlemas", transliteration = "[ˈkændləməs]", translation = "Сретение (Свечной праздник)",
            definition = "A Christian feast on February second when candles are blessed in church.",
            definitionNative = "Христианский праздник второго февраля — в храме освящают свечи.",
            example = "On Candlemas the priest walked through the chapel with a tall white candle.",
            exampleNative = "На Candlemas священник прошёл через часовню с высокой белой свечой.",
            pos = "noun", semanticGroup = "holidays_obsolete_revived",
            isFillInBlankSafe = false, fillInBlankExclusions = listOf(37411L, 37412L, 37413L, 37415L, 37416L, 37417L, 37419L, 37420L)),

        WordEntity(id = 37415, setId = 374, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "Michaelmas", transliteration = "[ˈmɪkəlməs]", translation = "Михайлов день (29 сентября)",
            definition = "An English autumn feast of the archangel, once tied to harvest and quarter rents.",
            definitionNative = "Английский осенний праздник архангела — когда-то связан со сбором урожая и платой.",
            example = "Tenants once paid their rent and ate roast goose at Michaelmas every year.",
            exampleNative = "Арендаторы платили оброк и ели жареного гуся на Michaelmas каждый год.",
            pos = "noun", semanticGroup = "holidays_obsolete_revived",
            isFillInBlankSafe = false, fillInBlankExclusions = listOf(37411L, 37412L, 37413L, 37414L, 37416L, 37417L, 37418L, 37419L, 37420L)),

        // ── holidays_obscure_world (5) ────────────────────────────────────

        WordEntity(id = 37416, setId = 374, languagePair = "en-ru", rarity = "EPIC",
            original = "Obon", transliteration = "[ˈoʊbɒn]", translation = "Обон (японский праздник поминовения)",
            definition = "A Japanese summer feast when families welcome the souls of dead kin home.",
            definitionNative = "Японский летний праздник — семьи встречают души умерших родных.",
            example = "Lanterns float on the river during Obon to guide spirits back across the water.",
            exampleNative = "Фонарики плывут по реке на Obon, провожая духов обратно за воду.",
            pos = "noun", semanticGroup = "holidays_obscure_world",
            isFillInBlankSafe = false, fillInBlankExclusions = listOf(37412L, 37413L, 37414L, 37415L, 37417L, 37418L, 37419L, 37420L)),

        WordEntity(id = 37417, setId = 374, languagePair = "en-ru", rarity = "EPIC",
            original = "Kwanzaa", transliteration = "[ˈkwɑːnzə]", translation = "Кванза (афроамериканский праздник)",
            definition = "An African-American winter feast of seven days honoring heritage and unity.",
            definitionNative = "Афроамериканский зимний праздник из семи дней — чествует наследие и единство.",
            example = "The family lit a fresh candle each evening of Kwanzaa from a wooden holder.",
            exampleNative = "Семья зажигала новую свечу каждый вечер Kwanzaa в деревянном подсвечнике.",
            pos = "noun", semanticGroup = "holidays_obscure_world",
            isFillInBlankSafe = false, fillInBlankExclusions = listOf(37412L, 37413L, 37414L, 37415L, 37416L, 37418L, 37419L, 37420L)),

        WordEntity(id = 37418, setId = 374, languagePair = "en-ru", rarity = "EPIC",
            original = "Holi", transliteration = "[ˈhoʊli]", translation = "Холи (индийский праздник красок)",
            definition = "An Indian spring festival when crowds throw bright colored powders at each other.",
            definitionNative = "Индийский весенний праздник — толпы осыпают друг друга яркими порошками.",
            example = "By the end of Holi every face was streaked with pink and gold.",
            exampleNative = "К концу Holi все лица во дворе были в розовых и золотых разводах.",
            pos = "noun", semanticGroup = "holidays_obscure_world",
            isFillInBlankSafe = false, fillInBlankExclusions = listOf(37412L, 37413L, 37414L, 37415L, 37416L, 37417L, 37419L, 37420L)),

        WordEntity(id = 37419, setId = 374, languagePair = "en-ru", rarity = "EPIC",
            original = "Yom Kippur", transliteration = "[ˌjɔːm kɪˈpʊər]", translation = "Йом-Киппур (Судный день)",
            definition = "The Jewish day of repentance and fasting, the most solemn date of the calendar.",
            definitionNative = "Иудейский день покаяния и поста — самая строгая дата календаря.",
            example = "On Yom Kippur the streets of the small town fell completely quiet.",
            exampleNative = "В Yom Kippur улицы маленького городка совсем смолкли.",
            pos = "phrase", semanticGroup = "holidays_obscure_world",
            isFillInBlankSafe = false, fillInBlankExclusions = listOf(37412L, 37413L, 37414L, 37415L, 37416L, 37417L, 37418L, 37420L)),

        WordEntity(id = 37420, setId = 374, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "Vesak", transliteration = "[ˈveɪsɑːk]", translation = "Весак (буддийский праздник Будды)",
            definition = "A Buddhist feast in May marking the birth, awakening and passing of the Buddha.",
            definitionNative = "Буддийский майский праздник — рождение, прозрение и уход Будды.",
            example = "Temples in Sri Lanka glow with paper lanterns through the night of Vesak.",
            exampleNative = "Храмы Шри-Ланки сияют бумажными фонарями всю ночь Vesak.",
            pos = "noun", semanticGroup = "holidays_obscure_world", fillInBlankExclusions = listOf(37413L, 37414L, 37415L, 37416L, 37417L, 37418L, 37419L)),

        // ── holidays_concepts (5) ─────────────────────────────────────────

        WordEntity(id = 37421, setId = 374, languagePair = "en-ru", rarity = "EPIC",
            original = "rite of passage", transliteration = "[raɪt əv ˈpæsɪʤ]", translation = "обряд перехода (инициации)",
            definition = "A ceremony marking a person's move from one stage of life to the next.",
            definitionNative = "Церемония, отмечающая переход человека из одного этапа жизни в другой.",
            example = "Graduation works as a modern rite of passage from school into adulthood.",
            exampleNative = "Выпускной служит современным rite of passage из школы во взрослую жизнь.",
            pos = "phrase", semanticGroup = "holidays_concepts", fillInBlankExclusions = listOf(37422L, 37423L, 37424L, 37425L)),

        WordEntity(id = 37422, setId = 374, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "gift economy", transliteration = "[ɡɪft ɪˈkɑnəmi]", translation = "дарообменная экономика",
            definition = "A way of trading where goods move as gifts, not by price or barter.",
            definitionNative = "Способ обмена, где блага идут как дары, а не по цене или бартеру.",
            example = "Some indigenous feasts run as a true gift economy of food, song and craft.",
            exampleNative = "Иные племенные торжества идут как настоящая gift economy еды, песни и ремесла.",
            pos = "phrase", semanticGroup = "holidays_concepts", fillInBlankExclusions = listOf(37421L, 37423L, 37424L, 37425L)),

        WordEntity(id = 37423, setId = 374, languagePair = "en-ru", rarity = "EPIC",
            original = "ceremonial exchange", transliteration = "[ˌsɛrəˈmoʊniəl ɪksˈʧeɪnʤ]", translation = "церемониальный обмен (дарами)",
            definition = "A formal swap of presents between groups, binding them by honor and respect.",
            definitionNative = "Торжественный обмен подарками между группами — связывает их честью и уважением.",
            example = "Pacific island feasts feature elaborate ceremonial exchange of pigs and yams.",
            exampleNative = "На островных пирах Тихого океана идёт пышный ceremonial exchange свиней и ямса.",
            pos = "phrase", semanticGroup = "holidays_concepts", fillInBlankExclusions = listOf(37421L, 37422L, 37424L, 37425L)),

        WordEntity(id = 37424, setId = 374, languagePair = "en-ru", rarity = "EPIC",
            original = "ancestor veneration", transliteration = "[ˈænsɛstər ˌvɛnəˈreɪʃən]", translation = "почитание предков",
            definition = "Honoring those who came before with offerings, prayers and remembered names.",
            definitionNative = "Почитание ушедших родичей подношениями, молитвами и памятью об именах.",
            example = "Chinese New Year keeps a strong thread of ancestor veneration before the family altar.",
            exampleNative = "Китайский Новый год хранит крепкую нить ancestor veneration у семейного алтаря.",
            pos = "phrase", semanticGroup = "holidays_concepts", fillInBlankExclusions = listOf(37406L, 37421L, 37422L, 37423L, 37425L)),

        WordEntity(id = 37425, setId = 374, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "taboo lifting", transliteration = "[təˈbuː ˈlɪftɪŋ]", translation = "снятие табу (на празднике)",
            definition = "A festive moment when usual bans on food, dress or speech are briefly set aside.",
            definitionNative = "Праздничный миг, когда обычные запреты на еду, одежду или речь ненадолго сняты.",
            example = "Carnival serves as a public taboo lifting before the strict weeks of Lent.",
            exampleNative = "Карнавал служит публичным taboo lifting перед строгими неделями поста.",
            pos = "phrase", semanticGroup = "holidays_concepts", fillInBlankExclusions = listOf(37406L, 37421L, 37422L, 37423L, 37424L)),
    )
}
