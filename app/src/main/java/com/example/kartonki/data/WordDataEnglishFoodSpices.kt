package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — set 461.
 * Еда и кулинария: специи, пряности и ароматические травы (L3 / RARE + EPIC).
 *
 * Расширение темы «Еда и кулинария». Дополняет:
 *   - 9, 10 (L1) — базовые продукты и напитки
 *   - 230, 250, 263, 273 (L1-L2) — продукты, овощи, рестораны, завтрак
 *   - 207, 231 (L3) — готовка и профессиональная кухня
 *   - 319, 320 (L4-L5) — гастрономия высокого уровня
 *
 * Подтема — узкоспециальная лексика про специи и пряные травы:
 * семена (cumin, peppercorn), тёплые ноты (clove, star anise),
 * зелёные травы (basil, thyme, sage), редкие/экзотические
 * (fenugreek, sumac, lemongrass, garam masala).
 *
 * Слова saffron, cardamom, turmeric, paprika, cinnamon, nutmeg,
 * coriander, dill, bay leaf уже заняты setId=230, parsley — setId=263.
 */
object WordDataEnglishFoodSpices {

    val sets = listOf(
        WordSetEntity(
            id = 461,
            name = "Еда и кулинария",
            description = "Специи, пряности и травы: cumin, thyme, fenugreek, sumac",
            languagePair = "en-ru",
            orderIndex = 461,
            topic = "Еда и кулинария",
            level = 3,
        ),
    )

    val words = listOf(

        // ── food_spices_seeds (семенные специи) ───────────────────────────────
        WordEntity(
            id = 46101, original = "cumin", transliteration = "[ˈkjuːmɪn]", translation = "зира (кумин)",
            definition = "A warm, earthy seed spice ground into curries, chili, and Middle Eastern stews.",
            definitionNative = "Тёплая землистая пряность из семян — для карри, чили и ближневосточных рагу.",
            example = "She toasted a teaspoon of cumin before adding the onions.",
            exampleNative = "Она обжарила чайную ложку cumin перед тем, как добавить лук.",
            rarity = "RARE", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_seeds", fillInBlankExclusions = listOf(46102L, 46103L, 46104L)),
        WordEntity(
            id = 46102, original = "fennel seed", transliteration = "[ˈfenəl siːd]", translation = "семена фенхеля",
            definition = "A small green-brown seed with a soft licorice taste, popular in sausages and tea.",
            definitionNative = "Зеленовато-бурое семечко с мягким лакричным вкусом — для колбас и чая.",
            example = "He sprinkled fennel seed over the pork sausage before roasting it.",
            exampleNative = "Он посыпал fennel seed свиную колбаску перед запеканием.",
            rarity = "RARE", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_seeds", fillInBlankExclusions = listOf(46101L, 46103L, 46104L)),
        WordEntity(
            id = 46103, original = "mustard seed", transliteration = "[ˈmʌstərd siːd]", translation = "горчичное зерно",
            definition = "A tiny round seed that crackles in hot oil and adds a sharp bite to Indian dishes.",
            definitionNative = "Маленькое круглое зёрнышко: трещит в горячем масле и придаёт остроту индийским блюдам.",
            example = "Pop a spoonful of mustard seed in oil until the seeds crackle.",
            exampleNative = "Брось ложку mustard seed в масло, пока зёрна не затрещат.",
            rarity = "RARE", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_seeds", fillInBlankExclusions = listOf(46101L, 46102L, 46104L)),
        WordEntity(
            id = 46104, original = "peppercorn", transliteration = "[ˈpepərkɔːrn]", translation = "горошек чёрного перца",
            definition = "A small dried berry that is ground to give heat and bite to food.",
            definitionNative = "Маленькая сушёная ягода, которую перемалывают для остроты и пикантности в еде.",
            example = "Crack a fresh peppercorn over the steak just before serving.",
            exampleNative = "Расколи свежий peppercorn над стейком прямо перед подачей.",
            rarity = "RARE", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_seeds", fillInBlankExclusions = listOf(46101L, 46102L, 46103L)),

        // ── food_spices_warm (тёплые/древесные ноты) ──────────────────────────
        WordEntity(
            id = 46105, original = "clove", transliteration = "[kloʊv]", translation = "гвоздика (пряность)",
            definition = "A dried flower bud that looks like a tiny nail and tastes sharply sweet.",
            definitionNative = "Сушёный цветочный бутон — выглядит как крошечный гвоздик, на вкус остро-сладкий.",
            example = "Stick a clove into each lemon half for the mulled wine.",
            exampleNative = "Воткни по одной clove в каждую половинку лимона для глинтвейна.",
            rarity = "RARE", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_warm", fillInBlankExclusions = listOf(46108L, 46109L)),
        WordEntity(
            id = 46106, original = "anise", transliteration = "[ˈænɪs]", translation = "анис",
            definition = "A seed with a licorice-like flavour, used in baking, liqueurs, and herbal tea.",
            definitionNative = "Семечко со вкусом лакрицы — для выпечки, ликёров и травяного чая.",
            example = "The cookies got their unique taste from a pinch of anise.",
            exampleNative = "Печенье получило свой особый вкус от щепотки anise.",
            rarity = "RARE", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_warm", fillInBlankExclusions = listOf(46105L, 46107L, 46108L, 46109L)),
        WordEntity(
            id = 46107, original = "allspice", transliteration = "[ˈɔːlspaɪs]", translation = "ямайский перец",
            definition = "A dried berry whose taste reminds you of cloves, cinnamon, and nutmeg at once.",
            definitionNative = "Сушёная ягода со вкусом, в котором сразу слышны гвоздика, корица и мускат.",
            example = "Jamaican jerk seasoning relies heavily on allspice and chili.",
            exampleNative = "Ямайская приправа джерк сильно опирается на allspice и чили.",
            rarity = "RARE", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_warm", fillInBlankExclusions = listOf(46105L, 46106L, 46108L, 46109L)),
        WordEntity(
            id = 46108, original = "star anise", transliteration = "[stɑːr ˈænɪs]", translation = "бадьян (звёздчатый анис)",
            definition = "A dark star-shaped pod from China, central to pho broth and Chinese five-spice.",
            definitionNative = "Тёмный звездообразный стручок из Китая — основа бульона фо и китайских пяти специй.",
            example = "Drop two pieces of star anise into the simmering broth.",
            exampleNative = "Брось два кусочка star anise в кипящий бульон.",
            rarity = "EPIC", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_warm", fillInBlankExclusions = listOf(46105L, 46106L, 46107L, 46109L)),
        WordEntity(
            id = 46109, original = "mace", transliteration = "[meɪs]", translation = "мацис (цвет мускатного ореха)",
            definition = "A bright red lace around a tropical nut, milder than that nut but more delicate.",
            definitionNative = "Ярко-красная сетка вокруг тропического ореха — мягче и тоньше самого ореха.",
            example = "A blade of mace gives bechamel a subtle perfume.",
            exampleNative = "Лепесток mace придаёт бешамелю тонкий аромат.",
            rarity = "EPIC", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_warm", fillInBlankExclusions = listOf(46105L, 46106L, 46107L, 46108L)),

        // ── food_spices_herbs_green (зелёные ароматические травы) ─────────────
        WordEntity(
            id = 46110, original = "basil", transliteration = "[ˈbeɪzəl]", translation = "базилик",
            definition = "A green leafy herb at the heart of Italian pesto and Thai stir-fries.",
            definitionNative = "Зелёная листовая трава — основа итальянского песто и тайских стир-фраев.",
            example = "Tear fresh basil leaves over the warm pizza.",
            exampleNative = "Порви свежие листья basil над тёплой пиццей.",
            rarity = "RARE", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_herbs_green", fillInBlankExclusions = listOf(46111L, 46112L, 46113L, 46114L, 46115L)),
        WordEntity(
            id = 46111, original = "oregano", transliteration = "[əˈreɡənoʊ]", translation = "орегано (душица)",
            definition = "A small-leaved Mediterranean herb that gives pizza its familiar warm aroma.",
            definitionNative = "Средиземноморская трава с мелкими листьями — даёт пицце привычный тёплый аромат.",
            example = "Greek salad needs a heavy sprinkle of dried oregano on top.",
            exampleNative = "Греческому салату нужна обильная посыпка сухого oregano сверху.",
            rarity = "RARE", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_herbs_green", fillInBlankExclusions = listOf(46110L, 46112L, 46113L, 46114L, 46115L)),
        WordEntity(
            id = 46112, original = "rosemary", transliteration = "[ˈroʊzməri]", translation = "розмарин",
            definition = "A piney evergreen herb whose needle-shaped leaves pair well with lamb and potatoes.",
            definitionNative = "Хвойная вечнозелёная трава с иголочками — отлично подходит к баранине и картофелю.",
            example = "Toss the potatoes with olive oil and fresh rosemary before roasting.",
            exampleNative = "Перемешай картофель с оливковым маслом и свежим rosemary перед запеканием.",
            rarity = "RARE", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_herbs_green", fillInBlankExclusions = listOf(46110L, 46111L, 46113L, 46114L, 46115L)),
        WordEntity(
            id = 46113, original = "thyme", transliteration = "[taɪm]", translation = "тимьян (чабрец)",
            definition = "A tiny-leaved garden herb with an earthy note, central to French country cooking.",
            definitionNative = "Огородная трава с крошечными листочками и землистой нотой — основа французской кухни.",
            example = "Strip a few thyme sprigs into the chicken stock.",
            exampleNative = "Сними листочки с пары веточек thyme прямо в куриный бульон.",
            rarity = "RARE", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_herbs_green", fillInBlankExclusions = listOf(46110L, 46111L, 46112L, 46114L, 46115L)),
        WordEntity(
            id = 46114, original = "sage", transliteration = "[seɪdʒ]", translation = "шалфей",
            definition = "A grey-green velvety herb whose savoury punch shines in stuffing and brown butter.",
            definitionNative = "Серо-зелёная бархатистая трава — её насыщенный вкус раскрывается в фарше и масле.",
            example = "Fry the sage leaves in butter until they turn crisp.",
            exampleNative = "Обжарь листочки sage в масле, пока они не станут хрустящими.",
            rarity = "RARE", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_herbs_green", fillInBlankExclusions = listOf(46110L, 46111L, 46112L, 46113L, 46115L)),
        WordEntity(
            id = 46115, original = "mint", transliteration = "[mɪnt]", translation = "мята",
            definition = "A cool, fresh-tasting herb chopped into tabbouleh, mojitos, and lamb sauces.",
            definitionNative = "Прохладная свежая трава — рубят в табуле, мохито и соусы к баранине.",
            example = "Garnish each glass of mojito with a sprig of mint.",
            exampleNative = "Укрась каждый стакан мохито веточкой mint.",
            rarity = "RARE", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_herbs_green", fillInBlankExclusions = listOf(46110L, 46111L, 46112L, 46113L, 46114L)),

        // ── food_spices_herbs_special (редкие травы) ──────────────────────────
        WordEntity(
            id = 46116, original = "tarragon", transliteration = "[ˈtærəɡən]", translation = "эстрагон (тархун)",
            definition = "A slender herb with a soft licorice note, classic in French chicken sauces.",
            definitionNative = "Тонкая трава с мягкой лакричной нотой — классика французских куриных соусов.",
            example = "Bearnaise sauce gets its character from fresh tarragon.",
            exampleNative = "Соус беарнез получает свой характер от свежего tarragon.",
            rarity = "EPIC", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_herbs_special", fillInBlankExclusions = listOf(46117L, 46118L, 46119L)),
        WordEntity(
            id = 46117, original = "marjoram", transliteration = "[ˈmɑːrdʒərəm]", translation = "майоран",
            definition = "A sweeter, milder cousin of oregano, often stirred into sausages and pates.",
            definitionNative = "Более сладкий и мягкий собрат орегано — часто кладут в колбасы и паштеты.",
            example = "German bratwurst recipes often call for a pinch of marjoram.",
            exampleNative = "Рецепты немецких братвурстов часто требуют щепотку marjoram.",
            rarity = "EPIC", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_herbs_special", fillInBlankExclusions = listOf(46116L, 46118L, 46119L)),
        WordEntity(
            id = 46118, original = "chive", transliteration = "[tʃaɪv]", translation = "шнитт-лук",
            definition = "A thin hollow green shoot with a mild onion flavour, snipped over soups and eggs.",
            definitionNative = "Тонкий полый зелёный росток с мягким луковым вкусом — режут в супы и яичницу.",
            example = "Scatter chopped chive across the bowl of cold potato soup.",
            exampleNative = "Рассыпь нарезанный chive по тарелке холодного картофельного супа.",
            rarity = "RARE", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_herbs_special", fillInBlankExclusions = listOf(46116L, 46117L, 46119L)),
        WordEntity(
            id = 46119, original = "chervil", transliteration = "[ˈtʃɜːrvɪl]", translation = "кервель",
            definition = "A lacy, mild French herb tasting faintly of parsley and licorice at once.",
            definitionNative = "Кружевная мягкая французская трава со слабым вкусом петрушки и лакрицы одновременно.",
            example = "Top the omelette with a few delicate chervil leaves.",
            exampleNative = "Укрась омлет несколькими нежными листочками chervil.",
            rarity = "EPIC", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_herbs_special", fillInBlankExclusions = listOf(46116L, 46117L, 46118L)),

        // ── food_spices_exotic (восточные и экзотические) ─────────────────────
        WordEntity(
            id = 46120, original = "ginger", transliteration = "[ˈdʒɪndʒər]", translation = "имбирь",
            definition = "A knobby underground stem with a hot, fresh bite, used in tea, curry, and baking.",
            definitionNative = "Узловатый подземный стебель с острой свежей нотой — для чая, карри и выпечки.",
            example = "Grate a piece of fresh ginger into the chicken broth.",
            exampleNative = "Натри кусочек свежего ginger в куриный бульон.",
            rarity = "RARE", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_exotic", fillInBlankExclusions = listOf(46121L, 46122L, 46123L, 46124L, 46125L)),
        WordEntity(
            id = 46121, original = "vanilla bean", transliteration = "[vəˈnɪlə biːn]", translation = "стручок ванили",
            definition = "A long, dark, leathery pod whose tiny seeds perfume custards and ice cream.",
            definitionNative = "Длинный тёмный кожистый стручок: его крошечные семена ароматизируют крем и мороженое.",
            example = "Split a vanilla bean and scrape the seeds into the warm cream.",
            exampleNative = "Расщепи vanilla bean и наскреби семена в тёплые сливки.",
            rarity = "RARE", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_exotic", fillInBlankExclusions = listOf(46120L, 46122L, 46123L, 46124L, 46125L)),
        WordEntity(
            id = 46122, original = "fenugreek", transliteration = "[ˈfenjuːɡriːk]", translation = "пажитник (хельба)",
            definition = "A small bitter-sweet seed used in Indian curries that smells slightly of maple syrup.",
            definitionNative = "Маленькое горько-сладкое семечко для индийских карри — слегка пахнет кленовым сиропом.",
            example = "Soak some fenugreek overnight before adding it to the curry.",
            exampleNative = "Замочи немного fenugreek на ночь, перед тем как добавить в карри.",
            rarity = "EPIC", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_exotic", fillInBlankExclusions = listOf(46120L, 46121L, 46123L, 46124L, 46125L)),
        WordEntity(
            id = 46123, original = "sumac", transliteration = "[ˈsuːmæk]", translation = "сумах",
            definition = "A dried red berry, ground into a tangy purple powder used across the Levant.",
            definitionNative = "Сушёная красная ягода, перемолотая в кислый пурпурный порошок — популярен на Леванте.",
            example = "Dust the salad with sumac for a citrusy kick.",
            exampleNative = "Присыпь салат sumac, чтобы получить цитрусовую нотку.",
            rarity = "EPIC", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_exotic", fillInBlankExclusions = listOf(46120L, 46121L, 46122L, 46124L, 46125L)),
        WordEntity(
            id = 46124, original = "lemongrass", transliteration = "[ˈleməngræs]", translation = "лемонграсс",
            definition = "A tough, citrus-scented grass crushed into Thai soups and curries.",
            definitionNative = "Жёсткая трава с цитрусовым ароматом — крошат в тайские супы и карри.",
            example = "Bruise a stalk of lemongrass before dropping it in the broth.",
            exampleNative = "Раздави стебель lemongrass перед тем, как бросить его в бульон.",
            rarity = "EPIC", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_exotic", fillInBlankExclusions = listOf(46120L, 46121L, 46122L, 46123L, 46125L)),
        WordEntity(
            id = 46125, original = "garam masala", transliteration = "[ɡəˈrɑːm məˈsɑːlə]", translation = "гарам масала",
            definition = "An Indian blend of warm ground spices, stirred in at the very end of cooking.",
            definitionNative = "Индийская смесь тёплых молотых пряностей — её добавляют в самом конце готовки.",
            example = "Stir a teaspoon of garam masala into the curry before serving.",
            exampleNative = "Вмешай чайную ложку garam masala в карри прямо перед подачей.",
            rarity = "EPIC", setId = 461, languagePair = "en-ru", pos = "noun",
            semanticGroup = "food_spices_exotic", fillInBlankExclusions = listOf(46120L, 46121L, 46122L, 46123L, 46124L)),
    )
}
