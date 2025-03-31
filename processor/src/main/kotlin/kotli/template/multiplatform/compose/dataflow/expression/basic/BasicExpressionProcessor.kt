package kotli.template.multiplatform.compose.dataflow.expression.basic

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotli.template.multiplatform.compose.common.CommonStatelyCollectionsProcessor
import kotlin.reflect.KClass
import kotlin.time.Duration.Companion.hours

object BasicExpressionProcessor : BaseFeatureProcessor() {

    const val ID = "dataflow.expression.basic"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getIntegrationEstimate(state: TemplateState): Long = 1.hours.inWholeMilliseconds
    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        CommonStatelyCollectionsProcessor::class
    )

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.ExpressionSource,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.DataBuildGradle,
            RemoveMarkedLine("multiplatform.expressions.evaluator")
        )
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("multiplatform-expressions-evaluator")
            )
        )
    }

}