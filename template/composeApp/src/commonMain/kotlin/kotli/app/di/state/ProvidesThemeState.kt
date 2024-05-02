package kotli.app.di.state

import shared.core.theme.ThemeConfig
import shared.core.theme.ThemeState
import shared.design.theme.DarkThemeContext
import shared.design.theme.LightThemeContext
import org.koin.dsl.module

val ProvidesThemeState = module {
    single {
        ThemeState(
            defaultConfig = ThemeConfig(
                defaultTheme = LightThemeContext,
                lightTheme = LightThemeContext,
                darkTheme = DarkThemeContext
            )
        )
    }
}