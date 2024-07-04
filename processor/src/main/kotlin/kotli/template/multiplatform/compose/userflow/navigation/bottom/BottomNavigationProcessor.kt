package kotli.template.multiplatform.compose.userflow.navigation.bottom

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotlin.time.Duration.Companion.hours

object BottomNavigationProcessor : BaseFeatureProcessor() {

    const val ID = "userflow.navigation.bottom"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getIntegrationEstimate(state: TemplateState): Long = 2.hours.inWholeMilliseconds

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.AppNavigationBottomProvider,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppScreenKt,
            RemoveMarkedLine("BottomProvider")
        )
    }

}