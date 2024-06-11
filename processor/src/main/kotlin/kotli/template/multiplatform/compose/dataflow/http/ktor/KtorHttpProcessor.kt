package kotli.template.multiplatform.compose.dataflow.http.ktor

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotlin.time.Duration.Companion.hours

object KtorHttpProcessor : BaseFeatureProcessor() {

    const val ID = "dataflow.http.ktor"

    override fun getId(): String = ID
    override fun getWebUrl(state: TemplateState): String = "https://ktor.io"
    override fun getIntegrationUrl(state: TemplateState): String = "https://ktor.io/docs/client-create-new-application.html"

    override fun getIntegrationEstimate(state: TemplateState): Long = 2.hours.inWholeMilliseconds

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.HttpSource,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppDIKt,
            RemoveMarkedLine("HttpSource")
        )
        state.onApplyRules(
            Rules.AppConfigSource,
            RemoveMarkedLine("http_")
        )
        state.onApplyRules(
            Rules.BuildGradleSharedData,
            RemoveMarkedLine("ktor")
        )
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("ktor-client")
            )
        )
    }

}