## Overview

Library is pre-configured in the `composeApp` module.

## Example

```kotlin
import co.touchlab.kermit.Logger

class Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Logger.i { "Hello World" }
    }

}
```