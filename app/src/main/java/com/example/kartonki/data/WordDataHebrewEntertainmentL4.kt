package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Развлечения и досуг" (level 4, профессиональный).
 *
 * Set 1794: «Развлечения и досуг» — профессиональный (L4, EPIC + LEGENDARY):
 *           продакшн, фестивали, gaming-индустрия, streaming, креативные индустрии.
 *
 * Слова не повторяются с EntertainmentL1L2L3 (1733, 1734, 1735): спидран и
 * инди-игра уже заняты в 1735, поэтому в gaming взяты microtransaction и
 * battle pass; вместо «бинж-вотчинг» в streaming — «массовый выпуск», чтобы
 * избежать однокоренных конструкций с צְפִיָּה внутри сета.
 *
 * Cross-set совпадения (допустимо — разные наборы одной темы):
 *   - פֶסְטִיבָל קוֹלְנוֹעַ (1794) пересекается шорешом с פֶסְטִיבָל (1734) — другая фраза.
 *   - אֶסְפּוֹרְט как часть טוּרְנִיר אֶסְפּוֹרְט (1794) — оригинал в 1735.
 *   - מְסִבַּת רֶשֶׁת (1794) — корень סבב, в 1733 есть מְסִבָּה. Разные originals.
 *
 * Распределение редкости: 13 EPIC + 12 LEGENDARY (спред 1, на границе L4-L5).
 *
 * SemanticGroups (5 × 5):
 *   entertainment_production   — חברת הפקות, מפקח עליון, איתור אתרים, פוסט פרודקשן, עיצוב צלילים
 *   entertainment_festivals    — פסטיבל קולנוע, בכורה עולמית, מבחר רשמי, רטרוספקטיבה, פרס הקהל
 *   entertainment_gaming       — טורניר אספורט, מיקרו-תשלום, בטל פאס, תוכן להורדה, מנוי עונתי
 *   entertainment_streaming    — פלטפורמת סטרימינג, סדרה מקורית, מסיבת רשת, שחרור מסיבי, דירוג צפיות
 *   entertainment_creative     — דוקטור תסריט, מנהל לוקיישן, אחראי ליהוק, אמן רעש, רכז אינטימיות
 *
 * Word IDs: setId × 100 + position (179401..179425).
 *
 * isFillInBlankSafe = false — все слова многословные термины, в FILL_IN_BLANK
 * пропуск создаётся механической заменой и для двусловных терминов «протекает»
 * либо неоднозначен. Pipeline позже подберёт exclusions и при необходимости
 * флипнет флаг в Phase 3.
 */
object WordDataHebrewEntertainmentL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1794, languagePair = "he-ru", orderIndex = 1794,
            name = "Развлечения и досуг",
            description = "Углублённый: производство, фестивали, gaming, streaming, креативные индустрии",
            topic = "Развлечения и досуг", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1794 — Развлечения и досуг: профессиональный (L4, EPIC+LEGENDARY)
        // 5 групп × 5 слов: production, festivals, gaming, streaming, creative
        // ══════════════════════════════════════════════════════════════════════

        // ── entertainment_production (5) — продакшн и индустрия ──
        WordEntity(
            id = 179401, setId = 1794, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_production", transliteration = "khevrat hafakot",
            original = "חֶבְרַת הַפָּקוֹת", translation = "продюсерская компания",
            definition = "פִירְמָה שֶׁמְּמַמֶּנֶת וּמְאַרְגֶּנֶת אֶת הַצִּלּוּם שֶׁל סְרָטִים אוֹ סִדְרוֹת.",
            definitionNative = "Фирма, что финансирует и организует съёмки фильмов или сериалов.",
            example = "חֶבְרַת הַפָּקוֹת קְטַנָּה צִלְּמָה אֶת הַסֵּרֶט הַתִּיעוּדִי בְּשִׁשָּׁה שָׁבוּעוֹת.",
            exampleNative = "Маленькая חֶבְרַת הַפָּקוֹת сняла документалку всего за шесть недель.",
         fillInBlankExclusions = listOf(179402L, 179403L, 179404L, 179405L)),
        WordEntity(
            id = 179402, setId = 1794, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "entertainment_production", transliteration = "mefakeakh elyon",
            original = "מְפַקֵּחַ עֶלְיוֹן", translation = "исполнительный продюсер",
            definition = "אִישׁ בָּכִיר שֶׁמַּשִּׂיג תַּקְצִיב וּמַנְהִיג אֶת כָּל הַפְּרוֹיֶיקְט מִתְּחִלָּה לַסּוֹף.",
            definitionNative = "Старший человек, что добывает бюджет и ведёт весь проект до конца.",
            example = "הַמְּפַקֵּחַ עֶלְיוֹן הִגִּיעַ לַסְּטוּדְיוֹ לְפַקֵּחַ עַל הַעֲרִיכָה הַסּוֹפִית.",
            exampleNative = "מְפַקֵּחַ עֶלְיוֹן прилетел в студию контролировать финальный монтаж.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179403, setId = 1794, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "entertainment_production", transliteration = "itur atarim",
            original = "אִתּוּר אֲתָרִים", translation = "поиск локаций",
            definition = "מְלָאכָה שֶׁל מְצִיאַת מְקוֹמוֹת אֲמִתִּיִּים שֶׁבָּהֶם נִתָּן לְצַלֵּם סֵרֶט.",
            definitionNative = "Работа по поиску реальных мест, где можно снимать кино.",
            example = "הֵם בִּלּוּ חֳדָשַׁיִם בְּאִתּוּר אֲתָרִים בִּכְפָרֵי הַגָּלִיל הָעֶלְיוֹן.",
            exampleNative = "Они два месяца провели на אִתּוּר אֲתָרִים в деревнях Верхней Галилеи.",
         fillInBlankExclusions = listOf(179401L, 179402L, 179404L, 179405L)),
        WordEntity(
            id = 179404, setId = 1794, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_production", transliteration = "post prodakshen",
            original = "פּוֹסְט פְּרוֹדַקְשֶׁן", translation = "постпродакшн",
            definition = "כָּל מַה שֶּׁעוֹשִׂים לַסֵּרֶט אַחֲרֵי הַצִּלּוּם — עֲרִיכָה, צֶבַע, מוּסִיקָה וְאֶפֶקְטִים.",
            definitionNative = "Всё, что делают с фильмом после съёмки — монтаж, цвет, музыка, эффекты.",
            example = "הַצֶּוֶת עֲדַיִן בְּפּוֹסְט פְּרוֹדַקְשֶׁן וְהַטְּרֵיילֶר יֵצֵא בַּחֹדֶשׁ הַבָּא.",
            exampleNative = "Команда ещё в פּוֹסְט פְּרוֹדַקְשֶׁן, а трейлер выйдет в следующем месяце.",
         fillInBlankExclusions = listOf(179401L, 179402L, 179403L, 179405L)),
        WordEntity(
            id = 179405, setId = 1794, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "entertainment_production", transliteration = "itsuv tslilim",
            original = "עִצּוּב צְלִילִים", translation = "саунд-дизайн",
            definition = "אָמָּנוּת שֶׁל בְּנִיַּת כָּל הָרְעָשִׁים וְהָאֲוִירָה שֶׁסֵּרֶט אוֹ מִשְׂחָק זָקוּק לָהֶם.",
            definitionNative = "Искусство создания всех шумов и атмосферы, нужных фильму или игре.",
            example = "עִצּוּב צְלִילִים מַצְמְרִיר הָפַךְ אֶת הַבִּקְתָּה לְמַפְחִידָה מֵהָרֶגַע הָרִאשׁוֹן.",
            exampleNative = "Жуткий עִצּוּב צְלִילִים делал хижину пугающей с первой минуты.",
         fillInBlankExclusions = listOf(179401L, 179402L, 179403L, 179404L)),

        // ── entertainment_festivals (5) — фестивали и премии ──
        WordEntity(
            id = 179406, setId = 1794, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_festivals", transliteration = "festival kolnoa",
            original = "פֶסְטִיבָל קוֹלְנוֹעַ", translation = "кинофестиваль",
            definition = "אֵרוּעַ שֶׁל יָמִים אֲחָדִים שֶׁבּוֹ מַצִּיגִים וְשׁוֹפְטִים סְרָטִים חֲדָשִׁים.",
            definitionNative = "Многодневное событие, где показывают и оценивают новые фильмы.",
            example = "סִרְטָהּ הָרִאשׁוֹן זָכָה בַּגָּבִיעַ בְּפֶסְטִיבָל קוֹלְנוֹעַ אֵירוֹפִּי קָטָן.",
            exampleNative = "Её дебют получил кубок на маленьком европейском פֶסְטִיבָל קוֹלְנוֹעַ.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179407, setId = 1794, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_festivals", transliteration = "bekhora olamit",
            original = "בְּכוֹרָה עוֹלָמִית", translation = "мировая премьера",
            definition = "הַהַקְרָנָה הַפּוּמְבִּית הָרִאשׁוֹנָה שֶׁל סֵרֶט בְּכָל מָקוֹם בָּעוֹלָם.",
            definitionNative = "Самый первый публичный показ фильма где-либо в мире.",
            example = "הַבְּכוֹרָה עוֹלָמִית הִתְקַיְּמָה בְּקַאן עִם הַשַּׂחְקָנִים עַל הַשָּׁטִיחַ הָאָדֹם.",
            exampleNative = "בְּכוֹרָה עוֹלָמִית прошла в Каннах с актёрами на красной дорожке.",
         fillInBlankExclusions = listOf(179406L, 179408L, 179410L)),
        WordEntity(
            id = 179408, setId = 1794, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "entertainment_festivals", transliteration = "mivkhar rishmi",
            original = "מִבְחָר רִשְׁמִי", translation = "официальная программа",
            definition = "רְשִׁימַת הַיְצִירוֹת שֶׁהַשּׁוֹפְטִים בָּחֲרוּ לְהִתְחָרוֹת בַּתּוֹכְנִית הַמֶּרְכָּזִית.",
            definitionNative = "Список работ, что жюри выбрало для конкурса основной программы.",
            example = "סִרְטָם הַקָּצָר נִכְנַס לְמִבְחָר רִשְׁמִי בִּשְׁלוֹשָׁה פֶסְטִיבָלִים גְּדוֹלִים.",
            exampleNative = "Их короткометражка попала в מִבְחָר רִשְׁמִי трёх крупных фестов.",
         fillInBlankExclusions = listOf(179406L, 179407L, 179410L)),
        WordEntity(
            id = 179409, setId = 1794, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "entertainment_festivals", transliteration = "retrospektiva",
            original = "רֶטְרוֹסְפֶּקְטִיבָה", translation = "ретроспектива",
            definition = "תּוֹכְנִית פֶסְטִיבָל הַחוֹזֶרֶת אֶל יְצִירוֹתָיו הַיְּשָׁנוֹת שֶׁל אָמָּן בִּמְקוֹם אֶחָד.",
            definitionNative = "Программа фестиваля, собирающая давние работы автора в одном месте.",
            example = "הַפֶסְטִיבָל נִפְתַּח בְּרֶטְרוֹסְפֶּקְטִיבָה שֶׁל סִרְטֵי הַבַּמַּאי הַמָּנוֹחַ.",
            exampleNative = "Фестиваль открыла רֶטְרוֹסְפֶּקְטִיבָה ранних фильмов покойного режиссёра.",
        ),
        WordEntity(
            id = 179410, setId = 1794, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "entertainment_festivals", transliteration = "pras hakahal",
            original = "פְּרָס הַקָּהָל", translation = "приз зрительских симпатий",
            definition = "פְּרָס פֶסְטִיבָל הַנִּבְחָר בְּהַצְבָּעַת הַצּוֹפִים וְלֹא עַל יְדֵי שׁוֹפְטִים.",
            definitionNative = "Награда фестиваля, выбираемая голосованием зрителей, а не жюри.",
            example = "הַקּוֹמֶדְיָה הָעָנְוָה לָקְחָה אֶת פְּרָס הַקָּהָל בָּעֶרֶב הַסִּיּוּם.",
            exampleNative = "Народная комедия унесла פְּרָס הַקָּהָל в закрывающий вечер.",
         fillInBlankExclusions = listOf(179406L, 179407L, 179408L)),

        // ── entertainment_gaming (5) — гейминг-индустрия ──
        WordEntity(
            id = 179411, setId = 1794, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_gaming", transliteration = "turnir esport",
            original = "טוּרְנִיר אֶסְפּוֹרְט", translation = "киберспортивный турнир",
            definition = "תַּחֲרוּת מִקְצוֹעִית שֶׁבָּהּ קְבוּצוֹת אוֹ שַׂחְקָנִים נִלְחָמִים עַל פְּרָסִים גְּדוֹלִים.",
            definitionNative = "Профессиональное соревнование, где команды или игроки бьются за крупные награды.",
            example = "הוּא טָס לְסֵאוּל לְטוּרְנִיר אֶסְפּוֹרְט עִם קֻפַּת פְּרָסִים שֶׁל מִילְיוֹן דּוֹלָר.",
            exampleNative = "Он полетел в Сеул на טוּרְנִיר אֶסְפּוֹרְט с миллионным призовым фондом.",
         fillInBlankExclusions = listOf(179412L, 179413L, 179414L, 179415L)),
        WordEntity(
            id = 179412, setId = 1794, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_gaming", transliteration = "mikro tashlum",
            original = "מִיקְרוֹ-תַּשְׁלוּם", translation = "микротранзакция",
            definition = "תַּשְׁלוּם זָעִיר בְּתוֹךְ הַמִּשְׂחָק עֲבוּר קִשּׁוּטִים, מַטְבֵּעוֹת אוֹ הֲטָבוֹת.",
            definitionNative = "Маленький платёж внутри игры за украшения, монеты или мелкие бонусы.",
            example = "מְבַקְּרִים תּוֹקְפִים אֶת הַסְּטוּדְיוֹ עַל הַסְתָּרַת צִיּוּד מֵאֲחוֹרֵי מִיקְרוֹ-תַּשְׁלוּם.",
            exampleNative = "Критики ругают студию за то, что снаряжение спрятано за מִיקְרוֹ-תַּשְׁלוּם.",
         fillInBlankExclusions = listOf(179411L, 179413L, 179414L, 179415L)),
        WordEntity(
            id = 179413, setId = 1794, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_gaming", transliteration = "batel pas",
            original = "בָּטֶל פַּאס", translation = "боевой пропуск",
            definition = "מַסְלוּל בְּתַשְׁלוּם שֶׁל פְּרָסִים עוֹנָתִיִּים שֶׁפּוֹתְחִים עַל יְדֵי מִשְׂחָק יוֹמִי.",
            definitionNative = "Платный трек сезонных наград, открывающихся за ежедневную игру.",
            example = "הוּא קָנָה בָּטֶל פַּאס חָדָשׁ כְּדֵי לְקַבֵּל אֶת מַעֲרֶכֶת הַסְּקִינִים הַנָּדִירָה.",
            exampleNative = "Он купил новый בָּטֶל פַּאס, чтобы получить редкий набор скинов.",
         fillInBlankExclusions = listOf(179411L, 179412L, 179414L, 179415L)),
        WordEntity(
            id = 179414, setId = 1794, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "entertainment_gaming", transliteration = "tokhen lehorada",
            original = "תּוֹכֶן לְהוֹרָדָה", translation = "загружаемый контент",
            definition = "מַשִּׂימוֹת, מַפּוֹת אוֹ פְּרִיטִים נוֹסָפִים שֶׁמּוֹסִיפִים לַמִּשְׂחָק אַחֲרֵי יְצִיאָתוֹ.",
            definitionNative = "Дополнительные миссии, карты или предметы, что добавляют к игре после релиза.",
            example = "תּוֹכֶן לְהוֹרָדָה חָדָשׁ הוֹסִיף אִי מֻשְׁלָג וּשְׁלוֹשָׁה קְרָבוֹת בּוֹסִים אַכְזָרִיִּים.",
            exampleNative = "Новый תּוֹכֶן לְהוֹרָדָה добавил снежный остров и три суровых битвы с боссами.",
         fillInBlankExclusions = listOf(179411L, 179412L, 179413L, 179415L)),
        WordEntity(
            id = 179415, setId = 1794, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "entertainment_gaming", transliteration = "minui onati",
            original = "מִנּוּי עוֹנָתִי", translation = "сезонный пропуск",
            definition = "כַּרְטִיס חֲבִילָה הַפּוֹתֵחַ אֶת כָּל הַתּוֹסָפוֹת הַמְּתֻכְנָנוֹת לִשְׁנַת מִשְׂחָק אַחַת.",
            definitionNative = "Пакетный билет, что открывает все запланированные дополнения за игровой год.",
            example = "מַעֲרִיצִים נֶאֱמָנִים חָטְפוּ אֶת הַמִּנּוּי עוֹנָתִי בַּיּוֹם הָרִאשׁוֹן בְּלִי לְהַסֵּס.",
            exampleNative = "Преданные фанаты схватили מִנּוּי עוֹנָתִי в первый же день не раздумывая.",
            isFillInBlankSafe = false,
        ),

        // ── entertainment_streaming (5) — стриминг-платформы ──
        WordEntity(
            id = 179416, setId = 1794, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_streaming", transliteration = "platforma streaming",
            original = "פְּלַטְפוֹרְמַת סְטְרִימִינְג", translation = "стриминговая платформа",
            definition = "שֵׁרוּת מְקֻוָּן שֶׁמְּסַפֵּק סְרָטִים וְסִדְרוֹת לְצוֹפִים לְפִי דְרִישָׁה.",
            definitionNative = "Онлайн-сервис, что доставляет фильмы и сериалы зрителям по запросу.",
            example = "פְּלַטְפוֹרְמַת סְטְרִימִינְג גְּדוֹלָה שִׁלְּמָה סְכוּמֵי עָתֵק עַל זְכוּיוֹת מַדָּע בִּדְיוֹנִי.",
            exampleNative = "Крупная פְּלַטְפוֹרְמַת סְטְרִימִינְג заплатила огромные суммы за фантастические права.",
         fillInBlankExclusions = listOf(179417L, 179418L, 179419L, 179420L)),
        WordEntity(
            id = 179417, setId = 1794, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_streaming", transliteration = "sidra mekorit",
            original = "סִדְרָה מְקוֹרִית", translation = "оригинальный сериал",
            definition = "תָּכְנִית שֶׁשֵּׁרוּת הַסְּטְרִימִינְג עָשָׂה בְּעַצְמוֹ וְלֹא קָנָה מִסְּטוּדְיוֹ אַחֵר.",
            definitionNative = "Шоу, что стриминговый сервис снял сам, а не купил у другой студии.",
            example = "הַסִּדְרָה מְקוֹרִית שֶׁלָּהּ הוֹאֲרָכָה לִשְׁתֵּי עוֹנוֹת אַחֲרֵי סוֹף שָׁבוּעַ אֶחָד.",
            exampleNative = "Её סִדְרָה מְקוֹרִית продлили на два сезона уже после первых выходных.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179418, setId = 1794, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_streaming", transliteration = "mesibat reshet",
            original = "מְסִבַּת רֶשֶׁת", translation = "совместный онлайн-просмотр",
            definition = "מִפְגָּשׁ מְקֻוָּן שֶׁבּוֹ חֲבֵרִים רוֹאִים יַחַד אֶת אוֹתָהּ הַתָּכְנִית עִם צַ'אט.",
            definitionNative = "Онлайн-встреча, где друзья смотрят одну программу вместе и переписываются.",
            example = "אִרְגַּנּוּ מְסִבַּת רֶשֶׁת עַל פֶּרֶק הַסִּיּוּם וְדִבַּרְנוּ עַל כָּל תַּפְנִית.",
            exampleNative = "Мы устроили מְסִבַּת רֶשֶׁת на финал и обсуждали каждый поворот.",
         fillInBlankExclusions = listOf(179416L, 179417L, 179419L, 179420L)),
        WordEntity(
            id = 179419, setId = 1794, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "entertainment_streaming", transliteration = "shikhrur masivi",
            original = "שִׁחְרוּר מַסִּיבִי", translation = "массовый выпуск (всех серий)",
            definition = "הוֹצָאָה שֶׁל כָּל פִּרְקֵי הָעוֹנָה בְּבַת אַחַת בְּמָקוֹם אַחַד לְשָׁבוּעַ.",
            definitionNative = "Выпуск всех серий сезона разом вместо одной за неделю.",
            example = "הַשֵּׁרוּת בָּחַר בְּשִׁחְרוּר מַסִּיבִי כְּדֵי לְעוֹדֵד מָרָתוֹן עַל הַסַּפָּה.",
            exampleNative = "Сервис выбрал שִׁחְרוּר מַסִּיבִי, чтобы поощрить марафон на диване.",
         fillInBlankExclusions = listOf(179416L, 179417L, 179418L, 179420L)),
        WordEntity(
            id = 179420, setId = 1794, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "entertainment_streaming", transliteration = "deyrug tsfiyot",
            original = "דֵּירוּג צְפִיּוֹת", translation = "рейтинг просмотров",
            definition = "מִסְפָּר הַמַּרְאֶה כַּמָּה אֲנָשִׁים הִתְחַבְּרוּ לְתָכְנִית אוֹ שִׁדּוּר.",
            definitionNative = "Число, что показывает, сколько людей подключились к программе или эфиру.",
            example = "הַדְּרָמָה גָּבְרָה עַל כָּל הַמִּתְחָרוֹת בְּטַבְלַת דֵּירוּג צְפִיּוֹת הַשְּׁבוּעִית.",
            exampleNative = "Драма обошла соперников в недельной таблице דֵּירוּג צְפִיּוֹת.",
         fillInBlankExclusions = listOf(179416L, 179417L, 179418L, 179419L)),

        // ── entertainment_creative (5) — креативные индустрии ──
        WordEntity(
            id = 179421, setId = 1794, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_creative", transliteration = "doktor tasrit",
            original = "דּוֹקְטוֹר תַּסְרִיט", translation = "скрипт-доктор",
            definition = "כּוֹתֵב שָׂכוּר שֶׁמְּתַקֵּן בְּשֶׁקֶט סְצֵנוֹת חַלָּשׁוֹת בְּטְיוּטָה שֶׁל סוֹפֵר אַחֵר.",
            definitionNative = "Нанятый автор, что тихо чинит слабые сцены в чужом черновике.",
            example = "הַסְּטוּדְיוֹ שִׁלֵּם לְדּוֹקְטוֹר תַּסְרִיט כְּדֵי לְחַדֵּד אֶת הָעֲלִילָה בָּאַקְט הַשֵּׁנִי.",
            exampleNative = "Студия заплатила דּוֹקְטוֹר תַּסְרִיט, чтобы заострить сюжет во втором акте.",
         fillInBlankExclusions = listOf(179422L, 179423L, 179424L, 179425L)),
        WordEntity(
            id = 179422, setId = 1794, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_creative", transliteration = "menahel lokeyshen",
            original = "מְנַהֵל לוֹקֵיישֵׁן", translation = "локейшн-менеджер",
            definition = "אִישׁ הַצֶּוֶת שֶׁמְּסַדֵּר אִשּׁוּרִים וּגְשִׁישׁוֹת לְכָל אֲתַר צִלּוּם.",
            definitionNative = "Член группы, что оформляет разрешения и доступ к каждой съёмочной площадке.",
            example = "הַמְּנַהֵל לוֹקֵיישֵׁן שֶׁלָּהֶם הִשִּׂיג סְגִירַת גֶּשֶׁר עָמוּס לְלַיְלָה אֶחָד.",
            exampleNative = "Их מְנַהֵל לוֹקֵיישֵׁן добился закрытия оживлённого моста на одну ночь.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179423, setId = 1794, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "entertainment_creative", transliteration = "akhrai lihuk",
            original = "אַחְרָאִי לִיהוּק", translation = "директор по кастингу",
            definition = "מִקְצוֹעָן הַמּוֹצֵא וּבוֹחֵר שַׂחְקָנִים לְכָל תַּפְקִיד בַּפְּרוֹיֶיקְט.",
            definitionNative = "Профи, что находит и выбирает актёров на каждую роль в проекте.",
            example = "אַחְרָאִי לִיהוּק חַד יָכוֹל לְהַצִּיל סֵרֶט מִמִּשְׂחָק חַלָּשׁ בְּלִי שֶׁיַּרְגִּישׁוּ.",
            exampleNative = "Толковый אַחְרָאִי לִיהוּק способен спасти фильм от слабой игры незаметно.",
         fillInBlankExclusions = listOf(179421L, 179422L, 179424L, 179425L)),
        WordEntity(
            id = 179424, setId = 1794, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "entertainment_creative", transliteration = "aman raash",
            original = "אָמָּן רַעַשׁ", translation = "фоли-артист",
            definition = "מוּמְחֶה הַמְּשַׁחְזֵר בְּיָדַיִם רְעָשִׁים יוֹמְיוֹמִיִּים לְפַסְקוֹל הַסֵּרֶט.",
            definitionNative = "Специалист, что вручную воссоздаёт бытовые шумы для звуковой дорожки.",
            example = "אָמָּן רַעַשׁ רָמַס חַסָּה לְחַקּוֹת צְעִידָה בְּמַגָּפַיִם עַל שֶׁלֶג רָטֹב.",
            exampleNative = "אָמָּן רַעַשׁ давил салат, имитируя шаги в сапогах по мокрому снегу.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 179425, setId = 1794, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "entertainment_creative", transliteration = "rakaz intimiyut",
            original = "רַכָּז אִינְטִימִיּוּת", translation = "координатор интимных сцен",
            definition = "מִקְצוֹעָן עַל הַסֶּט הַשּׁוֹמֵר עַל בִּטְחוֹן הַשַּׂחְקָנִים בִּסְצֵנוֹת רְגִישׁוֹת.",
            definitionNative = "Профи на площадке, что бережёт безопасность актёров в чувствительных сценах.",
            example = "רַכָּז אִינְטִימִיּוּת מִצְטָרֵף הַיּוֹם כִּמְעַט לְכָל צִלּוּם גָּדוֹל מִיּוֹם הַפְּתִיחָה.",
            exampleNative = "רַכָּז אִינְטִימִיּוּת сегодня участвует почти в каждой крупной съёмке с первого дня.",
         fillInBlankExclusions = listOf(179421L, 179422L, 179423L, 179424L)),
    )
}
