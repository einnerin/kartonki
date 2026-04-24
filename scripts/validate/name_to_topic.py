#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Финальная упрощение имён (утверждено 2026-04-24):
    name = "{topic}"           -- просто тема
    description = подтема/детали

То есть любое текущее name вида "{topic}: ..." превращается в "{topic}".
description остаётся как есть.
"""
import re, sys, io, glob, argparse
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')


def process(apply: bool):
    files = {}
    for path in glob.glob('app/src/main/java/com/example/kartonki/data/WordData*.kt'):
        content = Path(path).read_text(encoding='utf-8')
        for m in re.finditer(r'WordSetEntity\(([^)]+)\)', content, re.DOTALL):
            body = m.group(1)
            id_m = re.search(r'\bid\s*=\s*(\d+)', body)
            name_m = re.search(r'name\s*=\s*"([^"]+)"', body)
            topic_m = re.search(r'topic\s*=\s*"([^"]+)"', body)
            if not (id_m and name_m and topic_m):
                continue
            sid = int(id_m.group(1))
            old_name = name_m.group(1)
            topic = topic_m.group(1)
            if old_name == topic:
                continue  # уже ок
            files.setdefault(path, []).append((sid, old_name, topic))

    total = sum(len(v) for v in files.values())
    print(f"Правок: {total}")
    shown = 0
    for path, lst in files.items():
        for sid, old, new in lst[:3]:
            print(f"  [{sid}] '{old}' → '{new}'")
            shown += 1
            if shown >= 15: break
        if shown >= 15: break

    if not apply:
        print("\nDry run. Запусти с --apply чтобы применить.")
        return 0

    for path, lst in files.items():
        content = Path(path).read_text(encoding='utf-8')
        for sid, old_name, topic in lst:
            pattern = re.compile(
                rf'(id\s*=\s*{sid}\b[^)]*?name\s*=\s*")' + re.escape(old_name) + r'(")',
                re.DOTALL
            )
            content, n = pattern.subn(r'\1' + topic + r'\2', content, count=1)
            if n == 0:
                print(f"  WARN: не нашёл для id={sid}: '{old_name}'")
        Path(path).write_text(content, encoding='utf-8', newline='\n')
    print(f"Применено. Файлов: {len(files)}")
    return 0


def main():
    ap = argparse.ArgumentParser(description=__doc__)
    ap.add_argument('--apply', action='store_true')
    args = ap.parse_args()
    return process(args.apply)


if __name__ == '__main__':
    sys.exit(main())
