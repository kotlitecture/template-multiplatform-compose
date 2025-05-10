package kotli.app.theme.toggle.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import shared.presentation.ui.component.DsActionButton
import shared.presentation.viewmodel.provideViewModel

@Composable
fun ToggleThemeButton(modifier: Modifier = Modifier) {
    val viewModel: ToggleThemeViewModel = provideViewModel()
    val state = viewModel.state

    DsActionButton(
        modifier = modifier,
        icon = state.getIcon(),
        onClick = viewModel::onToggle,
    )
}