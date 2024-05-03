package kotli.template.multiplatform.compose.essentials.buildtool

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.essentials.EssentialsProvider
import kotli.template.multiplatform.compose.essentials.buildtool.gradle.GradleProcessor

object BuildToolProvider : EssentialsProvider() {

    override fun getId(): String = "essentials.buildd"
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        GradleProcessor
    )

}