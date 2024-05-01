package kotli.template.multiplatform.compose.dataflow.analytics

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.dataflow.BaseDataFlowProvider
import kotli.template.multiplatform.compose.dataflow.analytics.facade.FacadeAnalyticsProcessor

object AnalyticsProvider : BaseDataFlowProvider() {

    override fun getId(): String = "dataflow.analytics"
    override fun isMultiple(): Boolean = true
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        FacadeAnalyticsProcessor
    )

}