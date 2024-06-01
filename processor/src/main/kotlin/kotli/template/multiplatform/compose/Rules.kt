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
    const val BuildGradleSharedData = "shared/data/build.gradle.kts"
    const val BuildGradleSharedDesign = "shared/design/build.gradle.kts"
    // proguard
    const val ProguardRulesPro = "composeApp/assemble/proguard-rules.pro"

    // sources
    const val IosAppDir = "iosApp"
    const val SrcAndroidMainDir = "*/src/androidMain"
    const val SrcIosMainDir = "*/src/iosMain"
    const val SrcJsMainDir = "*/src/jsMain"
    const val SrcJvmMainDir = "*/src/jvmMain"
    const val SharedCoreDir = "shared/core"
    const val SharedDataDir = "shared/data"
    const val SharedDesignDir = "shared/design"

    // kotlin
    const val Kt = "*.kt"
    const val CommonAppSrcDir = "composeApp/src"
    const val SharedDesignSrcDir = "shared/design/src"
    const val CommonAppMainDir = "${CommonAppSrcDir}/commonMain"
    const val AppIconsProviderKt = "${SharedDesignSrcDir}/commonMain/kotlin/shared/design/AppIconsProvider.kt"
    const val AppKt = "${CommonAppMainDir}/kotlin/kotli/app/App.kt"
    const val AppDIKt = "${CommonAppMainDir}/kotlin/kotli/app/di/DI.kt"
    const val AppScreenKt = "${CommonAppMainDir}/kotlin/kotli/app/AppScreen.kt"
    const val AppNavigationRouterKt = "${CommonAppMainDir}/kotlin/kotli/app/AppNavigationRouter.kt"
    const val AppThemeDir = "${CommonAppMainDir}/kotlin/kotli/app/ui/theme"
    const val AppThemeViewModelKt = "${AppThemeDir}/AppThemeViewModel.kt"
    const val AppThemeProviderKt = "${AppThemeDir}/AppThemeProvider.kt"
    const val AppThemeConfigDataKt = "${AppThemeDir}/AppThemeConfigData.kt"
    const val AppThemePersistenceViewModelKt = "${AppThemeDir}/AppThemePersistenceViewModel.kt"
    const val ProvidesNavigationBarStateKt = "${CommonAppMainDir}/kotlin/kotli/app/di/state/ProvidesNavigationBarState.kt"
    const val ProvidesNavigationStateKt = "${CommonAppMainDir}/kotlin/kotli/app/di/state/ProvidesNavigationState.kt"
    const val UserFlowDir = "${CommonAppMainDir}/kotlin/kotli/app/feature"
    const val UserFlowDataLoaderDir = "${UserFlowDir}/loader/data"
    const val UserFlowThemeDir = "${UserFlowDir}/theme"
    const val UserFlowThemeChangeDir = "${UserFlowThemeDir}/change"
    const val UserFlowThemeToggleDir = "${UserFlowThemeDir}/toggle"
    const val UserFlowNavigationDir = "${UserFlowDir}/navigation"
    const val UserFlowNavigationBarProvider = "${UserFlowNavigationDir}/NavigationBarProvider.kt"
    const val UserFlowNavigationAdaptiveProvider = "${UserFlowNavigationDir}/AdaptiveProvider.kt"
    const val UserFlowNavigationBottomProvider = "${UserFlowNavigationDir}/BottomProvider.kt"
    const val UserFlowNavigationDismissibleProvider = "${UserFlowNavigationDir}/DismissibleProvider.kt"
    const val UserFlowNavigationModalProvider = "${UserFlowNavigationDir}/ModalProvider.kt"
    const val UserFlowNavigationPermanentProvider = "${UserFlowNavigationDir}/PermanentProvider.kt"
    const val UserFlowNavigationRailProvider = "${UserFlowNavigationDir}/RailProvider.kt"
    const val ShowcasesDir = "${CommonAppMainDir}/kotlin/kotli/app/showcases"
    const val ShowcasesHttpDir = "${ShowcasesDir}/datasource/http"
    const val ShowcasesPagingDir = "${ShowcasesDir}/datasource/paging"
    const val ShowcasesKeyValueDir = "${ShowcasesDir}/datasource/keyvalue"
    const val ShowcasesNavigationDir = "${ShowcasesDir}/navigation"
    const val ShowcasesThemeDir = "${ShowcasesDir}/feature/theme"
    const val ShowcasesLoaderDir = "${ShowcasesDir}/feature/loader"
    const val ShowcasesPasscodeDir = "${ShowcasesDir}/feature/passcode"
    const val ShowcasesKt = "${ShowcasesDir}/Showcases.kt"
    const val ThemeStateKt = "${SharedCoreDir}/src/commonMain/kotlin/shared/core/theme/ThemeState.kt"
    // dataflow
    const val AppConfigSource = "${CommonAppMainDir}/kotlin/kotli/app/datasource/config/AppConfigSource.kt"
    const val AnalyticsSource = "*/*AnalyticsSource.kt"
    const val ConfigSource = "*/*ConfigSource.kt"
    const val PagingSource = "*/*Paging*.kt"
    const val HttpSource = "*/*HttpSource.kt"
    const val KeyValueSource = "*/*KeyValueSource.kt"
    const val SettingsKeyValueSource = "*/*SettingsKeyValueSource.kt"

}