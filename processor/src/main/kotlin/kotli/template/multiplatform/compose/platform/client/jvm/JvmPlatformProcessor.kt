package kotli.template.multiplatform.compose.platform.client.jvm

import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.platform.PlatformProcessor

object JvmPlatformProcessor : PlatformProcessor() {

    const val ID = "platform.jvm"

    override fun getId(): String = ID

    override fun doRemove(state: TemplateState) {
        super.doRemove(state)
        state.onApplyRules(
            Rules.SrcJvmMainDir,
            RemoveFile()
        )
    }

}