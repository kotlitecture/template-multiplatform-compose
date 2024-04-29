package app.showcases.datasource.paging.basic

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.appViewModel
import app.cash.paging.compose.collectAsLazyPagingItems
import app.ui.container.FixedTopBarLazyColumnLayout
import shared.design.component.paging.BasicPagingList

@Composable
fun BasicPagingScreen() {
    val viewModel = appViewModel(BasicPagingViewModel::class)
    val items = viewModel.itemsFlow.collectAsLazyPagingItems()
    FixedTopBarLazyColumnLayout(
        title = BasicPagingShowcase.label,
        onBack = viewModel::onBack,
        content = {
            BasicPagingList(
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
        Text(text = item.orEmpty())
    }
    HorizontalDivider(
        Modifier
            .fillMaxWidth()
    )
}