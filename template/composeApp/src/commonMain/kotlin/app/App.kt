package app

import androidx.compose.runtime.Composable
import app.ui.theme.AppThemeProvider
import core.ui.ViewModelProvider

@Composable
fun App() = ViewModelProvider {
    AppThemeProvider {
        AppScreen()
    }
}
