package kotli.app.feature.showcases.presentation.dataflow.paging.basic

import androidx.compose.runtime.Stable
import app.cash.paging.PagingData
import kotlinx.coroutines.flow.Flow

@Stable
interface BasicPagingState {

    val items: Flow<PagingData<String>>

}