package kotli.template.multiplatform.compose.showcases.feature.passcode

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules

object PasscodeShowcasesProcessor : BaseFeatureProcessor() {

    const val ID = "showcases.userflow.passcode"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.ShowcasesKt,
            RemoveMarkedLine("Passcode")
        )
        state.onApplyRules(
            Rules.ShowcasesPasscodeDir,
            RemoveFile()
        )
    }

}