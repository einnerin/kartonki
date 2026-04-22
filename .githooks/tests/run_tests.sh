#!/usr/bin/env bash
# Тесты для scripts/validate/changed_setids.py — корректность детекции
# реально изменённых setIds по diff.
#
# Запуск: bash .githooks/tests/run_tests.sh
#
# Создаёт временную git-worktree, модифицирует fixture-файл, stage'ит
# изменения и проверяет вывод скрипта.

set -u
cd "$(git rev-parse --show-toplevel)" || exit 1

PASS=0
FAIL=0
FAILS=()

run_test() {
  local name="$1"
  local expected="$2"
  local actual="$3"
  if [ "$expected" = "$actual" ]; then
    PASS=$((PASS+1))
    echo "  ✅ $name"
  else
    FAIL=$((FAIL+1))
    FAILS+=("$name")
    echo "  ❌ $name"
    echo "     expected: [$expected]"
    echo "     actual:   [$actual]"
  fi
}

# Создаём временный git-repo для изоляции тестов
TMPDIR=$(mktemp -d)
cleanup() { rm -rf "$TMPDIR"; }
trap cleanup EXIT

cd "$TMPDIR"
git init -q
git config user.email test@test
git config user.name test

# Готовим базовый файл с тремя WordEntity разных setId
mkdir -p app/src/main/java/com/example/kartonki/data
FIXTURE="app/src/main/java/com/example/kartonki/data/WordDataTest.kt"
cat > "$FIXTURE" <<'EOF'
package com.example.kartonki.data

import com.example.kartonki.data.db.entity.WordEntity

// Header comment, should not trigger validation.

object WordDataTest {
    val words = listOf(
        WordEntity(
            id = 101,
            original = "apple",
            translation = "яблоко",
            setId = 10,
            rarity = "COMMON",
        ),
        WordEntity(
            id = 201,
            original = "banana",
            translation = "банан",
            setId = 20,
            rarity = "COMMON",
        ),
        WordEntity(
            id = 301,
            original = "cherry",
            translation = "вишня",
            setId = 30,
            rarity = "COMMON",
        ),
    )
}
EOF
git add "$FIXTURE" >/dev/null
git commit -q -m "baseline"

# Подключаем скрипт из основного проекта
SCRIPT="$OLDPWD/scripts/validate/changed_setids.py"

echo "Test 1: Edit one word in setId 10 (translation change)"
sed -i 's/"яблоко"/"яблочко"/' "$FIXTURE"
git add "$FIXTURE"
ACTUAL=$(python "$SCRIPT" "$FIXTURE" 2>/dev/null | tr -d '\r' | tr '\n' ' ' | sed 's/[[:space:]]*$//')
run_test "one setId modified" "10" "$ACTUAL"
git reset -q HEAD "$FIXTURE" >/dev/null
git checkout -q "$FIXTURE"

echo "Test 2: Edit words in setId 20 and setId 30"
sed -i 's/"банан"/"банаша"/; s/"вишня"/"вишенка"/' "$FIXTURE"
git add "$FIXTURE"
ACTUAL=$(python "$SCRIPT" "$FIXTURE" 2>/dev/null | tr -d '\r' | tr '\n' ' ' | sed 's/[[:space:]]*$//')
run_test "two setIds modified" "20 30" "$ACTUAL"
git reset -q HEAD "$FIXTURE" >/dev/null
git checkout -q "$FIXTURE"

echo "Test 3: Edit only header comment (no setId change)"
sed -i 's/Header comment/Updated header/' "$FIXTURE"
git add "$FIXTURE"
ACTUAL=$(python "$SCRIPT" "$FIXTURE" 2>/dev/null | tr -d '\r' | tr '\n' ' ' | sed 's/[[:space:]]*$//')
run_test "header-only edit returns empty" "" "$ACTUAL"
git reset -q HEAD "$FIXTURE" >/dev/null
git checkout -q "$FIXTURE"

echo "Test 4: Edit import (no setId change)"
sed -i '/^import /a\
import com.example.kartonki.data.db.entity.AchievementEntity' "$FIXTURE"
git add "$FIXTURE"
ACTUAL=$(python "$SCRIPT" "$FIXTURE" 2>/dev/null | tr -d '\r' | tr '\n' ' ' | sed 's/[[:space:]]*$//')
run_test "import-only edit returns empty" "" "$ACTUAL"
git reset -q HEAD "$FIXTURE" >/dev/null
git checkout -q "$FIXTURE"

echo ""
echo "════════════════════════════════════════════"
echo "  passed: $PASS"
echo "  failed: $FAIL"
echo "════════════════════════════════════════════"
if [ $FAIL -gt 0 ]; then
  exit 1
fi
exit 0
