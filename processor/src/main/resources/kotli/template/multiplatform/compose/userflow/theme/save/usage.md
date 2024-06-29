## Overview

Component package: `app.ui.theme`

The current theme state is managed by an instance of `shared.presentation.theme.ThemeStore`. This class provides a `configStore` property representing the currently selected theme configuration.

The feature utilizes `AppThemeProvider` to control the value of this property:
- Persist its state whenever it changes.
- Restore the last state when the app is reopened.

The logic is handled by `AppThemePersistenceViewModel`.

Thus, whenever you update the current active application theme, it is automatically saved across app restarts.

```kotlin
class ToggleThemeViewModel(
    private val themeStore: ThemeStore = get()
) : BaseViewModel() {

    fun onSetLightTheme() {
        themeStore.setLight()
    }

    fun onSetDarkTheme() {
        themeStore.setDark()
    }

    fun onSetCustomTheme() {
        themeStore.configStore.set(
            ThemeConfig(
                ...
            )
        )
    }
    
    ...

}
```