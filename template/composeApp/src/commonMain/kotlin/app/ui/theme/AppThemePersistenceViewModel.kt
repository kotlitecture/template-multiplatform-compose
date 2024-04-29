package app.ui.theme

import app.datasource.keyvalue.AppKeyValueSource
import shared.data.serialization.JsonStrategy
import shared.core.BaseViewModel
import shared.core.theme.ThemeConfig
import shared.core.theme.ThemeState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map

/**
 * ViewModel class responsible for managing the theme state with persistence implemented by default.
 */
class AppThemePersistenceViewModel(
    val themeState: ThemeState,
    private val keyValueSource: AppKeyValueSource
) : BaseViewModel() {

    /**
     * Performs the binding operation.
     */
    override fun doBind() {
        launchAsync("config") {
            val key = themeState.persistentKey
            val strategy = JsonStrategy.create(AppThemeConfigData.serializer())
            val config = keyValueSource.read(key, strategy)?.let { mapToModel(it) }
                ?: themeState.defaultConfig
            themeState.configStore.set(config)
            themeState.configStore.asFlow()
                .filterNotNull()
                .filter { it !== config }
                .map { mapToData(it) }
                .collectLatest { data -> keyValueSource.save(key, data, strategy) }
        }
    }

    /**
     * Maps data from [AppThemeConfigData] to [ThemeConfig].
     *
     * @param from The source data.
     * @return The mapped [ThemeConfig].
     */
    private fun mapToModel(from: AppThemeConfigData): ThemeConfig {
        val initial = themeState.defaultConfig
        return initial.copy(
            defaultTheme = themeState.getById(from.defaultThemeId) ?: initial.defaultTheme,
            lightTheme = themeState.getById(from.lightThemeId) ?: initial.lightTheme,
            darkTheme = themeState.getById(from.darkThemeId) ?: initial.darkTheme,
            autoDark = from.autoDark ?: initial.autoDark
        )
    }

    /**
     * Maps data from [ThemeConfig] to [AppThemeConfigData].
     *
     * @param from The source data.
     * @return The mapped [AppThemeConfigData].
     */
    private fun mapToData(from: ThemeConfig): AppThemeConfigData {
        return AppThemeConfigData(
            defaultThemeId = from.defaultTheme.id,
            lightThemeId = from.lightTheme.id,
            darkThemeId = from.darkTheme.id,
            autoDark = from.autoDark
        )
    }

}