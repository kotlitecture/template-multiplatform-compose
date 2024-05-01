package kotli.template.multiplatform.compose.showcases.datasource.paging

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules

object PagingShowcasesProcessor : BaseFeatureProcessor() {

    const val ID = "showcases.datasource.paging"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.ShowcasesKt,
            RemoveMarkedLine("Paging")
        )
        state.onApplyRules(
            Rules.ShowcasesPagingDir,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppKt,
            RemoveMarkedLine("BasicPagingViewModel")
        )
    }

}