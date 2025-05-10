package kotli.app.theme.change.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.serialization.Serializable
import shared.presentation.ui.container.DsBottomSheet
import shared.presentation.viewmodel.provideViewModel

@Serializable
object ChangeThemeBottomSheetRoute

@Composable
fun ChangeThemeBottomSheet(onBack: () -> Unit) {
    val viewModel: ChangeThemeViewModel = provideViewModel()
    DsBottomSheet(onDismissRequest = onBack) {
        ChangeThemeLayout(
            modifier = Modifier.padding(16.dp),
            state = viewModel.state,
            onUseDark = viewModel::onUseDark,
            onUseLight = viewModel::onUseLight,
            onUseSystemDefault = viewModel::onUseSystemDefault,
            onEnableDynamicColors = viewModel::onEnableDynamicColors,
            onDisableDynamicColors = viewModel::onDisableDynamicColors
        )
    }
}