#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Hard-blocking validator: exampleNative must start with Russian capital letter.

Background: exampleNative legitimately contains `original` embedded in Russian
text — that's a deliberate design pattern («Наш dog каждый вечер…»,
«Большое תּוֹדָה за помощь»). So we can't ban foreign letters wholesale.

The actual bug we're catching: subagent translated `example` to Russian but
forgot to translate the FIRST word, leaving it as foreign:

    example:       "The proliferation of nuclear weapons poses..."
    exampleNative: "proliferation ядерного оружия создаёт серьёзную угрозу..."
                    ↑ should be «Распространение ядерного оружия...»

Symptom: exampleNative starts with a lowercase letter (foreign or Russian
lowercase). Russian sentences ALWAYS start with a capital letter. Hebrew has
no case, so an exampleNative starting with a Hebrew letter is acceptable
(legit when first word is the embedded Hebrew original).

Acceptable first chars:
  - Russian uppercase А-ЯЁ
  - Latin uppercase A-Z (when `original` is capitalized and starts the sentence)
  - Hebrew letters (no case in Hebrew)
  - Digit (numbered list, year)
  - Quote, dash, bracket (— «"'(„«»)

Rejected: lowercase Latin (a-z), lowercase Russian (а-яё) at the very start.

Usage: validate_no_foreign_in_examplenative.py <setId>
Exit: 0 = clean, 1 = violations, 2 = bad args
"""
import sys
import io
import re
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
sys.path.insert(0, str(Path(__file__).parent))
from _parser import words_for_set_id  # noqa: E402

LOWERCASE_LATIN = re.compile(r'[a-z]')
LOWERCASE_CYR = re.compile(r'[а-яё]')


def first_significant_char(text):
    for ch in text:
        if ch.strip():
            return ch
    return ''


def validate(set_id):
    words = words_for_set_id(set_id)
    if not words:
        print(f"❌ setId={set_id}: no words found")
        return 1
    bad = []
    for w in words:
        exn = w.get("exampleNative") or ""
        if not exn:
            continue
        first = first_significant_char(exn)
        if not first:
            continue
        # Lowercase Latin → almost certainly untranslated copy-paste
        # Lowercase Russian → grammatically wrong (sentences start uppercase)
        if LOWERCASE_LATIN.match(first) or LOWERCASE_CYR.match(first):
            bad.append((w["id"], w["original"], first, exn[:60] + ("…" if len(exn) > 60 else "")))
    if bad:
        print(f"❌ setId={set_id}: {len(bad)} слов с exampleNative, "
              f"начинающимся со строчной буквы")
        for wid, orig, ch, snip in bad[:15]:
            print(f"    {wid} «{orig}» — exampleNative начинается с «{ch}»: {snip}")
        if len(bad) > 15:
            print(f"    ... and {len(bad) - 15} more")
        print()
        print("    exampleNative — русское предложение, начинается с заглавной. "
              "Строчная латинская буква = непереведённое слово (subagent забыл "
              "перевести начало). Строчная русская = грамматическая ошибка. "
              "Hebrew, цифры и открывающие кавычки/тире — допустимы.")
        return 1
    print(f"✅ setId={set_id}: exampleNative начинается корректно")
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: validate_no_foreign_in_examplenative.py <setId>", file=sys.stderr)
        sys.exit(2)
    sys.exit(validate(int(sys.argv[1])))
