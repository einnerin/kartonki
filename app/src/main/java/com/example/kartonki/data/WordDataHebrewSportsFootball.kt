package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * Hebrew football vocabulary — extension of the «Спорт» topic, level 2.
 * Set 1892 (he-ru). Covers Israeli football specifics: clubs (Maccabi/Hapoel/Beitar),
 * leagues (Ligat ha-Al, Liga Le'ummit), positions, play, match types, competitions.
 * Rarity: UNCOMMON + RARE (two adjacent tiers, A2..B2).
 * Word IDs follow formula setId*100+pos → 189201..189225.
 *
 * Не пересекается с set 1041 (L2), 1285 (L3), 1286 (L4), 1287 (L5), 1490 (L1) — общие
 * термины спорта там, тут — узкая израильская футбольная лексика (клубы, лиги, правила).
 */
object WordDataHebrewSportsFootball {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 1892, languagePair = "he-ru", orderIndex = 1892,
            name = "Спорт",
            description = "Футбол в Израиле: лиги, клубы, термины",
            topic = "Спорт",
            level = 2,
        ),
    )

    val words: List<WordEntity> = listOf(

        // ── Group: sport_football_clubs (5 words) ───────────────────────────

        WordEntity(id = 189201, setId = 1892, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַכַּבִּי תֵּל אָבִיב", translation = "Маккаби Тель-Авив",
            definition = "מוֹעֲדוֹן כַּדּוּרֶגֶל יִשְׂרְאֵלִי וָתִיק עִם אַלִּיפוּיוֹת רַבּוֹת.",
            definitionNative = "Один из самых титулованных футбольных клубов Израиля, базируется в Тель-Авиве.",
            example = "מַכַּבִּי תֵּל אָבִיב נִצְּחָה אֶת הַיַּרִיבָה שֶׁלָּהּ שָׁלוֹשׁ אֶפֶס.",
            exampleNative = "מַכַּבִּי תֵּל אָבִיב обыграла соперника со счётом три ноль.",
            pos = "phrase", semanticGroup = "sport_football_clubs",
            fillInBlankExclusions = listOf(189202L, 189203L, 189204L, 189205L)),

        WordEntity(id = 189202, setId = 1892, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "הַפּוֹעֵל תֵּל אָבִיב", translation = "Хапоэль Тель-Авив",
            definition = "מוֹעֲדוֹן כַּדּוּרֶגֶל יִשְׂרְאֵלִי הַמְּשַׂחֵק בְּצֶבַע אָדֹם.",
            definitionNative = "Тель-авивский клуб, главный соперник Маккаби в дерби города.",
            example = "אוֹהֲדֵי הַפּוֹעֵל תֵּל אָבִיב מִילְאוּ אֶת הַיָּצִיעַ הַצְּפוֹנִי.",
            exampleNative = "Болельщики הַפּוֹעֵל תֵּל אָבִיב заполнили северную трибуну.",
            pos = "phrase", semanticGroup = "sport_football_clubs",
            fillInBlankExclusions = listOf(189201L, 189203L, 189204L, 189205L)),

        WordEntity(id = 189203, setId = 1892, languagePair = "he-ru", rarity = "RARE",
            original = "בֵּיתָר יְרוּשָׁלַיִם", translation = "Бейтар Иерусалим",
            definition = "מוֹעֲדוֹן כַּדּוּרֶגֶל מִיְּרוּשָׁלַיִם בַּעַל אוֹהֲדִים נִלְהָבִים בִּמְיוּחָד.",
            definitionNative = "Иерусалимский клуб со страстной и шумной фанатской трибуной.",
            example = "בֵּיתָר יְרוּשָׁלַיִם הִשְׁלִימָה אֶת הָעוֹנָה בַּמָּקוֹם הַשְּׁלִישִׁי.",
            exampleNative = "בֵּיתָר יְרוּשָׁלַיִם завершила сезон на третьем месте.",
            pos = "phrase", semanticGroup = "sport_football_clubs",
            fillInBlankExclusions = listOf(189201L, 189202L, 189204L, 189205L)),

        WordEntity(id = 189204, setId = 1892, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "לִיגַת הָעַל", translation = "Лигат ха-Аль (премьер-лига)",
            definition = "הַדַּרְגָּה הָעֶלְיוֹנָה שֶׁל כַּדּוּרֶגֶל מִקְצוֹעָנִי בְּיִשְׂרָאֵל.",
            definitionNative = "Высший дивизион профессионального футбола в Израиле, аналог премьер-лиги.",
            example = "הַקְּבוּצָה עָלְתָה לְלִיגַת הָעָל אַחֲרֵי שָׁנִים בִּמְקוֹמוֹת נְמוּכִים.",
            exampleNative = "Команда поднялась в לִיגַת הָעַל после многих лет в низших дивизионах.",
            pos = "phrase", semanticGroup = "sport_football_clubs",
            fillInBlankExclusions = listOf(189201L, 189202L, 189203L, 189205L)),

        WordEntity(id = 189205, setId = 1892, languagePair = "he-ru", rarity = "RARE",
            original = "לִיגָה לְאֻמִּית", translation = "Лига Леуммит (вторая лига)",
            definition = "הַדַּרְגָּה הַשְּׁנִיָּה בַּמַּעֲרֶכֶת הַמִּקְצוֹעָנִית הַיִּשְׂרְאֵלִית.",
            definitionNative = "Вторая по силе израильская лига; победитель выходит наверх.",
            example = "הוּא חָתַם חוֹזֶה עִם קְבוּצָה מִלִּיגָה לְאֻמִּית הַשָּׁנָה.",
            exampleNative = "В этом сезоне он подписал контракт с клубом из לִיגָה לְאֻמִּית.",
            pos = "phrase", semanticGroup = "sport_football_clubs",
            fillInBlankExclusions = listOf(189201L, 189202L, 189203L, 189204L)),

        // ── Group: sport_football_roles (5 words) ───────────────────────────

        WordEntity(id = 189206, setId = 1892, languagePair = "he-ru", rarity = "RARE",
            original = "בַּלָּם", translation = "центральный защитник",
            definition = "שַׂחְקָן בְּמֶרְכַּז הַהֲגָנָה הָעוֹצֵר אֶת הַתְּקִיפוֹת שֶׁל הַיָּרִיב.",
            definitionNative = "Игрок в центре обороны, останавливает атакующих соперника.",
            example = "הַבַּלָּם הַגָּבוֹהַּ נִצַּח כָּל כַּדּוּר בָּאֲוִיר.",
            exampleNative = "Высокий בַּלָּם выигрывал каждое верховое единоборство.",
            pos = "noun", semanticGroup = "sport_football_roles",
            fillInBlankExclusions = listOf(189207L, 189208L, 189209L, 189210L)),

        WordEntity(id = 189207, setId = 1892, languagePair = "he-ru", rarity = "RARE",
            original = "קַשָּׁר", translation = "полузащитник",
            definition = "שַׂחְקָן בְּאֶמְצַע הַמִּגְרָשׁ הַמְּחַבֵּר בֵּין הֲגַנָּה לְהַתְקָפָה.",
            definitionNative = "Игрок середины поля, связующее звено между обороной и атакой.",
            example = "הַקַּשָּׁר הַצָּעִיר הִשִּׂיג שְׁנֵי בִּישׁוּלִים בַּמַּחֲצִית הָרִאשׁוֹנָה.",
            exampleNative = "Молодой קַשָּׁר сделал две голевые передачи в первом тайме.",
            pos = "noun", semanticGroup = "sport_football_roles",
            fillInBlankExclusions = listOf(189206L, 189208L, 189209L, 189210L)),

        WordEntity(id = 189208, setId = 1892, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אוֹהֵד", translation = "болельщик",
            definition = "אָדָם הַתּוֹמֵךְ בִּקְבוּצָה מְסוּיֶּמֶת וּמַגִּיעַ לְעוֹדֵד אוֹתָהּ.",
            definitionNative = "Человек, который поддерживает определённую команду и приходит на трибуны.",
            example = "כָּל אוֹהֵד שָׁר אֶת שְׁמוֹ שֶׁל הַחֲלוּץ הַחָדָשׁ.",
            exampleNative = "Каждый אוֹהֵד скандировал имя нового нападающего.",
            pos = "noun", semanticGroup = "sport_football_roles",
            fillInBlankExclusions = listOf(189206L, 189207L, 189209L, 189210L)),

        WordEntity(id = 189209, setId = 1892, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "יָרִיב", translation = "соперник",
            definition = "הַקְּבוּצָה הַמְּשַׂחֶקֶת מוּל הַקְּבוּצָה שֶׁלָּנוּ בַּמִּגְרָשׁ.",
            definitionNative = "Команда, играющая против нашей в данном матче.",
            example = "הַיָּרִיב הַגָּדוֹל בְּיוֹתֵר שֶׁלָּהֶם הוּא מַכַּבִּי תֵּל אָבִיב.",
            exampleNative = "Их главный יָרִיב — Маккаби Тель-Авив.",
            pos = "noun", semanticGroup = "sport_football_roles",
            fillInBlankExclusions = listOf(189206L, 189207L, 189208L, 189210L)),

        WordEntity(id = 189210, setId = 1892, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אַלּוּף", translation = "чемпион",
            definition = "הַקְּבוּצָה אוֹ הַשַּׂחְקָן שֶׁזָּכָה בַּמָּקוֹם הָרִאשׁוֹן בָּעוֹנָה.",
            definitionNative = "Команда или игрок, занявший первое место в сезоне.",
            example = "הַקְּבוּצָה הוּכְתְּרָה אַלּוּף לְאַחַר שֶׁנִּיצְּחָה אֶת בֵּיתָר יְרוּשָׁלַיִם.",
            exampleNative = "Команду провозгласили אַלּוּף после победы над Бейтаром.",
            pos = "noun", semanticGroup = "sport_football_roles",
            fillInBlankExclusions = listOf(189206L, 189207L, 189208L, 189209L)),

        // ── Group: sport_football_play (5 words) ────────────────────────────

        WordEntity(id = 189211, setId = 1892, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "בְּעִיטָה", translation = "удар по мячу",
            definition = "פְּעוּלָה שֶׁל הַכָּאַת כַּדּוּר בָּרֶגֶל לְעֵבֶר שַׁעַר אוֹ חָבֵר.",
            definitionNative = "Действие, когда игрок бьёт мяч ногой по воротам или партнёру.",
            example = "הָיְתָה לוֹ בְּעִיטָה חֲזָקָה מִחוּץ לָרֲחָבָה.",
            exampleNative = "У него получился сильный בְּעִיטָה из-за пределов штрафной.",
            pos = "noun", semanticGroup = "sport_football_play",
            fillInBlankExclusions = listOf(189212L, 189213L, 189214L, 189215L)),

        WordEntity(id = 189212, setId = 1892, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מְסִירָה", translation = "передача мяча",
            definition = "הַעֲבָרַת הַכַּדּוּר מִשַּׂחְקָן אֶחָד לִשְׁנִי בַּקְּבוּצָה.",
            definitionNative = "Когда игрок отдаёт мяч партнёру по команде ногой или головой.",
            example = "הוּא נָתַן מְסִירָה מְדוּיֶּקֶת אֶל הַחֲלוּץ הַחוֹפְשִׁי.",
            exampleNative = "Он отдал точную מְסִירָה на свободного нападающего.",
            pos = "noun", semanticGroup = "sport_football_play",
            fillInBlankExclusions = listOf(189211L, 189213L, 189214L, 189215L)),

        WordEntity(id = 189213, setId = 1892, languagePair = "he-ru", rarity = "RARE",
            original = "גִּמּוּר", translation = "завершение атаки",
            definition = "הַשְׁלָמַת הַהַתְקָפָה בַּעֲזָרַת בְּעִיטָה מְדוּיֶּקֶת לְעֵבֶר הַשַּׁעַר.",
            definitionNative = "Завершающий удар по воротам в концовке атаки команды.",
            example = "הַחֲלוּץ הִפְגִּין גִּמּוּר קַר וְהִכְנִיס לְפִינָה.",
            exampleNative = "Нападающий показал хладнокровный גִּמּוּר и поразил угол.",
            pos = "noun", semanticGroup = "sport_football_play",
            fillInBlankExclusions = listOf(189211L, 189212L, 189214L, 189215L)),

        WordEntity(id = 189214, setId = 1892, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פָאוּל", translation = "фол",
            definition = "פְּגִיעָה לֹא חוּקִית בְּשַׂחְקָן יָרִיב הַמְבִיאָה לְעֵצִירַת הַמִּשְׂחָק.",
            definitionNative = "Запрещённое нарушение против игрока соперника, останавливает игру.",
            example = "הַשּׁוֹפֵט שָׁרַק עַל פָאוּל קָשֶׁה בָּרָחָבָה.",
            exampleNative = "Судья свистнул на жёсткий פָאוּל в штрафной.",
            pos = "noun", semanticGroup = "sport_football_play",
            fillInBlankExclusions = listOf(189211L, 189212L, 189213L, 189215L)),

        WordEntity(id = 189215, setId = 1892, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קוֹרְנֵר", translation = "угловой удар",
            definition = "בְּעִיטָה מִפִּינַּת הַמִּגְרָשׁ אַחֲרֵי שֶׁהֲגַנָּה הוֹצִיאָה אֶת הַכַּדּוּר.",
            definitionNative = "Удар из углового сектора после того, как защита выбила мяч за линию.",
            example = "מִן הַקּוֹרְנֵר עָלָה הַחֲלוּץ וְהֵבִיא שַׁעַר.",
            exampleNative = "С קוֹרְנֵר нападающий поднялся и забил гол.",
            pos = "noun", semanticGroup = "sport_football_play",
            fillInBlankExclusions = listOf(189211L, 189212L, 189213L, 189214L)),

        // ── Group: sport_football_match (5 words) ───────────────────────────

        WordEntity(id = 189216, setId = 1892, languagePair = "he-ru", rarity = "RARE",
            original = "מִשְׂחַק חוּץ", translation = "выездной матч",
            definition = "מִפְגַּשׁ סְפּוֹרְט הַנֶּעֱרָךְ בַּמִּגְרָשׁ שֶׁל הַיָּרִיב.",
            definitionNative = "Игра, которая проходит на стадионе соперника, не дома.",
            example = "הַקְּבוּצָה הִפְסִידָה אֶת מִשְׂחַק חוּץ הַחֲשׁוּב בְּחֵיפָה.",
            exampleNative = "Команда проиграла важный מִשְׂחַק חוּץ в Хайфе.",
            pos = "phrase", semanticGroup = "sport_football_match",
            fillInBlankExclusions = listOf(189217L, 189218L, 189219L, 189220L)),

        WordEntity(id = 189217, setId = 1892, languagePair = "he-ru", rarity = "RARE",
            original = "מִשְׂחַק בַּיִת", translation = "домашний матч",
            definition = "מִפְגַּשׁ סְפּוֹרְט הַנֶּעֱרָךְ בַּמִּגְרָשׁ שֶׁל הַקְּבוּצָה הַמְּאָרַחַת.",
            definitionNative = "Игра, которую команда проводит на собственном стадионе.",
            example = "הָאוֹהֲדִים הִגִּיעוּ בַּהֲמוֹנֵיהֶם לְמִשְׂחַק בַּיִת.",
            exampleNative = "Болельщики толпой пришли на מִשְׂחַק בַּיִת.",
            pos = "phrase", semanticGroup = "sport_football_match",
            fillInBlankExclusions = listOf(189216L, 189218L, 189219L, 189220L)),

        WordEntity(id = 189218, setId = 1892, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַחֲצִית", translation = "тайм, половина игры",
            definition = "אֶחָד מִשְּׁנֵי חֶלְקֵי הַמִּשְׂחָק שֶׁבֵּינֵיהֶם הַפְסָקָה.",
            definitionNative = "Одна из двух частей матча; между ними устроен перерыв.",
            example = "בְּסוֹף הַמַּחֲצִית הָרִאשׁוֹנָה הַתּוֹצָאָה הָיְתָה אֶחָד אֶחָד.",
            exampleNative = "В конце первой מַחֲצִית счёт был один один.",
            pos = "noun", semanticGroup = "sport_football_match",
            fillInBlankExclusions = listOf(189216L, 189217L, 189219L, 189220L)),

        WordEntity(id = 189219, setId = 1892, languagePair = "he-ru", rarity = "RARE",
            original = "תּוֹסֶפֶת זְמַן", translation = "добавленное время",
            definition = "דַּקּוֹת נוֹסָפוֹת שֶׁהַשּׁוֹפֵט מוֹסִיף בְּסוֹף הַמַּחֲצִית עַל הַפְסָקוֹת.",
            definitionNative = "Дополнительные минуты, которые судья добавляет за остановки игры.",
            example = "הַשַּׁעַר הַמַּכְרִיעַ הוּבְקַע בְּתוֹסֶפֶת זְמַן.",
            exampleNative = "Решающий гол был забит в תּוֹסֶפֶת זְמַן.",
            pos = "phrase", semanticGroup = "sport_football_match",
            fillInBlankExclusions = listOf(189216L, 189217L, 189218L, 189220L)),

        WordEntity(id = 189220, setId = 1892, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "דֶּשֶׁא", translation = "газон",
            definition = "מִשְׁטַח עֵשֶׂב יָרֹק שֶׁעָלָיו מְשַׂחֲקִים כַּדּוּרֶגֶל מִקְצוֹעָנִי.",
            definitionNative = "Зелёное травяное покрытие поля, на котором играют в футбол.",
            example = "הַדֶּשֶׁא בַּמִּגְרָשׁ הָיָה רָטוֹב לְאַחַר הַגֶּשֶׁם.",
            exampleNative = "דֶּשֶׁא на поле был мокрым после дождя.",
            pos = "noun", semanticGroup = "sport_football_match",
            fillInBlankExclusions = listOf(189216L, 189217L, 189218L, 189219L)),

        // ── Group: sport_football_competitions (5 words) ────────────────────

        WordEntity(id = 189221, setId = 1892, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "דֶּרְבִּי", translation = "дерби",
            definition = "מִפְגַּשׁ סְפּוֹרְט בֵּין שְׁתֵּי קְבוּצוֹת מֵאוֹתָהּ עִיר אוֹ אֵזוֹר.",
            definitionNative = "Принципиальный матч двух команд из одного города или района.",
            example = "דֶּרְבִּי תֵּל אָבִיב הוּא הַמִּפְגָּשׁ הֲכִי מְעַנְיֵן בָּעוֹנָה.",
            exampleNative = "דֶּרְבִּי Тель-Авива — самое интересное противостояние сезона.",
            pos = "noun", semanticGroup = "sport_football_competitions",
            fillInBlankExclusions = listOf(189222L, 189223L, 189224L, 189225L)),

        WordEntity(id = 189222, setId = 1892, languagePair = "he-ru", rarity = "RARE",
            original = "גָּבִיעַ הַמְּדִינָה", translation = "Кубок Государства",
            definition = "תַּחֲרוּת כַּדּוּרֶגֶל יִשְׂרְאֵלִית בְּשִׁיטַת הַדָּחָה עַל גָּבִיעַ הָאַלִּיפוּת.",
            definitionNative = "Израильский футбольный кубок на вылет с одним общим трофеем.",
            example = "הַקְּבוּצָה זָכְתָה בְּגָבִיעַ הַמְּדִינָה אַחֲרֵי שָׁלוֹשׁ שָׁנִים.",
            exampleNative = "Команда выиграла גָּבִיעַ הַמְּדִינָה спустя три года.",
            pos = "phrase", semanticGroup = "sport_football_competitions",
            fillInBlankExclusions = listOf(189221L, 189223L, 189224L, 189225L)),

        WordEntity(id = 189223, setId = 1892, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טוּרְנִיר", translation = "турнир",
            definition = "סִדְרַת מִשְׂחָקִים מְאוּרְגֶּנֶת שֶׁבְּסוֹפָהּ נִקְבַּע מְנַצֵּחַ.",
            definitionNative = "Серия игр по жеребьёвке; в финале определяется победитель.",
            example = "הַטּוּרְנִיר הָאֵירוֹפֵּי יִתְקַיֵּם בַּחוֹדֶשׁ הַבָּא.",
            exampleNative = "Европейский טוּרְנִיר пройдёт в следующем месяце.",
            pos = "noun", semanticGroup = "sport_football_competitions",
            fillInBlankExclusions = listOf(189221L, 189222L, 189224L, 189225L)),

        WordEntity(id = 189224, setId = 1892, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "כַּרְטִיס צָהֹב", translation = "жёлтая карточка",
            definition = "אַזְהָרָה רִשְׁמִית שֶׁמּוֹצִיא הַשּׁוֹפֵט עַל עֲבֵרָה בִּינוֹנִית בַּמִּשְׂחָק.",
            definitionNative = "Официальное предупреждение от арбитра за нарушение средней тяжести.",
            example = "הַקַּשָּׁר קִבֵּל כַּרְטִיס צָהֹב כְּבָר בַּדַּקָּה הַחֲמִישִׁית.",
            exampleNative = "Полузащитник получил כַּרְטִיס צָהֹב уже на пятой минуте.",
            pos = "phrase", semanticGroup = "sport_football_competitions",
            fillInBlankExclusions = listOf(189221L, 189222L, 189223L, 189225L)),

        WordEntity(id = 189225, setId = 1892, languagePair = "he-ru", rarity = "RARE",
            original = "בְּעִיטַת עוֹנְשִׁין", translation = "штрафной удар",
            definition = "בְּעִיטָה חוֹפְשִׁית הַנִּיתֶּנֶת אַחֲרֵי עֲבֵרָה מִחוּץ לָרֲחָבָה.",
            definitionNative = "Свободный удар, назначаемый после нарушения за пределами штрафной площади.",
            example = "מִבְּעִיטַת עוֹנְשִׁין מֵרָחוֹק עָלָה הַכַּדּוּר אֶל הַזָּוִית.",
            exampleNative = "С בְּעִיטַת עוֹנְשִׁין издалека мяч улетел в самый угол.",
            pos = "phrase", semanticGroup = "sport_football_competitions",
            fillInBlankExclusions = listOf(189221L, 189222L, 189223L, 189224L)),
    )
}
