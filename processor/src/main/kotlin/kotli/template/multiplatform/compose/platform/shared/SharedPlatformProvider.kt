package kotli.template.multiplatform.compose.platform.shared

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureType
import kotli.template.multiplatform.compose.platform.PlatformType

object SharedPlatformProvider : BaseFeatureProvider() {

    override fun getId(): String = "platform.shared"
    override fun isRequired(): Boolean = false
    override fun isMultiple(): Boolean = false
    override fun getType(): FeatureType = PlatformType

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        SharedDomainProcessor
    )

}