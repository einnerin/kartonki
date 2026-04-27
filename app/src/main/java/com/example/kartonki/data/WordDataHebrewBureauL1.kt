package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary: Бюрократия и документы, level 1 (single set, 25 words).
 *
 * Set 1807 — базовая лексика для бытовой бюрократии: документы, кабинет,
 * очередь, действия с бумагами, ответ инстанции. 13 COMMON + 12 UNCOMMON.
 *
 * Подтемы:
 *   bureau_basic_docs       — документы и фотокопии
 *   bureau_basic_office     — учреждение и стойка приёма
 *   bureau_basic_queue      — очередь, номер, запись
 *   bureau_basic_actions    — заполнить, подписать, подать
 *   bureau_basic_response   — ответ, отказ, жалоба, квитанция
 *
 * Не пересекается со словами в he-ru сете «Право» (1703): מִסְמָךְ, חֲתִימָה,
 * טֹפֶס, אִישּׁוּר, פָּקִיד остаются за Law L1; здесь — параллельный пласт
 * бытовой канцелярии (הוֹדָעָה, מְעַטָּפָה, מַזְכִּירָה, סֵרוּב и т.п.).
 *
 * Все слова помечены isFillInBlankSafe=false: ивритская морфология
 * (биньян, огласовки, артикли, смихут) часто ломает подстрочную замену
 * в FILL_IN_BLANK, пока не реализована Hebrew-aware логика.
 */
object WordDataHebrewBureauL1 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1807, languagePair = "he-ru", orderIndex = 1807,
            name = "Бюрократия и документы",
            description = "Базовая лексика: документ, подпись, фото, копия, форма",
            topic = "Бюрократия и документы", level = 1,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Set 1807 — Бюрократия и документы: основы (level 1) ───────────

        // ── bureau_basic_docs (5) ─────────────────────────────────────────
        WordEntity(
            id = 180701, setId = 1807, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bureau_basic_docs", transliteration = "hodаа",
            original = "הוֹדָעָה", translation = "уведомление",
            definition = "מִכְתָּב קָצָר מִמּוֹסָד שֶׁמּוֹסֵר לָאָדָם מֵידָע אוֹ הַחְלָטָה.",
            definitionNative = "Короткая бумага от учреждения, сообщающая человеку решение или сведения.",
            example = "קִבַּלְתִּי הוֹדָעָה עַל פְּגִישָׁה בַּמִּשְׂרָד.",
            exampleNative = "Я получил הוֹדָעָה о встрече в ведомстве.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180702, setId = 1807, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "bureau_basic_docs", transliteration = "тмуна",
            original = "תְּמוּנָה", translation = "фотография (для документа)",
            definition = "צִיּוּר אוֹ דְּמוּת שֶׁל פָּנִים שֶׁמַּדְבִּיקִים עַל טֹפֶס לְזִהוּי.",
            definitionNative = "Изображение лица, которое наклеивают на бланк для опознания владельца.",
            example = "צָרִיךְ תְּמוּנָה חֲדָשָׁה לְבַקָּשַׁת הַדַּרְכּוֹן.",
            exampleNative = "Нужна свежая תְּמוּנָה для заявления на паспорт.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180703, setId = 1807, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "bureau_basic_docs", transliteration = "цилум",
            original = "צִילּוּם", translation = "фотокопия",
            definition = "הֶעְתֵּק שֶׁל דַּף מְקוֹרִי שֶׁמּוּכָן בְּמַכְשִׁיר וְנִרְאֶה בְּדִיּוּק כַּמָּקוֹר.",
            definitionNative = "Точная копия оригинального листа, сделанная аппаратом и выглядящая как оригинал.",
            example = "צָרְפוּ צִילּוּם בָּהִיר שֶׁל הַדַּרְכּוֹן.",
            exampleNative = "Приложите чёткий צִילּוּם паспорта.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180704, setId = 1807, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bureau_basic_docs", transliteration = "меатафа",
            original = "מְעַטָּפָה", translation = "конверт",
            definition = "כִּיס נְיָר סָגוּר שֶׁבּוֹ שׁוֹלְחִים מִכְתָּב אוֹ מִסְמָכִים בַּדֹּאַר.",
            definitionNative = "Бумажный карман с клапаном, в котором отправляют письмо или бумаги по почте.",
            example = "שַׂמְתִּי אֶת הַטֹּפֶס בְּתוֹךְ הַמְּעַטָּפָה.",
            exampleNative = "Я положил бланк внутрь מְעַטָּפָה.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180705, setId = 1807, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bureau_basic_docs", transliteration = "сэиф",
            original = "סְעִיף", translation = "пункт (документа) / параграф",
            definition = "חֵלֶק קָטָן וּמְמֻסְפָּר בְּתוֹךְ מִסְמָךְ אוֹ חוֹזֶה רִשְׁמִי.",
            definitionNative = "Маленькая нумерованная часть внутри официального документа или договора.",
            example = "צָרִיךְ לְמַלֵּא רַק אֶת הַסְּעִיף הָרִאשׁוֹן.",
            exampleNative = "Нужно заполнить только первый סְעִיף.",
            isFillInBlankSafe = false,
        ),

        // ── bureau_basic_office (5) ───────────────────────────────────────
        WordEntity(
            id = 180706, setId = 1807, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "bureau_basic_office", transliteration = "мисрад",
            original = "מִשְׂרָד", translation = "ведомство / контора",
            definition = "מָקוֹם רִשְׁמִי שֶׁבּוֹ פְּקִידִים מְקַבְּלִים תּוֹשָׁבִים וּמְטַפְּלִים בִּפְנִיּוֹת.",
            definitionNative = "Государственное помещение, где служащие принимают граждан и оформляют обращения.",
            example = "הַמִּשְׂרָד פָּתוּחַ רַק עַד שְׁתֵּים עֶשְׂרֵה.",
            exampleNative = "מִשְׂרָד открыт только до двенадцати.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180707, setId = 1807, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bureau_basic_office", transliteration = "далпек",
            original = "דַּלְפֵּק", translation = "стойка приёма",
            definition = "שֻׁלְחָן גָּבוֹהַּ בְּכְנִיסַת הַמִּשְׂרָד שֶׁאֶצְלוֹ עוֹמֵד הַפָּקִיד.",
            definitionNative = "Высокий стол у входа в учреждение, за которым работает служащий.",
            example = "נִגַּשְׁתִּי לַדַּלְפֵּק לְמַסֹּר אֶת הַמְּעַטָּפָה.",
            exampleNative = "Я подошёл к דַּלְפֵּק, чтобы передать конверт.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180708, setId = 1807, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bureau_basic_office", transliteration = "шелет",
            original = "שֶׁלֶט", translation = "табличка (с указателем)",
            definition = "לוּחַ קָטָן עִם מִלִּים אוֹ חֵץ שֶׁמַּרְאֶה לְאָן לָלֶכֶת בַּבִּנְיָן.",
            definitionNative = "Маленькая дощечка со словами или стрелкой, указывающая путь внутри здания.",
            example = "הַשֶּׁלֶט עַל הַדֶּלֶת מַרְאֶה אֶת מִסְפַּר הַחֶדֶר.",
            exampleNative = "שֶׁלֶט на двери показывает номер кабинета.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180709, setId = 1807, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bureau_basic_office", transliteration = "кома",
            original = "קוֹמָה", translation = "этаж",
            definition = "אַחַת הַשִּׁכָבוֹת שֶׁל בִּנְיָן שֶׁמַּגִּיעִים אֵלֶיהָ בְּמַעֲלִית אוֹ בְּמַדְרֵגוֹת.",
            definitionNative = "Один из ярусов здания, до которого добираются на лифте или по лестнице.",
            example = "מִשְׂרַד הַפְּנִים נִמְצָא בַּקּוֹמָה הַשְּׁלִישִׁית.",
            exampleNative = "МВД находится на третьей קוֹמָה.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180710, setId = 1807, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bureau_basic_office", transliteration = "мазкира",
            original = "מַזְכִּירָה", translation = "секретарь (женщина)",
            definition = "הָאִשָּׁה שֶׁקּוֹבַעַת תּוֹרִים וְשׁוֹמֶרֶת אֶת לוּחַ הַזְּמַנִּים בַּמִּשְׂרָד.",
            definitionNative = "Женщина, которая ведёт расписание и записывает посетителей в учреждении.",
            example = "הַמַּזְכִּירָה שָׁלְחָה לִי הוֹדָעָה בַּמַּיְל.",
            exampleNative = "מַזְכִּירָה прислала мне уведомление по электронной почте.",
            isFillInBlankSafe = false,
        ),

        // ── bureau_basic_queue (5) ────────────────────────────────────────
        WordEntity(
            id = 180711, setId = 1807, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "bureau_basic_queue", transliteration = "тор",
            original = "תּוֹר", translation = "очередь (живая)",
            definition = "שׁוּרָה שֶׁל אֲנָשִׁים שֶׁמְּחַכִּים אֶחָד אַחֲרֵי הַשֵּׁנִי לְקַבָּלַת שֵׁרוּת.",
            definitionNative = "Цепочка людей, которые ждут друг за другом обслуживания у служащего.",
            example = "עָמַדְתִּי בַּתּוֹר שָׁעָה שְׁלֵמָה.",
            exampleNative = "Я простоял в תּוֹר целый час.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180712, setId = 1807, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "bureau_basic_queue", transliteration = "миспар",
            original = "מִסְפָּר", translation = "номер (в очереди)",
            definition = "הַסִּפְרָה שֶׁמַּדְפִּיס מְכוֹנָה בַּכְּנִיסָה כְּדֵי לִקְבֹּעַ אֶת תּוֹרְךָ.",
            definitionNative = "Цифра, которую печатает аппарат у входа, чтобы определить твою очерёдность.",
            example = "לָקַחְתִּי מִסְפָּר וְחִכִּיתִי שֶׁיִּקְרְאוּ לִי.",
            exampleNative = "Я взял מִסְפָּר и ждал, пока меня вызовут.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180713, setId = 1807, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bureau_basic_queue", transliteration = "hазмана",
            original = "הַזְמָנָה", translation = "запись (на приём)",
            definition = "תַּאֲרִיךְ וּשְׁעָה שֶׁקּוֹבְעִים מֵרֹאשׁ כְּדֵי לְהִתְקַבֵּל אֵצֶל פָּקִיד.",
            definitionNative = "Дата и время, заранее назначенные для приёма у государственного служащего.",
            example = "יֵשׁ לִי הַזְמָנָה לְיוֹם רִאשׁוֹן בַּבֹּקֶר.",
            exampleNative = "У меня הַזְמָנָה на воскресенье утром.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180714, setId = 1807, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bureau_basic_queue", transliteration = "hамтана",
            original = "הַמְתָּנָה", translation = "ожидание",
            definition = "הַזְּמַן שֶׁבּוֹ יוֹשְׁבִים בַּשֶּׁקֶט עַד שֶׁפָּקִיד יִקְרָא לְשֵׁרוּת.",
            definitionNative = "Время, которое проводят сидя в тишине до вызова к служащему.",
            example = "הַהַמְתָּנָה לַתּוֹר הָיְתָה אֲרֻכָּה מְאֹד.",
            exampleNative = "הַמְתָּנָה в очереди была очень долгой.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180715, setId = 1807, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bureau_basic_queue", transliteration = "ришум",
            original = "רִשּׁוּם", translation = "регистрация",
            definition = "הַכְנָסַת שֵׁם וּפְרָטִים שֶׁל אָדָם לְרְשִׁימָה רִשְׁמִית בְּמַחְשֵׁב הַמּוֹסָד.",
            definitionNative = "Внесение имени и данных человека в официальный список в системе ведомства.",
            example = "הָרִשּׁוּם לְקֻרְסֵי עִבְרִית נִסְגָּר מָחָר.",
            exampleNative = "רִשּׁוּם на курсы иврита закрывается завтра.",
            isFillInBlankSafe = false,
        ),

        // ── bureau_basic_actions (5) ──────────────────────────────────────
        WordEntity(
            id = 180716, setId = 1807, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "bureau_basic_actions", transliteration = "лемале",
            original = "לְמַלֵּא", translation = "заполнять (бланк)",
            definition = "לִכְתֹּב פְּרָטִים בְּתוֹךְ הַמִּשְׁבְּצוֹת הָרֵיקוֹת שֶׁל הַטֹּפֶס.",
            definitionNative = "Вписывать данные в пустые графы готового бланка от руки или на компьютере.",
            example = "צָרִיךְ לְמַלֵּא אֶת כָּל הַשּׁוּרוֹת בִּכְתָב בָּרוּר.",
            exampleNative = "Нужно לְמַלֵּא все строки разборчивым почерком.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180717, setId = 1807, languagePair = "he-ru", rarity = "COMMON",
            pos = "verb", semanticGroup = "bureau_basic_actions", transliteration = "лахтом",
            original = "לַחְתֹּם", translation = "подписывать",
            definition = "לִכְתֹּב אֶת הַשֵּׁם שֶׁלָּךְ בִּכְתָב יָד בְּסוֹף הַמִּסְמָךְ לְאִשּׁוּר.",
            definitionNative = "Писать своё имя от руки в конце бумаги, чтобы официально её утвердить.",
            example = "אַל תִּשְׁכַּח לַחְתֹּם בְּסוֹף הַטֹּפֶס.",
            exampleNative = "Не забудь לַחְתֹּם в конце бланка.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180718, setId = 1807, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "bureau_basic_actions", transliteration = "леhагиш",
            original = "לְהַגִּישׁ", translation = "подавать (заявление)",
            definition = "לְהַעֲבִיר טֹפֶס אוֹ נְיָרוֹת לַפָּקִיד שֶׁיְּטַפֵּל בָּהֶם.",
            definitionNative = "Передать готовый бланк или бумаги служащему, который должен ими заняться.",
            example = "לְהַגִּישׁ אֶת הַבַּקָּשָׁה צָרִיךְ עַד יוֹם חֲמִישִׁי.",
            exampleNative = "לְהַגִּישׁ заявление надо до четверга.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180719, setId = 1807, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "bureau_basic_actions", transliteration = "ликбоа",
            original = "לִקְבֹּעַ", translation = "назначать (встречу)",
            definition = "לְהַחְלִיט מֵרֹאשׁ עַל תַּאֲרִיךְ וּשְׁעָה שֶׁל פְּגִישָׁה אֵצֶל הַפָּקִיד.",
            definitionNative = "Заранее условиться о дате и часе встречи у государственного служащего.",
            example = "צְרִיכִים לִקְבֹּעַ פְּגִישָׁה דֶּרֶךְ הָאֲתָר.",
            exampleNative = "Нужно לִקְבֹּעַ встречу через сайт.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180720, setId = 1807, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "bureau_basic_actions", transliteration = "леварер",
            original = "לְבָרֵר", translation = "выяснять (детали)",
            definition = "לִשְׁאֹל וּלְקַבֵּל מֵידָע מְדֻיָּק עַל מַצַּב הַתִּיק אוֹ שֵׁרוּת.",
            definitionNative = "Расспросить и получить точные сведения о состоянии дела или об услуге.",
            example = "אֲנִי רוֹצֶה לְבָרֵר מָה קוֹרֶה עִם הַבַּקָּשָׁה.",
            exampleNative = "Я хочу לְבָרֵר, что происходит с заявлением.",
            isFillInBlankSafe = false,
        ),

        // ── bureau_basic_response (5) ─────────────────────────────────────
        WordEntity(
            id = 180721, setId = 1807, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "bureau_basic_response", transliteration = "тшува",
            original = "תְּשׁוּבָה", translation = "ответ (от инстанции)",
            definition = "מַעֲנֶה רִשְׁמִי מֵהַמּוֹסָד עַל בַּקָּשָׁה אוֹ פְּנִיָּה שֶׁהוּגְּשָׁה.",
            definitionNative = "Официальное решение учреждения по поданному обращению или заявлению.",
            example = "חִכִּינוּ חֹדֶשׁ שָׁלֵם לִתְשׁוּבָה מֵהַמִּשְׂרָד.",
            exampleNative = "Мы ждали целый месяц תְּשׁוּבָה из ведомства.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180722, setId = 1807, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "bureau_basic_response", transliteration = "михтав",
            original = "מִכְתָּב", translation = "письмо (официальное)",
            definition = "דַּף כָּתוּב שֶׁשּׁוֹלֵחַ מוֹסָד אוֹ אָדָם בַּדֹּאַר עַל עִנְיָן רִשְׁמִי.",
            definitionNative = "Написанный лист, который шлют по почте от учреждения по официальному вопросу.",
            example = "הַמִּכְתָּב הִגִּיעַ עִם חוֹתֶמֶת שֶׁל הַבַּנְק.",
            exampleNative = "מִכְתָּב пришло с печатью банка.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180723, setId = 1807, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bureau_basic_response", transliteration = "сэрув",
            original = "סֵרוּב", translation = "отказ (официальный)",
            definition = "הוֹדָעַת מוֹסָד שֶׁלֹּא אִשֵּׁר בַּקָּשָׁה אוֹ פְּנִיָּה שֶׁל הַתּוֹשָׁב.",
            definitionNative = "Сообщение учреждения о том, что просьба или заявление гражданина не одобрены.",
            example = "קִבַּלְנוּ סֵרוּב לְבַקָּשַׁת הָאַשְׁרָה.",
            exampleNative = "Мы получили סֵרוּב в просьбе о визе.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180724, setId = 1807, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "bureau_basic_response", transliteration = "тлуна",
            original = "תְּלוּנָה", translation = "жалоба",
            definition = "פְּנִיָּה כְּתוּבָה לְמוֹסָד עַל שֵׁרוּת רַע אוֹ עַל הַחְלָטָה לֹא הוֹגֶנֶת.",
            definitionNative = "Письменное обращение в инстанцию о плохом обслуживании или несправедливом решении.",
            example = "הִגַּשְׁתִּי תְּלוּנָה עַל הַפָּקִיד הַגַּס.",
            exampleNative = "Я подал תְּלוּנָה на грубого служащего.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180725, setId = 1807, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "bureau_basic_response", transliteration = "кабала",
            original = "קַבָּלָה", translation = "квитанция (об оплате)",
            definition = "פֶּתֶק רִשְׁמִי שֶׁמְּאַשֵּׁר שֶׁשִּׁלַּמְתָּ סְכוּם כֶּסֶף לַמּוֹסָד.",
            definitionNative = "Официальная бумажка, удостоверяющая, что вы внесли оплату в учреждение.",
            example = "שִׁמְרוּ אֶת הַקַּבָּלָה עַד סוֹף הַשָּׁנָה.",
            exampleNative = "Сохраните קַבָּלָה до конца года.",
            isFillInBlankSafe = false,
        ),
    )
}
