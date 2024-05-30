plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeCompiler)
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
    js {
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
                optIn("androidx.compose.material3.ExperimentalMaterial3Api")
                optIn("org.jetbrains.compose.resources.ExperimentalResourceApi")
            }
        }
        commonMain.dependencies {
            implementation(projects.shared.core)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(compose.material3)
            api(compose.materialIconsExtended)
            api(libs.cashapp.paging.compose.common)
        }
    }
}

// {platform.android.config}
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
// {platform.android.config}
