package kotli.template.multiplatform.compose

import kotli.engine.BaseTemplateProcessor
import kotli.engine.FeatureProvider
import kotli.engine.LayerType
import kotli.engine.TemplateState
import kotli.engine.model.Feature
import kotli.engine.model.Layer
import kotli.engine.model.LayerTypes
import kotli.engine.template.rule.RenamePackage
import kotli.engine.template.rule.ReplaceMarkedText
import kotli.template.multiplatform.compose.dataflow.analytics.AnalyticsProvider
import kotli.template.multiplatform.compose.dataflow.common.CommonDataFlowProvider
import kotli.template.multiplatform.compose.dataflow.config.ConfigProvider
import kotli.template.multiplatform.compose.dataflow.http.HttpProvider
import kotli.template.multiplatform.compose.dataflow.keyvalue.KeyValueProvider
import kotli.template.multiplatform.compose.dataflow.keyvalue.settings.SettingsKeyValueProcessor
import kotli.template.multiplatform.compose.dataflow.paging.PagingProvider
import kotli.template.multiplatform.compose.essentials.buildtool.BuildToolProvider
import kotli.template.multiplatform.compose.essentials.design.DesignSystemProvider
import kotli.template.multiplatform.compose.essentials.di.DependencyInjectionProvider
import kotli.template.multiplatform.compose.essentials.navigation.NavigationProvider
import kotli.template.multiplatform.compose.essentials.toolkit.ToolkitProvider
import kotli.template.multiplatform.compose.platform.PlatformProvider
import kotli.template.multiplatform.compose.platform.android.AndroidPlatformProcessor
import kotli.template.multiplatform.compose.platform.ios.IOSPlatformProcessor
import kotli.template.multiplatform.compose.showcases.ShowcasesProvider
import kotli.template.multiplatform.compose.testing.logging.LoggingProvider
import kotli.template.multiplatform.compose.testing.logging.kermit.KermitProcessor
import kotli.template.multiplatform.compose.userflow.loader.LoaderProvider
import kotli.template.multiplatform.compose.userflow.loader.data.DataLoaderProcessor
import kotli.template.multiplatform.compose.userflow.navigation.NavigationBarProvider
import kotli.template.multiplatform.compose.userflow.theme.ThemeProvider
import kotli.template.multiplatform.compose.userflow.theme.change.ChangeThemeProcessor
import kotli.template.multiplatform.compose.userflow.theme.save.SaveThemeProcessor
import kotli.template.multiplatform.compose.userflow.theme.toggle.ToggleThemeProcessor

object MultiplatformComposeTemplateProcessor : BaseTemplateProcessor() {

    const val ID = "template-multiplatform-compose"

    override fun getId(): String = ID
    override fun getType(): LayerType = LayerTypes.Multiplatform
    override fun getWebUrl(): String = "https://github.com/kotlitecture/template-multiplatform-compose"

    override fun createPresets(): List<Layer> = listOf(
        createPreset(
            features = listOf(
                Feature(IOSPlatformProcessor.ID),
                Feature(AndroidPlatformProcessor.ID),
                Feature(SettingsKeyValueProcessor.ID),
                Feature(DataLoaderProcessor.ID),
                Feature(SaveThemeProcessor.ID),
                Feature(ChangeThemeProcessor.ID),
                Feature(ToggleThemeProcessor.ID),
                Feature(KermitProcessor.ID),
            )
        )
    )

    override fun createProviders(): List<FeatureProvider> = listOf(
        // essentials
        ToolkitProvider,
        NavigationProvider,
        DesignSystemProvider,
        DependencyInjectionProvider,
        BuildToolProvider,

        // platform
        PlatformProvider,

        // dataflow
        CommonDataFlowProvider,
        AnalyticsProvider,
        ConfigProvider,
        KeyValueProvider,
        HttpProvider,
        PagingProvider,

        // userflow
        NavigationBarProvider,
        ThemeProvider,
        LoaderProvider,

        LoggingProvider,

        // showcases
        ShowcasesProvider,
    )

    override fun processBefore(state: TemplateState) {
        state.onApplyRules(
            Rules.IndexHtml,
            ReplaceMarkedText(
                text = "Template",
                marker = "title",
                replacer = state.layer.name,
                singleLine = true
            )
        )
        state.onApplyRules(
            Rules.StringsXml,
            ReplaceMarkedText(
                text = "Template",
                marker = "app_name",
                replacer = state.layer.name,
                singleLine = true
            )
        )
        state.onApplyRules(
            Rules.IosConfig,
            ReplaceMarkedText(
                text = "app",
                marker = "BUNDLE_ID",
                replacer = state.layer.namespace,
                singleLine = true
            ),
            ReplaceMarkedText(
                text = "Template",
                marker = "APP_NAME",
                replacer = state.layer.name,
                singleLine = true
            )
        )
        state.onApplyRules(
            Rules.BuildGradleComposeApp,
            ReplaceMarkedText(
                text = "kotli.app",
                marker = "kotli.app",
                replacer = state.layer.namespace
            )
        )
        state.onApplyRules(
            Rules.SettingsGradle,
            ReplaceMarkedText(
                text = "template",
                marker = "rootProject.name",
                replacer = normalizeRootName(state.layer.name),
                singleLine = true
            )
        )
        state.onApplyRules(
            Rules.ProguardRulesPro,
            ReplaceMarkedText(
                text = "kotli.app",
                marker = "kotli.app",
                replacer = state.layer.namespace
            )
        )
    }

    override fun processAfter(state: TemplateState) {
        state.onApplyRules(
            "${Rules.CommonAppSrcDir}/*.kt",
            ReplaceMarkedText(
                text = "import template.composeapp.",
                marker = "import template.composeapp.",
                replacer = "import ${normalizeRootName(state.layer.name)}.composeapp."
            )
        )
        renamePackage(state, "${Rules.CommonAppSrcDir}/androidMain/kotlin")
        renamePackage(state, "${Rules.CommonAppSrcDir}/commonMain/kotlin")
        renamePackage(state, "${Rules.CommonAppSrcDir}/iosMain/kotlin")
        renamePackage(state, "${Rules.CommonAppSrcDir}/jsMain/kotlin")
        renamePackage(state, "${Rules.CommonAppSrcDir}/jvmMain/kotlin")
    }

    private fun renamePackage(state: TemplateState, root: String) {
        state.onApplyRules(
            root,
            RenamePackage(
                "kotli.app",
                state.layer.namespace
            )
        )
    }

    private fun normalizeRootName(name: String): String {
        return name.lowercase()
            .replace("_", "")
            .replace("-", "")
            .replace(".", "")
    }

}