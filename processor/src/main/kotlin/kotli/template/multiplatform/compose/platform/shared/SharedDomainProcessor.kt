package kotli.template.multiplatform.compose.platform.shared

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules

object SharedDomainProcessor : BaseFeatureProcessor() {

    const val ID = "platform.shared.domain"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.SharedDomainDir,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.BuildGradle,
            RemoveMarkedLine("shared.domain")
        )
        state.onApplyRules(
            Rules.SettingsGradle,
            RemoveMarkedLine("shared:domain")
        )
    }

}