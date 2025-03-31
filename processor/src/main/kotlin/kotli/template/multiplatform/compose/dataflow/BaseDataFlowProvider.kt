package kotli.template.multiplatform.compose.dataflow

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureType
import kotli.engine.model.FeatureTypes
import kotli.template.multiplatform.compose.dataflow.common.CommonDataFlowProcessor
import kotlin.reflect.KClass

abstract class BaseDataFlowProvider : BaseFeatureProvider() {

    final override fun getType(): FeatureType = FeatureTypes.DataFlow

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        CommonDataFlowProcessor::class
    )

}