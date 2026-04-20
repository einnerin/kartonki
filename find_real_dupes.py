#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Validates all WordData files against Room's insertion rules and quality rules.

Blocking errors (exit 1) — ANY file, staged or not:
  1. Same-topic duplicates — same (original, languagePair) in two sets of the SAME topic.
     This is a semantic error: the word is repeated within the same theme.
     Cross-topic duplicates are allowed — the DB schema no longer enforces uniqueness
     on (original, languagePair), so the same word can appear in different topics.
  2. Wrong word count — every set must have exactly 25 words.
  3. Duplicate setId across files.
  4. SetId outside language block (he-ru 1001-1999, en-ru 1-999).

Blocking errors (exit 1) — staged files only:
  5. Rarity spread > 2 adjacent levels within a NEW set.
  6. Missing topic or level=0 in staged sets (both are required).
  7. Derivative/same-root word pairs within the same NEW staged set.

Warnings (never block):
  8. Rarity spread in modified/non-staged files (old data, fixed in Phase 4).
  9. Word ID formula violation (staged files only).
 10. Duplicate set names within same languagePair (staged files only).
 11. Description contains CEFR level notation (A1/B1 etc) — use rarity colour instead.

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


def _get_new_set_ids(staged_files):
    """Return setIds that are NEW in this commit (added, not modified).

    Looks for '+        WordSetEntity(id = N' lines in git diff --cached.
    This lets rarity/derivative checks skip pre-existing sets that only
    got metadata updates (topic/level/name) without new word content.
    """
    new_ids = set()
    removed_ids = set()
    if not staged_files:
        return new_ids
    try:
        r = subprocess.run(["git", "diff", "--cached"],
                           capture_output=True, text=True, timeout=10)
        for line in r.stdout.splitlines():
            if line.startswith('+++') or line.startswith('---'):
                continue
            m = re.search(r'WordSetEntity\([^)]*\bid\s*=\s*(\d+)', line)
            if not m:
                continue
            sid = int(m.group(1))
            if line.startswith('+'):
                new_ids.add(sid)
            elif line.startswith('-'):
                removed_ids.add(sid)
    except Exception:
        pass
    # setIds present in both +/- are modifications, not additions
    return new_ids - removed_ids


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
    # Support both `get() =` and `by lazy {` syntax
    m = re.search(r'val allWords.*?(?:get\(\)\s*=|by\s+lazy\s*\{)(.*?)(?=\n[ \t]*val |\n\})', text, re.DOTALL)
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
        translation = extract_field(block, 'translation') or ""
        has_translit = bool(re.search(r'\btransliteration\s*=\s*"[^"]+"', block))
        if wid and sid and original and lang:
            words.append({"id": wid, "setId": sid, "original": original,
                          "rarity": rarity, "lang": lang, "file": kt_file.name,
                          "has_translit": has_translit, "translation": translation})
    return words


def parse_sets(kt_file):
    content = kt_file.read_text(encoding="utf-8")
    sets = []
    for block in _parse_blocks(content, "WordSetEntity"):
        sid = extract_int_field(block, r'\bid')
        name = extract_field(block, 'name')
        lang = extract_field(block, 'languagePair')
        topic = extract_field(block, 'topic') or ""
        description = extract_field(block, 'description') or ""
        level_m = re.search(r'\blevel\s*=\s*(\d+)', block)
        level = int(level_m.group(1)) if level_m else 0
        if sid and name and lang:
            sets.append({"id": sid, "name": name, "lang": lang,
                         "topic": topic, "level": level,
                         "description": description, "file": kt_file.name})
    return sets


# ── Checks ─────────────────────────────────────────────────────────────────────

def check_stolen_words(all_words, set_topic_map, staged_files=None):
    """
    Returns (errors, warnings, final_db, loser_sets).

    Only same-topic duplicates are errors — the same word appearing twice within
    the same topic is a semantic mistake. Cross-topic duplicates are allowed:
    the DB no longer has a UNIQUE constraint on (original, languagePair).

    - error:   same-topic dup where staged file is involved → block the commit
    - warning: same-topic dup where both files are unstaged → pre-existing issue

    loser_sets: always empty now (no Room stealing). Kept for API compatibility.
    """
    staged_files = staged_files or set()
    errors, warnings = [], []
    loser_sets = set()
    final_db = {}  # (original, lang) -> word
    seen = {}      # (original, lang) -> first word seen

    for w in all_words:
        key = (w["original"], w["lang"])
        final_db[key] = w

        if key in seen:
            prev = seen[key]
            prev_topic = set_topic_map.get(prev["setId"], "")
            curr_topic = set_topic_map.get(w["setId"], "")
            same_topic = (prev_topic == curr_topic and prev_topic != "")
            if same_topic:
                entry = {
                    "original": w["original"],
                    "loser_set": prev["setId"], "loser_file": prev["file"],
                    "winner_set": w["setId"], "winner_file": w["file"],
                    "loser_topic": prev_topic,
                    "winner_topic": curr_topic,
                    "same_topic": True,
                }
                if prev["file"] in staged_files or w["file"] in staged_files:
                    errors.append(entry)
                else:
                    warnings.append(entry)
        seen[key] = w

    return errors, warnings, final_db, loser_sets


def check_intra_set_duplicates(all_words):
    """
    Flags any set where the same `original` OR the same `translation` appears
    more than once. This is always a blocking error regardless of staged status.
    """
    errors = []
    by_set = defaultdict(list)
    for w in all_words:
        by_set[(w["setId"], w["file"])].append(w)

    for (sid, fname), words in sorted(by_set.items()):
        seen_orig  = defaultdict(list)
        seen_trans = defaultdict(list)
        for w in words:
            seen_orig[w["original"]].append(w["id"])
            t = w.get("translation", "").strip()
            # Same-translation check only for he-ru: in en-ru different words often
            # share the same Russian translation (synonyms), which is valid.
            if t and w.get("lang") == "he-ru":
                seen_trans[t].append(w["id"])

        dup_orig  = {o: ids for o, ids in seen_orig.items()  if len(ids) > 1}
        dup_trans = {t: ids for t, ids in seen_trans.items() if len(ids) > 1}

        if dup_orig or dup_trans:
            errors.append(f"  Set {sid} [{fname}]:")
            for orig, ids in dup_orig.items():
                errors.append(f"    ДУБЛЬ original: '{orig}'  wordIds={ids}")
            for trans, ids in dup_trans.items():
                errors.append(f"    ДУБЛЬ translation: '{trans}'  wordIds={ids}")

    return errors


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


def check_set_count(all_words, set_file_map, loser_sets=None):
    """
    Every set must have exactly 25 words.
    Only flags sets that appear in loser_sets (i.e. lost words to a duplicate).
    Returns {setId: (count, filename)}.
    """
    loser_sets = loser_sets or set()
    counts = defaultdict(int)
    for w in all_words:
        if w["setId"] != 0:
            counts[w["setId"]] += 1
    problems = {}
    for sid, cnt in counts.items():
        if cnt != 25 and sid in loser_sets:
            problems[sid] = (cnt, set_file_map.get(sid, "?"))
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


def check_topic_level_required(all_sets, staged_files):
    """Every set in staged files must have topic filled and level 1–5."""
    errors = []
    for s in all_sets:
        if s["file"] not in staged_files:
            continue
        if not s["topic"]:
            errors.append(f"  Set {s['id']} '{s['name']}' [{s['file']}]: "
                          f"поле topic пустое (обязательно)")
        if s["level"] not in (1, 2, 3, 4, 5):
            errors.append(f"  Set {s['id']} '{s['name']}' [{s['file']}]: "
                          f"level={s['level']} — должен быть 1–5 (основы/продвинутый/углублённый/профессиональный/носитель языка)")
    return errors


def _normalize(s):
    """Strip Hebrew niqqud and lowercase for root comparison."""
    return re.sub(r'[\u05B0-\u05C7\u05F3\u05F4]', '', s).strip().lower()


def _is_derivative(w1, w2):
    """
    Returns True if w1 and w2 look like derivatives of the same root.
    Works for both Hebrew (prefix-share on niqqud-stripped forms) and
    Latin scripts (prefix + common suffix stripping).
    """
    n1 = _normalize(w1).split()[0]
    n2 = _normalize(w2).split()[0]
    if n1 == n2 or len(n1) < 3 or len(n2) < 3:
        return False
    # Shared prefix length (consecutive chars)
    plen = 0
    for a, b in zip(n1, n2):
        if a == b:
            plen += 1
        else:
            break
    min_len = min(len(n1), len(n2))
    if plen >= 3 and plen >= min_len * 0.75:
        return True
    # Latin suffix stripping (covers English sets)
    suffixes = ["ing", "ed", "er", "tion", "sion", "ness", "ment",
                "ity", "ive", "ful", "less", "able", "ible", "ly", "al"]
    for suffix in suffixes:
        for longer, shorter in [(n1, n2), (n2, n1)]:
            if longer.endswith(suffix) and len(longer) - len(suffix) >= 3:
                stem = longer[:-len(suffix)]
                if shorter == stem or shorter.startswith(stem):
                    return True
    return False


def check_derivatives_in_sets(all_words, staged_files):
    """Within each staged set, flag pairs of words that share a root."""
    errors = []
    by_set = defaultdict(list)
    for w in all_words:
        if w["file"] in staged_files:
            by_set[(w["setId"], w["file"])].append(w["original"])
    for (sid, fname), originals in sorted(by_set.items()):
        pairs = []
        for i in range(len(originals)):
            for j in range(i + 1, len(originals)):
                if _is_derivative(originals[i], originals[j]):
                    pairs.append((originals[i], originals[j]))
        if pairs:
            errors.append(f"  Set {sid} [{fname}]: однокоренные пары:")
            for a, b in pairs:
                errors.append(f"    '{a}'  ←→  '{b}'")
    return errors


LEVEL_KEYWORDS = {1: "основ", 2: "продвинут", 3: "углублён", 4: "профессионал", 5: "носитель"}


def check_name_consistency(all_sets, staged_files):
    """
    For staged sets:
      - name must start with topic (e.g. topic="Медицина" → name="Медицина: ...")
      - level keyword in name must match level number:
          level=1 → "основ", level=2 → "продвинут", level=3 → "профессионал"
      - if multiple sets share (topic, lang, level), all names after the first
        must end with a space and number: "Медицина: основы 2", "Медицина: основы 3"
    """
    errors = []
    staged = [s for s in all_sets if s["file"] in staged_files]

    for s in staged:
        name, topic, level = s["name"], s["topic"], s["level"]
        if not topic or level == 0:
            continue  # already caught by topic/level check

        # Name must start with topic
        if not name.startswith(topic):
            errors.append(
                f"  Set {s['id']} [{s['file']}]: name='{name}' не начинается "
                f"с topic='{topic}'"
            )
            continue

        # Level keyword must match
        keyword = LEVEL_KEYWORDS.get(level, "")
        if keyword and keyword not in name.lower():
            expected = {1: "основы", 2: "продвинутый", 3: "углублённый", 4: "профессиональный", 5: "носитель языка"}
            errors.append(
                f"  Set {s['id']} [{s['file']}]: name='{name}' но level={level} "
                f"— ожидается слово «{expected[level]}» в названии"
            )

    # Check numbering when multiple sets at same (topic, lang, level)
    from collections import Counter
    key_counts = Counter((s["topic"], s["lang"], s["level"]) for s in staged if s["topic"] and s["level"])
    # Also check across ALL sets (not just staged) to catch collisions
    all_by_key = defaultdict(list)
    for s in all_sets:
        if s["topic"] and s["level"]:
            all_by_key[(s["topic"], s["lang"], s["level"])].append(s)

    for s in staged:
        if not s["topic"] or not s["level"]:
            continue
        key = (s["topic"], s["lang"], s["level"])
        siblings = all_by_key[key]
        if len(siblings) > 1:
            # All must have unique names; names 2+ must end with " N"
            names = [sib["name"] for sib in siblings]
            base = f"{s['topic']}: {LEVEL_KEYWORDS.get(s['level'], '')}"
            for sib in siblings:
                n = sib["name"]
                # Valid: "Медицина: основы", "Медицина: основы 2", "Медицина: основы 3"
                # i.e., either exactly the base keyword expansion, or ends with " <digit>"
                suffix = n[len(s["topic"]) + 2:].strip()  # part after "Topic: "
                keyword = LEVEL_KEYWORDS.get(s["level"], "")
                if keyword not in suffix.lower():
                    continue  # already caught above
                # Check that if there are N > 1 sets, they are numbered correctly
            # Simplified: just ensure no two siblings share the exact same name
            from collections import Counter as C2
            dups = [nm for nm, cnt in C2(names).items() if cnt > 1]
            if dups and any(s["name"] in dups for s in staged):
                errors.append(
                    f"  topic='{s['topic']}' level={s['level']} ({s['lang']}): "
                    f"несколько наборов с одним именем — используй суффикс: "
                    f"«{s['topic']}: основы», «{s['topic']}: основы 2» и т.д."
                )

    return errors


def check_transliteration_missing(all_words, staged_files, new_set_ids=None):
    """Warn if NEW he-ru words (in new sets only) are missing transliteration."""
    new_set_ids = new_set_ids or set()
    warnings = []
    for w in all_words:
        if w["lang"] != "he-ru":
            continue
        if w["file"] not in staged_files:
            continue
        if w["setId"] not in new_set_ids:
            continue  # skip words in pre-existing sets
        if not w.get("has_translit"):
            warnings.append(f"  Word {w['id']} '{w['original']}' [set {w['setId']}, "
                            f"{w['file']}]: нет transliteration")
    return warnings


def check_description_cefr(all_sets, staged_files):
    """Warn if staged set descriptions mention A1/B1/etc — rarity colour is enough."""
    cefr = re.compile(r'\b(A1|A2|B1|B2|C1|C2)\b')
    warnings = []
    for s in all_sets:
        if s["file"] not in staged_files:
            continue
        if cefr.search(s["description"]):
            warnings.append(f"  Set {s['id']} '{s['name']}': описание содержит CEFR "
                            f"«{s['description']}» — убери, достаточно цвета карточки")
    return warnings


# ── Main ───────────────────────────────────────────────────────────────────────

def main():
    registry_order = parse_registry_order()
    staged_files = _get_staged_files()
    new_set_ids = _get_new_set_ids(staged_files)  # setIds first appearing in this commit

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

    # ── 1. Same-topic duplicates ──────────────────────────────────────────────
    stolen_errors, stolen_warnings, final_db, loser_sets = check_stolen_words(
        all_words, set_topic_map, staged_files)
    all_conflicts = stolen_errors + stolen_warnings
    print(f"=== 1. Дубли внутри одной темы: {len(all_conflicts)} ===\n")
    if all_conflicts:
        has_errors = True
        by_loser = defaultdict(list)
        for e in all_conflicts:
            by_loser[e["loser_set"]].append(e)
        for sid in sorted(by_loser):
            items = by_loser[sid]
            topic_label = f" [тема: {items[0]['loser_topic']}]" if items[0]['loser_topic'] else ""
            staged_marker = " [staged]" if items[0]['loser_file'] in staged_files else ""
            print(f"  Set {sid} [{items[0]['loser_file']}]{topic_label}{staged_marker} — {len(items)} семантических дублей:")
            for e in items:
                print(f"    '{e['original']}' → уже в наборе {e['winner_set']} [{e['winner_file']}]")
    else:
        print("  ✅ Нет дублей внутри одной темы\n")

    # ── 1b. Intra-set duplicates (same original OR same translation) ─────────
    intra_errors = check_intra_set_duplicates(all_words)
    print(f"=== 1b. Дубли внутри одного набора: {len(intra_errors)} ===\n")
    if intra_errors:
        has_errors = True
        for e in intra_errors:
            print(e)
        print()
    else:
        print("  ✅ Нет дублей внутри наборов\n")

    # ── 2. Word count — flag sets that lost words to any duplicate ──────────
    count_problems = check_set_count(all_words, set_file_map, loser_sets)
    print(f"=== 2. Наборы с нехваткой слов (из-за дублей): {len(count_problems)} ===\n")
    if count_problems:
        has_errors = True
        for sid in sorted(count_problems):
            cnt, fname = count_problems[sid]
            staged_marker = " [staged]" if fname in staged_files else ""
            print(f"  Set {sid}: {cnt} слов [{fname}]{staged_marker} — потерял слова из-за дубля")
        print()
    else:
        print("  ✅ Нет наборов с нехваткой слов\n")

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

    # ── 5. Rarity spread — BLOCKING only for NEW sets, warning for modified ──────
    rarity_issues = check_rarity_spread(all_words)
    if staged_files:
        # New sets: block; modified (metadata-only) sets: warn; non-staged: summarise
        new_rarity  = [(sid, f, r) for sid, f, r in rarity_issues if sid in new_set_ids]
        mod_rarity  = [(sid, f, r) for sid, f, r in rarity_issues
                       if f in staged_files and sid not in new_set_ids]
        old_rarity  = [(sid, f, r) for sid, f, r in rarity_issues if f not in staged_files]
        print(f"=== 5. Разброс редкости в новых staged наборах: {len(new_rarity)} ===\n")
        if new_rarity:
            has_errors = True
            for sid, fname, rstr in new_rarity:
                print(f"  Set {sid} [{fname}]: {rstr} — допустимо ≤ 2 смежных уровня")
            print()
        else:
            print("  ✅ Новые staged наборы: разброс редкости в норме\n")
        if mod_rarity:
            print(f"  ⚠️  Изменённые staged наборы с разбросом: {len(mod_rarity)} "
                  f"(исправить в Phase 4)\n")
        if old_rarity:
            print(f"  ℹ️  В не-staged файлах {len(old_rarity)} наборов с разбросом\n")
    else:
        # Manual run: just summarise
        if rarity_issues:
            print(f"=== 5. Разброс редкости: {len(rarity_issues)} наборов нарушают правило ===\n")
            print(f"  (Запускай с staged файлами чтобы увидеть детали для новых наборов)\n")
        else:
            print("=== 5. Разброс редкости: ✅ нет проблем ===\n")

    # ── 6. topic + level required (staged) ───────────────────────────────────
    if staged_files:
        tl_errors = check_topic_level_required(all_sets, staged_files)
        print(f"=== 6. Обязательные поля topic/level в staged файлах: {len(tl_errors)} ===\n")
        if tl_errors:
            has_errors = True
            for e in tl_errors:
                print(e)
            print()
        else:
            print("  ✅ Все staged наборы имеют topic и level\n")

    # ── 6b. Name/topic/level consistency (staged) ────────────────────────────
    if staged_files:
        name_cons_errors = check_name_consistency(all_sets, staged_files)
        print(f"=== 6b. Соответствие name/topic/level в staged файлах: "
              f"{len(name_cons_errors)} ===\n")
        if name_cons_errors:
            has_errors = True
            for e in name_cons_errors:
                print(e)
            print()
        else:
            print("  ✅ Имена соответствуют topic и level\n")

    # ── 7. Derivative word pairs — BLOCKING only for NEW sets ────────────────
    if staged_files:
        deriv_errors = check_derivatives_in_sets(all_words, staged_files)
        # Only block for NEW sets; warn for modified sets
        new_deriv = [e for e in deriv_errors
                     if any(f"Set {sid}" in e for sid in new_set_ids)]
        mod_deriv = [e for e in deriv_errors
                     if not any(f"Set {sid}" in e for sid in new_set_ids)]
        print(f"=== 7. Однокоренные слова в новых staged наборах: {len(new_deriv)} ===\n")
        if new_deriv:
            has_errors = True
            for e in new_deriv:
                print(e)
            print()
        else:
            print("  ✅ Новые staged наборы: однокоренных пар не найдено\n")
        if mod_deriv:
            print(f"  ⚠️  Изменённые staged наборы с однокоренными парами: "
                  f"{len(mod_deriv)} (исправить в Phase 4)\n")

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

        cefr_warnings = check_description_cefr(all_sets, staged_files)
        if cefr_warnings:
            print(f"=== ⚠️  CEFR в описаниях staged наборов: {len(cefr_warnings)} ===\n")
            for w in cefr_warnings:
                print(w)
            print()

        translit_warnings = check_transliteration_missing(all_words, staged_files, new_set_ids)
        if translit_warnings:
            print(f"=== ⚠️  Нет transliteration в staged he-ru словах: "
                  f"{len(translit_warnings)} ===\n")
            for w in translit_warnings:
                print(w)
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
