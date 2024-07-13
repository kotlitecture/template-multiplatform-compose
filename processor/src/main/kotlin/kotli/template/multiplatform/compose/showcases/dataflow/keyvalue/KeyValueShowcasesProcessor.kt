package kotli.template.multiplatform.compose.showcases.dataflow.keyvalue

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules

object KeyValueShowcasesProcessor : BaseFeatureProcessor() {

    const val ID = "showcases.datasource.keyvalue"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.ShowcasesKt,
            RemoveMarkedLine("KeyValue")
        )
        state.onApplyRules(
            Rules.ShowcasesKeyValueDir,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppModuleKt,
            RemoveMarkedLine("KeyValueViewModel")
        )
    }

}