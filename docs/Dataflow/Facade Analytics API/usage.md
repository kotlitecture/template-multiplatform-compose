# Usage

## Overview

The API can be accessed through:
- `shared.data.datasource.analytics.AnalyticsSource` - facade interface at the core module level.
- `app.datasource.analytics.AppAnalyticsSource` - decorator class at the app level.

The difference is that the class serves as a **decorator** and can provide extra methods without impacting facade implementations. 

Facade **AnalyticsSource** provides the following methods:

- `setUserId(id: String?)` - Sets the user ID for tracking all subsequent analytics events.
- `setUserProperty(key: String, value: String?)` - Sets a user property for tracking all subsequent analytics events.
- `onError(event: String, error: Throwable)` - Logs an error event with the specified error.
- `onEvent(event: String, params: Map<String, String>)` - Logs any custom event with optional parameters.
- `onScreenView(screenName: String, params: Map<String, String>)` - Logs a screen view event with optional parameters.

## Example

Both the **facade** and **decorator** are pre-configured via dependency injection (DI) as singletons in `app.di.datasource.ProvidesAnalyticsSource`.

To start using, just inject any of them to your DI managed class. Recommended to use from `ViewModel` or `Repository` level.

```kotlin
class TemplateViewModel (
    private val analyticsSource: AnalyticsSource = instance() // AppAnalyticsSource
) : BaseViewModel() {

    fun onSomeAction() {
        ...
        analyticsSource.onEvent("my_event")
        ...
    }
}
```
