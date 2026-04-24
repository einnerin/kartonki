package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity

/**
 * Extra words (positions 21–25) for immigrant sets 1022–1037.
 * All sets were missing 5 words to reach the standard 25-word count.
 * This file adds them without touching the original batch files.
 *
 * No WordSetEntity entries here — the sets already exist in Immigrant/2/3/4.
 */
object WordDataHebrewImmigrantExtra {

    val words = listOf(

        // ──────────────────────────────────────────────────────
        // Set 1022 — Документы и оформление (слова 21–25),
        // ──────────────────────────────────────────────────────

                                        
        // ──────────────────────────────────────────────────────
        // Set 1023 — Алия и абсорбция (слова 21–25),
        // ──────────────────────────────────────────────────────

                                        
        // ──────────────────────────────────────────────────────
        // Set 1024 — Банк: открытие счёта (слова 21–25),
        // ──────────────────────────────────────────────────────

                                        
        // ──────────────────────────────────────────────────────
        // Set 1025 — Аэропорт Бен-Гурион (слова 21–25),
        // ──────────────────────────────────────────────────────

                                        
        // ──────────────────────────────────────────────────────
        // Set 1026 — Аренда квартиры (слова 21–25),
        // ──────────────────────────────────────────────────────

        WordEntity(
            id = 102621, setId = 1026, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "apartment", transliteration = "khadar sheyna",
            original = "חֲדַר שֵׁינָה", translation = "спальня",
            definition = "הַחֶדֶר הַמְּיוּעָד לִשְׁנָת לָיְלָה.",
            definitionNative = "Комната, предназначенная для ночного сна.",
            example = "הַדִּירָה כּוֹלֶלֶת שְׁנַיִם חַדְרֵי שֵׁינָה וְסָלוֹן.",
            exampleNative = "Квартира включает две חֲדַר שֵׁינָה и гостиную.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 102622, setId = 1026, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "apartment", transliteration = "kheder okhel",
            original = "חֶדֶר אֹכֶל", translation = "столовая / обеденная зона",
            definition = "הַחֶדֶר אוֹ הַפִּנָּה בַּדִּירָה שֶׁבָּהּ אוֹכְלִים.",
            definitionNative = "Комната или уголок в квартире, где едят.",
            example = "הַמִּטְבָּח וְחֶדֶר הָאֹכֶל הַחִיפְּנוּ בְּדִירָה הַחֲדָשָׁה.",
            exampleNative = "Кухня и חֶדֶר אֹכֶל объединены в новой квартире.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 102623, setId = 1026, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "apartment", transliteration = "shkhenim",
            original = "שְׁכֵנִים", translation = "соседи",
            definition = "אֲנָשִׁים הַגָּרִים בַּבִּנְיָן אוֹ לְיַד הַדִּירָה.",
            definitionNative = "Люди, живущие в одном доме или рядом с квартирой.",
            example = "הַשְּׁכֵנִים שֶׁלָּנוּ מְאֹד נֶחְמָדִים וְתָּמִיד עוֹזְרִים.",
            exampleNative = "Наши שְׁכֵנִים очень хорошие и всегда помогают.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 102624, setId = 1026, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "apartment", transliteration = "merkhav",
            original = "מֶרְחָב", translation = "площадь / пространство (жилая площадь)",
            definition = "גֹּדֶל הַשֶּׁטַח שֶׁל דִּירָה אוֹ חֶדֶר בְּמֶטְרִים רְבוּעִים.",
            definitionNative = "Размер площади квартиры или комнаты в квадратных метрах.",
            example = "מֶרְחָב הַדִּירָה הוּא 75 מֶטְרִים רְבוּעִים.",
            exampleNative = "מֶרְחָב квартиры — 75 квадратных метров.",
         fillInBlankExclusions = listOf(102621L, 102622L, 102623L, 102625L)),
        WordEntity(
            id = 102625, setId = 1026, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "apartment", transliteration = "amalat tiyukh",
            original = "עֲמָלַת תִּיּוּךְ", translation = "комиссия агента по недвижимости",
            definition = "תַּשְׁלוּם הַנִּגְבָּה מֵהַשּׁוֹכֵר אוֹ הַמַּשְׂכִּיר בְּתַמּוּרָה לְשֵׁרוּת הַתִּיּוּךְ.",
            definitionNative = "Плата, взимаемая с арендатора или арендодателя за услуги посредничества.",
            example = "עֲמָלַת הַתִּיּוּךְ הִיא בְּדֶרֶךְ כְּלָל מֶחֱצִית חוֹדֶשׁ שְׂכִירוּת.",
            exampleNative = "עֲמָלַת תִּיּוּךְ обычно составляет половину месячной арендной платы.",
         isFillInBlankSafe = false),

        // ──────────────────────────────────────────────────────
        // Set 1027 — Коммунальные услуги (слова 21–25),
        // ──────────────────────────────────────────────────────

        WordEntity(
            id = 102721, setId = 1027, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "utilities", transliteration = "kheshbon khashmal",
            original = "חֶשְׁבּוֹן חַשְׁמַל", translation = "счёт за электричество",
            definition = "דְּרִישַׁת תַּשְׁלוּם שֶׁל חֶבְרַת הַחַשְׁמַל בְּגִין הַחַשְׁמַל שֶׁנִּצְרַךְ.",
            definitionNative = "Требование оплаты от электрической компании за потреблённую электроэнергию.",
            example = "חֶשְׁבּוֹן הַחַשְׁמַל שֶׁלָּנוּ גָּבֹהַּ בַּקַּיִץ בְּשֶׁל הַמַּזְגָּן.",
            exampleNative = "Наш חֶשְׁבּוֹן חַשְׁמַל высокий летом из-за кондиционера.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 102722, setId = 1027, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "utilities", transliteration = "provayeder",
            original = "פְּרוֹבַיְדֶר", translation = "провайдер (интернет-поставщик)",
            definition = "חֶבְרָה הַמְּסַפֶּקֶת גִּישָׁה לָאִינְטֶרְנֶט.",
            definitionNative = "Компания, предоставляющая доступ к интернету.",
            example = "עָבַרְתִּי לְפְּרוֹבַיְדֶר אַחֵר כִּי הַמְּהִירוּת הָיְתָה נְמוּכָּה.",
            exampleNative = "Я сменил פְּרוֹבַיְדֶר, потому что скорость была низкой.",
         fillInBlankExclusions = listOf(102711L)),
        WordEntity(
            id = 102723, setId = 1027, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "utilities", transliteration = "khimum",
            original = "חִמּוּם", translation = "отопление",
            definition = "מַעֲרֶכֶת לְחִמּוּם הַבַּיִת בְּמֶזֶג אֲוִיר קַר.",
            definitionNative = "Система для обогрева дома в холодную погоду.",
            example = "בְּחֶרְמוֹן יֵשׁ צֹרֶךְ בְּחִמּוּם בְּחֹרֶף.",
            exampleNative = "В Хермоне зимой необходимо חִמּוּם.",
         fillInBlankExclusions = listOf(102724L)),
        WordEntity(
            id = 102724, setId = 1027, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "utilities", transliteration = "energya",
            original = "אֶנֶרְגְיָה", translation = "энергия",
            definition = "כּוֹחַ אוֹ חַשְׁמַל הַנָּחוּץ לְהַפְעָלַת מִכְשִׁירִים וּבִנְיָנִים.",
            definitionNative = "Сила или электричество, необходимые для работы приборов и зданий.",
            example = "שִׁמּוּשׁ בְּאֶנֶרְגְיָה סוֹלָרִית מוֹרִיד אֶת הַחֶשְׁבּוֹן.",
            exampleNative = "Использование солнечной אֶנֶרְגְיָה снижает счёт за электричество.",
         fillInBlankExclusions = listOf(102723L)),
        WordEntity(
            id = 102725, setId = 1027, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "utilities", transliteration = "ventilatsya",
            original = "וִנְטִילַצְיָה", translation = "вентиляция",
            definition = "מַעֲרֶכֶת לְהַחְלָפַת אֲוִיר בְּמֶרְחָבִים סְגוּרִים.",
            definitionNative = "Система для обмена воздуха в закрытых помещениях.",
            example = "וִנְטִילַצְיָה טוֹבָה חִיּוּנִית בַּחֶדֶר שֶׁל יֶלֶד קָטָן.",
            exampleNative = "Хорошая וִנְטִילַצְיָה необходима в детской комнате.",
         fillInBlankExclusions = listOf(102723L)),

        // ──────────────────────────────────────────────────────
        // Set 1028 — Купат Холим (слова 21–25),
        // ──────────────────────────────────────────────────────

                                        
        // ──────────────────────────────────────────────────────
        // Set 1029 — Аптека (слова 21–25),
        // ──────────────────────────────────────────────────────

                                        
        // ──────────────────────────────────────────────────────
        // Set 1030 — Поиск работы (слова 21–25),
        // ──────────────────────────────────────────────────────

                                        
        // ──────────────────────────────────────────────────────
        // Set 1031 — Детский сад и школа (слова 21–25),
        // ──────────────────────────────────────────────────────

        WordEntity(
            id = 103121, setId = 1031, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "school", transliteration = "mora",
            original = "מוֹרָה", translation = "учительница",
            definition = "אִשָּׁה הַמְּלַמֶּדֶת תַּלְמִידִים בְּבֵית סֵפֶר.",
            definitionNative = "Женщина, обучающая учеников в школе.",
            example = "הַמּוֹרָה שֶׁל הַכִּתָּה שֶׁלִּי מְלַמֶּדֶת מַתְמָטִיקָה.",
            exampleNative = "מוֹרָה нашего класса преподаёт математику.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 103122, setId = 1031, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "school", transliteration = "khadar kita",
            original = "חֲדַר כִּיתָּה", translation = "классная комната",
            definition = "הַחֶדֶר שֶׁבּוֹ מִתְקַיְּמִים שִׁיעוּרִים בְּבֵית סֵפֶר.",
            definitionNative = "Комната, в которой проходят уроки в школе.",
            example = "כָּל חֲדַר כִּיתָּה מְצוּיָּד בְּלוּחַ חָכָם.",
            exampleNative = "Каждый חֲדַר כִּיתָּה оснащён умной доской.",
        ),
        WordEntity(
            id = 103123, setId = 1031, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "school", transliteration = "semester",
            original = "סֶמֶסְטֶר", translation = "семестр",
            definition = "מֶחֱצִית שֶׁל שָׁנַת הַלִּימּוּדִים בְּמוֹסָד אָקָדֵמִי.",
            definitionNative = "Половина учебного года в академическом заведении.",
            example = "הַסֶּמֶסְטֶר הָרִאשׁוֹן מַתְחִיל בְּאוֹקְטוֹבֶּר.",
            exampleNative = "Первый סֶמֶסְטֶר начинается в октябре.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 103124, setId = 1031, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "school", transliteration = "te'uda",
            original = "תְּעוּדָה", translation = "табель / свидетельство",
            definition = "מִסְמָךְ רִשְׁמִי הַמְּעִיד עַל לִימּוּדִים, הִישֵׂגִים אוֹ כִּשּׁוּרִים.",
            definitionNative = "Официальный документ, подтверждающий учёбу, достижения или квалификацию.",
            example = "קִיבַּלְנוּ אֶת תְּעוּדוֹת הַסּוֹף שָׁנָה בְּטֶקֶס.",
            exampleNative = "Мы получили годовые תְּעוּדָה на торжественной церемонии.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 103125, setId = 1031, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "school", transliteration = "iparon",
            original = "עִפָּרוֹן", translation = "карандаш",
            definition = "כְּלִי כְּתִיבָה עַם לַיְב גְּרָפִיט לִשְׁרִיטַת מִשְׁטָחִים.",
            definitionNative = "Инструмент для письма с графитовым стержнем для нанесения на поверхность.",
            example = "הַמּוֹרָה בִּקְּשָׁה לִכְתּוֹב בְּעִפָּרוֹן, לֹא בְּעֵט.",
            exampleNative = "Учительница попросила писать עִפָּרוֹן, а не ручкой.",
        ),

        // ──────────────────────────────────────────────────────
        // Set 1032 — Почта и посылки (слова 21–25),
        // ──────────────────────────────────────────────────────

        WordEntity(
            id = 103221, setId = 1032, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "post", transliteration = "bituakh mishlokh",
            original = "בִּיטּוּחַ מִשְׁלוֹחַ", translation = "страхование посылки",
            definition = "כִּיסּוּי בִּיטּוּחִי לְנֵזֶק אוֹ אֲבֵדָה שֶׁל חֲבִילָה בְּמֶשֶׁךְ הַמִּשְׁלוֹחַ.",
            definitionNative = "Страховое покрытие на случай повреждения или потери посылки при доставке.",
            example = "שִׁלַּחְתִּי אֶת הַחֲבִילָה עִם בִּיטּוּחַ מִשְׁלוֹחַ כִּי הִיא יְקָרָה.",
            exampleNative = "Я отправил посылку с בִּיטּוּחַ מִשְׁלוֹחַ, потому что она дорогая.",
        ),
        WordEntity(
            id = 103222, setId = 1032, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "post", transliteration = "mishlokh mahir",
            original = "מִשְׁלוֹחַ מְהִיר", translation = "экспресс-доставка",
            definition = "שֵׁרוּת מִשְׁלוֹחַ בִּזְמַן קָצָר מֵהַרָּגִיל, לְרוֹב בְּמְחִיר גָּבֹהַּ יוֹתֵר.",
            definitionNative = "Служба доставки за более короткое время, обычно по более высокой цене.",
            example = "בָּחַרְתִּי בְּמִשְׁלוֹחַ מְהִיר כְּדֵי שֶׁהַחֲבִילָה תַּגִּיעַ מָחָר.",
            exampleNative = "Я выбрал מִשְׁלוֹחַ מְהִיר, чтобы посылка пришла завтра.",
        ),
        WordEntity(
            id = 103223, setId = 1032, languagePair = "he-ru", rarity = "COMMON",
            pos = "noun", semanticGroup = "post", transliteration = "madbeka",
            original = "מַדְבֵּקָה", translation = "этикетка / наклейка",
            definition = "פֶּתֶק דָּבִיק שֶׁמָּדְבִּיקִים עַל חֲבִילוֹת עִם פְּרָטִים אוֹ לְעִיטּוּר.",
            definitionNative = "Клейкий ярлычок, наклеиваемый на посылки с данными или для украшения.",
            example = "הַמַּדְבֵּקָה עַל הַחֲבִילָה מְכִילָה אֶת שֵׁם הַמְּקַבֵּל וְאֶת הַכְּתוֹבֶת.",
            exampleNative = "מַדְבֵּקָה на посылке содержит имя получателя и адрес.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 103224, setId = 1032, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "post", transliteration = "shover",
            original = "שׁוֹבֵר", translation = "квитанция для получения / ваучер",
            definition = "תְּלוּשׁ הַמַּזְכֶּה בְּקַבָּלַת חֲבִילָה אוֹ שֵׁרוּת.",
            definitionNative = "Отрывной талон, дающий право на получение посылки или услуги.",
            example = "קִיבַּלְתִּי שׁוֹבֵר בְּדֹאַר לְמַשִּׁיכַת הַחֲבִילָה מֵהַסְּנִיף.",
            exampleNative = "Я получил שׁוֹבֵר по почте для получения посылки в отделении.",
         fillInBlankExclusions = listOf(103210L, 103215L)),
        WordEntity(
            id = 103225, setId = 1032, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "post", transliteration = "ktovet sholelkh",
            original = "כְּתוֹבֶת שׁוֹלֵחַ", translation = "адрес отправителя",
            definition = "כְּתוֹבַת הָאָדָם שֶׁשָּׁלַח אֶת הַחֲבִילָה, הַנִּרְשֶׁמֶת עַל גַּב הַחֲבִילָה.",
            definitionNative = "Адрес человека, отправившего посылку, указываемый на обратной стороне.",
            example = "כָּתַבְתִּי אֶת כְּתוֹבֶת הַשּׁוֹלֵחַ בְּפִּנָּה הָעֶלְיוֹנָה שְׂמֹאלִית.",
            exampleNative = "Я написал כְּתוֹבֶת שׁוֹלֵחַ в верхнем левом углу.",
         isFillInBlankSafe = false),

        // ──────────────────────────────────────────────────────
        // Set 1033 — Вождение и транспорт (слова 21–25),
        // ──────────────────────────────────────────────────────

                                        
        // ──────────────────────────────────────────────────────
        // Set 1034 — Полиция и экстренные службы (слова 21–25),
        // ──────────────────────────────────────────────────────

                                        
        // ──────────────────────────────────────────────────────
        // Set 1035 — Шаббат и праздники (слова 21–25),
        // ──────────────────────────────────────────────────────

        WordEntity(
            id = 103521, setId = 1035, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holidays", transliteration = "motsa'e shabbat",
            original = "מוֹצָאֵי שַׁבָּת", translation = "исход субботы / субботний вечер",
            definition = "הַזְּמַן לְאַחַר שְׁקִיעַת הַחַמָּה בְּמוֹצָאֵי שַׁבָּת כְּשֶׁמְּסַיְּמִים אֶת הַשַּׁבָּת.",
            definitionNative = "Время после захода солнца в субботу вечером, когда Шаббат заканчивается.",
            example = "בְּמוֹצָאֵי שַׁבָּת פּוֹתְחִים אֶת הַחֲנֻיּוֹת וְהַמִּסְעָדוֹת.",
            exampleNative = "В מוֹצָאֵי שַׁבָּת открываются магазины и рестораны.",
        ),
        WordEntity(
            id = 103522, setId = 1035, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holidays", transliteration = "tfilа",
            original = "תְּפִלָּה", translation = "молитва",
            definition = "פְּנִיָּה לֵאלֹהִים בְּבַקָּשָׁה, הוֹדָיָה אוֹ שֶׁבַח.",
            definitionNative = "Обращение к Богу с просьбой, благодарностью или хвалой.",
            example = "בְּשַׁבָּת מִשְׁתַּתְּפִים בִּתְפִלַּת הַבֹּקֶר בְּבֵית הַכְּנֶסֶת.",
            exampleNative = "В субботу участвуют в утренней תְּפִלָּה в синагоге.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 103523, setId = 1035, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holidays", transliteration = "erev khag",
            original = "עֵרֶב חַג", translation = "канун праздника",
            definition = "הַלַּיְלָה לִפְנֵי הַחַג שֶׁבּוֹ מְכִינִים אֶת הַחַג.",
            definitionNative = "Ночь перед праздником, когда готовятся к нему.",
            example = "בְּעֵרֶב חַג כָּל הַמִּשְׁפָּחָה עוֹזֶרֶת לְהָכִין אֶת הַסְּעוּדָה.",
            exampleNative = "В עֵרֶב חַג вся семья помогает готовить праздничный ужин.",
        ),
        WordEntity(
            id = 103524, setId = 1035, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holidays", transliteration = "minhag",
            original = "מִנְהַג", translation = "традиция / обычай",
            definition = "נוֹהַג מְקֻבָּל הַמֻּעְבָּר מִדּוֹר לְדוֹר בְּקֶרֶב עֵדָה אוֹ מִשְׁפָּחָה.",
            definitionNative = "Принятый обычай, передаваемый из поколения в поколение в общине или семье.",
            example = "מִנְהַג הַמִּשְׁפָּחָה הוּא לֶאֱכֹל דְּבַשׁ בְּרֹאשׁ הַשָּׁנָה.",
            exampleNative = "מִנְהַג нашей семьи — есть мёд на Рош Ашана.",
        ),
        WordEntity(
            id = 103525, setId = 1035, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "holidays", transliteration = "mezuza",
            original = "מְזוּזָה", translation = "мезуза",
            definition = "קְלַף קָדוֹשׁ בְּנַרְתִּיק הַמּוּצָמָד לְמְזוּזַת הַדֶּלֶת כְּסִימָן יְהוּדִי.",
            definitionNative = "Священный свиток в футляре, прикреплённый к косяку двери как еврейский символ.",
            example = "בְּכָל כְּנִיסָה לְבַיִת יְהוּדִי יֵשׁ מְזוּזָה בַּמְּזוּזָה הַיְּמִינִית.",
            exampleNative = "У каждого входа в еврейский дом есть מְזוּזָה на правом косяке.",
        ),

        // ──────────────────────────────────────────────────────
        // Set 1036 — Налоги и финансы (слова 21–25),
        // ──────────────────────────────────────────────────────

                                        
        // ──────────────────────────────────────────────────────
        // Set 1037 — Природа и климат Израиля (слова 21–25),
        // ──────────────────────────────────────────────────────

        WordEntity(
            id = 103721, setId = 1037, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "nature", transliteration = "karmel",
            original = "כַּרְמֶל", translation = "Кармель (горный массив)",
            definition = "רֶכֶס הָרִים בְּחֵיפָה וּסְבִיבוֹתֶיהָ, מְפֹרְסָם בְּיַעֲרוֹת וּנְחָלִים.",
            definitionNative = "Горный хребет в Хайфе и её окрестностях, известный лесами и ручьями.",
            example = "טִיַּלְנוּ בִּשְׁבִיל נָחָשׁ בְּרֶכֶס הַכַּרְמֶל.",
            exampleNative = "Мы прошли по тропе Нахаш на хребте כַּרְמֶל.",
        ),
        WordEntity(
            id = 103722, setId = 1037, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "nature", transliteration = "khermon",
            original = "חֶרְמוֹן", translation = "Хермон (гора / горнолыжный курорт)",
            definition = "הָהָר הַגָּבֹהַּ בְּיוֹתֵר בְּיִשְׂרָאֵל בְּצָפוֹן הַגּוֹלָן, עִם אֲזוֹר סְקִי בַּחֹרֶף.",
            definitionNative = "Самая высокая гора в Израиле на севере Голан, с горнолыжным районом зимой.",
            example = "בַּחֹרֶף עוֹלִים לַחֶרְמוֹן לְגְלִישָׁה עַל הַשֶּׁלֶג.",
            exampleNative = "Зимой едут на חֶרְמוֹן кататься на лыжах.",
        ),
        WordEntity(
            id = 103723, setId = 1037, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "nature", transliteration = "perekh",
            original = "פֶּרֶח", translation = "цветок",
            definition = "חֵלֶק הַצֶּמַח הַמְּיוּעָד לְרִבִּיָּה, לְרוֹב יָפֶה וְרֵיחָנִי.",
            definitionNative = "Часть растения, предназначенная для размножения, обычно красивая и ароматная.",
            example = "בָּאָבִיב פּוֹרְחִים פִּרְחֵי הַכַּלָּנִית הָאֲדֻמִּים בְּכָל הָאָרֶץ.",
            exampleNative = "Весной по всей стране цветут красные פֶּרֶח — каланиты.",
         isFillInBlankSafe = false),
        WordEntity(
            id = 103724, setId = 1037, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "nature", transliteration = "ets",
            original = "עֵץ", translation = "дерево",
            definition = "צֶמַח רַב-שְׁנָתִי עִם גֶּזַע קָשֶׁה, עֲנָפִים וְעָלִים.",
            definitionNative = "Многолетнее растение с твёрдым стволом, ветвями и листьями.",
            example = "עֵץ הַזַּיִת הוּא סֵמֶל שֶׁל יִשְׂרָאֵל וְהַשָּׁלוֹם.",
            exampleNative = "עֵץ маслины — символ Израиля и мира.",
        ),
        WordEntity(
            id = 103725, setId = 1037, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "nature", transliteration = "tsipor",
            original = "צִפּוֹר", translation = "птица",
            definition = "חַיָּה בַּעֲלַת כְּנָפַיִם וְנוֹצוֹת הַמְּסוּגֶּלֶת לְעוֹף.",
            definitionNative = "Животное с крыльями и перьями, способное летать.",
            example = "יִשְׂרָאֵל נְמֻצֶּאֶת עַל נָתִיב הַגֵּירָה שֶׁל מֵאוֹת מִינֵי צִפּוֹרִים.",
            exampleNative = "Израиль расположен на пути миграции сотен видов צִפּוֹר.",
        ),
    )
}
