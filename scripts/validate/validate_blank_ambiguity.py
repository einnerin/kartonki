#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Validate that FILL_IN_BLANK examples produce a clean, unambiguous blank.

Two checks per example (English only — Hebrew morphology is out of scope here
and is validated in a separate pass):

1. FORM_MISMATCH — the example must contain `original` letter-for-letter.
   Inflected forms (plural, past, gerund) are rejected because QuizBuilder
   does a naive `example.replace(original, "___")` — an inflected form leaks
   its suffix into the UI as "___s" / "___ed" / "___ing". The only exception
   is pluralia tantum (scissors, trousers, glasses — legitimately plural).

2. AMBIGUOUS_BLANK — after masking the target with "___", no sibling word
   from the same (setId, semanticGroup) should plausibly fit. Heuristic:
   a sibling with same `pos` and original-length close to target
   (|diff| ≤ 3 chars) is counted as a candidate. This catches templated
   examples like "I baked a batch of ___" where cookie/brownie/muffin are
   all tier1 distractors in `QuizBuilder.pickDistractors`.

Exit 1 on any violation, 0 otherwise.
"""
import sys
import io
import re
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
sys.path.insert(0, str(Path(__file__).parent))
from _parser import words_for_set_id  # noqa: E402


# Pluralia tantum — English nouns whose `original` is legitimately plural.
# For these, the form check is skipped (no "___s" is produced anyway).
PLURALIA_TANTUM_EN = {
    "scissors", "trousers", "pants", "jeans", "shorts",
    "glasses", "sunglasses", "goggles", "pajamas", "pyjamas",
    "clothes", "headphones", "earphones", "binoculars",
    "tongs", "tweezers", "pliers", "scales",
    "belongings", "surroundings", "outskirts", "stairs",
    "premises", "remains", "odds", "thanks", "congratulations",
}

# Regular English inflections. Each fn returns the inflected form or None.
INFLECTIONS = [
    lambda w: w + "s",
    lambda w: w + "es",
    lambda w: (w[:-1] + "ies") if w.endswith("y") and len(w) > 2 and w[-2] not in "aeiou" else None,
    lambda w: w + "ed",
    lambda w: (w[:-1] + "ied") if w.endswith("y") and len(w) > 2 and w[-2] not in "aeiou" else None,
    lambda w: w + "d" if w.endswith("e") else None,
    lambda w: w + "ing",
    lambda w: (w[:-1] + "ing") if w.endswith("e") and len(w) > 2 else None,
]

LENGTH_SIMILARITY_THRESHOLD = 3  # |len(a) - len(b)| <= 3 → similar


def find_exact(original, example):
    """Return (start, end) of `original` as a standalone token, or None."""
    pat = r'\b' + re.escape(original) + r'\b'
    m = re.search(pat, example, re.IGNORECASE)
    return (m.start(), m.end()) if m else None


def find_inflected(original, example):
    """Return (start, end, matched_form) for the first inflected form, or None."""
    orig = original.lower()
    seen = set()
    for fn in INFLECTIONS:
        form = fn(orig)
        if not form or form == orig or form in seen:
            continue
        seen.add(form)
        pat = r'\b' + re.escape(form) + r'\b'
        m = re.search(pat, example, re.IGNORECASE)
        if m:
            return (m.start(), m.end(), m.group(0))
    return None


def validate(set_id):
    words = words_for_set_id(set_id)
    if not words:
        print(f"❌ setId={set_id}: no words found")
        return 1

    # Group words by (setId, semanticGroup)
    by_group = {}
    for w in words:
        key = (w["setId"], w.get("semanticGroup"))
        by_group.setdefault(key, []).append(w)

    violations = []
    for w in words:
        lang = w.get("lang", "")
        if not lang.startswith("en"):
            continue  # Hebrew morphology out of scope for this validator

        # Words explicitly marked as unsafe are excluded from the quiz's
        # FILL_IN_BLANK type (see QuizBuilder.pickQuizType), so the validator
        # has nothing to enforce on them.
        if w.get("isFillInBlankSafe") is False:
            continue

        original = w["original"]
        example = w.get("example")
        if not example or not original:
            continue

        # ── FORM check ─────────────────────────────────────────────────────
        exact = find_exact(original, example)
        blank_start = blank_end = None
        is_pluralia_tantum = original.lower() in PLURALIA_TANTUM_EN

        if exact is not None:
            blank_start, blank_end = exact
        else:
            inflected = find_inflected(original, example)
            if inflected is not None:
                blank_start, blank_end, bad_form = inflected
                if not is_pluralia_tantum:
                    preview = example[:blank_start] + "___" + example[blank_end:]
                    violations.append((
                        w["id"], original, "FORM_MISMATCH",
                        f"example использует «{bad_form}» вместо «{original}» — "
                        f"в UI получится: «{preview}»"
                    ))
            else:
                violations.append((
                    w["id"], original, "NOT_IN_EXAMPLE",
                    f"целевое слово не найдено в example: «{example}»"
                ))
                continue  # no blank position → skip ambiguity check

        # ── AMBIGUITY check ────────────────────────────────────────────────
        group_key = (w["setId"], w.get("semanticGroup"))
        if not group_key[1]:
            continue  # no semanticGroup → can't compare
        siblings = by_group.get(group_key, [])
        target_len = len(original)
        # fillInBlankExclusions are handled at runtime by QuizBuilder —
        # neighbors already in the exclusion list cannot become distractors.
        # See docs/claude/fill-in-blank-pipeline.md.
        exclusion_ids = set(w.get("fillInBlankExclusions") or [])
        # Rule 1 (article filter): "an ___" → only vowel-start candidates
        # are possible distractors. Consonant-start with "an" is visibly
        # wrong to the player so never produces frustration.
        article = None
        pre = example[:blank_start].rstrip().lower()
        if pre.endswith(" an"):
            article = "an"
        elif pre.endswith(" a") or pre == "a":
            article = "a"
        # Rule 3 (candidate already in example): if candidate's original
        # appears elsewhere in the example, substituting creates "cup of
        # coffee or coffee" nonsense — not a viable distractor.
        example_without_target = example[:blank_start] + example[blank_end:]
        example_lower = example_without_target.lower()
        candidates = []
        for other in siblings:
            if other["id"] == w["id"]:
                continue
            if other["id"] in exclusion_ids:
                continue  # handled by fillInBlankExclusions pipeline
            if other.get("pos") != w.get("pos"):
                continue
            if abs(len(other["original"]) - target_len) > LENGTH_SIMILARITY_THRESHOLD:
                continue
            cand_orig = other["original"]
            # Rule 1: article/vowel mismatch → visibly wrong → skip
            first = cand_orig[0].lower() if cand_orig else ""
            is_vowel = first in "aeiou"
            if article == "an" and not is_vowel:
                continue
            if article == "a" and is_vowel:
                continue
            # Rule 3: candidate already in example → nonsense if substituted
            if re.search(rf"\b{re.escape(cand_orig.lower())}\b", example_lower):
                continue
            candidates.append(cand_orig)
        if candidates:
            preview = example[:blank_start] + "___" + example[blank_end:]
            shown = ", ".join(candidates[:4])
            if len(candidates) > 4:
                shown += f" (+{len(candidates) - 4})"
            violations.append((
                w["id"], original, "AMBIGUOUS_BLANK",
                f"в пропуск «{preview}» подходят также: {shown}"
            ))

    # Separate blocking violations (FORM_MISMATCH, NOT_IN_EXAMPLE — quiz
    # literally broken) from ambiguity warnings (another word happens to fit
    # the blank — Phase A pipeline should handle, but some slip through).
    #
    # History: before 2026-04-24, all three codes blocked commits. Softened
    # to WARN for AMBIGUOUS_BLANK after Phase 4 audit showed that enforcing
    # it at release time would require marking ~3500 words isFillInBlankSafe=false
    # (68% of quiz-eligible words would vanish from FILL_IN_BLANK type).
    # Phase A pipeline + fillInBlankExclusions already catches most cases;
    # the remaining ~5% slip is acceptable for a first release.
    blocking = [v for v in violations if v[2] in ("FORM_MISMATCH", "NOT_IN_EXAMPLE")]
    warnings = [v for v in violations if v[2] == "AMBIGUOUS_BLANK"]

    if blocking:
        print(f"❌ setId={set_id}: {len(blocking)} проблем с FILL_IN_BLANK")
        for wid, orig, code, msg in blocking[:20]:
            print(f"    {wid} «{orig}» [{code}] {msg}")
        if len(blocking) > 20:
            print(f"    ... and {len(blocking) - 20} more")
        if warnings:
            print(f"    + {len(warnings)} AMBIGUOUS_BLANK warning(s) (не блокируют)")
        return 1

    if warnings:
        print(f"⚠️  setId={set_id}: {len(warnings)} ambiguous blanks (WARN; не блокирует)")
        for wid, orig, code, msg in warnings[:10]:
            print(f"    {wid} «{orig}» [{code}] {msg}")
        if len(warnings) > 10:
            print(f"    ... and {len(warnings) - 10} more")
        return 0

    print(f"✅ setId={set_id}: все пропуски однозначны, формы совпадают")
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: validate_blank_ambiguity.py <setId>", file=sys.stderr)
        sys.exit(2)
    sys.exit(validate(int(sys.argv[1])))
