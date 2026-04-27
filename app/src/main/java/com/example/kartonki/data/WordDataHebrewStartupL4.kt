package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Стартап", уровень 4 (профессиональный).
 *
 * Set 1759: «Стартап» — профессиональный L4 (EPIC + LEGENDARY).
 * Узкоспециальная лексика финансирования стартапов: раунды инвестиций,
 * типы инвесторов, акселерационные программы, юр. структура сделки и
 * инвест-питч.
 *
 * Целевая аудитория — русскоязычные основатели/CFO/инвест-аналитики в
 * израильском VC-секторе. Лексика двуязычная: иврит + английские
 * заимствования (סִיד, סֵירִיס אֵיי, אֶנְגֵ'ל, קֶרֶן הוֹן סִיכּוּן,
 * אַקְסֶלֵרָטוֹר, דֵּמוֹ דֵּיי, סֵיף, פִּיטְץ' דֶּק) — так реально
 * говорят в офисах TLV-VC и на питч-дне Y Combinator-style программ.
 *
 * Распределение редкостей:
 *   13 EPIC + 12 LEGENDARY (без выхода за 2 смежных уровня).
 *
 * SemanticGroups (5 × 5):
 *   startup_rounds     — этапы привлечения денег: seed, series A, бридж, growth, mezzanine
 *   startup_investors  — типы инвесторов: ангел, VC-фонд, corp VC, family office, LP
 *   startup_programs   — программы поддержки: акселератор, инкубатор, demo day, конкурс, грант
 *   startup_deal       — юр.термины сделки: term sheet, SAFE, convertible note, valuation cap, dilution
 *   startup_pitch      — питч и DD: pitch deck, презентация, elevator pitch, DD-вопросы, traction slide
 *
 * Word IDs: setId × 100 + position (175901..175925).
 *
 * Пересечения с другими наборами:
 *   - HightechL5 (1749) содержит רַאוּנְד גִּיּוּס (общий «инвест-раунд»),
 *     דְּיוּ-דִּילִיגֶ'נְס, טֶרְם שִׁיט, שׁוֹוִי חֶבְרָה (valuation), דִּילּוּל
 *     (dilution). В этом наборе использованы ВАРИАЦИИ:
 *       term sheet → דַּף תְּנָאִים (буквальный ивритский термин)
 *       dilution   → הִדּוּלְדּוּל מְנָיוֹת (специально про размытие акций)
 *       valuation  → תִּקְרַת שׁוֹוִי (специфический valuation cap, не общая оценка)
 *       DD         → שְׁאֵלוֹת בְּדִיקַת נֶאוֹת (вопросы DD как процесс пре-сделки)
 *     Темы разные (Стартап vs Хайтек) — дубли по `original` между темами разрешены,
 *     но политика «не повторять» соблюдена для чистоты выдачи.
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewStartupL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1759, languagePair = "he-ru", orderIndex = 1759,
            name = "Стартап",
            description = "Финансирование: pre-seed, seed, series A, акселераторы, ангелы, term sheet",
            topic = "Стартап", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1759 — Стартап: профессиональный (L4, EPIC + LEGENDARY)
        // 5 групп × 5 слов: rounds, investors, programs, deal, pitch
        // ══════════════════════════════════════════════════════════════════════

        // ── startup_rounds (5) — этапы привлечения денег ──
        WordEntity(
            id = 175901, setId = 1759, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_rounds", transliteration = "sid",
            original = "סִיד", translation = "seed-раунд",
            definition = "הַשְׁקָעָה רִאשׁוֹנָה בִּסְכוּם קָטָן שֶׁמְּאַפְשֶׁרֶת לְהוֹכִיחַ אֶת הָרַעְיוֹן וְלִבְנוֹת אֲבָטִיפּוּס.",
            definitionNative = "Самая первая инвестиция небольшой суммы — на доказательство идеи и прототип.",
            example = "סָגַרְנוּ סִיד שֶׁל מִילְיוֹן וָחֵצִי דּוֹלָר מֵאַרְבָּעָה אֶנְגֵ'לִים.",
            exampleNative = "Мы закрыли סִיד на полтора миллиона долларов от четырёх ангелов.",
         fillInBlankExclusions = listOf(175902L, 175903L, 175904L, 175905L)),
        WordEntity(
            id = 175902, setId = 1759, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_rounds", transliteration = "seyris ey",
            original = "סֵירִיס אֵיי", translation = "series A",
            definition = "גִּיּוּס מַשְׁמָעוּתִי שֶׁבָּא כְּשֶׁכְּבָר יֵשׁ מוּצָר עוֹבֵד וְלָקוֹחוֹת רִאשׁוֹנִים מְשַׁלְּמִים.",
            definitionNative = "Серьёзный сбор — когда уже есть рабочий продукт и первые платящие клиенты.",
            example = "סֵירִיס אֵיי הָיָה עֲשָׂרָה מִילְיוֹן דּוֹלָר בְּהוֹבָלַת קֶרֶן אָמֵרִיקָאִית.",
            exampleNative = "סֵירִיס אֵיי был на десять миллионов долларов под лидом американского фонда.",
         fillInBlankExclusions = listOf(175901L, 175903L, 175904L, 175905L)),
        WordEntity(
            id = 175903, setId = 1759, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_rounds", transliteration = "mimun gesher",
            original = "מִימּוּן גֶּשֶׁר", translation = "бридж-финансирование",
            definition = "הַזְרָמַת כֶּסֶף קְצָרָה בֵּין שְׁנֵי שְׁלָבִים גְּדוֹלִים כְּדֵי לְהַחְזִיק אֶת הַחֶבְרָה בַּחַיִּים.",
            definitionNative = "Короткое вливание денег между двумя крупными этапами — чтобы фирма дотянула.",
            example = "לָקַחְנוּ מִימּוּן גֶּשֶׁר שֶׁל שְׁלוֹשָׁה חֳדָשִׁים לִפְנֵי הַסְּגִירָה הַסּוֹפִית.",
            exampleNative = "Мы взяли מִימּוּן גֶּשֶׁר на три месяца до окончательного закрытия раунда.",
         fillInBlankExclusions = listOf(175901L, 175902L, 175904L, 175905L)),
        WordEntity(
            id = 175904, setId = 1759, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_rounds", transliteration = "shlav tsmikha",
            original = "שְׁלַב צְמִיחָה", translation = "growth-стадия",
            definition = "תְּקוּפָה שֶׁל הַרְחָבָה מְהִירָה לְשׁוּקִים חֲדָשִׁים אַחֲרֵי שֶׁהַמּוּצָר כְּבָר מָצָא קְהִלָּה.",
            definitionNative = "Период быстрой экспансии в новые рынки — после того как продукт нашёл свою аудиторию.",
            example = "בִּשְׁלַב צְמִיחָה שָׂכַרְנוּ אַרְבָּעִים אַנְשֵׁי מְכִירוֹת בְּחֵצִי שָׁנָה.",
            exampleNative = "В שְׁלַב צְמִיחָה мы наняли сорок продажников за полгода.",
         fillInBlankExclusions = listOf(175901L, 175902L, 175903L, 175905L)),
        WordEntity(
            id = 175905, setId = 1759, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_rounds", transliteration = "mezanin",
            original = "מֵזָנִין", translation = "мезонин-финансирование",
            definition = "שִׁלּוּב שֶׁל חוֹב וּמְנָיוֹת לִפְנֵי הַנְפָּקָה צִבּוּרִית, עִם רִיבִּית גְּבוֹהָה אֲבָל גְּמִישׁוּת.",
            definitionNative = "Смесь долга и акций перед выходом на биржу — высокая ставка, но гибкие условия.",
            example = "מֵזָנִין הִתְאִים לָנוּ כִּי לֹא רָצִינוּ לִדְלֹל אֶת הַמַּיְיסְדִים שׁוּב.",
            exampleNative = "מֵזָנִין нам подошёл — мы не хотели снова разводнять основателей.",
         fillInBlankExclusions = listOf(175901L, 175902L, 175903L, 175904L)),

        // ── startup_investors (5) — типы инвесторов ──
        WordEntity(
            id = 175906, setId = 1759, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_investors", transliteration = "enjel",
            original = "אֶנְגֵ'ל", translation = "ангел-инвестор",
            definition = "אִישׁ פְּרָטִי עָשִׁיר שֶׁמַּשְׁקִיעַ כֶּסֶף שֶׁלּוֹ בִּשְׁלָבִים מַקְדִּימִים שֶׁל יָזְמוּת.",
            definitionNative = "Богатый частник, вкладывающий свои деньги на самых ранних этапах предпринимательства.",
            example = "אֶנְגֵ'ל וָתִיק נָתַן לָנוּ צֵ'ק שֶׁל מָאתַיִם אֶלֶף שֶׁקֶל אַחֲרֵי שִׂיחָה אַחַת.",
            exampleNative = "Опытный אֶנְגֵ'ל выдал нам чек на двести тысяч шекелей после одного разговора.",
         fillInBlankExclusions = listOf(175907L, 175908L, 175909L, 175910L)),
        WordEntity(
            id = 175907, setId = 1759, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_investors", transliteration = "keren hon sikun",
            original = "קֶרֶן הוֹן סִיכּוּן", translation = "венчурный фонд",
            definition = "תַּאֲגִיד מִקְצוֹעִי שֶׁאוֹסֵף כֶּסֶף מִמַּשְׁקִיעִים גְּדוֹלִים וּמְפַזֵּר אוֹתוֹ בְּעֶשְׂרוֹת חֶבְרוֹת.",
            definitionNative = "Профессиональная контора — собирает деньги у крупных вкладчиков и распределяет на десятки фирм.",
            example = "קֶרֶן הוֹן סִיכּוּן יִשְׂרְאֵלִית הוֹבִילָה אֶת הַסִּבּוּב וְהֵבִיאָה שׁוּתָפִים נוֹסָפִים.",
            exampleNative = "Израильская קֶרֶן הוֹן סִיכּוּן возглавила раунд и привела ещё партнёров.",
         fillInBlankExclusions = listOf(175906L, 175908L, 175909L, 175910L)),
        WordEntity(
            id = 175908, setId = 1759, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_investors", transliteration = "korporeyt vi-si",
            original = "קוֹרְפּוֹרֵייט וִי-סִי", translation = "корпоративный VC",
            definition = "זְרוֹעַ הַשְׁקָעָה שֶׁל תַּאֲגִיד גָּדוֹל שֶׁמְּחַפֵּשׂ סִינֶרְגְיָה אִסְטְרָטֶגִית עִם הַחֶבְרָה הַצְּעִירָה.",
            definitionNative = "Инвест-рукав крупной корпорации — ищет стратегическую синергию с молодой фирмой.",
            example = "קוֹרְפּוֹרֵייט וִי-סִי שֶׁל אִינְטֵל הִשְׁקִיעַ בָּנוּ בִּסְכוּם נָאֶה.",
            exampleNative = "קוֹרְפּוֹרֵייט וִי-סִי от Intel вложил в нас приличную сумму.",
         fillInBlankExclusions = listOf(175906L, 175907L, 175909L, 175910L)),
        WordEntity(
            id = 175909, setId = 1759, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_investors", transliteration = "femili ofis",
            original = "פֶמִילִי אוֹפִיס", translation = "family office",
            definition = "מִשְׂרָד פְּרָטִי שֶׁמְּנַהֵל אֶת הַהוֹן שֶׁל מִשְׁפָּחָה אַחַת בְּעֶרֶךְ שֶׁל מֵאוֹת מִילְיוֹנִים.",
            definitionNative = "Частный офис, ведущий капитал одной семьи — обычно на сотни миллионов.",
            example = "פֶמִילִי אוֹפִיס מִלּוֹנְדּוֹן הִשְׁתַּתֵּף בַּסִּבּוּב כְּמַשְׁקִיעַ אִסְטְרָטֶגִי שָׁקֵט.",
            exampleNative = "פֶמִילִי אוֹפִיס из Лондона участвовал в раунде как тихий стратегический инвестор.",
         fillInBlankExclusions = listOf(175906L, 175907L, 175908L, 175910L)),
        WordEntity(
            id = 175910, setId = 1759, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_investors", transliteration = "el-pi",
            original = "אֵל-פִּי", translation = "limited partner (LP)",
            definition = "מַשְׁקִיעַ פָּסִיבִי שֶׁשָּׂם כֶּסֶף בַּקֶּרֶן אֲבָל לֹא מַחְלִיט בַּעֲסָקוֹת הַסּוֹפִיּוֹת.",
            definitionNative = "Пассивный вкладчик в фонд — кладёт деньги, но не решает по конкретным сделкам.",
            example = "אֵל-פִּי גָּדוֹל יָצָא מֵהַקֶּרֶן וְכָל הַתִּכְנוּן הָאֱסְטְרָטֶגִי הִשְׁתַּנָּה.",
            exampleNative = "Крупный אֵל-פִּי вышел из фонда — и весь стратегический план поменялся.",
         fillInBlankExclusions = listOf(175906L, 175907L, 175908L, 175909L)),

        // ── startup_programs (5) — программы поддержки ──
        WordEntity(
            id = 175911, setId = 1759, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_programs", transliteration = "akselerator",
            original = "אַקְסֶלֵרָטוֹר", translation = "акселератор",
            definition = "תָּכְנִית בַּת שְׁלוֹשָׁה חֳדָשִׁים שֶׁעוֹזֶרֶת לְיַזָּמִים לְזָרֵז פִּתּוּחַ תְּמוּרַת אָחוּז קָטָן בַּחֶבְרָה.",
            definitionNative = "Трёхмесячная программа — помогает основателям ускорить рост в обмен на маленький процент.",
            example = "הִתְקַבַּלְנוּ לְאַקְסֶלֵרָטוֹר יוּקְרָתִי בְּסַן פְרַנְצִיסְקוֹ אַחֲרֵי שִׁבְעָה רָאֲיוֹנוֹת.",
            exampleNative = "Нас взяли в престижный אַקְסֶלֵרָטוֹר в Сан-Франциско после семи интервью.",
         fillInBlankExclusions = listOf(175912L, 175913L, 175914L, 175915L)),
        WordEntity(
            id = 175912, setId = 1759, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_programs", transliteration = "studyo startap",
            original = "סְטוּדִיוֹ סְטַארְט-אַפּ", translation = "startup studio (стартап-фабрика)",
            definition = "מִזְנוֹן שֶׁל יְזָמִים שֶׁמַּקְמִים מִסְפַּר חֲבָרוֹת בְּמַקְבִּיל וּמְלַוֶּה אוֹתָן הַחֲל מִיוֹם רִאשׁוֹן.",
            definitionNative = "Команда предпринимателей, что запускает несколько компаний параллельно и ведёт их с самого начала.",
            example = "סְטוּדִיוֹ סְטַארְט-אַפּ מִתֵּל אָבִיב בָּנָה לָנוּ אֶת הַחֶבְרָה תּוֹךְ שִׁשָּׁה חֳדָשִׁים.",
            exampleNative = "סְטוּדִיוֹ סְטַארְט-אַפּ из Тель-Авива построил нам компанию за полгода.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175913, setId = 1759, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_programs", transliteration = "demo dey",
            original = "דֵּמוֹ דֵּיי", translation = "demo day",
            definition = "אֵרוּעַ סִיּוּם תָּכְנִית שֶׁבּוֹ כָּל הַמַּחְזוֹר מַצִּיג מוּצָר חַי לְפוֹרוּם רָחָב שֶׁל מַשְׁקִיעִים.",
            definitionNative = "Финальное событие программы — каждый поток показывает живой продукт большому залу инвесторов.",
            example = "בַּדֵּמוֹ דֵּיי הָיוּ מָאתַיִם מַשְׁקִיעִים וְהוֹתִירָה אוֹתָנוּ בְּלִי קוֹל מֵרֹב הַתְלָהֲבוּת.",
            exampleNative = "На דֵּמוֹ דֵּיי было двести инвесторов — мы охрипли от восторга.",
         fillInBlankExclusions = listOf(175911L, 175912L, 175914L, 175915L)),
        WordEntity(
            id = 175914, setId = 1759, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_programs", transliteration = "takharut startapim",
            original = "תַּחֲרוּת סְטַרְטְאַפִּים", translation = "конкурс стартапов",
            definition = "מַעֲמָד תְּחָרוּתִי שֶׁבּוֹ מִסְפַּר חֶבְרוֹת צְעִירוֹת מִתְמוֹדְדוֹת עַל פְּרָס כַּסְפִּי וְחֲשִׂיפָה.",
            definitionNative = "Соревновательное мероприятие — несколько молодых фирм борются за денежный приз и засветку.",
            example = "זָכִינוּ בְּתַחֲרוּת סְטַרְטְאַפִּים אֵירוֹפִּית עִם פְּרָס שֶׁל חֲמִישִּׁים אֶלֶף יוֹרוֹ.",
            exampleNative = "Мы выиграли תַּחֲרוּת סְטַרְטְאַפִּים в Европе с призом в пятьдесят тысяч евро.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175915, setId = 1759, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_programs", transliteration = "ma'anak mekhkar",
            original = "מַעֲנָק מֶחְקָר", translation = "исследовательский грант",
            definition = "סְכוּם כַּסְפִּי מִגּוּף מֶמְשַׁלְתִּי שֶׁנִּתָּן לְלֹא דְּרִישָׁה לְהַחְזִיר וּלְלֹא וִיתּוּר עַל מְנָיוֹת.",
            definitionNative = "Денежная сумма от государства — без требования возврата и без отдачи акций.",
            example = "קִבַּלְנוּ מַעֲנָק מֶחְקָר מֵרָשׁוּת הַחַדְשָׁנוּת לִפְנֵי הַסִּבּוּב הָרִאשׁוֹן.",
            exampleNative = "Мы получили מַעֲנָק מֶחְקָר от Управления инноваций до первого раунда.",
         fillInBlankExclusions = listOf(175911L, 175912L, 175913L, 175914L)),

        // ── startup_deal (5) — юридические термины сделки ──
        WordEntity(
            id = 175916, setId = 1759, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_deal", transliteration = "daf tna'im",
            original = "דַּף תְּנָאִים", translation = "term sheet",
            definition = "מִסְמָךְ קָצָר לֹא מְחַיֵּב מִשְׁפָּטִית שֶׁמְּסַכֵּם אֶת עִקְּרֵי הָעִסְקָה לִפְנֵי חוֹזֶה רִשְׁמִי.",
            definitionNative = "Короткая юридически необязательная бумага — резюмирует ключевые пункты сделки до контракта.",
            example = "הַמַּשְׁקִיעַ הָרָאשִׁי שָׁלַח דַּף תְּנָאִים בְּעֶרֶב חַג הַפֶּסַח.",
            exampleNative = "Главный инвестор прислал דַּף תְּנָאִים в канун Песаха.",
         fillInBlankExclusions = listOf(175917L, 175918L, 175919L, 175920L)),
        WordEntity(
            id = 175917, setId = 1759, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_deal", transliteration = "seif",
            original = "סֵיף", translation = "SAFE (упрощённая инвест-форма)",
            definition = "כְּלִי גִּיּוּס פָּשׁוּט שֶׁבּוֹ הַמַּשְׁקִיעַ נוֹתֵן כֶּסֶף הַיּוֹם וּמְקַבֵּל מְנָיוֹת רַק בָּרַאוּנְד הַבָּא.",
            definitionNative = "Простой инструмент сбора — инвестор даёт деньги сейчас, акции получает только в следующем раунде.",
            example = "שִׁבְעָה אֶנְגֵ'לִים נִכְנְסוּ דֶּרֶךְ סֵיף בְּלִי שֶׁקִּבַּעְנוּ עֲדַיִן הַעֲרָכָה.",
            exampleNative = "Семь ангелов зашли через סֵיף — оценку мы ещё не зафиксировали.",
         fillInBlankExclusions = listOf(175916L, 175918L, 175919L, 175920L)),
        WordEntity(
            id = 175918, setId = 1759, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_deal", transliteration = "shtar hamara",
            original = "שְׁטַר הַמָרָה", translation = "convertible note",
            definition = "הַלְוָאָה שֶׁמּוּסֶבֶת אוֹטוֹמָטִית לִמְנָיוֹת בָּעִסְקָה הַגְּדוֹלָה הַבָּאָה לְפִי הָנָחָה מֻסְכֶּמֶת.",
            definitionNative = "Заём, превращающийся автоматом в акции на следующей крупной сделке — по согласованной скидке.",
            example = "שְׁטַר הַמָרָה אִפְשֵׁר לָנוּ לִדְחוֹת אֶת וִיכּוּחַ הַהַעֲרָכָה לְעוֹד שָׁנָה.",
            exampleNative = "שְׁטַר הַמָרָה позволил нам отложить спор об оценке ещё на год.",
         fillInBlankExclusions = listOf(175916L, 175917L, 175919L, 175920L)),
        WordEntity(
            id = 175919, setId = 1759, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_deal", transliteration = "tikrat shovi",
            original = "תִּקְרַת שׁוֹוִי", translation = "valuation cap",
            definition = "מַקְסִימוּם שֶׁנִּקְבָּע מֵרֹאשׁ שֶׁמַּגֵּן עַל הַמַּשְׁקִיעַ הַמַּקְדִּים מִפְּנֵי הַעֲרָכָה גְּבוֹהָה מִדַּי.",
            definitionNative = "Заранее заданный максимум — защищает раннего инвестора от слишком высокой оценки.",
            example = "תִּקְרַת שׁוֹוִי שֶׁל חֲמִשָּׁה מִילְיוֹנִים נִשְׁמְעָה לָנוּ הוֹגֶנֶת בְּשִׁבְעָה בָּעֶרֶב.",
            exampleNative = "תִּקְרַת שׁוֹוִי в пять миллионов казалась нам справедливой в семь вечера.",
         fillInBlankExclusions = listOf(175916L, 175917L, 175918L, 175920L)),
        WordEntity(
            id = 175920, setId = 1759, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_deal", transliteration = "hidul'dul mnayot",
            original = "הִדּוּלְדּוּל מְנָיוֹת", translation = "разводнение акций",
            definition = "תַּהֲלִיךְ שֶׁבּוֹ אָחוּז הַבְּעָלִים הַוָּתִיקִים יוֹרֵד כִּי מַנְפִּיקִים נְיָרוֹת חֲדָשִׁים לְמַשְׁקִיעַ נוֹסָף.",
            definitionNative = "Процесс — доля старых владельцев падает, потому что выпускают бумаги новому вкладчику.",
            example = "הַמַּיְיסְדִים סָבְלוּ מֵהִדּוּלְדּוּל מְנָיוֹת שֶׁל חֲמֵשׁ עֶשְׂרֵה אָחוּז.",
            exampleNative = "Основатели пострадали от הִדּוּלְדּוּל מְנָיוֹת на пятнадцать процентов.",
         fillInBlankExclusions = listOf(175916L, 175917L, 175918L, 175919L)),

        // ── startup_pitch (5) — питч и due diligence ──
        WordEntity(
            id = 175921, setId = 1759, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_pitch", transliteration = "pitch dek",
            original = "פִּיטְץ' דֶּק", translation = "pitch deck",
            definition = "מַצָּגַת קְצָרָה שֶׁל כְּעֶשֶׂר שְׁקוּפִיּוֹת שֶׁמְּסַפֶּרֶת אֶת סִיפּוּר הַסְּטַרְטְאַפּ לְמַשְׁקִיעַ פּוֹטֶנְצְיָאלִי.",
            definitionNative = "Короткая презентация в десяток слайдов — рассказывает историю стартапа потенциальному инвестору.",
            example = "עָבַדְנוּ עַל פִּיטְץ' דֶּק שָׁבוּעַ שָׁלֵם וְהֶחֱלַפְנוּ אוֹתוֹ אַרְבַּע פְּעָמִים.",
            exampleNative = "Мы пилили פִּיטְץ' דֶּק целую неделю и переделывали четыре раза.",
         fillInBlankExclusions = listOf(175922L, 175923L, 175924L, 175925L)),
        WordEntity(
            id = 175922, setId = 1759, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_pitch", transliteration = "matsegert mashkim",
            original = "מַצֶּגֶת מַשְׁקִיעִים", translation = "презентация инвесторам",
            definition = "גִּלְגּוּל מְפֹרָט יוֹתֵר שֶׁל הַסִּפּוּר הָעִסְקִי, מוּכָן לִישִׁיבָה אֲרֻכָּה מוּל אַנְשֵׁי כְּסָפִים.",
            definitionNative = "Более развёрнутая версия бизнес-истории — для долгой встречи с финансистами.",
            example = "מַצֶּגֶת מַשְׁקִיעִים בִּשְׁלוֹשִׁים שְׁקוּפִיּוֹת עָנְתָה עַל כָּל הַשְּׁאֵלוֹת מֵרֹאשׁ.",
            exampleNative = "מַצֶּגֶת מַשְׁקִיעִים на тридцать слайдов закрыла все вопросы заранее.",
         fillInBlankExclusions = listOf(175921L, 175923L, 175924L, 175925L)),
        WordEntity(
            id = 175923, setId = 1759, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_pitch", transliteration = "ne'um ma'alit",
            original = "נְאוּם מַעֲלִית", translation = "elevator pitch",
            definition = "תֵּאוּר תַּמְצִיתִי בֶּן שְׁלוֹשִׁים שְׁנִיּוֹת שֶׁמְּסַבֵּר מַה הַחֶבְרָה עוֹשָׂה בְּלִי מַסְפָּרִים.",
            definitionNative = "Сжатое описание на тридцать секунд — что делает фирма, без чисел.",
            example = "פָּגַשְׁתִּי שֻׁתָּף שֶׁל הַקֶּרֶן בִּקְפִיטֶרְיָה וְהִסְפַּקְתִּי לִדְחֹף נְאוּם מַעֲלִית.",
            exampleNative = "Я встретил партнёра фонда в кафетерии — успел втиснуть נְאוּם מַעֲלִית.",
         fillInBlankExclusions = listOf(175921L, 175922L, 175924L, 175925L)),
        WordEntity(
            id = 175924, setId = 1759, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_pitch", transliteration = "she'elot bdikat ne'ot",
            original = "שְׁאֵלוֹת בְּדִיקַת נֶאוֹת", translation = "due diligence questions",
            definition = "רְשִׁימַת בֵּרוּרִים מְפֹרֶטֶת שֶׁמַּשְׁקִיעַ שׁוֹלֵחַ לִפְנֵי שֶׁהוּא חוֹתֵם וּמַעֲבִיר אֶת הַכֶּסֶף.",
            definitionNative = "Подробный список вопросов от инвестора — до подписания и перевода денег.",
            example = "שְׁאֵלוֹת בְּדִיקַת נֶאוֹת הִגִּיעוּ בְּקֹבֶץ אֶקְסֵל עִם מָאתַיִם פְּרִיטִים.",
            exampleNative = "שְׁאֵלוֹת בְּדִיקַת נֶאוֹת пришли в Excel-файле на двести пунктов.",
         fillInBlankExclusions = listOf(175921L, 175922L, 175923L, 175925L)),
        WordEntity(
            id = 175925, setId = 1759, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_pitch", transliteration = "shkufit trakshen",
            original = "שְׁקוּפִית טְרַקְשֶׁן", translation = "traction slide",
            definition = "עַמּוּד מִפְתֵּחַ בַּמַּצָּגַת שֶׁמַּרְאֶה גְּרָפִים שֶׁל גִּדּוּל מְהִיר וַחֲזָרַת לָקוֹחוֹת.",
            definitionNative = "Ключевая страница презентации — графики быстрого роста и возврата клиентов.",
            example = "שְׁקוּפִית טְרַקְשֶׁן עִם קַו עוֹלֶה חַד שִׁכְנְעָה אֶת הַמַּשְׁקִיעַ תּוֹךְ דַּקָּה.",
            exampleNative = "שְׁקוּפִית טְרַקְשֶׁן с резко растущей кривой убедила инвестора за минуту.",
         fillInBlankExclusions = listOf(175921L, 175922L, 175923L, 175924L)),
    )
}
