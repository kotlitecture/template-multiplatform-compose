## Overview

Component package: `app.ui.loader`

The component is pre-configured at the `app.AppScreen` level to monitor state changes of the `app.AppStore` instance.

If you need to modify the behavior, including colors, texts, logic, etc., simply update the `app.ui.loader.LoaderProvider` composable.

## Example

To control the loader state, you need to change the value of `app.AppStore#loadingState`.
By default, this can be achieved through the provided **MVVM** functionality.

### Usage via provided MVVM Framework

Simply inject the `app.AppStore` instance into your **ViewModel** and call the `launchAsync` or `launchMain` method by passing the obtained state instance.

```kotlin
class TemplateViewModel(
    private val appStore: AppStore = get()
) : BaseViewModel() {

    fun onActionWithLoader() {
        launchAsync("onBottom", appStore) {
            delay(1000) // just delay to simulate an action
        }
    }

}
```

### Usage from anywhere

Inject the `app.AppStore` instance into your DI-managed class and modify its loading state to control the visibility of the loader.
However, it is recommended to use it only at the **ViewModel** level.

```kotlin
class DataRepository(
    private val appStore: AppStore = get()
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

### Usage without `app.AppStore`

`app.ui.loader.LoaderProvider` accepts any `StoreState` instance. As this is your code, feel free to use it as needed.