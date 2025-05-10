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
import shared.presentation.ui.theme.DsTheme
import shared.presentation.ui.component.DsActionButton
import shared.presentation.ui.component.DsHorizontalDivider
import shared.presentation.ui.component.DsPagingList
import shared.presentation.ui.component.DsText
import shared.presentation.ui.container.DsFixedTopBarLayout
import shared.presentation.ui.icon.DsIcons
import shared.presentation.viewmodel.provideViewModel

@Composable
fun RoomPagingScreen(onBack: () -> Unit) {
    val viewModel: RoomPagingViewModel = provideViewModel()
    val state = viewModel.state

    DsFixedTopBarLayout(
        title = RoomPagingRoute.screen.label,
        onBack = onBack,
        content = {
            DsPagingList(
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
        DsText(text = user?.firstName.orEmpty())
        DsText(text = user?.lastName.orEmpty())
        Spacer(Modifier.weight(1f))
        DsActionButton(
            onClick = { user?.let(onDelete) },
            tint = DsTheme.current.error,
            icon = DsIcons.delete,
        )
    }
    DsHorizontalDivider()
}