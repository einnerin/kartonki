#!/usr/bin/env bash
set -e
cd "$(git rev-parse --show-toplevel 2>/dev/null || pwd)"
exec python scripts/validate/validate_group_sizes.py "$@"
