package kotli.template.multiplatform.compose.platform.server

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureType
import kotli.template.multiplatform.compose.platform.PlatformType
import kotli.template.multiplatform.compose.platform.server.ktor.KtorBackendProcessor

object ServerPlatformProvider : BaseFeatureProvider() {

    override fun getId(): String = "platform.server"
    override fun isRequired(): Boolean = false
    override fun isMultiple(): Boolean = false
    override fun getType(): FeatureType = PlatformType

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        KtorBackendProcessor
    )

}