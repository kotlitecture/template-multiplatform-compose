package kotli.app.showcases.presentation.dataflow.paging.basic

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shared.presentation.ui.component.AppHorizontalDivider
import shared.presentation.ui.component.AppPagingList
import shared.presentation.ui.component.AppText
import shared.presentation.ui.container.AppFixedTopBarLayout
import shared.presentation.viewmodel.provideViewModel

@Composable
fun BasicPagingScreen(onBack: () -> Unit) {
    val viewModel: BasicPagingViewModel = provideViewModel()
    val state = viewModel.state

    AppFixedTopBarLayout(
        title = BasicPagingRoute.screen.label,
        onBack = onBack,
        content = {
            AppPagingList(
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
        AppText(text = item.orEmpty())
    }
    AppHorizontalDivider()
}