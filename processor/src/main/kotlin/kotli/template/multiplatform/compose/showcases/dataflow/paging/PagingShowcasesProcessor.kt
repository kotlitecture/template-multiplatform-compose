package kotli.template.multiplatform.compose.showcases.dataflow.paging

import kotli.engine.TemplateState
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.showcases.BaseShowcasesProcessor

object PagingShowcasesProcessor : BaseShowcasesProcessor() {

    const val ID = "showcases.datasource.paging"

    override fun getId(): String = ID

    override fun doRemove(state: TemplateState) {
        removeDir(state, "${Rules.AppShowcasesDataflow}/paging")
        removeFromConfig(state, "Paging")
        removeFromViewModel(state, "Paging")
    }

}