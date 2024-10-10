## Overview

Component package: `app.presentation.theme`

The current theme state is managed by an instance of `shared.presentation.theme.ThemeState`. This class provides a `configState` property representing the currently selected theme configuration.

The feature utilizes `AppThemeProvider` to control the value of this property:
- Persist its state whenever it changes.
- Restore the last state when the app is reopened.

The logic is handled by `AppThemePersistenceViewModel`.

Thus, whenever you update the current active application theme, it is automatically saved across app restarts.

```kotlin
class ToggleThemeViewModel(
    private val ThemeState: ThemeState
) : BaseViewModel() {

    fun onSetLightTheme() {
        ThemeState.setLight()
    }

    fun onSetDarkTheme() {
        ThemeState.setDark()
    }

    fun onSetCustomTheme() {
        ThemeState.configState.set(
            ThemeConfig(
                ...
            )
        )
    }
    
    ...

}
```