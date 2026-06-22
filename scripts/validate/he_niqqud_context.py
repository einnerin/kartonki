#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""Context-aware adjudication of he_niqqud_check flags.

Re-vocalizes each flagged headword INSIDE its `example` sentence. Context kills
homograph/construct false positives (Nakdan in isolation gives the absolute form
or the wrong reading; in a sentence it reads correctly).

Verdict per flag:
  FP_CONTEXT — in-context vocalization == ours    -> our form is correct, drop
  REAL       — in-context != ours (single word)   -> real error, fix to in-context
  AMBIG      — word not found in example / phrase  -> human/agent decision

Usage: python scripts/validate/he_niqqud_context.py <setId> [setId ...]
"""
import json, sys
sys.path.insert(0, "scripts/validate")
sys.stdout.reconfigure(encoding="utf-8")
import he_niqqud_check as N

def ctx_vocalization(example, head_bare):
    if not example: return None
    res = N.nakdan_raw(example)
    hb = head_bare.replace(" ", "")
    for tk in [w for w in res if not w.get("sep")]:
        opts = tk.get("options", [])
        if not opts: continue
        cb = N.strip(N.norm(opts[0])).replace(" ", "")
        if cb == hb or (cb.endswith(hb) and len(cb) - len(hb) <= 2):
            return N.norm(opts[0])
    return None

def run(sid):
    print(f"=== set {sid} ===")
    real = []
    for w in N.words_for_set_id(sid):
        o = w.get("original", "")
        if not o or not any('א' <= c <= 'ת' for c in o): continue
        bare = N.strip(o).strip()
        if len(bare.replace(" ", "")) < 2: continue
        try: iso = N.check(bare, o)
        except Exception: iso = None
        if not iso: continue
        if N.LOAN.search(N.nfc(o)):
            print(f"  {w['id']}: «{o}» [loan?] изолир→«{iso}»  (skip)"); continue
        head_first = bare.split()[0] if " " in bare else bare
        ctx = ctx_vocalization(w.get("example", ""), head_first)
        ours_n = N.norm(o); ours_first = ours_n.split()[0] if " " in ours_n else ours_n
        tr = w.get("translation", "")
        # prefix-tolerant: in a sentence the word may carry ה/ב/ל/מ/כ/ו/ש; if the
        # context vocalization ENDS WITH our form, the word itself is confirmed.
        confirmed = ctx is not None and (ctx == ours_first or ctx.endswith(ours_first))
        if ctx is None:
            verdict = "AMBIG (не нашёл в примере)"
        elif confirmed:
            verdict = "FP_CONTEXT (наше верно)"
        elif " " not in bare:
            real.append((w["id"], o, ctx, tr)); verdict = f"REAL → «{ctx}»"
        else:
            verdict = f"AMBIG (контекст «{ctx}»)"
        print(f"  {w['id']} [{tr}]: наше «{o}» | изолир «{iso}» | {verdict}")
    print(f"  -> REAL={len(real)}\n")
    return real

if __name__ == "__main__":
    try:
        for s in sys.argv[1:]: run(int(s))
    finally:
        json.dump(N.CACHE, open(N.CACHE_F, "w", encoding="utf-8"), ensure_ascii=False)
