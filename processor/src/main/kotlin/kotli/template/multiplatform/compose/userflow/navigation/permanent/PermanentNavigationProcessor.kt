package kotli.template.multiplatform.compose.userflow.navigation.permanent

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.rule.ReplaceMarkedText
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotlin.time.Duration.Companion.hours

object PermanentNavigationProcessor : BaseFeatureProcessor() {

    const val ID = "userflow.navigation.permanent"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getIntegrationEstimate(state: TemplateState): Long = 2.hours.inWholeMilliseconds

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.AppNavigationProvider,
            ReplaceMarkedText(
                "AdaptiveProvider",
                "AdaptiveProvider",
                "PermanentProvider"
            )
        )
    }

}