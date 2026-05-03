#!/usr/bin/env bash
# Helper для съёмки скриншотов с подключённого телефона / эмулятора.
#
# Usage:
#   bash scripts/release/shot.sh 01-card
#   bash scripts/release/shot.sh 02-quiz
#   bash scripts/release/shot.sh demo-on        # включить demo mode статус-бара (12:00, 100%, wifi 4)
#   bash scripts/release/shot.sh demo-off       # выключить demo mode
#
# Складывает в docs/release-assets/screenshots/<name>.png.
# На Windows + Git Bash adb pull через файл надёжнее чем `adb exec-out screencap`
# (последний может побить бинарный stream символами CRLF).

set -euo pipefail

ADB="${ADB:-C:/Users/Einerin/AppData/Local/Android/Sdk/platform-tools/adb.exe}"
DEST_DIR="docs/release-assets/screenshots"

if [[ $# -eq 0 ]]; then
    echo "usage: bash scripts/release/shot.sh <name>"
    echo "       bash scripts/release/shot.sh demo-on | demo-off"
    exit 1
fi

cmd="$1"

case "$cmd" in
    demo-on)
        "$ADB" shell settings put global sysui_demo_allowed 1
        "$ADB" shell am broadcast -a com.android.systemui.demo -e command enter
        "$ADB" shell am broadcast -a com.android.systemui.demo -e command battery -e level 100 -e plugged false
        "$ADB" shell am broadcast -a com.android.systemui.demo -e command network -e wifi show -e level 4
        "$ADB" shell am broadcast -a com.android.systemui.demo -e command notifications -e visible false
        "$ADB" shell am broadcast -a com.android.systemui.demo -e command clock -e hhmm 1200
        echo "demo mode ON (12:00, battery 100%, wifi level 4, no notifications)"
        ;;
    demo-off)
        "$ADB" shell am broadcast -a com.android.systemui.demo -e command exit
        echo "demo mode OFF"
        ;;
    *)
        name="$cmd"
        mkdir -p "$DEST_DIR"
        out="$DEST_DIR/${name}.png"
        "$ADB" shell screencap -p /sdcard/_shot.png
        "$ADB" pull /sdcard/_shot.png "$out" >/dev/null
        "$ADB" shell rm /sdcard/_shot.png
        # Размер в килобайтах для быстрой проверки что не пустой
        size_kb=$(($(stat -c%s "$out" 2>/dev/null || stat -f%z "$out") / 1024))
        echo "saved: $out (${size_kb} KB)"
        ;;
esac
