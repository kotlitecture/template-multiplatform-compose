package kotli.template.multiplatform.compose.showcases.userflow.navigation

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules

object NavigationShowcasesProcessor : BaseFeatureProcessor() {

    const val ID = "showcases.navigation"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.ShowcasesKt,
            RemoveMarkedLine("Navigation")
        )
        state.onApplyRules(
            Rules.ShowcasesNavigationDir,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppKoinAppModuleKt,
            RemoveMarkedLine("ArgsNavigation")
        )
    }

}