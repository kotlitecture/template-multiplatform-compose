## Overview

The API can be accessed through:
- `shared.data.source.settings.SettingsSource` - base class at the core module level.
- `shared.data.source.settings.multiplatform.MultiplatformSettingsSource` - implementation of the base class.

**SettingsSource** provides the following methods:

- `read(key: String): T?` - Reads data of type [T] associated with the given [key].
- `save(key: String, value: T)` - Saves the provided [value] of type [T] with the given [key].
- `read(key: String, serializationStrategy: SerializationStrategy<T>): T?` - Reads the value associated with the specified key.
- `save(key: String, value: T, serializationStrategy: SerializationStrategy<T>): T` - Saves the specified key-value pair.
- `remove(key: String, serializationStrategy: SerializationStrategy<T>): T?` - Removes the value associated with the specified key.
- `clear()` - Clears all key-value pairs.

## Example

Class instance is pre-configured via dependency injection (DI) as a singleton in `app.common.CommonConfig`.

To start using, just inject it to your DI managed class.

```kotlin
class TemplateViewModel(
    private val settingsSource: SettingsSource
) : BaseViewModel() {
    
    override fun doBind() = async("Init settings") {
        ...
        val passcode: String? = settingsSource.read("name")
        ...
    }
}
```