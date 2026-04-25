package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Еда и кулинария (level 4, профессиональный).
 *
 * Set 319: «Еда и кулинария: профессиональный» — кухонная терминология
 * шеф-поваров: техники, разделка, инструменты, концепты вкуса и подача.
 *
 * Распределение редкости: 10 RARE + 15 EPIC — два смежных уровня шкалы.
 *   RARE  (10): sear, infuse, fillet, mince, cleaver, sieve, skillet,
 *               drizzle, sprinkle, skim
 *   EPIC  (15): clarify, temper, parboil, dredge, debone, spatchcock,
 *               mandoline, ramekin, aspic, doneness, consommé, roux,
 *               velouté, dollop, decant
 *
 * Дополняет уже существующие сеты темы «Еда и кулинария»:
 *   - Set 207 (WordDataEnglishExpanded.kt) — L3 готовка/кухня (RARE).
 *   - Set 230 (WordDataEnglishExpanded.kt) — L2 специи и приправы (COMMON/UNCOMMON).
 *   - Set 231 (WordDataEnglishExpanded.kt) — L4 шеф-лексика (RARE/EPIC).
 *   - Set 262 (WordDataEnglishBatch7.kt)   — L1-L2 фрукты (COMMON/UNCOMMON).
 *
 * Слова setId=319 не пересекаются ни с одним из этих наборов (проверено grep
 * по полю original; однокоренные внутри темы тоже отсеяны).
 *
 * SemanticGroups (5 × 5):
 *   food_techniques  — sear, infuse, clarify, temper, parboil
 *   food_cuts        — fillet, mince, dredge, debone, spatchcock
 *   food_tools       — cleaver, sieve, skillet, mandoline, ramekin
 *   food_concepts    — aspic, doneness, consommé, roux, velouté
 *   food_finishing   — drizzle, sprinkle, skim, dollop, decant
 *
 * Word IDs: 31901..31925 (setId × 100 + position).
 */
object WordDataEnglishFoodL4 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 319, name = "Еда и кулинария",
            description = "Профессиональная кулинарная терминология: техники, инструменты, кухонный жаргон",
            languagePair = "en-ru",
            orderIndex = 139,
            topic = "Еда и кулинария", level = 4),
    )

    val words: List<WordEntity> = listOf(

        // ── food_techniques (5) ───────────────────────────────────────────

        WordEntity(id = 31901, setId = 319, languagePair = "en-ru", rarity = "RARE",
            original = "sear", transliteration = "[sɪr]", translation = "обжаривать на сильном огне (для корочки)",
            definition = "To brown the surface of meat quickly over very high heat for crust.",
            definitionNative = "Быстро подрумянить поверхность мяса на сильном огне ради корочки.",
            example = "The chef will sear the steak before finishing it gently in the oven.",
            exampleNative = "Шеф собирается sear стейк, а затем мягко доводить его в духовке.",
            pos = "verb", semanticGroup = "food_techniques", fillInBlankExclusions = listOf(31902L, 31903L, 31904L, 31905L)),

        WordEntity(id = 31902, setId = 319, languagePair = "en-ru", rarity = "RARE",
            original = "infuse", transliteration = "[ɪnˈfjuz]", translation = "настаивать (для аромата)",
            definition = "To soak a flavour or herb in liquid so the taste passes into it.",
            definitionNative = "Дать аромату или травам перейти в жидкость, выдержав их вместе.",
            example = "Let the basil infuse the warm olive oil for an hour before straining.",
            exampleNative = "Дай базилику infuse тёплое оливковое масло час перед процеживанием.",
            pos = "verb", semanticGroup = "food_techniques", fillInBlankExclusions = listOf(31901L, 31903L, 31904L, 31905L)),

        WordEntity(id = 31903, setId = 319, languagePair = "en-ru", rarity = "EPIC",
            original = "clarify", transliteration = "[ˈklɛrəˌfaɪ]", translation = "осветлить (бульон/масло)",
            definition = "To make a liquid clear by skimming and straining off all small particles.",
            definitionNative = "Сделать жидкость прозрачной — снять и процедить все мелкие частицы.",
            example = "Clarify the broth with egg whites until it gleams a clean amber colour.",
            exampleNative = "Clarify бульон с яичными белками, пока он не засияет чистым янтарём.",
            pos = "verb", semanticGroup = "food_techniques", fillInBlankExclusions = listOf(31901L, 31902L, 31904L, 31905L)),

        WordEntity(id = 31904, setId = 319, languagePair = "en-ru", rarity = "EPIC",
            original = "temper", transliteration = "[ˈtɛmpər]", translation = "темперировать (стабилизировать структуру)",
            definition = "To heat and cool chocolate carefully so it sets shiny and snappy.",
            definitionNative = "Аккуратно нагреть и охладить шоколад, чтобы он застыл блестящим и хрустящим.",
            example = "You must temper the chocolate before pouring it over the dessert.",
            exampleNative = "Нужно temper шоколад до того, как лить его на десерт.",
            pos = "verb", semanticGroup = "food_techniques", fillInBlankExclusions = listOf(31901L, 31902L, 31903L, 31905L)),

        WordEntity(id = 31905, setId = 319, languagePair = "en-ru", rarity = "EPIC",
            original = "parboil", transliteration = "[ˈpɑrˌbɔɪl]", translation = "отварить до полуготовности",
            definition = "To cook food briefly in boiling water before finishing it another way.",
            definitionNative = "Коротко проварить продукт в кипятке, чтобы потом доготовить иначе.",
            example = "Parboil the potatoes for five minutes, then roast them with rosemary.",
            exampleNative = "Parboil картофель пять минут и потом запеки его с розмарином.",
            pos = "verb", semanticGroup = "food_techniques", fillInBlankExclusions = listOf(31901L, 31902L, 31903L, 31904L)),

        // ── food_cuts (5) ─────────────────────────────────────────────────

        WordEntity(id = 31906, setId = 319, languagePair = "en-ru", rarity = "RARE",
            original = "fillet", transliteration = "[ˈfɪlɪt]", translation = "разделать на филе",
            definition = "To cut the soft flesh away from the bones of fish or meat.",
            definitionNative = "Срезать мягкую мякоть с костей рыбы или мяса.",
            example = "He learned to fillet a salmon cleanly during his first week of training.",
            exampleNative = "Он научился fillet лосося чисто на первой неделе обучения.",
            pos = "verb", semanticGroup = "food_cuts", fillInBlankExclusions = listOf(31907L, 31908L, 31909L, 31910L)),

        WordEntity(id = 31907, setId = 319, languagePair = "en-ru", rarity = "RARE",
            original = "mince", transliteration = "[mɪns]", translation = "очень мелко рубить ножом",
            definition = "To chop food into tiny pieces, smaller than a regular dice.",
            definitionNative = "Нарубить продукт на крошечные кусочки, мельче обычных кубиков.",
            example = "Mince the garlic finely and add it to the pan with the butter.",
            exampleNative = "Mince чеснок очень мелко и добавь его на сковороду с маслом.",
            pos = "verb", semanticGroup = "food_cuts", fillInBlankExclusions = listOf(31906L, 31908L, 31909L, 31910L)),

        WordEntity(id = 31908, setId = 319, languagePair = "en-ru", rarity = "EPIC",
            original = "dredge", transliteration = "[drɛʤ]", translation = "обвалять в муке (для жарки)",
            definition = "To coat food lightly with flour or breadcrumbs before frying it.",
            definitionNative = "Слегка покрыть продукт мукой или панировкой перед жаркой.",
            example = "Dredge the chicken pieces in seasoned flour before lowering them into oil.",
            exampleNative = "Dredge кусочки курицы в приправленной муке и опусти их в масло.",
            pos = "verb", semanticGroup = "food_cuts", fillInBlankExclusions = listOf(31906L, 31907L, 31909L, 31910L)),

        WordEntity(id = 31909, setId = 319, languagePair = "en-ru", rarity = "EPIC",
            original = "debone", transliteration = "[diˈboʊn]", translation = "удалить кости из мяса/рыбы",
            definition = "To take all the bones out of meat or fish before cooking.",
            definitionNative = "Аккуратно вынуть все кости из мяса или рыбы до начала готовки.",
            example = "Ask the butcher to debone the chicken thighs for tonight's dinner.",
            exampleNative = "Попроси мясника debone куриные бёдрышки для сегодняшнего ужина.",
            pos = "verb", semanticGroup = "food_cuts", fillInBlankExclusions = listOf(31906L, 31907L, 31908L, 31910L)),

        WordEntity(id = 31910, setId = 319, languagePair = "en-ru", rarity = "EPIC",
            original = "spatchcock", transliteration = "[ˈspæʧˌkɑk]", translation = "распластать птицу для жарки",
            definition = "To split a whole bird along the back and flatten it for fast roasting.",
            definitionNative = "Разрезать тушку птицы по спине и сплющить её для быстрого запекания.",
            example = "Spatchcock the chicken so it cooks evenly under the hot grill.",
            exampleNative = "Spatchcock курицу, чтобы она готовилась равномерно под горячим грилем.",
            pos = "verb", semanticGroup = "food_cuts", fillInBlankExclusions = listOf(31905L, 31906L, 31907L, 31908L, 31909L)),

        // ── food_tools (5) ────────────────────────────────────────────────

        WordEntity(id = 31911, setId = 319, languagePair = "en-ru", rarity = "RARE",
            original = "cleaver", transliteration = "[ˈklivər]", translation = "тяжёлый нож-секач",
            definition = "A heavy square knife used to chop through bones and tough meat.",
            definitionNative = "Тяжёлый прямоугольный нож, которым рубят кости и плотное мясо.",
            example = "The butcher swung his cleaver and split the rack of ribs in two.",
            exampleNative = "Мясник взмахнул cleaver и разрубил рёбра пополам.",
            pos = "noun", semanticGroup = "food_tools", fillInBlankExclusions = listOf(31912L, 31913L, 31914L, 31915L)),

        WordEntity(id = 31912, setId = 319, languagePair = "en-ru", rarity = "RARE",
            original = "sieve", transliteration = "[sɪv]", translation = "сито для процеживания",
            definition = "A bowl with a mesh bottom that lets liquid pass but holds solids.",
            definitionNative = "Чаша с сетчатым дном — пропускает жидкость, задерживает твёрдое.",
            example = "Pour the sauce through a fine sieve to remove all the herb stems.",
            exampleNative = "Перелей соус через мелкий sieve, чтобы убрать стебли трав.",
            pos = "noun", semanticGroup = "food_tools", fillInBlankExclusions = listOf(31911L, 31913L, 31914L, 31915L)),

        WordEntity(id = 31913, setId = 319, languagePair = "en-ru", rarity = "RARE",
            original = "skillet", transliteration = "[ˈskɪlɪt]", translation = "чугунная сковорода с ручкой",
            definition = "A heavy iron pan with sloped sides used for frying over high heat.",
            definitionNative = "Тяжёлая железная сковорода со скошенными бортиками для жарки на сильном огне.",
            example = "Heat the cast-iron skillet until a drop of water dances on the surface.",
            exampleNative = "Грей чугунный skillet, пока капля воды не начнёт скакать по дну.",
            pos = "noun", semanticGroup = "food_tools", fillInBlankExclusions = listOf(31911L, 31912L, 31914L, 31915L)),

        WordEntity(id = 31914, setId = 319, languagePair = "en-ru", rarity = "EPIC",
            original = "mandoline", transliteration = "[ˌmændəˈlɪn]", translation = "ручной слайсер для тонкой нарезки",
            definition = "A flat tool with a sharp blade for slicing vegetables very thinly.",
            definitionNative = "Плоский инструмент с острым лезвием — режет овощи очень тонкими ломтиками.",
            example = "Use a mandoline to shave the radishes into paper-thin slices.",
            exampleNative = "Возьми mandoline и настругай редис тонкими, как бумага, ломтиками.",
            pos = "noun", semanticGroup = "food_tools", fillInBlankExclusions = listOf(31911L, 31912L, 31913L, 31915L)),

        WordEntity(id = 31915, setId = 319, languagePair = "en-ru", rarity = "EPIC",
            original = "ramekin", transliteration = "[ˈræmɪkɪn]", translation = "порционная керамическая форма",
            definition = "A small round ceramic dish used for baking individual servings.",
            definitionNative = "Маленькая круглая керамическая формочка для запекания одной порции.",
            example = "Pour the custard into each ramekin and place them in a water bath.",
            exampleNative = "Разлей крем в каждый ramekin и поставь их на водяную баню.",
            pos = "noun", semanticGroup = "food_tools", fillInBlankExclusions = listOf(31911L, 31912L, 31913L, 31914L)),

        // ── food_concepts (5) ─────────────────────────────────────────────

        WordEntity(id = 31916, setId = 319, languagePair = "en-ru", rarity = "EPIC",
            original = "aspic", transliteration = "[ˈæspɪk]", translation = "заливное (бульон, застывший в желе)",
            definition = "A clear savoury jelly made from bone broth that sets around cold meats.",
            definitionNative = "Прозрачное мясное желе из костного бульона — застывает вокруг холодного мяса.",
            example = "The chef set the poached salmon in a glassy lemon aspic for the buffet.",
            exampleNative = "Шеф залил отварного лосося прозрачным лимонным aspic для фуршета.",
            pos = "noun", semanticGroup = "food_concepts", fillInBlankExclusions = listOf(31917L, 31918L, 31919L, 31920L)),

        WordEntity(id = 31917, setId = 319, languagePair = "en-ru", rarity = "EPIC",
            original = "doneness", transliteration = "[ˈdənnəs]", translation = "степень прожарки/готовности",
            definition = "How far food is cooked, from rare and pink to fully cooked through.",
            definitionNative = "Насколько продукт проготовлен — от сырого с розовым центром до полного.",
            example = "Press the steak with your finger to check the doneness without cutting it.",
            exampleNative = "Надави на стейк пальцем, чтобы проверить doneness, не разрезая его.",
            pos = "noun", semanticGroup = "food_concepts", fillInBlankExclusions = listOf(31916L, 31918L, 31919L, 31920L)),

        WordEntity(id = 31918, setId = 319, languagePair = "en-ru", rarity = "EPIC",
            original = "consommé", transliteration = "[ˌkɑnsəˈmeɪ]", translation = "осветлённый прозрачный бульон",
            definition = "A clear soup made by simmering meat with egg whites that catch the cloudy bits.",
            definitionNative = "Прозрачный суп: мясо томят с яичными белками, и они вытягивают всю муть.",
            example = "A bowl of golden consommé opened the formal dinner at the embassy.",
            exampleNative = "Тарелка золотистого consommé открыла торжественный ужин в посольстве.",
            pos = "noun", semanticGroup = "food_concepts", fillInBlankExclusions = listOf(31916L, 31917L, 31919L, 31920L)),

        WordEntity(id = 31919, setId = 319, languagePair = "en-ru", rarity = "EPIC",
            original = "roux", transliteration = "[ru]", translation = "ру (мука с маслом — основа соусов)",
            definition = "Flour cooked in fat that forms the base for many thick sauces.",
            definitionNative = "Мука, проваренная в жире — основа многих густых соусов.",
            example = "Stir the flour into the melted butter to make a smooth blond roux.",
            exampleNative = "Вмешай муку в растопленное масло, чтобы получить гладкий светлый roux.",
            pos = "noun", semanticGroup = "food_concepts", fillInBlankExclusions = listOf(31916L, 31917L, 31918L, 31920L)),

        WordEntity(id = 31920, setId = 319, languagePair = "en-ru", rarity = "EPIC",
            original = "velouté", transliteration = "[vəˈluteɪ]", translation = "соус велюте (на белом ру и светлом бульоне)",
            definition = "A smooth white sauce made from a blond roux and a light broth.",
            definitionNative = "Гладкий белый соус из светлого ру и нежного прозрачного бульона.",
            example = "She finished the chicken with a silky velouté and chopped tarragon.",
            exampleNative = "Она довела курицу шелковистым velouté с рубленым эстрагоном.",
            pos = "noun", semanticGroup = "food_concepts", fillInBlankExclusions = listOf(31916L, 31917L, 31918L, 31919L)),

        // ── food_finishing (5) ────────────────────────────────────────────

        WordEntity(id = 31921, setId = 319, languagePair = "en-ru", rarity = "RARE",
            original = "drizzle", transliteration = "[ˈdrɪzəl]", translation = "тонкой струйкой полить сверху",
            definition = "To pour a liquid in a thin slow stream over a finished dish.",
            definitionNative = "Лить жидкость тонкой медленной струйкой поверх готового блюда.",
            example = "Drizzle a little olive oil over the warm tomatoes just before serving.",
            exampleNative = "Drizzle немного оливкового масла на тёплые помидоры перед подачей.",
            pos = "verb", semanticGroup = "food_finishing", fillInBlankExclusions = listOf(31922L, 31923L, 31925L)),

        WordEntity(id = 31922, setId = 319, languagePair = "en-ru", rarity = "RARE",
            original = "sprinkle", transliteration = "[ˈsprɪŋkəl]", translation = "посыпать сверху небольшим количеством",
            definition = "To scatter a small amount of something lightly over a dish.",
            definitionNative = "Рассыпать немного чего-то лёгким движением сверху по блюду.",
            example = "Sprinkle a bit of sea salt over the tomato slices just before serving.",
            exampleNative = "Sprinkle немного морской соли на ломтики помидора прямо перед подачей.",
            pos = "verb", semanticGroup = "food_finishing", fillInBlankExclusions = listOf(31921L, 31923L, 31925L)),

        WordEntity(id = 31923, setId = 319, languagePair = "en-ru", rarity = "RARE",
            original = "skim", transliteration = "[skɪm]", translation = "снимать пену/жир с поверхности",
            definition = "To lift foam or fat off the top of a hot liquid with a spoon.",
            definitionNative = "Ложкой снять с поверхности горячей жидкости пену или жир.",
            example = "Skim the foam from the top of the simmering broth every few minutes.",
            exampleNative = "Skim пену с поверхности тихо кипящего бульона каждые несколько минут.",
            pos = "verb", semanticGroup = "food_finishing", fillInBlankExclusions = listOf(31921L, 31922L, 31925L)),

        WordEntity(id = 31924, setId = 319, languagePair = "en-ru", rarity = "EPIC",
            original = "dollop", transliteration = "[ˈdɑləp]", translation = "ложка-порция мягкого продукта",
            definition = "A soft round spoonful of something thick like cream or yogurt.",
            definitionNative = "Мягкая округлая ложка чего-то густого — сметаны, йогурта, крема.",
            example = "Add a dollop of sour cream on top of the warm beetroot soup.",
            exampleNative = "Положи dollop сметаны поверх тёплого свекольного супа.",
            pos = "noun", semanticGroup = "food_finishing"),

        WordEntity(id = 31925, setId = 319, languagePair = "en-ru", rarity = "EPIC",
            original = "decant", transliteration = "[dɪˈkænt]", translation = "осторожно перелить жидкость",
            definition = "To pour a liquid slowly from one container to another, leaving sediment.",
            definitionNative = "Медленно перелить жидкость из сосуда в сосуд, оставив осадок на дне.",
            example = "Decant the wine carefully so the dark sediment stays in the bottle.",
            exampleNative = "Decant вино аккуратно, чтобы тёмный осадок остался в бутылке.",
            pos = "verb", semanticGroup = "food_finishing", fillInBlankExclusions = listOf(31903L, 31921L, 31922L, 31923L)),
    )
}
