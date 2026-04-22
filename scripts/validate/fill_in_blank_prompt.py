#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Generate an LLM prompt for FILL_IN_BLANK exclusion labeling for one set.

Reads all 25 words of the given --set-id from WordData*.kt, renders them
into the v3 prompt template (docs/claude/fill-in-blank-pipeline.md), and
prints the result. Copy the output into a general-purpose subagent to get
back a JSON exclusion list, then feed it into generate_fill_in_blank_exclusions.py.

Usage:
    python scripts/validate/fill_in_blank_prompt.py --set-id 9 > /tmp/prompt.md
"""
import argparse
import json
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).parent))
from _parser import ROOT, parse_words


PROMPT_TEMPLATE = """You are labeling a set of words for Kartonki's FILL_IN_BLANK quiz exclusion lists.

## Context

Kartonki is a Russian-market Android vocabulary app. In FILL_IN_BLANK quiz, the target word is blanked out of its example sentence, player picks correct vs 3 distractors. Problem: if a distractor also fits the blank, player gets frustrated. Solution: for each word, precompute which set-neighbors also fit the blank. These are excluded from the distractor pool.

## Core task

For each of the {num_words} words below: return the list of IDs of neighbors whose `original`, substituted into the target's `example` in place of the target word, produces a natural, grammatical, correct-sounding sentence.

Apply the 5 rules IN ORDER to every candidate. Any rule fails → the candidate is NOT an exclusion.

## THE CRITICAL PROCESS RULE

**Systematically walk through ALL {neighbors_count} neighbors for each target word. Do NOT stop at "enough". Do NOT skip obvious cases.** When a target has many ambiguous neighbors, catch ALL of them.

## Rule 1 — Article agreement
- `an ___` → candidate's `original` must start with a VOWEL SOUND (a, e, i, o, u, or silent h).
- `a ___`  → candidate must start with a CONSONANT SOUND.
- No article → rule doesn't apply.

Mismatched article is visibly wrong to the player → NOT a frustrating distractor → exclude only if article matches.

## Rule 2 — Preserve modifiers adjacent to the blank
Note ALL modifier words (adjectives, participles, noun-compound first halves). Candidate must form a natural phrase WITH those modifiers.

Examples:
- "roast ___" → roast chicken ✓, roast soup ✗
- "orange ___" → orange juice ✓, orange milk ✗
- "cheese ___" → cheese sandwich ✓, cheese pizza ✓, cheesecake ✓, cheese soup ✗
- "chocolate ___" → chocolate cake ✓, chocolate ice cream ✓, chocolate pizza ✗

## Rule 3 — Candidate must not appear in the example
If candidate's `original` (or inflected form) appears ELSEWHERE in the example, REJECT. Substituting creates "a cup of coffee or coffee" nonsense.

## Rule 4 — Mental substitution read-back
Replace the target with the candidate and read the full sentence. If grammar/meaning/naturalness is off, REJECT.

## Rule 5 — Conservatism tie-break
When rules 1–4 all pass but uncertain — INCLUDE. Over-exclusion costs nothing; under-exclusion frustrates the user.

## Form mismatch

If target's `original` does NOT appear verbatim in its `example` (e.g., original "egg" but example has "eggs"), set `"form_mismatch": true`, `exclusions: []`.

## Output

Raw JSON array, {num_words} entries in input order, no prose, no markdown fencing.

Schema (exact):
```json
[
  {{"id": <id>, "original": "<original>", "exclusions": [{{"id": <nid>, "original": "<noriginal>", "why": "<phrase>"}}], "form_mismatch": false}}
]
```

## The {num_words} words (set {set_id})

```json
{data_json}
```

Return the {num_words}-entry JSON array.
"""


def build_prompt(set_id: int) -> str:
    words = []
    for kt in sorted(ROOT.glob("WordData*.kt")):
        for w in parse_words(kt):
            if w.get("setId") == set_id:
                words.append({
                    "id": w["id"],
                    "original": w["original"],
                    "translation": w.get("translation", ""),
                    "example": w.get("example", ""),
                    "pos": w.get("pos"),
                    "semanticGroup": w.get("semanticGroup"),
                    "rarity": w.get("rarity"),
                })
    if not words:
        raise SystemExit(f"No words found for setId={set_id}")
    return PROMPT_TEMPLATE.format(
        num_words=len(words),
        neighbors_count=len(words) - 1,
        set_id=set_id,
        data_json=json.dumps(words, ensure_ascii=False, indent=2),
    )


def main() -> None:
    ap = argparse.ArgumentParser(description=__doc__)
    ap.add_argument("--set-id", type=int, required=True, help="setId to label")
    args = ap.parse_args()
    print(build_prompt(args.set_id))


if __name__ == "__main__":
    main()
