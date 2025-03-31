package kotli.app.showcases.presentation.dataflow.room.paging

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
import kotli.app.common.data.source.database.UserEntity
import shared.presentation.theme.Theme
import shared.presentation.ui.component.AppActionButton
import shared.presentation.ui.component.AppHorizontalDivider
import shared.presentation.ui.component.AppPagingList
import shared.presentation.ui.component.AppText
import shared.presentation.ui.container.AppFixedTopBarLayout
import shared.presentation.ui.icon.AppIcons
import shared.presentation.viewmodel.provideViewModel

@Composable
fun RoomPagingScreen(onBack: () -> Unit) {
    val viewModel: RoomPagingViewModel = provideViewModel()
    val state = viewModel.state

    AppFixedTopBarLayout(
        title = RoomPagingRoute.screen.label,
        onBack = onBack,
        content = {
            AppPagingList(
                pager = state.pager,
                itemContent = { user ->
                    UserBlock(user, viewModel::onDelete)
                }
            )
        }
    )
}

@Composable
private fun UserBlock(user: UserEntity?, onDelete: (user: UserEntity) -> Unit) {
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
            tint = Theme.current.error,
            icon = AppIcons.delete,
        )
    }
    AppHorizontalDivider()
}