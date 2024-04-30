package kotli.template.multiplatform.compose.platform.js

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotlin.time.Duration.Companion.hours

object JsPlatformProcessor : BaseFeatureProcessor() {

    const val ID = "platform.js"

    override fun getId(): String = ID
    override fun getWebUrl(state: TemplateState): String = "https://www.jetbrains.com/lp/compose-multiplatform/"
    override fun getIntegrationUrl(state: TemplateState): String = "https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-multiplatform-getting-started.html"
    override fun getIntegrationEstimate(state: TemplateState): Long = 1.hours.inWholeMilliseconds
    override fun dependencies(): List<Class<out FeatureProcessor>> = emptyList()

}