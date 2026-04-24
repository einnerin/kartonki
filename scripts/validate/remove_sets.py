#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Удаляет указанные setId из WordData*.kt файлов — и WordSetEntity из list 'sets',
и все WordEntity из list 'words'. Safe: идёт по WordEntity/WordSetEntity блокам,
нагоняя закрывающую ')' через счётчик скобок.

Usage:
    python scripts/validate/remove_sets.py 1028 1029 1045 ...
"""
import sys
import re
import glob
from pathlib import Path


def find_entity_blocks(content: str, entity_name: str):
    """Возвращает список (start, end) для каждого `<entity_name>(...)` блока в контенте."""
    blocks = []
    pattern = re.compile(rf'\b{entity_name}\s*\(')
    for m in pattern.finditer(content):
        start = m.start()
        paren_start = m.end() - 1
        depth = 0
        in_str = False
        escape = False
        i = paren_start
        while i < len(content):
            c = content[i]
            if escape:
                escape = False
            elif c == '\\' and in_str:
                escape = True
            elif c == '"' and not escape:
                in_str = not in_str
            elif not in_str:
                if c == '(':
                    depth += 1
                elif c == ')':
                    depth -= 1
                    if depth == 0:
                        # Include trailing ',' and whitespace up to newline
                        j = i + 1
                        while j < len(content) and content[j] in ' \t':
                            j += 1
                        if j < len(content) and content[j] == ',':
                            j += 1
                        # Include the following newline
                        if j < len(content) and content[j] == '\n':
                            j += 1
                        blocks.append((start, j))
                        break
            i += 1
    return blocks


def get_set_id(block_text: str) -> int | None:
    # WordSetEntity uses `id = N`, WordEntity uses `setId = N`
    m = re.search(r'setId\s*=\s*(\d+)', block_text)
    if m:
        return int(m.group(1))
    m = re.search(r'id\s*=\s*(\d+)', block_text)
    return int(m.group(1)) if m else None


def is_setentity_block(block_text: str) -> bool:
    return block_text.lstrip().startswith('WordSetEntity')


def process_file(path: Path, target_ids: set[int]) -> tuple[int, int]:
    """Returns (removed_set_entities, removed_word_entities)."""
    content = path.read_text(encoding='utf-8')
    # Collect blocks (start, end, entity_type)
    all_blocks = []
    for name in ('WordSetEntity', 'WordEntity'):
        for start, end in find_entity_blocks(content, name):
            all_blocks.append((start, end, name))
    all_blocks.sort(key=lambda b: b[0])
    # Determine which to remove
    to_remove = []
    for start, end, name in all_blocks:
        block_text = content[start:end]
        if name == 'WordSetEntity':
            # WordSetEntity.id = setId
            m = re.search(r'\bid\s*=\s*(\d+)', block_text)
            sid = int(m.group(1)) if m else None
        else:
            m = re.search(r'setId\s*=\s*(\d+)', block_text)
            sid = int(m.group(1)) if m else None
        if sid in target_ids:
            to_remove.append((start, end, name))
    if not to_remove:
        return (0, 0)
    # Build new content, skipping removed blocks (in reverse order so offsets stay valid)
    pieces = []
    last = 0
    for start, end, _ in to_remove:
        pieces.append(content[last:start])
        last = end
    pieces.append(content[last:])
    new_content = ''.join(pieces)
    # Cleanup double blank lines (optional but nicer diffs)
    new_content = re.sub(r'\n\n\n+', '\n\n', new_content)
    path.write_text(new_content, encoding='utf-8', newline='\n')
    set_count = sum(1 for _, _, n in to_remove if n == 'WordSetEntity')
    word_count = sum(1 for _, _, n in to_remove if n == 'WordEntity')
    return (set_count, word_count)


def main():
    if len(sys.argv) < 2:
        print("Usage: remove_sets.py <setId> [setId ...]", file=sys.stderr)
        return 2
    target_ids = set(int(x) for x in sys.argv[1:])
    total_sets = total_words = 0
    files_touched = []
    for path in glob.glob('app/src/main/java/com/example/kartonki/data/WordData*.kt'):
        p = Path(path)
        s, w = process_file(p, target_ids)
        if s or w:
            total_sets += s
            total_words += w
            files_touched.append((p.name, s, w))
    print(f"Removed {total_sets} WordSetEntity and {total_words} WordEntity from {len(files_touched)} files:")
    for name, s, w in files_touched:
        print(f"  {name}: {s} sets, {w} words")
    print(f"Target setIds: {sorted(target_ids)}")
    return 0


if __name__ == '__main__':
    sys.exit(main())
