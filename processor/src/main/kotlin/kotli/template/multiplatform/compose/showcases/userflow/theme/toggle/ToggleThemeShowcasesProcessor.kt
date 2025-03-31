package kotli.template.multiplatform.compose.showcases.userflow.theme.toggle

import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.showcases.BaseShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.userflow.theme.ThemeShowcasesProcessor
import kotlin.reflect.KClass

object ToggleThemeShowcasesProcessor : BaseShowcasesProcessor() {

    const val ID = "showcases.userflow.theme.toggle"

    override fun getId(): String = ID

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        ThemeShowcasesProcessor::class
    )

    override fun doRemove(state: TemplateState) {
        removeDir(state, "${Rules.AppShowcasesUserflow}/theme/toggle")
        removeFromConfig(state, "ToggleTheme")
        removeFromViewModel(state, "ToggleTheme")
    }

}