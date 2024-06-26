package kotli.template.multiplatform.compose.essentials.di

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.essentials.di.koin.KoinProcessor
import kotli.template.multiplatform.compose.essentials.EssentialsProvider

object DependencyInjectionProvider : EssentialsProvider() {

    override fun getId(): String = "essentials.di"
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        KoinProcessor
    )

}