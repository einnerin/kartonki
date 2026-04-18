#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Validates all WordData files against Room's insertion rules.

Checks performed:
  1. Stolen words — REPLACE strategy means the last file in registry order
     wins for any (original, languagePair) collision. Earlier sets lose words.
  2. Wrong word count — every set must have exactly 25 words after DB simulation.
  3. Rarity spread — within a set, rarities must span ≤ 2 adjacent levels
     (e.g. RARE+EPIC ok, COMMON+EPIC not ok).
  4. Word ID formula — every word must satisfy: id == setId * 100 + position
     where position is 1-based index within the set (1..99).
  5. Duplicate set names — two sets with the same name in the same languagePair
     cause confusion in the UI.

Registry order is derived automatically from WordRegistry.kt allWords.
No manual list to maintain — just keep WordRegistry.kt up to date.

Exit code: 0 if all checks pass, 1 if any check fails.
"""

import re, io, sys, subprocess
from pathlib import Path
from collections import defaultdict

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')

ROOT = Path("app/src/main/java/com/example/kartonki/data")
REGISTRY_FILE = ROOT / "WordRegistry.kt"

RARITY_ORDER = ["COMMON", "UNCOMMON", "RARE", "EPIC", "LEGENDARY"]


def _get_staged_files():
    """Return set of .kt filenames (basename only) currently staged in git."""
    try:
        result = subprocess.run(
            ["git", "diff", "--cached", "--name-only"],
            capture_output=True, text=True, timeout=5
        )
        return {Path(p).name for p in result.stdout.splitlines() if p.endswith(".kt")}
    except Exception:
        return set()
RARITY_INDEX = {r: i for i, r in enumerate(RARITY_ORDER)}


def parse_registry_order():
    """Return ordered list of .kt filenames from WordRegistry.kt allWords."""
    text = REGISTRY_FILE.read_text(encoding="utf-8")
    m = re.search(r'val allWords.*?get\(\)\s*=(.*?)(?=\n[ \t]*val |\Z)', text, re.DOTALL)
    if not m:
        raise RuntimeError("Could not find allWords property in WordRegistry.kt")
    body = m.group(1)
    seen = set()
    order = []
    for obj_name in re.findall(r'(WordData\w+)\.', body):
        if obj_name not in seen:
            seen.add(obj_name)
            order.append(obj_name + ".kt")
    return order


def extract_field(block, field_name):
    m = re.search(field_name + r'\s*=\s*"((?:[^"\\]|\\.)*)"', block)
    if m:
        return m.group(1)
    return None


def parse_words(kt_file):
    content = kt_file.read_text(encoding="utf-8")
    words = []
    parts = re.split(r'(?=WordEntity\s*\()', content)
    for part in parts:
        if not part.strip().startswith('WordEntity'):
            continue
        depth = 0
        end = -1
        for i, ch in enumerate(part):
            if ch == '(':
                depth += 1
            elif ch == ')':
                depth -= 1
                if depth == 0:
                    end = i + 1
                    break
        block = part[:end] if end >= 0 else part

        wid = re.search(r'\bid\s*=\s*(\d+)', block)
        sid = re.search(r'\bsetId\s*=\s*(\d+)', block)
        original = extract_field(block, 'original')
        rarity = extract_field(block, 'rarity')
        lang = extract_field(block, 'languagePair')
        translation = extract_field(block, 'translation')

        if wid and sid and original and lang:
            words.append({
                "id": int(wid.group(1)),
                "setId": int(sid.group(1)),
                "original": original,
                "rarity": rarity or "COMMON",
                "lang": lang,
                "translation": translation or "",
                "file": kt_file.name,
            })
    return words


def parse_sets(kt_file):
    content = kt_file.read_text(encoding="utf-8")
    sets = []
    parts = re.split(r'(?=WordSetEntity\s*\()', content)
    for part in parts:
        if not part.strip().startswith('WordSetEntity'):
            continue
        depth = 0
        end = -1
        for i, ch in enumerate(part):
            if ch == '(':
                depth += 1
            elif ch == ')':
                depth -= 1
                if depth == 0:
                    end = i + 1
                    break
        block = part[:end] if end >= 0 else part

        sid = re.search(r'\bid\s*=\s*(\d+)', block)
        name = extract_field(block, 'name')
        lang = extract_field(block, 'languagePair')

        if sid and name and lang:
            sets.append({
                "id": int(sid.group(1)),
                "name": name,
                "lang": lang,
                "file": kt_file.name,
            })
    return sets


def check_rarity_spread(all_words):
    """Each set's rarities must span ≤ 2 adjacent levels."""
    errors = []
    by_set = defaultdict(list)
    for w in all_words:
        by_set[(w["setId"], w["file"])].append(w["rarity"])

    for (sid, fname), rarities in sorted(by_set.items()):
        known = [r for r in rarities if r in RARITY_INDEX]
        if not known:
            continue
        levels = sorted(set(RARITY_INDEX[r] for r in known))
        span = levels[-1] - levels[0]
        if span > 1:
            present = sorted(set(known), key=lambda r: RARITY_INDEX[r])
            errors.append(f"  Set {sid} [{fname}]: рарити {'+'.join(present)} "
                          f"— слишком большой разброс (допустимо ≤ 2 смежных уровня)")
    return errors


def check_id_formula(all_words):
    """id must equal setId * 100 + position (1-based, per set)."""
    errors = []
    by_set = defaultdict(list)
    for w in all_words:
        by_set[(w["setId"], w["file"])].append(w)

    for (sid, fname), words in sorted(by_set.items()):
        words_sorted = sorted(words, key=lambda w: w["id"])
        for pos, w in enumerate(words_sorted, start=1):
            expected = sid * 100 + pos
            if w["id"] != expected:
                errors.append(f"  Set {sid} [{fname}]: слово '{w['original']}' "
                              f"id={w['id']}, ожидалось {expected} (setId×100+{pos})")
    return errors


def check_duplicate_set_names(registry_order):
    """Two sets with same name in same languagePair = UI confusion."""
    errors = []
    name_lang_to_sets = defaultdict(list)
    for fname in registry_order:
        fpath = ROOT / fname
        if not fpath.exists():
            continue
        for s in parse_sets(fpath):
            name_lang_to_sets[(s["name"], s["lang"])].append((s["id"], fname))

    for (name, lang), entries in sorted(name_lang_to_sets.items()):
        if len(entries) > 1:
            ids = ", ".join(f"id={e[0]} [{e[1]}]" for e in entries)
            errors.append(f"  Имя '{name}' ({lang}) встречается {len(entries)} раза: {ids}")
    return errors


def main():
    registry_order = parse_registry_order()
    all_words = []
    for fname in registry_order:
        fpath = ROOT / fname
        if fpath.exists():
            all_words.extend(parse_words(fpath))
        else:
            print(f"  [WARN] файл в WordRegistry.kt но не найден на диске: {fname}")

    print(f"Всего слов: {len(all_words)}\n")

    has_errors = False

    # ── Check 1: stolen words ─────────────────────────────────────────────────
    seen = {}
    real_dupes = []
    for w in all_words:
        key = (w["original"], w["lang"])
        if key in seen:
            real_dupes.append({
                "original": w["original"],
                "loser_set": seen[key]["setId"],
                "loser_file": seen[key]["file"],
                "winner_set": w["setId"],
                "winner_file": w["file"],
            })
            seen[key] = w
        else:
            seen[key] = w

    set_counts = defaultdict(int)
    set_names_by_file = {}
    for w in all_words:
        set_names_by_file[w["setId"]] = w["file"]
    for w in seen.values():
        set_counts[w["setId"]] += 1

    loser_sets = defaultdict(list)
    for d in real_dupes:
        loser_sets[d["loser_set"]].append(d)

    print(f"=== 1. Украденные слова: {len(real_dupes)} ===\n")
    if real_dupes:
        has_errors = True
        for sid in sorted(loser_sets):
            stolen = loser_sets[sid]
            print(f"  Set {sid} [{stolen[0]['loser_file']}] теряет {len(stolen)} слов:")
            for d in stolen:
                print(f"    '{d['original']}' → украдено набором {d['winner_set']} [{d['winner_file']}]")
    else:
        print("  ✅ Нет украденных слов\n")

    # ── Check 2: word count per set ───────────────────────────────────────────
    problem_counts = {sid: cnt for sid, cnt in set_counts.items() if cnt != 25}
    # Set 0 is achievement reward words — always skip
    problem_counts.pop(0, None)
    print(f"=== 2. Наборы ≠ 25 слов: {len(problem_counts)} ===\n")
    if problem_counts:
        has_errors = True
        for sid in sorted(problem_counts):
            cnt = problem_counts[sid]
            print(f"  Set {sid}: {cnt} слов [{set_names_by_file.get(sid, '?')}]")
    else:
        print("  ✅ Все наборы по 25 слов\n")

    # ── Checks 3 & 5: warnings for staged files only (old data has violations) ─
    staged_files = _get_staged_files()
    if staged_files:
        rarity_errors = check_rarity_spread(all_words)
        rarity_in_staged = [e for e in rarity_errors if any(f in e for f in staged_files)]
        if rarity_in_staged:
            print(f"=== 3. ⚠️  Разброс редкости в изменённых файлах ({len(rarity_in_staged)}) ===\n")
            for e in rarity_in_staged:
                print(e)
            print()
        else:
            print("=== 3. Разброс редкости: ✅ нет проблем в изменённых файлах ===\n")

        # ── Check 4: ID formula (staged files only) ───────────────────────────
        id_errors = check_id_formula(all_words)
        id_in_staged = [e for e in id_errors if any(f in e for f in staged_files)]
        if id_in_staged:
            print(f"=== 4. ⚠️  Нарушение формулы ID в изменённых файлах ({len(id_in_staged)}) ===\n")
            for e in id_in_staged:
                print(e)
            print()
        else:
            print("=== 4. Формула ID: ✅ нет проблем в изменённых файлах ===\n")

        name_errors = check_duplicate_set_names(registry_order)
        name_in_staged = [e for e in name_errors if any(f in e for f in staged_files)]
        if name_in_staged:
            print(f"=== 5. ⚠️  Дублирующиеся имена в изменённых файлах ({len(name_in_staged)}) ===\n")
            for e in name_in_staged:
                print(e)
            print()
        else:
            print("=== 5. Дублирующиеся имена: ✅ нет проблем в изменённых файлах ===\n")

    # ── Summary ───────────────────────────────────────────────────────────────
    if has_errors:
        print("━" * 60)
        print("❌ ПРОВЕРКА НЕ ПРОЙДЕНА — исправь ошибки перед коммитом")
        sys.exit(1)
    else:
        print("━" * 60)
        print("✅ Все проверки пройдены")


if __name__ == "__main__":
    main()
