package kotli.template.multiplatform.compose.platform.android

import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.platform.PlatformProcessor

object AndroidPlatformProcessor : PlatformProcessor() {

    const val ID = "platform.android"

    override fun getId(): String = ID

    override fun doRemove(state: TemplateState) {
        super.doRemove(state)
        state.onApplyRules(
            Rules.SrcAndroidMain,
            RemoveFile()
        )
    }

}