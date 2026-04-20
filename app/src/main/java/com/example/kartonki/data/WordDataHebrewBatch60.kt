package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrewBatch60 {

    val sets: List<WordSetEntity> get() = listOf(

        WordSetEntity(
            id = 1335, languagePair = "he-ru", orderIndex = 1335,
            name = "Хай-тек: основы 2",
            description = "Собеседование в IT: стек, задачи, оффер",
            topic = "Хай-тек",
            level = 1),

        WordSetEntity(
            id = 1336, languagePair = "he-ru", orderIndex = 1336,
            name = "Маркетинг: основы 2",
            description = "Собеседование в маркетинг: кейсы, метрики, портфолио",
            topic = "Маркетинг",
            level = 1),

        WordSetEntity(
            id = 1337, languagePair = "he-ru", orderIndex = 1337,
            name = "Строительство: основы 2",
            description = "Собеседование на стройку: специальность, опыт, бригада",
            topic = "Строительство",
            level = 1),

        WordSetEntity(
            id = 1338, languagePair = "he-ru", orderIndex = 1338,
            name = "Уход: основы 2",
            description = "Собеседование сиделки: нагрузка, подопечный, смена",
            topic = "Уход",
            level = 1),

        WordSetEntity(
            id = 1339, languagePair = "he-ru", orderIndex = 1339,
            name = "Бухгалтерия: основы 2",
            description = "Собеседование в бухгалтерию: программы, опыт, отчётность",
            topic = "Бухгалтерия",
            level = 1),

        WordSetEntity(
            id = 1340, languagePair = "he-ru", orderIndex = 1340,
            name = "Логистика: основы 2",
            description = "Собеседование в логистику: маршруты, права, склад",
            topic = "Логистика",
            level = 1),

        WordSetEntity(
            id = 1341, languagePair = "he-ru", orderIndex = 1341,
            name = "Риэлтор: основы 3",
            description = "Собеседование риэлтора: лицензия, сделки, база клиентов",
            topic = "Риэлтор",
            level = 1),

        WordSetEntity(
            id = 1342, languagePair = "he-ru", orderIndex = 1342,
            name = "Журналист: основы 2",
            description = "Собеседование журналиста: редакция, материалы, формат",
            topic = "Журналист",
            level = 1),

        WordSetEntity(
            id = 1343, languagePair = "he-ru", orderIndex = 1343,
            name = "Архитектура: основы 2",
            description = "Собеседование архитектора: проекты, программы, чертежи",
            topic = "Архитектура",
            level = 1),
    )

    val words: List<WordEntity> get() = listOf(

        // ── Set 1335: Хай-тек: основы 2 (level=1, COMMON+UNCOMMON) ─────────

        WordEntity(id = 133501, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "רֶזוּמֵה", transliteration = "rezume", translation = "резюме"),

        WordEntity(id = 133502, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "רֵיאָיוֹן עֲבוֹדָה", transliteration = "re'ayon avoda", translation = "собеседование"),

        WordEntity(id = 133503, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "מְגַיֵּס", transliteration = "megayes", translation = "рекрутер"),

        WordEntity(id = 133504, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "הֶצְעַת עֲבוֹדָה", transliteration = "hets'at avoda", translation = "предложение о работе, оффер"),

        WordEntity(id = 133505, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "תְּקוּפַת נִסָּיוֹן", transliteration = "tkufat nisayon", translation = "испытательный срок"),

        WordEntity(id = 133506, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "מַשְׂכּוֹרֶת", transliteration = "maskoret", translation = "зарплата"),

        WordEntity(id = 133507, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "תֶּפְקִיד", transliteration = "tafkid", translation = "должность, роль"),

        WordEntity(id = 133508, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "כִּשּׁוּרִים", transliteration = "kishurim", translation = "навыки, умения"),

        WordEntity(id = 133509, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "נִסָּיוֹן עֲבוֹדָה", transliteration = "nisayon avoda", translation = "опыт работы"),

        WordEntity(id = 133510, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "הַמְלָצָה", transliteration = "hamlitsa", translation = "рекомендация"),

        WordEntity(id = 133511, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "חוֹזֶה עֲבוֹדָה", transliteration = "khoze avoda", translation = "трудовой договор"),

        WordEntity(id = 133512, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "עֲבוֹדָה מֵרָחוֹק", transliteration = "avoda merakhok", translation = "удалённая работа"),

        WordEntity(id = 133513, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "מִשְׁרָה מְלֵאָה", transliteration = "misra mele'a", translation = "полная занятость"),

        WordEntity(id = 133514, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "מִשְׁרָה חֶלְקִית", transliteration = "misra khelkit", translation = "частичная занятость"),

        WordEntity(id = 133515, setId = 1335, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סְטֶק טֶכְנוֹלוֹגִי", transliteration = "stek tekhnologi", translation = "технологический стек"),

        WordEntity(id = 133516, setId = 1335, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פּוֹרְטְפוֹלְיוֹ", transliteration = "portfolio", translation = "портфолио"),

        WordEntity(id = 133517, setId = 1335, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַטְלַת בַּיִת", transliteration = "matla bayit", translation = "тестовое задание (take-home)"),

        WordEntity(id = 133518, setId = 1335, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אַתְגַּר טֶכְנִי", transliteration = "atgar tekhni", translation = "техническое испытание"),

        WordEntity(id = 133519, setId = 1335, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פְּרוֹיֶקְט אִישִׁי", transliteration = "proyek ishi", translation = "личный проект (пет-проект)"),

        WordEntity(id = 133520, setId = 1335, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַנְהֵל צֶוֶת", transliteration = "manhel tsevet", translation = "руководитель команды, тимлид"),

        WordEntity(id = 133521, setId = 1335, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טְוַח שָׂכָר", transliteration = "tvakh sakhar", translation = "зарплатная вилка"),

        WordEntity(id = 133522, setId = 1335, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הֶסְכֵּם סוֹדִיּוּת", transliteration = "heskem sodiut", translation = "соглашение о конфиденциальности (NDA)"),

        WordEntity(id = 133523, setId = 1335, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קְלִיטָה לַעֲבוֹדָה", transliteration = "klita la'avoda", translation = "онбординг, вступление в должность"),

        WordEntity(id = 133524, setId = 1335, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סֶדֶר גִּיּוּס", transliteration = "seder giyus", translation = "процесс найма"),

        WordEntity(id = 133525, setId = 1335, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רֵיאָיוֹן לָבָן", transliteration = "re'ayon lavan", translation = "whiteboard-интервью"),

        // ── Set 1336: Маркетинг: основы 2 (level=1, COMMON+UNCOMMON) ────────

        WordEntity(id = 133601, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "רֶזוּמֵה", transliteration = "rezume", translation = "резюме"),

        WordEntity(id = 133602, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "רֵיאָיוֹן עֲבוֹדָה", transliteration = "re'ayon avoda", translation = "собеседование"),

        WordEntity(id = 133603, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "תִּיק עֲבוֹדוֹת", transliteration = "tik avodot", translation = "портфолио работ"),

        WordEntity(id = 133604, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "נִסָּיוֹן שִׁיוּוּקִי", transliteration = "nisayon shivuki", translation = "маркетинговый опыт"),

        WordEntity(id = 133605, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "מַשְׂכּוֹרֶת", transliteration = "maskoret", translation = "зарплата"),

        WordEntity(id = 133606, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "תֶּפְקִיד שִׁיוּוּקִי", transliteration = "tafkid shivuki", translation = "маркетинговая должность"),

        WordEntity(id = 133607, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "הֶצְעַת עֲבוֹדָה", transliteration = "hets'at avoda", translation = "предложение о работе, оффер"),

        WordEntity(id = 133608, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "כִּשּׁוּרִים", transliteration = "kishurim", translation = "навыки"),

        WordEntity(id = 133609, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "תְּקוּפַת נִסָּיוֹן", transliteration = "tkufat nisayon", translation = "испытательный срок"),

        WordEntity(id = 133610, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "חוֹזֶה עֲבוֹדָה", transliteration = "khoze avoda", translation = "трудовой договор"),

        WordEntity(id = 133611, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "אֵייג'נְסִי", transliteration = "ejnsi", translation = "агентство"),

        WordEntity(id = 133612, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "תַּקְצִיב פִּרְסוּם", transliteration = "taktsiv pirssum", translation = "рекламный бюджет"),

        WordEntity(id = 133613, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "תּוֹצָאוֹת קַמְפֵּיְן", transliteration = "totsa'ot kampein", translation = "результаты кампании"),

        WordEntity(id = 133614, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "הַמְלָצָה", transliteration = "hamlitsa", translation = "рекомендация"),

        WordEntity(id = 133615, setId = 1336, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קֶייס-סְטַאדִי", transliteration = "keys-stadi", translation = "кейс-стади, разбор кейса"),

        WordEntity(id = 133616, setId = 1336, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אֶסְטְרָטֶגְיַת שִׁיוּוּק", transliteration = "estrategiyat shivuk", translation = "маркетинговая стратегия"),

        WordEntity(id = 133617, setId = 1336, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִיצּוּב מוּצָר", transliteration = "mitsub mutsad", translation = "позиционирование продукта"),

        WordEntity(id = 133618, setId = 1336, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מְדַדִּים", transliteration = "medadim", translation = "метрики"),

        WordEntity(id = 133619, setId = 1336, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "כְּלֵי שִׁיוּוּק", transliteration = "kle shivuk", translation = "маркетинговые инструменты"),

        WordEntity(id = 133620, setId = 1336, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שִׁוּוּק תּוֹכֶן", transliteration = "shivuk tokhen", translation = "контент-маркетинг"),

        WordEntity(id = 133621, setId = 1336, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מְנַהֵל מוּצָר", transliteration = "menahel mutsad", translation = "менеджер по продукту"),

        WordEntity(id = 133622, setId = 1336, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גְּדִילָה אוֹרְגָּנִית", transliteration = "gdila organit", translation = "органический рост"),

        WordEntity(id = 133623, setId = 1336, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "דּוּ\"חַ שִׁיוּוּקִי", transliteration = "du'akh shivuki", translation = "маркетинговый отчёт"),

        WordEntity(id = 133624, setId = 1336, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אִינְסַיְטְס", transliteration = "insaits", translation = "инсайты (аналитические выводы)"),

        WordEntity(id = 133625, setId = 1336, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "בְּרִיפ", transliteration = "brif", translation = "бриф, техническое задание"),

        // ── Set 1337: Строительство: основы 2 (level=1, COMMON+UNCOMMON) ────

        WordEntity(id = 133701, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "רֶזוּמֵה", transliteration = "rezume", translation = "резюме"),

        WordEntity(id = 133702, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "רֵיאָיוֹן עֲבוֹדָה", transliteration = "re'ayon avoda", translation = "собеседование"),

        WordEntity(id = 133703, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "מַשְׂכּוֹרֶת", transliteration = "maskoret", translation = "зарплата"),

        WordEntity(id = 133704, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "נִסָּיוֹן בַּנְּיָה", transliteration = "nisayon banya", translation = "опыт в строительстве"),

        WordEntity(id = 133705, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "מִקְצוֹעַ בַּנְּיָה", transliteration = "miktsoa banya", translation = "строительная специальность"),

        WordEntity(id = 133706, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "תְּקוּפַת נִסָּיוֹן", transliteration = "tkufat nisayon", translation = "испытательный срок"),

        WordEntity(id = 133707, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "אֲתַר בַּנְּיָה", transliteration = "atar banya", translation = "строительная площадка"),

        WordEntity(id = 133708, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "פּוֹעֵל בַּנָּיָה", transliteration = "po'el banya", translation = "строительный рабочий"),

        WordEntity(id = 133709, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "צֶוֶת עֲבוֹדָה", transliteration = "tsevet avoda", translation = "рабочая бригада"),

        WordEntity(id = 133710, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "כְּלֵי עֲבוֹדָה", transliteration = "kle avoda", translation = "рабочие инструменты"),

        WordEntity(id = 133711, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "בִּגְדֵי עֲבוֹדָה", transliteration = "bigde avoda", translation = "рабочая одежда, спецовка"),

        WordEntity(id = 133712, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "שָׁעוֹת עֲבוֹדָה", transliteration = "sha'ot avoda", translation = "рабочие часы"),

        WordEntity(id = 133713, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "חוֹזֶה עֲבוֹדָה", transliteration = "khoze avoda", translation = "трудовой договор"),

        WordEntity(id = 133714, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "הַמְלָצָה", transliteration = "hamlitsa", translation = "рекомендация"),

        WordEntity(id = 133715, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "בְּטִיחוּת בְּעֲבוֹדָה", transliteration = "btikhut be'avoda", translation = "безопасность труда"),

        WordEntity(id = 133716, setId = 1337, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תְּעוּדַת מַקְצוֹעַ", transliteration = "te'udat miktsoa", translation = "профессиональное удостоверение"),

        WordEntity(id = 133717, setId = 1337, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רִשָּׁיוֹן עֲבוֹדָה", transliteration = "rishayaon avoda", translation = "разрешение на работу"),

        WordEntity(id = 133718, setId = 1337, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פִּקּוּחַ בַּנְּיָה", transliteration = "pikuakh banya", translation = "строительный надзор"),

        WordEntity(id = 133719, setId = 1337, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תָּכְנִית בַּנְּיָה", transliteration = "takhnit banya", translation = "строительный план, чертёж"),

        WordEntity(id = 133720, setId = 1337, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הֶיתֵּר בַּנְּיָה", transliteration = "heiter banya", translation = "разрешение на строительство"),

        WordEntity(id = 133721, setId = 1337, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סַקְרָן בַּנְּיָה", transliteration = "sakran banya", translation = "строительный инспектор"),

        WordEntity(id = 133722, setId = 1337, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מְפַקֵּחַ עֲבוֹדוֹת", transliteration = "mefake'akh avodot", translation = "мастер работ, прораб"),

        WordEntity(id = 133723, setId = 1337, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עֵרוּב מִשְׂרוֹת", transliteration = "eruv misrot", translation = "совмещение специальностей"),

        WordEntity(id = 133724, setId = 1337, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מְנַהֵל פְּרוֹיֶקְט", transliteration = "menahel proyek", translation = "руководитель проекта"),

        WordEntity(id = 133725, setId = 1337, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַגְשַׁת מִכְרָז", transliteration = "hagashat mikhraz", translation = "подача тендерного предложения"),

        // ── Set 1338: Уход: основы 2 (level=1, COMMON+UNCOMMON) ─────────────

        WordEntity(id = 133801, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "רֶזוּמֵה", transliteration = "rezume", translation = "резюме"),

        WordEntity(id = 133802, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "רֵיאָיוֹן עֲבוֹדָה", transliteration = "re'ayon avoda", translation = "собеседование"),

        WordEntity(id = 133803, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "מַשְׂכּוֹרֶת", transliteration = "maskoret", translation = "зарплата"),

        WordEntity(id = 133804, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "נִסָּיוֹן בְּטִיפּוּל", transliteration = "nisayon betipul", translation = "опыт ухода"),

        WordEntity(id = 133805, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "מִשְׁמֶרֶת", transliteration = "mishmeret", translation = "смена, дежурство"),

        WordEntity(id = 133806, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "לוּחַ תּוֹרָנִיּוֹת", transliteration = "luakh toraniiot", translation = "график дежурств"),

        WordEntity(id = 133807, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "מְטוּפָּל", transliteration = "metupal", translation = "подопечный, пациент"),

        WordEntity(id = 133808, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "מוֹסַד גֶרִיאַטְרִי", transliteration = "mosad geriatri", translation = "дом престарелых"),

        WordEntity(id = 133809, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "סוֹכְנוּת טִיפּוּל", transliteration = "sokhnuyut tipul", translation = "агентство по уходу"),

        WordEntity(id = 133810, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "עֶזְרָה רִאשׁוֹנָה", transliteration = "ezra rishona", translation = "первая помощь"),

        WordEntity(id = 133811, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "לוּחַ זְמַנִּים", transliteration = "luakh zmanim", translation = "расписание"),

        WordEntity(id = 133812, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "הַמְלָצָה", transliteration = "hamlitsa", translation = "рекомендация"),

        WordEntity(id = 133813, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "חוֹזֶה עֲבוֹדָה", transliteration = "khoze avoda", translation = "трудовой договор"),

        WordEntity(id = 133814, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "תְּקוּפַת נִסָּיוֹן", transliteration = "tkufat nisayon", translation = "испытательный срок"),

        WordEntity(id = 133815, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "כִּשּׁוּרֵי טִיפּוּל", transliteration = "kishurey tipul", translation = "навыки ухода"),

        WordEntity(id = 133816, setId = 1338, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תְּעוּדַת הַסְמָכָה", transliteration = "te'udat hasmakha", translation = "сертификат, свидетельство"),

        WordEntity(id = 133817, setId = 1338, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עֹמֶס עֲבוֹדָה", transliteration = "omes avoda", translation = "рабочая нагрузка"),

        WordEntity(id = 133818, setId = 1338, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַצָּב חֵרוּם", transliteration = "matsav kheirum", translation = "экстренная ситуация"),

        WordEntity(id = 133819, setId = 1338, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הֲגָשַׁת תְּרוּפוֹת", transliteration = "hagashat trufot", translation = "выдача медикаментов"),

        WordEntity(id = 133820, setId = 1338, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הֶקְשֵׁר עִם הַמִּשְׁפָּחָה", transliteration = "heksher im hamishpakha", translation = "контакт с семьёй"),

        WordEntity(id = 133821, setId = 1338, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עֲזָרָה בְּנְיִידוּת", transliteration = "azara benei'adut", translation = "помощь при передвижении"),

        WordEntity(id = 133822, setId = 1338, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שְׁמִירַת כָּבוֹד", transliteration = "shmirat kavod", translation = "соблюдение достоинства пациента"),

        WordEntity(id = 133823, setId = 1338, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "דּוּ\"חַ יּוֹמִי", transliteration = "du'akh yomi", translation = "ежедневный отчёт"),

        WordEntity(id = 133824, setId = 1338, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תֶּקֶן טִיפּוּל", transliteration = "taken tipul", translation = "стандарт ухода"),

        WordEntity(id = 133825, setId = 1338, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הֶכְשֵׁר מִקְצוּעִי", transliteration = "heksher miktsui", translation = "профессиональная подготовка"),

        // ── Set 1339: Бухгалтерия: основы 2 (level=1, COMMON+UNCOMMON) ──────

        WordEntity(id = 133901, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "רֶזוּמֵה", transliteration = "rezume", translation = "резюме"),

        WordEntity(id = 133902, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "רֵיאָיוֹן עֲבוֹדָה", transliteration = "re'ayon avoda", translation = "собеседование"),

        WordEntity(id = 133903, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "מַשְׂכּוֹרֶת", transliteration = "maskoret", translation = "зарплата"),

        WordEntity(id = 133904, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "נִסָּיוֹן בְּחֶשְׁבּוֹנַאוּת", transliteration = "nisayon bakheshbonaut", translation = "опыт в бухгалтерии"),

        WordEntity(id = 133905, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "תְּקוּפַת נִסָּיוֹן", transliteration = "tkufat nisayon", translation = "испытательный срок"),

        WordEntity(id = 133906, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "חוֹזֶה עֲבוֹדָה", transliteration = "khoze avoda", translation = "трудовой договор"),

        WordEntity(id = 133907, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "הַמְלָצָה", transliteration = "hamlitsa", translation = "рекомендация"),

        WordEntity(id = 133908, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "כִּשּׁוּרִים", transliteration = "kishurim", translation = "навыки"),

        WordEntity(id = 133909, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "תֶּפְקִיד חֶשְׁבּוֹנַאי", transliteration = "tafkid kheshbonai", translation = "должность бухгалтера"),

        WordEntity(id = 133910, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "חֶשְׁבּוֹנַאי רָאשִׁי", transliteration = "kheshbonai rashi", translation = "главный бухгалтер"),

        WordEntity(id = 133911, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "תֹּכְנַת חֶשְׁבּוֹנַאוּת", transliteration = "tokhnat kheshbonaut", translation = "программа бухучёта"),

        WordEntity(id = 133912, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "גִּלְיוֹן אֶלֶקְטְרוֹנִי", transliteration = "gilyon elektroni", translation = "электронная таблица (Excel)"),

        WordEntity(id = 133913, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "דּוּ\"חַ כַּסְפִּי", transliteration = "du'akh kaspi", translation = "финансовый отчёт"),

        WordEntity(id = 133914, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "תַּקְצִיב", transliteration = "taktsiv", translation = "бюджет"),

        WordEntity(id = 133915, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "הֶצְעַת עֲבוֹדָה", transliteration = "hets'at avoda", translation = "предложение о работе, оффер"),

        WordEntity(id = 133916, setId = 1339, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רוֹאֵה חֶשְׁבּוֹן מוּסְמָךְ", transliteration = "ro'e kheshbon musmakh", translation = "сертифицированный бухгалтер (CPA)"),

        WordEntity(id = 133917, setId = 1339, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "נִהוּל כַּסְפִּים", transliteration = "nihul kaspim", translation = "финансовое управление"),

        WordEntity(id = 133918, setId = 1339, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "דֵּ\"חַ רְבִיעוֹנִי", transliteration = "de'akh revi'oni", translation = "квартальный отчёт"),

        WordEntity(id = 133919, setId = 1339, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַאֲזָן חֶשְׁבּוֹנוֹת", transliteration = "ma'azan kheshbonot", translation = "балансовый отчёт"),

        WordEntity(id = 133920, setId = 1339, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "דֵּ\"חַ רֶוַח וְהֶפְסֵד", transliteration = "de'akh revakh vehefed", translation = "отчёт о прибылях и убытках"),

        WordEntity(id = 133921, setId = 1339, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גַּבִּאות מַס", transliteration = "gabaot mas", translation = "налоговая служба"),

        WordEntity(id = 133922, setId = 1339, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַגְשַׁת דּוּ\"חַ שָׁנָתִי", transliteration = "hagashat du'akh shnati", translation = "подача годового отчёта"),

        WordEntity(id = 133923, setId = 1339, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תְּעוּדַת הַסְמָכָה", transliteration = "te'udat hasmakha", translation = "профессиональный сертификат"),

        WordEntity(id = 133924, setId = 1339, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פְּקִידַת שׂוּם", transliteration = "pkidat sum", translation = "налоговый инспектор"),

        WordEntity(id = 133925, setId = 1339, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סְגִירַת סְפָרִים", transliteration = "sgirat sfarim", translation = "закрытие книг (конец периода)"),

        // ── Set 1340: Логистика: основы 2 (level=1, COMMON+UNCOMMON) ─────────

        WordEntity(id = 134001, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "רֶזוּמֵה", transliteration = "rezume", translation = "резюме"),

        WordEntity(id = 134002, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "רֵיאָיוֹן עֲבוֹדָה", transliteration = "re'ayon avoda", translation = "собеседование"),

        WordEntity(id = 134003, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "מַשְׂכּוֹרֶת", transliteration = "maskoret", translation = "зарплата"),

        WordEntity(id = 134004, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "רִשָּׁיוֹן נְהִיגָה", transliteration = "rishayaon nehiga", translation = "водительские права"),

        WordEntity(id = 134005, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "קְטֶגוֹרִיַּת רִשָּׁיוֹן", transliteration = "kategoriyat rishayaon", translation = "категория водительских прав"),

        WordEntity(id = 134006, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "נִסָּיוֹן נְהִיגָה", transliteration = "nisayon nehiga", translation = "опыт вождения"),

        WordEntity(id = 134007, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "מַסְלוּל מְשְׁלוֹחַ", transliteration = "maslul mishloakh", translation = "маршрут доставки"),

        WordEntity(id = 134008, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "תְּקוּפַת נִסָּיוֹן", transliteration = "tkufat nisayon", translation = "испытательный срок"),

        WordEntity(id = 134009, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "חוֹזֶה עֲבוֹדָה", transliteration = "khoze avoda", translation = "трудовой договор"),

        WordEntity(id = 134010, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "הַמְלָצָה", transliteration = "hamlitsa", translation = "рекомендация"),

        WordEntity(id = 134011, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "שָׁעוֹת עֲבוֹדָה", transliteration = "sha'ot avoda", translation = "рабочие часы"),

        WordEntity(id = 134012, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "מַחְסָן", transliteration = "makhsan", translation = "склад"),

        WordEntity(id = 134013, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "מְשָׁאִית", transliteration = "meshi'it", translation = "грузовик"),

        WordEntity(id = 134014, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "טֹפֶס הַזְמָנָה", transliteration = "toфes hazmana", translation = "бланк заказа"),

        WordEntity(id = 134015, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "הֶצְעַת עֲבוֹדָה", transliteration = "hets'at avoda", translation = "предложение о работе, оффер"),

        WordEntity(id = 134016, setId = 1340, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַפְעִיל עָגוּרָן", transliteration = "maflil aguran", translation = "оператор погрузчика / крановщик"),

        WordEntity(id = 134017, setId = 1340, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַנְהֵל לוֹגִיסְטִיקָה", transliteration = "manhel logistika", translation = "менеджер по логистике"),

        WordEntity(id = 134018, setId = 1340, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "דִּיסְפֶּטְשֶׁר", transliteration = "dispetsher", translation = "диспетчер"),

        WordEntity(id = 134019, setId = 1340, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַעֲקַב מִשְׁלוֹחַ", transliteration = "ma'akav mishloakh", translation = "отслеживание груза"),

        WordEntity(id = 134020, setId = 1340, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אַחְרָיוּת בִּיטּוּחַ", transliteration = "akhraiut bituakh", translation = "страховая ответственность"),

        WordEntity(id = 134021, setId = 1340, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אִי-עֲמִידָה בְּמַסְלוּל", transliteration = "i-amida bemaslul", translation = "отклонение от маршрута"),

        WordEntity(id = 134022, setId = 1340, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אִי-עֲמִידָה בִּזְמַן", transliteration = "i-amida bizman", translation = "нарушение сроков доставки"),

        WordEntity(id = 134023, setId = 1340, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "בְּדִיקַת רֶכֶב", transliteration = "bdikat rekhev", translation = "технический осмотр автомобиля"),

        WordEntity(id = 134024, setId = 1340, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תְּנַאֵי הֲסָעָה", transliteration = "tnae hasa'a", translation = "условия перевозки"),

        WordEntity(id = 134025, setId = 1340, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "כִּשּׁוּרִים לוֹגִיסְטִיִּים", transliteration = "kishurim logistiim", translation = "логистические навыки"),

        // ── Set 1341: Риэлтор: основы 3 (level=1, COMMON+UNCOMMON) ──────────

        WordEntity(id = 134101, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "רֶזוּמֵה", transliteration = "rezume", translation = "резюме"),

        WordEntity(id = 134102, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "רֵיאָיוֹן עֲבוֹדָה", transliteration = "re'ayon avoda", translation = "собеседование"),

        WordEntity(id = 134103, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "מַשְׂכּוֹרֶת", transliteration = "maskoret", translation = "зарплата"),

        WordEntity(id = 134104, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "עַמְלָה", transliteration = "amla", translation = "комиссионные, процент от сделки"),

        WordEntity(id = 134105, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "נִסָּיוֹן בְּתִיוּוּךְ", transliteration = "nisayon betivukh", translation = "опыт в риэлторстве"),

        WordEntity(id = 134106, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "תְּקוּפַת נִסָּיוֹן", transliteration = "tkufat nisayon", translation = "испытательный срок"),

        WordEntity(id = 134107, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "חוֹזֶה עֲבוֹדָה", transliteration = "khoze avoda", translation = "трудовой договор"),

        WordEntity(id = 134108, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "הַמְלָצָה", transliteration = "hamlitsa", translation = "рекомендация"),

        WordEntity(id = 134109, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "מַאֲגַר לְקוֹחוֹת", transliteration = "ma'agar lekukhot", translation = "база клиентов"),

        WordEntity(id = 134110, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "הַצָּגַת נְכָס", transliteration = "hatsagat nakhas", translation = "показ объекта"),

        WordEntity(id = 134111, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "מִשָּׂא וּמַתָּן", transliteration = "masa umatan", translation = "переговоры"),

        WordEntity(id = 134112, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "הֶצְעַת עֲבוֹדָה", transliteration = "hets'at avoda", translation = "предложение о работе, оффер"),

        WordEntity(id = 134113, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "כִּשּׁוּרֵי מֶכֶר", transliteration = "kishurey mekher", translation = "навыки продаж"),

        WordEntity(id = 134114, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "הִיכָּרוּת עִם הַשּׁוּק", transliteration = "hikharut im hashuk", translation = "знание рынка"),

        WordEntity(id = 134115, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "שִׁיחַ קַר", transliteration = "siakh kar", translation = "холодный звонок"),

        WordEntity(id = 134116, setId = 1341, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רִשָּׁיוֹן מְתִיוּוּךְ", transliteration = "rishayaon metivukh", translation = "лицензия риэлтора"),

        WordEntity(id = 134117, setId = 1341, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הֶסְכֵּם שְׂכִירוּת", transliteration = "heskem skhirut", translation = "договор аренды"),

        WordEntity(id = 134118, setId = 1341, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַעֲרָכַת שֵׁווּי", transliteration = "ha'arakat shevui", translation = "оценка стоимости объекта"),

        WordEntity(id = 134119, setId = 1341, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חֲלוּקַת עַמְלָה", transliteration = "khalukat amla", translation = "раздел комиссионных"),

        WordEntity(id = 134120, setId = 1341, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רִישׁוּם בְּטַאבּוּ", transliteration = "rishum betabu", translation = "регистрация в земельном реестре (тabu)"),

        WordEntity(id = 134121, setId = 1341, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "בּוֹנוּס מֶכֶר", transliteration = "bonus mekher", translation = "бонус за сделку"),

        WordEntity(id = 134122, setId = 1341, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "כְּנַסַת בַּיִת פְּתוּחָה", transliteration = "knisat bayit ptuha", translation = "открытый показ (open house)"),

        WordEntity(id = 134123, setId = 1341, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִשְׂרַד תִּיוּוּךְ", transliteration = "misrad tivukh", translation = "риэлторское агентство"),

        WordEntity(id = 134124, setId = 1341, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פּוּנֵל לְקוֹחוֹת", transliteration = "funel lekukhot", translation = "воронка клиентов"),

        WordEntity(id = 134125, setId = 1341, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַנְהֵל תִּיקִים", transliteration = "manhel tikim", translation = "управляющий портфелем объектов"),

        // ── Set 1342: Журналист: основы 2 (level=1, COMMON+UNCOMMON) ─────────

        WordEntity(id = 134201, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "רֶזוּמֵה", transliteration = "rezume", translation = "резюме"),

        WordEntity(id = 134202, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "רֵיאָיוֹן עֲבוֹדָה", transliteration = "re'ayon avoda", translation = "собеседование"),

        WordEntity(id = 134203, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "מַשְׂכּוֹרֶת", transliteration = "maskoret", translation = "зарплата"),

        WordEntity(id = 134204, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "תִּיק עֲבוֹדוֹת", transliteration = "tik avodot", translation = "портфолио публикаций"),

        WordEntity(id = 134205, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "נִסָּיוֹן בְּעִיתוֹנַאוּת", transliteration = "nisayon beitonaut", translation = "опыт в журналистике"),

        WordEntity(id = 134206, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "תְּקוּפַת נִסָּיוֹן", transliteration = "tkufat nisayon", translation = "испытательный срок"),

        WordEntity(id = 134207, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "חוֹזֶה עֲבוֹדָה", transliteration = "khoze avoda", translation = "трудовой договор"),

        WordEntity(id = 134208, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "הַמְלָצָה", transliteration = "hamlitsa", translation = "рекомендация"),

        WordEntity(id = 134209, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "עוֹרֵךְ", transliteration = "orekh", translation = "редактор"),

        WordEntity(id = 134210, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "עוֹרֵךְ רָאשִׁי", transliteration = "orekh rashi", translation = "главный редактор"),

        WordEntity(id = 134211, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "מַעֲרֶכֶת עִיתּוֹן", transliteration = "ma'arekhet iton", translation = "редакция газеты"),

        WordEntity(id = 134212, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "כְּתַב עֵת", transliteration = "ktav et", translation = "журнал, периодическое издание"),

        WordEntity(id = 134213, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "הֶצְעַת עֲבוֹדָה", transliteration = "hets'at avoda", translation = "предложение о работе, оффер"),

        WordEntity(id = 134214, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "כְּתָבוֹת לְדוּגְמָה", transliteration = "ktavot ledugma", translation = "примеры публикаций / статей"),

        WordEntity(id = 134215, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "תְּחוּם הִתְמַחֻיּוּת", transliteration = "tkhum hitmakhiut", translation = "область специализации"),

        WordEntity(id = 134216, setId = 1342, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עִיתוֹנַאי עַצְמָאִי", transliteration = "itonai atsmay", translation = "независимый журналист, фрилансер"),

        WordEntity(id = 134217, setId = 1342, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שְׂכַר טִרְחָה", transliteration = "skhar tirkha", translation = "гонорар"),

        WordEntity(id = 134218, setId = 1342, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "בְּדִיקַת עוּבְדוֹת", transliteration = "bdikat uvdot", translation = "проверка фактов (fact-checking)"),

        WordEntity(id = 134219, setId = 1342, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "נוֹשֵׂא כְּתָבָה", transliteration = "nose ktava", translation = "тема материала / статьи"),

        WordEntity(id = 134220, setId = 1342, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פּוֹרְמַט תּוֹכֶן", transliteration = "format tokhen", translation = "формат контента"),

        WordEntity(id = 134221, setId = 1342, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תַּדְרִיךְ עִיתוֹנַאי", transliteration = "tadrikH itonai", translation = "брифинг для прессы"),

        WordEntity(id = 134222, setId = 1342, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "כִּיסּוּי אֲזוֹרִי", transliteration = "kisuy azori", translation = "региональное освещение событий"),

        WordEntity(id = 134223, setId = 1342, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רְשׁוּת שִׁדּוּר", transliteration = "reshut shidur", translation = "вещательная корпорация"),

        WordEntity(id = 134224, setId = 1342, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עֲבוֹדַת שֶׂדֶה", transliteration = "avodat sade", translation = "репортаж с места событий"),

        WordEntity(id = 134225, setId = 1342, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "זְכוּיּוֹת יוֹצְרִים", transliteration = "zkhuyot yotsrim", translation = "авторские права"),

        // ── Set 1343: Архитектура: основы 2 (level=1, COMMON+UNCOMMON) ───────

        WordEntity(id = 134301, setId = 1343, languagePair = "he-ru", rarity = "COMMON",
            original = "רֶזוּמֵה", transliteration = "rezume", translation = "резюме"),

        WordEntity(id = 134302, setId = 1343, languagePair = "he-ru", rarity = "COMMON",
            original = "רֵיאָיוֹן עֲבוֹדָה", transliteration = "re'ayon avoda", translation = "собеседование"),

        WordEntity(id = 134303, setId = 1343, languagePair = "he-ru", rarity = "COMMON",
            original = "מַשְׂכּוֹרֶת", transliteration = "maskoret", translation = "зарплата"),

        WordEntity(id = 134304, setId = 1343, languagePair = "he-ru", rarity = "COMMON",
            original = "תִּיק עֲבוֹדוֹת", transliteration = "tik avodot", translation = "портфолио проектов"),

        WordEntity(id = 134305, setId = 1343, languagePair = "he-ru", rarity = "COMMON",
            original = "נִסָּיוֹן בְּאַרְכִיטֶקְטוּרָה", transliteration = "nisayon bearhitektura", translation = "опыт в архитектуре"),

        WordEntity(id = 134306, setId = 1343, languagePair = "he-ru", rarity = "COMMON",
            original = "תְּקוּפַת נִסָּיוֹן", transliteration = "tkufat nisayon", translation = "испытательный срок"),

        WordEntity(id = 134307, setId = 1343, languagePair = "he-ru", rarity = "COMMON",
            original = "חוֹזֶה עֲבוֹדָה", transliteration = "khoze avoda", translation = "трудовой договор"),

        WordEntity(id = 134308, setId = 1343, languagePair = "he-ru", rarity = "COMMON",
            original = "הַמְלָצָה", transliteration = "hamlitsa", translation = "рекомендация"),

        WordEntity(id = 134309, setId = 1343, languagePair = "he-ru", rarity = "COMMON",
            original = "תָּכְנִית מִגְרָשׁ", transliteration = "takhnit migras", translation = "план участка / генплан"),

        WordEntity(id = 134310, setId = 1343, languagePair = "he-ru", rarity = "COMMON",
            original = "תֶּפְקִיד אַרְכִיטֶקְט", transliteration = "tafkid arkhitekt", translation = "должность архитектора"),

        WordEntity(id = 134311, setId = 1343, languagePair = "he-ru", rarity = "COMMON",
            original = "הֶצְעַת עֲבוֹדָה", transliteration = "hets'at avoda", translation = "предложение о работе, оффер"),

        WordEntity(id = 134312, setId = 1343, languagePair = "he-ru", rarity = "COMMON",
            original = "מִשְׂרַד אַרְכִיטֶקְטִים", transliteration = "misrad arkhitekтim", translation = "архитектурное бюро"),

        WordEntity(id = 134313, setId = 1343, languagePair = "he-ru", rarity = "COMMON",
            original = "לְקוֹחַ", transliteration = "lekoakh", translation = "клиент"),

        WordEntity(id = 134314, setId = 1343, languagePair = "he-ru", rarity = "COMMON",
            original = "פְּגִישַׁת הִיכָּרוּת", transliteration = "pgishat hikharut", translation = "знакомственная встреча"),

        WordEntity(id = 134315, setId = 1343, languagePair = "he-ru", rarity = "COMMON",
            original = "כִּשּׁוּרִים טֶכְנִיִּים", transliteration = "kishurim tekhniim", translation = "технические навыки"),

        WordEntity(id = 134316, setId = 1343, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רִשָּׁיוֹן אַרְכִיטֶקְט", transliteration = "rishayaon arkhitekt", translation = "лицензия архитектора"),

        WordEntity(id = 134317, setId = 1343, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תֹּכְנַת CAD", transliteration = "tokhnat CAD", translation = "программа CAD (AutoCAD)"),

        WordEntity(id = 134318, setId = 1343, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מוֹדֵל BIM", transliteration = "model BIM", translation = "BIM-модель"),

        WordEntity(id = 134319, setId = 1343, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תַּקְנוֹת בִּנְיָן", transliteration = "takanot binyan", translation = "строительные нормы"),

        WordEntity(id = 134320, setId = 1343, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אִישּׁוּר תָּכְנִית", transliteration = "ishur takhnit", translation = "согласование проекта"),

        WordEntity(id = 134321, setId = 1343, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תַּחֲרוּת עִיצּוּב", transliteration = "takharut itsub", translation = "архитектурный конкурс"),

        WordEntity(id = 134322, setId = 1343, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פִּיקּוּחַ מְחַבֵּר", transliteration = "pikuakh mekhaber", translation = "авторский надзор"),

        WordEntity(id = 134323, setId = 1343, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תַּכְנִית פָּנִים", transliteration = "takhnit panim", translation = "план интерьера"),

        WordEntity(id = 134324, setId = 1343, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סִפְרוּן אַרְכִיטֶקְטוּרִי", transliteration = "siфrun arkhitekturi", translation = "архитектурный буклет / концептбук"),

        WordEntity(id = 134325, setId = 1343, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אֶסְתֶּטִיקָה אַרְכִיטֶקְטוּרִית", transliteration = "estetika arkhitekturit", translation = "архитектурная эстетика"),
    )
}
