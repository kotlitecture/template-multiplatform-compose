package kotli.template.multiplatform.compose.testing.development.hotreload

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.model.FeatureTags
import kotli.template.multiplatform.compose.Tags
import kotli.template.multiplatform.compose.platform.client.jvm.JvmPlatformProcessor
import kotlin.reflect.KClass
import kotlin.time.Duration.Companion.minutes

object HotReloadProcessor : BaseFeatureProcessor() {

    const val ID = "testing.development.hotreload"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = listOf(FeatureTags.Desktop)
    override fun getWebUrl(state: TemplateState): String = "https://github.com/JetBrains/compose-hot-reload"
    override fun getIntegrationUrl(state: TemplateState): String = "https://github.com/JetBrains/compose-hot-reload?tab=readme-ov-file#getting-started"
    override fun getIntegrationEstimate(state: TemplateState): Long = 30.minutes.inWholeMilliseconds

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        JvmPlatformProcessor::class
    )
}