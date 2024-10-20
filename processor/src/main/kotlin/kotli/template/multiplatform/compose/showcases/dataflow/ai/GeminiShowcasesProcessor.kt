package kotli.template.multiplatform.compose.showcases.dataflow.ai

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.userflow.component.markdown.MarkdownProcessor

object GeminiShowcasesProcessor : BaseFeatureProcessor() {

    const val ID = "showcases.datasource.ai.gemini"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        MarkdownProcessor::class.java
    )

    override fun doRemove(state: TemplateState) {
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
            Rules.AppKoinAppModuleKt,
            RemoveMarkedLine("GeminiViewModel")
        )
    }

}