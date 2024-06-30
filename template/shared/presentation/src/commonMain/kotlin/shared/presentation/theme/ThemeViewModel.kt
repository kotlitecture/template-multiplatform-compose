package shared.presentation.theme

import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.mapNotNull
import shared.presentation.viewmodel.BaseViewModel

/**
 * ViewModel responsible for managing the app theme state.
 */
internal class ThemeViewModel : BaseViewModel() {

    fun onBind(state: ThemeStore) {
        launchAsync("dataStore") {
            state.systemDarkModeState.asFlow()
                .filterNotNull()
                .flatMapLatest { darkMode ->
                    state.configState.asFlow()
                        .filterNotNull()
                        .mapNotNull { config -> map(config, darkMode) }
                }
                .collect(state.dataState::set)
        }
    }

    private fun map(config: ThemeConfig, darkMode: Boolean): ThemeData {
        val autoDark = config.autoDark
        val context = when {
            autoDark && !darkMode -> config.lightTheme
            autoDark && darkMode -> config.darkTheme
            else -> config.defaultTheme
        }
        return ThemeData(
            context = context,
            fontFamily = config.fontFamily
        )
    }

}