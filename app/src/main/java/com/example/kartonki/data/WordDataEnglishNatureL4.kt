package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Природа и экология (level 4, профессиональный).
 *
 * Set 332: «Природа и экология» — профессиональная экологическая
 * и природоведческая терминология (L4 / RARE+EPIC, преобладает EPIC).
 *
 * Дополняет уже существующие сеты темы «Природа и экология»:
 *   - Set 281 (WordDataEnglishBatch12.kt)    — L1 COMMON/UNCOMMON (sky, sand, jungle…).
 *   - Set 232 (WordDataEnglishExpanded.kt)   — L2 (copse, fjord, tundra…).
 *   - Set 233 (WordDataEnglishExpanded.kt)   — L3 (canopy, symbiosis, ecotone…).
 *
 * Слова setId=332 не пересекаются ни с одним из перечисленных setId
 * (а также с set 49 environment_ecology в WordDataEnglish.kt — проверено grep).
 *
 * Распределение редкости: 8 RARE + 17 EPIC — два смежных уровня шкалы.
 *
 * SemanticGroups (5 × 5):
 *   nature_biomes       — biome, watershed, biosphere, hydrosphere, peatland
 *   nature_evolution    — speciation, refugia, phenology, biota, fauna
 *   nature_processes    — bioaccumulation, eutrophication, sequestration, acidification, salinization
 *   nature_conservation — stewardship, preservation, remediation, restoration, afforestation
 *   nature_diversity    — invasive, threatened, extirpated, fragmented, pristine
 *
 * Word IDs: 33201..33225 (setId × 100 + position).
 */
object WordDataEnglishNatureL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 332, name = "Природа и экология",
            description = "Профессиональная экологическая и природоведческая терминология: биомы, эволюция, охрана природы",
            languagePair = "en-ru",
            topic = "Природа и экология", level = 4),
    )

    val words: List<WordEntity> = listOf(

        // ── nature_biomes (5) ─────────────────────────────────────────────

        WordEntity(id = 33201, setId = 332, languagePair = "en-ru", rarity = "RARE",
            original = "biome", transliteration = "[ˈbaɪoʊm]", translation = "биом (крупная природная зона)",
            definition = "A large region of the planet defined by its climate, plants and animals.",
            definitionNative = "Крупный участок планеты, определяемый климатом, растениями и животными.",
            example = "The boreal biome stretches across northern Russia and Canada in dense forests.",
            exampleNative = "Бореальный biome тянется по северу России и Канады густыми лесами.",
            pos = "noun", semanticGroup = "nature_biomes",
            fillInBlankExclusions = listOf(33202L, 33203L, 33204L, 33205L)),

        WordEntity(id = 33202, setId = 332, languagePair = "en-ru", rarity = "RARE",
            original = "watershed", transliteration = "[ˈwɔtərˌʃɛd]", translation = "водосборный бассейн",
            definition = "An area of land where every stream and river drains into the same body of water.",
            definitionNative = "Территория, с которой все ручьи и реки стекают в один общий водоём.",
            example = "Logging upstream polluted the entire watershed with mud and sawdust.",
            exampleNative = "Вырубка выше по течению загрязнила весь watershed грязью и опилками.",
            pos = "noun", semanticGroup = "nature_biomes",
            fillInBlankExclusions = listOf(33201L, 33203L, 33204L, 33205L)),

        WordEntity(id = 33203, setId = 332, languagePair = "en-ru", rarity = "EPIC",
            original = "biosphere", transliteration = "[ˈbaɪəˌsfɪr]", translation = "биосфера (область жизни на Земле)",
            definition = "The thin shell of the planet where all living creatures exist together.",
            definitionNative = "Тонкая оболочка планеты, где совместно существуют все живые организмы.",
            example = "Plastic waste now reaches every corner of the global biosphere.",
            exampleNative = "Пластиковый мусор сегодня достигает любого уголка глобальной biosphere.",
            pos = "noun", semanticGroup = "nature_biomes",
            fillInBlankExclusions = listOf(33201L, 33202L, 33204L, 33205L)),

        WordEntity(id = 33204, setId = 332, languagePair = "en-ru", rarity = "EPIC",
            original = "hydrosphere", transliteration = "[ˈhaɪdrəˌsfɪr]", translation = "гидросфера (вся вода Земли)",
            definition = "All the water on Earth — oceans, rivers, lakes, ice and underground reserves together.",
            definitionNative = "Вся вода Земли — океаны, реки, озёра, лёд и подземные запасы вместе.",
            example = "Oceans hold most of the hydrosphere's salt and frozen volumes.",
            exampleNative = "Океаны вмещают большую часть солёных и замёрзших объёмов hydrosphere.",
            pos = "noun", semanticGroup = "nature_biomes",
            fillInBlankExclusions = listOf(33201L, 33202L, 33203L, 33205L)),

        WordEntity(id = 33205, setId = 332, languagePair = "en-ru", rarity = "EPIC",
            original = "peatland", transliteration = "[ˈpitlænd]", translation = "торфяник / торфяное болото",
            definition = "A wet, spongy area where dead plants pile up and slowly turn into thick fuel.",
            definitionNative = "Влажная мшистая местность, где мёртвые растения слой за слоем превращаются в плотное топливо.",
            example = "Drained peatland releases enormous quantities of stored carbon into the air.",
            exampleNative = "Осушённый peatland выбрасывает в воздух огромные запасы углерода.",
            pos = "noun", semanticGroup = "nature_biomes",
            fillInBlankExclusions = listOf(33201L, 33202L, 33203L, 33204L)),

        // ── nature_evolution (5) ──────────────────────────────────────────

        WordEntity(id = 33206, setId = 332, languagePair = "en-ru", rarity = "EPIC",
            original = "speciation", transliteration = "[ˌspiʃiˈeɪʃən]", translation = "видообразование",
            definition = "The slow biological process by which one population splits into two distinct species.",
            definitionNative = "Медленный биологический процесс, при котором одна популяция делится на два разных вида.",
            example = "Isolated islands often drive rapid speciation among finches and lizards.",
            exampleNative = "Изолированные острова часто ускоряют speciation у вьюрков и ящериц.",
            pos = "noun", semanticGroup = "nature_evolution",
            fillInBlankExclusions = listOf(33207L, 33208L, 33209L, 33210L)),

        WordEntity(id = 33207, setId = 332, languagePair = "en-ru", rarity = "EPIC",
            original = "refugia", transliteration = "[rɪˈfjuʤiə]", translation = "рефугиумы (убежища выживания)",
            definition = "Small surviving habitats where rare species hold out during ice ages or droughts.",
            definitionNative = "Небольшие сохранившиеся участки, где редкие виды пережидают ледники или засухи.",
            example = "Mountain refugia let several rare orchids survive the last glacial period.",
            exampleNative = "Горные refugia позволили нескольким редким орхидеям пережить последний ледниковый период.",
            pos = "noun", semanticGroup = "nature_evolution",
            fillInBlankExclusions = listOf(33206L, 33208L, 33209L, 33210L)),

        WordEntity(id = 33208, setId = 332, languagePair = "en-ru", rarity = "EPIC",
            original = "phenology", transliteration = "[fɪˈnɑləʤi]", translation = "фенология (наука о сезонных явлениях)",
            definition = "The study of how plants and animals time their seasonal events year after year.",
            definitionNative = "Изучение того, как растения и животные выстраивают сезонные явления из года в год.",
            example = "Warmer springs are rewriting the phenology of bees and the flowers they visit.",
            exampleNative = "Тёплые вёсны переписывают phenology пчёл и цветов, которые они опыляют.",
            pos = "noun", semanticGroup = "nature_evolution",
            fillInBlankExclusions = listOf(33206L, 33207L, 33209L, 33210L)),

        WordEntity(id = 33209, setId = 332, languagePair = "en-ru", rarity = "EPIC",
            original = "biota", transliteration = "[baɪˈoʊtə]", translation = "биота (флора и фауна региона)",
            definition = "The full collection of plants, animals and microbes living in one specific area.",
            definitionNative = "Полная совокупность растений, животных и микробов, обитающих в одной конкретной местности.",
            example = "Researchers catalogued the unique biota of the deep cave for the first time.",
            exampleNative = "Исследователи впервые описали уникальную biota глубокой пещеры.",
            pos = "noun", semanticGroup = "nature_evolution",
            fillInBlankExclusions = listOf(33206L, 33207L, 33208L, 33210L)),

        WordEntity(id = 33210, setId = 332, languagePair = "en-ru", rarity = "RARE",
            original = "fauna", transliteration = "[ˈfɔnə]", translation = "фауна (животный мир региона)",
            definition = "All the animal life of a particular region, period or environment.",
            definitionNative = "Совокупность всех животных конкретного региона, эпохи или среды.",
            example = "The island fauna includes several reptiles found nowhere else on Earth.",
            exampleNative = "Островная fauna включает несколько рептилий, не встречающихся больше нигде.",
            pos = "noun", semanticGroup = "nature_evolution",
            fillInBlankExclusions = listOf(33206L, 33207L, 33208L, 33209L)),

        // ── nature_processes (5) ──────────────────────────────────────────

        WordEntity(id = 33211, setId = 332, languagePair = "en-ru", rarity = "EPIC",
            original = "bioaccumulation", transliteration = "[ˌbaɪoʊəˌkjumjəˈleɪʃən]", translation = "биоаккумуляция (накопление токсинов в организме)",
            definition = "The slow build-up of toxic chemicals inside an animal as it eats contaminated prey.",
            definitionNative = "Медленное накопление токсинов в организме животного при поедании заражённой добычи.",
            example = "Mercury bioaccumulation makes large old tuna risky for pregnant women to eat.",
            exampleNative = "Ртутная bioaccumulation делает крупного старого тунца опасным для беременных.",
            pos = "noun", semanticGroup = "nature_processes",
            fillInBlankExclusions = listOf(33212L, 33213L, 33214L, 33215L)),

        WordEntity(id = 33212, setId = 332, languagePair = "en-ru", rarity = "EPIC",
            original = "eutrophication", transliteration = "[juːˌtroʊfɪˈkeɪʃən]", translation = "эвтрофикация (чрезмерное цветение водоёма)",
            definition = "When too many nutrients enter a lake, algae bloom and most fish suffocate.",
            definitionNative = "Когда в озеро попадает избыток питательных веществ, водоросли разрастаются и рыба задыхается.",
            example = "Fertilizer runoff caused severe eutrophication in the bay last summer.",
            exampleNative = "Стоки удобрений вызвали тяжёлую eutrophication в заливе прошлым летом.",
            pos = "noun", semanticGroup = "nature_processes",
            fillInBlankExclusions = listOf(33211L, 33213L, 33214L, 33215L)),

        WordEntity(id = 33213, setId = 332, languagePair = "en-ru", rarity = "EPIC",
            original = "sequestration", transliteration = "[ˌsiːkwɪˈstreɪʃən]", translation = "связывание / поглощение (углерода)",
            definition = "The capture and long-term storage of carbon dioxide in trees, soil or rocks.",
            definitionNative = "Захват и длительное хранение углекислого газа в деревьях, почве или горных породах.",
            example = "Old-growth forests are champions of natural carbon sequestration.",
            exampleNative = "Старовозрастные леса — чемпионы природного углеродного sequestration.",
            pos = "noun", semanticGroup = "nature_processes",
            fillInBlankExclusions = listOf(33211L, 33212L, 33214L, 33215L)),

        WordEntity(id = 33214, setId = 332, languagePair = "en-ru", rarity = "EPIC",
            original = "acidification", transliteration = "[əˌsɪdɪfɪˈkeɪʃən]", translation = "подкисление (океана, почвы)",
            definition = "The drop in water or soil pH that harms shells, coral and many tiny creatures.",
            definitionNative = "Снижение pH воды или почвы, которое вредит ракушкам, кораллам и мелким организмам.",
            example = "Ocean acidification is dissolving the thin shells of plankton across the Pacific.",
            exampleNative = "Океанический acidification растворяет тонкие раковины планктона по всему Тихому океану.",
            pos = "noun", semanticGroup = "nature_processes",
            fillInBlankExclusions = listOf(33211L, 33212L, 33213L, 33215L)),

        WordEntity(id = 33215, setId = 332, languagePair = "en-ru", rarity = "EPIC",
            original = "salinization", transliteration = "[ˌsælɪnɪˈzeɪʃən]", translation = "засоление (почвы или воды)",
            definition = "The harmful build-up of salt in soil that ruins fields for future crops.",
            definitionNative = "Вредное накопление соли в почве, делающее поля непригодными для будущих посевов.",
            example = "Heavy irrigation in dry valleys often leads to soil salinization within decades.",
            exampleNative = "Обильный полив в сухих долинах за десятилетия вызывает почвенную salinization.",
            pos = "noun", semanticGroup = "nature_processes",
            fillInBlankExclusions = listOf(33211L, 33212L, 33213L, 33214L)),

        // ── nature_conservation (5) ───────────────────────────────────────

        WordEntity(id = 33216, setId = 332, languagePair = "en-ru", rarity = "EPIC",
            original = "stewardship", transliteration = "[ˈstuərdʃɪp]", translation = "ответственное управление (природой)",
            definition = "The careful, responsible looking-after of land and natural resources for the future.",
            definitionNative = "Бережное и ответственное распоряжение землёй и природными ресурсами ради будущих поколений.",
            example = "Indigenous stewardship has kept the river basin healthy for many centuries.",
            exampleNative = "Местное stewardship веками поддерживало здоровье речного бассейна.",
            pos = "noun", semanticGroup = "nature_conservation",
            fillInBlankExclusions = listOf(33217L, 33218L, 33219L, 33220L)),

        WordEntity(id = 33217, setId = 332, languagePair = "en-ru", rarity = "RARE",
            original = "preservation", transliteration = "[ˌprɛzərˈveɪʃən]", translation = "сохранение (в нетронутом виде)",
            definition = "Keeping a place exactly as it is, without letting people use or change it.",
            definitionNative = "Сохранение места ровно таким, какое оно есть, без человеческого использования или изменения.",
            example = "Strict preservation of the old-growth forest leaves it untouched by loggers.",
            exampleNative = "Строгая preservation старого леса оставляет его нетронутым лесорубами.",
            pos = "noun", semanticGroup = "nature_conservation",
            fillInBlankExclusions = listOf(33216L, 33218L, 33219L, 33220L)),

        WordEntity(id = 33218, setId = 332, languagePair = "en-ru", rarity = "EPIC",
            original = "remediation", transliteration = "[rɪˌmiːdiˈeɪʃən]", translation = "очистка / устранение загрязнения",
            definition = "The process of cleaning up polluted soil, water or air to make it safe again.",
            definitionNative = "Процесс очистки заражённой почвы, воды или воздуха для возврата к безопасности.",
            example = "Bacterial remediation slowly digested the oil spill in the contaminated bay.",
            exampleNative = "Бактериальная remediation постепенно переработала разлив нефти в заражённом заливе.",
            pos = "noun", semanticGroup = "nature_conservation",
            fillInBlankExclusions = listOf(33216L, 33217L, 33219L, 33220L)),

        WordEntity(id = 33219, setId = 332, languagePair = "en-ru", rarity = "RARE",
            original = "restoration", transliteration = "[ˌrɛstəˈreɪʃən]", translation = "восстановление (экосистемы)",
            definition = "Bringing a damaged ecosystem back to its earlier healthy condition.",
            definitionNative = "Возвращение повреждённой экосистемы к прежнему здоровому состоянию.",
            example = "Wetland restoration brought herons and frogs back to the polluted marsh.",
            exampleNative = "Restoration водно-болотных угодий вернула цапель и лягушек на загрязнённое болото.",
            pos = "noun", semanticGroup = "nature_conservation",
            fillInBlankExclusions = listOf(33216L, 33217L, 33218L, 33220L)),

        WordEntity(id = 33220, setId = 332, languagePair = "en-ru", rarity = "EPIC",
            original = "afforestation", transliteration = "[əˌfɔrəˈsteɪʃən]", translation = "облесение (создание леса на пустыре)",
            definition = "Planting a brand-new forest on land that has had no trees for a long time.",
            definitionNative = "Посадка нового леса на участке, который долгое время был лишён деревьев.",
            example = "A massive afforestation programme turned the dusty steppe into shaded groves.",
            exampleNative = "Массовая afforestation превратила пыльную степь в тенистые рощи.",
            pos = "noun", semanticGroup = "nature_conservation",
            fillInBlankExclusions = listOf(33216L, 33217L, 33218L, 33219L)),

        // ── nature_diversity (5) ──────────────────────────────────────────

        WordEntity(id = 33221, setId = 332, languagePair = "en-ru", rarity = "RARE",
            original = "invasive", transliteration = "[ɪnˈveɪsɪv]", translation = "инвазивный (вид-вселенец)",
            definition = "Brought from far away and spreading aggressively, pushing out the local species.",
            definitionNative = "Завезённый издалека и агрессивно распространяющийся, вытесняющий местные виды.",
            example = "An invasive vine is choking the native trees along the entire river bank.",
            exampleNative = "Invasive лиана душит местные деревья вдоль всего речного берега.",
            pos = "adjective", semanticGroup = "nature_diversity",
            fillInBlankExclusions = listOf(33222L, 33223L, 33224L, 33225L)),

        WordEntity(id = 33222, setId = 332, languagePair = "en-ru", rarity = "RARE",
            original = "threatened", transliteration = "[ˈθrɛtənd]", translation = "находящийся под угрозой (вид)",
            definition = "Likely to become endangered soon if the present harm to the species continues.",
            definitionNative = "Вид, который скоро попадёт в Красную книгу, если нынешний вред не прекратится.",
            example = "The threatened salamander now breeds in only three small mountain ponds.",
            exampleNative = "Threatened саламандра размножается лишь в трёх крошечных горных прудах.",
            pos = "adjective", semanticGroup = "nature_diversity",
            fillInBlankExclusions = listOf(33221L, 33223L, 33224L, 33225L)),

        WordEntity(id = 33223, setId = 332, languagePair = "en-ru", rarity = "EPIC",
            original = "extirpated", transliteration = "[ˈɛkstərˌpeɪtɪd]", translation = "истреблённый (на конкретной территории)",
            definition = "Wiped out completely from one specific area, though still alive elsewhere.",
            definitionNative = "Полностью уничтоженный в конкретной местности, хотя где-то ещё сохранился.",
            example = "Wolves were extirpated from the British Isles by the seventeenth century.",
            exampleNative = "Волки были extirpated с Британских островов к семнадцатому веку.",
            pos = "adjective", semanticGroup = "nature_diversity",
            fillInBlankExclusions = listOf(33221L, 33222L, 33224L, 33225L)),

        WordEntity(id = 33224, setId = 332, languagePair = "en-ru", rarity = "RARE",
            original = "fragmented", transliteration = "[ˈfræɡməntɪd]", translation = "раздроблённый (о среде обитания)",
            definition = "Broken into small isolated patches by roads, fields or human settlements.",
            definitionNative = "Разбитый дорогами, полями или поселениями человека на мелкие изолированные участки.",
            example = "Fragmented forest patches make it hard for tigers to find new mates.",
            exampleNative = "Fragmented лесные островки мешают тиграм находить новых партнёров.",
            pos = "adjective", semanticGroup = "nature_diversity",
            fillInBlankExclusions = listOf(33221L, 33222L, 33223L, 33225L)),

        WordEntity(id = 33225, setId = 332, languagePair = "en-ru", rarity = "EPIC",
            original = "pristine", transliteration = "[prɪsˈtin]", translation = "первозданный / нетронутый",
            definition = "Still in its original natural state, never spoiled by human activity.",
            definitionNative = "Сохранившийся в исходном природном виде, не испорченный человеком.",
            example = "Divers explored a pristine reef where coral has grown for centuries undisturbed.",
            exampleNative = "Дайверы исследовали pristine риф, где кораллы росли веками без помех.",
            pos = "adjective", semanticGroup = "nature_diversity",
            fillInBlankExclusions = listOf(33221L, 33222L, 33223L, 33224L)),
    )
}
