def w(id, orig, trans, rarity, setId, pos, sg, defn, ex):
    d = defn.replace('"', '\\"')
    e = ex.replace('"', '\\"')
    return (f'        WordEntity(id = {id}, original = "{orig}", translation = "{trans}", '
            f'rarity = "{rarity}", setId = {setId}, languagePair = "en-ru", pos = "{pos}", '
            f'semanticGroup = "{sg}",\n'
            f'            definition = "{d}",\n'
            f'            example = "{e}"),\n')

words_j = []
words_k = []

wid = 3076

# SET 200 basics — 13 new COMMON/UNCOMMON
words_j += [
    w(wid+0,  "basket",        "корзина (для покупок)",      "COMMON",   200, "noun", "shopping", "A container used for carrying items while shopping.", "She picked up a basket at the entrance to the shop."),
    w(wid+1,  "weight",        "вес",                        "COMMON",   200, "noun", "shopping", "The heaviness of a product, often shown on the label.", "Check the weight on the packet before buying."),
    w(wid+2,  "fresh",         "свежий",                     "COMMON",   200, "adj",  "shopping", "Recently produced and not preserved or frozen.", "Always buy fresh fruit and vegetables when possible."),
    w(wid+3,  "tin",           "консервная банка",           "UNCOMMON", 200, "noun", "shopping", "A sealed metal container used to preserve food.", "She bought two tins of tomatoes for the sauce."),
    w(wid+4,  "packet",        "пакет / упаковка",           "UNCOMMON", 200, "noun", "shopping", "A small container or wrapper for goods.", "A packet of biscuits costs about a pound."),
    w(wid+5,  "loaf",          "буханка",                    "UNCOMMON", 200, "noun", "shopping", "A shaped mass of bread baked as a single unit.", "Could you pick up a loaf of bread on your way home?"),
    w(wid+6,  "section",       "отдел (магазина)",           "UNCOMMON", 200, "noun", "shopping", "A part of a store dedicated to a particular type of product.", "The dairy section is at the back of the supermarket."),
    w(wid+7,  "price tag",     "ценник",                     "UNCOMMON", 200, "noun", "shopping", "A label attached to an item showing its price.", "She checked the price tag before putting it in the basket."),
    w(wid+8,  "self-checkout", "касса самообслуживания",     "UNCOMMON", 200, "noun", "shopping", "A machine that lets customers scan and pay for items themselves.", "The self-checkout queue was shorter than the staffed tills."),
    w(wid+9,  "carton",        "картонная упаковка / пачка", "UNCOMMON", 200, "noun", "shopping", "A box made of cardboard used to package food or drink.", "Please recycle the carton after finishing the juice."),
    w(wid+10, "shelf life",    "срок годности",              "UNCOMMON", 200, "noun", "shopping", "The length of time a product can be stored before it spoils.", "The shelf life of this yoghurt is only five days."),
    w(wid+11, "portion",       "порция",                     "UNCOMMON", 200, "noun", "shopping", "The amount of food suitable for one person.", "The portion size on the packet feeds two people."),
    w(wid+12, "reusable bag",  "многоразовая сумка",         "UNCOMMON", 200, "noun", "shopping", "A durable bag designed to be used many times instead of plastic bags.", "Bring a reusable bag to avoid paying for plastic ones."),
]
wid += 13

# SET 201 basics — 10 new COMMON/UNCOMMON
words_j += [
    w(wid+0, "paint",  "краска",             "COMMON",   201, "noun", "tools", "A coloured liquid applied to surfaces to colour or protect them.", "We need two tins of paint for the living room walls."),
    w(wid+1, "brush",  "кисть",              "COMMON",   201, "noun", "tools", "A tool with bristles used for painting or cleaning.", "Use a wide brush to cover large areas quickly."),
    w(wid+2, "rope",   "верёвка",            "COMMON",   201, "noun", "tools", "A thick strong cord made of twisted fibres.", "Tie the rope tightly around the post."),
    w(wid+3, "bucket", "ведро",              "COMMON",   201, "noun", "tools", "An open container with a handle used to carry liquids.", "Fill the bucket with warm water and add some detergent."),
    w(wid+4, "hook",   "крючок",             "COMMON",   201, "noun", "tools", "A curved piece of metal or plastic for hanging things.", "Hang your coat on the hook by the door."),
    w(wid+5, "glue",   "клей",               "UNCOMMON", 201, "noun", "tools", "A sticky substance used to join things together.", "Apply glue to both surfaces and press them firmly together."),
    w(wid+6, "hinge",  "петля (дверная)",    "UNCOMMON", 201, "noun", "tools", "A jointed fitting that allows a door or lid to swing open.", "The hinge is loose — we need to tighten the screws."),
    w(wid+7, "plank",  "доска",              "UNCOMMON", 201, "noun", "tools", "A long flat piece of timber.", "Lay the planks side by side to make the floor."),
    w(wid+8, "latch",  "щеколда / задвижка", "UNCOMMON", 201, "noun", "tools", "A fastening on a door or gate that can be lifted to open it.", "Push the latch down to open the garden gate."),
    w(wid+9, "spring", "пружина",            "UNCOMMON", 201, "noun", "tools", "A coiled piece of metal that returns to its shape after being compressed.", "The spring inside the mechanism was broken."),
]
wid += 10

# SET 202 basics — 7 new COMMON/UNCOMMON
words_j += [
    w(wid+0, "gift",   "подарок",              "COMMON",   202, "noun", "celebrations", "Something given to someone as a present.", "She wrapped the gift in colourful paper."),
    w(wid+1, "party",  "вечеринка / праздник", "COMMON",   202, "noun", "celebrations", "A social event at which people enjoy themselves.", "We are having a party to celebrate her birthday."),
    w(wid+2, "cake",   "торт / пирог",         "COMMON",   202, "noun", "celebrations", "A sweet baked food often decorated and served at celebrations.", "The birthday cake had twenty candles on top."),
    w(wid+3, "dance",  "танец",                "COMMON",   202, "noun", "celebrations", "Moving rhythmically to music, especially at a celebration.", "Everyone joined in the dance at the wedding reception."),
    w(wid+4, "ribbon", "лента",                "UNCOMMON", 202, "noun", "celebrations", "A long narrow strip of fabric used as decoration.", "She tied a red ribbon around the gift box."),
    w(wid+5, "banner", "баннер / транспарант", "UNCOMMON", 202, "noun", "celebrations", "A large piece of cloth with a message, hung at events.", "The banner above the stage read Happy New Year."),
    w(wid+6, "theme",  "тема (праздника)",     "UNCOMMON", 202, "noun", "celebrations", "A subject or idea that gives a party a distinctive character.", "The party theme was tropical, so guests wore bright colours."),
]
wid += 7

# SET 203 basics — 11 new COMMON/UNCOMMON
words_j += [
    w(wid+0,  "teacher",     "учитель",            "COMMON",   203, "noun", "professions", "A person who educates students in a school.", "The teacher explained the grammar rule very clearly."),
    w(wid+1,  "doctor",      "врач",               "COMMON",   203, "noun", "professions", "A person qualified to treat people who are ill.", "She went to see the doctor about her sore throat."),
    w(wid+2,  "nurse",       "медсестра / медбрат","COMMON",   203, "noun", "professions", "A person trained to care for sick or injured people.", "The nurse checked the patient's temperature every hour."),
    w(wid+3,  "driver",      "водитель",           "COMMON",   203, "noun", "professions", "A person who drives a vehicle as a job.", "The bus driver waited for all passengers to board."),
    w(wid+4,  "farmer",      "фермер",             "COMMON",   203, "noun", "professions", "A person who grows crops or raises animals for food.", "The farmer woke up at dawn to feed the animals."),
    w(wid+5,  "waiter",      "официант",           "COMMON",   203, "noun", "professions", "A person who serves food and drinks in a restaurant.", "The waiter brought the menus and listed the daily specials."),
    w(wid+6,  "firefighter", "пожарный",           "UNCOMMON", 203, "noun", "professions", "A person trained to put out fires and rescue people.", "The firefighters arrived within minutes of the emergency call."),
    w(wid+7,  "engineer",    "инженер",            "UNCOMMON", 203, "noun", "professions", "A person who designs or builds machines or structures.", "The engineer inspected the bridge for structural damage."),
    w(wid+8,  "lawyer",      "адвокат / юрист",    "UNCOMMON", 203, "noun", "professions", "A person qualified to advise on legal matters.", "She hired a lawyer to represent her in court."),
    w(wid+9,  "receptionist","ресепционист",        "UNCOMMON", 203, "noun", "professions", "A person who greets visitors and answers phones in an office.", "The receptionist directed them to the waiting room."),
    w(wid+10, "librarian",   "библиотекарь",       "UNCOMMON", 203, "noun", "professions", "A person who manages a library and helps people find books.", "Ask the librarian if you need help finding a reference book."),
]
wid += 11

# SET 204 basics — 11 new COMMON/UNCOMMON
words_j += [
    w(wid+0,  "sink",      "раковина",           "COMMON",   204, "noun", "home", "A fixed basin with a water supply, used for washing.", "Leave the dishes in the sink and I will wash them later."),
    w(wid+1,  "lamp",      "лампа",              "COMMON",   204, "noun", "home", "A device that produces light.", "Turn on the lamp — it is getting dark in here."),
    w(wid+2,  "rug",       "ковёр / коврик",     "COMMON",   204, "noun", "home", "A small carpet that covers part of a floor.", "The dog likes to sleep on the rug in front of the fireplace."),
    w(wid+3,  "shelf",     "полка",              "COMMON",   204, "noun", "home", "A flat board fixed to a wall for storing things.", "Put the books on the shelf above the desk."),
    w(wid+4,  "drawer",    "ящик (стола/шкафа)", "UNCOMMON", 204, "noun", "home", "A sliding box-shaped compartment in a piece of furniture.", "The scissors are in the top drawer of the desk."),
    w(wid+5,  "cloth",     "тряпка / ткань",     "UNCOMMON", 204, "noun", "home", "A piece of fabric used for cleaning or wiping surfaces.", "Wipe the counter with a damp cloth."),
    w(wid+6,  "mould",     "плесень",            "UNCOMMON", 204, "noun", "home", "A fungus that grows in damp conditions.", "Check the bathroom walls for mould every few weeks."),
    w(wid+7,  "drain",     "слив / канализация", "UNCOMMON", 204, "noun", "home", "A pipe that carries away waste water.", "The drain is blocked — we need to call a plumber."),
    w(wid+8,  "thermostat","термостат",          "UNCOMMON", 204, "noun", "home", "A device that automatically controls temperature.", "Set the thermostat to 20 degrees to save energy."),
    w(wid+9,  "plug",      "вилка / пробка",     "UNCOMMON", 204, "noun", "home", "A device that connects an appliance to an electrical socket.", "Pull out the plug before you leave the house."),
    w(wid+10, "grease",    "жир / смазка",       "UNCOMMON", 204, "noun", "home", "An oily substance used to lubricate parts or found in cooking residue.", "Clean the grease off the cooker with a degreasing spray."),
]
wid += 11

# SET 206 basics — 13 new COMMON/UNCOMMON
words_j += [
    w(wid+0,  "film",       "фильм",              "COMMON",   206, "noun", "cinema", "A story recorded as moving images shown on a screen.", "Let us watch a film tonight — any preferences?"),
    w(wid+1,  "actor",      "актёр",              "COMMON",   206, "noun", "cinema", "A person who performs a role in a film or play.", "The lead actor won an award for his performance."),
    w(wid+2,  "cinema",     "кинотеатр",          "COMMON",   206, "noun", "cinema", "A building where films are shown to the public.", "The cinema in town has twelve screens."),
    w(wid+3,  "seat",       "место (в зале)",     "COMMON",   206, "noun", "cinema", "A chair in a theatre or cinema.", "We reserved seats in the front row."),
    w(wid+4,  "screen",     "экран",              "COMMON",   206, "noun", "cinema", "The flat surface on which films are projected.", "The image on the screen was incredibly sharp."),
    w(wid+5,  "audience",   "зрители / аудитория","UNCOMMON", 206, "noun", "cinema", "The people gathered to watch a performance.", "The audience applauded enthusiastically at the end of the play."),
    w(wid+6,  "role",       "роль",               "UNCOMMON", 206, "noun", "cinema", "A character played by an actor.", "She landed the lead role in the new thriller."),
    w(wid+7,  "performance","выступление / спектакль","UNCOMMON",206,"noun","cinema","An act of presenting a play to an audience.", "The evening performance starts at eight o'clock."),
    w(wid+8,  "rehearsal",  "репетиция",          "UNCOMMON", 206, "noun", "cinema", "A practice session for a performance.", "The director called an extra rehearsal before opening night."),
    w(wid+9,  "script",     "сценарий",           "UNCOMMON", 206, "noun", "cinema", "The written text of a film or play.", "She spent months writing the script for the short film."),
    w(wid+10, "interval",   "антракт",            "UNCOMMON", 206, "noun", "cinema", "A pause between acts of a play.", "We bought ice cream during the interval."),
    w(wid+11, "comedy",     "комедия",            "UNCOMMON", 206, "noun", "cinema", "A film or play intended to make the audience laugh.", "He prefers comedy to drama when choosing a film."),
    w(wid+12, "act",        "акт / действие",     "UNCOMMON", 206, "noun", "cinema", "A division of a play or opera.", "The twist in the final act shocked everyone."),
]
wid += 13

# SET 208 basics — 20 new COMMON/UNCOMMON
words_j += [
    w(wid+0,  "flower",  "цветок",              "COMMON",   208, "noun", "gardening", "The colourful part of a plant that produces seeds.", "She planted flowers along the path to the front door."),
    w(wid+1,  "seed",    "семя",                "COMMON",   208, "noun", "gardening", "A small object produced by a plant from which a new plant can grow.", "Sow the seeds in early spring for summer flowers."),
    w(wid+2,  "grass",   "трава",               "COMMON",   208, "noun", "gardening", "Low green plants that cover lawns and fields.", "Cut the grass before it gets too long."),
    w(wid+3,  "soil",    "почва / земля",       "COMMON",   208, "noun", "gardening", "The top layer of the earth in which plants grow.", "Mix compost into the soil before planting."),
    w(wid+4,  "plant",   "растение",            "COMMON",   208, "noun", "gardening", "A living organism that grows in soil and has leaves.", "Water the plant every two days in summer."),
    w(wid+5,  "garden",  "сад / огород",        "COMMON",   208, "noun", "gardening", "An outdoor area where plants are grown.", "She spent the weekend tidying the garden."),
    w(wid+6,  "water",   "поливать",            "COMMON",   208, "verb", "gardening", "To pour water onto plants or soil.", "Remember to water the tomatoes every evening."),
    w(wid+7,  "grow",    "выращивать",          "COMMON",   208, "verb", "gardening", "To cultivate a plant or allow it to develop.", "We grow our own herbs on the kitchen windowsill."),
    w(wid+8,  "leaf",    "лист растения",       "COMMON",   208, "noun", "gardening", "A flat green part of a plant that grows from a stem.", "The leaves turned yellow in autumn."),
    w(wid+9,  "tree",    "дерево",              "COMMON",   208, "noun", "gardening", "A tall plant with a wooden trunk and branches.", "The apple tree in the garden produces fruit every year."),
    w(wid+10, "dig",     "копать",              "UNCOMMON", 208, "verb", "gardening", "To break up and move soil with a tool.", "Dig the soil to a depth of 30 cm before planting potatoes."),
    w(wid+11, "rake",    "грабли",              "UNCOMMON", 208, "noun", "gardening", "A garden tool with a long handle and teeth for gathering leaves.", "Rake up the fallen leaves and add them to the compost."),
    w(wid+12, "pot",     "горшок (цветочный)",  "UNCOMMON", 208, "noun", "gardening", "A container in which plants are grown.", "Move the pot indoors before the first frost."),
    w(wid+13, "trim",    "подрезать / стричь",  "UNCOMMON", 208, "verb", "gardening", "To cut away unwanted parts of a plant to keep it tidy.", "Trim the hedge once a month in summer."),
    w(wid+14, "bloom",   "цвести / цветение",   "UNCOMMON", 208, "verb", "gardening", "To produce flowers; the state of flowering.", "Roses bloom from late spring through to autumn."),
    w(wid+15, "root",    "корень",              "UNCOMMON", 208, "noun", "gardening", "The part of a plant that grows underground and absorbs water.", "The roots of the old oak tree spread far underground."),
    w(wid+16, "branch",  "ветка",               "UNCOMMON", 208, "noun", "gardening", "A part of a tree that grows from the main trunk.", "Prune the lower branches to let more light into the garden."),
    w(wid+17, "petal",   "лепесток",            "UNCOMMON", 208, "noun", "gardening", "One of the coloured parts of a flower.", "Rose petals fell gently onto the path."),
    w(wid+18, "stem",    "стебель",             "UNCOMMON", 208, "noun", "gardening", "The main stalk of a plant that supports its leaves and flowers.", "Cut the stem at an angle so the flower can absorb water."),
    w(wid+19, "thorn",   "шип",                 "UNCOMMON", 208, "noun", "gardening", "A sharp pointed growth on the stem of a plant.", "Be careful of the thorns when pruning rose bushes."),
]
wid += 20

# SET 209 basics — 10 new COMMON/UNCOMMON
words_j += [
    w(wid+0, "email",      "электронная почта",   "COMMON",   209, "noun", "internet", "Electronic messages sent over the internet.", "Send me an email with the details of the meeting."),
    w(wid+1, "profile",    "профиль",             "COMMON",   209, "noun", "internet", "A personal page on a social network showing your information.", "Update your profile with a recent photo."),
    w(wid+2, "post",       "пост / публикация",   "UNCOMMON", 209, "noun", "internet", "A piece of content published on a social media platform.", "Her post about the trip got hundreds of likes."),
    w(wid+3, "share",      "делиться / репостить","UNCOMMON", 209, "verb", "internet", "To repost or distribute content to your own followers.", "If you liked the article, share it with your friends."),
    w(wid+4, "like",       "лайк",                "UNCOMMON", 209, "noun", "internet", "A positive reaction button on social media.", "The video got over a million likes in one day."),
    w(wid+5, "comment",    "комментарий",         "UNCOMMON", 209, "noun", "internet", "A written response left below a post or video.", "Leave a comment below if you have any questions."),
    w(wid+6, "chat",       "чат",                 "UNCOMMON", 209, "noun", "internet", "Real-time text communication over the internet.", "We stayed in touch through a group chat."),
    w(wid+7, "video call", "видеозвонок",         "UNCOMMON", 209, "noun", "internet", "A phone call in which you can see the other person on screen.", "They had a video call every Sunday to catch up."),
    w(wid+8, "feed",       "лента (новостей)",    "UNCOMMON", 209, "noun", "internet", "A continuously updated list of posts on a social media platform.", "Scroll through your feed to see the latest updates."),
    w(wid+9, "account",    "аккаунт",             "UNCOMMON", 209, "noun", "internet", "A registered user profile on a website or app.", "Create an account to access all the features."),
]
wid += 10

# SET 219 basics — 19 new COMMON/UNCOMMON
words_j += [
    w(wid+0,  "gas",        "газ",                "COMMON",   219, "noun", "chemistry", "A substance that expands to fill any container.", "Carbon dioxide is a gas released when fuels burn."),
    w(wid+1,  "liquid",     "жидкость",           "COMMON",   219, "noun", "chemistry", "A substance that flows freely and takes the shape of its container.", "Water is the most common liquid on Earth."),
    w(wid+2,  "solid",      "твёрдое тело",       "COMMON",   219, "noun", "chemistry", "A substance with a fixed shape that does not flow.", "Ice is the solid form of water."),
    w(wid+3,  "metal",      "металл",             "COMMON",   219, "noun", "chemistry", "A material such as iron that conducts electricity and heat.", "Iron is a metal that rusts when exposed to moisture."),
    w(wid+4,  "heat",       "тепло / нагрев",     "COMMON",   219, "noun", "chemistry", "Energy that causes a rise in temperature.", "Applying heat to the substance causes it to melt."),
    w(wid+5,  "test",       "опыт / испытание",   "COMMON",   219, "noun", "chemistry", "A procedure carried out to check a scientific hypothesis.", "The litmus test shows whether a solution is acid or alkaline."),
    w(wid+6,  "base",       "основание",          "UNCOMMON", 219, "noun", "chemistry", "A chemical that neutralises an acid to form a salt.", "Sodium hydroxide is a strong base used in many reactions."),
    w(wid+7,  "salt",       "соль (химическая)",  "UNCOMMON", 219, "noun", "chemistry", "A compound formed when an acid reacts with a base.", "Common table salt is sodium chloride."),
    w(wid+8,  "oxygen",     "кислород",           "UNCOMMON", 219, "noun", "chemistry", "A colourless gas that makes up about 21% of the atmosphere.", "Oxygen is essential for combustion and respiration."),
    w(wid+9,  "hydrogen",   "водород",            "UNCOMMON", 219, "noun", "chemistry", "The lightest element, which combines with oxygen to form water.", "Hydrogen burns easily and is used as a fuel."),
    w(wid+10, "carbon",     "углерод",            "UNCOMMON", 219, "noun", "chemistry", "An element found in all living things and fossil fuels.", "Carbon forms the backbone of organic molecules."),
    w(wid+11, "solution",   "раствор",            "UNCOMMON", 219, "noun", "chemistry", "A liquid mixture in which a substance is evenly dissolved.", "Add the salt to the water to make a saline solution."),
    w(wid+12, "mixture",    "смесь",              "UNCOMMON", 219, "noun", "chemistry", "A combination of two or more substances not chemically joined.", "Sand and water form a mixture, not a compound."),
    w(wid+13, "experiment", "эксперимент",        "UNCOMMON", 219, "noun", "chemistry", "A scientific test to discover or prove something.", "The experiment confirmed the hypothesis about reaction rates."),
    w(wid+14, "dissolve",   "растворять(ся)",     "UNCOMMON", 219, "verb", "chemistry", "To mix completely with a liquid and become part of it.", "Sugar dissolves quickly in warm water."),
    w(wid+15, "burn",       "гореть / сжигать",   "UNCOMMON", 219, "verb", "chemistry", "To undergo combustion, producing heat and light.", "The magnesium ribbon burns with a bright white flame."),
    w(wid+16, "particle",   "частица",            "UNCOMMON", 219, "noun", "chemistry", "A very small piece of matter.", "Heat causes particles to move faster."),
    w(wid+17, "density",    "плотность",          "UNCOMMON", 219, "noun", "chemistry", "The mass of a substance per unit of volume.", "Gold has a much higher density than water."),
    w(wid+18, "formula",    "формула (химическая)","UNCOMMON",219, "noun", "chemistry", "A combination of symbols representing a chemical compound.", "The formula for water is H2O."),
]
wid += 19

print(f"wordsJ done: {len(words_j)} words, next ID: {wid}")

# ── ADVANCED SETS ──────────────────────────────────────────────────────────

# SET 240 advanced — 11 new RARE/EPIC
words_k += [
    w(wid+0,  "markdown",    "уценка / снижение цены",      "RARE", 240, "noun", "retail", "A reduction in the selling price of an item.", "The markdown on winter coats was fifty percent."),
    w(wid+1,  "turnover",    "товарооборот / выручка",      "RARE", 240, "noun", "retail", "The total sales revenue of a business over a period.", "Annual turnover rose by twelve percent last year."),
    w(wid+2,  "shrinkage",   "потери товара (кражи, порча)","RARE", 240, "noun", "retail", "The loss of inventory due to theft or damage.", "Shrinkage accounts for two percent of annual revenue."),
    w(wid+3,  "margin",      "маржа / прибыль",             "RARE", 240, "noun", "retail", "The difference between the cost of a product and its selling price.", "The profit margin on fresh produce is typically low."),
    w(wid+4,  "markup",      "наценка",                     "RARE", 240, "noun", "retail", "The amount added to the cost price to set the selling price.", "A 40% markup covers overhead costs and profit."),
    w(wid+5,  "stock-take",  "инвентаризация",              "RARE", 240, "noun", "retail", "The process of counting all items held in a store.", "The store closes on Sunday night for the monthly stock-take."),
    w(wid+6,  "net weight",  "вес нетто",                   "RARE", 240, "noun", "retail", "The weight of a product excluding its packaging.", "The net weight of cereal in the box is 500 g."),
    w(wid+7,  "supplier",    "поставщик",                   "RARE", 240, "noun", "retail", "A company that provides goods or materials to a retailer.", "The supplier delivered the new stock on Tuesday morning."),
    w(wid+8,  "supply chain","цепочка поставок",            "EPIC", 240, "noun", "retail", "The entire sequence of processes involved in producing and distributing a product.", "Disruptions to the supply chain raised prices globally."),
    w(wid+9,  "footfall",    "посещаемость (магазина)",     "EPIC", 240, "noun", "retail", "The number of people entering a shop or shopping centre.", "Footfall increased sharply during the Christmas period."),
    w(wid+10, "loss leader", "товар-приманка",              "EPIC", 240, "noun", "retail", "A product sold at a low profit to attract customers.", "Supermarkets use milk as a loss leader to bring in shoppers."),
]
wid += 11

# SET 241 advanced — 16 new RARE/EPIC/LEGENDARY
words_k += [
    w(wid+0,  "soldering iron","паяльник",                   "RARE",      241, "noun", "tools", "A hand tool used to melt solder and join electronic components.", "Use the soldering iron carefully to avoid burning the circuit board."),
    w(wid+1,  "lathe",        "токарный станок",             "RARE",      241, "noun", "tools", "A machine that rotates a workpiece so a cutting tool can shape it.", "The lathe turned the wooden block into a smooth cylinder."),
    w(wid+2,  "jigsaw",       "лобзик",                      "RARE",      241, "noun", "tools", "A power tool with a narrow blade used to cut curves in wood.", "Use a jigsaw to cut the curved shapes for the shelf supports."),
    w(wid+3,  "angle grinder","болгарка",                    "RARE",      241, "noun", "tools", "A handheld power tool used for cutting and grinding.", "Wear safety goggles when using an angle grinder."),
    w(wid+4,  "plane",        "рубанок",                     "RARE",      241, "noun", "tools", "A woodworking tool used to shave thin layers from a surface.", "Run the plane along the door edge to make it fit the frame."),
    w(wid+5,  "rasp",         "рашпиль",                     "RARE",      241, "noun", "tools", "A coarse file with raised teeth for shaping wood.", "Shape the curve with a rasp before sanding smooth."),
    w(wid+6,  "rivet",        "заклёпка",                    "RARE",      241, "noun", "tools", "A metal pin used to join two pieces of material permanently.", "Aircraft panels are held together with thousands of rivets."),
    w(wid+7,  "brace",        "распорка / скоба",            "RARE",      241, "noun", "tools", "A device that holds two things firmly together in position.", "Fit a diagonal brace to stop the frame from racking."),
    w(wid+8,  "blowtorch",    "паяльная лампа",              "EPIC",      241, "noun", "tools", "A device that produces a hot flame for soldering or stripping paint.", "The plumber used a blowtorch to sweat the copper joints."),
    w(wid+9,  "tile cutter",  "плиткорез",                   "EPIC",      241, "noun", "tools", "A tool used to score and snap ceramic tiles to size.", "Score the tile with the tile cutter before snapping it along the line."),
    w(wid+10, "router",       "фрезер",                      "EPIC",      241, "noun", "tools", "A power tool used to hollow out or shape an area of wood.", "Use the router to cut the groove for the shelf panel."),
    w(wid+11, "pneumatic drill","отбойный молоток",           "EPIC",      241, "noun", "tools", "A power tool driven by compressed air for breaking up hard surfaces.", "The workers used a pneumatic drill to break up the old concrete."),
    w(wid+12, "torque wrench","динамометрический ключ",       "LEGENDARY", 241, "noun", "tools", "A wrench that applies a specific torque to a fastener.", "Always tighten wheel bolts to the specified torque with a torque wrench."),
    w(wid+13, "mitre saw",    "торцовочная пила",             "LEGENDARY", 241, "noun", "tools", "A power saw used to make accurate crosscuts and mitre cuts in wood.", "Cut the skirting boards to 45 degrees with a mitre saw."),
    w(wid+14, "calibrate",    "калибровать",                  "LEGENDARY", 241, "verb", "tools", "To adjust an instrument to make it accurate.", "Calibrate the torque wrench before each use."),
    w(wid+15, "dovetail",     "ласточкин хвост (соединение)","LEGENDARY", 241, "noun", "tools", "A strong interlocking joint used in furniture-making.", "The drawer sides were joined with hand-cut dovetails."),
]
wid += 16

# SET 242 advanced — 18 new RARE/EPIC/LEGENDARY
words_k += [
    w(wid+0,  "gala",         "торжественный вечер",         "RARE",      242, "noun", "celebrations", "A festive occasion with special entertainment or performances.", "The charity gala raised over fifty thousand pounds."),
    w(wid+1,  "banquet",      "банкет",                      "RARE",      242, "noun", "celebrations", "A grand formal meal for many people.", "The state banquet was attended by heads of government."),
    w(wid+2,  "memorial",     "траурный / памятный",         "RARE",      242, "adj",  "celebrations", "Relating to remembering a person or event from the past.", "A memorial service was held at the cathedral."),
    w(wid+3,  "inaugural",    "инаугурационный",             "RARE",      242, "adj",  "celebrations", "Relating to the beginning of an important role or period.", "The inaugural ceremony marked the opening of the new museum."),
    w(wid+4,  "pageant",      "красочное шествие",           "RARE",      242, "noun", "celebrations", "An elaborate public entertainment or display.", "The medieval pageant attracted thousands of spectators."),
    w(wid+5,  "rite",         "обряд",                       "RARE",      242, "noun", "celebrations", "A religious or solemn ceremony or act.", "Baptism is an important rite in many Christian traditions."),
    w(wid+6,  "ovation",      "овация",                      "RARE",      242, "noun", "celebrations", "A long enthusiastic round of applause.", "The audience gave the conductor a standing ovation."),
    w(wid+7,  "festivity",    "торжество / праздничность",   "RARE",      242, "noun", "celebrations", "The celebration of something in a joyful manner.", "The street was full of festivity on New Year's Eve."),
    w(wid+8,  "eulogy",       "надгробная / хвалебная речь", "EPIC",      242, "noun", "celebrations", "A speech praising someone, typically at their funeral.", "He delivered a moving eulogy that brought many to tears."),
    w(wid+9,  "jubilee",      "юбилей (особый)",             "EPIC",      242, "noun", "celebrations", "A special anniversary, especially a 25th or 50th.", "The company celebrated its golden jubilee with a grand party."),
    w(wid+10, "consecration", "освящение / посвящение",      "EPIC",      242, "noun", "celebrations", "The act of making something sacred in a religious ceremony.", "The consecration of the new church drew hundreds of worshippers."),
    w(wid+11, "commemoration","увековечение памяти",         "EPIC",      242, "noun", "celebrations", "An official ceremony that preserves the memory of a person or event.", "The commemoration of the battle took place at dawn."),
    w(wid+12, "pomp",         "пышность / помпа",            "EPIC",      242, "noun", "celebrations", "Ceremony and splendid display associated with great occasions.", "The royal wedding was celebrated with great pomp and pageantry."),
    w(wid+13, "benediction",  "благословение",               "EPIC",      242, "noun", "celebrations", "The utterance of a blessing, especially at the end of a service.", "The priest gave a benediction at the close of the ceremony."),
    w(wid+14, "exuberance",   "ликование / бурная радость",  "EPIC",      242, "noun", "celebrations", "The quality of being full of energy, excitement, and cheerfulness.", "The crowd greeted the victory with unrestrained exuberance."),
    w(wid+15, "panegyric",    "панегирик",                   "LEGENDARY", 242, "noun", "celebrations", "A public speech praising someone enthusiastically.", "The ambassador delivered a panegyric in honour of the retiring diplomat."),
    w(wid+16, "solemnity",    "торжественность",             "LEGENDARY", 242, "noun", "celebrations", "The quality of being serious and dignified in tone or manner.", "The solemnity of the occasion demanded respectful silence."),
    w(wid+17, "extravaganza", "экстраваганца",               "LEGENDARY", 242, "noun", "celebrations", "An elaborate and spectacular entertainment or production.", "The closing ceremony was a musical extravaganza."),
]
wid += 18

# SET 243 advanced — 14 new RARE/EPIC/LEGENDARY
words_k += [
    w(wid+0,  "magistrate",    "магистрат / мировой судья",  "RARE",      243, "noun", "professions", "A civil officer who administers the law.", "The case was heard by a magistrate in the local court."),
    w(wid+1,  "underwriter",   "андеррайтер",                "RARE",      243, "noun", "professions", "A person who assesses and assumes financial risk.", "The underwriter evaluated the insurance application carefully."),
    w(wid+2,  "osteopath",     "остеопат",                   "RARE",      243, "noun", "professions", "A practitioner who treats conditions by manipulating the musculoskeletal framework.", "The osteopath treated her chronic back pain with gentle manipulation."),
    w(wid+3,  "surveyor",      "геодезист / инспектор",      "RARE",      243, "noun", "professions", "A person who measures and maps land or inspects buildings.", "The surveyor identified several structural problems with the property."),
    w(wid+4,  "metallurgist",  "металлург",                  "RARE",      243, "noun", "professions", "A scientist who studies the properties and processing of metals.", "The metallurgist analysed the composition of the alloy."),
    w(wid+5,  "toxicologist",  "токсиколог",                 "EPIC",      243, "noun", "professions", "A scientist who studies the adverse effects of chemicals on living organisms.", "The toxicologist determined the cause of the poisoning."),
    w(wid+6,  "neurologist",   "невролог",                   "EPIC",      243, "noun", "professions", "A doctor specialising in disorders of the nervous system.", "The neurologist ordered an MRI to investigate the symptoms."),
    w(wid+7,  "forensic scientist","судебный эксперт",        "EPIC",      243, "noun", "professions", "A scientist who applies scientific methods to criminal investigations.", "The forensic scientist analysed the evidence collected at the scene."),
    w(wid+8,  "geophysicist",  "геофизик",                   "EPIC",      243, "noun", "professions", "A scientist who studies the physical properties of the Earth.", "The geophysicist used seismic waves to map underground structures."),
    w(wid+9,  "cryptographer", "криптограф",                 "EPIC",      243, "noun", "professions", "A specialist in the theory and practice of writing or solving codes.", "The cryptographer designed an encryption algorithm for the secure service."),
    w(wid+10, "biostatistician","биостатистик",              "LEGENDARY", 243, "noun", "professions", "A specialist who applies statistics to biological and medical research.", "The biostatistician designed the clinical trial analysis plan."),
    w(wid+11, "palaeontologist","палеонтолог",               "LEGENDARY", 243, "noun", "professions", "A scientist who studies fossil plants and animals.", "The palaeontologist discovered a previously unknown species of dinosaur."),
    w(wid+12, "numismatist",   "нумизмат",                   "LEGENDARY", 243, "noun", "professions", "A collector or expert in coins and medals.", "The numismatist authenticated the rare Roman denarius."),
    w(wid+13, "lexicographer", "лексикограф",                "LEGENDARY", 243, "noun", "professions", "A person who compiles dictionaries.", "Samuel Johnson was one of the most famous lexicographers in English history."),
]
wid += 14

# SET 244 advanced — 15 new RARE/EPIC/LEGENDARY
words_k += [
    w(wid+0,  "damp-proof course","гидроизоляционный слой",  "RARE",      244, "noun", "home", "A layer of waterproof material in a wall that prevents moisture rising.", "The damp-proof course must be intact to keep the walls dry."),
    w(wid+1,  "joinery",      "столярные изделия",           "RARE",      244, "noun", "home", "Items made by a joiner, such as doors, windows, and staircases.", "The quality of the joinery throughout the house was excellent."),
    w(wid+2,  "cavity wall",  "двойная стена (с полостью)",  "RARE",      244, "noun", "home", "A wall built of two leaves with a gap between them for insulation.", "The cavity wall insulation keeps the house warmer in winter."),
    w(wid+3,  "downpipe",     "водосточная труба",           "RARE",      244, "noun", "home", "A pipe that carries rainwater from a gutter to a drain.", "The downpipe was blocked with leaves, causing the gutter to overflow."),
    w(wid+4,  "rendering",    "штукатурная отделка фасада",  "RARE",      244, "noun", "home", "A coat of plaster applied to the outside of a wall.", "The exterior rendering was cracked and needed replacing."),
    w(wid+5,  "dado rail",    "горизонтальный молдинг",      "RARE",      244, "noun", "home", "A horizontal moulding fixed to a wall at about waist height.", "The dado rail divides the wallpaper from the painted lower half."),
    w(wid+6,  "ridge tile",   "конёк (крыши)",               "RARE",      244, "noun", "home", "A tile used to cover the ridge of a roof.", "Several ridge tiles were dislodged by the storm."),
    w(wid+7,  "fascia board", "подшивочная доска (карниза)", "RARE",      244, "noun", "home", "A board fixed horizontally at the edge of a roof to support the guttering.", "Replace the rotten fascia board before fitting new gutters."),
    w(wid+8,  "alcove",       "ниша (в стене)",              "EPIC",      244, "noun", "home", "A recess in the wall of a room, often used to fit shelving.", "They built bookshelves in the alcoves on either side of the fireplace."),
    w(wid+9,  "architrave",   "наличник / обналичка",        "EPIC",      244, "noun", "home", "The moulding around a door or window frame.", "Sand down the architrave before applying a fresh coat of paint."),
    w(wid+10, "soffit",       "подшив / потолок свеса",      "EPIC",      244, "noun", "home", "The underside of an architectural element such as an arch or overhang.", "The soffit beneath the stairs was painted white to brighten the space."),
    w(wid+11, "coving",       "потолочный карниз / лепнина", "EPIC",      244, "noun", "home", "A curved junction between the wall and ceiling, usually moulded.", "Decorative coving was added to the living room to give it a period feel."),
    w(wid+12, "fenestration", "остекление / расположение окон","EPIC",    244, "noun", "home", "The arrangement of windows and doors in a building.", "The fenestration on the south facade maximises natural light."),
    w(wid+13, "inglenook",    "ниша у камина",               "LEGENDARY", 244, "noun", "home", "A recess on either side of a large fireplace.", "The inglenook fireplace with its wooden beams gave the cottage great character."),
    w(wid+14, "wainscoting",  "дощатая обшивка стен",        "LEGENDARY", 244, "noun", "home", "Wooden panelling lining the lower part of an interior wall.", "The dining room featured original Victorian wainscoting painted in dark green."),
]
wid += 15

# SET 245 advanced — 11 new RARE/EPIC/LEGENDARY
words_k += [
    w(wid+0,  "voice-over",  "закадровый голос",            "RARE",      245, "noun", "cinema", "A narration recorded for a film but not seen on screen.", "The documentary used a voice-over to explain the historical context."),
    w(wid+1,  "storyboard",  "раскадровка",                 "RARE",      245, "noun", "cinema", "A series of drawings showing the planned sequence of shots in a film.", "The director sketched the storyboard before shooting began."),
    w(wid+2,  "score",       "саундтрек / музыкальная тема","RARE",      245, "noun", "cinema", "The music composed for a film or theatrical production.", "The score by Ennio Morricone perfectly captured the mood of the film."),
    w(wid+3,  "grip",        "грип (технический специалист)","RARE",     245, "noun", "cinema", "A member of a film crew responsible for camera movement equipment.", "The grip rigged the dolly tracks for the tracking shot."),
    w(wid+4,  "continuity",  "монтажная непрерывность",     "RARE",      245, "noun", "cinema", "The consistency of details in a film from one shot to the next.", "The continuity error was spotted by eagle-eyed viewers."),
    w(wid+5,  "mise-en-scene","мизансцена",                 "EPIC",      245, "noun", "cinema", "The visual arrangement of elements within a film frame.", "The director's use of mise-en-scene conveyed isolation without dialogue."),
    w(wid+6,  "auteur",      "автор-режиссёр",              "EPIC",      245, "noun", "cinema", "A filmmaker with a strong personal style regarded as the creative author of a film.", "Kubrick is regarded as the ultimate auteur of the twentieth century."),
    w(wid+7,  "narrative arc","нарративная дуга",           "EPIC",      245, "noun", "cinema", "The chronological construction of plot in a film or story.", "The narrative arc of the trilogy builds to a satisfying climax."),
    w(wid+8,  "cinematheque","синематека",                  "EPIC",      245, "noun", "cinema", "An archive or library of films, often with a screening programme.", "She discovered the classic films at the city's cinematheque."),
    w(wid+9,  "diegetic",    "диегетический",               "LEGENDARY", 245, "adj",  "cinema", "Relating to sound or elements that exist within the world of the narrative.", "The music played on the radio in the scene is diegetic sound."),
    w(wid+10, "didascalia",  "дидаскалия (ремарки автора)", "LEGENDARY", 245, "noun", "cinema", "Stage directions and authorial notes in a dramatic script.", "The didascalia specified that the actor should face the audience at this moment."),
]
wid += 11

# SET 246 advanced — 6 new RARE/EPIC/LEGENDARY
words_k += [
    w(wid+0, "photosynthesis","фотосинтез",                 "RARE",      246, "noun", "botany", "The process by which plants use sunlight to produce food from carbon dioxide and water.", "Photosynthesis takes place mainly in the leaves of a plant."),
    w(wid+1, "chlorophyll",   "хлорофилл",                  "RARE",      246, "noun", "botany", "The green pigment in plants that absorbs light for photosynthesis.", "Leaves lose their chlorophyll in autumn, revealing red and yellow pigments."),
    w(wid+2, "transpiration", "транспирация",               "EPIC",      246, "noun", "botany", "The process by which plants release water vapour through their leaves.", "Transpiration helps cool the plant and transport nutrients upward."),
    w(wid+3, "mycorrhiza",    "микориза",                   "LEGENDARY", 246, "noun", "botany", "A symbiotic association between a fungus and the roots of a plant.", "Mycorrhiza networks help trees share nutrients across a forest."),
    w(wid+4, "allelopathy",   "аллелопатия",                "LEGENDARY", 246, "noun", "botany", "The influence of a plant on neighbours through chemical secretions.", "Walnut trees practise allelopathy, inhibiting the growth of plants beneath them."),
    w(wid+5, "phytoremediation","фиторемедиация",           "LEGENDARY", 246, "noun", "botany", "The use of plants to remove pollutants from soil or water.", "Phytoremediation was used to clean up the contaminated site."),
]
wid += 6

# SET 247 advanced — 15 new RARE/EPIC/LEGENDARY
words_k += [
    w(wid+0,  "VPN",              "виртуальная частная сеть",   "RARE",      247, "noun", "cybersecurity", "A service that encrypts your internet connection and hides your IP address.", "Use a VPN when connecting to public Wi-Fi to stay secure."),
    w(wid+1,  "cloud storage",    "облачное хранилище",         "RARE",      247, "noun", "cybersecurity", "An online service that stores digital files on remote servers.", "Back up your photos to cloud storage so you never lose them."),
    w(wid+2,  "two-factor auth",  "двухфакторная аутентификация","RARE",     247, "noun", "cybersecurity", "A security process requiring two forms of verification to log in.", "Enable two-factor auth on all important accounts."),
    w(wid+3,  "API",              "программный интерфейс",      "RARE",      247, "noun", "cybersecurity", "A set of rules that allows different software applications to communicate.", "The app fetches weather data through a public API."),
    w(wid+4,  "cookie",           "куки (данные браузера)",     "RARE",      247, "noun", "cybersecurity", "A small file stored by a website on your browser to remember preferences.", "Clear your cookies regularly to protect your privacy."),
    w(wid+5,  "backdoor",         "бэкдор",                     "RARE",      247, "noun", "cybersecurity", "A hidden method of bypassing normal authentication in a system.", "Attackers installed a backdoor to maintain persistent access."),
    w(wid+6,  "debug",            "отладка / дебаггинг",        "RARE",      247, "verb", "cybersecurity", "To identify and remove errors from computer software.", "The developer spent hours trying to debug the faulty code."),
    w(wid+7,  "cryptography",     "криптография",               "EPIC",      247, "noun", "cybersecurity", "The practice of securing communications through codes and ciphers.", "Modern cryptography underlies all secure internet transactions."),
    w(wid+8,  "distributed system","распределённая система",    "EPIC",      247, "noun", "cybersecurity", "A network of computers that work together and appear as a single system.", "Blockchain is an example of a distributed system with no central authority."),
    w(wid+9,  "microservices",    "микросервисы",               "EPIC",      247, "noun", "cybersecurity", "An architectural approach where an application is built as small independent services.", "The company migrated from a monolithic application to microservices."),
    w(wid+10, "load balancer",    "балансировщик нагрузки",     "EPIC",      247, "noun", "cybersecurity", "A system that distributes network traffic across multiple servers.", "The load balancer prevented any single server from being overwhelmed."),
    w(wid+11, "reverse proxy",    "обратный прокси-сервер",     "EPIC",      247, "noun", "cybersecurity", "A server that forwards client requests to backend servers.", "The reverse proxy handles SSL termination and caching."),
    w(wid+12, "containerisation", "контейнеризация",            "LEGENDARY", 247, "noun", "cybersecurity", "The packaging of software and its dependencies into isolated units called containers.", "Docker popularised containerisation among software developers."),
    w(wid+13, "end-to-end encryption","сквозное шифрование",    "LEGENDARY", 247, "noun", "cybersecurity", "A system where only the communicating users can read the messages.", "End-to-end encryption ensures that not even the service provider can read your messages."),
    w(wid+14, "zero-knowledge proof","доказательство с нулевым разглашением","LEGENDARY",247,"noun","cybersecurity","A cryptographic method that proves knowledge of a fact without revealing the fact itself.", "Zero-knowledge proofs are used in privacy-preserving cryptocurrencies."),
]
wid += 15

# SET 248 advanced — 6 new RARE/EPIC/LEGENDARY
words_k += [
    w(wid+0, "isomer",          "изомер",               "RARE",      248, "noun", "chemistry", "One of two or more compounds with the same molecular formula but different structures.", "Glucose and fructose are isomers of each other."),
    w(wid+1, "chromatography",  "хроматография",        "EPIC",      248, "noun", "chemistry", "A technique for separating mixtures by passing them through a medium.", "Paper chromatography revealed four different pigments in the ink."),
    w(wid+2, "stoichiometry",   "стехиометрия",         "LEGENDARY", 248, "noun", "chemistry", "The calculation of relative quantities of reactants and products in chemical reactions.", "Stoichiometry allows chemists to predict how much product a reaction will yield."),
    w(wid+3, "electronegativity","электроотрицательность","LEGENDARY",248, "noun", "chemistry", "The tendency of an atom to attract electrons in a chemical bond.", "Fluorine has the highest electronegativity of all elements."),
    w(wid+4, "spectroscopy",    "спектроскопия",        "LEGENDARY", 248, "noun", "chemistry", "The study of the interaction between matter and electromagnetic radiation.", "Mass spectroscopy identified the unknown compound in the mixture."),
    w(wid+5, "thermodynamics",  "термодинамика",        "LEGENDARY", 248, "noun", "chemistry", "The branch of physics concerned with heat and its relation to other forms of energy.", "The second law of thermodynamics states that entropy always increases."),
]
wid += 6

print(f"wordsK done: {len(words_k)} words, final ID: {wid - 1}")
print(f"Total new words: {len(words_j) + len(words_k)}")

# Generate Kotlin and append to file
wordsJ_kt = '    private fun wordsJ(): List<WordEntity> = listOf(\n' + ''.join(words_j) + '    )\n'
wordsK_kt = '    private fun wordsK(): List<WordEntity> = listOf(\n' + ''.join(words_k) + '    )\n'

filepath = "app/src/main/java/com/example/kartonki/data/SeedDataEnglishMore.kt"
with open(filepath, "r", encoding="utf-8") as f:
    content = f.read()

content = content.rstrip()
assert content.endswith('}'), f"Expected file to end with }}, got: {content[-20:]!r}"
content = content[:-1]  # remove final }
content += '\n' + wordsJ_kt + '\n' + wordsK_kt + '\n}\n'

with open(filepath, "w", encoding="utf-8") as f:
    f.write(content)

print(f"File updated successfully")
