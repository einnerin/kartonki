"""
Adds IPA transliteration to all WordEntity entries in English word data files.

For each line containing:
    original = "word", translation = ...
it inserts:
    original = "word", transliteration = "[IPA]", translation = ...

Words not found in the eng_to_ipa dictionary are left with an empty
transliteration field so the slot is still present and can be filled manually.
"""

import re
import sys

import eng_to_ipa as ipa

FILES = [
    r"C:\Users\Einerin\AndroidStudioProjects\Kartonki\app\src\main\java\com\example\kartonki\data\WordDataEnglish.kt",
    r"C:\Users\Einerin\AndroidStudioProjects\Kartonki\app\src\main\java\com\example\kartonki\data\WordDataEnglishExpanded.kt",
]

# Matches:  original = "someword", translation
# Capture group 1 = the word inside quotes
# Uses a negative lookahead to skip entries that already have transliteration
PATTERN = re.compile(
    r'(original = "([^"]+)",)(?!\s*\n?\s*transliteration)'
)


def convert(word: str) -> str:
    """Return IPA in [brackets], or empty string if word not found."""
    result = ipa.convert(word)
    # eng_to_ipa marks unknown words by leaving asterisks or returning the word unchanged
    if not result or "*" in result:
        return ""
    return f"[{result}]"


def process_file(path: str) -> None:
    with open(path, encoding="utf-8") as f:
        content = f.read()

    replaced = 0
    missing = []

    def replacer(m: re.Match) -> str:
        nonlocal replaced
        full_match = m.group(1)   # original = "word",
        word = m.group(2)         # word
        ipa_str = convert(word)
        replaced += 1
        if not ipa_str:
            missing.append(word)
            return full_match     # leave as-is; transliteration stays null
        return f'{full_match} transliteration = "{ipa_str}",'

    new_content = PATTERN.sub(replacer, content)

    with open(path, "w", encoding="utf-8") as f:
        f.write(new_content)

    print(f"\n{path}")
    print(f"  Processed : {replaced} entries")
    print(f"  With IPA  : {replaced - len(missing)}")
    print(f"  Missing   : {len(missing)}")
    if missing:
        print(f"  Words without IPA: {', '.join(missing[:20])}" +
              (" ..." if len(missing) > 20 else ""))


for file_path in FILES:
    process_file(file_path)

print("\nDone.")
