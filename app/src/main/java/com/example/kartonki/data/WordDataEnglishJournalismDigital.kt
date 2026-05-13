package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — set 471.
 * Журналистика: fact-checking и цифровая журналистика (L4 / RARE + EPIC).
 *
 * Расширение темы «Журналистика». Дополняет существующие сеты:
 *   - 33        — СМИ и технологии (L2): newspaper, journalist, podcast, blog, anchor.
 *   - 51        — Влияние СМИ и источники (L3): propaganda, disinformation,
 *                 fake news, viral, clickbait, paywall.
 *   - 305 (L4)  — Производство материала: fact-check, lede, op-ed, longform,
 *                 stringer, scoop, embargo, byline, dateline, attribution.
 *   - 311 (L5)  — Архаика типографики: linotype, muckraker, samizdat.
 *
 * Подтема — современная digital-журналистика (середина 2020-х):
 *   fact-checking процедуры (debunk, retraction, correction, source verification,
 *     primary source),
 *   дезинформация и поддельные медиа (misinformation, conspiracy theory,
 *     AI-generated content, manipulated media, doctored image),
 *   цифровые форматы (newsletter, native advertising, sponsored content,
 *     listicle, secondary source),
 *   профессиональная лексика (exclusive, investigative journalism, beat reporter,
 *     Pulitzer, on-background),
 *   workflow и взаимодействие с источниками (off-the-record, OSINT, wire service,
 *     embed, fixer).
 *
 * НЕ дубли с другими en-ru сетами (проверено grep по всем WordDataEnglish*.kt):
 *   propaganda/disinformation/viral/clickbait/paywall (51), fact-check/lede/op-ed/
 *   longform/stringer/scoop/embargo/byline/dateline (305), podcast (33),
 *   deepfake/hoax (Internet L2), ghostwriter (Literature), sponsored post (257
 *   social_media_business — там другой паттерн, у нас sponsored content как
 *   формат материала). exclusive, retraction, correction, debunk, misinformation,
 *   conspiracy theory, OSINT, Pulitzer и прочие — впервые в базе.
 *
 * Распределение редкости (2 смежных уровня по `validate_rarity_spread`):
 *   RARE — 13 слов (отраслевой стандарт цифровой журналистики).
 *   EPIC — 12 слов (продвинутая профлексика: source verification, primary source,
 *          manipulated media, doctored image, secondary source, Pulitzer,
 *          on-background, OSINT, wire service, embed, fixer, listicle no —
 *          listicle = RARE; считаем точно ниже).
 *
 * Пять семантических подгрупп:
 *   journalism_fact_checking   — процедуры проверки фактов (5 слов)
 *   journalism_disinformation  — дезинформация и поддельные медиа (5 слов)
 *   journalism_digital_formats — цифровые форматы материалов (5 слов)
 *   journalism_pro_lexicon     — профлексика репортёра (5 слов)
 *   journalism_workflow        — workflow и взаимодействие с источниками (5 слов)
 *
 * Word IDs: 47101..47125 (setId × 100 + position).
 */
object WordDataEnglishJournalismDigital {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 471,
            name = "Журналистика",
            description = "Fact-checking и цифровая журналистика: дезинформация, deepfake-эпоха, новые форматы (debunk, retraction, native advertising, OSINT)",
            languagePair = "en-ru",
            orderIndex = 471,
            topic = "Журналистика",
            level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── journalism_fact_checking (процедуры проверки фактов) ──────────────
        WordEntity(
            id = 47101, original = "debunk", transliteration = "[diːˈbʌŋk]", translation = "опровергать (миф, ложное утверждение)",
            definition = "To prove that a popular claim, rumour or theory is false by checking the evidence.",
            definitionNative = "Доказывать ложность популярного утверждения, слуха или теории через проверку доказательств.",
            example = "The BBC's Verify team spent a week trying to debunk the viral video of the staged protest.",
            exampleNative = "Команда BBC Verify неделю пыталась debunk вирусное видео постановочной протестной акции.",
            rarity = "RARE", setId = 471, languagePair = "en-ru", pos = "verb",
            semanticGroup = "journalism_fact_checking"),
        WordEntity(
            id = 47102, original = "retraction", transliteration = "[rɪˈtrækʃən]", translation = "отзыв публикации",
            definition = "Official statement by a media outlet that withdraws a story shown to be wrong.",
            definitionNative = "Официальное заявление издания об отзыве материала, оказавшегося неверным.",
            example = "Rolling Stone issued a full retraction of the campus rape story after the reporting collapsed.",
            exampleNative = "Rolling Stone выпустил полный retraction той статьи об изнасиловании в кампусе после провала репортажа.",
            rarity = "RARE", setId = 471, languagePair = "en-ru", pos = "noun",
            semanticGroup = "journalism_fact_checking", fillInBlankExclusions = listOf(47103L)),
        WordEntity(
            id = 47103, original = "correction", transliteration = "[kəˈrɛkʃən]", translation = "поправка (к материалу)",
            definition = "Short note that fixes a factual mistake in an already published article.",
            definitionNative = "Короткая заметка, исправляющая фактическую ошибку в уже опубликованном материале.",
            example = "A correction appended to paragraph four notes that the senator voted against the bill, not for it.",
            exampleNative = "Correction в конце четвёртого абзаца уточняет, что сенатор голосовал против законопроекта, а не за.",
            rarity = "RARE", setId = 471, languagePair = "en-ru", pos = "noun",
            semanticGroup = "journalism_fact_checking", fillInBlankExclusions = listOf(47102L)),
        WordEntity(
            id = 47104, original = "source verification", transliteration = "[sɔːrs ˌvɛrɪfɪˈkeɪʃən]", translation = "верификация источника",
            definition = "Step-by-step checking that the person or document behind a story is real and reliable.",
            definitionNative = "Пошаговая проверка, что человек или документ за материалом существуют и достоверны.",
            example = "Source verification took two days — geolocation, reverse image search and a call to city hall.",
            exampleNative = "Source verification заняла два дня: геолокация, обратный поиск и звонок в мэрию.",
            rarity = "EPIC", setId = 471, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "journalism_fact_checking", fillInBlankExclusions = listOf(47105L)),
        WordEntity(
            id = 47105, original = "primary source", transliteration = "[ˈpraɪmɛri sɔːrs]", translation = "первичный источник",
            definition = "Original document, witness or recording — the closest possible evidence of an event.",
            definitionNative = "Первоисточник: документ, свидетель или запись — максимально близкое свидетельство события.",
            example = "Leaked emails counted as a primary source; the press release only paraphrased them for the public.",
            exampleNative = "Утёкшие письма были primary source — пресс-релиз лишь пересказывал их для публики.",
            rarity = "EPIC", setId = 471, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "journalism_fact_checking", fillInBlankExclusions = listOf(47104L)),

        // ── journalism_disinformation (дезинформация и поддельные медиа) ──────
        WordEntity(
            id = 47106, original = "misinformation", transliteration = "[ˌmɪsɪnfərˈmeɪʃən]", translation = "недостоверная информация (по ошибке)",
            definition = "False information that someone shares without meaning to deceive — they believe it is true.",
            definitionNative = "Ложная информация, которую распространяют без умысла обмануть — её считают правдой.",
            example = "Most pandemic misinformation came from worried parents resharing posts, not organised campaigns.",
            exampleNative = "Большая часть пандемийной misinformation шла от встревоженных родителей, а не от кампаний.",
            rarity = "RARE", setId = 471, languagePair = "en-ru", pos = "noun",
            semanticGroup = "journalism_disinformation"),
        WordEntity(
            id = 47107, original = "conspiracy theory", transliteration = "[kənˈspɪrəsi ˈθɪəri]", translation = "теория заговора",
            definition = "Explanation that blames secret powerful groups for events that have ordinary causes.",
            definitionNative = "Объяснение, приписывающее обычные события тайным могущественным группам.",
            example = "The newsroom refused to platform the conspiracy theory unless three experts could rebut it.",
            exampleNative = "Редакция отказалась давать слово этой conspiracy theory, пока её не опровергнут трое экспертов.",
            rarity = "RARE", setId = 471, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "journalism_disinformation", fillInBlankExclusions = listOf(47108L, 47109L, 47110L)),
        WordEntity(
            id = 47108, original = "AI-generated content", transliteration = "[ˌeɪ ˈaɪ ˈʤɛnəreɪtɪd ˈkɒntɛnt]", translation = "контент, созданный ИИ",
            definition = "Text, image or video produced by a machine learning model without a human author writing each piece.",
            definitionNative = "Текст, изображение или видео, созданное ИИ-моделью без человека-автора каждого куска.",
            example = "The newsroom labels every piece of AI-generated content with a bot icon above the headline.",
            exampleNative = "Редакция помечает каждый кусок AI-generated content иконкой бота над заголовком.",
            rarity = "RARE", setId = 471, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "journalism_disinformation", fillInBlankExclusions = listOf(47107L, 47109L, 47110L)),
        WordEntity(
            id = 47109, original = "manipulated media", transliteration = "[məˈnɪpjʊleɪtɪd ˈmiːdiə]", translation = "манипулированные медиа",
            definition = "Photos, videos or audio that have been edited to create a false impression of an event.",
            definitionNative = "Фото, видео или аудио, отредактированные так, чтобы создать ложное впечатление о событии.",
            example = "Twitter flagged the speech clip as manipulated media after experts spotted slowed-down audio.",
            exampleNative = "Twitter пометил клип речи как manipulated media — эксперты заметили замедленное аудио.",
            rarity = "EPIC", setId = 471, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "journalism_disinformation", fillInBlankExclusions = listOf(47107L, 47108L, 47110L)),
        WordEntity(
            id = 47110, original = "doctored image", transliteration = "[ˈdɒktərd ˈɪmɪʤ]", translation = "отретушированное (поддельное) изображение",
            definition = "Photo that has been altered — objects added, removed or moved — to change what it appears to show.",
            definitionNative = "Фото, изменённое — с добавлением, удалением или переносом объектов — чтобы поменять смысл сцены.",
            example = "Reuters pulled the photo within an hour after readers spotted a doctored image of the building.",
            exampleNative = "Reuters снял снимок за час — читатели заметили doctored image того здания.",
            rarity = "EPIC", setId = 471, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "journalism_disinformation", fillInBlankExclusions = listOf(47107L, 47109L)),

        // ── journalism_digital_formats (цифровые форматы материалов) ──────────
        WordEntity(
            id = 47111, original = "newsletter", transliteration = "[ˈnuːzlɛtər]", translation = "рассылка (email-формат)",
            definition = "Regular email publication a journalist sends directly to readers who subscribed.",
            definitionNative = "Регулярная email-публикация, которую журналист отправляет подписавшимся читателям.",
            example = "Casey Newton's daily newsletter on Big Tech now has more paying readers than many city papers.",
            exampleNative = "Дневной newsletter Кейси Ньютона про бигтех имеет уже больше платных читателей, чем многие городские газеты.",
            rarity = "RARE", setId = 471, languagePair = "en-ru", pos = "noun",
            semanticGroup = "journalism_digital_formats", fillInBlankExclusions = listOf(47114L)),
        WordEntity(
            id = 47112, original = "native advertising", transliteration = "[ˈneɪtɪv ˈædvərtaɪzɪŋ]", translation = "нативная реклама",
            definition = "Paid content designed to look and read like a normal article on the same site.",
            definitionNative = "Платный материал, оформленный так, чтобы выглядеть и читаться как обычная статья сайта.",
            example = "The Atlantic was burnt in 2013 by a native advertising piece readers mistook for editorial.",
            exampleNative = "The Atlantic обжёгся в 2013 году на native advertising, которую читатели приняли за редакционный материал.",
            rarity = "RARE", setId = 471, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "journalism_digital_formats", fillInBlankExclusions = listOf(47113L, 47115L)),
        WordEntity(
            id = 47113, original = "sponsored content", transliteration = "[ˈspɒnsərd ˈkɒntɛnt]", translation = "спонсируемый материал",
            definition = "Article or video paid for by a brand and clearly labelled as such above the headline.",
            definitionNative = "Статья или видео, оплаченные брендом и явно помеченные пометкой над заголовком.",
            example = "Sponsored content from Salesforce sits at the top of the homepage with a yellow Promoted tag.",
            exampleNative = "Sponsored content от Salesforce висит вверху главной страницы с жёлтой плашкой Promoted.",
            rarity = "RARE", setId = 471, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "journalism_digital_formats", fillInBlankExclusions = listOf(47112L, 47115L)),
        WordEntity(
            id = 47114, original = "listicle", transliteration = "[ˈlɪstɪkəl]", translation = "статья-список",
            definition = "Article built as a numbered list — \"Ten ways to…\" — instead of running prose.",
            definitionNative = "Статья в виде нумерованного списка — «Десять способов…» — вместо обычного текста.",
            example = "BuzzFeed built a billion-dollar empire on the listicle before pivoting to more serious reporting.",
            exampleNative = "BuzzFeed построил миллиардную империю на listicle, прежде чем уйти в более серьёзную журналистику.",
            rarity = "RARE", setId = 471, languagePair = "en-ru", pos = "noun",
            semanticGroup = "journalism_digital_formats", fillInBlankExclusions = listOf(47111L)),
        WordEntity(
            id = 47115, original = "secondary source", transliteration = "[ˈsɛkənˌdɛri sɔːrs]", translation = "вторичный источник",
            definition = "Material that retells or analyses a primary source rather than presenting the original evidence.",
            definitionNative = "Материал, пересказывающий или анализирующий первоисточник, а не предъявляющий оригинальное доказательство.",
            example = "Reuters' wire summary was a secondary source — the editor still asked for the leaked PDF itself.",
            exampleNative = "Сводка Reuters была secondary source — редактор всё равно попросил сам утёкший PDF.",
            rarity = "EPIC", setId = 471, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "journalism_digital_formats", fillInBlankExclusions = listOf(47112L, 47113L)),

        // ── journalism_pro_lexicon (профлексика репортёра) ────────────────────
        WordEntity(
            id = 47116, original = "exclusive", transliteration = "[ɪkˈskluːsɪv]", translation = "эксклюзив (материал)",
            definition = "Story that one outlet publishes first and that no rival paper has at the same time.",
            definitionNative = "Материал, который одно издание выпускает первым, и которого нет у конкурентов в тот же момент.",
            example = "The Guardian ran the leaked memo as an exclusive on the front page of its Sunday edition.",
            exampleNative = "The Guardian опубликовал утёкшую служебную записку как exclusive на первой полосе воскресного номера.",
            rarity = "RARE", setId = 471, languagePair = "en-ru", pos = "noun",
            semanticGroup = "journalism_pro_lexicon"),
        WordEntity(
            id = 47117, original = "investigative journalism", transliteration = "[ɪnˈvɛstɪɡətɪv ˈʤɜːrnəlɪzəm]", translation = "журналистское расследование",
            definition = "Long-form reporting that uncovers wrongdoing hidden by powerful people or institutions.",
            definitionNative = "Длительный репортаж, вскрывающий нарушения, спрятанные властными людьми или организациями.",
            example = "ProPublica's investigative journalism on the Supreme Court forced new disclosure rules in a year.",
            exampleNative = "Investigative journalism ProPublica о Верховном суде привело к новым правилам раскрытия за год.",
            rarity = "RARE", setId = 471, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "journalism_pro_lexicon", fillInBlankExclusions = listOf(47118L, 47120L)),
        WordEntity(
            id = 47118, original = "beat reporter", transliteration = "[biːt rɪˈpɔːrtər]", translation = "корреспондент-специалист (по направлению)",
            definition = "Journalist who covers one specific topic — courts, tech, City Hall — week after week.",
            definitionNative = "Журналист, который из недели в неделю освещает одно направление — суды, технологии, мэрию.",
            example = "As the tech beat reporter, she had three CEOs on speed dial within her first year.",
            exampleNative = "Как beat reporter по технологиям, она к первому году имела трёх гендиректоров на быстром наборе.",
            rarity = "RARE", setId = 471, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "journalism_pro_lexicon", fillInBlankExclusions = listOf(47117L, 47120L)),
        WordEntity(
            id = 47119, original = "Pulitzer", transliteration = "[ˈpʊlɪtsər]", translation = "Пулитцеровская премия",
            definition = "Top American prize for journalism, awarded each year for the best reporting in several categories.",
            definitionNative = "Высшая американская премия в журналистике, вручается ежегодно за лучший репортаж в нескольких номинациях.",
            example = "The team won a Pulitzer for explanatory reporting after eighteen months on the opioid investigation.",
            exampleNative = "Команда взяла Pulitzer за explanatory reporting после восемнадцати месяцев расследования об опиоидах.",
            rarity = "EPIC", setId = 471, languagePair = "en-ru", pos = "noun",
            semanticGroup = "journalism_pro_lexicon"),
        WordEntity(
            id = 47120, original = "on-background", transliteration = "[ɒn ˈbækɡraʊnd]", translation = "на условиях бэкграунда",
            definition = "Source-agreement level where the reporter may quote the information but not name the speaker.",
            definitionNative = "Уровень договорённости с источником: журналист может цитировать сведения, но не называть имя.",
            example = "The official spoke on-background, so the article quotes \"a senior State Department adviser\".",
            exampleNative = "Чиновник говорил on-background, поэтому в статье цитируется «старший советник Госдепартамента».",
            rarity = "EPIC", setId = 471, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "journalism_pro_lexicon", fillInBlankExclusions = listOf(47117L, 47118L)),

        // ── journalism_workflow (workflow и взаимодействие с источниками) ─────
        WordEntity(
            id = 47121, original = "off-the-record", transliteration = "[ˌɒf ðə ˈrɛkɔːrd]", translation = "не для записи",
            definition = "Source-agreement level where nothing the person says can appear in the story in any form.",
            definitionNative = "Уровень договорённости, при котором сказанное не должно появиться в материале ни в каком виде.",
            example = "The senator agreed to talk off-the-record so the reporter could grasp the back story first.",
            exampleNative = "Сенатор согласился говорить off-the-record, чтобы репортёр сначала понял подоплёку.",
            rarity = "RARE", setId = 471, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "journalism_workflow", fillInBlankExclusions = listOf(47123L)),
        WordEntity(
            id = 47122, original = "OSINT", transliteration = "[ˈɒsɪnt]", translation = "OSINT (разведка по открытым источникам)",
            definition = "Practice of building stories from public satellite images, social posts and leaked databases.",
            definitionNative = "Практика собирать материалы из публичных спутниковых снимков, соцпостов и слитых баз.",
            example = "Bellingcat used OSINT to place the missile launcher in eastern Ukraine within hours of the crash.",
            exampleNative = "Bellingcat через OSINT определил позицию пусковой установки на востоке Украины через несколько часов после крушения.",
            rarity = "EPIC", setId = 471, languagePair = "en-ru", pos = "noun",
            semanticGroup = "journalism_workflow", fillInBlankExclusions = listOf(47124L, 47125L)),
        WordEntity(
            id = 47123, original = "wire service", transliteration = "[ˈwaɪər ˈsɜːrvɪs]", translation = "новостное агентство (агрегатор)",
            definition = "Agency such as Reuters or AP that sells fast-moving news copy to many subscribing outlets.",
            definitionNative = "Агентство вроде Reuters или AP, продающее оперативные новости множеству изданий-подписчиков.",
            example = "Smaller papers killed their foreign desks and now run wire service copy on the world page.",
            exampleNative = "Мелкие газеты закрыли иностранные отделы и теперь публикуют wire service-материалы на международной полосе.",
            rarity = "EPIC", setId = 471, languagePair = "en-ru", pos = "phrase",
            semanticGroup = "journalism_workflow", fillInBlankExclusions = listOf(47121L)),
        WordEntity(
            id = 47124, original = "embed", transliteration = "[ɪmˈbɛd]", translation = "приданный журналист (при военных/команде)",
            definition = "Reporter who travels and lives with a military unit or campaign team to cover them from inside.",
            definitionNative = "Репортёр, путешествующий и живущий с воинской частью или штабом кампании, чтобы освещать изнутри.",
            example = "She spent four months as an embed with a Marine battalion in Helmand before filing the longread.",
            exampleNative = "Она провела четыре месяца как embed с батальоном морской пехоты в Гильменде, прежде чем выпустить лонгрид.",
            rarity = "EPIC", setId = 471, languagePair = "en-ru", pos = "noun",
            semanticGroup = "journalism_workflow", fillInBlankExclusions = listOf(47122L)),
        WordEntity(
            id = 47125, original = "fixer", transliteration = "[ˈfɪksər]", translation = "фиксер (местный помощник)",
            definition = "Local contact in a foreign country who arranges interviews, translation and logistics for a reporter.",
            definitionNative = "Местный помощник в чужой стране, организующий интервью, перевод и логистику для репортёра.",
            example = "Without a trusted fixer in Kyiv the correspondent would not have reached the front in two days.",
            exampleNative = "Без надёжного fixer в Киеве корреспондент не добрался бы до фронта за два дня.",
            rarity = "EPIC", setId = 471, languagePair = "en-ru", pos = "noun",
            semanticGroup = "journalism_workflow", fillInBlankExclusions = listOf(47122L, 47124L)),
    )
}
