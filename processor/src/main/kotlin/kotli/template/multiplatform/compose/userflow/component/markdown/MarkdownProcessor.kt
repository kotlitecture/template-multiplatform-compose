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
import kotli.template.multiplatform.compose.userflow.component.ComponentProcessor
import kotlin.time.Duration.Companion.hours

object MarkdownProcessor : BaseFeatureProcessor() {

    const val ID = "userflow.component.markdown"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getIntegrationEstimate(state: TemplateState): Long = 1.hours.inWholeMilliseconds
    override fun getWebUrl(state: TemplateState): String = "https://github.com/mikepenz/multiplatform-markdown-renderer"
    override fun getIntegrationUrl(state: TemplateState): String = "https://github.com/mikepenz/multiplatform-markdown-renderer?tab=readme-ov-file#setup"

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        ComponentProcessor::class.java
    )

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.BuildGradleSharedDesign,
            CleanupMarkedLine("markdown")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.BuildGradleSharedDesign,
            RemoveMarkedLine("markdown")
        )

        state.onApplyRules(
            Rules.AppMarkdown,
            RemoveFile()
        )

        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("markdown-renderer")
            )
        )

        state.onApplyRules(
            Rules.AppKoinAppModuleKt,
            RemoveMarkedLine("MarkdownShowcaseViewModel")
        )

        state.onApplyRules(
            Rules.ShowcasesMarkdownDir,
            RemoveFile()
        )

        state.onApplyRules(
            Rules.ShowcasesKt,
            RemoveMarkedLine("MarkdownShowcase")
        )
    }

}