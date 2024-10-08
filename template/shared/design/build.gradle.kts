plugins {
    alias(libs.plugins.kotlin.multiplatform)
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
            implementation(projects.shared.presentation)
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
            api(libs.cashapp.paging.compose.common)
        }
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
    namespace = "shared.design"
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
