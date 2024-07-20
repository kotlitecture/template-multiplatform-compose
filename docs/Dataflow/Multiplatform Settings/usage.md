# Usage

## Overview

The API can be accessed through:
- `shared.data.source.keyvalue.KeyValueSource` - base class at the core module level.
- `shared.data.source.keyvalue.SettingsKeyValueSource` - implementation of the base class.

**KeyValueSource** provides the following methods:

- `read(key: String): T?` - Reads data of type [T] associated with the given [key].
- `save(key: String, value: T)` - Saves the provided [value] of type [T] with the given [key].
- `read(key: String, serializationStrategy: SerializationStrategy<T>): T?` - Reads the value associated with the specified key.
- `save(key: String, value: T, serializationStrategy: SerializationStrategy<T>): T` - Saves the specified key-value pair.
- `remove(key: String, serializationStrategy: SerializationStrategy<T>): T?` - Removes the value associated with the specified key.
- `clear()` - Clears all key-value pairs.

## Example

Class instance is pre-configured via dependency injection (DI) as a singleton in `app.di.data.KeyValueSourceModule`.

To start using, just inject it to your DI managed class.

```kotlin
class TemplateViewModel @Inject constructor(
    private val keyValueSource: KeyValueSource
) : BaseViewModel() {
    
    override fun doBind() {
        launchAsync("init settings") {
            ...
            val passcode: String? = keyValueSource.read("name")
            ...
        }
    }
}
```
