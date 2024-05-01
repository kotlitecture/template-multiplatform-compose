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
    const val CommonAppMainDir = "composeApp/src/commonMain"
    const val AppKt = "${CommonAppMainDir}/kotlin/app/App.kt"
    const val AppDIKt = "${CommonAppMainDir}/kotlin/app/di/DI.kt"
    const val ShowcasesDir = "${CommonAppMainDir}/kotlin/app/showcases"
    const val ShowcasesHttpDir = "${ShowcasesDir}/datasource/http"
    const val ShowcasesPagingDir = "${ShowcasesDir}/datasource/paging"
    const val ShowcasesNavigationDir = "${ShowcasesDir}/navigation"
    const val ShowcasesThemeDir = "${ShowcasesDir}/userflow/theme"
    const val ShowcasesPasscodeDir = "${ShowcasesDir}/userflow/passcode"
    const val ShowcasesKt = "${ShowcasesDir}/Showcases.kt"
    const val AppNavigationRouterKt = "${CommonAppMainDir}/kotlin/app/AppNavigationRouter.kt"
    const val ProvidesNavigationBarStateKt = "${CommonAppMainDir}/kotlin/app/di/state/ProvidesNavigationBarState.kt"
    const val ProvidesNavigationStateKt = "${CommonAppMainDir}/kotlin/app/di/state/ProvidesNavigationState.kt"
    // dataflow
    const val AnalyticsSource = "*/*AnalyticsSource.kt"
    const val ConfigSource = "*/*ConfigSource.kt"

    // sources
    const val IosAppDir = "iosApp"
    const val SrcAndroidMainDir = "*/src/androidMain"
    const val SrcIosMainDir = "*/src/iosMain"
    const val SrcJsMainDir = "*/src/jsMain"
    const val SrcJvmMainDir = "*/src/jvmMain"
    const val SharedCoreDir = "shared/core"
    const val SharedDataDir = "shared/data"
    const val SharedDesignDir = "shared/design"

}