#!/usr/bin/env bash
# Aggregated validator: runs all 21 checks on a given setId.
# Exit 0 only if all checks pass (warnings OK). Exit 1 if any blocks.
set -u
cd "$(git rev-parse --show-toplevel 2>/dev/null || pwd)"

if [ $# -ne 1 ]; then
  echo "Usage: validate_all.sh <setId>" >&2
  exit 2
fi
SETID=$1

HERE="scripts/validate"
CHECKS=(
  "validate_fields_filled.sh"
  "validate_pos_values.sh"
  "validate_group_sizes.sh"
  "validate_text_lengths.sh"
  "validate_rarity_spread.sh"
  "validate_no_duplicates.sh"
  "validate_no_cognates.sh"
  "validate_no_headword_in_def.sh"
  "validate_no_translation_in_defnative.sh"
  "validate_text_terminators.sh"
  "validate_original_in_example.sh"
  "validate_original_strict_in_example.sh"
  "validate_no_foreign_in_examplenative.sh"
  "validate_no_clerical.sh"
  "validate_hebrew_transliteration_format.sh"
  "validate_blank_ambiguity_hebrew.sh"
  "validate_no_foreign_script_in_original.sh"
  "validate_no_mixed_script_in_words.sh"
  "validate_example_variety.sh"
  "validate_fillinblank_exclusions_fresh.sh"
  "validate_blank_ambiguity.sh"
)

FAIL=0
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo "Валидация setId=$SETID"
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
for check in "${CHECKS[@]}"; do
  echo ""
  echo "── $check ──"
  if bash "$HERE/$check" "$SETID"; then
    :
  else
    FAIL=1
  fi
done

echo ""
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
if [ $FAIL -eq 0 ]; then
  echo "✅ setId=$SETID: все 21 проверка пройдена"
else
  echo "❌ setId=$SETID: есть блокирующие нарушения (см. выше)"
fi
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
exit $FAIL
