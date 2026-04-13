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
        // Local Maven proxy (serves Firebase and other artifacts downloaded via curl)
        // This is used in environments where Java network sockets are restricted
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
