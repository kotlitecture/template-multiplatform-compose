package kotli.template.multiplatform.compose.platform.client

import kotli.engine.TemplateState
import kotli.template.multiplatform.compose.platform.PlatformProcessor

object MobileAndDesktopProcessor : PlatformProcessor() {

    const val ID = "platform.mobile_and_desktop"
    override fun isInternal(): Boolean = true

    override fun getId(): String = ID

    override fun doRemove(state: TemplateState) {
        super.doRemove(state)
        error("TODO")
    }

}