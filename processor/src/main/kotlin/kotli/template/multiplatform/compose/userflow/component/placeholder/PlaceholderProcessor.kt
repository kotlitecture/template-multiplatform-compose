package kotli.template.multiplatform.compose.userflow.component.placeholder

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
import kotli.template.multiplatform.compose.showcases.userflow.component.placeholder.PlaceholderShowcasesProcessor
import kotlin.reflect.KClass
import kotlin.time.Duration.Companion.hours

object PlaceholderProcessor : BaseFeatureProcessor() {

    const val ID = "userflow.component.placeholder"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getIntegrationEstimate(state: TemplateState): Long = 1.hours.inWholeMilliseconds
    override fun getWebUrl(state: TemplateState): String =
        "https://github.com/eygraber/compose-placeholder"

    override fun getIntegrationUrl(state: TemplateState): String =
        "https://github.com/eygraber/compose-placeholder?tab=readme-ov-file#gradle"

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        PlaceholderShowcasesProcessor::class
    )

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.PresentationBuildGradle,
            CleanupMarkedLine("{userflow.component.placeholder}")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.PresentationBuildGradle,
            RemoveMarkedLine("{userflow.component.placeholder}")
        )

        state.onApplyRules(
            Rules.PresentationComponentPlaceholder,
            RemoveFile()
        )

        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("compose-placeholder")
            )
        )
    }

}