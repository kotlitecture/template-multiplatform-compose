package shared.core.theme

import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import shared.core.BaseViewModel

/**
 * ViewModel responsible for managing the app theme state.
 */
class ThemeViewModel : BaseViewModel() {

    /**
     * Binds the theme state to the ViewModel.
     *
     * @param state The state of the theme to be bound.
     */
    fun onBind(state: ThemeState) {
        launchAsync("onBind") {
            state.systemDarkModeStore.asFlow()
                .filterNotNull()
                .flatMapLatest { darkMode ->
                    state.configStore.asFlow()
                        .filterNotNull()
                        .mapNotNull { Data(it, darkMode) }
                }
                .map { data ->
                    val config = data.config
                    val autoDark = config.autoDark
                    val context = when {
                        autoDark && !data.darkMode -> config.lightTheme
                        autoDark && data.darkMode -> config.darkTheme
                        else -> config.defaultTheme
                    }
                    ThemeData(
                        context = context,
                        fontFamily = config.fontFamily
                    )
                }
                .collect(state.dataStore::set)
        }
    }

    private data class Data(
        val config: ThemeConfig,
        val darkMode: Boolean
    )

}