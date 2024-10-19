package kotli.app.koin.feature

import kotli.app.feature.theme.provide.data.ThemeRepositoryImpl
import kotli.app.feature.theme.provide.domain.repository.ThemeRepository
import kotli.app.feature.theme.provide.domain.usecase.RestoreThemeUseCase
import kotli.app.feature.theme.provide.domain.usecase.StoreThemeUseCase
import org.koin.dsl.module
import shared.design.theme.DarkThemeContext
import shared.design.theme.LightThemeContext
import shared.presentation.theme.ThemeConfig
import shared.presentation.theme.ThemeStateImpl
import shared.presentation.theme.ThemeState

val themeModule = module {
    single<ThemeState> {
        ThemeStateImpl(
            defaultConfig = ThemeConfig(
                defaultTheme = LightThemeContext,
                lightTheme = LightThemeContext,
                darkTheme = DarkThemeContext
            )
        )
    }
    single<ThemeRepository> { ThemeRepositoryImpl("theme_config", get()) }
    single { StoreThemeUseCase(get()) }
    single { RestoreThemeUseCase(get()) }
}