package kotli.template.multiplatform.compose.showcases.dataflow.ai

import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.showcases.BaseShowcasesProcessor
import kotli.template.multiplatform.compose.userflow.common.component.markdown.MarkdownProcessor
import kotlin.reflect.KClass

object GeminiShowcasesProcessor : BaseShowcasesProcessor() {

    const val ID = "showcases.datasource.ai.gemini"

    override fun getId(): String = ID

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        MarkdownProcessor::class
    )

    override fun doRemove(state: TemplateState) {
        removeDir(state, "${Rules.AppShowcasesDataflow}/ai/gemini")
        removeFromConfig(state, "Gemini")
        removeFromViewModel(state, "Data Flow :: AI", "Gemini")
    }

}