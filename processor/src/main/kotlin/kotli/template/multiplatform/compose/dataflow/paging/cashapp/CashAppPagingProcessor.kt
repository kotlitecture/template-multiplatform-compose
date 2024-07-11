package kotli.template.multiplatform.compose.dataflow.paging.cashapp

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotlin.time.Duration.Companion.minutes

object CashAppPagingProcessor : BaseFeatureProcessor() {

    const val ID = "dataflow.paging.jetpack"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getWebUrl(state: TemplateState): String = "https://github.com/cashapp/multiplatform-paging"
    override fun getIntegrationUrl(state: TemplateState): String = "https://github.com/cashapp/multiplatform-paging?tab=readme-ov-file#usage"
    override fun getIntegrationEstimate(state: TemplateState): Long = 30.minutes.inWholeMilliseconds

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("cashapp")
            )
        )
        state.onApplyRules(
            Rules.PagingSource,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppDIKt,
            RemoveMarkedLine("PagingSource")
        )
        state.onApplyRules(
            Rules.AppConfigSource,
            RemoveMarkedLine("paging_")
        )
        state.onApplyRules(
            Rules.BuildGradleSharedDesign,
            RemoveMarkedLine("cashapp")
        )
    }

}