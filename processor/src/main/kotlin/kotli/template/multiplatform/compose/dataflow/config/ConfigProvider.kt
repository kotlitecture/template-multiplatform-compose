package kotli.template.multiplatform.compose.dataflow.config

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.dataflow.BaseDataFlowProvider
import kotli.template.multiplatform.compose.dataflow.config.facade.FacadeConfigProcessor

object ConfigProvider : BaseDataFlowProvider() {

    override fun getId(): String = "dataflow.config"
    override fun isMultiple(): Boolean = true
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        FacadeConfigProcessor
    )

}