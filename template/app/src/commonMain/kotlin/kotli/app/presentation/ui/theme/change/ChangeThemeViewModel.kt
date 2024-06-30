package kotli.app.presentation.ui.theme.change

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
 * @property navigationStore The navigation store to manage navigation within the app.
 * @property themeStore The theme state to manage theme-related operations.
 */
class ChangeThemeViewModel(
    private val navigationStore: NavigationStore,
    private val themeStore: ThemeStore
) : BaseViewModel() {

    val configState = themeStore.configState
    val dynamicColorsState = DataState<Boolean>()

    override fun doBind() {
        val dynamicConfig = themeStore.dynamicConfig
        if (dynamicConfig != null) {
            launchAsync("dynamicColors") {
                val dynamicThemes = setOf(dynamicConfig.lightTheme.id, dynamicConfig.darkTheme.id)
                themeStore.configState.asFlow()
                    .filterNotNull()
                    .map { it.defaultTheme.id }
                    .map { it in dynamicThemes }
                    .distinctUntilChanged()
                    .collectLatest(dynamicColorsState::set)
            }
        }
    }

    fun onBack() {
        navigationStore.onBack()
    }

    fun onEnableDynamicColors() {
        val dynamicConfig = themeStore.dynamicConfig ?: return
        val currentConfig = themeStore.configState.get() ?: return
        themeStore.configState.set(copyState(dynamicConfig, currentConfig))
    }

    fun onDisableDynamicColors() {
        val defaultConfig = themeStore.defaultConfig
        val currentConfig = themeStore.configState.get() ?: return
        themeStore.configState.set(copyState(defaultConfig, currentConfig))
    }

    fun onUseSystemDefault() {
        themeStore.setAuto()
    }

    fun onUseLight() {
        themeStore.setLight()
    }

    fun onUseDark() {
        themeStore.setDark()
    }

    private fun copyState(to: ThemeConfig, from: ThemeConfig): ThemeConfig {
        return to.copy(
            defaultTheme = if (from.defaultTheme.dark) to.darkTheme else to.lightTheme,
            autoDark = from.autoDark
        )
    }

}
