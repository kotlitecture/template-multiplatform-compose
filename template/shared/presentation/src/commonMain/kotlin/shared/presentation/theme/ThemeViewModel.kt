package shared.presentation.theme

import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filterNotNull
import shared.presentation.viewmodel.BaseViewModel

internal class ThemeViewModel : BaseViewModel() {

    suspend fun onBind(state: ThemeState) {
        val systemDarkModeFlow = snapshotFlow { state.systemDarkMode }.filterNotNull()
        val currentConfigFlow = snapshotFlow { state.currentConfig }.filterNotNull()

        combine(systemDarkModeFlow, currentConfigFlow) { darkMode, config ->
            val autoDark = config.autoDark
            val theme = when {
                autoDark && !darkMode -> config.lightTheme
                autoDark && darkMode -> config.darkTheme
                else -> config.defaultTheme
            }
            withState {
                state.fontFamily = config.fontFamily
                state.systemDarkMode = darkMode
                state.currentConfig = config
                state.currentTheme = theme
            }
        }.collect {}
    }

}