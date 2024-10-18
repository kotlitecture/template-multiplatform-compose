package shared.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import shared.presentation.viewmodel.ViewModelFactory
import shared.presentation.viewmodel.provideViewModel

@Composable
fun ThemeProvider(
    state: ThemeState,
    content: @Composable () -> Unit
) {
    val viewModel: ThemeViewModel = provideViewModel(factory = ViewModelFactory)
    LaunchedEffect(state) { viewModel.onBind(state) }
    SystemDarkModeHandler(state::systemDarkMode::set)
    ThemeSwitchHandler(state, content)
}

@Composable
private fun SystemDarkModeHandler(
    onSystemDarkModeChanged: (mode: Boolean) -> Unit
) {
    val systemDarkMode = isSystemInDarkTheme()
    LaunchedEffect(systemDarkMode) {
        onSystemDarkModeChanged(systemDarkMode)
    }
}

@Composable
private fun ThemeSwitchHandler(
    state: ThemeState,
    content: @Composable () -> Unit
) {
    val theme = state.currentTheme ?: return
    CompositionLocalProvider(Theme.localThemeContext provides theme) {
        theme.apply(state, content)
    }
}