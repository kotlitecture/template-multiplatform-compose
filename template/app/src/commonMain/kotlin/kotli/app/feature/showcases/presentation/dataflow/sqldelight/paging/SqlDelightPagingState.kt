package kotli.app.feature.showcases.presentation.dataflow.sqldelight.paging

import androidx.compose.runtime.Stable
import app.cash.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotli.app.common.data.source.database.sqldelight.User

@Stable
interface SqlDelightPagingState {

    val users: Flow<PagingData<User>>

}