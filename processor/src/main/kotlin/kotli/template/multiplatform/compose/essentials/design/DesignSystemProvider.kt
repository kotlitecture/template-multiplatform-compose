package kotli.template.multiplatform.compose.essentials.design

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.essentials.EssentialsProvider
import kotli.template.multiplatform.compose.essentials.design.material3.Material3Processor

object DesignSystemProvider : EssentialsProvider() {

    override fun getId(): String = "essentials.design"
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        Material3Processor
    )

}