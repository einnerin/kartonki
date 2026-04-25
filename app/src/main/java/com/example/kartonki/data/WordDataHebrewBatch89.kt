package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — batch 89.
 * Sets 1539–1543: углубление — Финансы L4, Одежда L2, Религия L2, Хай-тек L2, Путешествия L2.
 */
object WordDataHebrewBatch89 {

    val sets = listOf(
        WordSetEntity(id = 1542, languagePair = "he-ru", orderIndex = 1542,
            name = "Хай-тек",
            description = "Стартап-экосистема, финтех, SaaS",
            topic = "Хай-тек", level = 2),
        WordSetEntity(id = 1543, languagePair = "he-ru", orderIndex = 1543,
            name = "Путешествия",
            description = "Виды путешествий, бронирование, туризм",
            topic = "Путешествия", level = 2),
    )

    val words = listOf(

        // ── Set 1539 — Финансы: профессиональный 2 (level 4, C1) ─────────
        // 0 COMMON + 1 UNCOMMON + 6 RARE + 13 EPIC + 5 LEGENDARY

        // ── Set 1540 — Одежда: продвинутый 2 (level 2, A2/B1) ────────────
        // 2 COMMON + 16 UNCOMMON + 4 RARE + 2 EPIC + 1 LEGENDARY

        // ── Set 1541 — Религия и праздники: продвинутый 2 (level 2) ──────
        // 2 COMMON + 16 UNCOMMON + 4 RARE + 2 EPIC + 1 LEGENDARY

        // ── Set 1542 — Хай-тек: продвинутый 2 (level 2, A2/B1) ───────────
        // 2 COMMON + 16 UNCOMMON + 4 RARE + 2 EPIC + 1 LEGENDARY
        WordEntity(id = 154201, setId = 1542, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סְטַארְט-אָפּ", translation = "стартап", transliteration = "старт-ап"),
        WordEntity(id = 154202, setId = 1542, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַשְׁקִיעַ", translation = "инвестор", transliteration = "машкиа"),
        WordEntity(id = 154203, setId = 1542, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "יַזָּם", translation = "предприниматель / основатель", transliteration = "язам"),
        WordEntity(id = 154204, setId = 1542, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אִינְקוּבָּטוֹר", translation = "бизнес-инкубатор", transliteration = "инкубатор"),
        WordEntity(id = 154205, setId = 1542, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אָצֶלֶרָטוֹר", translation = "акселератор стартапов", transliteration = "ацелератор"),
        WordEntity(id = 154206, setId = 1542, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַלְאָךְ עֲסָקִים", translation = "бизнес-ангел", transliteration = "малах асаким"),
        WordEntity(id = 154207, setId = 1542, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מוֹדֶל עֲסָקִי", translation = "бизнес-модель", transliteration = "модель асаки"),
        WordEntity(id = 154208, setId = 1542, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מוּצָר מִינִימָלִי", translation = "MVP (минимальный продукт)", transliteration = "муцар минимали"),
        WordEntity(id = 154209, setId = 1542, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הִתְאָמַת מוּצָר-שׁוּק", translation = "product-market fit", transliteration = "hитъамат муцар-шук"),
        WordEntity(id = 154210, setId = 1542, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שְׁכִיבִיל", translation = "масштабируемость (scalability)", transliteration = "шхивиль"),
        WordEntity(id = 154211, setId = 1542, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פִינְטֵק", translation = "финтех / финансовые технологии", transliteration = "финтек"),
        WordEntity(id = 154212, setId = 1542, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אֶדְטֶק", translation = "эдтех / образовательные технологии", transliteration = "эдтек"),
        WordEntity(id = 154213, setId = 1542, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "בִּיּוֹטֶק", translation = "биотех / биотехнологии", transliteration = "биотек"),
        WordEntity(id = 154214, setId = 1542, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תּוֹכְנָה כְּשֵׁרוּת", translation = "SaaS (ПО как услуга)", transliteration = "тохна ке-шерут"),
        WordEntity(id = 154215, setId = 1542, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "בִּינָה יוֹצֶרֶת", translation = "генеративный интеллект (GenAI продукт)", transliteration = "бина йоцерет"),
        WordEntity(id = 154216, setId = 1542, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַשְׁקָת מוּצָר", translation = "запуск продукта (product launch)", transliteration = "hашкат муцар"),
        WordEntity(id = 154217, setId = 1542, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אָב טִפּוּס", translation = "прототип", transliteration = "ав типус"),
        WordEntity(id = 154218, setId = 1542, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פִּתּוּחַ עֲסָקִי", translation = "развитие бизнеса (BizDev)", transliteration = "питуах асаки"),
        WordEntity(id = 154219, setId = 1542, languagePair = "he-ru", rarity = "RARE",
            original = "אֶקְזִיט", translation = "экзит (выход из компании)", transliteration = "экзит"),
        WordEntity(id = 154220, setId = 1542, languagePair = "he-ru", rarity = "RARE",
            original = "חַדְקֶרֶן", translation = "юникорн (стартап-«единорог»)", transliteration = "хадкерен"),
        WordEntity(id = 154221, setId = 1542, languagePair = "he-ru", rarity = "RARE",
            original = "מַפַּת דֶּרֶךְ מוּצָר", translation = "дорожная карта продукта", transliteration = "мапат дерех муцар"),
        WordEntity(id = 154222, setId = 1542, languagePair = "he-ru", rarity = "RARE",
            original = "פַּרְגּוּגַת הַחֲזָרָה", translation = "отток клиентов (churn rate)", transliteration = "паргугат hа-хазара"),
        WordEntity(id = 154223, setId = 1542, languagePair = "he-ru", rarity = "RARE",
            original = "מַחֲזוֹר חַיַּי לָקוֹחַ", translation = "Customer Lifetime Value (CLV)", transliteration = "махзор хаей лакоах"),
        WordEntity(id = 154224, setId = 1542, languagePair = "he-ru", rarity = "RARE",
            original = "אֱקוֹסִיסְטֶם טֶכְנוֹלוֹגִי", translation = "технологическая экосистема", transliteration = "экосистем технологи"),
        WordEntity(id = 154225, setId = 1542, languagePair = "he-ru", rarity = "RARE",
            original = "פַּרַדִּיגְמַת פְּלַטְפוֹרְמָה", translation = "платформенная парадигма (бизнеса)", transliteration = "парадигмат платформа"),

        // ── Set 1543 — Путешествия: продвинутый 2 (level 2, A2/B1) ───────
        // 2 COMMON + 16 UNCOMMON + 4 RARE + 2 EPIC + 1 LEGENDARY
        WordEntity(id = 154301, setId = 1543, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "כַּרְטִיס טִיסָה", translation = "авиабилет", transliteration = "картис тиса"),
        WordEntity(id = 154302, setId = 1543, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מָלוֹן", translation = "гостиница / отель", transliteration = "малон"),
        WordEntity(id = 154303, setId = 1543, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַזְמָנַת מָלוֹן", translation = "бронирование отеля", transliteration = "hазманат малон"),
        WordEntity(id = 154304, setId = 1543, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "צִ'ק אִין", translation = "заселение (check-in)", transliteration = "чек ин"),
        WordEntity(id = 154305, setId = 1543, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "צִ'ק אַאוּט", translation = "выезд (check-out)", transliteration = "чек аут"),
        WordEntity(id = 154306, setId = 1543, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִטַּעֲנִית יָד", translation = "ручная кладь", transliteration = "митаанит яд"),
        WordEntity(id = 154307, setId = 1543, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַזְוָדָה", translation = "чемодан", transliteration = "мизвада"),
        WordEntity(id = 154308, setId = 1543, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "דַּרְכּוֹן", translation = "паспорт", transliteration = "даркон"),
        WordEntity(id = 154309, setId = 1543, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "וִיזַה", translation = "виза", transliteration = "виза"),
        WordEntity(id = 154310, setId = 1543, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חַגּוֹרַת בְּטִחוּת", translation = "ремень безопасности", transliteration = "хагорат бтихут"),
        WordEntity(id = 154311, setId = 1543, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טִיּוּל תַּרְמִיל", translation = "бэкпекерское путешествие", transliteration = "тийуль тармиль"),
        WordEntity(id = 154312, setId = 1543, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טִיּוּל מֻכְוָן", translation = "организованный тур", transliteration = "тийуль мухван"),
        WordEntity(id = 154313, setId = 1543, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תַּרְמִיל נֶסִיעָה", translation = "рюкзак-трансформер", transliteration = "тармиль несиа"),
        WordEntity(id = 154314, setId = 1543, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תְּעוּדַת חִיסּוּן", translation = "сертификат о прививках (для поездки)", transliteration = "теудат хисун"),
        WordEntity(id = 154315, setId = 1543, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַדְרִיךְ תַּיָּרִים", translation = "гид / экскурсовод", transliteration = "мадрих таярим"),
        WordEntity(id = 154316, setId = 1543, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אַטְרַקְצְיָה", translation = "достопримечательность", transliteration = "аттракция"),
        WordEntity(id = 154317, setId = 1543, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חֲבִילַת נֹפֶשׁ", translation = "пакетный тур (всё включено)", transliteration = "хавилат нофеш"),
        WordEntity(id = 154318, setId = 1543, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סוֹפֵי שָׁבוּעַ אֲרוּכִים", translation = "длинные выходные", transliteration = "софей шавуа арухим"),
        WordEntity(id = 154319, setId = 1543, languagePair = "he-ru", rarity = "RARE",
            original = "טַיָּסִיָּה זוֹלָה", translation = "лоукостер / бюджетная авиация", transliteration = "таясия зола"),
        WordEntity(id = 154320, setId = 1543, languagePair = "he-ru", rarity = "RARE",
            original = "הַעֲבָרַת טִיסָה", translation = "стыковка / трансфер (рейс)", transliteration = "hааварат тиса"),
        WordEntity(id = 154321, setId = 1543, languagePair = "he-ru", rarity = "RARE",
            original = "פִּיצּוּי עַל עִכּוּב", translation = "компенсация за задержку рейса", transliteration = "пицуй аль икув"),
        WordEntity(id = 154322, setId = 1543, languagePair = "he-ru", rarity = "RARE",
            original = "נְסִיעוֹת יְקָרוֹת", translation = "люкс-путешествия / luxury travel", transliteration = "несиот йекарот"),
        WordEntity(id = 154323, setId = 1543, languagePair = "he-ru", rarity = "RARE",
            original = "תַּיָּרוּת גַסְטְרוֹנוֹמִית", translation = "гастрономический туризм", transliteration = "таярут гастрономит"),
        WordEntity(id = 154324, setId = 1543, languagePair = "he-ru", rarity = "RARE",
            original = "טִיּוּל הַרְפַּתְקָאוֹת", translation = "приключенческий туризм", transliteration = "тийуль hарпаткаот"),
        WordEntity(id = 154325, setId = 1543, languagePair = "he-ru", rarity = "RARE",
            original = "תַּיָּרוּת חֲלַלִית", translation = "космический туризм", transliteration = "таярут халалит"),
    )
}
