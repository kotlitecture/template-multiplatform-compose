package kotli.template.multiplatform.compose.dataflow.settings.common

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.template.multiplatform.compose.Rules

object CommonSettingsProcessor : BaseFeatureProcessor() {

    const val ID = "dataflow.settings.common"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.SettingsSource,
            RemoveFile()
        )
    }

}