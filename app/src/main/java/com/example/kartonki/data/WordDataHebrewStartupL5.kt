package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Стартап", уровень L5 (носитель языка).
 *
 * Set 1760: «Стартап» — носитель языка (EPIC+LEGENDARY):
 *           скейлинг и exit-операционка. Финансы стартапа (runway,
 *           burn rate, unit economics, CAC/LTV), управление (board,
 *           voting/information rights, founder vesting), рост
 *           (growth hacking, viral coefficient, churn rate, retention
 *           cohort, expansion revenue), поздняя стадия (bridge round,
 *           secondary, down round, anti-dilution, ratchet) и пути exit
 *           (strategic/financial buyer, lockup, earn-out, escrow).
 *
 * Аудитория — русскоязычные founders / VP'ы / С-level в израильском
 * стартап-секторе. Лексика реальная: смесь иврита с английскими
 * заимствованиями (רַאנְוֵוי, בֵּרְן רֵייט, יוּנִיט אֵקוֹנוֹמִיקְס, בּוֹרְד,
 * סֵקוֹנְדֵרִי, דָּאוּן רָאוּנְד, אֵרְן-אַאוּט).
 *
 * Распределение редкостей: 13 EPIC + 12 LEGENDARY.
 *
 * SemanticGroups (5 × 5):
 *   startup_finance      — финансы стартапа: runway, burn rate, gross
 *                          margin, unit economics, CAC/LTV ratio
 *   startup_governance   — управление: board, board observer, voting
 *                          rights, information rights, founder vesting
 *   startup_growth       — рост: growth hacking, viral coefficient,
 *                          churn rate, retention cohort, expansion revenue
 *   startup_late_stage   — поздняя стадия: bridge round, secondary sale,
 *                          down round, anti-dilution, ratchet clause
 *   startup_exit_paths   — пути exit: strategic buyer, financial buyer,
 *                          lockup period, earn-out, escrow
 *
 * Word IDs: setId × 100 + position (176001..176025).
 *
 * Пересечения с другими наборами:
 *   - HightechL5 (1749) уже содержит IPO, M&A, exit, valuation, dilution,
 *     PMF, pivot, term sheet, due diligence, captable. В этом сете они
 *     НЕ повторяются — фокус на скейлинг + late-stage + exit-механика.
 *   - InterviewV2 (1751) содержит обычный וֶסְטִינְג. Здесь — отдельный
 *     термин וֶסְטִינְג מַיְיסְדִים (founder vesting, специфика для основателей).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них
 * отключён, пока LLM-pipeline не пройдёт по набору и не проставит
 * fillInBlankExclusions.
 */
object WordDataHebrewStartupL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1760, languagePair = "he-ru", orderIndex = 1760,
            name = "Стартап",
            description = "Скейлинг и exit: runway, burn rate, board, secondary, growth hacking",
            topic = "Стартап", level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1760 — Стартап: носитель языка (L5, EPIC+LEGENDARY)
        // 5 групп × 5 слов: finance, governance, growth, late_stage, exit_paths
        // ══════════════════════════════════════════════════════════════════════

        // ── startup_finance (5) — операционные финансы стартапа ──
        WordEntity(
            id = 176001, setId = 1760, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_finance", transliteration = "ranvey",
            original = "רַאנְוֵוי", translation = "runway (запас денег по времени)",
            definition = "מִסְפַּר הַחֳדָשִׁים שֶׁבָּהֶם הַסְּטַרְטְאַפּ שׂוֹרֵד עַד שֶׁהַכֶּסֶף נִגְמָר.",
            definitionNative = "Сколько месяцев стартап продержится, пока деньги на счёте не кончатся.",
            example = "נִשְׁאָר לָנוּ רַאנְוֵוי שֶׁל שִׁשָּׁה חֳדָשִׁים בִּלְבַד.",
            exampleNative = "У нас остался רַאנְוֵוי всего на шесть месяцев.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176002, setId = 1760, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_finance", transliteration = "bern reyt",
            original = "בֵּרְן רֵייט", translation = "burn rate (скорость трат в месяц)",
            definition = "כַּמּוּת הַכֶּסֶף שֶׁהַחֶבְרָה שׂוֹרֶפֶת בְּכָל חוֹדֶשׁ מֵעֵבֶר לְהַכְנָסוֹתֶיהָ.",
            definitionNative = "Сколько денег фирма проедает каждый месяц сверх своих поступлений.",
            example = "בֵּרְן רֵייט קָפַץ אַחֲרֵי שֶׁגִּיַּסְנוּ עוֹד עֶשְׂרִים מְהַנְדְּסִים.",
            exampleNative = "בֵּרְן רֵייט подскочил после того, как мы наняли ещё двадцать инженеров.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176003, setId = 1760, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_finance", transliteration = "shulei tipuel",
            original = "שׁוּלֵי תְפִעוּל", translation = "операционная маржа",
            definition = "מָה שֶׁנִּשְׁאָר מֵהַהַכְנָסוֹת אַחֲרֵי כָּל הוֹצָאוֹת הַתִּפְעוּל לִפְנֵי מִסִּים וְרִיבִּית.",
            definitionNative = "Что остаётся от выручки после всех операционных расходов — до налогов и процентов.",
            example = "שׁוּלֵי תְפִעוּל שְׁלִילִיִּים בָּרֶבַע הָאַחֲרוֹן הִדְלִיקוּ נוּרָה אֲדֻמָּה אֵצֶל הַבּוֹרְד.",
            exampleNative = "Отрицательные שׁוּלֵי תְפִעוּל в последнем квартале зажгли красную лампу у борда.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176004, setId = 1760, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_finance", transliteration = "yunit ekonomiks",
            original = "יוּנִיט אֵקוֹנוֹמִיקְס", translation = "юнит-экономика",
            definition = "חִשּׁוּב שֶׁל רֶוַח אוֹ הֶפְסֵד עַל לָקוֹחַ בּוֹדֵד אוֹ עִסְקָה אַחַת.",
            definitionNative = "Расчёт прибыли или убытка на одного клиента либо на одну сделку.",
            example = "בְּלִי יוּנִיט אֵקוֹנוֹמִיקְס חִיּוּבִי אֵין סִכּוּי לְצְמוֹחַ בְּרִיא.",
            exampleNative = "Без положительной יוּנִיט אֵקוֹנוֹמִיקְס нет шанса расти здоровым.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176005, setId = 1760, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_finance", transliteration = "yakhas si-ey-si le-el-ti-vi",
            original = "יַחַס סִי-אֵיי-סִי לְ-אֵל-טִי-וִי", translation = "соотношение CAC к LTV",
            definition = "מַדָּד שֶׁמַּשְׁוֶוה כַּמָּה עוֹלֶה לְהָבִיא לָקוֹחַ וְכַמָּה הוּא יָבִיא לְאוֹרֶךְ זְמַן.",
            definitionNative = "Метрика, которая сравнивает цену привлечения клиента с пожизненной выручкой от него.",
            example = "יַחַס סִי-אֵיי-סִי לְ-אֵל-טִי-וִי שֶׁל אֶחָד לִשְׁלֹשָׁה נֶחְשָׁב בָּרִיא.",
            exampleNative = "יַחַס סִי-אֵיי-סִי לְ-אֵל-טִי-וִי один к трём считается здоровым.",
            isFillInBlankSafe = false,
        ),

        // ── startup_governance (5) — совет директоров и права акционеров ──
        WordEntity(
            id = 176006, setId = 1760, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_governance", transliteration = "bord",
            original = "בּוֹרְד", translation = "совет директоров",
            definition = "קְבוּצָה שֶׁל אֲנָשִׁים בָּכִירִים שֶׁמְּפַקְּחִים עַל הַמְּנַכָּ\"ל וְעַל הַחֲלָטוֹת אֶסְטְרָטֶגִיּוֹת.",
            definitionNative = "Группа старших людей, которые контролируют гендиректора и стратегические решения.",
            example = "הַבּוֹרְד הִתְכַּנֵּס בְּחֵיפָה כְּדֵי לְאַשֵּׁר אֶת תַּקְצִיב הַשָּׁנָה הַבָּאָה.",
            exampleNative = "הַבּוֹרְד собрался в Хайфе — утвердить бюджет на следующий год.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176007, setId = 1760, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_governance", transliteration = "direktor khitsoni",
            original = "דִּירֶקְטוֹר חִיצוֹנִי", translation = "независимый директор",
            definition = "חֲבֵר בּוֹרְד שֶׁאֵין לוֹ אִינְטֶרֶס בַּחֶבְרָה — נִכְלָל לְשִׁמּוּר אִיזוּן וְשַׁקִּיפוּת.",
            definitionNative = "Член борда без личного интереса в компании — нужен для баланса и прозрачности.",
            example = "הוֹסַפְנוּ דִּירֶקְטוֹר חִיצוֹנִי לִפְנֵי הָרַאוּנְד הַבָּא לְהַרְאוֹת בָּגרוּת אִרְגוּנִית.",
            exampleNative = "Мы добавили דִּירֶקְטוֹר חִיצוֹנִי перед следующим раундом — показать организационную зрелость.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176008, setId = 1760, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_governance", transliteration = "zkhuyot hatsba'a",
            original = "זְכוּיוֹת הַצְבָּעָה", translation = "право голоса (на акциях)",
            definition = "הַכֹּחַ שֶׁבַּעַל מְנָיָה מַשְׁפִּיעַ עַל הַחְלָטוֹת הַגּוֹרָלִיּוֹת שֶׁל הַחֶבְרָה.",
            definitionNative = "Сила, с которой акционер влияет на ключевые решения компании.",
            example = "זְכוּיוֹת הַצְבָּעָה כְּפוּלוֹת שָׁמְרוּ עַל הַשְּׁלִיטָה אֵצֶל הַמַּיְיסְדִים.",
            exampleNative = "זְכוּיוֹת הַצְבָּעָה двойные сохранили контроль за основателями.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176009, setId = 1760, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_governance", transliteration = "divuakh le-mashkiim",
            original = "דִּיווּחַ לְמַשְׁקִיעִים", translation = "информационные права инвесторов",
            definition = "חוֹבָה שֶׁל הַחֶבְרָה לִשְׁלֹחַ נְתוּנִים פִינָנְסִיִּים לְבַעֲלֵי מְנָיוֹת בִּזְמַן קָבוּעַ.",
            definitionNative = "Обязанность фирмы регулярно слать финансовые данные акционерам.",
            example = "דִּיווּחַ לְמַשְׁקִיעִים מַגִּיעַ בְּכָל סוֹף רֹבַע יַחַד עִם דּוּ\"חַ הַנְהָלָה.",
            exampleNative = "דִּיווּחַ לְמַשְׁקִיעִים уходит в конце каждого квартала с отчётом руководства.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176010, setId = 1760, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_governance", transliteration = "vesting maysdim",
            original = "וֶסְטִינְג מַיְיסְדִים", translation = "вестинг основателей",
            definition = "תַּקָּנוֹן שֶׁדּוֹרֵשׁ מֵהַמַּתְחִילִים לַעֲבוֹד אַרְבַּע שָׁנִים כְּדֵי לְקַבֵּל אֶת חֶלְקָם.",
            definitionNative = "Правило, что зачинатели должны отработать четыре года, чтобы получить свою долю.",
            example = "וֶסְטִינְג מַיְיסְדִים מָנַע מֵאֶחָד מֵהַשְּׁנַיִים לָקַחַת אֶת הַכֹּל וְלָלֶכֶת.",
            exampleNative = "וֶסְטִינְג מַיְיסְדִים помешал одному из двух забрать всё и уйти.",
            isFillInBlankSafe = false,
        ),

        // ── startup_growth (5) — метрики и механики роста ──
        WordEntity(
            id = 176011, setId = 1760, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_growth", transliteration = "grout haking",
            original = "גְרוֹאוּת' הָאקִינְג", translation = "growth hacking (взрывной рост)",
            definition = "סֵט שֶׁל טַכְסִיסִים יְצִירָתִיִּים וְזוֹלִים שֶׁמַּקְפִּיצִים אֶת מִסְפַּר הַמִּשְׁתַּמְּשִׁים.",
            definitionNative = "Набор дешёвых хитрых приёмов, которыми сильно подбрасывают число пользователей.",
            example = "גְרוֹאוּת' הָאקִינְג עִם הַמְלָצוֹת חֲבֵרִים הֵבִיא מִילְיוֹן מִשְׁתַּמְּשִׁים בְּחוֹדֶשׁ.",
            exampleNative = "גְרוֹאוּת' הָאקִינְג через рекомендации друзей привёл миллион пользователей за месяц.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176012, setId = 1760, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_growth", transliteration = "mekadem virali",
            original = "מְקַדֵּם וִירָאלִי", translation = "вирусный коэффициент",
            definition = "הַמִּסְפָּר שֶׁמַּרְאֶה כַּמָּה מִשְׁתַּמְּשִׁים חֲדָשִׁים מֵבִיא בְּמַמּוּצָע מִשְׁתַּמֵּשׁ קַיָּם.",
            definitionNative = "Число, которое показывает, скольких новых приводит в среднем один существующий.",
            example = "מְקַדֵּם וִירָאלִי מֵעַל אֶחָד אוֹמֵר שֶׁהָאַפְּלִיקַצְיָה גְּדֵלָה לְבַד.",
            exampleNative = "מְקַדֵּם וִירָאלִי больше единицы означает, что приложение растёт само.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176013, setId = 1760, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_growth", transliteration = "shi'ur netisha",
            original = "שִׁעוּר נְטִישָׁה", translation = "отток клиентов (churn rate)",
            definition = "אָחוּז הַמִּשְׁתַּמְּשִׁים שֶׁעוֹזְבִים אֶת הַשֵּׁרוּת בְּתוֹךְ פֶּרֶק זְמַן קָבוּעַ.",
            definitionNative = "Процент пользователей, которые уходят из сервиса за фиксированный отрезок времени.",
            example = "שִׁעוּר נְטִישָׁה גָּבוֹהַּ אַחֲרֵי הַשִּׁדְרוּג הִכְעִיס אֶת הַמְּנַכָּ\"ל.",
            exampleNative = "שִׁעוּר נְטִישָׁה вырос после апдейта и взбесил гендиректора.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176014, setId = 1760, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_growth", transliteration = "kohort shimur",
            original = "קוֹהוֹרְט שִׁמּוּר", translation = "когорта удержания",
            definition = "קְבוּצָה שֶׁל מִשְׁתַּמְּשִׁים שֶׁנִּרְשְׁמוּ בְּאוֹתוֹ חוֹדֶשׁ וְנִבְדָּקִים לְאוֹרֶךְ זְמַן.",
            definitionNative = "Группа пользователей одной даты регистрации, за которыми следят со временем.",
            example = "קוֹהוֹרְט שִׁמּוּר שֶׁל יָנוּאָר הֶרְאָה שֶׁהָאַפְּלִיקַצְיָה דּוֹלֶפֶת אַחֲרֵי שָׁבוּעַ.",
            exampleNative = "קוֹהוֹרְט שִׁמּוּר января показала, что приложение протекает после недели.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176015, setId = 1760, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_growth", transliteration = "hakhnasat harkhava",
            original = "הַכְנָסַת הַרְחָבָה", translation = "доход от расширения (existing accounts)",
            definition = "כֶּסֶף נוֹסָף שֶׁבָּא מִלָּקוֹחוֹת קַיָּמִים שֶׁעָבְרוּ לְחֲבִילָה גְּדוֹלָה יוֹתֵר.",
            definitionNative = "Дополнительные деньги от текущих клиентов, что перешли на пакет побольше.",
            example = "הַכְנָסַת הַרְחָבָה הֵרִימָה אֶת הַ-אֵיי-אַר-אַר בְּלִי לְהָבִיא לָקוֹחַ חָדָשׁ.",
            exampleNative = "הַכְנָסַת הַרְחָבָה подняла ARR без единого нового клиента.",
            isFillInBlankSafe = false,
        ),

        // ── startup_late_stage (5) — поздняя стадия и защитные механизмы ──
        WordEntity(
            id = 176016, setId = 1760, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_late_stage", transliteration = "halva'at gesher",
            original = "הַלְוָאַת גֶּשֶׁר", translation = "бридж-раунд (промежуточное финансирование)",
            definition = "מַתָּן כֶּסֶף קָצָר טְוַח שֶׁמַּחֲזִיק אֶת הַחֶבְרָה עַד הַסִּיבּוּב הַגָּדוֹל הַבָּא.",
            definitionNative = "Короткая денежная подпитка, что держит фирму до следующего большого цикла.",
            example = "הַלְוָאַת גֶּשֶׁר שֶׁל חֲמִשָּׁה מִילְיוֹן הִצִּילָה אוֹתָנוּ לִפְנֵי סִדְרָה בִּי.",
            exampleNative = "הַלְוָאַת גֶּשֶׁר на пять миллионов спасла нас перед серией B.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176017, setId = 1760, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_late_stage", transliteration = "sekonderi",
            original = "סֵקוֹנְדֵרִי", translation = "secondary (продажа долей вторичным инвесторам)",
            definition = "עִסְקָה שֶׁבָּהּ בַּעַל מְנָיוֹת וָתִיק מוֹכֵר אֶת חֶלְקוֹ לְמַשְׁקִיעַ חָדָשׁ.",
            definitionNative = "Сделка, в которой давний акционер продаёт свою долю новому инвестору.",
            example = "סֵקוֹנְדֵרִי שֶׁל שְׁנֵי מִילְיוֹן אִפְשֵׁר לַמַּיְיסְדִים לִקְנוֹת בָּתִּים.",
            exampleNative = "סֵקוֹנְדֵרִי на два миллиона позволил основателям купить дома.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176018, setId = 1760, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_late_stage", transliteration = "daun raund",
            original = "דָּאוּן רָאוּנְד", translation = "down round (раунд по сниженной оценке)",
            definition = "סִיבּוּב הַשְׁקָעָה שֶׁבּוֹ הַשּׁוֹוִי שֶׁל הַחֶבְרָה נָמוּךְ מֵהַסִּיבּוּב הַקּוֹדֵם.",
            definitionNative = "Цикл инвестиций, в котором стоимость фирмы ниже, чем в прошлом цикле.",
            example = "דָּאוּן רָאוּנְד אַחֲרֵי הַמַּשְׁבֵּר זָרַק אֶת הַשּׁוֹוִי בִּשְׁלוֹשִׁים אָחוּז.",
            exampleNative = "דָּאוּן רָאוּנְד после кризиса уронил оценку на тридцать процентов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176019, setId = 1760, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_late_stage", transliteration = "anti-dilyushen",
            original = "אַנְטִי-דִּילְיוּשֶׁן", translation = "защита от размывания (anti-dilution)",
            definition = "סְעִיף שֶׁמְּגֵן עַל מַשְׁקִיעַ מִיְּרִידָה בְּשׁוֹוִי הַחֵלֶק שֶׁלּוֹ בַּסִּיבּוּב הַבָּא.",
            definitionNative = "Условие, что защищает инвестора от падения стоимости его доли в новом цикле.",
            example = "אַנְטִי-דִּילְיוּשֶׁן שָׁמַר אֶת הַקֶּרֶן הָרָאשִׁית כְּשֶׁהָעֲרָכָה צָנְחָה.",
            exampleNative = "אַנְטִי-דִּילְיוּשֶׁן защитил главный фонд, когда оценка обвалилась.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176020, setId = 1760, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_late_stage", transliteration = "se'if ratchet",
            original = "סְעִיף רָאצֶ'ט", translation = "ratchet (полная защита от разводнения)",
            definition = "תְּנַאי קָשׁוּחַ שֶׁמְּפַצֶּה אֶת הַמַּשְׁקִיעַ בִּמְנָיוֹת חִנָּם בִּזְמַן יְרִידַת שׁוֹוִי.",
            definitionNative = "Жёсткое условие, которое награждает инвестора бесплатными акциями при падении оценки.",
            example = "סְעִיף רָאצֶ'ט מָלֵא נָתַן לַקֶּרֶן עוֹד עֶשְׂרִים אָחוּז בַּחִנָּם.",
            exampleNative = "Полный סְעִיף רָאצֶ'ט выдал фонду ещё двадцать процентов задаром.",
            isFillInBlankSafe = false,
        ),

        // ── startup_exit_paths (5) — пути и механика выхода ──
        WordEntity(
            id = 176021, setId = 1760, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_exit_paths", transliteration = "rokhesh istrategi",
            original = "רוֹכֵשׁ אִסְטְרָטֶגִי", translation = "стратегический покупатель",
            definition = "תַּאֲגִיד גָּדוֹל שֶׁקּוֹנֶה כְּדֵי לְחַזֵּק אֶת הָעֵסֶק שֶׁלּוֹ, לֹא בִּשְׁבִיל רֶוַח מָהִיר.",
            definitionNative = "Большая корпорация, что покупает ради усиления своего бизнеса, не ради быстрой прибыли.",
            example = "רוֹכֵשׁ אִסְטְרָטֶגִי מֵאַמֵרִיקָה סָגַר אִתָּנוּ עִסְקָה שֶׁל מִילְיַארְד.",
            exampleNative = "רוֹכֵשׁ אִסְטְרָטֶגִי из Америки закрыл с нами сделку на миллиард.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176022, setId = 1760, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_exit_paths", transliteration = "kone finansi",
            original = "קוֹנֶה פִינָנְסִי", translation = "финансовый покупатель (PE-фонд)",
            definition = "קֶרֶן הַשְׁקָעָה שֶׁקּוֹנָה אֶת הַחֶבְרָה כְּדֵי לִמְכֹּר אוֹתָהּ בְּיֹקֶר תּוֹךְ כַּמָּה שָׁנִים.",
            definitionNative = "Инвестфонд, что покупает фирму с целью продать её дороже через несколько лет.",
            example = "קוֹנֶה פִינָנְסִי נִגְשַׁר עִמָּנוּ עַל הַעֲרָכָה נְמוּכָה מֵהַתַּאֲגִיד.",
            exampleNative = "קוֹנֶה פִינָנְסִי торговался с нами по оценке ниже, чем корпорация.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176023, setId = 1760, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_exit_paths", transliteration = "tkufat lokup",
            original = "תְּקוּפַת לוֹקְאַפּ", translation = "lockup (период блокировки акций)",
            definition = "פֶּרֶק זְמַן שֶׁבּוֹ אָסוּר לַמַּיְיסְדִים לִמְכֹּר אֶת הַמְּנָיוֹת אַחֲרֵי הַהַנְפָּקָה.",
            definitionNative = "Отрезок времени, в который основателям нельзя продавать акции после выхода на биржу.",
            example = "תְּקוּפַת לוֹקְאַפּ שֶׁל שִׁשָּׁה חֳדָשִׁים נִגְמְרָה רַק אַחֲרֵי הַחַג.",
            exampleNative = "תְּקוּפַת לוֹקְאַפּ в шесть месяцев истекла лишь после праздников.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176024, setId = 1760, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "startup_exit_paths", transliteration = "ern-aut",
            original = "אֵרְן-אַאוּט", translation = "earn-out (отложенная часть выплаты)",
            definition = "חֵלֶק מִתַּשְׁלוּם הָעִסְקָה שֶׁמְּשֻׁלָּם רַק אִם הַחֶבְרָה מַגִּיעָה לִיעָדִים מֵרֹאשׁ.",
            definitionNative = "Часть оплаты сделки, которую переводят только если фирма выполнит заранее цели.",
            example = "אֵרְן-אַאוּט שֶׁל שְׁנָתַיִם הִכְנִיס אוֹתָנוּ לְלַחַץ עַל הַ-אֵיי-אַר-אַר.",
            exampleNative = "אֵרְן-אַאוּט на два года поставил нас под давление по ARR.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176025, setId = 1760, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_exit_paths", transliteration = "eskro",
            original = "אֶסְקְרוֹ", translation = "эскроу (счёт у посредника)",
            definition = "חֶשְׁבּוֹן צַד שְׁלִישִׁי שֶׁמַּחֲזִיק כֶּסֶף עַד שֶׁכָּל הַתְּנָאִים שֶׁל הַעִסְקָה מִתְמַלְּאִים.",
            definitionNative = "Счёт у третьей стороны, что держит деньги, пока не выполнены все условия сделки.",
            example = "אֶסְקְרוֹ הִחְזִיק עֶשֶׂר אָחוּז מֵהַסְּכוּם לְמֶשֶׁךְ שָׁנָה אַחֲרֵי הַסְּגִירָה.",
            exampleNative = "אֶסְקְרוֹ держал десять процентов суммы целый год после закрытия.",
            isFillInBlankSafe = false,
        ),
    )
}
