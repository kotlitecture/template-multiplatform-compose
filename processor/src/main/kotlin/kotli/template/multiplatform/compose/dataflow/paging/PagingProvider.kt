package kotli.template.multiplatform.compose.dataflow.paging

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.dataflow.BaseDataFlowProvider
import kotli.template.multiplatform.compose.dataflow.config.facade.FacadeConfigProcessor
import kotli.template.multiplatform.compose.dataflow.paging.cashapp.CashAppPagingProcessor
import kotli.template.multiplatform.compose.showcases.datasource.paging.PagingShowcasesProcessor

object PagingProvider : BaseDataFlowProvider() {

    override fun getId(): String = "dataflow.paging"

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        FacadeConfigProcessor::class.java,
        PagingShowcasesProcessor::class.java
    )

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        CashAppPagingProcessor
    )

}