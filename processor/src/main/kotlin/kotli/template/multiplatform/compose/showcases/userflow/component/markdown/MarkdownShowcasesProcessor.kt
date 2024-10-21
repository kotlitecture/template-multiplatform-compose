package kotli.template.multiplatform.compose.showcases.userflow.component.markdown

import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.showcases.BaseShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.userflow.component.ComponentShowcasesProcessor

object MarkdownShowcasesProcessor : BaseShowcasesProcessor() {

    const val ID = "showcases.userflow.component.markdown"

    override fun getId(): String = ID

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        ComponentShowcasesProcessor::class.java
    )

    override fun doRemove(state: TemplateState) {
        removeDir(state, "${Rules.AppShowcasesUserflow}/component/markdown")
        removeFromConfig(state, "Markdown")
        removeFromViewModel(state, "Markdown")
    }

}