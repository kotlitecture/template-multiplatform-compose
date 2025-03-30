## Overview

The API can be accessed through:
- `shared.data.source.config.ConfigSource` - facade interface at the core module level.

Facade **ConfigSource** provides the following methods:

- `<T> get(key: String, encodingStrategy: EncodingStrategy<T>, defaultValue: () -> T): T` - Retrieves the value associated with the specified key from the configuration source.
- `getString(key: String, defaultValue: () -> String): String` - Retrieves string value associated with the specified key from the configuration source.
- `getBoolean(key: String, defaultValue: () -> Boolean): Boolean` - Retrieves boolean value associated with the specified key from the configuration source.
- `getLong(key: String, defaultValue: () -> Long): Long` - Retrieves long value associated with the specified key from the configuration source.
- `getInt(key: String, defaultValue: () -> Int): Int` - Retrieves int value associated with the specified key from the configuration source.
- `getDouble(key: String, defaultValue: () -> Int): Int` - Retrieves double value associated with the specified key from the configuration source.
- `getFloat(key: String, defaultValue: () -> Float): Float` - Retrieves float value associated with the specified key from the configuration source.

## Example

The **facade** is pre-configured via dependency injection (DI) as singletons in `app.common.CommonConfig`.

To start using, just inject it to your DI managed class.

```kotlin
class TemplateViewModel(
    private val configSource: ConfigSource
) : BaseViewModel() {

    private val counter = AtomicInteger(configSource.getInt("counter_initial_value") { 100 })

    ...
}
```