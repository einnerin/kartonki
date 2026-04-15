"""
Second pass: fills transliteration for entries that were left without it.
Handles British spellings, hyphenated words, and multi-word phrases.
"""

import re
import sys

import eng_to_ipa as ipa

FILES = [
    r"C:\Users\Einerin\AndroidStudioProjects\Kartonki\app\src\main\java\com\example\kartonki\data\WordDataEnglish.kt",
    r"C:\Users\Einerin\AndroidStudioProjects\Kartonki\app\src\main\java\com\example\kartonki\data\WordDataEnglishExpanded.kt",
]

# Matches entries that still have no transliteration:
#   original = "word", translation = ...   (no transliteration between them)
MISSING_PATTERN = re.compile(
    r'(original = "([^"]+)",)(?=\s+translation)'
)

# British → American suffix conversions
BRIT_TO_AM = [
    (re.compile(r'ise\b'), 'ize'),
    (re.compile(r'isation\b'), 'ization'),
    (re.compile(r'ising\b'), 'izing'),
    (re.compile(r'colour'), 'color'),
    (re.compile(r'honour'), 'honor'),
    (re.compile(r'humour'), 'humor'),
    (re.compile(r'favour'), 'favor'),
    (re.compile(r'behaviour'), 'behavior'),
    (re.compile(r'neighbour'), 'neighbor'),
    (re.compile(r'labour'), 'labor'),
    (re.compile(r'centre'), 'center'),
    (re.compile(r'theatre'), 'theater'),
    (re.compile(r'metre'), 'meter'),
    (re.compile(r'defence'), 'defense'),
    (re.compile(r'offence'), 'offense'),
    (re.compile(r'licence'), 'license'),
    (re.compile(r'practise'), 'practice'),
    (re.compile(r'pyjama'), 'pajama'),
    (re.compile(r'tyre'), 'tire'),
    (re.compile(r'travelling'), 'traveling'),
    (re.compile(r'travelled'), 'traveled'),
    (re.compile(r'counsellor'), 'counselor'),
    (re.compile(r'fulfil\b'), 'fulfill'),
    (re.compile(r'enrol\b'), 'enroll'),
    (re.compile(r'skillful'), 'skillful'),
]

# Manual overrides for words the library simply doesn't know
MANUAL: dict[str, str] = {
    "toothache":        "[ˈtuːθeɪk]",
    "headteacher":      "[ˈhɛdtiːtʃər]",
    "check-in":         "[ˈtʃɛkɪn]",
    "self-discipline":  "[sɛlf ˈdɪsɪplɪn]",
    "heatwave":         "[ˈhiːtweɪv]",
    "rebrand":          "[riːˈbrænd]",
    "acculturation":    "[əˌkʌltʃəˈreɪʃən]",
    "desertification":  "[dɪˌzɜːrtɪfɪˈkeɪʃən]",
    "problematise":     "[prəˈblɛmətaɪz]",
    "hypothesise":      "[haɪˈpɒθɪsaɪz]",
    "rationalise":      "[ˈræʃənəlaɪz]",
    "summarise":        "[ˈsʌməraɪz]",
    "synthesise":       "[ˈsɪnθəsaɪz]",
    "generalise":       "[ˈdʒɛnərəlaɪz]",
    "emphasise":        "[ˈɛmfəsaɪz]",
    "criticise":        "[ˈkrɪtɪsaɪz]",
    "civilisation":     "[ˌsɪvɪlaɪˈzeɪʃən]",
    "economise":        "[ɪˈkɒnəmaɪz]",
    "colourful":        "[ˈkʌlərfəl]",
}


def brit_to_am(word: str) -> str:
    result = word
    for pattern, replacement in BRIT_TO_AM:
        result = pattern.sub(replacement, result)
    return result


def convert(word: str) -> str:
    if word in MANUAL:
        return MANUAL[word]

    # Direct lookup
    result = ipa.convert(word)
    if result and "*" not in result:
        return f"[{result}]"

    # Try American spelling
    am_word = brit_to_am(word)
    if am_word != word:
        result = ipa.convert(am_word)
        if result and "*" not in result:
            return f"[{result}]"

    # Hyphenated: look up each part separately
    if "-" in word:
        parts = word.split("-")
        converted = []
        ok = True
        for part in parts:
            r = ipa.convert(part)
            if not r or "*" in r:
                ok = False
                break
            converted.append(r)
        if ok:
            return f"[{' '.join(converted)}]"

    # Multi-word: convert as phrase
    if " " in word:
        result = ipa.convert(word)
        if result and "*" not in result:
            return f"[{result}]"

    return ""


def process_file(path: str) -> None:
    with open(path, encoding="utf-8") as f:
        content = f.read()

    replaced = 0
    still_missing = []

    def replacer(m: re.Match) -> str:
        nonlocal replaced
        full_match = m.group(1)
        word = m.group(2)
        ipa_str = convert(word)
        replaced += 1
        if not ipa_str:
            still_missing.append(word)
            return full_match
        return f'{full_match} transliteration = "{ipa_str}",'

    new_content = MISSING_PATTERN.sub(replacer, content)

    with open(path, "w", encoding="utf-8") as f:
        f.write(new_content)

    filled = replaced - len(still_missing)
    sys.stdout.buffer.write(
        f"\n{path}\n"
        f"  Candidates : {replaced}\n"
        f"  Filled     : {filled}\n"
        f"  Still missing ({len(still_missing)}): "
        f"{', '.join(still_missing)}\n".encode("utf-8")
    )


for file_path in FILES:
    process_file(file_path)

sys.stdout.buffer.write(b"\nDone.\n")
