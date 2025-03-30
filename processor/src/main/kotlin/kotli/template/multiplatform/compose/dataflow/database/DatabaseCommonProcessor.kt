package kotli.template.multiplatform.compose.dataflow.database

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules

object DatabaseCommonProcessor : BaseFeatureProcessor() {

    const val ID = "dataflow.database.common"
    override fun isInternal(): Boolean = true

    override fun getId(): String = ID

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.AppCommonDatabase,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppPlatformConfigKt,
            RemoveMarkedLine("DatabaseSource")
        )
    }

}