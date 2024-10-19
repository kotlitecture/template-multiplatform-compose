package kotli.app.feature.showcases.presentation.dataflow.paging.basic

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.collectAsLazyPagingItems
import shared.presentation.viewmodel.provideViewModel
import shared.design.component.AppHorizontalDivider
import shared.design.component.AppPagingList
import shared.design.component.AppText
import shared.design.container.AppFixedTopBarLazyColumn

@Composable
fun BasicPagingScreen() {
    val viewModel: BasicPagingViewModel = provideViewModel()
    val items = viewModel.itemsFlow.collectAsLazyPagingItems()
    AppFixedTopBarLazyColumn(
        title = BasicPagingShowcase.label,
        onBack = viewModel::onBack,
        content = {
            AppPagingList(
                items = items,
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