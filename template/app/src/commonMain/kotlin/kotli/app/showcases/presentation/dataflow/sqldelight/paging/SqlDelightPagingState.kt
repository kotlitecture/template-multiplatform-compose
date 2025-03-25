package kotli.app.showcases.presentation.dataflow.sqldelight.paging

import androidx.compose.runtime.Stable
import kotli.app.common.data.source.database.UserEntity
import shared.data.source.paging.Pager

@Stable
interface SqlDelightPagingState {

    val users: Pager<UserEntity>
}