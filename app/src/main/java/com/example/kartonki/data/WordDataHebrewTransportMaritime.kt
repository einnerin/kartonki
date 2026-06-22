package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — set 1898 (he-ru).
 * Транспорт: морской и водный — суда, части корпуса, порт, навигация
 * (L3 / UNCOMMON + RARE).
 *
 * Расширение темы «Транспорт». Зеркало en-ru set 467 (морской транспорт).
 * Тема отделена от:
 *   - «Транспорт в Израиле» (TransportV2, IsraeliTransportL1..L5) — общественный
 *      и наземный городской транспорт;
 *   - «Моряк» (Batch74 sets 1468..1472) — лексика моряка как профессии: экипаж,
 *      право, метео, аварии, классификация по конвенциям.
 *
 * Четыре семантические группы:
 *   transport_maritime_vessels      — מַעֲבוֹרֶת, יָאכְטָה, קָטָמָרָן, גוֹרֶרֶת,
 *                                      קָנוֹאֶה, מִכָלִית, סִירַת מָנוֹעַ
 *   transport_maritime_parts        — סִיפוּן, תּוֹרֶן, עוֹגֶן, מַדְחֵף, מַשּׁוֹט,
 *                                      בָּלָסְט
 *   transport_maritime_port         — מַסְפֵּנָה, מִגְדַּלוֹר, מָצוֹף, מַזָּח,
 *                                      אַסְדָה, שׁוֹבֵר גַּלִּים, מַעְגָּן יָאכְטוֹת
 *   transport_maritime_navigation   — נִיווּט, הַפְלָגָה, גֵּאוּת וְשֵׁפֶל,
 *                                      תְּעַלָה, עֲגִינָה
 *
 * Из шорт-листа исключены дубли (13 слов):
 *   - סְפִינָה        (судно) — Batch74, TransportV2
 *   - אֳנִיָּה         (корабль) — TransportV2
 *   - סִירָה          (лодка) — Batch5
 *   - מַעֲגָן         (пристань) — IsraeliTransportL5
 *   - צוֹלֶלֶת        (подлодка) — IsraeliTransportL5
 *   - קַיָּק           (каяк) — Batch5
 *   - מִפְרָשׂ         (парус) — Batch5, Batch74
 *   - הֶגֶה            (руль) — Batch74, TransportV2 и др.
 *   - חַרְטוֹם        (нос корабля) — IsraeliTransportL5
 *   - יַרְכָּתַיִם     (корма) — IsraeliTransportL5
 *   - אֶשְׁנָב         (иллюминатор) — UrbanLifeL2
 *   - נָמֵל            (порт) — Batch57
 *   - מֶזַח           (пирс) — Batch5
 *   - רָצִיף          (причал) — IsraeliTransportL1, TransportV2
 *   - קֶשֶׁר           (узел) — Batch63 (нашейный смысл)
 *
 * Word IDs: 189801..189825 (setId × 100 + position).
 */
object WordDataHebrewTransportMaritime {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1898, languagePair = "he-ru", orderIndex = 1898,
            name = "Транспорт",
            description = "Морской транспорт: суда, оснастка, порт и навигация — מַעֲבוֹרֶת, עוֹגֶן, מִגְדַּלוֹר, הַפְלָגָה",
            topic = "Транспорт",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: transport_maritime_vessels (7 words) ───────────────────────

        WordEntity(id = 189801, setId = 1898, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַעֲבוֹרֶת",
            translation = "паром",
            definition = "כְּלִי שַׁיִט גָּדוֹל הַמַּעֲבִיר נוֹסְעִים וּמְכוֹנִיּוֹת בֵּין שְׁתֵּי גְּדוֹת מַיִם.",
            definitionNative = "Большое плавсредство, перевозящее пассажиров и машины между двумя берегами водоёма.",
            example = "הַמַּעֲבוֹרֶת מֵחֵיפָה לְקַפְרִיסִין יוֹצֵאת בְּכָל בֹּקֶר.",
            exampleNative = "מַעֲבוֹרֶת из Хайфы на Кипр отходит каждое утро.",
            pos = "noun", semanticGroup = "transport_maritime_vessels"),

        WordEntity(id = 189802, setId = 1898, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "יָאכְטָה",
            translation = "яхта",
            definition = "סְפִינַת פְּנַאי קְטַנָּה אוֹ בֵּינוֹנִית, לְרֹב פְּרָטִית, לְהַפְלָגָה לְשֵׁם תַּעֲנוּג.",
            definitionNative = "Малое или среднее прогулочное судно, обычно частное, для морских прогулок ради удовольствия.",
            example = "הַמִּילְיוֹנֵר מַחֲזִיק יָאכְטָה בִּמְפַרְץ הֶרְצְלִיָּה.",
            exampleNative = "Миллионер держит יָאכְטָה в марине Герцлии.",
            pos = "noun", semanticGroup = "transport_maritime_vessels", fillInBlankExclusions = listOf(189801L, 189803L, 189804L, 189805L, 189806L)),

        WordEntity(id = 189803, setId = 1898, languagePair = "he-ru", rarity = "RARE",
            original = "קָטָמָרָן",
            translation = "катамаран",
            definition = "כְּלִי שַׁיִט בַּעַל שְׁנֵי גּוּפִים מַקְבִּילִים, יַצִּיב יוֹתֵר וּמָהִיר מִסְּפִינָה רְגִילָה.",
            definitionNative = "Плавсредство с двумя параллельными корпусами; устойчивее и быстрее обычного судна.",
            example = "טִיּוּל קָטָמָרָן בְּאֵילָת מַתְאִים לְמִשְׁפָּחוֹת עִם יְלָדִים קְטַנִּים.",
            exampleNative = "Прогулка на קָטָמָרָן в Эйлате подходит семьям с маленькими детьми.",
            pos = "noun", semanticGroup = "transport_maritime_vessels", fillInBlankExclusions = listOf(189801L, 189802L, 189804L, 189805L, 189806L)),

        WordEntity(id = 189804, setId = 1898, languagePair = "he-ru", rarity = "RARE",
            original = "גּוֹרֶרֶת",
            translation = "буксир",
            definition = "סְפִינָה חֲזָקָה שֶׁמּוֹשֶׁכֶת אוֹ דּוֹחֶפֶת כְּלֵי שַׁיִט גְּדוֹלִים אֶל הַמַּזָּח אוֹ מִמֶּנּוּ.",
            definitionNative = "Мощное небольшое судно; тянет или толкает крупные плавсредства к пирсу или от него.",
            example = "שְׁתֵּי גּוֹרֶרֶת הִכְנִיסוּ אֶת אֳנִיַּת הַמְּכוֹלוֹת לְנָמֵל אַשְׁדּוֹד.",
            exampleNative = "Две גּוֹרֶרֶת завели контейнеровоз в порт Ашдода.",
            pos = "noun", semanticGroup = "transport_maritime_vessels", fillInBlankExclusions = listOf(189801L, 189802L, 189803L, 189805L, 189806L)),

        WordEntity(id = 189805, setId = 1898, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קָנוֹאֶה",
            translation = "каноэ",
            definition = "סִירָה קַלָּה וְצָרָה לְאָדָם אֶחָד אוֹ שְׁנַיִם, חוֹתְרִים בָּהּ בְּאֶמְצַע מַיִם רְגוּעִים.",
            definitionNative = "Лёгкое узкое плавсредство на одного-двух; гребут в нём по спокойной воде.",
            example = "בְּקַיִץ הַיַּלְדִים שׁוֹכְרִים קָנוֹאֶה עַל הַיַּרְקוֹן בְּתֵל אָבִיב.",
            exampleNative = "Летом ребята берут קָנוֹאֶה напрокат на Яркон в Тель-Авиве.",
            pos = "noun", semanticGroup = "transport_maritime_vessels", fillInBlankExclusions = listOf(189801L, 189802L, 189803L, 189804L, 189806L)),

        WordEntity(id = 189806, setId = 1898, languagePair = "he-ru", rarity = "RARE",
            original = "מִכָלִית",
            translation = "танкер",
            definition = "כְּלִי שַׁיִט גָּדוֹל לְהוֹבָלַת נוֹזְלִים בְּכַמּוּת עֲצוּמָה — לְרֹב נֵפְט אוֹ גַּז.",
            definitionNative = "Крупное судно для перевозки жидкостей в больших объёмах — чаще нефти или газа.",
            example = "מִכָּלִית עֲנָקִית פָּרְקָה דֶּלֶק בַּמָּסוֹף שֶׁל אַשְׁקְלוֹן.",
            exampleNative = "Огромный מִכָלִית разгружал топливо на терминале Ашкелона.",
            pos = "noun", semanticGroup = "transport_maritime_vessels", fillInBlankExclusions = listOf(189801L, 189802L, 189803L, 189804L, 189805L)),

        WordEntity(id = 189807, setId = 1898, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סִירַת מָנוֹעַ",
            translation = "моторная лодка",
            definition = "כְּלִי שַׁיִט קָטָן עִם מָנוֹעַ מָהִיר, מוּעָדָף לְמַסַּע קָצָר אוֹ סְפּוֹרְט מַיִם.",
            definitionNative = "Малое плавсредство с быстрым двигателем; удобно для коротких выездов и водного спорта.",
            example = "הַמַּצִּילִים פַּטְרוֹלוּ אֶת הַחוֹף בְּסִירַת מָנוֹעַ אֲדֻמָּה.",
            exampleNative = "Спасатели объехали пляж на красной סִירַת מָנוֹעַ.",
            pos = "phrase", semanticGroup = "transport_maritime_vessels"),

        // ── Group: transport_maritime_parts (6 words) ─────────────────────────

        WordEntity(id = 189808, setId = 1898, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סִיפוּן",
            translation = "палуба",
            definition = "מִשְׁטָח עֶלְיוֹן וְשָׁטוּחַ שֶׁל סְפִינָה, שָׁם הוֹלְכִים נוֹסְעִים וְצֶוֶת.",
            definitionNative = "Верхняя плоская площадка плавсредства; по ней ходят пассажиры и команда.",
            example = "אַחֲרֵי הָאֲרוּחָה יָצָאנוּ לַסִּיפוּן לִרְאוֹת אֶת הַשְּׁקִיעָה.",
            exampleNative = "После ужина мы вышли на סִיפוּן полюбоваться закатом.",
            pos = "noun", semanticGroup = "transport_maritime_parts"),

        WordEntity(id = 189809, setId = 1898, languagePair = "he-ru", rarity = "RARE",
            original = "תּוֹרֶן",
            translation = "мачта",
            definition = "עַמּוּד אָרֹךְ וְזָקוּף עַל סְפִינָה, נוֹשֵׂא מִפְרָשִׂים אוֹ אַנְטֶנּוֹת.",
            definitionNative = "Длинный вертикальный столб на корабле; держит паруса или антенны.",
            example = "הַסּוּפָה שָׁבְרָה אֶת הַתּוֹרֶן וְהַצֶּוֶת חָזַר עִם מָנוֹעַ בִּלְבַד.",
            exampleNative = "Шторм сломал תּוֹרֶן, и команда вернулась только на двигателе.",
            pos = "noun", semanticGroup = "transport_maritime_parts", fillInBlankExclusions = listOf(189808L, 189810L, 189811L, 189812L, 189813L)),

        WordEntity(id = 189810, setId = 1898, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "עוֹגֶן",
            translation = "якорь",
            definition = "מַתֶּכֶת כְּבֵדָה עַל שַׁרְשֶׁרֶת, שׁוֹמֶרֶת סְפִינָה בִּמְקוֹמָהּ עַל קַרְקַעִית הַיָּם.",
            definitionNative = "Тяжёлый металл на цепи; удерживает плавсредство на месте, зацепившись за дно.",
            example = "הַקַּפִּיטָן הוֹרִיד עוֹגֶן בְּמִפְרָץ שָׁקֵט לְלִינַת לַיְלָה.",
            exampleNative = "Капитан опустил עוֹגֶן в тихой бухте для ночёвки.",
            pos = "noun", semanticGroup = "transport_maritime_parts", fillInBlankExclusions = listOf(189808L, 189809L, 189811L, 189812L, 189813L)),

        WordEntity(id = 189811, setId = 1898, languagePair = "he-ru", rarity = "RARE",
            original = "מַדְחֵף",
            translation = "винт / пропеллер",
            definition = "גַּלְגַּל בַּעַל לַהֲבִים מִתְפּוֹחֲחִים שֶׁמְּקַדֵּם סְפִינָה אוֹ מָטוֹס בְּדַחְפוֹ אֶת הַמַּיִם אוֹ הָאֲוִיר.",
            definitionNative = "Колесо с косыми лопастями; продвигает судно или самолёт, отбрасывая воду или воздух назад.",
            example = "צוֹלְלָנִים מָצְאוּ חֶבֶל מְסֻבָּךְ עַל הַמַּדְחֵף שֶׁל הַסְּפִינָה.",
            exampleNative = "Дайверы нашли запутавшийся канат на מַדְחֵף судна.",
            pos = "noun", semanticGroup = "transport_maritime_parts"),

        WordEntity(id = 189812, setId = 1898, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מָשׁוֹט",
            translation = "весло",
            definition = "מַקֵּל אָרֹךְ עִם לַהַב שָׁטוּחַ בַּקָּצֶה; דּוֹחֲפִים בּוֹ סִירָה דֶּרֶךְ הַמַּיִם.",
            definitionNative = "Длинная палка с плоской лопастью на конце; ею толкают лодку сквозь воду.",
            example = "סַבָּא לִמֵּד אוֹתִי לֶאֱחֹז בַּמַּשּׁוֹט בִּשְׁתֵּי יָדַיִם בְּלִי לִשְׁבֹּר אֶת הַמַּיִם.",
            exampleNative = "Дед учил меня держать מָשׁוֹט двумя руками и не хлопать им по воде.",
            pos = "noun", semanticGroup = "transport_maritime_parts"),

        WordEntity(id = 189813, setId = 1898, languagePair = "he-ru", rarity = "RARE",
            original = "בָּלָסְט",
            translation = "балласт",
            definition = "מִשְׁקָל כָּבֵד — לְרֹב מַיִם אוֹ חוֹל — שֶׁשָּׂמִים בְּתַחְתִּית סְפִינָה לַיַּצִּיבוּת.",
            definitionNative = "Тяжёлый груз — обычно вода или песок — закладывают в нижнюю часть судна для устойчивости.",
            example = "לִפְנֵי הַסּוּפָה הַצֶּוֶת מִלֵּא אֶת מֵכָלֵי הַבָּלָסְט בְּמֵי יָם.",
            exampleNative = "Перед штормом команда залила баки בָּלָסְט морской водой.",
            pos = "noun", semanticGroup = "transport_maritime_parts", fillInBlankExclusions = listOf(189808L, 189809L, 189810L, 189811L, 189812L)),

        // ── Group: transport_maritime_port (7 words) ──────────────────────────

        WordEntity(id = 189814, setId = 1898, languagePair = "he-ru", rarity = "RARE",
            original = "מִסְפָּנָה",
            translation = "верфь",
            definition = "מִתְקָן גָּדוֹל עַל חוֹף הַיָּם שֶׁבּוֹ בּוֹנִים, מְתַקְּנִים אוֹ מְפָרְקִים סְפִינוֹת.",
            definitionNative = "Большая береговая площадка, где строят, чинят или разбирают плавсредства.",
            example = "מִסְפָּנָה בְּחֵיפָה בּוֹנָה סְפִינוֹת לִדְיָג בְּמֶשֶׁךְ דּוֹרוֹת.",
            exampleNative = "מִסְפָּנָה в Хайфе строит рыболовные суда уже несколько поколений.",
            pos = "noun", semanticGroup = "transport_maritime_port", fillInBlankExclusions = listOf(189815L, 189816L, 189817L, 189818L)),

        WordEntity(id = 189815, setId = 1898, languagePair = "he-ru", rarity = "RARE",
            original = "מִגְדַּלּוֹר",
            translation = "маяк",
            definition = "מִגְדָּל גָּבוֹהַּ עַל הַחוֹף הַשּׁוֹלֵחַ אוֹר חָזָק כְּדֵי לְהַזְהִיר סְפִינוֹת מִסְּלָעִים בַּחֲשֵׁכָה.",
            definitionNative = "Высокая прибрежная башня; её сильный свет предупреждает плавсредства о скалах ночью.",
            example = "הַמִּגְדַּלוֹר בִּסְלָעֵי קֵיסַרְיָה דּוֹלֵק כָּל לַיְלָה.",
            exampleNative = "מִגְדַּלּוֹר на скалах Кесарии горит каждую ночь.",
            pos = "noun", semanticGroup = "transport_maritime_port"),

        WordEntity(id = 189816, setId = 1898, languagePair = "he-ru", rarity = "RARE",
            original = "מָצוֹף",
            translation = "буй",
            definition = "כַּדּוּר צָף הָעָגוּן לְקַרְקַעִית, מְסַמֵּן לְמַלָּחִים תְּעָלָה, שִׂרְטוֹן אוֹ אֵזוֹר שְׁחִיָּה.",
            definitionNative = "Плавающий шар, закреплённый ко дну; показывает морякам фарватер, мель или зону купания.",
            example = "סִירַת הַמַּצִּילִים תָּפְרָה חֶבֶל לַמָּצוֹף הַצָּהֹב.",
            exampleNative = "Лодка спасателей привязала верёвку к жёлтому מָצוֹף.",
            pos = "noun", semanticGroup = "transport_maritime_port"),

        WordEntity(id = 189817, setId = 1898, languagePair = "he-ru", rarity = "RARE",
            original = "מֵזַח",
            translation = "пирс",
            definition = "מִבְנֶה אָרֹךְ הַנִּכְנָס לְתוֹךְ הַמַּיִם, סְפִינוֹת קוֹשְׁרוֹת אוֹתוֹ לְהַעֲמָסָה אוֹ הוֹרָדָה.",
            definitionNative = "Длинное сооружение, уходящее в воду; к нему швартуются суда для погрузки и высадки.",
            example = "הַנּוֹסְעִים מַמְתִּינִים עַל הַמַּזָּח עִם הַמִּזְוָדוֹת.",
            exampleNative = "Пассажиры ждут на מֵזַח с чемоданами.",
            pos = "noun", semanticGroup = "transport_maritime_port"),

        WordEntity(id = 189818, setId = 1898, languagePair = "he-ru", rarity = "RARE",
            original = "אַסְדָּה",
            translation = "плот / понтон",
            definition = "מִשְׁטָח צָף שָׁטוּחַ — לֹא סְפִינָה — שׁוֹאֲבִים אוֹתוֹ אוֹ עוֹגְנִים אוֹתוֹ לְהוֹבָלַת מִטְעָן.",
            definitionNative = "Плоская плавающая площадка; не самоходная — её тянут или ставят на якорь для перевозки грузов.",
            example = "פּוֹעֲלֵי הַנָּמֵל הֶעֱבִירוּ צִינּוֹר עָנָק עַל אַסְדָּה רְחָבָה.",
            exampleNative = "Портовые рабочие переправили огромную трубу на широкой אַסְדָּה.",
            pos = "noun", semanticGroup = "transport_maritime_port", fillInBlankExclusions = listOf(189814L, 189815L, 189816L, 189817L)),

        WordEntity(id = 189819, setId = 1898, languagePair = "he-ru", rarity = "RARE",
            original = "שׁוֹבֵר גַּלִּים",
            translation = "волнорез",
            definition = "קִיר מֵאֶבֶן אוֹ בֵּטוֹן בַּיָּם, חוֹסֵם גַּלִּים גְּדוֹלִים וְשׁוֹמֵר עַל הַנָּמֵל רָגוּעַ.",
            definitionNative = "Каменная или бетонная стена в море; гасит крупные волны и держит порт спокойным.",
            example = "צְעִירִים יוֹשְׁבִים עַל שׁוֹבֵר גַּלִּים בְּתֵל אָבִיב וּמְזַמְּרִים בַּלַּיְלָה.",
            exampleNative = "Молодёжь сидит на שׁוֹבֵר גַּלִּים в Тель-Авиве и поёт по вечерам.",
            pos = "phrase", semanticGroup = "transport_maritime_port", fillInBlankExclusions = listOf(189820L)),

        WordEntity(id = 189820, setId = 1898, languagePair = "he-ru", rarity = "RARE",
            original = "מַעְגָּן יָאכְטוֹת",
            translation = "марина",
            definition = "אֵזוֹר נָמֵל קָטָן הַמְּיֹעָד לִסְפִינוֹת פְּנַאי, עִם חַשְׁמַל, מַיִם וּמַקְלַחַת לַצֶּוֶת.",
            definitionNative = "Небольшая портовая зона для прогулочных судов; с электричеством, водой и душем для команды.",
            example = "מַעְגָּן יָאכְטוֹת בְּהֶרְצְלִיָּה מָלֵא בְּסוֹף הַשָּׁבוּעַ.",
            exampleNative = "מַעְגָּן יָאכְטוֹת в Герцлии забит на выходных.",
            pos = "phrase", semanticGroup = "transport_maritime_port", fillInBlankExclusions = listOf(189819L)),

        // ── Group: transport_maritime_navigation (5 words) ────────────────────

        WordEntity(id = 189821, setId = 1898, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "נִיווּט",
            translation = "навигация",
            definition = "אֳמָנוּת מְצִיאַת הַדֶּרֶךְ בַּיָּם בְּעֶזְרַת מַפּוֹת, כּוֹכָבִים אוֹ מַכְשִׁירִים אֶלֶקְטְרוֹנִיִּים.",
            definitionNative = "Искусство находить путь по морю с помощью карт, звёзд или электронных приборов.",
            example = "הַתַּלְמִיד לוֹמֵד נִיווּט עִם סַרְגֵּל וּמַצְפֵּן בְּלִי GPS.",
            exampleNative = "Курсант учит נִיווּט с линейкой и компасом — без GPS.",
            pos = "noun", semanticGroup = "transport_maritime_navigation", fillInBlankExclusions = listOf(189822L, 189824L, 189825L)),

        WordEntity(id = 189822, setId = 1898, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַפְלָגָה",
            translation = "плавание / рейс",
            definition = "מַסַּע סְפִינָה מִנְּקֻדָּה אַחַת אֶל אַחֶרֶת, לְרֹב לְמֶרְחָק יָמִים אוֹ שָׁבוּעַ.",
            definitionNative = "Поездка плавсредства из одной точки в другую; обычно на несколько дней или неделю.",
            example = "הַהַפְלָגָה לְקַפְרִיסִין נִדְחֲתָה בִּגְלַל גַּלִּים גְּבוֹהִים מִדַּי.",
            exampleNative = "הַפְלָגָה на Кипр перенесли из-за слишком высоких волн.",
            pos = "noun", semanticGroup = "transport_maritime_navigation", fillInBlankExclusions = listOf(189821L, 189824L, 189825L)),

        WordEntity(id = 189823, setId = 1898, languagePair = "he-ru", rarity = "RARE",
            original = "גֵּאוּת וְשֵׁפֶל",
            translation = "прилив и отлив",
            definition = "תְּנוּעָה יוֹמִית שֶׁל מִפְלָס הַיָּם — עוֹלֶה וְיוֹרֵד פַּעֲמַיִם בְּיוֹם בִּגְלַל מְשִׁיכַת הַיָּרֵחַ.",
            definitionNative = "Суточное движение уровня моря — дважды в сутки поднимается и опускается из-за притяжения Луны.",
            example = "הַדַּיָּגִים בּוֹדְקִים אֶת גֵּאוּת וְשֵׁפֶל לִפְנֵי שֶׁמּוֹצִיאִים סִירוֹת.",
            exampleNative = "Рыбаки сверяются с גֵּאוּת וְשֵׁפֶל, прежде чем спускать лодки.",
            pos = "phrase", semanticGroup = "transport_maritime_navigation"),

        WordEntity(id = 189824, setId = 1898, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תְּעַלָה",
            translation = "канал (водный)",
            definition = "מַעֲבָר מַיִם צַר שֶׁבְּנֵי אָדָם חָפְרוּ כְּדֵי לְקַצֵּר דֶּרֶךְ בֵּין יַמִּים אוֹ נְהָרוֹת.",
            definitionNative = "Узкий рукотворный водный проход; копают, чтобы сократить путь между морями или реками.",
            example = "תְּעַלָה אַחַת חוֹסֶכֶת לַסְּפִינוֹת כִּמְעַט שָׁבוּעַ הַפְלָגָה.",
            exampleNative = "Одна תְּעַלָה экономит судам почти неделю плавания.",
            pos = "noun", semanticGroup = "transport_maritime_navigation", fillInBlankExclusions = listOf(189821L, 189825L)),

        WordEntity(id = 189825, setId = 1898, languagePair = "he-ru", rarity = "RARE",
            original = "עֲגִינָה",
            translation = "швартовка",
            definition = "פְּעוּלָה שֶׁל קְשִׁירַת סְפִינָה אֶל מַזַּח אוֹ הוֹרָדַת עוֹגֶן בְּמָקוֹם בָּטוּחַ.",
            definitionNative = "Действие, при котором плавсредство привязывают к причалу или ставят на якорь в безопасном месте.",
            example = "עֲגִינָה בָּרוּחַ הַזֹּאת דּוֹרֶשֶׁת קַפִּיטָן עִם נִסָּיוֹן רַב.",
            exampleNative = "עֲגִינָה в такой ветер требует капитана с большим опытом.",
            pos = "noun", semanticGroup = "transport_maritime_navigation", fillInBlankExclusions = listOf(189821L, 189822L, 189824L)),
    )
}
