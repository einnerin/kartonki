#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Shared Kotlin-DSL parser for Kartonki WordData*.kt files.

Used by all scripts in scripts/validate/. Writing a reliable parser for the
Kotlin DSL with nested parentheses and escaped strings in bash is painful —
this module centralises it in Python so individual validators stay small.

Public API:
    Constants:  ROOT, REGISTRY_FILE, RARITY_ORDER, RARITY_INDEX, LANG_BLOCKS
    Field helpers:
        extract_field(block, field_name)      → str | None
        extract_int_field(block, field_name)  → int | None
    Block parser:
        parse_blocks(content, entity_name)    → generator of block strings
    High-level parsers:
        parse_registry_order()  → list of WordData*.kt filenames in import order
        parse_words(kt_file)    → list of word dicts
        parse_sets(kt_file)     → list of set dicts
    Git helpers:
        get_staged_files()      → set of .kt basenames currently staged
        get_new_set_ids(staged) → set of setIds newly added in this commit

Typical usage:
    from _parser import parse_words, parse_sets, ROOT, RARITY_INDEX

    for kt in sorted(ROOT.glob("WordData*.kt")):
        for word in parse_words(kt):
            ...
"""

import os
import re
import subprocess
from pathlib import Path

# ── Constants ─────────────────────────────────────────────────────────────────

# Root directory for word data. Overridable via env var for test fixtures.
ROOT = Path(os.environ.get(
    "KARTONKI_DATA_DIR",
    "app/src/main/java/com/example/kartonki/data",
))
REGISTRY_FILE = ROOT / "WordRegistry.kt"

# Allowed pos values (see docs/claude/quality_standards_metadata.md)
ALLOWED_POS = {
    "noun", "verb", "adjective", "adverb", "number",
    "phrase", "preposition", "interjection", "conjunction", "pronoun",
}

RARITY_ORDER = ["COMMON", "UNCOMMON", "RARE", "EPIC", "LEGENDARY"]
RARITY_INDEX = {r: i for i, r in enumerate(RARITY_ORDER)}

# Valid setId ranges per languagePair (from WordRegistry.languageIdBlocks).
# When a new language is introduced, update both here and in WordRegistry.kt.
LANG_BLOCKS = {
    "en-ru": range(1, 1000),
    "he-ru": range(1001, 2000),
}


# ── Low-level field extraction ────────────────────────────────────────────────

def extract_field(block, field_name):
    """Extract a quoted string field value from a WordEntity/WordSetEntity block."""
    m = re.search(field_name + r'\s*=\s*"((?:[^"\\]|\\.)*)"', block)
    return m.group(1) if m else None


def extract_int_field(block, field_name):
    """Extract an integer field value from a block."""
    m = re.search(field_name + r'\s*=\s*(\d+)', block)
    return int(m.group(1)) if m else None


# ── Block-level parser ────────────────────────────────────────────────────────

def parse_blocks(content, entity_name):
    """
    Yield raw text blocks for each occurrence of `entity_name(...)` in content.

    Handles nested parentheses correctly (e.g. lambdas or default values with
    parentheses inside). Each yielded block starts with `entity_name(` and
    ends at its matching closing paren.
    """
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


# ── High-level parsers ────────────────────────────────────────────────────────

def parse_registry_order():
    """
    Read WordRegistry.kt's `allWords` section, return list of WordData*.kt
    filenames in the order they're concatenated. Used to reproduce Room's
    insertion order for duplicate detection.

    Supports both `get() =` and `by lazy { ... }` syntax.
    """
    text = REGISTRY_FILE.read_text(encoding="utf-8")
    m = re.search(
        r'val allWords.*?(?:get\(\)\s*=|by\s+lazy\s*\{)(.*?)(?=\n[ \t]*val |\n\})',
        text, re.DOTALL,
    )
    if not m:
        raise RuntimeError("Could not find `val allWords` in WordRegistry.kt")
    body = m.group(1)
    seen, order = set(), []
    for obj in re.findall(r'(WordData\w+)\.', body):
        if obj not in seen:
            seen.add(obj)
            order.append(obj + ".kt")
    return order


def parse_words(kt_file):
    """
    Parse all WordEntity records from a single .kt file.

    Returns list of dicts with keys:
        id, setId, original, rarity, lang, file, has_translit, translation,
        definition, definitionNative, example, exampleNative,
        pos, semanticGroup

    Missing text fields (definition/example/etc.) return None — that lets
    validate_fields_filled distinguish between "field absent" and "field
    present but empty string".
    """
    content = kt_file.read_text(encoding="utf-8")
    words = []
    for block in parse_blocks(content, "WordEntity"):
        wid = extract_int_field(block, r'\bid')
        sid = extract_int_field(block, r'\bsetId')
        original = extract_field(block, 'original')
        rarity = extract_field(block, 'rarity') or "COMMON"
        lang = extract_field(block, 'languagePair')
        translation = extract_field(block, 'translation') or ""
        has_translit = bool(re.search(r'\btransliteration\s*=\s*"[^"]+"', block))
        # isFillInBlankSafe — Boolean with default True. Only present in the DSL
        # when explicitly set to false by scripts/validate/mark_ambiguous_blanks.py.
        safe_m = re.search(r'\bisFillInBlankSafe\s*=\s*(true|false)\b', block)
        is_safe = True if safe_m is None else (safe_m.group(1) == "true")
        if wid and sid and original and lang:
            words.append({
                "id": wid, "setId": sid, "original": original,
                "rarity": rarity, "lang": lang, "file": kt_file.name,
                "has_translit": has_translit, "translation": translation,
                "definition": extract_field(block, 'definition'),
                "definitionNative": extract_field(block, 'definitionNative'),
                "example": extract_field(block, 'example'),
                "exampleNative": extract_field(block, 'exampleNative'),
                "pos": extract_field(block, 'pos'),
                "semanticGroup": extract_field(block, 'semanticGroup'),
                "isFillInBlankSafe": is_safe,
            })
    return words


def find_file_for_set_id(set_id, data_dir=None):
    """
    Return the .kt file path containing the given setId, or None if not found.
    Searches all WordData*.kt under data_dir (defaults to ROOT).
    """
    search_dir = Path(data_dir) if data_dir else ROOT
    for kt in sorted(search_dir.glob("WordData*.kt")):
        content = kt.read_text(encoding="utf-8")
        if re.search(rf'\bsetId\s*=\s*{set_id}\b', content):
            return kt
    return None


def words_for_set_id(set_id, data_dir=None):
    """
    Return list of word dicts for the given setId. Searches across all
    WordData*.kt under data_dir (defaults to ROOT).
    """
    search_dir = Path(data_dir) if data_dir else ROOT
    result = []
    for kt in sorted(search_dir.glob("WordData*.kt")):
        for w in parse_words(kt):
            if w["setId"] == set_id:
                result.append(w)
    return result


def parse_sets(kt_file):
    """
    Parse all WordSetEntity records from a single .kt file.

    Returns list of dicts with keys:
        id, name, lang, topic, level, description, file
    """
    content = kt_file.read_text(encoding="utf-8")
    sets = []
    for block in parse_blocks(content, "WordSetEntity"):
        sid = extract_int_field(block, r'\bid')
        name = extract_field(block, 'name')
        lang = extract_field(block, 'languagePair')
        topic = extract_field(block, 'topic') or ""
        description = extract_field(block, 'description') or ""
        level_m = re.search(r'\blevel\s*=\s*(\d+)', block)
        level = int(level_m.group(1)) if level_m else 0
        if sid and name and lang:
            sets.append({
                "id": sid, "name": name, "lang": lang,
                "topic": topic, "level": level,
                "description": description, "file": kt_file.name,
            })
    return sets


# ── Git integration helpers ───────────────────────────────────────────────────

def get_staged_files():
    """Return set of .kt file basenames currently staged in the index."""
    try:
        r = subprocess.run(
            ["git", "diff", "--cached", "--name-only"],
            capture_output=True, text=True, timeout=5,
        )
        return {Path(p).name for p in r.stdout.splitlines() if p.endswith(".kt")}
    except Exception:
        return set()


def get_new_set_ids(staged_files):
    """
    Return setIds that are NEW in this commit (added, not modified).

    Looks for `+        WordSetEntity(id = N` lines in `git diff --cached`.
    Lets rarity/derivative checks skip pre-existing sets that only got
    metadata updates (topic/level/name) without new word content.
    """
    new_ids = set()
    removed_ids = set()
    if not staged_files:
        return new_ids
    try:
        r = subprocess.run(
            ["git", "diff", "--cached"],
            capture_output=True, text=True, timeout=10,
        )
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
