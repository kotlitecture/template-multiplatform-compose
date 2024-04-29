package app.di.state

import core.ui.theme.ThemeConfig
import core.ui.theme.ThemeState
import core.ui.theme.material3.DarkThemeContext
import core.ui.theme.material3.LightThemeContext
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