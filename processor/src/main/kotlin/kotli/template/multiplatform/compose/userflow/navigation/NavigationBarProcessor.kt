package kotli.template.multiplatform.compose.userflow.navigation

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.CleanupMarkedLine
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.engine.template.rule.ReplaceMarkedText
import kotli.template.multiplatform.compose.Rules

object NavigationBarProcessor : BaseFeatureProcessor() {

    const val ID = "userflow.navigation"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.AppKt,
            CleanupMarkedLine("{userflow.navigation}")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.AppNavigation,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppCommonNavigation,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppConfigKt,
            RemoveMarkedLine("navigation("),
            RemoveMarkedLine("feature.navigation"),
        )
        state.onApplyRules(
            Rules.AppKt,
            RemoveMarkedLine("{userflow.navigation}"),
            RemoveMarkedLine("NavigationProvider"),
            ReplaceMarkedText(
                marker = "            ",
                text = "            ",
                replacer = "        "
            )
        )
    }

}