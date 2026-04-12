/**
 * Appends missing words to TSV files to bring every group to 25 words.
 * Run: node fill_words.js
 */
const fs = require('fs');
const path = require('path');
const ASSETS = 'app/src/main/assets';

// Read all existing words to avoid duplicates
function readAll() {
  const seen = new Set();
  for (const f of ['words_a1','words_a2','words_b1','words_b2','words_c1','words_c2']) {
    const lines = fs.readFileSync(path.join(ASSETS,f+'.tsv'),'utf8').split('\n').slice(1).filter(l=>l.trim());
    for (const l of lines) { const w = l.split('\t')[1]; if (w) seen.add(w.trim().toLowerCase()); }
  }
  return seen;
}

// T = tab-separated row builder
const T = (level,word,pos,sg,ru,def,ex) => [level,word,pos,sg,ru,def,ex].join('\t');

function main() {
  const existing = readAll();
  const appends = { words_a1:[], words_a2:[], words_b1:[], words_b2:[], words_c1:[], words_c2:[] };

  function add(file, rows) {
    for (const r of rows) {
      const word = r.split('\t')[1].trim().toLowerCase();
      if (!existing.has(word)) { appends[file].push(r); existing.add(word); }
    }
  }

  // ─── A1 colours (need 12 more) ──────────────────────────────────────────────
  add('words_a1', [
    T('A1','orange','adjective','colours','оранжевый','Having the colour between red and yellow.','She wore an orange jacket so people could see her easily.'),
    T('A1','purple','adjective','colours','фиолетовый','Having a colour made by mixing red and blue.','He painted the wall purple for his daughter\'s room.'),
    T('A1','pink','adjective','colours','розовый','Having a pale red colour.','She bought pink flowers for her mother\'s birthday.'),
    T('A1','grey','adjective','colours','серый','Having the colour between black and white, like clouds.','The sky was grey all day and it rained in the evening.'),
    T('A1','brown','adjective','colours','коричневый','Having the colour of wood or chocolate.','He has brown hair and brown eyes.'),
    T('A1','dark','adjective','colours','тёмный','Not having much light, or deep in colour.','She chose a dark blue dress for the formal event.'),
    T('A1','light','adjective','colours','светлый','Pale in colour, not dark.','He prefers light colours like cream and pale yellow.'),
    T('A1','bright','adjective','colours','яркий','Having a strong, vivid colour that is easy to see.','She wore a bright red coat that everyone noticed.'),
    T('A1','pale','adjective','colours','бледный','Having a colour that is not strong or bright.','The walls were painted pale blue to make the room feel calm.'),
    T('A1','colourful','adjective','colours','красочный','Having many bright and different colours.','The market was full of colourful fruits and vegetables.'),
    T('A1','golden','adjective','colours','золотой','Having the colour of gold, a bright yellow-orange.','The golden leaves fell from the trees in autumn.'),
    T('A1','silver','adjective','colours','серебристый','Having the shiny grey-white colour of silver metal.','She wore silver earrings to match her grey dress.'),
  ]);

  // ─── A1 home (need 6 more) ──────────────────────────────────────────────────
  add('words_a1', [
    T('A1','floor','noun','home','пол','The flat surface you walk on inside a building.','The children sat on the floor to play with their toys.'),
    T('A1','wall','noun','home','стена','A flat vertical surface that forms the side of a room.','She hung a painting on the wall above the sofa.'),
    T('A1','sofa','noun','home','диван','A long soft seat with a back and arms for two or more people.','They sat on the sofa and watched a film together.'),
    T('A1','lamp','noun','home','лампа','A device that produces light, used to light a room.','She turned on the lamp to read her book in the evening.'),
    T('A1','mirror','noun','home','зеркало','A flat piece of glass that reflects images.','He looked in the mirror before going out.'),
    T('A1','clock','noun','home','часы','A device that shows what time it is, usually fixed to a wall.','The clock on the wall showed that it was already ten.'),
  ]);

  // ─── A1 numbers (need 6 more) ───────────────────────────────────────────────
  add('words_a1', [
    T('A1','four','number','numbers','четыре','The number 4.','She has four brothers and one sister.'),
    T('A1','five','number','numbers','пять','The number 5.','He woke up at five o\'clock every morning for work.'),
    T('A1','six','number','numbers','шесть','The number 6.','There are six people in my family.'),
    T('A1','seven','number','numbers','семь','The number 7.','A week has seven days.'),
    T('A1','twenty','number','numbers','двадцать','The number 20.','She is twenty years old today.'),
    T('A1','thousand','number','numbers','тысяча','The number 1000.','About a thousand people came to the concert.'),
  ]);

  // ─── A1 education (need 5 more) ─────────────────────────────────────────────
  add('words_a1', [
    T('A1','class','noun','education','класс','A group of students who learn together at the same level.','There are thirty students in my class.'),
    T('A1','lesson','noun','education','урок','A period of time when a teacher teaches a group of students.','The maths lesson starts at nine o\'clock.'),
    T('A1','homework','noun','education','домашнее задание','School work that students do at home.','She did her homework before watching television.'),
    T('A1','pencil','noun','education','карандаш','A thin stick of wood used for writing or drawing.','He drew the picture with a pencil.'),
    T('A1','notebook','noun','education','тетрадь','A book with blank or lined pages for writing.','She wrote all the new words in her notebook.'),
  ]);

  // ─── A1 animals (need 5 more) ───────────────────────────────────────────────
  add('words_a1', [
    T('A1','rabbit','noun','animals','кролик','A small animal with long ears that hops.','The children fed the rabbit in the garden.'),
    T('A1','cow','noun','animals','корова','A large farm animal kept for milk and meat.','The cow stood in the field eating grass.'),
    T('A1','sheep','noun','animals','овца','A farm animal with thick wool, kept for meat and wool.','The farmer had fifty sheep on his land.'),
    T('A1','lion','noun','animals','лев','A large wild cat that lives in Africa.','The lion slept under a tree in the afternoon sun.'),
    T('A1','elephant','noun','animals','слон','The largest land animal, with a long nose called a trunk.','The elephant used its trunk to drink water from the river.'),
  ]);

  // ─── A1 body (need 4 more) ──────────────────────────────────────────────────
  add('words_a1', [
    T('A1','arm','noun','body','рука (рука целиком)','The long part of your body from your shoulder to your hand.','She broke her arm when she fell off her bicycle.'),
    T('A1','back','noun','body','спина','The part of your body between your neck and your bottom.','He hurt his back lifting heavy boxes at work.'),
    T('A1','stomach','noun','body','желудок','The organ inside your body where food goes after you eat.','His stomach hurt because he ate too fast.'),
    T('A1','shoulder','noun','body','плечо','The joint between your arm and the top of your body.','She carried her bag over her left shoulder.'),
  ]);

  // ─── A1 family (need 2 more) ────────────────────────────────────────────────
  add('words_a1', [
    T('A1','wife','noun','family','жена','A woman to whom a man is married.','His wife is a doctor at the local hospital.'),
    T('A1','cousin','noun','family','двоюродный брат/сестра','A child of your aunt or uncle.','My cousin lives in another city but we meet at holidays.'),
  ]);

  // ─── A1 food (need 1 more) ──────────────────────────────────────────────────
  add('words_a1', [
    T('A1','fish','noun','food','рыба','An animal that lives in water and is eaten as food.','They had grilled fish for dinner at the seaside restaurant.'),
  ]);

  // ─── A2 work (need 8 more) ──────────────────────────────────────────────────
  add('words_a2', [
    T('A2','job','noun','work','работа','The regular work that you do to earn money.','She got a new job at a bank after finishing university.'),
    T('A2','office','noun','work','офис','A room or building where people work at desks.','He works in an office in the city centre.'),
    T('A2','boss','noun','work','начальник','The person who is in charge of a workplace.','Her boss gave her more responsibilities after six months.'),
    T('A2','salary','noun','work','зарплата','The money you receive regularly for doing your job.','He was happy because his salary increased this year.'),
    T('A2','colleague','noun','work','коллега','A person who works with you in the same place.','She had lunch with her colleagues every Friday.'),
    T('A2','meeting','noun','work','совещание','A planned occasion when people come together to discuss something.','The meeting lasted two hours and everyone was tired.'),
    T('A2','interview','noun','work','собеседование','A formal meeting where someone is asked questions for a job.','She prepared carefully for the job interview the night before.'),
    T('A2','uniform','noun','work','форма','Special clothes worn for a particular job or school.','The nurses at the hospital wear a white uniform.'),
  ]);

  // ─── A2 health (need 6 more) ────────────────────────────────────────────────
  add('words_a2', [
    T('A2','headache','noun','health','головная боль','A pain in your head that can last a long time.','She took a tablet because she had a bad headache.'),
    T('A2','cold','noun','health','простуда','A common illness that makes you sneeze and have a runny nose.','He stayed at home because he had a cold.'),
    T('A2','temperature','noun','health','температура','A measure of how hot or cold the body is when ill.','The doctor checked the child\'s temperature with a thermometer.'),
    T('A2','pill','noun','health','таблетка','A small solid piece of medicine that you swallow.','She took a pill every morning with a glass of water.'),
    T('A2','appointment','noun','health','запись к врачу','A planned time to meet a doctor or other professional.','He made an appointment with the dentist for Friday afternoon.'),
    T('A2','allergy','noun','health','аллергия','A medical condition where your body reacts badly to something.','She has an allergy to cats and starts sneezing near them.'),
  ]);

  // ─── A2 technology (need 4 more) ────────────────────────────────────────────
  add('words_a2', [
    T('A2','screen','noun','technology','экран','The flat surface of a phone, computer, or TV that shows images.','He stared at the screen for hours without a break.'),
    T('A2','battery','noun','technology','батарея','The part of a device that stores electrical energy.','Her phone stopped working because the battery was flat.'),
    T('A2','password','noun','technology','пароль','A secret word or letters used to get access to a computer.','He forgot his password and could not log into his account.'),
    T('A2','message','noun','technology','сообщение','A piece of information sent from one person to another.','She sent a message to her friend to say she was late.'),
  ]);

  // ─── A2 travel (need 4 more) ────────────────────────────────────────────────
  add('words_a2', [
    T('A2','passport','noun','travel','паспорт','An official document you need to enter another country.','He could not board the plane because he forgot his passport.'),
    T('A2','suitcase','noun','travel','чемодан','A large bag with a hard outside used for carrying clothes when you travel.','She packed her suitcase the night before the flight.'),
    T('A2','hotel','noun','travel','гостиница','A building where you pay to stay when you are away from home.','They stayed at a comfortable hotel near the beach.'),
    T('A2','flight','noun','travel','рейс','A journey made by plane.','Their flight was delayed by two hours due to bad weather.'),
  ]);

  // ─── A2 transport (need 3 more) ─────────────────────────────────────────────
  add('words_a2', [
    T('A2','taxi','noun','transport','такси','A car with a driver that you pay to take you somewhere.','She took a taxi to the airport because she had too much luggage.'),
    T('A2','motorcycle','noun','transport','мотоцикл','A two-wheeled vehicle with an engine.','He rode his motorcycle to work every day in summer.'),
    T('A2','platform','noun','transport','платформа','The raised area at a train station where passengers wait.','The train to London leaves from platform six.'),
  ]);

  // ─── A2 weather (need 3 more) ───────────────────────────────────────────────
  add('words_a2', [
    T('A2','storm','noun','weather','гроза','Very bad weather with strong wind, rain, or snow.','The storm knocked down several trees in the park.'),
    T('A2','flood','noun','weather','наводнение','A large amount of water covering areas that are usually dry.','The flood damaged many houses in the valley.'),
    T('A2','temperature','noun','weather','температура','A measure of how hot or cold something is.','The temperature dropped below zero overnight.'),
  ]);

  // ─── A2 clothing (need 3 more) ──────────────────────────────────────────────
  add('words_a2', [
    T('A2','scarf','noun','clothing','шарф','A long piece of cloth worn around the neck to keep warm.','She wrapped a warm scarf around her neck before going outside.'),
    T('A2','gloves','noun','clothing','перчатки','Coverings for your hands with separate sections for each finger.','He wore thick gloves because the weather was very cold.'),
    T('A2','belt','noun','clothing','ремень','A strip of leather or cloth worn around the waist.','He bought a new leather belt to go with his trousers.'),
  ]);

  // ─── A2 school (need 2 more) ────────────────────────────────────────────────
  add('words_a2', [
    T('A2','exam','noun','school','экзамен','A formal test of your knowledge or ability.','She studied for three weeks before the final exam.'),
    T('A2','subject','noun','school','предмет','An area of knowledge studied at school, e.g. maths or history.','Her favourite subject at school is biology.'),
  ]);

  // ─── A2 sport (need 2 more) ─────────────────────────────────────────────────
  add('words_a2', [
    T('A2','referee','noun','sport','судья','An official who makes sure players follow the rules in a sport.','The referee stopped the game when a player was injured.'),
    T('A2','stadium','noun','sport','стадион','A large structure where sports events take place.','The stadium was full when the national team played.'),
  ]);

  // ─── A2 geography (need 2 more) ─────────────────────────────────────────────
  add('words_a2', [
    T('A2','capital','noun','geography','столица','The most important city in a country, usually where the government is.','Paris is the capital of France.'),
    T('A2','coast','noun','geography','побережье','The area of land next to the sea.','They drove along the coast to enjoy the sea views.'),
  ]);

  // ─── A2 shopping (need 1 more) ──────────────────────────────────────────────
  add('words_a2', [
    T('A2','queue','noun','shopping','очередь','A line of people waiting for something.','There was a long queue at the checkout on Saturday afternoon.'),
  ]);

  // ─── B1 economy (need 5 more) ───────────────────────────────────────────────
  add('words_b1', [
    T('B1','inflation','noun','economy','инфляция','A general increase in prices and fall in the value of money.','Inflation made everyday goods more expensive for ordinary families.'),
    T('B1','unemployment','noun','economy','безработица','The situation when people who want work cannot find a job.','High unemployment led to increased poverty in the region.'),
    T('B1','export','verb','economy','экспортировать','To sell goods or services to another country.','The country exports large quantities of wheat every year.'),
    T('B1','import','verb','economy','импортировать','To buy goods or services from another country.','They import most of their electronics from abroad.'),
    T('B1','currency','noun','economy','валюта','The system of money used in a particular country.','The euro is the currency used in many European countries.'),
  ]);

  // ─── B1 arts (need 4 more) ──────────────────────────────────────────────────
  add('words_b1', [
    T('B1','sculpture','noun','arts','скульптура','A work of art made from stone, metal, or wood.','The sculpture in the town square was made by a local artist.'),
    T('B1','exhibition','noun','arts','выставка','A public event where art or objects are shown for people to see.','She visited an exhibition of modern paintings at the gallery.'),
    T('B1','orchestra','noun','arts','оркестр','A large group of musicians who play different instruments together.','The orchestra performed a symphony by Beethoven.'),
    T('B1','rhythm','noun','arts','ритм','A regular pattern of sounds or movements in music or poetry.','The dancers moved in perfect rhythm to the music.'),
  ]);

  // ─── B1 environment (need 4 more) ───────────────────────────────────────────
  add('words_b1', [
    T('B1','deforestation','noun','environment','вырубка лесов','The cutting down of large areas of forest.','Deforestation destroys the habitats of many forest animals.'),
    T('B1','carbon','noun','environment','углерод','A chemical element found in all living things and fossil fuels.','Burning fossil fuels releases carbon into the atmosphere.'),
    T('B1','biodiversity','noun','environment','биоразнообразие','The variety of plant and animal life in an area or the world.','Protecting forests helps maintain the biodiversity of our planet.'),
    T('B1','sustainable','adjective','environment','устойчивый','Using resources in a way that can continue long into the future.','They chose sustainable materials to build the eco-friendly house.'),
  ]);

  // ─── B1 health (need 4 more) ────────────────────────────────────────────────
  add('words_b1', [
    T('B1','symptom','noun','health','симптом','A sign that shows you may have a particular illness.','Fever is a common symptom of many viral infections.'),
    T('B1','treatment','noun','health','лечение','Medical care given to a patient for an illness or injury.','The doctor recommended a course of treatment for her condition.'),
    T('B1','surgery','noun','health','операция','A medical operation where a doctor cuts into the body to repair it.','He needed surgery after breaking his leg in three places.'),
    T('B1','vaccine','noun','health','вакцина','A substance that protects people against a disease.','The new vaccine was effective against the most dangerous strains.'),
  ]);

  // ─── B1 history (need 4 more) ───────────────────────────────────────────────
  add('words_b1', [
    T('B1','ancient','adjective','history','древний','Belonging to a period very long ago in the past.','The ancient ruins attracted thousands of tourists every year.'),
    T('B1','empire','noun','history','империя','A group of countries controlled by one ruler or government.','The Roman Empire lasted for hundreds of years.'),
    T('B1','revolution','noun','history','революция','A sudden, complete change in the way a country is governed.','The revolution changed the political system of the entire country.'),
    T('B1','independence','noun','history','независимость','The freedom of a country to govern itself without outside control.','The country celebrated fifty years of independence.'),
  ]);

  // ─── B1 personal_development (need 3 more) ──────────────────────────────────
  add('words_b1', [
    T('B1','motivation','noun','personal_development','мотивация','The reason why you want to do something or work hard.','His strong motivation to succeed helped him through difficult times.'),
    T('B1','discipline','noun','personal_development','дисциплина','The ability to control your behaviour and do what is needed.','Regular discipline in studying helped her pass all her exams.'),
    T('B1','confidence','noun','personal_development','уверенность','The feeling that you are good at something and can succeed.','Public speaking helped him build confidence in his abilities.'),
  ]);

  // ─── B1 education (need 3 more) ─────────────────────────────────────────────
  add('words_b1', [
    T('B1','scholarship','noun','education','стипендия','Money given to a student to help pay for their studies.','She won a scholarship to study at a top university.'),
    T('B1','diploma','noun','education','диплом','An official document showing you have completed a course.','He framed his diploma and hung it on the office wall.'),
    T('B1','curriculum','noun','education','учебная программа','The subjects taught in a school or the content of a course.','The school updated its curriculum to include digital skills.'),
  ]);

  // ─── B1 media (need 2 more) ─────────────────────────────────────────────────
  add('words_b1', [
    T('B1','broadcast','verb','media','транслировать','To send out a programme on television or radio.','The game was broadcast live on national television.'),
    T('B1','subscribe','verb','media','подписаться','To pay regularly to receive a service or publication.','She subscribed to a streaming service to watch films online.'),
  ]);

  // ─── B1 technology (need 2 more) ────────────────────────────────────────────
  add('words_b1', [
    T('B1','algorithm','noun','technology','алгоритм','A set of rules for solving a problem, especially in computing.','The search engine uses a complex algorithm to rank results.'),
    T('B1','database','noun','technology','база данных','An organised collection of information stored in a computer.','All customer information was stored in a secure database.'),
  ]);

  // ─── B1 travel (need 2 more) ────────────────────────────────────────────────
  add('words_b1', [
    T('B1','itinerary','noun','travel','маршрут','A detailed plan of a journey, including the places you will visit.','The tour guide handed out the itinerary for the week.'),
    T('B1','currency exchange','noun','travel','обмен валюты','The process of changing money from one currency to another.','He found a currency exchange office at the airport.'),
  ]);

  // ─── B1 nature (need 2 more) ────────────────────────────────────────────────
  add('words_b1', [
    T('B1','habitat','noun','nature','среда обитания','The natural environment in which a plant or animal lives.','The destruction of its habitat threatens the survival of the species.'),
    T('B1','predator','noun','nature','хищник','An animal that hunts other animals for food.','The fox is a predator that feeds on smaller animals.'),
  ]);

  // ─── B1 work_career (need 1 more) ───────────────────────────────────────────
  add('words_b1', [
    T('B1','redundancy','noun','work_career','сокращение штата','The situation when an employee loses their job because it no longer exists.','He received a redundancy payment when the factory closed down.'),
  ]);

  // ─── B1 emotions (need 1 more) ──────────────────────────────────────────────
  add('words_b1', [
    T('B1','nostalgia','noun','emotions','ностальгия','A feeling of sadness mixed with happiness when you think about the past.','Looking at old photos filled her with nostalgia for her childhood.'),
  ]);

  // ─── B1 relationships (need 1 more) ─────────────────────────────────────────
  add('words_b1', [
    T('B1','reconcile','verb','relationships','примириться','To cause two people or groups to become friendly again after a disagreement.','It took months before the two brothers finally reconciled.'),
  ]);

  // ─── B1 science_b1 (need 1 more) ────────────────────────────────────────────
  add('words_b1', [
    T('B1','gravity','noun','science_b1','гравитация','The force that attracts objects towards the centre of the Earth.','Gravity is what keeps the planets in orbit around the sun.'),
  ]);

  // ─── B1 society (need 1 more) ───────────────────────────────────────────────
  add('words_b1', [
    T('B1','prejudice','noun','society','предрассудок','An unfair opinion about someone not based on facts or reason.','The campaign aimed to reduce prejudice against minority groups.'),
  ]);

  // ─── B1 business (need 1 more) ──────────────────────────────────────────────
  add('words_b1', [
    T('B1','entrepreneur','noun','business','предприниматель','A person who starts their own business, taking on financial risks.','The young entrepreneur launched his first company at age twenty.'),
  ]);

  // ─── B2 communication (need 6 more) ─────────────────────────────────────────
  add('words_b2', [
    T('B2','persuade','verb','communication','убедить','To cause someone to do something by giving good reasons.','He persuaded his colleagues to adopt the new working method.'),
    T('B2','clarify','verb','communication','прояснить','To make something less confusing and easier to understand.','The manager clarified the new policy to avoid misunderstandings.'),
    T('B2','negotiate','verb','communication','переговариваться','To try to reach an agreement through discussion.','The union negotiated better pay conditions for all workers.'),
    T('B2','contradict','verb','communication','противоречить','To say the opposite of what someone else has said.','The new evidence contradicted the witness\'s original statement.'),
    T('B2','emphasis','noun','communication','акцент','Special importance given to something in speech or writing.','She placed great emphasis on the need for careful planning.'),
    T('B2','coherent','adjective','communication','связный','Logical and consistent, easy to understand.','The report was well-structured and coherent throughout.'),
  ]);

  // ─── B2 behaviour (need 5 more) ─────────────────────────────────────────────
  add('words_b2', [
    T('B2','impulsive','adjective','behaviour','импульсивный','Doing things suddenly without thinking carefully first.','His impulsive decision to quit his job surprised everyone.'),
    T('B2','manipulate','verb','behaviour','манипулировать','To influence or control someone in a clever or unfair way.','She felt he was trying to manipulate her into agreeing.'),
    T('B2','procrastinate','verb','behaviour','откладывать на потом','To delay doing something that you should do.','He procrastinated for weeks before finally starting the report.'),
    T('B2','conform','verb','behaviour','подчиняться нормам','To behave according to the usual rules or standards of society.','There was pressure on students to conform to strict dress codes.'),
    T('B2','inhibit','verb','behaviour','сдерживать','To prevent or slow down a process or action.','Fear of failure can inhibit people from taking creative risks.'),
  ]);

  // ─── B2 culture (need 5 more) ───────────────────────────────────────────────
  add('words_b2', [
    T('B2','heritage','noun','culture','наследие','The traditions, buildings, and beliefs that a country has had for many years.','The old city was protected as a site of cultural heritage.'),
    T('B2','ritual','noun','culture','ритуал','A set of actions performed regularly as part of a ceremony.','The annual harvest ritual brought the whole village together.'),
    T('B2','assimilate','verb','culture','ассимилировать','To become part of a group or society, or to absorb new information.','It took years for the immigrants to assimilate into the new culture.'),
    T('B2','indigenous','adjective','culture','коренной','Originating or occurring naturally in a particular place.','The museum displayed art created by indigenous communities.'),
    T('B2','intercultural','adjective','culture','межкультурный','Involving or relating to different cultures.','Intercultural communication skills are essential for international business.'),
  ]);

  // ─── B2 logical_connectors (need 5 more) ────────────────────────────────────
  add('words_b2', [
    T('B2','consequently','adverb','logical_connectors','следовательно','As a result of what has just been stated.','The project was poorly planned; consequently, it failed to meet its deadline.'),
    T('B2','nevertheless','adverb','logical_connectors','тем не менее','In spite of what has just been said; however.','The task was difficult; nevertheless, the team completed it on time.'),
    T('B2','furthermore','adverb','logical_connectors','кроме того','In addition to what has already been said.','The results were positive; furthermore, costs were lower than expected.'),
    T('B2','whereas','conjunction','logical_connectors','тогда как','Used to contrast two different things or situations.','He prefers modern architecture, whereas his partner loves historic buildings.'),
    T('B2','albeit','conjunction','logical_connectors','хотя','Although; even though.','It was a successful event, albeit smaller than last year\'s.'),
  ]);

  // ─── B2 media (need 5 more) ─────────────────────────────────────────────────
  add('words_b2', [
    T('B2','censorship','noun','media','цензура','The practice of officially examining material and removing parts considered harmful.','The new government introduced censorship of online content.'),
    T('B2','propaganda','noun','media','пропаганда','Information spread to promote a particular political cause or point of view.','The documentary exposed how propaganda was used during the war.'),
    T('B2','disinformation','noun','media','дезинформация','False information deliberately spread to deceive people.','Social media made it easier to spread disinformation rapidly.'),
    T('B2','objectivity','noun','media','объективность','The quality of not being influenced by personal feelings or opinions.','Journalists are expected to report news with objectivity.'),
    T('B2','viral','adjective','media','вирусный','Spreading quickly from person to person, especially online.','The video became viral within hours of being posted.'),
  ]);

  // ─── B2 psychology (need 5 more) ────────────────────────────────────────────
  add('words_b2', [
    T('B2','perception','noun','psychology','восприятие','The way you notice or understand something using your senses.','Our perception of colour is influenced by the light around us.'),
    T('B2','subconscious','adjective','psychology','подсознательный','Relating to thoughts and feelings you are not fully aware of.','Her subconscious fear of failure held her back from trying.'),
    T('B2','stereotype','noun','psychology','стереотип','A fixed idea about a type of person that may not be true.','He worked hard to challenge the stereotype of his profession.'),
    T('B2','trauma','noun','psychology','травма','A very distressing experience that causes lasting psychological harm.','Therapy helped her process the trauma from her difficult childhood.'),
    T('B2','cognitive','adjective','psychology','когнитивный','Relating to the mental processes of thinking, learning, and understanding.','The researcher studied cognitive development in young children.'),
  ]);

  // ─── B2 risk_danger (need 5 more) ───────────────────────────────────────────
  add('words_b2', [
    T('B2','hazard','noun','risk_danger','опасность','Something that is dangerous and could cause harm.','The icy road was a serious hazard for drivers.'),
    T('B2','vulnerability','noun','risk_danger','уязвимость','The quality of being easily hurt, damaged, or attacked.','The report highlighted the vulnerability of coastal towns to flooding.'),
    T('B2','exposure','noun','risk_danger','воздействие','The state of being unprotected from something harmful.','Long exposure to sunlight can damage your skin.'),
    T('B2','precaution','noun','risk_danger','мера предосторожности','An action taken in advance to prevent something bad from happening.','She took every precaution before climbing the mountain alone.'),
    T('B2','threat','noun','risk_danger','угроза','A statement that you will cause harm, or something likely to cause danger.','The rising water levels posed a serious threat to the island.'),
  ]);

  // ─── B2 science_b2 (need 5 more) ────────────────────────────────────────────
  add('words_b2', [
    T('B2','phenomenon','noun','science_b2','явление','A fact or event in nature or society, especially one that is unusual.','The northern lights are a natural phenomenon visible near the poles.'),
    T('B2','organism','noun','science_b2','организм','A living thing, such as a plant, animal, or bacterium.','Scientists discovered a new organism living in the deep ocean.'),
    T('B2','particle','noun','science_b2','частица','An extremely small piece of a substance.','The air was full of tiny particles after the volcanic eruption.'),
    T('B2','evolve','verb','science_b2','эволюционировать','To develop gradually over a long period of time.','Species evolve over millions of years in response to their environment.'),
    T('B2','nucleus','noun','science_b2','ядро','The central part of an atom, or the part of a cell containing DNA.','The nucleus of the atom contains protons and neutrons.'),
  ]);

  // ─── B2 abstract (need 3 more) ──────────────────────────────────────────────
  add('words_b2', [
    T('B2','paradox','noun','abstract','парадокс','A statement that seems impossible but may be true.','It is a paradox that the more choices we have, the less happy we feel.'),
    T('B2','ambiguity','noun','abstract','двусмысленность','The quality of being open to more than one interpretation.','The ambiguity in the contract led to a legal dispute.'),
    T('B2','ideology','noun','abstract','идеология','A set of beliefs and ideas that form the basis of a political system.','The two parties had very different political ideologies.'),
  ]);

  // ─── B2 academic_skills (need 3 more) ───────────────────────────────────────
  add('words_b2', [
    T('B2','bibliography','noun','academic_skills','библиография','A list of books and sources used when writing a paper.','She included a full bibliography at the end of her dissertation.'),
    T('B2','hypothesis','noun','academic_skills','гипотеза','An idea that is suggested as a possible explanation, to be tested.','The scientist developed a hypothesis and designed an experiment to test it.'),
    T('B2','methodology','noun','academic_skills','методология','The system of methods used in a particular area of study.','The research paper described the methodology in detail.'),
  ]);

  // ─── B2 business (need 4 more) ──────────────────────────────────────────────
  add('words_b2', [
    T('B2','franchise','noun','business','франшиза','A licence to sell a company\'s products using its name.','He bought a franchise and opened his own fast-food restaurant.'),
    T('B2','stakeholder','noun','business','заинтересованная сторона','A person or group with an interest in a company or project.','All stakeholders were invited to the annual general meeting.'),
    T('B2','outsource','verb','business','передавать на аутсорсинг','To pay another company to do work instead of doing it yourself.','The company decided to outsource its customer service to a call centre.'),
    T('B2','trademark','noun','business','товарный знак','A name or symbol that shows a product belongs to a specific company.','The company registered its logo as a trademark.'),
  ]);

  // ─── B2 environment (need 3 more) ───────────────────────────────────────────
  add('words_b2', [
    T('B2','contamination','noun','environment','загрязнение','The process of making something harmful by adding a polluting substance.','The contamination of the river affected local fish populations.'),
    T('B2','landfill','noun','environment','мусорный полигон','A place where waste material is buried underground.','The local landfill site was nearly full and had to be closed.'),
    T('B2','biodegradable','adjective','environment','биоразлагаемый','Able to be broken down naturally by bacteria.','The company switched to biodegradable packaging to reduce waste.'),
  ]);

  // ─── B2 personal (need 3 more) ──────────────────────────────────────────────
  add('words_b2', [
    T('B2','assertive','adjective','personal','настойчивый','Confident and direct in claiming your rights or opinions.','Being assertive in negotiations helped her get a better salary.'),
    T('B2','conscientious','adjective','personal','добросовестный','Taking care to do things correctly and thoroughly.','A conscientious student checks their work before submitting it.'),
    T('B2','empathetic','adjective','personal','эмпатичный','Able to understand and share the feelings of another person.','A good nurse must be empathetic towards their patients.'),
  ]);

  // ─── B2 social_issues (need 3 more) ─────────────────────────────────────────
  add('words_b2', [
    T('B2','discrimination','noun','social_issues','дискриминация','Treating someone unfairly because of their race, gender, or age.','The new law was designed to combat discrimination in the workplace.'),
    T('B2','oppression','noun','social_issues','угнетение','The cruel and unjust treatment of a group of people.','The documentary highlighted the oppression faced by minorities.'),
    T('B2','marginalise','verb','social_issues','маргинализировать','To treat someone as if they are not important.','Policies that marginalise the poor lead to greater inequality.'),
  ]);

  // ─── B2 social_advanced (need 1 more) ───────────────────────────────────────
  add('words_b2', [
    T('B2','empower','verb','social_advanced','наделять полномочиями','To give someone the power or authority to do something.','The programme was designed to empower women in rural communities.'),
  ]);

  // ─── C1 process_c1 (need 6 more) ────────────────────────────────────────────
  add('words_c1', [
    T('C1','streamline','verb','process_c1','упростить','To make a system or organisation more efficient.','The new software helped streamline the entire billing process.'),
    T('C1','delegate','verb','process_c1','делегировать','To give part of your work or power to someone else.','A good manager knows how to delegate tasks effectively.'),
    T('C1','execute','verb','process_c1','выполнять','To carry out or complete a plan, order, or piece of work.','The team executed the project flawlessly within budget.'),
    T('C1','orchestrate','verb','process_c1','организовывать','To carefully arrange or direct a complex operation.','She orchestrated the entire product launch without any external help.'),
    T('C1','optimise','verb','process_c1','оптимизировать','To make something as good or effective as possible.','The engineers worked to optimise the fuel efficiency of the engine.'),
    T('C1','prioritise','verb','process_c1','расставлять приоритеты','To decide which tasks are most important and do those first.','She had to prioritise her workload to meet the tight deadline.'),
  ]);

  // ─── C1 academic_discourse (need 5 more) ────────────────────────────────────
  add('words_c1', [
    T('C1','conjecture','noun','academic_discourse','предположение','An opinion or idea that is not based on certain knowledge.','The scientist\'s conjecture was later supported by experimental data.'),
    T('C1','compendium','noun','academic_discourse','компендиум','A collection of concise information about a subject.','The professor recommended a compendium of key texts for the course.'),
    T('C1','refute','verb','academic_discourse','опровергать','To prove that a statement or idea is wrong.','The new study refuted the long-held theory about human migration.'),
    T('C1','posit','verb','academic_discourse','постулировать','To suggest or assume that something is true.','The paper posits a link between diet and cognitive performance.'),
    T('C1','substantiate','verb','academic_discourse','подтвердить','To provide evidence to support or prove something.','She was unable to substantiate her claims with concrete evidence.'),
  ]);

  // ─── C1 conditions (need 5 more) ────────────────────────────────────────────
  add('words_c1', [
    T('C1','contingent','adjective','conditions','зависящий от обстоятельств','Depending on something else in order to happen.','The funding was contingent on the project meeting specific targets.'),
    T('C1','provisional','adjective','conditions','временный','Arranged for the present but likely to change.','The provisional agreement was signed pending final approval.'),
    T('C1','prerequisite','noun','conditions','предпосылка','Something that must exist or be done before something else can happen.','A degree is a prerequisite for most professional positions.'),
    T('C1','stipulate','verb','conditions','оговаривать','To state exactly what is required as part of an agreement.','The contract stipulates that payment must be made within 30 days.'),
    T('C1','subject to','phrase','conditions','при условии','Depending on a condition being met first.','The deal was subject to approval by the board of directors.'),
  ]);

  // ─── C1 organisation (need 5 more) ──────────────────────────────────────────
  add('words_c1', [
    T('C1','hierarchy','noun','organisation','иерархия','A system where people are ranked according to their status.','The company had a strict hierarchy with the CEO at the top.'),
    T('C1','bureaucracy','noun','organisation','бюрократия','A system of official rules and processes, often seen as slow.','The bureaucracy made it difficult to get anything approved quickly.'),
    T('C1','accountability','noun','organisation','подотчётность','The fact of being responsible for decisions and actions.','The new system increased accountability among senior managers.'),
    T('C1','decentralise','verb','organisation','децентрализовать','To move control from a central authority to local groups.','The government decided to decentralise healthcare services.'),
    T('C1','governance','noun','organisation','управление','The way in which a country, company, or organisation is managed.','Good governance is essential for long-term economic stability.'),
  ]);

  // ─── C1 patterns (need 5 more) ──────────────────────────────────────────────
  add('words_c1', [
    T('C1','trajectory','noun','patterns','траектория','The path or direction along which something develops.','The company\'s growth trajectory has been consistently upward.'),
    T('C1','cyclical','adjective','patterns','циклический','Happening in repeated cycles or patterns.','The economy goes through cyclical periods of growth and recession.'),
    T('C1','recurrent','adjective','patterns','повторяющийся','Happening again and again at regular intervals.','The recurrent theme in her novels is the loss of identity.'),
    T('C1','converge','verb','patterns','сходиться','To come together from different directions to meet at a point.','Several major roads converge at the centre of the city.'),
    T('C1','diverge','verb','patterns','расходиться','To go in different directions from the same starting point.','Their opinions began to diverge as the discussion continued.'),
  ]);

  // ─── C1 personal_advanced (need 4 more) ─────────────────────────────────────
  add('words_c1', [
    T('C1','tenacious','adjective','personal_advanced','упорный','Holding firmly to a decision, belief, or aim despite difficulties.','Her tenacious approach to problem-solving impressed her supervisors.'),
    T('C1','stoic','adjective','personal_advanced','стоический','Accepting pain or difficulty without complaining.','He was stoic in the face of great personal loss.'),
    T('C1','prudent','adjective','personal_advanced','благоразумный','Careful and sensible in avoiding risks and making good decisions.','It would be prudent to save some money before making that investment.'),
    T('C1','equanimity','noun','personal_advanced','душевное спокойствие','A calm and composed mental state in difficult situations.','She faced the setback with remarkable equanimity.'),
  ]);

  // ─── C1 business_advanced (need 3 more) ─────────────────────────────────────
  add('words_c1', [
    T('C1','arbitrage','noun','business_advanced','арбитраж','The practice of profiting from differences in prices in different markets.','Currency arbitrage is common in international financial trading.'),
    T('C1','divestment','noun','business_advanced','дивестиция','The sale of assets or subsidiary companies.','The company announced a major divestment to focus on its core business.'),
    T('C1','fiduciary','adjective','business_advanced','фидуциарный','Relating to a trust or the responsibility to act in someone\'s best interest.','Directors have a fiduciary duty to act in shareholders\' interests.'),
  ]);

  // ─── C1 global_issues (need 3 more) ─────────────────────────────────────────
  add('words_c1', [
    T('C1','geopolitical','adjective','global_issues','геополитический','Relating to politics as influenced by geographical factors.','The conflict had significant geopolitical consequences for the region.'),
    T('C1','multilateral','adjective','global_issues','многосторонний','Involving three or more countries or parties.','A multilateral agreement on climate change was signed by forty nations.'),
    T('C1','sovereignty','noun','global_issues','суверенитет','The right of a country to govern itself without outside control.','The treaty was criticised as an infringement on national sovereignty.'),
  ]);

  // ─── C1 language_advanced (need 3 more) ─────────────────────────────────────
  add('words_c1', [
    T('C1','ellipsis','noun','language_advanced','эллипсис','The omission of words from speech or writing that can be understood from context.','The use of ellipsis makes the sentence more concise without losing meaning.'),
    T('C1','syntax','noun','language_advanced','синтаксис','The rules that govern the structure of sentences in a language.','Understanding syntax is fundamental to learning a new language.'),
    T('C1','pragmatics','noun','language_advanced','прагматика','The study of how language is used in social contexts.','Pragmatics explains why the same words can mean different things in different situations.'),
  ]);

  // ─── C1 arts_c1 (need 2 more) ───────────────────────────────────────────────
  add('words_c1', [
    T('C1','avant-garde','adjective','arts_c1','авангардный','New and experimental in style, especially in art and culture.','The avant-garde film divided critics with its unconventional structure.'),
    T('C1','motif','noun','arts_c1','мотив','A repeated element or theme in art, literature, or music.','The motif of water runs throughout the composer\'s later works.'),
  ]);

  // ─── C1 process (need 2 more) ───────────────────────────────────────────────
  add('words_c1', [
    T('C1','iterate','verb','process','повторять','To repeat a process, making improvements each time.','The design team continued to iterate on the prototype until it was perfect.'),
    T('C1','calibrate','verb','process','калибровать','To measure and adjust an instrument or process accurately.','The engineers had to calibrate the sensors before testing the device.'),
  ]);

  // ─── C1 social_advanced (need 2 more) ───────────────────────────────────────
  add('words_c1', [
    T('C1','polarise','verb','social_advanced','поляризовать','To divide into two opposite groups with very different opinions.','The controversial policy polarised public opinion across the country.'),
    T('C1','cohesion','noun','social_advanced','сплочённость','The quality of forming a united whole and working well together.','Social cohesion was strengthened by community projects.'),
  ]);

  // ─── C1 change (need 1 more) ────────────────────────────────────────────────
  add('words_c1', [
    T('C1','overhaul','verb','change','капитально реформировать','To examine and repair or improve a system completely.','The government overhauled the education system to improve outcomes.'),
  ]);

  // ─── C1 experiences (need 1 more) ───────────────────────────────────────────
  add('words_c1', [
    T('C1','epiphany','noun','experiences','откровение','A sudden, clear understanding of something important.','Reading that book was an epiphany that changed how she saw the world.'),
  ]);

  // ─── C1 law_politics (need 1 more) ──────────────────────────────────────────
  add('words_c1', [
    T('C1','ratify','verb','law_politics','ратифицировать','To make an agreement official by signing or voting for it.','The parliament voted to ratify the international climate treaty.'),
  ]);

  // ─── C1 science (need 1 more) ───────────────────────────────────────────────
  add('words_c1', [
    T('C1','catalyst','noun','science','катализатор','A substance that increases the rate of a chemical reaction, or something that causes change.','The discovery acted as a catalyst for a major shift in the field.'),
  ]);

  // ─── C2 advanced_thinking (need 6 more) ─────────────────────────────────────
  add('words_c2', [
    T('C2','solecism','noun','advanced_thinking','солецизм','A grammatical error or a breach of etiquette.','The professor winced at every solecism in the student\'s presentation.'),
    T('C2','aphorism','noun','advanced_thinking','афоризм','A short statement expressing a general truth or observation.','The speech opened with a well-chosen aphorism that set the tone.'),
    T('C2','heuristic','adjective','advanced_thinking','эвристический','Enabling someone to discover or learn something for themselves through trial.','The teacher used a heuristic approach to help students solve problems independently.'),
    T('C2','dialectical','adjective','advanced_thinking','диалектический','Relating to the process of examining opposing ideas to find the truth.','The debate took on a dialectical quality as each argument was countered.'),
    T('C2','epistemology','noun','advanced_thinking','эпистемология','The branch of philosophy concerned with the nature and limits of knowledge.','Epistemology asks how we can be certain that anything is true.'),
    T('C2','abstruse','adjective','advanced_thinking','непонятный','Very difficult to understand; obscure.','His abstruse lecture confused even the most experienced academics.'),
  ]);

  // ─── C2 advanced_descriptions (need 5 more) ─────────────────────────────────
  add('words_c2', [
    T('C2','ineffable','adjective','advanced_descriptions','невыразимый','Too great or extreme to be expressed in words.','The view from the summit was of an ineffable, breathtaking beauty.'),
    T('C2','incandescent','adjective','advanced_descriptions','ослепительный','Emitting bright light as a result of being heated; also intensely angry.','She was incandescent with rage when she discovered the deception.'),
    T('C2','pellucid','adjective','advanced_descriptions','прозрачный','Transparently clear; easily understood.','Her pellucid prose made even complex ideas accessible to all readers.'),
    T('C2','mellifluous','adjective','advanced_descriptions','мелодичный','Pleasant and musical to hear; smooth and sweet.','His mellifluous voice made every story sound like a piece of music.'),
    T('C2','ineffaceable','adjective','advanced_descriptions','неизгладимый','Impossible to remove or forget; making a permanent impression.','The loss left an ineffaceable mark on his spirit.'),
  ]);

  // ─── C2 advanced_verbs (need 5 more) ────────────────────────────────────────
  add('words_c2', [
    T('C2','prevaricate','verb','advanced_verbs','уклоняться от ответа','To avoid giving a direct answer by speaking evasively.','When asked about the funds, he began to prevaricate.'),
    T('C2','eviscerate','verb','advanced_verbs','опустошать','To deprive something of its essential content; to disembowel.','The critic eviscerated the novel in a scathing review.'),
    T('C2','vitiate','verb','advanced_verbs','портить','To impair or spoil the quality or efficiency of something.','A single fraudulent entry vitiated the entire set of accounts.'),
    T('C2','dissemble','verb','advanced_verbs','притворяться','To conceal or disguise one\'s true feelings or beliefs.','He dissembled his anxiety behind a calm and confident manner.'),
    T('C2','fulminate','verb','advanced_verbs','громить','To express vehement protest or condemnation.','The columnist fulminated against the new policy in several articles.'),
  ]);

  // ─── C2 art_literature (need 5 more) ────────────────────────────────────────
  add('words_c2', [
    T('C2','ekphrasis','noun','art_literature','экфрасис','A vivid written description of a visual work of art.','The poem is a remarkable example of ekphrasis, describing the painting in verse.'),
    T('C2','pastiche','noun','art_literature','пастиш','A work of art that imitates the style of another artist.','The film is a loving pastiche of 1950s Hollywood musicals.'),
    T('C2','picaresque','adjective','art_literature','плутовской','Relating to a genre of fiction dealing with the adventures of a rogue.','The novel follows a picaresque hero through a series of comic misadventures.'),
    T('C2','pathos','noun','art_literature','пафос','A quality in art or literature that arouses feelings of sadness or pity.','The final scene was filled with pathos as the old man said goodbye.'),
    T('C2','bathos','noun','art_literature','батос','An abrupt, jarring change from the serious to the trivial.','The speech descended into bathos when he began discussing his cat.'),
  ]);

  // ─── C2 growth (need 5 more) ────────────────────────────────────────────────
  add('words_c2', [
    T('C2','catalyse','verb','growth','катализировать','To make a chemical reaction happen faster, or to cause change.','The new investment catalysed rapid development in the region.'),
    T('C2','regenerate','verb','growth','регенерировать','To grow again or cause something to grow or develop again.','The stem cell treatment helped regenerate damaged tissue.'),
    T('C2','transmute','verb','growth','превращать','To change from one form, nature, or substance into another.','Over centuries, attitudes towards disability have been transmuted.'),
    T('C2','amplify','verb','growth','усилить','To increase the strength or amount of something.','The discovery amplified the research team\'s initial findings.'),
    T('C2','metamorphose','verb','growth','преобразиться','To change completely, especially into something very different.','The rundown district has metamorphosed into a vibrant cultural hub.'),
  ]);

  // ─── C2 advanced_nouns (need 4 more) ────────────────────────────────────────
  add('words_c2', [
    T('C2','anathema','noun','advanced_nouns','анафема','Something or someone strongly disliked or disapproved of.','Any form of compromise was anathema to the hardline faction.'),
    T('C2','panacea','noun','advanced_nouns','панацея','A solution to all difficulties; a universal remedy.','Technology is often promoted as a panacea for social problems.'),
    T('C2','spectre','noun','advanced_nouns','призрак','A ghost, or something that causes fear about a future event.','The spectre of unemployment loomed over the struggling town.'),
    T('C2','quintessence','noun','advanced_nouns','квинтэссенция','The most perfect or typical example of a quality or class.','The cathedral is regarded as the quintessence of Gothic architecture.'),
  ]);

  // ─── C2 character (need 4 more) ─────────────────────────────────────────────
  add('words_c2', [
    T('C2','magnanimous','adjective','character','великодушный','Very generous and forgiving, especially towards a rival.','In his victory speech, he was magnanimous towards his defeated opponent.'),
    T('C2','intransigent','adjective','character','непримиримый','Refusing to change one\'s views or to agree to any compromise.','The intransigent negotiator refused every proposal put forward.'),
    T('C2','pusillanimous','adjective','character','малодушный','Showing a lack of courage or determination; timid.','His pusillanimous response to the crisis disappointed his supporters.'),
    T('C2','equivocal','adjective','character','двусмысленный','Not clear or decided; open to more than one interpretation.','His equivocal reply left everyone uncertain about his true intentions.'),
  ]);

  // ─── C2 force_change (need 4 more) ──────────────────────────────────────────
  add('words_c2', [
    T('C2','inexorable','adjective','force_change','неумолимый','Impossible to stop or prevent; relentless.','The inexorable advance of technology continues to reshape society.'),
    T('C2','incipient','adjective','force_change','начинающийся','In an early stage; beginning to develop.','Scientists detected incipient signs of erosion along the coastline.'),
    T('C2','metastasise','verb','force_change','метастазировать','To spread to other parts, especially harmful ideas or diseases.','The disinformation campaign quickly metastasised across social media.'),
    T('C2','supplant','verb','force_change','вытеснять','To take the place of something, especially by force.','Streaming services have largely supplanted traditional television viewing.'),
  ]);

  // ─── Write appended rows to files ───────────────────────────────────────────
  let totalAdded = 0;
  for (const [file, rows] of Object.entries(appends)) {
    if (rows.length === 0) continue;
    const filePath = path.join(ASSETS, file + '.tsv');
    const content = '\n' + rows.join('\n');
    fs.appendFileSync(filePath, content, 'utf8');
    console.log(`${file}.tsv: +${rows.length} words`);
    totalAdded += rows.length;
  }
  console.log(`\nTotal added: ${totalAdded}`);
}

main();
