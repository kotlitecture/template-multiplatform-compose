package kotli.template.multiplatform.compose.userflow.theme

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.userflow.BaseUserFlowProvider
import kotli.template.multiplatform.compose.userflow.theme.change.ChangeThemeProcessor
import kotli.template.multiplatform.compose.userflow.theme.save.SaveThemeProcessor
import kotli.template.multiplatform.compose.userflow.theme.toggle.ToggleThemeProcessor

object ThemeProvider : BaseUserFlowProvider() {

    override fun getId(): String = "userflow.theme"
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        SaveThemeProcessor,
        ChangeThemeProcessor,
        ToggleThemeProcessor,
    )

}