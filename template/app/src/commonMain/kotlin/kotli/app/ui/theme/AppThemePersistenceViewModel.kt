package kotli.app.ui.theme

import kotli.app.data.source.keyvalue.AppKeyValueSource
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.theme.ThemeConfig
import shared.presentation.theme.ThemeStore
import shared.data.serialization.SerializationStrategy

/**
 * ViewModel class responsible for managing the theme state with persistence implemented by default.
 */
class AppThemePersistenceViewModel(
    val themeStore: ThemeStore,
    private val keyValueSource: AppKeyValueSource
) : BaseViewModel() {

    /**
     * Performs the binding operation.
     */
    override fun doBind() {
        launchAsync("config") {
            val key = themeStore.persistentKey
            val strategy = SerializationStrategy.json(AppThemeConfigData.serializer())
            val config = keyValueSource.read(key, strategy)?.let { mapToModel(it) }
                ?: themeStore.defaultConfig
            themeStore.configState.set(config)
            themeStore.configState.asFlow()
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
        val initial = themeStore.defaultConfig
        return initial.copy(
            defaultTheme = themeStore.getById(from.defaultThemeId) ?: initial.defaultTheme,
            lightTheme = themeStore.getById(from.lightThemeId) ?: initial.lightTheme,
            darkTheme = themeStore.getById(from.darkThemeId) ?: initial.darkTheme,
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