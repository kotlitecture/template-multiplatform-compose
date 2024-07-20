package kotli.template.multiplatform.compose.dataflow.keyvalue

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.dataflow.BaseDataFlowProvider
import kotli.template.multiplatform.compose.dataflow.keyvalue.common.CommonKeyValueProcessor
import kotli.template.multiplatform.compose.dataflow.keyvalue.datastore.DataStoreProcessor
import kotli.template.multiplatform.compose.dataflow.keyvalue.settings.SettingsKeyValueProcessor

object KeyValueProvider : BaseDataFlowProvider() {

    override fun getId(): String = "dataflow.keyvalue"
    override fun isMultiple(): Boolean = true
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        CommonKeyValueProcessor,
        SettingsKeyValueProcessor,
        DataStoreProcessor
    )

}