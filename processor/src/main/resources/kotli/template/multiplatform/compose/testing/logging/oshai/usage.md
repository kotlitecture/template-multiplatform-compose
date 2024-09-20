## Overview

Library is pre-configured in the `app` module.

## Example

```kotlin
private val logger = KotlinLogging.logger {}

class Application {

    @JvmStatic
    fun main(args: Array<String>) {
        logger.info { "Hello World!" }
    }
}
```