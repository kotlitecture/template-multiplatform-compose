package kotli.template.multiplatform.compose.common

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.CleanupMarkedLine
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotlin.reflect.KClass

object CommonStatelyCollectionsProcessor : BaseFeatureProcessor() {

    override fun getId(): String = "common.stately-collections"
    override fun isInternal(): Boolean = true

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        CommonStatelyProcessor::class
    )

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.DataBuildGradle,
            CleanupMarkedLine("{common.stately-collections}")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.DataBuildGradle,
            RemoveMarkedLine("{common.stately-collections}")
        )
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("stately-concurrent-collections")
            )
        )
    }
}