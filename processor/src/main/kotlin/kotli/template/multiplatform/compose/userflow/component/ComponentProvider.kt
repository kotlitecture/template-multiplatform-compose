package kotli.template.multiplatform.compose.userflow.component

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.userflow.BaseUserFlowProvider
import kotli.template.multiplatform.compose.userflow.component.image.coil.CoilProcessor
import kotli.template.multiplatform.compose.userflow.component.markdown.MarkdownProcessor
import kotli.template.multiplatform.compose.userflow.component.placeholder.PlaceholderProcessor

object ComponentProvider : BaseUserFlowProvider() {

    override fun getId(): String = "userflow.component"
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        ComponentProcessor,
        PlaceholderProcessor,
        CoilProcessor,
        MarkdownProcessor
    )

}