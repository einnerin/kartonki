package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Мобильная разработка", L3 «Углублённый» (RARE+EPIC).
 *
 * Set 1769: «Мобильная разработка» — углублённый L3:
 *           Платформы (iOS/Android), стек разработки, UI и lifecycle.
 *
 * Тема ориентирована на мобильного разработчика, который изучает иврит
 * для работы в израильском хайтеке. Лексика отражает реальную речь
 * mobile-инженеров: множество английских заимствований
 * (סְוִויפְט, קוֹטְלִין, אֶקְסְקוֹד, גְ'טפַּק קוֹמְפּוֹז) — так реально говорят.
 * RTL обязателен — для иврит-приложений критическая тема UI.
 *
 * Распределение редкостей: 13 RARE + 12 EPIC (L3 = специальная mobile-лексика,
 * не базовый офисный сленг).
 *
 * SemanticGroups (5 × 5):
 *   mobile_platforms   — платформы: iOS, Android, native, hybrid, cross-platform
 *   mobile_ios         — iOS-стек: Swift, SwiftUI, UIKit, Xcode, App Store
 *   mobile_android     — Android-стек: Kotlin, Compose, Studio, Gradle, Play Store
 *   mobile_ui          — UI: layout, navigation, animation, a11y, RTL
 *   mobile_lifecycle   — жизненный цикл: foreground, background, lifecycle, VM, state
 *
 * Word IDs: setId × 100 + position (176901..176925).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewMobileL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1769, languagePair = "he-ru", orderIndex = 1769,
            name = "Мобильная разработка",
            description = "Основы mobile: платформы, iOS/Android стек, UI, lifecycle",
            topic = "Мобильная разработка", level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1769 — Мобильная разработка: углублённый (L3, RARE+EPIC)
        // 5 групп × 5 слов: platforms, ios, android, ui, lifecycle
        // ══════════════════════════════════════════════════════════════════════

        // ── mobile_platforms (5) — мобильные платформы ──
        WordEntity(
            id = 176901, setId = 1769, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_platforms", transliteration = "ay-o-es",
            original = "אַיי-אוֹ-אֶס", translation = "iOS",
            definition = "מַעֲרֶכֶת הַהַפְעָלָה שֶׁל אַפֵּל לַמַּכְשִׁירִים הַנַּיָּדִים שֶׁלָּהּ.",
            definitionNative = "Операционная система Apple для её мобильных устройств — телефонов и планшетов.",
            example = "אַיי-אוֹ-אֶס מְקַבֵּל עֲדְכּוּן גָּדוֹל פַּעַם בְּשָׁנָה בַּסְּתָו.",
            exampleNative = "אַיי-אוֹ-אֶס получает большое обновление раз в год — осенью.",
         fillInBlankExclusions = listOf(176902L, 176903L, 176904L, 176905L)),
        WordEntity(
            id = 176902, setId = 1769, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_platforms", transliteration = "android",
            original = "אַנְדְרוֹייד", translation = "Android",
            definition = "מַעֲרֶכֶת הַפְעָלָה פְּתוּחָה שֶׁל גוּגְל לְמַכְשִׁירִים סְלוּלָרִיִּים מִיַּצְרָנִים שׁוֹנִים.",
            definitionNative = "Открытая ОС от Google для мобильных устройств разных производителей.",
            example = "אַנְדְרוֹייד מְחַזִּיק יוֹתֵר מִשִּׁבְעִים אָחוּז מֵהַשּׁוּק הָעוֹלָמִי.",
            exampleNative = "אַנְדְרוֹייד держит больше семидесяти процентов мирового рынка.",
         fillInBlankExclusions = listOf(176901L, 176903L, 176904L, 176905L)),
        WordEntity(
            id = 176903, setId = 1769, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_platforms", transliteration = "aplikatsya nativit",
            original = "אַפְּלִיקַצְיָה נֵטִיבִית", translation = "нативное приложение",
            definition = "תּוֹכְנָה שֶׁנִּכְתְּבָה בִּשְׂפַת הַפְּלַטְפוֹרְמָה עַצְמָהּ — לְבִיצוּעִים מְהִירִים.",
            definitionNative = "Программа на родном языке платформы — для максимально быстрой работы.",
            example = "אַפְּלִיקַצְיָה נֵטִיבִית רָצָה חָלָק יוֹתֵר מִפִּתְרוֹן חוֹצֵה פְּלַטְפוֹרְמוֹת.",
            exampleNative = "אַפְּלִיקַצְיָה נֵטִיבִית бежит плавнее кросс-платформенного решения.",
         fillInBlankExclusions = listOf(176901L, 176902L, 176904L, 176905L)),
        WordEntity(
            id = 176904, setId = 1769, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_platforms", transliteration = "aplikatsya hibridit",
            original = "אַפְּלִיקַצְיָה הִיבְּרִידִית", translation = "гибридное приложение",
            definition = "תּוֹכְנָה שֶׁעוֹטֶפֶת קוֹד וֵוּב בְּתוֹךְ אֲרִיזָה שֶׁל מַכְשִׁיר נַיָּד.",
            definitionNative = "Программа, оборачивающая веб-код в обёртку мобильного устройства.",
            example = "אַפְּלִיקַצְיָה הִיבְּרִידִית זוֹלָה לְפִתּוּחַ אֲבָל סוֹבֶלֶת בִּבִיצוּעִים כְּבֵדִים.",
            exampleNative = "אַפְּלִיקַצְיָה הִיבְּרִידִית дешёвая в разработке, но страдает на тяжёлых задачах.",
         fillInBlankExclusions = listOf(176901L, 176902L, 176903L, 176905L)),
        WordEntity(
            id = 176905, setId = 1769, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_platforms", transliteration = "kros-platforma",
            original = "קְרוֹס-פְּלַטְפוֹרְמָה", translation = "кросс-платформа",
            definition = "גִּישָׁה שֶׁבָּהּ אוֹתוֹ קוֹד רָץ עַל שְׁתֵּי מַעֲרָכוֹת הַפְעָלָה שׁוֹנוֹת.",
            definitionNative = "Подход, при котором один код работает на двух разных операционных системах.",
            example = "פְלָטֶר וּ-רֵיאַקְט נֵייטִיב הֵם כֵּלֵי קְרוֹס-פְּלַטְפוֹרְמָה פּוֹפּוּלָרִיִּים.",
            exampleNative = "Flutter и React Native — популярные инструменты קְרוֹס-פְּלַטְפוֹרְמָה.",
         fillInBlankExclusions = listOf(176901L, 176902L, 176903L, 176904L)),

        // ── mobile_ios (5) — iOS-стек ──
        WordEntity(
            id = 176906, setId = 1769, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_ios", transliteration = "swift",
            original = "סְוִויפְט", translation = "Swift",
            definition = "שְׂפַת תִּכְנוּת מוֹדֶרְנִית שֶׁל אַפֵּל — בְּטוּחָה, קְרִיאָה וּמְהִירָה.",
            definitionNative = "Современный язык программирования Apple — безопасный, читаемый и быстрый.",
            example = "סְוִויפְט הֶחֱלִיף אֶת אוֹבְּגֶ׳קְטִיב סִי כִּשְׂפַת בְּרִירַת הַמַּחְדָּל.",
            exampleNative = "סְוִויפְט сменил Objective-C как язык по умолчанию.",
         fillInBlankExclusions = listOf(176907L, 176908L, 176909L, 176910L)),
        WordEntity(
            id = 176907, setId = 1769, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_ios", transliteration = "swift-yu-ay",
            original = "סְוִויפְט-יוּ-אַיי", translation = "SwiftUI",
            definition = "סְפְרִיָּה הַצְהָרָתִית לִבְנִיַּת מָסָכִים בְּשׂוֹרוֹת קוֹד מְעַטוֹת.",
            definitionNative = "Декларативная библиотека для построения экранов в несколько строк кода.",
            example = "סְוִויפְט-יוּ-אַיי קִצֵּר אֶת זְמַן הַפִּתּוּחַ בִּפְרוֹיֶקְטִים חֲדָשִׁים.",
            exampleNative = "סְוִויפְט-יוּ-אַיי сократил время разработки в новых проектах.",
         fillInBlankExclusions = listOf(176906L, 176908L, 176909L, 176910L)),
        WordEntity(
            id = 176908, setId = 1769, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_ios", transliteration = "yu-ay-kit",
            original = "יוּ-אַיי-קִיט", translation = "UIKit",
            definition = "סְפְרִיַּת מִמְשָׁק וָוּתִיקָה שֶׁל אַפֵּל — בְּסִיס לְכָל אַפְּלִיקַצְיוֹת אַיי-אוֹ-אֶס יְשָׁנוֹת.",
            definitionNative = "Старая интерфейсная библиотека Apple — основа всех старых iOS-приложений.",
            example = "יוּ-אַיי-קִיט עֲדַיִן נִדְרָשׁ לִתְמִיכָה בְּמַכְשִׁירִים יוֹתֵר יְשָׁנִים.",
            exampleNative = "יוּ-אַיי-קִיט всё ещё нужен для поддержки более старых устройств.",
         fillInBlankExclusions = listOf(176906L, 176907L, 176909L, 176910L)),
        WordEntity(
            id = 176909, setId = 1769, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_ios", transliteration = "ekskod",
            original = "אֶקְסְקוֹד", translation = "Xcode",
            definition = "סְבִיבַת פִּתּוּחַ רִשְׁמִית שֶׁל אַפֵּל — בָּהּ כּוֹתְבִים, מַרְצִים וּמְפִיצִים.",
            definitionNative = "Официальная среда разработки от Apple — в ней пишут, запускают и публикуют.",
            example = "אֶקְסְקוֹד דּוֹרֵשׁ הַרְבֵּה זִכָּרוֹן וְעוֹבֵד רַק עַל מַק.",
            exampleNative = "אֶקְסְקוֹד требует много памяти и работает только на Mac.",
         fillInBlankExclusions = listOf(176906L, 176907L, 176908L, 176910L)),
        WordEntity(
            id = 176910, setId = 1769, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_ios", transliteration = "ap stor",
            original = "אַפּ סְטוֹר", translation = "App Store",
            definition = "חֲנוּת רִשְׁמִית שֶׁל אַפֵּל לְהוֹרָדַת תּוֹכְנוֹת לְאַיי-פוֹן וְאַיי-פֶּד.",
            definitionNative = "Официальный магазин Apple для скачивания программ на iPhone и iPad.",
            example = "הָאִישּׁוּר שֶׁל אַפּ סְטוֹר לִפְעָמִים לוֹקֵחַ יוֹתֵר מִשָּׁבוּעַ.",
            exampleNative = "Одобрение в אַפּ סְטוֹר иногда занимает больше недели.",
         fillInBlankExclusions = listOf(176906L, 176907L, 176908L, 176909L, 176915L)),

        // ── mobile_android (5) — Android-стек ──
        WordEntity(
            id = 176911, setId = 1769, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_android", transliteration = "kotlin",
            original = "קוֹטְלִין", translation = "Kotlin",
            definition = "שְׂפַת תִּכְנוּת מוֹדֶרְנִית — הַשְּׂפָה הָרִשְׁמִית שֶׁל גוּגְל לְפִתּוּחַ אַנְדְרוֹייד.",
            definitionNative = "Современный язык программирования — официальный язык Google для разработки Android.",
            example = "קוֹטְלִין דָּחַק אֶת גָּ'אוָוה כְּשְׂפָה רָאשִׁית בִּפְרוֹיֶקְטִים חֲדָשִׁים.",
            exampleNative = "קוֹטְלִין вытеснил Java как основной язык в новых проектах.",
         fillInBlankExclusions = listOf(176912L, 176913L, 176914L, 176915L)),
        WordEntity(
            id = 176912, setId = 1769, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_android", transliteration = "jetpak kompoz",
            original = "גְ׳טפַּק קוֹמְפּוֹז", translation = "Jetpack Compose",
            definition = "סְפְרִיָּה חֲדָשָׁה לִבְנִיַּת מָסָכִים בְּצוּרָה הַצְהָרָתִית — דּוֹמָה לִ-סְוִויפְט-יוּ-אַיי.",
            definitionNative = "Новая библиотека для построения экранов декларативно — похожа на SwiftUI.",
            example = "גְ׳טפַּק קוֹמְפּוֹז קִצֵּר אֶת הַקּוֹד פִּי שְׁלוֹשָׁה מוּל הַגִּישָׁה הַיְשָׁנָה.",
            exampleNative = "גְ׳טפַּק קוֹמְפּוֹז сократил код втрое по сравнению со старым подходом.",
         fillInBlankExclusions = listOf(176911L, 176913L, 176914L, 176915L)),
        WordEntity(
            id = 176913, setId = 1769, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_android", transliteration = "android studyo",
            original = "אַנְדְרוֹייד סְטוּדִיוֹ", translation = "Android Studio",
            definition = "סְבִיבַת פִּתּוּחַ רִשְׁמִית שֶׁל גוּגְל לְפִתּוּחַ אַפְּלִיקַצְיוֹת לַמַּעֲרֶכֶת שֶׁלָּהּ.",
            definitionNative = "Официальная среда разработки от Google для приложений под её систему.",
            example = "אַנְדְרוֹייד סְטוּדִיוֹ מַצִּיעַ אֶמוּלָטוֹר מוּבְנֶה לִבְדִיקַת הַקּוֹד.",
            exampleNative = "אַנְדְרוֹייד סְטוּדִיוֹ предлагает встроенный эмулятор для проверки кода.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176914, setId = 1769, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_android", transliteration = "greydl",
            original = "גְרֵייד׳ל", translation = "Gradle",
            definition = "כְּלִי בְּנִיָּה שֶׁמְּחַבֵּר תְּלוּיוֹת וְאוֹסֵף אֶת הַקּוֹד לְקֹבֶץ הַתְקָנָה אֶחָד.",
            definitionNative = "Сборочный инструмент — соединяет зависимости и собирает код в один установочный файл.",
            example = "הָרָצָה הָרִאשׁוֹנָה שֶׁל גְרֵייד׳ל לְאַחַר נִקּוּי מַטְמוֹן לוֹקַחַת הַרְבֵּה זְמַן.",
            exampleNative = "Первый запуск גְרֵייד׳ל после очистки кэша занимает много времени.",
         fillInBlankExclusions = listOf(176911L, 176912L, 176913L, 176915L)),
        WordEntity(
            id = 176915, setId = 1769, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_android", transliteration = "pley stor",
            original = "פְּלֵיי סְטוֹר", translation = "Play Store",
            definition = "חֲנוּת רִשְׁמִית שֶׁל גוּגְל לְהוֹרָדַת תּוֹכְנוֹת לְמַכְשִׁירֵי אַנְדְרוֹייד.",
            definitionNative = "Официальный магазин Google для скачивания программ на устройства Android.",
            example = "הִשְׁקַת הַתּוֹכְנָה בִּ-פְּלֵיי סְטוֹר אִישְּׁרָה אוֹתָהּ בְּתוֹךְ יוֹמַיִם.",
            exampleNative = "Запуск программы в פְּלֵיי סְטוֹר одобрили в течение двух дней.",
         fillInBlankExclusions = listOf(176910L, 176911L, 176912L, 176913L, 176914L)),

        // ── mobile_ui (5) — мобильный интерфейс ──
        WordEntity(
            id = 176916, setId = 1769, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_ui", transliteration = "leyaaut",
            original = "לֵייאַאוּט", translation = "лейаут (расположение элементов)",
            definition = "סִידּוּר חָזוּתִי שֶׁל אֶלֶמֶנְטִים עַל הַמָּסָךְ — מָה אֵיפֹה וּבְאֵיזֶה גּוֹדֶל.",
            definitionNative = "Визуальное расположение элементов на экране — что где и какого размера.",
            example = "הַמְּעַצֵּב שִׁנָּה אֶת הַלֵּייאַאוּט שֶׁל הַטֹּפֶס פַּעֲמַיִם בִּשְׁבוּעַיִם.",
            exampleNative = "Дизайнер менял לֵייאַאוּט формы дважды за две недели.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176917, setId = 1769, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_ui", transliteration = "navigatsya",
            original = "נָווִיגַצְיָה", translation = "навигация (между экранами)",
            definition = "מַעֲרֶכֶת הַמַּעֲבָרִים בֵּין מָסָכִים — אֵיךְ הַמִּשְׁתַּמֵּשׁ מַגִּיעַ מִדַּף לְדַף.",
            definitionNative = "Система переходов между экранами — как пользователь попадает со страницы на страницу.",
            example = "נָווִיגַצְיָה מְבֻלְבֶּלֶת גּוֹרֶמֶת לְמִשְׁתַּמְּשִׁים לְהָסִיר אֶת הַתּוֹכְנָה.",
            exampleNative = "Запутанная נָווִיגַצְיָה заставляет пользователей удалять программу.",
         fillInBlankExclusions = listOf(176916L, 176918L, 176919L, 176920L)),
        WordEntity(
            id = 176918, setId = 1769, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_ui", transliteration = "animatsya",
            original = "אַנִימַצְיָה", translation = "анимация (UI)",
            definition = "תְּנוּעָה חֲלָקָה שֶׁל אֶלֶמֶנְטִים עַל הַמָּסָךְ — שֶׁעוֹזֶרֶת לְהָבִין מָה קָרָה.",
            definitionNative = "Плавное движение элементов на экране — помогает понять, что произошло.",
            example = "אַנִימַצְיָה קְצָרָה שֶׁל מַעֲבָר עוֹשָׂה אֶת הַתּוֹכְנָה לְהַרְגִּישׁ אֵיכוּתִית.",
            exampleNative = "Короткая אַנִימַצְיָה перехода делает программу качественной на ощупь.",
         fillInBlankExclusions = listOf(176916L, 176917L, 176919L, 176920L)),
        WordEntity(
            id = 176919, setId = 1769, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_ui", transliteration = "negishut",
            original = "נְגִישׁוּת", translation = "доступность (a11y)",
            definition = "תְּמִיכָה בְּמִשְׁתַּמְּשִׁים עִם מֻגְבָּלוּיוֹת — קוֹרְאֵי מָסָךְ, גּוֹדֶל גּוּפָן וְכַדּוֹמֶה.",
            definitionNative = "Поддержка пользователей с ограниченными возможностями — экранные читалки, размер шрифта и т.д.",
            example = "אַפֵּל מַחְמִירָה אֶת הַדְּרִישׁוֹת שֶׁל נְגִישׁוּת בְּכָל גִּרְסָה חֲדָשָׁה.",
            exampleNative = "Apple ужесточает требования к נְגִישׁוּת в каждой новой версии.",
         fillInBlankExclusions = listOf(176916L, 176917L, 176918L, 176920L)),
        WordEntity(
            id = 176920, setId = 1769, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_ui", transliteration = "ar-ti-el",
            original = "אַר-טִי-אֵל", translation = "RTL (справа-налево)",
            definition = "כִּוּוּן קְרִיאָה מִיָּמִין לִשְׂמֹאל — הֶכְרֵחִי לְעִבְרִית וַעֲרָבִית.",
            definitionNative = "Направление чтения справа налево — обязательно для иврита и арабского.",
            example = "תְּמִיכַת אַר-טִי-אֵל מְלֵאָה דּוֹרֶשֶׁת בְּדִיקַת כָּל מָסָךְ בְּעִבְרִית.",
            exampleNative = "Полная поддержка אַר-טִי-אֵל требует проверки каждого экрана на иврите.",
         fillInBlankExclusions = listOf(176916L, 176917L, 176918L, 176919L)),

        // ── mobile_lifecycle (5) — жизненный цикл приложения ──
        WordEntity(
            id = 176921, setId = 1769, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_lifecycle", transliteration = "matsav peil",
            original = "מַצָּב פָּעִיל", translation = "активное состояние (foreground)",
            definition = "הַמַּעֲמָד שֶׁבּוֹ הַתּוֹכְנָה רָצָה גְּלוּיָה עַל הַמָּסָךְ וּמְקַבֶּלֶת קְלָטִים מֵהַמִּשְׁתַּמֵּשׁ.",
            definitionNative = "Положение, когда программа работает видимой на экране и принимает ввод от пользователя.",
            example = "בְּמַצָּב פָּעִיל הָאַפְּלִיקַצְיָה מְקַבֶּלֶת אֶת מְלֹא מַשְׁאַבֵּי הַמַּכְשִׁיר.",
            exampleNative = "В מַצָּב פָּעִיל приложение получает все ресурсы устройства.",
         fillInBlankExclusions = listOf(176922L, 176923L, 176924L, 176925L)),
        WordEntity(
            id = 176922, setId = 1769, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "mobile_lifecycle", transliteration = "reka",
            original = "רֶקַע", translation = "фоновый режим (background)",
            definition = "מַצָּב שֶׁבּוֹ הַתּוֹכְנָה רָצָה בְּלִי שֶׁהַמִּשְׁתַּמֵּשׁ רוֹאֶה אוֹתָהּ עַל הַמָּסָךְ.",
            definitionNative = "Состояние, когда программа работает, не показываясь пользователю на экране.",
            example = "מַעֲרֶכֶת הַהַפְעָלָה מַגְבִּילָה תּוֹכְנוֹת בְּרֶקַע כְּדֵי לַחֲסוֹךְ סוֹלְלָה.",
            exampleNative = "ОС ограничивает программы в רֶקַע, чтобы экономить батарею.",
         fillInBlankExclusions = listOf(176921L, 176923L, 176924L, 176925L)),
        WordEntity(
            id = 176923, setId = 1769, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_lifecycle", transliteration = "makhzor khayey aktiviti",
            original = "מַחֲזוֹר חַיֵּי אַקְטִיבִיטִי", translation = "lifecycle активити",
            definition = "רֶצֶף הַשְּׁלָבִים שֶׁמָּסָךְ בְּאַנְדְרוֹייד עוֹבֵר — מֵהַיְצִירָה וְעַד הַסְּגִירָה.",
            definitionNative = "Цепочка стадий, которую экран в Android проходит — от создания до закрытия.",
            example = "טָעוּת בְּמַחֲזוֹר חַיֵּי אַקְטִיבִיטִי גּוֹרֶמֶת לִדְלִיפַת זִכָּרוֹן.",
            exampleNative = "Ошибка в מַחֲזוֹר חַיֵּי אַקְטִיבִיטִי приводит к утечке памяти.",
         fillInBlankExclusions = listOf(176921L, 176922L, 176924L, 176925L)),
        WordEntity(
            id = 176924, setId = 1769, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_lifecycle", transliteration = "vyu-model",
            original = "וְיוּ-מוֹדֶל", translation = "ViewModel",
            definition = "רְכִיב שֶׁמַּחְזִיק נְתוּנֵי מָסָךְ וְשׂוֹרֵד סִיבּוּב מַכְשִׁיר וּשִׁנּוּי תֵּצוּגָה.",
            definitionNative = "Компонент, держащий данные экрана и переживающий поворот устройства и смену конфигурации.",
            example = "וְיוּ-מוֹדֶל פּוֹתֵר אֶת בְּעָיַית אִבּוּד הַנְּתוּנִים בְּסִיבּוּב מַסָךְ.",
            exampleNative = "וְיוּ-מוֹדֶל решает проблему потери данных при повороте экрана.",
         fillInBlankExclusions = listOf(176921L, 176922L, 176923L, 176925L)),
        WordEntity(
            id = 176925, setId = 1769, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "mobile_lifecycle", transliteration = "shikhzur matsav",
            original = "שִׁחְזוּר מַצָּב", translation = "восстановление состояния",
            definition = "הַחֲזָרַת תֵּצוּגָה לַמָּקוֹם שֶׁהָיְתָה לִפְנֵי שֶׁהַמַּעֲרֶכֶת סָגְרָה אֶת הַתּוֹכְנָה.",
            definitionNative = "Возврат экрана туда, где он был, до того как система закрыла программу.",
            example = "שִׁחְזוּר מַצָּב טוֹב נוֹתֵן הַרְגָּשָׁה שֶׁהַתּוֹכְנָה לֹא נֶעֶצְרָה כְּלָל.",
            exampleNative = "Хороший שִׁחְזוּר מַצָּב создаёт ощущение, что программа вообще не останавливалась.",
         fillInBlankExclusions = listOf(176921L, 176922L, 176923L, 176924L)),
    )
}
