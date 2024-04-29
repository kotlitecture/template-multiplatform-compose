package app

import androidx.compose.runtime.Composable
import app.ui.theme.AppThemeProvider

@Composable
fun App() {
    AppThemeProvider {
        AppScreen()
    }
}
