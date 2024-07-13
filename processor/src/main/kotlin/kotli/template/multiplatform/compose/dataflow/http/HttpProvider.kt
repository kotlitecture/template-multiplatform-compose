package kotli.template.multiplatform.compose.dataflow.http

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.dataflow.BaseDataFlowProvider
import kotli.template.multiplatform.compose.dataflow.config.facade.FacadeConfigProcessor
import kotli.template.multiplatform.compose.dataflow.http.ktor.KtorHttpProcessor
import kotli.template.multiplatform.compose.showcases.dataflow.http.HttpShowcasesProcessor

object HttpProvider : BaseDataFlowProvider() {

    override fun getId(): String = "dataflow.http"

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        HttpShowcasesProcessor::class.java,
        FacadeConfigProcessor::class.java
    )

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        KtorHttpProcessor
    )
}