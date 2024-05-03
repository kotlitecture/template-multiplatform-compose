# Usage

## Overview

Component package: `app.ui.theme`

The current theme state is managed by an instance of `shared.core.theme.ThemeState`. This class provides a `configStore` property representing the currently selected theme configuration.

The feature utilizes `AppThemeProvider` to control the value of this property:
- Persist its state whenever it changes.
- Restore the last state when the app is reopened.

The logic is handled by `AppThemePersistenceViewModel`.

Thus, whenever you update the current active application theme, it is automatically saved across app restarts.

```kotlin
class ToggleThemeViewModel(
    private val themeState: ThemeState = instance()
) : BaseViewModel() {

    fun onSetLightTheme() {
        themeState.setLight()
    }

    fun onSetDarkTheme() {
        themeState.setDark()
    }

    fun onSetCustomTheme() {
        themeState.configStore.set(
            ThemeConfig(
                ...
            )
        )
    }
    
    ...

}
```
