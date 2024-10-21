package kotli.template.multiplatform.compose.showcases.dataflow.http

import kotli.engine.TemplateState
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.showcases.BaseShowcasesProcessor

object HttpShowcasesProcessor : BaseShowcasesProcessor() {

    const val ID = "showcases.datasource.http"

    override fun getId(): String = ID

    override fun doRemove(state: TemplateState) {
        removeDir(state, "${Rules.AppShowcasesDataflow}/http")
        removeFromConfig(state, "Http")
        removeFromViewModel(state, "Http")
    }

}