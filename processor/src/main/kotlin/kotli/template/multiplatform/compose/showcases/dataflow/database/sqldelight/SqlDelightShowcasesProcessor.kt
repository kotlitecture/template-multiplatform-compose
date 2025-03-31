package kotli.template.multiplatform.compose.showcases.dataflow.database.sqldelight

import kotli.engine.TemplateState
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.dataflow.paging.multiplatform.MultiplatformPagingProcessor
import kotli.template.multiplatform.compose.showcases.BaseShowcasesProcessor

object SqlDelightShowcasesProcessor : BaseShowcasesProcessor() {

    const val ID = "showcases.datasource.database.sqldelight"

    override fun getId(): String = ID

    override fun doApply(state: TemplateState) {
        if (state.getFeature(MultiplatformPagingProcessor.ID) != null) return

        removeDir(state, "${Rules.AppShowcasesDataflow}/sqldelight/paging")
        removeFromConfig(state, "SqlDelightPaging")
        removeFromViewModel(state, "SqlDelightPaging")
    }

    override fun doRemove(state: TemplateState) {
        removeDir(state, "${Rules.AppShowcasesDataflow}/sqldelight")
        removeFromConfig(state, "SqlDelight")
        removeFromViewModel(state, "SqlDelight")
    }

}