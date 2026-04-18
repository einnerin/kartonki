#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Validates all WordData files against Room's insertion rules and quality rules.

Blocking errors (exit 1):
  1. Stolen words within the SAME TOPIC — word exists in two sets that share a
     topic. Cross-topic duplicates are allowed (e.g. "doctor" in Medicine +
     Hospital is fine). Sets without a topic field follow the old rule: any
     stealing is an error.
  2. Wrong word count — every set must have exactly 25 words after DB simulation.
  3. Rarity spread in STAGED files — within a set, rarities must span ≤ 2
     adjacent levels (e.g. RARE+EPIC ok, COMMON+EPIC not ok).
  4. Duplicate setId — two different files declare the same setId.
  5. SetId outside language block — he-ru must be 1001-1999, en-ru 1-999.

Warnings (printed but never block):
  6. Rarity spread in un-staged files (old data, fixed in Phase 3).
  7. Word ID formula violation: id ≠ setId×100+position (staged files only).
  8. Duplicate set names within the same languagePair.
  9. Cross-topic duplicate words (info only — allowed by new rules).

Registry order is derived automatically from WordRegistry.kt allWords.
"""

import re, io, sys, subprocess
from pathlib import Path
from collections import defaultdict

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')

ROOT = Path("app/src/main/java/com/example/kartonki/data")
REGISTRY_FILE = ROOT / "WordRegistry.kt"

RARITY_ORDER = ["COMMON", "UNCOMMON", "RARE", "EPIC", "LEGENDARY"]
RARITY_INDEX = {r: i for i, r in enumerate(RARITY_ORDER)}

# Valid setId ranges per languagePair
LANG_BLOCKS = {
    "en-ru": range(1, 1000),
    "he-ru": range(1001, 2000),
}


# ── Helpers ────────────────────────────────────────────────────────────────────

def _get_staged_files():
    """Return set of .kt filenames (basename) currently staged in git."""
    try:
        r = subprocess.run(["git", "diff", "--cached", "--name-only"],
                           capture_output=True, text=True, timeout=5)
        return {Path(p).name for p in r.stdout.splitlines() if p.endswith(".kt")}
    except Exception:
        return set()


def extract_field(block, field_name):
    m = re.search(field_name + r'\s*=\s*"((?:[^"\\]|\\.)*)"', block)
    return m.group(1) if m else None


def extract_int_field(block, field_name):
    m = re.search(field_name + r'\s*=\s*(\d+)', block)
    return int(m.group(1)) if m else None


def _parse_blocks(content, entity_name):
    """Yield raw text blocks for each occurrence of entity_name(...) in content."""
    for part in re.split(rf'(?={entity_name}\s*\()', content):
        if not part.strip().startswith(entity_name):
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
        yield part[:end] if end >= 0 else part


# ── Parsers ────────────────────────────────────────────────────────────────────

def parse_registry_order():
    text = REGISTRY_FILE.read_text(encoding="utf-8")
    m = re.search(r'val allWords.*?get\(\)\s*=(.*?)(?=\n[ \t]*val |\Z)', text, re.DOTALL)
    if not m:
        raise RuntimeError("Could not find allWords in WordRegistry.kt")
    body = m.group(1)
    seen, order = set(), []
    for obj in re.findall(r'(WordData\w+)\.', body):
        if obj not in seen:
            seen.add(obj)
            order.append(obj + ".kt")
    return order


def parse_words(kt_file):
    content = kt_file.read_text(encoding="utf-8")
    words = []
    for block in _parse_blocks(content, "WordEntity"):
        wid = extract_int_field(block, r'\bid')
        sid = extract_int_field(block, r'\bsetId')
        original = extract_field(block, 'original')
        rarity = extract_field(block, 'rarity') or "COMMON"
        lang = extract_field(block, 'languagePair')
        if wid and sid and original and lang:
            words.append({"id": wid, "setId": sid, "original": original,
                          "rarity": rarity, "lang": lang, "file": kt_file.name})
    return words


def parse_sets(kt_file):
    content = kt_file.read_text(encoding="utf-8")
    sets = []
    for block in _parse_blocks(content, "WordSetEntity"):
        sid = extract_int_field(block, r'\bid')
        name = extract_field(block, 'name')
        lang = extract_field(block, 'languagePair')
        topic = extract_field(block, 'topic') or ""
        level_m = re.search(r'\blevel\s*=\s*(\d+)', block)
        level = int(level_m.group(1)) if level_m else 0
        if sid and name and lang:
            sets.append({"id": sid, "name": name, "lang": lang,
                         "topic": topic, "level": level, "file": kt_file.name})
    return sets


# ── Checks ─────────────────────────────────────────────────────────────────────

def check_stolen_words(all_words, set_topic_map):
    """
    Returns (errors, warnings).
    - error: same (original, lang) in two sets that share the same non-empty topic
    - error: same (original, lang) in two sets where either has no topic (old rule)
    - warning: same (original, lang) in two sets with DIFFERENT non-empty topics (allowed)
    """
    errors, warnings = [], []
    seen = {}  # (original, lang) -> word
    for w in all_words:
        key = (w["original"], w["lang"])
        if key in seen:
            prev = seen[key]
            loser_topic = set_topic_map.get(prev["setId"], "")
            winner_topic = set_topic_map.get(w["setId"], "")
            entry = {
                "original": w["original"],
                "loser_set": prev["setId"], "loser_file": prev["file"],
                "winner_set": w["setId"], "winner_file": w["file"],
                "loser_topic": loser_topic, "winner_topic": winner_topic,
            }
            if loser_topic and winner_topic and loser_topic != winner_topic:
                warnings.append(entry)  # cross-topic: allowed
            else:
                errors.append(entry)    # same topic or no topic: error
            seen[key] = w
        else:
            seen[key] = w
    return errors, warnings, seen  # seen = final DB state


def check_rarity_spread(words_for_sets):
    """Returns list of (setId, file, rarity_str) for sets with spread > 2 adjacent levels."""
    issues = []
    by_set = defaultdict(list)
    for w in words_for_sets:
        by_set[(w["setId"], w["file"])].append(w["rarity"])
    for (sid, fname), rarities in sorted(by_set.items()):
        known = [r for r in rarities if r in RARITY_INDEX]
        if not known:
            continue
        levels = sorted(set(RARITY_INDEX[r] for r in known))
        if levels[-1] - levels[0] > 1:
            present = "+".join(sorted(set(known), key=lambda r: RARITY_INDEX[r]))
            issues.append((sid, fname, present))
    return issues


def check_set_count(seen_db, set_names_map):
    """Every set must have exactly 25 words in the simulated DB."""
    counts = defaultdict(int)
    for w in seen_db.values():
        counts[w["setId"]] += 1
    problems = {}
    for sid, cnt in counts.items():
        if sid == 0:
            continue  # achievement reward words
        if cnt != 25:
            problems[sid] = (cnt, set_names_map.get(sid, "?"))
    return problems


def check_duplicate_setids(all_sets):
    """Two files declare the same setId."""
    errors = []
    seen = {}
    for s in all_sets:
        key = (s["id"], s["lang"])
        if key in seen:
            errors.append(f"  setId={s['id']} ({s['lang']}) объявлен в "
                          f"{seen[key]} И {s['file']}")
        else:
            seen[key] = s["file"]
    return errors


def check_lang_blocks(all_sets):
    """SetId must fall within the declared languagePair block."""
    errors = []
    for s in all_sets:
        block = LANG_BLOCKS.get(s["lang"])
        if block and s["id"] not in block:
            errors.append(f"  Set {s['id']} ({s['lang']}) вне диапазона "
                          f"{block.start}–{block.stop - 1} [{s['file']}]")
    return errors


def check_id_formula(all_words):
    """id must equal setId * 100 + 1-based position within set."""
    errors = []
    by_set = defaultdict(list)
    for w in all_words:
        by_set[(w["setId"], w["file"])].append(w)
    for (sid, fname), words in sorted(by_set.items()):
        for pos, w in enumerate(sorted(words, key=lambda x: x["id"]), start=1):
            if w["id"] != sid * 100 + pos:
                errors.append(f"  Set {sid} [{fname}]: '{w['original']}' "
                              f"id={w['id']}, ожидалось {sid*100+pos}")
    return errors


def check_duplicate_names(all_sets):
    """Two sets with same name in same languagePair."""
    errors = []
    seen = defaultdict(list)
    for s in all_sets:
        seen[(s["name"], s["lang"])].append(s)
    for (name, lang), entries in sorted(seen.items()):
        if len(entries) > 1:
            ids = ", ".join(f"id={e['id']} [{e['file']}]" for e in entries)
            errors.append(f"  '{name}' ({lang}): {ids}")
    return errors


# ── Main ───────────────────────────────────────────────────────────────────────

def main():
    registry_order = parse_registry_order()
    staged_files = _get_staged_files()

    all_words, all_sets = [], []
    for fname in registry_order:
        fpath = ROOT / fname
        if fpath.exists():
            all_words.extend(parse_words(fpath))
            all_sets.extend(parse_sets(fpath))
        else:
            print(f"  [WARN] в WordRegistry.kt но не найден на диске: {fname}")

    # Build topic map: setId -> topic
    set_topic_map = {s["id"]: s["topic"] for s in all_sets}
    set_file_map = {w["setId"]: w["file"] for w in all_words}

    print(f"Всего слов: {len(all_words)} | Наборов: {len(all_sets)}\n")

    has_errors = False

    # ── 1. Stolen words (topic-aware) ─────────────────────────────────────────
    stolen_errors, stolen_warnings, final_db = check_stolen_words(all_words, set_topic_map)
    print(f"=== 1. Украденные слова (внутри темы или без темы): {len(stolen_errors)} ===\n")
    if stolen_errors:
        has_errors = True
        by_loser = defaultdict(list)
        for e in stolen_errors:
            by_loser[e["loser_set"]].append(e)
        for sid in sorted(by_loser):
            items = by_loser[sid]
            topic_label = f" [тема: {items[0]['loser_topic']}]" if items[0]['loser_topic'] else ""
            print(f"  Set {sid} [{items[0]['loser_file']}]{topic_label} теряет {len(items)} слов:")
            for e in items:
                winner_topic = f" [тема: {e['winner_topic']}]" if e['winner_topic'] else ""
                print(f"    '{e['original']}' → украдено набором {e['winner_set']}"
                      f" [{e['winner_file']}]{winner_topic}")
    else:
        print("  ✅ Нет украденных слов внутри одной темы\n")

    if stolen_warnings:
        print(f"  ℹ️  Кросс-тематические дубли (допустимы): {len(stolen_warnings)}")
        for w in stolen_warnings[:5]:
            print(f"    '{w['original']}': {w['loser_topic']} → {w['winner_topic']}")
        if len(stolen_warnings) > 5:
            print(f"    ... и ещё {len(stolen_warnings) - 5}")
        print()

    # ── 2. Word count per set ─────────────────────────────────────────────────
    count_problems = check_set_count(final_db, set_file_map)
    print(f"=== 2. Наборы ≠ 25 слов: {len(count_problems)} ===\n")
    if count_problems:
        has_errors = True
        for sid in sorted(count_problems):
            cnt, fname = count_problems[sid]
            print(f"  Set {sid}: {cnt} слов [{fname}]")
        print()
    else:
        print("  ✅ Все наборы по 25 слов\n")

    # ── 3. Duplicate setIds ───────────────────────────────────────────────────
    dup_setid_errors = check_duplicate_setids(all_sets)
    print(f"=== 3. Дублирующиеся setId: {len(dup_setid_errors)} ===\n")
    if dup_setid_errors:
        has_errors = True
        for e in dup_setid_errors:
            print(e)
        print()
    else:
        print("  ✅ Все setId уникальны\n")

    # ── 4. SetId outside language block ──────────────────────────────────────
    lang_block_errors = check_lang_blocks(all_sets)
    print(f"=== 4. SetId вне языкового блока: {len(lang_block_errors)} ===\n")
    if lang_block_errors:
        has_errors = True
        for e in lang_block_errors:
            print(e)
        print()
    else:
        print("  ✅ Все setId в правильных диапазонах\n")

    # ── 5. Rarity spread — BLOCKING for staged, warning for others ───────────
    rarity_issues = check_rarity_spread(all_words)
    if staged_files:
        staged_rarity = [(sid, f, r) for sid, f, r in rarity_issues if f in staged_files]
        old_rarity = [(sid, f, r) for sid, f, r in rarity_issues if f not in staged_files]
        print(f"=== 5. Разброс редкости в staged файлах: {len(staged_rarity)} ===\n")
        if staged_rarity:
            has_errors = True
            for sid, fname, rstr in staged_rarity:
                print(f"  Set {sid} [{fname}]: {rstr} — допустимо ≤ 2 смежных уровня")
            print()
        else:
            print("  ✅ Staged файлы: разброс редкости в норме\n")
        if old_rarity:
            print(f"  ℹ️  В не-staged файлах {len(old_rarity)} наборов с разбросом "
                  f"(будет исправлено в Phase 3)\n")
    else:
        # Manual run: just summarise
        if rarity_issues:
            print(f"=== 5. Разброс редкости: {len(rarity_issues)} наборов нарушают правило ===\n")
            print(f"  (Запускай с staged файлами чтобы увидеть детали для новых наборов)\n")
        else:
            print("=== 5. Разброс редкости: ✅ нет проблем ===\n")

    # ── Warnings (never block) ────────────────────────────────────────────────
    if staged_files:
        id_errors = check_id_formula(all_words)
        id_staged = [e for e in id_errors if any(f in e for f in staged_files)]
        if id_staged:
            print(f"=== ⚠️  Формула ID в staged файлах: {len(id_staged)} нарушений ===\n")
            for e in id_staged:
                print(e)
            print()

        name_errors = check_duplicate_names(all_sets)
        name_staged = [e for e in name_errors if any(f in e for f in staged_files)]
        if name_staged:
            print(f"=== ⚠️  Дублирующиеся имена в staged файлах: {len(name_staged)} ===\n")
            for e in name_staged:
                print(e)
            print()

    # ── Result ────────────────────────────────────────────────────────────────
    print("━" * 60)
    if has_errors:
        print("❌ КОММИТ ЗАБЛОКИРОВАН — исправь ошибки выше")
        sys.exit(1)
    else:
        print("✅ Все блокирующие проверки пройдены")


if __name__ == "__main__":
    main()
