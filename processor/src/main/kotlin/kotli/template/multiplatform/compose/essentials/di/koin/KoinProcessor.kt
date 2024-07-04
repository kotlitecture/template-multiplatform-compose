package kotli.template.multiplatform.compose.essentials.di.koin

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotlin.time.Duration.Companion.hours

object KoinProcessor : BaseFeatureProcessor() {

    const val ID = "essentials.di.koin"

    override fun getId(): String = ID
    override fun getWebUrl(state: TemplateState): String = "https://insert-koin.io"
    override fun getIntegrationUrl(state: TemplateState): String =
        "https://insert-koin.io/docs/reference/koin-mp/kmp"

    override fun getIntegrationEstimate(state: TemplateState): Long = 1.hours.inWholeMilliseconds

}