package app.ui.theme

import androidx.compose.runtime.Composable
import app.appViewModel
import core.ui.theme.ThemeProvider

@Composable
fun AppThemeProvider(content: @Composable () -> Unit) {
    val viewModel = appViewModel(AppThemeViewModel::class)
    ThemeProvider(viewModel.themeState, content)
}