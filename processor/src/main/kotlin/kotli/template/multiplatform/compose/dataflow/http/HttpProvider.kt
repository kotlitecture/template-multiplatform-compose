package kotli.template.multiplatform.compose.dataflow.http

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.dataflow.BaseDataFlowProvider
import kotli.template.multiplatform.compose.dataflow.http.ktor.KtorHttpProcessor

object HttpProvider : BaseDataFlowProvider() {

    override fun getId(): String = "dataflow.http"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        KtorHttpProcessor
    )
}