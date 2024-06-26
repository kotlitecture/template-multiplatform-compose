package kotli.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotli.app.di.get
import kotli.app.presentation.app.AppScreen
import kotli.app.presentation.theme.AppThemeProvider
import shared.presentation.viewmodel.ViewModelProvider

/**
 * Root of the application.
 */
@Composable
fun App() = ViewModelProvider(remember(::get)) {
    AppThemeProvider {
        AppScreen()
    }
}
