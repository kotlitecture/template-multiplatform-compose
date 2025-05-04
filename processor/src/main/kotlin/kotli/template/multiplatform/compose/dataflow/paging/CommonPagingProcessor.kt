package kotli.template.multiplatform.compose.dataflow.paging

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.template.multiplatform.compose.Rules

object CommonPagingProcessor : BaseFeatureProcessor() {

    const val ID = "dataflow.paging.common"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.PagingSourceDir,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.PagingSource,
            RemoveFile()
        )
    }

}