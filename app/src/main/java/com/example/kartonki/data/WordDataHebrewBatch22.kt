package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrewBatch22 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1088, languagePair = "he-ru", orderIndex = 1088,
            name = "Медицина: углублённо",
            description = "Специалисты, процедуры и медицинские дисциплины A2/C1",
        ),
        WordSetEntity(
            id = 1089, languagePair = "he-ru", orderIndex = 1089,
            name = "Право",
            description = "Судебная система, процессы и правовые теории B1/C2",
        ),
        WordSetEntity(
            id = 1090, languagePair = "he-ru", orderIndex = 1090,
            name = "Литература",
            description = "Жанры, нарратив и литературный анализ A2/C2",
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Set 1088: Медицина: углублённо ─────────────────────────────────

        // COMMON (A1)
        WordEntity(id = 108801, setId = 1088, languagePair = "he-ru", rarity = "COMMON",
            original = "חוֹלֶה", translation = "пациент, больной"),
        WordEntity(id = 108802, setId = 1088, languagePair = "he-ru", rarity = "COMMON",
            original = "אֶמְבּוּלַנְס", translation = "скорая помощь"),
        WordEntity(id = 108803, setId = 1088, languagePair = "he-ru", rarity = "COMMON",
            original = "זְרִיקָה", translation = "укол, инъекция"),
        WordEntity(id = 108804, setId = 1088, languagePair = "he-ru", rarity = "COMMON",
            original = "כִּירוּרְג", translation = "хирург"),
        WordEntity(id = 108805, setId = 1088, languagePair = "he-ru", rarity = "COMMON",
            original = "אַנְטִיבִּיוֹטִיקָה", translation = "антибиотики"),
        WordEntity(id = 108806, setId = 1088, languagePair = "he-ru", rarity = "COMMON",
            original = "רֶנְטְגֶן", translation = "рентген"),

        // UNCOMMON (A2-B1)
        WordEntity(id = 108807, setId = 1088, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אֲנֶסְתֵּזִיָּה", translation = "анестезия, наркоз"),
        WordEntity(id = 108808, setId = 1088, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִבְחַן דָּם", translation = "анализ крови"),
        WordEntity(id = 108809, setId = 1088, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טֵיפּוֹל נֶמְרָץ", translation = "интенсивная терапия"),
        WordEntity(id = 108810, setId = 1088, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "כְּרוֹנִי", translation = "хронический"),
        WordEntity(id = 108811, setId = 1088, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַחְלָמָה", translation = "выздоровление, реабилитация"),
        WordEntity(id = 108812, setId = 1088, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תַּסְמוֹנֶת", translation = "синдром"),
        WordEntity(id = 108813, setId = 1088, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קְדַח", translation = "температура, жар"),
        WordEntity(id = 108814, setId = 1088, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אִינְטֶרְנִיסְט", translation = "терапевт (врач общей практики)"),
        WordEntity(id = 108815, setId = 1088, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קַרְדִּיוֹלוֹג", translation = "кардиолог"),
        WordEntity(id = 108816, setId = 1088, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "דֶּרְמָטוֹלוֹג", translation = "дерматолог"),

        // RARE (B2)
        WordEntity(id = 108817, setId = 1088, languagePair = "he-ru", rarity = "RARE",
            original = "נוֹיְרוֹלוֹג", translation = "невролог"),
        WordEntity(id = 108818, setId = 1088, languagePair = "he-ru", rarity = "RARE",
            original = "פְּסִיכִיאַטְר", translation = "психиатр"),
        WordEntity(id = 108819, setId = 1088, languagePair = "he-ru", rarity = "RARE",
            original = "גַּסְטְרוֹאֶנְטֶרוֹלוֹג", translation = "гастроэнтеролог"),
        WordEntity(id = 108820, setId = 1088, languagePair = "he-ru", rarity = "RARE",
            original = "מֶטָבּוֹלִיזְם", translation = "метаболизм"),
        WordEntity(id = 108821, setId = 1088, languagePair = "he-ru", rarity = "RARE",
            original = "בַּקְטֶרִיָּה", translation = "бактерия"),

        // EPIC (C1)
        WordEntity(id = 108822, setId = 1088, languagePair = "he-ru", rarity = "EPIC",
            original = "אֵפִּידֶמְיוֹלוֹגְיָה", translation = "эпидемиология"),
        WordEntity(id = 108823, setId = 1088, languagePair = "he-ru", rarity = "EPIC",
            original = "פַּרְמַקוֹלוֹגְיָה", translation = "фармакология"),
        WordEntity(id = 108824, setId = 1088, languagePair = "he-ru", rarity = "EPIC",
            original = "בִּיוֹטֶכְנוֹלוֹגְיָה", translation = "биотехнология"),

        // LEGENDARY (C2)
        WordEntity(id = 108825, setId = 1088, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "רְפוּאָה מְדוּיֶּקֶת", translation = "прецизионная (персонализированная) медицина"),

        // ── Set 1089: Право ────────────────────────────────────────────────

        // COMMON (A1)
        WordEntity(id = 108901, setId = 1089, languagePair = "he-ru", rarity = "COMMON",
            original = "עוֹרֵךְ-דִּין", translation = "адвокат, юрист"),
        WordEntity(id = 108902, setId = 1089, languagePair = "he-ru", rarity = "COMMON",
            original = "חֹק", translation = "закон"),
        WordEntity(id = 108903, setId = 1089, languagePair = "he-ru", rarity = "COMMON",
            original = "חוּקָה", translation = "конституция"),
        WordEntity(id = 108904, setId = 1089, languagePair = "he-ru", rarity = "COMMON",
            original = "תּוֹבֵעַ", translation = "прокурор, обвинитель"),
        WordEntity(id = 108905, setId = 1089, languagePair = "he-ru", rarity = "COMMON",
            original = "גְּזַר דִּין", translation = "приговор"),
        WordEntity(id = 108906, setId = 1089, languagePair = "he-ru", rarity = "COMMON",
            original = "זַכּוּת", translation = "право (юридическое)"),

        // UNCOMMON (A2-B1)
        WordEntity(id = 108907, setId = 1089, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַרְשָׁעָה", translation = "осуждение, обвинительный приговор"),
        WordEntity(id = 108908, setId = 1089, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "זִיכּוּי", translation = "оправдание, оправдательный приговор"),
        WordEntity(id = 108909, setId = 1089, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עַרְעוּר", translation = "апелляция"),
        WordEntity(id = 108910, setId = 1089, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פִּצּוּיִים", translation = "компенсация, возмещение ущерба"),
        WordEntity(id = 108911, setId = 1089, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עֹנֶשׁ", translation = "наказание"),
        WordEntity(id = 108912, setId = 1089, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אִישּׁוּם", translation = "обвинительное заключение, предъявление обвинения"),
        WordEntity(id = 108913, setId = 1089, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שׁוּחַד", translation = "взятка"),
        WordEntity(id = 108914, setId = 1089, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "בֵּית דִּין", translation = "суд (религиозный или гражданский)"),
        WordEntity(id = 108915, setId = 1089, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִשְׁפַּט פְּלִילִי", translation = "уголовный суд"),
        WordEntity(id = 108916, setId = 1089, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִשְׁפַּט מִנְהָלִי", translation = "административное право"),

        // RARE (B2)
        WordEntity(id = 108917, setId = 1089, languagePair = "he-ru", rarity = "RARE",
            original = "סַנֵּגוֹרִיָּה", translation = "защита (адвокатская)"),
        WordEntity(id = 108918, setId = 1089, languagePair = "he-ru", rarity = "RARE",
            original = "יוּרִיסְדִּיקְצְיָה", translation = "юрисдикция"),
        WordEntity(id = 108919, setId = 1089, languagePair = "he-ru", rarity = "RARE",
            original = "פְּרֵצֶדֶנְט", translation = "прецедент"),
        WordEntity(id = 108920, setId = 1089, languagePair = "he-ru", rarity = "RARE",
            original = "הֲלָכָה פְּסוּקָה", translation = "судебная практика, прецедентное право"),
        WordEntity(id = 108921, setId = 1089, languagePair = "he-ru", rarity = "RARE",
            original = "מַעֲשֶׂה עָווֶל", translation = "правонарушение, деликт"),

        // EPIC (C1)
        WordEntity(id = 108922, setId = 1089, languagePair = "he-ru", rarity = "EPIC",
            original = "תַּקְדִּים מִשְׁפָּטִי", translation = "юридический прецедент"),
        WordEntity(id = 108923, setId = 1089, languagePair = "he-ru", rarity = "EPIC",
            original = "מְדִינִיּוּת מִשְׁפָּטִית", translation = "правовая политика"),
        WordEntity(id = 108924, setId = 1089, languagePair = "he-ru", rarity = "EPIC",
            original = "הַפְרָדַת רְשׁוּיוֹת", translation = "разделение властей"),

        // LEGENDARY (C2)
        WordEntity(id = 108925, setId = 1089, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "פּוֹזִיטִיבִיזְם מִשְׁפָּטִי", translation = "правовой позитивизм (Остин, Харт)"),

        // ── Set 1090: Литература ───────────────────────────────────────────

        // COMMON (A1)
        WordEntity(id = 109001, setId = 1090, languagePair = "he-ru", rarity = "COMMON",
            original = "סִפְרוּת", translation = "литература"),
        WordEntity(id = 109002, setId = 1090, languagePair = "he-ru", rarity = "COMMON",
            original = "רוֹמָן", translation = "роман"),
        WordEntity(id = 109003, setId = 1090, languagePair = "he-ru", rarity = "COMMON",
            original = "סוֹפֵר", translation = "писатель"),
        WordEntity(id = 109004, setId = 1090, languagePair = "he-ru", rarity = "COMMON",
            original = "פֶּרֶק", translation = "глава (в книге)"),
        WordEntity(id = 109005, setId = 1090, languagePair = "he-ru", rarity = "COMMON",
            original = "סִיפּוּר", translation = "рассказ, история"),
        WordEntity(id = 109006, setId = 1090, languagePair = "he-ru", rarity = "COMMON",
            original = "מְחַבֵּר", translation = "автор"),

        // UNCOMMON (A2-B1)
        WordEntity(id = 109007, setId = 1090, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "דְּמוּת", translation = "персонаж, литературный герой"),
        WordEntity(id = 109008, setId = 1090, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עֶלְיָלָה", translation = "сюжет"),
        WordEntity(id = 109009, setId = 1090, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מוֹטִיב", translation = "мотив (литературный)"),
        WordEntity(id = 109010, setId = 1090, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "ז'וֹנְר", translation = "жанр"),
        WordEntity(id = 109011, setId = 1090, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "נוֹבֶלָה", translation = "новелла"),
        WordEntity(id = 109012, setId = 1090, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "לִירִיקָה", translation = "лирика"),
        WordEntity(id = 109013, setId = 1090, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פְּרוֹזָה", translation = "проза"),
        WordEntity(id = 109014, setId = 1090, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "נַרָטִיב", translation = "нарратив, повествование"),
        WordEntity(id = 109015, setId = 1090, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מֶטָפוֹרָה", translation = "метафора"),
        WordEntity(id = 109016, setId = 1090, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רָמֶז", translation = "намёк, аллюзия"),

        // RARE (B2)
        WordEntity(id = 109017, setId = 1090, languagePair = "he-ru", rarity = "RARE",
            original = "אֵפּוֹס", translation = "эпос"),
        WordEntity(id = 109018, setId = 1090, languagePair = "he-ru", rarity = "RARE",
            original = "אוֹנוֹמַטוֹפֵּאָה", translation = "звукоподражание (ономатопея)"),
        WordEntity(id = 109019, setId = 1090, languagePair = "he-ru", rarity = "RARE",
            original = "צֶבַע מִלִּים", translation = "образность языка, языковая живопись"),
        WordEntity(id = 109020, setId = 1090, languagePair = "he-ru", rarity = "RARE",
            original = "זְרַם הַתּוֹדָעָה", translation = "поток сознания"),
        WordEntity(id = 109021, setId = 1090, languagePair = "he-ru", rarity = "RARE",
            original = "הַנָּרָה בִּלְתִּי-מְהֵימָנָה", translation = "ненадёжный рассказчик"),

        // EPIC (C1)
        WordEntity(id = 109022, setId = 1090, languagePair = "he-ru", rarity = "EPIC",
            original = "אִינְטֶרְטֶקְסְטוּאַלִיּוּת", translation = "интертекстуальность"),
        WordEntity(id = 109023, setId = 1090, languagePair = "he-ru", rarity = "EPIC",
            original = "פּוֹסְט-קוֹלוֹנְיַלִיזְם", translation = "постколониализм (в литературе)"),
        WordEntity(id = 109024, setId = 1090, languagePair = "he-ru", rarity = "EPIC",
            original = "מֶטָאָנָרָטִיב", translation = "метанарратив (большой нарратив)"),

        // LEGENDARY (C2)
        WordEntity(id = 109025, setId = 1090, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "הֶרְמֶנוֹיְטִיקָה", translation = "герменевтика (теория интерпретации)"),
    )
}
