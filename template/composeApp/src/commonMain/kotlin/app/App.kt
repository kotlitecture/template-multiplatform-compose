package app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import core.ui.ViewModelStoreOwnerProvider
import core.ui.theme.ThemeConfig
import core.ui.theme.ThemeProvider
import core.ui.theme.ThemeState
import core.ui.theme.material3.Material3Themes

@Composable
fun App() = ViewModelStoreOwnerProvider {
    val themeState = remember {
        ThemeState(
            defaultConfig = ThemeConfig(
                defaultTheme = Material3Themes.light(),
                lightTheme = Material3Themes.light(),
                darkTheme = Material3Themes.dark()
            )
        )
    }
    LaunchedEffect(themeState) {
        themeState.configStore.set(themeState.defaultConfig)
    }
    ThemeProvider(
        state = themeState,
        content = {
            AppScreen()
        }
    )
}
