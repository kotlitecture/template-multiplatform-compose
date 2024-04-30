package kotli.template.multiplatform.compose

object Rules {

    // resources
    const val StringsXml = "*/strings.xml"
    const val IndexHtml = "*/index.html"
    const val IosConfig = "*/Config.xcconfig"

    // gradle
    const val BuildGradle = "*build.gradle.kts"
    const val SettingsGradle = "settings.gradle.kts"
    const val BuildGradleRoot = "build.gradle.kts"
    const val BuildGradleComposeApp = "composeApp/build.gradle.kts"

    // kotlin
    const val Kt = "*.kt"

    // sources
    const val IosApp = "iosApp"
    const val SrcAndroidMain = "*/src/androidMain"
    const val SrcIosMain = "*/src/iosMain"
    const val SrcJsMain = "*/src/jsMain"
    const val SrcJvmMain = "*/src/jvmMain"

}