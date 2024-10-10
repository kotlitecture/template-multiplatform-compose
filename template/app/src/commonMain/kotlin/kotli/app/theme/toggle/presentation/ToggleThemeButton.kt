package kotli.app.theme.toggle.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import shared.design.component.AppActionButton
import shared.presentation.viewmodel.provideViewModel

@Composable
fun ToggleThemeButton(modifier: Modifier = Modifier) {
    val viewModel: ToggleThemeViewModel = provideViewModel()
    val state = viewModel.state
    AppActionButton(
        modifier = modifier,
        icon = state.getIcon(),
        onClick = viewModel::onToggle,
    )
}