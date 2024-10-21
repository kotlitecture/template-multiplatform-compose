package kotli.template.multiplatform.compose.showcases.userflow.loader.data

import kotli.engine.TemplateState
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.showcases.BaseShowcasesProcessor

object DataLoaderShowcasesProcessor : BaseShowcasesProcessor() {

    const val ID = "showcases.datasource.loader.data"

    override fun getId(): String = ID

    override fun doRemove(state: TemplateState) {
        removeDir(state, "${Rules.AppShowcasesUserflow}/loader")
        removeFromConfig(state, "Loader")
        removeFromViewModel(state, "Loader")
    }

}