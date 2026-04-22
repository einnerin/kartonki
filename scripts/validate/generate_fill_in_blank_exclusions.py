#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Safety net for FILL_IN_BLANK exclusion lists: takes raw LLM output and
produces a cleaned + extended JSON ready to be applied to WordData*.kt.

Rules (applied in order for each target word):
  1. Remove Rule 1 article violators — if example has "an <target>", exclusions
     filtered to vowel-start originals; "a <target>" → consonant-start.
  2. Auto-add missing same-semanticGroup + same-pos + same-rarity neighbors
     that pass Rule 1. Catches LLM under-exclusions.
  3. form_mismatch detection — if target.original not in target.example (case-
     insensitive, whole-word), force form_mismatch=true, exclusions=[].
  4. Strip any candidate that is the target itself (shouldn't happen but guard).

Usage:
    python scripts/validate/generate_fill_in_blank_exclusions.py \\
        --set-id 9 \\
        --llm-output /tmp/subagent_out.json \\
        > /tmp/final_exclusions.json

See docs/claude/fill-in-blank-pipeline.md.
"""
import argparse
import json
import re
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).parent))
from _parser import ROOT, parse_words


# Approximation — good enough for English.
VOWEL_LETTERS = set("aeiouAEIOU")


def starts_with_vowel_sound(original: str) -> bool:
    """Approximation: first letter is a/e/i/o/u. Good enough for most cases.

    Known exceptions we don't handle: silent-h words (hour, honest),
    u-words pronounced /juː/ (user, uniform — actually consonant sound).
    Acceptable false-positive/negative rate for the product use-case.
    """
    s = original.strip()
    return bool(s) and s[0] in VOWEL_LETTERS


def detect_article_before_target(example: str, target: str) -> str | None:
    """Find the article directly preceding the target in the example.

    Returns 'a', 'an', or None.
    """
    # case-insensitive search for whole-word target
    pattern = re.compile(rf"\b(a|an)\s+{re.escape(target)}\b", re.IGNORECASE)
    m = pattern.search(example)
    if m:
        return m.group(1).lower()
    return None


def target_in_example(original: str, example: str) -> bool:
    """Whole-word case-insensitive presence check."""
    if not original or not example:
        return False
    pattern = re.compile(rf"\b{re.escape(original)}\b", re.IGNORECASE)
    return bool(pattern.search(example))


def candidate_appears_in_example(candidate_original: str, target_example: str,
                                   target_original: str) -> bool:
    """Rule 3 check: candidate's original (or inflected form) appears
    elsewhere in target's example, beyond the target word itself.
    """
    # Remove the target's occurrence(s) before searching.
    without_target = re.sub(
        rf"\b{re.escape(target_original)}\b", "",
        target_example, flags=re.IGNORECASE,
    )
    pattern = re.compile(rf"\b{re.escape(candidate_original)}\b", re.IGNORECASE)
    return bool(pattern.search(without_target))


def apply_safety_net(llm_entries: list[dict], set_words: list[dict]) -> list[dict]:
    """Take LLM output + full word data for a set; return corrected entries."""
    by_id = {w["id"]: w for w in set_words}
    llm_by_id = {e["id"]: e for e in llm_entries}
    out = []
    for target in set_words:
        tid = target["id"]
        llm_entry = llm_by_id.get(tid, {"id": tid, "original": target["original"],
                                          "exclusions": [], "form_mismatch": False})

        # Step 3: form_mismatch auto-detection (overrides LLM).
        if not target_in_example(target["original"], target.get("example", "")):
            out.append({
                "id": tid,
                "original": target["original"],
                "exclusions": [],
                "form_mismatch": True,
            })
            continue

        article = detect_article_before_target(target["example"], target["original"])
        llm_exclusions = llm_entry.get("exclusions", [])

        # Step 1: Rule 1 filter — remove article-mismatched candidates.
        filtered = []
        for exc in llm_exclusions:
            cand_id = exc["id"]
            if cand_id == tid:
                continue  # Step 4 sanity
            cand = by_id.get(cand_id)
            if not cand:
                continue
            cand_original = cand["original"]
            if article == "an" and not starts_with_vowel_sound(cand_original):
                continue  # "an bread" invalid
            if article == "a" and starts_with_vowel_sound(cand_original):
                continue  # "a orange" invalid
            # Rule 3 sanity
            if candidate_appears_in_example(cand_original, target["example"], target["original"]):
                continue
            filtered.append({"id": cand_id, "original": cand_original,
                             "why": exc.get("why", "llm")})

        # Step 2: auto-add same-semanticGroup + same-pos + same-rarity neighbors
        # that pass Rule 1 and Rule 3, if not already in list.
        existing = {e["id"] for e in filtered}
        for other in set_words:
            if other["id"] == tid or other["id"] in existing:
                continue
            if other.get("semanticGroup") != target.get("semanticGroup"):
                continue
            if other.get("pos") != target.get("pos"):
                continue
            if other.get("rarity") != target.get("rarity"):
                continue
            # Rule 1
            if article == "an" and not starts_with_vowel_sound(other["original"]):
                continue
            if article == "a" and starts_with_vowel_sound(other["original"]):
                continue
            # Rule 3
            if candidate_appears_in_example(other["original"], target["example"],
                                              target["original"]):
                continue
            filtered.append({"id": other["id"], "original": other["original"],
                             "why": "safety-net: same semGroup/pos/rarity"})

        out.append({
            "id": tid,
            "original": target["original"],
            "exclusions": filtered,
            "form_mismatch": False,
        })
    return out


def load_set_words(set_id: int) -> list[dict]:
    words = []
    for kt in sorted(ROOT.glob("WordData*.kt")):
        for w in parse_words(kt):
            if w.get("setId") == set_id:
                words.append(w)
    if not words:
        raise SystemExit(f"No words found for setId={set_id}")
    return words


def main() -> None:
    ap = argparse.ArgumentParser(description=__doc__)
    ap.add_argument("--set-id", type=int, required=True)
    ap.add_argument("--llm-output", type=Path, required=False,
                    help="JSON file with LLM subagent output. If omitted, "
                         "treat LLM output as empty (safety net only).")
    args = ap.parse_args()

    set_words = load_set_words(args.set_id)

    if args.llm_output:
        raw = args.llm_output.read_text(encoding="utf-8")
        # Tolerate markdown fencing if present
        raw = re.sub(r"^```(?:json)?\s*", "", raw.strip())
        raw = re.sub(r"\s*```\s*$", "", raw)
        llm_entries = json.loads(raw)
    else:
        llm_entries = []

    result = apply_safety_net(llm_entries, set_words)
    print(json.dumps(result, ensure_ascii=False, indent=2))


if __name__ == "__main__":
    main()
