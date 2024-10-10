package shared.presentation.theme

import androidx.compose.runtime.snapshotFlow
import androidx.compose.runtime.snapshots.Snapshot
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filterNotNull
import shared.presentation.viewmodel.BaseViewModel

/**
 * ViewModel responsible for managing the app theme state.
 */
internal class ThemeViewModel : BaseViewModel() {

    fun onBind(state: ThemeMutableState) = launchAsync("Init theme state") {
        val systemDarkModeFlow = snapshotFlow { state.systemDarkMode }.filterNotNull()
        val currentConfigFlow = snapshotFlow { state.currentConfig }.filterNotNull()

        combine(systemDarkModeFlow, currentConfigFlow) { darkMode, config ->
            val autoDark = config.autoDark
            val theme = when {
                autoDark && !darkMode -> config.lightTheme
                autoDark && darkMode -> config.darkTheme
                else -> config.defaultTheme
            }
            Snapshot.withMutableSnapshot {
                state.fontFamily = config.fontFamily
                state.systemDarkMode = darkMode
                state.currentConfig = config
                state.currentTheme = theme
            }
        }.collect {}
    }

}