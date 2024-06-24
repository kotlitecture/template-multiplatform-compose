package kotli.template.multiplatform.compose.common

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureType
import kotli.engine.model.FeatureTypes

object CommonProvider : BaseFeatureProvider() {

    override fun getType(): FeatureType = FeatureTypes.Unspecified
    override fun getId(): String = "common"
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        CommonKtorProcessor,
        CommonStatelyProcessor
    )

}