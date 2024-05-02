package kotli.template.multiplatform.compose.userflow

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureType
import kotli.engine.model.FeatureTypes

abstract class BaseUserFlowProvider : BaseFeatureProvider() {

    final override fun getType(): FeatureType = FeatureTypes.UserFlow
    final override fun dependencies(): List<Class<out FeatureProcessor>> = emptyList()

}