#!/usr/bin/env bash
set -e
cd "$(git rev-parse --show-toplevel 2>/dev/null || pwd)"
exec python scripts/validate/validate_blank_ambiguity.py "$@"
