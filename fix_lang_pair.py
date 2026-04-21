"""Добавляет languagePair = 'en-ru' всем английским наборам без этого поля."""
import re
import glob
import sys


def parse_sets(content):
    out = []
    for m in re.finditer(r"WordSetEntity\s*\(", content):
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


def main():
    total = 0
    for path in sorted(glob.glob("app/src/main/java/com/example/kartonki/data/WordDataEnglish*.kt")):
        content = open(path, encoding="utf-8").read()
        blocks = parse_sets(content)
        changed = 0
        for start, end, body in reversed(blocks):
            if "languagePair" in body:
                continue
            # Вставляем перед закрывающей скобкой
            trimmed = body.rstrip().rstrip(",").rstrip()
            new_body = f'{trimmed}, languagePair = "en-ru"'
            content = content[:start] + f"WordSetEntity({new_body})" + content[end:]
            changed += 1
        if changed:
            open(path, "w", encoding="utf-8").write(content)
            total += changed
            print(f"{path.split(chr(92))[-1]}: +{changed} languagePair")
    print(f"\nИтого: {total}")


if __name__ == "__main__":
    sys.stdout.reconfigure(encoding="utf-8")
    main()
