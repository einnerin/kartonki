#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""Niqqud ground-truth check for he-ru sets via Dicta Nakdan.

For each `original`: strip niqqud -> bare consonants -> ask Nakdan for the
academic vocalization options -> compare our (NFC-normalized) form. If ours is
NOT among Nakdan's options -> flag with Nakdan's top suggestion.

This is an ADVISORY tool, not a hard gate (see add-words SKILL §7.1a):
  - single nouns without [loan?]  -> Nakdan is almost always right -> fix to it
  - [loan?] (loanwords)           -> Nakdan unstable -> both forms ok, ignore
  - construct / idiom / homograph -> Nakdan in isolation gives wrong reading;
                                     adjudicate with he_niqqud_context.py

Cache: scripts/validate/_nakdan_cache.json (word -> Nakdan response; re-runs offline).
External service: nakdan.dicta.org.il  (public vocab words only).
Usage: python scripts/validate/he_niqqud_check.py <setId> [setId ...]
"""
import json, urllib.request, re, sys, time, unicodedata, os, glob
sys.path.insert(0, "scripts/validate")
sys.stdout.reconfigure(encoding="utf-8")
from pathlib import Path
from _parser import parse_words

NIK = re.compile(r'[֑-ׇ]')
strip = lambda s: NIK.sub('', s or '')
URL = "https://nakdan-2-0.loadbalancer.dicta.org.il/api"
CACHE_F = os.environ.get("NAKDAN_CACHE", "scripts/validate/_nakdan_cache.json")
CACHE = json.load(open(CACHE_F, encoding="utf-8")) if os.path.exists(CACHE_F) else {}
LOAN = re.compile(r"['׳״]|יזְם|זְם$|צְיָה|לוֹגְיָה|טִיב")  # loanword markers

def nfc(s): return unicodedata.normalize("NFC", s or "")
def norm(s):
    s = nfc(s).replace("|", "").replace("־", " ").replace("׳", "'").replace("״", '"')
    return re.sub(r'\s+', ' ', s).strip()

def nakdan_raw(text):
    if text in CACHE: return CACHE[text]
    body = json.dumps({"task": "nakdan", "data": text, "genre": "modern"}).encode("utf-8")
    req = urllib.request.Request(URL, data=body, headers={"Content-Type": "application/json"})
    res = json.loads(urllib.request.urlopen(req, timeout=25).read().decode("utf-8"))
    CACHE[text] = res; time.sleep(0.12)
    return res

def reconstruct(res, pick):
    out = []
    for w in res:
        if w.get("sep"): out.append(w.get("word", "")); continue
        opts = w.get("options", [])
        out.append(opts[pick] if pick < len(opts) else (opts[0] if opts else w.get("word", "")))
    return "".join(out)

def check(bare, ours):
    """Return Nakdan's suggested form if ours is wrong, else None."""
    res = nakdan_raw(bare)
    toks = [w for w in res if not w.get("sep")]
    if not toks: return None
    our_n = norm(ours)
    if len(toks) == 1:
        opts = toks[0].get("options", [])
        if not opts: return None
        if our_n in [norm(o) for o in opts]: return None
        return opts[0]
    for pick in range(3):
        if norm(reconstruct(res, pick)) == our_n: return None
    return norm(reconstruct(res, 0))

def words_for_set_id(sid):
    out = []
    for f in glob.glob("app/src/main/java/com/example/kartonki/data/WordDataHebrew*.kt"):
        for w in parse_words(Path(f)):
            if w["setId"] == sid: out.append(w)
    return out

def run(sid):
    flagged = []
    for w in words_for_set_id(sid):
        o = w.get("original", "")
        if not o or not any('א' <= c <= 'ת' for c in o): continue
        bare = strip(o).strip()
        if len(bare.replace(" ", "")) < 2: continue
        try: sug = check(bare, o)
        except Exception as e: print(f"  ERR {w['id']}: {e}"); continue
        if sug:
            loan = "  [loan?]" if LOAN.search(nfc(o)) else ""
            flagged.append((w["id"], o, sug, bool(loan)))
            print(f"  {w['id']} [{w.get('translation','')}]: «{o}» → накдан «{sug}»{loan}")
    real = [f for f in flagged if not f[3]]
    print(f"=== set {sid}: {len(flagged)} кандидатов ({len(real)} не-заимствования) ===\n")
    return flagged

if __name__ == "__main__":
    try:
        for s in sys.argv[1:]: run(int(s))
    finally:
        json.dump(CACHE, open(CACHE_F, "w", encoding="utf-8"), ensure_ascii=False)
