# ============================================================================
# Kartonki — ProGuard / R8 rules
# ============================================================================
#
# Most libraries ship their own consumer rules (Hilt, Room, Compose, Firebase
# Analytics, kotlinx coroutines), so this file only adds project-specific rules
# and a few cross-cutting attributes needed for crash diagnostics + Firebase
# reflection.
#
# When adding rules: prefer narrowest possible scope. Wildcard keeps disable
# minification benefits (smaller APK, faster cold start, less reverse-engineering
# surface). If a release build crashes, find the exact class hit by R8 and add
# a targeted -keep, not a blanket one.

# ----------------------------------------------------------------------------
# Crash report readability
# ----------------------------------------------------------------------------
# Keep line numbers in stack traces (Crashlytics, Play Console "Vitals", local logs).
# Without these, post-minify stack traces are unreadable: methods become a/b/c at
# unknown lines.
-keepattributes SourceFile,LineNumberTable
# Map the obfuscated source file name to a fixed marker so Crashlytics can
# decode via the uploaded mapping.txt without leaking real .kt paths.
-renamesourcefileattribute SourceFile

# ----------------------------------------------------------------------------
# Firebase Realtime Database — POJO models
# ----------------------------------------------------------------------------
# OnlineMatchData / OnlineRoundData / MatchmakingEntry are written into Firebase
# via setValue(obj) and read back via getValue(Class). Both paths use Java
# reflection over field/property names. R8 would rename fields and break the
# wire format. Keep the data classes and their members verbatim.
-keep class com.example.kartonki.data.remote.model.** { *; }

# Firebase reflection needs annotations on POJOs (e.g. @PropertyName, @Exclude)
# preserved even though we don't use them today — defensive keep covers future
# additions.
-keepattributes *Annotation*

# Generic signatures: Firebase's getValue(GenericTypeIndicator<List<Long>>())
# needs the parameterized type info kept at runtime.
-keepattributes Signature,InnerClasses,EnclosingMethod

# ----------------------------------------------------------------------------
# Library noise — third-party deps R8 can't fully analyse
# ----------------------------------------------------------------------------
# Firestore depends on protobuf-lite and Google Tasks internals that reference
# JDK classes not present on Android. These are runtime-safe but R8 logs them
# as warnings. Suppress to keep build output clean and prevent false positives.
-dontwarn com.google.errorprone.annotations.**
-dontwarn javax.annotation.**

# ----------------------------------------------------------------------------
# Kotlin metadata — needed for any reflection-based deserialisation
# ----------------------------------------------------------------------------
# kotlin-reflect is not on the classpath, but Firebase's Kotlin support inspects
# @Metadata to find primary-constructor params. Keep it on POJO classes only
# (already covered by the broad -keep above for data.remote.model).
-keepclassmembers class kotlin.Metadata { *; }
