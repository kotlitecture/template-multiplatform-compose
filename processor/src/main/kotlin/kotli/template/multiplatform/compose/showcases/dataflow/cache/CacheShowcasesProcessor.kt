package kotli.template.multiplatform.compose.showcases.dataflow.cache

import kotli.engine.TemplateState
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.showcases.BaseShowcasesProcessor

object CacheShowcasesProcessor : BaseShowcasesProcessor() {

    const val ID = "showcases.datasource.cache"

    override fun getId(): String = ID

    override fun doRemove(state: TemplateState) {
        removeDir(state, "${Rules.AppShowcasesDataflow}/cache")
        removeFromConfig(state, "Cache")
        removeFromViewModel(state, "Cache")
    }

}