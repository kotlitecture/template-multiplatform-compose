package kotli.template.multiplatform.compose.showcases.dataflow.http

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules

object HttpShowcasesProcessor : BaseFeatureProcessor() {

    const val ID = "showcases.datasource.http"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.ShowcasesKt,
            RemoveMarkedLine("Http")
        )
        state.onApplyRules(
            Rules.ShowcasesHttpDir,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppKoinAppModuleKt,
            RemoveMarkedLine("BasicHttpViewModel")
        )
    }

}