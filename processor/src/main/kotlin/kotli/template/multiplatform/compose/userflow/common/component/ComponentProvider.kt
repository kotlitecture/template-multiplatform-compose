package kotli.template.multiplatform.compose.userflow.common.component

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.userflow.BaseUserFlowProvider
import kotli.template.multiplatform.compose.userflow.common.component.filekit.FileKitProcessor
import kotli.template.multiplatform.compose.userflow.common.component.image.coil.CoilProcessor
import kotli.template.multiplatform.compose.userflow.common.component.markdown.MarkdownProcessor

object ComponentProvider : BaseUserFlowProvider() {

    override fun getId(): String = "userflow.component"
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        CoilProcessor,
        MarkdownProcessor,
        FileKitProcessor
    )

}