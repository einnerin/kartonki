package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew vocabulary — тема "Собеседования", уровень 5 (носитель языка).
 *
 * Set 1754: «Собеседования» — носитель языка (EPIC + LEGENDARY):
 *           тонкости израильского рынка для опытного соискателя.
 *           Бэкграунд-чек, юридические нюансы оффера (NDA, non-compete),
 *           компенсация (קֶרֶן הִשְׁתַּלְמוּת, опционы), follow-up после интервью,
 *           культурные особенности (כִּימְיָה אִישִׁית, רֵאָיוֹן בִּיתִי, סְגִירַת מַעְגָּל).
 *
 * Распределение редкостей: 13 EPIC + 12 LEGENDARY.
 *
 * SemanticGroups (5 × 5):
 *   interview_subtleties_check        — проверка кандидата
 *   interview_subtleties_legal        — юридические тонкости оффера
 *   interview_subtleties_compensation — нюансы компенсации
 *   interview_subtleties_followup     — после интервью
 *   interview_subtleties_culture      — израильские особенности
 *
 * Word IDs: setId × 100 + position (175401..175425).
 *
 * Все слова помечены isFillInBlankSafe = false: FILL_IN_BLANK для них отключён
 * до прохода LLM-pipeline по набору.
 */
object WordDataHebrewInterviewL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1754, languagePair = "he-ru", orderIndex = 1754,
            name = "Собеседования",
            description = "Тонкости рынка: бэкграунд-чек, рекомендации, follow-up, специфика юрлиц",
            topic = "Собеседования", level = 5,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ══════════════════════════════════════════════════════════════════════
        // Set 1754 — Собеседования: носитель языка (L5, EPIC + LEGENDARY)
        // 5 групп × 5 слов: check, legal, compensation, followup, culture
        // ══════════════════════════════════════════════════════════════════════

        // ── interview_subtleties_check (5) — проверка кандидата ──
        WordEntity(
            id = 175401, setId = 1754, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_subtleties_check", transliteration = "berur reka",
            original = "בֵּרוּר רֶקַע", translation = "проверка биографии (бэкграунд-чек)",
            definition = "תַּהֲלִיךְ שֶׁהַחֶבְרָה בּוֹדֶקֶת אֶת הֶעָבָר שֶׁל מֻעֳמָד לִפְנֵי שֶׁמְּגַיֶּסֶת אוֹתוֹ.",
            definitionNative = "Когда фирма проверяет прошлое кандидата перед тем, как взять на работу.",
            example = "בֵּרוּר רֶקַע אָרַךְ שָׁבוּעַ וְכָלַל שִׂיחָה עִם הַמַּעֲבִיד הַקּוֹדֵם.",
            exampleNative = "בֵּרוּר רֶקַע длился неделю и включал звонок прежнему работодателю.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175402, setId = 1754, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "interview_subtleties_check", transliteration = "poligraf",
            original = "פּוֹלִיגְרָף", translation = "полиграф (детектор лжи)",
            definition = "מַכְשִׁיר שֶׁמּוֹדֵד תְּגוּבוֹת הַגּוּף כְּדֵי לִבְדֹּק אִם הַנִּבְדָּק מְשַׁקֵּר בִּשְׁאֵלוֹת.",
            definitionNative = "Прибор измеряет реакции тела — врёт ли проверяемый при ответах.",
            example = "תַּפְקִידִים בִּטְחוֹנִיִּים בָּאָרֶץ דּוֹרְשִׁים פּוֹלִיגְרָף לִפְנֵי קְבָלָה.",
            exampleNative = "Должности в безопасности в Израиле требуют פּוֹלִיגְרָף до приёма.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175403, setId = 1754, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_subtleties_check", transliteration = "bdikat hamlatsot",
            original = "בְּדִיקַת הַמְלָצוֹת", translation = "проверка рекомендаций",
            definition = "שִׂיחָה שֶׁל הַמַּעֲסִיק עִם בּוֹסִים קוֹדְמִים שֶׁל הַמֻּעֳמָד לְבֵרוּר אֲמִינוּת.",
            definitionNative = "Звонок работодателя бывшим начальникам кандидата — узнать, можно ли доверять.",
            example = "אַחֲרֵי בְּדִיקַת הַמְלָצוֹת חִיּוּבִית קִבַּלְתִּי אֶת הַחוֹזֶה.",
            exampleNative = "После положительной בְּדִיקַת הַמְלָצוֹת я получил договор.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175404, setId = 1754, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "interview_subtleties_check", transliteration = "ishur bitkhoni",
            original = "אִישּׁוּר בִּטְחוֹנִי", translation = "допуск к секретной информации",
            definition = "הַסְכָּמָה רִשְׁמִית שֶׁל הַמְּדִינָה לָתֵת לָאָדָם גִּישָׁה לְמֵידָע סוֹדִי שֶׁל צָבָא אוֹ מַדִּינָה.",
            definitionNative = "Официальное согласие государства допустить человека к секретным сведениям.",
            example = "בְּלִי אִישּׁוּר בִּטְחוֹנִי אִי אֶפְשָׁר לַעֲבֹד בְּתַעֲשִׂיָּה צְבָאִית.",
            exampleNative = "Без אִישּׁוּר בִּטְחוֹנִי нельзя работать в военной промышленности.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175405, setId = 1754, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_subtleties_check", transliteration = "tohar midot",
            original = "טוֹהַר מִדּוֹת", translation = "чистая репутация (без правонарушений)",
            definition = "מַצָּב שֶׁל אָדָם בְּלִי עָבָר פְּלִילִי אוֹ הַפָּרוֹת מוּסָר שֶׁמִּתְפַּרְסְמוֹת לָרַבִּים.",
            definitionNative = "Состояние, когда у человека нет уголовного прошлого или громких нарушений морали.",
            example = "תַּפְקִידִים צִיבּוּרִיִּים דּוֹרְשִׁים תְּעוּדַת טוֹהַר מִדּוֹת מֵהַמִּשְׁטָרָה.",
            exampleNative = "Государственные должности требуют справку о טוֹהַר מִדּוֹת из полиции.",
            isFillInBlankSafe = false,
        ),

        // ── interview_subtleties_legal (5) — юридические тонкости ──
        WordEntity(
            id = 175406, setId = 1754, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_subtleties_legal", transliteration = "hitkhayvut i-giluy",
            original = "הִתְחַיְּבוּת אִי-גִּלּוּי", translation = "обязательство неразглашения (NDA)",
            definition = "הַסְכָּמָה בִּכְתָב לֹא לְסַפֵּר לְאַף אֶחָד עַל מַה שֶּׁעוֹבֵד יוֹדֵעַ עַל הַחֶבְרָה.",
            definitionNative = "Письменное согласие никому не рассказывать то, что сотрудник знает о фирме.",
            example = "חָתַמְתִּי עַל הִתְחַיְּבוּת אִי-גִּלּוּי לִפְנֵי שֶׁהֶרְאוּ אֶת הַקּוֹד.",
            exampleNative = "Я подписал הִתְחַיְּבוּת אִי-גִּלּוּי до того, как мне показали код.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175407, setId = 1754, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "interview_subtleties_legal", transliteration = "tniyat i-takharut",
            original = "תְּנִיַית אִי-תַּחֲרוּת", translation = "пункт о запрете конкуренции",
            definition = "סָעִיף בַּחוֹזֶה הָאוֹסֵר עַל עוֹבֵד לַעֲבֹד אֵצֶל מִתְחָרֶה תּוֹךְ פֶּרֶק זְמַן קָבוּעַ.",
            definitionNative = "Пункт договора — нельзя пойти к конкуренту в течение оговорённого срока.",
            example = "תְּנִיַית אִי-תַּחֲרוּת אָסְרָה עָלַי לַעֲבֹר לְחֶבְרָה דּוֹמָה לְשָׁנָה.",
            exampleNative = "תְּנִיַית אִי-תַּחֲרוּת запретила мне год переходить в похожую фирму.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175408, setId = 1754, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "interview_subtleties_legal", transliteration = "knas yetsi'a",
            original = "קְנַס יְצִיאָה", translation = "штраф за досрочный уход",
            definition = "סְכוּם שֶׁעוֹבֵד מְשַׁלֵּם אִם הוּא עוֹזֵב לִפְנֵי שֶׁעָבְרָה תְּקוּפָה מִינִימָלִית בָּעֲבוֹדָה.",
            definitionNative = "Сумма, которую сотрудник платит, если уходит до минимального срока в работе.",
            example = "הַחֶבְרָה הוֹסִיפָה קְנַס יְצִיאָה לָעוֹבְדִים שֶׁמְּקַבְּלִים בּוֹנוּס חֲתִימָה.",
            exampleNative = "Фирма добавила קְנַס יְצִיאָה для тех, кто получил бонус при подписании.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175409, setId = 1754, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_subtleties_legal", transliteration = "tkufat hodaa mukdemet",
            original = "תְּקוּפַת הוֹדָעָה מֻקְדֶּמֶת", translation = "срок предупреждения об уходе",
            definition = "הַזְּמַן בֵּין הַיּוֹם שֶׁבּוֹ עוֹבֵד מוֹדִיעַ עַל עֲזִיבָה לְבֵין יוֹם הַסִּיוּם בְּפֹעַל.",
            definitionNative = "Срок между днём, когда сотрудник предупреждает об уходе, и днём фактического ухода.",
            example = "תְּקוּפַת הוֹדָעָה מֻקְדֶּמֶת מְקֻבֶּלֶת בְּיִשְׂרָאֵל הִיא שְׁלוֹשִׁים יוֹם.",
            exampleNative = "Принятая в Израиле תְּקוּפַת הוֹדָעָה מֻקְדֶּמֶת — тридцать дней.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175410, setId = 1754, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "interview_subtleties_legal", transliteration = "kinyan rukhani",
            original = "קִנְיָן רוּחָנִי", translation = "интеллектуальная собственность",
            definition = "כָּל הַיְצִירָה הַמַּחְשַׁבְתִּית — קוֹד, פָּטֶנְט אוֹ מַתְכּוֹן — שֶׁשַּׁיֶּכֶת לְבַעֲלֶיהָ עַל פִּי חוֹק.",
            definitionNative = "Любое творение мысли — код, патент или рецепт — по закону принадлежит автору.",
            example = "כָּל קִנְיָן רוּחָנִי שֶׁנּוֹצַר בִּשְׁעוֹת הָעֲבוֹדָה שַׁיָּךְ לַחֶבְרָה.",
            exampleNative = "Любая קִנְיָן רוּחָנִי, созданная в рабочее время, принадлежит фирме.",
            isFillInBlankSafe = false,
        ),

        // ── interview_subtleties_compensation (5) — нюансы компенсации ──
        WordEntity(
            id = 175411, setId = 1754, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_subtleties_compensation", transliteration = "shikhlul ha-khavila",
            original = "שִׁכְלוּל הַחֲבִילָה", translation = "взвешенная оценка пакета",
            definition = "חִישּׁוּב שֶׁל הַשּׁוֹוִי הַכּוֹלֵל שֶׁל הַהַצָּעָה — שָׂכָר, הֲטָבוֹת, מְנָיוֹת וּבוֹנוּסִים.",
            definitionNative = "Подсчёт совокупной ценности предложения — оклад, льготы, акции и бонусы.",
            example = "אַחֲרֵי שִׁכְלוּל הַחֲבִילָה הֵבַנְתִּי שֶׁהַסְּטַרְטְאַפּ מַצִּיעַ יוֹתֵר.",
            exampleNative = "После שִׁכְלוּל הַחֲבִילָה я понял, что стартап даёт больше.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175412, setId = 1754, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "interview_subtleties_compensation", transliteration = "bonus mutne",
            original = "בּוֹנוּס מֻתְנֶה", translation = "условный бонус (по KPI)",
            definition = "תַּשְׁלוּם נוֹסָף שֶׁמִּשְׁתַּלֵּם רַק אִם עוֹבֵד מַגִּיעַ לִיעָדִים מֻגְדָּרִים מֵרֹאשׁ.",
            definitionNative = "Доплата, которая идёт только если сотрудник дотягивает до заранее заданных целей.",
            example = "בּוֹנוּס מֻתְנֶה תָּלוּי בְּאַרְבָּעָה מַדָּדִים רֻבְעוֹנִיִּים שֶׁל הַצֶּוֶות.",
            exampleNative = "בּוֹנוּס מֻתְנֶה зависит от четырёх квартальных показателей команды.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175413, setId = 1754, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_subtleties_compensation", transliteration = "optsiyot avirot",
            original = "אוֹפְּצְיוֹת עֲבִירוֹת", translation = "переносимые опционы",
            definition = "זְכוּת לִקְנוֹת מְנָיוֹת שֶׁאֶפְשָׁר לְהַעֲבִיר לְקָרוֹב מִשְׁפָּחָה בְּלִי לְאַבֵּד אוֹתָהּ.",
            definitionNative = "Право купить акции, которое можно передать родственнику без потери.",
            example = "אוֹפְּצְיוֹת עֲבִירוֹת נֶחְשָׁבוֹת תְּנַאי נָדִיר וְמוּעָדָף בִּישְׂרָאֵל.",
            exampleNative = "אוֹפְּצְיוֹת עֲבִירוֹת — редкое и ценимое условие в Израиле.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175414, setId = 1754, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_subtleties_compensation", transliteration = "hafrashot pensiya",
            original = "הַפְרָשׁוֹת פֶּנְסְיָה", translation = "пенсионные отчисления",
            definition = "סְכוּמִים חֳדְשִׁיִּים שֶׁמַּעֲבִיד וְעוֹבֵד מַעֲבִירִים לְקֶרֶן לְעֵת זִקְנָה.",
            definitionNative = "Месячные суммы, что работодатель и сотрудник переводят в фонд на старость.",
            example = "הַחֶבְרָה הַחֲדָשָׁה מַגְדִּילָה הַפְרָשׁוֹת פֶּנְסְיָה לְשִׁבְעָה אֲחוּזִים.",
            exampleNative = "Новая фирма повышает הַפְרָשׁוֹת פֶּנְסְיָה до семи процентов.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175415, setId = 1754, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "interview_subtleties_compensation", transliteration = "keren hishtalmut",
            original = "קֶרֶן הִשְׁתַּלְמוּת", translation = "фонд повышения квалификации",
            definition = "חִסָּכוֹן עִם הֲטָבוֹת מַס שֶׁמְּמַמֵּן הַמַּעֲבִיד וְהָעוֹבֵד יָכוֹל לְמָשׁוֹךְ אַחֲרֵי שֵׁשׁ שָׁנִים.",
            definitionNative = "Накопление с налоговыми льготами от работодателя — снять можно через шесть лет.",
            example = "קֶרֶן הִשְׁתַּלְמוּת נֶחְשֶׁבֶת לַהֲטָבָה הֲכִי מְבֻקֶּשֶׁת בָּאוֹפֶר.",
            exampleNative = "קֶרֶן הִשְׁתַּלְמוּת — самая желанная льгота в офере.",
            isFillInBlankSafe = false,
        ),

        // ── interview_subtleties_followup (5) — после интервью ──
        WordEntity(
            id = 175416, setId = 1754, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_subtleties_followup", transliteration = "mikhtav toda",
            original = "מִכְתַּב תּוֹדָה", translation = "благодарственное письмо после интервью",
            definition = "הוֹדָעָה קְצָרָה בַּמֵּייל שֶׁמֻעֳמָד שׁוֹלֵחַ אַחֲרֵי שִׂיחָה כְּדֵי לִשְׁמֹר עַל קֶשֶׁר חִיוּבִי.",
            definitionNative = "Короткое сообщение по почте от кандидата после разговора — поддержать тёплый контакт.",
            example = "שָׁלַחְתִּי מִכְתַּב תּוֹדָה לַמְּרַאֲיֵין שָׁעָה אַחֲרֵי הַזּוּם.",
            exampleNative = "Я отправил מִכְתַּב תּוֹדָה интервьюеру через час после Зума.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175417, setId = 1754, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_subtleties_followup", transliteration = "ma'akav khozer",
            original = "מַעֲקָב חוֹזֵר", translation = "повторное обращение (follow-up)",
            definition = "פְּנִיָּה שֶׁל הַמֻּעֳמָד אַחֲרֵי שֶׁעָבַר זְמַן בְּלִי שׁוּם תְּשׁוּבָה מֵהַחֶבְרָה.",
            definitionNative = "Когда кандидат сам пишет фирме после того, как прошло время без ответа.",
            example = "מַעֲקָב חוֹזֵר הָגוּן הוּא מֵייל אֶחָד אַחֲרֵי שָׁבוּעַ שֶׁל שֶׁקֶט.",
            exampleNative = "Уместный מַעֲקָב חוֹזֵר — это одно письмо после недели тишины.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175418, setId = 1754, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "interview_subtleties_followup", transliteration = "ma'avar le-shalav",
            original = "מַעֲבָר לְשָׁלָב", translation = "переход на следующий этап отбора",
            definition = "הוֹדָעָה מֵהַחֶבְרָה שֶׁהַמֻּעֳמָד עוֹבֵר הָלְאָה לִקְרַאת רֵאָיוֹן בָּא בַּתַּהֲלִיךְ.",
            definitionNative = "Сообщение от фирмы — кандидат идёт дальше, к следующему интервью в процессе.",
            example = "מַעֲבָר לְשָׁלָב הִגִּיעַ בַּלַּיְלָה וְכָלַל הַזְמָנָה לְמִבְחָן טֶכְנִי.",
            exampleNative = "מַעֲבָר לְשָׁלָב пришёл ночью и включал приглашение на технический тест.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175419, setId = 1754, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_subtleties_followup", transliteration = "hamtana le-hakhlata",
            original = "הַמְתָּנָה לְהַחְלָטָה", translation = "ожидание решения (после финала)",
            definition = "תְּקוּפָה אַחֲרֵי הָרֵאָיוֹן הָאַחֲרוֹן שֶׁבָּהּ הַמֻּעֳמָד לֹא יוֹדֵעַ אִם קִבְּלוּ אוֹתוֹ.",
            definitionNative = "Время после финального интервью, пока кандидат не знает, взяли его или нет.",
            example = "הַמְתָּנָה לְהַחְלָטָה הִיא הַחֵלֶק הֲכִי קָשֶׁה שֶׁל כָּל הַתַּהֲלִיךְ.",
            exampleNative = "הַמְתָּנָה לְהַחְלָטָה — самая мучительная часть всего процесса.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175420, setId = 1754, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "interview_subtleties_followup", transliteration = "meshekh ha-tahalikh",
            original = "מֶשֶׁךְ הַתַּהֲלִיךְ", translation = "длительность процесса найма",
            definition = "מִסְפַּר הַשָּׁבוּעוֹת מֵהַשִּׂיחָה הָרִאשׁוֹנָה עִם הַמְּגַיֵּיס וְעַד חֲתִימָה עַל אוֹפֶר.",
            definitionNative = "Сколько недель проходит от первого звонка рекрутера до подписания офера.",
            example = "מֶשֶׁךְ הַתַּהֲלִיךְ בַּחֶבְרָה הַזֹּאת הוּא חָמֵשׁ שָׁבוּעוֹת בְּמְמֻצָּע.",
            exampleNative = "מֶשֶׁךְ הַתַּהֲלִיךְ в этой фирме — пять недель в среднем.",
            isFillInBlankSafe = false,
        ),

        // ── interview_subtleties_culture (5) — израильские особенности ──
        WordEntity(
            id = 175421, setId = 1754, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_subtleties_culture", transliteration = "ra'ayon beiti",
            original = "רֵאָיוֹן בֵּיתִי", translation = "интервью в неформальной обстановке",
            definition = "שִׂיחָה עִם מַעֲבִיד בְּבֵית קָפֶה אוֹ עַל קוּרְנֶר בְּלִי לוּחַ וּבְלִי חֲלִיפָה.",
            definitionNative = "Разговор с работодателем в кофейне или на углу — без доски и без костюма.",
            example = "רֵאָיוֹן בֵּיתִי בְּבֵית קָפֶה בִּתֵל אָבִיב הוּא עִנְיָן רָגִיל לְגַמְרֵי.",
            exampleNative = "רֵאָיוֹן בֵּיתִי в кофейне в Тель-Авиве — совершенно обычное дело.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175422, setId = 1754, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "interview_subtleties_culture", transliteration = "khimiya ishit",
            original = "כִּימְיָה אִישִׁית", translation = "личная химия (взаимная симпатия)",
            definition = "תְּחוּשָׁה הֲדָדִית טוֹבָה בֵּין שְׁנֵי אֲנָשִׁים שֶׁלֹּא תָּמִיד אֶפְשָׁר לְהַסְבִּיר בְּמִילִּים.",
            definitionNative = "Взаимное хорошее ощущение между двумя людьми — не всегда выразимое словами.",
            example = "כִּימְיָה אִישִׁית עִם הַמְּנַהֵל הָיְתָה גּוֹרֵם מַכְרִיעַ בַּהַחְלָטָה.",
            exampleNative = "כִּימְיָה אִישִׁית с менеджером оказалась решающим фактором.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175423, setId = 1754, languagePair = "he-ru", rarity = "EPIC",
            pos = "noun", semanticGroup = "interview_subtleties_culture", transliteration = "tikshoret yeshira",
            original = "תִּקְשֹׁרֶת יְשִׁירָה", translation = "прямой стиль общения",
            definition = "סְגַנּוֹן דִּבּוּר שֶׁבּוֹ אוֹמְרִים בְּדִיּוּק מָה שֶׁחוֹשְׁבִים בְּלִי כְּסוּת מְנֻמֶּסֶת.",
            definitionNative = "Манера речи: говорят ровно то, что думают, без вежливой обёртки.",
            example = "תִּקְשֹׁרֶת יְשִׁירָה בִּישְׂרָאֵל הוֹלֶמֶת אֶת מֶזֶג הָאֲוִיר וְהָאֲנָשִׁים.",
            exampleNative = "תִּקְשֹׁרֶת יְשִׁירָה в Израиле подходит и климату, и людям.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175424, setId = 1754, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "interview_subtleties_culture", transliteration = "formaliyut mu'eitet",
            original = "פוֹרְמָאלִיּוּת מוּעֶטֶת", translation = "минимум формальностей",
            definition = "סִגְנוֹן עֲבוֹדָה בְּלִי כְּתוֹבוֹת רִשְׁמִיּוֹת, בְּלִי חֲלִיפוֹת וּבְשֵׁמוֹת פְּרָטִיִּים.",
            definitionNative = "Стиль работы без формальных обращений, без костюмов и по именам.",
            example = "פוֹרְמָאלִיּוּת מוּעֶטֶת מַפְתִּיעָה רֶפַּטְרִיאַנְטִים מֵרוּסְיָה בָּרֵאָיוֹן הָרִאשׁוֹן.",
            exampleNative = "פוֹרְמָאלִיּוּת מוּעֶטֶת удивляет репатриантов из России на первом собеседовании.",
            isFillInBlankSafe = false,
        ),
        WordEntity(
            id = 175425, setId = 1754, languagePair = "he-ru", rarity = "LEGENDARY",
            pos = "noun", semanticGroup = "interview_subtleties_culture", transliteration = "sgirat ma'agal",
            original = "סְגִירַת מַעְגָּל", translation = "финальное закрытие (loop closing)",
            definition = "שִׂיחָה אוֹ מֵייל אַחֲרוֹן שֶׁמְּסַיֵּם אֶת הַתַּהֲלִיךְ — חִיּוּבִי אוֹ שְׁלִילִי — בְּלִי לְהַשְׁאִיר עַרְפִילִים.",
            definitionNative = "Последний звонок или письмо — закрывают процесс позитивно или негативно, без тумана.",
            example = "בִּקַּשְׁתִּי סְגִירַת מַעְגָּל הֲגוּנָה גַּם אַחֲרֵי תְּשׁוּבָה שְׁלִילִית מֵהַמְּגַיֵּיס.",
            exampleNative = "Я попросил приличную סְגִירַת מַעְגָּל даже после отказа от рекрутера.",
            isFillInBlankSafe = false,
        ),
    )
}
