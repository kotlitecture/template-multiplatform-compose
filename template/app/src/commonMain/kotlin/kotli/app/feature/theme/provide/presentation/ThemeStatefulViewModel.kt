package kotli.app.feature.theme.provide.presentation

import androidx.compose.runtime.snapshotFlow
import kotli.app.feature.theme.provide.domain.model.ThemeConfigModel
import kotli.app.feature.theme.provide.domain.usecase.RestoreThemeUseCase
import kotli.app.feature.theme.provide.domain.usecase.StoreThemeUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import shared.presentation.theme.ThemeConfig
import shared.presentation.theme.ThemeState
import shared.presentation.viewmodel.BaseViewModel

class ThemeStatefulViewModel(
    val state: ThemeState,
    private val storeTheme: StoreThemeUseCase,
    private val restoreTheme: RestoreThemeUseCase
) : BaseViewModel() {

    override fun doBind() = async("Restore last selected theme") {
        val config = restoreTheme.invoke()?.let(::map) ?: state.defaultConfig
        state.currentConfig = config
        snapshotFlow { state.currentConfig }
            .filterNotNull()
            .filter { current -> current !== config }
            .map(::map)
            .collectLatest(storeTheme::invoke)
    }

    private fun map(from: ThemeConfigModel): ThemeConfig {
        val default = state.defaultConfig
        return default.copy(
            defaultTheme = state.getById(from.defaultThemeId) ?: default.defaultTheme,
            lightTheme = state.getById(from.lightThemeId) ?: default.lightTheme,
            darkTheme = state.getById(from.darkThemeId) ?: default.darkTheme,
            autoDark = from.autoDark ?: default.autoDark
        )
    }

    private fun map(from: ThemeConfig): ThemeConfigModel {
        return ThemeConfigModel(
            defaultThemeId = from.defaultTheme.id,
            lightThemeId = from.lightTheme.id,
            darkThemeId = from.darkTheme.id,
            autoDark = from.autoDark
        )
    }
}