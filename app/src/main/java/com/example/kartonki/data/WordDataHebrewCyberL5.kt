package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Кибербезопасность", уровень L5 (носитель языка).
 *
 * Set 1782: «Кибербезопасность» — носитель языка L5 (EPIC + LEGENDARY):
 *           управление безопасностью, threat intelligence, defense-in-depth,
 *           governance высокого уровня и непрерывность бизнеса.
 *
 * Целевая аудитория — русскоязычные senior security-инженеры, CISO, GRC-leads
 * и архитекторы в израильских компаниях. Лексика defensive & governance —
 * никаких offensive techniques (red team / pentest / exploit живут в CyberL4).
 *
 * Лексика двуязычная: иврит + плотный слой английских заимствований
 * (סִי-אַייסוֹ, BISO, SOAR, MITRE ATT&CK, ISO 27017, NIST, RPO, RTO) — так
 * реально говорят на security-комитетах и в профильных подкастах.
 *
 * Распределение редкостей:
 *   13 EPIC + 12 LEGENDARY (без выхода за 2 смежных уровня).
 *
 * SemanticGroups (5 × 5):
 *   cyber_leadership            — лидерство: CISO, security architect, head of GRC, principal sec engineer, BISO
 *   cyber_threat_intelligence   — threat intel: разведка, фид индикаторов, threat hunting, attribution, MITRE ATT&CK
 *   cyber_defense_in_depth      — глубина защиты: defense-in-depth, SOAR, security automation, runbook, blue-team playbook
 *   cyber_governance_advanced   — governance L5: security policy, awareness training, risk register, ISO 27017, NIST CSF
 *   cyber_business_continuity   — непрерывность: BCP, disaster recovery, RPO, RTO, cyber insurance
 *
 * Word IDs: setId × 100 + position (178201..178225).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 *
 * Заметки про возможные пересечения с соседями:
 * - CyberL3 (1767) содержит хеширование, MFA, SSO, файрвол, IDS/IPS, DMZ —
 *   здесь все термины иные (управленческие, не технические).
 * - CyberL4 (1768) содержит pentest, red/blue team, SIEM, SOC, IOC, ISO 27001,
 *   GDPR, zero trust, criptography. В этом наборе их нет:
 *     • вместо "ISO 27001" — "ISO 27017" (cloud-specific вариант стандарта);
 *     • вместо "IOC" — "פִיד אִינְדִיקָטוֹרִים" (feed of indicators) и "צַיָּד אִיּוּמִים"
 *       (threat hunting) — иные концепции;
 *     • вместо "SIEM" — "SOAR" (orchestration, не aggregation);
 *     • вместо "incident response" — "פְּלֵייבּוּק כְּחֻלָּה" (blue-team playbook);
 *     • вместо "audit" — "מַטְרִיצַת סִיכּוּנִים" (risk register).
 * - HightechL4 (1748) содержит פֶּנְ-טֶסְט, אִיּוּמֵי סַייבֶּר, מִבְדַּק אַבְטָחָה, GDPR.
 *   Здесь не пересекается — управленческий слой, иные термины.
 * - HightechL5 (1749) содержит C-level (CTO, VP R&D, CPO), funding/exit/strategy.
 *   Пересечения нет: здесь security-leadership (CISO/BISO/security architect),
 *   funding/exit/strategy не дублируются.
 */
object WordDataHebrewCyberL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1782, languagePair = "he-ru", orderIndex = 1782,
            name = "Кибербезопасность",
            description = "Управление безопасностью: CISO, threat intel, defense-in-depth, аудит, страхование",
            topic = "Кибербезопасность", level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1782 — Кибербезопасность: носитель языка (L5, EPIC + LEGENDARY)
        // 5 групп × 5 слов: leadership, threat intelligence, defense-in-depth,
        //                   governance, business continuity
        // ══════════════════════════════════════════════════════════════════════

        // ── cyber_leadership (5) — security-руководители высшего звена ──
        WordEntity(
            id = 178201, setId = 1782, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_leadership", transliteration = "si-ayso",
            original = "סִי-אַייסוֹ", translation = "CISO (директор по информационной безопасности)",
            definition = "מְנַהֵל בָּכִיר שֶׁאַחְרָאִי עַל כָּל הָאַסְטְרָטֶגְיָה וְעַל הַתַּקְצִיב שֶׁל הֲגָנָה דִיגִיטָלִית בָּאִרְגּוּן.",
            definitionNative = "Старший управленец, отвечающий за стратегию и бюджет цифровой защиты в организации.",
            example = "סִי-אַייסוֹ הִצִּיג לַדִּירֶקְטוֹרְיוֹן תָּכְנִית רַב-שְׁנָתִית לְצִמְצוּם סִיכּוּנִים.",
            exampleNative = "סִי-אַייסוֹ представил совету директоров многолетний план снижения рисков.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178202, setId = 1782, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "cyber_leadership", transliteration = "arkhitekt avtakha",
            original = "אַרְכִיטֵקְט אַבְטָחָה", translation = "архитектор безопасности",
            definition = "מְעַצֵּב מַעֲרָכוֹת שֶׁבּוֹחֵר אֵיךְ לְשַׁלֵּב הֲגָנָה לְתוֹךְ כָּל שִׁכְבָה שֶׁל הַמּוּצָר.",
            definitionNative = "Проектировщик систем — выбирает, как вшить защиту в каждый слой продукта.",
            example = "אַרְכִיטֵקְט אַבְטָחָה דָּרַשׁ לְהַצְפִּין אֶת כָּל הַתִּקְשֹׁרֶת בֵּין הַמִּיקְרוֹ-שֵׁרוּתִים.",
            exampleNative = "אַרְכִיטֵקְט אַבְטָחָה потребовал шифровать всю связь между микросервисами.",
         fillInBlankExclusions = listOf(178201L, 178203L, 178204L, 178205L)),
        WordEntity(
            id = 178203, setId = 1782, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "cyber_leadership", transliteration = "rosh ji-ar-si",
            original = "רֹאשׁ גִ׳י-אַר-סִי", translation = "head of GRC (governance, risk, compliance)",
            definition = "אִישׁ שֶׁמְּרַכֵּז אֶת כָּל הַנּוֹשְׂאִים שֶׁל מִשְׁטָר, סִיכּוּנִים וְעֵמִידָה בַּתְּקָנִים תַּחַת גַּג אֶחָד.",
            definitionNative = "Человек, сводящий под одну крышу все вопросы порядка, рисков и соответствия стандартам.",
            example = "רֹאשׁ גִ׳י-אַר-סִי קוֹבֵעַ לְאֵיזוֹ תְּקָנִים הַחֶבְרָה תֶּעָמֹד הַשָּׁנָה.",
            exampleNative = "רֹאשׁ גִ׳י-אַר-סִי определяет, каким стандартам фирма будет соответствовать в этом году.",
         fillInBlankExclusions = listOf(178201L, 178202L, 178204L, 178205L)),
        WordEntity(
            id = 178204, setId = 1782, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_leadership", transliteration = "mehandes rashi",
            original = "מְהַנְדֵּס רָאשִׁי", translation = "principal security engineer",
            definition = "אִישׁ טֶכְנִי בָּכִיר בְּיוֹתֵר שֶׁפּוֹתֵר אֶת הַבְּעָיוֹת הַקָּשׁוֹת בְּיוֹתֵר וּמַנְחֶה אֶת הַסְּגִילָה.",
            definitionNative = "Самый старший технарь — решает труднейшие задачи и задаёт техническое направление.",
            example = "מְהַנְדֵּס רָאשִׁי כָּתַב אֶת הַמִּסְמָךְ עַל מַעֲבָר לְהַצְפָּנָה אַחֲרֵי הַקְוַונְטוּם.",
            exampleNative = "מְהַנְדֵּס רָאשִׁי написал документ о переходе на постквантовое шифрование.",
         fillInBlankExclusions = listOf(178201L, 178202L, 178203L, 178205L)),
        WordEntity(
            id = 178205, setId = 1782, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "cyber_leadership", transliteration = "bi-ayso",
            original = "בִּי-אַייסוֹ", translation = "BISO (бизнес-ориентированный CISO)",
            definition = "אִישׁ קֶשֶׁר שֶׁמְּתַרְגֵּם בֵּין צָרְכֵי הָעֵסֶק לְבֵין דְּרִישׁוֹת אַבְטָחָה בְּתוֹךְ דִּיוִויזְיָה מְסֻיֶּמֶת.",
            definitionNative = "Связной — переводит между нуждами бизнеса и требованиями защиты внутри одного дивизиона.",
            example = "בִּי-אַייסוֹ שֶׁל דִּיוִוִיזְיַת הַתַּשְׁלוּמִים יוֹשֵׁב כָּל יוֹם עִם הַסְּמַנְכַּ״ל.",
            exampleNative = "בִּי-אַייסוֹ платёжного дивизиона ежедневно встречается с VP.",
            isFillInBlankSafe = false,
        ),

        // ── cyber_threat_intelligence (5) — разведка угроз ──
        WordEntity(
            id = 178206, setId = 1782, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_threat_intelligence", transliteration = "modi'in iyumim",
            original = "מוֹדִיעִין אִיּוּמִים", translation = "threat intelligence (разведка угроз)",
            definition = "אִסּוּף וְעִבּוּד שֶׁל מֵידָע עַל תּוֹקְפִים וּשְׁיטוֹתֵיהֶם כְּדֵי לְהָכִין אֶת הַהֲגָנָה מֵרֹאשׁ.",
            definitionNative = "Сбор и обработка сведений о нападающих и их методах — чтобы готовить оборону заранее.",
            example = "מוֹדִיעִין אִיּוּמִים זִהָה קְבוּצָה רוּסִית שֶׁמַּתְכּוֹנֶנֶת לִתְקֹף בַּנְקִים יִשְׂרְאֵלִיִּים.",
            exampleNative = "מוֹדִיעִין אִיּוּמִים вычислил российскую группу, готовящую атаку на израильские банки.",
         fillInBlankExclusions = listOf(178207L, 178208L, 178209L, 178210L)),
        WordEntity(
            id = 178207, setId = 1782, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "cyber_threat_intelligence", transliteration = "feed indikatorim",
            original = "פִיד אִינְדִיקָטוֹרִים", translation = "фид индикаторов (IOC feed)",
            definition = "זֶרֶם רָצוּף שֶׁל סִימָנִים חֲשׁוּדִים מִקְּהִילָה בֵּינְלְאֻמִּית — נִכְנָס אוֹטוֹמָטִית לְמַעַרְכוֹת הַסִּינּוּן.",
            definitionNative = "Непрерывный поток подозрительных признаков от мирового сообщества — автоматом льётся в фильтры.",
            example = "פִיד אִינְדִיקָטוֹרִים מִ-מַאנְדִּיאַנְט עוֹדְכַּן כָּל חָמֵשׁ דַּקּוֹת בָּרֶגֶל הַחֲדָשָׁה.",
            exampleNative = "פִיד אִינְדִיקָטוֹרִים от Mandiant обновлялся раз в пять минут на новой стойке.",
         fillInBlankExclusions = listOf(178206L, 178208L, 178209L, 178210L)),
        WordEntity(
            id = 178208, setId = 1782, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_threat_intelligence", transliteration = "tsayad iyumim",
            original = "צַיָּד אִיּוּמִים", translation = "threat hunting (охота за угрозами)",
            definition = "חִפּוּשׂ יָזוּם בְּלוֹגִים וּבְזִכָּרוֹן עַל סִימָנֵי תּוֹקֵף שֶׁאוּלַי כְּבָר נִמְצָא בָּרֶשֶׁת בְּלִי שֶׁהִתְרִיעַ.",
            definitionNative = "Активный поиск в логах и памяти — нет ли уже внутри сети нападавшего, что не подал сигнала.",
            example = "צַיָּד אִיּוּמִים שְׁבוּעִי מָצָא דְּלָתוֹת אֲחוֹרִיּוֹת שֶׁכְּלִי הָאַנְטִיוִוירוּס פִּסְפֵּס.",
            exampleNative = "צַיָּד אִיּוּמִים еженедельный нашёл бэкдоры, которые антивирус пропустил.",
         fillInBlankExclusions = listOf(178206L, 178207L, 178209L, 178210L)),
        WordEntity(
            id = 178209, setId = 1782, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "cyber_threat_intelligence", transliteration = "yikhus tkifa",
            original = "יִיחוּס תְּקִיפָה", translation = "attribution (атрибуция атаки)",
            definition = "הַחְלָטָה מְבֻסֶּסֶת רְאָיוֹת מִי הַקְּבוּצָה שֶׁעוֹמֶדֶת מֵאֲחוֹרֵי הַתְקָפָה — לְפִי כְּלִים, שָׂפָה וְזְמַנֵּי פְּעִילוּת.",
            definitionNative = "Доказательное решение, какая группа стоит за нападением — по инструментам, языку и часам активности.",
            example = "יִיחוּס תְּקִיפָה לְקַבוּצַת לָאזָרוּס לָקַח חֳדָשַׁיִם שֶׁל אֲנָלִיזָה מַעֲמִיקָה.",
            exampleNative = "יִיחוּס תְּקִיפָה группе Lazarus занял два месяца глубокого анализа.",
         fillInBlankExclusions = listOf(178206L, 178207L, 178208L, 178210L)),
        WordEntity(
            id = 178210, setId = 1782, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "cyber_threat_intelligence", transliteration = "miter atak",
            original = "מִיטֶר אַטָאק", translation = "MITRE ATT&CK (фреймворк техник)",
            definition = "טַבְלָה רִשְׁמִית שֶׁמְּמַפָּה אֶת כָּל הַטַּכְטִיקוֹת וְהַטֶּכְנִיקוֹת שֶׁתּוֹקְפִים מִשְׁתַּמְּשִׁים בָּהֶן בָּעוֹלָם.",
            definitionNative = "Официальная таблица — карта всех тактик и техник, которыми пользуются нападающие в мире.",
            example = "מִיטֶר אַטָאק שִׁמֵּשׁ אוֹתָנוּ לְמַפּוֹת אֵיזֶה שְׁלַבִּים בַּהַתְקָפָה כְּבָר זִהִינוּ.",
            exampleNative = "מִיטֶר אַטָאק помог нам разметить, какие стадии атаки мы уже опознали.",
         fillInBlankExclusions = listOf(178206L, 178207L, 178208L, 178209L)),

        // ── cyber_defense_in_depth (5) — многоуровневая оборона и автоматизация ──
        WordEntity(
            id = 178211, setId = 1782, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_defense_in_depth", transliteration = "hagana rav-shikhvatit",
            original = "הֲגָנָה רַב-שִׁכְבָתִית", translation = "defense in depth (многоуровневая защита)",
            definition = "אַסְטְרָטֶגְיָה שֶׁבָּהּ כַּמָּה מַחְסוֹמִים עוֹמְדִים אֶחָד אַחֲרֵי הַשֵּׁנִי, כָּךְ שֶׁפְּרִיצָה אַחַת לֹא מַסְפִּיקָה.",
            definitionNative = "Стратегия — несколько барьеров стоят один за другим, чтобы одного пробоя не хватило.",
            example = "הֲגָנָה רַב-שִׁכְבָתִית שָׁמְרָה עַל הַמָּסָד גַּם אַחֲרֵי שֶׁהַתּוֹקֵף עָקַף אֶת הַ-WAF.",
            exampleNative = "הֲגָנָה רַב-שִׁכְבָתִית уберегла базу даже после того, как нападающий обошёл WAF.",
         fillInBlankExclusions = listOf(178212L, 178213L, 178214L, 178215L)),
        WordEntity(
            id = 178212, setId = 1782, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "cyber_defense_in_depth", transliteration = "soar",
            original = "סוֹאָר", translation = "SOAR (оркестрация и автоматизация)",
            definition = "פְּלַטְפוֹרְמָה שֶׁמְּחַבֶּרֶת בֵּין כְּלֵי אַבְטָחָה וְמַרִיצָה תְּגוּבָה אוֹטוֹמָטִית עַל אֵרוּעִים שִׁגְרָתִיִּים.",
            definitionNative = "Платформа — связывает security-инструменты и катит автоматический ответ на рутинные события.",
            example = "סוֹאָר סָגַר חֶשְׁבּוֹן חָשׁוּד תּוֹךְ שָׁלוֹשׁ שְׁנִיּוֹת בְּלִי שֶׁאֲנָלִיסְט נָגַע.",
            exampleNative = "סוֹאָר закрыл подозрительный аккаунт за три секунды без участия аналитика.",
         fillInBlankExclusions = listOf(178211L, 178213L, 178214L, 178215L)),
        WordEntity(
            id = 178213, setId = 1782, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_defense_in_depth", transliteration = "otomatsiyat hagana",
            original = "אוֹטוֹמַצְיַת הֲגָנָה", translation = "security automation",
            definition = "הַחְלָפַת פְּעֻלּוֹת חוֹזְרוֹת שֶׁל אֲנָלִיסְט בִּסְקְרִיפְטִים שֶׁמַּגִּיבִים מִיָּד לְסִימָנִים מְסֻיָּמִים.",
            definitionNative = "Замена рутинных действий аналитика на скрипты — реагируют немедленно на конкретные сигналы.",
            example = "אוֹטוֹמַצְיַת הֲגָנָה צִמְצְמָה בִּשְׁלִישׁ אֶת זְמַן הַטִּפּוּל בְּפִישִׁינְג.",
            exampleNative = "אוֹטוֹמַצְיַת הֲגָנָה сократила на треть время разбора фишинга.",
         fillInBlankExclusions = listOf(178211L, 178212L, 178214L, 178215L)),
        WordEntity(
            id = 178214, setId = 1782, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_defense_in_depth", transliteration = "ranbuk",
            original = "רַאנְבּוּק", translation = "runbook (пошаговая инструкция)",
            definition = "מַסְמָךְ קָצָר וּמְפֹרָט שֶׁאוֹמֵר לַתּוֹרָן מָה לַעֲשׂוֹת צַעַד אַחַר צַעַד בִּמְקרֶה מֻגְדָּר.",
            definitionNative = "Краткий и подробный документ — говорит дежурному, что делать шаг за шагом в конкретном случае.",
            example = "רַאנְבּוּק חָדָשׁ נִכְתַּב אַחֲרֵי שֶׁהָאֵרוּעַ הָאַחֲרוֹן חָשַׂף פִּעֲרֵי יֶדַע.",
            exampleNative = "Новый רַאנְבּוּק написали после того как последнее ЧП обнажило пробелы в знаниях.",
         fillInBlankExclusions = listOf(178211L, 178212L, 178213L, 178215L)),
        WordEntity(
            id = 178215, setId = 1782, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "cyber_defense_in_depth", transliteration = "pleybuk kakhol",
            original = "פְּלֵייבּוּק כָּחֹל", translation = "blue-team playbook (защитный сценарий)",
            definition = "אֹסֶף תַּסְרִיטֵי תְּגוּבָה לְצֶוֶות הַהֲגָנָה — אֵיךְ פּוֹעֲלִים מוּל סוּגֵי תְּקִיפוֹת שׁוֹנוֹת.",
            definitionNative = "Сборник реакций для защитной команды — как действовать при разных видах нападений.",
            example = "פְּלֵייבּוּק כָּחֹל לְאֵרוּעַ כֹּפֶר נִבְחַן בְּתִרְגוּל סִימוּלָצְיָה רֻבְעוֹנִי.",
            exampleNative = "פְּלֵייבּוּק כָּחֹל под событие шифровальщика проверили на квартальном киберучении.",
         fillInBlankExclusions = listOf(178211L, 178212L, 178213L, 178214L)),

        // ── cyber_governance_advanced (5) — governance высокого уровня ──
        WordEntity(
            id = 178216, setId = 1782, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_governance_advanced", transliteration = "mediniyut avtakha",
            original = "מְדִינִיּוּת אַבְטָחָה", translation = "security policy (политика безопасности)",
            definition = "מַסְמָךְ רִשְׁמִי שֶׁקּוֹבֵעַ אֵיזוֹ הִתְנַהֲגוּת מֻתֶּרֶת לְעוֹבְדִים מוּל מֵידָע וּמַעֲרָכוֹת בָּעֵסֶק.",
            definitionNative = "Официальный документ — определяет, какое поведение разрешено сотрудникам с данными и системами.",
            example = "מְדִינִיּוּת אַבְטָחָה חֲדָשָׁה אָסְרָה לַחֲבֵר הַתְקָנִים אִישִׁיִּים לָרֶשֶׁת הַפְּנִימִית.",
            exampleNative = "Новая מְדִינִיּוּת אַבְטָחָה запретила цеплять личные устройства во внутреннюю сеть.",
         fillInBlankExclusions = listOf(178217L, 178218L, 178219L, 178220L)),
        WordEntity(
            id = 178217, setId = 1782, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_governance_advanced", transliteration = "hadrakhat moda'ut",
            original = "הַדְרָכַת מוּדָעוּת", translation = "тренинг по информбезопасности (awareness training)",
            definition = "סִדְרַת שִׁעוּרִים לְעוֹבְדִים שֶׁמְלַמֶּדֶת אוֹתָם לְזַהוֹת תַּרְמִיּוֹת וְלֹא לִמְסוֹר פְּרָטִים לַזָּרִים.",
            definitionNative = "Серия уроков для сотрудников — учит распознавать обманы и не выдавать сведения чужим.",
            example = "הַדְרָכַת מוּדָעוּת שְׁנָתִית הוֹרִידָה אֶת אָחוּז הַלְּחִיצוֹת עַל קִישּׁוּרִים מְזֻיָּפִים.",
            exampleNative = "Ежегодный הַדְרָכַת מוּדָעוּת снизил процент кликов по поддельным ссылкам.",
         fillInBlankExclusions = listOf(178216L, 178218L, 178219L, 178220L)),
        WordEntity(
            id = 178218, setId = 1782, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_governance_advanced", transliteration = "matritzat sikunim",
            original = "מַטְרִיצַת סִיכּוּנִים", translation = "risk register (реестр рисков)",
            definition = "טַבְלָה מְרֻכֶּזֶת שֶׁבָּהּ כָּל סִכּוּן יָדוּעַ נִרְשָׁם עִם הִסְתַּבְּרוּת, הַשְׁלָכָה וְאַחַרָאִי לְטִפּוּל.",
            definitionNative = "Сводная таблица — каждый известный риск записан с вероятностью, последствием и ответственным.",
            example = "מַטְרִיצַת סִיכּוּנִים נִסְקְרָה בָּמוֹעֲצָה כָּל רֹבַע מוּל סִ׳י-אַייסוֹ.",
            exampleNative = "מַטְרִיצַת סִיכּוּנִים пересматривали в совете каждый квартал с CISO.",
         fillInBlankExclusions = listOf(178216L, 178217L, 178219L, 178220L)),
        WordEntity(
            id = 178219, setId = 1782, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "cyber_governance_advanced", transliteration = "ayso esrim ve-sheva elef seventeen",
            original = "אַייסוֹ 27017", translation = "ISO 27017 (cloud-стандарт)",
            definition = "תֶּקֶן בֵּינְלְאֻמִּי שֶׁמַּרְחִיב אֶת כְּלָלֵי אַבְטַחַת הַמֵּידָע בִּסְפֵצִיפִי לִסְבִיבַת עָנָן וְשֵׁרוּתִים מְשֻׁתָּפִים.",
            definitionNative = "Международный стандарт — расширяет правила защиты данных специально для облачной среды.",
            example = "אַייסוֹ 27017 הִתְקַבֵּל אַחֲרֵי הַעֲבָרַת רֹב הַשֵּׁרוּתִים לִסְבִיבָה עֲנָנִית.",
            exampleNative = "אַייסוֹ 27017 получили после переезда большинства сервисов в облако.",
         fillInBlankExclusions = listOf(178216L, 178217L, 178218L, 178220L)),
        WordEntity(
            id = 178220, setId = 1782, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_governance_advanced", transliteration = "mishketet nist",
            original = "מִשְׁקֶּתֶת נִיסְט", translation = "NIST cybersecurity framework",
            definition = "מַסְגֶּרֶת אָמֵרִיקָאִית עִם חָמֵשׁ פֻּנְקְצִיּוֹת — לְזַהוֹת, לְהָגֵן, לְגַלּוֹת, לְהָגִיב וּלְהִתְאוֹשֵׁשׁ.",
            definitionNative = "Американская рамка с пятью функциями — опознать, защитить, обнаружить, ответить и восстановиться.",
            example = "הִתְאֵמְנוּ אֶת תָּכְנִית הָעֲבוֹדָה לְמִשְׁקֶּתֶת נִיסְט.",
            exampleNative = "Подогнали рабочий план под מִשְׁקֶּתֶת נִיסְט.",
         fillInBlankExclusions = listOf(178216L, 178217L, 178218L, 178219L)),

        // ── cyber_business_continuity (5) — непрерывность и страхование ──
        WordEntity(
            id = 178221, setId = 1782, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_business_continuity", transliteration = "tokhnit hemshekhiyut",
            original = "תָּכְנִית הֶמְשֵׁכִיּוּת", translation = "business continuity plan (BCP)",
            definition = "מִסְמָךְ שֶׁמְפָרֵט אֵיךְ הַחֶבְרָה מַמְשִׁיכָה לִפְעֹל בִּזְמַן מַשְׁבֵּר חָמוּר אוֹ נְפִילַת מַעֲרָכוֹת.",
            definitionNative = "Документ — расписывает, как фирма продолжает работать во время серьёзного кризиса или падения систем.",
            example = "תָּכְנִית הֶמְשֵׁכִיּוּת אִפְשְׁרָה לְלָקוֹחוֹת לְשַׁלֵּם גַּם בִּזְמַן הַתְקָפַת הַכֹּפֶר.",
            exampleNative = "תָּכְנִית הֶמְשֵׁכִיּוּת позволила клиентам платить даже во время атаки шифровальщика.",
         fillInBlankExclusions = listOf(178222L, 178223L, 178224L, 178225L)),
        WordEntity(
            id = 178222, setId = 1782, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "cyber_business_continuity", transliteration = "shikum me-ason",
            original = "שִׁיקּוּם מֵאָסוֹן", translation = "disaster recovery (восстановление после катастрофы)",
            definition = "אֹסֶף שֶׁל פְּרוֹצֶדוּרוֹת טֶכְנִיּוֹת לְהַחְזָרַת שְׁרָתִים וּמָסַדִּים אַחֲרֵי כִּשָּׁלוֹן רְחָב.",
            definitionNative = "Сборник технических процедур для возврата серверов и баз после крупного сбоя.",
            example = "שִׁיקּוּם מֵאָסוֹן נִמְשַׁךְ שָׁעָה וָחֵצִי בָּמַעֲבָר לְמֶרְכַּז הַגִּבּוּי.",
            exampleNative = "שִׁיקּוּם מֵאָסוֹן занял полтора часа при переключении на резервный центр.",
         fillInBlankExclusions = listOf(178221L, 178223L, 178224L, 178225L)),
        WordEntity(
            id = 178223, setId = 1782, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "cyber_business_continuity", transliteration = "ar-pi-o",
            original = "אַר-פִּי-אוֹ", translation = "RPO (recovery point objective)",
            definition = "כַּמּוּת הַמֵּידָע הַמַּקְסִימָלִית שֶׁמּוּתָר לְהַפְסִיד בִּזְמַן תַּקָּלָה — נִמְדֶּדֶת בְּדַקּוֹת אוֹ שָׁעוֹת.",
            definitionNative = "Максимум данных, которые позволено потерять при сбое — измеряют в минутах или часах.",
            example = "אַר-פִּי-אוֹ שֶׁל חָמֵשׁ דַּקּוֹת חִיֵּיב גִּבּוּי רְצוּף שֶׁל הַמָּסַד.",
            exampleNative = "אַר-פִּי-אוֹ в пять минут потребовал непрерывного бэкапа базы.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178224, setId = 1782, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "cyber_business_continuity", transliteration = "ar-ti-o",
            original = "אַר-טִי-אוֹ", translation = "RTO (recovery time objective)",
            definition = "מֶשֶׁךְ הַזְּמַן הַמַּקְסִימָלִי שֶׁמַּעֲרֶכֶת יְכוֹלָה לִהְיוֹת מֻשְׁבֶּתֶת לִפְנֵי שֶׁהָעֵסֶק נִפְגָּע מַמָּשׁ.",
            definitionNative = "Предельное время простоя системы — пока бизнес не пострадает по-настоящему.",
            example = "אַר-טִי-אוֹ שֶׁל אַרְבַּע שָׁעוֹת לְמַעֲרֶכֶת הַתַּשְׁלוּמִים הָיָה תָּקִיף מִדַּי.",
            exampleNative = "אַר-טִי-אוֹ в четыре часа для платёжной системы оказался слишком жёстким.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 178225, setId = 1782, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_business_continuity", transliteration = "bituakh sayber",
            original = "בִּיטוּחַ סַייבֶּר", translation = "cyber insurance (киберстрахование)",
            definition = "פּוֹלִיסָה שֶׁמְכַסָּה הוֹצָאוֹת מִשְׁפָּטִיּוֹת וּכְסָפִים שֶׁל פִּיצּוּי לָקוֹחוֹת אַחֲרֵי דְּלִיפַת מֵידָע.",
            definitionNative = "Полис — покрывает судебные расходы и компенсации клиентам после утечки данных.",
            example = "בִּיטוּחַ סַייבֶּר שִׁלֵּם אֶת רֹב הַקְּנָסוֹת אַחֲרֵי דְּלִיפַת מַסַד הַלְּקוֹחוֹת.",
            exampleNative = "בִּיטוּחַ סַייבֶּר оплатил большую часть штрафов после утечки клиентской базы.",
         fillInBlankExclusions = listOf(178221L, 178222L, 178223L, 178224L)),
    )
}
