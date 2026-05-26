#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Hard-blocking validator: FILL_IN_BLANK exclusions must be fresh.

When an `example` is rewritten or words are added/removed from a set, the
existing `fillInBlankExclusions` lists become stale — they reflect the OLD
context, not the new one. Result: quiz distractors might be off (e.g.
a synonym that used to be excluded is now valid, or vice versa).

How freshness is detected:
  - `generate_fill_in_blank_exclusions.py --apply` (or --flip-safety-flag)
    records sha256(sorted [(id, example)]) for the set in
    `scripts/validate/pipeline_hashes.json` at end of each successful run.
  - This validator recomputes the hash from current data and compares.
  - Mismatch → exclusions outdated → block.
  - No recorded hash → "grandfathered" (set pre-dates this validator). Pass.
    On first pipeline run for the set, hash is recorded and future
    changes are protected.

To clear a failure:
  1. Generate LLM prompt:    python scripts/validate/fill_in_blank_prompt.py --set-id N
  2. Get JSON from LLM/subagent into /tmp/out.json
  3. Apply:                  python scripts/validate/generate_fill_in_blank_exclusions.py \\
                                 --set-id N --llm-output /tmp/out.json --apply

The --apply step automatically records the new hash → next commit passes.

Usage: validate_fillinblank_exclusions_fresh.py <setId>
Exit: 0 = fresh / grandfathered, 1 = stale, 2 = bad args
"""
import sys
import io
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
sys.path.insert(0, str(Path(__file__).parent))
from _parser import words_for_set_id  # noqa: E402
from generate_fill_in_blank_exclusions import (  # noqa: E402
    compute_set_hash, load_pipeline_hashes, HASH_FILE,
)


def validate(set_id):
    words = words_for_set_id(set_id)
    if not words:
        print(f"❌ setId={set_id}: no words found")
        return 1

    hashes = load_pipeline_hashes()
    recorded = hashes.get(str(set_id))

    if recorded is None:
        # Grandfathered: set has never been through pipeline (or pre-dates
        # this validator). Pass silently — first --apply will record hash.
        print(f"✅ setId={set_id}: no recorded hash (grandfathered)")
        return 0

    current = compute_set_hash(words)
    if current == recorded:
        print(f"✅ setId={set_id}: fillInBlankExclusions hash matches "
              f"({current[:12]}…)")
        return 0

    print(f"❌ setId={set_id}: fillInBlankExclusions устарели")
    print(f"    recorded hash: {recorded[:12]}…")
    print(f"    current hash:  {current[:12]}…")
    print()
    print(f"    Какое-то слово в setе сменило `example` или setId изменил "
          f"состав слов после последнего прогона pipeline.")
    print(f"    `fillInBlankExclusions` теперь могут не соответствовать "
          f"новому контексту — distractors будут некорректны.")
    print()
    print(f"    Прогон pipeline для обновления:")
    print(f"      python scripts/validate/fill_in_blank_prompt.py --set-id {set_id}")
    print(f"      # → передать LLM/subagent → получить /tmp/out.json")
    print(f"      python scripts/validate/generate_fill_in_blank_exclusions.py \\")
    print(f"          --set-id {set_id} --llm-output /tmp/out.json --apply")
    print()
    print(f"    Hash storage: {HASH_FILE}")
    return 1


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: validate_fillinblank_exclusions_fresh.py <setId>",
              file=sys.stderr)
        sys.exit(2)
    sys.exit(validate(int(sys.argv[1])))
