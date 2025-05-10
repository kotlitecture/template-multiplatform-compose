package kotli.template.multiplatform.compose.dataflow.paging.multiplatform

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotlin.time.Duration.Companion.minutes

object MultiplatformPagingProcessor : BaseFeatureProcessor() {

    const val ID = "dataflow.paging.multiplatform"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getWebUrl(state: TemplateState): String = "https://github.com/cashapp/multiplatform-paging"
    override fun getIntegrationUrl(state: TemplateState): String =
        "https://github.com/cashapp/multiplatform-paging?tab=readme-ov-file#usage"

    override fun getIntegrationEstimate(state: TemplateState): Long = 30.minutes.inWholeMilliseconds

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("cashapp-paging")
            )
        )
        state.onApplyRules(
            Rules.AppCommonConfigKt,
            RemoveMarkedLine("MultiplatformPagingSource")
        )
        state.onApplyRules(
            Rules.PresentationBuildGradle,
            RemoveMarkedLine("cashapp.paging")
        )
        state.onApplyRules(
            Rules.DataBuildGradle,
            RemoveMarkedLine("cashapp.paging")
        )
        state.onApplyRules(
            "*/paging/multiplatform/*",
            RemoveFile()
        )
    }

}