package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrewBatch25 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1099, languagePair = "he-ru", orderIndex = 1099,
            name = "Технологии",
            description = "Атаки, защита и киберугрозы",
            topic = "Технологии",
            level = 4
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Set 1097: Математика ───────────────────────────────────────────

        // UNCOMMON (A2-B1),

        // UNCOMMON (A2-B1),

        // RARE (B2),

        // RARE (B2),

        // ── Set 1098: Физика и химия ───────────────────────────────────────

        // UNCOMMON (A2-B1),

        // UNCOMMON (A2-B1),

        // RARE (B2),

        // RARE (B2),

        // ── Set 1099: ИТ-безопасность ──────────────────────────────────────

        // EPIC (C1),
        WordEntity(id = 109901, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_defense_arch", transliteration = "hatzpana simetrit",
            original = "הַצְפָּנָה סִימֶטְרִית", translation = "симметричное шифрование",
            definition = "שִׁיטָה הַמְּשַׁתֶּמֶת בְּמַפְתֵּחַ סוֹדִי אֶחָד גַּם לְקִוְדּוּד הַמֵּידָע וְגַם לְפִעְנוּחוֹ.",
            definitionNative = "Способ кодирования, при котором один общий секретный ключ используется и для зашифровки, и для расшифровки данных.",
            example = "הַצְפָּנָה סִימֶטְרִית מְהִירָה אַךְ דּוֹרֶשֶׁת חִלּוּף בָּטוּחַ שֶׁל הַמַּפְתֵּחַ.",
            exampleNative = "הַצְפָּנָה סִימֶטְרִית работает быстро, но требует безопасного обмена ключом между сторонами.", fillInBlankExclusions = listOf(109906L, 109917L, 109923L, 109924L)),

        WordEntity(id = 109902, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_identity_pki", transliteration = "otentikatziya",
            original = "אוֹתֶנְטִיקַצְיָה", translation = "аутентификация",
            definition = "תַּהֲלִיךְ אִימּוּת זֶהוּת הַמִּשְׁתַּמֵּשׁ לִפְנֵי שֶׁמְּקַבֵּל גִּישָׁה לַמַּעֲרֶכֶת.",
            definitionNative = "Проверка того, что пользователь действительно тот, за кого себя выдаёт, перед доступом к системе.",
            example = "אוֹתֶנְטִיקַצְיָה דּוּ-שְׁלַבִּית מְצִּמְצֶמֶת מְאֹד אֶת סִכּוּן הַחֲדִירָה.",
            exampleNative = "Двухфакторная אוֹתֶנְטִיקַצְיָה значительно снижает риск взлома учётной записи.", fillInBlankExclusions = listOf(109903L, 109910L, 109920L)),

        WordEntity(id = 109903, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_identity_pki", transliteration = "ishur digitali",
            original = "אִישּׁוּר דִּיגִיטַלִי", translation = "цифровой сертификат",
            definition = "קֹבֶץ אֶלֶקְטְרוֹנִי הַמְּקַשֵּׁר זֶהוּת בְּעָלִים לְמַפְתֵּחַ צִיבּוּרִי וּמַצְהִיר עַל אֲמִיתּוּתָהּ.",
            definitionNative = "Электронный документ, который связывает открытый ключ с конкретным владельцем и подтверждает его подлинность.",
            example = "הַדַּפְדְּפָן דּוֹחֶה אֶת הָאֲתַר אִם אִישּׁוּר דִּיגִיטַלִי פָּג תֹּקֶף.",
            exampleNative = "Браузер блокирует сайт, если его אִישּׁוּר דִּיגִיטַלִי просрочен или отозван.", fillInBlankExclusions = listOf(109902L, 109910L, 109920L)),

        WordEntity(id = 109904, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_resilience", transliteration = "gibuy netunim",
            original = "גִּבּוּי נְתוּנִים", translation = "резервное копирование данных",
            definition = "הֶעְתֵּק שָׁמוּר שֶׁל מֵידָע, שֶׁמְּאַפְשֵׁר שִׁיחְזוּר לְאַחַר תָּקָלָה אוֹ תְּקִיפָה.",
            definitionNative = "Сохранённая копия информации, которая позволяет восстановить её после сбоя, ошибки или кибератаки.",
            example = "אַחַר הַתְּקִיפָה שִׁיחְזַרְנוּ אֶת הַמַּעֲרֶכֶת מִתּוֹךְ גִּבּוּי נְתוּנִים יוֹמִי.",
            exampleNative = "После атаки мы восстановили систему из ежедневного גִּבּוּי נְתוּנִים без потери файлов.", fillInBlankExclusions = listOf(109908L, 109914L, 109918L, 109925L)),

        WordEntity(id = 109905, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_threat_concepts", transliteration = "srikat khulshot",
            original = "סְרִיקַת חוּלְשׁוֹת", translation = "сканирование уязвимостей",
            definition = "בְּדִיקָה אוֹטוֹמָטִית הַמְּאַתֶּרֶת פִּרְצוֹת אֶפְשָׁרִיּוֹת בְּמַעֲרֶכֶת לִפְנֵי שֶׁתּוֹקֵף יְנַצֵּל אוֹתָן.",
            definitionNative = "Автоматический поиск слабых мест в системе с помощью специальных программ перед возможной атакой.",
            example = "סְרִיקַת חוּלְשׁוֹת חֹדְשִׁית מְגַלָּה רְכִיבִים שֶׁדּוֹרְשִׁים עִדְכּוּן דָּחוּף.",
            exampleNative = "Ежемесячное סְרִיקַת חוּלְשׁוֹת выявляет компоненты, требующие срочного обновления.", fillInBlankExclusions = listOf(109913L, 109919L, 109921L, 109922L)),

        WordEntity(id = 109906, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_defense_arch", transliteration = "khalukat reshet",
            original = "חֲלוּקַת רְשָׁת", translation = "сегментация сети",
            definition = "פִּיצּוּל הַתַּשְׁתִּית לְאֵזוֹרִים מְבוּדָדִים, כְּדֵי לְהָקְשׁוֹת עַל תּוֹקֵף לְהִתְפַּשֵּׁט בְּתוֹכָהּ.",
            definitionNative = "Разделение единой инфраструктуры на изолированные зоны, чтобы злоумышленник не мог свободно перемещаться внутри.",
            example = "חֲלוּקַת רְשָׁת קְפֵדָנִית מוֹנַעַת הִתְפַּשְּׁטוּת תְּקִיפָה בֵּין מַחְלָקוֹת.",
            exampleNative = "Жёсткое חֲלוּקַת רְשָׁת предотвращает распространение атаки между подразделениями компании.", fillInBlankExclusions = listOf(109901L, 109917L, 109923L, 109924L)),

        WordEntity(id = 109907, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_offensive", transliteration = "kle pritza",
            original = "כְּלֵי פְּרִיצָה", translation = "инструменты взлома",
            definition = "תּוֹכְנוֹת הַמְּשַׁמְּשׁוֹת תּוֹקְפִים לְנִצּוּל פִּרְצוֹת בְּמַעֲרָכוֹת מַחְשֵׁב וְלַחֲדִירָה לְתוֹכָן.",
            definitionNative = "Программное обеспечение, которое атакующие применяют для проникновения в чужие компьютерные системы.",
            example = "צֶבַע אָדוֹם מְשַׁמֵּשׁ כְּלֵי פְּרִיצָה לֵגַלִיִּים בִּתְרְגוּלִים פְּנִימִיִּים.",
            exampleNative = "Команда red team использует легальные כְּלֵי פְּרִיצָה во внутренних учениях.", fillInBlankExclusions = listOf(109909L, 109911L, 109912L, 109915L, 109916L)),

        WordEntity(id = 109908, setId = 1099, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_resilience", transliteration = "nkudat knisa",
            original = "נְקוּדַת כְּנִיסָה", translation = "точка входа (в систему)",
            definition = "הַמָּקוֹם שֶׁבּוֹ תּוֹקֵף מַתְחִיל אֶת הַחֲדִירָה הָרִאשׁוֹנָה אֶל תּוֹךְ הַמַּעֲרֶכֶת.",
            definitionNative = "Место в инфраструктуре, через которое атакующий впервые получает доступ к внутренним ресурсам.",
            example = "דֹּאַר אֶלֶקְטְרוֹנִי נוֹתָר נְקוּדַת כְּנִיסָה הַשְּׁכִיחָה בְּיוֹתֵר.",
            exampleNative = "Корпоративная электронная почта остаётся самой частой נְקוּדַת כְּנִיסָה для злоумышленников.", fillInBlankExclusions = listOf(109904L, 109914L, 109918L, 109925L)),

        WordEntity(id = 109909, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_offensive", transliteration = "hashtala merakhoq",
            original = "הַשְׁתָּלָה מֵרָחוֹק", translation = "удалённое внедрение кода",
            definition = "הַחְדָּרַת קוֹד זָדוֹנִי לְמַחְשֵׁב הַקָּרְבָּן מִמָּקוֹם אַחֵר, בְּלִי גִּישָׁה פִיזִית אֵלָיו.",
            definitionNative = "Загрузка и запуск вредоносного кода на чужой машине без физического доступа к ней.",
            example = "פִּרְצָה בַּשְּׁרָת אִפְשְׁרָה הַשְׁתָּלָה מֵרָחוֹק שֶׁל סוּס טְרוֹיָאנִי.",
            exampleNative = "Уязвимость в сервере позволила הַשְׁתָּלָה מֵרָחוֹק троянской программы.", fillInBlankExclusions = listOf(109907L, 109911L, 109912L, 109915L, 109916L)),

        WordEntity(id = 109910, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_identity_pki", transliteration = "tshtit maftea tzibburi",
            original = "תְּשְׁתִּית מַפְתֵּחַ צִיבּוּרִי", translation = "инфраструктура открытых ключей (PKI)",
            definition = "מַעֲרֶכֶת הַמְּנַהֶלֶת הַנְפָּקָה וְאִימּוּת שֶׁל אִישּׁוּרִים דִּיגִיטַלִיִּים לְחִבּוּרִים מוּגָנִים.",
            definitionNative = "Система выдачи и проверки электронных удостоверений, на которой держатся защищённые соединения в интернете.",
            example = "תְּשְׁתִּית מַפְתֵּחַ צִיבּוּרִי שֶׁל הַמְּדִינָה מְאַפְשֶׁרֶת חֲתִימוֹת רִשְׁמִיּוֹת.",
            exampleNative = "Государственная תְּשְׁתִּית מַפְתֵּחַ צִיבּוּרִי обеспечивает юридически значимые электронные подписи.", fillInBlankExclusions = listOf(109902L, 109903L, 109920L)),

        WordEntity(id = 109911, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_offensive", transliteration = "tkifat sharsheret aspaka",
            original = "תְּקִיפַת שַׁרְשֶׁרֶת אַסְפָּקָה", translation = "атака на цепочку поставок",
            definition = "מַכָּה בְּסַפָּק תּוֹכְנָה מְהֵימָן, כְּדֵי לְהַגִּיעַ דַּרְכּוֹ אֶל כָּל לָקוֹחוֹתָיו.",
            definitionNative = "Удар по доверенному поставщику программ, через которого вредоносный код попадает дальше ко всем его клиентам.",
            example = "תְּקִיפַת שַׁרְשֶׁרֶת אַסְפָּקָה זִעְזְעָה אֶלֶף חֶבְרוֹת בְּעַדְכּוּן יָחִיד.",
            exampleNative = "Громкая תְּקִיפַת שַׁרְשֶׁרֶת אַסְפָּקָה задела тысячу компаний через одно обновление.", fillInBlankExclusions = listOf(109907L, 109909L, 109912L, 109915L, 109916L)),

        WordEntity(id = 109912, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_offensive", transliteration = "hadamayt tzeva adom",
            original = "הֲדָמָיַת צֶבַע אָדוֹם", translation = "учения red team",
            definition = "תַּרְגִּיל מְבֻקָּר שֶׁבּוֹ צֶוֶת תּוֹקֵף יְזוּם בּוֹחֵן אֶת הַגָּנוֹת הָאִרְגוּן.",
            definitionNative = "Контролируемое нападение на собственную инфраструктуру, чтобы оценить, насколько хорошо защита выдержит реального противника.",
            example = "הֲדָמָיַת צֶבַע אָדוֹם חָשְׂפָה כָּשֶׁל בִּמְעַרְכֶת הַזִּיהוּי הָאַרְגּוּנִית.",
            exampleNative = "הֲדָמָיַת צֶבַע אָדוֹם обнажила слабость корпоративной системы обнаружения.", fillInBlankExclusions = listOf(109907L, 109909L, 109911L, 109915L, 109916L)),

        WordEntity(id = 109913, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_threat_concepts", transliteration = "zihuy khrigut",
            original = "זִיהוּי חֲרִיגוּת", translation = "обнаружение аномалий",
            definition = "אִתּוּר אוֹטוֹמָטִי שֶׁל הִתְנַהֲגוּת חוֹרֶגֶת מֵהַשִּׁגְרָה הָרְגִילָה שֶׁל הַמַּעֲרֶכֶת.",
            definitionNative = "Поиск событий, которые выбиваются из обычной картины поведения сети или сотрудников.",
            example = "מַעֲרֶכֶת זִיהוּי חֲרִיגוּת הִתְרִיעָה עַל הִתְחַבְּרוּת חֲשׁוּדָה בַּלַּיְלָה.",
            exampleNative = "Система זִיהוּי חֲרִיגוּת подняла тревогу из-за подозрительного входа в нерабочее время.", fillInBlankExclusions = listOf(109905L, 109919L, 109921L, 109922L)),

        WordEntity(id = 109914, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_resilience", transliteration = "amidut bmerkhav hasayber",
            original = "עֲמִידוּת בְּמֶרְחָב הַסַּיְיבֶּר", translation = "устойчивость в киберпространстве",
            definition = "יְכֹלֶת אִרְגוּן לְהַמְשִׁיךְ לִפְעֹל וּלְהִתְאוֹשֵׁשׁ גַּם תַּחַת תְּקִיפָה דִּיגִיטָלִית מִתְמַשֶּׁכֶת.",
            definitionNative = "Способность организации продолжать работу и быстро восстанавливаться даже во время продолжающейся цифровой атаки.",
            example = "עֲמִידוּת בְּמֶרְחָב הַסַּיְיבֶּר נִבְחֶנֶת בִּתְרְגוּלִים שְׁנָתִיִּים.",
            exampleNative = "עֲמִידוּת בְּמֶרְחָב הַסַּיְיבֶּר проверяется на ежегодных учениях с симуляцией атаки.", fillInBlankExclusions = listOf(109904L, 109908L, 109918L, 109925L)),

        WordEntity(id = 109915, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_offensive", transliteration = "handasa khevratit metukhemet",
            original = "הַנְדָּסָה חֶבְרָתִית מְתוּחְכֶּמֶת", translation = "продвинутая социальная инженерия",
            definition = "מְנִיפּוּלַצְיָה פְּסִיכוֹלוֹגִית עַל עוֹבֵד כְּדֵי שֶׁיִּמְסֹר מֵידָע סוֹדִי אוֹ יִפְתַּח גִּישָׁה.",
            definitionNative = "Тонкое психологическое воздействие на сотрудника, чтобы он сам выдал секретные сведения или открыл доступ.",
            example = "הַנְדָּסָה חֶבְרָתִית מְתוּחְכֶּמֶת שִׁכְנְעָה אֶת הַמַּזְכִּירָה לִמְסוֹר סִיסְמָה.",
            exampleNative = "Многоступенчатая הַנְדָּסָה חֶבְרָתִית מְתוּחְכֶּמֶת убедила секретаря выдать рабочий пароль.", fillInBlankExclusions = listOf(109907L, 109909L, 109911L, 109912L, 109916L)),

        WordEntity(id = 109916, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_offensive", transliteration = "shitot hakhba'a",
            original = "שִׁיטוֹת הַחְבָּאָה", translation = "методы обфускации",
            definition = "טֶכְנִיקוֹת מַסְוֶה הַגּוֹרְמוֹת לְקוֹד זָדוֹנִי לְהֵירָאוֹת תָּמִים בְּעֵינֵי כְּלֵי אַבְטָחָה.",
            definitionNative = "Приёмы маскировки вредоносного кода, чтобы антивирусы не распознали его и пропустили внутрь системы.",
            example = "שִׁיטוֹת הַחְבָּאָה מַצְלִיחוֹת לְעַקֵּף סוֹרְקֵי וִירוּסִים מָסוֹרְתִּיִּים.",
            exampleNative = "Современные שִׁיטוֹת הַחְבָּאָה позволяют обходить классические сигнатурные антивирусы.", fillInBlankExclusions = listOf(109907L, 109909L, 109911L, 109912L, 109915L)),

        WordEntity(id = 109917, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_defense_arch", transliteration = "misgeret avtaha",
            original = "מִסְגֶּרֶת אַבְטָחָה", translation = "фреймворк безопасности (security framework)",
            definition = "אֹסֶף סְטַנְדַּרְטִים וּפְרַקְטִיקוֹת מְקוּבָּלוֹת שֶׁעַל פִּיהֶם נִבְנֵית הַגָּנָה אַחֲדוּתִית בָּאִרְגוּן.",
            definitionNative = "Набор стандартов и правил, на котором строится единая защита всей информационной системы предприятия.",
            example = "הַחֶבְרָה אִימְּצָה מִסְגֶּרֶת אַבְטָחָה לְפִי תֵּקֶן NIST.",
            exampleNative = "Компания приняла מִסְגֶּרֶת אַבְטָחָה по стандарту NIST для аудита процессов.", fillInBlankExclusions = listOf(109901L, 109906L, 109923L, 109924L)),

        WordEntity(id = 109918, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_resilience", transliteration = "sayber-bitachon",
            original = "סַיְיבֶּר-בִּטָּחוֹן", translation = "кибербезопасность",
            definition = "תְּחוּם הָעוֹסֵק בְּהַגָּנַת מַחְשְׁבִים, רְשָׁתוֹת וּמֵידָע מִפְּנֵי חֲדִירוֹת וּתְקִיפוֹת זְדוֹנִיּוֹת.",
            definitionNative = "Область, которая занимается защитой компьютеров, сетей и данных от вредоносного вторжения.",
            example = "סַיְיבֶּר-בִּטָּחוֹן הָפַךְ לְמִקְצוֹעַ מְבוּקָּשׁ בְּחֶבְרוֹת טֵכְנוֹלוֹגִיָּה.",
            exampleNative = "סַיְיבֶּר-בִּטָּחוֹן стал одной из самых востребованных профессий в технологических компаниях.", fillInBlankExclusions = listOf(109904L, 109908L, 109914L, 109925L)),

        WordEntity(id = 109919, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_threat_concepts", transliteration = "tkifa mhuunet",
            original = "תְּקִיפָה מְכֻוֶּנֶת", translation = "целенаправленная атака",
            definition = "חֲדִירָה מְמֻשֶּׁכֶת וְשֶׁקֶטָה לְאִרְגוּן אֶחָד שֶׁנִּבְחַר מֵרֹאשׁ, לְשֵׁם רִגּוּל אוֹ גְּנִיבָה.",
            definitionNative = "Длительное и тихое вторжение в одну заранее выбранную организацию ради конкретных секретных сведений.",
            example = "תְּקִיפָה מְכֻוֶּנֶת עַל הַצָּבָא נִמְשְׁכָה חֳדָשִׁים לִפְנֵי שֶׁהִתְגַּלְּתָה.",
            exampleNative = "תְּקִיפָה מְכֻוֶּנֶת на армию длилась несколько месяцев до момента обнаружения.", fillInBlankExclusions = listOf(109905L, 109913L, 109921L, 109922L)),

        WordEntity(id = 109920, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_identity_pki", transliteration = "nihul zhuiot",
            original = "נִיהוּל זְהוּיוֹת", translation = "управление идентификацией (IAM)",
            definition = "קְבִיעָה מְרֻכֶּזֶת שֶׁל מִי מוּרְשֶׁה לְהִתְחַבֵּר וּלְאֵיזֶה מַשְׁאָב בָּאִרְגוּן.",
            definitionNative = "Централизованное определение того, какому сотруднику разрешён вход и к каким ресурсам системы.",
            example = "נִיהוּל זְהוּיוֹת תְּקִין מוֹנַעַ הַרְשָׁאוֹת מְיוּתָּרוֹת לְעוֹבְדִים יוֹצְאִים.",
            exampleNative = "Грамотное נִיהוּל זְהוּיוֹת блокирует лишние права у уволенных сотрудников.", fillInBlankExclusions = listOf(109902L, 109903L, 109910L)),

        WordEntity(id = 109921, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_threat_concepts", transliteration = "pgiut",
            original = "פְּגִיעוּת", translation = "уязвимость (в системе безопасности)",
            definition = "חֻלְשָׁה בְּתוֹכְנָה אוֹ בְּרֶשֶׁת, שֶׁדַּרְכָּהּ תּוֹקֵף יָכוֹל לַחֲדֹר פְּנִימָה.",
            definitionNative = "Слабое место в программе или сети, через которое возможно проникновение злоумышленника внутрь.",
            example = "פְּגִיעוּת קְרִיטִית בַּשְּׁרָת תּוּקְּנָה תּוֹךְ שָׁעוֹת מִגִּילּוּיָהּ.",
            exampleNative = "Критическая פְּגִיעוּת в сервере была закрыта в течение нескольких часов после обнаружения.", fillInBlankExclusions = listOf(109905L, 109913L, 109919L, 109922L)),

        WordEntity(id = 109922, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_threat_concepts", transliteration = "nitsul yom-efes",
            original = "נִיצּוּל יוֹם-אֶפֶס", translation = "эксплойт нулевого дня (zero-day)",
            definition = "תְּקִיפָה הַמְּשַׁתֶּמֶת בְּפִרְצָה שֶׁעֲדַיִן לֹא יְדוּעָה לְיַצְרָן הַתּוֹכְנָה וְאֵין לָהּ טְלַאי.",
            definitionNative = "Использование дыры, о которой производитель программы ещё не знает и потому не выпустил исправление.",
            example = "נִיצּוּל יוֹם-אֶפֶס בְּדַפְדְּפָן יָקָר עָלָה מִילְיוֹנֵי דּוֹלָר בַּשּׁוּק הַשָּׁחֹר.",
            exampleNative = "נִיצּוּל יוֹם-אֶפֶס для популярного браузера стоит миллионы долларов на чёрном рынке.", fillInBlankExclusions = listOf(109905L, 109913L, 109919L, 109921L)),

        WordEntity(id = 109923, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_defense_arch", transliteration = "hagana bishhavot",
            original = "הַגְנָה בִּשְׂכָבוֹת", translation = "эшелонированная защита (defense in depth)",
            definition = "אִרְגוּן כַּמָּה מַחֲסוֹמֵי אַבְטָחָה זֶה אַחַר זֶה, כָּךְ שֶׁכִּשְׁלוֹן אֶחָד אֵינוֹ פּוֹתֵחַ הַכֹּל.",
            definitionNative = "Несколько последовательных рубежей защиты, при которых пробой одного слоя ещё не означает доступ ко всему.",
            example = "הַגְנָה בִּשְׂכָבוֹת הִצִּילָה אֶת הַמַּעֲרֶכֶת לְמָרוֹת פְּרִיצַת חוֹמַת אֵשׁ.",
            exampleNative = "הַגְנָה בִּשְׂכָבוֹת спасла систему даже после того, как был пробит внешний межсетевой экран.", fillInBlankExclusions = listOf(109901L, 109906L, 109917L, 109924L)),

        WordEntity(id = 109924, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_defense_arch", transliteration = "model efes-emun",
            original = "מוֹדֶל אֶפֶס-אֱמוּן", translation = "модель нулевого доверия (zero trust)",
            definition = "גִּישָׁה הַמַּנִּיחָה שֶׁכָּל בַּקָּשָׁה חֲשׁוּדָה, גַּם כְּשֶׁהִיא מַגִּיעָה מִתּוֹךְ הָאִרְגוּן עַצְמוֹ.",
            definitionNative = "Подход, при котором ни один запрос не считается надёжным заранее, даже от внутренних сотрудников.",
            example = "מוֹדֶל אֶפֶס-אֱמוּן מְחַיֵּב אִימּוּת חוֹזֵר בְּכָל גִּישָׁה לְמַשְׁאַב.",
            exampleNative = "מוֹדֶל אֶפֶס-אֱמוּן требует повторной проверки личности при каждом обращении к ресурсу.", fillInBlankExclusions = listOf(109901L, 109906L, 109917L, 109923L)),

        WordEntity(id = 109925, setId = 1099, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_resilience", transliteration = "analiza forensit",
            original = "אָנָלִיזָה פּוֹרֶנְזִית", translation = "цифровая форензика",
            definition = "חֲקִירָה שֶׁל עִקְבוֹת דִּיגִיטַלִיִּים אַחֲרֵי תְּקִיפָה, כְּדֵי לְהָבִין כֵּיצַד וּמִי חָדַר.",
            definitionNative = "Расследование цифровых следов после инцидента, чтобы понять, как, кто и через что проник в систему.",
            example = "אָנָלִיזָה פּוֹרֶנְזִית חָשְׂפָה אֶת מָקוֹר הַחֲדִירָה תּוֹךְ יוֹמַיִם.",
            exampleNative = "אָנָלִיזָה פּוֹרֶנְזִית обнаружила источник проникновения за двое суток после инцидента.", fillInBlankExclusions = listOf(109904L, 109908L, 109914L, 109918L)),
    )
}
