import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
}

// Release-signing config is loaded from keystore.properties at the repo root.
// File is .gitignored — passwords never enter the repo. If the file is absent
// (e.g. fresh clone, CI without secrets), `release` falls back to debug signing
// so smoke-tests of the minified build still work locally. Such APKs/AABs MUST
// NOT be uploaded to Play Store — see warning below.
val keystorePropertiesFile = rootProject.file("keystore.properties")
val keystoreProperties = Properties().apply {
    if (keystorePropertiesFile.exists()) load(keystorePropertiesFile.inputStream())
}
val hasReleaseKeystore = keystorePropertiesFile.exists() &&
    keystoreProperties.getProperty("storeFile")?.isNotBlank() == true

android {
    namespace = "com.example.kartonki"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        // Permanent identity in Google Play — chosen 2026-04-27 to replace the
        // example.* placeholder before first publish. Cannot be changed after
        // upload to Play Store. Kotlin package (namespace) stays as
        // "com.example.kartonki" to avoid touching every import in the codebase
        // — applicationId and namespace are independent and don't have to match.
        applicationId = "com.einerin.kartonki"
        minSdk = 24
        targetSdk = 36
        versionCode = 15
        versionName = "0.1.14"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        if (hasReleaseKeystore) {
            create("release") {
                storeFile = file(keystoreProperties.getProperty("storeFile"))
                storePassword = keystoreProperties.getProperty("storePassword")
                keyAlias = keystoreProperties.getProperty("keyAlias")
                keyPassword = keystoreProperties.getProperty("keyPassword")
            }
        }
    }

    buildTypes {
        debug {
            // Suffix позволяет debug-сборке (Android Studio Run) сосуществовать
            // с release-сборкой (.aab/.apk из Play Store) на одном устройстве.
            // Без suffix'а они конфликтуют по applicationId + разной подписи —
            // Android отказывается ставить второй APK поверх первого, требует
            // `adb uninstall` каждый раз при переключении.
            // Firebase: для com.einerin.kartonki.debug зарегистрирован отдельный
            // Android-app в Firebase Console (2026-05-07), debug-keystore SHA-1
            // прописан там же — Google Sign-In в debug-сборке работает.
            applicationIdSuffix = ".debug"
        }
        release {
            // minify + resource shrinking are ON. Verified via the v0.1.14 release
            // (versionCode 15) smoke-test cycle before it was rolled out to Closed
            // Testing — ProGuard rules in proguard-rules.pro keep Firebase/Hilt/Room
            // reflection paths intact. If you add a library that breaks under R8,
            // add keep-rules there rather than flipping these back off.
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = if (hasReleaseKeystore) {
                signingConfigs.getByName("release")
            } else {
                // Fallback: debug-signed release build is fine for local smoke tests
                // of the minified pipeline, but Play Store will reject (or worse,
                // accept and lock you to the debug keystore forever). Loud warning:
                logger.warn(
                    "⚠️  keystore.properties not found — release build will use DEBUG signing. " +
                    "Do NOT upload this build to Google Play. " +
                    "Generate a release keystore and create keystore.properties first."
                )
                signingConfigs.getByName("debug")
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }

    // Room-схемы публикуются в androidTest assets, чтобы MigrationTestHelper мог
    // открыть БД на исторической версии (41/42/43) и прогнать миграции до 44.
    // Без этого helper.createDatabase(name, version) кидает FileNotFoundException.
    sourceSets {
        getByName("androidTest").assets.srcDir("$projectDir/schemas")
    }
}

ksp {
    arg("room.schemaLocation", "$projectDir/schemas")
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    // collectAsStateWithLifecycle — stops Flow collection when the UI is below
    // STARTED (e.g. app backgrounded), instead of collectAsState which keeps
    // collecting in the background.
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material.icons.core)
    // Navigation
    implementation(libs.androidx.navigation.compose)
    // Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)
    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)
    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth)
    implementation(libs.firebase.database)
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.analytics)
    // Crashlytics — УБРАН 2026-06-23: SDK авто-инициализируется через ContentProvider и
    // требует "build ID", который впрыскивает Gradle-плагин com.google.firebase.crashlytics.
    // Плагин НЕ был применён (в f739997 добавили только зависимость) → IllegalStateException
    // "The Crashlytics build ID is missing" → КРАШ на каждом запуске. assembleDebug зелёный
    // (баг только в рантайме) — поймано прогоном на эмуляторе.
    // ВЕРНУТЬ правильно: (1) проверить firebase-crashlytics-gradle с поддержкой AGP 9.x;
    // (2) применить плагин (root apply false + app apply); (3) mappingFileUploadEnabled=false
    // чтобы не тянуть google-services (у нас ручная per-build-type init в FirebaseModule);
    // (4) доделать настройку в Firebase Console.
    // implementation(libs.firebase.crashlytics)
    // Google Sign-In
    implementation(libs.play.services.auth)
    // Coroutines + Play Services
    implementation(libs.kotlinx.coroutines.play.services)
    // Tests
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.room.testing)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    // Auto-installs via ContentProvider; ships only in debug builds (~3-4 MB).
    // Catches retained ViewModels / Activities / Composable scopes.
    debugImplementation(libs.leakcanary.android)
}
