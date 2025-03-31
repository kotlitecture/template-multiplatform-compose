package kotli.template.multiplatform.compose.userflow.component.markdown

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.CleanupMarkedLine
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotli.template.multiplatform.compose.showcases.userflow.component.markdown.MarkdownShowcasesProcessor
import kotli.template.multiplatform.compose.userflow.component.image.coil.CoilProcessor
import kotlin.reflect.KClass
import kotlin.time.Duration.Companion.hours

object MarkdownProcessor : BaseFeatureProcessor() {

    const val ID = "userflow.component.markdown"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getIntegrationEstimate(state: TemplateState): Long = 1.hours.inWholeMilliseconds
    override fun getWebUrl(state: TemplateState): String =
        "https://github.com/mikepenz/multiplatform-markdown-renderer"

    override fun getIntegrationUrl(state: TemplateState): String =
        "https://github.com/mikepenz/multiplatform-markdown-renderer?tab=readme-ov-file#setup"

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        MarkdownShowcasesProcessor::class,
        CoilProcessor::class
    )

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.PresentationBuildGradle,
            CleanupMarkedLine("markdown")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.PresentationBuildGradle,
            RemoveMarkedLine("markdown")
        )

        state.onApplyRules(
            Rules.PresentationComponentMarkdown,
            RemoveFile()
        )

        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("markdown-renderer")
            )
        )
    }

}