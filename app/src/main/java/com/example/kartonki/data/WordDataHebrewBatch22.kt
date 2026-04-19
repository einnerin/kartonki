package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrewBatch22 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1088, languagePair = "he-ru", orderIndex = 1088,
            name = "Медицина: профессиональный",
            description = "Специалисты, процедуры и медицинские дисциплины",
            topic = "Медицина",
            level = 4
        ),
        WordSetEntity(
            id = 1089, languagePair = "he-ru", orderIndex = 1089,
            name = "Право: профессиональный",
            description = "Судебная система, процессы и правовые теории",
            topic = "Право",
            level = 4
        ),
        WordSetEntity(
            id = 1090, languagePair = "he-ru", orderIndex = 1090,
            name = "Культура и искусство: продвинутый 4",
            description = "Жанры, нарратив и литературный анализ",
            topic = "Культура и искусство",
            level = 2
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Set 1088: Медицина: углублённо ─────────────────────────────────

        // RARE (B2)
        WordEntity(id = 108801, setId = 1088, languagePair = "he-ru", rarity = "RARE",
            original = "אוֹנְקוֹלוֹג", translation = "онколог", transliteration = "onkolog"),
        WordEntity(id = 108802, setId = 1088, languagePair = "he-ru", rarity = "RARE",
            original = "רַדְיוֹלוֹג", translation = "радиолог", transliteration = "radiolog"),
        WordEntity(id = 108803, setId = 1088, languagePair = "he-ru", rarity = "RARE",
            original = "אָנֶסְתֶּזְיוֹלוֹג", translation = "анестезиолог", transliteration = "anesteziyolog"),
        WordEntity(id = 108804, setId = 1088, languagePair = "he-ru", rarity = "RARE",
            original = "בִּיוּפְסִיָּה", translation = "биопсия", transliteration = "biopsiya"),
        WordEntity(id = 108805, setId = 1088, languagePair = "he-ru", rarity = "RARE",
            original = "כִּירוּרְגְיָה לַפָּרוֹסְקוֹפִּית", translation = "лапароскопическая хирургия", transliteration = "khirurgia laparoskopít"),
        WordEntity(id = 108806, setId = 1088, languagePair = "he-ru", rarity = "RARE",
            original = "אֶמְבּוֹלְיָה", translation = "эмболия", transliteration = "embolya"),
        WordEntity(id = 108807, setId = 1088, languagePair = "he-ru", rarity = "RARE",
            original = "אִסְכֶּמְיָה", translation = "ишемия", transliteration = "iskemya"),
        WordEntity(id = 108808, setId = 1088, languagePair = "he-ru", rarity = "RARE",
            original = "מַחְלַת לֵב כְּלִילִי", translation = "ишемическая болезнь сердца", transliteration = "makhlat lev klili"),
        WordEntity(id = 108809, setId = 1088, languagePair = "he-ru", rarity = "RARE",
            original = "הַרְדָּמָה מְלֵאָה", translation = "общий наркоз", transliteration = "hardama mele'a"),
        WordEntity(id = 108810, setId = 1088, languagePair = "he-ru", rarity = "RARE",
            original = "אֶקוֹקַרְדִּיוֹגְרַמָּה", translation = "эхокардиограмма", transliteration = "ekokardiograma"),

        // EPIC (C1)
        WordEntity(id = 108811, setId = 1088, languagePair = "he-ru", rarity = "EPIC",
            original = "אֶנְדוֹסְקוֹפְּיָה", translation = "эндоскопия", transliteration = "endoskopya"),
        WordEntity(id = 108812, setId = 1088, languagePair = "he-ru", rarity = "EPIC",
            original = "כִּירוּרְגְיָה רוֹבּוֹטִית", translation = "роботизированная хирургия", transliteration = "khirurgia robotit"),
        WordEntity(id = 108813, setId = 1088, languagePair = "he-ru", rarity = "EPIC",
            original = "רְפוּאָה פַּלִּיאַטִיבִית", translation = "паллиативная медицина", transliteration = "refu'a paliatívit"),
        WordEntity(id = 108814, setId = 1088, languagePair = "he-ru", rarity = "EPIC",
            original = "אֶפִּדֶּמְיוֹלוֹגְיָה", translation = "эпидемиология", transliteration = "epidemyologia"),
        WordEntity(id = 108815, setId = 1088, languagePair = "he-ru", rarity = "EPIC",
            original = "אִמּוּנוֹתֶּרַפְּיָה", translation = "иммунотерапия", transliteration = "imunoterapya"),
        WordEntity(id = 108816, setId = 1088, languagePair = "he-ru", rarity = "EPIC",
            original = "מִיקְרוֹבִּיוֹם", translation = "микробиом", transliteration = "mikrobiom"),

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
            original = "פָּתוֹלוֹגְיָה", translation = "патология"),
        WordEntity(id = 108823, setId = 1088, languagePair = "he-ru", rarity = "EPIC",
            original = "פַּרְמַקוֹלוֹגְיָה", translation = "фармакология"),
        WordEntity(id = 108824, setId = 1088, languagePair = "he-ru", rarity = "EPIC",
            original = "בִּיוֹטֶכְנוֹלוֹגְיָה", translation = "биотехнология"),

        WordEntity(id = 108825, setId = 1088, languagePair = "he-ru", rarity = "EPIC",
            original = "הֲדָמָיָה רְפוּאִית", translation = "медицинская визуализация", transliteration = "hadamaya refu'it"),

        // ── Set 1089: Право ────────────────────────────────────────────────

        // RARE (B2)
        WordEntity(id = 108901, setId = 1089, languagePair = "he-ru", rarity = "RARE",
            original = "עֵד מוּמְחֶה", translation = "свидетель-эксперт", transliteration = "ed mumkhe"),
        WordEntity(id = 108902, setId = 1089, languagePair = "he-ru", rarity = "RARE",
            original = "חוּקַת יְסוֹד", translation = "основной закон; конституционный акт", transliteration = "khukkat yesod"),
        WordEntity(id = 108903, setId = 1089, languagePair = "he-ru", rarity = "RARE",
            original = "נְזִיקִין", translation = "деликтное право; причинение вреда", transliteration = "nezikin"),
        WordEntity(id = 108904, setId = 1089, languagePair = "he-ru", rarity = "RARE",
            original = "צַו מְנִיעָה", translation = "судебный запрет; инджанкшн", transliteration = "tsav meni'a"),
        WordEntity(id = 108905, setId = 1089, languagePair = "he-ru", rarity = "RARE",
            original = "פְּשָׁרָה", translation = "мировое соглашение; урегулирование", transliteration = "pshara"),
        WordEntity(id = 108906, setId = 1089, languagePair = "he-ru", rarity = "RARE",
            original = "נֶאֱמָן", translation = "доверенное лицо; фидуциарий", transliteration = "ne'eman"),
        WordEntity(id = 108907, setId = 1089, languagePair = "he-ru", rarity = "RARE",
            original = "עֵרְעוּר", translation = "апелляция", transliteration = "er'ur"),
        WordEntity(id = 108908, setId = 1089, languagePair = "he-ru", rarity = "RARE",
            original = "שִׁעְבּוּד", translation = "залог; обременение", transliteration = "shi'bud"),
        WordEntity(id = 108909, setId = 1089, languagePair = "he-ru", rarity = "RARE",
            original = "בִּיטוּל חוֹזֶה", translation = "расторжение договора", transliteration = "bitul khoza"),
        WordEntity(id = 108910, setId = 1089, languagePair = "he-ru", rarity = "RARE",
            original = "סַמְכוּת שִׁפּוּטִית", translation = "судебная компетенция", transliteration = "samkhut shiftutit"),

        // EPIC (C1)
        WordEntity(id = 108911, setId = 1089, languagePair = "he-ru", rarity = "EPIC",
            original = "עֶקְרוֹן הַמִּדָּתִיּוּת", translation = "принцип соразмерности", transliteration = "ikaron hamidatiyut"),
        WordEntity(id = 108912, setId = 1089, languagePair = "he-ru", rarity = "EPIC",
            original = "שְׁלִיטַת הַחוֹק", translation = "верховенство закона", transliteration = "shlitat hakhok"),
        WordEntity(id = 108913, setId = 1089, languagePair = "he-ru", rarity = "EPIC",
            original = "אַחְרָיוּת מוּגְבֶּלֶת", translation = "ограниченная ответственность", transliteration = "akhrayut mugbelet"),
        WordEntity(id = 108914, setId = 1089, languagePair = "he-ru", rarity = "EPIC",
            original = "מִשְׁפַּט חֻקְתִּי", translation = "конституционное право", transliteration = "mishpat khuktí"),
        WordEntity(id = 108915, setId = 1089, languagePair = "he-ru", rarity = "EPIC",
            original = "זְכוּיוֹת הַנֶּאֱשָׁם", translation = "права обвиняемого", transliteration = "zkhuyot hane'esham"),
        WordEntity(id = 108916, setId = 1089, languagePair = "he-ru", rarity = "EPIC",
            original = "עִקְרוֹן הַחֻקִּיּוּת", translation = "принцип законности", transliteration = "ikaron hakhukiyut"),

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

        WordEntity(id = 108925, setId = 1089, languagePair = "he-ru", rarity = "EPIC",
            original = "הִסְכֵּם כּוֹבֵל", translation = "ограничительное соглашение", transliteration = "hiskem kové'l"),

        // ── Set 1090: Литература ───────────────────────────────────────────

        // UNCOMMON (A2-B1)
        WordEntity(id = 109001, setId = 1090, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גִּבּוֹר", translation = "главный герой; протагонист", transliteration = "gibor"),
        WordEntity(id = 109002, setId = 1090, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עֶלִילָה", translation = "сюжет", transliteration = "elila"),
        WordEntity(id = 109003, setId = 1090, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אֶפִּילוֹג", translation = "эпилог", transliteration = "epilog"),
        WordEntity(id = 109004, setId = 1090, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טְרַגֶּדְיָה", translation = "трагедия", transliteration = "tragedia"),
        WordEntity(id = 109005, setId = 1090, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סוֹנֶט", translation = "сонет", transliteration = "sonet"),
        WordEntity(id = 109006, setId = 1090, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פּוֹאֶזְיָה", translation = "поэзия", transliteration = "poeziya"),

        // UNCOMMON (A2-B1)
        WordEntity(id = 109007, setId = 1090, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אַלֶּגוֹרְיָה", translation = "аллегория"),
        WordEntity(id = 109008, setId = 1090, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תֵּמָה", translation = "тема (литературная)"),
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

        WordEntity(id = 109022, setId = 1090, languagePair = "he-ru", rarity = "RARE",
            original = "אֶסְתֶּטִיקָה", translation = "эстетика", transliteration = "estetika"),
        WordEntity(id = 109023, setId = 1090, languagePair = "he-ru", rarity = "RARE",
            original = "נַטוּרָלִיזְם", translation = "натурализм (литературное течение)", transliteration = "naturalizm"),
        WordEntity(id = 109024, setId = 1090, languagePair = "he-ru", rarity = "RARE",
            original = "רוֹמַנְטִיזְם", translation = "романтизм", transliteration = "romantizm"),
        WordEntity(id = 109025, setId = 1090, languagePair = "he-ru", rarity = "RARE",
            original = "פַּתּוֹס", translation = "пафос; патетика", transliteration = "pathos"),
    )
}
