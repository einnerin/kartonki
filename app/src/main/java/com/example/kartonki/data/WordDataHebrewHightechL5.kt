package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Хайтек", уровень L5 (носитель языка).
 *
 * Set 1749: «Хайтек» — носитель языка (EPIC+LEGENDARY):
 *           управление и стратегия. Лидерство C-level, инвестиционные раунды,
 *           exit (IPO/M&A), стратегия (technical debt, moat, PMF, pivot)
 *           и культура (attrition, retention, ownership, accountability, employer brand).
 *
 * Аудитория — русскоязычные сеньоры/руководители в израильском хайтеке.
 * Лексика реальная, как говорят в Tel Aviv'ском tech-секторе: смесь иврита
 * с английскими заимствованиями (CTO, VP אַר-אֶנְד-דִּי, רַאוּנְד גִּיּוּס,
 * דְּיוּ-דִּילִיגֶ'נְס, IPO, אֶקְזִיט, אַטְרִישֶׁן, פִיבּוֹט).
 *
 * Распределение редкостей: 13 EPIC + 12 LEGENDARY.
 *
 * SemanticGroups (5 × 5):
 *   hightech_leadership — лидерство: CTO, VP R&D, CPO, скейлинг команды, оргструктура
 *   hightech_funding    — инвестиции: раунд, due diligence, term sheet, оценка, разводнение
 *   hightech_exit       — exit: IPO, M&A, acqui-hire, exit-стратегия, captable
 *   hightech_strategy   — стратегия: technical debt, moat, конкур. преимущество, PMF, pivot
 *   hightech_culture    — культура: attrition, retention, ownership, accountability, employer brand
 *
 * Word IDs: setId × 100 + position (174901..174925).
 *
 * Пересечения с другими наборами Хайтек:
 *   - L4 (1748) содержит retention продукта, KPI, roadmap. Здесь retention сотрудников
 *     обозначен иной фразой: שִׁמּוּר עוֹבְדִים — иной original + другой русский перевод.
 *   - Interview L4 (1751) содержит equity/RSU/options/signing bonus/vesting/оффер/переговоры.
 *     В этом наборе они не повторяются — речь про инвестиционные и стратегические термины.
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewHightechL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1749, languagePair = "he-ru", orderIndex = 1749,
            name = "Хайтек",
            description = "Управление и стратегия: лидерство, инвестиции, IPO, exit",
            topic = "Хайтек", level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1749 — Хайтек: носитель языка (L5, EPIC+LEGENDARY)
        // 5 групп × 5 слов: leadership, funding, exit, strategy, culture
        // ══════════════════════════════════════════════════════════════════════

        // ── hightech_leadership (5) — C-level и структура команды ──
        WordEntity(
            id = 174901, setId = 1749, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_leadership", transliteration = "si-ti-o",
            original = "סִי-טִי-אוֹ", translation = "CTO (технический директор)",
            definition = "הָאָדָם הַבָּכִיר שֶׁאַחְרָאִי עַל כָּל הַחֲלָטוֹת הָאַרְכִיטֶקְטוּרָה וְהַטֶּכְנוֹלוֹגְיָה.",
            definitionNative = "Самый старший человек, отвечающий за все архитектурные и технологические решения.",
            example = "הַסִּי-טִי-אוֹ אִישֵּׁר אֶת הַמַּעֲבָר לְעַנְנֵי גוּגַל בִּישִׁיבָה הַשָּׁבוּעִית.",
            exampleNative = "סִי-טִי-אוֹ утвердил переход на Google Cloud на еженедельной встрече.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174902, setId = 1749, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "hightech_leadership", transliteration = "vi-pi ar-en-di",
            original = "וִי-פִּי אַר-אֶנְד-דִּי", translation = "VP R&D (вице-президент по разработке)",
            definition = "סְגַן נָשִׂיא שֶׁמְּנַהֵל מַחְלֶקֶת מֶחְקָר וּפִתּוּחַ עִם עַשְׂרוֹת אוֹ מֵאוֹת מְהַנְדְּסִים.",
            definitionNative = "Замглавы, который ведёт отдел исследований и разработки — десятки или сотни инженеров.",
            example = "וִי-פִּי אַר-אֶנְד-דִּי קָבַע יַעַד שֶׁל שְׁתֵּי מַהְדּוּרוֹת מֵייגָ'וֹר בַּשָּׁנָה.",
            exampleNative = "וִי-פִּי אַר-אֶנְד-דִּי поставил цель — два мажорных релиза в год.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174903, setId = 1749, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "hightech_leadership", transliteration = "si-pi-o",
            original = "סִי-פִּי-אוֹ", translation = "CPO (директор по продукту)",
            definition = "מְנַהֵל בָּכִיר שֶׁאַחְרָאִי עַל הַחֲזוֹן וְעַל הַמַּפָּה הָאֲרֻכָּה שֶׁל כָּל קַוֵּי הַמּוּצָר.",
            definitionNative = "Старший управленец, отвечающий за видение и долгий план всех продуктовых линий.",
            example = "הַסִּי-פִּי-אוֹ הֶחֱלִיט לְבַטֵּל קַו מוּצָר חֲלָשׁ וּלְהַפְנוֹת אֶת הַמַּשְׁאַבִּים.",
            exampleNative = "סִי-פִּי-אוֹ решил закрыть слабую продуктовую линию и перенаправить ресурсы.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174904, setId = 1749, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_leadership", transliteration = "skeyling tsevet",
            original = "סְקֵיילִינְג צֶוֶות", translation = "масштабирование команды",
            definition = "תַּהֲלִיךְ שֶׁל גִּדּוּל מָהִיר בְּמִסְפַּר הָעוֹבְדִים בְּלִי לְאַבֵּד אֵיכוּת אוֹ תַּרְבּוּת.",
            definitionNative = "Быстрый рост числа сотрудников без потери качества или культуры.",
            example = "סְקֵיילִינְג צֶוֶות מֵעֶשְׂרִים לְמֵאָה אִישׁ שָׁבַר לָנוּ אֶת הַתִּקְשׁוֹרֶת הַפְּנִימִית.",
            exampleNative = "סְקֵיילִינְג צֶוֶות с двадцати до ста человек сломал нашу внутреннюю коммуникацию.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174905, setId = 1749, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_leadership", transliteration = "mivne irguni",
            original = "מִבְנֶה אִרְגּוּנִי", translation = "организационная структура",
            definition = "צוּרָה שֶׁבָּהּ מְסֻדָּרוֹת הַמַּחְלָקוֹת וְכַפִיפוּיוֹת בֵּין הָאַנָשִׁים בַּחֶבְרָה.",
            definitionNative = "То, как устроены отделы и кому кто подчиняется внутри фирмы.",
            example = "מִבְנֶה אִרְגּוּנִי שָׁטוּחַ הִתְאִים לִשְׁלֹשִׁים אִישׁ אֲבָל לֹא לְמֵאתַיִם.",
            exampleNative = "Плоский מִבְנֶה אִרְגּוּנִי годился для тридцати человек, но не для двухсот.",
            isFillInBlankSafe = false,
        ),

        // ── hightech_funding (5) — раунды и инвестиции ──
        WordEntity(
            id = 174906, setId = 1749, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_funding", transliteration = "raund giyus",
            original = "רַאוּנְד גִּיּוּס", translation = "инвестиционный раунд",
            definition = "סִבּוּב שֶׁל הַשְׁקָעָה שֶׁבּוֹ סְטַרְטְאַפּ מְקַבֵּל כֶּסֶף מִקְבוּצָה שֶׁל מַשְׁקִיעִים.",
            definitionNative = "Цикл инвестирования, в котором стартап получает деньги от группы инвесторов.",
            example = "סָגַרְנוּ רַאוּנְד גִּיּוּס שֶׁל שְׁלֹשִׁים מִילְיוֹן דּוֹלָר בְּסוֹף הַשָּׁנָה.",
            exampleNative = "Мы закрыли רַאוּנְד גִּיּוּס на тридцать миллионов долларов в конце года.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174907, setId = 1749, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "hightech_funding", transliteration = "dyu-dilijens",
            original = "דְּיוּ-דִּילִיגֶ'נְס", translation = "due diligence (проверка перед сделкой)",
            definition = "בְּדִיקָה מַעֲמִיקָה שֶׁל מַשְׁקִיעַ לִפְנֵי שֶׁהוּא מַחְלִיט לְהַעֲבִיר אֶת הַכֶּסֶף.",
            definitionNative = "Глубокая проверка инвестором — перед тем как решить переводить деньги.",
            example = "דְּיוּ-דִּילִיגֶ'נְס לָקַח חֳדָשַׁיִם וְעִכֵּב לָנוּ אֶת הַחֲתִימָה.",
            exampleNative = "דְּיוּ-דִּילִיגֶ'נְס занял два месяца и задержал нам подписание.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174908, setId = 1749, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "hightech_funding", transliteration = "term shit",
            original = "טֶרְם שִׁיט", translation = "term sheet (предварительные условия)",
            definition = "מִסְמָךְ קָצָר וְלֹא מְחַיֵּב שֶׁמְסַכֵּם אֶת הַתְּנָאִים הַעִקָּרִיִּים שֶׁל הָעִסְקָה.",
            definitionNative = "Короткая необязывающая бумага — резюмирует ключевые условия будущей сделки.",
            example = "הַמַּשְׁקִיעַ הָרָאשִׁי שָׁלַח טֶרְם שִׁיט עִם הַעֲרָכָה גְּבוֹהָה מֵהַצָּפוּי.",
            exampleNative = "Главный инвестор прислал טֶרְם שִׁיט с оценкой выше ожидаемой.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174909, setId = 1749, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_funding", transliteration = "sho'i hevra",
            original = "שׁוֹוִי חֶבְרָה", translation = "оценка компании (valuation)",
            definition = "הַסְּכוּם הַכּוֹלֵל שֶׁבּוֹ מַעֲרִיכִים אֶת הַסְּטַרְטְאַפּ עַל בָּסִיס שֶׁל הַחֻלָּקָה הָעַכְשָׁוִית.",
            definitionNative = "Полная сумма, в которую оценивают стартап на основе текущего распределения долей.",
            example = "שׁוֹוִי חֶבְרָה אַחֲרֵי הַרַּאוּנְד הִגִּיעַ לְמִילְיַארְד דּוֹלָר.",
            exampleNative = "שׁוֹוִי חֶבְרָה после раунда дошла до миллиарда долларов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174910, setId = 1749, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "hightech_funding", transliteration = "dilul",
            original = "דִּילּוּל", translation = "разводнение долей (dilution)",
            definition = "יְרִידָה בָּאָחוּז שֶׁל הַבְּעָלִים הַוָּתִיקִים כְּשֶׁחֶבְרָה מַנְפִּיקָה מְנָיוֹת חֲדָשׁוֹת.",
            definitionNative = "Падение доли старых владельцев, когда фирма выпускает новые акции.",
            example = "הַמַּיְיסְדִים סָבְלוּ מִדִּילּוּל שֶׁל עֶשְׂרִים אָחוּז בָּרַאוּנְד הָאַחֲרוֹן.",
            exampleNative = "Основатели пострадали от דִּילּוּל в двадцать процентов в последнем раунде.",
            isFillInBlankSafe = false,
        ),

        // ── hightech_exit (5) — IPO, M&A, выход ──
        WordEntity(
            id = 174911, setId = 1749, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_exit", transliteration = "hanpaka",
            original = "הַנְפָּקָה", translation = "IPO (выход на биржу)",
            definition = "תַּהֲלִיךְ שֶׁבּוֹ סְטַרְטְאַפּ פְּרָטִי הוֹפֵךְ לְצִבּוּרִי וּמְנָיוֹתָיו נִסְחָרוֹת בַּבּוּרְסָה.",
            definitionNative = "Когда частный стартап становится публичным, и его акции торгуются на бирже.",
            example = "הַחֶבְרָה הִתְכּוֹנְנָה לְהַנְפָּקָה בְּנָאסְדָאק אַחֲרֵי שֶׁבַע שְׁנוֹת צְמִיחָה.",
            exampleNative = "Фирма готовилась к הַנְפָּקָה на NASDAQ после семи лет роста.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174912, setId = 1749, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_exit", transliteration = "mizug ve-rekhisha",
            original = "מִיזּוּג וּרְכִישָׁה", translation = "M&A (слияния и поглощения)",
            definition = "עִסְקָה שֶׁבָּהּ חֶבְרָה אַחַת קוֹנָה אַחֶרֶת אוֹ שְׁתֵּיהֶן מִתְאַחֲדוֹת לִישׁוּת אַחַת.",
            definitionNative = "Сделка, в которой одна фирма покупает другую — или обе сливаются в одно лицо.",
            example = "מִיזּוּג וּרְכִישָׁה עִם תַּאֲגִיד אָמֵרִיקָאִי הִכְפִּיל אֶת מִסְפַּר הָעוֹבְדִים שֶׁלָּנוּ.",
            exampleNative = "מִיזּוּג וּרְכִישָׁה с американской корпорацией удвоил наше число сотрудников.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174913, setId = 1749, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "hightech_exit", transliteration = "akvi-hayer",
            original = "אַקְוִוי-הַיְיר", translation = "acqui-hire (покупка ради команды)",
            definition = "סוּג שֶׁל קְנִיָּה שֶׁבּוֹ הַמַּטָּרָה הָעִיקָּרִית הִיא הָעוֹבְדִים, לֹא הַמּוּצָר אוֹ הַטֶּכְנוֹלוֹגְיָה.",
            definitionNative = "Тип сделки, где главная цель — сами сотрудники, а не продукт или технология.",
            example = "גוּגַל בִּצְּעָה אַקְוִוי-הַיְיר וּקָלְטָה רַק שִׁישָּׁה מְהַנְדְּסִים מֵהַסְּטַרְטְאַפּ.",
            exampleNative = "Google провёл אַקְוִוי-הַיְיר и забрал лишь шесть инженеров со стартапа.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174914, setId = 1749, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_exit", transliteration = "ekzit",
            original = "אֶקְזִיט", translation = "exit (выход основателей)",
            definition = "אֵרוּעַ שֶׁבּוֹ מַיְיסְדִים וּמַשְׁקִיעִים מַמִּירִים אֶת הַחֵלֶק שֶׁלָּהֶם לְכֶסֶף נָזִיל.",
            definitionNative = "Событие, когда основатели и инвесторы превращают свою долю в живые деньги.",
            example = "אֶקְזִיט שֶׁל מֵאָה וַחֲמִישִּׁים מִילְיוֹן דּוֹלָר שִׁנָּה לְכֻלָּם אֶת הַחַיִּים.",
            exampleNative = "אֶקְזִיט в сто пятьдесят миллионов долларов изменил всем жизнь.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174915, setId = 1749, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "hightech_exit", transliteration = "kep teibel",
            original = "קֶפ טֵייבֶּל", translation = "captable (таблица долей)",
            definition = "טַבְלָה מְפֹרֶטֶת שֶׁמַּרְאָה מִי מַחֲזִיק כָּל אָחוּז וְכָל סוּג שֶׁל נְיָר עֶרֶךְ בַּחֶבְרָה.",
            definitionNative = "Подробная таблица — кто владеет каким процентом и каждым типом ценной бумаги.",
            example = "קֶפ טֵייבֶּל מְבֻלְבָּל הִבְהִיל אֶת הַמַּשְׁקִיעַ הַחָדָשׁ בַּדִּילִיגֶ'נְס.",
            exampleNative = "Запутанный קֶפ טֵייבֶּל напугал нового инвестора при проверке.",
            isFillInBlankSafe = false,
        ),

        // ── hightech_strategy (5) — стратегические термины ──
        WordEntity(
            id = 174916, setId = 1749, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_strategy", transliteration = "pozitsyoning",
            original = "פּוֹזִיצְיוֹנִינְג", translation = "позиционирование (на рынке)",
            definition = "הַחְלָטָה אֵיךְ הַמּוּצָר נִתְפָּס בַּשּׁוּק וּמוּל מִי הוּא מַתְמוֹדֵד.",
            definitionNative = "Решение, как продукт воспринимается на рынке и с кем именно он соперничает.",
            example = "שִׁנִּינוּ אֶת הַפּוֹזִיצְיוֹנִינְג אַחֲרֵי שֶׁשְּׁתֵּי חֲבָרוֹת חֲדָשׁוֹת נִכְנְסוּ לַשּׁוּק.",
            exampleNative = "Мы переделали פּוֹזִיצְיוֹנִינְג после того как на рынок вышли две новые компании.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174917, setId = 1749, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "hightech_strategy", transliteration = "moat",
            original = "מוֹאָט", translation = "moat (защитный ров вокруг бизнеса)",
            definition = "יִתְרוֹן עָמֹק שֶׁמַּקְשֶׁה עַל מִתְחָרִים לִגְנוֹב אֶת הַלָּקוֹחוֹת שֶׁל הַחֶבְרָה.",
            definitionNative = "Глубокое преимущество, которое мешает соперникам уводить клиентов фирмы.",
            example = "אֶפֶקְט הָרֶשֶׁת יָצַר לְוָוטְסְאַפּ מוֹאָט שֶׁאַף אֶחָד לֹא הִצְלִיחַ לִשְׁבֹּר.",
            exampleNative = "Сетевой эффект создал WhatsApp такой מוֹאָט, что никто не сумел пробить.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174918, setId = 1749, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_strategy", transliteration = "yitaron takharuti",
            original = "יִתְרוֹן תַּחֲרוּתִי", translation = "конкурентное преимущество",
            definition = "מַשֶּׁהוּ שֶׁחֶבְרָה עוֹשָׂה טוֹב יוֹתֵר מֵאַחֵרִים וְקָשֶׁה לָהֶם לְהָדְבִּיק אוֹתָהּ.",
            definitionNative = "То, что фирма делает лучше прочих, — и им сложно её догнать.",
            example = "הַיִּתְרוֹן הַתַּחֲרוּתִי שֶׁלָּנוּ הוּא מַאֲגַר נְתוּנִים שֶׁאַסַּפְנוּ עֶשֶׂר שָׁנִים.",
            exampleNative = "Наше יִתְרוֹן תַּחֲרוּתִי — это база данных, что мы собирали десять лет.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174919, setId = 1749, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "hightech_strategy", transliteration = "pi-em-ef",
            original = "פִּי-אֶם-אֶף", translation = "product-market fit (PMF)",
            definition = "הַשָּׁלָב שֶׁבּוֹ הַשּׁוּק קוֹנֶה בְּתֵיאָבוֹן אֶת מַה שֶּׁהַסְּטַרְטְאַפּ מַצִּיעַ.",
            definitionNative = "Стадия, когда рынок жадно покупает то, что предлагает стартап.",
            example = "בְּלִי פִּי-אֶם-אֶף אַף מַשְׁקִיעַ לֹא יִכָּנֵס לַסִּיבּוּב הַבָּא.",
            exampleNative = "Без פִּי-אֶם-אֶף ни один инвестор не зайдёт в следующий цикл.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174920, setId = 1749, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_strategy", transliteration = "pivot",
            original = "פִיבּוֹט", translation = "pivot (резкая смена курса)",
            definition = "שִׁינּוּי חַד בַּכִּוּוּן הָעִסְקִי כְּשֶׁמּוּצָר אוֹ שׁוּק לֹא עוֹבְדִים כְּמוֹ שֶׁתִּכְנְנוּ.",
            definitionNative = "Резкий поворот в бизнес-направлении, когда продукт или рынок не идут как задумано.",
            example = "אַחֲרֵי שָׁנָה בְּלִי לְקוֹחוֹת בִּצַּעְנוּ פִיבּוֹט מִ-בִּי-טוּ-סִי לְ-בִּי-טוּ-בִּי.",
            exampleNative = "После года без клиентов мы сделали פִיבּוֹט с B2C на B2B.",
            isFillInBlankSafe = false,
        ),

        // ── hightech_culture (5) — корпоративная культура и удержание ──
        WordEntity(
            id = 174921, setId = 1749, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_culture", transliteration = "atrishen",
            original = "אַטְרִישֶׁן", translation = "attrition (текучка кадров)",
            definition = "אָחוּז הָעוֹבְדִים שֶׁעוֹזְבִים אֶת הַחֶבְרָה בְּמֶשֶׁךְ שָׁנָה אַחַת לִכְלָל הַסֶּגֶל.",
            definitionNative = "Процент уходящих сотрудников за год от всего персонала.",
            example = "אַטְרִישֶׁן שֶׁל עֶשְׂרִים וַחֲמִישָּׁה אָחוּז הִדְלִיק נוּרָה אֲדֻמָּה לַהַנְהָלָה.",
            exampleNative = "אַטְרִישֶׁן в двадцать пять процентов зажёг красную лампу руководству.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174922, setId = 1749, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "hightech_culture", transliteration = "shimur ovdim",
            original = "שִׁמּוּר עוֹבְדִים", translation = "удержание сотрудников",
            definition = "מַעֲרֶכֶת אֶמְצָעִים שֶׁל הַחֶבְרָה כְּדֵי שֶׁאַנָשִׁים טוֹבִים יִשָּׁאֲרוּ זְמַן רַב.",
            definitionNative = "Совокупность мер компании, чтобы хорошие люди оставались надолго.",
            example = "שִׁמּוּר עוֹבְדִים אֵצֶל אִינְטֵל מִתְבַּסֵּס עַל בּוֹנוּסִים שְׁנָתִיִּים גְּדוֹלִים.",
            exampleNative = "שִׁמּוּר עוֹבְדִים в Intel держится на крупных годовых бонусах.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174923, setId = 1749, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_culture", transliteration = "ona'ut",
            original = "אוֹנָאוּת", translation = "ownership (чувство хозяина)",
            definition = "תְּחוּשָׁה שֶׁל עוֹבֵד שֶׁהַתּוֹצָאוֹת הֵן אִישִׁיּוֹת שֶׁלּוֹ, לֹא רַק שֶׁל הַמְּנַהֵל.",
            definitionNative = "Чувство сотрудника, что результаты — лично его, а не одного начальника.",
            example = "אוֹנָאוּת חֲזָקָה אֵצֶל מְהַנְדְּסִים גּוֹרֶמֶת לָהֶם לִפְתֹּחַ בָּגִים בְּלִי בַּקָּשָׁה.",
            exampleNative = "Сильное אוֹנָאוּת у инженеров приводит к тому, что они чинят баги без просьбы.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174924, setId = 1749, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "hightech_culture", transliteration = "akhrayutiyut",
            original = "אַחְרָיוּתִיּוּת", translation = "accountability (готовность отвечать за результат)",
            definition = "נְכוֹנוּת לָתֵת דִּין וְחֶשְׁבּוֹן עַל מַעֲשִׂים וּתְוֹצָאוֹת בְּלִי לְהַאֲשִׁים אֶת הַסְּבִיבָה.",
            definitionNative = "Готовность отчитываться за поступки и итоги, не сваливая на окружение.",
            example = "אַחְרָיוּתִיּוּת אִישִׁית עָשְׂתָה אֶת הַהֶבְדֵּל בֵּין צֶוֶות חָזָק לְבֵינוֹנִי.",
            exampleNative = "Личная אַחְרָיוּתִיּוּת сделала разницу между сильной и средней командой.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 174925, setId = 1749, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "hightech_culture", transliteration = "mo'tag ma'asik",
            original = "מוֹתַג מַעֲסִיק", translation = "employer brand (бренд работодателя)",
            definition = "הַתַּדְמִית שֶׁל הַחֶבְרָה בְּעֵינֵי הַמֻּעֳמָדִים שֶׁעוֹד לֹא הִגִּיעוּ אֵלֶיהָ.",
            definitionNative = "Образ фирмы в глазах кандидатов, которые ещё в неё не пришли.",
            example = "מוֹתַג מַעֲסִיק חָזָק חוֹסֵךְ מְלֵא כֶּסֶף עַל מוֹדַעוֹת דְּרוּשִׁים.",
            exampleNative = "Сильный מוֹתַג מַעֲסִיק экономит много денег на объявлениях о вакансиях.",
            isFillInBlankSafe = false,
        ),
    )
}
