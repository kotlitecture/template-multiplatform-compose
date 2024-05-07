package kotli.template.multiplatform.compose.showcases.feature.theme

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules

object ThemeShowcasesProcessor : BaseFeatureProcessor() {

    const val ID = "showcases.userflow.theme"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.ShowcasesKt,
            RemoveMarkedLine("Userflow :: Theme")
        )
    }

}