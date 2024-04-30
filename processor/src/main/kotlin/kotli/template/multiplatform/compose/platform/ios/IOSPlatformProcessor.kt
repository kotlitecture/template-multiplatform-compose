package kotli.template.multiplatform.compose.platform.ios

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotlin.time.Duration.Companion.hours

object IOSPlatformProcessor : BaseFeatureProcessor() {

    const val ID = "platform.ios"

    override fun getId(): String = ID
    override fun getWebUrl(state: TemplateState): String = "https://www.jetbrains.com/lp/compose-multiplatform/"
    override fun getIntegrationUrl(state: TemplateState): String = "https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-multiplatform-getting-started.html"
    override fun getIntegrationEstimate(state: TemplateState): Long = 1.hours.inWholeMilliseconds
    override fun dependencies(): List<Class<out FeatureProcessor>> = emptyList()

}