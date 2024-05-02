package kotli.template.multiplatform.compose

import kotli.engine.BaseTemplateProcessor
import kotli.engine.FeatureProvider
import kotli.engine.LayerType
import kotli.engine.TemplateState
import kotli.engine.model.Feature
import kotli.engine.model.Layer
import kotli.engine.model.LayerTypes
import kotli.engine.template.rule.ReplaceMarkedText
import kotli.template.multiplatform.compose.dataflow.analytics.AnalyticsProvider
import kotli.template.multiplatform.compose.dataflow.common.CommonDataFlowProvider
import kotli.template.multiplatform.compose.dataflow.config.ConfigProvider
import kotli.template.multiplatform.compose.dataflow.http.HttpProvider
import kotli.template.multiplatform.compose.dataflow.keyvalue.KeyValueProvider
import kotli.template.multiplatform.compose.dataflow.paging.PagingProvider
import kotli.template.multiplatform.compose.essentials.build.BuildToolProvider
import kotli.template.multiplatform.compose.essentials.design.DesignSystemProvider
import kotli.template.multiplatform.compose.essentials.di.DependencyInjectionProvider
import kotli.template.multiplatform.compose.essentials.navigation.NavigationProvider
import kotli.template.multiplatform.compose.essentials.toolkit.ToolkitProvider
import kotli.template.multiplatform.compose.platform.PlatformProvider
import kotli.template.multiplatform.compose.platform.android.AndroidPlatformProcessor
import kotli.template.multiplatform.compose.platform.ios.IOSPlatformProcessor
import kotli.template.multiplatform.compose.showcases.ShowcasesProvider
import kotli.template.multiplatform.compose.userflow.loader.LoaderProvider
import kotli.template.multiplatform.compose.userflow.theme.ThemeProvider

object MultiplatformComposeTemplateProcessor : BaseTemplateProcessor() {

    const val ID = "template-multiplatform-compose"

    override fun getId(): String = ID
    override fun getType(): LayerType = LayerTypes.Multiplatform
    override fun getWebUrl(): String =
        "https://github.com/kotlitecture/template-multiplatform-compose"

    override fun createPresets(): List<Layer> = listOf(
        createPreset(
            features = listOf(
                Feature(IOSPlatformProcessor.ID),
                Feature(AndroidPlatformProcessor.ID),
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
        ThemeProvider,
        LoaderProvider,

        // showcases
        ShowcasesProvider,
    )

    override fun processAfter(state: TemplateState) {
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
                marker = "applicationId",
                replacer = state.layer.namespace,
                singleLine = true
            ),
            ReplaceMarkedText(
                text = "app",
                marker = "packageName",
                replacer = state.layer.namespace,
                singleLine = true
            )
        )
        state.onApplyRules(
            Rules.SettingsGradle,
            ReplaceMarkedText(
                text = "template",
                marker = "rootProject.name",
                replacer = state.layer.name,
                singleLine = true
            )
        )
        state.onApplyRules(
            Rules.Kt,
            ReplaceMarkedText(
                text = "import template.",
                marker = "import template.",
                replacer = "import ${state.layer.name.lowercase()}."
            )
        )
    }

}