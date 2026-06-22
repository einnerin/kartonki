package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — set 1899 (he-ru).
 * Финансы: рынки капитала и инвестиции (L4 / RARE + EPIC).
 *
 * Зеркало en-ru set 468. Расширение темы «Финансы».
 * Подтема — финансовые рынки, ценные бумаги и инвестиции
 * (Тель-Авивская биржа TASE, акции, облигации, деривативы).
 * НЕ розничная банковская лексика (FinanceV2, Batch51, Batch56).
 *
 * Четыре семантические группы:
 *   finance_markets_instruments   — נְיָר עֵרֶךְ, קֶרֶן נֶאֱמָנוּת, תְּעוּדוֹת סַל,
 *                                   נִגְזָר, אוֹפְּצְיָה, חוֹזֶה עָתִידִי,
 *                                   קְרַן גִּידּוּר
 *   finance_markets_events        — שׁוּק שׁוֹר, שׁוּק דּוֹב, דִּיבִידֶנְד,
 *                                   מְכִירָה בַּחֲסֵר, מִינּוּף, גִּידּוּר,
 *                                   אַרְבִּיטְרָז׳, סְפֵקוּלַצְיָה
 *   finance_markets_participants  — בְּרוֹקֶר, סוֹחֵר, חַתָּם, עוֹשֵׂה שׁוּק,
 *                                   הָרְשׁוּת לְנְיָרוֹת עֵרֶךְ
 *   finance_markets_metrics       — נְזִילוּת, תְּנוּדָתִיוּת, מַכְפִּיל רֶוַח,
 *                                   פִּיזוּר תִּיק, קַצַב סִיכּוּן
 *
 * Из шорт-листа исключены дубли (4 слова):
 *   - מְנָיָה          (акция)         — UrbanLifeL4
 *   - אִגֶּרֶת חוֹב     (облигация)     — UrbanLifeL4
 *   - הַנְפָּקָה       (IPO/эмиссия)   — HightechL5
 *   - תְּשׁוּאָה       (доходность)    — Batch81
 *
 * Word IDs: 189901..189925 (setId × 100 + position).
 */
object WordDataHebrewFinanceMarkets {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1899, languagePair = "he-ru", orderIndex = 1899,
            name = "Финансы",
            description = "Рынки капитала и инвестиции: ценные бумаги, деривативы, биржевые игроки и метрики — נְיָר עֵרֶךְ, אוֹפְּצְיָה, בְּרוֹקֶר, מַכְפִּיל רֶוַח",
            topic = "Финансы",
            level = 4,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: finance_markets_instruments (7 words) ──────────────────────

        WordEntity(id = 189901, setId = 1899, languagePair = "he-ru", rarity = "RARE",
            original = "נְיָר עֵרֶךְ",
            translation = "ценная бумага",
            definition = "מִסְמָךְ פִינַנְסִי סָחִיר שֶׁמּוֹכִיחַ בַּעֲלוּת אוֹ זְכוּת לְקַבֵּל תַּשְׁלוּם בַּעֲתִיד.",
            definitionNative = "Торгуемый финансовый документ, подтверждающий владение или право на получение платежа в будущем.",
            example = "הַבַּנְק מַחֲזִיק מִילְיוֹנֵי דּוֹלָר נְיָר עֵרֶךְ לְלָקוֹחוֹתָיו.",
            exampleNative = "Банк держит на миллионы долларов נְיָר עֵרֶךְ своих клиентов.",
            pos = "phrase", semanticGroup = "finance_markets_instruments"),

        WordEntity(id = 189902, setId = 1899, languagePair = "he-ru", rarity = "RARE",
            original = "קֶרֶן נֶאֱמָנוּת",
            translation = "паевой инвестфонд",
            definition = "מַאֲגַר כְּסָפִים מִמַּשְׁקִיעִים רַבִּים שֶׁמְּנַהֵל מִקְצוֹעִי קוֹנֶה בּוֹ מְנָיוֹת וְאִגְּרוֹת לְכוּלָּם.",
            definitionNative = "Объединённые деньги многих вкладчиков; профессионал покупает на них акции и облигации для всех.",
            example = "אַבָּא שָׂם אֶת הַחִיסָּכוֹן בְּקֶרֶן נֶאֱמָנוּת זוֹלָה וְכִמְעַט לֹא בָּדַק שָׁנִים.",
            exampleNative = "Папа положил сбережения в дешёвый קֶרֶן נֶאֱמָנוּת и почти не заглядывал туда годами.",
            pos = "phrase", semanticGroup = "finance_markets_instruments", fillInBlankExclusions = listOf(189901L, 189903L, 189906L, 189907L)),

        WordEntity(id = 189903, setId = 1899, languagePair = "he-ru", rarity = "RARE",
            original = "תְּעוּדוֹת סַל",
            translation = "биржевой фонд (ETF)",
            definition = "סַל נְכָסִים נִסְחָר בְּבּוּרְסָה כְּמוֹ מְנָיָה בּוֹדֶדֶת, לְרֹב עוֹקֵב אַחֲרֵי מַדָּד.",
            definitionNative = "Корзина активов, торгуемая на бирже как одна бумага; чаще всего следует за индексом.",
            example = "מַתְחִיל חָכָם פּוֹתֵחַ עִם תְּעוּדוֹת סַל רְחָבוֹת וְרַק אַחַר כָּךְ בּוֹחֵר מְנָיוֹת.",
            exampleNative = "Грамотный новичок начинает с широких תְּעוּדוֹת סַל и только потом берётся за отдельные акции.",
            pos = "phrase", semanticGroup = "finance_markets_instruments", fillInBlankExclusions = listOf(189901L, 189902L, 189906L, 189907L)),

        WordEntity(id = 189904, setId = 1899, languagePair = "he-ru", rarity = "EPIC",
            original = "נִגְזָר",
            translation = "дериватив",
            definition = "מַכְשִׁיר פִינַנְסִי שֶׁעֶרְכּוֹ נִשְׁעָן עַל מְחִיר נֶכֶס אַחֵר — מַטְבֵּעַ, סְחוֹרָה אוֹ מַדָּד.",
            definitionNative = "Финансовый инструмент, стоимость которого опирается на цену другого актива — валюты, сырья или индекса.",
            example = "כָּל נִגְזָר בְּתִיק שֶׁל הַסּוֹחֵר מְכַסֶּה סִיכּוּן שֶׁל פּוֹזִיצְיָה אַחֶרֶת.",
            exampleNative = "Каждый נִגְזָר в портфеле трейдера прикрывает риск другой позиции.",
            pos = "noun", semanticGroup = "finance_markets_instruments", fillInBlankExclusions = listOf(189905L, 189906L)),

        WordEntity(id = 189905, setId = 1899, languagePair = "he-ru", rarity = "RARE",
            original = "אוֹפְּצְיָה",
            translation = "опцион",
            definition = "זְכוּת בִּתְשׁלוּם — בְּלִי חוֹבָה — לִקְנוֹת אוֹ לִמְכֹּר נֶכֶס בִּמְחִיר קָבוּעַ עַד תַּאֲרִיךְ מוּסְכָּם.",
            definitionNative = "Платное право, но не обязанность, купить или продать актив по фиксированной цене до условленной даты.",
            example = "הוּא קָנָה אוֹפְּצְיָה זוֹלָה עַל מְנָיַת אֶפֶּל וְהִרְוִיחַ הוֹן קָטָן כְּשֶׁעָלְתָה.",
            exampleNative = "Он купил дешёвый אוֹפְּצְיָה на акцию Apple и заработал небольшое состояние, когда та взлетела.",
            pos = "noun", semanticGroup = "finance_markets_instruments", fillInBlankExclusions = listOf(189904L)),

        WordEntity(id = 189906, setId = 1899, languagePair = "he-ru", rarity = "RARE",
            original = "חוֹזֶה עָתִידִי",
            translation = "фьючерсный контракт",
            definition = "הֶסְכֵּם לִקְנוֹת אוֹ לִמְכֹּר נֶכֶס בִּמְחִיר קָבוּעַ בְּתַאֲרִיךְ מוּסְכָּם בַּעֲתִיד.",
            definitionNative = "Соглашение купить или продать актив по фиксированной цене в условленную дату в будущем.",
            example = "חַקְלָאֵי חִיטָּה נוֹעֲלִים מְחִיר דֶּרֶךְ חוֹזֶה עָתִידִי לִפְנֵי שֶׁזּוֹרְעִים בָּאָבִיב.",
            exampleNative = "Фермеры-зерновики фиксируют цену через חוֹזֶה עָתִידִי ещё до весеннего сева.",
            pos = "phrase", semanticGroup = "finance_markets_instruments", fillInBlankExclusions = listOf(189901L, 189902L, 189903L, 189904L, 189907L)),

        WordEntity(id = 189907, setId = 1899, languagePair = "he-ru", rarity = "EPIC",
            original = "קְרַן גִּידּוּר",
            translation = "хедж-фонд",
            definition = "קֶרֶן הַשְׁקָעוֹת אֲגְרֶסִיבִית לְמִשְׁקִיעִים אֲמִידִים — מַשְׁתַּמֶּשֶׁת בְּמִינּוּף, שׁוֹרְט וְנִגְזָרִים.",
            definitionNative = "Агрессивный инвестфонд для состоятельных клиентов — пользуется плечом, шортом и деривативами.",
            example = "קְרַן גִּידּוּר אַחַת הִרְוִיחָה מִילְיַארְדִּים בַּמַּשְׁבֵּר שֶׁל 2008.",
            exampleNative = "Один קְרַן גִּידּוּר заработал миллиарды на кризисе 2008-го.",
            pos = "phrase", semanticGroup = "finance_markets_instruments", fillInBlankExclusions = listOf(189901L, 189902L, 189903L, 189906L)),

        // ── Group: finance_markets_events (8 words) ───────────────────────────

        WordEntity(id = 189908, setId = 1899, languagePair = "he-ru", rarity = "RARE",
            original = "שׁוּק שׁוֹר",
            translation = "бычий рынок",
            definition = "תְּקוּפָה מְמֻשֶּׁכֶת שֶׁל עֲלִיַּת מְחִירִים בַּבּוּרְסָה וְאוֹפְּטִימִיּוּת רְחָבָה בֵּין הַמַּשְׁקִיעִים.",
            definitionNative = "Продолжительный период роста цен на бирже и широкого оптимизма среди инвесторов.",
            example = "שׁוּק שׁוֹר אָרֹךְ הִכְפִּיל אֶת חֶסְכוֹנוֹתֵיהֶם בְּתוֹךְ שָׁלוֹשׁ שָׁנִים בִּלְבָד.",
            exampleNative = "Долгий שׁוּק שׁוֹר удвоил их сбережения всего за три года.",
            pos = "phrase", semanticGroup = "finance_markets_events", fillInBlankExclusions = listOf(189909L, 189911L)),

        WordEntity(id = 189909, setId = 1899, languagePair = "he-ru", rarity = "RARE",
            original = "שׁוּק דּוֹב",
            translation = "медвежий рынок",
            definition = "תְּקוּפָה מְמֻשֶּׁכֶת שֶׁל יְרִידַת מְחִירִים בַּבּוּרְסָה — עָשׂוּי לֶאֱרֹךְ חוֹדָשִׁים אוֹ שָׁנִים.",
            definitionNative = "Продолжительный период падения цен на бирже — может растянуться на месяцы или годы.",
            example = "שׁוּק דּוֹב בִּשְׁנַת 2022 מָחַק שָׁלִישׁ מִשּׁוֹוִי תִּיק הָאוֹפְצְיוֹת שֶׁלָּהּ.",
            exampleNative = "שׁוּק דּוֹב 2022 года стёр треть стоимости её опционного портфеля.",
            pos = "phrase", semanticGroup = "finance_markets_events", fillInBlankExclusions = listOf(189908L, 189911L)),

        WordEntity(id = 189910, setId = 1899, languagePair = "he-ru", rarity = "RARE",
            original = "דִּיבִידֶנְד",
            translation = "дивиденд",
            definition = "תַּשְׁלוּם בְּמָזוּמָן שֶׁחֶבְרָה מְחַלֶּקֶת לְבַעֲלֵי הַמְּנָיוֹת מֵרֶוַח, לְרֹב פַּעֲמַיִם אוֹ אַרְבַּע פְּעָמִים בְּשָׁנָה.",
            definitionNative = "Денежная выплата, которую компания распределяет акционерам из прибыли — обычно два или четыре раза в год.",
            example = "חֲבָרוֹת קוֹמוּנָלִיוֹת מְשַׁלְּמוֹת דִּיבִידֶנְד גָּבוֹהַּ וּמְכַסּוֹת אוֹתוֹ מִתִּזְרִים יַצִּיב.",
            exampleNative = "Коммунальные компании платят высокий דִּיבִידֶנְד и закрывают его стабильным денежным потоком.",
            pos = "noun", semanticGroup = "finance_markets_events", fillInBlankExclusions = listOf(189912L, 189913L, 189914L, 189915L)),

        WordEntity(id = 189911, setId = 1899, languagePair = "he-ru", rarity = "RARE",
            original = "מְכִירָה בַּחֲסֵר",
            translation = "короткая продажа",
            definition = "שְׁאִילַת נֶכֶס, מְכִירָתוֹ עַכְשָׁו וּקְנִיָּתוֹ בַּחֲזָרָה אַחַר כָּךְ — רוֹוֵחַ רַק אִם הַמְּחִיר יוֹרֵד.",
            definitionNative = "Заём актива, его немедленная продажа и обратный выкуп позже — прибыльно только при падении цены.",
            example = "סוֹחֲרֵי קְרַן גִּידּוּר עָשׂוּ מְכִירָה בַּחֲסֵר עַל בַּנְקֵי 2008 וְהִרְוִיחוּ הוֹן.",
            exampleNative = "Трейдеры хедж-фонда сделали מְכִירָה בַּחֲסֵר на банки в 2008 и заработали состояние.",
            pos = "phrase", semanticGroup = "finance_markets_events", fillInBlankExclusions = listOf(189908L, 189909L, 189915L)),

        WordEntity(id = 189912, setId = 1899, languagePair = "he-ru", rarity = "RARE",
            original = "מִינּוּף",
            translation = "финансовый рычаг",
            definition = "שִׁמּוּשׁ בְּכֶסֶף שָׁאוּל כְּדֵי לְהַגְדִּיל פּוֹזִיצְיָה — מַגְבִּיר רֶוַח אֲבָל גַּם הֶפְסֵד.",
            definitionNative = "Использование заёмных денег для увеличения позиции — усиливает и прибыль, и потери.",
            example = "מִינּוּף שֶׁל פִּי עֲשָׂרָה הָפַךְ הֶפְסֵד קָטָן לְחוֹב עָצוּם מוּל הַבְּרוֹקֶר.",
            exampleNative = "מִינּוּף в десять раз превратил небольшую потерю в огромный долг перед брокером.",
            pos = "noun", semanticGroup = "finance_markets_events", fillInBlankExclusions = listOf(189910L, 189913L, 189914L, 189915L)),

        WordEntity(id = 189913, setId = 1899, languagePair = "he-ru", rarity = "EPIC",
            original = "גִּידּוּר",
            translation = "хеджирование",
            definition = "פְּעוּלָה לְצִמְצוּם סִיכּוּן — פּוֹתְחִים פּוֹזִיצְיָה הֲפוּכָה בְּנֶכֶס אַחֵר שֶׁמְּפַצֶּה עַל הֶפְסֵד אֶפְשָׁרִי.",
            definitionNative = "Действие по снижению риска — открывают встречную позицию в другом активе, перекрывающую возможные потери.",
            example = "יְצוּאָנִים יִשְׂרְאֵלִים עוֹשִׂים גִּידּוּר עַל הַדּוֹלָר כְּדֵי לְהָגֵן עַל הָרֶוַח.",
            exampleNative = "Израильские экспортёры делают גִּידּוּר по доллару, чтобы защитить прибыль.",
            pos = "noun", semanticGroup = "finance_markets_events", fillInBlankExclusions = listOf(189910L, 189912L, 189914L, 189915L)),

        WordEntity(id = 189914, setId = 1899, languagePair = "he-ru", rarity = "EPIC",
            original = "אַרְבִּיטְרָז׳",
            translation = "арбитраж",
            definition = "רֶוַח חֲסַר סִיכּוּן מִקְּנִיָּה וּמְכִירָה בּוֹ-זְמַנִּית שֶׁל אוֹתוֹ נֶכֶס בִּשְׁנֵי שְׁוָקִים בִּמְחִירִים שׁוֹנִים.",
            definitionNative = "Безрисковая прибыль от одновременной покупки и продажи одного и того же актива на двух рынках по разной цене.",
            example = "אַלְגוֹרִיתְמִים מָהִירִים סוֹגְרִים כָּל אַרְבִּיטְרָז׳ קָטָן בְּתוֹךְ אַלְפִּיּוֹת שְׁנִיָּה.",
            exampleNative = "Быстрые алгоритмы закрывают любой мелкий אַרְבִּיטְרָז׳ за миллисекунды.",
            pos = "noun", semanticGroup = "finance_markets_events"),

        WordEntity(id = 189915, setId = 1899, languagePair = "he-ru", rarity = "EPIC",
            original = "סְפֵקוּלַצְיָה",
            translation = "спекуляция",
            definition = "קְנִיָּה וּמְכִירָה מְהִירוֹת וּמְסֻכָּנוֹת לְמַטָּרַת רֶוַח קָצָר מִתְּנוּדוֹת מְחִירִים, וְלֹא מֵעֵרֶךְ אֲרֻכָּת טְוָח.",
            definitionNative = "Быстрая рискованная купля-продажа ради короткой прибыли от колебаний цен, а не от долгой стоимости.",
            example = "סְפֵקוּלַצְיָה טְהוֹרָה מַנִּיעָה רֹב גַּלֵּי הַקְּרִיפְּטוֹ — וְלָכֵן הַנְּפִילוֹת כֹּה חַדּוֹת.",
            exampleNative = "Чистая סְפֵקוּלַצְיָה двигает большинство криптоволн — потому-то обвалы и бьют так больно.",
            pos = "noun", semanticGroup = "finance_markets_events", fillInBlankExclusions = listOf(189910L, 189911L, 189912L, 189913L, 189914L)),

        // ── Group: finance_markets_participants (5 words) ─────────────────────

        WordEntity(id = 189916, setId = 1899, languagePair = "he-ru", rarity = "RARE",
            original = "בְּרוֹקֶר",
            translation = "брокер",
            definition = "מְתַוֵּךְ מוּסְמָךְ שֶׁמַּעֲבִיר הוֹרָאוֹת קְנִיָּה אוֹ מְכִירָה שֶׁל נְיָר עֵרֶךְ בְּשֵׁם הַלָּקוֹחַ.",
            definitionNative = "Сертифицированный посредник, передающий приказы на покупку или продажу ценных бумаг от имени клиента.",
            example = "הַבְּרוֹקֶר שֶׁלָּהּ הִתְקַשֵּׁר בַּבֹּקֶר עִם טִיפּ חַם.",
            exampleNative = "Её בְּרוֹקֶר позвонил утром с горячей наводкой.",
            pos = "noun", semanticGroup = "finance_markets_participants", fillInBlankExclusions = listOf(189917L, 189918L)),

        WordEntity(id = 189917, setId = 1899, languagePair = "he-ru", rarity = "RARE",
            original = "סוֹחֵר",
            translation = "трейдер",
            definition = "אָדָם שֶׁמִּתְפַּרְנֵס מִקְּנִיָּה וּמְכִירָה שֶׁל נְכָסִים — לְעִיתִּים עֲשָׂרוֹת עִסְקוֹת בְּיוֹם.",
            definitionNative = "Человек, зарабатывающий на купле-продаже активов — порой десятки сделок за день.",
            example = "סוֹחֵר שָׂרוּף מִוּוֹל סְטְרִיט פָּרַשׁ בְּגִיל שְׁלוֹשִׁים וּשְׁתַּיִם וְפָתַח מַאֲפִיָּה.",
            exampleNative = "Выгоревший סוֹחֵר с Уолл-стрит уволился в тридцать два и открыл пекарню.",
            pos = "noun", semanticGroup = "finance_markets_participants", fillInBlankExclusions = listOf(189916L, 189918L)),

        WordEntity(id = 189918, setId = 1899, languagePair = "he-ru", rarity = "EPIC",
            original = "חַתָּם",
            translation = "андеррайтер",
            definition = "גּוּף שֶׁמְּלַוֶּה הַנְפָּקַת נְיָר עֵרֶךְ — קוֹבֵעַ מְחִיר וְעָרֵב לַחֲבָרָה שֶׁתִּמָּכֵר כָּל הַכַּמּוּת.",
            definitionNative = "Организация, сопровождающая выпуск ценных бумаг — назначает цену и гарантирует фирме продажу всего объёма.",
            example = "הַחַתָּם דָּחָה אֶת הָהַנְפָּקָה בְּחֹדֶשׁ כְּשֶׁהַשּׁוּק הִתְקָרֵר.",
            exampleNative = "חַתָּם отложил эмиссию на месяц, когда рынок остыл.",
            pos = "noun", semanticGroup = "finance_markets_participants", fillInBlankExclusions = listOf(189916L, 189917L)),

        WordEntity(id = 189919, setId = 1899, languagePair = "he-ru", rarity = "EPIC",
            original = "עוֹשֵׂה שׁוּק",
            translation = "маркет-мейкер",
            definition = "פִירְמָה שֶׁמְּצַטֶּטֶת תָּמִיד מְחִיר קְנִיָּה וּמְחִיר מְכִירָה — מַחְזִיקָה אֶת הַמִּסְחָר חָלָק גַּם בְּשָׁעוֹת רְגוּעוֹת.",
            definitionNative = "Фирма, постоянно выставляющая встречные цены покупки и продажи — держит торги плавными даже в тихие часы.",
            example = "בְּלִי עוֹשֵׂה שׁוּק הַמִּרְוָוחִים הָיוּ קוֹפְצִים פִּי שָׁלוֹשׁ.",
            exampleNative = "Без עוֹשֵׂה שׁוּק спреды подскочили бы втрое.",
            pos = "phrase", semanticGroup = "finance_markets_participants", fillInBlankExclusions = listOf(189920L, 189921L)),

        WordEntity(id = 189920, setId = 1899, languagePair = "he-ru", rarity = "EPIC",
            original = "הָרְשׁוּת לִנְיָרוֹת עֵרֶךְ",
            translation = "регулятор биржи",
            definition = "גּוּף מַמְלַכְתִּי שֶׁכּוֹתֵב חוּקֵי בּוּרְסָה, מְפַקֵּחַ עַל חֲבָרוֹת וּמַטִּיל קְנָסוֹת עַל מַפְרֵי כְּלָלִים.",
            definitionNative = "Госорган, пишущий биржевые законы, надзирающий за компаниями и штрафующий нарушителей правил.",
            example = "הָרְשׁוּת לִנְיָרוֹת עֵרֶךְ קָנְסָה אֶת הַחֶבְרָה עַל זִיּוּף.",
            exampleNative = "הָרְשׁוּת לְנְיָרוֹת עֵרֶךְ оштрафовала компанию за подлог.",
            pos = "phrase", semanticGroup = "finance_markets_participants"),

        // ── Group: finance_markets_metrics (5 words) ──────────────────────────

        WordEntity(id = 189921, setId = 1899, languagePair = "he-ru", rarity = "RARE",
            original = "נְזִילוּת",
            translation = "ликвидность",
            definition = "מִדַּת הַקַּלּוּת שֶׁבָּהּ אֶפְשָׁר לִמְכֹּר נֶכֶס מַהֵר וּבְלִי לְהַפְסִיד הַרְבֵּה עַל הַמְּחִיר.",
            definitionNative = "Мера того, насколько легко продать актив быстро и без больших потерь в цене.",
            example = "מְנָיוֹת קְטַנּוֹת סוֹבְלוֹת מִנְּזִילוּת נְמוּכָה וְצָרִיךְ הַרְבֵּה זְמַן כְּדֵי לְצֵאת.",
            exampleNative = "Мелкие акции страдают от низкой נְזִילוּת — на выход нужна уйма времени.",
            pos = "noun", semanticGroup = "finance_markets_metrics"),

        WordEntity(id = 189922, setId = 1899, languagePair = "he-ru", rarity = "EPIC",
            original = "תְּנוּדָתִיּוּת",
            translation = "волатильность",
            definition = "מִדַּת הַתְּנוּעָה הַחַדָּה שֶׁל מְחִיר נֶכֶס סְבִיב מְמֻצָּעוֹ — גָּבוֹהַּ סִיכּוּן, גָּבוֹהַּ סִיכּוּי.",
            definitionNative = "Мера резкости колебаний цены актива вокруг среднего значения — выше риск, выше шанс прибыли.",
            example = "תְּנוּדָתִיּוּת בִּקְרִיפְּטוֹ קוֹפֶצֶת בַּלַּיְלָה וְהוֹפֶכֶת שֵׁנָה לְלִחַץ דָּם.",
            exampleNative = "תְּנוּדָתִיּוּת на крипте взлетает ночью и превращает сон в скачок давления.",
            pos = "noun", semanticGroup = "finance_markets_metrics", fillInBlankExclusions = listOf(189921L)),

        WordEntity(id = 189923, setId = 1899, languagePair = "he-ru", rarity = "EPIC",
            original = "מַכְפִּיל רֶוַח",
            translation = "коэффициент цена/прибыль",
            definition = "מְחִיר הַמְּנָיָה חָלוּק בָּרֶוַח הַשְּׁנָתִי לִמְנָיָה אַחַת — מַרְאֶה כַּמָּה מְשַׁלְּמִים עַל שֶׁקֶל אֶחָד שֶׁל הַכְנָסָה.",
            definitionNative = "Цена акции, делённая на её годовой доход — показывает, сколько платят за один шекель заработка компании.",
            example = "מְנָיוֹת טֶק נִסְחָרוֹת בְּמַכְפִּיל רֶוַח שֶׁל חֲמִישִּׁים.",
            exampleNative = "Технологические акции торгуются с מַכְפִּיל רֶוַח около пятидесяти.",
            pos = "phrase", semanticGroup = "finance_markets_metrics", fillInBlankExclusions = listOf(189924L, 189925L)),

        WordEntity(id = 189924, setId = 1899, languagePair = "he-ru", rarity = "RARE",
            original = "פִּיזוּר תִּיק",
            translation = "диверсификация портфеля",
            definition = "חֲלוּקַת הַכֶּסֶף בֵּין נְכָסִים רַבִּים וְלֹא קְשׁוּרִים — כָּךְ פּוֹזִיצְיָה אַחַת לֹא מוֹחֶקֶת הַכֹּל.",
            definitionNative = "Распределение денег между множеством несвязанных активов — чтобы одна позиция не уничтожила всё.",
            example = "פִּיזוּר תִּיק נָכוֹן הִצִּיל אֶת הַפֶּנְסְיָה שֶׁלָּהּ בָּעֵת מַשְׁבֵּר.",
            exampleNative = "Грамотный פִּיזוּר תִּיק спас её пенсию в кризис.",
            pos = "phrase", semanticGroup = "finance_markets_metrics", fillInBlankExclusions = listOf(189923L, 189925L)),

        WordEntity(id = 189925, setId = 1899, languagePair = "he-ru", rarity = "EPIC",
            original = "קַצַב סִיכּוּן",
            translation = "премия за риск",
            definition = "תּוֹסֶפֶת תְּשׁוּאָה שֶׁמַּשְׁקִיעִים דּוֹרְשִׁים עַל נֶכֶס מְסֻכָּן מֵעַל לְנֶכֶס בָּטוּחַ כְּמוֹ אִיגֶּרֶת מְדִינָה.",
            definitionNative = "Прибавка к доходности, которую инвесторы требуют за рискованный актив сверх безопасного, например государственной облигации.",
            example = "קַצַב סִיכּוּן בִּשְׁוָקִים מִתְפַּתְּחִים הִתְכַּוֵּץ שָׁנִים וְאָז הִתְפּוֹצֵץ בַּמִּלְחָמָה.",
            exampleNative = "קַצַב סִיכּוּן развивающихся рынков годами сжимался, а потом взорвался во время войны.",
            pos = "phrase", semanticGroup = "finance_markets_metrics", fillInBlankExclusions = listOf(189923L, 189924L)),
    )
}
