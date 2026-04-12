// fill_words2.js — adds missing words so every group has >= 25
const fs = require('fs');
const path = require('path');
const ASSETS = 'app/src/main/assets';

function parseTsv(fp) {
  const lines = fs.readFileSync(fp, 'utf8').split('\n').filter(l => l.trim());
  const h = lines[0].split('\t').map(x => x.trim());
  return lines.slice(1).map(l => {
    const c = l.split('\t'); const o = {};
    h.forEach((k, i) => o[k] = (c[i] || '').trim()); return o;
  });
}

// Build global set of existing words
const existing = new Set();
for (const fname of ['words_a1.tsv','words_a2.tsv','words_b1.tsv','words_b2.tsv','words_c1.tsv','words_c2.tsv'])
  parseTsv(path.join(ASSETS, fname)).forEach(w => existing.add(w.WORD.toLowerCase().trim()));

const T = (level, word, pos, sg, ru, def, ex) => [level, word, pos, sg, ru, def, ex].join('\t');

// ─── A1 additions ────────────────────────────────────────────────────────────
const A1 = [
  // colours (need 8)
  T('A1','orange','adjective','colours','оранжевый','having the colour between red and yellow','The sun looked orange as it set over the sea.'),
  T('A1','navy','adjective','colours','тёмно-синий','a very dark shade of blue','She wore a navy blue jacket to work.'),
  T('A1','cream','adjective','colours','кремовый','a pale yellowish-white colour','The walls were painted a warm cream colour.'),
  T('A1','lime','adjective','colours','лаймовый','a bright yellow-green colour','He was wearing a lime green T-shirt.'),
  T('A1','violet','adjective','colours','фиолетовый','a bluish-purple colour','The violets in the garden are violet.'),
  T('A1','beige','adjective','colours','бежевый','a pale sandy yellowish-brown colour','She chose beige curtains for the living room.'),
  T('A1','shade','noun','colours','оттенок','a variety of a particular colour','She painted the room in a light shade of blue.'),
  T('A1','tint','noun','colours','тон цвета','a small amount of colour added to something','The glass had a slight green tint.'),
  // numbers (need 6)
  T('A1','last','adjective','numbers','последний','coming after all others in a sequence','December is the last month of the year.'),
  T('A1','next','adjective','numbers','следующий','coming immediately after something','Turn left at the next street.'),
  T('A1','million','number','numbers','миллион','the number 1,000,000','There are over a million people in this city.'),
  T('A1','dozen','noun','numbers','дюжина','a group of twelve things','She bought a dozen eggs at the market.'),
  T('A1','count','verb','numbers','считать','to say numbers in order','Can you count from one to twenty?'),
  T('A1','total','noun','numbers','итого','the whole number or amount','What is the total cost of the trip?'),
  // education A1 (need 5)
  T('A1','learn','verb','education','учиться','to gain knowledge or a skill','I want to learn French.'),
  T('A1','read','verb','education','читать','to look at words and understand them','She reads a book every week.'),
  T('A1','write','verb','education','писать','to make letters or words on paper','Please write your name here.'),
  T('A1','draw','verb','education','рисовать','to make a picture with a pencil or pen','The children love to draw animals.'),
  T('A1','pencil','noun','education','карандаш','a thin stick used for writing or drawing','I need a pencil to do this exercise.'),
  // animals (need 5)
  T('A1','wolf','noun','animals','волк','a wild animal that looks like a large dog','Wolves live in packs and hunt together.'),
  T('A1','deer','noun','animals','олень','a large wild animal with long thin legs','We saw a deer in the forest.'),
  T('A1','whale','noun','animals','кит','the largest animal in the sea','Whales are mammals, not fish.'),
  T('A1','parrot','noun','animals','попугай','a tropical bird that can copy human speech','The parrot repeated everything I said.'),
  T('A1','butterfly','noun','animals','бабочка','an insect with large colourful wings','A butterfly landed on the flower.'),
  // body (need 4)
  T('A1','elbow','noun','body','локоть','the joint in the middle of your arm','She hurt her elbow playing tennis.'),
  T('A1','wrist','noun','body','запястье','the part of your body between your hand and arm','She wore a bracelet on her wrist.'),
  T('A1','heel','noun','body','пятка','the back part of your foot','My new shoes rub my heels.'),
  T('A1','tongue','noun','body','язык','the soft organ in your mouth used for tasting','Stick out your tongue and say "Ah".'),
  // family (need 2)
  T('A1','nephew','noun','family','племянник','the son of your brother or sister','My nephew is five years old.'),
  T('A1','niece','noun','family','племянница','the daughter of your brother or sister','I bought a gift for my niece.'),
];

// ─── A2 additions ────────────────────────────────────────────────────────────
const A2 = [
  // work (need 8)
  T('A2','team','noun','work','команда','a group of people who work together','Our team finished the project on time.'),
  T('A2','project','noun','work','проект','a piece of planned work with a specific aim','She is managing a new project.'),
  T('A2','deadline','noun','work','дедлайн','the latest time by which you must complete something','The deadline for the report is Friday.'),
  T('A2','report','noun','work','отчёт','a written or spoken account of something','I have to write a report for my boss.'),
  T('A2','staff','noun','work','персонал','the people who work for an organisation','The staff are very friendly here.'),
  T('A2','schedule','noun','work','расписание','a plan of what will happen and when','Let me check my schedule for tomorrow.'),
  T('A2','budget','noun','work','бюджет','the amount of money available for a purpose','We need to stay within our budget.'),
  T('A2','sign','verb','work','подписывать','to write your name on a document','Please sign the contract here.'),
  // health (need 6)
  T('A2','cold','noun','health','простуда','a common illness that affects the nose and throat','I have a cold and cannot come to work.'),
  T('A2','rest','verb','health','отдыхать','to relax and stop doing active things','The doctor told me to rest for a week.'),
  T('A2','sleep','noun','health','сон','the natural state of rest during the night','You need at least eight hours of sleep.'),
  T('A2','breathe','verb','health','дышать','to take air into your lungs and send it out','Breathe in slowly and relax.'),
  T('A2','fit','adjective','health','в хорошей форме','healthy and physically strong','She goes running every day to stay fit.'),
  T('A2','broken','adjective','health','сломанный','fractured or damaged, such as a bone','He has a broken arm from a fall.'),
  // travel A2 (need 5)
  T('A2','journey','noun','travel','поездка','the act of travelling from one place to another','The journey took three hours by train.'),
  T('A2','trip','noun','travel','путешествие','a short journey made to a place and back','We went on a day trip to the coast.'),
  T('A2','route','noun','travel','маршрут','the way you travel from one place to another','We took a scenic route through the mountains.'),
  T('A2','overnight','adjective','travel','ночной','done during or lasting one night','We took an overnight train to the capital.'),
  T('A2','currency','noun','travel','валюта','the money used in a particular country','Don\'t forget to exchange currency before your trip.'),
  // technology (need 4)
  T('A2','click','verb','technology','кликать','to press a button on a computer mouse','Click on the icon to open the program.'),
  T('A2','link','noun','technology','ссылка','a connection between two websites or documents','Click the link to visit the website.'),
  T('A2','share','verb','technology','делиться','to send content to others online','She shared the photo on social media.'),
  T('A2','upload','verb','technology','загружать','to move a file from your device to the internet','Please upload your assignment to the website.'),
  // weather (need 3)
  T('A2','season','noun','weather','сезон','one of the four periods of the year','Spring is my favourite season.'),
  T('A2','hail','noun','weather','град','small balls of ice that fall like rain','The hail damaged the car roof.'),
  T('A2','breeze','noun','weather','ветерок','a light and gentle wind','A cool breeze blew through the window.'),
  // geography (need 3)
  T('A2','town','noun','geography','город','a place with many buildings, smaller than a city','I grew up in a small town in the north.'),
  T('A2','region','noun','geography','регион','a large area of land with common features','The northern region of the country is very cold.'),
  T('A2','suburb','noun','geography','пригород','an area outside the centre of a large city','They moved to the suburbs to have a garden.'),
  // clothing (need 3)
  T('A2','pocket','noun','clothing','карман','a small bag sewn into a piece of clothing','He put his keys in his jacket pocket.'),
  T('A2','material','noun','clothing','материал','the substance from which clothing is made','This shirt is made from a soft material.'),
  T('A2','fashion','noun','clothing','мода','the style of clothing popular at a particular time','She always follows the latest fashion.'),
  // transport (need 2)
  T('A2','ferry','noun','transport','паром','a boat that carries passengers across water','We took the ferry to the island.'),
  T('A2','lorry','noun','transport','грузовик','a large motor vehicle used for carrying heavy loads','A lorry blocked the road for an hour.'),
  // school (need 2)
  T('A2','chalk','noun','school','мел','a white or coloured stick used for writing on a blackboard','The teacher wrote the word in chalk.'),
  T('A2','register','noun','school','журнал','a list of students who attend a class','The teacher called out the register.'),
  // sport (need 2)
  T('A2','boxing','noun','sport','бокс','a sport in which two people fight using their fists','He trained hard to become a boxing champion.'),
  T('A2','gymnastics','noun','sport','гимнастика','a sport involving physical exercises requiring balance and flexibility','She won a gold medal in gymnastics.'),
  // shopping (need 1)
  T('A2','gift','noun','shopping','подарок','something you give to someone, usually on a special occasion','I need to buy a gift for her birthday.'),
];

// ─── B1 additions ────────────────────────────────────────────────────────────
const B1 = [
  // economy (need 5)
  T('B1','recession','noun','economy','рецессия','a period of reduced economic activity','The country fell into recession after the crisis.'),
  T('B1','surplus','noun','economy','профицит','an amount greater than what is needed','The country had a trade surplus last year.'),
  T('B1','deficit','noun','economy','дефицит','when spending is greater than income','The government needs to reduce the budget deficit.'),
  T('B1','dividend','noun','economy','дивиденд','a share of a company\'s profits paid to investors','Shareholders received a high dividend this year.'),
  T('B1','prosperity','noun','economy','процветание','the condition of being financially successful','The region enjoyed a period of great prosperity.'),
  // health B1 (need 4)
  T('B1','chronic','adjective','health','хронический','lasting for a long time or constantly occurring','She suffers from chronic back pain.'),
  T('B1','contagious','adjective','health','заразный','able to spread from one person to another','Flu is highly contagious in winter.'),
  T('B1','overdose','noun','health','передозировка','taking too much of a drug at one time','An overdose of painkillers can be dangerous.'),
  T('B1','prescribe','verb','health','назначать лечение','to say what medicine a patient should take','The doctor prescribed antibiotics for the infection.'),
  // history (need 4)
  T('B1','reign','noun','history','царствование','the period when a king or queen rules','The reign of Queen Victoria lasted 63 years.'),
  T('B1','republic','noun','history','республика','a country governed by elected representatives','France became a republic after the revolution.'),
  T('B1','medieval','adjective','history','средневековый','relating to the Middle Ages','The medieval castle stands on a hill.'),
  T('B1','reform','noun','history','реформа','a change made to improve a system','The government introduced major educational reforms.'),
  // environment (need 3)
  T('B1','wilderness','noun','environment','дикая природа','a large natural area that humans have not changed','The national park protects areas of wilderness.'),
  T('B1','estuary','noun','environment','эстуарий','the wide part of a river where it meets the sea','Many birds feed in the estuary.'),
  T('B1','groundwater','noun','environment','грунтовые воды','water stored under the ground in rocks or soil','Farming chemicals can contaminate groundwater.'),
  // work_career (need 2)
  T('B1','appraisal','noun','work_career','оценка работы','a formal review of an employee\'s performance','My annual appraisal is scheduled for next week.'),
  T('B1','network','verb','work_career','налаживать связи','to meet and talk with people who may be useful professionally','It is important to network at industry events.'),
  // nature (need 2)
  T('B1','burrow','noun','nature','нора','a hole in the ground made by an animal for shelter','Rabbits live in burrows underground.'),
  T('B1','tide','noun','nature','прилив','the regular rise and fall of sea levels','The tide comes in twice a day.'),
  // personal_development (need 2)
  T('B1','persistence','noun','personal_development','настойчивость','continuing to do something despite difficulty','Success requires persistence and hard work.'),
  T('B1','self-discipline','noun','personal_development','самодисциплина','the ability to control your behaviour and actions','Self-discipline is essential for achieving goals.'),
  // education B1 (need 2)
  T('B1','internship','noun','education','стажировка','a period of work experience at a company','She completed a summer internship at a law firm.'),
  T('B1','placement','noun','education','практика','a period working for an organisation as part of your studies','He did a year\'s placement in Germany.'),
  // media B1 (need 2)
  T('B1','platform','noun','media','платформа','a website or service used to share content or ideas','She built a large following on the social media platform.'),
  T('B1','streaming','noun','media','стриминг','the process of watching video or listening to audio online','Streaming services have replaced DVDs.'),
  // arts B1 (need 2)
  T('B1','rehearse','verb','arts','репетировать','to practise a performance before showing it to an audience','The actors rehearsed for weeks before opening night.'),
  T('B1','choreography','noun','arts','хореография','the arrangement of steps and movements in a dance','The choreography of the ballet was stunning.'),
  // science_b1 (need 2)
  T('B1','theorem','noun','science_b1','теорема','a statement in mathematics that has been proved true','Students learn to prove geometric theorems.'),
  T('B1','specimen','noun','science_b1','образец','an example or sample used for examination','The scientist studied a specimen under the microscope.'),
  // travel B1 (need 1)
  T('B1','charter','adjective','travel','чартерный','describing a flight or vehicle hired for a specific journey','We booked a charter flight to the resort.'),
  // society B1 (need 1)
  T('B1','legislature','noun','society','законодательный орган','the group of people who make laws for a country','The legislature voted on the new bill.'),
  // business B1 (need 1)
  T('B1','turnover','noun','business','оборот','the total amount of money a business earns over a period','The company\'s annual turnover increased by ten per cent.'),
  // technology B1 (need 1)
  T('B1','encryption','noun','technology','шифрование','the process of converting information to a coded form','Encryption protects your personal data online.'),
  // relationships B1 (need 1)
  T('B1','reconcile','verb','relationships','помириться','to restore a friendly relationship after a disagreement','It took months for them to reconcile after the argument.'),
];

// ─── B2 additions ────────────────────────────────────────────────────────────
const B2 = [
  // culture (need 6)
  T('B2','custom','noun','culture','обычай','a traditional practice followed in a society','It is a custom to bow when greeting someone in Japan.'),
  T('B2','tradition','noun','culture','традиция','a belief or practice passed down over time','Celebrating the new year is a tradition worldwide.'),
  T('B2','diversity','noun','culture','разнообразие','the presence of different types of people or cultures','The city is known for its cultural diversity.'),
  T('B2','integration','noun','culture','интеграция','the process of bringing groups together as equal members','Social integration helps newcomers feel welcome.'),
  T('B2','acculturation','noun','culture','аккультурация','the process of adopting the culture of another group','Acculturation can be challenging for immigrants.'),
  T('B2','cohesion','noun','culture','сплочённость','the quality of forming a united whole','Social cohesion depends on shared values.'),
  // science_b2 (need 6)
  T('B2','isotope','noun','science_b2','изотоп','one of two or more forms of the same element','Carbon has several isotopes used in dating.'),
  T('B2','enzyme','noun','science_b2','фермент','a protein that speeds up a chemical reaction in a body','Enzymes help digest food in the stomach.'),
  T('B2','receptor','noun','science_b2','рецептор','a cell or organ that responds to stimuli','Pain receptors send signals to the brain.'),
  T('B2','wavelength','noun','science_b2','длина волны','the distance between the crests of two waves','Visible light has a wavelength we can see.'),
  T('B2','conductivity','noun','science_b2','проводимость','the ability of a substance to conduct heat or electricity','Copper has high electrical conductivity.'),
  T('B2','membrane','noun','science_b2','мембрана','a thin flexible layer that covers or separates something','The cell membrane controls what enters the cell.'),
  // media B2 (need 5)
  T('B2','influencer','noun','media','инфлюенсер','a person who affects others\' opinions through social media','The brand hired an influencer to promote their product.'),
  T('B2','hyperlink','noun','media','гиперссылка','a link in digital text that takes you to another page','Click the hyperlink to read the full article.'),
  T('B2','clickbait','noun','media','кликбейт','content designed to attract clicks with sensational headlines','That article was just clickbait with no real news.'),
  T('B2','paywall','noun','media','платный доступ','a system requiring payment to access online content','The newspaper put its articles behind a paywall.'),
  T('B2','narrative','noun','media','нарратив','the way events are described or presented to an audience','The media narrative about the event was misleading.'),
  // communication (need 5)
  T('B2','interpret','verb','communication','интерпретировать','to explain the meaning of something','She had to interpret his ambiguous answer.'),
  T('B2','engage','verb','communication','вступать в общение','to attract and hold someone\'s attention or interest','The speaker knew how to engage the audience.'),
  T('B2','rapport','noun','communication','взаимопонимание','a close and friendly relationship with someone','She quickly built rapport with the new students.'),
  T('B2','explicit','adjective','communication','прямой','clearly stated and leaving nothing to be understood','Please be explicit about what you need.'),
  T('B2','informal','adjective','communication','неформальный','relaxed and friendly in style or tone','The meeting was informal and open.'),
  // risk_danger (need 5)
  T('B2','liability','noun','risk_danger','ответственность','being legally responsible for causing harm or damage','The company accepted liability for the accident.'),
  T('B2','mitigation','noun','risk_danger','смягчение','the action of reducing the severity of something','Early action is key to the mitigation of risk.'),
  T('B2','safeguard','noun','risk_danger','защитная мера','a measure taken to protect against harm','Safety regulations are a safeguard against accidents.'),
  T('B2','deterrence','noun','risk_danger','сдерживание','the use of threats to prevent harmful actions','Nuclear deterrence was central to Cold War strategy.'),
  T('B2','jeopardy','noun','risk_danger','угроза','danger of loss, harm, or failure','His health was in jeopardy after the accident.'),
  // business B2 (need 4)
  T('B2','stakeholder','noun','business','заинтересованная сторона','a person with an interest in a business or project','All stakeholders were consulted before the decision.'),
  T('B2','acquisition','noun','business','поглощение','the act of buying another company','The firm announced the acquisition of a rival.'),
  T('B2','leverage','noun','business','рычаг влияния','the power to influence a situation or outcome','They used their financial leverage in the negotiation.'),
  T('B2','consortium','noun','business','консорциум','a group of organisations working together on a project','A consortium of firms bid for the contract.'),
  // psychology (need 4)
  T('B2','cognition','noun','psychology','познание','the mental process of acquiring knowledge','Language affects cognition and thought.'),
  T('B2','narcissism','noun','psychology','нарциссизм','excessive admiration of oneself','His narcissism made it hard to work with him.'),
  T('B2','catharsis','noun','psychology','катарсис','a release of strong emotion, often through art','Writing can provide catharsis in difficult times.'),
  T('B2','desensitise','verb','psychology','притуплять чувства','to make someone less sensitive to something','Violent media may desensitise viewers to aggression.'),
  // behaviour (need 4)
  T('B2','exhibit','verb','behaviour','проявлять','to show a particular quality or behaviour','He exhibited signs of stress before the exam.'),
  T('B2','restrain','verb','behaviour','сдерживать','to prevent someone from doing something','She restrained herself from saying what she thought.'),
  T('B2','appease','verb','behaviour','умиротворять','to make someone calmer by giving them what they want','They tried to appease the angry crowd.'),
  T('B2','simulate','verb','behaviour','симулировать','to pretend to have a feeling or to copy something','The training exercise simulated a real emergency.'),
  // logical_connectors (need 4)
  T('B2','thus','adverb','logical_connectors','таким образом','as a result or consequence of this','The weather was bad; thus, we stayed inside.'),
  T('B2','hence','adverb','logical_connectors','следовательно','for this reason or therefore','He was late; hence, he missed the introduction.'),
  T('B2','namely','adverb','logical_connectors','а именно','that is to say; specifically','Only one person failed, namely John.'),
  T('B2','specifically','adverb','logical_connectors','конкретно','in a precise or exact way','She asked for help, specifically with grammar.'),
  // personal (need 3)
  T('B2','passionate','adjective','personal','страстный','having or showing strong feelings about something','She is passionate about environmental issues.'),
  T('B2','genuine','adjective','personal','подлинный','truly what it is claimed to be; sincere','His concern for the team was genuine.'),
  T('B2','earnest','adjective','personal','серьёзный','showing sincere and serious intention','He made an earnest effort to improve.'),
  // abstract (need 3)
  T('B2','criterion','noun','abstract','критерий','a standard by which something is judged','What is your main criterion for success?'),
  T('B2','conception','noun','abstract','представление','an idea or understanding of something','Her conception of happiness is different from mine.'),
  T('B2','duality','noun','abstract','двойственность','the quality of having two parts or natures','The novel explores the duality of human nature.'),
  // academic_skills (need 3)
  T('B2','evaluate','verb','academic_skills','оценивать','to judge the value, quality, or importance of something','Students must evaluate the sources they use.'),
  T('B2','restate','verb','academic_skills','перефразировать','to say something again, especially more clearly','The teacher asked him to restate his argument.'),
  T('B2','hypothesise','verb','academic_skills','выдвигать гипотезу','to form a hypothesis to explain something','Scientists hypothesise and then test their ideas.'),
  // society B2 (need 1)
  T('B2','oligarchy','noun','society','олигархия','government by a small group of powerful people','The country was effectively an oligarchy.'),
  // environment B2 (need 1)
  T('B2','biofuel','noun','environment','биотопливо','fuel made from biological materials','Biofuel is considered a cleaner energy source.'),
  // social_issues (need 1)
  T('B2','segregation','noun','social_issues','сегрегация','the practice of keeping people apart based on race or class','Racial segregation was abolished in the 1960s.'),
  // social_advanced (need 1)
  T('B2','scapegoat','noun','social_advanced','козёл отпущения','a person blamed for the mistakes or problems of others','Immigrants were used as scapegoats during the crisis.'),
];

// ─── C1 additions ────────────────────────────────────────────────────────────
const C1 = [
  // academic_discourse (need 6)
  T('C1','substantiate','verb','academic_discourse','подкреплять','to provide evidence to support a claim','You need to substantiate your argument with data.'),
  T('C1','juxtapose','verb','academic_discourse','сопоставлять','to place two things together to compare them','The author juxtaposes wealth and poverty.'),
  T('C1','elicit','verb','academic_discourse','извлекать','to draw out a response or information from someone','Good questions elicit thoughtful answers.'),
  T('C1','corroborate','verb','academic_discourse','подтверждать','to confirm or support with evidence','The witness corroborated the detective\'s theory.'),
  T('C1','extrapolate','verb','academic_discourse','экстраполировать','to extend known data to estimate unknown values','We can extrapolate from current trends.'),
  T('C1','synthesise','verb','academic_discourse','синтезировать','to combine ideas from different sources into one whole','Her essay synthesised research from multiple fields.'),
  // process_c1 (need 6)
  T('C1','benchmark','noun','process_c1','эталон','a standard used for comparing or measuring performance','We use this model as a benchmark for quality.'),
  T('C1','appraise','verb','process_c1','оценивать','to assess the value or quality of something','The manager regularly appraises staff performance.'),
  T('C1','liaise','verb','process_c1','поддерживать связь','to communicate and work together with someone','You will need to liaise with the other departments.'),
  T('C1','proactive','adjective','process_c1','проактивный','taking action in advance to deal with problems','A proactive approach prevents many issues.'),
  T('C1','contingency','noun','process_c1','непредвиденное обстоятельство','a plan for a possible future event','We need a contingency plan if this fails.'),
  T('C1','feasibility','noun','process_c1','осуществимость','the quality of being likely to succeed or be done','We need to assess the feasibility of the project.'),
  // organisation (need 5)
  T('C1','workflow','noun','organisation','рабочий процесс','the sequence of processes through which work passes','We need to improve our team\'s workflow.'),
  T('C1','compliance','noun','organisation','соответствие требованиям','the act of obeying rules or meeting requirements','The company must ensure compliance with regulations.'),
  T('C1','directive','noun','organisation','директива','an official instruction issued by an authority','The manager issued a directive on remote working.'),
  T('C1','procurement','noun','organisation','закупка','the process of obtaining goods or services','The procurement of new equipment is underway.'),
  T('C1','devolution','noun','organisation','передача полномочий','the transfer of power to a lower level of government','Devolution gave more control to regional authorities.'),
  // science C1 (need 3)
  T('C1','empiricism','noun','science','эмпиризм','the theory that all knowledge comes from experience','Empiricism underpins the scientific method.'),
  T('C1','taxonomy','noun','science','таксономия','the branch of science concerned with classification','Taxonomy helps organise living things into groups.'),
  T('C1','microbiology','noun','science','микробиология','the study of microorganisms such as bacteria and viruses','Advances in microbiology have improved medicine.'),
  // global_issues (need 3)
  T('C1','colonialism','noun','global_issues','колониализм','the policy of acquiring control over another country','Colonialism shaped the modern world map.'),
  T('C1','proxy war','noun','global_issues','война по доверенности','a conflict in which major powers support opposing sides','The region became a theatre for a proxy war.'),
  T('C1','diaspora','noun','global_issues','диаспора','people who have spread from their homeland','The Irish diaspora is found across the world.'),
  // personal_advanced (need 2)
  T('C1','equitable','adjective','personal_advanced','справедливый','fair and treating everyone in the same way','An equitable solution was found for both parties.'),
  T('C1','judicious','adjective','personal_advanced','благоразумный','having or showing good judgement and common sense','She made a judicious choice under pressure.'),
  // social_advanced C1 (need 2)
  T('C1','destabilise','verb','social_advanced','дестабилизировать','to make a system or country unstable','The scandal threatened to destabilise the government.'),
  T('C1','disaffected','adjective','social_advanced','недовольный','dissatisfied and no longer loyal or supportive','Disaffected voters stayed home on election day.'),
  // law_politics (need 1)
  T('C1','adjudicate','verb','law_politics','выносить решение','to make an official decision about a dispute','A panel of judges will adjudicate the competition.'),
  // change (need 1)
  T('C1','recalibrate','verb','change','перенастроить','to adjust something carefully to match a new situation','The company had to recalibrate its strategy.'),
  // language_advanced (need 1)
  T('C1','diction','noun','language_advanced','дикция','the style of enunciation or choice of words in speech','Clear diction is essential for public speaking.'),
  // process (need 1)
  T('C1','logistics','noun','process','логистика','the detailed organisation of a complex operation','Good logistics are essential for the event to succeed.'),
  // patterns (need 1)
  T('C1','oscillate','verb','patterns','колебаться','to move or change repeatedly between two points or states','Public opinion oscillates between support and opposition.'),
  // arts_c1 (need 1)
  T('C1','interplay','noun','arts_c1','взаимодействие','the way in which two or more things affect each other','The interplay of light and shadow creates depth.'),
  // conditions (need 1)
  T('C1','aggravate','verb','conditions','усугублять','to make a bad situation worse','Cold weather aggravates joint pain.'),
  // experiences (need 1)
  T('C1','crystallise','verb','experiences','выкристаллизовать','to make an idea or feeling clear and definite','The journey helped crystallise her thoughts.'),
];

// ─── C2 additions ────────────────────────────────────────────────────────────
const C2 = [
  // art_literature (need 4)
  T('C2','diegesis','noun','art_literature','диегезис','the narrative world in which a story takes place','The diegesis includes all events shown in the film.'),
  T('C2','metafiction','noun','art_literature','метафикция','fiction that self-consciously draws attention to itself as fiction','Her novel uses metafiction to blur reality and story.'),
  T('C2','intertextuality','noun','art_literature','интертекстуальность','the relationship between texts that reference each other','The poem is rich with intertextuality.'),
  T('C2','prolepsis','noun','art_literature','пролепсис','a narrative device that anticipates a future event','The opening scene is a prolepsis of the ending.'),
  // advanced_verbs (need 3)
  T('C2','usurp','verb','advanced_verbs','узурпировать','to take power or a position without the right to do so','He usurped the throne by force.'),
  T('C2','efface','verb','advanced_verbs','стирать','to erase or make something disappear completely','Time effaced the memory of the event.'),
  T('C2','abjure','verb','advanced_verbs','отрекаться','to formally reject or renounce a belief or claim','He abjured his earlier position on the matter.'),
  // advanced_thinking (need 3)
  T('C2','fallacious','adjective','advanced_thinking','ошибочный','based on false or misleading reasoning','His argument was logically fallacious.'),
  T('C2','deductive','adjective','advanced_thinking','дедуктивный','using known facts to reach a logical conclusion','Deductive reasoning moves from general to specific.'),
  T('C2','empiricist','noun','advanced_thinking','эмпирик','a person who believes knowledge comes from experience','Locke was a famous empiricist philosopher.'),
  // force_change (need 3)
  T('C2','disintegrate','verb','force_change','распадаться','to break apart or lose cohesion completely','The old alliance began to disintegrate.'),
  T('C2','cataclysmic','adjective','force_change','катастрофический','causing a sudden and violent upheaval','The earthquake had cataclysmic consequences.'),
  T('C2','eradicate','verb','force_change','искоренять','to completely destroy or eliminate something','The campaign aimed to eradicate poverty.'),
  // character (need 2)
  T('C2','venal','adjective','character','продажный','willing to act dishonestly in exchange for money','The venal politician accepted bribes openly.'),
  T('C2','mendacious','adjective','character','лживый','not telling the truth; lying','His mendacious account fooled everyone at first.'),
  // advanced_descriptions (need 1)
  T('C2','sempiternal','adjective','advanced_descriptions','вечный','lasting forever; eternal','The sempiternal stars guided ancient travellers.'),
  // advanced_nouns (need 1)
  T('C2','solipsism','noun','advanced_nouns','солипсизм','the view that only one\'s own mind can be known to exist','His solipsism made empathy impossible.'),
  // growth (need 1)
  T('C2','flourish','verb','growth','процветать','to grow or develop strongly; to be successful','The business flourished under her leadership.'),
];

// ─── Write additions to files ─────────────────────────────────────────────────
const fileMap = {
  'words_a1.tsv': A1,
  'words_a2.tsv': A2,
  'words_b1.tsv': B1,
  'words_b2.tsv': B2,
  'words_c1.tsv': C1,
  'words_c2.tsv': C2,
};

let totalAdded = 0;
for (const [fname, rows] of Object.entries(fileMap)) {
  const fp = path.join(ASSETS, fname);
  const toAdd = rows.filter(row => {
    const word = row.split('\t')[1].toLowerCase().trim();
    return !existing.has(word);
  });
  if (toAdd.length > 0) {
    fs.appendFileSync(fp, '\n' + toAdd.join('\n'), 'utf8');
    totalAdded += toAdd.length;
    console.log(fname + ': +' + toAdd.length + ' words');
    toAdd.forEach(r => existing.add(r.split('\t')[1].toLowerCase().trim()));
  } else {
    console.log(fname + ': nothing to add');
  }
}
console.log('\nTotal added:', totalAdded);
