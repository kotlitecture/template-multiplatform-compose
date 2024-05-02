plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinxSerialization)
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
                optIn("kotlin.io.encoding.ExperimentalEncodingApi")
                optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
            }
        }
        commonMain.dependencies {
            api(libs.bundles.ktor.common)
            api(libs.kotlinx.coroutines.core)
            api(libs.kotlinx.serialization.json)
            implementation(libs.multiplatform.settings.no.arg)
        }
        // {platform.android.dependencies}
        androidMain.dependencies {
            api(libs.kotlinx.coroutines.android)
            implementation(libs.ktor.client.okHttp)
        }
        // {platform.android.dependencies}
        // {platform.ios.dependencies}
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
        // {platform.ios.dependencies}
        // {platform.js.dependencies}
        jsMain.dependencies {
            implementation(libs.ktor.client.js)
        }
        // {platform.js.dependencies}
        // {platform.jvm.dependencies}
        jvmMain.dependencies {
            api(libs.kotlinx.coroutines.swing)
            implementation(libs.ktor.client.java)
        }
        // {platform.jvm.dependencies}
    }
}

// {platform.android.config}
android {
    namespace = "shared.data"
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
