package kotli.template.multiplatform.compose.common

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.CleanupMarkedBlock
import kotli.engine.template.rule.CleanupMarkedLine
import kotli.engine.template.rule.RemoveMarkedBlock
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules

object CommonKspProcessor : BaseFeatureProcessor() {

    override fun getId(): String = "common.ksp"
    override fun isInternal(): Boolean = true

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.AppBuildGradle,
            CleanupMarkedLine("{common.ksp}"),
            CleanupMarkedBlock("{common.ksp.config}")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("ksp")
            )
        )
        state.onApplyRules(
            Rules.AppBuildGradle,
            RemoveMarkedLine("{common.ksp}"),
            RemoveMarkedBlock("{common.ksp.config}")
        )
    }
}