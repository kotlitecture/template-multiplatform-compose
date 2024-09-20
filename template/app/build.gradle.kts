plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.android.application) // {platform.android}
    alias(libs.plugins.sqldelight) // {dataflow.database.sqldelight}
    alias(libs.plugins.ksp) // {common.ksp}
    alias(libs.plugins.room) // {dataflow.database.room}
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
            baseName = "App"
            isStatic = true
            linkerOpts.add("-lsqlite3") // {dataflow.database.sqlite-linker}
        }
    }
    // {platform.ios.target}
    // {platform.js.target}
    js(IR) {
        useEsModules()
        browser {
            commonWebpackConfig {
                outputFileName = "app.js"
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
                optIn("kotlinx.cinterop.ExperimentalForeignApi")
                optIn("kotlinx.coroutines.DelicateCoroutinesApi")
                optIn("androidx.compose.ui.ExperimentalComposeUiApi")
                optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
                optIn("org.jetbrains.compose.resources.ExperimentalResourceApi")
            }
        }
        commonMain.dependencies {
            implementation(compose.components.resources)
            implementation(libs.koin.core)
            implementation(libs.kotlin.logging)
            implementation(libs.napier)
            implementation(libs.sqldelight.coroutines) // {dataflow.database.sqldelight}
            implementation(libs.sqldelight.androidx.paging) // {dataflow.database.sqldelight}
            implementation(libs.touchlab.kermit)
            implementation(libs.generativeai)
            implementation(projects.shared.data)
            implementation(projects.shared.domain)
            implementation(projects.shared.design)
            implementation(projects.shared.presentation)
        }
        // {platform.android.dependencies}
        androidMain.dependencies {
            implementation(libs.androidx.splashscreen)
            implementation(libs.sqldelight.android.driver) // {dataflow.database.sqldelight}
        }
        // {platform.android.dependencies}
        // {platform.ios.dependencies}
        iosMain.dependencies {
            implementation(libs.sqldelight.native.driver) // {dataflow.database.sqldelight}
            implementation(libs.touchlab.stately.common) // {dataflow.database.sqldelight}
            implementation(libs.touchlab.stately.isolate) // {dataflow.database.sqldelight}
            implementation(libs.touchlab.stately.iso.collections) // {dataflow.database.sqldelight}
        }
        // {platform.ios.dependencies}
        // {platform.js.dependencies}
        jsMain.dependencies {
            implementation(libs.sqldelight.web.worker.driver) // {dataflow.database.sqldelight}
            implementation(libs.touchlab.stately.iso.collections.js) // {dataflow.database.sqldelight}
            implementation(npm("sql.js", "1.10.3")) // {dataflow.database.sqldelight}
            implementation(npm("@cashapp/sqldelight-sqljs-worker", libs.versions.sqldelight.get())) // {dataflow.database.sqldelight}
            implementation(devNpm("copy-webpack-plugin", "9.1.0")) // {dataflow.database.sqldelight}
        }
        // {platform.js.dependencies}
        // {platform.jvm.dependencies}
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.sqldelight.sqlite.driver) // {dataflow.database.sqldelight}
        }
        // {platform.jvm.dependencies}
        // {platform.mobile_and_desktop.dependencies}
        val mobileAndDesktopMain by creating {
            dependsOn(commonMain.get())
            dependencies {
                implementation(libs.androidx.room.runtime) // {dataflow.database.room}
                implementation(libs.sqlite.bundled) // {dataflow.database.sqlite}
            }
        }
        // {platform.mobile_and_desktop.dependencies}
        androidMain.get().dependsOn(mobileAndDesktopMain) // {platform.android}
        iosMain.get().dependsOn(mobileAndDesktopMain) // {platform.ios}
        jvmMain.get().dependsOn(mobileAndDesktopMain) // {platform.jvm}
    }
}
// {sqldelight.config}
sqldelight {
    databases {
        create("AppDatabase") {
            packageName.set("kotli.app.data.source.database.sqldelight")
            generateAsync.set(true)
        }
    }
}
// {sqldelight.config}
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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "assemble/proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility(libs.versions.android.jvmTarget.get())
        targetCompatibility(libs.versions.android.jvmTarget.get())
    }
}
// {platform.android.config}
// {platform.jvm.config}
compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Deb
            )
            packageName = "kotli.app"
            packageVersion = "1.0.0"
            modules(
                "java.sql",
                "java.net.http",
                "jdk.unsupported",
                "jdk.security.auth",
            )
        }
        buildTypes.release.proguard {
            obfuscate.set(false)
            configurationFiles.from(project.file("assemble/proguard-rules.pro"))
        }
    }
}
// {platform.jvm.config}
// {common.ksp.config}
dependencies {
    add("kspAndroid", libs.androidx.room.compiler) // {platform.android}
    add("kspJvm", libs.androidx.room.compiler) // {platform.jvm}
    add("kspIosX64", libs.androidx.room.compiler) // {platform.ios}
    add("kspIosArm64", libs.androidx.room.compiler) // {platform.ios}
    add("kspIosSimulatorArm64", libs.androidx.room.compiler) // {platform.ios}
}
// {common.ksp.config}
// {dataflow.database.room.config}
room {
    schemaDirectory("$projectDir/schemas")
}
// {dataflow.database.room.config}
