package kotli.template.multiplatform.compose.showcases

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.CleanupMarkedBlock
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedBlock
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.engine.template.rule.ReplaceMarkedText
import kotli.template.multiplatform.compose.Rules

object ShowcasesProcessor : BaseFeatureProcessor() {

    const val ID = "showcases"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.ProvidesNavigationBarStateKt,
            CleanupMarkedBlock("{showcases}")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.ShowcasesDir,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.ProvidesNavigationStateKt,
            RemoveMarkedLine("ShowcasesDestination")
        )
        state.onApplyRules(
            Rules.AppKt,
            RemoveMarkedLine("ShowcasesViewModel")
        )
        state.onApplyRules(
            Rules.ProvidesNavigationBarStateKt,
            RemoveMarkedBlock("{showcases}"),
            RemoveMarkedLine("ShowcasesDestination")
        )
        state.onApplyRules(
            Rules.AppNavigationRouterKt,
            ReplaceMarkedText(
                text = "app.showcases.ShowcasesDestination",
                marker = "app.showcases.ShowcasesDestination",
                replacer = "app.ui.screen.template_no_args.TemplateNoArgsDestination"
            ),
            ReplaceMarkedText(
                text = "ShowcasesDestination",
                marker = "ShowcasesDestination",
                replacer = "TemplateNoArgsDestination"
            )
        )
    }

}