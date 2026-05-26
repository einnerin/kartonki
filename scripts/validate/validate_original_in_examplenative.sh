#!/usr/bin/env bash
set -u
cd "$(git rev-parse --show-toplevel 2>/dev/null || pwd)"
python scripts/validate/validate_original_in_examplenative.py "$1"
