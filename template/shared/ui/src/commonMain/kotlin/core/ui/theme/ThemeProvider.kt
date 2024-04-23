package core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import core.ui.coreViewModel
import core.ui.theme.material3.Material3ThemeData
import core.ui.theme.material3.Material3ThemeProvider

@Composable
fun ThemeProvider(
    state: ThemeState,
    content: @Composable () -> Unit
) {
    val viewModel = coreViewModel(ThemeViewModel::class)
    LaunchedEffect(state) { viewModel.onBind(state) }
    SystemDarkModeHandler(state)
    ThemeSwitchHandler(state, content)
}

@Composable
private fun SystemDarkModeHandler(state: ThemeState) {
    val systemDarkMode = isSystemInDarkTheme()
    LaunchedEffect(systemDarkMode) {
        state.systemDarkModeStore.set(systemDarkMode)
    }
}

@Composable
private fun ThemeSwitchHandler(state: ThemeState, content: @Composable () -> Unit) {
    val data = state.dataStore.asStateValue() ?: return
    CompositionLocalProvider(ThemeData.localThemeData provides data) {
        when {
            data is Material3ThemeData -> Material3ThemeProvider(data, content)
            else -> content()
        }
    }
}