package kotli.template.multiplatform.compose.dataflow.cache.basic

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.rule.CleanupMarkedLine
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotli.template.multiplatform.compose.common.CommonStatelyCollectionsProcessor
import kotli.template.multiplatform.compose.showcases.dataflow.cache.CacheShowcasesProcessor
import kotlin.time.Duration.Companion.hours

object BasicCacheProcessor : BaseFeatureProcessor() {

    const val ID = "dataflow.cache.basic"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getIntegrationEstimate(state: TemplateState): Long = 8.hours.inWholeMilliseconds
    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        CommonStatelyCollectionsProcessor::class.java,
        CacheShowcasesProcessor::class.java,
    )

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.BuildGradleSharedData,
            CleanupMarkedLine("{dataflow.cache.basic}")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.CacheSource,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppDiKt,
            RemoveMarkedLine("CacheSource")
        )
        state.onApplyRules(
            Rules.BuildGradleSharedData,
            RemoveMarkedLine("{dataflow.cache.basic}")
        )
    }

}