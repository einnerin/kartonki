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
            original = "מֶדְיָה", transliteration = "medya", translation = "медиа / медиаканал"),

        WordEntity(id = 130002, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "עֲלוֹן פִּרְסוּם", transliteration = "alon pirsum", translation = "рекламный флаер / листовка"),

        WordEntity(id = 130003, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "לִינְק", transliteration = "link", translation = "ссылка / гиперссылка"),

        WordEntity(id = 130004, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "מְחִירוֹן", transliteration = "mekhiron", translation = "прайс-лист / ценник"),

        WordEntity(id = 130005, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "הַנָּחַת נֶאֱמָנוּת", transliteration = "hanakhat ne'emanut", translation = "скидка для постоянных клиентов"),

        WordEntity(id = 130006, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "מֶכֶר", transliteration = "mékher", translation = "продажа"),

        WordEntity(id = 130007, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "שׁוּק יָעַד", transliteration = "shuk ya'ad", translation = "целевой рынок"),

        WordEntity(id = 130008, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "אֲתַר אִינְטֶרְנֶט", transliteration = "atár internét", translation = "сайт / интернет-сайт"),

        WordEntity(id = 130009, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "תּוֹכֶן מְקוּרִי", transliteration = "tokhen mekori", translation = "оригинальный контент"),

        WordEntity(id = 130010, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "אַקְצִיָּה", transliteration = "aktsiya", translation = "акция / специальная промоакция"),

        WordEntity(id = 130011, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "זֶהוּת מִיתוּגִית", transliteration = "zehut mitugit", translation = "фирменный стиль / бренд-айдентити"),

        WordEntity(id = 130012, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "מֶסֶר שִׁיוּוקִי", transliteration = "meser shivuki", translation = "маркетинговое сообщение"),

        WordEntity(id = 130013, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "פוֹסְטֶר", transliteration = "póster", translation = "постер / афиша"),

        WordEntity(id = 130014, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "קַטָלוֹג", transliteration = "katalog", translation = "каталог"),

        WordEntity(id = 130015, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "מַנּוּי", transliteration = "manúy", translation = "подписчик / подписка"),

        WordEntity(id = 130016, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "לַיְק", transliteration = "layk", translation = "лайк"),

        WordEntity(id = 130017, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "נְמֶן", transliteration = "naman", translation = "подписчик / абонент"),

        WordEntity(id = 130018, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "צְפִיָּה", transliteration = "tsfiá", translation = "просмотр"),

        WordEntity(id = 130019, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "וֶבִּינַר", transliteration = "vebinar", translation = "вебинар"),

        WordEntity(id = 130020, setId = 1300, languagePair = "he-ru", rarity = "COMMON",
            original = "רְשִׁימַת תַּפּוּצָה", transliteration = "reshimat tifutsa", translation = "список рассылки / email-база"),

        WordEntity(id = 130021, setId = 1300, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִיתוּג", transliteration = "mitúg", translation = "брендинг"),

        WordEntity(id = 130022, setId = 1300, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קַמְפֵּיין", transliteration = "kampeyn", translation = "кампания (рекламная)"),

        WordEntity(id = 130023, setId = 1300, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קהַל יַעַד", transliteration = "kahal yáad", translation = "целевая аудитория"),

        WordEntity(id = 130024, setId = 1300, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מְשׁוֹב", transliteration = "meshuv", translation = "отзыв / обратная связь"),

        WordEntity(id = 130025, setId = 1300, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מוּדָעוּת לְמַותָּג", transliteration = "muda'ut lematag", translation = "узнаваемость бренда"),

        // ── Set 1301: Маркетинг: продвинутый (level=2, UNCOMMON+RARE) ────────────

        WordEntity(id = 130101, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טַרְגּוּט", transliteration = "targút", translation = "таргетинг"),

        WordEntity(id = 130102, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פִּלּוּחַ שׁוּק", transliteration = "piluakh shuk", translation = "сегментация рынка"),

        WordEntity(id = 130103, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מַשְׁפֵּךְ מִכִּירוֹת", transliteration = "mashpekh mikírot", translation = "воронка продаж"),

        WordEntity(id = 130104, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "שִׁיעוּר הַמָּרָה", transliteration = "shi'ur hamará", translation = "конверсия / коэффициент конверсии"),

        WordEntity(id = 130105, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אוֹפְּטִימִיזַצְיָה לְמַנּוֹעֵי חִיפּוּשׂ", transliteration = "optimizatsya lemanode khipus", translation = "поисковая оптимизация / SEO"),

        WordEntity(id = 130106, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תַּפּוּצָה", transliteration = "taputsá", translation = "рассылка / распространение"),

        WordEntity(id = 130107, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אֲנָלִיטִיקָה", transliteration = "analítika", translation = "аналитика"),

        WordEntity(id = 130108, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "טְוַח", transliteration = "tvákh", translation = "охват (аудитории)"),

        WordEntity(id = 130109, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מְעוּרְבוּת", transliteration = "me'urbút", translation = "вовлечённость / engagement"),

        WordEntity(id = 130110, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "אַפִּילְיֵייט", transliteration = "affiliate", translation = "аффилиат / партнёр по реферальной программе"),

        WordEntity(id = 130111, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פִּיתּוּחַ עֵסְקִי", transliteration = "pituyakh iski", translation = "бизнес-девелопмент"),

        WordEntity(id = 130112, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "חֲסוּת", transliteration = "khasút", translation = "спонсорство"),

        WordEntity(id = 130113, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "משַׁפִּיעָן", transliteration = "mashpián", translation = "инфлюэнсер"),

        WordEntity(id = 130114, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תָּכְנִית הַפְנָיָה", transliteration = "takhnit hafnayá", translation = "реферальная программа"),

        WordEntity(id = 130115, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "קְלִיקָּה", transliteration = "kliká", translation = "клик"),

        WordEntity(id = 130116, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "תַּקְצִיב פַּרְסוּם", transliteration = "taktsiv parsúm", translation = "рекламный бюджет"),

        WordEntity(id = 130117, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "מִלּוֹת מַפְתֵּחַ", transliteration = "milot maftéakh", translation = "ключевые слова"),

        WordEntity(id = 130118, setId = 1301, languagePair = "he-ru", rarity = "UNCOMMON",
            original = "פֶּרוּסְפֶּקְט", transliteration = "prospect", translation = "потенциальный клиент / проспект"),

        WordEntity(id = 130119, setId = 1301, languagePair = "he-ru", rarity = "RARE",
            original = "רֵיטַרְגֶּטִינְג", transliteration = "retargetiŋ", translation = "ретаргетинг"),

        WordEntity(id = 130120, setId = 1301, languagePair = "he-ru", rarity = "RARE",
            original = "פִּיקְסֶל מַעֲקָב", transliteration = "piksel ma'akav", translation = "пиксель отслеживания (трекинг-пиксель)"),

        WordEntity(id = 130121, setId = 1301, languagePair = "he-ru", rarity = "RARE",
            original = "קְרִיאָה לְפַעֻלָּה", transliteration = "kri'a lefé'ula", translation = "призыв к действию / CTA"),

        WordEntity(id = 130122, setId = 1301, languagePair = "he-ru", rarity = "RARE",
            original = "תוֹכְנִית מֵדִיָּה", transliteration = "tokhnit mediyá", translation = "медиаплан"),

        WordEntity(id = 130123, setId = 1301, languagePair = "he-ru", rarity = "RARE",
            original = "בְּדִיקַת אֵי-בֵּי", transliteration = "bdíkat ey-bey", translation = "A/B тест"),

        WordEntity(id = 130124, setId = 1301, languagePair = "he-ru", rarity = "RARE",
            original = "שִׁיעוּר נִטִּישָׁה", transliteration = "shi'ur nitishá", translation = "показатель отказов / bounce rate"),

        WordEntity(id = 130125, setId = 1301, languagePair = "he-ru", rarity = "RARE",
            original = "עֶרֶךְ חַיֵּי לָקוֹחַ", transliteration = "erekh khaye lakóakh", translation = "пожизненная ценность клиента / CLV"),

        // ── Set 1302: Маркетинг: углублённый (level=3, RARE+EPIC) ────────────────

        WordEntity(id = 130201, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "מִיצּוּב", transliteration = "mitsúv", translation = "позиционирование"),

        WordEntity(id = 130202, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "בִּידּוּל", transliteration = "bidúl", translation = "дифференциация"),

        WordEntity(id = 130203, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "הַצְּעַת עֵרֶךְ", transliteration = "hatsa'at erekh", translation = "ценностное предложение"),

        WordEntity(id = 130204, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "מַחְזוֹר חַיֵּי מוּצָר", transliteration = "makhzor khaye mutsár", translation = "жизненный цикл продукта"),

        WordEntity(id = 130205, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "עֶלֶות רְכִישַׁת לָקוֹחַ", transliteration = "élut rekhishat lakóakh", translation = "стоимость привлечения клиента / CAC"),

        WordEntity(id = 130206, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "מַרְקֶטִינְג תֹּכֶן", transliteration = "marketiŋ tókhen", translation = "контент-маркетинг"),

        WordEntity(id = 130207, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "שִׁיוּוּק בְּרֶשֶׁת חֶבְרָתִית", transliteration = "shivúk bereshet khevratít", translation = "маркетинг в социальных сетях / SMM"),

        WordEntity(id = 130208, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "אוֹטוֹמַצְיַת שִׁיוּוּק", transliteration = "otomatsyat shivúk", translation = "автоматизация маркетинга"),

        WordEntity(id = 130209, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "נִיהוּל קְשָׁרֵי לָקוֹחוֹת", transliteration = "nihul ksharey lakhókhot", translation = "управление отношениями с клиентами / CRM"),

        WordEntity(id = 130210, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "שִׁיוּוּק וִירַלִי", transliteration = "shivúk virali", translation = "вирусный маркетинг"),

        WordEntity(id = 130211, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "תֹּכֶן גּוֹלְשִׁים", transliteration = "tókhen golshím", translation = "пользовательский контент / UGC"),

        WordEntity(id = 130212, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "יְיִחוּס", transliteration = "yikhús", translation = "атрибуция (маркетинговая)"),

        WordEntity(id = 130213, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "מִיתּוּג מְשֻׁתָּף", transliteration = "mitúg meshuhtáf", translation = "ко-брендинг"),

        WordEntity(id = 130214, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "תָּמְהִיל מֵדִיָּה", transliteration = "tamkhil mediyá", translation = "медиамикс"),

        WordEntity(id = 130215, setId = 1302, languagePair = "he-ru", rarity = "RARE",
            original = "נֶטּוֹ מְקַדֵּם", transliteration = "neto mekadém", translation = "индекс потребительской лояльности / NPS"),

        WordEntity(id = 130216, setId = 1302, languagePair = "he-ru", rarity = "EPIC",
            original = "עַרְנָק לָקוֹחַ", transliteration = "arnák lakóakh", translation = "кошелёк клиента / share of wallet"),

        WordEntity(id = 130217, setId = 1302, languagePair = "he-ru", rarity = "EPIC",
            original = "נֵאוּרוֹמַרְקֶטִינְג", transliteration = "neuromarketiŋ", translation = "нейромаркетинг"),

        WordEntity(id = 130218, setId = 1302, languagePair = "he-ru", rarity = "EPIC",
            original = "שִׁיוּוּק עַל-פּי חֶשְׁבּוֹנוֹת", transliteration = "shivúk al-pi kheshbonót", translation = "account-based marketing / ABM"),

        WordEntity(id = 130219, setId = 1302, languagePair = "he-ru", rarity = "EPIC",
            original = "פְּרוֹגְרָמָטִי", transliteration = "programáti", translation = "программатик-реклама"),

        WordEntity(id = 130220, setId = 1302, languagePair = "he-ru", rarity = "EPIC",
            original = "עֲרוּץ רַב-מֵדִי", transliteration = "aruts rav-medí", translation = "омниканальность"),

        WordEntity(id = 130221, setId = 1302, languagePair = "he-ru", rarity = "EPIC",
            original = "גְּרוּת צְמִיחָה", transliteration = "grut tsmikhá", translation = "growth hacking"),

        WordEntity(id = 130222, setId = 1302, languagePair = "he-ru", rarity = "EPIC",
            original = "קּוֹל מוֹתָּג", transliteration = "kol motág", translation = "голос бренда / brand voice"),

        WordEntity(id = 130223, setId = 1302, languagePair = "he-ru", rarity = "EPIC",
            original = "נַרָטִיב מוֹתָּג", transliteration = "narátiv motág", translation = "нарратив бренда / brand story"),

        WordEntity(id = 130224, setId = 1302, languagePair = "he-ru", rarity = "EPIC",
            original = "הִבְדָּלוּת תַּחֲרוּתִית", transliteration = "hivdalút takharútit", translation = "конкурентная отстройка"),

        WordEntity(id = 130225, setId = 1302, languagePair = "he-ru", rarity = "EPIC",
            original = "מַפַּת תְּפִיסָה", transliteration = "mapat tfiisá", translation = "перцепционная карта / perceptual map"),

        // ── Set 1303: Маркетинг: профессиональный (level=4, EPIC+LEGENDARY) ─────────

        WordEntity(id = 130301, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "אַרְכִיטֶקְטוּרַת מוֹתָּג", transliteration = "arkhitekturát motág", translation = "бренд-архитектура"),

        WordEntity(id = 130302, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "תִּקְשׁוֹרֶת אִסְטְרָטֶגִית", transliteration = "tikshoret istratégit", translation = "стратегическая коммуникация"),

        WordEntity(id = 130303, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "קְנִיַּת מֵדְיָה", transliteration = "kniyát mediyá", translation = "медиабайинг / закупка медиа"),

        WordEntity(id = 130304, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "סֵמְיוֹטִיקָה שֶׁל מוֹתָּג", transliteration = "semyotika shel motág", translation = "семиотика бренда"),

        WordEntity(id = 130305, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "אַרְכֵיטִיפּ שֶׁל מוֹתָּג", transliteration = "arkhetip shel motág", translation = "архетип бренда"),

        WordEntity(id = 130306, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "הוֹן מוֹתָּג", transliteration = "hon motág", translation = "акционерная стоимость бренда / brand equity"),

        WordEntity(id = 130307, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "מִיתּוּג רְגָשִׁי", transliteration = "mitúg regashí", translation = "эмоциональный брендинг"),

        WordEntity(id = 130308, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "מִיפּוּי תְּפִיסָה", transliteration = "mipúy tfiisá", translation = "перцепционный маппинг"),

        WordEntity(id = 130309, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "אִינְטֶגְרַצְיַת מֵסָּר", transliteration = "integratsiyat mesár", translation = "интегрированные маркетинговые коммуникации / IMC"),

        WordEntity(id = 130310, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "שׁוֹוִי מוֹתָּג", transliteration = "shovi motág", translation = "оценка стоимости бренда"),

        WordEntity(id = 130311, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "תָּכְנִית תְּקְשׁוֹרֶת", transliteration = "takhnit tikshoret", translation = "коммуникационная стратегия"),

        WordEntity(id = 130312, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "נֶרָטִיב מְחֻדָּשׁ", transliteration = "narátiv mekhudásh", translation = "реинвенция нарратива / переосмысление истории бренда"),

        WordEntity(id = 130313, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "תֶּדְמִית תַּאֲגִידִית", transliteration = "tedmít ta'agidit", translation = "корпоративный имидж"),

        WordEntity(id = 130314, setId = 1303, languagePair = "he-ru", rarity = "EPIC",
            original = "נִיתּוּחַ שִׂיחַ", transliteration = "nitúakh siakh", translation = "дискурс-анализ (в маркетинге)"),

        WordEntity(id = 130315, setId = 1303, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "הוֹן מוֹתָּג מֵבֻסָּס לָקוֹחַ", transliteration = "hon motág mevusas lakóakh", translation = "потребительский капитал бренда (модель Келлера)"),

        WordEntity(id = 130316, setId = 1303, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "פּוֹזִיצְיוֹנִינְג מַעְרָכָה", transliteration = "pozitsyoniŋ ma'arakha", translation = "позиционирование в ценовой войне"),

        WordEntity(id = 130317, setId = 1303, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "פּוֹרְטְפוֹלְיוֹ מוֹתָּגִים", transliteration = "portfolio motaguim", translation = "портфель брендов"),

        WordEntity(id = 130318, setId = 1303, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "אִסְטְרָטֶגְיַת מֵחִיר", transliteration = "istrategiyát mekhír", translation = "ценовая стратегия"),

        WordEntity(id = 130319, setId = 1303, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תַּכְנּוּן תַּחֲרוּתִי", transliteration = "tikhnún takharútí", translation = "конкурентное планирование"),

        WordEntity(id = 130320, setId = 1303, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "שִׁוּוּק נוּרוֹ-שִׂיחַתִּי", transliteration = "shivúk nuro-siakhati", translation = "нейролингвистический маркетинг"),

        WordEntity(id = 130321, setId = 1303, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "דַּיְנָמִיקַת שּׁוּק", transliteration = "dinamikat shuk", translation = "рыночная динамика"),

        WordEntity(id = 130322, setId = 1303, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "יְצִירַת דֶּרֶךְ שׁוּק", transliteration = "yetsirat derekh shuk", translation = "создание рыночного пути / go-to-market стратегия"),

        WordEntity(id = 130323, setId = 1303, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "בִּיקּוֹרֶת שִׁיוּוּק", transliteration = "bikoret shivúk", translation = "критика маркетинга / маркетинговая критика"),

        WordEntity(id = 130324, setId = 1303, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תָּכְנִית שִׁיוּוּק אִסְטְרָטֶגִי", transliteration = "takhnit shivúk istrategí", translation = "стратегический маркетинговый план"),

        WordEntity(id = 130325, setId = 1303, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מֶשֶׁק פְּרִסָה", transliteration = "mesek prisa", translation = "медиаэкономика / экономика рекламного пространства"),

        // ── Set 1304: Маркетинг: носитель языка (level=5, LEGENDARY) ─────────────

        WordEntity(id = 130401, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "שִׁיוּוּק פּוֹסְטְ-מוֹדֶרְנִי", transliteration = "shivúk post-moderni", translation = "постмодернистский маркетинг"),

        WordEntity(id = 130402, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "הִיפֶּר-צְרִיכָה", transliteration = "hiper-tsrikhá", translation = "гиперпотребление / гиперреальность потребления"),

        WordEntity(id = 130403, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "סִימוּלַקְרוּם שֶׁל מוֹתָּג", transliteration = "simulakrum shel motág", translation = "симулякр бренда (Бодрийяр)"),

        WordEntity(id = 130404, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "שִׁיחַ צְרִיכָה", transliteration = "siakh tsrikhá", translation = "дискурс потребительства"),

        WordEntity(id = 130405, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "אוֹרְיֵינוּת מֵדִיָּה בִּיקּוֹרְתִּית", transliteration = "oryenut mediyá bikortit", translation = "критическая медиаграмотность"),

        WordEntity(id = 130406, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "שִׁיוּוּק פּוֹסְטְ-מִבְנִי", transliteration = "shivúk post-mivni", translation = "постструктуральный маркетинг"),

        WordEntity(id = 130407, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "חֶבְרַת הַצֵּגָה", transliteration = "khevrat hatsagá", translation = "общество спектакля (Дебор) в контексте рекламы"),

        WordEntity(id = 130408, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "כַּלְכָּלַת תְּשׁוּמָה לֵב", transliteration = "kalkala tshumá lev", translation = "экономика внимания / attention economy"),

        WordEntity(id = 130409, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "אִידֵאוֹלוֹגְיַת הַצְּרִיכָה", transliteration = "ideologiyát hatsrikhá", translation = "идеология потребления"),

        WordEntity(id = 130410, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "פֶּטִישִׁיזַצְיַת הַסְּחוֹרָה", transliteration = "fetishizatsiyát haskhora", translation = "фетишизация товара (Маркс)"),

        WordEntity(id = 130411, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "בִּיקּוֹרֶת הַפַּרְסוּם", transliteration = "bikoret haparsúm", translation = "критика рекламы / антиреклама"),

        WordEntity(id = 130412, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "אַלְגּוֹרִיתְם וּשִׁיוּוּק", transliteration = "algoritm ushivúk", translation = "алгоритм и маркетинг (платформенная экономика)"),

        WordEntity(id = 130413, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "נוֹרְמָלִיזַצְיַת מוֹתָּג", transliteration = "normalizatsiyát motág", translation = "нормализация бренда (культурная ассимиляция)"),

        WordEntity(id = 130414, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "מִין וְפַרְסוּם", transliteration = "min veparsúm", translation = "гендер и реклама (критические исследования)"),

        WordEntity(id = 130415, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "גּוּף כְּמֶטָפוֹרָה בַּפַּרְסוּם", transliteration = "guf kemetafora baparsúm", translation = "тело как метафора в рекламе"),

        WordEntity(id = 130416, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "שִׁיוּוּק פּוֹסְטְ-קוֹלוֹנְיָאלִי", transliteration = "shivúk post-koloniyali", translation = "постколониальный маркетинг"),

        WordEntity(id = 130417, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "כּוֹחַ וּשִׁיוּוּק", transliteration = "koakh ushivúk", translation = "власть и маркетинг (Фуко)"),

        WordEntity(id = 130418, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "זֶהוּת וּמִיתּוּג", transliteration = "zehút umitúg", translation = "идентичность и брендинг"),

        WordEntity(id = 130419, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "רֶגֶשׁ כְּסַחְרֹרֶת בַּצְּרִיכָה", transliteration = "regesh kesakhroret batsrikhá", translation = "аффект как вихрь потребления"),

        WordEntity(id = 130420, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "פִּילוֹסוֹפְיַת הַמֶּרְחָב הַצְּרִיכָתִי", transliteration = "filosofyát hamerkhav hatsrikháti", translation = "философия потребительского пространства"),

        WordEntity(id = 130421, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "שִׁיוּוּק נֶגְדִּי", transliteration = "shivúk negdí", translation = "антимаркетинг / деmarketing"),

        WordEntity(id = 130422, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "אֶקוֹ-שִׁיוּוּק בִּיקּוֹרְתִּי", transliteration = "eko-shivúk bikortí", translation = "критический экомаркетинг (greenwashing и его анализ)"),

        WordEntity(id = 130423, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "פּוֹלִיטִיקָה שֶׁל מוֹתָּג", transliteration = "politika shel motág", translation = "политика бренда (брендинг как власть)"),

        WordEntity(id = 130424, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "תֵּיאוֹרְיַת הַשְּׂדֵה הַשִּׁיוּוּקִי", transliteration = "teoriyát hasde hashivúki", translation = "теория маркетингового поля (Бурдьё)"),

        WordEntity(id = 130425, setId = 1304, languagePair = "he-ru", rarity = "LEGENDARY",
            original = "שִׁיוּוּק כְּיַחֲסֵי כֹּחַ", transliteration = "shivúk keyakhase koakh", translation = "маркетинг как властные отношения"),
    )
}
