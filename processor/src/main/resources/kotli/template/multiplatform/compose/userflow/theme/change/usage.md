## Overview

Component package: `app.feature.theme.change`

## Example

### As a separate screen

Invoke the `ChangeThemeDestination` destination from your **ViewModel** or **View** utilizing the pre-configured **NavigationState**.

```kotlin
class TemplateViewModel(
    private val navigationState: NavigationState = instance()
) : BaseViewModel() {

    fun onChangeTheme() {
        navigationState.onNext(ChangeThemeDestination)
    }

}
```

### As a dialog

Invoke the `ChangeThemeDialogDestination` destination from your **ViewModel** or **View** utilizing the pre-configured **NavigationState**.

```kotlin
class TemplateViewModel(
    private val navigationState: NavigationState = instance()
) : BaseViewModel() {

    fun onChangeTheme() {
        navigationState.onNext(ChangeThemeDialogDestination)
    }

}
```