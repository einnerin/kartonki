package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — set 465.
 * Наука: физика — механика, энергия, электричество, оптика, термодинамика
 * (L3 / UNCOMMON + RARE).
 *
 * Расширение темы «Наука». Дополняет:
 *   - 37   (L2) — базовая научная лексика.
 *   - 55   (L3) — продвинутая научная лексика.
 *   - 70-74 (L4) — закономерности, процессы, продвинутые термины.
 *   - 216  (L3) — космос и небесные тела.
 *   - 218  (L3) — числа, фигуры, математика.
 *   - 219  (L2) — химия базовая.
 *   - 248  (L4) — химия углублённая.
 *   - 324  (L1) — наука для начинающих.
 *   - 325  (L5) — методология и философия науки.
 *
 * Подтема — физика B1-B2: понятия из учебника и научпопа.
 * Пять семантических групп:
 *   science_physics_mechanics    — acceleration, momentum, inertia, friction, torque
 *   science_physics_energy       — kinetic energy, potential energy, efficiency, mass, pressure
 *   science_physics_electricity  — voltage, current, resistance, circuit, magnetism
 *   science_physics_optics_waves — photon, refraction, reflection, lens, oscillation
 *   science_physics_thermo       — conduction, viscosity, buoyancy, equilibrium, insulator
 *
 * Исключены дубли (21 слово):
 *   - velocity, gravity, electron, charge, wavelength, frequency, spectrum,
 *     temperature, entropy, radiation — setId 1/2 (WordDataEnglish.kt, общая лексика).
 *   - weight, density, power, conductor, heat, vacuum — WordDataEnglishExpanded.kt.
 *   - energy — setId 1 + HealthFitness.
 *   - force — setId 324 (ScienceL1).
 *   - wave — Batch11.
 *   - convection — WeatherL4.
 *   - work — setId 22 (значение «работа = место»).
 *
 * Word IDs: 46501..46525 (setId × 100 + position).
 */
object WordDataEnglishSciencePhysics {

    val sets = listOf(
        WordSetEntity(
            id = 465,
            name = "Наука",
            description = "Физика: механика, электричество, оптика и термодинамика — momentum, voltage, refraction, conduction",
            languagePair = "en-ru",
            orderIndex = 465,
            topic = "Наука",
            level = 3,
        ),
    )

    val words = listOf(

        // ── science_physics_mechanics (механика и силы) ───────────────────────
        WordEntity(
            id = 46501, original = "acceleration", transliteration = "[ækˌseləˈreɪʃən]", translation = "ускорение",
            definition = "The rate at which an object's speed changes over time, in any direction it happens to move.",
            definitionNative = "Скорость изменения быстроты объекта со временем в любом направлении его движения.",
            example = "The new electric car claims an acceleration that pins you to the seat for the first three seconds.",
            exampleNative = "Новый электромобиль обещает acceleration, которое первые три секунды вжимает в кресло.",
            rarity = "RARE", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_mechanics", fillInBlankExclusions = listOf(46503L)),
        WordEntity(
            id = 46502, original = "momentum", transliteration = "[moʊˈmentəm]", translation = "импульс (количество движения)",
            definition = "The push a moving body carries, equal to its mass times how fast it is going.",
            definitionNative = "Запас движения у тела: произведение его массы на быстроту перемещения.",
            example = "The truck kept rolling for half a block because its momentum was simply too big to brake away.",
            exampleNative = "Грузовик ещё полквартала катился: его momentum был слишком велик, чтобы оттормозиться сразу.",
            rarity = "RARE", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_mechanics", fillInBlankExclusions = listOf(46501L, 46503L, 46504L, 46505L, 46509L)),
        WordEntity(
            id = 46503, original = "inertia", transliteration = "[ɪˈnɜːrʃə]", translation = "инерция",
            definition = "The natural tendency of a body to keep doing whatever it is doing until something pushes it otherwise.",
            definitionNative = "Свойство тела сохранять текущее состояние движения или покоя, пока на него не подействует что-то.",
            example = "Passengers lurch forward at a red light because their inertia keeps them moving after the bus stops.",
            exampleNative = "Пассажиров кидает вперёд на красном: их inertia толкает их дальше, когда автобус уже встал.",
            rarity = "RARE", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_mechanics", fillInBlankExclusions = listOf(46501L, 46502L, 46504L, 46505L)),
        WordEntity(
            id = 46504, original = "friction", transliteration = "[ˈfrɪkʃən]", translation = "трение",
            definition = "The resistance that surfaces in contact produce when one tries to slide past the other.",
            definitionNative = "Сопротивление, которое создают соприкасающиеся поверхности, когда одна скользит по другой.",
            example = "Skiers wax the bottom of their skis to cut friction between the gear and packed snow.",
            exampleNative = "Лыжники натирают мазью основание лыж, чтобы уменьшить friction между снаряжением и плотным снегом.",
            rarity = "UNCOMMON", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_mechanics", fillInBlankExclusions = listOf(46501L, 46502L, 46503L, 46505L, 46513L)),
        WordEntity(
            id = 46505, original = "torque", transliteration = "[tɔːrk]", translation = "момент силы / крутящий момент",
            definition = "The turning push a force exerts on an object around an axis, like tightening a bolt with a wrench.",
            definitionNative = "Поворачивающее воздействие силы на объект вокруг оси, как при затягивании болта ключом.",
            example = "Diesel engines are loved by truckers for the low-end torque that drags heavy loads up steep grades.",
            exampleNative = "Дизельные моторы любимы дальнобойщиками за низкооборотный torque, тянущий тяжёлые грузы в крутую гору.",
            rarity = "RARE", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_mechanics", fillInBlankExclusions = listOf(46501L, 46502L, 46503L, 46504L)),

        // ── science_physics_energy (энергия, масса, давление) ─────────────────
        WordEntity(
            id = 46506, original = "kinetic energy", transliteration = "[kɪˈnetɪk ˈenərdʒi]", translation = "кинетическая энергия",
            definition = "The store of motion a body carries; the faster or heavier it moves, the more of this store it holds.",
            definitionNative = "Запас движения у тела: чем быстрее или тяжелее оно перемещается, тем этот запас больше.",
            example = "A falling hammer turns its height into kinetic energy and drives the nail in one solid blow.",
            exampleNative = "Падающий молоток превращает высоту в kinetic energy и одним крепким ударом загоняет гвоздь.",
            rarity = "RARE", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_energy", fillInBlankExclusions = listOf(46502L, 46507L, 46508L, 46509L, 46510L)),
        WordEntity(
            id = 46507, original = "potential energy", transliteration = "[pəˈtenʃəl ˈenərdʒi]", translation = "потенциальная энергия",
            definition = "The stored store a body has because of its position or shape, ready to turn into motion when released.",
            definitionNative = "Скрытый запас, который тело хранит из-за своего положения или формы — готов перейти в движение.",
            example = "A drawn bow holds potential energy in its bent limbs and releases it the moment you let go.",
            exampleNative = "Натянутый лук держит potential energy в согнутых плечах и отдаёт её в момент выстрела.",
            rarity = "RARE", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_energy", fillInBlankExclusions = listOf(46506L, 46508L, 46509L, 46510L)),
        WordEntity(
            id = 46508, original = "efficiency", transliteration = "[ɪˈfɪʃənsi]", translation = "коэффициент полезного действия",
            definition = "The share of input that comes back as useful output, with the rest lost as heat, noise or waste.",
            definitionNative = "Доля вложенного, что возвращается полезным результатом; остальное уходит на тепло, шум или потери.",
            example = "Modern LED bulbs win on efficiency because they turn almost all the electricity straight into light.",
            exampleNative = "Современные светодиодные лампы выигрывают по efficiency: почти весь ток уходит прямо в свет.",
            rarity = "RARE", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_energy", fillInBlankExclusions = listOf(46506L, 46507L, 46509L, 46510L)),
        WordEntity(
            id = 46509, original = "mass", transliteration = "[mæs]", translation = "масса",
            definition = "The amount of stuff a body contains; the more of it, the harder the body is to push or stop.",
            definitionNative = "Количество вещества в теле; чем его больше, тем тяжелее тело сдвинуть или остановить.",
            example = "An astronaut keeps the same mass on the moon, even though the scale reads only a sixth there.",
            exampleNative = "У космонавта на Луне та же mass, хотя весы показывают там лишь шестую часть.",
            rarity = "UNCOMMON", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_energy", fillInBlankExclusions = listOf(46503L, 46506L, 46507L, 46508L, 46510L)),
        WordEntity(
            id = 46510, original = "pressure", transliteration = "[ˈpreʃər]", translation = "давление",
            definition = "The push a fluid or gas exerts on every square unit of any surface it touches.",
            definitionNative = "Сила, с которой жидкость или газ давят на каждую единицу площади касающейся поверхности.",
            example = "Divers feel the pressure squeeze on their ears the moment they drop below a couple of metres.",
            exampleNative = "Дайверы чувствуют, как pressure давит на уши, едва они уходят на пару метров вглубь.",
            rarity = "UNCOMMON", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_energy", fillInBlankExclusions = listOf(46506L, 46507L, 46508L, 46509L)),

        // ── science_physics_electricity (электричество и магнетизм) ───────────
        WordEntity(
            id = 46511, original = "voltage", transliteration = "[ˈvoʊltɪdʒ]", translation = "напряжение (электрическое)",
            definition = "The push that drives charges along a wire, measured between any two points of a circuit.",
            definitionNative = "Сила, гонящая заряды по проводу; измеряется между любыми двумя точками цепи.",
            example = "European outlets deliver double the voltage of American ones, so cheap chargers can pop loudly.",
            exampleNative = "Европейские розетки выдают вдвое больший voltage, чем американские, и дешёвые зарядки громко лопаются.",
            rarity = "RARE", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_electricity", fillInBlankExclusions = listOf(46512L, 46513L, 46514L, 46515L)),
        WordEntity(
            id = 46512, original = "current", transliteration = "[ˈkɜːrənt]", translation = "ток (электрический)",
            definition = "The steady flow of electric charges through a wire, measured in amperes.",
            definitionNative = "Упорядоченный поток электрических зарядов через провод; измеряется в амперах.",
            example = "A small current of ten milliamps through the heart is already dangerous for a human being.",
            exampleNative = "Небольшой current около десяти миллиампер через сердце уже опасен для человека.",
            rarity = "UNCOMMON", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_electricity", fillInBlankExclusions = listOf(46511L, 46513L, 46514L, 46515L)),
        WordEntity(
            id = 46513, original = "resistance", transliteration = "[rɪˈzɪstəns]", translation = "сопротивление (электрическое)",
            definition = "How strongly a material fights the flow of electric charges, turning some of the energy into heat.",
            definitionNative = "Способность материала препятствовать потоку зарядов, превращая часть энергии в тепло.",
            example = "Old copper wires gain resistance as they oxidise, so the toaster pulls more power than before.",
            exampleNative = "Старые медные провода набирают resistance по мере окисления, и тостер тянет из розетки больше энергии.",
            rarity = "RARE", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_electricity", fillInBlankExclusions = listOf(46511L, 46512L, 46514L, 46515L)),
        WordEntity(
            id = 46514, original = "circuit", transliteration = "[ˈsɜːrkɪt]", translation = "электрическая цепь",
            definition = "A closed loop along which electric charges can travel from a power source through devices and back.",
            definitionNative = "Замкнутая петля, по которой заряды идут от источника питания через приборы и обратно.",
            example = "Flipping the switch closes the circuit and the bulb lights up almost instantly across the room.",
            exampleNative = "Щелчок выключателя замыкает circuit, и лампочка зажигается почти мгновенно через всю комнату.",
            rarity = "UNCOMMON", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_electricity", fillInBlankExclusions = listOf(46511L, 46512L, 46513L, 46515L)),
        WordEntity(
            id = 46515, original = "magnetism", transliteration = "[ˈmæɡnəˌtɪzəm]", translation = "магнетизм",
            definition = "The pull or push some materials and moving charges produce on iron, nickel and each other.",
            definitionNative = "Притяжение или отталкивание, которое некоторые материалы и движущиеся заряды создают на железе, никеле и друг друге.",
            example = "Hard drives store every photo and song through tiny patches of magnetism on a spinning platter.",
            exampleNative = "Жёсткие диски хранят каждое фото и каждую песню через крошечные участки magnetism на вращающейся пластине.",
            rarity = "RARE", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_electricity", fillInBlankExclusions = listOf(46511L, 46512L, 46513L, 46514L)),

        // ── science_physics_optics_waves (оптика и волны) ─────────────────────
        WordEntity(
            id = 46516, original = "photon", transliteration = "[ˈfoʊtɑːn]", translation = "фотон",
            definition = "The smallest single packet of light or any other electromagnetic radiation, with no rest weight.",
            definitionNative = "Наименьший одиночный пакет света или другого электромагнитного излучения; покоя у него нет.",
            example = "Solar panels knock electrons loose each time a photon of sunlight slams into the silicon surface.",
            exampleNative = "Солнечные панели выбивают электроны каждый раз, когда photon солнечного света бьёт по кремнию.",
            rarity = "RARE", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_optics_waves", fillInBlankExclusions = listOf(46517L, 46518L, 46519L)),
        WordEntity(
            id = 46517, original = "refraction", transliteration = "[rɪˈfrækʃən]", translation = "преломление (света)",
            definition = "The bend a light ray takes when it crosses into a medium where it travels at a different speed.",
            definitionNative = "Изгиб луча света при переходе в среду, где скорость его распространения становится иной.",
            example = "A straw in a water glass looks broken at the surface because of the refraction of light.",
            exampleNative = "Соломинка в стакане воды кажется надломленной у поверхности из-за refraction света.",
            rarity = "RARE", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_optics_waves", fillInBlankExclusions = listOf(46516L, 46518L, 46519L, 46520L)),
        WordEntity(
            id = 46518, original = "reflection", transliteration = "[rɪˈflekʃən]", translation = "отражение (света)",
            definition = "The bouncing of light, sound or any other wave off a surface back into the medium it came from.",
            definitionNative = "Отскок света, звука или другой волны от поверхности обратно в ту среду, откуда она пришла.",
            example = "Drivers hate sharp reflection off wet asphalt at sunset because the glare wipes out road markings.",
            exampleNative = "Водители ненавидят резкое reflection от мокрого асфальта на закате: засветка убивает разметку.",
            rarity = "UNCOMMON", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_optics_waves", fillInBlankExclusions = listOf(46516L, 46517L, 46519L, 46520L)),
        WordEntity(
            id = 46519, original = "lens", transliteration = "[lenz]", translation = "линза",
            definition = "A curved piece of glass or plastic shaped to bend light rays and form a sharp picture beyond it.",
            definitionNative = "Изогнутый кусок стекла или пластика, преломляющий лучи света и собирающий из них чёткую картинку.",
            example = "A scratched camera lens softens every shot, no matter how good the sensor behind it might be.",
            exampleNative = "Поцарапанная lens фотоаппарата размывает каждый кадр, каким бы хорошим ни был сенсор за ней.",
            rarity = "UNCOMMON", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_optics_waves", fillInBlankExclusions = listOf(46516L, 46517L, 46518L, 46520L)),
        WordEntity(
            id = 46520, original = "oscillation", transliteration = "[ˌɑːsəˈleɪʃən]", translation = "колебание",
            definition = "A back-and-forth motion around a middle point, like a swinging pendulum or a vibrating string.",
            definitionNative = "Движение туда-обратно вокруг среднего положения, как у качающегося маятника или вибрирующей струны.",
            example = "Engineers damp every tall building's oscillation so wind gusts never sway the upper floors badly.",
            exampleNative = "Инженеры гасят oscillation каждого высотного здания, чтобы порывы ветра не раскачивали верхние этажи.",
            rarity = "RARE", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_optics_waves", fillInBlankExclusions = listOf(46516L, 46517L, 46518L, 46519L)),

        // ── science_physics_thermo (термодинамика и состояния вещества) ───────
        WordEntity(
            id = 46521, original = "conduction", transliteration = "[kənˈdʌkʃən]", translation = "теплопроводность",
            definition = "The way heat or electricity moves through a body by direct contact of its tiny particles.",
            definitionNative = "Передача тепла или электричества внутри тела за счёт прямого контакта его мельчайших частиц.",
            example = "A copper pan heats food fast because metal's conduction shoves heat from the burner straight upward.",
            exampleNative = "Медная сковорода греет еду быстро: conduction металла гонит тепло от конфорки прямо наверх.",
            rarity = "RARE", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_thermo", fillInBlankExclusions = listOf(46522L, 46523L, 46524L, 46525L)),
        WordEntity(
            id = 46522, original = "viscosity", transliteration = "[vɪˈskɑːsəti]", translation = "вязкость",
            definition = "How thick a fluid is, or how strongly its inner layers drag against one another as it flows.",
            definitionNative = "Густота жидкости — насколько сильно её внутренние слои тормозят друг друга при течении.",
            example = "Cold honey has such high viscosity that pouring it onto a pancake feels like pulling rubber.",
            exampleNative = "У холодного мёда такая viscosity, что лить его на блин — будто тянуть резину.",
            rarity = "RARE", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_thermo", fillInBlankExclusions = listOf(46521L, 46523L, 46524L, 46525L)),
        WordEntity(
            id = 46523, original = "buoyancy", transliteration = "[ˈbɔɪənsi]", translation = "плавучесть",
            definition = "The lift a fluid gives any body placed in it, pushing the body up against gravity.",
            definitionNative = "Подъёмная сила, которую жидкость даёт погружённому в неё телу, толкая его вверх против тяготения.",
            example = "Salty seawater offers more buoyancy than a freshwater lake, so swimmers float without much effort.",
            exampleNative = "Солёная морская вода даёт большую buoyancy, чем пресное озеро, и пловец держится на поверхности без усилий.",
            rarity = "RARE", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_thermo", fillInBlankExclusions = listOf(46513L, 46521L, 46522L, 46524L, 46525L)),
        WordEntity(
            id = 46524, original = "equilibrium", transliteration = "[ˌiːkwəˈlɪbriəm]", translation = "равновесие",
            definition = "A steady state in which all pushes and pulls on a body cancel out, leaving nothing changing.",
            definitionNative = "Устойчивое состояние, при котором все воздействия на тело гасят друг друга, и ничего не меняется.",
            example = "A drink and the surrounding air reach thermal equilibrium after about twenty minutes on the counter.",
            exampleNative = "Напиток и окружающий воздух приходят в тепловое equilibrium примерно через двадцать минут на столе.",
            rarity = "RARE", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_thermo", fillInBlankExclusions = listOf(46521L, 46522L, 46523L, 46525L)),
        WordEntity(
            id = 46525, original = "insulator", transliteration = "[ˈɪnsəˌleɪtər]", translation = "изолятор (тепловой / электрический)",
            definition = "A material that hardly lets heat or electric charges pass, used to block them where needed.",
            definitionNative = "Материал, почти не пропускающий тепло или электрические заряды; ставится там, где их надо удержать.",
            example = "Rubber gloves work as a fine insulator and let the electrician touch live wires safely.",
            exampleNative = "Резиновые перчатки работают как хороший insulator: электрик берёт провода под напряжением безопасно.",
            rarity = "RARE", setId = 465, languagePair = "en-ru", pos = "noun",
            semanticGroup = "science_physics_thermo", fillInBlankExclusions = listOf(46521L, 46522L, 46523L, 46524L)),
    )
}
