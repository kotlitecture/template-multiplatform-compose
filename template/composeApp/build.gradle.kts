import org.jetbrains.compose.desktop.application.dsl.TargetFormat // {platform.jvm}
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig // {platform.js}
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.android.application) // {platform.android}
    alias(libs.plugins.skie) // {platform.ios}
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
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    // {platform.ios.target}
    // {platform.js.target}
    js(IR) {
        browser {
            commonWebpackConfig {
                outputFileName = "app.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        add(project.projectDir.path)
                    }
                }
            }
            useCommonJs()
        }
        binaries.executable()
    }
    // {platform.js.target}
    // {platform.jvm.target}
    jvm()
    // {platform.jvm.target}
    applyDefaultHierarchyTemplate()
    sourceSets {
        all {
            languageSettings {
                optIn("kotlinx.coroutines.FlowPreview")
                optIn("androidx.compose.ui.ExperimentalComposeUiApi")
                optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
                optIn("org.jetbrains.compose.resources.ExperimentalResourceApi")
            }
        }
        commonMain.dependencies {
            implementation(compose.components.resources)
            implementation(libs.koin.core)
            implementation(libs.napier)
            implementation(libs.touchlab.kermit)
            implementation(projects.shared.data)
            implementation(projects.shared.design)
            implementation(projects.shared.presentation)
        }
        // {platform.android.dependencies}
        androidMain.dependencies {
            implementation(libs.androidx.splashscreen)
        }
        // {platform.android.dependencies}
        // {platform.jvm.dependencies}
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
        }
        // {platform.jvm.dependencies}
    }
}

// {platform.android.config}
android {
    namespace = "kotli.app"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "kotli.app"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        named("release") {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "assemble/proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility(libs.versions.android.jvmTarget.get())
        targetCompatibility(libs.versions.android.jvmTarget.get())
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
        debugImplementation(libs.compose.ui.tooling.preview)
    }
}
// {platform.android.config}
// {platform.jvm.config}
compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "kotli.app"
            packageVersion = "1.0.0"
            modules(
                "java.net.http"
            )
        }
        buildTypes.release.proguard {
            obfuscate.set(true)
            configurationFiles.from(project.file("assemble/proguard-rules.pro"))
        }
    }
}
// {platform.jvm.config}
// {platform.js.config}
compose.experimental {
    web.application {}
}
// {platform.js.config}
