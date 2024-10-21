package kotli.template.multiplatform.compose.showcases.userflow.component.placeholder

import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.showcases.BaseShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.userflow.component.ComponentShowcasesProcessor

object PlaceholderShowcasesProcessor : BaseShowcasesProcessor() {

    const val ID = "showcases.userflow.component.placeholder"

    override fun getId(): String = ID

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        ComponentShowcasesProcessor::class.java
    )

    override fun doRemove(state: TemplateState) {
        removeDir(state, "${Rules.AppShowcasesUserflow}/component/placeholder")
        removeFromConfig(state, "Placeholder")
        removeFromViewModel(state, "Placeholder")
    }

}