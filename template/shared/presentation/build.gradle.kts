plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.android.library) // {platform.android}
}

kotlin {
    // {platform.android.target}
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = libs.versions.android.jvmTarget.get()
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
                optIn("androidx.compose.material3.ExperimentalMaterial3Api")
                optIn("org.jetbrains.compose.resources.ExperimentalResourceApi")
            }
        }
        commonMain.dependencies {
            api(compose.foundation)
            api(libs.kotlinx.datetime)
            api(libs.kotlinx.coroutines.core)
            api(libs.kotlinx.serialization.json)
            api(libs.androidx.navigation.compose)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(compose.material3)
            implementation(libs.compose.placeholder.material3) // {userflow.component.placeholder}
            implementation(libs.coil.compose)
            implementation(libs.coil.network.ktor2)
            implementation(libs.filekit.compose)
            implementation(libs.markdown.renderer) // {userflow.component.markdown}
            implementation(libs.markdown.renderer.m3) // {userflow.component.markdown}
            implementation(libs.markdown.renderer.coil3) // {userflow.component.markdown}
            implementation(libs.cashapp.paging.compose.common)
            implementation(projects.shared.data)
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
        val skikoMain by creating {
            dependsOn(commonMain.get())
        }
        jsMain.get().dependsOn(skikoMain)
        jvmMain.get().dependsOn(skikoMain)
        nativeMain.get().dependsOn(skikoMain)
    }
}

// {platform.android.config}
android {
    namespace = "shared.presentation"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility(libs.versions.android.jvmTarget.get())
        targetCompatibility(libs.versions.android.jvmTarget.get())
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
// {platform.android.config}
