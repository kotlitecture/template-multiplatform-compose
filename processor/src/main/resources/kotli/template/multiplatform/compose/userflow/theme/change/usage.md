## Overview

Component package: `app.presentation.theme.change`

## Example

### As a separate screen

Invoke the `ChangeThemeDestination` destination from your **ViewModel** or **View** utilizing the pre-configured **NavigationStore**.

```kotlin
class TemplateViewModel(
    private val navigationStore: NavigationStore
) : BaseViewModel() {

    fun onChangeTheme() {
        navigationStore.onNext(ChangeThemeDestination)
    }

}
```

### As a dialog

Invoke the `ChangeThemeDialogDestination` destination from your **ViewModel** or **View** utilizing the pre-configured **NavigationStore**.

```kotlin
class TemplateViewModel(
    private val navigationStore: NavigationStore
) : BaseViewModel() {

    fun onChangeTheme() {
        navigationStore.onNext(ChangeThemeDialogDestination)
    }

}
```