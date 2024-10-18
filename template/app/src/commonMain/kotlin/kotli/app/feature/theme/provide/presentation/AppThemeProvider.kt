package kotli.app.feature.theme.provide.presentation

import androidx.compose.runtime.Composable
import shared.presentation.theme.ThemeProvider
import shared.presentation.viewmodel.provideViewModel

@Composable
fun AppThemeProvider(content: @Composable () -> Unit) {
    val viewModel: AppThemePersistenceViewModel = provideViewModel()
    ThemeProvider(viewModel.state, content)
}