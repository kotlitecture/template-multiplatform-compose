package kotli.template.multiplatform.compose.dataflow.keyvalue.common

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.template.multiplatform.compose.Rules

object CommonKeyValueProcessor : BaseFeatureProcessor() {

    const val ID = "dataflow.keyvalue.common"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.KeyValueSource,
            RemoveFile()
        )
    }

}