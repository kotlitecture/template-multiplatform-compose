package kotli.template.multiplatform.compose.showcases.dataflow.database.room

import kotli.engine.TemplateState
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.dataflow.paging.multiplatform.MultiplatformPagingProcessor
import kotli.template.multiplatform.compose.showcases.BaseShowcasesProcessor

object RoomShowcasesProcessor : BaseShowcasesProcessor() {

    const val ID = "showcases.datasource.database.room"

    override fun getId(): String = ID

    override fun doApply(state: TemplateState) {
        if (state.getFeature(MultiplatformPagingProcessor.ID) != null) return

        removeDir(state, "${Rules.AppShowcasesDataflow}/room/paging")
        removeFromConfig(state, "RoomPaging")
        removeFromViewModel(state, "RoomPaging")
    }

    override fun doRemove(state: TemplateState) {
        removeDir(state, "${Rules.AppShowcasesDataflow}/room")
        removeFromConfig(state, "Room")
        removeFromViewModel(state, "Room")
    }
}