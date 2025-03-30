package kotli.template.multiplatform.compose

object Rules {

    // common
    const val BuildGradle = "*build.gradle.kts"
    const val StringsXml = "*/strings.xml"
    const val IndexHtml = "*/index.html"
    const val IosConfig = "*/Config.xcconfig"
    const val AndroidSrcDir = "*/src/androidMain"
    const val JvmSrcDir = "*/src/jvmMain"
    const val JsSrcDir = "*/src/jsMain"
    const val IosSrcDir = "*/src/ios*"
    const val IosAppDir = "iosApp"

    // root
    const val RootSettingsGradle = "settings.gradle.kts"
    const val RootBuildGradle = "build.gradle.kts"

    // app
    const val App = "app"
    const val AppSrc = "${App}/src"
    const val AppBuildGradle = "${App}/build.gradle.kts"
    const val AppCommonMain = "${AppSrc}/commonMain"
    const val AppCommonMainRoot = "${AppCommonMain}/kotlin/kotli/app"
    const val AppKt = "${AppCommonMainRoot}/app/App.kt"
    const val AppConfigKt = "${AppCommonMainRoot}/app/AppConfig.kt"
    const val AppViewModelKt = "${AppCommonMainRoot}/app/AppViewModel.kt"
    const val AppCommon = "${AppCommonMainRoot}/common"
    const val AppCommonPresentation = "${AppCommon}/presentation"
    const val AppCommonConfigKt = "${AppCommon}/CommonConfig.kt"
    const val AppProguardRulesPro = "${App}/assemble/proguard-rules.pro"
    const val AppWebPackConfigDir = "app/webpack.config.d"
    const val AppSqlDelightConfigJs = "${AppWebPackConfigDir}/sqljs-config.js"
    const val AppPlatformConfigKt = "*/PlatformConfig.*.kt"
    const val AppCommonLoader = "${AppCommonPresentation}/loader"
    const val AppCommonNavigation = "${AppCommonPresentation}/navigation"
    const val AppCommonDatabase = "${AppCommon}/data/source/database"
    const val AppPasscode = "${AppCommonMainRoot}/passcode"
    const val AppTheme = "${AppCommonMainRoot}/theme"
    const val AppThemeConfigKt = "${AppTheme}/ThemeConfig.kt"
    const val AppNavigation = "${AppCommonMainRoot}/navigation"
    const val AppNavigationProvider = "${AppNavigation}/provide/presentation/NavigationProvider.kt"
    const val AppBottomNavigationProvider = "${AppNavigation}/provide/presentation/BottomNavigationProvider.kt"
    const val AppNavigationViewModel = "${AppNavigation}/provide/presentation/NavigationViewModel.kt"
    const val AppShowcases = "${AppCommonMainRoot}/showcases"
    const val AppShowcasesDataflow = "${AppShowcases}/presentation/dataflow"
    const val AppShowcasesUserflow = "${AppShowcases}/presentation/userflow"
    const val AppShowcasesViewModelKt = "${AppShowcases}/presentation/ShowcasesViewModel.kt"
    const val AppShowcasesConfigKt = "${AppShowcases}/ShowcasesConfig.kt"

    // backend
    const val BackendDir = "backend"
    const val BackendBuildGradle = "${BackendDir}/build.gradle.kts"
    const val BackendSrc = "${BackendDir}/src"

    // domain
    const val DomainDir = "shared/domain"
    const val DomainBuildGradle = "${DomainDir}/build.gradle.kts"

    // data
    const val DataDir = "shared/data"
    const val DataDataSourceDir = "${DataDir}/src/commonMain/kotlin/shared/data/source"
    const val DataBuildGradle = "${DataDir}/build.gradle.kts"
    const val AnalyticsSource = "*/*AnalyticsSource*.kt"
    const val CacheSource = "*/*CacheSource*.kt"
    const val CacheSourceDir = "${DataDataSourceDir}/cache"
    const val SqlDelightSource = "*/*SqlDelightSource*.kt"
    const val SqlDelightDir = "*/sqldelight/*"
    const val RoomSource = "*/*RoomSource*.kt"
    const val RoomDir = "*/database/room/*"
    const val ConfigSource = "*/*ConfigSource.kt"
    const val PagingSource = "*/*Paging*.kt"
    const val PagingSourceDir = "${DataDataSourceDir}/paging"
    const val HttpSource = "*/*HttpSource.kt"
    const val SettingsSource = "*/*SettingsSource.kt"
    const val DataStoreSource = "*/DataStoreSource.kt"
    const val MultiplatformSettingsSource = "*/MultiplatformSettingsSource.kt"
    const val EncryptionSource = "*/*EncryptionSource*.kt"
    const val EncryptionDir = "${DataDir}/src/commonMain/kotlin/shared/data/source/encryption"
    const val ExpressionSource = "*/*ExpressionEvaluator*.kt"
    const val AiSource = "*/*AiSource*.kt"

    // presentation
    const val PresentationDir = "shared/presentation"
    const val PresentationBuildGradle = "${PresentationDir}/build.gradle.kts"
    const val PresentationUiDir = "${PresentationDir}/src/commonMain/kotlin/shared/presentation/ui"
    const val PresentationIconsKt = "${PresentationUiDir}/icon/AppIcons.kt"
    const val PresentationComponentDir = "${PresentationUiDir}/component"
    const val PresentationComponentPlaceholder = "${PresentationComponentDir}/AppPlaceholder.kt"
    const val PresentationComponentFilePicker = "${PresentationComponentDir}/AppFilePicker.kt"
    const val PresentationComponentMarkdown = "${PresentationComponentDir}/AppMarkdown.kt"
    const val PresentationComponentIcon = "${PresentationComponentDir}/AppIcon.kt"
}