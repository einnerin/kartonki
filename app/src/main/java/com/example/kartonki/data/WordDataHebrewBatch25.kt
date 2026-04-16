package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrewBatch25 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1097, languagePair = "he-ru", orderIndex = 1097,
            name = "Математика",
            description = "Алгебра, анализ и дискретная математика A2/C2",
        ),
        WordSetEntity(
            id = 1098, languagePair = "he-ru", orderIndex = 1098,
            name = "Физика и химия",
            description = "Атомы, поля и теории строения материи A2/C2",
        ),
        WordSetEntity(
            id = 1099, languagePair = "he-ru", orderIndex = 1099,
            name = "ИТ-безопасность",
            description = "Атаки, защита и киберугрозы A2/C2",
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Set 1097: Математика ───────────────────────────────────────────

        // COMMON (A1)
        WordEntity(id = 109701, setId = 1097, languagePair = "he-ru", rarity = "COMMON",
            original = "מַתֵּמָטִיקָה", translation = "математика"),
        WordEntity(id = 109702, setId = 1097, languagePair = "he-ru", rarity = "COMMON",
            original = "מִשְׁוָאָה", translation = "уравнение"),
        WordEntity(id = 109703, setId = 1097, languagePair = "he-ru", rarity = "COMMON",
            original = "גֵּאוֹמֶטְרְיָה", translation = "геометрия"),
        WordEntity(id = 109704, setId = 1097, languagePair = "he-ru", rarity = "COMMON",
            original = "אַלְגֶּבְּרָה", translation = "алгебра"),
        WordEntity(id = 109705, setId = 1097, languagePair = "he-ru", rarity = "COMMON",
            original = "הִסְתַּבְּרוּת", translation = "вероятность"),
        WordEntity(id = 109706, setId = 1097, languagePair = "he-ru", rarity = "COMMON",
            original = "הוֹכָחָה", translation = "доказательство"),

        // UNCOMMON (A2-B1)
        WordEntity(id = 109707, setId = 1097, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חֶשְׁבּוֹן דִּיפֶרֶנְצְיַלִי", translation = "дифференциальное исчисление"),
        WordEntity(id = 109708, setId = 1097, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אִינְטֶגְרַל", translation = "интеграл"),
        WordEntity(id = 109709, setId = 1097, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַשְׁפָּט", translation = "теорема"),
        WordEntity(id = 109710, setId = 1097, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַטְרִיצָה", translation = "матрица"),
        WordEntity(id = 109711, setId = 1097, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גְּרָף", translation = "граф"),
        WordEntity(id = 109712, setId = 1097, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "וֶקְטוֹר", translation = "вектор"),
        WordEntity(id = 109713, setId = 1097, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אַקְסִיוֹמָה", translation = "аксиома"),
        WordEntity(id = 109714, setId = 1097, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אֶלְגוֹרִיתְם", translation = "алгоритм"),
        WordEntity(id = 109715, setId = 1097, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מֶטְרִיקָה", translation = "метрика (мера расстояния)"),
        WordEntity(id = 109716, setId = 1097, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מוֹדוּל", translation = "модуль, абсолютная величина"),

        // RARE (B2)
        WordEntity(id = 109717, setId = 1097, languagePair = "he-ru", rarity = "RARE",
            original = "פְּרַקְטָל", translation = "фрактал"),
        WordEntity(id = 109718, setId = 1097, languagePair = "he-ru", rarity = "RARE",
            original = "טוֹפּוֹלוֹגְיָה", translation = "топология"),
        WordEntity(id = 109719, setId = 1097, languagePair = "he-ru", rarity = "RARE",
            original = "אַנָלִיזָה נוּמֶרִית", translation = "численный анализ"),
        WordEntity(id = 109720, setId = 1097, languagePair = "he-ru", rarity = "RARE",
            original = "לוֹגִיקָה פוֹרְמַלִית", translation = "формальная логика"),
        WordEntity(id = 109721, setId = 1097, languagePair = "he-ru", rarity = "RARE",
            original = "תֵּיאוֹרְיַת הַקְּבוּצוֹת", translation = "теория множеств"),

        // EPIC (C1)
        WordEntity(id = 109722, setId = 1097, languagePair = "he-ru", rarity = "EPIC",
            original = "קוֹמְפְּלֶקְסִיּוּת חִישׁוּבִית", translation = "вычислительная сложность (P vs NP)"),
        WordEntity(id = 109723, setId = 1097, languagePair = "he-ru", rarity = "EPIC",
            original = "גֵאוֹמֶטְרְיָה דִּיפֶרֶנְצְיַלִית", translation = "дифференциальная геометрия"),
        WordEntity(id = 109724, setId = 1097, languagePair = "he-ru", rarity = "EPIC",
            original = "אַנָלִיזָה קוֹמְפְּלֶקְסִית", translation = "комплексный анализ"),

        // LEGENDARY (C2)
        WordEntity(id = 109725, setId = 1097, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "הִשְׁעָרַת רִימָן", translation = "гипотеза Римана (нерешённая задача тысячелетия)"),

        // ── Set 1098: Физика и химия ───────────────────────────────────────

        // COMMON (A1)
        WordEntity(id = 109801, setId = 1098, languagePair = "he-ru", rarity = "COMMON",
            original = "פִּיסִיקָה", translation = "физика"),
        WordEntity(id = 109802, setId = 1098, languagePair = "he-ru", rarity = "COMMON",
            original = "אַטוֹם", translation = "атом"),
        WordEntity(id = 109803, setId = 1098, languagePair = "he-ru", rarity = "COMMON",
            original = "מוֹלֶקוּלָה", translation = "молекула"),
        WordEntity(id = 109804, setId = 1098, languagePair = "he-ru", rarity = "COMMON",
            original = "אֶלֶקְטְרוֹן", translation = "электрон"),
        WordEntity(id = 109805, setId = 1098, languagePair = "he-ru", rarity = "COMMON",
            original = "גַּרְעִין", translation = "ядро (атомное)"),
        WordEntity(id = 109806, setId = 1098, languagePair = "he-ru", rarity = "COMMON",
            original = "פּוֹטוֹן", translation = "фотон"),

        // UNCOMMON (A2-B1)
        WordEntity(id = 109807, setId = 1098, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "נֵיטְרוֹן", translation = "нейтрон"),
        WordEntity(id = 109808, setId = 1098, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פְּרוֹטוֹן", translation = "протон"),
        WordEntity(id = 109809, setId = 1098, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אֶלֶמֶנְט", translation = "химический элемент"),
        WordEntity(id = 109810, setId = 1098, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תַּרְכּוֹבֶת", translation = "химическое соединение"),
        WordEntity(id = 109811, setId = 1098, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חֻמְצָה", translation = "кислота"),
        WordEntity(id = 109812, setId = 1098, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אוֹקְסִידַצְיָה", translation = "окисление"),
        WordEntity(id = 109813, setId = 1098, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שְׂדֵה חַשְׁמַלִּי", translation = "электрическое поле"),
        WordEntity(id = 109814, setId = 1098, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תְּנוּפָה", translation = "импульс (физика)"),
        WordEntity(id = 109815, setId = 1098, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גַּלֵּי אֶלֶקְטְרוֹמַגְנֶטִי", translation = "электромагнитные волны"),
        WordEntity(id = 109816, setId = 1098, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קְוַנְטוּם", translation = "квант"),

        // RARE (B2)
        WordEntity(id = 109817, setId = 1098, languagePair = "he-ru", rarity = "RARE",
            original = "יָחֲסוּת", translation = "теория относительности (Эйнштейн)"),
        WordEntity(id = 109818, setId = 1098, languagePair = "he-ru", rarity = "RARE",
            original = "אֶנְטְרוֹפִּיָּה", translation = "энтропия"),
        WordEntity(id = 109819, setId = 1098, languagePair = "he-ru", rarity = "RARE",
            original = "קוֹנְדֶּנְסָטוֹר", translation = "конденсатор"),
        WordEntity(id = 109820, setId = 1098, languagePair = "he-ru", rarity = "RARE",
            original = "קְוַרְק", translation = "кварк"),
        WordEntity(id = 109821, setId = 1098, languagePair = "he-ru", rarity = "RARE",
            original = "מֵכָנִיקָה קְלַסִּית", translation = "классическая механика (Ньютон)"),

        // EPIC (C1)
        WordEntity(id = 109822, setId = 1098, languagePair = "he-ru", rarity = "EPIC",
            original = "מֵכָנִיקָה קְוַנְטִית", translation = "квантовая механика"),
        WordEntity(id = 109823, setId = 1098, languagePair = "he-ru", rarity = "EPIC",
            original = "עִוּוּת מֶרְחָב-זְמַן", translation = "искривление пространства-времени"),
        WordEntity(id = 109824, setId = 1098, languagePair = "he-ru", rarity = "EPIC",
            original = "סוּפֶּרְ-נוֹבָה", translation = "сверхновая звезда"),

        // LEGENDARY (C2)
        WordEntity(id = 109825, setId = 1098, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תּוֹרַת הַמַּיְתָרִים", translation = "теория струн"),

        // ── Set 1099: ИТ-безопасность ──────────────────────────────────────

        // COMMON (A1)
        WordEntity(id = 109901, setId = 1099, languagePair = "he-ru", rarity = "COMMON",
            original = "סַיְיבֶּר", translation = "кибер-, киберпространство"),
        WordEntity(id = 109902, setId = 1099, languagePair = "he-ru", rarity = "COMMON",
            original = "פִּישִׁינְג", translation = "фишинг (кража данных через обман)"),
        WordEntity(id = 109903, setId = 1099, languagePair = "he-ru", rarity = "COMMON",
            original = "רוֹגַלָּה", translation = "шпионское ПО (spyware)"),
        WordEntity(id = 109904, setId = 1099, languagePair = "he-ru", rarity = "COMMON",
            original = "כּוֹפֶּר-וֶיֶר", translation = "программа-вымогатель (ransomware)"),
        WordEntity(id = 109905, setId = 1099, languagePair = "he-ru", rarity = "COMMON",
            original = "בּוֹטְנֶט", translation = "ботнет (сеть заражённых компьютеров)"),
        WordEntity(id = 109906, setId = 1099, languagePair = "he-ru", rarity = "COMMON",
            original = "סִיסְמָא", translation = "пароль"),

        // UNCOMMON (A2-B1)
        WordEntity(id = 109907, setId = 1099, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַנְדָּסָה חוֹזֶרֶת", translation = "обратная разработка (reverse engineering)"),
        WordEntity(id = 109908, setId = 1099, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אַקְסֶס קוֹנְטְרוֹל", translation = "контроль доступа (access control)"),
        WordEntity(id = 109909, setId = 1099, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "וֶקְטוֹר תְּקִיפָה", translation = "вектор атаки"),
        WordEntity(id = 109910, setId = 1099, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "נִיצּוּל", translation = "эксплойт (использование уязвимости)"),
        WordEntity(id = 109911, setId = 1099, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פֶּנֶטְרַצְיָה", translation = "пентест, тест на проникновение"),
        WordEntity(id = 109912, setId = 1099, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הֶנְדְּסָה חֶבְרָתִית", translation = "социальная инженерия (манипуляция людьми)"),
        WordEntity(id = 109913, setId = 1099, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רֶשֶׁת פְּרִיבָטִית וִירְטוּאָלִית", translation = "VPN — виртуальная частная сеть"),
        WordEntity(id = 109914, setId = 1099, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אֲנוֹנִימִיּוּת", translation = "анонимность"),
        WordEntity(id = 109915, setId = 1099, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אִינְצִידֶנְט", translation = "инцидент (в информационной безопасности)"),
        WordEntity(id = 109916, setId = 1099, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הֶסְדֵּר אַבְטָחָה", translation = "порядок реагирования на инцидент"),

        // RARE (B2)
        WordEntity(id = 109917, setId = 1099, languagePair = "he-ru", rarity = "RARE",
            original = "מִסְגֶּרֶת אַבְטָחָה", translation = "фреймворк безопасности (security framework)"),
        WordEntity(id = 109918, setId = 1099, languagePair = "he-ru", rarity = "RARE",
            original = "סַיְיבֶּר-בִּטָּחוֹן", translation = "кибербезопасность"),
        WordEntity(id = 109919, setId = 1099, languagePair = "he-ru", rarity = "RARE",
            original = "תְּקִיפָה מְכֻוֶּנֶת", translation = "целенаправленная атака (APT)"),
        WordEntity(id = 109920, setId = 1099, languagePair = "he-ru", rarity = "RARE",
            original = "נִיהוּל זְהוּיוֹת", translation = "управление идентификацией (IAM)"),
        WordEntity(id = 109921, setId = 1099, languagePair = "he-ru", rarity = "RARE",
            original = "פְּגִיעוּת", translation = "уязвимость (в системе безопасности)"),

        // EPIC (C1)
        WordEntity(id = 109922, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            original = "נִיצּוּל יוֹם-אֶפֶס", translation = "эксплойт нулевого дня (zero-day)"),
        WordEntity(id = 109923, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            original = "הַגְנָה בִּשְׂכָבוֹת", translation = "эшелонированная защита (defense in depth)"),
        WordEntity(id = 109924, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            original = "מוֹדֶל אֶפֶס-אֱמוּן", translation = "модель нулевого доверия (zero trust)"),

        // LEGENDARY (C2)
        WordEntity(id = 109925, setId = 1099, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "הַצְפָּנָה קְוַנְטִית", translation = "квантовое шифрование (постквантовая криптография)"),
    )
}
