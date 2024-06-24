package kotli.template.multiplatform.compose.dataflow.cache

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.dataflow.BaseDataFlowProvider
import kotli.template.multiplatform.compose.dataflow.cache.basic.BasicCacheProcessor

object CacheProvider : BaseDataFlowProvider() {

    override fun getId(): String = "dataflow.cache"
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        BasicCacheProcessor
    )

}