rootProject.name = "template"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

include(":backend")
include(":composeApp")
include(":shared:data")
include(":shared:design")
include(":shared:presentation")
