package kotli.template.multiplatform.compose.essentials.navigation

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.essentials.navigation.jetpack.JetpackProcessor
import kotli.template.multiplatform.compose.essentials.EssentialsProvider

object NavigationProvider : EssentialsProvider() {

    override fun getId(): String = "essentials.navigation"
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        JetpackProcessor
    )

}