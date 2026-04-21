#!/usr/bin/env bash
# Thin wrapper — all logic in the Python module.
set -e
cd "$(git rev-parse --show-toplevel 2>/dev/null || pwd)"
exec python scripts/validate/validate_fields_filled.py "$@"
