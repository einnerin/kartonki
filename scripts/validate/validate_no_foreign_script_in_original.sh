#!/usr/bin/env bash
set -u
cd "$(git rev-parse --show-toplevel 2>/dev/null || pwd)"
python scripts/validate/validate_no_foreign_script_in_original.py "$1"
