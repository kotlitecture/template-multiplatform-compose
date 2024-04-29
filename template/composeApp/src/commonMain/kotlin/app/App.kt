package app

import androidx.compose.runtime.Composable
import app.ui.theme.AppThemeProvider
import shared.core.ViewModelProvider

@Composable
fun App() = ViewModelProvider {
    AppThemeProvider {
        AppScreen()
    }
}
