package kotli.template.multiplatform.compose.essentials.design.material3

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.model.FeatureTags
import kotlin.reflect.KClass
import kotlin.time.Duration.Companion.hours

object Material3Processor : BaseFeatureProcessor() {

    const val ID = "essentials.design.material3"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = listOf(FeatureTags.Client)
    override fun getWebUrl(state: TemplateState): String = "https://m3.material.io/"
    override fun getIntegrationUrl(state: TemplateState): String = "https://m3.material.io/develop"
    override fun getIntegrationEstimate(state: TemplateState): Long = 4.hours.inWholeMilliseconds
    override fun dependencies(): List<KClass<out FeatureProcessor>> = emptyList()

}