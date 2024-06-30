package kotli.template.multiplatform.compose.userflow.navigation.adaptive

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.engine.template.rule.ReplaceMarkedText
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.userflow.navigation.NavigationBarProcessor
import kotli.template.multiplatform.compose.userflow.navigation.bottom.BottomNavigationProcessor
import kotli.template.multiplatform.compose.userflow.navigation.dismissible.DismissibleNavigationProcessor
import kotli.template.multiplatform.compose.userflow.navigation.modal.ModalNavigationProcessor
import kotli.template.multiplatform.compose.userflow.navigation.permanent.PermanentNavigationProcessor
import kotli.template.multiplatform.compose.userflow.navigation.rail.RailNavigationProcessor
import kotlin.time.Duration.Companion.hours

object AdaptiveNavigationProcessor : BaseFeatureProcessor() {

    const val ID = "userflow.navigation.adaptive"

    override fun getId(): String = ID
    override fun getIntegrationEstimate(state: TemplateState): Long = 2.hours.inWholeMilliseconds

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        NavigationBarProcessor::class.java,
        BottomNavigationProcessor::class.java,
        DismissibleNavigationProcessor::class.java,
        ModalNavigationProcessor::class.java,
        PermanentNavigationProcessor::class.java,
        RailNavigationProcessor::class.java
    )

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.AppNavigationBarProvider,
            ReplaceMarkedText(
                "content()",
                "content()",
                "AdaptiveProvider(content)"
            )
        )
        state.onApplyRules(
            Rules.AppScreenKt,
            RemoveMarkedLine("BottomProvider")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.AppNavigationAdaptiveProvider,
            RemoveFile()
        )
    }

}