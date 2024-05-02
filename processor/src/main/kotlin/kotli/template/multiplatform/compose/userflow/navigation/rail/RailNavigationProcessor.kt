package kotli.template.multiplatform.compose.userflow.navigation.rail

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.ReplaceMarkedText
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.userflow.navigation.adaptive.AdaptiveNavigationProcessor
import kotlin.time.Duration.Companion.hours

object RailNavigationProcessor : BaseFeatureProcessor() {

    const val ID = "userflow.navigation.rail"

    override fun getId(): String = ID
    override fun getIntegrationEstimate(state: TemplateState): Long = 2.hours.inWholeMilliseconds

    override fun doApply(state: TemplateState) {
        if (state.getFeature(AdaptiveNavigationProcessor.ID) == null) {
            state.onApplyRules(
                Rules.UserFlowNavigationBarProvider,
                ReplaceMarkedText(
                    "content()",
                    "content()",
                    "RailProvider(content)"
                )
            )
        }
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.UserFlowNavigationRailProvider,
            RemoveFile()
        )
    }

}