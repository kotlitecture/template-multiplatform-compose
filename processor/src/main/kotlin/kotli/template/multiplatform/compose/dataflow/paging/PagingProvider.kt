package kotli.template.multiplatform.compose.dataflow.paging

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.dataflow.BaseDataFlowProvider
import kotli.template.multiplatform.compose.dataflow.paging.cashapp.CashAppPagingProcessor
import kotli.template.multiplatform.compose.showcases.dataflow.paging.PagingShowcasesProcessor

object PagingProvider : BaseDataFlowProvider() {

    override fun getId(): String = "dataflow.paging"

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        PagingShowcasesProcessor::class.java
    )

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        CashAppPagingProcessor
    )

}