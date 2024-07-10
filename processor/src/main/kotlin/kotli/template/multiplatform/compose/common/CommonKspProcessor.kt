package kotli.template.multiplatform.compose.common

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState

object CommonKspProcessor : BaseFeatureProcessor() {

    override fun getId(): String = "common.ksp"
    override fun isInternal(): Boolean = true

    override fun doRemove(state: TemplateState) {

    }
}