package kotli.app.feature.theme.change

import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationStore
import shared.presentation.store.DataState
import shared.presentation.theme.ThemeConfig
import shared.presentation.theme.ThemeStore
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map

/**
 * ViewModel for handling theme change functionality.
 *
 * @property navigationState The navigation state to manage navigation within the app.
 * @property themeState The theme state to manage theme-related operations.
 */
class ChangeThemeViewModel(
    private val navigationState: NavigationStore,
    private val themeState: ThemeStore
) : BaseViewModel() {

    val configState = themeState.configState
    val dynamicColorsState = DataState<Boolean>()

    override fun doBind() {
        val dynamicConfig = themeState.dynamicConfig
        if (dynamicConfig != null) {
            launchAsync("dynamicColors") {
                val dynamicThemes = setOf(dynamicConfig.lightTheme.id, dynamicConfig.darkTheme.id)
                themeState.configState.asFlow()
                    .filterNotNull()
                    .map { it.defaultTheme.id }
                    .map { it in dynamicThemes }
                    .distinctUntilChanged()
                    .collectLatest(dynamicColorsState::set)
            }
        }
    }

    fun onBack() {
        navigationState.onBack()
    }

    fun onEnableDynamicColors() {
        val dynamicConfig = themeState.dynamicConfig ?: return
        val currentConfig = themeState.configState.get() ?: return
        themeState.configState.set(copyState(dynamicConfig, currentConfig))
    }

    fun onDisableDynamicColors() {
        val defaultConfig = themeState.defaultConfig
        val currentConfig = themeState.configState.get() ?: return
        themeState.configState.set(copyState(defaultConfig, currentConfig))
    }

    fun onUseSystemDefault() {
        themeState.setAuto()
    }

    fun onUseLight() {
        themeState.setLight()
    }

    fun onUseDark() {
        themeState.setDark()
    }

    private fun copyState(to: ThemeConfig, from: ThemeConfig): ThemeConfig {
        return to.copy(
            defaultTheme = if (from.defaultTheme.dark) to.darkTheme else to.lightTheme,
            autoDark = from.autoDark
        )
    }

}
