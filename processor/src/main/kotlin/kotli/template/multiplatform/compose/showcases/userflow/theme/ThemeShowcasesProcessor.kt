package kotli.template.multiplatform.compose.showcases.userflow.theme

import kotli.engine.TemplateState
import kotli.template.multiplatform.compose.showcases.BaseShowcasesProcessor

object ThemeShowcasesProcessor : BaseShowcasesProcessor() {

    const val ID = "showcases.userflow.theme"

    override fun getId(): String = ID

    override fun doRemove(state: TemplateState) {
        removeFromViewModel(state, "Userflow :: Theme")
    }

}