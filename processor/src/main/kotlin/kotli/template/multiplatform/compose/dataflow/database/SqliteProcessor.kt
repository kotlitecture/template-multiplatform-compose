package kotli.template.multiplatform.compose.dataflow.database

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState

object SqliteProcessor : BaseFeatureProcessor() {

    const val ID = "dataflow.database.sqlite"
    override fun isInternal(): Boolean = true

    override fun getId(): String = ID

    override fun doApply(state: TemplateState) {

    }

    override fun doRemove(state: TemplateState) {

    }

}