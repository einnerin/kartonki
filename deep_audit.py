"""Глубокий аудит всех слов и наборов. Использует балансированный парсер.

Проверяет:
  A. Слова — обязательные поля, редкость из списка, формула ID, language pair, transliteration для he-ru
  B. Наборы — поля, имя по schema, 25 слов, совпадение topic/level с именем
  C. Кроссы — slava (orphan words), дубли по original в одной теме, setId=0 не-rewards
  D. Разброс редкости в наборе
"""
import re
import glob
import sys
from collections import defaultdict, Counter

RARITY_LEVEL = {"COMMON": 1, "UNCOMMON": 2, "RARE": 3, "EPIC": 4, "LEGENDARY": 5}
VALID_RARITIES = set(RARITY_LEVEL)
LEVEL_WORDS = {1: "основы", 2: "продвинутый", 3: "углублённый",
               4: "профессиональный", 5: "носитель языка"}
LANG_RANGES = {"en-ru": range(1, 1000), "he-ru": range(1001, 2000)}


def parse(content, kind):
    out = []
    for m in re.finditer(rf"{kind}\s*\(", content):
        start = m.start(); i = m.end(); depth = 1; in_str = False; esc = False
        while i < len(content) and depth > 0:
            ch = content[i]
            if esc: esc = False
            elif ch == "\\": esc = True
            elif ch == '"': in_str = not in_str
            elif not in_str:
                if ch == "(": depth += 1
                elif ch == ")":
                    depth -= 1
                    if depth == 0:
                        out.append((start, i + 1, content[m.end():i])); break
            i += 1
    return out


def collect():
    sets = {}  # set_id -> info
    words = []  # list of dict
    for path in sorted(glob.glob("app/src/main/java/com/example/kartonki/data/WordData*.kt")):
        fname = path.split("\\")[-1]
        content = open(path, encoding="utf-8").read()
        for _, _, body in parse(content, "WordSetEntity"):
            info = {"file": fname}
            for f in ["id", "level", "orderIndex"]:
                m = re.search(rf"\b{f}\s*=\s*(\d+)", body)
                info[f] = int(m.group(1)) if m else None
            for f in ["name", "description", "topic", "languagePair"]:
                m = re.search(rf'\b{f}\s*=\s*"((?:\\"|[^"])*)"', body)
                info[f] = m.group(1) if m else None
            if info.get("id") is not None:
                sets[info["id"]] = info

        for _, _, body in parse(content, "WordEntity"):
            w = {"file": fname}
            for f in ["id", "setId"]:
                m = re.search(rf"\b{f}\s*=\s*(\d+)", body)
                w[f] = int(m.group(1)) if m else None
            for f in ["original", "translation", "transliteration", "rarity", "languagePair", "semanticGroup", "pos"]:
                m = re.search(rf'\b{f}\s*=\s*"((?:\\"|[^"])*)"', body)
                w[f] = m.group(1) if m else None
            words.append(w)
    return sets, words


def check_words(sets, words):
    issues = defaultdict(list)
    for w in words:
        label = f'{w["file"]} word id={w.get("id")}'
        # A1: обязательные поля
        for f in ["id", "setId", "original", "translation", "rarity"]:
            if w.get(f) is None:
                issues["A1_missing_field"].append(f'{label} — нет поля {f}')
        # A2: редкость
        if w.get("rarity") and w["rarity"] not in VALID_RARITIES:
            issues["A2_bad_rarity"].append(f'{label} — rarity={w["rarity"]}')
        # A3: setId=0 допустим только для semanticGroup=achievement_reward
        if w.get("setId") == 0:
            if w.get("semanticGroup") != "achievement_reward":
                issues["A3_orphan_setId0"].append(f'{label} original={w.get("original")}')
            continue  # остальные проверки не применяем
        # A4: слово ссылается на несуществующий setId
        if w.get("setId") and w["setId"] not in sets:
            issues["A4_unknown_setId"].append(f'{label} setId={w["setId"]} не существует')
            continue
        parent = sets.get(w.get("setId"))
        if not parent:
            continue
        # A5: languagePair слова совпадает с набором
        if w.get("languagePair") and parent.get("languagePair") and w["languagePair"] != parent["languagePair"]:
            issues["A5_lang_mismatch"].append(
                f'{label} lang={w["languagePair"]} set-lang={parent["languagePair"]}'
            )
        # A6: id формула = setId * 100 + позиция (1..99)
        expected_range_lo = w["setId"] * 100 + 1
        expected_range_hi = w["setId"] * 100 + 99
        if w.get("id") and not (expected_range_lo <= w["id"] <= expected_range_hi):
            issues["A6_id_formula"].append(
                f'{label} id={w["id"]} setId={w["setId"]} (ожидалось {expected_range_lo}..{expected_range_hi})'
            )
        # A7: транслитерация обязательна для he-ru
        if parent.get("languagePair") == "he-ru":
            if not w.get("transliteration"):
                issues["A7_no_translit"].append(f'{label} original={w.get("original")}')
        # A8: пустые строки
        for f in ["original", "translation"]:
            if w.get(f) == "":
                issues["A8_empty_string"].append(f'{label} пустое {f}')
    return issues


def check_sets(sets, words):
    issues = defaultdict(list)
    by_set = defaultdict(list)
    for w in words:
        if w.get("setId"):
            by_set[w["setId"]].append(w)

    for sid, info in sets.items():
        label = f'{info["file"]} set id={sid}'
        # B1: обязательные поля
        for f in ["name", "topic", "level", "languagePair"]:
            if not info.get(f):
                issues["B1_missing"].append(f'{label} — нет {f}')
        if info.get("level") == 0:
            issues["B1_missing"].append(f'{label} — level=0')
        # B2: level в [1,5]
        if info.get("level") and not (1 <= info["level"] <= 5):
            issues["B2_bad_level"].append(f'{label} level={info["level"]}')
        # B3: setId в диапазоне языка
        lang = info.get("languagePair")
        if lang and lang in LANG_RANGES and sid not in LANG_RANGES[lang]:
            issues["B3_id_range"].append(f'{label} lang={lang} sid вне диапазона')
        # B4: имя по schema "<topic>: <word> [N]"
        if info.get("name") and info.get("topic") and info.get("level"):
            word = LEVEL_WORDS.get(info["level"])
            prefix = f'{info["topic"]}: {word}'
            if not info["name"].startswith(prefix):
                issues["B4_name_schema"].append(
                    f'{label} name="{info["name"]}" ожидалось начало "{prefix}"'
                )
        # B5: 25 слов
        words_count = len(by_set.get(sid, []))
        if words_count != 25:
            issues["B5_word_count"].append(f'{label} слов: {words_count}')
    return issues


def check_rarity_spread(sets, words):
    issues = defaultdict(list)
    by_set = defaultdict(Counter)
    for w in words:
        if w.get("setId") and w.get("rarity") and w["setId"] != 0:
            if w["rarity"] in RARITY_LEVEL:
                by_set[w["setId"]][w["rarity"]] += 1
    for sid, counter in by_set.items():
        levels = [RARITY_LEVEL[r] for r in counter if counter[r] > 0]
        if levels and max(levels) - min(levels) + 1 > 2:
            info = sets.get(sid, {"file": "?"})
            issues["D1_spread"].append(
                f'{info["file"]} set {sid}: {dict(counter)}'
            )
    return issues


def check_topic_dupes(sets, words):
    """Дубли original в одной (lang, topic) группе."""
    issues = defaultdict(list)
    buckets = defaultdict(list)  # (lang, topic, original) → [(set_id, file)]
    for w in words:
        if w.get("setId") == 0: continue
        set_info = sets.get(w.get("setId"))
        if not set_info: continue
        lang = set_info.get("languagePair")
        topic = set_info.get("topic")
        orig = w.get("original")
        if lang and topic and orig:
            buckets[(lang, topic, orig)].append((w["setId"], w["file"]))
    for key, locs in buckets.items():
        if len(locs) > 1:
            locs_str = ", ".join(f'set {s} [{f}]' for s, f in locs)
            issues["C1_topic_dupe"].append(f'"{key[2]}" lang={key[0]} topic={key[1]}: {locs_str}')
    return issues


def main():
    sets, words = collect()
    print(f"Наборов: {len(sets)}, слов (WordEntity): {len(words)}\n")
    all_issues = {}
    all_issues.update(check_words(sets, words))
    all_issues.update(check_sets(sets, words))
    all_issues.update(check_rarity_spread(sets, words))
    all_issues.update(check_topic_dupes(sets, words))

    if not all_issues:
        print("✅ Чисто по всем проверкам.")
        return

    summary = []
    with open("deep_audit.txt", "w", encoding="utf-8") as f:
        for code in sorted(all_issues):
            items = all_issues[code]
            summary.append((code, len(items)))
            f.write(f"=== {code} ({len(items)}) ===\n")
            for msg in items[:50]:
                f.write(f"  {msg}\n")
            if len(items) > 50:
                f.write(f"  ... ещё {len(items) - 50}\n")
            f.write("\n")

    print("Сводка:")
    for code, n in summary:
        print(f"  {code}: {n}")
    print("\nПодробности: deep_audit.txt")


if __name__ == "__main__":
    sys.stdout.reconfigure(encoding="utf-8")
    main()
