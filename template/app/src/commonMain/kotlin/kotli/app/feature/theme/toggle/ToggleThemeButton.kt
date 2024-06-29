package kotli.app.feature.theme.toggle

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import shared.presentation.viewmodel.provideViewModel
import shared.design.component.AppActionButton

/**
 * Composable function for rendering a button that toggles the theme.
 *
 * @param modifier The modifier to be applied to the button.
 */
@Composable
fun ToggleThemeButton(modifier: Modifier = Modifier) {
    val viewModel: ToggleThemeViewModel = provideViewModel()
    val data = viewModel.dataStore.asStateValue() ?: return
    AppActionButton(
        modifier = modifier,
        onClick = viewModel::onToggle,
        icon = data.getIcon()
    )
}