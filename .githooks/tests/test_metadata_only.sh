#!/usr/bin/env bash
# Unit tests for METADATA_ONLY_COMMIT escape hatch.
#
# Three scenarios:
#   1. Pure isFillInBlankSafe injection diff → check_metadata_only_diff.py exit 0
#   2. Diff with definition change + marker → check_metadata_only_diff.py exit 1
#   3. METADATA_ONLY_COMMIT=1 without LARGE_COMMIT_OK=1 → hook-level flag guard
#      rejects. Tested by replicating the guard condition in isolation (the
#      full hook needs a git repo+staged state and is out of scope here).
set -u
cd "$(git rev-parse --show-toplevel)" || exit 1

TEST_DIR=$(mktemp -d)
trap "rm -rf $TEST_DIR" EXIT

PASS=0
FAIL=0

report_pass() {
  PASS=$((PASS + 1))
  echo "✅ $1"
}
report_fail() {
  FAIL=$((FAIL + 1))
  echo "❌ $1"
}

echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo "METADATA_ONLY_COMMIT tests"
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"

# ── Test 1: pure marker-only diff → accepted ───────────────────────────────

cat > "$TEST_DIR/diff_ok.txt" <<'EOF'
diff --git a/app/src/main/java/com/example/kartonki/data/WordDataEnglish.kt b/app/src/main/java/com/example/kartonki/data/WordDataEnglish.kt
index 1072c73..300f22b 100644
--- a/app/src/main/java/com/example/kartonki/data/WordDataEnglish.kt
+++ b/app/src/main/java/com/example/kartonki/data/WordDataEnglish.kt
@@ -103,1 +103,1 @@
-            exampleNative = "Наш dog каждый вечер встречает меня у двери и виляет хвостом."),
+            exampleNative = "Наш dog каждый вечер встречает меня у двери и виляет хвостом.", isFillInBlankSafe = false),
@@ -108,1 +108,1 @@
-            exampleNative = "Соседская cat целыми днями дремлет на подоконнике под солнцем."),
+            exampleNative = "Соседская cat целыми днями дремлет на подоконнике под солнцем.", isFillInBlankSafe = false),
diff --git a/app/src/main/java/com/example/kartonki/data/WordDataEnglishExpanded.kt b/app/src/main/java/com/example/kartonki/data/WordDataEnglishExpanded.kt
index abc..def 100644
--- a/app/src/main/java/com/example/kartonki/data/WordDataEnglishExpanded.kt
+++ b/app/src/main/java/com/example/kartonki/data/WordDataEnglishExpanded.kt
@@ -80,1 +80,1 @@
-        ),
+         isFillInBlankSafe = false),
EOF

if python scripts/validate/check_metadata_only_diff.py --diff-file "$TEST_DIR/diff_ok.txt" > "$TEST_DIR/out1.txt" 2>&1; then
  report_pass "Тест 1: чистый marker-only diff (inline + trailing-comma) принят"
else
  report_fail "Тест 1: должен был пройти, но check упал"
  cat "$TEST_DIR/out1.txt" | sed 's/^/    /'
fi

# ── Test 2: diff with definition change + marker → rejected ────────────────

cat > "$TEST_DIR/diff_bad.txt" <<'EOF'
diff --git a/app/src/main/java/com/example/kartonki/data/WordDataEnglish.kt b/app/src/main/java/com/example/kartonki/data/WordDataEnglish.kt
index 1072c73..300f22b 100644
--- a/app/src/main/java/com/example/kartonki/data/WordDataEnglish.kt
+++ b/app/src/main/java/com/example/kartonki/data/WordDataEnglish.kt
@@ -100,1 +100,1 @@
-            definition = "A friendly four-legged pet that barks and wags its tail.",
+            definition = "A friendly dog that barks.", isFillInBlankSafe = false,
EOF

if python scripts/validate/check_metadata_only_diff.py --diff-file "$TEST_DIR/diff_bad.txt" > "$TEST_DIR/out2.txt" 2>&1; then
  report_fail "Тест 2: должен был заблокировать definition-правку, но check прошёл"
  cat "$TEST_DIR/out2.txt" | sed 's/^/    /'
else
  report_pass "Тест 2: правка definition + marker корректно заблокирована"
fi

# ── Test 3: METADATA_ONLY_COMMIT=1 without LARGE_COMMIT_OK=1 → hook guard ──
# Replicates the bash guard from .githooks/pre-commit block 2, тестируем его
# в изоляции (без запуска целого хука, который требует git-репо в состоянии
# staged-commit).

check_flags() {
  local md="${1:-}" lc="${2:-}"
  if [ -n "$md" ] && [ -z "$lc" ]; then
    return 1
  fi
  return 0
}

if ! check_flags "1" ""; then
  report_pass "Тест 3: METADATA_ONLY_COMMIT=1 без LARGE_COMMIT_OK=1 отклонён"
else
  report_fail "Тест 3: guard должен был отклонить одиночный флаг"
fi

if check_flags "1" "1"; then
  report_pass "Тест 3b: оба флага одновременно приняты guard'ом"
else
  report_fail "Тест 3b: оба флага не прошли guard"
fi

if check_flags "" ""; then
  report_pass "Тест 3c: без флагов guard ничего не блокирует"
else
  report_fail "Тест 3c: guard сработал без причины"
fi

echo ""
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo "Итог: $PASS прошли, $FAIL не прошли"
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
[ $FAIL -eq 0 ]
