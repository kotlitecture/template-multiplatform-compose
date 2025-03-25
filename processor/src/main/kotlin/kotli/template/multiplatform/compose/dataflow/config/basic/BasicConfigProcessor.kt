package kotli.template.multiplatform.compose.dataflow.config.basic

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotlin.time.Duration.Companion.minutes

object BasicConfigProcessor : BaseFeatureProcessor() {

    const val ID = "dataflow.config.basic"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getIntegrationEstimate(state: TemplateState): Long = 30.minutes.inWholeMilliseconds

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.ConfigSource,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppCommonConfigKt,
            RemoveMarkedLine("ConfigSource")
        )
    }

}