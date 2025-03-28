package kotli.app.feature.showcases.presentation.dataflow.sqldelight.paging

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.collectAsLazyPagingItems
import kotli.app.common.data.source.database.sqldelight.User
import shared.design.component.AppActionButton
import shared.design.component.AppHorizontalDivider
import shared.design.component.AppPagingList
import shared.design.component.AppText
import shared.design.container.AppFixedTopBarLazyColumn
import shared.design.icon.AppIcons
import shared.design.theme.AppTheme
import shared.presentation.viewmodel.provideViewModel

@Composable
fun SqlDelightPagingScreen(onBack: () -> Unit) {
    val viewModel: SqlDelightPagingViewModel = provideViewModel()
    val users = viewModel.state.users.collectAsLazyPagingItems()

    AppFixedTopBarLazyColumn(
        title = SqlDelightPagingRoute.screen.label,
        onBack = onBack,
        content = {
            AppPagingList(
                items = users,
                itemContent = { user ->
                    UserBlock(user, viewModel::onDelete)
                }
            )
        }
    )
}

@Composable
private fun UserBlock(user: User?, onDelete: (user: User) -> Unit) {
    Row(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AppText(text = user?.firstName.orEmpty())
        AppText(text = user?.lastName.orEmpty())
        Spacer(Modifier.weight(1f))
        AppActionButton(
            onClick = { user?.let(onDelete) },
            tint = AppTheme.current.error,
            icon = AppIcons.delete,
        )
    }
    AppHorizontalDivider()
}