package kotli.template.multiplatform.compose.platform.server.ktor

import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.platform.PlatformProcessor
import kotli.template.multiplatform.compose.platform.shared.SharedDomainProcessor
import kotlin.time.Duration.Companion.hours

object KtorBackendProcessor : PlatformProcessor() {

    const val ID = "platform.server.ktor"

    override fun getId(): String = ID
    override fun getWebUrl(state: TemplateState): String = "https://ktor.io"
    override fun getIntegrationUrl(state: TemplateState): String = "https://ktor.io/docs/server-create-a-new-project.html"
    override fun getIntegrationEstimate(state: TemplateState): Long = 1.hours.inWholeMilliseconds

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        SharedDomainProcessor::class.java
    )

    override fun doRemove(state: TemplateState) {
        super.doRemove(state)
        state.onApplyRules(
            Rules.BackendDir,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.BuildGradleRoot,
            RemoveMarkedLine("kotlin.jvm")
        )
        state.onApplyRules(
            Rules.SettingsGradle,
            RemoveMarkedLine("backend")
        )
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("logback"),
                RemoveMarkedLine("server"),
                RemoveMarkedLine("kotlin.jvm"),
                RemoveMarkedLine("ktor.plugin")
            )
        )
    }

}