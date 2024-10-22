package kotli.template.multiplatform.compose.showcases.userflow.component.image

import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.showcases.BaseShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.userflow.component.ComponentShowcasesProcessor

object CoilShowcasesProcessor : BaseShowcasesProcessor() {

    const val ID = "showcases.userflow.component.image.coil"

    override fun getId(): String = ID

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        ComponentShowcasesProcessor::class.java
    )

    override fun doRemove(state: TemplateState) {
        removeDir(state, "${Rules.AppShowcasesUserflow}/component/image/coil")
        removeFromConfig(state, "Coil")
        removeFromViewModel(state, "Coil")
    }

}