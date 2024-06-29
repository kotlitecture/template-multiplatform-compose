package kotli.app.feature.theme.toggle

import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.store.DataState
import shared.presentation.theme.ThemeStore

/**
 * ViewModel responsible for toggling between light and dark themes.
 *
 * @param themeState The state of the theme to be toggled.
 */
class ToggleThemeViewModel(
    private val themeState: ThemeStore
) : BaseViewModel() {

    val dataState: DataState<ToggleThemeData> = DataState()

    override fun doBind() {
        launchAsync("doBind") {
            themeState.dataState.asFlow()
                .filterNotNull()
                .distinctUntilChanged()
                .map { ToggleThemeData(it) }
                .collectLatest(dataState::set)
        }
    }

    /**
     * Toggles the theme between light and dark modes.
     */
    fun onToggle() {
        val data = dataState.get() ?: return
        if (data.isDark()) {
            themeState.setLight()
        } else {
            themeState.setDark()
        }
    }

}
