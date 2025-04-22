package kotli.template.multiplatform.compose

import kotli.engine.BaseTemplateProcessor
import kotli.engine.FeatureProvider
import kotli.engine.LayerType
import kotli.engine.TemplateState
import kotli.engine.model.Feature
import kotli.engine.model.Layer
import kotli.engine.model.LayerTypes
import kotli.engine.provider.documentation.DocumentationProvider
import kotli.engine.provider.documentation.readme.ReadmeProcessor
import kotli.engine.template.rule.RenamePackage
import kotli.engine.template.rule.ReplaceMarkedText
import kotli.template.multiplatform.compose.common.CommonProvider
import kotli.template.multiplatform.compose.dataflow.ai.AiProvider
import kotli.template.multiplatform.compose.dataflow.analytics.AnalyticsProvider
import kotli.template.multiplatform.compose.dataflow.cache.CacheProvider
import kotli.template.multiplatform.compose.dataflow.common.CommonDataFlowProvider
import kotli.template.multiplatform.compose.dataflow.config.ConfigProvider
import kotli.template.multiplatform.compose.dataflow.database.DatabaseProvider
import kotli.template.multiplatform.compose.dataflow.encryption.EncryptionProvider
import kotli.template.multiplatform.compose.dataflow.expression.ExpressionProvider
import kotli.template.multiplatform.compose.dataflow.http.HttpProvider
import kotli.template.multiplatform.compose.dataflow.paging.PagingProvider
import kotli.template.multiplatform.compose.dataflow.settings.SettingsProvider
import kotli.template.multiplatform.compose.essentials.buildtool.BuildToolProvider
import kotli.template.multiplatform.compose.essentials.design.DesignSystemProvider
import kotli.template.multiplatform.compose.essentials.di.DependencyInjectionProvider
import kotli.template.multiplatform.compose.essentials.navigation.NavigationProvider
import kotli.template.multiplatform.compose.essentials.toolkit.ToolkitProvider
import kotli.template.multiplatform.compose.guides.samples.SamplesProvider
import kotli.template.multiplatform.compose.guides.templates.TemplatesProvider
import kotli.template.multiplatform.compose.platform.client.ClientPlatformProvider
import kotli.template.multiplatform.compose.platform.client.android.AndroidPlatformProcessor
import kotli.template.multiplatform.compose.platform.client.ios.IOSPlatformProcessor
import kotli.template.multiplatform.compose.platform.client.jvm.JvmPlatformProcessor
import kotli.template.multiplatform.compose.platform.server.ServerPlatformProvider
import kotli.template.multiplatform.compose.platform.shared.SharedPlatformProvider
import kotli.template.multiplatform.compose.showcases.ShowcasesProvider
import kotli.template.multiplatform.compose.testing.logging.LoggingProvider
import kotli.template.multiplatform.compose.userflow.auth.AuthProvider
import kotli.template.multiplatform.compose.userflow.common.component.ComponentProvider
import kotli.template.multiplatform.compose.userflow.navigation.NavigationBarProvider
import kotli.template.multiplatform.compose.userflow.passcode.PasscodeProvider
import kotli.template.multiplatform.compose.userflow.profile.ProfileProvider
import kotli.template.multiplatform.compose.userflow.theme.ThemeProvider

object MultiplatformComposeTemplateProcessor : BaseTemplateProcessor() {

    const val ID = "template-multiplatform-compose"

    override fun getId(): String = ID
    override fun getType(): LayerType = LayerTypes.Multiplatform
    override fun getWebUrl(): String =
        "https://github.com/realAleksha/template-multiplatform-compose"

    override fun createPresets(): List<Layer> = listOf(
        createPreset(
            features = listOf(
                Feature(IOSPlatformProcessor.ID),
                Feature(AndroidPlatformProcessor.ID),
                Feature(JvmPlatformProcessor.ID),
                Feature(ReadmeProcessor.getId())
            )
        )
    )

    override fun createProviders(): List<FeatureProvider> = listOf(
        // common
        CommonProvider,

        // essentials
        ToolkitProvider,
        NavigationProvider,
        DesignSystemProvider,
        DependencyInjectionProvider,
        BuildToolProvider,

        // platform
        ClientPlatformProvider,
        ServerPlatformProvider,
        SharedPlatformProvider,

        // dataflow
        CommonDataFlowProvider,
        SettingsProvider,
        EncryptionProvider,
        ExpressionProvider,
        CacheProvider,
        ConfigProvider,
        DatabaseProvider,
        HttpProvider,
        PagingProvider,
        AnalyticsProvider,
        AiProvider,

        // userflow
        NavigationBarProvider,
        ThemeProvider,
        AuthProvider,
        PasscodeProvider,
        ProfileProvider,
        ComponentProvider,

        // testing
        LoggingProvider,

        // guides
        DocumentationProvider,
        SamplesProvider,
        TemplatesProvider,

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
            Rules.AppBuildGradle,
            ReplaceMarkedText(
                text = "kotli.app",
                marker = "kotli.app",
                replacer = state.layer.namespace
            )
        )
        state.onApplyRules(
            Rules.RootSettingsGradle,
            ReplaceMarkedText(
                text = "template",
                marker = "rootProject.name",
                replacer = normalizeRootName(state.layer.name),
                singleLine = true
            )
        )
        state.onApplyRules(
            Rules.AppProguardRulesPro,
            ReplaceMarkedText(
                text = "kotli.app",
                marker = "kotli.app",
                replacer = state.layer.namespace
            )
        )
    }

    override fun processAfter(state: TemplateState) {
        val name = normalizeRootName(state.layer.name)
        state.onApplyRules(
            "${Rules.AppSrc}/*.kt",
            ReplaceMarkedText(
                text = "import template.app.",
                marker = "import template.app.",
                replacer = "import ${name}.app."
            )
        )
        state.onApplyRules(
            Rules.PresentationIconsKt,
            ReplaceMarkedText(
                text = "import template.",
                marker = "import template.",
                replacer = "import ${name}."
            )
        )
        state.onApplyRules(
            "${Rules.BackendSrc}/*.yaml",
            ReplaceMarkedText(
                text = "kotli.app.",
                marker = "kotli.app.",
                replacer = "${state.layer.namespace}."
            )
        )
        renamePackage(state, "${Rules.AppSrc}/androidMain/kotlin")
        renamePackage(state, "${Rules.AppSrc}/commonMain/kotlin")
        renamePackage(state, "${Rules.AppSrc}/iosArm64Main/kotlin")
        renamePackage(state, "${Rules.AppSrc}/iosMain/kotlin")
        renamePackage(state, "${Rules.AppSrc}/iosSimulatorArm64Main/kotlin")
        renamePackage(state, "${Rules.AppSrc}/iosX64Main/kotlin")
        renamePackage(state, "${Rules.AppSrc}/jsMain/kotlin")
        renamePackage(state, "${Rules.AppSrc}/jvmMain/kotlin")
        renamePackage(state, "${Rules.AppSrc}/mobileAndDesktopMain/kotlin")
        renamePackage(state, "${Rules.BackendSrc}/main/kotlin")
        renamePackage(state, "${Rules.BackendSrc}/test/kotlin")
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