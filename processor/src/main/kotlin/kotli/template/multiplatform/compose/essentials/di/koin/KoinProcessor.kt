package kotli.template.android.compose.essentials.di.hilt

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotlin.time.Duration.Companion.hours

class KoinProcessor : BaseFeatureProcessor() {

    override fun getId(): String = ID
    override fun getWebUrl(state: TemplateState): String = "https://insert-koin.io"
    override fun getIntegrationUrl(state: TemplateState): String = "https://insert-koin.io/docs/reference/koin-mp/kmp"
    override fun getIntegrationEstimate(state: TemplateState): Long = 1.hours.inWholeMilliseconds

    companion object {
        const val ID = "metadata.di.koin"
    }

}