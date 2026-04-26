package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Хайтек" (рабочий процесс инженера в продуктовой компании).
 *
 * Set 1746: «Хайтек» — продвинутый L2 (UNCOMMON+RARE):
 *           ежедневный workflow разработчика — agile-церемонии, ревью кода, баги,
 *           релизы, коммуникация в команде.
 *
 * Лексика смешанная: иврит + множество английских заимствований
 * (סְפְּרִינְט, פּוּל רִיקְוֶסְט, מֶרְג׳, דֶּפְּלוֹי, רוֹלְבֵּק) — так реально говорят
 * в израильских хайтек-компаниях.
 *
 * Распределение редкостей: 13 UNCOMMON + 12 RARE.
 *
 * SemanticGroups (5 × 5):
 *   hightech_agile        — agile/scrum: спринт, дейли, ретро, планирование, рефайнмент
 *   hightech_code_review  — code review: PR, ревью, аппрув, мерж, дифф
 *   hightech_bugs         — работа с багами: тикет, воспроизведение, статус, приоритет, регрессия
 *   hightech_release      — релизы: версия, деплой, роллбек, хотфикс, чейнджлог
 *   hightech_team_comm    — коммуникация в команде: тимлид, менеджер, 1-on-1, фидбэк, синк
 *
 * Word IDs: setId × 100 + position (174601..174625).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewHightechL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1746, languagePair = "he-ru", orderIndex = 1746,
            name = "Хайтек",
            description = "Рабочий процесс: спринты, ревью кода, баги, релизы",
            topic = "Хайтек", level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1746 — Хайтек: продвинутый (L2, UNCOMMON+RARE)
        // 5 групп × 5 слов: agile, code_review, bugs, release, team_comm
        // ══════════════════════════════════════════════════════════════════════

        // ── hightech_agile (5) — церемонии scrum и agile-процесс ──
        WordEntity(
            id = 174601, setId = 1746, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_agile", transliteration = "sprint",
            original = "סְפְּרִינְט", translation = "спринт",
            definition = "מָחֲזוֹר עֲבוֹדָה קָצָר שֶׁל שָׁבוּעַיִם, שֶׁבְּסוֹפוֹ הַצֶּוֶות מַסְפִּיק לְמַסֵּר תּוֹצָר.",
            definitionNative = "Короткий цикл работы — пару недель, в конце команда сдаёт результат.",
            example = "סְפְּרִינְט הַבָּא מַתְחִיל בְּיוֹם רִאשׁוֹן וְכוֹלֵל שִׁיפּוּצֵי בִּיצוּעִים.",
            exampleNative = "Следующий סְפְּרִינְט начинается в воскресенье и включает оптимизацию производительности.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174602, setId = 1746, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_agile", transliteration = "deili",
            original = "דֵּיְילִי", translation = "дейли (ежедневная встреча)",
            definition = "פְּגִישָׁה קְצָרָה כָּל בֹּקֶר שֶׁבָּהּ כָּל מְפַתֵּחַ אוֹמֵר מָה עָשָׂה וּמָה יַעֲשֶׂה.",
            definitionNative = "Короткая встреча по утрам — каждый разработчик говорит, что сделал и что планирует.",
            example = "בַּדֵּיְילִי שֶׁל הַבֹּקֶר הִתְלוֹנַנְתִּי עַל חֲסִימָה בְּהַרְשָׁאוֹת שֶׁל הַשֵּׁרֵת.",
            exampleNative = "На утреннем דֵּיְילִי я пожаловался на блок с правами доступа на сервере.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174603, setId = 1746, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_agile", transliteration = "retrospektiv",
            original = "רֶטְרוֹסְפֶּקְטִיב", translation = "ретроспектива",
            definition = "פְּגִישָׁה בְּסוֹף מָחֲזוֹר שֶׁל דִּיוּן עַל מָה עָבַד טוֹב וּמָה צָרִיךְ לְשַׁפֵּר.",
            definitionNative = "Встреча в конце цикла — обсуждают, что прошло хорошо и что нужно улучшить.",
            example = "בָּרֶטְרוֹסְפֶּקְטִיב הֶחְלַטְנוּ לְקַצֵּר אֶת אֹרֶךְ הַפְּגִישׁוֹת בָּעֲתִיד.",
            exampleNative = "На רֶטְרוֹסְפֶּקְטִיב мы решили в будущем сократить продолжительность встреч.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174604, setId = 1746, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_agile", transliteration = "planing",
            original = "פְּלָנִינְג", translation = "планирование (planning)",
            definition = "פְּגִישָׁה שֶׁבָּהּ בּוֹחֲרִים אֵילוּ מְשִׂימוֹת יִכָּנְסוּ לַמָּחֲזוֹר הַקָּרוֹב.",
            definitionNative = "Встреча, на которой выбирают, какие задачи войдут в ближайший цикл.",
            example = "פְּלָנִינְג שֶׁל יוֹם שֵׁנִי אָרַךְ שָׁעָתַיִם בִּגְלַל מַחְלוֹקוֹת עַל הָעֲדִיפוּת.",
            exampleNative = "פְּלָנִינְג в понедельник длился два часа из-за споров о приоритетах.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174605, setId = 1746, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_agile", transliteration = "rifaynment",
            original = "רִיפַיְינְמֶנְט", translation = "рефайнмент (refinement)",
            definition = "סֶשֵׁן שֶׁבּוֹ הַצֶּוֶות מְלַטֵּשׁ אֶת תֵּאוּרֵי הַמְּשִׂימוֹת לִפְנֵי הַתְּכְנוּן הָרִשְׁמִי.",
            definitionNative = "Сессия, где команда уточняет описания задач до формального планирования.",
            example = "בָּרִיפַיְינְמֶנְט גִּלִּינוּ שֶׁמְּשִׂימָה אַחַת דּוֹרֶשֶׁת חֲקִירָה אֲרֻוכָּה.",
            exampleNative = "На רִיפַיְינְמֶנְט мы поняли, что одна задача требует долгого исследования.",
            isFillInBlankSafe = false,
        ),

        // ── hightech_code_review (5) — процесс ревью кода ──
        WordEntity(
            id = 174606, setId = 1746, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_code_review", transliteration = "pul rikvest",
            original = "פּוּל רִיקְוֶסְט", translation = "pull request (PR)",
            definition = "בַּקָּשָׁה לְמַזְּגוּ שִׁנּוּיֵי קוֹד מֵעָנָף צָדָדִי אֶל הָעָנָף הָרָאשִׁי שֶׁל הַפּרוֹיֶקְט.",
            definitionNative = "Просьба влить изменения кода из побочной ветки в главную ветку проекта.",
            example = "פָּתַחְתִּי פּוּל רִיקְוֶסְט עִם תֵּאוּר מַקִּיף וְצִילּוּמֵי מָסָךְ.",
            exampleNative = "Я открыл פּוּל רִיקְוֶסְט с подробным описанием и скриншотами.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174607, setId = 1746, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_code_review", transliteration = "kod rivyu",
            original = "קוֹד רִיוויוּ", translation = "ревью кода",
            definition = "בְּדִיקָה שֶׁל קוֹד שֶׁכָּתַב מִישֶׁהוּ אַחֵר, לְפִי הֶעָרוֹת וְשִׁפּוּרִים.",
            definitionNative = "Проверка кода, который написал кто-то другой — с замечаниями и предложениями.",
            example = "קוֹד רִיוויוּ שֶׁלִּי גִּלָּה שָׁלוֹשׁ דְּלִיפוֹת זִכָּרוֹן בְּמוֹדוּל הַפְּלִיטָה.",
            exampleNative = "Мой קוֹד רִיוויוּ выявил три утечки памяти в модуле выгрузки.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174608, setId = 1746, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_code_review", transliteration = "aprov",
            original = "אַפְּרוּב", translation = "аппрув (одобрение)",
            definition = "סִימָן יָרֹק שֶׁל בּוֹדֵק הַקּוֹד שֶׁכָּל הַשִּׁנּוּיִים מוּכָנִים לְהִתְמַזֵּג.",
            definitionNative = "Зелёный значок от ревьюера — все изменения готовы к слиянию.",
            example = "מְחַכֶּה לָאַפְּרוּב הָאַחֲרוֹן מֵהָאַרְכִיטֶקְט לִפְנֵי שֶׁמַּעֲבִיר לַפְּרוֹדָקְשִׁן.",
            exampleNative = "Жду последний אַפְּרוּב от архитектора, прежде чем выкатывать на продакшн.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174609, setId = 1746, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_code_review", transliteration = "merj",
            original = "מֶרְג׳", translation = "мерж (слияние веток)",
            definition = "פְּעֻלָּה שֶׁמְּחַבֶּרֶת שִׁנּוּיִים מִשְּׁנֵי עֲנָפִים לְעָנָף אֶחָד מְשֻׁלָּב.",
            definitionNative = "Действие, которое объединяет правки из двух веток в одну общую.",
            example = "אַחֲרֵי הַמֶּרְג׳ נִשְׁבַּר טֶסְט אוֹטוֹמָטִי בְּצִינוֹר הָאִינְטֶגְרַצְיָה.",
            exampleNative = "После מֶרְג׳ сломался автотест в пайплайне интеграции.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174610, setId = 1746, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_code_review", transliteration = "dif",
            original = "דִּיף", translation = "дифф (различия в коде)",
            definition = "תְּצוּגָה צָבְעוֹנִית שֶׁל הַשּׁוּרוֹת שֶׁנּוֹסְפוּ אוֹ נִמְחֲקוּ בֵּין שְׁתֵּי גִּרְסָאוֹת.",
            definitionNative = "Цветной показ строк, которые добавились или удалились между двумя версиями.",
            example = "הִסְתַּכַּלְתִּי עַל הַדִּיף וְהֵבַנְתִּי שֶׁשָּׁכַחְתִּי לְמָחֹק קוֹד דִּיבּוּג.",
            exampleNative = "Я посмотрел на דִּיף и понял, что забыл удалить отладочный код.",
            isFillInBlankSafe = false,
        ),

        // ── hightech_bugs (5) — работа с багами ──
        WordEntity(
            id = 174611, setId = 1746, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_bugs", transliteration = "tiket",
            original = "תִּיקֶט", translation = "тикет",
            definition = "רְשׁוּמָה בַּמַּעֲרֶכֶת שֶׁל מַעֲקָב מְשִׂימוֹת שֶׁמְּתָאֶרֶת תַּקָּלָה אוֹ בַּקָּשָׁה.",
            definitionNative = "Запись в системе отслеживания задач — описывает поломку или просьбу.",
            example = "פָּתַחְתִּי תִּיקֶט עִם צִילּוּמֵי מָסָךְ וְלוֹגִים מֵהַשֵּׁרֵת הַמֶּרְכָּזִי.",
            exampleNative = "Я открыл תִּיקֶט со скриншотами и логами с центрального сервера.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174612, setId = 1746, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_bugs", transliteration = "shikhzur bag",
            original = "שִׁחְזוּר בָּאג", translation = "воспроизведение бага",
            definition = "סֵדֶר שֶׁל פְּעֻלּוֹת שֶׁהוֹפֵךְ אֶת הַתַּקָּלָה לְעוֹבֶדֶת שׁוּב מוּל הַמְּפַתֵּחַ.",
            definitionNative = "Последовательность шагов, после которой поломка повторяется на глазах у разработчика.",
            example = "בְּלִי שִׁחְזוּר בָּאג אֲמִין הַמְּפַתֵּחַ אֵינוֹ יָכוֹל לְתַקֵּן כְּלוּם.",
            exampleNative = "Без надёжного שִׁחְזוּר בָּאג разработчик вообще ничего не починит.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174613, setId = 1746, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_bugs", transliteration = "status",
            original = "סְטָטוּס", translation = "статус",
            definition = "הַשָּׁלָב הַנּוֹכְחִי שֶׁל מְשִׂימָה בַּמַּעֲרֶכֶת — פָּתוּחַ, בִּטִפּוּל, סָגוּר אוֹ נִדְחָה.",
            definitionNative = "Текущий этап задачи в системе — открыт, в работе, закрыт или отклонён.",
            example = "הַסְּטָטוּס הִשְׁתַּנָּה לְ-«בִּבְדִיקָה» אַחֲרֵי שֶׁהַטֶסְטֵר קִבֵּל אֶת הַמְּשִׂימָה.",
            exampleNative = "סְטָטוּס сменился на «на проверке» после того, как тестировщик принял задачу.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174614, setId = 1746, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_bugs", transliteration = "adifut",
            original = "עֲדִיפוּת", translation = "приоритет",
            definition = "דַּרְגַּת הַחֲשִׁיבוּת שֶׁמַּחְלִיטָה בְּאֵיזֶה סֵדֶר מְפַתְּחִים מְטַפְּלִים בִּמְשִׂימוֹת.",
            definitionNative = "Степень важности — определяет, в каком порядке разработчики берут задачи.",
            example = "הַתִּיקֶט קִבֵּל עֲדִיפוּת גְּבוֹהָה כִּי כָּל הָאֲתָר הָיָה לֹא נָגִישׁ.",
            exampleNative = "Тикет получил высокую עֲדִיפוּת, потому что весь сайт был недоступен.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174615, setId = 1746, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_bugs", transliteration = "edzh-keys",
            original = "אֶג'-קֵייס", translation = "пограничный случай (edge case)",
            definition = "מָצָב גְּבוּל לֹא רָגִיל שֶׁבּוֹ הַתּוֹכְנָה מַתְנַהֶגֶת אַחֶרֶת מֵהַצָּפוּי.",
            definitionNative = "Редкий пограничный сценарий, когда программа ведёт себя не как обычно.",
            example = "הַתַּקָּלָה קָרְתָה רַק בְּאֶג'-קֵייס שֶׁל מִשְׁתַּמֵּשׁ עִם תִּשְׁעִים תָּגִּיּוֹת בָּרְשִׁימָה.",
            exampleNative = "Сбой случился только в אֶג'-קֵייס у пользователя с девяноста тегами в списке.",
            isFillInBlankSafe = false,
        ),

        // ── hightech_release (5) — релизы и развёртывание ──
        WordEntity(
            id = 174616, setId = 1746, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_release", transliteration = "stejging",
            original = "סְטֵייגִ'ינְג", translation = "стейджинг (тестовая среда)",
            definition = "סְבִיבָה כִּמְעַט-זֵהָה לַפְּרוֹדַקְשֶׁן שֶׁבָּהּ בּוֹדְקִים גִּרְסָה לִפְנֵי שִׁחְרוּר לַמִּשְׁתַּמְּשִׁים.",
            definitionNative = "Среда, почти как продакшен — там проверяют сборку до выкатки на пользователей.",
            example = "הַפִיצֶ׳ר עָבַד נִפְלָא בְּסְטֵייגִ'ינְג אֲבָל קָרַס תּוֹךְ דַּקָּה בַּפְּרוֹדַקְשֶׁן.",
            exampleNative = "Фича прекрасно работала в סְטֵייגִ'ינְג, но рухнула за минуту в проде.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174617, setId = 1746, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_release", transliteration = "deploy",
            original = "דֶּפְּלוֹי", translation = "деплой",
            definition = "פְּעֻלָּה שֶׁמַּעֲבִירָה קוֹד מַחְשֵׁב חָדָשׁ לַשְּׁרָתִים שֶׁל הַמִּשְׁתַּמְּשִׁים בָּעוֹלָם.",
            definitionNative = "Действие, которое переносит свежий код на серверы пользователей в мире.",
            example = "דֶּפְּלוֹי שֶׁל יוֹם שִׁישִּׁי גָּרַם לְלַחַץ בַּצֶּוֶות עַד הַסִּיּוּם.",
            exampleNative = "דֶּפְּלוֹי в пятницу вызвал стресс в команде до самого завершения.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174618, setId = 1746, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_release", transliteration = "rolbek",
            original = "רוֹלְבֵּק", translation = "роллбек (откат)",
            definition = "חֲזָרָה מְהִירָה לַשִּׁכְבָה הַקּוֹדֶמֶת אַחֲרֵי שֶׁהִתְגַּלְּתָה תַּקָּלָה בַּחֲדָשָׁה.",
            definitionNative = "Быстрый возврат на прежний слой — после того, как в новом нашли поломку.",
            example = "עָשִׂינוּ רוֹלְבֵּק חָמֵשׁ דַּקּוֹת אַחֲרֵי שֶׁתָּפַסְנוּ עֲלִיָּה בְּשִׁעוּר הַשְּׁגִיאוֹת.",
            exampleNative = "Мы сделали רוֹלְבֵּק через пять минут, как заметили рост ошибок.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174619, setId = 1746, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_release", transliteration = "hotfiks",
            original = "הוֹטְפִיקְס", translation = "хотфикс",
            definition = "תִּקּוּן דָּחוּף וּקְצַר טְוַח שֶׁיּוֹצֵא לַמִּשְׁתַּמְּשִׁים בְּלִי לְחַכּוֹת לַמָּחֲזוֹר הָרָגִיל.",
            definitionNative = "Срочная мелкая правка — выходит к пользователям, не дожидаясь обычного цикла.",
            example = "הִכִּינּוּ הוֹטְפִיקְס בְּלַיְלָה אַחֲרֵי שֶׁמִּשְׁתַּמְּשִׁים לֹא הִצְלִיחוּ לְהִתְחַבֵּר.",
            exampleNative = "Мы подготовили הוֹטְפִיקְס ночью, после того как пользователи не могли войти.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174620, setId = 1746, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_release", transliteration = "cheinjlog",
            original = "צֵ׳יְינְגְ׳לוֹג", translation = "чейнджлог",
            definition = "רְשִׁימָה כְּתוּבָה שֶׁל כָּל הַשִּׁנּוּיִים וְהַתִּיקּוּנִים בֵּין שִׁכְבָה לְשִׁכְבָה.",
            definitionNative = "Письменный список всех правок и починок между одним слоем и следующим.",
            example = "כָּתַבְתִּי צֵ׳יְינְגְ׳לוֹג בָּהִיר עִם קַטָגוֹרְיוֹת לְפִיצֶ׳רִים וּתִקּוּנִים.",
            exampleNative = "Я написал понятный צֵ׳יְינְגְ׳לוֹג с категориями для фич и починок.",
            isFillInBlankSafe = false,
        ),

        // ── hightech_team_comm (5) — коммуникация в команде ──
        WordEntity(
            id = 174621, setId = 1746, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_team_comm", transliteration = "timlid",
            original = "תִּימְלִיד", translation = "тимлид",
            definition = "מְפַתֵּחַ בָּכִיר שֶׁמַּדְרִיךְ אַנְשֵׁי הַצֶּוֶות וְאַחְרַאי עַל הַתּוֹצָר הַטֶּכְנִי.",
            definitionNative = "Старший разработчик — направляет людей в команде и отвечает за технический результат.",
            example = "הַתִּימְלִיד שֶׁלִּי מְקַיֵּם פְּגִישׁוֹת אֲרֻוכּוֹת עִם כָּל מְפַתֵּחַ בְּסוֹף הַחֹדֶשׁ.",
            exampleNative = "Мой תִּימְלִיד проводит длинные встречи с каждым разработчиком в конце месяца.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174622, setId = 1746, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_team_comm", transliteration = "menejer",
            original = "מֶנֶגֶ׳ר", translation = "менеджер",
            definition = "אַחְרַאי עַל אֲנָשִׁים — שָׂכָר, קִדּוּם, מַשּׁוֹב וּמְעוֹדֵד הִתְפַּתְּחוּת אִישִׁית.",
            definitionNative = "Отвечает за людей — зарплату, повышения, обратную связь и личный рост.",
            example = "הַמֶּנֶגֶ׳ר מָסַר לִי שֶׁאֲנִי מוּכָן לְהַעֲלָאַת דַּרְגָּה בִּתְחִלַּת הַשָּׁנָה.",
            exampleNative = "מֶנֶגֶ׳ר сообщил мне, что я готов к повышению грейда в начале года.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174623, setId = 1746, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_team_comm", transliteration = "van-on-van",
            original = "וַן-אוֹן-וַן", translation = "встреча 1-on-1",
            definition = "פְּגִישָׁה אִישִׁית שְׁבוּעִית שֶׁל הַמְּנַהֵל עִם כָּל אֶחָד מֵאַנְשֵׁי הַצֶּוֶות בְּנִפְרָד.",
            definitionNative = "Личная еженедельная встреча руководителя с каждым из людей команды отдельно.",
            example = "בָּוַן-אוֹן-וַן דִּבַּרְנוּ עַל מַסְלוּל הַקַּרְיֵרָה שֶׁלִּי לְשָׁלוֹשׁ שָׁנִים קָדִימָה.",
            exampleNative = "На וַן-אוֹן-וַן мы говорили о моей карьерной траектории на три года вперёд.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174624, setId = 1746, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "hightech_team_comm", transliteration = "fidbek",
            original = "פִידְבֵּק", translation = "фидбэк",
            definition = "תְּגוּבָה כְּנָה לַעֲבוֹדַת אָדָם שֶׁעוֹזֶרֶת לוֹ לְהָבִין מָה לְהַמְשִׁיךְ אוֹ לְשַׁנּוֹת.",
            definitionNative = "Честный отклик о работе человека — помогает ему понять, что продолжать или менять.",
            example = "פִידְבֵּק יָשִׁיר מֵעֲמִיתִים שִׁפֵּר אֶת הָעֲבוֹדָה שֶׁלִּי מֵרָבָעוֹן לְרָבָעוֹן.",
            exampleNative = "Прямой פִידְבֵּק от коллег улучшал мою работу от квартала к кварталу.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174625, setId = 1746, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "hightech_team_comm", transliteration = "sink",
            original = "סִינְק", translation = "синк (синхронизация)",
            definition = "פְּגִישָׁה קְצָרָה שֶׁל שְׁנֵי צְוָתִים אוֹ אֲנָשִׁים לְעַדְכֵּן זֶה אֶת זֶה בַּהִתְקַדְּמוּת.",
            definitionNative = "Короткая встреча двух команд или людей — обновить друг друга по продвижению.",
            example = "קָבַעְתִּי סִינְק שְׁבוּעִי עִם צֶוֶות הַמּוּצָר כְּדֵי לִמְנֹעַ הַפְתָּעוֹת.",
            exampleNative = "Я назначил еженедельный סִינְק с продуктовой командой, чтобы избежать сюрпризов.",
            isFillInBlankSafe = false,
        ),
    )
}
