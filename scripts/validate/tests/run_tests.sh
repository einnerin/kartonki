#!/usr/bin/env bash
# Regression test for 19 hard-блок-валидаторов (из 21 в validate_all.sh).
# Исключены validate_group_sizes и validate_no_cognates — оба advisory-only
# (всегда exit 0, см. комментарии в их .py файлах).
#
# Uses KARTONKI_DATA_DIR to point _parser at fixtures in this directory,
# and KARTONKI_HASHES_FILE to point fill-in-blank fresh validator at a stale
# test hash file.
#
# Fixtures:
#   GOOD = 9991 (en-ru) — every validator must exit 0
#   BAD_EN = 9992 — en-ru core violations
#   BAD_HE = 9993 — he-ru specific (IPA translit, mixed-script, blank ambiguity)
#   BAD_MONOTONE = 9994 — 11 examples all starting "Every test ..."
#
# Per-validator: assigns a specific bad set the validator is expected to fail on
# (since Hebrew validators skip non-Hebrew, example_variety needs ≥10 examples,
# fillinblank_fresh needs an entry in pipeline_hashes.json).
set -u
cd "$(git rev-parse --show-toplevel 2>/dev/null || pwd)"

export KARTONKI_DATA_DIR=scripts/validate/tests
export KARTONKI_HASHES_FILE="$PWD/scripts/validate/tests/pipeline_hashes_test.json"

GOOD=9991
BAD_EN=9992
BAD_HE=9993
BAD_MONOTONE=9994
HERE="scripts/validate"

# (validator_name, bad_setId) — good_setId is always 9991.
# Total: 21 validators.
TESTS=(
  # ── Hard-блок (en-ru, fail-able) ───────────────────────────────────────────
  "validate_fields_filled $BAD_EN"
  "validate_pos_values $BAD_EN"
  "validate_text_lengths $BAD_EN"
  "validate_rarity_spread $BAD_EN"
  "validate_no_duplicates $BAD_EN"
  "validate_blank_ambiguity $BAD_EN"
  "validate_no_headword_in_def $BAD_EN"
  "validate_no_translation_in_defnative $BAD_EN"
  "validate_text_terminators $BAD_EN"
  "validate_original_in_example $BAD_EN"
  "validate_original_strict_in_example $BAD_EN"
  "validate_no_foreign_in_examplenative $BAD_EN"
  "validate_no_clerical $BAD_EN"
  "validate_no_mixed_script_in_words $BAD_EN"
  "validate_fillinblank_exclusions_fresh $BAD_EN"
  # ── Hebrew-specific (need he-ru fixture) ───────────────────────────────────
  "validate_hebrew_transliteration_format $BAD_HE"
  "validate_blank_ambiguity_hebrew $BAD_HE"
  "validate_no_foreign_script_in_original $BAD_HE"
  # ── Monotone-examples (needs ≥10 examples with same prefix) ────────────────
  "validate_example_variety $BAD_MONOTONE"

  # ── ИСКЛЮЧЕНЫ из регрессии (advisory-only, всегда exit 0): ─────────────────
  #   validate_group_sizes — после Phase 2 эксперимента (2026-04-23) переведён
  #     в WARN-only: bulk-regrouping имел каскадные побочки на blank_ambiguity,
  #     не оправдывало pain. group_sizes печатает warning, но не блокирует.
  #   validate_no_cognates — heuristic с известными FP (особенно Hebrew, где
  #     стем находит сам себя). Warning-only пока эвристика не уточнена.
  # Оба остаются в validate_all.sh для информативного output, но не могут
  # быть проверены через bad-fixture (они никогда не возвращают 1).
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
echo "Regression tests для 21 валидатора"
echo "KARTONKI_DATA_DIR=$KARTONKI_DATA_DIR"
echo "KARTONKI_HASHES_FILE=$KARTONKI_HASHES_FILE"
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"

# Good fixture: каждый валидатор должен пройти (exit 0)
echo ""
echo "── GOOD FIXTURE (setId=$GOOD): каждый валидатор должен вернуть 0 ──"
for t in "${TESTS[@]}"; do
  validator=$(echo "$t" | awk '{print $1}')
  check_result "$validator" "$GOOD" "0" "good"
done

# Bad fixtures: каждый валидатор должен заблокировать СВОЙ bad-setId (exit 1)
echo ""
echo "── BAD FIXTURES: каждый валидатор должен вернуть 1 на своём bad-setId ──"
for t in "${TESTS[@]}"; do
  validator=$(echo "$t" | awk '{print $1}')
  bad_set=$(echo "$t" | awk '{print $2}')
  check_result "$validator" "$bad_set" "1" "bad"
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
