package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Городская жизнь и услуги (level 5, носитель языка).
 *
 * Set 369: «Городская жизнь и услуги» — высокая лексика уровня носителя:
 * governance, public administration, юридическая лексика, urban planning
 * advanced terms, муниципальные финансы.
 *
 * Распределение редкости: 13 EPIC + 12 LEGENDARY — два смежных уровня шкалы.
 *
 * Параллельно создаются L1–L4 (365–368) — базовая, продвинутая, углублённая
 * и профессиональная лексика. Слова setId=369 не пересекаются ни с L1–L4
 * темы «Городская жизнь и услуги», ни с темами «Финансы» (344, 214),
 * «Право» (220–221), «Политика» (236, 237, 363).
 *
 * Замены при подготовке (объявленные конфликты):
 *   - escrow      → home rule       (escrow в Финансы L5, set 344)
 *   - due process → civic engagement (due process в Право, set 221)
 *   - fiscal year → general fund    (fiscal year в Финансы L3, set 214)
 *
 * SemanticGroups (5 × 5):
 *   city_governance         — ombudsman, civic engagement, separation of powers,
 *                             procurement law, public-private partnership
 *   city_advanced_legal     — eminent domain, easement, encumbrance, home rule, lien
 *   city_admin              — adjudication, statutory body, regulatory framework,
 *                             comptroller, audit trail
 *   city_planning_advanced  — transit-oriented development, smart city,
 *                             green infrastructure, walkability index, place-making
 *   city_advanced_finance   — municipal bond, property tax assessment,
 *                             cost-of-living index, general fund, levy
 *
 * isFillInBlankSafe = false на всех 25 словах: лексика governance/legal —
 * многие термины формально подходят в чужие пропуски (regulatory framework
 * vs. statutory body и т.п.). FILL_IN_BLANK pipeline решит точечно.
 *
 * Word IDs: 36901..36925 (setId × 100 + position).
 */
object WordDataEnglishCityLifeL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 369, languagePair = "en-ru", orderIndex = 369,
            name = "Городская жизнь и услуги",
            description = "Уровень носителя: governance, public administration, юридическая лексика",
            topic = "Городская жизнь и услуги", level = 5),
    )

    val words: List<WordEntity> = listOf(

        // ── city_governance (5) ───────────────────────────────────────────

        WordEntity(id = 36901, setId = 369, languagePair = "en-ru", rarity = "EPIC",
            original = "ombudsman", transliteration = "[ˈɑmbədzmən]", translation = "омбудсмен (защитник прав граждан)",
            definition = "An official who hears complaints from citizens against public bodies.",
            definitionNative = "Чиновник, разбирающий жалобы горожан на работу государственных служб.",
            example = "The city ombudsman investigated complaints about the new parking rules.",
            exampleNative = "Городской ombudsman изучил жалобы на новые парковочные правила.",
            pos = "noun", semanticGroup = "city_governance", fillInBlankExclusions = listOf(36902L, 36903L, 36904L, 36905L, 36912L, 36914L)),

        WordEntity(id = 36902, setId = 369, languagePair = "en-ru", rarity = "EPIC",
            original = "civic engagement", transliteration = "[ˈsɪvɪk ɪnˈɡeɪʤmənt]", translation = "гражданское участие",
            definition = "When residents take part in public meetings, votes or volunteer work.",
            definitionNative = "Когда жители ходят на собрания, голосуют и помогают в общих делах.",
            example = "The mayor praised the high level of civic engagement at the town hall.",
            exampleNative = "Мэр похвалил высокий уровень civic engagement на встрече с жителями.",
            pos = "noun", semanticGroup = "city_governance", fillInBlankExclusions = listOf(36901L, 36903L, 36904L, 36905L)),

        WordEntity(id = 36903, setId = 369, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "separation of powers", transliteration = "[ˌsɛpəˈreɪʃən əv ˈpaʊərz]", translation = "разделение властей",
            definition = "Splitting government into branches so no one part rules alone.",
            definitionNative = "Деление управления на ветви, чтобы ни одна не правила в одиночку.",
            example = "The charter respects the separation of powers between mayor and council.",
            exampleNative = "Устав уважает separation of powers между мэром и советом.",
            pos = "noun", semanticGroup = "city_governance", fillInBlankExclusions = listOf(36901L, 36902L, 36904L, 36905L)),

        WordEntity(id = 36904, setId = 369, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "procurement law", transliteration = "[prəˈkjʊrmənt lɔ]", translation = "закон о госзакупках",
            definition = "The rules a city must follow when buying goods or hiring contractors.",
            definitionNative = "Правила, по которым город закупает товары и нанимает подрядчиков.",
            example = "Procurement law forced the city to put the bridge contract out to bid.",
            exampleNative = "Procurement law обязал город провести тендер на постройку моста.",
            pos = "noun", semanticGroup = "city_governance", fillInBlankExclusions = listOf(36901L, 36902L, 36903L, 36905L, 36906L, 36909L, 36913L)),

        WordEntity(id = 36905, setId = 369, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "public-private partnership", transliteration = "[ˈpʌblɪk ˈpraɪvət ˈpɑrtnərˌʃɪp]", translation = "государственно-частное партнёрство",
            definition = "A deal where a city and a firm share costs and risks of a project.",
            definitionNative = "Соглашение, где город и фирма делят расходы и риски проекта.",
            example = "The new tram line was built through a public-private partnership.",
            exampleNative = "Новая трамвайная линия построена через public-private partnership.",
            pos = "noun", semanticGroup = "city_governance", fillInBlankExclusions = listOf(36902L, 36903L, 36904L, 36916L, 36921L)),

        // ── city_advanced_legal (5) ────────────────────────────────────────

        WordEntity(id = 36906, setId = 369, languagePair = "en-ru", rarity = "EPIC",
            original = "eminent domain", transliteration = "[ˈɛmɪnənt dəˈmeɪn]", translation = "экспроприация для общественных нужд",
            definition = "The right of the state to take private land for public use, with payment.",
            definitionNative = "Право государства забрать частную землю под общие нужды за выплату.",
            example = "Through eminent domain the city seized land for the new metro line.",
            exampleNative = "Через eminent domain город изъял землю под новую ветку метро.",
            pos = "noun", semanticGroup = "city_advanced_legal", fillInBlankExclusions = listOf(36904L, 36905L, 36907L, 36908L, 36909L, 36910L, 36913L)),

        WordEntity(id = 36907, setId = 369, languagePair = "en-ru", rarity = "EPIC",
            original = "easement", transliteration = "[ˈizmənt]", translation = "сервитут (право прохода через чужую землю)",
            definition = "A legal right to use part of someone else's land for a set purpose.",
            definitionNative = "Право пользоваться частью чужого участка для определённой цели.",
            example = "The utility company holds an easement to run cables under the yard.",
            exampleNative = "У энергетиков есть easement на прокладку кабеля под двором.",
            pos = "noun", semanticGroup = "city_advanced_legal", fillInBlankExclusions = listOf(36906L, 36908L)),

        WordEntity(id = 36908, setId = 369, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "encumbrance", transliteration = "[ɛnˈkʌmbrəns]", translation = "обременение (на недвижимость)",
            definition = "A claim or limit on a property — like a mortgage or court order.",
            definitionNative = "Притязание или ограничение на участок — ипотека, арест и подобное.",
            example = "The deed listed an old encumbrance from a forgotten lawsuit.",
            exampleNative = "В документе нашли старый encumbrance из забытого судебного дела.",
            pos = "noun", semanticGroup = "city_advanced_legal", fillInBlankExclusions = listOf(36906L, 36907L, 36909L, 36910L, 36911L)),

        WordEntity(id = 36909, setId = 369, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "home rule", transliteration = "[hoʊm rul]", translation = "право местного самоуправления",
            definition = "A city's power to write its own rules within state limits.",
            definitionNative = "Возможность города принимать свои нормы в рамках законов штата.",
            example = "Under home rule the town banned plastic bags before the state did.",
            exampleNative = "По home rule городок запретил пакеты раньше штата.",
            pos = "noun", semanticGroup = "city_advanced_legal", fillInBlankExclusions = listOf(36906L, 36907L, 36908L, 36910L, 36913L)),

        WordEntity(id = 36910, setId = 369, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "lien", transliteration = "[lin]", translation = "залоговое право (на имущество должника)",
            definition = "A creditor's right to hold property until a debt is paid.",
            definitionNative = "Право кредитора удерживать имущество до уплаты долга.",
            example = "The contractor put a lien on the house after the owner refused to pay.",
            exampleNative = "Подрядчик наложил lien на дом, когда хозяин отказался платить.",
            pos = "noun", semanticGroup = "city_advanced_legal", fillInBlankExclusions = listOf(36909L, 36921L, 36925L)),

        // ── city_admin (5) ─────────────────────────────────────────────────

        WordEntity(id = 36911, setId = 369, languagePair = "en-ru", rarity = "EPIC",
            original = "adjudication", transliteration = "[əˌʤudɪˈkeɪʃən]", translation = "вынесение решения (по делу)",
            definition = "The formal act of deciding a case or claim by a judge or board.",
            definitionNative = "Формальное завершение дела судьёй или специальной комиссией с итогом.",
            example = "The zoning dispute waited six months for adjudication by the panel.",
            exampleNative = "Спор о застройке ждал adjudication от комиссии полгода.",
            pos = "noun", semanticGroup = "city_admin", fillInBlankExclusions = listOf(36912L, 36913L, 36914L, 36915L)),

        WordEntity(id = 36912, setId = 369, languagePair = "en-ru", rarity = "EPIC",
            original = "statutory body", transliteration = "[ˈstæʧəˌtɔri ˈbɑdi]", translation = "орган, учреждённый законом",
            definition = "An office or board created and given power by an act of law.",
            definitionNative = "Учреждение, созданное законом и наделённое им полномочиями.",
            example = "The transport agency is a statutory body answering to the council.",
            exampleNative = "Транспортное агентство — statutory body, подотчётное совету.",
            pos = "noun", semanticGroup = "city_admin", fillInBlankExclusions = listOf(36905L, 36913L, 36914L)),

        WordEntity(id = 36913, setId = 369, languagePair = "en-ru", rarity = "EPIC",
            original = "regulatory framework", transliteration = "[ˈrɛɡjəˌlɛtɔri ˈfreɪmˌwɜrk]", translation = "нормативная база",
            definition = "The whole set of rules and bodies that govern a particular area.",
            definitionNative = "Совокупность правил и органов, управляющих какой-то сферой.",
            example = "Builders complained about the heavy regulatory framework around housing.",
            exampleNative = "Строители ругали тяжёлый regulatory framework вокруг жилья.",
            pos = "noun", semanticGroup = "city_admin", fillInBlankExclusions = listOf(36904L, 36911L, 36912L, 36914L, 36915L, 36922L)),

        WordEntity(id = 36914, setId = 369, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "comptroller", transliteration = "[kənˈtroʊlər]", translation = "финансовый контролёр (города)",
            definition = "A senior officer who watches over public money and audits spending.",
            definitionNative = "Высокий чиновник, следящий за казной и проверяющий траты.",
            example = "The city comptroller flagged unusual spending in the parks department.",
            exampleNative = "Городской comptroller заметил странные траты в управлении парков.",
            pos = "noun", semanticGroup = "city_admin", fillInBlankExclusions = listOf(36901L, 36911L, 36912L, 36913L, 36915L)),

        WordEntity(id = 36915, setId = 369, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "audit trail", transliteration = "[ˈɔdɪt treɪl]", translation = "контрольный след (документов)",
            definition = "A record showing who did what with money or papers, step by step.",
            definitionNative = "Запись, показывающая, кто и что делал с деньгами или бумагами.",
            example = "Every payment from the budget left a clear audit trail in the system.",
            exampleNative = "Каждый платёж из бюджета оставлял чёткий audit trail в системе.",
            pos = "noun", semanticGroup = "city_admin", fillInBlankExclusions = listOf(36911L, 36912L, 36913L, 36914L)),

        // ── city_planning_advanced (5) ─────────────────────────────────────

        WordEntity(id = 36916, setId = 369, languagePair = "en-ru", rarity = "EPIC",
            original = "transit-oriented development", transliteration = "[ˈtrænzɪt ˈɔriɛntəd dɪˈvɛləpmənt]", translation = "застройка вокруг транспортных узлов",
            definition = "Building dense housing and shops near train or bus stations on purpose.",
            definitionNative = "Плотное строительство жилья и магазинов прямо у станций транспорта.",
            example = "The new district follows transit-oriented development around the metro.",
            exampleNative = "Новый район построен по transit-oriented development вокруг метро.",
            pos = "noun", semanticGroup = "city_planning_advanced", fillInBlankExclusions = listOf(36917L, 36918L, 36919L, 36920L)),

        WordEntity(id = 36917, setId = 369, languagePair = "en-ru", rarity = "EPIC",
            original = "smart city", transliteration = "[smɑrt ˈsɪti]", translation = "умный город",
            definition = "A town that uses sensors and data to run traffic, lights and waste.",
            definitionNative = "Город, где датчики и данные управляют транспортом и освещением.",
            example = "Barcelona is often cited as a leading smart city in Europe.",
            exampleNative = "Барселону часто называют ведущим smart city в Европе.",
            pos = "noun", semanticGroup = "city_planning_advanced", fillInBlankExclusions = listOf(36916L, 36918L, 36919L, 36920L)),

        WordEntity(id = 36918, setId = 369, languagePair = "en-ru", rarity = "EPIC",
            original = "green infrastructure", transliteration = "[ɡrin ˈɪnfrəˌstrʌkʧər]", translation = "зелёная инфраструктура",
            definition = "Parks, rain gardens and wetlands that handle water and clean the air.",
            definitionNative = "Парки, дождевые сады и болотца, что чистят воздух и сток.",
            example = "The plan invests in green infrastructure to soak up storm water.",
            exampleNative = "План вкладывается в green infrastructure, чтобы впитывать ливни.",
            pos = "noun", semanticGroup = "city_planning_advanced", fillInBlankExclusions = listOf(36916L, 36917L, 36919L, 36920L)),

        WordEntity(id = 36919, setId = 369, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "walkability index", transliteration = "[ˌwɔkəˈbɪlɪti ˈɪnˌdɛks]", translation = "индекс пешеходной доступности",
            definition = "A score for how easy it is to reach shops or schools on foot.",
            definitionNative = "Оценка того, как легко дойти пешком до магазинов или школ.",
            example = "This neighborhood scores high on the walkability index for daily errands.",
            exampleNative = "У этого района высокий walkability index для повседневных дел.",
            pos = "noun", semanticGroup = "city_planning_advanced", fillInBlankExclusions = listOf(36916L, 36917L, 36918L, 36920L, 36923L)),

        WordEntity(id = 36920, setId = 369, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "place-making", transliteration = "[pleɪs ˈmeɪkɪŋ]", translation = "создание привлекательных общественных мест",
            definition = "Designing public spaces so people want to stop, sit and meet there.",
            definitionNative = "Оформление общественных пространств, чтобы там хотелось бывать.",
            example = "The plaza renewal is a classic example of place-making done right.",
            exampleNative = "Обновление площади — классический пример удачного place-making.",
            pos = "noun", semanticGroup = "city_planning_advanced", fillInBlankExclusions = listOf(36916L, 36917L, 36918L, 36919L)),

        // ── city_advanced_finance (5) ──────────────────────────────────────

        WordEntity(id = 36921, setId = 369, languagePair = "en-ru", rarity = "EPIC",
            original = "municipal bond", transliteration = "[mjuˈnɪsəpəl bɑnd]", translation = "муниципальная облигация",
            definition = "A loan from the public to a town to pay for bridges or schools.",
            definitionNative = "Заём, который жители дают городу на мосты, школы и метро.",
            example = "The town issued a municipal bond to fund the new water plant.",
            exampleNative = "Город выпустил municipal bond ради новой водоочистки.",
            pos = "noun", semanticGroup = "city_advanced_finance", fillInBlankExclusions = listOf(36922L, 36923L, 36924L, 36925L)),

        WordEntity(id = 36922, setId = 369, languagePair = "en-ru", rarity = "EPIC",
            original = "property tax assessment", transliteration = "[ˈprɑpərti tæks əˈsɛsmənt]", translation = "оценка имущества для налогообложения",
            definition = "The official estimate of a home's worth used to set its yearly tax.",
            definitionNative = "Официальный расчёт стоимости жилья для определения годового налога.",
            example = "After the property tax assessment, his bill jumped by twenty percent.",
            exampleNative = "После property tax assessment его счёт вырос на двадцать процентов.",
            pos = "noun", semanticGroup = "city_advanced_finance", fillInBlankExclusions = listOf(36921L, 36923L, 36924L, 36925L)),

        WordEntity(id = 36923, setId = 369, languagePair = "en-ru", rarity = "EPIC",
            original = "cost-of-living index", transliteration = "[kɔst əv ˈlɪvɪŋ ˈɪnˌdɛks]", translation = "индекс стоимости жизни",
            definition = "A number showing how expensive daily needs are in one place.",
            definitionNative = "Число, показывающее, насколько дорого жить в данном месте.",
            example = "The cost-of-living index ranks San Francisco far above Detroit.",
            exampleNative = "Cost-of-living index ставит Сан-Франциско намного выше Детройта.",
            pos = "noun", semanticGroup = "city_advanced_finance", fillInBlankExclusions = listOf(36919L, 36921L, 36922L, 36924L, 36925L)),

        WordEntity(id = 36924, setId = 369, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "general fund", transliteration = "[ˈʤɛnərəl fʌnd]", translation = "общий бюджетный фонд (города)",
            definition = "The main pot of money a city uses for day-to-day services.",
            definitionNative = "Главный денежный котёл города для повседневных нужд.",
            example = "Most park salaries are paid out of the city's general fund.",
            exampleNative = "Большинство зарплат в парках идёт из general fund города.",
            pos = "noun", semanticGroup = "city_advanced_finance", fillInBlankExclusions = listOf(36921L, 36922L, 36923L, 36925L)),

        WordEntity(id = 36925, setId = 369, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "levy", transliteration = "[ˈlɛvi]", translation = "сбор / налог (введённый властью)",
            definition = "A charge that an authority imposes on people to raise public money.",
            definitionNative = "Сбор, который власть налагает на людей ради общей казны.",
            example = "Voters approved a small levy to keep the public library open longer.",
            exampleNative = "Жители одобрили небольшой levy, чтобы библиотека работала дольше.",
            pos = "noun", semanticGroup = "city_advanced_finance", fillInBlankExclusions = listOf(36921L, 36922L, 36923L, 36924L)),
    )
}
