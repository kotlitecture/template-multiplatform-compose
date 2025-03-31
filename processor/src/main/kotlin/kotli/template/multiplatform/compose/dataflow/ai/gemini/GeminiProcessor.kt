package kotli.template.multiplatform.compose.dataflow.ai.gemini

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotli.template.multiplatform.compose.showcases.dataflow.ai.GeminiShowcasesProcessor
import kotlin.reflect.KClass
import kotlin.time.Duration.Companion.hours

object GeminiProcessor : BaseFeatureProcessor() {

    const val ID = "dataflow.ai.gemini"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getWebUrl(state: TemplateState): String = "https://github.com/PatilShreyas/generative-ai-kmp"
    override fun getIntegrationUrl(state: TemplateState): String =
        "https://github.com/PatilShreyas/generative-ai-kmp?tab=readme-ov-file#installation-and-usage"

    override fun getIntegrationEstimate(state: TemplateState): Long = 1.hours.inWholeMilliseconds

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        GeminiShowcasesProcessor::class
    )

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.AiSource,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.DataBuildGradle,
            RemoveMarkedLine("generativeai")
        )
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("generativeai")
            )
        )
        state.onApplyRules(
            Rules.AppCommonConfigKt,
            RemoveMarkedLine("ai")
        )
    }

}