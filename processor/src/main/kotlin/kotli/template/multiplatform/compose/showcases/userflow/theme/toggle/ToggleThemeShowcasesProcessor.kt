package kotli.template.multiplatform.compose.showcases.userflow.theme.toggle

import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.showcases.BaseShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.userflow.theme.ThemeShowcasesProcessor

object ToggleThemeShowcasesProcessor : BaseShowcasesProcessor() {

    const val ID = "showcases.userflow.theme.toggle"

    override fun getId(): String = ID

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        ThemeShowcasesProcessor::class.java
    )

    override fun doRemove(state: TemplateState) {
        removeDir(state, "${Rules.AppShowcasesUserflow}/theme/toggle")
        removeFromConfig(state, "ToggleTheme")
        removeFromViewModel(state, "ToggleTheme")
    }

}