package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — topic "Кулинария Израиля", level 2 (A2-B1+).
 * Один сет × 25 слов. setId = 1843. Продолжение L1 (set 1842).
 *
 *  - 17 UNCOMMON + 8 RARE (два смежных уровня).
 *  - 5 семантических групп по 5 слов:
 *      cuisine_l2_techniques       — продвинутые техники: замочить,
 *                                    заморозить, на пару, обжарить, коптить (5)
 *      cuisine_l2_dishes_advanced  — продвинутые блюда: малавах, кубэ,
 *                                    махши, фата, сахлаб (5)
 *      cuisine_l2_kosher           — кашрут: молочное, мясное, парве,
 *                                    нетилат ядаим, печать раввината (5)
 *      cuisine_l2_drinks           — израильские напитки: тапузина, арак,
 *                                    кафе афух, кафе боц, гранатовый сок (5)
 *      cuisine_l2_holidays_food    — праздничная еда: гоменташи, харосет,
 *                                    кугель, кнейдлах, халва (5)
 *  - Не пересекается с L1 (set 1842): другие конкретные термины. Базовые
 *    блюда (פָלָאפֶל, חוּמּוּס, שַׁקְשׁוּקָה, בּוּרֶקַס, סָבִיח), ингредиенты
 *    (טַחִינָה, חִמְצָה, זַעְתַּר, אֲבוֹקָדוֹ, נַעֲנַע), трапезы (אֲרוּחַת
 *    בֹּקֶר, אֲרוּחַת עֶרֶב, אֲרוּחַת שַׁבָּת, חָמִין, חֲטִיף), действия
 *    (לֶאֱכֹל, לְבַשֵּׁל, לְהַזְמִין, לִטְעֹם, לִקְצֹץ) и места
 *    (חוּמּוּסִיָּה, פָלָאפֶלִיָּה, מַעֲדַנִיָּה, שׁוּק, מִסְעָדָה) остались
 *    в L1.
 *  - Замены против исходного плана из-за коллизий с уже существующими
 *    сетами в темах «Религия и праздники» (1053, 1710), «Бариста» (1739),
 *    «Готовка» (1374, 1375), «Алия» (Aliya), «Иммигрант» (Immigrant4/6),
 *    «Религия» (1701):
 *      לִצְלוֹת → לְקַלּוֹת (לִצְלוֹת уже UNCOMMON в Batch64/CookL4)
 *      לִימוֹנָדָה → קַפֶּה בּוֹץ (לִימוֹנָדָה уже UNCOMMON в BaristaL1L2L3)
 *      כָּשֵׁר → נֶטִילַת יָדַיִם (כָּשֵׁר уже COMMON в AliyaV2/Immigrant4/
 *                  ReligionL1; нельзя менять rarity)
 *      הַכְשָׁרָה → חוֹתֶמֶת רַבָּנוּת (הַכְשָׁרָה уже занят как «обучение»
 *                  в Batch72; здесь другой контекст «сертификация», но
 *                  безопаснее новая фраза)
 *      מַצָּה → אָזְנֵי הָמָן (מַצָּה уже COMMON в Batch10)
 *      לֶחֶם הַפָּנִים → קוּגֶל (לֶחֶם הַפָּנִים уже занят в Batch45)
 *      רִימּוֹנִים → מִיץ רִמּוֹנִים (более специфично, гранатовый напиток
 *                  как часть drinks-группы)
 *      שׁוֹקוֹלָד חַם → исключено (занят в BaristaL1L2L3); беру кафе боц
 *      סוּפְגָנִיָּה → חַלְוָה (סֻפְגָּנִיָּה уже COMMON в RelHolidaysL1;
 *                  халва — другой пасхальный/праздничный десерт)
 *  - Никудим везде (стандарт he-ru). Огласовки в `example` ставятся только
 *    на целевом слове.
 *  - fillInBlankExclusions / isFillInBlankSafe не задаются — заполнятся
 *    через FILL_IN_BLANK pipeline централизованно после wave.
 */
object WordDataHebrewIsraeliCuisineL2 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1843, languagePair = "he-ru", orderIndex = 1843,
            name = "Кулинария Израиля",
            description = "Продвинутые техники, кашрут, напитки и праздничная еда",
            topic = "Кулинария Израиля", level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ─── cuisine_l2_techniques (5) ───────────────────────────────────
        WordEntity(
            id = 184301, setId = 1843, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "cuisine_l2_techniques",
            original = "לְהַשְׁרוֹת", translation = "замачивать",
            transliteration = "леhашрот",
            definition = "לְהַשְׁאִיר אֹכֶל בְּמַיִם זְמַן רַב כְּדֵי שֶׁיִּתְרַכֵּךְ אוֹ יִסְפֹּג טַעַם.",
            definitionNative = "Оставлять продукт в воде надолго, чтобы он размяк или впитал вкус.",
            example = "צָרִיךְ לְהַשְׁרוֹת אֶת הַחִמְצָה כָּל הַלַּיְלָה לִפְנֵי הַבִּשּׁוּל.",
            exampleNative = "Надо לְהַשְׁרוֹת нут на всю ночь до варки утренней похлёбки.",
         fillInBlankExclusions = listOf(184302L, 184303L, 184304L, 184305L)),
        WordEntity(
            id = 184302, setId = 1843, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "cuisine_l2_techniques",
            original = "לְהַקְפִּיא", translation = "замораживать",
            transliteration = "леhакпи",
            definition = "לָשִׂים אֹכֶל בַּמַּקְפִּיא בְּטֶמְפֶּרָטוּרָה מִתַּחַת לְאֶפֶס לִשְׁמִירָה אֲרֻכָּה.",
            definitionNative = "Класть продукт в морозильник при температуре ниже нуля для хранения.",
            example = "אִמָּא נוֹהֶגֶת לְהַקְפִּיא מָנוֹת חָמִין לִשְׁבָתוֹת הַבָּאוֹת.",
            exampleNative = "Мама привыкла לְהַקְפִּיא порции чолента на следующие субботы.",
         fillInBlankExclusions = listOf(184301L, 184303L, 184304L, 184305L)),
        WordEntity(
            id = 184303, setId = 1843, languagePair = "he-ru", rarity = "RARE",
            pos = "verb", semanticGroup = "cuisine_l2_techniques",
            original = "לְבַשֵּׁל בְּאֵדִים", translation = "готовить на пару",
            transliteration = "леваше́ль беэдим",
            definition = "לְהָכִין יְרָקוֹת אוֹ דָּג מֵעַל מַיִם רוֹתְחִים בְּלִי לְהַטְבִּיעַ אוֹתָם.",
            definitionNative = "Делать овощи или рыбу над кипящей водой, не погружая их в жидкость.",
            example = "הַשֵּׁף הֶחְלִיט לְבַשֵּׁל בְּאֵדִים אֶת הַסַּלְמוֹן עִם נַעֲנַע.",
            exampleNative = "Шеф решил לְבַשֵּׁל בְּאֵדִים лосося с веточкой свежей мяты.",
         fillInBlankExclusions = listOf(184301L, 184302L, 184304L, 184305L)),
        WordEntity(
            id = 184304, setId = 1843, languagePair = "he-ru", rarity = "RARE",
            pos = "verb", semanticGroup = "cuisine_l2_techniques",
            original = "לְקַלּוֹת", translation = "обжаривать (всухую)",
            transliteration = "лекалот",
            definition = "לְחַמֵּם אֱגוֹזִים אוֹ זְרָעִים בַּתַּנּוּר אוֹ בַּמַּחֲבַת בְּלִי שֶׁמֶן עַד שֶׁיִּזְהִיבוּ.",
            definitionNative = "Греть орехи или семечки в духовке или на сковороде без масла до золотистости.",
            example = "כְּדַאי לְקַלּוֹת אֶת הַשֻּׁמְשׁוּם לִפְנֵי שֶׁמּוֹסִיפִים אוֹתוֹ לַזַּעְתַּר.",
            exampleNative = "Стоит לְקַלּוֹת кунжут перед добавлением его в смесь заатара дома.",
         fillInBlankExclusions = listOf(184301L, 184302L, 184303L, 184305L)),
        WordEntity(
            id = 184305, setId = 1843, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "verb", semanticGroup = "cuisine_l2_techniques",
            original = "לְעַשֵּׁן", translation = "коптить",
            transliteration = "леаше́н",
            definition = "לְהָכִין בָּשָׂר אוֹ דָּג מֵעַל עָשָׁן שֶׁל עֵצִים רֵיחָנִיִּים לְטַעַם מְיֻחָד.",
            definitionNative = "Готовить мясо или рыбу над дымом ароматных дров для особого вкуса.",
            example = "הַסַּבָּא יוֹדֵעַ לְעַשֵּׁן דָּג פוֹרֶל בָּאָרוּבָּה הַבֵּיתִית שֶׁלּוֹ.",
            exampleNative = "Дед умеет לְעַשֵּׁן рыбу-форель в самодельной дымовой трубе во дворе.",
         fillInBlankExclusions = listOf(184301L, 184302L, 184303L, 184304L)),

        // ─── cuisine_l2_dishes_advanced (5) ──────────────────────────────
        WordEntity(
            id = 184306, setId = 1843, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cuisine_l2_dishes_advanced",
            original = "מָלָוַח", translation = "малавах (йеменская лепёшка)",
            transliteration = "малавах",
            definition = "מַאֲפֶה תֵּימָנִי שָׁטוּחַ מִבָּצֵק עָלִים שֶׁמְּטַגְּנִים בְּמַחֲבַת עִם רֹטֶב עַגְבָנִיּוֹת.",
            definitionNative = "Йеменская плоская лепёшка из слоёного теста, что жарят на сковороде с томатным соусом.",
            example = "סַבְתָּא מִתֵּימָן הֵכִינָה לָנוּ מָלָוַח חַם לַאֲרוּחַת הַבֹּקֶר.",
            exampleNative = "Бабушка из Йемена приготовила нам горячий מָלָוַח на семейный завтрак.",
         fillInBlankExclusions = listOf(184307L, 184308L, 184309L, 184310L)),
        WordEntity(
            id = 184307, setId = 1843, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cuisine_l2_dishes_advanced",
            original = "קוּבֶּה", translation = "кубэ (фаршированные клёцки)",
            transliteration = "кубэ",
            definition = "כַּדּוּרֵי בּוּרְגוּל אוֹ סֹלֶת מְמֻלָּאִים בְּבָשָׂר טָחוּן שֶׁמּוֹסִיפִים לְמָרָק.",
            definitionNative = "Шарики из булгура или манки, фаршированные молотым мясом, что подают в супе.",
            example = "מָרַק קוּבֶּה סֶלֶק אָדֹם הוּא הַמָּנָה הָעִירָאקִית הַחַמָּה הָאֲהוּבָה בָּאָרֶץ.",
            exampleNative = "Суп с קוּבֶּה из красной свёклы — любимое горячее блюдо иракских евреев в Израиле.",
         fillInBlankExclusions = listOf(184306L, 184308L, 184309L, 184310L)),
        WordEntity(
            id = 184308, setId = 1843, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cuisine_l2_dishes_advanced",
            original = "מַחְשִׁי", translation = "махши (фаршированные овощи)",
            transliteration = "махши",
            definition = "יְרָקוֹת חֲלוּלִים — פִּלְפֵּל, חָצִיל אוֹ קִישּׁוּא — מְמֻלָּאִים בְּאֹרֶז וּבָשָׂר.",
            definitionNative = "Полые овощи — перец, баклажан или кабачок — фаршированные рисом и мясом.",
            example = "הַשְּׁכֵנָה הַסּוּרִית מְלַמֶּדֶת אוֹתִי לְהָכִין מַחְשִׁי כְּמוֹ אֵצֶל אִמָּהּ.",
            exampleNative = "Соседка-сирийка учит меня готовить מַחְשִׁי как у её мамы дома в Алеппо.",
         fillInBlankExclusions = listOf(184306L, 184307L, 184309L, 184310L, 184325L)),
        WordEntity(
            id = 184309, setId = 1843, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cuisine_l2_dishes_advanced",
            original = "פָתָה", translation = "фата (хлебный суп с нутом)",
            transliteration = "фата",
            definition = "מָנָה לְבָנוֹנִית-פָּלֶסְטִינִית מִפִּיתָה יְבֵשָׁה, חִמְצָה, יוֹגוּרְט וּטְחִינָה.",
            definitionNative = "Ливанско-палестинское блюдо из засохшей питы, нута, йогурта и тхины.",
            example = "בְּמִסְעֶדֶת הַחוּמּוּס הַחֲדָשָׁה מַגִּישִׁים פָתָה בְּקַעֲרוֹת חֵרֶס חַמּוֹת.",
            exampleNative = "В новой хумусной подают פָתָה в горячих керамических плошках с пылу с жару.",
         fillInBlankExclusions = listOf(184306L, 184307L, 184308L, 184310L)),
        WordEntity(
            id = 184310, setId = 1843, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cuisine_l2_dishes_advanced",
            original = "סָחְלָב", translation = "сахлаб (молочный десерт)",
            transliteration = "сахлав",
            definition = "מַשְׁקֶה חַם וְסָמִיךְ מֵחָלָב עִם קִינָּמוֹן וֶאֱגוֹזִים — חוֹרֶף בְּיָפוֹ.",
            definitionNative = "Горячий густой молочный напиток с корицей и орехами — зимний вкус Яффо.",
            example = "בִּימֵי גֶּשֶׁם הַדּוּכָן בְּיָפוֹ מוֹכֵר סָחְלָב חַם בִּכְלִי קַרְטוֹן.",
            exampleNative = "В дождливые дни ларёк в Яффо торгует горячим סָחְלָב в картонных стаканчиках.",
         fillInBlankExclusions = listOf(184306L, 184307L, 184308L, 184309L)),

        // ─── cuisine_l2_kosher (5) ───────────────────────────────────────
        WordEntity(
            id = 184311, setId = 1843, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "cuisine_l2_kosher",
            original = "חָלָבִי", translation = "молочный (по кашруту)",
            transliteration = "халави",
            definition = "אֹכֶל שֶׁמֵּכִיל חָלָב אוֹ גְּבִינָה — אָסוּר בְּעִרְבּוּב עִם בָּשָׂר.",
            definitionNative = "Еда с молоком или сыром — её нельзя смешивать с мясом по кашруту.",
            example = "אַחֲרֵי אֲרוּחָה חָלָבִי מַמְתִּינִים שָׁעָה לִפְנֵי שֶׁאוֹכְלִים בָּשָׂר.",
            exampleNative = "После חָלָבִי трапезы ждут час прежде чем сесть за мясное блюдо.",
         fillInBlankExclusions = listOf(184312L, 184313L)),
        WordEntity(
            id = 184312, setId = 1843, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "cuisine_l2_kosher",
            original = "בְּשָׂרִי", translation = "мясной (по кашруту)",
            transliteration = "бесари",
            definition = "אֹכֶל שֶׁמֵּכִיל בָּשָׂר עוֹף אוֹ בְּהֵמָה — אָסוּר בְּעִרְבּוּב עִם חָלָב.",
            definitionNative = "Еда с мясом птицы или скота — её нельзя смешивать с молоком по кашруту.",
            example = "בַּמִּטְבָּח בְּשָׂרִי מַחֲזִיקִים סִירִים נִפְרָדִים מֵהַמִּטְבָּח הֶחָלָבִי.",
            exampleNative = "На בְּשָׂרִי кухне держат отдельные кастрюли от молочной кухни напротив.",
         fillInBlankExclusions = listOf(184313L)),
        WordEntity(
            id = 184313, setId = 1843, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "adjective", semanticGroup = "cuisine_l2_kosher",
            original = "פַּרְוֶה", translation = "парве (нейтральная еда)",
            transliteration = "парве",
            definition = "אֹכֶל בְּלִי בָּשָׂר וּבְלִי חָלָב — מֻתָּר עִם שְׁנֵיהֶם, כְּמוֹ דָּג אוֹ יְרָקוֹת.",
            definitionNative = "Еда без мяса и без молока — разрешена с обоими, как рыба или овощи.",
            example = "הַסָּלָט הַזֶּה פַּרְוֶה וְאֶפְשָׁר לְהַגִּישׁ אוֹתוֹ עִם בָּשָׂר אוֹ עִם גְּבִינָה.",
            exampleNative = "Этот салат פַּרְוֶה и его можно подавать как с мясом, так и с сыром.",
         fillInBlankExclusions = listOf(184311L, 184312L)),
        WordEntity(
            id = 184314, setId = 1843, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cuisine_l2_kosher",
            original = "נֶטִילַת יָדַיִם", translation = "ритуальное омовение рук",
            transliteration = "нетилат ядаим",
            definition = "מִצְוָה לִשְׁפֹּךְ מַיִם פַּעֲמַיִם עַל כָּל יָד לִפְנֵי אֲרוּחָה עִם לֶחֶם.",
            definitionNative = "Заповедь дважды лить воду на каждую руку перед трапезой с хлебом.",
            example = "לִפְנֵי הַסְּעוּדָה הַשַּׁבָּתִית עוֹשִׂים נֶטִילַת יָדַיִם בַּכִּיּוֹר עִם נָטְלָה.",
            exampleNative = "Перед субботней трапезой совершают נֶטִילַת יָדַיִם у раковины с особым кубком.",
         fillInBlankExclusions = listOf(184315L)),
        WordEntity(
            id = 184315, setId = 1843, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cuisine_l2_kosher",
            original = "חוֹתֶמֶת רַבָּנוּת", translation = "печать раввината (сертификат кашрута)",
            transliteration = "хотемет раббанут",
            definition = "אִשּׁוּר רִשְׁמִי שֶׁל הָרַבָּנוּת שֶׁמּוּצָר אוֹ מִסְעֶדֶת הִיא כְּשֵׁרָה.",
            definitionNative = "Официальное подтверждение раввината о том, что продукт или ресторан кошерны.",
            example = "בְּלִי חוֹתֶמֶת רַבָּנוּת הַסּוּפֶּר לֹא יִקְנֶה אֶת הַבָּשָׂר מֵהָאַטְלִיז הַחָדָשׁ.",
            exampleNative = "Без חוֹתֶמֶת רַבָּנוּת супермаркет не закупит мясо у новой мясной лавки в районе.",
         fillInBlankExclusions = listOf(184314L)),

        // ─── cuisine_l2_drinks (5) ───────────────────────────────────────
        WordEntity(
            id = 184316, setId = 1843, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cuisine_l2_drinks",
            original = "תַּפּוּזִינָה", translation = "тапузина (апельсиновая газировка)",
            transliteration = "тапузина",
            definition = "מַשְׁקֶה תּוֹסֵס מָתוֹק בְּטַעַם תַּפּוּז — סֵמֶל לְקַיִץ יִשְׂרְאֵלִי.",
            definitionNative = "Сладкий газированный напиток со вкусом апельсина — символ израильского лета.",
            example = "הַיְּלָדִים בִּקְּשׁוּ בַּקְבּוּק תַּפּוּזִינָה קַר לִקְרַאת הַבְּרֵכָה בַּצָּהֳרַיִם.",
            exampleNative = "Дети попросили холодную бутылку תַּפּוּזִינָה к выходу в бассейн в полдень.",
         fillInBlankExclusions = listOf(184317L, 184318L, 184319L, 184320L)),
        WordEntity(
            id = 184317, setId = 1843, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cuisine_l2_drinks",
            original = "אַרָק", translation = "арак (анисовая водка)",
            transliteration = "арак",
            definition = "מַשְׁקֶה חָרִיף שָׁקוּף בְּטַעַם אֲנִיס — מִתְעַרְבֵּב בְּמַיִם וְהוֹפֵךְ לְלָבָן.",
            definitionNative = "Крепкий прозрачный напиток со вкусом аниса — мутнеет до белизны при разбавлении.",
            example = "בַּחֲגִיגוֹת הַמִּזְרָחִיּוֹת מַגִּישִׁים אַרָק עִם קֶרַח וְלִימוֹן בְּכוֹסִיּוֹת קְטַנּוֹת.",
            exampleNative = "На восточных торжествах подают אַרָק со льдом и лимоном в маленьких рюмках.",
         fillInBlankExclusions = listOf(184316L, 184318L, 184319L, 184320L)),
        WordEntity(
            id = 184318, setId = 1843, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cuisine_l2_drinks",
            original = "קָפֶה הָפוּךְ", translation = "кафе афух (израильское латте)",
            transliteration = "кафе афух",
            definition = "קָפֶה חַם בְּכוֹס גְּדוֹלָה עִם הַרְבֵּה חָלָב מוּקְצָף — קָלָאסִיקָה בְּתֵל אָבִיב.",
            definitionNative = "Горячий кофе в большой кружке с обилием взбитого молока — классика тель-авивских кафе.",
            example = "בַּבֹּקֶר הִזְמַנְתִּי קָפֶה הָפוּךְ עַל מִרְפֶּסֶת בֵּית הַקָּפֶה מוּל הַיָּם.",
            exampleNative = "С утра я заказал קָפֶה הָפוּךְ на террасе кофейни напротив набережной моря.",
        ),
        WordEntity(
            id = 184319, setId = 1843, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cuisine_l2_drinks",
            original = "קַפֶּה בּוֹץ", translation = "кафе боц (турецкий кофе)",
            transliteration = "кафе боц",
            definition = "קָפֶה טָחוּן עָבֶה שֶׁמַּכִּינִים בְּכוֹס בְּלִי סִנּוּן — שׁוֹתִים מִלְמַעְלָה זָהִיר.",
            definitionNative = "Грубомолотый кофе, что заваривают в чашке без фильтра — пьют осторожно с поверхности.",
            example = "אַבָּא מַעֲדִיף קַפֶּה בּוֹץ עִם הֵל מָרוֹקָאִי וּבְלִי סֻכָּר בָּעֶרֶב.",
            exampleNative = "Папа предпочитает קַפֶּה בּוֹץ с марокканским кардамоном и без сахара по вечерам.",
         fillInBlankExclusions = listOf(184316L, 184317L, 184318L, 184320L)),
        WordEntity(
            id = 184320, setId = 1843, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cuisine_l2_drinks",
            original = "מִיץ רִמּוֹנִים", translation = "гранатовый сок",
            transliteration = "миц римоним",
            definition = "מַשְׁקֶה אָדֹם סָמִיךְ הַנִּסְחָט מִפְּרִי גַּרְעִינִי — סִימָן לְשָׁנָה טוֹבָה.",
            definitionNative = "Густой красный напиток, что выжимают из зернистого плода — символ доброго года.",
            example = "בַּדּוּכָן בַּשּׁוּק סוֹחֲטִים מִיץ רִמּוֹנִים טָרִי לְעֵינֵי הַלָּקוֹחוֹת.",
            exampleNative = "В ларьке на рынке выжимают свежий מִיץ רִמּוֹנִים прямо на глазах у клиентов.",
         fillInBlankExclusions = listOf(184316L, 184317L, 184318L, 184319L)),

        // ─── cuisine_l2_holidays_food (5) ────────────────────────────────
        WordEntity(
            id = 184321, setId = 1843, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cuisine_l2_holidays_food",
            original = "אָזְנֵי הָמָן", translation = "гоменташи (треугольное печенье на Пурим)",
            transliteration = "ознэ hаман",
            definition = "עוּגִיּוֹת מְשֻׁלָּשׁוֹת מְמֻלָּאוֹת בְּפֶרֶג אוֹ בְּשׁוֹקוֹלָד שֶׁאוֹכְלִים בְּפּוּרִים.",
            definitionNative = "Треугольное печенье с маком или шоколадной начинкой, что едят на Пурим.",
            example = "בְּבֵית הַסֵּפֶר חִלְּקוּ אָזְנֵי הָמָן בְּמִשְׁלוֹחַ מָנוֹת לְכָל יֶלֶד וָיֶלֶד.",
            exampleNative = "В школе раздавали אָזְנֵי הָמָן в подарочных пакетах каждому ребёнку без исключения.",
         fillInBlankExclusions = listOf(184322L, 184323L, 184324L, 184325L)),
        WordEntity(
            id = 184322, setId = 1843, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cuisine_l2_holidays_food",
            original = "הָרוֹסֶת", translation = "харосет (паста на седер Песаха)",
            transliteration = "харосет",
            definition = "מִמְרָח חוּם וּמָתוֹק מִתַּפּוּחִים, אֱגוֹזִים וְיַיִן — סִמְלוֹ הַטִּיט שֶׁבְּמִצְרַיִם.",
            definitionNative = "Коричневая сладкая паста из яблок, орехов и вина — её символ — глина из Египта.",
            example = "בְּלֵיל הַסֵּדֶר טוֹבְלִים מָרוֹר בְּהָרוֹסֶת לִפְנֵי שֶׁאוֹכְלִים אוֹתוֹ.",
            exampleNative = "В пасхальную ночь обмакивают горькую зелень в הָרוֹסֶת перед тем как съесть.",
         fillInBlankExclusions = listOf(184321L, 184323L, 184324L, 184325L)),
        WordEntity(
            id = 184323, setId = 1843, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cuisine_l2_holidays_food",
            original = "קוּגֶל", translation = "кугель (запеканка)",
            transliteration = "кугель",
            definition = "תַּבְשִׁיל אֲפוּי מֵאִטְרִיּוֹת אוֹ מִתַּפּוּחֵי אֲדָמָה — מָנָה אַשְׁכְּנַזִּית לְשַׁבָּת.",
            definitionNative = "Запечённое блюдо из лапши или картошки — ашкеназская кушанье на субботу.",
            example = "סָבְתָא הִכִינָה קוּגֶל יְרוּשַׁלְמִי מָתוֹק עִם פִּלְפֵּל שָׁחֹר חָרִיף.",
            exampleNative = "Бабушка приготовила сладкий иерусалимский קוּגֶל с острым чёрным перцем.",
         fillInBlankExclusions = listOf(184321L, 184322L, 184324L, 184325L)),
        WordEntity(
            id = 184324, setId = 1843, languagePair = "he-ru", rarity = "RARE",
            pos = "noun", semanticGroup = "cuisine_l2_holidays_food",
            original = "קְנֵיידְלָךְ", translation = "кнейдлах (клёцки из мацы)",
            transliteration = "кнейдлах",
            definition = "כַּדּוּרִים רַכִּים מִקֶּמַח מַצָּה וּבֵיצָה שֶׁמְּבַשְּׁלִים בְּמָרָק עוֹף לְפֶסַח.",
            definitionNative = "Мягкие шарики из мацовой муки и яйца, что варят в курином бульоне на Песах.",
            example = "מָרָק הָעוֹף שֶׁל אִמָּא תָּמִיד מַגִּיעַ עִם קְנֵיידְלָךְ אֲוִירִיִּים בְּלֵיל הַסֵּדֶר.",
            exampleNative = "Мамин куриный суп всегда подаётся с воздушными קְנֵיידְלָךְ в пасхальную ночь.",
        ),
        WordEntity(
            id = 184325, setId = 1843, languagePair = "he-ru", rarity = "UNCOMMON",
            pos = "noun", semanticGroup = "cuisine_l2_holidays_food",
            original = "חַלְוָה", translation = "халва (кунжутный десерт)",
            transliteration = "халва",
            definition = "מַמְתָּק מִזְרָחִי קָשֶׁה מִשַּׁמְשׁוּם טָחוּן וְסֻכָּר — חוֹתְכִים לְפְרוּסוֹת בַּשּׁוּק.",
            definitionNative = "Восточная твёрдая сладость из молотого кунжута и сахара — режут на ломти на рынке.",
            example = "בַּשּׁוּק מַחֲנֵה יְהוּדָה קוֹנִים חַלְוָה עִם פִּסְתּוּקִים בְּמִשְׁקָל בְּכָל בֹּקֶר.",
            exampleNative = "На рынке Махане-Йехуда покупают חַלְוָה с фисташками на вес каждое утро.",
         fillInBlankExclusions = listOf(184321L, 184322L, 184323L, 184324L)),
    )
}
