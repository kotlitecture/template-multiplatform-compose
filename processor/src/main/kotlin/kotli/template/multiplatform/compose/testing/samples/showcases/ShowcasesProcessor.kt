package kotli.template.multiplatform.compose.testing.samples.showcases

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.CleanupMarkedBlock
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedBlock
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.engine.template.rule.ReplaceMarkedText
import kotli.template.multiplatform.compose.Rules

object ShowcasesProcessor : BaseFeatureProcessor() {

    const val ID = "testings.samples.showcases"

    override fun getId(): String = ID

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.AppNavigationViewModel,
            CleanupMarkedBlock("{showcases}")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.AppShowcases,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppConfigKt,
            RemoveMarkedLine("showcases"),
        )
        state.onApplyRules(
            Rules.AppNavigationViewModel,
            RemoveMarkedBlock("{showcases}"),
            RemoveMarkedLine("Showcases"),
        )
        state.onApplyRules(
            Rules.AppViewModelKt,
            ReplaceMarkedText(
                text = "showcases.presentation.ShowcasesRoute",
                marker = "showcases.presentation.ShowcasesRoute",
                replacer = "home.presentation.HomeRoute"
            ),
            ReplaceMarkedText(
                text = "ShowcasesRoute",
                marker = "ShowcasesRoute",
                replacer = "HomeRoute"
            )
        )
    }

}