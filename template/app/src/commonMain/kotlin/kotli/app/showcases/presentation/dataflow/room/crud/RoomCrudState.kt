package kotli.app.showcases.presentation.dataflow.room.crud

import androidx.compose.runtime.Stable
import kotli.app.common.data.source.database.UserEntity

@Stable
interface RoomCrudState {

    val users: List<UserEntity>
}