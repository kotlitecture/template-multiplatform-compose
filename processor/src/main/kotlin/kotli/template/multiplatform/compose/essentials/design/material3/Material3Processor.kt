package kotli.template.multiplatform.compose.essentials.design.material3

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotlin.time.Duration.Companion.hours

object Material3Processor : BaseFeatureProcessor() {

    const val ID = "essentials.design.material3"

    override fun getId(): String = ID
    override fun getWebUrl(state: TemplateState): String = "https://m3.material.io/"
    override fun getIntegrationUrl(state: TemplateState): String = "https://m3.material.io/develop"
    override fun getIntegrationEstimate(state: TemplateState): Long = 4.hours.inWholeMilliseconds
    override fun dependencies(): List<Class<out FeatureProcessor>> = emptyList()

}