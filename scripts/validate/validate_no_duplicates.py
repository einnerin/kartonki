#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Validate no duplicate `original` values:
1. Within this setId (intra-set duplicates — always a bug)
2. Cross-setId within the same topic (same-topic duplicates — semantic mistake)

Cross-topic duplicates are allowed (Room UNIQUE constraint was removed).
"""
import sys
import io
import re
from collections import defaultdict
from pathlib import Path

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8', errors='replace')
sys.path.insert(0, str(Path(__file__).parent))
from _parser import ROOT, parse_words, parse_sets, words_for_set_id  # noqa: E402


def validate(set_id):
    # 1. Intra-set duplicates
    words = words_for_set_id(set_id)
    if not words:
        print(f"❌ setId={set_id}: no words found")
        return 1
    seen = defaultdict(list)
    for w in words:
        seen[w["original"]].append(w["id"])
    intra_dupes = {orig: ids for orig, ids in seen.items() if len(ids) > 1}

    # 2. Cross-setId same-topic duplicates
    # Collect topic of this setId
    set_topic = None
    set_lang = None
    for kt in sorted(ROOT.glob("WordData*.kt")):
        for s in parse_sets(kt):
            if s["id"] == set_id:
                set_topic = s["topic"]
                set_lang = s["lang"]
                break
        if set_topic is not None:
            break
    if not set_topic:
        # No topic or set not found — skip cross-set check
        topic_dupes = {}
    else:
        # Collect all words from sets with same topic + lang
        same_topic_set_ids = set()
        for kt in sorted(ROOT.glob("WordData*.kt")):
            for s in parse_sets(kt):
                if s["topic"] == set_topic and s["lang"] == set_lang and s["id"] != set_id:
                    same_topic_set_ids.add(s["id"])
        this_originals = {w["original"] for w in words}
        topic_dupes = defaultdict(list)
        for kt in sorted(ROOT.glob("WordData*.kt")):
            for w in parse_words(kt):
                if w["setId"] in same_topic_set_ids and w["original"] in this_originals:
                    topic_dupes[w["original"]].append(w["setId"])

    if intra_dupes or topic_dupes:
        print(f"❌ setId={set_id}: дубли обнаружены")
        if intra_dupes:
            print(f"    В пределах набора (критично):")
            for orig, ids in list(intra_dupes.items())[:10]:
                print(f"      «{orig}» — ids {ids}")
        if topic_dupes:
            print(f"    С другими наборами темы \"{set_topic}\":")
            for orig, sids in list(topic_dupes.items())[:10]:
                print(f"      «{orig}» — также в setIds {sids}")
        return 1
    print(f"✅ setId={set_id}: дублей не найдено "
          f"(проверено внутри набора и в теме \"{set_topic or '?'}\")")
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: validate_no_duplicates.py <setId>", file=sys.stderr)
        sys.exit(2)
    sys.exit(validate(int(sys.argv[1])))
