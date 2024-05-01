package kotli.template.multiplatform.compose.platform.ios

import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.platform.PlatformProcessor

object IOSPlatformProcessor : PlatformProcessor() {

    const val ID = "platform.ios"

    override fun getId(): String = ID

    override fun doRemove(state: TemplateState) {
        super.doRemove(state)
        state.onApplyRules(
            Rules.SrcIosMainDir,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.IosAppDir,
            RemoveFile()
        )
    }

}