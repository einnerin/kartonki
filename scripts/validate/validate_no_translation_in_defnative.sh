#!/usr/bin/env bash
# Wrapper for validate_no_translation_in_defnative.py — same pattern as other .sh wrappers.
set -u
cd "$(git rev-parse --show-toplevel 2>/dev/null || pwd)"
python scripts/validate/validate_no_translation_in_defnative.py "$1"
