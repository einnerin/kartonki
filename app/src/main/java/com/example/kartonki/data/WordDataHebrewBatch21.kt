package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrewBatch21 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1085, languagePair = "he-ru", orderIndex = 1085,
            name = "Спорт: продвинутый",
            description = "Соревнования, тактика и спортивная психология",
            topic = "Спорт",
            level = 2
        ),
        WordSetEntity(
            id = 1086, languagePair = "he-ru", orderIndex = 1086,
            name = "Архитектура: продвинутый",
            description = "Стили, конструкции и городская среда",
            topic = "Архитектура",
            level = 2
        ),
        WordSetEntity(
            id = 1087, languagePair = "he-ru", orderIndex = 1087,
            name = "Психология: профессиональный",
            description = "Психоанализ, когниция и защитные механизмы",
            topic = "Психология",
            level = 3
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Set 1085: Спорт: углублённо ────────────────────────────────────

        // COMMON (A1)
        WordEntity(id = 108501, setId = 1085, languagePair = "he-ru", rarity = "COMMON",
            original = "אַתְלֵט", translation = "атлет, спортсмен"),
        WordEntity(id = 108502, setId = 1085, languagePair = "he-ru", rarity = "COMMON",
            original = "כּוֹשֶׁר", translation = "физическая форма, фитнес"),
        WordEntity(id = 108503, setId = 1085, languagePair = "he-ru", rarity = "COMMON",
            original = "קְבוּצָה", translation = "команда"),
        WordEntity(id = 108504, setId = 1085, languagePair = "he-ru", rarity = "COMMON",
            original = "נִיצָּחוֹן", translation = "победа, победный результат"),
        WordEntity(id = 108505, setId = 1085, languagePair = "he-ru", rarity = "COMMON",
            original = "אִצְטַדְיוֹן", translation = "стадион"),
        WordEntity(id = 108506, setId = 1085, languagePair = "he-ru", rarity = "COMMON",
            original = "גְּמַר", translation = "финал"),

        // UNCOMMON (A2-B1)
        WordEntity(id = 108507, setId = 1085, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אַלּוּף", translation = "чемпион"),
        WordEntity(id = 108508, setId = 1085, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טוּרְנִיר", translation = "турнир"),
        WordEntity(id = 108509, setId = 1085, languagePair = "he-ru", rarity = "COMMON",
            original = "אֵירוֹבִּיקָה", translation = "аэробика"),
        WordEntity(id = 108510, setId = 1085, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חֲצִי גָּמַר", translation = "полуфинал"),
        WordEntity(id = 108511, setId = 1085, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גְּמַר גָּבִיעַ", translation = "финал Кубка"),
        WordEntity(id = 108512, setId = 1085, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רֶקוֹרְד עוֹלָמִי", translation = "мировой рекорд"),
        WordEntity(id = 108513, setId = 1085, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טַקְטִיקָה", translation = "тактика"),
        WordEntity(id = 108514, setId = 1085, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אוֹלִימְפִּיאָדָה", translation = "Олимпиада"),
        WordEntity(id = 108515, setId = 1085, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אַתְלֶטִיקָה", translation = "лёгкая атлетика"),
        WordEntity(id = 108516, setId = 1085, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חֲנִינַת אִיגְרוּף", translation = "боксёрский поединок"),

        // RARE (B2)
        WordEntity(id = 108517, setId = 1085, languagePair = "he-ru", rarity = "RARE",
            original = "דּוֹפִינְג", translation = "допинг"),
        WordEntity(id = 108518, setId = 1085, languagePair = "he-ru", rarity = "RARE",
            original = "סְפּוֹרְטִיבִיּוּת", translation = "спортивное поведение, честная игра"),
        WordEntity(id = 108519, setId = 1085, languagePair = "he-ru", rarity = "RARE",
            original = "אַרְגּוֹנוֹמִיָּה", translation = "эргономика (в спорте)"),
        WordEntity(id = 108520, setId = 1085, languagePair = "he-ru", rarity = "RARE",
            original = "פְּסִיכוֹלוֹגִיָּה סְפּוֹרְטִיבִית", translation = "спортивная психология"),
        WordEntity(id = 108521, setId = 1085, languagePair = "he-ru", rarity = "RARE",
            original = "זוֹן", translation = "зона (состояние потока в спорте)"),

        // EPIC (C1)
        WordEntity(id = 108522, setId = 1085, languagePair = "he-ru", rarity = "EPIC",
            original = "סִינֶרְגְּיָה סְפּוֹרְטִיבִית", translation = "спортивная синергия (слаженность команды)"),
        WordEntity(id = 108523, setId = 1085, languagePair = "he-ru", rarity = "EPIC",
            original = "פְּרֵסְטֵיז", translation = "престиж (соревнования высокого уровня)"),
        WordEntity(id = 108524, setId = 1085, languagePair = "he-ru", rarity = "EPIC",
            original = "גּוּף וְנֶפֶשׁ", translation = "тело и душа (холистический подход в спорте)"),

        // LEGENDARY (C2)
        WordEntity(id = 108525, setId = 1085, languagePair = "he-ru", rarity = "EPIC",
            original = "תֵּיאוֹרִיַּת הַזְּרִימָה", translation = "теория потока (Чиксентмихайи)"),

        // ── Set 1086: Архитектура ──────────────────────────────────────────

        // COMMON (A1)
        WordEntity(id = 108601, setId = 1086, languagePair = "he-ru", rarity = "COMMON",
            original = "אָרְכִיטֶקְטוּרָה", translation = "архитектура"),
        WordEntity(id = 108602, setId = 1086, languagePair = "he-ru", rarity = "COMMON",
            original = "מָבְנָה", translation = "строение, здание"),
        WordEntity(id = 108603, setId = 1086, languagePair = "he-ru", rarity = "COMMON",
            original = "חֲלַל", translation = "пространство, помещение"),
        WordEntity(id = 108604, setId = 1086, languagePair = "he-ru", rarity = "COMMON",
            original = "תּוֹכְנִית", translation = "план, чертёж"),
        WordEntity(id = 108605, setId = 1086, languagePair = "he-ru", rarity = "COMMON",
            original = "עַמּוּד", translation = "колонна, столб"),
        WordEntity(id = 108606, setId = 1086, languagePair = "he-ru", rarity = "COMMON",
            original = "כִּיפָּה", translation = "купол"),

        // UNCOMMON (A2-B1)
        WordEntity(id = 108607, setId = 1086, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חֲזִית", translation = "фасад здания"),
        WordEntity(id = 108608, setId = 1086, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חוֹמֶר בְּנִיָּה", translation = "строительный материал"),
        WordEntity(id = 108609, setId = 1086, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גּוֹרֶד שְׁחָקִים", translation = "небоскрёб"),
        WordEntity(id = 108610, setId = 1086, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "בִּנְיָן צִיבּוּרִי", translation = "общественное здание"),
        WordEntity(id = 108611, setId = 1086, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מוֹנוּמֶנְט", translation = "монумент, памятник"),
        WordEntity(id = 108612, setId = 1086, languagePair = "he-ru", rarity = "RARE",
            original = "בַּאְרוֹקוֹ", translation = "барокко (архитектурный стиль)"),
        WordEntity(id = 108613, setId = 1086, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "גּוֹתִי", translation = "готический (стиль)"),
        WordEntity(id = 108614, setId = 1086, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קוֹנְסְטְרוּקְצִיָּה", translation = "конструкция, несущая система"),
        WordEntity(id = 108615, setId = 1086, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תִּכְנוּן עִיר", translation = "городское планирование"),
        WordEntity(id = 108616, setId = 1086, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שִׁימּוּר אֲתָרִים", translation = "охрана исторических памятников"),

        // RARE (B2)
        WordEntity(id = 108617, setId = 1086, languagePair = "he-ru", rarity = "RARE",
            original = "אֶסְתֵּטִיקָה", translation = "эстетика"),
        WordEntity(id = 108618, setId = 1086, languagePair = "he-ru", rarity = "RARE",
            original = "אוּרְבַּנִיזְם", translation = "урбанизм"),
        WordEntity(id = 108619, setId = 1086, languagePair = "he-ru", rarity = "RARE",
            original = "מִינִימַלִיזְם", translation = "минимализм"),
        WordEntity(id = 108620, setId = 1086, languagePair = "he-ru", rarity = "RARE",
            original = "פוּנְקְצְיוֹנַלִיזְם", translation = "функционализм"),
        WordEntity(id = 108621, setId = 1086, languagePair = "he-ru", rarity = "RARE",
            original = "קְלַסִיצִיזְם", translation = "классицизм"),

        // EPIC (C1)
        WordEntity(id = 108622, setId = 1086, languagePair = "he-ru", rarity = "EPIC",
            original = "בּוֹהָאוּס", translation = "Баухаус (модернистское движение в дизайне)"),
        WordEntity(id = 108623, setId = 1086, languagePair = "he-ru", rarity = "EPIC",
            original = "אַרְ-נוּבוֹ", translation = "ар-нуво (стиль модерн)"),
        WordEntity(id = 108624, setId = 1086, languagePair = "he-ru", rarity = "EPIC",
            original = "קוֹנְסְטְרוּקְטִיבִיזְם", translation = "конструктивизм"),

        // LEGENDARY (C2)
        WordEntity(id = 108625, setId = 1086, languagePair = "he-ru", rarity = "EPIC",
            original = "דֶּקוֹנְסְטְרוּקְטִיבִיזְם", translation = "деконструктивизм (Деррида, Гери)"),

        // ── Set 1087: Психология: углублённо ──────────────────────────────

        // COMMON (A1)
        WordEntity(id = 108701, setId = 1087, languagePair = "he-ru", rarity = "COMMON",
            original = "פָּסִיכוֹלוֹגִיָּה", translation = "психология"),
        WordEntity(id = 108702, setId = 1087, languagePair = "he-ru", rarity = "COMMON",
            original = "הִתְנְהַגּוּת", translation = "поведение"),
        WordEntity(id = 108703, setId = 1087, languagePair = "he-ru", rarity = "COMMON",
            original = "אֶגוֹ", translation = "эго"),
        WordEntity(id = 108704, setId = 1087, languagePair = "he-ru", rarity = "COMMON",
            original = "קוֹגְנִיצְיָה", translation = "когниция, познание"),
        WordEntity(id = 108705, setId = 1087, languagePair = "he-ru", rarity = "COMMON",
            original = "אֶמְפַּתְיָה", translation = "эмпатия"),
        WordEntity(id = 108706, setId = 1087, languagePair = "he-ru", rarity = "COMMON",
            original = "טִיפּוּל פְּסִיכוֹלוֹגִי", translation = "психологическое лечение, терапия"),

        // UNCOMMON (A2-B1)
        WordEntity(id = 108707, setId = 1087, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תַּת-מוּדָע", translation = "подсознание"),
        WordEntity(id = 108708, setId = 1087, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַדְחָקָה", translation = "вытеснение (защитный механизм)"),
        WordEntity(id = 108709, setId = 1087, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַשְׁלָכָה", translation = "проекция (перенос чувств на другого)"),
        WordEntity(id = 108710, setId = 1087, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מֶנְגְּנוֹן הֲגָנָה", translation = "защитный механизм"),
        WordEntity(id = 108711, setId = 1087, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רֵזִילִיֶּנְס", translation = "жизнестойкость, резилиентность"),
        WordEntity(id = 108712, setId = 1087, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "רֶגוּלַצְיָה רְגָשִׁית", translation = "эмоциональная регуляция"),
        WordEntity(id = 108713, setId = 1087, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פְּסִיכוֹאַנָלִיזָה", translation = "психоанализ"),
        WordEntity(id = 108714, setId = 1087, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אַרְכֶּטִיפּ", translation = "архетип (Юнг)"),
        WordEntity(id = 108715, setId = 1087, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פְּרוֹיֶקְצְיָה", translation = "проекция (психол.)"),
        WordEntity(id = 108716, setId = 1087, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סוּבְּלִימֵישֶׁן", translation = "сублимация"),

        // RARE (B2)
        WordEntity(id = 108717, setId = 1087, languagePair = "he-ru", rarity = "RARE",
            original = "הֲיוֹרִיסְטִיקָה", translation = "эвристика (когнитивные сокращения)"),
        WordEntity(id = 108718, setId = 1087, languagePair = "he-ru", rarity = "RARE",
            original = "הֲטָיָה קוֹגְנִיטִיבִית", translation = "когнитивное искажение"),
        WordEntity(id = 108719, setId = 1087, languagePair = "he-ru", rarity = "RARE",
            original = "אַטַּצ'מֶנְט", translation = "теория привязанности"),
        WordEntity(id = 108720, setId = 1087, languagePair = "he-ru", rarity = "RARE",
            original = "פְּסִיכוֹפָּתוֹלוֹגִיָּה", translation = "психопатология"),
        WordEntity(id = 108721, setId = 1087, languagePair = "he-ru", rarity = "RARE",
            original = "הַפְרָעַת אִישִׁיּוּת", translation = "расстройство личности"),

        // EPIC (C1)
        WordEntity(id = 108722, setId = 1087, languagePair = "he-ru", rarity = "EPIC",
            original = "פְּסִיכוֹדִינַמִיקָה", translation = "психодинамика"),
        WordEntity(id = 108723, setId = 1087, languagePair = "he-ru", rarity = "EPIC",
            original = "לָא-מוּדָע קוֹלֶקְטִיבִי", translation = "коллективное бессознательное (Юнг)"),
        WordEntity(id = 108724, setId = 1087, languagePair = "he-ru", rarity = "EPIC",
            original = "תַּסְמֹנֶת הָאִמְפּוֹסְטוֹר", translation = "синдром самозванца"),

        // LEGENDARY (C2)
        WordEntity(id = 108725, setId = 1087, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "נְאוּרוֹפְּלַסְטִיוּת", translation = "нейропластичность"),
    )
}
