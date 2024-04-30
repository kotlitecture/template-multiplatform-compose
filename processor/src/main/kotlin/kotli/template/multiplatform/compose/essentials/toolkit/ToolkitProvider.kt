package kotli.template.multiplatform.compose.essentials.toolkit

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.essentials.EssentialsProvider
import kotli.template.multiplatform.compose.essentials.toolkit.compose.ComposeProcessor

object ToolkitProvider : EssentialsProvider() {

    override fun getId(): String = "essentials.toolkit"
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        ComposeProcessor
    )

}