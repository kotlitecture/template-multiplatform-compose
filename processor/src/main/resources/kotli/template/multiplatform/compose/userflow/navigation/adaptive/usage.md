## Overview

- Component package: `app.feature.navigation`
- DI integration: `app.di.presentation.NavigationBarModule`
- State management: `app.feature.navigation.NavigationBarState`
- Pre-configured destinations package: `app.feature.navigation.samples`


## Configuration

Configure your destinations using `NavigationBarModule`, and if necessary, specify any restricted or allowed destinations which will force navigation to show/hide the navigation bar in some cases.

```kotlin
val navigationBarModule = module {
    single {
        NavigationBarState(
            pages = listOf(
                createPage(
                    navigationState = get(),
                    destination = NavigationADestination,
                    getActiveIcon = { Icons.Filled.WineBar },
                    getInactiveIcon = { Icons.Outlined.WineBar },
                    getLabel = { "Page 1" }
                ),
                createPage(
                    navigationState = get(),
                    destination = NavigationBDestination,
                    getActiveIcon = { Icons.Filled.LocalDrink },
                    getInactiveIcon = { Icons.Outlined.LocalDrink },
                    getLabel = { "Page 2" }
                ),
                createPage(
                    navigationState = get(),
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