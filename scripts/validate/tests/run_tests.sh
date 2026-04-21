#!/usr/bin/env bash
# Regression test for all 7 validators.
# Uses KARTONKI_DATA_DIR to point _parser at fixtures in this directory.
#
# Expects:
#   good_set (setId=9991) — every validator exits 0
#   bad_set  (setId=9992) — every validator exits 1 (each fixture word violates
#                           one specific rule)
set -u
cd "$(git rev-parse --show-toplevel 2>/dev/null || pwd)"

export KARTONKI_DATA_DIR=scripts/validate/tests

GOOD=9991
BAD=9992
HERE="scripts/validate"

CHECKS=(
  "validate_fields_filled"
  "validate_pos_values"
  "validate_group_sizes"
  "validate_text_lengths"
  "validate_rarity_spread"
  "validate_no_duplicates"
  "validate_no_cognates"
)

PASS=0
FAIL=0
REPORT=()

check_result() {
  local validator="$1"
  local set_id="$2"
  local expected="$3"  # 0 = should pass, 1 = should fail
  local label="$4"
  bash "$HERE/${validator}.sh" "$set_id" > /dev/null 2>&1
  local actual=$?
  if [ "$actual" = "$expected" ]; then
    PASS=$((PASS + 1))
    REPORT+=("✅ $label: $validator на setId=$set_id вернул $actual (ожидалось $expected)")
  else
    FAIL=$((FAIL + 1))
    REPORT+=("❌ $label: $validator на setId=$set_id вернул $actual, ожидалось $expected")
  fi
}

echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo "Regression tests для валидаторов"
echo "KARTONKI_DATA_DIR=$KARTONKI_DATA_DIR"
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"

# Good fixture должен проходить все проверки (exit 0)
echo ""
echo "── GOOD FIXTURE (setId=$GOOD): каждый валидатор должен вернуть 0 ──"
for c in "${CHECKS[@]}"; do
  check_result "$c" "$GOOD" "0" "good"
done

# Bad fixture должен валить каждую проверку (exit 1)
echo ""
echo "── BAD FIXTURE (setId=$BAD): каждый валидатор должен вернуть 1 ──"
for c in "${CHECKS[@]}"; do
  check_result "$c" "$BAD" "1" "bad"
done

echo ""
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
for line in "${REPORT[@]}"; do
  echo "$line"
done
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo "Итог: $PASS прошли, $FAIL не прошли"
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
[ $FAIL -eq 0 ]
