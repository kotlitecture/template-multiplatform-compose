package kotli.app.theme.change.presentation

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable
import shared.presentation.ui.component.DsDialogContent
import shared.presentation.viewmodel.provideViewModel

@Serializable
object ChangeThemeDialogRoute

@Composable
fun ChangeThemeDialog() {
    val viewModel: ChangeThemeViewModel = provideViewModel()
    DsDialogContent {
        ChangeThemeLayout(
            state = viewModel.state,
            onUseDark = viewModel::onUseDark,
            onUseLight = viewModel::onUseLight,
            onUseSystemDefault = viewModel::onUseSystemDefault,
            onEnableDynamicColors = viewModel::onEnableDynamicColors,
            onDisableDynamicColors = viewModel::onDisableDynamicColors
        )
    }
}