package kotli.template.multiplatform.compose.platform.client

import kotli.engine.TemplateState
import kotli.engine.template.rule.CleanupMarkedBlock
import kotli.engine.template.rule.RemoveMarkedBlock
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.platform.PlatformProcessor

object MobileAndDesktopProcessor : PlatformProcessor() {

    const val ID = "platform.mobile_and_desktop"
    override fun isInternal(): Boolean = true

    override fun getId(): String = ID

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.BuildGradle,
            CleanupMarkedBlock("{platform.mobile_and_desktop.dependencies}")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.BuildGradle,
            RemoveMarkedBlock("{platform.mobile_and_desktop.dependencies}"),
            RemoveMarkedLine("mobileAndDesktopMain")
        )
    }

}