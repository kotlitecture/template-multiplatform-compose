package kotli.app.presentation.theme.toggle

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import shared.presentation.theme.ThemeStore
import shared.presentation.viewmodel.BaseViewModel

/**
 * ViewModel responsible for toggling between light and dark themes.
 *
 * @param themeStore The state of the theme to be toggled.
 */
class ToggleThemeViewModel(
    private val themeStore: ThemeStore
) : BaseViewModel() {

    private val _uiState = MutableStateFlow<ToggleThemeState?>(null)
    val uiState = _uiState.asStateFlow()

    override fun doBind() {
        launchAsync("doBind") {
            themeStore.dataState.asFlow()
                .filterNotNull()
                .distinctUntilChanged()
                .map { ToggleThemeState(it) }
                .collectLatest(_uiState::value::set)
        }
    }

    /**
     * Toggles the theme between light and dark modes.
     */
    fun onToggle() {
        val state = _uiState.value ?: return
        if (state.isDark()) {
            themeStore.setLight()
        } else {
            themeStore.setDark()
        }
    }

}
