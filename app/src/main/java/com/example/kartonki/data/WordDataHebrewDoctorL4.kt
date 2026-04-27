package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "У врача в Израиле", L4 «Профессиональный»
 * (EPIC+LEGENDARY).
 *
 * Set 1805: «У врача в Израиле» — профессиональный L4:
 *           Израильская система здравоохранения — кофат холим, корзина
 *           здоровья, гарантийные обязательства, дополнительное страхование,
 *           специальные клиники.
 *
 * Целевая аудитория — русскоязычные репатрианты, освоившие базовую
 * медицинскую лексику (L1-L3) и теперь разбирающиеся со страховой
 * бюрократией: четыре кофат холим, סל הבריאות, התחייבות, ביטוח משלים,
 * виды מרפאות. Лексика — административно-страховая сторона визита к врачу.
 *
 * Распределение редкостей: 13 EPIC + 12 LEGENDARY.
 *
 * SemanticGroups (5 × 5):
 *   doctor_kupot           — четыре кофат холим: общее понятие + 4 фонда
 *   doctor_health_basket   — корзина здоровья: услуги в корзине, вне корзины,
 *                            самоучастие, освобождение
 *   doctor_commitment      — гарантийные обязательства: технический אישור,
 *                            рофэ йоэц, рофэ ришони, внутреннее направление
 *   doctor_supplemental    — дополнительная страховка: משלים, פוליסה,
 *                            тяжёлые болезни, третий слой, סיעודי
 *   doctor_specialty_clinics — специализированные клиники: хирургия, боль,
 *                              реабилитация, дневная госпитализация, амбулатория
 *
 * Word IDs: setId × 100 + position (180501..180525).
 *
 * Пересечения с другими наборами:
 *   - DoctorL1L2L3 (1802-1804, параллельная разработка) — лексикон L1-L3
 *     покрывает базовый визит к врачу: симптомы, части тела, простые
 *     процедуры, основные специалисты. Здесь — административно-страховой
 *     слой, не пересекается.
 *   - MedicineV2 (1601-1606) — медицина в целом (части тела, болезни, врачи,
 *     процедуры). Несколько ключевых административных терминов
 *     (קֻפַּת חוֹלִים, четыре фонда, סָל הַבְּרִיאוּת, הִתְחַיְּבוּת, הַפְנָיָה)
 *     присутствуют в обоих темах — это допустимо по политике дублей: «между
 *     темами одного языка повтор original разрешён»
 *     (см. docs/claude/feedback_duplicate_words_policy.md). Тема нового сета
 *     — «У врача в Израиле» (фокус на израильской системе), тема MedicineV2 —
 *     «Медицина» (общая лексика).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён,
 * пока LLM-pipeline не пройдёт по набору и не проставит fillInBlankExclusions.
 */
object WordDataHebrewDoctorL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1805, languagePair = "he-ru", orderIndex = 1805,
            name = "У врача в Израиле",
            description = "Профессиональный: израильская система — кофат холим, корзина здоровья, обязательства",
            topic = "У врача в Израиле", level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1805 — У врача в Израиле: профессиональный (L4, EPIC+LEGENDARY)
        // 5 групп × 5 слов: kupot, health_basket, commitment, supplemental,
        // specialty_clinics
        // 13 EPIC + 12 LEGENDARY
        // ══════════════════════════════════════════════════════════════════════

        // ── doctor_kupot (5) — четыре кофат холим Израиля ──
        WordEntity(
            id = 180501, setId = 1805, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "doctor_kupot", transliteration = "magen briut",
            original = "מָגֵן בְּרִיאוּת", translation = "медицинский страховой щит",
            definition = "שִׁכְבַת הֲגָנָה בְּסִיסִית שֶׁמְּקַבֵּל כָּל תּוֹשָׁב מֵהַמְּדִינָה לְלֹא תַּשְׁלוּם נוֹסָף.",
            definitionNative = "Базовый защитный слой, что получает каждый житель от государства без доплаты.",
            example = "מָגֵן בְּרִיאוּת מַגִּיעַ אוֹטוֹמָטִית לְכָל תּוֹשָׁב מִיּוֹם הָעֲלִיָּה.",
            exampleNative = "Медицинский страховой щит положен автоматически каждому жителю с дня репатриации.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180502, setId = 1805, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "doctor_kupot", transliteration = "kupa tzibburit",
            original = "קֻפָּה צִיבּוּרִית", translation = "общественная медицинская касса",
            definition = "גּוּף לֹא־רַוְוחִי שֶׁמְּסַפֵּק טִפּוּל לְפִי תַּקְצִיב מֵהַמְּדִינָה וְלֹא לְמַטָּרַת רֶוַח.",
            definitionNative = "Некоммерческая организация, что выдаёт лечение по бюджету от государства, а не ради прибыли.",
            example = "קֻפָּה צִיבּוּרִית מְחֻיֶּבֶת לְקַבֵּל כָּל פּוֹנֶה בְּלִי קֶשֶׁר לְמַצָּב הַבְּרִיאוּת.",
            exampleNative = "Общественная медицинская касса обязана принимать любого обратившегося независимо от его состояния.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180503, setId = 1805, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "doctor_kupot", transliteration = "sherutei makabi",
            original = "שֵׁרוּתֵי מַכַּבִּי", translation = "сеть «Шерутей Маккаби»",
            definition = "הַשֵּׁם הָרִשְׁמִי שֶׁל הַמִּסְגֶּרֶת הַשְּׁנִיָּה בְּגֹדֶל בָּאָרֶץ — שִׁמּוּשׁ בְּסֶפֶר הַחֻקִּים.",
            definitionNative = "Официальное название второй по размеру сети в стране, что фигурирует в законах.",
            example = "שֵׁרוּתֵי מַכַּבִּי פָּתְחוּ סָנִיף חָדָשׁ לְיַד הַתַּחֲנָה הַמֶּרְכָּזִית.",
            exampleNative = "Сеть «Шерутей Маккаби» открыла новый филиал рядом с центральной автостанцией.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180504, setId = 1805, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "doctor_kupot", transliteration = "meukhedet",
            original = "מְאֻחֶדֶת", translation = "Меухедет",
            definition = "קֻפָּה שְׁלִישִׁית — קְטַנָּה יוֹתֵר, מַצִּיעָה הֲטָבוֹת לִמְבֻגָּרִים וּלְמִשְׁפָּחוֹת.",
            definitionNative = "Третья касса — поменьше, предлагает льготы пожилым и семьям.",
            example = "סָבָתָא שֶׁלִּי מְבֻטַּחַת בִּמְאֻחֶדֶת כְּבָר עֶשְׂרִים שָׁנָה.",
            exampleNative = "Моя бабушка застрахована в מְאֻחֶדֶת уже двадцать лет.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180505, setId = 1805, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "doctor_kupot", transliteration = "leumit",
            original = "לֵאוּמִית", translation = "Леумит",
            definition = "הַקֻּפָּה הַקְּטַנָּה בְּיוֹתֵר — בְּחִירָה שֶׁל מִי שֶׁמְּחַפֵּשׂ דְּמֵי-חָבֵר נְמוּכִים.",
            definitionNative = "Самая маленькая касса — выбор тех, кто ищет низкий членский взнос.",
            example = "לֵאוּמִית פָּתְחָה סָנִיף חָדָשׁ בְּעִיר הַפְּרִיפֶרְיָה הַשָּׁנָה.",
            exampleNative = "לֵאוּמִית открыла новый филиал в периферийном городе в этом году.",
            isFillInBlankSafe = false,
        ),

        // ── doctor_health_basket (5) — корзина здоровья и самоучастие ──
        WordEntity(
            id = 180506, setId = 1805, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "doctor_health_basket", transliteration = "sal habriut",
            original = "סַל הַבְּרִיאוּת", translation = "корзина здоровья",
            definition = "רְשִׁימַת הַשֵּׁרוּתִים שֶׁכָּל מְבֻטָּח זַכַּאי לָהֶם בְּלִי תַּשְׁלוּם נוֹסָף.",
            definitionNative = "Список услуг, на которые каждый застрахованный имеет право без доплаты от государства.",
            example = "סַל הַבְּרִיאוּת מִתְעַדְכֵּן כָּל שָׁנָה עַל יְדֵי וַעֲדָה צִבּוּרִית.",
            exampleNative = "סַל הַבְּרִיאוּת обновляется каждый год общественной комиссией.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180507, setId = 1805, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "doctor_health_basket", transliteration = "trufot basal",
            original = "תְּרוּפוֹת בַּסַּל", translation = "лекарства из корзины",
            definition = "כַּדּוּרִים וּמִשְׁחוֹת שֶׁאֻשְּׁרוּ לְמִמּוּן צִבּוּרִי — הַחוֹלֶה מוֹסִיף חֵלֶק זָעוּם.",
            definitionNative = "Препараты, утверждённые для гос. финансирования — больной платит лишь малую долю.",
            example = "הָרוֹפֵא בָּחַר תְּרוּפוֹת בַּסַּל כְּדֵי לַחֲסֹךְ לִי כֶּסֶף.",
            exampleNative = "Врач выбрал תְּרוּפוֹת בַּסַּל, чтобы сэкономить мне деньги.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180508, setId = 1805, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "doctor_health_basket", transliteration = "sherutim mikhuts lasal",
            original = "שֵׁרוּתִים מִחוּץ לַסַּל", translation = "услуги вне корзины",
            definition = "טִפּוּלִים שֶׁלֹּא נִכְנָסִים לָרְשִׁימָה הַצִּבּוּרִית — הַמְּטֻפָּל מְמַמֵּן בְּעַצְמוֹ.",
            definitionNative = "Лечения, не входящие в общественный список — пациент финансирует их сам.",
            example = "טִפּוּל זֶה נֶחְשָׁב לְשֵׁרוּתִים מִחוּץ לַסַּל וְעוֹלֶה מָמוֹן רַב.",
            exampleNative = "Это лечение считается שֵׁרוּתִים מִחוּץ לַסַּל и стоит немалых денег.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180509, setId = 1805, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "doctor_health_basket", transliteration = "hishtatfut atsmit",
            original = "הִשְׁתַּתְּפוּת עַצְמִית", translation = "самоучастие",
            definition = "סְכוּם קָטָן שֶׁמּוֹסִיף הַחוֹלֶה מִכִּיסוֹ עַל בִּקּוּר אוֹ עַל מִרְשָׁם.",
            definitionNative = "Небольшая сумма, что больной платит сам за визит или за рецепт.",
            example = "הִשְׁתַּתְּפוּת עַצְמִית לְבִקּוּר אֵצֶל יוֹעֵץ — שְׁלוֹשִׁים שֶׁקֶל.",
            exampleNative = "הִשְׁתַּתְּפוּת עַצְמִית за визит к консультанту — тридцать шекелей.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180510, setId = 1805, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "doctor_health_basket", transliteration = "ptor mehishtatfut",
            original = "פְּטוֹר מֵהִשְׁתַּתְּפוּת", translation = "освобождение от самоучастия",
            definition = "זְכוּת לֹא לְשַׁלֵּם אֶת הַסְּכוּם הַקָּטָן — לִקְשִׁישִׁים וּלְחוֹלִים כְרוֹנִיִּים.",
            definitionNative = "Право не платить эту сумму — даётся пожилым и хронически больным.",
            example = "אַבָּא קִבֵּל פְּטוֹר מֵהִשְׁתַּתְּפוּת בִּגְלַל מַחֲלָה כְרוֹנִית.",
            exampleNative = "Папа получил פְּטוֹר מֵהִשְׁתַּתְּפוּת из-за хронической болезни.",
            isFillInBlankSafe = false,
        ),

        // ── doctor_commitment (5) — гарантийные обязательства и направления ──
        WordEntity(
            id = 180511, setId = 1805, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "doctor_commitment", transliteration = "hakhlatat kupa",
            original = "הַחְלָטַת קֻפָּה", translation = "решение страховой кассы",
            definition = "קְבִיעָה רִשְׁמִית שֶׁל הַגּוּף הַמְבַטֵּחַ אִם לְמַמֵּן טִפּוּל לְמְבֻטָּח אוֹ לִדְחוֹתוֹ.",
            definitionNative = "Официальный вердикт страховщика — финансировать лечение пациента или отказать.",
            example = "הַחְלָטַת קֻפָּה הִגִּיעָה בְּמֵייל וְהִיא חִיּוּבִית עַל הַטִּפּוּל הַחָדָשׁ.",
            exampleNative = "Решение страховой кассы пришло по почте и оно положительное по новому лечению.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180512, setId = 1805, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "doctor_commitment", transliteration = "ishur tekhni",
            original = "אִישּׁוּר טֶכְנִי", translation = "техническое подтверждение",
            definition = "מַעֲנֶה פוֹרְמָלִי שֶׁכָּל הַתְּנָאִים מִתְקַיְּמִים — בְּלִי דִּיּוּן רְפוּאִי נוֹסָף.",
            definitionNative = "Формальное одобрение, что все условия выполнены — без дополнительного мед. обсуждения.",
            example = "אִישּׁוּר טֶכְנִי לַבְּדִיקָה הִגִּיעַ בְּמֵייל בְּתוֹךְ שָׁעָה.",
            exampleNative = "אִישּׁוּר טֶכְנִי на проверку пришёл по почте в течение часа.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180513, setId = 1805, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "doctor_commitment", transliteration = "rofe yoets",
            original = "רוֹפֵא יוֹעֵץ", translation = "врач-консультант",
            definition = "מֻמְחֶה שֶׁאֵלָיו פּוֹנִים לְבִקּוּר חַד-פַּעֲמִי לְצֹרֶךְ חַוַּת-דַּעַת בִּתְחוּמוֹ.",
            definitionNative = "Специалист, к которому идут на разовый визит за мнением в его области.",
            example = "הָרוֹפֵא הָרִאשׁוֹנִי שָׁלַח אוֹתִי לְרוֹפֵא יוֹעֵץ בְּלֵב.",
            exampleNative = "Семейный врач направил меня к רוֹפֵא יוֹעֵץ по сердцу.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180514, setId = 1805, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "doctor_commitment", transliteration = "rofe rishoni",
            original = "רוֹפֵא רִאשׁוֹנִי", translation = "первичный врач",
            definition = "הַכְּתֹבֶת הַהַתְחָלָתִית שֶׁל הַמְבֻטָּח — פּוֹתֵחַ אֶת הַמַּסְלוּל לַיּוֹעֲצִים.",
            definitionNative = "Начальный адрес для застрахованного — он открывает путь к консультантам.",
            example = "כָּל בְּדִיקָה מַתְחִילָה אֵצֶל הָרוֹפֵא הָרִאשׁוֹנִי שֶׁלִּי בַּסָּנִיף.",
            exampleNative = "Любая проверка начинается у моего רוֹפֵא רִאשׁוֹנִי в филиале.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180515, setId = 1805, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "doctor_commitment", transliteration = "hafnaya dchufa",
            original = "הַפְנָיָה דְחוּפָה", translation = "срочное направление",
            definition = "טֹפֶס שֶׁמַּתִּיר טִפּוּל בְּלִי תּוֹר רָגִיל — מָסֵר מֻמְחֶה בְּמַצָּב חָרוּם.",
            definitionNative = "Бланк, разрешающий лечение без обычной очереди — выдаёт специалист в экстренной ситуации.",
            example = "הָרוֹפֵא חָתַם הַפְנָיָה דְחוּפָה לְבֵית חוֹלִים בְּאוֹתוֹ עֶרֶב.",
            exampleNative = "Врач подписал הַפְנָיָה דְחוּפָה в больницу в тот же вечер.",
            isFillInBlankSafe = false,
        ),

        // ── doctor_supplemental (5) — дополнительные страховки ──
        WordEntity(
            id = 180516, setId = 1805, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "doctor_supplemental", transliteration = "bituakh mashlim",
            original = "בִּטּוּחַ מַשְׁלִים", translation = "дополнительная страховка",
            definition = "שִׁכְבָה שְׁנִיָּה שֶׁל כִּסּוּי מֵהַקֻּפָּה — מוֹסִיף שֵׁרוּתִים מֵעֵבֶר לַבְּסִיס.",
            definitionNative = "Второй слой покрытия от самой кассы — добавляет услуги сверх базы.",
            example = "בִּטּוּחַ מַשְׁלִים מְכַסֶּה לִי בְּחִירַת מְנַתֵּחַ בָּבֵית-הַחוֹלִים.",
            exampleNative = "בִּטּוּחַ מַשְׁלִים покрывает мне выбор хирурга в больнице.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180517, setId = 1805, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "doctor_supplemental", transliteration = "polisa pratit",
            original = "פּוֹלִיסָה פְּרָטִית", translation = "частный полис",
            definition = "חוֹזֶה עִם חֶבְרַת בִּטּוּחַ מִחוּץ לַקֻּפָּה — לְכִסּוּי הַרְחָבָה אִישִׁי וִיקַר.",
            definitionNative = "Договор со страховой вне кассы — для индивидуального и дорогого расширения.",
            example = "פּוֹלִיסָה פְּרָטִית טוֹבָה עוֹלָה אַלְפֵי שְׁקָלִים בַּשָּׁנָה.",
            exampleNative = "Хорошая פּוֹלִיסָה פְּרָטִית стоит тысячи шекелей в год.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180518, setId = 1805, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "doctor_supplemental", transliteration = "kisuy lemakhalot kashot",
            original = "כִּסּוּי לְמַחֲלוֹת קָשׁוֹת", translation = "покрытие тяжёлых заболеваний",
            definition = "תַּשְׁלוּם חַד-פַּעֲמִי גָּדוֹל לְמִי שֶׁנִּתְגַּלָּה אֶצְלוֹ סַרְטָן אוֹ אֵרוּעַ מֹחִי.",
            definitionNative = "Крупная разовая выплата тому, у кого нашли рак или мозговое событие.",
            example = "כִּסּוּי לְמַחֲלוֹת קָשׁוֹת עוֹזֵר לְכַסּוֹת חֳדָשִׁים בְּלִי עֲבוֹדָה.",
            exampleNative = "כִּסּוּי לְמַחֲלוֹת קָשׁוֹת помогает покрыть месяцы без работы.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180519, setId = 1805, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "doctor_supplemental", transliteration = "shikhva shlishit",
            original = "שִׁכְבָה שְׁלִישִׁית", translation = "третий слой страховки",
            definition = "רֹבֶד עָמֹק יוֹתֵר מֵהַמַּשְׁלִים — לְמִי שֶׁרוֹצֶה גַּם פְּרָטִי מֵעַל הַכֹּל.",
            definitionNative = "Уровень глубже дополнительной — для тех, кто хочет ещё и частный поверх всего.",
            example = "הַבּוֹחֵר בְּשִׁכְבָה שְׁלִישִׁית מְשַׁלֵּם שָׁלוֹשׁ פְּרֵמְיוֹת.",
            exampleNative = "Кто выбирает שִׁכְבָה שְׁלִישִׁית, платит три премии параллельно.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180520, setId = 1805, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "doctor_supplemental", transliteration = "bituakh siudi",
            original = "בִּיטוּחַ סִיעוּדִי", translation = "страховка на уход",
            definition = "כִּסּוּי לְזָקֵן שֶׁאֵינוֹ מַסְפִּיק לְעַצְמוֹ וְצָרִיךְ עֶזְרָה יוֹמְיוֹמִית בַּבַּיִת.",
            definitionNative = "Покрытие пожилого, что себя не обслуживает и нуждается в ежедневной помощи дома.",
            example = "בִּיטוּחַ סִיעוּדִי מְמַמֵּן עוֹבֶדֶת זָרָה לְסָבָתָא בַּבַּיִת.",
            exampleNative = "בִּיטוּחַ סִיעוּדִי финансирует иностранную работницу для бабушки дома.",
            isFillInBlankSafe = false,
        ),

        // ── doctor_specialty_clinics (5) — специализированные клиники ──
        WordEntity(
            id = 180521, setId = 1805, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "doctor_specialty_clinics", transliteration = "mirpaa kirurgit",
            original = "מִרְפְּאָה כִּירוּרְגִית", translation = "хирургическая клиника",
            definition = "מָקוֹם שֶׁבּוֹ מְקַבְּלִים נִתּוּחִים קְטַנִּים בְּלִי לְהִתְאַשְׁפֵּז לְלַיְלָה.",
            definitionNative = "Место, где делают мелкие операции без госпитализации на ночь.",
            example = "פִּנּוּ אוֹתִי לְמִרְפְּאָה כִּירוּרְגִית לְהוֹצָאַת שׁוּמָן.",
            exampleNative = "Меня направили в מִרְפְּאָה כִּירוּרְגִית на удаление жировика.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180522, setId = 1805, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "doctor_specialty_clinics", transliteration = "mirpaat keev",
            original = "מִרְפְּאַת כְּאֵב", translation = "клиника боли",
            definition = "צֶוֶת רַב-מִקְצוֹעִי שֶׁמְּטַפֵּל בִּמְבֻגָּרִים שֶׁסּוֹבְלִים חֳדָשִׁים אֲרֻכִּים.",
            definitionNative = "Многопрофильная команда, что лечит взрослых, страдающих долгие месяцы.",
            example = "מִרְפְּאַת כְּאֵב הִצִּיעָה לִי שִׁלּוּב שֶׁל תְּרוּפָה וְהִתְעַמְּלוּת.",
            exampleNative = "מִרְפְּאַת כְּאֵב предложила мне сочетание препарата и гимнастики.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180523, setId = 1805, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "doctor_specialty_clinics", transliteration = "mirpaat shikum",
            original = "מִרְפְּאַת שִׁקּוּם", translation = "клиника реабилитации",
            definition = "מָקוֹם שֶׁמַּחֲזִיר אֲנָשִׁים לְתִפְקוּד אַחֲרֵי תְּאוּנָה אוֹ אֵרוּעַ מֹחִי.",
            definitionNative = "Место, что возвращает людей к функционированию после аварии или инсульта.",
            example = "אַחֲרֵי הָאֵרוּעַ הַמֹּחִי הִגַּעְתִּי לְמִרְפְּאַת שִׁקּוּם כָּל שָׁבוּעַ.",
            exampleNative = "После инсульта я ходил в מִרְפְּאַת שִׁקּוּם два раза в неделю.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180524, setId = 1805, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "doctor_specialty_clinics", transliteration = "ishpuz yom",
            original = "אִשְׁפּוּז יוֹם", translation = "дневная госпитализация",
            definition = "הַגָּעָה לְבֵית-חוֹלִים בַּבֹּקֶר וִיצִיאָה הַבַּיְתָה בָּעֶרֶב — בְּלִי לִינָה.",
            definitionNative = "Приход в больницу утром и уход домой вечером — без ночёвки.",
            example = "קִבַּלְתִּי כִימוֹתֶרַפְּיָה בְּמַסְלוּל אִשְׁפּוּז יוֹם פַּעַם בִּשְׁבוּעַיִם.",
            exampleNative = "Я получал химию по маршруту אִשְׁפּוּז יוֹם раз в две недели.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 180525, setId = 1805, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "doctor_specialty_clinics", transliteration = "mirpeet khuts",
            original = "מִרְפֵּאת חוּץ", translation = "амбулаторное отделение",
            definition = "אֲגַף בְּתוֹךְ בֵּית-הַחוֹלִים שֶׁמְּקַבֵּל מְטֻפָּלִים בְּלִי לְאַשְׁפֵּז אוֹתָם.",
            definitionNative = "Подразделение внутри больницы, что принимает пациентов без их госпитализации.",
            example = "מִרְפֵּאת חוּץ אוֹרְתוֹפֶּדִית בְּהַדָסָה פְּתוּחָה כָּל בֹּקֶר.",
            exampleNative = "מִרְפֵּאת חוּץ ортопедическая в Хадассе открыта каждое утро.",
            isFillInBlankSafe = false,
        ),
    )
}
