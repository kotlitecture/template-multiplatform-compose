plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.androidLibrary) // {platform.android}
}

kotlin {
    // {platform.android.target}
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }
    // {platform.android.target}
    // {platform.ios.target}
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    // {platform.ios.target}
    // {platform.js.target}
    js(IR) {
        browser()
    }
    // {platform.js.target}
    // {platform.jvm.target}
    jvm()
    // {platform.jvm.target}
    applyDefaultHierarchyTemplate()
    sourceSets {
        all {
            languageSettings {
                optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
            }
        }
        commonMain.dependencies {
            api(compose.foundation)
            api(libs.androidx.lifecycle.viewmodel.compose)
            api(libs.androidx.navigation.compose)
            api(libs.kotlinx.coroutines.core)
            api(libs.kotlinx.datetime)
            api(libs.kotlinx.serialization.json)
        }
        // {platform.android.dependencies}
        androidMain.dependencies {
            api(libs.androidx.appcompat)
            api(libs.androidx.activity.compose)
            api(libs.kotlinx.coroutines.android)
        }
        // {platform.android.dependencies}
        // {platform.jvm.dependencies}
        jvmMain.dependencies {
            api(libs.kotlinx.coroutines.swing)
        }
        // {platform.jvm.dependencies}
    }
}

// {platform.android.config}
android {
    namespace = "shared.core"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
// {platform.android.config}
