package kotli.template.multiplatform.compose.showcases.dataflow.encryption

import kotli.engine.TemplateState
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.showcases.BaseShowcasesProcessor

object EncryptionShowcasesProcessor : BaseShowcasesProcessor() {

    const val ID = "showcases.datasource.encryption"

    override fun getId(): String = ID

    override fun doRemove(state: TemplateState) {
        removeDir(state, "${Rules.AppShowcasesDataflow}/encryption")
        removeFromConfig(state, "Encryption")
        removeFromViewModel(state, "Encryption")
    }

}