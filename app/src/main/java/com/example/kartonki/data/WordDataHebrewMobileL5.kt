package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Мобильная разработка", уровень L5 (носитель языка).
 *
 * Set 1785: «Мобильная разработка» — носитель языка (EPIC+LEGENDARY):
 *           Mobile-leadership, monorepo для mobile, release strategy,
 *           регуляторика сторов и продвинутый perf-tooling.
 *
 * Целевая аудитория — русскоязычные сеньоры/тимлиды/архитекторы мобильных
 * команд в израильском хайтеке. Лексика отражает реальную речь mobile-leadership
 * на митингах в Tel Aviv'ских tech-командах: сильная смесь иврита с английскими
 * заимствованиями (רֵישׁ מוֹבַייל, מוֹנוֹרֵפּוֹ, אוֹ-טִי-אֵיי, קוֹפָּה,
 * קִיל סְוִוץ', בֵּייסְלַיין פְּרוֹפַייל).
 *
 * Распределение редкостей: 13 EPIC + 12 LEGENDARY (без выхода за 2 смежных уровня).
 *
 * SemanticGroups (5 × 5):
 *   mobile_leadership      — лидерство: head of mobile, mobile platform team,
 *                            mobile architect, principal/staff engineer
 *   mobile_monorepo        — монорепо: monorepo, shared library, build matrix,
 *                            modularization, platform abstraction
 *   mobile_release_strategy — релиз-стратегия: quarterly release, mobile train,
 *                            OTA, региональная раскатка, kill switch
 *   mobile_compliance      — регуляторика сторов: App Store guidelines,
 *                            Play Store policy, privacy nutrition label,
 *                            App Tracking Transparency, COPPA
 *   mobile_perf_advanced   — продвинутый perf-tooling: instrumentation,
 *                            perfetto trace, baseline profile, R8 minification,
 *                            dead code elimination
 *
 * Word IDs: setId × 100 + position (178501..178525).
 *
 * Пересечения с другими наборами Mobile / Hightech:
 *   - L3 (1769) — базовые платформы, iOS/Android-стек, UI, lifecycle
 *   - L4 (1770) — perf, distribution (TestFlight/Play Console), фичи устройства,
 *     offline-first, native bridge. В L5 perf-инструментирование на уровень глубже
 *     (Perfetto, Baseline Profiles, R8) — другой original.
 *   - Hightech L5 (1749) — общеуправленческая лексика (CTO, VP R&D, M&A,
 *     attrition). В этом наборе — только mobile-specific лидерство.
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewMobileL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1785, languagePair = "he-ru", orderIndex = 1785,
            name = "Мобильная разработка",
            description = "Mobile-leadership: head of mobile, internal platform, monorepo, регуляторика",
            topic = "Мобильная разработка", level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1785 — Мобильная разработка: носитель языка (L5, EPIC+LEGENDARY)
        // 5 групп × 5 слов: leadership, monorepo, release_strategy, compliance, perf_advanced
        // ══════════════════════════════════════════════════════════════════════

        // ── mobile_leadership (5) — руководящие роли в мобильной команде ──
        WordEntity(
            id = 178501, setId = 1785, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_leadership", transliteration = "reish movayl",
            original = "רֵישׁ מוֹבַייל", translation = "head of mobile (руководитель направления mobile)",
            definition = "הָאָדָם הַבָּכִיר שֶׁאַחְרָאִי עַל כָּל הַפִּתּוּחַ הַסְּלוּלָרִי שֶׁל הַחֶבְרָה.",
            definitionNative = "Самый старший человек, отвечающий за всё мобильное направление в фирме.",
            example = "הָרֵישׁ מוֹבַייל הֶחֱלִיט לְאַחֵד אֶת שְׁתֵּי הַקְּבוּצוֹת לְצֶוֶות אֶחָד.",
            exampleNative = "רֵישׁ מוֹבַייל решил объединить две группы в одну команду.",
         fillInBlankExclusions = listOf(178502L, 178503L, 178504L, 178505L)),
        WordEntity(
            id = 178502, setId = 1785, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_leadership", transliteration = "tsevet platformat movayl",
            original = "צֶוֶות פְּלַטְפוֹרְמַת מוֹבַייל", translation = "команда платформы mobile",
            definition = "קְבוּצָה פְּנִימִית שֶׁבּוֹנָה תַּשְׁתִּיּוֹת לְכָל מְפַתְּחֵי הַסְּלוּלָר בָּאִרְגּוּן.",
            definitionNative = "Внутренняя группа, что строит инфраструктуру для всех мобильных разработчиков фирмы.",
            example = "צֶוֶות פְּלַטְפוֹרְמַת מוֹבַייל סִפֵּק לָנוּ סִפְרִיַּת רֶשֶׁת אֲחִידָה לִשְׁתֵּי הַמַּעֲרָכוֹת.",
            exampleNative = "צֶוֶות פְּלַטְפוֹרְמַת מוֹבַייל выдал нам единую сетевую библиотеку для двух систем.",
         fillInBlankExclusions = listOf(178501L, 178503L, 178504L, 178505L)),
        WordEntity(
            id = 178503, setId = 1785, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_leadership", transliteration = "arkhitekt movayl",
            original = "אַרְכִיטֶקְט מוֹבַייל", translation = "архитектор mobile",
            definition = "מוּמְחֶה בָּכִיר שֶׁמַּחְלִיט עַל הַמִּבְנֶה הַטֶּכְנִי שֶׁל הָאַפְּלִיקַצְיָה לְשָׁנִים קָדִימָה.",
            definitionNative = "Старший эксперт, решающий технический скелет приложения на годы вперёд.",
            example = "אַרְכִיטֶקְט מוֹבַייל הִכְתִּיב מַעֲבָר הַדְרָגָתִי מִ-יוּ-אַיי-קִיט לִ-סְוִויפְט-יוּ-אַיי.",
            exampleNative = "אַרְכִיטֶקְט מוֹבַייל продиктовал постепенный переход с UIKit на SwiftUI.",
         fillInBlankExclusions = listOf(178501L, 178502L, 178504L, 178505L)),
        WordEntity(
            id = 178504, setId = 1785, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_leadership", transliteration = "prinsipal movayl",
            original = "פְּרִינְסִיפַּל מוֹבַייל", translation = "principal mobile engineer",
            definition = "תַּפְקִיד טֶכְנִי גָּבוֹהַּ — בְּדַרְגַּת בָּכִיר וְלִפְעָמִים מַעַל לְמַנְהֲלֵי תּוֹכְנָה.",
            definitionNative = "Высокая инженерная роль — наравне с самыми старшими и иногда выше тимлидов.",
            example = "הַפְּרִינְסִיפַּל מוֹבַייל מוֹבִיל פְּרוֹיֶקְט חוֹצֶה אַרְבָּעָה צְוָתִים בְּמַקְבִּיל.",
            exampleNative = "פְּרִינְסִיפַּל מוֹבַייל ведёт проект, что пересекает четыре команды параллельно.",
         fillInBlankExclusions = listOf(178501L, 178502L, 178503L, 178505L)),
        WordEntity(
            id = 178505, setId = 1785, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_leadership", transliteration = "staf inji'nir",
            original = "סְטָאף אִינְגִ'ינִיר", translation = "staff engineer",
            definition = "מְהַנְדֵּס בְּכִיר שֶׁמַּשְׁפִּיעַ עַל הַחְלָטוֹת טֶכְנוֹלוֹגְיוֹת בְּלִי לְנַהֵל אֲנָשִׁים.",
            definitionNative = "Старший инженер с большим влиянием на технические решения, без управления людьми.",
            example = "סְטָאף אִינְגִ'ינִיר אֵצְלֵנוּ מַחְלִיט עַל גִּרְסַת קוֹטְלִין בְּכָל הַמַּאֲגָר.",
            exampleNative = "סְטָאף אִינְגִ'ינִיר у нас решает версию Kotlin во всём репозитории.",
         fillInBlankExclusions = listOf(178501L, 178502L, 178503L, 178504L)),

        // ── mobile_monorepo (5) — монорепо для мобильной разработки ──
        WordEntity(
            id = 178506, setId = 1785, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_monorepo", transliteration = "monorepo",
            original = "מוֹנוֹרֵפּוֹ", translation = "монорепо (единый репозиторий)",
            definition = "מַחְסָן קוֹד יָחִיד שֶׁבּוֹ חַיִּים יָחַד אַיי-אוֹ-אֶס, אַנְדְּרוֹאִיד וּסְפְרִיּוֹת מְשֻׁתָּפוֹת.",
            definitionNative = "Один склад кода, где живут вместе iOS, Android и общие библиотеки.",
            example = "הַמַּעֲבָר לְ-מוֹנוֹרֵפּוֹ הִקְפִּיא לָנוּ פִּתּוּחַ לְשָׁבוּעַ שָׁלֵם.",
            exampleNative = "Переход на מוֹנוֹרֵפּוֹ заморозил нам разработку на целую неделю.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178507, setId = 1785, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_monorepo", transliteration = "sifriya meshutefet",
            original = "סִפְרִיָּה מְשֻׁתֶּפֶת", translation = "общая библиотека",
            definition = "אֹסֶף קוֹד שֶׁמְּשַׁמֵּשׁ כַּמָּה אַפְּלִיקַצְיוֹת בְּלִי לְשַׁכְפֵּל לוֹגִיקָה זֵהָה.",
            definitionNative = "Набор кода, что обслуживает несколько приложений — без дублирования одной логики.",
            example = "סִפְרִיָּה מְשֻׁתֶּפֶת לְעִצּוּב אִחֲדָה לָנוּ אֶת הַצְּבָעִים בְּכָל הַמּוּצָרִים.",
            exampleNative = "סִפְרִיָּה מְשֻׁתֶּפֶת для дизайна унифицировала нам цвета во всех продуктах.",
         fillInBlankExclusions = listOf(178506L, 178508L, 178509L, 178510L)),
        WordEntity(
            id = 178508, setId = 1785, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_monorepo", transliteration = "matritsat bniya",
            original = "מַטְרִיצַת בְּנִיָּה", translation = "матрица сборки (build matrix)",
            definition = "טַבְלָה שֶׁל שִׁילּוּבֵי גִּרְסָאוֹת וּפְרִמֶטְרִים שֶׁמְּקַמְפְלִים בְּמַקְבִּיל בִּכְּדֵי לְזָרֵז סִי-אַיי.",
            definitionNative = "Таблица сочетаний версий и параметров — компилятся параллельно, чтобы ускорить CI.",
            example = "מַטְרִיצַת בְּנִיָּה רְחָבָה הוֹרִידָה אֶת זְמַן הַצֶּ'ק מֵעֶשְׂרִים דַּקּוֹת לְשֵׁשׁ.",
            exampleNative = "Широкая מַטְרִיצַת בְּנִיָּה снизила время проверки с двадцати минут до шести.",
         fillInBlankExclusions = listOf(178506L, 178507L, 178509L, 178510L)),
        WordEntity(
            id = 178509, setId = 1785, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_monorepo", transliteration = "modularizatsya",
            original = "מוֹדּוּלָרִיזַצְיָה", translation = "модуляризация (дробление на модули)",
            definition = "פֵּרוּק אַפְּלִיקַצְיָה גְּדוֹלָה לְחֵלְקֵי קוֹד עַצְמָאִיִּים וְקְטַנִּים יוֹתֵר.",
            definitionNative = "Распиливание большого приложения на самостоятельные мелкие части.",
            example = "מוֹדּוּלָרִיזַצְיָה צִמְצְמָה אֶת זְמַן הַבְּנִיָּה בְּפִי שְׁלוֹשָׁה.",
            exampleNative = "מוֹדּוּלָרִיזַצְיָה сократила время сборки в три раза.",
         fillInBlankExclusions = listOf(178506L, 178507L, 178508L, 178510L)),
        WordEntity(
            id = 178510, setId = 1785, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_monorepo", transliteration = "hafshatat platforma",
            original = "הַפְשָׁטַת פְּלַטְפוֹרְמָה", translation = "абстракция платформы",
            definition = "שִׁכְבָה שֶׁמַּסְתִּירָה הֶבְדֵּלִים בֵּין הַמַּעֲרָכוֹת מֵהַפִיצָ'ר שֶׁמִּשְׁתַּמֵּשׁ בָּהּ.",
            definitionNative = "Слой, скрывающий разницу между ОС от той фичи, что им пользуется.",
            example = "הַפְשָׁטַת פְּלַטְפוֹרְמָה אִפְשְׁרָה לִכְתֹּב לוֹגִיקָה עִסְקִית פַּעַם אַחַת בְּלִבָד.",
            exampleNative = "הַפְשָׁטַת פְּלַטְפוֹרְמָה позволила писать бизнес-логику только один раз.",
         fillInBlankExclusions = listOf(178506L, 178507L, 178508L, 178509L)),

        // ── mobile_release_strategy (5) — стратегия релизов ──
        WordEntity(
            id = 178511, setId = 1785, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_release_strategy", transliteration = "rilis riv'oni",
            original = "רִילִיס רִבְעוֹנִי", translation = "квартальный релиз",
            definition = "מַחֲזוֹר הוֹצָאָה שֶׁל גִּרְסָה גְּדוֹלָה אַחַת לִשְׁלוֹשָׁה חֳדָשִׁים, עִם חֲבִילַת פִיצָ'רִים.",
            definitionNative = "Цикл выпуска большой версии раз в три месяца — с пакетом фич.",
            example = "רִילִיס רִבְעוֹנִי הִכְרִיחַ אוֹתָנוּ לְקַבֵּעַ דֵּד-לַיין קָשִׁיחַ לְפִיצָ'רִים.",
            exampleNative = "רִילִיס רִבְעוֹנִי заставил нас зафиксировать жёсткий дедлайн на фичи.",
         fillInBlankExclusions = listOf(178512L, 178513L, 178514L, 178515L)),
        WordEntity(
            id = 178512, setId = 1785, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_release_strategy", transliteration = "rakevet movayl",
            original = "רַכֶּבֶת מוֹבַייל", translation = "поезд релизов (mobile train)",
            definition = "לוּחַ זְמַנִּים קָבוּעַ שֶׁל הוֹצָאַת גִּרְסָאוֹת בְּלִי הִתְחַשְּׁבוּת בְּמַה שֶׁמּוּכָן.",
            definitionNative = "Постоянное расписание выпуска версий — независимо от того, что готово.",
            example = "רַכֶּבֶת מוֹבַייל יוֹצֵאת בְּכָל יוֹם רִאשׁוֹן גַּם אִם פִיצָ'ר אֶחָד פֻּסַל.",
            exampleNative = "רַכֶּבֶת מוֹבַייל уходит каждое воскресенье — даже если одну фичу выкинули.",
         fillInBlankExclusions = listOf(178511L, 178513L, 178514L, 178515L)),
        WordEntity(
            id = 178513, setId = 1785, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_release_strategy", transliteration = "o-ti-ey",
            original = "אוֹ-טִי-אֵיי", translation = "OTA-обновление (по воздуху)",
            definition = "שִׁדּוּר עִדְכּוּן יָשִׁיר לַמַּכְשִׁיר דֶּרֶךְ הָאִינְטֶרְנֶט בְּלִי לַעֲבֹר דֶּרֶךְ חֲנוּת רִשְׁמִית.",
            definitionNative = "Передача обновления прямо на устройство через интернет — минуя официальный магазин.",
            example = "אוֹ-טִי-אֵיי תִּקֵּן לָנוּ בָּאג קְרִיטִי בְּתוֹךְ שָׁעָה לְכָל הַמִּשְׁתַּמְּשִׁים.",
            exampleNative = "אוֹ-טִי-אֵיי починил нам критичный баг за час для всех пользователей.",
         fillInBlankExclusions = listOf(178511L, 178512L, 178514L, 178515L)),
        WordEntity(
            id = 178514, setId = 1785, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_release_strategy", transliteration = "prisa ezorit",
            original = "פְּרִיסָה אֵזוֹרִית", translation = "региональная раскатка (по странам)",
            definition = "הַשָׁקַת גִּרְסָה רַק בְּחֵלֶק מִן הָעוֹלָם בְּהַתְחָלָה — כְּדֵי לִבְדֹּק תְּגוּבוֹת בְּמָקוֹם בָּטוּחַ.",
            definitionNative = "Запуск версии лишь в части мира поначалу — чтобы оценить отклик в безопасном месте.",
            example = "פְּרִיסָה אֵזוֹרִית הִתְחִילָה בְּקָנָדָה וְעָבְרָה לָאֵיחוּד הָאֵירוֹפֵּי שָׁבוּעַ אַחַר.",
            exampleNative = "פְּרִיסָה אֵזוֹרִית началась в Канаде и перешла в ЕС неделю спустя.",
         fillInBlankExclusions = listOf(178511L, 178512L, 178513L, 178515L)),
        WordEntity(
            id = 178515, setId = 1785, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_release_strategy", transliteration = "kil svvich",
            original = "קִיל סְוִוץ'", translation = "kill switch (аварийный рубильник)",
            definition = "מַתְקָן מֵרָחוֹק לְכַבּוֹת פִיצָ'ר אוֹ גִּרְסָה כְּשֶׁמִּתְגַּלֶּה בָּעָיָה חֲמוּרָה.",
            definitionNative = "Дистанционный механизм погасить фичу или версию — когда обнаружили серьёзную проблему.",
            example = "קִיל סְוִוץ' עָצַר אֶת הַתַּשְׁלוּמִים אַחֲרֵי שֶׁשֶּׁרֶת חִיצוֹנִי הִתְמוֹטֵט.",
            exampleNative = "קִיל סְוִוץ' остановил оплаты после того как внешний сервер рухнул.",
            isFillInBlankSafe = false,
        ),

        // ── mobile_compliance (5) — регуляторика и правила сторов ──
        WordEntity(
            id = 178516, setId = 1785, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_compliance", transliteration = "hankhayot ap stor",
            original = "הַנְחָיוֹת אַפּ סְטוֹר", translation = "правила App Store",
            definition = "מִסְמָךְ רִשְׁמִי שֶׁל אַפֵּל עִם כְּלָלִים שֶׁכָּל אַפְּלִיקַצְיָה חַיֶּיבֶת לַעֲמֹד בָּהֶם.",
            definitionNative = "Официальный документ Apple с правилами, которым обязано отвечать каждое приложение.",
            example = "הַנְחָיוֹת אַפּ סְטוֹר אוֹסְרוֹת תַּשְׁלוּם דֶּרֶךְ צַד שְׁלִישִׁי בְּתוֹךְ אַפְּלִיקַצְיָה.",
            exampleNative = "הַנְחָיוֹת אַפּ סְטוֹר запрещают платежи через третью сторону внутри приложения.",
         fillInBlankExclusions = listOf(178517L, 178518L, 178519L, 178520L)),
        WordEntity(
            id = 178517, setId = 1785, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_compliance", transliteration = "mediniyut pley stor",
            original = "מְדִינִיּוּת פְּלֵיי סְטוֹר", translation = "политика Play Store",
            definition = "אֹסֶף הַחֻקִּים שֶׁל גוּגְל לִתְכָנִים, פִּרְסוּם וְהֲרְשָׁאוֹת בְּכָל אַפְּלִיקַצְיָה לְאַנְדְּרוֹאִיד.",
            definitionNative = "Свод правил Google по контенту, рекламе и разрешениям в каждом Android-приложении.",
            example = "מְדִינִיּוּת פְּלֵיי סְטוֹר הִכְרִיחָה לָנוּ לְהוֹסִיף הַסְבָּר עַל אִיסּוּף נְתוּנִים.",
            exampleNative = "מְדִינִיּוּת פְּלֵיי סְטוֹר обязала нас добавить пояснение про сбор данных.",
         fillInBlankExclusions = listOf(178516L, 178518L, 178519L, 178520L)),
        WordEntity(
            id = 178518, setId = 1785, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_compliance", transliteration = "tavit pratiyut",
            original = "תָּוִית פְּרָטִיּוּת", translation = "ярлык приватности (privacy nutrition label)",
            definition = "כַּרְטִיס תַּמְצִיתִי בַּחֲנוּת שֶׁמַּרְאֶה לַמִּשְׁתַּמֵּשׁ אֵילוּ נְתוּנִים נֶאֱסָפִים עָלָיו.",
            definitionNative = "Краткая карточка в сторе — показывает пользователю, какие данные о нём собирают.",
            example = "תָּוִית פְּרָטִיּוּת אֲדֻמָּה הֵרִיחָה לָקוֹחוֹת מֵהַהוֹרָדָה בָּרֶגַע הָאַחֲרוֹן.",
            exampleNative = "Красная תָּוִית פְּרָטִיּוּת отпугнула клиентов от загрузки в последний момент.",
         fillInBlankExclusions = listOf(178516L, 178517L, 178519L, 178520L)),
        WordEntity(
            id = 178519, setId = 1785, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_compliance", transliteration = "shkifut ma'akav",
            original = "שְׁקִיפוּת מַעֲקַב", translation = "App Tracking Transparency (прозрачность трекинга)",
            definition = "דְּרִישָׁה שֶׁל אַפֵּל לְבַקֵּשׁ אִישּׁוּר מְפֹרָשׁ לִפְנֵי שֶׁאוֹסְפִים מֵידָע פִּרְסוּמִי.",
            definitionNative = "Требование Apple — спросить явное согласие, прежде чем собирать рекламные данные.",
            example = "שְׁקִיפוּת מַעֲקַב הִקְטִינָה לָנוּ אֶת הַהַכְנָסוֹת מִפִּרְסֹמֶת בִּשְׁלוֹשִׁים אָחוּז.",
            exampleNative = "שְׁקִיפוּת מַעֲקַב уменьшила нам доходы от рекламы на тридцать процентов.",
         fillInBlankExclusions = listOf(178516L, 178517L, 178518L, 178520L)),
        WordEntity(
            id = 178520, setId = 1785, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_compliance", transliteration = "kopa",
            original = "קוֹפָּה", translation = "COPPA (закон о защите детей в США)",
            definition = "חֹק אָמֵרִיקָאִי שֶׁמַּגְבִּיל אִיסּוּף מֵידָע מִיְּלָדִים מִתַּחַת לְגִיל שְׁלוֹשׁ עֶשְׂרֵה.",
            definitionNative = "Американский закон, ограничивающий сбор данных от детей младше тринадцати лет.",
            example = "קוֹפָּה הִכְרִיחָה אוֹתָנוּ לְהוֹצִיא חֶשְׁבּוֹנוֹת קְטַנִּים מִשּׁוּק אַרְצוֹת הַבְּרִית.",
            exampleNative = "קוֹפָּה вынудила нас вытащить детские аккаунты с рынка США.",
         fillInBlankExclusions = listOf(178516L, 178517L, 178518L, 178519L)),

        // ── mobile_perf_advanced (5) — продвинутые инструменты профайлинга ──
        WordEntity(
            id = 178521, setId = 1785, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_perf_advanced", transliteration = "instrumentatsya",
            original = "אִינְסְטְרוּמֶנְטַצְיָה", translation = "инструментация (для трассировки)",
            definition = "הַכְנָסַת נְקֻדּוֹת מְדִידָה זְעִירוֹת לְתוֹךְ הַתּוֹכְנָה כְּדֵי לִרְאוֹת מַה קוֹרֶה בִּזְמַן רִיצָה.",
            definitionNative = "Вставка крошечных замерных точек внутрь программы — увидеть, что происходит на ходу.",
            example = "אִינְסְטְרוּמֶנְטַצְיָה צְפוּפָה גִּלְּתָה לָנוּ צַוַּאר בַּקְבּוּק.",
            exampleNative = "Плотная אִינְסְטְרוּמֶנְטַצְיָה раскрыла нам бутылочное горлышко.",
         fillInBlankExclusions = listOf(178522L, 178523L, 178524L, 178525L)),
        WordEntity(
            id = 178522, setId = 1785, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_perf_advanced", transliteration = "treys perfeto",
            original = "טְרֵייס פֵּרְפֶטוֹ", translation = "perfetto trace (трассировка perfetto)",
            definition = "קֹבֶץ מְפֹרָט שֶׁמַּרְאֶה כָּל פְּעֻלָּה שֶׁל הַמַּעֲבֵד וְהַזִּכָּרוֹן בְּמַהֲלָךְ הָרִיצָה בְּאַנְדְּרוֹאִיד.",
            definitionNative = "Подробный файл — показывает каждое действие процессора и памяти во время работы Android.",
            example = "טְרֵייס פֵּרְפֶטוֹ חָשַׂף קְפִיצָה שֶׁל ג'יסי דַּוְקָא בָּרֶגַע הַקְּרִיטִי.",
            exampleNative = "טְרֵייס פֵּרְפֶטוֹ выявил скачок GC именно в самый критичный момент.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178523, setId = 1785, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_perf_advanced", transliteration = "beysline profayl",
            original = "בֵּייסְלַיין פְּרוֹפַייל", translation = "baseline profile",
            definition = "קֹבֶץ הֲנָחָיָה לַמַּהַדֵּר שֶׁמְּסַמֵּן אֵילוּ נְתִיבֵי קוֹד לְהָכִין מֵרֹאשׁ לְהַאֲצָה.",
            definitionNative = "Файл-подсказка компилятору — какие пути кода готовить заранее для ускорения.",
            example = "בֵּייסְלַיין פְּרוֹפַייל קִצֵּר אֶת זְמַן הַטְּעִינָה הָרִאשׁוֹנָה בְּעֶשְׂרִים אָחוּז.",
            exampleNative = "בֵּייסְלַיין פְּרוֹפַייל сократил первую загрузку на двадцать процентов.",
         fillInBlankExclusions = listOf(178521L, 178522L, 178524L, 178525L)),
        WordEntity(
            id = 178524, setId = 1785, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "mobile_perf_advanced", transliteration = "mizur ar-shmone",
            original = "מַזְעוּר אַר-שְׁמוֹנֶה", translation = "минификация R8",
            definition = "תַּהֲלִיךְ שֶׁל גוּגְל שֶׁמְּכַוֵּץ סִמְלֵי קוֹד וּמַעֲבִיר לְשֵׁמוֹת קְצָרִים בִּכְּדֵי לְהַקְטִין חֲבִילָה.",
            definitionNative = "Процесс Google — пакует символы и переименовывает в короткие имена, чтобы сжать пакет.",
            example = "מַזְעוּר אַר-שְׁמוֹנֶה הוֹרִיד אֶת הַחֲבִילָה מִשִּׁשִּׁים מֶגָה לְאַרְבָּעִים.",
            exampleNative = "מַזְעוּר אַר-שְׁמוֹנֶה снизил пакет с шестидесяти мегабайт до сорока.",
         fillInBlankExclusions = listOf(178521L, 178522L, 178523L, 178525L)),
        WordEntity(
            id = 178525, setId = 1785, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_perf_advanced", transliteration = "hasarat kod met",
            original = "הֲסָרַת קוֹד מֵת", translation = "удаление мёртвого кода",
            definition = "הַשְׁלָכָה אוֹטוֹמָטִית שֶׁל פוּנְקְצְיוֹת וּמַחְלָקוֹת שֶׁאַף אֶחָד לֹא קוֹרֵא לָהֶם.",
            definitionNative = "Автоматический выброс функций и классов, к которым никто не обращается.",
            example = "הֲסָרַת קוֹד מֵת מָחֲקָה שְׁתֵּי סְפְרִיּוֹת שֶׁשָּׁכַחְנוּ לְהַסִּיר.",
            exampleNative = "הֲסָרַת קוֹד מֵת стёрла две библиотеки, которые мы забыли вынести.",
         fillInBlankExclusions = listOf(178521L, 178522L, 178523L, 178524L)),
    )
}
