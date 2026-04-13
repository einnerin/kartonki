#!/bin/bash
# Populate Gradle module cache with Firebase artifacts downloaded via curl
# Run from project root

CACHE_DIR="$HOME/.gradle/caches/modules-2/files-2.1"
GOOGLE_MAVEN="https://dl.google.com/dl/android/maven2"
MAVEN_CENTRAL="https://repo1.maven.org/maven2"

download_to_cache() {
    local group="$1"    # e.g. com.google.firebase
    local artifact="$2" # e.g. firebase-auth-ktx
    local version="$3"  # e.g. 23.1.0
    local ext="$4"      # pom or aar or jar
    local base_url="$5" # Maven base URL

    local group_path="${group//.//}"
    local filename="${artifact}-${version}.${ext}"
    local url="${base_url}/${group_path}/${artifact}/${version}/${filename}"
    local tmpfile="/tmp/${filename}"

    echo "Downloading ${group}:${artifact}:${version}.${ext}..."
    if ! curl -sf --max-time 30 -o "$tmpfile" "$url"; then
        echo "  FAILED to download $url"
        return 1
    fi

    # Calculate SHA1
    local sha1
    sha1=$(sha1sum "$tmpfile" | cut -d' ' -f1)

    local dest_dir="${CACHE_DIR}/${group}/${artifact}/${version}/${sha1}"
    mkdir -p "$dest_dir"
    cp "$tmpfile" "${dest_dir}/${filename}"
    rm "$tmpfile"
    echo "  Cached at ${dest_dir}/${filename} (sha1: ${sha1})"
}

# Firebase BOM
download_to_cache "com.google.firebase" "firebase-bom" "33.7.0" "pom" "$GOOGLE_MAVEN"

# firebase-auth-ktx
download_to_cache "com.google.firebase" "firebase-auth-ktx" "23.1.0" "pom" "$GOOGLE_MAVEN"
download_to_cache "com.google.firebase" "firebase-auth-ktx" "23.1.0" "aar" "$GOOGLE_MAVEN"

# firebase-auth (base)
download_to_cache "com.google.firebase" "firebase-auth" "23.1.0" "pom" "$GOOGLE_MAVEN"
download_to_cache "com.google.firebase" "firebase-auth" "23.1.0" "aar" "$GOOGLE_MAVEN"

# firebase-database-ktx
download_to_cache "com.google.firebase" "firebase-database-ktx" "21.0.0" "pom" "$GOOGLE_MAVEN"
download_to_cache "com.google.firebase" "firebase-database-ktx" "21.0.0" "aar" "$GOOGLE_MAVEN"

# firebase-database (base)
download_to_cache "com.google.firebase" "firebase-database" "21.0.0" "pom" "$GOOGLE_MAVEN"
download_to_cache "com.google.firebase" "firebase-database" "21.0.0" "aar" "$GOOGLE_MAVEN"

# firebase-firestore-ktx
download_to_cache "com.google.firebase" "firebase-firestore-ktx" "25.1.1" "pom" "$GOOGLE_MAVEN"
download_to_cache "com.google.firebase" "firebase-firestore-ktx" "25.1.1" "aar" "$GOOGLE_MAVEN"

# firebase-firestore (base)
download_to_cache "com.google.firebase" "firebase-firestore" "25.1.1" "pom" "$GOOGLE_MAVEN"
download_to_cache "com.google.firebase" "firebase-firestore" "25.1.1" "aar" "$GOOGLE_MAVEN"

# play-services-auth
download_to_cache "com.google.android.gms" "play-services-auth" "21.3.0" "pom" "$GOOGLE_MAVEN"
download_to_cache "com.google.android.gms" "play-services-auth" "21.3.0" "aar" "$GOOGLE_MAVEN"

# kotlinx-coroutines-play-services
download_to_cache "org.jetbrains.kotlinx" "kotlinx-coroutines-play-services" "1.8.1" "pom" "$MAVEN_CENTRAL"
download_to_cache "org.jetbrains.kotlinx" "kotlinx-coroutines-play-services" "1.8.1" "jar" "$MAVEN_CENTRAL"

echo "Done!"
