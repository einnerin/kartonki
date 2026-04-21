"""Находит все однокоренные пары слов внутри одного набора."""
import re
import glob
import sys
from collections import defaultdict


def parse(content, kind):
    out = []
    for m in re.finditer(rf"{kind}\s*\(", content):
        i = m.end(); depth = 1; in_str = False; esc = False
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
                        out.append(content[m.end():i]); break
            i += 1
    return out


def normalize(w):
    """Убираем огласовки иврита и приводим к нижнему регистру."""
    out = []
    for c in w:
        code = ord(c)
        # Hebrew niqqud range
        if 0x0591 <= code <= 0x05C7 and c not in set("אבגדהוזחטיכלמנסעפצקרשתךםןףץ"):
            continue
        out.append(c)
    return ''.join(out).lower().strip()


def is_derivative(w1, w2):
    n1 = normalize(w1).split()[0] if w1 else ""
    n2 = normalize(w2).split()[0] if w2 else ""
    if not n1 or not n2:
        return False
    if n1 == n2 or len(n1) < 3 or len(n2) < 3:
        return False
    plen = 0
    for a, b in zip(n1, n2):
        if a == b:
            plen += 1
        else:
            break
    min_len = min(len(n1), len(n2))
    if plen >= 3 and plen >= min_len * 0.75:
        return True
    suffixes = ["ing", "ed", "er", "tion", "sion", "ness", "ment",
                "ity", "ive", "ful", "less", "able", "ible", "ly", "al"]
    for suffix in suffixes:
        for longer, shorter in [(n1, n2), (n2, n1)]:
            if longer.endswith(suffix) and len(longer) - len(suffix) >= 3:
                stem = longer[:-len(suffix)]
                if shorter == stem or shorter.startswith(stem):
                    return True
    return False


def main():
    by_set = defaultdict(list)
    for path in sorted(glob.glob("app/src/main/java/com/example/kartonki/data/WordData*.kt")):
        content = open(path, encoding="utf-8").read()
        for body in parse(content, "WordEntity"):
            sid = re.search(r"\bsetId\s*=\s*(\d+)", body)
            orig = re.search(r'\boriginal\s*=\s*"((?:\\"|[^"])*)"', body)
            wid = re.search(r"\bid\s*=\s*(\d+)", body)
            if sid and orig and wid:
                by_set[(int(sid.group(1)), path.split("\\")[-1])].append(
                    (int(wid.group(1)), orig.group(1)))

    total_pairs = 0
    with open("same_roots.txt", "w", encoding="utf-8") as f:
        for (sid, fname), words in sorted(by_set.items()):
            if sid == 0:
                continue
            pairs = []
            for i in range(len(words)):
                for j in range(i + 1, len(words)):
                    if is_derivative(words[i][1], words[j][1]):
                        pairs.append((words[i], words[j]))
            if pairs:
                f.write(f"Set {sid} [{fname}]:\n")
                for (id1, o1), (id2, o2) in pairs:
                    f.write(f"  id={id1} '{o1}'  ←→  id={id2} '{o2}'\n")
                    total_pairs += 1
                f.write("\n")
    print(f"Всего однокоренных пар: {total_pairs}")


if __name__ == "__main__":
    sys.stdout.reconfigure(encoding="utf-8")
    main()
