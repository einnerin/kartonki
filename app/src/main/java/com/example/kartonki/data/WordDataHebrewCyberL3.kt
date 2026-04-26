package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Кибербезопасность", L3 «Углублённый» (RARE+EPIC).
 *
 * Set 1767: «Кибербезопасность» — углублённый L3:
 *           Угрозы, аутентификация, сетевая защита, web-уязвимости, основы шифрования.
 *
 * Тема ориентирована на разработчика/админа, который изучает иврит для работы
 * в израильской ИТ-индустрии и хочет понимать речь security-инженеров,
 * аудиторов и SOC-аналитиков. Лексика отражает реальные термины: множество
 * английских заимствований (פִישִׁינְג, פַייאֵרוֹאוּל, אֶס-קְיוּ-אֶל אִינְגֵ'קְשֶׁן,
 * סֶרְטִיפִיקַט) — так реально говорят в индустрии.
 *
 * Распределение редкостей: 13 RARE + 12 EPIC.
 *
 * SemanticGroups (5 × 5):
 *   cyber_threats   — угрозы: malware, ransomware, phishing, social engineering, zero-day
 *   cyber_auth      — аутентификация: MFA, password manager, SSO, biometric, public key
 *   cyber_network   — сеть: firewall, VPN, IDS, IPS, DMZ
 *   cyber_app       — web/app: SQL injection, XSS, CSRF, OWASP top 10, secure coding
 *   cyber_basics    — основы: asymmetric encryption, hashing, certificate, TLS, digital signature
 *
 * Word IDs: setId × 100 + position (176701..176725).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 *
 * Заметки про возможные пересечения с соседями:
 * - אִיּוּמֵי סַייבֶּר (киберугрозы) уже в HightechL4 — здесь не дублируется,
 *   используются конкретные виды угроз вместо обобщающего термина.
 * - הַצְפָּנָה (RARE) и הַצְפָּנָה סִימֶטְרִית (EPIC, set 1099 «Технологии»)
 *   уже заняты в других темах — здесь использован термин הִצָפָּנָה לֹא-סִימֶטְרִית
 *   (asymmetric encryption) как иной криптотермин, не пересекается с symmetric.
 */
object WordDataHebrewCyberL3 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1767, languagePair = "he-ru", orderIndex = 1767,
            name = "Кибербезопасность",
            description = "Основы: угрозы, аутентификация, сеть, web-уязвимости, шифрование",
            topic = "Кибербезопасность", level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1767 — Кибербезопасность: углублённый (L3, RARE+EPIC)
        // 5 групп × 5 слов: threats, auth, network, app, basics
        // ══════════════════════════════════════════════════════════════════════

        // ── cyber_threats (5) — типы атак и вредоносного ПО ──
        WordEntity(
            id = 176701, setId = 1767, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_threats", transliteration = "malveyer",
            original = "מַאלְוֵוייר", translation = "вредоносная программа",
            definition = "תּוֹכְנָה זְדוֹנִית שֶׁמַּזִּיקָה לַמַּחְשֵׁב, גּוֹנֶבֶת מֵידָע אוֹ פּוֹתַחַת דֶּלֶת אֲחוֹרִית.",
            definitionNative = "Зловредная программа — портит компьютер, ворует данные или открывает чёрный ход.",
            example = "הָאַנְטִיוִירוּס זִהָה מַאלְוֵוייר חָדָשׁ בַּקֹּבֶץ שֶׁהוֹרַדְתִּי אֶתְמוֹל.",
            exampleNative = "Антивирус опознал новый מַאלְוֵוייר в файле, который я скачал вчера.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176702, setId = 1767, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_threats", transliteration = "ransomveyer",
            original = "רַאנְסוֹמְוֵוייר", translation = "программа-вымогатель",
            definition = "תּוֹכְנָה שֶׁנּוֹעֶלֶת קְבָצִים שֶׁל הַקָּרְבָּן וְדוֹרֶשֶׁת תַּשְׁלוּם תְּמוּרַת הַשַּׁחְרוּר.",
            definitionNative = "Программа, блокирующая файлы жертвы и требующая выкуп за разблокировку.",
            example = "רַאנְסוֹמְוֵוייר הִשְׁבִּית אֶת בֵּית הַחוֹלִים לְשִׁבְעָה יָמִים שְׁלֵמִים.",
            exampleNative = "רַאנְסוֹמְוֵוייר парализовал больницу на целых семь дней.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176703, setId = 1767, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_threats", transliteration = "fishing",
            original = "פִישִׁינְג", translation = "фишинг",
            definition = "מִכְתָּב אוֹ אַתָר מְזֻיָּף שֶׁמַּטְעֶה אֶת הַמִּשְׁתַּמֵּשׁ לִמְסוֹר פְּרָטִים אִישִׁיִּים.",
            definitionNative = "Поддельное письмо или сайт, обманом заставляющий пользователя выдать личные данные.",
            example = "הוּא נָפַל בְּפִישִׁינְג שֶׁנִּרְאָה כְּמוֹ הוֹדָעָה אֲמִיתִּית מֵהַבַּנְק.",
            exampleNative = "Он попался на פִישִׁינְג, выглядевший как настоящее сообщение от банка.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176704, setId = 1767, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_threats", transliteration = "handasa khevratit",
            original = "הַנְדָּסָה חֶבְרָתִית", translation = "социальная инженерия",
            definition = "מְנִיפּוּלַצְיָה שֶׁל אֲנָשִׁים בִּכְדֵי לְהוֹצִיא מֵהֶם מֵידָע סוֹדִי בְּלִי לִפְרֹץ מַעֲרֶכֶת.",
            definitionNative = "Манипулирование людьми — выманить секрет, не взламывая систему технически.",
            example = "הַתּוֹקֵף הִשְׁתַּמֵּשׁ בְּהַנְדָּסָה חֶבְרָתִית כְּדֵי לְהִכָּנֵס לַבִּנְיָן בְּלִי תָּג.",
            exampleNative = "Атакующий применил הַנְדָּסָה חֶבְרָתִית, чтобы зайти в здание без пропуска.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176705, setId = 1767, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_threats", transliteration = "pgi'ut yom-efes",
            original = "פְּגִיעוּת יוֹם-אֶפֶס", translation = "уязвимость нулевого дня",
            definition = "חוֹר אַבְטָחָה שֶׁעֲדַיִן לֹא יָדוּעַ לַיַּצְרָן וְאֵין עָלָיו טְלַאי לְהָתְקִין.",
            definitionNative = "Дыра в защите, о которой ещё не знает производитель — и заплатки на неё нет.",
            example = "פְּגִיעוּת יוֹם-אֶפֶס בַּדַּפְדְּפָן נִמְכְּרָה לְמִסְחָר חַסְמָנִי בְּמִילְיוֹן דּוֹלָר.",
            exampleNative = "פְּגִיעוּת יוֹם-אֶפֶס в браузере была продана теневому покупателю за миллион долларов.",
            isFillInBlankSafe = false,
        ),

        // ── cyber_auth (5) — аутентификация и удостоверение ──
        WordEntity(
            id = 176706, setId = 1767, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_auth", transliteration = "em-ef-ey",
            original = "אֵם-אֵף-אֵיי", translation = "MFA (многофакторная аутентификация)",
            definition = "שִׁיטָה שֶׁדּוֹרֶשֶׁת לְפָחוֹת שְׁנֵי אִישּׁוּרִים שׁוֹנִים — לְמָשָׁל סִיסְמָה וְקוֹד מֵהַטֶּלֶפוֹן.",
            definitionNative = "Метод требует минимум двух подтверждений — например, пароль и код из телефона.",
            example = "הַחֶבְרָה חִיֵּיבָה אֶת כָּל הָעוֹבְדִים לְהַפְעִיל אֵם-אֵף-אֵיי עַל הַחֶשְׁבּוֹן.",
            exampleNative = "Фирма обязала всех сотрудников включить אֵם-אֵף-אֵיי на аккаунте.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176707, setId = 1767, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_auth", transliteration = "menahel sismaot",
            original = "מְנַהֵל סִיסְמָאוֹת", translation = "менеджер паролей",
            definition = "אַפְּלִיקַצְיָה שֶׁשּׁוֹמֶרֶת בְּזִכָּרוֹן מֻצְפָּן הַרְבֵּה קוֹדִים שׁוֹנִים לְכָל הָאֲתָרִים שֶׁלְּךָ.",
            definitionNative = "Приложение, хранящее в зашифрованной памяти много кодов для всех твоих сайтов.",
            example = "מְנַהֵל סִיסְמָאוֹת חוֹסֵךְ לִי אֶת הַצֹּרֶךְ לִזְכֹּר עֲשָׂרוֹת קוֹדִים שׁוֹנִים.",
            exampleNative = "מְנַהֵל סִיסְמָאוֹת избавляет меня от нужды помнить десятки разных кодов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176708, setId = 1767, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_auth", transliteration = "singel sayin-on",
            original = "סִינְגֶל סָיין-אוֹן", translation = "SSO (единый вход)",
            definition = "מָקוֹם אֶחָד שֶׁמְּזַהֶה אוֹתְךָ פַּעַם אַחַת וְנוֹתֵן גִּישָׁה לְהַרְבֵּה מַעֲרָכוֹת בְּלִי לְהִכָּנֵס שׁוּב.",
            definitionNative = "Одна точка входа — опознала тебя один раз и пускает во много систем без повторного логина.",
            example = "סִינְגֶל סָיין-אוֹן בָּמִשְׂרָד מַחֲבֵר אֶת הַדּוֹאַר וְאֶת מַעֲרֶכֶת הַמַּשְׂכֹּרֶת.",
            exampleNative = "סִינְגֶל סָיין-אוֹן в офисе связывает почту и систему зарплаты.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176709, setId = 1767, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_auth", transliteration = "imut biyometri",
            original = "אִימוּת בִּיּוֹמֶטְרִי", translation = "биометрическая аутентификация",
            definition = "בְּדִיקַת זֶהוּת לְפִי תְּכוּנוֹת הַגּוּף — טְבִיעַת אֶצְבַּע, פָּנִים אוֹ קוֹל.",
            definitionNative = "Проверка личности по признакам тела — отпечатку пальца, лицу или голосу.",
            example = "הַטֶּלֶפוֹן הַחָדָשׁ נִפְתָּח עִם אִימוּת בִּיּוֹמֶטְרִי בְּתוֹךְ חֲצִי שְׁנִיָּה.",
            exampleNative = "Новый телефон открывается через אִימוּת בִּיּוֹמֶטְרִי за полсекунды.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176710, setId = 1767, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_auth", transliteration = "maftea'kh tsiburi",
            original = "מַפְתֵּחַ צִיבּוּרִי", translation = "открытый ключ",
            definition = "קוֹד גָּלוּי שֶׁכָּל אֶחָד יָכוֹל לְהִשְׁתַּמֵּשׁ בּוֹ כְּדֵי לִשְׁלֹחַ הוֹדָעָה מֻצְפֶּנֶת לִמְקַבֵּל יָדוּעַ.",
            definitionNative = "Открытый код — любой может им зашифровать сообщение для конкретного получателя.",
            example = "פִּרְסַמְתִּי מַפְתֵּחַ צִיבּוּרִי בָּאֲתָר לְקַבָּלַת דֹּאַר מֻצְפָּן.",
            exampleNative = "Я опубликовал свой מַפְתֵּחַ צִיבּוּרִי на сайте — для шифрованной почты.",
            isFillInBlankSafe = false,
        ),

        // ── cyber_network (5) — сетевая защита и периметр ──
        WordEntity(
            id = 176711, setId = 1767, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_network", transliteration = "fayer-oul",
            original = "פַייאֵרוֹאוּל", translation = "файрвол (брандмауэр)",
            definition = "מִסְנָן רֶשֶׁת שֶׁבּוֹדֵק כָּל בַּקָּשָׁה נִכְנֶסֶת וְיוֹצֵאת וְחוֹסֵם אֶת הַחֲשׁוּדוֹת.",
            definitionNative = "Сетевой фильтр — проверяет каждый входящий и исходящий запрос и блокирует подозрительные.",
            example = "פַייאֵרוֹאוּל שֶׁל הַחֶבְרָה חוֹסֵם גִּישָׁה לְאַתְרֵי שִׁיתּוּף קְבָצִים.",
            exampleNative = "פַייאֵרוֹאוּל фирмы блокирует доступ к файлообменникам.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176712, setId = 1767, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_network", transliteration = "vi-pi-en",
            original = "וִי-פִּי-אֵן", translation = "VPN (защищённый туннель)",
            definition = "תְּעָלָה מֻצְפֶּנֶת בֵּין הַמַּחְשֵׁב לַשָּׂרָת — מַסְתִּירָה אֶת הַתְּנוּעָה מֵעֵינַיִם זָרוֹת.",
            definitionNative = "Шифрованный канал между компьютером и сервером — прячет трафик от чужих глаз.",
            example = "אֲנִי מַפְעִיל וִי-פִּי-אֵן כָּל פַּעַם שֶׁאֲנִי מִתְחַבֵּר לְוַויי-פַיי בְּבֵית קָפֶה.",
            exampleNative = "Я включаю וִי-פִּי-אֵן каждый раз, когда подключаюсь к Wi-Fi в кафе.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176713, setId = 1767, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_network", transliteration = "ay-di-es",
            original = "אַיי-דִי-אֵס", translation = "IDS (система обнаружения вторжений)",
            definition = "מַעֲרֶכֶת שֶׁמַּקְשִׁיבָה לִתְנוּעַת הָרֶשֶׁת וּמַתְרִיעָה כְּשֶׁהִיא רוֹאָה דְּפוּס חָשׁוּד.",
            definitionNative = "Система слушает сетевой трафик и подаёт сигнал, заметив подозрительный паттерн.",
            example = "אַיי-דִי-אֵס שָׁלַח הִתְרָעָה לַצֶּוֶות שָׁלוֹשׁ דַּקּוֹת לִפְנֵי הַחֲדִירָה.",
            exampleNative = "אַיי-דִי-אֵס прислал команде тревогу за три минуты до проникновения.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176714, setId = 1767, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_network", transliteration = "ay-pi-es",
            original = "אַיי-פִּי-אֵס", translation = "IPS (система предотвращения вторжений)",
            definition = "כְּמוֹ שׁוֹמֵר פָּעִיל — לֹא רַק מְזַהֶה תְּקִיפָה אֶלָּא חוֹסֵם אוֹתָהּ אוֹטוֹמָטִית.",
            definitionNative = "Как активный охранник — не только видит атаку, но и блокирует её автоматически.",
            example = "אַיי-פִּי-אֵס חָסַם אֶת הַתְּקִיפָה בְּלִי שֶׁהַצֶּוֶות הוּצְרַךְ לְהִתְעָרֵב.",
            exampleNative = "אַיי-פִּי-אֵס заблокировал атаку — команде даже не пришлось вмешиваться.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176715, setId = 1767, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_network", transliteration = "di-em-zi",
            original = "דִי-אֶם-זִי", translation = "DMZ (демилитаризованная зона сети)",
            definition = "אֵזוֹר רֶשֶׁת מְבֻדָּד שֶׁבּוֹ יוֹשְׁבִים שָׂרָתִים פּוּמְבִּיִּים בְּלִי גִּישָׁה לָרֶשֶׁת הַפְּנִימִית.",
            definitionNative = "Изолированная зона сети — там стоят публичные сервера без выхода во внутреннюю сеть.",
            example = "שָׁמְנוּ אֶת שָׂרָת הָאֲתָר בְּדִי-אֶם-זִי כְּדֵי לְהָגֵן עַל הַמָּסָדִים הַפְּנִימִיִּים.",
            exampleNative = "Мы поставили веб-сервер в דִי-אֶם-זִי, чтобы защитить внутренние базы.",
            isFillInBlankSafe = false,
        ),

        // ── cyber_app (5) — уязвимости приложений и web ──
        WordEntity(
            id = 176716, setId = 1767, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_app", transliteration = "es-kyu-el inzhekshen",
            original = "אֶס-קְיוּ-אֶל אִינְגֵ'קְשֶׁן", translation = "SQL-инъекция",
            definition = "תְּקִיפָה שֶׁבָּהּ הַתּוֹקֵף שׁוֹתֵל פְּקוּדַת מָסַד בְּתוֹךְ טֹפֶס וּמַשִּׂיג גִּישָׁה לִנְתוּנִים.",
            definitionNative = "Атака — злоумышленник вшивает команду базы в форму и получает доступ к данным.",
            example = "אֶס-קְיוּ-אֶל אִינְגֵ'קְשֶׁן בִּפְשׁוּטָה חָשַׂף אֶת כָּל טַבְלַת הַמִּשְׁתַּמְּשִׁים.",
            exampleNative = "Простая אֶס-קְיוּ-אֶל אִינְגֵ'קְשֶׁן раскрыла всю таблицу пользователей.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176717, setId = 1767, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_app", transliteration = "eks-es-es",
            original = "אֶקְס-אֶס-אֶס", translation = "XSS (cross-site scripting)",
            definition = "הַחְדָּרַת קוֹד זָר לְדַף אַתָר כָּדִי שֶׁיֵּרוּץ בַּדַּפְדְּפָן שֶׁל הַמְבַקֵּר וְיִגְנֹב נְתוּנִים.",
            definitionNative = "Вшивание чужого кода в страницу — он бежит в браузере посетителя и крадёт данные.",
            example = "אֶקְס-אֶס-אֶס דֶּרֶךְ שָׂדֶה תְּגוּבוֹת שָׁלַח אֶת הָעוּגִיּוֹת לַתּוֹקֵף.",
            exampleNative = "אֶקְס-אֶס-אֶס через поле комментариев отправил cookies атакующему.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176718, setId = 1767, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_app", transliteration = "si-es-ar-ef",
            original = "סִי-אֶס-אַר-אֶף", translation = "CSRF (подделка межсайтового запроса)",
            definition = "תַּחְבּוּלָה שֶׁמַּכְרִיחָה אֶת הַדַּפְדְּפָן שֶׁל הַקָּרְבָּן לִשְׁלֹחַ פְּעֻלָּה בְּשֵׁם הַמִּשְׁתַּמֵּשׁ הַמְּחֻבָּר.",
            definitionNative = "Уловка — заставляет браузер жертвы отправить действие от имени залогиненного пользователя.",
            example = "סִי-אֶס-אַר-אֶף הֶעֱבִיר כֶּסֶף מֵהַחֶשְׁבּוֹן בְּעוֹד הַמִּשְׁתַּמֵּשׁ צוֹפֶה בִּסְרָטוֹן.",
            exampleNative = "סִי-אֶס-אַר-אֶף перевёл деньги со счёта, пока пользователь смотрел ролик.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176719, setId = 1767, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_app", transliteration = "owasp top asara",
            original = "אוֹוַסְפּ טוֹפּ עֲשָׂרָה", translation = "OWASP top 10",
            definition = "רְשִׁימָה רִשְׁמִית שֶׁל עֲשֶׂרֶת חוֹרֵי הָאַבְטָחָה הַנְּפוֹצִים בְּיוֹתֵר בְּאַתָרִים.",
            definitionNative = "Официальный список десяти самых частых дыр в защите сайтов.",
            example = "כָּל בּוֹדֵק חַיָּב לְהַכִּיר אֶת אוֹוַסְפּ טוֹפּ עֲשָׂרָה לִפְנֵי שֶׁמַּתְחִיל לַעֲבֹד.",
            exampleNative = "Каждый аудитор обязан знать אוֹוַסְפּ טוֹפּ עֲשָׂרָה до начала работы.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176720, setId = 1767, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_app", transliteration = "kod meubtakh",
            original = "קוֹד מְאֻבְטָח", translation = "защищённый код (secure coding)",
            definition = "סִגְנוֹן כְּתִיבַת תּוֹכְנָה שֶׁמֵּרֹאשׁ סוֹגֵר סִכּוּנֵי אַבְטָחָה לִפְנֵי שֶׁמִּישֶׁהוּ יְנַסֶּה לְנַצֵּל.",
            definitionNative = "Стиль написания программ — заранее закрывает бреши до того, как кто-то попытается их использовать.",
            example = "הֲדְרָכַת קוֹד מְאֻבְטָח חוֹסֶכֶת לַחֶבְרָה הַרְבֵּה בָּעָיוֹת בִּכְלָל הָעֵרֶךְ.",
            exampleNative = "Тренинг по קוֹד מְאֻבְטָח экономит фирме много проблем в продакшне.",
            isFillInBlankSafe = false,
        ),

        // ── cyber_basics (5) — основы криптографии ──
        WordEntity(
            id = 176721, setId = 1767, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_basics", transliteration = "hatzpana lo-simetrit",
            original = "הִצָפָּנָה לֹא-סִימֶטְרִית", translation = "асимметричное шифрование",
            definition = "שִׁיטָה שֶׁמַּשְׁתֶּמֶשֶׁת בִּזּוּג קוֹדִים — אֶחָד פּוּמְבִּי לְסִגוּר וְאֶחָד פְּרָטִי לִפְתִיחָה.",
            definitionNative = "Метод с парой кодов — один публичный для закрытия, другой приватный для открытия.",
            example = "הִצָפָּנָה לֹא-סִימֶטְרִית הִיא הַבָּסִיס לְכָל הַתִּקְשֹׁרֶת הַמֻּגֶּנֶת בָּאִינְטֶרְנֶט.",
            exampleNative = "הִצָפָּנָה לֹא-סִימֶטְרִית — основа всей защищённой связи в интернете.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176722, setId = 1767, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_basics", transliteration = "heshing",
            original = "הֵשִׁינְג", translation = "хеширование",
            definition = "תַּהֲלִיךְ שֶׁהוֹפֵךְ קֶלֶט בְּכָל אֹרֶךְ לִמְחָרוֹזֶת קְצָרָה קְבוּעָה — בְּלִי דֶּרֶךְ לַחֲזֹר אָחוֹר.",
            definitionNative = "Процесс — превращает любой ввод в короткую строку фиксированной длины, без пути назад.",
            example = "הֵשִׁינְג שֶׁל סִיסְמָה לִפְנֵי שְׁמִירָה מוֹנֵעַ דְּלִיפָה גַּם אִם הַמָּסַד נִגְנָב.",
            exampleNative = "הֵשִׁינְג пароля перед сохранением предотвращает утечку даже если базу украли.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176723, setId = 1767, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_basics", transliteration = "sertifikat",
            original = "סֶרְטִיפִיקַט", translation = "сертификат (TLS/SSL)",
            definition = "מִסְמָךְ דִיגִיטַלִי שֶׁמּוֹכִיחַ שֶׁאַתָר הוּא בֶּאֱמֶת מִי שֶׁהוּא טוֹעֵן וְלֹא הַעְתָּקָה מְזֻיֶּפֶת.",
            definitionNative = "Цифровой документ — доказывает, что сайт действительно тот, за кого себя выдаёт.",
            example = "הַדַּפְדְּפָן הִתְרִיעַ שֶׁהַסֶּרְטִיפִיקַט שֶׁל הָאֲתָר פָּג לִפְנֵי שְׁבוּעַיִם.",
            exampleNative = "Браузер предупредил, что סֶרְטִיפִיקַט сайта истёк две недели назад.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176724, setId = 1767, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cyber_basics", transliteration = "ti-el-es",
            original = "טִי-אֶל-אֶס", translation = "TLS (протокол защиты канала)",
            definition = "פְּרוֹטוֹקוֹל שֶׁעוֹטֵף תִּקְשֹׁרֶת בֵּין דַּפְדְּפָן לְשָׂרָת וּמוֹנֵעַ הַאֲזָנָה בָּאֶמְצַע.",
            definitionNative = "Протокол — оборачивает связь между браузером и сервером и не даёт прослушать её посередине.",
            example = "כָּל אֲתָר עִם מַנְעוּל יָרֹק בַּדַּפְדְּפָן מִשְׁתַּמֵּשׁ בְּטִי-אֶל-אֶס.",
            exampleNative = "Любой сайт с зелёным замком в браузере использует טִי-אֶל-אֶס.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 176725, setId = 1767, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "cyber_basics", transliteration = "khatima digitalit",
            original = "חֲתִימָה דִיגִיטָלִית", translation = "цифровая подпись",
            definition = "סִימָן מָתֵמָטִי שֶׁמּוֹכִיחַ שֶׁמִּסְמָךְ נִכְתַּב בִּידֵי אִישׁ מְסֻיָּם וְלֹא שֻׁנָּה אַחֲרֵי.",
            definitionNative = "Математический знак — доказывает, что документ написан конкретным человеком и не менялся.",
            example = "חֲתִימָה דִיגִיטָלִית עַל הַחוֹזֶה הִיא תַּחֲלִיף לְגָלִי לְעֵט וּנְיָר.",
            exampleNative = "חֲתִימָה דִיגִיטָלִית на договоре — юридический эквивалент ручки и бумаги.",
            isFillInBlankSafe = false,
        ),
    )
}
