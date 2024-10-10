package kotli.app

import androidx.compose.runtime.Composable
import kotli.app.di.get
import kotli.app.presentation.app.AppScreen
import kotli.app.theme.provide.presentation.AppThemeProvider
import shared.presentation.viewmodel.ViewModelProvider

@Composable
fun App() = ViewModelProvider(get()) {
    AppThemeProvider {
        AppScreen()
    }
}
