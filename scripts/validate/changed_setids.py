#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Определяет список setIds, реально изменённых в staged-файле.

Алгоритм:
1. Берём unified=0 diff от git diff --cached <file>
2. Для каждого hunk извлекаем диапазон изменённых строк (в новой версии)
3. В итоговом файле (HEAD + staged) находим все WordEntity-блоки и их setIds
4. Пересекаем: если диапазон изменённых строк пересекается с блоком WordEntity — его setId идёт в результат

Использование:
    python scripts/validate/changed_setids.py <path/to/WordData*.kt>

Выведет список setId по одному на строку (sorted unique).

Если файл изменился только вне WordEntity-блоков (импорты, комментарии, заголовок) —
возвращает пусто.
"""
import sys
import re
import subprocess
import io
from pathlib import Path

# Ensure LF output on Windows (Python по умолчанию \r\n в text mode)
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding="utf-8", newline="\n")


def staged_hunk_ranges(file_path: str):
    """
    Возвращает list[(new_start, new_end)] — диапазоны изменённых строк в новой (staged) версии файла.
    """
    try:
        diff = subprocess.check_output(
            ["git", "diff", "--cached", "--unified=0", "--", file_path],
            text=True,
            encoding="utf-8",
            errors="replace",
            stderr=subprocess.DEVNULL,
        )
    except subprocess.CalledProcessError:
        return []
    ranges = []
    # @@ -old_start,old_count +new_start,new_count @@
    hunk_re = re.compile(r"^@@ -\d+(?:,\d+)? \+(\d+)(?:,(\d+))? @@", re.MULTILINE)
    for m in hunk_re.finditer(diff):
        new_start = int(m.group(1))
        new_count = int(m.group(2)) if m.group(2) is not None else 1
        if new_count == 0:
            # Удаление — для нас это тоже изменение "вокруг" этой позиции
            ranges.append((new_start, new_start))
        else:
            ranges.append((new_start, new_start + new_count - 1))
    return ranges


def staged_file_content(file_path: str) -> str:
    """Возвращает содержимое файла как оно будет после коммита (staged version)."""
    try:
        return subprocess.check_output(
            ["git", "show", f":{file_path}"],
            text=True,
            encoding="utf-8",
            errors="replace",
        )
    except subprocess.CalledProcessError:
        # Файл новый? Тогда берём с диска
        try:
            return Path(file_path).read_text(encoding="utf-8", errors="replace")
        except Exception:
            return ""


def wordentity_blocks(content: str):
    """
    Возвращает list[(line_start, line_end, set_id)] для каждого WordEntity-блока в content.

    Блок начинается со `WordEntity(` и заканчивается на ближайшем `),` или `)` того же уровня
    (упрощённо — первая скобка, совпадающая по балансу).
    """
    lines = content.split("\n")
    blocks = []
    i = 0
    n = len(lines)
    while i < n:
        line = lines[i]
        if "WordEntity(" in line:
            start = i + 1  # line numbers 1-based
            # Ищем конец блока — балансируем скобки
            depth = 0
            started = False
            end = start
            j = i
            set_id = None
            while j < n:
                for ch in lines[j]:
                    if ch == "(":
                        depth += 1
                        started = True
                    elif ch == ")":
                        depth -= 1
                        if started and depth == 0:
                            end = j + 1
                            break
                if started and depth == 0:
                    break
                j += 1
            else:
                # не закрылось — берём до конца файла
                end = n
            # Ищем setId внутри блока
            block_text = "\n".join(lines[i:end])
            m = re.search(r"\bsetId\s*=\s*(\d+)", block_text)
            if m:
                set_id = int(m.group(1))
            blocks.append((start, end, set_id))
            i = end
        else:
            i += 1
    return blocks


def main():
    if len(sys.argv) != 2:
        print("Usage: changed_setids.py <WordData*.kt>", file=sys.stderr)
        sys.exit(2)
    file_path = sys.argv[1]
    hunks = staged_hunk_ranges(file_path)
    if not hunks:
        return 0
    content = staged_file_content(file_path)
    if not content:
        return 0
    blocks = wordentity_blocks(content)
    changed = set()
    for (hstart, hend) in hunks:
        for (bstart, bend, sid) in blocks:
            if sid is None:
                continue
            # Пересечение отрезков
            if not (hend < bstart or hstart > bend):
                changed.add(sid)
    for sid in sorted(changed):
        print(sid)
    return 0


if __name__ == "__main__":
    sys.exit(main())
