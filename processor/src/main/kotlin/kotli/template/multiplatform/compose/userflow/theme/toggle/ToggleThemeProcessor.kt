package kotli.template.multiplatform.compose.userflow.theme.toggle

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.showcases.userflow.theme.toggle.ToggleThemeShowcasesProcessor
import kotli.template.multiplatform.compose.userflow.theme.save.SaveThemeProcessor
import kotlin.time.Duration.Companion.hours

object ToggleThemeProcessor : BaseFeatureProcessor() {

    const val ID = "userflow.theme.toggle"

    override fun getId(): String = ID
    override fun getIntegrationEstimate(state: TemplateState): Long = 1.hours.inWholeMilliseconds

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        SaveThemeProcessor::class.java,
        ToggleThemeShowcasesProcessor::class.java
    )

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.UserFlowThemeToggleDir,
            RemoveFile()
        )
    }

}