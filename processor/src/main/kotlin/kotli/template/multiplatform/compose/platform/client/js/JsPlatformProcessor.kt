package kotli.template.multiplatform.compose.platform.client.js

import kotli.engine.TemplateState
import kotli.engine.template.rule.CleanupMarkedBlock
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedBlock
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.platform.PlatformProcessor

object JsPlatformProcessor : PlatformProcessor() {

    const val ID = "platform.js"

    override fun getId(): String = ID

    override fun doApply(state: TemplateState) {
        super.doApply(state)
        state.onApplyRules(
            Rules.BuildGradleBackend,
            CleanupMarkedBlock(configBlock)
        )
    }

    override fun doRemove(state: TemplateState) {
        super.doRemove(state)
        state.onApplyRules(
            Rules.SrcJsMainDir,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.BuildGradleBackend,
            RemoveMarkedBlock(configBlock)
        )
        state.onApplyRules(
            Rules.AppWebPackConfigDir,
            RemoveFile()
        )
    }

}