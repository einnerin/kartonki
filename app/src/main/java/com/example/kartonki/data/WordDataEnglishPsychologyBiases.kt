package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — set 466.
 * Психология: когнитивные искажения и предубеждения (cognitive biases)
 * по работам Канемана/Тверски и поведенческой экономики (L4 / RARE + EPIC).
 *
 * Расширение темы «Психология». Дополняет:
 *   - 28, 35, 36   (L2) — чувства, рост, отношения.
 *   - 45, 52, 53, 54 (L3) — поведение, черты, процессы, риски.
 *   - 64, 71       (L4) — опыт и ценности.
 *   - 81           (L5) — описание ума и характера.
 *   - 215          (L2) — терминология психологии (WordDataEnglishExpanded).
 *   - 334          (L1) — основы (WordDataEnglishPsychologyL1).
 *
 * Подтема — конкретные именованные когнитивные искажения: confirmation bias,
 * anchoring, sunk cost fallacy, dunning-kruger effect, endowment effect и др.
 * Терминология поведенческой экономики и социальной психологии.
 *
 * Пять семантических групп:
 *   psy_bias_judgment — confirmation bias, anchoring, availability heuristic,
 *                       base rate fallacy, gambler's fallacy
 *   psy_bias_memory   — recency bias, hindsight bias, primacy effect,
 *                       peak-end rule, negativity bias
 *   psy_bias_social   — attribution error, self-serving bias, in-group bias,
 *                       out-group homogeneity, false consensus effect
 *   psy_bias_decision — sunk cost fallacy, status quo bias, endowment effect,
 *                       IKEA effect, ostrich effect
 *   psy_bias_self     — dunning-kruger effect, optimism bias, planning fallacy,
 *                       illusory correlation, survivorship bias
 *
 * Исключены из набора кандидатов (уже есть в других сетах):
 *   - halo effect, framing effect, loss aversion — set 287 (ShoppingL5).
 *   - bandwagon-effect, decoy-effect — set 286 (ShoppingL4).
 *
 * Word IDs: 46601..46625 (setId × 100 + position).
 */
object WordDataEnglishPsychologyBiases {

    val sets = listOf(
        WordSetEntity(
            id = 466,
            name = "Психология",
            description = "Когнитивные искажения и предубеждения: confirmation bias, anchoring, sunk cost fallacy, dunning-kruger effect",
            languagePair = "en-ru",
            orderIndex = 466,
            topic = "Психология",
            level = 4,
        ),
    )

    val words = listOf(

        // ── psy_bias_judgment (суждение и оценка вероятности) ─────────────────
        WordEntity(
            id = 46601, original = "confirmation bias", transliteration = "[ˌkɑːnfərˈmeɪʃən ˈbaɪəs]", translation = "склонность к подтверждению",
            definition = "The habit of noticing evidence that backs your view and skipping anything that quietly argues against it.",
            definitionNative = "Привычка замечать факты в поддержку своей позиции и обходить вниманием то, что ей мешает.",
            example = "He reads only sites that share his views; confirmation bias keeps him there for years.",
            exampleNative = "Он читает три новостных сайта своих взглядов, и confirmation bias держит его там годами.",
            rarity = "RARE", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_judgment", fillInBlankExclusions = listOf(46602L, 46603L, 46604L, 46605L)),
        WordEntity(
            id = 46602, original = "anchoring", transliteration = "[ˈæŋkərɪŋ]", translation = "якорный эффект",
            definition = "Latching onto the first number or fact you hear and judging everything that follows against it.",
            definitionNative = "Цепляние за первое услышанное число или факт и оценка всего последующего относительно него.",
            example = "Sellers price a sofa at nine hundred to make four hundred feel cheap — pure anchoring at work.",
            exampleNative = "Продавцы ставят на диван ценник девятьсот, чтобы четыреста казались дёшево — чистый anchoring в деле.",
            rarity = "RARE", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_judgment", fillInBlankExclusions = listOf(46601L, 46603L, 46604L, 46605L, 46613L)),
        WordEntity(
            id = 46603, original = "availability heuristic", transliteration = "[əˌveɪləˈbɪləti hjʊˈrɪstɪk]", translation = "эвристика доступности",
            definition = "Judging how likely a thing is by how easily a vivid example of it pops into your head.",
            definitionNative = "Оценка вероятности события по тому, насколько легко в голове всплывает яркий пример.",
            example = "After one shark story, swimmers panic at every shadow — availability heuristic in action.",
            exampleNative = "После одного сюжета про акулу купальщики шарахаются от каждой тени — availability heuristic в действии.",
            rarity = "EPIC", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_judgment", fillInBlankExclusions = listOf(46601L, 46602L, 46604L, 46605L)),
        WordEntity(
            id = 46604, original = "base rate fallacy", transliteration = "[beɪs reɪt ˈfæləsi]", translation = "ошибка игнорирования базовой частоты",
            definition = "Trusting a vivid specific case so much that you forget how rare or common the thing actually is.",
            definitionNative = "Доверие яркому частному случаю настолько, что забываешь, насколько вообще редко или часто бывает явление.",
            example = "A positive test for a rare disease is usually a false alarm — base rate fallacy in action.",
            exampleNative = "Положительный тест на редкую болезнь чаще всего ложный — base rate fallacy обманывает большинство пациентов.",
            rarity = "EPIC", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_judgment", fillInBlankExclusions = listOf(46601L, 46602L, 46603L, 46605L, 46625L)),
        WordEntity(
            id = 46605, original = "gambler's fallacy", transliteration = "[ˈɡæmblərz ˈfæləsi]", translation = "ошибка игрока",
            definition = "Belief that a streak of one outcome makes the opposite outcome more likely on the very next try.",
            definitionNative = "Вера, что после серии одинаковых исходов на следующем розыгрыше выпадет противоположное.",
            example = "After five blacks at roulette he doubled on red, sure red was due — classic gambler's fallacy.",
            exampleNative = "После пяти чёрных подряд он удвоил ставку на красное, уверенный, что пора — классический gambler's fallacy.",
            rarity = "EPIC", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_judgment", fillInBlankExclusions = listOf(46601L, 46602L, 46603L, 46604L, 46611L)),

        // ── psy_bias_memory (искажения памяти и впечатления) ──────────────────
        WordEntity(
            id = 46606, original = "recency bias", transliteration = "[ˈriːsənsi ˈbaɪəs]", translation = "эффект свежести",
            definition = "Weighting the most recent thing you saw or heard far more than older, equally important pieces.",
            definitionNative = "Завышение веса самого свежего увиденного или услышанного на фоне столь же важного, но более раннего.",
            example = "Managers judge a whole year on the last quarter's numbers — recency bias quietly skews every review.",
            exampleNative = "Менеджеры судят о целом годе по цифрам последнего квартала — recency bias тихо искажает каждую оценку.",
            rarity = "RARE", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_memory", fillInBlankExclusions = listOf(46607L, 46608L, 46609L, 46610L)),
        WordEntity(
            id = 46607, original = "hindsight bias", transliteration = "[ˈhaɪndsaɪt ˈbaɪəs]", translation = "ретроспективное искажение",
            definition = "The feeling, after the outcome is known, that the result was obvious from the start all along.",
            definitionNative = "Ощущение задним числом, что известный исход был очевиден с самого начала.",
            example = "Every analyst now calls the 2008 crash predictable, but that is just hindsight bias talking loudly.",
            exampleNative = "Сейчас каждый аналитик называет крах 2008-го предсказуемым, но это просто hindsight bias громко говорит.",
            rarity = "RARE", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_memory", fillInBlankExclusions = listOf(46606L, 46608L, 46609L, 46610L)),
        WordEntity(
            id = 46608, original = "primacy effect", transliteration = "[ˈpraɪməsi ɪˈfekt]", translation = "эффект первого впечатления",
            definition = "The pull of the first items in a list or first moments of a meeting, which stick best in memory.",
            definitionNative = "Доминирование первых элементов списка или первых минут встречи в памяти и оценке.",
            example = "Interviewers judge candidates by the opening minute — primacy effect lingers the whole hour.",
            exampleNative = "Интервьюеры оценивают кандидатов в основном по первой минуте — primacy effect держится весь час.",
            rarity = "EPIC", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_memory", fillInBlankExclusions = listOf(46606L, 46607L, 46609L, 46610L)),
        WordEntity(
            id = 46609, original = "peak-end rule", transliteration = "[piːk end ruːl]", translation = "правило пика и конца",
            definition = "We judge an experience by its sharpest moment and how it ended, not by the average of the whole.",
            definitionNative = "Опыт оценивается по самому сильному моменту и финалу, а не по средней всех минут.",
            example = "A great dessert saves a slow dinner because the peak-end rule rewrites memory by the last bite.",
            exampleNative = "Отличный десерт спасает медленный ужин: peak-end rule переписывает память по последнему кусочку.",
            rarity = "EPIC", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_memory", fillInBlankExclusions = listOf(46606L, 46607L, 46608L, 46610L)),
        WordEntity(
            id = 46610, original = "negativity bias", transliteration = "[ˌneɡəˈtɪvəti ˈbaɪəs]", translation = "негативное искажение",
            definition = "The pull of bad news, harsh words and threats, which print onto memory deeper than equal good ones.",
            definitionNative = "Тяга к плохим новостям, резким словам и угрозам — они запоминаются глубже равных по силе хороших.",
            example = "One rude review weighs on the chef more than fifty kind ones — negativity bias at work.",
            exampleNative = "Один грубый отзыв давит на повара сильнее пятидесяти тёплых — negativity bias вшит в нас.",
            rarity = "RARE", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_memory", fillInBlankExclusions = listOf(46606L, 46607L, 46608L, 46609L)),

        // ── psy_bias_social (социальные искажения и группы) ───────────────────
        WordEntity(
            id = 46611, original = "attribution error", transliteration = "[ˌætrɪˈbjuːʃən ˈerər]", translation = "фундаментальная ошибка атрибуции",
            definition = "Blaming others' bad acts on their character while excusing your own by circumstances around you.",
            definitionNative = "Объяснение чужих ошибок их характером, а собственных — обстоятельствами вокруг.",
            example = "He thinks the late driver is rude, but he himself was late because of traffic — attribution error.",
            exampleNative = "Опоздавшего водителя он считает хамом, а сам опоздал из-за пробки — attribution error в чистом виде.",
            rarity = "EPIC", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_social", fillInBlankExclusions = listOf(46612L, 46613L, 46614L, 46615L)),
        WordEntity(
            id = 46612, original = "self-serving bias", transliteration = "[self ˈsɜːrvɪŋ ˈbaɪəs]", translation = "корыстное искажение",
            definition = "Crediting your wins to your own talent and pinning your losses on bad luck or other people.",
            definitionNative = "Приписывание успехов себе и своим талантам, а неудач — невезению или другим людям.",
            example = "The trader brags about good calls and blames the market for bad ones — pure self-serving bias.",
            exampleNative = "Трейдер хвастается удачными сделками и винит рынок за провальные — чистый self-serving bias.",
            rarity = "EPIC", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_social", fillInBlankExclusions = listOf(46611L, 46613L, 46614L, 46615L)),
        WordEntity(
            id = 46613, original = "in-group bias", transliteration = "[ɪn ɡruːp ˈbaɪəs]", translation = "внутригрупповой фаворитизм",
            definition = "The tendency to trust, defend and reward members of your own circle over people from outside it.",
            definitionNative = "Склонность доверять, защищать и поощрять своих в ущерб людям из других групп.",
            example = "Hiring managers wave through alumni of their own university — in-group bias is hard to shake off.",
            exampleNative = "Кадровики легко пропускают выпускников своего вуза — in-group bias тяжело вытряхнуть из головы.",
            rarity = "RARE", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_social", fillInBlankExclusions = listOf(46611L, 46612L, 46614L, 46615L)),
        WordEntity(
            id = 46614, original = "out-group homogeneity", transliteration = "[aʊt ɡruːp ˌhoʊmoʊdʒəˈniːəti]", translation = "однородность чужой группы",
            definition = "Seeing outsiders as much the same as each other, while seeing your own group as full of unique people.",
            definitionNative = "Восприятие чужой группы как «все одинаковые», а своей — как набора неповторимых личностей.",
            example = "Tourists say locals all act alike, but locals see clear variety — out-group homogeneity.",
            exampleNative = "Туристы говорят, что местные все одинаковы, а сами местные видят пёстрое разнообразие — out-group homogeneity.",
            rarity = "EPIC", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_social", fillInBlankExclusions = listOf(46611L, 46612L, 46613L, 46615L)),
        WordEntity(
            id = 46615, original = "false consensus effect", transliteration = "[fɔːls kənˈsensəs ɪˈfekt]", translation = "эффект ложного согласия",
            definition = "Overestimating how many people share your tastes, opinions and choices simply because they feel normal to you.",
            definitionNative = "Завышение оценки доли людей, разделяющих твои вкусы и взгляды, потому что себе они кажутся обычными.",
            example = "He assumed every colleague loved early meetings — false consensus effect tripped him up.",
            exampleNative = "Он решил, что ранние совещания нравятся всем коллегам — false consensus effect постоянно сбивает руководителей.",
            rarity = "EPIC", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_social", fillInBlankExclusions = listOf(46611L, 46612L, 46613L, 46614L)),

        // ── psy_bias_decision (искажения принятия решений) ────────────────────
        WordEntity(
            id = 46616, original = "sunk cost fallacy", transliteration = "[sʌŋk kɒst ˈfæləsi]", translation = "ошибка невозвратных затрат",
            definition = "Sticking with a losing project because of money or time already spent, not because the future looks good.",
            definitionNative = "Продолжение провального проекта из-за уже потраченных денег или времени, а не из-за будущей выгоды.",
            example = "After three failed startups he kept pouring money into the same idea — textbook sunk cost fallacy.",
            exampleNative = "После трёх провальных стартапов он продолжал вливать деньги в ту же идею — учебный sunk cost fallacy.",
            rarity = "RARE", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_decision", fillInBlankExclusions = listOf(46604L, 46605L, 46617L, 46618L, 46619L, 46620L, 46625L)),
        WordEntity(
            id = 46617, original = "status quo bias", transliteration = "[ˈsteɪtəs kwoʊ ˈbaɪəs]", translation = "склонность к сохранению статус-кво",
            definition = "Preferring whatever is already in place, even when a clearly better option is sitting right there.",
            definitionNative = "Предпочтение того, что уже есть, даже когда рядом лежит явно лучший вариант.",
            example = "Workers stay in the default pension plan for years — status quo bias quietly costs them real money.",
            exampleNative = "Сотрудники годами сидят в пенсионном плане по умолчанию — status quo bias тихо обходится им в реальные деньги.",
            rarity = "EPIC", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_decision", fillInBlankExclusions = listOf(46616L, 46618L, 46619L, 46620L)),
        WordEntity(
            id = 46618, original = "endowment effect", transliteration = "[ɪnˈdaʊmənt ɪˈfekt]", translation = "эффект владения",
            definition = "Valuing something more once you own it than you would pay to buy the very same thing fresh.",
            definitionNative = "Завышение цены вещи, которой уже владеешь, по сравнению с тем, сколько отдал бы за неё заново.",
            example = "Owners ask twice the market price for old cars they would never rebuy — endowment effect.",
            exampleNative = "Хозяева ставят двойную рыночную цену на старые машины, которые сами бы не купили — endowment effect в действии.",
            rarity = "EPIC", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_decision", fillInBlankExclusions = listOf(46616L, 46617L, 46619L, 46620L)),
        WordEntity(
            id = 46619, original = "IKEA effect", transliteration = "[aɪˈkiːə ɪˈfekt]", translation = "эффект ИКЕА",
            definition = "Placing extra value on furniture, code or food you built yourself, just because of the work you put in.",
            definitionNative = "Завышение ценности мебели, кода или блюда, собранных своими руками, из-за вложенного труда.",
            example = "Customers cherish the wobbly shelf they screwed together themselves — IKEA effect at work.",
            exampleNative = "Покупатели берегут шаткую полку, которую сами скрутили — IKEA effect окрашивает каждый взгляд на неё.",
            rarity = "EPIC", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_decision", fillInBlankExclusions = listOf(46616L, 46617L, 46618L, 46620L)),
        WordEntity(
            id = 46620, original = "ostrich effect", transliteration = "[ˈɑːstrɪtʃ ɪˈfekt]", translation = "эффект страуса",
            definition = "Ducking news you sense will be bad — unread medical letters, untouched bank statements, ignored alerts.",
            definitionNative = "Уход от информации, которая, по предчувствию, окажется плохой: непрочитанные письма врача, не открытые выписки.",
            example = "Investors stop opening brokerage apps in a crash — ostrich effect makes losses feel smaller.",
            exampleNative = "Инвесторы перестают открывать брокерские приложения в обвал — ostrich effect делает потерю как бы меньше.",
            rarity = "EPIC", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_decision", fillInBlankExclusions = listOf(46616L, 46617L, 46618L, 46619L)),

        // ── psy_bias_self (искажения самооценки и прогнозов) ──────────────────
        WordEntity(
            id = 46621, original = "dunning-kruger effect", transliteration = "[ˈdʌnɪŋ ˈkruːɡər ɪˈfekt]", translation = "эффект Даннинга — Крюгера",
            definition = "Beginners feel like experts because they lack the knowledge to see how much they actually do not know.",
            definitionNative = "Новички ощущают себя экспертами, потому что им не хватает знаний, чтобы увидеть, чего они не знают.",
            example = "After one weekend class he said he could build Twitter — dunning-kruger effect talking.",
            exampleNative = "После одних выходных на курсах он заявил, что напишет Твиттер — чистейший dunning-kruger effect говорит за него.",
            rarity = "EPIC", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_self", fillInBlankExclusions = listOf(46622L, 46623L, 46624L, 46625L)),
        WordEntity(
            id = 46622, original = "optimism bias", transliteration = "[ˈɑːptəmɪzəm ˈbaɪəs]", translation = "склонность к оптимизму",
            definition = "Belief that bad outcomes — crashes, divorces, illnesses — happen to other people, not personally to you.",
            definitionNative = "Уверенность, что плохое — аварии, разводы, болезни — случается с другими, а не лично с тобой.",
            example = "Young drivers skip seat belts: they assume crashes hit other people — optimism bias.",
            exampleNative = "Молодые водители забивают на ремни: они уверены, что аварии — проблема других — optimism bias во всей красе.",
            rarity = "RARE", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_self", fillInBlankExclusions = listOf(46621L, 46623L, 46624L, 46625L)),
        WordEntity(
            id = 46623, original = "planning fallacy", transliteration = "[ˈplænɪŋ ˈfæləsi]", translation = "ошибка планирования",
            definition = "Underestimating how long a task will take, even when past tasks of the same kind always ran longer.",
            definitionNative = "Занижение оценки времени на задачу, даже если прошлые такие же задачи всегда растягивались.",
            example = "He promised the renovation in a month — six months later the planning fallacy proves itself again.",
            exampleNative = "Он обещал ремонт за месяц — через полгода planning fallacy в очередной раз подтверждает себя.",
            rarity = "EPIC", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_self", fillInBlankExclusions = listOf(46621L, 46622L, 46624L, 46625L)),
        WordEntity(
            id = 46624, original = "illusory correlation", transliteration = "[ɪˈluːsəri ˌkɔːrəˈleɪʃən]", translation = "иллюзорная корреляция",
            definition = "Seeing a tie between two things that just happen to occur together, when no real link is there at all.",
            definitionNative = "Восприятие связи между двумя явлениями только потому, что они совпадают, при отсутствии настоящей связи.",
            example = "She wears a lucky shirt to every match and credits wins to it — illusory correlation.",
            exampleNative = "Она надевает счастливую рубашку на каждый матч и приписывает ей победы — illusory correlation плодит ритуалы.",
            rarity = "EPIC", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_self", fillInBlankExclusions = listOf(46621L, 46622L, 46623L, 46625L)),
        WordEntity(
            id = 46625, original = "survivorship bias", transliteration = "[sərˈvaɪvərʃɪp ˈbaɪəs]", translation = "ошибка выжившего",
            definition = "Drawing lessons only from the winners you can see, while the silent losers quietly skew every conclusion.",
            definitionNative = "Извлечение уроков только из видимых победителей, в то время как молчаливые проигравшие искажают вывод.",
            example = "Drop-out billionaires inspire copycats, but survivorship bias hides millions who failed.",
            exampleNative = "Миллиардеры-недоучки вдохновляют подражателей, но survivorship bias прячет миллионы бросивших и разорившихся.",
            rarity = "EPIC", setId = 466, languagePair = "en-ru", pos = "noun",
            semanticGroup = "psy_bias_self", fillInBlankExclusions = listOf(46604L, 46616L, 46621L, 46622L, 46623L, 46624L)),
    )
}
