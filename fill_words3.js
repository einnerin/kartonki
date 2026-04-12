// fill_words3.js — final targeted fill, exactly the missing words per group
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
const existing = new Set();
for (const fname of ['words_a1.tsv','words_a2.tsv','words_b1.tsv','words_b2.tsv','words_c1.tsv','words_c2.tsv'])
  parseTsv(path.join(ASSETS, fname)).forEach(w => existing.add(w.WORD.toLowerCase().trim()));

const T = (level, word, pos, sg, ru, def, ex) => [level, word, pos, sg, ru, def, ex].join('\t');

const A1 = [
  // colours: need 1
  T('A1','maroon','adjective','colours','тёмно-красный','a dark brownish-red colour','She wore a maroon scarf in winter.'),
  // education: need 4
  T('A1','spell','verb','education','произносить по буквам','to say or write the letters of a word in order','Can you spell your name for me?'),
  T('A1','ask','verb','education','спрашивать','to say a question to get information','She asked the teacher for help.'),
  T('A1','tell','verb','education','говорить','to give information to someone by speaking','Tell me what you learned today.'),
  T('A1','show','verb','education','показывать','to make something visible or known to someone','She showed us how to do the exercise.'),
];

const A2 = [
  // work: need 6
  T('A2','employ','verb','work','нанимать','to pay someone to do a job for you','The company employs over two hundred people.'),
  T('A2','wages','noun','work','зарплата','money paid regularly to an employee for work done','His wages are paid every Friday.'),
  T('A2','duty','noun','work','обязанность','a task or piece of work someone is required to do','One of her duties is to answer the phone.'),
  T('A2','absence','noun','work','отсутствие','the state of being away from a place, especially work','His absence from the meeting was noted.'),
  T('A2','quit','verb','work','увольняться','to leave a job or stop doing something','She quit her job to start a business.'),
  T('A2','paperwork','noun','work','бумажная работа','documents and administrative work that needs to be completed','I spent the morning catching up on paperwork.'),
  // travel: need 3
  T('A2','stay','noun','travel','пребывание','a period of time spent in a place','We had a two-night stay at a seaside hotel.'),
  T('A2','embark','verb','travel','садиться на борт','to get onto a ship or plane at the start of a journey','Passengers should embark at gate seven.'),
  T('A2','aboard','adverb','travel','на борту','on or onto a ship, plane, or other vehicle','Welcome aboard the overnight train to Paris.'),
  // health: need 2
  T('A2','ache','noun','health','боль','a continuous dull pain in part of your body','I have an ache in my lower back.'),
  T('A2','wound','noun','health','рана','an injury to the body, especially a cut or tear','The nurse cleaned and bandaged the wound.'),
];

const B1 = [
  // work_career: need 2
  T('B1','pension','noun','work_career','пенсия','a regular payment made to someone who has retired from work','She contributes to her pension every month.'),
  T('B1','vacancy','noun','work_career','вакансия','an available job position that needs to be filled','There is a vacancy for a sales manager.'),
  // travel: need 1
  T('B1','transit','noun','travel','транзит','the process of travelling through a place on the way to another','Passengers in transit must wait in the departure lounge.'),
  // business: need 1
  T('B1','gross','adjective','business','валовой','total before any reductions such as tax or costs','The company reported a gross profit of one million.'),
  // health: need 1
  T('B1','ailment','noun','health','недомогание','a minor illness or health problem','He visited the doctor for a common ailment.'),
  // relationships: need 1
  T('B1','intimacy','noun','relationships','близость','a close personal relationship or feeling of being near to someone','Friendships develop through shared intimacy and trust.'),
  // economy: need 1
  T('B1','monetary','adjective','economy','денежный','relating to money or the currency of a country','The government adopted a tight monetary policy.'),
  // media: need 1
  T('B1','portal','noun','media','портал','a website that acts as a gateway to other sites or information','The school has an online portal for students.'),
  // history: need 1
  T('B1','chronicle','noun','history','хроника','a detailed written record of historical events in order','The monk wrote a chronicle of the kingdom.'),
];

const B2 = [
  // culture: need 4
  T('B2','festival','noun','culture','фестиваль','an organised series of events or performances','The town holds an annual music festival in July.'),
  T('B2','belief','noun','culture','верование','a feeling that something is true or a principle held as true','Religious belief shapes many cultural practices.'),
  T('B2','sacred','adjective','culture','священный','connected with a religion or deserving of great respect','The mountain is considered sacred by the local people.'),
  T('B2','rite','noun','culture','обряд','a formal ceremony or procedure prescribed by tradition','Marriage is a rite that marks the start of a new life.'),
  // business: need 2
  T('B2','equity','noun','business','акционерный капитал','the value of the shares issued by a company','She owns a ten per cent equity stake in the firm.'),
  T('B2','asset','noun','business','актив','a resource owned by a company with economic value','The building is the company\'s most valuable asset.'),
  // communication: need 2
  T('B2','eloquence','noun','communication','красноречие','the ability to express ideas clearly and effectively in speech','Her eloquence won over the audience immediately.'),
  T('B2','candid','adjective','communication','откровенный','truthful and straightforward in what you say','He gave a candid assessment of the situation.'),
  // psychology: need 1
  T('B2','mindfulness','noun','psychology','осознанность','the practice of being fully aware of the present moment','Mindfulness meditation can reduce anxiety.'),
  // media: need 1
  T('B2','outlet','noun','media','издание','a newspaper, television channel, or website that provides news','The story was covered by every major news outlet.'),
  // abstract: need 1
  T('B2','antithesis','noun','abstract','антитезис','the direct opposite of something','Cruelty is the antithesis of kindness.'),
  // academic_skills: need 1
  T('B2','citation','noun','academic_skills','цитирование','a reference to a source of information used in your work','Each claim requires a proper citation.'),
  // risk_danger: need 1
  T('B2','negligence','noun','risk_danger','халатность','failure to take proper care, resulting in harm to others','The accident was caused by negligence on the road.'),
];

const C1 = [
  // academic_discourse: need 5
  T('C1','elucidate','verb','academic_discourse','разъяснять','to make something clear and easy to understand','Can you elucidate your argument further?'),
  T('C1','delineate','verb','academic_discourse','очерчивать','to describe or explain something precisely and clearly','The report delineates the key findings of the study.'),
  T('C1','expound','verb','academic_discourse','излагать','to explain and develop an idea in detail','He expounded his theory at the conference.'),
  T('C1','enumerate','verb','academic_discourse','перечислять','to mention a number of things one by one','She enumerated the reasons for her decision.'),
  T('C1','circumscribe','verb','academic_discourse','ограничивать','to restrict something within certain limits','The law circumscribes the power of the government.'),
  // organisation: need 2
  T('C1','delegation','noun','organisation','делегирование','the act of giving tasks or authority to someone else','Effective delegation is a key management skill.'),
  T('C1','induction','noun','organisation','вводный инструктаж','the process of introducing a new employee to their role','All new staff attend a two-day induction.'),
  // process_c1: need 1
  T('C1','pilot','adjective','process_c1','пилотный','done as a test before being applied more widely','We ran a pilot scheme before the full launch.'),
];

const C2 = [
  // advanced_thinking: need 2
  T('C2','apodeictic','adjective','advanced_thinking','аподиктический','necessarily true; demonstrably certain beyond doubt','His argument was presented as apodeictic truth.'),
  T('C2','aleatory','adjective','advanced_thinking','случайный','depending on chance or involving random elements','The aleatory structure of the poem mirrors life\'s unpredictability.'),
];

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
  const toAdd = rows.filter(row => !existing.has(row.split('\t')[1].toLowerCase().trim()));
  if (toAdd.length > 0) {
    fs.appendFileSync(fp, '\n' + toAdd.join('\n'), 'utf8');
    totalAdded += toAdd.length;
    console.log(fname + ': +' + toAdd.length + ' (' + toAdd.map(r=>r.split('\t')[1]).join(', ') + ')');
    toAdd.forEach(r => existing.add(r.split('\t')[1].toLowerCase().trim()));
  }
}
console.log('\nTotal added:', totalAdded);
