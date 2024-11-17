package kotli.template.multiplatform.compose.dataflow.settings

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.dataflow.BaseDataFlowProvider
import kotli.template.multiplatform.compose.dataflow.settings.common.CommonSettingsProcessor
import kotli.template.multiplatform.compose.dataflow.settings.datastore.DataStoreProcessor
import kotli.template.multiplatform.compose.dataflow.settings.basic.BasicSettingsProcessor

object SettingsProvider : BaseDataFlowProvider() {

    override fun getId(): String = "dataflow.settings"
    override fun isMultiple(): Boolean = false
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        CommonSettingsProcessor,
        BasicSettingsProcessor,
        DataStoreProcessor
    )
}