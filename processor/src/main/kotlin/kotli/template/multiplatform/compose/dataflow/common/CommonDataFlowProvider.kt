package kotli.template.multiplatform.compose.dataflow.common

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureType
import kotli.engine.model.FeatureTypes

object CommonDataFlowProvider : BaseFeatureProvider() {

    override fun getId(): String = "dataflow.common"
    override fun getType(): FeatureType = FeatureTypes.DataFlow
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        CommonDataFlowProcessor
    )

}