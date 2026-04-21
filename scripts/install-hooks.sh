#!/usr/bin/env bash
# Установка git hooks Kartonki (уровень 5 системы гарантий качества).
# Запускается однократно после клонирования репозитория.
set -eu

cd "$(git rev-parse --show-toplevel)" || exit 1

GREEN="\033[0;32m"
RED="\033[0;31m"
YELLOW="\033[0;33m"
NC="\033[0m"

echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo "Установка git hooks для Kartonki"
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"

# 1. git config → использовать .githooks/ вместо .git/hooks/
git config core.hooksPath .githooks
echo -e "${GREEN}✓${NC} git config core.hooksPath .githooks"

# 2. chmod +x
if [ -d .githooks ]; then
  for hook in .githooks/*; do
    if [ -f "$hook" ]; then
      chmod +x "$hook" 2>/dev/null || true
    fi
  done
  echo -e "${GREEN}✓${NC} chmod +x .githooks/*"
else
  echo -e "${RED}✗${NC} .githooks/ директория не найдена"
  exit 1
fi

# 3. Проверка, что валидаторы на месте
MISSING=()
for file in \
  scripts/validate/_parser.py \
  scripts/validate/validate_all.sh \
  scripts/validate/find_real_dupes.py; do
  if [ ! -f "$file" ]; then
    MISSING+=("$file")
  fi
done
if [ ${#MISSING[@]} -gt 0 ]; then
  echo -e "${YELLOW}⚠${NC}  Валидаторы не все на месте:"
  for f in "${MISSING[@]}"; do
    echo "    $f"
  done
  echo "    Hook будет работать для cleanliness-проверок, но не для WordData-валидации."
else
  echo -e "${GREEN}✓${NC} Валидаторы на месте (scripts/validate/)"
fi

# 4. Проверка Python
if command -v python >/dev/null 2>&1; then
  PYVER=$(python --version 2>&1)
  echo -e "${GREEN}✓${NC} $PYVER доступен"
else
  echo -e "${YELLOW}⚠${NC}  python не найден в PATH — WordData-валидация работать не будет"
fi

echo ""
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo -e "${GREEN}Git hooks установлены.${NC} Pre-commit validation активна."
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo ""
echo "Что теперь проверяется перед каждым коммитом:"
echo "  • Нет .py в корне репозитория"
echo "  • Нет .claude/worktrees/ в staged"
echo "  • Нет embedded git repos (submodule trap)"
echo "  • Warning при 20+ файлах (обходится LARGE_COMMIT_OK=1)"
echo "  • При изменении WordData*.kt — validate_all.sh на изменённых setIds"
echo ""
echo "Подробности: docs/claude/quality_gates.md"
