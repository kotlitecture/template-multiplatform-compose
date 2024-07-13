package kotli.template.multiplatform.compose.dataflow.common

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules

object CommonDataFlowProcessor : BaseFeatureProcessor() {

    const val ID = "dataflow.common"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.SharedDataDir,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.SettingsGradle,
            RemoveMarkedLine("shared:data")
        )
        state.onApplyRules(
            Rules.BuildGradle,
            RemoveMarkedLine("shared.data")
        )
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("kotlin-test =")
            )
        )
    }

}