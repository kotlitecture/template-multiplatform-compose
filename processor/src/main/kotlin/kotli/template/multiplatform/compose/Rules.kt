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
    const val BuildGradleApp = "app/build.gradle.kts"
    const val BuildGradleBackend = "backend/build.gradle.kts"
    const val BuildGradleSharedData = "shared/data/build.gradle.kts"
    const val BuildGradleSharedDesign = "shared/design/build.gradle.kts"
    const val BuildGradleSharedDomain = "shared/domain/build.gradle.kts"

    // proguard
    const val ProguardRulesPro = "app/assemble/proguard-rules.pro"

    // sources
    const val IosAppDir = "iosApp"
    const val SrcAndroidMainDir = "*/src/androidMain"
    const val SrcIosMainDir = "*/src/ios*"
    const val SrcJsMainDir = "*/src/jsMain"
    const val SrcJvmMainDir = "*/src/jvmMain"
    const val SharedPresentationDir = "shared/presentation"
    const val SharedDataDir = "shared/data"
    const val SharedDomainDir = "shared/domain"
    const val BackendDir = "backend"

    // kotlin
    const val DIKt = "*/DI*.kt"
    const val ConfigureKoinDI = "*/configureKoin.kt"
    const val CommonAppSrcDir = "app/src"
    const val CommonAppMainDir = "${CommonAppSrcDir}/commonMain"
    const val AppKt = "${CommonAppMainDir}/kotlin/kotli/app/App.kt"
    const val AppPresentationDir = "${CommonAppMainDir}/kotlin/kotli/app/presentation"
    const val AppDiDir = "${CommonAppMainDir}/kotlin/kotli/app/di"
    const val AppModuleKt = "${CommonAppMainDir}/kotlin/kotli/app/di/presentation/AppModule.kt"
    const val AppWebPackConfigDir = "app/webpack.config.d"
    const val AppSqlDelightConfigJs = "${AppWebPackConfigDir}/sqljs-config.js"
    const val AppScreenKt = "${AppPresentationDir}/app/AppScreen.kt"
    const val AppNavigationRouterKt = "${AppPresentationDir}/app/AppNavigationRouter.kt"
    const val AppThemeDir = "${AppPresentationDir}/theme"
    const val AppThemeViewModelKt = "${AppThemeDir}/AppThemeViewModel.kt"
    const val AppThemeChangeDir = "${AppPresentationDir}/theme/change"
    const val AppThemeToggleDir = "${AppPresentationDir}/theme/toggle"
    const val AppThemeProviderKt = "${AppThemeDir}/AppThemeProvider.kt"
    const val AppThemeConfigDataKt = "${AppThemeDir}/AppThemeConfigData.kt"
    const val AppThemePersistenceViewModelKt = "${AppThemeDir}/AppThemePersistenceViewModel.kt"
    const val AppLoaderDir = "${AppPresentationDir}/loader"
    const val AppNavigationDir = "${AppPresentationDir}/navigation"
    const val AppNavigationBarProvider = "${AppNavigationDir}/NavigationBarProvider.kt"
    const val AppNavigationAdaptiveProvider = "${AppNavigationDir}/AdaptiveProvider.kt"
    const val AppNavigationBottomProvider = "${AppNavigationDir}/BottomProvider.kt"
    const val AppNavigationDismissibleProvider = "${AppNavigationDir}/DismissibleProvider.kt"
    const val AppNavigationModalProvider = "${AppNavigationDir}/ModalProvider.kt"
    const val AppNavigationPermanentProvider = "${AppNavigationDir}/PermanentProvider.kt"
    const val AppNavigationRailProvider = "${AppNavigationDir}/RailProvider.kt"

    const val ThemeStoreKt = "${SharedPresentationDir}/src/commonMain/kotlin/shared/presentation/theme/ThemeStore.kt"
    const val NavigationBarModuleKt = "${CommonAppMainDir}/kotlin/kotli/app/di/presentation/NavigationBarModule.kt"
    const val NavigationModuleKt = "${AppDiDir}/presentation/NavigationModule.kt"

    // userflow -> passcode
    const val AppPasscodeDir = "${AppPresentationDir}/passcode"
    const val PasscodeModuleKt = "${AppDiDir}/presentation/PasscodeModule.kt"

    // showcases
    const val ShowcasesDir = "*/presentation/showcases"
    const val ShowcasesDataFlowDir = "${ShowcasesDir}/dataflow"
    const val ShowcasesUserFlowDir = "${ShowcasesDir}/userflow"
    const val ShowcasesHttpDir = "${ShowcasesDataFlowDir}/http"
    const val ShowcasesCacheDir = "${ShowcasesDataFlowDir}/cache"
    const val ShowcasesAiDir = "${ShowcasesDataFlowDir}/ai"
    const val ShowcasesPagingDir = "${ShowcasesDataFlowDir}/paging"
    const val ShowcasesEncryptionDir = "${ShowcasesDataFlowDir}/encryption"
    const val ShowcasesKeyValueDir = "${ShowcasesDataFlowDir}/keyvalue"
    const val ShowcasesSqlDelightDir = "${ShowcasesDataFlowDir}/sqldelight"
    const val ShowcasesRoomDir = "${ShowcasesDataFlowDir}/room"
    const val ShowcasesNavigationDir = "${ShowcasesUserFlowDir}/navigation"
    const val ShowcasesThemeDir = "${ShowcasesUserFlowDir}/theme"
    const val ShowcasesLoaderDir = "${ShowcasesUserFlowDir}/loader"
    const val ShowcasesPasscodeDir = "${ShowcasesUserFlowDir}/passcode"
    const val ShowcasesPlaceholderDir = "${ShowcasesUserFlowDir}/component/placeholder"
    const val ShowcasesMarkdownDir = "${ShowcasesUserFlowDir}/component/markdown"
    const val ShowcasesFilePickerDir = "${ShowcasesUserFlowDir}/component/filepicker"
    const val ShowcasesCoilDir = "${ShowcasesUserFlowDir}/component/image/coil"
    const val ShowcasesKt = "${ShowcasesDir}/Showcases.kt"

    // design
    const val SharedDesignDir = "shared/design"
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
    // dataflow -> database
    const val SqlDelightSource = "*/*SqlDelightSource*.kt"
    const val SqlDelightDir = "*/sqldelight/*"
    const val RoomSource = "*/*RoomSource*.kt"
    const val RoomDir = "*/database/room/*"
    // dataflow -> config
    const val ConfigSource = "*/*ConfigSource*.kt"
    const val AppConfigSource = "${CommonAppMainDir}/kotlin/kotli/app/data/source/config/AppConfigSource.kt"
    // dataflow -> paging
    const val PagingSource = "*/*Paging*.kt"
    // dataflow -> http
    const val HttpSource = "*/*HttpSource*.kt"
    // dataflow -> keyvalue
    const val KeyValueSource = "*/*KeyValueSource*.kt"
    const val SettingsKeyValueSource = "*/*SettingsKeyValueSource*.kt"
    const val DataStoreSource = "*/*DataStoreSource.kt"
    // dataflow -> encryption
    const val EncryptionSource = "*/*EncryptionSource*.kt"
    const val EncryptionDir = "${SharedDataDir}/src/commonMain/kotlin/shared/data/source/encryption"
    // dataflow -> AiSource
    const val AiSource = "*/*AiSource*.kt"

}