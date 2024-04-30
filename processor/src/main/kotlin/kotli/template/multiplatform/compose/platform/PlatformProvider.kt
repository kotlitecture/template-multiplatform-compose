package kotli.template.multiplatform.compose.platform

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureType
import kotli.template.multiplatform.compose.platform.android.AndroidPlatformProcessor
import kotli.template.multiplatform.compose.platform.ios.IOSPlatformProcessor
import kotli.template.multiplatform.compose.platform.js.JsPlatformProcessor
import kotli.template.multiplatform.compose.platform.jvm.JvmPlatformProcessor

object PlatformProvider : BaseFeatureProvider() {

    override fun getId(): String = "platform"
    override fun isRequired(): Boolean = true
    override fun isMultiple(): Boolean = false
    override fun getType(): FeatureType = PlatformType

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        IOSPlatformProcessor,
        AndroidPlatformProcessor,
        JvmPlatformProcessor,
        JsPlatformProcessor
    )

}