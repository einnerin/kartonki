#!/usr/bin/env python3
"""Generates SeedData.kt from Cambridge CEFR TSV files."""

import csv, os, textwrap

ASSETS = "app/src/main/assets"
OUT = "app/src/main/java/com/example/kartonki/data/SeedData.kt"

LEVEL_TO_RARITY = {"A1": "COMMON", "A2": "COMMON", "B1": "UNCOMMON",
                   "B2": "RARE", "C1": "EPIC", "C2": "LEGENDARY"}

RARITY_ORDER = ["COMMON", "UNCOMMON", "RARE", "EPIC", "LEGENDARY"]

# Russian names for semantic groups
GROUP_NAMES = {
    "family": "Семья", "body": "Тело человека", "food": "Еда и продукты",
    "home": "Дом", "colours": "Цвета и описания", "basic verbs": "Основные глаголы",
    "numbers": "Числа и счёт", "animals": "Животные", "shopping": "Магазины и покупки",
    "transport": "Транспорт", "weather": "Погода", "school": "Школа и учёба",
    "sport": "Спорт", "work": "Работа и офис", "technology": "Технологии",
    "health": "Здоровье", "geography": "География", "clothing": "Одежда",
    "travel": "Путешествия", "restaurant": "Еда в ресторане",
    "career": "Карьера и работа", "nature": "Природа", "emotions": "Эмоции",
    "society": "Общество", "business": "Бизнес", "language": "Язык и общение",
    "personal development": "Личностный рост", "education": "Образование",
    "relationships": "Отношения", "environment": "Окружающая среда",
    "economy": "Экономика", "media": "СМИ", "history": "История",
    "arts": "Искусство", "science": "Наука", "daily life": "Повседневная жизнь",
    "academic": "Академический язык", "politics": "Политика",
    "psychology": "Психология", "social issues": "Социальные проблемы",
    "personal qualities": "Личные качества", "abstract": "Абстрактные понятия",
    "logic": "Логика и аргументация", "behaviour": "Поведение",
    "law": "Право", "discourse": "Академический дискурс",
    "change": "Изменения и процессы", "global issues": "Глобальные проблемы",
    "values": "Личные ценности", "organisation": "Организация",
    "rare adjectives": "Редкие прилагательные", "rare verbs": "Редкие глаголы",
    "rare nouns": "Редкие существительные", "character": "Ум и характер",
    "literature": "Литература и искусство", "growth": "Рост и изменения",
    "risk": "Риски", "communication": "Коммуникация",
    "logical connectors": "Логические связки",
}

def group_desc(group):
    descs = {
        "family": "Слова о семье и близких", "body": "Части тела",
        "food": "Продукты и напитки", "home": "Дом и мебель",
        "colours": "Цвета и базовые прилагательные", "basic verbs": "Самые важные глаголы",
        "numbers": "Числа и счёт", "animals": "Домашние и дикие животные",
        "shopping": "Шоппинг, деньги и цены", "transport": "Средства передвижения",
        "weather": "Погодные явления", "school": "Образование и учёба",
        "sport": "Виды спорта", "work": "Профессиональная лексика",
        "technology": "Гаджеты и интернет", "health": "Здоровье и медицина",
        "geography": "Страны и места", "clothing": "Одежда и стиль",
        "travel": "Туризм и поездки", "restaurant": "Ресторан и меню",
        "career": "Карьера и профессиональный рост", "nature": "Окружающий мир",
        "emotions": "Чувства и эмоции", "society": "Общество и государство",
        "business": "Бизнес-лексика", "language": "Язык и коммуникация",
        "personal development": "Личностный рост", "education": "Система образования",
        "relationships": "Межличностные отношения", "environment": "Экология",
        "economy": "Экономика и финансы", "media": "СМИ и технологии",
        "history": "История и культура", "arts": "Искусство и культура",
        "science": "Наука и исследования", "daily life": "Повседневная жизнь",
        "academic": "Академический язык B2", "politics": "Политика и общество",
        "psychology": "Психология", "social issues": "Социальные проблемы",
        "personal qualities": "Черты личности", "abstract": "Абстрактные понятия",
        "logic": "Логика и аргументация", "behaviour": "Поведение и риски",
        "law": "Право и законодательство", "discourse": "Академический дискурс C1",
        "change": "Процессы изменений", "global issues": "Глобальные проблемы",
        "values": "Ценности и убеждения", "organisation": "Управление и организация",
        "rare adjectives": "Изысканные прилагательные C2",
        "rare verbs": "Изысканные глаголы C2",
        "rare nouns": "Редкие существительные C2",
        "character": "Описание ума и характера C2",
        "literature": "Термины литературы и искусства",
        "growth": "Влияние, рост и изменения",
        "risk": "Риски и последствия",
        "communication": "Общение и дискуссия",
        "logical connectors": "Логические связи",
    }
    return descs.get(group, f"Лексика: {group}")

def esc(s):
    return s.replace('\\', '\\\\').replace('"', '\\"').replace('$', '\\$')

def main():
    # 1. Read all TSV files
    words = []
    for fname in ["words_a1.tsv", "words_a2.tsv", "words_b1.tsv",
                  "words_b2.tsv", "words_c1.tsv", "words_c2.tsv"]:
        path = os.path.join(ASSETS, fname)
        with open(path, encoding="utf-8") as f:
            reader = csv.DictReader(f, delimiter="\t")
            for row in reader:
                words.append(row)

    # 2. Deduplicate by WORD
    seen = set()
    unique = []
    for w in words:
        key = w["WORD"].lower().strip()
        if key not in seen:
            seen.add(key)
            unique.append(w)
    words = unique

    # 3. Group by (rarity, semantic_group)
    from collections import defaultdict
    groups = defaultdict(list)
    for w in words:
        rarity = LEVEL_TO_RARITY.get(w["LEVEL"].strip(), "COMMON")
        sg = w["SEMANTIC_GROUP"].strip().lower()
        groups[(rarity, sg)].append(w)

    # 4. Build sets — split large groups into sets of 25
    sets_list = []   # (set_id, rarity, group, name, description, words[])
    set_id = 1
    for rarity in RARITY_ORDER:
        # Sort groups alphabetically within rarity for stable output
        rarity_groups = sorted(
            [(sg, ws) for (r, sg), ws in groups.items() if r == rarity],
            key=lambda x: x[0]
        )
        for sg, ws in rarity_groups:
            # Split into chunks of 25
            chunks = [ws[i:i+25] for i in range(0, len(ws), 25)]
            for idx, chunk in enumerate(chunks):
                base_name = GROUP_NAMES.get(sg, sg.capitalize())
                name = base_name if len(chunks) == 1 else f"{base_name} {idx+1}"
                desc = group_desc(sg)
                sets_list.append((set_id, rarity, sg, name, desc, chunk))
                set_id += 1

    # 5. Assign word ids and build word list
    word_entries = []
    word_id = 1
    for (sid, rarity, sg, name, desc, ws) in sets_list:
        for w in ws:
            word_entries.append((word_id, sid, rarity, sg, w))
            word_id += 1

    # 6. Pick prebuilt deck words (level=3: 8C 6U 4R 2E 1L)
    by_rarity = defaultdict(list)
    for (wid, sid, rarity, sg, w) in word_entries:
        by_rarity[rarity].append(w["WORD"].lower().strip())

    def pick(rarity, n, exclude):
        result = []
        for wd in by_rarity[rarity]:
            if wd not in exclude and len(result) < n:
                result.append(wd)
                exclude.add(wd)
        return result

    deck_defs = [
        ("Для новичков",   ["family","body","food","home","basic verbs"]),
        ("Путешественник", ["transport","travel","geography","weather","nature"]),
        ("Бизнес-лексика", ["shopping","work","career","business","economy"]),
        ("Академический",  ["school","education","academic","science","logic"]),
        ("Мастер слова",   ["emotions","language","arts","literature","character"]),
    ]

    prebuilt = []
    for deck_name, pref_groups in deck_defs:
        used = set()
        originals = []
        # Pick preferring relevant groups
        for grp in pref_groups:
            pool = [w["WORD"].lower().strip()
                    for (wid, sid, rarity, sg, w) in word_entries
                    if sg == grp and w["WORD"].lower().strip() not in used]
            for r, n in [("COMMON",8),("UNCOMMON",6),("RARE",4),("EPIC",2),("LEGENDARY",1)]:
                needed = n - sum(1 for o in originals if
                    next((wr for (wi,si,wr,wg,ww) in word_entries
                          if ww["WORD"].lower().strip()==o), None) == r)
                if needed <= 0:
                    continue
                for wd in pool:
                    wr = next((wr for (wi,si,wr,wg,ww) in word_entries
                               if ww["WORD"].lower().strip()==wd for ww in [ww]), None)
                    # find rarity of this word
                    wr2 = next((wr for (wi,si,wr,wg,ww) in word_entries
                                if ww["WORD"].lower().strip()==wd), None)
                    if wr2 == r and wd not in used:
                        originals.append(wd)
                        used.add(wd)
                        needed -= 1
                        if needed <= 0:
                            break
        # Fallback: fill missing slots
        counts = defaultdict(int)
        for o in originals:
            r = next((wr for (wi,si,wr,wg,ww) in word_entries
                      if ww["WORD"].lower().strip()==o), "COMMON")
            counts[r] += 1
        targets = {"COMMON":8,"UNCOMMON":6,"RARE":4,"EPIC":2,"LEGENDARY":1}
        for r, target in targets.items():
            needed = target - counts[r]
            for wd in by_rarity[r]:
                if needed <= 0:
                    break
                if wd not in used:
                    originals.append(wd)
                    used.add(wd)
                    needed -= 1
        prebuilt.append((deck_name, originals[:21]))

    # 7. Generate Kotlin
    lines = []
    lines.append("package com.example.kartonki.data\n")
    lines.append("import com.example.kartonki.data.db.entity.WordEntity")
    lines.append("import com.example.kartonki.data.db.entity.WordSetEntity\n")
    lines.append("object SeedData {\n")
    lines.append("    // ── Sets ──────────────────────────────────────────────────────────────────")
    lines.append("    val sets: List<WordSetEntity> = listOf(")
    for (sid, rarity, sg, name, desc, ws) in sets_list:
        comma = "," if sid < sets_list[-1][0] else ""
        lines.append(f'        WordSetEntity(id = {sid}, name = "{esc(name)}", description = "{esc(desc)}", orderIndex = {sid-1}){comma}')
    lines.append("    )\n")
    lines.append("    // ── Words ──────────────────────────────────────────────────────────────────")
    lines.append("    val words: List<WordEntity> = listOf(")

    prev_sid = None
    for i, (wid, sid, rarity, sg, w) in enumerate(word_entries):
        if sid != prev_sid:
            set_name = next(s[3] for s in sets_list if s[0]==sid)
            lines.append(f"        // ━━━ SET {sid} — {rarity} — {set_name} ━━━")
            prev_sid = sid
        comma = "," if i < len(word_entries)-1 else ""
        orig = esc(w["WORD"].strip().lower())
        trans = esc(w["RUSSIAN_TRANSLATION"].strip())
        defn = esc(w["DEFINITION"].strip())
        ex = esc(w["EXAMPLE_SENTENCE"].strip())
        pos = esc(w["POS"].strip().lower())
        sgr = esc(w["SEMANTIC_GROUP"].strip().lower())
        lines.append(f'        WordEntity(id = {wid}, original = "{orig}", translation = "{trans}", rarity = "{rarity}", setId = {sid}, languagePair = "en-ru", pos = "{pos}", semanticGroup = "{sgr}",')
        lines.append(f'            definition = "{defn}",')
        lines.append(f'            example = "{ex}"){comma}')

    lines.append("    )\n")
    lines.append("    // ── Pre-built Decks ───────────────────────────────────────────────────────\n")
    lines.append("    data class DeckSeed(val name: String, val level: Int = 1, val wordOriginals: List<String>)\n")
    lines.append("    val prebuiltDecks: List<DeckSeed> = listOf(")
    for i, (dname, originals) in enumerate(prebuilt):
        comma = "," if i < len(prebuilt)-1 else ""
        lines.append(f'        DeckSeed(')
        lines.append(f'            name = "{esc(dname)}",')
        lines.append(f'            level = 3,')
        lines.append(f'            wordOriginals = listOf(')
        word_lines = [f'                "{o}"' for o in originals]
        lines.append(",\n".join(word_lines) + ",")
        lines.append(f'            ),')
        lines.append(f'        ){comma}')
    lines.append("    )")
    lines.append("}")

    content = "\n".join(lines)
    with open(OUT, "w", encoding="utf-8") as f:
        f.write(content)
    print(f"Written {OUT}: {len(word_entries)} words, {len(sets_list)} sets")

if __name__ == "__main__":
    main()
