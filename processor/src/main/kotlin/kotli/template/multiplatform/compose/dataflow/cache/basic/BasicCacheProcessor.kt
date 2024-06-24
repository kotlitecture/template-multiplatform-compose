package kotli.template.android.compose.dataflow.cache.basic

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotlin.time.Duration.Companion.hours

class BasicCacheProcessor : BaseFeatureProcessor() {

    override fun getId(): String = ID
    override fun getIntegrationEstimate(state: TemplateState): Long = 8.hours.inWholeMilliseconds

    override fun doRemove(state: TemplateState) {
        state.onApplyRules("core/data/src/main/kotlin/core/data/datasource/cache", RemoveFile())
        state.onApplyRules("*CacheSource*", RemoveFile())
    }

    companion object {
        const val ID = "dataflow.cache.basic"
    }

}