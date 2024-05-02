package kotli.app.ui.theme

import androidx.compose.runtime.Composable
import shared.core.provideViewModel
import shared.core.theme.ThemeProvider

@Composable
fun AppThemeProvider(content: @Composable () -> Unit) {
    val viewModel: AppThemePersistenceViewModel = provideViewModel()
    ThemeProvider(viewModel.themeState, content)
}