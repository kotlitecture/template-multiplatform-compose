package kotli.app.presentation.ui.theme.change

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import shared.presentation.viewmodel.provideViewModel
import shared.design.component.AppDialogContent
import shared.design.component.AppRadioButton
import shared.design.component.AppSpacer8
import shared.design.component.AppText
import shared.design.component.AppTextHeader
import shared.design.container.AppFixedTopBarColumn
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
                viewModel = viewModel
            )
        }
    )
}

@Composable
fun ChangeThemeDialog() {
    val viewModel: ChangeThemeViewModel = provideViewModel()
    AppDialogContent { ChangeThemeLayout(viewModel = viewModel) }
}

@Composable
fun ChangeThemeLayout(
    modifier: Modifier = Modifier,
    viewModel: ChangeThemeViewModel = provideViewModel()
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        DynamicColorBlock()
        DarkModePreferenceBlock(viewModel)
    }
}

@Composable
fun DynamicColorBlock(viewModel: ChangeThemeViewModel = provideViewModel()) {
    val use = viewModel.dynamicColorsState.asStateValue() ?: return
    Column {
        HeaderBlock(stringResource(Res.string.theme_change_dynamic_color))
        AppSpacer8()
        ToggleBlock(
            label = stringResource(Res.string.theme_change_dynamic_color_on),
            selected = use,
            onClick = viewModel::onEnableDynamicColors
        )
        ToggleBlock(
            label = stringResource(Res.string.theme_change_dynamic_color_off),
            selected = !use,
            onClick = viewModel::onDisableDynamicColors
        )
    }
}

@Composable
fun DarkModePreferenceBlock(viewModel: ChangeThemeViewModel = provideViewModel()) {
    val config = viewModel.configState.asStateValue() ?: return
    Column {
        HeaderBlock(stringResource(Res.string.theme_change_dark_mode))
        AppSpacer8()
        ToggleBlock(
            label = stringResource(Res.string.theme_change_dark_mode_system),
            selected = config.autoDark,
            onClick = viewModel::onUseSystemDefault
        )
        ToggleBlock(
            label = stringResource(Res.string.theme_change_dark_mode_off),
            selected = !config.autoDark && !config.defaultTheme.dark,
            onClick = viewModel::onUseLight
        )
        ToggleBlock(
            label = stringResource(Res.string.theme_change_dark_mode_on),
            selected = !config.autoDark && config.defaultTheme.dark,
            onClick = viewModel::onUseDark
        )
    }
}

@Composable
fun HeaderBlock(title: String) {
    AppTextHeader(text = title)
}

@Composable
fun ToggleBlock(label: String, selected: Boolean, onClick: () -> Unit) {
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