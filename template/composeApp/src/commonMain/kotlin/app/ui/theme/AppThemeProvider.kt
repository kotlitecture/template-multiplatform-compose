package app.ui.theme

import androidx.compose.runtime.Composable
import app.appViewModel
import shared.core.theme.ThemeProvider

@Composable
fun AppThemeProvider(content: @Composable () -> Unit) {
    val viewModel = appViewModel(AppThemePersistenceViewModel::class)
    ThemeProvider(viewModel.themeState, content)
}