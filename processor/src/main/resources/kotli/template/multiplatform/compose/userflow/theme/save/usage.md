## Overview

- Component package: `app.feature.theme.provide`
- DI integration: `app.di.feature.ThemeModule`

The current theme state is managed by an instance of `shared.presentation.theme.ThemeState`. This class provides a `currentState` property representing the currently selected theme configuration.

The feature utilizes `app.feature.theme.provide.presentation.ThemeProvider` to control the value of this property:
- Persist its state whenever it changes.
- Restore the last state when the app is reopened.

The logic is handled by `app.feature.theme.provide.presentation.ThemePersistenceViewModel`.

Thus, whenever you update the current active application theme, it is automatically saved across app restarts.

```kotlin
class ToggleThemeViewModel(
    private val themeState: ThemeState
) : BaseViewModel() {

    fun onSetLightTheme() {
        themeState.setLight()
    }

    fun onSetDarkTheme() {
        themeState.setDark()
    }

    fun onSetCustomTheme() {
        themeState.currentConfig = ThemeConfig(
            ...
        )
    }
    ...
}
```