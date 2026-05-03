#!/usr/bin/env bash
# Установить свежую release-сборку на подключённый телефон / эмулятор.
#
# Usage:
#   bash scripts/release/install-release.sh
#   bash scripts/release/install-release.sh --build      # пересобрать AAB+APK перед установкой
#
# Имеется в виду release-build с release-keystore (com.einerin.kartonki).
# Чтобы поставить — на телефоне НЕ должно стоять debug-сборки этого же
# applicationId; если стоит — `adb uninstall` сначала.

set -euo pipefail

ADB="${ADB:-C:/Users/Einerin/AppData/Local/Android/Sdk/platform-tools/adb.exe}"
JAVA_HOME_PATH="${JAVA_HOME:-C:/Program Files/Android/Android Studio/jbr}"
APK="app/build/outputs/apk/release/app-release.apk"

if [[ "${1:-}" == "--build" ]]; then
    echo ">> Сборка release..."
    JAVA_HOME="$JAVA_HOME_PATH" ./gradlew assembleRelease \
        -x lintVitalAnalyzeRelease -x lintVitalReportRelease -x lintVitalRelease \
        -x lint -x lintRelease -x lintAnalyzeRelease -x lintReportRelease
fi

if [[ ! -f "$APK" ]]; then
    echo "❌ APK не найден: $APK"
    echo "   Запусти: bash scripts/release/install-release.sh --build"
    exit 1
fi

devices=$("$ADB" devices | grep -E "device$" | wc -l)
if [[ $devices -eq 0 ]]; then
    echo "❌ Нет подключённых устройств. Подключи телефон с USB-debugging или запусти эмулятор."
    exit 1
fi

echo ">> Установка $APK..."
"$ADB" install -r "$APK"
echo "✅ Установлено: com.einerin.kartonki"
echo "   Размер APK: $(($(stat -c%s "$APK" 2>/dev/null || stat -f%z "$APK") / 1024)) KB"
