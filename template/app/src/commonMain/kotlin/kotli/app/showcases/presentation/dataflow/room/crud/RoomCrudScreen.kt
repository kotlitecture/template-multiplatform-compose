package kotli.app.showcases.presentation.dataflow.room.crud

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotli.app.common.data.source.database.UserEntity
import shared.presentation.theme.Theme
import shared.presentation.ui.component.AppActionButton
import shared.presentation.ui.component.AppHorizontalDivider
import shared.presentation.ui.component.AppOutlinedButton
import shared.presentation.ui.component.AppText
import shared.presentation.ui.container.AppFixedTopBarLazyColumn
import shared.presentation.ui.icon.AppIcons
import shared.presentation.viewmodel.provideViewModel

@Composable
fun RoomCrudScreen(onBack: () -> Unit) {
    val viewModel: RoomCrudViewModel = provideViewModel()
    val state = viewModel.state

    AppFixedTopBarLazyColumn(
        title = RoomCrudRoute.screen.label,
        onBack = onBack,
        actions = { ActionsBlock(viewModel) },
        content = {
            val users = state.users

            users.forEach { user ->
                item {
                    UserBlock(user, viewModel::onDelete)
                }
            }

            if (users.isEmpty()) {
                item {
                    AppText(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        text = "No users",
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    )
}

@Composable
private fun ActionsBlock(viewModel: RoomCrudViewModel) {
    AppOutlinedButton(
        modifier = Modifier.padding(horizontal = 16.dp),
        onClick = viewModel::onAdd,
        text = "Add user"
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