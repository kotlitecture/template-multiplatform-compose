package kotli.app.theme.change.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.stringResource
import shared.presentation.ui.container.DsFixedTopBarColumn
import shared.presentation.viewmodel.provideViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.theme_change_title

@Serializable
object ChangeThemeRoute

@Composable
fun ChangeThemeScreen(onBack: () -> Unit) {
    val viewModel: ChangeThemeViewModel = provideViewModel()

    DsFixedTopBarColumn(
        title = stringResource(Res.string.theme_change_title),
        onBack = onBack,
        content = {
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
    )
}