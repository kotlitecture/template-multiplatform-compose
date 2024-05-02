package kotli.template.multiplatform.compose.userflow.loader

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.userflow.BaseUserFlowProvider
import kotli.template.multiplatform.compose.userflow.loader.data.DataLoaderProcessor

object LoaderProvider : BaseUserFlowProvider() {

    override fun getId(): String = "userflow.loader"
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        DataLoaderProcessor
    )

}