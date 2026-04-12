const fs = require('fs');
const path = require('path');

const ASSETS = 'app/src/main/assets';
const OUT = 'app/src/main/java/com/example/kartonki/data/SeedData.kt';

const LEVEL_TO_RARITY = { A1:'COMMON', A2:'COMMON', B1:'UNCOMMON', B2:'RARE', C1:'EPIC', C2:'LEGENDARY' };
const RARITY_ORDER = ['COMMON','UNCOMMON','RARE','EPIC','LEGENDARY'];

const GROUP_NAMES = {
  'family':'Семья','body':'Тело человека','food':'Еда и продукты','home':'Дом',
  'colours':'Цвета и описания','basic verbs':'Основные глаголы','numbers':'Числа и счёт',
  'animals':'Животные','shopping':'Магазины и покупки','transport':'Транспорт',
  'weather':'Погода','school':'Школа','sport':'Спорт','work':'Работа и офис',
  'technology':'Технологии','health':'Здоровье','geography':'География',
  'clothing':'Одежда','travel':'Путешествия','restaurant':'Еда в ресторане',
  'career':'Карьера','nature':'Природа','emotions':'Эмоции','society':'Общество',
  'business':'Бизнес','language':'Язык и общение','personal development':'Личностный рост',
  'education':'Образование','relationships':'Отношения','environment':'Окружающая среда',
  'economy':'Экономика','media':'СМИ','history':'История','arts':'Искусство',
  'science':'Наука','daily life':'Повседневная жизнь','academic':'Академический язык',
  'politics':'Политика','psychology':'Психология','social issues':'Социальные проблемы',
  'personal qualities':'Личные качества','abstract':'Абстрактные понятия',
  'logic':'Логика','behaviour':'Поведение','law':'Право',
  'discourse':'Академический дискурс','change':'Изменения','global issues':'Глобальные проблемы',
  'values':'Ценности','organisation':'Организация','rare adjectives':'Редкие прилагательные',
  'rare verbs':'Редкие глаголы','rare nouns':'Редкие существительные',
  'character':'Ум и характер','literature':'Литература','growth':'Рост и влияние',
  'risk':'Риски','communication':'Коммуникация','logical connectors':'Логические связки',
};

const GROUP_DESC = {
  'family':'Слова о семье и близких','body':'Части тела','food':'Продукты и напитки',
  'home':'Дом и мебель','colours':'Цвета и базовые прилагательные',
  'basic verbs':'Самые важные глаголы','numbers':'Числа и счёт',
  'animals':'Домашние и дикие животные','shopping':'Шоппинг и покупки',
  'transport':'Средства передвижения','weather':'Погодные явления',
  'school':'Образование и учёба','sport':'Виды спорта','work':'Профессиональная лексика',
  'technology':'Гаджеты и интернет','health':'Здоровье и медицина',
  'geography':'Страны и места','clothing':'Одежда и стиль',
  'travel':'Туризм и поездки','restaurant':'Ресторан и меню',
  'career':'Карьера и профессиональный рост','nature':'Окружающий мир',
  'emotions':'Чувства и эмоции','society':'Общество и государство',
  'business':'Бизнес-лексика','language':'Язык и коммуникация',
  'personal development':'Личностный рост','education':'Система образования',
  'relationships':'Межличностные отношения','environment':'Экология',
  'economy':'Экономика и финансы','media':'СМИ и технологии',
  'history':'История и культура','arts':'Искусство','science':'Наука',
  'daily life':'Повседневная жизнь','academic':'Академический язык B2',
  'politics':'Политика и общество','psychology':'Психология',
  'social issues':'Социальные проблемы','personal qualities':'Черты личности',
  'abstract':'Абстрактные понятия','logic':'Логика и аргументация',
  'behaviour':'Поведение и риски','law':'Право и законодательство',
  'discourse':'Академический дискурс C1','change':'Процессы изменений',
  'global issues':'Глобальные проблемы','values':'Ценности и убеждения',
  'organisation':'Управление и организация',
  'rare adjectives':'Изысканные прилагательные C2','rare verbs':'Изысканные глаголы C2',
  'rare nouns':'Редкие существительные C2','character':'Описание ума и характера',
  'literature':'Термины литературы','growth':'Рост, влияние и изменения',
  'risk':'Риски и последствия','communication':'Общение и дискуссия',
  'logical connectors':'Логические связи',
};

function esc(s) {
  return (s||'').replace(/\\/g,'\\\\').replace(/"/g,'\\"').replace(/\$/g,'\\$');
}

function parseTsv(filePath) {
  const text = fs.readFileSync(filePath, 'utf8');
  const lines = text.split('\n').filter(l => l.trim());
  const headers = lines[0].split('\t').map(h => h.trim());
  return lines.slice(1).map(line => {
    const cols = line.split('\t');
    const obj = {};
    headers.forEach((h, i) => obj[h] = (cols[i]||'').trim());
    return obj;
  });
}

// 1. Read all TSV files
let allWords = [];
for (const fname of ['words_a1.tsv','words_a2.tsv','words_b1.tsv','words_b2.tsv','words_c1.tsv','words_c2.tsv']) {
  allWords = allWords.concat(parseTsv(path.join(ASSETS, fname)));
}

// 2. Deduplicate
const seen = new Set();
const words = [];
for (const w of allWords) {
  const key = w.WORD.toLowerCase().trim();
  if (!seen.has(key)) { seen.add(key); words.push(w); }
}
console.log(`Total unique words: ${words.length}`);

// 3. Group by (rarity, semanticGroup)
const groups = {};
for (const w of words) {
  const rarity = LEVEL_TO_RARITY[w.LEVEL.trim()] || 'COMMON';
  const sg = (w.SEMANTIC_GROUP||'').trim().toLowerCase();
  const key = rarity + '|' + sg;
  if (!groups[key]) groups[key] = [];
  groups[key].push(w);
}

// 4. Build sets
const setsList = [];
let setId = 1;
for (const rarity of RARITY_ORDER) {
  const rarityGroups = Object.entries(groups)
    .filter(([k]) => k.startsWith(rarity + '|'))
    .map(([k, ws]) => [k.split('|')[1], ws])
    .sort((a, b) => a[0].localeCompare(b[0]));
  for (const [sg, ws] of rarityGroups) {
    const chunks = [];
    for (let i = 0; i < ws.length; i += 25) chunks.push(ws.slice(i, i+25));
    const fullChunks = chunks.filter(c => c.length >= 25);
    for (let idx = 0; idx < fullChunks.length; idx++) {
      const baseName = GROUP_NAMES[sg] || sg.charAt(0).toUpperCase() + sg.slice(1);
      const name = fullChunks.length === 1 ? baseName : `${baseName} ${idx+1}`;
      const desc = GROUP_DESC[sg] || `Лексика: ${sg}`;
      setsList.push({ setId, rarity, sg, name, desc, words: fullChunks[idx] });
      setId++;
    }
  }
}
console.log(`Total sets: ${setsList.length}`);

// 5. Build word entries
const wordEntries = [];
let wordId = 1;
for (const s of setsList) {
  for (const w of s.words) {
    wordEntries.push({ wordId, setId: s.setId, rarity: s.rarity, sg: s.sg, w });
    wordId++;
  }
}

// 6. Build prebuilt decks (level=3: 8C 6U 4R 2E 1L)
const byRarity = { COMMON:[], UNCOMMON:[], RARE:[], EPIC:[], LEGENDARY:[] };
for (const e of wordEntries) byRarity[e.rarity].push(e.w.WORD.toLowerCase().trim());

const deckDefs = [
  { name:'Для новичков',   groups:['family','body','food','home','basic verbs'] },
  { name:'Путешественник', groups:['transport','travel','geography','weather','nature'] },
  { name:'Бизнес-лексика', groups:['shopping','work','career','business','economy'] },
  { name:'Академический',  groups:['school','education','academic','science','logic'] },
  { name:'Мастер слова',   groups:['emotions','language','arts','literature','character'] },
];

const targets = { COMMON:8, UNCOMMON:6, RARE:4, EPIC:2, LEGENDARY:1 };

const prebuilt = deckDefs.map(deck => {
  const used = new Set();
  const originals = [];
  const counts = { COMMON:0, UNCOMMON:0, RARE:0, EPIC:0, LEGENDARY:0 };

  // Prefer words from relevant groups
  for (const grp of deck.groups) {
    const pool = wordEntries.filter(e => e.sg === grp);
    for (const r of RARITY_ORDER) {
      const needed = targets[r] - counts[r];
      if (needed <= 0) continue;
      let added = 0;
      for (const e of pool) {
        if (added >= needed) break;
        const word = e.w.WORD.toLowerCase().trim();
        if (e.rarity === r && !used.has(word)) {
          originals.push(word); used.add(word); counts[r]++; added++;
        }
      }
    }
  }

  // Fallback: fill remaining from global pool
  for (const r of RARITY_ORDER) {
    let needed = targets[r] - counts[r];
    for (const word of byRarity[r]) {
      if (needed <= 0) break;
      if (!used.has(word)) { originals.push(word); used.add(word); counts[r]++; needed--; }
    }
  }

  return { name: deck.name, originals: originals.slice(0, 21) };
});

// 7. Generate Kotlin
const lines = [];
lines.push('package com.example.kartonki.data\n');
lines.push('import com.example.kartonki.data.db.entity.WordEntity');
lines.push('import com.example.kartonki.data.db.entity.WordSetEntity\n');
lines.push('object SeedData {\n');
lines.push('    // ── Sets ──────────────────────────────────────────────────────────────────');
lines.push('    val sets: List<WordSetEntity> = listOf(');
for (const s of setsList) {
  const comma = s.setId < setsList[setsList.length-1].setId ? ',' : '';
  lines.push(`        WordSetEntity(id = ${s.setId}, name = "${esc(s.name)}", description = "${esc(s.desc)}", orderIndex = ${s.setId-1})${comma}`);
}
lines.push('    )\n');
// Split words into chunks of 200 to avoid JVM 64KB method size limit
lines.push('    // ── Words ──────────────────────────────────────────────────────────────────');
const CHUNK_SIZE = 200;
const numChunks = Math.ceil(wordEntries.length / CHUNK_SIZE);
// Generate private chunk functions
let prevSetId = null;
for (let chunk = 0; chunk < numChunks; chunk++) {
  const start = chunk * CHUNK_SIZE;
  const end = Math.min(start + CHUNK_SIZE, wordEntries.length);
  lines.push(`    private fun words${chunk + 1}(): List<WordEntity> = listOf(`);
  for (let i = start; i < end; i++) {
    const { wordId, setId, rarity, sg, w } = wordEntries[i];
    if (setId !== prevSetId) {
      const setName = setsList.find(s => s.setId === setId)?.name || '';
      lines.push(`        // ━━━ SET ${setId} — ${rarity} — ${setName} ━━━`);
      prevSetId = setId;
    }
    const comma = i < end - 1 ? ',' : '';
    lines.push(`        WordEntity(id = ${wordId}, original = "${esc(w.WORD.trim().toLowerCase())}", translation = "${esc(w.RUSSIAN_TRANSLATION)}", rarity = "${rarity}", setId = ${setId}, languagePair = "en-ru", pos = "${esc((w.POS||'').toLowerCase())}", semanticGroup = "${esc(sg)}",`);
    lines.push(`            definition = "${esc(w.DEFINITION)}",`);
    lines.push(`            example = "${esc(w.EXAMPLE_SENTENCE)}")${comma}`);
  }
  lines.push('    )');
}
// Combine chunks
const combineParts = Array.from({length: numChunks}, (_, i) => `words${i + 1}()`).join(' + ');
lines.push(`    val words: List<WordEntity> = ${combineParts}\n`);
lines.push('    // ── Pre-built Decks ───────────────────────────────────────────────────────\n');
lines.push('    data class DeckSeed(val name: String, val level: Int = 1, val wordOriginals: List<String>)\n');
lines.push('    val prebuiltDecks: List<DeckSeed> = listOf(');
for (let i = 0; i < prebuilt.length; i++) {
  const { name, originals } = prebuilt[i];
  const comma = i < prebuilt.length - 1 ? ',' : '';
  lines.push(`        DeckSeed(`);
  lines.push(`            name = "${esc(name)}",`);
  lines.push(`            level = 3,`);
  lines.push(`            wordOriginals = listOf(`);
  lines.push(originals.map(o => `                "${o}"`).join(',\n') + ',');
  lines.push(`            ),`);
  lines.push(`        )${comma}`);
}
lines.push('    )');
lines.push('}');

const content = lines.join('\n');
fs.writeFileSync(OUT, content, 'utf8');
console.log(`Written ${OUT}: ${wordEntries.length} words, ${setsList.length} sets`);
