#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
One-shot tool: mark every word flagged by validate_blank_ambiguity with
`isFillInBlankSafe = false` in its WordEntity(...) block in WordData*.kt.

Behaviour:
- Default: DRY-RUN — prints a report, does not touch any file.
- --apply: actually edits the .kt files.
- Idempotent: skips WordEntity blocks that already contain `isFillInBlankSafe`.
- Byte-preserving: reads/writes bytes so line endings (CRLF on Windows) stay
  exactly as they were. Only the single ", isFillInBlankSafe = false" injection
  is added per flagged WordEntity, right before the matching closing ')'.

Usage:
    python scripts/validate/mark_ambiguous_blanks.py          # dry-run
    python scripts/validate/mark_ambiguous_blanks.py --apply  # edit files
"""
import sys
import io
import re
import argparse
from collections import defaultdict, Counter
from pathlib import Path

sys.path.insert(0, str(Path(__file__).parent))

# validate_blank_ambiguity installs a UTF-8 stdout wrapper at import time —
# don't re-wrap here (double-wrap closes the buffer on Windows).
from _parser import ROOT, parse_words  # noqa: E402
from validate_blank_ambiguity import (  # noqa: E402
    find_exact, find_inflected,
    PLURALIA_TANTUM_EN, LENGTH_SIMILARITY_THRESHOLD,
)


# ── Violation detection (mirrors validate_blank_ambiguity.validate) ───────────

def find_violations():
    """
    Walk every WordData*.kt file, reproduce the validator's per-word logic,
    return a dict: {word_id: (type, setId, original, file, example)}.
    Only the FIRST violation type per word is recorded (order: FORM_MISMATCH,
    NOT_IN_EXAMPLE, AMBIGUOUS_BLANK) — marking the same word twice is moot.
    """
    all_words = []
    word_file = {}
    for kt in sorted(ROOT.glob("WordData*.kt")):
        for w in parse_words(kt):
            all_words.append(w)
            word_file[w["id"]] = kt.name

    by_group = defaultdict(list)
    for w in all_words:
        by_group[(w["setId"], w.get("semanticGroup"))].append(w)

    flagged = {}  # word_id -> (type, setId, original, file, example)
    for w in all_words:
        lang = w.get("lang", "")
        if not lang.startswith("en"):
            continue
        if w.get("isFillInBlankSafe") is False:
            continue  # already marked, skip (idempotent)
        original = w["original"]
        example = w.get("example")
        if not example or not original:
            continue

        exact = find_exact(original, example)
        if exact is not None:
            blank_start = exact[0]
        else:
            inflected = find_inflected(original, example)
            if inflected is not None:
                blank_start = inflected[0]
                if original.lower() not in PLURALIA_TANTUM_EN:
                    flagged[w["id"]] = (
                        "FORM_MISMATCH",
                        w["setId"], original, word_file[w["id"]], example,
                    )
            else:
                flagged[w["id"]] = (
                    "NOT_IN_EXAMPLE",
                    w["setId"], original, word_file[w["id"]], example,
                )
                continue  # already flagged; no ambiguity check without blank pos

        group = w.get("semanticGroup")
        if not group:
            continue
        target_len = len(original)
        for other in by_group[(w["setId"], group)]:
            if other["id"] == w["id"]:
                continue
            if other.get("pos") != w.get("pos"):
                continue
            if abs(len(other["original"]) - target_len) > LENGTH_SIMILARITY_THRESHOLD:
                continue
            # Don't overwrite a FORM_MISMATCH entry already recorded for this word.
            flagged.setdefault(w["id"], (
                "AMBIGUOUS_BLANK",
                w["setId"], original, word_file[w["id"]], example,
            ))
            break

    return flagged


# ── Byte-preserving injection ────────────────────────────────────────────────

_WORD_ENTITY_START = re.compile(rb'WordEntity\(\s*id\s*=\s*(\d+)')


def inject_flag(raw_bytes: bytes, target_ids: set[int]) -> tuple[bytes, int]:
    """
    Return (new_bytes, injected_count). Each matching WordEntity block gets
    `, isFillInBlankSafe = false` inserted right before its closing ')'.

    Parens inside string literals are ignored. If the block already contains
    `isFillInBlankSafe`, it's left alone (idempotent).
    """
    out = bytearray()
    pos = 0
    injected = 0

    while pos < len(raw_bytes):
        m = _WORD_ENTITY_START.search(raw_bytes, pos)
        if m is None:
            out.extend(raw_bytes[pos:])
            break
        # Copy everything up to (and including) the start of the block header.
        out.extend(raw_bytes[pos:m.start()])
        wid = int(m.group(1))

        # Walk the block, tracking paren depth while skipping string literals.
        # The block starts at the '(' immediately after "WordEntity".
        open_paren_idx = raw_bytes.index(b'(', m.start())
        depth = 1
        i = open_paren_idx + 1
        while i < len(raw_bytes) and depth > 0:
            c = raw_bytes[i:i+1]
            if c == b'"':
                # Skip string literal, honouring backslash escapes.
                i += 1
                while i < len(raw_bytes) and raw_bytes[i:i+1] != b'"':
                    if raw_bytes[i:i+1] == b'\\' and i + 1 < len(raw_bytes):
                        i += 2
                    else:
                        i += 1
                i += 1  # past closing quote
                continue
            if c == b'(':
                depth += 1
            elif c == b')':
                depth -= 1
                if depth == 0:
                    break
            i += 1

        if depth != 0:
            # Malformed file — bail without modifying anything.
            raise RuntimeError(
                f"Unbalanced parens starting at WordEntity(id={wid}) — aborting"
            )

        close_paren_idx = i  # position of the matching ')'
        block_bytes = raw_bytes[m.start():close_paren_idx + 1]

        if wid in target_ids and b"isFillInBlankSafe" not in block_bytes:
            # Emit block up to (not including) the ')', insert marker, then ')'.
            out.extend(raw_bytes[m.start():close_paren_idx])
            out.extend(b", isFillInBlankSafe = false")
            out.extend(raw_bytes[close_paren_idx:close_paren_idx + 1])
            injected += 1
        else:
            out.extend(block_bytes)

        pos = close_paren_idx + 1

    return bytes(out), injected


# ── Report ────────────────────────────────────────────────────────────────────

def print_report(flagged, apply_mode: bool, per_file_written: dict[str, int]):
    total = len(flagged)
    type_counts = Counter(v[0] for v in flagged.values())
    file_counts = Counter(v[3] for v in flagged.values())

    print("=" * 64)
    mode = "APPLY" if apply_mode else "DRY-RUN (no files modified)"
    print(f"mark_ambiguous_blanks — {mode}")
    print("=" * 64)
    print()
    print(f"Всего помечено бы: {total} слов")
    print(f"  FORM_MISMATCH:    {type_counts.get('FORM_MISMATCH', 0)}")
    print(f"  AMBIGUOUS_BLANK:  {type_counts.get('AMBIGUOUS_BLANK', 0)}")
    print(f"  NOT_IN_EXAMPLE:   {type_counts.get('NOT_IN_EXAMPLE', 0)}")
    print()

    print(f"По файлам ({len(file_counts)} файлов):")
    for f, c in file_counts.most_common():
        if apply_mode:
            written = per_file_written.get(f, 0)
            print(f"  {c:5d}  {f}   (written: {written})")
        else:
            print(f"  {c:5d}  {f}")
    print()

    # 10 sample words for eyeball-check
    print("Примеры (10 первых):")
    for wid, (typ, sid, orig, f, ex) in list(flagged.items())[:10]:
        ex_short = (ex or "")[:70]
        print(f"  id={wid} setId={sid} «{orig}» [{typ}] in {f}")
        print(f"      example: {ex_short}")
    if total > 10:
        print(f"  ... and {total - 10} more")
    print()


# ── Entry point ───────────────────────────────────────────────────────────────

def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--apply", action="store_true",
                        help="Actually modify files. Without this flag, the script is a dry-run.")
    args = parser.parse_args()

    flagged = find_violations()
    target_ids_by_file = defaultdict(set)
    for wid, (_typ, _sid, _orig, f, _ex) in flagged.items():
        target_ids_by_file[f].add(wid)

    per_file_written: dict[str, int] = {}
    if args.apply:
        for filename, ids in target_ids_by_file.items():
            kt_path = ROOT / filename
            raw = kt_path.read_bytes()
            new_raw, n = inject_flag(raw, ids)
            if n > 0:
                kt_path.write_bytes(new_raw)
            per_file_written[filename] = n

    print_report(flagged, args.apply, per_file_written)
    return 0


if __name__ == "__main__":
    sys.exit(main())
