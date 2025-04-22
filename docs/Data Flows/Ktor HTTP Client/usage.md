# Usage

## Overview

- Integration config: `app.common.CommonConfig`
- Data source: `shared.data.source.http.HttpSource`

The class provides the next functionality:

- `client` - pre-configured HTTP client to work with HTTP through **Ktor API**.

## Example

To start using, just inject it to your DI managed class.

```kotlin
class ApiSource(
    private val httpSource: HttpSource
) {

    fun getIp(): String {
        val client = httpSource.client
        return client.get("https://api64.ipify.org").body<String>()
    }

}
```
