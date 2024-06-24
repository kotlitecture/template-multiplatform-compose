package kotli.template.multiplatform.compose.showcases.datasource.cache

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules

object CacheShowcasesProcessor : BaseFeatureProcessor() {

    const val ID = "showcases.datasource.cache"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.ShowcasesKt,
            RemoveMarkedLine("Cache")
        )
        state.onApplyRules(
            Rules.ShowcasesCacheDir,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppKt,
            RemoveMarkedLine("BasicCacheViewModel")
        )
    }

}