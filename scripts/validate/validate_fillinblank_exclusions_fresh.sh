#!/usr/bin/env bash
set -u
cd "$(git rev-parse --show-toplevel 2>/dev/null || pwd)"
python scripts/validate/validate_fillinblank_exclusions_fresh.py "$1"
