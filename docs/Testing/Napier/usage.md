# Usage

## Overview

Library is pre-configured in the `composeApp` module.

## Example

```kotlin
import io.github.aakira.napier.Napier

class Application {

    init { Napier.base(DebugAntilog()) }
    
    @JvmStatic
    fun main(args: Array<String>) {
        Napier.i { "Hello World" }
    }

}
```
