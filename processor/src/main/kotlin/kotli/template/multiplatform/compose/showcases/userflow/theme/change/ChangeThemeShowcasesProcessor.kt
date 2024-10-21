package kotli.template.multiplatform.compose.showcases.userflow.theme.change

import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.showcases.BaseShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.userflow.theme.ThemeShowcasesProcessor

object ChangeThemeShowcasesProcessor : BaseShowcasesProcessor() {

    const val ID = "showcases.userflow.theme.change"

    override fun getId(): String = ID

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        ThemeShowcasesProcessor::class.java
    )

    override fun doRemove(state: TemplateState) {
        removeDir(state, "${Rules.AppShowcasesUserflow}/theme/change")
        removeFromConfig(state, "ChangeTheme")
        removeFromViewModel(state, "ChangeTheme")
    }

}