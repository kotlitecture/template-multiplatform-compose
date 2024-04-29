package app.userflow.theme.toggle

import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import shared.core.BaseViewModel
import shared.core.state.StoreObject
import shared.core.theme.ThemeState

/**
 * ViewModel responsible for toggling between light and dark themes.
 *
 * @param themeState The state of the theme to be toggled.
 */
class ToggleThemeViewModel(
    private val themeState: ThemeState
) : BaseViewModel() {

    val dataStore: StoreObject<ToggleThemeData> = StoreObject()

    override fun doBind() {
        launchAsync("doBind") {
            themeState.contextStore.asFlow()
                .mapNotNull { it?.id }
                .mapNotNull(themeState::getById)
                .distinctUntilChanged()
                .map { ToggleThemeData(it) }
                .collectLatest(dataStore::set)
        }
    }

    /**
     * Toggles the theme between light and dark modes.
     */
    fun onToggle() {
        val data = dataStore.get() ?: return
        if (data.isDark()) {
            themeState.setLight()
        } else {
            themeState.setDark()
        }
    }

}
