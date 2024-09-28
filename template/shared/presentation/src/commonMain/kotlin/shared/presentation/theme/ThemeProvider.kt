package shared.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import shared.presentation.store.DataState
import shared.presentation.viewmodel.ViewModelFactory
import shared.presentation.viewmodel.provideViewModel

@Composable
fun ThemeProvider(
    store: ThemeStore,
    content: @Composable () -> Unit
) {
    val viewModel: ThemeViewModel = provideViewModel(factory = ViewModelFactory)
    LaunchedEffect(store) { viewModel.onBind(store) }
    SystemDarkModeHandler(store.systemDarkModeState)
    ThemeSwitchHandler(store.dataState, content)
}

@Composable
private fun SystemDarkModeHandler(state: DataState<Boolean>) {
    val systemDarkMode = isSystemInDarkTheme()
    LaunchedEffect(systemDarkMode) {
        state.set(systemDarkMode)
    }
}

@Composable
private fun ThemeSwitchHandler(
    state: DataState<ThemeData>,
    content: @Composable () -> Unit
) {
    val data = state.asStateValue() ?: return
    val theme = data.context
    CompositionLocalProvider(ThemeContext.localThemeContext provides theme) {
        theme.apply(data.fontFamily, content)
    }
}