#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""Fast in-process runner for the 20 per-setId validators.

Replaces the pre-commit hook's `for sid; do bash validate_all.sh $sid` loop,
which spawned 20*N python processes each re-parsing the whole corpus (~35s/set
on Windows). Here the corpus is parsed ONCE (parse_words mtime-cache) and every
validator runs in-process for every setId. Identical pass/fail semantics.

Usage: validate_fast.py <setId> [setId ...]
Exit 0 if all pass, 1 if any setId has a blocking failure.
"""
import sys, io, os, importlib, contextlib
sys.path.insert(0, "scripts/validate")


def _fresh_devnull_stdout():
    return io.TextIOWrapper(io.FileIO(os.devnull, "w"), encoding="utf-8", errors="replace")


def _fresh_real_stdout():
    return io.TextIOWrapper(io.FileIO(1, "w", closefd=False), encoding="utf-8",
                            errors="replace", line_buffering=True)

# Same 20 checks as validate_all.sh, in the same order.
CHECKS = [
    "validate_fields_filled", "validate_pos_values", "validate_group_sizes",
    "validate_text_lengths", "validate_rarity_spread", "validate_no_duplicates",
    "validate_no_cognates", "validate_no_headword_in_def",
    "validate_no_translation_in_defnative", "validate_text_terminators",
    "validate_original_in_example", "validate_original_strict_in_example",
    "validate_no_foreign_in_examplenative", "validate_no_clerical",
    "validate_blank_ambiguity_hebrew", "validate_no_foreign_script_in_original",
    "validate_no_mixed_script_in_words", "validate_example_variety",
    "validate_fillinblank_exclusions_fresh", "validate_blank_ambiguity",
]

mods = []
for name in CHECKS:
    # each validator re-wraps sys.stdout at import; give each a fresh isolated
    # buffer so the chained re-wrapping never closes a shared/real stream.
    sys.stdout = _fresh_devnull_stdout()
    try:
        mods.append((name, importlib.import_module(name)))
    except Exception as e:  # pragma: no cover
        sys.__stderr__.write(f"warn: import {name} failed: {e}\n")
sys.stdout = _fresh_real_stdout()


def run(setids):
    fails = {}
    for sid in setids:
        for name, mod in mods:
            buf = io.StringIO()
            try:
                with contextlib.redirect_stdout(buf), contextlib.redirect_stderr(buf):
                    rc = mod.validate(sid)
            except SystemExit as e:
                rc = e.code if isinstance(e.code, int) else 1
            except Exception as e:
                rc = 1
                buf.write(f"{name}: исключение: {e}")
            if rc not in (0, None):
                fails.setdefault(sid, []).append((name, buf.getvalue().strip()))
    return fails


if __name__ == "__main__":
    try:
        sids = [int(a) for a in sys.argv[1:]]
    except ValueError:
        print("Usage: validate_fast.py <setId> [setId ...]", file=sys.stderr)
        sys.exit(2)
    if not sids:
        sys.exit(0)
    fails = run(sids)
    if not fails:
        print(f"✅ validate_fast: все 20 проверок пройдены для {len(sids)} setId")
        sys.exit(0)
    for sid in sorted(fails):
        print(f"❌ setId={sid}: блокирующие нарушения:")
        for name, out in fails[sid]:
            first = out.splitlines()[0] if out else ""
            print(f"    ▸ {name}: {first}")
            print(f"      детали: bash scripts/validate/{name}.sh {sid}")
    sys.exit(1)
