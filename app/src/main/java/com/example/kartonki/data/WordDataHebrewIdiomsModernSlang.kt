package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — set 1912 (he-ru).
 * Идиомы и поговорки иврита: современный израильский сленг XXI века
 * (L3 / UNCOMMON + RARE). Парный к set 1893 (танахические выражения).
 *
 * Уникальный для he-ru ракурс: то, что слышишь на улице Тель-Авива,
 * в кафе, в офисе хайтек-стартапа, в армии — без вульгаризмов и
 * ругательств. Бытовой сленг, который учебники ульпана почти не дают,
 * а носители используют постоянно.
 *
 * НЕ танахизмы (1893), НЕ литературные идиомы (L4-L5 наборы Idioms).
 *
 * Исключены 8 кандидатов из-за дублей:
 *   - מַגְנִיב (крутой) — Batch80
 *   - בְּסֵדֶר גָּמוּר (полный порядок) — Batch50, Batch80
 *   - עַל הַפָּנִים (отвратительно) — Batch80
 *   - אָחִי (братан) — Batch80
 *   - נְשָׁמָה (душа моя) — ReligionL1 (как «душа»)
 *   - חָבֵר (друг) — Everyday
 *   - בְּרֵכָה (омоним «бассейн») — More
 *   - כַּפְתּוֹר (омоним «кнопка») — Mobile/Qa
 *
 * Заменители подобраны под современный сленг улицы:
 *   - פִּצָּצָה («бомба», =«огонь, потрясно») вместо магнив
 *   - סוֹף הַדֶּרֶךְ («конец пути», =«офигенно») для approval
 *   - תַּכְלֶ׳ס («по сути, по делу») и בְּכֵיף («с удовольствием»)
 *   - אֵין מַצָּב («нет шансов / да ладно!»)
 *   - הָזוּי («безумный, бредовый») вместо магнив-омонима
 *   - מַה נִּשְׁמַע / וואלה не вошли — заняты ранее или не уникальны
 *
 * Распределение редкости (validate_rarity_spread: 2 смежных уровня):
 *   UNCOMMON — 12 слов (A2-B1): базовый сленг, который слышишь
 *     в первые недели в Израиле (sababa, ahla, yala, stam, eih ze,
 *     ma pitom, lo nora, balagan, al tagid, hafif, ein matsav, pitsatsa).
 *   RARE — 13 слов (B2): продвинутые выражения, которые отличают
 *     своего от «учебникового» иммигранта (shafit, sof haderech,
 *     haval al hazman, nes shalem, tachles, b'keif, padiha, mesahev,
 *     azov shtuyot, hazui, hahaim sheli, of hahol, pazam).
 *
 * Пять семантических подгрупп (validate_group_sizes: 3-8 на группу):
 *   idioms_slang_approval — 5 слов: восторг и одобрение
 *   idioms_slang_surprise — 5 слов: удивление и недоверие
 *   idioms_slang_agreement — 5 слов: согласие и поддержка
 *   idioms_slang_irritation — 5 слов: раздражение и облом
 *   idioms_slang_address — 5 слов: обращения и универсальный
 *     бытовой сленг (включая армейский пазам)
 *
 * Word IDs: 191201..191225 (setId × 100 + position).
 */
object WordDataHebrewIdiomsModernSlang {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1912, languagePair = "he-ru", orderIndex = 1912,
            name = "Идиомы и поговорки иврита",
            description = "Современный сленг XXI века: סַבָּבָּה, חֲבָל עַל הַזְּמַן, פָּדִיחָה, יָאלָה.",
            topic = "Идиомы и поговорки иврита",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: idioms_slang_approval (5 words) ────────────────────────────

        WordEntity(id = 191201, setId = 1912, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סַבָּבָּה",
            translation = "класс, окей, отлично (одобрение)",
            definition = "מִילַּת רְצִיָּה וְהַסְכָּמָה לְכֹל מַצָּב חִיּוּבִי; שְׁאוּלָה מֵעֲרָבִית, רוֹוַחַת אֵצֶל כֻּלָּם.",
            definitionNative = "Универсальное одобрение на всё хорошее; пришло из арабского, говорят все возрасты.",
            example = "אֵיךְ הָיְתָה הַמְּסִבָּה? — סַבָּבָּה, נֶהֱנֵיתִי מְאוֹד!",
            exampleNative = "Как вечеринка? — סַבָּבָּה, очень понравилось!",
            pos = "interjection", semanticGroup = "idioms_slang_approval", fillInBlankExclusions = listOf(191202L, 191203L, 191204L, 191205L, 191211L, 191213L, 191215L, 191218L)),

        WordEntity(id = 191202, setId = 1912, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אַחְלָה",
            translation = "классный, супер (одобрение)",
            definition = "תֹּאַר חִיּוּבִי לָאֹכֶל, לְמָקוֹם אוֹ לְמַצָּב — מֵהָעֲרָבִית, נְפוֹצָה בְּכֹל הָאָרֶץ.",
            definitionNative = "Положительная оценка для еды, места или ситуации — из арабского, повсеместно.",
            example = "אָכַלְנוּ אַחְלָה חוּמוּס בְּמִסְעָדָה קְטַנָּה בִּצְפַת.",
            exampleNative = "Поели אַחְלָה хумус в маленьком ресторане в Цфате.",
            pos = "adjective", semanticGroup = "idioms_slang_approval", fillInBlankExclusions = listOf(191203L, 191218L)),

        WordEntity(id = 191203, setId = 1912, languagePair = "he-ru", rarity = "RARE",
            original = "שָׁפִיט",
            translation = "лучший, топ (одобрение)",
            definition = "תֹּאַר סְלֶנְגִּי הַמַּצְבִּיעַ עַל פִּסְגַּת הָאֵיכוּת — מַשֶּׁהוּ שֶׁעוֹמֵד מֵעַל הַשְּׁאָר.",
            definitionNative = "Сленговая оценка высшей пробы — то, что выделяется над остальным.",
            example = "הַסְּדָרָה הַזֹּאת שָׁפִיט, חַיָּב לִרְאוֹת אוֹתָהּ.",
            exampleNative = "Этот сериал שָׁפִיט, обязательно посмотри.",
            pos = "adjective", semanticGroup = "idioms_slang_approval", fillInBlankExclusions = listOf(191201L, 191202L, 191204L, 191205L, 191211L, 191218L)),

        WordEntity(id = 191204, setId = 1912, languagePair = "he-ru", rarity = "RARE",
            original = "סוֹף הַדֶּרֶךְ",
            translation = "офигенно, лучше некуда (одобрение)",
            definition = "בִּטּוּי מַשְׁבָּחַ לִתְכוּנָה אוֹ חֲוָיָה — בֶּאֱמֶת אֵין הֶמְשֵׁךְ מֵעֵבֶר לְכָךְ.",
            definitionNative = "Хвалебный оборот для качества или впечатления — действительно лучше быть не может.",
            example = "הַטִּיוּל בַּגָּלִיל הָיָה סוֹף הַדֶּרֶךְ, אֲנִי לֹא רוֹצָה לַחֲזוֹר.",
            exampleNative = "Поездка в Галилею вышла סוֹף הַדֶּרֶךְ, не хочется возвращаться.",
            pos = "phrase", semanticGroup = "idioms_slang_approval"),

        WordEntity(id = 191205, setId = 1912, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פְּצָצָה",
            translation = "бомба, огонь (превосходно)",
            definition = "מָה שֶׁמַּפְצִיץ אֶת הַחוּשִׁים — אֹכֶל, הוֹפָעָה אוֹ מוּצָר בְּאֵיכוּת חֲרִיגָה.",
            definitionNative = "Что-то, что взрывает чувства — еда, концерт или вещь редкого уровня.",
            example = "הָעוּגָה שֶׁהֵכַנְתְּ הָיְתָה פְּצָצָה, כֻּלָּם בִּקְּשׁוּ עוֹד.",
            exampleNative = "Торт, что ты испекла, был פְּצָצָה, все просили добавки.",
            pos = "noun", semanticGroup = "idioms_slang_approval", fillInBlankExclusions = listOf(191201L, 191202L, 191203L, 191204L, 191211L, 191218L)),

        // ── Group: idioms_slang_surprise (5 words) ────────────────────────────

        WordEntity(id = 191206, setId = 1912, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אֵיךְ זֶה",
            translation = "как же так, как такое (удивление)",
            definition = "תְּמִיהָה עַל מַצָּב לֹא הַגְיוֹנִי, רֵיק מִתַּכְלִית: אֵיךְ הִגַּעְנוּ לְכָאן.",
            definitionNative = "Возглас при ситуации, что кажется нелогичной: как мы дошли до такого.",
            example = "אֵיךְ זֶה שֶׁלֹּא קִבַּלְתָּ הוֹדָעָה? שָׁלַחְתִּי אֶתְמוֹל.",
            exampleNative = "אֵיךְ זֶה, что сообщение не пришло? я отправила вчера.",
            pos = "phrase", semanticGroup = "idioms_slang_surprise", fillInBlankExclusions = listOf(191207L, 191208L, 191209L)),

        WordEntity(id = 191207, setId = 1912, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מָה פִּתְאוֹם",
            translation = "с чего вдруг, ещё чего (возражение)",
            definition = "תְּגוּבָה חַדָּה הַדּוֹחָה הַנָּחָה אוֹ הַצָּעָה — לְמָה אַתָּה חוֹשֵׁב כָּךְ בִּכְלָל.",
            definitionNative = "Резкая реакция, что отбрасывает предположение или предложение — с чего бы.",
            example = "אַתָּה כּוֹעֵס עָלַי? — מָה פִּתְאוֹם, הַכֹּל טוֹב.",
            exampleNative = "Ты на меня сердишься? — מָה פִּתְאוֹם, всё нормально.",
            pos = "phrase", semanticGroup = "idioms_slang_surprise", fillInBlankExclusions = listOf(191206L, 191208L, 191209L, 191219L)),

        WordEntity(id = 191208, setId = 1912, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אַל תַּגִּיד",
            translation = "да ладно, не может быть (недоверие)",
            definition = "תְּגוּבָה עַל יְדִיעָה מַפְתִּיעָה — אַתָּה צוֹחֵק עָלַי, זֶה לֹא יִתָּכֵן.",
            definitionNative = "Реакция на удивительную новость — ты шутишь, такого быть не может.",
            example = "פָּגַשְׁתִּי אֶתְמוֹל אֶת רוֹעִי בְּפָרִיז. — אַל תַּגִּיד!",
            exampleNative = "Встретила вчера Рои в Париже. — אַל תַּגִּיד!",
            pos = "phrase", semanticGroup = "idioms_slang_surprise", fillInBlankExclusions = listOf(191205L, 191206L, 191207L, 191209L, 191210L)),

        WordEntity(id = 191209, setId = 1912, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אֵין מַצָּב",
            translation = "нет шансов, да ну (недоверие)",
            definition = "סֵרוּב מֻחְלָט אוֹ פְּלִיאָה גְּדוֹלָה — בְּחַיֶּיךָ, אֲנִי לֹא מַאֲמִין שֶׁזֶּה קוֹרֶה.",
            definitionNative = "Полный отказ или большое изумление — слушай, не верится, что это правда.",
            example = "אֵין מַצָּב שֶׁאַתָּה הוֹלֵךְ לַיָּם בַּגֶּשֶׁם הַזֶּה.",
            exampleNative = "אֵין מַצָּב, что ты собираешься на море в такой дождь.",
            pos = "phrase", semanticGroup = "idioms_slang_surprise", fillInBlankExclusions = listOf(191206L, 191207L, 191208L)),

        WordEntity(id = 191210, setId = 1912, languagePair = "he-ru", rarity = "RARE",
            original = "הָזוּי",
            translation = "бредовый, безумный (нереально)",
            definition = "תֹּאַר לְמַצָּב שֶׁמַּרְגִּישׁ כְּמוֹ חֲלוֹם מוּזָר — מְנֻתָּק מֵהַמְּצִיאוּת, אַבְּסוּרְדִי.",
            definitionNative = "Признак ситуации, что ощущается как странный сон — оторвано от реальности.",
            example = "הֲרַעְיוֹן שֶׁלָּהֶם לְפַתֵּחַ הָאַפְּלִיקַצְיָה הוּא הָזוּי לְגַמְרֵי.",
            exampleNative = "Их идея с разработкой приложения просто הָזוּי.",
            pos = "adjective", semanticGroup = "idioms_slang_surprise", fillInBlankExclusions = listOf(191205L)),

        // ── Group: idioms_slang_agreement (5 words) ───────────────────────────

        WordEntity(id = 191211, setId = 1912, languagePair = "he-ru", rarity = "RARE",
            original = "חֲבָל עַל הַזְּמַן",
            translation = "офигенно, не передать словами",
            definition = "שֶׁבַח גָּדוֹל בְּלִי לְבַזְבֵּז מִלִּים — כָּל כָּךְ טוֹב שֶׁאֵין טַעַם לְהַסְבִּיר.",
            definitionNative = "Большая похвала без лишних слов — настолько хорошо, что объяснять бессмысленно.",
            example = "הַקּוֹנְצֶרְט שֶׁל אָבִיב גֶּפֶן הָיָה חֲבָל עַל הַזְּמַן אֶמֶשׁ.",
            exampleNative = "Концерт Авива Гефена вчера был חֲבָל עַל הַזְּמַן.",
            pos = "phrase", semanticGroup = "idioms_slang_agreement", fillInBlankExclusions = listOf(191201L, 191202L, 191203L, 191204L, 191205L, 191212L, 191213L, 191215L, 191218L)),

        WordEntity(id = 191212, setId = 1912, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "לֹא נוֹרָא",
            translation = "ничего страшного, бывает",
            definition = "מַרְגִּיעַ אֶת בֶּן הַשִּׂיחַ עַל כִּשָּׁלוֹן אוֹ אִחוּר — אֵין צֹרֶךְ לְהִתְנַצֵּל יוֹתֵר.",
            definitionNative = "Успокаивает собеседника после промаха или опоздания — извиняться больше незачем.",
            example = "שָׁכַחְתִּי לְהָבִיא יַיִן. — לֹא נוֹרָא, יֵשׁ לִי בַּקְבּוּק נוֹסָף.",
            exampleNative = "Забыл принести вино. — לֹא נוֹרָא, у меня есть запасная бутылка.",
            pos = "phrase", semanticGroup = "idioms_slang_agreement", fillInBlankExclusions = listOf(191201L, 191211L, 191213L, 191215L)),

        WordEntity(id = 191213, setId = 1912, languagePair = "he-ru", rarity = "RARE",
            original = "נֵס שָׁלֵם",
            translation = "просто чудо (часто иронично)",
            definition = "תֵּאוּר מַצָּב שֶׁהִסְתַּדֵּר בְּאֹפֶן מַפְתִּיעַ, לִפְעָמִים בְּטוֹן צִינִי לְמַשֶּׁהוּ פָּשׁוּט.",
            definitionNative = "Описание ситуации, что разрешилась неожиданно, иногда с иронией к мелочи.",
            example = "הָאוֹטוֹבּוּס הִגִּיעַ בַּזְּמַן — נֵס שָׁלֵם, מַמָּשׁ לֹא צָפוּי.",
            exampleNative = "Автобус пришёл вовремя — נֵס שָׁלֵם, прям нежданно.",
            pos = "phrase", semanticGroup = "idioms_slang_agreement", fillInBlankExclusions = listOf(191205L, 191208L, 191209L, 191210L, 191211L, 191212L, 191215L)),

        WordEntity(id = 191214, setId = 1912, languagePair = "he-ru", rarity = "RARE",
            original = "תַּכְלֶ׳ס",
            translation = "по сути, по делу (давай о главном)",
            definition = "מִילַּת מַעֲבָר לִנְקֻדָּה הָעִקָּרִית בְּלִי הַקְדָּמוֹת — נְפוֹצָה בְּדִיּוּן עִסְקִי וְחֶבְרָתִי.",
            definitionNative = "Слово-переход к сути без предисловий — частое в офисных и дружеских разговорах.",
            example = "תַּכְלֶ׳ס, אַתָּה הוֹלֵךְ לַטִּיוּל בְּשַׁבָּת אוֹ לֹא?",
            exampleNative = "תַּכְלֶ׳ס, ты идёшь на прогулку в субботу или нет?",
            pos = "interjection", semanticGroup = "idioms_slang_agreement", fillInBlankExclusions = listOf(191221L)),

        WordEntity(id = 191215, setId = 1912, languagePair = "he-ru", rarity = "RARE",
            original = "בְּכֵיף",
            translation = "с удовольствием, легко (согласие)",
            definition = "תְּגוּבָה חִיּוּבִית לְהַצָּעָה — אֲנִי שָׂמֵחַ לַעֲשׂוֹת זֹאת, אֵין שׁוּם בְּעָיָה.",
            definitionNative = "Радушный ответ на предложение — рад это сделать, никаких проблем.",
            example = "תּוּכַל לִקְפֹּץ אֵלַי בַּדֶּרֶךְ? — בְּכֵיף, מָתַּי שֶׁתִּרְצֶה.",
            exampleNative = "Сможешь заскочить ко мне по пути? — בְּכֵיף, когда захочешь.",
            pos = "phrase", semanticGroup = "idioms_slang_agreement", fillInBlankExclusions = listOf(191201L, 191202L, 191211L, 191212L, 191213L)),

        // ── Group: idioms_slang_irritation (5 words) ──────────────────────────

        WordEntity(id = 191216, setId = 1912, languagePair = "he-ru", rarity = "RARE",
            original = "פָּדִיחָה",
            translation = "облом, конфуз (стыдная ситуация)",
            definition = "מַצָּב מְבַיֵּשׁ בְּפוּמְבִּי שֶׁמַּשְׁאִיר טַעַם רַע — אַתָּה מַרְגִּישׁ קָטָן מוּל אֲחֵרִים.",
            definitionNative = "Стыдная публичная ситуация с неприятным осадком — чувствуешь себя маленьким перед другими.",
            example = "שָׁכַחְתִּי אֶת שֵׁם הַמְּנַהֶלֶת בַּפְּגִישָׁה, אֵיזוֹ פָּדִיחָה.",
            exampleNative = "Забыл имя начальницы на встрече, какой פָּדִיחָה.",
            pos = "noun", semanticGroup = "idioms_slang_irritation", fillInBlankExclusions = listOf(191205L, 191217L)),

        WordEntity(id = 191217, setId = 1912, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "בַּלָּגָן",
            translation = "хаос, беспорядок, кавардак",
            definition = "מַצָּב מְבֻלְבָּל בַּחֶדֶר, בְּמַסְמָכִים אוֹ בְּתַהֲלִיכִים — שׁוּם דָּבָר לֹא בִּמְקוֹמוֹ.",
            definitionNative = "Запутанное состояние в комнате, в документах или в процессах — ничего не на месте.",
            example = "הַחֶדֶר שֶׁל הַיְלָדִים בַּלָּגָן מֻחְלָט אַחֲרֵי הַסּוֹף שָׁבוּעַ.",
            exampleNative = "В детской после выходных абсолютный בַּלָּגָן.",
            pos = "noun", semanticGroup = "idioms_slang_irritation", fillInBlankExclusions = listOf(191216L)),

        WordEntity(id = 191218, setId = 1912, languagePair = "he-ru", rarity = "RARE",
            original = "מֵסָאחֵב",
            translation = "потрясный, обалденный (арабизм)",
            definition = "תֹּאַר שֶׁבַח קִיצּוֹנִי לְאֹכֶל אוֹ חֲוָיָה — בֶּאֱמֶת לֹא רָגִיל, מַעֲרִיב אֶת הַחוּשִׁים.",
            definitionNative = "Крайняя похвальная оценка для еды или впечатления — реально нерядовое, восхищает.",
            example = "הַשָּׁוַוַארְמָה אֵצֶל אַבּוּ חַסַּן — מֵסָאחֵב, חוֹבָה לְנַסּוֹת.",
            exampleNative = "Шаурма у Абу Хасана — מֵסָאחֵב, обязательно попробуй.",
            pos = "adjective", semanticGroup = "idioms_slang_irritation", fillInBlankExclusions = listOf(191201L, 191202L, 191203L, 191204L, 191205L, 191211L)),

        WordEntity(id = 191219, setId = 1912, languagePair = "he-ru", rarity = "RARE",
            original = "עָזֹב שְׁטוּיוֹת",
            translation = "брось ерунду, хватит чушь нести",
            definition = "בַּקָּשָׁה לְהַפְסִיק לְדַבֵּר עַל דָּבָר רֵיק — נְגִישָׁה, לִפְעָמִים מְעַט תּוֹקְפָנִית.",
            definitionNative = "Просьба прекратить разговор о пустом — фамильярно, иногда с ноткой раздражения.",
            example = "אַתָּה עוֹד מַאֲמִין לַשְּׁמוּעָה? עֲזֹב שְׁטוּיוֹת, זֶה לֹא נָכוֹן.",
            exampleNative = "Ты ещё веришь слуху? עָזֹב שְׁטוּיוֹת, это неправда.",
            pos = "phrase", semanticGroup = "idioms_slang_irritation", fillInBlankExclusions = listOf(191207L, 191208L)),

        WordEntity(id = 191220, setId = 1912, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חַפִּיף",
            translation = "халтурно, на отвяжись (небрежно)",
            definition = "תֵּאוּר עֲבוֹדָה שֶׁנַּעַשְׂתָה בְּחֹסֶר רְצִינוּת — בִּמְהִירוּת, בְּלִי תְּשׂוּמַת לֵב לַפְּרָטִים.",
            definitionNative = "Описание работы, что сделана несерьёзно — быстро, без внимания к деталям.",
            example = "הַשִּׁפּוּצְנִיק עָבַד חַפִּיף, וְעַכְשָׁו הַצֶּבַע מִתְקַלֵּף.",
            exampleNative = "Ремонтник работал חַפִּיף, и теперь краска отслаивается.",
            pos = "adverb", semanticGroup = "idioms_slang_irritation", fillInBlankExclusions = listOf(191222L)),

        // ── Group: idioms_slang_address (5 words) ─────────────────────────────

        WordEntity(id = 191221, setId = 1912, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "יָאלָה",
            translation = "давай, пошли, ну (побуждение)",
            definition = "קְרִיאָה לִזְרִיזוּת אוֹ פְּתִיחָה — מֵעֲרָבִית, מַתְאִימָה לְכֹל קוֹנְטֶקְסְט יוֹמְיוֹמִי.",
            definitionNative = "Призыв поторопиться или начать — из арабского, подходит для любой повседневной ситуации.",
            example = "יָאלָה, אֲנַחְנוּ מְאַחֲרִים, צְרִיכִים לָצֵאת עַכְשָׁו.",
            exampleNative = "יָאלָה, мы опаздываем, надо выходить прямо сейчас.",
            pos = "interjection", semanticGroup = "idioms_slang_address", fillInBlankExclusions = listOf(191214L)),

        WordEntity(id = 191222, setId = 1912, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סְתָם",
            translation = "просто так, без причины (между прочим)",
            definition = "מִילַּת מַעֲבָר לְמַשֶּׁהוּ זָנִּיחַ אוֹ הַבְהָרָה שֶׁאֵין מַשְׁמָעוּת מְיֻחֶדֶת לְמַעֲשֶׂה.",
            definitionNative = "Слово-переход к мелочи или уточнение, что у действия нет особого смысла.",
            example = "לָמָּה הִתְקַשַּׁרְתָּ? — סְתָם, רָצִיתִי לִשְׁמֹעַ אֶת קוֹלֲךְ.",
            exampleNative = "Зачем позвонил? — סְתָם, хотелось услышать твой голос.",
            pos = "adverb", semanticGroup = "idioms_slang_address"),

        WordEntity(id = 191223, setId = 1912, languagePair = "he-ru", rarity = "RARE",
            original = "עוֹף הַחוֹל",
            translation = "редкость, диковинка (Феникс)",
            definition = "תֵּאוּר לְמַשֶּׁהוּ נָדִיר מְאוֹד שֶׁכִּמְעַט לֹא רוֹאִים — דָּבָר אַגָּדִי בְּחַיֵּי הַיּוֹם.",
            definitionNative = "Описание чего-то очень редкого, что почти не встречается — почти легендарного.",
            example = "פּוֹעֵל שֶׁבָּא בַּזְּמַן זֶה עוֹף הַחוֹל בִּימֵינוּ.",
            exampleNative = "Рабочий, что приходит вовремя — это עוֹף הַחוֹל в наши дни.",
            pos = "phrase", semanticGroup = "idioms_slang_address", fillInBlankExclusions = listOf(191210L, 191213L, 191224L)),

        WordEntity(id = 191224, setId = 1912, languagePair = "he-ru", rarity = "RARE",
            original = "הַחַיִּים שֶׁלִּי",
            translation = "жизнь моя (ласковое обращение)",
            definition = "פְּנִיָּה חַמָּה לְבֶן זוּג, יֶלֶד אוֹ חָבֵר קָרוֹב — בִּטּוּי חִבָּה מְקֻבָּל מְאוֹד.",
            definitionNative = "Тёплое обращение к близкому, ребёнку или другу — очень распространённое выражение нежности.",
            example = "מָה שְׁלוֹמְךָ, הַחַיִּים שֶׁלִּי, אֵיךְ הָיָה הַיּוֹם בְּגַן?",
            exampleNative = "Как ты, הַחַיִּים שֶׁלִּי, как день в садике?",
            pos = "phrase", semanticGroup = "idioms_slang_address", fillInBlankExclusions = listOf(191223L)),

        WordEntity(id = 191225, setId = 1912, languagePair = "he-ru", rarity = "RARE",
            original = "פַּז״ם",
            translation = "стаж в армии (אר״ת)",
            definition = "רָאשֵׁי תֵּבוֹת לִ״פֶּרֶק זְמַן מִינִימָאלִי״ — מַשְׁמָעוּתוֹ הַוָּתֶק שֶׁל חַיָּל בְּצָבָא.",
            definitionNative = "Аббревиатура от «минимальный отрезок времени» — обозначает выслугу солдата в армии.",
            example = "יֵשׁ לוֹ כְּבָר פַּז״ם שֶׁל שָׁנָה וָחֵצִי בַּיְּחִידָה.",
            exampleNative = "У него уже פַּז״ם в полтора года в части.",
            pos = "noun", semanticGroup = "idioms_slang_address"),
    )
}
