package kotli.template.multiplatform.compose.dataflow.keyvalue.common

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.showcases.datasource.keyvalue.KeyValueShowcasesProcessor
import kotlin.time.Duration.Companion.minutes

object CommonKeyValueProcessor : BaseFeatureProcessor() {

    const val ID = "dataflow.keyvalue.common"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true
    override fun getIntegrationEstimate(state: TemplateState): Long = 30.minutes.inWholeMilliseconds

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        KeyValueShowcasesProcessor::class.java
    )

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.KeyValueSource,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppDIKt,
            RemoveMarkedLine("KeyValueSource")
        )
    }

}