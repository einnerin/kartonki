package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrewBatch60 {

    val sets: List<WordSetEntity> get() = listOf(

        WordSetEntity(
            id = 1335, languagePair = "he-ru", orderIndex = 1335,
            name = "Хайтек",
            description = "Стек, задачи, оффер",
            topic = "Хайтек",
            level = 1),

        WordSetEntity(
            id = 1336, languagePair = "he-ru", orderIndex = 1336,
            name = "Маркетинг",
            description = "Кейсы, метрики, портфолио",
            topic = "Маркетинг",
            level = 1),

        WordSetEntity(
            id = 1337, languagePair = "he-ru", orderIndex = 1337,
            name = "Стройка и работа строителем",
            description = "Специальность, опыт, бригада",
            topic = "Стройка и работа строителем",
            level = 1),

        WordSetEntity(
            id = 1338, languagePair = "he-ru", orderIndex = 1338,
            name = "Уход за пожилыми и работа сиделкой",
            description = "Нагрузка, подопечный, смена",
            topic = "Уход за пожилыми и работа сиделкой",
            level = 1),

        WordSetEntity(
            id = 1339, languagePair = "he-ru", orderIndex = 1339,
            name = "Учёт и работа бухгалтером",
            description = "Программы, опыт, отчётность",
            topic = "Учёт и работа бухгалтером",
            level = 1),

        WordSetEntity(
            id = 1340, languagePair = "he-ru", orderIndex = 1340,
            name = "Склад и работа логистом",
            description = "Маршруты, права, склад",
            topic = "Склад и работа логистом",
            level = 1),

        WordSetEntity(
            id = 1341, languagePair = "he-ru", orderIndex = 1341,
            name = "Риэлтор",
            description = "Лицензия, сделки, база клиентов",
            topic = "Риэлтор",
            level = 1),

        WordSetEntity(
            id = 1342, languagePair = "he-ru", orderIndex = 1342,
            name = "Журналист",
            description = "Редакция, материалы, формат",
            topic = "Журналист",
            level = 1),

    )

    val words: List<WordEntity> get() = listOf(

        // ── Set 1335: Хайтек: основы 2 (level=1, COMMON+UNCOMMON) ─────────

        WordEntity(id = 133501, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "רֶזוּמֵה", translation = "резюме"),

        WordEntity(id = 133502, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "רֵיאָיוֹן עֲבוֹדָה", translation = "собеседование"),

        WordEntity(id = 133503, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "מְגַיֵּס", translation = "рекрутер"),

        WordEntity(id = 133504, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "הֶצְעַת עֲבוֹדָה", translation = "предложение о работе, оффер"),

        WordEntity(id = 133505, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "תְּקוּפַת נִסָּיוֹן", translation = "испытательный срок"),

        WordEntity(id = 133506, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "מַשְׂכּוֹרֶת", translation = "зарплата"),

        WordEntity(id = 133507, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "תַּפְקִיד", translation = "должность, роль"),

        WordEntity(id = 133508, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "כִּשּׁוּרִים", translation = "навыки, умения"),

        WordEntity(id = 133509, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "נִסָּיוֹן עֲבוֹדָה", translation = "опыт работы"),

        WordEntity(id = 133510, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "הַמְלָצָה", translation = "рекомендация"),

        WordEntity(id = 133511, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "חוֹזֶה עֲבוֹדָה", translation = "трудовой договор"),

        WordEntity(id = 133512, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "עֲבוֹדָה מֵרָחוֹק", translation = "удалённая работа"),

        WordEntity(id = 133513, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "מִשְׁרָה מְלֵאָה", translation = "полная занятость"),

        WordEntity(id = 133514, setId = 1335, languagePair = "he-ru", rarity = "COMMON",
            original = "מִשְׁרָה חֶלְקִית", translation = "частичная занятость"),

        WordEntity(id = 133515, setId = 1335, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סְטֶק טֶכְנוֹלוֹגִי", translation = "технологический стек"),

        WordEntity(id = 133516, setId = 1335, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פּוֹרְטְפוֹלְיוֹ", translation = "портфолио"),

        WordEntity(id = 133517, setId = 1335, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַטְלַת בַּיִת", translation = "тестовое задание (take-home)"),

        WordEntity(id = 133518, setId = 1335, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אַתְגַּר טֶכְנִי", translation = "техническое испытание"),

        WordEntity(id = 133519, setId = 1335, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פְּרוֹיֶקְט אִישִׁי", translation = "личный проект (пет-проект)"),

        WordEntity(id = 133520, setId = 1335, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַנְהֵל צֶוֶת", translation = "руководитель команды, тимлид"),

        WordEntity(id = 133521, setId = 1335, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טְוַח שָׂכָר", translation = "зарплатная вилка"),

        WordEntity(id = 133522, setId = 1335, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הֶסְכֵּם סוֹדִיּוּת", translation = "соглашение о конфиденциальности (NDA)"),

        WordEntity(id = 133523, setId = 1335, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קְלִיטָה לַעֲבוֹדָה", translation = "онбординг, вступление в должность"),

        WordEntity(id = 133524, setId = 1335, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סֶדֶר גִּיּוּס", translation = "процесс найма"),

        WordEntity(id = 133525, setId = 1335, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רֵיאָיוֹן לָבָן", translation = "whiteboard-интервью"),

        // ── Set 1336: Маркетинг: основы 2 (level=1, COMMON+UNCOMMON) ────────

        WordEntity(id = 133601, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "רֶזוּמֵה", translation = "резюме"),

        WordEntity(id = 133602, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "רֵיאָיוֹן עֲבוֹדָה", translation = "собеседование"),

        WordEntity(id = 133603, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "תִּיק עֲבוֹדוֹת", translation = "портфолио работ"),

        WordEntity(id = 133604, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "נִסָּיוֹן שִׁיוּוּקִי", translation = "маркетинговый опыт"),

        WordEntity(id = 133605, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "מַשְׂכּוֹרֶת", translation = "зарплата"),

        WordEntity(id = 133606, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "תֶּפְקִיד שִׁיוּוּקִי", translation = "маркетинговая должность"),

        WordEntity(id = 133607, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "הֶצְעַת עֲבוֹדָה", translation = "предложение о работе, оффер"),

        WordEntity(id = 133608, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "כִּשּׁוּרִים", translation = "навыки"),

        WordEntity(id = 133609, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "תְּקוּפַת נִסָּיוֹן", translation = "испытательный срок"),

        WordEntity(id = 133610, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "חוֹזֶה עֲבוֹדָה", translation = "трудовой договор"),

        WordEntity(id = 133611, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "אֵייג'נְסִי", translation = "агентство"),

        WordEntity(id = 133612, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "תַּקְצִיב פִּרְסוּם", translation = "рекламный бюджет"),

        WordEntity(id = 133613, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "תּוֹצָאוֹת קַמְפֵּיְן", translation = "результаты кампании"),

        WordEntity(id = 133614, setId = 1336, languagePair = "he-ru", rarity = "COMMON",
            original = "הַמְלָצָה", translation = "рекомендация"),

        WordEntity(id = 133615, setId = 1336, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קֶייס-סְטַאדִי", translation = "кейс-стади, разбор кейса"),

        WordEntity(id = 133616, setId = 1336, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אֶסְטְרָטֶגְיַת שִׁיוּוּק", translation = "маркетинговая стратегия"),

        WordEntity(id = 133617, setId = 1336, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִיצּוּב מוּצָר", translation = "позиционирование продукта"),

        WordEntity(id = 133618, setId = 1336, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מְדַדִּים", translation = "метрики"),

        WordEntity(id = 133619, setId = 1336, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "כְּלֵי שִׁיוּוּק", translation = "маркетинговые инструменты"),

        WordEntity(id = 133620, setId = 1336, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שִׁוּוּק תּוֹכֶן", translation = "контент-маркетинг"),

        WordEntity(id = 133621, setId = 1336, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מְנַהֵל מוּצָר", translation = "менеджер по продукту"),

        WordEntity(id = 133622, setId = 1336, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גְּדִילָה אוֹרְגָּנִית", translation = "органический рост"),

        WordEntity(id = 133623, setId = 1336, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "דּוּ\"חַ שִׁיוּוּקִי", translation = "маркетинговый отчёт"),

        WordEntity(id = 133624, setId = 1336, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אִינְסַיְטְס", translation = "инсайты (аналитические выводы)"),

        WordEntity(id = 133625, setId = 1336, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "בְּרִיפ", translation = "бриф, техническое задание"),

        // ── Set 1337: Строительство: основы 2 (level=1, COMMON+UNCOMMON) ────

        WordEntity(id = 133701, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "רֶזוּמֵה", translation = "резюме"),

        WordEntity(id = 133702, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "רֵיאָיוֹן עֲבוֹדָה", translation = "собеседование"),

        WordEntity(id = 133703, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "מַשְׂכּוֹרֶת", translation = "зарплата"),

        WordEntity(id = 133704, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "נִסָּיוֹן בַּנְּיָה", translation = "опыт в строительстве"),

        WordEntity(id = 133705, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "מִקְצוֹעַ בַּנְּיָה", translation = "строительная специальность"),

        WordEntity(id = 133706, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "תְּקוּפַת נִסָּיוֹן", translation = "испытательный срок"),

        WordEntity(id = 133707, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "אֲתַר בַּנְּיָה", translation = "строительная площадка"),

        WordEntity(id = 133708, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "פּוֹעֵל בַּנָּיָה", translation = "строительный рабочий"),

        WordEntity(id = 133709, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "צֶוֶת עֲבוֹדָה", translation = "рабочая бригада"),

        WordEntity(id = 133710, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "כְּלֵי עֲבוֹדָה", translation = "рабочие инструменты"),

        WordEntity(id = 133711, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "בִּגְדֵי עֲבוֹדָה", translation = "рабочая одежда, спецовка"),

        WordEntity(id = 133712, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "שָׁעוֹת עֲבוֹדָה", translation = "рабочие часы"),

        WordEntity(id = 133713, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "חוֹזֶה עֲבוֹדָה", translation = "трудовой договор"),

        WordEntity(id = 133714, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "הַמְלָצָה", translation = "рекомендация"),

        WordEntity(id = 133715, setId = 1337, languagePair = "he-ru", rarity = "COMMON",
            original = "בְּטִיחוּת בְּעֲבוֹדָה", translation = "безопасность труда"),

        WordEntity(id = 133716, setId = 1337, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תְּעוּדַת מַקְצוֹעַ", translation = "профессиональное удостоверение"),

        WordEntity(id = 133717, setId = 1337, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רִשָּׁיוֹן עֲבוֹדָה", translation = "разрешение на работу"),

        WordEntity(id = 133718, setId = 1337, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פִּקּוּחַ בַּנְּיָה", translation = "строительный надзор"),

        WordEntity(id = 133719, setId = 1337, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תָּכְנִית בַּנְּיָה", translation = "строительный план, чертёж"),

        WordEntity(id = 133720, setId = 1337, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הֶיתֵּר בַּנְּיָה", translation = "разрешение на строительство"),

        WordEntity(id = 133721, setId = 1337, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סַקְרָן בַּנְּיָה", translation = "строительный инспектор"),

        WordEntity(id = 133722, setId = 1337, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מְפַקֵּחַ עֲבוֹדוֹת", translation = "мастер работ, прораб"),

        WordEntity(id = 133723, setId = 1337, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עֵרוּב מִשְׂרוֹת", translation = "совмещение специальностей"),

        WordEntity(id = 133724, setId = 1337, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מְנַהֵל פְּרוֹיֶקְט", translation = "руководитель проекта"),

        WordEntity(id = 133725, setId = 1337, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַגְשַׁת מִכְרָז", translation = "подача тендерного предложения"),

        // ── Set 1338: Уход: основы 2 (level=1, COMMON+UNCOMMON) ─────────────

        WordEntity(id = 133801, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "רֶזוּמֵה", translation = "резюме"),

        WordEntity(id = 133802, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "רֵיאָיוֹן עֲבוֹדָה", translation = "собеседование"),

        WordEntity(id = 133803, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "מַשְׂכּוֹרֶת", translation = "зарплата"),

        WordEntity(id = 133804, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "נִסָּיוֹן בְּטִיפּוּל", translation = "опыт ухода"),

        WordEntity(id = 133805, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "מִשְׁמֶרֶת", translation = "смена, дежурство"),

        WordEntity(id = 133806, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "לוּחַ תּוֹרָנִיּוֹת", translation = "график дежурств"),

        WordEntity(id = 133807, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "מְטוּפָּל", translation = "подопечный, пациент"),

        WordEntity(id = 133808, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "מוֹסַד גֶרִיאַטְרִי", translation = "дом престарелых"),

        WordEntity(id = 133809, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "סוֹכְנוּת טִיפּוּל", translation = "агентство по уходу"),

        WordEntity(id = 133810, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "עֶזְרָה רִאשׁוֹנָה", translation = "первая помощь"),

        WordEntity(id = 133811, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "לוּחַ זְמַנִּים", translation = "расписание"),

        WordEntity(id = 133812, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "הַמְלָצָה", translation = "рекомендация"),

        WordEntity(id = 133813, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "חוֹזֶה עֲבוֹדָה", translation = "трудовой договор"),

        WordEntity(id = 133814, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "תְּקוּפַת נִסָּיוֹן", translation = "испытательный срок"),

        WordEntity(id = 133815, setId = 1338, languagePair = "he-ru", rarity = "COMMON",
            original = "כִּשּׁוּרֵי טִיפּוּל", translation = "навыки ухода"),

        WordEntity(id = 133816, setId = 1338, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תְּעוּדַת הַסְמָכָה", translation = "сертификат, свидетельство"),

        WordEntity(id = 133817, setId = 1338, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עֹמֶס עֲבוֹדָה", translation = "рабочая нагрузка"),

        WordEntity(id = 133818, setId = 1338, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַצָּב חֵרוּם", translation = "экстренная ситуация"),

        WordEntity(id = 133819, setId = 1338, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הֲגָשַׁת תְּרוּפוֹת", translation = "выдача медикаментов"),

        WordEntity(id = 133820, setId = 1338, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הֶקְשֵׁר עִם הַמִּשְׁפָּחָה", translation = "контакт с семьёй"),

        WordEntity(id = 133821, setId = 1338, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עֲזָרָה בְּנְיִידוּת", translation = "помощь при передвижении"),

        WordEntity(id = 133822, setId = 1338, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שְׁמִירַת כָּבוֹד", translation = "соблюдение достоинства пациента"),

        WordEntity(id = 133823, setId = 1338, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "דּוּ\"חַ יּוֹמִי", translation = "ежедневный отчёт"),

        WordEntity(id = 133824, setId = 1338, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תֶּקֶן טִיפּוּל", translation = "стандарт ухода"),

        WordEntity(id = 133825, setId = 1338, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הֶכְשֵׁר מִקְצוּעִי", translation = "профессиональная подготовка"),

        // ── Set 1339: Бухгалтерия: основы 2 (level=1, COMMON+UNCOMMON) ──────

        WordEntity(id = 133901, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "רֶזוּמֵה", translation = "резюме"),

        WordEntity(id = 133902, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "רֵיאָיוֹן עֲבוֹדָה", translation = "собеседование"),

        WordEntity(id = 133903, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "מַשְׂכּוֹרֶת", translation = "зарплата"),

        WordEntity(id = 133904, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "נִסָּיוֹן בְּחֶשְׁבּוֹנַאוּת", translation = "опыт в бухгалтерии"),

        WordEntity(id = 133905, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "תְּקוּפַת נִסָּיוֹן", translation = "испытательный срок"),

        WordEntity(id = 133906, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "חוֹזֶה עֲבוֹדָה", translation = "трудовой договор"),

        WordEntity(id = 133907, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "הַמְלָצָה", translation = "рекомендация"),

        WordEntity(id = 133908, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "כִּשּׁוּרִים", translation = "навыки"),

        WordEntity(id = 133909, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "תֶּפְקִיד חֶשְׁבּוֹנַאי", translation = "должность бухгалтера"),

        WordEntity(id = 133910, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "חֶשְׁבּוֹנַאי רָאשִׁי", translation = "главный бухгалтер"),

        WordEntity(id = 133911, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "תֹּכְנַת חֶשְׁבּוֹנַאוּת", translation = "программа бухучёта"),

        WordEntity(id = 133912, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "גִּלְיוֹן אֶלֶקְטְרוֹנִי", translation = "электронная таблица (Excel)"),

        WordEntity(id = 133913, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "דּוּ\"חַ כַּסְפִּי", translation = "финансовый отчёт"),

        WordEntity(id = 133914, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "תַּקְצִיב", translation = "бюджет"),

        WordEntity(id = 133915, setId = 1339, languagePair = "he-ru", rarity = "COMMON",
            original = "הֶצְעַת עֲבוֹדָה", translation = "предложение о работе, оффер"),

        WordEntity(id = 133916, setId = 1339, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רוֹאֵה חֶשְׁבּוֹן מוּסְמָךְ", translation = "сертифицированный бухгалтер (CPA)"),

        WordEntity(id = 133917, setId = 1339, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "נִהוּל כַּסְפִּים", translation = "финансовое управление"),

        WordEntity(id = 133918, setId = 1339, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "דֵּ\"חַ רְבִיעוֹנִי", translation = "квартальный отчёт"),

        WordEntity(id = 133919, setId = 1339, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַאֲזָן חֶשְׁבּוֹנוֹת", translation = "балансовый отчёт"),

        WordEntity(id = 133920, setId = 1339, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "דֵּ\"חַ רֶוַח וְהֶפְסֵד", translation = "отчёт о прибылях и убытках"),

        WordEntity(id = 133921, setId = 1339, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גַּבִּאות מַס", translation = "налоговая служба"),

        WordEntity(id = 133922, setId = 1339, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַגְשַׁת דּוּ\"חַ שָׁנָתִי", translation = "подача годового отчёта"),

        WordEntity(id = 133923, setId = 1339, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תְּעוּדַת הַסְמָכָה", translation = "профессиональный сертификат"),

        WordEntity(id = 133924, setId = 1339, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פְּקִידַת שׂוּם", translation = "налоговый инспектор"),

        WordEntity(id = 133925, setId = 1339, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סְגִירַת סְפָרִים", translation = "закрытие книг (конец периода)"),

        // ── Set 1340: Логистика: основы 2 (level=1, COMMON+UNCOMMON) ─────────

        WordEntity(id = 134001, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "רֶזוּמֵה", translation = "резюме"),

        WordEntity(id = 134002, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "רֵיאָיוֹן עֲבוֹדָה", translation = "собеседование"),

        WordEntity(id = 134003, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "מַשְׂכּוֹרֶת", translation = "зарплата"),

        WordEntity(id = 134004, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "רִשָּׁיוֹן נְהִיגָה", translation = "водительские права"),

        WordEntity(id = 134005, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "קְטֶגוֹרִיַּת רִשָּׁיוֹן", translation = "категория водительских прав"),

        WordEntity(id = 134006, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "נִסָּיוֹן נְהִיגָה", translation = "опыт вождения"),

        WordEntity(id = 134007, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "מַסְלוּל מְשְׁלוֹחַ", translation = "маршрут доставки"),

        WordEntity(id = 134008, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "תְּקוּפַת נִסָּיוֹן", translation = "испытательный срок"),

        WordEntity(id = 134009, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "חוֹזֶה עֲבוֹדָה", translation = "трудовой договор"),

        WordEntity(id = 134010, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "הַמְלָצָה", translation = "рекомендация"),

        WordEntity(id = 134011, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "שָׁעוֹת עֲבוֹדָה", translation = "рабочие часы"),

        WordEntity(id = 134012, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "מַחְסָן", translation = "склад"),

        WordEntity(id = 134013, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "מַשָּׂאִית", translation = "грузовик"),

        WordEntity(id = 134014, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "טֹפֶס הַזְמָנָה", translation = "бланк заказа"),

        WordEntity(id = 134015, setId = 1340, languagePair = "he-ru", rarity = "COMMON",
            original = "הֶצְעַת עֲבוֹדָה", translation = "предложение о работе, оффер"),

        WordEntity(id = 134016, setId = 1340, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַפְעִיל עָגוּרָן", translation = "оператор погрузчика / крановщик"),

        WordEntity(id = 134017, setId = 1340, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַנְהֵל לוֹגִיסְטִיקָה", translation = "менеджер по логистике"),

        WordEntity(id = 134018, setId = 1340, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "דִּיסְפֶּטְשֶׁר", translation = "диспетчер"),

        WordEntity(id = 134019, setId = 1340, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַעֲקַב מִשְׁלוֹחַ", translation = "отслеживание груза"),

        WordEntity(id = 134020, setId = 1340, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אַחְרָיוּת בִּיטּוּחַ", translation = "страховая ответственность"),

        WordEntity(id = 134021, setId = 1340, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אִי-עֲמִידָה בְּמַסְלוּל", translation = "отклонение от маршрута"),

        WordEntity(id = 134022, setId = 1340, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אִי-עֲמִידָה בִּזְמַן", translation = "нарушение сроков доставки"),

        WordEntity(id = 134023, setId = 1340, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "בְּדִיקַת רֶכֶב", translation = "технический осмотр автомобиля"),

        WordEntity(id = 134024, setId = 1340, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תְּנַאֵי הֲסָעָה", translation = "условия перевозки"),

        WordEntity(id = 134025, setId = 1340, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "כִּשּׁוּרִים לוֹגִיסְטִיִּים", translation = "логистические навыки"),

        // ── Set 1341: Риэлтор: основы 3 (level=1, COMMON+UNCOMMON) ──────────

        WordEntity(id = 134101, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "רֶזוּמֵה", translation = "резюме"),

        WordEntity(id = 134102, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "רֵיאָיוֹן עֲבוֹדָה", translation = "собеседование"),

        WordEntity(id = 134103, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "מַשְׂכּוֹרֶת", translation = "зарплата"),

        WordEntity(id = 134104, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "עַמְלָה", translation = "комиссионные, процент от сделки"),

        WordEntity(id = 134105, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "נִסָּיוֹן בְּתִיוּוּךְ", translation = "опыт в риэлторстве"),

        WordEntity(id = 134106, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "תְּקוּפַת נִסָּיוֹן", translation = "испытательный срок"),

        WordEntity(id = 134107, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "חוֹזֶה עֲבוֹדָה", translation = "трудовой договор"),

        WordEntity(id = 134108, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "הַמְלָצָה", translation = "рекомендация"),

        WordEntity(id = 134109, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "מַאֲגַר לְקוֹחוֹת", translation = "база клиентов"),

        WordEntity(id = 134110, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "הַצָּגַת נְכָס", translation = "показ объекта"),

        WordEntity(id = 134111, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "מִשָּׂא וּמַתָּן", translation = "переговоры"),

        WordEntity(id = 134112, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "הֶצְעַת עֲבוֹדָה", translation = "предложение о работе, оффер"),

        WordEntity(id = 134113, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "כִּשּׁוּרֵי מֶכֶר", translation = "навыки продаж"),

        WordEntity(id = 134114, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "הִיכָּרוּת עִם הַשּׁוּק", translation = "знание рынка"),

        WordEntity(id = 134115, setId = 1341, languagePair = "he-ru", rarity = "COMMON",
            original = "שִׁיחַ קַר", translation = "холодный звонок"),

        WordEntity(id = 134116, setId = 1341, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רִשָּׁיוֹן מְתִיוּוּךְ", translation = "лицензия риэлтора"),

        WordEntity(id = 134117, setId = 1341, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הֶסְכֵּם שְׂכִירוּת", translation = "договор аренды"),

        WordEntity(id = 134118, setId = 1341, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַעֲרָכַת שֵׁווּי", translation = "оценка стоимости объекта"),

        WordEntity(id = 134119, setId = 1341, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חֲלוּקַת עַמְלָה", translation = "раздел комиссионных"),

        WordEntity(id = 134120, setId = 1341, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רִישׁוּם בְּטַאבּוּ", translation = "регистрация в земельном реестре (тabu)"),

        WordEntity(id = 134121, setId = 1341, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "בּוֹנוּס מֶכֶר", translation = "бонус за сделку"),

        WordEntity(id = 134122, setId = 1341, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "כְּנַסַת בַּיִת פְּתוּחָה", translation = "открытый показ (open house)"),

        WordEntity(id = 134123, setId = 1341, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִשְׂרַד תִּיוּוּךְ", translation = "риэлторское агентство"),

        WordEntity(id = 134124, setId = 1341, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פּוּנֵל לְקוֹחוֹת", translation = "воронка клиентов"),

        WordEntity(id = 134125, setId = 1341, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַנְהֵל תִּיקִים", translation = "управляющий портфелем объектов"),

        // ── Set 1342: Журналист: основы 2 (level=1, COMMON+UNCOMMON) ─────────

        WordEntity(id = 134201, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "רֶזוּמֵה", translation = "резюме"),

        WordEntity(id = 134202, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "רֵיאָיוֹן עֲבוֹדָה", translation = "собеседование"),

        WordEntity(id = 134203, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "מַשְׂכּוֹרֶת", translation = "зарплата"),

        WordEntity(id = 134204, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "תִּיק עֲבוֹדוֹת", translation = "портфолио публикаций"),

        WordEntity(id = 134205, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "נִסָּיוֹן בְּעִיתוֹנַאוּת", translation = "опыт в журналистике"),

        WordEntity(id = 134206, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "תְּקוּפַת נִסָּיוֹן", translation = "испытательный срок"),

        WordEntity(id = 134207, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "חוֹזֶה עֲבוֹדָה", translation = "трудовой договор"),

        WordEntity(id = 134208, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "הַמְלָצָה", translation = "рекомендация"),

        WordEntity(id = 134209, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "עוֹרֵךְ", translation = "редактор"),

        WordEntity(id = 134210, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "עוֹרֵךְ רָאשִׁי", translation = "главный редактор"),

        WordEntity(id = 134211, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "מַעֲרֶכֶת עִיתּוֹן", translation = "редакция газеты"),

        WordEntity(id = 134212, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "כְּתַב עֵת", translation = "журнал, периодическое издание"),

        WordEntity(id = 134213, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "הֶצְעַת עֲבוֹדָה", translation = "предложение о работе, оффер"),

        WordEntity(id = 134214, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "כְּתָבוֹת לְדוּגְמָה", translation = "примеры публикаций / статей"),

        WordEntity(id = 134215, setId = 1342, languagePair = "he-ru", rarity = "COMMON",
            original = "תְּחוּם הִתְמַחֻיּוּת", translation = "область специализации"),

        WordEntity(id = 134216, setId = 1342, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עִיתוֹנַאי עַצְמָאִי", translation = "независимый журналист, фрилансер"),

        WordEntity(id = 134217, setId = 1342, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שְׂכַר טִרְחָה", translation = "гонорар"),

        WordEntity(id = 134218, setId = 1342, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "בְּדִיקַת עוּבְדוֹת", translation = "проверка фактов (fact-checking)"),

        WordEntity(id = 134219, setId = 1342, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "נוֹשֵׂא כְּתָבָה", translation = "тема материала / статьи"),

        WordEntity(id = 134220, setId = 1342, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פּוֹרְמַט תּוֹכֶן", translation = "формат контента"),

        WordEntity(id = 134221, setId = 1342, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תַּדְרִיךְ עִיתוֹנַאי", translation = "брифинг для прессы"),

        WordEntity(id = 134222, setId = 1342, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "כִּיסּוּי אֲזוֹרִי", translation = "региональное освещение событий"),

        WordEntity(id = 134223, setId = 1342, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רְשׁוּת שִׁדּוּר", translation = "вещательная корпорация"),

        WordEntity(id = 134224, setId = 1342, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עֲבוֹדַת שֶׂדֶה", translation = "репортаж с места событий"),

        WordEntity(id = 134225, setId = 1342, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "זְכוּיּוֹת יוֹצְרִים", translation = "авторские права"),

        // ── Set 1343: Архитектура: основы 2 (level=1, COMMON+UNCOMMON) ───────

























    )
}
