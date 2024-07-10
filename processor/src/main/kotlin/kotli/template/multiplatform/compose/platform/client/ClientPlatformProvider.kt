package kotli.template.multiplatform.compose.platform.client

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureType
import kotli.template.multiplatform.compose.platform.PlatformType
import kotli.template.multiplatform.compose.platform.client.android.AndroidPlatformProcessor
import kotli.template.multiplatform.compose.platform.client.ios.IOSPlatformProcessor
import kotli.template.multiplatform.compose.platform.client.js.JsPlatformProcessor
import kotli.template.multiplatform.compose.platform.client.jvm.JvmPlatformProcessor

object ClientPlatformProvider : BaseFeatureProvider() {

    override fun getId(): String = "platform.client"
    override fun isRequired(): Boolean = true
    override fun isMultiple(): Boolean = true
    override fun getType(): FeatureType = PlatformType

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        IOSPlatformProcessor,
        AndroidPlatformProcessor,
        JvmPlatformProcessor,
        JsPlatformProcessor,
        MobileAndDesktopProcessor
    )

}