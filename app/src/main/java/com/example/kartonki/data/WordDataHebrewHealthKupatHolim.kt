package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — set 1917 (he-ru).
 * Здоровье и фитнес: купат-холим и медицинская система Израиля (L3 / UNCOMMON + RARE).
 *
 * Уникальный для he-ru угол: практическая навигация по медсистеме —
 * переход между кассами, запись и очереди, возврат денег, сети неотложной
 * помощи (Терэм, Натали, МАДА), нюансы добавочных программ. Это L3
 * углублённый: репатриант уже знает, что такое קוּפַּת חוֹלִים, и теперь
 * учится пользоваться системой эффективно.
 *
 * Тема «Здоровье и фитнес» = три существующих сета 1727/1728/1729
 * (lifestyle, фитнес, нутрициология/биомеханика). Дополняет их прикладной
 * лексикой системы здравоохранения, без пересечений с фитнес-сетами.
 *
 * Дубли внутри темы «Здоровье и фитнес» (validate_no_duplicates):
 *   - Все 25 слов уникальны для темы — grep'нуты по originals в 1727/1728/1729.
 *
 * Cross-topic пересечений с близкими темами («У врача в Израиле», «Медицина»,
 * «Бюрократия и документы») сознательно избегаем:
 *   - НЕ берём базовые кассы (קוּפַּת חוֹלִים / כְּלָלִית / מַכַּבִּי / מְאוּחֶדֶת /
 *     לְאוּמִית) — они в Batch68 как COMMON и DoctorL4 как EPIC/LEGENDARY;
 *     рарность для L3 не совпала бы ни с одной стороной.
 *   - НЕ берём סַל הַבְּרִיאוּת, הִשְׁתַּתְּפוּת עַצְמִית, בִּטּוּחַ מַשְׁלִים,
 *     רוֹפֵא יוֹעֵץ — все в DoctorL4 как EPIC. Менять их рарность нельзя
 *     (правило 2: rarity объективна).
 *   - НЕ берём базовые מִרְשָׁם / רוֹפֵא מִשְׁפָּחָה / אַמְבּוּלַנְס / הַפְנָיָה —
 *     все COMMON в Batch68 (Алия-медицина).
 *   - НЕ берём חֲדַר מִיּוּן / מָגֵן דָּוִד אָדוֹם — в DoctorL3.
 *   Вместо этого — 25 свежих оригиналов, не встречающихся ни в одном
 *   he-ru файле: переход между кассами, дежурная служба, домашняя скорая,
 *   возврат денег, форма запроса, превентивная и удалённая медицина.
 *
 * Распределение редкости (validate_rarity_spread: 2 смежных уровня A2-B1 + B2):
 *   UNCOMMON — 11 (A2-B1): практическая лексика, которой пользуется любой
 *     взрослый репатриант: запись, очереди, филиал кассы, телефон 101.
 *   RARE — 14 (B2): продвинутая лексика навигации по системе: переходы
 *     между кассами, частные сети, формы возврата, потолок платежа,
 *     генетический скрининг.
 *
 * Пять семантических подгрупп (validate_group_sizes: 3-8 на группу):
 *   health_il_kassot      — 5: касса и переходы между ними
 *   health_il_appointments — 5: запись, очереди, превентивная и удалённая
 *   health_il_payments    — 5: финансы — возврат, квитанции, потолок
 *   health_il_diagnostics — 5: бронирование и виды обследований
 *   health_il_emergency   — 5: горячие линии и сети неотложки (Терэм/Натали)
 *
 * Все слова помечены isFillInBlankSafe = false: ивритская морфология
 * (биньян, огласовки, артикли ה/ב/ל/מ, смихут на фразах) ломает подстрочную
 * замену в FILL_IN_BLANK, пока не реализована Hebrew-aware логика. Финальный
 * pipeline (`scripts/validate/generate_fill_in_blank_exclusions.py`) проставит
 * exclusions и снимет флаг для безопасных слов.
 *
 * Word IDs: 191701..191725 (setId × 100 + position).
 */
object WordDataHebrewHealthKupatHolim {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1917, languagePair = "he-ru", orderIndex = 1917,
            name = "Здоровье и фитнес",
            description = "Купат-холим и медсистема Израиля: переход между кассами, очереди, возврат денег, сети Терэм и Натали, формы и горячие линии.",
            topic = "Здоровье и фитнес",
            level = 3,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: health_il_kassot (5 words) ─────────────────────────────────

        WordEntity(id = 191701, setId = 1917, languagePair = "he-ru", rarity = "RARE",
            original = "מַעֲבָר קֻפָּה",
            translation = "переход между больничными кассами",
            definition = "פְּעֻלָּה רִשְׁמִית שֶׁל עֲזִיבַת קֻפַּת חוֹלִים אַחַת וְהִצְטָרְפוּת לְקֻפָּה אַחֶרֶת.",
            definitionNative = "Официальное действие — выход из одной больничной кассы и вступление в другую.",
            example = "מַעֲבָר קֻפָּה מִתְבַּצֵּעַ דֶּרֶךְ הָאֲתָר שֶׁל הַבִּטּוּחַ הַלְּאֻמִּי.",
            exampleNative = "מַעֲבָר קֻפָּה оформляется через сайт Битуах Леуми за пару минут.",
            transliteration = "маавар купа",
            pos = "phrase", semanticGroup = "health_il_kassot", fillInBlankExclusions = listOf(191702L, 191703L, 191704L, 191705L)),

        WordEntity(id = 191702, setId = 1917, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "כַּרְטִיס מְבֻטָּח",
            translation = "карта застрахованного (магнитная)",
            definition = "כַּרְטִיס פְּלַסְטִיק שֶׁל הַקֻּפָּה — מַזְהֶה אֶת הַחוֹלֶה בְּמִרְפָּאָה וּבְבֵית מִרְקַחַת.",
            definitionNative = "Пластиковая карта кассы — идентифицирует пациента в клинике и в аптеке.",
            example = "בְּלִי כַּרְטִיס מְבֻטָּח הָאָחוֹת לֹא יְכוֹלָה לִפְתֹּחַ אֶת הַתִּיק.",
            exampleNative = "Без כַּרְטִיס מְבֻטָּח медсестра не сможет открыть мою медкарту.",
            transliteration = "картис мэвутах",
            pos = "phrase", semanticGroup = "health_il_kassot", fillInBlankExclusions = listOf(191701L, 191703L, 191704L, 191705L)),

        WordEntity(id = 191703, setId = 1917, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "סָנִיף קֻפַּת חוֹלִים",
            translation = "филиал больничной кассы",
            definition = "מִשְׂרָד שָׁכוּן בַּשְּׁכוּנָה שֶׁמַּעֲנִיק שֵׁרוּתֵי הָרְשָׁמָה וּבְדִיקוֹת בְּסִיסִיּוֹת.",
            definitionNative = "Офис в районе, где оформляют записи и сдают базовые анализы рядом с домом.",
            example = "סָנִיף קֻפַּת חוֹלִים נִפְתָּח בְּשֶׁבַע בַּבֹּקֶר וְעוֹמֵד עַד הָעֶרֶב.",
            exampleNative = "סָנִיף קֻפַּת חוֹלִים открывается в семь утра и стоит открытым до вечера.",
            transliteration = "сниф купат холим",
            pos = "phrase", semanticGroup = "health_il_kassot", fillInBlankExclusions = listOf(191701L, 191702L, 191704L, 191705L)),

        WordEntity(id = 191704, setId = 1917, languagePair = "he-ru", rarity = "RARE",
            original = "רֶשֶׁת רוֹפְאֵי הֶסְכֵּם",
            translation = "сеть врачей по договору",
            definition = "מֻמְחִים פְּרָטִיִּים שֶׁחָתְמוּ עִם הַקֻּפָּה — בִּקּוּר זוֹל בְּלִי תַּשְׁלוּם מָלֵא.",
            definitionNative = "Частные специалисты, заключившие соглашение с кассой, — визит у них дешевле полного.",
            example = "מָצָאתִי אוֹרְתוֹפֵד טוֹב בְּרֶשֶׁת רוֹפְאֵי הֶסְכֵּם בָּאֲתָר.",
            exampleNative = "Я нашла хорошего ортопеда в רֶשֶׁת רוֹפְאֵי הֶסְכֵּם прямо на сайте.",
            transliteration = "рэшэт рофэй hэскэм",
            pos = "phrase", semanticGroup = "health_il_kassot", fillInBlankExclusions = listOf(191701L, 191702L, 191703L, 191705L)),

        WordEntity(id = 191705, setId = 1917, languagePair = "he-ru", rarity = "RARE",
            original = "מוֹעֲדוֹן בְּרִיאוּת",
            translation = "программа лояльности кассы",
            definition = "מַסְלוּל נָבוֹן בְּתוֹךְ הַקֻּפָּה — הֲנָחוֹת עַל חוּגֵי סְפּוֹרְט וְעַל תְּזוּנָה.",
            definitionNative = "Бонусная программа внутри кассы — скидки на спортивные кружки и на консультации диетолога.",
            example = "הִצְטָרַפְתִּי לְמוֹעֲדוֹן בְּרִיאוּת וְקִבַּלְתִּי הֲנָחָה עַל חֲדַר כֹּשֶׁר.",
            exampleNative = "Я записалась в מוֹעֲדוֹן בְּרִיאוּת и получила скидку на абонемент в зал.",
            transliteration = "моадон бриют",
            pos = "phrase", semanticGroup = "health_il_kassot", fillInBlankExclusions = listOf(191701L, 191702L, 191703L, 191704L)),

        // ── Group: health_il_appointments (5 words) ───────────────────────────

        WordEntity(id = 191706, setId = 1917, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תּוֹר רְפוּאִי",
            translation = "запись на приём (медицинская)",
            definition = "מוֹעֵד פָּנוּי שֶׁמְּזַמְּנִים מֵרֹאשׁ אֵצֶל רוֹפֵא דֶּרֶךְ הָאַפְּלִיקַצְיָה אוֹ הַטֶּלֶפוֹן.",
            definitionNative = "Свободное время, забронированное заранее у врача через приложение или по телефону.",
            example = "קָבַעְתִּי תּוֹר רְפוּאִי לְעֵינַיִים לְעוֹד שְׁבוּעַיִם.",
            exampleNative = "Я записалась на תּוֹר רְפוּאִי к окулисту через две недели.",
            transliteration = "тор рэфуи",
            pos = "phrase", semanticGroup = "health_il_appointments", fillInBlankExclusions = listOf(191707L, 191708L, 191709L, 191710L)),

        WordEntity(id = 191707, setId = 1917, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תּוֹר רָחוֹק",
            translation = "далёкая очередь (на месяцы вперёд)",
            definition = "מוֹעֵד פָּנוּי רַק בְּעוֹד חֳדָשִׁים — תּוֹפָעָה רְגִילָה אֵצֶל מֻמְחֵי קֻפָּה.",
            definitionNative = "Свободная запись только через месяцы — обычное явление у специалистов в кассе.",
            example = "קִבַּלְתִּי תּוֹר רָחוֹק לְעוֹר רַק בְּסוֹף הַשָּׁנָה.",
            exampleNative = "Мне дали תּוֹר רָחוֹק к дерматологу только на конец года.",
            transliteration = "тор рахок",
            pos = "phrase", semanticGroup = "health_il_appointments", fillInBlankExclusions = listOf(191706L, 191708L, 191709L, 191710L)),

        WordEntity(id = 191708, setId = 1917, languagePair = "he-ru", rarity = "RARE",
            original = "רְפוּאָה מְקַדֶּמֶת",
            translation = "превентивная медицина",
            definition = "בְּדִיקוֹת וְחִסּוּנִים שֶׁעוֹשִׂים מֵרֹאשׁ — לִמְנֹעַ מַחֲלוֹת לִפְנֵי שֶׁמּוֹפִיעוֹת.",
            definitionNative = "Обследования и прививки, что делают заранее, — чтобы предупредить болезни до их появления.",
            example = "רְפוּאָה מְקַדֶּמֶת מַצִּילָה כֶּסֶף וְזְמַן בַּטְּוָוח הָאָרֹךְ.",
            exampleNative = "רְפוּאָה מְקַדֶּמֶת экономит деньги и время в долгосрочной перспективе.",
            transliteration = "рэфуа мкадэмэт",
            pos = "phrase", semanticGroup = "health_il_appointments", fillInBlankExclusions = listOf(191706L, 191707L, 191709L, 191710L)),

        WordEntity(id = 191709, setId = 1917, languagePair = "he-ru", rarity = "RARE",
            original = "בִּקּוּר בַּיִת רְפוּאִי",
            translation = "врач на дом",
            definition = "הַגָּעַת רוֹפֵא לְבֵית הַחוֹלֶה — שֵׁרוּת לְקְשִׁישִׁים וּלְמִי שֶׁאֵינוֹ נַיָּד.",
            definitionNative = "Приход врача на дом к пациенту — услуга для пожилых и для тех, кто не может ходить.",
            example = "הִזְמַנְתִּי בִּקּוּר בַּיִת רְפוּאִי לְסָבָתָא כִּי הִיא לֹא יְכוֹלָה לָצֵאת.",
            exampleNative = "Я заказала בִּקּוּר בַּיִת רְפוּאִי бабушке, потому что она не выходит из дома.",
            transliteration = "бикур баит рэфуи",
            pos = "phrase", semanticGroup = "health_il_appointments", fillInBlankExclusions = listOf(191706L, 191707L, 191708L, 191710L)),

        WordEntity(id = 191710, setId = 1917, languagePair = "he-ru", rarity = "RARE",
            original = "רְפוּאָה מֵרָחוֹק",
            translation = "телемедицина (видео-приём)",
            definition = "פְּגִישָׁה עִם רוֹפֵא בְּוִידֵאוֹ אוֹ בְּצַ'ט — בְּלִי לְהַגִּיעַ פִיזִית לַסָּנִיף.",
            definitionNative = "Встреча с врачом в видео или в чате — без необходимости физически приходить в филиал.",
            example = "רְפוּאָה מֵרָחוֹק מַתְאִימָה לְמַחֲלוֹת קַלּוֹת וּלְמַעֲקַב כְּרוֹנִי.",
            exampleNative = "רְפוּאָה מֵרָחוֹק подходит для лёгких заболеваний и для хронического наблюдения.",
            transliteration = "рэфуа мэрахок",
            pos = "phrase", semanticGroup = "health_il_appointments", fillInBlankExclusions = listOf(191706L, 191707L, 191708L, 191709L)),

        // ── Group: health_il_payments (5 words) ───────────────────────────────

        WordEntity(id = 191711, setId = 1917, languagePair = "he-ru", rarity = "RARE",
            original = "טוֹפֶס בַּקָּשַׁת הַחְזֵר",
            translation = "форма запроса возврата денег",
            definition = "טֹפֶס שֶׁמְּמַלְּאִים כְּדֵי לְקַבֵּל בַּחֲזָרָה תַּשְׁלוּם עַל שֵׁרוּת רְפוּאִי.",
            definitionNative = "Бланк, который заполняют, чтобы получить обратно деньги за медицинскую услугу.",
            example = "הֵגַשְׁתִּי טוֹפֶס בַּקָּשַׁת הַחְזֵר עַל בְּדִיקַת אוּלְטְרָה-סָאוּנְד.",
            exampleNative = "Я подала טוֹפֶס בַּקָּשַׁת הַחְזֵר на УЗИ, что делала в частной клинике.",
            transliteration = "тофэс бакашат hахзэр",
            pos = "phrase", semanticGroup = "health_il_payments", fillInBlankExclusions = listOf(191712L, 191713L, 191714L, 191715L)),

        WordEntity(id = 191712, setId = 1917, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תְּלוּשׁ קַבָּלָה",
            translation = "квитанция (об оплате в кассе)",
            definition = "פֶּתֶק נְיָר שֶׁמְּעִיד עַל תַּשְׁלוּם בְּדַלְפֵּק הַקֻּפָּה — נִשְׁמָר לְהַחְזֵר אוֹ לְמַס.",
            definitionNative = "Бумажный талон, что подтверждает оплату у стойки кассы, — хранят для возврата или для налоговой.",
            example = "שָׁמַרְתִּי תְּלוּשׁ קַבָּלָה כְּדֵי לְהַגִּישׁ לְמַס הַכְנָסָה בְּסוֹף הַשָּׁנָה.",
            exampleNative = "Я сохранила תְּלוּשׁ קַבָּלָה, чтобы подать в налоговую в конце года.",
            transliteration = "тлуш кабала",
            pos = "phrase", semanticGroup = "health_il_payments", fillInBlankExclusions = listOf(191711L, 191713L, 191714L, 191715L)),

        WordEntity(id = 191713, setId = 1917, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "דְּמֵי חָבֵר",
            translation = "членский взнос (за дополнительную программу)",
            definition = "תַּשְׁלוּם חָדְשִׁי קָבוּעַ עַל הַתָּכְנִית הַמַּשְׁלִימָה שֶׁל הַקֻּפָּה.",
            definitionNative = "Фиксированная ежемесячная оплата за дополнительную программу кассы, поверх базовой страховки.",
            example = "דְּמֵי חָבֵר בָּעַלוּ הַשָּׁנָה בְּכַעֲשָׂרָה אֲחוּזִים.",
            exampleNative = "דְּמֵי חָבֵר подорожали в этом году примерно на десять процентов.",
            transliteration = "дмэй хавэр",
            pos = "phrase", semanticGroup = "health_il_payments", fillInBlankExclusions = listOf(191711L, 191712L, 191714L, 191715L)),

        WordEntity(id = 191714, setId = 1917, languagePair = "he-ru", rarity = "RARE",
            original = "תְּעוּדַת חוֹלֶה כְרוֹנִי",
            translation = "справка о хронической болезни",
            definition = "מִסְמָךְ רִשְׁמִי שֶׁמְּזַכֶּה בְּהֲנָחָה עַל תְּרוּפוֹת וְעַל בִּקּוּרֵי מֻמְחֶה.",
            definitionNative = "Официальный документ, что даёт скидку на лекарства и на визиты к специалистам — выдаёт семейный врач.",
            example = "קִבַּלְתִּי תְּעוּדַת חוֹלֶה כְרוֹנִי עַל לַחַץ דָּם גָּבוֹהַּ.",
            exampleNative = "Я получил תְּעוּדַת חוֹלֶה כְרוֹנִי из-за высокого давления — теперь скидка.",
            transliteration = "тэудат холэ крони",
            pos = "phrase", semanticGroup = "health_il_payments", fillInBlankExclusions = listOf(191711L, 191712L, 191713L, 191715L)),

        WordEntity(id = 191715, setId = 1917, languagePair = "he-ru", rarity = "RARE",
            original = "תִּקְרַת תַּשְׁלוּם",
            translation = "потолок платежей (за квартал)",
            definition = "סְכוּם מַקְסִימָלִי שֶׁחוֹלֶה מְשַׁלֵּם בְּרֶבַע — מֵעַל זֶה הַקֻּפָּה מְכַסָּה הַכֹּל.",
            definitionNative = "Максимальная сумма, что больной платит за квартал, — выше неё касса покрывает всё сама.",
            example = "הִגַּעְתִּי לְתִקְרַת תַּשְׁלוּם בְּחֹדֶשׁ מַרְץ וְלֹא שִׁלַּמְתִּי יוֹתֵר.",
            exampleNative = "Я достигла תִּקְרַת תַּשְׁלוּם в марте и больше ничего не платила.",
            transliteration = "тикрат ташлум",
            pos = "phrase", semanticGroup = "health_il_payments"),

        // ── Group: health_il_diagnostics (5 words) ────────────────────────────

        WordEntity(id = 191716, setId = 1917, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַזְמָנַת בְּדִיקָה",
            translation = "запись на обследование",
            definition = "תּוֹר מֵרֹאשׁ לִבְדִיקַת מַעְבָּדָה אוֹ הַדְמָיָה — דֶּרֶךְ אַפְּלִיקַצְיָה אוֹ בְּסָנִיף.",
            definitionNative = "Запись заранее на лабораторное обследование или визуализацию — через приложение или в филиале.",
            example = "הַזְמָנַת בְּדִיקָה לְמַעְבָּדָה מִתְבַּצַּעַת בִּשְׁתֵּי דַּקּוֹת בְּאַפְּלִיקַצְיָה.",
            exampleNative = "הַזְמָנַת בְּדִיקָה в лабораторию делается за две минуты в приложении.",
            transliteration = "hазманат бдика",
            pos = "phrase", semanticGroup = "health_il_diagnostics", fillInBlankExclusions = listOf(191717L, 191718L, 191719L, 191720L)),

        WordEntity(id = 191717, setId = 1917, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תּוֹצָאוֹת בַּמֵּייל",
            translation = "результаты по электронной почте",
            definition = "פּוֹרְמָט שֶׁל שִׁלּוּחַ תּוֹצְאוֹת מַעְבָּדָה לְלָקוֹחַ — בְּלִי לָגֶשֶׁת לַסָּנִיף.",
            definitionNative = "Формат отправки лабораторных результатов клиенту — без необходимости приходить в филиал.",
            example = "תּוֹצָאוֹת בַּמֵּייל הִגִּיעוּ בְּסוֹף הַיּוֹם הָאוֹתוֹ.",
            exampleNative = "תּוֹצָאוֹת בַּמֵּייל пришли уже к концу того же дня.",
            transliteration = "тоцаот ба-мэйл",
            pos = "phrase", semanticGroup = "health_il_diagnostics", fillInBlankExclusions = listOf(191716L, 191718L, 191719L, 191720L)),

        WordEntity(id = 191718, setId = 1917, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "צִילּוּם רֶנְטְגֵן",
            translation = "рентген (снимок)",
            definition = "תַּצְלוּם פְּנִימִי שֶׁל הַגּוּף בִּקְרִינַת אֶקְס — מַרְאֶה עֲצָמוֹת וְשִׁבְרֵי כָּפְלִים.",
            definitionNative = "Внутренний снимок тела в излучении X — показывает кости и переломы, видимые сразу.",
            example = "צִילּוּם רֶנְטְגֵן שֶׁל הַיָּד גִּלָּה סֶדֶק קָטָן.",
            exampleNative = "צִילּוּם רֶנְטְגֵן кисти показал небольшую трещину в кости.",
            transliteration = "цилум рэнтгэн",
            pos = "phrase", semanticGroup = "health_il_diagnostics", fillInBlankExclusions = listOf(191716L, 191717L, 191719L, 191720L)),

        WordEntity(id = 191719, setId = 1917, languagePair = "he-ru", rarity = "RARE",
            original = "טִיפּוּל פִיזְיוֹתֶרָפִּי",
            translation = "физиотерапия (курс)",
            definition = "סִדְרַת מִפְגָּשִׁים עִם מְטַפֵּל — תַּרְגִּילִים לְשִׁפּוּר תְּנוּעָה אַחֲרֵי פְּצִיעָה.",
            definitionNative = "Курс встреч с терапевтом — упражнения для восстановления движения после травмы.",
            example = "הָרוֹפֵא רָשַׁם טִיפּוּל פִיזְיוֹתֶרָפִּי לִשְׁמוֹנֶה מִפְגָּשִׁים.",
            exampleNative = "Врач выписал טִיפּוּל פִיזְיוֹתֶרָפִּי на восемь сеансов в районной клинике.",
            transliteration = "типуль физиотэрапи",
            pos = "phrase", semanticGroup = "health_il_diagnostics", fillInBlankExclusions = listOf(191716L, 191717L, 191718L, 191720L)),

        WordEntity(id = 191720, setId = 1917, languagePair = "he-ru", rarity = "RARE",
            original = "בְּדִיקָה גְּנֵטִית",
            translation = "генетический скрининг",
            definition = "בְּדִיקַת דָּם הַמְגַלָּה סִכּוּן לְמַחֲלוֹת תּוֹרַשְׁתִּיּוֹת — נֶחְשֶׁבֶת בְּסַל הַשֵּׁרוּתִים.",
            definitionNative = "Анализ крови, что выявляет риск наследственных болезней, — входит в корзину услуг для семей.",
            example = "זוֹגוֹת צְעִירִים עוֹשִׂים בְּדִיקָה גְּנֵטִית לִפְנֵי הֵרָיוֹן.",
            exampleNative = "Молодые пары делают בְּדִיקָה גְּנֵטִית до планирования беременности.",
            transliteration = "бдика гэнэтит",
            pos = "phrase", semanticGroup = "health_il_diagnostics", fillInBlankExclusions = listOf(191716L, 191717L, 191718L, 191719L)),

        // ── Group: health_il_emergency (5 words) ──────────────────────────────

        WordEntity(id = 191721, setId = 1917, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מוֹקֵד 101",
            translation = "горячая линия 101 (МАДА)",
            definition = "מִסְפַּר חֵרוּם אַרְצִי לְהַזְמָנַת אַמְבּוּלַנְס וּלְהוֹרָאוֹת רְפוּאִיּוֹת בַּטֶּלֶפוֹן.",
            definitionNative = "Национальный экстренный номер для вызова скорой и для медицинских указаний по телефону.",
            example = "הִתְקַשַּׁרְתִּי לְמוֹקֵד 101 כְּשֶׁאַבָּא הִתְעַלֵּף בַּסָּלוֹן.",
            exampleNative = "Я позвонил в מוֹקֵד 101, когда папа потерял сознание в гостиной.",
            transliteration = "мокэд мэа вэ-эхад",
            pos = "phrase", semanticGroup = "health_il_emergency", fillInBlankExclusions = listOf(191722L, 191723L)),

        WordEntity(id = 191722, setId = 1917, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מוֹקֵד קֻפָּה",
            translation = "горячая линия кассы",
            definition = "טֶלֶפוֹן שֶׁל הַקֻּפָּה — אָחוֹת תּוֹרָנִית עוֹנָה עַל שְׁאֵלוֹת רְפוּאִיּוֹת מִיָּד.",
            definitionNative = "Телефон кассы — дежурная медсестра сразу отвечает на медицинские вопросы и советует.",
            example = "מוֹקֵד קֻפָּה פּוֹתֵחַ עֶשְׂרִים וְאַרְבַּע שָׁעוֹת בְּיוֹם.",
            exampleNative = "מוֹקֵד קֻפָּה открыт двадцать четыре часа в сутки без выходных.",
            transliteration = "мокэд купа",
            pos = "phrase", semanticGroup = "health_il_emergency", fillInBlankExclusions = listOf(191721L, 191723L)),

        WordEntity(id = 191723, setId = 1917, languagePair = "he-ru", rarity = "RARE",
            original = "שֵׁרוּת תּוֹרָנִי",
            translation = "дежурная служба (ночью и в шабат)",
            definition = "מִרְפָּאָה שֶׁעוֹבֶדֶת מִחוּץ לְשָׁעוֹת רְגִילוֹת — בַּלַּיְלָה וּבְשַׁבָּת.",
            definitionNative = "Клиника, что работает вне обычных часов, — ночью и в шабат, когда филиалы кассы закрыты.",
            example = "שֵׁרוּת תּוֹרָנִי לְיַד הַבַּיִת פּוֹתֵחַ עַד חֲצוֹת.",
            exampleNative = "שֵׁרוּת תּוֹרָנִי рядом с домом работает до полуночи каждый вечер.",
            transliteration = "шэрут торани",
            pos = "phrase", semanticGroup = "health_il_emergency", fillInBlankExclusions = listOf(191721L, 191722L)),

        WordEntity(id = 191724, setId = 1917, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טֶרֶם",
            translation = "сеть «Терэм» (срочная помощь)",
            definition = "רֶשֶׁת מִרְפָּאוֹת לְמַצָּבִים דְּחוּפִים שֶׁאֵינָם דּוֹרְשִׁים חֲדַר מִיּוּן.",
            definitionNative = "Сеть клиник для срочных состояний, что не требуют приёмного отделения больницы.",
            example = "לָקַחְתִּי אֶת הַיַּלְדָּה לְטֶרֶם בִּגְלַל חֹם גָּבוֹהַּ.",
            exampleNative = "Я повёз дочку в טֶרֶם из-за высокой температуры в субботу вечером.",
            transliteration = "тэрэм",
            pos = "noun", semanticGroup = "health_il_emergency", fillInBlankExclusions = listOf(191725L)),

        WordEntity(id = 191725, setId = 1917, languagePair = "he-ru", rarity = "RARE",
            original = "נַטָּלִי",
            translation = "сеть «Натали» (домашняя скорая)",
            definition = "חֶבְרַת רְפוּאַת חֵרוּם פְּרָטִית — שׁוֹלַחַת רוֹפֵא הַבַּיְתָה תּוֹךְ דַּקּוֹת.",
            definitionNative = "Частная компания экстренной медицины — присылает врача на дом за минуты, по абонементу.",
            example = "מָנוּי בְּנַטָּלִי הִצִּיל לָנוּ לַיְלָה שָׁלֵם בְּלִי חֲדַר מִיּוּן.",
            exampleNative = "Абонемент в נַטָּלִי спас нам ночь — мы не поехали в приёмный покой.",
            transliteration = "наталИ",
            pos = "noun", semanticGroup = "health_il_emergency", fillInBlankExclusions = listOf(191724L)),
    )
}
