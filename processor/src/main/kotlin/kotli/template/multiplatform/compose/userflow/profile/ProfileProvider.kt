package kotli.template.multiplatform.compose.userflow.profile

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.userflow.BaseUserFlowProvider
import kotli.template.multiplatform.compose.userflow.profile.basic.BasicProfileProcessor

object ProfileProvider : BaseUserFlowProvider() {

    override fun getId(): String = "userflow.profile"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        BasicProfileProcessor
    )
}