package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrewBatch25 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1097, languagePair = "he-ru", orderIndex = 1097,
            name = "Наука: продвинутый 2",
            description = "Алгебра, анализ и дискретная математика",
            topic = "Наука",
            level = 2
        ),
        WordSetEntity(
            id = 1098, languagePair = "he-ru", orderIndex = 1098,
            name = "Наука: продвинутый 3",
            description = "Атомы, поля и теории строения материи",
            topic = "Наука",
            level = 2
        ),
        WordSetEntity(
            id = 1099, languagePair = "he-ru", orderIndex = 1099,
            name = "Технологии: профессиональный 4",
            description = "Атаки, защита и киберугрозы",
            topic = "Технологии",
            level = 4
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Set 1097: Математика ───────────────────────────────────────────

        // UNCOMMON (A2-B1)
        WordEntity(id = 109701, setId = 1097, languagePair = "he-ru", original = "קְבוּצָה", translation = "множество (матем.)", transliteration = "kvutza", rarity = "UNCOMMON"),
        WordEntity(id = 109702, setId = 1097, languagePair = "he-ru", original = "רְצֵף", translation = "последовательность (матем.)", transliteration = "retzef", rarity = "UNCOMMON"),
        WordEntity(id = 109703, setId = 1097, languagePair = "he-ru", original = "קִירוּב", translation = "приближение; аппроксимация", transliteration = "kirúv", rarity = "UNCOMMON"),
        WordEntity(id = 109704, setId = 1097, languagePair = "he-ru", original = "אֲרִיתְמֶטִיקָה", translation = "арифметика", transliteration = "aritmetika", rarity = "UNCOMMON"),
        WordEntity(id = 109705, setId = 1097, languagePair = "he-ru", original = "מֵדִיאָנָה", translation = "медиана", transliteration = "medyana", rarity = "UNCOMMON"),
        WordEntity(id = 109706, setId = 1097, languagePair = "he-ru", original = "פוּנְקְצִיָה", translation = "функция (матем.)", transliteration = "funtziya", rarity = "UNCOMMON"),

        // UNCOMMON (A2-B1)
        WordEntity(id = 109707, setId = 1097, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חֶשְׁבּוֹן דִּיפֶרֶנְצְיַלִי", translation = "дифференциальное исчисление"),
        WordEntity(id = 109708, setId = 1097, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אִינְטֶגְרַל", translation = "интеграл"),
        WordEntity(id = 109709, setId = 1097, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חֶלְקִיק", translation = "элементарная частица"),
        WordEntity(id = 109710, setId = 1097, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַטְרִיצָה", translation = "матрица"),
        WordEntity(id = 109711, setId = 1097, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גְּרָף", translation = "граф"),
        WordEntity(id = 109712, setId = 1097, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "וֶקְטוֹר", translation = "вектор"),
        WordEntity(id = 109713, setId = 1097, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אַקְסִיוֹמָה", translation = "аксиома"),
        WordEntity(id = 109714, setId = 1097, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "לֶמָּה", translation = "лемма"),
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

        // RARE (B2)
        WordEntity(id = 109722, setId = 1097, languagePair = "he-ru", original = "גְּזִירָה", translation = "производная (матем.)", transliteration = "gzira", rarity = "RARE"),
        WordEntity(id = 109723, setId = 1097, languagePair = "he-ru", original = "מְשׁוּוָּאָה דִּיפֶרֶנְצִיאָלִית", translation = "дифференциальное уравнение", transliteration = "meshuva'a differenzi'alit", rarity = "RARE"),
        WordEntity(id = 109724, setId = 1097, languagePair = "he-ru", original = "טְרַנְסְפוֹרְמַצְיָה לִינֵאָרִית", translation = "линейное преобразование", transliteration = "transformatziya lineárit", rarity = "RARE"),
        WordEntity(id = 109725, setId = 1097, languagePair = "he-ru", original = "אַלְגּוֹרִיתְם נוּמֶרִי", translation = "численный алгоритм", transliteration = "algoritm numeri", rarity = "RARE"),

        // ── Set 1098: Физика и химия ───────────────────────────────────────

        // UNCOMMON (A2-B1)
        WordEntity(id = 109801, setId = 1098, languagePair = "he-ru", original = "מַגְנֶטִיּוּת", translation = "магнетизм", transliteration = "magnetiyut", rarity = "UNCOMMON"),
        WordEntity(id = 109802, setId = 1098, languagePair = "he-ru", original = "חוֹם", translation = "тепло; тепловая энергия", transliteration = "khom", rarity = "UNCOMMON"),
        WordEntity(id = 109803, setId = 1098, languagePair = "he-ru", original = "תְּאוּצָה", translation = "ускорение", transliteration = "te'utza", rarity = "UNCOMMON"),
        WordEntity(id = 109804, setId = 1098, languagePair = "he-ru", original = "גַּלֵּי קוֹל", translation = "звуковые волны", transliteration = "gale kol", rarity = "UNCOMMON"),
        WordEntity(id = 109805, setId = 1098, languagePair = "he-ru", original = "חֶשְׁמַל", translation = "электричество", transliteration = "kheshmal", rarity = "UNCOMMON"),
        WordEntity(id = 109806, setId = 1098, languagePair = "he-ru", original = "הַתַּנְגָּדוּת", translation = "сопротивление (электрическое)", transliteration = "hatangadut", rarity = "UNCOMMON"),

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

        // RARE (B2)
        WordEntity(id = 109822, setId = 1098, languagePair = "he-ru", original = "מַעְגַּל חַשְׁמַלִּי", translation = "электрическая цепь", transliteration = "ma'agal khishmali", rarity = "RARE"),
        WordEntity(id = 109823, setId = 1098, languagePair = "he-ru", original = "אֶנֶרְגְיַת קִינֶטִית", translation = "кинетическая энергия", transliteration = "energyat kinetit", rarity = "RARE"),
        WordEntity(id = 109824, setId = 1098, languagePair = "he-ru", original = "הַמְרַת אֶנֶרְגְיָה", translation = "преобразование энергии", transliteration = "hamrat energya", rarity = "RARE"),
        WordEntity(id = 109825, setId = 1098, languagePair = "he-ru", original = "תֵּאוֹרְיַת הַקְּוַנְטִים", translation = "квантовая теория", transliteration = "teoriyat hakkvantim", rarity = "RARE"),

        // ── Set 1099: ИТ-безопасность ──────────────────────────────────────

        // RARE (B2)
        WordEntity(id = 109901, setId = 1099, languagePair = "he-ru", original = "הַצְפָּנָה סִימֶטְרִית", translation = "симметричное шифрование", transliteration = "hatzpana simetrit", rarity = "EPIC"),
        WordEntity(id = 109902, setId = 1099, languagePair = "he-ru", original = "אוֹתֶנְטִיקַצְיָה", translation = "аутентификация", transliteration = "otentikatziya", rarity = "EPIC"),
        WordEntity(id = 109903, setId = 1099, languagePair = "he-ru", original = "אִישּׁוּר דִּיגִיטַלִי", translation = "цифровой сертификат", transliteration = "ishur digitali", rarity = "EPIC"),
        WordEntity(id = 109904, setId = 1099, languagePair = "he-ru", original = "גִּבּוּי נְתוּנִים", translation = "резервное копирование данных", transliteration = "gibuy netumim", rarity = "EPIC"),
        WordEntity(id = 109905, setId = 1099, languagePair = "he-ru", original = "סְרִיקַת חוּלְשׁוֹת", translation = "сканирование уязвимостей", transliteration = "srikat khulshot", rarity = "EPIC"),
        WordEntity(id = 109906, setId = 1099, languagePair = "he-ru", original = "חֲלוּקַת רְשָׁת", translation = "сегментация сети", transliteration = "khalukat reshet", rarity = "EPIC"),
        WordEntity(id = 109907, setId = 1099, languagePair = "he-ru", original = "כְּלֵי פְּרִיצָה", translation = "инструменты взлома", transliteration = "kle pritza", rarity = "EPIC"),
        WordEntity(id = 109908, setId = 1099, languagePair = "he-ru", original = "נְקוּדַת כְּנִיסָה", translation = "точка входа (в систему)", transliteration = "nkudat knisa", rarity = "RARE"),

        // EPIC (C1)
        WordEntity(id = 109909, setId = 1099, languagePair = "he-ru", original = "הַשְׁתָּלָה מֵרָחוֹק", translation = "удалённое внедрение кода", transliteration = "hashtala merakhoq", rarity = "EPIC"),
        WordEntity(id = 109910, setId = 1099, languagePair = "he-ru", original = "תְּשְׁתִּית מַפְתֵּחַ צִיבּוּרִי", translation = "инфраструктура открытых ключей (PKI)", transliteration = "tshtit maftea tzibburi", rarity = "EPIC"),
        WordEntity(id = 109911, setId = 1099, languagePair = "he-ru", original = "תְּקִיפַת שַׁרְשֶׁרֶת אַסְפָּקָה", translation = "атака на цепочку поставок", transliteration = "tkifat sharsheret aspaka", rarity = "EPIC"),
        WordEntity(id = 109912, setId = 1099, languagePair = "he-ru", original = "הֲדָמָיַת צֶבַע אָדוֹם", translation = "учения red team", transliteration = "hadamayt tzeva adom", rarity = "EPIC"),
        WordEntity(id = 109913, setId = 1099, languagePair = "he-ru", original = "זִיהוּי חֲרִיגוּת", translation = "обнаружение аномалий", transliteration = "zihuy khrigut", rarity = "EPIC"),
        WordEntity(id = 109914, setId = 1099, languagePair = "he-ru", original = "עֲמִידוּת בְּמֶרְחָב הַסַּיְיבֶּר", translation = "устойчивость в киберпространстве", transliteration = "amidut bmerkhav hasayber", rarity = "EPIC"),
        WordEntity(id = 109915, setId = 1099, languagePair = "he-ru", original = "הַנְדָּסָה חֶבְרָתִית מְתוּחְכֶּמֶת", translation = "продвинутая социальная инженерия", transliteration = "handasa khevratit metukhemet", rarity = "EPIC"),
        WordEntity(id = 109916, setId = 1099, languagePair = "he-ru", original = "שִׁיטוֹת הַחְבָּאָה", translation = "методы обфускации", transliteration = "shitot hakhba'a", rarity = "EPIC"),

        // RARE (B2)
        WordEntity(id = 109917, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            original = "מִסְגֶּרֶת אַבְטָחָה", translation = "фреймворк безопасности (security framework)"),
        WordEntity(id = 109918, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            original = "סַיְיבֶּר-בִּטָּחוֹן", translation = "кибербезопасность"),
        WordEntity(id = 109919, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            original = "תְּקִיפָה מְכֻוֶּנֶת", translation = "целенаправленная атака (APT)"),
        WordEntity(id = 109920, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            original = "נִיהוּל זְהוּיוֹת", translation = "управление идентификацией (IAM)"),
        WordEntity(id = 109921, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            original = "פְּגִיעוּת", translation = "уязвимость (в системе безопасности)"),

        // EPIC (C1)
        WordEntity(id = 109922, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            original = "נִיצּוּל יוֹם-אֶפֶס", translation = "эксплойт нулевого дня (zero-day)"),
        WordEntity(id = 109923, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            original = "הַגְנָה בִּשְׂכָבוֹת", translation = "эшелонированная защита (defense in depth)"),
        WordEntity(id = 109924, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            original = "מוֹדֶל אֶפֶס-אֱמוּן", translation = "модель нулевого доверия (zero trust)"),

        // EPIC (C1)
        WordEntity(id = 109925, setId = 1099, languagePair = "he-ru", original = "אָנָלִיזָה פּוֹרֶנְזִית", translation = "цифровая форензика", transliteration = "analiza forensit", rarity = "EPIC"),
    )
}
