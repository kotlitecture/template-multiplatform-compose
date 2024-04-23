package app

import androidx.compose.runtime.Composable
import app.ui.theme.AppTheme
import core.ui.ViewModelStoreOwnerProvider

@Composable
fun App() = ViewModelStoreOwnerProvider {
    AppTheme {
        AppScreen()
    }
}
