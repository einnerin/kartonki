pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        // Local Maven proxy on :18080 — required because the Gradle daemon's JVM
        // can't open outbound sockets directly on this Windows host (firewall /
        // AV blocks Java sockets — confirmed by `Permission denied: getsockopt`
        // when trying google()/mavenCentral() directly). The proxy uses curl
        // instead and serves artifacts to the daemon over loopback.
        //
        // Auto-start: if the proxy isn't already listening, settings.gradle.kts
        // launches `node maven_proxy.js` in the background and waits up to 5s
        // for it to bind. This way `gradlew bundleRelease` "just works" after a
        // reboot — no manual `node maven_proxy.js &` step.
        fun proxyListening(): Boolean = try {
            java.net.Socket().use { socket ->
                socket.connect(java.net.InetSocketAddress("127.0.0.1", 18080), 200)
                true
            }
        } catch (_: Exception) {
            false
        }

        if (!proxyListening()) {
            val proxyScript = rootDir.resolve("maven_proxy.js")
            if (proxyScript.exists()) {
                val logFile = rootDir.resolve("maven_proxy.log")
                try {
                    ProcessBuilder("node", proxyScript.absolutePath)
                        .directory(rootDir)
                        .redirectOutput(logFile)
                        .redirectError(logFile)
                        .start()
                    val deadline = System.currentTimeMillis() + 5000
                    while (System.currentTimeMillis() < deadline && !proxyListening()) {
                        Thread.sleep(100)
                    }
                } catch (e: Exception) {
                    println("[settings.gradle.kts] Could not auto-start maven_proxy.js: ${e.message}")
                }
            }
        }

        maven {
            url = uri("http://127.0.0.1:18080")
            isAllowInsecureProtocol = true
        }
        google()
        mavenCentral()
    }
}

rootProject.name = "Kartonki"
include(":app")
