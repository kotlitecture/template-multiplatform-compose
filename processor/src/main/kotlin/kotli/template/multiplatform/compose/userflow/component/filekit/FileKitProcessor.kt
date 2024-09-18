package kotli.template.multiplatform.compose.userflow.component.filekit

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotli.template.multiplatform.compose.userflow.component.ComponentProcessor
import kotlin.time.Duration.Companion.minutes

object FileKitProcessor : BaseFeatureProcessor() {

    const val ID = "userflow.component.filekit"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getIntegrationEstimate(state: TemplateState): Long = 30.minutes.inWholeMilliseconds
    override fun getWebUrl(state: TemplateState): String = "https://github.com/vinceglb/FileKit"
    override fun getIntegrationUrl(state: TemplateState): String =
        "https://github.com/vinceglb/FileKit?tab=readme-ov-file#-quick-start"

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        ComponentProcessor::class.java
    )

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.BuildGradleSharedDesign,
            RemoveMarkedLine("filekit")
        )

        state.onApplyRules(
            Rules.AppFilePicker,
            RemoveFile()
        )

        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("filekit")
            )
        )

        state.onApplyRules(
            Rules.AppModuleKt,
            RemoveMarkedLine("FilePickerShowcaseViewModel")
        )

        state.onApplyRules(
            Rules.ShowcasesFilePickerDir,
            RemoveFile()
        )

        state.onApplyRules(
            Rules.ShowcasesKt,
            RemoveMarkedLine("FilePickerShowcase")
        )
    }

}