package kotli.template.multiplatform.compose.userflow.auth

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.userflow.BaseUserFlowProvider
import kotli.template.multiplatform.compose.userflow.auth.basic.BasicAuthProcessor

object AuthProvider : BaseUserFlowProvider() {

    override fun getId(): String = "userflow.auth"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        BasicAuthProcessor
    )

}