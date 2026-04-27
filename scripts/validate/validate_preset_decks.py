#!/usr/bin/env python3
"""
Validates all preset PvP DeckSeeds against the actual word database.

Catches the failure mode where preset decks ship orphaned words or wrong-rarity
words because DeckSeed.wordOriginals is a list of strings, not IDs — and Kotlin's
compiler does not check it.

Three classes of bug:

1. ORPHAN — wordOriginal is a string that no WordEntity in the language pair
   has as `original`. Migration silently drops these (`?: continue`), so the
   user sees a deck with fewer than 21 cards. Fixing requires a substitute word.

2. WRONG_RARITY — wordOriginal exists, but its rarity in the effective DB state
   does not match the bucket it occupies in DeckSeed (e.g. "סִיסְמָה" sits in the
   UNCOMMON bucket but resolves to COMMON because of cross-topic last-write-wins).
   Visible to the user as "Обыч 5/4" overflow in deck-builder filter chips.

3. LIMIT_VIOLATION — even if every word resolves to its correct bucket, the deck
   may exceed DeckLevel limits for that level (e.g. 21 COMMON in level 1, which
   only allows 12). The user sees "Обыч 21/12" overflow.

Effective rarity = last WordEntity in WordRegistry.kt order to declare that
(original, languagePair) pair. This matches Room's `OnConflictStrategy.REPLACE`
on `UNIQUE(original, languagePair)`.

Bucket assignment is parsed from "// COMMON ×N" / "// UNCOMMON ×N" comments
between groups inside DeckSeed.wordOriginals, falling back to expected counts
from DeckLevel.limitsFor(deck.level) if no bucket comments are present.

Output:
- Exits 0 if no problems.
- Exits 1 with a human-readable report otherwise.

Run from repo root:
    python scripts/validate/validate_preset_decks.py
"""
from __future__ import annotations
import re
import sys
from collections import Counter
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
DATA_DIR = ROOT / "app" / "src" / "main" / "java" / "com" / "example" / "kartonki" / "data"

# DeckLevel.kt — keep in sync if Limits change in Kotlin.
DECK_LEVEL_LIMITS = {
    1: {"COMMON": 12, "UNCOMMON": 9, "RARE": 0, "EPIC": 0, "LEGENDARY": 0},
    2: {"COMMON": 10, "UNCOMMON": 6, "RARE": 5, "EPIC": 0, "LEGENDARY": 0},
    3: {"COMMON": 8,  "UNCOMMON": 6, "RARE": 4, "EPIC": 2, "LEGENDARY": 1},
    4: {"COMMON": 4,  "UNCOMMON": 7, "RARE": 6, "EPIC": 3, "LEGENDARY": 1},
    5: {"COMMON": 0,  "UNCOMMON": 6, "RARE": 8, "EPIC": 5, "LEGENDARY": 2},
    6: {"COMMON": 0,  "UNCOMMON": 3, "RARE": 8, "EPIC": 7, "LEGENDARY": 3},
    7: {"COMMON": 0,  "UNCOMMON": 0, "RARE": 6, "EPIC": 10, "LEGENDARY": 5},
}

ID_RE = re.compile(r"\bid\s*=\s*(\d+)\b")
SET_ID_RE = re.compile(r"\bsetId\s*=\s*(\d+)\b")
LANG_RE = re.compile(r'\blanguagePair\s*=\s*"([^"]+)"')
RARITY_RE = re.compile(r'\brarity\s*=\s*"([^"]+)"')
ORIGINAL_RE = re.compile(r'\boriginal\s*=\s*"([^"]+)"')

DECK_SEED_RE = re.compile(
    r"DeckSeed\(\s*(?P<body>(?:[^()]|\([^()]*\))*?)\)",
    re.DOTALL,
)
DECK_NAME_RE = re.compile(r'\bname\s*=\s*"([^"]+)"')
DECK_LEVEL_RE = re.compile(r"\blevel\s*=\s*(\d+)")
DECK_LANG_RE = re.compile(r'\blanguagePair\s*=\s*"([^"]+)"')
DECK_WORDS_RE = re.compile(r"wordOriginals\s*=\s*listOf\((?P<list>.*?)\)", re.DOTALL)
BUCKET_HEADER_RE = re.compile(r"//\s*(COMMON|UNCOMMON|RARE|EPIC|LEGENDARY)\b", re.IGNORECASE)
WORD_LITERAL_RE = re.compile(r'"([^"]+)"')


def parse_word_entities(fpath: Path):
    """Yield (id, setId, languagePair, rarity, original) tuples.

    Streams WordEntity(...) blocks via paren-balanced scan — robust to multiline
    formatting and different field orderings.
    """
    text = fpath.read_text(encoding="utf-8", errors="replace")
    needle = "WordEntity("
    pos = 0
    while True:
        i = text.find(needle, pos)
        if i < 0:
            break
        depth = 1
        j = i + len(needle)
        while j < len(text) and depth:
            c = text[j]
            if c == "(":
                depth += 1
            elif c == ")":
                depth -= 1
            j += 1
        body = text[i + len(needle): j - 1]
        pos = j
        idm = ID_RE.search(body)
        sidm = SET_ID_RE.search(body)
        langm = LANG_RE.search(body)
        rarm = RARITY_RE.search(body)
        origm = ORIGINAL_RE.search(body)
        if not (idm and sidm and langm and rarm and origm):
            continue
        yield (
            int(idm.group(1)),
            int(sidm.group(1)),
            langm.group(1),
            rarm.group(1),
            origm.group(1),
        )


def parse_word_registry_order():
    """Return list of WordData* file names in WordRegistry.kt declaration order
    of `_allWordsRaw`. Matches Room's effective insertion order."""
    registry_path = DATA_DIR / "WordRegistry.kt"
    text = registry_path.read_text(encoding="utf-8")
    # _allWordsRaw block: starts at the declaration, ends at top-level `}` of
    # the by-lazy block (depth-balanced). Keeps it robust against multi-line
    # definitions and nested braces in lambdas.
    start = text.find("private val _allWordsRaw")
    if start < 0:
        return []
    brace_open = text.find("{", start)
    if brace_open < 0:
        return []
    depth = 1
    j = brace_open + 1
    while j < len(text) and depth:
        c = text[j]
        if c == "{":
            depth += 1
        elif c == "}":
            depth -= 1
        j += 1
    block = text[brace_open + 1: j - 1]
    return re.findall(r"\bWordData\w+\b", block)


def build_effective_rarity_map():
    """Returns dict[(lang, original)] -> rarity, last-occurrence wins (Room
    INSERT REPLACE semantics on UNIQUE(original, languagePair))."""
    order = parse_word_registry_order()
    seen_files = set()
    file_to_path = {}
    for fpath in DATA_DIR.glob("WordData*.kt"):
        file_to_path[fpath.stem] = fpath
    rarity_map: dict[tuple[str, str], str] = {}
    for fname in order:
        if fname in seen_files:
            continue
        seen_files.add(fname)
        fpath = file_to_path.get(fname)
        if not fpath:
            continue
        for _id, _sid, lang, rarity, original in parse_word_entities(fpath):
            rarity_map[(lang, original)] = rarity  # later wins
    return rarity_map


def parse_deck_seeds():
    """Yields (file, deck_name, level, languagePair, ordered_words_with_buckets).

    ordered_words_with_buckets: list[(word_original, bucket_or_None)] in
    declaration order. bucket is the last "// COMMON ×N" comment seen above the
    word, or None if the deck has no bucket headers.
    """
    for fpath in DATA_DIR.glob("WordData*.kt"):
        text = fpath.read_text(encoding="utf-8", errors="replace")
        # quick filter
        if "DeckSeed(" not in text or "wordOriginals" not in text:
            continue
        for m in DECK_SEED_RE.finditer(text):
            body = m.group("body")
            name_m = DECK_NAME_RE.search(body)
            level_m = DECK_LEVEL_RE.search(body)
            lang_m = DECK_LANG_RE.search(body)
            words_m = DECK_WORDS_RE.search(body)
            if not (name_m and words_m):
                continue
            list_body = words_m.group("list")
            entries = []  # (word, bucket_or_None)
            current_bucket = None
            for line in list_body.splitlines():
                # bucket header on its own line
                bh = BUCKET_HEADER_RE.search(line)
                if bh and not WORD_LITERAL_RE.search(line):
                    current_bucket = bh.group(1).upper()
                    continue
                for w_m in WORD_LITERAL_RE.finditer(line):
                    entries.append((w_m.group(1), current_bucket))
            yield (
                fpath.name,
                name_m.group(1),
                int(level_m.group(1)) if level_m else 1,
                lang_m.group(1) if lang_m else "en-ru",
                entries,
            )


def validate():
    rarity_map = build_effective_rarity_map()
    problems = []  # list of dict
    for file, name, level, lang, entries in parse_deck_seeds():
        deck_label = f"[{file}] '{name}' (L{level} {lang})"
        # Resolve each word
        resolved: list[tuple[str, str | None, str | None]] = []
        # (word, expected_bucket, real_rarity)
        for word, bucket in entries:
            real = rarity_map.get((lang, word))
            resolved.append((word, bucket, real))

        # 1. ORPHAN check
        orphans = [w for w, b, r in resolved if r is None]
        if orphans:
            problems.append({
                "type": "ORPHAN",
                "deck": deck_label,
                "detail": f"{len(orphans)} word(s) not found in DB: {orphans}",
            })

        # 2. WRONG_RARITY: only if at least some buckets are declared
        has_buckets = any(b is not None for _, b, _ in resolved)
        if has_buckets:
            mismatches = [
                f"'{w}' bucket={b} actual={r}"
                for w, b, r in resolved
                if b is not None and r is not None and b != r
            ]
            if mismatches:
                problems.append({
                    "type": "WRONG_RARITY",
                    "deck": deck_label,
                    "detail": f"{len(mismatches)} bucket vs effective-rarity mismatch(es): {mismatches[:5]}{'…' if len(mismatches) > 5 else ''}",
                })

        # 3. LIMIT_VIOLATION
        limits = DECK_LEVEL_LIMITS.get(level)
        if limits is not None:
            counts = Counter(r for _, _, r in resolved if r is not None)
            for rarity, max_count in limits.items():
                actual = counts.get(rarity, 0)
                if actual > max_count:
                    problems.append({
                        "type": "LIMIT_VIOLATION",
                        "deck": deck_label,
                        "detail": f"{rarity}={actual} exceeds level {level} limit {max_count}",
                    })
            # Also check total
            total_resolved = sum(counts.values())
            expected_total = sum(limits.values())
            if total_resolved < expected_total - len(orphans):
                # Don't double-report orphans, but flag if even after orphans we're short
                problems.append({
                    "type": "TOTAL_SHORT",
                    "deck": deck_label,
                    "detail": f"only {total_resolved} resolved + {len(orphans)} orphan = "
                              f"{total_resolved + len(orphans)} entries, level {level} expects {expected_total}",
                })

    return problems


def main():
    sys.stdout.reconfigure(encoding="utf-8", errors="replace")
    problems = validate()
    if not problems:
        print("✅ All preset DeckSeeds resolve cleanly against the effective DB state.")
        return 0
    by_type: dict[str, list] = {}
    for p in problems:
        by_type.setdefault(p["type"], []).append(p)
    print(f"❌ Preset deck validation: {len(problems)} problem(s) across "
          f"{len({p['deck'] for p in problems})} deck(s)\n")
    for ptype in ("ORPHAN", "WRONG_RARITY", "LIMIT_VIOLATION", "TOTAL_SHORT"):
        items = by_type.get(ptype, [])
        if not items:
            continue
        print(f"── {ptype} ({len(items)}) " + "─" * (60 - len(ptype) - 5))
        for p in items[:50]:
            print(f"  {p['deck']}: {p['detail']}")
        if len(items) > 50:
            print(f"  … and {len(items) - 50} more")
        print()
    print("Reference: docs/claude/preset-decks.md — fix workflow.")
    return 1


if __name__ == "__main__":
    sys.exit(main())
