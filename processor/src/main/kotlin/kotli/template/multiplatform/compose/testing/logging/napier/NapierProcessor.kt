package kotli.template.multiplatform.compose.testing.logging.napier

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotlin.time.Duration.Companion.minutes

object NapierProcessor : BaseFeatureProcessor() {

    const val ID = "testing.logging.napier"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getWebUrl(state: TemplateState): String = "https://github.com/AAkira/Napier"
    override fun getIntegrationUrl(state: TemplateState): String = "https://github.com/AAkira/Napier?tab=readme-ov-file#common"

    override fun getIntegrationEstimate(state: TemplateState): Long = 15.minutes.inWholeMilliseconds

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.BuildGradleApp,
            RemoveMarkedLine("napier")
        )
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("napier")
            )
        )
    }

}