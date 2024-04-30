package kotli.template.multiplatform.compose.essentials.navigation.jetpack

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotlin.time.Duration.Companion.hours

object JetpackProcessor : BaseFeatureProcessor() {

    const val ID = "essentials.navigation.jetpack"

    override fun getId(): String = ID
    override fun getWebUrl(state: TemplateState): String = "https://developer.android.com/guide/navigation"
    override fun getIntegrationUrl(state: TemplateState): String = "https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-navigation-routing.html"
    override fun getIntegrationEstimate(state: TemplateState): Long = 4.hours.inWholeMilliseconds

}