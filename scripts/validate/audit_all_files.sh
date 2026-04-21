#!/usr/bin/env bash
# Full-base audit: run validate_all on every setId in all WordData*.kt files.
# Aggregates pass/fail counts. Used by CI and for manual health checks.
set -u
cd "$(git rev-parse --show-toplevel 2>/dev/null || pwd)"

DATA_DIR="app/src/main/java/com/example/kartonki/data"
HERE="scripts/validate"

# Extract all setIds across all WordData*.kt files
SET_IDS=$(grep -hoE 'setId = [0-9]+' "$DATA_DIR"/WordData*.kt | grep -oE '[0-9]+' | sort -un)
TOTAL=$(echo "$SET_IDS" | wc -l)
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo "Аудит всей базы: $TOTAL setIds"
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"

PASS=0
FAIL=0
FAIL_LIST=()
for sid in $SET_IDS; do
  if bash "$HERE/validate_all.sh" "$sid" > /dev/null 2>&1; then
    PASS=$((PASS + 1))
  else
    FAIL=$((FAIL + 1))
    FAIL_LIST+=("$sid")
  fi
done

echo ""
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo "Результат: $PASS/$TOTAL setId прошли, $FAIL с нарушениями"
if [ $FAIL -gt 0 ]; then
  echo ""
  echo "setId с нарушениями (первые 50):"
  for sid in "${FAIL_LIST[@]:0:50}"; do
    echo "  $sid"
  done
  if [ ${#FAIL_LIST[@]} -gt 50 ]; then
    echo "  ... and $((${#FAIL_LIST[@]} - 50)) more"
  fi
  echo ""
  echo "Детали по конкретному setId:"
  echo "  bash scripts/validate/validate_all.sh <setId>"
fi
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
[ $FAIL -eq 0 ]
