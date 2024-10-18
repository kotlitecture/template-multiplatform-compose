package kotli.app.koin.feature

import kotli.app.feature.theme.provide.domain.RestoreThemeUseCase
import kotli.app.feature.theme.provide.domain.StoreThemeUseCase
import org.koin.dsl.bind
import org.koin.dsl.module
import shared.design.theme.DarkThemeContext
import shared.design.theme.LightThemeContext
import shared.presentation.theme.ThemeConfig
import shared.presentation.theme.ThemeMutableState
import shared.presentation.theme.ThemeState

val themeModule = module {
    single<ThemeMutableState> {
        ThemeMutableState(
            defaultConfig = ThemeConfig(
                defaultTheme = LightThemeContext,
                lightTheme = LightThemeContext,
                darkTheme = DarkThemeContext
            )
        )
    }.bind(ThemeState::class)

    single { StoreThemeUseCase(get()) }
    single { RestoreThemeUseCase(get()) }
}