package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

object WordDataHebrewBatch53 {

    val sets: List<WordSetEntity> get() = listOf(

        WordSetEntity(
            id = 1300, languagePair = "he-ru", orderIndex = 1300,
            name = "Маркетинг",
            description = "Базовая лексика рекламы, продвижения и работы с клиентами",
            topic = "Маркетинг",
            level = 1),

        WordSetEntity(
            id = 1301, languagePair = "he-ru", orderIndex = 1301,
            name = "Маркетинг",
            description = "Инструменты и каналы цифрового маркетинга",
            topic = "Маркетинг",
            level = 2),

        WordSetEntity(
            id = 1302, languagePair = "he-ru", orderIndex = 1302,
            name = "Маркетинг",
            description = "Стратегический маркетинг, брендинг и аналитика",
            topic = "Маркетинг",
            level = 3),

        WordSetEntity(
            id = 1303, languagePair = "he-ru", orderIndex = 1303,
            name = "Маркетинг",
            description = "Бренд-архитектура, стратегические коммуникации и перцепционный менеджмент",
            topic = "Маркетинг",
            level = 4),

        WordSetEntity(
            id = 1304, languagePair = "he-ru", orderIndex = 1304,
            name = "Маркетинг",
            description = "Академический и постструктуральный дискурс маркетинга и потребления",
            topic = "Маркетинг",
            level = 5),
    )

    val words: List<WordEntity> get() = listOf(

        // ── Set 1300: Маркетинг: основы (level=1, COMMON+UNCOMMON) ────────────

        WordEntity(id = 130001, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "מֶדְיָה", translation = "медиа / медиаканал"),

        WordEntity(id = 130002, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "עֲלוֹן פִּרְסוּם", translation = "рекламный флаер / листовка"),

        WordEntity(id = 130003, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "לִינְק", translation = "ссылка / гиперссылка"),

        WordEntity(id = 130004, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "מְחִירוֹן", translation = "прайс-лист / ценник"),

        WordEntity(id = 130005, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "הַנָּחַת נֶאֱמָנוּת", translation = "скидка для постоянных клиентов"),

        WordEntity(id = 130006, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "מֶכֶר", translation = "продажа"),

        WordEntity(id = 130007, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "שׁוּק יָעַד", translation = "целевой рынок"),

        WordEntity(id = 130008, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "אֲתַר אִינְטֶרְנֶט", translation = "сайт / интернет-сайт"),

        WordEntity(id = 130009, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "תּוֹכֶן מְקוּרִי", translation = "оригинальный контент"),

        WordEntity(id = 130010, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "אַקְצִיָּה", translation = "акция / специальная промоакция"),

        WordEntity(id = 130011, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "זֶהוּת מִיתוּגִית", translation = "фирменный стиль / бренд-айдентити"),

        WordEntity(id = 130012, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "מֶסֶר שִׁיוּוקִי", translation = "маркетинговое сообщение"),

        WordEntity(id = 130013, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "פוֹסְטֶר", translation = "постер / афиша"),

        WordEntity(id = 130014, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "קַטָלוֹג", translation = "каталог"),

        WordEntity(id = 130015, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "מַנּוּי", translation = "подписчик / подписка"),

        WordEntity(id = 130016, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "לַיְק", translation = "лайк"),

        WordEntity(id = 130017, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "נְמֶן", translation = "подписчик / абонент"),

        WordEntity(id = 130018, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "צְפִיָּה", translation = "просмотр"),

        WordEntity(id = 130019, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "וֶבִּינַר", translation = "вебинар"),

        WordEntity(id = 130020, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "רְשִׁימַת תַּפּוּצָה", translation = "список рассылки / email-база"),

        WordEntity(id = 130021, setId = 1300, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִיתוּג", translation = "брендинг"),

        WordEntity(id = 130022, setId = 1300, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קַמְפֵּיין", translation = "кампания (рекламная)"),

        WordEntity(id = 130023, setId = 1300, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קהַל יַעַד", translation = "целевая аудитория"),

        WordEntity(id = 130024, setId = 1300, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מְשׁוֹב", translation = "отзыв / обратная связь"),

        WordEntity(id = 130025, setId = 1300, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מוּדָעוּת לְמַותָּג", translation = "узнаваемость бренда"),

        // ── Set 1301: Маркетинг: продвинутый (level=2, UNCOMMON+RARE) ────────────

        WordEntity(id = 130101, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טַרְגּוּט", translation = "таргетинг"),

        WordEntity(id = 130102, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פִּלּוּחַ שׁוּק", translation = "сегментация рынка"),

        WordEntity(id = 130103, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַשְׁפֵּךְ מִכִּירוֹת", translation = "воронка продаж"),

        WordEntity(id = 130104, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שִׁיעוּר הַמָּרָה", translation = "конверсия / коэффициент конверсии"),

        WordEntity(id = 130105, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אוֹפְּטִימִיזַצְיָה לְמַנּוֹעֵי חִיפּוּשׂ", translation = "поисковая оптимизация / SEO"),

        WordEntity(id = 130106, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תְּפוּצָה", translation = "рассылка / распространение"),

        WordEntity(id = 130107, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אֲנָלִיטִיקָה", translation = "аналитика"),

        WordEntity(id = 130108, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טְוַח", translation = "охват (аудитории)"),

        WordEntity(id = 130109, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מְעוּרְבוּת", translation = "вовлечённость / engagement"),

        WordEntity(id = 130110, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אַפִּילְיֵייט", translation = "аффилиат / партнёр по реферальной программе"),

        WordEntity(id = 130111, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פִּיתּוּחַ עֵסְקִי", translation = "бизнес-девелопмент"),

        WordEntity(id = 130112, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חָסוּת", translation = "спонсорство"),

        WordEntity(id = 130113, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַשְׁפִּיעָן", translation = "инфлюэнсер"),

        WordEntity(id = 130114, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תָּכְנִית הַפְנָיָה", translation = "реферальная программа"),

        WordEntity(id = 130115, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קְלִיקָּה", translation = "клик"),

        WordEntity(id = 130116, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תַּקְצִיב פַּרְסוּם", translation = "рекламный бюджет"),

        WordEntity(id = 130117, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִלּוֹת מַפְתֵּחַ", translation = "ключевые слова"),

        WordEntity(id = 130118, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פֶּרוּסְפֶּקְט", translation = "потенциальный клиент / проспект"),

        WordEntity(id = 130119, setId = 1301, languagePair = "he-ru", rarity = "RARE",
            original = "רֵיטַרְגֶּטִינְג", translation = "ретаргетинг"),

        WordEntity(id = 130120, setId = 1301, languagePair = "he-ru", rarity = "RARE",
            original = "פִּיקְסֶל מַעֲקָב", translation = "пиксель отслеживания (трекинг-пиксель)"),

        WordEntity(id = 130121, setId = 1301, languagePair = "he-ru", rarity = "RARE",
            original = "קְרִיאָה לְפַעֻלָּה", translation = "призыв к действию / CTA"),

        WordEntity(id = 130122, setId = 1301, languagePair = "he-ru", rarity = "RARE",
            original = "תוֹכְנִית מֵדִיָּה", translation = "медиаплан"),

        WordEntity(id = 130123, setId = 1301, languagePair = "he-ru", rarity = "RARE",
            original = "בְּדִיקַת אֵי-בֵּי", translation = "A/B тест"),

        WordEntity(id = 130124, setId = 1301, languagePair = "he-ru", rarity = "RARE",
            original = "שִׁיעוּר נִטִּישָׁה", translation = "показатель отказов / bounce rate"),

        WordEntity(id = 130125, setId = 1301, languagePair = "he-ru", rarity = "RARE",
            original = "עֶרֶךְ חַיֵּי לָקוֹחַ", translation = "пожизненная ценность клиента / CLV"),

        // ── Set 1302: Маркетинг: углублённый (level=3, RARE+EPIC) ────────────────

        WordEntity(id = 130201, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "מִיצּוּב", translation = "позиционирование"),

        WordEntity(id = 130202, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "בִּידּוּל", translation = "дифференциация"),

        WordEntity(id = 130203, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "הַצְּעַת עֵרֶךְ", translation = "ценностное предложение"),

        WordEntity(id = 130204, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "מַחְזוֹר חַיֵּי מוּצָר", translation = "жизненный цикл продукта"),

        WordEntity(id = 130205, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "עֶלֶות רְכִישַׁת לָקוֹחַ", translation = "стоимость привлечения клиента / CAC"),

        WordEntity(id = 130206, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "מַרְקֶטִינְג תֹּכֶן", translation = "контент-маркетинг"),

        WordEntity(id = 130207, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "שִׁיוּוּק בְּרֶשֶׁת חֶבְרָתִית", translation = "маркетинг в социальных сетях / SMM"),

        WordEntity(id = 130208, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "אוֹטוֹמַצְיַת שִׁיוּוּק", translation = "автоматизация маркетинга"),

        WordEntity(id = 130209, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "נִיהוּל קְשָׁרֵי לָקוֹחוֹת", translation = "управление отношениями с клиентами / CRM"),

        WordEntity(id = 130210, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "שִׁיוּוּק וִירַלִי", translation = "вирусный маркетинг"),

        WordEntity(id = 130211, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "תֹּכֶן גּוֹלְשִׁים", translation = "пользовательский контент / UGC"),

        WordEntity(id = 130212, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "יְיִחוּס", translation = "атрибуция (маркетинговая)"),

        WordEntity(id = 130213, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "מִיתּוּג מְשֻׁתָּף", translation = "ко-брендинг"),

        WordEntity(id = 130214, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "תָּמְהִיל מֵדִיָּה", translation = "медиамикс"),

        WordEntity(id = 130215, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "נֶטּוֹ מְקַדֵּם", translation = "индекс потребительской лояльности / NPS"),

        WordEntity(id = 130216, setId = 1302, languagePair = "he-ru", rarity = "EPIC",
            original = "עַרְנָק לָקוֹחַ", translation = "кошелёк клиента / share of wallet"),

        WordEntity(id = 130217, setId = 1302, languagePair = "he-ru", rarity = "EPIC",
            original = "נֵאוּרוֹמַרְקֶטִינְג", translation = "нейромаркетинг"),

        WordEntity(id = 130218, setId = 1302, languagePair = "he-ru", rarity = "EPIC",
            original = "שִׁיוּוּק עַל-פּי חֶשְׁבּוֹנוֹת", translation = "account-based marketing / ABM"),

        WordEntity(id = 130219, setId = 1302, languagePair = "he-ru", rarity = "EPIC",
            original = "פְּרוֹגְרָמָטִי", translation = "программатик-реклама"),

        WordEntity(id = 130220, setId = 1302, languagePair = "he-ru", rarity = "EPIC",
            original = "עֲרוּץ רַב-מֵדִי", translation = "омниканальность"),

        WordEntity(id = 130221, setId = 1302, languagePair = "he-ru", rarity = "EPIC",
            original = "גְּרוּת צְמִיחָה", translation = "growth hacking"),

        WordEntity(id = 130222, setId = 1302, languagePair = "he-ru", rarity = "EPIC",
            original = "קּוֹל מוֹתָּג", translation = "голос бренда / brand voice"),

        WordEntity(id = 130223, setId = 1302, languagePair = "he-ru", rarity = "EPIC",
            original = "נַרָטִיב מוֹתָּג", translation = "нарратив бренда / brand story"),

        WordEntity(id = 130224, setId = 1302, languagePair = "he-ru", rarity = "EPIC",
            original = "הִבְדָּלוּת תַּחֲרוּתִית", translation = "конкурентная отстройка"),

        WordEntity(id = 130225, setId = 1302, languagePair = "he-ru", rarity = "EPIC",
            original = "מַפַּת תְּפִיסָה", translation = "перцепционная карта / perceptual map"),

        // ── Set 1303: Маркетинг: профессиональный (level=4, EPIC+LEGENDARY) ─────────

        WordEntity(id = 130301, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "אַרְכִיטֶקְטוּרַת מוֹתָּג", translation = "бренд-архитектура"),

        WordEntity(id = 130302, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "תִּקְשׁוֹרֶת אִסְטְרָטֶגִית", translation = "стратегическая коммуникация"),

        WordEntity(id = 130303, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "קְנִיַּת מֵדְיָה", translation = "медиабайинг / закупка медиа"),

        WordEntity(id = 130304, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "סֵמְיוֹטִיקָה שֶׁל מוֹתָּג", translation = "семиотика бренда"),

        WordEntity(id = 130305, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "אַרְכֵיטִיפּ שֶׁל מוֹתָּג", translation = "архетип бренда"),

        WordEntity(id = 130306, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "הוֹן מוֹתָּג", translation = "акционерная стоимость бренда / brand equity"),

        WordEntity(id = 130307, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "מִיתּוּג רְגָשִׁי", translation = "эмоциональный брендинг"),

        WordEntity(id = 130308, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "מִיפּוּי תְּפִיסָה", translation = "перцепционный маппинг"),

        WordEntity(id = 130309, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "אִינְטֶגְרַצְיַת מֵסָּר", translation = "интегрированные маркетинговые коммуникации / IMC"),

        WordEntity(id = 130310, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "שׁוֹוִי מוֹתָּג", translation = "оценка стоимости бренда"),

        WordEntity(id = 130311, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "תָּכְנִית תְּקְשׁוֹרֶת", translation = "коммуникационная стратегия"),

        WordEntity(id = 130312, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "נֶרָטִיב מְחֻדָּשׁ", translation = "реинвенция нарратива / переосмысление истории бренда"),

        WordEntity(id = 130313, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "תֶּדְמִית תַּאֲגִידִית", translation = "корпоративный имидж"),

        WordEntity(id = 130314, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "נִיתּוּחַ שִׂיחַ", translation = "дискурс-анализ (в маркетинге)"),

        WordEntity(id = 130315, setId = 1303, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "הוֹן מוֹתָּג מֵבֻסָּס לָקוֹחַ", translation = "потребительский капитал бренда (модель Келлера)"),

        WordEntity(id = 130316, setId = 1303, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "פּוֹזִיצְיוֹנִינְג מַעְרָכָה", translation = "позиционирование в ценовой войне"),

        WordEntity(id = 130317, setId = 1303, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "פּוֹרְטְפוֹלְיוֹ מוֹתָּגִים", translation = "портфель брендов"),

        WordEntity(id = 130318, setId = 1303, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "אִסְטְרָטֶגְיַת מֵחִיר", translation = "ценовая стратегия"),

        WordEntity(id = 130319, setId = 1303, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תַּכְנּוּן תַּחֲרוּתִי", translation = "конкурентное планирование"),

        WordEntity(id = 130320, setId = 1303, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "שִׁוּוּק נוּרוֹ-שִׂיחַתִּי", translation = "нейролингвистический маркетинг"),

        WordEntity(id = 130321, setId = 1303, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "דַּיְנָמִיקַת שּׁוּק", translation = "рыночная динамика"),

        WordEntity(id = 130322, setId = 1303, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "יְצִירַת דֶּרֶךְ שׁוּק", translation = "создание рыночного пути / go-to-market стратегия"),

        WordEntity(id = 130323, setId = 1303, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "בִּיקּוֹרֶת שִׁיוּוּק", translation = "критика маркетинга / маркетинговая критика"),

        WordEntity(id = 130324, setId = 1303, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תָּכְנִית שִׁיוּוּק אִסְטְרָטֶגִי", translation = "стратегический маркетинговый план"),

        WordEntity(id = 130325, setId = 1303, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מֶשֶׁק פְּרִסָה", translation = "медиаэкономика / экономика рекламного пространства"),

        // ── Set 1304: Маркетинг: носитель языка (level=5, LEGENDARY) ─────────────

        WordEntity(id = 130401, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "שִׁיוּוּק פּוֹסְטְ-מוֹדֶרְנִי", translation = "постмодернистский маркетинг"),

        WordEntity(id = 130402, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "הִיפֶּר-צְרִיכָה", translation = "гиперпотребление / гиперреальность потребления"),

        WordEntity(id = 130403, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "סִימוּלַקְרוּם שֶׁל מוֹתָּג", translation = "симулякр бренда (Бодрийяр)"),

        WordEntity(id = 130404, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "שִׁיחַ צְרִיכָה", translation = "дискурс потребительства"),

        WordEntity(id = 130405, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "אוֹרְיֵינוּת מֵדִיָּה בִּיקּוֹרְתִּית", translation = "критическая медиаграмотность"),

        WordEntity(id = 130406, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "שִׁיוּוּק פּוֹסְטְ-מִבְנִי", translation = "постструктуральный маркетинг"),

        WordEntity(id = 130407, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "חֶבְרַת הַצֵּגָה", translation = "общество спектакля (Дебор) в контексте рекламы"),

        WordEntity(id = 130408, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "כַּלְכָּלַת תְּשׁוּמָה לֵב", translation = "экономика внимания / attention economy"),

        WordEntity(id = 130409, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "אִידֵאוֹלוֹגְיַת הַצְּרִיכָה", translation = "идеология потребления"),

        WordEntity(id = 130410, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "פֶּטִישִׁיזַצְיַת הַסְּחוֹרָה", translation = "фетишизация товара (Маркс)"),

        WordEntity(id = 130411, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "בִּיקּוֹרֶת הַפַּרְסוּם", translation = "критика рекламы / антиреклама"),

        WordEntity(id = 130412, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "אַלְגּוֹרִיתְם וּשִׁיוּוּק", translation = "алгоритм и маркетинг (платформенная экономика)"),

        WordEntity(id = 130413, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "נוֹרְמָלִיזַצְיַת מוֹתָּג", translation = "нормализация бренда (культурная ассимиляция)"),

        WordEntity(id = 130414, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מִין וְפַרְסוּם", translation = "гендер и реклама (критические исследования)"),

        WordEntity(id = 130415, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "גּוּף כְּמֶטָפוֹרָה בַּפַּרְסוּם", translation = "тело как метафора в рекламе"),

        WordEntity(id = 130416, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "שִׁיוּוּק פּוֹסְטְ-קוֹלוֹנְיָאלִי", translation = "постколониальный маркетинг"),

        WordEntity(id = 130417, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "כּוֹחַ וּשִׁיוּוּק", translation = "власть и маркетинг (Фуко)"),

        WordEntity(id = 130418, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "זֶהוּת וּמִיתּוּג", translation = "идентичность и брендинг"),

        WordEntity(id = 130419, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "רֶגֶשׁ כְּסַחְרֹרֶת בַּצְּרִיכָה", translation = "аффект как вихрь потребления"),

        WordEntity(id = 130420, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "פִּילוֹסוֹפְיַת הַמֶּרְחָב הַצְּרִיכָתִי", translation = "философия потребительского пространства"),

        WordEntity(id = 130421, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "שִׁיוּוּק נֶגְדִּי", translation = "антимаркетинг / деmarketing"),

        WordEntity(id = 130422, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "אֶקוֹ-שִׁיוּוּק בִּיקּוֹרְתִּי", translation = "критический экомаркетинг (greenwashing и его анализ)"),

        WordEntity(id = 130423, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "פּוֹלִיטִיקָה שֶׁל מוֹתָּג", translation = "политика бренда (брендинг как власть)"),

        WordEntity(id = 130424, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תֵּיאוֹרְיַת הַשְּׂדֵה הַשִּׁיוּוּקִי", translation = "теория маркетингового поля (Бурдьё)"),

        WordEntity(id = 130425, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "שִׁיוּוּק כְּיַחֲסֵי כֹּחַ", translation = "маркетинг как властные отношения"),
    )
}
