package kotli.template.multiplatform.compose.showcases.userflow.auth

import kotli.engine.TemplateState
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.showcases.BaseShowcasesProcessor

object AuthShowcasesProcessor : BaseShowcasesProcessor() {

    const val ID = "showcases.userflow.auth"

    override fun getId(): String = ID

    override fun doRemove(state: TemplateState) {
        removeDir(state, "${Rules.AppShowcasesUserflow}/auth")
        removeFromConfig(state, "Auth")
        removeFromViewModel(state, "Auth")
    }
}