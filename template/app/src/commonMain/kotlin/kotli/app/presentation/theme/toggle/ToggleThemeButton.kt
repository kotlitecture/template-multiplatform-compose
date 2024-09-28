package kotli.app.presentation.theme.toggle

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import shared.design.component.AppActionButton
import shared.presentation.viewmodel.provideViewModel

/**
 * Composable function for rendering a button that toggles the theme.
 *
 * @param modifier The modifier to be applied to the button.
 */
@Composable
fun ToggleThemeButton(modifier: Modifier = Modifier) {
    val viewModel: ToggleThemeViewModel = provideViewModel()
    val state = viewModel.uiState.collectAsState().value ?: return
    AppActionButton(
        modifier = modifier,
        onClick = viewModel::onToggle,
        icon = state.getIcon()
    )
}