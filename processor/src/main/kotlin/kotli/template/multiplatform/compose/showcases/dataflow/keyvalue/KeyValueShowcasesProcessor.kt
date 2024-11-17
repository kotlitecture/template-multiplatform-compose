package kotli.template.multiplatform.compose.showcases.dataflow.settings

import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.showcases.BaseShowcasesProcessor

object SettingsShowcasesProcessor : BaseShowcasesProcessor() {

    const val ID = "showcases.datasource.settings"

    override fun getId(): String = ID

    override fun doRemove(state: TemplateState) {
        removeDir(state, "${Rules.AppShowcasesDataflow}/settings")
        removeFromConfig(state, "Settings")
        removeFromViewModel(state, "Settings")
    }

}