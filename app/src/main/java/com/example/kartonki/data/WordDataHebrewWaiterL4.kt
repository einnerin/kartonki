package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary: Waiter, level 4 (1 set, 25 words).
 * Профессиональная лексика опытного официанта премиум-ресторана:
 * винная карта, тонкости сервиса, работа с проблемными гостями,
 * банкетный сервис.
 *
 * Set 1720 (level 4, EPIC + LEGENDARY) — заполняет пробел между level 3 (1371)
 * и level 5 (1372, 1373) в теме «Официант».
 *
 * Не пересекается с уже существующими сетами темы «Официант»
 * (1369, 1370, 1371, 1372, 1373).
 *
 * Распределение редкостей: 15 EPIC + 10 LEGENDARY (2 смежных уровня).
 *
 * Пять подгрупп по 5 слов каждая:
 *   waiter_wine_pro            — винная карта и подача вина
 *   waiter_service_finesse     — тонкости профессионального сервиса
 *   waiter_difficult_guests    — работа с проблемными гостями
 *   waiter_banquet_pro         — банкетное обслуживание
 *   waiter_premium_etiquette   — этикет премиум-ресторана
 */
object WordDataHebrewWaiterL4 {

    val sets = listOf(
        WordSetEntity(
            id = 1720, languagePair = "he-ru", orderIndex = 1720,
            name = "Официант",
            description = "Винная карта, банкеты, проблемные гости, премиум-этикет",
            topic = "Официант", level = 4,
        ),
    )

    val words = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1720 — Официант: профессиональный (EPIC + LEGENDARY, C1–C2)
        // 5 групп × 5 слов
        // ══════════════════════════════════════════════════════════════════════

        // ── waiter_wine_pro (5) — винная карта и подача вина ──
        WordEntity(
            id = 172001, setId = 1720, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "waiter_wine_pro", transliteration = "dekanter",
            original = "דֵּיקַנְטֵר", translation = "декантер",
            definition = "כְּלִי זְכוּכִית רָחָב שֶׁבּוֹ מַעֲבִירִים אֶת הַמַּשְׁקֶה הָאָדֹם לְאִוְרוּר.",
            definitionNative = "Широкий стеклянный сосуд, куда переливают красное вино для аэрации.",
            example = "הַסּוֹמֵלְיֶר הוֹצִיא דֵּיקַנְטֵר לִפְנֵי שֶׁפָּתַח אֶת הַבַּקְבּוּק.",
            exampleNative = "Сомелье достал דֵּיקַנְטֵר прежде чем откупорить бутылку.",
            fillInBlankExclusions = listOf(172002L, 172003L, 172004L, 172005L)),
        WordEntity(
            id = 172002, setId = 1720, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "waiter_wine_pro", transliteration = "vintage",
            original = "וִינְטָאז'", translation = "винтаж, год урожая вина",
            definition = "שָׁנָה שֶׁבָּהּ נֶאֱסַף הָעֵנָב — מְצוּיֶּנֶת עַל הַתָּו וּמַשְׁפִּיעָה עַל אֵיכוּת.",
            definitionNative = "Год сбора винограда — пишется на этикетке и влияет на качество напитка.",
            example = "הָאוֹרֵחַ שָׁאַל מָה הַוִינְטָאז' שֶׁל הַבַּקְבּוּק עַל הַשֻּׁלְחָן.",
            exampleNative = "Гость спросил, какой וִינְטָאז' у бутылки на столе.",
            fillInBlankExclusions = listOf(172001L, 172003L, 172004L, 172005L)),
        WordEntity(
            id = 172003, setId = 1720, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "waiter_wine_pro", transliteration = "temperaturat hagasha",
            original = "טַמְפֵּרָטוּרַת הַגָּשָׁה", translation = "температура подачи (вина)",
            definition = "מִדַּת הַחֹם הַמֻּמְלֶצֶת לִכְלוֹל בָּהּ מַשְׁקֶה כְּדֵי לְהַבְלִיט אֶת הַטַּעַם.",
            definitionNative = "Рекомендуемый градус напитка, при котором его вкус раскрывается лучше всего.",
            example = "טַמְפֵּרָטוּרַת הַגָּשָׁה שֶׁל לָבָן הִיא בְּסָבִיב שְׁמוֹנֶה מַעֲלוֹת.",
            exampleNative = "טַמְפֵּרָטוּרַת הַגָּשָׁה для белого — около восьми градусов.",
            fillInBlankExclusions = listOf(172001L, 172002L, 172004L, 172005L)),
        WordEntity(
            id = 172004, setId = 1720, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "waiter_wine_pro", transliteration = "bdikat pkak",
            original = "בְּדִיקַת פְּקָק", translation = "проверка пробки на дефекты",
            definition = "הַבְחָנָה בְּרֵיחַ הַמַּגְנֵטָה כְּדֵי לְוַדֵּא שֶׁהַמַּשְׁקֶה לֹא הִתְקַלְקֵל.",
            definitionNative = "Проверка корка по запаху, чтобы убедиться: напиток не испорчен.",
            example = "בְּדִיקַת פְּקָק נַעֲשֵׂית תָּמִיד לִפְנֵי הַמְּזִיגָה לָאוֹרֵחַ.",
            exampleNative = "בְּדִיקַת פְּקָק всегда делают до того, как наливают гостю.",
            fillInBlankExclusions = listOf(172001L, 172002L, 172003L, 172005L)),
        WordEntity(
            id = 172005, setId = 1720, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "waiter_wine_pro", transliteration = "mezigat someliyer",
            original = "מְזִיגַת סוֹמֵלְיֶר", translation = "профессиональное наливание сомелье",
            definition = "טֶכְנִיקָה מְדֻיֶּקֶת שֶׁל יְצִיקַת מַשְׁקֶה בְּזָוִית קְבוּעָה וּבְקֶצֶב מְבֻקָּר.",
            definitionNative = "Точная техника подачи напитка под фиксированным углом и в выверенном темпе.",
            example = "מְזִיגַת סוֹמֵלְיֶר נֶעֱשֵׂית בְּשֶׁקֶט בְּלִי לְגַעַת בַּזְּכוּכִית.",
            exampleNative = "מְזִיגַת סוֹמֵלְיֶר идёт бесшумно, без касания горлышка о бокал.",
            fillInBlankExclusions = listOf(172001L, 172002L, 172003L, 172004L)),

        // ── waiter_service_finesse (5) — тонкости сервиса ──
        WordEntity(
            id = 172006, setId = 1720, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "waiter_service_finesse", transliteration = "hagasha sinkhronit",
            original = "הַגָּשָׁה סִינְכְרוֹנִית", translation = "синхронная подача блюд",
            definition = "כָּל הַצַּלָּחוֹת מַגִּיעוֹת לַשֻּׁלְחָן בְּאוֹתוֹ רֶגַע — מֻנָּחוֹת בְּיַחַד.",
            definitionNative = "Все тарелки приходят на стол в один и тот же момент — ставят их вместе.",
            example = "צֶוֶת שֶׁל אַרְבָּעָה מֶלְצָרִים מַבְטִיחַ הַגָּשָׁה סִינְכְרוֹנִית לְשִׁשָּׁה אוֹרְחִים.",
            exampleNative = "Бригада из четырёх обеспечивает הַגָּשָׁה סִינְכְרוֹנִית на шестерых гостей.",
            fillInBlankExclusions = listOf(172007L, 172008L, 172009L, 172010L)),
        WordEntity(
            id = 172007, setId = 1720, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "waiter_service_finesse", transliteration = "ketsev hagasha",
            original = "קֶצֶב הַגָּשָׁה", translation = "темп подачи блюд",
            definition = "הַזְּמַן בֵּין מָנָה לְמָנָה — לֹא מָהִיר מִדַּי וְלֹא אִטִּי שֶׁמַּרְגִּיז.",
            definitionNative = "Промежутки между блюдами — не слишком быстрые и не настолько долгие, что раздражают.",
            example = "קֶצֶב הַגָּשָׁה הוּתְאַם לִשִׂיחָה אֲרֻכָּה שֶׁל הַזּוּג לְיַד הַחַלּוֹן.",
            exampleNative = "קֶצֶב הַגָּשָׁה подстроили под долгий разговор пары у окна.",
            fillInBlankExclusions = listOf(172006L, 172008L, 172009L, 172010L)),
        WordEntity(
            id = 172008, setId = 1720, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "waiter_service_finesse", transliteration = "pinui hashulkhan",
            original = "פִּינּוּי הַשֻּׁלְחָן", translation = "расчистка стола между блюдами",
            definition = "אִסּוּף שָׁקֵט שֶׁל צַלָּחוֹת רֵיקוֹת וּמַפִּיּוֹת לִפְנֵי הַמָּנָה הַבָּאָה.",
            definitionNative = "Тихий сбор пустых тарелок и салфеток, прежде чем выйдет следующая перемена.",
            example = "פִּינּוּי הַשֻּׁלְחָן בּוּצַע בְּלִי לְהַפְרִיעַ לַשִּׂיחָה.",
            exampleNative = "פִּינּוּי הַשֻּׁלְחָן прошёл, не прерывая беседу за столом.",
            fillInBlankExclusions = listOf(172006L, 172007L, 172009L, 172010L)),
        WordEntity(
            id = 172009, setId = 1720, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "waiter_service_finesse", transliteration = "tfisat siniya",
            original = "תְּפִיסַת סִינִיָּה", translation = "техника удержания подноса",
            definition = "אֲחִיזָה יַצִּיבָה עַל הַיָּד הַשְּׂמָאלִית שֶׁמַּשְׁאִירָה אֶת הַיְּמָנִית פְּנוּיָה.",
            definitionNative = "Стабильный хват на левой руке, оставляющий правую свободной для подачи.",
            example = "תְּפִיסַת סִינִיָּה נְכוֹנָה מוֹנַעַת תְּאוּנוֹת בִּשְׁעוֹת הָעֹמֶס.",
            exampleNative = "Правильная תְּפִיסַת סִינִיָּה предотвращает ЧП в часы пик.",
            fillInBlankExclusions = listOf(172006L, 172007L, 172008L, 172010L)),
        WordEntity(
            id = 172010, setId = 1720, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "waiter_service_finesse", transliteration = "hastarat tav",
            original = "הַסְתָּרַת תָּו", translation = "сокрытие ценника при подаче",
            definition = "הַגָּשַׁת בַּקְבּוּק כָּךְ שֶׁהַמְּחִיר אֵינוֹ נֶחְשָׂף לִשְׁאָר הַסּוֹעֲדִים.",
            definitionNative = "Подача бутылки так, чтобы цена не показывалась остальным сидящим за столом.",
            example = "הַסְתָּרַת תָּו חוֹסֶכֶת מָבוּכָה בִּפְגִישׁוֹת עִסְקִיּוֹת.",
            exampleNative = "הַסְתָּרַת תָּו избавляет от неловкости на деловых встречах.",
            fillInBlankExclusions = listOf(172006L, 172007L, 172008L, 172009L)),

        // ── waiter_difficult_guests (5) — работа с проблемными гостями ──
        WordEntity(
            id = 172011, setId = 1720, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "waiter_difficult_guests", transliteration = "tluna kharifa",
            original = "תְּלוּנָה חֲרִיפָה", translation = "острая жалоба",
            definition = "אִי-שְׂבִיעוּת רָצוֹן חָזָקָה מְאוֹד שֶׁדּוֹרֶשֶׁת תְּגוּבָה מִיָּדִית מֵהַצֶּוֶת.",
            definitionNative = "Очень сильное недовольство, требующее немедленной реакции от персонала.",
            example = "תְּלוּנָה חֲרִיפָה הַגִּיעָה לַמְנַהֵל לִפְנֵי שֶׁהָאוֹכֶל הַתְקָרֵר.",
            exampleNative = "תְּלוּנָה חֲרִיפָה долетела до управляющего, ещё пока еда не остыла.",
            fillInBlankExclusions = listOf(172012L, 172013L, 172014L, 172015L)),
        WordEntity(
            id = 172012, setId = 1720, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "waiter_difficult_guests", transliteration = "ir'ur al kheshbon",
            original = "עִרְעוּר עַל חֶשְׁבּוֹן", translation = "оспаривание счёта",
            definition = "מַחְלוֹקֶת עַל סְכוּם הַתַּשְׁלוּם — לָקוֹחַ טוֹעֵן שֶׁמַשֶּׁהוּ נֶחְשָׁב לֹא נָכוֹן.",
            definitionNative = "Спор о сумме в чеке — гость утверждает, что что-то посчитали неверно.",
            example = "עִרְעוּר עַל חֶשְׁבּוֹן נִפְתָּר אַחֲרֵי שֶׁהַמַּלְצָר הִדְפִּיס פֵּרוּט מְחוּדָּשׁ.",
            exampleNative = "עִרְעוּר עַל חֶשְׁבּוֹן закрыли после того, как официант распечатал детализацию.",
            fillInBlankExclusions = listOf(172011L, 172013L, 172014L, 172015L)),
        WordEntity(
            id = 172013, setId = 1720, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "waiter_difficult_guests", transliteration = "i-haga'a",
            original = "אִי-הַגָּעָה", translation = "неявка по брони (no-show)",
            definition = "מַצָּב שֶׁבּוֹ הָאוֹרֵחַ הִזְמִין שֻׁלְחָן וְלֹא הוֹפִיעַ וְלֹא בִּטֵּל.",
            definitionNative = "Когда гость зарезервировал столик, но не пришёл и не отменил заранее.",
            example = "אִי-הַגָּעָה בְּעֶרֶב סוֹף שָׁבוּעַ עוֹלָה לַמִּסְעָדָה הַרְבֵּה כֶּסֶף.",
            exampleNative = "אִי-הַגָּעָה в выходной вечер обходится ресторану дорого.",
            fillInBlankExclusions = listOf(172011L, 172012L, 172014L, 172015L)),
        WordEntity(
            id = 172014, setId = 1720, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "waiter_difficult_guests", transliteration = "pitsui lako'akh",
            original = "פִּצּוּי לָקוֹחַ", translation = "компенсация недовольному гостю",
            definition = "מַתָּן שֵׁרוּת אוֹ מָנָה בְּחִנָּם כְּדֵי לְפַיֵּס מִישֶׁהוּ שֶׁנִּפְגַּע מֵהָעַסֵּק.",
            definitionNative = "Услуга или блюдо за счёт заведения, чтобы загладить впечатление у обиженного.",
            example = "פִּצּוּי לָקוֹחַ הִקְפִּיא תְּלוּנָה שֶׁהָיְתָה נוֹסַעַת לַסּוֹשִׁיאל.",
            exampleNative = "פִּצּוּי לָקוֹחַ остановил жалобу, которая едва не ушла в соцсети.",
            fillInBlankExclusions = listOf(172011L, 172012L, 172013L, 172015L)),
        WordEntity(
            id = 172015, setId = 1720, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "waiter_difficult_guests", transliteration = "ta'ana legitimit",
            original = "טַעֲנָה לְגִיטִימִית", translation = "обоснованная претензия",
            definition = "טִעוּן שֶׁל הָאוֹרֵחַ שֶׁבּוֹ צוֹדְקִים — מַשֶּׁהוּ אֵכָן הָיָה לֹא בְּסֵדֶר.",
            definitionNative = "Аргумент гостя, в котором он действительно прав — что-то и впрямь было плохо.",
            example = "טַעֲנָה לְגִיטִימִית לְגַבֵּי בָּשָׂר חַי הוֹבִילָה לְהַחְלָפָה מִיָּדִית.",
            exampleNative = "טַעֲנָה לְגִיטִימִית про сырое мясо повлекла мгновенную замену блюда.",
            fillInBlankExclusions = listOf(172011L, 172012L, 172013L, 172014L)),

        // ── waiter_banquet_pro (5) — банкетное обслуживание ──
        WordEntity(
            id = 172016, setId = 1720, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "waiter_banquet_pro", transliteration = "tafrit sagur",
            original = "תַּפְרִיט סְגוּר", translation = "фиксированное меню банкета",
            definition = "רְשִׁימַת מָנוֹת קְבוּעָה לְכָל הַסּוֹעֲדִים — בְּלִי בְּחִירָה אִישִׁית.",
            definitionNative = "Заданный набор блюд на всех — без индивидуального выбора по карточке.",
            example = "תַּפְרִיט סְגוּר לַחֲתֻנָּה כָּלַל אַרְבַּע מָנוֹת וִיּוֹצְרוּ קְבוּצָתִי.",
            exampleNative = "תַּפְרִיט סְגוּר на свадьбе включал четыре перемены и десерт-фуршет.",
            fillInBlankExclusions = listOf(172017L, 172018L, 172019L, 172020L)),
        WordEntity(
            id = 172017, setId = 1720, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "waiter_banquet_pro", transliteration = "svav hagasha",
            original = "סְבַב הַגָּשָׁה", translation = "круг подачи (по столам)",
            definition = "מַסְלוּל קָבוּעַ שֶׁבּוֹ הַצֶּוֶת מְחַלֵּק אוֹתָהּ הַמָּנָה לְכָל הַסּוֹעֲדִים.",
            definitionNative = "Заданный маршрут, по которому бригада разносит одну и ту же перемену всем.",
            example = "סְבַב הַגָּשָׁה רִאשׁוֹן יָצָא בְּדִיּוּק בִּשְׁמוֹנֶה בָּעֶרֶב.",
            exampleNative = "Первый סְבַב הַגָּשָׁה стартовал ровно в восемь вечера.",
            fillInBlankExclusions = listOf(172016L, 172018L, 172019L, 172020L)),
        WordEntity(
            id = 172018, setId = 1720, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "waiter_banquet_pro", transliteration = "pre-pleyting",
            original = "פְּרֵה-פְּלֵיטִינְג", translation = "пред-сервировка тарелок",
            definition = "סִדּוּר אוֹכֶל עַל צַלָּחוֹת בַּמִּטְבָּח עוֹד לִפְנֵי שֶׁהָאוֹרְחִים יוֹשְׁבִים.",
            definitionNative = "Раскладывание еды по тарелкам на кухне ещё до того, как гости садятся за стол.",
            example = "פְּרֵה-פְּלֵיטִינְג חָסַךְ עֲשָׂרָה דַּקּוֹת בַּסְּבָב הָרִאשׁוֹן.",
            exampleNative = "פְּרֵה-פְּלֵיטִינְג сэкономил десять минут на первой подаче.",
            fillInBlankExclusions = listOf(172016L, 172017L, 172019L, 172020L)),
        WordEntity(
            id = 172019, setId = 1720, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "waiter_banquet_pro", transliteration = "aspakat petit-four",
            original = "אַסְפָּקַת פֶּטִיט-פוּר", translation = "разнос мини-десертов",
            definition = "סִבּוּב אַחֲרוֹן עִם מִתוֹקִים זְעִירִים — לַפֶּה שֶׁמְּחַכֶּה לַקָּפֶה.",
            definitionNative = "Финальный обход с миниатюрными сладостями — к кофе после основного.",
            example = "אַסְפָּקַת פֶּטִיט-פוּר סִכֶּנָה אֶת הָעֶרֶב יָפֶה.",
            exampleNative = "אַסְפָּקַת פֶּטִיט-פוּר красиво завершила вечер для всех столиков.",
            fillInBlankExclusions = listOf(172016L, 172017L, 172018L, 172020L)),
        WordEntity(
            id = 172020, setId = 1720, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "waiter_banquet_pro", transliteration = "prisat mezalgot",
            original = "פְּרִיסַת מְזַלְּגוֹת", translation = "раскладка приборов перед банкетом",
            definition = "סִדּוּר מְדֻיָּק שֶׁל סַכּוּ״ם בַּשֻּׁלְחָן לְפִי סֵדֶר הַמָּנוֹת הַצָּפוּי.",
            definitionNative = "Точная расстановка приборов на столе по порядку будущих перемен.",
            example = "פְּרִיסַת מְזַלְּגוֹת לְבַנְקֶט גְּדוֹלָה אוֹרֶכֶת שָׁעָה בְּמוּחָץ.",
            exampleNative = "פְּרִיסַת מְזַלְּגוֹת на большой банкет занимает в среднем час.",
            fillInBlankExclusions = listOf(172016L, 172017L, 172018L, 172019L)),

        // ── waiter_premium_etiquette (5) — этикет премиум-ресторана ──
        WordEntity(
            id = 172021, setId = 1720, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "waiter_premium_etiquette", transliteration = "birkat kabalat panim",
            original = "בִּרְכַּת קַבָּלַת פָּנִים", translation = "приветствие гостей при входе",
            definition = "מִלִּים קָצָרוֹת וְחִיּוּךְ שֶׁמְּקַדְּמִים בָּהֶם אֶת הַבָּאִים בַּפֶּתַח.",
            definitionNative = "Короткие слова и улыбка, которыми встречают входящих в зале у двери.",
            example = "בִּרְכַּת קַבָּלַת פָּנִים נֶאֱמְרָה תָּמִיד בִּשְׁתֵּי שָׂפוֹת לַתַּיָּרִים.",
            exampleNative = "בִּרְכַּת קַבָּלַת פָּנִים звучала на двух языках для туристов всегда.",
            fillInBlankExclusions = listOf(172022L, 172023L, 172024L, 172025L)),
        WordEntity(
            id = 172022, setId = 1720, languagePair = "he-ru", rarity = "EPIC",
            pos = "phrase", semanticGroup = "waiter_premium_etiquette", transliteration = "birkat preda",
            original = "בִּרְכַּת פְּרֵדָה", translation = "прощание с уходящими гостями",
            definition = "מִלִּים אֲדִיבוֹת בַּדֶּלֶת בְּסוֹף הָאֵירוּחַ — הַזְמָנָה לַחֲזֹר.",
            definitionNative = "Учтивые слова на выходе в конце визита — приглашение прийти ещё.",
            example = "בִּרְכַּת פְּרֵדָה לַזּוּג הַמְבֻגָּר הָיְתָה חַמָּה וְלֹא נְמוּסִית.",
            exampleNative = "בִּרְכַּת פְּרֵדָה для пожилой пары прозвучала тепло, не казённо.",
            fillInBlankExclusions = listOf(172021L, 172023L, 172024L, 172025L)),
        WordEntity(
            id = 172023, setId = 1720, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "waiter_premium_etiquette", transliteration = "merkhak miktso'i",
            original = "מֶרְחָק מְקֻצָּעִי", translation = "профессиональная дистанция с гостем",
            definition = "אִזּוּן בֵּין נִעוּמָה אֲדִיבָה לְבֵין סְפֵרָה אִישִׁית שֶׁל הַסּוֹעֵד.",
            definitionNative = "Баланс между приветливостью и личным пространством сидящего за столом.",
            example = "מֶרְחָק מְקֻצָּעִי נִשְׁמָר גַּם כְּשֶׁהָאוֹרֵחַ נִסָּה לְהֵיוֹת חָבֵר.",
            exampleNative = "מֶרְחָק מְקֻצָּעִי сохранили, хотя гость пытался перейти на дружеский тон.",
            fillInBlankExclusions = listOf(172021L, 172022L, 172024L, 172025L)),
        WordEntity(
            id = 172024, setId = 1720, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "waiter_premium_etiquette", transliteration = "pe'ulot bediskretsia",
            original = "פָּעוֹלוֹת בְּדִיסְקְרֶצְיָה", translation = "действия с тактом, незаметно",
            definition = "פְּעֻלּוֹת קְטַנּוֹת שֶׁל הַצֶּוֶת שֶׁנַּעֲשׂוֹת בְּלִי לִמְשֹׁךְ תְּשׂוּמַת לֵב.",
            definitionNative = "Маленькие действия персонала, выполняемые так, чтобы их не замечали.",
            example = "פָּעוֹלוֹת בְּדִיסְקְרֶצְיָה אִפְשְׁרוּ לַחָבֵר לְהַפְתִּיעַ אֶת בַּת הַזּוּג בְּטַבַּעַת.",
            exampleNative = "פָּעוֹלוֹת בְּדִיסְקְרֶצְיָה позволили мужчине незаметно поднести кольцо.",
            fillInBlankExclusions = listOf(172021L, 172022L, 172023L, 172025L)),
        WordEntity(
            id = 172025, setId = 1720, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "phrase", semanticGroup = "waiter_premium_etiquette", transliteration = "te'ima rishmit",
            original = "טָעִימָה רִשְׁמִית", translation = "формальная дегустация (для одобрения)",
            definition = "טֶקֶס קָצָר שֶׁבּוֹ הָאוֹרֵחַ טוֹעֵם וּמְאַשֵּׁר אֶת הַבַּקְבּוּק לִפְנֵי הַמְּזִיגָה לְכֻלָּם.",
            definitionNative = "Краткий ритуал, в котором гость пробует и одобряет напиток до общего разлива.",
            example = "טָעִימָה רִשְׁמִית הִתְבַּצְּעָה עַל פִּי כָּל הַכְּלָלִים הַמְּקֻבָּלִים.",
            exampleNative = "טָעִימָה רִשְׁמִית прошла строго по всем принятым правилам.",
            fillInBlankExclusions = listOf(172021L, 172022L, 172023L, 172024L)),
    )
}
