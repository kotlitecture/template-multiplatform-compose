package kotli.template.android.compose.dataflow.cache

import kotli.engine.FeatureProcessor
import kotli.template.android.compose.dataflow.BaseDataFlowProvider
import kotli.template.android.compose.dataflow.cache.basic.BasicCacheProcessor

class CacheProvider : BaseDataFlowProvider() {

    override fun getId(): String = "dataflow.cache"
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        BasicCacheProcessor()
    )

}