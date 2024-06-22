package kotli.app.ui.theme

import androidx.compose.runtime.Composable
import shared.presentation.provideViewModel
import shared.presentation.theme.ThemeProvider

@Composable
fun AppThemeProvider(content: @Composable () -> Unit) {
    val viewModel: AppThemePersistenceViewModel = provideViewModel()
    ThemeProvider(viewModel.themeState, content)
}