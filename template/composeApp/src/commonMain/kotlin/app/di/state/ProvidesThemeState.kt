package app.di.state

import core.ui.theme.ThemeConfig
import core.ui.theme.ThemeState
import core.ui.theme.material3.Material3Themes
import org.koin.dsl.module

val ProvidesThemeState = module {
    single {
        ThemeState(
            defaultConfig = ThemeConfig(
                defaultTheme = Material3Themes.light(),
                lightTheme = Material3Themes.light(),
                darkTheme = Material3Themes.dark()
            )
        )
    }
}