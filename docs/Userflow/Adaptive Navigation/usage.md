# Usage

## Overview

- Component package: `app.presentation.navigation`
- DI integration: `app.di.presentation.NavigationBarModule`
- State management: `app.presentation.navigation.NavigationBarStore`
- Pre-configured sample destinations package: `app.presentation.navigation.samples`

## Configuration

Configure your destinations using `NavigationBarModule`, and if necessary, specify any restricted or allowed destinations which will force navigation to show/hide the navigation bar in some cases.

```kotlin
val navigationBarModule = module {
    single {
        NavigationBarStore(
            pages = listOf(
                createPage(
                    store = get(),
                    destination = NavigationADestination,
                    getActiveIcon = { Icons.Filled.WineBar },
                    getInactiveIcon = { Icons.Outlined.WineBar },
                    getLabel = { "Page 1" }
                ),
                createPage(
                    store = get(),
                    destination = NavigationBDestination,
                    getActiveIcon = { Icons.Filled.LocalDrink },
                    getInactiveIcon = { Icons.Outlined.LocalDrink },
                    getLabel = { "Page 2" }
                ),
                createPage(
                    store = get(),
                    destination = NavigationCDestination,
                    getActiveIcon = { Icons.Filled.Coffee },
                    getInactiveIcon = { Icons.Outlined.Coffee },
                    getLabel = { "Page 3" }
                ),
                ...
            ),
            allowedDestinations = setOf(
            ),
            restrictedDestinations = setOf(
            )
        )
    }
}
```
