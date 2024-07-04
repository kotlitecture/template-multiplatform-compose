package kotli.template.multiplatform.compose.essentials.buildtool.gradle

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.model.FeatureTags
import kotli.template.multiplatform.compose.Tags
import kotlin.time.Duration.Companion.hours

object GradleProcessor : BaseFeatureProcessor() {

    const val ID = "essentials.buildtool.gradle"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = listOf(FeatureTags.Client, FeatureTags.Server)
    override fun getWebUrl(state: TemplateState): String = "https://gradle.org/"
    override fun getIntegrationUrl(state: TemplateState): String = "https://docs.gradle.org/current/samples/sample_building_kotlin_applications.html"

    override fun getIntegrationEstimate(state: TemplateState): Long = 2.hours.inWholeMilliseconds

}