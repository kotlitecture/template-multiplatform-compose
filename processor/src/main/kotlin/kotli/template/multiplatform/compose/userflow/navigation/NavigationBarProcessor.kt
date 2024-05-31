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
            Rules.AppScreenKt,
            CleanupMarkedLine("{userflow.navigation}")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.AppDIKt,
            RemoveMarkedLine("ProvidesNavigationBarState")
        )
        state.onApplyRules(
            Rules.AppScreenKt,
            RemoveMarkedLine("{userflow.navigation}"),
            RemoveMarkedLine("NavigationBarProvider"),
            ReplaceMarkedText(
                marker = "        ",
                text = "        ",
                replacer = "    "
            )
        )
        state.onApplyRules(
            Rules.UserFlowNavigationDir,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.ProvidesNavigationBarStateKt,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.ProvidesNavigationStateKt,
            RemoveMarkedLine("NavigationADestination"),
            RemoveMarkedLine("NavigationBDestination"),
            RemoveMarkedLine("NavigationCDestination"),
            RemoveMarkedLine("ic_nav_a"),
            RemoveMarkedLine("ic_nav_b"),
            RemoveMarkedLine("ic_nav_c"),
        )
        state.onApplyRules(
            Rules.AppKt,
            RemoveMarkedLine("NavigationAViewModel"),
            RemoveMarkedLine("NavigationBViewModel"),
            RemoveMarkedLine("NavigationCViewModel"),
            RemoveMarkedLine("NavigationBarViewModel")
        )
        state.onApplyRules(
            "${Rules.CommonAppMainDrawableDir}/ic_nav_a.svg",
            RemoveFile()
        )
        state.onApplyRules(
            "${Rules.CommonAppMainDrawableDir}/ic_nav_b.svg",
            RemoveFile()
        )
        state.onApplyRules(
            "${Rules.CommonAppMainDrawableDir}/ic_nav_c.svg",
            RemoveFile()
        )
    }

}