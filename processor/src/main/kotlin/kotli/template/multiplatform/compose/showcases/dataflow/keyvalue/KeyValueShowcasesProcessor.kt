package kotli.template.multiplatform.compose.showcases.dataflow.keyvalue

import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.showcases.BaseShowcasesProcessor

object KeyValueShowcasesProcessor : BaseShowcasesProcessor() {

    const val ID = "showcases.datasource.keyvalue"

    override fun getId(): String = ID

    override fun doRemove(state: TemplateState) {
        removeDir(state, "${Rules.AppShowcasesDataflow}/keyvalue")
        removeFromConfig(state, "KeyValue")
        removeFromViewModel(state, "KeyValue")
    }

}