import re, glob, sys

files = glob.glob('app/src/main/java/com/example/kartonki/data/WordData*.kt')
words = {}
set_topics = {}

for f in files:
    content = open(f, encoding='utf-8').read()
    for m in re.finditer(r'WordSetEntity\s*\(.*?id\s*=\s*(\d+).*?topic\s*=\s*"([^"]*)"', content, re.DOTALL):
        set_topics[int(m.group(1))] = m.group(2)
    for m in re.finditer(r'id\s*=\s*(\d+),\s*setId\s*=\s*(\d+),.*?original\s*=\s*"([^"]+)".*?rarity\s*=\s*"(\w+)"', content, re.DOTALL):
        wid, sid, word, rarity = int(m.group(1)), int(m.group(2)), m.group(3), m.group(4)
        if word not in words:
            words[word] = []
        words[word].append((sid, rarity, set_topics.get(sid, '')))

print('Topics:', set_topics.get(1041,'?'), '/', set_topics.get(1042,'?'), '/', set_topics.get(1043,'?'))

def check(label, candidates, target_rarity, target_topic):
    print(f'\n--- {label} ---')
    for w in candidates:
        if w not in words:
            print(f'  FREE {w}')
            continue
        entries = words[w]
        ok = True
        for (sid, r, topic) in entries:
            if r != target_rarity:
                print(f'  CONFLICT-RARITY {w} => {r} set={sid} topic={topic}')
                ok = False; break
            if topic == target_topic:
                print(f'  CONFLICT-TOPIC {w} => set={sid}')
                ok = False; break
        if ok:
            print(f'  OK(diff-topic) {w}')

check('1041 sport UNCOMMON',
  ['שְׁחִייָה','אִיצָּה','חֲצִי גְּמָר','נִבְחֶרֶת','הִתְחַמְּמוּת','פֶּנָלְטִי','כּוֹשֵׁר גּוּפָנִי','רַגְבִּי'],
  'UNCOMMON', set_topics.get(1041,'Спорт'))

check('1042 food UNCOMMON',
  ['שֶׁמֶן זֵית','בְּשַׂר טָחוּן','צָלוּי','אָפוּי','מָרָק','מָנָה קְטַנָּה','תַּבְלִינִים','רוֹטֶב','מְנָה עִיקָרִית','קִינּוּחַ','טִיפּ'],
  'UNCOMMON', set_topics.get(1042,'Еда и кулинария'))

check('1043 kitchen UNCOMMON',
  ['מָסָנָן','מְגֵרָה','שַׁקֲשׁוּקָה','פָּלָפֶל','מְלָח גַּס','מֵצַחַת','נְיַר אֲפִיָּה','כִּיּוּר','מִדָּה','עֵרֶבֶל','מַחְבַּת'],
  'UNCOMMON', set_topics.get(1043,'Еда и кулинария'))
