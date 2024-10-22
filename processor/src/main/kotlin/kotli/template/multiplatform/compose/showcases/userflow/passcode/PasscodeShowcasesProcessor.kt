package kotli.template.multiplatform.compose.showcases.userflow.passcode

import kotli.engine.TemplateState
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.showcases.BaseShowcasesProcessor

object PasscodeShowcasesProcessor : BaseShowcasesProcessor() {

    const val ID = "showcases.userflow.passcode"

    override fun getId(): String = ID

    override fun doRemove(state: TemplateState) {
        removeDir(state, "${Rules.AppShowcasesUserflow}/passcode")
        removeFromConfig(state, "Passcode")
        removeFromViewModel(state, "Passcode")
    }

}