package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity
import com.example.kartonki.data.db.entity.WordSetEntity

/**
 * English vocabulary — Политика (level 5, носитель языка).
 *
 * Set 331: «Политика: носитель языка» — высокая политическая лексика
 * (политтеория, дипломатия, формы власти и архаизмы C2+).
 *
 * Распределение редкости: 22 LEGENDARY + 3 EPIC — два смежных уровня шкалы.
 *
 * Дополняет уже существующие сеты темы «Политика»:
 *   - Set 330 (WordDataEnglishPoliticsL1.kt) — L1 COMMON (создаётся параллельно).
 *   - Set 236 (WordDataEnglishExpanded.kt)   — L2 COMMON/UNCOMMON.
 *   - Set 237 (WordDataEnglishExpanded.kt)   — L3 RARE/EPIC.
 *   - Set 75  (WordDataEnglish.kt)           — L4 EPIC (общественно-политические глаголы).
 *
 * Слова setId=331 не пересекаются ни с одним из этих наборов (проверено grep).
 *
 * SemanticGroups (5 × 5):
 *   politics_theory          — demagogue, demagoguery, statecraft, polity, ideologue
 *   politics_diplomacy       — rapprochement, detente, entente, communique, plenipotentiary
 *   politics_forms_of_rule   — tyranny, autocracy, despotism, ochlocracy, kleptocracy
 *   politics_archaic         — fiefdom, satrapy, vassalage, potentate, diktat
 *   politics_rhetoric        — suffrage, partisanship, plenary, junta, demarche
 *
 * Word IDs: 33101..33125 (setId × 100 + position).
 */
object WordDataEnglishPoliticsL5 {

    val sets: List<WordSetEntity> = listOf(
        WordSetEntity(
            id = 331, name = "Политика",
            description = "Высокая политическая лексика: политическая теория, дипломатия, архаизмы и редкая терминология",
            languagePair = "en-ru",
            topic = "Политика", level = 5),
    )

    val words: List<WordEntity> = listOf(

        // ── politics_theory (5) ───────────────────────────────────────────

        WordEntity(id = 33101, setId = 331, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "demagogue", transliteration = "[ˈdɛməˌɡɑɡ]", translation = "демагог (политик-популист)",
            definition = "A leader who whips up the crowd's fears and prejudices to gain power.",
            definitionNative = "Вождь, разжигающий страхи и предрассудки толпы ради собственной власти.",
            example = "The fiery demagogue won votes by blaming foreigners for every hardship.",
            exampleNative = "Пламенный demagogue собирал голоса, виня иностранцев во всех бедах.",
            pos = "noun", semanticGroup = "politics_theory",
            fillInBlankExclusions = listOf(33102L, 33105L)),

        WordEntity(id = 33102, setId = 331, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "demagoguery", transliteration = "[ˈdɛməˌɡɑɡəri]", translation = "демагогия (приёмы популиста)",
            definition = "Political talk that stirs base emotions instead of offering real arguments.",
            definitionNative = "Политическая риторика, давящая на низменные чувства вместо честных доводов.",
            example = "His speech was pure demagoguery, full of slogans but empty of policy.",
            exampleNative = "Его речь была чистая demagoguery — лозунги без единой реальной программы.",
            pos = "noun", semanticGroup = "politics_theory",
            fillInBlankExclusions = listOf(33101L)),

        WordEntity(id = 33103, setId = 331, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "statecraft", transliteration = "[ˈsteɪtˌkræft]", translation = "государственное искусство",
            definition = "The skilful art of governing a country and managing its affairs of state.",
            definitionNative = "Умелое искусство управлять страной и вести её государственные дела.",
            example = "The ageing chancellor was admired for his patient and shrewd statecraft.",
            exampleNative = "Стареющего канцлера ценили за терпеливое и проницательное statecraft.",
            pos = "noun", semanticGroup = "politics_theory", fillInBlankExclusions = listOf(33101L, 33102L, 33104L, 33105L)),

        WordEntity(id = 33104, setId = 331, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "polity", transliteration = "[ˈpɑləti]", translation = "форма государства / устройство",
            definition = "An organised society or community seen as a body that governs itself.",
            definitionNative = "Организованное общество или община, рассматриваемые как самоуправляющееся тело.",
            example = "The ancient Greek polity rested on the active life of free male citizens.",
            exampleNative = "Древнегреческое polity держалось на активной жизни свободных мужчин-граждан.",
            pos = "noun", semanticGroup = "politics_theory",
            fillInBlankExclusions = listOf(33103L)),

        WordEntity(id = 33105, setId = 331, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "ideologue", transliteration = "[ˈaɪdiəˌlɔɡ]", translation = "идеолог (фанатичный сторонник доктрины)",
            definition = "A person rigidly devoted to a political doctrine, valuing theory over reality.",
            definitionNative = "Человек, фанатично преданный политической доктрине и ставящий теорию выше жизни.",
            example = "Every senior post in the cabinet went to a hardline ideologue this time.",
            exampleNative = "Все ключевые посты в кабинете на этот раз достались жёсткому ideologue.",
            pos = "noun", semanticGroup = "politics_theory",
            fillInBlankExclusions = listOf(33101L)),

        // ── politics_diplomacy (5) ────────────────────────────────────────

        WordEntity(id = 33106, setId = 331, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "rapprochement", transliteration = "[ˌræprɒʃˈmɑ̃]", translation = "сближение (восстановление отношений)",
            definition = "A renewal of friendly ties between two states after a period of coldness.",
            definitionNative = "Возобновление дружественных отношений между двумя государствами после холода.",
            example = "Quiet diplomacy led to a slow rapprochement between the old rival capitals.",
            exampleNative = "Тихая дипломатия привела к медленному rapprochement между старыми соперниками.",
            pos = "noun", semanticGroup = "politics_diplomacy",
            fillInBlankExclusions = listOf(33107L, 33108L)),

        WordEntity(id = 33107, setId = 331, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "detente", transliteration = "[deɪˈtɑnt]", translation = "разрядка напряжённости",
            definition = "An easing of strained relations, especially between hostile powers.",
            definitionNative = "Ослабление напряжённости в отношениях, особенно между враждующими державами.",
            example = "The summit ushered in a brief detente during the long Cold War years.",
            exampleNative = "Саммит открыл короткую detente в долгие годы Холодной войны.",
            pos = "noun", semanticGroup = "politics_diplomacy",
            fillInBlankExclusions = listOf(33106L, 33108L)),

        WordEntity(id = 33108, setId = 331, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "entente", transliteration = "[ɑnˈtɑnt]", translation = "согласие (дружественный договор)",
            definition = "A friendly understanding between two governments that stops short of a treaty.",
            definitionNative = "Дружественная договорённость между двумя правительствами, не доходящая до договора.",
            example = "An informal entente bound the two western powers against the rising threat.",
            exampleNative = "Неформальное entente связывало две западные державы против растущей угрозы.",
            pos = "noun", semanticGroup = "politics_diplomacy",
            fillInBlankExclusions = listOf(33106L, 33107L)),

        WordEntity(id = 33109, setId = 331, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "communique", transliteration = "[kəˌmjunəˈkeɪ]", translation = "коммюнике (официальное заявление)",
            definition = "An official written statement issued after a meeting between governments.",
            definitionNative = "Официальное письменное заявление, выпускаемое после встречи правительств.",
            example = "The joint communique mentioned trade but said nothing of the border dispute.",
            exampleNative = "Совместное communique упомянуло торговлю, но обошло пограничный спор.",
            pos = "noun", semanticGroup = "politics_diplomacy", fillInBlankExclusions = listOf(33106L, 33107L, 33108L, 33110L, 33125L)),

        WordEntity(id = 33110, setId = 331, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "plenipotentiary", transliteration = "[ˌplɛnəpəˈtɛnʃiˌɛri]", translation = "полномочный представитель",
            definition = "An envoy who holds the full authority of his government to act and sign.",
            definitionNative = "Посланник, обладающий всей полнотой полномочий своего правительства на действия и подпись.",
            example = "A plenipotentiary was sent to Vienna with the power to sign the final treaty.",
            exampleNative = "В Вену отправили plenipotentiary с правом подписать итоговый договор.",
            pos = "noun", semanticGroup = "politics_diplomacy", fillInBlankExclusions = listOf(33101L, 33106L, 33107L, 33109L, 33119L)),

        // ── politics_forms_of_rule (5) ────────────────────────────────────

        WordEntity(id = 33111, setId = 331, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "tyranny", transliteration = "[ˈtɪrəni]", translation = "тирания (жестокое единовластие)",
            definition = "Cruel and absolute rule by one person who answers to no law or court.",
            definitionNative = "Жестокое и неограниченное правление одного, не подотчётного ни закону, ни суду.",
            example = "The pamphlet warned that unchecked power slides quickly into open tyranny.",
            exampleNative = "Памфлет предупреждал: бесконтрольная власть быстро скатывается в tyranny.",
            pos = "noun", semanticGroup = "politics_forms_of_rule",
            fillInBlankExclusions = listOf(33112L, 33113L)),

        WordEntity(id = 33112, setId = 331, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "autocracy", transliteration = "[ɔˈtɑkrəsi]", translation = "автократия (единоличное правление)",
            definition = "A system in which one ruler holds total power, unchecked by parliament or law.",
            definitionNative = "Система, где один правитель держит всю власть без сдерживания парламентом или законом.",
            example = "The reforms slowly turned a constitutional throne back into a personal autocracy.",
            exampleNative = "Реформы постепенно превратили конституционный трон обратно в autocracy.",
            pos = "noun", semanticGroup = "politics_forms_of_rule",
            fillInBlankExclusions = listOf(33111L, 33113L)),

        WordEntity(id = 33113, setId = 331, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "despotism", transliteration = "[ˈdɛspəˌtɪzəm]", translation = "деспотизм (произвол правителя)",
            definition = "Government by a ruler who acts on personal will, ignoring rights and custom.",
            definitionNative = "Правление по личной воле правителя, попирающее права и обычаи подданных.",
            example = "Enlightened thinkers feared that benevolent reform could mask quiet despotism.",
            exampleNative = "Просветители боялись, что мягкие реформы скроют тихий despotism.",
            pos = "noun", semanticGroup = "politics_forms_of_rule",
            fillInBlankExclusions = listOf(33111L, 33112L)),

        WordEntity(id = 33114, setId = 331, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "ochlocracy", transliteration = "[ɒkˈlɒkrəsi]", translation = "охлократия (власть толпы)",
            definition = "Mob rule — government driven by the passions of the unruly crowd.",
            definitionNative = "Власть толпы — правление, движимое страстями буйной массы.",
            example = "Classical writers warned that pure democracy might collapse into ochlocracy.",
            exampleNative = "Античные авторы остерегали: чистая демократия может скатиться в ochlocracy.",
            pos = "noun", semanticGroup = "politics_forms_of_rule",
            fillInBlankExclusions = listOf(33115L)),

        WordEntity(id = 33115, setId = 331, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "kleptocracy", transliteration = "[klɛpˈtɑkrəsi]", translation = "клептократия (власть воров)",
            definition = "Rule by leaders who use public office mainly to steal from the treasury.",
            definitionNative = "Правление, при котором руководители используют пост в основном для расхищения казны.",
            example = "Auditors uncovered a kleptocracy where every minister had a foreign account.",
            exampleNative = "Аудиторы раскрыли kleptocracy: у каждого министра был зарубежный счёт.",
            pos = "noun", semanticGroup = "politics_forms_of_rule",
            fillInBlankExclusions = listOf(33114L)),

        // ── politics_archaic (5) ──────────────────────────────────────────

        WordEntity(id = 33116, setId = 331, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "fiefdom", transliteration = "[ˈfifdəm]", translation = "феод (вотчина вассала)",
            definition = "Land granted by a lord to a vassal in return for service and loyalty.",
            definitionNative = "Земля, дарованная сеньором вассалу в обмен на службу и верность.",
            example = "The young knight inherited a small fiefdom on the wooded northern frontier.",
            exampleNative = "Молодой рыцарь унаследовал небольшое fiefdom на лесистой северной границе.",
            pos = "noun", semanticGroup = "politics_archaic",
            fillInBlankExclusions = listOf(33117L, 33118L)),

        WordEntity(id = 33117, setId = 331, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "satrapy", transliteration = "[ˈseɪtrəpi]", translation = "сатрапия (провинция Персии)",
            definition = "A province of the old Persian empire, ruled by a governor for the king.",
            definitionNative = "Провинция древней Персидской империи под управлением наместника от имени царя.",
            example = "Each satrapy paid heavy tribute every year to the royal court at Susa.",
            exampleNative = "Каждая satrapy ежегодно платила тяжёлую дань царскому двору в Сузах.",
            pos = "noun", semanticGroup = "politics_archaic",
            fillInBlankExclusions = listOf(33116L, 33118L)),

        WordEntity(id = 33118, setId = 331, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "vassalage", transliteration = "[ˈvæsəlɪʤ]", translation = "вассальная зависимость",
            definition = "The bound state of a lesser lord who owes service and loyalty to a greater one.",
            definitionNative = "Связанное положение младшего владыки, обязанного службой и верностью старшему.",
            example = "Sworn vassalage tied the duke firmly to the distant king for life.",
            exampleNative = "Принесённое vassalage прочно связывало герцога с далёким королём пожизненно.",
            pos = "noun", semanticGroup = "politics_archaic",
            fillInBlankExclusions = listOf(33116L, 33117L)),

        WordEntity(id = 33119, setId = 331, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "potentate", transliteration = "[ˈpoʊtənˌteɪt]", translation = "властитель (могущественный правитель)",
            definition = "A mighty ruler, especially one of an old eastern realm with absolute power.",
            definitionNative = "Могущественный правитель, особенно древнего восточного царства с абсолютной властью.",
            example = "The eastern potentate received the embassy in a hall hung with golden silk.",
            exampleNative = "Восточный potentate принял посольство в зале, увешанном золотым шёлком.",
            pos = "noun", semanticGroup = "politics_archaic", fillInBlankExclusions = listOf(33101L, 33105L, 33110L, 33116L, 33117L, 33118L, 33120L)),

        WordEntity(id = 33120, setId = 331, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "diktat", transliteration = "[dɪkˈtɑt]", translation = "диктат (навязанное условие)",
            definition = "A harsh order forced upon a defeated party with no room for any discussion.",
            definitionNative = "Жёсткое повеление, навязанное побеждённой стороне без права на обсуждение.",
            example = "The treaty was less a settlement than a diktat handed down by the victors.",
            exampleNative = "Договор был не соглашением, а diktat, спущенным победителями сверху.",
            pos = "noun", semanticGroup = "politics_archaic", fillInBlankExclusions = listOf(33109L, 33116L, 33117L, 33118L, 33119L, 33125L)),

        // ── politics_rhetoric (5) ─────────────────────────────────────────

        WordEntity(id = 33121, setId = 331, languagePair = "en-ru", rarity = "EPIC",
            original = "suffrage", transliteration = "[ˈsəfrɪʤ]", translation = "избирательное право",
            definition = "The legal right of a citizen to take part in elections by casting a vote.",
            definitionNative = "Юридическое право гражданина участвовать в выборах, подавая свой голос.",
            example = "Women in that country won universal suffrage only after the second war.",
            exampleNative = "Женщины той страны добились всеобщего suffrage лишь после второй войны.",
            pos = "noun", semanticGroup = "politics_rhetoric", fillInBlankExclusions = listOf(33122L, 33124L, 33125L)),

        WordEntity(id = 33122, setId = 331, languagePair = "en-ru", rarity = "EPIC",
            original = "partisanship", transliteration = "[ˈpɑrtəzənˌʃɪp]", translation = "партийная пристрастность",
            definition = "Strong, biased loyalty to one party that blocks fair judgement of issues.",
            definitionNative = "Сильная пристрастная преданность одной партии, мешающая беспристрастной оценке.",
            example = "Bitter partisanship in the chamber blocked even routine budget agreements.",
            exampleNative = "Жёсткая partisanship в зале блокировала даже рутинные соглашения по бюджету.",
            pos = "noun", semanticGroup = "politics_rhetoric", fillInBlankExclusions = listOf(33102L, 33121L, 33124L, 33125L)),

        WordEntity(id = 33123, setId = 331, languagePair = "en-ru", rarity = "EPIC",
            original = "plenary", transliteration = "[ˈplinəri]", translation = "пленарный (общий, в полном составе)",
            definition = "Attended by all members entitled to be present — a full session of a body.",
            definitionNative = "С участием всех имеющих право присутствовать членов — полная сессия органа.",
            example = "The motion passed only at the plenary meeting after weeks of small debates.",
            exampleNative = "Резолюцию приняли только на plenary заседании после недель мелких споров.",
            pos = "adjective", semanticGroup = "politics_rhetoric"),

        WordEntity(id = 33124, setId = 331, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "junta", transliteration = "[ˈhʊntə]", translation = "хунта (военное правительство)",
            definition = "A small group of military officers who seize power and rule a country together.",
            definitionNative = "Небольшая группа военных, захвативших власть и правящих страной сообща.",
            example = "The ruling junta dissolved the parliament and arrested the elected ministers.",
            exampleNative = "Правящая junta распустила парламент и арестовала избранных министров.",
            pos = "noun", semanticGroup = "politics_rhetoric", fillInBlankExclusions = listOf(33101L, 33105L, 33111L, 33112L, 33113L, 33114L, 33115L, 33119L, 33121L, 33122L, 33125L)),

        WordEntity(id = 33125, setId = 331, languagePair = "en-ru", rarity = "LEGENDARY",
            original = "demarche", transliteration = "[deɪˈmɑrʃ]", translation = "демарш (дипломатический жест)",
            definition = "A formal diplomatic step taken by one government to protest to another.",
            definitionNative = "Официальный дипломатический шаг одного правительства, выражающий протест другому.",
            example = "The ambassador made a sharp demarche over the treatment of his citizens.",
            exampleNative = "Посол совершил резкий demarche из-за обращения с его гражданами.",
            pos = "noun", semanticGroup = "politics_rhetoric", fillInBlankExclusions = listOf(33109L, 33121L, 33122L, 33124L)),
    )
}
