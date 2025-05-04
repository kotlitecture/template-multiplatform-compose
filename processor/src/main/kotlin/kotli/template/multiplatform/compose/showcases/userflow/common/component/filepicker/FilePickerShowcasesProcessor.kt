package kotli.template.multiplatform.compose.showcases.userflow.common.component.filepicker

import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.showcases.BaseShowcasesProcessor
import kotli.template.multiplatform.compose.showcases.userflow.common.component.ComponentShowcasesProcessor
import kotlin.reflect.KClass

object FilePickerShowcasesProcessor : BaseShowcasesProcessor() {

    const val ID = "showcases.userflow.component.filepicker"

    override fun getId(): String = ID

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        ComponentShowcasesProcessor::class
    )

    override fun doRemove(state: TemplateState) {
        removeDir(state, "${Rules.AppShowcasesUserflow}/common/component/filepicker")
        removeFromConfig(state, "FilePicker")
        removeFromViewModel(state, "FilePicker")
    }

}