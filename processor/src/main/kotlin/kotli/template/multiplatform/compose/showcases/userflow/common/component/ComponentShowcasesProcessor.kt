package kotli.template.multiplatform.compose.showcases.userflow.common.component

import kotli.engine.TemplateState
import kotli.template.multiplatform.compose.showcases.BaseShowcasesProcessor

object ComponentShowcasesProcessor : BaseShowcasesProcessor() {

    const val ID = "showcases.userflow.component"

    override fun getId(): String = ID

    override fun doRemove(state: TemplateState) {
        removeFromViewModel(state, "User Flow :: Components")
    }

}