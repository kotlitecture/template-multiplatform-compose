package kotli.app.showcases.presentation.dataflow.room.paging

import androidx.compose.runtime.Stable
import kotli.app.common.data.source.database.UserEntity
import shared.data.source.paging.Pager

@Stable
interface RoomPagingState {

    val pager: Pager<UserEntity>
}