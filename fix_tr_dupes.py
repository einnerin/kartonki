"""Уточняет translation у английских слов, у которых перевод совпадает в одном наборе."""
import re
import sys

# (word_id, original, new_translation)
FIXES = [
    (4402, "cite", "цитировать"),
    (4711, "rephrase", "переформулировать"),
    (4714, "paraphrase", "пересказать своими словами"),
    (5002, "nevertheless", "тем не менее"),
    (5007, "nonetheless", "вместе с тем"),
    (5006, "consequently", "следовательно"),
    (5023, "hence", "отсюда / поэтому"),
    (5008, "although", "хотя"),
    (5021, "albeit", "несмотря на то что"),
    (5424, "jeopardy", "опасность / риск"),
    (5918, "postulate", "постулировать"),
    (5919, "posit", "предполагать / утверждать"),
    (6118, "arbitration", "арбитраж (разрешение спора)"),
    (6123, "arbitrage", "арбитраж (финансовый)"),
    (7122, "prudent", "благоразумный"),
    (7125, "judicious", "здравомыслящий"),
    (7213, "streamline", "упорядочивать / упрощать"),
    (7223, "optimise", "оптимизировать"),
    (7301, "assess", "оценивать"),
    (7320, "appraise", "давать оценку / экспертировать"),
    (8303, "disseminate", "распространять (идеи, информацию)"),
    (8314, "propagate", "распространять / размножать"),
]

PATH = "app/src/main/java/com/example/kartonki/data/WordDataEnglish.kt"


def main():
    content = open(PATH, encoding="utf-8").read()
    n = 0
    for wid, orig, new_tr in FIXES:
        pat = rf'(id\s*=\s*{wid},[^)]*?original\s*=\s*"{re.escape(orig)}"[^)]*?translation\s*=\s*")[^"]*(")'
        new_content, count = re.subn(pat, rf'\g<1>{new_tr}\g<2>', content, count=1, flags=re.DOTALL)
        if count:
            content = new_content
            n += 1
            print(f'  {wid} {orig} → "{new_tr}"')
        else:
            print(f'  ! не нашёл id={wid} original={orig}')
    open(PATH, "w", encoding="utf-8").write(content)
    print(f"\nОбновлено: {n}")


if __name__ == "__main__":
    sys.stdout.reconfigure(encoding="utf-8")
    main()
