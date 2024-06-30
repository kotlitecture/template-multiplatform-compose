package kotli.template.multiplatform.compose.userflow.theme.change

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.showcases.feature.theme.change.ChangeThemeShowcasesProcessor
import kotli.template.multiplatform.compose.userflow.theme.save.SaveThemeProcessor
import kotlin.time.Duration.Companion.hours

object ChangeThemeProcessor : BaseFeatureProcessor() {

    const val ID = "userflow.theme.change"

    override fun getId(): String = ID
    override fun getIntegrationEstimate(state: TemplateState): Long = 1.hours.inWholeMilliseconds

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        SaveThemeProcessor::class.java,
        ChangeThemeShowcasesProcessor::class.java
    )

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.NavigationModuleKt,
            RemoveMarkedLine("ChangeThemeDialogDestination"),
            RemoveMarkedLine("ChangeThemeDestination")
        )
        state.onApplyRules(
            Rules.AppModuleKt,
            RemoveMarkedLine("ChangeThemeViewModel")
        )
        state.onApplyRules(
            Rules.AppPresentationThemeChangeDir,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.StringsXml,
            RemoveMarkedLine("theme_change_")
        )
    }

}