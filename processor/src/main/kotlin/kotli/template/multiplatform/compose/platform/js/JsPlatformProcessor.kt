package kotli.template.multiplatform.compose.platform.js

import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.platform.PlatformProcessor

object JsPlatformProcessor : PlatformProcessor() {

    const val ID = "platform.js"

    override fun getId(): String = ID

    override fun doRemove(state: TemplateState) {
        super.doRemove(state)
        state.onApplyRules(
            Rules.SrcJsMain,
            RemoveFile()
        )
    }

}