package kotli.template.multiplatform.compose.dataflow.ai.gemini

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotlin.time.Duration.Companion.hours

object GeminiProcessor : BaseFeatureProcessor() {

    const val ID = "dataflow.ai.gemini"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getIntegrationEstimate(state: TemplateState): Long = 1.hours.inWholeMilliseconds

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.AiSource,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.BuildGradleApp,
            RemoveMarkedLine("generativeai")
        )
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("generativeai")
            )
        )
        state.onApplyRules(
            Rules.DIKt,
            RemoveMarkedLine("aiSource")
        )

        state.onApplyRules(
            Rules.ShowcasesKt,
            RemoveMarkedLine("Gemini"),
            RemoveMarkedLine("Dataflow :: AI"),
        )
        state.onApplyRules(
            Rules.ShowcasesAiDir,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppModuleKt,
            RemoveMarkedLine("GeminiViewModel")
        )
    }

}