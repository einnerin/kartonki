package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — Religion L1 (set 1701).
 * 25 базовых слов иудаизма уровня A1-A2: синагога, шабат, основные праздники,
 * кошер, мезуза, Йом Кипур, Мессия, душа, рай, ангелы и т.д.
 *
 * Дубли с существующими сетами темы «Религия» (1053, 1070, 1071, 1282, 1283, 1284)
 * проверены вручную — пересечений нет.
 *
 * Все слова помечены isFillInBlankSafe = false: ивритская морфология делает
 * автоматический blank небезопасным; FILL_IN_BLANK по этому набору будет
 * включён после прохода LLM-pipeline'ом и расстановки fillInBlankExclusions.
 */
object WordDataHebrewReligionL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1701, languagePair = "he-ru", orderIndex = 201,
            name = "Религия",
            description = "Базовые понятия иудаизма: молитва, праздники, синагога",
            topic = "Религия", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ════════════════════════════════════════════════════════════════════
        // Set 1701 — Религия: основы (level 1, COMMON+UNCOMMON)
        // 7 групп × 2-6 слов: synagogue, shabbat, kashrut, holidays,
        //                      high_holy, soul, people
        // 15 COMMON + 10 UNCOMMON
        // ════════════════════════════════════════════════════════════════════

        // ── religion_synagogue (4 — COMMON) ──
        WordEntity(
            id = 170101, setId = 1701, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "religion_synagogue", transliteration = "beit kneset",
            original = "בֵּית כְּנֶסֶת", translation = "синагога",
            definition = "מָקוֹם תְּפִלָּה וְלִמּוּד שֶׁל קְהִלָּה יְהוּדִית.",
            definitionNative = "Здание для еврейских молитв и совместного изучения Торы.",
            example = "בַּשַּׁבָּת אֲנַחְנוּ הוֹלְכִים לַבֵּית הַכְּנֶסֶת.",
            exampleNative = "В субботу мы идём в בֵּית כְּנֶסֶת.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 170102, setId = 1701, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "religion_synagogue", transliteration = "mezuza",
            original = "מְזוּזָה", translation = "мезуза (свиток на дверном косяке)",
            definition = "קַלָּף קָטָן עִם פְּסוּקֵי תּוֹרָה הַמְצַמָּד לִמְזוּזַת הַדֶּלֶת.",
            definitionNative = "Маленький пергамент с отрывками из Торы, прикреплённый к дверному косяку.",
            example = "אִמָּא נוֹשֶׁקֶת לַמְּזוּזָה לִפְנֵי הַיְּצִיאָה.",
            exampleNative = "Мама целует מְזוּזָה перед выходом из дома.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 170103, setId = 1701, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "religion_synagogue", transliteration = "brakha",
            original = "בְּרָכָה", translation = "благословение",
            definition = "אֲמִירָה דָּתִית קְצָרָה לְהוֹדוֹת לֶאֱלֹהִים עַל מַשֶּׁהוּ.",
            definitionNative = "Короткое религиозное слово благодарности Богу за пищу или событие.",
            example = "אַבָּא אוֹמֵר בְּרָכָה לִפְנֵי הָאֲרוּחָה.",
            exampleNative = "Папа произносит בְּרָכָה перед едой.",
         fillInBlankExclusions = listOf(170101L, 170102L, 170104L)),
        WordEntity(
            id = 170104, setId = 1701, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "religion_synagogue", transliteration = "ner",
            original = "נֵר", translation = "свеча",
            definition = "מָקוֹר אוֹר קָטָן הַמֻּצַּת לִכְבוֹד שַׁבָּת אוֹ חַג.",
            definitionNative = "Маленький источник света, который зажигают в честь субботы или праздника.",
            example = "סָבְתָא מַדְלִיקָה נֵר בְּעֶרֶב שַׁבָּת.",
            exampleNative = "Бабушка зажигает נֵר накануне субботы.",
         fillInBlankExclusions = listOf(170101L, 170102L, 170103L)),

        // ── religion_shabbat (3 — 2 COMMON + 1 UNCOMMON) ──
        WordEntity(
            id = 170105, setId = 1701, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "religion_shabbat", transliteration = "shabat",
            original = "שַׁבָּת", translation = "шабат, суббота",
            definition = "הַיּוֹם הַשְּׁבִיעִי בַּשָּׁבוּעַ — יוֹם מְנוּחָה וּקְדוּשָׁה.",
            definitionNative = "Седьмой день недели, день покоя и святости в иудаизме.",
            example = "בַּשַּׁבָּת אֲנַחְנוּ לֹא עוֹבְדִים.",
            exampleNative = "В שַׁבָּת мы не работаем.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 170106, setId = 1701, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "religion_shabbat", transliteration = "khala",
            original = "חַלָּה", translation = "хала (праздничный хлеб)",
            definition = "לֶחֶם קָלוּעַ מִיוֹחָד הַנֶּאֱכָל בִּסְעוּדַת שַׁבָּת אוֹ חַג.",
            definitionNative = "Особый плетёный хлеб, который едят за субботним или праздничным столом.",
            example = "אִמָּא אוֹפָה שְׁתֵּי חַלּוֹת לְכָל שַׁבָּת.",
            exampleNative = "Мама печёт две חַלָּה на каждую субботу.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 170107, setId = 1701, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "religion_shabbat", transliteration = "kabalat shabat",
            original = "קַבָּלַת שַׁבָּת", translation = "встреча субботы (вечерняя служба)",
            definition = "סֵדֶר תְּפִלָּה קָצָר שֶׁאוֹמְרִים בְּעֶרֶב שַׁבָּת לְקַבֵּל אֶת הַשַּׁבָּת.",
            definitionNative = "Короткая вечерняя служба для встречи наступающей субботы.",
            example = "קַבָּלַת שַׁבָּת מַתְחִילָה עִם שְׁקִיעַת הַחַמָּה.",
            exampleNative = "קַבָּלַת שַׁבָּת начинается с заходом солнца.",
         fillInBlankExclusions = listOf(170105L, 170106L)),

        // ── religion_kashrut (2 — 1 COMMON + 1 UNCOMMON; антонимическая пара) ──
        WordEntity(
            id = 170108, setId = 1701, languagePair = "he-ru", rarity = "COMMON",
            pos = "adjective", semanticGroup = "religion_kashrut", transliteration = "kasher",
            original = "כָּשֵׁר", translation = "кошерный (разрешённый по закону)",
            definition = "מַתְאִים לַחֻקֵּי הָאֲכִילָה הַיְּהוּדִיִּים, מֻתָּר לַאֲכִילָה.",
            definitionNative = "Соответствующий еврейским пищевым законам и разрешённый к употреблению.",
            example = "בַּמִּסְעָדָה הַזֹּאת כָּל הָאֹכֶל כָּשֵׁר.",
            exampleNative = "В этом ресторане вся еда — כָּשֵׁר.",
         fillInBlankExclusions = listOf(170118L)),
        WordEntity(
            id = 170109, setId = 1701, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "religion_kashrut", transliteration = "kashrut",
            original = "כַּשְׁרוּת", translation = "кашрут (свод пищевых законов)",
            definition = "מַעֲרֶכֶת הַחֻקִּים שֶׁקּוֹבַעַת אֵיזֶה אֹכֶל מֻתָּר לִיהוּדִים.",
            definitionNative = "Свод религиозных правил о том, какую пищу разрешено есть евреям.",
            example = "הַמַּשְׁגִּיחַ בּוֹדֵק אֶת הַכַּשְׁרוּת בַּמִּטְבָּח.",
            exampleNative = "Машгиах проверяет כַּשְׁרוּת на кухне.",
        ),

        // ── religion_holidays (6 — COMMON; основные праздники цикла) ──
        WordEntity(
            id = 170110, setId = 1701, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "religion_holidays", transliteration = "khag",
            original = "חַג", translation = "праздник (религиозный)",
            definition = "יוֹם דָּתִי מְיֻחָד שֶׁבּוֹ עוֹשִׂים סְעוּדָה וְאוֹמְרִים בְּרָכוֹת.",
            definitionNative = "Особый религиозный день с праздничной трапезой и благословениями.",
            example = "כָּל מִשְׁפָּחָה אוֹסְפִים לְכָל חַג גָּדוֹל.",
            exampleNative = "Вся семья собирается на каждый большой חַג.",
         fillInBlankExclusions = listOf(170111L, 170112L, 170113L, 170114L, 170115L)),
        WordEntity(
            id = 170111, setId = 1701, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "religion_holidays", transliteration = "pesakh",
            original = "פֶּסַח", translation = "Песах (еврейская Пасха)",
            definition = "חַג הָאָבִיב הַמְצַיֵּן אֶת יְצִיאַת מִצְרַיִם וְהַחֵרוּת.",
            definitionNative = "Весенний праздник в память об исходе евреев из Египта и обретении свободы.",
            example = "בְּלֵיל פֶּסַח קוֹרְאִים אֶת הַהַגָּדָה.",
            exampleNative = "В пасхальный вечер читают פֶּסַח-Агаду.",
         fillInBlankExclusions = listOf(170110L, 170112L, 170113L, 170114L, 170115L)),
        WordEntity(
            id = 170112, setId = 1701, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "religion_holidays", transliteration = "khanuka",
            original = "חֲנֻכָּה", translation = "Ханука (праздник огней)",
            definition = "חַג שְׁמוֹנָה יָמִים לְזֵכֶר הַנֵס שֶׁל הַשֶּׁמֶן בְּבֵית הַמִּקְדָּשׁ.",
            definitionNative = "Восьмидневный праздник в память чуда с маслом в Иерусалимском Храме.",
            example = "בַּחֲנֻכָּה יְלָדִים מְקַבְּלִים מַתָּנוֹת וּמְשַׂחֲקִים בִּסְבִיבוֹן.",
            exampleNative = "В חֲנֻכָּה дети получают подарки и крутят волчок.",
         fillInBlankExclusions = listOf(170110L, 170111L, 170113L, 170114L, 170115L)),
        WordEntity(
            id = 170113, setId = 1701, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "religion_holidays", transliteration = "purim",
            original = "פּוּרִים", translation = "Пурим (праздник жребия)",
            definition = "חַג שִׂמְחָה הַמְצַיֵּן אֶת הַצָּלַת הַיְּהוּדִים מִידֵי הָמָן.",
            definitionNative = "Весёлый праздник в память спасения евреев Персии от планов Амана.",
            example = "יְלָדִים מִתְחַפְּשִׂים בְּפּוּרִים וְאוֹכְלִים אָזְנֵי הָמָן.",
            exampleNative = "Дети наряжаются на פּוּרִים и едят треугольные пирожки.",
         fillInBlankExclusions = listOf(170110L, 170111L, 170112L, 170114L, 170115L)),
        WordEntity(
            id = 170114, setId = 1701, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "religion_holidays", transliteration = "sukot",
            original = "סוּכּוֹת", translation = "Суккот (праздник кущей)",
            definition = "חַג שִׁבְעַת יָמִים בַּסְּתָו, בּוֹ גָּרִים בְּסוּכּוֹת זְמַנִּיּוֹת.",
            definitionNative = "Семидневный осенний праздник, во время которого живут во временных шалашах.",
            example = "בְּסוּכּוֹת אוֹכְלִים וְיָשְׁנִים בַּסֻּכָּה.",
            exampleNative = "В סוּכּוֹת едят и спят в шалаше-сукке.",
         fillInBlankExclusions = listOf(170110L, 170111L, 170112L, 170113L, 170115L)),
        WordEntity(
            id = 170115, setId = 1701, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "religion_holidays", transliteration = "rosh hashana",
            original = "רֹאשׁ הַשָּׁנָה", translation = "Рош ха-Шана (еврейский Новый год)",
            definition = "רֵאשִׁית הַשָּׁנָה הַיְּהוּדִית, בָּהּ תּוֹקְעִים בַּשּׁוֹפָר.",
            definitionNative = "Начало еврейского года, когда трубят в шофар и едят сладкое.",
            example = "בְּרֹאשׁ הַשָּׁנָה טוֹבְלִים תַּפּוּחַ בִּדְבַשׁ.",
            exampleNative = "На רֹאשׁ הַשָּׁנָה макают яблоко в мёд.",
         fillInBlankExclusions = listOf(170110L, 170111L, 170112L, 170113L, 170114L)),

        // ── religion_high_holy (3 — UNCOMMON; день искупления и связанные понятия) ──
        WordEntity(
            id = 170116, setId = 1701, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "religion_high_holy", transliteration = "yom kipur",
            original = "יוֹם כִּפּוּר", translation = "Йом Кипур (День искупления)",
            definition = "הַיּוֹם הַקָּדוֹשׁ בְּיוֹתֵר בַּשָּׁנָה הַיְּהוּדִית, יוֹם צוֹם וּתְפִלָּה.",
            definitionNative = "Самый святой день еврейского года, день поста и покаянных молитв.",
            example = "בְּיוֹם כִּפּוּר כָּל הַמְּדִינָה שׁוֹתֶקֶת.",
            exampleNative = "В יוֹם כִּפּוּר вся страна замирает.",
         fillInBlankExclusions = listOf(170117L)),
        WordEntity(
            id = 170117, setId = 1701, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "religion_high_holy", transliteration = "khet",
            original = "חֵטְא", translation = "грех (религиозный проступок)",
            definition = "מַעֲשֶׂה אֲסוּר עַל פִּי הַתּוֹרָה אוֹ נְגֶד רְצוֹן הָאֵל.",
            definitionNative = "Поступок, запрещённый Торой или противоречащий воле Всевышнего.",
            example = "אָדָם מִתְחָרֵט עַל הַחֵטְא שֶׁעָשָׂה.",
            exampleNative = "Человек раскаивается в совершённом חֵטְא.",
         fillInBlankExclusions = listOf(170116L)),
        WordEntity(
            id = 170118, setId = 1701, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "religion_high_holy", transliteration = "kadosh",
            original = "קָדוֹשׁ", translation = "святой, священный",
            definition = "מֻבְדָּל לְשִׁמּוּשׁ דָּתִי, בַּעַל מַעֲמָד מְיֻחָד וְעֶלְיוֹן.",
            definitionNative = "Выделенный для религиозного назначения, обладающий особым высшим статусом.",
            example = "יוֹם הַשַּׁבָּת קָדוֹשׁ לְעַם יִשְׂרָאֵל.",
            exampleNative = "Суббота — קָדוֹשׁ день для еврейского народа.",
            isFillInBlankSafe = false,
        ),

        // ── religion_soul (4 — 2 COMMON + 2 UNCOMMON; душа и потусторонний мир) ──
        WordEntity(
            id = 170119, setId = 1701, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "religion_soul", transliteration = "neshama",
            original = "נְשָׁמָה", translation = "душа",
            definition = "הַחֵלֶק הָרוּחָנִי בָּאָדָם שֶׁנִּתָּן עַל יְדֵי הָאֵל.",
            definitionNative = "Духовная часть человека, дарованная ему Богом по еврейскому учению.",
            example = "כָּל אָדָם יֵשׁ לוֹ נְשָׁמָה אַחַת.",
            exampleNative = "У каждого человека одна נְשָׁמָה.",
         fillInBlankExclusions = listOf(170120L, 170121L, 170122L)),
        WordEntity(
            id = 170120, setId = 1701, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "religion_soul", transliteration = "shamayim",
            original = "שָׁמַיִם", translation = "небеса (религ. место Бога)",
            definition = "הַמָּקוֹם הָעֶלְיוֹן בּוֹ שׁוֹכֵן הָאֵל לְפִי הָאֱמוּנָה.",
            definitionNative = "Высшее место, где, согласно религии, пребывает Всевышний.",
            example = "הוּא הִבִּיט לַשָּׁמַיִם וְהִתְפַּלֵּל.",
            exampleNative = "Он посмотрел в שָׁמַיִם и помолился.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 170121, setId = 1701, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "religion_soul", transliteration = "gan eden",
            original = "גַּן עֵדֶן", translation = "райский сад, рай",
            definition = "הַמָּקוֹם בַּשָּׁמַיִם בּוֹ נִמְצָאוֹת נִשְׁמוֹת הַצַּדִּיקִים.",
            definitionNative = "Райское место на небесах, где обитают души праведников.",
            example = "סָבָא שֶׁלִּי בְּגַן עֵדֶן עַכְשָׁו.",
            exampleNative = "Мой дедушка теперь в גַּן עֵדֶן.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 170122, setId = 1701, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "religion_soul", transliteration = "mashi'akh",
            original = "מָשִׁיחַ", translation = "Мессия (избавитель)",
            definition = "הַמְּלֶךְ הָרוּחָנִי שֶׁיָּבוֹא לִגְאֹל אֶת עַם יִשְׂרָאֵל בְּעָתִיד.",
            definitionNative = "Духовный царь, который, по вере, придёт избавить народ Израиля в будущем.",
            example = "הוּא מַאֲמִין שֶׁהַמָּשִׁיחַ קָרוֹב לָבוֹא.",
            exampleNative = "Он верит, что מָשִׁיחַ скоро придёт.",
            isFillInBlankSafe = false,
        ),

        // ── religion_people (3 — UNCOMMON; религиозные фигуры и предки) ──
        WordEntity(
            id = 170123, setId = 1701, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "religion_people", transliteration = "navi",
            original = "נָבִיא", translation = "пророк",
            definition = "אִישׁ שֶׁמּוֹסֵר אֶת דְּבַר הָאֵל לָעָם וּמַזְהִיר אוֹתָם.",
            definitionNative = "Человек, который передаёт народу слова Бога и предупреждает о грядущем.",
            example = "מֹשֶׁה רַבֵּנוּ הָיָה הַנָּבִיא הַגָּדוֹל בְּיוֹתֵר.",
            exampleNative = "Моисей был величайшим נָבִיא.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 170124, setId = 1701, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "religion_people", transliteration = "rebi",
            original = "רֶבִּי", translation = "ребе (хасидский лидер)",
            definition = "מַנְהִיג רוּחָנִי שֶׁל קְהִלָּה חֲסִידִית, מוֹרֶה דֶּרֶךְ לְתַלְמִידָיו.",
            definitionNative = "Духовный лидер хасидской общины и наставник своих последователей.",
            example = "הַחֲסִידִים נוֹסְעִים אֶל הָרֶבִּי לְבָרֵךְ.",
            exampleNative = "Хасиды едут к רֶבִּי за благословением.",
         fillInBlankExclusions = listOf(170123L, 170125L)),
        WordEntity(
            id = 170125, setId = 1701, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "religion_people", transliteration = "avot",
            original = "אָבוֹת", translation = "праотцы (Авраам, Исаак, Иаков)",
            definition = "שְׁלוֹשֶׁת מְיַסְּדֵי הָעָם הַיְּהוּדִי: אַבְרָהָם, יִצְחָק וְיַעֲקֹב.",
            definitionNative = "Три основоположника еврейского народа: Авраам, Исаак и Иаков.",
            example = "מְזַכִּירִים אֶת הָאָבוֹת בִּתְפִלַּת עֲמִידָה.",
            exampleNative = "Имена אָבוֹת упоминают в молитве Амида.",
         fillInBlankExclusions = listOf(170123L, 170124L)),
    )
}
