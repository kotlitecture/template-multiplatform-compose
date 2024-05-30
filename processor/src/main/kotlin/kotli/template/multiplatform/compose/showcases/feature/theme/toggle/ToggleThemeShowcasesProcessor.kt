package kotli.template.multiplatform.compose.showcases.feature.theme.toggle

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.showcases.feature.theme.ThemeShowcasesProcessor

object ToggleThemeShowcasesProcessor : BaseFeatureProcessor() {

    const val ID = "showcases.userflow.theme.toggle"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        ThemeShowcasesProcessor::class.java
    )

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            "${Rules.ShowcasesThemeDir}/toggle",
            RemoveFile()
        )
        state.onApplyRules(
            Rules.ShowcasesKt,
            RemoveMarkedLine("ToggleThemeShowcase")
        )
        state.onApplyRules(
            Rules.AppKt,
            RemoveMarkedLine("ToggleThemeViewModel")
        )
    }

}