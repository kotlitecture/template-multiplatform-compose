package kotli.app.theme.change.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import shared.design.component.AppDialogContent
import shared.design.component.AppRadioButton
import shared.design.component.AppSpacer8
import shared.design.component.AppText
import shared.design.component.AppTextHeader
import shared.design.container.AppFixedTopBarColumn
import shared.presentation.viewmodel.provideViewModel
import template.app.generated.resources.Res
import template.app.generated.resources.theme_change_dark_mode
import template.app.generated.resources.theme_change_dark_mode_off
import template.app.generated.resources.theme_change_dark_mode_on
import template.app.generated.resources.theme_change_dark_mode_system
import template.app.generated.resources.theme_change_dynamic_color
import template.app.generated.resources.theme_change_dynamic_color_off
import template.app.generated.resources.theme_change_dynamic_color_on
import template.app.generated.resources.theme_change_title

@Composable
fun ChangeThemeScreen() {
    val viewModel: ChangeThemeViewModel = provideViewModel()
    AppFixedTopBarColumn(
        title = stringResource(Res.string.theme_change_title),
        onBack = viewModel::onBack,
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

@Composable
fun ChangeThemeDialog() {
    val viewModel: ChangeThemeViewModel = provideViewModel()
    AppDialogContent {
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

@Composable
private fun ChangeThemeLayout(
    modifier: Modifier = Modifier,
    state: ChangeThemeState,
    onUseDark: () -> Unit,
    onUseLight: () -> Unit,
    onUseSystemDefault: () -> Unit,
    onEnableDynamicColors: () -> Unit,
    onDisableDynamicColors: () -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        DynamicColorBlock(
            state = state,
            onEnableDynamicColors = onEnableDynamicColors,
            onDisableDynamicColors = onDisableDynamicColors
        )
        DarkModePreferenceBlock(
            state = state,
            onUseDark = onUseDark,
            onUseLight = onUseLight,
            onUseSystemDefault = onUseSystemDefault
        )
    }
}

@Composable
private fun DynamicColorBlock(
    state: ChangeThemeState,
    onEnableDynamicColors: () -> Unit,
    onDisableDynamicColors: () -> Unit,
) {
    val dynamic = state.dynamic ?: return
    Column {
        HeaderBlock(stringResource(Res.string.theme_change_dynamic_color))
        AppSpacer8()
        ToggleBlock(
            label = stringResource(Res.string.theme_change_dynamic_color_on),
            selected = dynamic,
            onClick = onEnableDynamicColors
        )
        ToggleBlock(
            label = stringResource(Res.string.theme_change_dynamic_color_off),
            selected = !dynamic,
            onClick = onDisableDynamicColors
        )
    }
}

@Composable
fun DarkModePreferenceBlock(
    state: ChangeThemeState,
    onUseDark: () -> Unit,
    onUseLight: () -> Unit,
    onUseSystemDefault: () -> Unit
) {
    val config = state.currentConfig ?: return
    Column {
        HeaderBlock(stringResource(Res.string.theme_change_dark_mode))
        AppSpacer8()
        ToggleBlock(
            label = stringResource(Res.string.theme_change_dark_mode_system),
            selected = config.autoDark,
            onClick = onUseSystemDefault
        )
        ToggleBlock(
            label = stringResource(Res.string.theme_change_dark_mode_off),
            selected = !config.autoDark && !config.defaultTheme.dark,
            onClick = onUseLight
        )
        ToggleBlock(
            label = stringResource(Res.string.theme_change_dark_mode_on),
            selected = !config.autoDark && config.defaultTheme.dark,
            onClick = onUseDark
        )
    }
}

@Composable
private fun HeaderBlock(title: String) {
    AppTextHeader(text = title)
}

@Composable
private fun ToggleBlock(label: String, selected: Boolean, onClick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppRadioButton(
            selected = selected,
            onClick = onClick
        )
        AppText(text = label)
    }
}