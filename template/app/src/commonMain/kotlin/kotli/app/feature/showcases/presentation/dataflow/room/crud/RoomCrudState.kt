package kotli.app.feature.showcases.presentation.dataflow.room.crud

import androidx.compose.runtime.Stable

@Stable
interface RoomCrudState {

    val users: List<UserData>

}