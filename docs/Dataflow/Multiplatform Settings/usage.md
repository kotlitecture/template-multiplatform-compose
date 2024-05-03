# Usage

## Overview

The API can be accessed through:
- `shared.data.datasource.keyvalue.KeyValueSource` - facade interface at the core module level.
- `app.datasource.keyvalue.AppKeyValueSource` - decorator class at the app level.

The difference is that the class serves as a **decorator** and can provide extra methods without impacting facade implementations.

Facade **KeyValueSource** provides the following methods:

- `save(key: String, value: T, serializationStrategy: SerializationStrategy<T>): T` - Saves the specified key-value pair.
- `read(key: String, serializationStrategy: SerializationStrategy<T>): T?` - Reads the value associated with the specified key.
- `remove(key: String, serializationStrategy: SerializationStrategy<T>): T?` - Removes the value associated with the specified key.
- `clear()` - Clears all key-value pairs.

Decorator **AppKeyValueSource** also provides the following methods with default serialization strategy applied:

- `read(key: String): T?` - Reads data of type [T] associated with the given [key].
- `save(key: String, value: T)` - Saves the provided [value] of type [T] with the given [key].

## Example

Both the **facade** and **decorator** are pre-configured via dependency injection (DI) as singletons in `app.di.datasource.ProvidesKeyValueSource`.

To start using, just inject it to your DI managed class.

```kotlin
class TemplateViewModel @Inject constructor(
    private val keyValueSource: AppKeyValueSource = instance() // KeyValueSource
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
