package kotli.app.showcases.presentation.dataflow.paging.basic

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shared.presentation.ui.component.DsHorizontalDivider
import shared.presentation.ui.component.DsPagingList
import shared.presentation.ui.component.DsText
import shared.presentation.ui.container.DsFixedTopBarLayout
import shared.presentation.viewmodel.provideViewModel

@Composable
fun BasicPagingScreen(onBack: () -> Unit) {
    val viewModel: BasicPagingViewModel = provideViewModel()
    val state = viewModel.state

    DsFixedTopBarLayout(
        title = BasicPagingRoute.screen.label,
        onBack = onBack,
        content = {
            DsPagingList(
                pager = state.items,
                itemContent = {
                    ItemBlock(item = it)
                }
            )
        }
    )
}

@Composable
private fun ItemBlock(item: String?) {
    Row(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        DsText(text = item.orEmpty())
    }
    DsHorizontalDivider()
}