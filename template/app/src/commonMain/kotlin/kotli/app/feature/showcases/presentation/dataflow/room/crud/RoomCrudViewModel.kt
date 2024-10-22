package kotli.app.feature.showcases.presentation.dataflow.room.crud

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import shared.presentation.viewmodel.BaseViewModel

abstract class RoomCrudViewModel : BaseViewModel() {

    protected val _state = RoomCrudMutableState()
    val state: RoomCrudState = _state

    abstract fun onAdd()

    abstract fun onDelete(user: UserData)

    protected class RoomCrudMutableState : RoomCrudState {
        override var users: List<UserData> by mutableStateOf(emptyList())
    }
}
