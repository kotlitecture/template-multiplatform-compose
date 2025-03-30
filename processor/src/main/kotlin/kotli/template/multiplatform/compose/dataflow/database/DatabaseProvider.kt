package kotli.template.multiplatform.compose.dataflow.database

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.dataflow.BaseDataFlowProvider
import kotli.template.multiplatform.compose.dataflow.database.room.RoomProcessor
import kotli.template.multiplatform.compose.dataflow.database.sqldelight.SqlDelightProcessor

object DatabaseProvider : BaseDataFlowProvider() {

    override fun getId(): String = "dataflow.database"
    override fun isMultiple(): Boolean = false

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        SqlDelightProcessor,
        RoomProcessor,
        SqliteProcessor,
        SqliteLinkerProcessor,
        DatabaseCommonProcessor
    )

}