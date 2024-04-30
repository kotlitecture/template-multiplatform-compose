package kotli.template.multiplatform.compose

import kotli.engine.BaseTemplateProcessor
import kotli.engine.FeatureProvider
import kotli.engine.LayerType
import kotli.engine.TemplateState
import kotli.engine.model.LayerTypes
import kotli.engine.template.rule.ReplaceMarkedText
import kotli.template.multiplatform.compose.essentials.build.BuildToolProvider
import kotli.template.multiplatform.compose.essentials.design.DesignSystemProvider
import kotli.template.multiplatform.compose.essentials.di.DependencyInjectionProvider
import kotli.template.multiplatform.compose.essentials.navigation.NavigationProvider
import kotli.template.multiplatform.compose.essentials.toolkit.ToolkitProvider

object MultiplatformComposeTemplateProcessor : BaseTemplateProcessor() {

    const val ID = "template-multiplatform-compose"

    override fun getId(): String = ID
    override fun getType(): LayerType = LayerTypes.Multiplatform
    override fun getWebUrl(): String = "https://github.com/kotlitecture/template-multiplatform-compose"

    override fun createProviders(): List<FeatureProvider> = listOf(
        // essentials
        ToolkitProvider,
        NavigationProvider,
        DesignSystemProvider,
        DependencyInjectionProvider,
        BuildToolProvider,
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
                marker = "applicationId",
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
    }

}