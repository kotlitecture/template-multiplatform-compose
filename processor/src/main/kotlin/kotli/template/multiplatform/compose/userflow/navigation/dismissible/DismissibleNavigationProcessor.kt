package kotli.template.multiplatform.compose.userflow.navigation.dismissible

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.ReplaceMarkedText
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.userflow.navigation.adaptive.AdaptiveNavigationProcessor
import kotlin.time.Duration.Companion.hours

object DismissibleNavigationProcessor : BaseFeatureProcessor() {

    const val ID = "userflow.navigation.dismissible"

    override fun getId(): String = ID
    override fun getIntegrationEstimate(state: TemplateState): Long = 2.hours.inWholeMilliseconds

    override fun doApply(state: TemplateState) {
        if (state.getFeature(AdaptiveNavigationProcessor.ID) == null) {
            state.onApplyRules(
                Rules.UserFlowNavigationBarProvider,
                ReplaceMarkedText(
                    "content()",
                    "content()",
                    "DismissibleProvider(content)"
                )
            )
        }
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.UserFlowNavigationDismissibleProvider,
            RemoveFile()
        )
    }

}