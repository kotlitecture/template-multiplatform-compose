# Usage

## Overview

The data source is available within the class `shared.data.datasource.http.HttpSource`. An instance of this class can be obtained through dependency injection (DI) as a singleton in `app.di.datasource.ProvidesHttpSource`.

The class provides the next functionality:

- `ktor` - pre-configured HTTP client to work with HTTP through **Ktor API**.

## Example

To start using, just inject it to your DI managed class.

```kotlin
class ApiSource(
    private val httpSource: HttpSource = get()
) {

    suspend fun getIp(): String {
        val ktor = httpSource.ktor
        return ktor.get("https://api64.ipify.org").body<String>()
    }

}
```
