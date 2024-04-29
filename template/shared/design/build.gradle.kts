plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    jvm()
    js(IR) {
        browser()
    }
    applyDefaultHierarchyTemplate()

    sourceSets {
        commonMain.dependencies {
            api(compose.components.uiToolingPreview)
            api(compose.foundation)
            api(compose.material3)
            api(compose.materialIconsExtended)
        }
        androidMain.dependencies {
            api(libs.androidx.appcompat)
            api(libs.androidx.activity.compose)
        }
    }
}

android {
    namespace = "shared.design"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
