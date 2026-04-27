package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Стартап", L3 «Углублённый» (RARE+EPIC).
 *
 * Set 1758: «Стартап» — углублённый L3:
 *           Идея и команда: основатели, MVP, валидация, product-market fit.
 *
 * Тема ориентирована на ранние стадии стартапа (idea, validation, MVP) —
 * не финансирование и не exit (это покрывает Хайтек L5). Лексика отражает
 * речь израильских предпринимателей: множество английских заимствований
 * (פָאוּנְדֶר, אֶם-וִי-פִּי, טְרַאקְשֶׁן, בּוּטְסְטרַאפּ, פְּרוֹדָאקְט מָארְקֶט פִיט) —
 * так реально говорят на питч-вечерах и в акселераторах.
 *
 * Распределение редкостей: 13 RARE + 12 EPIC (L3 = специальная стартап-лексика
 * раннего этапа, не базовый бизнес-сленг).
 *
 * SemanticGroups (5 × 5):
 *   startup_idea         — идея и валидация: идея, гипотеза, валидация, боль клиента, custdev
 *   startup_team         — команда: founder, со-учредительство, CEO, тех-руководитель, дополняющие скиллы
 *   startup_mvp          — MVP и итерации: MVP, прототип, лендинг, бета-тестеры, итерация
 *   startup_market_fit   — поиск рынка: целевая аудитория, PMF, ниша, конкурентный анализ, traction
 *   startup_culture      — культура раннего этапа: пивот, bootstrap, hustle, hands-on, миссия
 *
 * Word IDs: setId × 100 + position (175801..175825).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewStartupL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1758, languagePair = "he-ru", orderIndex = 1758,
            name = "Стартап",
            description = "Идея и команда: основатели, MVP, валидация, product-market fit",
            topic = "Стартап", level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1758 — Стартап: углублённый (L3, RARE+EPIC)
        // 5 групп × 5 слов: idea, team, mvp, market_fit, culture
        // ══════════════════════════════════════════════════════════════════════

        // ── startup_idea (5) — идея и её валидация ──
        WordEntity(
            id = 175801, setId = 1758, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_idea", transliteration = "kontsept mutsar",
            original = "קוֹנְצֶפְּט מוּצָר", translation = "концепт продукта",
            definition = "תֵּאוּר מַעֲשִׂי שֶׁל מוּצָר עָתִידִי — מָה הוּא עוֹשֶׂה, לְמִי וְאֵיךְ נִרְאֶה.",
            definitionNative = "Конкретное описание будущего продукта — что делает, для кого, как выглядит.",
            example = "הִצַּגְנוּ קוֹנְצֶפְּט מוּצָר לַלָּקוֹחוֹת לִפְנֵי שֶׁכָּתַבְנוּ קוֹד.",
            exampleNative = "Мы показали клиентам קוֹנְצֶפְּט מוּצָר до того, как написали код.",
         fillInBlankExclusions = listOf(175802L, 175803L, 175804L, 175805L, 175811L, 175812L)),
        WordEntity(
            id = 175802, setId = 1758, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_idea", transliteration = "hash'ara iskit",
            original = "הַשְׁעָרָה עִסְקִית", translation = "бизнес-предположение",
            definition = "אֲמִירָה שֶׁל הַמְּיַסֵּד עַל הַשּׁוּק שֶׁיֵּשׁ לִבְדֹּק בְּמַעֲשֶׂה לִפְנֵי הַשְׁקָעַת מַשָּׁאַבִּים.",
            definitionNative = "Утверждение основателя о рынке — нужно проверить на практике до вложения ресурсов.",
            example = "הַשְׁעָרָה עִסְקִית: מוֹרִים יְשַׁלְּמוּ עֲבוּר כְּלִי בְּדִיקָה אוֹטוֹמָטִית.",
            exampleNative = "הַשְׁעָרָה עִסְקִית: репетиторы заплатят за инструмент авто-проверки.",
         fillInBlankExclusions = listOf(175801L, 175803L, 175804L, 175805L)),
        WordEntity(
            id = 175803, setId = 1758, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_idea", transliteration = "validatsya",
            original = "וָלִידַצְיָה", translation = "валидация (идеи)",
            definition = "תַּהֲלִיךְ שֶׁבּוֹ בּוֹדְקִים אִם לְקוֹחוֹת בֶּאֱמֶת רוֹצִים לְשַׁלֵּם עַל מַה שֶׁמְּתַכְנְנִים.",
            definitionNative = "Процесс, в котором проверяют, готовы ли клиенты реально платить за то, что планируют.",
            example = "אַחֲרֵי וָלִידַצְיָה עִם עֶשְׂרִים מִשְׁתַּמְּשִׁים הֵבַנּוּ שֶׁצְּרִיכִים פִיצֶ׳ר אַחֵר.",
            exampleNative = "После וָלִידַצְיָה с двадцатью пользователями мы поняли, что нужна другая фича.",
         fillInBlankExclusions = listOf(175801L, 175802L, 175804L, 175805L, 175815L)),
        WordEntity(
            id = 175804, setId = 1758, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_idea", transliteration = "ke'ev lakoah",
            original = "כְּאֵב לָקוֹחַ", translation = "боль клиента",
            definition = "בְּעָיָה כּוֹאֶבֶת מַסְפִּיק שֶׁאֲנָשִׁים מוּכָנִים לְשַׁלֵּם כְּדֵי לִפְתֹּר אוֹתָהּ.",
            definitionNative = "Проблема, болезненная настолько, что люди готовы платить за её решение.",
            example = "בְּלִי כְּאֵב לָקוֹחַ אֲמִיתִּי הַסְּטַארְט-אַפּ נִשְׁאָר רַק תַּרְגִּיל אֲקָדֵמִי.",
            exampleNative = "Без настоящей כְּאֵב לָקוֹחַ стартап остаётся лишь академическим упражнением.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175805, setId = 1758, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_idea", transliteration = "kastomer development",
            original = "קַסְטוֹמֶר דֶּוֶולוֹפְּמֶנְט", translation = "customer development (исследование клиентов)",
            definition = "שִׁיטָה שֶׁל רֵאָיוֹנוֹת עִם מִשְׁתַּמְּשִׁים פּוֹטֶנְצְיָאלִיִּים כְּדֵי לְהָבִין אֶת הַצְּרָכִים שֶׁלָּהֶם.",
            definitionNative = "Метод интервью с потенциальными пользователями — чтобы понять их реальные нужды.",
            example = "קַסְטוֹמֶר דֶּוֶולוֹפְּמֶנְט גִּלָּה לָנוּ שֶׁהַמַּחִיר חָשׁוּב פָּחוֹת מֵהַזְּמָן.",
            exampleNative = "קַסְטוֹמֶר דֶּוֶולוֹפְּמֶנְט показал нам — цена важна меньше, чем время.",
         fillInBlankExclusions = listOf(175801L, 175802L, 175803L, 175804L, 175819L)),

        // ── startup_team (5) — состав ранней команды ──
        WordEntity(
            id = 175806, setId = 1758, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_team", transliteration = "faunder",
            original = "פָאוּנְדֶר", translation = "основатель (founder)",
            definition = "אִישׁ שֶׁהֵקִים אֶת הַחֶבְרָה מֵאֶפֶס וְלוֹקֵחַ אֶת הַסִּכּוּן הָרִאשׁוֹן עַל עַצְמוֹ.",
            definitionNative = "Человек, поднявший фирму с нуля и взявший на себя первый риск.",
            example = "כָּל פָאוּנְדֶר עוֹבֵד שָׁבוּעַ שֶׁל שִׁבְעִים שָׁעוֹת בַּשָּׁנָה הָרִאשׁוֹנָה.",
            exampleNative = "Каждый פָאוּנְדֶר работает по семьдесят часов в неделю в первый год.",
         fillInBlankExclusions = listOf(175807L, 175808L, 175809L, 175810L)),
        WordEntity(
            id = 175807, setId = 1758, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_team", transliteration = "shutafut hakama",
            original = "שׁוּתָפוּת הַקָמָה", translation = "со-учредительство (партнёрство при основании)",
            definition = "מַעֲרֶכֶת יַחֲסִים בֵּין שְׁנֵי אֲנָשִׁים שֶׁפּוֹתְחִים יַחַד עֵסֶק וּמַחֲלֹקִים אַחְרָיוּת.",
            definitionNative = "Отношения двух людей, открывающих вместе бизнес и делящих ответственность.",
            example = "שׁוּתָפוּת הַקָמָה דּוֹרֶשֶׁת הֶסְכֵּם בָּרוּר עַל אֲחוּזִים וְעַל תַּפְקִידִים.",
            exampleNative = "שׁוּתָפוּת הַקָמָה требует ясного соглашения о долях и ролях.",
         fillInBlankExclusions = listOf(175806L, 175808L, 175809L, 175810L)),
        WordEntity(
            id = 175808, setId = 1758, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_team", transliteration = "si-i-o",
            original = "סִי-אִי-אוֹ", translation = "CEO (генеральный директор)",
            definition = "הָאָדָם הָרָאשִׁי שֶׁמַּחְלִיט עַל הַחֲזוֹן וְעַל הַתַּקְצִיב וְעוֹמֵד מוּל הַמַּשְׁקִיעִים.",
            definitionNative = "Главный человек — решает по видению и бюджету, общается с инвесторами.",
            example = "הַסִּי-אִי-אוֹ נִפְגַּשׁ עִם שְׁלוֹשָׁה קְרָנוֹת בַּשָּׁבוּעַ הַקָּרוֹב.",
            exampleNative = "סִי-אִי-אוֹ встречается с тремя фондами на следующей неделе.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175809, setId = 1758, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_team", transliteration = "mehandes rashi",
            original = "מְהַנְדֵּס רָאשִׁי", translation = "главный инженер (технический руководитель стартапа)",
            definition = "הָאַחְרַאי הַטֶּכְנִי הַבָּכִיר שֶׁבּוֹחֵר טֶכְנוֹלוֹגְיוֹת וּמְכַוֵּן אֶת הָאַרְכִיטֶקְטוּרָה.",
            definitionNative = "Старший технический ответственный — выбирает технологии и задаёт архитектуру.",
            example = "מְהַנְדֵּס רָאשִׁי טוֹב חוֹסֵךְ לַסְּטַארְט-אַפּ חֳדָשִׁים שֶׁל עֲבוֹדָה כְּפוּלָה.",
            exampleNative = "Хороший מְהַנְדֵּס רָאשִׁי экономит стартапу месяцы лишней работы.",
         fillInBlankExclusions = listOf(175806L, 175807L, 175808L, 175810L)),
        WordEntity(
            id = 175810, setId = 1758, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_team", transliteration = "hashlamat meyumanuyot",
            original = "הַשְׁלָמַת מְיֻמָּנֻיּוֹת", translation = "взаимодополнение компетенций (skill complementarity)",
            definition = "מַצָּב שֶׁבּוֹ כָּל אֶחָד בַּצֶּוֶות מֵבִיא יְכוֹלוֹת שׁוֹנוֹת — וְיַחַד הֵם מְכַסִּים אֶת הַכֹּל.",
            definitionNative = "Ситуация, когда каждый в команде приносит свои навыки — и вместе они закрывают всё.",
            example = "הַשְׁלָמַת מְיֻמָּנֻיּוֹת בֵּין מְהַנְדֵּס לְאִישׁ מַכִּירוֹת קְרִיטִית בַּשָּׁלָב הַמֻּקְדָּם.",
            exampleNative = "הַשְׁלָמַת מְיֻמָּנֻיּוֹת между инженером и продажником критична на ранней стадии.",
         fillInBlankExclusions = listOf(175806L, 175807L, 175808L, 175809L)),

        // ── startup_mvp (5) — MVP и итерации ──
        WordEntity(
            id = 175811, setId = 1758, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_mvp", transliteration = "em-vi-pi",
            original = "אֶם-וִי-פִּי", translation = "MVP (минимально жизнеспособный продукт)",
            definition = "גִּרְסָה רָזָה בְּיוֹתֵר שֶׁעוֹשָׂה רַק דָּבָר אֶחָד וּמַסְפִּיקָה כְּדֵי לִבְדֹּק בִּקּוּשׁ.",
            definitionNative = "Самая лёгкая версия — делает только одно и достаточна, чтобы проверить спрос.",
            example = "בָּנִינוּ אֶם-וִי-פִּי בְּשִׁשָּׁה שָׁבוּעוֹת וְהוֹצֵאנוּ אוֹתוֹ לְמַעְגַּל סָגוּר.",
            exampleNative = "Мы построили אֶם-וִי-פִּי за шесть недель и выпустили его в закрытый круг.",
         fillInBlankExclusions = listOf(175812L, 175813L, 175814L, 175815L)),
        WordEntity(
            id = 175812, setId = 1758, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_mvp", transliteration = "prototip",
            original = "פְּרוֹטוֹטִיפּ", translation = "прототип (стартапа)",
            definition = "דֻּגְמָה עוֹבֶדֶת בְּאֹפֶן חֶלְקִי שֶׁמַּמְחִישָׁה אֵיךְ הָרַעְיוֹן יִרְאֶה בִּפְעֻלָּה.",
            definitionNative = "Частично работающий образец — показывает, как замысел будет выглядеть в действии.",
            example = "פְּרוֹטוֹטִיפּ בְּפִיגְמָה הִסְפִּיק לָנוּ כְּדֵי לְשַׁכְנֵעַ אֶת הַמַּלְאָךְ הָרִאשׁוֹן.",
            exampleNative = "פְּרוֹטוֹטִיפּ в Figma хватило, чтобы убедить первого ангела.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175813, setId = 1758, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_mvp", transliteration = "lending",
            original = "לֶנְדִּינְג", translation = "лендинг (посадочная страница)",
            definition = "דַּף יָחִיד בָּאִינְטֶרְנֶט שֶׁמַּסְבִּיר אֶת הַמּוּצָר וּמְבַקֵּשׁ אִי-מֵייל אוֹ תַּשְׁלוּם.",
            definitionNative = "Одна страница в интернете — объясняет продукт и просит email или оплату.",
            example = "הַלֶּנְדִּינְג הָרִאשׁוֹן שֶׁלָּנוּ אָסַף שָׁלוֹשׁ מֵאוֹת רִשּׁוּמִים בְּסוֹף שָׁבוּעַ.",
            exampleNative = "Наш первый לֶנְדִּינְג собрал триста регистраций за выходные.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175814, setId = 1758, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_mvp", transliteration = "beta tester",
            original = "בֵּיטָא טֶסְטֶר", translation = "бета-тестер",
            definition = "מִשְׁתַּמֵּשׁ מֻקְדָּם שֶׁמְּקַבֵּל גִּישָׁה לִפְנֵי הַשְׁאָר וּמַחֲזִיר מַשְׁוֹב מַעֲשִׂי.",
            definitionNative = "Ранний пользователь, получающий доступ раньше остальных и присылающий практический отклик.",
            example = "אָסַפְנוּ חֲמִישִּׁים בֵּיטָא טֶסְטֶר מִקְּהִילַת הַמְּפַתְּחִים שֶׁל תֵּל-אָבִיב.",
            exampleNative = "Мы собрали пятьдесят בֵּיטָא טֶסְטֶר из сообщества разработчиков Тель-Авива.",
         fillInBlankExclusions = listOf(175811L, 175812L, 175813L, 175815L)),
        WordEntity(
            id = 175815, setId = 1758, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_mvp", transliteration = "iteratsya",
            original = "אִיטֵרַצְיָה", translation = "итерация (цикл доработки)",
            definition = "סִבּוּב אֶחָד שֶׁל שִׁפּוּר עַל בָּסִיס מַשְׁוֹב — שׁוֹלְחִים, בּוֹדְקִים, מְשַׁנִּים, מַחְזִירִים.",
            definitionNative = "Один круг улучшения по фидбеку — выпустили, проверили, изменили, выпустили снова.",
            example = "אַחֲרֵי שָׁלוֹשׁ אִיטֵרַצְיָה הָאַפְּלִיקַצְיָה הִתְחִילָה לְהַרְגִּישׁ נָכוֹן.",
            exampleNative = "После трёх אִיטֵרַצְיָה приложение начало ощущаться правильно.",
         fillInBlankExclusions = listOf(175803L, 175811L, 175812L, 175813L, 175814L)),

        // ── startup_market_fit (5) — поиск рынка и позиционирование ──
        WordEntity(
            id = 175816, setId = 1758, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_market_fit", transliteration = "kahal yaad",
            original = "קְהַל יַעַד", translation = "целевая аудитория",
            definition = "קְבוּצָה מְסֻיֶּמֶת שֶׁל אֲנָשִׁים שֶׁהַמּוּצָר נוֹעַד בִּשְׁבִילָם וְלֹא בִּשְׁבִיל כֻּלָּם.",
            definitionNative = "Конкретная группа людей, для которых сделан продукт — а не для всех подряд.",
            example = "קְהַל יַעַד שֶׁל אִמָּהוֹת לִילָדִים קְטַנִּים מֵבִין אֶת הַבְּעָיָה הָרִאשׁוֹנָה שֶׁלָּנוּ.",
            exampleNative = "קְהַל יַעַד из мам с маленькими детьми сразу понимает нашу первую проблему.",
         fillInBlankExclusions = listOf(175817L, 175818L, 175819L, 175820L)),
        WordEntity(
            id = 175817, setId = 1758, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_market_fit", transliteration = "prodakt market fit",
            original = "פְּרוֹדָאקְט מָארְקֶט פִיט", translation = "product-market fit (PMF)",
            definition = "מַצָּב שֶׁבּוֹ הַשּׁוּק מוֹשֵׁךְ אֶת הַמּוּצָר חָזָק יוֹתֵר מִמַּה שֶׁהַחֶבְרָה מַצְלִיחָה לְסַפֵּק.",
            definitionNative = "Состояние, когда рынок тянет продукт сильнее, чем фирма успевает поставлять.",
            example = "בְּלִי פְּרוֹדָאקְט מָארְקֶט פִיט אֵין טַעַם לְהַשְׁקִיעַ בְּשִׁוּוּק אַגְרֶסִיבִי.",
            exampleNative = "Без פְּרוֹדָאקְט מָארְקֶט פִיט нет смысла вкладываться в агрессивный маркетинг.",
         fillInBlankExclusions = listOf(175816L, 175818L, 175819L, 175820L)),
        WordEntity(
            id = 175818, setId = 1758, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_market_fit", transliteration = "nisha",
            original = "נִישָׁה", translation = "ниша (сегмент рынка)",
            definition = "פִּינָה צָרָה בַּשּׁוּק עִם קָהָל מְסֻיָּם שֶׁהַשְּׁחָקָנִים הַגְּדוֹלִים מְזַלְזְלִים בָּהּ.",
            definitionNative = "Узкий уголок рынка с конкретной публикой — большие игроки им пренебрегают.",
            example = "מָצָאנוּ נִישָׁה שֶׁל רוֹפְאֵי שִׁנַּיִם פְּרָטִיִּים שֶׁאֵין לָהֶם מַעֲרֶכֶת זְמִינָה.",
            exampleNative = "Мы нашли נִישָׁה из частных стоматологов, у которых нет доступной системы.",
         fillInBlankExclusions = listOf(175816L, 175817L, 175819L, 175820L)),
        WordEntity(
            id = 175819, setId = 1758, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_market_fit", transliteration = "nituakh tahrut",
            original = "נִיתוּחַ תַּחֲרוּת", translation = "конкурентный анализ",
            definition = "הַשְׁוָאָה שִׁיטָתִית שֶׁל הַמּוּצָר מוּל מָה שֶׁהַשְּׁחָקָנִים הָאֲחֵרִים בַּשּׁוּק מַצִּיעִים.",
            definitionNative = "Системное сравнение продукта с тем, что предлагают другие игроки на рынке.",
            example = "הַנִּיתוּחַ תַּחֲרוּת חָשַׂף שְׁתֵּי חֶבְרוֹת שֶׁעוֹשׂוֹת כִּמְעַט בְּדִיּוּק אֶת אוֹתוֹ דָּבָר.",
            exampleNative = "נִיתוּחַ תַּחֲרוּת вскрыл две фирмы, делающие почти то же самое.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175820, setId = 1758, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_market_fit", transliteration = "trakshen",
            original = "טְרַאקְשֶׁן", translation = "traction (тяга, ранний рост)",
            definition = "סִימָנִים מְדִידִים שֶׁל גִּדּוּל אֲמִיתִּי — מִשְׁתַּמְּשִׁים חֲדָשִׁים, הַכְנָסָה וְשִׁמּוּשׁ קָבוּעַ.",
            definitionNative = "Измеримые признаки реального роста — новые юзеры, выручка и постоянное использование.",
            example = "מַשְׁקִיעִים בִּשְׁלָב סִיד מְחַפְּשִׂים טְרַאקְשֶׁן עָם מְעַט מְדִידוֹת חִיּוּבִיּוֹת.",
            exampleNative = "Сид-инвесторы ищут טְרַאקְשֶׁן с несколькими положительными метриками.",
         fillInBlankExclusions = listOf(175816L, 175817L, 175818L, 175819L)),

        // ── startup_culture (5) — культура раннего стартапа ──
        WordEntity(
            id = 175821, setId = 1758, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_culture", transliteration = "shinui kivun",
            original = "שִׁינּוּי כִּוּוּן", translation = "пивот (резкая смена курса)",
            definition = "הַחְלָטָה לְהַחְלִיף אֶת הַשּׁוּק אוֹ אֶת הַמּוּצָר אַחֲרֵי שֶׁהַמַּסְלוּל הָרִאשׁוֹן לֹא עוֹבֵד.",
            definitionNative = "Решение сменить рынок или продукт после того, как первый путь не сработал.",
            example = "אַחֲרֵי שָׁנָה שֶׁל וָלִידַצְיָה כּוֹשֶׁלֶת בִּצַּעְנוּ שִׁינּוּי כִּוּוּן לְקָהָל אַחֵר לְגַמְרֵי.",
            exampleNative = "После года провальных проверок мы сделали שִׁינּוּי כִּוּוּן на совсем другую аудиторию.",
         fillInBlankExclusions = listOf(175822L, 175823L, 175824L, 175825L)),
        WordEntity(
            id = 175822, setId = 1758, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_culture", transliteration = "butstrap",
            original = "בּוּטְסְטרַאפּ", translation = "bootstrap (развитие без инвесторов)",
            definition = "צוּרַת בְּנִיָּה שֶׁל עֵסֶק רַק מִכֶּסֶף הַמַּיְיסְּדִים וּמֵהַכְנָסוֹת לְלֹא מְמַמְּנִים חִיצוֹנִיִּים.",
            definitionNative = "Способ строить бизнес — только на деньги основателей и выручку, без внешнего финансирования.",
            example = "בּוּטְסְטרַאפּ דּוֹרֵשׁ סַבְלָנוּת אֲבָל מַשְׁאִיר אֶת הַשְּׁלִיטָה אֵצֶל הַמַּיְיסְּדִים.",
            exampleNative = "בּוּטְסְטרַאפּ требует терпения, но оставляет контроль в руках основателей.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175823, setId = 1758, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_culture", transliteration = "hasl",
            original = "הַסְל", translation = "hustle (драйв и упорство)",
            definition = "אֶנֶרְגְיָה שֶׁל לִרְדֹּף אַחֲרֵי הָזְדַּמְּנֻיּוֹת בְּלִי לֵאוּת — לִשְׁלֹחַ, לִשְׁאֹל, לְהַתְחִיל.",
            definitionNative = "Энергия гнаться за возможностями без устали — писать, спрашивать, начинать.",
            example = "בְּשָׁלָב הַסִּיד הַסְל חָשׁוּב יוֹתֵר מִתֹּכְנִית עֲסָקִית מֻשְׁלֶמֶת.",
            exampleNative = "На сид-стадии הַסְל важнее идеального бизнес-плана.",
         fillInBlankExclusions = listOf(175821L, 175822L, 175824L, 175825L)),
        WordEntity(
            id = 175824, setId = 1758, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "startup_culture", transliteration = "gisha me'oravet",
            original = "גִּישָׁה מְעֹרָבֶת", translation = "hands-on подход (вовлечённый стиль)",
            definition = "סִגְנוֹן עֲבוֹדָה שֶׁבּוֹ הַמְּנַהֵל יוֹרֵד לִפְרָטִים וְעוֹשֶׂה דְּבָרִים בַּיָּדַיִם בְּעַצְמוֹ.",
            definitionNative = "Стиль работы, при котором руководитель спускается до деталей и делает руками сам.",
            example = "גִּישָׁה מְעֹרָבֶת שֶׁל הַמַּיְיסְּדִים נָתְנָה לַצֶּוֶות תְּחוּשָׁה שֶׁכֻּלָּם בְּאוֹתוֹ הַסִּירָה.",
            exampleNative = "גִּישָׁה מְעֹרָבֶת основателей дала команде ощущение, что все в одной лодке.",
         fillInBlankExclusions = listOf(175821L, 175822L, 175823L, 175825L)),
        WordEntity(
            id = 175825, setId = 1758, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "startup_culture", transliteration = "misyon",
            original = "מִיסְיוֹן", translation = "миссия стартапа",
            definition = "מִשְׁפָּט קָצָר שֶׁמַּסְבִּיר לָמָּה הַחֶבְרָה קַיֶּמֶת וְאֶת מִי הִיא רוֹצָה לְשָׁרֵת בָּעוֹלָם.",
            definitionNative = "Короткая фраза о том, зачем фирма существует и кому она хочет служить в мире.",
            example = "הַמִּיסְיוֹן הַבָּרוּר עָזַר לָנוּ לִדְחוֹת לְקוֹחוֹת שֶׁלֹּא הִתְאִימוּ לַחֶבְרָה.",
            exampleNative = "Чёткий מִיסְיוֹן помог нам отказывать клиентам, которые фирме не подходили.",
            isFillInBlankSafe = false,
        ),
    )
}
