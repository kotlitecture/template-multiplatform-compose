package shared.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import shared.core.ViewModelFactory
import shared.core.provideViewModel

@Composable
fun ThemeProvider(
    state: ThemeState,
    content: @Composable () -> Unit
) {
    val viewModel: ThemeViewModel = provideViewModel(factory = ViewModelFactory)
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
    val context = state.contextStore.asStateValue() ?: return
    CompositionLocalProvider(ThemeContext.localThemeContext provides context) {
        context.apply(state.configStore.getNotNull(), content)
    }
}