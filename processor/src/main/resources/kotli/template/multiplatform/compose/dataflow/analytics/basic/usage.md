## Overview

The API can be accessed through:

- `shared.data.source.analytics.AnalyticsSource` - facade interface at the shared module level.

Facade **AnalyticsSource** provides the following methods:

- `setUserId(id: String?)` - Sets the user ID for tracking all subsequent analytics events.
- `setUserProperty(key: String, value: String?)` - Sets a user property for tracking all subsequent analytics events.
- `onError(event: String, error: Throwable)` - Logs an error event with the specified error.
- `onEvent(event: String, params: Map<String, String>)` - Logs any custom event with optional parameters.
- `onScreenView(screenName: String, params: Map<String, String>)` - Logs a screen view event with optional parameters.

## Example

The **facade** is pre-configured via dependency injection (DI) as singletons in `app.common.CommonConfig`.

To start using, just inject your DI managed class.

```kotlin
class TemplateViewModel(
    private val analyticsSource: AnalyticsSource
) : BaseViewModel() {

    fun onSomeAction() {
        ...
        analyticsSource.onEvent("my_event")
        ...
    }
}
```