package kotli.template.multiplatform.compose.common

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.RemoveMarkedLine

object CommonKtorProcessor : BaseFeatureProcessor() {

    override fun getId(): String = "common.ktor"
    override fun isInternal(): Boolean = true

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("ktor ="),
                RemoveMarkedLine("ktor-client"),
                RemoveMarkedLine("ktor-server"),
                RemoveMarkedLine("ktor-common"),
            )
        )
    }
}