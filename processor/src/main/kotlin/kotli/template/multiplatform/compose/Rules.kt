package kotli.template.multiplatform.compose

object Rules {

    // resources
    const val StringsXml = "*/strings.xml"
    const val IndexHtml = "*/index.html"
    const val IosConfig = "*/Config.xcconfig"

    const val IosAppDir = "iosApp"
    const val BackendDir = "backend"
    const val SrcAndroidMainDir = "*/src/androidMain"
    const val SrcIosMainDir = "*/src/ios*"
    const val SrcJsMainDir = "*/src/jsMain"
    const val SrcJvmMainDir = "*/src/jvmMain"
    const val SharedDataDir = "shared/data"
    const val SharedDomainDir = "shared/domain"
    const val SharedDesignDir = "shared/design"

    // gradle
    const val BuildGradle = "*build.gradle.kts"
    const val SettingsGradle = "settings.gradle.kts"
    const val BuildGradleRoot = "build.gradle.kts"
    const val BuildGradleBackend = "${BackendDir}/build.gradle.kts"
    const val BuildGradleSharedData = "${SharedDataDir}/build.gradle.kts"
    const val BuildGradleSharedDesign = "${SharedDesignDir}/build.gradle.kts"
    const val BuildGradleSharedDomain = "${SharedDomainDir}/build.gradle.kts"

    // app
    const val App = "app"
    const val AppSrc = "${App}/src"
    const val AppBuildGradle = "${App}/build.gradle.kts"
    const val AppCommonMain = "${AppSrc}/commonMain"
    const val AppCommonMainRoot = "${AppCommonMain}/kotlin/kotli/app"
    const val AppCommon = "${AppCommonMainRoot}/common"
    const val AppFeature = "${AppCommonMainRoot}/feature"
    const val AppKt = "${AppCommonMainRoot}/App.kt"
    const val AppConfigKt = "${AppCommonMainRoot}/AppConfig.kt"
    const val AppViewModelKt = "${AppCommonMainRoot}/AppViewModel.kt"
    const val AppCommonPresentation = "${AppCommon}/presentation"
    const val AppCommonConfigKt = "${AppCommon}/CommonConfig.kt"
    const val AppConfigureKoinKt = "*/configureKoin.kt"

    // app -> di
    const val AppDI = "${AppCommonMainRoot}/di"
    const val AppDiKt = "${AppDI}/DI.kt"

    // app -> misc
    const val AppProguardRulesPro = "${App}/assemble/proguard-rules.pro"
    const val AppWebPackConfigDir = "app/webpack.config.d"
    const val AppSqlDelightConfigJs = "${AppWebPackConfigDir}/sqljs-config.js"

    // app -> common -> presentation -> loader
    const val AppCommonLoader = "${AppCommonPresentation}/loader"

    // app -> common -> presentation -> navigation
    const val AppCommonNavigation = "${AppCommonPresentation}/navigation"

    // app -> feature -> passcode
    const val AppPasscode = "${AppFeature}/passcode"
    const val AppDIPasscodeModuleKt = "${AppDI}/feature/PasscodeModule.kt"

    // app -> feature -> theme
    const val AppTheme = "${AppFeature}/theme"
    const val AppThemeConfigKt = "${AppTheme}/ThemeConfig.kt"
    const val AppDIThemeModuleKt = "${AppDI}/feature/ThemeModule.kt"

    // app -> feature -> navigation
    const val AppNavigation = "${AppFeature}/navigation"
    const val AppNavigationProvider = "${AppNavigation}/provide/presentation/NavigationProvider.kt"
    const val AppBottomNavigationProvider = "${AppNavigation}/provide/presentation/BottomNavigationProvider.kt"
    const val AppNavigationViewModel = "${AppNavigation}/provide/presentation/NavigationViewModel.kt"

    // app -> feature -> showcases
    const val AppShowcases = "${AppFeature}/showcases"
    const val AppShowcasesDataflow = "${AppShowcases}/presentation/dataflow"
    const val AppShowcasesUserflow = "${AppShowcases}/presentation/userflow"
    const val AppShowcasesViewModelKt = "${AppShowcases}/presentation/ShowcasesViewModel.kt"
    const val AppShowcasesConfigKt = "${AppShowcases}/ShowcasesConfig.kt"

    // design
    const val SharedDesignSrcDir = "${SharedDesignDir}/src"
    const val SharedDesignComponentDir = "${SharedDesignSrcDir}/commonMain/kotlin/shared/design/component"
    const val AppIconsKt = "${SharedDesignSrcDir}/commonMain/kotlin/shared/design/icon/AppIcons.kt"
    const val AppPlaceholder = "${SharedDesignComponentDir}/AppPlaceholder.kt"
    const val AppMarkdown = "${SharedDesignComponentDir}/AppMarkdown.kt"
    const val AppFilePicker = "${SharedDesignComponentDir}/AppFilePicker.kt"
    const val AppIcon = "${SharedDesignComponentDir}/AppIcon.kt"

    // dataflow -> analytics
    const val AnalyticsSource = "*/*AnalyticsSource*.kt"

    // dataflow -> cache
    const val CacheSource = "*/*CacheSource*.kt"
    const val CacheSourceDir = "${SharedDataDir}/src/commonMain/kotlin/shared/data/source/cache"

    // dataflow -> database
    const val SqlDelightSource = "*/*SqlDelightSource*.kt"
    const val SqlDelightDir = "*/sqldelight/*"
    const val RoomSource = "*/*RoomSource*.kt"
    const val RoomDir = "*/database/room/*"

    // dataflow -> config
    const val ConfigSource = "*/*ConfigSource*.kt"
    const val AppConfigSource = "${AppCommon}/data/source/config/AppConfigSource.kt"

    // dataflow -> paging
    const val PagingSource = "*/*Paging*.kt"

    // dataflow -> http
    const val HttpSource = "*/*HttpSource*.kt"

    // dataflow -> settings
    const val SettingsSource = "*/*SettingsSource*.kt"
    const val BasicSettingsSource = "*/*BasicSettingsSource*.kt"
    const val DataStoreSource = "*/*DataStoreSource.kt"

    // dataflow -> encryption
    const val EncryptionSource = "*/*EncryptionSource*.kt"
    const val EncryptionDir = "${SharedDataDir}/src/commonMain/kotlin/shared/data/source/encryption"

    // dataflow -> expression
    const val ExpressionSource = "*/*ExpressionEvaluator*.kt"

    // dataflow -> AiSource
    const val AiSource = "*/*AiSource*.kt"

    // backend
    const val Backend = "backend"
    const val BackendSrc = "${Backend}/src"

}