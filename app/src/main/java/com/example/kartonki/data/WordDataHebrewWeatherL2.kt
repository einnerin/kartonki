package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Погода и климат", level 2 (A2-B2).
 * Один сет × 25 слов. setId = 1818.
 *
 *  - 18 UNCOMMON + 7 RARE (два смежных уровня).
 *  - 5 семантических групп по 5 слов:
 *      weather_l2_sky_appearance — описания неба (мрачное, тусклое, туман, мгла, свинцовое) (5)
 *      weather_l2_precipitation  — ливни и осадки (потоп, морось, брызги, шквальный дождь) (5)
 *      weather_l2_temp_feel      — ощущение температуры (тёплый, прохладный, свежий, зябкий, палящий) (5)
 *      weather_l2_atmosphere     — атмосфера (сырость, зной, жар, торнадо, вихрь) (5)
 *      weather_l2_meteo          — метеорология (синоптик, прогноз, летний, весенний, зимний) (5)
 *  - Не пересекается с set 1817 (L1): другие слова, более продвинутая семантика.
 *  - Никудим везде (стандарт he-ru).
 *  - fillInBlankExclusions / isFillInBlankSafe не задаются — заполнятся через
 *    FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataHebrewWeatherL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1818, languagePair = "he-ru", orderIndex = 1818,
            name = "Погода и климат",
            description = "Прогноз, ливни, влажность и тонкие описания неба",
            topic = "Погода и климат", level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── weather_l2_sky_appearance (5) ───────────────────────────────
        WordEntity(
            id = 181801, setId = 1818, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "weather_l2_sky_appearance",
            original = "קוֹדֵר", translation = "мрачный (о небе)",
            transliteration = "кодэр",
            definition = "כְּשֶׁהַשָּׁמַיִם אֲפוֹרִים וּכְבֵדִים וְהָאוֹר עָמוּם וְעָצוּב.",
            definitionNative = "Когда небо серое и тяжёлое, а свет тусклый и грустный.",
            example = "בֹּקֶר קוֹדֵר וְקַר חִכָּה לָנוּ מִחוּץ לַחַלּוֹן.",
            exampleNative = "За окном нас встретило קוֹדֵר прохладное утро.",
         fillInBlankExclusions = listOf(181802L, 181812L, 181813L, 181814L, 181824L, 181825L)),
        WordEntity(
            id = 181802, setId = 1818, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "weather_l2_sky_appearance",
            original = "עָמוּם", translation = "тусклый, мутный",
            transliteration = "амум",
            definition = "כְּשֶׁהָאוֹר חַלָּשׁ וְלֹא בָּהִיר, כְּאִלּוּ הוּא עוֹבֵר דֶּרֶךְ אָבָק.",
            definitionNative = "Когда свет слабый и не яркий — будто пробивается через слой пыли.",
            example = "אוֹר עָמוּם נָפַל עַל הַגַּגּוֹת בְּשַׁעַת בֵּין הָעַרְבַּיִם.",
            exampleNative = "На крыши падал עָמוּם свет в час между днём и ночью.",
         fillInBlankExclusions = listOf(181801L, 181811L, 181813L, 181815L, 181823L, 181824L, 181825L)),
        WordEntity(
            id = 181803, setId = 1818, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "weather_l2_sky_appearance",
            original = "עֲרָפֶל", translation = "туман",
            transliteration = "арафель",
            definition = "עֲנַן מַיִם נָמוּךְ שֶׁשּׁוֹכֵב עַל הָאָרֶץ וּמַסְתִּיר אֶת הַמַּרְאֶה.",
            definitionNative = "Низкое водяное облако, что лежит на земле и прячет всё вокруг.",
            example = "הָעֲרָפֶל הַסְּמִיךְ הִסְתִּיר אֶת הַכְּבִישׁ לְגַמְרֵי.",
            exampleNative = "Густой עֲרָפֶל полностью скрыл шоссе впереди.",
         fillInBlankExclusions = listOf(181804L, 181805L)),
        WordEntity(
            id = 181804, setId = 1818, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "weather_l2_sky_appearance",
            original = "אוֹבֶךְ", translation = "мгла, пыльная дымка",
            transliteration = "овэх",
            definition = "אֲוִיר מָלֵא חֶלְקִיקֵי אָבָק שֶׁמַּסְתִּירִים אֶת הַשֶּׁמֶשׁ וְהַמַּרְחָק.",
            definitionNative = "Воздух, наполненный мелкой пылью, что прячет солнце и горизонт.",
            example = "הָאוֹבֶךְ מֵהַמִּדְבָּר עָטַף אֶת הָעִיר בְּצֶבַע צָהֹב.",
            exampleNative = "אוֹבֶךְ из пустыни окутал город жёлтой пеленой.",
        ),
        WordEntity(
            id = 181805, setId = 1818, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "weather_l2_sky_appearance",
            original = "עוֹפֶרֶת", translation = "свинец (о свинцовом небе)",
            transliteration = "офэрэт",
            definition = "מַתֶּכֶת אֲפֹרָה כְּבֵדָה — בְּהַשְׁאָלָה: שָׁמַיִם אֲפֹרִים וְכִבְדֵי-עָנָן.",
            definitionNative = "Серый тяжёлый металл — образно так зовут серое тучное небо.",
            example = "שָׁמַיִם שֶׁל עוֹפֶרֶת נִתְלוּ מֵעַל הַיָּם כָּל הַיּוֹם.",
            exampleNative = "Над морем весь день висело небо цвета עוֹפֶרֶת.",
         fillInBlankExclusions = listOf(181803L, 181804L)),

        // ─── weather_l2_precipitation (5) ────────────────────────────────
        WordEntity(
            id = 181806, setId = 1818, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "weather_l2_precipitation",
            original = "שִׁטָּפוֹן", translation = "потоп, наводнение",
            transliteration = "шитафон",
            definition = "כַּמּוּת מַיִם עֲצוּמָה שֶׁמַּצִּיפָה רְחוֹבוֹת וְשָׂדוֹת אַחֲרֵי גְּשָׁמִים חֲזָקִים.",
            definitionNative = "Огромный поток воды, что заливает улицы и поля после сильных дождей.",
            example = "הַשִּׁטָּפוֹן סָגַר אֶת הַכְּבִישׁ הַמְּהִיר לְכַמָּה שָׁעוֹת.",
            exampleNative = "שִׁטָּפוֹן перекрыл скоростное шоссе на несколько часов.",
        ),
        WordEntity(
            id = 181807, setId = 1818, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "weather_l2_precipitation",
            original = "זַרְזִיף", translation = "слабый дождик, морось",
            transliteration = "зарзиф",
            definition = "גֶּשֶׁם דַּק וְקַל שֶׁבּוֹ הַטִּיפּוֹת קְטַנּוֹת וְכִמְעַט לֹא מַרְטִיבוֹת.",
            definitionNative = "Тонкий лёгкий дождик с маленькими каплями, которые почти не мочат.",
            example = "זַרְזִיף נָעִים יָרַד עָלֵינוּ כְּשֶׁטִּיַּלְנוּ בַּפַּארְק.",
            exampleNative = "Приятный זַרְזִיף сыпал на нас, пока мы гуляли по парку.",
         fillInBlankExclusions = listOf(181803L, 181806L, 181808L, 181809L, 181810L)),
        WordEntity(
            id = 181808, setId = 1818, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "weather_l2_precipitation",
            original = "מַבּוּל", translation = "потоп, ливень (книжн.)",
            transliteration = "мабуль",
            definition = "גֶּשֶׁם עָצוּם וְלֹא רָגִיל שֶׁמַּזְכִּיר אֶת הַסִּפּוּר עַל נֹחַ וְהַתֵּבָה.",
            definitionNative = "Огромный небывалый ливень — отсылает к рассказу о Ное и ковчеге.",
            example = "יָרַד מַבּוּל שֶׁל מַמָּשׁ וְכֻלָּם נִתְקְעוּ בַּבַּיִת.",
            exampleNative = "Хлынул настоящий מַבּוּל, и все застряли по домам.",
         fillInBlankExclusions = listOf(181806L, 181807L, 181809L, 181810L)),
        WordEntity(
            id = 181809, setId = 1818, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "weather_l2_precipitation",
            original = "רְסִיסִים", translation = "брызги, мелкие капли",
            transliteration = "ресисим",
            definition = "טִיפּוֹת קְטַנּוֹת מְאוֹד שֶׁמִּתְפַּזְּרוֹת בָּאֲוִיר אַחֲרֵי פְּגִיעַת מַיִם בְּמַשֶּׁהוּ.",
            definitionNative = "Очень мелкие капельки, что разлетаются по воздуху от удара воды о что-то.",
            example = "רְסִיסִים שֶׁל גֶּשֶׁם נָגְעוּ בִּי דֶּרֶךְ הַחַלּוֹן הַפָּתוּחַ.",
            exampleNative = "רְסִיסִים дождя касались меня через приоткрытое окно.",
         fillInBlankExclusions = listOf(181806L, 181807L, 181808L, 181810L)),
        WordEntity(
            id = 181810, setId = 1818, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "weather_l2_precipitation",
            original = "מִמְטָר", translation = "ливень, шквал дождя",
            transliteration = "мимтар",
            definition = "גֶּשֶׁם חָזָק וּפִתְאוֹמִי שֶׁבָּא לִזְמַן קָצָר וּמַרְטִיב הַכֹּל.",
            definitionNative = "Сильный внезапный дождь, что налетает на короткое время и промачивает всё.",
            example = "מִמְטָר קַל הִפְסִיק לְרֶגַע אֶת הַטִּיוּל בָּעִיר הָעַתִּיקָה.",
            exampleNative = "Лёгкий מִמְטָר на минуту прервал прогулку по Старому городу.",
         fillInBlankExclusions = listOf(181803L, 181804L, 181806L, 181807L, 181808L, 181809L)),

        // ─── weather_l2_temp_feel (5) ────────────────────────────────────
        WordEntity(
            id = 181811, setId = 1818, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "weather_l2_temp_feel",
            original = "חָמִים", translation = "тёплый (приятно)",
            transliteration = "хамим",
            definition = "כְּשֶׁהַטֶּמְפֶּרָטוּרָה נְעִימָה — לֹא חַם מִדַּי וְלֹא קַר, כְּמוֹ אַחֲרֵי הַצָּהֳרַיִם בָּאָבִיב.",
            definitionNative = "Когда температура приятная — не жарко и не холодно, как в весенний полдень.",
            example = "אֲוִיר חָמִים וְקַל שָׁטַף אוֹתָנוּ בְּצֵאתֵנוּ מֵהַבַּיִת.",
            exampleNative = "חָמִים лёгкий воздух обнял нас, когда мы вышли из дома.",
         fillInBlankExclusions = listOf(181812L, 181813L, 181814L, 181815L, 181823L, 181824L, 181825L)),
        WordEntity(
            id = 181812, setId = 1818, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "weather_l2_temp_feel",
            original = "צוֹנֵן", translation = "прохладный, свежий",
            transliteration = "цонэн",
            definition = "כְּשֶׁהָאֲוִיר קָרִיר וְנָעִים — לֹא קַר מַמָּשׁ אֲבָל מַרְגִּישִׁים שֶׁכְּדַאי לְהוֹסִיף סְוֶדֶר.",
            definitionNative = "Когда воздух свежий и прохладный — не холодно, но хочется накинуть свитер.",
            example = "בֹּקֶר צוֹנֵן שֶׁל אוֹקְטוֹבֶּר חִכָּה לָנוּ בִּיצִיאָה לָעֲבוֹדָה.",
            exampleNative = "צוֹנֵן октябрьское утро встретило нас по дороге на работу.",
         fillInBlankExclusions = listOf(181801L, 181811L, 181813L, 181814L, 181815L, 181823L, 181825L)),
        WordEntity(
            id = 181813, setId = 1818, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "weather_l2_temp_feel",
            original = "רַעֲנָן", translation = "свежий, бодрящий",
            transliteration = "раанан",
            definition = "כְּשֶׁהָאֲוִיר נָקִי וְקָרִיר וּמַרְגִּישִׁים שֶׁכֵּיף לִנְשֹׁם וְלָזוּז.",
            definitionNative = "Когда воздух чистый и прохладный — дышится легко и хочется двигаться.",
            example = "אֲוִיר רַעֲנָן נִכְנַס לַחֶדֶר בְּרֶגַע שֶׁפָּתַחְנוּ אֶת הַחַלּוֹן.",
            exampleNative = "רַעֲנָן воздух ворвался в комнату, едва мы открыли окно.",
         fillInBlankExclusions = listOf(181811L, 181812L, 181814L, 181815L, 181823L, 181824L, 181825L)),
        WordEntity(
            id = 181814, setId = 1818, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "weather_l2_temp_feel",
            original = "עוֹקְצָנִי", translation = "колкий, зябкий (о холоде)",
            transliteration = "окцани",
            definition = "כְּשֶׁהַקֹּר חַד וּמַרְגִּישִׁים אוֹתוֹ עַל הַלְּחָיַיִם וְעַל קְצוֹת הָאֶצְבָּעוֹת.",
            definitionNative = "Когда холод колкий и его чувствуешь на щеках и кончиках пальцев.",
            example = "רוּחַ עוֹקְצָנִית הִכְנִיסָה אוֹתָנוּ הַבַּיְתָה מַהֵר.",
            exampleNative = "עוֹקְצָנִי ветер быстро загнал нас обратно домой.",
        ),
        WordEntity(
            id = 181815, setId = 1818, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "weather_l2_temp_feel",
            original = "לוֹהֵט", translation = "палящий, раскалённый",
            transliteration = "лоhэт",
            definition = "חַם בְּצוּרָה קִיצוֹנִית — כְּמוֹ אֶבֶן בַּשֶּׁמֶשׁ אוֹ חוֹל מִדְבָּרִי בַּצָּהֳרַיִם.",
            definitionNative = "Жаркий до крайности — как камень на солнце или песок в пустыне в полдень.",
            example = "אַסְפַלְט לוֹהֵט שָׂרַף לָנוּ אֶת כַּפּוֹת הָרַגְלַיִם.",
            exampleNative = "לוֹהֵט асфальт жёг нам ступни.",
         fillInBlankExclusions = listOf(181811L, 181812L, 181813L, 181814L, 181823L)),

        // ─── weather_l2_atmosphere (5) ───────────────────────────────────
        WordEntity(
            id = 181816, setId = 1818, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "weather_l2_atmosphere",
            original = "רְטִיבוּת", translation = "сырость",
            transliteration = "ретивут",
            definition = "מַצָּב שֶׁבּוֹ הַכֹּל קְצָת רָטוּב — קִירוֹת, בְּגָדִים אוֹ הָאֲוִיר עַצְמוֹ.",
            definitionNative = "Состояние, когда всё вокруг чуть мокрое — стены, одежда или сам воздух.",
            example = "הָרְטִיבוּת בַּמַּרְתֵּף הִשְׁאִירָה רֵיחַ לֹא נָעִים בַּסְּפָרִים.",
            exampleNative = "רְטִיבוּת в подвале оставила в книгах неприятный запах.",
         fillInBlankExclusions = listOf(181817L, 181818L, 181819L, 181820L)),
        WordEntity(
            id = 181817, setId = 1818, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "weather_l2_atmosphere",
            original = "הֶבֶל", translation = "зной, духота",
            transliteration = "hэвель",
            definition = "אֲוִיר חַם וְכָבֵד שֶׁעוֹלֶה מֵהָאַסְפַלְט אוֹ מֵהָאָרֶץ אַחֲרֵי יוֹם חַם.",
            definitionNative = "Жаркий тяжёлый воздух, что поднимается от асфальта или земли в жаркий день.",
            example = "הֶבֶל כָּבֵד עָמַד בָּרְחוֹב גַּם אַחֲרֵי שְׁקִיעַת הַשֶּׁמֶשׁ.",
            exampleNative = "Тяжёлый הֶבֶל стоял на улице даже после заката.",
         fillInBlankExclusions = listOf(181803L, 181804L, 181816L, 181818L, 181819L, 181820L)),
        WordEntity(
            id = 181818, setId = 1818, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "weather_l2_atmosphere",
            original = "לַהַט", translation = "жар, зной (палящий)",
            transliteration = "лаhат",
            definition = "חֹם חָזָק וְצוֹרֵב — כְּמוֹ זֶה שֶׁמַּרְגִּישִׁים לְיַד תַּנּוּר אוֹ בְּצָהֳרֵי קַיִץ.",
            definitionNative = "Сильный жгучий жар — как у печи или в полдень в разгар лета.",
            example = "לַהַט הַשֶּׁמֶשׁ רוֹקֵן אֶת הָרְחוֹבוֹת אַחַר הַצָּהֳרַיִם.",
            exampleNative = "לַהַט солнца опустошил улицы после полудня.",
         fillInBlankExclusions = listOf(181816L, 181817L, 181819L, 181820L)),
        WordEntity(
            id = 181819, setId = 1818, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "weather_l2_atmosphere",
            original = "טוֹרְנָדוֹ", translation = "торнадо",
            transliteration = "торнадо",
            definition = "עַמּוּד אֲוִיר מִסְתּוֹבֵב חָזָק שֶׁיּוֹרֵד מִן הָעֲנָנִים וּמַחֲרִיב כָּל מַה שֶׁבְּדַרְכּוֹ.",
            definitionNative = "Мощный вращающийся воздушный столб, что спускается из туч и крушит всё на пути.",
            example = "טוֹרְנָדוֹ פָּגַע בָּעֲיָרָה וְהֶעֱלִים גַּגּוֹת שְׁלֵמִים.",
            exampleNative = "טוֹרְנָדוֹ ударил по городку и сорвал крыши с домов целиком.",
        ),
        WordEntity(
            id = 181820, setId = 1818, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "weather_l2_atmosphere",
            original = "מְעַרְבֹּלֶת", translation = "вихрь, водоворот",
            transliteration = "меарболет",
            definition = "תְּנוּעָה מְהִירָה וּמִסְתּוֹבֶבֶת שֶׁל אֲוִיר אוֹ מַיִם שֶׁמּוֹשֶׁכֶת אֵלֶיהָ דְּבָרִים קְטַנִּים.",
            definitionNative = "Быстрое вращательное движение воздуха или воды, что втягивает в себя мелкие предметы.",
            example = "מְעַרְבֹּלֶת קְטַנָּה הִקִּיפָה אֶת הֶעָלִים בֶּחָצֵר.",
            exampleNative = "Маленькая מְעַרְבֹּלֶת закружила листья посреди двора.",
         fillInBlankExclusions = listOf(181816L, 181817L, 181818L, 181819L)),

        // ─── weather_l2_meteo (5) ────────────────────────────────────────
        WordEntity(
            id = 181821, setId = 1818, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "weather_l2_meteo",
            original = "חַזַּאי", translation = "синоптик, метеоролог",
            transliteration = "хазай",
            definition = "אִישׁ הַמְּקַצּוֹעַ שֶׁמּוֹסֵר בַּטֶּלֶוִיזְיָה אוֹ בָּרַדְיוֹ אֵיךְ תִּהְיֶה הַמֶּזֶג אֲוִיר.",
            definitionNative = "Специалист, что рассказывает по ТВ или радио, какой будет погода завтра.",
            example = "הַחַזַּאי הִבְטִיחַ סוֹף שָׁבוּעַ נָעִים וְשִׁמְשִׁי.",
            exampleNative = "חַזַּאי обещал приятные солнечные выходные.",
         fillInBlankExclusions = listOf(181822L)),
        WordEntity(
            id = 181822, setId = 1818, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "weather_l2_meteo",
            original = "תַּחֲזִית", translation = "прогноз (погоды)",
            transliteration = "тахазит",
            definition = "תֵּאוּר קָצָר שֶׁל מַה שֶּׁצָּפוּי לִקְרוֹת בַּמֶּזֶג אֲוִיר בַּיָּמִים הַקְּרוֹבִים.",
            definitionNative = "Короткий рассказ о том, что ожидается с погодой в ближайшие дни.",
            example = "הַתַּחֲזִית לְמָחָר מְדַבֶּרֶת עַל גֶּשֶׁם וְרוּחַ.",
            exampleNative = "תַּחֲזִית на завтра обещает дождь и ветер.",
         fillInBlankExclusions = listOf(181821L)),
        WordEntity(
            id = 181823, setId = 1818, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "weather_l2_meteo",
            original = "קַיְצִי", translation = "летний",
            transliteration = "кайци",
            definition = "אוֹפְיָנִי לַקַּיִץ — חַם, יָבֵשׁ וְשִׁמְשִׁי, יָמִים אֲרֻכִּים וְלֵילוֹת קְצָרִים.",
            definitionNative = "Свойственный лету — жарко, сухо и солнечно, длинные дни и короткие ночи.",
            example = "עֶרֶב קַיְצִי נָעִים מָשַׁךְ אוֹתָנוּ לְשֶׁבֶת בְּחוּץ עַד מְאֻחָר.",
            exampleNative = "Приятный קַיְצִי вечер выманил нас сидеть на улице допоздна.",
         fillInBlankExclusions = listOf(181811L, 181812L, 181813L, 181824L, 181825L)),
        WordEntity(
            id = 181824, setId = 1818, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "weather_l2_meteo",
            original = "אֲבִיבִי", translation = "весенний",
            transliteration = "авиви",
            definition = "אוֹפְיָנִי לָאָבִיב — חָמִים, פּוֹרֵחַ וְצִבְעוֹנִי, גְּשָׁמִים קַלִּים מִדֵּי פַּעַם.",
            definitionNative = "Свойственный весне — тепло, всё цветёт и красочно, временами лёгкие дожди.",
            example = "בֹּקֶר אֲבִיבִי קָרִיר חִכָּה לָנוּ בְּדֶרֶךְ הַחֲזָרָה מֵהַפַּארְק.",
            exampleNative = "אֲבִיבִי прохладное утро встретило нас на обратном пути из парка.",
         fillInBlankExclusions = listOf(181801L, 181813L, 181814L, 181823L, 181825L)),
        WordEntity(
            id = 181825, setId = 1818, languagePair = "he-ru", rarity = "RARE",
            pos = "adjective", semanticGroup = "weather_l2_meteo",
            original = "חָרְפִּי", translation = "зимний (как зимой)",
            transliteration = "хорпи",
            definition = "אוֹפְיָנִי לַחֹרֶף — קַר, אָפֹר, וְלִפְעָמִים עִם שֶׁלֶג אוֹ כְּפוֹר עַל הַחַלּוֹנוֹת.",
            definitionNative = "Свойственный зиме — холодный, серый, иногда со снегом или инеем на стёклах.",
            example = "בֹּקֶר חָרְפִּי קָפוּא הִתְחִיל בְּכוֹס שׁוֹקוֹ חַם.",
            exampleNative = "חָרְפִּי морозное утро началось с чашки горячего какао.",
         fillInBlankExclusions = listOf(181801L, 181812L, 181813L, 181814L, 181823L, 181824L)),
    )
}
