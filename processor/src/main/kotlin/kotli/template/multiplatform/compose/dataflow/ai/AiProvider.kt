package kotli.template.multiplatform.compose.dataflow.ai

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.dataflow.BaseDataFlowProvider
import kotli.template.multiplatform.compose.dataflow.ai.gemini.GeminiProcessor

object AiProvider : BaseDataFlowProvider() {

    override fun getId(): String = "dataflow.ai"
    override fun isMultiple(): Boolean = true
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        GeminiProcessor
    )

}