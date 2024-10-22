package kotli.template.multiplatform.compose.showcases.dataflow.database.room

import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.showcases.BaseShowcasesProcessor

object RoomShowcasesProcessor : BaseShowcasesProcessor() {

    const val ID = "showcases.datasource.database.room"

    override fun getId(): String = ID

    override fun doRemove(state: TemplateState) {
        removeDir(state, "${Rules.AppShowcasesDataflow}/room")
        removeFromConfig(state, "Room")
        removeFromViewModel(state, "Room")
        state.onApplyRules(
            "*/createRoom*.kt",
            RemoveFile()
        )
    }

}