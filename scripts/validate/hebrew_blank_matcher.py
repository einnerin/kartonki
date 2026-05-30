#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Python port of Kotlin HebrewBlankMatcher.

Used by validators and re-evaluation scripts to predict whether the runtime
FILL_IN_BLANK will succeed for a given (example, original) pair. Logic must
mirror app/src/main/java/com/example/kartonki/domain/quiz/HebrewBlankMatcher.kt
1:1 — if these diverge, validation lies.
"""
import re

NIKUD_RE = re.compile(r'[֑-ׇ]')

# Same prefix list as Kotlin HebrewBlankMatcher.PREFIXES. Order doesn't matter
# semantically (we just need to find any successful prefix), but keep it in
# sync for diff readability.
PREFIXES = [
    "",
    "ה", "ב", "ל", "מ", "כ", "ו", "ש",
    "וה", "וב", "ול", "ומ", "וכ",
    "כש", "לש", "מש", "בש",
]


def strip_nikud(text):
    return NIKUD_RE.sub('', text or '')


HEBREW_LETTER_RE = re.compile(r'[א-ת]')


def _is_hebrew_letter(ch):
    return bool(ch and HEBREW_LETTER_RE.match(ch))


def _has_hebrew_letter_before(s, idx):
    """True if a Hebrew letter sits immediately before idx, skipping nikud marks.

    Mirrors Kotlin HebrewBlankMatcher.hasHebrewLetterBefore — needed because the
    strict path used to match a bare nikud-aligned root inside a prefixed form
    (e.g. `כֶּלֶב` inside `הַכֶּלֶב`), leaving the article dangling next to the blank.
    The patach `ַ` on the prefix `ה` is a nikud char, not a letter, so a naive
    char-by-char boundary check would say "no letter before". Skipping nikud
    until a real letter (or string start) gives the correct answer.
    """
    i = idx - 1
    while i >= 0 and NIKUD_RE.match(s[i]):
        i -= 1
    return i >= 0 and _is_hebrew_letter(s[i])


def _has_hebrew_letter_after(s, idx):
    """True if a Hebrew letter sits immediately at/after idx, skipping nikud marks.

    Mirrors the same Kotlin helper. Closes the suffix-inflection hole: a bare
    headword like `פָּשַׁט` (3ms past) sits as a *prefix* of `פָּשַׁטְתִּי` (1s past) —
    same nikud, no leading prefix letter — so the strict `original in example`
    used to succeed there too, blanking the stem and leaving `תִּי` dangling.
    With this check, the strict path correctly bails on suffix-inflected forms
    and the caller falls through to prefix-aware mode (which also won't match
    suffix inflection, so we end up returning False — the right answer).
    """
    i = idx
    while i < len(s) and NIKUD_RE.match(s[i]):
        i += 1
    return i < len(s) and _is_hebrew_letter(s[i])


def _find_word_bounded(haystack, needle):
    """Return index of needle in haystack such that boundaries on both sides
    are NOT Hebrew letters (so we don't match singular inside plural)."""
    start = 0
    while True:
        idx = haystack.find(needle, start)
        if idx < 0:
            return -1
        before_ok = (idx == 0) or not _is_hebrew_letter(haystack[idx - 1])
        end = idx + len(needle)
        after_ok = (end == len(haystack)) or not _is_hebrew_letter(haystack[end])
        if before_ok and after_ok:
            return idx
        start = idx + 1


PREFIX_CHARS = "הבלמכוש"
PREFIX_REGEX = f"[{PREFIX_CHARS}]*"


def _build_multi_token_regex(orig_stripped):
    """Build a regex matching orig_stripped allowing prefix letters before
    each whitespace-separated token. Used for multi-word phrases where
    the article ה or preposition attaches to BOTH words separately
    (e.g. `קַלְמָר עֲנָק` → `הַקַּלְמָר הָעֲנָק`)."""
    tokens = orig_stripped.split()
    return r'\s+'.join(PREFIX_REGEX + re.escape(tok) for tok in tokens)


def can_make_blank(example, original):
    """True if matcher would successfully replace original in example."""
    if not example or not original:
        return False

    # 1) Strict path — word-bounded so a bare root doesn't match inside a
    # prefixed/inflected form (see helpers above).
    idx = example.find(original)
    if idx >= 0 and \
       not _has_hebrew_letter_before(example, idx) and \
       not _has_hebrew_letter_after(example, idx + len(original)):
        return True

    # 2) Nikud-insensitive + prefix tolerance, word-bounded
    orig_stripped = strip_nikud(original)
    if not orig_stripped:
        return False
    ex_stripped = strip_nikud(example)
    # 2a) Single token, or leading-prefix-only multi-token (cheap)
    for prefix in PREFIXES:
        if _find_word_bounded(ex_stripped, prefix + orig_stripped) >= 0:
            return True
    # 2b) Multi-token with per-token prefix (handles double-article in
    #     compound phrases: `קַלְמָר עֲנָק` in `הַקַּלְמָר הָעֲנָק`)
    if ' ' in orig_stripped:
        pat = _build_multi_token_regex(orig_stripped)
        if re.search(rf'(?<![א-ת]){pat}(?![א-ת])', ex_stripped):
            return True
    return False


def replace_blank(example, original, blank="_____"):
    """Replace original with blank in example, returning new string or None."""
    if not example or not original:
        return None

    # 1) Strict path — replaceFirst, word-bounded. Same boundary check as
    # can_make_blank: a bare root must not sit inside a prefixed/inflected form.
    idx = example.find(original)
    if idx >= 0 and \
       not _has_hebrew_letter_before(example, idx) and \
       not _has_hebrew_letter_after(example, idx + len(original)):
        return example[:idx] + blank + example[idx + len(original):]

    # 2) Nikud-insensitive + prefix tolerance with index mapping
    orig_stripped = strip_nikud(original)
    if not orig_stripped:
        return None

    mapping = []
    stripped_chars = []
    for i, c in enumerate(example):
        if NIKUD_RE.match(c):
            continue
        mapping.append(i)
        stripped_chars.append(c)
    mapping.append(len(example))
    ex_stripped = ''.join(stripped_chars)

    # 2a) Single-token / leading-prefix-only
    for prefix in PREFIXES:
        needle = prefix + orig_stripped
        idx = _find_word_bounded(ex_stripped, needle)
        if idx < 0:
            continue
        start_orig = mapping[idx]
        end_orig = mapping[idx + len(needle)]
        return example[:start_orig] + blank + example[end_orig:]

    # 2b) Multi-token with per-token prefix
    if ' ' in orig_stripped:
        pat = _build_multi_token_regex(orig_stripped)
        m = re.search(rf'(?<![א-ת]){pat}(?![א-ת])', ex_stripped)
        if m:
            start_orig = mapping[m.start()]
            end_orig = mapping[m.end()]
            return example[:start_orig] + blank + example[end_orig:]

    return None


if __name__ == "__main__":
    import sys, io
    sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')
    # Self-test
    tests = [
        ("אֲנִי אוֹהֵב כֶּלֶב.", "כֶּלֶב", True),
        ("הַתְּבִיעָה הֻגְּשָׁה לְבֵית מִשְׁפָּט הַשָּׁלוֹם.", "בֵּית מִשְׁפָּט הַשָּׁלוֹם", True),
        ("הַכֶּלֶב נָבַח.", "כֶּלֶב", True),
        ("הַחָתוּל יָשַׁן.", "כֶּלֶב", False),
        ("הַכְּלָבִים נָבְחוּ.", "כֶּלֶב", False),
        # Suffix-inflection regression — must not match stem inside conjugated form.
        # Stems Kotlin runtime would refuse to blank also must be False here, else
        # validator would advise unfreezing words the app can't actually quiz.
        ("פָּשַׁטְתִּי אֶת הַמְּעִיל בַּבַּיִת.", "פָּשַׁט", False),
        # Article ה with nikud-aligned root — strict path used to leave `הַ_____`.
        # Prefix-aware path correctly absorbs the article into the blank → True.
        ("הַכֶּלֶב נָבַח כָּל הַלַּיְלָה.", "כֶּלֶב", True),
    ]
    for ex, orig, expected in tests:
        got = can_make_blank(ex, orig)
        status = "PASS" if got == expected else "FAIL"
        print(f"  {status}: can_make_blank({orig!r}) → {got}, expected {expected}")
