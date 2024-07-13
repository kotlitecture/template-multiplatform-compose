package kotli.template.multiplatform.compose.showcases.userflow.loader.data

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules

object DataLoaderShowcasesProcessor : BaseFeatureProcessor() {

    const val ID = "showcases.datasource.loader.data"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.ShowcasesKt,
            RemoveMarkedLine("Loader")
        )
        state.onApplyRules(
            Rules.ShowcasesLoaderDir,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppModuleKt,
            RemoveMarkedLine("DataLoaderShowcaseViewModel")
        )
    }

}