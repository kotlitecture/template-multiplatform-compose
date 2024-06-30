# Usage

## Overview

Component package: `app.presentation.loader`

The component is pre-configured at the `app.presentation.app.AppScreen` level to monitor state changes of the `AppStore` instance.

If you need to modify the behavior, including colors, texts, logic, etc., simply update the `app.presentation.loader.LoaderProvider` composable.

## Example

To control the loader state, you need to change the value of `AppStore#loadingState`.
By default, this can be achieved through the provided **MVVM** functionality.

### Usage via provided MVVM Framework

Simply inject the `AppStore` instance into your **ViewModel** and call the `launchAsync` or `launchMain` method by passing the obtained state instance.

```kotlin
class TemplateViewModel(
    private val appStore: AppStore
) : BaseViewModel() {

    fun onActionWithLoader() {
        launchAsync("onBottom", appStore) {
            delay(1000) // just delay to simulate an action
        }
    }

}
```

### Usage from anywhere

Inject the `AppStore` instance into your DI-managed class and modify its loading state to control the visibility of the loader.
However, it is recommended to use it only at the **ViewModel** level.

```kotlin
class DataRepository(
    private val appStore: AppStore
) {

    fun performSomeAction() {
        val id = "performSomeAction"
        try {
            appStore.loading(id)
            // some action
            appStore.loaded(id)
        } catch (e: Exception) {
            appStore.error(id, e)
        }
    }

}
```

### Usage without `AppStore`

`app.presentation.loader.LoaderProvider` accepts any `Store` instance. As this is your code, feel free to use it as needed.
