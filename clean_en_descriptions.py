"""Убирает CEFR-пометки (A1/A2/B1/B2/C1/C2) из description английских наборов."""
import re
import glob
import sys


def main():
    total = 0
    for path in sorted(glob.glob("app/src/main/java/com/example/kartonki/data/WordDataEnglish*.kt")):
        content = open(path, encoding="utf-8").read()
        new_content = content
        # Шаблоны CEFR которые надо убрать из description
        # примеры: "... C1", "... B2", "... (A1)", "... A1-B1"
        patterns = [
            r"\s+\([ABC][12]\)",                          # (C1), (A2)
            r"\s+[ABC][12][-/][ABC][12]",                  # A2-B1, A1/A2, B2/C1
            r"\s+[ABC][12](?=\"|\s*,)",                    # " C1" перед концом
            r",\s*[ABC][12](?=\"|\s*,)",                   # ", C1"
        ]
        for p in patterns:
            new_content = re.sub(
                r'(description\s*=\s*"[^"]*?)' + p + r'([^"]*")',
                r"\1\2",
                new_content,
            )
        if new_content != content:
            changes = len(re.findall(r'description\s*=\s*"[^"]*[ABC][12]', content)) - \
                      len(re.findall(r'description\s*=\s*"[^"]*[ABC][12]', new_content))
            total += changes
            open(path, "w", encoding="utf-8").write(new_content)
            print(f"{path.split(chr(92))[-1]}: {changes} описаний почищено")
    print(f"\nИтого: {total}")


if __name__ == "__main__":
    sys.stdout.reconfigure(encoding="utf-8")
    main()
