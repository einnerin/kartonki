package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic «Транспорт в Израиле», level 2 (B1).
 * Один сет × 25 слов. setId = 1853. Продолжение L1 (set 1852).
 *
 *  - 17 UNCOMMON + 8 RARE (два смежных уровня).
 *  - 5 семантических групп по 5 слов:
 *      transport_l2_problems          — проблемы в дороге: пробка-загрузка,
 *                                       опоздание, поломка, забастовка,
 *                                       незаконная парковка (5)
 *      transport_l2_intercity         — междугородние поездки: межгород,
 *                                       долгая поездка, скорость, ожидание,
 *                                       скидка (5)
 *      transport_l2_documents         — документы и проверки: водительское,
 *                                       страховка, регистрация, тест-МоТ,
 *                                       автосервис (5)
 *      transport_l2_actions_advanced  — продвинутые действия: пересесть,
 *                                       задерживаться, прозевать, сократить
 *                                       путь, тормозить (5)
 *      transport_l2_advanced_terms    — продвинутые термины: компания Эгед,
 *                                       приморская трасса, север, юг, центр (5)
 *  - Тема — переходный уровень: израильтяне сталкиваются с «час пик», берут
 *    автобус Эгед в Беэр-Шеву по бейн-ирони, делают טֶסְט раз в год,
 *    показывают רִשְׁיוֹן נְהִיגָה — всё то, что в L1 ещё не покрыто.
 *  - Никудим везде (стандарт he-ru). Огласовки в `example` ставятся только
 *    на целевом слове.
 *  - Замены против исходного плана из-за коллизий с уже существующими
 *    сетами:
 *      פְּקָק → עוֹמֶס תְּנוּעָה (פְּקָק уже COMMON в Batch66/1383, нельзя
 *                  поднимать rarity; синоним передаёт ту же ситуацию)
 *      גֻּלָּם → שָׁבִיתָה (גֻּלָּם «болванка» не подходит контексту
 *                  транспорта; забастовки водителей — реальная проблема в IL)
 *      הִתְקַבְּלוּת → הַמְתָּנָה (הִתְקַבְּלוּת — нестандартное; הַמְתָּנָה
 *                  уже UNCOMMON в BureauL1 — выровнено)
 *      בְּדִיקָה → טֶסְט (בְּדִיקָה занят в Batch62/QaL1/MedicineV2 в разных
 *                  rarity; טֶסְט — конкретный израильский термин для
 *                  годовой проверки авто)
 *      מַעֲבָדָה → מוֹסַךְ (מַעְבָּדָה уже COMMON в ScienceL1 «лаборатория»;
 *                  מוֹסַךְ — автомастерская, прямой контекст транспорта)
 *      לִפְנוֹת → לְהִתְעַכֵּב (לִפְנוֹת уже COMMON в Batch66/1383)
 *      לַחְצוֹת → לְפַסְפֵּס (לַחֲצוֹת уже COMMON в UrbanLifeL1)
 *      לִעֲצֹר → לְקַצֵּר (לַעֲצֹר уже COMMON в Batch66/1383)
 *      לַחֲנוֹת → לִבְלֹם (לְהַחְנוֹת уже COMMON в AutomobilePartial)
 *      אַרְכֵי-אוֹטוֹבּוּס → אֶגֶד (имя собственное компании Egged — точнее
 *                  и реалистичнее)
 *      חוֹף הַשָּׁרוֹן → כְּבִישׁ הַחוֹף (приморская трасса №2 — главная
 *                  транспортная артерия побережья)
 *  - Rarity-выравнивания: אִחוּר UNCOMMON (SchoolL2), תַּקָּלָה UNCOMMON
 *    (Immigrant2/QaL1), רִשּׁוּם UNCOMMON (Batch13/BureauL1), מְהִירוּת
 *    UNCOMMON (Batch64), הַמְתָּנָה UNCOMMON (BureauL1) — все совпадают.
 *  - fillInBlankExclusions / isFillInBlankSafe не задаются — заполнятся
 *    через FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataHebrewIsraeliTransportL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1853, languagePair = "he-ru", orderIndex = 1853,
            name = "Транспорт в Израиле",
            description = "Пробки, межгород, документы, тест-МоТ и Эгед",
            topic = "Транспорт в Израиле", level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── transport_l2_problems (5) ───────────────────────────────────
        WordEntity(
            id = 185301, setId = 1853, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "transport_l2_problems",
            original = "עוֹמֶס תְּנוּעָה", translation = "перегрузка движения",
            transliteration = "омес тнуа",
            definition = "מַצָּב שֶׁבּוֹ יֵשׁ הַרְבֵּה רֶכֶב עַל הַכְּבִישׁ וְהַתְּנוּעָה זָזָה לְאַט.",
            definitionNative = "Ситуация, когда на дороге очень много машин и движение еле ползёт.",
            example = "עוֹמֶס תְּנוּעָה כָּבֵד בִּכְנִיסָה לְתֵל אָבִיב בַּבֹּקֶר.",
            exampleNative = "Сильный עוֹמֶס תְּנוּעָה на въезде в Тель-Авив каждое утро.",
         fillInBlankExclusions = listOf(185302L, 185303L, 185304L)),
        WordEntity(
            id = 185302, setId = 1853, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "transport_l2_problems",
            original = "אִחוּר", translation = "опоздание",
            transliteration = "ихур",
            definition = "הַגָּעָה שֶׁל אוֹטוֹבּוּס אוֹ רַכֶּבֶת מְאֻחָר מֵהַזְּמַן הַכָּתוּב בַּלּוּחַ.",
            definitionNative = "Прибытие автобуса или поезда позже того времени, что указано в расписании.",
            example = "אִחוּר שֶׁל עֶשֶׂר דַּקּוֹת בָּאוֹטוֹבּוּס גָּרַם לִי לְפַסְפֵּס פְּגִישָׁה.",
            exampleNative = "אִחוּר автобуса в десять минут заставил меня пропустить встречу.",
         fillInBlankExclusions = listOf(185301L, 185303L, 185304L, 185309L)),
        WordEntity(
            id = 185303, setId = 1853, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "transport_l2_problems",
            original = "תַּקָּלָה", translation = "поломка",
            transliteration = "такала",
            definition = "בְּעָיָה טֶכְנִית בָּרֶכֶב אוֹ בָּרַכֶּבֶת שֶׁמַּפְסִיקָה אֶת הַנְּסִיעָה.",
            definitionNative = "Техническая неисправность транспорта, которая прерывает поездку.",
            example = "תַּקָּלָה בַּקַּטָּר עִכְּבָה אֶת הָרַכֶּבֶת לְשָׁעָה שְׁלֵמָה.",
            exampleNative = "תַּקָּלָה в локомотиве задержала поезд на целый час.",
         fillInBlankExclusions = listOf(185301L, 185302L, 185304L)),
        WordEntity(
            id = 185304, setId = 1853, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "transport_l2_problems",
            original = "שָׁבִיתָה", translation = "забастовка (водителей)",
            transliteration = "швита",
            definition = "הַפְסָקַת עֲבוֹדָה מְאֻרְגֶּנֶת שֶׁל נֶהָגִים אוֹ עוֹבְדֵי תַחְבּוּרָה צִבּוּרִית.",
            definitionNative = "Организованная остановка работы водителей или работников транспорта.",
            example = "שָׁבִיתָה שֶׁל נֶהָגֵי הָרַכֶּבֶת מְבוּטֶלֶת אַחֲרֵי מַשָּׂא וּמַתָּן.",
            exampleNative = "שָׁבִיתָה машинистов поездов отменена после переговоров с профсоюзом.",
         fillInBlankExclusions = listOf(185301L, 185302L, 185303L)),
        WordEntity(
            id = 185305, setId = 1853, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "transport_l2_problems",
            original = "חֲנִיָּה אֲסוּרָה", translation = "запрещённая парковка",
            transliteration = "ханийа асура",
            definition = "הַחְנָיָה בִּמְקוֹם שֶׁאָסוּר עַל פִּי תַּמְרוּר אוֹ צֶבַע אָדֹם-לָבָן בַּמַּדְרֵכָה.",
            definitionNative = "Парковка в месте, где запрещено по знаку или красно-белой разметке.",
            example = "קִבַּלְתִּי דּוּחַ עַל חֲנִיָּה אֲסוּרָה מוּל בֵּית הַסֵּפֶר אֶתְמוֹל.",
            exampleNative = "Я получил штраф за חֲנִיָּה אֲסוּרָה прямо напротив школы вчера.",
        ),

        // ─── transport_l2_intercity (5) ──────────────────────────────────
        WordEntity(
            id = 185306, setId = 1853, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "transport_l2_intercity",
            original = "בֵּין-עִירוֹנִי", translation = "междугородний",
            transliteration = "бейн-ирони",
            definition = "שַׁיָּךְ לְקַו תַּחְבּוּרָה שֶׁמְּחַבֵּר בֵּין שְׁתֵּי עָרִים שׁוֹנוֹת אוֹ יוֹתֵר.",
            definitionNative = "Относящийся к маршруту, что соединяет два или более разных города.",
            example = "אוֹטוֹבּוּס בֵּין-עִירוֹנִי לְאֵילַת יוֹצֵא מֵהַתַּחֲנָה כָּל שָׁעָה.",
            exampleNative = "בֵּין-עִירוֹנִי автобус в Эйлат отходит со станции каждый час.",
        ),
        WordEntity(
            id = 185307, setId = 1853, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "transport_l2_intercity",
            original = "נְסִיעָה אֲרֻכָּה", translation = "долгая поездка",
            transliteration = "несиа арука",
            definition = "מַסָּע שֶׁאוֹרֵךְ כַּמָּה שָׁעוֹת אוֹ יוֹתֵר בַּתַּחְבּוּרָה הַצִּבּוּרִית.",
            definitionNative = "Поездка, которая длится несколько часов или больше в общественном транспорте.",
            example = "נְסִיעָה אֲרֻכָּה לְאֵילַת אוֹרֶכֶת חָמֵשׁ שָׁעוֹת בְּלִי פְּקָקִים.",
            exampleNative = "נְסִיעָה אֲרֻכָּה до Эйлата занимает пять часов без пробок.",
        ),
        WordEntity(
            id = 185308, setId = 1853, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "transport_l2_intercity",
            original = "מְהִירוּת", translation = "скорость",
            transliteration = "мехирут",
            definition = "כַּמָּה קִילוֹמֶטְרִים הָרֶכֶב אוֹ הָרַכֶּבֶת עוֹבְרִים בְּשָׁעָה אַחַת בַּדֶּרֶךְ.",
            definitionNative = "Сколько километров транспорт проходит за один час пути.",
            example = "מְהִירוּת הָרַכֶּבֶת הַמְּהִירָה לִיְרוּשָׁלַיִם מַגִּיעָה לְמֵאָה וְשִׁשִּׁים.",
            exampleNative = "מְהִירוּת скоростного поезда в Иерусалим достигает ста шестидесяти.",
         fillInBlankExclusions = listOf(185309L, 185310L)),
        WordEntity(
            id = 185309, setId = 1853, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "transport_l2_intercity",
            original = "הַמְתָּנָה", translation = "ожидание",
            transliteration = "хамтана",
            definition = "הַזְּמַן שֶׁבּוֹ נוֹסֵעַ עוֹמֵד בַּתַּחֲנָה עַד שֶׁהָאוֹטוֹבּוּס יַגִּיעַ.",
            definitionNative = "Время, которое пассажир стоит на остановке, пока подойдёт автобус.",
            example = "הַמְתָּנָה לָאוֹטוֹבּוּס הָאַחֲרוֹן בַּשַּׁבָּת אֲרֻכָּה בְּמְיֻחָד.",
            exampleNative = "הַמְתָּנָה последнего автобуса в субботу особенно долгая.",
         fillInBlankExclusions = listOf(185308L, 185310L)),
        WordEntity(
            id = 185310, setId = 1853, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "transport_l2_intercity",
            original = "הַקָּלָה", translation = "льгота, скидка",
            transliteration = "хакала",
            definition = "הוֹרָדַת מְחִיר אוֹ הֲטָבָה בַּתַּחְבּוּרָה לִגְמָלָאִים, חַיָּלִים וּסְטוּדֶנְטִים.",
            definitionNative = "Снижение цены или особая поблажка в транспорте для пенсионеров, солдат и студентов.",
            example = "הַקָּלָה שֶׁל חֲמִשִּׁים אָחוּז בַּכַּרְטִיס נִתֶּנֶת לְכָל גִּמְלַאי.",
            exampleNative = "הַקָּלָה в пятьдесят процентов от цены билета даётся всем пенсионерам.",
         fillInBlankExclusions = listOf(185308L, 185309L)),

        // ─── transport_l2_documents (5) ──────────────────────────────────
        WordEntity(
            id = 185311, setId = 1853, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "phrase", semanticGroup = "transport_l2_documents",
            original = "רִשְׁיוֹן נְהִיגָה", translation = "водительские права",
            transliteration = "ришьон неhига",
            definition = "מִסְמָךְ רִשְׁמִי שֶׁמַּתִּיר לָאָדָם לִנְהֹג בְּרֶכֶב פְּרָטִי בַּכְּבִישׁ.",
            definitionNative = "Официальный документ, что разрешает человеку водить машину по дорогам.",
            example = "חִדַּשְׁתִּי רִשְׁיוֹן נְהִיגָה בְּמִשְׂרַד הָרִשּׁוּי לִפְנֵי שְׁבוּעַיִם.",
            exampleNative = "Я обновил רִשְׁיוֹן נְהִיגָה в министерстве транспорта пару недель назад.",
         fillInBlankExclusions = listOf(185312L, 185313L)),
        WordEntity(
            id = 185312, setId = 1853, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "transport_l2_documents",
            original = "בִּטּוּחַ", translation = "страховка",
            transliteration = "битуах",
            definition = "תַּשְׁלוּם שָׁנָתִי שֶׁמְּכַסֶּה נֶזֶק לָרֶכֶב אוֹ פְּגִיעָה בַּתְּאוּנָה.",
            definitionNative = "Годовой платёж, что покрывает ущерб транспорту или травму при аварии.",
            example = "בִּטּוּחַ הָרֶכֶב הַשָּׁנָה עָלָה בְּמֵאָה שְׁקָלִים בְּגִלָל הָאִינְפְלַצְיָה.",
            exampleNative = "בִּטּוּחַ машины в этом году вырос на сто шекелей из-за инфляции.",
        ),
        WordEntity(
            id = 185313, setId = 1853, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "transport_l2_documents",
            original = "רִשּׁוּם", translation = "регистрация (авто)",
            transliteration = "ришум",
            definition = "תַּהֲלִיךְ רִשְׁמִי שֶׁל הַכְנָסַת רֶכֶב חָדָשׁ לְמַאֲגַר מִשְׂרַד הָרִשּׁוּי.",
            definitionNative = "Официальная процедура внесения новой машины в реестр министерства транспорта.",
            example = "רִשּׁוּם הָרֶכֶב הֶחָדָשׁ לוֹקֵחַ שָׁבוּעַ בְּמִשְׂרַד הָרִשּׁוּי.",
            exampleNative = "רִשּׁוּם новой машины занимает неделю в министерстве транспорта.",
         fillInBlankExclusions = listOf(185312L, 185314L, 185315L)),
        WordEntity(
            id = 185314, setId = 1853, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "transport_l2_documents",
            original = "טֶסְט", translation = "тест (годовой техосмотр)",
            transliteration = "тест",
            definition = "בְּדִיקָה שָׁנָתִית שֶׁל מַצַּב הָרֶכֶב לְפִי דְּרִישַׁת מִשְׂרַד הַתַּחְבּוּרָה.",
            definitionNative = "Годовая проверка состояния автомобиля по требованию министерства транспорта.",
            example = "עָבַרְתִּי טֶסְט שָׁנָתִי וְקִבַּלְתִּי תָּו יָרֹק בְּלִי הֶעָרוֹת.",
            exampleNative = "Я прошёл годовой טֶסְט и получил зелёный талон без единого замечания.",
         fillInBlankExclusions = listOf(185312L, 185313L, 185315L)),
        WordEntity(
            id = 185315, setId = 1853, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "transport_l2_documents",
            original = "מוֹסַךְ", translation = "автосервис, мастерская",
            transliteration = "мосах",
            definition = "מָקוֹם מִקְצוֹעִי שֶׁבּוֹ מְתַקְּנִים תַּקָּלוֹת בָּרֶכֶב וּמְבַצְּעִים טִפּוּלִים.",
            definitionNative = "Профессиональное место, где чинят поломки и проводят техобслуживание.",
            example = "הִשְׁאַרְתִּי אֶת הָרֶכֶב בַּמּוֹסַךְ עַד מָחָר אַחַר הַצָּהֳרַיִם.",
            exampleNative = "Я оставил машину в מוֹסַךְ до завтрашнего полудня для ремонта.",
        ),

        // ─── transport_l2_actions_advanced (5) ───────────────────────────
        WordEntity(
            id = 185316, setId = 1853, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "transport_l2_actions_advanced",
            original = "לְהַחֲלִיף", translation = "пересаживаться",
            transliteration = "леhахалиф",
            definition = "לָרֶדֶת מִכְּלִי תַּחְבּוּרָה אֶחָד וְלַעֲלוֹת לִכְלִי אַחֵר בְּאוֹתָהּ נְסִיעָה.",
            definitionNative = "Сойти с одного транспорта и сесть на другой в той же поездке.",
            example = "צָרִיךְ לְהַחֲלִיף לְקַו אַרְבָּעִים בַּתַּחֲנָה הַמֶּרְכָּזִית בִּיְרוּשָׁלַיִם.",
            exampleNative = "Надо לְהַחֲלִיף на сороковую линию на центральной станции в Иерусалиме.",
         fillInBlankExclusions = listOf(185317L, 185318L, 185319L, 185320L)),
        WordEntity(
            id = 185317, setId = 1853, languagePair = "he-ru", rarity = "RARE",
            pos = "verb", semanticGroup = "transport_l2_actions_advanced",
            original = "לְהִתְעַכֵּב", translation = "задерживаться",
            transliteration = "леhитъакев",
            definition = "לְאַחֵר בִּגְלַל פְּקָקִים, תַּקָּלָה אוֹ סִבָּה אַחֶרֶת בַּדֶּרֶךְ.",
            definitionNative = "Опаздывать из-за пробок, поломки или другой причины в дороге.",
            example = "הָאוֹטוֹבּוּס נֶאֱלַץ לְהִתְעַכֵּב חֲצִי שָׁעָה בִּגְלַל תְּאוּנָה בַּכְּבִישׁ.",
            exampleNative = "Автобус был вынужден לְהִתְעַכֵּב на полчаса из-за аварии на трассе.",
         fillInBlankExclusions = listOf(185316L, 185318L, 185319L, 185320L)),
        WordEntity(
            id = 185318, setId = 1853, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "transport_l2_actions_advanced",
            original = "לְפַסְפֵּס", translation = "пропустить (рейс)",
            transliteration = "лефасфес",
            definition = "לֹא לְהַסְפִּיק לַעֲלוֹת לָאוֹטוֹבּוּס אוֹ לָרַכֶּבֶת לִפְנֵי שֶׁהֵם יָצְאוּ.",
            definitionNative = "Не успеть сесть в автобус или поезд до того, как они уедут.",
            example = "אֲנִי לֹא רוֹצֶה לְפַסְפֵּס אֶת הָרַכֶּבֶת הָאַחֲרוֹנָה הַלַּיְלָה.",
            exampleNative = "Я не хочу לְפַסְפֵּס последний поезд сегодня ночью.",
        ),
        WordEntity(
            id = 185319, setId = 1853, languagePair = "he-ru", rarity = "RARE",
            pos = "verb", semanticGroup = "transport_l2_actions_advanced",
            original = "לְקַצֵּר", translation = "сократить (путь)",
            transliteration = "лекацер",
            definition = "לִבְחֹר מַסְלוּל קָצָר יוֹתֵר כְּדֵי לַחֲסֹךְ זְמַן בַּדֶּרֶךְ.",
            definitionNative = "Выбирать более короткий маршрут, чтобы экономить время в дороге.",
            example = "וֵייז הִצִּיעַ לִי לְקַצֵּר אֶת הַדֶּרֶךְ דֶּרֶךְ שְׁכוּנָה צִדִּית.",
            exampleNative = "Waze предложил мне לְקַצֵּר путь через боковой район города.",
         fillInBlankExclusions = listOf(185316L, 185317L, 185318L, 185320L)),
        WordEntity(
            id = 185320, setId = 1853, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "transport_l2_actions_advanced",
            original = "לִבְלֹם", translation = "тормозить",
            transliteration = "ливлом",
            definition = "לְהַפְעִיל אֶת הַבְּלָמִים כְּדֵי לְהַאֵט אוֹ לְהַפְסִיק אֶת הַנְּסִיעָה.",
            definitionNative = "Нажать на тормоза, чтобы замедлить или прекратить движение.",
            example = "הַנֶּהָג נֶאֱלַץ לִבְלֹם בְּחָזְקָה כְּשֶׁכֶּלֶב קָפַץ לַכְּבִישׁ.",
            exampleNative = "Водителю пришлось резко לִבְלֹם, когда собака выскочила на дорогу.",
         fillInBlankExclusions = listOf(185316L, 185317L, 185318L, 185319L)),

        // ─── transport_l2_advanced_terms (5) ─────────────────────────────
        WordEntity(
            id = 185321, setId = 1853, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "transport_l2_advanced_terms",
            original = "אֶגֶד", translation = "Эгед (автобусный кооператив)",
            transliteration = "эгед",
            definition = "חֶבְרַת הָאוֹטוֹבּוּסִים הַגְּדוֹלָה בְּיִשְׂרָאֵל שֶׁמַּפְעִילָה רֹב הַקַּוִּים.",
            definitionNative = "Крупнейшая автобусная компания Израиля, что обслуживает большинство линий.",
            example = "אֶגֶד מַפְעִיל אֶת קַו חֲמֵשׁ-מֵאוֹת מִתֵּל אָבִיב לִיְרוּשָׁלַיִם.",
            exampleNative = "אֶגֶד обслуживает пятисотую линию из Тель-Авива в Иерусалим.",
         fillInBlankExclusions = listOf(185323L, 185324L, 185325L)),
        WordEntity(
            id = 185322, setId = 1853, languagePair = "he-ru", rarity = "RARE",
            pos = "phrase", semanticGroup = "transport_l2_advanced_terms",
            original = "כְּבִישׁ הַחוֹף", translation = "приморская трасса (№2)",
            transliteration = "квиш hа-хоф",
            definition = "הַכְּבִישׁ הַמָּהִיר שֶׁל יִשְׂרָאֵל לְאֹרֶךְ חוֹף יָם הַתִּיכוֹן בֵּין תֵּל אָבִיב לְחֵיפָה.",
            definitionNative = "Скоростная трасса Израиля вдоль побережья Средиземного моря между городами.",
            example = "כְּבִישׁ הַחוֹף עָמוּס מְאֹד בִּימֵי שִׁשִּׁי אַחַר הַצָּהֳרַיִם.",
            exampleNative = "כְּבִישׁ הַחוֹף очень загружен по пятницам во второй половине дня.",
        ),
        WordEntity(
            id = 185323, setId = 1853, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "transport_l2_advanced_terms",
            original = "צָפוֹן", translation = "север",
            transliteration = "цафон",
            definition = "אֵזוֹר יִשְׂרָאֵל מִחֵיפָה וְעַד הַגְּבוּל הַלְּבָנוֹנִי, כִּוּוּן עַל הַמַּצְפֵּן.",
            definitionNative = "Регион Израиля от Хайфы до ливанской границы и направление по компасу.",
            example = "אֲנִי נוֹסֵעַ לַצָּפוֹן לְסוֹף שָׁבוּעַ אַרֹךְ עִם הַחֲבֵרִים שֶׁלִּי.",
            exampleNative = "Я еду на צָפוֹן на длинный уикенд с моими старыми друзьями.",
        ),
        WordEntity(
            id = 185324, setId = 1853, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "transport_l2_advanced_terms",
            original = "דָּרוֹם", translation = "юг",
            transliteration = "даром",
            definition = "אֵזוֹר יִשְׂרָאֵל מִבְּאֵר שֶׁבַע וְעַד אֵילַת, כִּוּוּן עַל הַמַּצְפֵּן.",
            definitionNative = "Регион Израиля от Беэр-Шевы до Эйлата и направление по компасу.",
            example = "הָרַכֶּבֶת לַדָּרוֹם עוֹבֶרֶת דֶּרֶךְ אַשְׁדּוֹד וְאַשְׁקְלוֹן בַּדֶּרֶךְ.",
            exampleNative = "Поезд на דָּרוֹם проходит через Ашдод и Ашкелон по пути.",
         fillInBlankExclusions = listOf(185321L, 185323L, 185325L)),
        WordEntity(
            id = 185325, setId = 1853, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "transport_l2_advanced_terms",
            original = "מֶרְכָּז", translation = "центр (страны)",
            transliteration = "мерказ",
            definition = "אֵזוֹר יִשְׂרָאֵל סְבִיב תֵּל אָבִיב — לֵב הַתַּעֲסוּקָה וְהַתַּחְבּוּרָה.",
            definitionNative = "Регион Израиля вокруг Тель-Авива — сердце занятости и транспорта.",
            example = "כָּל הַקַּוִּים הַבֵּין-עִירוֹנִיִּים נִפְגָּשִׁים בַּמֶּרְכָּז שֶׁל הַמְּדִינָה.",
            exampleNative = "Все междугородние линии встречаются в מֶרְכָּז страны Израиль.",
        ),
    )
}
