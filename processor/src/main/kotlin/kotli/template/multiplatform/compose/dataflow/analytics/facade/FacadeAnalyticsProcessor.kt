package kotli.template.multiplatform.compose.dataflow.analytics.facade

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotlin.time.Duration.Companion.minutes

object FacadeAnalyticsProcessor : BaseFeatureProcessor() {

    const val ID = "dataflow.analytics.facade"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getIntegrationEstimate(state: TemplateState): Long = 30.minutes.inWholeMilliseconds

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.AnalyticsSource,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppDIKt,
            RemoveMarkedLine("AnalyticsSource")
        )
    }

}