package kotli.app.showcases.presentation.dataflow.paging.basic

import androidx.compose.runtime.Stable
import shared.data.source.paging.Pager

@Stable
interface BasicPagingState {

    val items: Pager<String>
}