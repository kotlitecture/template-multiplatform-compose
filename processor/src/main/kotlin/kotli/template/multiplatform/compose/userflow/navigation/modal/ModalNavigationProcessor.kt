package kotli.template.multiplatform.compose.userflow.navigation.modal

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.ReplaceMarkedText
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.userflow.navigation.adaptive.AdaptiveNavigationProcessor
import kotlin.time.Duration.Companion.hours

object ModalNavigationProcessor : BaseFeatureProcessor() {

    const val ID = "userflow.navigation.modal"

    override fun getId(): String = ID
    override fun getIntegrationEstimate(state: TemplateState): Long = 2.hours.inWholeMilliseconds

    override fun doApply(state: TemplateState) {
        if (state.getFeature(AdaptiveNavigationProcessor.ID) == null) {
            state.onApplyRules(
                Rules.AppNavigationBarProvider,
                ReplaceMarkedText(
                    "content()",
                    "content()",
                    "ModalProvider(content)"
                )
            )
        }
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.AppNavigationModalProvider,
            RemoveFile()
        )
    }

}